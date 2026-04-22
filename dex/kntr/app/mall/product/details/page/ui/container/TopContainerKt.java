package kntr.app.mall.product.details.page.ui.container;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.animation.AnimatedContentKt;
import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.animation.AnimatedContentTransitionScope;
import androidx.compose.animation.ContentTransform;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.Easing;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.IconKt;
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
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.AlphaKt;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.draw.ShadowKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import com.bilibili.compose.iconfont.BiliIconfont;
import com.bilibili.compose.theme.BiliTheme;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kntr.app.mall.product.details.page.api.CommentInfoApiService;
import kntr.app.mall.product.details.page.api.model.ActionIconModel;
import kntr.app.mall.product.details.page.api.model.BasicInfoFloor;
import kntr.app.mall.product.details.page.api.model.CommentFloor;
import kntr.app.mall.product.details.page.api.model.DetailDescFloor;
import kntr.app.mall.product.details.page.api.model.FixedTabSkinVO;
import kntr.app.mall.product.details.page.api.model.HeaderFloor;
import kntr.app.mall.product.details.page.api.model.MallRecommendItem;
import kntr.app.mall.product.details.page.api.model.ProductDetailsResponse;
import kntr.app.mall.product.details.page.ui.components.CollectorHolder;
import kntr.app.mall.product.details.page.ui.components.ExposerKt;
import kntr.app.mall.product.details.page.ui.scale.ProvideUiScaleKt;
import kntr.app.mall.product.details.page.ui.scale.UiScaleModel;
import kntr.app.mall.product.details.page.utils.ConstsKt;
import kntr.app.mall.product.details.page.utils.DayNightTheme;
import kntr.app.mall.product.details.page.utils.HelperKt;
import kntr.app.mall.product.details.page.utils.ThemesKt;
import kntr.app.mall.product.details.page.utils.TrackConsts;
import kntr.app.mall.product.details.page.vm.ContentModule;
import kntr.app.mall.product.details.page.vm.FloorType;
import kntr.app.mall.product.details.page.vm.PageActionHandler;
import kntr.app.mall.product.details.page.vm.PageViewModel;
import kntr.app.mall.product.details.page.vm.PageViewModelWrapper;
import kntr.app.mall.product.details.page.vm.TopContainerState;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.imageloader.BiliImageKt;
import kntr.base.imageloader.ImageRequest;
import kntr.base.net.comm.flowcontrol.internal.backoff.BackoffConfigKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KFunction;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: TopContainer.kt */
@Metadata(d1 = {"\u0000 \u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a9\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0001¢\u0006\u0004\b\f\u0010\r\u001aA\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u0011\u001a\u00020\u00032\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0003¢\u0006\u0002\u0010\u0015\u001a/\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0003¢\u0006\u0002\u0010\u0017\u001a\r\u0010\u0018\u001a\u00020\u0019H\u0003¢\u0006\u0002\u0010\u001a\u001a\u0015\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003H\u0003¢\u0006\u0002\u0010\u001c\u001a\u001b\u0010\u001d\u001a\u00020\u0019*\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\u001f\u0010 \u001a_\u0010!\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00010'2\u0006\u0010(\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010*2\b\b\u0002\u0010+\u001a\u00020,2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010.H\u0003¢\u0006\u0002\u0010/\u001af\u00100\u001a\u00020\u00012\u0006\u00101\u001a\u00020%2\b\u0010)\u001a\u0004\u0018\u00010*2\u000e\u00102\u001a\n\u0012\u0004\u0012\u000203\u0018\u00010\u00132#\u0010&\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010*¢\u0006\f\b5\u0012\b\b6\u0012\u0004\b\b(7\u0012\u0004\u0012\u00020\u0001042\u0006\u0010(\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0003¢\u0006\u0002\u00108\u001ay\u00109\u001a\u00020\u00012\f\u0010:\u001a\b\u0012\u0004\u0012\u0002030\u00132\b\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010(\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010;\u001a\u00020<2\b\b\u0002\u0010=\u001a\u00020.2\u0014\b\u0002\u0010>\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003042\u0016\b\u0002\u0010&\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010*\u0012\u0004\u0012\u00020\u000104H\u0003¢\u0006\u0002\u0010?¨\u0006@²\u0006\n\u0010A\u001a\u00020BX\u008a\u0084\u0002²\u0006\f\u0010C\u001a\u0004\u0018\u00010DX\u008a\u0084\u0002²\u0006\n\u0010E\u001a\u00020.X\u008a\u0084\u0002²\u0006\n\u0010A\u001a\u00020BX\u008a\u0084\u0002²\u0006\n\u0010A\u001a\u00020BX\u008a\u0084\u0002²\u0006\n\u0010F\u001a\u00020.X\u008a\u0084\u0002²\u0006\u0010\u0010G\u001a\b\u0012\u0004\u0012\u00020H0\u0013X\u008a\u0084\u0002²\u0006\u0010\u0010I\u001a\b\u0012\u0004\u0012\u00020J0\u0013X\u008a\u0084\u0002²\u0006\n\u0010K\u001a\u00020.X\u008a\u008e\u0002²\u0006\n\u0010L\u001a\u00020.X\u008a\u008e\u0002"}, d2 = {"TopContainer", "", "scrollOffset", "", "topPadding", "Landroidx/compose/ui/unit/Dp;", "listState", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;", "pageViewModelWrapper", "Lkntr/app/mall/product/details/page/vm/PageViewModelWrapper;", "modifier", "Landroidx/compose/ui/Modifier;", "TopContainer-EUb7tLY", "(FFLandroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;Lkntr/app/mall/product/details/page/vm/PageViewModelWrapper;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "TopActionContainer", "pageViewModel", "Lkntr/app/mall/product/details/page/vm/PageViewModel;", "alpha", "actionItems", "", "Lkntr/app/mall/product/details/page/ui/container/TopActionItem;", "(FLkntr/app/mall/product/details/page/vm/PageViewModel;Landroidx/compose/ui/Modifier;FLjava/util/List;Landroidx/compose/runtime/Composer;II)V", "TopTabContainer", "(FLandroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;Lkntr/app/mall/product/details/page/vm/PageViewModel;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "getTabBgColor", "Landroidx/compose/ui/graphics/Color;", "(Landroidx/compose/runtime/Composer;I)J", "alphaFromScrollOffset", "(FLandroidx/compose/runtime/Composer;I)F", "withOverlayAlpha", "overlayAlpha", "withOverlayAlpha-DxMtmZc", "(JF)J", "TopActionButton", "iconType", "Lkntr/app/mall/product/details/page/ui/container/ActionIconType;", "scrolled", "", "onClick", "Lkotlin/Function0;", "scale", "iconUrl", "", "margin", "Landroidx/compose/foundation/layout/PaddingValues;", "count", "", "(Lkntr/app/mall/product/details/page/ui/container/ActionIconType;ZLkotlin/jvm/functions/Function0;FLandroidx/compose/ui/Modifier;Ljava/lang/String;Landroidx/compose/foundation/layout/PaddingValues;Ljava/lang/Integer;Landroidx/compose/runtime/Composer;II)V", "TopSearchComponent", "isScrolled", "salePoint", "Lkntr/app/mall/product/details/page/api/model/BasicInfoFloor$SalePoint;", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "searchText", "(ZLjava/lang/String;Ljava/util/List;Lkotlin/jvm/functions/Function1;FLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "VerticalCarouselComponent", "items", "intervalMs", "", "animDurationMs", "easing", "(Ljava/util/List;Ljava/lang/String;FLandroidx/compose/ui/Modifier;JILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "product-details-page_debug", "scaleModel", "Lkntr/app/mall/product/details/page/ui/scale/UiScaleModel;", "topContainerState", "Lkntr/app/mall/product/details/page/vm/TopContainerState;", "topContainerHeightInPixel", "selectedIndex", "contentModules", "Lkntr/app/mall/product/details/page/vm/ContentModule;", "feedBlastState", "Lkntr/app/mall/product/details/page/api/model/MallRecommendItem;", "settledIndex", "displayIndex"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TopContainerKt {

    /* compiled from: TopContainer.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ActionIconType.values().length];
            try {
                iArr[ActionIconType.SHARE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[ActionIconType.CART.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[ActionIconType.BACK.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[ActionIconType.SEARCH.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TopActionButton$lambda$0(ActionIconType actionIconType, boolean z, Function0 function0, float f, Modifier modifier, String str, PaddingValues paddingValues, Integer num, int i, int i2, Composer composer, int i3) {
        TopActionButton(actionIconType, z, function0, f, modifier, str, paddingValues, num, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TopActionButton$lambda$2$0$0(ActionIconType actionIconType, boolean z, Function0 function0, float f, Modifier modifier, String str, PaddingValues paddingValues, Integer num, int i, int i2, Composer composer, int i3) {
        TopActionButton(actionIconType, z, function0, f, modifier, str, paddingValues, num, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TopActionButton$lambda$3(ActionIconType actionIconType, boolean z, Function0 function0, float f, Modifier modifier, String str, PaddingValues paddingValues, Integer num, int i, int i2, Composer composer, int i3) {
        TopActionButton(actionIconType, z, function0, f, modifier, str, paddingValues, num, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TopActionContainer$lambda$4(float f, PageViewModel pageViewModel, Modifier modifier, float f2, List list, int i, int i2, Composer composer, int i3) {
        TopActionContainer(f, pageViewModel, modifier, f2, list, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TopContainer_EUb7tLY$lambda$7(float f, float f2, LazyStaggeredGridState lazyStaggeredGridState, PageViewModelWrapper pageViewModelWrapper, Modifier modifier, int i, int i2, Composer composer, int i3) {
        m586TopContainerEUb7tLY(f, f2, lazyStaggeredGridState, pageViewModelWrapper, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TopSearchComponent$lambda$3(boolean z, String str, List list, Function1 function1, float f, Modifier modifier, int i, int i2, Composer composer, int i3) {
        TopSearchComponent(z, str, list, function1, f, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TopTabContainer$lambda$12(float f, LazyStaggeredGridState lazyStaggeredGridState, PageViewModel pageViewModel, Modifier modifier, int i, int i2, Composer composer, int i3) {
        TopTabContainer(f, lazyStaggeredGridState, pageViewModel, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit VerticalCarouselComponent$lambda$14(List list, String str, float f, Modifier modifier, long j, int i, Function1 function1, Function1 function12, int i2, int i3, Composer composer, int i4) {
        VerticalCarouselComponent(list, str, f, modifier, j, i, function1, function12, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit VerticalCarouselComponent$lambda$3(List list, String str, float f, Modifier modifier, long j, int i, Function1 function1, Function1 function12, int i2, int i3, Composer composer, int i4) {
        VerticalCarouselComponent(list, str, f, modifier, j, i, function1, function12, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: TopContainer-EUb7tLY  reason: not valid java name */
    public static final void m586TopContainerEUb7tLY(final float scrollOffset, final float f, final LazyStaggeredGridState listState, final PageViewModelWrapper pageViewModelWrapper, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Modifier modifier3;
        List list;
        Object value$iv;
        int i2;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Intrinsics.checkNotNullParameter(listState, "listState");
        Intrinsics.checkNotNullParameter(pageViewModelWrapper, "pageViewModelWrapper");
        Composer $composer2 = $composer.startRestartGroup(-770957409);
        ComposerKt.sourceInformation($composer2, "C(TopContainer)N(scrollOffset,topPadding:c#ui.unit.Dp,listState,pageViewModelWrapper,modifier)111@5105L16,112@5203L16,124@5595L35,126@5663L7,127@5702L263,127@5675L290,135@6040L16,136@6114L1899,136@6061L1952,189@8415L15,180@8018L1355:TopContainer.kt#u9475x");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(scrollOffset) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(f) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changed(listState) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer2.changedInstance(pageViewModelWrapper) ? 2048 : 1024;
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
        if ($composer2.shouldExecute(($dirty & 9363) != 9362, $dirty & 1)) {
            if (i3 != 0) {
                modifier2 = (Modifier) Modifier.Companion;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-770957409, $dirty, -1, "kntr.app.mall.product.details.page.ui.container.TopContainer (TopContainer.kt:109)");
            }
            final PageViewModel pageViewModel = pageViewModelWrapper.getViewModel();
            State scaleModel$delegate = SnapshotStateKt.collectAsState(pageViewModel.getUiScaleModelFlow$product_details_page_debug(), (CoroutineContext) null, $composer2, 0, 1);
            State topContainerState$delegate = SnapshotStateKt.collectAsState(pageViewModel.getTopContainerState$product_details_page_debug(), (CoroutineContext) null, $composer2, 0, 1);
            TopContainerState TopContainer_EUb7tLY$lambda$1 = TopContainer_EUb7tLY$lambda$1(topContainerState$delegate);
            ContentModule.HeaderModule headerModule = TopContainer_EUb7tLY$lambda$1 != null ? TopContainer_EUb7tLY$lambda$1.getData() : null;
            HeaderFloor headerFloor = headerModule != null ? headerModule.getData() : null;
            Iterable header = headerFloor != null ? headerFloor.getHeader() : null;
            if (header == null) {
                $composer2.startReplaceGroup(1893477988);
                $composer2.endReplaceGroup();
                list = null;
            } else {
                $composer2.startReplaceGroup(1893477989);
                ComposerKt.sourceInformation($composer2, "*119@5460L93");
                Iterable $this$map$iv = header;
                Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                for (Object item$iv$iv : $this$map$iv) {
                    ActionIconModel it = (ActionIconModel) item$iv$iv;
                    ComposerKt.sourceInformationMarkerStart($composer2, -1927111902, "CC(remember):TopContainer.kt#9igjgp");
                    boolean invalid$iv = $composer2.changedInstance(pageViewModel);
                    Object it$iv = $composer2.rememberedValue();
                    if (!invalid$iv && it$iv != Composer.Companion.getEmpty()) {
                        value$iv = it$iv;
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        destination$iv$iv.add(new ActionIconModelWrapperItem(it, (Function1) value$iv));
                    }
                    value$iv = new Function1() { // from class: kntr.app.mall.product.details.page.ui.container.TopContainerKt$$ExternalSyntheticLambda17
                        public final Object invoke(Object obj) {
                            Unit TopContainer_EUb7tLY$lambda$2$0$0;
                            TopContainer_EUb7tLY$lambda$2$0$0 = TopContainerKt.TopContainer_EUb7tLY$lambda$2$0$0(PageViewModel.this, (ActionIconModel) obj);
                            return TopContainer_EUb7tLY$lambda$2$0$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    destination$iv$iv.add(new ActionIconModelWrapperItem(it, (Function1) value$iv));
                }
                list = (List) destination$iv$iv;
                $composer2.endReplaceGroup();
            }
            List topItems = list;
            float alpha = alphaFromScrollOffset(scrollOffset, $composer2, $dirty & 14);
            CompositionLocal this_$iv = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Density density = (Density) consume;
            Dp dp = Dp.box-impl(f);
            ComposerKt.sourceInformationMarkerStart($composer2, 2139301030, "CC(remember):TopContainer.kt#9igjgp");
            boolean invalid$iv2 = (($dirty & 112) == 32) | $composer2.changed(scaleModel$delegate) | $composer2.changed(density) | $composer2.changedInstance(pageViewModel);
            Object value$iv2 = $composer2.rememberedValue();
            if (invalid$iv2 || value$iv2 == Composer.Companion.getEmpty()) {
                i2 = 1;
                value$iv2 = new TopContainerKt$TopContainer$1$1(f, density, pageViewModel, scaleModel$delegate, null);
                $composer2.updateRememberedValue(value$iv2);
            } else {
                i2 = 1;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(dp, (Function2) value$iv2, $composer2, ($dirty >> 3) & 14);
            State topContainerHeightInPixel$delegate = SnapshotStateKt.collectAsState(pageViewModel.getTopContainerHeightFlow(), (CoroutineContext) null, $composer2, 0, i2);
            Integer valueOf = Integer.valueOf(TopContainer_EUb7tLY$lambda$4(topContainerHeightInPixel$delegate));
            ComposerKt.sourceInformationMarkerStart($composer2, 2139315850, "CC(remember):TopContainer.kt#9igjgp");
            int i4 = ($composer2.changed(topContainerHeightInPixel$delegate) ? 1 : 0) | (($dirty & 896) == 256 ? i2 : 0) | ($composer2.changedInstance(pageViewModel) ? 1 : 0);
            Object it$iv2 = $composer2.rememberedValue();
            if (i4 != 0 || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv3 = (Function2) new TopContainerKt$TopContainer$2$1(listState, topContainerHeightInPixel$delegate, pageViewModel, null);
                $composer2.updateRememberedValue(value$iv3);
                it$iv2 = value$iv3;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(listState, valueOf, (Function2) it$iv2, $composer2, ($dirty >> 6) & 14);
            Modifier modifier$iv = PaddingKt.padding-qDBjuR0$default(BackgroundKt.background-bw27NRU$default(ShadowKt.shadow-s4CzXII$default(SizeKt.fillMaxWidth$default(modifier2, 0.0f, 1, (Object) null), (alpha > 1.0f ? 1 : (alpha == 1.0f ? 0 : -1)) == 0 ? ProvideUiScaleKt.dpScaled(4, TopContainer_EUb7tLY$lambda$0(scaleModel$delegate).getScale()) : Dp.constructor-impl(0), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(ProvideUiScaleKt.dpScaled(8, TopContainer_EUb7tLY$lambda$0(scaleModel$delegate).getScale())), false, 0L, Color.copy-wmQWz5c$default(Color.Companion.getBlack-0d7_KjU(), 0.25f, 0.0f, 0.0f, 0.0f, 14, (Object) null), 8, (Object) null), m587withOverlayAlphaDxMtmZc(getTabBgColor($composer2, 0), alpha), (Shape) null, 2, (Object) null), 0.0f, f, 0.0f, 0.0f, 13, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
            Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            modifier3 = modifier2;
            ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer2.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer2);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i5 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i6 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, 1044334167, "C192@8516L851:TopContainer.kt#u9475x");
            Modifier modifier$iv2 = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer2, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer2, ((6 >> 3) & 14) | ((6 >> 3) & 112));
            int $changed$iv$iv2 = (6 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer2, modifier$iv2);
            Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv4;
                $composer2.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv4;
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer2);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i7 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i8 = ((6 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, 2099869744, "C193@8573L624,208@9210L147:TopContainer.kt#u9475x");
            TopActionContainer(scrollOffset, pageViewModel, null, alpha, topItems == null ? CollectionsKt.listOf(new TopActionItem() { // from class: kntr.app.mall.product.details.page.ui.container.TopContainerKt$TopContainer$3$1$1
                private final Void count;
                private final Void iconNightUrl;
                private final ActionIconType iconType = ActionIconType.BACK;
                private final Void iconUrl;
                private final Void onClick;

                @Override // kntr.app.mall.product.details.page.ui.container.TopActionItem
                public /* bridge */ /* synthetic */ Integer getCount() {
                    return (Integer) m589getCount();
                }

                @Override // kntr.app.mall.product.details.page.ui.container.TopActionItem
                public /* bridge */ /* synthetic */ String getIconNightUrl() {
                    return (String) m590getIconNightUrl();
                }

                @Override // kntr.app.mall.product.details.page.ui.container.TopActionItem
                public /* bridge */ /* synthetic */ String getIconUrl() {
                    return (String) m591getIconUrl();
                }

                @Override // kntr.app.mall.product.details.page.ui.container.TopActionItem
                public ActionIconType getIconType() {
                    return this.iconType;
                }

                @Override // kntr.app.mall.product.details.page.ui.container.TopActionItem
                /* renamed from: getOnClick */
                public Void mo592getOnClick() {
                    return this.onClick;
                }

                /* renamed from: getIconUrl  reason: collision with other method in class */
                public Void m591getIconUrl() {
                    return this.iconUrl;
                }

                /* renamed from: getIconNightUrl  reason: collision with other method in class */
                public Void m590getIconNightUrl() {
                    return this.iconNightUrl;
                }

                /* renamed from: getCount  reason: collision with other method in class */
                public Void m589getCount() {
                    return this.count;
                }
            }) : topItems, $composer2, $dirty & 14, 4);
            TopTabContainer(alpha, listState, pageViewModel, null, $composer2, ($dirty >> 3) & 112, 8);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
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
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier4 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.container.TopContainerKt$$ExternalSyntheticLambda18
                public final Object invoke(Object obj, Object obj2) {
                    Unit TopContainer_EUb7tLY$lambda$7;
                    TopContainer_EUb7tLY$lambda$7 = TopContainerKt.TopContainer_EUb7tLY$lambda$7(scrollOffset, f, listState, pageViewModelWrapper, modifier4, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return TopContainer_EUb7tLY$lambda$7;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final UiScaleModel TopContainer_EUb7tLY$lambda$0(State<UiScaleModel> state) {
        Object thisObj$iv = state.getValue();
        return (UiScaleModel) thisObj$iv;
    }

    private static final TopContainerState TopContainer_EUb7tLY$lambda$1(State<TopContainerState> state) {
        Object thisObj$iv = state.getValue();
        return (TopContainerState) thisObj$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TopContainer_EUb7tLY$lambda$2$0$0(PageViewModel $pageViewModel, ActionIconModel model) {
        Intrinsics.checkNotNullParameter(model, "model");
        $pageViewModel.handleHeaderButtonClick$product_details_page_debug(model);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int TopContainer_EUb7tLY$lambda$4(State<Integer> state) {
        Object thisObj$iv = state.getValue();
        return ((Number) thisObj$iv).intValue();
    }

    /* JADX WARN: Code restructure failed: missing block: B:114:0x0347, code lost:
        if (r14 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x05bd, code lost:
        if (r13 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L165;
     */
    /* JADX WARN: Code restructure failed: missing block: B:194:0x06fa, code lost:
        if (r4 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L123;
     */
    /* JADX WARN: Removed duplicated region for block: B:113:0x033f  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x034b  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x041c  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0428  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x042e  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x04b0  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x04d5  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x04e6  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0628  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0668  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x07b9  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x04cf A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void TopActionContainer(final float scrollOffset, final PageViewModel pageViewModel, Modifier modifier, float alpha, List<? extends TopActionItem> list, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        float f;
        Iterable actionItems;
        Modifier modifier3;
        float alpha2;
        Modifier modifier4;
        float alpha3;
        Object obj;
        Function0 factory$iv$iv$iv;
        Object value$iv;
        boolean invalid$iv;
        Function0 factory$iv$iv$iv2;
        Iterator it;
        Object obj2;
        TopActionItem it2;
        List salePoint;
        ProductDetailsResponse.ProductDetailsData data;
        BasicInfoFloor basicInfoFloorVO;
        Iterator it3;
        Composer $composer2 = $composer.startRestartGroup(1415222793);
        ComposerKt.sourceInformation($composer2, "C(TopActionContainer)N(scrollOffset,pageViewModel,modifier,alpha,actionItems)261@10616L16,263@10688L22,266@10838L285,277@11150L25,278@11180L5972:TopContainer.kt#u9475x");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(scrollOffset) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(pageViewModel) ? 32 : 16;
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
        int i3 = i & 8;
        if (i3 != 0) {
            $dirty |= 3072;
            f = alpha;
        } else if (($changed & 3072) == 0) {
            f = alpha;
            $dirty |= $composer2.changed(f) ? 2048 : 1024;
        } else {
            f = alpha;
        }
        int i4 = i & 16;
        if (i4 != 0) {
            $dirty |= 24576;
            actionItems = list;
        } else if (($changed & 24576) == 0) {
            actionItems = list;
            $dirty |= $composer2.changedInstance(actionItems) ? 16384 : 8192;
        } else {
            actionItems = list;
        }
        int $dirty2 = $dirty;
        if ($composer2.shouldExecute(($dirty2 & 9363) != 9362, $dirty2 & 1)) {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (i3 == 0) {
                alpha3 = f;
            } else {
                alpha3 = 0.0f;
            }
            if (i4 != 0) {
                actionItems = CollectionsKt.emptyList();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1415222793, $dirty2, -1, "kntr.app.mall.product.details.page.ui.container.TopActionContainer (TopContainer.kt:260)");
            }
            State scaleModel$delegate = SnapshotStateKt.collectAsState(pageViewModel.getUiScaleModelFlow$product_details_page_debug(), (CoroutineContext) null, $composer2, 0, 1);
            boolean isAtTop = scrollOffset <= 1.0f;
            final boolean isLight = Intrinsics.areEqual(ThemesKt.currentDayNightTheme($composer2, 0), DayNightTheme.Light.INSTANCE);
            Iterator<T> it4 = actionItems.iterator();
            while (true) {
                if (!it4.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it4.next();
                if (((TopActionItem) obj).getIconType() == ActionIconType.BACK) {
                    break;
                }
            }
            TopActionItem backItem = (TopActionItem) obj;
            ComposerKt.sourceInformationMarkerStart($composer2, -1475513370, "CC(remember):TopContainer.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                alpha2 = alpha3;
                Object value$iv2 = new Function1() { // from class: kntr.app.mall.product.details.page.ui.container.TopContainerKt$$ExternalSyntheticLambda8
                    public final Object invoke(Object obj3) {
                        String TopActionContainer$lambda$2$0;
                        TopActionContainer$lambda$2$0 = TopContainerKt.TopActionContainer$lambda$2$0(isLight, (TopActionItem) obj3);
                        return TopActionContainer$lambda$2$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv2);
                it$iv = value$iv2;
            } else {
                alpha2 = alpha3;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Function1 getIconUrl = (Function1) it$iv;
            CollectorHolder collectorHolder = ExposerKt.rememberCollectorHolder($composer2, 0);
            Modifier modifier$iv = AlphaKt.alpha(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, (Object) null), ProvideUiScaleKt.dpScaled(44, TopActionContainer$lambda$0(scaleModel$delegate).getScale())), isAtTop ? 1.0f : alpha2);
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            modifier3 = modifier4;
            ComposerKt.sourceInformationMarkerStart($composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer2, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv = (384 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
            Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            Iterable actionItems2 = actionItems;
            ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer2.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer2);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i5 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i6 = ((384 >> 6) & 112) | 6;
            RowScope $this$TopActionContainer_u24lambda_u243 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, 1494348016, "C307@12325L240,302@12080L485,292@11722L249,286@11436L1140,315@12586L1780:TopContainer.kt#u9475x");
            ActionIconType actionIconType = ActionIconType.BACK;
            String str = isAtTop ? null : (String) getIconUrl.invoke(backItem);
            boolean z = !isAtTop;
            PaddingValues paddingValues = PaddingKt.PaddingValues-a9UjIt4$default(ProvideUiScaleKt.dpScaled(16, TopActionContainer$lambda$0(scaleModel$delegate).getScale()), 0.0f, 0.0f, 0.0f, 14, (Object) null);
            float scale = TopActionContainer$lambda$0(scaleModel$delegate).getScale();
            Modifier modifier5 = Modifier.Companion;
            ComposerKt.sourceInformationMarkerStart($composer2, 463869749, "CC(remember):TopContainer.kt#9igjgp");
            boolean invalid$iv2 = $composer2.changedInstance(pageViewModel);
            Object it$iv2 = $composer2.rememberedValue();
            if (!invalid$iv2 && it$iv2 != Composer.Companion.getEmpty()) {
                value$iv = it$iv2;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                Modifier reportOnExposure = ExposerKt.reportOnExposure(modifier5, "top_action_back", collectorHolder, null, false, 0.5f, 0, 500L, (Function0) value$iv, $composer2, 12779574, 44);
                ComposerKt.sourceInformationMarkerStart($composer2, 463850462, "CC(remember):TopContainer.kt#9igjgp");
                invalid$iv = $composer2.changedInstance(pageViewModel);
                Object it$iv3 = $composer2.rememberedValue();
                if (invalid$iv) {
                }
                Object value$iv3 = new Function0() { // from class: kntr.app.mall.product.details.page.ui.container.TopContainerKt$$ExternalSyntheticLambda11
                    public final Object invoke() {
                        Unit TopActionContainer$lambda$3$1$0;
                        TopActionContainer$lambda$3$1$0 = TopContainerKt.TopActionContainer$lambda$3$1$0(PageViewModel.this);
                        return TopActionContainer$lambda$3$1$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                TopActionButton(actionIconType, z, (Function0) it$iv3, scale, reportOnExposure, str, paddingValues, null, $composer2, 6, 128);
                Modifier modifier$iv2 = PaddingKt.padding-VpY3zN4$default(RowScope.-CC.weight$default($this$TopActionContainer_u24lambda_u243, Modifier.Companion, 1.0f, false, 2, (Object) null), ProvideUiScaleKt.dpScaled(8, TopActionContainer$lambda$0(scaleModel$delegate).getScale()), 0.0f, 2, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
                MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                int $changed$iv$iv2 = (0 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
                CompositionLocalMap localMap$iv$iv2 = $composer2.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer2, modifier$iv2);
                Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer2.startReusableNode();
                if (!$composer2.getInserting()) {
                    factory$iv$iv$iv2 = factory$iv$iv$iv4;
                    $composer2.createNode(factory$iv$iv$iv2);
                } else {
                    factory$iv$iv$iv2 = factory$iv$iv$iv4;
                    $composer2.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer2);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
                int i7 = ($changed$iv$iv$iv2 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScope boxScope = BoxScopeInstance.INSTANCE;
                int i8 = ((0 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer2, 2123353936, "C:TopContainer.kt#u9475x");
                it = actionItems2.iterator();
                while (true) {
                    if (it.hasNext()) {
                        obj2 = null;
                        break;
                    }
                    Object next = it.next();
                    it3 = it;
                    obj2 = next;
                    if (((TopActionItem) next).getIconType() == ActionIconType.SEARCH) {
                        break;
                    }
                    it = it3;
                }
                it2 = (TopActionItem) obj2;
                if (it2 != null) {
                    $composer2.startReplaceGroup(2123410633);
                    $composer2.endReplaceGroup();
                } else {
                    $composer2.startReplaceGroup(2123410634);
                    ComposerKt.sourceInformation($composer2, "*325@12972L16,348@14027L296,343@13757L566,334@13328L317,330@13146L1196");
                    ProductDetailsResponse productDetailsResponse = (ProductDetailsResponse) SnapshotStateKt.collectAsState(pageViewModel.getProductDetailsResponse(), (CoroutineContext) null, $composer2, 0, 1).getValue();
                    if (productDetailsResponse == null || (data = productDetailsResponse.getData()) == null || (basicInfoFloorVO = data.getBasicInfoFloorVO()) == null) {
                        salePoint = null;
                    } else {
                        salePoint = basicInfoFloorVO.getSalePoint();
                    }
                    boolean z2 = !isAtTop;
                    String str2 = (String) getIconUrl.invoke(it2);
                    float scale2 = TopActionContainer$lambda$0(scaleModel$delegate).getScale();
                    Modifier modifier6 = Modifier.Companion;
                    ComposerKt.sourceInformationMarkerStart($composer2, -102013778, "CC(remember):TopContainer.kt#9igjgp");
                    boolean invalid$iv3 = $composer2.changedInstance(pageViewModel);
                    Object it$iv4 = $composer2.rememberedValue();
                    if (invalid$iv3 || it$iv4 == Composer.Companion.getEmpty()) {
                        Object value$iv4 = new Function0() { // from class: kntr.app.mall.product.details.page.ui.container.TopContainerKt$$ExternalSyntheticLambda12
                            public final Object invoke() {
                                Unit TopActionContainer$lambda$3$2$1$0$0;
                                TopActionContainer$lambda$3$2$1$0$0 = TopContainerKt.TopActionContainer$lambda$3$2$1$0$0(PageViewModel.this);
                                return TopActionContainer$lambda$3$2$1$0$0;
                            }
                        };
                        $composer2.updateRememberedValue(value$iv4);
                        it$iv4 = value$iv4;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    Modifier reportOnExposure2 = ExposerKt.reportOnExposure(modifier6, "top_search_component", collectorHolder, null, false, 0.5f, 0, 500L, (Function0) it$iv4, $composer2, 12779574, 44);
                    ComposerKt.sourceInformationMarkerStart($composer2, -102036125, "CC(remember):TopContainer.kt#9igjgp");
                    boolean invalid$iv4 = $composer2.changedInstance(pageViewModel);
                    Object it$iv5 = $composer2.rememberedValue();
                    if (invalid$iv4) {
                    }
                    Object value$iv5 = new Function1() { // from class: kntr.app.mall.product.details.page.ui.container.TopContainerKt$$ExternalSyntheticLambda13
                        public final Object invoke(Object obj3) {
                            Unit TopActionContainer$lambda$3$2$1$1$0;
                            TopActionContainer$lambda$3$2$1$1$0 = TopContainerKt.TopActionContainer$lambda$3$2$1$1$0(PageViewModel.this, (String) obj3);
                            return TopActionContainer$lambda$3$2$1$1$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv5);
                    it$iv5 = value$iv5;
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    TopSearchComponent(z2, str2, salePoint, (Function1) it$iv5, scale2, reportOnExposure2, $composer2, 0, 0);
                    Unit unit = Unit.INSTANCE;
                    $composer2.endReplaceGroup();
                    Unit unit2 = Unit.INSTANCE;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer2.startReplaceGroup(463942282);
                ComposerKt.sourceInformation($composer2, "*396@16177L936,391@15874L1239,367@14837L856,362@14551L2581");
                Iterable $this$filterNot$iv = actionItems2;
                boolean z3 = false;
                Collection destination$iv$iv = new ArrayList();
                for (Object element$iv$iv : $this$filterNot$iv) {
                    TopActionItem it5 = (TopActionItem) element$iv$iv;
                    Iterable $this$filterNot$iv2 = $this$filterNot$iv;
                    boolean z4 = z3;
                    if (!(it5.getIconType() == ActionIconType.BACK || it5.getIconType() == ActionIconType.SEARCH)) {
                        destination$iv$iv.add(element$iv$iv);
                    }
                    $this$filterNot$iv = $this$filterNot$iv2;
                    z3 = z4;
                }
                Iterable $this$forEach$iv = (List) destination$iv$iv;
                boolean z5 = false;
                for (Object element$iv : $this$forEach$iv) {
                    final TopActionItem item = (TopActionItem) element$iv;
                    ActionIconType iconType = item.getIconType();
                    String str3 = isAtTop ? null : (String) getIconUrl.invoke(item);
                    boolean z6 = !isAtTop;
                    Iterable $this$forEach$iv2 = $this$forEach$iv;
                    Function1 getIconUrl2 = getIconUrl;
                    PaddingValues paddingValues2 = PaddingKt.PaddingValues-a9UjIt4$default(0.0f, 0.0f, ProvideUiScaleKt.dpScaled(16, TopActionContainer$lambda$0(scaleModel$delegate).getScale()), 0.0f, 11, (Object) null);
                    Integer count = item.getCount();
                    float scale3 = TopActionContainer$lambda$0(scaleModel$delegate).getScale();
                    State scaleModel$delegate2 = scaleModel$delegate;
                    boolean z7 = z5;
                    String str4 = "top_action_" + item.getIconType().getValue();
                    Modifier modifier7 = Modifier.Companion;
                    ComposerKt.sourceInformationMarkerStart($composer2, 946161126, "CC(remember):TopContainer.kt#9igjgp");
                    boolean invalid$iv5 = $composer2.changedInstance(item) | $composer2.changedInstance(pageViewModel);
                    Object it$iv6 = $composer2.rememberedValue();
                    if (invalid$iv5) {
                    }
                    Object value$iv6 = new Function0() { // from class: kntr.app.mall.product.details.page.ui.container.TopContainerKt$$ExternalSyntheticLambda14
                        public final Object invoke() {
                            Unit TopActionContainer$lambda$3$4$0$0;
                            TopActionContainer$lambda$3$4$0$0 = TopContainerKt.TopActionContainer$lambda$3$4$0$0(TopActionItem.this, pageViewModel);
                            return TopActionContainer$lambda$3$4$0$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv6);
                    it$iv6 = value$iv6;
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    Modifier reportOnExposure3 = ExposerKt.reportOnExposure(modifier7, str4, collectorHolder, null, false, 0.5f, 0, 500L, (Function0) it$iv6, $composer2, 12779526, 44);
                    ComposerKt.sourceInformationMarkerStart($composer2, 946118166, "CC(remember):TopContainer.kt#9igjgp");
                    boolean invalid$iv6 = $composer2.changedInstance(item) | $composer2.changedInstance(pageViewModel);
                    Object it$iv7 = $composer2.rememberedValue();
                    if (!invalid$iv6 && it$iv7 != Composer.Companion.getEmpty()) {
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        TopActionButton(iconType, z6, (Function0) it$iv7, scale3, reportOnExposure3, str3, paddingValues2, count, $composer2, 0, 0);
                        $this$forEach$iv = $this$forEach$iv2;
                        getIconUrl = getIconUrl2;
                        scaleModel$delegate = scaleModel$delegate2;
                        z5 = z7;
                    }
                    Object value$iv7 = new Function0() { // from class: kntr.app.mall.product.details.page.ui.container.TopContainerKt$$ExternalSyntheticLambda15
                        public final Object invoke() {
                            Unit TopActionContainer$lambda$3$4$1$0;
                            TopActionContainer$lambda$3$4$1$0 = TopContainerKt.TopActionContainer$lambda$3$4$1$0(TopActionItem.this, pageViewModel);
                            return TopActionContainer$lambda$3$4$1$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv7);
                    it$iv7 = value$iv7;
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    TopActionButton(iconType, z6, (Function0) it$iv7, scale3, reportOnExposure3, str3, paddingValues2, count, $composer2, 0, 0);
                    $this$forEach$iv = $this$forEach$iv2;
                    getIconUrl = getIconUrl2;
                    scaleModel$delegate = scaleModel$delegate2;
                    z5 = z7;
                }
                $composer2.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                actionItems = actionItems2;
            }
            Object obj3 = new Function0() { // from class: kntr.app.mall.product.details.page.ui.container.TopContainerKt$$ExternalSyntheticLambda9
                public final Object invoke() {
                    Unit TopActionContainer$lambda$3$0$0;
                    TopActionContainer$lambda$3$0$0 = TopContainerKt.TopActionContainer$lambda$3$0$0(PageViewModel.this);
                    return TopActionContainer$lambda$3$0$0;
                }
            };
            $composer2.updateRememberedValue(obj3);
            value$iv = obj3;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier reportOnExposure4 = ExposerKt.reportOnExposure(modifier5, "top_action_back", collectorHolder, null, false, 0.5f, 0, 500L, (Function0) value$iv, $composer2, 12779574, 44);
            ComposerKt.sourceInformationMarkerStart($composer2, 463850462, "CC(remember):TopContainer.kt#9igjgp");
            invalid$iv = $composer2.changedInstance(pageViewModel);
            Object it$iv32 = $composer2.rememberedValue();
            if (invalid$iv) {
            }
            Object value$iv32 = new Function0() { // from class: kntr.app.mall.product.details.page.ui.container.TopContainerKt$$ExternalSyntheticLambda11
                public final Object invoke() {
                    Unit TopActionContainer$lambda$3$1$0;
                    TopActionContainer$lambda$3$1$0 = TopContainerKt.TopActionContainer$lambda$3$1$0(PageViewModel.this);
                    return TopActionContainer$lambda$3$1$0;
                }
            };
            $composer2.updateRememberedValue(value$iv32);
            it$iv32 = value$iv32;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            TopActionButton(actionIconType, z, (Function0) it$iv32, scale, reportOnExposure4, str, paddingValues, null, $composer2, 6, 128);
            Modifier modifier$iv22 = PaddingKt.padding-VpY3zN4$default(RowScope.-CC.weight$default($this$TopActionContainer_u24lambda_u243, Modifier.Companion, 1.0f, false, 2, (Object) null), ProvideUiScaleKt.dpScaled(8, TopActionContainer$lambda$0(scaleModel$delegate).getScale()), 0.0f, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv2 = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv22 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
            int $changed$iv$iv22 = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv22 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv22 = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv22 = ComposedModifierKt.materializeModifier($composer2, modifier$iv22);
            Function0 factory$iv$iv$iv42 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv22 = (($changed$iv$iv22 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
            }
            $composer2.startReusableNode();
            if (!$composer2.getInserting()) {
            }
            Composer $this$Layout_u24lambda_u240$iv$iv22 = Updater.constructor-impl($composer2);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv22, measurePolicy$iv22, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv22, localMap$iv$iv22, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv22, Integer.valueOf(compositeKeyHash$iv$iv22), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv22, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv22, materialized$iv$iv22, ComposeUiNode.Companion.getSetModifier());
            int i72 = ($changed$iv$iv$iv22 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
            int i82 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, 2123353936, "C:TopContainer.kt#u9475x");
            it = actionItems2.iterator();
            while (true) {
                if (it.hasNext()) {
                }
                it = it3;
            }
            it2 = (TopActionItem) obj2;
            if (it2 != null) {
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.startReplaceGroup(463942282);
            ComposerKt.sourceInformation($composer2, "*396@16177L936,391@15874L1239,367@14837L856,362@14551L2581");
            Iterable $this$filterNot$iv3 = actionItems2;
            boolean z32 = false;
            Collection destination$iv$iv2 = new ArrayList();
            while (r10.hasNext()) {
            }
            Iterable $this$forEach$iv3 = (List) destination$iv$iv2;
            boolean z52 = false;
            while (r5.hasNext()) {
            }
            $composer2.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
            }
            actionItems = actionItems2;
        } else {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            alpha2 = f;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier8 = modifier3;
            final float f2 = alpha2;
            final List list2 = actionItems;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.container.TopContainerKt$$ExternalSyntheticLambda16
                public final Object invoke(Object obj4, Object obj5) {
                    Unit TopActionContainer$lambda$4;
                    TopActionContainer$lambda$4 = TopContainerKt.TopActionContainer$lambda$4(scrollOffset, pageViewModel, modifier8, f2, list2, $changed, i, (Composer) obj4, ((Integer) obj5).intValue());
                    return TopActionContainer$lambda$4;
                }
            });
        }
    }

    private static final UiScaleModel TopActionContainer$lambda$0(State<UiScaleModel> state) {
        Object thisObj$iv = state.getValue();
        return (UiScaleModel) thisObj$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String TopActionContainer$lambda$2$0(boolean $isLight, TopActionItem item) {
        if (item == null) {
            return null;
        }
        if ($isLight) {
            return item.getIconUrl();
        }
        return item.getIconNightUrl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TopActionContainer$lambda$3$1$0(PageViewModel $pageViewModel) {
        $pageViewModel.handleBackAction$product_details_page_debug();
        PageActionHandler.trackEvent$product_details_page_debug$default($pageViewModel.getActionHandler$product_details_page_debug(), TrackConsts.MALL_MALL_DETAIL_RETURN_0_CLICK, null, true, false, 10, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TopActionContainer$lambda$3$0$0(PageViewModel $pageViewModel) {
        PageActionHandler.trackEvent$product_details_page_debug$default($pageViewModel.getActionHandler$product_details_page_debug(), TrackConsts.MALL_MALL_DETAIL_RETURN_0_SHOW, null, false, false, 10, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TopActionContainer$lambda$3$2$1$1$0(PageViewModel $pageViewModel, String searchText) {
        $pageViewModel.handleSearch$product_details_page_debug(searchText);
        PageActionHandler.trackEvent$product_details_page_debug$default($pageViewModel.getActionHandler$product_details_page_debug(), TrackConsts.MALL_MALL_DETAIL_SEARCH_0_CLICK, null, true, false, 10, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TopActionContainer$lambda$3$2$1$0$0(PageViewModel $pageViewModel) {
        PageActionHandler.trackEvent$product_details_page_debug$default($pageViewModel.getActionHandler$product_details_page_debug(), TrackConsts.MALL_MALL_DETAIL_SEARCH_0_SHOW, null, false, false, 10, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TopActionContainer$lambda$3$4$1$0(TopActionItem $item, PageViewModel $pageViewModel) {
        Function0<Unit> mo592getOnClick = $item.mo592getOnClick();
        if (mo592getOnClick != null) {
            mo592getOnClick.invoke();
        }
        switch (WhenMappings.$EnumSwitchMapping$0[$item.getIconType().ordinal()]) {
            case 1:
                PageActionHandler.trackEvent$product_details_page_debug$default($pageViewModel.getActionHandler$product_details_page_debug(), TrackConsts.MALL_MALL_DETAIL_TOPSHARE_0_CLICK, null, true, false, 10, null);
                break;
            case 2:
                PageActionHandler.trackEvent$product_details_page_debug$default($pageViewModel.getActionHandler$product_details_page_debug(), TrackConsts.MALL_MALL_DETAIL_GO_ADDCART_0_CLICK, null, true, false, 10, null);
                break;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TopActionContainer$lambda$3$4$0$0(TopActionItem $item, PageViewModel $pageViewModel) {
        switch (WhenMappings.$EnumSwitchMapping$0[$item.getIconType().ordinal()]) {
            case 1:
                PageActionHandler.trackEvent$product_details_page_debug$default($pageViewModel.getActionHandler$product_details_page_debug(), TrackConsts.MALL_MALL_DETAIL_TOPSHARE_0_SHOW, null, false, false, 10, null);
                break;
            case 2:
                PageActionHandler.trackEvent$product_details_page_debug$default($pageViewModel.getActionHandler$product_details_page_debug(), TrackConsts.MALL_MALL_DETAIL_GO_ADDCART_0_SHOW, null, false, false, 10, null);
                break;
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:184:0x062b, code lost:
        if (r12 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L139;
     */
    /* JADX WARN: Removed duplicated region for block: B:103:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0239  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0248  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x026d  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x02a0  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x02d1  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0324  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0329  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x032e  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x03e4  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x03f0  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x03f6  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0504  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0510  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0516  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x05a9  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x0954  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x097d  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x09a8  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x09c0  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x0a0c  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x0b7e  */
    /* JADX WARN: Removed duplicated region for block: B:265:0x01a7 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0186  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void TopTabContainer(final float alpha, final LazyStaggeredGridState listState, final PageViewModel pageViewModel, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Composer $composer2;
        Modifier modifier3;
        Object obj;
        List combinedCommentList;
        boolean showComment;
        Iterator<T> it;
        Object obj2;
        boolean showDetail;
        boolean showFeedBlast;
        Object value$iv;
        Object it$iv;
        Object it$iv2;
        Object it$iv3;
        boolean invalid$iv;
        Object value$iv2;
        Function0 factory$iv$iv$iv;
        Composer $composer$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Iterable $this$forEachIndexed$iv;
        boolean z;
        CompositionLocalMap localMap$iv$iv;
        Function0 factory$iv$iv$iv3;
        Function0 factory$iv$iv$iv4;
        List decorImgs;
        TextStyle textStyle;
        long j;
        ProductDetailsResponse.ProductDetailsData data;
        FixedTabSkinVO fixedTabSkin;
        CommentInfoApiService.CommentInfoResponse.CommentInfoData commentInfoData;
        List combinedCommentList2;
        CommentFloor productApiData;
        Long totalCount;
        Composer $composer3 = $composer.startRestartGroup(-4341613);
        ComposerKt.sourceInformation($composer3, "C(TopTabContainer)N(alpha,listState,pageViewModel,modifier)436@17476L24,437@17554L16,438@17627L16,439@17699L16,452@18481L16,459@18675L16,500@19719L377,514@20130L253,524@20416L252,534@20704L255,545@21006L408,558@21419L3435:TopContainer.kt#u9475x");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(alpha) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changed(listState) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer3.changedInstance(pageViewModel) ? 256 : 128;
        }
        int i2 = i & 8;
        if (i2 != 0) {
            $dirty |= 3072;
            modifier2 = modifier;
        } else if (($changed & 3072) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 2048 : 1024;
        } else {
            modifier2 = modifier;
        }
        int $dirty2 = $dirty;
        if ($composer3.shouldExecute(($dirty2 & 1171) != 1170, $dirty2 & 1)) {
            Modifier modifier4 = i2 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-4341613, $dirty2, -1, "kntr.app.mall.product.details.page.ui.container.TopTabContainer (TopContainer.kt:435)");
            }
            ComposerKt.sourceInformationMarkerStart($composer3, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart($composer3, 683736516, "CC(remember):Effects.kt#9igjgp");
            Object it$iv$iv = $composer3.rememberedValue();
            if (it$iv$iv == Composer.Companion.getEmpty()) {
                Object value$iv$iv = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer3);
                $composer3.updateRememberedValue(value$iv$iv);
                it$iv$iv = value$iv$iv;
            }
            CoroutineScope scope = (CoroutineScope) it$iv$iv;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            State scaleModel$delegate = SnapshotStateKt.collectAsState(pageViewModel.getUiScaleModelFlow$product_details_page_debug(), (CoroutineContext) null, $composer3, 0, 1);
            State selectedIndex$delegate = SnapshotStateKt.collectAsState(pageViewModel.getSelectedTabIndex(), (CoroutineContext) null, $composer3, 0, 1);
            State contentModules$delegate = SnapshotStateKt.collectAsState(pageViewModel.getContentModules$product_details_page_debug(), (CoroutineContext) null, $composer3, 0, 1);
            Iterator it2 = TopTabContainer$lambda$2(contentModules$delegate).iterator();
            while (true) {
                if (!it2.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it2.next();
                ContentModule it3 = (ContentModule) obj;
                Iterator it4 = it2;
                if (it3.getFloorType() == FloorType.COMMENT) {
                    break;
                }
                it2 = it4;
            }
            ContentModule.CommentModule commentModule = (ContentModule.CommentModule) obj;
            CommentInfoApiService.CommentInfoResponse.CommentInfoData commentInfoData2 = commentModule != null ? commentModule.getCommentApiData() : null;
            long commentCount = (commentInfoData2 == null || (totalCount = commentInfoData2.getTotalCount()) == null) ? 0L : totalCount.longValue();
            if (commentInfoData2 == null || (combinedCommentList = commentInfoData2.getCombinedCommentList$product_details_page_debug()) == null) {
                combinedCommentList = CollectionsKt.emptyList();
            }
            if (commentCount <= 0 && combinedCommentList.isEmpty()) {
                if (!((commentModule == null || (productApiData = commentModule.getProductApiData()) == null) ? false : Intrinsics.areEqual(productApiData.getShowPreBuyComment(), true))) {
                    showComment = false;
                    it = TopTabContainer$lambda$2(contentModules$delegate).iterator();
                    while (true) {
                        if (it.hasNext()) {
                            obj2 = null;
                            break;
                        }
                        obj2 = it.next();
                        ContentModule it5 = (ContentModule) obj2;
                        commentInfoData = commentInfoData2;
                        combinedCommentList2 = combinedCommentList;
                        if (it5.getFloorType() == FloorType.DETAIL_DESC) {
                            break;
                        }
                        commentInfoData2 = commentInfoData;
                        combinedCommentList = combinedCommentList2;
                    }
                    ContentModule detailModule = (ContentModule) obj2;
                    ContentModule.DetailDescModule detailDescModule = (ContentModule.DetailDescModule) detailModule;
                    DetailDescFloor detailData = detailDescModule == null ? detailDescModule.getData() : null;
                    List<DetailDescFloor.Content> contents = detailData == null ? detailData.getContents() : null;
                    showDetail = !(contents != null || contents.isEmpty());
                    State feedBlastState$delegate = SnapshotStateKt.collectAsState(pageViewModel.getFeedBlastState$product_details_page_debug(), (CoroutineContext) null, $composer3, 0, 1);
                    showFeedBlast = !TopTabContainer$lambda$5(feedBlastState$delegate).isEmpty();
                    ProductDetailsResponse productDetailsResponse = (ProductDetailsResponse) SnapshotStateKt.collectAsState(pageViewModel.getProductDetailsResponse(), (CoroutineContext) null, $composer3, 0, 1).getValue();
                    List<String> decorImgs2 = (productDetailsResponse != null || (data = productDetailsResponse.getData()) == null || (fixedTabSkin = data.getFixedTabSkin()) == null) ? null : fixedTabSkin.getDecorImgs();
                    String str = "CC(remember):TopContainer.kt#9igjgp";
                    ComposerKt.sourceInformationMarkerStart($composer3, 122754700, "CC(remember):TopContainer.kt#9igjgp");
                    value$iv = $composer3.rememberedValue();
                    if (value$iv != Composer.Companion.getEmpty()) {
                        value$iv = new TopContainerKt$TopTabContainer$itemTabItem$1$1(pageViewModel, scope, listState);
                        $composer3.updateRememberedValue(value$iv);
                    }
                    TopContainerKt$TopTabContainer$itemTabItem$1$1 itemTabItem = (TopContainerKt$TopTabContainer$itemTabItem$1$1) value$iv;
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerStart($composer3, 122767728, "CC(remember):TopContainer.kt#9igjgp");
                    it$iv = $composer3.rememberedValue();
                    List decorImgs3 = decorImgs2;
                    if (it$iv == Composer.Companion.getEmpty()) {
                        Object value$iv3 = new TopContainerKt$TopTabContainer$commentTabItem$1$1(pageViewModel, scope, listState);
                        $composer3.updateRememberedValue(value$iv3);
                        it$iv = value$iv3;
                    }
                    TopContainerKt$TopTabContainer$commentTabItem$1$1 commentTabItem = (TopContainerKt$TopTabContainer$commentTabItem$1$1) it$iv;
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerStart($composer3, 122776879, "CC(remember):TopContainer.kt#9igjgp");
                    it$iv2 = $composer3.rememberedValue();
                    if (it$iv2 == Composer.Companion.getEmpty()) {
                        Object value$iv4 = new TopContainerKt$TopTabContainer$detailTabItem$1$1(pageViewModel, scope, listState);
                        $composer3.updateRememberedValue(value$iv4);
                        it$iv2 = value$iv4;
                    }
                    TopContainerKt$TopTabContainer$detailTabItem$1$1 detailTabItem = (TopContainerKt$TopTabContainer$detailTabItem$1$1) it$iv2;
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerStart($composer3, 122786098, "CC(remember):TopContainer.kt#9igjgp");
                    it$iv3 = $composer3.rememberedValue();
                    if (it$iv3 == Composer.Companion.getEmpty()) {
                        Object value$iv5 = new TopContainerKt$TopTabContainer$feedBlastTabItem$1$1(pageViewModel, scope, listState);
                        $composer3.updateRememberedValue(value$iv5);
                        it$iv3 = value$iv5;
                    }
                    TopContainerKt$TopTabContainer$feedBlastTabItem$1$1 feedBlastTabItem = (TopContainerKt$TopTabContainer$feedBlastTabItem$1$1) it$iv3;
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerStart($composer3, 122795915, "CC(remember):TopContainer.kt#9igjgp");
                    invalid$iv = $composer3.changed(showComment) | $composer3.changed(showFeedBlast) | $composer3.changed(showDetail);
                    value$iv2 = $composer3.rememberedValue();
                    if (!invalid$iv || value$iv2 == Composer.Companion.getEmpty()) {
                        List list = CollectionsKt.mutableListOf(new TopTabItem[]{itemTabItem});
                        if (showComment) {
                            list.add(commentTabItem);
                        }
                        if (showDetail) {
                            list.add(detailTabItem);
                        }
                        if (showFeedBlast) {
                            list.add(feedBlastTabItem);
                        }
                        value$iv2 = CollectionsKt.toList(list);
                        $composer3.updateRememberedValue(value$iv2);
                    }
                    List tabItems = (List) value$iv2;
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    Modifier modifier$iv = AlphaKt.alpha(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, (Object) null), ProvideUiScaleKt.dpScaled(32, TopTabContainer$lambda$0(scaleModel$delegate).getScale())), alpha);
                    Alignment contentAlignment$iv = Alignment.Companion.getCenter();
                    modifier3 = modifier4;
                    ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                    int $changed$iv$iv = (48 << 3) & 112;
                    String str2 = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
                    ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
                    CompositionLocalMap localMap$iv$iv2 = $composer3.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
                    Function0 factory$iv$iv$iv5 = ComposeUiNode.Companion.getConstructor();
                    int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                    String str3 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
                    ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!($composer3.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer3.startReusableNode();
                    if ($composer3.getInserting()) {
                        factory$iv$iv$iv = factory$iv$iv$iv5;
                        $composer3.useNode();
                    } else {
                        factory$iv$iv$iv = factory$iv$iv$iv5;
                        $composer3.createNode(factory$iv$iv$iv);
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer3);
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
                    int i3 = ($changed$iv$iv$iv >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScope boxScope = BoxScopeInstance.INSTANCE;
                    int i4 = ((48 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer3, -1850034267, "C566@21643L3205:TopContainer.kt#u9475x");
                    Modifier modifier$iv2 = SizeKt.fillMaxHeight$default(Modifier.Companion, 0.0f, 1, (Object) null);
                    Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
                    Composer $composer$iv = $composer3;
                    int $changed$iv = 390;
                    $composer2 = $composer3;
                    ComposerKt.sourceInformationMarkerStart($composer$iv, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                    Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                    MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer$iv, ((390 >> 3) & 14) | ((390 >> 3) & 112));
                    int $changed$iv$iv2 = (390 << 3) & 112;
                    Composer $composer$iv$iv = $composer$iv;
                    ComposerKt.sourceInformationMarkerStart($composer$iv$iv, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv$iv, 0));
                    CompositionLocalMap localMap$iv$iv3 = $composer$iv$iv.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer$iv$iv, modifier$iv2);
                    Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
                    int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                    $composer$iv$iv$iv = $composer$iv$iv;
                    ComposerKt.sourceInformationMarkerStart($composer$iv$iv$iv, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!($composer$iv$iv$iv.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer$iv$iv$iv.startReusableNode();
                    if ($composer$iv$iv$iv.getInserting()) {
                        factory$iv$iv$iv2 = factory$iv$iv$iv6;
                        $composer$iv$iv$iv.useNode();
                    } else {
                        factory$iv$iv$iv2 = factory$iv$iv$iv6;
                        $composer$iv$iv$iv.createNode(factory$iv$iv$iv2);
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer$iv$iv$iv);
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
                    int i5 = ($changed$iv$iv$iv2 >> 6) & 14;
                    Composer $composer$iv2 = $composer$iv$iv$iv;
                    boolean z2 = false;
                    ComposerKt.sourceInformationMarkerStart($composer$iv2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                    RowScope rowScope = RowScopeInstance.INSTANCE;
                    int i6 = ((390 >> 6) & 112) | 6;
                    Composer $composer4 = $composer$iv2;
                    ComposerKt.sourceInformationMarkerStart($composer4, 358751589, "C:TopContainer.kt#u9475x");
                    $composer4.startReplaceGroup(-1928089739);
                    ComposerKt.sourceInformation($composer4, "*580@22159L21,577@22051L2773");
                    List $this$forEachIndexed$iv2 = tabItems;
                    boolean z3 = false;
                    int index$iv = 0;
                    for (Object item$iv : $this$forEachIndexed$iv2) {
                        int index$iv2 = index$iv + 1;
                        if (index$iv < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        List tabItems2 = tabItems;
                        final TopTabItem tabItm = (TopTabItem) item$iv;
                        if (index$iv > 0) {
                            $this$forEachIndexed$iv = $this$forEachIndexed$iv2;
                            $composer4.startReplaceGroup(-414678300);
                            ComposerKt.sourceInformation($composer4, "573@21893L53");
                            z = z3;
                            localMap$iv$iv = localMap$iv$iv3;
                            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(70, TopTabContainer$lambda$0(scaleModel$delegate).getScale())), $composer4, 0);
                        } else {
                            $this$forEachIndexed$iv = $this$forEachIndexed$iv2;
                            z = z3;
                            localMap$iv$iv = localMap$iv$iv3;
                            $composer4.startReplaceGroup(-436378207);
                        }
                        $composer4.endReplaceGroup();
                        boolean isItemSelected = TopTabContainer$lambda$1(selectedIndex$delegate) == tabItm.getItemKey();
                        Modifier modifier5 = Modifier.Companion;
                        ComposerKt.sourceInformationMarkerStart($composer4, 1510653078, str);
                        boolean invalid$iv2 = $composer4.changedInstance(tabItm);
                        Composer $this$cache$iv = $composer4;
                        String str4 = str;
                        Object it$iv4 = $this$cache$iv.rememberedValue();
                        if (invalid$iv2) {
                        }
                        Object value$iv6 = new Function0() { // from class: kntr.app.mall.product.details.page.ui.container.TopContainerKt$$ExternalSyntheticLambda26
                            public final Object invoke() {
                                Unit TopTabContainer$lambda$11$0$0$0$0;
                                TopTabContainer$lambda$11$0$0$0$0 = TopContainerKt.TopTabContainer$lambda$11$0$0$0$0(TopTabItem.this);
                                return TopTabContainer$lambda$11$0$0$0$0;
                            }
                        };
                        $this$cache$iv.updateRememberedValue(value$iv6);
                        it$iv4 = value$iv6;
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        Modifier modifier$iv3 = ClickableKt.clickable-oSLSa3U$default(modifier5, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv4, 15, (Object) null);
                        Alignment contentAlignment$iv2 = Alignment.Companion.getCenter();
                        Composer $composer$iv3 = $composer4;
                        boolean z4 = z2;
                        int $changed$iv2 = $changed$iv;
                        int $changed$iv$iv$iv3 = $changed$iv$iv$iv2;
                        ComposerKt.sourceInformationMarkerStart($composer$iv3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicy$iv3 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
                        int $changed$iv$iv3 = (48 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer$iv3, -1159599143, str2);
                        int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv3, 0));
                        CompositionLocalMap localMap$iv$iv4 = $composer$iv3.getCurrentCompositionLocalMap();
                        Composer $composer$iv4 = $composer$iv;
                        Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer$iv3, modifier$iv3);
                        Function0 factory$iv$iv$iv7 = ComposeUiNode.Companion.getConstructor();
                        int $changed$iv$iv$iv4 = (($changed$iv$iv3 << 6) & 896) | 6;
                        Composer $composer$iv$iv2 = $composer$iv$iv;
                        Composer $composer$iv$iv$iv2 = $composer$iv$iv$iv;
                        ComposerKt.sourceInformationMarkerStart($composer$iv3, -553112988, str3);
                        if (!($composer$iv3.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer$iv3.startReusableNode();
                        if ($composer$iv3.getInserting()) {
                            factory$iv$iv$iv3 = factory$iv$iv$iv7;
                            $composer$iv3.createNode(factory$iv$iv$iv3);
                        } else {
                            factory$iv$iv$iv3 = factory$iv$iv$iv7;
                            $composer$iv3.useNode();
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer$iv3);
                        Composer $composer$iv5 = $composer$iv2;
                        Composer $composer5 = $composer4;
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
                        int i7 = ($changed$iv$iv$iv4 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer$iv3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                        BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
                        int i8 = ((48 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer$iv3, 1421402845, "C583@22279L2527:TopContainer.kt#u9475x");
                        Alignment.Vertical verticalAlignment$iv2 = Alignment.Companion.getCenterVertically();
                        ComposerKt.sourceInformationMarkerStart($composer$iv3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                        Modifier modifier$iv4 = Modifier.Companion;
                        Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.getStart();
                        int $changed$iv3 = ((384 >> 3) & 14) | ((384 >> 3) & 112);
                        MeasurePolicy measurePolicy$iv4 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer$iv3, $changed$iv3);
                        int $changed$iv$iv4 = (384 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer$iv3, -1159599143, str2);
                        int compositeKeyHash$iv$iv4 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv3, 0));
                        String str5 = str2;
                        CompositionLocalMap localMap$iv$iv5 = $composer$iv3.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer$iv3, modifier$iv4);
                        Function0 factory$iv$iv$iv8 = ComposeUiNode.Companion.getConstructor();
                        int $changed$iv$iv$iv5 = (($changed$iv$iv4 << 6) & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer$iv3, -553112988, str3);
                        if (!($composer$iv3.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer$iv3.startReusableNode();
                        if ($composer$iv3.getInserting()) {
                            factory$iv$iv$iv4 = factory$iv$iv$iv8;
                            $composer$iv3.createNode(factory$iv$iv$iv4);
                        } else {
                            factory$iv$iv$iv4 = factory$iv$iv$iv8;
                            $composer$iv3.useNode();
                        }
                        String str6 = str3;
                        Composer $this$Layout_u24lambda_u240$iv$iv4 = Updater.constructor-impl($composer$iv3);
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, measurePolicy$iv4, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, localMap$iv$iv5, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Updater.init-impl($this$Layout_u24lambda_u240$iv$iv4, Integer.valueOf(compositeKeyHash$iv$iv4), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv4, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, materialized$iv$iv4, ComposeUiNode.Companion.getSetModifier());
                        int i9 = ($changed$iv$iv$iv5 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer$iv3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                        int i10 = ((384 >> 6) & 112) | 6;
                        RowScope $this$TopTabContainer_u24lambda_u2411_u240_u240_u241_u240 = RowScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart($composer$iv3, -111124658, "C602@23308L571:TopContainer.kt#u9475x");
                        if (isItemSelected) {
                            List list2 = decorImgs3;
                            if (!(list2 == null || list2.isEmpty()) && !decorImgs3.isEmpty()) {
                                decorImgs = decorImgs3;
                                if (decorImgs.get(0).length() > 0) {
                                    $composer$iv3.startReplaceGroup(-111070316);
                                    ComposerKt.sourceInformation($composer$iv3, "588@22573L591,599@23193L63");
                                    String $this$asRequest$iv = HelperKt.customizedImageUrl(decorImgs.get(0));
                                    ImageRequest $this$TopTabContainer_u24lambda_u2411_u240_u240_u241_u240_u240 = new ImageRequest($this$asRequest$iv);
                                    $this$TopTabContainer_u24lambda_u2411_u240_u240_u241_u240_u240.contentScale(ContentScale.Companion.getFillBounds());
                                    BiliImageKt.BiliImage($this$TopTabContainer_u24lambda_u2411_u240_u240_u241_u240_u240.build(), $this$TopTabContainer_u24lambda_u2411_u240_u240_u241_u240.align(SizeKt.height-3ABfNKs(SizeKt.width-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(12, TopTabContainer$lambda$0(scaleModel$delegate).getScale())), ProvideUiScaleKt.dpScaled(30, TopTabContainer$lambda$0(scaleModel$delegate).getScale())), Alignment.Companion.getBottom()), null, null, null, null, null, null, null, $composer$iv3, 0, 508);
                                    SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(2, TopTabContainer$lambda$0(scaleModel$delegate).getScale())), $composer$iv3, 0);
                                    $composer$iv3.endReplaceGroup();
                                    String titleText = tabItm.getTitleText();
                                    if (isItemSelected) {
                                        $composer$iv3.startReplaceGroup(-110184770);
                                        ComposerKt.sourceInformation($composer$iv3, "606@23503L9");
                                        TextStyle scaled = ProvideUiScaleKt.scaled(BiliTheme.INSTANCE.getTextStyle($composer$iv3, BiliTheme.$stable).getT14b(), TopTabContainer$lambda$0(scaleModel$delegate).getScale());
                                        $composer$iv3.endReplaceGroup();
                                        textStyle = scaled;
                                    } else {
                                        $composer$iv3.startReplaceGroup(-110058817);
                                        ComposerKt.sourceInformation($composer$iv3, "608@23630L9");
                                        TextStyle scaled2 = ProvideUiScaleKt.scaled(BiliTheme.INSTANCE.getTextStyle($composer$iv3, BiliTheme.$stable).getT14(), TopTabContainer$lambda$0(scaleModel$delegate).getScale());
                                        $composer$iv3.endReplaceGroup();
                                        textStyle = scaled2;
                                    }
                                    if (isItemSelected) {
                                        $composer$iv3.startReplaceGroup(-557733488);
                                        ComposerKt.sourceInformation($composer$iv3, "610@23770L6");
                                        j = BiliTheme.INSTANCE.getColors($composer$iv3, BiliTheme.$stable).getText1-0d7_KjU();
                                    } else {
                                        $composer$iv3.startReplaceGroup(-557732592);
                                        ComposerKt.sourceInformation($composer$iv3, "610@23798L6");
                                        j = BiliTheme.INSTANCE.getColors($composer$iv3, BiliTheme.$stable).getText2-0d7_KjU();
                                    }
                                    $composer$iv3.endReplaceGroup();
                                    TextKt.Text-Nvy7gAk(titleText, (Modifier) null, j, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, textStyle, $composer$iv3, 0, 24576, 114682);
                                    if (isItemSelected) {
                                        List list3 = decorImgs;
                                        if (!(list3 == null || list3.isEmpty()) && decorImgs.size() >= 2) {
                                            String str7 = decorImgs.get(1);
                                            if (!(str7 == null || str7.length() == 0)) {
                                                $composer$iv3.startReplaceGroup(-109580332);
                                                ComposerKt.sourceInformation($composer$iv3, "616@24075L63,617@24167L591");
                                                SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(2, TopTabContainer$lambda$0(scaleModel$delegate).getScale())), $composer$iv3, 0);
                                                String $this$asRequest$iv2 = HelperKt.customizedImageUrl(decorImgs.get(1));
                                                ImageRequest $this$TopTabContainer_u24lambda_u2411_u240_u240_u241_u240_u241 = new ImageRequest($this$asRequest$iv2);
                                                $this$TopTabContainer_u24lambda_u2411_u240_u240_u241_u240_u241.contentScale(ContentScale.Companion.getFillBounds());
                                                BiliImageKt.BiliImage($this$TopTabContainer_u24lambda_u2411_u240_u240_u241_u240_u241.build(), $this$TopTabContainer_u24lambda_u2411_u240_u240_u241_u240.align(SizeKt.height-3ABfNKs(SizeKt.width-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(12, TopTabContainer$lambda$0(scaleModel$delegate).getScale())), ProvideUiScaleKt.dpScaled(30, TopTabContainer$lambda$0(scaleModel$delegate).getScale())), Alignment.Companion.getBottom()), null, null, null, null, null, null, null, $composer$iv3, 0, 508);
                                                $composer$iv3.endReplaceGroup();
                                                ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                                                ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                                                $composer$iv3.endNode();
                                                ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                                                ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                                                ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                                                ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                                                ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                                                $composer$iv3.endNode();
                                                ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                                                ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                                                ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                                                decorImgs3 = decorImgs;
                                                $changed$iv$iv$iv2 = $changed$iv$iv$iv3;
                                                index$iv = index$iv2;
                                                tabItems = tabItems2;
                                                $this$forEachIndexed$iv2 = $this$forEachIndexed$iv;
                                                localMap$iv$iv3 = localMap$iv$iv;
                                                z3 = z;
                                                z2 = z4;
                                                $changed$iv = $changed$iv2;
                                                $composer$iv = $composer$iv4;
                                                str = str4;
                                                $composer$iv$iv$iv = $composer$iv$iv$iv2;
                                                $composer$iv$iv = $composer$iv$iv2;
                                                $composer4 = $composer5;
                                                $composer$iv2 = $composer$iv5;
                                                str2 = str5;
                                                str3 = str6;
                                            }
                                        }
                                    }
                                    $composer$iv3.startReplaceGroup(-133456873);
                                    $composer$iv3.endReplaceGroup();
                                    ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                                    ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                                    $composer$iv3.endNode();
                                    ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                                    ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                                    ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                                    ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                                    ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                                    $composer$iv3.endNode();
                                    ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                                    ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                                    ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                                    decorImgs3 = decorImgs;
                                    $changed$iv$iv$iv2 = $changed$iv$iv$iv3;
                                    index$iv = index$iv2;
                                    tabItems = tabItems2;
                                    $this$forEachIndexed$iv2 = $this$forEachIndexed$iv;
                                    localMap$iv$iv3 = localMap$iv$iv;
                                    z3 = z;
                                    z2 = z4;
                                    $changed$iv = $changed$iv2;
                                    $composer$iv = $composer$iv4;
                                    str = str4;
                                    $composer$iv$iv$iv = $composer$iv$iv$iv2;
                                    $composer$iv$iv = $composer$iv$iv2;
                                    $composer4 = $composer5;
                                    $composer$iv2 = $composer$iv5;
                                    str2 = str5;
                                    str3 = str6;
                                } else {
                                    $composer$iv3.startReplaceGroup(-133456873);
                                    $composer$iv3.endReplaceGroup();
                                    String titleText2 = tabItm.getTitleText();
                                    if (isItemSelected) {
                                    }
                                    if (isItemSelected) {
                                    }
                                    $composer$iv3.endReplaceGroup();
                                    TextKt.Text-Nvy7gAk(titleText2, (Modifier) null, j, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, textStyle, $composer$iv3, 0, 24576, 114682);
                                    if (isItemSelected) {
                                    }
                                    $composer$iv3.startReplaceGroup(-133456873);
                                    $composer$iv3.endReplaceGroup();
                                    ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                                    ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                                    $composer$iv3.endNode();
                                    ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                                    ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                                    ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                                    ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                                    ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                                    $composer$iv3.endNode();
                                    ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                                    ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                                    ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                                    decorImgs3 = decorImgs;
                                    $changed$iv$iv$iv2 = $changed$iv$iv$iv3;
                                    index$iv = index$iv2;
                                    tabItems = tabItems2;
                                    $this$forEachIndexed$iv2 = $this$forEachIndexed$iv;
                                    localMap$iv$iv3 = localMap$iv$iv;
                                    z3 = z;
                                    z2 = z4;
                                    $changed$iv = $changed$iv2;
                                    $composer$iv = $composer$iv4;
                                    str = str4;
                                    $composer$iv$iv$iv = $composer$iv$iv$iv2;
                                    $composer$iv$iv = $composer$iv$iv2;
                                    $composer4 = $composer5;
                                    $composer$iv2 = $composer$iv5;
                                    str2 = str5;
                                    str3 = str6;
                                }
                            }
                        }
                        decorImgs = decorImgs3;
                        $composer$iv3.startReplaceGroup(-133456873);
                        $composer$iv3.endReplaceGroup();
                        String titleText22 = tabItm.getTitleText();
                        if (isItemSelected) {
                        }
                        if (isItemSelected) {
                        }
                        $composer$iv3.endReplaceGroup();
                        TextKt.Text-Nvy7gAk(titleText22, (Modifier) null, j, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, textStyle, $composer$iv3, 0, 24576, 114682);
                        if (isItemSelected) {
                        }
                        $composer$iv3.startReplaceGroup(-133456873);
                        $composer$iv3.endReplaceGroup();
                        ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                        $composer$iv3.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                        $composer$iv3.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                        decorImgs3 = decorImgs;
                        $changed$iv$iv$iv2 = $changed$iv$iv$iv3;
                        index$iv = index$iv2;
                        tabItems = tabItems2;
                        $this$forEachIndexed$iv2 = $this$forEachIndexed$iv;
                        localMap$iv$iv3 = localMap$iv$iv;
                        z3 = z;
                        z2 = z4;
                        $changed$iv = $changed$iv2;
                        $composer$iv = $composer$iv4;
                        str = str4;
                        $composer$iv$iv$iv = $composer$iv$iv$iv2;
                        $composer$iv$iv = $composer$iv$iv2;
                        $composer4 = $composer5;
                        $composer$iv2 = $composer$iv5;
                        str2 = str5;
                        str3 = str6;
                    }
                    Composer $composer$iv$iv$iv3 = $composer$iv$iv$iv;
                    Composer $composer6 = $composer4;
                    $composer6.endReplaceGroup();
                    ComposerKt.sourceInformationMarkerEnd($composer6);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                    $composer$iv$iv$iv3.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv3);
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
                }
            }
            showComment = true;
            it = TopTabContainer$lambda$2(contentModules$delegate).iterator();
            while (true) {
                if (it.hasNext()) {
                }
                commentInfoData2 = commentInfoData;
                combinedCommentList = combinedCommentList2;
            }
            ContentModule detailModule2 = (ContentModule) obj2;
            ContentModule.DetailDescModule detailDescModule2 = (ContentModule.DetailDescModule) detailModule2;
            if (detailDescModule2 == null) {
            }
            List<DetailDescFloor.Content> contents2 = detailData == null ? detailData.getContents() : null;
            showDetail = !(contents2 != null || contents2.isEmpty());
            State feedBlastState$delegate2 = SnapshotStateKt.collectAsState(pageViewModel.getFeedBlastState$product_details_page_debug(), (CoroutineContext) null, $composer3, 0, 1);
            showFeedBlast = !TopTabContainer$lambda$5(feedBlastState$delegate2).isEmpty();
            ProductDetailsResponse productDetailsResponse2 = (ProductDetailsResponse) SnapshotStateKt.collectAsState(pageViewModel.getProductDetailsResponse(), (CoroutineContext) null, $composer3, 0, 1).getValue();
            if (productDetailsResponse2 != null) {
            }
            String str8 = "CC(remember):TopContainer.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart($composer3, 122754700, "CC(remember):TopContainer.kt#9igjgp");
            value$iv = $composer3.rememberedValue();
            if (value$iv != Composer.Companion.getEmpty()) {
            }
            TopContainerKt$TopTabContainer$itemTabItem$1$1 itemTabItem2 = (TopContainerKt$TopTabContainer$itemTabItem$1$1) value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerStart($composer3, 122767728, "CC(remember):TopContainer.kt#9igjgp");
            it$iv = $composer3.rememberedValue();
            List decorImgs32 = decorImgs2;
            if (it$iv == Composer.Companion.getEmpty()) {
            }
            TopContainerKt$TopTabContainer$commentTabItem$1$1 commentTabItem2 = (TopContainerKt$TopTabContainer$commentTabItem$1$1) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerStart($composer3, 122776879, "CC(remember):TopContainer.kt#9igjgp");
            it$iv2 = $composer3.rememberedValue();
            if (it$iv2 == Composer.Companion.getEmpty()) {
            }
            TopContainerKt$TopTabContainer$detailTabItem$1$1 detailTabItem2 = (TopContainerKt$TopTabContainer$detailTabItem$1$1) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerStart($composer3, 122786098, "CC(remember):TopContainer.kt#9igjgp");
            it$iv3 = $composer3.rememberedValue();
            if (it$iv3 == Composer.Companion.getEmpty()) {
            }
            TopContainerKt$TopTabContainer$feedBlastTabItem$1$1 feedBlastTabItem2 = (TopContainerKt$TopTabContainer$feedBlastTabItem$1$1) it$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerStart($composer3, 122795915, "CC(remember):TopContainer.kt#9igjgp");
            invalid$iv = $composer3.changed(showComment) | $composer3.changed(showFeedBlast) | $composer3.changed(showDetail);
            value$iv2 = $composer3.rememberedValue();
            if (!invalid$iv) {
            }
            List list4 = CollectionsKt.mutableListOf(new TopTabItem[]{itemTabItem2});
            if (showComment) {
            }
            if (showDetail) {
            }
            if (showFeedBlast) {
            }
            value$iv2 = CollectionsKt.toList(list4);
            $composer3.updateRememberedValue(value$iv2);
            List tabItems3 = (List) value$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifier$iv5 = AlphaKt.alpha(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, (Object) null), ProvideUiScaleKt.dpScaled(32, TopTabContainer$lambda$0(scaleModel$delegate).getScale())), alpha);
            Alignment contentAlignment$iv3 = Alignment.Companion.getCenter();
            modifier3 = modifier4;
            ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv5 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv3, false);
            int $changed$iv$iv5 = (48 << 3) & 112;
            String str22 = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv5 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv22 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv5 = ComposedModifierKt.materializeModifier($composer3, modifier$iv5);
            Function0 factory$iv$iv$iv52 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv6 = (($changed$iv$iv5 << 6) & 896) | 6;
            String str32 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
            }
            Composer $this$Layout_u24lambda_u240$iv$iv5 = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, measurePolicy$iv5, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, localMap$iv$iv22, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv5, Integer.valueOf(compositeKeyHash$iv$iv5), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv5, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, materialized$iv$iv5, ComposeUiNode.Companion.getSetModifier());
            int i32 = ($changed$iv$iv$iv6 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope3 = BoxScopeInstance.INSTANCE;
            int i42 = ((48 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -1850034267, "C566@21643L3205:TopContainer.kt#u9475x");
            Modifier modifier$iv22 = SizeKt.fillMaxHeight$default(Modifier.Companion, 0.0f, 1, (Object) null);
            Alignment.Vertical verticalAlignment$iv3 = Alignment.Companion.getCenterVertically();
            Composer $composer$iv6 = $composer3;
            int $changed$iv4 = 390;
            $composer2 = $composer3;
            ComposerKt.sourceInformationMarkerStart($composer$iv6, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv3 = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv22 = RowKt.rowMeasurePolicy(horizontalArrangement$iv3, verticalAlignment$iv3, $composer$iv6, ((390 >> 3) & 14) | ((390 >> 3) & 112));
            int $changed$iv$iv22 = (390 << 3) & 112;
            Composer $composer$iv$iv3 = $composer$iv6;
            ComposerKt.sourceInformationMarkerStart($composer$iv$iv3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv22 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv$iv3, 0));
            CompositionLocalMap localMap$iv$iv32 = $composer$iv$iv3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv22 = ComposedModifierKt.materializeModifier($composer$iv$iv3, modifier$iv22);
            Function0 factory$iv$iv$iv62 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv22 = (($changed$iv$iv22 << 6) & 896) | 6;
            $composer$iv$iv$iv = $composer$iv$iv3;
            ComposerKt.sourceInformationMarkerStart($composer$iv$iv$iv, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer$iv$iv$iv.getApplier() instanceof Applier)) {
            }
            $composer$iv$iv$iv.startReusableNode();
            if ($composer$iv$iv$iv.getInserting()) {
            }
            Composer $this$Layout_u24lambda_u240$iv$iv22 = Updater.constructor-impl($composer$iv$iv$iv);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv22, measurePolicy$iv22, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv22, localMap$iv$iv32, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv22, Integer.valueOf(compositeKeyHash$iv$iv22), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv22, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv22, materialized$iv$iv22, ComposeUiNode.Companion.getSetModifier());
            int i52 = ($changed$iv$iv$iv22 >> 6) & 14;
            Composer $composer$iv22 = $composer$iv$iv$iv;
            boolean z22 = false;
            ComposerKt.sourceInformationMarkerStart($composer$iv22, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope2 = RowScopeInstance.INSTANCE;
            int i62 = ((390 >> 6) & 112) | 6;
            Composer $composer42 = $composer$iv22;
            ComposerKt.sourceInformationMarkerStart($composer42, 358751589, "C:TopContainer.kt#u9475x");
            $composer42.startReplaceGroup(-1928089739);
            ComposerKt.sourceInformation($composer42, "*580@22159L21,577@22051L2773");
            List $this$forEachIndexed$iv22 = tabItems3;
            boolean z32 = false;
            int index$iv3 = 0;
            while (r86.hasNext()) {
            }
            Composer $composer$iv$iv$iv32 = $composer$iv$iv$iv;
            Composer $composer62 = $composer42;
            $composer62.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer62);
            ComposerKt.sourceInformationMarkerEnd($composer$iv22);
            $composer$iv$iv$iv32.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv32);
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv3);
            ComposerKt.sourceInformationMarkerEnd($composer$iv6);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            if (ComposerKt.isTraceInProgress()) {
            }
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier6 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.container.TopContainerKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj3, Object obj4) {
                    Unit TopTabContainer$lambda$12;
                    TopTabContainer$lambda$12 = TopContainerKt.TopTabContainer$lambda$12(alpha, listState, pageViewModel, modifier6, $changed, i, (Composer) obj3, ((Integer) obj4).intValue());
                    return TopTabContainer$lambda$12;
                }
            });
        }
    }

    private static final UiScaleModel TopTabContainer$lambda$0(State<UiScaleModel> state) {
        Object thisObj$iv = state.getValue();
        return (UiScaleModel) thisObj$iv;
    }

    private static final int TopTabContainer$lambda$1(State<Integer> state) {
        Object thisObj$iv = state.getValue();
        return ((Number) thisObj$iv).intValue();
    }

    private static final List<ContentModule> TopTabContainer$lambda$2(State<? extends List<? extends ContentModule>> state) {
        Object thisObj$iv = state.getValue();
        return (List) thisObj$iv;
    }

    private static final List<MallRecommendItem> TopTabContainer$lambda$5(State<? extends List<MallRecommendItem>> state) {
        Object thisObj$iv = state.getValue();
        return (List) thisObj$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void TopTabContainer$scrollToComment(PageViewModel $pageViewModel, CoroutineScope scope, LazyStaggeredGridState $listState) {
        String floorKey = FloorType.COMMENT.getKey();
        Integer targetIndex = $pageViewModel.getListKeyToIndexMap().get(floorKey);
        if (targetIndex != null) {
            $pageViewModel.scrollToTab$product_details_page_debug(targetIndex.intValue(), scope, $listState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void TopTabContainer$scrollToDetail(PageViewModel $pageViewModel, CoroutineScope scope, LazyStaggeredGridState $listState) {
        Integer targetIndex = $pageViewModel.getListKeyToIndexMap().get(FloorType.DETAIL_DESC.getKey());
        if (targetIndex != null) {
            $pageViewModel.scrollToTab$product_details_page_debug(targetIndex.intValue(), scope, $listState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void TopTabContainer$scrollToRecommend(PageViewModel $pageViewModel, CoroutineScope scope, LazyStaggeredGridState $listState) {
        Integer maxIndex = (Integer) CollectionsKt.maxOrNull($pageViewModel.getListKeyToIndexMap().values());
        if (maxIndex != null) {
            $pageViewModel.scrollToTab$product_details_page_debug(maxIndex.intValue() + 1, scope, $listState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TopTabContainer$lambda$11$0$0$0$0(TopTabItem $tabItm) {
        $tabItm.getOnSelect().invoke();
        return Unit.INSTANCE;
    }

    private static final long getTabBgColor(Composer $composer, int $changed) {
        long Color;
        ComposerKt.sourceInformationMarkerStart($composer, -711080915, "C(getTabBgColor)641@24943L22:TopContainer.kt#u9475x");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-711080915, $changed, -1, "kntr.app.mall.product.details.page.ui.container.getTabBgColor (TopContainer.kt:641)");
        }
        DayNightTheme currentDayNightTheme = ThemesKt.currentDayNightTheme($composer, 0);
        if (Intrinsics.areEqual(currentDayNightTheme, DayNightTheme.Light.INSTANCE)) {
            Color = Color.Companion.getWhite-0d7_KjU();
        } else if (!Intrinsics.areEqual(currentDayNightTheme, DayNightTheme.Dark.INSTANCE)) {
            throw new NoWhenBranchMatchedException();
        } else {
            Color = ColorKt.Color(4279703578L);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return Color;
    }

    private static final float alphaFromScrollOffset(float scrollOffset, Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, 1131415549, "C(alphaFromScrollOffset)N(scrollOffset)651@25198L7:TopContainer.kt#u9475x");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1131415549, $changed, -1, "kntr.app.mall.product.details.page.ui.container.alphaFromScrollOffset (TopContainer.kt:650)");
        }
        CompositionLocal this_$iv = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object consume = $composer.consume(this_$iv);
        ComposerKt.sourceInformationMarkerEnd($composer);
        float density = ((Density) consume).getDensity();
        float maxScrollPixel = 150.0f * density;
        float coerceIn = RangesKt.coerceIn(scrollOffset / maxScrollPixel, 0.0f, 1.0f);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return coerceIn;
    }

    /* renamed from: withOverlayAlpha-DxMtmZc  reason: not valid java name */
    public static final long m587withOverlayAlphaDxMtmZc(long j, float overlayAlpha) {
        float combinedAlpha = Color.getAlpha-impl(j) * overlayAlpha;
        return Color.copy-wmQWz5c$default(j, combinedAlpha, 0.0f, 0.0f, 0.0f, 14, (Object) null);
    }

    private static final void TopActionButton(final ActionIconType iconType, final boolean scrolled, final Function0<Unit> function0, final float scale, Modifier modifier, String iconUrl, PaddingValues margin, Integer count, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Composer $composer2;
        String iconUrl2;
        PaddingValues margin2;
        Integer count2;
        Modifier modifier3;
        String str;
        Function0 factory$iv$iv$iv;
        Composer $composer$iv$iv$iv;
        Composer $composer$iv;
        Composer $composer$iv2;
        BoxScope $this$TopActionButton_u24lambda_u242;
        float f;
        Composer $composer3;
        Composer $composer4;
        Function0 factory$iv$iv$iv2;
        Composer $composer$iv$iv$iv2;
        Painter arrow_share_line_500;
        Composer $composer5 = $composer.startRestartGroup(-2139535889);
        ComposerKt.sourceInformation($composer5, "C(TopActionButton)N(iconType,scrolled,onClick,scale,modifier,iconUrl,margin,count)679@25909L21,700@26830L49,695@26667L2826:TopContainer.kt#u9475x");
        int currentMarker = $composer5.getCurrentMarker();
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer5.changed(iconType.ordinal()) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer5.changed(scrolled) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer5.changedInstance(function0) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer5.changed(scale) ? 2048 : 1024;
        }
        int i2 = i & 16;
        if (i2 != 0) {
            $dirty |= 24576;
            modifier2 = modifier;
        } else if (($changed & 24576) == 0) {
            modifier2 = modifier;
            $dirty |= $composer5.changed(modifier2) ? 16384 : 8192;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 32;
        if (i3 != 0) {
            $dirty |= 196608;
        } else if (($changed & 196608) == 0) {
            $dirty |= $composer5.changed(iconUrl) ? 131072 : 65536;
        }
        int i4 = i & 64;
        if (i4 != 0) {
            $dirty |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty |= $composer5.changed(margin) ? 1048576 : 524288;
        }
        int i5 = i & 128;
        if (i5 != 0) {
            $dirty |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty |= $composer5.changed(count) ? 8388608 : 4194304;
        }
        if ($composer5.shouldExecute(($dirty & 4793491) != 4793490, $dirty & 1)) {
            if (i2 != 0) {
                modifier2 = (Modifier) Modifier.Companion;
            }
            iconUrl2 = i3 != 0 ? null : iconUrl;
            PaddingValues margin3 = i4 != 0 ? PaddingKt.PaddingValues-0680j_4(Dp.constructor-impl(0)) : margin;
            count2 = i5 != 0 ? null : count;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2139535889, $dirty, -1, "kntr.app.mall.product.details.page.ui.container.TopActionButton (TopContainer.kt:678)");
            }
            boolean isLight = ThemesKt.isCurrentThemeLight($composer5, 0);
            if (iconUrl2 == null) {
                switch (WhenMappings.$EnumSwitchMapping$0[iconType.ordinal()]) {
                    case 1:
                        if (!isLight) {
                            str = ConstsKt.TOP_ACTION_ICON_SHARE_SCROLLED_DARK;
                            break;
                        } else {
                            str = ConstsKt.TOP_ACTION_ICON_SHARE_SCROLLED_LIGHT;
                            break;
                        }
                    case 2:
                        if (!isLight) {
                            str = ConstsKt.TOP_ACTION_ICON_CART_SCROLLED_DARK;
                            break;
                        } else {
                            str = ConstsKt.TOP_ACTION_ICON_CART_SCROLLED_LIGHT;
                            break;
                        }
                    case 3:
                        if (!isLight) {
                            str = ConstsKt.TOP_ACTION_ICON_BACK_SCROLLED_DARK;
                            break;
                        } else {
                            str = ConstsKt.TOP_ACTION_ICON_BACK_SCROLLED_LIGHT;
                            break;
                        }
                    default:
                        str = null;
                        break;
                }
            } else {
                str = iconUrl2;
            }
            String iconString = str;
            boolean useDefaultIcon = !scrolled && SetsKt.setOf(new ActionIconType[]{ActionIconType.BACK, ActionIconType.SEARCH, ActionIconType.CART, ActionIconType.SHARE}).contains(iconType);
            if (!useDefaultIcon && iconString == null) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup = $composer5.endRestartGroup();
                if (endRestartGroup != null) {
                    final Modifier modifier4 = modifier2;
                    final String str2 = iconUrl2;
                    final PaddingValues paddingValues = margin3;
                    final Integer num = count2;
                    endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.container.TopContainerKt$$ExternalSyntheticLambda1
                        public final Object invoke(Object obj, Object obj2) {
                            Unit TopActionButton$lambda$0;
                            TopActionButton$lambda$0 = TopContainerKt.TopActionButton$lambda$0(ActionIconType.this, scrolled, function0, scale, modifier4, str2, paddingValues, num, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                            return TopActionButton$lambda$0;
                        }
                    });
                    return;
                }
                return;
            }
            int $dirty2 = $dirty;
            Modifier modifier5 = modifier2;
            final PaddingValues margin4 = margin3;
            Modifier modifier6 = SizeKt.size-3ABfNKs(PaddingKt.padding(modifier5, margin4), ProvideUiScaleKt.dpScaled(30, scale));
            ComposerKt.sourceInformationMarkerStart($composer5, 1195383808, "CC(remember):TopContainer.kt#9igjgp");
            boolean invalid$iv = ($dirty2 & 896) == 256;
            Object it$iv = $composer5.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                modifier3 = modifier5;
                Object value$iv = new Function0() { // from class: kntr.app.mall.product.details.page.ui.container.TopContainerKt$$ExternalSyntheticLambda2
                    public final Object invoke() {
                        Unit TopActionButton$lambda$1$0;
                        TopActionButton$lambda$1$0 = TopContainerKt.TopActionButton$lambda$1$0(function0);
                        return TopActionButton$lambda$1$0;
                    }
                };
                $composer5.updateRememberedValue(value$iv);
                it$iv = value$iv;
            } else {
                modifier3 = modifier5;
            }
            ComposerKt.sourceInformationMarkerEnd($composer5);
            Modifier modifier$iv = ClickableKt.clickable-oSLSa3U$default(modifier6, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer5, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer5, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer5, 0));
            CompositionLocalMap localMap$iv$iv = $composer5.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer5, modifier$iv);
            Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer5, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer5.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer5.startReusableNode();
            if ($composer5.getInserting()) {
                $composer5.createNode(factory$iv$iv$iv3);
            } else {
                $composer5.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer5);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i6 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer5, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            int i7 = ((0 >> 6) & 112) | 6;
            BoxScope $this$TopActionButton_u24lambda_u2422 = BoxScopeInstance.INSTANCE;
            $composer5.startReplaceGroup(1762864668);
            ComposerKt.sourceInformation($composer5, "C704@26897L1633:TopContainer.kt#u9475x");
            Modifier clip = ClipKt.clip(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(ProvideUiScaleKt.dpScaled(6, scale)));
            Color.Companion companion = Color.Companion;
            Modifier modifier$iv2 = BackgroundKt.background-bw27NRU$default(clip, useDefaultIcon ? m587withOverlayAlphaDxMtmZc(companion.getBlack-0d7_KjU(), 0.5f) : companion.getTransparent-0d7_KjU(), (Shape) null, 2, (Object) null);
            Alignment contentAlignment$iv2 = Alignment.Companion.getCenter();
            ComposerKt.sourceInformationMarkerStart($composer5, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
            int $changed$iv$iv2 = (48 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer5, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer5, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer5.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer5, modifier$iv2);
            Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer5, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer5.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer5.startReusableNode();
            if ($composer5.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv4;
                $composer5.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv4;
                $composer5.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer5);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i8 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer5, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i9 = ((48 >> 6) & 112) | 6;
            $composer5.startReplaceGroup(193432690);
            ComposerKt.sourceInformation($composer5, "C:TopContainer.kt#u9475x");
            if (useDefaultIcon) {
                $composer5.startReplaceGroup(193439385);
                ComposerKt.sourceInformation($composer5, "726@27887L215");
                switch (WhenMappings.$EnumSwitchMapping$0[iconType.ordinal()]) {
                    case 1:
                        $composer$iv$iv$iv2 = $composer5;
                        $composer5.startReplaceGroup(976075031);
                        ComposerKt.sourceInformation($composer5, "717@27451L20");
                        arrow_share_line_500 = BiliIconfont.INSTANCE.getArrow_share_line_500($composer5, 6);
                        $composer5.endReplaceGroup();
                        break;
                    case 2:
                        $composer$iv$iv$iv2 = $composer5;
                        $composer5.startReplaceGroup(976080345);
                        ComposerKt.sourceInformation($composer5, "719@27617L22");
                        arrow_share_line_500 = BiliIconfont.INSTANCE.getShopping_cart_line_500($composer5, 6);
                        $composer5.endReplaceGroup();
                        break;
                    case 3:
                        $composer$iv$iv$iv2 = $composer5;
                        $composer5.startReplaceGroup(976077627);
                        ComposerKt.sourceInformation($composer5, "718@27532L24");
                        arrow_share_line_500 = BiliIconfont.INSTANCE.getArrow_back_left_line_500($composer5, 6);
                        $composer5.endReplaceGroup();
                        break;
                    case 4:
                        $composer5.startReplaceGroup(976083068);
                        ComposerKt.sourceInformation($composer5, "720@27702L25");
                        $composer$iv$iv$iv2 = $composer5;
                        arrow_share_line_500 = BiliIconfont.INSTANCE.getMagnifier_search_line_500($composer5, 6);
                        $composer5.endReplaceGroup();
                        break;
                    default:
                        $composer$iv$iv$iv2 = $composer5;
                        $composer5.startReplaceGroup(193860922);
                        $composer5.endReplaceGroup();
                        arrow_share_line_500 = null;
                        break;
                }
                Painter painter = arrow_share_line_500;
                if (painter == null) {
                    $composer5.endToMarker(currentMarker);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    ScopeUpdateScope endRestartGroup2 = $composer5.endRestartGroup();
                    if (endRestartGroup2 != null) {
                        final Modifier modifier7 = modifier3;
                        final String str3 = iconUrl2;
                        final Integer num2 = count2;
                        endRestartGroup2.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.container.TopContainerKt$$ExternalSyntheticLambda3
                            public final Object invoke(Object obj, Object obj2) {
                                Unit TopActionButton$lambda$2$0$0;
                                TopActionButton$lambda$2$0$0 = TopContainerKt.TopActionButton$lambda$2$0$0(ActionIconType.this, scrolled, function0, scale, modifier7, str3, margin4, num2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                                return TopActionButton$lambda$2$0$0;
                            }
                        });
                        return;
                    }
                    return;
                }
                $composer$iv = $composer5;
                $composer$iv2 = $composer5;
                $composer2 = $composer5;
                $composer$iv$iv$iv = $composer$iv$iv$iv2;
                $this$TopActionButton_u24lambda_u242 = $this$TopActionButton_u24lambda_u2422;
                f = scale;
                IconKt.Icon-ww6aTOc(painter, (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(24, f)), Color.Companion.getWhite-0d7_KjU(), $composer5, Painter.$stable | 3120, 0);
                $composer5.endReplaceGroup();
                $composer3 = $composer5;
            } else {
                $composer$iv$iv$iv = $composer5;
                $composer$iv = $composer5;
                $composer$iv2 = $composer5;
                $composer2 = $composer5;
                $this$TopActionButton_u24lambda_u242 = $this$TopActionButton_u24lambda_u2422;
                f = scale;
                if (iconString != null) {
                    $composer3 = $composer5;
                    $composer3.startReplaceGroup(194255305);
                    ComposerKt.sourceInformation($composer3, "733@28164L342");
                    BiliImageKt.BiliImage(new ImageRequest(HelperKt.customizedImageUrl(iconString)).useRaw(true).contentScale(ContentScale.Companion.getFit()).build(), SizeKt.size-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(24, f)), null, null, null, null, null, null, null, $composer3, 0, 508);
                } else {
                    $composer3 = $composer5;
                    $composer3.startReplaceGroup(166321887);
                }
                $composer3.endReplaceGroup();
            }
            $composer3.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            $composer$iv$iv$iv.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer5);
            ComposerKt.sourceInformationMarkerEnd($composer5);
            if (count2 == null || count2.intValue() <= 0) {
                margin2 = margin4;
                $composer4 = $composer5;
                $composer4.startReplaceGroup(1736101561);
            } else {
                $composer4 = $composer5;
                $composer4.startReplaceGroup(1764474342);
                ComposerKt.sourceInformation($composer4, "751@28868L6,745@28586L891");
                Modifier modifier$iv3 = PaddingKt.padding-VpY3zN4$default(SizeKt.widthIn-VpY3zN4$default(SizeKt.height-3ABfNKs(BackgroundKt.background-bw27NRU(OffsetKt.absoluteOffset-VpY3zN4($this$TopActionButton_u24lambda_u242.align(Modifier.Companion, Alignment.Companion.getTopEnd()), ProvideUiScaleKt.dpScaled(6, f), ProvideUiScaleKt.dpScaled(-2, f)), BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getBrand_pink-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(ProvideUiScaleKt.dpScaled(8, f))), ProvideUiScaleKt.dpScaled(16, f)), ProvideUiScaleKt.dpScaled(16, f), 0.0f, 2, (Object) null), ProvideUiScaleKt.dpScaled(4, f), 0.0f, 2, (Object) null);
                Alignment contentAlignment$iv3 = Alignment.Companion.getCenter();
                ComposerKt.sourceInformationMarkerStart($composer4, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv3 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv3, false);
                int $changed$iv$iv3 = (48 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
                CompositionLocalMap localMap$iv$iv3 = $composer4.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer4, modifier$iv3);
                Function0 factory$iv$iv$iv5 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
                margin2 = margin4;
                ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer4.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer4.startReusableNode();
                if ($composer4.getInserting()) {
                    factory$iv$iv$iv2 = factory$iv$iv$iv5;
                    $composer4.createNode(factory$iv$iv$iv2);
                } else {
                    factory$iv$iv$iv2 = factory$iv$iv$iv5;
                    $composer4.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer4);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
                int i10 = ($changed$iv$iv$iv3 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer4, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
                int i11 = ((48 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer4, 685187181, "C760@29341L9,758@29225L238:TopContainer.kt#u9475x");
                TextKt.Text-Nvy7gAk(count2.intValue() > 99 ? "99+" : String.valueOf(count2.intValue()), (Modifier) null, Color.Companion.getWhite-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, ProvideUiScaleKt.scaled(BiliTheme.INSTANCE.getTextStyle($composer4, BiliTheme.$stable).getT10b(), f), $composer4, 384, 24576, 114682);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                $composer4.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
            }
            $composer4.endReplaceGroup();
            $composer4.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer5);
            $composer5.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer5);
            ComposerKt.sourceInformationMarkerEnd($composer5);
            ComposerKt.sourceInformationMarkerEnd($composer$iv2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2 = $composer5;
            $composer2.skipToGroupEnd();
            iconUrl2 = iconUrl;
            margin2 = margin;
            count2 = count;
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup3 = $composer2.endRestartGroup();
        if (endRestartGroup3 != null) {
            final Modifier modifier8 = modifier3;
            final String str4 = iconUrl2;
            final PaddingValues paddingValues2 = margin2;
            final Integer num3 = count2;
            endRestartGroup3.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.container.TopContainerKt$$ExternalSyntheticLambda4
                public final Object invoke(Object obj, Object obj2) {
                    Unit TopActionButton$lambda$3;
                    TopActionButton$lambda$3 = TopContainerKt.TopActionButton$lambda$3(ActionIconType.this, scrolled, function0, scale, modifier8, str4, paddingValues2, num3, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return TopActionButton$lambda$3;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TopActionButton$lambda$1$0(Function0 $onClick) {
        $onClick.invoke();
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:116:0x03f4, code lost:
        if (r8 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L94;
     */
    /* JADX WARN: Removed duplicated region for block: B:101:0x03a0  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0673  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x088e  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x020a  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0297  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x029c  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0318  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0324  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x032a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void TopSearchComponent(final boolean isScrolled, final String iconUrl, final List<BasicInfoFloor.SalePoint> list, final Function1<? super String, Unit> function1, final float scale, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        int $dirty;
        Composer $composer2;
        Modifier modifier3;
        Modifier modifier4;
        long j;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Composer $composer$iv;
        Composer $composer3;
        Composer $composer$iv$iv;
        Composer $composer$iv$iv$iv;
        Composer $composer$iv$iv2;
        Function0 factory$iv$iv$iv3;
        MeasurePolicy measurePolicy$iv$iv;
        Composer $composer4;
        Function0 factory$iv$iv$iv4;
        Composer $composer5 = $composer.startRestartGroup(-255633188);
        ComposerKt.sourceInformation($composer5, "C(TopSearchComponent)N(isScrolled,iconUrl,salePoint,onClick,scale,modifier)781@29809L33,782@29889L305,782@29847L347,792@30200L3171:TopContainer.kt#u9475x");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer5.changed(isScrolled) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty2 |= $composer5.changed(iconUrl) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty2 |= $composer5.changedInstance(list) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty2 |= $composer5.changedInstance(function1) ? 2048 : 1024;
        }
        if (($changed & 24576) == 0) {
            $dirty2 |= $composer5.changed(scale) ? 16384 : 8192;
        }
        int i2 = i & 32;
        if (i2 != 0) {
            $dirty2 |= 196608;
            modifier2 = modifier;
        } else if ((196608 & $changed) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer5.changed(modifier2) ? 131072 : 65536;
        } else {
            modifier2 = modifier;
        }
        if (!$composer5.shouldExecute((74899 & $dirty2) != 74898, $dirty2 & 1)) {
            $dirty = $dirty2;
            $composer2 = $composer5;
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-255633188, $dirty2, -1, "kntr.app.mall.product.details.page.ui.container.TopSearchComponent (TopContainer.kt:780)");
            }
            ComposerKt.sourceInformationMarkerStart($composer5, -850349027, "CC(remember):TopContainer.kt#9igjgp");
            Object it$iv = $composer5.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                MutableState mutableStateOf$default = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer5.updateRememberedValue(mutableStateOf$default);
                it$iv = mutableStateOf$default;
            }
            final MutableState requestedSearchText = (MutableState) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer5);
            Object value = requestedSearchText.getValue();
            ComposerKt.sourceInformationMarkerStart($composer5, -850346195, "CC(remember):TopContainer.kt#9igjgp");
            Object it$iv2 = $composer5.rememberedValue();
            if (it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv = (Function2) new TopContainerKt$TopSearchComponent$1$1(requestedSearchText, null);
                $composer5.updateRememberedValue(value$iv);
                it$iv2 = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer5);
            EffectsKt.LaunchedEffect(value, (Function2) it$iv2, $composer5, 0);
            Modifier modifier5 = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, (Object) null), ProvideUiScaleKt.dpScaled(34, scale));
            if (isScrolled) {
                List<BasicInfoFloor.SalePoint> list2 = list;
                if (list2 == null || list2.isEmpty()) {
                    $composer5.startReplaceGroup(-590381830);
                    ComposerKt.sourceInformation($composer5, "800@30487L6");
                    j = BiliTheme.INSTANCE.getColors($composer5, BiliTheme.$stable).getBg2-0d7_KjU();
                    $composer5.endReplaceGroup();
                    Modifier modifier$iv = PaddingKt.padding-VpY3zN4$default(BackgroundKt.background-bw27NRU(modifier5, j, RoundedCornerShapeKt.RoundedCornerShape-0680j_4(ProvideUiScaleKt.dpScaled(15, scale))), ProvideUiScaleKt.dpScaled(8, scale), 0.0f, 2, (Object) null);
                    ComposerKt.sourceInformationMarkerStart($composer5, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
                    MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                    int $changed$iv$iv = (0 << 3) & 112;
                    modifier3 = modifier4;
                    ComposerKt.sourceInformationMarkerStart($composer5, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer5, 0));
                    CompositionLocalMap localMap$iv$iv = $composer5.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer5, modifier$iv);
                    Function0 factory$iv$iv$iv5 = ComposeUiNode.Companion.getConstructor();
                    int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                    $composer2 = $composer5;
                    ComposerKt.sourceInformationMarkerStart($composer5, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!($composer5.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer5.startReusableNode();
                    if (!$composer5.getInserting()) {
                        factory$iv$iv$iv = factory$iv$iv$iv5;
                        $composer5.createNode(factory$iv$iv$iv);
                    } else {
                        factory$iv$iv$iv = factory$iv$iv$iv5;
                        $composer5.useNode();
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer5);
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
                    int i3 = ($changed$iv$iv$iv >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer5, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScope boxScope = BoxScopeInstance.INSTANCE;
                    int i4 = ((0 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer5, 1980314791, "C807@30747L2618:TopContainer.kt#u9475x");
                    Modifier modifier$iv2 = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
                    Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
                    Arrangement arrangement = Arrangement.INSTANCE;
                    Arrangement.Horizontal horizontalArrangement$iv = !isScrolled ? arrangement.getStart() : arrangement.getEnd();
                    ComposerKt.sourceInformationMarkerStart($composer5, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                    MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer5, ((390 >> 3) & 14) | ((390 >> 3) & 112));
                    int $changed$iv$iv2 = (390 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer5, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer5, 0));
                    CompositionLocalMap localMap$iv$iv2 = $composer5.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer5, modifier$iv2);
                    Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
                    int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer5, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!($composer5.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer5.startReusableNode();
                    if (!$composer5.getInserting()) {
                        factory$iv$iv$iv2 = factory$iv$iv$iv6;
                        $composer5.createNode(factory$iv$iv$iv2);
                    } else {
                        factory$iv$iv$iv2 = factory$iv$iv$iv6;
                        $composer5.useNode();
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer5);
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
                    int i5 = ($changed$iv$iv$iv2 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer5, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                    RowScope rowScope = RowScopeInstance.INSTANCE;
                    int i6 = ((390 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer5, 2018639729, "C:TopContainer.kt#u9475x");
                    if (!isScrolled) {
                        $composer5.startReplaceGroup(2018629374);
                        ComposerKt.sourceInformation($composer5, "");
                        List<BasicInfoFloor.SalePoint> list3 = list;
                        if (list3 == null || list3.isEmpty()) {
                            $composer5.startReplaceGroup(2018688491);
                            ComposerKt.sourceInformation($composer5, "818@31230L106,814@31062L1169");
                            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
                            ComposerKt.sourceInformationMarkerStart($composer5, -489066032, "CC(remember):TopContainer.kt#9igjgp");
                            boolean invalid$iv = ($dirty2 & 7168) == 2048;
                            Object it$iv3 = $composer5.rememberedValue();
                            if (invalid$iv) {
                            }
                            Object value$iv2 = new Function0() { // from class: kntr.app.mall.product.details.page.ui.container.TopContainerKt$$ExternalSyntheticLambda5
                                public final Object invoke() {
                                    Unit TopSearchComponent$lambda$2$0$0$0;
                                    TopSearchComponent$lambda$2$0$0$0 = TopContainerKt.TopSearchComponent$lambda$2$0$0$0(function1, requestedSearchText);
                                    return TopSearchComponent$lambda$2$0$0$0;
                                }
                            };
                            $composer5.updateRememberedValue(value$iv2);
                            it$iv3 = value$iv2;
                            ComposerKt.sourceInformationMarkerEnd($composer5);
                            Modifier modifier$iv3 = ClickableKt.clickable-oSLSa3U$default(fillMaxWidth$default, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv3, 15, (Object) null);
                            Alignment.Vertical verticalAlignment$iv2 = Alignment.Companion.getCenterVertically();
                            Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.getStart();
                            ComposerKt.sourceInformationMarkerStart($composer5, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                            MeasurePolicy measurePolicy$iv3 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer5, ((432 >> 3) & 14) | ((432 >> 3) & 112));
                            int $changed$iv$iv3 = (432 << 3) & 112;
                            ComposerKt.sourceInformationMarkerStart($composer5, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                            int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer5, 0));
                            CompositionLocalMap localMap$iv$iv3 = $composer5.getCurrentCompositionLocalMap();
                            Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer5, modifier$iv3);
                            Function0 factory$iv$iv$iv7 = ComposeUiNode.Companion.getConstructor();
                            int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer5, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                            if (!($composer5.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            $composer5.startReusableNode();
                            if ($composer5.getInserting()) {
                                factory$iv$iv$iv4 = factory$iv$iv$iv7;
                                $composer5.createNode(factory$iv$iv$iv4);
                            } else {
                                factory$iv$iv$iv4 = factory$iv$iv$iv7;
                                $composer5.useNode();
                            }
                            Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer5);
                            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
                            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
                            int i7 = ($changed$iv$iv$iv3 >> 6) & 14;
                            ComposerKt.sourceInformationMarkerStart($composer5, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                            RowScope rowScope2 = RowScopeInstance.INSTANCE;
                            int i8 = ((432 >> 6) & 112) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer5, -1752115977, "C825@31582L25,827@31709L6,824@31525L297,833@32053L9,834@32128L6,830@31847L362:TopContainer.kt#u9475x");
                            IconKt.Icon-ww6aTOc(BiliIconfont.INSTANCE.getMagnifier_search_line_500($composer5, 6), (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(16, scale)), BiliTheme.INSTANCE.getColors($composer5, BiliTheme.$stable).getText4-0d7_KjU(), $composer5, Painter.$stable | 48, 0);
                            String str = (String) requestedSearchText.getValue();
                            if (str == null) {
                                str = "搜索";
                            }
                            TextKt.Text-Nvy7gAk(str, PaddingKt.padding-qDBjuR0$default(Modifier.Companion, ProvideUiScaleKt.dpScaled(4, scale), 0.0f, 0.0f, 0.0f, 14, (Object) null), BiliTheme.INSTANCE.getColors($composer5, BiliTheme.$stable).getText4-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, ProvideUiScaleKt.scaled(BiliTheme.INSTANCE.getTextStyle($composer5, BiliTheme.$stable).getT14(), scale), $composer5, 0, 24576, 114680);
                            ComposerKt.sourceInformationMarkerEnd($composer5);
                            ComposerKt.sourceInformationMarkerEnd($composer5);
                            $composer5.endNode();
                            ComposerKt.sourceInformationMarkerEnd($composer5);
                            ComposerKt.sourceInformationMarkerEnd($composer5);
                            ComposerKt.sourceInformationMarkerEnd($composer5);
                            $composer5.endReplaceGroup();
                            $composer4 = $composer5;
                            $composer$iv$iv = $composer5;
                            measurePolicy$iv$iv = measurePolicy$iv;
                            $composer$iv = $composer5;
                            $composer$iv$iv$iv = $composer5;
                            $composer$iv$iv2 = $composer5;
                        } else {
                            $composer5.startReplaceGroup(2019864228);
                            ComposerKt.sourceInformation($composer5, "839@32277L216");
                            $composer$iv$iv = $composer5;
                            measurePolicy$iv$iv = measurePolicy$iv;
                            $composer$iv$iv$iv = $composer5;
                            $composer4 = $composer5;
                            $composer$iv = $composer5;
                            $composer$iv$iv2 = $composer5;
                            VerticalCarouselComponent(list, iconUrl, scale, null, 0L, 0, null, function1, $composer4, (($dirty2 >> 6) & 14) | ($dirty2 & 112) | (($dirty2 >> 6) & 896) | (($dirty2 << 12) & 29360128), BackoffConfigKt.MAX_DELAY_SECONDS);
                            $composer4.endReplaceGroup();
                        }
                        $composer4.endReplaceGroup();
                        $dirty = $dirty2;
                        $composer3 = $composer4;
                    } else {
                        $composer$iv = $composer5;
                        $composer3 = $composer5;
                        $composer$iv$iv = $composer5;
                        $composer$iv$iv$iv = $composer5;
                        $composer$iv$iv2 = $composer5;
                        $composer3.startReplaceGroup(2020135044);
                        ComposerKt.sourceInformation($composer3, "853@32860L98,847@32549L792");
                        Modifier modifier6 = BackgroundKt.background-bw27NRU$default(ClipKt.clip(SizeKt.size-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(30, scale)), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(ProvideUiScaleKt.dpScaled(6, scale))), m587withOverlayAlphaDxMtmZc(Color.Companion.getBlack-0d7_KjU(), 0.5f), (Shape) null, 2, (Object) null);
                        ComposerKt.sourceInformationMarkerStart($composer3, -489013880, "CC(remember):TopContainer.kt#9igjgp");
                        boolean invalid$iv2 = ($dirty2 & 7168) == 2048;
                        Object it$iv4 = $composer3.rememberedValue();
                        if (invalid$iv2 || it$iv4 == Composer.Companion.getEmpty()) {
                            $dirty = $dirty2;
                            Object value$iv3 = new Function0() { // from class: kntr.app.mall.product.details.page.ui.container.TopContainerKt$$ExternalSyntheticLambda6
                                public final Object invoke() {
                                    Unit TopSearchComponent$lambda$2$0$2$0;
                                    TopSearchComponent$lambda$2$0$2$0 = TopContainerKt.TopSearchComponent$lambda$2$0$2$0(function1, requestedSearchText);
                                    return TopSearchComponent$lambda$2$0$2$0;
                                }
                            };
                            $composer3.updateRememberedValue(value$iv3);
                            it$iv4 = value$iv3;
                        } else {
                            $dirty = $dirty2;
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        Modifier modifier$iv4 = ClickableKt.clickable-oSLSa3U$default(modifier6, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv4, 15, (Object) null);
                        Alignment contentAlignment$iv2 = Alignment.Companion.getCenter();
                        ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicy$iv4 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
                        int $changed$iv$iv4 = (48 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv4 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
                        CompositionLocalMap localMap$iv$iv4 = $composer3.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer3, modifier$iv4);
                        Function0 factory$iv$iv$iv8 = ComposeUiNode.Companion.getConstructor();
                        int $changed$iv$iv$iv4 = (($changed$iv$iv4 << 6) & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                        if (!($composer3.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer3.startReusableNode();
                        if ($composer3.getInserting()) {
                            factory$iv$iv$iv3 = factory$iv$iv$iv8;
                            $composer3.createNode(factory$iv$iv$iv3);
                        } else {
                            factory$iv$iv$iv3 = factory$iv$iv$iv8;
                            $composer3.useNode();
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv4 = Updater.constructor-impl($composer3);
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, measurePolicy$iv4, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, localMap$iv$iv4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Updater.init-impl($this$Layout_u24lambda_u240$iv$iv4, Integer.valueOf(compositeKeyHash$iv$iv4), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv4, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, materialized$iv$iv4, ComposeUiNode.Companion.getSetModifier());
                        int i9 = ($changed$iv$iv$iv4 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                        BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
                        int i10 = ((48 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer3, 1302058377, "C859@33110L25,858@33057L266:TopContainer.kt#u9475x");
                        IconKt.Icon-ww6aTOc(BiliIconfont.INSTANCE.getMagnifier_search_line_500($composer3, 6), (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(24, scale)), Color.Companion.getWhite-0d7_KjU(), $composer3, Painter.$stable | 3120, 0);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        $composer3.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        $composer3.endReplaceGroup();
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv);
                    $composer$iv$iv$iv.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv$iv2);
                    ComposerKt.sourceInformationMarkerEnd($composer5);
                    ComposerKt.sourceInformationMarkerEnd($composer5);
                    ComposerKt.sourceInformationMarkerEnd($composer5);
                    $composer5.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer5);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
                    ComposerKt.sourceInformationMarkerEnd($composer5);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }
            $composer5.startReplaceGroup(-590300579);
            $composer5.endReplaceGroup();
            j = Color.Companion.getTransparent-0d7_KjU();
            Modifier modifier$iv5 = PaddingKt.padding-VpY3zN4$default(BackgroundKt.background-bw27NRU(modifier5, j, RoundedCornerShapeKt.RoundedCornerShape-0680j_4(ProvideUiScaleKt.dpScaled(15, scale))), ProvideUiScaleKt.dpScaled(8, scale), 0.0f, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer5, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv3 = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv5 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv3, false);
            int $changed$iv$iv5 = (0 << 3) & 112;
            modifier3 = modifier4;
            ComposerKt.sourceInformationMarkerStart($composer5, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv5 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer5, 0));
            CompositionLocalMap localMap$iv$iv5 = $composer5.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv5 = ComposedModifierKt.materializeModifier($composer5, modifier$iv5);
            Function0 factory$iv$iv$iv52 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv5 = (($changed$iv$iv5 << 6) & 896) | 6;
            $composer2 = $composer5;
            ComposerKt.sourceInformationMarkerStart($composer5, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer5.getApplier() instanceof Applier)) {
            }
            $composer5.startReusableNode();
            if (!$composer5.getInserting()) {
            }
            Composer $this$Layout_u24lambda_u240$iv$iv5 = Updater.constructor-impl($composer5);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, measurePolicy$iv5, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, localMap$iv$iv5, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv5, Integer.valueOf(compositeKeyHash$iv$iv5), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv5, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, materialized$iv$iv5, ComposeUiNode.Companion.getSetModifier());
            int i32 = ($changed$iv$iv$iv5 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer5, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope3 = BoxScopeInstance.INSTANCE;
            int i42 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer5, 1980314791, "C807@30747L2618:TopContainer.kt#u9475x");
            Modifier modifier$iv22 = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
            Alignment.Vertical verticalAlignment$iv3 = Alignment.Companion.getCenterVertically();
            Arrangement arrangement2 = Arrangement.INSTANCE;
            if (!isScrolled) {
            }
            ComposerKt.sourceInformationMarkerStart($composer5, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv22 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv3, $composer5, ((390 >> 3) & 14) | ((390 >> 3) & 112));
            int $changed$iv$iv22 = (390 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer5, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv22 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer5, 0));
            CompositionLocalMap localMap$iv$iv22 = $composer5.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv22 = ComposedModifierKt.materializeModifier($composer5, modifier$iv22);
            Function0 factory$iv$iv$iv62 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv22 = (($changed$iv$iv22 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer5, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer5.getApplier() instanceof Applier)) {
            }
            $composer5.startReusableNode();
            if (!$composer5.getInserting()) {
            }
            Composer $this$Layout_u24lambda_u240$iv$iv22 = Updater.constructor-impl($composer5);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv22, measurePolicy$iv22, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv22, localMap$iv$iv22, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv22, Integer.valueOf(compositeKeyHash$iv$iv22), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv22, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv22, materialized$iv$iv22, ComposeUiNode.Companion.getSetModifier());
            int i52 = ($changed$iv$iv$iv22 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer5, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope3 = RowScopeInstance.INSTANCE;
            int i62 = ((390 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer5, 2018639729, "C:TopContainer.kt#u9475x");
            if (!isScrolled) {
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            $composer$iv$iv$iv.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv2);
            ComposerKt.sourceInformationMarkerEnd($composer5);
            ComposerKt.sourceInformationMarkerEnd($composer5);
            ComposerKt.sourceInformationMarkerEnd($composer5);
            $composer5.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer5);
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer5);
            if (ComposerKt.isTraceInProgress()) {
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier7 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.container.TopContainerKt$$ExternalSyntheticLambda7
                public final Object invoke(Object obj, Object obj2) {
                    Unit TopSearchComponent$lambda$3;
                    TopSearchComponent$lambda$3 = TopContainerKt.TopSearchComponent$lambda$3(isScrolled, iconUrl, list, function1, scale, modifier7, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return TopSearchComponent$lambda$3;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TopSearchComponent$lambda$2$0$0$0(Function1 $onClick, MutableState $requestedSearchText) {
        $onClick.invoke($requestedSearchText.getValue());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TopSearchComponent$lambda$2$0$2$0(Function1 $onClick, MutableState $requestedSearchText) {
        $onClick.invoke($requestedSearchText.getValue());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit VerticalCarouselComponent$lambda$1$0(String it) {
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:191:0x03be, code lost:
        if (r14.changed(r7) == false) goto L148;
     */
    /* JADX WARN: Code restructure failed: missing block: B:226:0x0655, code lost:
        if (r9 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L124;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0266  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x02af  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x048c  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x048e  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x0552  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x055e  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x0564  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x064d  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x0659  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x06a8  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x06ef  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x074b  */
    /* JADX WARN: Type inference failed for: r9v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void VerticalCarouselComponent(final List<BasicInfoFloor.SalePoint> list, final String iconUrl, final float scale, Modifier modifier, long intervalMs, int animDurationMs, Function1<? super Float, Float> function1, Function1<? super String, Unit> function12, Composer $composer, final int $changed, final int i) {
        long j;
        Composer $composer2;
        Modifier modifier2;
        int animDurationMs2;
        Function1 easing;
        Function1 onClick;
        long intervalMs2;
        Modifier modifier3;
        Function1 easing2;
        Function1 onClick2;
        int animDurationMs3;
        Modifier modifier4;
        int $dirty;
        Function1 easing3;
        final List displayList;
        Function1 easing4;
        boolean z;
        boolean invalid$iv;
        Object it$iv;
        int animDurationMs4;
        boolean invalid$iv2;
        Object it$iv2;
        int animDurationMs5;
        final Function1 onClick3;
        Function0 factory$iv$iv$iv;
        boolean invalid$iv3;
        String str;
        int i2;
        Composer $composer3 = $composer.startRestartGroup(-1837533901);
        ComposerKt.sourceInformation($composer3, "C(VerticalCarouselComponent)N(items,iconUrl,scale,modifier,intervalMs,animDurationMs,easing,onClick)886@33806L86,894@33973L40,895@34038L40,900@34261L503,900@34233L531,920@34847L646,938@35602L122,934@35499L1850:TopContainer.kt#u9475x");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer3.changedInstance(list) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty2 |= $composer3.changed(iconUrl) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty2 |= $composer3.changed(scale) ? 256 : 128;
        }
        int i3 = i & 8;
        if (i3 != 0) {
            $dirty2 |= 3072;
        } else if (($changed & 3072) == 0) {
            $dirty2 |= $composer3.changed(modifier) ? 2048 : 1024;
        }
        int i4 = i & 16;
        if (i4 != 0) {
            $dirty2 |= 24576;
            j = intervalMs;
        } else if (($changed & 24576) == 0) {
            j = intervalMs;
            $dirty2 |= $composer3.changed(j) ? 16384 : 8192;
        } else {
            j = intervalMs;
        }
        int i5 = i & 32;
        if (i5 != 0) {
            $dirty2 |= 196608;
        } else if (($changed & 196608) == 0) {
            $dirty2 |= $composer3.changed(animDurationMs) ? 131072 : 65536;
        }
        if (($changed & 1572864) == 0) {
            if ((i & 64) == 0 && $composer3.changedInstance(function1)) {
                i2 = 1048576;
                $dirty2 |= i2;
            }
            i2 = 524288;
            $dirty2 |= i2;
        }
        int i6 = i & 128;
        if (i6 != 0) {
            $dirty2 |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty2 |= $composer3.changedInstance(function12) ? 8388608 : 4194304;
        }
        if ($composer3.shouldExecute(($dirty2 & 4793491) != 4793490, $dirty2 & 1)) {
            $composer3.startDefaults();
            ComposerKt.sourceInformation($composer3, "881@33678L30,883@33768L2");
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                Modifier modifier5 = i3 != 0 ? (Modifier) Modifier.Companion : modifier;
                long intervalMs3 = i4 != 0 ? 5000L : j;
                int animDurationMs6 = i5 != 0 ? 500 : animDurationMs;
                if ((i & 64) != 0) {
                    Easing fastOutSlowInEasing = EasingKt.getFastOutSlowInEasing();
                    ComposerKt.sourceInformationMarkerStart($composer3, -638511119, "CC(remember):TopContainer.kt#9igjgp");
                    boolean invalid$iv4 = $composer3.changed(fastOutSlowInEasing);
                    Object it$iv3 = $composer3.rememberedValue();
                    if (invalid$iv4) {
                        modifier3 = modifier5;
                    } else {
                        modifier3 = modifier5;
                        if (it$iv3 != Composer.Companion.getEmpty()) {
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            easing2 = (Function1) ((KFunction) it$iv3);
                            $dirty2 &= -3670017;
                        }
                    }
                    Object value$iv = (KFunction) new TopContainerKt$VerticalCarouselComponent$1$1(fastOutSlowInEasing);
                    $composer3.updateRememberedValue(value$iv);
                    it$iv3 = value$iv;
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    easing2 = (Function1) ((KFunction) it$iv3);
                    $dirty2 &= -3670017;
                } else {
                    modifier3 = modifier5;
                    easing2 = function1;
                }
                if (i6 != 0) {
                    ComposerKt.sourceInformationMarkerStart($composer3, -638508267, "CC(remember):TopContainer.kt#9igjgp");
                    Object it$iv4 = $composer3.rememberedValue();
                    if (it$iv4 == Composer.Companion.getEmpty()) {
                        Object value$iv2 = new Function1() { // from class: kntr.app.mall.product.details.page.ui.container.TopContainerKt$$ExternalSyntheticLambda10
                            public final Object invoke(Object obj) {
                                Unit VerticalCarouselComponent$lambda$1$0;
                                VerticalCarouselComponent$lambda$1$0 = TopContainerKt.VerticalCarouselComponent$lambda$1$0((String) obj);
                                return VerticalCarouselComponent$lambda$1$0;
                            }
                        };
                        $composer3.updateRememberedValue(value$iv2);
                        it$iv4 = value$iv2;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    onClick2 = it$iv4;
                    animDurationMs3 = animDurationMs6;
                    intervalMs2 = intervalMs3;
                    modifier4 = modifier3;
                    $dirty = $dirty2;
                    easing3 = easing2;
                } else {
                    onClick2 = function12;
                    animDurationMs3 = animDurationMs6;
                    intervalMs2 = intervalMs3;
                    modifier4 = modifier3;
                    $dirty = $dirty2;
                    easing3 = easing2;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 64) != 0) {
                    $dirty2 &= -3670017;
                }
                modifier4 = modifier;
                onClick2 = function12;
                $dirty = $dirty2;
                intervalMs2 = j;
                animDurationMs3 = animDurationMs;
                easing3 = function1;
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1837533901, $dirty, -1, "kntr.app.mall.product.details.page.ui.container.VerticalCarouselComponent (TopContainer.kt:884)");
            }
            ComposerKt.sourceInformationMarkerStart($composer3, -638506967, "CC(remember):TopContainer.kt#9igjgp");
            boolean invalid$iv5 = $composer3.changed(list);
            boolean z2 = false;
            Object it$iv5 = $composer3.rememberedValue();
            if (!invalid$iv5 && it$iv5 != Composer.Companion.getEmpty()) {
                displayList = (List) it$iv5;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                if (!displayList.isEmpty()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    ScopeUpdateScope endRestartGroup = $composer3.endRestartGroup();
                    if (endRestartGroup != null) {
                        final Modifier modifier6 = modifier4;
                        final Function1 onClick4 = onClick2;
                        final long j2 = intervalMs2;
                        final Function1 easing5 = easing3;
                        final int i7 = animDurationMs3;
                        endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.container.TopContainerKt$$ExternalSyntheticLambda19
                            public final Object invoke(Object obj, Object obj2) {
                                Unit VerticalCarouselComponent$lambda$3;
                                VerticalCarouselComponent$lambda$3 = TopContainerKt.VerticalCarouselComponent$lambda$3(list, iconUrl, scale, modifier6, j2, i7, easing5, onClick4, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                                return VerticalCarouselComponent$lambda$3;
                            }
                        });
                        return;
                    }
                    return;
                }
                Function1 onClick5 = onClick2;
                int $dirty3 = $dirty;
                Function1 easing6 = easing3;
                int animDurationMs7 = animDurationMs3;
                Modifier modifier7 = modifier4;
                $composer2 = $composer3;
                ComposerKt.sourceInformationMarkerStart($composer2, -638501669, "CC(remember):TopContainer.kt#9igjgp");
                boolean invalid$iv6 = $composer2.changed(list);
                Object it$iv6 = $composer2.rememberedValue();
                if (invalid$iv6 || it$iv6 == Composer.Companion.getEmpty()) {
                    Object value$iv3 = SnapshotIntStateKt.mutableIntStateOf(0);
                    $composer2.updateRememberedValue(value$iv3);
                    it$iv6 = value$iv3;
                }
                MutableIntState settledIndex$delegate = (MutableIntState) it$iv6;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerStart($composer2, -638499589, "CC(remember):TopContainer.kt#9igjgp");
                boolean invalid$iv7 = $composer2.changed(list);
                Object it$iv7 = $composer2.rememberedValue();
                if (invalid$iv7 || it$iv7 == Composer.Companion.getEmpty()) {
                    Object value$iv4 = SnapshotIntStateKt.mutableIntStateOf(0);
                    $composer2.updateRememberedValue(value$iv4);
                    it$iv7 = value$iv4;
                }
                MutableIntState displayIndex$delegate = (MutableIntState) it$iv7;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                final int safeSettledIndex = RangesKt.coerceIn(VerticalCarouselComponent$lambda$5(settledIndex$delegate), 0, displayList.size() - 1);
                int safeDisplayIndex = RangesKt.coerceIn(VerticalCarouselComponent$lambda$8(displayIndex$delegate), 0, displayList.size() - 1);
                ComposerKt.sourceInformationMarkerStart($composer2, -638491990, "CC(remember):TopContainer.kt#9igjgp");
                boolean invalid$iv8 = $composer2.changed(settledIndex$delegate) | $composer2.changedInstance(displayList) | $composer2.changed(displayIndex$delegate) | (($dirty3 & 57344) == 16384) | (($dirty3 & 458752) == 131072);
                Object it$iv8 = $composer2.rememberedValue();
                if (invalid$iv8 || it$iv8 == Composer.Companion.getEmpty()) {
                    Object value$iv5 = (Function2) new TopContainerKt$VerticalCarouselComponent$4$1(displayList, intervalMs2, animDurationMs7, settledIndex$delegate, displayIndex$delegate, null);
                    $composer2.updateRememberedValue(value$iv5);
                    it$iv8 = value$iv5;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                EffectsKt.LaunchedEffect(displayList, (Function2) it$iv8, $composer2, 0);
                ComposerKt.sourceInformationMarkerStart($composer2, -638473095, "CC(remember):TopContainer.kt#9igjgp");
                boolean z3 = ($dirty3 & 458752) == 131072;
                if ((($dirty3 & 3670016) ^ 1572864) > 1048576) {
                    easing4 = easing6;
                } else {
                    easing4 = easing6;
                }
                if (($dirty3 & 1572864) != 1048576) {
                    z = false;
                    invalid$iv = z3 | z;
                    it$iv = $composer2.rememberedValue();
                    if (!invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                        animDurationMs4 = animDurationMs7;
                        easing = easing4;
                        Object value$iv6 = AnimatedContentKt.togetherWith(EnterExitTransitionKt.slideInVertically(AnimationSpecKt.tween$default(animDurationMs4, 0, new TopContainerKt$sam$androidx_compose_animation_core_Easing$0(easing4), 2, (Object) null), new Function1() { // from class: kntr.app.mall.product.details.page.ui.container.TopContainerKt$$ExternalSyntheticLambda20
                            public final Object invoke(Object obj) {
                                int VerticalCarouselComponent$lambda$11$0;
                                VerticalCarouselComponent$lambda$11$0 = TopContainerKt.VerticalCarouselComponent$lambda$11$0(((Integer) obj).intValue());
                                return Integer.valueOf(VerticalCarouselComponent$lambda$11$0);
                            }
                        }).plus(EnterExitTransitionKt.fadeIn$default(AnimationSpecKt.tween$default(animDurationMs4, 0, new TopContainerKt$sam$androidx_compose_animation_core_Easing$0(easing4), 2, (Object) null), 0.0f, 2, (Object) null)), EnterExitTransitionKt.slideOutVertically(AnimationSpecKt.tween$default(animDurationMs4, 0, new TopContainerKt$sam$androidx_compose_animation_core_Easing$0(easing4), 2, (Object) null), new Function1() { // from class: kntr.app.mall.product.details.page.ui.container.TopContainerKt$$ExternalSyntheticLambda21
                            public final Object invoke(Object obj) {
                                int VerticalCarouselComponent$lambda$11$1;
                                VerticalCarouselComponent$lambda$11$1 = TopContainerKt.VerticalCarouselComponent$lambda$11$1(((Integer) obj).intValue());
                                return Integer.valueOf(VerticalCarouselComponent$lambda$11$1);
                            }
                        }).plus(EnterExitTransitionKt.fadeOut$default(AnimationSpecKt.tween$default(animDurationMs4, 0, new TopContainerKt$sam$androidx_compose_animation_core_Easing$0(easing4), 2, (Object) null), 0.0f, 2, (Object) null)));
                        $composer2.updateRememberedValue(value$iv6);
                        it$iv = value$iv6;
                    } else {
                        easing = easing4;
                        animDurationMs4 = animDurationMs7;
                    }
                    final ContentTransform spec = (ContentTransform) it$iv;
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(modifier7, 0.0f, 1, (Object) null);
                    ComposerKt.sourceInformationMarkerStart($composer2, -638449459, "CC(remember):TopContainer.kt#9igjgp");
                    invalid$iv2 = $composer2.changedInstance(displayList) | $composer2.changed(safeSettledIndex) | (($dirty3 & 29360128) != 8388608);
                    it$iv2 = $composer2.rememberedValue();
                    if (!invalid$iv2 || it$iv2 == Composer.Companion.getEmpty()) {
                        animDurationMs5 = animDurationMs4;
                        onClick3 = onClick5;
                        Object value$iv7 = new Function0() { // from class: kntr.app.mall.product.details.page.ui.container.TopContainerKt$$ExternalSyntheticLambda22
                            public final Object invoke() {
                                Unit VerticalCarouselComponent$lambda$12$0;
                                VerticalCarouselComponent$lambda$12$0 = TopContainerKt.VerticalCarouselComponent$lambda$12$0(displayList, safeSettledIndex, onClick3);
                                return VerticalCarouselComponent$lambda$12$0;
                            }
                        };
                        $composer2.updateRememberedValue(value$iv7);
                        it$iv2 = value$iv7;
                    } else {
                        animDurationMs5 = animDurationMs4;
                        onClick3 = onClick5;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    Modifier modifier$iv$iv = ClickableKt.clickable-oSLSa3U$default(fillMaxSize$default, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv2, 15, (Object) null);
                    Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
                    ComposerKt.sourceInformationMarkerStart($composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                    Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                    MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer2, ((384 >> 3) & 14) | ((384 >> 3) & 112));
                    int $changed$iv$iv = (384 << 3) & 112;
                    onClick = onClick3;
                    modifier2 = modifier7;
                    ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
                    CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv$iv);
                    Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
                    int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!($composer2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer2.startReusableNode();
                    if ($composer2.getInserting()) {
                        factory$iv$iv$iv = factory$iv$iv$iv2;
                        $composer2.useNode();
                    } else {
                        factory$iv$iv$iv = factory$iv$iv$iv2;
                        $composer2.createNode(factory$iv$iv$iv);
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer2);
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
                    int i8 = ($changed$iv$iv$iv >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                    int i9 = ((384 >> 6) & 112) | 6;
                    RowScope $this$VerticalCarouselComponent_u24lambda_u2413 = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart($composer2, -970631709, "C945@35903L140,952@36143L8,958@36320L539,950@36053L806:TopContainer.kt#u9475x");
                    String $this$asRequest_u24default$iv = HelperKt.customizedImageUrl("http://i0.hdslb.com/bfs/kfptfe/floor/a3331b996c68eca3a1e530bb9b9d3b269c06fea3.png");
                    ImageRequest imageRequest = new ImageRequest($this$asRequest_u24default$iv);
                    Unit unit = Unit.INSTANCE;
                    BiliImageKt.BiliImage(imageRequest.build(), SizeKt.size-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(16, scale)), null, null, null, null, null, null, null, $composer2, 0, 508);
                    Modifier weight$default = RowScope.-CC.weight$default($this$VerticalCarouselComponent_u24lambda_u2413, SizeKt.fillMaxHeight$default(Modifier.Companion, 0.0f, 1, (Object) null), 1.0f, false, 2, (Object) null);
                    Integer valueOf = Integer.valueOf(safeDisplayIndex);
                    ComposerKt.sourceInformationMarkerStart($composer2, 384340799, "CC(remember):TopContainer.kt#9igjgp");
                    invalid$iv3 = $composer2.changedInstance(spec);
                    Object it$iv9 = $composer2.rememberedValue();
                    if (invalid$iv3) {
                    }
                    Object value$iv8 = new Function1() { // from class: kntr.app.mall.product.details.page.ui.container.TopContainerKt$$ExternalSyntheticLambda23
                        public final Object invoke(Object obj) {
                            ContentTransform VerticalCarouselComponent$lambda$13$0$0;
                            VerticalCarouselComponent$lambda$13$0$0 = TopContainerKt.VerticalCarouselComponent$lambda$13$0$0(spec, (AnimatedContentTransitionScope) obj);
                            return VerticalCarouselComponent$lambda$13$0$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv8);
                    it$iv9 = value$iv8;
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    AnimatedContentKt.AnimatedContent(valueOf, weight$default, (Function1) it$iv9, (Alignment) null, "SalePointTicker", (Function1) null, ComposableLambdaKt.rememberComposableLambda(1751894369, true, new Function4() { // from class: kntr.app.mall.product.details.page.ui.container.TopContainerKt$$ExternalSyntheticLambda24
                        public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            Unit VerticalCarouselComponent$lambda$13$1;
                            VerticalCarouselComponent$lambda$13$1 = TopContainerKt.VerticalCarouselComponent$lambda$13$1(displayList, scale, (AnimatedContentScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
                            return VerticalCarouselComponent$lambda$13$1;
                        }
                    }, $composer2, 54), $composer2, 1597440, 40);
                    str = iconUrl;
                    if (str != null || str.length() == 0) {
                        $composer2.startReplaceGroup(-969581926);
                        ComposerKt.sourceInformation($composer2, "977@36913L153");
                        String $this$asRequest_u24default$iv2 = HelperKt.customizedImageUrl(iconUrl);
                        ImageRequest imageRequest2 = new ImageRequest($this$asRequest_u24default$iv2);
                        Unit unit2 = Unit.INSTANCE;
                        BiliImageKt.BiliImage(imageRequest2.build(), SizeKt.size-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(24, scale)), null, null, null, null, null, null, null, $composer2, 0, 508);
                        $composer2.endReplaceGroup();
                    } else {
                        $composer2.startReplaceGroup(-969384642);
                        ComposerKt.sourceInformation($composer2, "983@37141L25,985@37244L6,982@37096L237");
                        IconKt.Icon-ww6aTOc(BiliIconfont.INSTANCE.getMagnifier_search_line_500($composer2, 6), (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(24, scale)), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText1-0d7_KjU(), $composer2, Painter.$stable | 48, 0);
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
                    animDurationMs2 = animDurationMs5;
                }
                z = true;
                invalid$iv = z3 | z;
                it$iv = $composer2.rememberedValue();
                if (invalid$iv) {
                }
                animDurationMs4 = animDurationMs7;
                easing = easing4;
                Object value$iv62 = AnimatedContentKt.togetherWith(EnterExitTransitionKt.slideInVertically(AnimationSpecKt.tween$default(animDurationMs4, 0, new TopContainerKt$sam$androidx_compose_animation_core_Easing$0(easing4), 2, (Object) null), new Function1() { // from class: kntr.app.mall.product.details.page.ui.container.TopContainerKt$$ExternalSyntheticLambda20
                    public final Object invoke(Object obj) {
                        int VerticalCarouselComponent$lambda$11$0;
                        VerticalCarouselComponent$lambda$11$0 = TopContainerKt.VerticalCarouselComponent$lambda$11$0(((Integer) obj).intValue());
                        return Integer.valueOf(VerticalCarouselComponent$lambda$11$0);
                    }
                }).plus(EnterExitTransitionKt.fadeIn$default(AnimationSpecKt.tween$default(animDurationMs4, 0, new TopContainerKt$sam$androidx_compose_animation_core_Easing$0(easing4), 2, (Object) null), 0.0f, 2, (Object) null)), EnterExitTransitionKt.slideOutVertically(AnimationSpecKt.tween$default(animDurationMs4, 0, new TopContainerKt$sam$androidx_compose_animation_core_Easing$0(easing4), 2, (Object) null), new Function1() { // from class: kntr.app.mall.product.details.page.ui.container.TopContainerKt$$ExternalSyntheticLambda21
                    public final Object invoke(Object obj) {
                        int VerticalCarouselComponent$lambda$11$1;
                        VerticalCarouselComponent$lambda$11$1 = TopContainerKt.VerticalCarouselComponent$lambda$11$1(((Integer) obj).intValue());
                        return Integer.valueOf(VerticalCarouselComponent$lambda$11$1);
                    }
                }).plus(EnterExitTransitionKt.fadeOut$default(AnimationSpecKt.tween$default(animDurationMs4, 0, new TopContainerKt$sam$androidx_compose_animation_core_Easing$0(easing4), 2, (Object) null), 0.0f, 2, (Object) null)));
                $composer2.updateRememberedValue(value$iv62);
                it$iv = value$iv62;
                final ContentTransform spec2 = (ContentTransform) it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                Modifier fillMaxSize$default2 = SizeKt.fillMaxSize$default(modifier7, 0.0f, 1, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer2, -638449459, "CC(remember):TopContainer.kt#9igjgp");
                invalid$iv2 = $composer2.changedInstance(displayList) | $composer2.changed(safeSettledIndex) | (($dirty3 & 29360128) != 8388608);
                it$iv2 = $composer2.rememberedValue();
                if (invalid$iv2) {
                }
                animDurationMs5 = animDurationMs4;
                onClick3 = onClick5;
                Object value$iv72 = new Function0() { // from class: kntr.app.mall.product.details.page.ui.container.TopContainerKt$$ExternalSyntheticLambda22
                    public final Object invoke() {
                        Unit VerticalCarouselComponent$lambda$12$0;
                        VerticalCarouselComponent$lambda$12$0 = TopContainerKt.VerticalCarouselComponent$lambda$12$0(displayList, safeSettledIndex, onClick3);
                        return VerticalCarouselComponent$lambda$12$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv72);
                it$iv2 = value$iv72;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                Modifier modifier$iv$iv2 = ClickableKt.clickable-oSLSa3U$default(fillMaxSize$default2, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv2, 15, (Object) null);
                Alignment.Vertical verticalAlignment$iv2 = Alignment.Companion.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart($composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.getStart();
                MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer2, ((384 >> 3) & 14) | ((384 >> 3) & 112));
                int $changed$iv$iv2 = (384 << 3) & 112;
                onClick = onClick3;
                modifier2 = modifier7;
                ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
                CompositionLocalMap localMap$iv$iv2 = $composer2.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer2, modifier$iv$iv2);
                Function0 factory$iv$iv$iv22 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer2.getApplier() instanceof Applier)) {
                }
                $composer2.startReusableNode();
                if ($composer2.getInserting()) {
                }
                Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer2);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
                int i82 = ($changed$iv$iv$iv2 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                int i92 = ((384 >> 6) & 112) | 6;
                RowScope $this$VerticalCarouselComponent_u24lambda_u24132 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer2, -970631709, "C945@35903L140,952@36143L8,958@36320L539,950@36053L806:TopContainer.kt#u9475x");
                String $this$asRequest_u24default$iv3 = HelperKt.customizedImageUrl("http://i0.hdslb.com/bfs/kfptfe/floor/a3331b996c68eca3a1e530bb9b9d3b269c06fea3.png");
                ImageRequest imageRequest3 = new ImageRequest($this$asRequest_u24default$iv3);
                Unit unit3 = Unit.INSTANCE;
                BiliImageKt.BiliImage(imageRequest3.build(), SizeKt.size-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(16, scale)), null, null, null, null, null, null, null, $composer2, 0, 508);
                Modifier weight$default2 = RowScope.-CC.weight$default($this$VerticalCarouselComponent_u24lambda_u24132, SizeKt.fillMaxHeight$default(Modifier.Companion, 0.0f, 1, (Object) null), 1.0f, false, 2, (Object) null);
                Integer valueOf2 = Integer.valueOf(safeDisplayIndex);
                ComposerKt.sourceInformationMarkerStart($composer2, 384340799, "CC(remember):TopContainer.kt#9igjgp");
                invalid$iv3 = $composer2.changedInstance(spec2);
                Object it$iv92 = $composer2.rememberedValue();
                if (invalid$iv3) {
                }
                Object value$iv82 = new Function1() { // from class: kntr.app.mall.product.details.page.ui.container.TopContainerKt$$ExternalSyntheticLambda23
                    public final Object invoke(Object obj) {
                        ContentTransform VerticalCarouselComponent$lambda$13$0$0;
                        VerticalCarouselComponent$lambda$13$0$0 = TopContainerKt.VerticalCarouselComponent$lambda$13$0$0(spec2, (AnimatedContentTransitionScope) obj);
                        return VerticalCarouselComponent$lambda$13$0$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv82);
                it$iv92 = value$iv82;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                AnimatedContentKt.AnimatedContent(valueOf2, weight$default2, (Function1) it$iv92, (Alignment) null, "SalePointTicker", (Function1) null, ComposableLambdaKt.rememberComposableLambda(1751894369, true, new Function4() { // from class: kntr.app.mall.product.details.page.ui.container.TopContainerKt$$ExternalSyntheticLambda24
                    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        Unit VerticalCarouselComponent$lambda$13$1;
                        VerticalCarouselComponent$lambda$13$1 = TopContainerKt.VerticalCarouselComponent$lambda$13$1(displayList, scale, (AnimatedContentScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
                        return VerticalCarouselComponent$lambda$13$1;
                    }
                }, $composer2, 54), $composer2, 1597440, 40);
                str = iconUrl;
                if (str != null || str.length() == 0) {
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                if (ComposerKt.isTraceInProgress()) {
                }
                animDurationMs2 = animDurationMs5;
            }
            List<BasicInfoFloor.SalePoint> $this$filterNot$iv = list;
            Collection destination$iv$iv = new ArrayList();
            for (Object element$iv$iv : $this$filterNot$iv) {
                boolean z4 = z2;
                BasicInfoFloor.SalePoint it = (BasicInfoFloor.SalePoint) element$iv$iv;
                String tagText = it.getTagText();
                if (!(tagText == null || tagText.length() == 0)) {
                    destination$iv$iv.add(element$iv$iv);
                }
                z2 = z4;
            }
            Object value$iv9 = (List) destination$iv$iv;
            $composer3.updateRememberedValue(value$iv9);
            it$iv5 = value$iv9;
            displayList = (List) it$iv5;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            if (!displayList.isEmpty()) {
            }
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            modifier2 = modifier;
            animDurationMs2 = animDurationMs;
            easing = function1;
            onClick = function12;
            intervalMs2 = j;
        }
        ScopeUpdateScope endRestartGroup2 = $composer2.endRestartGroup();
        if (endRestartGroup2 != null) {
            final Modifier modifier8 = modifier2;
            final long j3 = intervalMs2;
            final int i10 = animDurationMs2;
            final Function1 function13 = easing;
            final Function1 function14 = onClick;
            endRestartGroup2.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.container.TopContainerKt$$ExternalSyntheticLambda25
                public final Object invoke(Object obj, Object obj2) {
                    Unit VerticalCarouselComponent$lambda$14;
                    VerticalCarouselComponent$lambda$14 = TopContainerKt.VerticalCarouselComponent$lambda$14(list, iconUrl, scale, modifier8, j3, i10, function13, function14, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return VerticalCarouselComponent$lambda$14;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int VerticalCarouselComponent$lambda$5(MutableIntState $settledIndex$delegate) {
        IntState $this$getValue$iv = (IntState) $settledIndex$delegate;
        return $this$getValue$iv.getIntValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int VerticalCarouselComponent$lambda$8(MutableIntState $displayIndex$delegate) {
        IntState $this$getValue$iv = (IntState) $displayIndex$delegate;
        return $this$getValue$iv.getIntValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int VerticalCarouselComponent$lambda$11$0(int fullHeight) {
        return fullHeight;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int VerticalCarouselComponent$lambda$11$1(int fullHeight) {
        return -fullHeight;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit VerticalCarouselComponent$lambda$12$0(List $displayList, int $safeSettledIndex, Function1 $onClick) {
        String text = ((BasicInfoFloor.SalePoint) $displayList.get($safeSettledIndex)).getTagText();
        $onClick.invoke(text);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ContentTransform VerticalCarouselComponent$lambda$13$0$0(ContentTransform $spec, AnimatedContentTransitionScope $this$AnimatedContent) {
        Intrinsics.checkNotNullParameter($this$AnimatedContent, "$this$AnimatedContent");
        return $spec;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit VerticalCarouselComponent$lambda$13$1(List $displayList, float $scale, AnimatedContentScope $this$AnimatedContent, int idx, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        Intrinsics.checkNotNullParameter($this$AnimatedContent, "$this$AnimatedContent");
        ComposerKt.sourceInformation($composer, "CN(idx)961@36423L426:TopContainer.kt#u9475x");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1751894369, $changed, -1, "kntr.app.mall.product.details.page.ui.container.VerticalCarouselComponent.<anonymous>.<anonymous> (TopContainer.kt:959)");
        }
        BasicInfoFloor.SalePoint current = (BasicInfoFloor.SalePoint) $displayList.get(idx);
        String text = current.getTagText();
        Modifier modifier$iv = SizeKt.fillMaxHeight$default(Modifier.Companion, 0.0f, 1, (Object) null);
        Alignment contentAlignment$iv = Alignment.Companion.getCenterStart();
        ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
        MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
        int $changed$iv$iv = (54 << 3) & 112;
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
        ComposerKt.sourceInformationMarkerStart($composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
        BoxScope boxScope = BoxScopeInstance.INSTANCE;
        int i2 = ((54 >> 6) & 112) | 6;
        ComposerKt.sourceInformationMarkerStart($composer, 2087913805, "C970@36737L6,971@36789L9,967@36616L219:TopContainer.kt#u9475x");
        TextKt.Text-Nvy7gAk(text == null ? "" : text, (Modifier) null, BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText2-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, ProvideUiScaleKt.scaled(BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT12(), $scale), $composer, 0, 24576, 114682);
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        $composer.endNode();
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }
}