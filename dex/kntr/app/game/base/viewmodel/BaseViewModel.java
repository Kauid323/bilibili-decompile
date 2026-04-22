package kntr.app.game.base.viewmodel;

import androidx.lifecycle.ViewModel;
import com.freeletics.flowredux.dsl.BaseBuilderBlock;
import com.freeletics.flowredux.dsl.ConditionBuilderBlock;
import com.freeletics.flowredux.dsl.ExecutionPolicy;
import com.freeletics.flowredux.dsl.FlowReduxStoreBuilder;
import com.freeletics.flowredux.dsl.InStateBuilderBlock;
import kntr.app.ad.domain.report.internal.ReportBuildInParam;
import kntr.app.game.base.viewmodel.PageState;
import kntr.app.game.base.viewmodel.event.PageEvent;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.udf.Store;
import kntr.base.udf.StoreMachine;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.flow.Flow;

/* compiled from: BaseViewModel.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b'\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0005H\u0097@¢\u0006\u0002\u0010\u0012J\u001a\u0010\u0013\u001a\u0004\u0018\u00018\u00002\b\b\u0002\u0010\u0014\u001a\u00020\u0015H§@¢\u0006\u0002\u0010\u0016J\u0015\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0019J\u001d\u0010\u001a\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00028\u00002\u0006\u0010\u001c\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\u001dJ\b\u0010\u001e\u001a\u00020\u0010H\u0014J$\u0010\u001f\u001a\u00020\u0010*\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000!\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050 H\u0014R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\tX\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b8\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\u0007\u001a\u0004\b\r\u0010\u000e¨\u0006\""}, d2 = {"Lkntr/app/game/base/viewmodel/BaseViewModel;", "Data", "Landroidx/lifecycle/ViewModel;", "Lkntr/base/udf/Store;", "Lkntr/app/game/base/viewmodel/PageState;", "Lkntr/app/game/base/viewmodel/event/PageEvent;", "<init>", "()V", ReportBuildInParam.MACHINE, "Lkntr/base/udf/StoreMachine;", "state", "Lkotlinx/coroutines/flow/Flow;", "getState$annotations", "getState", "()Lkotlinx/coroutines/flow/Flow;", "dispatch", RoomRecommendViewModel.EMPTY_CURSOR, "action", "(Lkntr/app/game/base/viewmodel/event/PageEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadData", "refresh", RoomRecommendViewModel.EMPTY_CURSOR, "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkEmpty", "data", "(Ljava/lang/Object;)Z", "mergeData", "old", "new", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "onDataSuccess", "customContentBlock", "Lcom/freeletics/flowredux/dsl/InStateBuilderBlock;", "Lkntr/app/game/base/viewmodel/PageState$Content;", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class BaseViewModel<Data> extends ViewModel implements Store<PageState, PageEvent> {
    public static final int $stable = 8;
    private final StoreMachine<PageState, PageEvent> machine;
    private final Flow<PageState> state;

    public static /* synthetic */ void getState$annotations() {
    }

    public abstract boolean checkEmpty(Data data);

    public Object dispatch(PageEvent pageEvent, Continuation<? super Unit> continuation) {
        return dispatch$suspendImpl(this, pageEvent, continuation);
    }

    public abstract Object loadData(boolean z, Continuation<? super Data> continuation);

    public BaseViewModel() {
        StoreMachine.Companion companion = StoreMachine.Companion;
        Object initialState$iv = PageState.Initialize.INSTANCE;
        Function1 specBlock$iv = new Function1() { // from class: kntr.app.game.base.viewmodel.BaseViewModel$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit machine$lambda$0;
                machine$lambda$0 = BaseViewModel.machine$lambda$0(BaseViewModel.this, (FlowReduxStoreBuilder) obj);
                return machine$lambda$0;
            }
        };
        this.machine = new StoreMachine<>(initialState$iv, specBlock$iv);
        this.state = this.machine.getState();
    }

    public /* bridge */ /* synthetic */ Object dispatch(Object action, Continuation $completion) {
        return dispatch((PageEvent) action, (Continuation<? super Unit>) $completion);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit machine$lambda$0(final BaseViewModel this$0, FlowReduxStoreBuilder $this$StoreMachine) {
        Intrinsics.checkNotNullParameter($this$StoreMachine, "$this$StoreMachine");
        Function1 block$iv = new Function1() { // from class: kntr.app.game.base.viewmodel.BaseViewModel$$ExternalSyntheticLambda5
            public final Object invoke(Object obj) {
                Unit machine$lambda$0$0;
                machine$lambda$0$0 = BaseViewModel.machine$lambda$0$0((InStateBuilderBlock) obj);
                return machine$lambda$0$0;
            }
        };
        $this$StoreMachine.inState(Reflection.getOrCreateKotlinClass(PageState.class), block$iv);
        Function1 block$iv2 = new Function1() { // from class: kntr.app.game.base.viewmodel.BaseViewModel$$ExternalSyntheticLambda6
            public final Object invoke(Object obj) {
                Unit machine$lambda$0$1;
                machine$lambda$0$1 = BaseViewModel.machine$lambda$0$1(BaseViewModel.this, (InStateBuilderBlock) obj);
                return machine$lambda$0$1;
            }
        };
        $this$StoreMachine.inState(Reflection.getOrCreateKotlinClass(PageState.Loading.class), block$iv2);
        Function1 block$iv3 = new Function1() { // from class: kntr.app.game.base.viewmodel.BaseViewModel$$ExternalSyntheticLambda7
            public final Object invoke(Object obj) {
                Unit machine$lambda$0$2;
                machine$lambda$0$2 = BaseViewModel.machine$lambda$0$2((InStateBuilderBlock) obj);
                return machine$lambda$0$2;
            }
        };
        $this$StoreMachine.inState(Reflection.getOrCreateKotlinClass(PageState.Error.class), block$iv3);
        Function1 block$iv4 = new Function1() { // from class: kntr.app.game.base.viewmodel.BaseViewModel$$ExternalSyntheticLambda8
            public final Object invoke(Object obj) {
                Unit machine$lambda$0$3;
                machine$lambda$0$3 = BaseViewModel.machine$lambda$0$3(BaseViewModel.this, (InStateBuilderBlock) obj);
                return machine$lambda$0$3;
            }
        };
        $this$StoreMachine.inState(Reflection.getOrCreateKotlinClass(PageState.Content.class), block$iv4);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit machine$lambda$0$0(InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv = new BaseViewModel$machine$1$1$1(null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(PageEvent.Start.class), executionPolicy$iv, handler$iv);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit machine$lambda$0$1(BaseViewModel this$0, InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        $this$inState.onEnter(new BaseViewModel$machine$1$2$1(this$0, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit machine$lambda$0$2(InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv = new BaseViewModel$machine$1$3$1(null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(PageEvent.Retry.class), executionPolicy$iv, handler$iv);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit machine$lambda$0$3(final BaseViewModel this$0, InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv = new BaseViewModel$machine$1$4$1(null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(PageEvent.Refresh.class), executionPolicy$iv, handler$iv);
        BaseBuilderBlock $this$iv2 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv2 = new BaseViewModel$machine$1$4$2(null);
        ExecutionPolicy executionPolicy$iv2 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv2.on(Reflection.getOrCreateKotlinClass(PageEvent.LoadMore.class), executionPolicy$iv2, handler$iv2);
        $this$inState.condition(new Function1() { // from class: kntr.app.game.base.viewmodel.BaseViewModel$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                boolean machine$lambda$0$3$0;
                machine$lambda$0$3$0 = BaseViewModel.machine$lambda$0$3$0((PageState.Content) obj);
                return Boolean.valueOf(machine$lambda$0$3$0);
            }
        }, new Function1() { // from class: kntr.app.game.base.viewmodel.BaseViewModel$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                Unit machine$lambda$0$3$1;
                machine$lambda$0$3$1 = BaseViewModel.machine$lambda$0$3$1(BaseViewModel.this, (ConditionBuilderBlock) obj);
                return machine$lambda$0$3$1;
            }
        });
        $this$inState.condition(new Function1() { // from class: kntr.app.game.base.viewmodel.BaseViewModel$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                boolean machine$lambda$0$3$2;
                machine$lambda$0$3$2 = BaseViewModel.machine$lambda$0$3$2((PageState.Content) obj);
                return Boolean.valueOf(machine$lambda$0$3$2);
            }
        }, new Function1() { // from class: kntr.app.game.base.viewmodel.BaseViewModel$$ExternalSyntheticLambda4
            public final Object invoke(Object obj) {
                Unit machine$lambda$0$3$3;
                machine$lambda$0$3$3 = BaseViewModel.machine$lambda$0$3$3(BaseViewModel.this, (ConditionBuilderBlock) obj);
                return machine$lambda$0$3$3;
            }
        });
        this$0.customContentBlock($this$inState);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean machine$lambda$0$3$0(PageState.Content it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getLoadMore().isLoading();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit machine$lambda$0$3$1(BaseViewModel this$0, ConditionBuilderBlock $this$condition) {
        Intrinsics.checkNotNullParameter($this$condition, "$this$condition");
        $this$condition.onEnter(new BaseViewModel$machine$1$4$4$1(this$0, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean machine$lambda$0$3$2(PageState.Content it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getRefreshState().getRefreshing();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit machine$lambda$0$3$3(BaseViewModel this$0, ConditionBuilderBlock $this$condition) {
        Intrinsics.checkNotNullParameter($this$condition, "$this$condition");
        $this$condition.onEnter(new BaseViewModel$machine$1$4$6$1(this$0, null));
        return Unit.INSTANCE;
    }

    public Flow<PageState> getState() {
        return this.state;
    }

    static /* synthetic */ <Data> Object dispatch$suspendImpl(BaseViewModel<Data> baseViewModel, PageEvent action, Continuation<? super Unit> continuation) {
        Object dispatch = ((BaseViewModel) baseViewModel).machine.dispatch(action, continuation);
        return dispatch == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? dispatch : Unit.INSTANCE;
    }

    public static /* synthetic */ Object loadData$default(BaseViewModel baseViewModel, boolean z, Continuation continuation, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                z = false;
            }
            return baseViewModel.loadData(z, continuation);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadData");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Data mergeData(Data data, Data data2) {
        return data2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDataSuccess() {
    }

    protected void customContentBlock(InStateBuilderBlock<PageState.Content<Data>, PageState, PageEvent> inStateBuilderBlock) {
        Intrinsics.checkNotNullParameter(inStateBuilderBlock, "<this>");
    }
}