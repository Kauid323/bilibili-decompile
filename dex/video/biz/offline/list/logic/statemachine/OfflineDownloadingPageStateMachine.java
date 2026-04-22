package video.biz.offline.list.logic.statemachine;

import com.freeletics.flowredux.dsl.BaseBuilderBlock;
import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.ConditionBuilderBlock;
import com.freeletics.flowredux.dsl.ExecutionPolicy;
import com.freeletics.flowredux.dsl.InStateBuilderBlock;
import com.freeletics.flowredux.dsl.State;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kntr.base.router.Router;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.base.log.LogKt;
import video.biz.offline.base.facade.IOfflineFacade;
import video.biz.offline.base.facade.OfflineFacadeImpl_androidKt;
import video.biz.offline.base.infra.utils.Config;
import video.biz.offline.list.logic.model.DataState;
import video.biz.offline.list.logic.model.OfflineCacheCardModelKt;
import video.biz.offline.list.logic.model.OfflineDownloadingCardModel;
import video.biz.offline.list.logic.model.OfflinePageConfig;
import video.biz.offline.list.logic.model.OfflinePageOperation;
import video.biz.offline.list.logic.model.OfflinePageState;
import video.biz.offline.list.logic.model.OfflinePageStateKt;
import video.biz.offline.list.logic.model.SelectionState;
import video.biz.offline.list.logic.statemachine.OfflineListAction;
import video.biz.offline.list.logic.utils.UtilsKt;

