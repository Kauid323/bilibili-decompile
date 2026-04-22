package tv.danmaku.bili.inner;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.fullscreen.state.IFullscreenLoginAction;
import tv.danmaku.bili.fullscreen.state.ISmsLoginAction;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: InnerLoginViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.inner.InnerLoginViewModel$checkAndSendSmsCode$1", f = "InnerLoginViewModel.kt", i = {}, l = {BR.changeEpBtnVisible, BR.chatHint, BR.chatPlayerInputHint}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class InnerLoginViewModel$checkAndSendSmsCode$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ InnerLoginViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InnerLoginViewModel$checkAndSendSmsCode$1(InnerLoginViewModel innerLoginViewModel, Continuation<? super InnerLoginViewModel$checkAndSendSmsCode$1> continuation) {
        super(2, continuation);
        this.this$0 = innerLoginViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new InnerLoginViewModel$checkAndSendSmsCode$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0056 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x006f A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        InnerLoginStateMachine innerLoginStateMachine;
        InnerLoginStateMachine innerLoginStateMachine2;
        InnerLoginStateMachine innerLoginStateMachine3;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                BLog.i(InnerLoginViewModelKt.TAG_INNER_LOGIN, "Setting agreement checked true and send sms code");
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
                innerLoginStateMachine3 = this.this$0.stateMachine;
                this.label = 3;
                if (innerLoginStateMachine3.dispatch(new ISmsLoginAction.SendSmsAction(null, null, 3, null), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            case 1:
                ResultKt.throwOnFailure($result);
                innerLoginStateMachine2 = this.this$0.stateMachine;
                this.label = 2;
                if (innerLoginStateMachine2.dispatch(new IFullscreenLoginAction.AgreementCheckedAction(true), (Continuation) this) == coroutine_suspended) {
                }
                innerLoginStateMachine3 = this.this$0.stateMachine;
                this.label = 3;
                if (innerLoginStateMachine3.dispatch(new ISmsLoginAction.SendSmsAction(null, null, 3, null), (Continuation) this) == coroutine_suspended) {
                }
                return Unit.INSTANCE;
            case 2:
                ResultKt.throwOnFailure($result);
                innerLoginStateMachine3 = this.this$0.stateMachine;
                this.label = 3;
                if (innerLoginStateMachine3.dispatch(new ISmsLoginAction.SendSmsAction(null, null, 3, null), (Continuation) this) == coroutine_suspended) {
                }
                return Unit.INSTANCE;
            case 3:
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}