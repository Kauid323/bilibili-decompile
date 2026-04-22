package video.biz.offline.list.logic.statemachine;

import com.freeletics.flowredux.dsl.BaseBuilderBlock;
import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.ExecutionPolicy;
import com.freeletics.flowredux.dsl.InStateBuilderBlock;
import com.freeletics.flowredux.dsl.State;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kntr.base.router.Router;
import kntr.common.router.UrisKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlin.time.Duration;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.biliplayerv2.service.interact.biz.sender.ChronosDanmakuSender;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.base.log.LogKt;
import video.biz.offline.base.facade.IOfflineFacade;
import video.biz.offline.base.facade.OfflineFacadeImpl_androidKt;
import video.biz.offline.base.model.entity.OfflineVideoEntity;
import video.biz.offline.base.model.model.AuthCode;
import video.biz.offline.base.model.model.AuthCodeKt;
import video.biz.offline.list.logic.model.DataState;
import video.biz.offline.list.logic.model.OfflineCacheCardModelKt;
import video.biz.offline.list.logic.model.OfflineCachedCardModel;
import video.biz.offline.list.logic.model.OfflinePageState;
import video.biz.offline.list.logic.model.OfflinePageStateKt;
import video.biz.offline.list.logic.statemachine.OfflineListAction;
import video.biz.offline.list.logic.utils.UtilsKt;

