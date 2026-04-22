package kntr.app.mall.product.details.page.ui.container;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.ScrollableState;
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
import androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt;
import androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemScope;
import androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridScope;
import androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState;
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells;
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridItemSpan;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.IconKt;
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
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import com.bilibili.compose.iconfont.BiliIconfont;
import com.bilibili.compose.theme.BiliTheme;
import java.util.List;
import kntr.app.mall.product.details.page.api.model.FeedsModel;
import kntr.app.mall.product.details.page.api.model.GlobalSkinConfigDTO;
import kntr.app.mall.product.details.page.api.model.MallRecommendItem;
import kntr.app.mall.product.details.page.api.model.ProductDetailsResponse;
import kntr.app.mall.product.details.page.api.model.RecommendVO;
import kntr.app.mall.product.details.page.ui.components.ComponentBuilderKt;
import kntr.app.mall.product.details.page.ui.components.FeedBlastHeaderKt;
import kntr.app.mall.product.details.page.ui.components.FeedBlastItemKt;
import kntr.app.mall.product.details.page.ui.scale.ProvideUiScaleKt;
import kntr.app.mall.product.details.page.ui.scale.UiScaleModel;
import kntr.app.mall.product.details.page.vm.ContentModule;
import kntr.app.mall.product.details.page.vm.FloorType;
import kntr.app.mall.product.details.page.vm.ModuleGroup;
import kntr.app.mall.product.details.page.vm.ModuleViewModel;
import kntr.app.mall.product.details.page.vm.PageViewModel;
import kntr.app.mall.product.details.page.vm.PageViewModelWrapper;
import kntr.app.mall.product.details.page.vm.VideoPlayerViewModelWrapper;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.imageloader.BiliImageKt;
import kntr.base.imageloader.ImageRequest;
import kntr.common.compose.pulltorefresh.PullToRefreshIndicatorKt;
import kntr.common.compose.pulltorefresh.PullToRefreshKt;
import kntr.common.compose.pulltorefresh.PullToRefreshState;
import kntr.common.compose.pulltorefresh.PullToRefreshStateKt;
import kntr.common.trio.list.DefaultListModifierKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

