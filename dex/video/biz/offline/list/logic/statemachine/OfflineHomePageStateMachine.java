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
import java.util.LinkedHashMap;
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
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.time.Duration;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.base.log.LogKt;
import video.base.utils.DateKt;
import video.biz.offline.base.facade.IOfflineFacade;
import video.biz.offline.base.facade.OfflineFacadeImpl_androidKt;
import video.biz.offline.base.infra.utils.OfflineLog;
import video.biz.offline.base.infra.utils.OfflineScopeKt;
import video.biz.offline.base.model.entity.OfflineAuthUpdate;
import video.biz.offline.base.model.entity.OfflineVideoEntity;
import video.biz.offline.base.model.model.AuthCode;
import video.biz.offline.base.model.model.AuthCodeKt;
import video.biz.offline.list.logic.ReserveInfoImpl_androidKt;
import video.biz.offline.list.logic.SupportedOptions_androidKt;
import video.biz.offline.list.logic.model.AvAuthResult;
import video.biz.offline.list.logic.model.DataState;
import video.biz.offline.list.logic.model.EpAuthItem;
import video.biz.offline.list.logic.model.OfflineCacheCardModelKt;
import video.biz.offline.list.logic.model.OfflineCachedCardModel;
import video.biz.offline.list.logic.model.OfflinePageConfig;
import video.biz.offline.list.logic.model.OfflinePageState;
import video.biz.offline.list.logic.model.OfflinePageStateKt;
import video.biz.offline.list.logic.model.SelectionState;
import video.biz.offline.list.logic.statemachine.OfflineListAction;
import video.biz.offline.list.logic.utils.EpisodeParam;
import video.biz.offline.list.logic.utils.OfflineAuthApiKt;
import video.biz.offline.list.logic.utils.UtilsKt;

