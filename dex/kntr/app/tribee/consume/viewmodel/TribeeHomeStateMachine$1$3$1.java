package kntr.app.tribee.consume.viewmodel;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction;
import kntr.app.tribee.consume.viewmodel.state.TribeeHomeInitialState;
import kntr.app.tribee.consume.viewmodel.state.TribeeHomeState;
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
/* compiled from: TribeeHomeStateMachine.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/tribee/consume/viewmodel/state/TribeeHomeState;", "<unused var>", "Lkntr/app/tribee/consume/viewmodel/TribeeHomeStateAction$Initial;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.tribee.consume.viewmodel.TribeeHomeStateMachine$1$3$1", f = "TribeeHomeStateMachine.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class TribeeHomeStateMachine$1$3$1 extends SuspendLambda implements Function3<TribeeHomeStateAction.Initial, State<TribeeHomeState>, Continuation<? super ChangedState<? extends TribeeHomeState>>, Object> {
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TribeeHomeStateMachine$1$3$1(Continuation<? super TribeeHomeStateMachine$1$3$1> continuation) {
        super(3, continuation);
    }

    public final Object invoke(TribeeHomeStateAction.Initial initial, State<TribeeHomeState> state, Continuation<? super ChangedState<? extends TribeeHomeState>> continuation) {
        TribeeHomeStateMachine$1$3$1 tribeeHomeStateMachine$1$3$1 = new TribeeHomeStateMachine$1$3$1(continuation);
        tribeeHomeStateMachine$1$3$1.L$0 = state;
        return tribeeHomeStateMachine$1$3$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        final State state = (State) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                return state.override(new Function1() { // from class: kntr.app.tribee.consume.viewmodel.TribeeHomeStateMachine$1$3$1$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        TribeeHomeInitialState invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = TribeeHomeStateMachine$1$3$1.invokeSuspend$lambda$0(state, (TribeeHomeState) obj);
                        return invokeSuspend$lambda$0;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TribeeHomeInitialState invokeSuspend$lambda$0(State $state, TribeeHomeState $this$override) {
        return new TribeeHomeInitialState(null, null, ((TribeeHomeState) $state.getSnapshot()).getCategoryId(), false, 11, null);
    }
}