package kntr.app.mall.mallDynamicPage.component.base;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import java.util.ArrayList;
import java.util.Map;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.app.mall.mallDynamicPage.MallDynamicPageViewKt;
import kntr.app.mall.mallDynamicPage.MallDynamicPageViewModel;
import kntr.app.mall.mallDynamicPage.bean.Props;
import kntr.app.mall.mallDynamicPage.bean.Style;
import kntr.app.mall.mallDynamicPage.parser.ComponentBuilderKt;
import kntr.app.mall.mallDynamicPage.parser.MappingHelperKt;
import kntr.app.mall.mallDynamicPage.parser.ModifierCreatorKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RowComponent.kt */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aS\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0001¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"RowComponent", RoomRecommendViewModel.EMPTY_CURSOR, "uiMap", RoomRecommendViewModel.EMPTY_CURSOR, RoomRecommendViewModel.EMPTY_CURSOR, RoomRecommendViewModel.EMPTY_CURSOR, "data", "style", "Lkntr/app/mall/mallDynamicPage/bean/Style;", "props", "Lkntr/app/mall/mallDynamicPage/bean/Props;", "modifier", "Landroidx/compose/ui/Modifier;", "(Ljava/util/Map;Ljava/util/Map;Lkntr/app/mall/mallDynamicPage/bean/Style;Lkntr/app/mall/mallDynamicPage/bean/Props;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "mallDynamicPage_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class RowComponentKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RowComponent$lambda$1(Map map, Map map2, Style style, Props props, Modifier modifier, int i, int i2, Composer composer, int i3) {
        RowComponent(map, map2, style, props, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void RowComponent(final Map<String, ? extends Object> map, final Map<String, ? extends Object> map2, final Style style, final Props props, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Modifier modifier3;
        Function0 factory$iv$iv$iv;
        Modifier materialized$iv$iv;
        MeasurePolicy measurePolicy$iv$iv;
        Arrangement.Horizontal horizontalArrangement$iv;
        Modifier modifierThis;
        RowScope $this$RowComponent_u24lambda_u240;
        Composer $composer2;
        Composer $composer$iv;
        Alignment.Vertical verticalAlignment$iv;
        String str;
        String str2;
        Composer $composer3;
        Intrinsics.checkNotNullParameter(map, "uiMap");
        Intrinsics.checkNotNullParameter(map2, "data");
        Composer $composer4 = $composer.startRestartGroup(-1209465356);
        ComposerKt.sourceInformation($composer4, "C(RowComponent)N(uiMap,data,style,props,modifier)25@917L22,33@1153L21,30@1091L1907:RowComponent.kt#ay1t0q");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer4.changedInstance(map) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer4.changedInstance(map2) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer4.changedInstance(style) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer4.changedInstance(props) ? 2048 : 1024;
        }
        int i2 = i & 16;
        if (i2 != 0) {
            $dirty |= 24576;
            modifier2 = modifier;
        } else if (($changed & 24576) == 0) {
            modifier2 = modifier;
            $dirty |= $composer4.changed(modifier2) ? 16384 : 8192;
        } else {
            modifier2 = modifier;
        }
        int $dirty2 = $dirty;
        if (!$composer4.shouldExecute(($dirty2 & 9363) != 9362, $dirty2 & 1)) {
            $composer4.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i2 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1209465356, $dirty2, -1, "kntr.app.mall.mallDynamicPage.component.base.RowComponent (RowComponent.kt:24)");
            }
            MallDynamicPageViewModel vm = MallDynamicPageViewKt.currentPageViewModel($composer4, 0);
            Modifier modifierThis2 = modifier3;
            if (props != null ? Intrinsics.areEqual(props.getScrollable(), true) : false) {
                $composer4.startReplaceGroup(-701519041);
                ComposerKt.sourceInformation($composer4, "28@1058L21");
                modifierThis2 = ScrollKt.horizontalScroll$default(modifier3, ScrollKt.rememberScrollState(0, $composer4, 0, 1), false, (FlingBehavior) null, false, 14, (Object) null);
            } else {
                $composer4.startReplaceGroup(-702521426);
            }
            $composer4.endReplaceGroup();
            Modifier modifierThis3 = modifierThis2;
            Modifier modifierThis4 = Modifier.Companion;
            Modifier modifier$iv = ModifierCreatorKt.createModifier(modifierThis4, style, $composer4, (($dirty2 >> 3) & 112) | 6).then(modifierThis3);
            Alignment.Vertical verticalAlignment$iv2 = MappingHelperKt.mappingAlignVertical(style != null ? style.getVerticalAlignment() : null);
            Arrangement.Horizontal horizontalArrangement$iv2 = MappingHelperKt.mappingArrangeHorizontal(style != null ? style.getHorizontalArrangement() : null);
            ComposerKt.sourceInformationMarkerStart($composer4, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
            CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer4, modifier$iv);
            Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer4.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer4.startReusableNode();
            if ($composer4.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer4.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer4.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer4);
            MeasurePolicy measurePolicy$iv$iv2 = measurePolicy$iv;
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Alignment.Vertical verticalAlignment$iv3 = verticalAlignment$iv2;
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer4, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i4 = ((0 >> 6) & 112) | 6;
            RowScope $this$RowComponent_u24lambda_u2402 = RowScopeInstance.INSTANCE;
            Composer $composer5 = $composer4;
            Composer $composer$iv2 = $composer4;
            Arrangement.Horizontal horizontalArrangement$iv3 = horizontalArrangement$iv2;
            ComposerKt.sourceInformationMarkerStart($composer5, -240149133, "C:RowComponent.kt#ay1t0q");
            $composer5.startReplaceGroup(-1808860948);
            String str3 = RoomRecommendViewModel.EMPTY_CURSOR;
            ComposerKt.sourceInformation($composer5, RoomRecommendViewModel.EMPTY_CURSOR);
            Object obj = map.get("children");
            Modifier modifierThis5 = modifierThis3;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type java.util.ArrayList<*>");
            Iterable $this$forEach$iv = (ArrayList) obj;
            for (Object element$iv : $this$forEach$iv) {
                Intrinsics.checkNotNull(element$iv, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any>");
                Map child = (Map) element$iv;
                CompositionLocalMap localMap$iv$iv2 = localMap$iv$iv;
                Object obj2 = child.get("options");
                Map options = obj2 instanceof Map ? (Map) obj2 : null;
                if (options == null) {
                    options = MapsKt.emptyMap();
                }
                Object obj3 = options.get("style");
                Map map3 = obj3 instanceof Map ? (Map) obj3 : null;
                if (map3 == null) {
                    map3 = MapsKt.emptyMap();
                }
                Map styleChild = map3;
                int compositeKeyHash$iv$iv2 = compositeKeyHash$iv$iv;
                if (styleChild.get("align") != null) {
                    materialized$iv$iv = materialized$iv$iv2;
                    $composer5.startReplaceGroup(874277086);
                    ComposerKt.sourceInformation($composer5, str3);
                    Function2<String, Map<String, ? extends Object>, Object> valueBridge = vm.getValueBridge();
                    String str4 = str3;
                    measurePolicy$iv$iv = measurePolicy$iv$iv2;
                    Object obj4 = styleChild.get("align");
                    Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type kotlin.String");
                    Object invoke = valueBridge.invoke("execAntlr", MapsKt.mapOf(new Pair[]{TuplesKt.to("expression", (String) obj4), TuplesKt.to("data", map2)}));
                    Intrinsics.checkNotNull(invoke, "null cannot be cast to non-null type kotlin.String");
                    String align = (String) invoke;
                    if (styleChild.get("weight") != null) {
                        $composer5.startReplaceGroup(874546786);
                        ComposerKt.sourceInformation($composer5, "50@2075L241");
                        Object obj5 = styleChild.get("weight");
                        Intrinsics.checkNotNull(obj5, "null cannot be cast to non-null type kotlin.String");
                        float weight = Float.parseFloat((String) obj5);
                        $this$RowComponent_u24lambda_u240 = $this$RowComponent_u24lambda_u2402;
                        Composer $composer6 = $composer5;
                        $composer$iv = $composer$iv2;
                        verticalAlignment$iv = verticalAlignment$iv3;
                        str2 = str4;
                        horizontalArrangement$iv = horizontalArrangement$iv3;
                        modifierThis = modifierThis5;
                        ComponentBuilderKt.BuildComponentTree((Map) element$iv, map2, RowScope.-CC.weight$default($this$RowComponent_u24lambda_u2402, $this$RowComponent_u24lambda_u2402.align(Modifier.Companion, MappingHelperKt.mappingAlignVertical(align)), weight, false, 2, (Object) null), $composer6, $dirty2 & 112, 0);
                        $composer6.endReplaceGroup();
                        $composer3 = $composer6;
                    } else {
                        str2 = str4;
                        horizontalArrangement$iv = horizontalArrangement$iv3;
                        modifierThis = modifierThis5;
                        $this$RowComponent_u24lambda_u240 = $this$RowComponent_u24lambda_u2402;
                        $composer$iv = $composer$iv2;
                        verticalAlignment$iv = verticalAlignment$iv3;
                        $composer3 = $composer5;
                        $composer3.startReplaceGroup(874902263);
                        ComposerKt.sourceInformation($composer3, "58@2362L168");
                        ComponentBuilderKt.BuildComponentTree((Map) element$iv, map2, $this$RowComponent_u24lambda_u240.align(Modifier.Companion, MappingHelperKt.mappingAlignVertical(align)), $composer3, $dirty2 & 112, 0);
                        $composer3.endReplaceGroup();
                    }
                    $composer3.endReplaceGroup();
                    $composer2 = $composer3;
                    str = str2;
                } else {
                    String str5 = str3;
                    materialized$iv$iv = materialized$iv$iv2;
                    measurePolicy$iv$iv = measurePolicy$iv$iv2;
                    horizontalArrangement$iv = horizontalArrangement$iv3;
                    modifierThis = modifierThis5;
                    $this$RowComponent_u24lambda_u240 = $this$RowComponent_u24lambda_u2402;
                    $composer2 = $composer5;
                    $composer$iv = $composer$iv2;
                    verticalAlignment$iv = verticalAlignment$iv3;
                    $composer2.startReplaceGroup(875134825);
                    ComposerKt.sourceInformation($composer2, str5);
                    if (styleChild.get("weight") != null) {
                        $composer2.startReplaceGroup(875181759);
                        ComposerKt.sourceInformation($composer2, "67@2718L148");
                        Object obj6 = styleChild.get("weight");
                        Intrinsics.checkNotNull(obj6, "null cannot be cast to non-null type kotlin.String");
                        float weight2 = Float.parseFloat((String) obj6);
                        str = str5;
                        ComponentBuilderKt.BuildComponentTree((Map) element$iv, map2, RowScope.-CC.weight$default($this$RowComponent_u24lambda_u240, Modifier.Companion, weight2, false, 2, (Object) null), $composer2, $dirty2 & 112, 0);
                        $composer2.endReplaceGroup();
                    } else {
                        str = str5;
                        $composer2.startReplaceGroup(875443833);
                        ComposerKt.sourceInformation($composer2, "73@2912L38");
                        ComponentBuilderKt.BuildComponentTree((Map) element$iv, map2, Modifier.Companion, $composer2, ($dirty2 & 112) | 384, 0);
                        $composer2.endReplaceGroup();
                    }
                    $composer2.endReplaceGroup();
                }
                $composer5 = $composer2;
                $this$RowComponent_u24lambda_u2402 = $this$RowComponent_u24lambda_u240;
                str3 = str;
                verticalAlignment$iv3 = verticalAlignment$iv;
                modifierThis5 = modifierThis;
                localMap$iv$iv = localMap$iv$iv2;
                $composer$iv2 = $composer$iv;
                compositeKeyHash$iv$iv = compositeKeyHash$iv$iv2;
                materialized$iv$iv2 = materialized$iv$iv;
                measurePolicy$iv$iv2 = measurePolicy$iv$iv;
                horizontalArrangement$iv3 = horizontalArrangement$iv;
            }
            Composer $composer7 = $composer5;
            $composer7.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer7);
            ComposerKt.sourceInformationMarkerEnd($composer$iv2);
            $composer4.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer4.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier4 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.mallDynamicPage.component.base.RowComponentKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj7, Object obj8) {
                    Unit RowComponent$lambda$1;
                    RowComponent$lambda$1 = RowComponentKt.RowComponent$lambda$1(map, map2, style, props, modifier4, $changed, i, (Composer) obj7, ((Integer) obj8).intValue());
                    return RowComponent$lambda$1;
                }
            });
        }
    }
}