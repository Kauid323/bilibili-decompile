package video.biz.offline.list.logic.statemachine;

import com.freeletics.flowredux.dsl.BaseBuilderBlock;
import com.freeletics.flowredux.dsl.ExecutionPolicy;
import com.freeletics.flowredux.dsl.FlowReduxStoreBuilder;
import com.freeletics.flowredux.dsl.InStateBuilderBlock;
import kntr.base.router.Router;
import kntr.base.udf.StoreMachine;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.biz.offline.list.logic.statemachine.OfflineSettingsPageEvent;
import video.biz.offline.list.logic.statemachine.OfflineSettingsPageState;

/* compiled from: OfflineSettingsPageStore.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u000e\n\u0000\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lvideo/biz/offline/list/logic/statemachine/OfflineSettingsPageStore;", "", "router", "Lkntr/base/router/Router;", "<init>", "(Lkntr/base/router/Router;)V", "machine", "Lkntr/base/udf/StoreMachine;", "Lvideo/biz/offline/list/logic/statemachine/OfflineSettingsPageState;", "Lvideo/biz/offline/list/logic/statemachine/OfflineSettingsPageEvent;", "getMachine$annotations", "()V", "getMachine", "()Lkntr/base/udf/StoreMachine;", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class OfflineSettingsPageStore {
    public static final int $stable = 8;
    private final StoreMachine<OfflineSettingsPageState, OfflineSettingsPageEvent> machine;
    private final Router router;

    public static /* synthetic */ void getMachine$annotations() {
    }

    public OfflineSettingsPageStore(Router router) {
        Intrinsics.checkNotNullParameter(router, "router");
        this.router = router;
        StoreMachine.Companion companion = StoreMachine.Companion;
        Object initialState$iv = OfflineSettingsPageState.Loading.INSTANCE;
        Function1 specBlock$iv = new Function1() { // from class: video.biz.offline.list.logic.statemachine.OfflineSettingsPageStore$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit machine$lambda$0;
                machine$lambda$0 = OfflineSettingsPageStore.machine$lambda$0(OfflineSettingsPageStore.this, (FlowReduxStoreBuilder) obj);
                return machine$lambda$0;
            }
        };
        this.machine = new StoreMachine<>(initialState$iv, specBlock$iv);
    }

    public final StoreMachine<OfflineSettingsPageState, OfflineSettingsPageEvent> getMachine() {
        return this.machine;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit machine$lambda$0(final OfflineSettingsPageStore this$0, FlowReduxStoreBuilder $this$StoreMachine) {
        Intrinsics.checkNotNullParameter($this$StoreMachine, "$this$StoreMachine");
        Function1 block$iv = new Function1() { // from class: video.biz.offline.list.logic.statemachine.OfflineSettingsPageStore$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit machine$lambda$0$0;
                machine$lambda$0$0 = OfflineSettingsPageStore.machine$lambda$0$0((InStateBuilderBlock) obj);
                return machine$lambda$0$0;
            }
        };
        $this$StoreMachine.inState(Reflection.getOrCreateKotlinClass(OfflineSettingsPageState.Loading.class), block$iv);
        Function1 block$iv2 = new Function1() { // from class: video.biz.offline.list.logic.statemachine.OfflineSettingsPageStore$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                Unit machine$lambda$0$1;
                machine$lambda$0$1 = OfflineSettingsPageStore.machine$lambda$0$1(OfflineSettingsPageStore.this, (InStateBuilderBlock) obj);
                return machine$lambda$0$1;
            }
        };
        $this$StoreMachine.inState(Reflection.getOrCreateKotlinClass(OfflineSettingsPageState.Ready.class), block$iv2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit machine$lambda$0$0(InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        $this$inState.onEnter(new OfflineSettingsPageStore$machine$1$1$1(null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit machine$lambda$0$1(OfflineSettingsPageStore this$0, InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv = new OfflineSettingsPageStore$machine$1$2$1(null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(OfflineSettingsPageEvent.ToggleAutoResumptionSwitch.class), executionPolicy$iv, handler$iv);
        BaseBuilderBlock $this$iv2 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv2 = new OfflineSettingsPageStore$machine$1$2$2(this$0, null);
        ExecutionPolicy executionPolicy$iv2 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv2.on(Reflection.getOrCreateKotlinClass(OfflineSettingsPageEvent.ClickOfflineDiagnose.class), executionPolicy$iv2, handler$iv2);
        BaseBuilderBlock $this$iv3 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv3 = new OfflineSettingsPageStore$machine$1$2$3(this$0, null);
        ExecutionPolicy executionPolicy$iv3 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv3.on(Reflection.getOrCreateKotlinClass(OfflineSettingsPageEvent.ClickExternalSDDiagnose.class), executionPolicy$iv3, handler$iv3);
        BaseBuilderBlock $this$iv4 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv4 = new OfflineSettingsPageStore$machine$1$2$4(null);
        ExecutionPolicy executionPolicy$iv4 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv4.on(Reflection.getOrCreateKotlinClass(OfflineSettingsPageEvent.ChangeStorageType.class), executionPolicy$iv4, handler$iv4);
        return Unit.INSTANCE;
    }
}