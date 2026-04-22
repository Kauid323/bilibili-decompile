package kntr.common.ouro.core;

import com.freeletics.flowredux.dsl.FlowReduxStateMachine;
import com.freeletics.flowredux.dsl.FlowReduxStoreBuilder;
import com.freeletics.flowredux.dsl.InStateBuilderBlock;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.action.OuroAction;
import kntr.common.ouro.core.di.OuroInitialState;
import kntr.common.ouro.core.di.OuroScope;
import kntr.common.ouro.core.plugin.OuroPlugin;
import kntr.common.ouro.core.plugin.OuroPluginState;
import kntr.common.ouro.core.reducer.OuroCommonReudcerKt;
import kntr.common.ouro.core.reducer.OuroEditActionReducerKt;
import kntr.common.ouro.core.reducer.OuroHierarchyActionReducerKt;
import kntr.common.ouro.core.reducer.OuroTextMarkReducerKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;

/* compiled from: OuroStateMachine.kt */
@OuroScope
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B,\b\u0007\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0002\u0012\u0017\u0010\u0005\u001a\u0013\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\b\t0\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\f\u001a\u00020\r*\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000eH\u0002J,\u0010\f\u001a\u00020\r*\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000e2\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006H\u0002¨\u0006\u000f"}, d2 = {"Lkntr/common/ouro/core/OuroStateMachine;", "Lcom/freeletics/flowredux/dsl/FlowReduxStateMachine;", "Lkntr/common/ouro/core/OuroState;", "Lkntr/common/ouro/core/action/OuroAction;", "initialState", "plugins", "", "Lkntr/common/ouro/core/plugin/OuroPlugin;", "Lkntr/common/ouro/core/plugin/OuroPluginState;", "Lkotlin/jvm/JvmSuppressWildcards;", "<init>", "(Lkntr/common/ouro/core/OuroState;Ljava/util/Set;)V", "build", "", "Lcom/freeletics/flowredux/dsl/FlowReduxStoreBuilder;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class OuroStateMachine extends FlowReduxStateMachine<OuroState, OuroAction> {
    /* JADX WARN: Illegal instructions before constructor call */
    @Inject
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public OuroStateMachine(@OuroInitialState OuroState initialState, final Set<OuroPlugin<OuroPluginState>> set) {
        super(OuroState.copy$default(initialState, null, null, null, null, destination$iv$iv, 15, null));
        Intrinsics.checkNotNullParameter(initialState, "initialState");
        Intrinsics.checkNotNullParameter(set, "plugins");
        Set<OuroPlugin<OuroPluginState>> $this$associate$iv = set;
        int capacity$iv = RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associate$iv, 10)), 16);
        Map destination$iv$iv = new LinkedHashMap(capacity$iv);
        for (Object element$iv$iv : $this$associate$iv) {
            OuroPlugin it = (OuroPlugin) element$iv$iv;
            Pair pair = TuplesKt.to(Reflection.getOrCreateKotlinClass(it.getClass()), it.getInitState());
            destination$iv$iv.put(pair.getFirst(), pair.getSecond());
        }
        spec(new Function1() { // from class: kntr.common.ouro.core.OuroStateMachine$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit _init_$lambda$1;
                _init_$lambda$1 = OuroStateMachine._init_$lambda$1(OuroStateMachine.this, set, (FlowReduxStoreBuilder) obj);
                return _init_$lambda$1;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$1(OuroStateMachine this$0, Set $plugins, FlowReduxStoreBuilder $this$spec) {
        Intrinsics.checkNotNullParameter($this$spec, "$this$spec");
        this$0.build($this$spec);
        this$0.build($this$spec, $plugins);
        return Unit.INSTANCE;
    }

    private final void build(FlowReduxStoreBuilder<OuroState, OuroAction> flowReduxStoreBuilder) {
        Function1 block$iv = new Function1() { // from class: kntr.common.ouro.core.OuroStateMachine$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                Unit build$lambda$0;
                build$lambda$0 = OuroStateMachine.build$lambda$0((InStateBuilderBlock) obj);
                return build$lambda$0;
            }
        };
        flowReduxStoreBuilder.inState(Reflection.getOrCreateKotlinClass(OuroState.class), block$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit build$lambda$0(InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        OuroCommonReudcerKt.onCommonAction($this$inState);
        OuroTextMarkReducerKt.onTextMarkAction($this$inState);
        OuroEditActionReducerKt.onEditAction($this$inState);
        OuroHierarchyActionReducerKt.onHierarchyAction($this$inState);
        return Unit.INSTANCE;
    }

    private final void build(final FlowReduxStoreBuilder<OuroState, OuroAction> flowReduxStoreBuilder, final Set<? extends OuroPlugin<OuroPluginState>> set) {
        Function1 block$iv = new Function1() { // from class: kntr.common.ouro.core.OuroStateMachine$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit build$lambda$1;
                build$lambda$1 = OuroStateMachine.build$lambda$1(set, flowReduxStoreBuilder, this, (InStateBuilderBlock) obj);
                return build$lambda$1;
            }
        };
        flowReduxStoreBuilder.inState(Reflection.getOrCreateKotlinClass(OuroState.class), block$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit build$lambda$1(Set $plugins, FlowReduxStoreBuilder $this_build, OuroStateMachine this$0, InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        Set $this$forEach$iv = $plugins;
        for (Object element$iv : $this$forEach$iv) {
            OuroPlugin plugin = (OuroPlugin) element$iv;
            plugin.getSpec().invoke($this_build, new OuroStateMachine$build$2$1$1(this$0, null));
        }
        return Unit.INSTANCE;
    }
}