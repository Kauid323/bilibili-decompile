package tv.danmaku.bili.inner;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.fullscreen.stat.Facebook;
import tv.danmaku.bili.fullscreen.stat.Google;
import tv.danmaku.bili.fullscreen.stat.LoginWay;
import tv.danmaku.bili.fullscreen.state.IFullscreenLoginAction;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: InnerLoginViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.inner.InnerLoginViewModel$checkAndLogin$1", f = "InnerLoginViewModel.kt", i = {}, l = {BR.btnTextColor, BR.btnTryAgainText, BR.buttonText, BR.buttonWidths, BR.canWatch}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class InnerLoginViewModel$checkAndLogin$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ LoginWay $way;
    int label;
    final /* synthetic */ InnerLoginViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InnerLoginViewModel$checkAndLogin$1(InnerLoginViewModel innerLoginViewModel, LoginWay loginWay, Continuation<? super InnerLoginViewModel$checkAndLogin$1> continuation) {
        super(2, continuation);
        this.this$0 = innerLoginViewModel;
        this.$way = loginWay;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new InnerLoginViewModel$checkAndLogin$1(this.this$0, this.$way, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0060 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0081  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        InnerLoginStateMachine innerLoginStateMachine;
        InnerLoginStateMachine innerLoginStateMachine2;
        LoginWay loginWay;
        InnerLoginStateMachine innerLoginStateMachine3;
        InnerLoginStateMachine innerLoginStateMachine4;
        InnerLoginStateMachine innerLoginStateMachine5;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                BLog.i(InnerLoginViewModelKt.TAG_INNER_LOGIN, "Setting agreement checked true and login");
                innerLoginStateMachine = this.this$0.stateMachine;
                this.label = 1;
                if (innerLoginStateMachine.dispatch(new IFullscreenLoginAction.DismissEulaAction(true), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                innerLoginStateMachine2 = this.this$0.stateMachine;
                this.label = 2;
                if (innerLoginStateMachine2.dispatch(new IFullscreenLoginAction.AgreementCheckedAction(true), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                loginWay = this.$way;
                if (Intrinsics.areEqual(loginWay, Google.GoogleLogin.INSTANCE)) {
                    innerLoginStateMachine5 = this.this$0.stateMachine;
                    this.label = 3;
                    if (innerLoginStateMachine5.dispatch(IFullscreenLoginAction.GoogleLogin.INSTANCE, (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (Intrinsics.areEqual(loginWay, Facebook.FacebookLogin.INSTANCE)) {
                    innerLoginStateMachine4 = this.this$0.stateMachine;
                    this.label = 4;
                    if (innerLoginStateMachine4.dispatch(IFullscreenLoginAction.FacebookLogin.INSTANCE, (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    innerLoginStateMachine3 = this.this$0.stateMachine;
                    this.label = 5;
                    if (innerLoginStateMachine3.dispatch(new IFullscreenLoginAction.LoginAction(null, false, MapsKt.emptyMap(), 1, null), (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Unit.INSTANCE;
            case 1:
                ResultKt.throwOnFailure($result);
                innerLoginStateMachine2 = this.this$0.stateMachine;
                this.label = 2;
                if (innerLoginStateMachine2.dispatch(new IFullscreenLoginAction.AgreementCheckedAction(true), (Continuation) this) == coroutine_suspended) {
                }
                loginWay = this.$way;
                if (Intrinsics.areEqual(loginWay, Google.GoogleLogin.INSTANCE)) {
                }
                return Unit.INSTANCE;
            case 2:
                ResultKt.throwOnFailure($result);
                loginWay = this.$way;
                if (Intrinsics.areEqual(loginWay, Google.GoogleLogin.INSTANCE)) {
                }
                return Unit.INSTANCE;
            case 3:
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            case 4:
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            case 5:
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}