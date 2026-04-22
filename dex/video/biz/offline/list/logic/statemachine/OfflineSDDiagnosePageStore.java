package video.biz.offline.list.logic.statemachine;

import com.freeletics.flowredux.dsl.BaseBuilderBlock;
import com.freeletics.flowredux.dsl.ConditionBuilderBlock;
import com.freeletics.flowredux.dsl.ExecutionPolicy;
import com.freeletics.flowredux.dsl.FlowReduxStoreBuilder;
import com.freeletics.flowredux.dsl.InStateBuilderBlock;
import kntr.base.udf.StoreMachine;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.biz.offline.list.logic.statemachine.OfflineSDDiagnosePageEvent;

/* compiled from: OfflineSDDiagnosePageStore.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R#\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u000e\n\u0000\u0012\u0004\b\b\u0010\u0003\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lvideo/biz/offline/list/logic/statemachine/OfflineSDDiagnosePageStore;", "", "<init>", "()V", "machine", "Lkntr/base/udf/StoreMachine;", "Lvideo/biz/offline/list/logic/statemachine/OfflineSDDiagnosePageState;", "Lvideo/biz/offline/list/logic/statemachine/OfflineSDDiagnosePageEvent;", "getMachine$annotations", "getMachine", "()Lkntr/base/udf/StoreMachine;", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class OfflineSDDiagnosePageStore {
    public static final int $stable = 8;
    private final StoreMachine<OfflineSDDiagnosePageState, OfflineSDDiagnosePageEvent> machine;

    public static /* synthetic */ void getMachine$annotations() {
    }

    public OfflineSDDiagnosePageStore() {
        StoreMachine.Companion companion = StoreMachine.Companion;
        Object initialState$iv = new OfflineSDDiagnosePageState(null, null, null, 7, null);
        Function1 specBlock$iv = new Function1() { // from class: video.biz.offline.list.logic.statemachine.OfflineSDDiagnosePageStore$$ExternalSyntheticLambda4
            public final Object invoke(Object obj) {
                Unit machine$lambda$0;
                machine$lambda$0 = OfflineSDDiagnosePageStore.machine$lambda$0((FlowReduxStoreBuilder) obj);
                return machine$lambda$0;
            }
        };
        this.machine = new StoreMachine<>(initialState$iv, specBlock$iv);
    }

    public final StoreMachine<OfflineSDDiagnosePageState, OfflineSDDiagnosePageEvent> getMachine() {
        return this.machine;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit machine$lambda$0(FlowReduxStoreBuilder $this$StoreMachine) {
        Intrinsics.checkNotNullParameter($this$StoreMachine, "$this$StoreMachine");
        Function1 block$iv = new Function1() { // from class: video.biz.offline.list.logic.statemachine.OfflineSDDiagnosePageStore$$ExternalSyntheticLambda5
            public final Object invoke(Object obj) {
                Unit machine$lambda$0$0;
                machine$lambda$0$0 = OfflineSDDiagnosePageStore.machine$lambda$0$0((InStateBuilderBlock) obj);
                return machine$lambda$0$0;
            }
        };
        $this$StoreMachine.inState(Reflection.getOrCreateKotlinClass(OfflineSDDiagnosePageState.class), block$iv);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit machine$lambda$0$0(InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        $this$inState.condition(new Function1() { // from class: video.biz.offline.list.logic.statemachine.OfflineSDDiagnosePageStore$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                boolean machine$lambda$0$0$0;
                machine$lambda$0$0$0 = OfflineSDDiagnosePageStore.machine$lambda$0$0$0((OfflineSDDiagnosePageState) obj);
                return Boolean.valueOf(machine$lambda$0$0$0);
            }
        }, new Function1() { // from class: video.biz.offline.list.logic.statemachine.OfflineSDDiagnosePageStore$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit machine$lambda$0$0$1;
                machine$lambda$0$0$1 = OfflineSDDiagnosePageStore.machine$lambda$0$0$1((ConditionBuilderBlock) obj);
                return machine$lambda$0$0$1;
            }
        });
        $this$inState.condition(new Function1() { // from class: video.biz.offline.list.logic.statemachine.OfflineSDDiagnosePageStore$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                boolean machine$lambda$0$0$2;
                machine$lambda$0$0$2 = OfflineSDDiagnosePageStore.machine$lambda$0$0$2((OfflineSDDiagnosePageState) obj);
                return Boolean.valueOf(machine$lambda$0$0$2);
            }
        }, new Function1() { // from class: video.biz.offline.list.logic.statemachine.OfflineSDDiagnosePageStore$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                Unit machine$lambda$0$0$3;
                machine$lambda$0$0$3 = OfflineSDDiagnosePageStore.machine$lambda$0$0$3((ConditionBuilderBlock) obj);
                return machine$lambda$0$0$3;
            }
        });
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv = new OfflineSDDiagnosePageStore$machine$1$1$5(null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(OfflineSDDiagnosePageEvent.TriggerTest.class), executionPolicy$iv, handler$iv);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean machine$lambda$0$0$0(OfflineSDDiagnosePageState it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getProcedure() == OfflineSDDiagnoseProcedure.WriteTest;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit machine$lambda$0$0$1(ConditionBuilderBlock $this$condition) {
        Intrinsics.checkNotNullParameter($this$condition, "$this$condition");
        $this$condition.onEnter(new OfflineSDDiagnosePageStore$machine$1$1$2$1(null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean machine$lambda$0$0$2(OfflineSDDiagnosePageState it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getProcedure() == OfflineSDDiagnoseProcedure.ReadTest;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit machine$lambda$0$0$3(ConditionBuilderBlock $this$condition) {
        Intrinsics.checkNotNullParameter($this$condition, "$this$condition");
        $this$condition.onEnter(new OfflineSDDiagnosePageStore$machine$1$1$4$1(null));
        return Unit.INSTANCE;
    }
}