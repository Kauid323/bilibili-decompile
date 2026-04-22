package kntr.common.ouro.core.plugin.textStyle;

import com.freeletics.flowredux.dsl.BaseBuilderBlock;
import com.freeletics.flowredux.dsl.ConditionBuilderBlock;
import com.freeletics.flowredux.dsl.ExecutionPolicy;
import com.freeletics.flowredux.dsl.FlowReduxStoreBuilder;
import com.freeletics.flowredux.dsl.IdentityBuilderBlock;
import com.freeletics.flowredux.dsl.InStateBuilderBlock;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.OuroState;
import kntr.common.ouro.core.action.OuroAction;
import kntr.common.ouro.core.model.NodeStorage;
import kntr.common.ouro.core.model.NodeStorageBuilder;
import kntr.common.ouro.core.model.OuroSelection;
import kntr.common.ouro.core.model.mark.OuroBackgroundColorMark;
import kntr.common.ouro.core.model.mark.OuroForegroundColorMark;
import kntr.common.ouro.core.model.mark.OuroMark;
import kntr.common.ouro.core.model.mark.OuroTextMark;
import kntr.common.ouro.core.model.node.OuroLink;
import kntr.common.ouro.core.model.node.OuroListItem;
import kntr.common.ouro.core.model.node.OuroNode;
import kntr.common.ouro.core.model.node.OuroParagraph;
import kntr.common.ouro.core.model.node.OuroTextElement;
import kntr.common.ouro.core.model.node.drawable.OuroInlineContent;
import kntr.common.ouro.core.plugin.OuroPlugin;
import kntr.common.ouro.core.plugin.OuroPluginState;
import kntr.common.ouro.core.plugin.textStyle.OuroTextStyleState;
import kntr.common.ouro.core.utils.OuroNodeStorageUtilsKt;
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

