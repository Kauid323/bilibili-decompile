package io.grpc.internal;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import io.grpc.Attributes;
import io.grpc.ClientStreamTracer;
import io.grpc.Compressor;
import io.grpc.Deadline;
import io.grpc.DecompressorRegistry;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import io.grpc.internal.ClientStreamListener;
import io.grpc.internal.StreamListener;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import javax.annotation.CheckForNull;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
public abstract class RetriableStream<ReqT> implements ClientStream {
    private final Executor callExecutor;
    private final long channelBufferLimit;
    private final ChannelBufferMeter channelBufferUsed;
    private final Metadata headers;
    @Nullable
    private final HedgingPolicy hedgingPolicy;
    private final boolean isHedging;
    private ClientStreamListener masterListener;
    private final MethodDescriptor<ReqT, ?> method;
    private long nextBackoffIntervalNanos;
    private final long perRpcBufferLimit;
    private long perRpcBufferUsed;
    @Nullable
    private final RetryPolicy retryPolicy;
    private final ScheduledExecutorService scheduledExecutorService;
    private FutureCanceller scheduledHedging;
    private FutureCanceller scheduledRetry;
    @Nullable
    private final Throttle throttle;
    static final Metadata.Key<String> GRPC_PREVIOUS_RPC_ATTEMPTS = Metadata.Key.of("grpc-previous-rpc-attempts", Metadata.ASCII_STRING_MARSHALLER);
    static final Metadata.Key<String> GRPC_RETRY_PUSHBACK_MS = Metadata.Key.of("grpc-retry-pushback-ms", Metadata.ASCII_STRING_MARSHALLER);
    private static final Status CANCELLED_BECAUSE_COMMITTED = Status.CANCELLED.withDescription("Stream thrown away because RetriableStream committed");
    private static Random random = new Random();
    private final Object lock = new Object();
    private final InsightBuilder closedSubstreamsInsight = new InsightBuilder();
    private volatile State state = new State(new ArrayList(8), Collections.emptyList(), null, null, false, false, false, 0);
    private final AtomicBoolean noMoreTransparentRetry = new AtomicBoolean();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public interface BufferEntry {
        void runWith(Substream substream);
    }

    abstract ClientStream newSubstream(ClientStreamTracer.Factory factory, Metadata metadata);

    abstract void postCommit();

    @CheckReturnValue
    @Nullable
    abstract Status prestart();

