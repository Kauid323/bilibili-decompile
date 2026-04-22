package kntr.app.tribee.consume.viewmodel;

import com.bapis.bilibili.app.dynamic.v2.KAppMineRcmd;
import com.bapis.bilibili.app.dynamic.v2.KExitTribeeToast;
import com.bapis.bilibili.app.dynamic.v2.KGameStatsButton;
import com.bapis.bilibili.app.dynamic.v2.KJoinButton;
import com.bapis.bilibili.app.dynamic.v2.KPublishButton;
import com.bapis.bilibili.app.dynamic.v2.KShareConfig;
import com.bapis.bilibili.app.dynamic.v2.KToastDialog;
import com.bapis.bilibili.app.dynamic.v2.KTribeeInteraction;
import com.bapis.bilibili.community.interfacess.cosmoconn.v1.KJoinTribeeCandidatePoolRsp;
import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction;
import kntr.app.tribee.consume.viewmodel.TribeeHomeUIAction;
import kntr.app.tribee.consume.viewmodel.service.TribeeHomeDataService;
import kntr.app.tribee.consume.viewmodel.state.TribeeHomeContentState;
import kntr.app.tribee.consume.viewmodel.state.TribeeHomeState;
import kntr.app.tribee.consume.viewmodel.state.TribeeToast;
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
/* compiled from: TribeeHomeStateMachine.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/tribee/consume/viewmodel/state/TribeeHomeState;", "action", "Lkntr/app/tribee/consume/viewmodel/TribeeHomeStateAction$ToJoinCandidatePool;", "state", "Lcom/freeletics/flowredux/dsl/State;", "Lkntr/app/tribee/consume/viewmodel/state/TribeeHomeContentState;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.tribee.consume.viewmodel.TribeeHomeStateMachine$1$2$4", f = "TribeeHomeStateMachine.kt", i = {0}, l = {290}, m = "invokeSuspend", n = {"state"}, s = {"L$0"}, v = 1)
public final class TribeeHomeStateMachine$1$2$4 extends SuspendLambda implements Function3<TribeeHomeStateAction.ToJoinCandidatePool, State<TribeeHomeContentState>, Continuation<? super ChangedState<? extends TribeeHomeState>>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ TribeeHomeStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TribeeHomeStateMachine$1$2$4(TribeeHomeStateMachine tribeeHomeStateMachine, Continuation<? super TribeeHomeStateMachine$1$2$4> continuation) {
        super(3, continuation);
        this.this$0 = tribeeHomeStateMachine;
    }

    public final Object invoke(TribeeHomeStateAction.ToJoinCandidatePool toJoinCandidatePool, State<TribeeHomeContentState> state, Continuation<? super ChangedState<? extends TribeeHomeState>> continuation) {
        TribeeHomeStateMachine$1$2$4 tribeeHomeStateMachine$1$2$4 = new TribeeHomeStateMachine$1$2$4(this.this$0, continuation);
        tribeeHomeStateMachine$1$2$4.L$0 = state;
        return tribeeHomeStateMachine$1$2$4.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        TribeeHomeDataService tribeeHomeDataService;
        Object joinCandidatePool;
        State state = (State) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    tribeeHomeDataService = this.this$0.dataService;
                    this.L$0 = state;
                    this.label = 1;
                    joinCandidatePool = tribeeHomeDataService.joinCandidatePool((Continuation) this);
                    if (joinCandidatePool == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    joinCandidatePool = $result;
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            final KJoinTribeeCandidatePoolRsp rsp = (KJoinTribeeCandidatePoolRsp) joinCandidatePool;
            final String resultTips = rsp.getToast();
            return state.mutate(new Function1() { // from class: kntr.app.tribee.consume.viewmodel.TribeeHomeStateMachine$1$2$4$$ExternalSyntheticLambda0
                public final Object invoke(Object obj) {
                    TribeeHomeContentState invokeSuspend$lambda$0;
                    invokeSuspend$lambda$0 = TribeeHomeStateMachine$1$2$4.invokeSuspend$lambda$0(resultTips, rsp, (TribeeHomeContentState) obj);
                    return invokeSuspend$lambda$0;
                }
            });
        } catch (Exception e) {
            KLog_androidKt.getKLog().e("TribeeHomeStateMachine", "join tribee candidate pool error! (" + e.getMessage() + ")");
            return state.mutate(new Function1() { // from class: kntr.app.tribee.consume.viewmodel.TribeeHomeStateMachine$1$2$4$$ExternalSyntheticLambda1
                public final Object invoke(Object obj) {
                    TribeeHomeContentState invokeSuspend$lambda$1;
                    invokeSuspend$lambda$1 = TribeeHomeStateMachine$1$2$4.invokeSuspend$lambda$1(e, (TribeeHomeContentState) obj);
                    return invokeSuspend$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TribeeHomeContentState invokeSuspend$lambda$0(String $resultTips, KJoinTribeeCandidatePoolRsp $rsp, TribeeHomeContentState $this$mutate) {
        TribeeHomeContentState copy;
        TribeeHomeUIAction.ToastTips toastTips = new TribeeHomeUIAction.ToastTips(TribeeToast.Companion.create($resultTips));
        KTribeeInteraction interaction = $this$mutate.getInteraction();
        if (interaction != null) {
            KJoinButton join = $this$mutate.getInteraction().getJoin();
            KJoinButton copy$default = join != null ? KJoinButton.copy$default(join, $rsp.getPermType(), (KToastDialog) null, (KToastDialog) null, 6, (Object) null) : null;
            KPublishButton publish = $this$mutate.getInteraction().getPublish();
            r1 = KTribeeInteraction.copy$default(interaction, publish != null ? KPublishButton.copy$default(publish, $rsp.getPermType(), (String) null, (String) null, (KToastDialog) null, (KToastDialog) null, (KToastDialog) null, (KToastDialog) null, (KToastDialog) null, 254, (Object) null) : null, (KExitTribeeToast) null, (KShareConfig) null, copy$default, (KGameStatsButton) null, (KAppMineRcmd) null, 54, (Object) null);
        }
        copy = $this$mutate.copy((r20 & 1) != 0 ? $this$mutate.baseInfo : null, (r20 & 2) != 0 ? $this$mutate.interaction : r1, (r20 & 4) != 0 ? $this$mutate.navigation : null, (r20 & 8) != 0 ? $this$mutate.categoryList : null, (r20 & 16) != 0 ? $this$mutate.categoryId : 0L, (r20 & 32) != 0 ? $this$mutate.fetchModel : null, (r20 & 64) != 0 ? $this$mutate.observedRequestingActions : null, (r20 & 128) != 0 ? $this$mutate.uiAction : toastTips);
        return copy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TribeeHomeContentState invokeSuspend$lambda$1(Exception $e, TribeeHomeContentState $this$mutate) {
        TribeeHomeContentState copy;
        copy = $this$mutate.copy((r20 & 1) != 0 ? $this$mutate.baseInfo : null, (r20 & 2) != 0 ? $this$mutate.interaction : null, (r20 & 4) != 0 ? $this$mutate.navigation : null, (r20 & 8) != 0 ? $this$mutate.categoryList : null, (r20 & 16) != 0 ? $this$mutate.categoryId : 0L, (r20 & 32) != 0 ? $this$mutate.fetchModel : null, (r20 & 64) != 0 ? $this$mutate.observedRequestingActions : null, (r20 & 128) != 0 ? $this$mutate.uiAction : new TribeeHomeUIAction.ToastTips(TribeeToast.Companion.create$default(TribeeToast.Companion, $e, null, 2, null)));
        return copy;
    }
}