package tv.danmaku.bili.stepbystep.sms;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.time.Duration;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.stepbystep.sms.StepByStepSmsLoginAction;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StepByStepSmsLoginStateMachine.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Ltv/danmaku/bili/stepbystep/sms/StepByStepSmsLoginVerifyPage;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.stepbystep.sms.StepByStepSmsLoginStateMachine$1$5$1", f = "StepByStepSmsLoginStateMachine.kt", i = {}, l = {BR.emoteImage}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class StepByStepSmsLoginStateMachine$1$5$1 extends SuspendLambda implements Function2<StepByStepSmsLoginVerifyPage, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ StepByStepSmsLoginStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepByStepSmsLoginStateMachine$1$5$1(StepByStepSmsLoginStateMachine stepByStepSmsLoginStateMachine, Continuation<? super StepByStepSmsLoginStateMachine$1$5$1> continuation) {
        super(2, continuation);
        this.this$0 = stepByStepSmsLoginStateMachine;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> stepByStepSmsLoginStateMachine$1$5$1 = new StepByStepSmsLoginStateMachine$1$5$1(this.this$0, continuation);
        stepByStepSmsLoginStateMachine$1$5$1.L$0 = obj;
        return stepByStepSmsLoginStateMachine$1$5$1;
    }

    public final Object invoke(StepByStepSmsLoginVerifyPage stepByStepSmsLoginVerifyPage, Continuation<? super Unit> continuation) {
        return create(stepByStepSmsLoginVerifyPage, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                StepByStepSmsLoginVerifyPage it = (StepByStepSmsLoginVerifyPage) this.L$0;
                if (Duration.equals-impl0(it.mo1508getCountingUwyO8pc(), Duration.Companion.getZERO-UwyO8pc())) {
                    this.label = 1;
                    if (this.this$0.dispatch(new StepByStepSmsLoginAction.GetSmsAction(null, null, 3, null), (Continuation) this) == coroutine_suspended) {
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