package kntr.app.mall.mallDynamicPage.parser;

import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import java.util.ArrayList;
import java.util.Map;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.app.mall.mallDynamicPage.MallDynamicPageViewKt;
import kntr.app.mall.mallDynamicPage.MallDynamicPageViewModel;
import kntr.app.mall.mallDynamicPage.bean.Props;
import kntr.app.mall.mallDynamicPage.bean.Style;
import kntr.app.mall.mallDynamicPage.component.base.BoxComponentKt;
import kntr.app.mall.mallDynamicPage.component.base.ButtonComponentKt;
import kntr.app.mall.mallDynamicPage.component.base.CheckBoxComponentKt;
import kntr.app.mall.mallDynamicPage.component.base.ColumnComponentKt;
import kntr.app.mall.mallDynamicPage.component.base.ImageComponentKt;
import kntr.app.mall.mallDynamicPage.component.base.LazyVerticalGridComponentKt;
import kntr.app.mall.mallDynamicPage.component.base.RowComponentKt;
import kntr.app.mall.mallDynamicPage.component.base.TextComponentKt;
import kntr.app.mall.mallDynamicPage.component.business.FeedsComponentKt;
import kntr.app.mall.mallDynamicPage.component.business.HeaderComponentKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.json.JsonPrimitive;

