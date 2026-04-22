package kntr.app.tribee.consume.viewmodel;

import com.bapis.bilibili.app.dynamic.v2.KTribeeBaseInfo;
import com.bapis.bilibili.app.dynamic.v2.KTribeeCategory;
import com.bapis.bilibili.app.dynamic.v2.KTribeeCategoryInfo;
import com.bapis.bilibili.app.dynamic.v2.KTribeeContent;
import com.bapis.bilibili.app.dynamic.v2.KTribeeDynAllResp;
import com.bapis.bilibili.app.dynamic.v2.KTribeeSortInfo;
import com.bapis.bilibili.app.dynamic.v2.KTribeeSortType;
import com.bapis.bilibili.pagination.KPaginationReply;
import com.freeletics.flowredux.dsl.BaseBuilderBlock;
import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.ExecutionPolicy;
import com.freeletics.flowredux.dsl.FlowReduxStateMachine;
import com.freeletics.flowredux.dsl.FlowReduxStoreBuilder;
import com.freeletics.flowredux.dsl.IdentityBuilderBlock;
import com.freeletics.flowredux.dsl.InStateBuilderBlock;
import com.freeletics.flowredux.dsl.State;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import kntr.app.tribee.consume.TribeeExtensionsKt;
import kntr.app.tribee.consume.page.model.TribeeDynListState;
import kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction;
import kntr.app.tribee.consume.viewmodel.TribeeHomeUIAction;
import kntr.app.tribee.consume.viewmodel.service.TribeeHomeDataService;
import kntr.app.tribee.consume.viewmodel.state.TribeeHomeContentState;
import kntr.app.tribee.consume.viewmodel.state.TribeeHomeInitialState;
import kntr.app.tribee.consume.viewmodel.state.TribeeHomeState;
import kntr.app.tribee.consume.viewmodel.state.TribeeToast;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.account.KAccountStore;
import kntr.base.log.KLog_androidKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.flow.FlowKt;