/* compiled from: ScrollContainer.kt */
@Metadata(d1 = {"\u0000z\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u001a~\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0011\u0010\u0012\u001a\r\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u00132\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0001¢\u0006\u0004\b\u0017\u0010\u0018\u001a;\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"H\u0003¢\u0006\u0002\u0010#¨\u0006$²\u0006\u0010\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00010\rX\u008a\u0084\u0002²\u0006\n\u0010&\u001a\u00020'X\u008a\u008e\u0002²\u0006\n\u0010(\u001a\u00020\u000bX\u008a\u008e\u0002²\u0006\u0010\u0010)\u001a\b\u0012\u0004\u0012\u00020*0\u0015X\u008a\u0084\u0002²\u0006\f\u0010+\u001a\u0004\u0018\u00010,X\u008a\u0084\u0002²\u0006\n\u0010\u001f\u001a\u00020 X\u008a\u0084\u0002"}, d2 = {"ScrollContainer", "", "listState", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;", "getViewModel", "Lkotlin/Function1;", "Lkntr/app/mall/product/details/page/vm/FloorType;", "Lkntr/app/mall/product/details/page/vm/ModuleViewModel;", "bottomPadding", "Landroidx/compose/ui/unit/Dp;", "isRefreshing", "", "onRefresh", "Lkotlin/Function0;", "pageViewModelWrapper", "Lkntr/app/mall/product/details/page/vm/PageViewModelWrapper;", "videoViewModelWrapper", "Lkntr/app/mall/product/details/page/vm/VideoPlayerViewModelWrapper;", "headerBannerSection", "Landroidx/compose/runtime/Composable;", "dynamicModules", "", "Lkntr/app/mall/product/details/page/vm/ContentModule;", "ScrollContainer-dsL6K2w", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;Lkotlin/jvm/functions/Function1;FZLkotlin/jvm/functions/Function0;Lkntr/app/mall/product/details/page/vm/PageViewModelWrapper;Lkntr/app/mall/product/details/page/vm/VideoPlayerViewModelWrapper;Lkotlin/jvm/functions/Function2;Ljava/util/List;Landroidx/compose/runtime/Composer;II)V", "CustomRefreshIndicator", "state", "Lkntr/common/compose/pulltorefresh/PullToRefreshState;", "refreshIcon", "", "refreshIconGif", "scaleModel", "Lkntr/app/mall/product/details/page/ui/scale/UiScaleModel;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lkntr/common/compose/pulltorefresh/PullToRefreshState;Ljava/lang/String;Ljava/lang/String;Lkntr/app/mall/product/details/page/ui/scale/UiScaleModel;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "product-details-page_debug", "currentOnRefresh", "feedBlastPageNum", "", "feedBlastIsLoading", "feedBlast", "Lkntr/app/mall/product/details/page/api/model/MallRecommendItem;", "lastFeedBlastData", "Lkntr/app/mall/product/details/page/api/model/FeedsModel;"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ScrollContainerKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CustomRefreshIndicator$lambda$3(PullToRefreshState pullToRefreshState, String str, String str2, UiScaleModel uiScaleModel, Modifier modifier, int i, int i2, Composer composer, int i3) {
        CustomRefreshIndicator(pullToRefreshState, str, str2, uiScaleModel, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ScrollContainer_dsL6K2w$lambda$15(LazyStaggeredGridState lazyStaggeredGridState, Function1 function1, float f, boolean z, Function0 function0, PageViewModelWrapper pageViewModelWrapper, VideoPlayerViewModelWrapper videoPlayerViewModelWrapper, Function2 function2, List list, int i, int i2, Composer composer, int i3) {
        m580ScrollContainerdsL6K2w(lazyStaggeredGridState, function1, f, z, function0, pageViewModelWrapper, videoPlayerViewModelWrapper, function2, list, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:120:0x0267  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x026a  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x02c9  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x02cb  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x031d  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x031f  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0330  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x033e A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:148:0x038a  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0398  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x03c1  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x03c3  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x03e7  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x04b4  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x04c0  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x04c4  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x05bb  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0924  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0950  */
    /* renamed from: ScrollContainer-dsL6K2w  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m580ScrollContainerdsL6K2w(final LazyStaggeredGridState listState, final Function1<? super FloorType, ? extends ModuleViewModel> function1, final float f, final boolean isRefreshing, final Function0<Unit> function0, final PageViewModelWrapper pageViewModelWrapper, final VideoPlayerViewModelWrapper videoViewModelWrapper, final Function2<? super Composer, ? super Integer, Unit> function2, List<? extends ContentModule> list, Composer $composer, final int $changed, final int i) {
        Composer $composer2;
        List dynamicModules;
        Object it$iv;
        String refreshIconGif;
        boolean useCustomIcons;
        boolean invalid$iv;
        boolean invalid$iv2;
        State currentOnRefresh$delegate;
        State selectedTabIndex;
        boolean invalid$iv3;
        boolean invalid$iv4;
        Object value$iv;
        CoroutineScope scope;
        State lastFeedBlastData$delegate;
        List groupedContent;
        PageViewModel pageViewModel;
        int $dirty;
        String str;
        PullToRefreshState pullToRefreshState;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        ProductDetailsResponse.ProductDetailsData data;
        Intrinsics.checkNotNullParameter(listState, "listState");
        Intrinsics.checkNotNullParameter(function1, "getViewModel");
        Intrinsics.checkNotNullParameter(function0, "onRefresh");
        Intrinsics.checkNotNullParameter(pageViewModelWrapper, "pageViewModelWrapper");
        Intrinsics.checkNotNullParameter(videoViewModelWrapper, "videoViewModelWrapper");
        Intrinsics.checkNotNullParameter(function2, "headerBannerSection");
        Composer $composer3 = $composer.startRestartGroup(-1012612675);
        ComposerKt.sourceInformation($composer3, "C(ScrollContainer)N(listState,getViewModel,bottomPadding:c#ui.unit.Dp,isRefreshing,onRefresh,pageViewModelWrapper,videoViewModelWrapper,headerBannerSection,dynamicModules)75@3641L24,77@3749L31,78@3809L33,79@3873L34,80@3958L16,81@4036L16,82@4106L16,88@4246L16,101@4725L139,106@4918L186,106@4870L234,113@5139L125,113@5110L154,119@5324L16,123@5458L66,123@5427L97,128@5579L1080,128@5553L1106,153@6665L5429:ScrollContainer.kt#u9475x");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer3.changed(listState) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty2 |= $composer3.changedInstance(function1) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty2 |= $composer3.changed(f) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty2 |= $composer3.changed(isRefreshing) ? 2048 : 1024;
        }
        if (($changed & 24576) == 0) {
            $dirty2 |= $composer3.changedInstance(function0) ? 16384 : 8192;
        }
        if ((196608 & $changed) == 0) {
            $dirty2 |= $composer3.changedInstance(pageViewModelWrapper) ? 131072 : 65536;
        }
        if ((12582912 & $changed) == 0) {
            $dirty2 |= $composer3.changedInstance(function2) ? 8388608 : 4194304;
        }
        int i2 = i & 256;
        if (i2 != 0) {
            $dirty2 |= 100663296;
        } else if (($changed & 100663296) == 0) {
            $dirty2 |= $composer3.changedInstance(list) ? 67108864 : 33554432;
        }
        if ($composer3.shouldExecute(($dirty2 & 37823635) != 37823634, $dirty2 & 1)) {
            List dynamicModules2 = i2 != 0 ? CollectionsKt.emptyList() : list;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1012612675, $dirty2, -1, "kntr.app.mall.product.details.page.ui.container.ScrollContainer (ScrollContainer.kt:74)");
            }
            ComposerKt.sourceInformationMarkerStart($composer3, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart($composer3, 683736516, "CC(remember):Effects.kt#9igjgp");
            Object value$iv$iv = $composer3.rememberedValue();
            if (value$iv$iv == Composer.Companion.getEmpty()) {
                value$iv$iv = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer3);
                $composer3.updateRememberedValue(value$iv$iv);
            }
            CoroutineScope scope2 = (CoroutineScope) value$iv$iv;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            PageViewModel pageViewModel2 = pageViewModelWrapper.getViewModel();
            State currentOnRefresh$delegate2 = SnapshotStateKt.rememberUpdatedState(function0, $composer3, ($dirty2 >> 12) & 14);
            ComposerKt.sourceInformationMarkerStart($composer3, 1836814302, "CC(remember):ScrollContainer.kt#9igjgp");
            int $dirty3 = $dirty2;
            Object it$iv2 = $composer3.rememberedValue();
            if (it$iv2 == Composer.Companion.getEmpty()) {
                Object mutableIntStateOf = SnapshotIntStateKt.mutableIntStateOf(1);
                $composer3.updateRememberedValue(mutableIntStateOf);
                it$iv = mutableIntStateOf;
            } else {
                it$iv = it$iv2;
            }
            MutableIntState feedBlastPageNum$delegate = (MutableIntState) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerStart($composer3, 1836816351, "CC(remember):ScrollContainer.kt#9igjgp");
            Object value$iv2 = $composer3.rememberedValue();
            if (value$iv2 == Composer.Companion.getEmpty()) {
                value$iv2 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer3.updateRememberedValue(value$iv2);
            }
            MutableState feedBlastIsLoading$delegate = (MutableState) value$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            final State feedBlast$delegate = SnapshotStateKt.collectAsState(pageViewModel2.getFeedBlastState$product_details_page_debug(), (CoroutineContext) null, $composer3, 0, 1);
            State lastFeedBlastData$delegate2 = SnapshotStateKt.collectAsState(pageViewModel2.getLastFeedBlastData$product_details_page_debug(), (CoroutineContext) null, $composer3, 0, 1);
            final State scaleModel$delegate = SnapshotStateKt.collectAsState(pageViewModel2.getUiScaleModelFlow$product_details_page_debug(), (CoroutineContext) null, $composer3, 0, 1);
            ProductDetailsResponse productDetailsResponse = (ProductDetailsResponse) SnapshotStateKt.collectAsState(pageViewModel2.getProductDetailsResponse(), (CoroutineContext) null, $composer3, 0, 1).getValue();
            GlobalSkinConfigDTO globalSkin = (productDetailsResponse == null || (data = productDetailsResponse.getData()) == null) ? null : data.getGlobalSkin();
            String refreshIcon = globalSkin != null ? globalSkin.getRefreshIcon() : null;
            String refreshIconGif2 = globalSkin != null ? globalSkin.getRefreshIconGif() : null;
            String str2 = refreshIcon;
            if (str2 == null || str2.length() == 0) {
                refreshIconGif = refreshIconGif2;
            } else {
                refreshIconGif = refreshIconGif2;
                String str3 = refreshIconGif;
                if (!(str3 == null || str3.length() == 0)) {
                    useCustomIcons = true;
                    float refreshDistance = ProvideUiScaleKt.dpScaled(!useCustomIcons ? 109 : 60, ScrollContainer_dsL6K2w$lambda$9(scaleModel$delegate).getScale());
                    final String refreshIcon2 = refreshIcon;
                    final String refreshIconGif3 = refreshIconGif;
                    PullToRefreshState pullToRefreshState2 = PullToRefreshStateKt.m1873rememberPullToRefreshStatedjqsMU(0.0f, refreshDistance, refreshDistance, false, $composer3, 0, 9);
                    Boolean valueOf = Boolean.valueOf(pullToRefreshState2.isRefreshing());
                    ComposerKt.sourceInformationMarkerStart($composer3, 1836849943, "CC(remember):ScrollContainer.kt#9igjgp");
                    invalid$iv = $composer3.changed(pullToRefreshState2) | (($dirty3 & 7168) != 2048) | $composer3.changed(currentOnRefresh$delegate2);
                    Object it$iv3 = $composer3.rememberedValue();
                    if (!invalid$iv && it$iv3 != Composer.Companion.getEmpty()) {
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        EffectsKt.LaunchedEffect(valueOf, (Function2) it$iv3, $composer3, 0);
                        Boolean valueOf2 = Boolean.valueOf(isRefreshing);
                        ComposerKt.sourceInformationMarkerStart($composer3, 1836856954, "CC(remember):ScrollContainer.kt#9igjgp");
                        invalid$iv2 = (($dirty3 & 7168) != 2048) | $composer3.changed(pullToRefreshState2);
                        Object it$iv4 = $composer3.rememberedValue();
                        if (!invalid$iv2 && it$iv4 != Composer.Companion.getEmpty()) {
                            currentOnRefresh$delegate = currentOnRefresh$delegate2;
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            EffectsKt.LaunchedEffect(valueOf2, (Function2) it$iv4, $composer3, ($dirty3 >> 9) & 14);
                            selectedTabIndex = SnapshotStateKt.collectAsState(pageViewModel2.getSelectedTabIndex(), (CoroutineContext) null, $composer3, 0, 1);
                            List groupedContent2 = pageViewModel2.groupModules$product_details_page_debug(dynamicModules2);
                            ComposerKt.sourceInformationMarkerStart($composer3, 1836867103, "CC(remember):ScrollContainer.kt#9igjgp");
                            invalid$iv3 = $composer3.changedInstance(pageViewModel2) | $composer3.changedInstance(groupedContent2);
                            Object it$iv5 = $composer3.rememberedValue();
                            if (invalid$iv3) {
                                dynamicModules = dynamicModules2;
                                if (it$iv5 != Composer.Companion.getEmpty()) {
                                    ComposerKt.sourceInformationMarkerEnd($composer3);
                                    EffectsKt.LaunchedEffect(groupedContent2, (Function2) it$iv5, $composer3, 0);
                                    ComposerKt.sourceInformationMarkerStart($composer3, 1836871989, "CC(remember):ScrollContainer.kt#9igjgp");
                                    invalid$iv4 = (($dirty3 & 14) == 4) | $composer3.changed(lastFeedBlastData$delegate2) | $composer3.changedInstance(scope2) | $composer3.changedInstance(pageViewModel2);
                                    value$iv = $composer3.rememberedValue();
                                    if (!invalid$iv4 || value$iv == Composer.Companion.getEmpty()) {
                                        scope = scope2;
                                        lastFeedBlastData$delegate = lastFeedBlastData$delegate2;
                                        groupedContent = groupedContent2;
                                        pageViewModel = pageViewModel2;
                                        $dirty = $dirty3;
                                        str = "CC(remember):ScrollContainer.kt#9igjgp";
                                        pullToRefreshState = pullToRefreshState2;
                                        value$iv = new ScrollContainerKt$ScrollContainer$4$1(listState, scope, lastFeedBlastData$delegate, feedBlastIsLoading$delegate, pageViewModel, feedBlastPageNum$delegate, null);
                                        $composer3.updateRememberedValue(value$iv);
                                    } else {
                                        scope = scope2;
                                        lastFeedBlastData$delegate = lastFeedBlastData$delegate2;
                                        groupedContent = groupedContent2;
                                        pageViewModel = pageViewModel2;
                                        $dirty = $dirty3;
                                        str = "CC(remember):ScrollContainer.kt#9igjgp";
                                        pullToRefreshState = pullToRefreshState2;
                                    }
                                    ComposerKt.sourceInformationMarkerEnd($composer3);
                                    EffectsKt.LaunchedEffect(listState, (Function2) value$iv, $composer3, $dirty & 14);
                                    Modifier modifier$iv = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
                                    ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                                    Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
                                    MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                                    int $changed$iv$iv = (6 << 3) & 112;
                                    ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                                    int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
                                    CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
                                    Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
                                    Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
                                    int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                                    String str4 = str;
                                    ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                                    if (!($composer3.getApplier() instanceof Applier)) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    $composer3.startReusableNode();
                                    if ($composer3.getInserting()) {
                                        $composer3.createNode(factory$iv$iv$iv3);
                                    } else {
                                        $composer3.useNode();
                                    }
                                    Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer3);
                                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
                                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
                                    int i3 = ($changed$iv$iv$iv >> 6) & 14;
                                    ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                                    int i4 = ((6 >> 6) & 112) | 6;
                                    BoxScope $this$ScrollContainer_dsL6K2w_u24lambda_u2414 = BoxScopeInstance.INSTANCE;
                                    ComposerKt.sourceInformationMarkerStart($composer3, 237376814, "C156@6793L262,164@7067L3560,154@6714L3913:ScrollContainer.kt#u9475x");
                                    final List list2 = groupedContent;
                                    final State state = lastFeedBlastData$delegate;
                                    final PageViewModel pageViewModel3 = pageViewModel;
                                    PullToRefreshKt.PullToRefresh(pullToRefreshState, null, null, ComposableLambdaKt.rememberComposableLambda(-1188560652, true, new Function3() { // from class: kntr.app.mall.product.details.page.ui.container.ScrollContainerKt$$ExternalSyntheticLambda6
                                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                                            Unit ScrollContainer_dsL6K2w$lambda$14$0;
                                            ScrollContainer_dsL6K2w$lambda$14$0 = ScrollContainerKt.ScrollContainer_dsL6K2w$lambda$14$0(refreshIcon2, refreshIconGif3, scaleModel$delegate, (PullToRefreshState) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                            return ScrollContainer_dsL6K2w$lambda$14$0;
                                        }
                                    }, $composer3, 54), false, ComposableLambdaKt.rememberComposableLambda(-2048010676, true, new Function2() { // from class: kntr.app.mall.product.details.page.ui.container.ScrollContainerKt$$ExternalSyntheticLambda7
                                        public final Object invoke(Object obj, Object obj2) {
                                            Unit ScrollContainer_dsL6K2w$lambda$14$1;
                                            ScrollContainer_dsL6K2w$lambda$14$1 = ScrollContainerKt.ScrollContainer_dsL6K2w$lambda$14$1(f, listState, function2, list2, function1, pageViewModelWrapper, feedBlast$delegate, state, scaleModel$delegate, pageViewModel3, (Composer) obj, ((Integer) obj2).intValue());
                                            return ScrollContainer_dsL6K2w$lambda$14$1;
                                        }
                                    }, $composer3, 54), $composer3, 199680, 22);
                                    if (((Number) selectedTabIndex.getValue()).intValue() > 0) {
                                        $composer3.startReplaceGroup(241177568);
                                        ComposerKt.sourceInformation($composer3, "258@11128L6,261@11286L6,262@11333L158,250@10683L1395");
                                        Modifier modifier = BackgroundKt.background-bw27NRU$default(ClipKt.clip(BorderKt.border-xT4_qwU(SizeKt.size-3ABfNKs(OffsetKt.offset-VpY3zN4($this$ScrollContainer_dsL6K2w_u24lambda_u2414.align(Modifier.Companion, Alignment.Companion.getBottomEnd()), ProvideUiScaleKt.dpScaled(-16, ScrollContainer_dsL6K2w$lambda$9(scaleModel$delegate).getScale()), Dp.constructor-impl(ProvideUiScaleKt.dpScaled(-50, ScrollContainer_dsL6K2w$lambda$9(scaleModel$delegate).getScale()) - f)), ProvideUiScaleKt.dpScaled(50, ScrollContainer_dsL6K2w$lambda$9(scaleModel$delegate).getScale())), ProvideUiScaleKt.dpScaled(0.5d, ScrollContainer_dsL6K2w$lambda$9(scaleModel$delegate).getScale()), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getLine_light-0d7_KjU(), RoundedCornerShapeKt.getCircleShape()), RoundedCornerShapeKt.getCircleShape()), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getBg1-0d7_KjU(), (Shape) null, 2, (Object) null);
                                        ComposerKt.sourceInformationMarkerStart($composer3, 561989237, str4);
                                        final CoroutineScope scope3 = scope;
                                        boolean invalid$iv5 = $composer3.changedInstance(scope3) | (($dirty & 14) == 4);
                                        Object it$iv6 = $composer3.rememberedValue();
                                        if (invalid$iv5 || it$iv6 == Composer.Companion.getEmpty()) {
                                            Object value$iv3 = new Function0() { // from class: kntr.app.mall.product.details.page.ui.container.ScrollContainerKt$$ExternalSyntheticLambda8
                                                public final Object invoke() {
                                                    Unit ScrollContainer_dsL6K2w$lambda$14$2$0;
                                                    ScrollContainer_dsL6K2w$lambda$14$2$0 = ScrollContainerKt.ScrollContainer_dsL6K2w$lambda$14$2$0(scope3, listState);
                                                    return ScrollContainer_dsL6K2w$lambda$14$2$0;
                                                }
                                            };
                                            $composer3.updateRememberedValue(value$iv3);
                                            it$iv6 = value$iv3;
                                        }
                                        ComposerKt.sourceInformationMarkerEnd($composer3);
                                        Modifier modifier$iv2 = ClickableKt.clickable-oSLSa3U$default(modifier, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv6, 15, (Object) null);
                                        Alignment contentAlignment$iv2 = Alignment.Companion.getCenter();
                                        ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                                        MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
                                        int $changed$iv$iv2 = (48 << 3) & 112;
                                        ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                                        int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
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
                                            factory$iv$iv$iv = factory$iv$iv$iv4;
                                            $composer3.createNode(factory$iv$iv$iv);
                                        } else {
                                            factory$iv$iv$iv = factory$iv$iv$iv4;
                                            $composer3.useNode();
                                        }
                                        Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer3);
                                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                        Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                                        Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
                                        int i5 = ($changed$iv$iv$iv2 >> 6) & 14;
                                        ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                                        BoxScope boxScope = BoxScopeInstance.INSTANCE;
                                        int i6 = ((48 >> 6) & 112) | 6;
                                        ComposerKt.sourceInformationMarkerStart($composer3, 1749825831, "C269@11578L486:ScrollContainer.kt#u9475x");
                                        Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getCenterHorizontally();
                                        ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                                        Modifier modifier$iv3 = Modifier.Companion;
                                        Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                                        MeasurePolicy measurePolicy$iv3 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((384 >> 3) & 14) | ((384 >> 3) & 112));
                                        int $changed$iv$iv3 = (384 << 3) & 112;
                                        ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                                        int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
                                        CompositionLocalMap localMap$iv$iv3 = $composer3.getCurrentCompositionLocalMap();
                                        Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer3, modifier$iv3);
                                        Function0 factory$iv$iv$iv5 = ComposeUiNode.Companion.getConstructor();
                                        int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
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
                                        Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer3);
                                        $composer2 = $composer3;
                                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
                                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                        Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                                        Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
                                        int i7 = ($changed$iv$iv$iv3 >> 6) & 14;
                                        ComposerKt.sourceInformationMarkerStart($composer3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                                        ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
                                        int i8 = ((384 >> 6) & 112) | 6;
                                        ComposerKt.sourceInformationMarkerStart($composer3, 1419313767, "C273@11751L24,275@11869L6,272@11698L348:ScrollContainer.kt#u9475x");
                                        IconKt.Icon-ww6aTOc(BiliIconfont.INSTANCE.getArrow_to_top_up_line_500($composer3, 6), (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(20, ScrollContainer_dsL6K2w$lambda$9(scaleModel$delegate).getScale())), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText1-0d7_KjU(), $composer3, Painter.$stable | 48, 0);
                                        ComposerKt.sourceInformationMarkerEnd($composer3);
                                        ComposerKt.sourceInformationMarkerEnd($composer3);
                                        $composer3.endNode();
                                        ComposerKt.sourceInformationMarkerEnd($composer3);
                                        ComposerKt.sourceInformationMarkerEnd($composer3);
                                        ComposerKt.sourceInformationMarkerEnd($composer3);
                                        ComposerKt.sourceInformationMarkerEnd($composer3);
                                        ComposerKt.sourceInformationMarkerEnd($composer3);
                                        $composer3.endNode();
                                        ComposerKt.sourceInformationMarkerEnd($composer3);
                                        ComposerKt.sourceInformationMarkerEnd($composer3);
                                        ComposerKt.sourceInformationMarkerEnd($composer3);
                                    } else {
                                        $composer2 = $composer3;
                                        $composer3.startReplaceGroup(230548939);
                                    }
                                    $composer3.endReplaceGroup();
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
                            } else {
                                dynamicModules = dynamicModules2;
                            }
                            Object value$iv4 = (Function2) new ScrollContainerKt$ScrollContainer$3$1(pageViewModel2, groupedContent2, null);
                            $composer3.updateRememberedValue(value$iv4);
                            it$iv5 = value$iv4;
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            EffectsKt.LaunchedEffect(groupedContent2, (Function2) it$iv5, $composer3, 0);
                            ComposerKt.sourceInformationMarkerStart($composer3, 1836871989, "CC(remember):ScrollContainer.kt#9igjgp");
                            invalid$iv4 = (($dirty3 & 14) == 4) | $composer3.changed(lastFeedBlastData$delegate2) | $composer3.changedInstance(scope2) | $composer3.changedInstance(pageViewModel2);
                            value$iv = $composer3.rememberedValue();
                            if (invalid$iv4) {
                            }
                            scope = scope2;
                            lastFeedBlastData$delegate = lastFeedBlastData$delegate2;
                            groupedContent = groupedContent2;
                            pageViewModel = pageViewModel2;
                            $dirty = $dirty3;
                            str = "CC(remember):ScrollContainer.kt#9igjgp";
                            pullToRefreshState = pullToRefreshState2;
                            value$iv = new ScrollContainerKt$ScrollContainer$4$1(listState, scope, lastFeedBlastData$delegate, feedBlastIsLoading$delegate, pageViewModel, feedBlastPageNum$delegate, null);
                            $composer3.updateRememberedValue(value$iv);
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            EffectsKt.LaunchedEffect(listState, (Function2) value$iv, $composer3, $dirty & 14);
                            Modifier modifier$iv4 = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
                            ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                            Alignment contentAlignment$iv3 = Alignment.Companion.getTopStart();
                            MeasurePolicy measurePolicy$iv4 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv3, false);
                            int $changed$iv$iv4 = (6 << 3) & 112;
                            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                            int compositeKeyHash$iv$iv4 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
                            CompositionLocalMap localMap$iv$iv4 = $composer3.getCurrentCompositionLocalMap();
                            Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer3, modifier$iv4);
                            Function0 factory$iv$iv$iv32 = ComposeUiNode.Companion.getConstructor();
                            int $changed$iv$iv$iv4 = (($changed$iv$iv4 << 6) & 896) | 6;
                            String str42 = str;
                            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                            if (!($composer3.getApplier() instanceof Applier)) {
                            }
                            $composer3.startReusableNode();
                            if ($composer3.getInserting()) {
                            }
                            Composer $this$Layout_u24lambda_u240$iv$iv4 = Updater.constructor-impl($composer3);
                            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, measurePolicy$iv4, ComposeUiNode.Companion.getSetMeasurePolicy());
                            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, localMap$iv$iv4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv4, Integer.valueOf(compositeKeyHash$iv$iv4), ComposeUiNode.Companion.getSetCompositeKeyHash());
                            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv4, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, materialized$iv$iv4, ComposeUiNode.Companion.getSetModifier());
                            int i32 = ($changed$iv$iv$iv4 >> 6) & 14;
                            ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                            int i42 = ((6 >> 6) & 112) | 6;
                            BoxScope $this$ScrollContainer_dsL6K2w_u24lambda_u24142 = BoxScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart($composer3, 237376814, "C156@6793L262,164@7067L3560,154@6714L3913:ScrollContainer.kt#u9475x");
                            final List list22 = groupedContent;
                            final State state2 = lastFeedBlastData$delegate;
                            final PageViewModel pageViewModel32 = pageViewModel;
                            PullToRefreshKt.PullToRefresh(pullToRefreshState, null, null, ComposableLambdaKt.rememberComposableLambda(-1188560652, true, new Function3() { // from class: kntr.app.mall.product.details.page.ui.container.ScrollContainerKt$$ExternalSyntheticLambda6
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    Unit ScrollContainer_dsL6K2w$lambda$14$0;
                                    ScrollContainer_dsL6K2w$lambda$14$0 = ScrollContainerKt.ScrollContainer_dsL6K2w$lambda$14$0(refreshIcon2, refreshIconGif3, scaleModel$delegate, (PullToRefreshState) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                    return ScrollContainer_dsL6K2w$lambda$14$0;
                                }
                            }, $composer3, 54), false, ComposableLambdaKt.rememberComposableLambda(-2048010676, true, new Function2() { // from class: kntr.app.mall.product.details.page.ui.container.ScrollContainerKt$$ExternalSyntheticLambda7
                                public final Object invoke(Object obj, Object obj2) {
                                    Unit ScrollContainer_dsL6K2w$lambda$14$1;
                                    ScrollContainer_dsL6K2w$lambda$14$1 = ScrollContainerKt.ScrollContainer_dsL6K2w$lambda$14$1(f, listState, function2, list22, function1, pageViewModelWrapper, feedBlast$delegate, state2, scaleModel$delegate, pageViewModel32, (Composer) obj, ((Integer) obj2).intValue());
                                    return ScrollContainer_dsL6K2w$lambda$14$1;
                                }
                            }, $composer3, 54), $composer3, 199680, 22);
                            if (((Number) selectedTabIndex.getValue()).intValue() > 0) {
                            }
                            $composer3.endReplaceGroup();
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            $composer3.endNode();
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                        }
                        currentOnRefresh$delegate = currentOnRefresh$delegate2;
                        Object value$iv5 = (Function2) new ScrollContainerKt$ScrollContainer$2$1(isRefreshing, pullToRefreshState2, null);
                        $composer3.updateRememberedValue(value$iv5);
                        it$iv4 = value$iv5;
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        EffectsKt.LaunchedEffect(valueOf2, (Function2) it$iv4, $composer3, ($dirty3 >> 9) & 14);
                        selectedTabIndex = SnapshotStateKt.collectAsState(pageViewModel2.getSelectedTabIndex(), (CoroutineContext) null, $composer3, 0, 1);
                        List groupedContent22 = pageViewModel2.groupModules$product_details_page_debug(dynamicModules2);
                        ComposerKt.sourceInformationMarkerStart($composer3, 1836867103, "CC(remember):ScrollContainer.kt#9igjgp");
                        invalid$iv3 = $composer3.changedInstance(pageViewModel2) | $composer3.changedInstance(groupedContent22);
                        Object it$iv52 = $composer3.rememberedValue();
                        if (invalid$iv3) {
                        }
                        Object value$iv42 = (Function2) new ScrollContainerKt$ScrollContainer$3$1(pageViewModel2, groupedContent22, null);
                        $composer3.updateRememberedValue(value$iv42);
                        it$iv52 = value$iv42;
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        EffectsKt.LaunchedEffect(groupedContent22, (Function2) it$iv52, $composer3, 0);
                        ComposerKt.sourceInformationMarkerStart($composer3, 1836871989, "CC(remember):ScrollContainer.kt#9igjgp");
                        invalid$iv4 = (($dirty3 & 14) == 4) | $composer3.changed(lastFeedBlastData$delegate2) | $composer3.changedInstance(scope2) | $composer3.changedInstance(pageViewModel2);
                        value$iv = $composer3.rememberedValue();
                        if (invalid$iv4) {
                        }
                        scope = scope2;
                        lastFeedBlastData$delegate = lastFeedBlastData$delegate2;
                        groupedContent = groupedContent22;
                        pageViewModel = pageViewModel2;
                        $dirty = $dirty3;
                        str = "CC(remember):ScrollContainer.kt#9igjgp";
                        pullToRefreshState = pullToRefreshState2;
                        value$iv = new ScrollContainerKt$ScrollContainer$4$1(listState, scope, lastFeedBlastData$delegate, feedBlastIsLoading$delegate, pageViewModel, feedBlastPageNum$delegate, null);
                        $composer3.updateRememberedValue(value$iv);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        EffectsKt.LaunchedEffect(listState, (Function2) value$iv, $composer3, $dirty & 14);
                        Modifier modifier$iv42 = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
                        ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                        Alignment contentAlignment$iv32 = Alignment.Companion.getTopStart();
                        MeasurePolicy measurePolicy$iv42 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv32, false);
                        int $changed$iv$iv42 = (6 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv42 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
                        CompositionLocalMap localMap$iv$iv42 = $composer3.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv42 = ComposedModifierKt.materializeModifier($composer3, modifier$iv42);
                        Function0 factory$iv$iv$iv322 = ComposeUiNode.Companion.getConstructor();
                        int $changed$iv$iv$iv42 = (($changed$iv$iv42 << 6) & 896) | 6;
                        String str422 = str;
                        ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                        if (!($composer3.getApplier() instanceof Applier)) {
                        }
                        $composer3.startReusableNode();
                        if ($composer3.getInserting()) {
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv42 = Updater.constructor-impl($composer3);
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv42, measurePolicy$iv42, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv42, localMap$iv$iv42, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Updater.init-impl($this$Layout_u24lambda_u240$iv$iv42, Integer.valueOf(compositeKeyHash$iv$iv42), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv42, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv42, materialized$iv$iv42, ComposeUiNode.Companion.getSetModifier());
                        int i322 = ($changed$iv$iv$iv42 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                        int i422 = ((6 >> 6) & 112) | 6;
                        BoxScope $this$ScrollContainer_dsL6K2w_u24lambda_u241422 = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart($composer3, 237376814, "C156@6793L262,164@7067L3560,154@6714L3913:ScrollContainer.kt#u9475x");
                        final List list222 = groupedContent;
                        final State state22 = lastFeedBlastData$delegate;
                        final PageViewModel pageViewModel322 = pageViewModel;
                        PullToRefreshKt.PullToRefresh(pullToRefreshState, null, null, ComposableLambdaKt.rememberComposableLambda(-1188560652, true, new Function3() { // from class: kntr.app.mall.product.details.page.ui.container.ScrollContainerKt$$ExternalSyntheticLambda6
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                Unit ScrollContainer_dsL6K2w$lambda$14$0;
                                ScrollContainer_dsL6K2w$lambda$14$0 = ScrollContainerKt.ScrollContainer_dsL6K2w$lambda$14$0(refreshIcon2, refreshIconGif3, scaleModel$delegate, (PullToRefreshState) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                return ScrollContainer_dsL6K2w$lambda$14$0;
                            }
                        }, $composer3, 54), false, ComposableLambdaKt.rememberComposableLambda(-2048010676, true, new Function2() { // from class: kntr.app.mall.product.details.page.ui.container.ScrollContainerKt$$ExternalSyntheticLambda7
                            public final Object invoke(Object obj, Object obj2) {
                                Unit ScrollContainer_dsL6K2w$lambda$14$1;
                                ScrollContainer_dsL6K2w$lambda$14$1 = ScrollContainerKt.ScrollContainer_dsL6K2w$lambda$14$1(f, listState, function2, list222, function1, pageViewModelWrapper, feedBlast$delegate, state22, scaleModel$delegate, pageViewModel322, (Composer) obj, ((Integer) obj2).intValue());
                                return ScrollContainer_dsL6K2w$lambda$14$1;
                            }
                        }, $composer3, 54), $composer3, 199680, 22);
                        if (((Number) selectedTabIndex.getValue()).intValue() > 0) {
                        }
                        $composer3.endReplaceGroup();
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        $composer3.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                    }
                    Object value$iv6 = (Function2) new ScrollContainerKt$ScrollContainer$1$1(pullToRefreshState2, isRefreshing, currentOnRefresh$delegate2, null);
                    $composer3.updateRememberedValue(value$iv6);
                    it$iv3 = value$iv6;
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    EffectsKt.LaunchedEffect(valueOf, (Function2) it$iv3, $composer3, 0);
                    Boolean valueOf22 = Boolean.valueOf(isRefreshing);
                    ComposerKt.sourceInformationMarkerStart($composer3, 1836856954, "CC(remember):ScrollContainer.kt#9igjgp");
                    invalid$iv2 = (($dirty3 & 7168) != 2048) | $composer3.changed(pullToRefreshState2);
                    Object it$iv42 = $composer3.rememberedValue();
                    if (!invalid$iv2) {
                        currentOnRefresh$delegate = currentOnRefresh$delegate2;
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        EffectsKt.LaunchedEffect(valueOf22, (Function2) it$iv42, $composer3, ($dirty3 >> 9) & 14);
                        selectedTabIndex = SnapshotStateKt.collectAsState(pageViewModel2.getSelectedTabIndex(), (CoroutineContext) null, $composer3, 0, 1);
                        List groupedContent222 = pageViewModel2.groupModules$product_details_page_debug(dynamicModules2);
                        ComposerKt.sourceInformationMarkerStart($composer3, 1836867103, "CC(remember):ScrollContainer.kt#9igjgp");
                        invalid$iv3 = $composer3.changedInstance(pageViewModel2) | $composer3.changedInstance(groupedContent222);
                        Object it$iv522 = $composer3.rememberedValue();
                        if (invalid$iv3) {
                        }
                        Object value$iv422 = (Function2) new ScrollContainerKt$ScrollContainer$3$1(pageViewModel2, groupedContent222, null);
                        $composer3.updateRememberedValue(value$iv422);
                        it$iv522 = value$iv422;
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        EffectsKt.LaunchedEffect(groupedContent222, (Function2) it$iv522, $composer3, 0);
                        ComposerKt.sourceInformationMarkerStart($composer3, 1836871989, "CC(remember):ScrollContainer.kt#9igjgp");
                        invalid$iv4 = (($dirty3 & 14) == 4) | $composer3.changed(lastFeedBlastData$delegate2) | $composer3.changedInstance(scope2) | $composer3.changedInstance(pageViewModel2);
                        value$iv = $composer3.rememberedValue();
                        if (invalid$iv4) {
                        }
                        scope = scope2;
                        lastFeedBlastData$delegate = lastFeedBlastData$delegate2;
                        groupedContent = groupedContent222;
                        pageViewModel = pageViewModel2;
                        $dirty = $dirty3;
                        str = "CC(remember):ScrollContainer.kt#9igjgp";
                        pullToRefreshState = pullToRefreshState2;
                        value$iv = new ScrollContainerKt$ScrollContainer$4$1(listState, scope, lastFeedBlastData$delegate, feedBlastIsLoading$delegate, pageViewModel, feedBlastPageNum$delegate, null);
                        $composer3.updateRememberedValue(value$iv);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        EffectsKt.LaunchedEffect(listState, (Function2) value$iv, $composer3, $dirty & 14);
                        Modifier modifier$iv422 = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
                        ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                        Alignment contentAlignment$iv322 = Alignment.Companion.getTopStart();
                        MeasurePolicy measurePolicy$iv422 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv322, false);
                        int $changed$iv$iv422 = (6 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv422 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
                        CompositionLocalMap localMap$iv$iv422 = $composer3.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv422 = ComposedModifierKt.materializeModifier($composer3, modifier$iv422);
                        Function0 factory$iv$iv$iv3222 = ComposeUiNode.Companion.getConstructor();
                        int $changed$iv$iv$iv422 = (($changed$iv$iv422 << 6) & 896) | 6;
                        String str4222 = str;
                        ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                        if (!($composer3.getApplier() instanceof Applier)) {
                        }
                        $composer3.startReusableNode();
                        if ($composer3.getInserting()) {
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv422 = Updater.constructor-impl($composer3);
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv422, measurePolicy$iv422, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv422, localMap$iv$iv422, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Updater.init-impl($this$Layout_u24lambda_u240$iv$iv422, Integer.valueOf(compositeKeyHash$iv$iv422), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv422, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv422, materialized$iv$iv422, ComposeUiNode.Companion.getSetModifier());
                        int i3222 = ($changed$iv$iv$iv422 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                        int i4222 = ((6 >> 6) & 112) | 6;
                        BoxScope $this$ScrollContainer_dsL6K2w_u24lambda_u2414222 = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart($composer3, 237376814, "C156@6793L262,164@7067L3560,154@6714L3913:ScrollContainer.kt#u9475x");
                        final List list2222 = groupedContent;
                        final State state222 = lastFeedBlastData$delegate;
                        final PageViewModel pageViewModel3222 = pageViewModel;
                        PullToRefreshKt.PullToRefresh(pullToRefreshState, null, null, ComposableLambdaKt.rememberComposableLambda(-1188560652, true, new Function3() { // from class: kntr.app.mall.product.details.page.ui.container.ScrollContainerKt$$ExternalSyntheticLambda6
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                Unit ScrollContainer_dsL6K2w$lambda$14$0;
                                ScrollContainer_dsL6K2w$lambda$14$0 = ScrollContainerKt.ScrollContainer_dsL6K2w$lambda$14$0(refreshIcon2, refreshIconGif3, scaleModel$delegate, (PullToRefreshState) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                return ScrollContainer_dsL6K2w$lambda$14$0;
                            }
                        }, $composer3, 54), false, ComposableLambdaKt.rememberComposableLambda(-2048010676, true, new Function2() { // from class: kntr.app.mall.product.details.page.ui.container.ScrollContainerKt$$ExternalSyntheticLambda7
                            public final Object invoke(Object obj, Object obj2) {
                                Unit ScrollContainer_dsL6K2w$lambda$14$1;
                                ScrollContainer_dsL6K2w$lambda$14$1 = ScrollContainerKt.ScrollContainer_dsL6K2w$lambda$14$1(f, listState, function2, list2222, function1, pageViewModelWrapper, feedBlast$delegate, state222, scaleModel$delegate, pageViewModel3222, (Composer) obj, ((Integer) obj2).intValue());
                                return ScrollContainer_dsL6K2w$lambda$14$1;
                            }
                        }, $composer3, 54), $composer3, 199680, 22);
                        if (((Number) selectedTabIndex.getValue()).intValue() > 0) {
                        }
                        $composer3.endReplaceGroup();
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        $composer3.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                    }
                    currentOnRefresh$delegate = currentOnRefresh$delegate2;
                    Object value$iv52 = (Function2) new ScrollContainerKt$ScrollContainer$2$1(isRefreshing, pullToRefreshState2, null);
                    $composer3.updateRememberedValue(value$iv52);
                    it$iv42 = value$iv52;
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    EffectsKt.LaunchedEffect(valueOf22, (Function2) it$iv42, $composer3, ($dirty3 >> 9) & 14);
                    selectedTabIndex = SnapshotStateKt.collectAsState(pageViewModel2.getSelectedTabIndex(), (CoroutineContext) null, $composer3, 0, 1);
                    List groupedContent2222 = pageViewModel2.groupModules$product_details_page_debug(dynamicModules2);
                    ComposerKt.sourceInformationMarkerStart($composer3, 1836867103, "CC(remember):ScrollContainer.kt#9igjgp");
                    invalid$iv3 = $composer3.changedInstance(pageViewModel2) | $composer3.changedInstance(groupedContent2222);
                    Object it$iv5222 = $composer3.rememberedValue();
                    if (invalid$iv3) {
                    }
                    Object value$iv4222 = (Function2) new ScrollContainerKt$ScrollContainer$3$1(pageViewModel2, groupedContent2222, null);
                    $composer3.updateRememberedValue(value$iv4222);
                    it$iv5222 = value$iv4222;
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    EffectsKt.LaunchedEffect(groupedContent2222, (Function2) it$iv5222, $composer3, 0);
                    ComposerKt.sourceInformationMarkerStart($composer3, 1836871989, "CC(remember):ScrollContainer.kt#9igjgp");
                    invalid$iv4 = (($dirty3 & 14) == 4) | $composer3.changed(lastFeedBlastData$delegate2) | $composer3.changedInstance(scope2) | $composer3.changedInstance(pageViewModel2);
                    value$iv = $composer3.rememberedValue();
                    if (invalid$iv4) {
                    }
                    scope = scope2;
                    lastFeedBlastData$delegate = lastFeedBlastData$delegate2;
                    groupedContent = groupedContent2222;
                    pageViewModel = pageViewModel2;
                    $dirty = $dirty3;
                    str = "CC(remember):ScrollContainer.kt#9igjgp";
                    pullToRefreshState = pullToRefreshState2;
                    value$iv = new ScrollContainerKt$ScrollContainer$4$1(listState, scope, lastFeedBlastData$delegate, feedBlastIsLoading$delegate, pageViewModel, feedBlastPageNum$delegate, null);
                    $composer3.updateRememberedValue(value$iv);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    EffectsKt.LaunchedEffect(listState, (Function2) value$iv, $composer3, $dirty & 14);
                    Modifier modifier$iv4222 = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
                    ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    Alignment contentAlignment$iv3222 = Alignment.Companion.getTopStart();
                    MeasurePolicy measurePolicy$iv4222 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv3222, false);
                    int $changed$iv$iv4222 = (6 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int compositeKeyHash$iv$iv4222 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
                    CompositionLocalMap localMap$iv$iv4222 = $composer3.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv4222 = ComposedModifierKt.materializeModifier($composer3, modifier$iv4222);
                    Function0 factory$iv$iv$iv32222 = ComposeUiNode.Companion.getConstructor();
                    int $changed$iv$iv$iv4222 = (($changed$iv$iv4222 << 6) & 896) | 6;
                    String str42222 = str;
                    ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!($composer3.getApplier() instanceof Applier)) {
                    }
                    $composer3.startReusableNode();
                    if ($composer3.getInserting()) {
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv4222 = Updater.constructor-impl($composer3);
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4222, measurePolicy$iv4222, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4222, localMap$iv$iv4222, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv4222, Integer.valueOf(compositeKeyHash$iv$iv4222), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv4222, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4222, materialized$iv$iv4222, ComposeUiNode.Companion.getSetModifier());
                    int i32222 = ($changed$iv$iv$iv4222 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    int i42222 = ((6 >> 6) & 112) | 6;
                    BoxScope $this$ScrollContainer_dsL6K2w_u24lambda_u24142222 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart($composer3, 237376814, "C156@6793L262,164@7067L3560,154@6714L3913:ScrollContainer.kt#u9475x");
                    final List list22222 = groupedContent;
                    final State state2222 = lastFeedBlastData$delegate;
                    final PageViewModel pageViewModel32222 = pageViewModel;
                    PullToRefreshKt.PullToRefresh(pullToRefreshState, null, null, ComposableLambdaKt.rememberComposableLambda(-1188560652, true, new Function3() { // from class: kntr.app.mall.product.details.page.ui.container.ScrollContainerKt$$ExternalSyntheticLambda6
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            Unit ScrollContainer_dsL6K2w$lambda$14$0;
                            ScrollContainer_dsL6K2w$lambda$14$0 = ScrollContainerKt.ScrollContainer_dsL6K2w$lambda$14$0(refreshIcon2, refreshIconGif3, scaleModel$delegate, (PullToRefreshState) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            return ScrollContainer_dsL6K2w$lambda$14$0;
                        }
                    }, $composer3, 54), false, ComposableLambdaKt.rememberComposableLambda(-2048010676, true, new Function2() { // from class: kntr.app.mall.product.details.page.ui.container.ScrollContainerKt$$ExternalSyntheticLambda7
                        public final Object invoke(Object obj, Object obj2) {
                            Unit ScrollContainer_dsL6K2w$lambda$14$1;
                            ScrollContainer_dsL6K2w$lambda$14$1 = ScrollContainerKt.ScrollContainer_dsL6K2w$lambda$14$1(f, listState, function2, list22222, function1, pageViewModelWrapper, feedBlast$delegate, state2222, scaleModel$delegate, pageViewModel32222, (Composer) obj, ((Integer) obj2).intValue());
                            return ScrollContainer_dsL6K2w$lambda$14$1;
                        }
                    }, $composer3, 54), $composer3, 199680, 22);
                    if (((Number) selectedTabIndex.getValue()).intValue() > 0) {
                    }
                    $composer3.endReplaceGroup();
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    $composer3.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                }
            }
            useCustomIcons = false;
            float refreshDistance2 = ProvideUiScaleKt.dpScaled(!useCustomIcons ? 109 : 60, ScrollContainer_dsL6K2w$lambda$9(scaleModel$delegate).getScale());
            final String refreshIcon22 = refreshIcon;
            final String refreshIconGif32 = refreshIconGif;
            PullToRefreshState pullToRefreshState22 = PullToRefreshStateKt.m1873rememberPullToRefreshStatedjqsMU(0.0f, refreshDistance2, refreshDistance2, false, $composer3, 0, 9);
            Boolean valueOf3 = Boolean.valueOf(pullToRefreshState22.isRefreshing());
            ComposerKt.sourceInformationMarkerStart($composer3, 1836849943, "CC(remember):ScrollContainer.kt#9igjgp");
            invalid$iv = $composer3.changed(pullToRefreshState22) | (($dirty3 & 7168) != 2048) | $composer3.changed(currentOnRefresh$delegate2);
            Object it$iv32 = $composer3.rememberedValue();
            if (!invalid$iv) {
                ComposerKt.sourceInformationMarkerEnd($composer3);
                EffectsKt.LaunchedEffect(valueOf3, (Function2) it$iv32, $composer3, 0);
                Boolean valueOf222 = Boolean.valueOf(isRefreshing);
                ComposerKt.sourceInformationMarkerStart($composer3, 1836856954, "CC(remember):ScrollContainer.kt#9igjgp");
                invalid$iv2 = (($dirty3 & 7168) != 2048) | $composer3.changed(pullToRefreshState22);
                Object it$iv422 = $composer3.rememberedValue();
                if (!invalid$iv2) {
                }
                currentOnRefresh$delegate = currentOnRefresh$delegate2;
                Object value$iv522 = (Function2) new ScrollContainerKt$ScrollContainer$2$1(isRefreshing, pullToRefreshState22, null);
                $composer3.updateRememberedValue(value$iv522);
                it$iv422 = value$iv522;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                EffectsKt.LaunchedEffect(valueOf222, (Function2) it$iv422, $composer3, ($dirty3 >> 9) & 14);
                selectedTabIndex = SnapshotStateKt.collectAsState(pageViewModel2.getSelectedTabIndex(), (CoroutineContext) null, $composer3, 0, 1);
                List groupedContent22222 = pageViewModel2.groupModules$product_details_page_debug(dynamicModules2);
                ComposerKt.sourceInformationMarkerStart($composer3, 1836867103, "CC(remember):ScrollContainer.kt#9igjgp");
                invalid$iv3 = $composer3.changedInstance(pageViewModel2) | $composer3.changedInstance(groupedContent22222);
                Object it$iv52222 = $composer3.rememberedValue();
                if (invalid$iv3) {
                }
                Object value$iv42222 = (Function2) new ScrollContainerKt$ScrollContainer$3$1(pageViewModel2, groupedContent22222, null);
                $composer3.updateRememberedValue(value$iv42222);
                it$iv52222 = value$iv42222;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                EffectsKt.LaunchedEffect(groupedContent22222, (Function2) it$iv52222, $composer3, 0);
                ComposerKt.sourceInformationMarkerStart($composer3, 1836871989, "CC(remember):ScrollContainer.kt#9igjgp");
                invalid$iv4 = (($dirty3 & 14) == 4) | $composer3.changed(lastFeedBlastData$delegate2) | $composer3.changedInstance(scope2) | $composer3.changedInstance(pageViewModel2);
                value$iv = $composer3.rememberedValue();
                if (invalid$iv4) {
                }
                scope = scope2;
                lastFeedBlastData$delegate = lastFeedBlastData$delegate2;
                groupedContent = groupedContent22222;
                pageViewModel = pageViewModel2;
                $dirty = $dirty3;
                str = "CC(remember):ScrollContainer.kt#9igjgp";
                pullToRefreshState = pullToRefreshState22;
                value$iv = new ScrollContainerKt$ScrollContainer$4$1(listState, scope, lastFeedBlastData$delegate, feedBlastIsLoading$delegate, pageViewModel, feedBlastPageNum$delegate, null);
                $composer3.updateRememberedValue(value$iv);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                EffectsKt.LaunchedEffect(listState, (Function2) value$iv, $composer3, $dirty & 14);
                Modifier modifier$iv42222 = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                Alignment contentAlignment$iv32222 = Alignment.Companion.getTopStart();
                MeasurePolicy measurePolicy$iv42222 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv32222, false);
                int $changed$iv$iv42222 = (6 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv42222 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
                CompositionLocalMap localMap$iv$iv42222 = $composer3.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv42222 = ComposedModifierKt.materializeModifier($composer3, modifier$iv42222);
                Function0 factory$iv$iv$iv322222 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv42222 = (($changed$iv$iv42222 << 6) & 896) | 6;
                String str422222 = str;
                ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer3.getApplier() instanceof Applier)) {
                }
                $composer3.startReusableNode();
                if ($composer3.getInserting()) {
                }
                Composer $this$Layout_u24lambda_u240$iv$iv42222 = Updater.constructor-impl($composer3);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv42222, measurePolicy$iv42222, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv42222, localMap$iv$iv42222, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv42222, Integer.valueOf(compositeKeyHash$iv$iv42222), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv42222, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv42222, materialized$iv$iv42222, ComposeUiNode.Companion.getSetModifier());
                int i322222 = ($changed$iv$iv$iv42222 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                int i422222 = ((6 >> 6) & 112) | 6;
                BoxScope $this$ScrollContainer_dsL6K2w_u24lambda_u241422222 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer3, 237376814, "C156@6793L262,164@7067L3560,154@6714L3913:ScrollContainer.kt#u9475x");
                final List list222222 = groupedContent;
                final State state22222 = lastFeedBlastData$delegate;
                final PageViewModel pageViewModel322222 = pageViewModel;
                PullToRefreshKt.PullToRefresh(pullToRefreshState, null, null, ComposableLambdaKt.rememberComposableLambda(-1188560652, true, new Function3() { // from class: kntr.app.mall.product.details.page.ui.container.ScrollContainerKt$$ExternalSyntheticLambda6
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        Unit ScrollContainer_dsL6K2w$lambda$14$0;
                        ScrollContainer_dsL6K2w$lambda$14$0 = ScrollContainerKt.ScrollContainer_dsL6K2w$lambda$14$0(refreshIcon22, refreshIconGif32, scaleModel$delegate, (PullToRefreshState) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        return ScrollContainer_dsL6K2w$lambda$14$0;
                    }
                }, $composer3, 54), false, ComposableLambdaKt.rememberComposableLambda(-2048010676, true, new Function2() { // from class: kntr.app.mall.product.details.page.ui.container.ScrollContainerKt$$ExternalSyntheticLambda7
                    public final Object invoke(Object obj, Object obj2) {
                        Unit ScrollContainer_dsL6K2w$lambda$14$1;
                        ScrollContainer_dsL6K2w$lambda$14$1 = ScrollContainerKt.ScrollContainer_dsL6K2w$lambda$14$1(f, listState, function2, list222222, function1, pageViewModelWrapper, feedBlast$delegate, state22222, scaleModel$delegate, pageViewModel322222, (Composer) obj, ((Integer) obj2).intValue());
                        return ScrollContainer_dsL6K2w$lambda$14$1;
                    }
                }, $composer3, 54), $composer3, 199680, 22);
                if (((Number) selectedTabIndex.getValue()).intValue() > 0) {
                }
                $composer3.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                if (ComposerKt.isTraceInProgress()) {
                }
            }
            Object value$iv62 = (Function2) new ScrollContainerKt$ScrollContainer$1$1(pullToRefreshState22, isRefreshing, currentOnRefresh$delegate2, null);
            $composer3.updateRememberedValue(value$iv62);
            it$iv32 = value$iv62;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            EffectsKt.LaunchedEffect(valueOf3, (Function2) it$iv32, $composer3, 0);
            Boolean valueOf2222 = Boolean.valueOf(isRefreshing);
            ComposerKt.sourceInformationMarkerStart($composer3, 1836856954, "CC(remember):ScrollContainer.kt#9igjgp");
            invalid$iv2 = (($dirty3 & 7168) != 2048) | $composer3.changed(pullToRefreshState22);
            Object it$iv4222 = $composer3.rememberedValue();
            if (!invalid$iv2) {
            }
            currentOnRefresh$delegate = currentOnRefresh$delegate2;
            Object value$iv5222 = (Function2) new ScrollContainerKt$ScrollContainer$2$1(isRefreshing, pullToRefreshState22, null);
            $composer3.updateRememberedValue(value$iv5222);
            it$iv4222 = value$iv5222;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            EffectsKt.LaunchedEffect(valueOf2222, (Function2) it$iv4222, $composer3, ($dirty3 >> 9) & 14);
            selectedTabIndex = SnapshotStateKt.collectAsState(pageViewModel2.getSelectedTabIndex(), (CoroutineContext) null, $composer3, 0, 1);
            List groupedContent222222 = pageViewModel2.groupModules$product_details_page_debug(dynamicModules2);
            ComposerKt.sourceInformationMarkerStart($composer3, 1836867103, "CC(remember):ScrollContainer.kt#9igjgp");
            invalid$iv3 = $composer3.changedInstance(pageViewModel2) | $composer3.changedInstance(groupedContent222222);
            Object it$iv522222 = $composer3.rememberedValue();
            if (invalid$iv3) {
            }
            Object value$iv422222 = (Function2) new ScrollContainerKt$ScrollContainer$3$1(pageViewModel2, groupedContent222222, null);
            $composer3.updateRememberedValue(value$iv422222);
            it$iv522222 = value$iv422222;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            EffectsKt.LaunchedEffect(groupedContent222222, (Function2) it$iv522222, $composer3, 0);
            ComposerKt.sourceInformationMarkerStart($composer3, 1836871989, "CC(remember):ScrollContainer.kt#9igjgp");
            invalid$iv4 = (($dirty3 & 14) == 4) | $composer3.changed(lastFeedBlastData$delegate2) | $composer3.changedInstance(scope2) | $composer3.changedInstance(pageViewModel2);
            value$iv = $composer3.rememberedValue();
            if (invalid$iv4) {
            }
            scope = scope2;
            lastFeedBlastData$delegate = lastFeedBlastData$delegate2;
            groupedContent = groupedContent222222;
            pageViewModel = pageViewModel2;
            $dirty = $dirty3;
            str = "CC(remember):ScrollContainer.kt#9igjgp";
            pullToRefreshState = pullToRefreshState22;
            value$iv = new ScrollContainerKt$ScrollContainer$4$1(listState, scope, lastFeedBlastData$delegate, feedBlastIsLoading$delegate, pageViewModel, feedBlastPageNum$delegate, null);
            $composer3.updateRememberedValue(value$iv);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            EffectsKt.LaunchedEffect(listState, (Function2) value$iv, $composer3, $dirty & 14);
            Modifier modifier$iv422222 = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv322222 = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv422222 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv322222, false);
            int $changed$iv$iv422222 = (6 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv422222 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv422222 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv422222 = ComposedModifierKt.materializeModifier($composer3, modifier$iv422222);
            Function0 factory$iv$iv$iv3222222 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv422222 = (($changed$iv$iv422222 << 6) & 896) | 6;
            String str4222222 = str;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
            }
            Composer $this$Layout_u24lambda_u240$iv$iv422222 = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv422222, measurePolicy$iv422222, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv422222, localMap$iv$iv422222, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv422222, Integer.valueOf(compositeKeyHash$iv$iv422222), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv422222, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv422222, materialized$iv$iv422222, ComposeUiNode.Companion.getSetModifier());
            int i3222222 = ($changed$iv$iv$iv422222 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            int i4222222 = ((6 >> 6) & 112) | 6;
            BoxScope $this$ScrollContainer_dsL6K2w_u24lambda_u2414222222 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, 237376814, "C156@6793L262,164@7067L3560,154@6714L3913:ScrollContainer.kt#u9475x");
            final List list2222222 = groupedContent;
            final State state222222 = lastFeedBlastData$delegate;
            final PageViewModel pageViewModel3222222 = pageViewModel;
            PullToRefreshKt.PullToRefresh(pullToRefreshState, null, null, ComposableLambdaKt.rememberComposableLambda(-1188560652, true, new Function3() { // from class: kntr.app.mall.product.details.page.ui.container.ScrollContainerKt$$ExternalSyntheticLambda6
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit ScrollContainer_dsL6K2w$lambda$14$0;
                    ScrollContainer_dsL6K2w$lambda$14$0 = ScrollContainerKt.ScrollContainer_dsL6K2w$lambda$14$0(refreshIcon22, refreshIconGif32, scaleModel$delegate, (PullToRefreshState) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return ScrollContainer_dsL6K2w$lambda$14$0;
                }
            }, $composer3, 54), false, ComposableLambdaKt.rememberComposableLambda(-2048010676, true, new Function2() { // from class: kntr.app.mall.product.details.page.ui.container.ScrollContainerKt$$ExternalSyntheticLambda7
                public final Object invoke(Object obj, Object obj2) {
                    Unit ScrollContainer_dsL6K2w$lambda$14$1;
                    ScrollContainer_dsL6K2w$lambda$14$1 = ScrollContainerKt.ScrollContainer_dsL6K2w$lambda$14$1(f, listState, function2, list2222222, function1, pageViewModelWrapper, feedBlast$delegate, state222222, scaleModel$delegate, pageViewModel3222222, (Composer) obj, ((Integer) obj2).intValue());
                    return ScrollContainer_dsL6K2w$lambda$14$1;
                }
            }, $composer3, 54), $composer3, 199680, 22);
            if (((Number) selectedTabIndex.getValue()).intValue() > 0) {
            }
            $composer3.endReplaceGroup();
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
            dynamicModules = list;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final List list3 = dynamicModules;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.container.ScrollContainerKt$$ExternalSyntheticLambda9
                public final Object invoke(Object obj, Object obj2) {
                    Unit ScrollContainer_dsL6K2w$lambda$15;
                    ScrollContainer_dsL6K2w$lambda$15 = ScrollContainerKt.ScrollContainer_dsL6K2w$lambda$15(listState, function1, f, isRefreshing, function0, pageViewModelWrapper, videoViewModelWrapper, function2, list3, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return ScrollContainer_dsL6K2w$lambda$15;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function0<Unit> ScrollContainer_dsL6K2w$lambda$0(State<? extends Function0<Unit>> state) {
        Object thisObj$iv = state.getValue();
        return (Function0) thisObj$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int ScrollContainer_dsL6K2w$lambda$2(MutableIntState $feedBlastPageNum$delegate) {
        IntState $this$getValue$iv = (IntState) $feedBlastPageNum$delegate;
        return $this$getValue$iv.getIntValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean ScrollContainer_dsL6K2w$lambda$5(MutableState<Boolean> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ScrollContainer_dsL6K2w$lambda$6(MutableState<Boolean> mutableState, boolean z) {
        Object value$iv = Boolean.valueOf(z);
        mutableState.setValue(value$iv);
    }

    private static final List<MallRecommendItem> ScrollContainer_dsL6K2w$lambda$7(State<? extends List<MallRecommendItem>> state) {
        Object thisObj$iv = state.getValue();
        return (List) thisObj$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FeedsModel ScrollContainer_dsL6K2w$lambda$8(State<FeedsModel> state) {
        Object thisObj$iv = state.getValue();
        return (FeedsModel) thisObj$iv;
    }

    private static final UiScaleModel ScrollContainer_dsL6K2w$lambda$9(State<UiScaleModel> state) {
        Object thisObj$iv = state.getValue();
        return (UiScaleModel) thisObj$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ScrollContainer_dsL6K2w$lambda$14$0(String $refreshIcon, String $refreshIconGif, State $scaleModel$delegate, PullToRefreshState state, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(state, "state");
        ComposerKt.sourceInformation($composer, "CN(state)157@6820L221:ScrollContainer.kt#u9475x");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer.changed(state) ? 4 : 2;
        }
        int $dirty2 = $dirty;
        if (!$composer.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1188560652, $dirty2, -1, "kntr.app.mall.product.details.page.ui.container.ScrollContainer.<anonymous>.<anonymous> (ScrollContainer.kt:157)");
            }
            CustomRefreshIndicator(state, $refreshIcon, $refreshIconGif, ScrollContainer_dsL6K2w$lambda$9($scaleModel$delegate), null, $composer, $dirty2 & 14, 16);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00f5  */
    /* JADX WARN: Type inference failed for: r5v11 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit ScrollContainer_dsL6K2w$lambda$14$1(float f, LazyStaggeredGridState $listState, final Function2 $headerBannerSection, final List $groupedContent, final Function1 $getViewModel, final PageViewModelWrapper $pageViewModelWrapper, final State $feedBlast$delegate, final State $lastFeedBlastData$delegate, final State $scaleModel$delegate, final PageViewModel $pageViewModel, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C175@7457L43,176@7516L3101,165@7081L3536:ScrollContainer.kt#u9475x");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2048010676, $changed, -1, "kntr.app.mall.product.details.page.ui.container.ScrollContainer.<anonymous>.<anonymous> (ScrollContainer.kt:165)");
            }
            StaggeredGridCells fixed = new StaggeredGridCells.Fixed(2);
            PaddingValues paddingValues = PaddingKt.PaddingValues-a9UjIt4$default(0.0f, 0.0f, 0.0f, f, 7, (Object) null);
            Modifier defaultVerticalScrollableEffects = DefaultListModifierKt.defaultVerticalScrollableEffects(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), (ScrollableState) $listState, $composer, 6);
            StaggeredGridCells staggeredGridCells = fixed;
            ComposerKt.sourceInformationMarkerStart($composer, -1043220599, "CC(remember):ScrollContainer.kt#9igjgp");
            boolean invalid$iv = $composer.changed($headerBannerSection) | $composer.changedInstance($groupedContent) | $composer.changed($getViewModel) | $composer.changedInstance($pageViewModelWrapper) | $composer.changed($feedBlast$delegate) | $composer.changed($lastFeedBlastData$delegate) | $composer.changed($scaleModel$delegate) | $composer.changedInstance($pageViewModel);
            Object value$iv = $composer.rememberedValue();
            if (!invalid$iv && value$iv != Composer.Companion.getEmpty()) {
                ComposerKt.sourceInformationMarkerEnd($composer);
                LazyStaggeredGridDslKt.LazyVerticalStaggeredGrid-6qCrX9Q(staggeredGridCells, defaultVerticalScrollableEffects, $listState, paddingValues, false, 0.0f, (Arrangement.Horizontal) null, (FlingBehavior) null, false, (OverscrollEffect) null, (Function1) value$iv, $composer, 0, 0, 1008);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            value$iv = new Function1() { // from class: kntr.app.mall.product.details.page.ui.container.ScrollContainerKt$$ExternalSyntheticLambda10
                public final Object invoke(Object obj) {
                    Unit ScrollContainer_dsL6K2w$lambda$14$1$0$0;
                    ScrollContainer_dsL6K2w$lambda$14$1$0$0 = ScrollContainerKt.ScrollContainer_dsL6K2w$lambda$14$1$0$0($groupedContent, $headerBannerSection, $getViewModel, $pageViewModelWrapper, $feedBlast$delegate, $lastFeedBlastData$delegate, $scaleModel$delegate, $pageViewModel, (LazyStaggeredGridScope) obj);
                    return ScrollContainer_dsL6K2w$lambda$14$1$0$0;
                }
            };
            $composer.updateRememberedValue(value$iv);
            ComposerKt.sourceInformationMarkerEnd($composer);
            LazyStaggeredGridDslKt.LazyVerticalStaggeredGrid-6qCrX9Q(staggeredGridCells, defaultVerticalScrollableEffects, $listState, paddingValues, false, 0.0f, (Arrangement.Horizontal) null, (FlingBehavior) null, false, (OverscrollEffect) null, (Function1) value$iv, $composer, 0, 0, 1008);
            if (ComposerKt.isTraceInProgress()) {
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ScrollContainer_dsL6K2w$lambda$14$1$0$0(final List $groupedContent, final Function2 $headerBannerSection, final Function1 $getViewModel, final PageViewModelWrapper $pageViewModelWrapper, final State $feedBlast$delegate, final State $lastFeedBlastData$delegate, final State $scaleModel$delegate, final PageViewModel $pageViewModel, LazyStaggeredGridScope $this$LazyVerticalStaggeredGrid) {
        Intrinsics.checkNotNullParameter($this$LazyVerticalStaggeredGrid, "$this$LazyVerticalStaggeredGrid");
        LazyStaggeredGridScope.-CC.item$default($this$LazyVerticalStaggeredGrid, (Object) null, (Object) null, StaggeredGridItemSpan.Companion.getFullLine(), ComposableLambdaKt.composableLambdaInstance(-569640126, true, new Function3() { // from class: kntr.app.mall.product.details.page.ui.container.ScrollContainerKt$$ExternalSyntheticLambda13
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit ScrollContainer_dsL6K2w$lambda$14$1$0$0$0;
                ScrollContainer_dsL6K2w$lambda$14$1$0$0$0 = ScrollContainerKt.ScrollContainer_dsL6K2w$lambda$14$1$0$0$0($headerBannerSection, (LazyStaggeredGridItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return ScrollContainer_dsL6K2w$lambda$14$1$0$0$0;
            }
        }), 3, (Object) null);
        LazyStaggeredGridScope.-CC.items$default($this$LazyVerticalStaggeredGrid, $groupedContent.size(), new Function1() { // from class: kntr.app.mall.product.details.page.ui.container.ScrollContainerKt$$ExternalSyntheticLambda14
            public final Object invoke(Object obj) {
                Object ScrollContainer_dsL6K2w$lambda$14$1$0$0$1;
                ScrollContainer_dsL6K2w$lambda$14$1$0$0$1 = ScrollContainerKt.ScrollContainer_dsL6K2w$lambda$14$1$0$0$1($groupedContent, ((Integer) obj).intValue());
                return ScrollContainer_dsL6K2w$lambda$14$1$0$0$1;
            }
        }, (Function1) null, new Function1() { // from class: kntr.app.mall.product.details.page.ui.container.ScrollContainerKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                StaggeredGridItemSpan ScrollContainer_dsL6K2w$lambda$14$1$0$0$2;
                ScrollContainer_dsL6K2w$lambda$14$1$0$0$2 = ScrollContainerKt.ScrollContainer_dsL6K2w$lambda$14$1$0$0$2(((Integer) obj).intValue());
                return ScrollContainer_dsL6K2w$lambda$14$1$0$0$2;
            }
        }, ComposableLambdaKt.composableLambdaInstance(2050122683, true, new Function4() { // from class: kntr.app.mall.product.details.page.ui.container.ScrollContainerKt$$ExternalSyntheticLambda1
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                Unit ScrollContainer_dsL6K2w$lambda$14$1$0$0$3;
                ScrollContainer_dsL6K2w$lambda$14$1$0$0$3 = ScrollContainerKt.ScrollContainer_dsL6K2w$lambda$14$1$0$0$3($groupedContent, $getViewModel, $pageViewModelWrapper, (LazyStaggeredGridItemScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
                return ScrollContainer_dsL6K2w$lambda$14$1$0$0$3;
            }
        }), 4, (Object) null);
        if (!ScrollContainer_dsL6K2w$lambda$7($feedBlast$delegate).isEmpty()) {
            LazyStaggeredGridScope.-CC.item$default($this$LazyVerticalStaggeredGrid, (Object) null, (Object) null, StaggeredGridItemSpan.Companion.getFullLine(), ComposableLambdaKt.composableLambdaInstance(1308452999, true, new Function3() { // from class: kntr.app.mall.product.details.page.ui.container.ScrollContainerKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit ScrollContainer_dsL6K2w$lambda$14$1$0$0$4;
                    ScrollContainer_dsL6K2w$lambda$14$1$0$0$4 = ScrollContainerKt.ScrollContainer_dsL6K2w$lambda$14$1$0$0$4($lastFeedBlastData$delegate, $scaleModel$delegate, (LazyStaggeredGridItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return ScrollContainer_dsL6K2w$lambda$14$1$0$0$4;
                }
            }), 3, (Object) null);
        }
        LazyStaggeredGridScope.-CC.items$default($this$LazyVerticalStaggeredGrid, ScrollContainer_dsL6K2w$lambda$7($feedBlast$delegate).size(), new Function1() { // from class: kntr.app.mall.product.details.page.ui.container.ScrollContainerKt$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                Object ScrollContainer_dsL6K2w$lambda$14$1$0$0$5;
                ScrollContainer_dsL6K2w$lambda$14$1$0$0$5 = ScrollContainerKt.ScrollContainer_dsL6K2w$lambda$14$1$0$0$5($feedBlast$delegate, ((Integer) obj).intValue());
                return ScrollContainer_dsL6K2w$lambda$14$1$0$0$5;
            }
        }, (Function1) null, new Function1() { // from class: kntr.app.mall.product.details.page.ui.container.ScrollContainerKt$$ExternalSyntheticLambda4
            public final Object invoke(Object obj) {
                StaggeredGridItemSpan ScrollContainer_dsL6K2w$lambda$14$1$0$0$6;
                ScrollContainer_dsL6K2w$lambda$14$1$0$0$6 = ScrollContainerKt.ScrollContainer_dsL6K2w$lambda$14$1$0$0$6(((Integer) obj).intValue());
                return ScrollContainer_dsL6K2w$lambda$14$1$0$0$6;
            }
        }, ComposableLambdaKt.composableLambdaInstance(-1760968860, true, new Function4() { // from class: kntr.app.mall.product.details.page.ui.container.ScrollContainerKt$$ExternalSyntheticLambda5
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                Unit ScrollContainer_dsL6K2w$lambda$14$1$0$0$7;
                ScrollContainer_dsL6K2w$lambda$14$1$0$0$7 = ScrollContainerKt.ScrollContainer_dsL6K2w$lambda$14$1$0$0$7($feedBlast$delegate, $scaleModel$delegate, $pageViewModel, (LazyStaggeredGridItemScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
                return ScrollContainer_dsL6K2w$lambda$14$1$0$0$7;
            }
        }), 4, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ScrollContainer_dsL6K2w$lambda$14$1$0$0$0(Function2 $headerBannerSection, LazyStaggeredGridItemScope $this$item, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$item, "$this$item");
        ComposerKt.sourceInformation($composer, "C178@7600L21:ScrollContainer.kt#u9475x");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-569640126, $changed, -1, "kntr.app.mall.product.details.page.ui.container.ScrollContainer.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ScrollContainer.kt:178)");
            }
            $headerBannerSection.invoke($composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object ScrollContainer_dsL6K2w$lambda$14$1$0$0$1(List $groupedContent, int index) {
        Object obj = $groupedContent.get(index);
        if (obj instanceof ModuleGroup) {
            Object obj2 = $groupedContent.get(index);
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kntr.app.mall.product.details.page.vm.ModuleGroup");
            return ((ModuleGroup) obj2).getId();
        } else if (obj instanceof ContentModule) {
            Object obj3 = $groupedContent.get(index);
            Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kntr.app.mall.product.details.page.vm.ContentModule");
            return ((ContentModule) obj3).getFloorType().getKey();
        } else {
            return String.valueOf($groupedContent.get(index).hashCode());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StaggeredGridItemSpan ScrollContainer_dsL6K2w$lambda$14$1$0$0$2(int it) {
        return StaggeredGridItemSpan.Companion.getFullLine();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ScrollContainer_dsL6K2w$lambda$14$1$0$0$3(List $groupedContent, Function1 $getViewModel, PageViewModelWrapper $pageViewModelWrapper, LazyStaggeredGridItemScope $this$items, int index, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$items, "$this$items");
        ComposerKt.sourceInformation($composer, "CN(index):ScrollContainer.kt#u9475x");
        int $dirty = $changed;
        if (($changed & 48) == 0) {
            $dirty |= $composer.changed(index) ? 32 : 16;
        }
        int $dirty2 = $dirty;
        if (!$composer.shouldExecute(($dirty2 & 145) != 144, $dirty2 & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2050122683, $dirty2, -1, "kntr.app.mall.product.details.page.ui.container.ScrollContainer.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ScrollContainer.kt:193)");
            }
            Object obj = $groupedContent.get(index);
            if (obj instanceof ModuleGroup) {
                $composer.startReplaceGroup(770016416);
                ComposerKt.sourceInformation($composer, "196@8451L291");
                Object obj2 = $groupedContent.get(index);
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kntr.app.mall.product.details.page.vm.ModuleGroup");
                ComponentBuilderKt.GroupedModuleSection(((ModuleGroup) obj2).getModules(), $getViewModel, $pageViewModelWrapper, Modifier.Companion, $composer, 3072, 0);
                $composer.endReplaceGroup();
            } else {
                if (obj instanceof ContentModule) {
                    $composer.startReplaceGroup(770481354);
                    ComposerKt.sourceInformation($composer, "206@8922L279");
                    Object obj3 = $groupedContent.get(index);
                    Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kntr.app.mall.product.details.page.vm.ContentModule");
                    ContentModule item = (ContentModule) obj3;
                    ComponentBuilderKt.CustomModuleSection(item.getFloorType().getKey(), item, $pageViewModelWrapper, Modifier.Companion, $composer, 3072, 0);
                } else {
                    $composer.startReplaceGroup(761724071);
                }
                $composer.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ScrollContainer_dsL6K2w$lambda$14$1$0$0$4(State $lastFeedBlastData$delegate, State $scaleModel$delegate, LazyStaggeredGridItemScope $this$item, Composer $composer, int $changed) {
        RecommendVO vo;
        Intrinsics.checkNotNullParameter($this$item, "$this$item");
        ComposerKt.sourceInformation($composer, "C217@9404L162:ScrollContainer.kt#u9475x");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1308452999, $changed, -1, "kntr.app.mall.product.details.page.ui.container.ScrollContainer.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ScrollContainer.kt:217)");
            }
            FeedsModel ScrollContainer_dsL6K2w$lambda$8 = ScrollContainer_dsL6K2w$lambda$8($lastFeedBlastData$delegate);
            FeedBlastHeaderKt.FeedBlastHeader((ScrollContainer_dsL6K2w$lambda$8 == null || (vo = ScrollContainer_dsL6K2w$lambda$8.getVo()) == null) ? null : vo.getTitle(), ScrollContainer_dsL6K2w$lambda$9($scaleModel$delegate).getScale(), null, $composer, 0, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object ScrollContainer_dsL6K2w$lambda$14$1$0$0$5(State $feedBlast$delegate, int index) {
        Long itemId = ScrollContainer_dsL6K2w$lambda$7($feedBlast$delegate).get(index).getItemId();
        long itemId2 = itemId != null ? itemId.longValue() : 0L;
        Integer pageNum = ScrollContainer_dsL6K2w$lambda$7($feedBlast$delegate).get(index).getPageNum();
        int pageNum2 = pageNum != null ? pageNum.intValue() : 0;
        return "itemId-" + itemId2 + "-pageNum-" + pageNum2 + "-index-" + index;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StaggeredGridItemSpan ScrollContainer_dsL6K2w$lambda$14$1$0$0$6(int it) {
        return StaggeredGridItemSpan.Companion.getSingleLane();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ScrollContainer_dsL6K2w$lambda$14$1$0$0$7(State $feedBlast$delegate, State $scaleModel$delegate, PageViewModel $pageViewModel, LazyStaggeredGridItemScope $this$items, int index, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        Intrinsics.checkNotNullParameter($this$items, "$this$items");
        ComposerKt.sourceInformation($composer, "CN(index)233@10101L484:ScrollContainer.kt#u9475x");
        int $dirty = $changed;
        if (($changed & 48) == 0) {
            $dirty |= $composer.changed(index) ? 32 : 16;
        }
        if ($composer.shouldExecute(($dirty & 145) != 144, $dirty & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1760968860, $dirty, -1, "kntr.app.mall.product.details.page.ui.container.ScrollContainer.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ScrollContainer.kt:232)");
            }
            MallRecommendItem item = ScrollContainer_dsL6K2w$lambda$7($feedBlast$delegate).get(index);
            Modifier modifier$iv = PaddingKt.padding-VpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), ProvideUiScaleKt.dpScaled(4, ScrollContainer_dsL6K2w$lambda$9($scaleModel$delegate).getScale()), 0.0f, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (0 << 3) & 112;
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
            int i2 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -1681151411, "C239@10359L204:ScrollContainer.kt#u9475x");
            Modifier modifier$iv$iv = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
            FeedBlastItemKt.FeedBlastItem(item, $pageViewModel, modifier$iv$iv, $composer, 384, 0);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ScrollContainer_dsL6K2w$lambda$14$2$0(CoroutineScope $scope, LazyStaggeredGridState $listState) {
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new ScrollContainerKt$ScrollContainer$5$3$1$1($listState, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:80:0x016e, code lost:
        if (r0 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L62;
     */
    /* JADX WARN: Removed duplicated region for block: B:112:0x039a  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x03bb  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00c8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void CustomRefreshIndicator(final PullToRefreshState state, final String refreshIcon, final String refreshIconGif, final UiScaleModel scaleModel, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Modifier modifier3;
        Modifier modifier4;
        boolean useCustomIcons;
        Function0 factory$iv$iv$iv;
        Composer $composer2 = $composer.startRestartGroup(574099438);
        ComposerKt.sourceInformation($composer2, "C(CustomRefreshIndicator)N(state,refreshIcon,refreshIconGif,scaleModel,modifier):ScrollContainer.kt#u9475x");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(state) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(refreshIcon) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changed(refreshIconGif) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer2.changed(scaleModel) ? 2048 : 1024;
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
        if (!$composer2.shouldExecute(($dirty2 & 9363) != 9362, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(574099438, $dirty2, -1, "kntr.app.mall.product.details.page.ui.container.CustomRefreshIndicator (ScrollContainer.kt:293)");
            }
            String str = refreshIcon;
            if (!(str == null || str.length() == 0)) {
                String str2 = refreshIconGif;
                if (!(str2 == null || str2.length() == 0)) {
                    useCustomIcons = true;
                    if (!useCustomIcons) {
                        $composer2.startReplaceGroup(436931895);
                        ComposerKt.sourceInformation($composer2, "301@12702L7,309@12979L284,303@12743L1359");
                        float iconSize = ProvideUiScaleKt.dpScaled(77, scaleModel.getScale());
                        float topPadding = ProvideUiScaleKt.dpScaled(16, scaleModel.getScale());
                        float bottomPadding = ProvideUiScaleKt.dpScaled(16, scaleModel.getScale());
                        float f = Dp.constructor-impl(Dp.constructor-impl(iconSize + topPadding) + bottomPadding);
                        CompositionLocal this_$iv = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object consume = $composer2.consume(this_$iv);
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        Density $this$CustomRefreshIndicator_u24lambda_u240 = (Density) consume;
                        $this$CustomRefreshIndicator_u24lambda_u240.toPx-0680j_4(f);
                        Modifier modifier5 = PaddingKt.padding-qDBjuR0$default(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, (Object) null), f), 0.0f, topPadding, 0.0f, bottomPadding, 5, (Object) null);
                        ComposerKt.sourceInformationMarkerStart($composer2, 1953773866, "CC(remember):ScrollContainer.kt#9igjgp");
                        boolean invalid$iv = ($dirty2 & 14) == 4;
                        Object value$iv = $composer2.rememberedValue();
                        if (invalid$iv) {
                            modifier3 = modifier4;
                        } else {
                            modifier3 = modifier4;
                        }
                        value$iv = new Function1() { // from class: kntr.app.mall.product.details.page.ui.container.ScrollContainerKt$$ExternalSyntheticLambda11
                            public final Object invoke(Object obj) {
                                Unit CustomRefreshIndicator$lambda$1$0;
                                CustomRefreshIndicator$lambda$1$0 = ScrollContainerKt.CustomRefreshIndicator$lambda$1$0(PullToRefreshState.this, (GraphicsLayerScope) obj);
                                return CustomRefreshIndicator$lambda$1$0;
                            }
                        };
                        $composer2.updateRememberedValue(value$iv);
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        Modifier modifier$iv = GraphicsLayerModifierKt.graphicsLayer(modifier5, (Function1) value$iv);
                        Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getCenter();
                        Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
                        ComposerKt.sourceInformationMarkerStart($composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                        MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer2, ((432 >> 3) & 14) | ((432 >> 3) & 112));
                        int $changed$iv$iv = (432 << 3) & 112;
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
                        int i3 = ($changed$iv$iv$iv >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                        RowScope rowScope = RowScopeInstance.INSTANCE;
                        int i4 = ((432 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer2, -665620859, "C:ScrollContainer.kt#u9475x");
                        if (state.isRefreshing() || (!state.isRefreshing() && state.isPullInProgress() && state.getContentOffset() >= state.getRefreshTriggerDistancePx())) {
                            $composer2.startReplaceGroup(-665416167);
                            ComposerKt.sourceInformation($composer2, "");
                            if (refreshIconGif == null) {
                                $composer2.startReplaceGroup(-665416168);
                                $composer2.endReplaceGroup();
                            } else {
                                $composer2.startReplaceGroup(-665416167);
                                ComposerKt.sourceInformation($composer2, "*323@13653L142");
                                BiliImageKt.BiliImage(new ImageRequest(refreshIconGif).build(), SizeKt.size-3ABfNKs(Modifier.Companion, iconSize), null, null, null, null, null, null, null, $composer2, 0, 508);
                                $composer2.endReplaceGroup();
                                Unit unit = Unit.INSTANCE;
                            }
                            $composer2.endReplaceGroup();
                        } else {
                            $composer2.startReplaceGroup(-665153287);
                            ComposerKt.sourceInformation($composer2, "");
                            if (refreshIcon == null) {
                                $composer2.startReplaceGroup(-665153288);
                                $composer2.endReplaceGroup();
                            } else {
                                $composer2.startReplaceGroup(-665153287);
                                ComposerKt.sourceInformation($composer2, "*331@13918L142");
                                BiliImageKt.BiliImage(new ImageRequest(refreshIcon).build(), SizeKt.size-3ABfNKs(Modifier.Companion, iconSize), null, null, null, null, null, null, null, $composer2, 0, 508);
                                $composer2.endReplaceGroup();
                                Unit unit2 = Unit.INSTANCE;
                            }
                            $composer2.endReplaceGroup();
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        $composer2.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        $composer2.endReplaceGroup();
                    } else {
                        modifier3 = modifier4;
                        $composer2.startReplaceGroup(438568912);
                        ComposerKt.sourceInformation($composer2, "341@14211L29");
                        PullToRefreshIndicatorKt.PullToRefreshIndicator(state, null, $composer2, $dirty2 & 14, 2);
                        $composer2.endReplaceGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }
            useCustomIcons = false;
            if (!useCustomIcons) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier6 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.container.ScrollContainerKt$$ExternalSyntheticLambda12
                public final Object invoke(Object obj, Object obj2) {
                    Unit CustomRefreshIndicator$lambda$3;
                    CustomRefreshIndicator$lambda$3 = ScrollContainerKt.CustomRefreshIndicator$lambda$3(PullToRefreshState.this, refreshIcon, refreshIconGif, scaleModel, modifier6, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return CustomRefreshIndicator$lambda$3;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CustomRefreshIndicator$lambda$1$0(PullToRefreshState $state, GraphicsLayerScope $this$graphicsLayer) {
        Intrinsics.checkNotNullParameter($this$graphicsLayer, "$this$graphicsLayer");
        float trans = $state.getContentOffset() - $state.getRefreshingOffsetPx();
        $this$graphicsLayer.setTranslationY(trans);
        return Unit.INSTANCE;
    }
}