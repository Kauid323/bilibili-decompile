package kntr.app.mall.product.details.page.ui.components;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.gestures.TargetedFlingBehavior;
import androidx.compose.foundation.gestures.snapping.SnapPosition;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.AspectRatioKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState;
import androidx.compose.foundation.pager.PageSize;
import androidx.compose.foundation.pager.PagerKt;
import androidx.compose.foundation.pager.PagerScope;
import androidx.compose.foundation.pager.PagerState;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.FloatState;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.compose.ui.unit.Velocity;
import com.bilibili.framework.simpleplayer.SimplePlayer;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kntr.app.mall.product.details.page.api.CommentInfoApiService;
import kntr.app.mall.product.details.page.api.model.BasicInfoFloor;
import kntr.app.mall.product.details.page.api.model.HeaderFloor;
import kntr.app.mall.product.details.page.api.model.ProductDetailsResponse;
import kntr.app.mall.product.details.page.api.model.SkuInfoFloor;
import kntr.app.mall.product.details.page.api.model.VideoSkinConfigDTO;
import kntr.app.mall.product.details.page.ui.components.pieces.BulletTickerKt;
import kntr.app.mall.product.details.page.ui.components.pieces.HeaderCommentPreviewKt;
import kntr.app.mall.product.details.page.ui.components.pieces.HeaderIpFeedRecommendComponentKt;
import kntr.app.mall.product.details.page.ui.components.pieces.SkuInfoHeaderComponentKt;
import kntr.app.mall.product.details.page.ui.components.pieces.UpSayComponentKt;
import kntr.app.mall.product.details.page.ui.components.pieces.VideoPlayerComponentKt;
import kntr.app.mall.product.details.page.ui.container.TopContainerKt;
import kntr.app.mall.product.details.page.ui.scale.ProvideUiScaleKt;
import kntr.app.mall.product.details.page.ui.scale.UiScaleModel;
import kntr.app.mall.product.details.page.utils.HelperKt;
import kntr.app.mall.product.details.page.utils.ScreenKt;
import kntr.app.mall.product.details.page.utils.TrackConsts;
import kntr.app.mall.product.details.page.vm.ContentModule;
import kntr.app.mall.product.details.page.vm.FloorType;
import kntr.app.mall.product.details.page.vm.PageActionHandler;
import kntr.app.mall.product.details.page.vm.PageViewModel;
import kntr.app.mall.product.details.page.vm.PageViewModelWrapper;
import kntr.app.mall.product.details.page.vm.TopContainerState;
import kntr.app.mall.product.details.page.vm.VideoPlayerViewModel;
import kntr.app.mall.product.details.page.vm.VideoPlayerViewModelWrapper;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.imageloader.BiliImageKt;
import kntr.base.imageloader.ImageRequest;
import kntr.base.imageloader.ImmutableImageRequest;
import kntr.base.imageloader.Pixel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function8;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KFunction;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

