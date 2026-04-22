package kntr.app.mall.product.details.page.ui.container;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.BorderStroke;
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
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.ButtonColors;
import androidx.compose.material3.ButtonElevation;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
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
import androidx.compose.ui.draw.AlphaKt;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.layout.ContentScale;
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
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import com.bilibili.compose.theme.BiliTheme;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kntr.app.mall.product.details.page.api.model.ActionIconModel;
import kntr.app.mall.product.details.page.api.model.CountDownInfoVO;
import kntr.app.mall.product.details.page.api.model.FooterFloor;
import kntr.app.mall.product.details.page.api.model.PriceDescVO;
import kntr.app.mall.product.details.page.api.model.WishInfo;
import kntr.app.mall.product.details.page.ui.components.BottomSheetKt;
import kntr.app.mall.product.details.page.ui.components.CollectorHolder;
import kntr.app.mall.product.details.page.ui.components.ExposerKt;
import kntr.app.mall.product.details.page.ui.components.MergeAtmospherePriceFloorComponentKt;
import kntr.app.mall.product.details.page.ui.scale.ProvideUiScaleKt;
import kntr.app.mall.product.details.page.ui.scale.UiScaleModel;
import kntr.app.mall.product.details.page.utils.DayNightTheme;
import kntr.app.mall.product.details.page.utils.HelperKt;
import kntr.app.mall.product.details.page.utils.ThemesKt;
import kntr.app.mall.product.details.page.utils.TrackConsts;
import kntr.app.mall.product.details.page.vm.BottomContainerState;
import kntr.app.mall.product.details.page.vm.ContentModule;
import kntr.app.mall.product.details.page.vm.PageActionHandler;
import kntr.app.mall.product.details.page.vm.PageViewModel;
import kntr.app.mall.product.details.page.vm.PageViewModelWrapper;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.imageloader.BiliImageKt;
import kntr.base.imageloader.ImageRequest;
import kntr.base.imageloader.ImmutableImageRequest;
import kntr.base.imageloader.LoopCount;
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

