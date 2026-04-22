package io.ktor.websocket;

import com.bilibili.doraemonkit.widget.tableview.bean.Column;
import com.bilibili.game.service.bean.DownloadType;
import io.ktor.util.cio.ChannelIOException;
import io.ktor.websocket.CloseReason;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.ExceptionsKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ClosedReceiveChannelException;
import kotlinx.coroutines.channels.ClosedSendChannelException;
import kotlinx.coroutines.channels.ReceiveChannel;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DefaultWebSocketSession.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", Column.INVAL_VALUE, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.websocket.DefaultWebSocketSessionImpl$runOutgoingProcessor$1", f = "DefaultWebSocketSession.kt", i = {}, l = {246, DownloadType.DOWNLOAD_FROM_WEB, DownloadType.DOWNLOAD_FROM_WEB, DownloadType.DOWNLOAD_FROM_WEB, 250, DownloadType.DOWNLOAD_FROM_WEB, DownloadType.DOWNLOAD_FROM_WEB, 254, DownloadType.DOWNLOAD_FROM_WEB, DownloadType.DOWNLOAD_FROM_WEB}, m = "invokeSuspend", n = {}, s = {})
public final class DefaultWebSocketSessionImpl$runOutgoingProcessor$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ DefaultWebSocketSessionImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultWebSocketSessionImpl$runOutgoingProcessor$1(DefaultWebSocketSessionImpl defaultWebSocketSessionImpl, Continuation<? super DefaultWebSocketSessionImpl$runOutgoingProcessor$1> continuation) {
        super(2, continuation);
        this.this$0 = defaultWebSocketSessionImpl;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DefaultWebSocketSessionImpl$runOutgoingProcessor$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x006e A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        ReceiveChannel receiveChannel;
        WebSocketSession webSocketSession;
        ReceiveChannel receiveChannel2;
        WebSocketSession webSocketSession2;
        Channel channel;
        WebSocketSession webSocketSession3;
        ReceiveChannel receiveChannel3;
        WebSocketSession webSocketSession4;
        ReceiveChannel receiveChannel4;
        WebSocketSession webSocketSession5;
        ReceiveChannel receiveChannel5;
        WebSocketSession webSocketSession6;
        ReceiveChannel receiveChannel6;
        WebSocketSession webSocketSession7;
        Object outgoingProcessorLoop;
        ReceiveChannel receiveChannel7;
        WebSocketSession webSocketSession8;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            try {
                try {
                } catch (ChannelIOException e) {
                    receiveChannel3 = this.this$0.outgoingToBeProcessed;
                    ReceiveChannel.DefaultImpls.cancel$default(receiveChannel3, (CancellationException) null, 1, (Object) null);
                    webSocketSession4 = this.this$0.raw;
                    this.label = 7;
                    if (WebSocketSessionKt.close$default(webSocketSession4, null, (Continuation) this, 1, null) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } catch (Throwable cause) {
                    channel = this.this$0.outgoingToBeProcessed;
                    channel.cancel(ExceptionsKt.CancellationException("Failed to send frame", cause));
                    webSocketSession3 = this.this$0.raw;
                    this.label = 8;
                    if (WebSocketSessionKt.closeExceptionally(webSocketSession3, cause, (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            } catch (CancellationException e2) {
                this.label = 5;
                if (DefaultWebSocketSessionImpl.sendCloseSequence$default(this.this$0, new CloseReason(CloseReason.Codes.NORMAL, Column.INVAL_VALUE), null, (Continuation) this, 2, null) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } catch (ClosedSendChannelException e3) {
                receiveChannel2 = this.this$0.outgoingToBeProcessed;
                ReceiveChannel.DefaultImpls.cancel$default(receiveChannel2, (CancellationException) null, 1, (Object) null);
                webSocketSession2 = this.this$0.raw;
                this.label = 3;
                if (WebSocketSessionKt.close$default(webSocketSession2, null, (Continuation) this, 1, null) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } catch (ClosedReceiveChannelException e4) {
                receiveChannel = this.this$0.outgoingToBeProcessed;
                ReceiveChannel.DefaultImpls.cancel$default(receiveChannel, (CancellationException) null, 1, (Object) null);
                webSocketSession = this.this$0.raw;
                this.label = 4;
                if (WebSocketSessionKt.close$default(webSocketSession, null, (Continuation) this, 1, null) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    outgoingProcessorLoop = this.this$0.outgoingProcessorLoop((Continuation) this);
                    if (outgoingProcessorLoop == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    receiveChannel7 = this.this$0.outgoingToBeProcessed;
                    ReceiveChannel.DefaultImpls.cancel$default(receiveChannel7, (CancellationException) null, 1, (Object) null);
                    webSocketSession8 = this.this$0.raw;
                    this.label = 2;
                    if (WebSocketSessionKt.close$default(webSocketSession8, null, (Continuation) this, 1, null) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                case 1:
                    ResultKt.throwOnFailure($result);
                    receiveChannel7 = this.this$0.outgoingToBeProcessed;
                    ReceiveChannel.DefaultImpls.cancel$default(receiveChannel7, (CancellationException) null, 1, (Object) null);
                    webSocketSession8 = this.this$0.raw;
                    this.label = 2;
                    if (WebSocketSessionKt.close$default(webSocketSession8, null, (Continuation) this, 1, null) == coroutine_suspended) {
                    }
                    return Unit.INSTANCE;
                case 2:
                case 3:
                case 4:
                case 6:
                case 7:
                case 9:
                    ResultKt.throwOnFailure($result);
                    return Unit.INSTANCE;
                case 5:
                    ResultKt.throwOnFailure($result);
                    receiveChannel5 = this.this$0.outgoingToBeProcessed;
                    ReceiveChannel.DefaultImpls.cancel$default(receiveChannel5, (CancellationException) null, 1, (Object) null);
                    webSocketSession6 = this.this$0.raw;
                    this.label = 6;
                    if (WebSocketSessionKt.close$default(webSocketSession6, null, (Continuation) this, 1, null) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                case 8:
                    ResultKt.throwOnFailure($result);
                    receiveChannel6 = this.this$0.outgoingToBeProcessed;
                    ReceiveChannel.DefaultImpls.cancel$default(receiveChannel6, (CancellationException) null, 1, (Object) null);
                    webSocketSession7 = this.this$0.raw;
                    this.label = 9;
                    if (WebSocketSessionKt.close$default(webSocketSession7, null, (Continuation) this, 1, null) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                case 10:
                    Throwable th = (Throwable) this.L$0;
                    ResultKt.throwOnFailure($result);
                    throw th;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } catch (Throwable th2) {
            receiveChannel4 = this.this$0.outgoingToBeProcessed;
            ReceiveChannel.DefaultImpls.cancel$default(receiveChannel4, (CancellationException) null, 1, (Object) null);
            webSocketSession5 = this.this$0.raw;
            this.L$0 = th2;
            this.label = 10;
            if (WebSocketSessionKt.close$default(webSocketSession5, null, (Continuation) this, 1, null) == coroutine_suspended) {
                return coroutine_suspended;
            }
            throw th2;
        }
    }
}