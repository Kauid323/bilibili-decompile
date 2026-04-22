package kntr.app.tribee.operation.viewmodel;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import kntr.app.tribee.operation.viewmodel.TribeeOperationStateAction;
import kntr.app.tribee.operation.viewmodel.state.TribeeOperationState;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TribeeOperationStateMachine.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/tribee/operation/viewmodel/state/TribeeOperationState;", "action", "Lkntr/app/tribee/operation/viewmodel/TribeeOperationStateAction$UpdateTribee;", "state", "Lcom/freeletics/flowredux/dsl/State;", "Lkntr/app/tribee/operation/viewmodel/state/TribeeOperationState$TribeeOperationContentState;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.tribee.operation.viewmodel.TribeeOperationStateMachine$1$2$1", f = "TribeeOperationStateMachine.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class TribeeOperationStateMachine$1$2$1 extends SuspendLambda implements Function3<TribeeOperationStateAction.UpdateTribee, State<TribeeOperationState.TribeeOperationContentState>, Continuation<? super ChangedState<? extends TribeeOperationState>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TribeeOperationStateMachine$1$2$1(Continuation<? super TribeeOperationStateMachine$1$2$1> continuation) {
        super(3, continuation);
    }

    public final Object invoke(TribeeOperationStateAction.UpdateTribee updateTribee, State<TribeeOperationState.TribeeOperationContentState> state, Continuation<? super ChangedState<? extends TribeeOperationState>> continuation) {
        TribeeOperationStateMachine$1$2$1 tribeeOperationStateMachine$1$2$1 = new TribeeOperationStateMachine$1$2$1(continuation);
        tribeeOperationStateMachine$1$2$1.L$0 = updateTribee;
        tribeeOperationStateMachine$1$2$1.L$1 = state;
        return tribeeOperationStateMachine$1$2$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        final TribeeOperationStateAction.UpdateTribee action = (TribeeOperationStateAction.UpdateTribee) this.L$0;
        State state = (State) this.L$1;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                return state.mutate(new Function1() { // from class: kntr.app.tribee.operation.viewmodel.TribeeOperationStateMachine$1$2$1$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        TribeeOperationState.TribeeOperationContentState invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = TribeeOperationStateMachine$1$2$1.invokeSuspend$lambda$0(TribeeOperationStateAction.UpdateTribee.this, (TribeeOperationState.TribeeOperationContentState) obj);
                        return invokeSuspend$lambda$0;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TribeeOperationState.TribeeOperationContentState invokeSuspend$lambda$0(TribeeOperationStateAction.UpdateTribee $action, TribeeOperationState.TribeeOperationContentState $this$mutate) {
        return TribeeOperationState.TribeeOperationContentState.copy$default($this$mutate, null, null, null, 0L, $action.getSelectedItem(), 15, null);
    }
}