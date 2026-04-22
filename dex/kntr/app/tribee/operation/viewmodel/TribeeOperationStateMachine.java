package kntr.app.tribee.operation.viewmodel;

import com.freeletics.flowredux.dsl.BaseBuilderBlock;
import com.freeletics.flowredux.dsl.ConditionBuilderBlock;
import com.freeletics.flowredux.dsl.ExecutionPolicy;
import com.freeletics.flowredux.dsl.FlowReduxStateMachine;
import com.freeletics.flowredux.dsl.FlowReduxStoreBuilder;
import com.freeletics.flowredux.dsl.InStateBuilderBlock;
import javax.inject.Inject;
import kntr.app.tribee.operation.viewmodel.TribeeOperationStateAction;
import kntr.app.tribee.operation.viewmodel.service.TribeeOperationDataService;
import kntr.app.tribee.operation.viewmodel.state.TribeeOperationState;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: TribeeOperationStateMachine.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lkntr/app/tribee/operation/viewmodel/TribeeOperationStateMachine;", "Lcom/freeletics/flowredux/dsl/FlowReduxStateMachine;", "Lkntr/app/tribee/operation/viewmodel/state/TribeeOperationState;", "Lkntr/app/tribee/operation/viewmodel/TribeeOperationStateAction;", "dataService", "Lkntr/app/tribee/operation/viewmodel/service/TribeeOperationDataService;", "fromTribeeId", "", "<init>", "(Lkntr/app/tribee/operation/viewmodel/service/TribeeOperationDataService;J)V", "operation_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeeOperationStateMachine extends FlowReduxStateMachine<TribeeOperationState, TribeeOperationStateAction> {
    public static final int $stable = 8;
    private final TribeeOperationDataService dataService;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public TribeeOperationStateMachine(TribeeOperationDataService dataService, @FromTribeeId long fromTribeeId) {
        super(new TribeeOperationState.TribeeOperationInitiateState(Long.valueOf(fromTribeeId)));
        Intrinsics.checkNotNullParameter(dataService, "dataService");
        this.dataService = dataService;
        spec(new Function1() { // from class: kntr.app.tribee.operation.viewmodel.TribeeOperationStateMachine$$ExternalSyntheticLambda5
            public final Object invoke(Object obj) {
                Unit _init_$lambda$0;
                _init_$lambda$0 = TribeeOperationStateMachine._init_$lambda$0(TribeeOperationStateMachine.this, (FlowReduxStoreBuilder) obj);
                return _init_$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$0(final TribeeOperationStateMachine this$0, FlowReduxStoreBuilder $this$spec) {
        Intrinsics.checkNotNullParameter($this$spec, "$this$spec");
        Function1 block$iv = new Function1() { // from class: kntr.app.tribee.operation.viewmodel.TribeeOperationStateMachine$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                return TribeeOperationStateMachine.lambda$0$0(TribeeOperationStateMachine.this, (InStateBuilderBlock) obj);
            }
        };
        $this$spec.inState(Reflection.getOrCreateKotlinClass(TribeeOperationState.TribeeOperationInitiateState.class), block$iv);
        Function1 block$iv2 = new Function1() { // from class: kntr.app.tribee.operation.viewmodel.TribeeOperationStateMachine$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                return TribeeOperationStateMachine.lambda$0$1(TribeeOperationStateMachine.this, (InStateBuilderBlock) obj);
            }
        };
        $this$spec.inState(Reflection.getOrCreateKotlinClass(TribeeOperationState.TribeeOperationContentState.class), block$iv2);
        Function1 block$iv3 = new Function1() { // from class: kntr.app.tribee.operation.viewmodel.TribeeOperationStateMachine$$ExternalSyntheticLambda4
            public final Object invoke(Object obj) {
                return TribeeOperationStateMachine.lambda$0$2((InStateBuilderBlock) obj);
            }
        };
        $this$spec.inState(Reflection.getOrCreateKotlinClass(TribeeOperationState.class), block$iv3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$0$0(TribeeOperationStateMachine this$0, InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        $this$inState.onEnter(new TribeeOperationStateMachine$1$1$1(this$0, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$0$1(final TribeeOperationStateMachine this$0, InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv = new TribeeOperationStateMachine$1$2$1(null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(TribeeOperationStateAction.UpdateTribee.class), executionPolicy$iv, handler$iv);
        BaseBuilderBlock $this$iv2 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv2 = new TribeeOperationStateMachine$1$2$2(null);
        ExecutionPolicy executionPolicy$iv2 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv2.on(Reflection.getOrCreateKotlinClass(TribeeOperationStateAction.UpdateType.class), executionPolicy$iv2, handler$iv2);
        BaseBuilderBlock $this$iv3 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv3 = new TribeeOperationStateMachine$1$2$3(null);
        ExecutionPolicy executionPolicy$iv3 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv3.on(Reflection.getOrCreateKotlinClass(TribeeOperationStateAction.UpdateCount.class), executionPolicy$iv3, handler$iv3);
        $this$inState.condition(new Function1() { // from class: kntr.app.tribee.operation.viewmodel.TribeeOperationStateMachine$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                return Boolean.valueOf(TribeeOperationStateMachine.lambda$0$1$0((TribeeOperationState.TribeeOperationContentState) obj));
            }
        }, new Function1() { // from class: kntr.app.tribee.operation.viewmodel.TribeeOperationStateMachine$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                return TribeeOperationStateMachine.lambda$0$1$1(TribeeOperationStateMachine.this, (ConditionBuilderBlock) obj);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean lambda$0$1$0(TribeeOperationState.TribeeOperationContentState it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getSelectedTribeeId() != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$0$1$1(TribeeOperationStateMachine this$0, ConditionBuilderBlock $this$condition) {
        Intrinsics.checkNotNullParameter($this$condition, "$this$condition");
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) $this$condition;
        Function3 handler$iv = new TribeeOperationStateMachine$1$2$5$1(this$0, null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(TribeeOperationStateAction.Submit.class), executionPolicy$iv, handler$iv);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$0$2(InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv = new TribeeOperationStateMachine$1$3$1(null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(TribeeOperationStateAction.RefreshPage.class), executionPolicy$iv, handler$iv);
        return Unit.INSTANCE;
    }
}