/* compiled from: OfflineHomePageStateMachine.kt */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001Ba\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\u0004\u0018\u0001`\u000b\u0012(\b\u0002\u0010\f\u001a\"\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\n\u0018\u00010\rj\u0004\u0018\u0001`\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\u001e\u0010\u0015\u001a\u00020\u0016*\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00180\u0017H\u0014J\"\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00030\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00030\u001cH\u0094@¢\u0006\u0002\u0010\u001dJ*\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00030\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00030\u001c2\u0006\u0010\u001f\u001a\u00020 H\u0094@¢\u0006\u0002\u0010!J\u001c\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00030\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00030\u001cH\u0014J\"\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00030\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00030\u001cH\u0094@¢\u0006\u0002\u0010\u001dJ\b\u0010$\u001a\u00020\u0016H\u0016J\u0014\u0010%\u001a\u00020&*\u00020\u00032\u0006\u0010'\u001a\u00020\nH\u0002J\u000e\u0010(\u001a\u00020\u0016H\u0082@¢\u0006\u0002\u0010)R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\u0004\u0018\u0001`\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R.\u0010\f\u001a\"\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\n\u0018\u00010\rj\u0004\u0018\u0001`\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lvideo/biz/offline/list/logic/statemachine/OfflineHomePageStateMachine;", "Lvideo/biz/offline/list/logic/statemachine/OfflineBaseListStateMachine;", "initialState", "Lvideo/biz/offline/list/logic/model/OfflinePageState;", "router", "Lkntr/base/router/Router;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "downloadingInterceptor", "Lkotlin/Function0;", "", "Lvideo/biz/offline/list/logic/statemachine/OfflineDownloadingRouteInterceptor;", "downloadedInterceptor", "Lkotlin/Function3;", "", "Lvideo/biz/offline/list/logic/statemachine/OfflineDownloadedRouteInterceptor;", "<init>", "(Lvideo/biz/offline/list/logic/model/OfflinePageState;Lkntr/base/router/Router;Lkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function3;)V", "didTrackFirstLoad", "authJob", "Lkotlinx/coroutines/Job;", "childSpec", "", "Lcom/freeletics/flowredux/dsl/InStateBuilderBlock;", "Lvideo/biz/offline/list/logic/statemachine/OfflineListAction;", "loadData", "Lcom/freeletics/flowredux/dsl/ChangedState;", "state", "Lcom/freeletics/flowredux/dsl/State;", "(Lcom/freeletics/flowredux/dsl/State;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleClick", "action", "Lvideo/biz/offline/list/logic/statemachine/OfflineListAction$ItemClick;", "(Lcom/freeletics/flowredux/dsl/State;Lvideo/biz/offline/list/logic/statemachine/OfflineListAction$ItemClick;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleSelectAll", "onHistoryUpdated", "dispose", "updateConfig", "Lvideo/biz/offline/list/logic/model/OfflinePageConfig;", "isEmpty", "handleAuth", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class OfflineHomePageStateMachine extends OfflineBaseListStateMachine {
    public static final int $stable = 8;
    private Job authJob;
    private boolean didTrackFirstLoad;
    private final Function3<String, String, String, Boolean> downloadedInterceptor;
    private final Function0<Boolean> downloadingInterceptor;
    private final Router router;
    private final CoroutineScope scope;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public OfflineHomePageStateMachine(OfflinePageState initialState, Router router, CoroutineScope scope, Function0<Boolean> function0, Function3<? super String, ? super String, ? super String, Boolean> function3) {
        super(initialState, scope, router);
        Intrinsics.checkNotNullParameter(initialState, "initialState");
        Intrinsics.checkNotNullParameter(router, "router");
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.router = router;
        this.scope = scope;
        this.downloadingInterceptor = function0;
        this.downloadedInterceptor = function3;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ OfflineHomePageStateMachine(OfflinePageState offlinePageState, Router router, CoroutineScope coroutineScope, Function0 function0, Function3 function3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(offlinePageState, router, coroutineScope, r5, r6);
        Function0 function02;
        Function3 function32;
        if ((i & 8) == 0) {
            function02 = function0;
        } else {
            function02 = null;
        }
        if ((i & 16) == 0) {
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
        inStateBuilderBlock.condition(new Function1() { // from class: video.biz.offline.list.logic.statemachine.OfflineHomePageStateMachine$$ExternalSyntheticLambda4
            public final Object invoke(Object obj) {
                boolean childSpec$lambda$0;
                childSpec$lambda$0 = OfflineHomePageStateMachine.childSpec$lambda$0((OfflinePageState) obj);
                return Boolean.valueOf(childSpec$lambda$0);
            }
        }, new Function1() { // from class: video.biz.offline.list.logic.statemachine.OfflineHomePageStateMachine$$ExternalSyntheticLambda5
            public final Object invoke(Object obj) {
                Unit childSpec$lambda$1;
                childSpec$lambda$1 = OfflineHomePageStateMachine.childSpec$lambda$1(OfflineHomePageStateMachine.this, (ConditionBuilderBlock) obj);
                return childSpec$lambda$1;
            }
        });
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) inStateBuilderBlock;
        Function3 handler$iv = new OfflineHomePageStateMachine$childSpec$3(this, null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(ClickSearch.class), executionPolicy$iv, handler$iv);
        BaseBuilderBlock $this$iv2 = (BaseBuilderBlock) inStateBuilderBlock;
        Function3 handler$iv2 = new OfflineHomePageStateMachine$childSpec$4(this, null);
        ExecutionPolicy executionPolicy$iv2 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv2.on(Reflection.getOrCreateKotlinClass(ClickSetting.class), executionPolicy$iv2, handler$iv2);
        BaseBuilderBlock $this$iv3 = (BaseBuilderBlock) inStateBuilderBlock;
        Function3 handler$iv3 = new OfflineHomePageStateMachine$childSpec$5(this, null);
        ExecutionPolicy executionPolicy$iv3 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv3.on(Reflection.getOrCreateKotlinClass(ClickDownloading.class), executionPolicy$iv3, handler$iv3);
        BaseBuilderBlock $this$iv4 = (BaseBuilderBlock) inStateBuilderBlock;
        Function3 handler$iv4 = new OfflineHomePageStateMachine$childSpec$6(this, null);
        ExecutionPolicy executionPolicy$iv4 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv4.on(Reflection.getOrCreateKotlinClass(ClickContinuousPlay.class), executionPolicy$iv4, handler$iv4);
        BaseBuilderBlock $this$iv5 = (BaseBuilderBlock) inStateBuilderBlock;
        Function3 handler$iv5 = new OfflineHomePageStateMachine$childSpec$7(null);
        ExecutionPolicy executionPolicy$iv5 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv5.on(Reflection.getOrCreateKotlinClass(OfflineListAction.Delete.class), executionPolicy$iv5, handler$iv5);
        BaseBuilderBlock $this$iv6 = (BaseBuilderBlock) inStateBuilderBlock;
        Function3 handler$iv6 = new OfflineHomePageStateMachine$childSpec$8(this, null);
        ExecutionPolicy executionPolicy$iv6 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv6.on(Reflection.getOrCreateKotlinClass(OfflineListAction.DeleteConfirmed.class), executionPolicy$iv6, handler$iv6);
        BaseBuilderBlock $this$iv7 = (BaseBuilderBlock) inStateBuilderBlock;
        Function3 handler$iv7 = new OfflineHomePageStateMachine$childSpec$9(this, null);
        ExecutionPolicy executionPolicy$iv7 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv7.on(Reflection.getOrCreateKotlinClass(StartAuthentication.class), executionPolicy$iv7, handler$iv7);
        BaseBuilderBlock $this$iv8 = (BaseBuilderBlock) inStateBuilderBlock;
        Function3 handler$iv8 = new OfflineHomePageStateMachine$childSpec$10(this, null);
        ExecutionPolicy executionPolicy$iv8 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv8.on(Reflection.getOrCreateKotlinClass(ClickReserve.class), executionPolicy$iv8, handler$iv8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit childSpec$lambda$1(OfflineHomePageStateMachine this$0, ConditionBuilderBlock $this$condition) {
        Intrinsics.checkNotNullParameter($this$condition, "$this$condition");
        BaseBuilderBlock.collectWhileInState$default((BaseBuilderBlock) $this$condition, new Function1() { // from class: video.biz.offline.list.logic.statemachine.OfflineHomePageStateMachine$$ExternalSyntheticLambda8
            public final Object invoke(Object obj) {
                Flow childSpec$lambda$1$0;
                childSpec$lambda$1$0 = OfflineHomePageStateMachine.childSpec$lambda$1$0((OfflinePageState) obj);
                return childSpec$lambda$1$0;
            }
        }, (ExecutionPolicy) null, new OfflineHomePageStateMachine$childSpec$2$2(this$0, null), 2, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Flow childSpec$lambda$1$0(OfflinePageState it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return OfflineFacadeImpl_androidKt.getOfflineFacadeImpl().getAllVideosFlow();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't wrap try/catch for region: R(7:1|(2:3|(4:5|6|7|8))|101|6|7|8|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0099, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x009a, code lost:
        r10 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00a0, code lost:
        r10 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00c0, code lost:
        r0 = th;
     */
    /* JADX WARN: Not initialized variable reg: 11, insn: 0x009c: MOVE  (r10 I:??[OBJECT, ARRAY]) = (r11 I:??[OBJECT, ARRAY] A[D('state' com.freeletics.flowredux.dsl.State)]), block:B:24:0x009a */
    /* JADX WARN: Not initialized variable reg: 11, insn: 0x00a2: MOVE  (r10 I:??[OBJECT, ARRAY]) = (r11 I:??[OBJECT, ARRAY] A[D('state' com.freeletics.flowredux.dsl.State)]), block:B:26:0x00a0 */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00fa A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0113 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x012c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x013e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x017d A[Catch: Exception -> 0x01bc, all -> 0x01fa, TryCatch #2 {Exception -> 0x01bc, blocks: (B:58:0x0151, B:60:0x017d, B:61:0x0199), top: B:92:0x0151 }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01b8 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01f8 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0212 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0213  */
    @Override // video.biz.offline.list.logic.statemachine.OfflineBaseListStateMachine
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object loadData(State<OfflinePageState> state, Continuation<? super ChangedState<OfflinePageState>> continuation) {
        OfflineHomePageStateMachine$loadData$1 offlineHomePageStateMachine$loadData$1;
        OfflineHomePageStateMachine$loadData$1 offlineHomePageStateMachine$loadData$12;
        State<OfflinePageState> state2;
        StartAuthentication startAuthentication;
        ChangedState override;
        StartAuthentication startAuthentication2;
        long startTime;
        Object allVideos;
        List videos;
        Object completedGroups;
        List completed;
        OfflineListAction.UpdateHistoryProgress updateHistoryProgress;
        List videos2;
        final List completed2;
        OfflineListAction.GetStorageInfo getStorageInfo;
        Object downloadingCards;
        long duration;
        StartAuthentication startAuthentication3;
        if (continuation instanceof OfflineHomePageStateMachine$loadData$1) {
            offlineHomePageStateMachine$loadData$1 = (OfflineHomePageStateMachine$loadData$1) continuation;
            if ((offlineHomePageStateMachine$loadData$1.label & Integer.MIN_VALUE) != 0) {
                offlineHomePageStateMachine$loadData$1.label -= Integer.MIN_VALUE;
                offlineHomePageStateMachine$loadData$12 = offlineHomePageStateMachine$loadData$1;
                Object $result = offlineHomePageStateMachine$loadData$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (offlineHomePageStateMachine$loadData$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        try {
                            startTime = DateKt.getCurrentTimeMillis();
                            IOfflineFacade offlineFacadeImpl = OfflineFacadeImpl_androidKt.getOfflineFacadeImpl();
                            state2 = state;
                            try {
                                offlineHomePageStateMachine$loadData$12.L$0 = state2;
                                offlineHomePageStateMachine$loadData$12.J$0 = startTime;
                                offlineHomePageStateMachine$loadData$12.label = 1;
                                allVideos = offlineFacadeImpl.getAllVideos(offlineHomePageStateMachine$loadData$12);
                                if (allVideos == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            } catch (Exception e) {
                                override = state2.override(new Function1() { // from class: video.biz.offline.list.logic.statemachine.OfflineHomePageStateMachine$$ExternalSyntheticLambda7
                                    public final Object invoke(Object obj) {
                                        OfflinePageState loadData$lambda$1;
                                        loadData$lambda$1 = OfflineHomePageStateMachine.loadData$lambda$1((OfflinePageState) obj);
                                        return loadData$lambda$1;
                                    }
                                });
                                startAuthentication2 = StartAuthentication.INSTANCE;
                                offlineHomePageStateMachine$loadData$12.L$0 = SpillingKt.nullOutSpilledVariable(state2);
                                offlineHomePageStateMachine$loadData$12.L$1 = override;
                                offlineHomePageStateMachine$loadData$12.L$2 = null;
                                offlineHomePageStateMachine$loadData$12.label = 7;
                                if (dispatch(startAuthentication2, offlineHomePageStateMachine$loadData$12) == coroutine_suspended) {
                                }
                                return override;
                            } catch (Throwable th) {
                                th = th;
                                startAuthentication = StartAuthentication.INSTANCE;
                                offlineHomePageStateMachine$loadData$12.L$0 = SpillingKt.nullOutSpilledVariable(state2);
                                offlineHomePageStateMachine$loadData$12.L$1 = th;
                                offlineHomePageStateMachine$loadData$12.L$2 = null;
                                offlineHomePageStateMachine$loadData$12.label = 8;
                                if (dispatch(startAuthentication, offlineHomePageStateMachine$loadData$12) == coroutine_suspended) {
                                }
                            }
                        } catch (Exception e2) {
                            state2 = state;
                        } catch (Throwable th2) {
                            th = th2;
                            state2 = state;
                        }
                        try {
                            videos = (List) allVideos;
                            Map<Long, Duration> historyCache = getHistoryCache();
                            offlineHomePageStateMachine$loadData$12.L$0 = state2;
                            offlineHomePageStateMachine$loadData$12.L$1 = videos;
                            offlineHomePageStateMachine$loadData$12.J$0 = startTime;
                            offlineHomePageStateMachine$loadData$12.label = 2;
                            completedGroups = OfflineCacheCardModelKt.completedGroups(videos, historyCache, offlineHomePageStateMachine$loadData$12);
                            if (completedGroups == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            completed = (List) completedGroups;
                            updateHistoryProgress = new OfflineListAction.UpdateHistoryProgress(completed);
                            offlineHomePageStateMachine$loadData$12.L$0 = state2;
                            offlineHomePageStateMachine$loadData$12.L$1 = videos;
                            offlineHomePageStateMachine$loadData$12.L$2 = completed;
                            offlineHomePageStateMachine$loadData$12.J$0 = startTime;
                            offlineHomePageStateMachine$loadData$12.label = 3;
                        } catch (Exception e3) {
                            override = state2.override(new Function1() { // from class: video.biz.offline.list.logic.statemachine.OfflineHomePageStateMachine$$ExternalSyntheticLambda7
                                public final Object invoke(Object obj) {
                                    OfflinePageState loadData$lambda$1;
                                    loadData$lambda$1 = OfflineHomePageStateMachine.loadData$lambda$1((OfflinePageState) obj);
                                    return loadData$lambda$1;
                                }
                            });
                            startAuthentication2 = StartAuthentication.INSTANCE;
                            offlineHomePageStateMachine$loadData$12.L$0 = SpillingKt.nullOutSpilledVariable(state2);
                            offlineHomePageStateMachine$loadData$12.L$1 = override;
                            offlineHomePageStateMachine$loadData$12.L$2 = null;
                            offlineHomePageStateMachine$loadData$12.label = 7;
                            if (dispatch(startAuthentication2, offlineHomePageStateMachine$loadData$12) == coroutine_suspended) {
                            }
                            return override;
                        } catch (Throwable th3) {
                            th = th3;
                            startAuthentication = StartAuthentication.INSTANCE;
                            offlineHomePageStateMachine$loadData$12.L$0 = SpillingKt.nullOutSpilledVariable(state2);
                            offlineHomePageStateMachine$loadData$12.L$1 = th;
                            offlineHomePageStateMachine$loadData$12.L$2 = null;
                            offlineHomePageStateMachine$loadData$12.label = 8;
                            if (dispatch(startAuthentication, offlineHomePageStateMachine$loadData$12) == coroutine_suspended) {
                            }
                        }
                        if (dispatch(updateHistoryProgress, offlineHomePageStateMachine$loadData$12) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        videos2 = videos;
                        completed2 = completed;
                        getStorageInfo = OfflineListAction.GetStorageInfo.INSTANCE;
                        offlineHomePageStateMachine$loadData$12.L$0 = state2;
                        offlineHomePageStateMachine$loadData$12.L$1 = videos2;
                        offlineHomePageStateMachine$loadData$12.L$2 = completed2;
                        offlineHomePageStateMachine$loadData$12.J$0 = startTime;
                        offlineHomePageStateMachine$loadData$12.label = 4;
                        if (dispatch(getStorageInfo, offlineHomePageStateMachine$loadData$12) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        offlineHomePageStateMachine$loadData$12.L$0 = state2;
                        offlineHomePageStateMachine$loadData$12.L$1 = videos2;
                        offlineHomePageStateMachine$loadData$12.L$2 = completed2;
                        offlineHomePageStateMachine$loadData$12.J$0 = startTime;
                        offlineHomePageStateMachine$loadData$12.label = 5;
                        downloadingCards = OfflineCacheCardModelKt.downloadingCards(videos2, offlineHomePageStateMachine$loadData$12);
                        if (downloadingCards == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        final List downloading = (List) downloadingCards;
                        long endTime = DateKt.getCurrentTimeMillis();
                        duration = endTime - startTime;
                        try {
                            try {
                                LogKt.getVBLog().info("Home Page loading cost: " + duration + " ms, size: " + videos2.size() + ".");
                                if (!this.didTrackFirstLoad) {
                                    BuildersKt.launch$default(OfflineScopeKt.getStorageScope(), (CoroutineContext) null, (CoroutineStart) null, new OfflineHomePageStateMachine$loadData$2(duration, videos2, null), 3, (Object) null);
                                    this.didTrackFirstLoad = true;
                                }
                                override = state2.mutate(new Function1() { // from class: video.biz.offline.list.logic.statemachine.OfflineHomePageStateMachine$$ExternalSyntheticLambda6
                                    public final Object invoke(Object obj) {
                                        OfflinePageState loadData$lambda$0;
                                        loadData$lambda$0 = OfflineHomePageStateMachine.loadData$lambda$0(downloading, completed2, this, (OfflinePageState) obj);
                                        return loadData$lambda$0;
                                    }
                                });
                                startAuthentication3 = StartAuthentication.INSTANCE;
                                offlineHomePageStateMachine$loadData$12.L$0 = SpillingKt.nullOutSpilledVariable(state2);
                                offlineHomePageStateMachine$loadData$12.L$1 = override;
                                offlineHomePageStateMachine$loadData$12.L$2 = null;
                                offlineHomePageStateMachine$loadData$12.label = 6;
                                if (dispatch(startAuthentication3, offlineHomePageStateMachine$loadData$12) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            } catch (Exception e4) {
                                override = state2.override(new Function1() { // from class: video.biz.offline.list.logic.statemachine.OfflineHomePageStateMachine$$ExternalSyntheticLambda7
                                    public final Object invoke(Object obj) {
                                        OfflinePageState loadData$lambda$1;
                                        loadData$lambda$1 = OfflineHomePageStateMachine.loadData$lambda$1((OfflinePageState) obj);
                                        return loadData$lambda$1;
                                    }
                                });
                                startAuthentication2 = StartAuthentication.INSTANCE;
                                offlineHomePageStateMachine$loadData$12.L$0 = SpillingKt.nullOutSpilledVariable(state2);
                                offlineHomePageStateMachine$loadData$12.L$1 = override;
                                offlineHomePageStateMachine$loadData$12.L$2 = null;
                                offlineHomePageStateMachine$loadData$12.label = 7;
                                if (dispatch(startAuthentication2, offlineHomePageStateMachine$loadData$12) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                return override;
                            }
                            return override;
                        } catch (Throwable th4) {
                            th = th4;
                            startAuthentication = StartAuthentication.INSTANCE;
                            offlineHomePageStateMachine$loadData$12.L$0 = SpillingKt.nullOutSpilledVariable(state2);
                            offlineHomePageStateMachine$loadData$12.L$1 = th;
                            offlineHomePageStateMachine$loadData$12.L$2 = null;
                            offlineHomePageStateMachine$loadData$12.label = 8;
                            if (dispatch(startAuthentication, offlineHomePageStateMachine$loadData$12) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            throw th;
                        }
                    case 1:
                        startTime = offlineHomePageStateMachine$loadData$12.J$0;
                        state2 = (State) offlineHomePageStateMachine$loadData$12.L$0;
                        ResultKt.throwOnFailure($result);
                        allVideos = $result;
                        videos = (List) allVideos;
                        Map<Long, Duration> historyCache2 = getHistoryCache();
                        offlineHomePageStateMachine$loadData$12.L$0 = state2;
                        offlineHomePageStateMachine$loadData$12.L$1 = videos;
                        offlineHomePageStateMachine$loadData$12.J$0 = startTime;
                        offlineHomePageStateMachine$loadData$12.label = 2;
                        completedGroups = OfflineCacheCardModelKt.completedGroups(videos, historyCache2, offlineHomePageStateMachine$loadData$12);
                        if (completedGroups == coroutine_suspended) {
                        }
                        completed = (List) completedGroups;
                        updateHistoryProgress = new OfflineListAction.UpdateHistoryProgress(completed);
                        offlineHomePageStateMachine$loadData$12.L$0 = state2;
                        offlineHomePageStateMachine$loadData$12.L$1 = videos;
                        offlineHomePageStateMachine$loadData$12.L$2 = completed;
                        offlineHomePageStateMachine$loadData$12.J$0 = startTime;
                        offlineHomePageStateMachine$loadData$12.label = 3;
                        if (dispatch(updateHistoryProgress, offlineHomePageStateMachine$loadData$12) == coroutine_suspended) {
                        }
                        break;
                    case 2:
                        startTime = offlineHomePageStateMachine$loadData$12.J$0;
                        videos = (List) offlineHomePageStateMachine$loadData$12.L$1;
                        state2 = (State) offlineHomePageStateMachine$loadData$12.L$0;
                        ResultKt.throwOnFailure($result);
                        completedGroups = $result;
                        completed = (List) completedGroups;
                        updateHistoryProgress = new OfflineListAction.UpdateHistoryProgress(completed);
                        offlineHomePageStateMachine$loadData$12.L$0 = state2;
                        offlineHomePageStateMachine$loadData$12.L$1 = videos;
                        offlineHomePageStateMachine$loadData$12.L$2 = completed;
                        offlineHomePageStateMachine$loadData$12.J$0 = startTime;
                        offlineHomePageStateMachine$loadData$12.label = 3;
                        if (dispatch(updateHistoryProgress, offlineHomePageStateMachine$loadData$12) == coroutine_suspended) {
                        }
                        break;
                    case 3:
                        startTime = offlineHomePageStateMachine$loadData$12.J$0;
                        completed2 = (List) offlineHomePageStateMachine$loadData$12.L$2;
                        List videos3 = (List) offlineHomePageStateMachine$loadData$12.L$1;
                        State<OfflinePageState> state3 = (State) offlineHomePageStateMachine$loadData$12.L$0;
                        ResultKt.throwOnFailure($result);
                        videos2 = videos3;
                        state2 = state3;
                        getStorageInfo = OfflineListAction.GetStorageInfo.INSTANCE;
                        offlineHomePageStateMachine$loadData$12.L$0 = state2;
                        offlineHomePageStateMachine$loadData$12.L$1 = videos2;
                        offlineHomePageStateMachine$loadData$12.L$2 = completed2;
                        offlineHomePageStateMachine$loadData$12.J$0 = startTime;
                        offlineHomePageStateMachine$loadData$12.label = 4;
                        if (dispatch(getStorageInfo, offlineHomePageStateMachine$loadData$12) == coroutine_suspended) {
                        }
                        offlineHomePageStateMachine$loadData$12.L$0 = state2;
                        offlineHomePageStateMachine$loadData$12.L$1 = videos2;
                        offlineHomePageStateMachine$loadData$12.L$2 = completed2;
                        offlineHomePageStateMachine$loadData$12.J$0 = startTime;
                        offlineHomePageStateMachine$loadData$12.label = 5;
                        downloadingCards = OfflineCacheCardModelKt.downloadingCards(videos2, offlineHomePageStateMachine$loadData$12);
                        if (downloadingCards == coroutine_suspended) {
                        }
                        final List downloading2 = (List) downloadingCards;
                        long endTime2 = DateKt.getCurrentTimeMillis();
                        duration = endTime2 - startTime;
                        LogKt.getVBLog().info("Home Page loading cost: " + duration + " ms, size: " + videos2.size() + ".");
                        if (!this.didTrackFirstLoad) {
                        }
                        override = state2.mutate(new Function1() { // from class: video.biz.offline.list.logic.statemachine.OfflineHomePageStateMachine$$ExternalSyntheticLambda6
                            public final Object invoke(Object obj) {
                                OfflinePageState loadData$lambda$0;
                                loadData$lambda$0 = OfflineHomePageStateMachine.loadData$lambda$0(downloading2, completed2, this, (OfflinePageState) obj);
                                return loadData$lambda$0;
                            }
                        });
                        startAuthentication3 = StartAuthentication.INSTANCE;
                        offlineHomePageStateMachine$loadData$12.L$0 = SpillingKt.nullOutSpilledVariable(state2);
                        offlineHomePageStateMachine$loadData$12.L$1 = override;
                        offlineHomePageStateMachine$loadData$12.L$2 = null;
                        offlineHomePageStateMachine$loadData$12.label = 6;
                        if (dispatch(startAuthentication3, offlineHomePageStateMachine$loadData$12) == coroutine_suspended) {
                        }
                        return override;
                    case 4:
                        startTime = offlineHomePageStateMachine$loadData$12.J$0;
                        completed2 = (List) offlineHomePageStateMachine$loadData$12.L$2;
                        List videos4 = (List) offlineHomePageStateMachine$loadData$12.L$1;
                        State<OfflinePageState> state4 = (State) offlineHomePageStateMachine$loadData$12.L$0;
                        ResultKt.throwOnFailure($result);
                        videos2 = videos4;
                        state2 = state4;
                        offlineHomePageStateMachine$loadData$12.L$0 = state2;
                        offlineHomePageStateMachine$loadData$12.L$1 = videos2;
                        offlineHomePageStateMachine$loadData$12.L$2 = completed2;
                        offlineHomePageStateMachine$loadData$12.J$0 = startTime;
                        offlineHomePageStateMachine$loadData$12.label = 5;
                        downloadingCards = OfflineCacheCardModelKt.downloadingCards(videos2, offlineHomePageStateMachine$loadData$12);
                        if (downloadingCards == coroutine_suspended) {
                        }
                        final List downloading22 = (List) downloadingCards;
                        long endTime22 = DateKt.getCurrentTimeMillis();
                        duration = endTime22 - startTime;
                        LogKt.getVBLog().info("Home Page loading cost: " + duration + " ms, size: " + videos2.size() + ".");
                        if (!this.didTrackFirstLoad) {
                        }
                        override = state2.mutate(new Function1() { // from class: video.biz.offline.list.logic.statemachine.OfflineHomePageStateMachine$$ExternalSyntheticLambda6
                            public final Object invoke(Object obj) {
                                OfflinePageState loadData$lambda$0;
                                loadData$lambda$0 = OfflineHomePageStateMachine.loadData$lambda$0(downloading22, completed2, this, (OfflinePageState) obj);
                                return loadData$lambda$0;
                            }
                        });
                        startAuthentication3 = StartAuthentication.INSTANCE;
                        offlineHomePageStateMachine$loadData$12.L$0 = SpillingKt.nullOutSpilledVariable(state2);
                        offlineHomePageStateMachine$loadData$12.L$1 = override;
                        offlineHomePageStateMachine$loadData$12.L$2 = null;
                        offlineHomePageStateMachine$loadData$12.label = 6;
                        if (dispatch(startAuthentication3, offlineHomePageStateMachine$loadData$12) == coroutine_suspended) {
                        }
                        return override;
                    case 5:
                        startTime = offlineHomePageStateMachine$loadData$12.J$0;
                        completed2 = (List) offlineHomePageStateMachine$loadData$12.L$2;
                        List videos5 = (List) offlineHomePageStateMachine$loadData$12.L$1;
                        State<OfflinePageState> state5 = (State) offlineHomePageStateMachine$loadData$12.L$0;
                        ResultKt.throwOnFailure($result);
                        downloadingCards = $result;
                        videos2 = videos5;
                        state2 = state5;
                        final List downloading222 = (List) downloadingCards;
                        long endTime222 = DateKt.getCurrentTimeMillis();
                        duration = endTime222 - startTime;
                        LogKt.getVBLog().info("Home Page loading cost: " + duration + " ms, size: " + videos2.size() + ".");
                        if (!this.didTrackFirstLoad) {
                        }
                        override = state2.mutate(new Function1() { // from class: video.biz.offline.list.logic.statemachine.OfflineHomePageStateMachine$$ExternalSyntheticLambda6
                            public final Object invoke(Object obj) {
                                OfflinePageState loadData$lambda$0;
                                loadData$lambda$0 = OfflineHomePageStateMachine.loadData$lambda$0(downloading222, completed2, this, (OfflinePageState) obj);
                                return loadData$lambda$0;
                            }
                        });
                        startAuthentication3 = StartAuthentication.INSTANCE;
                        offlineHomePageStateMachine$loadData$12.L$0 = SpillingKt.nullOutSpilledVariable(state2);
                        offlineHomePageStateMachine$loadData$12.L$1 = override;
                        offlineHomePageStateMachine$loadData$12.L$2 = null;
                        offlineHomePageStateMachine$loadData$12.label = 6;
                        if (dispatch(startAuthentication3, offlineHomePageStateMachine$loadData$12) == coroutine_suspended) {
                        }
                        return override;
                    case 6:
                    case 7:
                        ChangedState changedState = (ChangedState) offlineHomePageStateMachine$loadData$12.L$1;
                        State state6 = (State) offlineHomePageStateMachine$loadData$12.L$0;
                        ResultKt.throwOnFailure($result);
                        return changedState;
                    case 8:
                        Throwable th5 = (Throwable) offlineHomePageStateMachine$loadData$12.L$1;
                        State state7 = (State) offlineHomePageStateMachine$loadData$12.L$0;
                        ResultKt.throwOnFailure($result);
                        throw th5;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        offlineHomePageStateMachine$loadData$1 = new OfflineHomePageStateMachine$loadData$1(this, continuation);
        offlineHomePageStateMachine$loadData$12 = offlineHomePageStateMachine$loadData$1;
        Object $result2 = offlineHomePageStateMachine$loadData$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (offlineHomePageStateMachine$loadData$12.label) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OfflinePageState loadData$lambda$0(List $downloading, List $completed, OfflineHomePageStateMachine this$0, OfflinePageState $this$mutate) {
        OfflinePageState copy;
        Intrinsics.checkNotNullParameter($this$mutate, "$this$mutate");
        copy = $this$mutate.copy((r18 & 1) != 0 ? $this$mutate.downloading : $downloading, (r18 & 2) != 0 ? $this$mutate.completed : $completed, (r18 & 4) != 0 ? $this$mutate.dataState : DataState.READY, (r18 & 8) != 0 ? $this$mutate.selectionState : null, (r18 & 16) != 0 ? $this$mutate.config : this$0.updateConfig($this$mutate, $completed.isEmpty()), (r18 & 32) != 0 ? $this$mutate.storageInfo : null, (r18 & 64) != 0 ? $this$mutate.reserveInfo : ReserveInfoImpl_androidKt.getReserveInfo(), (r18 & 128) != 0 ? $this$mutate.dialogType : null);
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
                if (function3 != null && ((Boolean) function3.invoke(action.getKey(), item.getTitle(), "group")).booleanValue()) {
                    z = true;
                }
                if (!z) {
                    this.router.launch(UrisKt.toUri("bilibili://offline/cache/completed?id=" + action.getKey() + "&type=group&title=" + item.getEncodedTitle() + "&keyword="));
                }
            } else {
                final OfflineVideoEntity it2 = item.getEntity();
                if (it2 != null) {
                    final AuthCode authCode = AuthCodeKt.toAuthCode(it2.getAuthCode());
                    if (ArraysKt.contains(AuthCodeKt.getForbiddenAuthCodeArray(), authCode)) {
                        return state.mutate(new Function1() { // from class: video.biz.offline.list.logic.statemachine.OfflineHomePageStateMachine$$ExternalSyntheticLambda2
                            public final Object invoke(Object obj2) {
                                OfflinePageState handleClick$lambda$1$0;
                                handleClick$lambda$1$0 = OfflineHomePageStateMachine.handleClick$lambda$1$0(AuthCode.this, it2, (OfflinePageState) obj2);
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
            return state.mutate(new Function1() { // from class: video.biz.offline.list.logic.statemachine.OfflineHomePageStateMachine$$ExternalSyntheticLambda3
                public final Object invoke(Object obj2) {
                    OfflinePageState handleClick$lambda$2;
                    handleClick$lambda$2 = OfflineHomePageStateMachine.handleClick$lambda$2(result, (OfflinePageState) obj2);
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
        return state.mutate(new Function1() { // from class: video.biz.offline.list.logic.statemachine.OfflineHomePageStateMachine$$ExternalSyntheticLambda9
            public final Object invoke(Object obj) {
                OfflinePageState handleSelectAll$lambda$0;
                handleSelectAll$lambda$0 = OfflineHomePageStateMachine.handleSelectAll$lambda$0(state, (OfflinePageState) obj);
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
    /* JADX WARN: Removed duplicated region for block: B:15:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0086 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x009d  */
    @Override // video.biz.offline.list.logic.statemachine.OfflineBaseListStateMachine
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object onHistoryUpdated(State<OfflinePageState> state, Continuation<? super ChangedState<OfflinePageState>> continuation) {
        OfflineHomePageStateMachine$onHistoryUpdated$1 offlineHomePageStateMachine$onHistoryUpdated$1;
        Object allVideos;
        List videos;
        Object completedGroups;
        Object downloadingCards;
        final List completed;
        try {
            if (continuation instanceof OfflineHomePageStateMachine$onHistoryUpdated$1) {
                offlineHomePageStateMachine$onHistoryUpdated$1 = (OfflineHomePageStateMachine$onHistoryUpdated$1) continuation;
                if ((offlineHomePageStateMachine$onHistoryUpdated$1.label & Integer.MIN_VALUE) != 0) {
                    offlineHomePageStateMachine$onHistoryUpdated$1.label -= Integer.MIN_VALUE;
                    Object $result = offlineHomePageStateMachine$onHistoryUpdated$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (offlineHomePageStateMachine$onHistoryUpdated$1.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            LogKt.getVBLog().info("OfflineHomePageStateMachine onHistoryUpdated.");
                            IOfflineFacade offlineFacadeImpl = OfflineFacadeImpl_androidKt.getOfflineFacadeImpl();
                            offlineHomePageStateMachine$onHistoryUpdated$1.L$0 = state;
                            offlineHomePageStateMachine$onHistoryUpdated$1.label = 1;
                            allVideos = offlineFacadeImpl.getAllVideos(offlineHomePageStateMachine$onHistoryUpdated$1);
                            if (allVideos == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            videos = (List) allVideos;
                            Map<Long, Duration> historyCache = getHistoryCache();
                            offlineHomePageStateMachine$onHistoryUpdated$1.L$0 = state;
                            offlineHomePageStateMachine$onHistoryUpdated$1.L$1 = videos;
                            offlineHomePageStateMachine$onHistoryUpdated$1.label = 2;
                            completedGroups = OfflineCacheCardModelKt.completedGroups(videos, historyCache, offlineHomePageStateMachine$onHistoryUpdated$1);
                            if (completedGroups == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            List completed2 = (List) completedGroups;
                            offlineHomePageStateMachine$onHistoryUpdated$1.L$0 = state;
                            offlineHomePageStateMachine$onHistoryUpdated$1.L$1 = SpillingKt.nullOutSpilledVariable(videos);
                            offlineHomePageStateMachine$onHistoryUpdated$1.L$2 = completed2;
                            offlineHomePageStateMachine$onHistoryUpdated$1.label = 3;
                            downloadingCards = OfflineCacheCardModelKt.downloadingCards(videos, offlineHomePageStateMachine$onHistoryUpdated$1);
                            if (downloadingCards == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            completed = completed2;
                            final List downloading = (List) downloadingCards;
                            return state.mutate(new Function1() { // from class: video.biz.offline.list.logic.statemachine.OfflineHomePageStateMachine$$ExternalSyntheticLambda0
                                public final Object invoke(Object obj) {
                                    OfflinePageState onHistoryUpdated$lambda$0;
                                    onHistoryUpdated$lambda$0 = OfflineHomePageStateMachine.onHistoryUpdated$lambda$0(downloading, completed, this, (OfflinePageState) obj);
                                    return onHistoryUpdated$lambda$0;
                                }
                            });
                        case 1:
                            state = (State) offlineHomePageStateMachine$onHistoryUpdated$1.L$0;
                            ResultKt.throwOnFailure($result);
                            allVideos = $result;
                            videos = (List) allVideos;
                            Map<Long, Duration> historyCache2 = getHistoryCache();
                            offlineHomePageStateMachine$onHistoryUpdated$1.L$0 = state;
                            offlineHomePageStateMachine$onHistoryUpdated$1.L$1 = videos;
                            offlineHomePageStateMachine$onHistoryUpdated$1.label = 2;
                            completedGroups = OfflineCacheCardModelKt.completedGroups(videos, historyCache2, offlineHomePageStateMachine$onHistoryUpdated$1);
                            if (completedGroups == coroutine_suspended) {
                            }
                            List completed22 = (List) completedGroups;
                            offlineHomePageStateMachine$onHistoryUpdated$1.L$0 = state;
                            offlineHomePageStateMachine$onHistoryUpdated$1.L$1 = SpillingKt.nullOutSpilledVariable(videos);
                            offlineHomePageStateMachine$onHistoryUpdated$1.L$2 = completed22;
                            offlineHomePageStateMachine$onHistoryUpdated$1.label = 3;
                            downloadingCards = OfflineCacheCardModelKt.downloadingCards(videos, offlineHomePageStateMachine$onHistoryUpdated$1);
                            if (downloadingCards == coroutine_suspended) {
                            }
                            break;
                        case 2:
                            videos = (List) offlineHomePageStateMachine$onHistoryUpdated$1.L$1;
                            state = (State) offlineHomePageStateMachine$onHistoryUpdated$1.L$0;
                            ResultKt.throwOnFailure($result);
                            completedGroups = $result;
                            List completed222 = (List) completedGroups;
                            offlineHomePageStateMachine$onHistoryUpdated$1.L$0 = state;
                            offlineHomePageStateMachine$onHistoryUpdated$1.L$1 = SpillingKt.nullOutSpilledVariable(videos);
                            offlineHomePageStateMachine$onHistoryUpdated$1.L$2 = completed222;
                            offlineHomePageStateMachine$onHistoryUpdated$1.label = 3;
                            downloadingCards = OfflineCacheCardModelKt.downloadingCards(videos, offlineHomePageStateMachine$onHistoryUpdated$1);
                            if (downloadingCards == coroutine_suspended) {
                            }
                            break;
                        case 3:
                            completed = (List) offlineHomePageStateMachine$onHistoryUpdated$1.L$2;
                            List list = (List) offlineHomePageStateMachine$onHistoryUpdated$1.L$1;
                            state = (State) offlineHomePageStateMachine$onHistoryUpdated$1.L$0;
                            ResultKt.throwOnFailure($result);
                            downloadingCards = $result;
                            final List downloading2 = (List) downloadingCards;
                            return state.mutate(new Function1() { // from class: video.biz.offline.list.logic.statemachine.OfflineHomePageStateMachine$$ExternalSyntheticLambda0
                                public final Object invoke(Object obj) {
                                    OfflinePageState onHistoryUpdated$lambda$0;
                                    onHistoryUpdated$lambda$0 = OfflineHomePageStateMachine.onHistoryUpdated$lambda$0(downloading2, completed, this, (OfflinePageState) obj);
                                    return onHistoryUpdated$lambda$0;
                                }
                            });
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }
            }
            switch (offlineHomePageStateMachine$onHistoryUpdated$1.label) {
            }
        } catch (CancellationException cancellation) {
            throw cancellation;
        } catch (Exception e) {
            LogKt.getVBLog().error("onHistoryUpdated error: " + e);
            return state.override(new Function1() { // from class: video.biz.offline.list.logic.statemachine.OfflineHomePageStateMachine$$ExternalSyntheticLambda1
                public final Object invoke(Object obj) {
                    OfflinePageState onHistoryUpdated$lambda$1;
                    onHistoryUpdated$lambda$1 = OfflineHomePageStateMachine.onHistoryUpdated$lambda$1((OfflinePageState) obj);
                    return onHistoryUpdated$lambda$1;
                }
            });
        }
        offlineHomePageStateMachine$onHistoryUpdated$1 = new OfflineHomePageStateMachine$onHistoryUpdated$1(this, continuation);
        Object $result2 = offlineHomePageStateMachine$onHistoryUpdated$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OfflinePageState onHistoryUpdated$lambda$0(List $downloading, List $completed, OfflineHomePageStateMachine this$0, OfflinePageState $this$mutate) {
        OfflinePageState copy;
        Intrinsics.checkNotNullParameter($this$mutate, "$this$mutate");
        copy = $this$mutate.copy((r18 & 1) != 0 ? $this$mutate.downloading : $downloading, (r18 & 2) != 0 ? $this$mutate.completed : $completed, (r18 & 4) != 0 ? $this$mutate.dataState : null, (r18 & 8) != 0 ? $this$mutate.selectionState : null, (r18 & 16) != 0 ? $this$mutate.config : this$0.updateConfig($this$mutate, $completed.isEmpty()), (r18 & 32) != 0 ? $this$mutate.storageInfo : null, (r18 & 64) != 0 ? $this$mutate.reserveInfo : null, (r18 & 128) != 0 ? $this$mutate.dialogType : null);
        return copy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OfflinePageState onHistoryUpdated$lambda$1(OfflinePageState $this$override) {
        Intrinsics.checkNotNullParameter($this$override, "$this$override");
        return OfflinePageStateKt.getOfflinePageErrorState();
    }

    @Override // video.biz.offline.list.logic.statemachine.OfflineBaseListStateMachine
    public void dispose() {
        super.dispose();
        Job job = this.authJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.authJob = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final OfflinePageConfig updateConfig(OfflinePageState $this$updateConfig, boolean isEmpty) {
        return OfflinePageConfig.copy$default($this$updateConfig.getConfig(), SupportedOptions_androidKt.getSupportedHeaderOptions(isEmpty), null, 0, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x03f3  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x03fb  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0409  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0280  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0288  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x029c  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x02c7  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x035d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object handleAuth(Continuation<? super Unit> continuation) {
        OfflineHomePageStateMachine$handleAuth$1 offlineHomePageStateMachine$handleAuth$1;
        Object allVideos;
        Object[] videos;
        Map avMap;
        List arrayList;
        List updateList;
        Map avMap2;
        Object[] videos2;
        Object avAuthWithLimit$default;
        ArrayList arrayList2;
        int length;
        int i;
        List epList;
        OfflineAuthUpdate offlineAuthUpdate;
        boolean z;
        Object epAuthWithLimit$default;
        List avAuthList;
        Object obj;
        List avAuthList2;
        Object $result;
        Map $this$forEach$iv;
        boolean z2;
        List it$iv$iv;
        Object obj2;
        List epAuthList;
        boolean z3;
        if (continuation instanceof OfflineHomePageStateMachine$handleAuth$1) {
            offlineHomePageStateMachine$handleAuth$1 = (OfflineHomePageStateMachine$handleAuth$1) continuation;
            if ((offlineHomePageStateMachine$handleAuth$1.label & Integer.MIN_VALUE) != 0) {
                offlineHomePageStateMachine$handleAuth$1.label -= Integer.MIN_VALUE;
                Object $result2 = offlineHomePageStateMachine$handleAuth$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (offlineHomePageStateMachine$handleAuth$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result2);
                        new OfflineLog().info("start authentication.");
                        IOfflineFacade offlineFacadeImpl = OfflineFacadeImpl_androidKt.getOfflineFacadeImpl();
                        offlineHomePageStateMachine$handleAuth$1.label = 1;
                        allVideos = offlineFacadeImpl.getAllVideos(offlineHomePageStateMachine$handleAuth$1);
                        if (allVideos == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        Collection $this$toTypedArray$iv = (Collection) allVideos;
                        videos = (OfflineVideoEntity[]) $this$toTypedArray$iv.toArray(new OfflineVideoEntity[0]);
                        Collection destination$iv$iv = new ArrayList();
                        for (OfflineVideoEntity offlineVideoEntity : videos) {
                            if (offlineVideoEntity.getBizType() == OfflineVideoEntity.BizType.UGC) {
                                destination$iv$iv.add(offlineVideoEntity);
                            }
                        }
                        Iterable $this$groupBy$iv = (List) destination$iv$iv;
                        Map destination$iv$iv2 = new LinkedHashMap();
                        for (Object element$iv$iv : $this$groupBy$iv) {
                            Long boxLong = Boxing.boxLong(((OfflineVideoEntity) element$iv$iv).getVideoId());
                            Object value$iv$iv$iv = destination$iv$iv2.get(boxLong);
                            if (value$iv$iv$iv == null) {
                                arrayList2 = new ArrayList();
                                destination$iv$iv2.put(boxLong, arrayList2);
                            } else {
                                arrayList2 = value$iv$iv$iv;
                            }
                            List list$iv$iv = (List) arrayList2;
                            list$iv$iv.add(element$iv$iv);
                        }
                        avMap = destination$iv$iv2;
                        arrayList = new ArrayList();
                        if (avMap.isEmpty()) {
                            new OfflineLog().info("start authentication UGC, size: " + avMap.size());
                            Collection destination$iv$iv3 = new ArrayList(avMap.size());
                            for (Map.Entry item$iv$iv : avMap.entrySet()) {
                                destination$iv$iv3.add(Boxing.boxLong(((Number) item$iv$iv.getKey()).longValue()));
                            }
                            offlineHomePageStateMachine$handleAuth$1.L$0 = videos;
                            offlineHomePageStateMachine$handleAuth$1.L$1 = avMap;
                            offlineHomePageStateMachine$handleAuth$1.L$2 = arrayList;
                            offlineHomePageStateMachine$handleAuth$1.label = 2;
                            avAuthWithLimit$default = OfflineAuthApiKt.avAuthWithLimit$default((List) destination$iv$iv3, 0, offlineHomePageStateMachine$handleAuth$1, 2, null);
                            if (avAuthWithLimit$default == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            avAuthList = (List) avAuthWithLimit$default;
                            if (avAuthList.isEmpty()) {
                                Map $this$forEach$iv2 = avMap;
                                for (Map.Entry element$iv : $this$forEach$iv2.entrySet()) {
                                    long aid = ((Number) element$iv.getKey()).longValue();
                                    Iterable pages = (List) element$iv.getValue();
                                    Iterator it = avAuthList.iterator();
                                    while (true) {
                                        if (it.hasNext()) {
                                            obj = it.next();
                                            if (((AvAuthResult) obj).getAvid() == aid) {
                                                z2 = true;
                                                continue;
                                            } else {
                                                z2 = false;
                                                continue;
                                            }
                                            if (z2) {
                                            }
                                        } else {
                                            obj = null;
                                        }
                                    }
                                    AvAuthResult avAuthResult = (AvAuthResult) obj;
                                    AuthCode authCode = avAuthResult != null ? avAuthResult.getCode() : null;
                                    if (authCode != null) {
                                        avAuthList2 = avAuthList;
                                        Iterable $this$map$iv = pages;
                                        $result = $result2;
                                        $this$forEach$iv = $this$forEach$iv2;
                                        Collection destination$iv$iv4 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                                        Iterable $this$mapTo$iv$iv = $this$map$iv;
                                        boolean z4 = false;
                                        for (Object item$iv$iv2 : $this$mapTo$iv$iv) {
                                            Iterable $this$mapTo$iv$iv2 = $this$mapTo$iv$iv;
                                            String key = ((OfflineVideoEntity) item$iv$iv2).getKey();
                                            boolean z5 = z4;
                                            int $i$f$mapTo = authCode.getCode();
                                            destination$iv$iv4.add(new OfflineAuthUpdate(key, $i$f$mapTo));
                                            $this$map$iv = $this$map$iv;
                                            $this$mapTo$iv$iv = $this$mapTo$iv$iv2;
                                            z4 = z5;
                                        }
                                        arrayList.addAll((List) destination$iv$iv4);
                                    } else {
                                        avAuthList2 = avAuthList;
                                        $result = $result2;
                                        $this$forEach$iv = $this$forEach$iv2;
                                    }
                                    avAuthList = avAuthList2;
                                    $result2 = $result;
                                    $this$forEach$iv2 = $this$forEach$iv;
                                }
                            }
                            updateList = arrayList;
                            avMap2 = avMap;
                            videos2 = videos;
                            Object[] $this$filter$iv = videos2;
                            Collection destination$iv$iv5 = new ArrayList();
                            length = $this$filter$iv.length;
                            i = 0;
                            while (i < length) {
                                OfflineVideoEntity offlineVideoEntity2 = $this$filter$iv[i];
                                Object[] $this$filter$iv2 = $this$filter$iv;
                                if (offlineVideoEntity2.getBizType() == OfflineVideoEntity.BizType.OGV) {
                                    destination$iv$iv5.add(offlineVideoEntity2);
                                }
                                i++;
                                $this$filter$iv = $this$filter$iv2;
                            }
                            epList = (List) destination$iv$iv5;
                            if (!epList.isEmpty()) {
                                new OfflineLog().info("start authentication OGV, size: " + epList.size());
                                List $this$map$iv2 = epList;
                                Collection destination$iv$iv6 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
                                Iterable $this$mapTo$iv$iv3 = $this$map$iv2;
                                boolean z6 = false;
                                for (Object item$iv$iv3 : $this$mapTo$iv$iv3) {
                                    OfflineVideoEntity it2 = (OfflineVideoEntity) item$iv$iv3;
                                    destination$iv$iv6.add(new EpisodeParam(it2.getEpisodeId(), it2.getRealVideoQuality()));
                                    $this$mapTo$iv$iv3 = $this$mapTo$iv$iv3;
                                    z6 = z6;
                                    $this$map$iv2 = $this$map$iv2;
                                }
                                offlineHomePageStateMachine$handleAuth$1.L$0 = SpillingKt.nullOutSpilledVariable(videos2);
                                offlineHomePageStateMachine$handleAuth$1.L$1 = SpillingKt.nullOutSpilledVariable(avMap2);
                                offlineHomePageStateMachine$handleAuth$1.L$2 = updateList;
                                offlineHomePageStateMachine$handleAuth$1.L$3 = epList;
                                offlineHomePageStateMachine$handleAuth$1.label = 3;
                                offlineAuthUpdate = null;
                                z = false;
                                epAuthWithLimit$default = OfflineAuthApiKt.epAuthWithLimit$default((List) destination$iv$iv6, 0, offlineHomePageStateMachine$handleAuth$1, 2, null);
                                if (epAuthWithLimit$default == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                it$iv$iv = (List) epAuthWithLimit$default;
                                if (it$iv$iv.isEmpty()) {
                                    Iterable $this$mapNotNull$iv = epList;
                                    Collection destination$iv$iv7 = new ArrayList();
                                    for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
                                        OfflineVideoEntity ep = (OfflineVideoEntity) element$iv$iv$iv;
                                        Iterator it3 = it$iv$iv.iterator();
                                        while (true) {
                                            if (it3.hasNext()) {
                                                obj2 = it3.next();
                                                if (((EpAuthItem) obj2).getEpId() == ep.getEpisodeId()) {
                                                    z3 = true;
                                                    continue;
                                                } else {
                                                    z3 = z;
                                                    continue;
                                                }
                                                if (z3) {
                                                }
                                            } else {
                                                obj2 = offlineAuthUpdate;
                                            }
                                        }
                                        EpAuthItem epAuthItem = (EpAuthItem) obj2;
                                        Integer authCode2 = epAuthItem != null ? Boxing.boxInt(epAuthItem.getCode()) : offlineAuthUpdate;
                                        if (authCode2 == 0) {
                                            epAuthList = it$iv$iv;
                                        } else {
                                            epAuthList = it$iv$iv;
                                            offlineAuthUpdate = new OfflineAuthUpdate(ep.getKey(), authCode2.intValue());
                                        }
                                        if (offlineAuthUpdate != null) {
                                            destination$iv$iv7.add(offlineAuthUpdate);
                                        }
                                        it$iv$iv = epAuthList;
                                        offlineAuthUpdate = null;
                                        z = false;
                                    }
                                    updateList.addAll((List) destination$iv$iv7);
                                }
                            }
                            if (!updateList.isEmpty()) {
                                new OfflineLog().info("updateList is empty, nothing to update.");
                                return Unit.INSTANCE;
                            }
                            IOfflineFacade offlineFacadeImpl2 = OfflineFacadeImpl_androidKt.getOfflineFacadeImpl();
                            offlineHomePageStateMachine$handleAuth$1.L$0 = SpillingKt.nullOutSpilledVariable(videos2);
                            offlineHomePageStateMachine$handleAuth$1.L$1 = SpillingKt.nullOutSpilledVariable(avMap2);
                            offlineHomePageStateMachine$handleAuth$1.L$2 = SpillingKt.nullOutSpilledVariable(updateList);
                            offlineHomePageStateMachine$handleAuth$1.L$3 = SpillingKt.nullOutSpilledVariable(epList);
                            offlineHomePageStateMachine$handleAuth$1.label = 4;
                            return offlineFacadeImpl2.updateAuthCode(updateList, offlineHomePageStateMachine$handleAuth$1) == coroutine_suspended ? coroutine_suspended : Unit.INSTANCE;
                        }
                        updateList = arrayList;
                        avMap2 = avMap;
                        videos2 = videos;
                        Object[] $this$filter$iv3 = videos2;
                        Collection destination$iv$iv52 = new ArrayList();
                        length = $this$filter$iv3.length;
                        i = 0;
                        while (i < length) {
                        }
                        epList = (List) destination$iv$iv52;
                        if (!epList.isEmpty()) {
                        }
                        if (!updateList.isEmpty()) {
                        }
                    case 1:
                        ResultKt.throwOnFailure($result2);
                        allVideos = $result2;
                        Collection $this$toTypedArray$iv2 = (Collection) allVideos;
                        videos = (OfflineVideoEntity[]) $this$toTypedArray$iv2.toArray(new OfflineVideoEntity[0]);
                        Collection destination$iv$iv8 = new ArrayList();
                        while (r6 < r9) {
                        }
                        Iterable $this$groupBy$iv2 = (List) destination$iv$iv8;
                        Map destination$iv$iv22 = new LinkedHashMap();
                        while (r10.hasNext()) {
                        }
                        avMap = destination$iv$iv22;
                        arrayList = new ArrayList();
                        if (avMap.isEmpty()) {
                        }
                        break;
                    case 2:
                        arrayList = (List) offlineHomePageStateMachine$handleAuth$1.L$2;
                        avMap = (Map) offlineHomePageStateMachine$handleAuth$1.L$1;
                        videos = (OfflineVideoEntity[]) offlineHomePageStateMachine$handleAuth$1.L$0;
                        ResultKt.throwOnFailure($result2);
                        avAuthWithLimit$default = $result2;
                        avAuthList = (List) avAuthWithLimit$default;
                        if (avAuthList.isEmpty()) {
                        }
                        updateList = arrayList;
                        avMap2 = avMap;
                        videos2 = videos;
                        Object[] $this$filter$iv32 = videos2;
                        Collection destination$iv$iv522 = new ArrayList();
                        length = $this$filter$iv32.length;
                        i = 0;
                        while (i < length) {
                        }
                        epList = (List) destination$iv$iv522;
                        if (!epList.isEmpty()) {
                        }
                        if (!updateList.isEmpty()) {
                        }
                        break;
                    case 3:
                        epList = (List) offlineHomePageStateMachine$handleAuth$1.L$3;
                        updateList = (List) offlineHomePageStateMachine$handleAuth$1.L$2;
                        avMap2 = (Map) offlineHomePageStateMachine$handleAuth$1.L$1;
                        videos2 = (OfflineVideoEntity[]) offlineHomePageStateMachine$handleAuth$1.L$0;
                        ResultKt.throwOnFailure($result2);
                        epAuthWithLimit$default = $result2;
                        z = false;
                        offlineAuthUpdate = null;
                        it$iv$iv = (List) epAuthWithLimit$default;
                        if (it$iv$iv.isEmpty()) {
                        }
                        if (!updateList.isEmpty()) {
                        }
                        break;
                    case 4:
                        List list = (List) offlineHomePageStateMachine$handleAuth$1.L$3;
                        List list2 = (List) offlineHomePageStateMachine$handleAuth$1.L$2;
                        Map map = (Map) offlineHomePageStateMachine$handleAuth$1.L$1;
                        OfflineVideoEntity[] offlineVideoEntityArr = (OfflineVideoEntity[]) offlineHomePageStateMachine$handleAuth$1.L$0;
                        ResultKt.throwOnFailure($result2);
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        offlineHomePageStateMachine$handleAuth$1 = new OfflineHomePageStateMachine$handleAuth$1(this, continuation);
        Object $result22 = offlineHomePageStateMachine$handleAuth$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (offlineHomePageStateMachine$handleAuth$1.label) {
        }
    }
}