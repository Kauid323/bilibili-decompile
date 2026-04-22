package kntr.app.mall.product.details.page.ui.floatingLayer;

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
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
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
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
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
import androidx.compose.ui.unit.TextUnitKt;
import androidx.compose.ui.window.AndroidDialog_androidKt;
import androidx.compose.ui.window.DialogProperties;
import java.util.Iterator;
import java.util.List;
import kntr.app.mall.product.details.page.api.IPFeedRecommendV2ApiService;
import kntr.app.mall.product.details.page.api.model.BasicInfoFloor;
import kntr.app.mall.product.details.page.api.model.CoverVO;
import kntr.app.mall.product.details.page.api.model.ProductDetailsResponse;
import kntr.app.mall.product.details.page.api.model.ShopItem;
import kntr.app.mall.product.details.page.ui.scale.ProvideUiScaleKt;
import kntr.app.mall.product.details.page.ui.scale.UiScaleModel;
import kntr.app.mall.product.details.page.utils.HelperKt;
import kntr.app.mall.product.details.page.vm.PageViewModel;
import kntr.app.mall.product.details.page.vm.PageViewModelWrapper;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.imageloader.BiliImageKt;
import kntr.base.imageloader.ImageRequest;
import kntr.base.imageloader.ImmutableImageRequest;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RetainPopupDialog.kt */
@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a5\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0001¢\u0006\u0002\u0010\n\u001a_\u0010\u000e\u001a\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00010\u00112\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\b\u001a\u00020\tH\u0003¢\u0006\u0002\u0010\u0017\u001a;\u0010\u001b\u001a\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u0006\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\b\u001a\u00020\tH\u0003¢\u0006\u0002\u0010\u001c\"\u000e\u0010\u000b\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0018\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0019\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001a\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001d²\u0006\n\u0010\u0015\u001a\u00020\u0016X\u008a\u0084\u0002"}, d2 = {"RetainPopupDialog", "", "show", "", "onDismiss", "Lkotlin/Function0;", "pageVMWrapper", "Lkntr/app/mall/product/details/page/vm/PageViewModelWrapper;", "modifier", "Landroidx/compose/ui/Modifier;", "(ZLkotlin/jvm/functions/Function0;Lkntr/app/mall/product/details/page/vm/PageViewModelWrapper;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "RECOMMEND_BG_IMG", "", "RECOMMEND_TITLE_IMG", "RecommendPopupComponent", "onAction", "onItem", "Lkotlin/Function1;", "Lkntr/app/mall/product/details/page/api/model/ShopItem;", "ipFeedList", "", "scaleModel", "Lkntr/app/mall/product/details/page/ui/scale/UiScaleModel;", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Ljava/util/List;Lkntr/app/mall/product/details/page/ui/scale/UiScaleModel;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "HYG_GUIDE_BG_IMG", "GUIDE_HIDE_IMG", "GUIDE_ACTION_IMG", "HYGGuidePopupComponent", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkntr/app/mall/product/details/page/ui/scale/UiScaleModel;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "product-details-page_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class RetainPopupDialogKt {
    private static final String GUIDE_ACTION_IMG = "//i0.hdslb.com/bfs/kfptfe/floor/73d1033312805dc41841fdfc9616ac6824830378.png";
    private static final String GUIDE_HIDE_IMG = "//i0.hdslb.com/bfs/kfptfe/floor/2aa9f406f9e5472afe666fe5d842d628f5dc3e77.png";
    private static final String HYG_GUIDE_BG_IMG = "//i0.hdslb.com/bfs/kfptfe/floor/e1ef606f92378d3e62de1e0d903eb58b2682336a.png";
    private static final String RECOMMEND_BG_IMG = "//i0.hdslb.com/bfs/kfptfe/floor/03bd1f243a836572253efd899c15488a77663953.png";
    private static final String RECOMMEND_TITLE_IMG = "//i0.hdslb.com/bfs/kfptfe/floor/169bc76a02552c3166cf5466c2190daca2094428.png";

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HYGGuidePopupComponent$lambda$1(Function0 function0, Function0 function02, UiScaleModel uiScaleModel, Modifier modifier, int i, int i2, Composer composer, int i3) {
        HYGGuidePopupComponent(function0, function02, uiScaleModel, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RecommendPopupComponent$lambda$0(Function0 function0, Function0 function02, Function1 function1, List list, UiScaleModel uiScaleModel, Modifier modifier, int i, int i2, Composer composer, int i3) {
        RecommendPopupComponent(function0, function02, function1, list, uiScaleModel, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RecommendPopupComponent$lambda$2(Function0 function0, Function0 function02, Function1 function1, List list, UiScaleModel uiScaleModel, Modifier modifier, int i, int i2, Composer composer, int i3) {
        RecommendPopupComponent(function0, function02, function1, list, uiScaleModel, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RetainPopupDialog$lambda$1(boolean z, Function0 function0, PageViewModelWrapper pageViewModelWrapper, Modifier modifier, int i, int i2, Composer composer, int i3) {
        RetainPopupDialog(z, function0, pageViewModelWrapper, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RetainPopupDialog$lambda$2(boolean z, Function0 function0, PageViewModelWrapper pageViewModelWrapper, Modifier modifier, int i, int i2, Composer composer, int i3) {
        RetainPopupDialog(z, function0, pageViewModelWrapper, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RetainPopupDialog$lambda$4(boolean z, Function0 function0, PageViewModelWrapper pageViewModelWrapper, Modifier modifier, int i, int i2, Composer composer, int i3) {
        RetainPopupDialog(z, function0, pageViewModelWrapper, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void RetainPopupDialog(final boolean show, final Function0<Unit> function0, final PageViewModelWrapper pageVMWrapper, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Composer $composer2;
        Modifier modifier3;
        Composer $composer3;
        Intrinsics.checkNotNullParameter(function0, "onDismiss");
        Intrinsics.checkNotNullParameter(pageVMWrapper, "pageVMWrapper");
        Composer $composer4 = $composer.startRestartGroup(-15058490);
        ComposerKt.sourceInformation($composer4, "C(RetainPopupDialog)N(show,onDismiss,pageVMWrapper,modifier)47@2049L16,53@2178L16,59@2381L16,67@2614L1373,65@2562L1425:RetainPopupDialog.kt#j7uxph");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer4.changed(show) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer4.changedInstance(function0) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer4.changedInstance(pageVMWrapper) ? 256 : 128;
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
        if ($composer4.shouldExecute(($dirty2 & 1171) != 1170, $dirty2 & 1)) {
            modifier3 = i2 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-15058490, $dirty2, -1, "kntr.app.mall.product.details.page.ui.floatingLayer.RetainPopupDialog (RetainPopupDialog.kt:45)");
            }
            final PageViewModel pageVM = pageVMWrapper.getViewModel();
            final State scaleModel$delegate = SnapshotStateKt.collectAsState(pageVM.getUiScaleModelFlow$product_details_page_debug(), (CoroutineContext) null, $composer4, 0, 1);
            if (!show) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup = $composer4.endRestartGroup();
                if (endRestartGroup != null) {
                    final Modifier modifier4 = modifier3;
                    endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.floatingLayer.RetainPopupDialogKt$$ExternalSyntheticLambda7
                        public final Object invoke(Object obj, Object obj2) {
                            Unit RetainPopupDialog$lambda$1;
                            RetainPopupDialog$lambda$1 = RetainPopupDialogKt.RetainPopupDialog$lambda$1(show, function0, pageVMWrapper, modifier4, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                            return RetainPopupDialog$lambda$1;
                        }
                    });
                    return;
                }
                return;
            }
            ProductDetailsResponse productDetailsResponse = (ProductDetailsResponse) SnapshotStateKt.collectAsState(pageVM.getProductDetailsResponse(), (CoroutineContext) null, $composer4, 0, 1).getValue();
            if (productDetailsResponse != null) {
                ProductDetailsResponse.ProductDetailsData responseData = productDetailsResponse.getData();
                if (responseData != null) {
                    BasicInfoFloor basicInfoFloorVO = responseData.getBasicInfoFloorVO();
                    final String guideIndexUrl = basicInfoFloorVO != null ? basicInfoFloorVO.getGuideIndexUrl() : null;
                    IPFeedRecommendV2ApiService.Response response = (IPFeedRecommendV2ApiService.Response) SnapshotStateKt.collectAsState(pageVM.getIpFeedRecommendFlow(), (CoroutineContext) null, $composer4, 0, 1).getValue();
                    IPFeedRecommendV2ApiService.RecommendData ipFeedData = response != null ? response.getData() : null;
                    final List ipFeedList = pageVM.ipItemsFeed$product_details_page_debug(ipFeedData);
                    final boolean showRecommend = pageVM.shouldShowIpFeedRecommend$product_details_page_debug(ipFeedData);
                    final Modifier modifier5 = modifier3;
                    $composer2 = $composer4;
                    AndroidDialog_androidKt.Dialog(function0, (DialogProperties) null, ComposableLambdaKt.rememberComposableLambda(422154319, true, new Function2() { // from class: kntr.app.mall.product.details.page.ui.floatingLayer.RetainPopupDialogKt$$ExternalSyntheticLambda9
                        public final Object invoke(Object obj, Object obj2) {
                            Unit RetainPopupDialog$lambda$3;
                            RetainPopupDialog$lambda$3 = RetainPopupDialogKt.RetainPopupDialog$lambda$3(showRecommend, function0, pageVM, guideIndexUrl, ipFeedList, modifier5, scaleModel$delegate, (Composer) obj, ((Integer) obj2).intValue());
                            return RetainPopupDialog$lambda$3;
                        }
                    }, $composer4, 54), $composer4, (($dirty2 >> 3) & 14) | 384, 2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                } else {
                    $composer3 = $composer4;
                }
            } else {
                $composer3 = $composer4;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            ScopeUpdateScope endRestartGroup2 = $composer3.endRestartGroup();
            if (endRestartGroup2 != null) {
                final Modifier modifier6 = modifier3;
                endRestartGroup2.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.floatingLayer.RetainPopupDialogKt$$ExternalSyntheticLambda8
                    public final Object invoke(Object obj, Object obj2) {
                        Unit RetainPopupDialog$lambda$2;
                        RetainPopupDialog$lambda$2 = RetainPopupDialogKt.RetainPopupDialog$lambda$2(show, function0, pageVMWrapper, modifier6, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                        return RetainPopupDialog$lambda$2;
                    }
                });
                return;
            }
            return;
        }
        $composer2 = $composer4;
        $composer2.skipToGroupEnd();
        modifier3 = modifier2;
        ScopeUpdateScope endRestartGroup3 = $composer2.endRestartGroup();
        if (endRestartGroup3 != null) {
            final Modifier modifier7 = modifier3;
            endRestartGroup3.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.floatingLayer.RetainPopupDialogKt$$ExternalSyntheticLambda11
                public final Object invoke(Object obj, Object obj2) {
                    Unit RetainPopupDialog$lambda$4;
                    RetainPopupDialog$lambda$4 = RetainPopupDialogKt.RetainPopupDialog$lambda$4(show, function0, pageVMWrapper, modifier7, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return RetainPopupDialog$lambda$4;
                }
            });
        }
    }

    private static final UiScaleModel RetainPopupDialog$lambda$0(State<UiScaleModel> state) {
        Object thisObj$iv = state.getValue();
        return (UiScaleModel) thisObj$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RetainPopupDialog$lambda$3(boolean $showRecommend, final Function0 $onDismiss, final PageViewModel $pageVM, final String $guideIndexUrl, List $ipFeedList, Modifier $modifier, State $scaleModel$delegate, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C:RetainPopupDialog.kt#j7uxph");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(422154319, $changed, -1, "kntr.app.mall.product.details.page.ui.floatingLayer.RetainPopupDialog.<anonymous> (RetainPopupDialog.kt:68)");
            }
            if ($showRecommend) {
                $composer.startReplaceGroup(735145385);
                ComposerKt.sourceInformation($composer, "73@2829L97,77@2955L107,81@3089L459,69@2657L906");
                UiScaleModel RetainPopupDialog$lambda$0 = RetainPopupDialog$lambda$0($scaleModel$delegate);
                ComposerKt.sourceInformationMarkerStart($composer, 1963381712, "CC(remember):RetainPopupDialog.kt#9igjgp");
                boolean invalid$iv = $composer.changed($onDismiss) | $composer.changedInstance($pageVM);
                Object it$iv = $composer.rememberedValue();
                if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function0() { // from class: kntr.app.mall.product.details.page.ui.floatingLayer.RetainPopupDialogKt$$ExternalSyntheticLambda10
                        public final Object invoke() {
                            Unit RetainPopupDialog$lambda$3$0$0;
                            RetainPopupDialog$lambda$3$0$0 = RetainPopupDialogKt.RetainPopupDialog$lambda$3$0$0($onDismiss, $pageVM);
                            return RetainPopupDialog$lambda$3$0$0;
                        }
                    };
                    $composer.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                Function0 function0 = (Function0) it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerStart($composer, 1963385754, "CC(remember):RetainPopupDialog.kt#9igjgp");
                boolean invalid$iv2 = $composer.changed($onDismiss) | $composer.changedInstance($pageVM) | $composer.changed($guideIndexUrl);
                Object it$iv2 = $composer.rememberedValue();
                if (invalid$iv2 || it$iv2 == Composer.Companion.getEmpty()) {
                    Object value$iv2 = new Function0() { // from class: kntr.app.mall.product.details.page.ui.floatingLayer.RetainPopupDialogKt$$ExternalSyntheticLambda12
                        public final Object invoke() {
                            Unit RetainPopupDialog$lambda$3$1$0;
                            RetainPopupDialog$lambda$3$1$0 = RetainPopupDialogKt.RetainPopupDialog$lambda$3$1$0($onDismiss, $pageVM, $guideIndexUrl);
                            return RetainPopupDialog$lambda$3$1$0;
                        }
                    };
                    $composer.updateRememberedValue(value$iv2);
                    it$iv2 = value$iv2;
                }
                Function0 function02 = (Function0) it$iv2;
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerStart($composer, 1963390394, "CC(remember):RetainPopupDialog.kt#9igjgp");
                boolean invalid$iv3 = $composer.changed($onDismiss) | $composer.changedInstance($pageVM);
                Object it$iv3 = $composer.rememberedValue();
                if (invalid$iv3 || it$iv3 == Composer.Companion.getEmpty()) {
                    Object value$iv3 = new Function1() { // from class: kntr.app.mall.product.details.page.ui.floatingLayer.RetainPopupDialogKt$$ExternalSyntheticLambda13
                        public final Object invoke(Object obj) {
                            Unit RetainPopupDialog$lambda$3$2$0;
                            RetainPopupDialog$lambda$3$2$0 = RetainPopupDialogKt.RetainPopupDialog$lambda$3$2$0($onDismiss, $pageVM, (ShopItem) obj);
                            return RetainPopupDialog$lambda$3$2$0;
                        }
                    };
                    $composer.updateRememberedValue(value$iv3);
                    it$iv3 = value$iv3;
                }
                ComposerKt.sourceInformationMarkerEnd($composer);
                RecommendPopupComponent(function0, function02, (Function1) it$iv3, $ipFeedList, RetainPopupDialog$lambda$0, $modifier, $composer, 0, 0);
                $composer.endReplaceGroup();
            } else {
                $composer.startReplaceGroup(736057529);
                ComposerKt.sourceInformation($composer, "97@3723L97,101@3849L107,94@3593L378");
                UiScaleModel RetainPopupDialog$lambda$02 = RetainPopupDialog$lambda$0($scaleModel$delegate);
                ComposerKt.sourceInformationMarkerStart($composer, 1963410320, "CC(remember):RetainPopupDialog.kt#9igjgp");
                boolean invalid$iv4 = $composer.changed($onDismiss) | $composer.changedInstance($pageVM);
                Object it$iv4 = $composer.rememberedValue();
                if (invalid$iv4 || it$iv4 == Composer.Companion.getEmpty()) {
                    Object value$iv4 = new Function0() { // from class: kntr.app.mall.product.details.page.ui.floatingLayer.RetainPopupDialogKt$$ExternalSyntheticLambda14
                        public final Object invoke() {
                            Unit RetainPopupDialog$lambda$3$3$0;
                            RetainPopupDialog$lambda$3$3$0 = RetainPopupDialogKt.RetainPopupDialog$lambda$3$3$0($onDismiss, $pageVM);
                            return RetainPopupDialog$lambda$3$3$0;
                        }
                    };
                    $composer.updateRememberedValue(value$iv4);
                    it$iv4 = value$iv4;
                }
                Function0 function03 = (Function0) it$iv4;
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerStart($composer, 1963414362, "CC(remember):RetainPopupDialog.kt#9igjgp");
                boolean invalid$iv5 = $composer.changed($onDismiss) | $composer.changedInstance($pageVM) | $composer.changed($guideIndexUrl);
                Object it$iv5 = $composer.rememberedValue();
                if (invalid$iv5 || it$iv5 == Composer.Companion.getEmpty()) {
                    Object value$iv5 = new Function0() { // from class: kntr.app.mall.product.details.page.ui.floatingLayer.RetainPopupDialogKt$$ExternalSyntheticLambda15
                        public final Object invoke() {
                            Unit RetainPopupDialog$lambda$3$4$0;
                            RetainPopupDialog$lambda$3$4$0 = RetainPopupDialogKt.RetainPopupDialog$lambda$3$4$0($onDismiss, $pageVM, $guideIndexUrl);
                            return RetainPopupDialog$lambda$3$4$0;
                        }
                    };
                    $composer.updateRememberedValue(value$iv5);
                    it$iv5 = value$iv5;
                }
                ComposerKt.sourceInformationMarkerEnd($composer);
                HYGGuidePopupComponent(function03, (Function0) it$iv5, RetainPopupDialog$lambda$02, $modifier, $composer, 0, 0);
                $composer.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RetainPopupDialog$lambda$3$0$0(Function0 $onDismiss, PageViewModel $pageVM) {
        $onDismiss.invoke();
        $pageVM.handleBackAction$product_details_page_debug();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RetainPopupDialog$lambda$3$1$0(Function0 $onDismiss, PageViewModel $pageVM, String $guideIndexUrl) {
        $onDismiss.invoke();
        $pageVM.handleJumpUrl$product_details_page_debug($guideIndexUrl);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RetainPopupDialog$lambda$3$2$0(Function0 $onDismiss, PageViewModel $pageVM, ShopItem item) {
        String jumpUrl;
        Intrinsics.checkNotNullParameter(item, "item");
        $onDismiss.invoke();
        ShopItem.JumpUrlVO jumpUrlVO = item.getJumpUrlVO();
        if (jumpUrlVO == null) {
            return Unit.INSTANCE;
        }
        String guideIndexUrl = jumpUrlVO.getGuideIndexUrl();
        if (!(guideIndexUrl == null || guideIndexUrl.length() == 0)) {
            jumpUrl = jumpUrlVO.getGuideIndexUrl();
        } else {
            jumpUrl = jumpUrlVO.getJumpUrlNA();
        }
        $pageVM.handleJumpUrl$product_details_page_debug(jumpUrl);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RetainPopupDialog$lambda$3$3$0(Function0 $onDismiss, PageViewModel $pageVM) {
        $onDismiss.invoke();
        $pageVM.handleBackAction$product_details_page_debug();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RetainPopupDialog$lambda$3$4$0(Function0 $onDismiss, PageViewModel $pageVM, String $guideIndexUrl) {
        $onDismiss.invoke();
        $pageVM.handleJumpUrl$product_details_page_debug($guideIndexUrl);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:90:0x0253, code lost:
        if (r6 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L79;
     */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0842  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0844  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x08ca  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void RecommendPopupComponent(final Function0<Unit> function0, final Function0<Unit> function02, final Function1<? super ShopItem, Unit> function1, final List<ShopItem> list, final UiScaleModel scaleModel, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Composer $composer2;
        Modifier modifier3;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Function0 factory$iv$iv$iv3;
        Function0 factory$iv$iv$iv4;
        boolean invalid$iv;
        Composer $composer3 = $composer.startRestartGroup(-1307821146);
        ComposerKt.sourceInformation($composer3, "C(RecommendPopupComponent)N(onDismiss,onAction,onItem,ipFeedList,scaleModel,modifier)125@4526L5501:RetainPopupDialog.kt#j7uxph");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changedInstance(function0) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changedInstance(function02) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer3.changedInstance(function1) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer3.changedInstance(list) ? 2048 : 1024;
        }
        if (($changed & 24576) == 0) {
            $dirty |= $composer3.changed(scaleModel) ? 16384 : 8192;
        }
        int i2 = i & 32;
        if (i2 != 0) {
            $dirty |= 196608;
            modifier2 = modifier;
        } else if ((196608 & $changed) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 131072 : 65536;
        } else {
            modifier2 = modifier;
        }
        int $dirty2 = $dirty;
        if ($composer3.shouldExecute((74899 & $dirty2) != 74898, $dirty2 & 1)) {
            modifier3 = i2 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1307821146, $dirty2, -1, "kntr.app.mall.product.details.page.ui.floatingLayer.RecommendPopupComponent (RetainPopupDialog.kt:121)");
            }
            List<ShopItem> list2 = list;
            if (list2 == null || list2.isEmpty()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup = $composer3.endRestartGroup();
                if (endRestartGroup != null) {
                    final Modifier modifier4 = modifier3;
                    endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.floatingLayer.RetainPopupDialogKt$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj, Object obj2) {
                            Unit RecommendPopupComponent$lambda$0;
                            RecommendPopupComponent$lambda$0 = RetainPopupDialogKt.RecommendPopupComponent$lambda$0(function0, function02, function1, list, scaleModel, modifier4, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                            return RecommendPopupComponent$lambda$0;
                        }
                    });
                    return;
                }
                return;
            }
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getCenterHorizontally();
            int $changed$iv = (($dirty2 >> 15) & 14) | 384;
            Modifier modifier$iv = modifier3;
            ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, (($changed$iv >> 3) & 14) | (($changed$iv >> 3) & 112));
            int $changed$iv$iv = ($changed$iv << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0 factory$iv$iv$iv5 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            $composer2 = $composer3;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv5;
                $composer3.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv5;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i4 = (($changed$iv >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 700635489, "C134@4866L58,129@4639L4148,218@8797L1224:RetainPopupDialog.kt#j7uxph");
            Modifier clipToBounds = ClipKt.clipToBounds(SizeKt.size-VpY3zN4(Modifier.Companion, ProvideUiScaleKt.dpScaled(278, scaleModel.getScale()), ProvideUiScaleKt.dpScaled(421, scaleModel.getScale())));
            ComposerKt.sourceInformationMarkerStart($composer3, 1408076406, "CC(remember):RetainPopupDialog.kt#9igjgp");
            boolean invalid$iv2 = ($dirty2 & 112) == 32;
            Object it$iv = $composer3.rememberedValue();
            if (invalid$iv2) {
            }
            Object value$iv = new Function0() { // from class: kntr.app.mall.product.details.page.ui.floatingLayer.RetainPopupDialogKt$$ExternalSyntheticLambda1
                public final Object invoke() {
                    Unit RecommendPopupComponent$lambda$1$0$0;
                    RecommendPopupComponent$lambda$1$0$0 = RetainPopupDialogKt.RecommendPopupComponent$lambda$1$0$0(function02);
                    return RecommendPopupComponent$lambda$1$0$0;
                }
            };
            $composer3.updateRememberedValue(value$iv);
            it$iv = value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifier$iv2 = ClickableKt.clickable-oSLSa3U$default(clipToBounds, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv2 = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer3, modifier$iv2);
            Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv6;
                $composer3.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv6;
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
            int i6 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -1169992114, "C138@4950L284,145@5247L3530:RetainPopupDialog.kt#j7uxph");
            String $this$asRequest_u24default$iv = HelperKt.customizedImageUrl(RECOMMEND_BG_IMG);
            ImageRequest imageRequest = new ImageRequest($this$asRequest_u24default$iv);
            Unit unit = Unit.INSTANCE;
            BiliImageKt.BiliImage(imageRequest.build(), SizeKt.height-3ABfNKs(SizeKt.width-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(278, scaleModel.getScale())), ProvideUiScaleKt.dpScaled(421, scaleModel.getScale())), null, null, null, null, null, null, null, $composer3, 0, 508);
            Modifier modifier$iv3 = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
            Alignment.Horizontal horizontalAlignment$iv2 = Alignment.Companion.getCenterHorizontally();
            ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv2 = Arrangement.INSTANCE.getTop();
            MeasurePolicy measurePolicy$iv3 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv2, horizontalAlignment$iv2, $composer3, ((390 >> 3) & 14) | ((390 >> 3) & 112));
            int $changed$iv$iv3 = (390 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv3 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer3, modifier$iv3);
            Function0 factory$iv$iv$iv7 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv3 = factory$iv$iv$iv7;
                $composer3.createNode(factory$iv$iv$iv3);
            } else {
                factory$iv$iv$iv3 = factory$iv$iv$iv7;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
            int i7 = ($changed$iv$iv$iv3 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope2 = ColumnScopeInstance.INSTANCE;
            int i8 = ((390 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -1858922834, "C149@5406L386,166@6292L2471,158@5810L2953:RetainPopupDialog.kt#j7uxph");
            String $this$asRequest_u24default$iv2 = HelperKt.customizedImageUrl(RECOMMEND_TITLE_IMG);
            ImageRequest imageRequest2 = new ImageRequest($this$asRequest_u24default$iv2);
            Unit unit2 = Unit.INSTANCE;
            BiliImageKt.BiliImage(imageRequest2.build(), SizeKt.height-3ABfNKs(SizeKt.width-3ABfNKs(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, ProvideUiScaleKt.dpScaled(16, scaleModel.getScale()), 0.0f, 0.0f, 13, (Object) null), ProvideUiScaleKt.dpScaled(117, scaleModel.getScale())), ProvideUiScaleKt.dpScaled(18.5d, scaleModel.getScale())), null, null, null, null, null, null, null, $composer3, 0, 508);
            FlowLayoutKt.FlowRow(PaddingKt.padding-VpY3zN4$default(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, ProvideUiScaleKt.dpScaled(14, scaleModel.getScale()), 0.0f, 0.0f, 13, (Object) null), ProvideUiScaleKt.dpScaled(35, scaleModel.getScale()), 0.0f, 2, (Object) null), Arrangement.INSTANCE.spacedBy-0680j_4(ProvideUiScaleKt.dpScaled(16, scaleModel.getScale())), Arrangement.INSTANCE.spacedBy-0680j_4(ProvideUiScaleKt.dpScaled(12, scaleModel.getScale())), (Alignment.Vertical) null, 2, 0, ComposableLambdaKt.rememberComposableLambda(355655549, true, new Function3() { // from class: kntr.app.mall.product.details.page.ui.floatingLayer.RetainPopupDialogKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit RecommendPopupComponent$lambda$1$1$0$0;
                    RecommendPopupComponent$lambda$1$1$0$0 = RetainPopupDialogKt.RecommendPopupComponent$lambda$1$1$0$0(list, function1, scaleModel, (FlowRowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return RecommendPopupComponent$lambda$1$1$0$0;
                }
            }, $composer3, 54), $composer3, 1597440, 40);
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
            Modifier modifier$iv4 = PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, ProvideUiScaleKt.dpScaled(21, scaleModel.getScale()), 0.0f, 0.0f, 13, (Object) null);
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv4 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv4 = (384 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv4 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv4 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer3, modifier$iv4);
            Function0 factory$iv$iv$iv8 = ComposeUiNode.Companion.getConstructor();
            int $i$f$Row = $changed$iv$iv4 << 6;
            int $changed$iv$iv$iv4 = ($i$f$Row & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv4 = factory$iv$iv$iv8;
                $composer3.createNode(factory$iv$iv$iv4);
            } else {
                factory$iv$iv$iv4 = factory$iv$iv$iv8;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv4 = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, measurePolicy$iv4, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, localMap$iv$iv4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv4, Integer.valueOf(compositeKeyHash$iv$iv4), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv4, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, materialized$iv$iv4, ComposeUiNode.Companion.getSetModifier());
            int i9 = ($changed$iv$iv$iv4 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i10 = ((384 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -700301423, "C231@9384L67,224@9001L465,235@9479L53,243@9930L66,236@9545L466:RetainPopupDialog.kt#j7uxph");
            String $this$asRequest_u24default$iv3 = HelperKt.customizedImageUrl(GUIDE_HIDE_IMG);
            ImageRequest imageRequest3 = new ImageRequest($this$asRequest_u24default$iv3);
            Unit unit3 = Unit.INSTANCE;
            ImmutableImageRequest build = imageRequest3.build();
            Modifier clip = ClipKt.clip(SizeKt.height-3ABfNKs(SizeKt.width-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(140, scaleModel.getScale())), ProvideUiScaleKt.dpScaled(40, scaleModel.getScale())), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(ProvideUiScaleKt.dpScaled(20, scaleModel.getScale())));
            ComposerKt.sourceInformationMarkerStart($composer3, -1546599709, "CC(remember):RetainPopupDialog.kt#9igjgp");
            boolean invalid$iv3 = ($dirty2 & 14) == 4;
            Object it$iv2 = $composer3.rememberedValue();
            if (!invalid$iv3 && it$iv2 != Composer.Companion.getEmpty()) {
                ComposerKt.sourceInformationMarkerEnd($composer3);
                BiliImageKt.BiliImage(build, ClickableKt.clickable-oSLSa3U$default(clip, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv2, 15, (Object) null), null, null, null, null, null, null, null, $composer3, 0, 508);
                SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(12, scaleModel.getScale())), $composer3, 0);
                String $this$asRequest_u24default$iv4 = HelperKt.customizedImageUrl(GUIDE_ACTION_IMG);
                ImageRequest imageRequest4 = new ImageRequest($this$asRequest_u24default$iv4);
                Unit unit4 = Unit.INSTANCE;
                ImmutableImageRequest build2 = imageRequest4.build();
                Modifier clip2 = ClipKt.clip(SizeKt.height-3ABfNKs(SizeKt.width-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(140, scaleModel.getScale())), ProvideUiScaleKt.dpScaled(40, scaleModel.getScale())), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(ProvideUiScaleKt.dpScaled(20, scaleModel.getScale())));
                ComposerKt.sourceInformationMarkerStart($composer3, -1546582238, "CC(remember):RetainPopupDialog.kt#9igjgp");
                invalid$iv = ($dirty2 & 112) != 32;
                Object it$iv3 = $composer3.rememberedValue();
                if (!invalid$iv && it$iv3 != Composer.Companion.getEmpty()) {
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    BiliImageKt.BiliImage(build2, ClickableKt.clickable-oSLSa3U$default(clip2, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv3, 15, (Object) null), null, null, null, null, null, null, null, $composer3, 0, 508);
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
                }
                Object value$iv2 = new Function0() { // from class: kntr.app.mall.product.details.page.ui.floatingLayer.RetainPopupDialogKt$$ExternalSyntheticLambda4
                    public final Object invoke() {
                        Unit RecommendPopupComponent$lambda$1$2$1$0;
                        RecommendPopupComponent$lambda$1$2$1$0 = RetainPopupDialogKt.RecommendPopupComponent$lambda$1$2$1$0(function02);
                        return RecommendPopupComponent$lambda$1$2$1$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv2);
                it$iv3 = value$iv2;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                BiliImageKt.BiliImage(build2, ClickableKt.clickable-oSLSa3U$default(clip2, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv3, 15, (Object) null), null, null, null, null, null, null, null, $composer3, 0, 508);
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
                }
            }
            Object value$iv3 = new Function0() { // from class: kntr.app.mall.product.details.page.ui.floatingLayer.RetainPopupDialogKt$$ExternalSyntheticLambda3
                public final Object invoke() {
                    Unit RecommendPopupComponent$lambda$1$2$0$0;
                    RecommendPopupComponent$lambda$1$2$0$0 = RetainPopupDialogKt.RecommendPopupComponent$lambda$1$2$0$0(function0);
                    return RecommendPopupComponent$lambda$1$2$0$0;
                }
            };
            $composer3.updateRememberedValue(value$iv3);
            it$iv2 = value$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            BiliImageKt.BiliImage(build, ClickableKt.clickable-oSLSa3U$default(clip, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv2, 15, (Object) null), null, null, null, null, null, null, null, $composer3, 0, 508);
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(12, scaleModel.getScale())), $composer3, 0);
            String $this$asRequest_u24default$iv42 = HelperKt.customizedImageUrl(GUIDE_ACTION_IMG);
            ImageRequest imageRequest42 = new ImageRequest($this$asRequest_u24default$iv42);
            Unit unit42 = Unit.INSTANCE;
            ImmutableImageRequest build22 = imageRequest42.build();
            Modifier clip22 = ClipKt.clip(SizeKt.height-3ABfNKs(SizeKt.width-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(140, scaleModel.getScale())), ProvideUiScaleKt.dpScaled(40, scaleModel.getScale())), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(ProvideUiScaleKt.dpScaled(20, scaleModel.getScale())));
            ComposerKt.sourceInformationMarkerStart($composer3, -1546582238, "CC(remember):RetainPopupDialog.kt#9igjgp");
            invalid$iv = ($dirty2 & 112) != 32;
            Object it$iv32 = $composer3.rememberedValue();
            if (!invalid$iv) {
                ComposerKt.sourceInformationMarkerEnd($composer3);
                BiliImageKt.BiliImage(build22, ClickableKt.clickable-oSLSa3U$default(clip22, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv32, 15, (Object) null), null, null, null, null, null, null, null, $composer3, 0, 508);
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
                }
            }
            Object value$iv22 = new Function0() { // from class: kntr.app.mall.product.details.page.ui.floatingLayer.RetainPopupDialogKt$$ExternalSyntheticLambda4
                public final Object invoke() {
                    Unit RecommendPopupComponent$lambda$1$2$1$0;
                    RecommendPopupComponent$lambda$1$2$1$0 = RetainPopupDialogKt.RecommendPopupComponent$lambda$1$2$1$0(function02);
                    return RecommendPopupComponent$lambda$1$2$1$0;
                }
            };
            $composer3.updateRememberedValue(value$iv22);
            it$iv32 = value$iv22;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            BiliImageKt.BiliImage(build22, ClickableKt.clickable-oSLSa3U$default(clip22, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv32, 15, (Object) null), null, null, null, null, null, null, null, $composer3, 0, 508);
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
            }
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup2 = $composer2.endRestartGroup();
        if (endRestartGroup2 != null) {
            final Modifier modifier5 = modifier3;
            endRestartGroup2.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.floatingLayer.RetainPopupDialogKt$$ExternalSyntheticLambda5
                public final Object invoke(Object obj, Object obj2) {
                    Unit RecommendPopupComponent$lambda$2;
                    RecommendPopupComponent$lambda$2 = RetainPopupDialogKt.RecommendPopupComponent$lambda$2(function0, function02, function1, list, scaleModel, modifier5, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return RecommendPopupComponent$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RecommendPopupComponent$lambda$1$0$0(Function0 $onAction) {
        $onAction.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RecommendPopupComponent$lambda$1$1$0$0(List $ipFeedList, Function1 $onItem, UiScaleModel $scaleModel, FlowRowScope $this$FlowRow, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        final Function1 function1 = $onItem;
        Composer composer = $composer;
        Intrinsics.checkNotNullParameter($this$FlowRow, "$this$FlowRow");
        ComposerKt.sourceInformation(composer, "C*172@6544L92,169@6409L2314:RetainPopupDialog.kt#j7uxph");
        if (!composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(355655549, $changed, -1, "kntr.app.mall.product.details.page.ui.floatingLayer.RecommendPopupComponent.<anonymous>.<anonymous>.<anonymous>.<anonymous> (RetainPopupDialog.kt:168)");
            }
            Iterable $this$forEach$iv = CollectionsKt.takeLast($ipFeedList, 4);
            boolean z = false;
            Iterator it = $this$forEach$iv.iterator();
            while (it.hasNext()) {
                Object element$iv = it.next();
                final ShopItem item = (ShopItem) element$iv;
                Modifier modifier = Modifier.Companion;
                ComposerKt.sourceInformationMarkerStart(composer, -590172063, "CC(remember):RetainPopupDialog.kt#9igjgp");
                boolean invalid$iv = composer.changed(function1) | composer.changedInstance(item);
                Object it$iv = $composer.rememberedValue();
                if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function0() { // from class: kntr.app.mall.product.details.page.ui.floatingLayer.RetainPopupDialogKt$$ExternalSyntheticLambda6
                        public final Object invoke() {
                            Unit RecommendPopupComponent$lambda$1$1$0$0$0$0$0;
                            RecommendPopupComponent$lambda$1$1$0$0$0$0$0 = RetainPopupDialogKt.RecommendPopupComponent$lambda$1$1$0$0$0$0$0(function1, item);
                            return RecommendPopupComponent$lambda$1$1$0$0$0$0$0;
                        }
                    };
                    $composer.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                ComposerKt.sourceInformationMarkerEnd($composer);
                Modifier modifier$iv = ClickableKt.clickable-oSLSa3U$default(modifier, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null);
                Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getCenterHorizontally();
                ComposerKt.sourceInformationMarkerStart($composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer, ((384 >> 3) & 14) | ((384 >> 3) & 112));
                int $changed$iv$iv = (384 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
                Iterable $this$forEach$iv2 = $this$forEach$iv;
                CompositionLocalMap localMap$iv$iv = $composer.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer, modifier$iv);
                Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                boolean z2 = z;
                Iterator it2 = it;
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
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
                int i = ($changed$iv$iv$iv >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
                int i2 = ((384 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, -1142749487, "C177@6774L1087,197@7891L806:RetainPopupDialog.kt#j7uxph");
                Modifier modifier$iv2 = BackgroundKt.background-bw27NRU$default(ClipKt.clip(SizeKt.size-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(96, $scaleModel.getScale())), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(ProvideUiScaleKt.dpScaled(8, $scaleModel.getScale()))), ColorKt.Color(4294375416L), (Shape) null, 2, (Object) null);
                Alignment contentAlignment$iv = Alignment.Companion.getCenter();
                ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                int $changed$iv$iv2 = (48 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
                CompositionLocalMap localMap$iv$iv2 = $composer.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer, modifier$iv2);
                Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer.startReusableNode();
                if ($composer.getInserting()) {
                    factory$iv$iv$iv2 = factory$iv$iv$iv4;
                    $composer.createNode(factory$iv$iv$iv2);
                } else {
                    factory$iv$iv$iv2 = factory$iv$iv$iv4;
                    $composer.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
                int i3 = ($changed$iv$iv$iv2 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScope boxScope = BoxScopeInstance.INSTANCE;
                int i4 = ((48 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, 636056816, "C:RetainPopupDialog.kt#j7uxph");
                CoverVO coverVO = item.getCoverVO();
                String coverUrl = coverVO != null ? coverVO.getUrl() : null;
                String str = coverUrl;
                if (!(str == null || str.length() == 0)) {
                    $composer.startReplaceGroup(636149071);
                    ComposerKt.sourceInformation($composer, "187@7379L418");
                    String $this$asRequest_u24default$iv = HelperKt.customizedImageUrl(coverUrl);
                    ImageRequest imageRequest = new ImageRequest($this$asRequest_u24default$iv);
                    Unit unit = Unit.INSTANCE;
                    BiliImageKt.BiliImage(imageRequest.build(), SizeKt.height-3ABfNKs(SizeKt.width-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(92, $scaleModel.getScale())), ProvideUiScaleKt.dpScaled(92, $scaleModel.getScale())), null, null, null, null, null, null, null, $composer, 0, 508);
                } else {
                    $composer.startReplaceGroup(628850617);
                }
                $composer.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                String itemsName = item.getItemsName();
                if (itemsName == null) {
                    itemsName = "";
                }
                TextKt.Text-Nvy7gAk(itemsName, SizeKt.widthIn-VpY3zN4$default(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, ProvideUiScaleKt.dpScaled(6, $scaleModel.getScale()), 0.0f, 0.0f, 13, (Object) null), 0.0f, ProvideUiScaleKt.dpScaled(96, $scaleModel.getScale()), 1, (Object) null), ColorKt.Color(4279769372L), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, ProvideUiScaleKt.scaled(new TextStyle(0L, TextUnitKt.getSp(12), FontWeight.Companion.getNormal(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(16), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646137, (DefaultConstructorMarker) null), $scaleModel.getScale()), $composer, 384, 24576, 114680);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                function1 = $onItem;
                composer = $composer;
                $this$forEach$iv = $this$forEach$iv2;
                z = z2;
                it = it2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RecommendPopupComponent$lambda$1$1$0$0$0$0$0(Function1 $onItem, ShopItem $item) {
        $onItem.invoke($item);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RecommendPopupComponent$lambda$1$2$0$0(Function0 $onDismiss) {
        $onDismiss.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RecommendPopupComponent$lambda$1$2$1$0(Function0 $onAction) {
        $onAction.invoke();
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:68:0x030a, code lost:
        if (r13 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x04dc, code lost:
        if (r11 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x059c, code lost:
        if (r11 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L76;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void HYGGuidePopupComponent(final Function0<Unit> function0, final Function0<Unit> function02, final UiScaleModel scaleModel, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Composer $composer2;
        Modifier modifier3;
        Modifier modifier4;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Function0 factory$iv$iv$iv3;
        Composer $composer3 = $composer.startRestartGroup(886934055);
        ComposerKt.sourceInformation($composer3, "C(HYGGuidePopupComponent)N(onDismiss,onAction,scaleModel,modifier)262@10552L2023:RetainPopupDialog.kt#j7uxph");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changedInstance(function0) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changedInstance(function02) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer3.changed(scaleModel) ? 256 : 128;
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
        if (!$composer3.shouldExecute(($dirty2 & 1171) != 1170, $dirty2 & 1)) {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(886934055, $dirty2, -1, "kntr.app.mall.product.details.page.ui.floatingLayer.HYGGuidePopupComponent (RetainPopupDialog.kt:261)");
            }
            Modifier modifier$iv = ClipKt.clipToBounds(modifier4);
            Alignment contentAlignment$iv = Alignment.Companion.getCenter();
            ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (48 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            modifier3 = modifier4;
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
            int i3 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i4 = ((48 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -844963488, "C268@10691L1878:RetainPopupDialog.kt#j7uxph");
            Modifier modifier$iv2 = Modifier.Companion;
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getCenterHorizontally();
            ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((390 >> 3) & 14) | ((390 >> 3) & 112));
            int $changed$iv$iv2 = (390 << 3) & 112;
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
            int i5 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i6 = ((390 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -533819691, "C278@11125L66,272@10820L386,282@11219L1340:RetainPopupDialog.kt#j7uxph");
            String $this$asRequest_u24default$iv = HelperKt.customizedImageUrl(HYG_GUIDE_BG_IMG);
            ImageRequest imageRequest = new ImageRequest($this$asRequest_u24default$iv);
            Unit unit = Unit.INSTANCE;
            ImmutableImageRequest build = imageRequest.build();
            Modifier modifier5 = SizeKt.height-3ABfNKs(SizeKt.width-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(266, scaleModel.getScale())), ProvideUiScaleKt.dpScaled(396, scaleModel.getScale()));
            ComposerKt.sourceInformationMarkerStart($composer3, 121335429, "CC(remember):RetainPopupDialog.kt#9igjgp");
            boolean invalid$iv = ($dirty2 & 112) == 32;
            Object it$iv = $composer3.rememberedValue();
            if (invalid$iv) {
            }
            Object value$iv = new Function0() { // from class: kntr.app.mall.product.details.page.ui.floatingLayer.RetainPopupDialogKt$$ExternalSyntheticLambda16
                public final Object invoke() {
                    Unit HYGGuidePopupComponent$lambda$0$0$0$0;
                    HYGGuidePopupComponent$lambda$0$0$0$0 = RetainPopupDialogKt.HYGGuidePopupComponent$lambda$0$0$0$0(function02);
                    return HYGGuidePopupComponent$lambda$0$0$0$0;
                }
            };
            $composer3.updateRememberedValue(value$iv);
            it$iv = value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            BiliImageKt.BiliImage(build, ClickableKt.clickable-oSLSa3U$default(modifier5, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null), null, null, null, null, null, null, null, $composer3, 0, 508);
            Modifier modifier$iv3 = PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, ProvideUiScaleKt.dpScaled(21, scaleModel.getScale()), 0.0f, 0.0f, 13, (Object) null);
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv3 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv3 = (384 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv3 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer3, modifier$iv3);
            Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
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
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
            int i7 = ($changed$iv$iv$iv3 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i8 = ((384 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 1337958354, "C295@11858L75,288@11447L505,299@11969L53,307@12452L74,300@12039L506:RetainPopupDialog.kt#j7uxph");
            String $this$asRequest_u24default$iv2 = HelperKt.customizedImageUrl(GUIDE_HIDE_IMG);
            ImageRequest imageRequest2 = new ImageRequest($this$asRequest_u24default$iv2);
            Unit unit2 = Unit.INSTANCE;
            ImmutableImageRequest build2 = imageRequest2.build();
            Modifier clip = ClipKt.clip(SizeKt.height-3ABfNKs(SizeKt.width-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(140, scaleModel.getScale())), ProvideUiScaleKt.dpScaled(40, scaleModel.getScale())), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(ProvideUiScaleKt.dpScaled(20, scaleModel.getScale())));
            ComposerKt.sourceInformationMarkerStart($composer3, -1896490574, "CC(remember):RetainPopupDialog.kt#9igjgp");
            boolean invalid$iv2 = ($dirty2 & 14) == 4;
            Object it$iv2 = $composer3.rememberedValue();
            if (invalid$iv2) {
            }
            Object value$iv2 = new Function0() { // from class: kntr.app.mall.product.details.page.ui.floatingLayer.RetainPopupDialogKt$$ExternalSyntheticLambda17
                public final Object invoke() {
                    Unit HYGGuidePopupComponent$lambda$0$0$1$0$0;
                    HYGGuidePopupComponent$lambda$0$0$1$0$0 = RetainPopupDialogKt.HYGGuidePopupComponent$lambda$0$0$1$0$0(function0);
                    return HYGGuidePopupComponent$lambda$0$0$1$0$0;
                }
            };
            $composer3.updateRememberedValue(value$iv2);
            it$iv2 = value$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            BiliImageKt.BiliImage(build2, ClickableKt.clickable-oSLSa3U$default(clip, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv2, 15, (Object) null), null, null, null, null, null, null, null, $composer3, 0, 508);
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(12, scaleModel.getScale())), $composer3, 0);
            String $this$asRequest_u24default$iv3 = HelperKt.customizedImageUrl(GUIDE_ACTION_IMG);
            ImageRequest imageRequest3 = new ImageRequest($this$asRequest_u24default$iv3);
            Unit unit3 = Unit.INSTANCE;
            ImmutableImageRequest build3 = imageRequest3.build();
            Modifier clip2 = ClipKt.clip(SizeKt.height-3ABfNKs(SizeKt.width-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(140, scaleModel.getScale())), ProvideUiScaleKt.dpScaled(40, scaleModel.getScale())), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(ProvideUiScaleKt.dpScaled(20, scaleModel.getScale())));
            ComposerKt.sourceInformationMarkerStart($composer3, -1896471567, "CC(remember):RetainPopupDialog.kt#9igjgp");
            boolean invalid$iv3 = ($dirty2 & 112) == 32;
            Object it$iv3 = $composer3.rememberedValue();
            if (invalid$iv3) {
            }
            Object value$iv3 = new Function0() { // from class: kntr.app.mall.product.details.page.ui.floatingLayer.RetainPopupDialogKt$$ExternalSyntheticLambda18
                public final Object invoke() {
                    Unit HYGGuidePopupComponent$lambda$0$0$1$1$0;
                    HYGGuidePopupComponent$lambda$0$0$1$1$0 = RetainPopupDialogKt.HYGGuidePopupComponent$lambda$0$0$1$1$0(function02);
                    return HYGGuidePopupComponent$lambda$0$0$1$1$0;
                }
            };
            $composer3.updateRememberedValue(value$iv3);
            it$iv3 = value$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            BiliImageKt.BiliImage(build3, ClickableKt.clickable-oSLSa3U$default(clip2, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv3, 15, (Object) null), null, null, null, null, null, null, null, $composer3, 0, 508);
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
            final Modifier modifier6 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.floatingLayer.RetainPopupDialogKt$$ExternalSyntheticLambda19
                public final Object invoke(Object obj, Object obj2) {
                    Unit HYGGuidePopupComponent$lambda$1;
                    HYGGuidePopupComponent$lambda$1 = RetainPopupDialogKt.HYGGuidePopupComponent$lambda$1(function0, function02, scaleModel, modifier6, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return HYGGuidePopupComponent$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HYGGuidePopupComponent$lambda$0$0$0$0(Function0 $onAction) {
        $onAction.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HYGGuidePopupComponent$lambda$0$0$1$0$0(Function0 $onDismiss) {
        $onDismiss.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HYGGuidePopupComponent$lambda$0$0$1$1$0(Function0 $onAction) {
        $onAction.invoke();
        return Unit.INSTANCE;
    }
}