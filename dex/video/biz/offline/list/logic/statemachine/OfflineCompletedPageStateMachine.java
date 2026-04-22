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
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kntr.base.router.Router;
import kntr.common.router.UrisKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.time.Duration;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import tv.danmaku.biliplayerv2.service.interact.biz.sender.ChronosDanmakuSender;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.base.log.IVBLog;
import video.base.log.LogKt;
import video.base.utils.DateKt;
import video.base.utils.VBStriingExtKt;
import video.biz.offline.base.facade.IOfflineFacade;
import video.biz.offline.base.facade.OfflineFacadeImpl_androidKt;
import video.biz.offline.base.model.entity.OfflineVideoEntity;
import video.biz.offline.base.model.model.AuthCode;
import video.biz.offline.base.model.model.AuthCodeKt;
import video.biz.offline.list.logic.model.DataState;
import video.biz.offline.list.logic.model.OfflineCacheCardModelKt;
import video.biz.offline.list.logic.model.OfflineCachedCardModel;
import video.biz.offline.list.logic.model.OfflinePageConfig;
import video.biz.offline.list.logic.model.OfflinePageOperation;
import video.biz.offline.list.logic.model.OfflinePageState;
import video.biz.offline.list.logic.model.OfflinePageStateKt;
import video.biz.offline.list.logic.model.SelectionState;
import video.biz.offline.list.logic.statemachine.OfflineListAction;
import video.biz.offline.list.logic.utils.UtilsKt;

