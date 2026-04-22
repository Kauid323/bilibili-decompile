package kntr.app.mall.product.details.page.ui.components;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.gestures.FlingBehavior;
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
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.IntState;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shadow;
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
import java.util.List;
import kntr.app.mall.product.details.page.api.model.CouponInfoModel;
import kntr.app.mall.product.details.page.api.model.CouponPackageInfoModel;
import kntr.app.mall.product.details.page.kmm.ProductDetailsPageUpCouponDisplayModel;
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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CouponPopupComponent.kt */
@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\u001a\u001f\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0001¢\u0006\u0002\u0010\f\u001a7\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\n\u001a\u00020\u000b2\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u0013H\u0001¢\u0006\u0002\u0010\u0014\u001a)\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0003¢\u0006\u0002\u0010\u0018\u001a/\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00112\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u001b2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0003¢\u0006\u0002\u0010\u001c\u001a/\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00112\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u001b2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0003¢\u0006\u0002\u0010\u001c\u001a)\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0003¢\u0006\u0002\u0010\u0018\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001f²\u0006\n\u0010 \u001a\u00020!X\u008a\u0084\u0002²\u0006\n\u0010\"\u001a\u00020#X\u008a\u008e\u0002"}, d2 = {"UP_COUPON_POPUP_BG_IMG", "", "UP_COUPON_POPUP_BG_IMG_MULTIPLE", "UP_COUPON_POPUP_BUTTON_IMG", "UP_COUPON_POPUP_SINGLE_COUPON_IMG", "UP_COUPON_POPUP_MULTIPLE_COUPON_IMG", "CouponPopupComponent", "", "pageViewModelWrapper", "Lkntr/app/mall/product/details/page/vm/PageViewModelWrapper;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lkntr/app/mall/product/details/page/vm/PageViewModelWrapper;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "UPCouponPopupComponent", "displayModel", "Lkntr/app/mall/product/details/page/kmm/ProductDetailsPageUpCouponDisplayModel;", "scale", "", "onClose", "Lkotlin/Function0;", "(Lkntr/app/mall/product/details/page/kmm/ProductDetailsPageUpCouponDisplayModel;FLandroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "SingleCouponComponent", "couponInfoModel", "Lkntr/app/mall/product/details/page/api/model/CouponInfoModel;", "(FLkntr/app/mall/product/details/page/api/model/CouponInfoModel;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "DoubleCouponComponent", "couponInfoModelList", "", "(FLjava/util/List;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "MultipleCouponComponent", "CouponItemComponent", "product-details-page_debug", "scaleModel", "Lkntr/app/mall/product/details/page/ui/scale/UiScaleModel;", "countDownSeconds", ""}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class CouponPopupComponentKt {
    private static final String UP_COUPON_POPUP_BG_IMG = "http://i0.hdslb.com/bfs/kfptfe/floor/fb24c8558da722f1ad0af0e4192e6593b2c23325.png";
    private static final String UP_COUPON_POPUP_BG_IMG_MULTIPLE = "http://i0.hdslb.com/bfs/kfptfe/floor/e97cf5f7c821172071839baae7eeb30844573624.png";
    private static final String UP_COUPON_POPUP_BUTTON_IMG = "http://i0.hdslb.com/bfs/kfptfe/floor/f75c8ec077c49a4075c334b1648634dae8d4d306.png";
    private static final String UP_COUPON_POPUP_MULTIPLE_COUPON_IMG = "https://i0.hdslb.com/bfs/kfptfe/floor/79e5b8f21defb8babe8d0ba61d260fa740730a0f.png";
    private static final String UP_COUPON_POPUP_SINGLE_COUPON_IMG = "https://i0.hdslb.com/bfs/kfptfe/floor/3012160247903f86477a0372cf46d9edcab415e0.png";

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CouponItemComponent$lambda$1(float f, CouponInfoModel couponInfoModel, Modifier modifier, int i, int i2, Composer composer, int i3) {
        CouponItemComponent(f, couponInfoModel, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CouponPopupComponent$lambda$3(PageViewModelWrapper pageViewModelWrapper, Modifier modifier, int i, int i2, Composer composer, int i3) {
        CouponPopupComponent(pageViewModelWrapper, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DoubleCouponComponent$lambda$1(float f, List list, Modifier modifier, int i, int i2, Composer composer, int i3) {
        DoubleCouponComponent(f, list, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MultipleCouponComponent$lambda$1(float f, List list, Modifier modifier, int i, int i2, Composer composer, int i3) {
        MultipleCouponComponent(f, list, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SingleCouponComponent$lambda$1(float f, CouponInfoModel couponInfoModel, Modifier modifier, int i, int i2, Composer composer, int i3) {
        SingleCouponComponent(f, couponInfoModel, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UPCouponPopupComponent$lambda$1(ProductDetailsPageUpCouponDisplayModel productDetailsPageUpCouponDisplayModel, float f, Modifier modifier, Function0 function0, int i, int i2, Composer composer, int i3) {
        UPCouponPopupComponent(productDetailsPageUpCouponDisplayModel, f, modifier, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UPCouponPopupComponent$lambda$7(ProductDetailsPageUpCouponDisplayModel productDetailsPageUpCouponDisplayModel, float f, Modifier modifier, Function0 function0, int i, int i2, Composer composer, int i3) {
        UPCouponPopupComponent(productDetailsPageUpCouponDisplayModel, f, modifier, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void CouponPopupComponent(final PageViewModelWrapper pageViewModelWrapper, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        final Modifier modifier3;
        Intrinsics.checkNotNullParameter(pageViewModelWrapper, "pageViewModelWrapper");
        Composer $composer2 = $composer.startRestartGroup(-2070390723);
        ComposerKt.sourceInformation($composer2, "C(CouponPopupComponent)N(pageViewModelWrapper,modifier)71@3286L16,73@3405L16:CouponPopupComponent.kt#o90vz8");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(pageViewModelWrapper) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i2 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2070390723, $dirty2, -1, "kntr.app.mall.product.details.page.ui.components.CouponPopupComponent (CouponPopupComponent.kt:69)");
            }
            final PageViewModel pageVM = pageViewModelWrapper.getViewModel();
            State scaleModel$delegate = SnapshotStateKt.collectAsState(pageVM.getUiScaleModelFlow$product_details_page_debug(), (CoroutineContext) null, $composer2, 0, 1);
            final float scale = CouponPopupComponent$lambda$0(scaleModel$delegate).getScale();
            State displayModelState = SnapshotStateKt.collectAsState(pageVM.getUpCouponAutoFetchDisplayStateFlow$product_details_page_debug(), (CoroutineContext) null, $composer2, 0, 1);
            final ProductDetailsPageUpCouponDisplayModel displayModel = (ProductDetailsPageUpCouponDisplayModel) displayModelState.getValue();
            if (displayModel == null || !displayModel.isValid()) {
                $composer2.startReplaceGroup(1012253605);
            } else {
                $composer2.startReplaceGroup(1015773748);
                ComposerKt.sourceInformation($composer2, "77@3574L64,81@3726L514,76@3535L705");
                ComposerKt.sourceInformationMarkerStart($composer2, -1075610851, "CC(remember):CouponPopupComponent.kt#9igjgp");
                boolean invalid$iv = $composer2.changedInstance(pageVM);
                Object it$iv = $composer2.rememberedValue();
                if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function0() { // from class: kntr.app.mall.product.details.page.ui.components.CouponPopupComponentKt$$ExternalSyntheticLambda4
                        public final Object invoke() {
                            Unit CouponPopupComponent$lambda$1$0;
                            CouponPopupComponent$lambda$1$0 = CouponPopupComponentKt.CouponPopupComponent$lambda$1$0(PageViewModel.this);
                            return CouponPopupComponent$lambda$1$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                AndroidDialog_androidKt.Dialog((Function0) it$iv, new DialogProperties(false, false, false, 3, (DefaultConstructorMarker) null), ComposableLambdaKt.rememberComposableLambda(-1087025297, true, new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.CouponPopupComponentKt$$ExternalSyntheticLambda5
                    public final Object invoke(Object obj, Object obj2) {
                        Unit CouponPopupComponent$lambda$2;
                        CouponPopupComponent$lambda$2 = CouponPopupComponentKt.CouponPopupComponent$lambda$2(ProductDetailsPageUpCouponDisplayModel.this, scale, modifier3, pageVM, (Composer) obj, ((Integer) obj2).intValue());
                        return CouponPopupComponent$lambda$2;
                    }
                }, $composer2, 54), $composer2, 432, 0);
            }
            $composer2.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.CouponPopupComponentKt$$ExternalSyntheticLambda6
                public final Object invoke(Object obj, Object obj2) {
                    Unit CouponPopupComponent$lambda$3;
                    CouponPopupComponent$lambda$3 = CouponPopupComponentKt.CouponPopupComponent$lambda$3(PageViewModelWrapper.this, modifier3, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return CouponPopupComponent$lambda$3;
                }
            });
        }
    }

    private static final UiScaleModel CouponPopupComponent$lambda$0(State<UiScaleModel> state) {
        Object thisObj$iv = state.getValue();
        return (UiScaleModel) thisObj$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CouponPopupComponent$lambda$1$0(PageViewModel $pageVM) {
        $pageVM.hideAutoFetchedUpCoupon$product_details_page_debug();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CouponPopupComponent$lambda$2(ProductDetailsPageUpCouponDisplayModel $displayModel, float $scale, Modifier $modifier, final PageViewModel $pageVM, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C86@3903L72,82@3740L250,90@4024L206,90@4003L227:CouponPopupComponent.kt#o90vz8");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1087025297, $changed, -1, "kntr.app.mall.product.details.page.ui.components.CouponPopupComponent.<anonymous> (CouponPopupComponent.kt:82)");
            }
            ComposerKt.sourceInformationMarkerStart($composer, -954251753, "CC(remember):CouponPopupComponent.kt#9igjgp");
            boolean invalid$iv = $composer.changedInstance($pageVM);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function0() { // from class: kntr.app.mall.product.details.page.ui.components.CouponPopupComponentKt$$ExternalSyntheticLambda8
                    public final Object invoke() {
                        Unit CouponPopupComponent$lambda$2$0$0;
                        CouponPopupComponent$lambda$2$0$0 = CouponPopupComponentKt.CouponPopupComponent$lambda$2$0$0(PageViewModel.this);
                        return CouponPopupComponent$lambda$2$0$0;
                    }
                };
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            UPCouponPopupComponent($displayModel, $scale, $modifier, (Function0) it$iv, $composer, 0, 0);
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer, -954247747, "CC(remember):CouponPopupComponent.kt#9igjgp");
            boolean invalid$iv2 = $composer.changedInstance($displayModel) | $composer.changedInstance($pageVM);
            Object it$iv2 = $composer.rememberedValue();
            if (invalid$iv2 || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = (Function2) new CouponPopupComponentKt$CouponPopupComponent$2$2$1($displayModel, $pageVM, null);
                $composer.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            EffectsKt.LaunchedEffect(unit, (Function2) it$iv2, $composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CouponPopupComponent$lambda$2$0$0(PageViewModel $pageVM) {
        $pageVM.hideAutoFetchedUpCoupon$product_details_page_debug();
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v51 */
    public static final void UPCouponPopupComponent(final ProductDetailsPageUpCouponDisplayModel displayModel, final float scale, Modifier modifier, Function0<Unit> function0, Composer $composer, final int $changed, final int i) {
        final Function0<Unit> function02;
        Composer $composer2;
        Modifier modifier2;
        String str;
        Function0 factory$iv$iv$iv;
        BoxScope $this$UPCouponPopupComponent_u24lambda_u246;
        Function0 factory$iv$iv$iv2;
        Function0 factory$iv$iv$iv3;
        String popUpTitleSuffix;
        Function0 factory$iv$iv$iv4;
        Composer $composer$iv$iv$iv;
        String str2;
        MutableIntState countDownSeconds$delegate;
        Composer $composer$iv$iv;
        Composer $composer$iv;
        Composer $composer3;
        Composer $composer$iv$iv$iv2;
        Composer $composer$iv2;
        Composer $composer$iv3;
        Composer $composer4;
        Composer $composer$iv4;
        Composer $composer5;
        Composer $composer$iv5;
        boolean z;
        Composer $composer$iv$iv2;
        Composer $composer$iv$iv3;
        Composer $composer$iv6;
        Composer $composer6;
        Intrinsics.checkNotNullParameter(displayModel, "displayModel");
        Composer $composer7 = $composer.startRestartGroup(1228632850);
        ComposerKt.sourceInformation($composer7, "C(UPCouponPopupComponent)N(displayModel,scale,modifier,onClose)104@4436L2,114@4775L47,115@4848L136,115@4827L157,122@4989L5771:CouponPopupComponent.kt#o90vz8");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer7.changedInstance(displayModel) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer7.changed(scale) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty |= 384;
        } else if (($changed & 384) == 0) {
            $dirty |= $composer7.changed(modifier) ? 256 : 128;
        }
        int i3 = i & 8;
        if (i3 != 0) {
            $dirty |= 3072;
            function02 = function0;
        } else if (($changed & 3072) == 0) {
            function02 = function0;
            $dirty |= $composer7.changedInstance(function02) ? 2048 : 1024;
        } else {
            function02 = function0;
        }
        int $dirty2 = $dirty;
        if ($composer7.shouldExecute(($dirty2 & 1171) != 1170, $dirty2 & 1)) {
            Modifier modifier3 = i2 != 0 ? (Modifier) Modifier.Companion : modifier;
            if (i3 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer7, -399832268, "CC(remember):CouponPopupComponent.kt#9igjgp");
                Object it$iv = $composer7.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function0() { // from class: kntr.app.mall.product.details.page.ui.components.CouponPopupComponentKt$$ExternalSyntheticLambda9
                        public final Object invoke() {
                            Unit unit;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    };
                    $composer7.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                ComposerKt.sourceInformationMarkerEnd($composer7);
                function02 = it$iv;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1228632850, $dirty2, -1, "kntr.app.mall.product.details.page.ui.components.UPCouponPopupComponent (CouponPopupComponent.kt:105)");
            }
            List couponInfoList = displayModel.getValidCouponInfoList();
            List list = couponInfoList;
            if (list == null || list.isEmpty()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup = $composer7.endRestartGroup();
                if (endRestartGroup != null) {
                    final Modifier modifier4 = modifier3;
                    final Function0<Unit> function03 = function02;
                    endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.CouponPopupComponentKt$$ExternalSyntheticLambda10
                        public final Object invoke(Object obj, Object obj2) {
                            Unit UPCouponPopupComponent$lambda$1;
                            UPCouponPopupComponent$lambda$1 = CouponPopupComponentKt.UPCouponPopupComponent$lambda$1(ProductDetailsPageUpCouponDisplayModel.this, scale, modifier4, function03, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                            return UPCouponPopupComponent$lambda$1;
                        }
                    });
                    return;
                }
                return;
            }
            int count = couponInfoList.size();
            boolean needScrolling = count > 2;
            CouponPackageInfoModel.CouponPackagePopInfoModel popupInfoModel = displayModel.getPopupInfoModel();
            CouponPackageInfoModel.CouponPackagePopInfoModel.UserInfo relatedUpInfo = popupInfoModel != null ? popupInfoModel.getRelatedUpInfo() : null;
            ComposerKt.sourceInformationMarkerStart($composer7, -399821375, "CC(remember):CouponPopupComponent.kt#9igjgp");
            boolean invalid$iv = $composer7.changed(displayModel);
            Object it$iv2 = $composer7.rememberedValue();
            if (invalid$iv || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = SnapshotIntStateKt.mutableIntStateOf(6);
                $composer7.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            MutableIntState countDownSeconds$delegate2 = (MutableIntState) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer7);
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer7, -399818950, "CC(remember):CouponPopupComponent.kt#9igjgp");
            boolean invalid$iv2 = $composer7.changed(countDownSeconds$delegate2) | (($dirty2 & 7168) == 2048);
            Object it$iv3 = $composer7.rememberedValue();
            if (invalid$iv2 || it$iv3 == Composer.Companion.getEmpty()) {
                str = "CC(remember):CouponPopupComponent.kt#9igjgp";
                Object value$iv3 = (Function2) new CouponPopupComponentKt$UPCouponPopupComponent$3$1(function02, countDownSeconds$delegate2, null);
                $composer7.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
            } else {
                str = "CC(remember):CouponPopupComponent.kt#9igjgp";
            }
            ComposerKt.sourceInformationMarkerEnd($composer7);
            EffectsKt.LaunchedEffect(unit, (Function2) it$iv3, $composer7, 6);
            Modifier modifier$iv = SizeKt.width-3ABfNKs(modifier3, ProvideUiScaleKt.dpScaled(needScrolling ? 317 : 318, scale));
            ComposerKt.sourceInformationMarkerStart($composer7, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer7, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer7, 0));
            CompositionLocalMap localMap$iv$iv = $composer7.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer7, modifier$iv);
            Function0 factory$iv$iv$iv5 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer7, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer7.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer7.startReusableNode();
            if ($composer7.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv5;
                $composer7.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv5;
                $composer7.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer7);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i4 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer7, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            int i5 = ((0 >> 6) & 112) | 6;
            BoxScope $this$UPCouponPopupComponent_u24lambda_u2462 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer7, 2130793331, "C163@6401L4353:CouponPopupComponent.kt#o90vz8");
            String avatar = relatedUpInfo != null ? relatedUpInfo.getAvatar() : null;
            String str3 = avatar;
            if (str3 == null || str3.length() == 0) {
                $this$UPCouponPopupComponent_u24lambda_u246 = $this$UPCouponPopupComponent_u24lambda_u2462;
                $composer7.startReplaceGroup(2125344522);
            } else {
                $composer7.startReplaceGroup(2130708824);
                ComposerKt.sourceInformation($composer7, "137@5408L378");
                String $this$asRequest_u24default$iv = HelperKt.customizedImageUrl(avatar);
                ImageRequest imageRequest = new ImageRequest($this$asRequest_u24default$iv);
                Unit unit2 = Unit.INSTANCE;
                $this$UPCouponPopupComponent_u24lambda_u246 = $this$UPCouponPopupComponent_u24lambda_u2462;
                BiliImageKt.BiliImage(imageRequest.build(), ClipKt.clip(SizeKt.size-3ABfNKs(OffsetKt.absoluteOffset-VpY3zN4($this$UPCouponPopupComponent_u24lambda_u2462.align(Modifier.Companion, Alignment.Companion.getTopCenter()), ProvideUiScaleKt.dpScaled(4, scale), ProvideUiScaleKt.dpScaled(4, scale)), ProvideUiScaleKt.dpScaled(68, scale)), RoundedCornerShapeKt.getCircleShape()), null, null, null, null, null, null, null, $composer7, 0, 508);
            }
            $composer7.endReplaceGroup();
            if (needScrolling) {
                $composer7.startReplaceGroup(2131131757);
                ComposerKt.sourceInformation($composer7, "148@5838L261");
                String $this$asRequest_u24default$iv2 = HelperKt.customizedImageUrl(UP_COUPON_POPUP_BG_IMG_MULTIPLE);
                ImageRequest imageRequest2 = new ImageRequest($this$asRequest_u24default$iv2);
                Unit unit3 = Unit.INSTANCE;
                BiliImageKt.BiliImage(imageRequest2.build(), SizeKt.size-VpY3zN4(Modifier.Companion, ProvideUiScaleKt.dpScaled(317, scale), ProvideUiScaleKt.dpScaled(381, scale)), null, null, null, null, null, null, null, $composer7, 0, 508);
                $composer7.endReplaceGroup();
            } else {
                $composer7.startReplaceGroup(2131420150);
                ComposerKt.sourceInformation($composer7, "155@6129L252");
                String $this$asRequest_u24default$iv3 = HelperKt.customizedImageUrl(UP_COUPON_POPUP_BG_IMG);
                ImageRequest imageRequest3 = new ImageRequest($this$asRequest_u24default$iv3);
                Unit unit4 = Unit.INSTANCE;
                BiliImageKt.BiliImage(imageRequest3.build(), SizeKt.size-VpY3zN4(Modifier.Companion, ProvideUiScaleKt.dpScaled(318, scale), ProvideUiScaleKt.dpScaled(350, scale)), null, null, null, null, null, null, null, $composer7, 0, 508);
                $composer7.endReplaceGroup();
            }
            Modifier modifier$iv2 = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getCenterHorizontally();
            modifier2 = modifier3;
            ComposerKt.sourceInformationMarkerStart($composer7, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer7, ((390 >> 3) & 14) | ((390 >> 3) & 112));
            int $changed$iv$iv2 = (390 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer7, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer7, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer7.getCurrentCompositionLocalMap();
            $composer2 = $composer7;
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer7, modifier$iv2);
            Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer7, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer7.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer7.startReusableNode();
            if ($composer7.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv6;
                $composer7.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv6;
                $composer7.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer7);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i6 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer7, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i7 = ((390 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer7, -2003245965, "C169@6582L3725,260@10320L43,261@10376L368:CouponPopupComponent.kt#o90vz8");
            Modifier modifier$iv3 = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), needScrolling ? ProvideUiScaleKt.dpScaled(381, scale) : ProvideUiScaleKt.dpScaled(350, scale));
            Arrangement.Vertical verticalArrangement$iv2 = Arrangement.INSTANCE.getSpaceBetween();
            Alignment.Horizontal horizontalAlignment$iv2 = Alignment.Companion.getCenterHorizontally();
            ComposerKt.sourceInformationMarkerStart($composer7, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv3 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv2, horizontalAlignment$iv2, $composer7, ((432 >> 3) & 14) | ((432 >> 3) & 112));
            int $changed$iv$iv3 = (432 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer7, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer7, 0));
            CompositionLocalMap localMap$iv$iv3 = $composer7.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer7, modifier$iv3);
            Function0 factory$iv$iv$iv7 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer7, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer7.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer7.startReusableNode();
            if ($composer7.getInserting()) {
                factory$iv$iv$iv3 = factory$iv$iv$iv7;
                $composer7.createNode(factory$iv$iv$iv3);
            } else {
                factory$iv$iv$iv3 = factory$iv$iv$iv7;
                $composer7.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer7);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
            int i8 = ($changed$iv$iv$iv3 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer7, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope2 = ColumnScopeInstance.INSTANCE;
            int i9 = ((432 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer7, 2044749093, "C183@7131L45,184@7193L584,198@7794L496,210@8307L1494,254@10134L80,248@9818L415,258@10250L43:CouponPopupComponent.kt#o90vz8");
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(79, scale)), $composer7, 0);
            String uname = relatedUpInfo != null ? relatedUpInfo.getUname() : null;
            if (uname == null) {
                uname = "";
            }
            TextKt.Text-Nvy7gAk(uname + ((popupInfoModel != null ? popupInfoModel.getPopUpTitleSuffix() : null) != null ? popUpTitleSuffix : ""), SizeKt.height-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(24, scale)), ColorKt.Color(4279769372L), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, ProvideUiScaleKt.scaled(new TextStyle(0L, TextUnitKt.getSp(16), FontWeight.Companion.getW600(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(24), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646137, (DefaultConstructorMarker) null), scale), $composer7, 384, 24576, 114680);
            String popUpSubTitle = popupInfoModel != null ? popupInfoModel.getPopUpSubTitle() : null;
            TextKt.Text-Nvy7gAk(popUpSubTitle == null ? "" : popUpSubTitle, SizeKt.height-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(18, scale)), ColorKt.Color(4284573293L), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, ProvideUiScaleKt.scaled(new TextStyle(0L, TextUnitKt.getSp(13), FontWeight.Companion.getW400(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(18), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646137, (DefaultConstructorMarker) null), scale), $composer7, 384, 24576, 114680);
            Modifier modifier$iv4 = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), needScrolling ? ProvideUiScaleKt.dpScaled(188, scale) : ProvideUiScaleKt.dpScaled(157, scale));
            ComposerKt.sourceInformationMarkerStart($composer7, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv2 = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv4 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
            int $changed$iv$iv4 = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer7, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv4 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer7, 0));
            CompositionLocalMap localMap$iv$iv4 = $composer7.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer7, modifier$iv4);
            Function0 factory$iv$iv$iv8 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv4 = (($changed$iv$iv4 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer7, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer7.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer7.startReusableNode();
            if ($composer7.getInserting()) {
                factory$iv$iv$iv4 = factory$iv$iv$iv8;
                $composer7.createNode(factory$iv$iv$iv4);
            } else {
                factory$iv$iv$iv4 = factory$iv$iv$iv8;
                $composer7.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv4 = Updater.constructor-impl($composer7);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, measurePolicy$iv4, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, localMap$iv$iv4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv4, Integer.valueOf(compositeKeyHash$iv$iv4), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv4, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, materialized$iv$iv4, ComposeUiNode.Companion.getSetModifier());
            int i10 = ($changed$iv$iv$iv4 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer7, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i11 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer7, 1997015107, "C:CouponPopupComponent.kt#o90vz8");
            switch (count) {
                case 1:
                    $composer$iv$iv$iv = $composer7;
                    str2 = str;
                    countDownSeconds$delegate = countDownSeconds$delegate2;
                    $composer$iv$iv = $composer7;
                    $composer$iv = $composer7;
                    $composer3 = $composer7;
                    $composer$iv$iv$iv2 = $composer7;
                    $composer$iv2 = $composer7;
                    $composer$iv3 = $composer7;
                    $composer4 = $composer7;
                    $composer$iv4 = $composer7;
                    $composer5 = $composer7;
                    $composer$iv5 = $composer7;
                    z = true;
                    $composer$iv$iv2 = $composer7;
                    $composer$iv$iv3 = $composer7;
                    $composer$iv6 = $composer7;
                    $composer7.startReplaceGroup(1997036527);
                    ComposerKt.sourceInformation($composer7, "224@8843L241");
                    SingleCouponComponent(scale, couponInfoList != null ? (CouponInfoModel) CollectionsKt.first(couponInfoList) : null, SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), $composer7, (($dirty2 >> 3) & 14) | 384, 0);
                    $composer7.endReplaceGroup();
                    Unit unit5 = Unit.INSTANCE;
                    $composer6 = $composer7;
                    break;
                case 2:
                    $composer7.startReplaceGroup(1997361748);
                    ComposerKt.sourceInformation($composer7, "232@9171L236");
                    $composer$iv$iv$iv = $composer7;
                    $composer$iv$iv2 = $composer7;
                    $composer$iv$iv3 = $composer7;
                    $composer3 = $composer7;
                    $composer$iv$iv$iv2 = $composer7;
                    $composer4 = $composer7;
                    $composer$iv6 = $composer7;
                    str2 = str;
                    $composer$iv$iv = $composer7;
                    $composer$iv4 = $composer7;
                    $composer5 = $composer7;
                    $composer$iv5 = $composer7;
                    z = true;
                    countDownSeconds$delegate = countDownSeconds$delegate2;
                    $composer$iv = $composer7;
                    $composer$iv2 = $composer7;
                    $composer$iv3 = $composer7;
                    DoubleCouponComponent(scale, couponInfoList, SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), $composer7, (($dirty2 >> 3) & 14) | 384, 0);
                    $composer7.endReplaceGroup();
                    Unit unit6 = Unit.INSTANCE;
                    $composer6 = $composer7;
                    break;
                default:
                    $composer$iv$iv$iv = $composer7;
                    str2 = str;
                    countDownSeconds$delegate = countDownSeconds$delegate2;
                    $composer$iv$iv = $composer7;
                    $composer$iv = $composer7;
                    $composer3 = $composer7;
                    $composer$iv$iv$iv2 = $composer7;
                    $composer$iv2 = $composer7;
                    $composer$iv3 = $composer7;
                    $composer4 = $composer7;
                    $composer$iv4 = $composer7;
                    $composer5 = $composer7;
                    $composer$iv5 = $composer7;
                    z = true;
                    $composer$iv$iv2 = $composer7;
                    $composer$iv$iv3 = $composer7;
                    $composer$iv6 = $composer7;
                    $composer7.startReplaceGroup(1997685202);
                    ComposerKt.sourceInformation($composer7, "240@9497L238");
                    $composer6 = $composer7;
                    MultipleCouponComponent(scale, couponInfoList, SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), $composer7, (($dirty2 >> 3) & 14) | 384, 0);
                    $composer6.endReplaceGroup();
                    Unit unit7 = Unit.INSTANCE;
                    break;
            }
            ComposerKt.sourceInformationMarkerEnd($composer6);
            ComposerKt.sourceInformationMarkerEnd($composer$iv4);
            $composer$iv$iv$iv.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv3);
            ComposerKt.sourceInformationMarkerEnd($composer$iv2);
            String $this$asRequest_u24default$iv4 = HelperKt.customizedImageUrl(UP_COUPON_POPUP_BUTTON_IMG);
            ImageRequest imageRequest4 = new ImageRequest($this$asRequest_u24default$iv4);
            Unit unit8 = Unit.INSTANCE;
            ImmutableImageRequest build = imageRequest4.build();
            Modifier modifier5 = SizeKt.height-3ABfNKs(SizeKt.width-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(126, scale)), ProvideUiScaleKt.dpScaled(44, scale));
            Composer $composer8 = $composer4;
            ComposerKt.sourceInformationMarkerStart($composer8, 2144262644, str2);
            boolean invalid$iv3 = ($dirty2 & 7168) == 2048 ? z : false;
            Object it$iv4 = $composer8.rememberedValue();
            if (invalid$iv3 || it$iv4 == Composer.Companion.getEmpty()) {
                Object value$iv4 = new Function0() { // from class: kntr.app.mall.product.details.page.ui.components.CouponPopupComponentKt$$ExternalSyntheticLambda11
                    public final Object invoke() {
                        Unit UPCouponPopupComponent$lambda$6$0$0$1$0;
                        UPCouponPopupComponent$lambda$6$0$0$1$0 = CouponPopupComponentKt.UPCouponPopupComponent$lambda$6$0$0$1$0(function02);
                        return UPCouponPopupComponent$lambda$6$0$0$1$0;
                    }
                };
                $composer8.updateRememberedValue(value$iv4);
                it$iv4 = value$iv4;
            }
            ComposerKt.sourceInformationMarkerEnd($composer8);
            BiliImageKt.BiliImage(build, ClickableKt.clickable-oSLSa3U$default(modifier5, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv4, 15, (Object) null), null, null, null, null, null, null, null, $composer8, 0, 508);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(28, scale)), $composer8, 0);
            ComposerKt.sourceInformationMarkerEnd($composer8);
            ComposerKt.sourceInformationMarkerEnd($composer$iv5);
            $composer$iv$iv$iv2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv2);
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv3);
            ComposerKt.sourceInformationMarkerEnd($composer7);
            Composer $composer9 = $composer3;
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(16, scale)), $composer9, 0);
            TextKt.Text-Nvy7gAk(UPCouponPopupComponent$lambda$3(countDownSeconds$delegate) + "s后关闭", (Modifier) null, Color.Companion.getWhite-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, ProvideUiScaleKt.scaled(new TextStyle(0L, TextUnitKt.getSp(16), FontWeight.Companion.getW500(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(22), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646137, (DefaultConstructorMarker) null), scale), $composer9, 384, 24576, 114682);
            ComposerKt.sourceInformationMarkerEnd($composer9);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            $composer5.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer5);
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv2);
            ComposerKt.sourceInformationMarkerEnd($composer7);
            ComposerKt.sourceInformationMarkerEnd($composer7);
            ComposerKt.sourceInformationMarkerEnd($composer$iv6);
            $composer7.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer7);
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer7);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2 = $composer7;
            $composer2.skipToGroupEnd();
            modifier2 = modifier;
        }
        ScopeUpdateScope endRestartGroup2 = $composer2.endRestartGroup();
        if (endRestartGroup2 != null) {
            final Modifier modifier6 = modifier2;
            final Function0<Unit> function04 = function02;
            endRestartGroup2.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.CouponPopupComponentKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit UPCouponPopupComponent$lambda$7;
                    UPCouponPopupComponent$lambda$7 = CouponPopupComponentKt.UPCouponPopupComponent$lambda$7(ProductDetailsPageUpCouponDisplayModel.this, scale, modifier6, function04, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return UPCouponPopupComponent$lambda$7;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int UPCouponPopupComponent$lambda$3(MutableIntState $countDownSeconds$delegate) {
        IntState $this$getValue$iv = (IntState) $countDownSeconds$delegate;
        return $this$getValue$iv.getIntValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UPCouponPopupComponent$lambda$6$0$0$1$0(Function0 $onClose) {
        $onClose.invoke();
        return Unit.INSTANCE;
    }

    private static final void SingleCouponComponent(final float scale, final CouponInfoModel couponInfoModel, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Composer $composer2;
        Modifier modifier3;
        Modifier modifier4;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Function0 factory$iv$iv$iv3;
        Function0 factory$iv$iv$iv4;
        Function0 factory$iv$iv$iv5;
        Composer $composer3 = $composer.startRestartGroup(1261036826);
        ComposerKt.sourceInformation($composer3, "C(SingleCouponComponent)N(scale,couponInfoModel,modifier)282@10911L5160:CouponPopupComponent.kt#o90vz8");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(scale) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changed(couponInfoModel) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int $dirty2 = $dirty;
        if (!$composer3.shouldExecute(($dirty2 & 147) != 146, $dirty2 & 1)) {
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
                ComposerKt.traceEventStart(1261036826, $dirty2, -1, "kntr.app.mall.product.details.page.ui.components.SingleCouponComponent (CouponPopupComponent.kt:281)");
            }
            int $changed$iv = ($dirty2 >> 6) & 14;
            Modifier modifier$iv = modifier4;
            ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, (($changed$iv >> 3) & 14) | (($changed$iv >> 3) & 112));
            int $changed$iv$iv = ($changed$iv << 3) & 112;
            modifier3 = modifier4;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv6;
                $composer3.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv6;
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
            ComposerKt.sourceInformationMarkerStart($composer3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            int i4 = (($changed$iv >> 6) & 112) | 6;
            ColumnScope $this$SingleCouponComponent_u24lambda_u240 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, -1732666266, "C285@10964L42,286@11015L4998,402@16022L43:CouponPopupComponent.kt#o90vz8");
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(7, scale)), $composer3, 0);
            Modifier modifier$iv2 = ColumnScope.-CC.weight$default($this$SingleCouponComponent_u24lambda_u240, SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 1.0f, false, 2, (Object) null);
            Alignment.Horizontal horizontalAlignment$iv2 = Alignment.Companion.getCenterHorizontally();
            Arrangement.Vertical verticalArrangement$iv2 = Arrangement.INSTANCE.getSpaceBetween();
            ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv2, horizontalAlignment$iv2, $composer3, ((432 >> 3) & 14) | ((432 >> 3) & 112));
            int $changed$iv$iv2 = (432 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer3, modifier$iv2);
            Function0 factory$iv$iv$iv7 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv7;
                $composer3.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv7;
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
            int i6 = ((432 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -1371894926, "C294@11288L3008,361@14309L42,389@15553L450:CouponPopupComponent.kt#o90vz8");
            Modifier modifier$iv3 = SizeKt.height-3ABfNKs(SizeKt.width-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(138, scale)), ProvideUiScaleKt.dpScaled(96, scale));
            ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv3 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv3 = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv3 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer3, modifier$iv3);
            Function0 factory$iv$iv$iv8 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
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
            Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
            int i7 = ($changed$iv$iv$iv3 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i8 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -752366005, "C300@11486L180,304@11683L2599:CouponPopupComponent.kt#o90vz8");
            String $this$asRequest_u24default$iv = HelperKt.customizedImageUrl(UP_COUPON_POPUP_SINGLE_COUPON_IMG);
            ImageRequest imageRequest = new ImageRequest($this$asRequest_u24default$iv);
            Unit unit = Unit.INSTANCE;
            BiliImageKt.BiliImage(imageRequest.build(), SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), null, null, null, null, null, null, null, $composer3, 48, 508);
            Modifier modifier$iv4 = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
            Alignment.Horizontal horizontalAlignment$iv3 = Alignment.Companion.getCenterHorizontally();
            Arrangement.Vertical verticalArrangement$iv3 = Arrangement.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv4 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv3, horizontalAlignment$iv3, $composer3, ((438 >> 3) & 14) | ((438 >> 3) & 112));
            int $changed$iv$iv4 = (438 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv4 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv4 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer3, modifier$iv4);
            Function0 factory$iv$iv$iv9 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv4 = (($changed$iv$iv4 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv4 = factory$iv$iv$iv9;
                $composer3.createNode(factory$iv$iv$iv4);
            } else {
                factory$iv$iv$iv4 = factory$iv$iv$iv9;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv4 = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, measurePolicy$iv4, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, localMap$iv$iv4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv4, Integer.valueOf(compositeKeyHash$iv$iv4), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv4, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, materialized$iv$iv4, ComposeUiNode.Companion.getSetModifier());
            int i9 = ($changed$iv$iv$iv4 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope2 = ColumnScopeInstance.INSTANCE;
            int i10 = ((438 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -783723815, "C309@11920L1904,349@13846L418:CouponPopupComponent.kt#o90vz8");
            Modifier modifier$iv5 = Modifier.Companion;
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv5 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((390 >> 3) & 14) | ((390 >> 3) & 112));
            int $changed$iv$iv5 = (390 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv5 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv5 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv5 = ComposedModifierKt.materializeModifier($composer3, modifier$iv5);
            Function0 factory$iv$iv$iv10 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv5 = (($changed$iv$iv5 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv5 = factory$iv$iv$iv10;
                $composer3.createNode(factory$iv$iv$iv5);
            } else {
                factory$iv$iv$iv5 = factory$iv$iv$iv10;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv5 = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, measurePolicy$iv5, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, localMap$iv$iv5, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv5, Integer.valueOf(compositeKeyHash$iv$iv5), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv5, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, materialized$iv$iv5, ComposeUiNode.Companion.getSetModifier());
            int i11 = ($changed$iv$iv$iv5 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i12 = ((390 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 631505645, "C313@12090L534,324@12649L594,336@13268L534:CouponPopupComponent.kt#o90vz8");
            String discountYPrefix = couponInfoModel != null ? couponInfoModel.getDiscountYPrefix() : null;
            TextKt.Text-Nvy7gAk(discountYPrefix == null ? "" : discountYPrefix, OffsetKt.offset-VpY3zN4$default(Modifier.Companion, 0.0f, ProvideUiScaleKt.dpScaled(2, scale), 1, (Object) null), ColorKt.Color(4294928025L), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, ProvideUiScaleKt.scaled(new TextStyle(0L, TextUnitKt.getSp(20), FontWeight.Companion.getW600(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777209, (DefaultConstructorMarker) null), scale), $composer3, 384, 24576, 114680);
            String discountY = couponInfoModel != null ? couponInfoModel.getDiscountY() : null;
            TextKt.Text-Nvy7gAk(discountY == null ? "" : discountY, PaddingKt.padding-VpY3zN4$default(Modifier.Companion, ProvideUiScaleKt.dpScaled(2, scale), 0.0f, 2, (Object) null), ColorKt.Color(4294928025L), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, ProvideUiScaleKt.scaled(new TextStyle(0L, TextUnitKt.getSp(32), FontWeight.Companion.getW600(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(36), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646137, (DefaultConstructorMarker) null), scale), $composer3, 384, 24576, 114680);
            String discountYSuffix = couponInfoModel != null ? couponInfoModel.getDiscountYSuffix() : null;
            boolean z = true;
            TextKt.Text-Nvy7gAk(discountYSuffix == null ? "" : discountYSuffix, OffsetKt.offset-VpY3zN4$default(Modifier.Companion, 0.0f, ProvideUiScaleKt.dpScaled(2, scale), 1, (Object) null), ColorKt.Color(4294928025L), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, ProvideUiScaleKt.scaled(new TextStyle(0L, TextUnitKt.getSp(20), FontWeight.Companion.getW600(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777209, (DefaultConstructorMarker) null), scale), $composer3, 384, 24576, 114680);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            String couponTypeDesc = couponInfoModel != null ? couponInfoModel.getCouponTypeDesc() : null;
            TextKt.Text-Nvy7gAk(couponTypeDesc == null ? "" : couponTypeDesc, (Modifier) null, ColorKt.Color(4294928025L), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, ProvideUiScaleKt.scaled(new TextStyle(0L, TextUnitKt.getSp(14), FontWeight.Companion.getW500(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777209, (DefaultConstructorMarker) null), scale), $composer3, 384, 24576, 114682);
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
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(2, scale)), $composer3, 0);
            String couponUseStartTimeStr = couponInfoModel != null ? couponInfoModel.getCouponUseStartTimeStr() : null;
            if (couponUseStartTimeStr == null || couponUseStartTimeStr.length() == 0) {
                String couponUseEndTimeStr = couponInfoModel != null ? couponInfoModel.getCouponUseEndTimeStr() : null;
                if (couponUseEndTimeStr != null && couponUseEndTimeStr.length() != 0) {
                    z = false;
                }
                if (!z) {
                    $composer3.startReplaceGroup(-1368309808);
                    ComposerKt.sourceInformation($composer3, "376@15034L492");
                    TextKt.Text-Nvy7gAk(couponInfoModel.getCouponUseEndTimeStr(), SizeKt.height-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(20, scale)), ColorKt.Color(4284573293L), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, ProvideUiScaleKt.scaled(new TextStyle(0L, TextUnitKt.getSp(14), FontWeight.Companion.getW400(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(20), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646137, (DefaultConstructorMarker) null), scale), $composer3, 384, 24576, 114680);
                } else {
                    $composer3.startReplaceGroup(-1383239780);
                }
                $composer3.endReplaceGroup();
            } else {
                $composer3.startReplaceGroup(-1368896018);
                ComposerKt.sourceInformation($composer3, "363@14443L494");
                TextKt.Text-Nvy7gAk(couponInfoModel.getCouponUseStartTimeStr(), SizeKt.height-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(20, scale)), ColorKt.Color(4284573293L), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, ProvideUiScaleKt.scaled(new TextStyle(0L, TextUnitKt.getSp(14), FontWeight.Companion.getW400(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(20), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646137, (DefaultConstructorMarker) null), scale), $composer3, 384, 24576, 114680);
                $composer3.endReplaceGroup();
            }
            String couponDesc = couponInfoModel != null ? couponInfoModel.getCouponDesc() : null;
            TextKt.Text-Nvy7gAk(couponDesc == null ? "" : couponDesc, SizeKt.height-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(20, scale)), ColorKt.Color(4284573293L), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, ProvideUiScaleKt.scaled(new TextStyle(0L, TextUnitKt.getSp(14), FontWeight.Companion.getW400(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(20), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646137, (DefaultConstructorMarker) null), scale), $composer3, 384, 24576, 114680);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(12, scale)), $composer3, 0);
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
            final Modifier modifier5 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.CouponPopupComponentKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    Unit SingleCouponComponent$lambda$1;
                    SingleCouponComponent$lambda$1 = CouponPopupComponentKt.SingleCouponComponent$lambda$1(scale, couponInfoModel, modifier5, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return SingleCouponComponent$lambda$1;
                }
            });
        }
    }

    private static final void DoubleCouponComponent(final float scale, final List<CouponInfoModel> list, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Modifier modifier3;
        Modifier modifier4;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Composer $composer$iv$iv$iv;
        Composer $composer2;
        Composer $composer$iv;
        Composer $composer$iv$iv$iv2;
        Composer $composer$iv$iv;
        Composer $composer$iv$iv2;
        Composer $composer$iv2;
        Composer $composer3 = $composer.startRestartGroup(1978951866);
        ComposerKt.sourceInformation($composer3, "C(DoubleCouponComponent)N(scale,couponInfoModelList,modifier)412@16232L621:CouponPopupComponent.kt#o90vz8");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(scale) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changedInstance(list) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int $dirty2 = $dirty;
        if (!$composer3.shouldExecute(($dirty2 & 147) != 146, $dirty2 & 1)) {
            $composer3.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1978951866, $dirty2, -1, "kntr.app.mall.product.details.page.ui.components.DoubleCouponComponent (CouponPopupComponent.kt:411)");
            }
            int $changed$iv = ($dirty2 >> 6) & 14;
            Modifier modifier$iv = modifier4;
            ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, Alignment.Companion.getStart(), $composer3, (($changed$iv >> 3) & 14) | (($changed$iv >> 3) & 112));
            int $changed$iv$iv = ($changed$iv << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            Arrangement.Vertical verticalArrangement$iv2 = verticalArrangement$iv;
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
            modifier3 = modifier4;
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv >> 6) & 14;
            Composer $composer$iv$iv$iv3 = $composer3;
            ComposerKt.sourceInformationMarkerStart($composer3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            int i4 = (($changed$iv >> 6) & 112) | 6;
            ColumnScope $this$DoubleCouponComponent_u24lambda_u240 = ColumnScopeInstance.INSTANCE;
            Composer $composer$iv3 = $composer3;
            ComposerKt.sourceInformationMarkerStart($composer3, 974846669, "C415@16285L42,416@16336L459,431@16804L43:CouponPopupComponent.kt#o90vz8");
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(7, scale)), $composer3, 0);
            Modifier modifier$iv2 = ColumnScope.-CC.weight$default($this$DoubleCouponComponent_u24lambda_u240, SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 1.0f, false, 2, (Object) null);
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getCenterHorizontally();
            ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getSpaceBetween(), horizontalAlignment$iv, $composer3, ((432 >> 3) & 14) | ((432 >> 3) & 112));
            int $changed$iv$iv2 = (432 << 3) & 112;
            Composer $composer$iv4 = $composer3;
            Alignment.Horizontal horizontalAlignment$iv2 = horizontalAlignment$iv;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer3, modifier$iv2);
            Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            Composer $composer$iv$iv$iv4 = $composer3;
            Composer $composer$iv5 = $composer3;
            ComposerKt.sourceInformationMarkerStart($composer$iv$iv$iv4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer$iv$iv$iv4.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer$iv$iv$iv4.startReusableNode();
            if ($composer$iv$iv$iv4.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv4;
                $composer$iv$iv$iv4.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv4;
                $composer$iv$iv$iv4.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer$iv$iv$iv4);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i5 = ($changed$iv$iv$iv2 >> 6) & 14;
            Composer $composer$iv6 = $composer$iv$iv$iv4;
            ComposerKt.sourceInformationMarkerStart($composer$iv6, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i6 = ((432 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer$iv6, 1869862789, "C:CouponPopupComponent.kt#o90vz8");
            if (list == null) {
                $composer$iv6.startReplaceGroup(1869882968);
                $composer$iv6.endReplaceGroup();
                $composer$iv$iv$iv = $composer$iv$iv$iv4;
                $composer2 = $composer$iv6;
                $composer$iv = $composer$iv6;
                $composer$iv$iv$iv2 = $composer$iv$iv$iv3;
                $composer$iv$iv = $composer$iv5;
                $composer$iv$iv2 = $composer$iv4;
                $composer$iv2 = $composer$iv3;
            } else {
                $composer$iv6.startReplaceGroup(1869882969);
                ComposerKt.sourceInformation($composer$iv6, "*425@16656L115");
                List<CouponInfoModel> $this$forEach$iv = list;
                for (Object element$iv : $this$forEach$iv) {
                    CouponInfoModel it = (CouponInfoModel) element$iv;
                    Composer $composer$iv$iv3 = $composer$iv5;
                    Composer $composer$iv$iv4 = $composer$iv4;
                    CouponItemComponent(scale, it, null, $composer$iv6, $dirty2 & 14, 4);
                    $composer$iv4 = $composer$iv$iv4;
                    $composer$iv6 = $composer$iv6;
                    $composer$iv$iv$iv4 = $composer$iv$iv$iv4;
                    $composer$iv5 = $composer$iv$iv3;
                    $composer$iv$iv$iv3 = $composer$iv$iv$iv3;
                    localMap$iv$iv2 = localMap$iv$iv2;
                    verticalArrangement$iv2 = verticalArrangement$iv2;
                    horizontalAlignment$iv2 = horizontalAlignment$iv2;
                    $composer$iv3 = $composer$iv3;
                }
                $composer$iv$iv$iv = $composer$iv$iv$iv4;
                $composer2 = $composer$iv6;
                $composer$iv = $composer$iv6;
                $composer$iv$iv$iv2 = $composer$iv$iv$iv3;
                $composer$iv$iv = $composer$iv5;
                $composer$iv$iv2 = $composer$iv4;
                $composer$iv2 = $composer$iv3;
                $composer2.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            $composer$iv$iv$iv.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv2);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(12, scale)), $composer3, 0);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer$iv2);
            $composer$iv$iv$iv2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv2);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer3.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.CouponPopupComponentKt$$ExternalSyntheticLambda7
                public final Object invoke(Object obj, Object obj2) {
                    Unit DoubleCouponComponent$lambda$1;
                    DoubleCouponComponent$lambda$1 = CouponPopupComponentKt.DoubleCouponComponent$lambda$1(scale, list, modifier5, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return DoubleCouponComponent$lambda$1;
                }
            });
        }
    }

    private static final void MultipleCouponComponent(final float scale, final List<CouponInfoModel> list, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Modifier modifier3;
        Modifier modifier4;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Composer $composer2;
        Composer $composer$iv;
        Composer $composer3;
        Composer $composer$iv$iv$iv;
        Composer $composer$iv$iv;
        Composer $composer$iv2;
        Composer $composer$iv3;
        Composer $composer$iv4;
        Composer $composer$iv$iv$iv2;
        char c;
        Composer $composer4 = $composer.startRestartGroup(-112719175);
        ComposerKt.sourceInformation($composer4, "C(MultipleCouponComponent)N(scale,couponInfoModelList,modifier)441@17034L21,442@17060L744:CouponPopupComponent.kt#o90vz8");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer4.changed(scale) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer4.changedInstance(list) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty |= $composer4.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int $dirty2 = $dirty;
        if (!$composer4.shouldExecute(($dirty2 & 147) != 146, $dirty2 & 1)) {
            $composer4.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-112719175, $dirty2, -1, "kntr.app.mall.product.details.page.ui.components.MultipleCouponComponent (CouponPopupComponent.kt:440)");
            }
            ScrollState scrollState = ScrollKt.rememberScrollState(0, $composer4, 0, 1);
            int $changed$iv = ($dirty2 >> 6) & 14;
            Modifier modifier$iv = modifier4;
            ComposerKt.sourceInformationMarkerStart($composer4, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer4, (($changed$iv >> 3) & 14) | (($changed$iv >> 3) & 112));
            int $changed$iv$iv = ($changed$iv << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
            CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer4, modifier$iv);
            Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer4.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer4.startReusableNode();
            if ($composer4.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer4.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer4.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer4);
            Composer $composer$iv5 = $composer4;
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer4, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            int i4 = (($changed$iv >> 6) & 112) | 6;
            ColumnScope $this$MultipleCouponComponent_u24lambda_u240 = ColumnScopeInstance.INSTANCE;
            Composer $composer$iv6 = $composer4;
            Modifier materialized$iv$iv2 = materialized$iv$iv;
            ComposerKt.sourceInformationMarkerStart($composer4, 1818021331, "C445@17113L42,446@17164L582,464@17755L43:CouponPopupComponent.kt#o90vz8");
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(8, scale)), $composer4, 0);
            Modifier modifier$iv2 = ScrollKt.verticalScroll$default(ColumnScope.-CC.weight$default($this$MultipleCouponComponent_u24lambda_u240, SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 1.0f, false, 2, (Object) null), scrollState, false, (FlingBehavior) null, false, 14, (Object) null);
            Alignment.Horizontal horizontalAlignment$iv2 = Alignment.Companion.getCenterHorizontally();
            ComposerKt.sourceInformationMarkerStart($composer4, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv2 = Arrangement.INSTANCE.getTop();
            MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv2, horizontalAlignment$iv2, $composer4, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv2 = (384 << 3) & 112;
            Composer $composer5 = $composer4;
            Composer $composer$iv$iv2 = $composer4;
            ComposerKt.sourceInformationMarkerStart($composer$iv$iv2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv$iv2, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer$iv$iv2.getCurrentCompositionLocalMap();
            Modifier modifier5 = modifier4;
            Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer$iv$iv2, modifier$iv2);
            Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
            Arrangement.Vertical verticalArrangement$iv3 = verticalArrangement$iv2;
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            Composer $composer$iv7 = $composer4;
            Composer $composer$iv$iv$iv3 = $composer$iv$iv2;
            ComposerKt.sourceInformationMarkerStart($composer$iv$iv$iv3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer$iv$iv$iv3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer$iv$iv$iv3.startReusableNode();
            if ($composer$iv$iv$iv3.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv4;
                $composer$iv$iv$iv3.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv4;
                $composer$iv$iv$iv3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer$iv$iv$iv3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            MeasurePolicy measurePolicy$iv$iv = measurePolicy$iv2;
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
            int i5 = ($changed$iv$iv$iv2 >> 6) & 14;
            Composer $composer$iv8 = $composer$iv$iv$iv3;
            ComposerKt.sourceInformationMarkerStart($composer$iv8, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i6 = ((384 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer$iv8, -1352235424, "C:CouponPopupComponent.kt#o90vz8");
            if (list == null) {
                $composer$iv8.startReplaceGroup(-1352215245);
                $composer$iv8.endReplaceGroup();
                $composer2 = $composer$iv8;
                $composer$iv = $composer$iv8;
                $composer3 = $composer5;
                $composer$iv$iv$iv = $composer$iv$iv$iv3;
                $composer$iv$iv = $composer$iv$iv2;
                $composer$iv2 = $composer$iv7;
                $composer$iv3 = $composer$iv5;
                $composer$iv4 = $composer$iv6;
            } else {
                $composer$iv8.startReplaceGroup(-1352215244);
                ComposerKt.sourceInformation($composer$iv8, "*458@17607L115");
                List<CouponInfoModel> $this$forEachIndexed$iv = list;
                int index$iv = 0;
                for (Object item$iv : $this$forEachIndexed$iv) {
                    int index$iv2 = index$iv + 1;
                    if (index$iv < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    CouponInfoModel it = (CouponInfoModel) item$iv;
                    int index = index$iv;
                    if (index > 0) {
                        $composer$iv8.startReplaceGroup(812522134);
                        ComposerKt.sourceInformation($composer$iv8, "456@17530L42");
                        $composer$iv$iv$iv2 = $composer$iv$iv$iv3;
                        c = 4;
                        SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(4, scale)), $composer$iv8, 0);
                    } else {
                        $composer$iv$iv$iv2 = $composer$iv$iv$iv3;
                        c = 4;
                        $composer$iv8.startReplaceGroup(795150664);
                    }
                    $composer$iv8.endReplaceGroup();
                    CouponItemComponent(scale, it, null, $composer$iv8, $dirty2 & 14, 4);
                    $composer$iv$iv$iv3 = $composer$iv$iv$iv2;
                    $composer$iv$iv2 = $composer$iv$iv2;
                    index$iv = index$iv2;
                    measurePolicy$iv$iv = measurePolicy$iv$iv;
                    $composer$iv8 = $composer$iv8;
                    verticalArrangement$iv3 = verticalArrangement$iv3;
                    materialized$iv$iv2 = materialized$iv$iv2;
                    $composer5 = $composer5;
                    $composer$iv5 = $composer$iv5;
                    $composer$iv7 = $composer$iv7;
                    $composer$iv6 = $composer$iv6;
                }
                $composer2 = $composer$iv8;
                $composer$iv = $composer$iv8;
                $composer3 = $composer5;
                $composer$iv$iv$iv = $composer$iv$iv$iv3;
                $composer$iv$iv = $composer$iv$iv2;
                Composer composer = $composer$iv6;
                $composer$iv2 = $composer$iv7;
                $composer$iv3 = $composer$iv5;
                $composer$iv4 = composer;
                $composer2.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            $composer$iv$iv$iv.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv2);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(10, scale)), $composer3, 0);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer$iv4);
            $composer4.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer$iv3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier5;
        }
        ScopeUpdateScope endRestartGroup = $composer4.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier6 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.CouponPopupComponentKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    Unit MultipleCouponComponent$lambda$1;
                    MultipleCouponComponent$lambda$1 = CouponPopupComponentKt.MultipleCouponComponent$lambda$1(scale, list, modifier6, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return MultipleCouponComponent$lambda$1;
                }
            });
        }
    }

    private static final void CouponItemComponent(final float scale, final CouponInfoModel couponInfoModel, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Composer $composer2;
        Modifier modifier3;
        Modifier modifier4;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Function0 factory$iv$iv$iv3;
        Function0 factory$iv$iv$iv4;
        Function0 factory$iv$iv$iv5;
        Composer $composer3 = $composer.startRestartGroup(-2078254481);
        ComposerKt.sourceInformation($composer3, "C(CouponItemComponent)N(scale,couponInfoModel,modifier)474@17953L5196:CouponPopupComponent.kt#o90vz8");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(scale) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changed(couponInfoModel) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int $dirty2 = $dirty;
        if (!$composer3.shouldExecute(($dirty2 & 147) != 146, $dirty2 & 1)) {
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
                ComposerKt.traceEventStart(-2078254481, $dirty2, -1, "kntr.app.mall.product.details.page.ui.components.CouponItemComponent (CouponPopupComponent.kt:473)");
            }
            Alignment contentAlignment$iv = Alignment.Companion.getCenter();
            int $changed$iv = (($dirty2 >> 6) & 14) | 48;
            Modifier modifier$iv = modifier4;
            ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = ($changed$iv << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
            modifier3 = modifier4;
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv6;
                $composer3.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv6;
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
            int i4 = (($changed$iv >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -1700970713, "C478@18048L207,483@18265L4878:CouponPopupComponent.kt#o90vz8");
            String $this$asRequest_u24default$iv = HelperKt.customizedImageUrl(UP_COUPON_POPUP_MULTIPLE_COUPON_IMG);
            ImageRequest imageRequest = new ImageRequest($this$asRequest_u24default$iv);
            Unit unit = Unit.INSTANCE;
            BiliImageKt.BiliImage(imageRequest.build(), SizeKt.size-VpY3zN4(Modifier.Companion, ProvideUiScaleKt.dpScaled(220, scale), ProvideUiScaleKt.dpScaled(66, scale)), null, null, null, null, null, null, null, $composer3, 0, 508);
            Modifier modifier$iv2 = SizeKt.size-VpY3zN4(Modifier.Companion, ProvideUiScaleKt.dpScaled(220, scale), ProvideUiScaleKt.dpScaled(66, scale));
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv2 = (384 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer3, modifier$iv2);
            Function0 factory$iv$iv$iv7 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            $composer2 = $composer3;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv7;
                $composer3.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv7;
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
            int i6 = ((384 >> 6) & 112) | 6;
            RowScope $this$CouponItemComponent_u24lambda_u240_u240 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, -1855036705, "C487@18450L2632,548@21095L2038:CouponPopupComponent.kt#o90vz8");
            Modifier modifier$iv3 = SizeKt.fillMaxHeight$default(SizeKt.width-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(75, scale)), 0.0f, 1, (Object) null);
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getCenterHorizontally();
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv3 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((432 >> 3) & 14) | ((432 >> 3) & 112));
            int $changed$iv$iv3 = (432 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv3 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer3, modifier$iv3);
            Function0 factory$iv$iv$iv8 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
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
            Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
            int i7 = ($changed$iv$iv$iv3 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i8 = ((432 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -1510254347, "C495@18765L1856,536@20638L430:CouponPopupComponent.kt#o90vz8");
            Modifier modifier$iv4 = Modifier.Companion;
            Alignment.Vertical verticalAlignment$iv2 = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv4 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer3, ((390 >> 3) & 14) | ((390 >> 3) & 112));
            int $changed$iv$iv4 = (390 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv4 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv4 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer3, modifier$iv4);
            Function0 factory$iv$iv$iv9 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv4 = (($changed$iv$iv4 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv4 = factory$iv$iv$iv9;
                $composer3.createNode(factory$iv$iv$iv4);
            } else {
                factory$iv$iv$iv4 = factory$iv$iv$iv9;
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
            int i10 = ((390 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -399967076, "C499@18919L546,511@19486L550,523@20057L546:CouponPopupComponent.kt#o90vz8");
            String discountYPrefix = couponInfoModel != null ? couponInfoModel.getDiscountYPrefix() : null;
            TextKt.Text-Nvy7gAk(discountYPrefix == null ? "" : discountYPrefix, OffsetKt.offset-VpY3zN4$default(Modifier.Companion, 0.0f, ProvideUiScaleKt.dpScaled(1, scale), 1, (Object) null), ColorKt.Color(4294928025L), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, ProvideUiScaleKt.scaled(new TextStyle(0L, TextUnitKt.getSp(16), FontWeight.Companion.getW600(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(20), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646137, (DefaultConstructorMarker) null), scale), $composer3, 384, 24576, 114680);
            String discountY = couponInfoModel != null ? couponInfoModel.getDiscountY() : null;
            TextKt.Text-Nvy7gAk(discountY == null ? "" : discountY, PaddingKt.padding-VpY3zN4$default(Modifier.Companion, ProvideUiScaleKt.dpScaled(1, scale), 0.0f, 2, (Object) null), ColorKt.Color(4294928025L), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, ProvideUiScaleKt.scaled(new TextStyle(0L, TextUnitKt.getSp(24), FontWeight.Companion.getW600(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(30), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646137, (DefaultConstructorMarker) null), scale), $composer3, 384, 24576, 114680);
            String discountYSuffix = couponInfoModel != null ? couponInfoModel.getDiscountYSuffix() : null;
            TextKt.Text-Nvy7gAk(discountYSuffix == null ? "" : discountYSuffix, OffsetKt.offset-VpY3zN4$default(Modifier.Companion, 0.0f, ProvideUiScaleKt.dpScaled(1, scale), 1, (Object) null), ColorKt.Color(4294928025L), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, ProvideUiScaleKt.scaled(new TextStyle(0L, TextUnitKt.getSp(16), FontWeight.Companion.getW600(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(20), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646137, (DefaultConstructorMarker) null), scale), $composer3, 384, 24576, 114680);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            String couponTypeDesc = couponInfoModel != null ? couponInfoModel.getCouponTypeDesc() : null;
            TextKt.Text-Nvy7gAk(couponTypeDesc == null ? "" : couponTypeDesc, (Modifier) null, ColorKt.Color(4279769372L), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, ProvideUiScaleKt.scaled(new TextStyle(0L, TextUnitKt.getSp(12), FontWeight.Companion.getW400(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(16), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646137, (DefaultConstructorMarker) null), scale), $composer3, 384, 24576, 114682);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifier$iv5 = PaddingKt.padding-qDBjuR0$default(RowScope.-CC.weight$default($this$CouponItemComponent_u24lambda_u240_u240, SizeKt.fillMaxHeight$default(Modifier.Companion, 0.0f, 1, (Object) null), 1.0f, false, 2, (Object) null), ProvideUiScaleKt.dpScaled(10, scale), 0.0f, ProvideUiScaleKt.dpScaled(7, scale), 0.0f, 10, (Object) null);
            Arrangement.Vertical verticalArrangement$iv2 = Arrangement.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Alignment.Horizontal horizontalAlignment$iv2 = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv5 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv2, horizontalAlignment$iv2, $composer3, ((48 >> 3) & 14) | ((48 >> 3) & 112));
            int $changed$iv$iv5 = (48 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv5 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv5 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv5 = ComposedModifierKt.materializeModifier($composer3, modifier$iv5);
            Function0 factory$iv$iv$iv10 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv5 = (($changed$iv$iv5 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv5 = factory$iv$iv$iv10;
                $composer3.createNode(factory$iv$iv$iv5);
            } else {
                factory$iv$iv$iv5 = factory$iv$iv$iv10;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv5 = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, measurePolicy$iv5, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, localMap$iv$iv5, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv5, Integer.valueOf(compositeKeyHash$iv$iv5), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv5, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, materialized$iv$iv5, ComposeUiNode.Companion.getSetModifier());
            int i11 = ($changed$iv$iv$iv5 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope2 = ColumnScopeInstance.INSTANCE;
            int i12 = ((48 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -2008112109, "C556@21413L494,568@21924L42:CouponPopupComponent.kt#o90vz8");
            String couponDesc = couponInfoModel != null ? couponInfoModel.getCouponDesc() : null;
            TextKt.Text-Nvy7gAk(couponDesc == null ? "" : couponDesc, SizeKt.height-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(20, scale)), ColorKt.Color(4279769372L), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, ProvideUiScaleKt.scaled(new TextStyle(0L, TextUnitKt.getSp(14), FontWeight.Companion.getW400(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(20), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646137, (DefaultConstructorMarker) null), scale), $composer3, 384, 24576, 114680);
            boolean z = false;
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(2, scale)), $composer3, 0);
            String couponUseStartTimeStr = couponInfoModel != null ? couponInfoModel.getCouponUseStartTimeStr() : null;
            if (!(couponUseStartTimeStr == null || couponUseStartTimeStr.length() == 0)) {
                $composer3.startReplaceGroup(-2007502774);
                ComposerKt.sourceInformation($composer3, "570@22066L466");
                TextKt.Text-Nvy7gAk(couponInfoModel.getCouponUseStartTimeStr(), (Modifier) null, ColorKt.Color(4287928736L), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, ProvideUiScaleKt.scaled(new TextStyle(0L, TextUnitKt.getSp(11), FontWeight.Companion.getW400(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(12), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646137, (DefaultConstructorMarker) null), scale), $composer3, 384, 24576, 114682);
                $composer3.endReplaceGroup();
            } else {
                String couponUseEndTimeStr = couponInfoModel != null ? couponInfoModel.getCouponUseEndTimeStr() : null;
                if (!((couponUseEndTimeStr == null || couponUseEndTimeStr.length() == 0) ? true : true)) {
                    $composer3.startReplaceGroup(-2006936404);
                    ComposerKt.sourceInformation($composer3, "582@22637L464");
                    TextKt.Text-Nvy7gAk(couponInfoModel.getCouponUseEndTimeStr(), (Modifier) null, ColorKt.Color(4287928736L), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, ProvideUiScaleKt.scaled(new TextStyle(0L, TextUnitKt.getSp(11), FontWeight.Companion.getW400(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(12), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646137, (DefaultConstructorMarker) null), scale), $composer3, 384, 24576, 114682);
                } else {
                    $composer3.startReplaceGroup(-2029407684);
                }
                $composer3.endReplaceGroup();
            }
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
            final Modifier modifier5 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.CouponPopupComponentKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit CouponItemComponent$lambda$1;
                    CouponItemComponent$lambda$1 = CouponPopupComponentKt.CouponItemComponent$lambda$1(scale, couponInfoModel, modifier5, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return CouponItemComponent$lambda$1;
                }
            });
        }
    }
}