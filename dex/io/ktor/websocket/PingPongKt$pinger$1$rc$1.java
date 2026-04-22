package io.ktor.websocket;

import com.bilibili.doraemonkit.widget.tableview.bean.Column;
import com.bilibili.fd_service.unicom.pkg.BaseNCodec;
import io.ktor.utils.io.core.StringsKt;
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
import kotlin.text.Charsets;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.SendChannel;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PingPong.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", Column.INVAL_VALUE, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.websocket.PingPongKt$pinger$1$rc$1", f = "PingPong.kt", i = {}, l = {BaseNCodec.MIME_CHUNK_SIZE, 80}, m = "invokeSuspend", n = {}, s = {})
public final class PingPongKt$pinger$1$rc$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Channel<Frame.Pong> $channel;
    final /* synthetic */ SendChannel<Frame> $outgoing;
    final /* synthetic */ String $pingMessage;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public PingPongKt$pinger$1$rc$1(SendChannel<? super Frame> sendChannel, String str, Channel<Frame.Pong> channel, Continuation<? super PingPongKt$pinger$1$rc$1> continuation) {
        super(2, continuation);
        this.$outgoing = sendChannel;
        this.$pingMessage = str;
        this.$channel = channel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PingPongKt$pinger$1$rc$1(this.$outgoing, this.$pingMessage, this.$channel, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0053 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0054  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x0054 -> B:16:0x0059). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        PingPongKt$pinger$1$rc$1 pingPongKt$pinger$1$rc$1;
        Object receive;
        Object $result2;
        PingPongKt$pinger$1$rc$1 pingPongKt$pinger$1$rc$12;
        Object obj;
        Object $result3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                DefaultWebSocketSessionKt.getLOGGER().trace("WebSocket Pinger: sending ping frame");
                this.label = 1;
                if (this.$outgoing.send(new Frame.Ping(StringsKt.toByteArray(this.$pingMessage, Charsets.ISO_8859_1)), (Continuation) this) == $result3) {
                    return $result3;
                }
                pingPongKt$pinger$1$rc$1 = this;
                pingPongKt$pinger$1$rc$1.label = 2;
                receive = pingPongKt$pinger$1$rc$1.$channel.receive((Continuation) pingPongKt$pinger$1$rc$1);
                if (receive != $result3) {
                    Object obj2 = $result3;
                    $result2 = $result;
                    $result = receive;
                    pingPongKt$pinger$1$rc$12 = pingPongKt$pinger$1$rc$1;
                    obj = obj2;
                    break;
                } else {
                    return $result3;
                }
            case 1:
                ResultKt.throwOnFailure($result);
                pingPongKt$pinger$1$rc$1 = this;
                pingPongKt$pinger$1$rc$1.label = 2;
                receive = pingPongKt$pinger$1$rc$1.$channel.receive((Continuation) pingPongKt$pinger$1$rc$1);
                if (receive != $result3) {
                }
                break;
            case 2:
                ResultKt.throwOnFailure($result);
                pingPongKt$pinger$1$rc$12 = this;
                obj = $result3;
                $result2 = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Frame.Pong msg = (Frame.Pong) $result;
        if (Intrinsics.areEqual(kotlin.text.StringsKt.decodeToString$default(msg.getData(), 0, msg.getData().length + 0, false, 4, (Object) null), pingPongKt$pinger$1$rc$12.$pingMessage)) {
            DefaultWebSocketSessionKt.getLOGGER().trace("WebSocket Pinger: received valid pong frame " + msg);
            return Unit.INSTANCE;
        }
        DefaultWebSocketSessionKt.getLOGGER().trace("WebSocket Pinger: received invalid pong frame " + msg + ", continue waiting");
        $result = $result2;
        $result3 = obj;
        pingPongKt$pinger$1$rc$1 = pingPongKt$pinger$1$rc$12;
        pingPongKt$pinger$1$rc$1.label = 2;
        receive = pingPongKt$pinger$1$rc$1.$channel.receive((Continuation) pingPongKt$pinger$1$rc$1);
        if (receive != $result3) {
        }
    }
}