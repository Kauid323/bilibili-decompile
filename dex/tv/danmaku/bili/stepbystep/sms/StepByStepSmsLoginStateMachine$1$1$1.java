package tv.danmaku.bili.stepbystep.sms;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.fullscreen.service.LoginReportService;
import tv.danmaku.bili.stepbystep.sms.StepByStepSmsLoginAction;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StepByStepSmsLoginStateMachine.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "action", "Ltv/danmaku/bili/stepbystep/sms/StepByStepSmsLoginAction$ReportAction;", "stateSnapshot", "Ltv/danmaku/bili/stepbystep/sms/IStepByStepSmsLoginPageState;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.stepbystep.sms.StepByStepSmsLoginStateMachine$1$1$1", f = "StepByStepSmsLoginStateMachine.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class StepByStepSmsLoginStateMachine$1$1$1 extends SuspendLambda implements Function3<StepByStepSmsLoginAction.ReportAction, IStepByStepSmsLoginPageState, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;
    final /* synthetic */ StepByStepSmsLoginStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepByStepSmsLoginStateMachine$1$1$1(StepByStepSmsLoginStateMachine stepByStepSmsLoginStateMachine, Continuation<? super StepByStepSmsLoginStateMachine$1$1$1> continuation) {
        super(3, continuation);
        this.this$0 = stepByStepSmsLoginStateMachine;
    }

    public final Object invoke(StepByStepSmsLoginAction.ReportAction reportAction, IStepByStepSmsLoginPageState iStepByStepSmsLoginPageState, Continuation<? super Unit> continuation) {
        StepByStepSmsLoginStateMachine$1$1$1 stepByStepSmsLoginStateMachine$1$1$1 = new StepByStepSmsLoginStateMachine$1$1$1(this.this$0, continuation);
        stepByStepSmsLoginStateMachine$1$1$1.L$0 = reportAction;
        stepByStepSmsLoginStateMachine$1$1$1.L$1 = iStepByStepSmsLoginPageState;
        return stepByStepSmsLoginStateMachine$1$1$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        LoginReportService loginReportService;
        String str;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                StepByStepSmsLoginAction.ReportAction action = (StepByStepSmsLoginAction.ReportAction) this.L$0;
                IStepByStepSmsLoginPageState stateSnapshot = (IStepByStepSmsLoginPageState) this.L$1;
                loginReportService = this.this$0.reportService;
                String eventId = action.getEventId();
                str = this.this$0.reportLoginType;
                Pair<String, String>[] params = action.getParams(stateSnapshot);
                loginReportService.report(eventId, str, (Pair[]) Arrays.copyOf(params, params.length));
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}