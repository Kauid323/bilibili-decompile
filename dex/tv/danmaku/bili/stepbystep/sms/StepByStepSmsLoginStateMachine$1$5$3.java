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
import tv.danmaku.bili.stepbystep.sms.StepByStepSmsLoginAction;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StepByStepSmsLoginStateMachine.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "<unused var>", "Ltv/danmaku/bili/stepbystep/sms/StepByStepSmsLoginAction$GetSmsAction;", "Ltv/danmaku/bili/stepbystep/sms/StepByStepSmsLoginVerifyPage;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.stepbystep.sms.StepByStepSmsLoginStateMachine$1$5$3", f = "StepByStepSmsLoginStateMachine.kt", i = {}, l = {BR.episodeTime}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class StepByStepSmsLoginStateMachine$1$5$3 extends SuspendLambda implements Function3<StepByStepSmsLoginAction.GetSmsAction, StepByStepSmsLoginVerifyPage, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ StepByStepSmsLoginStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepByStepSmsLoginStateMachine$1$5$3(StepByStepSmsLoginStateMachine stepByStepSmsLoginStateMachine, Continuation<? super StepByStepSmsLoginStateMachine$1$5$3> continuation) {
        super(3, continuation);
        this.this$0 = stepByStepSmsLoginStateMachine;
    }

    public final Object invoke(StepByStepSmsLoginAction.GetSmsAction getSmsAction, StepByStepSmsLoginVerifyPage stepByStepSmsLoginVerifyPage, Continuation<? super Unit> continuation) {
        return new StepByStepSmsLoginStateMachine$1$5$3(this.this$0, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                if (this.this$0.dispatch(StepByStepSmsLoginAction.ReportAction.OnGetSms.INSTANCE, (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
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