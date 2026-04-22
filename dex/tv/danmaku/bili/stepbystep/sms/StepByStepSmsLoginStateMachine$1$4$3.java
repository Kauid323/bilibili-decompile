package tv.danmaku.bili.stepbystep.sms;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.stepbystep.IStepByStepLoginAction;
import tv.danmaku.bili.stepbystep.sms.StepByStepSmsLoginAction;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StepByStepSmsLoginStateMachine.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "action", "Ltv/danmaku/bili/stepbystep/IStepByStepLoginAction$AgreementCheckedAction;", "<unused var>", "Ltv/danmaku/bili/stepbystep/sms/StepByStepSmsLoginPhonePage;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.stepbystep.sms.StepByStepSmsLoginStateMachine$1$4$3", f = "StepByStepSmsLoginStateMachine.kt", i = {}, l = {BR.countdownTip, BR.countdownTrackEnabled}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class StepByStepSmsLoginStateMachine$1$4$3 extends SuspendLambda implements Function3<IStepByStepLoginAction.AgreementCheckedAction, StepByStepSmsLoginPhonePage, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ StepByStepSmsLoginStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepByStepSmsLoginStateMachine$1$4$3(StepByStepSmsLoginStateMachine stepByStepSmsLoginStateMachine, Continuation<? super StepByStepSmsLoginStateMachine$1$4$3> continuation) {
        super(3, continuation);
        this.this$0 = stepByStepSmsLoginStateMachine;
    }

    public final Object invoke(IStepByStepLoginAction.AgreementCheckedAction agreementCheckedAction, StepByStepSmsLoginPhonePage stepByStepSmsLoginPhonePage, Continuation<? super Unit> continuation) {
        StepByStepSmsLoginStateMachine$1$4$3 stepByStepSmsLoginStateMachine$1$4$3 = new StepByStepSmsLoginStateMachine$1$4$3(this.this$0, continuation);
        stepByStepSmsLoginStateMachine$1$4$3.L$0 = agreementCheckedAction;
        return stepByStepSmsLoginStateMachine$1$4$3.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                IStepByStepLoginAction.AgreementCheckedAction action = (IStepByStepLoginAction.AgreementCheckedAction) this.L$0;
                if (action.getFromPopup()) {
                    this.label = 1;
                    if (this.this$0.dispatch(new StepByStepSmsLoginAction.ReportAction.ClickProvisionPopup(action.getChecked()), (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    this.label = 2;
                    if (this.this$0.dispatch(new StepByStepSmsLoginAction.ReportAction.ClickArrangementCheckBox(action.getChecked()), (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            case 2:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}