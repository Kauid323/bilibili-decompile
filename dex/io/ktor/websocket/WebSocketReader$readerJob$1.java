package io.ktor.websocket;

import com.bilibili.doraemonkit.widget.tableview.bean.Column;
import io.ktor.utils.io.pool.ObjectPool;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
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
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.SendChannel;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: WebSocketReader.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", Column.INVAL_VALUE, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.websocket.WebSocketReader$readerJob$1", f = "WebSocketReader.kt", i = {0}, l = {41}, m = "invokeSuspend", n = {"buffer"}, s = {"L$0"})
public final class WebSocketReader$readerJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ObjectPool<ByteBuffer> $pool;
    Object L$0;
    int label;
    final /* synthetic */ WebSocketReader this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebSocketReader$readerJob$1(ObjectPool<ByteBuffer> objectPool, WebSocketReader webSocketReader, Continuation<? super WebSocketReader$readerJob$1> continuation) {
        super(2, continuation);
        this.$pool = objectPool;
        this.this$0 = webSocketReader;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WebSocketReader$readerJob$1(this.$pool, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        SendChannel sendChannel;
        ByteBuffer buffer;
        ProtocolViolationException cause;
        FrameTooBigException cause2;
        Object readLoop;
        ReceiveChannel receiveChannel;
        Channel channel;
        Channel channel2;
        SendChannel sendChannel2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    ByteBuffer buffer2 = (ByteBuffer) this.$pool.borrow();
                    try {
                        this.L$0 = buffer2;
                        this.label = 1;
                        readLoop = this.this$0.readLoop(buffer2, (Continuation) this);
                        if (readLoop == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        buffer = buffer2;
                        break;
                    } catch (FrameTooBigException e) {
                        cause2 = e;
                        buffer = buffer2;
                        channel2 = this.this$0.queue;
                        channel2.close(cause2);
                        break;
                    } catch (ProtocolViolationException e2) {
                        cause = e2;
                        buffer = buffer2;
                        channel = this.this$0.queue;
                        channel.close(cause);
                        break;
                    } catch (ClosedChannelException e3) {
                        buffer = buffer2;
                        break;
                    } catch (IOException e4) {
                        buffer = buffer2;
                        receiveChannel = this.this$0.queue;
                        ReceiveChannel.DefaultImpls.cancel$default(receiveChannel, (CancellationException) null, 1, (Object) null);
                        break;
                    } catch (CancellationException e5) {
                        buffer = buffer2;
                        break;
                    } catch (Throwable cause3) {
                        throw cause3;
                    }
                case 1:
                    buffer = (ByteBuffer) this.L$0;
                    try {
                        ResultKt.throwOnFailure($result);
                        break;
                    } catch (FrameTooBigException e6) {
                        cause2 = e6;
                        channel2 = this.this$0.queue;
                        channel2.close(cause2);
                        break;
                    } catch (ProtocolViolationException e7) {
                        cause = e7;
                        channel = this.this$0.queue;
                        channel.close(cause);
                        break;
                    } catch (ClosedChannelException e8) {
                        break;
                    } catch (IOException e9) {
                        receiveChannel = this.this$0.queue;
                        ReceiveChannel.DefaultImpls.cancel$default(receiveChannel, (CancellationException) null, 1, (Object) null);
                        break;
                    } catch (CancellationException e10) {
                        break;
                    } catch (Throwable cause4) {
                        throw cause4;
                    }
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            this.$pool.recycle(buffer);
            sendChannel2 = this.this$0.queue;
            SendChannel.DefaultImpls.close$default(sendChannel2, (Throwable) null, 1, (Object) null);
            return Unit.INSTANCE;
        } catch (Throwable th) {
            this.$pool.recycle(coroutine_suspended);
            sendChannel = this.this$0.queue;
            SendChannel.DefaultImpls.close$default(sendChannel, (Throwable) null, 1, (Object) null);
            throw th;
        }
    }
}