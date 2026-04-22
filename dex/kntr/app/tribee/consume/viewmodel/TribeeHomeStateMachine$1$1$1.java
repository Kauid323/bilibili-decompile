package kntr.app.tribee.consume.viewmodel;

import com.bapis.bilibili.app.dynamic.v2.KAppMineRcmd;
import com.bapis.bilibili.app.dynamic.v2.KExitTribeeToast;
import com.bapis.bilibili.app.dynamic.v2.KGameStatsButton;
import com.bapis.bilibili.app.dynamic.v2.KGlobalPermissionType;
import com.bapis.bilibili.app.dynamic.v2.KJoinButton;
import com.bapis.bilibili.app.dynamic.v2.KPublishButton;
import com.bapis.bilibili.app.dynamic.v2.KShareConfig;
import com.bapis.bilibili.app.dynamic.v2.KToastDialog;
import com.bapis.bilibili.app.dynamic.v2.KTribeeBaseInfo;
import com.bapis.bilibili.app.dynamic.v2.KTribeeCategory;
import com.bapis.bilibili.app.dynamic.v2.KTribeeCategoryInfo;
import com.bapis.bilibili.app.dynamic.v2.KTribeeDesc;
import com.bapis.bilibili.app.dynamic.v2.KTribeeDynAllResp;
import com.bapis.bilibili.app.dynamic.v2.KTribeeInteraction;
import com.bapis.bilibili.app.dynamic.v2.KTribeeNavigation;
import com.bapis.bilibili.app.dynamic.v2.KTribeeSearchBar;
import com.bapis.bilibili.community.interfacess.cosmoconn.v1.KJoinTribeeByInviteCodeResult;
import com.bapis.bilibili.community.interfacess.cosmoconn.v1.KJoinTribeeByInviteCodeRsp;
import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kntr.app.tribee.consume.TribeeExtensionsKt;
import kntr.app.tribee.consume.page.model.TribeeDynListState;
import kntr.app.tribee.consume.page.model.TribeeFetchModel;
import kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction;
import kntr.app.tribee.consume.viewmodel.TribeeHomeUIAction;
import kntr.app.tribee.consume.viewmodel.service.TribeeHomeDataService;
import kntr.app.tribee.consume.viewmodel.state.TribeeHomeContentState;
import kntr.app.tribee.consume.viewmodel.state.TribeeHomeErrorState;
import kntr.app.tribee.consume.viewmodel.state.TribeeHomeInitialState;
import kntr.app.tribee.consume.viewmodel.state.TribeeHomeState;
import kntr.app.tribee.consume.viewmodel.state.TribeeToast;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.log.KLog_androidKt;
import kntr.watch.later.watchlater.edit.FavoriteSingleViewModelKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TribeeHomeStateMachine.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/tribee/consume/viewmodel/state/TribeeHomeState;", "state", "Lcom/freeletics/flowredux/dsl/State;", "Lkntr/app/tribee/consume/viewmodel/state/TribeeHomeInitialState;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.tribee.consume.viewmodel.TribeeHomeStateMachine$1$1$1", f = "TribeeHomeStateMachine.kt", i = {0, 1, 1, 1, 1, 1}, l = {65, FavoriteSingleViewModelKt.MAX_PAGE_SIZE}, m = "invokeSuspend", n = {"state", "state", "data", "rspCategoryList", "categoryList", "currentCategoryId"}, s = {"L$0", "L$0", "L$1", "L$2", "L$3", "J$0"}, v = 1)
public final class TribeeHomeStateMachine$1$1$1 extends SuspendLambda implements Function2<State<TribeeHomeInitialState>, Continuation<? super ChangedState<? extends TribeeHomeState>>, Object> {
    long J$0;
    /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ TribeeHomeStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TribeeHomeStateMachine$1$1$1(TribeeHomeStateMachine tribeeHomeStateMachine, Continuation<? super TribeeHomeStateMachine$1$1$1> continuation) {
        super(2, continuation);
        this.this$0 = tribeeHomeStateMachine;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> tribeeHomeStateMachine$1$1$1 = new TribeeHomeStateMachine$1$1$1(this.this$0, continuation);
        tribeeHomeStateMachine$1$1$1.L$0 = obj;
        return tribeeHomeStateMachine$1$1$1;
    }

