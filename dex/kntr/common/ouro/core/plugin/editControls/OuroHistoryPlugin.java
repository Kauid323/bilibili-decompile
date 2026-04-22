package kntr.common.ouro.core.plugin.editControls;

import com.freeletics.flowredux.dsl.BaseBuilderBlock;
import com.freeletics.flowredux.dsl.ConditionBuilderBlock;
import com.freeletics.flowredux.dsl.ExecutionPolicy;
import com.freeletics.flowredux.dsl.FlowReduxStoreBuilder;
import com.freeletics.flowredux.dsl.IdentityBuilderBlock;
import com.freeletics.flowredux.dsl.InStateBuilderBlock;
import java.util.NoSuchElementException;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.OuroState;
import kntr.common.ouro.core.action.OuroAction;
import kntr.common.ouro.core.plugin.OuroPlugin;
import kntr.common.ouro.core.plugin.OuroPluginState;
import kntr.common.ouro.core.plugin.editControls.OuroHistoryAction;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* compiled from: OuroHistoryPlugin.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00000\tX\u0082\u0004¢\u0006\u0002\n\u0000R]\u0010\n\u001aE\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f\u0012 \u0012\u001e\b\u0001\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u000b\u0012\u0004\u0012\u00020\u00100\u000bj\u0002`\u0013¢\u0006\u0002\b\u00128VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lkntr/common/ouro/core/plugin/editControls/OuroHistoryPlugin;", "Lkntr/common/ouro/core/plugin/OuroPlugin;", "Lkntr/common/ouro/core/plugin/editControls/OuroHistoryState;", "<init>", "()V", "initState", "getInitState", "()Lkntr/common/ouro/core/plugin/editControls/OuroHistoryState;", "key", "Lkotlin/reflect/KClass;", "spec", "Lkotlin/Function2;", "Lcom/freeletics/flowredux/dsl/FlowReduxStoreBuilder;", "Lkntr/common/ouro/core/OuroState;", "Lkntr/common/ouro/core/action/OuroAction;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "Lkntr/common/ouro/core/plugin/OuroPluginSpec;", "getSpec$annotations", "getSpec", "()Lkotlin/jvm/functions/Function2;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class OuroHistoryPlugin implements OuroPlugin<OuroHistoryState> {
    public static final OuroHistoryPlugin INSTANCE = new OuroHistoryPlugin();
    private static final KClass<OuroHistoryPlugin> key = Reflection.getOrCreateKotlinClass(OuroHistoryPlugin.class);

    public static /* synthetic */ void getSpec$annotations() {
    }

    private OuroHistoryPlugin() {
    }

    @Override // kntr.common.ouro.core.plugin.OuroPlugin
    public OuroHistoryState getInitState() {
        return new OuroHistoryState(null, null, null, 7, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _get_spec_$lambda$0(FlowReduxStoreBuilder flowReduxStoreBuilder, Function2 it) {
        Intrinsics.checkNotNullParameter(flowReduxStoreBuilder, "<this>");
        Intrinsics.checkNotNullParameter(it, "it");
        Function1 block$iv = new Function1() { // from class: kntr.common.ouro.core.plugin.editControls.OuroHistoryPlugin$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit _get_spec_$lambda$0$0;
                _get_spec_$lambda$0$0 = OuroHistoryPlugin._get_spec_$lambda$0$0((InStateBuilderBlock) obj);
                return _get_spec_$lambda$0$0;
            }
        };
        flowReduxStoreBuilder.inState(Reflection.getOrCreateKotlinClass(OuroState.class), block$iv);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _get_spec_$lambda$0$0(InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        $this$inState.untilIdentityChanges(new Function1() { // from class: kntr.common.ouro.core.plugin.editControls.OuroHistoryPlugin$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Object _get_spec_$lambda$0$0$0;
                _get_spec_$lambda$0$0$0 = OuroHistoryPlugin._get_spec_$lambda$0$0$0((OuroState) obj);
                return _get_spec_$lambda$0$0$0;
            }
        }, new Function1() { // from class: kntr.common.ouro.core.plugin.editControls.OuroHistoryPlugin$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                Unit _get_spec_$lambda$0$0$1;
                _get_spec_$lambda$0$0$1 = OuroHistoryPlugin._get_spec_$lambda$0$0$1((IdentityBuilderBlock) obj);
                return _get_spec_$lambda$0$0$1;
            }
        });
        $this$inState.condition(new Function1() { // from class: kntr.common.ouro.core.plugin.editControls.OuroHistoryPlugin$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                boolean _get_spec_$lambda$0$0$2;
                _get_spec_$lambda$0$0$2 = OuroHistoryPlugin._get_spec_$lambda$0$0$2((OuroState) obj);
                return Boolean.valueOf(_get_spec_$lambda$0$0$2);
            }
        }, new Function1() { // from class: kntr.common.ouro.core.plugin.editControls.OuroHistoryPlugin$$ExternalSyntheticLambda4
            public final Object invoke(Object obj) {
                Unit _get_spec_$lambda$0$0$3;
                _get_spec_$lambda$0$0$3 = OuroHistoryPlugin._get_spec_$lambda$0$0$3((ConditionBuilderBlock) obj);
                return _get_spec_$lambda$0$0$3;
            }
        });
        $this$inState.condition(new Function1() { // from class: kntr.common.ouro.core.plugin.editControls.OuroHistoryPlugin$$ExternalSyntheticLambda5
            public final Object invoke(Object obj) {
                boolean _get_spec_$lambda$0$0$4;
                _get_spec_$lambda$0$0$4 = OuroHistoryPlugin._get_spec_$lambda$0$0$4((OuroState) obj);
                return Boolean.valueOf(_get_spec_$lambda$0$0$4);
            }
        }, new Function1() { // from class: kntr.common.ouro.core.plugin.editControls.OuroHistoryPlugin$$ExternalSyntheticLambda6
            public final Object invoke(Object obj) {
                Unit _get_spec_$lambda$0$0$5;
                _get_spec_$lambda$0$0$5 = OuroHistoryPlugin._get_spec_$lambda$0$0$5((ConditionBuilderBlock) obj);
                return _get_spec_$lambda$0$0$5;
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object _get_spec_$lambda$0$0$0(OuroState it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return TuplesKt.to(it.getStorage(), it.getCompositionRange());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _get_spec_$lambda$0$0$1(IdentityBuilderBlock $this$untilIdentityChanges) {
        Intrinsics.checkNotNullParameter($this$untilIdentityChanges, "$this$untilIdentityChanges");
        $this$untilIdentityChanges.onEnter(new OuroHistoryPlugin$spec$1$1$2$1(null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _get_spec_$lambda$0$0$2(OuroState it) {
        Intrinsics.checkNotNullParameter(it, "it");
        KClass key$iv = key;
        OuroPluginState ouroPluginState = it.getPluginStates().get(key$iv);
        if (!(ouroPluginState instanceof OuroHistoryState)) {
            ouroPluginState = null;
        }
        OuroHistoryState ouroHistoryState = (OuroHistoryState) ouroPluginState;
        if (ouroHistoryState != null) {
            return ouroHistoryState.canUndo();
        }
        throw new NoSuchElementException("No plugin state for " + key$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _get_spec_$lambda$0$0$3(ConditionBuilderBlock $this$condition) {
        Intrinsics.checkNotNullParameter($this$condition, "$this$condition");
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) $this$condition;
        Function3 handler$iv = new OuroHistoryPlugin$spec$1$1$4$1(null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(OuroHistoryAction.Undo.class), executionPolicy$iv, handler$iv);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _get_spec_$lambda$0$0$4(OuroState it) {
        Intrinsics.checkNotNullParameter(it, "it");
        KClass key$iv = key;
        OuroPluginState ouroPluginState = it.getPluginStates().get(key$iv);
        if (!(ouroPluginState instanceof OuroHistoryState)) {
            ouroPluginState = null;
        }
        OuroHistoryState ouroHistoryState = (OuroHistoryState) ouroPluginState;
        if (ouroHistoryState != null) {
            return ouroHistoryState.canRedo();
        }
        throw new NoSuchElementException("No plugin state for " + key$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _get_spec_$lambda$0$0$5(ConditionBuilderBlock $this$condition) {
        Intrinsics.checkNotNullParameter($this$condition, "$this$condition");
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) $this$condition;
        Function3 handler$iv = new OuroHistoryPlugin$spec$1$1$6$1(null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(OuroHistoryAction.Redo.class), executionPolicy$iv, handler$iv);
        return Unit.INSTANCE;
    }

    @Override // kntr.common.ouro.core.plugin.OuroPlugin
    public Function2<FlowReduxStoreBuilder<OuroState, OuroAction>, Function2<? super OuroAction, ? super Continuation<? super Unit>, ? extends Object>, Unit> getSpec() {
        return new Function2() { // from class: kntr.common.ouro.core.plugin.editControls.OuroHistoryPlugin$$ExternalSyntheticLambda7
            public final Object invoke(Object obj, Object obj2) {
                Unit _get_spec_$lambda$0;
                _get_spec_$lambda$0 = OuroHistoryPlugin._get_spec_$lambda$0((FlowReduxStoreBuilder) obj, (Function2) obj2);
                return _get_spec_$lambda$0;
            }
        };
    }
}