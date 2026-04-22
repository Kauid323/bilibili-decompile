package tv.danmaku.bili.fullscreen.service;

import com.bilibili.lib.coroutineextension.CoroutineFinalableKt;
import com.bilibili.lib.coroutineextension.CoroutineFinallyResult;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.helper.LoginLifecycleObserver;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LoginCountDownLatchService.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.fullscreen.service.LoginCountDownLatchService$countDown$2", f = "LoginCountDownLatchService.kt", i = {0}, l = {BR.avatarListVisible}, m = "invokeSuspend", n = {"result$iv"}, s = {"L$0"}, v = 1)
public final class LoginCountDownLatchService$countDown$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public LoginCountDownLatchService$countDown$2(Continuation<? super LoginCountDownLatchService$countDown$2> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LoginCountDownLatchService$countDown$2(continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Throwable th;
        CoroutineFinallyResult result$iv;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                CoroutineFinalableKt.getCoroutineFinallyScope();
                LoginLifecycleObserver.INSTANCE.increaseCountDownLatch();
                CoroutineFinallyResult result$iv2 = new CoroutineFinallyResult() { // from class: tv.danmaku.bili.fullscreen.service.LoginCountDownLatchService$countDown$2$invokeSuspend$lambda$0$$inlined$onFinalization$1
                    public final void invoke() {
                        LoginLifecycleObserver.INSTANCE.decreaseCountDownLatch();
                    }
                };
                try {
                    this.L$0 = result$iv2;
                    this.label = 1;
                    if (DelayKt.awaitCancellation((Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    result$iv = result$iv2;
                    throw new KotlinNothingValueException();
                } catch (Throwable th2) {
                    th = th2;
                    result$iv = result$iv2;
                    result$iv.invoke();
                    throw th;
                }
            case 1:
                result$iv = (CoroutineFinallyResult) this.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    throw new KotlinNothingValueException();
                } catch (Throwable th3) {
                    th = th3;
                    result$iv.invoke();
                    throw th;
                }
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}