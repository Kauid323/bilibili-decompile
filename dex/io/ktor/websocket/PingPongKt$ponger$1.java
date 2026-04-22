package io.ktor.websocket;

import com.bilibili.doraemonkit.widget.tableview.bean.Column;
import io.ktor.websocket.Frame;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelsKt;
import kotlinx.coroutines.channels.ClosedSendChannelException;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.SendChannel;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PingPong.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", Column.INVAL_VALUE, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.websocket.PingPongKt$ponger$1", f = "PingPong.kt", i = {0, 1}, l = {117, 32}, m = "invokeSuspend", n = {"$this$consume$iv$iv", "$this$consume$iv$iv"}, s = {"L$1", "L$1"})
public final class PingPongKt$ponger$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Channel<Frame.Ping> $channel;
    final /* synthetic */ SendChannel<Frame.Pong> $outgoing;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public PingPongKt$ponger$1(Channel<Frame.Ping> channel, SendChannel<? super Frame.Pong> sendChannel, Continuation<? super PingPongKt$ponger$1> continuation) {
        super(2, continuation);
        this.$channel = channel;
        this.$outgoing = sendChannel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PingPongKt$ponger$1(this.$channel, this.$outgoing, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0080 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0090 A[Catch: all -> 0x00d3, TryCatch #3 {all -> 0x00d3, blocks: (B:23:0x0088, B:25:0x0090, B:30:0x00c6), top: B:59:0x0088 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00c6 A[Catch: all -> 0x00d3, TRY_LEAVE, TryCatch #3 {all -> 0x00d3, blocks: (B:23:0x0088, B:25:0x0090, B:30:0x00c6), top: B:59:0x0088 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x00bc -> B:29:0x00c1). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        ReceiveChannel $this$consume$iv$iv;
        Object $result;
        SendChannel<Frame.Pong> sendChannel;
        Throwable cause$iv$iv;
        ChannelIterator it;
        PingPongKt$ponger$1 pingPongKt$ponger$1;
        boolean z;
        boolean z2;
        Object $result2;
        SendChannel<Frame.Pong> sendChannel2;
        boolean z3;
        Object $result3;
        Object $result4;
        Object $result5;
        Object hasNext;
        PingPongKt$ponger$1 pingPongKt$ponger$12 = this;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = pingPongKt$ponger$12.label;
        try {
            switch (i) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    $result = obj;
                    try {
                        ReceiveChannel $this$consumeEach$iv = (ReceiveChannel) pingPongKt$ponger$12.$channel;
                        sendChannel = pingPongKt$ponger$12.$outgoing;
                        $this$consume$iv$iv = $this$consumeEach$iv;
                        cause$iv$iv = null;
                        try {
                            it = $this$consume$iv$iv.iterator();
                            pingPongKt$ponger$1 = pingPongKt$ponger$12;
                            z = false;
                            z2 = false;
                            $result5 = $result;
                            try {
                                pingPongKt$ponger$1.L$0 = sendChannel;
                                pingPongKt$ponger$1.L$1 = $this$consume$iv$iv;
                                pingPongKt$ponger$1.L$2 = it;
                                pingPongKt$ponger$1.label = 1;
                                hasNext = it.hasNext(pingPongKt$ponger$1);
                            } catch (Throwable th) {
                                e$iv$iv = th;
                                $result = $result5;
                                Throwable cause$iv$iv2 = e$iv$iv;
                                try {
                                    throw e$iv$iv;
                                } catch (Throwable e$iv$iv) {
                                    try {
                                        ChannelsKt.cancelConsumed($this$consume$iv$iv, cause$iv$iv2);
                                        throw e$iv$iv;
                                    } catch (ClosedSendChannelException e) {
                                        return Unit.INSTANCE;
                                    }
                                }
                            }
                        } catch (Throwable th2) {
                            e$iv$iv = th2;
                            $result = $result;
                            Throwable cause$iv$iv22 = e$iv$iv;
                            throw e$iv$iv;
                        }
                    } catch (ClosedSendChannelException e2) {
                        return Unit.INSTANCE;
                    }
                    if (hasNext == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    boolean z4 = z2;
                    $result3 = $result5;
                    $result2 = hasNext;
                    sendChannel2 = sendChannel;
                    z3 = z4;
                    try {
                        if (((Boolean) $result2).booleanValue()) {
                            Unit unit = Unit.INSTANCE;
                            try {
                                ChannelsKt.cancelConsumed($this$consume$iv$iv, cause$iv$iv);
                            } catch (ClosedSendChannelException e3) {
                                $result = $result3;
                                return Unit.INSTANCE;
                            }
                            return Unit.INSTANCE;
                        }
                        Object e$iv = it.next();
                        Frame.Ping it2 = (Frame.Ping) e$iv;
                        DefaultWebSocketSessionKt.getLOGGER().trace("Received ping message, sending pong message");
                        Frame.Pong pong = new Frame.Pong(it2.getData(), (DisposableHandle) null, 2, (DefaultConstructorMarker) null);
                        pingPongKt$ponger$1.L$0 = sendChannel2;
                        pingPongKt$ponger$1.L$1 = $this$consume$iv$iv;
                        pingPongKt$ponger$1.L$2 = it;
                        pingPongKt$ponger$1.label = 2;
                        if (sendChannel2.send(pong, pingPongKt$ponger$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        $result4 = $result3;
                        z2 = z3;
                        pingPongKt$ponger$12 = pingPongKt$ponger$1;
                        sendChannel = sendChannel2;
                        pingPongKt$ponger$1 = pingPongKt$ponger$12;
                        $result5 = $result4;
                        pingPongKt$ponger$1.L$0 = sendChannel;
                        pingPongKt$ponger$1.L$1 = $this$consume$iv$iv;
                        pingPongKt$ponger$1.L$2 = it;
                        pingPongKt$ponger$1.label = 1;
                        hasNext = it.hasNext(pingPongKt$ponger$1);
                        if (hasNext == coroutine_suspended) {
                        }
                    } catch (Throwable th3) {
                        e$iv$iv = th3;
                        $result = $result3;
                        Throwable cause$iv$iv222 = e$iv$iv;
                        throw e$iv$iv;
                    }
                case 1:
                    $result2 = obj;
                    ChannelIterator channelIterator = (ChannelIterator) pingPongKt$ponger$12.L$2;
                    cause$iv$iv = null;
                    ReceiveChannel $this$consume$iv$iv2 = (ReceiveChannel) pingPongKt$ponger$12.L$1;
                    $this$consume$iv$iv = $this$consume$iv$iv2;
                    SendChannel<Frame.Pong> sendChannel3 = (SendChannel) pingPongKt$ponger$12.L$0;
                    ResultKt.throwOnFailure($result2);
                    it = channelIterator;
                    sendChannel2 = sendChannel3;
                    pingPongKt$ponger$1 = pingPongKt$ponger$12;
                    z = false;
                    z3 = false;
                    $result3 = $result2;
                    if (((Boolean) $result2).booleanValue()) {
                    }
                    break;
                case 2:
                    Object $result6 = obj;
                    z2 = false;
                    ChannelIterator channelIterator2 = (ChannelIterator) pingPongKt$ponger$12.L$2;
                    cause$iv$iv = null;
                    $this$consume$iv$iv = (ReceiveChannel) pingPongKt$ponger$12.L$1;
                    SendChannel<Frame.Pong> sendChannel4 = (SendChannel) pingPongKt$ponger$12.L$0;
                    ResultKt.throwOnFailure($result6);
                    z = false;
                    sendChannel = sendChannel4;
                    it = channelIterator2;
                    $result4 = $result6;
                    pingPongKt$ponger$1 = pingPongKt$ponger$12;
                    $result5 = $result4;
                    pingPongKt$ponger$1.L$0 = sendChannel;
                    pingPongKt$ponger$1.L$1 = $this$consume$iv$iv;
                    pingPongKt$ponger$1.L$2 = it;
                    pingPongKt$ponger$1.label = 1;
                    hasNext = it.hasNext(pingPongKt$ponger$1);
                    if (hasNext == coroutine_suspended) {
                    }
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } catch (Throwable th4) {
            e$iv$iv = th4;
            $result = i;
        }
    }
}