package kntr.app.tribee.steam.viewmodel;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import kntr.app.tribee.steam.state.TribeeSteamShareState;
import kntr.app.tribee.steam.state.TribeeSteamState;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.log.KLog_androidKt;
import kntr.common.share.common.ui.ShareMenuViewState;
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
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/tribee/steam/state/TribeeSteamState;", "shareMenuState", "Lkntr/common/share/common/ui/ShareMenuViewState;", "state", "Lcom/freeletics/flowredux/dsl/State;", "Lkntr/app/tribee/steam/state/TribeeSteamState$SteamInfoState;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.tribee.steam.viewmodel.TribeeSteamStateMachine$1$2$9$2", f = "TribeeSteamStateMachine.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class TribeeSteamStateMachine$1$2$9$2 extends SuspendLambda implements Function3<ShareMenuViewState, State<TribeeSteamState.SteamInfoState>, Continuation<? super ChangedState<? extends TribeeSteamState>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TribeeSteamStateMachine$1$2$9$2(Continuation<? super TribeeSteamStateMachine$1$2$9$2> continuation) {
        super(3, continuation);
    }

    public final Object invoke(ShareMenuViewState shareMenuViewState, State<TribeeSteamState.SteamInfoState> state, Continuation<? super ChangedState<? extends TribeeSteamState>> continuation) {
        TribeeSteamStateMachine$1$2$9$2 tribeeSteamStateMachine$1$2$9$2 = new TribeeSteamStateMachine$1$2$9$2(continuation);
        tribeeSteamStateMachine$1$2$9$2.L$0 = shareMenuViewState;
        tribeeSteamStateMachine$1$2$9$2.L$1 = state;
        return tribeeSteamStateMachine$1$2$9$2.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        ShareMenuViewState shareMenuState = (ShareMenuViewState) this.L$0;
        final State state = (State) this.L$1;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (shareMenuState.isLoadedChannelList()) {
                    KLog_androidKt.getKLog().d("TribeeSteamStateMachine", "channel list loaded, update state");
                    final TribeeSteamShareState shareState = ((TribeeSteamState.SteamInfoState) state.getSnapshot()).getShareState();
                    return state.mutate(new Function1() { // from class: kntr.app.tribee.steam.viewmodel.TribeeSteamStateMachine$1$2$9$2$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj) {
                            TribeeSteamState.SteamInfoState invokeSuspend$lambda$0;
                            invokeSuspend$lambda$0 = TribeeSteamStateMachine$1$2$9$2.invokeSuspend$lambda$0(TribeeSteamShareState.this, state, (TribeeSteamState.SteamInfoState) obj);
                            return invokeSuspend$lambda$0;
                        }
                    });
                }
                KLog_androidKt.getKLog().d("TribeeSteamStateMachine", "channel list not loaded yet");
                return state.noChange();
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TribeeSteamState.SteamInfoState invokeSuspend$lambda$0(TribeeSteamShareState $shareState, State $state, TribeeSteamState.SteamInfoState $this$mutate) {
        return TribeeSteamState.SteamInfoState.copy$default($this$mutate, null, null, null, null, null, null, new TribeeSteamShareState.MaterialLoadedSuccessState($shareState.isFromScreenShot(), $shareState.isShareAllGame(), null, $shareState.getShareLink(), $shareState.getAllShareLinks(), false, 36, null), ((TribeeSteamState.SteamInfoState) $state.getSnapshot()).getShareMenuVM(), null, null, false, null, null, 7999, null);
    }
}