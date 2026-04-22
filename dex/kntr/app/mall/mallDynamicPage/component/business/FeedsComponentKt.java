package kntr.app.mall.mallDynamicPage.component.business;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.AspectRatioKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt;
import androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemScope;
import androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridScope;
import androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState;
import androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridStateKt;
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells;
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridItemSpan;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.DividerKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.IntState;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import com.bilibili.compose.theme.BiliTheme;
import com.bilibili.mall.kmm.base.MallEnvKt;
import com.bilibili.mall.kmm.common.MallBiliKtApiResponseKt;
import com.bilibili.mall.kmm.common.MallKtBiliApiResponse;
import java.util.List;
import java.util.Map;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.app.mall.mallDynamicPage.bean.Props;
import kntr.app.mall.mallDynamicPage.bean.Style;
import kntr.app.mall.mallDynamicPage.component.business.bean.FeedTag;
import kntr.app.mall.mallDynamicPage.component.business.bean.MallFeedsModel;
import kntr.app.mall.mallDynamicPage.component.business.bean.MallRecommendItem;
import kntr.app.mall.mallDynamicPage.component.business.bean.PriceInfo;
import kntr.app.mall.mallDynamicPage.component.business.bean.RecommendVO;
import kntr.app.mall.mallDynamicPage.component.business.bean.TagInfo;
import kntr.app.mall.mallDynamicPage.component.business.view.MallTagKt;
import kntr.app.mall.mallDynamicPage.parser.ComponentBuilderKt;
import kntr.app.mall.mallDynamicPage.parser.ModifierCreatorKt;
import kntr.base.imageloader.BiliImageKt;
import kntr.base.imageloader.ImageRequest;
import kntr.base.imageloader.ImageState;
import kntr.base.imageloader.ImmutableImageRequest;
import kntr.base.log.KLog_androidKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonKt;
import org.jetbrains.compose.resources.ImageResourcesKt;
import srcs.common.compose.res.generated.resources.Drawable0_commonMainKt;
import srcs.common.compose.res.generated.resources.Res;

