package kntr.app.tribee.consume.viewmodel;

import com.bapis.bilibili.app.dynamic.v2.KAppMineRcmd;
import com.bapis.bilibili.app.dynamic.v2.KExitTribeeToast;
import com.bapis.bilibili.app.dynamic.v2.KGameStatsButton;
import com.bapis.bilibili.app.dynamic.v2.KJoinButton;
import com.bapis.bilibili.app.dynamic.v2.KPublishButton;
import com.bapis.bilibili.app.dynamic.v2.KShareConfig;
import com.bapis.bilibili.app.dynamic.v2.KToastDialog;
import com.bapis.bilibili.app.dynamic.v2.KTribeeBaseInfo;
import com.bapis.bilibili.app.dynamic.v2.KTribeeDesc;
import com.bapis.bilibili.app.dynamic.v2.KTribeeInteraction;
import com.bapis.bilibili.app.dynamic.v2.KTribeeSearchBar;
import com.bapis.bilibili.community.interfacess.cosmoconn.v1.KJoinTribeeByInviteCodeResult;
import com.bapis.bilibili.community.interfacess.cosmoconn.v1.KJoinTribeeByInviteCodeRsp;
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
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TribeeHomeStateMachine.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/tribee/consume/viewmodel/state/TribeeHomeState;", "action", "Lkntr/app/tribee/consume/viewmodel/TribeeHomeStateAction$ToJoinTribeeByInviteCode;", "state", "Lcom/freeletics/flowredux/dsl/State;", "Lkntr/app/tribee/consume/viewmodel/state/TribeeHomeContentState;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.tribee.consume.viewmodel.TribeeHomeStateMachine$1$2$3", f = "TribeeHomeStateMachine.kt", i = {0, 0, 1, 1, 1}, l = {239, 240}, m = "invokeSuspend", n = {"action", "state", "action", "state", "joinRsp"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2"}, v = 1)
public final class TribeeHomeStateMachine$1$2$3 extends SuspendLambda implements Function3<TribeeHomeStateAction.ToJoinTribeeByInviteCode, State<TribeeHomeContentState>, Continuation<? super ChangedState<? extends TribeeHomeState>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ TribeeHomeStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TribeeHomeStateMachine$1$2$3(TribeeHomeStateMachine tribeeHomeStateMachine, Continuation<? super TribeeHomeStateMachine$1$2$3> continuation) {
        super(3, continuation);
        this.this$0 = tribeeHomeStateMachine;
    }

    public final Object invoke(TribeeHomeStateAction.ToJoinTribeeByInviteCode toJoinTribeeByInviteCode, State<TribeeHomeContentState> state, Continuation<? super ChangedState<? extends TribeeHomeState>> continuation) {
        TribeeHomeStateMachine$1$2$3 tribeeHomeStateMachine$1$2$3 = new TribeeHomeStateMachine$1$2$3(this.this$0, continuation);
        tribeeHomeStateMachine$1$2$3.L$0 = toJoinTribeeByInviteCode;
        tribeeHomeStateMachine$1$2$3.L$1 = state;
        return tribeeHomeStateMachine$1$2$3.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0090 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0091  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        TribeeHomeDataService tribeeHomeDataService;
        Object joinByInviteCode;
        final KJoinTribeeByInviteCodeRsp joinRsp;
        TribeeHomeStateAction.ToJoinTribeeByInviteCode action = (TribeeHomeStateAction.ToJoinTribeeByInviteCode) this.L$0;
        State state = (State) this.L$1;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    if (!StringsKt.isBlank(action.getInviteCode())) {
                        KTribeeBaseInfo baseInfo = ((TribeeHomeContentState) state.getSnapshot()).getBaseInfo();
                        if (!(baseInfo != null && baseInfo.isJoined())) {
                            tribeeHomeDataService = this.this$0.dataService;
                            this.L$0 = SpillingKt.nullOutSpilledVariable(action);
                            this.L$1 = state;
                            this.label = 1;
                            joinByInviteCode = tribeeHomeDataService.joinByInviteCode(action.getInviteCode(), (Continuation) this);
                            if (joinByInviteCode == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            KJoinTribeeByInviteCodeRsp joinRsp2 = (KJoinTribeeByInviteCodeRsp) joinByInviteCode;
                            this.L$0 = SpillingKt.nullOutSpilledVariable(action);
                            this.L$1 = state;
                            this.L$2 = joinRsp2;
                            this.label = 2;
                            if (this.this$0.dispatch(new TribeeHomeStateAction.Refresh(false), (Continuation) this) != coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            joinRsp = joinRsp2;
                            return state.mutate(new Function1() { // from class: kntr.app.tribee.consume.viewmodel.TribeeHomeStateMachine$1$2$3$$ExternalSyntheticLambda0
                                public final Object invoke(Object obj) {
                                    TribeeHomeContentState invokeSuspend$lambda$0;
                                    invokeSuspend$lambda$0 = TribeeHomeStateMachine$1$2$3.invokeSuspend$lambda$0(joinRsp, (TribeeHomeContentState) obj);
                                    return invokeSuspend$lambda$0;
                                }
                            });
                        }
                    }
                    return state.noChange();
                case 1:
                    ResultKt.throwOnFailure($result);
                    joinByInviteCode = $result;
                    KJoinTribeeByInviteCodeRsp joinRsp22 = (KJoinTribeeByInviteCodeRsp) joinByInviteCode;
                    this.L$0 = SpillingKt.nullOutSpilledVariable(action);
                    this.L$1 = state;
                    this.L$2 = joinRsp22;
                    this.label = 2;
                    if (this.this$0.dispatch(new TribeeHomeStateAction.Refresh(false), (Continuation) this) != coroutine_suspended) {
                    }
                    break;
                case 2:
                    joinRsp = (KJoinTribeeByInviteCodeRsp) this.L$2;
                    ResultKt.throwOnFailure($result);
                    return state.mutate(new Function1() { // from class: kntr.app.tribee.consume.viewmodel.TribeeHomeStateMachine$1$2$3$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj) {
                            TribeeHomeContentState invokeSuspend$lambda$0;
                            invokeSuspend$lambda$0 = TribeeHomeStateMachine$1$2$3.invokeSuspend$lambda$0(joinRsp, (TribeeHomeContentState) obj);
                            return invokeSuspend$lambda$0;
                        }
                    });
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } catch (Exception e) {
            KLog_androidKt.getKLog().e("TribeeHomeStateMachine", "join tribee by invite code error! (" + e.getMessage() + ")");
            return state.mutate(new Function1() { // from class: kntr.app.tribee.consume.viewmodel.TribeeHomeStateMachine$1$2$3$$ExternalSyntheticLambda1
                public final Object invoke(Object obj) {
                    TribeeHomeContentState invokeSuspend$lambda$1;
                    invokeSuspend$lambda$1 = TribeeHomeStateMachine$1$2$3.invokeSuspend$lambda$1(e, (TribeeHomeContentState) obj);
                    return invokeSuspend$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TribeeHomeContentState invokeSuspend$lambda$0(KJoinTribeeByInviteCodeRsp $joinRsp, TribeeHomeContentState $this$mutate) {
        KTribeeBaseInfo kTribeeBaseInfo;
        KTribeeInteraction kTribeeInteraction;
        TribeeHomeContentState copy;
        KTribeeBaseInfo baseInfo = $this$mutate.getBaseInfo();
        if (baseInfo != null) {
            kTribeeBaseInfo = KTribeeBaseInfo.copy$default(baseInfo, (KTribeeDesc) null, Intrinsics.areEqual($joinRsp.getResult(), KJoinTribeeByInviteCodeResult.JOIN_BY_INV_SUCCESS.INSTANCE) || Intrinsics.areEqual($joinRsp.getResult(), KJoinTribeeByInviteCodeResult.JOIN_BY_INV_FAIL_JOINED.INSTANCE), false, false, (String) null, (KTribeeSearchBar) null, 61, (Object) null);
        } else {
            kTribeeBaseInfo = null;
        }
        KTribeeInteraction interaction = $this$mutate.getInteraction();
        if (interaction != null) {
            KJoinButton join = $this$mutate.getInteraction().getJoin();
            KJoinButton copy$default = join != null ? KJoinButton.copy$default(join, $joinRsp.getPermType(), (KToastDialog) null, (KToastDialog) null, 6, (Object) null) : null;
            KPublishButton publish = $this$mutate.getInteraction().getPublish();
            kTribeeInteraction = KTribeeInteraction.copy$default(interaction, publish != null ? KPublishButton.copy$default(publish, $joinRsp.getPermType(), (String) null, (String) null, (KToastDialog) null, (KToastDialog) null, (KToastDialog) null, (KToastDialog) null, (KToastDialog) null, 254, (Object) null) : null, (KExitTribeeToast) null, (KShareConfig) null, copy$default, (KGameStatsButton) null, (KAppMineRcmd) null, 54, (Object) null);
        } else {
            kTribeeInteraction = null;
        }
        KToastDialog dialog = $joinRsp.getToastDialog();
        copy = $this$mutate.copy((r20 & 1) != 0 ? $this$mutate.baseInfo : kTribeeBaseInfo, (r20 & 2) != 0 ? $this$mutate.interaction : kTribeeInteraction, (r20 & 4) != 0 ? $this$mutate.navigation : null, (r20 & 8) != 0 ? $this$mutate.categoryList : null, (r20 & 16) != 0 ? $this$mutate.categoryId : 0L, (r20 & 32) != 0 ? $this$mutate.fetchModel : null, (r20 & 64) != 0 ? $this$mutate.observedRequestingActions : null, (r20 & 128) != 0 ? $this$mutate.uiAction : dialog != null ? new TribeeHomeUIAction.ToastDialog(dialog) : null);
        return copy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TribeeHomeContentState invokeSuspend$lambda$1(Exception $e, TribeeHomeContentState $this$mutate) {
        TribeeHomeContentState copy;
        copy = $this$mutate.copy((r20 & 1) != 0 ? $this$mutate.baseInfo : null, (r20 & 2) != 0 ? $this$mutate.interaction : null, (r20 & 4) != 0 ? $this$mutate.navigation : null, (r20 & 8) != 0 ? $this$mutate.categoryList : null, (r20 & 16) != 0 ? $this$mutate.categoryId : 0L, (r20 & 32) != 0 ? $this$mutate.fetchModel : null, (r20 & 64) != 0 ? $this$mutate.observedRequestingActions : null, (r20 & 128) != 0 ? $this$mutate.uiAction : new TribeeHomeUIAction.ToastTips(TribeeToast.Companion.create$default(TribeeToast.Companion, $e, null, 2, null)));
        return copy;
    }
}