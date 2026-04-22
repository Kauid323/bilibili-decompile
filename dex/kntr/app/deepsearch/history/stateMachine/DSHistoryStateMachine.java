package kntr.app.deepsearch.history.stateMachine;

import com.freeletics.flowredux.dsl.BaseBuilderBlock;
import com.freeletics.flowredux.dsl.ConditionBuilderBlock;
import com.freeletics.flowredux.dsl.ExecutionPolicy;
import com.freeletics.flowredux.dsl.FlowReduxStateMachine;
import com.freeletics.flowredux.dsl.FlowReduxStoreBuilder;
import com.freeletics.flowredux.dsl.InStateBuilderBlock;
import javax.inject.Inject;
import kntr.app.ad.domain.report.internal.ReportBuildInParam;
import kntr.app.deepsearch.base.model.history.DSHistoryAction;
import kntr.app.deepsearch.base.model.history.DSHistoryData;
import kntr.app.deepsearch.base.model.history.DSHistoryPageStatus;
import kntr.app.deepsearch.history.service.DSHistoryLoadService;
import kntr.app.deepsearch.history.service.DSHistoryTrackerServiceKt;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: DSHistoryStateMachine.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\n\u001a\u00020\u000b*\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\fH\u0002J\u001e\u0010\r\u001a\u00020\u000b*\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000eH\u0002J\u001e\u0010\u000f\u001a\u00020\u000b*\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000eH\u0002J\u001e\u0010\u0010\u001a\u00020\u000b*\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000eH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lkntr/app/deepsearch/history/stateMachine/DSHistoryStateMachine;", "Lcom/freeletics/flowredux/dsl/FlowReduxStateMachine;", "Lkntr/app/deepsearch/base/model/history/DSHistoryData;", "Lkntr/app/deepsearch/base/model/history/DSHistoryAction;", "sessionId", RoomRecommendViewModel.EMPTY_CURSOR, "loadService", "Lkntr/app/deepsearch/history/service/DSHistoryLoadService;", "<init>", "(Ljava/lang/String;Lkntr/app/deepsearch/history/service/DSHistoryLoadService;)V", ReportBuildInParam.BUILD, RoomRecommendViewModel.EMPTY_CURSOR, "Lcom/freeletics/flowredux/dsl/FlowReduxStoreBuilder;", "initialLoad", "Lcom/freeletics/flowredux/dsl/InStateBuilderBlock;", "bindLoadAction", "selectAction", "history_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DSHistoryStateMachine extends FlowReduxStateMachine<DSHistoryData, DSHistoryAction> {
    private final DSHistoryLoadService loadService;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public DSHistoryStateMachine(String sessionId, DSHistoryLoadService loadService) {
        super(new DSHistoryData(sessionId, null, null, null, null, null, 62, null));
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(loadService, "loadService");
        this.loadService = loadService;
        spec(new Function1() { // from class: kntr.app.deepsearch.history.stateMachine.DSHistoryStateMachine$$ExternalSyntheticLambda11
            public final Object invoke(Object obj) {
                Unit _init_$lambda$0;
                _init_$lambda$0 = DSHistoryStateMachine._init_$lambda$0(DSHistoryStateMachine.this, (FlowReduxStoreBuilder) obj);
                return _init_$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$0(DSHistoryStateMachine this$0, FlowReduxStoreBuilder $this$spec) {
        Intrinsics.checkNotNullParameter($this$spec, "$this$spec");
        DSHistoryTrackerServiceKt.bindDSHistoryTrackerAction($this$spec);
        this$0.build($this$spec);
        return Unit.INSTANCE;
    }

    private final void build(FlowReduxStoreBuilder<DSHistoryData, DSHistoryAction> flowReduxStoreBuilder) {
        Function1 block$iv = new Function1() { // from class: kntr.app.deepsearch.history.stateMachine.DSHistoryStateMachine$$ExternalSyntheticLambda10
            public final Object invoke(Object obj) {
                Unit build$lambda$0;
                build$lambda$0 = DSHistoryStateMachine.build$lambda$0(DSHistoryStateMachine.this, (InStateBuilderBlock) obj);
                return build$lambda$0;
            }
        };
        flowReduxStoreBuilder.inState(Reflection.getOrCreateKotlinClass(DSHistoryData.class), block$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit build$lambda$0(DSHistoryStateMachine this$0, InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        this$0.initialLoad($this$inState);
        this$0.bindLoadAction($this$inState);
        this$0.selectAction($this$inState);
        return Unit.INSTANCE;
    }

    private final void initialLoad(InStateBuilderBlock<DSHistoryData, DSHistoryData, DSHistoryAction> inStateBuilderBlock) {
        inStateBuilderBlock.condition(new Function1() { // from class: kntr.app.deepsearch.history.stateMachine.DSHistoryStateMachine$$ExternalSyntheticLambda4
            public final Object invoke(Object obj) {
                boolean initialLoad$lambda$0;
                initialLoad$lambda$0 = DSHistoryStateMachine.initialLoad$lambda$0((DSHistoryData) obj);
                return Boolean.valueOf(initialLoad$lambda$0);
            }
        }, new Function1() { // from class: kntr.app.deepsearch.history.stateMachine.DSHistoryStateMachine$$ExternalSyntheticLambda5
            public final Object invoke(Object obj) {
                Unit initialLoad$lambda$1;
                initialLoad$lambda$1 = DSHistoryStateMachine.initialLoad$lambda$1((ConditionBuilderBlock) obj);
                return initialLoad$lambda$1;
            }
        });
        inStateBuilderBlock.condition(new Function1() { // from class: kntr.app.deepsearch.history.stateMachine.DSHistoryStateMachine$$ExternalSyntheticLambda6
            public final Object invoke(Object obj) {
                boolean initialLoad$lambda$2;
                initialLoad$lambda$2 = DSHistoryStateMachine.initialLoad$lambda$2((DSHistoryData) obj);
                return Boolean.valueOf(initialLoad$lambda$2);
            }
        }, new Function1() { // from class: kntr.app.deepsearch.history.stateMachine.DSHistoryStateMachine$$ExternalSyntheticLambda7
            public final Object invoke(Object obj) {
                Unit initialLoad$lambda$3;
                initialLoad$lambda$3 = DSHistoryStateMachine.initialLoad$lambda$3(DSHistoryStateMachine.this, (ConditionBuilderBlock) obj);
                return initialLoad$lambda$3;
            }
        });
        inStateBuilderBlock.condition(new Function1() { // from class: kntr.app.deepsearch.history.stateMachine.DSHistoryStateMachine$$ExternalSyntheticLambda8
            public final Object invoke(Object obj) {
                boolean initialLoad$lambda$4;
                initialLoad$lambda$4 = DSHistoryStateMachine.initialLoad$lambda$4((DSHistoryData) obj);
                return Boolean.valueOf(initialLoad$lambda$4);
            }
        }, new Function1() { // from class: kntr.app.deepsearch.history.stateMachine.DSHistoryStateMachine$$ExternalSyntheticLambda9
            public final Object invoke(Object obj) {
                Unit initialLoad$lambda$5;
                initialLoad$lambda$5 = DSHistoryStateMachine.initialLoad$lambda$5((ConditionBuilderBlock) obj);
                return initialLoad$lambda$5;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initialLoad$lambda$0(DSHistoryData it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getStatus() instanceof DSHistoryPageStatus.Initial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initialLoad$lambda$1(ConditionBuilderBlock $this$condition) {
        Intrinsics.checkNotNullParameter($this$condition, "$this$condition");
        $this$condition.onEnter(new DSHistoryStateMachine$initialLoad$2$1(null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initialLoad$lambda$2(DSHistoryData it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getStatus() instanceof DSHistoryPageStatus.Loading;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initialLoad$lambda$3(DSHistoryStateMachine this$0, ConditionBuilderBlock $this$condition) {
        Intrinsics.checkNotNullParameter($this$condition, "$this$condition");
        $this$condition.onEnter(new DSHistoryStateMachine$initialLoad$4$1(this$0, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initialLoad$lambda$4(DSHistoryData it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return (it.getStatus() instanceof DSHistoryPageStatus.Error) && it.getList().isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initialLoad$lambda$5(ConditionBuilderBlock $this$condition) {
        Intrinsics.checkNotNullParameter($this$condition, "$this$condition");
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) $this$condition;
        Function3 handler$iv = new DSHistoryStateMachine$initialLoad$6$1(null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(DSHistoryAction.LoadAction.Retry.class), executionPolicy$iv, handler$iv);
        return Unit.INSTANCE;
    }

    private final void bindLoadAction(InStateBuilderBlock<DSHistoryData, DSHistoryData, DSHistoryAction> inStateBuilderBlock) {
        inStateBuilderBlock.condition(new Function1() { // from class: kntr.app.deepsearch.history.stateMachine.DSHistoryStateMachine$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                boolean bindLoadAction$lambda$0;
                bindLoadAction$lambda$0 = DSHistoryStateMachine.bindLoadAction$lambda$0((DSHistoryData) obj);
                return Boolean.valueOf(bindLoadAction$lambda$0);
            }
        }, new Function1() { // from class: kntr.app.deepsearch.history.stateMachine.DSHistoryStateMachine$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                Unit bindLoadAction$lambda$1;
                bindLoadAction$lambda$1 = DSHistoryStateMachine.bindLoadAction$lambda$1((ConditionBuilderBlock) obj);
                return bindLoadAction$lambda$1;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean bindLoadAction$lambda$0(DSHistoryData it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return (it.getStatus() instanceof DSHistoryPageStatus.Idle) || (it.getStatus() instanceof DSHistoryPageStatus.Error);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bindLoadAction$lambda$1(ConditionBuilderBlock $this$condition) {
        Intrinsics.checkNotNullParameter($this$condition, "$this$condition");
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) $this$condition;
        Function3 handler$iv = new DSHistoryStateMachine$bindLoadAction$2$1(null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(DSHistoryAction.LoadAction.Refresh.class), executionPolicy$iv, handler$iv);
        BaseBuilderBlock $this$iv2 = (BaseBuilderBlock) $this$condition;
        Function3 handler$iv2 = new DSHistoryStateMachine$bindLoadAction$2$2(null);
        ExecutionPolicy executionPolicy$iv2 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv2.on(Reflection.getOrCreateKotlinClass(DSHistoryAction.LoadAction.LoadMore.class), executionPolicy$iv2, handler$iv2);
        return Unit.INSTANCE;
    }

    private final void selectAction(InStateBuilderBlock<DSHistoryData, DSHistoryData, DSHistoryAction> inStateBuilderBlock) {
        inStateBuilderBlock.condition(new Function1() { // from class: kntr.app.deepsearch.history.stateMachine.DSHistoryStateMachine$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                boolean selectAction$lambda$0;
                selectAction$lambda$0 = DSHistoryStateMachine.selectAction$lambda$0((DSHistoryData) obj);
                return Boolean.valueOf(selectAction$lambda$0);
            }
        }, new Function1() { // from class: kntr.app.deepsearch.history.stateMachine.DSHistoryStateMachine$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                Unit selectAction$lambda$1;
                selectAction$lambda$1 = DSHistoryStateMachine.selectAction$lambda$1(DSHistoryStateMachine.this, (ConditionBuilderBlock) obj);
                return selectAction$lambda$1;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean selectAction$lambda$0(DSHistoryData it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return !it.getList().isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit selectAction$lambda$1(DSHistoryStateMachine this$0, ConditionBuilderBlock $this$condition) {
        Intrinsics.checkNotNullParameter($this$condition, "$this$condition");
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) $this$condition;
        Function3 handler$iv = new DSHistoryStateMachine$selectAction$2$1(this$0, null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(DSHistoryAction.SelectItem.class), executionPolicy$iv, handler$iv);
        return Unit.INSTANCE;
    }
}