    public final Object invoke(State<TribeeHomeInitialState> state, Continuation<? super ChangedState<? extends TribeeHomeState>> continuation) {
        return create(state, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00ad A[Catch: Exception -> 0x003b, TryCatch #0 {Exception -> 0x003b, blocks: (B:82:0x01aa, B:11:0x0035, B:19:0x0063, B:21:0x006c, B:24:0x0074, B:26:0x007a, B:28:0x0080, B:30:0x0087, B:32:0x0094, B:34:0x00a0, B:40:0x00ad, B:50:0x010f, B:52:0x0121, B:54:0x0129, B:59:0x0138, B:61:0x013e, B:63:0x0144, B:65:0x014a, B:67:0x0152, B:69:0x0158, B:71:0x015e, B:72:0x0162, B:84:0x01ba, B:41:0x00c5, B:42:0x00cd, B:44:0x00d3, B:46:0x00e9, B:48:0x0102, B:47:0x00fa, B:31:0x008c, B:86:0x01c4, B:87:0x01cb, B:16:0x0042), top: B:90:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00c5 A[Catch: Exception -> 0x003b, TryCatch #0 {Exception -> 0x003b, blocks: (B:82:0x01aa, B:11:0x0035, B:19:0x0063, B:21:0x006c, B:24:0x0074, B:26:0x007a, B:28:0x0080, B:30:0x0087, B:32:0x0094, B:34:0x00a0, B:40:0x00ad, B:50:0x010f, B:52:0x0121, B:54:0x0129, B:59:0x0138, B:61:0x013e, B:63:0x0144, B:65:0x014a, B:67:0x0152, B:69:0x0158, B:71:0x015e, B:72:0x0162, B:84:0x01ba, B:41:0x00c5, B:42:0x00cd, B:44:0x00d3, B:46:0x00e9, B:48:0x0102, B:47:0x00fa, B:31:0x008c, B:86:0x01c4, B:87:0x01cb, B:16:0x0042), top: B:90:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0121 A[Catch: Exception -> 0x003b, TryCatch #0 {Exception -> 0x003b, blocks: (B:82:0x01aa, B:11:0x0035, B:19:0x0063, B:21:0x006c, B:24:0x0074, B:26:0x007a, B:28:0x0080, B:30:0x0087, B:32:0x0094, B:34:0x00a0, B:40:0x00ad, B:50:0x010f, B:52:0x0121, B:54:0x0129, B:59:0x0138, B:61:0x013e, B:63:0x0144, B:65:0x014a, B:67:0x0152, B:69:0x0158, B:71:0x015e, B:72:0x0162, B:84:0x01ba, B:41:0x00c5, B:42:0x00cd, B:44:0x00d3, B:46:0x00e9, B:48:0x0102, B:47:0x00fa, B:31:0x008c, B:86:0x01c4, B:87:0x01cb, B:16:0x0042), top: B:90:0x000e }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        TribeeHomeDataService tribeeHomeDataService;
        Object initialData$default;
        final KTribeeDynAllResp data;
        boolean z;
        KGlobalPermissionType kGlobalPermissionType;
        boolean z2;
        TribeeDynListState tribeeDynListState;
        ChangedState override;
        String str;
        final Exception e;
        Map categoryList;
        long currentCategoryId;
        TribeeHomeDataService tribeeHomeDataService2;
        String str2;
        Object joinByInviteCode;
        Object obj;
        KJoinButton join;
        KJoinButton join2;
        final State state = (State) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    tribeeHomeDataService = this.this$0.dataService;
                    this.L$0 = state;
                    this.label = 1;
                    initialData$default = TribeeHomeDataService.initialData$default(tribeeHomeDataService, ((TribeeHomeInitialState) state.getSnapshot()).getCategoryId(), null, (Continuation) this, 2, null);
                    if (initialData$default == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    initialData$default = $result;
                    break;
                case 2:
                    currentCategoryId = this.J$0;
                    categoryList = (Map) this.L$3;
                    List list = (List) this.L$2;
                    data = (KTribeeDynAllResp) this.L$1;
                    try {
                        ResultKt.throwOnFailure($result);
                        obj = $result;
                        final KJoinTribeeByInviteCodeRsp joinRsp = (KJoinTribeeByInviteCodeRsp) obj;
                        final KTribeeDynAllResp kTribeeDynAllResp = data;
                        final Map map = categoryList;
                        final long j = currentCategoryId;
                        override = state.override(new Function1() { // from class: kntr.app.tribee.consume.viewmodel.TribeeHomeStateMachine$1$1$1$$ExternalSyntheticLambda0
                            public final Object invoke(Object obj2) {
                                TribeeHomeContentState invokeSuspend$lambda$1;
                                invokeSuspend$lambda$1 = TribeeHomeStateMachine$1$1$1.invokeSuspend$lambda$1(kTribeeDynAllResp, joinRsp, map, j, (TribeeHomeInitialState) obj2);
                                return invokeSuspend$lambda$1;
                            }
                        });
                    } catch (Exception e2) {
                        e = e2;
                        final KTribeeDynAllResp kTribeeDynAllResp2 = data;
                        final Map map2 = categoryList;
                        final long j2 = currentCategoryId;
                        override = state.override(new Function1() { // from class: kntr.app.tribee.consume.viewmodel.TribeeHomeStateMachine$1$1$1$$ExternalSyntheticLambda1
                            public final Object invoke(Object obj2) {
                                TribeeHomeContentState invokeSuspend$lambda$2;
                                invokeSuspend$lambda$2 = TribeeHomeStateMachine$1$1$1.invokeSuspend$lambda$2(kTribeeDynAllResp2, e, map2, j2, (TribeeHomeInitialState) obj2);
                                return invokeSuspend$lambda$2;
                            }
                        });
                        return override;
                    }
                    return override;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            data = (KTribeeDynAllResp) initialData$default;
            KTribeeBaseInfo baseInfo = data.getBaseInfo();
            if ((baseInfo != null ? baseInfo.getTribeeInfo() : null) != null) {
                KTribeeCategoryInfo category = data.getCategory();
                Iterable rspCategoryList = category != null ? category.getCategoryList() : null;
                KTribeeCategoryInfo category2 = data.getCategory();
                final long currentCategoryId2 = category2 != null ? category2.getCurrentCategoryId() : TribeeExtensionsKt.getDEFAULT_CATEGORY().getId();
                Map $this$invokeSuspend_u24lambda_u240 = MapsKt.createMapBuilder();
                boolean z3 = false;
                List list2 = (Collection) rspCategoryList;
                if (list2 != null && !list2.isEmpty()) {
                    z = false;
                    if (z) {
                        Iterable $this$forEach$iv = rspCategoryList;
                        for (Object element$iv : $this$forEach$iv) {
                            KTribeeCategory it = (KTribeeCategory) element$iv;
                            if (it.getId() == currentCategoryId2) {
                                z2 = z3;
                                tribeeDynListState = new TribeeDynListState(data.getContent(), data.getSortInfo());
                            } else {
                                z2 = z3;
                                tribeeDynListState = new TribeeDynListState(null, null);
                            }
                            $this$invokeSuspend_u24lambda_u240.put(it, tribeeDynListState);
                            z3 = z2;
                        }
                        kGlobalPermissionType = null;
                    } else {
                        $this$invokeSuspend_u24lambda_u240.put(TribeeExtensionsKt.getDEFAULT_CATEGORY(), new TribeeDynListState(data.getContent(), data.getSortInfo()));
                        kGlobalPermissionType = null;
                    }
                    final Map categoryList2 = MapsKt.build($this$invokeSuspend_u24lambda_u240);
                    if (((TribeeHomeInitialState) state.getSnapshot()).getAutoCheckJoin()) {
                        str = this.this$0.inviteCodeFromRouter;
                        if (str != null && (StringsKt.isBlank(str) ^ true)) {
                            KTribeeInteraction interaction = data.getInteraction();
                            if (!Intrinsics.areEqual((interaction == null || (join2 = interaction.getJoin()) == null) ? kGlobalPermissionType : join2.getPermType(), KGlobalPermissionType.QUALIFIED.INSTANCE)) {
                                KTribeeInteraction interaction2 = data.getInteraction();
                                if (interaction2 != null && (join = interaction2.getJoin()) != null) {
                                    kGlobalPermissionType = join.getPermType();
                                }
                                if (!Intrinsics.areEqual(kGlobalPermissionType, KGlobalPermissionType.QUALIFIED_BUT_BANNED.INSTANCE)) {
                                    try {
                                        tribeeHomeDataService2 = this.this$0.dataService;
                                        str2 = this.this$0.inviteCodeFromRouter;
                                        this.L$0 = state;
                                        this.L$1 = data;
                                        this.L$2 = SpillingKt.nullOutSpilledVariable(rspCategoryList);
                                        this.L$3 = categoryList2;
                                        this.J$0 = currentCategoryId2;
                                        this.label = 2;
                                        joinByInviteCode = tribeeHomeDataService2.joinByInviteCode(str2, (Continuation) this);
                                    } catch (Exception e3) {
                                        e = e3;
                                        categoryList = categoryList2;
                                        currentCategoryId = currentCategoryId2;
                                        final KTribeeDynAllResp kTribeeDynAllResp22 = data;
                                        final Map map22 = categoryList;
                                        final long j22 = currentCategoryId;
                                        override = state.override(new Function1() { // from class: kntr.app.tribee.consume.viewmodel.TribeeHomeStateMachine$1$1$1$$ExternalSyntheticLambda1
                                            public final Object invoke(Object obj2) {
                                                TribeeHomeContentState invokeSuspend$lambda$2;
                                                invokeSuspend$lambda$2 = TribeeHomeStateMachine$1$1$1.invokeSuspend$lambda$2(kTribeeDynAllResp22, e, map22, j22, (TribeeHomeInitialState) obj2);
                                                return invokeSuspend$lambda$2;
                                            }
                                        });
                                        return override;
                                    }
                                    if (joinByInviteCode == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    categoryList = categoryList2;
                                    obj = joinByInviteCode;
                                    currentCategoryId = currentCategoryId2;
                                    final KJoinTribeeByInviteCodeRsp joinRsp2 = (KJoinTribeeByInviteCodeRsp) obj;
                                    final KTribeeDynAllResp kTribeeDynAllResp3 = data;
                                    final Map map3 = categoryList;
                                    final long j3 = currentCategoryId;
                                    override = state.override(new Function1() { // from class: kntr.app.tribee.consume.viewmodel.TribeeHomeStateMachine$1$1$1$$ExternalSyntheticLambda0
                                        public final Object invoke(Object obj2) {
                                            TribeeHomeContentState invokeSuspend$lambda$1;
                                            invokeSuspend$lambda$1 = TribeeHomeStateMachine$1$1$1.invokeSuspend$lambda$1(kTribeeDynAllResp3, joinRsp2, map3, j3, (TribeeHomeInitialState) obj2);
                                            return invokeSuspend$lambda$1;
                                        }
                                    });
                                    return override;
                                }
                            }
                        }
                    }
                    override = state.override(new Function1() { // from class: kntr.app.tribee.consume.viewmodel.TribeeHomeStateMachine$1$1$1$$ExternalSyntheticLambda2
                        public final Object invoke(Object obj2) {
                            TribeeHomeContentState invokeSuspend$lambda$3;
                            invokeSuspend$lambda$3 = TribeeHomeStateMachine$1$1$1.invokeSuspend$lambda$3(data, categoryList2, currentCategoryId2, (TribeeHomeInitialState) obj2);
                            return invokeSuspend$lambda$3;
                        }
                    });
                    return override;
                }
                z = true;
                if (z) {
                }
                final Map categoryList22 = MapsKt.build($this$invokeSuspend_u24lambda_u240);
                if (((TribeeHomeInitialState) state.getSnapshot()).getAutoCheckJoin()) {
                }
                override = state.override(new Function1() { // from class: kntr.app.tribee.consume.viewmodel.TribeeHomeStateMachine$1$1$1$$ExternalSyntheticLambda2
                    public final Object invoke(Object obj2) {
                        TribeeHomeContentState invokeSuspend$lambda$3;
                        invokeSuspend$lambda$3 = TribeeHomeStateMachine$1$1$1.invokeSuspend$lambda$3(data, categoryList22, currentCategoryId2, (TribeeHomeInitialState) obj2);
                        return invokeSuspend$lambda$3;
                    }
                });
                return override;
            }
            throw new Exception("data error!");
        } catch (Exception e4) {
            KLog_androidKt.getKLog().e("TribeeHomeStateMachine", "initial error! (" + e4.getMessage() + ")");
            return state.override(new Function1() { // from class: kntr.app.tribee.consume.viewmodel.TribeeHomeStateMachine$1$1$1$$ExternalSyntheticLambda3
                public final Object invoke(Object obj2) {
                    TribeeHomeErrorState invokeSuspend$lambda$4;
                    invokeSuspend$lambda$4 = TribeeHomeStateMachine$1$1$1.invokeSuspend$lambda$4(e4, state, (TribeeHomeInitialState) obj2);
                    return invokeSuspend$lambda$4;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TribeeHomeContentState invokeSuspend$lambda$1(KTribeeDynAllResp $data, KJoinTribeeByInviteCodeRsp $joinRsp, Map $categoryList, long $currentCategoryId, TribeeHomeInitialState $this$override) {
        KTribeeBaseInfo kTribeeBaseInfo;
        KTribeeInteraction kTribeeInteraction;
        KPublishButton publish;
        KJoinButton join;
        KTribeeBaseInfo baseInfo = $data.getBaseInfo();
        if (baseInfo != null) {
            kTribeeBaseInfo = KTribeeBaseInfo.copy$default(baseInfo, (KTribeeDesc) null, Intrinsics.areEqual($joinRsp.getResult(), KJoinTribeeByInviteCodeResult.JOIN_BY_INV_SUCCESS.INSTANCE) || Intrinsics.areEqual($joinRsp.getResult(), KJoinTribeeByInviteCodeResult.JOIN_BY_INV_FAIL_JOINED.INSTANCE), false, false, (String) null, (KTribeeSearchBar) null, 61, (Object) null);
        } else {
            kTribeeBaseInfo = null;
        }
        KTribeeInteraction interaction = $data.getInteraction();
        if (interaction != null) {
            KTribeeInteraction interaction2 = $data.getInteraction();
            KJoinButton copy$default = (interaction2 == null || (join = interaction2.getJoin()) == null) ? null : KJoinButton.copy$default(join, $joinRsp.getPermType(), (KToastDialog) null, (KToastDialog) null, 6, (Object) null);
            KTribeeInteraction interaction3 = $data.getInteraction();
            kTribeeInteraction = KTribeeInteraction.copy$default(interaction, (interaction3 == null || (publish = interaction3.getPublish()) == null) ? null : KPublishButton.copy$default(publish, $joinRsp.getPermType(), (String) null, (String) null, (KToastDialog) null, (KToastDialog) null, (KToastDialog) null, (KToastDialog) null, (KToastDialog) null, 254, (Object) null), (KExitTribeeToast) null, (KShareConfig) null, copy$default, (KGameStatsButton) null, (KAppMineRcmd) null, 54, (Object) null);
        } else {
            kTribeeInteraction = null;
        }
        KTribeeNavigation navigation = $data.getNavigation();
        KToastDialog dialog = $joinRsp.getToastDialog();
        return new TribeeHomeContentState(kTribeeBaseInfo, kTribeeInteraction, navigation, $categoryList, $currentCategoryId, new TribeeFetchModel(new TribeeHomeStateAction.Refresh(false), 1), null, dialog != null ? new TribeeHomeUIAction.ToastDialog(dialog) : null, 64, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TribeeHomeContentState invokeSuspend$lambda$2(KTribeeDynAllResp $data, Exception $e, Map $categoryList, long $currentCategoryId, TribeeHomeInitialState $this$override) {
        return new TribeeHomeContentState($data.getBaseInfo(), $data.getInteraction(), $data.getNavigation(), $categoryList, $currentCategoryId, null, null, new TribeeHomeUIAction.ToastTips(TribeeToast.Companion.create$default(TribeeToast.Companion, $e, null, 2, null)), 96, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TribeeHomeContentState invokeSuspend$lambda$3(KTribeeDynAllResp $data, Map $categoryList, long $currentCategoryId, TribeeHomeInitialState $this$override) {
        return new TribeeHomeContentState($data.getBaseInfo(), $data.getInteraction(), $data.getNavigation(), $categoryList, $currentCategoryId, null, null, null, 224, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TribeeHomeErrorState invokeSuspend$lambda$4(Exception $e, State $state, TribeeHomeInitialState $this$override) {
        return new TribeeHomeErrorState(new TribeeHomeUIAction.ToastTips(TribeeToast.Companion.create$default(TribeeToast.Companion, $e, null, 2, null)), SetsKt.emptySet(), ((TribeeHomeInitialState) $state.getSnapshot()).getCategoryId());
    }
}