/* compiled from: TribeeHomeStateMachine.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B1\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fJ*\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00032\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0082@¢\u0006\u0002\u0010\u0013J*\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00152\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0082@¢\u0006\u0002\u0010\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lkntr/app/tribee/consume/viewmodel/TribeeHomeStateMachine;", "Lcom/freeletics/flowredux/dsl/FlowReduxStateMachine;", "Lkntr/app/tribee/consume/viewmodel/state/TribeeHomeState;", "Lkntr/app/tribee/consume/viewmodel/TribeeHomeStateAction;", "dataService", "Lkntr/app/tribee/consume/viewmodel/service/TribeeHomeDataService;", "accountStore", "Lkntr/base/account/KAccountStore;", "inviteCodeFromRouter", "", "categoryIdFromRouter", "<init>", "(Lkntr/app/tribee/consume/viewmodel/service/TribeeHomeDataService;Lkntr/base/account/KAccountStore;Ljava/lang/String;Ljava/lang/String;)V", "handleRefresh", "Lcom/freeletics/flowredux/dsl/ChangedState;", "action", "state", "Lcom/freeletics/flowredux/dsl/State;", "Lkntr/app/tribee/consume/viewmodel/state/TribeeHomeContentState;", "(Lkntr/app/tribee/consume/viewmodel/TribeeHomeStateAction;Lcom/freeletics/flowredux/dsl/State;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleLoadMore", "Lkntr/app/tribee/consume/viewmodel/TribeeHomeStateAction$LoadMore;", "(Lkntr/app/tribee/consume/viewmodel/TribeeHomeStateAction$LoadMore;Lcom/freeletics/flowredux/dsl/State;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "consume_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeeHomeStateMachine extends FlowReduxStateMachine<TribeeHomeState, TribeeHomeStateAction> {
    public static final int $stable = 8;
    private final KAccountStore accountStore;
    private final TribeeHomeDataService dataService;
    private final String inviteCodeFromRouter;

    /* JADX WARN: Illegal instructions before constructor call */
    @Inject
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public TribeeHomeStateMachine(TribeeHomeDataService dataService, KAccountStore accountStore, @InviteCodeParam String inviteCodeFromRouter, @CategoryIdParam String categoryIdFromRouter) {
        super(new TribeeHomeInitialState(null, null, (categoryIdFromRouter == null || (r1 = StringsKt.toLongOrNull(categoryIdFromRouter)) == null) ? 0L : r1.longValue(), true, 3, null));
        Long longOrNull;
        Intrinsics.checkNotNullParameter(dataService, "dataService");
        Intrinsics.checkNotNullParameter(accountStore, "accountStore");
        this.dataService = dataService;
        this.accountStore = accountStore;
        this.inviteCodeFromRouter = inviteCodeFromRouter;
        spec(new Function1() { // from class: kntr.app.tribee.consume.viewmodel.TribeeHomeStateMachine$$ExternalSyntheticLambda9
            public final Object invoke(Object obj) {
                Unit _init_$lambda$0;
                _init_$lambda$0 = TribeeHomeStateMachine._init_$lambda$0(TribeeHomeStateMachine.this, (FlowReduxStoreBuilder) obj);
                return _init_$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$0(final TribeeHomeStateMachine this$0, FlowReduxStoreBuilder $this$spec) {
        Intrinsics.checkNotNullParameter($this$spec, "$this$spec");
        Function1 block$iv = new Function1() { // from class: kntr.app.tribee.consume.viewmodel.TribeeHomeStateMachine$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                return TribeeHomeStateMachine.lambda$0$0(TribeeHomeStateMachine.this, (InStateBuilderBlock) obj);
            }
        };
        $this$spec.inState(Reflection.getOrCreateKotlinClass(TribeeHomeInitialState.class), block$iv);
        Function1 block$iv2 = new Function1() { // from class: kntr.app.tribee.consume.viewmodel.TribeeHomeStateMachine$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                return TribeeHomeStateMachine.lambda$0$1(TribeeHomeStateMachine.this, (InStateBuilderBlock) obj);
            }
        };
        $this$spec.inState(Reflection.getOrCreateKotlinClass(TribeeHomeContentState.class), block$iv2);
        Function1 block$iv3 = new Function1() { // from class: kntr.app.tribee.consume.viewmodel.TribeeHomeStateMachine$$ExternalSyntheticLambda4
            public final Object invoke(Object obj) {
                return TribeeHomeStateMachine.lambda$0$2((InStateBuilderBlock) obj);
            }
        };
        $this$spec.inState(Reflection.getOrCreateKotlinClass(TribeeHomeState.class), block$iv3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$0$0(TribeeHomeStateMachine this$0, InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        $this$inState.onEnter(new TribeeHomeStateMachine$1$1$1(this$0, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$0$1(final TribeeHomeStateMachine this$0, InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        BaseBuilderBlock.collectWhileInStateEffect$default((BaseBuilderBlock) $this$inState, FlowKt.drop(this$0.accountStore.getState(), 1), (ExecutionPolicy) null, new TribeeHomeStateMachine$1$2$1(this$0, null), 2, (Object) null);
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv = new TribeeHomeStateMachine$1$2$2(this$0, null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(TribeeHomeStateAction.ToJoinTribee.class), executionPolicy$iv, handler$iv);
        BaseBuilderBlock $this$iv2 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv2 = new TribeeHomeStateMachine$1$2$3(this$0, null);
        ExecutionPolicy executionPolicy$iv2 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv2.on(Reflection.getOrCreateKotlinClass(TribeeHomeStateAction.ToJoinTribeeByInviteCode.class), executionPolicy$iv2, handler$iv2);
        BaseBuilderBlock $this$iv3 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv3 = new TribeeHomeStateMachine$1$2$4(this$0, null);
        ExecutionPolicy executionPolicy$iv3 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv3.on(Reflection.getOrCreateKotlinClass(TribeeHomeStateAction.ToJoinCandidatePool.class), executionPolicy$iv3, handler$iv3);
        BaseBuilderBlock $this$iv4 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv4 = new TribeeHomeStateMachine$1$2$5(this$0, null);
        ExecutionPolicy executionPolicy$iv4 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv4.on(Reflection.getOrCreateKotlinClass(TribeeHomeStateAction.ToExitTribee.class), executionPolicy$iv4, handler$iv4);
        BaseBuilderBlock $this$iv5 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv5 = new TribeeHomeStateMachine$1$2$6(this$0, null);
        ExecutionPolicy executionPolicy$iv5 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv5.on(Reflection.getOrCreateKotlinClass(TribeeHomeStateAction.AwaitPublishResult.class), executionPolicy$iv5, handler$iv5);
        BaseBuilderBlock $this$iv6 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv6 = new TribeeHomeStateMachine$1$2$7(this$0, null);
        ExecutionPolicy executionPolicy$iv6 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv6.on(Reflection.getOrCreateKotlinClass(TribeeHomeStateAction.InsertFakeDyn.class), executionPolicy$iv6, handler$iv6);
        BaseBuilderBlock $this$iv7 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv7 = new TribeeHomeStateMachine$1$2$8(this$0, null);
        ExecutionPolicy executionPolicy$iv7 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv7.on(Reflection.getOrCreateKotlinClass(TribeeHomeStateAction.AwaitSteamBindResult.class), executionPolicy$iv7, handler$iv7);
        BaseBuilderBlock $this$iv8 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv8 = new TribeeHomeStateMachine$1$2$9(this$0, null);
        ExecutionPolicy executionPolicy$iv8 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv8.on(Reflection.getOrCreateKotlinClass(TribeeHomeStateAction.ReportNotification.class), executionPolicy$iv8, handler$iv8);
        BaseBuilderBlock $this$iv9 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv9 = new TribeeHomeStateMachine$1$2$10(this$0, null);
        ExecutionPolicy executionPolicy$iv9 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv9.on(Reflection.getOrCreateKotlinClass(TribeeHomeStateAction.SwitchSubarea.class), executionPolicy$iv9, handler$iv9);
        BaseBuilderBlock $this$iv10 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv10 = new TribeeHomeStateMachine$1$2$11(null);
        ExecutionPolicy executionPolicy$iv10 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv10.on(Reflection.getOrCreateKotlinClass(TribeeHomeStateAction.Refresh.class), executionPolicy$iv10, handler$iv10);
        BaseBuilderBlock $this$iv11 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv11 = new TribeeHomeStateMachine$1$2$12(null);
        ExecutionPolicy executionPolicy$iv11 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv11.on(Reflection.getOrCreateKotlinClass(TribeeHomeStateAction.FetchCategory.class), executionPolicy$iv11, handler$iv11);
        BaseBuilderBlock $this$iv12 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv12 = new TribeeHomeStateMachine$1$2$13(null);
        ExecutionPolicy executionPolicy$iv12 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv12.on(Reflection.getOrCreateKotlinClass(TribeeHomeStateAction.LoadMore.class), executionPolicy$iv12, handler$iv12);
        $this$inState.untilIdentityChanges(new Function1() { // from class: kntr.app.tribee.consume.viewmodel.TribeeHomeStateMachine$$ExternalSyntheticLambda5
            public final Object invoke(Object obj) {
                return TribeeHomeStateMachine.lambda$0$1$0((TribeeHomeContentState) obj);
            }
        }, new Function1() { // from class: kntr.app.tribee.consume.viewmodel.TribeeHomeStateMachine$$ExternalSyntheticLambda6
            public final Object invoke(Object obj) {
                return TribeeHomeStateMachine.lambda$0$1$1(TribeeHomeStateMachine.this, (IdentityBuilderBlock) obj);
            }
        });
        BaseBuilderBlock $this$iv13 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv13 = new TribeeHomeStateMachine$1$2$16(this$0, null);
        ExecutionPolicy executionPolicy$iv13 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv13.on(Reflection.getOrCreateKotlinClass(TribeeHomeStateAction.SwitchRevisitSettings.class), executionPolicy$iv13, handler$iv13);
        BaseBuilderBlock $this$iv14 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv14 = new TribeeHomeStateMachine$1$2$17(null);
        ExecutionPolicy executionPolicy$iv14 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv14.on(Reflection.getOrCreateKotlinClass(TribeeHomeStateAction.SwitchSortType.class), executionPolicy$iv14, handler$iv14);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Object lambda$0$1$0(TribeeHomeContentState it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Integer.valueOf(it.getFetchModel().getFetchIdentity());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$0$1$1(TribeeHomeStateMachine this$0, IdentityBuilderBlock $this$untilIdentityChanges) {
        Intrinsics.checkNotNullParameter($this$untilIdentityChanges, "$this$untilIdentityChanges");
        $this$untilIdentityChanges.onEnter(new TribeeHomeStateMachine$1$2$15$1(this$0, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$0$2(InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv = new TribeeHomeStateMachine$1$3$1(null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(TribeeHomeStateAction.Initial.class), executionPolicy$iv, handler$iv);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00e1 A[Catch: Exception -> 0x0048, TryCatch #2 {Exception -> 0x0048, blocks: (B:13:0x0042, B:47:0x00d7, B:49:0x00e1, B:52:0x00e9, B:54:0x00ef, B:56:0x00f5, B:58:0x00fd, B:60:0x010a, B:62:0x0118, B:68:0x0125, B:93:0x01cc, B:69:0x013b, B:70:0x0144, B:72:0x014a, B:74:0x0160, B:91:0x01c2, B:75:0x016f, B:76:0x0183, B:78:0x0189, B:85:0x01ab, B:87:0x01b0, B:90:0x01ba, B:59:0x0102, B:94:0x01e8, B:95:0x01ef), top: B:110:0x0042 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00e9 A[Catch: Exception -> 0x0048, TryCatch #2 {Exception -> 0x0048, blocks: (B:13:0x0042, B:47:0x00d7, B:49:0x00e1, B:52:0x00e9, B:54:0x00ef, B:56:0x00f5, B:58:0x00fd, B:60:0x010a, B:62:0x0118, B:68:0x0125, B:93:0x01cc, B:69:0x013b, B:70:0x0144, B:72:0x014a, B:74:0x0160, B:91:0x01c2, B:75:0x016f, B:76:0x0183, B:78:0x0189, B:85:0x01ab, B:87:0x01b0, B:90:0x01ba, B:59:0x0102, B:94:0x01e8, B:95:0x01ef), top: B:110:0x0042 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0125 A[Catch: Exception -> 0x0048, TryCatch #2 {Exception -> 0x0048, blocks: (B:13:0x0042, B:47:0x00d7, B:49:0x00e1, B:52:0x00e9, B:54:0x00ef, B:56:0x00f5, B:58:0x00fd, B:60:0x010a, B:62:0x0118, B:68:0x0125, B:93:0x01cc, B:69:0x013b, B:70:0x0144, B:72:0x014a, B:74:0x0160, B:91:0x01c2, B:75:0x016f, B:76:0x0183, B:78:0x0189, B:85:0x01ab, B:87:0x01b0, B:90:0x01ba, B:59:0x0102, B:94:0x01e8, B:95:0x01ef), top: B:110:0x0042 }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x013b A[Catch: Exception -> 0x0048, TryCatch #2 {Exception -> 0x0048, blocks: (B:13:0x0042, B:47:0x00d7, B:49:0x00e1, B:52:0x00e9, B:54:0x00ef, B:56:0x00f5, B:58:0x00fd, B:60:0x010a, B:62:0x0118, B:68:0x0125, B:93:0x01cc, B:69:0x013b, B:70:0x0144, B:72:0x014a, B:74:0x0160, B:91:0x01c2, B:75:0x016f, B:76:0x0183, B:78:0x0189, B:85:0x01ab, B:87:0x01b0, B:90:0x01ba, B:59:0x0102, B:94:0x01e8, B:95:0x01ef), top: B:110:0x0042 }] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01e8 A[Catch: Exception -> 0x0048, TryCatch #2 {Exception -> 0x0048, blocks: (B:13:0x0042, B:47:0x00d7, B:49:0x00e1, B:52:0x00e9, B:54:0x00ef, B:56:0x00f5, B:58:0x00fd, B:60:0x010a, B:62:0x0118, B:68:0x0125, B:93:0x01cc, B:69:0x013b, B:70:0x0144, B:72:0x014a, B:74:0x0160, B:91:0x01c2, B:75:0x016f, B:76:0x0183, B:78:0x0189, B:85:0x01ab, B:87:0x01b0, B:90:0x01ba, B:59:0x0102, B:94:0x01e8, B:95:0x01ef), top: B:110:0x0042 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object handleRefresh(TribeeHomeStateAction action, State<TribeeHomeContentState> state, Continuation<? super ChangedState<? extends TribeeHomeState>> continuation) {
        TribeeHomeStateMachine$handleRefresh$1 tribeeHomeStateMachine$handleRefresh$1;
        TribeeHomeStateMachine$handleRefresh$1 tribeeHomeStateMachine$handleRefresh$12;
        TribeeHomeStateAction tribeeHomeStateAction;
        State state2;
        final TribeeHomeStateAction action2;
        State state3;
        Object obj;
        Map.Entry currentEntry;
        TribeeHomeDataService tribeeHomeDataService;
        long categoryId;
        KTribeeSortType curSortType;
        Object obj2;
        TribeeDynListState tribeeDynListState;
        KTribeeSortInfo tribeeSortInfo;
        Map.Entry it;
        KTribeeBaseInfo baseInfo;
        boolean z;
        Object obj3;
        TribeeDynListState tribeeDynListState2;
        boolean z2;
        if (continuation instanceof TribeeHomeStateMachine$handleRefresh$1) {
            tribeeHomeStateMachine$handleRefresh$1 = (TribeeHomeStateMachine$handleRefresh$1) continuation;
            if ((tribeeHomeStateMachine$handleRefresh$1.label & Integer.MIN_VALUE) != 0) {
                tribeeHomeStateMachine$handleRefresh$1.label -= Integer.MIN_VALUE;
                tribeeHomeStateMachine$handleRefresh$12 = tribeeHomeStateMachine$handleRefresh$1;
                Object $result = tribeeHomeStateMachine$handleRefresh$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (tribeeHomeStateMachine$handleRefresh$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        try {
                            Iterator<T> it2 = ((TribeeHomeContentState) state.getSnapshot()).getCategoryList().entrySet().iterator();
                            while (true) {
                                if (it2.hasNext()) {
                                    try {
                                        obj = it2.next();
                                        Map.Entry it3 = (Map.Entry) obj;
                                        if (((KTribeeCategory) it3.getKey()).getId() == ((TribeeHomeContentState) state.getSnapshot()).getCategoryId()) {
                                            it = 1;
                                            continue;
                                        } else {
                                            it = null;
                                            continue;
                                        }
                                        if (it != null) {
                                        }
                                    } catch (Exception e) {
                                        e = e;
                                        action2 = action;
                                        state3 = state;
                                        KLog_androidKt.getKLog().e("TribeeHomeStateMachine", "refresh has error. from action : " + action2, e);
                                        return state3.mutate(new Function1() { // from class: kntr.app.tribee.consume.viewmodel.TribeeHomeStateMachine$$ExternalSyntheticLambda8
                                            public final Object invoke(Object obj4) {
                                                TribeeHomeContentState handleRefresh$lambda$3;
                                                handleRefresh$lambda$3 = TribeeHomeStateMachine.handleRefresh$lambda$3(e, action2, (TribeeHomeContentState) obj4);
                                                return handleRefresh$lambda$3;
                                            }
                                        });
                                    }
                                } else {
                                    obj = null;
                                }
                            }
                            currentEntry = (Map.Entry) obj;
                            tribeeHomeDataService = this.dataService;
                            categoryId = ((TribeeHomeContentState) state.getSnapshot()).getCategoryId();
                            curSortType = (currentEntry == null || (tribeeDynListState = (TribeeDynListState) currentEntry.getValue()) == null || (tribeeSortInfo = tribeeDynListState.getTribeeSortInfo()) == null) ? null : tribeeSortInfo.getCurSortType();
                            tribeeHomeStateAction = action;
                        } catch (Exception e2) {
                            e = e2;
                            tribeeHomeStateAction = action;
                        }
                        try {
                            tribeeHomeStateMachine$handleRefresh$12.L$0 = tribeeHomeStateAction;
                            state2 = state;
                            try {
                                tribeeHomeStateMachine$handleRefresh$12.L$1 = state2;
                                tribeeHomeStateMachine$handleRefresh$12.L$2 = SpillingKt.nullOutSpilledVariable(currentEntry);
                                tribeeHomeStateMachine$handleRefresh$12.label = 1;
                                Object initialData = tribeeHomeDataService.initialData(categoryId, curSortType, tribeeHomeStateMachine$handleRefresh$12);
                                if (initialData == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                obj2 = initialData;
                                action2 = tribeeHomeStateAction;
                                state3 = state2;
                                final KTribeeDynAllResp data = (KTribeeDynAllResp) obj2;
                                baseInfo = data.getBaseInfo();
                                if ((baseInfo == null ? baseInfo.getTribeeInfo() : null) == null) {
                                    KTribeeCategoryInfo category = data.getCategory();
                                    Iterable rspCategoryList = category != null ? category.getCategoryList() : null;
                                    KTribeeCategoryInfo category2 = data.getCategory();
                                    final long currentCategoryId = category2 != null ? category2.getCurrentCategoryId() : TribeeExtensionsKt.getDEFAULT_CATEGORY().getId();
                                    Map $this$handleRefresh_u24lambda_u241 = MapsKt.createMapBuilder();
                                    List list = (Collection) rspCategoryList;
                                    if (list != null && !list.isEmpty()) {
                                        z = false;
                                        if (z) {
                                            Iterable $this$forEach$iv = rspCategoryList;
                                            for (Object element$iv : $this$forEach$iv) {
                                                KTribeeCategory it4 = (KTribeeCategory) element$iv;
                                                if (it4.getId() == currentCategoryId) {
                                                    tribeeDynListState2 = new TribeeDynListState(data.getContent(), data.getSortInfo());
                                                } else {
                                                    Iterator<T> it5 = ((TribeeHomeContentState) state3.getSnapshot()).getCategoryList().entrySet().iterator();
                                                    while (true) {
                                                        if (it5.hasNext()) {
                                                            obj3 = it5.next();
                                                            KTribeeCategory key = (KTribeeCategory) ((Map.Entry) obj3).getKey();
                                                            if (key.getId() == it4.getId()) {
                                                                z2 = true;
                                                                continue;
                                                            } else {
                                                                z2 = false;
                                                                continue;
                                                            }
                                                            if (z2) {
                                                            }
                                                        } else {
                                                            obj3 = null;
                                                        }
                                                    }
                                                    Map.Entry entry = (Map.Entry) obj3;
                                                    if (entry == null || (tribeeDynListState2 = (TribeeDynListState) entry.getValue()) == null) {
                                                        tribeeDynListState2 = new TribeeDynListState(null, null);
                                                    }
                                                }
                                                $this$handleRefresh_u24lambda_u241.put(it4, tribeeDynListState2);
                                            }
                                        } else {
                                            $this$handleRefresh_u24lambda_u241.put(TribeeExtensionsKt.getDEFAULT_CATEGORY(), new TribeeDynListState(data.getContent(), data.getSortInfo()));
                                        }
                                        final Map categoryList = MapsKt.build($this$handleRefresh_u24lambda_u241);
                                        JobKt.ensureActive(tribeeHomeStateMachine$handleRefresh$12.getContext());
                                        final TribeeHomeStateAction tribeeHomeStateAction2 = action2;
                                        return state3.mutate(new Function1() { // from class: kntr.app.tribee.consume.viewmodel.TribeeHomeStateMachine$$ExternalSyntheticLambda7
                                            public final Object invoke(Object obj4) {
                                                TribeeHomeContentState handleRefresh$lambda$2;
                                                handleRefresh$lambda$2 = TribeeHomeStateMachine.handleRefresh$lambda$2(data, categoryList, currentCategoryId, tribeeHomeStateAction2, (TribeeHomeContentState) obj4);
                                                return handleRefresh$lambda$2;
                                            }
                                        });
                                    }
                                    z = true;
                                    if (z) {
                                    }
                                    final Map categoryList2 = MapsKt.build($this$handleRefresh_u24lambda_u241);
                                    JobKt.ensureActive(tribeeHomeStateMachine$handleRefresh$12.getContext());
                                    final TribeeHomeStateAction tribeeHomeStateAction22 = action2;
                                    return state3.mutate(new Function1() { // from class: kntr.app.tribee.consume.viewmodel.TribeeHomeStateMachine$$ExternalSyntheticLambda7
                                        public final Object invoke(Object obj4) {
                                            TribeeHomeContentState handleRefresh$lambda$2;
                                            handleRefresh$lambda$2 = TribeeHomeStateMachine.handleRefresh$lambda$2(data, categoryList2, currentCategoryId, tribeeHomeStateAction22, (TribeeHomeContentState) obj4);
                                            return handleRefresh$lambda$2;
                                        }
                                    });
                                }
                                throw new Exception("data error!");
                            } catch (Exception e3) {
                                e = e3;
                                action2 = tribeeHomeStateAction;
                                state3 = state2;
                                KLog_androidKt.getKLog().e("TribeeHomeStateMachine", "refresh has error. from action : " + action2, e);
                                return state3.mutate(new Function1() { // from class: kntr.app.tribee.consume.viewmodel.TribeeHomeStateMachine$$ExternalSyntheticLambda8
                                    public final Object invoke(Object obj4) {
                                        TribeeHomeContentState handleRefresh$lambda$3;
                                        handleRefresh$lambda$3 = TribeeHomeStateMachine.handleRefresh$lambda$3(e, action2, (TribeeHomeContentState) obj4);
                                        return handleRefresh$lambda$3;
                                    }
                                });
                            }
                        } catch (Exception e4) {
                            e = e4;
                            state2 = state;
                            action2 = tribeeHomeStateAction;
                            state3 = state2;
                            KLog_androidKt.getKLog().e("TribeeHomeStateMachine", "refresh has error. from action : " + action2, e);
                            return state3.mutate(new Function1() { // from class: kntr.app.tribee.consume.viewmodel.TribeeHomeStateMachine$$ExternalSyntheticLambda8
                                public final Object invoke(Object obj4) {
                                    TribeeHomeContentState handleRefresh$lambda$3;
                                    handleRefresh$lambda$3 = TribeeHomeStateMachine.handleRefresh$lambda$3(e, action2, (TribeeHomeContentState) obj4);
                                    return handleRefresh$lambda$3;
                                }
                            });
                        }
                    case 1:
                        Map.Entry entry2 = (Map.Entry) tribeeHomeStateMachine$handleRefresh$12.L$2;
                        state3 = (State) tribeeHomeStateMachine$handleRefresh$12.L$1;
                        action2 = (TribeeHomeStateAction) tribeeHomeStateMachine$handleRefresh$12.L$0;
                        try {
                            ResultKt.throwOnFailure($result);
                            obj2 = $result;
                            final KTribeeDynAllResp data2 = (KTribeeDynAllResp) obj2;
                            baseInfo = data2.getBaseInfo();
                            if ((baseInfo == null ? baseInfo.getTribeeInfo() : null) == null) {
                            }
                        } catch (Exception e5) {
                            e = e5;
                            KLog_androidKt.getKLog().e("TribeeHomeStateMachine", "refresh has error. from action : " + action2, e);
                            return state3.mutate(new Function1() { // from class: kntr.app.tribee.consume.viewmodel.TribeeHomeStateMachine$$ExternalSyntheticLambda8
                                public final Object invoke(Object obj4) {
                                    TribeeHomeContentState handleRefresh$lambda$3;
                                    handleRefresh$lambda$3 = TribeeHomeStateMachine.handleRefresh$lambda$3(e, action2, (TribeeHomeContentState) obj4);
                                    return handleRefresh$lambda$3;
                                }
                            });
                        }
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        tribeeHomeStateMachine$handleRefresh$1 = new TribeeHomeStateMachine$handleRefresh$1(this, continuation);
        tribeeHomeStateMachine$handleRefresh$12 = tribeeHomeStateMachine$handleRefresh$1;
        Object $result2 = tribeeHomeStateMachine$handleRefresh$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (tribeeHomeStateMachine$handleRefresh$12.label) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TribeeHomeContentState handleRefresh$lambda$2(KTribeeDynAllResp $data, Map $categoryList, long $currentCategoryId, TribeeHomeStateAction $action, TribeeHomeContentState $this$mutate) {
        TribeeHomeContentState copy;
        Intrinsics.checkNotNullParameter($this$mutate, "$this$mutate");
        copy = $this$mutate.copy((r20 & 1) != 0 ? $this$mutate.baseInfo : $data.getBaseInfo(), (r20 & 2) != 0 ? $this$mutate.interaction : $data.getInteraction(), (r20 & 4) != 0 ? $this$mutate.navigation : $data.getNavigation(), (r20 & 8) != 0 ? $this$mutate.categoryList : $categoryList, (r20 & 16) != 0 ? $this$mutate.categoryId : $currentCategoryId, (r20 & 32) != 0 ? $this$mutate.fetchModel : null, (r20 & 64) != 0 ? $this$mutate.observedRequestingActions : $this$mutate.removeIfObservedAction($action), (r20 & 128) != 0 ? $this$mutate.uiAction : null);
        return copy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TribeeHomeContentState handleRefresh$lambda$3(Exception $e, TribeeHomeStateAction $action, TribeeHomeContentState $this$mutate) {
        TribeeHomeContentState copy;
        Intrinsics.checkNotNullParameter($this$mutate, "$this$mutate");
        copy = $this$mutate.copy((r20 & 1) != 0 ? $this$mutate.baseInfo : null, (r20 & 2) != 0 ? $this$mutate.interaction : null, (r20 & 4) != 0 ? $this$mutate.navigation : null, (r20 & 8) != 0 ? $this$mutate.categoryList : null, (r20 & 16) != 0 ? $this$mutate.categoryId : 0L, (r20 & 32) != 0 ? $this$mutate.fetchModel : null, (r20 & 64) != 0 ? $this$mutate.observedRequestingActions : $this$mutate.removeIfObservedAction($action), (r20 & 128) != 0 ? $this$mutate.uiAction : new TribeeHomeUIAction.ToastTips(TribeeToast.Companion.create$default(TribeeToast.Companion, $e, null, 2, null)));
        return copy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x015c, code lost:
        if (r9 == null) goto L32;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x011c A[Catch: Exception -> 0x004f, TryCatch #1 {Exception -> 0x004f, blocks: (B:13:0x0048, B:48:0x00f9, B:50:0x011c, B:51:0x0126, B:53:0x012c, B:56:0x0134, B:60:0x0142, B:63:0x0168, B:62:0x015e), top: B:72:0x0048 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0126 A[Catch: Exception -> 0x004f, TryCatch #1 {Exception -> 0x004f, blocks: (B:13:0x0048, B:48:0x00f9, B:50:0x011c, B:51:0x0126, B:53:0x012c, B:56:0x0134, B:60:0x0142, B:63:0x0168, B:62:0x015e), top: B:72:0x0048 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object handleLoadMore(TribeeHomeStateAction.LoadMore action, State<TribeeHomeContentState> state, Continuation<? super ChangedState<? extends TribeeHomeState>> continuation) {
        TribeeHomeStateMachine$handleLoadMore$1 tribeeHomeStateMachine$handleLoadMore$1;
        TribeeHomeStateMachine$handleLoadMore$1 tribeeHomeStateMachine$handleLoadMore$12;
        Object obj;
        final Map.Entry currentEntry;
        TribeeDynListState tribeeDynListState;
        KPaginationReply it;
        Object loadNextList;
        boolean z;
        List $this$handleLoadMore_u24lambda_u245_u240;
        final TribeeHomeStateAction.LoadMore action2 = action;
        State state2 = state;
        if (continuation instanceof TribeeHomeStateMachine$handleLoadMore$1) {
            tribeeHomeStateMachine$handleLoadMore$1 = (TribeeHomeStateMachine$handleLoadMore$1) continuation;
            if ((tribeeHomeStateMachine$handleLoadMore$1.label & Integer.MIN_VALUE) != 0) {
                tribeeHomeStateMachine$handleLoadMore$1.label -= Integer.MIN_VALUE;
                tribeeHomeStateMachine$handleLoadMore$12 = tribeeHomeStateMachine$handleLoadMore$1;
                Object $result = tribeeHomeStateMachine$handleLoadMore$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (tribeeHomeStateMachine$handleLoadMore$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        try {
                            Iterator<T> it2 = ((TribeeHomeContentState) state.getSnapshot()).getCategoryList().entrySet().iterator();
                            while (true) {
                                if (it2.hasNext()) {
                                    obj = it2.next();
                                    if (((KTribeeCategory) ((Map.Entry) obj).getKey()).getId() == ((TribeeHomeContentState) state.getSnapshot()).getCategoryId()) {
                                        z = true;
                                        continue;
                                    } else {
                                        z = false;
                                        continue;
                                    }
                                    if (z) {
                                    }
                                } else {
                                    obj = null;
                                }
                            }
                            currentEntry = (Map.Entry) obj;
                            if (currentEntry != null && (tribeeDynListState = (TribeeDynListState) currentEntry.getValue()) != null && (it = tribeeDynListState.nextPage()) != null) {
                                KPaginationReply nextPage = !StringsKt.isBlank(it.getNext()) ? it : null;
                                if (nextPage != null) {
                                    TribeeHomeDataService tribeeHomeDataService = this.dataService;
                                    long categoryId = ((TribeeHomeContentState) state.getSnapshot()).getCategoryId();
                                    KTribeeSortInfo tribeeSortInfo = ((TribeeDynListState) currentEntry.getValue()).getTribeeSortInfo();
                                    KTribeeSortType curSortType = tribeeSortInfo != null ? tribeeSortInfo.getCurSortType() : null;
                                    tribeeHomeStateMachine$handleLoadMore$12.L$0 = action2;
                                    tribeeHomeStateMachine$handleLoadMore$12.L$1 = state2;
                                    tribeeHomeStateMachine$handleLoadMore$12.L$2 = currentEntry;
                                    tribeeHomeStateMachine$handleLoadMore$12.L$3 = SpillingKt.nullOutSpilledVariable(nextPage);
                                    tribeeHomeStateMachine$handleLoadMore$12.label = 1;
                                    loadNextList = tribeeHomeDataService.loadNextList(nextPage, categoryId, curSortType, tribeeHomeStateMachine$handleLoadMore$12);
                                    if (loadNextList == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    final KTribeeDynAllResp next = (KTribeeDynAllResp) loadNextList;
                                    JobKt.ensureActive(tribeeHomeStateMachine$handleLoadMore$12.getContext());
                                    if (((KTribeeCategory) currentEntry.getKey()).getId() == ((TribeeHomeContentState) state2.getSnapshot()).getCategoryId()) {
                                        return state2.mutate(new Function1() { // from class: kntr.app.tribee.consume.viewmodel.TribeeHomeStateMachine$$ExternalSyntheticLambda11
                                            public final Object invoke(Object obj2) {
                                                TribeeHomeContentState handleLoadMore$lambda$3;
                                                handleLoadMore$lambda$3 = TribeeHomeStateMachine.handleLoadMore$lambda$3(TribeeHomeStateAction.LoadMore.this, (TribeeHomeContentState) obj2);
                                                return handleLoadMore$lambda$3;
                                            }
                                        });
                                    }
                                    KTribeeContent content = next.getContent();
                                    List nextDynList = content != null ? content.getDynList() : null;
                                    if (nextDynList != null) {
                                        List it3 = nextDynList.isEmpty() ? null : nextDynList;
                                        if (it3 != null) {
                                            $this$handleLoadMore_u24lambda_u245_u240 = CollectionsKt.toMutableList(((TribeeDynListState) currentEntry.getValue()).items());
                                            $this$handleLoadMore_u24lambda_u245_u240.addAll(it3);
                                            break;
                                        }
                                    }
                                    $this$handleLoadMore_u24lambda_u245_u240 = ((TribeeDynListState) currentEntry.getValue()).items();
                                    final List finalDynList = $this$handleLoadMore_u24lambda_u245_u240;
                                    return state2.mutate(new Function1() { // from class: kntr.app.tribee.consume.viewmodel.TribeeHomeStateMachine$$ExternalSyntheticLambda1
                                        public final Object invoke(Object obj2) {
                                            TribeeHomeContentState handleLoadMore$lambda$6;
                                            handleLoadMore$lambda$6 = TribeeHomeStateMachine.handleLoadMore$lambda$6(TribeeHomeStateAction.LoadMore.this, currentEntry, finalDynList, next, (TribeeHomeContentState) obj2);
                                            return handleLoadMore$lambda$6;
                                        }
                                    });
                                }
                            }
                            return state2.mutate(new Function1() { // from class: kntr.app.tribee.consume.viewmodel.TribeeHomeStateMachine$$ExternalSyntheticLambda10
                                public final Object invoke(Object obj2) {
                                    TribeeHomeContentState handleLoadMore$lambda$2;
                                    handleLoadMore$lambda$2 = TribeeHomeStateMachine.handleLoadMore$lambda$2(TribeeHomeStateAction.LoadMore.this, (TribeeHomeContentState) obj2);
                                    return handleLoadMore$lambda$2;
                                }
                            });
                        } catch (Exception e) {
                            e = e;
                            KLog_androidKt.getKLog().e("TribeeHomeStateMachine", "load more has error. from action : " + action2, e);
                            return state2.mutate(new Function1() { // from class: kntr.app.tribee.consume.viewmodel.TribeeHomeStateMachine$$ExternalSyntheticLambda2
                                public final Object invoke(Object obj2) {
                                    TribeeHomeContentState handleLoadMore$lambda$7;
                                    handleLoadMore$lambda$7 = TribeeHomeStateMachine.handleLoadMore$lambda$7(e, action2, (TribeeHomeContentState) obj2);
                                    return handleLoadMore$lambda$7;
                                }
                            });
                        }
                    case 1:
                        KPaginationReply kPaginationReply = (KPaginationReply) tribeeHomeStateMachine$handleLoadMore$12.L$3;
                        Map.Entry currentEntry2 = (Map.Entry) tribeeHomeStateMachine$handleLoadMore$12.L$2;
                        state2 = (State) tribeeHomeStateMachine$handleLoadMore$12.L$1;
                        action2 = (TribeeHomeStateAction.LoadMore) tribeeHomeStateMachine$handleLoadMore$12.L$0;
                        try {
                            ResultKt.throwOnFailure($result);
                            currentEntry = currentEntry2;
                            loadNextList = $result;
                            final KTribeeDynAllResp next2 = (KTribeeDynAllResp) loadNextList;
                            JobKt.ensureActive(tribeeHomeStateMachine$handleLoadMore$12.getContext());
                            if (((KTribeeCategory) currentEntry.getKey()).getId() == ((TribeeHomeContentState) state2.getSnapshot()).getCategoryId()) {
                            }
                        } catch (Exception e2) {
                            e = e2;
                            KLog_androidKt.getKLog().e("TribeeHomeStateMachine", "load more has error. from action : " + action2, e);
                            return state2.mutate(new Function1() { // from class: kntr.app.tribee.consume.viewmodel.TribeeHomeStateMachine$$ExternalSyntheticLambda2
                                public final Object invoke(Object obj2) {
                                    TribeeHomeContentState handleLoadMore$lambda$7;
                                    handleLoadMore$lambda$7 = TribeeHomeStateMachine.handleLoadMore$lambda$7(e, action2, (TribeeHomeContentState) obj2);
                                    return handleLoadMore$lambda$7;
                                }
                            });
                        }
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        tribeeHomeStateMachine$handleLoadMore$1 = new TribeeHomeStateMachine$handleLoadMore$1(this, continuation);
        tribeeHomeStateMachine$handleLoadMore$12 = tribeeHomeStateMachine$handleLoadMore$1;
        Object $result2 = tribeeHomeStateMachine$handleLoadMore$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (tribeeHomeStateMachine$handleLoadMore$12.label) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TribeeHomeContentState handleLoadMore$lambda$2(TribeeHomeStateAction.LoadMore $action, TribeeHomeContentState $this$mutate) {
        TribeeHomeContentState copy;
        Intrinsics.checkNotNullParameter($this$mutate, "$this$mutate");
        copy = $this$mutate.copy((r20 & 1) != 0 ? $this$mutate.baseInfo : null, (r20 & 2) != 0 ? $this$mutate.interaction : null, (r20 & 4) != 0 ? $this$mutate.navigation : null, (r20 & 8) != 0 ? $this$mutate.categoryList : null, (r20 & 16) != 0 ? $this$mutate.categoryId : 0L, (r20 & 32) != 0 ? $this$mutate.fetchModel : null, (r20 & 64) != 0 ? $this$mutate.observedRequestingActions : $this$mutate.removeIfObservedAction($action), (r20 & 128) != 0 ? $this$mutate.uiAction : null);
        return copy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TribeeHomeContentState handleLoadMore$lambda$3(TribeeHomeStateAction.LoadMore $action, TribeeHomeContentState $this$mutate) {
        TribeeHomeContentState copy;
        Intrinsics.checkNotNullParameter($this$mutate, "$this$mutate");
        copy = $this$mutate.copy((r20 & 1) != 0 ? $this$mutate.baseInfo : null, (r20 & 2) != 0 ? $this$mutate.interaction : null, (r20 & 4) != 0 ? $this$mutate.navigation : null, (r20 & 8) != 0 ? $this$mutate.categoryList : null, (r20 & 16) != 0 ? $this$mutate.categoryId : 0L, (r20 & 32) != 0 ? $this$mutate.fetchModel : null, (r20 & 64) != 0 ? $this$mutate.observedRequestingActions : $this$mutate.removeIfObservedAction($action), (r20 & 128) != 0 ? $this$mutate.uiAction : null);
        return copy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TribeeHomeContentState handleLoadMore$lambda$6(TribeeHomeStateAction.LoadMore $action, Map.Entry $currentEntry, List $finalDynList, KTribeeDynAllResp $next, TribeeHomeContentState $this$mutate) {
        KTribeeContent kTribeeContent;
        TribeeHomeContentState copy;
        Intrinsics.checkNotNullParameter($this$mutate, "$this$mutate");
        Set<TribeeHomeStateAction> removeIfObservedAction = $this$mutate.removeIfObservedAction($action);
        Map $this$handleLoadMore_u24lambda_u246_u240 = MapsKt.toMutableMap($this$mutate.getCategoryList());
        Object key = $currentEntry.getKey();
        TribeeDynListState tribeeDynListState = (TribeeDynListState) $currentEntry.getValue();
        KTribeeContent content = ((TribeeDynListState) $currentEntry.getValue()).getContent();
        if (content != null) {
            KTribeeContent content2 = $next.getContent();
            kTribeeContent = content.copy($finalDynList, content2 != null ? content2.getNextPage() : null);
        } else {
            kTribeeContent = null;
        }
        $this$handleLoadMore_u24lambda_u246_u240.put(key, TribeeDynListState.copy$default(tribeeDynListState, null, kTribeeContent, null, 5, null));
        copy = $this$mutate.copy((r20 & 1) != 0 ? $this$mutate.baseInfo : null, (r20 & 2) != 0 ? $this$mutate.interaction : null, (r20 & 4) != 0 ? $this$mutate.navigation : null, (r20 & 8) != 0 ? $this$mutate.categoryList : $this$handleLoadMore_u24lambda_u246_u240, (r20 & 16) != 0 ? $this$mutate.categoryId : 0L, (r20 & 32) != 0 ? $this$mutate.fetchModel : null, (r20 & 64) != 0 ? $this$mutate.observedRequestingActions : removeIfObservedAction, (r20 & 128) != 0 ? $this$mutate.uiAction : null);
        return copy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TribeeHomeContentState handleLoadMore$lambda$7(Exception $e, TribeeHomeStateAction.LoadMore $action, TribeeHomeContentState $this$mutate) {
        TribeeHomeContentState copy;
        Intrinsics.checkNotNullParameter($this$mutate, "$this$mutate");
        copy = $this$mutate.copy((r20 & 1) != 0 ? $this$mutate.baseInfo : null, (r20 & 2) != 0 ? $this$mutate.interaction : null, (r20 & 4) != 0 ? $this$mutate.navigation : null, (r20 & 8) != 0 ? $this$mutate.categoryList : null, (r20 & 16) != 0 ? $this$mutate.categoryId : 0L, (r20 & 32) != 0 ? $this$mutate.fetchModel : null, (r20 & 64) != 0 ? $this$mutate.observedRequestingActions : $this$mutate.removeIfObservedAction($action), (r20 & 128) != 0 ? $this$mutate.uiAction : new TribeeHomeUIAction.ToastTips(TribeeToast.Companion.create$default(TribeeToast.Companion, $e, null, 2, null)));
        return copy;
    }
}