/* compiled from: OfflineDownloadingPageStateMachine.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u001e\u0010\n\u001a\u00020\u000b*\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\r0\fH\u0014J\"\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u0011H\u0094@¢\u0006\u0002\u0010\u0012J*\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u00112\u0006\u0010\u0014\u001a\u00020\u0015H\u0094@¢\u0006\u0002\u0010\u0016J\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u0011H\u0014J\u0014\u0010\u0018\u001a\u00020\u0019*\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u001bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lvideo/biz/offline/list/logic/statemachine/OfflineDownloadingPageStateMachine;", "Lvideo/biz/offline/list/logic/statemachine/OfflineBaseListStateMachine;", "initialState", "Lvideo/biz/offline/list/logic/model/OfflinePageState;", "router", "Lkntr/base/router/Router;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "(Lvideo/biz/offline/list/logic/model/OfflinePageState;Lkntr/base/router/Router;Lkotlinx/coroutines/CoroutineScope;)V", "childSpec", "", "Lcom/freeletics/flowredux/dsl/InStateBuilderBlock;", "Lvideo/biz/offline/list/logic/statemachine/OfflineListAction;", "loadData", "Lcom/freeletics/flowredux/dsl/ChangedState;", "state", "Lcom/freeletics/flowredux/dsl/State;", "(Lcom/freeletics/flowredux/dsl/State;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleClick", "action", "Lvideo/biz/offline/list/logic/statemachine/OfflineListAction$ItemClick;", "(Lcom/freeletics/flowredux/dsl/State;Lvideo/biz/offline/list/logic/statemachine/OfflineListAction$ItemClick;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleSelectAll", "updateConfig", "Lvideo/biz/offline/list/logic/model/OfflinePageConfig;", "isEmpty", "", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class OfflineDownloadingPageStateMachine extends OfflineBaseListStateMachine {
    public static final int $stable = 8;
    private final Router router;
    private final CoroutineScope scope;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OfflineDownloadingPageStateMachine(OfflinePageState initialState, Router router, CoroutineScope scope) {
        super(initialState, scope, router);
        Intrinsics.checkNotNullParameter(initialState, "initialState");
        Intrinsics.checkNotNullParameter(router, "router");
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.router = router;
        this.scope = scope;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean childSpec$lambda$0(OfflinePageState it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getDataState() == DataState.READY;
    }

    @Override // video.biz.offline.list.logic.statemachine.OfflineBaseListStateMachine
    protected void childSpec(InStateBuilderBlock<OfflinePageState, OfflinePageState, OfflineListAction> inStateBuilderBlock) {
        Intrinsics.checkNotNullParameter(inStateBuilderBlock, "<this>");
        inStateBuilderBlock.condition(new Function1() { // from class: video.biz.offline.list.logic.statemachine.OfflineDownloadingPageStateMachine$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                boolean childSpec$lambda$0;
                childSpec$lambda$0 = OfflineDownloadingPageStateMachine.childSpec$lambda$0((OfflinePageState) obj);
                return Boolean.valueOf(childSpec$lambda$0);
            }
        }, new Function1() { // from class: video.biz.offline.list.logic.statemachine.OfflineDownloadingPageStateMachine$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                Unit childSpec$lambda$1;
                childSpec$lambda$1 = OfflineDownloadingPageStateMachine.childSpec$lambda$1(OfflineDownloadingPageStateMachine.this, (ConditionBuilderBlock) obj);
                return childSpec$lambda$1;
            }
        });
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) inStateBuilderBlock;
        Function3 handler$iv = new OfflineDownloadingPageStateMachine$childSpec$3(this, null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(StartAll.class), executionPolicy$iv, handler$iv);
        BaseBuilderBlock $this$iv2 = (BaseBuilderBlock) inStateBuilderBlock;
        Function3 handler$iv2 = new OfflineDownloadingPageStateMachine$childSpec$4(this, null);
        ExecutionPolicy executionPolicy$iv2 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv2.on(Reflection.getOrCreateKotlinClass(StopAll.class), executionPolicy$iv2, handler$iv2);
        BaseBuilderBlock $this$iv3 = (BaseBuilderBlock) inStateBuilderBlock;
        Function3 handler$iv3 = new OfflineDownloadingPageStateMachine$childSpec$5(null);
        ExecutionPolicy executionPolicy$iv3 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv3.on(Reflection.getOrCreateKotlinClass(ShowConcurrentSheet.class), executionPolicy$iv3, handler$iv3);
        BaseBuilderBlock $this$iv4 = (BaseBuilderBlock) inStateBuilderBlock;
        Function3 handler$iv4 = new OfflineDownloadingPageStateMachine$childSpec$6(null);
        ExecutionPolicy executionPolicy$iv4 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv4.on(Reflection.getOrCreateKotlinClass(SetConcurrentCount.class), executionPolicy$iv4, handler$iv4);
        BaseBuilderBlock $this$iv5 = (BaseBuilderBlock) inStateBuilderBlock;
        Function3 handler$iv5 = new OfflineDownloadingPageStateMachine$childSpec$7(null);
        ExecutionPolicy executionPolicy$iv5 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv5.on(Reflection.getOrCreateKotlinClass(OfflineListAction.Delete.class), executionPolicy$iv5, handler$iv5);
        BaseBuilderBlock $this$iv6 = (BaseBuilderBlock) inStateBuilderBlock;
        Function3 handler$iv6 = new OfflineDownloadingPageStateMachine$childSpec$8(this, null);
        ExecutionPolicy executionPolicy$iv6 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv6.on(Reflection.getOrCreateKotlinClass(OfflineListAction.DeleteConfirmed.class), executionPolicy$iv6, handler$iv6);
        BaseBuilderBlock $this$iv7 = (BaseBuilderBlock) inStateBuilderBlock;
        Function3 handler$iv7 = new OfflineDownloadingPageStateMachine$childSpec$9(this, null);
        ExecutionPolicy executionPolicy$iv7 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv7.on(Reflection.getOrCreateKotlinClass(ItemCoverClick.class), executionPolicy$iv7, handler$iv7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit childSpec$lambda$1(OfflineDownloadingPageStateMachine this$0, ConditionBuilderBlock $this$condition) {
        Intrinsics.checkNotNullParameter($this$condition, "$this$condition");
        BaseBuilderBlock.collectWhileInState$default((BaseBuilderBlock) $this$condition, new Function1() { // from class: video.biz.offline.list.logic.statemachine.OfflineDownloadingPageStateMachine$$ExternalSyntheticLambda5
            public final Object invoke(Object obj) {
                Flow childSpec$lambda$1$0;
                childSpec$lambda$1$0 = OfflineDownloadingPageStateMachine.childSpec$lambda$1$0((OfflinePageState) obj);
                return childSpec$lambda$1$0;
            }
        }, (ExecutionPolicy) null, new OfflineDownloadingPageStateMachine$childSpec$2$2(this$0, null), 2, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Flow childSpec$lambda$1$0(OfflinePageState it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return OfflineFacadeImpl_androidKt.getOfflineFacadeImpl().getAllVideosFlow();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x007c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0094 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0095  */
    @Override // video.biz.offline.list.logic.statemachine.OfflineBaseListStateMachine
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object loadData(State<OfflinePageState> state, Continuation<? super ChangedState<OfflinePageState>> continuation) {
        OfflineDownloadingPageStateMachine$loadData$1 offlineDownloadingPageStateMachine$loadData$1;
        Object allVideos;
        List videos;
        Object downloadingCards;
        OfflineListAction.GetStorageInfo getStorageInfo;
        final List downloading;
        try {
            if (continuation instanceof OfflineDownloadingPageStateMachine$loadData$1) {
                offlineDownloadingPageStateMachine$loadData$1 = (OfflineDownloadingPageStateMachine$loadData$1) continuation;
                if ((offlineDownloadingPageStateMachine$loadData$1.label & Integer.MIN_VALUE) != 0) {
                    offlineDownloadingPageStateMachine$loadData$1.label -= Integer.MIN_VALUE;
                    Object $result = offlineDownloadingPageStateMachine$loadData$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (offlineDownloadingPageStateMachine$loadData$1.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            IOfflineFacade offlineFacadeImpl = OfflineFacadeImpl_androidKt.getOfflineFacadeImpl();
                            offlineDownloadingPageStateMachine$loadData$1.L$0 = state;
                            offlineDownloadingPageStateMachine$loadData$1.label = 1;
                            allVideos = offlineFacadeImpl.getAllVideos(offlineDownloadingPageStateMachine$loadData$1);
                            if (allVideos == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            videos = (List) allVideos;
                            offlineDownloadingPageStateMachine$loadData$1.L$0 = state;
                            offlineDownloadingPageStateMachine$loadData$1.L$1 = SpillingKt.nullOutSpilledVariable(videos);
                            offlineDownloadingPageStateMachine$loadData$1.label = 2;
                            downloadingCards = OfflineCacheCardModelKt.downloadingCards(videos, offlineDownloadingPageStateMachine$loadData$1);
                            if (downloadingCards == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            List downloading2 = (List) downloadingCards;
                            getStorageInfo = OfflineListAction.GetStorageInfo.INSTANCE;
                            offlineDownloadingPageStateMachine$loadData$1.L$0 = state;
                            offlineDownloadingPageStateMachine$loadData$1.L$1 = SpillingKt.nullOutSpilledVariable(videos);
                            offlineDownloadingPageStateMachine$loadData$1.L$2 = downloading2;
                            offlineDownloadingPageStateMachine$loadData$1.label = 3;
                            if (dispatch(getStorageInfo, offlineDownloadingPageStateMachine$loadData$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            downloading = downloading2;
                            return state.mutate(new Function1() { // from class: video.biz.offline.list.logic.statemachine.OfflineDownloadingPageStateMachine$$ExternalSyntheticLambda0
                                public final Object invoke(Object obj) {
                                    OfflinePageState loadData$lambda$0;
                                    loadData$lambda$0 = OfflineDownloadingPageStateMachine.loadData$lambda$0(downloading, this, (OfflinePageState) obj);
                                    return loadData$lambda$0;
                                }
                            });
                        case 1:
                            state = (State) offlineDownloadingPageStateMachine$loadData$1.L$0;
                            ResultKt.throwOnFailure($result);
                            allVideos = $result;
                            videos = (List) allVideos;
                            offlineDownloadingPageStateMachine$loadData$1.L$0 = state;
                            offlineDownloadingPageStateMachine$loadData$1.L$1 = SpillingKt.nullOutSpilledVariable(videos);
                            offlineDownloadingPageStateMachine$loadData$1.label = 2;
                            downloadingCards = OfflineCacheCardModelKt.downloadingCards(videos, offlineDownloadingPageStateMachine$loadData$1);
                            if (downloadingCards == coroutine_suspended) {
                            }
                            List downloading22 = (List) downloadingCards;
                            getStorageInfo = OfflineListAction.GetStorageInfo.INSTANCE;
                            offlineDownloadingPageStateMachine$loadData$1.L$0 = state;
                            offlineDownloadingPageStateMachine$loadData$1.L$1 = SpillingKt.nullOutSpilledVariable(videos);
                            offlineDownloadingPageStateMachine$loadData$1.L$2 = downloading22;
                            offlineDownloadingPageStateMachine$loadData$1.label = 3;
                            if (dispatch(getStorageInfo, offlineDownloadingPageStateMachine$loadData$1) == coroutine_suspended) {
                            }
                            break;
                        case 2:
                            videos = (List) offlineDownloadingPageStateMachine$loadData$1.L$1;
                            state = (State) offlineDownloadingPageStateMachine$loadData$1.L$0;
                            ResultKt.throwOnFailure($result);
                            downloadingCards = $result;
                            List downloading222 = (List) downloadingCards;
                            getStorageInfo = OfflineListAction.GetStorageInfo.INSTANCE;
                            offlineDownloadingPageStateMachine$loadData$1.L$0 = state;
                            offlineDownloadingPageStateMachine$loadData$1.L$1 = SpillingKt.nullOutSpilledVariable(videos);
                            offlineDownloadingPageStateMachine$loadData$1.L$2 = downloading222;
                            offlineDownloadingPageStateMachine$loadData$1.label = 3;
                            if (dispatch(getStorageInfo, offlineDownloadingPageStateMachine$loadData$1) == coroutine_suspended) {
                            }
                            break;
                        case 3:
                            downloading = (List) offlineDownloadingPageStateMachine$loadData$1.L$2;
                            List list = (List) offlineDownloadingPageStateMachine$loadData$1.L$1;
                            state = (State) offlineDownloadingPageStateMachine$loadData$1.L$0;
                            ResultKt.throwOnFailure($result);
                            return state.mutate(new Function1() { // from class: video.biz.offline.list.logic.statemachine.OfflineDownloadingPageStateMachine$$ExternalSyntheticLambda0
                                public final Object invoke(Object obj) {
                                    OfflinePageState loadData$lambda$0;
                                    loadData$lambda$0 = OfflineDownloadingPageStateMachine.loadData$lambda$0(downloading, this, (OfflinePageState) obj);
                                    return loadData$lambda$0;
                                }
                            });
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }
            }
            switch (offlineDownloadingPageStateMachine$loadData$1.label) {
            }
        } catch (Exception e) {
            return state.override(new Function1() { // from class: video.biz.offline.list.logic.statemachine.OfflineDownloadingPageStateMachine$$ExternalSyntheticLambda1
                public final Object invoke(Object obj) {
                    OfflinePageState loadData$lambda$1;
                    loadData$lambda$1 = OfflineDownloadingPageStateMachine.loadData$lambda$1((OfflinePageState) obj);
                    return loadData$lambda$1;
                }
            });
        }
        offlineDownloadingPageStateMachine$loadData$1 = new OfflineDownloadingPageStateMachine$loadData$1(this, continuation);
        Object $result2 = offlineDownloadingPageStateMachine$loadData$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OfflinePageState loadData$lambda$0(List $downloading, OfflineDownloadingPageStateMachine this$0, OfflinePageState $this$mutate) {
        OfflinePageState copy;
        Intrinsics.checkNotNullParameter($this$mutate, "$this$mutate");
        copy = $this$mutate.copy((r18 & 1) != 0 ? $this$mutate.downloading : $downloading, (r18 & 2) != 0 ? $this$mutate.completed : null, (r18 & 4) != 0 ? $this$mutate.dataState : DataState.READY, (r18 & 8) != 0 ? $this$mutate.selectionState : null, (r18 & 16) != 0 ? $this$mutate.config : this$0.updateConfig($this$mutate, $downloading.isEmpty()), (r18 & 32) != 0 ? $this$mutate.storageInfo : null, (r18 & 64) != 0 ? $this$mutate.reserveInfo : null, (r18 & 128) != 0 ? $this$mutate.dialogType : null);
        return copy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OfflinePageState loadData$lambda$1(OfflinePageState $this$override) {
        Intrinsics.checkNotNullParameter($this$override, "$this$override");
        return OfflinePageStateKt.getOfflinePageErrorState();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a3  */
    @Override // video.biz.offline.list.logic.statemachine.OfflineBaseListStateMachine
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object handleClick(State<OfflinePageState> state, final OfflineListAction.ItemClick action, Continuation<? super ChangedState<OfflinePageState>> continuation) {
        final Set result;
        Object obj;
        boolean z;
        boolean isFreeBandWidthError;
        SelectionState selectionState = ((OfflinePageState) state.getSnapshot()).getSelectionState();
        if (Intrinsics.areEqual(selectionState, SelectionState.Inactive.INSTANCE)) {
            LogKt.getVBLog().info("click item: " + action.getKey());
            Iterator<T> it = ((OfflinePageState) state.getSnapshot()).getDownloading().iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                OfflineDownloadingCardModel it2 = (OfflineDownloadingCardModel) obj;
                if (Intrinsics.areEqual(it2.getKey(), action.getKey())) {
                    break;
                }
            }
            OfflineDownloadingCardModel item = (OfflineDownloadingCardModel) obj;
            if (item == null) {
                return state.noChange();
            }
            if (item.isDownloading()) {
                processWithLoading(this, new OfflineDownloadingPageStateMachine$handleClick$2(action, null));
            } else {
                CoroutineScope coroutineScope = this.scope;
                OfflineDownloadingPageStateMachine offlineDownloadingPageStateMachine = this;
                if (Config.Companion.getHitFreeBandWidthFix865()) {
                    isFreeBandWidthError = OfflineDownloadingPageStateMachineKt.isFreeBandWidthError(item.getErrorCode());
                    if (isFreeBandWidthError) {
                        z = true;
                        if (UtilsKt.checkNetworkState(coroutineScope, offlineDownloadingPageStateMachine, z, new Function0() { // from class: video.biz.offline.list.logic.statemachine.OfflineDownloadingPageStateMachine$$ExternalSyntheticLambda6
                            public final Object invoke() {
                                Unit handleClick$lambda$1;
                                handleClick$lambda$1 = OfflineDownloadingPageStateMachine.handleClick$lambda$1(OfflineDownloadingPageStateMachine.this, action);
                                return handleClick$lambda$1;
                            }
                        })) {
                            processWithLoading(this, new OfflineDownloadingPageStateMachine$handleClick$4(action, null));
                        }
                    }
                }
                z = false;
                if (UtilsKt.checkNetworkState(coroutineScope, offlineDownloadingPageStateMachine, z, new Function0() { // from class: video.biz.offline.list.logic.statemachine.OfflineDownloadingPageStateMachine$$ExternalSyntheticLambda6
                    public final Object invoke() {
                        Unit handleClick$lambda$1;
                        handleClick$lambda$1 = OfflineDownloadingPageStateMachine.handleClick$lambda$1(OfflineDownloadingPageStateMachine.this, action);
                        return handleClick$lambda$1;
                    }
                })) {
                }
            }
            return state.noChange();
        } else if (selectionState instanceof SelectionState.Active) {
            Set selected = ((SelectionState.Active) selectionState).getSelectedIds();
            if (selected.contains(action.getKey())) {
                result = SetsKt.minus(selected, action.getKey());
            } else {
                result = SetsKt.plus(selected, action.getKey());
            }
            return state.mutate(new Function1() { // from class: video.biz.offline.list.logic.statemachine.OfflineDownloadingPageStateMachine$$ExternalSyntheticLambda7
                public final Object invoke(Object obj2) {
                    OfflinePageState handleClick$lambda$2;
                    handleClick$lambda$2 = OfflineDownloadingPageStateMachine.handleClick$lambda$2(result, (OfflinePageState) obj2);
                    return handleClick$lambda$2;
                }
            });
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit handleClick$lambda$1(OfflineDownloadingPageStateMachine this$0, OfflineListAction.ItemClick $action) {
        if (Config.Companion.getHitFreeBandWidthFix865()) {
            Config.Companion.setEnableDownloadWithWWAN(true);
        }
        this$0.processWithLoading(this$0, new OfflineDownloadingPageStateMachine$handleClick$3$1($action, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OfflinePageState handleClick$lambda$2(Set $result, OfflinePageState $this$mutate) {
        OfflinePageState copy;
        Intrinsics.checkNotNullParameter($this$mutate, "$this$mutate");
        copy = $this$mutate.copy((r18 & 1) != 0 ? $this$mutate.downloading : null, (r18 & 2) != 0 ? $this$mutate.completed : null, (r18 & 4) != 0 ? $this$mutate.dataState : null, (r18 & 8) != 0 ? $this$mutate.selectionState : new SelectionState.Active($result), (r18 & 16) != 0 ? $this$mutate.config : null, (r18 & 32) != 0 ? $this$mutate.storageInfo : null, (r18 & 64) != 0 ? $this$mutate.reserveInfo : null, (r18 & 128) != 0 ? $this$mutate.dialogType : null);
        return copy;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // video.biz.offline.list.logic.statemachine.OfflineBaseListStateMachine
    public ChangedState<OfflinePageState> handleSelectAll(final State<OfflinePageState> state) {
        Intrinsics.checkNotNullParameter(state, "state");
        return state.mutate(new Function1() { // from class: video.biz.offline.list.logic.statemachine.OfflineDownloadingPageStateMachine$$ExternalSyntheticLambda4
            public final Object invoke(Object obj) {
                OfflinePageState handleSelectAll$lambda$0;
                handleSelectAll$lambda$0 = OfflineDownloadingPageStateMachine.handleSelectAll$lambda$0(state, (OfflinePageState) obj);
                return handleSelectAll$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OfflinePageState handleSelectAll$lambda$0(State $state, OfflinePageState $this$mutate) {
        OfflinePageState copy;
        OfflinePageState copy2;
        Intrinsics.checkNotNullParameter($this$mutate, "$this$mutate");
        if (((OfflinePageState) $state.getSnapshot()).selected().size() != ((OfflinePageState) $state.getSnapshot()).getDownloading().size()) {
            Iterable $this$map$iv = $this$mutate.getDownloading();
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                OfflineDownloadingCardModel it = (OfflineDownloadingCardModel) item$iv$iv;
                destination$iv$iv.add(it.getKey());
            }
            copy = $this$mutate.copy((r18 & 1) != 0 ? $this$mutate.downloading : null, (r18 & 2) != 0 ? $this$mutate.completed : null, (r18 & 4) != 0 ? $this$mutate.dataState : null, (r18 & 8) != 0 ? $this$mutate.selectionState : new SelectionState.Active(CollectionsKt.toSet((List) destination$iv$iv)), (r18 & 16) != 0 ? $this$mutate.config : null, (r18 & 32) != 0 ? $this$mutate.storageInfo : null, (r18 & 64) != 0 ? $this$mutate.reserveInfo : null, (r18 & 128) != 0 ? $this$mutate.dialogType : null);
            return copy;
        }
        copy2 = $this$mutate.copy((r18 & 1) != 0 ? $this$mutate.downloading : null, (r18 & 2) != 0 ? $this$mutate.completed : null, (r18 & 4) != 0 ? $this$mutate.dataState : null, (r18 & 8) != 0 ? $this$mutate.selectionState : new SelectionState.Active(null, 1, null), (r18 & 16) != 0 ? $this$mutate.config : null, (r18 & 32) != 0 ? $this$mutate.storageInfo : null, (r18 & 64) != 0 ? $this$mutate.reserveInfo : null, (r18 & 128) != 0 ? $this$mutate.dialogType : null);
        return copy2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final OfflinePageConfig updateConfig(OfflinePageState $this$updateConfig, boolean isEmpty) {
        List listOf;
        OfflinePageConfig config = $this$updateConfig.getConfig();
        if (isEmpty) {
            listOf = CollectionsKt.emptyList();
        } else {
            listOf = CollectionsKt.listOf(OfflinePageOperation.EDIT_ICON);
        }
        return OfflinePageConfig.copy$default(config, listOf, null, 0, 6, null);
    }
}