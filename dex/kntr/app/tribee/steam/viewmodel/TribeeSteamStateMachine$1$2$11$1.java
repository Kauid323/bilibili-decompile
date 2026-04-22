package kntr.app.tribee.steam.viewmodel;

import com.bapis.bilibili.app.dynamic.v2.KTribeeSteamHomeGame;
import com.bapis.bilibili.app.dynamic.v2.KTribeeSteamHomeGameItem;
import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import kntr.app.tribee.steam.service.TribeeSteamDataService;
import kntr.app.tribee.steam.state.TribeeSteamGameAchievementState;
import kntr.app.tribee.steam.state.TribeeSteamState;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TribeeSteamStateMachine.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/tribee/steam/state/TribeeSteamState;", "it", "Lcom/freeletics/flowredux/dsl/State;", "Lkntr/app/tribee/steam/state/TribeeSteamState$SteamInfoState;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.tribee.steam.viewmodel.TribeeSteamStateMachine$1$2$11$1", f = "TribeeSteamStateMachine.kt", i = {0, 0, 0}, l = {265}, m = "invokeSuspend", n = {"it", "game", "games"}, s = {"L$0", "L$1", "L$2"}, v = 1)
public final class TribeeSteamStateMachine$1$2$11$1 extends SuspendLambda implements Function2<State<TribeeSteamState.SteamInfoState>, Continuation<? super ChangedState<? extends TribeeSteamState>>, Object> {
    /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ TribeeSteamStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TribeeSteamStateMachine$1$2$11$1(TribeeSteamStateMachine tribeeSteamStateMachine, Continuation<? super TribeeSteamStateMachine$1$2$11$1> continuation) {
        super(2, continuation);
        this.this$0 = tribeeSteamStateMachine;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> tribeeSteamStateMachine$1$2$11$1 = new TribeeSteamStateMachine$1$2$11$1(this.this$0, continuation);
        tribeeSteamStateMachine$1$2$11$1.L$0 = obj;
        return tribeeSteamStateMachine$1$2$11$1;
    }

    public final Object invoke(State<TribeeSteamState.SteamInfoState> state, Continuation<? super ChangedState<? extends TribeeSteamState>> continuation) {
        return create(state, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        TribeeSteamDataService tribeeSteamDataService;
        Object switchGameAchievementState;
        KTribeeSteamHomeGame games;
        State it = (State) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                KTribeeSteamHomeGameItem game = ((TribeeSteamState.SteamInfoState) it.getSnapshot()).getAchievementState().getSelectedGame();
                KTribeeSteamHomeGame games2 = ((TribeeSteamState.SteamInfoState) it.getSnapshot()).getAchievementState().getGames();
                if (game != null && games2 != null) {
                    tribeeSteamDataService = this.this$0.dataService;
                    this.L$0 = it;
                    this.L$1 = SpillingKt.nullOutSpilledVariable(game);
                    this.L$2 = SpillingKt.nullOutSpilledVariable(games2);
                    this.label = 1;
                    switchGameAchievementState = tribeeSteamDataService.switchGameAchievementState(game, games2, ((TribeeSteamState.SteamInfoState) it.getSnapshot()).getAchievementState().getAchievements(), (Continuation) this);
                    if (switchGameAchievementState == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    games = games2;
                    break;
                } else {
                    return it.noChange();
                }
            case 1:
                games = (KTribeeSteamHomeGame) this.L$2;
                KTribeeSteamHomeGameItem kTribeeSteamHomeGameItem = (KTribeeSteamHomeGameItem) this.L$1;
                ResultKt.throwOnFailure($result);
                switchGameAchievementState = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        final TribeeSteamGameAchievementState achievementState = (TribeeSteamGameAchievementState) switchGameAchievementState;
        return it.override(new Function1() { // from class: kntr.app.tribee.steam.viewmodel.TribeeSteamStateMachine$1$2$11$1$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                TribeeSteamState.SteamInfoState invokeSuspend$lambda$0$0;
                invokeSuspend$lambda$0$0 = TribeeSteamStateMachine$1$2$11$1.invokeSuspend$lambda$0$0(TribeeSteamGameAchievementState.this, (TribeeSteamState.SteamInfoState) obj);
                return invokeSuspend$lambda$0$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TribeeSteamState.SteamInfoState invokeSuspend$lambda$0$0(TribeeSteamGameAchievementState $achievementState, TribeeSteamState.SteamInfoState $this$override) {
        return TribeeSteamState.SteamInfoState.copy$default($this$override, null, null, null, null, null, $achievementState, null, null, null, null, false, null, null, 8159, null);
    }
}