/* compiled from: ComponentBuilder.kt */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a?\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0001¢\u0006\u0002\u0010\t\u001aO\u0010\n\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0001¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, d2 = {"BuildComponentTree", RoomRecommendViewModel.EMPTY_CURSOR, "uiMap", RoomRecommendViewModel.EMPTY_CURSOR, RoomRecommendViewModel.EMPTY_CURSOR, RoomRecommendViewModel.EMPTY_CURSOR, "data", "modifier", "Landroidx/compose/ui/Modifier;", "(Ljava/util/Map;Ljava/util/Map;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "MapComponent", "style", "Lkntr/app/mall/mallDynamicPage/bean/Style;", "props", "Lkntr/app/mall/mallDynamicPage/bean/Props;", "(Ljava/util/Map;Ljava/util/Map;Lkntr/app/mall/mallDynamicPage/bean/Style;Lkntr/app/mall/mallDynamicPage/bean/Props;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "mallDynamicPage_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ComponentBuilderKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BuildComponentTree$lambda$1(Map map, Map map2, Modifier modifier, int i, int i2, Composer composer, int i3) {
        BuildComponentTree(map, map2, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BuildComponentTree$lambda$2$1(Map map, Map map2, Modifier modifier, int i, int i2, Composer composer, int i3) {
        BuildComponentTree(map, map2, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BuildComponentTree$lambda$5(Map map, Map map2, Modifier modifier, int i, int i2, Composer composer, int i3) {
        BuildComponentTree(map, map2, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MapComponent$lambda$0(Map map, Map map2, Style style, Props props, Modifier modifier, int i, int i2, Composer composer, int i3) {
        MapComponent(map, map2, style, props, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:129:0x033f, code lost:
        if (r0 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x03af, code lost:
        if (r0 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L95;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v54 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void BuildComponentTree(final Map<String, ? extends Object> map, final Map<String, ? extends Object> map2, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Modifier modifier3;
        Object ifResult;
        Object ifResult2;
        Modifier modifierClick;
        String str;
        Intrinsics.checkNotNullParameter(map, "uiMap");
        Intrinsics.checkNotNullParameter(map2, "data");
        Composer $composer2 = $composer.startRestartGroup(-379243139);
        ComposerKt.sourceInformation($composer2, "C(BuildComponentTree)N(uiMap,data,modifier)30@1339L22,104@3981L54:ComponentBuilder.kt#7p8zsd");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(map) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(map2) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute(($dirty2 & 147) != 146, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i2 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-379243139, $dirty2, -1, "kntr.app.mall.mallDynamicPage.parser.BuildComponentTree (ComponentBuilder.kt:29)");
            }
            final MallDynamicPageViewModel vm = MallDynamicPageViewKt.currentPageViewModel($composer2, 0);
            Object obj = map.get("options");
            Map map3 = obj instanceof Map ? (Map) obj : null;
            if (map3 == null) {
                map3 = MapsKt.emptyMap();
            }
            Map options = map3;
            if (options.get("if") != null) {
                Function2<String, Map<String, ? extends Object>, Object> valueBridge = vm.getValueBridge();
                Object obj2 = options.get("if");
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
                ifResult = valueBridge.invoke("execAntlr", MapsKt.mapOf(new Pair[]{TuplesKt.to("expression", (String) obj2), TuplesKt.to("data", map2)}));
            } else {
                ifResult = null;
            }
            if (ifResult instanceof JsonPrimitive) {
                ifResult = ((JsonPrimitive) ifResult).getContent();
            }
            Object ifResult3 = ifResult;
            if (ifResult3 != null) {
                System.out.println((Object) ("wbw---regular: " + options.get("if")));
                System.out.println((Object) ("wbw---Type: " + Reflection.getOrCreateKotlinClass(ifResult3.getClass()).getQualifiedName() + " --Value: " + ifResult3));
            }
            if (ifResult3 == null || !Intrinsics.areEqual(ifResult3, false)) {
                Object obj3 = options.get("for");
                String forPath = obj3 instanceof String ? (String) obj3 : null;
                if (forPath == null) {
                    $composer2.startReplaceGroup(2027452282);
                    $composer2.endReplaceGroup();
                    ifResult2 = ifResult3;
                } else {
                    $composer2.startReplaceGroup(2027452283);
                    ComposerKt.sourceInformation($composer2, RoomRecommendViewModel.EMPTY_CURSOR);
                    if (!map2.containsKey(forPath)) {
                        ifResult2 = ifResult3;
                        $composer2.startReplaceGroup(1152187038);
                        $composer2.endReplaceGroup();
                        $composer2.endReplaceGroup();
                    } else {
                        $composer2.startReplaceGroup(1154299998);
                        ComposerKt.sourceInformation($composer2, RoomRecommendViewModel.EMPTY_CURSOR);
                        Object obj4 = map2.get(forPath);
                        Iterable dataList = obj4 instanceof ArrayList ? (ArrayList) obj4 : null;
                        if (dataList == null) {
                            $composer2.startReplaceGroup(1154383077);
                        } else {
                            $composer2.startReplaceGroup(1154383078);
                            ComposerKt.sourceInformation($composer2, RoomRecommendViewModel.EMPTY_CURSOR);
                            Iterable $this$forEach$iv = dataList;
                            for (Object element$iv : $this$forEach$iv) {
                                if (element$iv instanceof Map) {
                                    $composer2.startReplaceGroup(-2112240348);
                                    ComposerKt.sourceInformation($composer2, "56@2294L65");
                                    BuildComponentTree(map, (Map) element$iv, modifier3, $composer2, ($dirty2 & 14) | ($dirty2 & 896), 0);
                                } else {
                                    $composer2.startReplaceGroup(-2114498419);
                                }
                                $composer2.endReplaceGroup();
                            }
                        }
                        $composer2.endReplaceGroup();
                        $composer2.endReplaceGroup();
                        $composer2.endReplaceGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                            final Modifier modifier4 = modifier3;
                            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.mallDynamicPage.parser.ComponentBuilderKt$$ExternalSyntheticLambda2
                                public final Object invoke(Object obj5, Object obj6) {
                                    Unit BuildComponentTree$lambda$2$1;
                                    BuildComponentTree$lambda$2$1 = ComponentBuilderKt.BuildComponentTree$lambda$2$1(map, map2, modifier4, $changed, i, (Composer) obj5, ((Integer) obj6).intValue());
                                    return BuildComponentTree$lambda$2$1;
                                }
                            });
                            return;
                        }
                        return;
                    }
                }
                Style style = (Style) vm.getJsonBuilder().decodeFromJsonElement(Style.Companion.serializer(), JsonParserKt.mapToJsonObject(JsonParserKt.calAntlrExec(vm, options.get("style"), map2)));
                Props props = (Props) vm.getJsonBuilder().decodeFromJsonElement(Props.Companion.serializer(), JsonParserKt.mapToJsonObject(JsonParserKt.calAntlrExec(vm, options.get("props"), map2)));
                Object obj5 = options.get("on");
                Map map4 = obj5 instanceof Map ? (Map) obj5 : null;
                if (map4 == null) {
                    map4 = MapsKt.emptyMap();
                }
                Map on = map4;
                Object obj6 = on.get("click");
                Map map5 = obj6 instanceof Map ? (Map) obj6 : null;
                if (map5 == null) {
                    map5 = MapsKt.emptyMap();
                }
                final Map click = map5;
                Object obj7 = on.get("create");
                Map map6 = obj7 instanceof Map ? (Map) obj7 : null;
                if (map6 == null) {
                    map6 = MapsKt.emptyMap();
                }
                final Map create = map6;
                Object obj8 = on.get("destroy");
                final Map destroy = obj8 instanceof Map ? (Map) obj8 : null;
                if (destroy == null) {
                    destroy = MapsKt.emptyMap();
                }
                Modifier modifierClick2 = modifier3;
                if (on.isEmpty()) {
                    modifierClick = modifierClick2;
                    $composer2.startReplaceGroup(2025404485);
                    $composer2.endReplaceGroup();
                } else {
                    $composer2.startReplaceGroup(2028520078);
                    ComposerKt.sourceInformation($composer2, "88@3450L512,88@3427L535");
                    if (click.isEmpty()) {
                        str = "CC(remember):ComponentBuilder.kt#9igjgp";
                        $composer2.startReplaceGroup(2025404485);
                        $composer2.endReplaceGroup();
                    } else {
                        $composer2.startReplaceGroup(2028535702);
                        ComposerKt.sourceInformation($composer2, "82@3212L196");
                        ComposerKt.sourceInformationMarkerStart($composer2, 619627969, "CC(remember):ComponentBuilder.kt#9igjgp");
                        boolean invalid$iv = $composer2.changedInstance(click) | $composer2.changedInstance(vm) | $composer2.changedInstance(map2);
                        Object value$iv = $composer2.rememberedValue();
                        if (invalid$iv) {
                        }
                        value$iv = new Function0() { // from class: kntr.app.mall.mallDynamicPage.parser.ComponentBuilderKt$$ExternalSyntheticLambda3
                            public final Object invoke() {
                                Unit BuildComponentTree$lambda$3$0;
                                BuildComponentTree$lambda$3$0 = ComponentBuilderKt.BuildComponentTree$lambda$3$0(click, vm, map2);
                                return BuildComponentTree$lambda$3$0;
                            }
                        };
                        $composer2.updateRememberedValue(value$iv);
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        str = "CC(remember):ComponentBuilder.kt#9igjgp";
                        modifierClick2 = ClickableKt.clickable-oSLSa3U$default(modifier3, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) value$iv, 15, (Object) null);
                        $composer2.endReplaceGroup();
                    }
                    Unit unit = Unit.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart($composer2, 619635901, str);
                    boolean invalid$iv2 = $composer2.changedInstance(create) | $composer2.changedInstance(vm) | $composer2.changedInstance(map2) | $composer2.changedInstance(destroy);
                    Modifier modifierClick3 = modifierClick2;
                    Object value$iv2 = $composer2.rememberedValue();
                    if (invalid$iv2) {
                    }
                    value$iv2 = new Function1() { // from class: kntr.app.mall.mallDynamicPage.parser.ComponentBuilderKt$$ExternalSyntheticLambda4
                        public final Object invoke(Object obj9) {
                            DisposableEffectResult BuildComponentTree$lambda$4$0;
                            BuildComponentTree$lambda$4$0 = ComponentBuilderKt.BuildComponentTree$lambda$4$0(create, vm, map2, destroy, (DisposableEffectScope) obj9);
                            return BuildComponentTree$lambda$4$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    EffectsKt.DisposableEffect(unit, (Function1) value$iv2, $composer2, 6);
                    $composer2.endReplaceGroup();
                    modifierClick = modifierClick3;
                }
                MapComponent(map, map2, style, props, modifierClick, $composer2, ($dirty2 & 14) | ($dirty2 & 112), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup2 = $composer2.endRestartGroup();
                if (endRestartGroup2 != null) {
                    final Modifier modifier5 = modifier3;
                    endRestartGroup2.updateScope(new Function2() { // from class: kntr.app.mall.mallDynamicPage.parser.ComponentBuilderKt$$ExternalSyntheticLambda1
                        public final Object invoke(Object obj9, Object obj10) {
                            Unit BuildComponentTree$lambda$1;
                            BuildComponentTree$lambda$1 = ComponentBuilderKt.BuildComponentTree$lambda$1(map, map2, modifier5, $changed, i, (Composer) obj9, ((Integer) obj10).intValue());
                            return BuildComponentTree$lambda$1;
                        }
                    });
                    return;
                }
                return;
            }
        }
        ScopeUpdateScope endRestartGroup3 = $composer2.endRestartGroup();
        if (endRestartGroup3 != null) {
            final Modifier modifier6 = modifier3;
            endRestartGroup3.updateScope(new Function2() { // from class: kntr.app.mall.mallDynamicPage.parser.ComponentBuilderKt$$ExternalSyntheticLambda5
                public final Object invoke(Object obj9, Object obj10) {
                    Unit BuildComponentTree$lambda$5;
                    BuildComponentTree$lambda$5 = ComponentBuilderKt.BuildComponentTree$lambda$5(map, map2, modifier6, $changed, i, (Composer) obj9, ((Integer) obj10).intValue());
                    return BuildComponentTree$lambda$5;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BuildComponentTree$lambda$3$0(Map $click, MallDynamicPageViewModel $vm, Map $data) {
        Object obj = $click.get("name");
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
        String name = (String) obj;
        Object obj2 = $click.get("params");
        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any>");
        Map params = (Map) obj2;
        $vm.executeJs(name, params, $data);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult BuildComponentTree$lambda$4$0(Map $create, final MallDynamicPageViewModel $vm, final Map $data, final Map $destroy, DisposableEffectScope $this$DisposableEffect) {
        Intrinsics.checkNotNullParameter($this$DisposableEffect, "$this$DisposableEffect");
        if (!$create.isEmpty()) {
            Object obj = $create.get("name");
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            String name = (String) obj;
            Object obj2 = $create.get("params");
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any>");
            Map params = (Map) obj2;
            $vm.executeJs(name, params, $data);
        }
        return new DisposableEffectResult() { // from class: kntr.app.mall.mallDynamicPage.parser.ComponentBuilderKt$BuildComponentTree$lambda$4$0$$inlined$onDispose$1
            public void dispose() {
                if ($destroy.isEmpty()) {
                    return;
                }
                Object obj3 = $destroy.get("name");
                Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.String");
                String name2 = (String) obj3;
                Object obj4 = $destroy.get("params");
                Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any>");
                Map params2 = (Map) obj4;
                $vm.executeJs(name2, params2, $data);
            }
        };
    }

    public static final void MapComponent(final Map<String, ? extends Object> map, final Map<String, ? extends Object> map2, final Style style, final Props props, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Composer $composer2;
        Modifier modifier3;
        Modifier modifier4;
        Modifier modifier5;
        Intrinsics.checkNotNullParameter(map, "uiMap");
        Intrinsics.checkNotNullParameter(map2, "data");
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(props, "props");
        Composer $composer3 = $composer.startRestartGroup(117671898);
        ComposerKt.sourceInformation($composer3, "C(MapComponent)N(uiMap,data,style,props,modifier):ComponentBuilder.kt#7p8zsd");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changedInstance(map) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changedInstance(map2) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer3.changedInstance(style) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer3.changedInstance(props) ? 2048 : 1024;
        }
        int i2 = i & 16;
        if (i2 != 0) {
            $dirty |= 24576;
            modifier2 = modifier;
        } else if (($changed & 24576) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 16384 : 8192;
        } else {
            modifier2 = modifier;
        }
        int $dirty2 = $dirty;
        if ($composer3.shouldExecute(($dirty2 & 9363) != 9362, $dirty2 & 1)) {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(117671898, $dirty2, -1, "kntr.app.mall.mallDynamicPage.parser.MapComponent (ComponentBuilder.kt:114)");
            }
            Object name = map.get("name");
            if (Intrinsics.areEqual(name, "Box")) {
                $composer3.startReplaceGroup(870397006);
                ComposerKt.sourceInformation($composer3, "116@4267L42");
                BoxComponentKt.BoxComponent(map, map2, style, modifier4, $composer3, ($dirty2 & 14) | ($dirty2 & 112) | ($dirty2 & 896) | (($dirty2 >> 3) & 7168), 0);
                $composer3.endReplaceGroup();
                modifier5 = modifier4;
                $composer2 = $composer3;
            } else if (Intrinsics.areEqual(name, "Column")) {
                $composer3.startReplaceGroup(870472708);
                ComposerKt.sourceInformation($composer3, "120@4343L52");
                ColumnComponentKt.ColumnComponent(map, map2, style, props, modifier4, $composer3, ($dirty2 & 14) | ($dirty2 & 112) | ($dirty2 & 896) | ($dirty2 & 7168) | (57344 & $dirty2), 0);
                $composer3.endReplaceGroup();
                modifier5 = modifier4;
                $composer2 = $composer3;
            } else if (!Intrinsics.areEqual(name, "Row")) {
                if (!Intrinsics.areEqual(name, "Text")) {
                    if (!Intrinsics.areEqual(name, "Image")) {
                        if (!Intrinsics.areEqual(name, "Header")) {
                            if (!Intrinsics.areEqual(name, "CheckBox")) {
                                if (!Intrinsics.areEqual(name, "Button")) {
                                    if (!Intrinsics.areEqual(name, "LazyVerticalGrid")) {
                                        if (Intrinsics.areEqual(name, "FeedsComponent")) {
                                            $composer3.startReplaceGroup(871103589);
                                            ComposerKt.sourceInformation($composer3, "152@4979L51");
                                            FeedsComponentKt.FeedsComponent(map, map2, props, style, modifier4, $composer3, ($dirty2 & 14) | ($dirty2 & 112) | (($dirty2 >> 3) & 896) | (($dirty2 << 3) & 7168) | (57344 & $dirty2), 0);
                                            $composer3.endReplaceGroup();
                                            modifier5 = modifier4;
                                            $composer2 = $composer3;
                                        } else {
                                            $composer3.startReplaceGroup(871183352);
                                            ComposerKt.sourceInformation($composer3, "156@5060L32");
                                            modifier5 = modifier4;
                                            $composer2 = $composer3;
                                            TextKt.Text-Nvy7gAk("Unknown component: " + name, (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer2, 0, 0, 262142);
                                            $composer2.endReplaceGroup();
                                        }
                                    } else {
                                        $composer3.startReplaceGroup(871000762);
                                        ComposerKt.sourceInformation($composer3, "148@4875L62");
                                        LazyVerticalGridComponentKt.LazyVerticalGridComponent(map, map2, props, style, modifier4, $composer3, ($dirty2 & 14) | ($dirty2 & 112) | (($dirty2 >> 3) & 896) | (($dirty2 << 3) & 7168) | (57344 & $dirty2), 0);
                                        $composer3.endReplaceGroup();
                                        modifier5 = modifier4;
                                        $composer2 = $composer3;
                                    }
                                } else {
                                    $composer3.startReplaceGroup(870917713);
                                    ComposerKt.sourceInformation($composer3, "144@4792L39");
                                    ButtonComponentKt.ButtonComponent(props, style, modifier4, $composer3, (($dirty2 >> 9) & 14) | (($dirty2 >> 3) & 112) | (($dirty2 >> 6) & 896), 0);
                                    $composer3.endReplaceGroup();
                                    modifier5 = modifier4;
                                    $composer2 = $composer3;
                                }
                            } else {
                                $composer3.startReplaceGroup(870843375);
                                ComposerKt.sourceInformation($composer3, "140@4717L41");
                                CheckBoxComponentKt.CheckBoxComponent(props, style, modifier4, $composer3, (($dirty2 >> 9) & 14) | (($dirty2 >> 3) & 112) | (($dirty2 >> 6) & 896), 0);
                                $composer3.endReplaceGroup();
                                modifier5 = modifier4;
                                $composer2 = $composer3;
                            }
                        } else {
                            $composer3.startReplaceGroup(870775640);
                            ComposerKt.sourceInformation($composer3, "136@4649L32");
                            HeaderComponentKt.HeaderComponent(props, modifier4, $composer3, (($dirty2 >> 9) & 14) | (($dirty2 >> 9) & 112), 0);
                            $composer3.endReplaceGroup();
                            modifier5 = modifier4;
                            $composer2 = $composer3;
                        }
                    } else {
                        $composer3.startReplaceGroup(870704402);
                        ComposerKt.sourceInformation($composer3, "132@4577L38");
                        ImageComponentKt.ImageComponent(props, style, modifier4, $composer3, (($dirty2 >> 9) & 14) | (($dirty2 >> 3) & 112) | (($dirty2 >> 6) & 896), 0);
                        $composer3.endReplaceGroup();
                        modifier5 = modifier4;
                        $composer2 = $composer3;
                    }
                } else {
                    $composer3.startReplaceGroup(870634931);
                    ComposerKt.sourceInformation($composer3, "128@4507L37");
                    TextComponentKt.TextComponent(props, style, modifier4, $composer3, (($dirty2 >> 9) & 14) | (($dirty2 >> 3) & 112) | (($dirty2 >> 6) & 896), 0);
                    $composer3.endReplaceGroup();
                    modifier5 = modifier4;
                    $composer2 = $composer3;
                }
            } else {
                $composer3.startReplaceGroup(870554951);
                ComposerKt.sourceInformation($composer3, "124@4426L49");
                RowComponentKt.RowComponent(map, map2, style, props, modifier4, $composer3, ($dirty2 & 14) | ($dirty2 & 112) | ($dirty2 & 896) | ($dirty2 & 7168) | (57344 & $dirty2), 0);
                $composer3.endReplaceGroup();
                modifier5 = modifier4;
                $composer2 = $composer3;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier5;
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier6 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.mallDynamicPage.parser.ComponentBuilderKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit MapComponent$lambda$0;
                    MapComponent$lambda$0 = ComponentBuilderKt.MapComponent$lambda$0(map, map2, style, props, modifier6, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return MapComponent$lambda$0;
                }
            });
        }
    }
}