/* compiled from: HeaderBannerSection.kt */
@Metadata(d1 = {"\u0000n\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001ai\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0011\u0010\n\u001a\r\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\f2\u0011\u0010\r\u001a\r\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\f2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0001¢\u0006\u0004\b\u0012\u0010\u0013\u001a/\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0001¢\u0006\u0002\u0010\u001b\u001a\u001d\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0003¢\u0006\u0002\u0010\u001f\u001a\u001f\u0010 \u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0001¢\u0006\u0002\u0010!¨\u0006\"²\u0006\u0010\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$X\u008a\u0084\u0002²\u0006\f\u0010&\u001a\u0004\u0018\u00010'X\u008a\u0084\u0002²\u0006\n\u0010(\u001a\u00020)X\u008a\u0084\u0002²\u0006\f\u0010*\u001a\u0004\u0018\u00010\u0016X\u008a\u0084\u0002²\u0006\f\u0010+\u001a\u0004\u0018\u00010\u0016X\u008a\u0084\u0002²\u0006\n\u0010,\u001a\u00020\u0011X\u008a\u008e\u0002²\u0006\n\u0010-\u001a\u00020\u001aX\u008a\u008e\u0002²\u0006\n\u0010.\u001a\u00020\u0011X\u008a\u008e\u0002²\u0006\n\u0010/\u001a\u00020\u001dX\u008a\u0084\u0002"}, d2 = {"HeaderBannerSection", "", "topPadding", "Landroidx/compose/ui/unit/Dp;", "vmWrapper", "Lkntr/app/mall/product/details/page/vm/PageViewModelWrapper;", "videoVmWrapper", "Lkntr/app/mall/product/details/page/vm/VideoPlayerViewModelWrapper;", "listState", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;", "movableVideoPlayerView", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "movableUpSayVideoView", "modifier", "Landroidx/compose/ui/Modifier;", "isInPreview", "", "HeaderBannerSection-gSuKmCU", "(FLkntr/app/mall/product/details/page/vm/PageViewModelWrapper;Lkntr/app/mall/product/details/page/vm/VideoPlayerViewModelWrapper;Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLandroidx/compose/runtime/Composer;II)V", "HeaderIndicator", "pagerState", "Landroidx/compose/foundation/pager/PagerState;", "pageViewModel", "Lkntr/app/mall/product/details/page/vm/PageViewModel;", "scale", "", "(Landroidx/compose/foundation/pager/PagerState;Lkntr/app/mall/product/details/page/vm/PageViewModel;FLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "rememberHeaderIndicatorCount", "", "pageState", "(Landroidx/compose/foundation/pager/PagerState;Lkntr/app/mall/product/details/page/vm/PageViewModel;Landroidx/compose/runtime/Composer;I)I", "DetailPreviewPageComponent", "(FLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "product-details-page_debug", "contentModules", "", "Lkntr/app/mall/product/details/page/vm/ContentModule;", "topContainerState", "Lkntr/app/mall/product/details/page/vm/TopContainerState;", "scaleModel", "Lkntr/app/mall/product/details/page/ui/scale/UiScaleModel;", "bannerPagerState", "bannerPreviewPagerState", "firedThisGesture", "accumulatedOffsetPx", "gestureStarted", "count"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class HeaderBannerSectionKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DetailPreviewPageComponent$lambda$1(float f, Modifier modifier, int i, int i2, Composer composer, int i3) {
        DetailPreviewPageComponent(f, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HeaderBannerSection_gSuKmCU$lambda$12(float f, PageViewModelWrapper pageViewModelWrapper, VideoPlayerViewModelWrapper videoPlayerViewModelWrapper, LazyStaggeredGridState lazyStaggeredGridState, Function2 function2, Function2 function22, Modifier modifier, boolean z, int i, int i2, Composer composer, int i3) {
        m475HeaderBannerSectiongSuKmCU(f, pageViewModelWrapper, videoPlayerViewModelWrapper, lazyStaggeredGridState, function2, function22, modifier, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HeaderBannerSection_gSuKmCU$lambda$2(float f, PageViewModelWrapper pageViewModelWrapper, VideoPlayerViewModelWrapper videoPlayerViewModelWrapper, LazyStaggeredGridState lazyStaggeredGridState, Function2 function2, Function2 function22, Modifier modifier, boolean z, int i, int i2, Composer composer, int i3) {
        m475HeaderBannerSectiongSuKmCU(f, pageViewModelWrapper, videoPlayerViewModelWrapper, lazyStaggeredGridState, function2, function22, modifier, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HeaderBannerSection_gSuKmCU$lambda$30(float f, PageViewModelWrapper pageViewModelWrapper, VideoPlayerViewModelWrapper videoPlayerViewModelWrapper, LazyStaggeredGridState lazyStaggeredGridState, Function2 function2, Function2 function22, Modifier modifier, boolean z, int i, int i2, Composer composer, int i3) {
        m475HeaderBannerSectiongSuKmCU(f, pageViewModelWrapper, videoPlayerViewModelWrapper, lazyStaggeredGridState, function2, function22, modifier, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HeaderIndicator$lambda$2(PagerState pagerState, PageViewModel pageViewModel, float f, Modifier modifier, int i, int i2, Composer composer, int i3) {
        HeaderIndicator(pagerState, pageViewModel, f, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:239:0x06b9, code lost:
        if (r8 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L190;
     */
    /* JADX WARN: Code restructure failed: missing block: B:247:0x0701, code lost:
        if (r8 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L195;
     */
    /* JADX WARN: Code restructure failed: missing block: B:280:0x092e, code lost:
        if (r13 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L219;
     */
    /* JADX WARN: Removed duplicated region for block: B:316:0x0b7e  */
    /* JADX WARN: Removed duplicated region for block: B:317:0x0ba6  */
    /* JADX WARN: Removed duplicated region for block: B:320:0x0bcc  */
    /* renamed from: HeaderBannerSection-gSuKmCU  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m475HeaderBannerSectiongSuKmCU(final float f, final PageViewModelWrapper vmWrapper, final VideoPlayerViewModelWrapper videoVmWrapper, final LazyStaggeredGridState listState, final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, Modifier modifier, boolean isInPreview, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        boolean z;
        Composer $composer2;
        Modifier modifier3;
        boolean isInPreview2;
        Object obj;
        Modifier modifier4;
        PageViewModel pageViewModel;
        boolean isInPreview3;
        Composer $composer3;
        float aspectRatio;
        Object obj2;
        Object obj3;
        PageViewModel pageViewModel2;
        State bannerPreviewPagerState$delegate;
        float scale;
        String str;
        PagerState pagerState;
        int pageCount;
        boolean isInPreview4;
        Composer $composer4;
        Modifier modifier5;
        Function0 factory$iv$iv$iv;
        Composer $composer$iv$iv$iv;
        Composer $composer5;
        Composer $composer6;
        Composer $composer$iv;
        List<BasicInfoFloor.BulletScreen.BulletItem> list;
        boolean z2;
        boolean showBulletScreen;
        Function0 factory$iv$iv$iv2;
        ProductDetailsResponse.ProductDetailsData data;
        ContentModule.HeaderModule data2;
        Intrinsics.checkNotNullParameter(vmWrapper, "vmWrapper");
        Intrinsics.checkNotNullParameter(videoVmWrapper, "videoVmWrapper");
        Intrinsics.checkNotNullParameter(listState, "listState");
        Intrinsics.checkNotNullParameter(function2, "movableVideoPlayerView");
        Intrinsics.checkNotNullParameter(function22, "movableUpSayVideoView");
        Composer $composer7 = $composer.startRestartGroup(154847745);
        ComposerKt.sourceInformation($composer7, "C(HeaderBannerSection)N(topPadding:c#ui.unit.Dp,vmWrapper,videoVmWrapper,listState,movableVideoPlayerView,movableUpSayVideoView,modifier,isInPreview)103@5205L16,107@5484L16,126@6406L16,133@6571L16,139@6765L16,140@6855L16,141@6913L7,142@6949L34,152@7177L24,154@7234L7,156@7346L36,157@7409L34,176@8134L228,176@8088L274,198@8701L4224,292@12953L16,293@13014L7,297@13198L959,297@13172L985,327@14203L805,327@14163L845,347@15051L537,371@15594L14801:HeaderBannerSection.kt#o90vz8");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer7.changed(f) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer7.changedInstance(vmWrapper) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer7.changedInstance(videoVmWrapper) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer7.changed(listState) ? 2048 : 1024;
        }
        if (($changed & 24576) == 0) {
            $dirty |= $composer7.changedInstance(function2) ? 16384 : 8192;
        }
        if ((196608 & $changed) == 0) {
            $dirty |= $composer7.changedInstance(function22) ? 131072 : 65536;
        }
        int i2 = i & 64;
        if (i2 != 0) {
            $dirty |= 1572864;
            modifier2 = modifier;
        } else if ((1572864 & $changed) == 0) {
            modifier2 = modifier;
            $dirty |= $composer7.changed(modifier2) ? 1048576 : 524288;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 128;
        if (i3 != 0) {
            $dirty |= 12582912;
            z = isInPreview;
        } else if ((12582912 & $changed) == 0) {
            z = isInPreview;
            $dirty |= $composer7.changed(z) ? 8388608 : 4194304;
        } else {
            z = isInPreview;
        }
        if ($composer7.shouldExecute(($dirty & 4793491) != 4793490, $dirty & 1)) {
            if (i2 != 0) {
                modifier2 = (Modifier) Modifier.Companion;
            }
            boolean isInPreview5 = i3 != 0 ? false : z;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(154847745, $dirty, -1, "kntr.app.mall.product.details.page.ui.components.HeaderBannerSection (HeaderBannerSection.kt:100)");
            }
            PageViewModel pageViewModel3 = vmWrapper.getViewModel();
            final VideoPlayerViewModel videoViewModel = videoVmWrapper.getViewModel();
            int $dirty2 = $dirty;
            State contentModules$delegate = SnapshotStateKt.collectAsState(pageViewModel3.getContentModules$product_details_page_debug(), (CoroutineContext) null, $composer7, 0, 1);
            Iterator<T> it = HeaderBannerSection_gSuKmCU$lambda$0(contentModules$delegate).iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                ContentModule it2 = (ContentModule) obj;
                if (it2 instanceof ContentModule.BasicInfoModule) {
                    break;
                }
            }
            ContentModule.BasicInfoModule basicInfoModule = obj instanceof ContentModule.BasicInfoModule ? (ContentModule.BasicInfoModule) obj : null;
            if (basicInfoModule != null) {
                final BasicInfoFloor basicInfoFloor = basicInfoModule.getData();
                if (basicInfoFloor == null) {
                    modifier4 = modifier2;
                    pageViewModel = pageViewModel3;
                    isInPreview3 = isInPreview5;
                    $composer3 = $composer7;
                } else {
                    State topContainerState$delegate = SnapshotStateKt.collectAsState(pageViewModel3.getTopContainerState$product_details_page_debug(), (CoroutineContext) null, $composer7, 0, 1);
                    TopContainerState HeaderBannerSection_gSuKmCU$lambda$3 = HeaderBannerSection_gSuKmCU$lambda$3(topContainerState$delegate);
                    final HeaderFloor headerFloor = (HeaderBannerSection_gSuKmCU$lambda$3 == null || (data2 = HeaderBannerSection_gSuKmCU$lambda$3.getData()) == null) ? null : data2.getData();
                    final List imageList = basicInfoFloor.getImageList();
                    BasicInfoFloor.MainImageScale mainImgScale = basicInfoFloor.getMainImgScale();
                    if ((mainImgScale != null ? mainImgScale.getWidth() : null) == null || basicInfoFloor.getMainImgScale().getHeight() == null || basicInfoFloor.getMainImgScale().getWidth().doubleValue() <= 0.0d || basicInfoFloor.getMainImgScale().getHeight().doubleValue() <= 0.0d) {
                        aspectRatio = 1.0f;
                    } else {
                        float aspectRatio2 = ((float) basicInfoFloor.getMainImgScale().getWidth().doubleValue()) / ((float) basicInfoFloor.getMainImgScale().getHeight().doubleValue());
                        aspectRatio = aspectRatio2;
                    }
                    final BasicInfoFloor.NewUpSayModel upSayModel = basicInfoFloor.getNewUpSayVO();
                    Iterator it3 = HeaderBannerSection_gSuKmCU$lambda$0(contentModules$delegate).iterator();
                    while (true) {
                        if (!it3.hasNext()) {
                            obj2 = null;
                            break;
                        }
                        obj2 = it3.next();
                        Iterator it4 = it3;
                        ContentModule it5 = (ContentModule) obj2;
                        if (it5 instanceof ContentModule.CommentModule) {
                            break;
                        }
                        it3 = it4;
                    }
                    ContentModule.CommentModule commentModule = obj2 instanceof ContentModule.CommentModule ? (ContentModule.CommentModule) obj2 : null;
                    final CommentInfoApiService.CommentInfoResponse.CommentInfoData commentFloor = commentModule != null ? commentModule.getCommentApiData() : null;
                    Iterator it6 = HeaderBannerSection_gSuKmCU$lambda$0(contentModules$delegate).iterator();
                    while (true) {
                        if (!it6.hasNext()) {
                            obj3 = null;
                            break;
                        }
                        obj3 = it6.next();
                        Iterator it7 = it6;
                        ContentModule it8 = (ContentModule) obj3;
                        if (it8 instanceof ContentModule.SkuInfoModule) {
                            break;
                        }
                        it6 = it7;
                    }
                    ContentModule.SkuInfoModule skuInfoModule = obj3 instanceof ContentModule.SkuInfoModule ? (ContentModule.SkuInfoModule) obj3 : null;
                    final SkuInfoFloor skuInfoFloor = skuInfoModule != null ? skuInfoModule.getData() : null;
                    final Modifier modifier6 = modifier2;
                    State scaleModel$delegate = SnapshotStateKt.collectAsState(pageViewModel3.getUiScaleModelFlow$product_details_page_debug(), (CoroutineContext) null, $composer7, 0, 1);
                    float scale2 = HeaderBannerSection_gSuKmCU$lambda$6(scaleModel$delegate).getScale();
                    ProductDetailsResponse productDetailsResponse = (ProductDetailsResponse) SnapshotStateKt.collectAsState(pageViewModel3.getProductDetailsResponse(), (CoroutineContext) null, $composer7, 0, 1).getValue();
                    final VideoSkinConfigDTO videoSkin = (productDetailsResponse == null || (data = productDetailsResponse.getData()) == null) ? null : data.getVideoSkin();
                    final int pageCount2 = pageViewModel3.getHeaderPageCount$product_details_page_debug();
                    final State bannerPagerState$delegate = SnapshotStateKt.collectAsState(pageViewModel3.getBannerPagerState(), (CoroutineContext) null, $composer7, 0, 1);
                    State bannerPreviewPagerState$delegate2 = SnapshotStateKt.collectAsState(pageViewModel3.getBannerPreviewPagerState(), (CoroutineContext) null, $composer7, 0, 1);
                    CompositionLocal this_$iv = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart($composer7, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object consume = $composer7.consume(this_$iv);
                    ComposerKt.sourceInformationMarkerEnd($composer7);
                    LayoutDirection layoutDirection = (LayoutDirection) consume;
                    ComposerKt.sourceInformationMarkerStart($composer7, -1515100605, "CC(remember):HeaderBannerSection.kt#9igjgp");
                    Object it$iv = $composer7.rememberedValue();
                    if (it$iv == Composer.Companion.getEmpty()) {
                        pageViewModel2 = pageViewModel3;
                        Object value$iv = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                        $composer7.updateRememberedValue(value$iv);
                        it$iv = value$iv;
                    } else {
                        pageViewModel2 = pageViewModel3;
                    }
                    MutableState firedThisGesture$delegate = (MutableState) it$iv;
                    ComposerKt.sourceInformationMarkerEnd($composer7);
                    PagerState pagerState2 = isInPreview5 ? HeaderBannerSection_gSuKmCU$lambda$8(bannerPreviewPagerState$delegate2) : HeaderBannerSection_gSuKmCU$lambda$7(bannerPagerState$delegate);
                    if (pagerState2 == null) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        ScopeUpdateScope endRestartGroup = $composer7.endRestartGroup();
                        if (endRestartGroup != null) {
                            final boolean isInPreview6 = isInPreview5;
                            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.HeaderBannerSectionKt$$ExternalSyntheticLambda14
                                public final Object invoke(Object obj4, Object obj5) {
                                    Unit HeaderBannerSection_gSuKmCU$lambda$12;
                                    HeaderBannerSection_gSuKmCU$lambda$12 = HeaderBannerSectionKt.HeaderBannerSection_gSuKmCU$lambda$12(f, vmWrapper, videoVmWrapper, listState, function2, function22, modifier6, isInPreview6, $changed, i, (Composer) obj4, ((Integer) obj5).intValue());
                                    return HeaderBannerSection_gSuKmCU$lambda$12;
                                }
                            });
                            return;
                        }
                        return;
                    }
                    final boolean isInPreview7 = isInPreview5;
                    float aspectRatio3 = aspectRatio;
                    final PageViewModel pageViewModel4 = pageViewModel2;
                    ComposerKt.sourceInformationMarkerStart($composer7, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
                    ComposerKt.sourceInformationMarkerStart($composer7, 683736516, "CC(remember):Effects.kt#9igjgp");
                    Object it$iv$iv = $composer7.rememberedValue();
                    if (it$iv$iv == Composer.Companion.getEmpty()) {
                        Object value$iv$iv = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer7);
                        $composer7.updateRememberedValue(value$iv$iv);
                        it$iv$iv = value$iv$iv;
                    }
                    final CoroutineScope scope = (CoroutineScope) it$iv$iv;
                    ComposerKt.sourceInformationMarkerEnd($composer7);
                    ComposerKt.sourceInformationMarkerEnd($composer7);
                    CompositionLocal this_$iv2 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart($composer7, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object consume2 = $composer7.consume(this_$iv2);
                    ComposerKt.sourceInformationMarkerEnd($composer7);
                    Density density = (Density) consume2;
                    final float maxPreviewOffsetPx = density.toPx-0680j_4(ProvideUiScaleKt.dpScaled(60, scale2));
                    ComposerKt.sourceInformationMarkerStart($composer7, -1515087899, "CC(remember):HeaderBannerSection.kt#9igjgp");
                    Object it$iv2 = $composer7.rememberedValue();
                    if (it$iv2 == Composer.Companion.getEmpty()) {
                        Object value$iv2 = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
                        $composer7.updateRememberedValue(value$iv2);
                        it$iv2 = value$iv2;
                    }
                    final MutableFloatState accumulatedOffsetPx$delegate = (MutableFloatState) it$iv2;
                    ComposerKt.sourceInformationMarkerEnd($composer7);
                    ComposerKt.sourceInformationMarkerStart($composer7, -1515085885, "CC(remember):HeaderBannerSection.kt#9igjgp");
                    Object it$iv3 = $composer7.rememberedValue();
                    if (it$iv3 == Composer.Companion.getEmpty()) {
                        Object value$iv3 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                        $composer7.updateRememberedValue(value$iv3);
                        it$iv3 = value$iv3;
                    }
                    final MutableState gestureStarted$delegate = (MutableState) it$iv3;
                    ComposerKt.sourceInformationMarkerEnd($composer7);
                    if (isInPreview7) {
                        $composer7.startReplaceGroup(277042303);
                        ComposerKt.sourceInformation($composer7, "160@7529L221,160@7476L274");
                        PagerState HeaderBannerSection_gSuKmCU$lambda$8 = HeaderBannerSection_gSuKmCU$lambda$8(bannerPreviewPagerState$delegate2);
                        Integer valueOf = HeaderBannerSection_gSuKmCU$lambda$8 != null ? Integer.valueOf(HeaderBannerSection_gSuKmCU$lambda$8.getCurrentPage()) : null;
                        ComposerKt.sourceInformationMarkerStart($composer7, -1515081858, "CC(remember):HeaderBannerSection.kt#9igjgp");
                        bannerPreviewPagerState$delegate = bannerPreviewPagerState$delegate2;
                        boolean invalid$iv = $composer7.changed(bannerPreviewPagerState$delegate) | $composer7.changed(bannerPagerState$delegate);
                        Object it$iv4 = $composer7.rememberedValue();
                        if (invalid$iv || it$iv4 == Composer.Companion.getEmpty()) {
                            Object value$iv4 = (Function2) new HeaderBannerSectionKt$HeaderBannerSection$2$1(bannerPreviewPagerState$delegate, bannerPagerState$delegate, null);
                            $composer7.updateRememberedValue(value$iv4);
                            it$iv4 = value$iv4;
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer7);
                        EffectsKt.LaunchedEffect(valueOf, (Function2) it$iv4, $composer7, 0);
                        $composer7.endReplaceGroup();
                    } else {
                        bannerPreviewPagerState$delegate = bannerPreviewPagerState$delegate2;
                        $composer7.startReplaceGroup(277335935);
                        ComposerKt.sourceInformation($composer7, "167@7818L228,167@7772L274");
                        PagerState HeaderBannerSection_gSuKmCU$lambda$7 = HeaderBannerSection_gSuKmCU$lambda$7(bannerPagerState$delegate);
                        Integer valueOf2 = HeaderBannerSection_gSuKmCU$lambda$7 != null ? Integer.valueOf(HeaderBannerSection_gSuKmCU$lambda$7.getCurrentPage()) : null;
                        ComposerKt.sourceInformationMarkerStart($composer7, -1515072603, "CC(remember):HeaderBannerSection.kt#9igjgp");
                        boolean invalid$iv2 = $composer7.changed(bannerPagerState$delegate) | $composer7.changed(bannerPreviewPagerState$delegate);
                        Object it$iv5 = $composer7.rememberedValue();
                        if (invalid$iv2 || it$iv5 == Composer.Companion.getEmpty()) {
                            Object value$iv5 = (Function2) new HeaderBannerSectionKt$HeaderBannerSection$3$1(bannerPagerState$delegate, bannerPreviewPagerState$delegate, null);
                            $composer7.updateRememberedValue(value$iv5);
                            it$iv5 = value$iv5;
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer7);
                        EffectsKt.LaunchedEffect(valueOf2, (Function2) it$iv5, $composer7, 0);
                        $composer7.endReplaceGroup();
                    }
                    Boolean valueOf3 = Boolean.valueOf(pagerState2.isScrollInProgress());
                    ComposerKt.sourceInformationMarkerStart($composer7, -1515062491, "CC(remember):HeaderBannerSection.kt#9igjgp");
                    boolean invalid$iv3 = $composer7.changed(pagerState2);
                    Object it$iv6 = $composer7.rememberedValue();
                    if (invalid$iv3 || it$iv6 == Composer.Companion.getEmpty()) {
                        Object value$iv6 = (Function2) new HeaderBannerSectionKt$HeaderBannerSection$4$1(pagerState2, firedThisGesture$delegate, gestureStarted$delegate, accumulatedOffsetPx$delegate, null);
                        $composer7.updateRememberedValue(value$iv6);
                        it$iv6 = value$iv6;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer7);
                    EffectsKt.LaunchedEffect(valueOf3, (Function2) it$iv6, $composer7, 0);
                    Integer bannerDetailPreviewIndex = pageViewModel4.getBannerDetailPreviewIndex();
                    ComposerKt.sourceInformationMarkerStart($composer7, -1515040351, "CC(remember):HeaderBannerSection.kt#9igjgp");
                    boolean invalid$iv4 = $composer7.changed(pagerState2) | $composer7.changed(pageCount2) | $composer7.changed(bannerDetailPreviewIndex);
                    Object value$iv7 = $composer7.rememberedValue();
                    if (invalid$iv4 || value$iv7 == Composer.Companion.getEmpty()) {
                        scale = scale2;
                        str = "CC(remember):HeaderBannerSection.kt#9igjgp";
                        final State state = bannerPreviewPagerState$delegate;
                        pagerState = pagerState2;
                        pageCount = pageCount2;
                        isInPreview4 = isInPreview7;
                        $composer4 = $composer7;
                        value$iv7 = new NestedScrollConnection() { // from class: kntr.app.mall.product.details.page.ui.components.HeaderBannerSectionKt$HeaderBannerSection$nestedScrollConnection$1$1
                            /* renamed from: onPreFling-QWom1Mo  reason: not valid java name */
                            public /* bridge */ Object m482onPreFlingQWom1Mo(long j, Continuation<? super Velocity> continuation) {
                                return NestedScrollConnection.-CC.$default$onPreFling-QWom1Mo(this, j, continuation);
                            }

                            /* renamed from: onPreScroll-OzD1aCk  reason: not valid java name */
                            public long m483onPreScrollOzD1aCk(long j, int i4) {
                                boolean HeaderBannerSection_gSuKmCU$lambda$18;
                                float HeaderBannerSection_gSuKmCU$lambda$15;
                                PagerState currentPagerState = isInPreview7 ? HeaderBannerSectionKt.HeaderBannerSection_gSuKmCU$lambda$8(state) : HeaderBannerSectionKt.HeaderBannerSection_gSuKmCU$lambda$7(bannerPagerState$delegate);
                                if (currentPagerState == null) {
                                    return Offset.Companion.getZero-F1C5BW0();
                                }
                                int totalPages = pageCount2;
                                Integer detailPreviewIndex = pageViewModel4.getBannerDetailPreviewIndex();
                                boolean targetingDetailPreview = (detailPreviewIndex != null && currentPagerState.getTargetPage() == detailPreviewIndex.intValue()) || (detailPreviewIndex != null && currentPagerState.getTargetPage() == totalPages + (-1));
                                if (targetingDetailPreview && detailPreviewIndex != null) {
                                    int bits$iv$iv$iv = (int) (j >> 32);
                                    if (Float.intBitsToFloat(bits$iv$iv$iv) < 0.0f) {
                                        int bits$iv$iv$iv2 = (int) (j >> 32);
                                        float deltaX = Float.intBitsToFloat(bits$iv$iv$iv2);
                                        if (deltaX < 0.0f) {
                                            HeaderBannerSection_gSuKmCU$lambda$18 = HeaderBannerSectionKt.HeaderBannerSection_gSuKmCU$lambda$18(gestureStarted$delegate);
                                            if (!HeaderBannerSection_gSuKmCU$lambda$18) {
                                                HeaderBannerSectionKt.HeaderBannerSection_gSuKmCU$lambda$19(gestureStarted$delegate, true);
                                                accumulatedOffsetPx$delegate.setFloatValue(0.0f);
                                            }
                                            HeaderBannerSection_gSuKmCU$lambda$15 = HeaderBannerSectionKt.HeaderBannerSection_gSuKmCU$lambda$15(accumulatedOffsetPx$delegate);
                                            float newOffset = RangesKt.coerceAtMost(HeaderBannerSection_gSuKmCU$lambda$15 + deltaX, 0.0f);
                                            float offsetAbs = Math.abs(newOffset);
                                            if (offsetAbs > maxPreviewOffsetPx) {
                                                int bits$iv$iv$iv3 = (int) (j >> 32);
                                                float x$iv = Float.intBitsToFloat(bits$iv$iv$iv3);
                                                long v1$iv$iv = Float.floatToRawIntBits(x$iv);
                                                long v2$iv$iv = Float.floatToRawIntBits(0.0f);
                                                return Offset.constructor-impl((v1$iv$iv << 32) | (v2$iv$iv & 4294967295L));
                                            }
                                            accumulatedOffsetPx$delegate.setFloatValue(newOffset);
                                            int bits$iv$iv$iv4 = (int) (j >> 32);
                                            float x$iv2 = Float.intBitsToFloat(bits$iv$iv$iv4);
                                            long v1$iv$iv2 = Float.floatToRawIntBits(x$iv2);
                                            long v2$iv$iv2 = Float.floatToRawIntBits(0.0f);
                                            return Offset.constructor-impl((v1$iv$iv2 << 32) | (v2$iv$iv2 & 4294967295L));
                                        }
                                        return Offset.Companion.getZero-F1C5BW0();
                                    }
                                }
                                return Offset.Companion.getZero-F1C5BW0();
                            }

                            /* renamed from: onPostScroll-DzOQY0M  reason: not valid java name */
                            public long m481onPostScrollDzOQY0M(long j, long j2, int i4) {
                                return Offset.Companion.getZero-F1C5BW0();
                            }

                            /* renamed from: onPostFling-RZ2iAVY  reason: not valid java name */
                            public Object m480onPostFlingRZ2iAVY(long j, long j2, Continuation<? super Velocity> continuation) {
                                boolean HeaderBannerSection_gSuKmCU$lambda$18;
                                float HeaderBannerSection_gSuKmCU$lambda$15;
                                HeaderBannerSection_gSuKmCU$lambda$18 = HeaderBannerSectionKt.HeaderBannerSection_gSuKmCU$lambda$18(gestureStarted$delegate);
                                if (HeaderBannerSection_gSuKmCU$lambda$18) {
                                    HeaderBannerSectionKt.HeaderBannerSection_gSuKmCU$lambda$19(gestureStarted$delegate, false);
                                    HeaderBannerSection_gSuKmCU$lambda$15 = HeaderBannerSectionKt.HeaderBannerSection_gSuKmCU$lambda$15(accumulatedOffsetPx$delegate);
                                    float offsetAbs = Math.abs(HeaderBannerSection_gSuKmCU$lambda$15);
                                    if (offsetAbs >= maxPreviewOffsetPx * 0.5f) {
                                        BuildersKt.launch$default(scope, (CoroutineContext) null, (CoroutineStart) null, new HeaderBannerSectionKt$HeaderBannerSection$nestedScrollConnection$1$1$onPostFling$2(isInPreview7, pageCount2, pageViewModel4, state, bannerPagerState$delegate, scope, listState, null), 3, (Object) null);
                                    } else {
                                        BuildersKt.launch$default(scope, (CoroutineContext) null, (CoroutineStart) null, new HeaderBannerSectionKt$HeaderBannerSection$nestedScrollConnection$1$1$onPostFling$3(isInPreview7, pageCount2, state, bannerPagerState$delegate, null), 3, (Object) null);
                                    }
                                    accumulatedOffsetPx$delegate.setFloatValue(0.0f);
                                }
                                return Velocity.box-impl(Velocity.Companion.getZero-9UxMQ8M());
                            }
                        };
                        $composer7.updateRememberedValue(value$iv7);
                    } else {
                        pageCount = pageCount2;
                        isInPreview4 = isInPreview7;
                        $composer4 = $composer7;
                        scale = scale2;
                        pagerState = pagerState2;
                        str = "CC(remember):HeaderBannerSection.kt#9igjgp";
                    }
                    HeaderBannerSectionKt$HeaderBannerSection$nestedScrollConnection$1$1 headerBannerSectionKt$HeaderBannerSection$nestedScrollConnection$1$1 = (HeaderBannerSectionKt$HeaderBannerSection$nestedScrollConnection$1$1) value$iv7;
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    Composer $composer8 = $composer4;
                    float screenWidth = ScreenKt.getScreenWidth($composer8, 0);
                    CompositionLocal this_$iv3 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart($composer8, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object consume3 = $composer8.consume(this_$iv3);
                    ComposerKt.sourceInformationMarkerEnd($composer8);
                    Density $this$HeaderBannerSection_gSuKmCU_u24lambda_u2424 = (Density) consume3;
                    int widthPixelValue = (int) $this$HeaderBannerSection_gSuKmCU_u24lambda_u2424.toPx-0680j_4(screenWidth);
                    final int widthPixel = Pixel.m1517constructorimpl(widthPixelValue);
                    final int heightPixel = Pixel.m1517constructorimpl((int) (widthPixelValue / aspectRatio3));
                    ComposerKt.sourceInformationMarkerStart($composer8, -1514899712, str);
                    boolean invalid$iv5 = $composer8.changedInstance(imageList) | $composer8.changed(widthPixel) | $composer8.changed(heightPixel) | $composer8.changedInstance(scope) | $composer8.changedInstance(pageViewModel4);
                    Object it$iv7 = $composer8.rememberedValue();
                    if (invalid$iv5 || it$iv7 == Composer.Companion.getEmpty()) {
                        Object value$iv8 = (Function2) new HeaderBannerSectionKt$HeaderBannerSection$5$1(imageList, widthPixel, heightPixel, scope, pageViewModel4, null);
                        $composer8.updateRememberedValue(value$iv8);
                        it$iv7 = value$iv8;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer8);
                    EffectsKt.LaunchedEffect(imageList, (Function2) it$iv7, $composer8, 0);
                    Boolean valueOf4 = Boolean.valueOf(isInPreview4);
                    ComposerKt.sourceInformationMarkerStart($composer8, -1514867706, str);
                    final PagerState pagerState3 = pagerState;
                    boolean invalid$iv6 = $composer8.changedInstance(pageViewModel4) | (($dirty2 & 29360128) == 8388608) | $composer8.changed(pagerState3) | $composer8.changedInstance(videoViewModel);
                    Object it$iv8 = $composer8.rememberedValue();
                    if (invalid$iv6) {
                    }
                    Object value$iv9 = (Function2) new HeaderBannerSectionKt$HeaderBannerSection$6$1(pageViewModel4, isInPreview4, pagerState3, videoViewModel, null);
                    $composer8.updateRememberedValue(value$iv9);
                    it$iv8 = value$iv9;
                    ComposerKt.sourceInformationMarkerEnd($composer8);
                    EffectsKt.LaunchedEffect(valueOf4, pagerState3, (Function2) it$iv8, $composer8, ($dirty2 >> 21) & 14);
                    ComposerKt.sourceInformationMarkerStart($composer8, -1514840838, str);
                    boolean invalid$iv7 = $composer8.changedInstance(pageViewModel4);
                    Object it$iv9 = $composer8.rememberedValue();
                    if (invalid$iv7) {
                    }
                    Object value$iv10 = new Function1() { // from class: kntr.app.mall.product.details.page.ui.components.HeaderBannerSectionKt$$ExternalSyntheticLambda15
                        public final Object invoke(Object obj4) {
                            String HeaderBannerSection_gSuKmCU$lambda$27$0;
                            HeaderBannerSection_gSuKmCU$lambda$27$0 = HeaderBannerSectionKt.HeaderBannerSection_gSuKmCU$lambda$27$0(PageViewModel.this, ((Integer) obj4).intValue());
                            return HeaderBannerSection_gSuKmCU$lambda$27$0;
                        }
                    };
                    $composer8.updateRememberedValue(value$iv10);
                    it$iv9 = value$iv10;
                    final Function1 getShowElement = (Function1) it$iv9;
                    ComposerKt.sourceInformationMarkerEnd($composer8);
                    Modifier aspectRatio$default = AspectRatioKt.aspectRatio$default(SizeKt.fillMaxWidth$default(modifier6, 0.0f, 1, (Object) null), aspectRatio3, false, 2, (Object) null);
                    final boolean isInPreview8 = isInPreview4;
                    if (isInPreview8) {
                        $composer8.startReplaceGroup(286040425);
                        $composer8.endReplaceGroup();
                        modifier5 = Modifier.Companion;
                    } else {
                        $composer8.startReplaceGroup(285298533);
                        ComposerKt.sourceInformation($composer8, "378@15819L697");
                        Modifier modifier7 = Modifier.Companion;
                        ComposerKt.sourceInformationMarkerStart($composer8, -1514816102, str);
                        boolean invalid$iv8 = $composer8.changedInstance(pageViewModel4) | $composer8.changed(pagerState3) | $composer8.changed(getShowElement);
                        Object it$iv10 = $composer8.rememberedValue();
                        if (!invalid$iv8 && it$iv10 != Composer.Companion.getEmpty()) {
                            ComposerKt.sourceInformationMarkerEnd($composer8);
                            modifier5 = ClickableKt.clickable-oSLSa3U$default(modifier7, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv10, 15, (Object) null);
                            $composer8.endReplaceGroup();
                        }
                        Object value$iv11 = new Function0() { // from class: kntr.app.mall.product.details.page.ui.components.HeaderBannerSectionKt$$ExternalSyntheticLambda0
                            public final Object invoke() {
                                Unit HeaderBannerSection_gSuKmCU$lambda$28$0;
                                HeaderBannerSection_gSuKmCU$lambda$28$0 = HeaderBannerSectionKt.HeaderBannerSection_gSuKmCU$lambda$28$0(PageViewModel.this, pagerState3, getShowElement);
                                return HeaderBannerSection_gSuKmCU$lambda$28$0;
                            }
                        };
                        $composer8.updateRememberedValue(value$iv11);
                        it$iv10 = value$iv11;
                        ComposerKt.sourceInformationMarkerEnd($composer8);
                        modifier5 = ClickableKt.clickable-oSLSa3U$default(modifier7, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv10, 15, (Object) null);
                        $composer8.endReplaceGroup();
                    }
                    Modifier modifier$iv = aspectRatio$default.then(modifier5);
                    ComposerKt.sourceInformationMarkerStart($composer8, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    modifier3 = modifier6;
                    Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
                    MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                    int $changed$iv$iv = (0 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer8, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer8, 0));
                    CompositionLocalMap localMap$iv$iv = $composer8.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer8, modifier$iv);
                    Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
                    int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer8, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!($composer8.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer8.startReusableNode();
                    if ($composer8.getInserting()) {
                        factory$iv$iv$iv = factory$iv$iv$iv3;
                        $composer8.createNode(factory$iv$iv$iv);
                    } else {
                        factory$iv$iv$iv = factory$iv$iv$iv3;
                        $composer8.useNode();
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer8);
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
                    int i4 = ($changed$iv$iv$iv >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer8, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    int $changed2 = ((0 >> 6) & 112) | 6;
                    BoxScope $this$HeaderBannerSection_gSuKmCU_u24lambda_u2429 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart($composer8, -1709964892, "C396@16659L25:HeaderBannerSection.kt#o90vz8");
                    final CollectorHolder collectorHolder = ExposerKt.rememberCollectorHolder($composer8, 0);
                    if (pageCount > 0) {
                        $composer8.startReplaceGroup(-1709905466);
                        ComposerKt.sourceInformation($composer8, "407@17169L651,402@16860L960,420@17948L11594,398@16726L12816");
                        Modifier modifier8 = Modifier.Companion;
                        int $changed$iv$iv$iv2 = pagerState3.hashCode();
                        String str2 = "header_banner_pager_" + isInPreview8 + "_" + $changed$iv$iv$iv2;
                        Modifier modifier9 = modifier8;
                        ComposerKt.sourceInformationMarkerStart($composer8, 914675090, str);
                        boolean invalid$iv9 = $composer8.changedInstance(pageViewModel4) | (($dirty2 & 29360128) == 8388608) | $composer8.changed(pagerState3) | $composer8.changed(getShowElement);
                        Object it$iv11 = $composer8.rememberedValue();
                        if (invalid$iv9) {
                        }
                        Object value$iv12 = new Function0() { // from class: kntr.app.mall.product.details.page.ui.components.HeaderBannerSectionKt$$ExternalSyntheticLambda1
                            public final Object invoke() {
                                Unit HeaderBannerSection_gSuKmCU$lambda$29$0$0;
                                HeaderBannerSection_gSuKmCU$lambda$29$0$0 = HeaderBannerSectionKt.HeaderBannerSection_gSuKmCU$lambda$29$0$0(PageViewModel.this, isInPreview8, pagerState3, getShowElement);
                                return HeaderBannerSection_gSuKmCU$lambda$29$0$0;
                            }
                        };
                        $composer8.updateRememberedValue(value$iv12);
                        it$iv11 = value$iv12;
                        ComposerKt.sourceInformationMarkerEnd($composer8);
                        list = null;
                        $composer6 = $composer8;
                        $composer$iv = $composer8;
                        final float f2 = scale;
                        PagerKt.HorizontalPager--8jOkeI(pagerState3, SizeKt.fillMaxWidth$default(ExposerKt.reportOnExposure(modifier9, str2, collectorHolder, null, false, 0.5f, 0, 500L, (Function0) it$iv11, $composer8, 12779526, 44), 0.0f, 1, (Object) null), (PaddingValues) null, (PageSize) null, 0, 0.0f, (Alignment.Vertical) null, (TargetedFlingBehavior) null, false, false, (Function1) null, (NestedScrollConnection) null, (SnapPosition) null, (OverscrollEffect) null, ComposableLambdaKt.rememberComposableLambda(-1630165981, true, new Function4() { // from class: kntr.app.mall.product.details.page.ui.components.HeaderBannerSectionKt$$ExternalSyntheticLambda2
                            public final Object invoke(Object obj4, Object obj5, Object obj6, Object obj7) {
                                Unit HeaderBannerSection_gSuKmCU$lambda$29$1;
                                HeaderBannerSection_gSuKmCU$lambda$29$1 = HeaderBannerSectionKt.HeaderBannerSection_gSuKmCU$lambda$29$1(isInPreview8, pagerState3, collectorHolder, pageViewModel4, videoViewModel, f2, videoSkin, function2, skuInfoFloor, upSayModel, function22, commentFloor, listState, imageList, widthPixel, heightPixel, headerFloor, basicInfoFloor, (PagerScope) obj4, ((Integer) obj5).intValue(), (Composer) obj6, ((Integer) obj7).intValue());
                                return HeaderBannerSection_gSuKmCU$lambda$29$1;
                            }
                        }, $composer6, 54), $composer6, 0, 24576, 16380);
                        if (isInPreview8) {
                            $composer$iv$iv$iv = $composer8;
                            $composer5 = $composer8;
                            $composer6.startReplaceGroup(-1726896101);
                            $composer6.endReplaceGroup();
                        } else {
                            $composer6.startReplaceGroup(-1697545394);
                            ComposerKt.sourceInformation($composer6, "624@29592L365");
                            Modifier modifier$iv2 = $this$HeaderBannerSection_gSuKmCU_u24lambda_u2429.align(Modifier.Companion, Alignment.Companion.getBottomEnd());
                            ComposerKt.sourceInformationMarkerStart($composer6, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                            Alignment contentAlignment$iv2 = Alignment.Companion.getTopStart();
                            MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
                            int $changed$iv$iv2 = (0 << 3) & 112;
                            ComposerKt.sourceInformationMarkerStart($composer6, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer6, 0));
                            CompositionLocalMap localMap$iv$iv2 = $composer6.getCurrentCompositionLocalMap();
                            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer6, modifier$iv2);
                            Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
                            int $changed$iv$iv$iv3 = (($changed$iv$iv2 << 6) & 896) | 6;
                            $composer5 = $composer8;
                            ComposerKt.sourceInformationMarkerStart($composer6, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                            if (!($composer6.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            $composer6.startReusableNode();
                            if ($composer6.getInserting()) {
                                factory$iv$iv$iv2 = factory$iv$iv$iv4;
                                $composer6.createNode(factory$iv$iv$iv2);
                            } else {
                                factory$iv$iv$iv2 = factory$iv$iv$iv4;
                                $composer6.useNode();
                            }
                            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer6);
                            $composer$iv$iv$iv = $composer8;
                            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
                            int i5 = ($changed$iv$iv$iv3 >> 6) & 14;
                            ComposerKt.sourceInformationMarkerStart($composer6, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                            BoxScope boxScope = BoxScopeInstance.INSTANCE;
                            int i6 = ((0 >> 6) & 112) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer6, 2003757643, "C629@29758L181:HeaderBannerSection.kt#o90vz8");
                            HeaderIndicator(pagerState3, pageViewModel4, scale, null, $composer6, 0, 8);
                            ComposerKt.sourceInformationMarkerEnd($composer6);
                            ComposerKt.sourceInformationMarkerEnd($composer6);
                            $composer6.endNode();
                            ComposerKt.sourceInformationMarkerEnd($composer6);
                            ComposerKt.sourceInformationMarkerEnd($composer6);
                            ComposerKt.sourceInformationMarkerEnd($composer6);
                            $composer6.endReplaceGroup();
                        }
                    } else {
                        $composer$iv$iv$iv = $composer8;
                        $composer5 = $composer8;
                        $composer6 = $composer8;
                        $composer$iv = $composer8;
                        list = null;
                        $composer6.startReplaceGroup(-1726896101);
                    }
                    $composer6.endReplaceGroup();
                    BasicInfoFloor.BulletScreen crowdfundingBulletScreenVO = basicInfoFloor.getCrowdfundingBulletScreenVO();
                    List bulletScreenList = crowdfundingBulletScreenVO != null ? crowdfundingBulletScreenVO.getBulletScreenList() : list;
                    if (!isInPreview8) {
                        List list2 = bulletScreenList;
                        if (!(list2 == null || list2.isEmpty())) {
                            z2 = true;
                            showBulletScreen = z2;
                            if (showBulletScreen) {
                                $composer6.startReplaceGroup(-1726896101);
                            } else {
                                $composer6.startReplaceGroup(-1696918357);
                                ComposerKt.sourceInformation($composer6, "643@30227L152");
                                BulletTickerKt.m544BulletTickerEUb7tLY($this$HeaderBannerSection_gSuKmCU_u24lambda_u2429, f, bulletScreenList, scale, null, $composer6, ($changed2 & 14) | (($dirty2 << 3) & 112), 8);
                            }
                            $composer6.endReplaceGroup();
                            ComposerKt.sourceInformationMarkerEnd($composer6);
                            ComposerKt.sourceInformationMarkerEnd($composer$iv);
                            $composer$iv$iv$iv.endNode();
                            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
                            ComposerKt.sourceInformationMarkerEnd($composer8);
                            ComposerKt.sourceInformationMarkerEnd($composer8);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            isInPreview2 = isInPreview8;
                            $composer2 = $composer5;
                        }
                    }
                    z2 = false;
                    showBulletScreen = z2;
                    if (showBulletScreen) {
                    }
                    $composer6.endReplaceGroup();
                    ComposerKt.sourceInformationMarkerEnd($composer6);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv);
                    $composer$iv$iv$iv.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
                    ComposerKt.sourceInformationMarkerEnd($composer8);
                    ComposerKt.sourceInformationMarkerEnd($composer8);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    isInPreview2 = isInPreview8;
                    $composer2 = $composer5;
                }
            } else {
                modifier4 = modifier2;
                pageViewModel = pageViewModel3;
                isInPreview3 = isInPreview5;
                $composer3 = $composer7;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            ScopeUpdateScope endRestartGroup2 = $composer3.endRestartGroup();
            if (endRestartGroup2 != null) {
                final boolean isInPreview9 = isInPreview3;
                final Modifier modifier10 = modifier4;
                endRestartGroup2.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.HeaderBannerSectionKt$$ExternalSyntheticLambda13
                    public final Object invoke(Object obj4, Object obj5) {
                        Unit HeaderBannerSection_gSuKmCU$lambda$2;
                        HeaderBannerSection_gSuKmCU$lambda$2 = HeaderBannerSectionKt.HeaderBannerSection_gSuKmCU$lambda$2(f, vmWrapper, videoVmWrapper, listState, function2, function22, modifier10, isInPreview9, $changed, i, (Composer) obj4, ((Integer) obj5).intValue());
                        return HeaderBannerSection_gSuKmCU$lambda$2;
                    }
                });
                return;
            }
            return;
        }
        $composer2 = $composer7;
        $composer2.skipToGroupEnd();
        modifier3 = modifier2;
        isInPreview2 = z;
        ScopeUpdateScope endRestartGroup3 = $composer2.endRestartGroup();
        if (endRestartGroup3 != null) {
            final Modifier modifier11 = modifier3;
            final boolean z3 = isInPreview2;
            endRestartGroup3.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.HeaderBannerSectionKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj4, Object obj5) {
                    Unit HeaderBannerSection_gSuKmCU$lambda$30;
                    HeaderBannerSection_gSuKmCU$lambda$30 = HeaderBannerSectionKt.HeaderBannerSection_gSuKmCU$lambda$30(f, vmWrapper, videoVmWrapper, listState, function2, function22, modifier11, z3, $changed, i, (Composer) obj4, ((Integer) obj5).intValue());
                    return HeaderBannerSection_gSuKmCU$lambda$30;
                }
            });
        }
    }

    private static final List<ContentModule> HeaderBannerSection_gSuKmCU$lambda$0(State<? extends List<? extends ContentModule>> state) {
        Object thisObj$iv = state.getValue();
        return (List) thisObj$iv;
    }

    private static final TopContainerState HeaderBannerSection_gSuKmCU$lambda$3(State<TopContainerState> state) {
        Object thisObj$iv = state.getValue();
        return (TopContainerState) thisObj$iv;
    }

    private static final UiScaleModel HeaderBannerSection_gSuKmCU$lambda$6(State<UiScaleModel> state) {
        Object thisObj$iv = state.getValue();
        return (UiScaleModel) thisObj$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PagerState HeaderBannerSection_gSuKmCU$lambda$7(State<? extends PagerState> state) {
        Object thisObj$iv = state.getValue();
        return (PagerState) thisObj$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PagerState HeaderBannerSection_gSuKmCU$lambda$8(State<? extends PagerState> state) {
        Object thisObj$iv = state.getValue();
        return (PagerState) thisObj$iv;
    }

    private static final boolean HeaderBannerSection_gSuKmCU$lambda$10(MutableState<Boolean> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void HeaderBannerSection_gSuKmCU$lambda$11(MutableState<Boolean> mutableState, boolean z) {
        Object value$iv = Boolean.valueOf(z);
        mutableState.setValue(value$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float HeaderBannerSection_gSuKmCU$lambda$15(MutableFloatState $accumulatedOffsetPx$delegate) {
        FloatState $this$getValue$iv = (FloatState) $accumulatedOffsetPx$delegate;
        return $this$getValue$iv.getFloatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean HeaderBannerSection_gSuKmCU$lambda$18(MutableState<Boolean> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void HeaderBannerSection_gSuKmCU$lambda$19(MutableState<Boolean> mutableState, boolean z) {
        Object value$iv = Boolean.valueOf(z);
        mutableState.setValue(value$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void HeaderBannerSection_gSuKmCU$scrollToDetail(PageViewModel pageViewModel, CoroutineScope scope, LazyStaggeredGridState $listState) {
        Integer targetIndex = pageViewModel.getListKeyToIndexMap().get(FloorType.DETAIL_DESC.getKey());
        if (targetIndex != null) {
            pageViewModel.scrollToTab$product_details_page_debug(targetIndex.intValue(), scope, $listState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String HeaderBannerSection_gSuKmCU$lambda$27$0(PageViewModel $pageViewModel, int page) {
        Integer bannerVideoIndex = $pageViewModel.getBannerVideoIndex();
        if (bannerVideoIndex != null && page == bannerVideoIndex.intValue()) {
            return "itemvideo";
        }
        Integer bannerSkuIndex = $pageViewModel.getBannerSkuIndex();
        if (bannerSkuIndex != null && page == bannerSkuIndex.intValue()) {
            return "sku";
        }
        Integer bannerCommentOrUpSayIndex = $pageViewModel.getBannerCommentOrUpSayIndex();
        if (bannerCommentOrUpSayIndex != null && page == bannerCommentOrUpSayIndex.intValue()) {
            return $pageViewModel.getUseUpSay() ? "upvideo" : "commentpic";
        }
        Integer bannerIpFeedRecommendIndex = $pageViewModel.getBannerIpFeedRecommendIndex();
        if (bannerIpFeedRecommendIndex != null && page == bannerIpFeedRecommendIndex.intValue()) {
            return "recommend";
        }
        return "itempicture";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HeaderBannerSection_gSuKmCU$lambda$28$0(PageViewModel $pageViewModel, PagerState $pagerState, Function1 $getShowElement) {
        $pageViewModel.toggleHeaderFullScreenPreview$product_details_page_debug(true);
        PageActionHandler.trackEvent$product_details_page_debug$default($pageViewModel.getActionHandler$product_details_page_debug(), TrackConsts.MALL_MALL_DETAIL_MAIN_PICTURE_0_CLICK, MapsKt.mapOf(new Pair[]{TuplesKt.to("index", String.valueOf($pagerState.getCurrentPage() + 1)), TuplesKt.to("show_element", $getShowElement.invoke(Integer.valueOf($pagerState.getCurrentPage())))}), true, false, 8, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HeaderBannerSection_gSuKmCU$lambda$29$0$0(PageViewModel $pageViewModel, boolean $isInPreview, PagerState $pagerState, Function1 $getShowElement) {
        PageActionHandler actionHandler$product_details_page_debug = $pageViewModel.getActionHandler$product_details_page_debug();
        Pair[] pairArr = new Pair[3];
        pairArr[0] = TuplesKt.to("show_type", $isInPreview ? "1" : "0");
        pairArr[1] = TuplesKt.to("index", String.valueOf($pagerState.getCurrentPage() + 1));
        pairArr[2] = TuplesKt.to("show_element", $getShowElement.invoke(Integer.valueOf($pagerState.getCurrentPage())));
        PageActionHandler.trackEvent$product_details_page_debug$default(actionHandler$product_details_page_debug, TrackConsts.MALL_MALL_DETAIL_PRODUCT_ALL_SHOW, MapsKt.mapOf(pairArr), false, false, 8, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0098, code lost:
        if (r6 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0260, code lost:
        if (r5 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L136;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0299, code lost:
        if (r3 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L141;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x02d0, code lost:
        if (r6 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L146;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0938  */
    /* JADX WARN: Type inference failed for: r0v153 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit HeaderBannerSection_gSuKmCU$lambda$29$1(boolean $isInPreview, PagerState $pagerState, CollectorHolder $collectorHolder, final PageViewModel $pageViewModel, VideoPlayerViewModel $videoViewModel, float $scale, VideoSkinConfigDTO $videoSkin, Function2 $movableVideoPlayerView, SkuInfoFloor $skuInfoFloor, BasicInfoFloor.NewUpSayModel $upSayModel, Function2 $movableUpSayVideoView, CommentInfoApiService.CommentInfoResponse.CommentInfoData $commentFloor, LazyStaggeredGridState $listState, List $imageList, int $widthPixel, int $heightPixel, HeaderFloor $headerFloor, BasicInfoFloor $basicInfoFloor, PagerScope $this$HorizontalPager, final int page, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        Composer $composer$iv$iv$iv;
        Composer $composer$iv;
        Composer $composer2;
        Composer $composer$iv$iv;
        Composer $composer3;
        int i;
        Composer $composer4;
        int i2;
        Function0 factory$iv$iv$iv2;
        Modifier materialized$iv$iv;
        MeasurePolicy measurePolicy$iv$iv;
        Composer $composer$iv$iv2;
        Composer $composer$iv$iv$iv2;
        Composer $composer$iv2;
        Composer $composer5;
        Intrinsics.checkNotNullParameter($this$HorizontalPager, "$this$HorizontalPager");
        ComposerKt.sourceInformation($composer, "CN(page)429@18408L512,424@18072L848,421@17974L11554:HeaderBannerSection.kt#o90vz8");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1630165981, $changed, -1, "kntr.app.mall.product.details.page.ui.components.HeaderBannerSection.<anonymous>.<anonymous> (HeaderBannerSection.kt:421)");
        }
        String str = "header_banner_page_" + $isInPreview + "_" + page + "_" + $pagerState.hashCode();
        Modifier modifier = Modifier.Companion;
        ComposerKt.sourceInformationMarkerStart($composer, 1073570531, "CC(remember):HeaderBannerSection.kt#9igjgp");
        boolean invalid$iv = $composer.changedInstance($pageViewModel) | (((($changed & 112) ^ 48) > 32 && $composer.changed(page)) || ($changed & 48) == 32);
        Object it$iv = $composer.rememberedValue();
        if (invalid$iv) {
        }
        Object value$iv = new Function0() { // from class: kntr.app.mall.product.details.page.ui.components.HeaderBannerSectionKt$$ExternalSyntheticLambda11
            public final Object invoke() {
                Unit HeaderBannerSection_gSuKmCU$lambda$29$1$0$0;
                HeaderBannerSection_gSuKmCU$lambda$29$1$0$0 = HeaderBannerSectionKt.HeaderBannerSection_gSuKmCU$lambda$29$1$0$0(PageViewModel.this, page);
                return HeaderBannerSection_gSuKmCU$lambda$29$1$0$0;
            }
        };
        $composer.updateRememberedValue(value$iv);
        it$iv = value$iv;
        ComposerKt.sourceInformationMarkerEnd($composer);
        Modifier modifier$iv = ExposerKt.reportOnExposure(modifier, str, $collectorHolder, null, false, 0.5f, 0, 500L, (Function0) it$iv, $composer, 12779526, 44);
        ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
        Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
        MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
        int $changed$iv$iv = (0 << 3) & 112;
        ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
        int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
        CompositionLocalMap localMap$iv$iv = $composer.getCurrentCompositionLocalMap();
        Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer, modifier$iv);
        Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
        int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
        ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
        if (!($composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        $composer.startReusableNode();
        if ($composer.getInserting()) {
            factory$iv$iv$iv = factory$iv$iv$iv3;
            $composer.createNode(factory$iv$iv$iv);
        } else {
            factory$iv$iv$iv = factory$iv$iv$iv3;
            $composer.useNode();
        }
        Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer);
        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
        Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
        Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
        int i3 = ($changed$iv$iv$iv >> 6) & 14;
        ComposerKt.sourceInformationMarkerStart($composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
        BoxScope boxScope = BoxScopeInstance.INSTANCE;
        int i4 = ((0 >> 6) & 112) | 6;
        ComposerKt.sourceInformationMarkerStart($composer, 90915014, "C:HeaderBannerSection.kt#o90vz8");
        Integer bannerVideoIndex = $pageViewModel.getBannerVideoIndex();
        if (bannerVideoIndex == null) {
            $composer$iv$iv$iv = $composer;
            $composer$iv = $composer;
            $composer2 = $composer;
            $composer$iv$iv = $composer;
        } else if (page == bannerVideoIndex.intValue()) {
            $composer.startReplaceGroup(90795074);
            ComposerKt.sourceInformation($composer, "445@19246L21,446@19340L21,447@19448L21,448@19523L27,449@19598L27,450@19673L27,443@19100L2263");
            boolean booleanValue = ((Boolean) SnapshotStateKt.collectAsState($videoViewModel.getPauseFlow(), false, (CoroutineContext) null, $composer, 48, 2).getValue()).booleanValue();
            boolean booleanValue2 = ((Boolean) SnapshotStateKt.collectAsState($videoViewModel.getMutedFlow(), false, (CoroutineContext) null, $composer, 48, 2).getValue()).booleanValue();
            boolean booleanValue3 = ((Boolean) SnapshotStateKt.collectAsState($videoViewModel.getPauseByOtherFlow(), false, (CoroutineContext) null, $composer, 48, 2).getValue()).booleanValue();
            ComposerKt.sourceInformationMarkerStart($composer, -1382533148, "CC(remember):HeaderBannerSection.kt#9igjgp");
            boolean invalid$iv2 = $composer.changedInstance($videoViewModel);
            Object it$iv2 = $composer.rememberedValue();
            if (invalid$iv2) {
            }
            Object value$iv2 = (KFunction) new HeaderBannerSectionKt$HeaderBannerSection$8$2$2$1$1($videoViewModel);
            $composer.updateRememberedValue(value$iv2);
            it$iv2 = value$iv2;
            Function1 function1 = (KFunction) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, -1382530748, "CC(remember):HeaderBannerSection.kt#9igjgp");
            boolean invalid$iv3 = $composer.changedInstance($videoViewModel);
            Object it$iv3 = $composer.rememberedValue();
            if (invalid$iv3) {
            }
            Object value$iv3 = (KFunction) new HeaderBannerSectionKt$HeaderBannerSection$8$2$2$2$1($videoViewModel);
            $composer.updateRememberedValue(value$iv3);
            it$iv3 = value$iv3;
            Function0 function0 = (KFunction) it$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, -1382528348, "CC(remember):HeaderBannerSection.kt#9igjgp");
            boolean invalid$iv4 = $composer.changedInstance($videoViewModel);
            Object it$iv4 = $composer.rememberedValue();
            if (invalid$iv4) {
            }
            Object value$iv4 = (KFunction) new HeaderBannerSectionKt$HeaderBannerSection$8$2$2$3$1($videoViewModel);
            $composer.updateRememberedValue(value$iv4);
            it$iv4 = value$iv4;
            Function0 function02 = (KFunction) it$iv4;
            ComposerKt.sourceInformationMarkerEnd($composer);
            SimplePlayer simplePlayer = $videoViewModel.getSimplePlayer();
            Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
            float dpScaled = $isInPreview ? ProvideUiScaleKt.dpScaled(50, $scale) : ProvideUiScaleKt.dpScaled(100, $scale);
            Brush.Companion companion = Brush.Companion;
            Color[] colorArr = new Color[2];
            colorArr[0] = Color.box-impl(Color.Companion.getTransparent-0d7_KjU());
            colorArr[1] = Color.box-impl(Color.copy-wmQWz5c$default(Color.Companion.getBlack-0d7_KjU(), $isInPreview ? 0.56f : 0.8f, 0.0f, 0.0f, 0.0f, 14, (Object) null));
            $composer$iv$iv$iv = $composer;
            $composer$iv = $composer;
            $composer$iv$iv = $composer;
            VideoPlayerComponentKt.m563VideoPlayerComponentVmd5ePE($isInPreview, booleanValue2, booleanValue, booleanValue3, function1, function02, function0, simplePlayer, $movableVideoPlayerView, $scale, dpScaled, fillMaxSize$default, Brush.Companion.verticalGradient-8A-3gB4$default(companion, CollectionsKt.listOf(colorArr), 0.0f, 0.0f, 0, 14, (Object) null), $videoSkin != null ? $videoSkin.getProgressBarColor() : null, $videoSkin != null ? $videoSkin.getProgressBarIcon() : null, $composer, 0, 48, 0);
            $composer.endReplaceGroup();
            $composer3 = $composer;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            $composer$iv$iv$iv.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            return Unit.INSTANCE;
        } else {
            $composer$iv$iv$iv = $composer;
            $composer$iv = $composer;
            $composer2 = $composer;
            $composer$iv$iv = $composer;
        }
        Integer bannerSkuIndex = $pageViewModel.getBannerSkuIndex();
        if (bannerSkuIndex == null) {
            i = page;
            $composer4 = $composer2;
        } else {
            i = page;
            if (i == bannerSkuIndex.intValue()) {
                Composer $composer6 = $composer2;
                $composer6.startReplaceGroup(93065483);
                ComposerKt.sourceInformation($composer6, "483@21514L305");
                Intrinsics.checkNotNull($skuInfoFloor);
                SkuInfoHeaderComponentKt.SkuInfoHeaderComponent($skuInfoFloor, $isInPreview, $pageViewModel, SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), $composer6, 3072, 0);
                $composer6.endReplaceGroup();
                $composer3 = $composer6;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                $composer$iv$iv$iv.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
                ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
                ComposerKt.sourceInformationMarkerEnd($composer);
                if (ComposerKt.isTraceInProgress()) {
                }
                return Unit.INSTANCE;
            }
            $composer4 = $composer2;
        }
        Integer bannerCommentOrUpSayIndex = $pageViewModel.getBannerCommentOrUpSayIndex();
        if (bannerCommentOrUpSayIndex == null) {
            $composer3 = $composer4;
        } else if (i == bannerCommentOrUpSayIndex.intValue()) {
            $composer4.startReplaceGroup(93589135);
            ComposerKt.sourceInformation($composer4, "");
            if ($pageViewModel.getUseUpSay()) {
                $composer4.startReplaceGroup(93665798);
                ComposerKt.sourceInformation($composer4, "495@22097L174,502@22518L21,503@22621L21,507@22868L21,509@22992L32,510@23076L32,511@23160L32,499@22304L1547");
                int indicatorCount = rememberHeaderIndicatorCount($pagerState, $pageViewModel, $composer4, 0);
                Composer composer = $composer4;
                boolean booleanValue4 = ((Boolean) SnapshotStateKt.collectAsState($videoViewModel.getUpSayMutedFlow(), false, (CoroutineContext) null, composer, 48, 2).getValue()).booleanValue();
                boolean booleanValue5 = ((Boolean) SnapshotStateKt.collectAsState($videoViewModel.getUpSayPauseFlow(), false, (CoroutineContext) null, composer, 48, 2).getValue()).booleanValue();
                boolean booleanValue6 = ((Boolean) SnapshotStateKt.collectAsState($videoViewModel.getUpSayPauseByOtherFlow(), false, (CoroutineContext) null, composer, 48, 2).getValue()).booleanValue();
                ComposerKt.sourceInformationMarkerStart($composer4, -1382422135, "CC(remember):HeaderBannerSection.kt#9igjgp");
                boolean invalid$iv5 = $composer4.changedInstance($videoViewModel);
                Composer $this$cache$iv = $composer4;
                Object it$iv5 = $this$cache$iv.rememberedValue();
                if (invalid$iv5 || it$iv5 == Composer.Companion.getEmpty()) {
                    Object value$iv5 = (KFunction) new HeaderBannerSectionKt$HeaderBannerSection$8$2$2$4$1($videoViewModel);
                    $this$cache$iv.updateRememberedValue(value$iv5);
                    it$iv5 = value$iv5;
                }
                Function1 function12 = (KFunction) it$iv5;
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerStart($composer4, -1382419447, "CC(remember):HeaderBannerSection.kt#9igjgp");
                boolean invalid$iv6 = $composer4.changedInstance($videoViewModel);
                Composer $this$cache$iv2 = $composer4;
                Object it$iv6 = $this$cache$iv2.rememberedValue();
                if (invalid$iv6 || it$iv6 == Composer.Companion.getEmpty()) {
                    Object value$iv6 = (KFunction) new HeaderBannerSectionKt$HeaderBannerSection$8$2$2$5$1($videoViewModel);
                    $this$cache$iv2.updateRememberedValue(value$iv6);
                    it$iv6 = value$iv6;
                }
                Function0 function03 = (KFunction) it$iv6;
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerStart($composer4, -1382416759, "CC(remember):HeaderBannerSection.kt#9igjgp");
                boolean invalid$iv7 = $composer4.changedInstance($videoViewModel);
                Composer $this$cache$iv3 = $composer4;
                Object it$iv7 = $this$cache$iv3.rememberedValue();
                if (invalid$iv7 || it$iv7 == Composer.Companion.getEmpty()) {
                    Object value$iv7 = (KFunction) new HeaderBannerSectionKt$HeaderBannerSection$8$2$2$6$1($videoViewModel);
                    $this$cache$iv3.updateRememberedValue(value$iv7);
                    it$iv7 = value$iv7;
                }
                Function0 function04 = (KFunction) it$iv7;
                ComposerKt.sourceInformationMarkerEnd($composer4);
                Composer $composer7 = $composer4;
                UpSayComponentKt.m559UpSayComponentGp5xyCo($upSayModel, $isInPreview, booleanValue4, booleanValue5, booleanValue6, function12, function03, function04, $videoViewModel.getUpSayPlayer(), $movableUpSayVideoView, $scale, ProvideUiScaleKt.dpScaled(indicatorCount * 44, $scale), SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), $videoSkin != null ? $videoSkin.getProgressBarColor() : null, $videoSkin != null ? $videoSkin.getProgressBarIcon() : null, $composer7, 0, 384, 0);
                $composer7.endReplaceGroup();
                $composer3 = $composer7;
            } else {
                Composer $composer8 = $composer4;
                if ($commentFloor != null) {
                    $composer3 = $composer8;
                    $composer3.startReplaceGroup(95509368);
                    ComposerKt.sourceInformation($composer3, "523@23947L257");
                    HeaderCommentPreviewKt.HeaderCommentPreview($commentFloor, $pageViewModel, SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), $composer3, 384, 0);
                } else {
                    $composer3 = $composer8;
                    $composer3.startReplaceGroup(71776729);
                }
                $composer3.endReplaceGroup();
            }
            $composer3.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            $composer$iv$iv$iv.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer);
            if (ComposerKt.isTraceInProgress()) {
            }
            return Unit.INSTANCE;
        } else {
            $composer3 = $composer4;
        }
        Integer bannerIpFeedRecommendIndex = $pageViewModel.getBannerIpFeedRecommendIndex();
        if (bannerIpFeedRecommendIndex == null) {
            i2 = page;
        } else {
            i2 = page;
            if (i2 == bannerIpFeedRecommendIndex.intValue()) {
                $composer3.startReplaceGroup(95993681);
                ComposerKt.sourceInformation($composer3, "533@24400L360");
                HeaderIpFeedRecommendComponentKt.HeaderIpFeedRecommendComponent($pageViewModel, $listState, SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), $imageList, $isInPreview, $composer3, 384, 0);
                $composer3.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                $composer$iv$iv$iv.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
                ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
                ComposerKt.sourceInformationMarkerEnd($composer);
                if (ComposerKt.isTraceInProgress()) {
                }
                return Unit.INSTANCE;
            }
        }
        $composer3.startReplaceGroup(96754328);
        ComposerKt.sourceInformation($composer3, "");
        Integer bannerImagesStartIndex = $pageViewModel.getBannerImagesStartIndex();
        int imageIndex = i2 - (bannerImagesStartIndex != null ? bannerImagesStartIndex.intValue() : 0);
        if ($imageList != null) {
            $composer3.startReplaceGroup(96981279);
            ComposerKt.sourceInformation($composer3, "");
            if (imageIndex < 0 || imageIndex >= $imageList.size()) {
                $composer3.startReplaceGroup(71776729);
            } else {
                $composer3.startReplaceGroup(97062995);
                ComposerKt.sourceInformation($composer3, "560@25741L3657");
                ImmutableImageRequest request = new ImageRequest(HelperKt.customizedImageUrl((String) $imageList.get(imageIndex))).m1493requestWidth3VbuI34($widthPixel).m1488requestHeight3VbuI34($heightPixel).build();
                Modifier modifier$iv2 = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
                Composer $composer$iv3 = $composer3;
                ComposerKt.sourceInformationMarkerStart($composer$iv3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                Alignment contentAlignment$iv2 = Alignment.Companion.getTopStart();
                MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
                int $changed$iv$iv2 = (6 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer$iv3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv3, 0));
                CompositionLocalMap localMap$iv$iv2 = $composer$iv3.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer$iv3, modifier$iv2);
                Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer$iv3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer$iv3.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer$iv3.startReusableNode();
                if ($composer$iv3.getInserting()) {
                    factory$iv$iv$iv2 = factory$iv$iv$iv4;
                    $composer$iv3.createNode(factory$iv$iv$iv2);
                } else {
                    factory$iv$iv$iv2 = factory$iv$iv$iv4;
                    $composer$iv3.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer$iv3);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
                int i5 = ($changed$iv$iv$iv2 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer$iv3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                int i6 = ((6 >> 6) & 112) | 6;
                BoxScope $this$HeaderBannerSection_gSuKmCU_u24lambda_u2429_u241_u241_u246 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer$iv3, 1200295227, "C575@26734L1647:HeaderBannerSection.kt#o90vz8");
                String bgImgUrl = $headerFloor != null ? $headerFloor.getBgImgUrl() : null;
                String str2 = bgImgUrl;
                if (str2 == null || str2.length() == 0) {
                    materialized$iv$iv = materialized$iv$iv3;
                    measurePolicy$iv$iv = measurePolicy$iv2;
                    $composer$iv3.startReplaceGroup(1174523004);
                } else {
                    $composer$iv3.startReplaceGroup(1200314818);
                    ComposerKt.sourceInformation($composer$iv3, "569@26394L208");
                    ImmutableImageRequest bgRequest = new ImageRequest(HelperKt.customizedImageUrl(bgImgUrl)).m1493requestWidth3VbuI34($widthPixel).m1488requestHeight3VbuI34($heightPixel).build();
                    materialized$iv$iv = materialized$iv$iv3;
                    measurePolicy$iv$iv = measurePolicy$iv2;
                    BiliImageKt.BiliImage(bgRequest, SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), null, null, null, null, null, null, null, $composer$iv3, 48, 508);
                }
                $composer$iv3.endReplaceGroup();
                BiliImageKt.BiliImage(request, SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), null, null, null, null, null, ComposableSingletons$HeaderBannerSectionKt.INSTANCE.m437getLambda$271627637$product_details_page_debug(), ComposableSingletons$HeaderBannerSectionKt.INSTANCE.getLambda$1598673109$product_details_page_debug(), $composer$iv3, 113246256, 124);
                if (imageIndex != 0 || $basicInfoFloor.getItemsBenefitsInfo() == null) {
                    $composer$iv$iv2 = $composer$iv3;
                    $composer$iv$iv$iv2 = $composer$iv3;
                    $composer$iv2 = $composer$iv3;
                    $composer5 = $composer$iv3;
                    $composer5.startReplaceGroup(1174523004);
                    $composer5.endReplaceGroup();
                } else {
                    $composer$iv3.startReplaceGroup(1202908805);
                    ComposerKt.sourceInformation($composer$iv3, "605@28768L148,603@28591L727");
                    BasicInfoFloor.ItemsBenefitsInfo itemsBenefitsInfo = $basicInfoFloor.getItemsBenefitsInfo();
                    Modifier modifier2 = PaddingKt.padding-3ABfNKs($this$HeaderBannerSection_gSuKmCU_u24lambda_u2429_u241_u241_u246.align(Modifier.Companion, Alignment.Companion.getBottomStart()), ProvideUiScaleKt.dpScaled(16, $scale));
                    ComposerKt.sourceInformationMarkerStart($composer$iv3, -792475398, "CC(remember):HeaderBannerSection.kt#9igjgp");
                    boolean invalid$iv8 = $composer$iv3.changedInstance($pageViewModel);
                    Object value$iv8 = $composer$iv3.rememberedValue();
                    if (!invalid$iv8 && value$iv8 != Composer.Companion.getEmpty()) {
                        ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                        $composer$iv$iv2 = $composer$iv3;
                        $composer$iv$iv$iv2 = $composer$iv3;
                        $composer$iv2 = $composer$iv3;
                        BenefitBadgeComponentKt.BenefitBadgeComponent(itemsBenefitsInfo, value$iv8, $scale, modifier2, $composer$iv3, 0, 0);
                        $composer$iv3.endReplaceGroup();
                        $composer5 = $composer$iv3;
                    }
                    value$iv8 = new Function0() { // from class: kntr.app.mall.product.details.page.ui.components.HeaderBannerSectionKt$$ExternalSyntheticLambda12
                        public final Object invoke() {
                            Unit HeaderBannerSection_gSuKmCU$lambda$29$1$1$6$0$0;
                            HeaderBannerSection_gSuKmCU$lambda$29$1$1$6$0$0 = HeaderBannerSectionKt.HeaderBannerSection_gSuKmCU$lambda$29$1$1$6$0$0(PageViewModel.this);
                            return HeaderBannerSection_gSuKmCU$lambda$29$1$1$6$0$0;
                        }
                    };
                    $composer$iv3.updateRememberedValue(value$iv8);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                    $composer$iv$iv2 = $composer$iv3;
                    $composer$iv$iv$iv2 = $composer$iv3;
                    $composer$iv2 = $composer$iv3;
                    BenefitBadgeComponentKt.BenefitBadgeComponent(itemsBenefitsInfo, value$iv8, $scale, modifier2, $composer$iv3, 0, 0);
                    $composer$iv3.endReplaceGroup();
                    $composer5 = $composer$iv3;
                }
                ComposerKt.sourceInformationMarkerEnd($composer5);
                ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                $composer$iv$iv$iv2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv2);
                ComposerKt.sourceInformationMarkerEnd($composer$iv$iv2);
                ComposerKt.sourceInformationMarkerEnd($composer$iv3);
            }
            $composer3.endReplaceGroup();
        } else {
            $composer3.startReplaceGroup(71776729);
        }
        $composer3.endReplaceGroup();
        $composer3.endReplaceGroup();
        ComposerKt.sourceInformationMarkerEnd($composer3);
        ComposerKt.sourceInformationMarkerEnd($composer$iv);
        $composer$iv$iv$iv.endNode();
        ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
        ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HeaderBannerSection_gSuKmCU$lambda$29$1$0$0(PageViewModel $pageViewModel, int $page) {
        PageActionHandler.trackEvent$product_details_page_debug$default($pageViewModel.getActionHandler$product_details_page_debug(), TrackConsts.MALL_MALL_DETAIL_MAIN_PICTURE_0_SHOW, MapsKt.mapOf(TuplesKt.to("main_picture_number", String.valueOf($page + 1))), false, false, 8, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HeaderBannerSection_gSuKmCU$lambda$29$1$1$6$0$0(PageViewModel $pageViewModel) {
        $pageViewModel.toggleBenefitBottomSheet$product_details_page_debug(true);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v27 */
    public static final void HeaderIndicator(final PagerState pagerState, final PageViewModel pageViewModel, final float scale, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Composer $composer2;
        Modifier modifier3;
        String str;
        boolean hasMultipleItem;
        int firstItemCount;
        int $dirty;
        Function0 factory$iv$iv$iv;
        boolean z;
        Function0 factory$iv$iv$iv2;
        Composer $composer$iv$iv;
        String text;
        float textWidth;
        String showId;
        String clickId;
        Intrinsics.checkNotNullParameter(pagerState, "pagerState");
        Intrinsics.checkNotNullParameter(pageViewModel, "pageViewModel");
        Composer $composer3 = $composer.startRestartGroup(1975026708);
        ComposerKt.sourceInformation($composer3, "C(HeaderIndicator)N(pagerState,pageViewModel,scale,modifier)662@30758L24,677@31250L25,679@31305L2788,743@34098L3496:HeaderBannerSection.kt#o90vz8");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer3.changed(pagerState) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty2 |= $composer3.changedInstance(pageViewModel) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty2 |= $composer3.changed(scale) ? 256 : 128;
        }
        int i2 = i & 8;
        if (i2 != 0) {
            $dirty2 |= 3072;
            modifier2 = modifier;
        } else if (($changed & 3072) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer3.changed(modifier2) ? 2048 : 1024;
        } else {
            modifier2 = modifier;
        }
        int $dirty3 = $dirty2;
        if ($composer3.shouldExecute(($dirty3 & 1171) != 1170, $dirty3 & 1)) {
            Modifier modifier4 = i2 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1975026708, $dirty3, -1, "kntr.app.mall.product.details.page.ui.components.HeaderIndicator (HeaderBannerSection.kt:658)");
            }
            int currentPage = pagerState.getCurrentPage();
            Integer bannerFirstItemCount = pageViewModel.getBannerFirstItemCount();
            int firstItemCount2 = bannerFirstItemCount != null ? bannerFirstItemCount.intValue() : 0;
            final boolean hasMultipleItem2 = pageViewModel.getFullscreenTopTabItems$product_details_page_debug().size() >= 2;
            ComposerKt.sourceInformationMarkerStart($composer3, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart($composer3, 683736516, "CC(remember):Effects.kt#9igjgp");
            Object it$iv$iv = $composer3.rememberedValue();
            if (it$iv$iv == Composer.Companion.getEmpty()) {
                Object value$iv$iv = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer3);
                $composer3.updateRememberedValue(value$iv$iv);
                it$iv$iv = value$iv$iv;
            }
            final CoroutineScope scope = (CoroutineScope) it$iv$iv;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            final TextStyle normalTextStyle = ProvideUiScaleKt.scaled(new TextStyle(0L, TextUnitKt.getSp(12), FontWeight.Companion.getNormal(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, TextAlign.Companion.getJustify-e0LSkKk(), 0, TextUnitKt.getSp(16), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16613369, (DefaultConstructorMarker) null), scale);
            final TextStyle highlightedTextStyle = ProvideUiScaleKt.scaled(new TextStyle(0L, TextUnitKt.getSp(12), FontWeight.Companion.getMedium(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, TextAlign.Companion.getJustify-e0LSkKk(), 0, TextUnitKt.getSp(16), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16613369, (DefaultConstructorMarker) null), scale);
            final CollectorHolder collectorHolder = ExposerKt.rememberCollectorHolder($composer3, 0);
            ComposerKt.sourceInformationMarkerStart($composer3, -374847336, "CC(remember):HeaderBannerSection.kt#9igjgp");
            boolean invalid$iv = (($dirty3 & 14) == 4) | $composer3.changed(hasMultipleItem2);
            Object value$iv = $composer3.rememberedValue();
            if (invalid$iv || value$iv == Composer.Companion.getEmpty()) {
                str = "CC(remember):HeaderBannerSection.kt#9igjgp";
                hasMultipleItem = hasMultipleItem2;
                firstItemCount = firstItemCount2;
                modifier3 = modifier4;
                $dirty = $dirty3;
                value$iv = (Function8) ComposableLambdaKt.composableLambdaInstance(-104185142, true, new Function8() { // from class: kntr.app.mall.product.details.page.ui.components.HeaderBannerSectionKt$$ExternalSyntheticLambda4
                    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8) {
                        Unit HeaderIndicator$lambda$0$0;
                        HeaderIndicator$lambda$0$0 = HeaderBannerSectionKt.HeaderIndicator$lambda$0$0(scale, hasMultipleItem2, scope, pagerState, pageViewModel, collectorHolder, highlightedTextStyle, normalTextStyle, ((Integer) obj).intValue(), ((Integer) obj2).intValue(), (String) obj3, (Dp) obj4, (String) obj5, (String) obj6, (Composer) obj7, ((Integer) obj8).intValue());
                        return HeaderIndicator$lambda$0$0;
                    }
                });
                $composer3.updateRememberedValue(value$iv);
            } else {
                str = "CC(remember):HeaderBannerSection.kt#9igjgp";
                hasMultipleItem = hasMultipleItem2;
                firstItemCount = firstItemCount2;
                modifier3 = modifier4;
                $dirty = $dirty3;
            }
            Function8 normalItem = value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifier$iv = PaddingKt.padding-VpY3zN4$default(BackgroundKt.background-bw27NRU$default(ClipKt.clip(SizeKt.height-3ABfNKs(modifier3, ProvideUiScaleKt.dpScaled(24, scale)), RoundedCornerShapeKt.RoundedCornerShape-a9UjIt4$default(ProvideUiScaleKt.dpScaled(6, scale), 0.0f, 0.0f, 0.0f, 14, (Object) null)), TopContainerKt.m587withOverlayAlphaDxMtmZc(Color.Companion.getBlack-0d7_KjU(), 0.5f), (Shape) null, 2, (Object) null), ProvideUiScaleKt.dpScaled(2, scale), 0.0f, 2, (Object) null);
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getSpaceBetween();
            ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((432 >> 3) & 14) | ((432 >> 3) & 112));
            int $changed$iv$iv = (432 << 3) & 112;
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
            int i3 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i4 = ((432 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 1670387686, "C:HeaderBannerSection.kt#o90vz8");
            Integer bannerImagesStartIndex = pageViewModel.getBannerImagesStartIndex();
            if (bannerImagesStartIndex == null) {
                $composer3.startReplaceGroup(1670375129);
                $composer3.endReplaceGroup();
                $composer$iv$iv = $composer3;
                $composer2 = $composer3;
            } else {
                $composer3.startReplaceGroup(1670375130);
                ComposerKt.sourceInformation($composer3, "*767@35089L246,762@34859L1136");
                bannerImagesStartIndex.intValue();
                int it = currentPage + 1;
                int i5 = firstItemCount;
                final boolean isActive = it <= i5;
                String text2 = isActive ? it + "/" + i5 : "商品";
                Modifier modifier5 = PaddingKt.padding-VpY3zN4$default(SizeKt.fillMaxHeight$default(Modifier.Companion, 0.0f, 1, (Object) null), ProvideUiScaleKt.dpScaled(10, scale), 0.0f, 2, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer3, -1030003656, str);
                boolean invalid$iv2 = $composer3.changed(isActive) | $composer3.changedInstance(scope) | (($dirty & 14) == 4);
                Object it$iv = $composer3.rememberedValue();
                if (invalid$iv2 || it$iv == Composer.Companion.getEmpty()) {
                    z = true;
                    Object value$iv2 = new Function0() { // from class: kntr.app.mall.product.details.page.ui.components.HeaderBannerSectionKt$$ExternalSyntheticLambda5
                        public final Object invoke() {
                            Unit HeaderIndicator$lambda$1$0$0$0;
                            HeaderIndicator$lambda$1$0$0$0 = HeaderBannerSectionKt.HeaderIndicator$lambda$1$0$0$0(isActive, scope, pagerState);
                            return HeaderIndicator$lambda$1$0$0$0;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv2);
                    it$iv = value$iv2;
                } else {
                    z = true;
                }
                ComposerKt.sourceInformationMarkerEnd($composer3);
                Modifier modifier$iv2 = ClickableKt.clickable-oSLSa3U$default(modifier5, hasMultipleItem, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 14, (Object) null);
                Alignment contentAlignment$iv = Alignment.Companion.getCenter();
                ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                int $changed$iv$iv2 = (48 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
                CompositionLocalMap localMap$iv$iv2 = $composer3.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer3, modifier$iv2);
                Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                $composer2 = $composer3;
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
                $composer$iv$iv = $composer3;
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
                int i6 = ($changed$iv$iv$iv2 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScope boxScope = BoxScopeInstance.INSTANCE;
                int i7 = ((48 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, 444424364, "C777@35484L497:HeaderBannerSection.kt#o90vz8");
                boolean isHighlight = (isActive && hasMultipleItem) ? false : false;
                TextKt.Text-Nvy7gAk(text2, (Modifier) null, isHighlight ? Color.Companion.getWhite-0d7_KjU() : ColorKt.Color(4291415248L), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, isHighlight ? highlightedTextStyle : normalTextStyle, $composer3, 0, 0, 131066);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                Unit unit = Unit.INSTANCE;
                $composer3.endReplaceGroup();
                Unit unit2 = Unit.INSTANCE;
            }
            Integer bannerSkuIndex = pageViewModel.getBannerSkuIndex();
            if (bannerSkuIndex == null) {
                $composer3.startReplaceGroup(1671822581);
                $composer3.endReplaceGroup();
            } else {
                $composer3.startReplaceGroup(1671822582);
                ComposerKt.sourceInformation($composer3, "*795@36062L280");
                Integer valueOf = Integer.valueOf(bannerSkuIndex.intValue());
                Integer valueOf2 = Integer.valueOf(currentPage);
                String bannerSkuName = pageViewModel.getBannerSkuName();
                if (bannerSkuName == null) {
                    bannerSkuName = "规格";
                }
                normalItem.invoke(valueOf, valueOf2, bannerSkuName, Dp.box-impl(ProvideUiScaleKt.dpScaled(24, scale)), TrackConsts.MALL_MALL_DETAIL_TYPE_0_SHOW, TrackConsts.MALL_MALL_DETAIL_TYPE_0_CLICK, $composer3, 221184);
                Unit unit3 = Unit.INSTANCE;
                $composer3.endReplaceGroup();
                Unit unit4 = Unit.INSTANCE;
            }
            Integer bannerCommentOrUpSayIndex = pageViewModel.getBannerCommentOrUpSayIndex();
            if (bannerCommentOrUpSayIndex == null) {
                $composer3.startReplaceGroup(1672194085);
                $composer3.endReplaceGroup();
            } else {
                $composer3.startReplaceGroup(1672194086);
                ComposerKt.sourceInformation($composer3, "*820@37056L172");
                int it2 = bannerCommentOrUpSayIndex.intValue();
                if (pageViewModel.getUseUpSay()) {
                    text = "UP说";
                    textWidth = ProvideUiScaleKt.dpScaled(29, scale);
                    showId = TrackConsts.MALL_MALL_DETAIL_PRODUCT_UPVIDEO_SHOW;
                    clickId = TrackConsts.MALL_MALL_DETAIL_PRODUCT_UPVIDEO_CLICK;
                } else {
                    text = "晒图";
                    textWidth = ProvideUiScaleKt.dpScaled(24, scale);
                    showId = TrackConsts.MALL_MALL_DETAIL_PIC_0_SHOW;
                    clickId = TrackConsts.MALL_MALL_DETAIL_PIC_0_CLICK;
                }
                normalItem.invoke(Integer.valueOf(it2), Integer.valueOf(currentPage), text, Dp.box-impl(textWidth), showId, clickId, $composer3, 0);
                Unit unit5 = Unit.INSTANCE;
                $composer3.endReplaceGroup();
                Unit unit6 = Unit.INSTANCE;
            }
            Integer bannerIpFeedRecommendIndex = pageViewModel.getBannerIpFeedRecommendIndex();
            if (bannerIpFeedRecommendIndex == null) {
                $composer3.startReplaceGroup(1673057342);
                $composer3.endReplaceGroup();
            } else {
                $composer3.startReplaceGroup(1673057343);
                ComposerKt.sourceInformation($composer3, "*830@37307L271");
                normalItem.invoke(Integer.valueOf(bannerIpFeedRecommendIndex.intValue()), Integer.valueOf(currentPage), "推荐", Dp.box-impl(ProvideUiScaleKt.dpScaled(24, scale)), TrackConsts.MALL_MALL_DETAIL_PRODUCT_RECOMMEND_SHOW, TrackConsts.MALL_MALL_DETAIL_PRODUCT_RECOMMEND_CLICK, $composer3, 221568);
                Unit unit7 = Unit.INSTANCE;
                $composer3.endReplaceGroup();
                Unit unit8 = Unit.INSTANCE;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier6 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.HeaderBannerSectionKt$$ExternalSyntheticLambda6
                public final Object invoke(Object obj, Object obj2) {
                    Unit HeaderIndicator$lambda$2;
                    HeaderIndicator$lambda$2 = HeaderBannerSectionKt.HeaderIndicator$lambda$2(pagerState, pageViewModel, scale, modifier6, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return HeaderIndicator$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HeaderIndicator$lambda$0$0(float $scale, boolean $hasMultipleItem, final CoroutineScope $scope, final PagerState $pagerState, final PageViewModel $pageViewModel, CollectorHolder $collectorHolder, TextStyle $highlightedTextStyle, TextStyle $normalTextStyle, final int index, final int currentPage, String text, Dp textWidth, final String showId, final String clickId, Composer $composer, int $changed) {
        boolean z;
        int $dirty;
        Modifier reportOnExposure;
        Function0 factory$iv$iv$iv;
        long Color;
        TextStyle textStyle;
        Intrinsics.checkNotNullParameter(text, "text");
        ComposerKt.sourceInformation($composer, "CN(index,currentPage,text,textWidth:c#ui.unit.Dp,showId,clickId)693@31846L612,688@31596L2473:HeaderBannerSection.kt#o90vz8");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer.changed(index) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty2 |= $composer.changed(currentPage) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty2 |= $composer.changed(text) ? 256 : 128;
        }
        if (($changed & 24576) == 0) {
            $dirty2 |= $composer.changed(showId) ? 16384 : 8192;
        }
        if ((196608 & $changed) == 0) {
            $dirty2 |= $composer.changed(clickId) ? 131072 : 65536;
        }
        int $dirty3 = $dirty2;
        if ($composer.shouldExecute((598163 & $dirty3) != 598162, $dirty3 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-104185142, $dirty3, -1, "kntr.app.mall.product.details.page.ui.components.HeaderIndicator.<anonymous>.<anonymous> (HeaderBannerSection.kt:688)");
            }
            Modifier modifier = PaddingKt.padding-VpY3zN4$default(SizeKt.fillMaxHeight$default(Modifier.Companion, 0.0f, 1, (Object) null), ProvideUiScaleKt.dpScaled(10, $scale), 0.0f, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, -1337657778, "CC(remember):HeaderBannerSection.kt#9igjgp");
            boolean invalid$iv = (($dirty3 & 112) == 32) | (($dirty3 & 14) == 4) | $composer.changedInstance($scope) | $composer.changed($pagerState) | ((458752 & $dirty3) == 131072) | $composer.changedInstance($pageViewModel);
            Object value$iv = $composer.rememberedValue();
            if (invalid$iv || value$iv == Composer.Companion.getEmpty()) {
                z = true;
                $dirty = $dirty3;
                value$iv = new Function0() { // from class: kntr.app.mall.product.details.page.ui.components.HeaderBannerSectionKt$$ExternalSyntheticLambda7
                    public final Object invoke() {
                        Unit HeaderIndicator$lambda$0$0$0$0;
                        HeaderIndicator$lambda$0$0$0$0 = HeaderBannerSectionKt.HeaderIndicator$lambda$0$0$0$0(currentPage, index, $scope, clickId, $pageViewModel, $pagerState);
                        return HeaderIndicator$lambda$0$0$0$0;
                    }
                };
                $composer.updateRememberedValue(value$iv);
            } else {
                $dirty = $dirty3;
                z = true;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            Modifier modifier2 = ClickableKt.clickable-oSLSa3U$default(modifier, $hasMultipleItem, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) value$iv, 14, (Object) null);
            String str = showId;
            if ((str == null || str.length() == 0) ? z : false) {
                $composer.startReplaceGroup(1482938920);
                $composer.endReplaceGroup();
                reportOnExposure = (Modifier) Modifier.Companion;
            } else {
                $composer.startReplaceGroup(1483042801);
                ComposerKt.sourceInformation($composer, "714@32972L284,709@32658L598");
                Modifier modifier3 = Modifier.Companion;
                ComposerKt.sourceInformationMarkerStart($composer, -1337622074, "CC(remember):HeaderBannerSection.kt#9igjgp");
                boolean invalid$iv2 = $composer.changedInstance($pageViewModel) | (($dirty & 57344) == 16384 ? z : false);
                Object it$iv = $composer.rememberedValue();
                if (invalid$iv2 || it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv2 = new Function0() { // from class: kntr.app.mall.product.details.page.ui.components.HeaderBannerSectionKt$$ExternalSyntheticLambda8
                        public final Object invoke() {
                            Unit HeaderIndicator$lambda$0$0$1$0;
                            HeaderIndicator$lambda$0$0$1$0 = HeaderBannerSectionKt.HeaderIndicator$lambda$0$0$1$0(PageViewModel.this, showId);
                            return HeaderIndicator$lambda$0$0$1$0;
                        }
                    };
                    $composer.updateRememberedValue(value$iv2);
                    it$iv = value$iv2;
                }
                ComposerKt.sourceInformationMarkerEnd($composer);
                reportOnExposure = ExposerKt.reportOnExposure(modifier3, showId, $collectorHolder, null, false, 0.5f, 0, 500L, (Function0) it$iv, $composer, (($dirty >> 9) & 112) | 12779526, 44);
                $composer.endReplaceGroup();
            }
            Modifier modifier$iv = modifier2.then(reportOnExposure);
            Alignment contentAlignment$iv = Alignment.Companion.getCenter();
            ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (48 << 3) & 112;
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
            int i2 = ((48 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -891796056, "C725@33498L553:HeaderBannerSection.kt#o90vz8");
            boolean isHighlight = (currentPage == index && $hasMultipleItem) ? z : false;
            if (isHighlight) {
                Color = Color.Companion.getWhite-0d7_KjU();
            } else {
                Color = ColorKt.Color(4291415248L);
            }
            if (isHighlight) {
                textStyle = $highlightedTextStyle;
            } else {
                textStyle = $normalTextStyle;
            }
            TextKt.Text-Nvy7gAk(text, (Modifier) null, Color, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, textStyle, $composer, ($dirty >> 6) & 14, 0, 131066);
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
    public static final Unit HeaderIndicator$lambda$0$0$0$0(int $currentPage, int $index, CoroutineScope $scope, String $clickId, PageViewModel $pageViewModel, PagerState $pagerState) {
        if ($currentPage != $index) {
            BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new HeaderBannerSectionKt$HeaderIndicator$normalItem$1$1$1$1$1($pagerState, $index, null), 3, (Object) null);
        }
        String str = $clickId;
        if (!(str == null || str.length() == 0)) {
            PageActionHandler.trackEvent$product_details_page_debug$default($pageViewModel.getActionHandler$product_details_page_debug(), $clickId, null, true, false, 10, null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HeaderIndicator$lambda$0$0$1$0(PageViewModel $pageViewModel, String $showId) {
        PageActionHandler.trackEvent$product_details_page_debug$default($pageViewModel.getActionHandler$product_details_page_debug(), $showId, null, false, false, 10, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HeaderIndicator$lambda$1$0$0$0(boolean $isActive, CoroutineScope $scope, PagerState $pagerState) {
        if (!$isActive) {
            BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new HeaderBannerSectionKt$HeaderIndicator$1$1$1$1$1($pagerState, null), 3, (Object) null);
        }
        return Unit.INSTANCE;
    }

    private static final int rememberHeaderIndicatorCount(PagerState pageState, final PageViewModel pageViewModel, Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, -1622463108, "C(rememberHeaderIndicatorCount)N(pageState,pageViewModel)847@37739L332:HeaderBannerSection.kt#o90vz8");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1622463108, $changed, -1, "kntr.app.mall.product.details.page.ui.components.rememberHeaderIndicatorCount (HeaderBannerSection.kt:846)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, -113914136, "CC(remember):HeaderBannerSection.kt#9igjgp");
        boolean invalid$iv = ((($changed & 14) ^ 6) > 4 && $composer.changed(pageState)) || ($changed & 6) == 4;
        Object it$iv = $composer.rememberedValue();
        if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
            Object value$iv = SnapshotStateKt.derivedStateOf(new Function0() { // from class: kntr.app.mall.product.details.page.ui.components.HeaderBannerSectionKt$$ExternalSyntheticLambda9
                public final Object invoke() {
                    int rememberHeaderIndicatorCount$lambda$0$0;
                    rememberHeaderIndicatorCount$lambda$0$0 = HeaderBannerSectionKt.rememberHeaderIndicatorCount$lambda$0$0(PageViewModel.this);
                    return Integer.valueOf(rememberHeaderIndicatorCount$lambda$0$0);
                }
            });
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
        }
        State count$delegate = (State) it$iv;
        ComposerKt.sourceInformationMarkerEnd($composer);
        int rememberHeaderIndicatorCount$lambda$1 = rememberHeaderIndicatorCount$lambda$1(count$delegate) > 0 ? rememberHeaderIndicatorCount$lambda$1(count$delegate) : 0;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return rememberHeaderIndicatorCount$lambda$1;
    }

    private static final int rememberHeaderIndicatorCount$lambda$1(State<Integer> state) {
        Object thisObj$iv = state.getValue();
        return ((Number) thisObj$iv).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int rememberHeaderIndicatorCount$lambda$0$0(PageViewModel $pageViewModel) {
        Iterable $this$count$iv = CollectionsKt.listOf(new Integer[]{$pageViewModel.getBannerImagesStartIndex(), $pageViewModel.getBannerSkuIndex(), $pageViewModel.getBannerCommentOrUpSayIndex(), $pageViewModel.getBannerIpFeedRecommendIndex()});
        if (($this$count$iv instanceof Collection) && ((Collection) $this$count$iv).isEmpty()) {
            return 0;
        }
        int count$iv = 0;
        for (Object element$iv : $this$count$iv) {
            Integer it = (Integer) element$iv;
            Integer it2 = it != null ? 1 : null;
            if (it2 != null && (count$iv = count$iv + 1) < 0) {
                CollectionsKt.throwCountOverflow();
            }
        }
        return count$iv;
    }

    public static final void DetailPreviewPageComponent(final float scale, Modifier modifier, Composer $composer, final int $changed, final int i) {
        final Modifier modifier2;
        Composer $composer2;
        Modifier modifier3;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Composer $composer3 = $composer.startRestartGroup(134010646);
        ComposerKt.sourceInformation($composer3, "C(DetailPreviewPageComponent)N(scale,modifier)869@38274L949:HeaderBannerSection.kt#o90vz8");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(scale) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        if (!$composer3.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
        } else {
            if (i2 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(134010646, $dirty, -1, "kntr.app.mall.product.details.page.ui.components.DetailPreviewPageComponent (HeaderBannerSection.kt:868)");
            }
            Modifier modifier$iv = SizeKt.wrapContentWidth$default(SizeKt.fillMaxHeight$default(modifier3, 0.0f, 1, (Object) null), (Alignment.Horizontal) null, false, 3, (Object) null);
            Alignment contentAlignment$iv = Alignment.Companion.getCenterStart();
            ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (48 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
            Modifier modifier4 = modifier3;
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
            int i3 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i4 = ((48 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -1348450689, "C873@38409L808:HeaderBannerSection.kt#o90vz8");
            Modifier modifier$iv2 = SizeKt.wrapContentWidth$default(SizeKt.fillMaxHeight$default(PaddingKt.padding-VpY3zN4$default(Modifier.Companion, ProvideUiScaleKt.dpScaled(12, scale), 0.0f, 2, (Object) null), 0.0f, 1, (Object) null), (Alignment.Horizontal) null, false, 3, (Object) null);
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv2 = (384 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer3, modifier$iv2);
            Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            $composer2 = $composer3;
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
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i5 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i6 = ((384 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 395392491, "C879@38756L121,883@38890L41,884@38944L263:HeaderBannerSection.kt#o90vz8");
            ImmutableImageRequest request = new ImageRequest("https://i0.hdslb.com/bfs/kfptfe/floor/baf5f07ec6905eb58c453a5d7116435901c0a18d.png").build();
            BiliImageKt.BiliImage(request, SizeKt.size-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(20, scale)), null, null, null, null, null, null, null, $composer3, 0, 508);
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(8, scale)), $composer3, 0);
            TextKt.Text-Nvy7gAk("释\n放\n查\n看\n商\n品\n详\n情", SizeKt.wrapContentWidth$default(Modifier.Companion, (Alignment.Horizontal) null, false, 3, (Object) null), ColorKt.Color(4288256409L), (TextAutoSize) null, ProvideUiScaleKt.spScaled(11, scale), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, ProvideUiScaleKt.spScaled(11, scale), 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer3, 438, 0, 260072);
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
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier4;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.HeaderBannerSectionKt$$ExternalSyntheticLambda10
                public final Object invoke(Object obj, Object obj2) {
                    Unit DetailPreviewPageComponent$lambda$1;
                    DetailPreviewPageComponent$lambda$1 = HeaderBannerSectionKt.DetailPreviewPageComponent$lambda$1(scale, modifier2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return DetailPreviewPageComponent$lambda$1;
                }
            });
        }
    }
}