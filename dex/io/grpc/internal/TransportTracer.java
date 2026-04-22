package io.grpc.internal;

import com.google.common.base.Preconditions;
import io.grpc.InternalChannelz;

public final class TransportTracer {
    private static final Factory DEFAULT_FACTORY = new Factory(TimeProvider.SYSTEM_TIME_PROVIDER);
    private FlowControlReader flowControlWindowReader;
    private long keepAlivesSent;
    private long lastLocalStreamCreatedTimeNanos;
    private volatile long lastMessageReceivedTimeNanos;
    private long lastMessageSentTimeNanos;
    private long lastRemoteStreamCreatedTimeNanos;
    private final LongCounter messagesReceived;
    private long messagesSent;
    private long streamsFailed;
    private long streamsStarted;
    private long streamsSucceeded;
    private final TimeProvider timeProvider;

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public interface FlowControlReader {
        FlowControlWindows read();
    }

    public TransportTracer() {
        this.messagesReceived = LongCounterFactory.create();
        this.timeProvider = TimeProvider.SYSTEM_TIME_PROVIDER;
    }

    private TransportTracer(TimeProvider timeProvider) {
        this.messagesReceived = LongCounterFactory.create();
        this.timeProvider = timeProvider;
    }

    public InternalChannelz.TransportStats getStats() {
        long localFlowControlWindow = this.flowControlWindowReader == null ? -1L : this.flowControlWindowReader.read().localBytes;
        long remoteFlowControlWindow = this.flowControlWindowReader != null ? this.flowControlWindowReader.read().remoteBytes : -1L;
        return new InternalChannelz.TransportStats(this.streamsStarted, this.lastLocalStreamCreatedTimeNanos, this.lastRemoteStreamCreatedTimeNanos, this.streamsSucceeded, this.streamsFailed, this.messagesSent, this.messagesReceived.value(), this.keepAlivesSent, this.lastMessageSentTimeNanos, this.lastMessageReceivedTimeNanos, localFlowControlWindow, remoteFlowControlWindow);
    }

    public void reportLocalStreamStarted() {
        this.streamsStarted++;
        this.lastLocalStreamCreatedTimeNanos = this.timeProvider.currentTimeNanos();
    }

    public void reportRemoteStreamStarted() {
        this.streamsStarted++;
        this.lastRemoteStreamCreatedTimeNanos = this.timeProvider.currentTimeNanos();
    }

    public void reportStreamClosed(boolean success) {
        if (success) {
            this.streamsSucceeded++;
        } else {
            this.streamsFailed++;
        }
    }

    public void reportMessageSent(int numMessages) {
        if (numMessages == 0) {
            return;
        }
        this.messagesSent += numMessages;
        this.lastMessageSentTimeNanos = this.timeProvider.currentTimeNanos();
    }

    public void reportMessageReceived() {
        this.messagesReceived.add(1L);
        this.lastMessageReceivedTimeNanos = this.timeProvider.currentTimeNanos();
    }

    public void reportKeepAliveSent() {
        this.keepAlivesSent++;
    }

    public void setFlowControlWindowReader(FlowControlReader flowControlWindowReader) {
        this.flowControlWindowReader = (FlowControlReader) Preconditions.checkNotNull(flowControlWindowReader);
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class FlowControlWindows {
        public final long localBytes;
        public final long remoteBytes;

        public FlowControlWindows(long localBytes, long remoteBytes) {
            this.localBytes = localBytes;
            this.remoteBytes = remoteBytes;
        }
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Factory {
        private final TimeProvider timeProvider;

        public Factory(TimeProvider timeProvider) {
            this.timeProvider = timeProvider;
        }

        public TransportTracer create() {
            return new TransportTracer(this.timeProvider);
        }
    }

    public static Factory getDefaultFactory() {
        return DEFAULT_FACTORY;
    }
}