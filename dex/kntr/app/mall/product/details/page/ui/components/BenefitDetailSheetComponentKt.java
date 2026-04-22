package kntr.app.mall.product.details.page.ui.components;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import com.bilibili.compose.iconfont.BiliIconfont;
import com.bilibili.compose.theme.BiliTheme;
import java.util.List;
import kntr.app.mall.product.details.page.api.model.BasicInfoFloor;
import kntr.app.mall.product.details.page.ui.scale.ProvideUiScaleKt;
import kntr.app.mall.product.details.page.utils.HelperKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.imageloader.BiliImageKt;
import kntr.base.imageloader.ImageRequest;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BenefitDetailSheetComponent.kt */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\u001a3\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0001¢\u0006\u0002\u0010\n\u001a+\u0010\u000b\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0003¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"BenefitDetailSheetComponent", "", "benefitInfo", "Lkntr/app/mall/product/details/page/api/model/BasicInfoFloor$ItemsBenefitsInfo;", "show", "", "onDismiss", "Lkotlin/Function0;", "scale", "", "(Lkntr/app/mall/product/details/page/api/model/BasicInfoFloor$ItemsBenefitsInfo;ZLkotlin/jvm/functions/Function0;FLandroidx/compose/runtime/Composer;I)V", "BenefitDetailContent", "onClose", "(Lkntr/app/mall/product/details/page/api/model/BasicInfoFloor$ItemsBenefitsInfo;Lkotlin/jvm/functions/Function0;FLandroidx/compose/runtime/Composer;I)V", "product-details-page_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class BenefitDetailSheetComponentKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BenefitDetailContent$lambda$1(BasicInfoFloor.ItemsBenefitsInfo itemsBenefitsInfo, Function0 function0, float f, int i, Composer composer, int i2) {
        BenefitDetailContent(itemsBenefitsInfo, function0, f, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BenefitDetailSheetComponent$lambda$1(BasicInfoFloor.ItemsBenefitsInfo itemsBenefitsInfo, boolean z, Function0 function0, float f, int i, Composer composer, int i2) {
        BenefitDetailSheetComponent(itemsBenefitsInfo, z, function0, f, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void BenefitDetailSheetComponent(final BasicInfoFloor.ItemsBenefitsInfo benefitInfo, final boolean show, final Function0<Unit> function0, final float scale, Composer $composer, final int $changed) {
        Intrinsics.checkNotNullParameter(benefitInfo, "benefitInfo");
        Intrinsics.checkNotNullParameter(function0, "onDismiss");
        Composer $composer2 = $composer.startRestartGroup(602496516);
        ComposerKt.sourceInformation($composer2, "C(BenefitDetailSheetComponent)N(benefitInfo,show,onDismiss,scale)50@1914L146,39@1483L577:BenefitDetailSheetComponent.kt#o90vz8");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(benefitInfo) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(show) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changedInstance(function0) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer2.changed(scale) ? 2048 : 1024;
        }
        if (!$composer2.shouldExecute(($dirty & 1171) != 1170, $dirty & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(602496516, $dirty, -1, "kntr.app.mall.product.details.page.ui.components.BenefitDetailSheetComponent (BenefitDetailSheetComponent.kt:38)");
            }
            BottomSheetKt.m417WrapContentBottomSheethYmLsZ8(function0, show, PaddingKt.PaddingValues-a9UjIt4(ProvideUiScaleKt.dpScaled(12, scale), ProvideUiScaleKt.dpScaled(12, scale), ProvideUiScaleKt.dpScaled(12, scale), ProvideUiScaleKt.dpScaled(46, scale)), 0L, RoundedCornerShapeKt.RoundedCornerShape-a9UjIt4$default(ProvideUiScaleKt.dpScaled(12, scale), ProvideUiScaleKt.dpScaled(12, scale), 0.0f, 0.0f, 12, (Object) null), false, ComposableLambdaKt.rememberComposableLambda(1358337228, true, new Function3() { // from class: kntr.app.mall.product.details.page.ui.components.BenefitDetailSheetComponentKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit BenefitDetailSheetComponent$lambda$0;
                    BenefitDetailSheetComponent$lambda$0 = BenefitDetailSheetComponentKt.BenefitDetailSheetComponent$lambda$0(BasicInfoFloor.ItemsBenefitsInfo.this, function0, scale, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return BenefitDetailSheetComponent$lambda$0;
                }
            }, $composer2, 54), $composer2, (($dirty >> 6) & 14) | 1572864 | ($dirty & 112), 40);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.BenefitDetailSheetComponentKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    Unit BenefitDetailSheetComponent$lambda$1;
                    BenefitDetailSheetComponent$lambda$1 = BenefitDetailSheetComponentKt.BenefitDetailSheetComponent$lambda$1(BasicInfoFloor.ItemsBenefitsInfo.this, show, function0, scale, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return BenefitDetailSheetComponent$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BenefitDetailSheetComponent$lambda$0(BasicInfoFloor.ItemsBenefitsInfo $benefitInfo, Function0 $onDismiss, float $scale, ColumnScope $this$WrapContentBottomSheet, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$WrapContentBottomSheet, "$this$WrapContentBottomSheet");
        ComposerKt.sourceInformation($composer, "C51@1924L130:BenefitDetailSheetComponent.kt#o90vz8");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1358337228, $changed, -1, "kntr.app.mall.product.details.page.ui.components.BenefitDetailSheetComponent.<anonymous> (BenefitDetailSheetComponent.kt:51)");
            }
            BenefitDetailContent($benefitInfo, $onDismiss, $scale, $composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:53:0x0332, code lost:
        if (r11 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L50;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void BenefitDetailContent(final BasicInfoFloor.ItemsBenefitsInfo benefitInfo, final Function0<Unit> function0, final float scale, Composer $composer, final int $changed) {
        Composer $composer2;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        String str;
        Unit unit;
        Composer $composer3 = $composer.startRestartGroup(200536335);
        ComposerKt.sourceInformation($composer3, "C(BenefitDetailContent)N(benefitInfo,onClose,scale)68@2230L2833:BenefitDetailSheetComponent.kt#o90vz8");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changedInstance(benefitInfo) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changedInstance(function0) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer3.changed(scale) ? 256 : 128;
        }
        if (!$composer3.shouldExecute(($dirty & 147) != 146, $dirty & 1)) {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(200536335, $dirty, -1, "kntr.app.mall.product.details.page.ui.components.BenefitDetailContent (BenefitDetailSheetComponent.kt:67)");
            }
            Modifier modifier$iv = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getCenterHorizontally();
            ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((390 >> 3) & 14) | ((390 >> 3) & 112));
            int $changed$iv$iv = (390 << 3) & 112;
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
            $composer2 = $composer3;
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i2 = ((390 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 651769517, "C73@2372L728,93@3109L54,100@3355L9,101@3414L6,96@3191L465,110@3680L54:BenefitDetailSheetComponent.kt#o90vz8");
            Modifier modifier$iv2 = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv2 = (6 << 3) & 112;
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
            int i3 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            int i4 = ((6 >> 6) & 112) | 6;
            BoxScope $this$BenefitDetailContent_u24lambda_u240_u240 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, 2057938872, "C76@2495L9,77@2559L6,74@2426L221,81@2705L20,82@2760L6,87@2967L65,80@2660L430:BenefitDetailSheetComponent.kt#o90vz8");
            TextKt.Text-Nvy7gAk("特典", $this$BenefitDetailContent_u24lambda_u240_u240.align(Modifier.Companion, Alignment.Companion.getCenter()), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, ProvideUiScaleKt.scaled(BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT16b(), scale), $composer3, 6, 0, 131064);
            Painter xmark_close_line_500 = BiliIconfont.INSTANCE.getXmark_close_line_500($composer3, 6);
            long j = BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText3-0d7_KjU();
            Modifier modifier = SizeKt.size-3ABfNKs($this$BenefitDetailContent_u24lambda_u240_u240.align(Modifier.Companion, Alignment.Companion.getCenterEnd()), ProvideUiScaleKt.dpScaled(24, scale));
            ComposerKt.sourceInformationMarkerStart($composer3, -1873260812, "CC(remember):BenefitDetailSheetComponent.kt#9igjgp");
            boolean invalid$iv = ($dirty & 112) == 32;
            Object it$iv = $composer3.rememberedValue();
            if (invalid$iv) {
            }
            Object value$iv = new Function0() { // from class: kntr.app.mall.product.details.page.ui.components.BenefitDetailSheetComponentKt$$ExternalSyntheticLambda0
                public final Object invoke() {
                    Unit BenefitDetailContent$lambda$0$0$0$0;
                    BenefitDetailContent$lambda$0$0$0$0 = BenefitDetailSheetComponentKt.BenefitDetailContent$lambda$0$0$0$0(function0);
                    return BenefitDetailContent$lambda$0$0$0$0;
                }
            };
            $composer3.updateRememberedValue(value$iv);
            it$iv = value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            IconKt.Icon-ww6aTOc(xmark_close_line_500, (String) null, ClickableKt.clickable-oSLSa3U$default(modifier, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null), j, $composer3, Painter.$stable | 48, 0);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(12, scale)), $composer3, 0);
            String benefitsExplain = benefitInfo.getBenefitsExplain();
            if (benefitsExplain != null) {
                str = benefitsExplain;
            } else {
                str = "特典是随商品主体额外赠送的数量限定的赠品，数量稀有且让商品具有不同的意义哦！";
            }
            TextKt.Text-Nvy7gAk(str, PaddingKt.padding-VpY3zN4(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), ProvideUiScaleKt.dpScaled(12, scale), ProvideUiScaleKt.dpScaled(0, scale)), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, ProvideUiScaleKt.scaled(BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT12(), scale), $composer3, 0, 0, 130040);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(24, scale)), $composer3, 0);
            List<BasicInfoFloor.ItemsBenefitsInfo.BenefitsSku> benefitsSkuList = benefitInfo.getBenefitsSkuList();
            BasicInfoFloor.ItemsBenefitsInfo.BenefitsSku sku = benefitsSkuList != null ? (BasicInfoFloor.ItemsBenefitsInfo.BenefitsSku) CollectionsKt.firstOrNull(benefitsSkuList) : null;
            if (sku == null) {
                $composer3.startReplaceGroup(653136863);
                $composer3.endReplaceGroup();
                unit = null;
            } else {
                $composer3.startReplaceGroup(653136864);
                ComposerKt.sourceInformation($composer3, "*132@4485L9,133@4548L6,130@4401L300");
                String specImg = sku.getSpecImg();
                if (!(specImg == null || specImg.length() == 0)) {
                    $composer3.startReplaceGroup(-1371147001);
                    ComposerKt.sourceInformation($composer3, "116@3909L342,126@4299L54");
                    String $this$asRequest_u24default$iv = HelperKt.customizedImageUrl(sku.getSpecImg());
                    ImageRequest imageRequest = new ImageRequest($this$asRequest_u24default$iv);
                    Unit unit2 = Unit.INSTANCE;
                    BiliImageKt.BiliImage(imageRequest.build(), ClipKt.clip(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), ProvideUiScaleKt.dpScaled(248, scale)), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(ProvideUiScaleKt.dpScaled(8, scale))), null, null, null, null, null, null, null, $composer3, 0, 508);
                    SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(12, scale)), $composer3, 0);
                } else {
                    $composer3.startReplaceGroup(-1374997635);
                }
                $composer3.endReplaceGroup();
                String specName = sku.getSpecName();
                if (specName == null) {
                    specName = "无";
                }
                TextKt.Text-Nvy7gAk(specName, SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), ProvideUiScaleKt.dpScaled(100, scale)), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, ProvideUiScaleKt.scaled(BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT14(), scale), $composer3, 0, 0, 130040);
                Unit unit3 = Unit.INSTANCE;
                $composer3.endReplaceGroup();
                unit = Unit.INSTANCE;
            }
            if (unit == null) {
                $composer3.startReplaceGroup(654021139);
                ComposerKt.sourceInformation($composer3, "*141@4831L9,142@4894L6,139@4763L284");
                TextKt.Text-Nvy7gAk("无", SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), ProvideUiScaleKt.dpScaled(100, scale)), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, ProvideUiScaleKt.scaled(BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT14(), scale), $composer3, 6, 0, 130040);
                Unit unit4 = Unit.INSTANCE;
                $composer3.endReplaceGroup();
            } else {
                $composer3.startReplaceGroup(-1087310744);
                $composer3.endReplaceGroup();
            }
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
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.BenefitDetailSheetComponentKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit BenefitDetailContent$lambda$1;
                    BenefitDetailContent$lambda$1 = BenefitDetailSheetComponentKt.BenefitDetailContent$lambda$1(BasicInfoFloor.ItemsBenefitsInfo.this, function0, scale, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return BenefitDetailContent$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BenefitDetailContent$lambda$0$0$0$0(Function0 $onClose) {
        $onClose.invoke();
        return Unit.INSTANCE;
    }
}