    /* JADX INFO: Access modifiers changed from: package-private */
    public RetriableStream(MethodDescriptor<ReqT, ?> method, Metadata headers, ChannelBufferMeter channelBufferUsed, long perRpcBufferLimit, long channelBufferLimit, Executor callExecutor, ScheduledExecutorService scheduledExecutorService, @Nullable RetryPolicy retryPolicy, @Nullable HedgingPolicy hedgingPolicy, @Nullable Throttle throttle) {
        this.method = method;
        this.channelBufferUsed = channelBufferUsed;
        this.perRpcBufferLimit = perRpcBufferLimit;
        this.channelBufferLimit = channelBufferLimit;
        this.callExecutor = callExecutor;
        this.scheduledExecutorService = scheduledExecutorService;
        this.headers = headers;
        this.retryPolicy = retryPolicy;
        if (retryPolicy != null) {
            this.nextBackoffIntervalNanos = retryPolicy.initialBackoffNanos;
        }
        this.hedgingPolicy = hedgingPolicy;
        Preconditions.checkArgument(retryPolicy == null || hedgingPolicy == null, "Should not provide both retryPolicy and hedgingPolicy");
        this.isHedging = hedgingPolicy != null;
        this.throttle = throttle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @CheckReturnValue
    @Nullable
    public Runnable commit(final Substream winningSubstream) {
        Future<?> retryFuture;
        Future<?> hedgingFuture;
        synchronized (this.lock) {
            if (this.state.winningSubstream != null) {
                return null;
            }
            final Collection<Substream> savedDrainedSubstreams = this.state.drainedSubstreams;
            this.state = this.state.committed(winningSubstream);
            this.channelBufferUsed.addAndGet(-this.perRpcBufferUsed);
            if (this.scheduledRetry != null) {
                retryFuture = this.scheduledRetry.markCancelled();
                this.scheduledRetry = null;
            } else {
                retryFuture = null;
            }
            if (this.scheduledHedging != null) {
                Future<?> hedgingFuture2 = this.scheduledHedging.markCancelled();
                this.scheduledHedging = null;
                hedgingFuture = hedgingFuture2;
            } else {
                hedgingFuture = null;
            }
            final Future<?> future = retryFuture;
            final Future<?> future2 = hedgingFuture;
            return new Runnable() { // from class: io.grpc.internal.RetriableStream.1CommitTask
                @Override // java.lang.Runnable
                public void run() {
                    for (Substream substream : savedDrainedSubstreams) {
                        if (substream != winningSubstream) {
                            substream.stream.cancel(RetriableStream.CANCELLED_BECAUSE_COMMITTED);
                        }
                    }
                    if (future != null) {
                        future.cancel(false);
                    }
                    if (future2 != null) {
                        future2.cancel(false);
                    }
                    RetriableStream.this.postCommit();
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void commitAndRun(Substream winningSubstream) {
        Runnable postCommitTask = commit(winningSubstream);
        if (postCommitTask != null) {
            postCommitTask.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Substream createSubstream(int previousAttemptCount) {
        Substream sub = new Substream(previousAttemptCount);
        final ClientStreamTracer bufferSizeTracer = new BufferSizeTracer(sub);
        ClientStreamTracer.Factory tracerFactory = new ClientStreamTracer.Factory() { // from class: io.grpc.internal.RetriableStream.1
            @Override // io.grpc.ClientStreamTracer.Factory
            public ClientStreamTracer newClientStreamTracer(ClientStreamTracer.StreamInfo info, Metadata headers) {
                return bufferSizeTracer;
            }
        };
        Metadata newHeaders = updateHeaders(this.headers, previousAttemptCount);
        sub.stream = newSubstream(tracerFactory, newHeaders);
        return sub;
    }

    final Metadata updateHeaders(Metadata originalHeaders, int previousAttemptCount) {
        Metadata newHeaders = new Metadata();
        newHeaders.merge(originalHeaders);
        if (previousAttemptCount > 0) {
            newHeaders.put(GRPC_PREVIOUS_RPC_ATTEMPTS, String.valueOf(previousAttemptCount));
        }
        return newHeaders;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void drain(Substream substream) {
        int index = 0;
        List<BufferEntry> list = null;
        while (true) {
            synchronized (this.lock) {
                State savedState = this.state;
                if (savedState.winningSubstream == null || savedState.winningSubstream == substream) {
                    if (index == savedState.buffer.size()) {
                        this.state = savedState.substreamDrained(substream);
                        return;
                    } else if (substream.closed) {
                        return;
                    } else {
                        int stop = Math.min(index + 128, savedState.buffer.size());
                        if (list == null) {
                            list = new ArrayList<>(savedState.buffer.subList(index, stop));
                        } else {
                            list.clear();
                            list.addAll(savedState.buffer.subList(index, stop));
                        }
                        index = stop;
                        for (BufferEntry bufferEntry : list) {
                            State savedState2 = this.state;
                            if (savedState2.winningSubstream == null || savedState2.winningSubstream == substream) {
                                if (savedState2.cancelled) {
                                    Preconditions.checkState(savedState2.winningSubstream == substream, "substream should be CANCELLED_BECAUSE_COMMITTED already");
                                    return;
                                }
                                bufferEntry.runWith(substream);
                            }
                        }
                    }
                } else {
                    substream.stream.cancel(CANCELLED_BECAUSE_COMMITTED);
                    return;
                }
            }
        }
    }

    @Override // io.grpc.internal.ClientStream
    public final void start(ClientStreamListener listener) {
        this.masterListener = listener;
        Status shutdownStatus = prestart();
        if (shutdownStatus != null) {
            cancel(shutdownStatus);
            return;
        }
        synchronized (this.lock) {
            this.state.buffer.add(new BufferEntry() { // from class: io.grpc.internal.RetriableStream.1StartEntry
                @Override // io.grpc.internal.RetriableStream.BufferEntry
                public void runWith(Substream substream) {
                    substream.stream.start(new Sublistener(substream));
                }
            });
        }
        Substream substream = createSubstream(0);
        if (this.isHedging) {
            FutureCanceller scheduledHedgingRef = null;
            synchronized (this.lock) {
                this.state = this.state.addActiveHedge(substream);
                if (hasPotentialHedging(this.state) && (this.throttle == null || this.throttle.isAboveThreshold())) {
                    FutureCanceller futureCanceller = new FutureCanceller(this.lock);
                    scheduledHedgingRef = futureCanceller;
                    this.scheduledHedging = futureCanceller;
                }
            }
            if (scheduledHedgingRef != null) {
                scheduledHedgingRef.setFuture(this.scheduledExecutorService.schedule(new HedgingRunnable(scheduledHedgingRef), this.hedgingPolicy.hedgingDelayNanos, TimeUnit.NANOSECONDS));
            }
        }
        drain(substream);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pushbackHedging(@Nullable Integer delayMillis) {
        if (delayMillis == null) {
            return;
        }
        if (delayMillis.intValue() < 0) {
            freezeHedging();
            return;
        }
        synchronized (this.lock) {
            if (this.scheduledHedging == null) {
                return;
            }
            Future<?> futureToBeCancelled = this.scheduledHedging.markCancelled();
            FutureCanceller future = new FutureCanceller(this.lock);
            this.scheduledHedging = future;
            if (futureToBeCancelled != null) {
                futureToBeCancelled.cancel(false);
            }
            future.setFuture(this.scheduledExecutorService.schedule(new HedgingRunnable(future), delayMillis.intValue(), TimeUnit.MILLISECONDS));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public final class HedgingRunnable implements Runnable {
        final FutureCanceller scheduledHedgingRef;

        HedgingRunnable(FutureCanceller scheduledHedging) {
            this.scheduledHedgingRef = scheduledHedging;
        }

        @Override // java.lang.Runnable
        public void run() {
            RetriableStream.this.callExecutor.execute(new Runnable() { // from class: io.grpc.internal.RetriableStream.HedgingRunnable.1
                @Override // java.lang.Runnable
                public void run() {
                    Substream newSubstream = RetriableStream.this.createSubstream(RetriableStream.this.state.hedgingAttemptCount);
                    boolean cancelled = false;
                    FutureCanceller future = null;
                    synchronized (RetriableStream.this.lock) {
                        if (HedgingRunnable.this.scheduledHedgingRef.isCancelled()) {
                            cancelled = true;
                        } else {
                            RetriableStream.this.state = RetriableStream.this.state.addActiveHedge(newSubstream);
                            if (RetriableStream.this.hasPotentialHedging(RetriableStream.this.state) && (RetriableStream.this.throttle == null || RetriableStream.this.throttle.isAboveThreshold())) {
                                RetriableStream retriableStream = RetriableStream.this;
                                FutureCanceller futureCanceller = new FutureCanceller(RetriableStream.this.lock);
                                future = futureCanceller;
                                retriableStream.scheduledHedging = futureCanceller;
                            } else {
                                RetriableStream.this.state = RetriableStream.this.state.freezeHedging();
                                RetriableStream.this.scheduledHedging = null;
                            }
                        }
                    }
                    if (cancelled) {
                        newSubstream.stream.cancel(Status.CANCELLED.withDescription("Unneeded hedging"));
                        return;
                    }
                    if (future != null) {
                        future.setFuture(RetriableStream.this.scheduledExecutorService.schedule(new HedgingRunnable(future), RetriableStream.this.hedgingPolicy.hedgingDelayNanos, TimeUnit.NANOSECONDS));
                    }
                    RetriableStream.this.drain(newSubstream);
                }
            });
        }
    }

    @Override // io.grpc.internal.ClientStream
    public final void cancel(Status reason) {
        Substream noopSubstream = new Substream(0);
        noopSubstream.stream = new NoopClientStream();
        Runnable runnable = commit(noopSubstream);
        if (runnable != null) {
            this.masterListener.closed(reason, new Metadata());
            runnable.run();
            return;
        }
        this.state.winningSubstream.stream.cancel(reason);
        synchronized (this.lock) {
            this.state = this.state.cancelled();
        }
    }

    private void delayOrExecute(BufferEntry bufferEntry) {
        Collection<Substream> savedDrainedSubstreams;
        synchronized (this.lock) {
            if (!this.state.passThrough) {
                this.state.buffer.add(bufferEntry);
            }
            savedDrainedSubstreams = this.state.drainedSubstreams;
        }
        for (Substream substream : savedDrainedSubstreams) {
            bufferEntry.runWith(substream);
        }
    }

    @Override // io.grpc.internal.Stream
    public final void writeMessage(InputStream message) {
        throw new IllegalStateException("RetriableStream.writeMessage() should not be called directly");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void sendMessage(final ReqT message) {
        State savedState = this.state;
        if (savedState.passThrough) {
            savedState.winningSubstream.stream.writeMessage(this.method.streamRequest(message));
        } else {
            delayOrExecute(new BufferEntry() { // from class: io.grpc.internal.RetriableStream.1SendMessageEntry
                /* JADX WARN: Multi-variable type inference failed */
                @Override // io.grpc.internal.RetriableStream.BufferEntry
                public void runWith(Substream substream) {
                    substream.stream.writeMessage(RetriableStream.this.method.streamRequest(message));
                }
            });
        }
    }

    @Override // io.grpc.internal.Stream
    public final void request(final int numMessages) {
        State savedState = this.state;
        if (savedState.passThrough) {
            savedState.winningSubstream.stream.request(numMessages);
        } else {
            delayOrExecute(new BufferEntry() { // from class: io.grpc.internal.RetriableStream.1RequestEntry
                @Override // io.grpc.internal.RetriableStream.BufferEntry
                public void runWith(Substream substream) {
                    substream.stream.request(numMessages);
                }
            });
        }
    }

    @Override // io.grpc.internal.Stream
    public final void flush() {
        State savedState = this.state;
        if (savedState.passThrough) {
            savedState.winningSubstream.stream.flush();
        } else {
            delayOrExecute(new BufferEntry() { // from class: io.grpc.internal.RetriableStream.1FlushEntry
                @Override // io.grpc.internal.RetriableStream.BufferEntry
                public void runWith(Substream substream) {
                    substream.stream.flush();
                }
            });
        }
    }

    @Override // io.grpc.internal.Stream
    public final boolean isReady() {
        for (Substream substream : this.state.drainedSubstreams) {
            if (substream.stream.isReady()) {
                return true;
            }
        }
        return false;
    }

    @Override // io.grpc.internal.Stream
    public void optimizeForDirectExecutor() {
        delayOrExecute(new BufferEntry() { // from class: io.grpc.internal.RetriableStream.1OptimizeDirectEntry
            @Override // io.grpc.internal.RetriableStream.BufferEntry
            public void runWith(Substream substream) {
                substream.stream.optimizeForDirectExecutor();
            }
        });
    }

    @Override // io.grpc.internal.Stream
    public final void setCompressor(final Compressor compressor) {
        delayOrExecute(new BufferEntry() { // from class: io.grpc.internal.RetriableStream.1CompressorEntry
            @Override // io.grpc.internal.RetriableStream.BufferEntry
            public void runWith(Substream substream) {
                substream.stream.setCompressor(compressor);
            }
        });
    }

    @Override // io.grpc.internal.ClientStream
    public final void setFullStreamDecompression(final boolean fullStreamDecompression) {
        delayOrExecute(new BufferEntry() { // from class: io.grpc.internal.RetriableStream.1FullStreamDecompressionEntry
            @Override // io.grpc.internal.RetriableStream.BufferEntry
            public void runWith(Substream substream) {
                substream.stream.setFullStreamDecompression(fullStreamDecompression);
            }
        });
    }

    @Override // io.grpc.internal.Stream
    public final void setMessageCompression(final boolean enable) {
        delayOrExecute(new BufferEntry() { // from class: io.grpc.internal.RetriableStream.1MessageCompressionEntry
            @Override // io.grpc.internal.RetriableStream.BufferEntry
            public void runWith(Substream substream) {
                substream.stream.setMessageCompression(enable);
            }
        });
    }

    @Override // io.grpc.internal.ClientStream
    public final void halfClose() {
        delayOrExecute(new BufferEntry() { // from class: io.grpc.internal.RetriableStream.1HalfCloseEntry
            @Override // io.grpc.internal.RetriableStream.BufferEntry
            public void runWith(Substream substream) {
                substream.stream.halfClose();
            }
        });
    }

    @Override // io.grpc.internal.ClientStream
    public final void setAuthority(final String authority) {
        delayOrExecute(new BufferEntry() { // from class: io.grpc.internal.RetriableStream.1AuthorityEntry
            @Override // io.grpc.internal.RetriableStream.BufferEntry
            public void runWith(Substream substream) {
                substream.stream.setAuthority(authority);
            }
        });
    }

    @Override // io.grpc.internal.ClientStream
    public final void setDecompressorRegistry(final DecompressorRegistry decompressorRegistry) {
        delayOrExecute(new BufferEntry() { // from class: io.grpc.internal.RetriableStream.1DecompressorRegistryEntry
            @Override // io.grpc.internal.RetriableStream.BufferEntry
            public void runWith(Substream substream) {
                substream.stream.setDecompressorRegistry(decompressorRegistry);
            }
        });
    }

    @Override // io.grpc.internal.ClientStream
    public final void setMaxInboundMessageSize(final int maxSize) {
        delayOrExecute(new BufferEntry() { // from class: io.grpc.internal.RetriableStream.1MaxInboundMessageSizeEntry
            @Override // io.grpc.internal.RetriableStream.BufferEntry
            public void runWith(Substream substream) {
                substream.stream.setMaxInboundMessageSize(maxSize);
            }
        });
    }

    @Override // io.grpc.internal.ClientStream
    public final void setMaxOutboundMessageSize(final int maxSize) {
        delayOrExecute(new BufferEntry() { // from class: io.grpc.internal.RetriableStream.1MaxOutboundMessageSizeEntry
            @Override // io.grpc.internal.RetriableStream.BufferEntry
            public void runWith(Substream substream) {
                substream.stream.setMaxOutboundMessageSize(maxSize);
            }
        });
    }

    @Override // io.grpc.internal.ClientStream
    public final void setDeadline(final Deadline deadline) {
        delayOrExecute(new BufferEntry() { // from class: io.grpc.internal.RetriableStream.1DeadlineEntry
            @Override // io.grpc.internal.RetriableStream.BufferEntry
            public void runWith(Substream substream) {
                substream.stream.setDeadline(deadline);
            }
        });
    }

    @Override // io.grpc.internal.ClientStream
    public final Attributes getAttributes() {
        if (this.state.winningSubstream != null) {
            return this.state.winningSubstream.stream.getAttributes();
        }
        return Attributes.EMPTY;
    }

    @Override // io.grpc.internal.ClientStream
    public void appendTimeoutInsight(InsightBuilder insight) {
        State currentState;
        synchronized (this.lock) {
            insight.appendKeyValue("closed", this.closedSubstreamsInsight);
            currentState = this.state;
        }
        if (currentState.winningSubstream != null) {
            InsightBuilder substreamInsight = new InsightBuilder();
            currentState.winningSubstream.stream.appendTimeoutInsight(substreamInsight);
            insight.appendKeyValue("committed", substreamInsight);
            return;
        }
        InsightBuilder openSubstreamsInsight = new InsightBuilder();
        for (Substream sub : currentState.drainedSubstreams) {
            InsightBuilder substreamInsight2 = new InsightBuilder();
            sub.stream.appendTimeoutInsight(substreamInsight2);
            openSubstreamsInsight.append(substreamInsight2);
        }
        insight.appendKeyValue("open", openSubstreamsInsight);
    }

    static void setRandom(Random random2) {
        random = random2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean hasPotentialHedging(State state) {
        return state.winningSubstream == null && state.hedgingAttemptCount < this.hedgingPolicy.maxAttempts && !state.hedgingFrozen;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void freezeHedging() {
        Future<?> futureToBeCancelled = null;
        synchronized (this.lock) {
            if (this.scheduledHedging != null) {
                futureToBeCancelled = this.scheduledHedging.markCancelled();
                this.scheduledHedging = null;
            }
            this.state = this.state.freezeHedging();
        }
        if (futureToBeCancelled != null) {
            futureToBeCancelled.cancel(false);
        }
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    private final class Sublistener implements ClientStreamListener {
        final Substream substream;

        Sublistener(Substream substream) {
            this.substream = substream;
        }

        @Override // io.grpc.internal.ClientStreamListener
        public void headersRead(Metadata headers) {
            RetriableStream.this.commitAndRun(this.substream);
            if (RetriableStream.this.state.winningSubstream == this.substream) {
                RetriableStream.this.masterListener.headersRead(headers);
                if (RetriableStream.this.throttle != null) {
                    RetriableStream.this.throttle.onSuccess();
                }
            }
        }

        @Override // io.grpc.internal.ClientStreamListener
        public void closed(Status status, Metadata trailers) {
            closed(status, ClientStreamListener.RpcProgress.PROCESSED, trailers);
        }

        @Override // io.grpc.internal.ClientStreamListener
        public void closed(Status status, ClientStreamListener.RpcProgress rpcProgress, Metadata trailers) {
            FutureCanceller scheduledRetryCopy;
            synchronized (RetriableStream.this.lock) {
                RetriableStream.this.state = RetriableStream.this.state.substreamClosed(this.substream);
                RetriableStream.this.closedSubstreamsInsight.append(status.getCode());
            }
            if (this.substream.bufferLimitExceeded) {
                RetriableStream.this.commitAndRun(this.substream);
                if (RetriableStream.this.state.winningSubstream == this.substream) {
                    RetriableStream.this.masterListener.closed(status, trailers);
                    return;
                }
                return;
            }
            if (RetriableStream.this.state.winningSubstream == null) {
                if (rpcProgress == ClientStreamListener.RpcProgress.REFUSED && RetriableStream.this.noMoreTransparentRetry.compareAndSet(false, true)) {
                    final Substream newSubstream = RetriableStream.this.createSubstream(this.substream.previousAttemptCount);
                    if (!RetriableStream.this.isHedging) {
                        if (RetriableStream.this.retryPolicy == null || RetriableStream.this.retryPolicy.maxAttempts == 1) {
                            RetriableStream.this.commitAndRun(newSubstream);
                        }
                    } else {
                        boolean commit = false;
                        synchronized (RetriableStream.this.lock) {
                            RetriableStream.this.state = RetriableStream.this.state.replaceActiveHedge(this.substream, newSubstream);
                            if (!RetriableStream.this.hasPotentialHedging(RetriableStream.this.state) && RetriableStream.this.state.activeHedges.size() == 1) {
                                commit = true;
                            }
                        }
                        if (commit) {
                            RetriableStream.this.commitAndRun(newSubstream);
                        }
                    }
                    RetriableStream.this.callExecutor.execute(new Runnable() { // from class: io.grpc.internal.RetriableStream.Sublistener.1
                        @Override // java.lang.Runnable
                        public void run() {
                            RetriableStream.this.drain(newSubstream);
                        }
                    });
                    return;
                } else if (rpcProgress == ClientStreamListener.RpcProgress.DROPPED) {
                    if (RetriableStream.this.isHedging) {
                        RetriableStream.this.freezeHedging();
                    }
                } else {
                    RetriableStream.this.noMoreTransparentRetry.set(true);
                    if (RetriableStream.this.isHedging) {
                        HedgingPlan hedgingPlan = makeHedgingDecision(status, trailers);
                        if (hedgingPlan.isHedgeable) {
                            RetriableStream.this.pushbackHedging(hedgingPlan.hedgingPushbackMillis);
                        }
                        synchronized (RetriableStream.this.lock) {
                            RetriableStream.this.state = RetriableStream.this.state.removeActiveHedge(this.substream);
                            if (hedgingPlan.isHedgeable && (RetriableStream.this.hasPotentialHedging(RetriableStream.this.state) || !RetriableStream.this.state.activeHedges.isEmpty())) {
                                return;
                            }
                        }
                    } else {
                        RetryPlan retryPlan = makeRetryDecision(status, trailers);
                        if (retryPlan.shouldRetry) {
                            synchronized (RetriableStream.this.lock) {
                                RetriableStream retriableStream = RetriableStream.this;
                                scheduledRetryCopy = new FutureCanceller(RetriableStream.this.lock);
                                retriableStream.scheduledRetry = scheduledRetryCopy;
                            }
                            scheduledRetryCopy.setFuture(RetriableStream.this.scheduledExecutorService.schedule(new Runnable() { // from class: io.grpc.internal.RetriableStream.Sublistener.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    RetriableStream.this.callExecutor.execute(new Runnable() { // from class: io.grpc.internal.RetriableStream.Sublistener.2.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            Substream newSubstream2 = RetriableStream.this.createSubstream(Sublistener.this.substream.previousAttemptCount + 1);
                                            RetriableStream.this.drain(newSubstream2);
                                        }
                                    });
                                }
                            }, retryPlan.backoffNanos, TimeUnit.NANOSECONDS));
                            return;
                        }
                    }
                }
            }
            RetriableStream.this.commitAndRun(this.substream);
            if (RetriableStream.this.state.winningSubstream == this.substream) {
                RetriableStream.this.masterListener.closed(status, trailers);
            }
        }

        private RetryPlan makeRetryDecision(Status status, Metadata trailer) {
            if (RetriableStream.this.retryPolicy == null) {
                return new RetryPlan(false, 0L);
            }
            boolean shouldRetry = false;
            long backoffNanos = 0;
            boolean isRetryableStatusCode = RetriableStream.this.retryPolicy.retryableStatusCodes.contains(status.getCode());
            Integer pushbackMillis = getPushbackMills(trailer);
            boolean isThrottled = false;
            if (RetriableStream.this.throttle != null && (isRetryableStatusCode || (pushbackMillis != null && pushbackMillis.intValue() < 0))) {
                isThrottled = !RetriableStream.this.throttle.onQualifiedFailureThenCheckIsAboveThreshold();
            }
            if (RetriableStream.this.retryPolicy.maxAttempts > this.substream.previousAttemptCount + 1 && !isThrottled) {
                if (pushbackMillis == null) {
                    if (isRetryableStatusCode) {
                        shouldRetry = true;
                        backoffNanos = (long) (RetriableStream.this.nextBackoffIntervalNanos * RetriableStream.random.nextDouble());
                        RetriableStream.this.nextBackoffIntervalNanos = Math.min((long) (RetriableStream.this.nextBackoffIntervalNanos * RetriableStream.this.retryPolicy.backoffMultiplier), RetriableStream.this.retryPolicy.maxBackoffNanos);
                    }
                } else if (pushbackMillis.intValue() >= 0) {
                    shouldRetry = true;
                    backoffNanos = TimeUnit.MILLISECONDS.toNanos(pushbackMillis.intValue());
                    RetriableStream.this.nextBackoffIntervalNanos = RetriableStream.this.retryPolicy.initialBackoffNanos;
                }
            }
            return new RetryPlan(shouldRetry, backoffNanos);
        }

        private HedgingPlan makeHedgingDecision(Status status, Metadata trailer) {
            Integer pushbackMillis = getPushbackMills(trailer);
            boolean z = true;
            boolean isFatal = !RetriableStream.this.hedgingPolicy.nonFatalStatusCodes.contains(status.getCode());
            boolean isThrottled = false;
            if (RetriableStream.this.throttle != null && (!isFatal || (pushbackMillis != null && pushbackMillis.intValue() < 0))) {
                isThrottled = !RetriableStream.this.throttle.onQualifiedFailureThenCheckIsAboveThreshold();
            }
            return new HedgingPlan((isFatal || isThrottled) ? false : false, pushbackMillis);
        }

        @Nullable
        private Integer getPushbackMills(Metadata trailer) {
            String pushbackStr = (String) trailer.get(RetriableStream.GRPC_RETRY_PUSHBACK_MS);
            if (pushbackStr == null) {
                return null;
            }
            try {
                Integer pushbackMillis = Integer.valueOf(pushbackStr);
                return pushbackMillis;
            } catch (NumberFormatException e2) {
                return -1;
            }
        }

        @Override // io.grpc.internal.StreamListener
        public void messagesAvailable(StreamListener.MessageProducer producer) {
            State savedState = RetriableStream.this.state;
            Preconditions.checkState(savedState.winningSubstream != null, "Headers should be received prior to messages.");
            if (savedState.winningSubstream == this.substream) {
                RetriableStream.this.masterListener.messagesAvailable(producer);
            }
        }

        @Override // io.grpc.internal.StreamListener
        public void onReady() {
            RetriableStream.this.masterListener.onReady();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class State {
        final Collection<Substream> activeHedges;
        @Nullable
        final List<BufferEntry> buffer;
        final boolean cancelled;
        final Collection<Substream> drainedSubstreams;
        final int hedgingAttemptCount;
        final boolean hedgingFrozen;
        final boolean passThrough;
        @Nullable
        final Substream winningSubstream;

        State(@Nullable List<BufferEntry> buffer, Collection<Substream> drainedSubstreams, Collection<Substream> activeHedges, @Nullable Substream winningSubstream, boolean cancelled, boolean passThrough, boolean hedgingFrozen, int hedgingAttemptCount) {
            this.buffer = buffer;
            this.drainedSubstreams = (Collection) Preconditions.checkNotNull(drainedSubstreams, "drainedSubstreams");
            this.winningSubstream = winningSubstream;
            this.activeHedges = activeHedges;
            this.cancelled = cancelled;
            this.passThrough = passThrough;
            this.hedgingFrozen = hedgingFrozen;
            this.hedgingAttemptCount = hedgingAttemptCount;
            boolean z = false;
            Preconditions.checkState(!passThrough || buffer == null, "passThrough should imply buffer is null");
            Preconditions.checkState((passThrough && winningSubstream == null) ? false : true, "passThrough should imply winningSubstream != null");
            Preconditions.checkState(!passThrough || (drainedSubstreams.size() == 1 && drainedSubstreams.contains(winningSubstream)) || (drainedSubstreams.size() == 0 && winningSubstream.closed), "passThrough should imply winningSubstream is drained");
            Preconditions.checkState((cancelled && winningSubstream == null) ? z : true, "cancelled should imply committed");
        }

        @CheckReturnValue
        State cancelled() {
            return new State(this.buffer, this.drainedSubstreams, this.activeHedges, this.winningSubstream, true, this.passThrough, this.hedgingFrozen, this.hedgingAttemptCount);
        }

        @CheckReturnValue
        State substreamDrained(Substream substream) {
            Collection<Substream> drainedSubstreams;
            List<BufferEntry> buffer;
            Preconditions.checkState(!this.passThrough, "Already passThrough");
            if (substream.closed) {
                drainedSubstreams = this.drainedSubstreams;
            } else if (this.drainedSubstreams.isEmpty()) {
                drainedSubstreams = Collections.singletonList(substream);
            } else {
                Collection<Substream> drainedSubstreams2 = new ArrayList<>(this.drainedSubstreams);
                drainedSubstreams2.add(substream);
                drainedSubstreams = Collections.unmodifiableCollection(drainedSubstreams2);
            }
            boolean passThrough = this.winningSubstream != null;
            List<BufferEntry> buffer2 = this.buffer;
            if (!passThrough) {
                buffer = buffer2;
            } else {
                Preconditions.checkState(this.winningSubstream == substream, "Another RPC attempt has already committed");
                buffer = null;
            }
            return new State(buffer, drainedSubstreams, this.activeHedges, this.winningSubstream, this.cancelled, passThrough, this.hedgingFrozen, this.hedgingAttemptCount);
        }

        @CheckReturnValue
        State substreamClosed(Substream substream) {
            substream.closed = true;
            if (this.drainedSubstreams.contains(substream)) {
                Collection<Substream> drainedSubstreams = new ArrayList<>(this.drainedSubstreams);
                drainedSubstreams.remove(substream);
                return new State(this.buffer, Collections.unmodifiableCollection(drainedSubstreams), this.activeHedges, this.winningSubstream, this.cancelled, this.passThrough, this.hedgingFrozen, this.hedgingAttemptCount);
            }
            return this;
        }

        @CheckReturnValue
        State committed(Substream winningSubstream) {
            Collection<Substream> drainedSubstreams;
            Preconditions.checkState(this.winningSubstream == null, "Already committed");
            boolean passThrough = false;
            List<BufferEntry> buffer = this.buffer;
            if (this.drainedSubstreams.contains(winningSubstream)) {
                passThrough = true;
                buffer = null;
                drainedSubstreams = Collections.singleton(winningSubstream);
            } else {
                drainedSubstreams = Collections.emptyList();
            }
            return new State(buffer, drainedSubstreams, this.activeHedges, winningSubstream, this.cancelled, passThrough, this.hedgingFrozen, this.hedgingAttemptCount);
        }

        @CheckReturnValue
        State freezeHedging() {
            if (this.hedgingFrozen) {
                return this;
            }
            return new State(this.buffer, this.drainedSubstreams, this.activeHedges, this.winningSubstream, this.cancelled, this.passThrough, true, this.hedgingAttemptCount);
        }

        @CheckReturnValue
        State addActiveHedge(Substream substream) {
            Collection<Substream> activeHedges;
            Preconditions.checkState(!this.hedgingFrozen, "hedging frozen");
            Preconditions.checkState(this.winningSubstream == null, "already committed");
            if (this.activeHedges == null) {
                activeHedges = Collections.singleton(substream);
            } else {
                Collection<Substream> activeHedges2 = new ArrayList<>(this.activeHedges);
                activeHedges2.add(substream);
                activeHedges = Collections.unmodifiableCollection(activeHedges2);
            }
            int hedgingAttemptCount = 1 + this.hedgingAttemptCount;
            return new State(this.buffer, this.drainedSubstreams, activeHedges, this.winningSubstream, this.cancelled, this.passThrough, this.hedgingFrozen, hedgingAttemptCount);
        }

        @CheckReturnValue
        State removeActiveHedge(Substream substream) {
            Collection<Substream> activeHedges = new ArrayList<>(this.activeHedges);
            activeHedges.remove(substream);
            return new State(this.buffer, this.drainedSubstreams, Collections.unmodifiableCollection(activeHedges), this.winningSubstream, this.cancelled, this.passThrough, this.hedgingFrozen, this.hedgingAttemptCount);
        }

        @CheckReturnValue
        State replaceActiveHedge(Substream oldOne, Substream newOne) {
            Collection<Substream> activeHedges = new ArrayList<>(this.activeHedges);
            activeHedges.remove(oldOne);
            activeHedges.add(newOne);
            return new State(this.buffer, this.drainedSubstreams, Collections.unmodifiableCollection(activeHedges), this.winningSubstream, this.cancelled, this.passThrough, this.hedgingFrozen, this.hedgingAttemptCount);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Substream {
        boolean bufferLimitExceeded;
        boolean closed;
        final int previousAttemptCount;
        ClientStream stream;

        Substream(int previousAttemptCount) {
            this.previousAttemptCount = previousAttemptCount;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public class BufferSizeTracer extends ClientStreamTracer {
        long bufferNeeded;
        private final Substream substream;

        BufferSizeTracer(Substream substream) {
            this.substream = substream;
        }

        @Override // io.grpc.StreamTracer
        public void outboundWireSize(long bytes) {
            if (RetriableStream.this.state.winningSubstream != null) {
                return;
            }
            Runnable postCommitTask = null;
            synchronized (RetriableStream.this.lock) {
                if (RetriableStream.this.state.winningSubstream == null && !this.substream.closed) {
                    this.bufferNeeded += bytes;
                    if (this.bufferNeeded <= RetriableStream.this.perRpcBufferUsed) {
                        return;
                    }
                    if (this.bufferNeeded <= RetriableStream.this.perRpcBufferLimit) {
                        long savedChannelBufferUsed = RetriableStream.this.channelBufferUsed.addAndGet(this.bufferNeeded - RetriableStream.this.perRpcBufferUsed);
                        RetriableStream.this.perRpcBufferUsed = this.bufferNeeded;
                        if (savedChannelBufferUsed > RetriableStream.this.channelBufferLimit) {
                            this.substream.bufferLimitExceeded = true;
                        }
                    } else {
                        this.substream.bufferLimitExceeded = true;
                    }
                    if (this.substream.bufferLimitExceeded) {
                        postCommitTask = RetriableStream.this.commit(this.substream);
                    }
                    if (postCommitTask != null) {
                        postCommitTask.run();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class ChannelBufferMeter {
        private final AtomicLong bufferUsed = new AtomicLong();

        long addAndGet(long newBytesUsed) {
            return this.bufferUsed.addAndGet(newBytesUsed);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Throttle {
        private static final int THREE_DECIMAL_PLACES_SCALE_UP = 1000;
        final int maxTokens;
        final int threshold;
        final AtomicInteger tokenCount = new AtomicInteger();
        final int tokenRatio;

        /* JADX INFO: Access modifiers changed from: package-private */
        public Throttle(float maxTokens, float tokenRatio) {
            this.tokenRatio = (int) (tokenRatio * 1000.0f);
            this.maxTokens = (int) (1000.0f * maxTokens);
            this.threshold = this.maxTokens / 2;
            this.tokenCount.set(this.maxTokens);
        }

        boolean isAboveThreshold() {
            return this.tokenCount.get() > this.threshold;
        }

        boolean onQualifiedFailureThenCheckIsAboveThreshold() {
            int decremented;
            boolean updated;
            do {
                int currentCount = this.tokenCount.get();
                if (currentCount == 0) {
                    return false;
                }
                decremented = currentCount - 1000;
                updated = this.tokenCount.compareAndSet(currentCount, Math.max(decremented, 0));
            } while (!updated);
            return decremented > this.threshold;
        }

        void onSuccess() {
            boolean updated;
            do {
                int currentCount = this.tokenCount.get();
                if (currentCount != this.maxTokens) {
                    int incremented = this.tokenRatio + currentCount;
                    updated = this.tokenCount.compareAndSet(currentCount, Math.min(incremented, this.maxTokens));
                } else {
                    return;
                }
            } while (!updated);
        }

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o instanceof Throttle) {
                Throttle that = (Throttle) o;
                return this.maxTokens == that.maxTokens && this.tokenRatio == that.tokenRatio;
            }
            return false;
        }

        public int hashCode() {
            return Objects.hashCode(new Object[]{Integer.valueOf(this.maxTokens), Integer.valueOf(this.tokenRatio)});
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class RetryPlan {
        final long backoffNanos;
        final boolean shouldRetry;

        RetryPlan(boolean shouldRetry, long backoffNanos) {
            this.shouldRetry = shouldRetry;
            this.backoffNanos = backoffNanos;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class HedgingPlan {
        @Nullable
        final Integer hedgingPushbackMillis;
        final boolean isHedgeable;

        public HedgingPlan(boolean isHedgeable, @Nullable Integer hedgingPushbackMillis) {
            this.isHedgeable = isHedgeable;
            this.hedgingPushbackMillis = hedgingPushbackMillis;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class FutureCanceller {
        boolean cancelled;
        Future<?> future;
        final Object lock;

        FutureCanceller(Object lock) {
            this.lock = lock;
        }

        void setFuture(Future<?> future) {
            synchronized (this.lock) {
                if (!this.cancelled) {
                    this.future = future;
                }
            }
        }

        @CheckForNull
        Future<?> markCancelled() {
            this.cancelled = true;
            return this.future;
        }

        boolean isCancelled() {
            return this.cancelled;
        }
    }
}