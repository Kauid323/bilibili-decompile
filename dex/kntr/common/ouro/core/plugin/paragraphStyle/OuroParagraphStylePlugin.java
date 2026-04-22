package kntr.common.ouro.core.plugin.paragraphStyle;

import com.freeletics.flowredux.dsl.BaseBuilderBlock;
import com.freeletics.flowredux.dsl.ConditionBuilderBlock;
import com.freeletics.flowredux.dsl.ExecutionPolicy;
import com.freeletics.flowredux.dsl.FlowReduxStoreBuilder;
import com.freeletics.flowredux.dsl.IdentityBuilderBlock;
import com.freeletics.flowredux.dsl.InStateBuilderBlock;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.OuroState;
import kntr.common.ouro.core.action.OuroAction;
import kntr.common.ouro.core.model.NodeStorage;
import kntr.common.ouro.core.model.NodeStorageBuilder;
import kntr.common.ouro.core.model.OuroNodeStorageKt;
import kntr.common.ouro.core.model.mark.OuroParagraphMark;
import kntr.common.ouro.core.model.node.OuroH1;
import kntr.common.ouro.core.model.node.OuroH2;
import kntr.common.ouro.core.model.node.OuroH3;
import kntr.common.ouro.core.model.node.OuroParagraph;
import kntr.common.ouro.core.model.node.OuroText;
import kntr.common.ouro.core.plugin.OuroPlugin;
import kntr.common.ouro.core.plugin.OuroPluginState;
import kntr.common.ouro.core.plugin.paragraphStyle.OuroParagraphStyleState;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* compiled from: OuroParagraphStylePlugin.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0015\u001a\u00020\u000b*\u00020\u000b2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0002J\u001a\u0010\u0019\u001a\u00020\u000b*\u00020\u000b2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0002J\f\u0010\u001a\u001a\u00020\u000b*\u00020\u000bH\u0002J\f\u0010\u001b\u001a\u00020\u000b*\u00020\u000bH\u0002J\f\u0010\u001c\u001a\u00020\u000b*\u00020\u000bH\u0002J\f\u0010\u001d\u001a\u00020\u000b*\u00020\u000bH\u0002R\u0014\u0010\u0005\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R]\u0010\b\u001aE\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n\u0012 \u0012\u001e\b\u0001\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\t\u0012\u0004\u0012\u00020\u000e0\tj\u0002`\u0011¢\u0006\u0002\b\u00108VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001e"}, d2 = {"Lkntr/common/ouro/core/plugin/paragraphStyle/OuroParagraphStylePlugin;", "Lkntr/common/ouro/core/plugin/OuroPlugin;", "Lkntr/common/ouro/core/plugin/paragraphStyle/OuroParagraphStyleState;", "<init>", "()V", "initState", "getInitState", "()Lkntr/common/ouro/core/plugin/paragraphStyle/OuroParagraphStyleState;", "spec", "Lkotlin/Function2;", "Lcom/freeletics/flowredux/dsl/FlowReduxStoreBuilder;", "Lkntr/common/ouro/core/OuroState;", "Lkntr/common/ouro/core/action/OuroAction;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "Lkntr/common/ouro/core/plugin/OuroPluginSpec;", "getSpec$annotations", "getSpec", "()Lkotlin/jvm/functions/Function2;", "removeParagraphMarks", "marks", "", "Lkntr/common/ouro/core/model/mark/OuroParagraphMark;", "addParagraphMarks", "toH1", "toH2", "toH3", "toText", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class OuroParagraphStylePlugin implements OuroPlugin<OuroParagraphStyleState> {
    public static final OuroParagraphStylePlugin INSTANCE = new OuroParagraphStylePlugin();
    private static final OuroParagraphStyleState initState = new OuroParagraphStyleState.Preview(null, null, 3, null);

    public static /* synthetic */ void getSpec$annotations() {
    }

    private OuroParagraphStylePlugin() {
    }

    @Override // kntr.common.ouro.core.plugin.OuroPlugin
    public OuroParagraphStyleState getInitState() {
        return initState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _get_spec_$lambda$0(FlowReduxStoreBuilder flowReduxStoreBuilder, Function2 it) {
        Intrinsics.checkNotNullParameter(flowReduxStoreBuilder, "<this>");
        Intrinsics.checkNotNullParameter(it, "it");
        Function1 block$iv = new Function1() { // from class: kntr.common.ouro.core.plugin.paragraphStyle.OuroParagraphStylePlugin$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit _get_spec_$lambda$0$0;
                _get_spec_$lambda$0$0 = OuroParagraphStylePlugin._get_spec_$lambda$0$0((InStateBuilderBlock) obj);
                return _get_spec_$lambda$0$0;
            }
        };
        flowReduxStoreBuilder.inState(Reflection.getOrCreateKotlinClass(OuroState.class), block$iv);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _get_spec_$lambda$0$0(InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        $this$inState.untilIdentityChanges(new Function1() { // from class: kntr.common.ouro.core.plugin.paragraphStyle.OuroParagraphStylePlugin$$ExternalSyntheticLambda12
            public final Object invoke(Object obj) {
                Object _get_spec_$lambda$0$0$0;
                _get_spec_$lambda$0$0$0 = OuroParagraphStylePlugin._get_spec_$lambda$0$0$0((OuroState) obj);
                return _get_spec_$lambda$0$0$0;
            }
        }, new Function1() { // from class: kntr.common.ouro.core.plugin.paragraphStyle.OuroParagraphStylePlugin$$ExternalSyntheticLambda13
            public final Object invoke(Object obj) {
                Unit _get_spec_$lambda$0$0$1;
                _get_spec_$lambda$0$0$1 = OuroParagraphStylePlugin._get_spec_$lambda$0$0$1((IdentityBuilderBlock) obj);
                return _get_spec_$lambda$0$0$1;
            }
        });
        $this$inState.condition(new Function1() { // from class: kntr.common.ouro.core.plugin.paragraphStyle.OuroParagraphStylePlugin$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                boolean _get_spec_$lambda$0$0$2;
                _get_spec_$lambda$0$0$2 = OuroParagraphStylePlugin._get_spec_$lambda$0$0$2((OuroState) obj);
                return Boolean.valueOf(_get_spec_$lambda$0$0$2);
            }
        }, new Function1() { // from class: kntr.common.ouro.core.plugin.paragraphStyle.OuroParagraphStylePlugin$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                Unit _get_spec_$lambda$0$0$3;
                _get_spec_$lambda$0$0$3 = OuroParagraphStylePlugin._get_spec_$lambda$0$0$3((ConditionBuilderBlock) obj);
                return _get_spec_$lambda$0$0$3;
            }
        });
        $this$inState.condition(new Function1() { // from class: kntr.common.ouro.core.plugin.paragraphStyle.OuroParagraphStylePlugin$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                boolean _get_spec_$lambda$0$0$4;
                _get_spec_$lambda$0$0$4 = OuroParagraphStylePlugin._get_spec_$lambda$0$0$4((OuroState) obj);
                return Boolean.valueOf(_get_spec_$lambda$0$0$4);
            }
        }, new Function1() { // from class: kntr.common.ouro.core.plugin.paragraphStyle.OuroParagraphStylePlugin$$ExternalSyntheticLambda4
            public final Object invoke(Object obj) {
                Unit _get_spec_$lambda$0$0$5;
                _get_spec_$lambda$0$0$5 = OuroParagraphStylePlugin._get_spec_$lambda$0$0$5((ConditionBuilderBlock) obj);
                return _get_spec_$lambda$0$0$5;
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
    public static final Unit _get_spec_$lambda$0$0$1(IdentityBuilderBlock $this$untilIdentityChanges) {
        Intrinsics.checkNotNullParameter($this$untilIdentityChanges, "$this$untilIdentityChanges");
        $this$untilIdentityChanges.onEnter(new OuroParagraphStylePlugin$spec$1$1$2$1(null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _get_spec_$lambda$0$0$2(OuroState it) {
        Intrinsics.checkNotNullParameter(it, "it");
        KClass key$iv = Reflection.getOrCreateKotlinClass(OuroParagraphStylePlugin.class);
        OuroPluginState ouroPluginState = it.getPluginStates().get(key$iv);
        if (!(ouroPluginState instanceof OuroParagraphStyleState)) {
            ouroPluginState = null;
        }
        OuroParagraphStyleState ouroParagraphStyleState = (OuroParagraphStyleState) ouroPluginState;
        if (ouroParagraphStyleState != null) {
            return ouroParagraphStyleState instanceof OuroParagraphStyleState.Active;
        }
        throw new NoSuchElementException("No plugin state for " + key$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _get_spec_$lambda$0$0$3(ConditionBuilderBlock $this$condition) {
        Intrinsics.checkNotNullParameter($this$condition, "$this$condition");
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) $this$condition;
        Function3 handler$iv = new OuroParagraphStylePlugin$spec$1$1$4$1(null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(OuroToggleTextAlignAction.class), executionPolicy$iv, handler$iv);
        BaseBuilderBlock $this$iv2 = (BaseBuilderBlock) $this$condition;
        Function3 handler$iv2 = new OuroParagraphStylePlugin$spec$1$1$4$2(null);
        ExecutionPolicy executionPolicy$iv2 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv2.on(Reflection.getOrCreateKotlinClass(OuroToggleH1Action.class), executionPolicy$iv2, handler$iv2);
        BaseBuilderBlock $this$iv3 = (BaseBuilderBlock) $this$condition;
        Function3 handler$iv3 = new OuroParagraphStylePlugin$spec$1$1$4$3(null);
        ExecutionPolicy executionPolicy$iv3 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv3.on(Reflection.getOrCreateKotlinClass(OuroToggleH2Action.class), executionPolicy$iv3, handler$iv3);
        BaseBuilderBlock $this$iv4 = (BaseBuilderBlock) $this$condition;
        Function3 handler$iv4 = new OuroParagraphStylePlugin$spec$1$1$4$4(null);
        ExecutionPolicy executionPolicy$iv4 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv4.on(Reflection.getOrCreateKotlinClass(OuroToggleH3Action.class), executionPolicy$iv4, handler$iv4);
        BaseBuilderBlock $this$iv5 = (BaseBuilderBlock) $this$condition;
        Function3 handler$iv5 = new OuroParagraphStylePlugin$spec$1$1$4$5(null);
        ExecutionPolicy executionPolicy$iv5 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv5.on(Reflection.getOrCreateKotlinClass(OuroToggleTextAction.class), executionPolicy$iv5, handler$iv5);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _get_spec_$lambda$0$0$4(OuroState it) {
        Intrinsics.checkNotNullParameter(it, "it");
        KClass key$iv = Reflection.getOrCreateKotlinClass(OuroParagraphStylePlugin.class);
        OuroPluginState ouroPluginState = it.getPluginStates().get(key$iv);
        if (!(ouroPluginState instanceof OuroParagraphStyleState)) {
            ouroPluginState = null;
        }
        OuroParagraphStyleState ouroParagraphStyleState = (OuroParagraphStyleState) ouroPluginState;
        if (ouroParagraphStyleState != null) {
            return ouroParagraphStyleState instanceof OuroParagraphStyleState.Preview;
        }
        throw new NoSuchElementException("No plugin state for " + key$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _get_spec_$lambda$0$0$5(ConditionBuilderBlock $this$condition) {
        Intrinsics.checkNotNullParameter($this$condition, "$this$condition");
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) $this$condition;
        Function3 handler$iv = new OuroParagraphStylePlugin$spec$1$1$6$1(null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(OuroToggleTextAlignAction.class), executionPolicy$iv, handler$iv);
        BaseBuilderBlock $this$iv2 = (BaseBuilderBlock) $this$condition;
        Function3 handler$iv2 = new OuroParagraphStylePlugin$spec$1$1$6$2(null);
        ExecutionPolicy executionPolicy$iv2 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv2.on(Reflection.getOrCreateKotlinClass(OuroToggleParagraphTypeAction.class), executionPolicy$iv2, handler$iv2);
        return Unit.INSTANCE;
    }

    @Override // kntr.common.ouro.core.plugin.OuroPlugin
    public Function2<FlowReduxStoreBuilder<OuroState, OuroAction>, Function2<? super OuroAction, ? super Continuation<? super Unit>, ? extends Object>, Unit> getSpec() {
        return new Function2() { // from class: kntr.common.ouro.core.plugin.paragraphStyle.OuroParagraphStylePlugin$$ExternalSyntheticLambda5
            public final Object invoke(Object obj, Object obj2) {
                Unit _get_spec_$lambda$0;
                _get_spec_$lambda$0 = OuroParagraphStylePlugin._get_spec_$lambda$0((FlowReduxStoreBuilder) obj, (Function2) obj2);
                return _get_spec_$lambda$0;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final OuroState removeParagraphMarks(OuroState $this$removeParagraphMarks, final Collection<? extends OuroParagraphMark> collection) {
        final List elements = OuroNodeStorageKt.getSelectedParagraphs$default($this$removeParagraphMarks.getStorage(), $this$removeParagraphMarks.getSelection(), true, false, 4, null);
        NodeStorage newStorage = NodeStorage.mutate$core_debug$default($this$removeParagraphMarks.getStorage(), false, new Function1() { // from class: kntr.common.ouro.core.plugin.paragraphStyle.OuroParagraphStylePlugin$$ExternalSyntheticLambda10
            public final Object invoke(Object obj) {
                Unit removeParagraphMarks$lambda$0;
                removeParagraphMarks$lambda$0 = OuroParagraphStylePlugin.removeParagraphMarks$lambda$0(elements, collection, (NodeStorageBuilder) obj);
                return removeParagraphMarks$lambda$0;
            }
        }, 1, null);
        return OuroState.copy$default($this$removeParagraphMarks, newStorage, null, null, null, null, 30, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit removeParagraphMarks$lambda$0(List $elements, Collection $marks, NodeStorageBuilder $this$mutate) {
        Intrinsics.checkNotNullParameter($this$mutate, "$this$mutate");
        List $this$forEach$iv = $elements;
        for (Object element$iv : $this$forEach$iv) {
            OuroParagraph paragraph = (OuroParagraph) element$iv;
            List children = $this$mutate.getChildrenOrNull(paragraph);
            OuroParagraph other = paragraph.copyWithMarks(paragraph.getParagraphMarks().minusMarks(CollectionsKt.toSet($marks)));
            $this$mutate.replace(paragraph, other);
            if (children != null) {
                $this$mutate.addChildren(other, children);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final OuroState addParagraphMarks(OuroState $this$addParagraphMarks, final Collection<? extends OuroParagraphMark> collection) {
        final List elements = OuroNodeStorageKt.getSelectedParagraphs$default($this$addParagraphMarks.getStorage(), $this$addParagraphMarks.getSelection(), true, false, 4, null);
        NodeStorage newStorage = NodeStorage.mutate$core_debug$default($this$addParagraphMarks.getStorage(), false, new Function1() { // from class: kntr.common.ouro.core.plugin.paragraphStyle.OuroParagraphStylePlugin$$ExternalSyntheticLambda7
            public final Object invoke(Object obj) {
                Unit addParagraphMarks$lambda$0;
                addParagraphMarks$lambda$0 = OuroParagraphStylePlugin.addParagraphMarks$lambda$0(elements, collection, (NodeStorageBuilder) obj);
                return addParagraphMarks$lambda$0;
            }
        }, 1, null);
        return OuroState.copy$default($this$addParagraphMarks, newStorage, null, null, null, null, 30, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit addParagraphMarks$lambda$0(List $elements, Collection $marks, NodeStorageBuilder $this$mutate) {
        Intrinsics.checkNotNullParameter($this$mutate, "$this$mutate");
        List $this$forEach$iv = $elements;
        for (Object element$iv : $this$forEach$iv) {
            OuroParagraph paragraph = (OuroParagraph) element$iv;
            List children = $this$mutate.getChildrenOrNull(paragraph);
            OuroParagraph other = paragraph.copyWithMarks(paragraph.getParagraphMarks().plus($marks));
            $this$mutate.replace(paragraph, other);
            if (children != null) {
                $this$mutate.addChildren(other, children);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final OuroState toH1(final OuroState $this$toH1) {
        return OuroState.copy$default($this$toH1, NodeStorage.mutate$core_debug$default($this$toH1.getStorage(), false, new Function1() { // from class: kntr.common.ouro.core.plugin.paragraphStyle.OuroParagraphStylePlugin$$ExternalSyntheticLambda11
            public final Object invoke(Object obj) {
                Unit h1$lambda$0;
                h1$lambda$0 = OuroParagraphStylePlugin.toH1$lambda$0(OuroState.this, (NodeStorageBuilder) obj);
                return h1$lambda$0;
            }
        }, 1, null), null, null, null, null, 30, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit toH1$lambda$0(OuroState $this_toH1, NodeStorageBuilder $this$mutate) {
        Intrinsics.checkNotNullParameter($this$mutate, "$this$mutate");
        Iterable paragraphs = OuroNodeStorageKt.getSelectedParagraphs$default($this_toH1.getStorage(), $this_toH1.getSelection(), true, false, 4, null);
        Iterable $this$forEach$iv = paragraphs;
        for (Object element$iv : $this$forEach$iv) {
            OuroParagraph p = (OuroParagraph) element$iv;
            List it = $this$mutate.removeAllChildren(p);
            if (it != null) {
                OuroH1 h = new OuroH1(p.getParagraphMarks());
                $this$mutate.add(h, it);
                $this$mutate.replace(p, h);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final OuroState toH2(final OuroState $this$toH2) {
        return OuroState.copy$default($this$toH2, NodeStorage.mutate$core_debug$default($this$toH2.getStorage(), false, new Function1() { // from class: kntr.common.ouro.core.plugin.paragraphStyle.OuroParagraphStylePlugin$$ExternalSyntheticLambda6
            public final Object invoke(Object obj) {
                Unit h2$lambda$0;
                h2$lambda$0 = OuroParagraphStylePlugin.toH2$lambda$0(OuroState.this, (NodeStorageBuilder) obj);
                return h2$lambda$0;
            }
        }, 1, null), null, null, null, null, 30, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit toH2$lambda$0(OuroState $this_toH2, NodeStorageBuilder $this$mutate) {
        Intrinsics.checkNotNullParameter($this$mutate, "$this$mutate");
        Iterable paragraphs = OuroNodeStorageKt.getSelectedParagraphs$default($this_toH2.getStorage(), $this_toH2.getSelection(), true, false, 4, null);
        Iterable $this$forEach$iv = paragraphs;
        for (Object element$iv : $this$forEach$iv) {
            OuroParagraph p = (OuroParagraph) element$iv;
            List it = $this$mutate.removeAllChildren(p);
            if (it != null) {
                OuroH2 h = new OuroH2(p.getParagraphMarks());
                $this$mutate.add(h, it);
                $this$mutate.replace(p, h);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final OuroState toH3(final OuroState $this$toH3) {
        return OuroState.copy$default($this$toH3, NodeStorage.mutate$core_debug$default($this$toH3.getStorage(), false, new Function1() { // from class: kntr.common.ouro.core.plugin.paragraphStyle.OuroParagraphStylePlugin$$ExternalSyntheticLambda8
            public final Object invoke(Object obj) {
                Unit h3$lambda$0;
                h3$lambda$0 = OuroParagraphStylePlugin.toH3$lambda$0(OuroState.this, (NodeStorageBuilder) obj);
                return h3$lambda$0;
            }
        }, 1, null), null, null, null, null, 30, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit toH3$lambda$0(OuroState $this_toH3, NodeStorageBuilder $this$mutate) {
        Intrinsics.checkNotNullParameter($this$mutate, "$this$mutate");
        Iterable paragraphs = OuroNodeStorageKt.getSelectedParagraphs$default($this_toH3.getStorage(), $this_toH3.getSelection(), true, false, 4, null);
        Iterable $this$forEach$iv = paragraphs;
        for (Object element$iv : $this$forEach$iv) {
            OuroParagraph p = (OuroParagraph) element$iv;
            List it = $this$mutate.removeAllChildren(p);
            if (it != null) {
                OuroH3 h = new OuroH3(p.getParagraphMarks());
                $this$mutate.add(h, it);
                $this$mutate.replace(p, h);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final OuroState toText(final OuroState $this$toText) {
        return OuroState.copy$default($this$toText, NodeStorage.mutate$core_debug$default($this$toText.getStorage(), false, new Function1() { // from class: kntr.common.ouro.core.plugin.paragraphStyle.OuroParagraphStylePlugin$$ExternalSyntheticLambda9
            public final Object invoke(Object obj) {
                Unit text$lambda$0;
                text$lambda$0 = OuroParagraphStylePlugin.toText$lambda$0(OuroState.this, (NodeStorageBuilder) obj);
                return text$lambda$0;
            }
        }, 1, null), null, null, null, null, 30, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit toText$lambda$0(OuroState $this_toText, NodeStorageBuilder $this$mutate) {
        Intrinsics.checkNotNullParameter($this$mutate, "$this$mutate");
        Iterable paragraphs = OuroNodeStorageKt.getSelectedParagraphs$default($this_toText.getStorage(), $this_toText.getSelection(), true, false, 4, null);
        Iterable $this$forEach$iv = paragraphs;
        for (Object element$iv : $this$forEach$iv) {
            OuroParagraph p = (OuroParagraph) element$iv;
            List it = $this$mutate.removeAllChildren(p);
            if (it != null) {
                OuroText h = new OuroText(p.getParagraphMarks());
                $this$mutate.add(h, it);
                $this$mutate.replace(p, h);
            }
        }
        return Unit.INSTANCE;
    }
}