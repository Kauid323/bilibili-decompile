package video.biz.offline.list.logic.statemachine;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kntr.base.utils.CoroutineExJvmKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.ranges.RangesKt;
import kotlin.time.Duration;
import kotlin.time.TimeSource;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.base.log.LogKt;
import video.biz.offline.list.logic.model.OfflineCachedCardModel;
import video.biz.offline.list.logic.model.OfflinePageState;
import video.biz.offline.list.logic.statemachine.OfflineListAction;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OfflineBaseListStateMachine.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lvideo/biz/offline/list/logic/model/OfflinePageState;", "action", "Lvideo/biz/offline/list/logic/statemachine/OfflineListAction$UpdateHistoryProgress;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "video.biz.offline.list.logic.statemachine.OfflineBaseListStateMachine$1$1$17", f = "OfflineBaseListStateMachine.kt", i = {0, 0}, l = {174}, m = "invokeSuspend", n = {"action", "state"}, s = {"L$0", "L$1"}, v = 1)
public final class OfflineBaseListStateMachine$1$1$17 extends SuspendLambda implements Function3<OfflineListAction.UpdateHistoryProgress, State<OfflinePageState>, Continuation<? super ChangedState<? extends OfflinePageState>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;
    final /* synthetic */ OfflineBaseListStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OfflineBaseListStateMachine$1$1$17(OfflineBaseListStateMachine offlineBaseListStateMachine, Continuation<? super OfflineBaseListStateMachine$1$1$17> continuation) {
        super(3, continuation);
        this.this$0 = offlineBaseListStateMachine;
    }

    public final Object invoke(OfflineListAction.UpdateHistoryProgress updateHistoryProgress, State<OfflinePageState> state, Continuation<? super ChangedState<OfflinePageState>> continuation) {
        OfflineBaseListStateMachine$1$1$17 offlineBaseListStateMachine$1$1$17 = new OfflineBaseListStateMachine$1$1$17(this.this$0, continuation);
        offlineBaseListStateMachine$1$1$17.L$0 = updateHistoryProgress;
        offlineBaseListStateMachine$1$1$17.L$1 = state;
        return offlineBaseListStateMachine$1$1$17.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OfflineBaseListStateMachine.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lvideo/biz/offline/list/logic/model/OfflinePageState;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    @DebugMetadata(c = "video.biz.offline.list.logic.statemachine.OfflineBaseListStateMachine$1$1$17$1", f = "OfflineBaseListStateMachine.kt", i = {0, 0, 0, 0, 0, 0, 0, 1}, l = {187, 199}, m = "invokeSuspend", n = {"$this$withContext", "$this$measureTime$iv$iv", "completed", "$i$f$measureTime", "$i$f$measureTime", "mark$iv$iv", "$i$a$-measureTime-OfflineBaseListStateMachine$1$1$17$1$1", "$this$withContext"}, s = {"L$0", "L$2", "L$3", "I$0", "I$1", "J$0", "I$2", "L$0"}, v = 1)
    /* renamed from: video.biz.offline.list.logic.statemachine.OfflineBaseListStateMachine$1$1$17$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ChangedState<? extends OfflinePageState>>, Object> {
        final /* synthetic */ OfflineListAction.UpdateHistoryProgress $action;
        final /* synthetic */ State<OfflinePageState> $state;
        int I$0;
        int I$1;
        int I$2;
        long J$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        final /* synthetic */ OfflineBaseListStateMachine this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(OfflineBaseListStateMachine offlineBaseListStateMachine, State<OfflinePageState> state, OfflineListAction.UpdateHistoryProgress updateHistoryProgress, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = offlineBaseListStateMachine;
            this.$state = state;
            this.$action = updateHistoryProgress;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> anonymousClass1 = new AnonymousClass1(this.this$0, this.$state, this.$action, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ChangedState<OfflinePageState>> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            OfflineBaseListStateMachine offlineBaseListStateMachine;
            long mark$iv$iv;
            Object awaitAll;
            Object obj;
            CoroutineScope $this$withContext = (CoroutineScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    OfflineListAction.UpdateHistoryProgress updateHistoryProgress = this.$action;
                    offlineBaseListStateMachine = this.this$0;
                    TimeSource.Monotonic $this$measureTime$iv$iv = TimeSource.Monotonic.INSTANCE;
                    long mark$iv$iv2 = $this$measureTime$iv$iv.markNow-z9LOYto();
                    Iterable completed = updateHistoryProgress.getCompleted();
                    Iterable $this$filter$iv = completed;
                    Collection destination$iv$iv = new ArrayList();
                    Iterator<T> it = $this$filter$iv.iterator();
                    while (true) {
                        long mark$iv$iv3 = mark$iv$iv2;
                        if (!it.hasNext()) {
                            Iterable $this$map$iv = (List) destination$iv$iv;
                            Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                            for (Object item$iv$iv : $this$map$iv) {
                                Collection destination$iv$iv3 = destination$iv$iv2;
                                destination$iv$iv3.add(BuildersKt.async$default($this$withContext, (CoroutineContext) null, (CoroutineStart) null, new OfflineBaseListStateMachine$1$1$17$1$1$2$1((OfflineCachedCardModel) item$iv$iv, null), 3, (Object) null));
                                destination$iv$iv2 = destination$iv$iv3;
                                r7 = r7;
                                coroutine_suspended = coroutine_suspended;
                                mark$iv$iv3 = mark$iv$iv3;
                                $this$map$iv = $this$map$iv;
                            }
                            mark$iv$iv = mark$iv$iv3;
                            List it2 = (List) destination$iv$iv2;
                            LogKt.getVBLog().info("OfflineBaseListStateMachine trigger update history progress, size: " + it2.size());
                            this.L$0 = SpillingKt.nullOutSpilledVariable($this$withContext);
                            this.L$1 = offlineBaseListStateMachine;
                            this.L$2 = SpillingKt.nullOutSpilledVariable($this$measureTime$iv$iv);
                            this.L$3 = SpillingKt.nullOutSpilledVariable(completed);
                            this.I$0 = 0;
                            this.I$1 = 0;
                            this.J$0 = mark$iv$iv;
                            this.I$2 = 0;
                            this.label = 1;
                            awaitAll = AwaitKt.awaitAll(it2, this);
                            obj = coroutine_suspended;
                            if (awaitAll != obj) {
                                break;
                            } else {
                                return obj;
                            }
                        } else {
                            Object element$iv$iv = it.next();
                            if (((OfflineCachedCardModel) element$iv$iv).getChildCount() == 1) {
                                destination$iv$iv.add(element$iv$iv);
                            }
                            mark$iv$iv2 = mark$iv$iv3;
                        }
                    }
                case 1:
                    int i = this.I$2;
                    long mark$iv$iv4 = this.J$0;
                    int i2 = this.I$1;
                    int i3 = this.I$0;
                    List list = (List) this.L$3;
                    TimeSource.Monotonic monotonic = (TimeSource.Monotonic) this.L$2;
                    offlineBaseListStateMachine = (OfflineBaseListStateMachine) this.L$1;
                    ResultKt.throwOnFailure($result);
                    mark$iv$iv = mark$iv$iv4;
                    obj = coroutine_suspended;
                    awaitAll = $result;
                    break;
                case 2:
                    ResultKt.throwOnFailure($result);
                    return $result;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Iterable it3 = CollectionsKt.filterNotNull((Iterable) awaitAll);
            boolean z = false;
            Map<Long, Duration> historyCache = offlineBaseListStateMachine.getHistoryCache();
            Iterable<Pair> $this$associate$iv = it3;
            int capacity$iv = RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associate$iv, 10)), 16);
            Map destination$iv$iv4 = new LinkedHashMap(capacity$iv);
            for (Pair pair : $this$associate$iv) {
                long cid = ((Number) pair.component1()).longValue();
                long progress = ((Duration) pair.component2()).unbox-impl();
                int capacity$iv2 = capacity$iv;
                Pair pair2 = TuplesKt.to(Boxing.boxLong(cid), Duration.box-impl(progress));
                destination$iv$iv4.put(pair2.getFirst(), pair2.getSecond());
                capacity$iv = capacity$iv2;
                z = z;
            }
            historyCache.putAll(destination$iv$iv4);
            LogKt.getVBLog().info("OfflineBaseListStateMachine update history progress cost: " + Duration.getInWholeMilliseconds-impl(TimeSource.Monotonic.ValueTimeMark.elapsedNow-UwyO8pc(mark$iv$iv)) + " ms");
            this.L$0 = SpillingKt.nullOutSpilledVariable($this$withContext);
            this.L$1 = null;
            this.L$2 = null;
            this.L$3 = null;
            this.label = 2;
            Object onHistoryUpdated = this.this$0.onHistoryUpdated(this.$state, (Continuation) this);
            return onHistoryUpdated == obj ? obj : onHistoryUpdated;
        }
    }

    public final Object invokeSuspend(Object $result) {
        OfflineListAction.UpdateHistoryProgress action = (OfflineListAction.UpdateHistoryProgress) this.L$0;
        State state = (State) this.L$1;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.L$0 = SpillingKt.nullOutSpilledVariable(action);
                this.L$1 = SpillingKt.nullOutSpilledVariable(state);
                this.label = 1;
                Object withContext = BuildersKt.withContext(CoroutineExJvmKt.getIoContext(), new AnonymousClass1(this.this$0, state, action, null), (Continuation) this);
                if (withContext == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return withContext;
            case 1:
                ResultKt.throwOnFailure($result);
                return $result;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}