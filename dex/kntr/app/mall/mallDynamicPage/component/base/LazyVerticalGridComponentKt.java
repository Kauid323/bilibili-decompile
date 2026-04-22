package kntr.app.mall.mallDynamicPage.component.base;

import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.grid.GridCells;
import androidx.compose.foundation.lazy.grid.LazyGridDslKt;
import androidx.compose.foundation.lazy.grid.LazyGridItemScope;
import androidx.compose.foundation.lazy.grid.LazyGridScope;
import androidx.compose.foundation.lazy.grid.LazyGridState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.app.mall.mallDynamicPage.MallDynamicPageViewKt;
import kntr.app.mall.mallDynamicPage.bean.Props;
import kntr.app.mall.mallDynamicPage.bean.Style;
import kntr.app.mall.mallDynamicPage.parser.ComponentBuilderKt;
import kntr.app.mall.mallDynamicPage.parser.ModifierCreatorKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LazyVerticalGridComponent.kt */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aS\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0001¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"LazyVerticalGridComponent", RoomRecommendViewModel.EMPTY_CURSOR, "uiMap", RoomRecommendViewModel.EMPTY_CURSOR, RoomRecommendViewModel.EMPTY_CURSOR, RoomRecommendViewModel.EMPTY_CURSOR, "data", "props", "Lkntr/app/mall/mallDynamicPage/bean/Props;", "style", "Lkntr/app/mall/mallDynamicPage/bean/Style;", "modifier", "Landroidx/compose/ui/Modifier;", "(Ljava/util/Map;Ljava/util/Map;Lkntr/app/mall/mallDynamicPage/bean/Props;Lkntr/app/mall/mallDynamicPage/bean/Style;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "mallDynamicPage_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class LazyVerticalGridComponentKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LazyVerticalGridComponent$lambda$1(Map map, Map map2, Props props, Style style, Modifier modifier, int i, int i2, Composer composer, int i3) {
        LazyVerticalGridComponent(map, map2, props, style, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:67:0x010e, code lost:
        if (r5 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L57;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void LazyVerticalGridComponent(final Map<String, ? extends Object> map, final Map<String, ? extends Object> map2, final Props props, final Style style, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Modifier modifier3;
        Modifier modifier4;
        Boolean userScrollEnabled;
        Integer columns;
        Intrinsics.checkNotNullParameter(map, "uiMap");
        Intrinsics.checkNotNullParameter(map2, "data");
        Composer $composer2 = $composer.startRestartGroup(988048892);
        ComposerKt.sourceInformation($composer2, "C(LazyVerticalGridComponent)N(uiMap,data,props,style,modifier)22@760L22,28@980L21,30@1041L424,23@787L678:LazyVerticalGridComponent.kt#ay1t0q");
        int $dirty = $changed;
        int i2 = 2;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(map) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(map2) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changedInstance(props) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer2.changedInstance(style) ? 2048 : 1024;
        }
        int i3 = i & 16;
        if (i3 != 0) {
            $dirty |= 24576;
            modifier2 = modifier;
        } else if (($changed & 24576) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 16384 : 8192;
        } else {
            modifier2 = modifier;
        }
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute(($dirty2 & 9363) != 9362, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i3 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(988048892, $dirty2, -1, "kntr.app.mall.mallDynamicPage.component.base.LazyVerticalGridComponent (LazyVerticalGridComponent.kt:21)");
            }
            MallDynamicPageViewKt.currentPageViewModel($composer2, 0);
            if (props != null && (columns = props.getColumns()) != null) {
                i2 = columns.intValue();
            }
            GridCells fixed = new GridCells.Fixed(i2);
            boolean booleanValue = (props == null || (userScrollEnabled = props.getUserScrollEnabled()) == null) ? true : userScrollEnabled.booleanValue();
            Modifier then = ModifierCreatorKt.createModifier(Modifier.Companion, style, $composer2, (($dirty2 >> 6) & 112) | 6).then(modifier4);
            GridCells gridCells = fixed;
            ComposerKt.sourceInformationMarkerStart($composer2, 327227908, "CC(remember):LazyVerticalGridComponent.kt#9igjgp");
            boolean invalid$iv = $composer2.changedInstance(map2) | $composer2.changedInstance(props) | $composer2.changedInstance(map);
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv) {
            }
            Object value$iv = new Function1() { // from class: kntr.app.mall.mallDynamicPage.component.base.LazyVerticalGridComponentKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj) {
                    Unit LazyVerticalGridComponent$lambda$0$0;
                    LazyVerticalGridComponent$lambda$0$0 = LazyVerticalGridComponentKt.LazyVerticalGridComponent$lambda$0$0(map2, props, map, (LazyGridScope) obj);
                    return LazyVerticalGridComponent$lambda$0$0;
                }
            };
            $composer2.updateRememberedValue(value$iv);
            it$iv = value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            LazyGridDslKt.LazyVerticalGrid(gridCells, then, (LazyGridState) null, (PaddingValues) null, false, (Arrangement.Vertical) null, (Arrangement.Horizontal) null, (FlingBehavior) null, booleanValue, (OverscrollEffect) null, (Function1) it$iv, $composer2, 0, 0, 764);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.mallDynamicPage.component.base.LazyVerticalGridComponentKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    Unit LazyVerticalGridComponent$lambda$1;
                    LazyVerticalGridComponent$lambda$1 = LazyVerticalGridComponentKt.LazyVerticalGridComponent$lambda$1(map, map2, props, style, modifier5, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return LazyVerticalGridComponent$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LazyVerticalGridComponent$lambda$0$0(Map $data, Props $props, final Map $uiMap, LazyGridScope $this$LazyVerticalGrid) {
        Intrinsics.checkNotNullParameter($this$LazyVerticalGrid, "$this$LazyVerticalGrid");
        if (!$data.isEmpty()) {
            Object obj = $data.get($props != null ? $props.getDataKey() : null);
            ArrayList arrayList = obj instanceof ArrayList ? (ArrayList) obj : null;
            final ArrayList list = arrayList != null ? arrayList : CollectionsKt.emptyList();
            LazyGridScope.-CC.items$default($this$LazyVerticalGrid, list.size(), (Function1) null, (Function2) null, (Function1) null, ComposableLambdaKt.composableLambdaInstance(-1185140366, true, new Function4() { // from class: kntr.app.mall.mallDynamicPage.component.base.LazyVerticalGridComponentKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj2, Object obj3, Object obj4, Object obj5) {
                    Unit LazyVerticalGridComponent$lambda$0$0$0;
                    LazyVerticalGridComponent$lambda$0$0$0 = LazyVerticalGridComponentKt.LazyVerticalGridComponent$lambda$0$0$0(list, $uiMap, (LazyGridItemScope) obj2, ((Integer) obj3).intValue(), (Composer) obj4, ((Integer) obj5).intValue());
                    return LazyVerticalGridComponent$lambda$0$0$0;
                }
            }), 14, (Object) null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LazyVerticalGridComponent$lambda$0$0$0(List $list, Map $uiMap, LazyGridItemScope $this$items, int it, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$items, "$this$items");
        ComposerKt.sourceInformation($composer, "CN(it)*37@1376L41:LazyVerticalGridComponent.kt#ay1t0q");
        int $dirty = $changed;
        if (($changed & 48) == 0) {
            $dirty |= $composer.changed(it) ? 32 : 16;
        }
        int $dirty2 = $dirty;
        if ($composer.shouldExecute(($dirty2 & 145) != 144, $dirty2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1185140366, $dirty2, -1, "kntr.app.mall.mallDynamicPage.component.base.LazyVerticalGridComponent.<anonymous>.<anonymous>.<anonymous> (LazyVerticalGridComponent.kt:34)");
            }
            Object obj = $list.get(it);
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any>");
            Map item = (Map) obj;
            Object obj2 = $uiMap.get("children");
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type java.util.ArrayList<*>");
            Iterable $this$forEach$iv = (ArrayList) obj2;
            for (Object element$iv : $this$forEach$iv) {
                Intrinsics.checkNotNull(element$iv, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any>");
                Map map = (Map) element$iv;
                ComponentBuilderKt.BuildComponentTree((Map) element$iv, item, Modifier.Companion, $composer, 384, 0);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }
}