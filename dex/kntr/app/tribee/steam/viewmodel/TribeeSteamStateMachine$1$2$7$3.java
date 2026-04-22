package kntr.app.tribee.steam.viewmodel;

import com.bapis.bilibili.entitle.hub.interfaces.KGetShareGameDataUrlRsp;
import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import kntr.app.tribee.consume.TribeePreference;
import kntr.app.tribee.steam.page.share.TribeeSteamShareParamsKt;
import kntr.app.tribee.steam.state.TribeeSteamShareState;
import kntr.app.tribee.steam.state.TribeeSteamState;
import kntr.app.tribee.steam.viewmodel.TribeeSteamStateAction;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.log.KLog_androidKt;
import kntr.common.share.common.ui.ShareMenuVM;
import kntr.common.share.common.ui.ShareMenuViewAction;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TribeeSteamStateMachine.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/tribee/steam/state/TribeeSteamState;", "action", "Lkntr/app/tribee/steam/viewmodel/TribeeSteamStateAction$ToggleShareRange;", "state", "Lcom/freeletics/flowredux/dsl/State;", "Lkntr/app/tribee/steam/state/TribeeSteamState$SteamInfoState;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.tribee.steam.viewmodel.TribeeSteamStateMachine$1$2$7$3", f = "TribeeSteamStateMachine.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class TribeeSteamStateMachine$1$2$7$3 extends SuspendLambda implements Function3<TribeeSteamStateAction.ToggleShareRange, State<TribeeSteamState.SteamInfoState>, Continuation<? super ChangedState<? extends TribeeSteamState>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;
    final /* synthetic */ TribeeSteamStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TribeeSteamStateMachine$1$2$7$3(TribeeSteamStateMachine tribeeSteamStateMachine, Continuation<? super TribeeSteamStateMachine$1$2$7$3> continuation) {
        super(3, continuation);
        this.this$0 = tribeeSteamStateMachine;
    }

    public final Object invoke(TribeeSteamStateAction.ToggleShareRange toggleShareRange, State<TribeeSteamState.SteamInfoState> state, Continuation<? super ChangedState<? extends TribeeSteamState>> continuation) {
        TribeeSteamStateMachine$1$2$7$3 tribeeSteamStateMachine$1$2$7$3 = new TribeeSteamStateMachine$1$2$7$3(this.this$0, continuation);
        tribeeSteamStateMachine$1$2$7$3.L$0 = toggleShareRange;
        tribeeSteamStateMachine$1$2$7$3.L$1 = state;
        return tribeeSteamStateMachine$1$2$7$3.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        String shareLink;
        CoroutineScope coroutineScope;
        String str;
        long j;
        String str2;
        TribeeSteamStateAction.ToggleShareRange action = (TribeeSteamStateAction.ToggleShareRange) this.L$0;
        State state = (State) this.L$1;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                TribeeSteamShareState shareState = ((TribeeSteamState.SteamInfoState) state.getSnapshot()).getShareState();
                Intrinsics.checkNotNull(shareState, "null cannot be cast to non-null type kntr.app.tribee.steam.state.TribeeSteamShareState.MaterialLoadedSuccessState");
                TribeeSteamShareState.MaterialLoadedSuccessState shareState2 = (TribeeSteamShareState.MaterialLoadedSuccessState) shareState;
                KLog_androidKt.getKLog().d("TribeeSteamStateMachine", "toggle share range, isShareAllGame = " + action.isShareAllGame());
                TribeePreference.INSTANCE.setShowAllGamePreferences(action.isShareAllGame());
                if (action.isShareAllGame()) {
                    KGetShareGameDataUrlRsp allShareLinks = shareState2.getAllShareLinks();
                    shareLink = allShareLinks != null ? allShareLinks.getShareAllUrl() : null;
                } else {
                    KGetShareGameDataUrlRsp allShareLinks2 = shareState2.getAllShareLinks();
                    shareLink = allShareLinks2 != null ? allShareLinks2.getShareUrl() : null;
                }
                final TribeeSteamShareState.MaterialRefreshState newShareState = new TribeeSteamShareState.MaterialRefreshState(shareState2.isFromScreenShot(), action.isShareAllGame(), shareLink, shareState2.getAllShareLinks());
                coroutineScope = this.this$0.shareScope;
                TribeeSteamState.SteamInfoState steamInfoState = (TribeeSteamState.SteamInfoState) state.getSnapshot();
                str = this.this$0.tribeeId;
                String str3 = str == null ? "" : str;
                j = this.this$0.hostId;
                str2 = this.this$0.fromSpmid;
                final ShareMenuVM shareMenuVM = TribeeSteamShareParamsKt.getShareMenuViewModel(coroutineScope, steamInfoState, newShareState, j, str2 == null ? "" : str2, str3);
                shareMenuVM.dispatch(new ShareMenuViewAction.LoadChannelList(null, 1, null));
                KLog_androidKt.getKLog().d("TribeeSteamStateMachine", "waiting for channel list refresh");
                return state.mutate(new Function1() { // from class: kntr.app.tribee.steam.viewmodel.TribeeSteamStateMachine$1$2$7$3$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        TribeeSteamState.SteamInfoState invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = TribeeSteamStateMachine$1$2$7$3.invokeSuspend$lambda$0(TribeeSteamShareState.MaterialRefreshState.this, shareMenuVM, (TribeeSteamState.SteamInfoState) obj);
                        return invokeSuspend$lambda$0;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TribeeSteamState.SteamInfoState invokeSuspend$lambda$0(TribeeSteamShareState.MaterialRefreshState $newShareState, ShareMenuVM $shareMenuVM, TribeeSteamState.SteamInfoState $this$mutate) {
        return TribeeSteamState.SteamInfoState.copy$default($this$mutate, null, null, null, null, null, null, $newShareState, $shareMenuVM, null, null, false, null, null, 7999, null);
    }
}