package tv.danmaku.bili.fullscreen;

import android.app.Application;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.helper.LoginSuccessProcessorKt;
import tv.danmaku.bili.helper.LoginUIType;

/* compiled from: CoroutineExtension.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "com/bilibili/lib/coroutineextension/CoroutineExtensionKt$awaitCancel$1"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.fullscreen.FullscreenLoginActivity$onCreate$1$invokeSuspend$$inlined$awaitCancel$1", f = "FullscreenLoginActivity.kt", i = {}, l = {192}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class FullscreenLoginActivity$onCreate$1$invokeSuspend$$inlined$awaitCancel$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ FullscreenLoginActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FullscreenLoginActivity$onCreate$1$invokeSuspend$$inlined$awaitCancel$1(Continuation continuation, FullscreenLoginActivity fullscreenLoginActivity) {
        super(2, continuation);
        this.this$0 = fullscreenLoginActivity;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FullscreenLoginActivity$onCreate$1$invokeSuspend$$inlined$awaitCancel$1(continuation, this.this$0);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    if (DelayKt.awaitCancellation((Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            throw new KotlinNothingValueException();
        } catch (Throwable th) {
            FullscreenLoginActivity fullscreenLoginActivity = this.this$0;
            Application application = this.this$0.getApplication();
            Intrinsics.checkNotNullExpressionValue(application, "getApplication(...)");
            LoginSuccessProcessorKt.onLoginPageExit(fullscreenLoginActivity, application, LoginUIType.FULL);
            throw th;
        }
    }
}