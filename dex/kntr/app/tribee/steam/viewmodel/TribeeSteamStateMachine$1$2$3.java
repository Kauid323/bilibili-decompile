package kntr.app.tribee.steam.viewmodel;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import kntr.app.tribee.steam.state.TribeeSteamShareState;
import kntr.app.tribee.steam.state.TribeeSteamState;
import kntr.app.tribee.steam.viewmodel.TribeeSteamStateAction;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.log.KLog_androidKt;
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
/* compiled from: TribeeSteamStateMachine.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/tribee/steam/state/TribeeSteamState;", "<unused var>", "Lkntr/app/tribee/steam/viewmodel/TribeeSteamStateAction$EndShare;", "state", "Lcom/freeletics/flowredux/dsl/State;", "Lkntr/app/tribee/steam/state/TribeeSteamState$SteamInfoState;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.tribee.steam.viewmodel.TribeeSteamStateMachine$1$2$3", f = "TribeeSteamStateMachine.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class TribeeSteamStateMachine$1$2$3 extends SuspendLambda implements Function3<TribeeSteamStateAction.EndShare, State<TribeeSteamState.SteamInfoState>, Continuation<? super ChangedState<? extends TribeeSteamState>>, Object> {
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TribeeSteamStateMachine$1$2$3(Continuation<? super TribeeSteamStateMachine$1$2$3> continuation) {
        super(3, continuation);
    }

    public final Object invoke(TribeeSteamStateAction.EndShare endShare, State<TribeeSteamState.SteamInfoState> state, Continuation<? super ChangedState<? extends TribeeSteamState>> continuation) {
        TribeeSteamStateMachine$1$2$3 tribeeSteamStateMachine$1$2$3 = new TribeeSteamStateMachine$1$2$3(continuation);
        tribeeSteamStateMachine$1$2$3.L$0 = state;
        return tribeeSteamStateMachine$1$2$3.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        State state = (State) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                KLog_androidKt.getKLog().d("TribeeSteamStateMachine", "end share");
                return state.mutate(new Function1() { // from class: kntr.app.tribee.steam.viewmodel.TribeeSteamStateMachine$1$2$3$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        TribeeSteamState.SteamInfoState invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = TribeeSteamStateMachine$1$2$3.invokeSuspend$lambda$0((TribeeSteamState.SteamInfoState) obj);
                        return invokeSuspend$lambda$0;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TribeeSteamState.SteamInfoState invokeSuspend$lambda$0(TribeeSteamState.SteamInfoState $this$mutate) {
        return TribeeSteamState.SteamInfoState.copy$default($this$mutate, null, null, null, null, null, null, TribeeSteamShareState.InitialState.INSTANCE, null, null, null, false, null, null, 8127, null);
    }
}