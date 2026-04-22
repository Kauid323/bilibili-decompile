package io.ktor.websocket;

import com.bilibili.doraemonkit.widget.tableview.bean.Column;
import com.bilibili.droid.thread.BCoreThreadPoolKt;
import io.ktor.util.cio.ByteBufferPoolKt;
import io.ktor.util.cio.ChannelWriteException;
import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.utils.io.ByteWriteChannelOperations_jvmKt;
import io.ktor.utils.io.pool.ObjectPool;
import io.ktor.websocket.Frame;
import java.nio.ByteBuffer;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.ExceptionsKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.SendChannel;

/* compiled from: WebSocketWriter.kt */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u00017B1\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\tH\u0082@¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J \u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\tH\u0082@¢\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0013H\u0086@¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u000eH\u0086@¢\u0006\u0004\b\u001a\u0010\u001bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001cR\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\"\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006¢\u0006\f\n\u0004\b\n\u0010%\u001a\u0004\b&\u0010'R\u001a\u0010*\u001a\b\u0012\u0004\u0012\u00020)0(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0014\u0010-\u001a\u00020,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0017\u00102\u001a\b\u0012\u0004\u0012\u00020\u00130/8F¢\u0006\u0006\u001a\u0004\b0\u00101R\u001a\u00104\u001a\u0002038\u0002X\u0082\u0004¢\u0006\f\n\u0004\b4\u00105\u0012\u0004\b6\u0010\u0012¨\u00068"}, d2 = {"Lio/ktor/websocket/WebSocketWriter;", "Lkotlinx/coroutines/CoroutineScope;", "Lio/ktor/utils/io/ByteWriteChannel;", "writeChannel", "Lkotlin/coroutines/CoroutineContext;", "coroutineContext", Column.INVAL_VALUE, "masking", "Lio/ktor/utils/io/pool/ObjectPool;", "Ljava/nio/ByteBuffer;", "pool", "<init>", "(Lio/ktor/utils/io/ByteWriteChannel;Lkotlin/coroutines/CoroutineContext;ZLio/ktor/utils/io/pool/ObjectPool;)V", "buffer", Column.INVAL_VALUE, "writeLoop", "(Ljava/nio/ByteBuffer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "drainQueueAndDiscard", "()V", "Lio/ktor/websocket/Frame;", "firstMsg", "drainQueueAndSerialize", "(Lio/ktor/websocket/Frame;Ljava/nio/ByteBuffer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "frame", "send", "(Lio/ktor/websocket/Frame;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "flush", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/utils/io/ByteWriteChannel;", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "Z", "getMasking", "()Z", "setMasking", "(Z)V", "Lio/ktor/utils/io/pool/ObjectPool;", "getPool", "()Lio/ktor/utils/io/pool/ObjectPool;", "Lkotlinx/coroutines/channels/Channel;", Column.INVAL_VALUE, BCoreThreadPoolKt.REPORT_WHEN_QUEUE, "Lkotlinx/coroutines/channels/Channel;", "Lio/ktor/websocket/Serializer;", "serializer", "Lio/ktor/websocket/Serializer;", "Lkotlinx/coroutines/channels/SendChannel;", "getOutgoing", "()Lkotlinx/coroutines/channels/SendChannel;", "outgoing", "Lkotlinx/coroutines/Job;", "writeLoopJob", "Lkotlinx/coroutines/Job;", "getWriteLoopJob$annotations", "FlushRequest", "ktor-websockets"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class WebSocketWriter implements CoroutineScope {
    private final CoroutineContext coroutineContext;
    private boolean masking;
    private final ObjectPool<ByteBuffer> pool;
    private final Channel<Object> queue;
    private final Serializer serializer;
    private final ByteWriteChannel writeChannel;
    private final Job writeLoopJob;

    private static /* synthetic */ void getWriteLoopJob$annotations() {
    }

    public WebSocketWriter(ByteWriteChannel writeChannel, CoroutineContext coroutineContext, boolean masking, ObjectPool<ByteBuffer> objectPool) {
        Intrinsics.checkNotNullParameter(writeChannel, "writeChannel");
        Intrinsics.checkNotNullParameter(coroutineContext, "coroutineContext");
        Intrinsics.checkNotNullParameter(objectPool, "pool");
        this.writeChannel = writeChannel;
        this.coroutineContext = coroutineContext;
        this.masking = masking;
        this.pool = objectPool;
        this.queue = ChannelKt.Channel$default(8, (BufferOverflow) null, (Function1) null, 6, (Object) null);
        this.serializer = new Serializer();
        this.writeLoopJob = BuildersKt.launch(this, new CoroutineName("ws-writer"), CoroutineStart.ATOMIC, new WebSocketWriter$writeLoopJob$1(this, null));
    }

    public /* synthetic */ WebSocketWriter(ByteWriteChannel byteWriteChannel, CoroutineContext coroutineContext, boolean z, ObjectPool objectPool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(byteWriteChannel, coroutineContext, (i & 4) != 0 ? false : z, (i & 8) != 0 ? ByteBufferPoolKt.getKtorDefaultPool() : objectPool);
    }

    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    public final boolean getMasking() {
        return this.masking;
    }

    public final void setMasking(boolean z) {
        this.masking = z;
    }

    public final ObjectPool<ByteBuffer> getPool() {
        return this.pool;
    }

    public final SendChannel<Frame> getOutgoing() {
        return this.queue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(7:1|(2:3|(4:5|6|7|8))|79|6|7|8|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x006a, code lost:
        r12 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x006d, code lost:
        r12 = e;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x008d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x009c A[Catch: all -> 0x0116, ChannelWriteException -> 0x011a, TryCatch #6 {ChannelWriteException -> 0x011a, all -> 0x0116, blocks: (B:38:0x00b9, B:30:0x0094, B:32:0x009c, B:34:0x00a5, B:42:0x00c9, B:44:0x00cd, B:45:0x00dc, B:46:0x00f5), top: B:80:0x00b9 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0114 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0142 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0174 A[RETURN] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x00b8 -> B:80:0x00b9). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x00cd -> B:26:0x007e). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object writeLoop(ByteBuffer buffer, Continuation<? super Unit> continuation) {
        WebSocketWriter$writeLoop$1 webSocketWriter$writeLoop$1;
        Object $result;
        WebSocketWriter webSocketWriter;
        ByteWriteChannel byteWriteChannel;
        WebSocketWriter webSocketWriter2;
        ByteWriteChannel byteWriteChannel2;
        ChannelIterator it;
        ChannelIterator channelIterator;
        Object obj;
        Object $result2;
        Object hasNext;
        ByteWriteChannel byteWriteChannel3;
        try {
            if (continuation instanceof WebSocketWriter$writeLoop$1) {
                webSocketWriter$writeLoop$1 = (WebSocketWriter$writeLoop$1) continuation;
                if ((webSocketWriter$writeLoop$1.label & Integer.MIN_VALUE) != 0) {
                    webSocketWriter$writeLoop$1.label -= Integer.MIN_VALUE;
                    Object $result3 = webSocketWriter$writeLoop$1.result;
                    $result = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (webSocketWriter$writeLoop$1.label) {
                        case 0:
                            ResultKt.throwOnFailure($result3);
                            WebSocketWriter webSocketWriter3 = this;
                            buffer.clear();
                            try {
                                it = webSocketWriter3.queue.iterator();
                                webSocketWriter$writeLoop$1.L$0 = webSocketWriter3;
                                webSocketWriter$writeLoop$1.L$1 = buffer;
                                webSocketWriter$writeLoop$1.L$2 = it;
                                webSocketWriter$writeLoop$1.label = 1;
                                hasNext = it.hasNext(webSocketWriter$writeLoop$1);
                            } catch (ChannelWriteException e) {
                                cause = e;
                                webSocketWriter = webSocketWriter3;
                                webSocketWriter.queue.close(ExceptionsKt.CancellationException("Failed to write to WebSocket.", cause));
                                webSocketWriter.queue.close(ExceptionsKt.CancellationException("WebSocket closed.", (Throwable) null));
                                byteWriteChannel2 = webSocketWriter.writeChannel;
                                webSocketWriter$writeLoop$1.L$0 = webSocketWriter;
                                webSocketWriter$writeLoop$1.L$1 = null;
                                webSocketWriter$writeLoop$1.L$2 = null;
                                webSocketWriter$writeLoop$1.label = 4;
                                if (byteWriteChannel2.flushAndClose(webSocketWriter$writeLoop$1) == $result) {
                                    return $result;
                                }
                                webSocketWriter2 = webSocketWriter;
                                webSocketWriter2.drainQueueAndDiscard();
                                return Unit.INSTANCE;
                            } catch (Throwable th) {
                                t = th;
                                webSocketWriter = webSocketWriter3;
                                webSocketWriter.queue.close(t);
                                webSocketWriter.queue.close(ExceptionsKt.CancellationException("WebSocket closed.", (Throwable) null));
                                byteWriteChannel = webSocketWriter.writeChannel;
                                webSocketWriter$writeLoop$1.L$0 = webSocketWriter;
                                webSocketWriter$writeLoop$1.L$1 = null;
                                webSocketWriter$writeLoop$1.L$2 = null;
                                webSocketWriter$writeLoop$1.label = 5;
                                if (byteWriteChannel.flushAndClose(webSocketWriter$writeLoop$1) == $result) {
                                    return $result;
                                }
                                webSocketWriter2 = webSocketWriter;
                                webSocketWriter2.drainQueueAndDiscard();
                                return Unit.INSTANCE;
                            }
                            if (hasNext == $result) {
                                return $result;
                            }
                            Object obj2 = $result;
                            $result2 = $result3;
                            $result3 = hasNext;
                            channelIterator = it;
                            webSocketWriter = webSocketWriter3;
                            obj = obj2;
                            if (((Boolean) $result3).booleanValue()) {
                                webSocketWriter2 = webSocketWriter;
                                webSocketWriter2.queue.close(ExceptionsKt.CancellationException("WebSocket closed.", (Throwable) null));
                                byteWriteChannel3 = webSocketWriter2.writeChannel;
                                webSocketWriter$writeLoop$1.L$0 = webSocketWriter2;
                                webSocketWriter$writeLoop$1.L$1 = null;
                                webSocketWriter$writeLoop$1.L$2 = null;
                                webSocketWriter$writeLoop$1.label = 3;
                                if (byteWriteChannel3.flushAndClose(webSocketWriter$writeLoop$1) == obj) {
                                }
                                webSocketWriter2.drainQueueAndDiscard();
                                return Unit.INSTANCE;
                            }
                            Object message = channelIterator.next();
                            if (message instanceof Frame) {
                                webSocketWriter$writeLoop$1.L$0 = webSocketWriter;
                                webSocketWriter$writeLoop$1.L$1 = buffer;
                                webSocketWriter$writeLoop$1.L$2 = channelIterator;
                                webSocketWriter$writeLoop$1.label = 2;
                                Object drainQueueAndSerialize = webSocketWriter.drainQueueAndSerialize((Frame) message, buffer, webSocketWriter$writeLoop$1);
                                if (drainQueueAndSerialize == obj) {
                                    return obj;
                                }
                                $result3 = drainQueueAndSerialize;
                                try {
                                } catch (ChannelWriteException e2) {
                                    cause = e2;
                                    $result = obj;
                                    webSocketWriter.queue.close(ExceptionsKt.CancellationException("Failed to write to WebSocket.", cause));
                                    webSocketWriter.queue.close(ExceptionsKt.CancellationException("WebSocket closed.", (Throwable) null));
                                    byteWriteChannel2 = webSocketWriter.writeChannel;
                                    webSocketWriter$writeLoop$1.L$0 = webSocketWriter;
                                    webSocketWriter$writeLoop$1.L$1 = null;
                                    webSocketWriter$writeLoop$1.L$2 = null;
                                    webSocketWriter$writeLoop$1.label = 4;
                                    if (byteWriteChannel2.flushAndClose(webSocketWriter$writeLoop$1) == $result) {
                                    }
                                    webSocketWriter2 = webSocketWriter;
                                    webSocketWriter2.drainQueueAndDiscard();
                                    return Unit.INSTANCE;
                                } catch (Throwable th2) {
                                    t = th2;
                                    $result = obj;
                                    webSocketWriter.queue.close(t);
                                    webSocketWriter.queue.close(ExceptionsKt.CancellationException("WebSocket closed.", (Throwable) null));
                                    byteWriteChannel = webSocketWriter.writeChannel;
                                    webSocketWriter$writeLoop$1.L$0 = webSocketWriter;
                                    webSocketWriter$writeLoop$1.L$1 = null;
                                    webSocketWriter$writeLoop$1.L$2 = null;
                                    webSocketWriter$writeLoop$1.label = 5;
                                    if (byteWriteChannel.flushAndClose(webSocketWriter$writeLoop$1) == $result) {
                                    }
                                    webSocketWriter2 = webSocketWriter;
                                    webSocketWriter2.drainQueueAndDiscard();
                                    return Unit.INSTANCE;
                                }
                                if (!((Boolean) $result3).booleanValue()) {
                                    webSocketWriter2 = webSocketWriter;
                                    webSocketWriter2.queue.close(ExceptionsKt.CancellationException("WebSocket closed.", (Throwable) null));
                                    byteWriteChannel3 = webSocketWriter2.writeChannel;
                                    webSocketWriter$writeLoop$1.L$0 = webSocketWriter2;
                                    webSocketWriter$writeLoop$1.L$1 = null;
                                    webSocketWriter$writeLoop$1.L$2 = null;
                                    webSocketWriter$writeLoop$1.label = 3;
                                    if (byteWriteChannel3.flushAndClose(webSocketWriter$writeLoop$1) == obj) {
                                        return obj;
                                    }
                                    webSocketWriter2.drainQueueAndDiscard();
                                    return Unit.INSTANCE;
                                }
                                $result3 = $result2;
                                $result = obj;
                                webSocketWriter3 = webSocketWriter;
                                it = channelIterator;
                                webSocketWriter$writeLoop$1.L$0 = webSocketWriter3;
                                webSocketWriter$writeLoop$1.L$1 = buffer;
                                webSocketWriter$writeLoop$1.L$2 = it;
                                webSocketWriter$writeLoop$1.label = 1;
                                hasNext = it.hasNext(webSocketWriter$writeLoop$1);
                                if (hasNext == $result) {
                                }
                            } else if (!(message instanceof FlushRequest)) {
                                throw new IllegalArgumentException("unknown message " + message);
                            } else {
                                Boxing.boxBoolean(((FlushRequest) message).complete());
                                $result3 = $result2;
                                $result = obj;
                                webSocketWriter3 = webSocketWriter;
                                it = channelIterator;
                                webSocketWriter$writeLoop$1.L$0 = webSocketWriter3;
                                webSocketWriter$writeLoop$1.L$1 = buffer;
                                webSocketWriter$writeLoop$1.L$2 = it;
                                webSocketWriter$writeLoop$1.label = 1;
                                hasNext = it.hasNext(webSocketWriter$writeLoop$1);
                                if (hasNext == $result) {
                                }
                            }
                        case 1:
                            ChannelIterator channelIterator2 = (ChannelIterator) webSocketWriter$writeLoop$1.L$2;
                            ByteBuffer buffer2 = (ByteBuffer) webSocketWriter$writeLoop$1.L$1;
                            webSocketWriter = (WebSocketWriter) webSocketWriter$writeLoop$1.L$0;
                            ResultKt.throwOnFailure($result3);
                            channelIterator = channelIterator2;
                            buffer = buffer2;
                            obj = $result;
                            $result2 = $result3;
                            if (((Boolean) $result3).booleanValue()) {
                            }
                            break;
                        case 2:
                            ChannelIterator channelIterator3 = (ChannelIterator) webSocketWriter$writeLoop$1.L$2;
                            ByteBuffer buffer3 = (ByteBuffer) webSocketWriter$writeLoop$1.L$1;
                            webSocketWriter = (WebSocketWriter) webSocketWriter$writeLoop$1.L$0;
                            ResultKt.throwOnFailure($result3);
                            channelIterator = channelIterator3;
                            buffer = buffer3;
                            obj = $result;
                            $result2 = $result3;
                            if (!((Boolean) $result3).booleanValue()) {
                            }
                            break;
                        case 3:
                        case 4:
                        case 5:
                            webSocketWriter2 = (WebSocketWriter) webSocketWriter$writeLoop$1.L$0;
                            ResultKt.throwOnFailure($result3);
                            webSocketWriter2.drainQueueAndDiscard();
                            return Unit.INSTANCE;
                        case 6:
                            Throwable th3 = (Throwable) webSocketWriter$writeLoop$1.L$0;
                            ResultKt.throwOnFailure($result3);
                            throw th3;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }
            }
            switch (webSocketWriter$writeLoop$1.label) {
            }
        } catch (Throwable th4) {
            webSocketWriter.queue.close(ExceptionsKt.CancellationException("WebSocket closed.", (Throwable) null));
            ByteWriteChannel byteWriteChannel4 = webSocketWriter.writeChannel;
            webSocketWriter$writeLoop$1.L$0 = th4;
            webSocketWriter$writeLoop$1.L$1 = null;
            webSocketWriter$writeLoop$1.L$2 = null;
            webSocketWriter$writeLoop$1.label = 6;
            if (byteWriteChannel4.flushAndClose(webSocketWriter$writeLoop$1) == $result) {
                return $result;
            }
            throw th4;
        }
        webSocketWriter$writeLoop$1 = new WebSocketWriter$writeLoop$1(this, continuation);
        Object $result32 = webSocketWriter$writeLoop$1.result;
        $result = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0052, code lost:
        throw new java.lang.IllegalArgumentException("unknown message " + r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void drainQueueAndDiscard() {
        SendChannel.DefaultImpls.close$default(this.queue, (Throwable) null, 1, (Object) null);
        while (true) {
            try {
                Object message = ChannelResult.getOrNull-impl(this.queue.tryReceive-PtdJZtk());
                if (message != null) {
                    if (!(message instanceof Frame.Close) && !(message instanceof Frame.Ping) && !(message instanceof Frame.Pong)) {
                        if (!(message instanceof FlushRequest)) {
                            if (!(message instanceof Frame.Text) && !(message instanceof Frame.Binary)) {
                                break;
                            }
                        } else {
                            ((FlushRequest) message).complete();
                        }
                    }
                } else {
                    return;
                }
            } catch (CancellationException e) {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00d3, code lost:
        kotlinx.coroutines.channels.SendChannel.DefaultImpls.close$default(r3.queue, (java.lang.Throwable) null, 1, (java.lang.Object) null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0180, code lost:
        if (r13.hasRemaining() != false) goto L65;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0139 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x017a A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x009c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0099 A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r12v10 */
    /* JADX WARN: Type inference failed for: r12v11, types: [int] */
    /* JADX WARN: Type inference failed for: r12v12 */
    /* JADX WARN: Type inference failed for: r12v14 */
    /* JADX WARN: Type inference failed for: r12v26 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:67:0x0166 -> B:69:0x0169). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:70:0x0173 -> B:71:0x0176). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object drainQueueAndSerialize(Frame firstMsg, ByteBuffer buffer, Continuation<? super Boolean> continuation) {
        WebSocketWriter$drainQueueAndSerialize$1 webSocketWriter$drainQueueAndSerialize$1;
        WebSocketWriter webSocketWriter;
        Ref.ObjectRef flush;
        ByteBuffer buffer2;
        WebSocketWriter webSocketWriter2;
        int i;
        int closeSent;
        FlushRequest flushRequest;
        FlushRequest it;
        int i2;
        Ref.ObjectRef flush2;
        Object message;
        int i3;
        FlushRequest flushRequest2;
        if (continuation instanceof WebSocketWriter$drainQueueAndSerialize$1) {
            webSocketWriter$drainQueueAndSerialize$1 = (WebSocketWriter$drainQueueAndSerialize$1) continuation;
            if ((webSocketWriter$drainQueueAndSerialize$1.label & Integer.MIN_VALUE) != 0) {
                webSocketWriter$drainQueueAndSerialize$1.label -= Integer.MIN_VALUE;
                Object $result = webSocketWriter$drainQueueAndSerialize$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (webSocketWriter$drainQueueAndSerialize$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        webSocketWriter = this;
                        flush = new Ref.ObjectRef();
                        webSocketWriter.serializer.enqueue(firstMsg);
                        boolean closeSent2 = firstMsg instanceof Frame.Close;
                        ?? r12 = closeSent2;
                        while (flush.element == null && r12 == 0 && webSocketWriter.serializer.getRemainingCapacity() > 0 && (message = ChannelResult.getOrNull-impl(webSocketWriter.queue.tryReceive-PtdJZtk())) != null) {
                            if (!(message instanceof FlushRequest)) {
                                flush.element = message;
                            } else if (message instanceof Frame.Close) {
                                webSocketWriter.serializer.enqueue((Frame) message);
                                r12 = 1;
                            } else if (!(message instanceof Frame)) {
                                throw new IllegalArgumentException("unknown message " + message);
                            } else {
                                webSocketWriter.serializer.enqueue((Frame) message);
                            }
                        }
                        if (webSocketWriter.serializer.getHasOutstandingBytes() && buffer.position() == 0) {
                            ByteWriteChannel byteWriteChannel = webSocketWriter.writeChannel;
                            webSocketWriter$drainQueueAndSerialize$1.L$0 = flush;
                            webSocketWriter$drainQueueAndSerialize$1.L$1 = null;
                            webSocketWriter$drainQueueAndSerialize$1.L$2 = null;
                            webSocketWriter$drainQueueAndSerialize$1.L$3 = null;
                            webSocketWriter$drainQueueAndSerialize$1.I$0 = r12;
                            webSocketWriter$drainQueueAndSerialize$1.label = 3;
                            if (byteWriteChannel.flush(webSocketWriter$drainQueueAndSerialize$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            flush2 = flush;
                            i3 = r12;
                            flushRequest2 = (FlushRequest) flush2.element;
                            if (flushRequest2 != null) {
                                Boxing.boxBoolean(flushRequest2.complete());
                            }
                            return Boxing.boxBoolean(i3 != 0);
                        }
                        webSocketWriter.serializer.setMasking(webSocketWriter.masking);
                        webSocketWriter.serializer.serialize(buffer);
                        buffer.flip();
                        i2 = r12;
                        ByteWriteChannel byteWriteChannel2 = webSocketWriter.writeChannel;
                        webSocketWriter$drainQueueAndSerialize$1.L$0 = webSocketWriter;
                        webSocketWriter$drainQueueAndSerialize$1.L$1 = buffer;
                        webSocketWriter$drainQueueAndSerialize$1.L$2 = flush;
                        webSocketWriter$drainQueueAndSerialize$1.L$3 = null;
                        webSocketWriter$drainQueueAndSerialize$1.I$0 = i2;
                        webSocketWriter$drainQueueAndSerialize$1.label = 1;
                        if (ByteWriteChannelOperations_jvmKt.writeFully(byteWriteChannel2, buffer, webSocketWriter$drainQueueAndSerialize$1) != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        buffer2 = buffer;
                        webSocketWriter2 = webSocketWriter;
                        i = i2;
                        if (!webSocketWriter2.serializer.getHasOutstandingBytes() || buffer2.hasRemaining() || (flushRequest = (FlushRequest) flush.element) == null) {
                            closeSent = i;
                            buffer = buffer2;
                            webSocketWriter = webSocketWriter2;
                            if (flush.element == null || closeSent) {
                                i2 = closeSent;
                                break;
                            }
                            buffer.compact();
                            closeSent2 = closeSent;
                            ?? r122 = closeSent2;
                            while (flush.element == null) {
                                if (!(message instanceof FlushRequest)) {
                                }
                            }
                            if (webSocketWriter.serializer.getHasOutstandingBytes()) {
                            }
                            webSocketWriter.serializer.setMasking(webSocketWriter.masking);
                            webSocketWriter.serializer.serialize(buffer);
                            buffer.flip();
                            i2 = r122;
                            ByteWriteChannel byteWriteChannel22 = webSocketWriter.writeChannel;
                            webSocketWriter$drainQueueAndSerialize$1.L$0 = webSocketWriter;
                            webSocketWriter$drainQueueAndSerialize$1.L$1 = buffer;
                            webSocketWriter$drainQueueAndSerialize$1.L$2 = flush;
                            webSocketWriter$drainQueueAndSerialize$1.L$3 = null;
                            webSocketWriter$drainQueueAndSerialize$1.I$0 = i2;
                            webSocketWriter$drainQueueAndSerialize$1.label = 1;
                            if (ByteWriteChannelOperations_jvmKt.writeFully(byteWriteChannel22, buffer, webSocketWriter$drainQueueAndSerialize$1) != coroutine_suspended) {
                            }
                        } else {
                            it = flushRequest;
                            ByteWriteChannel byteWriteChannel3 = webSocketWriter2.writeChannel;
                            webSocketWriter$drainQueueAndSerialize$1.L$0 = webSocketWriter2;
                            webSocketWriter$drainQueueAndSerialize$1.L$1 = buffer2;
                            webSocketWriter$drainQueueAndSerialize$1.L$2 = flush;
                            webSocketWriter$drainQueueAndSerialize$1.L$3 = it;
                            webSocketWriter$drainQueueAndSerialize$1.I$0 = i;
                            webSocketWriter$drainQueueAndSerialize$1.label = 2;
                            if (byteWriteChannel3.flush(webSocketWriter$drainQueueAndSerialize$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            it.complete();
                            flush.element = null;
                            closeSent = i;
                            buffer = buffer2;
                            webSocketWriter = webSocketWriter2;
                            if (flush.element == null) {
                            }
                            i2 = closeSent;
                        }
                        break;
                    case 1:
                        int i4 = webSocketWriter$drainQueueAndSerialize$1.I$0;
                        Ref.ObjectRef flush3 = (Ref.ObjectRef) webSocketWriter$drainQueueAndSerialize$1.L$2;
                        ByteBuffer buffer3 = (ByteBuffer) webSocketWriter$drainQueueAndSerialize$1.L$1;
                        ResultKt.throwOnFailure($result);
                        buffer2 = buffer3;
                        webSocketWriter2 = (WebSocketWriter) webSocketWriter$drainQueueAndSerialize$1.L$0;
                        flush = flush3;
                        i = i4;
                        if (webSocketWriter2.serializer.getHasOutstandingBytes()) {
                            break;
                        }
                        closeSent = i;
                        buffer = buffer2;
                        webSocketWriter = webSocketWriter2;
                        if (flush.element == null) {
                        }
                        i2 = closeSent;
                        break;
                    case 2:
                        i = webSocketWriter$drainQueueAndSerialize$1.I$0;
                        it = (FlushRequest) webSocketWriter$drainQueueAndSerialize$1.L$3;
                        flush = (Ref.ObjectRef) webSocketWriter$drainQueueAndSerialize$1.L$2;
                        buffer2 = (ByteBuffer) webSocketWriter$drainQueueAndSerialize$1.L$1;
                        webSocketWriter2 = (WebSocketWriter) webSocketWriter$drainQueueAndSerialize$1.L$0;
                        ResultKt.throwOnFailure($result);
                        it.complete();
                        flush.element = null;
                        closeSent = i;
                        buffer = buffer2;
                        webSocketWriter = webSocketWriter2;
                        if (flush.element == null) {
                        }
                        i2 = closeSent;
                        break;
                    case 3:
                        int i5 = webSocketWriter$drainQueueAndSerialize$1.I$0;
                        flush2 = (Ref.ObjectRef) webSocketWriter$drainQueueAndSerialize$1.L$0;
                        ResultKt.throwOnFailure($result);
                        i3 = i5;
                        flushRequest2 = (FlushRequest) flush2.element;
                        if (flushRequest2 != null) {
                        }
                        return Boxing.boxBoolean(i3 != 0);
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        webSocketWriter$drainQueueAndSerialize$1 = new WebSocketWriter$drainQueueAndSerialize$1(this, continuation);
        Object $result2 = webSocketWriter$drainQueueAndSerialize$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (webSocketWriter$drainQueueAndSerialize$1.label) {
        }
    }

    public final Object send(Frame frame, Continuation<? super Unit> continuation) {
        Object send = this.queue.send(frame, continuation);
        return send == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? send : Unit.INSTANCE;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(7:1|(2:3|(4:5|6|7|8))|36|6|7|8|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0079, code lost:
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x007a, code lost:
        r5.complete();
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x007d, code lost:
        throw r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x007f, code lost:
        r5.complete();
        r5 = r7.writeLoopJob;
        r0.L$0 = r6;
        r0.L$1 = null;
        r0.L$2 = null;
        r0.label = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0091, code lost:
        if (r5.join(r0) == r2) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0093, code lost:
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0094, code lost:
        r5 = r6;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a7 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object flush(Continuation<? super Unit> continuation) {
        WebSocketWriter$flush$1 webSocketWriter$flush$1;
        FlushRequest flushRequest;
        WebSocketWriter webSocketWriter;
        FlushRequest it;
        if (continuation instanceof WebSocketWriter$flush$1) {
            webSocketWriter$flush$1 = (WebSocketWriter$flush$1) continuation;
            if ((webSocketWriter$flush$1.label & Integer.MIN_VALUE) != 0) {
                webSocketWriter$flush$1.label -= Integer.MIN_VALUE;
                Object $result = webSocketWriter$flush$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (webSocketWriter$flush$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        webSocketWriter = this;
                        flushRequest = new FlushRequest(webSocketWriter.getCoroutineContext().get(Job.Key));
                        it = flushRequest;
                        Channel<Object> channel = webSocketWriter.queue;
                        webSocketWriter$flush$1.L$0 = webSocketWriter;
                        webSocketWriter$flush$1.L$1 = flushRequest;
                        webSocketWriter$flush$1.L$2 = it;
                        webSocketWriter$flush$1.label = 1;
                        if (channel.send(it, webSocketWriter$flush$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        webSocketWriter$flush$1.L$0 = null;
                        webSocketWriter$flush$1.L$1 = null;
                        webSocketWriter$flush$1.L$2 = null;
                        webSocketWriter$flush$1.label = 3;
                        if (flushRequest.await(webSocketWriter$flush$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    case 1:
                        it = (FlushRequest) webSocketWriter$flush$1.L$2;
                        flushRequest = (FlushRequest) webSocketWriter$flush$1.L$1;
                        webSocketWriter = (WebSocketWriter) webSocketWriter$flush$1.L$0;
                        ResultKt.throwOnFailure($result);
                        webSocketWriter$flush$1.L$0 = null;
                        webSocketWriter$flush$1.L$1 = null;
                        webSocketWriter$flush$1.L$2 = null;
                        webSocketWriter$flush$1.label = 3;
                        if (flushRequest.await(webSocketWriter$flush$1) == coroutine_suspended) {
                        }
                        return Unit.INSTANCE;
                    case 2:
                        FlushRequest flushRequest2 = (FlushRequest) webSocketWriter$flush$1.L$0;
                        ResultKt.throwOnFailure($result);
                        flushRequest = flushRequest2;
                        webSocketWriter$flush$1.L$0 = null;
                        webSocketWriter$flush$1.L$1 = null;
                        webSocketWriter$flush$1.L$2 = null;
                        webSocketWriter$flush$1.label = 3;
                        if (flushRequest.await(webSocketWriter$flush$1) == coroutine_suspended) {
                        }
                        return Unit.INSTANCE;
                    case 3:
                        ResultKt.throwOnFailure($result);
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        webSocketWriter$flush$1 = new WebSocketWriter$flush$1(this, continuation);
        Object $result2 = webSocketWriter$flush$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (webSocketWriter$flush$1.label) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: WebSocketWriter.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tH\u0086@¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lio/ktor/websocket/WebSocketWriter$FlushRequest;", Column.INVAL_VALUE, "Lkotlinx/coroutines/Job;", "parent", "<init>", "(Lkotlinx/coroutines/Job;)V", Column.INVAL_VALUE, "complete", "()Z", Column.INVAL_VALUE, "await", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/CompletableJob;", "done", "Lkotlinx/coroutines/CompletableJob;", "ktor-websockets"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602230606352175db5d-4dcb-42b5-ae97-9aefdbbfec86/202602230606352175db5d-4dcb-42b5-ae97-9aefdbbfec86.dex */
    public static final class FlushRequest {
        private final CompletableJob done;

        public FlushRequest(Job parent) {
            this.done = JobKt.Job(parent);
        }

        public final boolean complete() {
            return this.done.complete();
        }

        public final Object await(Continuation<? super Unit> continuation) {
            Object join = this.done.join(continuation);
            return join == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? join : Unit.INSTANCE;
        }
    }
}