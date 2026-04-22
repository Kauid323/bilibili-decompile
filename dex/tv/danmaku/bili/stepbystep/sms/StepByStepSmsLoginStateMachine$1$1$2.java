package tv.danmaku.bili.stepbystep.sms;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.cb.AuthResultCbHelper;
import tv.danmaku.bili.stepbystep.IStepByStepLoginAction;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StepByStepSmsLoginStateMachine.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Ltv/danmaku/bili/stepbystep/sms/IStepByStepSmsLoginPageState;", "action", "Ltv/danmaku/bili/stepbystep/IStepByStepLoginAction$OnFocusChanged;", AuthResultCbHelper.ARGS_STATE, "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.stepbystep.sms.StepByStepSmsLoginStateMachine$1$1$2", f = "StepByStepSmsLoginStateMachine.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class StepByStepSmsLoginStateMachine$1$1$2 extends SuspendLambda implements Function3<IStepByStepLoginAction.OnFocusChanged, State<IStepByStepSmsLoginPageState>, Continuation<? super ChangedState<? extends IStepByStepSmsLoginPageState>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public StepByStepSmsLoginStateMachine$1$1$2(Continuation<? super StepByStepSmsLoginStateMachine$1$1$2> continuation) {
        super(3, continuation);
    }

    public final Object invoke(IStepByStepLoginAction.OnFocusChanged onFocusChanged, State<IStepByStepSmsLoginPageState> state, Continuation<? super ChangedState<? extends IStepByStepSmsLoginPageState>> continuation) {
        StepByStepSmsLoginStateMachine$1$1$2 stepByStepSmsLoginStateMachine$1$1$2 = new StepByStepSmsLoginStateMachine$1$1$2(continuation);
        stepByStepSmsLoginStateMachine$1$1$2.L$0 = onFocusChanged;
        stepByStepSmsLoginStateMachine$1$1$2.L$1 = state;
        return stepByStepSmsLoginStateMachine$1$1$2.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                final IStepByStepLoginAction.OnFocusChanged action = (IStepByStepLoginAction.OnFocusChanged) this.L$0;
                State state = (State) this.L$1;
                return state.mutate(new Function1() { // from class: tv.danmaku.bili.stepbystep.sms.StepByStepSmsLoginStateMachine$1$1$2$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj2) {
                        IStepByStepSmsLoginPageState invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = StepByStepSmsLoginStateMachine$1$1$2.invokeSuspend$lambda$0(IStepByStepLoginAction.OnFocusChanged.this, (IStepByStepSmsLoginPageState) obj2);
                        return invokeSuspend$lambda$0;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IStepByStepSmsLoginPageState invokeSuspend$lambda$0(IStepByStepLoginAction.OnFocusChanged $action, IStepByStepSmsLoginPageState $this$mutate) {
        return $this$mutate.onFocusChanged($action.getFocusState());
    }
}