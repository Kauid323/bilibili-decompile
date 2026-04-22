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
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.flow.FlowCollector;
import tv.danmaku.bili.BR;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StepByStepSmsLoginStateMachine.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.stepbystep.sms.StepByStepSmsLoginStateMachine$getCountDownFlow$1", f = "StepByStepSmsLoginStateMachine.kt", i = {0, 1}, l = {BR.pageId, BR.pageInfo}, m = "invokeSuspend", n = {"$this$flow", "$this$flow"}, s = {"L$0", "L$0"}, v = 1)
public final class StepByStepSmsLoginStateMachine$getCountDownFlow$1 extends SuspendLambda implements Function2<FlowCollector<? super Unit>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public StepByStepSmsLoginStateMachine$getCountDownFlow$1(Continuation<? super StepByStepSmsLoginStateMachine$getCountDownFlow$1> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> stepByStepSmsLoginStateMachine$getCountDownFlow$1 = new StepByStepSmsLoginStateMachine$getCountDownFlow$1(continuation);
        stepByStepSmsLoginStateMachine$getCountDownFlow$1.L$0 = obj;
        return stepByStepSmsLoginStateMachine$getCountDownFlow$1;
    }

    public final Object invoke(FlowCollector<? super Unit> flowCollector, Continuation<? super Unit> continuation) {
        return create(flowCollector, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x005d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x005f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x005b -> B:9:0x002b). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        FlowCollector $this$flow;
        StepByStepSmsLoginStateMachine$getCountDownFlow$1 stepByStepSmsLoginStateMachine$getCountDownFlow$1;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                $this$flow = (FlowCollector) this.L$0;
                stepByStepSmsLoginStateMachine$getCountDownFlow$1 = this;
                if (!JobKt.isActive(stepByStepSmsLoginStateMachine$getCountDownFlow$1.getContext())) {
                    Duration.Companion companion = Duration.Companion;
                    stepByStepSmsLoginStateMachine$getCountDownFlow$1.L$0 = $this$flow;
                    stepByStepSmsLoginStateMachine$getCountDownFlow$1.label = 1;
                    if (DelayKt.delay-VtjQ1oo(DurationKt.toDuration(1, DurationUnit.SECONDS), (Continuation) stepByStepSmsLoginStateMachine$getCountDownFlow$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    stepByStepSmsLoginStateMachine$getCountDownFlow$1.L$0 = $this$flow;
                    stepByStepSmsLoginStateMachine$getCountDownFlow$1.label = 2;
                    if ($this$flow.emit(Unit.INSTANCE, (Continuation) stepByStepSmsLoginStateMachine$getCountDownFlow$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    if (!JobKt.isActive(stepByStepSmsLoginStateMachine$getCountDownFlow$1.getContext())) {
                        return Unit.INSTANCE;
                    }
                }
            case 1:
                $this$flow = (FlowCollector) this.L$0;
                ResultKt.throwOnFailure($result);
                stepByStepSmsLoginStateMachine$getCountDownFlow$1 = this;
                stepByStepSmsLoginStateMachine$getCountDownFlow$1.L$0 = $this$flow;
                stepByStepSmsLoginStateMachine$getCountDownFlow$1.label = 2;
                if ($this$flow.emit(Unit.INSTANCE, (Continuation) stepByStepSmsLoginStateMachine$getCountDownFlow$1) == coroutine_suspended) {
                }
                if (!JobKt.isActive(stepByStepSmsLoginStateMachine$getCountDownFlow$1.getContext())) {
                }
                break;
            case 2:
                $this$flow = (FlowCollector) this.L$0;
                ResultKt.throwOnFailure($result);
                stepByStepSmsLoginStateMachine$getCountDownFlow$1 = this;
                if (!JobKt.isActive(stepByStepSmsLoginStateMachine$getCountDownFlow$1.getContext())) {
                }
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}