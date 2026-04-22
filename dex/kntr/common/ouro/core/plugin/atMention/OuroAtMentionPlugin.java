package kntr.common.ouro.core.plugin.atMention;

import com.freeletics.flowredux.dsl.BaseBuilderBlock;
import com.freeletics.flowredux.dsl.ConditionBuilderBlock;
import com.freeletics.flowredux.dsl.ExecutionPolicy;
import com.freeletics.flowredux.dsl.FlowReduxStoreBuilder;
import com.freeletics.flowredux.dsl.IdentityBuilderBlock;
import com.freeletics.flowredux.dsl.InStateBuilderBlock;
import java.util.Map;
import java.util.NoSuchElementException;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.OuroState;
import kntr.common.ouro.core.action.OuroAction;
import kntr.common.ouro.core.model.mark.OuroColor;
import kntr.common.ouro.core.plugin.OuroPlugin;
import kntr.common.ouro.core.plugin.OuroPluginState;
import kntr.common.ouro.core.plugin.atMention.OuroAtMentionAction;
import kntr.common.ouro.core.plugin.atMention.OuroAtMentionState;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* compiled from: OuroAtMentionPlugin.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u001a\u001a\u0004\u0018\u00010\u0002*\u00020\u000fH\u0002J\u0014\u0010\u001b\u001a\u00020\u000f*\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u0002H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR]\u0010\f\u001aE\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e\u0012 \u0012\u001e\b\u0001\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00130\r\u0012\u0004\u0012\u00020\u00120\rj\u0002`\u0015¢\u0006\u0002\b\u00148VX\u0096\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001d"}, d2 = {"Lkntr/common/ouro/core/plugin/atMention/OuroAtMentionPlugin;", "Lkntr/common/ouro/core/plugin/OuroPlugin;", "Lkntr/common/ouro/core/plugin/atMention/OuroAtMentionState;", "atMentionService", "Lkntr/common/ouro/core/plugin/atMention/AtMentionService;", "fontColor", "Lkntr/common/ouro/core/model/mark/OuroColor;", "<init>", "(Lkntr/common/ouro/core/plugin/atMention/AtMentionService;Lkntr/common/ouro/core/model/mark/OuroColor;)V", "initState", "getInitState", "()Lkntr/common/ouro/core/plugin/atMention/OuroAtMentionState;", "spec", "Lkotlin/Function2;", "Lcom/freeletics/flowredux/dsl/FlowReduxStoreBuilder;", "Lkntr/common/ouro/core/OuroState;", "Lkntr/common/ouro/core/action/OuroAction;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "Lkntr/common/ouro/core/plugin/OuroPluginSpec;", "getSpec$annotations", "()V", "getSpec", "()Lkotlin/jvm/functions/Function2;", "currentState", "copy", "newState", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class OuroAtMentionPlugin implements OuroPlugin<OuroAtMentionState> {
    private final AtMentionService atMentionService;
    private final OuroColor fontColor;

    public static /* synthetic */ void getSpec$annotations() {
    }

    public OuroAtMentionPlugin(AtMentionService atMentionService, OuroColor fontColor) {
        Intrinsics.checkNotNullParameter(atMentionService, "atMentionService");
        Intrinsics.checkNotNullParameter(fontColor, "fontColor");
        this.atMentionService = atMentionService;
        this.fontColor = fontColor;
    }

    @Override // kntr.common.ouro.core.plugin.OuroPlugin
    public OuroAtMentionState getInitState() {
        return OuroAtMentionState.Idle.INSTANCE;
    }

    @Override // kntr.common.ouro.core.plugin.OuroPlugin
    public Function2<FlowReduxStoreBuilder<OuroState, OuroAction>, Function2<? super OuroAction, ? super Continuation<? super Unit>, ? extends Object>, Unit> getSpec() {
        return new Function2() { // from class: kntr.common.ouro.core.plugin.atMention.OuroAtMentionPlugin$$ExternalSyntheticLambda0
            public final Object invoke(Object obj, Object obj2) {
                Unit _get_spec_$lambda$0;
                _get_spec_$lambda$0 = OuroAtMentionPlugin._get_spec_$lambda$0(OuroAtMentionPlugin.this, (FlowReduxStoreBuilder) obj, (Function2) obj2);
                return _get_spec_$lambda$0;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _get_spec_$lambda$0(final OuroAtMentionPlugin this$0, FlowReduxStoreBuilder flowReduxStoreBuilder, Function2 it) {
        Intrinsics.checkNotNullParameter(flowReduxStoreBuilder, "<this>");
        Intrinsics.checkNotNullParameter(it, "it");
        Function1 block$iv = new Function1() { // from class: kntr.common.ouro.core.plugin.atMention.OuroAtMentionPlugin$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit _get_spec_$lambda$0$0;
                _get_spec_$lambda$0$0 = OuroAtMentionPlugin._get_spec_$lambda$0$0(OuroAtMentionPlugin.this, (InStateBuilderBlock) obj);
                return _get_spec_$lambda$0$0;
            }
        };
        flowReduxStoreBuilder.inState(Reflection.getOrCreateKotlinClass(OuroState.class), block$iv);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _get_spec_$lambda$0$0(final OuroAtMentionPlugin this$0, InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        $this$inState.untilIdentityChanges(new Function1() { // from class: kntr.common.ouro.core.plugin.atMention.OuroAtMentionPlugin$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                Object _get_spec_$lambda$0$0$0;
                _get_spec_$lambda$0$0$0 = OuroAtMentionPlugin._get_spec_$lambda$0$0$0((OuroState) obj);
                return _get_spec_$lambda$0$0$0;
            }
        }, new Function1() { // from class: kntr.common.ouro.core.plugin.atMention.OuroAtMentionPlugin$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                Unit _get_spec_$lambda$0$0$1;
                _get_spec_$lambda$0$0$1 = OuroAtMentionPlugin._get_spec_$lambda$0$0$1(OuroAtMentionPlugin.this, (IdentityBuilderBlock) obj);
                return _get_spec_$lambda$0$0$1;
            }
        });
        $this$inState.untilIdentityChanges(new Function1() { // from class: kntr.common.ouro.core.plugin.atMention.OuroAtMentionPlugin$$ExternalSyntheticLambda4
            public final Object invoke(Object obj) {
                Object _get_spec_$lambda$0$0$2;
                _get_spec_$lambda$0$0$2 = OuroAtMentionPlugin._get_spec_$lambda$0$0$2(OuroAtMentionPlugin.this, (OuroState) obj);
                return _get_spec_$lambda$0$0$2;
            }
        }, new Function1() { // from class: kntr.common.ouro.core.plugin.atMention.OuroAtMentionPlugin$$ExternalSyntheticLambda5
            public final Object invoke(Object obj) {
                Unit _get_spec_$lambda$0$0$3;
                _get_spec_$lambda$0$0$3 = OuroAtMentionPlugin._get_spec_$lambda$0$0$3(OuroAtMentionPlugin.this, (IdentityBuilderBlock) obj);
                return _get_spec_$lambda$0$0$3;
            }
        });
        $this$inState.condition(new Function1() { // from class: kntr.common.ouro.core.plugin.atMention.OuroAtMentionPlugin$$ExternalSyntheticLambda6
            public final Object invoke(Object obj) {
                boolean _get_spec_$lambda$0$0$4;
                _get_spec_$lambda$0$0$4 = OuroAtMentionPlugin._get_spec_$lambda$0$0$4(OuroAtMentionPlugin.this, (OuroState) obj);
                return Boolean.valueOf(_get_spec_$lambda$0$0$4);
            }
        }, new Function1() { // from class: kntr.common.ouro.core.plugin.atMention.OuroAtMentionPlugin$$ExternalSyntheticLambda7
            public final Object invoke(Object obj) {
                Unit _get_spec_$lambda$0$0$5;
                _get_spec_$lambda$0$0$5 = OuroAtMentionPlugin._get_spec_$lambda$0$0$5(OuroAtMentionPlugin.this, (ConditionBuilderBlock) obj);
                return _get_spec_$lambda$0$0$5;
            }
        });
        $this$inState.condition(new Function1() { // from class: kntr.common.ouro.core.plugin.atMention.OuroAtMentionPlugin$$ExternalSyntheticLambda8
            public final Object invoke(Object obj) {
                boolean _get_spec_$lambda$0$0$6;
                _get_spec_$lambda$0$0$6 = OuroAtMentionPlugin._get_spec_$lambda$0$0$6(OuroAtMentionPlugin.this, (OuroState) obj);
                return Boolean.valueOf(_get_spec_$lambda$0$0$6);
            }
        }, new Function1() { // from class: kntr.common.ouro.core.plugin.atMention.OuroAtMentionPlugin$$ExternalSyntheticLambda9
            public final Object invoke(Object obj) {
                Unit _get_spec_$lambda$0$0$7;
                _get_spec_$lambda$0$0$7 = OuroAtMentionPlugin._get_spec_$lambda$0$0$7(OuroAtMentionPlugin.this, (ConditionBuilderBlock) obj);
                return _get_spec_$lambda$0$0$7;
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object _get_spec_$lambda$0$0$0(OuroState it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return TuplesKt.to(it.getStorage(), it.getTextRange());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _get_spec_$lambda$0$0$1(OuroAtMentionPlugin this$0, IdentityBuilderBlock $this$untilIdentityChanges) {
        Intrinsics.checkNotNullParameter($this$untilIdentityChanges, "$this$untilIdentityChanges");
        $this$untilIdentityChanges.onEnter(new OuroAtMentionPlugin$spec$1$1$2$1(this$0, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object _get_spec_$lambda$0$0$2(OuroAtMentionPlugin this$0, OuroState it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return this$0.currentState(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _get_spec_$lambda$0$0$3(OuroAtMentionPlugin this$0, IdentityBuilderBlock $this$untilIdentityChanges) {
        Intrinsics.checkNotNullParameter($this$untilIdentityChanges, "$this$untilIdentityChanges");
        $this$untilIdentityChanges.onEnter(new OuroAtMentionPlugin$spec$1$1$4$1(this$0, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _get_spec_$lambda$0$0$4(OuroAtMentionPlugin this$0, OuroState it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return this$0.currentState(it) instanceof OuroAtMentionState.Error;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _get_spec_$lambda$0$0$5(OuroAtMentionPlugin this$0, ConditionBuilderBlock $this$condition) {
        Intrinsics.checkNotNullParameter($this$condition, "$this$condition");
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) $this$condition;
        Function3 handler$iv = new OuroAtMentionPlugin$spec$1$1$6$1(this$0, null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(OuroAtMentionAction.Retry.class), executionPolicy$iv, handler$iv);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _get_spec_$lambda$0$0$6(OuroAtMentionPlugin this$0, OuroState it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return this$0.currentState(it) instanceof OuroAtMentionState.ShowContent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _get_spec_$lambda$0$0$7(OuroAtMentionPlugin this$0, ConditionBuilderBlock $this$condition) {
        Intrinsics.checkNotNullParameter($this$condition, "$this$condition");
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) $this$condition;
        Function3 handler$iv = new OuroAtMentionPlugin$spec$1$1$8$1(this$0, null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(OuroAtMentionAction.SelectUser.class), executionPolicy$iv, handler$iv);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final OuroAtMentionState currentState(OuroState $this$currentState) {
        KClass key$iv = Reflection.getOrCreateKotlinClass(OuroAtMentionPlugin.class);
        OuroPluginState ouroPluginState = $this$currentState.getPluginStates().get(key$iv);
        if (!(ouroPluginState instanceof OuroAtMentionState)) {
            ouroPluginState = null;
        }
        OuroAtMentionState ouroAtMentionState = (OuroAtMentionState) ouroPluginState;
        if (ouroAtMentionState != null) {
            return ouroAtMentionState;
        }
        throw new NoSuchElementException("No plugin state for " + key$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final OuroState copy(OuroState $this$copy, OuroAtMentionState newState) {
        KClass forKey$iv = Reflection.getOrCreateKotlinClass(OuroAtMentionPlugin.class);
        Map newPluginStates$iv = MapsKt.toMutableMap($this$copy.getPluginStates());
        newPluginStates$iv.put(forKey$iv, newState);
        return OuroState.copy$default($this$copy, null, null, null, null, MapsKt.toMap(newPluginStates$iv), 15, null);
    }
}