/* compiled from: OuroTextStylePlugin.kt */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001e\u0010\u0015\u001a\u00020\u000b*\u00020\u000b2\u0010\u0010\u0016\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00180\u0017H\u0002J\u001a\u0010\u0019\u001a\u00020\u000b*\u00020\u000b2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0017H\u0002J,\u0010\u001c\u001a\u00020\u000e*\u0006\u0012\u0002\b\u00030\u001d2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00172\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 H\u0002J0\u0010\"\u001a\u00020\u000e*\u0006\u0012\u0002\b\u00030\u001d2\u0010\u0010\u0016\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00180\u00172\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 H\u0002J$\u0010#\u001a\b\u0012\u0004\u0012\u00020!0 *\u0006\u0012\u0002\b\u00030\u001d2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020%0 H\u0002R\u0014\u0010\u0005\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R]\u0010\b\u001aE\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n\u0012 \u0012\u001e\b\u0001\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\t\u0012\u0004\u0012\u00020\u000e0\tj\u0002`\u0011¢\u0006\u0002\b\u00108VX\u0096\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0014¨\u0006&"}, d2 = {"Lkntr/common/ouro/core/plugin/textStyle/OuroTextStylePlugin;", "Lkntr/common/ouro/core/plugin/OuroPlugin;", "Lkntr/common/ouro/core/plugin/textStyle/OuroTextStyleState;", "<init>", "()V", "initState", "getInitState", "()Lkntr/common/ouro/core/plugin/textStyle/OuroTextStyleState;", "spec", "Lkotlin/Function2;", "Lcom/freeletics/flowredux/dsl/FlowReduxStoreBuilder;", "Lkntr/common/ouro/core/OuroState;", "Lkntr/common/ouro/core/action/OuroAction;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "Lkntr/common/ouro/core/plugin/OuroPluginSpec;", "getSpec$annotations", "getSpec", "()Lkotlin/jvm/functions/Function2;", "removeTextMarksByKeys", "keys", "", "Lkntr/common/ouro/core/model/mark/OuroMark$Key;", "addMarks", "marks", "Lkntr/common/ouro/core/model/mark/OuroMark;", "applyTextMarkToListItem", "Lkntr/common/ouro/core/model/NodeStorageBuilder;", "Lkntr/common/ouro/core/model/mark/OuroTextMark;", "listItems", "", "Lkntr/common/ouro/core/model/node/OuroListItem;", "removeTextMarkToListItem", "getCompletelySelectedListItems", "textList", "Lkntr/common/ouro/core/model/node/OuroTextElement;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class OuroTextStylePlugin implements OuroPlugin<OuroTextStyleState> {
    public static final OuroTextStylePlugin INSTANCE = new OuroTextStylePlugin();
    private static final OuroTextStyleState initState = new OuroTextStyleState.Preview(null, null, 3, null);

    public static /* synthetic */ void getSpec$annotations() {
    }

    private OuroTextStylePlugin() {
    }

    @Override // kntr.common.ouro.core.plugin.OuroPlugin
    public OuroTextStyleState getInitState() {
        return initState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _get_spec_$lambda$0(FlowReduxStoreBuilder flowReduxStoreBuilder, Function2 it) {
        Intrinsics.checkNotNullParameter(flowReduxStoreBuilder, "<this>");
        Intrinsics.checkNotNullParameter(it, "it");
        Function1 block$iv = new Function1() { // from class: kntr.common.ouro.core.plugin.textStyle.OuroTextStylePlugin$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit _get_spec_$lambda$0$0;
                _get_spec_$lambda$0$0 = OuroTextStylePlugin._get_spec_$lambda$0$0((InStateBuilderBlock) obj);
                return _get_spec_$lambda$0$0;
            }
        };
        flowReduxStoreBuilder.inState(Reflection.getOrCreateKotlinClass(OuroState.class), block$iv);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _get_spec_$lambda$0$0(InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        $this$inState.untilIdentityChanges(new Function1() { // from class: kntr.common.ouro.core.plugin.textStyle.OuroTextStylePlugin$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                Object _get_spec_$lambda$0$0$0;
                _get_spec_$lambda$0$0$0 = OuroTextStylePlugin._get_spec_$lambda$0$0$0((OuroState) obj);
                return _get_spec_$lambda$0$0$0;
            }
        }, new Function1() { // from class: kntr.common.ouro.core.plugin.textStyle.OuroTextStylePlugin$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                Unit _get_spec_$lambda$0$0$1;
                _get_spec_$lambda$0$0$1 = OuroTextStylePlugin._get_spec_$lambda$0$0$1((IdentityBuilderBlock) obj);
                return _get_spec_$lambda$0$0$1;
            }
        });
        $this$inState.condition(new Function1() { // from class: kntr.common.ouro.core.plugin.textStyle.OuroTextStylePlugin$$ExternalSyntheticLambda4
            public final Object invoke(Object obj) {
                boolean _get_spec_$lambda$0$0$2;
                _get_spec_$lambda$0$0$2 = OuroTextStylePlugin._get_spec_$lambda$0$0$2((OuroState) obj);
                return Boolean.valueOf(_get_spec_$lambda$0$0$2);
            }
        }, new Function1() { // from class: kntr.common.ouro.core.plugin.textStyle.OuroTextStylePlugin$$ExternalSyntheticLambda5
            public final Object invoke(Object obj) {
                Unit _get_spec_$lambda$0$0$3;
                _get_spec_$lambda$0$0$3 = OuroTextStylePlugin._get_spec_$lambda$0$0$3((ConditionBuilderBlock) obj);
                return _get_spec_$lambda$0$0$3;
            }
        });
        $this$inState.condition(new Function1() { // from class: kntr.common.ouro.core.plugin.textStyle.OuroTextStylePlugin$$ExternalSyntheticLambda6
            public final Object invoke(Object obj) {
                boolean _get_spec_$lambda$0$0$4;
                _get_spec_$lambda$0$0$4 = OuroTextStylePlugin._get_spec_$lambda$0$0$4((OuroState) obj);
                return Boolean.valueOf(_get_spec_$lambda$0$0$4);
            }
        }, new Function1() { // from class: kntr.common.ouro.core.plugin.textStyle.OuroTextStylePlugin$$ExternalSyntheticLambda7
            public final Object invoke(Object obj) {
                Unit _get_spec_$lambda$0$0$5;
                _get_spec_$lambda$0$0$5 = OuroTextStylePlugin._get_spec_$lambda$0$0$5((ConditionBuilderBlock) obj);
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
        $this$untilIdentityChanges.onEnter(new OuroTextStylePlugin$spec$1$1$2$1(null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _get_spec_$lambda$0$0$2(OuroState it) {
        Intrinsics.checkNotNullParameter(it, "it");
        KClass key$iv = Reflection.getOrCreateKotlinClass(OuroTextStylePlugin.class);
        OuroPluginState ouroPluginState = it.getPluginStates().get(key$iv);
        if (!(ouroPluginState instanceof OuroTextStyleState)) {
            ouroPluginState = null;
        }
        OuroTextStyleState ouroTextStyleState = (OuroTextStyleState) ouroPluginState;
        if (ouroTextStyleState != null) {
            return ouroTextStyleState instanceof OuroTextStyleState.Active;
        }
        throw new NoSuchElementException("No plugin state for " + key$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _get_spec_$lambda$0$0$3(ConditionBuilderBlock $this$condition) {
        Intrinsics.checkNotNullParameter($this$condition, "$this$condition");
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) $this$condition;
        Function3 handler$iv = new OuroTextStylePlugin$spec$1$1$4$1(null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(OuroToggleBoldAction.class), executionPolicy$iv, handler$iv);
        BaseBuilderBlock $this$iv2 = (BaseBuilderBlock) $this$condition;
        Function3 handler$iv2 = new OuroTextStylePlugin$spec$1$1$4$2(null);
        ExecutionPolicy executionPolicy$iv2 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv2.on(Reflection.getOrCreateKotlinClass(OuroToggleItalicAction.class), executionPolicy$iv2, handler$iv2);
        BaseBuilderBlock $this$iv3 = (BaseBuilderBlock) $this$condition;
        Function3 handler$iv3 = new OuroTextStylePlugin$spec$1$1$4$3(null);
        ExecutionPolicy executionPolicy$iv3 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv3.on(Reflection.getOrCreateKotlinClass(OuroToggleUnderlineAction.class), executionPolicy$iv3, handler$iv3);
        BaseBuilderBlock $this$iv4 = (BaseBuilderBlock) $this$condition;
        Function3 handler$iv4 = new OuroTextStylePlugin$spec$1$1$4$4(null);
        ExecutionPolicy executionPolicy$iv4 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv4.on(Reflection.getOrCreateKotlinClass(OuroToggleStrikethroughAction.class), executionPolicy$iv4, handler$iv4);
        BaseBuilderBlock $this$iv5 = (BaseBuilderBlock) $this$condition;
        Function3 handler$iv5 = new OuroTextStylePlugin$spec$1$1$4$5(null);
        ExecutionPolicy executionPolicy$iv5 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv5.on(Reflection.getOrCreateKotlinClass(OuroChangeForegroundColor.class), executionPolicy$iv5, handler$iv5);
        BaseBuilderBlock $this$iv6 = (BaseBuilderBlock) $this$condition;
        Function3 handler$iv6 = new OuroTextStylePlugin$spec$1$1$4$6(null);
        ExecutionPolicy executionPolicy$iv6 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv6.on(Reflection.getOrCreateKotlinClass(OuroChangeBackgroundColor.class), executionPolicy$iv6, handler$iv6);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _get_spec_$lambda$0$0$4(OuroState it) {
        Intrinsics.checkNotNullParameter(it, "it");
        KClass key$iv = Reflection.getOrCreateKotlinClass(OuroTextStylePlugin.class);
        OuroPluginState ouroPluginState = it.getPluginStates().get(key$iv);
        if (!(ouroPluginState instanceof OuroTextStyleState)) {
            ouroPluginState = null;
        }
        OuroTextStyleState ouroTextStyleState = (OuroTextStyleState) ouroPluginState;
        if (ouroTextStyleState != null) {
            return ouroTextStyleState instanceof OuroTextStyleState.Preview;
        }
        throw new NoSuchElementException("No plugin state for " + key$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _get_spec_$lambda$0$0$5(ConditionBuilderBlock $this$condition) {
        Intrinsics.checkNotNullParameter($this$condition, "$this$condition");
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) $this$condition;
        Function3 handler$iv = new OuroTextStylePlugin$spec$1$1$6$1(null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(OuroToggleBoldAction.class), executionPolicy$iv, handler$iv);
        BaseBuilderBlock $this$iv2 = (BaseBuilderBlock) $this$condition;
        Function3 handler$iv2 = new OuroTextStylePlugin$spec$1$1$6$2(null);
        ExecutionPolicy executionPolicy$iv2 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv2.on(Reflection.getOrCreateKotlinClass(OuroToggleItalicAction.class), executionPolicy$iv2, handler$iv2);
        BaseBuilderBlock $this$iv3 = (BaseBuilderBlock) $this$condition;
        Function3 handler$iv3 = new OuroTextStylePlugin$spec$1$1$6$3(null);
        ExecutionPolicy executionPolicy$iv3 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv3.on(Reflection.getOrCreateKotlinClass(OuroToggleUnderlineAction.class), executionPolicy$iv3, handler$iv3);
        BaseBuilderBlock $this$iv4 = (BaseBuilderBlock) $this$condition;
        Function3 handler$iv4 = new OuroTextStylePlugin$spec$1$1$6$4(null);
        ExecutionPolicy executionPolicy$iv4 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv4.on(Reflection.getOrCreateKotlinClass(OuroToggleStrikethroughAction.class), executionPolicy$iv4, handler$iv4);
        BaseBuilderBlock $this$iv5 = (BaseBuilderBlock) $this$condition;
        Function3 handler$iv5 = new OuroTextStylePlugin$spec$1$1$6$5(null);
        ExecutionPolicy executionPolicy$iv5 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv5.on(Reflection.getOrCreateKotlinClass(OuroChangeForegroundColor.class), executionPolicy$iv5, handler$iv5);
        BaseBuilderBlock $this$iv6 = (BaseBuilderBlock) $this$condition;
        Function3 handler$iv6 = new OuroTextStylePlugin$spec$1$1$6$6(null);
        ExecutionPolicy executionPolicy$iv6 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv6.on(Reflection.getOrCreateKotlinClass(OuroChangeBackgroundColor.class), executionPolicy$iv6, handler$iv6);
        return Unit.INSTANCE;
    }

    @Override // kntr.common.ouro.core.plugin.OuroPlugin
    public Function2<FlowReduxStoreBuilder<OuroState, OuroAction>, Function2<? super OuroAction, ? super Continuation<? super Unit>, ? extends Object>, Unit> getSpec() {
        return new Function2() { // from class: kntr.common.ouro.core.plugin.textStyle.OuroTextStylePlugin$$ExternalSyntheticLambda0
            public final Object invoke(Object obj, Object obj2) {
                Unit _get_spec_$lambda$0;
                _get_spec_$lambda$0 = OuroTextStylePlugin._get_spec_$lambda$0((FlowReduxStoreBuilder) obj, (Function2) obj2);
                return _get_spec_$lambda$0;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final OuroState removeTextMarksByKeys(OuroState $this$removeTextMarksByKeys, final Collection<? extends OuroMark.Key<?>> collection) {
        NodeStorage newStorage = OuroNodeStorageUtilsKt.mutate($this$removeTextMarksByKeys.getStorage(), $this$removeTextMarksByKeys.getTextRange(), $this$removeTextMarksByKeys.getDisplayLengthTransform(), new Function2() { // from class: kntr.common.ouro.core.plugin.textStyle.OuroTextStylePlugin$$ExternalSyntheticLambda8
            public final Object invoke(Object obj, Object obj2) {
                Unit removeTextMarksByKeys$lambda$0;
                removeTextMarksByKeys$lambda$0 = OuroTextStylePlugin.removeTextMarksByKeys$lambda$0(collection, (NodeStorageBuilder) obj, (OuroSelection) obj2);
                return removeTextMarksByKeys$lambda$0;
            }
        });
        return OuroState.copy$default($this$removeTextMarksByKeys, newStorage, null, null, null, null, 30, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit removeTextMarksByKeys$lambda$0(Collection $keys, NodeStorageBuilder $this$mutate, OuroSelection sel) {
        Iterable $this$forEach$iv;
        boolean z;
        Iterator it;
        Iterable $this$forEach$iv2;
        boolean z2;
        Iterator it2;
        Intrinsics.checkNotNullParameter($this$mutate, "$this$mutate");
        Intrinsics.checkNotNullParameter(sel, "sel");
        Iterable selectables = OuroNodeStorageUtilsKt.getSelectables($this$mutate, sel);
        Iterable $this$forEach$iv3 = selectables;
        boolean z3 = false;
        Iterator it3 = $this$forEach$iv3.iterator();
        while (it3.hasNext()) {
            Object element$iv = it3.next();
            OuroNode.Selectable node = (OuroNode.Selectable) element$iv;
            if (node instanceof OuroTextElement.Plain) {
                $this$mutate.replace(node, ((OuroTextElement.Plain) node).copyWithMarks(((OuroTextElement.Plain) node).getMarks().minusKeys(CollectionsKt.toSet($keys))));
                $this$forEach$iv = $this$forEach$iv3;
                z = z3;
                it = it3;
            } else if (node instanceof OuroLink) {
                Collection $this$filter$iv = $keys;
                Collection destination$iv$iv = new ArrayList();
                for (Object element$iv$iv : $this$filter$iv) {
                    Iterable $this$forEach$iv4 = $this$forEach$iv3;
                    if (!Intrinsics.areEqual((OuroMark.Key) element$iv$iv, OuroForegroundColorMark.Key.INSTANCE)) {
                        destination$iv$iv.add(element$iv$iv);
                    }
                    $this$forEach$iv3 = $this$forEach$iv4;
                }
                $this$forEach$iv = $this$forEach$iv3;
                List keysForLink = (List) destination$iv$iv;
                if (keysForLink.isEmpty()) {
                    keysForLink = null;
                }
                if (keysForLink == null) {
                    z = z3;
                    it = it3;
                } else {
                    Iterable children = $this$mutate.getChildren((OuroNode.Parent) node);
                    if (children != null) {
                        Iterable $this$filterIsInstance$iv = children;
                        Collection destination$iv$iv2 = new ArrayList();
                        for (Object element$iv$iv2 : $this$filterIsInstance$iv) {
                            Iterable $this$filterIsInstance$iv2 = $this$filterIsInstance$iv;
                            if (element$iv$iv2 instanceof OuroTextElement.Plain) {
                                destination$iv$iv2.add(element$iv$iv2);
                            }
                            $this$filterIsInstance$iv = $this$filterIsInstance$iv2;
                        }
                        Iterable $this$forEach$iv5 = (List) destination$iv$iv2;
                        for (Object element$iv2 : $this$forEach$iv5) {
                            OuroTextElement.Plain it4 = (OuroTextElement.Plain) element$iv2;
                            $this$mutate.replace(it4, it4.copyWithMarks(it4.getMarks().minusKeys(CollectionsKt.toSet(keysForLink))));
                            $this$forEach$iv5 = $this$forEach$iv5;
                            keysForLink = keysForLink;
                        }
                    }
                    Collection $this$filter$iv2 = $keys;
                    Collection destination$iv$iv3 = new ArrayList();
                    for (Object element$iv$iv3 : $this$filter$iv2) {
                        Iterable $this$filter$iv3 = $this$filter$iv2;
                        if (Intrinsics.areEqual((OuroMark.Key) element$iv$iv3, OuroBackgroundColorMark.Key.INSTANCE)) {
                            destination$iv$iv3.add(element$iv$iv3);
                        }
                        $this$filter$iv2 = $this$filter$iv3;
                    }
                    List it5 = (List) destination$iv$iv3;
                    List list = !it5.isEmpty() ? it5 : null;
                    if (list != null) {
                        List keyForInlineContent = list;
                        Iterable children2 = $this$mutate.getChildren((OuroNode.Parent) node);
                        if (children2 != null) {
                            Iterable $this$filterIsInstance$iv3 = children2;
                            Collection destination$iv$iv4 = new ArrayList();
                            for (Object element$iv$iv4 : $this$filterIsInstance$iv3) {
                                Iterable $this$filterIsInstance$iv4 = $this$filterIsInstance$iv3;
                                if (element$iv$iv4 instanceof OuroInlineContent) {
                                    destination$iv$iv4.add(element$iv$iv4);
                                }
                                $this$filterIsInstance$iv3 = $this$filterIsInstance$iv4;
                            }
                            Iterable $this$forEach$iv6 = (List) destination$iv$iv4;
                            for (Object element$iv3 : $this$forEach$iv6) {
                                OuroInlineContent inlineContent = (OuroInlineContent) element$iv3;
                                List children3 = $this$mutate.removeAllChildren(inlineContent);
                                if (children3 == null) {
                                    $this$forEach$iv2 = $this$forEach$iv6;
                                    z2 = z3;
                                    it2 = it3;
                                } else {
                                    $this$forEach$iv2 = $this$forEach$iv6;
                                    z2 = z3;
                                    it2 = it3;
                                    OuroInlineContent newInlineContent = new OuroInlineContent(inlineContent.getMarks().minusKeys(keyForInlineContent));
                                    $this$mutate.replace(inlineContent, newInlineContent);
                                    $this$mutate.add(newInlineContent, children3);
                                }
                                $this$forEach$iv6 = $this$forEach$iv2;
                                z3 = z2;
                                it3 = it2;
                            }
                            z = z3;
                            it = it3;
                        } else {
                            z = z3;
                            it = it3;
                        }
                    } else {
                        z = z3;
                        it = it3;
                    }
                }
            } else {
                $this$forEach$iv = $this$forEach$iv3;
                z = z3;
                it = it3;
                if (node instanceof OuroInlineContent) {
                    Collection $this$filter$iv4 = $keys;
                    Collection destination$iv$iv5 = new ArrayList();
                    for (Object element$iv$iv5 : $this$filter$iv4) {
                        if (Intrinsics.areEqual((OuroMark.Key) element$iv$iv5, OuroBackgroundColorMark.Key.INSTANCE)) {
                            destination$iv$iv5.add(element$iv$iv5);
                        }
                    }
                    List it6 = (List) destination$iv$iv5;
                    List list2 = !it6.isEmpty() ? it6 : null;
                    if (list2 != null) {
                        List keyForInlineContent2 = list2;
                        List children4 = $this$mutate.removeAllChildren((OuroNode.Parent) node);
                        if (children4 != null) {
                            OuroInlineContent newInlineContent2 = new OuroInlineContent(((OuroInlineContent) node).getMarks().minusKeys(keyForInlineContent2));
                            $this$mutate.replace(node, newInlineContent2);
                            $this$mutate.add(newInlineContent2, children4);
                        }
                    }
                }
            }
            z3 = z;
            $this$forEach$iv3 = $this$forEach$iv;
            it3 = it;
        }
        OuroTextStylePlugin ouroTextStylePlugin = INSTANCE;
        OuroTextStylePlugin ouroTextStylePlugin2 = INSTANCE;
        Collection destination$iv$iv6 = new ArrayList();
        for (Object element$iv$iv6 : selectables) {
            if (element$iv$iv6 instanceof OuroTextElement) {
                destination$iv$iv6.add(element$iv$iv6);
            }
        }
        ouroTextStylePlugin.removeTextMarkToListItem($this$mutate, $keys, ouroTextStylePlugin2.getCompletelySelectedListItems($this$mutate, (List) destination$iv$iv6));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final OuroState addMarks(OuroState $this$addMarks, final Collection<? extends OuroMark> collection) {
        NodeStorage newStorage = OuroNodeStorageUtilsKt.mutate($this$addMarks.getStorage(), $this$addMarks.getTextRange(), $this$addMarks.getDisplayLengthTransform(), new Function2() { // from class: kntr.common.ouro.core.plugin.textStyle.OuroTextStylePlugin$$ExternalSyntheticLambda9
            public final Object invoke(Object obj, Object obj2) {
                Unit addMarks$lambda$0;
                addMarks$lambda$0 = OuroTextStylePlugin.addMarks$lambda$0(collection, (NodeStorageBuilder) obj, (OuroSelection) obj2);
                return addMarks$lambda$0;
            }
        });
        return OuroState.copy$default($this$addMarks, newStorage, null, null, null, null, 30, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit addMarks$lambda$0(Collection $marks, NodeStorageBuilder $this$mutate, OuroSelection sel) {
        Iterable $this$forEach$iv;
        boolean z;
        List children;
        Iterable children2;
        Iterable $this$forEach$iv2;
        boolean z2;
        Iterator it;
        Intrinsics.checkNotNullParameter($this$mutate, "$this$mutate");
        Intrinsics.checkNotNullParameter(sel, "sel");
        Collection $this$filterIsInstance$iv = $marks;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filterIsInstance$iv) {
            if (element$iv$iv instanceof OuroTextMark) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        Iterable textMark = (List) destination$iv$iv;
        Collection $this$filterIsInstance$iv2 = $marks;
        Collection destination$iv$iv2 = new ArrayList();
        for (Object element$iv$iv2 : $this$filterIsInstance$iv2) {
            if (element$iv$iv2 instanceof OuroBackgroundColorMark) {
                destination$iv$iv2.add(element$iv$iv2);
            }
        }
        List inlineContentBackgroundColorMark = (List) destination$iv$iv2;
        Iterable selectables = OuroNodeStorageUtilsKt.getSelectables($this$mutate, sel);
        Iterable $this$forEach$iv3 = selectables;
        boolean z3 = false;
        for (Object element$iv : $this$forEach$iv3) {
            OuroNode.Selectable node = (OuroNode.Selectable) element$iv;
            if (node instanceof OuroTextElement.Plain) {
                $this$mutate.replace(node, ((OuroTextElement.Plain) node).copyWithMarks(((OuroTextElement.Plain) node).getMarks().plus((Collection) textMark)));
                $this$forEach$iv = $this$forEach$iv3;
                z = z3;
            } else if (node instanceof OuroLink) {
                Iterable $this$filter$iv = textMark;
                Collection destination$iv$iv3 = new ArrayList();
                for (Object element$iv$iv3 : $this$filter$iv) {
                    Iterable $this$forEach$iv4 = $this$forEach$iv3;
                    boolean z4 = z3;
                    if (!(((OuroTextMark) element$iv$iv3) instanceof OuroForegroundColorMark)) {
                        destination$iv$iv3.add(element$iv$iv3);
                    }
                    $this$forEach$iv3 = $this$forEach$iv4;
                    z3 = z4;
                }
                $this$forEach$iv = $this$forEach$iv3;
                z = z3;
                List marksForLink = (List) destination$iv$iv3;
                if (marksForLink.isEmpty()) {
                    marksForLink = null;
                }
                if (marksForLink != null) {
                    Iterable children3 = $this$mutate.getChildren((OuroNode.Parent) node);
                    if (children3 != null) {
                        Iterable $this$filterIsInstance$iv3 = children3;
                        Collection destination$iv$iv4 = new ArrayList();
                        for (Object element$iv$iv4 : $this$filterIsInstance$iv3) {
                            Iterable $this$filterIsInstance$iv4 = $this$filterIsInstance$iv3;
                            if (element$iv$iv4 instanceof OuroTextElement.Plain) {
                                destination$iv$iv4.add(element$iv$iv4);
                            }
                            $this$filterIsInstance$iv3 = $this$filterIsInstance$iv4;
                        }
                        Iterable $this$forEach$iv5 = (List) destination$iv$iv4;
                        boolean z5 = false;
                        for (Object element$iv2 : $this$forEach$iv5) {
                            OuroTextElement.Plain it2 = (OuroTextElement.Plain) element$iv2;
                            $this$mutate.replace(it2, it2.copyWithMarks(it2.getMarks().plus(marksForLink)));
                            $this$forEach$iv5 = $this$forEach$iv5;
                            z5 = z5;
                        }
                    }
                    if (!inlineContentBackgroundColorMark.isEmpty() && (children2 = $this$mutate.getChildren((OuroNode.Parent) node)) != null) {
                        Iterable $this$filterIsInstance$iv5 = children2;
                        Collection destination$iv$iv5 = new ArrayList();
                        for (Object element$iv$iv5 : $this$filterIsInstance$iv5) {
                            List marksForLink2 = marksForLink;
                            if (element$iv$iv5 instanceof OuroInlineContent) {
                                destination$iv$iv5.add(element$iv$iv5);
                            }
                            marksForLink = marksForLink2;
                        }
                        Iterable $this$forEach$iv6 = (List) destination$iv$iv5;
                        boolean z6 = false;
                        Iterator it3 = $this$forEach$iv6.iterator();
                        while (it3.hasNext()) {
                            Object element$iv3 = it3.next();
                            OuroInlineContent inlineContent = (OuroInlineContent) element$iv3;
                            List children4 = $this$mutate.removeAllChildren(inlineContent);
                            if (children4 == null) {
                                $this$forEach$iv2 = $this$forEach$iv6;
                                z2 = z6;
                                it = it3;
                            } else {
                                $this$forEach$iv2 = $this$forEach$iv6;
                                z2 = z6;
                                it = it3;
                                OuroInlineContent newInlineContent = new OuroInlineContent(inlineContent.getMarks().plus(inlineContentBackgroundColorMark));
                                $this$mutate.replace(inlineContent, newInlineContent);
                                $this$mutate.add(newInlineContent, children4);
                            }
                            $this$forEach$iv6 = $this$forEach$iv2;
                            z6 = z2;
                            it3 = it;
                        }
                    }
                }
            } else {
                $this$forEach$iv = $this$forEach$iv3;
                z = z3;
                if ((node instanceof OuroInlineContent) && !inlineContentBackgroundColorMark.isEmpty() && (children = $this$mutate.removeAllChildren((OuroNode.Parent) node)) != null) {
                    OuroInlineContent newInlineContent2 = new OuroInlineContent(((OuroInlineContent) node).getMarks().plus(inlineContentBackgroundColorMark));
                    $this$mutate.replace(node, newInlineContent2);
                    $this$mutate.add(newInlineContent2, children);
                }
            }
            $this$forEach$iv3 = $this$forEach$iv;
            z3 = z;
        }
        OuroTextStylePlugin ouroTextStylePlugin = INSTANCE;
        ArrayList arrayList = (Collection) textMark;
        OuroTextStylePlugin ouroTextStylePlugin2 = INSTANCE;
        Iterable $this$filterIsInstance$iv6 = selectables;
        Collection destination$iv$iv6 = new ArrayList();
        for (Object element$iv$iv6 : $this$filterIsInstance$iv6) {
            if (element$iv$iv6 instanceof OuroTextElement) {
                destination$iv$iv6.add(element$iv$iv6);
            }
        }
        ouroTextStylePlugin.applyTextMarkToListItem($this$mutate, arrayList, ouroTextStylePlugin2.getCompletelySelectedListItems($this$mutate, (List) destination$iv$iv6));
        return Unit.INSTANCE;
    }

    private final void applyTextMarkToListItem(NodeStorageBuilder<?> nodeStorageBuilder, Collection<? extends OuroTextMark> collection, List<OuroListItem> list) {
        List<OuroListItem> $this$forEach$iv = list;
        for (Object element$iv : $this$forEach$iv) {
            OuroListItem it = (OuroListItem) element$iv;
            OuroListItem newItem = OuroListItem.copy$default(it, null, it.getPrefixMarks().plus(collection), 1, null);
            List children = nodeStorageBuilder.removeAllChildren(it);
            if (children != null) {
                nodeStorageBuilder.add(newItem, children);
            }
            nodeStorageBuilder.replace(it, newItem);
        }
    }

    private final void removeTextMarkToListItem(NodeStorageBuilder<?> nodeStorageBuilder, Collection<? extends OuroMark.Key<?>> collection, List<OuroListItem> list) {
        Set removeKeys = CollectionsKt.toSet(collection);
        List<OuroListItem> $this$forEach$iv = list;
        for (Object element$iv : $this$forEach$iv) {
            OuroListItem it = (OuroListItem) element$iv;
            OuroListItem newItem = OuroListItem.copy$default(it, null, it.getPrefixMarks().minusKeys(removeKeys), 1, null);
            List children = nodeStorageBuilder.removeAllChildren(it);
            if (children != null) {
                nodeStorageBuilder.add(newItem, children);
            }
            nodeStorageBuilder.replace(it, newItem);
        }
    }

    private final List<OuroListItem> getCompletelySelectedListItems(NodeStorageBuilder<?> nodeStorageBuilder, List<? extends OuroTextElement> list) {
        Iterable $this$forEach$iv;
        int $i$f$forEach;
        ArrayList arrayList;
        boolean z;
        List result = new ArrayList();
        Set processedListItems = new LinkedHashSet();
        List<? extends OuroTextElement> $this$filterIsInstance$iv = list;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filterIsInstance$iv) {
            if (element$iv$iv instanceof OuroTextElement.Plain) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        Iterable $this$forEach$iv2 = (List) destination$iv$iv;
        int $i$f$forEach2 = 0;
        for (Object element$iv : $this$forEach$iv2) {
            OuroTextElement.Plain textElement = (OuroTextElement.Plain) element$iv;
            if (nodeStorageBuilder.getParent(textElement) instanceof OuroParagraph) {
                OuroNode.Parent<?> parent = nodeStorageBuilder.getParent(textElement);
                Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type kntr.common.ouro.core.model.node.OuroParagraph");
                OuroParagraph paragraph = (OuroParagraph) parent;
                Iterable children = nodeStorageBuilder.getChildren(paragraph);
                if (children == null) {
                    $this$forEach$iv = $this$forEach$iv2;
                    $i$f$forEach = $i$f$forEach2;
                    arrayList = null;
                } else {
                    Iterable $this$filterIsInstance$iv2 = children;
                    Collection destination$iv$iv2 = new ArrayList();
                    for (Object element$iv$iv2 : $this$filterIsInstance$iv2) {
                        Iterable $this$forEach$iv3 = $this$forEach$iv2;
                        int $i$f$forEach3 = $i$f$forEach2;
                        if (element$iv$iv2 instanceof OuroTextElement.Plain) {
                            destination$iv$iv2.add(element$iv$iv2);
                        }
                        $this$forEach$iv2 = $this$forEach$iv3;
                        $i$f$forEach2 = $i$f$forEach3;
                    }
                    $this$forEach$iv = $this$forEach$iv2;
                    $i$f$forEach = $i$f$forEach2;
                    arrayList = (List) destination$iv$iv2;
                }
                ArrayList arrayList2 = arrayList;
                if (arrayList2 == null || arrayList2.isEmpty()) {
                    return result;
                }
                if (nodeStorageBuilder.getParent(paragraph) instanceof OuroListItem) {
                    OuroNode.Parent<?> parent2 = nodeStorageBuilder.getParent(paragraph);
                    Intrinsics.checkNotNull(parent2, "null cannot be cast to non-null type kntr.common.ouro.core.model.node.OuroListItem");
                    OuroListItem listItem = (OuroListItem) parent2;
                    Set $this$any$iv = processedListItems;
                    if (!($this$any$iv instanceof Collection) || !$this$any$iv.isEmpty()) {
                        Iterator it = $this$any$iv.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                Object element$iv2 = it.next();
                                OuroListItem it2 = (OuroListItem) element$iv2;
                                if (Intrinsics.areEqual(it2, listItem)) {
                                    z = true;
                                    break;
                                }
                            } else {
                                z = false;
                                break;
                            }
                        }
                    } else {
                        z = false;
                    }
                    if (!z && list.containsAll(arrayList)) {
                        result.add(listItem);
                        processedListItems.add(listItem);
                    }
                }
            } else {
                $this$forEach$iv = $this$forEach$iv2;
                $i$f$forEach = $i$f$forEach2;
            }
            $this$forEach$iv2 = $this$forEach$iv;
            $i$f$forEach2 = $i$f$forEach;
        }
        return result;
    }
}