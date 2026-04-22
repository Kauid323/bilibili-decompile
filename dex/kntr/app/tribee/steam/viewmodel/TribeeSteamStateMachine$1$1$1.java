package kntr.app.tribee.steam.viewmodel;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import kntr.app.tribee.steam.service.TribeeSteamDataService;
import kntr.app.tribee.steam.state.TribeeSteamState;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TribeeSteamStateMachine.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/tribee/steam/state/TribeeSteamState;", "state", "Lcom/freeletics/flowredux/dsl/State;", "Lkntr/app/tribee/steam/state/TribeeSteamState$InitialState;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.tribee.steam.viewmodel.TribeeSteamStateMachine$1$1$1", f = "TribeeSteamStateMachine.kt", i = {0}, l = {45}, m = "invokeSuspend", n = {"state"}, s = {"L$0"}, v = 1)
public final class TribeeSteamStateMachine$1$1$1 extends SuspendLambda implements Function2<State<TribeeSteamState.InitialState>, Continuation<? super ChangedState<? extends TribeeSteamState>>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ TribeeSteamStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TribeeSteamStateMachine$1$1$1(TribeeSteamStateMachine tribeeSteamStateMachine, Continuation<? super TribeeSteamStateMachine$1$1$1> continuation) {
        super(2, continuation);
        this.this$0 = tribeeSteamStateMachine;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> tribeeSteamStateMachine$1$1$1 = new TribeeSteamStateMachine$1$1$1(this.this$0, continuation);
        tribeeSteamStateMachine$1$1$1.L$0 = obj;
        return tribeeSteamStateMachine$1$1$1;
    }

    public final Object invoke(State<TribeeSteamState.InitialState> state, Continuation<? super ChangedState<? extends TribeeSteamState>> continuation) {
        return create(state, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        TribeeSteamDataService tribeeSteamDataService;
        Object initialState$default;
        State state = (State) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                tribeeSteamDataService = this.this$0.dataService;
                this.L$0 = state;
                this.label = 1;
                initialState$default = TribeeSteamDataService.initialState$default(tribeeSteamDataService, false, 0L, (Continuation) this, 3, null);
                if (initialState$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                initialState$default = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        final TribeeSteamState newState = (TribeeSteamState) initialState$default;
        return state.override(new Function1() { // from class: kntr.app.tribee.steam.viewmodel.TribeeSteamStateMachine$1$1$1$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                TribeeSteamState invokeSuspend$lambda$0;
                invokeSuspend$lambda$0 = TribeeSteamStateMachine$1$1$1.invokeSuspend$lambda$0(TribeeSteamState.this, (TribeeSteamState.InitialState) obj);
                return invokeSuspend$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TribeeSteamState invokeSuspend$lambda$0(TribeeSteamState $newState, TribeeSteamState.InitialState $this$override) {
        return $newState;
    }
}