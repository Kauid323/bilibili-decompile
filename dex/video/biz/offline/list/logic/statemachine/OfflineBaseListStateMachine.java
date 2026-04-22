package video.biz.offline.list.logic.statemachine;

import com.freeletics.flowredux.dsl.BaseBuilderBlock;
import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.ConditionBuilderBlock;
import com.freeletics.flowredux.dsl.ExecutionPolicy;
import com.freeletics.flowredux.dsl.FlowReduxStateMachine;
import com.freeletics.flowredux.dsl.FlowReduxStoreBuilder;
import com.freeletics.flowredux.dsl.InStateBuilderBlock;
import com.freeletics.flowredux.dsl.State;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kntr.base.router.Router;
import kntr.base.utils.CoroutineExJvmKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.time.Duration;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.base.log.LogKt;
import video.biz.offline.base.model.entity.OfflineVideoEntity;
import video.biz.offline.list.logic.model.DataState;
import video.biz.offline.list.logic.model.OfflineCachedCardModel;
import video.biz.offline.list.logic.model.OfflinePageState;
import video.biz.offline.list.logic.model.SelectionState;
import video.biz.offline.list.logic.statemachine.OfflineListAction;

/* compiled from: OfflineBaseListStateMachine.kt */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\b'\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\"\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u0014H\u0095@¢\u0006\u0002\u0010\u0015J\u001e\u0010\u001d\u001a\u00020\u001e*\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u001fH\u0014J\"\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u0014H¥@¢\u0006\u0002\u0010\u0015J*\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u00142\u0006\u0010\"\u001a\u00020#H¥@¢\u0006\u0002\u0010$J$\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u00142\u0006\u0010\"\u001a\u00020&H\u0002J\u001c\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u0014H$J3\u0010(\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020\u00002\u001c\u0010*\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0,\u0012\u0006\u0012\u0004\u0018\u00010-0+H\u0004¢\u0006\u0002\u0010.J*\u0010/\u001a\u00020\u001e2\f\u00100\u001a\b\u0012\u0004\u0012\u000202012\f\u00103\u001a\b\u0012\u0004\u0012\u00020201H\u0085@¢\u0006\u0002\u00104J\b\u00105\u001a\u00020\u001eH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\"\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u00066"}, d2 = {"Lvideo/biz/offline/list/logic/statemachine/OfflineBaseListStateMachine;", "Lcom/freeletics/flowredux/dsl/FlowReduxStateMachine;", "Lvideo/biz/offline/list/logic/model/OfflinePageState;", "Lvideo/biz/offline/list/logic/statemachine/OfflineListAction;", "initialState", "scope", "Lkotlinx/coroutines/CoroutineScope;", "router", "Lkntr/base/router/Router;", "<init>", "(Lvideo/biz/offline/list/logic/model/OfflinePageState;Lkotlinx/coroutines/CoroutineScope;Lkntr/base/router/Router;)V", "historyCache", "", "", "Lkotlin/time/Duration;", "getHistoryCache", "()Ljava/util/Map;", "onHistoryUpdated", "Lcom/freeletics/flowredux/dsl/ChangedState;", "state", "Lcom/freeletics/flowredux/dsl/State;", "(Lcom/freeletics/flowredux/dsl/State;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toastFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "", "getToastFlow$annotations", "()V", "getToastFlow", "()Lkotlinx/coroutines/flow/MutableSharedFlow;", "childSpec", "", "Lcom/freeletics/flowredux/dsl/InStateBuilderBlock;", "loadData", "handleClick", "action", "Lvideo/biz/offline/list/logic/statemachine/OfflineListAction$ItemClick;", "(Lcom/freeletics/flowredux/dsl/State;Lvideo/biz/offline/list/logic/statemachine/OfflineListAction$ItemClick;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleLongClick", "Lvideo/biz/offline/list/logic/statemachine/OfflineListAction$ItemLongClick;", "handleSelectAll", "processWithLoading", "machine", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(Lvideo/biz/offline/list/logic/statemachine/OfflineBaseListStateMachine;Lkotlin/jvm/functions/Function1;)V", "notifyUpdateHistoryProgressIfNeed", "pre", "", "Lvideo/biz/offline/list/logic/model/OfflineCachedCardModel;", "new", "(Ljava/util/List;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dispose", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public abstract class OfflineBaseListStateMachine extends FlowReduxStateMachine<OfflinePageState, OfflineListAction> {
    public static final int $stable = 8;
    private final Map<Long, Duration> historyCache;
    private final Router router;
    private final CoroutineScope scope;
    private final MutableSharedFlow<String> toastFlow;

    public static /* synthetic */ void getToastFlow$annotations() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract Object handleClick(State<OfflinePageState> state, OfflineListAction.ItemClick itemClick, Continuation<? super ChangedState<OfflinePageState>> continuation);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract ChangedState<OfflinePageState> handleSelectAll(State<OfflinePageState> state);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract Object loadData(State<OfflinePageState> state, Continuation<? super ChangedState<OfflinePageState>> continuation);

    /* JADX INFO: Access modifiers changed from: protected */
    public Object onHistoryUpdated(State<OfflinePageState> state, Continuation<? super ChangedState<OfflinePageState>> continuation) {
        return onHistoryUpdated$suspendImpl(this, state, continuation);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OfflineBaseListStateMachine(OfflinePageState initialState, CoroutineScope scope, Router router) {
        super(initialState);
        Intrinsics.checkNotNullParameter(initialState, "initialState");
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(router, "router");
        this.scope = scope;
        this.router = router;
        this.historyCache = new LinkedHashMap();
        spec(new Function1() { // from class: video.biz.offline.list.logic.statemachine.OfflineBaseListStateMachine$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit _init_$lambda$0;
                _init_$lambda$0 = OfflineBaseListStateMachine._init_$lambda$0(OfflineBaseListStateMachine.this, (FlowReduxStoreBuilder) obj);
                return _init_$lambda$0;
            }
        });
        this.toastFlow = SharedFlowKt.MutableSharedFlow$default(0, 1, (BufferOverflow) null, 5, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Map<Long, Duration> getHistoryCache() {
        return this.historyCache;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$0(final OfflineBaseListStateMachine this$0, FlowReduxStoreBuilder $this$spec) {
        Intrinsics.checkNotNullParameter($this$spec, "$this$spec");
        Function1 block$iv = new Function1() { // from class: video.biz.offline.list.logic.statemachine.OfflineBaseListStateMachine$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                return OfflineBaseListStateMachine.lambda$0$0(OfflineBaseListStateMachine.this, (InStateBuilderBlock) obj);
            }
        };
        $this$spec.inState(Reflection.getOrCreateKotlinClass(OfflinePageState.class), block$iv);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$0$0(final OfflineBaseListStateMachine this$0, InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv = new OfflineBaseListStateMachine$1$1$1(this$0, null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(OfflineListAction.LoadData.class), executionPolicy$iv, handler$iv);
        $this$inState.condition(new Function1() { // from class: video.biz.offline.list.logic.statemachine.OfflineBaseListStateMachine$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                return Boolean.valueOf(OfflineBaseListStateMachine.lambda$0$0$0((OfflinePageState) obj));
            }
        }, new Function1() { // from class: video.biz.offline.list.logic.statemachine.OfflineBaseListStateMachine$$ExternalSyntheticLambda4
            public final Object invoke(Object obj) {
                return OfflineBaseListStateMachine.lambda$0$0$1(OfflineBaseListStateMachine.this, (ConditionBuilderBlock) obj);
            }
        });
        BaseBuilderBlock $this$iv2 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv2 = new OfflineBaseListStateMachine$1$1$4(this$0, null);
        ExecutionPolicy executionPolicy$iv2 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv2.on(Reflection.getOrCreateKotlinClass(OfflineListAction.ItemClick.class), executionPolicy$iv2, handler$iv2);
        BaseBuilderBlock $this$iv3 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv3 = new OfflineBaseListStateMachine$1$1$5(this$0, null);
        ExecutionPolicy executionPolicy$iv3 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv3.on(Reflection.getOrCreateKotlinClass(OfflineListAction.ItemLongClick.class), executionPolicy$iv3, handler$iv3);
        BaseBuilderBlock $this$iv4 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv4 = new OfflineBaseListStateMachine$1$1$6(null);
        ExecutionPolicy executionPolicy$iv4 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv4.on(Reflection.getOrCreateKotlinClass(OfflineListAction.EnterEditMode.class), executionPolicy$iv4, handler$iv4);
        BaseBuilderBlock $this$iv5 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv5 = new OfflineBaseListStateMachine$1$1$7(null);
        ExecutionPolicy executionPolicy$iv5 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv5.on(Reflection.getOrCreateKotlinClass(OfflineListAction.ExitEditMode.class), executionPolicy$iv5, handler$iv5);
        BaseBuilderBlock $this$iv6 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv6 = new OfflineBaseListStateMachine$1$1$8(this$0, null);
        ExecutionPolicy executionPolicy$iv6 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv6.on(Reflection.getOrCreateKotlinClass(OfflineListAction.UpdateDanmaku.class), executionPolicy$iv6, handler$iv6);
        BaseBuilderBlock $this$iv7 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv7 = new OfflineBaseListStateMachine$1$1$9(this$0, null);
        ExecutionPolicy executionPolicy$iv7 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv7.on(Reflection.getOrCreateKotlinClass(OfflineListAction.ClickSelectAll.class), executionPolicy$iv7, handler$iv7);
        BaseBuilderBlock $this$iv8 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv8 = new OfflineBaseListStateMachine$1$1$10(null);
        ExecutionPolicy executionPolicy$iv8 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv8.on(Reflection.getOrCreateKotlinClass(OfflineListAction.ShowLoading.class), executionPolicy$iv8, handler$iv8);
        BaseBuilderBlock $this$iv9 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv9 = new OfflineBaseListStateMachine$1$1$11(null);
        ExecutionPolicy executionPolicy$iv9 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv9.on(Reflection.getOrCreateKotlinClass(OfflineListAction.DismissLoading.class), executionPolicy$iv9, handler$iv9);
        BaseBuilderBlock $this$iv10 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv10 = new OfflineBaseListStateMachine$1$1$12(null);
        ExecutionPolicy executionPolicy$iv10 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv10.on(Reflection.getOrCreateKotlinClass(OfflineListAction.DismissDialog.class), executionPolicy$iv10, handler$iv10);
        BaseBuilderBlock $this$iv11 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv11 = new OfflineBaseListStateMachine$1$1$13(this$0, null);
        ExecutionPolicy executionPolicy$iv11 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv11.on(Reflection.getOrCreateKotlinClass(OfflineListAction.VipPurchase.class), executionPolicy$iv11, handler$iv11);
        BaseBuilderBlock $this$iv12 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv12 = new OfflineBaseListStateMachine$1$1$14(this$0, null);
        ExecutionPolicy executionPolicy$iv12 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv12.on(Reflection.getOrCreateKotlinClass(OfflineListAction.ClickToDetail.class), executionPolicy$iv12, handler$iv12);
        BaseBuilderBlock $this$iv13 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv13 = new OfflineBaseListStateMachine$1$1$15(null);
        ExecutionPolicy executionPolicy$iv13 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv13.on(Reflection.getOrCreateKotlinClass(OfflineListAction.ShowBandWidthAlert.class), executionPolicy$iv13, handler$iv13);
        BaseBuilderBlock $this$iv14 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv14 = new OfflineBaseListStateMachine$1$1$16(this$0, null);
        ExecutionPolicy executionPolicy$iv14 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv14.on(Reflection.getOrCreateKotlinClass(OfflineListAction.Jump2BandWidth.class), executionPolicy$iv14, handler$iv14);
        BaseBuilderBlock $this$iv15 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv15 = new OfflineBaseListStateMachine$1$1$17(this$0, null);
        ExecutionPolicy executionPolicy$iv15 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv15.on(Reflection.getOrCreateKotlinClass(OfflineListAction.UpdateHistoryProgress.class), executionPolicy$iv15, handler$iv15);
        BaseBuilderBlock $this$iv16 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv16 = new OfflineBaseListStateMachine$1$1$18(null);
        ExecutionPolicy executionPolicy$iv16 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv16.on(Reflection.getOrCreateKotlinClass(OfflineListAction.GetStorageInfo.class), executionPolicy$iv16, handler$iv16);
        this$0.childSpec($this$inState);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean lambda$0$0$0(OfflinePageState it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getDataState() == DataState.LOADING;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$0$0$1(OfflineBaseListStateMachine this$0, ConditionBuilderBlock $this$condition) {
        Intrinsics.checkNotNullParameter($this$condition, "$this$condition");
        $this$condition.onEnter(new OfflineBaseListStateMachine$1$1$3$1(this$0, null));
        return Unit.INSTANCE;
    }

    static /* synthetic */ Object onHistoryUpdated$suspendImpl(OfflineBaseListStateMachine $this, State<OfflinePageState> state, Continuation<? super ChangedState<OfflinePageState>> continuation) {
        return state.noChange();
    }

    public final MutableSharedFlow<String> getToastFlow() {
        return this.toastFlow;
    }

    protected void childSpec(InStateBuilderBlock<OfflinePageState, OfflinePageState, OfflineListAction> inStateBuilderBlock) {
        Intrinsics.checkNotNullParameter(inStateBuilderBlock, "<this>");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ChangedState<OfflinePageState> handleLongClick(State<OfflinePageState> state, final OfflineListAction.ItemLongClick action) {
        return state.mutate(new Function1() { // from class: video.biz.offline.list.logic.statemachine.OfflineBaseListStateMachine$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                OfflinePageState handleLongClick$lambda$0;
                handleLongClick$lambda$0 = OfflineBaseListStateMachine.handleLongClick$lambda$0(OfflineListAction.ItemLongClick.this, (OfflinePageState) obj);
                return handleLongClick$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OfflinePageState handleLongClick$lambda$0(OfflineListAction.ItemLongClick $action, OfflinePageState $this$mutate) {
        OfflinePageState copy;
        Intrinsics.checkNotNullParameter($this$mutate, "$this$mutate");
        copy = $this$mutate.copy((r18 & 1) != 0 ? $this$mutate.downloading : null, (r18 & 2) != 0 ? $this$mutate.completed : null, (r18 & 4) != 0 ? $this$mutate.dataState : null, (r18 & 8) != 0 ? $this$mutate.selectionState : new SelectionState.Active(SetsKt.setOf($action.getKey())), (r18 & 16) != 0 ? $this$mutate.config : null, (r18 & 32) != 0 ? $this$mutate.storageInfo : null, (r18 & 64) != 0 ? $this$mutate.reserveInfo : null, (r18 & 128) != 0 ? $this$mutate.dialogType : null);
        return copy;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void processWithLoading(OfflineBaseListStateMachine machine, Function1<? super Continuation<? super Unit>, ? extends Object> function1) {
        Intrinsics.checkNotNullParameter(machine, "machine");
        Intrinsics.checkNotNullParameter(function1, "block");
        BuildersKt.launch$default(this.scope, CoroutineExJvmKt.getIoContext(), (CoroutineStart) null, new OfflineBaseListStateMachine$processWithLoading$1(function1, machine, null), 2, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Object notifyUpdateHistoryProgressIfNeed(List<OfflineCachedCardModel> list, List<OfflineCachedCardModel> list2, Continuation<? super Unit> continuation) {
        List<OfflineCachedCardModel> $this$filter$iv = list;
        Collection destination$iv$iv = new ArrayList();
        Iterator<T> it = $this$filter$iv.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object element$iv$iv = it.next();
            OfflineCachedCardModel it2 = (OfflineCachedCardModel) element$iv$iv;
            if (it2.getChildCount() == 1) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        Iterable $this$map$iv = (List) destination$iv$iv;
        Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            OfflineCachedCardModel it3 = (OfflineCachedCardModel) item$iv$iv;
            destination$iv$iv2.add(Boxing.boxLong(((OfflineVideoEntity) CollectionsKt.first(it3.getChildren())).getCid()));
        }
        Set preSet = CollectionsKt.toSet((List) destination$iv$iv2);
        List<OfflineCachedCardModel> $this$filter$iv2 = list2;
        Collection destination$iv$iv3 = new ArrayList();
        for (Object element$iv$iv2 : $this$filter$iv2) {
            OfflineCachedCardModel it4 = (OfflineCachedCardModel) element$iv$iv2;
            OfflineCachedCardModel it5 = it4.getChildCount() == 1 ? 1 : null;
            if (it5 != null) {
                destination$iv$iv3.add(element$iv$iv2);
            }
        }
        Iterable $this$map$iv2 = (List) destination$iv$iv3;
        Collection destination$iv$iv4 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
        for (Object item$iv$iv2 : $this$map$iv2) {
            OfflineCachedCardModel it6 = (OfflineCachedCardModel) item$iv$iv2;
            destination$iv$iv4.add(Boxing.boxLong(((OfflineVideoEntity) CollectionsKt.first(it6.getChildren())).getCid()));
        }
        Set newSet = CollectionsKt.toSet((List) destination$iv$iv4);
        if (!newSet.isEmpty() && !Intrinsics.areEqual(preSet, newSet)) {
            Object dispatch = dispatch(new OfflineListAction.UpdateHistoryProgress(list2), continuation);
            return dispatch == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? dispatch : Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    public void dispose() {
        LogKt.getVBLog().info("OfflineBaseListStateMachine dispose");
    }
}