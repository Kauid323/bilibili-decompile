package tv.danmaku.bili.stepbystep.sms;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.cb.AuthResultCbHelper;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StepByStepSmsLoginStateMachine.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.stepbystep.sms.StepByStepSmsLoginStateMachine", f = "StepByStepSmsLoginStateMachine.kt", i = {0, 0, 0, 1, 1, 1, 1, 2, 2, 2}, l = {BR.inputHintText, BR.item, BR.itemShowType}, m = "handleLoginState", n = {AuthResultCbHelper.ARGS_STATE, "dispatchAction", "current", AuthResultCbHelper.ARGS_STATE, "dispatchAction", "current", "result", AuthResultCbHelper.ARGS_STATE, "current", "result"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2"}, v = 1)
public final class StepByStepSmsLoginStateMachine$handleLoginState$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ StepByStepSmsLoginStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepByStepSmsLoginStateMachine$handleLoginState$1(StepByStepSmsLoginStateMachine stepByStepSmsLoginStateMachine, Continuation<? super StepByStepSmsLoginStateMachine$handleLoginState$1> continuation) {
        super(continuation);
        this.this$0 = stepByStepSmsLoginStateMachine;
    }

    public final Object invokeSuspend(Object obj) {
        Object handleLoginState;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        handleLoginState = this.this$0.handleLoginState(null, null, (Continuation) this);
        return handleLoginState;
    }
}