/* compiled from: OfflineCompletedPageStateMachine.kt */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001Ba\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012(\b\u0002\u0010\f\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rj\u0004\u0018\u0001`\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\u001e\u0010\u0012\u001a\u00020\u0013*\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00150\u0014H\u0015J\"\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u0019H\u0094@¢\u0006\u0002\u0010\u001aJ*\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u00192\u0006\u0010\u001c\u001a\u00020\u001dH\u0094@¢\u0006\u0002\u0010\u001eJ\u001c\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00030\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u0019H\u0014J\"\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00030\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u0019H\u0094@¢\u0006\u0002\u0010\u001aJ\u0014\u0010!\u001a\u00020\"*\u00020\u00032\u0006\u0010#\u001a\u00020\u000eH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R.\u0010\f\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rj\u0004\u0018\u0001`\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lvideo/biz/offline/list/logic/statemachine/OfflineCompletedPageStateMachine;", "Lvideo/biz/offline/list/logic/statemachine/OfflineBaseListStateMachine;", "initial", "Lvideo/biz/offline/list/logic/model/OfflinePageState;", "id", "", ChronosDanmakuSender.KEY_MARK_DANMAKU, "type", "router", "Lkntr/base/router/Router;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "downloadedInterceptor", "Lkotlin/Function3;", "", "Lvideo/biz/offline/list/logic/statemachine/OfflineDownloadedRouteInterceptor;", "<init>", "(Lvideo/biz/offline/list/logic/model/OfflinePageState;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkntr/base/router/Router;Lkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/functions/Function3;)V", "childSpec", "", "Lcom/freeletics/flowredux/dsl/InStateBuilderBlock;", "Lvideo/biz/offline/list/logic/statemachine/OfflineListAction;", "loadData", "Lcom/freeletics/flowredux/dsl/ChangedState;", "state", "Lcom/freeletics/flowredux/dsl/State;", "(Lcom/freeletics/flowredux/dsl/State;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleClick", "action", "Lvideo/biz/offline/list/logic/statemachine/OfflineListAction$ItemClick;", "(Lcom/freeletics/flowredux/dsl/State;Lvideo/biz/offline/list/logic/statemachine/OfflineListAction$ItemClick;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleSelectAll", "onHistoryUpdated", "updateConfig", "Lvideo/biz/offline/list/logic/model/OfflinePageConfig;", "isEmpty", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class OfflineCompletedPageStateMachine extends OfflineBaseListStateMachine {
    public static final int $stable = 8;
    private final Function3<String, String, String, Boolean> downloadedInterceptor;
    private String id;
    private String keyword;
    private final Router router;
    private final String type;

    /* compiled from: OfflineCompletedPageStateMachine.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[QueryType.values().length];
            try {
                iArr[QueryType.VIDEO.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[QueryType.GROUP.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public OfflineCompletedPageStateMachine(OfflinePageState initial, String id, String keyword, String type, Router router, CoroutineScope scope, Function3<? super String, ? super String, ? super String, Boolean> function3) {
        super(initial, scope, router);
        Intrinsics.checkNotNullParameter(initial, "initial");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(keyword, ChronosDanmakuSender.KEY_MARK_DANMAKU);
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(router, "router");
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.id = id;
        this.keyword = keyword;
        this.type = type;
        this.router = router;
        this.downloadedInterceptor = function3;
        IVBLog vBLog = LogKt.getVBLog();
        String str = this.id;
        vBLog.info("OfflineCompletedPageStateMachine id: " + str + ", type: " + this.type);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ OfflineCompletedPageStateMachine(OfflinePageState offlinePageState, String str, String str2, String str3, Router router, CoroutineScope coroutineScope, Function3 function3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(offlinePageState, str, str2, str3, router, coroutineScope, r8);
        Function3 function32;
        if ((i & 64) == 0) {
            function32 = function3;
        } else {
            function32 = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean childSpec$lambda$0(OfflinePageState it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getDataState() == DataState.READY;
    }

    @Override // video.biz.offline.list.logic.statemachine.OfflineBaseListStateMachine
    protected void childSpec(InStateBuilderBlock<OfflinePageState, OfflinePageState, OfflineListAction> inStateBuilderBlock) {
        Intrinsics.checkNotNullParameter(inStateBuilderBlock, "<this>");
        inStateBuilderBlock.condition(new Function1() { // from class: video.biz.offline.list.logic.statemachine.OfflineCompletedPageStateMachine$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                boolean childSpec$lambda$0;
                childSpec$lambda$0 = OfflineCompletedPageStateMachine.childSpec$lambda$0((OfflinePageState) obj);
                return Boolean.valueOf(childSpec$lambda$0);
            }
        }, new Function1() { // from class: video.biz.offline.list.logic.statemachine.OfflineCompletedPageStateMachine$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                Unit childSpec$lambda$1;
                childSpec$lambda$1 = OfflineCompletedPageStateMachine.childSpec$lambda$1(OfflineCompletedPageStateMachine.this, (ConditionBuilderBlock) obj);
                return childSpec$lambda$1;
            }
        });
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) inStateBuilderBlock;
        Function3 handler$iv = new OfflineCompletedPageStateMachine$childSpec$3(null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(OfflineListAction.Delete.class), executionPolicy$iv, handler$iv);
        BaseBuilderBlock $this$iv2 = (BaseBuilderBlock) inStateBuilderBlock;
        Function3 handler$iv2 = new OfflineCompletedPageStateMachine$childSpec$4(this, null);
        ExecutionPolicy executionPolicy$iv2 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv2.on(Reflection.getOrCreateKotlinClass(OfflineListAction.DeleteConfirmed.class), executionPolicy$iv2, handler$iv2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit childSpec$lambda$1(final OfflineCompletedPageStateMachine this$0, ConditionBuilderBlock $this$condition) {
        Intrinsics.checkNotNullParameter($this$condition, "$this$condition");
        BaseBuilderBlock.collectWhileInState$default((BaseBuilderBlock) $this$condition, new Function1() { // from class: video.biz.offline.list.logic.statemachine.OfflineCompletedPageStateMachine$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Flow childSpec$lambda$1$0;
                childSpec$lambda$1$0 = OfflineCompletedPageStateMachine.childSpec$lambda$1$0(OfflineCompletedPageStateMachine.this, (OfflinePageState) obj);
                return childSpec$lambda$1$0;
            }
        }, (ExecutionPolicy) null, new OfflineCompletedPageStateMachine$childSpec$2$2(this$0, null), 2, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Flow childSpec$lambda$1$0(OfflineCompletedPageStateMachine this$0, OfflinePageState it) {
        Intrinsics.checkNotNullParameter(it, "it");
        long queryId = VBStriingExtKt.toLongOrZero(this$0.id);
        switch (WhenMappings.$EnumSwitchMapping$0[QueryType.Companion.enumOf(this$0.type).ordinal()]) {
            case 1:
                return OfflineFacadeImpl_androidKt.getOfflineFacadeImpl().getVideosFlowByVideoId(queryId, this$0.keyword);
            case 2:
                return OfflineFacadeImpl_androidKt.getOfflineFacadeImpl().getVideosFlowByGroupId(queryId, this$0.keyword);
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't wrap try/catch for region: R(6:1|(2:3|(4:5|6|7|8))|79|6|7|8) */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0131 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0153 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x016b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x016c  */
    @Override // video.biz.offline.list.logic.statemachine.OfflineBaseListStateMachine
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object loadData(State<OfflinePageState> state, Continuation<? super ChangedState<OfflinePageState>> continuation) {
        OfflineCompletedPageStateMachine$loadData$1 offlineCompletedPageStateMachine$loadData$1;
        OfflineCompletedPageStateMachine$loadData$1 offlineCompletedPageStateMachine$loadData$12;
        long queryId;
        long loadedTimestamp;
        Object videosByGroupId;
        Object videosByVideoId;
        List list;
        long startTimestamp;
        long startTimestamp2;
        List videos;
        Object completedCards;
        long loadedTimestamp2;
        long queryId2;
        List videos2;
        OfflineListAction.UpdateHistoryProgress updateHistoryProgress;
        OfflineListAction.GetStorageInfo getStorageInfo;
        final List completed;
        State state2 = state;
        if (continuation instanceof OfflineCompletedPageStateMachine$loadData$1) {
            offlineCompletedPageStateMachine$loadData$1 = (OfflineCompletedPageStateMachine$loadData$1) continuation;
            if ((offlineCompletedPageStateMachine$loadData$1.label & Integer.MIN_VALUE) != 0) {
                offlineCompletedPageStateMachine$loadData$1.label -= Integer.MIN_VALUE;
                offlineCompletedPageStateMachine$loadData$12 = offlineCompletedPageStateMachine$loadData$1;
                Object $result = offlineCompletedPageStateMachine$loadData$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (offlineCompletedPageStateMachine$loadData$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        try {
                            queryId = VBStriingExtKt.toLongOrZero(this.id);
                            loadedTimestamp = DateKt.getCurrentTimeMillis();
                            switch (WhenMappings.$EnumSwitchMapping$0[QueryType.Companion.enumOf(this.type).ordinal()]) {
                                case 1:
                                    IOfflineFacade offlineFacadeImpl = OfflineFacadeImpl_androidKt.getOfflineFacadeImpl();
                                    String str = this.keyword;
                                    offlineCompletedPageStateMachine$loadData$12.L$0 = state2;
                                    offlineCompletedPageStateMachine$loadData$12.J$0 = queryId;
                                    offlineCompletedPageStateMachine$loadData$12.J$1 = loadedTimestamp;
                                    offlineCompletedPageStateMachine$loadData$12.label = 1;
                                    videosByVideoId = offlineFacadeImpl.getVideosByVideoId(queryId, str, offlineCompletedPageStateMachine$loadData$12);
                                    if (videosByVideoId == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    try {
                                        list = (List) videosByVideoId;
                                        long j = loadedTimestamp;
                                        startTimestamp = queryId;
                                        startTimestamp2 = j;
                                        videos = list;
                                        long loadedTimestamp3 = DateKt.getCurrentTimeMillis();
                                        boolean areEqual = Intrinsics.areEqual(this.type, "group");
                                        Map<Long, Duration> historyCache = getHistoryCache();
                                        offlineCompletedPageStateMachine$loadData$12.L$0 = state2;
                                        offlineCompletedPageStateMachine$loadData$12.L$1 = videos;
                                        offlineCompletedPageStateMachine$loadData$12.J$0 = startTimestamp;
                                        offlineCompletedPageStateMachine$loadData$12.J$1 = startTimestamp2;
                                        offlineCompletedPageStateMachine$loadData$12.J$2 = loadedTimestamp3;
                                        offlineCompletedPageStateMachine$loadData$12.label = 3;
                                        completedCards = OfflineCacheCardModelKt.completedCards(videos, areEqual, historyCache, offlineCompletedPageStateMachine$loadData$12);
                                        if (completedCards == coroutine_suspended) {
                                            long j2 = startTimestamp;
                                            loadedTimestamp2 = loadedTimestamp3;
                                            queryId2 = j2;
                                            videos2 = (List) completedCards;
                                            updateHistoryProgress = new OfflineListAction.UpdateHistoryProgress(videos2);
                                            offlineCompletedPageStateMachine$loadData$12.L$0 = state2;
                                            offlineCompletedPageStateMachine$loadData$12.L$1 = videos;
                                            offlineCompletedPageStateMachine$loadData$12.L$2 = videos2;
                                            offlineCompletedPageStateMachine$loadData$12.J$0 = queryId2;
                                            offlineCompletedPageStateMachine$loadData$12.J$1 = startTimestamp2;
                                            offlineCompletedPageStateMachine$loadData$12.J$2 = loadedTimestamp2;
                                            offlineCompletedPageStateMachine$loadData$12.label = 4;
                                            if (dispatch(updateHistoryProgress, offlineCompletedPageStateMachine$loadData$12) == coroutine_suspended) {
                                                return coroutine_suspended;
                                            }
                                            getStorageInfo = OfflineListAction.GetStorageInfo.INSTANCE;
                                            offlineCompletedPageStateMachine$loadData$12.L$0 = state2;
                                            offlineCompletedPageStateMachine$loadData$12.L$1 = videos;
                                            offlineCompletedPageStateMachine$loadData$12.L$2 = videos2;
                                            offlineCompletedPageStateMachine$loadData$12.J$0 = queryId2;
                                            offlineCompletedPageStateMachine$loadData$12.J$1 = startTimestamp2;
                                            offlineCompletedPageStateMachine$loadData$12.J$2 = loadedTimestamp2;
                                            offlineCompletedPageStateMachine$loadData$12.label = 5;
                                            if (dispatch(getStorageInfo, offlineCompletedPageStateMachine$loadData$12) != coroutine_suspended) {
                                                completed = videos2;
                                                long finishTimestamp = DateKt.getCurrentTimeMillis();
                                                long j3 = loadedTimestamp2 - startTimestamp2;
                                                long startTimestamp3 = finishTimestamp - loadedTimestamp2;
                                                try {
                                                    LogKt.getVBLog().info("OfflineCompletedPageStateMachine loadData size: " + videos.size() + ", load cost: " + j3 + " ms, process cost: " + startTimestamp3 + " ms");
                                                    return state2.mutate(new Function1() { // from class: video.biz.offline.list.logic.statemachine.OfflineCompletedPageStateMachine$$ExternalSyntheticLambda8
                                                        public final Object invoke(Object obj) {
                                                            OfflinePageState loadData$lambda$0;
                                                            loadData$lambda$0 = OfflineCompletedPageStateMachine.loadData$lambda$0(completed, this, (OfflinePageState) obj);
                                                            return loadData$lambda$0;
                                                        }
                                                    });
                                                } catch (Exception e) {
                                                    break;
                                                }
                                            } else {
                                                return coroutine_suspended;
                                            }
                                        } else {
                                            return coroutine_suspended;
                                        }
                                    } catch (Exception e2) {
                                        break;
                                    }
                                case 2:
                                    try {
                                        IOfflineFacade offlineFacadeImpl2 = OfflineFacadeImpl_androidKt.getOfflineFacadeImpl();
                                        String str2 = this.keyword;
                                        offlineCompletedPageStateMachine$loadData$12.L$0 = state2;
                                        offlineCompletedPageStateMachine$loadData$12.J$0 = queryId;
                                        offlineCompletedPageStateMachine$loadData$12.J$1 = loadedTimestamp;
                                        offlineCompletedPageStateMachine$loadData$12.label = 2;
                                        videosByGroupId = offlineFacadeImpl2.getVideosByGroupId(queryId, str2, offlineCompletedPageStateMachine$loadData$12);
                                        if (videosByGroupId == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        list = (List) videosByGroupId;
                                        long j4 = loadedTimestamp;
                                        startTimestamp = queryId;
                                        startTimestamp2 = j4;
                                        videos = list;
                                        long loadedTimestamp32 = DateKt.getCurrentTimeMillis();
                                        boolean areEqual2 = Intrinsics.areEqual(this.type, "group");
                                        Map<Long, Duration> historyCache2 = getHistoryCache();
                                        offlineCompletedPageStateMachine$loadData$12.L$0 = state2;
                                        offlineCompletedPageStateMachine$loadData$12.L$1 = videos;
                                        offlineCompletedPageStateMachine$loadData$12.J$0 = startTimestamp;
                                        offlineCompletedPageStateMachine$loadData$12.J$1 = startTimestamp2;
                                        offlineCompletedPageStateMachine$loadData$12.J$2 = loadedTimestamp32;
                                        offlineCompletedPageStateMachine$loadData$12.label = 3;
                                        completedCards = OfflineCacheCardModelKt.completedCards(videos, areEqual2, historyCache2, offlineCompletedPageStateMachine$loadData$12);
                                        if (completedCards == coroutine_suspended) {
                                        }
                                    } catch (Exception e3) {
                                        break;
                                    }
                                    break;
                                default:
                                    try {
                                        throw new NoWhenBranchMatchedException();
                                    } catch (Exception e4) {
                                        break;
                                    }
                            }
                        } catch (Exception e5) {
                        }
                        return state2.override(new Function1() { // from class: video.biz.offline.list.logic.statemachine.OfflineCompletedPageStateMachine$$ExternalSyntheticLambda9
                            public final Object invoke(Object obj) {
                                OfflinePageState loadData$lambda$1;
                                loadData$lambda$1 = OfflineCompletedPageStateMachine.loadData$lambda$1((OfflinePageState) obj);
                                return loadData$lambda$1;
                            }
                        });
                    case 1:
                        loadedTimestamp = offlineCompletedPageStateMachine$loadData$12.J$1;
                        queryId = offlineCompletedPageStateMachine$loadData$12.J$0;
                        state2 = (State) offlineCompletedPageStateMachine$loadData$12.L$0;
                        ResultKt.throwOnFailure($result);
                        videosByVideoId = $result;
                        list = (List) videosByVideoId;
                        long j5 = loadedTimestamp;
                        startTimestamp = queryId;
                        startTimestamp2 = j5;
                        videos = list;
                        long loadedTimestamp322 = DateKt.getCurrentTimeMillis();
                        boolean areEqual22 = Intrinsics.areEqual(this.type, "group");
                        Map<Long, Duration> historyCache22 = getHistoryCache();
                        offlineCompletedPageStateMachine$loadData$12.L$0 = state2;
                        offlineCompletedPageStateMachine$loadData$12.L$1 = videos;
                        offlineCompletedPageStateMachine$loadData$12.J$0 = startTimestamp;
                        offlineCompletedPageStateMachine$loadData$12.J$1 = startTimestamp2;
                        offlineCompletedPageStateMachine$loadData$12.J$2 = loadedTimestamp322;
                        offlineCompletedPageStateMachine$loadData$12.label = 3;
                        completedCards = OfflineCacheCardModelKt.completedCards(videos, areEqual22, historyCache22, offlineCompletedPageStateMachine$loadData$12);
                        if (completedCards == coroutine_suspended) {
                        }
                        break;
                    case 2:
                        loadedTimestamp = offlineCompletedPageStateMachine$loadData$12.J$1;
                        queryId = offlineCompletedPageStateMachine$loadData$12.J$0;
                        state2 = (State) offlineCompletedPageStateMachine$loadData$12.L$0;
                        ResultKt.throwOnFailure($result);
                        videosByGroupId = $result;
                        list = (List) videosByGroupId;
                        long j42 = loadedTimestamp;
                        startTimestamp = queryId;
                        startTimestamp2 = j42;
                        videos = list;
                        long loadedTimestamp3222 = DateKt.getCurrentTimeMillis();
                        boolean areEqual222 = Intrinsics.areEqual(this.type, "group");
                        Map<Long, Duration> historyCache222 = getHistoryCache();
                        offlineCompletedPageStateMachine$loadData$12.L$0 = state2;
                        offlineCompletedPageStateMachine$loadData$12.L$1 = videos;
                        offlineCompletedPageStateMachine$loadData$12.J$0 = startTimestamp;
                        offlineCompletedPageStateMachine$loadData$12.J$1 = startTimestamp2;
                        offlineCompletedPageStateMachine$loadData$12.J$2 = loadedTimestamp3222;
                        offlineCompletedPageStateMachine$loadData$12.label = 3;
                        completedCards = OfflineCacheCardModelKt.completedCards(videos, areEqual222, historyCache222, offlineCompletedPageStateMachine$loadData$12);
                        if (completedCards == coroutine_suspended) {
                        }
                        break;
                    case 3:
                        loadedTimestamp2 = offlineCompletedPageStateMachine$loadData$12.J$2;
                        startTimestamp2 = offlineCompletedPageStateMachine$loadData$12.J$1;
                        queryId2 = offlineCompletedPageStateMachine$loadData$12.J$0;
                        videos = (List) offlineCompletedPageStateMachine$loadData$12.L$1;
                        state2 = (State) offlineCompletedPageStateMachine$loadData$12.L$0;
                        ResultKt.throwOnFailure($result);
                        completedCards = $result;
                        videos2 = (List) completedCards;
                        updateHistoryProgress = new OfflineListAction.UpdateHistoryProgress(videos2);
                        offlineCompletedPageStateMachine$loadData$12.L$0 = state2;
                        offlineCompletedPageStateMachine$loadData$12.L$1 = videos;
                        offlineCompletedPageStateMachine$loadData$12.L$2 = videos2;
                        offlineCompletedPageStateMachine$loadData$12.J$0 = queryId2;
                        offlineCompletedPageStateMachine$loadData$12.J$1 = startTimestamp2;
                        offlineCompletedPageStateMachine$loadData$12.J$2 = loadedTimestamp2;
                        offlineCompletedPageStateMachine$loadData$12.label = 4;
                        if (dispatch(updateHistoryProgress, offlineCompletedPageStateMachine$loadData$12) == coroutine_suspended) {
                        }
                        getStorageInfo = OfflineListAction.GetStorageInfo.INSTANCE;
                        offlineCompletedPageStateMachine$loadData$12.L$0 = state2;
                        offlineCompletedPageStateMachine$loadData$12.L$1 = videos;
                        offlineCompletedPageStateMachine$loadData$12.L$2 = videos2;
                        offlineCompletedPageStateMachine$loadData$12.J$0 = queryId2;
                        offlineCompletedPageStateMachine$loadData$12.J$1 = startTimestamp2;
                        offlineCompletedPageStateMachine$loadData$12.J$2 = loadedTimestamp2;
                        offlineCompletedPageStateMachine$loadData$12.label = 5;
                        if (dispatch(getStorageInfo, offlineCompletedPageStateMachine$loadData$12) != coroutine_suspended) {
                        }
                        break;
                    case 4:
                        loadedTimestamp2 = offlineCompletedPageStateMachine$loadData$12.J$2;
                        startTimestamp2 = offlineCompletedPageStateMachine$loadData$12.J$1;
                        queryId2 = offlineCompletedPageStateMachine$loadData$12.J$0;
                        List completed2 = (List) offlineCompletedPageStateMachine$loadData$12.L$2;
                        List videos3 = (List) offlineCompletedPageStateMachine$loadData$12.L$1;
                        state2 = (State) offlineCompletedPageStateMachine$loadData$12.L$0;
                        ResultKt.throwOnFailure($result);
                        videos2 = completed2;
                        videos = videos3;
                        getStorageInfo = OfflineListAction.GetStorageInfo.INSTANCE;
                        offlineCompletedPageStateMachine$loadData$12.L$0 = state2;
                        offlineCompletedPageStateMachine$loadData$12.L$1 = videos;
                        offlineCompletedPageStateMachine$loadData$12.L$2 = videos2;
                        offlineCompletedPageStateMachine$loadData$12.J$0 = queryId2;
                        offlineCompletedPageStateMachine$loadData$12.J$1 = startTimestamp2;
                        offlineCompletedPageStateMachine$loadData$12.J$2 = loadedTimestamp2;
                        offlineCompletedPageStateMachine$loadData$12.label = 5;
                        if (dispatch(getStorageInfo, offlineCompletedPageStateMachine$loadData$12) != coroutine_suspended) {
                        }
                        break;
                    case 5:
                        loadedTimestamp2 = offlineCompletedPageStateMachine$loadData$12.J$2;
                        startTimestamp2 = offlineCompletedPageStateMachine$loadData$12.J$1;
                        long j6 = offlineCompletedPageStateMachine$loadData$12.J$0;
                        completed = (List) offlineCompletedPageStateMachine$loadData$12.L$2;
                        videos = (List) offlineCompletedPageStateMachine$loadData$12.L$1;
                        state2 = (State) offlineCompletedPageStateMachine$loadData$12.L$0;
                        ResultKt.throwOnFailure($result);
                        long finishTimestamp2 = DateKt.getCurrentTimeMillis();
                        long j32 = loadedTimestamp2 - startTimestamp2;
                        long startTimestamp32 = finishTimestamp2 - loadedTimestamp2;
                        LogKt.getVBLog().info("OfflineCompletedPageStateMachine loadData size: " + videos.size() + ", load cost: " + j32 + " ms, process cost: " + startTimestamp32 + " ms");
                        return state2.mutate(new Function1() { // from class: video.biz.offline.list.logic.statemachine.OfflineCompletedPageStateMachine$$ExternalSyntheticLambda8
                            public final Object invoke(Object obj) {
                                OfflinePageState loadData$lambda$0;
                                loadData$lambda$0 = OfflineCompletedPageStateMachine.loadData$lambda$0(completed, this, (OfflinePageState) obj);
                                return loadData$lambda$0;
                            }
                        });
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        offlineCompletedPageStateMachine$loadData$1 = new OfflineCompletedPageStateMachine$loadData$1(this, continuation);
        offlineCompletedPageStateMachine$loadData$12 = offlineCompletedPageStateMachine$loadData$1;
        Object $result2 = offlineCompletedPageStateMachine$loadData$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (offlineCompletedPageStateMachine$loadData$12.label) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OfflinePageState loadData$lambda$0(List $completed, OfflineCompletedPageStateMachine this$0, OfflinePageState $this$mutate) {
        OfflinePageState copy;
        Intrinsics.checkNotNullParameter($this$mutate, "$this$mutate");
        copy = $this$mutate.copy((r18 & 1) != 0 ? $this$mutate.downloading : null, (r18 & 2) != 0 ? $this$mutate.completed : $completed, (r18 & 4) != 0 ? $this$mutate.dataState : DataState.READY, (r18 & 8) != 0 ? $this$mutate.selectionState : null, (r18 & 16) != 0 ? $this$mutate.config : this$0.updateConfig($this$mutate, $completed.isEmpty()), (r18 & 32) != 0 ? $this$mutate.storageInfo : null, (r18 & 64) != 0 ? $this$mutate.reserveInfo : null, (r18 & 128) != 0 ? $this$mutate.dialogType : null);
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
        final Set result;
        Object obj;
        SelectionState selectionState = ((OfflinePageState) state.getSnapshot()).getSelectionState();
        if (Intrinsics.areEqual(selectionState, SelectionState.Inactive.INSTANCE)) {
            LogKt.getVBLog().info("click item: " + action.getKey());
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
            boolean z = false;
            if (item.getChildCount() > 1) {
                Function3<String, String, String, Boolean> function3 = this.downloadedInterceptor;
                if (function3 != null && ((Boolean) function3.invoke(item.getId(), item.getTitle(), QueryType.VIDEO.getValue())).booleanValue()) {
                    z = true;
                }
                if (!z) {
                    this.router.launch(UrisKt.toUri("bilibili://offline/cache/completed?type=video&id=" + item.getId() + "&title=" + item.getEncodedTitle() + "&keyword=" + this.keyword));
                }
            } else {
                final OfflineVideoEntity it2 = item.getEntity();
                if (it2 != null) {
                    final AuthCode authCode = AuthCodeKt.toAuthCode(it2.getAuthCode());
                    if (ArraysKt.contains(AuthCodeKt.getForbiddenAuthCodeArray(), authCode)) {
                        return state.mutate(new Function1() { // from class: video.biz.offline.list.logic.statemachine.OfflineCompletedPageStateMachine$$ExternalSyntheticLambda4
                            public final Object invoke(Object obj2) {
                                OfflinePageState handleClick$lambda$1$0;
                                handleClick$lambda$1$0 = OfflineCompletedPageStateMachine.handleClick$lambda$1$0(AuthCode.this, it2, (OfflinePageState) obj2);
                                return handleClick$lambda$1$0;
                            }
                        });
                    }
                    this.router.launch(UtilsKt.plRoute(it2, false));
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
            return state.mutate(new Function1() { // from class: video.biz.offline.list.logic.statemachine.OfflineCompletedPageStateMachine$$ExternalSyntheticLambda5
                public final Object invoke(Object obj2) {
                    OfflinePageState handleClick$lambda$2;
                    handleClick$lambda$2 = OfflineCompletedPageStateMachine.handleClick$lambda$2(result, (OfflinePageState) obj2);
                    return handleClick$lambda$2;
                }
            });
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OfflinePageState handleClick$lambda$1$0(AuthCode $authCode, OfflineVideoEntity $it, OfflinePageState $this$mutate) {
        OfflinePageState copy;
        Intrinsics.checkNotNullParameter($this$mutate, "$this$mutate");
        copy = $this$mutate.copy((r18 & 1) != 0 ? $this$mutate.downloading : null, (r18 & 2) != 0 ? $this$mutate.completed : null, (r18 & 4) != 0 ? $this$mutate.dataState : null, (r18 & 8) != 0 ? $this$mutate.selectionState : null, (r18 & 16) != 0 ? $this$mutate.config : null, (r18 & 32) != 0 ? $this$mutate.storageInfo : null, (r18 & 64) != 0 ? $this$mutate.reserveInfo : null, (r18 & 128) != 0 ? $this$mutate.dialogType : OfflinePageStateKt.dialogType($authCode, $it.getAid()));
        return copy;
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
        return state.mutate(new Function1() { // from class: video.biz.offline.list.logic.statemachine.OfflineCompletedPageStateMachine$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                OfflinePageState handleSelectAll$lambda$0;
                handleSelectAll$lambda$0 = OfflineCompletedPageStateMachine.handleSelectAll$lambda$0(state, (OfflinePageState) obj);
                return handleSelectAll$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OfflinePageState handleSelectAll$lambda$0(State $state, OfflinePageState $this$mutate) {
        OfflinePageState copy;
        OfflinePageState copy2;
        Intrinsics.checkNotNullParameter($this$mutate, "$this$mutate");
        if (((OfflinePageState) $state.getSnapshot()).selected().size() != ((OfflinePageState) $state.getSnapshot()).getCompleted().size()) {
            Iterable $this$map$iv = $this$mutate.getCompleted();
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                OfflineCachedCardModel it = (OfflineCachedCardModel) item$iv$iv;
                destination$iv$iv.add(it.getId());
            }
            copy = $this$mutate.copy((r18 & 1) != 0 ? $this$mutate.downloading : null, (r18 & 2) != 0 ? $this$mutate.completed : null, (r18 & 4) != 0 ? $this$mutate.dataState : null, (r18 & 8) != 0 ? $this$mutate.selectionState : new SelectionState.Active(CollectionsKt.toSet((List) destination$iv$iv)), (r18 & 16) != 0 ? $this$mutate.config : null, (r18 & 32) != 0 ? $this$mutate.storageInfo : null, (r18 & 64) != 0 ? $this$mutate.reserveInfo : null, (r18 & 128) != 0 ? $this$mutate.dialogType : null);
            return copy;
        }
        copy2 = $this$mutate.copy((r18 & 1) != 0 ? $this$mutate.downloading : null, (r18 & 2) != 0 ? $this$mutate.completed : null, (r18 & 4) != 0 ? $this$mutate.dataState : null, (r18 & 8) != 0 ? $this$mutate.selectionState : new SelectionState.Active(null, 1, null), (r18 & 16) != 0 ? $this$mutate.config : null, (r18 & 32) != 0 ? $this$mutate.storageInfo : null, (r18 & 64) != 0 ? $this$mutate.reserveInfo : null, (r18 & 128) != 0 ? $this$mutate.dialogType : null);
        return copy2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00c2 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00c3  */
    @Override // video.biz.offline.list.logic.statemachine.OfflineBaseListStateMachine
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object onHistoryUpdated(State<OfflinePageState> state, Continuation<? super ChangedState<OfflinePageState>> continuation) {
        OfflineCompletedPageStateMachine$onHistoryUpdated$1 offlineCompletedPageStateMachine$onHistoryUpdated$1;
        long queryId;
        Object videosByVideoId;
        Object videosByGroupId;
        List videos;
        Object completedCards;
        try {
            if (continuation instanceof OfflineCompletedPageStateMachine$onHistoryUpdated$1) {
                offlineCompletedPageStateMachine$onHistoryUpdated$1 = (OfflineCompletedPageStateMachine$onHistoryUpdated$1) continuation;
                if ((offlineCompletedPageStateMachine$onHistoryUpdated$1.label & Integer.MIN_VALUE) != 0) {
                    offlineCompletedPageStateMachine$onHistoryUpdated$1.label -= Integer.MIN_VALUE;
                    Object $result = offlineCompletedPageStateMachine$onHistoryUpdated$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (offlineCompletedPageStateMachine$onHistoryUpdated$1.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            queryId = VBStriingExtKt.toLongOrZero(this.id);
                            switch (WhenMappings.$EnumSwitchMapping$0[QueryType.Companion.enumOf(this.type).ordinal()]) {
                                case 1:
                                    IOfflineFacade offlineFacadeImpl = OfflineFacadeImpl_androidKt.getOfflineFacadeImpl();
                                    String str = this.keyword;
                                    offlineCompletedPageStateMachine$onHistoryUpdated$1.L$0 = state;
                                    offlineCompletedPageStateMachine$onHistoryUpdated$1.J$0 = queryId;
                                    offlineCompletedPageStateMachine$onHistoryUpdated$1.label = 1;
                                    videosByVideoId = offlineFacadeImpl.getVideosByVideoId(queryId, str, offlineCompletedPageStateMachine$onHistoryUpdated$1);
                                    if (videosByVideoId == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    videos = (List) videosByVideoId;
                                    boolean areEqual = Intrinsics.areEqual(this.type, "group");
                                    Map<Long, Duration> historyCache = getHistoryCache();
                                    offlineCompletedPageStateMachine$onHistoryUpdated$1.L$0 = state;
                                    offlineCompletedPageStateMachine$onHistoryUpdated$1.L$1 = SpillingKt.nullOutSpilledVariable(videos);
                                    offlineCompletedPageStateMachine$onHistoryUpdated$1.J$0 = queryId;
                                    offlineCompletedPageStateMachine$onHistoryUpdated$1.label = 3;
                                    completedCards = OfflineCacheCardModelKt.completedCards(videos, areEqual, historyCache, offlineCompletedPageStateMachine$onHistoryUpdated$1);
                                    if (completedCards == coroutine_suspended) {
                                        break;
                                    } else {
                                        return coroutine_suspended;
                                    }
                                case 2:
                                    IOfflineFacade offlineFacadeImpl2 = OfflineFacadeImpl_androidKt.getOfflineFacadeImpl();
                                    String str2 = this.keyword;
                                    offlineCompletedPageStateMachine$onHistoryUpdated$1.L$0 = state;
                                    offlineCompletedPageStateMachine$onHistoryUpdated$1.J$0 = queryId;
                                    offlineCompletedPageStateMachine$onHistoryUpdated$1.label = 2;
                                    videosByGroupId = offlineFacadeImpl2.getVideosByGroupId(queryId, str2, offlineCompletedPageStateMachine$onHistoryUpdated$1);
                                    if (videosByGroupId == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    videos = (List) videosByGroupId;
                                    boolean areEqual2 = Intrinsics.areEqual(this.type, "group");
                                    Map<Long, Duration> historyCache2 = getHistoryCache();
                                    offlineCompletedPageStateMachine$onHistoryUpdated$1.L$0 = state;
                                    offlineCompletedPageStateMachine$onHistoryUpdated$1.L$1 = SpillingKt.nullOutSpilledVariable(videos);
                                    offlineCompletedPageStateMachine$onHistoryUpdated$1.J$0 = queryId;
                                    offlineCompletedPageStateMachine$onHistoryUpdated$1.label = 3;
                                    completedCards = OfflineCacheCardModelKt.completedCards(videos, areEqual2, historyCache2, offlineCompletedPageStateMachine$onHistoryUpdated$1);
                                    if (completedCards == coroutine_suspended) {
                                    }
                                    break;
                                default:
                                    throw new NoWhenBranchMatchedException();
                            }
                        case 1:
                            queryId = offlineCompletedPageStateMachine$onHistoryUpdated$1.J$0;
                            state = (State) offlineCompletedPageStateMachine$onHistoryUpdated$1.L$0;
                            ResultKt.throwOnFailure($result);
                            videosByVideoId = $result;
                            videos = (List) videosByVideoId;
                            boolean areEqual22 = Intrinsics.areEqual(this.type, "group");
                            Map<Long, Duration> historyCache22 = getHistoryCache();
                            offlineCompletedPageStateMachine$onHistoryUpdated$1.L$0 = state;
                            offlineCompletedPageStateMachine$onHistoryUpdated$1.L$1 = SpillingKt.nullOutSpilledVariable(videos);
                            offlineCompletedPageStateMachine$onHistoryUpdated$1.J$0 = queryId;
                            offlineCompletedPageStateMachine$onHistoryUpdated$1.label = 3;
                            completedCards = OfflineCacheCardModelKt.completedCards(videos, areEqual22, historyCache22, offlineCompletedPageStateMachine$onHistoryUpdated$1);
                            if (completedCards == coroutine_suspended) {
                            }
                            break;
                        case 2:
                            queryId = offlineCompletedPageStateMachine$onHistoryUpdated$1.J$0;
                            state = (State) offlineCompletedPageStateMachine$onHistoryUpdated$1.L$0;
                            ResultKt.throwOnFailure($result);
                            videosByGroupId = $result;
                            videos = (List) videosByGroupId;
                            boolean areEqual222 = Intrinsics.areEqual(this.type, "group");
                            Map<Long, Duration> historyCache222 = getHistoryCache();
                            offlineCompletedPageStateMachine$onHistoryUpdated$1.L$0 = state;
                            offlineCompletedPageStateMachine$onHistoryUpdated$1.L$1 = SpillingKt.nullOutSpilledVariable(videos);
                            offlineCompletedPageStateMachine$onHistoryUpdated$1.J$0 = queryId;
                            offlineCompletedPageStateMachine$onHistoryUpdated$1.label = 3;
                            completedCards = OfflineCacheCardModelKt.completedCards(videos, areEqual222, historyCache222, offlineCompletedPageStateMachine$onHistoryUpdated$1);
                            if (completedCards == coroutine_suspended) {
                            }
                            break;
                        case 3:
                            long j = offlineCompletedPageStateMachine$onHistoryUpdated$1.J$0;
                            List list = (List) offlineCompletedPageStateMachine$onHistoryUpdated$1.L$1;
                            state = (State) offlineCompletedPageStateMachine$onHistoryUpdated$1.L$0;
                            ResultKt.throwOnFailure($result);
                            completedCards = $result;
                            break;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    final List completed = (List) completedCards;
                    return state.mutate(new Function1() { // from class: video.biz.offline.list.logic.statemachine.OfflineCompletedPageStateMachine$$ExternalSyntheticLambda6
                        public final Object invoke(Object obj) {
                            OfflinePageState onHistoryUpdated$lambda$0;
                            onHistoryUpdated$lambda$0 = OfflineCompletedPageStateMachine.onHistoryUpdated$lambda$0(completed, this, (OfflinePageState) obj);
                            return onHistoryUpdated$lambda$0;
                        }
                    });
                }
            }
            switch (offlineCompletedPageStateMachine$onHistoryUpdated$1.label) {
            }
            final List completed2 = (List) completedCards;
            return state.mutate(new Function1() { // from class: video.biz.offline.list.logic.statemachine.OfflineCompletedPageStateMachine$$ExternalSyntheticLambda6
                public final Object invoke(Object obj) {
                    OfflinePageState onHistoryUpdated$lambda$0;
                    onHistoryUpdated$lambda$0 = OfflineCompletedPageStateMachine.onHistoryUpdated$lambda$0(completed2, this, (OfflinePageState) obj);
                    return onHistoryUpdated$lambda$0;
                }
            });
        } catch (CancellationException cancellation) {
            throw cancellation;
        } catch (Exception e) {
            LogKt.getVBLog().error("onHistoryUpdated error: " + e);
            return state.override(new Function1() { // from class: video.biz.offline.list.logic.statemachine.OfflineCompletedPageStateMachine$$ExternalSyntheticLambda7
                public final Object invoke(Object obj) {
                    OfflinePageState onHistoryUpdated$lambda$1;
                    onHistoryUpdated$lambda$1 = OfflineCompletedPageStateMachine.onHistoryUpdated$lambda$1((OfflinePageState) obj);
                    return onHistoryUpdated$lambda$1;
                }
            });
        }
        offlineCompletedPageStateMachine$onHistoryUpdated$1 = new OfflineCompletedPageStateMachine$onHistoryUpdated$1(this, continuation);
        Object $result2 = offlineCompletedPageStateMachine$onHistoryUpdated$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OfflinePageState onHistoryUpdated$lambda$0(List $completed, OfflineCompletedPageStateMachine this$0, OfflinePageState $this$mutate) {
        OfflinePageState copy;
        Intrinsics.checkNotNullParameter($this$mutate, "$this$mutate");
        copy = $this$mutate.copy((r18 & 1) != 0 ? $this$mutate.downloading : null, (r18 & 2) != 0 ? $this$mutate.completed : $completed, (r18 & 4) != 0 ? $this$mutate.dataState : DataState.READY, (r18 & 8) != 0 ? $this$mutate.selectionState : null, (r18 & 16) != 0 ? $this$mutate.config : this$0.updateConfig($this$mutate, $completed.isEmpty()), (r18 & 32) != 0 ? $this$mutate.storageInfo : null, (r18 & 64) != 0 ? $this$mutate.reserveInfo : null, (r18 & 128) != 0 ? $this$mutate.dialogType : null);
        return copy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OfflinePageState onHistoryUpdated$lambda$1(OfflinePageState $this$override) {
        Intrinsics.checkNotNullParameter($this$override, "$this$override");
        return OfflinePageStateKt.getOfflinePageErrorState();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final OfflinePageConfig updateConfig(OfflinePageState $this$updateConfig, boolean isEmpty) {
        OfflinePageConfig config = $this$updateConfig.getConfig();
        List listOf = CollectionsKt.listOf(OfflinePageOperation.EDIT_ICON);
        if (isEmpty) {
            listOf = null;
        }
        if (listOf == null) {
            listOf = CollectionsKt.emptyList();
        }
        return OfflinePageConfig.copy$default(config, listOf, null, 0, 6, null);
    }
}