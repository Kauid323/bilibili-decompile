package io.ktor.websocket;

import com.bilibili.doraemonkit.widget.tableview.bean.Column;
import io.ktor.utils.io.pool.ObjectPool;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: WebSocketWriter.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", Column.INVAL_VALUE, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.websocket.WebSocketWriter$writeLoopJob$1", f = "WebSocketWriter.kt", i = {0, 0}, l = {40}, m = "invokeSuspend", n = {"$this$useInstance$iv", "instance$iv"}, s = {"L$0", "L$1"})
public final class WebSocketWriter$writeLoopJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ WebSocketWriter this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebSocketWriter$writeLoopJob$1(WebSocketWriter webSocketWriter, Continuation<? super WebSocketWriter$writeLoopJob$1> continuation) {
        super(2, continuation);
        this.this$0 = webSocketWriter;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WebSocketWriter$writeLoopJob$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        ObjectPool $this$useInstance$iv;
        Object instance$iv;
        Object writeLoop;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                $this$useInstance$iv = this.this$0.getPool();
                WebSocketWriter webSocketWriter = this.this$0;
                Object instance$iv2 = $this$useInstance$iv.borrow();
                try {
                    ByteBuffer it = (ByteBuffer) instance$iv2;
                    this.L$0 = $this$useInstance$iv;
                    this.L$1 = instance$iv2;
                    this.label = 1;
                    writeLoop = webSocketWriter.writeLoop(it, this);
                    if (writeLoop == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    instance$iv = instance$iv2;
                    Unit unit = Unit.INSTANCE;
                    $this$useInstance$iv.recycle(instance$iv);
                    return Unit.INSTANCE;
                } catch (Throwable th) {
                    th = th;
                    instance$iv = instance$iv2;
                    $this$useInstance$iv.recycle(instance$iv);
                    throw th;
                }
            case 1:
                instance$iv = this.L$1;
                $this$useInstance$iv = (ObjectPool) this.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    Unit unit2 = Unit.INSTANCE;
                    $this$useInstance$iv.recycle(instance$iv);
                    return Unit.INSTANCE;
                } catch (Throwable th2) {
                    th = th2;
                    $this$useInstance$iv.recycle(instance$iv);
                    throw th;
                }
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}