/* compiled from: BottomContainer.kt */
@Metadata(d1 = {"\u0000\\\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0001¢\u0006\u0002\u0010\u0006\u001aw\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\r2\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\r2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u0010H\u0001¢\u0006\u0002\u0010\u0014\u001a]\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00010\r2\b\b\u0002\u0010\u001d\u001a\u00020\u00102\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0017H\u0001¢\u0006\u0002\u0010\u001f\u001a\u0010\u0010 \u001a\u00020\u00172\u0006\u0010!\u001a\u00020\u0012H\u0002¨\u0006\"²\u0006\n\u0010#\u001a\u00020$X\u008a\u0084\u0002²\u0006\f\u0010%\u001a\u0004\u0018\u00010&X\u008a\u0084\u0002²\u0006\n\u0010'\u001a\u00020\u0010X\u008a\u008e\u0002²\u0006\n\u0010(\u001a\u00020)X\u008a\u0084\u0002²\u0006\n\u0010*\u001a\u00020\u0010X\u008a\u0084\u0002²\u0006\n\u0010#\u001a\u00020$X\u008a\u0084\u0002"}, d2 = {"BottomContainer", "", "pageViewModelWrapper", "Lkntr/app/mall/product/details/page/vm/PageViewModelWrapper;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lkntr/app/mall/product/details/page/vm/PageViewModelWrapper;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "PurchaseButtonComponent", "data", "Lkntr/app/mall/product/details/page/api/model/FooterFloor$PurchaseButton;", "addCartData", "Lkntr/app/mall/product/details/page/api/model/FooterFloor$AddCartButton;", "onAddButton", "Lkotlin/Function0;", "onPurchaseButton", "mergeCartBuyButton", "", "mergeCartBuyButtonType", "", "showSkinCover", "(Lkntr/app/mall/product/details/page/vm/PageViewModelWrapper;Landroidx/compose/ui/Modifier;Lkntr/app/mall/product/details/page/api/model/FooterFloor$PurchaseButton;Lkntr/app/mall/product/details/page/api/model/FooterFloor$AddCartButton;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;ZLjava/lang/Integer;ZLandroidx/compose/runtime/Composer;II)V", "IconTextButton", "iconUrl", "", "text", "isLike", "scale", "", "onClick", "needClip", "iconOutlineColor", "(Ljava/lang/String;Ljava/lang/String;ZFLandroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;ZLjava/lang/String;Landroidx/compose/runtime/Composer;II)V", "formatWishCount", "count", "product-details-page_debug", "scaleModel", "Lkntr/app/mall/product/details/page/ui/scale/UiScaleModel;", "bottomContainerState", "Lkntr/app/mall/product/details/page/vm/BottomContainerState;", "showSheet", "wishInfo", "Lkntr/app/mall/product/details/page/api/model/WishInfo;", "isUserTriggeredWishAction"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class BottomContainerKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BottomContainer$lambda$5(PageViewModelWrapper pageViewModelWrapper, Modifier modifier, int i, int i2, Composer composer, int i3) {
        BottomContainer(pageViewModelWrapper, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BottomContainer$lambda$9(PageViewModelWrapper pageViewModelWrapper, Modifier modifier, int i, int i2, Composer composer, int i3) {
        BottomContainer(pageViewModelWrapper, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IconTextButton$lambda$2(String str, String str2, boolean z, float f, Modifier modifier, Function0 function0, boolean z2, String str3, int i, int i2, Composer composer, int i3) {
        IconTextButton(str, str2, z, f, modifier, function0, z2, str3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PurchaseButtonComponent$lambda$3(PageViewModelWrapper pageViewModelWrapper, Modifier modifier, FooterFloor.PurchaseButton purchaseButton, FooterFloor.AddCartButton addCartButton, Function0 function0, Function0 function02, boolean z, Integer num, boolean z2, int i, int i2, Composer composer, int i3) {
        PurchaseButtonComponent(pageViewModelWrapper, modifier, purchaseButton, addCartButton, function0, function02, z, num, z2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PurchaseButtonComponent$lambda$5(PageViewModelWrapper pageViewModelWrapper, Modifier modifier, FooterFloor.PurchaseButton purchaseButton, FooterFloor.AddCartButton addCartButton, Function0 function0, Function0 function02, boolean z, Integer num, boolean z2, int i, int i2, Composer composer, int i3) {
        PurchaseButtonComponent(pageViewModelWrapper, modifier, purchaseButton, addCartButton, function0, function02, z, num, z2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:119:0x0596  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x059a  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x05ac  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x05af  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x05c4  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x05c7  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x05ea  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x065e  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x066d A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:155:0x06d0  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x06dc A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void BottomContainer(final PageViewModelWrapper pageViewModelWrapper, Modifier modifier, Composer $composer, final int $changed, final int i) {
        final Modifier modifier2;
        Composer $composer2;
        final Modifier modifier3;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Function0 factory$iv$iv$iv3;
        final PageViewModel pageViewModel;
        FooterFloor footerFloorData;
        boolean z;
        int $changed$iv$iv$iv;
        Modifier materialized$iv$iv;
        final Boolean iconActive;
        String text;
        Integer type;
        CompositionLocalMap localMap$iv$iv;
        boolean z2;
        Integer type2;
        State wishInfo$delegate;
        boolean z3;
        Integer type3;
        boolean z4;
        boolean z5;
        String iconUrl$product_details_page_debug;
        boolean invalid$iv;
        Object it$iv;
        Object value$iv;
        boolean invalid$iv2;
        float dpScaled;
        final MutableState showSheet$delegate;
        Boolean mergeCartBuyButton;
        ContentModule.FooterModule data;
        Intrinsics.checkNotNullParameter(pageViewModelWrapper, "pageViewModelWrapper");
        Composer $composer3 = $composer.startRestartGroup(1117962422);
        ComposerKt.sourceInformation($composer3, "C(BottomContainer)N(pageViewModelWrapper,modifier)69@3272L16,70@3379L16,72@3476L34,73@3529L22,77@3674L16,78@3768L16,79@3811L25,80@3841L8329:BottomContainer.kt#u9475x");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changedInstance(pageViewModelWrapper) ? 4 : 2;
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
                ComposerKt.traceEventStart(1117962422, $dirty, -1, "kntr.app.mall.product.details.page.ui.container.BottomContainer (BottomContainer.kt:67)");
            }
            PageViewModel pageViewModel2 = pageViewModelWrapper.getViewModel();
            final State scaleModel$delegate = SnapshotStateKt.collectAsState(pageViewModel2.getUiScaleModelFlow$product_details_page_debug(), (CoroutineContext) null, $composer3, 0, 1);
            State bottomContainerState$delegate = SnapshotStateKt.collectAsState(pageViewModel2.getBottomContainerState$product_details_page_debug(), (CoroutineContext) null, $composer3, 0, 1);
            BottomContainerState BottomContainer$lambda$1 = BottomContainer$lambda$1(bottomContainerState$delegate);
            FooterFloor footerFloorData2 = (BottomContainer$lambda$1 == null || (data = BottomContainer$lambda$1.getData()) == null) ? null : data.getData();
            ComposerKt.sourceInformationMarkerStart($composer3, 620077016, "CC(remember):BottomContainer.kt#9igjgp");
            Object it$iv2 = $composer3.rememberedValue();
            if (it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer3.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            MutableState showSheet$delegate2 = (MutableState) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            boolean isLight = Intrinsics.areEqual(ThemesKt.currentDayNightTheme($composer3, 0), DayNightTheme.Light.INSTANCE);
            FooterFloor footerFloorData3 = footerFloorData2;
            if (footerFloorData3 != null) {
                State wishInfo$delegate2 = SnapshotStateKt.collectAsState(pageViewModel2.getWishInfo(), (CoroutineContext) null, $composer3, 0, 1);
                State isUserTriggeredWishAction$delegate = SnapshotStateKt.collectAsState(pageViewModel2.isUserTriggeredWishAction(), (CoroutineContext) null, $composer3, 0, 1);
                CollectorHolder collectorHolder = ExposerKt.rememberCollectorHolder($composer3, 0);
                Modifier modifier4 = modifier3;
                Modifier modifier$iv = PaddingKt.padding-VpY3zN4$default(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(modifier3, 0.0f, 1, (Object) null), ProvideUiScaleKt.dpScaled(60, BottomContainer$lambda$0(scaleModel$delegate).getScale())), ProvideUiScaleKt.dpScaled(12, BottomContainer$lambda$0(scaleModel$delegate).getScale()), 0.0f, 2, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
                MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                int $changed$iv$iv = (0 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
                CompositionLocalMap localMap$iv$iv2 = $composer3.getCurrentCompositionLocalMap();
                $composer2 = $composer3;
                Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
                Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv2 = (($changed$iv$iv << 6) & 896) | 6;
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
                PageViewModel pageViewModel3 = pageViewModel2;
                String str = "CC(remember):BottomContainer.kt#9igjgp";
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
                int i3 = ($changed$iv$iv$iv2 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScope boxScope = BoxScopeInstance.INSTANCE;
                int i4 = ((0 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, -707297240, "C87@4089L7197,239@11363L21,252@11918L246,237@11296L868:BottomContainer.kt#u9475x");
                Modifier modifier$iv2 = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
                Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((390 >> 3) & 14) | ((390 >> 3) & 112));
                int $changed$iv$iv2 = (390 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
                CompositionLocalMap localMap$iv$iv3 = $composer3.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer3, modifier$iv2);
                Function0 factory$iv$iv$iv5 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv3 = (($changed$iv$iv2 << 6) & 896) | 6;
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
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
                int i5 = ($changed$iv$iv$iv3 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                int i6 = ((390 >> 6) & 112) | 6;
                RowScope $this$BottomContainer_u24lambda_u248_u240 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer3, 1704231569, "C93@4262L5842,220@10494L215,225@10746L220,212@10117L1159:BottomContainer.kt#u9475x");
                Modifier modifier$iv3 = SizeKt.fillMaxHeight$default(Modifier.Companion, 0.0f, 1, (Object) null);
                Alignment.Vertical verticalAlignment$iv2 = Alignment.Companion.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.getStart();
                MeasurePolicy measurePolicy$iv3 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer3, ((390 >> 3) & 14) | ((390 >> 3) & 112));
                int $changed$iv$iv3 = (390 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
                CompositionLocalMap localMap$iv$iv4 = $composer3.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer3, modifier$iv3);
                Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv4 = (($changed$iv$iv3 << 6) & 896) | 6;
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
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv4, ComposeUiNode.Companion.getSetModifier());
                int i7 = ($changed$iv$iv$iv4 >> 6) & 14;
                boolean z6 = false;
                ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScope rowScope = RowScopeInstance.INSTANCE;
                int i8 = ((390 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, -1250488642, "C:BottomContainer.kt#u9475x");
                Iterable footer = footerFloorData3.getFooter();
                if (footer == null) {
                    $composer3.startReplaceGroup(-1250465580);
                    $composer3.endReplaceGroup();
                    pageViewModel = pageViewModel3;
                    footerFloorData = footerFloorData3;
                } else {
                    $composer3.startReplaceGroup(-1250465579);
                    ComposerKt.sourceInformation($composer3, "*173@8073L1860,168@7732L2201,133@5997L1557,123@5487L4585");
                    Iterable $this$forEachIndexed$iv = footer;
                    boolean z7 = false;
                    int index$iv = 0;
                    for (Object item$iv : $this$forEachIndexed$iv) {
                        int index$iv2 = index$iv + 1;
                        if (index$iv < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        Iterable $this$forEachIndexed$iv2 = $this$forEachIndexed$iv;
                        final ActionIconModel item = (ActionIconModel) item$iv;
                        int index = index$iv;
                        if (index > 0) {
                            z = z7;
                            $composer3.startReplaceGroup(-15264633);
                            ComposerKt.sourceInformation($composer3, "101@4578L369");
                            Modifier modifier5 = Modifier.Companion;
                            Integer type4 = item.getType();
                            $changed$iv$iv$iv = $changed$iv$iv$iv4;
                            if (type4 == null) {
                                materialized$iv$iv = materialized$iv$iv4;
                            } else {
                                int $changed$iv$iv$iv5 = type4.intValue();
                                materialized$iv$iv = materialized$iv$iv4;
                                if ($changed$iv$iv$iv5 == 6) {
                                    dpScaled = ProvideUiScaleKt.dpScaled(8, BottomContainer$lambda$0(scaleModel$delegate).getScale());
                                    SpacerKt.Spacer(SizeKt.width-3ABfNKs(modifier5, dpScaled), $composer3, 0);
                                }
                            }
                            dpScaled = ProvideUiScaleKt.dpScaled(18, BottomContainer$lambda$0(scaleModel$delegate).getScale());
                            SpacerKt.Spacer(SizeKt.width-3ABfNKs(modifier5, dpScaled), $composer3, 0);
                        } else {
                            z = z7;
                            $changed$iv$iv$iv = $changed$iv$iv$iv4;
                            materialized$iv$iv = materialized$iv$iv4;
                            $composer3.startReplaceGroup(-19794136);
                        }
                        $composer3.endReplaceGroup();
                        Integer type5 = item.getType();
                        if (type5 != null && type5.intValue() == 6) {
                            iconActive = BottomContainer$lambda$6(wishInfo$delegate2).getActive();
                        } else {
                            iconActive = null;
                        }
                        Integer type6 = item.getType();
                        if (type6 != null && type6.intValue() == 6) {
                            Integer count = BottomContainer$lambda$6(wishInfo$delegate2).getCount();
                            if ((count != null ? count.intValue() : 0) > 0) {
                                Integer count2 = BottomContainer$lambda$6(wishInfo$delegate2).getCount();
                                text = formatWishCount(count2 != null ? count2.intValue() : 0);
                                type = item.getType();
                                if (type != null) {
                                    localMap$iv$iv = localMap$iv$iv4;
                                } else {
                                    localMap$iv$iv = localMap$iv$iv4;
                                    if (type.intValue() == 4) {
                                        z2 = true;
                                        type2 = item.getType();
                                        if (type2 == null) {
                                            wishInfo$delegate = wishInfo$delegate2;
                                        } else {
                                            int intValue = type2.intValue();
                                            wishInfo$delegate = wishInfo$delegate2;
                                            if (intValue == 6) {
                                                z3 = true;
                                                type3 = item.getType();
                                                if (type3 != null) {
                                                    z4 = z6;
                                                } else {
                                                    z4 = z6;
                                                    if (type3.intValue() == 6 && Intrinsics.areEqual(iconActive, true) && !BottomContainer$lambda$7(isUserTriggeredWishAction$delegate)) {
                                                        z5 = true;
                                                        iconUrl$product_details_page_debug = item.getIconUrl$product_details_page_debug(isLight, iconActive, z5);
                                                        if (iconUrl$product_details_page_debug == null) {
                                                            iconUrl$product_details_page_debug = "";
                                                        }
                                                        boolean isLight2 = isLight;
                                                        State isUserTriggeredWishAction$delegate2 = isUserTriggeredWishAction$delegate;
                                                        Modifier modifier6 = SizeKt.height-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(42, BottomContainer$lambda$0(scaleModel$delegate).getScale()));
                                                        String str2 = "mall_detail_footer_" + item.getType() + "_" + iconActive + "_" + text;
                                                        String str3 = str;
                                                        ComposerKt.sourceInformationMarkerStart($composer3, -1524398946, str3);
                                                        final PageViewModel pageViewModel4 = pageViewModel3;
                                                        invalid$iv = $composer3.changed(item) | $composer3.changedInstance(pageViewModel4) | $composer3.changed(iconActive);
                                                        FooterFloor footerFloorData4 = footerFloorData3;
                                                        it$iv = $composer3.rememberedValue();
                                                        if (invalid$iv && it$iv != Composer.Companion.getEmpty()) {
                                                            value$iv = it$iv;
                                                            ComposerKt.sourceInformationMarkerEnd($composer3);
                                                            Modifier reportOnExposure = ExposerKt.reportOnExposure(modifier6, str2, collectorHolder, null, false, 0.5f, 0, 500L, (Function0) value$iv, $composer3, 12779520, 44);
                                                            String iconOutlineColor = item.getIconOutlineColor();
                                                            float scale = BottomContainer$lambda$0(scaleModel$delegate).getScale();
                                                            ComposerKt.sourceInformationMarkerStart($composer3, -1524465681, str3);
                                                            invalid$iv2 = $composer3.changedInstance(pageViewModel4) | $composer3.changed(item) | $composer3.changed(iconActive);
                                                            str = str3;
                                                            Object it$iv3 = $composer3.rememberedValue();
                                                            if (invalid$iv2 && it$iv3 != Composer.Companion.getEmpty()) {
                                                                ComposerKt.sourceInformationMarkerEnd($composer3);
                                                                IconTextButton(iconUrl$product_details_page_debug, text, z3, scale, reportOnExposure, (Function0) it$iv3, z2, iconOutlineColor, $composer3, 0, 0);
                                                                wishInfo$delegate2 = wishInfo$delegate;
                                                                footerFloorData3 = footerFloorData4;
                                                                index$iv = index$iv2;
                                                                $this$forEachIndexed$iv = $this$forEachIndexed$iv2;
                                                                z7 = z;
                                                                $changed$iv$iv$iv4 = $changed$iv$iv$iv;
                                                                materialized$iv$iv4 = materialized$iv$iv;
                                                                localMap$iv$iv4 = localMap$iv$iv;
                                                                z6 = z4;
                                                                isLight = isLight2;
                                                                pageViewModel3 = pageViewModel4;
                                                                isUserTriggeredWishAction$delegate = isUserTriggeredWishAction$delegate2;
                                                            }
                                                            Object value$iv3 = new Function0() { // from class: kntr.app.mall.product.details.page.ui.container.BottomContainerKt$$ExternalSyntheticLambda7
                                                                public final Object invoke() {
                                                                    Unit BottomContainer$lambda$8$0$0$0$1$0;
                                                                    BottomContainer$lambda$8$0$0$0$1$0 = BottomContainerKt.BottomContainer$lambda$8$0$0$0$1$0(PageViewModel.this, item, iconActive);
                                                                    return BottomContainer$lambda$8$0$0$0$1$0;
                                                                }
                                                            };
                                                            $composer3.updateRememberedValue(value$iv3);
                                                            it$iv3 = value$iv3;
                                                            ComposerKt.sourceInformationMarkerEnd($composer3);
                                                            IconTextButton(iconUrl$product_details_page_debug, text, z3, scale, reportOnExposure, (Function0) it$iv3, z2, iconOutlineColor, $composer3, 0, 0);
                                                            wishInfo$delegate2 = wishInfo$delegate;
                                                            footerFloorData3 = footerFloorData4;
                                                            index$iv = index$iv2;
                                                            $this$forEachIndexed$iv = $this$forEachIndexed$iv2;
                                                            z7 = z;
                                                            $changed$iv$iv$iv4 = $changed$iv$iv$iv;
                                                            materialized$iv$iv4 = materialized$iv$iv;
                                                            localMap$iv$iv4 = localMap$iv$iv;
                                                            z6 = z4;
                                                            isLight = isLight2;
                                                            pageViewModel3 = pageViewModel4;
                                                            isUserTriggeredWishAction$delegate = isUserTriggeredWishAction$delegate2;
                                                        }
                                                        Object obj = new Function0() { // from class: kntr.app.mall.product.details.page.ui.container.BottomContainerKt$$ExternalSyntheticLambda6
                                                            public final Object invoke() {
                                                                Unit BottomContainer$lambda$8$0$0$0$0$0;
                                                                BottomContainer$lambda$8$0$0$0$0$0 = BottomContainerKt.BottomContainer$lambda$8$0$0$0$0$0(ActionIconModel.this, pageViewModel4, iconActive);
                                                                return BottomContainer$lambda$8$0$0$0$0$0;
                                                            }
                                                        };
                                                        $composer3.updateRememberedValue(obj);
                                                        value$iv = obj;
                                                        ComposerKt.sourceInformationMarkerEnd($composer3);
                                                        Modifier reportOnExposure2 = ExposerKt.reportOnExposure(modifier6, str2, collectorHolder, null, false, 0.5f, 0, 500L, (Function0) value$iv, $composer3, 12779520, 44);
                                                        String iconOutlineColor2 = item.getIconOutlineColor();
                                                        float scale2 = BottomContainer$lambda$0(scaleModel$delegate).getScale();
                                                        ComposerKt.sourceInformationMarkerStart($composer3, -1524465681, str3);
                                                        invalid$iv2 = $composer3.changedInstance(pageViewModel4) | $composer3.changed(item) | $composer3.changed(iconActive);
                                                        str = str3;
                                                        Object it$iv32 = $composer3.rememberedValue();
                                                        if (invalid$iv2) {
                                                            ComposerKt.sourceInformationMarkerEnd($composer3);
                                                            IconTextButton(iconUrl$product_details_page_debug, text, z3, scale2, reportOnExposure2, (Function0) it$iv32, z2, iconOutlineColor2, $composer3, 0, 0);
                                                            wishInfo$delegate2 = wishInfo$delegate;
                                                            footerFloorData3 = footerFloorData4;
                                                            index$iv = index$iv2;
                                                            $this$forEachIndexed$iv = $this$forEachIndexed$iv2;
                                                            z7 = z;
                                                            $changed$iv$iv$iv4 = $changed$iv$iv$iv;
                                                            materialized$iv$iv4 = materialized$iv$iv;
                                                            localMap$iv$iv4 = localMap$iv$iv;
                                                            z6 = z4;
                                                            isLight = isLight2;
                                                            pageViewModel3 = pageViewModel4;
                                                            isUserTriggeredWishAction$delegate = isUserTriggeredWishAction$delegate2;
                                                        }
                                                        Object value$iv32 = new Function0() { // from class: kntr.app.mall.product.details.page.ui.container.BottomContainerKt$$ExternalSyntheticLambda7
                                                            public final Object invoke() {
                                                                Unit BottomContainer$lambda$8$0$0$0$1$0;
                                                                BottomContainer$lambda$8$0$0$0$1$0 = BottomContainerKt.BottomContainer$lambda$8$0$0$0$1$0(PageViewModel.this, item, iconActive);
                                                                return BottomContainer$lambda$8$0$0$0$1$0;
                                                            }
                                                        };
                                                        $composer3.updateRememberedValue(value$iv32);
                                                        it$iv32 = value$iv32;
                                                        ComposerKt.sourceInformationMarkerEnd($composer3);
                                                        IconTextButton(iconUrl$product_details_page_debug, text, z3, scale2, reportOnExposure2, (Function0) it$iv32, z2, iconOutlineColor2, $composer3, 0, 0);
                                                        wishInfo$delegate2 = wishInfo$delegate;
                                                        footerFloorData3 = footerFloorData4;
                                                        index$iv = index$iv2;
                                                        $this$forEachIndexed$iv = $this$forEachIndexed$iv2;
                                                        z7 = z;
                                                        $changed$iv$iv$iv4 = $changed$iv$iv$iv;
                                                        materialized$iv$iv4 = materialized$iv$iv;
                                                        localMap$iv$iv4 = localMap$iv$iv;
                                                        z6 = z4;
                                                        isLight = isLight2;
                                                        pageViewModel3 = pageViewModel4;
                                                        isUserTriggeredWishAction$delegate = isUserTriggeredWishAction$delegate2;
                                                    }
                                                }
                                                z5 = false;
                                                iconUrl$product_details_page_debug = item.getIconUrl$product_details_page_debug(isLight, iconActive, z5);
                                                if (iconUrl$product_details_page_debug == null) {
                                                }
                                                boolean isLight22 = isLight;
                                                State isUserTriggeredWishAction$delegate22 = isUserTriggeredWishAction$delegate;
                                                Modifier modifier62 = SizeKt.height-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(42, BottomContainer$lambda$0(scaleModel$delegate).getScale()));
                                                String str22 = "mall_detail_footer_" + item.getType() + "_" + iconActive + "_" + text;
                                                String str32 = str;
                                                ComposerKt.sourceInformationMarkerStart($composer3, -1524398946, str32);
                                                final PageViewModel pageViewModel42 = pageViewModel3;
                                                invalid$iv = $composer3.changed(item) | $composer3.changedInstance(pageViewModel42) | $composer3.changed(iconActive);
                                                FooterFloor footerFloorData42 = footerFloorData3;
                                                it$iv = $composer3.rememberedValue();
                                                if (invalid$iv) {
                                                    value$iv = it$iv;
                                                    ComposerKt.sourceInformationMarkerEnd($composer3);
                                                    Modifier reportOnExposure22 = ExposerKt.reportOnExposure(modifier62, str22, collectorHolder, null, false, 0.5f, 0, 500L, (Function0) value$iv, $composer3, 12779520, 44);
                                                    String iconOutlineColor22 = item.getIconOutlineColor();
                                                    float scale22 = BottomContainer$lambda$0(scaleModel$delegate).getScale();
                                                    ComposerKt.sourceInformationMarkerStart($composer3, -1524465681, str32);
                                                    invalid$iv2 = $composer3.changedInstance(pageViewModel42) | $composer3.changed(item) | $composer3.changed(iconActive);
                                                    str = str32;
                                                    Object it$iv322 = $composer3.rememberedValue();
                                                    if (invalid$iv2) {
                                                    }
                                                    Object value$iv322 = new Function0() { // from class: kntr.app.mall.product.details.page.ui.container.BottomContainerKt$$ExternalSyntheticLambda7
                                                        public final Object invoke() {
                                                            Unit BottomContainer$lambda$8$0$0$0$1$0;
                                                            BottomContainer$lambda$8$0$0$0$1$0 = BottomContainerKt.BottomContainer$lambda$8$0$0$0$1$0(PageViewModel.this, item, iconActive);
                                                            return BottomContainer$lambda$8$0$0$0$1$0;
                                                        }
                                                    };
                                                    $composer3.updateRememberedValue(value$iv322);
                                                    it$iv322 = value$iv322;
                                                    ComposerKt.sourceInformationMarkerEnd($composer3);
                                                    IconTextButton(iconUrl$product_details_page_debug, text, z3, scale22, reportOnExposure22, (Function0) it$iv322, z2, iconOutlineColor22, $composer3, 0, 0);
                                                    wishInfo$delegate2 = wishInfo$delegate;
                                                    footerFloorData3 = footerFloorData42;
                                                    index$iv = index$iv2;
                                                    $this$forEachIndexed$iv = $this$forEachIndexed$iv2;
                                                    z7 = z;
                                                    $changed$iv$iv$iv4 = $changed$iv$iv$iv;
                                                    materialized$iv$iv4 = materialized$iv$iv;
                                                    localMap$iv$iv4 = localMap$iv$iv;
                                                    z6 = z4;
                                                    isLight = isLight22;
                                                    pageViewModel3 = pageViewModel42;
                                                    isUserTriggeredWishAction$delegate = isUserTriggeredWishAction$delegate22;
                                                }
                                                Object obj2 = new Function0() { // from class: kntr.app.mall.product.details.page.ui.container.BottomContainerKt$$ExternalSyntheticLambda6
                                                    public final Object invoke() {
                                                        Unit BottomContainer$lambda$8$0$0$0$0$0;
                                                        BottomContainer$lambda$8$0$0$0$0$0 = BottomContainerKt.BottomContainer$lambda$8$0$0$0$0$0(ActionIconModel.this, pageViewModel42, iconActive);
                                                        return BottomContainer$lambda$8$0$0$0$0$0;
                                                    }
                                                };
                                                $composer3.updateRememberedValue(obj2);
                                                value$iv = obj2;
                                                ComposerKt.sourceInformationMarkerEnd($composer3);
                                                Modifier reportOnExposure222 = ExposerKt.reportOnExposure(modifier62, str22, collectorHolder, null, false, 0.5f, 0, 500L, (Function0) value$iv, $composer3, 12779520, 44);
                                                String iconOutlineColor222 = item.getIconOutlineColor();
                                                float scale222 = BottomContainer$lambda$0(scaleModel$delegate).getScale();
                                                ComposerKt.sourceInformationMarkerStart($composer3, -1524465681, str32);
                                                invalid$iv2 = $composer3.changedInstance(pageViewModel42) | $composer3.changed(item) | $composer3.changed(iconActive);
                                                str = str32;
                                                Object it$iv3222 = $composer3.rememberedValue();
                                                if (invalid$iv2) {
                                                }
                                                Object value$iv3222 = new Function0() { // from class: kntr.app.mall.product.details.page.ui.container.BottomContainerKt$$ExternalSyntheticLambda7
                                                    public final Object invoke() {
                                                        Unit BottomContainer$lambda$8$0$0$0$1$0;
                                                        BottomContainer$lambda$8$0$0$0$1$0 = BottomContainerKt.BottomContainer$lambda$8$0$0$0$1$0(PageViewModel.this, item, iconActive);
                                                        return BottomContainer$lambda$8$0$0$0$1$0;
                                                    }
                                                };
                                                $composer3.updateRememberedValue(value$iv3222);
                                                it$iv3222 = value$iv3222;
                                                ComposerKt.sourceInformationMarkerEnd($composer3);
                                                IconTextButton(iconUrl$product_details_page_debug, text, z3, scale222, reportOnExposure222, (Function0) it$iv3222, z2, iconOutlineColor222, $composer3, 0, 0);
                                                wishInfo$delegate2 = wishInfo$delegate;
                                                footerFloorData3 = footerFloorData42;
                                                index$iv = index$iv2;
                                                $this$forEachIndexed$iv = $this$forEachIndexed$iv2;
                                                z7 = z;
                                                $changed$iv$iv$iv4 = $changed$iv$iv$iv;
                                                materialized$iv$iv4 = materialized$iv$iv;
                                                localMap$iv$iv4 = localMap$iv$iv;
                                                z6 = z4;
                                                isLight = isLight22;
                                                pageViewModel3 = pageViewModel42;
                                                isUserTriggeredWishAction$delegate = isUserTriggeredWishAction$delegate22;
                                            }
                                        }
                                        z3 = false;
                                        type3 = item.getType();
                                        if (type3 != null) {
                                        }
                                        z5 = false;
                                        iconUrl$product_details_page_debug = item.getIconUrl$product_details_page_debug(isLight, iconActive, z5);
                                        if (iconUrl$product_details_page_debug == null) {
                                        }
                                        boolean isLight222 = isLight;
                                        State isUserTriggeredWishAction$delegate222 = isUserTriggeredWishAction$delegate;
                                        Modifier modifier622 = SizeKt.height-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(42, BottomContainer$lambda$0(scaleModel$delegate).getScale()));
                                        String str222 = "mall_detail_footer_" + item.getType() + "_" + iconActive + "_" + text;
                                        String str322 = str;
                                        ComposerKt.sourceInformationMarkerStart($composer3, -1524398946, str322);
                                        final PageViewModel pageViewModel422 = pageViewModel3;
                                        invalid$iv = $composer3.changed(item) | $composer3.changedInstance(pageViewModel422) | $composer3.changed(iconActive);
                                        FooterFloor footerFloorData422 = footerFloorData3;
                                        it$iv = $composer3.rememberedValue();
                                        if (invalid$iv) {
                                        }
                                        Object obj22 = new Function0() { // from class: kntr.app.mall.product.details.page.ui.container.BottomContainerKt$$ExternalSyntheticLambda6
                                            public final Object invoke() {
                                                Unit BottomContainer$lambda$8$0$0$0$0$0;
                                                BottomContainer$lambda$8$0$0$0$0$0 = BottomContainerKt.BottomContainer$lambda$8$0$0$0$0$0(ActionIconModel.this, pageViewModel422, iconActive);
                                                return BottomContainer$lambda$8$0$0$0$0$0;
                                            }
                                        };
                                        $composer3.updateRememberedValue(obj22);
                                        value$iv = obj22;
                                        ComposerKt.sourceInformationMarkerEnd($composer3);
                                        Modifier reportOnExposure2222 = ExposerKt.reportOnExposure(modifier622, str222, collectorHolder, null, false, 0.5f, 0, 500L, (Function0) value$iv, $composer3, 12779520, 44);
                                        String iconOutlineColor2222 = item.getIconOutlineColor();
                                        float scale2222 = BottomContainer$lambda$0(scaleModel$delegate).getScale();
                                        ComposerKt.sourceInformationMarkerStart($composer3, -1524465681, str322);
                                        invalid$iv2 = $composer3.changedInstance(pageViewModel422) | $composer3.changed(item) | $composer3.changed(iconActive);
                                        str = str322;
                                        Object it$iv32222 = $composer3.rememberedValue();
                                        if (invalid$iv2) {
                                        }
                                        Object value$iv32222 = new Function0() { // from class: kntr.app.mall.product.details.page.ui.container.BottomContainerKt$$ExternalSyntheticLambda7
                                            public final Object invoke() {
                                                Unit BottomContainer$lambda$8$0$0$0$1$0;
                                                BottomContainer$lambda$8$0$0$0$1$0 = BottomContainerKt.BottomContainer$lambda$8$0$0$0$1$0(PageViewModel.this, item, iconActive);
                                                return BottomContainer$lambda$8$0$0$0$1$0;
                                            }
                                        };
                                        $composer3.updateRememberedValue(value$iv32222);
                                        it$iv32222 = value$iv32222;
                                        ComposerKt.sourceInformationMarkerEnd($composer3);
                                        IconTextButton(iconUrl$product_details_page_debug, text, z3, scale2222, reportOnExposure2222, (Function0) it$iv32222, z2, iconOutlineColor2222, $composer3, 0, 0);
                                        wishInfo$delegate2 = wishInfo$delegate;
                                        footerFloorData3 = footerFloorData422;
                                        index$iv = index$iv2;
                                        $this$forEachIndexed$iv = $this$forEachIndexed$iv2;
                                        z7 = z;
                                        $changed$iv$iv$iv4 = $changed$iv$iv$iv;
                                        materialized$iv$iv4 = materialized$iv$iv;
                                        localMap$iv$iv4 = localMap$iv$iv;
                                        z6 = z4;
                                        isLight = isLight222;
                                        pageViewModel3 = pageViewModel422;
                                        isUserTriggeredWishAction$delegate = isUserTriggeredWishAction$delegate222;
                                    }
                                }
                                z2 = false;
                                type2 = item.getType();
                                if (type2 == null) {
                                }
                                z3 = false;
                                type3 = item.getType();
                                if (type3 != null) {
                                }
                                z5 = false;
                                iconUrl$product_details_page_debug = item.getIconUrl$product_details_page_debug(isLight, iconActive, z5);
                                if (iconUrl$product_details_page_debug == null) {
                                }
                                boolean isLight2222 = isLight;
                                State isUserTriggeredWishAction$delegate2222 = isUserTriggeredWishAction$delegate;
                                Modifier modifier6222 = SizeKt.height-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(42, BottomContainer$lambda$0(scaleModel$delegate).getScale()));
                                String str2222 = "mall_detail_footer_" + item.getType() + "_" + iconActive + "_" + text;
                                String str3222 = str;
                                ComposerKt.sourceInformationMarkerStart($composer3, -1524398946, str3222);
                                final PageViewModel pageViewModel4222 = pageViewModel3;
                                invalid$iv = $composer3.changed(item) | $composer3.changedInstance(pageViewModel4222) | $composer3.changed(iconActive);
                                FooterFloor footerFloorData4222 = footerFloorData3;
                                it$iv = $composer3.rememberedValue();
                                if (invalid$iv) {
                                }
                                Object obj222 = new Function0() { // from class: kntr.app.mall.product.details.page.ui.container.BottomContainerKt$$ExternalSyntheticLambda6
                                    public final Object invoke() {
                                        Unit BottomContainer$lambda$8$0$0$0$0$0;
                                        BottomContainer$lambda$8$0$0$0$0$0 = BottomContainerKt.BottomContainer$lambda$8$0$0$0$0$0(ActionIconModel.this, pageViewModel4222, iconActive);
                                        return BottomContainer$lambda$8$0$0$0$0$0;
                                    }
                                };
                                $composer3.updateRememberedValue(obj222);
                                value$iv = obj222;
                                ComposerKt.sourceInformationMarkerEnd($composer3);
                                Modifier reportOnExposure22222 = ExposerKt.reportOnExposure(modifier6222, str2222, collectorHolder, null, false, 0.5f, 0, 500L, (Function0) value$iv, $composer3, 12779520, 44);
                                String iconOutlineColor22222 = item.getIconOutlineColor();
                                float scale22222 = BottomContainer$lambda$0(scaleModel$delegate).getScale();
                                ComposerKt.sourceInformationMarkerStart($composer3, -1524465681, str3222);
                                invalid$iv2 = $composer3.changedInstance(pageViewModel4222) | $composer3.changed(item) | $composer3.changed(iconActive);
                                str = str3222;
                                Object it$iv322222 = $composer3.rememberedValue();
                                if (invalid$iv2) {
                                }
                                Object value$iv322222 = new Function0() { // from class: kntr.app.mall.product.details.page.ui.container.BottomContainerKt$$ExternalSyntheticLambda7
                                    public final Object invoke() {
                                        Unit BottomContainer$lambda$8$0$0$0$1$0;
                                        BottomContainer$lambda$8$0$0$0$1$0 = BottomContainerKt.BottomContainer$lambda$8$0$0$0$1$0(PageViewModel.this, item, iconActive);
                                        return BottomContainer$lambda$8$0$0$0$1$0;
                                    }
                                };
                                $composer3.updateRememberedValue(value$iv322222);
                                it$iv322222 = value$iv322222;
                                ComposerKt.sourceInformationMarkerEnd($composer3);
                                IconTextButton(iconUrl$product_details_page_debug, text, z3, scale22222, reportOnExposure22222, (Function0) it$iv322222, z2, iconOutlineColor22222, $composer3, 0, 0);
                                wishInfo$delegate2 = wishInfo$delegate;
                                footerFloorData3 = footerFloorData4222;
                                index$iv = index$iv2;
                                $this$forEachIndexed$iv = $this$forEachIndexed$iv2;
                                z7 = z;
                                $changed$iv$iv$iv4 = $changed$iv$iv$iv;
                                materialized$iv$iv4 = materialized$iv$iv;
                                localMap$iv$iv4 = localMap$iv$iv;
                                z6 = z4;
                                isLight = isLight2222;
                                pageViewModel3 = pageViewModel4222;
                                isUserTriggeredWishAction$delegate = isUserTriggeredWishAction$delegate2222;
                            }
                        }
                        text = item.getDesc();
                        if (text == null) {
                            text = "";
                        }
                        type = item.getType();
                        if (type != null) {
                        }
                        z2 = false;
                        type2 = item.getType();
                        if (type2 == null) {
                        }
                        z3 = false;
                        type3 = item.getType();
                        if (type3 != null) {
                        }
                        z5 = false;
                        iconUrl$product_details_page_debug = item.getIconUrl$product_details_page_debug(isLight, iconActive, z5);
                        if (iconUrl$product_details_page_debug == null) {
                        }
                        boolean isLight22222 = isLight;
                        State isUserTriggeredWishAction$delegate22222 = isUserTriggeredWishAction$delegate;
                        Modifier modifier62222 = SizeKt.height-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(42, BottomContainer$lambda$0(scaleModel$delegate).getScale()));
                        String str22222 = "mall_detail_footer_" + item.getType() + "_" + iconActive + "_" + text;
                        String str32222 = str;
                        ComposerKt.sourceInformationMarkerStart($composer3, -1524398946, str32222);
                        final PageViewModel pageViewModel42222 = pageViewModel3;
                        invalid$iv = $composer3.changed(item) | $composer3.changedInstance(pageViewModel42222) | $composer3.changed(iconActive);
                        FooterFloor footerFloorData42222 = footerFloorData3;
                        it$iv = $composer3.rememberedValue();
                        if (invalid$iv) {
                        }
                        Object obj2222 = new Function0() { // from class: kntr.app.mall.product.details.page.ui.container.BottomContainerKt$$ExternalSyntheticLambda6
                            public final Object invoke() {
                                Unit BottomContainer$lambda$8$0$0$0$0$0;
                                BottomContainer$lambda$8$0$0$0$0$0 = BottomContainerKt.BottomContainer$lambda$8$0$0$0$0$0(ActionIconModel.this, pageViewModel42222, iconActive);
                                return BottomContainer$lambda$8$0$0$0$0$0;
                            }
                        };
                        $composer3.updateRememberedValue(obj2222);
                        value$iv = obj2222;
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        Modifier reportOnExposure222222 = ExposerKt.reportOnExposure(modifier62222, str22222, collectorHolder, null, false, 0.5f, 0, 500L, (Function0) value$iv, $composer3, 12779520, 44);
                        String iconOutlineColor222222 = item.getIconOutlineColor();
                        float scale222222 = BottomContainer$lambda$0(scaleModel$delegate).getScale();
                        ComposerKt.sourceInformationMarkerStart($composer3, -1524465681, str32222);
                        invalid$iv2 = $composer3.changedInstance(pageViewModel42222) | $composer3.changed(item) | $composer3.changed(iconActive);
                        str = str32222;
                        Object it$iv3222222 = $composer3.rememberedValue();
                        if (invalid$iv2) {
                        }
                        Object value$iv3222222 = new Function0() { // from class: kntr.app.mall.product.details.page.ui.container.BottomContainerKt$$ExternalSyntheticLambda7
                            public final Object invoke() {
                                Unit BottomContainer$lambda$8$0$0$0$1$0;
                                BottomContainer$lambda$8$0$0$0$1$0 = BottomContainerKt.BottomContainer$lambda$8$0$0$0$1$0(PageViewModel.this, item, iconActive);
                                return BottomContainer$lambda$8$0$0$0$1$0;
                            }
                        };
                        $composer3.updateRememberedValue(value$iv3222222);
                        it$iv3222222 = value$iv3222222;
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        IconTextButton(iconUrl$product_details_page_debug, text, z3, scale222222, reportOnExposure222222, (Function0) it$iv3222222, z2, iconOutlineColor222222, $composer3, 0, 0);
                        wishInfo$delegate2 = wishInfo$delegate;
                        footerFloorData3 = footerFloorData42222;
                        index$iv = index$iv2;
                        $this$forEachIndexed$iv = $this$forEachIndexed$iv2;
                        z7 = z;
                        $changed$iv$iv$iv4 = $changed$iv$iv$iv;
                        materialized$iv$iv4 = materialized$iv$iv;
                        localMap$iv$iv4 = localMap$iv$iv;
                        z6 = z4;
                        isLight = isLight22222;
                        pageViewModel3 = pageViewModel42222;
                        isUserTriggeredWishAction$delegate = isUserTriggeredWishAction$delegate22222;
                    }
                    pageViewModel = pageViewModel3;
                    footerFloorData = footerFloorData3;
                    $composer3.endReplaceGroup();
                    Unit unit = Unit.INSTANCE;
                }
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                Modifier weight$default = RowScope.-CC.weight$default($this$BottomContainer_u24lambda_u248_u240, PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxHeight$default(Modifier.Companion, 0.0f, 1, (Object) null), ProvideUiScaleKt.dpScaled(12, BottomContainer$lambda$0(scaleModel$delegate).getScale()), 0.0f, 0.0f, 0.0f, 14, (Object) null), 1.0f, false, 2, (Object) null);
                FooterFloor.PurchaseButton purchaseButton = footerFloorData.getPurchaseButton();
                FooterFloor.AddCartButton addCartButton = footerFloorData.getAddCartButton();
                FooterFloor.PurchaseButton purchaseButton2 = footerFloorData.getPurchaseButton();
                boolean booleanValue = (purchaseButton2 == null || (mergeCartBuyButton = purchaseButton2.getMergeCartBuyButton()) == null) ? false : mergeCartBuyButton.booleanValue();
                FooterFloor.PurchaseButton purchaseButton3 = footerFloorData.getPurchaseButton();
                Integer mergeCartBuyButtonType = purchaseButton3 != null ? purchaseButton3.getMergeCartBuyButtonType() : null;
                PageViewModelWrapper wrapper$product_details_page_debug = pageViewModel.getWrapper$product_details_page_debug();
                String str4 = str;
                ComposerKt.sourceInformationMarkerStart($composer3, -1884494813, str4);
                final FooterFloor footerFloorData5 = footerFloorData;
                boolean invalid$iv3 = $composer3.changedInstance(footerFloorData5) | $composer3.changedInstance(pageViewModel);
                Object it$iv4 = $composer3.rememberedValue();
                if (invalid$iv3 || it$iv4 == Composer.Companion.getEmpty()) {
                    Object value$iv4 = new Function0() { // from class: kntr.app.mall.product.details.page.ui.container.BottomContainerKt$$ExternalSyntheticLambda8
                        public final Object invoke() {
                            Unit BottomContainer$lambda$8$0$1$0;
                            BottomContainer$lambda$8$0$1$0 = BottomContainerKt.BottomContainer$lambda$8$0$1$0(FooterFloor.this, pageViewModel);
                            return BottomContainer$lambda$8$0$1$0;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv4);
                    it$iv4 = value$iv4;
                }
                Function0 function0 = (Function0) it$iv4;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerStart($composer3, -1884486744, str4);
                boolean invalid$iv4 = $composer3.changedInstance(footerFloorData5) | $composer3.changedInstance(pageViewModel);
                Object it$iv5 = $composer3.rememberedValue();
                if (invalid$iv4 || it$iv5 == Composer.Companion.getEmpty()) {
                    Object value$iv5 = new Function0() { // from class: kntr.app.mall.product.details.page.ui.container.BottomContainerKt$$ExternalSyntheticLambda9
                        public final Object invoke() {
                            Unit BottomContainer$lambda$8$0$2$0;
                            BottomContainer$lambda$8$0$2$0 = BottomContainerKt.BottomContainer$lambda$8$0$2$0(FooterFloor.this, pageViewModel);
                            return BottomContainer$lambda$8$0$2$0;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv5);
                    it$iv5 = value$iv5;
                }
                ComposerKt.sourceInformationMarkerEnd($composer3);
                PurchaseButtonComponent(wrapper$product_details_page_debug, weight$default, purchaseButton, addCartButton, function0, (Function0) it$iv5, booleanValue, mergeCartBuyButtonType, true, $composer3, 100663296, 0);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                boolean BottomContainer$lambda$3 = BottomContainer$lambda$3(showSheet$delegate2);
                PaddingValues paddingValues = PaddingKt.PaddingValues-a9UjIt4(ProvideUiScaleKt.dpScaled(16, BottomContainer$lambda$0(scaleModel$delegate).getScale()), ProvideUiScaleKt.dpScaled(24, BottomContainer$lambda$0(scaleModel$delegate).getScale()), ProvideUiScaleKt.dpScaled(16, BottomContainer$lambda$0(scaleModel$delegate).getScale()), ProvideUiScaleKt.dpScaled(16, BottomContainer$lambda$0(scaleModel$delegate).getScale()));
                Shape shape = RoundedCornerShapeKt.RoundedCornerShape-a9UjIt4$default(ProvideUiScaleKt.dpScaled(12, BottomContainer$lambda$0(scaleModel$delegate).getScale()), ProvideUiScaleKt.dpScaled(12, BottomContainer$lambda$0(scaleModel$delegate).getScale()), 0.0f, 0.0f, 12, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer3, -992422651, str4);
                Object it$iv6 = $composer3.rememberedValue();
                if (it$iv6 == Composer.Companion.getEmpty()) {
                    showSheet$delegate = showSheet$delegate2;
                    Object value$iv6 = new Function0() { // from class: kntr.app.mall.product.details.page.ui.container.BottomContainerKt$$ExternalSyntheticLambda11
                        public final Object invoke() {
                            Unit BottomContainer$lambda$8$1$0;
                            BottomContainer$lambda$8$1$0 = BottomContainerKt.BottomContainer$lambda$8$1$0(showSheet$delegate);
                            return BottomContainer$lambda$8$1$0;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv6);
                    it$iv6 = value$iv6;
                } else {
                    showSheet$delegate = showSheet$delegate2;
                }
                ComposerKt.sourceInformationMarkerEnd($composer3);
                BottomSheetKt.m415BottomSheetfWhpE4E((Function0) it$iv6, BottomContainer$lambda$3, paddingValues, 0L, shape, ComposableLambdaKt.rememberComposableLambda(1101117212, true, new Function3() { // from class: kntr.app.mall.product.details.page.ui.container.BottomContainerKt$$ExternalSyntheticLambda12
                    public final Object invoke(Object obj3, Object obj4, Object obj5) {
                        Unit BottomContainer$lambda$8$2;
                        BottomContainer$lambda$8$2 = BottomContainerKt.BottomContainer$lambda$8$2(scaleModel$delegate, showSheet$delegate, (ColumnScope) obj3, (Composer) obj4, ((Integer) obj5).intValue());
                        return BottomContainer$lambda$8$2;
                    }
                }, $composer3, 54), $composer3, 196614, 8);
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
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup = $composer3.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.container.BottomContainerKt$$ExternalSyntheticLambda4
                        public final Object invoke(Object obj3, Object obj4) {
                            Unit BottomContainer$lambda$5;
                            BottomContainer$lambda$5 = BottomContainerKt.BottomContainer$lambda$5(PageViewModelWrapper.this, modifier3, $changed, i, (Composer) obj3, ((Integer) obj4).intValue());
                            return BottomContainer$lambda$5;
                        }
                    });
                    return;
                }
                return;
            }
        }
        ScopeUpdateScope endRestartGroup2 = $composer2.endRestartGroup();
        if (endRestartGroup2 != null) {
            endRestartGroup2.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.container.BottomContainerKt$$ExternalSyntheticLambda5
                public final Object invoke(Object obj3, Object obj4) {
                    Unit BottomContainer$lambda$9;
                    BottomContainer$lambda$9 = BottomContainerKt.BottomContainer$lambda$9(PageViewModelWrapper.this, modifier2, $changed, i, (Composer) obj3, ((Integer) obj4).intValue());
                    return BottomContainer$lambda$9;
                }
            });
        }
    }

    private static final UiScaleModel BottomContainer$lambda$0(State<UiScaleModel> state) {
        Object thisObj$iv = state.getValue();
        return (UiScaleModel) thisObj$iv;
    }

    private static final BottomContainerState BottomContainer$lambda$1(State<BottomContainerState> state) {
        Object thisObj$iv = state.getValue();
        return (BottomContainerState) thisObj$iv;
    }

    private static final boolean BottomContainer$lambda$3(MutableState<Boolean> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    private static final void BottomContainer$lambda$4(MutableState<Boolean> mutableState, boolean z) {
        Object value$iv = Boolean.valueOf(z);
        mutableState.setValue(value$iv);
    }

    private static final WishInfo BottomContainer$lambda$6(State<WishInfo> state) {
        Object thisObj$iv = state.getValue();
        return (WishInfo) thisObj$iv;
    }

    private static final boolean BottomContainer$lambda$7(State<Boolean> state) {
        Object thisObj$iv = state.getValue();
        return ((Boolean) thisObj$iv).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BottomContainer$lambda$8$0$0$0$1$0(PageViewModel $pageViewModel, ActionIconModel $item, Boolean $iconActive) {
        String str;
        $pageViewModel.handleFooterButtonClick$product_details_page_debug($item);
        Integer type = $item.getType();
        if (type != null && type.intValue() == 6) {
            PageActionHandler actionHandler$product_details_page_debug = $pageViewModel.getActionHandler$product_details_page_debug();
            if (Intrinsics.areEqual($iconActive, true)) {
                str = TrackConsts.MALL_MALL_DETAIL_WANT_CANCEL_CLICK;
            } else {
                str = TrackConsts.MALL_MALL_DETAIL_WANT_NEW_CLICK;
            }
            PageActionHandler.trackEvent$product_details_page_debug$default(actionHandler$product_details_page_debug, str, null, true, false, 10, null);
        } else if (type != null && type.intValue() == 5) {
            PageActionHandler.trackEvent$product_details_page_debug$default($pageViewModel.getActionHandler$product_details_page_debug(), TrackConsts.MALL_MALL_DETAIL_CUSTOMER_SERVICE_0_CLICK, null, true, false, 10, null);
        } else if (type != null && type.intValue() == 4) {
            PageActionHandler.trackEvent$product_details_page_debug$default($pageViewModel.getActionHandler$product_details_page_debug(), TrackConsts.MALL_MALL_DETAIL_SHOP_0_CLICK, null, true, false, 10, null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BottomContainer$lambda$8$0$0$0$0$0(ActionIconModel $item, PageViewModel $pageViewModel, Boolean $iconActive) {
        String str;
        Integer type = $item.getType();
        if (type != null && type.intValue() == 6) {
            PageActionHandler actionHandler$product_details_page_debug = $pageViewModel.getActionHandler$product_details_page_debug();
            if (Intrinsics.areEqual($iconActive, true)) {
                str = TrackConsts.MALL_MALL_DETAIL_WANT_NEW_SHOW;
            } else {
                str = TrackConsts.MALL_MALL_DETAIL_WANT_CANCEL_SHOW;
            }
            PageActionHandler.trackEvent$product_details_page_debug$default(actionHandler$product_details_page_debug, str, null, false, false, 10, null);
        } else if (type != null && type.intValue() == 5) {
            PageActionHandler.trackEvent$product_details_page_debug$default($pageViewModel.getActionHandler$product_details_page_debug(), TrackConsts.MALL_MALL_DETAIL_CUSTOMER_SERVICE_0_SHOW, null, false, false, 10, null);
        } else if (type != null && type.intValue() == 4) {
            PageActionHandler.trackEvent$product_details_page_debug$default($pageViewModel.getActionHandler$product_details_page_debug(), TrackConsts.MALL_MALL_DETAIL_SHOP_0_SHOW, null, false, false, 10, null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BottomContainer$lambda$8$0$1$0(FooterFloor $footerFloorData, PageViewModel $pageViewModel) {
        FooterFloor.PurchaseButton purchaseButton = $footerFloorData.getPurchaseButton();
        if (purchaseButton == null) {
            return Unit.INSTANCE;
        }
        $pageViewModel.handleAddButton$product_details_page_debug(purchaseButton);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BottomContainer$lambda$8$0$2$0(FooterFloor $footerFloorData, PageViewModel $pageViewModel) {
        FooterFloor.PurchaseButton purchaseButton = $footerFloorData.getPurchaseButton();
        if (purchaseButton == null) {
            return Unit.INSTANCE;
        }
        $pageViewModel.handlePurchaseButton$product_details_page_debug(purchaseButton);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BottomContainer$lambda$8$1$0(MutableState $showSheet$delegate) {
        BottomContainer$lambda$4($showSheet$delegate, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BottomContainer$lambda$8$2(State $scaleModel$delegate, final MutableState $showSheet$delegate, ColumnScope $this$BottomSheet, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$BottomSheet, "$this$BottomSheet");
        ComposerKt.sourceInformation($composer, "C253@11972L10,253@11932L61,254@12006L53,255@12089L21,255@12072L82:BottomContainer.kt#u9475x");
        if ($composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1101117212, $changed, -1, "kntr.app.mall.product.details.page.ui.container.BottomContainer.<anonymous>.<anonymous> (BottomContainer.kt:253)");
            }
            TextKt.Text-Nvy7gAk("这是底部弹出的浮层", (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getBodyLarge(), $composer, 6, 0, 131070);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(8, BottomContainer$lambda$0($scaleModel$delegate).getScale())), $composer, 0);
            ComposerKt.sourceInformationMarkerStart($composer, 1611691409, "CC(remember):BottomContainer.kt#9igjgp");
            Object it$iv = $composer.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function0() { // from class: kntr.app.mall.product.details.page.ui.container.BottomContainerKt$$ExternalSyntheticLambda13
                    public final Object invoke() {
                        Unit BottomContainer$lambda$8$2$0$0;
                        BottomContainer$lambda$8$2$0$0 = BottomContainerKt.BottomContainer$lambda$8$2$0$0($showSheet$delegate);
                        return BottomContainer$lambda$8$2$0$0;
                    }
                };
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            ButtonKt.Button((Function0) it$iv, (Modifier) null, false, (Shape) null, (ButtonColors) null, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableSingletons$BottomContainerKt.INSTANCE.m572getLambda$1613668596$product_details_page_debug(), $composer, 805306374, 510);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BottomContainer$lambda$8$2$0$0(MutableState $showSheet$delegate) {
        BottomContainer$lambda$4($showSheet$delegate, false);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:211:0x04e1, code lost:
        if (r6 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L122;
     */
    /* JADX WARN: Code restructure failed: missing block: B:219:0x0530, code lost:
        if (r10 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L127;
     */
    /* JADX WARN: Code restructure failed: missing block: B:325:0x0bcf, code lost:
        if (r15 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L433;
     */
    /* JADX WARN: Code restructure failed: missing block: B:577:0x1efc, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual(r2.getShowCountDown(), true) != false) goto L303;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:324:0x0bc7  */
    /* JADX WARN: Removed duplicated region for block: B:328:0x0bd3  */
    /* JADX WARN: Removed duplicated region for block: B:332:0x0c7e  */
    /* JADX WARN: Removed duplicated region for block: B:335:0x0c8a  */
    /* JADX WARN: Removed duplicated region for block: B:336:0x0c90  */
    /* JADX WARN: Removed duplicated region for block: B:339:0x0d0d  */
    /* JADX WARN: Removed duplicated region for block: B:357:0x0eac  */
    /* JADX WARN: Removed duplicated region for block: B:361:0x0ec0  */
    /* JADX WARN: Removed duplicated region for block: B:365:0x0ed1  */
    /* JADX WARN: Removed duplicated region for block: B:366:0x0ed4  */
    /* JADX WARN: Removed duplicated region for block: B:368:0x0ed8  */
    /* JADX WARN: Removed duplicated region for block: B:525:0x1929  */
    /* JADX WARN: Removed duplicated region for block: B:528:0x1935  */
    /* JADX WARN: Removed duplicated region for block: B:529:0x193b  */
    /* JADX WARN: Removed duplicated region for block: B:532:0x19bc  */
    /* JADX WARN: Removed duplicated region for block: B:535:0x1a5b  */
    /* JADX WARN: Removed duplicated region for block: B:538:0x1a67  */
    /* JADX WARN: Removed duplicated region for block: B:539:0x1a6d  */
    /* JADX WARN: Removed duplicated region for block: B:542:0x1aeb  */
    /* JADX WARN: Removed duplicated region for block: B:543:0x1b46  */
    /* JADX WARN: Removed duplicated region for block: B:546:0x1bd8  */
    /* JADX WARN: Removed duplicated region for block: B:573:0x1ec7  */
    /* JADX WARN: Removed duplicated region for block: B:576:0x1eef  */
    /* JADX WARN: Removed duplicated region for block: B:582:0x1f03  */
    /* JADX WARN: Removed duplicated region for block: B:583:0x1f08  */
    /* JADX WARN: Removed duplicated region for block: B:593:0x1f3f  */
    /* JADX WARN: Removed duplicated region for block: B:609:0x2258  */
    /* JADX WARN: Removed duplicated region for block: B:626:0x2397  */
    /* JADX WARN: Type inference failed for: r6v113 */
    /* JADX WARN: Type inference failed for: r8v184 */
    /* JADX WARN: Type inference failed for: r8v187 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void PurchaseButtonComponent(final PageViewModelWrapper pageViewModelWrapper, Modifier modifier, FooterFloor.PurchaseButton data, FooterFloor.AddCartButton addCartData, Function0<Unit> function0, Function0<Unit> function02, boolean mergeCartBuyButton, Integer mergeCartBuyButtonType, boolean showSkinCover, Composer $composer, final int $changed, final int i) {
        FooterFloor.AddCartButton addCartButton;
        final Function0 onAddButton;
        Composer $composer2;
        Modifier modifier2;
        FooterFloor.PurchaseButton data2;
        Function0 onPurchaseButton;
        boolean mergeCartBuyButton2;
        Integer mergeCartBuyButtonType2;
        boolean showSkinCover2;
        FooterFloor.AddCartButton addCartData2;
        Function0 onAddButton2;
        Function0 onPurchaseButton2;
        Function0 factory$iv$iv$iv;
        String buttonColorString;
        CollectorHolder collectorHolder;
        Composer $composer$iv;
        Composer $composer$iv$iv$iv;
        Function0 onAddButton3;
        PageViewModel pageViewModel;
        Integer buttonState;
        Function0 factory$iv$iv$iv2;
        Composer $composer$iv2;
        String str;
        String str2;
        Composer $composer$iv$iv;
        Composer $composer$iv3;
        final PageViewModel pageViewModel2;
        Composer $composer$iv$iv$iv2;
        Modifier modifier3;
        final Function0 onPurchaseButton3;
        Function0 factory$iv$iv$iv3;
        String str3;
        Function0 factory$iv$iv$iv4;
        String buttonText;
        PriceDescVO buttonPriceDescVO;
        Function0 factory$iv$iv$iv5;
        boolean showCountDown;
        boolean invalid$iv;
        Object it$iv;
        Function0 factory$iv$iv$iv6;
        String str4;
        String str5;
        List shadingImgs;
        PageViewModel pageViewModel3;
        final Function0 onAddButton4;
        Modifier backgroundModifier;
        final Function0 onAddButton5;
        boolean invalid$iv2;
        Function0 factory$iv$iv$iv7;
        String str6;
        String it;
        Modifier backgroundModifier2;
        Function0 factory$iv$iv$iv8;
        Modifier modifier4;
        Function0 factory$iv$iv$iv9;
        Intrinsics.checkNotNullParameter(pageViewModelWrapper, "pageViewModelWrapper");
        Composer $composer3 = $composer.startRestartGroup(48411);
        ComposerKt.sourceInformation($composer3, "C(PurchaseButtonComponent)N(pageViewModelWrapper,modifier,data,addCartData,onAddButton,onPurchaseButton,mergeCartBuyButton,mergeCartBuyButtonType,showSkinCover)269@12443L2,270@12482L2,276@12731L16,282@12881L22,287@13049L25,288@13079L29361:BottomContainer.kt#u9475x");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changedInstance(pageViewModelWrapper) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
        } else if (($changed & 48) == 0) {
            $dirty |= $composer3.changed(modifier) ? 32 : 16;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty |= 384;
        } else if (($changed & 384) == 0) {
            $dirty |= $composer3.changedInstance(data) ? 256 : 128;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty |= 3072;
            addCartButton = addCartData;
        } else if (($changed & 3072) == 0) {
            addCartButton = addCartData;
            $dirty |= $composer3.changedInstance(addCartButton) ? 2048 : 1024;
        } else {
            addCartButton = addCartData;
        }
        int i5 = i & 16;
        if (i5 != 0) {
            $dirty |= 24576;
            onAddButton = function0;
        } else if (($changed & 24576) == 0) {
            onAddButton = function0;
            $dirty |= $composer3.changedInstance(onAddButton) ? 16384 : 8192;
        } else {
            onAddButton = function0;
        }
        int i6 = i & 32;
        if (i6 != 0) {
            $dirty |= 196608;
        } else if (($changed & 196608) == 0) {
            $dirty |= $composer3.changedInstance(function02) ? 131072 : 65536;
        }
        int i7 = i & 64;
        if (i7 != 0) {
            $dirty |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty |= $composer3.changed(mergeCartBuyButton) ? 1048576 : 524288;
        }
        int i8 = i & 128;
        if (i8 != 0) {
            $dirty |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty |= $composer3.changed(mergeCartBuyButtonType) ? 8388608 : 4194304;
        }
        int i9 = i & 256;
        if (i9 != 0) {
            $dirty |= 100663296;
        } else if (($changed & 100663296) == 0) {
            $dirty |= $composer3.changed(showSkinCover) ? 67108864 : 33554432;
        }
        if ($composer3.shouldExecute(($dirty & 38347923) != 38347922, $dirty & 1)) {
            modifier2 = i2 != 0 ? (Modifier) Modifier.Companion : modifier;
            data2 = i3 != 0 ? null : data;
            addCartData2 = i4 != 0 ? null : addCartButton;
            if (i5 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer3, 46530653, "CC(remember):BottomContainer.kt#9igjgp");
                Object it$iv2 = $composer3.rememberedValue();
                if (it$iv2 == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function0() { // from class: kntr.app.mall.product.details.page.ui.container.BottomContainerKt$$ExternalSyntheticLambda10
                        public final Object invoke() {
                            Unit unit;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv);
                    it$iv2 = value$iv;
                }
                Function0 onAddButton6 = it$iv2;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                onAddButton = onAddButton6;
            }
            if (i6 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer3, 46531901, "CC(remember):BottomContainer.kt#9igjgp");
                Object it$iv3 = $composer3.rememberedValue();
                if (it$iv3 == Composer.Companion.getEmpty()) {
                    Object value$iv2 = new Function0() { // from class: kntr.app.mall.product.details.page.ui.container.BottomContainerKt$$ExternalSyntheticLambda21
                        public final Object invoke() {
                            Unit unit;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv2);
                    it$iv3 = value$iv2;
                }
                ComposerKt.sourceInformationMarkerEnd($composer3);
                onPurchaseButton2 = it$iv3;
            } else {
                onPurchaseButton2 = function02;
            }
            mergeCartBuyButton2 = i7 != 0 ? false : mergeCartBuyButton;
            mergeCartBuyButtonType2 = i8 != 0 ? null : mergeCartBuyButtonType;
            showSkinCover2 = i9 != 0 ? false : showSkinCover;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(48411, $dirty, -1, "kntr.app.mall.product.details.page.ui.container.PurchaseButtonComponent (BottomContainer.kt:274)");
            }
            final PageViewModel pageViewModel4 = pageViewModelWrapper.getViewModel();
            State scaleModel$delegate = SnapshotStateKt.collectAsState(pageViewModel4.getUiScaleModelFlow$product_details_page_debug(), (CoroutineContext) null, $composer3, 0, 1);
            if (data2 == null) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup = $composer3.endRestartGroup();
                if (endRestartGroup != null) {
                    final Modifier modifier5 = modifier2;
                    final FooterFloor.PurchaseButton purchaseButton = data2;
                    final FooterFloor.AddCartButton addCartButton2 = addCartData2;
                    final Function0 function03 = onAddButton;
                    final Function0<Unit> function04 = onPurchaseButton2;
                    final boolean z = mergeCartBuyButton2;
                    final Integer num = mergeCartBuyButtonType2;
                    final boolean z2 = showSkinCover2;
                    endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.container.BottomContainerKt$$ExternalSyntheticLambda23
                        public final Object invoke(Object obj, Object obj2) {
                            Unit PurchaseButtonComponent$lambda$3;
                            PurchaseButtonComponent$lambda$3 = BottomContainerKt.PurchaseButtonComponent$lambda$3(PageViewModelWrapper.this, modifier5, purchaseButton, addCartButton2, function03, function04, z, num, z2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                            return PurchaseButtonComponent$lambda$3;
                        }
                    });
                    return;
                }
                return;
            }
            int $dirty2 = $dirty;
            Function0 onPurchaseButton4 = onPurchaseButton2;
            Boolean showAddCart = data2.getShowAddCart();
            boolean showAddCart2 = showAddCart != null ? showAddCart.booleanValue() : false;
            String buttonColorString2 = Intrinsics.areEqual(ThemesKt.currentDayNightTheme($composer3, 0), DayNightTheme.Light.INSTANCE) ? data2.getButtonDayColor() : data2.getButtonNightColor();
            CollectorHolder collectorHolder2 = ExposerKt.rememberCollectorHolder($composer3, 0);
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            int $changed$iv = (($dirty2 >> 3) & 14) | 384;
            Modifier modifier$iv = modifier2;
            ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, (($changed$iv >> 3) & 14) | (($changed$iv >> 3) & 112));
            int $changed$iv$iv = ($changed$iv << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0 factory$iv$iv$iv10 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            $composer2 = $composer3;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv10;
                $composer3.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv10;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i10 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i11 = (($changed$iv >> 6) & 112) | 6;
            RowScope $this$PurchaseButtonComponent_u24lambda_u244 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, -298744381, "C396@17749L24685:BottomContainer.kt#u9475x");
            if (!showAddCart2 || mergeCartBuyButton2) {
                buttonColorString = buttonColorString2;
                collectorHolder = collectorHolder2;
                $composer$iv = $composer3;
                $composer$iv$iv$iv = $composer3;
                onAddButton3 = onAddButton;
                pageViewModel = pageViewModel4;
                $composer3.startReplaceGroup(-312731613);
            } else {
                $composer3.startReplaceGroup(-299471456);
                ComposerKt.sourceInformation($composer3, "330@14649L76,337@15003L258,332@14726L535,323@14350L3303,394@17667L63");
                List<String> bgColors = addCartData2 != null ? addCartData2.getBgColors() : null;
                String fontColor = addCartData2 != null ? addCartData2.getFontColor() : null;
                List shadingImgs2 = addCartData2 != null ? addCartData2.getShadingImgs() : null;
                List list = bgColors;
                if (list == null || list.isEmpty()) {
                    modifier4 = BackgroundKt.background-bw27NRU$default(Modifier.Companion, ColorKt.Color(4294961138L), (Shape) null, 2, (Object) null);
                } else {
                    int compositeKeyHash$iv$iv2 = bgColors.size();
                    if (compositeKeyHash$iv$iv2 == 1) {
                        modifier4 = BackgroundKt.background-bw27NRU$default(Modifier.Companion, ComposeColorParserKt.parseColor(bgColors.get(0)), (Shape) null, 2, (Object) null);
                    } else {
                        Modifier modifier6 = Modifier.Companion;
                        Brush.Companion companion = Brush.Companion;
                        Iterable $this$map$iv = bgColors;
                        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                        for (Object item$iv$iv : $this$map$iv) {
                            destination$iv$iv.add(Color.box-impl(ComposeColorParserKt.parseColor((String) item$iv$iv)));
                            $this$map$iv = $this$map$iv;
                        }
                        modifier4 = BackgroundKt.background$default(modifier6, Brush.Companion.horizontalGradient-8A-3gB4$default(companion, (List) destination$iv$iv, 0.0f, 0.0f, 0, 14, (Object) null), (Shape) null, 0.0f, 6, (Object) null);
                    }
                }
                Modifier backgroundModifier3 = modifier4;
                String str7 = fontColor;
                long textColor = !(str7 == null || str7.length() == 0) ? ComposeColorParserKt.parseColor(fontColor) : ColorKt.Color(4294928025L);
                Modifier then = ClipKt.clip(RowScope.-CC.weight$default($this$PurchaseButtonComponent_u24lambda_u244, SizeKt.height-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(42, PurchaseButtonComponent$lambda$2(scaleModel$delegate).getScale())), 1.0f, false, 2, (Object) null), RoundedCornerShapeKt.RoundedCornerShape(50)).then(backgroundModifier3);
                ComposerKt.sourceInformationMarkerStart($composer3, -425261237, "CC(remember):BottomContainer.kt#9igjgp");
                boolean invalid$iv3 = ($dirty2 & 57344) == 16384;
                Object value$iv3 = $composer3.rememberedValue();
                if (invalid$iv3) {
                }
                value$iv3 = new Function0() { // from class: kntr.app.mall.product.details.page.ui.container.BottomContainerKt$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        Unit PurchaseButtonComponent$lambda$4$1$0;
                        PurchaseButtonComponent$lambda$4$1$0 = BottomContainerKt.PurchaseButtonComponent$lambda$4$1$0(onAddButton);
                        return PurchaseButtonComponent$lambda$4$1$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                Modifier modifier7 = ClickableKt.clickable-oSLSa3U$default(then, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) value$iv3, 15, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer3, -425249727, "CC(remember):BottomContainer.kt#9igjgp");
                boolean invalid$iv4 = $composer3.changedInstance(pageViewModel4);
                Object it$iv4 = $composer3.rememberedValue();
                if (invalid$iv4) {
                }
                Object value$iv4 = new Function0() { // from class: kntr.app.mall.product.details.page.ui.container.BottomContainerKt$$ExternalSyntheticLambda1
                    public final Object invoke() {
                        Unit PurchaseButtonComponent$lambda$4$2$0;
                        PurchaseButtonComponent$lambda$4$2$0 = BottomContainerKt.PurchaseButtonComponent$lambda$4$2$0(PageViewModel.this);
                        return PurchaseButtonComponent$lambda$4$2$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv4);
                it$iv4 = value$iv4;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                Modifier modifier$iv2 = ExposerKt.reportOnExposure(modifier7, "mall_detail_add_cart_button", collectorHolder2, null, false, 0.5f, 0, 500L, (Function0) it$iv4, $composer3, 12779568, 44);
                Alignment contentAlignment$iv = Alignment.Companion.getCenter();
                $composer$iv$iv$iv = $composer3;
                ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                int $changed$iv$iv2 = (48 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
                CompositionLocalMap localMap$iv$iv2 = $composer3.getCurrentCompositionLocalMap();
                $composer$iv = $composer3;
                Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer3, modifier$iv2);
                Function0 factory$iv$iv$iv11 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                buttonColorString = buttonColorString2;
                collectorHolder = collectorHolder2;
                ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer3.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer3.startReusableNode();
                if ($composer3.getInserting()) {
                    factory$iv$iv$iv9 = factory$iv$iv$iv11;
                    $composer3.createNode(factory$iv$iv$iv9);
                } else {
                    factory$iv$iv$iv9 = factory$iv$iv$iv11;
                    $composer3.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer3);
                pageViewModel = pageViewModel4;
                onAddButton3 = onAddButton;
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
                int i12 = ($changed$iv$iv$iv2 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                int i13 = ((48 >> 6) & 112) | 6;
                BoxScope $this$PurchaseButtonComponent_u24lambda_u244_u243 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer3, 2002527440, "C390@17582L9,387@17464L175:BottomContainer.kt#u9475x");
                if (showSkinCover2) {
                    List list2 = shadingImgs2;
                    if (!(list2 == null || list2.isEmpty())) {
                        $composer3.startReplaceGroup(2002570467);
                        ComposerKt.sourceInformation($composer3, "");
                        if (shadingImgs2.size() >= 2) {
                            $composer3.startReplaceGroup(2002595453);
                            ComposerKt.sourceInformation($composer3, "348@15523L558,360@16155L556");
                            String $this$asRequest$iv = HelperKt.customizedImageUrl(shadingImgs2.get(0));
                            ImageRequest $this$PurchaseButtonComponent_u24lambda_u244_u243_u240 = new ImageRequest($this$asRequest$iv);
                            $this$PurchaseButtonComponent_u24lambda_u244_u243_u240.contentScale(ContentScale.Companion.getFillBounds());
                            BiliImageKt.BiliImage($this$PurchaseButtonComponent_u24lambda_u244_u243_u240.build(), SizeKt.height-3ABfNKs(SizeKt.width-3ABfNKs($this$PurchaseButtonComponent_u24lambda_u244_u243.align(Modifier.Companion, Alignment.Companion.getCenterStart()), ProvideUiScaleKt.dpScaled(36, PurchaseButtonComponent$lambda$2(scaleModel$delegate).getScale())), ProvideUiScaleKt.dpScaled(42, PurchaseButtonComponent$lambda$2(scaleModel$delegate).getScale())), null, null, null, null, null, null, null, $composer3, 0, 508);
                            String $this$asRequest$iv2 = HelperKt.customizedImageUrl(shadingImgs2.get(1));
                            ImageRequest $this$PurchaseButtonComponent_u24lambda_u244_u243_u241 = new ImageRequest($this$asRequest$iv2);
                            $this$PurchaseButtonComponent_u24lambda_u244_u243_u241.contentScale(ContentScale.Companion.getFillBounds());
                            BiliImageKt.BiliImage($this$PurchaseButtonComponent_u24lambda_u244_u243_u241.build(), SizeKt.height-3ABfNKs(SizeKt.width-3ABfNKs($this$PurchaseButtonComponent_u24lambda_u244_u243.align(Modifier.Companion, Alignment.Companion.getCenterEnd()), ProvideUiScaleKt.dpScaled(36, PurchaseButtonComponent$lambda$2(scaleModel$delegate).getScale())), ProvideUiScaleKt.dpScaled(42, PurchaseButtonComponent$lambda$2(scaleModel$delegate).getScale())), null, null, null, null, null, null, null, $composer3, 0, 508);
                            $composer3.endReplaceGroup();
                        } else {
                            if (shadingImgs2.size() == 1) {
                                $composer3.startReplaceGroup(2003883596);
                                ComposerKt.sourceInformation($composer3, "373@16848L558");
                                String $this$asRequest$iv3 = HelperKt.customizedImageUrl(shadingImgs2.get(0));
                                ImageRequest $this$PurchaseButtonComponent_u24lambda_u244_u243_u242 = new ImageRequest($this$asRequest$iv3);
                                $this$PurchaseButtonComponent_u24lambda_u244_u243_u242.contentScale(ContentScale.Companion.getFillBounds());
                                BiliImageKt.BiliImage($this$PurchaseButtonComponent_u24lambda_u244_u243_u242.build(), SizeKt.height-3ABfNKs(SizeKt.width-3ABfNKs($this$PurchaseButtonComponent_u24lambda_u244_u243.align(Modifier.Companion, Alignment.Companion.getCenterStart()), ProvideUiScaleKt.dpScaled(36, PurchaseButtonComponent$lambda$2(scaleModel$delegate).getScale())), ProvideUiScaleKt.dpScaled(42, PurchaseButtonComponent$lambda$2(scaleModel$delegate).getScale())), null, null, null, null, null, null, null, $composer3, 0, 508);
                            } else {
                                $composer3.startReplaceGroup(1987230210);
                            }
                            $composer3.endReplaceGroup();
                        }
                        $composer3.endReplaceGroup();
                        TextKt.Text-Nvy7gAk("加购物车", (Modifier) null, textColor, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, ProvideUiScaleKt.scaled(BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT15(), PurchaseButtonComponent$lambda$2(scaleModel$delegate).getScale()), $composer3, 6, 0, 131066);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        $composer3.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(7, PurchaseButtonComponent$lambda$2(scaleModel$delegate).getScale())), $composer3, 0);
                    }
                }
                $composer3.startReplaceGroup(1987230210);
                $composer3.endReplaceGroup();
                TextKt.Text-Nvy7gAk("加购物车", (Modifier) null, textColor, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, ProvideUiScaleKt.scaled(BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT15(), PurchaseButtonComponent$lambda$2(scaleModel$delegate).getScale()), $composer3, 6, 0, 131066);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(7, PurchaseButtonComponent$lambda$2(scaleModel$delegate).getScale())), $composer3, 0);
            }
            $composer3.endReplaceGroup();
            Modifier clip = ClipKt.clip(RowScope.-CC.weight$default($this$PurchaseButtonComponent_u24lambda_u244, SizeKt.height-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(42, PurchaseButtonComponent$lambda$2(scaleModel$delegate).getScale())), 1.0f, false, 2, (Object) null), RoundedCornerShapeKt.RoundedCornerShape(50));
            Integer buttonState2 = data2.getButtonState();
            Modifier modifier$iv3 = AlphaKt.alpha(clip, ((buttonState2 != null && buttonState2.intValue() == 2) || ((buttonState = data2.getButtonState()) != null && buttonState.intValue() == 3)) ? 0.5f : 1.0f);
            Alignment.Vertical verticalAlignment$iv2 = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv3 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer3, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv3 = (384 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv4 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv3 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer3, modifier$iv3);
            Function0 factory$iv$iv$iv12 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv12;
                $composer3.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv12;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv4), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
            int i14 = ($changed$iv$iv$iv3 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i15 = ((384 >> 6) & 112) | 6;
            RowScope $this$PurchaseButtonComponent_u24lambda_u244_u244 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, 1572900147, "C647@30371L74,654@30723L257,649@30446L534,641@30118L12306:BottomContainer.kt#u9475x");
            if (showAddCart2 && mergeCartBuyButton2) {
                $composer3.startReplaceGroup(1572517296);
                ComposerKt.sourceInformation($composer3, "");
                List<String> bgColors2 = addCartData2 != null ? addCartData2.getBgColors() : null;
                String fontColor2 = addCartData2 != null ? addCartData2.getFontColor() : null;
                List shadingImgs3 = addCartData2 != null ? addCartData2.getShadingImgs() : null;
                if (mergeCartBuyButtonType2 == null) {
                    $composer$iv2 = $composer3;
                    str4 = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
                    str5 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
                    $composer$iv$iv = $composer3;
                    shadingImgs = shadingImgs3;
                    pageViewModel3 = pageViewModel;
                    onAddButton4 = onAddButton3;
                    $composer$iv3 = $composer3;
                    $composer$iv$iv$iv2 = $composer3;
                } else if (mergeCartBuyButtonType2.intValue() == 2) {
                    $composer3.startReplaceGroup(1572602794);
                    ComposerKt.sourceInformation($composer3, "436@19593L85,443@19996L298,438@19679L615,429@19224L4352");
                    List<String> list3 = bgColors2;
                    if (list3 == null || list3.isEmpty()) {
                        backgroundModifier = BackgroundKt.background-bw27NRU$default(Modifier.Companion, ColorKt.Color(4294962417L), (Shape) null, 2, (Object) null);
                    } else if (bgColors2.size() == 1) {
                        backgroundModifier = BackgroundKt.background-bw27NRU$default(Modifier.Companion, ComposeColorParserKt.parseColor(bgColors2.get(0)), (Shape) null, 2, (Object) null);
                    } else {
                        Modifier modifier8 = Modifier.Companion;
                        Brush.Companion companion2 = Brush.Companion;
                        Iterable $this$map$iv2 = bgColors2;
                        Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
                        for (Object item$iv$iv2 : $this$map$iv2) {
                            destination$iv$iv2.add(Color.box-impl(ComposeColorParserKt.parseColor((String) item$iv$iv2)));
                            $this$map$iv2 = $this$map$iv2;
                        }
                        backgroundModifier = BackgroundKt.background$default(modifier8, Brush.Companion.horizontalGradient-8A-3gB4$default(companion2, (List) destination$iv$iv2, 0.0f, 0.0f, 0, 14, (Object) null), (Shape) null, 0.0f, 6, (Object) null);
                    }
                    Modifier modifier9 = SizeKt.size-VpY3zN4(Modifier.Companion.then(backgroundModifier), ProvideUiScaleKt.dpScaled(56, PurchaseButtonComponent$lambda$2(scaleModel$delegate).getScale()), ProvideUiScaleKt.dpScaled(42, PurchaseButtonComponent$lambda$2(scaleModel$delegate).getScale()));
                    ComposerKt.sourceInformationMarkerStart($composer3, 1851876856, "CC(remember):BottomContainer.kt#9igjgp");
                    boolean invalid$iv5 = ($dirty2 & 57344) == 16384;
                    Object it$iv5 = $composer3.rememberedValue();
                    if (!invalid$iv5 && it$iv5 != Composer.Companion.getEmpty()) {
                        onAddButton5 = onAddButton3;
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        Modifier modifier10 = ClickableKt.clickable-oSLSa3U$default(modifier9, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv5, 15, (Object) null);
                        ComposerKt.sourceInformationMarkerStart($composer3, 1851889965, "CC(remember):BottomContainer.kt#9igjgp");
                        final PageViewModel pageViewModel5 = pageViewModel;
                        invalid$iv2 = $composer3.changedInstance(pageViewModel5);
                        Object it$iv6 = $composer3.rememberedValue();
                        if (invalid$iv2) {
                        }
                        Object value$iv5 = new Function0() { // from class: kntr.app.mall.product.details.page.ui.container.BottomContainerKt$$ExternalSyntheticLambda3
                            public final Object invoke() {
                                Unit PurchaseButtonComponent$lambda$4$4$2$0;
                                PurchaseButtonComponent$lambda$4$4$2$0 = BottomContainerKt.PurchaseButtonComponent$lambda$4$4$2$0(PageViewModel.this);
                                return PurchaseButtonComponent$lambda$4$4$2$0;
                            }
                        };
                        $composer3.updateRememberedValue(value$iv5);
                        it$iv6 = value$iv5;
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        Modifier modifier$iv4 = ExposerKt.reportOnExposure(modifier10, "mall_detail_add_cart_button", collectorHolder, null, false, 0.5f, 0, 500L, (Function0) it$iv6, $composer3, 12779568, 44);
                        Alignment contentAlignment$iv2 = Alignment.Companion.getCenter();
                        $composer$iv2 = $composer3;
                        $composer$iv$iv = $composer3;
                        ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicy$iv4 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
                        int $changed$iv$iv4 = (48 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv5 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
                        CompositionLocalMap localMap$iv$iv4 = $composer3.getCurrentCompositionLocalMap();
                        $composer$iv$iv$iv2 = $composer3;
                        Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer3, modifier$iv4);
                        Function0 factory$iv$iv$iv13 = ComposeUiNode.Companion.getConstructor();
                        int $changed$iv$iv$iv4 = (($changed$iv$iv4 << 6) & 896) | 6;
                        $composer$iv3 = $composer3;
                        str = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
                        ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                        if (!($composer3.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer3.startReusableNode();
                        if ($composer3.getInserting()) {
                            factory$iv$iv$iv7 = factory$iv$iv$iv13;
                            $composer3.useNode();
                        } else {
                            factory$iv$iv$iv7 = factory$iv$iv$iv13;
                            $composer3.createNode(factory$iv$iv$iv7);
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv4 = Updater.constructor-impl($composer3);
                        str2 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, measurePolicy$iv4, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, localMap$iv$iv4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Updater.init-impl($this$Layout_u24lambda_u240$iv$iv4, Integer.valueOf(compositeKeyHash$iv$iv5), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv4, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, materialized$iv$iv4, ComposeUiNode.Companion.getSetModifier());
                        int i16 = ($changed$iv$iv$iv4 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                        int i17 = ((48 >> 6) & 112) | 6;
                        BoxScope $this$PurchaseButtonComponent_u24lambda_u244_u244_u243 = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart($composer3, 488165281, "C499@23251L303:BottomContainer.kt#u9475x");
                        if (showSkinCover2) {
                            List list4 = shadingImgs3;
                            if (!(list4 == null || list4.isEmpty())) {
                                $composer3.startReplaceGroup(488193924);
                                ComposerKt.sourceInformation($composer3, "");
                                if (shadingImgs3.size() >= 2) {
                                    $composer3.startReplaceGroup(488223126);
                                    ComposerKt.sourceInformation($composer3, "455@20678L638,467@21406L636");
                                    String $this$asRequest$iv4 = HelperKt.customizedImageUrl(shadingImgs3.get(0));
                                    ImageRequest $this$PurchaseButtonComponent_u24lambda_u244_u244_u243_u240 = new ImageRequest($this$asRequest$iv4);
                                    $this$PurchaseButtonComponent_u24lambda_u244_u244_u243_u240.contentScale(ContentScale.Companion.getFillBounds());
                                    BiliImageKt.BiliImage($this$PurchaseButtonComponent_u24lambda_u244_u244_u243_u240.build(), SizeKt.height-3ABfNKs(SizeKt.width-3ABfNKs($this$PurchaseButtonComponent_u24lambda_u244_u244_u243.align(Modifier.Companion, Alignment.Companion.getCenterStart()), ProvideUiScaleKt.dpScaled(36, PurchaseButtonComponent$lambda$2(scaleModel$delegate).getScale())), ProvideUiScaleKt.dpScaled(42, PurchaseButtonComponent$lambda$2(scaleModel$delegate).getScale())), null, null, null, null, null, null, null, $composer3, 0, 508);
                                    String $this$asRequest$iv5 = HelperKt.customizedImageUrl(shadingImgs3.get(1));
                                    ImageRequest $this$PurchaseButtonComponent_u24lambda_u244_u244_u243_u241 = new ImageRequest($this$asRequest$iv5);
                                    $this$PurchaseButtonComponent_u24lambda_u244_u244_u243_u241.contentScale(ContentScale.Companion.getFillBounds());
                                    BiliImageKt.BiliImage($this$PurchaseButtonComponent_u24lambda_u244_u244_u243_u241.build(), SizeKt.height-3ABfNKs(SizeKt.width-3ABfNKs($this$PurchaseButtonComponent_u24lambda_u244_u244_u243.align(Modifier.Companion, Alignment.Companion.getCenterEnd()), ProvideUiScaleKt.dpScaled(36, PurchaseButtonComponent$lambda$2(scaleModel$delegate).getScale())), ProvideUiScaleKt.dpScaled(42, PurchaseButtonComponent$lambda$2(scaleModel$delegate).getScale())), null, null, null, null, null, null, null, $composer3, 0, 508);
                                    $composer3.endReplaceGroup();
                                } else {
                                    if (shadingImgs3.size() == 1) {
                                        $composer3.startReplaceGroup(489706693);
                                        ComposerKt.sourceInformation($composer3, "480@22203L638");
                                        String $this$asRequest$iv6 = HelperKt.customizedImageUrl(shadingImgs3.get(0));
                                        ImageRequest $this$PurchaseButtonComponent_u24lambda_u244_u244_u243_u242 = new ImageRequest($this$asRequest$iv6);
                                        $this$PurchaseButtonComponent_u24lambda_u244_u244_u243_u242.contentScale(ContentScale.Companion.getFillBounds());
                                        BiliImageKt.BiliImage($this$PurchaseButtonComponent_u24lambda_u244_u244_u243_u242.build(), SizeKt.height-3ABfNKs(SizeKt.width-3ABfNKs($this$PurchaseButtonComponent_u24lambda_u244_u244_u243.align(Modifier.Companion, Alignment.Companion.getCenterStart()), ProvideUiScaleKt.dpScaled(36, PurchaseButtonComponent$lambda$2(scaleModel$delegate).getScale())), ProvideUiScaleKt.dpScaled(42, PurchaseButtonComponent$lambda$2(scaleModel$delegate).getScale())), null, null, null, null, null, null, null, $composer3, 0, 508);
                                    } else {
                                        $composer3.startReplaceGroup(467753795);
                                    }
                                    $composer3.endReplaceGroup();
                                }
                                $composer3.endReplaceGroup();
                                str6 = "http://i0.hdslb.com/bfs/kfptfe/floor/a5a9fcf7fb6aab5dd39cf781bc4aee044302c9b7.png";
                                if (addCartData2 != null && (it = addCartData2.getButtonIcon()) != null) {
                                    str6 = it.length() <= 0 ? it : "http://i0.hdslb.com/bfs/kfptfe/floor/a5a9fcf7fb6aab5dd39cf781bc4aee044302c9b7.png";
                                    Unit unit = Unit.INSTANCE;
                                    Unit unit2 = Unit.INSTANCE;
                                }
                                String $this$asRequest_u24default$iv = HelperKt.customizedImageUrl(str6);
                                ImageRequest imageRequest = new ImageRequest($this$asRequest_u24default$iv);
                                Unit unit3 = Unit.INSTANCE;
                                BiliImageKt.BiliImage(imageRequest.build(), SizeKt.size-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(24, PurchaseButtonComponent$lambda$2(scaleModel$delegate).getScale())), null, null, null, null, null, null, null, $composer3, 0, 508);
                                ComposerKt.sourceInformationMarkerEnd($composer3);
                                ComposerKt.sourceInformationMarkerEnd($composer3);
                                $composer3.endNode();
                                ComposerKt.sourceInformationMarkerEnd($composer3);
                                ComposerKt.sourceInformationMarkerEnd($composer3);
                                ComposerKt.sourceInformationMarkerEnd($composer3);
                                $composer3.endReplaceGroup();
                                onAddButton2 = onAddButton5;
                                pageViewModel2 = pageViewModel5;
                            }
                        }
                        $composer3.startReplaceGroup(467753795);
                        $composer3.endReplaceGroup();
                        str6 = "http://i0.hdslb.com/bfs/kfptfe/floor/a5a9fcf7fb6aab5dd39cf781bc4aee044302c9b7.png";
                        if (addCartData2 != null) {
                            if (it.length() <= 0) {
                            }
                            Unit unit4 = Unit.INSTANCE;
                            Unit unit22 = Unit.INSTANCE;
                        }
                        String $this$asRequest_u24default$iv2 = HelperKt.customizedImageUrl(str6);
                        ImageRequest imageRequest2 = new ImageRequest($this$asRequest_u24default$iv2);
                        Unit unit32 = Unit.INSTANCE;
                        BiliImageKt.BiliImage(imageRequest2.build(), SizeKt.size-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(24, PurchaseButtonComponent$lambda$2(scaleModel$delegate).getScale())), null, null, null, null, null, null, null, $composer3, 0, 508);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        $composer3.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        $composer3.endReplaceGroup();
                        onAddButton2 = onAddButton5;
                        pageViewModel2 = pageViewModel5;
                    }
                    onAddButton5 = onAddButton3;
                    Object value$iv6 = new Function0() { // from class: kntr.app.mall.product.details.page.ui.container.BottomContainerKt$$ExternalSyntheticLambda2
                        public final Object invoke() {
                            Unit PurchaseButtonComponent$lambda$4$4$1$0;
                            PurchaseButtonComponent$lambda$4$4$1$0 = BottomContainerKt.PurchaseButtonComponent$lambda$4$4$1$0(onAddButton5);
                            return PurchaseButtonComponent$lambda$4$4$1$0;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv6);
                    it$iv5 = value$iv6;
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    Modifier modifier102 = ClickableKt.clickable-oSLSa3U$default(modifier9, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv5, 15, (Object) null);
                    ComposerKt.sourceInformationMarkerStart($composer3, 1851889965, "CC(remember):BottomContainer.kt#9igjgp");
                    final PageViewModel pageViewModel52 = pageViewModel;
                    invalid$iv2 = $composer3.changedInstance(pageViewModel52);
                    Object it$iv62 = $composer3.rememberedValue();
                    if (invalid$iv2) {
                    }
                    Object value$iv52 = new Function0() { // from class: kntr.app.mall.product.details.page.ui.container.BottomContainerKt$$ExternalSyntheticLambda3
                        public final Object invoke() {
                            Unit PurchaseButtonComponent$lambda$4$4$2$0;
                            PurchaseButtonComponent$lambda$4$4$2$0 = BottomContainerKt.PurchaseButtonComponent$lambda$4$4$2$0(PageViewModel.this);
                            return PurchaseButtonComponent$lambda$4$4$2$0;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv52);
                    it$iv62 = value$iv52;
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    Modifier modifier$iv42 = ExposerKt.reportOnExposure(modifier102, "mall_detail_add_cart_button", collectorHolder, null, false, 0.5f, 0, 500L, (Function0) it$iv62, $composer3, 12779568, 44);
                    Alignment contentAlignment$iv22 = Alignment.Companion.getCenter();
                    $composer$iv2 = $composer3;
                    $composer$iv$iv = $composer3;
                    ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicy$iv42 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv22, false);
                    int $changed$iv$iv42 = (48 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int compositeKeyHash$iv$iv52 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
                    CompositionLocalMap localMap$iv$iv42 = $composer3.getCurrentCompositionLocalMap();
                    $composer$iv$iv$iv2 = $composer3;
                    Modifier materialized$iv$iv42 = ComposedModifierKt.materializeModifier($composer3, modifier$iv42);
                    Function0 factory$iv$iv$iv132 = ComposeUiNode.Companion.getConstructor();
                    int $changed$iv$iv$iv42 = (($changed$iv$iv42 << 6) & 896) | 6;
                    $composer$iv3 = $composer3;
                    str = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
                    ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!($composer3.getApplier() instanceof Applier)) {
                    }
                    $composer3.startReusableNode();
                    if ($composer3.getInserting()) {
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv42 = Updater.constructor-impl($composer3);
                    str2 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv42, measurePolicy$iv42, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv42, localMap$iv$iv42, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv42, Integer.valueOf(compositeKeyHash$iv$iv52), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv42, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv42, materialized$iv$iv42, ComposeUiNode.Companion.getSetModifier());
                    int i162 = ($changed$iv$iv$iv42 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    int i172 = ((48 >> 6) & 112) | 6;
                    BoxScope $this$PurchaseButtonComponent_u24lambda_u244_u244_u2432 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart($composer3, 488165281, "C499@23251L303:BottomContainer.kt#u9475x");
                    if (showSkinCover2) {
                    }
                    $composer3.startReplaceGroup(467753795);
                    $composer3.endReplaceGroup();
                    str6 = "http://i0.hdslb.com/bfs/kfptfe/floor/a5a9fcf7fb6aab5dd39cf781bc4aee044302c9b7.png";
                    if (addCartData2 != null) {
                    }
                    String $this$asRequest_u24default$iv22 = HelperKt.customizedImageUrl(str6);
                    ImageRequest imageRequest22 = new ImageRequest($this$asRequest_u24default$iv22);
                    Unit unit322 = Unit.INSTANCE;
                    BiliImageKt.BiliImage(imageRequest22.build(), SizeKt.size-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(24, PurchaseButtonComponent$lambda$2(scaleModel$delegate).getScale())), null, null, null, null, null, null, null, $composer3, 0, 508);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    $composer3.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    $composer3.endReplaceGroup();
                    onAddButton2 = onAddButton5;
                    pageViewModel2 = pageViewModel52;
                } else {
                    $composer$iv2 = $composer3;
                    str4 = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
                    str5 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
                    $composer$iv$iv = $composer3;
                    shadingImgs = shadingImgs3;
                    pageViewModel3 = pageViewModel;
                    onAddButton4 = onAddButton3;
                    $composer$iv3 = $composer3;
                    $composer$iv$iv$iv2 = $composer3;
                }
                $composer3.startReplaceGroup(1577742780);
                ComposerKt.sourceInformation($composer3, "539@25001L85,546@25404L298,541@25087L615,533@24708L4125");
                List<String> list5 = bgColors2;
                if (list5 == null || list5.isEmpty()) {
                    backgroundModifier2 = BackgroundKt.background-bw27NRU$default(Modifier.Companion, ColorKt.Color(4294961138L), (Shape) null, 2, (Object) null);
                } else if (bgColors2.size() == 1) {
                    backgroundModifier2 = BackgroundKt.background-bw27NRU$default(Modifier.Companion, ComposeColorParserKt.parseColor(bgColors2.get(0)), (Shape) null, 2, (Object) null);
                } else {
                    Modifier modifier11 = Modifier.Companion;
                    Brush.Companion companion3 = Brush.Companion;
                    Iterable $this$map$iv3 = bgColors2;
                    Collection destination$iv$iv3 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv3, 10));
                    for (Object item$iv$iv3 : $this$map$iv3) {
                        destination$iv$iv3.add(Color.box-impl(ComposeColorParserKt.parseColor((String) item$iv$iv3)));
                    }
                    backgroundModifier2 = BackgroundKt.background$default(modifier11, Brush.Companion.horizontalGradient-8A-3gB4$default(companion3, (List) destination$iv$iv3, 0.0f, 0.0f, 0, 14, (Object) null), (Shape) null, 0.0f, 6, (Object) null);
                }
                String str8 = fontColor2;
                long textColor2 = !(str8 == null || str8.length() == 0) ? ComposeColorParserKt.parseColor(fontColor2) : ColorKt.Color(4294928025L);
                Modifier then2 = RowScope.-CC.weight$default($this$PurchaseButtonComponent_u24lambda_u244_u244, SizeKt.height-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(42, PurchaseButtonComponent$lambda$2(scaleModel$delegate).getScale())), 1.0f, false, 2, (Object) null).then(backgroundModifier2);
                ComposerKt.sourceInformationMarkerStart($composer3, 1852049912, "CC(remember):BottomContainer.kt#9igjgp");
                boolean invalid$iv6 = ($dirty2 & 57344) == 16384;
                Object it$iv7 = $composer3.rememberedValue();
                if (invalid$iv6 || it$iv7 == Composer.Companion.getEmpty()) {
                    Object value$iv7 = new Function0() { // from class: kntr.app.mall.product.details.page.ui.container.BottomContainerKt$$ExternalSyntheticLambda16
                        public final Object invoke() {
                            Unit PurchaseButtonComponent$lambda$4$4$5$0;
                            PurchaseButtonComponent$lambda$4$4$5$0 = BottomContainerKt.PurchaseButtonComponent$lambda$4$4$5$0(onAddButton4);
                            return PurchaseButtonComponent$lambda$4$4$5$0;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv7);
                    it$iv7 = value$iv7;
                }
                ComposerKt.sourceInformationMarkerEnd($composer3);
                Modifier modifier12 = ClickableKt.clickable-oSLSa3U$default(then2, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv7, 15, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer3, 1852063021, "CC(remember):BottomContainer.kt#9igjgp");
                pageViewModel2 = pageViewModel3;
                boolean invalid$iv7 = $composer3.changedInstance(pageViewModel2);
                Object it$iv8 = $composer3.rememberedValue();
                if (invalid$iv7 || it$iv8 == Composer.Companion.getEmpty()) {
                    Object value$iv8 = new Function0() { // from class: kntr.app.mall.product.details.page.ui.container.BottomContainerKt$$ExternalSyntheticLambda17
                        public final Object invoke() {
                            Unit PurchaseButtonComponent$lambda$4$4$6$0;
                            PurchaseButtonComponent$lambda$4$4$6$0 = BottomContainerKt.PurchaseButtonComponent$lambda$4$4$6$0(PageViewModel.this);
                            return PurchaseButtonComponent$lambda$4$4$6$0;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv8);
                    it$iv8 = value$iv8;
                }
                ComposerKt.sourceInformationMarkerEnd($composer3);
                Modifier modifier$iv5 = ExposerKt.reportOnExposure(modifier12, "mall_detail_add_cart_button", collectorHolder, null, false, 0.5f, 0, 500L, (Function0) it$iv8, $composer3, 12779568, 44);
                Alignment contentAlignment$iv3 = Alignment.Companion.getCenter();
                ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv5 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv3, false);
                int $changed$iv$iv5 = (48 << 3) & 112;
                String str9 = str4;
                ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, str9);
                int compositeKeyHash$iv$iv6 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
                CompositionLocalMap localMap$iv$iv5 = $composer3.getCurrentCompositionLocalMap();
                onAddButton2 = onAddButton4;
                Modifier materialized$iv$iv5 = ComposedModifierKt.materializeModifier($composer3, modifier$iv5);
                Function0 factory$iv$iv$iv14 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv5 = (($changed$iv$iv5 << 6) & 896) | 6;
                String str10 = str5;
                ComposerKt.sourceInformationMarkerStart($composer3, -553112988, str10);
                if (!($composer3.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer3.startReusableNode();
                if ($composer3.getInserting()) {
                    factory$iv$iv$iv8 = factory$iv$iv$iv14;
                    $composer3.createNode(factory$iv$iv$iv8);
                } else {
                    factory$iv$iv$iv8 = factory$iv$iv$iv14;
                    $composer3.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv5 = Updater.constructor-impl($composer3);
                str2 = str10;
                str = str9;
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, measurePolicy$iv5, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, localMap$iv$iv5, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv5, Integer.valueOf(compositeKeyHash$iv$iv6), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv5, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, materialized$iv$iv5, ComposeUiNode.Companion.getSetModifier());
                int i18 = ($changed$iv$iv$iv5 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                int i19 = ((48 >> 6) & 112) | 6;
                BoxScope $this$PurchaseButtonComponent_u24lambda_u244_u244_u247 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer3, 916625135, "C597@28331L480:BottomContainer.kt#u9475x");
                if (showSkinCover2) {
                    List list6 = shadingImgs;
                    if (!(list6 == null || list6.isEmpty())) {
                        $composer3.startReplaceGroup(916658459);
                        ComposerKt.sourceInformation($composer3, "");
                        if (shadingImgs.size() >= 2) {
                            $composer3.startReplaceGroup(916687661);
                            ComposerKt.sourceInformation($composer3, "558@26086L638,570@26814L636");
                            String $this$asRequest$iv7 = HelperKt.customizedImageUrl(shadingImgs.get(0));
                            ImageRequest $this$PurchaseButtonComponent_u24lambda_u244_u244_u247_u240 = new ImageRequest($this$asRequest$iv7);
                            $this$PurchaseButtonComponent_u24lambda_u244_u244_u247_u240.contentScale(ContentScale.Companion.getFillBounds());
                            BiliImageKt.BiliImage($this$PurchaseButtonComponent_u24lambda_u244_u244_u247_u240.build(), SizeKt.height-3ABfNKs(SizeKt.width-3ABfNKs($this$PurchaseButtonComponent_u24lambda_u244_u244_u247.align(Modifier.Companion, Alignment.Companion.getCenterStart()), ProvideUiScaleKt.dpScaled(36, PurchaseButtonComponent$lambda$2(scaleModel$delegate).getScale())), ProvideUiScaleKt.dpScaled(42, PurchaseButtonComponent$lambda$2(scaleModel$delegate).getScale())), null, null, null, null, null, null, null, $composer3, 0, 508);
                            String $this$asRequest$iv8 = HelperKt.customizedImageUrl(shadingImgs.get(1));
                            ImageRequest $this$PurchaseButtonComponent_u24lambda_u244_u244_u247_u241 = new ImageRequest($this$asRequest$iv8);
                            $this$PurchaseButtonComponent_u24lambda_u244_u244_u247_u241.contentScale(ContentScale.Companion.getFillBounds());
                            BiliImageKt.BiliImage($this$PurchaseButtonComponent_u24lambda_u244_u244_u247_u241.build(), SizeKt.height-3ABfNKs(SizeKt.width-3ABfNKs($this$PurchaseButtonComponent_u24lambda_u244_u244_u247.align(Modifier.Companion, Alignment.Companion.getCenterEnd()), ProvideUiScaleKt.dpScaled(36, PurchaseButtonComponent$lambda$2(scaleModel$delegate).getScale())), ProvideUiScaleKt.dpScaled(42, PurchaseButtonComponent$lambda$2(scaleModel$delegate).getScale())), null, null, null, null, null, null, null, $composer3, 0, 508);
                            $composer3.endReplaceGroup();
                        } else {
                            if (shadingImgs.size() == 1) {
                                $composer3.startReplaceGroup(918171228);
                                ComposerKt.sourceInformation($composer3, "583@27611L638");
                                String $this$asRequest$iv9 = HelperKt.customizedImageUrl(shadingImgs.get(0));
                                ImageRequest $this$PurchaseButtonComponent_u24lambda_u244_u244_u247_u242 = new ImageRequest($this$asRequest$iv9);
                                $this$PurchaseButtonComponent_u24lambda_u244_u244_u247_u242.contentScale(ContentScale.Companion.getFillBounds());
                                BiliImageKt.BiliImage($this$PurchaseButtonComponent_u24lambda_u244_u244_u247_u242.build(), SizeKt.height-3ABfNKs(SizeKt.width-3ABfNKs($this$PurchaseButtonComponent_u24lambda_u244_u244_u247.align(Modifier.Companion, Alignment.Companion.getCenterStart()), ProvideUiScaleKt.dpScaled(36, PurchaseButtonComponent$lambda$2(scaleModel$delegate).getScale())), ProvideUiScaleKt.dpScaled(42, PurchaseButtonComponent$lambda$2(scaleModel$delegate).getScale())), null, null, null, null, null, null, null, $composer3, 0, 508);
                            } else {
                                $composer3.startReplaceGroup(890853594);
                            }
                            $composer3.endReplaceGroup();
                        }
                        $composer3.endReplaceGroup();
                        TextKt.Text-Nvy7gAk("加购物车", (Modifier) null, textColor2, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, ProvideUiScaleKt.scaled(new TextStyle(0L, TextUnitKt.getSp(16), FontWeight.Companion.getMedium(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(22), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646137, (DefaultConstructorMarker) null), PurchaseButtonComponent$lambda$2(scaleModel$delegate).getScale()), $composer3, 6, 24576, 114682);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        $composer3.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        $composer3.endReplaceGroup();
                    }
                }
                $composer3.startReplaceGroup(890853594);
                $composer3.endReplaceGroup();
                TextKt.Text-Nvy7gAk("加购物车", (Modifier) null, textColor2, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, ProvideUiScaleKt.scaled(new TextStyle(0L, TextUnitKt.getSp(16), FontWeight.Companion.getMedium(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(22), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646137, (DefaultConstructorMarker) null), PurchaseButtonComponent$lambda$2(scaleModel$delegate).getScale()), $composer3, 6, 24576, 114682);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer3.endReplaceGroup();
            } else {
                $composer$iv2 = $composer3;
                str = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
                str2 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
                $composer$iv$iv = $composer3;
                onAddButton2 = onAddButton3;
                $composer$iv3 = $composer3;
                pageViewModel2 = pageViewModel;
                $composer$iv$iv$iv2 = $composer3;
                $composer3.startReplaceGroup(1554167807);
            }
            $composer3.endReplaceGroup();
            List purchaseBgColors = data2.getBgColors();
            String purchaseFontColor = data2.getFontColor();
            List purchaseShadingImgs = data2.getShadingImgs();
            List list7 = purchaseBgColors;
            if (list7 == null || list7.isEmpty()) {
                modifier3 = BackgroundKt.background-bw27NRU$default(Modifier.Companion, ComposeColorParserKt.parseColor(buttonColorString == null ? "0xFFFF6699" : buttonColorString), (Shape) null, 2, (Object) null);
            } else if (purchaseBgColors.size() == 1) {
                modifier3 = BackgroundKt.background-bw27NRU$default(Modifier.Companion, ComposeColorParserKt.parseColor(purchaseBgColors.get(0)), (Shape) null, 2, (Object) null);
            } else {
                Modifier modifier13 = Modifier.Companion;
                Brush.Companion companion4 = Brush.Companion;
                List $this$map$iv4 = purchaseBgColors;
                Collection destination$iv$iv4 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv4, 10));
                for (Object item$iv$iv4 : $this$map$iv4) {
                    destination$iv$iv4.add(Color.box-impl(ComposeColorParserKt.parseColor((String) item$iv$iv4)));
                    purchaseBgColors = purchaseBgColors;
                }
                modifier3 = BackgroundKt.background$default(modifier13, Brush.Companion.horizontalGradient-8A-3gB4$default(companion4, (List) destination$iv$iv4, 0.0f, 0.0f, 0, 14, (Object) null), (Shape) null, 0.0f, 6, (Object) null);
            }
            Modifier purchaseBackgroundModifier = modifier3;
            String str11 = purchaseFontColor;
            long purchaseTextColor = !(str11 == null || str11.length() == 0) ? ComposeColorParserKt.parseColor(purchaseFontColor) : Color.Companion.getWhite-0d7_KjU();
            Modifier then3 = RowScope.-CC.weight$default($this$PurchaseButtonComponent_u24lambda_u244_u244, SizeKt.height-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(42, PurchaseButtonComponent$lambda$2(scaleModel$delegate).getScale())), 1.0f, false, 2, (Object) null).then(purchaseBackgroundModifier);
            ComposerKt.sourceInformationMarkerStart($composer3, 1852221741, "CC(remember):BottomContainer.kt#9igjgp");
            boolean invalid$iv8 = ($dirty2 & 458752) == 131072;
            Object it$iv9 = $composer3.rememberedValue();
            if (invalid$iv8 || it$iv9 == Composer.Companion.getEmpty()) {
                onPurchaseButton3 = onPurchaseButton4;
                Object value$iv9 = new Function0() { // from class: kntr.app.mall.product.details.page.ui.container.BottomContainerKt$$ExternalSyntheticLambda18
                    public final Object invoke() {
                        Unit PurchaseButtonComponent$lambda$4$4$9$0;
                        PurchaseButtonComponent$lambda$4$4$9$0 = BottomContainerKt.PurchaseButtonComponent$lambda$4$4$9$0(onPurchaseButton3);
                        return PurchaseButtonComponent$lambda$4$4$9$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv9);
                it$iv9 = value$iv9;
            } else {
                onPurchaseButton3 = onPurchaseButton4;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            onPurchaseButton = onPurchaseButton3;
            Modifier modifier14 = ClickableKt.clickable-oSLSa3U$default(then3, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv9, 15, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer3, 1852233188, "CC(remember):BottomContainer.kt#9igjgp");
            boolean invalid$iv9 = $composer3.changedInstance(pageViewModel2);
            Object it$iv10 = $composer3.rememberedValue();
            if (invalid$iv9 || it$iv10 == Composer.Companion.getEmpty()) {
                Object value$iv10 = new Function0() { // from class: kntr.app.mall.product.details.page.ui.container.BottomContainerKt$$ExternalSyntheticLambda19
                    public final Object invoke() {
                        Unit PurchaseButtonComponent$lambda$4$4$10$0;
                        PurchaseButtonComponent$lambda$4$4$10$0 = BottomContainerKt.PurchaseButtonComponent$lambda$4$4$10$0(PageViewModel.this);
                        return PurchaseButtonComponent$lambda$4$4$10$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv10);
                it$iv10 = value$iv10;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifier$iv6 = ExposerKt.reportOnExposure(modifier14, "mall_detail_purchase_button", collectorHolder, null, false, 0.5f, 0, 500L, (Function0) it$iv10, $composer3, 12779568, 44);
            Alignment contentAlignment$iv4 = Alignment.Companion.getCenter();
            ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv6 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv4, false);
            int $changed$iv$iv6 = (48 << 3) & 112;
            String purchaseFontColor2 = str;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, purchaseFontColor2);
            int compositeKeyHash$iv$iv7 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv6 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv6 = ComposedModifierKt.materializeModifier($composer3, modifier$iv6);
            Function0 factory$iv$iv$iv15 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv6 = (($changed$iv$iv6 << 6) & 896) | 6;
            String str12 = str2;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, str12);
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv3 = factory$iv$iv$iv15;
                $composer3.createNode(factory$iv$iv$iv3);
            } else {
                factory$iv$iv$iv3 = factory$iv$iv$iv15;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv6 = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv6, measurePolicy$iv6, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv6, localMap$iv$iv6, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv6, Integer.valueOf(compositeKeyHash$iv$iv7), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv6, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv6, materialized$iv$iv6, ComposeUiNode.Companion.getSetModifier());
            int i20 = ($changed$iv$iv$iv6 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            int i21 = ((48 >> 6) & 112) | 6;
            BoxScope $this$PurchaseButtonComponent_u24lambda_u244_u244_u2411 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, 1426523661, "C705@33246L9164:BottomContainer.kt#u9475x");
            if (showSkinCover2) {
                List list8 = purchaseShadingImgs;
                if (!(list8 == null || list8.isEmpty())) {
                    $composer3.startReplaceGroup(1426295717);
                    ComposerKt.sourceInformation($composer3, "");
                    if (purchaseShadingImgs.size() >= 2) {
                        $composer3.startReplaceGroup(1426328422);
                        ComposerKt.sourceInformation($composer3, "666@31307L566,678@31930L564");
                        String $this$asRequest$iv10 = HelperKt.customizedImageUrl(purchaseShadingImgs.get(0));
                        str3 = "";
                        ImageRequest $this$PurchaseButtonComponent_u24lambda_u244_u244_u2411_u240 = new ImageRequest($this$asRequest$iv10);
                        $this$PurchaseButtonComponent_u24lambda_u244_u244_u2411_u240.contentScale(ContentScale.Companion.getFillBounds());
                        BiliImageKt.BiliImage($this$PurchaseButtonComponent_u24lambda_u244_u244_u2411_u240.build(), SizeKt.height-3ABfNKs(SizeKt.width-3ABfNKs($this$PurchaseButtonComponent_u24lambda_u244_u244_u2411.align(Modifier.Companion, Alignment.Companion.getCenterStart()), ProvideUiScaleKt.dpScaled(36, PurchaseButtonComponent$lambda$2(scaleModel$delegate).getScale())), ProvideUiScaleKt.dpScaled(42, PurchaseButtonComponent$lambda$2(scaleModel$delegate).getScale())), null, null, null, null, null, null, null, $composer3, 0, 508);
                        String $this$asRequest$iv11 = HelperKt.customizedImageUrl(purchaseShadingImgs.get(1));
                        ImageRequest $this$PurchaseButtonComponent_u24lambda_u244_u244_u2411_u241 = new ImageRequest($this$asRequest$iv11);
                        $this$PurchaseButtonComponent_u24lambda_u244_u244_u2411_u241.contentScale(ContentScale.Companion.getFillBounds());
                        BiliImageKt.BiliImage($this$PurchaseButtonComponent_u24lambda_u244_u244_u2411_u241.build(), SizeKt.height-3ABfNKs(SizeKt.width-3ABfNKs($this$PurchaseButtonComponent_u24lambda_u244_u244_u2411.align(Modifier.Companion, Alignment.Companion.getCenterEnd()), ProvideUiScaleKt.dpScaled(36, PurchaseButtonComponent$lambda$2(scaleModel$delegate).getScale())), ProvideUiScaleKt.dpScaled(42, PurchaseButtonComponent$lambda$2(scaleModel$delegate).getScale())), null, null, null, null, null, null, null, $composer3, 0, 508);
                        $composer3.endReplaceGroup();
                    } else {
                        str3 = "";
                        if (purchaseShadingImgs.size() == 1) {
                            $composer3.startReplaceGroup(1427606924);
                            ComposerKt.sourceInformation($composer3, "691@32622L566");
                            String $this$asRequest$iv12 = HelperKt.customizedImageUrl(purchaseShadingImgs.get(0));
                            ImageRequest $this$PurchaseButtonComponent_u24lambda_u244_u244_u2411_u242 = new ImageRequest($this$asRequest$iv12);
                            $this$PurchaseButtonComponent_u24lambda_u244_u244_u2411_u242.contentScale(ContentScale.Companion.getFillBounds());
                            BiliImageKt.BiliImage($this$PurchaseButtonComponent_u24lambda_u244_u244_u2411_u242.build(), SizeKt.height-3ABfNKs(SizeKt.width-3ABfNKs($this$PurchaseButtonComponent_u24lambda_u244_u244_u2411.align(Modifier.Companion, Alignment.Companion.getCenterStart()), ProvideUiScaleKt.dpScaled(36, PurchaseButtonComponent$lambda$2(scaleModel$delegate).getScale())), ProvideUiScaleKt.dpScaled(42, PurchaseButtonComponent$lambda$2(scaleModel$delegate).getScale())), null, null, null, null, null, null, null, $composer3, 0, 508);
                        } else {
                            $composer3.startReplaceGroup(1395289145);
                        }
                        $composer3.endReplaceGroup();
                    }
                    $composer3.endReplaceGroup();
                    Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getCenter();
                    Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getCenterHorizontally();
                    ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                    Modifier modifier$iv7 = Modifier.Companion;
                    MeasurePolicy measurePolicy$iv7 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((432 >> 3) & 14) | ((432 >> 3) & 112));
                    int $changed$iv$iv7 = (432 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, purchaseFontColor2);
                    int compositeKeyHash$iv$iv8 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
                    CompositionLocalMap localMap$iv$iv7 = $composer3.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv7 = ComposedModifierKt.materializeModifier($composer3, modifier$iv7);
                    Function0 factory$iv$iv$iv16 = ComposeUiNode.Companion.getConstructor();
                    int $changed$iv$iv$iv7 = (($changed$iv$iv7 << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer3, -553112988, str12);
                    if (!($composer3.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer3.startReusableNode();
                    if ($composer3.getInserting()) {
                        factory$iv$iv$iv4 = factory$iv$iv$iv16;
                        $composer3.useNode();
                    } else {
                        factory$iv$iv$iv4 = factory$iv$iv$iv16;
                        $composer3.createNode(factory$iv$iv$iv4);
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv7 = Updater.constructor-impl($composer3);
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv7, measurePolicy$iv7, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv7, localMap$iv$iv7, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv7, Integer.valueOf(compositeKeyHash$iv$iv8), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv7, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv7, materialized$iv$iv7, ComposeUiNode.Companion.getSetModifier());
                    int i22 = ($changed$iv$iv$iv7 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                    ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
                    int i23 = ((432 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer3, -645449600, "C711@33558L4816,808@38744L100,806@38609L262:BottomContainer.kt#u9475x");
                    buttonText = data2.getButtonText();
                    if (buttonText == null) {
                        buttonText = "加购物车";
                    }
                    String buttonText2 = buttonText;
                    buttonPriceDescVO = data2.getButtonPriceDescVO();
                    Alignment.Vertical verticalAlignment$iv3 = Alignment.Companion.getCenterVertically();
                    ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                    Modifier modifier$iv8 = Modifier.Companion;
                    Arrangement.Horizontal horizontalArrangement$iv3 = Arrangement.INSTANCE.getStart();
                    MeasurePolicy measurePolicy$iv8 = RowKt.rowMeasurePolicy(horizontalArrangement$iv3, verticalAlignment$iv3, $composer3, ((384 >> 3) & 14) | ((384 >> 3) & 112));
                    int $changed$iv$iv8 = (384 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, purchaseFontColor2);
                    int compositeKeyHash$iv$iv9 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
                    CompositionLocalMap localMap$iv$iv8 = $composer3.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv8 = ComposedModifierKt.materializeModifier($composer3, modifier$iv8);
                    Function0 factory$iv$iv$iv17 = ComposeUiNode.Companion.getConstructor();
                    int $changed$iv$iv$iv8 = (($changed$iv$iv8 << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer3, -553112988, str12);
                    if (!($composer3.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer3.startReusableNode();
                    if ($composer3.getInserting()) {
                        factory$iv$iv$iv5 = factory$iv$iv$iv17;
                        $composer3.useNode();
                    } else {
                        factory$iv$iv$iv5 = factory$iv$iv$iv17;
                        $composer3.createNode(factory$iv$iv$iv5);
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv8 = Updater.constructor-impl($composer3);
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv8, measurePolicy$iv8, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv8, localMap$iv$iv8, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv8, Integer.valueOf(compositeKeyHash$iv$iv9), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv8, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv8, materialized$iv$iv8, ComposeUiNode.Companion.getSetModifier());
                    int i24 = ($changed$iv$iv$iv8 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                    int i25 = ((384 >> 6) & 112) | 6;
                    RowScope $this$PurchaseButtonComponent_u24lambda_u244_u244_u2411_u243_u240 = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart($composer3, 1570707203, "C714@33683L1015:BottomContainer.kt#u9475x");
                    TextKt.Text-Nvy7gAk(buttonText2, $this$PurchaseButtonComponent_u24lambda_u244_u244_u2411_u243_u240.alignByBaseline(Modifier.Companion), purchaseTextColor, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, buttonText2.length() <= 6 ? ProvideUiScaleKt.scaled(new TextStyle(0L, TextUnitKt.getSp(14), FontWeight.Companion.getMedium(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(20), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646137, (DefaultConstructorMarker) null), PurchaseButtonComponent$lambda$2(scaleModel$delegate).getScale()) : ProvideUiScaleKt.scaled(new TextStyle(0L, TextUnitKt.getSp(16), FontWeight.Companion.getMedium(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(20), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646137, (DefaultConstructorMarker) null), PurchaseButtonComponent$lambda$2(scaleModel$delegate).getScale()), $composer3, 0, 24576, 114680);
                    if (buttonPriceDescVO == null) {
                        $composer3.startReplaceGroup(1571736433);
                        ComposerKt.sourceInformation($composer3, "735@34784L632,747@35445L632,759@36106L637,771@36772L893,788@37694L632");
                        Modifier alignByBaseline = $this$PurchaseButtonComponent_u24lambda_u244_u244_u2411_u243_u240.alignByBaseline(Modifier.Companion);
                        String pricePrefix = buttonPriceDescVO.getPricePrefix();
                        TextKt.Text-Nvy7gAk(pricePrefix == null ? str3 : pricePrefix, alignByBaseline, purchaseTextColor, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, ProvideUiScaleKt.scaled(new TextStyle(0L, TextUnitKt.getSp(10), FontWeight.Companion.getMedium(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(18), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646137, (DefaultConstructorMarker) null), PurchaseButtonComponent$lambda$2(scaleModel$delegate).getScale()), $composer3, 0, 24576, 114680);
                        Modifier alignByBaseline2 = $this$PurchaseButtonComponent_u24lambda_u244_u244_u2411_u243_u240.alignByBaseline(Modifier.Companion);
                        String priceSymbol = buttonPriceDescVO.getPriceSymbol();
                        TextKt.Text-Nvy7gAk(priceSymbol == null ? str3 : priceSymbol, alignByBaseline2, purchaseTextColor, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, ProvideUiScaleKt.scaled(new TextStyle(0L, TextUnitKt.getSp(10), FontWeight.Companion.getMedium(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(18), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646137, (DefaultConstructorMarker) null), PurchaseButtonComponent$lambda$2(scaleModel$delegate).getScale()), $composer3, 0, 24576, 114680);
                        Modifier alignByBaseline3 = $this$PurchaseButtonComponent_u24lambda_u244_u244_u2411_u243_u240.alignByBaseline(Modifier.Companion);
                        String priceIntegerPart = buttonPriceDescVO.getPriceIntegerPart();
                        TextKt.Text-Nvy7gAk(priceIntegerPart == null ? str3 : priceIntegerPart, alignByBaseline3, purchaseTextColor, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, ProvideUiScaleKt.scaled(new TextStyle(0L, TextUnitKt.getSp(16), FontWeight.Companion.getMedium(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(20), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646137, (DefaultConstructorMarker) null), PurchaseButtonComponent$lambda$2(scaleModel$delegate).getScale()), $composer3, 0, 24576, 114680);
                        Modifier alignByBaseline4 = $this$PurchaseButtonComponent_u24lambda_u244_u244_u2411_u243_u240.alignByBaseline(Modifier.Companion);
                        TextStyle scaled = ProvideUiScaleKt.scaled(new TextStyle(0L, TextUnitKt.getSp(16), FontWeight.Companion.getMedium(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(20), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646137, (DefaultConstructorMarker) null), PurchaseButtonComponent$lambda$2(scaleModel$delegate).getScale());
                        String priceDecimalPart = buttonPriceDescVO.getPriceDecimalPart();
                        TextKt.Text-Nvy7gAk(priceDecimalPart == null || priceDecimalPart.length() == 0 ? str3 : "." + buttonPriceDescVO.getPriceDecimalPart(), alignByBaseline4, purchaseTextColor, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, scaled, $composer3, 0, 24576, 114680);
                        Modifier alignByBaseline5 = $this$PurchaseButtonComponent_u24lambda_u244_u244_u2411_u243_u240.alignByBaseline(Modifier.Companion);
                        String priceSuffix = buttonPriceDescVO.getPriceSuffix();
                        TextKt.Text-Nvy7gAk(priceSuffix == null ? str3 : priceSuffix, alignByBaseline5, purchaseTextColor, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, ProvideUiScaleKt.scaled(new TextStyle(0L, TextUnitKt.getSp(10), FontWeight.Companion.getMedium(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(18), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646137, (DefaultConstructorMarker) null), PurchaseButtonComponent$lambda$2(scaleModel$delegate).getScale()), $composer3, 0, 24576, 114680);
                    } else {
                        $composer3.startReplaceGroup(1537147935);
                    }
                    $composer3.endReplaceGroup();
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    $composer3.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    CountDownInfoVO countDownInfo = data2.getButtonSubCountDownInfo();
                    boolean z3 = countDownInfo != null;
                    showCountDown = z3;
                    Long leftTime = countDownInfo == null ? countDownInfo.getLeftTime() : null;
                    ComposerKt.sourceInformationMarkerStart($composer3, 2057550275, "CC(remember):BottomContainer.kt#9igjgp");
                    invalid$iv = $composer3.changedInstance(pageViewModel2);
                    it$iv = $composer3.rememberedValue();
                    if (!invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                        Object value$iv11 = new Function0() { // from class: kntr.app.mall.product.details.page.ui.container.BottomContainerKt$$ExternalSyntheticLambda20
                            public final Object invoke() {
                                Unit PurchaseButtonComponent$lambda$4$4$11$3$1$0;
                                PurchaseButtonComponent$lambda$4$4$11$3$1$0 = BottomContainerKt.PurchaseButtonComponent$lambda$4$4$11$3$1$0(PageViewModel.this);
                                return PurchaseButtonComponent$lambda$4$4$11$3$1$0;
                            }
                        };
                        $composer3.updateRememberedValue(value$iv11);
                        it$iv = value$iv11;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    String countDownText = MergeAtmospherePriceFloorComponentKt.rememberCountdown(leftTime, (Function0) it$iv, $composer3, 0, 0);
                    if (!showCountDown) {
                        $composer3.startReplaceGroup(-640200216);
                        ComposerKt.sourceInformation($composer3, "813@38937L2795");
                        Modifier modifier$iv9 = Modifier.Companion;
                        Alignment.Vertical verticalAlignment$iv4 = Alignment.Companion.getCenterVertically();
                        ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                        Arrangement.Horizontal horizontalArrangement$iv4 = Arrangement.INSTANCE.getStart();
                        MeasurePolicy measurePolicy$iv9 = RowKt.rowMeasurePolicy(horizontalArrangement$iv4, verticalAlignment$iv4, $composer3, ((390 >> 3) & 14) | ((390 >> 3) & 112));
                        int $changed$iv$iv9 = (390 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, purchaseFontColor2);
                        int compositeKeyHash$iv$iv10 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
                        CompositionLocalMap localMap$iv$iv9 = $composer3.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv9 = ComposedModifierKt.materializeModifier($composer3, modifier$iv9);
                        Function0 factory$iv$iv$iv18 = ComposeUiNode.Companion.getConstructor();
                        int $changed$iv$iv$iv9 = (($changed$iv$iv9 << 6) & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer3, -553112988, str12);
                        if (!($composer3.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer3.startReusableNode();
                        if ($composer3.getInserting()) {
                            factory$iv$iv$iv6 = factory$iv$iv$iv18;
                            $composer3.createNode(factory$iv$iv$iv6);
                        } else {
                            factory$iv$iv$iv6 = factory$iv$iv$iv18;
                            $composer3.useNode();
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv9 = Updater.constructor-impl($composer3);
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv9, measurePolicy$iv9, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv9, localMap$iv$iv9, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Updater.init-impl($this$Layout_u24lambda_u240$iv$iv9, Integer.valueOf(compositeKeyHash$iv$iv10), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv9, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv9, materialized$iv$iv9, ComposeUiNode.Companion.getSetModifier());
                        int i26 = ($changed$iv$iv$iv9 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                        int i27 = ((390 >> 6) & 112) | 6;
                        RowScope $this$PurchaseButtonComponent_u24lambda_u244_u244_u2411_u243_u242 = RowScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart($composer3, 554390958, "C817@39123L789,831@39941L63,832@40033L763,846@40825L63,847@40917L789:BottomContainer.kt#u9475x");
                        String countDownPrefix = countDownInfo.getCountDownPrefix();
                        TextKt.Text-Nvy7gAk(countDownPrefix == null ? str3 : countDownPrefix, $this$PurchaseButtonComponent_u24lambda_u244_u244_u2411_u243_u242.alignByBaseline(Modifier.Companion), purchaseTextColor, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, ProvideUiScaleKt.scaled(new TextStyle(0L, TextUnitKt.getSp(10), FontWeight.Companion.getNormal(), (FontStyle) null, (FontSynthesis) null, FontFamily.Companion.getMonospace(), "tnum", 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(14), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646041, (DefaultConstructorMarker) null), PurchaseButtonComponent$lambda$2(scaleModel$delegate).getScale()), $composer3, 0, 24576, 114680);
                        SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(4, PurchaseButtonComponent$lambda$2(scaleModel$delegate).getScale())), $composer3, 0);
                        TextKt.Text-Nvy7gAk(countDownText, $this$PurchaseButtonComponent_u24lambda_u244_u244_u2411_u243_u242.alignByBaseline(Modifier.Companion), purchaseTextColor, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, ProvideUiScaleKt.scaled(new TextStyle(0L, TextUnitKt.getSp(10), FontWeight.Companion.getNormal(), (FontStyle) null, (FontSynthesis) null, FontFamily.Companion.getMonospace(), "tnum", 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(14), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646041, (DefaultConstructorMarker) null), PurchaseButtonComponent$lambda$2(scaleModel$delegate).getScale()), $composer3, 0, 24576, 114680);
                        SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(4, PurchaseButtonComponent$lambda$2(scaleModel$delegate).getScale())), $composer3, 0);
                        String countDownSuffix = countDownInfo.getCountDownSuffix();
                        TextKt.Text-Nvy7gAk(countDownSuffix == null ? str3 : countDownSuffix, $this$PurchaseButtonComponent_u24lambda_u244_u244_u2411_u243_u242.alignByBaseline(Modifier.Companion), purchaseTextColor, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, ProvideUiScaleKt.scaled(new TextStyle(0L, TextUnitKt.getSp(10), FontWeight.Companion.getNormal(), (FontStyle) null, (FontSynthesis) null, FontFamily.Companion.getMonospace(), "tnum", 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(14), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646041, (DefaultConstructorMarker) null), PurchaseButtonComponent$lambda$2(scaleModel$delegate).getScale()), $composer3, 0, 24576, 114680);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        $composer3.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        $composer3.endReplaceGroup();
                    } else if ((countDownInfo != null ? countDownInfo.getTimeText() : null) != null) {
                        $composer3.startReplaceGroup(-637416509);
                        ComposerKt.sourceInformation($composer3, "866@41998L9,863@41823L240");
                        String text = countDownInfo.getTimeText().getText();
                        TextKt.Text-Nvy7gAk(text == null ? str3 : text, (Modifier) null, Color.Companion.getWhite-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, ProvideUiScaleKt.scaled(BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT10(), PurchaseButtonComponent$lambda$2(scaleModel$delegate).getScale()), $composer3, 384, 0, 131066);
                        $composer3.endReplaceGroup();
                    } else {
                        if (data2.getButtonSubText() != null) {
                            $composer3.startReplaceGroup(-637093706);
                            ComposerKt.sourceInformation($composer3, "872@42305L9,869@42149L221");
                            TextKt.Text-Nvy7gAk(data2.getButtonSubText(), (Modifier) null, Color.Companion.getWhite-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, ProvideUiScaleKt.scaled(BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT10(), PurchaseButtonComponent$lambda$2(scaleModel$delegate).getScale()), $composer3, 384, 0, 131066);
                        } else {
                            $composer3.startReplaceGroup(-678889053);
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
                    ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                    $composer$iv$iv$iv2.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv2);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv);
                    $composer$iv$iv$iv.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }
            str3 = "";
            $composer3.startReplaceGroup(1395289145);
            $composer3.endReplaceGroup();
            Arrangement.Vertical verticalArrangement$iv2 = Arrangement.INSTANCE.getCenter();
            Alignment.Horizontal horizontalAlignment$iv2 = Alignment.Companion.getCenterHorizontally();
            ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Modifier modifier$iv72 = Modifier.Companion;
            MeasurePolicy measurePolicy$iv72 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv2, horizontalAlignment$iv2, $composer3, ((432 >> 3) & 14) | ((432 >> 3) & 112));
            int $changed$iv$iv72 = (432 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, purchaseFontColor2);
            int compositeKeyHash$iv$iv82 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv72 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv72 = ComposedModifierKt.materializeModifier($composer3, modifier$iv72);
            Function0 factory$iv$iv$iv162 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv72 = (($changed$iv$iv72 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, str12);
            if (!($composer3.getApplier() instanceof Applier)) {
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
            }
            Composer $this$Layout_u24lambda_u240$iv$iv72 = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv72, measurePolicy$iv72, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv72, localMap$iv$iv72, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv72, Integer.valueOf(compositeKeyHash$iv$iv82), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv72, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv72, materialized$iv$iv72, ComposeUiNode.Companion.getSetModifier());
            int i222 = ($changed$iv$iv$iv72 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope2 = ColumnScopeInstance.INSTANCE;
            int i232 = ((432 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -645449600, "C711@33558L4816,808@38744L100,806@38609L262:BottomContainer.kt#u9475x");
            buttonText = data2.getButtonText();
            if (buttonText == null) {
            }
            String buttonText22 = buttonText;
            buttonPriceDescVO = data2.getButtonPriceDescVO();
            Alignment.Vertical verticalAlignment$iv32 = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Modifier modifier$iv82 = Modifier.Companion;
            Arrangement.Horizontal horizontalArrangement$iv32 = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv82 = RowKt.rowMeasurePolicy(horizontalArrangement$iv32, verticalAlignment$iv32, $composer3, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv82 = (384 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, purchaseFontColor2);
            int compositeKeyHash$iv$iv92 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv82 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv82 = ComposedModifierKt.materializeModifier($composer3, modifier$iv82);
            Function0 factory$iv$iv$iv172 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv82 = (($changed$iv$iv82 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, str12);
            if (!($composer3.getApplier() instanceof Applier)) {
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
            }
            Composer $this$Layout_u24lambda_u240$iv$iv82 = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv82, measurePolicy$iv82, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv82, localMap$iv$iv82, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv82, Integer.valueOf(compositeKeyHash$iv$iv92), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv82, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv82, materialized$iv$iv82, ComposeUiNode.Companion.getSetModifier());
            int i242 = ($changed$iv$iv$iv82 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i252 = ((384 >> 6) & 112) | 6;
            RowScope $this$PurchaseButtonComponent_u24lambda_u244_u244_u2411_u243_u2402 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, 1570707203, "C714@33683L1015:BottomContainer.kt#u9475x");
            TextKt.Text-Nvy7gAk(buttonText22, $this$PurchaseButtonComponent_u24lambda_u244_u244_u2411_u243_u2402.alignByBaseline(Modifier.Companion), purchaseTextColor, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, buttonText22.length() <= 6 ? ProvideUiScaleKt.scaled(new TextStyle(0L, TextUnitKt.getSp(14), FontWeight.Companion.getMedium(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(20), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646137, (DefaultConstructorMarker) null), PurchaseButtonComponent$lambda$2(scaleModel$delegate).getScale()) : ProvideUiScaleKt.scaled(new TextStyle(0L, TextUnitKt.getSp(16), FontWeight.Companion.getMedium(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(20), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646137, (DefaultConstructorMarker) null), PurchaseButtonComponent$lambda$2(scaleModel$delegate).getScale()), $composer3, 0, 24576, 114680);
            if (buttonPriceDescVO == null) {
            }
            $composer3.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            CountDownInfoVO countDownInfo2 = data2.getButtonSubCountDownInfo();
            if (countDownInfo2 != null) {
            }
            showCountDown = z3;
            if (countDownInfo2 == null) {
            }
            ComposerKt.sourceInformationMarkerStart($composer3, 2057550275, "CC(remember):BottomContainer.kt#9igjgp");
            invalid$iv = $composer3.changedInstance(pageViewModel2);
            it$iv = $composer3.rememberedValue();
            if (!invalid$iv) {
            }
            Object value$iv112 = new Function0() { // from class: kntr.app.mall.product.details.page.ui.container.BottomContainerKt$$ExternalSyntheticLambda20
                public final Object invoke() {
                    Unit PurchaseButtonComponent$lambda$4$4$11$3$1$0;
                    PurchaseButtonComponent$lambda$4$4$11$3$1$0 = BottomContainerKt.PurchaseButtonComponent$lambda$4$4$11$3$1$0(PageViewModel.this);
                    return PurchaseButtonComponent$lambda$4$4$11$3$1$0;
                }
            };
            $composer3.updateRememberedValue(value$iv112);
            it$iv = value$iv112;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            String countDownText2 = MergeAtmospherePriceFloorComponentKt.rememberCountdown(leftTime, (Function0) it$iv, $composer3, 0, 0);
            if (!showCountDown) {
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
            ComposerKt.sourceInformationMarkerEnd($composer$iv3);
            $composer$iv$iv$iv2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv2);
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv2);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            $composer$iv$iv$iv.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            if (ComposerKt.isTraceInProgress()) {
            }
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            modifier2 = modifier;
            data2 = data;
            onPurchaseButton = function02;
            mergeCartBuyButton2 = mergeCartBuyButton;
            mergeCartBuyButtonType2 = mergeCartBuyButtonType;
            showSkinCover2 = showSkinCover;
            addCartData2 = addCartButton;
            onAddButton2 = onAddButton;
        }
        ScopeUpdateScope endRestartGroup2 = $composer2.endRestartGroup();
        if (endRestartGroup2 != null) {
            final Modifier modifier15 = modifier2;
            final FooterFloor.PurchaseButton purchaseButton2 = data2;
            final FooterFloor.AddCartButton addCartButton3 = addCartData2;
            final Function0 function05 = onAddButton2;
            final Function0 function06 = onPurchaseButton;
            final boolean z4 = mergeCartBuyButton2;
            final Integer num2 = mergeCartBuyButtonType2;
            final boolean z5 = showSkinCover2;
            endRestartGroup2.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.container.BottomContainerKt$$ExternalSyntheticLambda22
                public final Object invoke(Object obj, Object obj2) {
                    Unit PurchaseButtonComponent$lambda$5;
                    PurchaseButtonComponent$lambda$5 = BottomContainerKt.PurchaseButtonComponent$lambda$5(PageViewModelWrapper.this, modifier15, purchaseButton2, addCartButton3, function05, function06, z4, num2, z5, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return PurchaseButtonComponent$lambda$5;
                }
            });
        }
    }

    private static final UiScaleModel PurchaseButtonComponent$lambda$2(State<UiScaleModel> state) {
        Object thisObj$iv = state.getValue();
        return (UiScaleModel) thisObj$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PurchaseButtonComponent$lambda$4$1$0(Function0 $onAddButton) {
        $onAddButton.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PurchaseButtonComponent$lambda$4$2$0(PageViewModel $pageViewModel) {
        PageActionHandler.trackEvent$product_details_page_debug$default($pageViewModel.getActionHandler$product_details_page_debug(), TrackConsts.MALL_MALL_DETAIL_BUTTON_ADDCART_0_SHOW, null, false, false, 10, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PurchaseButtonComponent$lambda$4$4$1$0(Function0 $onAddButton) {
        $onAddButton.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PurchaseButtonComponent$lambda$4$4$2$0(PageViewModel $pageViewModel) {
        PageActionHandler.trackEvent$product_details_page_debug$default($pageViewModel.getActionHandler$product_details_page_debug(), TrackConsts.MALL_MALL_DETAIL_BUTTON_ADDCART_0_SHOW, null, false, false, 10, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PurchaseButtonComponent$lambda$4$4$5$0(Function0 $onAddButton) {
        $onAddButton.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PurchaseButtonComponent$lambda$4$4$6$0(PageViewModel $pageViewModel) {
        PageActionHandler.trackEvent$product_details_page_debug$default($pageViewModel.getActionHandler$product_details_page_debug(), TrackConsts.MALL_MALL_DETAIL_BUTTON_ADDCART_0_SHOW, null, false, false, 10, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PurchaseButtonComponent$lambda$4$4$9$0(Function0 $onPurchaseButton) {
        $onPurchaseButton.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PurchaseButtonComponent$lambda$4$4$10$0(PageViewModel $pageViewModel) {
        PageActionHandler.trackEvent$product_details_page_debug$default($pageViewModel.getActionHandler$product_details_page_debug(), TrackConsts.MALL_MALL_DETAIL_BUTTON_BUYNOW_0_SHOW, null, false, false, 10, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PurchaseButtonComponent$lambda$4$4$11$3$1$0(PageViewModel $pageViewModel) {
        $pageViewModel.reloadProductDetails$product_details_page_debug();
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v27 */
    public static final void IconTextButton(final String iconUrl, final String text, final boolean isLike, final float scale, Modifier modifier, Function0<Unit> function0, boolean needClip, String iconOutlineColor, Composer $composer, final int $changed, final int i) {
        Function0 onClick;
        boolean needClip2;
        int $dirty;
        Composer $composer2;
        Modifier modifier2;
        String iconOutlineColor2;
        Function0 onClick2;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        boolean needClip3;
        String iconOutlineColor3;
        Modifier modifier3;
        Intrinsics.checkNotNullParameter(iconUrl, "iconUrl");
        Intrinsics.checkNotNullParameter(text, "text");
        Composer $composer3 = $composer.startRestartGroup(-1641819277);
        ComposerKt.sourceInformation($composer3, "C(IconTextButton)N(iconUrl,text,isLike,scale,modifier,onClick,needClip,iconOutlineColor)889@42634L2,893@42715L2113:BottomContainer.kt#u9475x");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer3.changed(iconUrl) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty2 |= $composer3.changed(text) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty2 |= $composer3.changed(isLike) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty2 |= $composer3.changed(scale) ? 2048 : 1024;
        }
        int i2 = i & 16;
        if (i2 != 0) {
            $dirty2 |= 24576;
        } else if (($changed & 24576) == 0) {
            $dirty2 |= $composer3.changed(modifier) ? 16384 : 8192;
        }
        int i3 = i & 32;
        if (i3 != 0) {
            $dirty2 |= 196608;
            onClick = function0;
        } else if ((196608 & $changed) == 0) {
            onClick = function0;
            $dirty2 |= $composer3.changedInstance(onClick) ? 131072 : 65536;
        } else {
            onClick = function0;
        }
        int i4 = i & 64;
        if (i4 != 0) {
            $dirty2 |= 1572864;
            needClip2 = needClip;
        } else if ((1572864 & $changed) == 0) {
            needClip2 = needClip;
            $dirty2 |= $composer3.changed(needClip2) ? 1048576 : 524288;
        } else {
            needClip2 = needClip;
        }
        int i5 = i & 128;
        if (i5 != 0) {
            $dirty2 |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty2 |= $composer3.changed(iconOutlineColor) ? 8388608 : 4194304;
        }
        if ($composer3.shouldExecute(($dirty2 & 4793491) != 4793490, $dirty2 & 1)) {
            Modifier modifier4 = i2 != 0 ? (Modifier) Modifier.Companion : modifier;
            if (i3 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer3, -1535322475, "CC(remember):BottomContainer.kt#9igjgp");
                Object it$iv = $composer3.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function0() { // from class: kntr.app.mall.product.details.page.ui.container.BottomContainerKt$$ExternalSyntheticLambda14
                        public final Object invoke() {
                            Unit unit;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                onClick2 = it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer3);
            } else {
                onClick2 = onClick;
            }
            boolean needClip4 = i4 != 0 ? false : needClip2;
            String iconOutlineColor4 = i5 != 0 ? null : iconOutlineColor;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1641819277, $dirty2, -1, "kntr.app.mall.product.details.page.ui.container.IconTextButton (BottomContainer.kt:892)");
            }
            Modifier modifier$iv = ClickableKt.clickable-oSLSa3U$default(modifier4, false, (String) null, (Role) null, (MutableInteractionSource) null, onClick2, 15, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (0 << 3) & 112;
            modifier2 = modifier4;
            Function0 onClick3 = onClick2;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            $composer2 = $composer3;
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
            int i6 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            int i7 = ((0 >> 6) & 112) | 6;
            BoxScope $this$IconTextButton_u24lambda_u241 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, 1605443515, "C899@42897L1445,939@44526L6,934@44351L471:BottomContainer.kt#u9475x");
            float size = ProvideUiScaleKt.dpScaled(isLike ? 44 : 24, scale);
            Modifier modifier$iv2 = SizeKt.size-3ABfNKs(OffsetKt.offset-VpY3zN4$default($this$IconTextButton_u24lambda_u241.align(Modifier.Companion, Alignment.Companion.getTopCenter()), 0.0f, Dp.constructor-impl(Dp.constructor-impl(-Dp.constructor-impl(size - ProvideUiScaleKt.dpScaled(24, scale))) / 2), 1, (Object) null), size);
            ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv2 = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
            int $changed$iv$iv2 = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer3, modifier$iv2);
            Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            $dirty = $dirty2;
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
            int i8 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            int i9 = ((0 >> 6) & 112) | 6;
            BoxScope $this$IconTextButton_u24lambda_u241_u240 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, 1847635337, "C906@43121L1211:BottomContainer.kt#u9475x");
            String $this$asRequest$iv = HelperKt.customizedImageUrl(iconUrl);
            ImageRequest $this$IconTextButton_u24lambda_u241_u240_u240 = new ImageRequest($this$asRequest$iv);
            $this$IconTextButton_u24lambda_u241_u240_u240.enableAnimate(isLike);
            $this$IconTextButton_u24lambda_u241_u240_u240.m1485animateLoopCountSW3asMM(LoopCount.m1495constructorimpl(1));
            $this$IconTextButton_u24lambda_u241_u240_u240.autoPlay(true);
            ImmutableImageRequest build = $this$IconTextButton_u24lambda_u241_u240_u240.build();
            Modifier matchParentSize = $this$IconTextButton_u24lambda_u241_u240.matchParentSize(Modifier.Companion);
            if (needClip4) {
                String str = iconOutlineColor4;
                long borderColor = !(str == null || str.length() == 0) ? ComposeColorParserKt.parseColor(iconOutlineColor4) : ColorKt.Color(4293125607L);
                needClip3 = needClip4;
                iconOutlineColor3 = iconOutlineColor4;
                modifier3 = BorderKt.border-xT4_qwU(ClipKt.clip(Modifier.Companion, RoundedCornerShapeKt.RoundedCornerShape(50)), ProvideUiScaleKt.dpScaled(0.5d, scale), borderColor, RoundedCornerShapeKt.RoundedCornerShape(50));
            } else {
                needClip3 = needClip4;
                iconOutlineColor3 = iconOutlineColor4;
                modifier3 = Modifier.Companion;
            }
            BiliImageKt.BiliImage(build, matchParentSize.then(modifier3), null, null, null, null, null, null, null, $composer3, 0, 508);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            int i10 = TextAlign.Companion.getCenter-e0LSkKk();
            TextKt.Text-Nvy7gAk(text, $this$IconTextButton_u24lambda_u241.align(Modifier.Companion, Alignment.Companion.getBottomCenter()), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText2-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(i10), 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, ProvideUiScaleKt.scaled(new TextStyle(0L, TextUnitKt.getSp(10), FontWeight.Companion.getNormal(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(14), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646137, (DefaultConstructorMarker) null), scale), $composer3, ($dirty >> 3) & 14, 24960, 109560);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            needClip2 = needClip3;
            iconOutlineColor2 = iconOutlineColor3;
            onClick = onClick3;
        } else {
            $dirty = $dirty2;
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            modifier2 = modifier;
            iconOutlineColor2 = iconOutlineColor;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier2;
            final Function0 function02 = onClick;
            final boolean z = needClip2;
            final String str2 = iconOutlineColor2;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.container.BottomContainerKt$$ExternalSyntheticLambda15
                public final Object invoke(Object obj, Object obj2) {
                    Unit IconTextButton$lambda$2;
                    IconTextButton$lambda$2 = BottomContainerKt.IconTextButton$lambda$2(iconUrl, text, isLike, scale, modifier5, function02, z, str2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return IconTextButton$lambda$2;
                }
            });
        }
    }

    private static final String formatWishCount(int count) {
        String result;
        if (count > 10000) {
            double wan = count / 10000.0d;
            double rounded = ((int) (10 * wan)) / 10.0d;
            if (rounded == ((double) ((int) rounded))) {
                result = String.valueOf((int) rounded);
            } else {
                result = String.valueOf(rounded);
            }
            return result + "万人";
        }
        return String.valueOf(count);
    }
}