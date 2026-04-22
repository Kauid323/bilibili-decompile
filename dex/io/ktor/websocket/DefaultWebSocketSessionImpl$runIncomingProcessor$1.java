package io.ktor.websocket;

import com.bilibili.doraemonkit.widget.tableview.bean.Column;
import com.bilibili.game.service.exception.DownloadError;
import io.ktor.util.logging.LoggerJvmKt;
import io.ktor.utils.io.core.BytePacketBuilderKt;
import io.ktor.websocket.CloseReason;
import io.ktor.websocket.Frame;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelsKt;
import kotlinx.coroutines.channels.ClosedSendChannelException;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.io.Sink;
import kotlinx.io.SourcesKt;
import org.slf4j.Logger;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DefaultWebSocketSession.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", Column.INVAL_VALUE, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.websocket.DefaultWebSocketSessionImpl$runIncomingProcessor$1", f = "DefaultWebSocketSession.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7}, l = {377, 183, 236, 189, 190, 192, DownloadError.FILE_APK_FILE_INVALID_ERROR, 222, 236, 236, 236, 236}, m = "invokeSuspend", n = {"$this$launch", "firstFrame", "frameBody", "closeFramePresented", "$this$consume$iv$iv", "frameBody", "closeFramePresented", "$this$consume$iv$iv", "$this$launch", "firstFrame", "frameBody", "closeFramePresented", "$this$consume$iv$iv", "$this$launch", "firstFrame", "frameBody", "closeFramePresented", "$this$consume$iv$iv", "$this$launch", "firstFrame", "frameBody", "closeFramePresented", "$this$consume$iv$iv", "frame", "$this$launch", "firstFrame", "frameBody", "closeFramePresented", "$this$consume$iv$iv", "$this$launch", "firstFrame", "frameBody", "closeFramePresented", "$this$consume$iv$iv"}, s = {"L$0", "L$1", "L$2", "L$3", "L$6", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$6", "L$0", "L$1", "L$2", "L$3", "L$6", "L$0", "L$1", "L$2", "L$3", "L$6", "L$8", "L$0", "L$1", "L$2", "L$3", "L$6", "L$0", "L$1", "L$2", "L$3", "L$6"})
public final class DefaultWebSocketSessionImpl$runIncomingProcessor$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ SendChannel<Frame.Ping> $ponger;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    int label;
    final /* synthetic */ DefaultWebSocketSessionImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public DefaultWebSocketSessionImpl$runIncomingProcessor$1(DefaultWebSocketSessionImpl defaultWebSocketSessionImpl, SendChannel<? super Frame.Ping> sendChannel, Continuation<? super DefaultWebSocketSessionImpl$runIncomingProcessor$1> continuation) {
        super(2, continuation);
        this.this$0 = defaultWebSocketSessionImpl;
        this.$ponger = sendChannel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> defaultWebSocketSessionImpl$runIncomingProcessor$1 = new DefaultWebSocketSessionImpl$runIncomingProcessor$1(this.this$0, this.$ponger, continuation);
        defaultWebSocketSessionImpl$runIncomingProcessor$1.L$0 = obj;
        return defaultWebSocketSessionImpl$runIncomingProcessor$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Not initialized variable reg: 13, insn: 0x014d: MOVE  (r4 I:??[OBJECT, ARRAY]) = (r13 I:??[OBJECT, ARRAY] A[D('frameBody' kotlin.jvm.internal.Ref$ObjectRef)]), block:B:28:0x014d */
    /* JADX WARN: Removed duplicated region for block: B:120:0x03fa  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x043b  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0563  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x0624  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x063a  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x06cf  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x06e5  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x0711  */
    /* JADX WARN: Removed duplicated region for block: B:272:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0212 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0225 A[Catch: all -> 0x05dc, TRY_LEAVE, TryCatch #25 {all -> 0x05dc, blocks: (B:49:0x021d, B:51:0x0225), top: B:262:0x021d }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x02ea  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0300  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:102:0x036f -> B:151:0x0540). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:105:0x037e -> B:151:0x0540). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:113:0x03b3 -> B:151:0x0540). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:128:0x0424 -> B:230:0x01f4). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:142:0x047b -> B:230:0x01f4). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:148:0x0522 -> B:248:0x052c). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Ref.ObjectRef frameBody;
        Ref.ObjectRef frameBody2;
        Ref.BooleanRef closeFramePresented;
        ReceiveChannel $this$consume$iv$iv;
        Object $result;
        Ref.ObjectRef frameBody3;
        Object $result2;
        SendChannel sendChannel;
        Throwable th;
        Object $result3;
        Channel channel;
        Sink sink;
        SendChannel sendChannel2;
        Sink sink2;
        SendChannel sendChannel3;
        CoroutineScope $this$launch;
        Ref.ObjectRef firstFrame;
        WebSocketSession webSocketSession;
        DefaultWebSocketSessionImpl defaultWebSocketSessionImpl;
        SendChannel<Frame.Ping> sendChannel4;
        boolean z;
        boolean z2;
        Throwable cause$iv$iv;
        boolean z3;
        ChannelIterator it;
        boolean z4;
        boolean z5;
        ReceiveChannel $this$consume$iv$iv2;
        Throwable cause$iv$iv2;
        DefaultWebSocketSessionImpl defaultWebSocketSessionImpl2;
        Object obj2;
        Ref.BooleanRef closeFramePresented2;
        Ref.ObjectRef firstFrame2;
        boolean z6;
        boolean z7;
        ReceiveChannel receiveChannel;
        Ref.ObjectRef frameBody4;
        Object $result4;
        Object $result5;
        Object $result6;
        boolean z8;
        boolean z9;
        Throwable cause$iv$iv3;
        ReceiveChannel $this$consume$iv$iv3;
        SendChannel<Frame.Ping> sendChannel5;
        DefaultWebSocketSessionImpl defaultWebSocketSessionImpl3;
        Ref.BooleanRef closeFramePresented3;
        Ref.ObjectRef firstFrame3;
        boolean z10;
        Ref.ObjectRef frameBody5;
        Object $result7;
        boolean z11;
        Throwable cause$iv$iv4;
        ReceiveChannel $this$consume$iv$iv4;
        SendChannel<Frame.Ping> sendChannel6;
        DefaultWebSocketSessionImpl defaultWebSocketSessionImpl4;
        Ref.BooleanRef closeFramePresented4;
        Ref.ObjectRef firstFrame4;
        Ref.ObjectRef frameBody6;
        boolean z12;
        boolean z13;
        Frame frame;
        boolean z14;
        Object $result8;
        Ref.BooleanRef closeFramePresented5;
        boolean z15;
        DefaultWebSocketSessionImpl defaultWebSocketSessionImpl5;
        SendChannel<Frame.Ping> sendChannel7;
        ChannelIterator channelIterator;
        boolean z16;
        boolean z17;
        ChannelIterator channelIterator2;
        SendChannel<Frame.Ping> sendChannel8;
        DefaultWebSocketSessionImpl defaultWebSocketSessionImpl6;
        Ref.ObjectRef frameBody7;
        Ref.ObjectRef firstFrame5;
        boolean z18;
        Object obj3;
        DefaultWebSocketSessionImpl$runIncomingProcessor$1 defaultWebSocketSessionImpl$runIncomingProcessor$1;
        CoroutineScope $this$launch2;
        Channel channel2;
        Frame processIncomingExtensions;
        Ref.ObjectRef firstFrame6;
        boolean z19;
        boolean z20;
        Channel channel3;
        boolean z21;
        Frame processIncomingExtensions2;
        boolean z22;
        Object $result9;
        Ref.ObjectRef frameBody8;
        Sink sink3;
        SendChannel sendChannel9;
        SendChannel sendChannel10;
        boolean z23;
        Object checkMaxFrameSize;
        Ref.ObjectRef firstFrame7;
        Object hasNext;
        DefaultWebSocketSessionImpl$runIncomingProcessor$1 defaultWebSocketSessionImpl$runIncomingProcessor$12 = this;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
        } catch (Throwable th2) {
            e$iv$iv = th2;
            frameBody2 = frameBody;
        }
        switch (defaultWebSocketSessionImpl$runIncomingProcessor$12.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                $result = obj;
                $this$launch = (CoroutineScope) defaultWebSocketSessionImpl$runIncomingProcessor$12.L$0;
                firstFrame = new Ref.ObjectRef();
                frameBody3 = new Ref.ObjectRef();
                closeFramePresented = new Ref.BooleanRef();
                try {
                    webSocketSession = defaultWebSocketSessionImpl$runIncomingProcessor$12.this$0.raw;
                    ReceiveChannel $this$consumeEach$iv = webSocketSession.getIncoming();
                    defaultWebSocketSessionImpl = defaultWebSocketSessionImpl$runIncomingProcessor$12.this$0;
                    sendChannel4 = defaultWebSocketSessionImpl$runIncomingProcessor$12.$ponger;
                    z = false;
                    $this$consume$iv$iv = $this$consumeEach$iv;
                    z2 = false;
                    cause$iv$iv = null;
                    z3 = false;
                    try {
                        it = $this$consume$iv$iv.iterator();
                        try {
                            defaultWebSocketSessionImpl$runIncomingProcessor$12.L$0 = $this$launch;
                            defaultWebSocketSessionImpl$runIncomingProcessor$12.L$1 = firstFrame;
                            defaultWebSocketSessionImpl$runIncomingProcessor$12.L$2 = frameBody3;
                            defaultWebSocketSessionImpl$runIncomingProcessor$12.L$3 = closeFramePresented;
                            defaultWebSocketSessionImpl$runIncomingProcessor$12.L$4 = defaultWebSocketSessionImpl;
                            defaultWebSocketSessionImpl$runIncomingProcessor$12.L$5 = sendChannel4;
                            defaultWebSocketSessionImpl$runIncomingProcessor$12.L$6 = $this$consume$iv$iv;
                            defaultWebSocketSessionImpl$runIncomingProcessor$12.L$7 = it;
                            firstFrame7 = firstFrame;
                            defaultWebSocketSessionImpl$runIncomingProcessor$12.L$8 = null;
                            defaultWebSocketSessionImpl$runIncomingProcessor$12.label = 1;
                            hasNext = it.hasNext(defaultWebSocketSessionImpl$runIncomingProcessor$12);
                        } catch (Throwable th3) {
                            e$iv$iv = th3;
                            frameBody2 = frameBody3;
                        }
                    } catch (Throwable th4) {
                        e$iv$iv = th4;
                        defaultWebSocketSessionImpl$runIncomingProcessor$12 = this;
                        frameBody2 = frameBody3;
                    }
                } catch (ClosedSendChannelException e) {
                    defaultWebSocketSessionImpl$runIncomingProcessor$12 = this;
                    $result2 = $result;
                    SendChannel.DefaultImpls.close$default(defaultWebSocketSessionImpl$runIncomingProcessor$12.$ponger, (Throwable) null, 1, (Object) null);
                    sink2 = (Sink) frameBody3.element;
                    if (sink2 != null) {
                    }
                    sendChannel3 = defaultWebSocketSessionImpl$runIncomingProcessor$12.this$0.filtered;
                    SendChannel.DefaultImpls.close$default(sendChannel3, (Throwable) null, 1, (Object) null);
                    if (closeFramePresented.element) {
                    }
                } catch (Throwable th5) {
                    cause = th5;
                    defaultWebSocketSessionImpl$runIncomingProcessor$12 = this;
                    try {
                        SendChannel.DefaultImpls.close$default(defaultWebSocketSessionImpl$runIncomingProcessor$12.$ponger, (Throwable) null, 1, (Object) null);
                        channel = defaultWebSocketSessionImpl$runIncomingProcessor$12.this$0.filtered;
                        channel.close(cause);
                        SendChannel.DefaultImpls.close$default(defaultWebSocketSessionImpl$runIncomingProcessor$12.$ponger, (Throwable) null, 1, (Object) null);
                        sink = (Sink) frameBody3.element;
                        if (sink != null) {
                        }
                        sendChannel2 = defaultWebSocketSessionImpl$runIncomingProcessor$12.this$0.filtered;
                        SendChannel.DefaultImpls.close$default(sendChannel2, (Throwable) null, 1, (Object) null);
                        if (!closeFramePresented.element) {
                        }
                        return Unit.INSTANCE;
                    } catch (Throwable th6) {
                        SendChannel.DefaultImpls.close$default(defaultWebSocketSessionImpl$runIncomingProcessor$12.$ponger, (Throwable) null, 1, (Object) null);
                        Sink sink4 = (Sink) frameBody3.element;
                        if (sink4 != null) {
                            sink4.close();
                            Unit unit = Unit.INSTANCE;
                        }
                        sendChannel = defaultWebSocketSessionImpl$runIncomingProcessor$12.this$0.filtered;
                        SendChannel.DefaultImpls.close$default(sendChannel, (Throwable) null, 1, (Object) null);
                        if (!closeFramePresented.element) {
                            defaultWebSocketSessionImpl$runIncomingProcessor$12.L$0 = th6;
                            defaultWebSocketSessionImpl$runIncomingProcessor$12.L$1 = null;
                            defaultWebSocketSessionImpl$runIncomingProcessor$12.L$2 = null;
                            defaultWebSocketSessionImpl$runIncomingProcessor$12.L$3 = null;
                            defaultWebSocketSessionImpl$runIncomingProcessor$12.L$4 = null;
                            defaultWebSocketSessionImpl$runIncomingProcessor$12.L$5 = null;
                            defaultWebSocketSessionImpl$runIncomingProcessor$12.L$6 = null;
                            defaultWebSocketSessionImpl$runIncomingProcessor$12.L$7 = null;
                            defaultWebSocketSessionImpl$runIncomingProcessor$12.L$8 = null;
                            defaultWebSocketSessionImpl$runIncomingProcessor$12.label = 12;
                            if (WebSocketSessionKt.close(defaultWebSocketSessionImpl$runIncomingProcessor$12.this$0, new CloseReason(CloseReason.Codes.CLOSED_ABNORMALLY, "Connection was closed without close frame"), (Continuation) defaultWebSocketSessionImpl$runIncomingProcessor$12) != coroutine_suspended) {
                                th = th6;
                                $result3 = $result;
                                break;
                            } else {
                                return coroutine_suspended;
                            }
                        } else {
                            throw th6;
                        }
                    }
                }
                if (hasNext == coroutine_suspended) {
                    return coroutine_suspended;
                }
                z5 = z3;
                $this$consume$iv$iv2 = $this$consume$iv$iv;
                cause$iv$iv2 = cause$iv$iv;
                defaultWebSocketSessionImpl2 = defaultWebSocketSessionImpl;
                z4 = z2;
                obj2 = hasNext;
                closeFramePresented2 = closeFramePresented;
                firstFrame2 = firstFrame7;
                try {
                } catch (Throwable th7) {
                    e$iv$iv = th7;
                    closeFramePresented = closeFramePresented2;
                    frameBody2 = frameBody3;
                    $this$consume$iv$iv = $this$consume$iv$iv2;
                }
                if (((Boolean) obj2).booleanValue()) {
                    Object $result10 = $result;
                    Unit unit2 = Unit.INSTANCE;
                    try {
                        ChannelsKt.cancelConsumed($this$consume$iv$iv2, cause$iv$iv2);
                        SendChannel.DefaultImpls.close$default(defaultWebSocketSessionImpl$runIncomingProcessor$12.$ponger, (Throwable) null, 1, (Object) null);
                        Sink sink5 = (Sink) frameBody3.element;
                        if (sink5 != null) {
                            sink5.close();
                            Unit unit3 = Unit.INSTANCE;
                        }
                        sendChannel10 = defaultWebSocketSessionImpl$runIncomingProcessor$12.this$0.filtered;
                        SendChannel.DefaultImpls.close$default(sendChannel10, (Throwable) null, 1, (Object) null);
                    } catch (ClosedSendChannelException e2) {
                        closeFramePresented = closeFramePresented2;
                        $result2 = $result10;
                        SendChannel.DefaultImpls.close$default(defaultWebSocketSessionImpl$runIncomingProcessor$12.$ponger, (Throwable) null, 1, (Object) null);
                        sink2 = (Sink) frameBody3.element;
                        if (sink2 != null) {
                        }
                        sendChannel3 = defaultWebSocketSessionImpl$runIncomingProcessor$12.this$0.filtered;
                        SendChannel.DefaultImpls.close$default(sendChannel3, (Throwable) null, 1, (Object) null);
                        if (closeFramePresented.element) {
                        }
                    } catch (Throwable th8) {
                        cause = th8;
                        closeFramePresented = closeFramePresented2;
                        $result = $result10;
                        SendChannel.DefaultImpls.close$default(defaultWebSocketSessionImpl$runIncomingProcessor$12.$ponger, (Throwable) null, 1, (Object) null);
                        channel = defaultWebSocketSessionImpl$runIncomingProcessor$12.this$0.filtered;
                        channel.close(cause);
                        SendChannel.DefaultImpls.close$default(defaultWebSocketSessionImpl$runIncomingProcessor$12.$ponger, (Throwable) null, 1, (Object) null);
                        sink = (Sink) frameBody3.element;
                        if (sink != null) {
                        }
                        sendChannel2 = defaultWebSocketSessionImpl$runIncomingProcessor$12.this$0.filtered;
                        SendChannel.DefaultImpls.close$default(sendChannel2, (Throwable) null, 1, (Object) null);
                        if (!closeFramePresented.element) {
                        }
                        return Unit.INSTANCE;
                    }
                    if (closeFramePresented2.element) {
                        return Unit.INSTANCE;
                    }
                    defaultWebSocketSessionImpl$runIncomingProcessor$12.L$0 = null;
                    defaultWebSocketSessionImpl$runIncomingProcessor$12.L$1 = null;
                    defaultWebSocketSessionImpl$runIncomingProcessor$12.L$2 = null;
                    defaultWebSocketSessionImpl$runIncomingProcessor$12.L$3 = null;
                    defaultWebSocketSessionImpl$runIncomingProcessor$12.L$4 = null;
                    defaultWebSocketSessionImpl$runIncomingProcessor$12.L$5 = null;
                    defaultWebSocketSessionImpl$runIncomingProcessor$12.L$6 = null;
                    defaultWebSocketSessionImpl$runIncomingProcessor$12.L$7 = null;
                    defaultWebSocketSessionImpl$runIncomingProcessor$12.label = 9;
                    if (WebSocketSessionKt.close(defaultWebSocketSessionImpl$runIncomingProcessor$12.this$0, new CloseReason(CloseReason.Codes.CLOSED_ABNORMALLY, "Connection was closed without close frame"), (Continuation) defaultWebSocketSessionImpl$runIncomingProcessor$12) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $result2 = $result10;
                    return Unit.INSTANCE;
                }
                Object e$iv = it.next();
                Frame frame2 = (Frame) e$iv;
                z14 = false;
                Logger $this$trace$iv = DefaultWebSocketSessionKt.getLOGGER();
                if (LoggerJvmKt.isTraceEnabled($this$trace$iv)) {
                    try {
                        $result9 = $result;
                        try {
                            $this$trace$iv.trace("WebSocketSession(" + $this$launch + ") receiving frame " + frame2);
                        } catch (Throwable th9) {
                            e$iv$iv = th9;
                            closeFramePresented = closeFramePresented2;
                            frameBody2 = frameBody3;
                            $this$consume$iv$iv = $this$consume$iv$iv2;
                            $result = $result9;
                        }
                    } catch (Throwable th10) {
                        e$iv$iv = th10;
                        closeFramePresented = closeFramePresented2;
                        frameBody2 = frameBody3;
                        $this$consume$iv$iv = $this$consume$iv$iv2;
                        $result = $result9;
                    }
                    z23 = z4;
                } else {
                    $result9 = $result;
                    z23 = z4;
                }
                if (frame2 instanceof Frame.Close) {
                    if (defaultWebSocketSessionImpl2.getOutgoing().isClosedForSend()) {
                        closeFramePresented = closeFramePresented2;
                        $result = $result9;
                        closeFramePresented.element = true;
                        Object $result11 = Unit.INSTANCE;
                        ChannelsKt.cancelConsumed($this$consume$iv$iv2, cause$iv$iv2);
                        SendChannel.DefaultImpls.close$default(defaultWebSocketSessionImpl$runIncomingProcessor$12.$ponger, (Throwable) null, 1, (Object) null);
                        sink3 = (Sink) frameBody3.element;
                        if (sink3 != null) {
                        }
                        sendChannel9 = defaultWebSocketSessionImpl$runIncomingProcessor$12.this$0.filtered;
                        SendChannel.DefaultImpls.close$default(sendChannel9, (Throwable) null, 1, (Object) null);
                        if (closeFramePresented.element) {
                        }
                    } else {
                        SendChannel<Frame> outgoing = defaultWebSocketSessionImpl2.getOutgoing();
                        CloseReason readReason = FrameCommonKt.readReason((Frame.Close) frame2);
                        if (readReason == null) {
                            readReason = DefaultWebSocketSessionKt.NORMAL_CLOSE;
                        }
                        Frame.Close close = new Frame.Close(readReason);
                        defaultWebSocketSessionImpl$runIncomingProcessor$12.L$0 = frameBody3;
                        defaultWebSocketSessionImpl$runIncomingProcessor$12.L$1 = closeFramePresented2;
                        defaultWebSocketSessionImpl$runIncomingProcessor$12.L$2 = $this$consume$iv$iv2;
                        defaultWebSocketSessionImpl$runIncomingProcessor$12.L$3 = null;
                        defaultWebSocketSessionImpl$runIncomingProcessor$12.L$4 = null;
                        defaultWebSocketSessionImpl$runIncomingProcessor$12.L$5 = null;
                        defaultWebSocketSessionImpl$runIncomingProcessor$12.L$6 = null;
                        defaultWebSocketSessionImpl$runIncomingProcessor$12.L$7 = null;
                        defaultWebSocketSessionImpl$runIncomingProcessor$12.label = 2;
                        if (outgoing.send(close, defaultWebSocketSessionImpl$runIncomingProcessor$12) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        z6 = z5;
                        closeFramePresented = closeFramePresented2;
                        frameBody4 = frameBody3;
                        receiveChannel = $this$consume$iv$iv2;
                        z7 = false;
                        $result = $result9;
                        $this$consume$iv$iv2 = receiveChannel;
                        frameBody3 = frameBody4;
                        try {
                            closeFramePresented.element = true;
                            Object $result112 = Unit.INSTANCE;
                            try {
                                ChannelsKt.cancelConsumed($this$consume$iv$iv2, cause$iv$iv2);
                                SendChannel.DefaultImpls.close$default(defaultWebSocketSessionImpl$runIncomingProcessor$12.$ponger, (Throwable) null, 1, (Object) null);
                                sink3 = (Sink) frameBody3.element;
                                if (sink3 != null) {
                                    sink3.close();
                                    Unit unit4 = Unit.INSTANCE;
                                }
                                sendChannel9 = defaultWebSocketSessionImpl$runIncomingProcessor$12.this$0.filtered;
                                SendChannel.DefaultImpls.close$default(sendChannel9, (Throwable) null, 1, (Object) null);
                                if (closeFramePresented.element) {
                                    return $result112;
                                }
                                defaultWebSocketSessionImpl$runIncomingProcessor$12.L$0 = $result112;
                                defaultWebSocketSessionImpl$runIncomingProcessor$12.L$1 = null;
                                defaultWebSocketSessionImpl$runIncomingProcessor$12.L$2 = null;
                                defaultWebSocketSessionImpl$runIncomingProcessor$12.L$3 = null;
                                defaultWebSocketSessionImpl$runIncomingProcessor$12.L$4 = null;
                                defaultWebSocketSessionImpl$runIncomingProcessor$12.L$5 = null;
                                defaultWebSocketSessionImpl$runIncomingProcessor$12.L$6 = null;
                                defaultWebSocketSessionImpl$runIncomingProcessor$12.L$7 = null;
                                defaultWebSocketSessionImpl$runIncomingProcessor$12.label = 3;
                                if (WebSocketSessionKt.close(defaultWebSocketSessionImpl$runIncomingProcessor$12.this$0, new CloseReason(CloseReason.Codes.CLOSED_ABNORMALLY, "Connection was closed without close frame"), (Continuation) defaultWebSocketSessionImpl$runIncomingProcessor$12) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                $result5 = $result112;
                                $result4 = $result;
                                return $result5;
                            } catch (ClosedSendChannelException e3) {
                                $result2 = $result;
                                SendChannel.DefaultImpls.close$default(defaultWebSocketSessionImpl$runIncomingProcessor$12.$ponger, (Throwable) null, 1, (Object) null);
                                sink2 = (Sink) frameBody3.element;
                                if (sink2 != null) {
                                    sink2.close();
                                    Unit unit5 = Unit.INSTANCE;
                                }
                                sendChannel3 = defaultWebSocketSessionImpl$runIncomingProcessor$12.this$0.filtered;
                                SendChannel.DefaultImpls.close$default(sendChannel3, (Throwable) null, 1, (Object) null);
                                if (closeFramePresented.element) {
                                    defaultWebSocketSessionImpl$runIncomingProcessor$12.L$0 = null;
                                    defaultWebSocketSessionImpl$runIncomingProcessor$12.L$1 = null;
                                    defaultWebSocketSessionImpl$runIncomingProcessor$12.L$2 = null;
                                    defaultWebSocketSessionImpl$runIncomingProcessor$12.L$3 = null;
                                    defaultWebSocketSessionImpl$runIncomingProcessor$12.L$4 = null;
                                    defaultWebSocketSessionImpl$runIncomingProcessor$12.L$5 = null;
                                    defaultWebSocketSessionImpl$runIncomingProcessor$12.L$6 = null;
                                    defaultWebSocketSessionImpl$runIncomingProcessor$12.L$7 = null;
                                    defaultWebSocketSessionImpl$runIncomingProcessor$12.L$8 = null;
                                    defaultWebSocketSessionImpl$runIncomingProcessor$12.label = 10;
                                    if (WebSocketSessionKt.close(defaultWebSocketSessionImpl$runIncomingProcessor$12.this$0, new CloseReason(CloseReason.Codes.CLOSED_ABNORMALLY, "Connection was closed without close frame"), (Continuation) defaultWebSocketSessionImpl$runIncomingProcessor$12) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    return Unit.INSTANCE;
                                }
                                return Unit.INSTANCE;
                            } catch (Throwable th11) {
                                cause = th11;
                                SendChannel.DefaultImpls.close$default(defaultWebSocketSessionImpl$runIncomingProcessor$12.$ponger, (Throwable) null, 1, (Object) null);
                                channel = defaultWebSocketSessionImpl$runIncomingProcessor$12.this$0.filtered;
                                channel.close(cause);
                                SendChannel.DefaultImpls.close$default(defaultWebSocketSessionImpl$runIncomingProcessor$12.$ponger, (Throwable) null, 1, (Object) null);
                                sink = (Sink) frameBody3.element;
                                if (sink != null) {
                                    sink.close();
                                    Unit unit6 = Unit.INSTANCE;
                                }
                                sendChannel2 = defaultWebSocketSessionImpl$runIncomingProcessor$12.this$0.filtered;
                                SendChannel.DefaultImpls.close$default(sendChannel2, (Throwable) null, 1, (Object) null);
                                if (!closeFramePresented.element) {
                                    defaultWebSocketSessionImpl$runIncomingProcessor$12.L$0 = null;
                                    defaultWebSocketSessionImpl$runIncomingProcessor$12.L$1 = null;
                                    defaultWebSocketSessionImpl$runIncomingProcessor$12.L$2 = null;
                                    defaultWebSocketSessionImpl$runIncomingProcessor$12.L$3 = null;
                                    defaultWebSocketSessionImpl$runIncomingProcessor$12.L$4 = null;
                                    defaultWebSocketSessionImpl$runIncomingProcessor$12.L$5 = null;
                                    defaultWebSocketSessionImpl$runIncomingProcessor$12.L$6 = null;
                                    defaultWebSocketSessionImpl$runIncomingProcessor$12.L$7 = null;
                                    defaultWebSocketSessionImpl$runIncomingProcessor$12.L$8 = null;
                                    defaultWebSocketSessionImpl$runIncomingProcessor$12.label = 11;
                                    if (WebSocketSessionKt.close(defaultWebSocketSessionImpl$runIncomingProcessor$12.this$0, new CloseReason(CloseReason.Codes.CLOSED_ABNORMALLY, "Connection was closed without close frame"), (Continuation) defaultWebSocketSessionImpl$runIncomingProcessor$12) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    $result2 = $result;
                                }
                                return Unit.INSTANCE;
                            }
                        } catch (Throwable th12) {
                            e$iv$iv = th12;
                            $this$consume$iv$iv = $this$consume$iv$iv2;
                            frameBody2 = frameBody3;
                        }
                    }
                } else if (frame2 instanceof Frame.Pong) {
                    SendChannel sendChannel11 = (SendChannel) defaultWebSocketSessionImpl2.pinger;
                    if (sendChannel11 != null) {
                        defaultWebSocketSessionImpl$runIncomingProcessor$12.L$0 = $this$launch;
                        defaultWebSocketSessionImpl$runIncomingProcessor$12.L$1 = firstFrame2;
                        defaultWebSocketSessionImpl$runIncomingProcessor$12.L$2 = frameBody3;
                        defaultWebSocketSessionImpl$runIncomingProcessor$12.L$3 = closeFramePresented2;
                        defaultWebSocketSessionImpl$runIncomingProcessor$12.L$4 = defaultWebSocketSessionImpl2;
                        defaultWebSocketSessionImpl$runIncomingProcessor$12.L$5 = sendChannel4;
                        defaultWebSocketSessionImpl$runIncomingProcessor$12.L$6 = $this$consume$iv$iv2;
                        defaultWebSocketSessionImpl$runIncomingProcessor$12.L$7 = it;
                        defaultWebSocketSessionImpl$runIncomingProcessor$12.label = 4;
                        if (sendChannel11.send(frame2, defaultWebSocketSessionImpl$runIncomingProcessor$12) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        sendChannel5 = sendChannel4;
                        z9 = z;
                        defaultWebSocketSessionImpl3 = defaultWebSocketSessionImpl2;
                        cause$iv$iv3 = cause$iv$iv2;
                        $this$consume$iv$iv3 = $this$consume$iv$iv2;
                        firstFrame3 = firstFrame2;
                        $result6 = $result9;
                        z8 = z23;
                        closeFramePresented3 = closeFramePresented2;
                        frameBody5 = frameBody3;
                        z10 = z5;
                        Unit unit7 = Unit.INSTANCE;
                        $result9 = $result6;
                        frameBody8 = frameBody5;
                        closeFramePresented2 = closeFramePresented3;
                        firstFrame2 = firstFrame3;
                        $this$consume$iv$iv2 = $this$consume$iv$iv3;
                        cause$iv$iv2 = cause$iv$iv3;
                        defaultWebSocketSessionImpl2 = defaultWebSocketSessionImpl3;
                        z = z9;
                        sendChannel4 = sendChannel5;
                        z2 = z8;
                        defaultWebSocketSessionImpl = defaultWebSocketSessionImpl2;
                        cause$iv$iv = cause$iv$iv2;
                        $this$consume$iv$iv = $this$consume$iv$iv2;
                        z3 = z10;
                        frameBody3 = frameBody8;
                        $result = $result9;
                        Ref.ObjectRef objectRef = firstFrame2;
                        closeFramePresented = closeFramePresented2;
                        firstFrame = objectRef;
                        defaultWebSocketSessionImpl$runIncomingProcessor$12.L$0 = $this$launch;
                        defaultWebSocketSessionImpl$runIncomingProcessor$12.L$1 = firstFrame;
                        defaultWebSocketSessionImpl$runIncomingProcessor$12.L$2 = frameBody3;
                        defaultWebSocketSessionImpl$runIncomingProcessor$12.L$3 = closeFramePresented;
                        defaultWebSocketSessionImpl$runIncomingProcessor$12.L$4 = defaultWebSocketSessionImpl;
                        defaultWebSocketSessionImpl$runIncomingProcessor$12.L$5 = sendChannel4;
                        defaultWebSocketSessionImpl$runIncomingProcessor$12.L$6 = $this$consume$iv$iv;
                        defaultWebSocketSessionImpl$runIncomingProcessor$12.L$7 = it;
                        firstFrame7 = firstFrame;
                        defaultWebSocketSessionImpl$runIncomingProcessor$12.L$8 = null;
                        defaultWebSocketSessionImpl$runIncomingProcessor$12.label = 1;
                        hasNext = it.hasNext(defaultWebSocketSessionImpl$runIncomingProcessor$12);
                        if (hasNext == coroutine_suspended) {
                        }
                    } else {
                        frameBody8 = frameBody3;
                        z8 = z23;
                        z10 = z5;
                        z2 = z8;
                        defaultWebSocketSessionImpl = defaultWebSocketSessionImpl2;
                        cause$iv$iv = cause$iv$iv2;
                        $this$consume$iv$iv = $this$consume$iv$iv2;
                        z3 = z10;
                        frameBody3 = frameBody8;
                        $result = $result9;
                        Ref.ObjectRef objectRef2 = firstFrame2;
                        closeFramePresented = closeFramePresented2;
                        firstFrame = objectRef2;
                        defaultWebSocketSessionImpl$runIncomingProcessor$12.L$0 = $this$launch;
                        defaultWebSocketSessionImpl$runIncomingProcessor$12.L$1 = firstFrame;
                        defaultWebSocketSessionImpl$runIncomingProcessor$12.L$2 = frameBody3;
                        defaultWebSocketSessionImpl$runIncomingProcessor$12.L$3 = closeFramePresented;
                        defaultWebSocketSessionImpl$runIncomingProcessor$12.L$4 = defaultWebSocketSessionImpl;
                        defaultWebSocketSessionImpl$runIncomingProcessor$12.L$5 = sendChannel4;
                        defaultWebSocketSessionImpl$runIncomingProcessor$12.L$6 = $this$consume$iv$iv;
                        defaultWebSocketSessionImpl$runIncomingProcessor$12.L$7 = it;
                        firstFrame7 = firstFrame;
                        defaultWebSocketSessionImpl$runIncomingProcessor$12.L$8 = null;
                        defaultWebSocketSessionImpl$runIncomingProcessor$12.label = 1;
                        hasNext = it.hasNext(defaultWebSocketSessionImpl$runIncomingProcessor$12);
                        if (hasNext == coroutine_suspended) {
                        }
                    }
                } else if (frame2 instanceof Frame.Ping) {
                    defaultWebSocketSessionImpl$runIncomingProcessor$12.L$0 = $this$launch;
                    defaultWebSocketSessionImpl$runIncomingProcessor$12.L$1 = firstFrame2;
                    defaultWebSocketSessionImpl$runIncomingProcessor$12.L$2 = frameBody3;
                    defaultWebSocketSessionImpl$runIncomingProcessor$12.L$3 = closeFramePresented2;
                    defaultWebSocketSessionImpl$runIncomingProcessor$12.L$4 = defaultWebSocketSessionImpl2;
                    defaultWebSocketSessionImpl$runIncomingProcessor$12.L$5 = sendChannel4;
                    defaultWebSocketSessionImpl$runIncomingProcessor$12.L$6 = $this$consume$iv$iv2;
                    defaultWebSocketSessionImpl$runIncomingProcessor$12.L$7 = it;
                    defaultWebSocketSessionImpl$runIncomingProcessor$12.label = 5;
                    if (sendChannel4.send(frame2, defaultWebSocketSessionImpl$runIncomingProcessor$12) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    sendChannel6 = sendChannel4;
                    z11 = z;
                    defaultWebSocketSessionImpl4 = defaultWebSocketSessionImpl2;
                    cause$iv$iv4 = cause$iv$iv2;
                    $this$consume$iv$iv4 = $this$consume$iv$iv2;
                    firstFrame4 = firstFrame2;
                    $result7 = $result9;
                    z8 = z23;
                    closeFramePresented4 = closeFramePresented2;
                    frameBody6 = frameBody3;
                    z10 = z5;
                    Unit unit8 = Unit.INSTANCE;
                    $result9 = $result7;
                    frameBody8 = frameBody6;
                    closeFramePresented2 = closeFramePresented4;
                    firstFrame2 = firstFrame4;
                    $this$consume$iv$iv2 = $this$consume$iv$iv4;
                    cause$iv$iv2 = cause$iv$iv4;
                    defaultWebSocketSessionImpl2 = defaultWebSocketSessionImpl4;
                    z = z11;
                    sendChannel4 = sendChannel6;
                    z2 = z8;
                    defaultWebSocketSessionImpl = defaultWebSocketSessionImpl2;
                    cause$iv$iv = cause$iv$iv2;
                    $this$consume$iv$iv = $this$consume$iv$iv2;
                    z3 = z10;
                    frameBody3 = frameBody8;
                    $result = $result9;
                    Ref.ObjectRef objectRef22 = firstFrame2;
                    closeFramePresented = closeFramePresented2;
                    firstFrame = objectRef22;
                    defaultWebSocketSessionImpl$runIncomingProcessor$12.L$0 = $this$launch;
                    defaultWebSocketSessionImpl$runIncomingProcessor$12.L$1 = firstFrame;
                    defaultWebSocketSessionImpl$runIncomingProcessor$12.L$2 = frameBody3;
                    defaultWebSocketSessionImpl$runIncomingProcessor$12.L$3 = closeFramePresented;
                    defaultWebSocketSessionImpl$runIncomingProcessor$12.L$4 = defaultWebSocketSessionImpl;
                    defaultWebSocketSessionImpl$runIncomingProcessor$12.L$5 = sendChannel4;
                    defaultWebSocketSessionImpl$runIncomingProcessor$12.L$6 = $this$consume$iv$iv;
                    defaultWebSocketSessionImpl$runIncomingProcessor$12.L$7 = it;
                    firstFrame7 = firstFrame;
                    defaultWebSocketSessionImpl$runIncomingProcessor$12.L$8 = null;
                    defaultWebSocketSessionImpl$runIncomingProcessor$12.label = 1;
                    hasNext = it.hasNext(defaultWebSocketSessionImpl$runIncomingProcessor$12);
                    if (hasNext == coroutine_suspended) {
                    }
                } else {
                    defaultWebSocketSessionImpl$runIncomingProcessor$12.L$0 = $this$launch;
                    defaultWebSocketSessionImpl$runIncomingProcessor$12.L$1 = firstFrame2;
                    defaultWebSocketSessionImpl$runIncomingProcessor$12.L$2 = frameBody3;
                    defaultWebSocketSessionImpl$runIncomingProcessor$12.L$3 = closeFramePresented2;
                    defaultWebSocketSessionImpl$runIncomingProcessor$12.L$4 = defaultWebSocketSessionImpl2;
                    defaultWebSocketSessionImpl$runIncomingProcessor$12.L$5 = sendChannel4;
                    defaultWebSocketSessionImpl$runIncomingProcessor$12.L$6 = $this$consume$iv$iv2;
                    defaultWebSocketSessionImpl$runIncomingProcessor$12.L$7 = it;
                    defaultWebSocketSessionImpl$runIncomingProcessor$12.L$8 = frame2;
                    defaultWebSocketSessionImpl$runIncomingProcessor$12.label = 6;
                    checkMaxFrameSize = defaultWebSocketSessionImpl2.checkMaxFrameSize((Sink) frameBody3.element, frame2, defaultWebSocketSessionImpl$runIncomingProcessor$12);
                    if (checkMaxFrameSize == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    closeFramePresented5 = closeFramePresented2;
                    frameBody2 = frameBody3;
                    frame = frame2;
                    z12 = z23;
                    z15 = z5;
                    $result8 = $result9;
                    ChannelIterator channelIterator3 = it;
                    sendChannel7 = sendChannel4;
                    z13 = z;
                    channelIterator = channelIterator3;
                    ReceiveChannel receiveChannel2 = $this$consume$iv$iv2;
                    defaultWebSocketSessionImpl5 = defaultWebSocketSessionImpl2;
                    cause$iv$iv = cause$iv$iv2;
                    $this$consume$iv$iv = receiveChannel2;
                    try {
                        if (frame.getFin()) {
                            boolean z24 = z15;
                            try {
                                if (firstFrame2.element == null) {
                                    firstFrame2.element = frame;
                                }
                                if (frameBody2.element == null) {
                                    frameBody2.element = BytePacketBuilderKt.BytePacketBuilder();
                                }
                                Object obj4 = frameBody2.element;
                                Intrinsics.checkNotNull(obj4);
                                BytePacketBuilderKt.writeFully$default((Sink) obj4, frame.getData(), 0, 0, 6, (Object) null);
                                frameBody3 = frameBody2;
                                z2 = z12;
                                defaultWebSocketSessionImpl = defaultWebSocketSessionImpl5;
                                firstFrame = firstFrame2;
                                z3 = z24;
                                closeFramePresented = closeFramePresented5;
                                $result = $result8;
                                ChannelIterator channelIterator4 = channelIterator;
                                z = z13;
                                sendChannel4 = sendChannel7;
                                it = channelIterator4;
                                defaultWebSocketSessionImpl$runIncomingProcessor$12.L$0 = $this$launch;
                                defaultWebSocketSessionImpl$runIncomingProcessor$12.L$1 = firstFrame;
                                defaultWebSocketSessionImpl$runIncomingProcessor$12.L$2 = frameBody3;
                                defaultWebSocketSessionImpl$runIncomingProcessor$12.L$3 = closeFramePresented;
                                defaultWebSocketSessionImpl$runIncomingProcessor$12.L$4 = defaultWebSocketSessionImpl;
                                defaultWebSocketSessionImpl$runIncomingProcessor$12.L$5 = sendChannel4;
                                defaultWebSocketSessionImpl$runIncomingProcessor$12.L$6 = $this$consume$iv$iv;
                                defaultWebSocketSessionImpl$runIncomingProcessor$12.L$7 = it;
                                firstFrame7 = firstFrame;
                                defaultWebSocketSessionImpl$runIncomingProcessor$12.L$8 = null;
                                defaultWebSocketSessionImpl$runIncomingProcessor$12.label = 1;
                                hasNext = it.hasNext(defaultWebSocketSessionImpl$runIncomingProcessor$12);
                                if (hasNext == coroutine_suspended) {
                                }
                            } catch (Throwable th13) {
                                e$iv$iv = th13;
                                closeFramePresented = closeFramePresented5;
                                $result = $result8;
                            }
                        } else {
                            z18 = z15;
                            if (firstFrame2.element == null) {
                                try {
                                    try {
                                        channel3 = defaultWebSocketSessionImpl5.filtered;
                                        processIncomingExtensions2 = defaultWebSocketSessionImpl5.processIncomingExtensions(frame);
                                        defaultWebSocketSessionImpl$runIncomingProcessor$12.L$0 = $this$launch;
                                        defaultWebSocketSessionImpl$runIncomingProcessor$12.L$1 = firstFrame2;
                                        defaultWebSocketSessionImpl$runIncomingProcessor$12.L$2 = frameBody2;
                                        defaultWebSocketSessionImpl$runIncomingProcessor$12.L$3 = closeFramePresented5;
                                        defaultWebSocketSessionImpl$runIncomingProcessor$12.L$4 = defaultWebSocketSessionImpl5;
                                        defaultWebSocketSessionImpl$runIncomingProcessor$12.L$5 = sendChannel7;
                                        defaultWebSocketSessionImpl$runIncomingProcessor$12.L$6 = $this$consume$iv$iv;
                                        defaultWebSocketSessionImpl$runIncomingProcessor$12.L$7 = channelIterator;
                                        defaultWebSocketSessionImpl$runIncomingProcessor$12.L$8 = null;
                                        defaultWebSocketSessionImpl$runIncomingProcessor$12.label = 7;
                                        if (channel3.send(processIncomingExtensions2, defaultWebSocketSessionImpl$runIncomingProcessor$12) == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        channelIterator2 = channelIterator;
                                        sendChannel8 = sendChannel7;
                                        defaultWebSocketSessionImpl6 = defaultWebSocketSessionImpl5;
                                        firstFrame5 = firstFrame2;
                                        z16 = z21;
                                        z17 = z22;
                                        frameBody7 = frameBody2;
                                        closeFramePresented = closeFramePresented5;
                                        $result = $result8;
                                        obj3 = coroutine_suspended;
                                        defaultWebSocketSessionImpl$runIncomingProcessor$1 = defaultWebSocketSessionImpl$runIncomingProcessor$12;
                                        $this$launch2 = $this$launch;
                                        $this$launch = $this$launch2;
                                        defaultWebSocketSessionImpl$runIncomingProcessor$12 = defaultWebSocketSessionImpl$runIncomingProcessor$1;
                                        coroutine_suspended = obj3;
                                        firstFrame = firstFrame5;
                                        z3 = z18;
                                        Ref.ObjectRef objectRef3 = frameBody7;
                                        it = channelIterator2;
                                        frameBody3 = objectRef3;
                                        boolean z25 = z17;
                                        sendChannel4 = sendChannel8;
                                        z2 = z16;
                                        defaultWebSocketSessionImpl = defaultWebSocketSessionImpl6;
                                        z = z25;
                                        defaultWebSocketSessionImpl$runIncomingProcessor$12.L$0 = $this$launch;
                                        defaultWebSocketSessionImpl$runIncomingProcessor$12.L$1 = firstFrame;
                                        defaultWebSocketSessionImpl$runIncomingProcessor$12.L$2 = frameBody3;
                                        defaultWebSocketSessionImpl$runIncomingProcessor$12.L$3 = closeFramePresented;
                                        defaultWebSocketSessionImpl$runIncomingProcessor$12.L$4 = defaultWebSocketSessionImpl;
                                        defaultWebSocketSessionImpl$runIncomingProcessor$12.L$5 = sendChannel4;
                                        defaultWebSocketSessionImpl$runIncomingProcessor$12.L$6 = $this$consume$iv$iv;
                                        defaultWebSocketSessionImpl$runIncomingProcessor$12.L$7 = it;
                                        firstFrame7 = firstFrame;
                                        defaultWebSocketSessionImpl$runIncomingProcessor$12.L$8 = null;
                                        defaultWebSocketSessionImpl$runIncomingProcessor$12.label = 1;
                                        hasNext = it.hasNext(defaultWebSocketSessionImpl$runIncomingProcessor$12);
                                        if (hasNext == coroutine_suspended) {
                                        }
                                    } catch (Throwable th14) {
                                        e$iv$iv = th14;
                                        closeFramePresented = closeFramePresented5;
                                        $result = $result8;
                                    }
                                    z22 = z13;
                                } catch (Throwable th15) {
                                    e$iv$iv = th15;
                                    closeFramePresented = closeFramePresented5;
                                    $result = $result8;
                                }
                                z21 = z12;
                            } else {
                                boolean z26 = z12;
                                boolean z27 = z13;
                                Object obj5 = frameBody2.element;
                                Intrinsics.checkNotNull(obj5);
                                BytePacketBuilderKt.writeFully$default((Sink) obj5, frame.getData(), 0, 0, 6, (Object) null);
                                Frame.Companion companion = Frame.Companion;
                                Object obj6 = firstFrame2.element;
                                Intrinsics.checkNotNull(obj6);
                                FrameType frameType = ((Frame) obj6).getFrameType();
                                Object obj7 = frameBody2.element;
                                Intrinsics.checkNotNull(obj7);
                                byte[] readByteArray = SourcesKt.readByteArray(BytePacketBuilderKt.build((Sink) obj7));
                                Object obj8 = firstFrame2.element;
                                Intrinsics.checkNotNull(obj8);
                                boolean rsv1 = ((Frame) obj8).getRsv1();
                                Object obj9 = firstFrame2.element;
                                Intrinsics.checkNotNull(obj9);
                                boolean rsv2 = ((Frame) obj9).getRsv2();
                                Object obj10 = firstFrame2.element;
                                Intrinsics.checkNotNull(obj10);
                                Frame defragmented = companion.byType(true, frameType, readByteArray, rsv1, rsv2, ((Frame) obj10).getRsv3());
                                firstFrame2.element = null;
                                channel2 = defaultWebSocketSessionImpl5.filtered;
                                processIncomingExtensions = defaultWebSocketSessionImpl5.processIncomingExtensions(defragmented);
                                defaultWebSocketSessionImpl$runIncomingProcessor$12.L$0 = $this$launch;
                                defaultWebSocketSessionImpl$runIncomingProcessor$12.L$1 = firstFrame2;
                                defaultWebSocketSessionImpl$runIncomingProcessor$12.L$2 = frameBody2;
                                defaultWebSocketSessionImpl$runIncomingProcessor$12.L$3 = closeFramePresented5;
                                defaultWebSocketSessionImpl$runIncomingProcessor$12.L$4 = defaultWebSocketSessionImpl5;
                                defaultWebSocketSessionImpl$runIncomingProcessor$12.L$5 = sendChannel7;
                                defaultWebSocketSessionImpl$runIncomingProcessor$12.L$6 = $this$consume$iv$iv;
                                defaultWebSocketSessionImpl$runIncomingProcessor$12.L$7 = channelIterator;
                                defaultWebSocketSessionImpl$runIncomingProcessor$12.L$8 = null;
                                defaultWebSocketSessionImpl$runIncomingProcessor$12.label = 8;
                                if (channel2.send(processIncomingExtensions, defaultWebSocketSessionImpl$runIncomingProcessor$12) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                firstFrame6 = firstFrame2;
                                z19 = z18;
                                z8 = z26;
                                z20 = z27;
                                closeFramePresented = closeFramePresented5;
                                $result = $result8;
                                try {
                                    Unit unit9 = Unit.INSTANCE;
                                    $result9 = $result;
                                    frameBody8 = frameBody2;
                                    closeFramePresented2 = closeFramePresented;
                                    firstFrame2 = firstFrame6;
                                    z10 = z19;
                                    ChannelIterator channelIterator5 = channelIterator;
                                    z = z20;
                                    sendChannel4 = sendChannel7;
                                    it = channelIterator5;
                                    ReceiveChannel receiveChannel3 = $this$consume$iv$iv;
                                    cause$iv$iv2 = cause$iv$iv;
                                    defaultWebSocketSessionImpl2 = defaultWebSocketSessionImpl5;
                                    $this$consume$iv$iv2 = receiveChannel3;
                                    z2 = z8;
                                    defaultWebSocketSessionImpl = defaultWebSocketSessionImpl2;
                                    cause$iv$iv = cause$iv$iv2;
                                    $this$consume$iv$iv = $this$consume$iv$iv2;
                                    z3 = z10;
                                    frameBody3 = frameBody8;
                                    $result = $result9;
                                    Ref.ObjectRef objectRef222 = firstFrame2;
                                    closeFramePresented = closeFramePresented2;
                                    firstFrame = objectRef222;
                                    defaultWebSocketSessionImpl$runIncomingProcessor$12.L$0 = $this$launch;
                                    defaultWebSocketSessionImpl$runIncomingProcessor$12.L$1 = firstFrame;
                                    defaultWebSocketSessionImpl$runIncomingProcessor$12.L$2 = frameBody3;
                                    defaultWebSocketSessionImpl$runIncomingProcessor$12.L$3 = closeFramePresented;
                                    defaultWebSocketSessionImpl$runIncomingProcessor$12.L$4 = defaultWebSocketSessionImpl;
                                    defaultWebSocketSessionImpl$runIncomingProcessor$12.L$5 = sendChannel4;
                                    defaultWebSocketSessionImpl$runIncomingProcessor$12.L$6 = $this$consume$iv$iv;
                                    defaultWebSocketSessionImpl$runIncomingProcessor$12.L$7 = it;
                                    firstFrame7 = firstFrame;
                                    defaultWebSocketSessionImpl$runIncomingProcessor$12.L$8 = null;
                                    defaultWebSocketSessionImpl$runIncomingProcessor$12.label = 1;
                                    hasNext = it.hasNext(defaultWebSocketSessionImpl$runIncomingProcessor$12);
                                    if (hasNext == coroutine_suspended) {
                                    }
                                } catch (Throwable th16) {
                                    e$iv$iv = th16;
                                }
                            }
                        }
                    } catch (Throwable th17) {
                        e$iv$iv = th17;
                        closeFramePresented = closeFramePresented5;
                        $result = $result8;
                    }
                    Throwable cause$iv$iv5 = e$iv$iv;
                    try {
                        throw e$iv$iv;
                    } catch (Throwable e$iv$iv) {
                        try {
                            ChannelsKt.cancelConsumed($this$consume$iv$iv, cause$iv$iv5);
                            throw e$iv$iv;
                        } catch (ClosedSendChannelException e4) {
                            frameBody3 = frameBody2;
                            $result2 = $result;
                            SendChannel.DefaultImpls.close$default(defaultWebSocketSessionImpl$runIncomingProcessor$12.$ponger, (Throwable) null, 1, (Object) null);
                            sink2 = (Sink) frameBody3.element;
                            if (sink2 != null) {
                            }
                            sendChannel3 = defaultWebSocketSessionImpl$runIncomingProcessor$12.this$0.filtered;
                            SendChannel.DefaultImpls.close$default(sendChannel3, (Throwable) null, 1, (Object) null);
                            if (closeFramePresented.element) {
                            }
                        } catch (Throwable th18) {
                            cause = th18;
                            frameBody3 = frameBody2;
                            SendChannel.DefaultImpls.close$default(defaultWebSocketSessionImpl$runIncomingProcessor$12.$ponger, (Throwable) null, 1, (Object) null);
                            channel = defaultWebSocketSessionImpl$runIncomingProcessor$12.this$0.filtered;
                            channel.close(cause);
                            SendChannel.DefaultImpls.close$default(defaultWebSocketSessionImpl$runIncomingProcessor$12.$ponger, (Throwable) null, 1, (Object) null);
                            sink = (Sink) frameBody3.element;
                            if (sink != null) {
                            }
                            sendChannel2 = defaultWebSocketSessionImpl$runIncomingProcessor$12.this$0.filtered;
                            SendChannel.DefaultImpls.close$default(sendChannel2, (Throwable) null, 1, (Object) null);
                            if (!closeFramePresented.element) {
                            }
                            return Unit.INSTANCE;
                        }
                    }
                }
            case 1:
                $result = obj;
                z4 = false;
                ChannelIterator channelIterator6 = (ChannelIterator) defaultWebSocketSessionImpl$runIncomingProcessor$12.L$7;
                ReceiveChannel $this$consume$iv$iv5 = (ReceiveChannel) defaultWebSocketSessionImpl$runIncomingProcessor$12.L$6;
                $this$consume$iv$iv = $this$consume$iv$iv5;
                SendChannel<Frame.Ping> sendChannel12 = (SendChannel) defaultWebSocketSessionImpl$runIncomingProcessor$12.L$5;
                DefaultWebSocketSessionImpl defaultWebSocketSessionImpl7 = (DefaultWebSocketSessionImpl) defaultWebSocketSessionImpl$runIncomingProcessor$12.L$4;
                closeFramePresented = (Ref.BooleanRef) defaultWebSocketSessionImpl$runIncomingProcessor$12.L$3;
                Ref.ObjectRef frameBody9 = (Ref.ObjectRef) defaultWebSocketSessionImpl$runIncomingProcessor$12.L$2;
                Ref.ObjectRef firstFrame8 = (Ref.ObjectRef) defaultWebSocketSessionImpl$runIncomingProcessor$12.L$1;
                CoroutineScope $this$launch3 = (CoroutineScope) defaultWebSocketSessionImpl$runIncomingProcessor$12.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    z5 = false;
                    $this$launch = $this$launch3;
                    $this$consume$iv$iv2 = $this$consume$iv$iv;
                    cause$iv$iv2 = null;
                    defaultWebSocketSessionImpl2 = defaultWebSocketSessionImpl7;
                    obj2 = $result;
                    it = channelIterator6;
                    closeFramePresented2 = closeFramePresented;
                    firstFrame2 = firstFrame8;
                    sendChannel4 = sendChannel12;
                    frameBody3 = frameBody9;
                    z = false;
                    if (((Boolean) obj2).booleanValue()) {
                    }
                } catch (Throwable th19) {
                    e$iv$iv = th19;
                    frameBody2 = frameBody9;
                    break;
                }
                break;
            case 2:
                $result = obj;
                z6 = false;
                z7 = false;
                receiveChannel = (ReceiveChannel) defaultWebSocketSessionImpl$runIncomingProcessor$12.L$2;
                closeFramePresented = (Ref.BooleanRef) defaultWebSocketSessionImpl$runIncomingProcessor$12.L$1;
                frameBody4 = (Ref.ObjectRef) defaultWebSocketSessionImpl$runIncomingProcessor$12.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    cause$iv$iv2 = null;
                    $this$consume$iv$iv2 = receiveChannel;
                    frameBody3 = frameBody4;
                    closeFramePresented.element = true;
                    Object $result1122 = Unit.INSTANCE;
                    ChannelsKt.cancelConsumed($this$consume$iv$iv2, cause$iv$iv2);
                    SendChannel.DefaultImpls.close$default(defaultWebSocketSessionImpl$runIncomingProcessor$12.$ponger, (Throwable) null, 1, (Object) null);
                    sink3 = (Sink) frameBody3.element;
                    if (sink3 != null) {
                    }
                    sendChannel9 = defaultWebSocketSessionImpl$runIncomingProcessor$12.this$0.filtered;
                    SendChannel.DefaultImpls.close$default(sendChannel9, (Throwable) null, 1, (Object) null);
                    if (closeFramePresented.element) {
                    }
                } catch (Throwable th20) {
                    e$iv$iv = th20;
                    $this$consume$iv$iv = receiveChannel;
                    frameBody2 = frameBody4;
                    break;
                }
                break;
            case 3:
                $result4 = obj;
                $result5 = (Unit) defaultWebSocketSessionImpl$runIncomingProcessor$12.L$0;
                ResultKt.throwOnFailure($result4);
                return $result5;
            case 4:
                $result6 = obj;
                z8 = false;
                z9 = false;
                ChannelIterator channelIterator7 = (ChannelIterator) defaultWebSocketSessionImpl$runIncomingProcessor$12.L$7;
                cause$iv$iv3 = null;
                ReceiveChannel $this$consume$iv$iv6 = (ReceiveChannel) defaultWebSocketSessionImpl$runIncomingProcessor$12.L$6;
                $this$consume$iv$iv3 = $this$consume$iv$iv6;
                sendChannel5 = (SendChannel) defaultWebSocketSessionImpl$runIncomingProcessor$12.L$5;
                defaultWebSocketSessionImpl3 = (DefaultWebSocketSessionImpl) defaultWebSocketSessionImpl$runIncomingProcessor$12.L$4;
                closeFramePresented3 = (Ref.BooleanRef) defaultWebSocketSessionImpl$runIncomingProcessor$12.L$3;
                Ref.ObjectRef frameBody10 = (Ref.ObjectRef) defaultWebSocketSessionImpl$runIncomingProcessor$12.L$2;
                firstFrame3 = (Ref.ObjectRef) defaultWebSocketSessionImpl$runIncomingProcessor$12.L$1;
                $this$launch = (CoroutineScope) defaultWebSocketSessionImpl$runIncomingProcessor$12.L$0;
                ResultKt.throwOnFailure($result6);
                z10 = false;
                frameBody5 = frameBody10;
                it = channelIterator7;
                Unit unit72 = Unit.INSTANCE;
                $result9 = $result6;
                frameBody8 = frameBody5;
                closeFramePresented2 = closeFramePresented3;
                firstFrame2 = firstFrame3;
                $this$consume$iv$iv2 = $this$consume$iv$iv3;
                cause$iv$iv2 = cause$iv$iv3;
                defaultWebSocketSessionImpl2 = defaultWebSocketSessionImpl3;
                z = z9;
                sendChannel4 = sendChannel5;
                z2 = z8;
                defaultWebSocketSessionImpl = defaultWebSocketSessionImpl2;
                cause$iv$iv = cause$iv$iv2;
                $this$consume$iv$iv = $this$consume$iv$iv2;
                z3 = z10;
                frameBody3 = frameBody8;
                $result = $result9;
                Ref.ObjectRef objectRef2222 = firstFrame2;
                closeFramePresented = closeFramePresented2;
                firstFrame = objectRef2222;
                defaultWebSocketSessionImpl$runIncomingProcessor$12.L$0 = $this$launch;
                defaultWebSocketSessionImpl$runIncomingProcessor$12.L$1 = firstFrame;
                defaultWebSocketSessionImpl$runIncomingProcessor$12.L$2 = frameBody3;
                defaultWebSocketSessionImpl$runIncomingProcessor$12.L$3 = closeFramePresented;
                defaultWebSocketSessionImpl$runIncomingProcessor$12.L$4 = defaultWebSocketSessionImpl;
                defaultWebSocketSessionImpl$runIncomingProcessor$12.L$5 = sendChannel4;
                defaultWebSocketSessionImpl$runIncomingProcessor$12.L$6 = $this$consume$iv$iv;
                defaultWebSocketSessionImpl$runIncomingProcessor$12.L$7 = it;
                firstFrame7 = firstFrame;
                defaultWebSocketSessionImpl$runIncomingProcessor$12.L$8 = null;
                defaultWebSocketSessionImpl$runIncomingProcessor$12.label = 1;
                hasNext = it.hasNext(defaultWebSocketSessionImpl$runIncomingProcessor$12);
                if (hasNext == coroutine_suspended) {
                }
                break;
            case 5:
                $result7 = obj;
                z8 = false;
                z11 = false;
                ChannelIterator channelIterator8 = (ChannelIterator) defaultWebSocketSessionImpl$runIncomingProcessor$12.L$7;
                cause$iv$iv4 = null;
                ReceiveChannel $this$consume$iv$iv7 = (ReceiveChannel) defaultWebSocketSessionImpl$runIncomingProcessor$12.L$6;
                $this$consume$iv$iv4 = $this$consume$iv$iv7;
                sendChannel6 = (SendChannel) defaultWebSocketSessionImpl$runIncomingProcessor$12.L$5;
                defaultWebSocketSessionImpl4 = (DefaultWebSocketSessionImpl) defaultWebSocketSessionImpl$runIncomingProcessor$12.L$4;
                closeFramePresented4 = (Ref.BooleanRef) defaultWebSocketSessionImpl$runIncomingProcessor$12.L$3;
                Ref.ObjectRef frameBody11 = (Ref.ObjectRef) defaultWebSocketSessionImpl$runIncomingProcessor$12.L$2;
                firstFrame4 = (Ref.ObjectRef) defaultWebSocketSessionImpl$runIncomingProcessor$12.L$1;
                $this$launch = (CoroutineScope) defaultWebSocketSessionImpl$runIncomingProcessor$12.L$0;
                ResultKt.throwOnFailure($result7);
                z10 = false;
                frameBody6 = frameBody11;
                it = channelIterator8;
                Unit unit82 = Unit.INSTANCE;
                $result9 = $result7;
                frameBody8 = frameBody6;
                closeFramePresented2 = closeFramePresented4;
                firstFrame2 = firstFrame4;
                $this$consume$iv$iv2 = $this$consume$iv$iv4;
                cause$iv$iv2 = cause$iv$iv4;
                defaultWebSocketSessionImpl2 = defaultWebSocketSessionImpl4;
                z = z11;
                sendChannel4 = sendChannel6;
                z2 = z8;
                defaultWebSocketSessionImpl = defaultWebSocketSessionImpl2;
                cause$iv$iv = cause$iv$iv2;
                $this$consume$iv$iv = $this$consume$iv$iv2;
                z3 = z10;
                frameBody3 = frameBody8;
                $result = $result9;
                Ref.ObjectRef objectRef22222 = firstFrame2;
                closeFramePresented = closeFramePresented2;
                firstFrame = objectRef22222;
                defaultWebSocketSessionImpl$runIncomingProcessor$12.L$0 = $this$launch;
                defaultWebSocketSessionImpl$runIncomingProcessor$12.L$1 = firstFrame;
                defaultWebSocketSessionImpl$runIncomingProcessor$12.L$2 = frameBody3;
                defaultWebSocketSessionImpl$runIncomingProcessor$12.L$3 = closeFramePresented;
                defaultWebSocketSessionImpl$runIncomingProcessor$12.L$4 = defaultWebSocketSessionImpl;
                defaultWebSocketSessionImpl$runIncomingProcessor$12.L$5 = sendChannel4;
                defaultWebSocketSessionImpl$runIncomingProcessor$12.L$6 = $this$consume$iv$iv;
                defaultWebSocketSessionImpl$runIncomingProcessor$12.L$7 = it;
                firstFrame7 = firstFrame;
                defaultWebSocketSessionImpl$runIncomingProcessor$12.L$8 = null;
                defaultWebSocketSessionImpl$runIncomingProcessor$12.label = 1;
                hasNext = it.hasNext(defaultWebSocketSessionImpl$runIncomingProcessor$12);
                if (hasNext == coroutine_suspended) {
                }
                break;
            case 6:
                $result = obj;
                z12 = false;
                z13 = false;
                frame = (Frame) defaultWebSocketSessionImpl$runIncomingProcessor$12.L$8;
                ChannelIterator channelIterator9 = (ChannelIterator) defaultWebSocketSessionImpl$runIncomingProcessor$12.L$7;
                cause$iv$iv = null;
                ReceiveChannel $this$consume$iv$iv8 = (ReceiveChannel) defaultWebSocketSessionImpl$runIncomingProcessor$12.L$6;
                $this$consume$iv$iv = $this$consume$iv$iv8;
                SendChannel<Frame.Ping> sendChannel13 = (SendChannel) defaultWebSocketSessionImpl$runIncomingProcessor$12.L$5;
                DefaultWebSocketSessionImpl defaultWebSocketSessionImpl8 = (DefaultWebSocketSessionImpl) defaultWebSocketSessionImpl$runIncomingProcessor$12.L$4;
                closeFramePresented = (Ref.BooleanRef) defaultWebSocketSessionImpl$runIncomingProcessor$12.L$3;
                Ref.ObjectRef frameBody12 = (Ref.ObjectRef) defaultWebSocketSessionImpl$runIncomingProcessor$12.L$2;
                Ref.ObjectRef firstFrame9 = (Ref.ObjectRef) defaultWebSocketSessionImpl$runIncomingProcessor$12.L$1;
                $this$launch = (CoroutineScope) defaultWebSocketSessionImpl$runIncomingProcessor$12.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    z14 = false;
                    $result8 = $result;
                    closeFramePresented5 = closeFramePresented;
                    firstFrame2 = firstFrame9;
                    z15 = false;
                    frameBody2 = frameBody12;
                    defaultWebSocketSessionImpl5 = defaultWebSocketSessionImpl8;
                    sendChannel7 = sendChannel13;
                    channelIterator = channelIterator9;
                    if (frame.getFin()) {
                    }
                } catch (Throwable th21) {
                    e$iv$iv = th21;
                    frameBody2 = frameBody12;
                }
                Throwable cause$iv$iv52 = e$iv$iv;
                throw e$iv$iv;
            case 7:
                $result = obj;
                z16 = false;
                z17 = false;
                channelIterator2 = (ChannelIterator) defaultWebSocketSessionImpl$runIncomingProcessor$12.L$7;
                cause$iv$iv = null;
                ReceiveChannel $this$consume$iv$iv9 = (ReceiveChannel) defaultWebSocketSessionImpl$runIncomingProcessor$12.L$6;
                $this$consume$iv$iv = $this$consume$iv$iv9;
                sendChannel8 = (SendChannel) defaultWebSocketSessionImpl$runIncomingProcessor$12.L$5;
                defaultWebSocketSessionImpl6 = (DefaultWebSocketSessionImpl) defaultWebSocketSessionImpl$runIncomingProcessor$12.L$4;
                closeFramePresented = (Ref.BooleanRef) defaultWebSocketSessionImpl$runIncomingProcessor$12.L$3;
                frameBody7 = (Ref.ObjectRef) defaultWebSocketSessionImpl$runIncomingProcessor$12.L$2;
                firstFrame5 = (Ref.ObjectRef) defaultWebSocketSessionImpl$runIncomingProcessor$12.L$1;
                CoroutineScope $this$launch4 = (CoroutineScope) defaultWebSocketSessionImpl$runIncomingProcessor$12.L$0;
                ResultKt.throwOnFailure($result);
                z18 = false;
                obj3 = coroutine_suspended;
                defaultWebSocketSessionImpl$runIncomingProcessor$1 = defaultWebSocketSessionImpl$runIncomingProcessor$12;
                $this$launch2 = $this$launch4;
                $this$launch = $this$launch2;
                defaultWebSocketSessionImpl$runIncomingProcessor$12 = defaultWebSocketSessionImpl$runIncomingProcessor$1;
                coroutine_suspended = obj3;
                firstFrame = firstFrame5;
                z3 = z18;
                Ref.ObjectRef objectRef32 = frameBody7;
                it = channelIterator2;
                frameBody3 = objectRef32;
                boolean z252 = z17;
                sendChannel4 = sendChannel8;
                z2 = z16;
                defaultWebSocketSessionImpl = defaultWebSocketSessionImpl6;
                z = z252;
                defaultWebSocketSessionImpl$runIncomingProcessor$12.L$0 = $this$launch;
                defaultWebSocketSessionImpl$runIncomingProcessor$12.L$1 = firstFrame;
                defaultWebSocketSessionImpl$runIncomingProcessor$12.L$2 = frameBody3;
                defaultWebSocketSessionImpl$runIncomingProcessor$12.L$3 = closeFramePresented;
                defaultWebSocketSessionImpl$runIncomingProcessor$12.L$4 = defaultWebSocketSessionImpl;
                defaultWebSocketSessionImpl$runIncomingProcessor$12.L$5 = sendChannel4;
                defaultWebSocketSessionImpl$runIncomingProcessor$12.L$6 = $this$consume$iv$iv;
                defaultWebSocketSessionImpl$runIncomingProcessor$12.L$7 = it;
                firstFrame7 = firstFrame;
                defaultWebSocketSessionImpl$runIncomingProcessor$12.L$8 = null;
                defaultWebSocketSessionImpl$runIncomingProcessor$12.label = 1;
                hasNext = it.hasNext(defaultWebSocketSessionImpl$runIncomingProcessor$12);
                if (hasNext == coroutine_suspended) {
                }
                break;
            case 8:
                $result = obj;
                z19 = false;
                z8 = false;
                z20 = false;
                channelIterator = (ChannelIterator) defaultWebSocketSessionImpl$runIncomingProcessor$12.L$7;
                cause$iv$iv = null;
                $this$consume$iv$iv = (ReceiveChannel) defaultWebSocketSessionImpl$runIncomingProcessor$12.L$6;
                sendChannel7 = (SendChannel) defaultWebSocketSessionImpl$runIncomingProcessor$12.L$5;
                defaultWebSocketSessionImpl5 = (DefaultWebSocketSessionImpl) defaultWebSocketSessionImpl$runIncomingProcessor$12.L$4;
                closeFramePresented = (Ref.BooleanRef) defaultWebSocketSessionImpl$runIncomingProcessor$12.L$3;
                frameBody2 = (Ref.ObjectRef) defaultWebSocketSessionImpl$runIncomingProcessor$12.L$2;
                firstFrame6 = (Ref.ObjectRef) defaultWebSocketSessionImpl$runIncomingProcessor$12.L$1;
                $this$launch = (CoroutineScope) defaultWebSocketSessionImpl$runIncomingProcessor$12.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    Unit unit92 = Unit.INSTANCE;
                    $result9 = $result;
                    frameBody8 = frameBody2;
                    closeFramePresented2 = closeFramePresented;
                    firstFrame2 = firstFrame6;
                    z10 = z19;
                    ChannelIterator channelIterator52 = channelIterator;
                    z = z20;
                    sendChannel4 = sendChannel7;
                    it = channelIterator52;
                    ReceiveChannel receiveChannel32 = $this$consume$iv$iv;
                    cause$iv$iv2 = cause$iv$iv;
                    defaultWebSocketSessionImpl2 = defaultWebSocketSessionImpl5;
                    $this$consume$iv$iv2 = receiveChannel32;
                    z2 = z8;
                    defaultWebSocketSessionImpl = defaultWebSocketSessionImpl2;
                    cause$iv$iv = cause$iv$iv2;
                    $this$consume$iv$iv = $this$consume$iv$iv2;
                    z3 = z10;
                    frameBody3 = frameBody8;
                    $result = $result9;
                    Ref.ObjectRef objectRef222222 = firstFrame2;
                    closeFramePresented = closeFramePresented2;
                    firstFrame = objectRef222222;
                    defaultWebSocketSessionImpl$runIncomingProcessor$12.L$0 = $this$launch;
                    defaultWebSocketSessionImpl$runIncomingProcessor$12.L$1 = firstFrame;
                    defaultWebSocketSessionImpl$runIncomingProcessor$12.L$2 = frameBody3;
                    defaultWebSocketSessionImpl$runIncomingProcessor$12.L$3 = closeFramePresented;
                    defaultWebSocketSessionImpl$runIncomingProcessor$12.L$4 = defaultWebSocketSessionImpl;
                    defaultWebSocketSessionImpl$runIncomingProcessor$12.L$5 = sendChannel4;
                    defaultWebSocketSessionImpl$runIncomingProcessor$12.L$6 = $this$consume$iv$iv;
                    defaultWebSocketSessionImpl$runIncomingProcessor$12.L$7 = it;
                    firstFrame7 = firstFrame;
                    defaultWebSocketSessionImpl$runIncomingProcessor$12.L$8 = null;
                    defaultWebSocketSessionImpl$runIncomingProcessor$12.label = 1;
                    hasNext = it.hasNext(defaultWebSocketSessionImpl$runIncomingProcessor$12);
                    if (hasNext == coroutine_suspended) {
                    }
                } catch (Throwable th22) {
                    e$iv$iv = th22;
                    break;
                }
                break;
            case 9:
            case 10:
            case 11:
                $result2 = obj;
                ResultKt.throwOnFailure($result2);
                return Unit.INSTANCE;
            case 12:
                $result3 = obj;
                th = (Throwable) defaultWebSocketSessionImpl$runIncomingProcessor$12.L$0;
                ResultKt.throwOnFailure($result3);
                throw th;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}