package kntr.app.mall.mallDynamicPage.component.base;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
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

/* compiled from: BoxComponent.kt */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aI\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\nH\u0001¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"BoxComponent", RoomRecommendViewModel.EMPTY_CURSOR, "uiMap", RoomRecommendViewModel.EMPTY_CURSOR, RoomRecommendViewModel.EMPTY_CURSOR, RoomRecommendViewModel.EMPTY_CURSOR, "data", "style", "Lkntr/app/mall/mallDynamicPage/bean/Style;", "modifier", "Landroidx/compose/ui/Modifier;", "(Ljava/util/Map;Ljava/util/Map;Lkntr/app/mall/mallDynamicPage/bean/Style;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "mallDynamicPage_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class BoxComponentKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxComponent$lambda$1(Map map, Map map2, Style style, Modifier modifier, int i, int i2, Composer composer, int i3) {
        BoxComponent(map, map2, style, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void BoxComponent(final Map<String, ? extends Object> map, final Map<String, ? extends Object> map2, final Style style, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Modifier modifier3;
        Modifier modifier4;
        Function0 factory$iv$iv$iv;
        Modifier materialized$iv$iv;
        Composer $composer2;
        Modifier modifier$iv$iv;
        Function0 factory$iv$iv$iv2;
        BoxScope $this$BoxComponent_u24lambda_u240;
        Composer $composer$iv;
        boolean propagateMinConstraints$iv;
        Composer $composer3;
        Intrinsics.checkNotNullParameter(map, "uiMap");
        Intrinsics.checkNotNullParameter(map2, "data");
        Composer $composer4 = $composer.startRestartGroup(-1009928016);
        ComposerKt.sourceInformation($composer4, "C(BoxComponent)N(uiMap,data,style,modifier)20@666L22,24@755L21,21@693L1063:BoxComponent.kt#ay1t0q");
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
        int i2 = i & 8;
        if (i2 != 0) {
            $dirty |= 3072;
            modifier2 = modifier;
        } else if (($changed & 3072) == 0) {
            modifier2 = modifier;
            $dirty |= $composer4.changed(modifier2) ? 2048 : 1024;
        } else {
            modifier2 = modifier;
        }
        int $dirty2 = $dirty;
        if (!$composer4.shouldExecute(($dirty2 & 1171) != 1170, $dirty2 & 1)) {
            $composer4.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1009928016, $dirty2, -1, "kntr.app.mall.mallDynamicPage.component.base.BoxComponent (BoxComponent.kt:19)");
            }
            MallDynamicPageViewModel vm = MallDynamicPageViewKt.currentPageViewModel($composer4, 0);
            Modifier modifier$iv = ModifierCreatorKt.createModifier(Modifier.Companion, style, $composer4, (($dirty2 >> 3) & 112) | 6).then(modifier4);
            Alignment contentAlignment$iv = MappingHelperKt.mappingAlign(style != null ? style.getContentAlignment() : null);
            Composer $composer$iv2 = $composer4;
            ComposerKt.sourceInformationMarkerStart($composer$iv2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer$iv2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv2, 0));
            CompositionLocalMap localMap$iv$iv = $composer$iv2.getCurrentCompositionLocalMap();
            modifier3 = modifier4;
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer$iv2, modifier$iv);
            Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            Composer $composer$iv$iv = $composer$iv2;
            Modifier modifier$iv$iv2 = modifier$iv;
            ComposerKt.sourceInformationMarkerStart($composer$iv2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer$iv2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer$iv2.startReusableNode();
            if ($composer$iv2.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer$iv2.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer$iv2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer$iv2);
            Function0 factory$iv$iv$iv4 = factory$iv$iv$iv;
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            boolean propagateMinConstraints$iv2 = false;
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer$iv2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            int i4 = ((0 >> 6) & 112) | 6;
            BoxScope $this$BoxComponent_u24lambda_u2402 = BoxScopeInstance.INSTANCE;
            BoxScope $this$BoxComponent_u24lambda_u2403 = $this$BoxComponent_u24lambda_u2402;
            Composer $composer5 = $composer$iv2;
            Composer $composer$iv3 = $composer$iv2;
            ComposerKt.sourceInformationMarkerStart($composer5, -1797771265, "C:BoxComponent.kt#ay1t0q");
            $composer5.startReplaceGroup(1604576480);
            ComposerKt.sourceInformation($composer5, RoomRecommendViewModel.EMPTY_CURSOR);
            Object obj = map.get("children");
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type java.util.ArrayList<*>");
            Iterable $this$forEach$iv = (ArrayList) obj;
            for (Object element$iv : $this$forEach$iv) {
                Intrinsics.checkNotNull(element$iv, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any>");
                Map child = (Map) element$iv;
                Composer $composer$iv4 = $composer$iv2;
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
                if (styleChild.get("align") != null) {
                    materialized$iv$iv = materialized$iv$iv2;
                    $composer5.startReplaceGroup(-374061491);
                    ComposerKt.sourceInformation($composer5, "42@1585L65");
                    Function2<String, Map<String, ? extends Object>, Object> valueBridge = vm.getValueBridge();
                    Composer $composer6 = $composer5;
                    Object obj4 = styleChild.get("align");
                    Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type kotlin.String");
                    Object invoke = valueBridge.invoke("execAntlr", MapsKt.mapOf(new Pair[]{TuplesKt.to("expression", (String) obj4), TuplesKt.to("data", map2)}));
                    Intrinsics.checkNotNull(invoke, "null cannot be cast to non-null type kotlin.String");
                    String align = (String) invoke;
                    $composer2 = $composer$iv$iv;
                    modifier$iv$iv = modifier$iv$iv2;
                    factory$iv$iv$iv2 = factory$iv$iv$iv4;
                    $this$BoxComponent_u24lambda_u240 = $this$BoxComponent_u24lambda_u2403;
                    $composer$iv = $composer$iv3;
                    propagateMinConstraints$iv = propagateMinConstraints$iv2;
                    ComponentBuilderKt.BuildComponentTree((Map) element$iv, map2, $this$BoxComponent_u24lambda_u2403.align(Modifier.Companion, MappingHelperKt.mappingAlign(align)), $composer6, $dirty2 & 112, 0);
                    $composer6.endReplaceGroup();
                    $composer3 = $composer6;
                } else {
                    materialized$iv$iv = materialized$iv$iv2;
                    $composer2 = $composer$iv$iv;
                    modifier$iv$iv = modifier$iv$iv2;
                    factory$iv$iv$iv2 = factory$iv$iv$iv4;
                    $this$BoxComponent_u24lambda_u240 = $this$BoxComponent_u24lambda_u2403;
                    $composer$iv = $composer$iv3;
                    propagateMinConstraints$iv = propagateMinConstraints$iv2;
                    $composer3 = $composer5;
                    $composer3.startReplaceGroup(-373653593);
                    ComposerKt.sourceInformation($composer3, "44@1688L38");
                    ComponentBuilderKt.BuildComponentTree((Map) element$iv, map2, Modifier.Companion, $composer3, ($dirty2 & 112) | 384, 0);
                    $composer3.endReplaceGroup();
                }
                $composer5 = $composer3;
                $this$BoxComponent_u24lambda_u2403 = $this$BoxComponent_u24lambda_u240;
                propagateMinConstraints$iv2 = propagateMinConstraints$iv;
                $composer$iv2 = $composer$iv4;
                $composer$iv3 = $composer$iv;
                materialized$iv$iv2 = materialized$iv$iv;
                factory$iv$iv$iv4 = factory$iv$iv$iv2;
                modifier$iv$iv2 = modifier$iv$iv;
                $composer$iv$iv = $composer2;
            }
            Composer $composer7 = $composer5;
            $composer7.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer7);
            ComposerKt.sourceInformationMarkerEnd($composer$iv3);
            $composer$iv2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv2);
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer4.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.mallDynamicPage.component.base.BoxComponentKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj5, Object obj6) {
                    Unit BoxComponent$lambda$1;
                    BoxComponent$lambda$1 = BoxComponentKt.BoxComponent$lambda$1(map, map2, style, modifier5, $changed, i, (Composer) obj5, ((Integer) obj6).intValue());
                    return BoxComponent$lambda$1;
                }
            });
        }
    }
}