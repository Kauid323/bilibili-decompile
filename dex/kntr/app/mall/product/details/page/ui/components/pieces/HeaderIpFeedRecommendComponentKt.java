package kntr.app.mall.product.details.page.ui.components.pieces;

import ComposableSingletons$CustomBottomSheetKt$;
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
import androidx.compose.foundation.layout.FlowLayoutKt;
import androidx.compose.foundation.layout.FlowRowScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
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
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
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
import androidx.compose.ui.unit.TextUnitKt;
import com.bilibili.compose.iconfont.BiliIconfont;
import com.bilibili.compose.theme.BiliTheme;
import java.util.Iterator;
import java.util.List;
import kntr.app.mall.product.details.page.api.IPFeedRecommendV2ApiService;
import kntr.app.mall.product.details.page.api.model.BasicInfoFloor;
import kntr.app.mall.product.details.page.api.model.CoverVO;
import kntr.app.mall.product.details.page.api.model.IpBrandFloor;
import kntr.app.mall.product.details.page.api.model.ProductDetailsResponse;
import kntr.app.mall.product.details.page.api.model.ShopItem;
import kntr.app.mall.product.details.page.ui.components.CollectorHolder;
import kntr.app.mall.product.details.page.ui.components.ExposerKt;
import kntr.app.mall.product.details.page.ui.scale.ProvideUiScaleKt;
import kntr.app.mall.product.details.page.ui.scale.UiScaleModel;
import kntr.app.mall.product.details.page.utils.HelperKt;
import kntr.app.mall.product.details.page.utils.ScreenKt;
import kntr.app.mall.product.details.page.vm.FloorType;
import kntr.app.mall.product.details.page.vm.PageViewModel;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.imageloader.BiliImageKt;
import kntr.base.imageloader.BlurOption;
import kntr.base.imageloader.ImageRequest;
import kntr.base.imageloader.Pixel;
import kntr.base.imageloader.Radius;
import kntr.base.imageloader.Sigma;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: HeaderIpFeedRecommendComponent.kt */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u001aC\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0001¢\u0006\u0002\u0010\r¨\u0006\u000e²\u0006\n\u0010\u000f\u001a\u00020\u0010X\u008a\u0084\u0002²\u0006\f\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u008a\u0084\u0002²\u0006\f\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u008a\u0084\u0002"}, d2 = {"HeaderIpFeedRecommendComponent", "", "pageViewModel", "Lkntr/app/mall/product/details/page/vm/PageViewModel;", "listState", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;", "modifier", "Landroidx/compose/ui/Modifier;", "imageList", "", "", "isInPreview", "", "(Lkntr/app/mall/product/details/page/vm/PageViewModel;Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;Landroidx/compose/ui/Modifier;Ljava/util/List;ZLandroidx/compose/runtime/Composer;II)V", "product-details-page_debug", "scaleModel", "Lkntr/app/mall/product/details/page/ui/scale/UiScaleModel;", "ipFeedRecommendResponse", "Lkntr/app/mall/product/details/page/api/IPFeedRecommendV2ApiService$Response;", "detailResponse", "Lkntr/app/mall/product/details/page/api/model/ProductDetailsResponse;"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class HeaderIpFeedRecommendComponentKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HeaderIpFeedRecommendComponent$lambda$2(PageViewModel pageViewModel, LazyStaggeredGridState lazyStaggeredGridState, Modifier modifier, List list, boolean z, int i, int i2, Composer composer, int i3) {
        HeaderIpFeedRecommendComponent(pageViewModel, lazyStaggeredGridState, modifier, list, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HeaderIpFeedRecommendComponent$lambda$5(PageViewModel pageViewModel, LazyStaggeredGridState lazyStaggeredGridState, Modifier modifier, List list, boolean z, int i, int i2, Composer composer, int i3) {
        HeaderIpFeedRecommendComponent(pageViewModel, lazyStaggeredGridState, modifier, list, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HeaderIpFeedRecommendComponent$lambda$8(PageViewModel pageViewModel, LazyStaggeredGridState lazyStaggeredGridState, Modifier modifier, List list, boolean z, int i, int i2, Composer composer, int i3) {
        HeaderIpFeedRecommendComponent(pageViewModel, lazyStaggeredGridState, modifier, list, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void HeaderIpFeedRecommendComponent(final PageViewModel pageViewModel, final LazyStaggeredGridState listState, Modifier modifier, List<String> list, boolean isInPreview, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        List list2;
        Composer $composer2;
        final boolean isInPreview2;
        Modifier modifier3;
        List imageList;
        boolean isInPreview3;
        Composer $composer3;
        boolean isInPreview4;
        int itemWidth;
        int i2;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Function0 factory$iv$iv$iv3;
        Intrinsics.checkNotNullParameter(pageViewModel, "pageViewModel");
        Intrinsics.checkNotNullParameter(listState, "listState");
        Composer $composer4 = $composer.startRestartGroup(-82844286);
        ComposerKt.sourceInformation($composer4, "C(HeaderIpFeedRecommendComponent)N(pageViewModel,listState,modifier,imageList,isInPreview)61@2800L16,63@2919L16,65@3060L25,66@3112L16,67@3167L7,69@3313L10,69@3324L17,70@3427L16,78@3618L24,88@3968L133,83@3710L391,80@3648L9767:HeaderIpFeedRecommendComponent.kt#v057zd");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer4.changedInstance(pageViewModel) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer4.changed(listState) ? 32 : 16;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty |= $composer4.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty |= 3072;
            list2 = list;
        } else if (($changed & 3072) == 0) {
            list2 = list;
            $dirty |= $composer4.changedInstance(list2) ? 2048 : 1024;
        } else {
            list2 = list;
        }
        int i5 = i & 16;
        if (i5 != 0) {
            $dirty |= 24576;
        } else if (($changed & 24576) == 0) {
            $dirty |= $composer4.changed(isInPreview) ? 16384 : 8192;
        }
        if ($composer4.shouldExecute(($dirty & 9363) != 9362, $dirty & 1)) {
            modifier3 = i3 != 0 ? (Modifier) Modifier.Companion : modifier2;
            imageList = i4 != 0 ? null : list2;
            final boolean isInPreview5 = i5 != 0 ? false : isInPreview;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-82844286, $dirty, -1, "kntr.app.mall.product.details.page.ui.components.pieces.HeaderIpFeedRecommendComponent (HeaderIpFeedRecommendComponent.kt:60)");
            }
            State scaleModel$delegate = SnapshotStateKt.collectAsState(pageViewModel.getUiScaleModelFlow$product_details_page_debug(), (CoroutineContext) null, $composer4, 0, 1);
            final float scale = HeaderIpFeedRecommendComponent$lambda$0(scaleModel$delegate).getScale();
            State ipFeedRecommendResponse$delegate = SnapshotStateKt.collectAsState(pageViewModel.getIpFeedRecommendFlow(), (CoroutineContext) null, $composer4, 0, 1);
            IPFeedRecommendV2ApiService.Response HeaderIpFeedRecommendComponent$lambda$1 = HeaderIpFeedRecommendComponent$lambda$1(ipFeedRecommendResponse$delegate);
            List<ShopItem> ipItemsFeed$product_details_page_debug = pageViewModel.ipItemsFeed$product_details_page_debug(HeaderIpFeedRecommendComponent$lambda$1 != null ? HeaderIpFeedRecommendComponent$lambda$1.getData() : null);
            if (ipItemsFeed$product_details_page_debug != null) {
                final List ipItemsFeed = CollectionsKt.take(ipItemsFeed$product_details_page_debug, 4);
                if (ipItemsFeed != null) {
                    CollectorHolder collectorHolder = ExposerKt.rememberCollectorHolder($composer4, 0);
                    float screenWidth = ScreenKt.getScreenWidth($composer4, 0);
                    CompositionLocal this_$iv = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object consume = $composer4.consume(this_$iv);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    Density $this$HeaderIpFeedRecommendComponent_u24lambda_u243 = (Density) consume;
                    int itemWidth2 = (int) $this$HeaderIpFeedRecommendComponent_u24lambda_u243.toPx-0680j_4(Dp.constructor-impl(Dp.constructor-impl(screenWidth - ProvideUiScaleKt.dpScaled(191, scale)) / 2));
                    final int itemWidthPixel = Pixel.m1517constructorimpl(itemWidth2);
                    float topPadding = WindowInsetsKt.asPaddingValues(WindowInsets_androidKt.getStatusBars(WindowInsets.Companion, $composer4, 6), $composer4, 0).calculateTopPadding-D9Ej5fM();
                    final State detailResponse$delegate = SnapshotStateKt.collectAsState(pageViewModel.getProductDetailsResponse(), (CoroutineContext) null, $composer4, 0, 1);
                    ProductDetailsResponse HeaderIpFeedRecommendComponent$lambda$4 = HeaderIpFeedRecommendComponent$lambda$4(detailResponse$delegate);
                    if (HeaderIpFeedRecommendComponent$lambda$4 != null) {
                        ProductDetailsResponse.ProductDetailsData data = HeaderIpFeedRecommendComponent$lambda$4.getData();
                        if (data != null) {
                            IpBrandFloor ipBrandFloorVO = data.getIpBrandFloorVO();
                            if (ipBrandFloorVO != null) {
                                List<IpBrandFloor.IpRightInfo> ipRightList = ipBrandFloorVO.getIpRightList();
                                if (ipRightList != null) {
                                    IpBrandFloor.IpRightInfo ipRightInfo = (IpBrandFloor.IpRightInfo) CollectionsKt.firstOrNull(ipRightList);
                                    if (ipRightInfo != null) {
                                        ComposerKt.sourceInformationMarkerStart($composer4, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
                                        ComposerKt.sourceInformationMarkerStart($composer4, 683736516, "CC(remember):Effects.kt#9igjgp");
                                        Object value$iv$iv = $composer4.rememberedValue();
                                        if (value$iv$iv == Composer.Companion.getEmpty()) {
                                            value$iv$iv = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer4);
                                            $composer4.updateRememberedValue(value$iv$iv);
                                        }
                                        final CoroutineScope scope = (CoroutineScope) value$iv$iv;
                                        ComposerKt.sourceInformationMarkerEnd($composer4);
                                        ComposerKt.sourceInformationMarkerEnd($composer4);
                                        ComposerKt.sourceInformationMarkerStart($composer4, 1991065991, "CC(remember):HeaderIpFeedRecommendComponent.kt#9igjgp");
                                        boolean invalid$iv = $composer4.changedInstance(pageViewModel) | $composer4.changedInstance(ipItemsFeed) | ((57344 & $dirty) == 16384);
                                        Object it$iv = $composer4.rememberedValue();
                                        if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                                            Object value$iv = new Function0() { // from class: kntr.app.mall.product.details.page.ui.components.pieces.HeaderIpFeedRecommendComponentKt$$ExternalSyntheticLambda4
                                                public final Object invoke() {
                                                    Unit HeaderIpFeedRecommendComponent$lambda$6$0;
                                                    HeaderIpFeedRecommendComponent$lambda$6$0 = HeaderIpFeedRecommendComponentKt.HeaderIpFeedRecommendComponent$lambda$6$0(PageViewModel.this, ipItemsFeed, isInPreview5);
                                                    return HeaderIpFeedRecommendComponent$lambda$6$0;
                                                }
                                            };
                                            $composer4.updateRememberedValue(value$iv);
                                            it$iv = value$iv;
                                        }
                                        ComposerKt.sourceInformationMarkerEnd($composer4);
                                        Modifier modifier$iv = ExposerKt.reportOnExposure(modifier3, "ip_recommend_floor", collectorHolder, null, true, 0.5f, 0, 0L, (Function0) it$iv, $composer4, (($dirty >> 6) & 14) | 221232, 100);
                                        ComposerKt.sourceInformationMarkerStart($composer4, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                                        Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
                                        MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                                        int $changed$iv$iv = (0 << 3) & 112;
                                        ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                                        int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
                                        CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
                                        Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer4, modifier$iv);
                                        Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
                                        int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                                        ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                                        if (!($composer4.getApplier() instanceof Applier)) {
                                            ComposablesKt.invalidApplier();
                                        }
                                        $composer4.startReusableNode();
                                        if ($composer4.getInserting()) {
                                            $composer4.createNode(factory$iv$iv$iv4);
                                        } else {
                                            $composer4.useNode();
                                        }
                                        Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer4);
                                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                        int $dirty2 = $dirty;
                                        Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
                                        Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
                                        int i6 = ($changed$iv$iv$iv >> 6) & 14;
                                        ComposerKt.sourceInformationMarkerStart($composer4, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                                        BoxScope boxScope = BoxScopeInstance.INSTANCE;
                                        int i7 = ((0 >> 6) & 112) | 6;
                                        ComposerKt.sourceInformationMarkerStart($composer4, -242844367, "C104@4501L162,111@4673L8736:HeaderIpFeedRecommendComponent.kt#v057zd");
                                        String backImg = imageList != null ? (String) CollectionsKt.lastOrNull(imageList) : null;
                                        String str = backImg;
                                        if (str == null || StringsKt.isBlank(str)) {
                                            i2 = 1;
                                            $composer4.startReplaceGroup(-247219398);
                                        } else {
                                            $composer4.startReplaceGroup(-243047790);
                                            ComposerKt.sourceInformation($composer4, "95@4209L272");
                                            String $this$asRequest$iv = HelperKt.customizedImageUrl(backImg);
                                            ImageRequest $this$HeaderIpFeedRecommendComponent_u24lambda_u247_u240 = new ImageRequest($this$asRequest$iv);
                                            $this$HeaderIpFeedRecommendComponent_u24lambda_u247_u240.requestBlur(new BlurOption(Radius.m1550constructorimpl(39), Sigma.m1565constructorimpl(39), null));
                                            i2 = 1;
                                            BiliImageKt.BiliImage($this$HeaderIpFeedRecommendComponent_u24lambda_u247_u240.build(), SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), null, null, null, null, null, null, null, $composer4, 48, 508);
                                        }
                                        $composer4.endReplaceGroup();
                                        BoxKt.Box(BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, i2, (Object) null), Color.copy-wmQWz5c$default(Color.Companion.getBlack-0d7_KjU(), 0.4f, 0.0f, 0.0f, 0.0f, 14, (Object) null), (Shape) null, 2, (Object) null), $composer4, 6);
                                        Modifier modifier$iv2 = PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, i2, (Object) null), 0.0f, Dp.constructor-impl(Dp.constructor-impl(topPadding + ProvideUiScaleKt.dpScaled(44, scale)) - ProvideUiScaleKt.dpScaled(8, scale)), 0.0f, 0.0f, 13, (Object) null);
                                        Alignment contentAlignment$iv2 = Alignment.Companion.getCenter();
                                        ComposerKt.sourceInformationMarkerStart($composer4, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                                        MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
                                        int $changed$iv$iv2 = (48 << 3) & 112;
                                        ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                                        int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
                                        CompositionLocalMap localMap$iv$iv2 = $composer4.getCurrentCompositionLocalMap();
                                        Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer4, modifier$iv2);
                                        Function0 factory$iv$iv$iv5 = ComposeUiNode.Companion.getConstructor();
                                        int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                                        ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                                        if (!($composer4.getApplier() instanceof Applier)) {
                                            ComposablesKt.invalidApplier();
                                        }
                                        $composer4.startReusableNode();
                                        if ($composer4.getInserting()) {
                                            $composer4.createNode(factory$iv$iv$iv5);
                                        } else {
                                            $composer4.useNode();
                                        }
                                        Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer4);
                                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                        Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                                        Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
                                        int i8 = ($changed$iv$iv$iv2 >> 6) & 14;
                                        ComposerKt.sourceInformationMarkerStart($composer4, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                                        BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
                                        int i9 = ((48 >> 6) & 112) | 6;
                                        ComposerKt.sourceInformationMarkerStart($composer4, 1853650257, "C120@4970L8429:HeaderIpFeedRecommendComponent.kt#v057zd");
                                        Modifier modifier$iv3 = SizeKt.width-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(200, scale));
                                        Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getCenterHorizontally();
                                        ComposerKt.sourceInformationMarkerStart($composer4, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                                        Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                                        MeasurePolicy measurePolicy$iv3 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer4, ((384 >> 3) & 14) | ((384 >> 3) & 112));
                                        int $changed$iv$iv3 = (384 << 3) & 112;
                                        ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                                        int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
                                        CompositionLocalMap localMap$iv$iv3 = $composer4.getCurrentCompositionLocalMap();
                                        Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer4, modifier$iv3);
                                        Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
                                        int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
                                        ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                                        if (!($composer4.getApplier() instanceof Applier)) {
                                            ComposablesKt.invalidApplier();
                                        }
                                        $composer4.startReusableNode();
                                        if ($composer4.getInserting()) {
                                            factory$iv$iv$iv = factory$iv$iv$iv6;
                                            $composer4.createNode(factory$iv$iv$iv);
                                        } else {
                                            factory$iv$iv$iv = factory$iv$iv$iv6;
                                            $composer4.useNode();
                                        }
                                        Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer4);
                                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
                                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                        Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                                        Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
                                        int i10 = ($changed$iv$iv$iv3 >> 6) & 14;
                                        ComposerKt.sourceInformationMarkerStart($composer4, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                                        ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
                                        int i11 = ((384 >> 6) & 112) | 6;
                                        ComposerKt.sourceInformationMarkerStart($composer4, -2016772318, "C126@5187L883,155@6453L3997,148@6088L4362,230@10641L1212,226@10468L2917:HeaderIpFeedRecommendComponent.kt#v057zd");
                                        Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
                                        ComposerKt.sourceInformationMarkerStart($composer4, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                                        Modifier modifier$iv4 = Modifier.Companion;
                                        Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                                        MeasurePolicy measurePolicy$iv4 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer4, ((384 >> 3) & 14) | ((384 >> 3) & 112));
                                        int $changed$iv$iv4 = (384 << 3) & 112;
                                        ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                                        int compositeKeyHash$iv$iv4 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
                                        CompositionLocalMap localMap$iv$iv4 = $composer4.getCurrentCompositionLocalMap();
                                        Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer4, modifier$iv4);
                                        Function0 factory$iv$iv$iv7 = ComposeUiNode.Companion.getConstructor();
                                        int $changed$iv$iv$iv4 = (($changed$iv$iv4 << 6) & 896) | 6;
                                        ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                                        if (!($composer4.getApplier() instanceof Applier)) {
                                            ComposablesKt.invalidApplier();
                                        }
                                        $composer4.startReusableNode();
                                        if ($composer4.getInserting()) {
                                            factory$iv$iv$iv2 = factory$iv$iv$iv7;
                                            $composer4.createNode(factory$iv$iv$iv2);
                                        } else {
                                            factory$iv$iv$iv2 = factory$iv$iv$iv7;
                                            $composer4.useNode();
                                        }
                                        Composer $this$Layout_u24lambda_u240$iv$iv4 = Updater.constructor-impl($composer4);
                                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, measurePolicy$iv4, ComposeUiNode.Companion.getSetMeasurePolicy());
                                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, localMap$iv$iv4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                        Updater.init-impl($this$Layout_u24lambda_u240$iv$iv4, Integer.valueOf(compositeKeyHash$iv$iv4), ComposeUiNode.Companion.getSetCompositeKeyHash());
                                        Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv4, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, materialized$iv$iv4, ComposeUiNode.Companion.getSetModifier());
                                        int i12 = ($changed$iv$iv$iv4 >> 6) & 14;
                                        ComposerKt.sourceInformationMarkerStart($composer4, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                                        RowScope rowScope = RowScopeInstance.INSTANCE;
                                        int i13 = ((384 >> 6) & 112) | 6;
                                        ComposerKt.sourceInformationMarkerStart($composer4, 2029161748, "C130@5353L14,131@5410L6,129@5300L271,135@5592L460:HeaderIpFeedRecommendComponent.kt#v057zd");
                                        IconKt.Icon-ww6aTOc(BiliIconfont.INSTANCE.getTopic_line_500($composer4, 6), (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(16, scale)), BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getBrand_pink-0d7_KjU(), $composer4, Painter.$stable | 48, 0);
                                        String ipRightName = ipRightInfo.getIpRightName();
                                        if (ipRightName == null) {
                                            ipRightName = "";
                                        }
                                        TextKt.Text-Nvy7gAk(ipRightName, (Modifier) null, Color.Companion.getWhite-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, ProvideUiScaleKt.scaled(new TextStyle(0L, TextUnitKt.getSp(12), FontWeight.Companion.getSemiBold(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(16), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646137, (DefaultConstructorMarker) null), scale), $composer4, 384, 24576, 114682);
                                        ComposerKt.sourceInformationMarkerEnd($composer4);
                                        ComposerKt.sourceInformationMarkerEnd($composer4);
                                        $composer4.endNode();
                                        ComposerKt.sourceInformationMarkerEnd($composer4);
                                        ComposerKt.sourceInformationMarkerEnd($composer4);
                                        ComposerKt.sourceInformationMarkerEnd($composer4);
                                        final boolean z = isInPreview5;
                                        isInPreview2 = isInPreview5;
                                        FlowLayoutKt.FlowRow(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, ProvideUiScaleKt.dpScaled(8, scale), 0.0f, 0.0f, 13, (Object) null), Arrangement.INSTANCE.spacedBy-0680j_4(ProvideUiScaleKt.dpScaled(8, scale)), Arrangement.INSTANCE.spacedBy-0680j_4(ProvideUiScaleKt.dpScaled(8, scale)), (Alignment.Vertical) null, 2, 0, ComposableLambdaKt.rememberComposableLambda(613009568, true, new Function3() { // from class: kntr.app.mall.product.details.page.ui.components.pieces.HeaderIpFeedRecommendComponentKt$$ExternalSyntheticLambda5
                                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                                Unit HeaderIpFeedRecommendComponent$lambda$7$1$0$1;
                                                HeaderIpFeedRecommendComponent$lambda$7$1$0$1 = HeaderIpFeedRecommendComponentKt.HeaderIpFeedRecommendComponent$lambda$7$1$0$1(ipItemsFeed, scale, pageViewModel, z, itemWidthPixel, (FlowRowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                                return HeaderIpFeedRecommendComponent$lambda$7$1$0$1;
                                            }
                                        }, $composer4, 54), $composer4, 1597440, 40);
                                        Modifier modifier4 = PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, ProvideUiScaleKt.dpScaled(8, scale), 0.0f, 0.0f, 13, (Object) null);
                                        ComposerKt.sourceInformationMarkerStart($composer4, 627847031, "CC(remember):HeaderIpFeedRecommendComponent.kt#9igjgp");
                                        boolean invalid$iv2 = $composer4.changed(detailResponse$delegate) | $composer4.changedInstance(pageViewModel) | (($dirty2 & 57344) == 16384) | $composer4.changedInstance(scope) | (($dirty2 & 112) == 32);
                                        Object value$iv2 = $composer4.rememberedValue();
                                        if (invalid$iv2 || value$iv2 == Composer.Companion.getEmpty()) {
                                            value$iv2 = new Function0() { // from class: kntr.app.mall.product.details.page.ui.components.pieces.HeaderIpFeedRecommendComponentKt$$ExternalSyntheticLambda6
                                                public final Object invoke() {
                                                    Unit HeaderIpFeedRecommendComponent$lambda$7$1$0$2$0;
                                                    HeaderIpFeedRecommendComponent$lambda$7$1$0$2$0 = HeaderIpFeedRecommendComponentKt.HeaderIpFeedRecommendComponent$lambda$7$1$0$2$0(PageViewModel.this, isInPreview2, scope, listState, detailResponse$delegate);
                                                    return HeaderIpFeedRecommendComponent$lambda$7$1$0$2$0;
                                                }
                                            };
                                            $composer4.updateRememberedValue(value$iv2);
                                        }
                                        ComposerKt.sourceInformationMarkerEnd($composer4);
                                        Modifier modifier$iv5 = ClickableKt.clickable-oSLSa3U$default(modifier4, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) value$iv2, 15, (Object) null);
                                        Alignment.Horizontal horizontalAlignment$iv2 = Alignment.Companion.getCenterHorizontally();
                                        ComposerKt.sourceInformationMarkerStart($composer4, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                                        Arrangement.Vertical verticalArrangement$iv2 = Arrangement.INSTANCE.getTop();
                                        MeasurePolicy measurePolicy$iv5 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv2, horizontalAlignment$iv2, $composer4, ((384 >> 3) & 14) | ((384 >> 3) & 112));
                                        int $changed$iv$iv5 = (384 << 3) & 112;
                                        ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                                        int compositeKeyHash$iv$iv5 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
                                        CompositionLocalMap localMap$iv$iv5 = $composer4.getCurrentCompositionLocalMap();
                                        Modifier materialized$iv$iv5 = ComposedModifierKt.materializeModifier($composer4, modifier$iv5);
                                        Function0 factory$iv$iv$iv8 = ComposeUiNode.Companion.getConstructor();
                                        int $changed$iv$iv$iv5 = (($changed$iv$iv5 << 6) & 896) | 6;
                                        ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                                        if (!($composer4.getApplier() instanceof Applier)) {
                                            ComposablesKt.invalidApplier();
                                        }
                                        $composer4.startReusableNode();
                                        if ($composer4.getInserting()) {
                                            factory$iv$iv$iv3 = factory$iv$iv$iv8;
                                            $composer4.createNode(factory$iv$iv$iv3);
                                        } else {
                                            factory$iv$iv$iv3 = factory$iv$iv$iv8;
                                            $composer4.useNode();
                                        }
                                        Composer $this$Layout_u24lambda_u240$iv$iv5 = Updater.constructor-impl($composer4);
                                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, measurePolicy$iv5, ComposeUiNode.Companion.getSetMeasurePolicy());
                                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, localMap$iv$iv5, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                        Updater.init-impl($this$Layout_u24lambda_u240$iv$iv5, Integer.valueOf(compositeKeyHash$iv$iv5), ComposeUiNode.Companion.getSetCompositeKeyHash());
                                        Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv5, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, materialized$iv$iv5, ComposeUiNode.Companion.getSetModifier());
                                        int i14 = ($changed$iv$iv$iv5 >> 6) & 14;
                                        ComposerKt.sourceInformationMarkerStart($composer4, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                                        ColumnScope columnScope2 = ColumnScopeInstance.INSTANCE;
                                        int i15 = ((384 >> 6) & 112) | 6;
                                        ComposerKt.sourceInformationMarkerStart($composer4, 340638906, "C273@12877L42,274@12940L427:HeaderIpFeedRecommendComponent.kt#v057zd");
                                        if (Intrinsics.areEqual(pageViewModel.isFromTMFeed(), true)) {
                                            $composer4.startReplaceGroup(328723249);
                                        } else {
                                            $composer4.startReplaceGroup(340649972);
                                            ComposerKt.sourceInformation($composer4, "256@12033L429");
                                            TextKt.Text-Nvy7gAk("您也可以", (Modifier) null, Color.Companion.getWhite-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, ProvideUiScaleKt.scaled(new TextStyle(0L, TextUnitKt.getSp(12), FontWeight.Companion.getNormal(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(16), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646137, (DefaultConstructorMarker) null), scale), $composer4, 390, 0, 131066);
                                        }
                                        $composer4.endReplaceGroup();
                                        String imgUrl = Intrinsics.areEqual(pageViewModel.isFromTMFeed(), true) ? "//i0.hdslb.com/bfs/kfptfe/floor/6ef45889ac0cf9e0f202bb9f506d4b4166439840.png" : "//i0.hdslb.com/bfs/kfptfe/floor/2802b9ef714088479603eb4f238cf12f9bd82ce9.png";
                                        SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(4, scale)), $composer4, 0);
                                        String $this$asRequest$iv2 = HelperKt.customizedImageUrl(imgUrl);
                                        ImageRequest $this$HeaderIpFeedRecommendComponent_u24lambda_u247_u241_u240_u243_u240 = new ImageRequest($this$asRequest$iv2);
                                        $this$HeaderIpFeedRecommendComponent_u24lambda_u247_u241_u240_u243_u240.contentScale(ContentScale.Companion.getFillBounds());
                                        BiliImageKt.BiliImage($this$HeaderIpFeedRecommendComponent_u24lambda_u247_u241_u240_u243_u240.build(), SizeKt.height-3ABfNKs(SizeKt.width-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(122, scale)), ProvideUiScaleKt.dpScaled(28, scale)), null, null, null, null, null, null, null, $composer4, 0, 508);
                                        ComposerKt.sourceInformationMarkerEnd($composer4);
                                        ComposerKt.sourceInformationMarkerEnd($composer4);
                                        $composer4.endNode();
                                        ComposerKt.sourceInformationMarkerEnd($composer4);
                                        ComposerKt.sourceInformationMarkerEnd($composer4);
                                        ComposerKt.sourceInformationMarkerEnd($composer4);
                                        ComposerKt.sourceInformationMarkerEnd($composer4);
                                        ComposerKt.sourceInformationMarkerEnd($composer4);
                                        $composer4.endNode();
                                        ComposerKt.sourceInformationMarkerEnd($composer4);
                                        ComposerKt.sourceInformationMarkerEnd($composer4);
                                        ComposerKt.sourceInformationMarkerEnd($composer4);
                                        ComposerKt.sourceInformationMarkerEnd($composer4);
                                        ComposerKt.sourceInformationMarkerEnd($composer4);
                                        $composer4.endNode();
                                        ComposerKt.sourceInformationMarkerEnd($composer4);
                                        ComposerKt.sourceInformationMarkerEnd($composer4);
                                        ComposerKt.sourceInformationMarkerEnd($composer4);
                                        ComposerKt.sourceInformationMarkerEnd($composer4);
                                        ComposerKt.sourceInformationMarkerEnd($composer4);
                                        $composer4.endNode();
                                        ComposerKt.sourceInformationMarkerEnd($composer4);
                                        ComposerKt.sourceInformationMarkerEnd($composer4);
                                        ComposerKt.sourceInformationMarkerEnd($composer4);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                        $composer2 = $composer4;
                                    } else {
                                        isInPreview4 = isInPreview5;
                                        itemWidth = itemWidth2;
                                    }
                                } else {
                                    isInPreview4 = isInPreview5;
                                    itemWidth = itemWidth2;
                                }
                            } else {
                                isInPreview4 = isInPreview5;
                                itemWidth = itemWidth2;
                            }
                        } else {
                            isInPreview4 = isInPreview5;
                            itemWidth = itemWidth2;
                        }
                    } else {
                        isInPreview4 = isInPreview5;
                        itemWidth = itemWidth2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    ScopeUpdateScope endRestartGroup = $composer4.endRestartGroup();
                    if (endRestartGroup != null) {
                        final Modifier modifier5 = modifier3;
                        final List list3 = imageList;
                        final boolean z2 = isInPreview4;
                        endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.pieces.HeaderIpFeedRecommendComponentKt$$ExternalSyntheticLambda3
                            public final Object invoke(Object obj, Object obj2) {
                                Unit HeaderIpFeedRecommendComponent$lambda$5;
                                HeaderIpFeedRecommendComponent$lambda$5 = HeaderIpFeedRecommendComponentKt.HeaderIpFeedRecommendComponent$lambda$5(PageViewModel.this, listState, modifier5, list3, z2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                                return HeaderIpFeedRecommendComponent$lambda$5;
                            }
                        });
                        return;
                    }
                    return;
                }
                isInPreview3 = isInPreview5;
                $composer3 = $composer4;
            } else {
                isInPreview3 = isInPreview5;
                $composer3 = $composer4;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            ScopeUpdateScope endRestartGroup2 = $composer3.endRestartGroup();
            if (endRestartGroup2 != null) {
                final Modifier modifier6 = modifier3;
                final List list4 = imageList;
                final boolean z3 = isInPreview3;
                endRestartGroup2.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.pieces.HeaderIpFeedRecommendComponentKt$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj, Object obj2) {
                        Unit HeaderIpFeedRecommendComponent$lambda$2;
                        HeaderIpFeedRecommendComponent$lambda$2 = HeaderIpFeedRecommendComponentKt.HeaderIpFeedRecommendComponent$lambda$2(PageViewModel.this, listState, modifier6, list4, z3, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                        return HeaderIpFeedRecommendComponent$lambda$2;
                    }
                });
                return;
            }
            return;
        }
        $composer2 = $composer4;
        $composer2.skipToGroupEnd();
        isInPreview2 = isInPreview;
        modifier3 = modifier2;
        imageList = list2;
        ScopeUpdateScope endRestartGroup3 = $composer2.endRestartGroup();
        if (endRestartGroup3 != null) {
            final Modifier modifier7 = modifier3;
            final List list5 = imageList;
            final boolean z4 = isInPreview2;
            endRestartGroup3.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.pieces.HeaderIpFeedRecommendComponentKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    Unit HeaderIpFeedRecommendComponent$lambda$8;
                    HeaderIpFeedRecommendComponent$lambda$8 = HeaderIpFeedRecommendComponentKt.HeaderIpFeedRecommendComponent$lambda$8(PageViewModel.this, listState, modifier7, list5, z4, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return HeaderIpFeedRecommendComponent$lambda$8;
                }
            });
        }
    }

    private static final UiScaleModel HeaderIpFeedRecommendComponent$lambda$0(State<UiScaleModel> state) {
        Object thisObj$iv = state.getValue();
        return (UiScaleModel) thisObj$iv;
    }

    private static final IPFeedRecommendV2ApiService.Response HeaderIpFeedRecommendComponent$lambda$1(State<IPFeedRecommendV2ApiService.Response> state) {
        Object thisObj$iv = state.getValue();
        return (IPFeedRecommendV2ApiService.Response) thisObj$iv;
    }

    private static final ProductDetailsResponse HeaderIpFeedRecommendComponent$lambda$4(State<ProductDetailsResponse> state) {
        Object thisObj$iv = state.getValue();
        return (ProductDetailsResponse) thisObj$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HeaderIpFeedRecommendComponent$lambda$6$0(PageViewModel $pageViewModel, List $ipItemsFeed, boolean $isInPreview) {
        $pageViewModel.reportIpRecommendShow$product_details_page_debug($ipItemsFeed, $isInPreview);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HeaderIpFeedRecommendComponent$lambda$7$1$0$1(List $ipItemsFeed, float $scale, PageViewModel $pageViewModel, boolean $isInPreview, int $itemWidthPixel, FlowRowScope $this$FlowRow, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        int $changed$iv;
        Composer $composer$iv$iv;
        Composer $composer$iv;
        Composer $composer$iv$iv$iv;
        char c;
        Composer $composer2;
        Function0 factory$iv$iv$iv2;
        Function0 factory$iv$iv$iv3;
        final PageViewModel pageViewModel = $pageViewModel;
        final boolean z = $isInPreview;
        int i = $itemWidthPixel;
        Composer composer = $composer;
        Intrinsics.checkNotNullParameter($this$FlowRow, "$this$FlowRow");
        ComposerKt.sourceInformation(composer, "C*163@6876L381,157@6529L3881:HeaderIpFeedRecommendComponent.kt#v057zd");
        if (!composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(613009568, $changed, -1, "kntr.app.mall.product.details.page.ui.components.pieces.HeaderIpFeedRecommendComponent.<anonymous>.<anonymous>.<anonymous>.<anonymous> (HeaderIpFeedRecommendComponent.kt:156)");
            }
            List $this$forEach$iv = $ipItemsFeed;
            boolean z2 = false;
            Iterator it = $this$forEach$iv.iterator();
            while (it.hasNext()) {
                Object element$iv = it.next();
                final ShopItem item = (ShopItem) element$iv;
                Modifier modifier = BackgroundKt.background-bw27NRU$default(ClipKt.clip(SizeKt.size-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(92, $scale)), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(ProvideUiScaleKt.dpScaled(8, $scale))), Color.copy-wmQWz5c$default(Color.Companion.getWhite-0d7_KjU(), 0.7f, 0.0f, 0.0f, 0.0f, 14, (Object) null), (Shape) null, 2, (Object) null);
                ComposerKt.sourceInformationMarkerStart(composer, 859834981, "CC(remember):HeaderIpFeedRecommendComponent.kt#9igjgp");
                boolean invalid$iv = composer.changedInstance(pageViewModel) | composer.changedInstance(item) | composer.changed(z);
                Object it$iv = $composer.rememberedValue();
                if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function0() { // from class: kntr.app.mall.product.details.page.ui.components.pieces.HeaderIpFeedRecommendComponentKt$$ExternalSyntheticLambda0
                        public final Object invoke() {
                            Unit HeaderIpFeedRecommendComponent$lambda$7$1$0$1$0$0$0;
                            HeaderIpFeedRecommendComponent$lambda$7$1$0$1$0$0$0 = HeaderIpFeedRecommendComponentKt.HeaderIpFeedRecommendComponent$lambda$7$1$0$1$0$0$0(PageViewModel.this, item, z);
                            return HeaderIpFeedRecommendComponent$lambda$7$1$0$1$0$0$0;
                        }
                    };
                    $composer.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                ComposerKt.sourceInformationMarkerEnd($composer);
                Modifier modifier$iv = ClickableKt.clickable-oSLSa3U$default(modifier, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
                MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                int $changed$iv$iv = (0 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
                Iterable $this$forEach$iv2 = $this$forEach$iv;
                CompositionLocalMap localMap$iv$iv = $composer.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer, modifier$iv);
                Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                boolean z3 = z2;
                Iterator it2 = it;
                ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer.startReusableNode();
                if ($composer.getInserting()) {
                    factory$iv$iv$iv = factory$iv$iv$iv4;
                    $composer.createNode(factory$iv$iv$iv);
                } else {
                    factory$iv$iv$iv = factory$iv$iv$iv4;
                    $composer.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
                int i2 = ($changed$iv$iv$iv >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                int i3 = ((0 >> 6) & 112) | 6;
                BoxScope $this$HeaderIpFeedRecommendComponent_u24lambda_u247_u241_u240_u241_u240_u241 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer, 468960932, "C:HeaderIpFeedRecommendComponent.kt#v057zd");
                CoverVO coverVO = item.getCoverVO();
                String imageUrl = coverVO != null ? coverVO.getUrl() : null;
                String str = imageUrl;
                if (!(str == null || str.length() == 0)) {
                    $composer.startReplaceGroup(468972432);
                    ComposerKt.sourceInformation($composer, "172@7441L432");
                    String $this$asRequest$iv = HelperKt.customizedImageUrl(imageUrl);
                    ImageRequest $this$HeaderIpFeedRecommendComponent_u24lambda_u247_u241_u240_u241_u240_u241_u240 = new ImageRequest($this$asRequest$iv);
                    $this$HeaderIpFeedRecommendComponent_u24lambda_u247_u241_u240_u241_u240_u241_u240.m1493requestWidth3VbuI34(i);
                    $this$HeaderIpFeedRecommendComponent_u24lambda_u247_u241_u240_u241_u240_u241_u240.m1488requestHeight3VbuI34(i);
                    $changed$iv = 1;
                    BiliImageKt.BiliImage($this$HeaderIpFeedRecommendComponent_u24lambda_u247_u241_u240_u241_u240_u241_u240.build(), SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), null, null, null, null, null, null, null, $composer, 48, 508);
                } else {
                    $changed$iv = 1;
                    $composer.startReplaceGroup(461608320);
                }
                $composer.endReplaceGroup();
                ShopItem.PriceInfoVO priceInfo = item.getPriceInfoVO();
                String netPrice = priceInfo != null ? priceInfo.getNetPrice() : null;
                if (((netPrice == null || netPrice.length() == 0) ? $changed$iv : 0) == 0) {
                    $composer.startReplaceGroup(469653812);
                    ComposerKt.sourceInformation($composer, "184@8070L2284");
                    Modifier modifier$iv2 = PaddingKt.padding-VpY3zN4$default(BackgroundKt.background-bw27NRU$default(ClipKt.clip(PaddingKt.padding-qDBjuR0$default($this$HeaderIpFeedRecommendComponent_u24lambda_u247_u241_u240_u241_u240_u241.align(Modifier.Companion, Alignment.Companion.getBottomCenter()), 0.0f, 0.0f, 0.0f, ProvideUiScaleKt.dpScaled(2, $scale), 7, (Object) null), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(ProvideUiScaleKt.dpScaled(4, $scale))), Color.copy-wmQWz5c$default(Color.Companion.getBlack-0d7_KjU(), 0.6f, 0.0f, 0.0f, 0.0f, 14, (Object) null), (Shape) null, 2, (Object) null), ProvideUiScaleKt.dpScaled(4, $scale), 0.0f, 2, (Object) null);
                    Alignment contentAlignment$iv2 = Alignment.Companion.getCenter();
                    ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
                    int $changed$iv$iv2 = (48 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
                    CompositionLocalMap localMap$iv$iv2 = $composer.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer, modifier$iv2);
                    Function0 factory$iv$iv$iv5 = ComposeUiNode.Companion.getConstructor();
                    int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                    $composer$iv$iv = $composer;
                    $composer$iv$iv$iv = $composer;
                    ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!($composer.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer.startReusableNode();
                    if ($composer.getInserting()) {
                        factory$iv$iv$iv2 = factory$iv$iv$iv5;
                        $composer.createNode(factory$iv$iv$iv2);
                    } else {
                        factory$iv$iv$iv2 = factory$iv$iv$iv5;
                        $composer.useNode();
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer);
                    $composer$iv = $composer;
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
                    int i4 = ($changed$iv$iv$iv2 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScope boxScope = BoxScopeInstance.INSTANCE;
                    int i5 = ((48 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer, -1864593208, "C194@8735L1585:HeaderIpFeedRecommendComponent.kt#v057zd");
                    Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
                    ComposerKt.sourceInformationMarkerStart($composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                    Modifier modifier$iv3 = Modifier.Companion;
                    Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                    MeasurePolicy measurePolicy$iv3 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer, ((384 >> 3) & 14) | ((384 >> 3) & 112));
                    int $changed$iv$iv3 = (384 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
                    CompositionLocalMap localMap$iv$iv3 = $composer.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer, modifier$iv3);
                    Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
                    int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!($composer.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer.startReusableNode();
                    if ($composer.getInserting()) {
                        factory$iv$iv$iv3 = factory$iv$iv$iv6;
                        $composer.createNode(factory$iv$iv$iv3);
                    } else {
                        factory$iv$iv$iv3 = factory$iv$iv$iv6;
                        $composer.useNode();
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer);
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
                    int i6 = ($changed$iv$iv$iv3 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                    RowScope rowScope = RowScopeInstance.INSTANCE;
                    int i7 = ((384 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer, -2012387553, "C197@8908L656,208@9605L677:HeaderIpFeedRecommendComponent.kt#v057zd");
                    String priceSymbol = priceInfo.getPriceSymbol();
                    if (priceSymbol == null) {
                        priceSymbol = "";
                    }
                    TextKt.Text-Nvy7gAk(priceSymbol, (Modifier) null, Color.Companion.getWhite-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, ProvideUiScaleKt.scaled(new TextStyle(0L, TextUnitKt.getSp(12), FontWeight.Companion.getNormal(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(16), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646137, (DefaultConstructorMarker) null), $scale), $composer, 384, 24576, 114682);
                    String netPrice2 = priceInfo.getNetPrice();
                    String priceSuffix = priceInfo.getPriceSuffix();
                    if (priceSuffix == null) {
                        priceSuffix = "";
                    }
                    c = 16;
                    TextKt.Text-Nvy7gAk(netPrice2 + priceSuffix, (Modifier) null, Color.Companion.getWhite-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, ProvideUiScaleKt.scaled(new TextStyle(0L, TextUnitKt.getSp(12), FontWeight.Companion.getNormal(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(16), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646137, (DefaultConstructorMarker) null), $scale), $composer, 384, 24576, 114682);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    $composer.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    $composer.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    $composer.endReplaceGroup();
                    $composer2 = $composer;
                } else {
                    $composer$iv$iv = $composer;
                    $composer$iv = $composer;
                    $composer$iv$iv$iv = $composer;
                    c = 16;
                    $composer2 = $composer;
                    $composer2.startReplaceGroup(461608320);
                    $composer2.endReplaceGroup();
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                $composer$iv$iv$iv.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
                ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
                ComposerKt.sourceInformationMarkerEnd($composer);
                pageViewModel = $pageViewModel;
                z = $isInPreview;
                i = $itemWidthPixel;
                $this$forEach$iv = $this$forEach$iv2;
                z2 = z3;
                it = it2;
                composer = $composer;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HeaderIpFeedRecommendComponent$lambda$7$1$0$1$0$0$0(PageViewModel $pageViewModel, ShopItem $item, boolean $isInPreview) {
        $pageViewModel.reportIpRecommendItemClick$product_details_page_debug($item, $isInPreview);
        ShopItem.JumpUrlVO jumpUrlVO = $item.getJumpUrlVO();
        if (jumpUrlVO == null) {
            return Unit.INSTANCE;
        }
        String jumpUrl = jumpUrlVO.getJumpUrlNA();
        $pageViewModel.handleJumpUrl$product_details_page_debug(jumpUrl);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HeaderIpFeedRecommendComponent$lambda$7$1$0$2$0(PageViewModel $pageViewModel, boolean $isInPreview, CoroutineScope $scope, LazyStaggeredGridState $listState, State $detailResponse$delegate) {
        String str;
        ProductDetailsResponse.ProductDetailsData data;
        BasicInfoFloor basicInfoFloorVO;
        ProductDetailsResponse.ProductDetailsData data2;
        ProductDetailsResponse HeaderIpFeedRecommendComponent$lambda$4 = HeaderIpFeedRecommendComponent$lambda$4($detailResponse$delegate);
        boolean fromTM = (HeaderIpFeedRecommendComponent$lambda$4 == null || (data2 = HeaderIpFeedRecommendComponent$lambda$4.getData()) == null) ? false : Intrinsics.areEqual(data2.getFromTm(), true);
        $pageViewModel.reportIpRecommendDetailMoreClick$product_details_page_debug(fromTM, $isInPreview);
        $pageViewModel.toggleHeaderFullScreenPreview$product_details_page_debug(false);
        Integer targetIndex = $pageViewModel.getListKeyToIndexMap().get(FloorType.DETAIL_DESC.getKey());
        if (targetIndex != null) {
            $pageViewModel.scrollToTab$product_details_page_debug(targetIndex.intValue(), $scope, $listState);
        }
        if (fromTM) {
            ProductDetailsResponse HeaderIpFeedRecommendComponent$lambda$42 = HeaderIpFeedRecommendComponent$lambda$4($detailResponse$delegate);
            if (HeaderIpFeedRecommendComponent$lambda$42 == null || (data = HeaderIpFeedRecommendComponent$lambda$42.getData()) == null || (basicInfoFloorVO = data.getBasicInfoFloorVO()) == null) {
                str = null;
            } else {
                str = basicInfoFloorVO.getGuideIndexUrl();
            }
            $pageViewModel.handleJumpUrl$product_details_page_debug(str);
        }
        return Unit.INSTANCE;
    }
}