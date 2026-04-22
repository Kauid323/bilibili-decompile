package tv.danmaku.bili.stepbystep.sms;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.text.StringsKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.stepbystep.IStepByStepLoginAction;
import tv.danmaku.bili.stepbystep.sms.StepByStepSmsLoginAction;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StepByStepSmsLoginStateMachine.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "action", "Ltv/danmaku/bili/stepbystep/sms/StepByStepSmsLoginAction$InputSmsCodeAction;", "stateSnapshot", "Ltv/danmaku/bili/stepbystep/sms/StepByStepSmsLoginVerifyPage;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.stepbystep.sms.StepByStepSmsLoginStateMachine$1$5$6", f = "StepByStepSmsLoginStateMachine.kt", i = {}, l = {BR.followedCountText}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class StepByStepSmsLoginStateMachine$1$5$6 extends SuspendLambda implements Function3<StepByStepSmsLoginAction.InputSmsCodeAction, StepByStepSmsLoginVerifyPage, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;
    final /* synthetic */ StepByStepSmsLoginStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepByStepSmsLoginStateMachine$1$5$6(StepByStepSmsLoginStateMachine stepByStepSmsLoginStateMachine, Continuation<? super StepByStepSmsLoginStateMachine$1$5$6> continuation) {
        super(3, continuation);
        this.this$0 = stepByStepSmsLoginStateMachine;
    }

    public final Object invoke(StepByStepSmsLoginAction.InputSmsCodeAction inputSmsCodeAction, StepByStepSmsLoginVerifyPage stepByStepSmsLoginVerifyPage, Continuation<? super Unit> continuation) {
        StepByStepSmsLoginStateMachine$1$5$6 stepByStepSmsLoginStateMachine$1$5$6 = new StepByStepSmsLoginStateMachine$1$5$6(this.this$0, continuation);
        stepByStepSmsLoginStateMachine$1$5$6.L$0 = inputSmsCodeAction;
        stepByStepSmsLoginStateMachine$1$5$6.L$1 = stepByStepSmsLoginVerifyPage;
        return stepByStepSmsLoginStateMachine$1$5$6.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                StepByStepSmsLoginAction.InputSmsCodeAction action = (StepByStepSmsLoginAction.InputSmsCodeAction) this.L$0;
                StepByStepSmsLoginVerifyPage stateSnapshot = (StepByStepSmsLoginVerifyPage) this.L$1;
                CharSequence $this$filter$iv = action.getSmsCode();
                CharSequence $this$filterTo$iv$iv = $this$filter$iv;
                Appendable destination$iv$iv = new StringBuilder();
                int length = $this$filterTo$iv$iv.length();
                for (int index$iv$iv = 0; index$iv$iv < length; index$iv$iv++) {
                    char element$iv$iv = $this$filterTo$iv$iv.charAt(index$iv$iv);
                    char it = element$iv$iv;
                    if (Character.isDigit(it)) {
                        destination$iv$iv.append(element$iv$iv);
                    }
                }
                String newSmsCode = StringsKt.take(((StringBuilder) destination$iv$iv).toString(), 6);
                if (newSmsCode.length() == 6) {
                    BLog.i(StepByStepSmsLoginPageStateKt.TAG_STEP_BY_STEP_SMS, "in state : StepByStepSmsLoginVerifyPage , action effect: InputSmsCodeAction -> smsCode=" + newSmsCode + " ,captchaStatus=" + stateSnapshot.getCaptchaStatus());
                    this.L$0 = null;
                    this.label = 1;
                    if (this.this$0.dispatch(new IStepByStepLoginAction.LoginAction(null, false, 3, null), (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}