/* compiled from: FeedsComponent.kt */
@Metadata(d1 = {"\u0000Z\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\u001aS\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0001¢\u0006\u0002\u0010\r\u001a\u0015\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0010H\u0001¢\u0006\u0002\u0010\u0011\u001a\u0015\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0001¢\u0006\u0002\u0010\u0016\u001a\u0017\u0010\u0017\u001a\u00020\u00012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0001¢\u0006\u0002\u0010\u0011\u001a\u001f\u0010\u0018\u001a\u00020\u00012\u0010\u0010\u0019\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0018\u00010\u001aH\u0001¢\u0006\u0002\u0010\u001c\u001a\u0015\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0010H\u0001¢\u0006\u0002\u0010\u0011\u001a\r\u0010\u001e\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\u001f\u001a\u0018\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020\u0015H\u0080@¢\u0006\u0002\u0010#¨\u0006$²\u0006\n\u0010%\u001a\u00020\u0004X\u008a\u008e\u0002²\u0006\n\u0010&\u001a\u00020\u0015X\u008a\u008e\u0002²\u0006\n\u0010\"\u001a\u00020\u0015X\u008a\u008e\u0002²\u0006\n\u0010'\u001a\u00020(X\u008a\u008e\u0002"}, d2 = {"FeedsComponent", RoomRecommendViewModel.EMPTY_CURSOR, "uiMap", RoomRecommendViewModel.EMPTY_CURSOR, RoomRecommendViewModel.EMPTY_CURSOR, RoomRecommendViewModel.EMPTY_CURSOR, "data", "props", "Lkntr/app/mall/mallDynamicPage/bean/Props;", "style", "Lkntr/app/mall/mallDynamicPage/bean/Style;", "modifier", "Landroidx/compose/ui/Modifier;", "(Ljava/util/Map;Ljava/util/Map;Lkntr/app/mall/mallDynamicPage/bean/Props;Lkntr/app/mall/mallDynamicPage/bean/Style;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "FeedsItem", "item", "Lkntr/app/mall/mallDynamicPage/component/business/bean/MallRecommendItem;", "(Lkntr/app/mall/mallDynamicPage/component/business/bean/MallRecommendItem;Landroidx/compose/runtime/Composer;I)V", "pxToDp", "Landroidx/compose/ui/unit/Dp;", "px", RoomRecommendViewModel.EMPTY_CURSOR, "(ILandroidx/compose/runtime/Composer;I)F", "TagTitle", "TagList", "tags", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/mall/mallDynamicPage/component/business/bean/TagInfo;", "(Ljava/util/List;Landroidx/compose/runtime/Composer;I)V", "Money", "DefaultImagePlaceHolder", "(Landroidx/compose/runtime/Composer;I)V", "loadData", "Lkntr/app/mall/mallDynamicPage/component/business/bean/RecommendVO;", "pageNum", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mallDynamicPage_debug", "title", "columns", "isLoading", RoomRecommendViewModel.EMPTY_CURSOR}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class FeedsComponentKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DefaultImagePlaceHolder$lambda$1(int i, Composer composer, int i2) {
        DefaultImagePlaceHolder(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FeedsComponent$lambda$17(Map map, Map map2, Props props, Style style, Modifier modifier, int i, int i2, Composer composer, int i3) {
        FeedsComponent(map, map2, props, style, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FeedsItem$lambda$1(MallRecommendItem mallRecommendItem, int i, Composer composer, int i2) {
        FeedsItem(mallRecommendItem, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Money$lambda$1(MallRecommendItem mallRecommendItem, int i, Composer composer, int i2) {
        Money(mallRecommendItem, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TagList$lambda$1(List list, int i, Composer composer, int i2) {
        TagList(list, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TagTitle$lambda$2(MallRecommendItem mallRecommendItem, int i, Composer composer, int i2) {
        TagTitle(mallRecommendItem, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:88:0x0279, code lost:
        if (r13 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x031f, code lost:
        if (r1 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L70;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v16 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void FeedsComponent(final Map<String, ? extends Object> map, final Map<String, ? extends Object> map2, final Props props, final Style style, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Modifier modifier3;
        Intrinsics.checkNotNullParameter(map, "uiMap");
        Intrinsics.checkNotNullParameter(map2, "data");
        Composer $composer2 = $composer.startRestartGroup(-205999867);
        ComposerKt.sourceInformation($composer2, "C(FeedsComponent)N(uiMap,data,props,style,modifier)77@3509L35,78@3564L33,79@3614L52,80@3687L66,81@3773L33,82@3828L34,83@3879L32,84@3928L24,87@3991L203,87@3970L224,95@4245L782,95@4223L804,124@5367L21,126@5428L1615,115@5033L2010:FeedsComponent.kt#9bld4r");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(map) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(map2) ? 32 : 16;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer2.changedInstance(style) ? 2048 : 1024;
        }
        int i2 = i & 16;
        if (i2 != 0) {
            $dirty |= 24576;
            modifier2 = modifier;
        } else if (($changed & 24576) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 16384 : 8192;
        } else {
            modifier2 = modifier;
        }
        int $dirty2 = $dirty;
        if ($composer2.shouldExecute(($dirty2 & 9235) != 9234, $dirty2 & 1)) {
            Modifier modifier4 = i2 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-205999867, $dirty2, -1, "kntr.app.mall.mallDynamicPage.component.business.FeedsComponent (FeedsComponent.kt:76)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, -397371064, "CC(remember):FeedsComponent.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = SnapshotStateKt.mutableStateOf$default("猜你喜欢", (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            final MutableState title$delegate = (MutableState) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, -397369306, "CC(remember):FeedsComponent.kt#9igjgp");
            Object it$iv2 = $composer2.rememberedValue();
            if (it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = SnapshotIntStateKt.mutableIntStateOf(2);
                $composer2.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            MutableIntState columns$delegate = (MutableIntState) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, -397367687, "CC(remember):FeedsComponent.kt#9igjgp");
            Object it$iv3 = $composer2.rememberedValue();
            if (it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv3 = SnapshotStateKt.mutableStateListOf();
                $composer2.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
            }
            final SnapshotStateList feeds = (SnapshotStateList) it$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Object obj = map.get("header");
            ComposerKt.sourceInformationMarkerStart($composer2, -397365337, "CC(remember):FeedsComponent.kt#9igjgp");
            boolean invalid$iv = $composer2.changed(obj);
            Object it$iv4 = $composer2.rememberedValue();
            if (invalid$iv || it$iv4 == Composer.Companion.getEmpty()) {
                Object obj2 = map.get("header");
                Object value$iv4 = obj2 instanceof Map ? (Map) obj2 : null;
                $composer2.updateRememberedValue(value$iv4);
                it$iv4 = value$iv4;
            }
            final Map headerMap = (Map) it$iv4;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, -397362618, "CC(remember):FeedsComponent.kt#9igjgp");
            Object it$iv5 = $composer2.rememberedValue();
            if (it$iv5 == Composer.Companion.getEmpty()) {
                Object value$iv5 = SnapshotIntStateKt.mutableIntStateOf(1);
                $composer2.updateRememberedValue(value$iv5);
                it$iv5 = value$iv5;
            }
            MutableIntState pageNum$delegate = (MutableIntState) it$iv5;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, -397360857, "CC(remember):FeedsComponent.kt#9igjgp");
            Object it$iv6 = $composer2.rememberedValue();
            if (it$iv6 == Composer.Companion.getEmpty()) {
                Object value$iv6 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer2.updateRememberedValue(value$iv6);
                it$iv6 = value$iv6;
            }
            MutableState isLoading$delegate = (MutableState) it$iv6;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            LazyStaggeredGridState state = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, $composer2, 0, 3);
            ComposerKt.sourceInformationMarkerStart($composer2, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart($composer2, 683736516, "CC(remember):Effects.kt#9igjgp");
            Object it$iv$iv = $composer2.rememberedValue();
            if (it$iv$iv == Composer.Companion.getEmpty()) {
                Object value$iv$iv = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer2);
                $composer2.updateRememberedValue(value$iv$iv);
                it$iv$iv = value$iv$iv;
            }
            CoroutineScope scope = (CoroutineScope) it$iv$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, -397355472, "CC(remember):FeedsComponent.kt#9igjgp");
            Object it$iv7 = $composer2.rememberedValue();
            if (it$iv7 == Composer.Companion.getEmpty()) {
                Object value$iv7 = (Function2) new FeedsComponentKt$FeedsComponent$1$1(feeds, pageNum$delegate, title$delegate, columns$delegate, null);
                $composer2.updateRememberedValue(value$iv7);
                it$iv7 = value$iv7;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(unit, (Function2) it$iv7, $composer2, 6);
            ComposerKt.sourceInformationMarkerStart($composer2, -397346765, "CC(remember):FeedsComponent.kt#9igjgp");
            boolean invalid$iv2 = $composer2.changed(state) | $composer2.changedInstance(scope);
            Object it$iv8 = $composer2.rememberedValue();
            if (invalid$iv2) {
            }
            Object value$iv8 = (Function2) new FeedsComponentKt$FeedsComponent$2$1(state, scope, isLoading$delegate, feeds, pageNum$delegate, null);
            $composer2.updateRememberedValue(value$iv8);
            it$iv8 = value$iv8;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(state, (Function2) it$iv8, $composer2, 0);
            StaggeredGridCells fixed = new StaggeredGridCells.Fixed(FeedsComponent$lambda$4(columns$delegate));
            float f = Dp.constructor-impl(10);
            Arrangement.Horizontal horizontal = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(10));
            Modifier then = ModifierCreatorKt.createModifier(SizeKt.fillMaxWidth$default(PaddingKt.padding-VpY3zN4$default(Modifier.Companion, Dp.constructor-impl(5), 0.0f, 2, (Object) null), 0.0f, 1, (Object) null), style, $composer2, (($dirty2 >> 6) & 112) | 6).then(modifier4);
            StaggeredGridCells staggeredGridCells = fixed;
            Arrangement.Horizontal horizontal2 = horizontal;
            ComposerKt.sourceInformationMarkerStart($composer2, -397308076, "CC(remember):FeedsComponent.kt#9igjgp");
            boolean invalid$iv3 = $composer2.changedInstance(headerMap) | $composer2.changedInstance(map2);
            modifier3 = modifier4;
            Object value$iv9 = $composer2.rememberedValue();
            if (invalid$iv3) {
            }
            value$iv9 = new Function1() { // from class: kntr.app.mall.mallDynamicPage.component.business.FeedsComponentKt$$ExternalSyntheticLambda11
                public final Object invoke(Object obj3) {
                    Unit FeedsComponent$lambda$16$0;
                    FeedsComponent$lambda$16$0 = FeedsComponentKt.FeedsComponent$lambda$16$0(feeds, headerMap, map2, title$delegate, (LazyStaggeredGridScope) obj3);
                    return FeedsComponent$lambda$16$0;
                }
            };
            $composer2.updateRememberedValue(value$iv9);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            LazyStaggeredGridDslKt.LazyVerticalStaggeredGrid-6qCrX9Q(staggeredGridCells, then, state, (PaddingValues) null, false, f, horizontal2, (FlingBehavior) null, false, (OverscrollEffect) null, (Function1) value$iv9, $composer2, 1769472, 0, 920);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.mallDynamicPage.component.business.FeedsComponentKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj3, Object obj4) {
                    Unit FeedsComponent$lambda$17;
                    FeedsComponent$lambda$17 = FeedsComponentKt.FeedsComponent$lambda$17(map, map2, props, style, modifier5, $changed, i, (Composer) obj3, ((Integer) obj4).intValue());
                    return FeedsComponent$lambda$17;
                }
            });
        }
    }

    private static final String FeedsComponent$lambda$1(MutableState<String> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return (String) $this$getValue$iv.getValue();
    }

    private static final int FeedsComponent$lambda$4(MutableIntState $columns$delegate) {
        IntState $this$getValue$iv = (IntState) $columns$delegate;
        return $this$getValue$iv.getIntValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int FeedsComponent$lambda$9(MutableIntState $pageNum$delegate) {
        IntState $this$getValue$iv = (IntState) $pageNum$delegate;
        return $this$getValue$iv.getIntValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean FeedsComponent$lambda$12(MutableState<Boolean> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void FeedsComponent$lambda$13(MutableState<Boolean> mutableState, boolean z) {
        Object value$iv = Boolean.valueOf(z);
        mutableState.setValue(value$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FeedsComponent$lambda$16$0(final SnapshotStateList $feeds, final Map $headerMap, final Map $data, final MutableState $title$delegate, LazyStaggeredGridScope $this$LazyVerticalStaggeredGrid) {
        Intrinsics.checkNotNullParameter($this$LazyVerticalStaggeredGrid, "$this$LazyVerticalStaggeredGrid");
        LazyStaggeredGridScope.-CC.item$default($this$LazyVerticalStaggeredGrid, (Object) null, (Object) null, StaggeredGridItemSpan.Companion.getFullLine(), ComposableLambdaKt.composableLambdaInstance(599590223, true, new Function3() { // from class: kntr.app.mall.mallDynamicPage.component.business.FeedsComponentKt$$ExternalSyntheticLambda8
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit FeedsComponent$lambda$16$0$0;
                FeedsComponent$lambda$16$0$0 = FeedsComponentKt.FeedsComponent$lambda$16$0$0($headerMap, $data, (LazyStaggeredGridItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return FeedsComponent$lambda$16$0$0;
            }
        }), 3, (Object) null);
        LazyStaggeredGridScope.-CC.item$default($this$LazyVerticalStaggeredGrid, (Object) null, (Object) null, StaggeredGridItemSpan.Companion.getFullLine(), ComposableLambdaKt.composableLambdaInstance(724055622, true, new Function3() { // from class: kntr.app.mall.mallDynamicPage.component.business.FeedsComponentKt$$ExternalSyntheticLambda9
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit FeedsComponent$lambda$16$0$1;
                FeedsComponent$lambda$16$0$1 = FeedsComponentKt.FeedsComponent$lambda$16$0$1($title$delegate, (LazyStaggeredGridItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return FeedsComponent$lambda$16$0$1;
            }
        }), 3, (Object) null);
        LazyStaggeredGridScope.-CC.items$default($this$LazyVerticalStaggeredGrid, $feeds.size(), (Function1) null, (Function1) null, (Function1) null, ComposableLambdaKt.composableLambdaInstance(387928502, true, new Function4() { // from class: kntr.app.mall.mallDynamicPage.component.business.FeedsComponentKt$$ExternalSyntheticLambda10
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                Unit FeedsComponent$lambda$16$0$2;
                FeedsComponent$lambda$16$0$2 = FeedsComponentKt.FeedsComponent$lambda$16$0$2($feeds, (LazyStaggeredGridItemScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
                return FeedsComponent$lambda$16$0$2;
            }
        }), 14, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FeedsComponent$lambda$16$0$0(Map $headerMap, Map $data, LazyStaggeredGridItemScope $this$item, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$item, "$this$item");
        ComposerKt.sourceInformation($composer, "C:FeedsComponent.kt#9bld4r");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(599590223, $changed, -1, "kntr.app.mall.mallDynamicPage.component.business.FeedsComponent.<anonymous>.<anonymous>.<anonymous> (FeedsComponent.kt:128)");
            }
            $composer.startMovableGroup(680587227, $headerMap);
            ComposerKt.sourceInformation($composer, RoomRecommendViewModel.EMPTY_CURSOR);
            if ($headerMap == null) {
                $composer.startReplaceGroup(-376590592);
            } else {
                $composer.startReplaceGroup(-376590591);
                ComposerKt.sourceInformation($composer, "*130@5566L38");
                ComponentBuilderKt.BuildComponentTree($headerMap, $data, Modifier.Companion, $composer, 384, 0);
            }
            $composer.endReplaceGroup();
            $composer.endMovableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FeedsComponent$lambda$16$0$1(MutableState $title$delegate, LazyStaggeredGridItemScope $this$item, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        Intrinsics.checkNotNullParameter($this$item, "$this$item");
        ComposerKt.sourceInformation($composer, "C139@5882L6,135@5713L1165:FeedsComponent.kt#9bld4r");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(724055622, $changed, -1, "kntr.app.mall.mallDynamicPage.component.business.FeedsComponent.<anonymous>.<anonymous>.<anonymous> (FeedsComponent.kt:135)");
            }
            Modifier modifier$iv = SizeKt.fillMaxWidth$default(BackgroundKt.background-bw27NRU$default(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, Dp.constructor-impl(20), 0.0f, Dp.constructor-impl(10), 5, (Object) null), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBg2-0d7_KjU(), (Shape) null, 2, (Object) null), 0.0f, 1, (Object) null);
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv = (384 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer, modifier$iv);
            Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i2 = ((384 >> 6) & 112) | 6;
            RowScope $this$FeedsComponent_u24lambda_u2416_u240_u241_u240 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer, 108998400, "C146@6178L6,143@6031L176,152@6443L6,156@6640L6,148@6224L447,161@6835L6,158@6688L176:FeedsComponent.kt#9bld4r");
            DividerKt.HorizontalDivider-9IZ8Weo(RowScope.-CC.weight$default($this$FeedsComponent_u24lambda_u2416_u240_u241_u240, Modifier.Companion, 1.0f, false, 2, (Object) null), Dp.constructor-impl(1), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getGa2-0d7_KjU(), $composer, 48, 0);
            TextKt.Text-Nvy7gAk(FeedsComponent$lambda$1($title$delegate), PaddingKt.padding-VpY3zN4(BackgroundKt.background-bw27NRU(PaddingKt.padding-VpY3zN4$default(Modifier.Companion, Dp.constructor-impl(2), 0.0f, 2, (Object) null), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getGa2-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(12))), Dp.constructor-impl(12), Dp.constructor-impl(6)), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, TextUnitKt.getSp(12), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer, 24576, 0, 262120);
            DividerKt.HorizontalDivider-9IZ8Weo(RowScope.-CC.weight$default($this$FeedsComponent_u24lambda_u2416_u240_u241_u240, Modifier.Companion, 1.0f, false, 2, (Object) null), Dp.constructor-impl(1), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getGa2-0d7_KjU(), $composer, 48, 0);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FeedsComponent$lambda$16$0$2(SnapshotStateList $feeds, LazyStaggeredGridItemScope $this$items, int it, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$items, "$this$items");
        ComposerKt.sourceInformation($composer, "CN(it):FeedsComponent.kt#9bld4r");
        int $dirty = $changed;
        if (($changed & 48) == 0) {
            $dirty |= $composer.changed(it) ? 32 : 16;
        }
        if (!$composer.shouldExecute(($dirty & 145) != 144, $dirty & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(387928502, $dirty, -1, "kntr.app.mall.mallDynamicPage.component.business.FeedsComponent.<anonymous>.<anonymous>.<anonymous> (FeedsComponent.kt:167)");
            }
            MallRecommendItem item = (MallRecommendItem) $feeds.get(it);
            $composer.startMovableGroup(-862862762, item.getItemId());
            ComposerKt.sourceInformation($composer, "169@6998L15");
            FeedsItem(item, $composer, 0);
            $composer.endMovableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x0364, code lost:
        if ((!r2.isEmpty()) == true) goto L40;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void FeedsItem(final MallRecommendItem item, Composer $composer, final int $changed) {
        Composer $composer2;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Composer $composer$iv$iv;
        Composer $composer$iv;
        Function0 factory$iv$iv$iv3;
        Intrinsics.checkNotNullParameter(item, "item");
        Composer $composer3 = $composer.startRestartGroup(101530392);
        ComposerKt.sourceInformation($composer3, "C(FeedsItem)N(item)180@7207L6,177@7113L1255:FeedsComponent.kt#9bld4r");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changedInstance(item) ? 4 : 2;
        }
        if ($composer3.shouldExecute(($dirty & 3) != 2, $dirty & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(101530392, $dirty, -1, "kntr.app.mall.mallDynamicPage.component.business.FeedsItem (FeedsComponent.kt:176)");
            }
            Modifier modifier$iv = BackgroundKt.background-bw27NRU(Modifier.Companion, BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getWh0-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(8)));
            ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv4;
                $composer3.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv4;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer3);
            $composer2 = $composer3;
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i2 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 1404204859, "C193@7756L244,184@7300L711,201@8020L342:FeedsComponent.kt#9bld4r");
            String cover = item.getCover();
            if (cover == null) {
                cover = RoomRecommendViewModel.EMPTY_CURSOR;
            }
            ImmutableImageRequest build = new ImageRequest(cover).contentScale(ContentScale.Companion.getFit()).build();
            Modifier modifier = PaddingKt.padding-qDBjuR0$default(ClipKt.clip(SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl((float) 177.5d)), RoundedCornerShapeKt.RoundedCornerShape-a9UjIt4(Dp.constructor-impl(8), Dp.constructor-impl(8), Dp.constructor-impl(0), Dp.constructor-impl(0))), 0.0f, 0.0f, 0.0f, Dp.constructor-impl(1), 7, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer3, 1292236694, "CC(remember):FeedsComponent.kt#9igjgp");
            Object it$iv = $composer3.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function1() { // from class: kntr.app.mall.mallDynamicPage.component.business.FeedsComponentKt$$ExternalSyntheticLambda6
                    public final Object invoke(Object obj) {
                        Unit FeedsItem$lambda$0$0$0;
                        FeedsItem$lambda$0$0$0 = FeedsComponentKt.FeedsItem$lambda$0$0$0((ImageState) obj);
                        return FeedsItem$lambda$0$0$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            BiliImageKt.BiliImage(build, modifier, (String) null, (Function1) it$iv, (Function1) null, (Function1) null, (Function1) null, ComposableSingletons$FeedsComponentKt.INSTANCE.m2059getLambda$395742371$mallDynamicPage_debug(), ComposableSingletons$FeedsComponentKt.INSTANCE.getLambda$1679631955$mallDynamicPage_debug(), $composer3, 113249280, 116);
            Modifier modifier$iv2 = PaddingKt.padding-3ABfNKs(Modifier.Companion, Dp.constructor-impl(10));
            ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv2 = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv2 = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv2, horizontalAlignment$iv2, $composer3, ((6 >> 3) & 14) | ((6 >> 3) & 112));
            int $changed$iv$iv2 = (6 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer3, modifier$iv2);
            Function0 factory$iv$iv$iv5 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv5;
                $composer3.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv5;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope2 = ColumnScopeInstance.INSTANCE;
            int i4 = ((6 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -1110689893, "C204@8100L14,210@8341L11:FeedsComponent.kt#9bld4r");
            TagTitle(item, $composer3, $dirty & 14);
            FeedTag feedTag = item.getFeedTag();
            boolean z = (feedTag == null || (r2 = feedTag.getUnderTag()) == null) ? false : true;
            if (z) {
                $composer3.startReplaceGroup(-1110616641);
                ComposerKt.sourceInformation($composer3, "206@8195L119");
                Modifier modifier$iv3 = PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, 0.0f, Dp.constructor-impl(4), 7, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getTop();
                MeasurePolicy measurePolicy$iv3 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((6 >> 3) & 14) | ((6 >> 3) & 112));
                int $changed$iv$iv3 = (6 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
                CompositionLocalMap localMap$iv$iv3 = $composer3.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer3, modifier$iv3);
                Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
                $composer$iv = $composer3;
                ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer3.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer3.startReusableNode();
                if ($composer3.getInserting()) {
                    factory$iv$iv$iv3 = factory$iv$iv$iv6;
                    $composer3.createNode(factory$iv$iv$iv3);
                } else {
                    factory$iv$iv$iv3 = factory$iv$iv$iv6;
                    $composer3.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer3);
                $composer$iv$iv = $composer3;
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
                int i5 = ($changed$iv$iv$iv3 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScope rowScope = RowScopeInstance.INSTANCE;
                int i6 = ((6 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, -34817449, "C207@8265L31:FeedsComponent.kt#9bld4r");
                FeedTag feedTag2 = item.getFeedTag();
                TagList(feedTag2 != null ? feedTag2.getUnderTag() : null, $composer3, 0);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
            } else {
                $composer$iv$iv = $composer3;
                $composer$iv = $composer3;
                $composer3.startReplaceGroup(-1118733898);
            }
            $composer3.endReplaceGroup();
            Money(item, $composer3, $dirty & 14);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.mallDynamicPage.component.business.FeedsComponentKt$$ExternalSyntheticLambda7
                public final Object invoke(Object obj, Object obj2) {
                    Unit FeedsItem$lambda$1;
                    FeedsItem$lambda$1 = FeedsComponentKt.FeedsItem$lambda$1(MallRecommendItem.this, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return FeedsItem$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FeedsItem$lambda$0$0$0(ImageState it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (it instanceof ImageState.Success) {
            KLog_androidKt.getKLog().e("FeedsComponent", "Success loading image");
        } else {
            KLog_androidKt.getKLog().e("FeedsComponent", "Error loading image");
        }
        return Unit.INSTANCE;
    }

    public static final float pxToDp(int px, Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, -181972919, "C(pxToDp)N(px)217@8450L7:FeedsComponent.kt#9bld4r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-181972919, $changed, -1, "kntr.app.mall.mallDynamicPage.component.business.pxToDp (FeedsComponent.kt:216)");
        }
        CompositionLocal this_$iv = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object consume = $composer.consume(this_$iv);
        ComposerKt.sourceInformationMarkerEnd($composer);
        Density density = (Density) consume;
        float f = density.toDp-u2uoSUM(px);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return f;
    }

    public static final void TagTitle(final MallRecommendItem item, Composer $composer, final int $changed) {
        Function0 factory$iv$iv$iv;
        Composer $composer2 = $composer.startRestartGroup(427039398);
        ComposerKt.sourceInformation($composer2, "C(TagTitle)N(item)242@9205L422:FeedsComponent.kt#9bld4r");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(item) ? 4 : 2;
        }
        if ($composer2.shouldExecute(($dirty & 3) != 2, $dirty & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(427039398, $dirty, -1, "kntr.app.mall.mallDynamicPage.component.business.TagTitle (FeedsComponent.kt:222)");
            }
            AnnotatedString.Builder $this$TagTitle_u24lambda_u240 = new AnnotatedString.Builder(0, 1, (DefaultConstructorMarker) null);
            String title = item != null ? item.getTitle() : null;
            if (title == null) {
                title = RoomRecommendViewModel.EMPTY_CURSOR;
            }
            $this$TagTitle_u24lambda_u240.append(title);
            AnnotatedString annotatedString = $this$TagTitle_u24lambda_u240.toAnnotatedString();
            Modifier modifier$iv = PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, 0.0f, Dp.constructor-impl(4), 7, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (6 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
            Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer2.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer2);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i2 = ((6 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, 708410909, "C249@9379L6,247@9307L271:FeedsComponent.kt#9bld4r");
            TextKt.Text-Z58ophY(annotatedString, (Modifier) null, BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, TextUnitKt.getSp(14), (FontStyle) null, FontWeight.Companion.getW500(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, TextUnitKt.getSp(20), TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 2, 0, (Map) null, (Function1) null, (TextStyle) null, $composer2, 1597440, 25008, 501674);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.mallDynamicPage.component.business.FeedsComponentKt$$ExternalSyntheticLambda5
                public final Object invoke(Object obj, Object obj2) {
                    Unit TagTitle$lambda$2;
                    TagTitle$lambda$2 = FeedsComponentKt.TagTitle$lambda$2(MallRecommendItem.this, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return TagTitle$lambda$2;
                }
            });
        }
    }

    public static final void TagList(final List<TagInfo> list, Composer $composer, final int $changed) {
        Function0 factory$iv$iv$iv;
        Iterable cloneTags;
        TagInfo tagInfo;
        String title;
        TagInfo tagInfo2;
        String title2;
        TagInfo tagInfo3;
        String title3;
        Composer $composer2 = $composer.startRestartGroup(-1068846199);
        ComposerKt.sourceInformation($composer2, "C(TagList)N(tags)262@9693L602:FeedsComponent.kt#9bld4r");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(list) ? 4 : 2;
        }
        if ($composer2.shouldExecute(($dirty & 3) != 2, $dirty & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1068846199, $dirty, -1, "kntr.app.mall.mallDynamicPage.component.business.TagList (FeedsComponent.kt:261)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Modifier modifier$iv = Modifier.Companion;
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getTop();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer2, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
            Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer2.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer2);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i2 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, 134787632, "C:FeedsComponent.kt#9bld4r");
            List cloneTags2 = list != null ? CollectionsKt.toMutableList(list) : null;
            Iterable cloneTags3 = cloneTags2;
            if ((list != null ? list.size() : 0) < 3) {
                cloneTags = cloneTags3;
            } else {
                int length = ((list == null || (tagInfo3 = list.get(0)) == null || (title3 = tagInfo3.getTitle()) == null) ? 0 : title3.length()) + ((list == null || (tagInfo2 = list.get(1)) == null || (title2 = tagInfo2.getTitle()) == null) ? 0 : title2.length()) + ((list == null || (tagInfo = list.get(2)) == null || (title = tagInfo.getTitle()) == null) ? 0 : title.length());
                if (length <= 11) {
                    cloneTags = TypeIntrinsics.asMutableList(list != null ? list.subList(0, 3) : null);
                } else {
                    cloneTags = TypeIntrinsics.asMutableList(list != null ? list.subList(0, 2) : null);
                }
            }
            if (cloneTags == null) {
                $composer2.startReplaceGroup(135295999);
                $composer2.endReplaceGroup();
            } else {
                $composer2.startReplaceGroup(135296000);
                ComposerKt.sourceInformation($composer2, "*277@10266L13");
                Iterable $this$forEach$iv = cloneTags;
                for (Object element$iv : $this$forEach$iv) {
                    Iterable $this$forEach$iv2 = $this$forEach$iv;
                    TagInfo item = (TagInfo) element$iv;
                    MallTagKt.MallTag(item, $composer2, 0);
                    $this$forEach$iv = $this$forEach$iv2;
                    cloneTags = cloneTags;
                }
                $composer2.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.mallDynamicPage.component.business.FeedsComponentKt$$ExternalSyntheticLambda4
                public final Object invoke(Object obj, Object obj2) {
                    Unit TagList$lambda$1;
                    TagList$lambda$1 = FeedsComponentKt.TagList$lambda$1(list, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return TagList$lambda$1;
                }
            });
        }
    }

    public static final void Money(final MallRecommendItem item, Composer $composer, final int $changed) {
        Composer $composer2;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Intrinsics.checkNotNullParameter(item, "item");
        Composer $composer3 = $composer.startRestartGroup(690461088);
        ComposerKt.sourceInformation($composer3, "C(Money)N(item)284@10361L1421:FeedsComponent.kt#9bld4r");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changedInstance(item) ? 4 : 2;
        }
        if (!$composer3.shouldExecute(($dirty & 3) != 2, $dirty & 1)) {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(690461088, $dirty, -1, "kntr.app.mall.mallDynamicPage.component.business.Money (FeedsComponent.kt:283)");
            }
            Arrangement.Horizontal spaceBetween = Arrangement.INSTANCE.getSpaceBetween();
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getBottom();
            Modifier modifier$iv = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
            Arrangement.Horizontal horizontalArrangement$iv = spaceBetween;
            ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((438 >> 3) & 14) | ((438 >> 3) & 112));
            int $changed$iv$iv = (438 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer3.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i2 = ((438 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -548199962, "C291@10559L1049,324@11693L6,322@11617L159:FeedsComponent.kt#9bld4r");
            Alignment.Vertical verticalAlignment$iv2 = Alignment.Companion.getBottom();
            ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Modifier modifier$iv2 = Modifier.Companion;
            Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.getStart();
            int compositeKeyHash$iv$iv2 = ((384 >> 3) & 14) | ((384 >> 3) & 112);
            MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer3, compositeKeyHash$iv$iv2);
            int $changed$iv$iv2 = (384 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer3, modifier$iv2);
            Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv4;
                $composer3.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv4;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer3);
            $composer2 = $composer3;
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope2 = RowScopeInstance.INSTANCE;
            int i4 = ((384 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 570763435, "C296@10736L6,294@10638L193,302@10942L6,300@10844L239,309@11192L6,307@11096L237,317@11503L6,314@11346L252:FeedsComponent.kt#9bld4r");
            PriceInfo price = item.getPrice();
            String pricePrefix = price != null ? price.getPricePrefix() : null;
            String str = pricePrefix == null ? RoomRecommendViewModel.EMPTY_CURSOR : pricePrefix;
            BiliTheme biliTheme = BiliTheme.INSTANCE;
            String str2 = RoomRecommendViewModel.EMPTY_CURSOR;
            TextKt.Text-Nvy7gAk(str, (Modifier) null, biliTheme.getColors($composer3, BiliTheme.$stable).getPi5-0d7_KjU(), (TextAutoSize) null, TextUnitKt.getSp(11), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, TextUnitKt.getSp(16), 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer3, 24576, 48, 260074);
            PriceInfo price2 = item.getPrice();
            String priceSymbol = price2 != null ? price2.getPriceSymbol() : null;
            TextKt.Text-Nvy7gAk(priceSymbol == null ? str2 : priceSymbol, (Modifier) null, BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getPi5-0d7_KjU(), (TextAutoSize) null, TextUnitKt.getSp(12), (FontStyle) null, FontWeight.Companion.getW500(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, TextUnitKt.getSp(16), 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer3, 1597440, 48, 260010);
            PriceInfo price3 = item.getPrice();
            String priceDesc = price3 != null ? price3.getPriceDesc() : null;
            TextKt.Text-Nvy7gAk(priceDesc == null ? str2 : priceDesc, (Modifier) null, BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getPi5-0d7_KjU(), (TextAutoSize) null, TextUnitKt.getSp(16), (FontStyle) null, FontWeight.Companion.getW500(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, TextUnitKt.getSp(16), 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer3, 1597440, 48, 260010);
            Modifier modifier = PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(2), 0.0f, 0.0f, 0.0f, 14, (Object) null);
            PriceInfo price4 = item.getPrice();
            String priceSuffix = price4 != null ? price4.getPriceSuffix() : null;
            TextKt.Text-Nvy7gAk(priceSuffix == null ? str2 : priceSuffix, modifier, BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getPi5-0d7_KjU(), (TextAutoSize) null, TextUnitKt.getSp(11), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, TextUnitKt.getSp(16), 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer3, 24624, 48, 260072);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            String like = item.getLike();
            if (like != null) {
                str2 = like;
            }
            TextKt.Text-Nvy7gAk(str2, (Modifier) null, BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getGa5-0d7_KjU(), (TextAutoSize) null, TextUnitKt.getSp(11), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, TextUnitKt.getSp(16), 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer3, 24576, 48, 260074);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.mallDynamicPage.component.business.FeedsComponentKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit Money$lambda$1;
                    Money$lambda$1 = FeedsComponentKt.Money$lambda$1(MallRecommendItem.this, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return Money$lambda$1;
                }
            });
        }
    }

    public static final void DefaultImagePlaceHolder(Composer $composer, final int $changed) {
        Function0 factory$iv$iv$iv;
        Composer $composer2 = $composer.startRestartGroup(1353840008);
        ComposerKt.sourceInformation($composer2, "C(DefaultImagePlaceHolder)337@11965L6,333@11843L520:FeedsComponent.kt#9bld4r");
        if (!$composer2.shouldExecute($changed != 0, $changed & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1353840008, $changed, -1, "kntr.app.mall.mallDynamicPage.component.business.DefaultImagePlaceHolder (FeedsComponent.kt:332)");
            }
            Modifier modifier$iv = BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getGraph_bg_thick-0d7_KjU(), (Shape) null, 2, (Object) null);
            Alignment contentAlignment$iv = Alignment.Companion.getCenter();
            ComposerKt.sourceInformationMarkerStart($composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (48 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
            Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer2.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer2);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i2 = ((48 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -1543879262, "C341@12079L47,340@12050L307:FeedsComponent.kt#9bld4r");
            ImageKt.Image(ImageResourcesKt.painterResource(Drawable0_commonMainKt.getIc_tv_placeholder(Res.drawable.INSTANCE), $composer2, 0), "placeholder", AspectRatioKt.aspectRatio$default(SizeKt.fillMaxWidth(Modifier.Companion, 0.3f), 1.0f, false, 2, (Object) null), (Alignment) null, ContentScale.Companion.getCrop(), 0.0f, (ColorFilter) null, $composer2, Painter.$stable | 25008, 104);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.mallDynamicPage.component.business.FeedsComponentKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    Unit DefaultImagePlaceHolder$lambda$1;
                    DefaultImagePlaceHolder$lambda$1 = FeedsComponentKt.DefaultImagePlaceHolder$lambda$1($changed, (Composer) obj, ((Integer) obj2).intValue());
                    return DefaultImagePlaceHolder$lambda$1;
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0038  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object loadData(int pageNum, Continuation<? super RecommendVO> continuation) {
        FeedsComponentKt$loadData$1 feedsComponentKt$loadData$1;
        Object mallKntrAsyncRequest;
        Json json;
        try {
            if (continuation instanceof FeedsComponentKt$loadData$1) {
                feedsComponentKt$loadData$1 = (FeedsComponentKt$loadData$1) continuation;
                if ((feedsComponentKt$loadData$1.label & Integer.MIN_VALUE) != 0) {
                    feedsComponentKt$loadData$1.label -= Integer.MIN_VALUE;
                    Object $result = feedsComponentKt$loadData$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (feedsComponentKt$loadData$1.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            Json json2 = JsonKt.Json$default((Json) null, new Function1() { // from class: kntr.app.mall.mallDynamicPage.component.business.FeedsComponentKt$$ExternalSyntheticLambda3
                                public final Object invoke(Object obj) {
                                    Unit loadData$lambda$0;
                                    loadData$lambda$0 = FeedsComponentKt.loadData$lambda$0((JsonBuilder) obj);
                                    return loadData$lambda$0;
                                }
                            }, 1, (Object) null);
                            Map mapOf = MapsKt.mapOf(new Pair[]{TuplesKt.to("pageNum", Boxing.boxInt(pageNum)), TuplesKt.to("scene", "user_home")});
                            feedsComponentKt$loadData$1.L$0 = json2;
                            feedsComponentKt$loadData$1.I$0 = pageNum;
                            feedsComponentKt$loadData$1.label = 1;
                            mallKntrAsyncRequest = MallEnvKt.mallKntrAsyncRequest("https://mall.bilibili.com/mall/noah/feed/sceneRec", "POST", (Map) null, mapOf, feedsComponentKt$loadData$1);
                            if (mallKntrAsyncRequest == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            json = json2;
                            break;
                        case 1:
                            int pageNum2 = feedsComponentKt$loadData$1.I$0;
                            json = (Json) feedsComponentKt$loadData$1.L$0;
                            ResultKt.throwOnFailure($result);
                            mallKntrAsyncRequest = $result;
                            break;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    String rawResponse = (String) mallKntrAsyncRequest;
                    Intrinsics.checkNotNull(rawResponse);
                    Json this_$iv = json;
                    this_$iv.getSerializersModule();
                    MallKtBiliApiResponse res = (MallKtBiliApiResponse) this_$iv.decodeFromString(MallKtBiliApiResponse.Companion.serializer(MallFeedsModel.Companion.serializer()), rawResponse);
                    Object asResult = MallBiliKtApiResponseKt.asResult(res);
                    ResultKt.throwOnFailure(asResult);
                    return ((MallFeedsModel) asResult).getVo();
                }
            }
            switch (feedsComponentKt$loadData$1.label) {
            }
            String rawResponse2 = (String) mallKntrAsyncRequest;
            Intrinsics.checkNotNull(rawResponse2);
            Json this_$iv2 = json;
            this_$iv2.getSerializersModule();
            MallKtBiliApiResponse res2 = (MallKtBiliApiResponse) this_$iv2.decodeFromString(MallKtBiliApiResponse.Companion.serializer(MallFeedsModel.Companion.serializer()), rawResponse2);
            Object asResult2 = MallBiliKtApiResponseKt.asResult(res2);
            ResultKt.throwOnFailure(asResult2);
            return ((MallFeedsModel) asResult2).getVo();
        } catch (Exception e) {
            KLog_androidKt.getKLog().e("FeedsComponent", "Error loading feeds data: " + e.getMessage());
            return null;
        }
        feedsComponentKt$loadData$1 = new FeedsComponentKt$loadData$1(continuation);
        Object $result2 = feedsComponentKt$loadData$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit loadData$lambda$0(JsonBuilder $this$Json) {
        Intrinsics.checkNotNullParameter($this$Json, "$this$Json");
        $this$Json.setIgnoreUnknownKeys(true);
        $this$Json.setLenient(true);
        return Unit.INSTANCE;
    }
}