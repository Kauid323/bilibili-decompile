package io.ktor.websocket;

import com.bilibili.doraemonkit.widget.tableview.bean.Column;
import com.bilibili.gripper.api.ad.core.report.UIExtraParams;
import com.bilibili.upper.comm.report.UpperReportConstants;
import io.ktor.util.logging.LoggerJvmKt;
import io.ktor.utils.io.core.BytePacketBuilderKt;
import io.ktor.websocket.CloseReason;
import io.ktor.websocket.DefaultWebSocketSession;
import io.ktor.websocket.Frame;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.io.Sink;
import org.slf4j.Logger;

/* compiled from: DefaultWebSocketSession.kt */
@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 e2\u00020\u00012\u00020\u0002:\u0001eB\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\r\u001a\u00020\f2\u0010\u0010\u000b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\f2\b\b\u0002\u0010\u0010\u001a\u00020\u000fH\u0086@¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\fH\u0096@¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\fH\u0017¢\u0006\u0004\b\u0015\u0010\u0016J\u001d\u0010\u001b\u001a\u00020\u001a2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\fH\u0082@¢\u0006\u0004\b\u001f\u0010\u0014J&\u0010$\u001a\u00020\f2\b\u0010!\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\"H\u0082@¢\u0006\u0004\b$\u0010%J\u000f\u0010'\u001a\u00020&H\u0002¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020\fH\u0002¢\u0006\u0004\b)\u0010\u0016J\"\u0010.\u001a\u00020\f2\b\u0010+\u001a\u0004\u0018\u00010*2\u0006\u0010-\u001a\u00020,H\u0082@¢\u0006\u0004\b.\u0010/J\u0017\u00100\u001a\u00020,2\u0006\u0010-\u001a\u00020,H\u0002¢\u0006\u0004\b0\u00101J\u0017\u00102\u001a\u00020,2\u0006\u0010-\u001a\u00020,H\u0002¢\u0006\u0004\b2\u00101R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u00103R\u001a\u00105\u001a\b\u0012\u0004\u0012\u00020 048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u001a\u00108\u001a\b\u0012\u0004\u0012\u00020,078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00109R\u001a\u0010:\u001a\b\u0012\u0004\u0012\u00020,078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u00109R\u0014\u0010<\u001a\u00020;8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u0010=R\u001e\u0010?\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0>8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u0010@R\u001a\u0010D\u001a\b\u0012\u0004\u0012\u00020,0A8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bB\u0010CR\u001a\u0010G\u001a\b\u0012\u0004\u0012\u00020,0\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bE\u0010FR\u001e\u0010J\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bH\u0010IR\u001a\u0010L\u001a\u00020K8\u0016X\u0096\u0004¢\u0006\f\n\u0004\bL\u0010M\u001a\u0004\bN\u0010OR$\u0010T\u001a\u00020&2\u0006\u0010P\u001a\u00020&8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bQ\u0010(\"\u0004\bR\u0010SR$\u0010Y\u001a\u00020\u00042\u0006\u0010P\u001a\u00020\u00048V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR*\u0010\u0005\u001a\u00020\u00042\u0006\u0010Z\u001a\u00020\u00048\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010[\u001a\u0004\b\\\u0010V\"\u0004\b]\u0010XR*\u0010\u0006\u001a\u00020\u00042\u0006\u0010Z\u001a\u00020\u00048\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010[\u001a\u0004\b^\u0010V\"\u0004\b_\u0010XR\"\u0010a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010 0`8\u0016X\u0096\u0004¢\u0006\f\n\u0004\ba\u0010b\u001a\u0004\bc\u0010d¨\u0006f"}, d2 = {"Lio/ktor/websocket/DefaultWebSocketSessionImpl;", "Lio/ktor/websocket/DefaultWebSocketSession;", "Lio/ktor/websocket/WebSocketSession;", "raw", Column.INVAL_VALUE, "pingIntervalMillis", "timeoutMillis", "<init>", "(Lio/ktor/websocket/WebSocketSession;JJ)V", Column.INVAL_VALUE, "Lio/ktor/websocket/WebSocketExtension;", "negotiatedExtensions", Column.INVAL_VALUE, UpperReportConstants.PUBLISH_STEP_START, "(Ljava/util/List;)V", Column.INVAL_VALUE, "message", "goingAway", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "flush", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "terminate", "()V", "Lkotlinx/coroutines/channels/SendChannel;", "Lio/ktor/websocket/Frame$Ping;", "ponger", "Lkotlinx/coroutines/Job;", "runIncomingProcessor", "(Lkotlinx/coroutines/channels/SendChannel;)Lkotlinx/coroutines/Job;", "runOutgoingProcessor", "()Lkotlinx/coroutines/Job;", "outgoingProcessorLoop", "Lio/ktor/websocket/CloseReason;", UIExtraParams.REASON, Column.INVAL_VALUE, "exception", "sendCloseSequence", "(Lio/ktor/websocket/CloseReason;Ljava/lang/Throwable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", Column.INVAL_VALUE, "tryClose", "()Z", "runOrCancelPinger", "Lkotlinx/io/Sink;", "packet", "Lio/ktor/websocket/Frame;", "frame", "checkMaxFrameSize", "(Lkotlinx/io/Sink;Lio/ktor/websocket/Frame;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processIncomingExtensions", "(Lio/ktor/websocket/Frame;)Lio/ktor/websocket/Frame;", "processOutgoingExtensions", "Lio/ktor/websocket/WebSocketSession;", "Lkotlinx/coroutines/CompletableDeferred;", "closeReasonRef", "Lkotlinx/coroutines/CompletableDeferred;", "Lkotlinx/coroutines/channels/Channel;", "filtered", "Lkotlinx/coroutines/channels/Channel;", "outgoingToBeProcessed", "Lkotlinx/coroutines/CompletableJob;", "context", "Lkotlinx/coroutines/CompletableJob;", Column.INVAL_VALUE, "_extensions", "Ljava/util/List;", "Lkotlinx/coroutines/channels/ReceiveChannel;", "getIncoming", "()Lkotlinx/coroutines/channels/ReceiveChannel;", "incoming", "getOutgoing", "()Lkotlinx/coroutines/channels/SendChannel;", "outgoing", "getExtensions", "()Ljava/util/List;", "extensions", "Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "value", "getMasking", "setMasking", "(Z)V", "masking", "getMaxFrameSize", "()J", "setMaxFrameSize", "(J)V", "maxFrameSize", "newValue", "J", "getPingIntervalMillis", "setPingIntervalMillis", "getTimeoutMillis", "setTimeoutMillis", "Lkotlinx/coroutines/Deferred;", "closeReason", "Lkotlinx/coroutines/Deferred;", "getCloseReason", "()Lkotlinx/coroutines/Deferred;", "Companion", "ktor-websockets"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DefaultWebSocketSessionImpl implements DefaultWebSocketSession, WebSocketSession {
    private final List<WebSocketExtension<?>> _extensions;
    private final Deferred<CloseReason> closeReason;
    private final CompletableDeferred<CloseReason> closeReasonRef;
    private volatile /* synthetic */ int closed;
    private final CompletableJob context;
    private final CoroutineContext coroutineContext;
    private final Channel<Frame> filtered;
    private final Channel<Frame> outgoingToBeProcessed;
    private long pingIntervalMillis;
    volatile /* synthetic */ Object pinger;
    private final WebSocketSession raw;
    private volatile /* synthetic */ int started;
    private long timeoutMillis;
    public static final Companion Companion = new Companion(null);
    private static final Frame.Pong EmptyPong = new Frame.Pong(new byte[0], NonDisposableHandle.INSTANCE);
    static final /* synthetic */ AtomicReferenceFieldUpdater pinger$FU = AtomicReferenceFieldUpdater.newUpdater(DefaultWebSocketSessionImpl.class, Object.class, "pinger");
    private static final /* synthetic */ AtomicIntegerFieldUpdater closed$FU = AtomicIntegerFieldUpdater.newUpdater(DefaultWebSocketSessionImpl.class, "closed");
    private static final /* synthetic */ AtomicIntegerFieldUpdater started$FU = AtomicIntegerFieldUpdater.newUpdater(DefaultWebSocketSessionImpl.class, "started");

    public DefaultWebSocketSessionImpl(WebSocketSession raw, long pingIntervalMillis, long timeoutMillis) {
        Intrinsics.checkNotNullParameter(raw, "raw");
        this.raw = raw;
        this.pinger = null;
        this.closeReasonRef = CompletableDeferredKt.CompletableDeferred$default((Job) null, 1, (Object) null);
        this.filtered = ChannelKt.Channel$default(8, (BufferOverflow) null, (Function1) null, 6, (Object) null);
        this.outgoingToBeProcessed = ChannelKt.Channel$default(UtilsKt.getOUTGOING_CHANNEL_CAPACITY(), (BufferOverflow) null, (Function1) null, 6, (Object) null);
        this.closed = 0;
        this.context = JobKt.Job(this.raw.getCoroutineContext().get(Job.Key));
        this._extensions = new ArrayList();
        this.started = 0;
        this.coroutineContext = this.raw.getCoroutineContext().plus(this.context).plus(new CoroutineName("ws-default"));
        this.pingIntervalMillis = pingIntervalMillis;
        this.timeoutMillis = timeoutMillis;
        this.closeReason = this.closeReasonRef;
    }

    @Override // io.ktor.websocket.WebSocketSession
    public Object send(Frame frame, Continuation<? super Unit> continuation) {
        return DefaultWebSocketSession.DefaultImpls.send(this, frame, continuation);
    }

    @Override // io.ktor.websocket.WebSocketSession
    public ReceiveChannel<Frame> getIncoming() {
        return this.filtered;
    }

    @Override // io.ktor.websocket.WebSocketSession
    public SendChannel<Frame> getOutgoing() {
        return this.outgoingToBeProcessed;
    }

    @Override // io.ktor.websocket.WebSocketSession
    public List<WebSocketExtension<?>> getExtensions() {
        return this._extensions;
    }

    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    @Override // io.ktor.websocket.WebSocketSession
    public boolean getMasking() {
        return this.raw.getMasking();
    }

    @Override // io.ktor.websocket.WebSocketSession
    public void setMasking(boolean value) {
        this.raw.setMasking(value);
    }

    @Override // io.ktor.websocket.WebSocketSession
    public long getMaxFrameSize() {
        return this.raw.getMaxFrameSize();
    }

    @Override // io.ktor.websocket.WebSocketSession
    public void setMaxFrameSize(long value) {
        this.raw.setMaxFrameSize(value);
    }

    @Override // io.ktor.websocket.DefaultWebSocketSession
    public long getPingIntervalMillis() {
        return this.pingIntervalMillis;
    }

    @Override // io.ktor.websocket.DefaultWebSocketSession
    public void setPingIntervalMillis(long newValue) {
        this.pingIntervalMillis = newValue;
        runOrCancelPinger();
    }

    @Override // io.ktor.websocket.DefaultWebSocketSession
    public long getTimeoutMillis() {
        return this.timeoutMillis;
    }

    @Override // io.ktor.websocket.DefaultWebSocketSession
    public void setTimeoutMillis(long newValue) {
        this.timeoutMillis = newValue;
        runOrCancelPinger();
    }

    @Override // io.ktor.websocket.DefaultWebSocketSession
    public Deferred<CloseReason> getCloseReason() {
        return this.closeReason;
    }

    @Override // io.ktor.websocket.DefaultWebSocketSession
    public void start(List<? extends WebSocketExtension<?>> list) {
        Intrinsics.checkNotNullParameter(list, "negotiatedExtensions");
        if (!started$FU.compareAndSet(this, 0, 1)) {
            throw new IllegalStateException(("WebSocket session " + this + " is already started.").toString());
        }
        Logger $this$trace$iv = DefaultWebSocketSessionKt.getLOGGER();
        if (LoggerJvmKt.isTraceEnabled($this$trace$iv)) {
            $this$trace$iv.trace("Starting default WebSocketSession(" + this + ") with negotiated extensions: " + CollectionsKt.joinToString$default(list, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null));
        }
        this._extensions.addAll(list);
        runOrCancelPinger();
        runIncomingProcessor(PingPongKt.ponger(this, getOutgoing()));
        runOutgoingProcessor();
    }

    public static /* synthetic */ Object goingAway$default(DefaultWebSocketSessionImpl defaultWebSocketSessionImpl, String str, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "Server is going down";
        }
        return defaultWebSocketSessionImpl.goingAway(str, continuation);
    }

    public final Object goingAway(String message, Continuation<? super Unit> continuation) {
        Object sendCloseSequence$default = sendCloseSequence$default(this, new CloseReason(CloseReason.Codes.GOING_AWAY, message), null, continuation, 2, null);
        return sendCloseSequence$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? sendCloseSequence$default : Unit.INSTANCE;
    }

    @Override // io.ktor.websocket.WebSocketSession
    public Object flush(Continuation<? super Unit> continuation) {
        Object flush = this.raw.flush(continuation);
        return flush == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? flush : Unit.INSTANCE;
    }

    @Override // io.ktor.websocket.WebSocketSession
    @Deprecated(level = DeprecationLevel.ERROR, message = "Use cancel() instead.", replaceWith = @ReplaceWith(expression = "cancel()", imports = {"kotlinx.coroutines.cancel"}))
    public void terminate() {
        Job.DefaultImpls.cancel$default(this.context, (CancellationException) null, 1, (Object) null);
        CoroutineScopeKt.cancel$default(this.raw, (CancellationException) null, 1, (Object) null);
    }

    private final Job runIncomingProcessor(SendChannel<? super Frame.Ping> sendChannel) {
        CoroutineName coroutineName;
        coroutineName = DefaultWebSocketSessionKt.IncomingProcessorCoroutineName;
        return BuildersKt.launch$default(this, coroutineName.plus(Dispatchers.getUnconfined()), (CoroutineStart) null, new DefaultWebSocketSessionImpl$runIncomingProcessor$1(this, sendChannel, null), 2, (Object) null);
    }

    private final Job runOutgoingProcessor() {
        CoroutineName coroutineName;
        coroutineName = DefaultWebSocketSessionKt.OutgoingProcessorCoroutineName;
        return BuildersKt.launch(this, coroutineName.plus(Dispatchers.getUnconfined()), CoroutineStart.UNDISPATCHED, new DefaultWebSocketSessionImpl$runOutgoingProcessor$1(this, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0068 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0077  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x00f4 -> B:16:0x005b). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object outgoingProcessorLoop(Continuation<? super Unit> continuation) {
        DefaultWebSocketSessionImpl$outgoingProcessorLoop$1 defaultWebSocketSessionImpl$outgoingProcessorLoop$1;
        DefaultWebSocketSessionImpl defaultWebSocketSessionImpl;
        ChannelIterator it;
        ChannelIterator channelIterator;
        DefaultWebSocketSessionImpl$outgoingProcessorLoop$1 defaultWebSocketSessionImpl$outgoingProcessorLoop$12;
        Object $result;
        Object obj;
        DefaultWebSocketSessionImpl defaultWebSocketSessionImpl2;
        Object hasNext;
        if (continuation instanceof DefaultWebSocketSessionImpl$outgoingProcessorLoop$1) {
            defaultWebSocketSessionImpl$outgoingProcessorLoop$1 = (DefaultWebSocketSessionImpl$outgoingProcessorLoop$1) continuation;
            if ((defaultWebSocketSessionImpl$outgoingProcessorLoop$1.label & Integer.MIN_VALUE) != 0) {
                defaultWebSocketSessionImpl$outgoingProcessorLoop$1.label -= Integer.MIN_VALUE;
                Object $result2 = defaultWebSocketSessionImpl$outgoingProcessorLoop$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (defaultWebSocketSessionImpl$outgoingProcessorLoop$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result2);
                        defaultWebSocketSessionImpl = this;
                        it = defaultWebSocketSessionImpl.outgoingToBeProcessed.iterator();
                        defaultWebSocketSessionImpl$outgoingProcessorLoop$1.L$0 = defaultWebSocketSessionImpl;
                        defaultWebSocketSessionImpl$outgoingProcessorLoop$1.L$1 = it;
                        defaultWebSocketSessionImpl$outgoingProcessorLoop$1.label = 1;
                        hasNext = it.hasNext(defaultWebSocketSessionImpl$outgoingProcessorLoop$1);
                        if (hasNext == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        defaultWebSocketSessionImpl$outgoingProcessorLoop$12 = defaultWebSocketSessionImpl$outgoingProcessorLoop$1;
                        $result = $result2;
                        obj = coroutine_suspended;
                        defaultWebSocketSessionImpl2 = defaultWebSocketSessionImpl;
                        channelIterator = it;
                        $result2 = hasNext;
                        if (((Boolean) $result2).booleanValue()) {
                            Frame frame = (Frame) channelIterator.next();
                            Logger $this$trace$iv = DefaultWebSocketSessionKt.getLOGGER();
                            if (LoggerJvmKt.isTraceEnabled($this$trace$iv)) {
                                $this$trace$iv.trace("Sending " + frame + " from session " + defaultWebSocketSessionImpl2);
                            }
                            if (frame instanceof Frame.Close) {
                                CloseReason readReason = FrameCommonKt.readReason((Frame.Close) frame);
                                defaultWebSocketSessionImpl$outgoingProcessorLoop$12.L$0 = null;
                                defaultWebSocketSessionImpl$outgoingProcessorLoop$12.L$1 = null;
                                defaultWebSocketSessionImpl$outgoingProcessorLoop$12.label = 2;
                                if (sendCloseSequence$default(defaultWebSocketSessionImpl2, readReason, null, defaultWebSocketSessionImpl$outgoingProcessorLoop$12, 2, null) == obj) {
                                    return obj;
                                }
                                defaultWebSocketSessionImpl$outgoingProcessorLoop$1 = defaultWebSocketSessionImpl$outgoingProcessorLoop$12;
                                $result2 = $result;
                            } else {
                                if ((frame instanceof Frame.Text) || (frame instanceof Frame.Binary)) {
                                    frame = defaultWebSocketSessionImpl2.processOutgoingExtensions(frame);
                                }
                                Frame processedFrame = frame;
                                SendChannel<Frame> outgoing = defaultWebSocketSessionImpl2.raw.getOutgoing();
                                defaultWebSocketSessionImpl$outgoingProcessorLoop$12.L$0 = defaultWebSocketSessionImpl2;
                                defaultWebSocketSessionImpl$outgoingProcessorLoop$12.L$1 = channelIterator;
                                defaultWebSocketSessionImpl$outgoingProcessorLoop$12.label = 3;
                                if (outgoing.send(processedFrame, defaultWebSocketSessionImpl$outgoingProcessorLoop$12) == obj) {
                                    return obj;
                                }
                                it = channelIterator;
                                defaultWebSocketSessionImpl$outgoingProcessorLoop$1 = defaultWebSocketSessionImpl$outgoingProcessorLoop$12;
                                $result2 = $result;
                                coroutine_suspended = obj;
                                defaultWebSocketSessionImpl = defaultWebSocketSessionImpl2;
                                defaultWebSocketSessionImpl$outgoingProcessorLoop$1.L$0 = defaultWebSocketSessionImpl;
                                defaultWebSocketSessionImpl$outgoingProcessorLoop$1.L$1 = it;
                                defaultWebSocketSessionImpl$outgoingProcessorLoop$1.label = 1;
                                hasNext = it.hasNext(defaultWebSocketSessionImpl$outgoingProcessorLoop$1);
                                if (hasNext == coroutine_suspended) {
                                }
                            }
                        }
                        return Unit.INSTANCE;
                    case 1:
                        channelIterator = (ChannelIterator) defaultWebSocketSessionImpl$outgoingProcessorLoop$1.L$1;
                        ResultKt.throwOnFailure($result2);
                        defaultWebSocketSessionImpl$outgoingProcessorLoop$12 = defaultWebSocketSessionImpl$outgoingProcessorLoop$1;
                        $result = $result2;
                        obj = coroutine_suspended;
                        defaultWebSocketSessionImpl2 = (DefaultWebSocketSessionImpl) defaultWebSocketSessionImpl$outgoingProcessorLoop$1.L$0;
                        if (((Boolean) $result2).booleanValue()) {
                        }
                        return Unit.INSTANCE;
                    case 2:
                        ResultKt.throwOnFailure($result2);
                        return Unit.INSTANCE;
                    case 3:
                        DefaultWebSocketSessionImpl defaultWebSocketSessionImpl3 = (DefaultWebSocketSessionImpl) defaultWebSocketSessionImpl$outgoingProcessorLoop$1.L$0;
                        ResultKt.throwOnFailure($result2);
                        it = (ChannelIterator) defaultWebSocketSessionImpl$outgoingProcessorLoop$1.L$1;
                        defaultWebSocketSessionImpl = defaultWebSocketSessionImpl3;
                        defaultWebSocketSessionImpl$outgoingProcessorLoop$1.L$0 = defaultWebSocketSessionImpl;
                        defaultWebSocketSessionImpl$outgoingProcessorLoop$1.L$1 = it;
                        defaultWebSocketSessionImpl$outgoingProcessorLoop$1.label = 1;
                        hasNext = it.hasNext(defaultWebSocketSessionImpl$outgoingProcessorLoop$1);
                        if (hasNext == coroutine_suspended) {
                        }
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        defaultWebSocketSessionImpl$outgoingProcessorLoop$1 = new DefaultWebSocketSessionImpl$outgoingProcessorLoop$1(this, continuation);
        Object $result22 = defaultWebSocketSessionImpl$outgoingProcessorLoop$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (defaultWebSocketSessionImpl$outgoingProcessorLoop$1.label) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00e1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object sendCloseSequence(CloseReason reasonToSend, Throwable exception, Continuation<? super Unit> continuation) {
        DefaultWebSocketSessionImpl$sendCloseSequence$1 defaultWebSocketSessionImpl$sendCloseSequence$1;
        DefaultWebSocketSessionImpl defaultWebSocketSessionImpl;
        Throwable th;
        DefaultWebSocketSessionImpl defaultWebSocketSessionImpl2;
        if (continuation instanceof DefaultWebSocketSessionImpl$sendCloseSequence$1) {
            defaultWebSocketSessionImpl$sendCloseSequence$1 = (DefaultWebSocketSessionImpl$sendCloseSequence$1) continuation;
            if ((defaultWebSocketSessionImpl$sendCloseSequence$1.label & Integer.MIN_VALUE) != 0) {
                defaultWebSocketSessionImpl$sendCloseSequence$1.label -= Integer.MIN_VALUE;
                Object $result = defaultWebSocketSessionImpl$sendCloseSequence$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (defaultWebSocketSessionImpl$sendCloseSequence$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        defaultWebSocketSessionImpl = this;
                        if (defaultWebSocketSessionImpl.tryClose()) {
                            Logger $this$trace$iv = DefaultWebSocketSessionKt.getLOGGER();
                            if (LoggerJvmKt.isTraceEnabled($this$trace$iv)) {
                                $this$trace$iv.trace("Sending Close Sequence for session " + defaultWebSocketSessionImpl + " with reason " + reasonToSend + " and exception " + exception);
                            }
                            defaultWebSocketSessionImpl.context.complete();
                            if (reasonToSend == null) {
                                reasonToSend = new CloseReason(CloseReason.Codes.NORMAL, Column.INVAL_VALUE);
                            }
                            try {
                                defaultWebSocketSessionImpl.runOrCancelPinger();
                                if (reasonToSend.getCode() != CloseReason.Codes.CLOSED_ABNORMALLY.getCode()) {
                                    SendChannel<Frame> outgoing = defaultWebSocketSessionImpl.raw.getOutgoing();
                                    Frame.Close close = new Frame.Close(reasonToSend);
                                    defaultWebSocketSessionImpl$sendCloseSequence$1.L$0 = defaultWebSocketSessionImpl;
                                    defaultWebSocketSessionImpl$sendCloseSequence$1.L$1 = exception;
                                    defaultWebSocketSessionImpl$sendCloseSequence$1.L$2 = reasonToSend;
                                    defaultWebSocketSessionImpl$sendCloseSequence$1.label = 1;
                                    if (outgoing.send(close, defaultWebSocketSessionImpl$sendCloseSequence$1) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    defaultWebSocketSessionImpl2 = defaultWebSocketSessionImpl;
                                    defaultWebSocketSessionImpl = defaultWebSocketSessionImpl2;
                                }
                                defaultWebSocketSessionImpl.closeReasonRef.complete(reasonToSend);
                                if (exception != null) {
                                    defaultWebSocketSessionImpl.outgoingToBeProcessed.close(exception);
                                    defaultWebSocketSessionImpl.filtered.close(exception);
                                }
                                return Unit.INSTANCE;
                            } catch (Throwable th2) {
                                th = th2;
                                defaultWebSocketSessionImpl2 = defaultWebSocketSessionImpl;
                                defaultWebSocketSessionImpl2.closeReasonRef.complete(reasonToSend);
                                if (exception != null) {
                                    defaultWebSocketSessionImpl2.outgoingToBeProcessed.close(exception);
                                    defaultWebSocketSessionImpl2.filtered.close(exception);
                                }
                                throw th;
                            }
                        }
                        return Unit.INSTANCE;
                    case 1:
                        reasonToSend = (CloseReason) defaultWebSocketSessionImpl$sendCloseSequence$1.L$2;
                        exception = (Throwable) defaultWebSocketSessionImpl$sendCloseSequence$1.L$1;
                        defaultWebSocketSessionImpl2 = (DefaultWebSocketSessionImpl) defaultWebSocketSessionImpl$sendCloseSequence$1.L$0;
                        try {
                            ResultKt.throwOnFailure($result);
                            defaultWebSocketSessionImpl = defaultWebSocketSessionImpl2;
                            defaultWebSocketSessionImpl.closeReasonRef.complete(reasonToSend);
                            if (exception != null) {
                            }
                            return Unit.INSTANCE;
                        } catch (Throwable th3) {
                            th = th3;
                            defaultWebSocketSessionImpl2.closeReasonRef.complete(reasonToSend);
                            if (exception != null) {
                            }
                            throw th;
                        }
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        defaultWebSocketSessionImpl$sendCloseSequence$1 = new DefaultWebSocketSessionImpl$sendCloseSequence$1(this, continuation);
        Object $result2 = defaultWebSocketSessionImpl$sendCloseSequence$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (defaultWebSocketSessionImpl$sendCloseSequence$1.label) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object sendCloseSequence$default(DefaultWebSocketSessionImpl defaultWebSocketSessionImpl, CloseReason closeReason, Throwable th, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        return defaultWebSocketSessionImpl.sendCloseSequence(closeReason, th, continuation);
    }

    private final boolean tryClose() {
        return closed$FU.compareAndSet(this, 0, 1);
    }

    private final void runOrCancelPinger() {
        SendChannel newPinger;
        long interval = getPingIntervalMillis();
        if (this.closed != 0) {
            newPinger = null;
        } else {
            newPinger = interval > 0 ? PingPongKt.pinger(this, this.raw.getOutgoing(), interval, getTimeoutMillis(), new DefaultWebSocketSessionImpl$runOrCancelPinger$newPinger$1(this, null)) : null;
        }
        SendChannel sendChannel = (SendChannel) pinger$FU.getAndSet(this, newPinger);
        if (sendChannel != null) {
            SendChannel.DefaultImpls.close$default(sendChannel, (Throwable) null, 1, (Object) null);
        }
        if (newPinger != null) {
            ChannelResult.isSuccess-impl(newPinger.trySend-JP2dKIU(EmptyPong));
        }
        if (this.closed != 0 && newPinger != null) {
            runOrCancelPinger();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object checkMaxFrameSize(Sink packet, Frame frame, Continuation<? super Unit> continuation) {
        DefaultWebSocketSessionImpl$checkMaxFrameSize$1 defaultWebSocketSessionImpl$checkMaxFrameSize$1;
        int size;
        if (continuation instanceof DefaultWebSocketSessionImpl$checkMaxFrameSize$1) {
            defaultWebSocketSessionImpl$checkMaxFrameSize$1 = (DefaultWebSocketSessionImpl$checkMaxFrameSize$1) continuation;
            if ((defaultWebSocketSessionImpl$checkMaxFrameSize$1.label & Integer.MIN_VALUE) != 0) {
                defaultWebSocketSessionImpl$checkMaxFrameSize$1.label -= Integer.MIN_VALUE;
                Object $result = defaultWebSocketSessionImpl$checkMaxFrameSize$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (defaultWebSocketSessionImpl$checkMaxFrameSize$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        int size2 = (packet != null ? BytePacketBuilderKt.getSize(packet) : 0) + frame.getData().length;
                        if (size2 > getMaxFrameSize()) {
                            if (packet != null) {
                                packet.close();
                            }
                            CloseReason closeReason = new CloseReason(CloseReason.Codes.TOO_BIG, "Frame is too big: " + size2 + ". Max size is " + getMaxFrameSize());
                            defaultWebSocketSessionImpl$checkMaxFrameSize$1.I$0 = size2;
                            defaultWebSocketSessionImpl$checkMaxFrameSize$1.label = 1;
                            if (WebSocketSessionKt.close(this, closeReason, (Continuation<? super Unit>) defaultWebSocketSessionImpl$checkMaxFrameSize$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            size = size2;
                            break;
                        } else {
                            return Unit.INSTANCE;
                        }
                    case 1:
                        size = defaultWebSocketSessionImpl$checkMaxFrameSize$1.I$0;
                        ResultKt.throwOnFailure($result);
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                throw new FrameTooBigException(size);
            }
        }
        defaultWebSocketSessionImpl$checkMaxFrameSize$1 = new DefaultWebSocketSessionImpl$checkMaxFrameSize$1(this, continuation);
        Object $result2 = defaultWebSocketSessionImpl$checkMaxFrameSize$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (defaultWebSocketSessionImpl$checkMaxFrameSize$1.label) {
        }
        throw new FrameTooBigException(size);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Frame processIncomingExtensions(Frame frame) {
        Iterable $this$fold$iv = getExtensions();
        Frame frame2 = frame;
        for (Object element$iv : $this$fold$iv) {
            WebSocketExtension extension = (WebSocketExtension) element$iv;
            Frame current = frame2;
            frame2 = extension.processIncomingFrame(current);
        }
        return frame2;
    }

    private final Frame processOutgoingExtensions(Frame frame) {
        Iterable $this$fold$iv = getExtensions();
        Frame frame2 = frame;
        for (Object element$iv : $this$fold$iv) {
            WebSocketExtension extension = (WebSocketExtension) element$iv;
            Frame current = frame2;
            frame2 = extension.processOutgoingFrame(current);
        }
        return frame2;
    }

    /* compiled from: DefaultWebSocketSession.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lio/ktor/websocket/DefaultWebSocketSessionImpl$Companion;", Column.INVAL_VALUE, "<init>", "()V", "Lio/ktor/websocket/Frame$Pong;", "EmptyPong", "Lio/ktor/websocket/Frame$Pong;", "ktor-websockets"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602230606352175db5d-4dcb-42b5-ae97-9aefdbbfec86/202602230606352175db5d-4dcb-42b5-ae97-9aefdbbfec86.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}