/* compiled from: OfflineSearchPageStateMachine.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u001e\u0010\f\u001a\u00020\r*\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000f0\u000eH\u0014J\"\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u0013H\u0094@¢\u0006\u0002\u0010\u0014J*\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u00132\u0006\u0010\u0016\u001a\u00020\u0017H\u0094@¢\u0006\u0002\u0010\u0018J\u001c\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00030\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u0013H\u0014J\"\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00030\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u0013H\u0094@¢\u0006\u0002\u0010\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lvideo/biz/offline/list/logic/statemachine/OfflineSearchPageStateMachine;", "Lvideo/biz/offline/list/logic/statemachine/OfflineBaseListStateMachine;", "initialState", "Lvideo/biz/offline/list/logic/model/OfflinePageState;", "router", "Lkntr/base/router/Router;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "(Lvideo/biz/offline/list/logic/model/OfflinePageState;Lkntr/base/router/Router;Lkotlinx/coroutines/CoroutineScope;)V", ChronosDanmakuSender.KEY_MARK_DANMAKU, "", "childSpec", "", "Lcom/freeletics/flowredux/dsl/InStateBuilderBlock;", "Lvideo/biz/offline/list/logic/statemachine/OfflineListAction;", "loadData", "Lcom/freeletics/flowredux/dsl/ChangedState;", "state", "Lcom/freeletics/flowredux/dsl/State;", "(Lcom/freeletics/flowredux/dsl/State;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleClick", "action", "Lvideo/biz/offline/list/logic/statemachine/OfflineListAction$ItemClick;", "(Lcom/freeletics/flowredux/dsl/State;Lvideo/biz/offline/list/logic/statemachine/OfflineListAction$ItemClick;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleSelectAll", "onHistoryUpdated", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class OfflineSearchPageStateMachine extends OfflineBaseListStateMachine {
    public static final int $stable = 8;
    private String keyword;
    private final Router router;
    private final CoroutineScope scope;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OfflineSearchPageStateMachine(OfflinePageState initialState, Router router, CoroutineScope scope) {
        super(initialState, scope, router);
        Intrinsics.checkNotNullParameter(initialState, "initialState");
        Intrinsics.checkNotNullParameter(router, "router");
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.router = router;
        this.scope = scope;
        this.keyword = "";
    }

    @Override // video.biz.offline.list.logic.statemachine.OfflineBaseListStateMachine
    protected void childSpec(InStateBuilderBlock<OfflinePageState, OfflinePageState, OfflineListAction> inStateBuilderBlock) {
        Intrinsics.checkNotNullParameter(inStateBuilderBlock, "<this>");
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) inStateBuilderBlock;
        Function3 handler$iv = new OfflineSearchPageStateMachine$childSpec$1(this, null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(OfflineListAction.Search.class), executionPolicy$iv, handler$iv);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0093 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ae A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00af  */
    @Override // video.biz.offline.list.logic.statemachine.OfflineBaseListStateMachine
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object loadData(State<OfflinePageState> state, Continuation<? super ChangedState<OfflinePageState>> continuation) {
        OfflineSearchPageStateMachine$loadData$1 offlineSearchPageStateMachine$loadData$1;
        List videos;
        Object search;
        Object searchResult;
        OfflineListAction.UpdateHistoryProgress updateHistoryProgress;
        final List completed;
        try {
            if (continuation instanceof OfflineSearchPageStateMachine$loadData$1) {
                offlineSearchPageStateMachine$loadData$1 = (OfflineSearchPageStateMachine$loadData$1) continuation;
                if ((offlineSearchPageStateMachine$loadData$1.label & Integer.MIN_VALUE) != 0) {
                    offlineSearchPageStateMachine$loadData$1.label -= Integer.MIN_VALUE;
                    Object $result = offlineSearchPageStateMachine$loadData$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (offlineSearchPageStateMachine$loadData$1.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            if (!StringsKt.isBlank(this.keyword)) {
                                IOfflineFacade offlineFacadeImpl = OfflineFacadeImpl_androidKt.getOfflineFacadeImpl();
                                String str = this.keyword;
                                offlineSearchPageStateMachine$loadData$1.L$0 = state;
                                offlineSearchPageStateMachine$loadData$1.label = 1;
                                search = offlineFacadeImpl.search(str, offlineSearchPageStateMachine$loadData$1);
                                if (search == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                videos = (List) search;
                                Map<Long, Duration> historyCache = getHistoryCache();
                                offlineSearchPageStateMachine$loadData$1.L$0 = state;
                                offlineSearchPageStateMachine$loadData$1.L$1 = SpillingKt.nullOutSpilledVariable(videos);
                                offlineSearchPageStateMachine$loadData$1.label = 2;
                                searchResult = OfflineCacheCardModelKt.searchResult(videos, historyCache, offlineSearchPageStateMachine$loadData$1);
                                if (searchResult == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                List completed2 = (List) searchResult;
                                updateHistoryProgress = new OfflineListAction.UpdateHistoryProgress(completed2);
                                offlineSearchPageStateMachine$loadData$1.L$0 = state;
                                offlineSearchPageStateMachine$loadData$1.L$1 = SpillingKt.nullOutSpilledVariable(videos);
                                offlineSearchPageStateMachine$loadData$1.L$2 = completed2;
                                offlineSearchPageStateMachine$loadData$1.label = 3;
                                if (dispatch(updateHistoryProgress, offlineSearchPageStateMachine$loadData$1) != coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                completed = completed2;
                                return state.mutate(new Function1() { // from class: video.biz.offline.list.logic.statemachine.OfflineSearchPageStateMachine$$ExternalSyntheticLambda2
                                    public final Object invoke(Object obj) {
                                        OfflinePageState loadData$lambda$0;
                                        loadData$lambda$0 = OfflineSearchPageStateMachine.loadData$lambda$0(completed, (OfflinePageState) obj);
                                        return loadData$lambda$0;
                                    }
                                });
                            }
                            videos = CollectionsKt.emptyList();
                            Map<Long, Duration> historyCache2 = getHistoryCache();
                            offlineSearchPageStateMachine$loadData$1.L$0 = state;
                            offlineSearchPageStateMachine$loadData$1.L$1 = SpillingKt.nullOutSpilledVariable(videos);
                            offlineSearchPageStateMachine$loadData$1.label = 2;
                            searchResult = OfflineCacheCardModelKt.searchResult(videos, historyCache2, offlineSearchPageStateMachine$loadData$1);
                            if (searchResult == coroutine_suspended) {
                            }
                            List completed22 = (List) searchResult;
                            updateHistoryProgress = new OfflineListAction.UpdateHistoryProgress(completed22);
                            offlineSearchPageStateMachine$loadData$1.L$0 = state;
                            offlineSearchPageStateMachine$loadData$1.L$1 = SpillingKt.nullOutSpilledVariable(videos);
                            offlineSearchPageStateMachine$loadData$1.L$2 = completed22;
                            offlineSearchPageStateMachine$loadData$1.label = 3;
                            if (dispatch(updateHistoryProgress, offlineSearchPageStateMachine$loadData$1) != coroutine_suspended) {
                            }
                        case 1:
                            state = (State) offlineSearchPageStateMachine$loadData$1.L$0;
                            ResultKt.throwOnFailure($result);
                            search = $result;
                            videos = (List) search;
                            Map<Long, Duration> historyCache22 = getHistoryCache();
                            offlineSearchPageStateMachine$loadData$1.L$0 = state;
                            offlineSearchPageStateMachine$loadData$1.L$1 = SpillingKt.nullOutSpilledVariable(videos);
                            offlineSearchPageStateMachine$loadData$1.label = 2;
                            searchResult = OfflineCacheCardModelKt.searchResult(videos, historyCache22, offlineSearchPageStateMachine$loadData$1);
                            if (searchResult == coroutine_suspended) {
                            }
                            List completed222 = (List) searchResult;
                            updateHistoryProgress = new OfflineListAction.UpdateHistoryProgress(completed222);
                            offlineSearchPageStateMachine$loadData$1.L$0 = state;
                            offlineSearchPageStateMachine$loadData$1.L$1 = SpillingKt.nullOutSpilledVariable(videos);
                            offlineSearchPageStateMachine$loadData$1.L$2 = completed222;
                            offlineSearchPageStateMachine$loadData$1.label = 3;
                            if (dispatch(updateHistoryProgress, offlineSearchPageStateMachine$loadData$1) != coroutine_suspended) {
                            }
                            break;
                        case 2:
                            videos = (List) offlineSearchPageStateMachine$loadData$1.L$1;
                            state = (State) offlineSearchPageStateMachine$loadData$1.L$0;
                            ResultKt.throwOnFailure($result);
                            searchResult = $result;
                            List completed2222 = (List) searchResult;
                            updateHistoryProgress = new OfflineListAction.UpdateHistoryProgress(completed2222);
                            offlineSearchPageStateMachine$loadData$1.L$0 = state;
                            offlineSearchPageStateMachine$loadData$1.L$1 = SpillingKt.nullOutSpilledVariable(videos);
                            offlineSearchPageStateMachine$loadData$1.L$2 = completed2222;
                            offlineSearchPageStateMachine$loadData$1.label = 3;
                            if (dispatch(updateHistoryProgress, offlineSearchPageStateMachine$loadData$1) != coroutine_suspended) {
                            }
                            break;
                        case 3:
                            completed = (List) offlineSearchPageStateMachine$loadData$1.L$2;
                            List list = (List) offlineSearchPageStateMachine$loadData$1.L$1;
                            state = (State) offlineSearchPageStateMachine$loadData$1.L$0;
                            ResultKt.throwOnFailure($result);
                            return state.mutate(new Function1() { // from class: video.biz.offline.list.logic.statemachine.OfflineSearchPageStateMachine$$ExternalSyntheticLambda2
                                public final Object invoke(Object obj) {
                                    OfflinePageState loadData$lambda$0;
                                    loadData$lambda$0 = OfflineSearchPageStateMachine.loadData$lambda$0(completed, (OfflinePageState) obj);
                                    return loadData$lambda$0;
                                }
                            });
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }
            }
            switch (offlineSearchPageStateMachine$loadData$1.label) {
            }
        } catch (Exception e) {
            return state.override(new Function1() { // from class: video.biz.offline.list.logic.statemachine.OfflineSearchPageStateMachine$$ExternalSyntheticLambda3
                public final Object invoke(Object obj) {
                    OfflinePageState loadData$lambda$1;
                    loadData$lambda$1 = OfflineSearchPageStateMachine.loadData$lambda$1((OfflinePageState) obj);
                    return loadData$lambda$1;
                }
            });
        }
        offlineSearchPageStateMachine$loadData$1 = new OfflineSearchPageStateMachine$loadData$1(this, continuation);
        Object $result2 = offlineSearchPageStateMachine$loadData$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OfflinePageState loadData$lambda$0(List $completed, OfflinePageState $this$mutate) {
        OfflinePageState copy;
        Intrinsics.checkNotNullParameter($this$mutate, "$this$mutate");
        copy = $this$mutate.copy((r18 & 1) != 0 ? $this$mutate.downloading : null, (r18 & 2) != 0 ? $this$mutate.completed : $completed, (r18 & 4) != 0 ? $this$mutate.dataState : DataState.READY, (r18 & 8) != 0 ? $this$mutate.selectionState : null, (r18 & 16) != 0 ? $this$mutate.config : null, (r18 & 32) != 0 ? $this$mutate.storageInfo : null, (r18 & 64) != 0 ? $this$mutate.reserveInfo : null, (r18 & 128) != 0 ? $this$mutate.dialogType : null);
        return copy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OfflinePageState loadData$lambda$1(OfflinePageState $this$override) {
        Intrinsics.checkNotNullParameter($this$override, "$this$override");
        return OfflinePageStateKt.getOfflinePageErrorState();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // video.biz.offline.list.logic.statemachine.OfflineBaseListStateMachine
    public Object handleClick(State<OfflinePageState> state, OfflineListAction.ItemClick action, Continuation<? super ChangedState<OfflinePageState>> continuation) {
        Object obj;
        Iterator<T> it = ((OfflinePageState) state.getSnapshot()).getCompleted().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual(((OfflineCachedCardModel) obj).getId(), action.getKey())) {
                break;
            }
        }
        OfflineCachedCardModel item = (OfflineCachedCardModel) obj;
        if (item == null) {
            return state.noChange();
        }
        if (item.getChildCount() > 1) {
            Router router = this.router;
            String key = action.getKey();
            String encodedTitle = item.getEncodedTitle();
            router.launch(UrisKt.toUri("bilibili://offline/cache/completed?id=" + key + "&type=group&title=" + encodedTitle + "&keyword=" + this.keyword));
        } else {
            final OfflineVideoEntity it2 = item.getEntity();
            if (it2 != null) {
                final AuthCode authCode = AuthCodeKt.toAuthCode(it2.getAuthCode());
                if (ArraysKt.contains(AuthCodeKt.getForbiddenAuthCodeArray(), authCode)) {
                    return state.mutate(new Function1() { // from class: video.biz.offline.list.logic.statemachine.OfflineSearchPageStateMachine$$ExternalSyntheticLambda4
                        public final Object invoke(Object obj2) {
                            OfflinePageState handleClick$lambda$1$0;
                            handleClick$lambda$1$0 = OfflineSearchPageStateMachine.handleClick$lambda$1$0(AuthCode.this, it2, (OfflinePageState) obj2);
                            return handleClick$lambda$1$0;
                        }
                    });
                }
                this.router.launch(UtilsKt.plRoute(it2, false));
            }
        }
        return state.noChange();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OfflinePageState handleClick$lambda$1$0(AuthCode $authCode, OfflineVideoEntity $it, OfflinePageState $this$mutate) {
        OfflinePageState copy;
        Intrinsics.checkNotNullParameter($this$mutate, "$this$mutate");
        copy = $this$mutate.copy((r18 & 1) != 0 ? $this$mutate.downloading : null, (r18 & 2) != 0 ? $this$mutate.completed : null, (r18 & 4) != 0 ? $this$mutate.dataState : null, (r18 & 8) != 0 ? $this$mutate.selectionState : null, (r18 & 16) != 0 ? $this$mutate.config : null, (r18 & 32) != 0 ? $this$mutate.storageInfo : null, (r18 & 64) != 0 ? $this$mutate.reserveInfo : null, (r18 & 128) != 0 ? $this$mutate.dialogType : OfflinePageStateKt.dialogType($authCode, $it.getAid()));
        return copy;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // video.biz.offline.list.logic.statemachine.OfflineBaseListStateMachine
    public ChangedState<OfflinePageState> handleSelectAll(State<OfflinePageState> state) {
        Intrinsics.checkNotNullParameter(state, "state");
        return state.noChange();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0081 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0082  */
    @Override // video.biz.offline.list.logic.statemachine.OfflineBaseListStateMachine
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object onHistoryUpdated(State<OfflinePageState> state, Continuation<? super ChangedState<OfflinePageState>> continuation) {
        OfflineSearchPageStateMachine$onHistoryUpdated$1 offlineSearchPageStateMachine$onHistoryUpdated$1;
        List videos;
        Object search;
        Object searchResult;
        try {
            if (continuation instanceof OfflineSearchPageStateMachine$onHistoryUpdated$1) {
                offlineSearchPageStateMachine$onHistoryUpdated$1 = (OfflineSearchPageStateMachine$onHistoryUpdated$1) continuation;
                if ((offlineSearchPageStateMachine$onHistoryUpdated$1.label & Integer.MIN_VALUE) != 0) {
                    offlineSearchPageStateMachine$onHistoryUpdated$1.label -= Integer.MIN_VALUE;
                    Object $result = offlineSearchPageStateMachine$onHistoryUpdated$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (offlineSearchPageStateMachine$onHistoryUpdated$1.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            if (!StringsKt.isBlank(this.keyword)) {
                                IOfflineFacade offlineFacadeImpl = OfflineFacadeImpl_androidKt.getOfflineFacadeImpl();
                                String str = this.keyword;
                                offlineSearchPageStateMachine$onHistoryUpdated$1.L$0 = state;
                                offlineSearchPageStateMachine$onHistoryUpdated$1.label = 1;
                                search = offlineFacadeImpl.search(str, offlineSearchPageStateMachine$onHistoryUpdated$1);
                                if (search == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                videos = (List) search;
                                Map<Long, Duration> historyCache = getHistoryCache();
                                offlineSearchPageStateMachine$onHistoryUpdated$1.L$0 = state;
                                offlineSearchPageStateMachine$onHistoryUpdated$1.L$1 = SpillingKt.nullOutSpilledVariable(videos);
                                offlineSearchPageStateMachine$onHistoryUpdated$1.label = 2;
                                searchResult = OfflineCacheCardModelKt.searchResult(videos, historyCache, offlineSearchPageStateMachine$onHistoryUpdated$1);
                                if (searchResult == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                final List completed = (List) searchResult;
                                return state.mutate(new Function1() { // from class: video.biz.offline.list.logic.statemachine.OfflineSearchPageStateMachine$$ExternalSyntheticLambda0
                                    public final Object invoke(Object obj) {
                                        OfflinePageState onHistoryUpdated$lambda$0;
                                        onHistoryUpdated$lambda$0 = OfflineSearchPageStateMachine.onHistoryUpdated$lambda$0(completed, (OfflinePageState) obj);
                                        return onHistoryUpdated$lambda$0;
                                    }
                                });
                            }
                            videos = CollectionsKt.emptyList();
                            Map<Long, Duration> historyCache2 = getHistoryCache();
                            offlineSearchPageStateMachine$onHistoryUpdated$1.L$0 = state;
                            offlineSearchPageStateMachine$onHistoryUpdated$1.L$1 = SpillingKt.nullOutSpilledVariable(videos);
                            offlineSearchPageStateMachine$onHistoryUpdated$1.label = 2;
                            searchResult = OfflineCacheCardModelKt.searchResult(videos, historyCache2, offlineSearchPageStateMachine$onHistoryUpdated$1);
                            if (searchResult == coroutine_suspended) {
                            }
                        case 1:
                            state = (State) offlineSearchPageStateMachine$onHistoryUpdated$1.L$0;
                            ResultKt.throwOnFailure($result);
                            search = $result;
                            videos = (List) search;
                            Map<Long, Duration> historyCache22 = getHistoryCache();
                            offlineSearchPageStateMachine$onHistoryUpdated$1.L$0 = state;
                            offlineSearchPageStateMachine$onHistoryUpdated$1.L$1 = SpillingKt.nullOutSpilledVariable(videos);
                            offlineSearchPageStateMachine$onHistoryUpdated$1.label = 2;
                            searchResult = OfflineCacheCardModelKt.searchResult(videos, historyCache22, offlineSearchPageStateMachine$onHistoryUpdated$1);
                            if (searchResult == coroutine_suspended) {
                            }
                            break;
                        case 2:
                            List list = (List) offlineSearchPageStateMachine$onHistoryUpdated$1.L$1;
                            state = (State) offlineSearchPageStateMachine$onHistoryUpdated$1.L$0;
                            ResultKt.throwOnFailure($result);
                            searchResult = $result;
                            final List completed2 = (List) searchResult;
                            return state.mutate(new Function1() { // from class: video.biz.offline.list.logic.statemachine.OfflineSearchPageStateMachine$$ExternalSyntheticLambda0
                                public final Object invoke(Object obj) {
                                    OfflinePageState onHistoryUpdated$lambda$0;
                                    onHistoryUpdated$lambda$0 = OfflineSearchPageStateMachine.onHistoryUpdated$lambda$0(completed2, (OfflinePageState) obj);
                                    return onHistoryUpdated$lambda$0;
                                }
                            });
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }
            }
            switch (offlineSearchPageStateMachine$onHistoryUpdated$1.label) {
            }
        } catch (CancellationException cancellation) {
            throw cancellation;
        } catch (Exception e) {
            LogKt.getVBLog().error("onHistoryUpdated error: " + e);
            return state.override(new Function1() { // from class: video.biz.offline.list.logic.statemachine.OfflineSearchPageStateMachine$$ExternalSyntheticLambda1
                public final Object invoke(Object obj) {
                    OfflinePageState onHistoryUpdated$lambda$1;
                    onHistoryUpdated$lambda$1 = OfflineSearchPageStateMachine.onHistoryUpdated$lambda$1((OfflinePageState) obj);
                    return onHistoryUpdated$lambda$1;
                }
            });
        }
        offlineSearchPageStateMachine$onHistoryUpdated$1 = new OfflineSearchPageStateMachine$onHistoryUpdated$1(this, continuation);
        Object $result2 = offlineSearchPageStateMachine$onHistoryUpdated$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OfflinePageState onHistoryUpdated$lambda$0(List $completed, OfflinePageState $this$mutate) {
        OfflinePageState copy;
        Intrinsics.checkNotNullParameter($this$mutate, "$this$mutate");
        copy = $this$mutate.copy((r18 & 1) != 0 ? $this$mutate.downloading : null, (r18 & 2) != 0 ? $this$mutate.completed : $completed, (r18 & 4) != 0 ? $this$mutate.dataState : DataState.READY, (r18 & 8) != 0 ? $this$mutate.selectionState : null, (r18 & 16) != 0 ? $this$mutate.config : null, (r18 & 32) != 0 ? $this$mutate.storageInfo : null, (r18 & 64) != 0 ? $this$mutate.reserveInfo : null, (r18 & 128) != 0 ? $this$mutate.dialogType : null);
        return copy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OfflinePageState onHistoryUpdated$lambda$1(OfflinePageState $this$override) {
        Intrinsics.checkNotNullParameter($this$override, "$this$override");
        return OfflinePageStateKt.getOfflinePageErrorState();
    }
}