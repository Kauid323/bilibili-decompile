package kntr.app.mall.product.details.page.ui.components;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.TextMeasurer;
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
import com.bilibili.compose.iconfont.BiliIconfont;
import com.bilibili.compose.theme.BiliTheme;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kntr.app.mall.product.details.page.api.model.CountDownInfoVO;
import kntr.app.mall.product.details.page.api.model.ImageColorModel;
import kntr.app.mall.product.details.page.api.model.MergeAtmospherePriceFloor;
import kntr.app.mall.product.details.page.api.model.PriceDescVO;
import kntr.app.mall.product.details.page.api.model.TextColorModel;
import kntr.app.mall.product.details.page.ui.container.TopContainerKt;
import kntr.app.mall.product.details.page.ui.scale.ProvideUiScaleKt;
import kntr.app.mall.product.details.page.ui.scale.UiScaleModel;
import kntr.app.mall.product.details.page.utils.DateFormatKt;
import kntr.app.mall.product.details.page.utils.ThemesKt;
import kntr.app.mall.product.details.page.vm.ContentModule;
import kntr.app.mall.product.details.page.vm.PageViewModel;
import kntr.app.mall.product.details.page.vm.PageViewModelWrapper;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MergeAtmospherePriceFloorComponent.kt */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0001¢\u0006\u0002\u0010\b\u001a;\u0010\t\u001a\u00020\u00012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0003¢\u0006\u0002\u0010\u0011\u001a3\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0003¢\u0006\u0002\u0010\u0014\u001aa\u0010\u0015\u001a\u00020\u00012\b\u0010\u0013\u001a\u0004\u0018\u00010\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00010\u00182\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001a2\b\b\u0002\u0010\u001c\u001a\u00020\u001a2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0003¢\u0006\u0002\u0010\u001d\u001a=\u0010\u001e\u001a\u00020\u00012\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0003¢\u0006\u0004\b#\u0010$\u001a'\u0010%\u001a\u00020\u00102\b\u0010&\u001a\u0004\u0018\u00010'2\u000e\b\u0002\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00010\u0018H\u0007¢\u0006\u0002\u0010)\u001a9\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u00102\u001a\u00020\u001aH\u0002¢\u0006\u0002\u00103\u001aO\u00104\u001a\u0002052\u000e\u00106\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u000b2\u000e\u00107\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\u0006\u00108\u001a\u00020+2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u000201H\u0002¢\u0006\u0004\b9\u0010:\u001a(\u0010;\u001a\u00020<2\u0006\u0010\u0013\u001a\u00020\u00162\u0006\u0010.\u001a\u00020/2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u00100\u001a\u000201H\u0002¨\u0006=²\u0006\n\u0010>\u001a\u00020?X\u008a\u0084\u0002²\u0006\n\u0010@\u001a\u00020\u0010X\u008a\u008e\u0002²\u0006\u0010\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00010\u0018X\u008a\u0084\u0002"}, d2 = {"MergeAtmospherePriceFloorComponent", "", "module", "Lkntr/app/mall/product/details/page/vm/ContentModule;", "pageViewModelWrapper", "Lkntr/app/mall/product/details/page/vm/PageViewModelWrapper;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lkntr/app/mall/product/details/page/vm/ContentModule;Lkntr/app/mall/product/details/page/vm/PageViewModelWrapper;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "BottomBenefitComponent", "items", "", "Lkntr/app/mall/product/details/page/api/model/TextColorModel;", "scale", "", "fontColor", "", "(Ljava/util/List;FLandroidx/compose/ui/Modifier;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)V", "TextColorComponent", "item", "(Lkntr/app/mall/product/details/page/api/model/TextColorModel;FLandroidx/compose/ui/Modifier;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)V", "PriceDescVOComponent", "Lkntr/app/mall/product/details/page/api/model/PriceDescVO;", "onItem", "Lkotlin/Function0;", "isMain", "", "besideMain", "showFrontSeparator", "(Lkntr/app/mall/product/details/page/api/model/PriceDescVO;Lkotlin/jvm/functions/Function0;FLandroidx/compose/ui/Modifier;ZZZLjava/lang/String;Landroidx/compose/runtime/Composer;II)V", "CountDownComponent", "countDownInfo", "Lkntr/app/mall/product/details/page/api/model/CountDownInfoVO;", "styleColor", "Landroidx/compose/ui/graphics/Color;", "CountDownComponent-PYNUQm4", "(Lkntr/app/mall/product/details/page/api/model/CountDownInfoVO;Landroidx/compose/ui/graphics/Color;Lkntr/app/mall/product/details/page/vm/PageViewModelWrapper;FLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "rememberCountdown", "leftTimeSeconds", "", "onCountdownEnd", "(Ljava/lang/Long;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)Ljava/lang/String;", "calculateRightVOWidth", "Landroidx/compose/ui/unit/Dp;", "rightVO", "Lkntr/app/mall/product/details/page/api/model/MergeAtmospherePriceFloor$MergePriceInfo$RightVO;", "textMeasurer", "Landroidx/compose/ui/text/TextMeasurer;", "density", "Landroidx/compose/ui/unit/Density;", "hasFrontImage", "(Lkntr/app/mall/product/details/page/api/model/MergeAtmospherePriceFloor$MergePriceInfo$RightVO;Landroidx/compose/ui/text/TextMeasurer;Landroidx/compose/ui/unit/Density;FZ)F", "calculateFittingItems", "Lkntr/app/mall/product/details/page/ui/components/FittingItemsResult;", "priceDescVOs", "benefitInfos", "availableWidth", "calculateFittingItems-6a0pyJM", "(Ljava/util/List;Ljava/util/List;FFLandroidx/compose/ui/text/TextMeasurer;Landroidx/compose/ui/unit/Density;)Lkntr/app/mall/product/details/page/ui/components/FittingItemsResult;", "calculatePriceDescVOWidth", "", "product-details-page_debug", "scaleModel", "Lkntr/app/mall/product/details/page/ui/scale/UiScaleModel;", "countDownText", "currentOnCountdownEnd"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class MergeAtmospherePriceFloorComponentKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BottomBenefitComponent$lambda$0(List list, float f, Modifier modifier, String str, int i, int i2, Composer composer, int i3) {
        BottomBenefitComponent(list, f, modifier, str, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BottomBenefitComponent$lambda$2(List list, float f, Modifier modifier, String str, int i, int i2, Composer composer, int i3) {
        BottomBenefitComponent(list, f, modifier, str, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CountDownComponent_PYNUQm4$lambda$1(CountDownInfoVO countDownInfoVO, Color color, PageViewModelWrapper pageViewModelWrapper, float f, Modifier modifier, int i, int i2, Composer composer, int i3) {
        m503CountDownComponentPYNUQm4(countDownInfoVO, color, pageViewModelWrapper, f, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CountDownComponent_PYNUQm4$lambda$3(CountDownInfoVO countDownInfoVO, Color color, PageViewModelWrapper pageViewModelWrapper, float f, Modifier modifier, int i, int i2, Composer composer, int i3) {
        m503CountDownComponentPYNUQm4(countDownInfoVO, color, pageViewModelWrapper, f, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MergeAtmospherePriceFloorComponent$lambda$0(ContentModule contentModule, PageViewModelWrapper pageViewModelWrapper, Modifier modifier, int i, int i2, Composer composer, int i3) {
        MergeAtmospherePriceFloorComponent(contentModule, pageViewModelWrapper, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MergeAtmospherePriceFloorComponent$lambda$1(ContentModule contentModule, PageViewModelWrapper pageViewModelWrapper, Modifier modifier, int i, int i2, Composer composer, int i3) {
        MergeAtmospherePriceFloorComponent(contentModule, pageViewModelWrapper, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MergeAtmospherePriceFloorComponent$lambda$5(ContentModule contentModule, PageViewModelWrapper pageViewModelWrapper, Modifier modifier, int i, int i2, Composer composer, int i3) {
        MergeAtmospherePriceFloorComponent(contentModule, pageViewModelWrapper, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PriceDescVOComponent$lambda$0(PriceDescVO priceDescVO, Function0 function0, float f, Modifier modifier, boolean z, boolean z2, boolean z3, String str, int i, int i2, Composer composer, int i3) {
        PriceDescVOComponent(priceDescVO, function0, f, modifier, z, z2, z3, str, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PriceDescVOComponent$lambda$3(PriceDescVO priceDescVO, Function0 function0, float f, Modifier modifier, boolean z, boolean z2, boolean z3, String str, int i, int i2, Composer composer, int i3) {
        PriceDescVOComponent(priceDescVO, function0, f, modifier, z, z2, z3, str, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TextColorComponent$lambda$0(TextColorModel textColorModel, float f, Modifier modifier, String str, int i, int i2, Composer composer, int i3) {
        TextColorComponent(textColorModel, f, modifier, str, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TextColorComponent$lambda$1(TextColorModel textColorModel, float f, Modifier modifier, String str, int i, int i2, Composer composer, int i3) {
        TextColorComponent(textColorModel, f, modifier, str, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: SSATransform
        java.lang.IndexOutOfBoundsException: bitIndex < 0: -120
        	at java.util.BitSet.get(BitSet.java:623)
        	at jadx.core.dex.visitors.ssa.LiveVarAnalysis.fillBasicBlockInfo(LiveVarAnalysis.java:65)
        	at jadx.core.dex.visitors.ssa.LiveVarAnalysis.runAnalysis(LiveVarAnalysis.java:36)
        	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:55)
        	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:41)
        */
    public static final void MergeAtmospherePriceFloorComponent(kntr.app.mall.product.details.page.vm.ContentModule r270, kntr.app.mall.product.details.page.vm.PageViewModelWrapper r271, androidx.compose.ui.Modifier r272, androidx.compose.runtime.Composer r273, int r274, int r275) {
        /*
            Method dump skipped, instructions count: 10075
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kntr.app.mall.product.details.page.ui.components.MergeAtmospherePriceFloorComponentKt.MergeAtmospherePriceFloorComponent(kntr.app.mall.product.details.page.vm.ContentModule, kntr.app.mall.product.details.page.vm.PageViewModelWrapper, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final UiScaleModel MergeAtmospherePriceFloorComponent$lambda$2(State<UiScaleModel> state) {
        Object thisObj$iv = state.getValue();
        return (UiScaleModel) thisObj$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MergeAtmospherePriceFloorComponent$lambda$4$0$0(PageViewModel $pageViewModel) {
        $pageViewModel.updateActivityCouponSheetState$product_details_page_debug(true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MergeAtmospherePriceFloorComponent$lambda$4$1$4$0$0$0$0$0$0$0(PageViewModel $pageViewModel) {
        $pageViewModel.updateActivityCouponSheetState$product_details_page_debug(true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MergeAtmospherePriceFloorComponent$lambda$4$1$4$0$0$0$0$1$0$0(PageViewModel $pageViewModel) {
        $pageViewModel.updateActivityCouponSheetState$product_details_page_debug(true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MergeAtmospherePriceFloorComponent$lambda$4$1$4$0$0$1$0$1$1$0(PageViewModel $pageViewModel) {
        $pageViewModel.updateActivityCouponSheetState$product_details_page_debug(true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MergeAtmospherePriceFloorComponent$lambda$4$1$4$1$0$1$0$0$0(PageViewModel $pageViewModel) {
        $pageViewModel.reloadProductDetails$product_details_page_debug();
        return Unit.INSTANCE;
    }

    private static final void BottomBenefitComponent(final List<TextColorModel> list, final float scale, Modifier modifier, String fontColor, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        String str;
        Modifier modifier$iv$iv;
        String fontColor2;
        Modifier modifier3;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Composer $composer$iv$iv$iv;
        Composer $composer$iv;
        Composer $composer$iv$iv;
        String str2;
        Modifier modifier$iv$iv2;
        Modifier materialized$iv$iv;
        String str3;
        Function0 factory$iv$iv$iv3;
        Composer $composer2 = $composer.startRestartGroup(-268897883);
        ComposerKt.sourceInformation($composer2, "C(BottomBenefitComponent)N(items,scale,modifier,fontColor)516@25377L1308:MergeAtmospherePriceFloorComponent.kt#o90vz8");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(list) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(scale) ? 32 : 16;
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
            str = fontColor;
        } else if (($changed & 3072) == 0) {
            str = fontColor;
            $dirty |= $composer2.changed(str) ? 2048 : 1024;
        } else {
            str = fontColor;
        }
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute(($dirty2 & 1171) != 1170, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
            modifier$iv$iv = modifier2;
            fontColor2 = str;
        } else {
            if (i2 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (i3 == 0) {
                fontColor2 = str;
            } else {
                fontColor2 = null;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-268897883, $dirty2, -1, "kntr.app.mall.product.details.page.ui.components.BottomBenefitComponent (MergeAtmospherePriceFloorComponent.kt:512)");
            }
            List<TextColorModel> list2 = list;
            if (!(list2 == null || list2.isEmpty())) {
                Modifier modifier$iv = PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxWidth$default(modifier3, 0.0f, 1, (Object) null), ProvideUiScaleKt.dpScaled(16, scale), ProvideUiScaleKt.dpScaled(8, scale), ProvideUiScaleKt.dpScaled(16, scale), 0.0f, 8, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
                MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                int $changed$iv$iv = (0 << 3) & 112;
                String str4 = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
                Composer $composer$iv$iv2 = $composer2;
                ComposerKt.sourceInformationMarkerStart($composer$iv$iv2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv$iv2, 0));
                CompositionLocalMap localMap$iv$iv = $composer$iv$iv2.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer$iv$iv2, modifier$iv);
                Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                Modifier modifier$iv$iv3 = modifier$iv;
                String str5 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart($composer$iv$iv2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer$iv$iv2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer$iv$iv2.startReusableNode();
                if ($composer$iv$iv2.getInserting()) {
                    factory$iv$iv$iv = factory$iv$iv$iv4;
                    $composer$iv$iv2.createNode(factory$iv$iv$iv);
                } else {
                    factory$iv$iv$iv = factory$iv$iv$iv4;
                    $composer$iv$iv2.useNode();
                }
                Function0 factory$iv$iv$iv5 = factory$iv$iv$iv;
                Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer$iv$iv2);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
                int i4 = ($changed$iv$iv$iv >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer$iv$iv2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScope boxScope = BoxScopeInstance.INSTANCE;
                int i5 = ((0 >> 6) & 112) | 6;
                Modifier materialized$iv$iv3 = materialized$iv$iv2;
                ComposerKt.sourceInformationMarkerStart($composer$iv$iv2, -650479948, "C522@25575L1104:MergeAtmospherePriceFloorComponent.kt#o90vz8");
                Composer $composer$iv2 = $composer$iv$iv2;
                Modifier modifier$iv2 = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
                Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart($composer$iv$iv2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer$iv$iv2, ((390 >> 3) & 14) | ((390 >> 3) & 112));
                int $changed$iv$iv2 = (390 << 3) & 112;
                Composer $composer$iv$iv3 = $composer$iv$iv2;
                Arrangement.Horizontal horizontalArrangement$iv2 = horizontalArrangement$iv;
                ComposerKt.sourceInformationMarkerStart($composer$iv$iv2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv$iv2, 0));
                CompositionLocalMap localMap$iv$iv2 = $composer$iv$iv2.getCurrentCompositionLocalMap();
                Modifier modifier$iv$iv4 = modifier$iv2;
                modifier$iv$iv = modifier3;
                Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer$iv$iv2, modifier$iv$iv4);
                Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                Composer $composer$iv$iv4 = $composer$iv$iv2;
                Composer $composer$iv$iv$iv2 = $composer$iv$iv4;
                ComposerKt.sourceInformationMarkerStart($composer$iv$iv$iv2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer$iv$iv$iv2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer$iv$iv$iv2.startReusableNode();
                if ($composer$iv$iv$iv2.getInserting()) {
                    factory$iv$iv$iv2 = factory$iv$iv$iv6;
                    $composer$iv$iv$iv2.createNode(factory$iv$iv$iv2);
                } else {
                    factory$iv$iv$iv2 = factory$iv$iv$iv6;
                    $composer$iv$iv$iv2.useNode();
                }
                Function0 factory$iv$iv$iv7 = factory$iv$iv$iv2;
                Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer$iv$iv$iv2);
                Alignment.Vertical verticalAlignment$iv2 = verticalAlignment$iv;
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                MeasurePolicy measurePolicy$iv$iv = measurePolicy$iv2;
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv4, ComposeUiNode.Companion.getSetModifier());
                int i6 = ($changed$iv$iv$iv2 >> 6) & 14;
                Composer $composer$iv3 = $composer$iv$iv$iv2;
                ComposerKt.sourceInformationMarkerStart($composer$iv3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScope rowScope = RowScopeInstance.INSTANCE;
                int i7 = ((390 >> 6) & 112) | 6;
                Composer $composer3 = $composer$iv3;
                CompositionLocalMap localMap$iv$iv3 = localMap$iv$iv2;
                ComposerKt.sourceInformationMarkerStart($composer3, -1754465333, "C:MergeAtmospherePriceFloorComponent.kt#o90vz8");
                $composer3.startReplaceGroup(-56595470);
                ComposerKt.sourceInformation($composer3, "*544@26506L149");
                List<TextColorModel> $this$forEachIndexed$iv = list;
                int index$iv = 0;
                for (Object item$iv : $this$forEachIndexed$iv) {
                    int index$iv2 = index$iv + 1;
                    if (index$iv < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    TextColorModel model = (TextColorModel) item$iv;
                    int index = index$iv;
                    if (index > 0) {
                        $composer3.startReplaceGroup(-1445849528);
                        ComposerKt.sourceInformation($composer3, "528@25804L667");
                        $composer$iv$iv$iv = $composer$iv$iv$iv2;
                        Modifier modifier$iv3 = SizeKt.width-3ABfNKs(SizeKt.height-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(12, scale)), ProvideUiScaleKt.dpScaled(12, scale));
                        Alignment contentAlignment$iv2 = Alignment.Companion.getCenter();
                        Composer $composer$iv4 = $composer3;
                        $composer$iv = $composer$iv3;
                        $composer$iv$iv = $composer$iv$iv2;
                        ComposerKt.sourceInformationMarkerStart($composer$iv4, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicy$iv3 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
                        int $changed$iv$iv3 = (48 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer$iv4, -1159599143, str4);
                        int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv4, 0));
                        CompositionLocalMap localMap$iv$iv4 = $composer$iv4.getCurrentCompositionLocalMap();
                        str2 = str4;
                        Modifier materialized$iv$iv5 = ComposedModifierKt.materializeModifier($composer$iv4, modifier$iv3);
                        Function0 factory$iv$iv$iv8 = ComposeUiNode.Companion.getConstructor();
                        int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
                        modifier$iv$iv2 = modifier$iv$iv4;
                        ComposerKt.sourceInformationMarkerStart($composer$iv4, -553112988, str5);
                        if (!($composer$iv4.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer$iv4.startReusableNode();
                        if ($composer$iv4.getInserting()) {
                            factory$iv$iv$iv3 = factory$iv$iv$iv8;
                            $composer$iv4.createNode(factory$iv$iv$iv3);
                        } else {
                            factory$iv$iv$iv3 = factory$iv$iv$iv8;
                            $composer$iv4.useNode();
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer$iv4);
                        materialized$iv$iv = materialized$iv$iv4;
                        str3 = str5;
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv5, ComposeUiNode.Companion.getSetModifier());
                        int i8 = ($changed$iv$iv$iv3 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer$iv4, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                        BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
                        int i9 = ((48 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer$iv4, 552875194, "C540@26381L6,535@26110L339:MergeAtmospherePriceFloorComponent.kt#o90vz8");
                        BoxKt.Box(BackgroundKt.background-bw27NRU$default(SizeKt.height-3ABfNKs(SizeKt.width-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(0.5d, scale)), ProvideUiScaleKt.dpScaled(12, scale)), TopContainerKt.m587withOverlayAlphaDxMtmZc(BiliTheme.INSTANCE.getColors($composer$iv4, BiliTheme.$stable).getBrand_pink-0d7_KjU(), 0.5f), (Shape) null, 2, (Object) null), $composer$iv4, 0);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv4);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv4);
                        $composer$iv4.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer$iv4);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv4);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv4);
                    } else {
                        $composer$iv$iv$iv = $composer$iv$iv$iv2;
                        $composer$iv = $composer$iv3;
                        $composer$iv$iv = $composer$iv$iv2;
                        str2 = str4;
                        modifier$iv$iv2 = modifier$iv$iv4;
                        materialized$iv$iv = materialized$iv$iv4;
                        str3 = str5;
                        $composer3.startReplaceGroup(-1471448181);
                    }
                    $composer3.endReplaceGroup();
                    Arrangement.Horizontal horizontalArrangement$iv3 = horizontalArrangement$iv2;
                    Composer $composer$iv5 = $composer$iv$iv3;
                    Composer $composer$iv6 = $composer$iv$iv4;
                    Function0 factory$iv$iv$iv9 = factory$iv$iv$iv7;
                    Composer $composer4 = $composer3;
                    TextColorComponent(model, scale, null, fontColor2, $composer4, ($dirty2 & 112) | ($dirty2 & 7168), 4);
                    measurePolicy$iv$iv = measurePolicy$iv$iv;
                    $composer$iv$iv2 = $composer$iv$iv;
                    modifier$iv$iv4 = modifier$iv$iv2;
                    localMap$iv$iv3 = localMap$iv$iv3;
                    $composer3 = $composer4;
                    $composer$iv2 = $composer$iv2;
                    index$iv = index$iv2;
                    $composer$iv$iv$iv2 = $composer$iv$iv$iv;
                    verticalAlignment$iv2 = verticalAlignment$iv2;
                    $composer$iv3 = $composer$iv;
                    str4 = str2;
                    str5 = str3;
                    materialized$iv$iv4 = materialized$iv$iv;
                    materialized$iv$iv3 = materialized$iv$iv3;
                    factory$iv$iv$iv7 = factory$iv$iv$iv9;
                    $composer$iv$iv4 = $composer$iv6;
                    $composer$iv$iv3 = $composer$iv5;
                    horizontalArrangement$iv2 = horizontalArrangement$iv3;
                    modifier$iv$iv3 = modifier$iv$iv3;
                    factory$iv$iv$iv5 = factory$iv$iv$iv5;
                }
                Composer $composer$iv$iv$iv3 = $composer$iv$iv$iv2;
                Composer $composer$iv7 = $composer$iv$iv3;
                Composer $composer$iv8 = $composer$iv$iv4;
                Composer $composer5 = $composer3;
                $composer5.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd($composer5);
                ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                $composer$iv$iv$iv3.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv3);
                ComposerKt.sourceInformationMarkerEnd($composer$iv8);
                ComposerKt.sourceInformationMarkerEnd($composer$iv7);
                ComposerKt.sourceInformationMarkerEnd($composer$iv$iv2);
                ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                $composer$iv$iv2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer$iv$iv2);
                ComposerKt.sourceInformationMarkerEnd($composer$iv$iv2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
                if (endRestartGroup != null) {
                    final Modifier modifier4 = modifier3;
                    final String str6 = fontColor2;
                    endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.MergeAtmospherePriceFloorComponentKt$$ExternalSyntheticLambda16
                        public final Object invoke(Object obj, Object obj2) {
                            Unit BottomBenefitComponent$lambda$0;
                            BottomBenefitComponent$lambda$0 = MergeAtmospherePriceFloorComponentKt.BottomBenefitComponent$lambda$0(list, scale, modifier4, str6, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                            return BottomBenefitComponent$lambda$0;
                        }
                    });
                    return;
                }
                return;
            }
        }
        ScopeUpdateScope endRestartGroup2 = $composer2.endRestartGroup();
        if (endRestartGroup2 != null) {
            final Modifier modifier5 = modifier$iv$iv;
            final String str7 = fontColor2;
            endRestartGroup2.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.MergeAtmospherePriceFloorComponentKt$$ExternalSyntheticLambda17
                public final Object invoke(Object obj, Object obj2) {
                    Unit BottomBenefitComponent$lambda$2;
                    BottomBenefitComponent$lambda$2 = MergeAtmospherePriceFloorComponentKt.BottomBenefitComponent$lambda$2(list, scale, modifier5, str7, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return BottomBenefitComponent$lambda$2;
                }
            });
        }
    }

    private static final void TextColorComponent(final TextColorModel item, final float scale, Modifier modifier, String fontColor, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        String str;
        Composer $composer2;
        Modifier modifier3;
        String fontColor2;
        long j;
        long j2;
        long textColor;
        Composer $composer3 = $composer.startRestartGroup(2014128710);
        ComposerKt.sourceInformation($composer3, "C(TextColorComponent)N(item,scale,modifier,fontColor)564@27059L21,583@27502L9,578@27371L165:MergeAtmospherePriceFloorComponent.kt#o90vz8");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(item) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changed(scale) ? 32 : 16;
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
        int i3 = i & 8;
        if (i3 != 0) {
            $dirty |= 3072;
            str = fontColor;
        } else if (($changed & 3072) == 0) {
            str = fontColor;
            $dirty |= $composer3.changed(str) ? 2048 : 1024;
        } else {
            str = fontColor;
        }
        int $dirty2 = $dirty;
        boolean z = true;
        if (!$composer3.shouldExecute(($dirty2 & 1171) != 1170, $dirty2 & 1)) {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            fontColor2 = str;
        } else {
            if (i2 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (i3 == 0) {
                fontColor2 = str;
            } else {
                fontColor2 = null;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2014128710, $dirty2, -1, "kntr.app.mall.product.details.page.ui.components.TextColorComponent (MergeAtmospherePriceFloorComponent.kt:560)");
            }
            String text = item.getText();
            String dayColor = item.getDayColor();
            Color color = dayColor != null ? Color.box-impl(ComposeColorParserKt.parseColor(dayColor)) : null;
            if (color == null) {
                $composer3.startReplaceGroup(-1452552816);
                ComposerKt.sourceInformation($composer3, "562@26932L6");
                j = BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getBrand_pink-0d7_KjU();
                $composer3.endReplaceGroup();
            } else {
                $composer3.startReplaceGroup(-1452554304);
                $composer3.endReplaceGroup();
                j = color.unbox-impl();
            }
            long dayColor2 = j;
            String nightColor = item.getNightColor();
            Color color2 = nightColor != null ? Color.box-impl(ComposeColorParserKt.parseColor(nightColor)) : null;
            if (color2 == null) {
                $composer3.startReplaceGroup(-1452550192);
                ComposerKt.sourceInformation($composer3, "563@27014L6");
                j2 = BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getBrand_pink-0d7_KjU();
                $composer3.endReplaceGroup();
            } else {
                $composer3.startReplaceGroup(-1452551742);
                $composer3.endReplaceGroup();
                j2 = color2.unbox-impl();
            }
            long nightColor2 = j2;
            long defaultColor = ThemesKt.isCurrentThemeLight($composer3, 0) ? dayColor2 : nightColor2;
            String str2 = fontColor2;
            if (!(str2 == null || str2.length() == 0)) {
                textColor = ComposeColorParserKt.parseColor(fontColor2);
            } else {
                textColor = defaultColor;
            }
            String str3 = text;
            if (str3 != null && str3.length() != 0) {
                z = false;
            }
            if (!z) {
                $composer2 = $composer3;
                TextKt.Text-Nvy7gAk(text, modifier3, textColor, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, ProvideUiScaleKt.scaled(BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT12(), scale), $composer2, ($dirty2 >> 3) & 112, 24576, 114680);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup = $composer3.endRestartGroup();
                if (endRestartGroup != null) {
                    final Modifier modifier4 = modifier3;
                    final String str4 = fontColor2;
                    endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.MergeAtmospherePriceFloorComponentKt$$ExternalSyntheticLambda11
                        public final Object invoke(Object obj, Object obj2) {
                            Unit TextColorComponent$lambda$0;
                            TextColorComponent$lambda$0 = MergeAtmospherePriceFloorComponentKt.TextColorComponent$lambda$0(TextColorModel.this, scale, modifier4, str4, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                            return TextColorComponent$lambda$0;
                        }
                    });
                    return;
                }
                return;
            }
        }
        ScopeUpdateScope endRestartGroup2 = $composer2.endRestartGroup();
        if (endRestartGroup2 != null) {
            final Modifier modifier5 = modifier3;
            final String str5 = fontColor2;
            endRestartGroup2.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.MergeAtmospherePriceFloorComponentKt$$ExternalSyntheticLambda12
                public final Object invoke(Object obj, Object obj2) {
                    Unit TextColorComponent$lambda$1;
                    TextColorComponent$lambda$1 = MergeAtmospherePriceFloorComponentKt.TextColorComponent$lambda$1(TextColorModel.this, scale, modifier5, str5, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return TextColorComponent$lambda$1;
                }
            });
        }
    }

    private static final void PriceDescVOComponent(final PriceDescVO item, final Function0<Unit> function0, final float scale, Modifier modifier, boolean isMain, boolean besideMain, boolean showFrontSeparator, String fontColor, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        boolean z;
        Composer $composer2;
        boolean besideMain2;
        boolean showFrontSeparator2;
        String fontColor2;
        Modifier modifier3;
        boolean isMain2;
        long dayColor;
        long nightColor;
        long styleColor;
        Function0 factory$iv$iv$iv;
        Alignment.Vertical verticalAlignment$iv;
        Function0 factory$iv$iv$iv2;
        Composer $composer$iv;
        TextStyle scaled;
        TextStyle scaled2;
        TextStyle scaled3;
        Function0 factory$iv$iv$iv3;
        TextStyle scaled4;
        TextStyle scaled5;
        String nightColor2;
        String dayColor2;
        Composer $composer3 = $composer.startRestartGroup(531982833);
        ComposerKt.sourceInformation($composer3, "C(PriceDescVOComponent)N(item,onItem,scale,modifier,isMain,besideMain,showFrontSeparator,fontColor)602@28085L21,617@28505L56,612@28349L6496:MergeAtmospherePriceFloorComponent.kt#o90vz8");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(item) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changedInstance(function0) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer3.changed(scale) ? 256 : 128;
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
        int i3 = i & 16;
        if (i3 != 0) {
            $dirty |= 24576;
            z = isMain;
        } else if (($changed & 24576) == 0) {
            z = isMain;
            $dirty |= $composer3.changed(z) ? 16384 : 8192;
        } else {
            z = isMain;
        }
        int i4 = i & 32;
        if (i4 != 0) {
            $dirty |= 196608;
        } else if (($changed & 196608) == 0) {
            $dirty |= $composer3.changed(besideMain) ? 131072 : 65536;
        }
        int i5 = i & 64;
        if (i5 != 0) {
            $dirty |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty |= $composer3.changed(showFrontSeparator) ? 1048576 : 524288;
        }
        int i6 = i & 128;
        if (i6 != 0) {
            $dirty |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty |= $composer3.changed(fontColor) ? 8388608 : 4194304;
        }
        if ($composer3.shouldExecute(($dirty & 4793491) != 4793490, $dirty & 1)) {
            if (i2 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (i3 == 0) {
                isMain2 = z;
            } else {
                isMain2 = false;
            }
            if (i4 == 0) {
                besideMain2 = besideMain;
            } else {
                besideMain2 = false;
            }
            if (i5 == 0) {
                showFrontSeparator2 = showFrontSeparator;
            } else {
                showFrontSeparator2 = false;
            }
            if (i6 == 0) {
                fontColor2 = fontColor;
            } else {
                fontColor2 = null;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(531982833, $dirty, -1, "kntr.app.mall.product.details.page.ui.components.PriceDescVOComponent (MergeAtmospherePriceFloorComponent.kt:597)");
            }
            if (item != null) {
                int $dirty2 = $dirty;
                PriceDescVO.StyleVO styleVO = item.getStyleVO();
                Color color = (styleVO == null || (dayColor2 = styleVO.getDayColor()) == null) ? null : Color.box-impl(ComposeColorParserKt.parseColor(dayColor2));
                if (color == null) {
                    $composer3.startReplaceGroup(134406971);
                    ComposerKt.sourceInformation($composer3, "600@27949L6");
                    dayColor = BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getBrand_pink-0d7_KjU();
                    $composer3.endReplaceGroup();
                } else {
                    $composer3.startReplaceGroup(134405359);
                    $composer3.endReplaceGroup();
                    dayColor = color.unbox-impl();
                }
                Color color2 = (styleVO == null || (nightColor2 = styleVO.getNightColor()) == null) ? null : Color.box-impl(ComposeColorParserKt.parseColor(nightColor2));
                if (color2 == null) {
                    $composer3.startReplaceGroup(134409723);
                    ComposerKt.sourceInformation($composer3, "601@28035L6");
                    nightColor = BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getBrand_pink-0d7_KjU();
                    $composer3.endReplaceGroup();
                } else {
                    $composer3.startReplaceGroup(134408049);
                    $composer3.endReplaceGroup();
                    nightColor = color2.unbox-impl();
                }
                long defaultStyleColor = ThemesKt.isCurrentThemeLight($composer3, 0) ? dayColor : nightColor;
                String str = fontColor2;
                if (!(str == null || str.length() == 0)) {
                    styleColor = ComposeColorParserKt.parseColor(fontColor2);
                } else {
                    styleColor = defaultStyleColor;
                }
                boolean areEqual = Intrinsics.areEqual(item.getCanClick(), true);
                ComposerKt.sourceInformationMarkerStart($composer3, 134424585, "CC(remember):MergeAtmospherePriceFloorComponent.kt#9igjgp");
                boolean invalid$iv = ($dirty2 & 112) == 32;
                Object it$iv = $composer3.rememberedValue();
                if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function0() { // from class: kntr.app.mall.product.details.page.ui.components.MergeAtmospherePriceFloorComponentKt$$ExternalSyntheticLambda14
                        public final Object invoke() {
                            Unit PriceDescVOComponent$lambda$1$0;
                            PriceDescVOComponent$lambda$1$0 = MergeAtmospherePriceFloorComponentKt.PriceDescVOComponent$lambda$1$0(function0);
                            return PriceDescVOComponent$lambda$1$0;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                ComposerKt.sourceInformationMarkerEnd($composer3);
                Modifier modifier$iv = ClickableKt.clickable-oSLSa3U$default(modifier3, areEqual, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 14, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
                MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
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
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
                int i7 = ($changed$iv$iv$iv >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                int i8 = ((0 >> 6) & 112) | 6;
                BoxScope $this$PriceDescVOComponent_u24lambda_u242 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer3, -1992316373, "C622@28598L5747:MergeAtmospherePriceFloorComponent.kt#o90vz8");
                if (isMain2 || besideMain2) {
                    verticalAlignment$iv = Alignment.Companion.getBottom();
                } else {
                    verticalAlignment$iv = Alignment.Companion.getTop();
                }
                ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                Modifier modifier$iv2 = Modifier.Companion;
                Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                int $changed$iv$iv2 = (0 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
                CompositionLocalMap localMap$iv$iv2 = $composer3.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer3, modifier$iv2);
                Function0 factory$iv$iv$iv5 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                $composer2 = $composer3;
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
                int i9 = ($changed$iv$iv$iv2 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                int i10 = ((0 >> 6) & 112) | 6;
                RowScope $this$PriceDescVOComponent_u24lambda_u242_u240 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer3, -393932261, "C691@31454L792,711@32259L839,731@33111L787:MergeAtmospherePriceFloorComponent.kt#o90vz8");
                if (!showFrontSeparator2) {
                    $composer$iv = $composer3;
                    $composer3.startReplaceGroup(-422691737);
                } else {
                    $composer3.startReplaceGroup(-394066678);
                    ComposerKt.sourceInformation($composer3, "631@28860L381");
                    $composer$iv = $composer3;
                    BoxKt.Box(BackgroundKt.background-bw27NRU$default(SizeKt.width-3ABfNKs(SizeKt.height-3ABfNKs(PaddingKt.padding-VpY3zN4$default($this$PriceDescVOComponent_u24lambda_u242_u240.align(Modifier.Companion, Alignment.Companion.getCenterVertically()), ProvideUiScaleKt.dpScaled(2, scale), 0.0f, 2, (Object) null), ProvideUiScaleKt.dpScaled(2, scale)), ProvideUiScaleKt.dpScaled(10, scale)), styleColor, (Shape) null, 2, (Object) null), $composer3, 0);
                }
                $composer3.endReplaceGroup();
                String pricePrefix = item.getPricePrefix();
                if (!(pricePrefix == null || pricePrefix.length() == 0)) {
                    $composer3.startReplaceGroup(-393569066);
                    ComposerKt.sourceInformation($composer3, "642@29325L1009");
                    String pricePrefix2 = item.getPricePrefix();
                    if (isMain2) {
                        scaled5 = ProvideUiScaleKt.scaled(new TextStyle(0L, TextUnitKt.getSp(12), FontWeight.Companion.getSemiBold(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(26), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646137, (DefaultConstructorMarker) null), scale);
                    } else {
                        scaled5 = ProvideUiScaleKt.scaled(new TextStyle(0L, TextUnitKt.getSp(12), FontWeight.Companion.getNormal(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(besideMain2 ? 26 : 16), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646137, (DefaultConstructorMarker) null), scale);
                    }
                    Modifier.Companion companion = Modifier.Companion;
                    Modifier modifier4 = Modifier.Companion;
                    TextKt.Text-Nvy7gAk(pricePrefix2, $this$PriceDescVOComponent_u24lambda_u242_u240.alignByBaseline(companion.then(isMain2 ? PaddingKt.padding-qDBjuR0$default(modifier4, 0.0f, 0.0f, ProvideUiScaleKt.dpScaled(2, scale), 0.0f, 11, (Object) null) : modifier4)), styleColor, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, scaled5, $composer3, 0, 24576, 114680);
                } else {
                    $composer3.startReplaceGroup(-422691737);
                }
                $composer3.endReplaceGroup();
                String priceSymbol = item.getPriceSymbol();
                if (!(priceSymbol == null || priceSymbol.length() == 0)) {
                    $composer3.startReplaceGroup(-392484810);
                    ComposerKt.sourceInformation($composer3, "667@30418L1009");
                    String priceSymbol2 = item.getPriceSymbol();
                    if (isMain2) {
                        scaled4 = ProvideUiScaleKt.scaled(new TextStyle(0L, TextUnitKt.getSp(12), FontWeight.Companion.getSemiBold(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(26), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646137, (DefaultConstructorMarker) null), scale);
                    } else {
                        scaled4 = ProvideUiScaleKt.scaled(new TextStyle(0L, TextUnitKt.getSp(12), FontWeight.Companion.getNormal(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(besideMain2 ? 26 : 16), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646137, (DefaultConstructorMarker) null), scale);
                    }
                    Modifier.Companion companion2 = Modifier.Companion;
                    Modifier modifier5 = Modifier.Companion;
                    TextKt.Text-Nvy7gAk(priceSymbol2, $this$PriceDescVOComponent_u24lambda_u242_u240.alignByBaseline(companion2.then(isMain2 ? PaddingKt.padding-qDBjuR0$default(modifier5, 0.0f, 0.0f, ProvideUiScaleKt.dpScaled(2, scale), 0.0f, 11, (Object) null) : modifier5)), styleColor, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, scaled4, $composer3, 0, 24576, 114680);
                } else {
                    $composer3.startReplaceGroup(-422691737);
                }
                $composer3.endReplaceGroup();
                String priceIntegerPart = item.getPriceIntegerPart();
                String str2 = priceIntegerPart == null ? "" : priceIntegerPart;
                if (isMain2) {
                    scaled = ProvideUiScaleKt.scaled(new TextStyle(0L, TextUnitKt.getSp(22), FontWeight.Companion.getSemiBold(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(32), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646137, (DefaultConstructorMarker) null), scale);
                } else {
                    scaled = ProvideUiScaleKt.scaled(new TextStyle(0L, TextUnitKt.getSp(12), FontWeight.Companion.getNormal(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(besideMain2 ? 26 : 16), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646137, (DefaultConstructorMarker) null), scale);
                }
                TextKt.Text-Nvy7gAk(str2, $this$PriceDescVOComponent_u24lambda_u242_u240.alignByBaseline(Modifier.Companion), styleColor, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, scaled, $composer3, 0, 24576, 114680);
                String priceDecimalPart = item.getPriceDecimalPart();
                String str3 = priceDecimalPart == null || priceDecimalPart.length() == 0 ? "" : "." + item.getPriceDecimalPart();
                if (isMain2) {
                    scaled2 = ProvideUiScaleKt.scaled(new TextStyle(0L, TextUnitKt.getSp(12), FontWeight.Companion.getSemiBold(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(26), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646137, (DefaultConstructorMarker) null), scale);
                } else {
                    scaled2 = ProvideUiScaleKt.scaled(new TextStyle(0L, TextUnitKt.getSp(12), FontWeight.Companion.getNormal(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(besideMain2 ? 26 : 16), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646137, (DefaultConstructorMarker) null), scale);
                }
                TextKt.Text-Nvy7gAk(str3, $this$PriceDescVOComponent_u24lambda_u242_u240.alignByBaseline(Modifier.Companion), styleColor, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, scaled2, $composer3, 0, 24576, 114680);
                String priceSuffix = item.getPriceSuffix();
                String str4 = priceSuffix == null ? "" : priceSuffix;
                if (isMain2) {
                    scaled3 = ProvideUiScaleKt.scaled(new TextStyle(0L, TextUnitKt.getSp(12), FontWeight.Companion.getSemiBold(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(26), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646137, (DefaultConstructorMarker) null), scale);
                } else {
                    scaled3 = ProvideUiScaleKt.scaled(new TextStyle(0L, TextUnitKt.getSp(12), FontWeight.Companion.getNormal(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(besideMain2 ? 26 : 16), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646137, (DefaultConstructorMarker) null), scale);
                }
                TextKt.Text-Nvy7gAk(str4, $this$PriceDescVOComponent_u24lambda_u242_u240.alignByBaseline(Modifier.Companion), styleColor, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, scaled3, $composer3, 0, 24576, 114680);
                if (Intrinsics.areEqual(item.getCanClick(), true)) {
                    $composer3.startReplaceGroup(-388994117);
                    ComposerKt.sourceInformation($composer3, "754@34006L28,753@33957L364");
                    IconKt.Icon-ww6aTOc(BiliIconfont.INSTANCE.getArrow_forward_right_line_500($composer3, 6), (String) null, SizeKt.size-3ABfNKs($this$PriceDescVOComponent_u24lambda_u242_u240.align(Modifier.Companion, Alignment.Companion.getCenterVertically()), ProvideUiScaleKt.dpScaled(12, scale)), styleColor, $composer3, Painter.$stable | 48, 0);
                } else {
                    $composer3.startReplaceGroup(-422691737);
                }
                $composer3.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                if (!Intrinsics.areEqual(item.getStrikePrice(), true) || isMain2) {
                    $composer3.startReplaceGroup(-2020880053);
                } else {
                    $composer3.startReplaceGroup(-1986744496);
                    ComposerKt.sourceInformation($composer3, "766@34410L419");
                    Modifier modifier$iv3 = $this$PriceDescVOComponent_u24lambda_u242.matchParentSize(Modifier.Companion);
                    ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    Alignment contentAlignment$iv2 = Alignment.Companion.getTopStart();
                    MeasurePolicy measurePolicy$iv3 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
                    int $changed$iv$iv3 = (0 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
                    CompositionLocalMap localMap$iv$iv3 = $composer3.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer3, modifier$iv3);
                    Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
                    int $i$f$Box = $changed$iv$iv3 << 6;
                    int $changed$iv$iv$iv3 = ($i$f$Box & 896) | 6;
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
                    int i11 = ($changed$iv$iv$iv3 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    int i12 = ((0 >> 6) & 112) | 6;
                    BoxScope $this$PriceDescVOComponent_u24lambda_u242_u241 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart($composer3, 1058894758, "C770@34522L293:MergeAtmospherePriceFloorComponent.kt#o90vz8");
                    BoxKt.Box(BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxWidth$default(SizeKt.height-3ABfNKs($this$PriceDescVOComponent_u24lambda_u242_u241.align(Modifier.Companion, Alignment.Companion.getCenter()), ProvideUiScaleKt.dpScaled(0.5d, scale)), 0.0f, 1, (Object) null), styleColor, (Shape) null, 2, (Object) null), $composer3, 0);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    $composer3.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                }
                $composer3.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                $composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup = $composer3.endRestartGroup();
                if (endRestartGroup != null) {
                    final Modifier modifier6 = modifier3;
                    final boolean z2 = isMain2;
                    final boolean z3 = besideMain2;
                    final boolean z4 = showFrontSeparator2;
                    final String str5 = fontColor2;
                    endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.MergeAtmospherePriceFloorComponentKt$$ExternalSyntheticLambda13
                        public final Object invoke(Object obj, Object obj2) {
                            Unit PriceDescVOComponent$lambda$0;
                            PriceDescVOComponent$lambda$0 = MergeAtmospherePriceFloorComponentKt.PriceDescVOComponent$lambda$0(PriceDescVO.this, function0, scale, modifier6, z2, z3, z4, str5, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                            return PriceDescVOComponent$lambda$0;
                        }
                    });
                    return;
                }
                return;
            }
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            besideMain2 = besideMain;
            showFrontSeparator2 = showFrontSeparator;
            fontColor2 = fontColor;
            modifier3 = modifier2;
            isMain2 = z;
        }
        ScopeUpdateScope endRestartGroup2 = $composer2.endRestartGroup();
        if (endRestartGroup2 != null) {
            final Modifier modifier7 = modifier3;
            final boolean z5 = isMain2;
            final boolean z6 = besideMain2;
            final boolean z7 = showFrontSeparator2;
            final String str6 = fontColor2;
            endRestartGroup2.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.MergeAtmospherePriceFloorComponentKt$$ExternalSyntheticLambda15
                public final Object invoke(Object obj, Object obj2) {
                    Unit PriceDescVOComponent$lambda$3;
                    PriceDescVOComponent$lambda$3 = MergeAtmospherePriceFloorComponentKt.PriceDescVOComponent$lambda$3(PriceDescVO.this, function0, scale, modifier7, z5, z6, z7, str6, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return PriceDescVOComponent$lambda$3;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PriceDescVOComponent$lambda$1$0(Function0 $onItem) {
        $onItem.invoke();
        return Unit.INSTANCE;
    }

    /* renamed from: CountDownComponent-PYNUQm4  reason: not valid java name */
    private static final void m503CountDownComponentPYNUQm4(final CountDownInfoVO countDownInfo, final Color styleColor, final PageViewModelWrapper pageViewModelWrapper, final float scale, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Modifier modifier3;
        PageViewModel pageViewModel;
        Long leftTime;
        Function0 factory$iv$iv$iv;
        Composer $composer2 = $composer.startRestartGroup(1646452076);
        ComposerKt.sourceInformation($composer2, "C(CountDownComponent)N(countDownInfo,styleColor:c#ui.graphics.Color,pageViewModelWrapper,scale,modifier)796@35277L68,794@35189L167,805@35456L1750:MergeAtmospherePriceFloorComponent.kt#o90vz8");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(countDownInfo) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(styleColor) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changedInstance(pageViewModelWrapper) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer2.changed(scale) ? 2048 : 1024;
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
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1646452076, $dirty2, -1, "kntr.app.mall.product.details.page.ui.components.CountDownComponent (MergeAtmospherePriceFloorComponent.kt:790)");
            }
            Long leftTime2 = countDownInfo != null ? countDownInfo.getLeftTime() : null;
            final PageViewModel pageViewModel2 = pageViewModelWrapper.getViewModel();
            ComposerKt.sourceInformationMarkerStart($composer2, 1692493232, "CC(remember):MergeAtmospherePriceFloorComponent.kt#9igjgp");
            boolean invalid$iv = $composer2.changedInstance(pageViewModel2);
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function0() { // from class: kntr.app.mall.product.details.page.ui.components.MergeAtmospherePriceFloorComponentKt$$ExternalSyntheticLambda18
                    public final Object invoke() {
                        Unit CountDownComponent_PYNUQm4$lambda$0$0;
                        CountDownComponent_PYNUQm4$lambda$0$0 = MergeAtmospherePriceFloorComponentKt.CountDownComponent_PYNUQm4$lambda$0$0(PageViewModel.this);
                        return CountDownComponent_PYNUQm4$lambda$0$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            String countDownText = rememberCountdown(leftTime2, (Function0) it$iv, $composer2, 0, 0);
            if (leftTime2 != null && leftTime2.longValue() > 0) {
                if (countDownText.length() == 0) {
                    pageViewModel = pageViewModel2;
                    leftTime = leftTime2;
                } else {
                    int $changed$iv = ($dirty2 >> 12) & 14;
                    Modifier modifier$iv = modifier3;
                    ComposerKt.sourceInformationMarkerStart($composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                    Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                    Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getTop();
                    int $i$f$Row = (($changed$iv >> 3) & 14) | (($changed$iv >> 3) & 112);
                    MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer2, $i$f$Row);
                    int $changed$iv$iv = ($changed$iv << 3) & 112;
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
                    int i4 = (($changed$iv >> 6) & 112) | 6;
                    RowScope $this$CountDownComponent_PYNUQm4_u24lambda_u242 = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart($composer2, -576906731, "C809@35556L510,823@36075L52,824@36136L484,838@36629L52,839@36690L510:MergeAtmospherePriceFloorComponent.kt#o90vz8");
                    long textColor = styleColor != null ? styleColor.unbox-impl() : Color.Companion.getWhite-0d7_KjU();
                    String countDownPrefix = countDownInfo.getCountDownPrefix();
                    TextKt.Text-Nvy7gAk(countDownPrefix == null ? "" : countDownPrefix, $this$CountDownComponent_PYNUQm4_u24lambda_u242.alignByBaseline(Modifier.Companion), textColor, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, ProvideUiScaleKt.scaled(new TextStyle(0L, TextUnitKt.getSp(12), FontWeight.Companion.getNormal(), (FontStyle) null, (FontSynthesis) null, FontFamily.Companion.getMonospace(), "tnum", 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(17), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646041, (DefaultConstructorMarker) null), scale), $composer2, 0, 24576, 114680);
                    SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(4, scale)), $composer2, 0);
                    TextKt.Text-Nvy7gAk(countDownText, $this$CountDownComponent_PYNUQm4_u24lambda_u242.alignByBaseline(Modifier.Companion), textColor, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, ProvideUiScaleKt.scaled(new TextStyle(0L, TextUnitKt.getSp(12), FontWeight.Companion.getNormal(), (FontStyle) null, (FontSynthesis) null, FontFamily.Companion.getMonospace(), "tnum", 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(17), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646041, (DefaultConstructorMarker) null), scale), $composer2, 0, 24576, 114680);
                    SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(4, scale)), $composer2, 0);
                    String countDownSuffix = countDownInfo.getCountDownSuffix();
                    TextKt.Text-Nvy7gAk(countDownSuffix == null ? "" : countDownSuffix, $this$CountDownComponent_PYNUQm4_u24lambda_u242.alignByBaseline(Modifier.Companion), textColor, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, ProvideUiScaleKt.scaled(new TextStyle(0L, TextUnitKt.getSp(12), FontWeight.Companion.getNormal(), (FontStyle) null, (FontSynthesis) null, FontFamily.Companion.getMonospace(), "tnum", 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(17), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646041, (DefaultConstructorMarker) null), scale), $composer2, 0, 24576, 114680);
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
            } else {
                pageViewModel = pageViewModel2;
                leftTime = leftTime2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
            if (endRestartGroup != null) {
                final Modifier modifier4 = modifier3;
                endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.MergeAtmospherePriceFloorComponentKt$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj, Object obj2) {
                        Unit CountDownComponent_PYNUQm4$lambda$1;
                        CountDownComponent_PYNUQm4$lambda$1 = MergeAtmospherePriceFloorComponentKt.CountDownComponent_PYNUQm4$lambda$1(CountDownInfoVO.this, styleColor, pageViewModelWrapper, scale, modifier4, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                        return CountDownComponent_PYNUQm4$lambda$1;
                    }
                });
                return;
            }
            return;
        }
        ScopeUpdateScope endRestartGroup2 = $composer2.endRestartGroup();
        if (endRestartGroup2 != null) {
            final Modifier modifier5 = modifier3;
            endRestartGroup2.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.MergeAtmospherePriceFloorComponentKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit CountDownComponent_PYNUQm4$lambda$3;
                    CountDownComponent_PYNUQm4$lambda$3 = MergeAtmospherePriceFloorComponentKt.CountDownComponent_PYNUQm4$lambda$3(CountDownInfoVO.this, styleColor, pageViewModelWrapper, scale, modifier5, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return CountDownComponent_PYNUQm4$lambda$3;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CountDownComponent_PYNUQm4$lambda$0$0(PageViewModel $pageViewModel) {
        $pageViewModel.reloadProductDetails$product_details_page_debug();
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v5 */
    public static final String rememberCountdown(Long leftTimeSeconds, Function0<Unit> function0, Composer $composer, int $changed, int i) {
        Function0<Unit> function02;
        ComposerKt.sourceInformationMarkerStart($composer, 357096105, "C(rememberCountdown)N(leftTimeSeconds,onCountdownEnd)859@37306L2,861@37347L31,862@37412L36,866@37527L222,874@37787L905,874@37755L937:MergeAtmospherePriceFloorComponent.kt#o90vz8");
        if ((i & 2) != 0) {
            ComposerKt.sourceInformationMarkerStart($composer, -428024085, "CC(remember):MergeAtmospherePriceFloorComponent.kt#9igjgp");
            Object it$iv = $composer.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function0() { // from class: kntr.app.mall.product.details.page.ui.components.MergeAtmospherePriceFloorComponentKt$$ExternalSyntheticLambda10
                    public final Object invoke() {
                        Unit unit;
                        unit = Unit.INSTANCE;
                        return unit;
                    }
                };
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            function02 = it$iv;
        } else {
            function02 = function0;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(357096105, $changed, -1, "kntr.app.mall.product.details.page.ui.components.rememberCountdown (MergeAtmospherePriceFloorComponent.kt:860)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, -428022744, "CC(remember):MergeAtmospherePriceFloorComponent.kt#9igjgp");
        Object it$iv2 = $composer.rememberedValue();
        if (it$iv2 == Composer.Companion.getEmpty()) {
            Object value$iv2 = SnapshotStateKt.mutableStateOf$default("", (SnapshotMutationPolicy) null, 2, (Object) null);
            $composer.updateRememberedValue(value$iv2);
            it$iv2 = value$iv2;
        }
        MutableState countDownText$delegate = (MutableState) it$iv2;
        ComposerKt.sourceInformationMarkerEnd($composer);
        State currentOnCountdownEnd$delegate = SnapshotStateKt.rememberUpdatedState(function02, $composer, ($changed >> 3) & 14);
        ComposerKt.sourceInformationMarkerStart($composer, -428016793, "CC(remember):MergeAtmospherePriceFloorComponent.kt#9igjgp");
        boolean invalid$iv = ((($changed & 14) ^ 6) > 4 && $composer.changed(leftTimeSeconds)) || ($changed & 6) == 4;
        Object it$iv3 = $composer.rememberedValue();
        if (invalid$iv || it$iv3 == Composer.Companion.getEmpty()) {
            long j = 0;
            if (leftTimeSeconds != null && leftTimeSeconds.longValue() > 0) {
                j = DateFormatKt.getCurrentTimeMillis() + (leftTimeSeconds.longValue() * 1000);
            }
            Object value$iv3 = Long.valueOf(j);
            $composer.updateRememberedValue(value$iv3);
            it$iv3 = value$iv3;
        }
        long targetEndTime = ((Number) it$iv3).longValue();
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerStart($composer, -428007790, "CC(remember):MergeAtmospherePriceFloorComponent.kt#9igjgp");
        boolean invalid$iv2 = $composer.changed(targetEndTime) | (((($changed & 14) ^ 6) > 4 && $composer.changed(leftTimeSeconds)) || ($changed & 6) == 4) | $composer.changed(currentOnCountdownEnd$delegate);
        Object value$iv4 = $composer.rememberedValue();
        if (invalid$iv2 || value$iv4 == Composer.Companion.getEmpty()) {
            value$iv4 = new MergeAtmospherePriceFloorComponentKt$rememberCountdown$2$1(leftTimeSeconds, targetEndTime, countDownText$delegate, currentOnCountdownEnd$delegate, null);
            $composer.updateRememberedValue(value$iv4);
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        EffectsKt.LaunchedEffect(leftTimeSeconds, (Function2) value$iv4, $composer, $changed & 14);
        String rememberCountdown$lambda$2 = rememberCountdown$lambda$2(countDownText$delegate);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return rememberCountdown$lambda$2;
    }

    private static final String rememberCountdown$lambda$2(MutableState<String> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return (String) $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function0<Unit> rememberCountdown$lambda$4(State<? extends Function0<Unit>> state) {
        Object thisObj$iv = state.getValue();
        return (Function0) thisObj$iv;
    }

    static /* synthetic */ float calculateRightVOWidth$default(MergeAtmospherePriceFloor.MergePriceInfo.RightVO rightVO, TextMeasurer textMeasurer, Density density, float f, boolean z, int i, Object obj) {
        if ((i & 16) != 0) {
            z = true;
        }
        return calculateRightVOWidth(rightVO, textMeasurer, density, f, z);
    }

    private static final float calculateRightVOWidth(MergeAtmospherePriceFloor.MergePriceInfo.RightVO rightVO, TextMeasurer textMeasurer, Density density, float scale, boolean hasFrontImage) {
        float defaultWidth;
        double d;
        double bottomWidth;
        TextColorModel timeText;
        List labels;
        if (hasFrontImage) {
            defaultWidth = ProvideUiScaleKt.dpScaled(116, scale);
        } else {
            defaultWidth = Dp.constructor-impl(0);
        }
        if (rightVO == null) {
            return defaultWidth;
        }
        double maxWidth = 0.0d;
        MergeAtmospherePriceFloor.MergePriceInfo.RightVO.RightTopVO rightTopVO = rightVO.getRightTopVO();
        if (rightTopVO != null && (labels = rightTopVO.getLabels()) != null) {
            double topWidth = 0.0d;
            List $this$forEach$iv = labels;
            for (Object element$iv : $this$forEach$iv) {
                ImageColorModel label = (ImageColorModel) element$iv;
                Double width = label.getWidth();
                topWidth += width != null ? width.doubleValue() : 0.0d;
            }
            if (labels.size() > 1) {
                topWidth += (labels.size() - 1) * 6.0d;
            }
            maxWidth = Math.max(0.0d, topWidth * scale);
        }
        MergeAtmospherePriceFloor.MergePriceInfo.RightVO.RightBottomVO rightBottomVO = rightVO.getRightBottomVO();
        if (rightBottomVO != null) {
            CountDownInfoVO countDownInfoVO = rightBottomVO.getCountDownInfoVO();
            if (countDownInfoVO != null ? Intrinsics.areEqual(countDownInfoVO.getShowCountDown(), true) : false) {
                String prefix = countDownInfoVO.getCountDownPrefix();
                if (prefix == null) {
                    prefix = "";
                }
                String countDownSuffix = countDownInfoVO.getCountDownSuffix();
                String suffix = countDownSuffix != null ? countDownSuffix : "";
                String fullText = prefix + " 00:00:00 " + suffix;
                float textWidth = density.toDp-u2uoSUM((int) (TextMeasurer.measure-xDpz5zY$default(textMeasurer, new AnnotatedString(fullText, (List) null, 2, (DefaultConstructorMarker) null), ProvideUiScaleKt.scaled(new TextStyle(0L, TextUnitKt.getSp(12), FontWeight.Companion.getNormal(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777209, (DefaultConstructorMarker) null), scale), 0, false, 0, (List) null, 0L, (LayoutDirection) null, (Density) null, (FontFamily.Resolver) null, false, 2044, (Object) null).getSize-YbymL2g() >> 32));
                bottomWidth = textWidth;
            } else if (((countDownInfoVO == null || (timeText = countDownInfoVO.getTimeText()) == null) ? null : timeText.getText()) != null) {
                String text = countDownInfoVO.getTimeText().getText();
                float textWidth2 = density.toDp-u2uoSUM((int) (TextMeasurer.measure-xDpz5zY$default(textMeasurer, new AnnotatedString(text, (List) null, 2, (DefaultConstructorMarker) null), ProvideUiScaleKt.scaled(new TextStyle(0L, TextUnitKt.getSp(12), (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777213, (DefaultConstructorMarker) null), scale), 0, false, 0, (List) null, 0L, (LayoutDirection) null, (Density) null, (FontFamily.Resolver) null, false, 2044, (Object) null).getSize-YbymL2g() >> 32));
                double bottomWidth2 = textWidth2;
                bottomWidth = bottomWidth2;
            } else {
                TextColorModel infoText = rightBottomVO.getInfoText();
                if ((infoText != null ? infoText.getText() : null) == null) {
                    bottomWidth = 0.0d;
                } else {
                    String text2 = rightBottomVO.getInfoText().getText();
                    float textWidth3 = density.toDp-u2uoSUM((int) (TextMeasurer.measure-xDpz5zY$default(textMeasurer, new AnnotatedString(text2, (List) null, 2, (DefaultConstructorMarker) null), ProvideUiScaleKt.scaled(new TextStyle(0L, TextUnitKt.getSp(12), (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777213, (DefaultConstructorMarker) null), scale), 0, false, 0, (List) null, 0L, (LayoutDirection) null, (Density) null, (FontFamily.Resolver) null, false, 2044, (Object) null).getSize-YbymL2g() >> 32));
                    double bottomWidth3 = textWidth3;
                    bottomWidth = bottomWidth3;
                }
            }
            maxWidth = Math.max(maxWidth, bottomWidth);
        }
        if (hasFrontImage) {
            d = scale * 116.0d;
        } else {
            d = maxWidth + (scale * 16.0d);
        }
        double minWidth = d;
        double finalWidth = Math.max((scale * 16.0d) + maxWidth, minWidth);
        return Dp.constructor-impl((float) finalWidth);
    }

    /* renamed from: calculateFittingItems-6a0pyJM  reason: not valid java name */
    private static final FittingItemsResult m504calculateFittingItems6a0pyJM(List<PriceDescVO> list, List<TextColorModel> list2, float f, float scale, TextMeasurer textMeasurer, Density density) {
        double separatorWidth;
        double separatorWidth2;
        List fittingPriceDescVOs = new ArrayList();
        List fittingBenefitInfos = new ArrayList();
        double currentWidth = 0.0d;
        double availableWidthPx = density.toPx-0680j_4(f);
        boolean canContinue = true;
        int i = 12;
        if (list != null) {
            Iterator<PriceDescVO> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                PriceDescVO vo = it.next();
                if (!fittingPriceDescVOs.isEmpty()) {
                    separatorWidth2 = density.toPx-0680j_4(ProvideUiScaleKt.dpScaled(12, scale));
                } else {
                    separatorWidth2 = 0.0d;
                }
                double itemWidth = calculatePriceDescVOWidth(vo, textMeasurer, scale, density);
                if (currentWidth + separatorWidth2 + itemWidth <= availableWidthPx) {
                    currentWidth += separatorWidth2 + itemWidth;
                    fittingPriceDescVOs.add(vo);
                } else {
                    canContinue = false;
                    break;
                }
            }
        }
        if (canContinue && list2 != null) {
            Iterator<TextColorModel> it2 = list2.iterator();
            while (it2.hasNext()) {
                TextColorModel model = it2.next();
                String text = model.getText();
                if (!(text == null || text.length() == 0)) {
                    if (!fittingPriceDescVOs.isEmpty() || !fittingBenefitInfos.isEmpty()) {
                        separatorWidth = density.toPx-0680j_4(ProvideUiScaleKt.dpScaled(i, scale));
                    } else {
                        separatorWidth = 0.0d;
                    }
                    boolean canContinue2 = canContinue;
                    Iterator<TextColorModel> it3 = it2;
                    double itemWidth2 = (int) (TextMeasurer.measure-xDpz5zY$default(textMeasurer, new AnnotatedString(model.getText(), (List) null, 2, (DefaultConstructorMarker) null), ProvideUiScaleKt.scaled(new TextStyle(0L, TextUnitKt.getSp(12), (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777213, (DefaultConstructorMarker) null), scale), 0, false, 0, (List) null, 0L, (LayoutDirection) null, (Density) null, (FontFamily.Resolver) null, false, 2044, (Object) null).getSize-YbymL2g() >> 32);
                    if (currentWidth + separatorWidth + itemWidth2 > availableWidthPx) {
                        break;
                    }
                    currentWidth += separatorWidth + itemWidth2;
                    fittingBenefitInfos.add(model);
                    canContinue = canContinue2;
                    it2 = it3;
                    i = 12;
                } else {
                    it2 = it2;
                    i = 12;
                }
            }
        }
        return new FittingItemsResult(fittingPriceDescVOs, fittingBenefitInfos);
    }

    private static final double calculatePriceDescVOWidth(PriceDescVO item, TextMeasurer textMeasurer, float scale, Density density) {
        List texts;
        Iterable $this$forEach$iv;
        double totalWidth = 0.0d;
        String pricePrefix = item.getPricePrefix();
        if (pricePrefix == null) {
            pricePrefix = "";
        }
        String priceSymbol = item.getPriceSymbol();
        if (priceSymbol == null) {
            priceSymbol = "";
        }
        String priceIntegerPart = item.getPriceIntegerPart();
        if (priceIntegerPart == null) {
            priceIntegerPart = "";
        }
        String priceDecimalPart = item.getPriceDecimalPart();
        String str = priceDecimalPart == null || priceDecimalPart.length() == 0 ? "" : "." + item.getPriceDecimalPart();
        String priceSuffix = item.getPriceSuffix();
        List texts2 = CollectionsKt.listOf(new String[]{pricePrefix, priceSymbol, priceIntegerPart, str, priceSuffix != null ? priceSuffix : ""});
        List $this$forEach$iv2 = texts2;
        for (Object element$iv : $this$forEach$iv2) {
            String text = (String) element$iv;
            if (!(text.length() > 0)) {
                texts = texts2;
                $this$forEach$iv = $this$forEach$iv2;
            } else {
                texts = texts2;
                $this$forEach$iv = $this$forEach$iv2;
                double textWidth = (int) (TextMeasurer.measure-xDpz5zY$default(textMeasurer, new AnnotatedString(text, (List) null, 2, (DefaultConstructorMarker) null), ProvideUiScaleKt.scaled(new TextStyle(0L, TextUnitKt.getSp(12), (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777213, (DefaultConstructorMarker) null), scale), 0, false, 0, (List) null, 0L, (LayoutDirection) null, (Density) null, (FontFamily.Resolver) null, false, 2044, (Object) null).getSize-YbymL2g() >> 32);
                totalWidth += textWidth;
            }
            texts2 = texts;
            $this$forEach$iv2 = $this$forEach$iv;
        }
        if (Intrinsics.areEqual(item.getCanClick(), true)) {
            return totalWidth + density.toPx-0680j_4(ProvideUiScaleKt.dpScaled(12, scale));
        }
        return totalWidth;
    }
}