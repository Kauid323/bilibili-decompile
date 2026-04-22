package kntr.app.mall.product.details.page.ui.components;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
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
import androidx.compose.runtime.LongState;
import androidx.compose.runtime.MutableLongState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotLongStateKt;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
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
import androidx.compose.ui.unit.TextUnitKt;
import kntr.app.mall.product.details.page.api.model.CountDownInfoVO;
import kntr.app.mall.product.details.page.api.model.CrowdfundingAtmosFloor;
import kntr.app.mall.product.details.page.api.model.ImageColorModel;
import kntr.app.mall.product.details.page.api.model.TextColorModel;
import kntr.app.mall.product.details.page.ui.scale.ProvideUiScaleKt;
import kntr.app.mall.product.details.page.ui.scale.UiScaleModel;
import kntr.app.mall.product.details.page.utils.DateFormatKt;
import kntr.app.mall.product.details.page.utils.HelperKt;
import kntr.app.mall.product.details.page.utils.ThemesKt;
import kntr.app.mall.product.details.page.vm.ContentModule;
import kntr.app.mall.product.details.page.vm.PageViewModel;
import kntr.app.mall.product.details.page.vm.PageViewModelWrapper;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.imageloader.BiliImageKt;
import kntr.base.imageloader.ImageRequest;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.TimeSource;

/* compiled from: CrowdfundingAtmosFloorComponent.kt */
@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0001¢\u0006\u0002\u0010\b\u001a7\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\u000fH\u0003¢\u0006\u0002\u0010\u0010¨\u0006\u0011²\u0006\n\u0010\u0012\u001a\u00020\u0013X\u008a\u0084\u0002²\u0006\n\u0010\u0014\u001a\u00020\u0015X\u008a\u008e\u0002²\u0006\n\u0010\u0016\u001a\u00020\u0015X\u008a\u008e\u0002²\u0006\n\u0010\u0017\u001a\u00020\u0015X\u008a\u008e\u0002²\u0006\n\u0010\u0018\u001a\u00020\u0015X\u008a\u008e\u0002²\u0006\n\u0010\u0019\u001a\u00020\u001aX\u008a\u008e\u0002"}, d2 = {"CrowdfundingAtmosFloorComponent", "", "module", "Lkntr/app/mall/product/details/page/vm/ContentModule;", "pageVMWrapper", "Lkntr/app/mall/product/details/page/vm/PageViewModelWrapper;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lkntr/app/mall/product/details/page/vm/ContentModule;Lkntr/app/mall/product/details/page/vm/PageViewModelWrapper;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "CountDownComponent", "countDownInfo", "Lkntr/app/mall/product/details/page/api/model/CountDownInfoVO;", "scale", "", "onCountdownEnd", "Lkotlin/Function0;", "(Lkntr/app/mall/product/details/page/api/model/CountDownInfoVO;FLandroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "product-details-page_debug", "scaleModel", "Lkntr/app/mall/product/details/page/ui/scale/UiScaleModel;", "days", "", "hours", "minutes", "seconds", "ended", ""}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class CrowdfundingAtmosFloorComponentKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CountDownComponent$lambda$1(CountDownInfoVO countDownInfoVO, float f, Modifier modifier, Function0 function0, int i, int i2, Composer composer, int i3) {
        CountDownComponent(countDownInfoVO, f, modifier, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CountDownComponent$lambda$23(CountDownInfoVO countDownInfoVO, float f, Modifier modifier, Function0 function0, int i, int i2, Composer composer, int i3) {
        CountDownComponent(countDownInfoVO, f, modifier, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CrowdfundingAtmosFloorComponent$lambda$0(ContentModule contentModule, PageViewModelWrapper pageViewModelWrapper, Modifier modifier, int i, int i2, Composer composer, int i3) {
        CrowdfundingAtmosFloorComponent(contentModule, pageViewModelWrapper, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CrowdfundingAtmosFloorComponent$lambda$3(ContentModule contentModule, PageViewModelWrapper pageViewModelWrapper, Modifier modifier, int i, int i2, Composer composer, int i3) {
        CrowdfundingAtmosFloorComponent(contentModule, pageViewModelWrapper, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:149:0x0731, code lost:
        if (r0 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L121;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v46 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void CrowdfundingAtmosFloorComponent(final ContentModule module, final PageViewModelWrapper pageVMWrapper, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Composer $composer2;
        Modifier modifier3;
        Modifier modifier4;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Function0 factory$iv$iv$iv3;
        Function0 factory$iv$iv$iv4;
        Composer $composer$iv$iv;
        Composer $composer$iv;
        Intrinsics.checkNotNullParameter(module, "module");
        Intrinsics.checkNotNullParameter(pageVMWrapper, "pageVMWrapper");
        Composer $composer3 = $composer.startRestartGroup(-936920128);
        ComposerKt.sourceInformation($composer3, "C(CrowdfundingAtmosFloorComponent)N(module,pageVMWrapper,modifier)67@2857L16,69@2911L4086:CrowdfundingAtmosFloorComponent.kt#o90vz8");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(module) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changedInstance(pageVMWrapper) ? 32 : 16;
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
                ComposerKt.traceEventStart(-936920128, $dirty2, -1, "kntr.app.mall.product.details.page.ui.components.CrowdfundingAtmosFloorComponent (CrowdfundingAtmosFloorComponent.kt:57)");
            }
            if (module instanceof ContentModule.CrowdfundingAtmosModule) {
                final PageViewModel pageVM = pageVMWrapper.getViewModel();
                CrowdfundingAtmosFloor floorData = ((ContentModule.CrowdfundingAtmosModule) module).getData();
                ImageColorModel backImg = floorData.getBackImg();
                ImageColorModel labelImg = floorData.getLabelImg();
                CountDownInfoVO countDownInfo = floorData.getCountDownInfoVO();
                State scaleModel$delegate = SnapshotStateKt.collectAsState(pageVM.getUiScaleModelFlow$product_details_page_debug(), (CoroutineContext) null, $composer3, 0, 1);
                float scale = CrowdfundingAtmosFloorComponent$lambda$1(scaleModel$delegate).getScale();
                Modifier modifier$iv = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, (Object) null), ProvideUiScaleKt.dpScaled(48, scale));
                ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
                MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                int $changed$iv$iv = (0 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
                CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
                Function0 factory$iv$iv$iv5 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                modifier3 = modifier4;
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
                ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScope boxScope = BoxScopeInstance.INSTANCE;
                int i4 = ((0 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, -1449234537, "C92@3661L3330:CrowdfundingAtmosFloorComponent.kt#o90vz8");
                if (backImg != null && backImg.isValid$product_details_page_debug()) {
                    $composer3.startReplaceGroup(-1449307326);
                    ComposerKt.sourceInformation($composer3, "");
                    String img = backImg.getUrl();
                    Double width = backImg.getWidth();
                    double imgWidth = width != null ? width.doubleValue() : 0.0d;
                    Double height = backImg.getHeight();
                    double imgHeight = height != null ? height.doubleValue() : 0.0d;
                    String str = img;
                    if ((str == null || str.length() == 0) || imgWidth <= 0.0d || imgHeight <= 0.0d) {
                        $composer3.startReplaceGroup(-1452382340);
                    } else {
                        $composer3.startReplaceGroup(-1449106787);
                        ComposerKt.sourceInformation($composer3, "80@3308L319");
                        String $this$asRequest$iv = HelperKt.customizedImageUrl(img);
                        ImageRequest $this$CrowdfundingAtmosFloorComponent_u24lambda_u242_u240 = new ImageRequest($this$asRequest$iv);
                        $this$CrowdfundingAtmosFloorComponent_u24lambda_u242_u240.contentScale(ContentScale.Companion.getFillBounds());
                        BiliImageKt.BiliImage($this$CrowdfundingAtmosFloorComponent_u24lambda_u242_u240.build(), SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), null, null, null, null, null, null, null, $composer3, 48, 508);
                    }
                    $composer3.endReplaceGroup();
                } else {
                    $composer3.startReplaceGroup(-1452382340);
                }
                $composer3.endReplaceGroup();
                Modifier modifier$iv2 = PaddingKt.padding-VpY3zN4$default(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), ProvideUiScaleKt.dpScaled(10, scale), 0.0f, 2, (Object) null);
                Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
                Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getSpaceBetween();
                ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((432 >> 3) & 14) | ((432 >> 3) & 112));
                int $changed$iv$iv2 = (432 << 3) & 112;
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
                ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScope rowScope = RowScopeInstance.INSTANCE;
                int i6 = ((432 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, 1444902890, "C100@3958L898,122@4870L2111:CrowdfundingAtmosFloorComponent.kt#o90vz8");
                Modifier modifier$iv3 = SizeKt.fillMaxHeight$default(Modifier.Companion, 0.0f, 1, (Object) null);
                Alignment contentAlignment$iv2 = Alignment.Companion.getCenter();
                ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv3 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
                int $changed$iv$iv3 = (54 << 3) & 112;
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
                ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
                int i8 = ((54 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, 398436174, "C:CrowdfundingAtmosFloorComponent.kt#o90vz8");
                if (labelImg != null && labelImg.isValid$product_details_page_debug()) {
                    $composer3.startReplaceGroup(398467886);
                    ComposerKt.sourceInformation($composer3, "");
                    String img2 = labelImg.getUrl();
                    Double width2 = labelImg.getWidth();
                    double imgWidth2 = width2 != null ? width2.doubleValue() : 0.0d;
                    Double height2 = labelImg.getHeight();
                    double imgHeight2 = height2 != null ? height2.doubleValue() : 0.0d;
                    String str2 = img2;
                    if (!(str2 == null || str2.length() == 0) && imgWidth2 > 0.0d && imgHeight2 > 0.0d) {
                        $composer3.startReplaceGroup(398701812);
                        ComposerKt.sourceInformation($composer3, "109@4404L398");
                        String $this$asRequest$iv2 = HelperKt.customizedImageUrl(img2);
                        BiliImageKt.BiliImage(new ImageRequest($this$asRequest$iv2).build(), SizeKt.height-3ABfNKs(SizeKt.width-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(imgWidth2, scale)), ProvideUiScaleKt.dpScaled(imgHeight2, scale)), null, null, null, null, null, null, null, $composer3, 0, 508);
                        $composer3.endReplaceGroup();
                    }
                    $composer3.startReplaceGroup(394344018);
                    $composer3.endReplaceGroup();
                } else {
                    $composer3.startReplaceGroup(394344018);
                }
                $composer3.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                Modifier modifier$iv4 = SizeKt.fillMaxHeight$default(Modifier.Companion, 0.0f, 1, (Object) null);
                Alignment contentAlignment$iv3 = Alignment.Companion.getCenter();
                ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv4 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv3, false);
                int $changed$iv$iv4 = (54 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv4 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
                CompositionLocalMap localMap$iv$iv4 = $composer3.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer3, modifier$iv4);
                Function0 factory$iv$iv$iv8 = ComposeUiNode.Companion.getConstructor();
                int $i$f$Box = $changed$iv$iv4 << 6;
                int $changed$iv$iv$iv4 = ($i$f$Box & 896) | 6;
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
                ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScope boxScope3 = BoxScopeInstance.INSTANCE;
                int i10 = ((54 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, 330510618, "C:CrowdfundingAtmosFloorComponent.kt#o90vz8");
                if (countDownInfo != null) {
                    $composer3.startReplaceGroup(330536564);
                    ComposerKt.sourceInformation($composer3, "");
                    Boolean showCountDown = countDownInfo.getShowCountDown();
                    if (!Intrinsics.areEqual(showCountDown, true)) {
                        $composer$iv$iv = $composer3;
                        $composer$iv = $composer3;
                        if (countDownInfo.getTimeText() != null) {
                            $composer3.startReplaceGroup(331010740);
                            ComposerKt.sourceInformation($composer3, "141@5858L7,152@6393L21,150@6296L631");
                            TextColorModel item = countDownInfo.getTimeText();
                            String text = item.getText();
                            String dayColor = item.getDayColor();
                            long dayColor2 = dayColor != null ? ComposeColorParserKt.parseColor(dayColor) : Color.Companion.getWhite-0d7_KjU();
                            String nightColor = item.getNightColor();
                            long nightColor2 = nightColor != null ? ComposeColorParserKt.parseColor(nightColor) : Color.Companion.getWhite-0d7_KjU();
                            CompositionLocal this_$iv = CompositionLocalsKt.getLocalDensity();
                            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object consume = $composer3.consume(this_$iv);
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            Density density = (Density) consume;
                            long Color = ColorKt.Color(4282019699L);
                            float y$iv = density.toPx-0680j_4(ProvideUiScaleKt.dpScaled(1, scale));
                            long v1$iv$iv = Float.floatToRawIntBits(0.0f);
                            long v2$iv$iv = Float.floatToRawIntBits(y$iv);
                            Shadow shadow = new Shadow(Color, Offset.constructor-impl((v1$iv$iv << 32) | (v2$iv$iv & 4294967295L)), density.toPx-0680j_4(ProvideUiScaleKt.dpScaled(1, scale)), (DefaultConstructorMarker) null);
                            TextKt.Text-Nvy7gAk(text == null ? "" : text, (Modifier) null, ThemesKt.isCurrentThemeLight($composer3, 0) ? dayColor2 : nightColor2, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, ProvideUiScaleKt.scaled(new TextStyle(0L, TextUnitKt.getSp(14), FontWeight.Companion.getW500(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, TextUnitKt.getEm(0.02d), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, shadow, (DrawStyle) null, 0, 0, TextUnitKt.getSp(20), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16637817, (DefaultConstructorMarker) null), scale), $composer3, 0, 24576, 114682);
                        } else {
                            $composer3.startReplaceGroup(325476155);
                        }
                        $composer3.endReplaceGroup();
                    } else {
                        $composer3.startReplaceGroup(330603276);
                        ComposerKt.sourceInformation($composer3, "132@5350L93,129@5183L287");
                        ComposerKt.sourceInformationMarkerStart($composer3, 287765220, "CC(remember):CrowdfundingAtmosFloorComponent.kt#9igjgp");
                        boolean invalid$iv = $composer3.changedInstance(pageVM);
                        Object value$iv = $composer3.rememberedValue();
                        if (invalid$iv) {
                        }
                        value$iv = new Function0() { // from class: kntr.app.mall.product.details.page.ui.components.CrowdfundingAtmosFloorComponentKt$$ExternalSyntheticLambda4
                            public final Object invoke() {
                                Unit CrowdfundingAtmosFloorComponent$lambda$2$1$1$0$0;
                                CrowdfundingAtmosFloorComponent$lambda$2$1$1$0$0 = CrowdfundingAtmosFloorComponentKt.CrowdfundingAtmosFloorComponent$lambda$2$1$1$0$0(PageViewModel.this);
                                return CrowdfundingAtmosFloorComponent$lambda$2$1$1$0$0;
                            }
                        };
                        $composer3.updateRememberedValue(value$iv);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        $composer$iv = $composer3;
                        $composer$iv$iv = $composer3;
                        CountDownComponent(countDownInfo, scale, null, value$iv, $composer3, 0, 4);
                        $composer3.endReplaceGroup();
                    }
                } else {
                    $composer$iv$iv = $composer3;
                    $composer$iv = $composer3;
                    $composer3.startReplaceGroup(325476155);
                }
                $composer3.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
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
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup = $composer3.endRestartGroup();
                if (endRestartGroup != null) {
                    final Modifier modifier5 = modifier4;
                    endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.CrowdfundingAtmosFloorComponentKt$$ExternalSyntheticLambda3
                        public final Object invoke(Object obj, Object obj2) {
                            Unit CrowdfundingAtmosFloorComponent$lambda$0;
                            CrowdfundingAtmosFloorComponent$lambda$0 = CrowdfundingAtmosFloorComponentKt.CrowdfundingAtmosFloorComponent$lambda$0(ContentModule.this, pageVMWrapper, modifier5, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                            return CrowdfundingAtmosFloorComponent$lambda$0;
                        }
                    });
                    return;
                }
                return;
            }
        }
        ScopeUpdateScope endRestartGroup2 = $composer2.endRestartGroup();
        if (endRestartGroup2 != null) {
            final Modifier modifier6 = modifier3;
            endRestartGroup2.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.CrowdfundingAtmosFloorComponentKt$$ExternalSyntheticLambda5
                public final Object invoke(Object obj, Object obj2) {
                    Unit CrowdfundingAtmosFloorComponent$lambda$3;
                    CrowdfundingAtmosFloorComponent$lambda$3 = CrowdfundingAtmosFloorComponentKt.CrowdfundingAtmosFloorComponent$lambda$3(ContentModule.this, pageVMWrapper, modifier6, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return CrowdfundingAtmosFloorComponent$lambda$3;
                }
            });
        }
    }

    private static final UiScaleModel CrowdfundingAtmosFloorComponent$lambda$1(State<UiScaleModel> state) {
        Object thisObj$iv = state.getValue();
        return (UiScaleModel) thisObj$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CrowdfundingAtmosFloorComponent$lambda$2$1$1$0$0(PageViewModel $pageVM) {
        $pageVM.reloadProductDetails$product_details_page_debug();
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:104:0x01fb, code lost:
        if (r8 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x034e, code lost:
        if (r3 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L89;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:103:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0238  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0268  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0297  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x02c7  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0346  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0352  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0386  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x038b  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0397  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x039c  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x03a9  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x03ac  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0564  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0570  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0576  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0684  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0690  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0696  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0714  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0768  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x07da  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x089a  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x08a6  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x08ac  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x092e  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x093d  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0ae9  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0af5  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0afb  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0b79  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0b88  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0d11  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0d1d  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0d23  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x0d9f  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x0dae  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x0e21  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x0e9e  */
    /* JADX WARN: Type inference failed for: r2v24 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void CountDownComponent(final CountDownInfoVO countDownInfo, final float scale, Modifier modifier, Function0<Unit> function0, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Function0 onCountdownEnd;
        Composer $composer2;
        Modifier modifier3;
        Modifier modifier4;
        long currentTimeMillis;
        Function0 onCountdownEnd2;
        long max;
        boolean invalid$iv;
        Object it$iv;
        MutableLongState days$delegate;
        Object it$iv2;
        Object it$iv3;
        Object it$iv4;
        boolean invalid$iv2;
        Object it$iv5;
        boolean invalid$iv3;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        String countDownPrefix;
        boolean z;
        Function0 factory$iv$iv$iv3;
        Function0 factory$iv$iv$iv4;
        Function0 factory$iv$iv$iv5;
        String countDownSuffix;
        Composer $composer3 = $composer.startRestartGroup(-218620594);
        ComposerKt.sourceInformation($composer3, "C(CountDownComponent)N(countDownInfo,scale,modifier,onCountdownEnd)175@7167L2,181@7360L36,185@7456L250,195@7777L183,203@7989L75,207@8082L35,208@8135L35,209@8190L35,210@8245L35,211@8298L46,213@8377L1095,213@8350L1122,253@9644L21,254@9723L7,278@10454L4692:CrowdfundingAtmosFloorComponent.kt#o90vz8");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(countDownInfo) ? 4 : 2;
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
            onCountdownEnd = function0;
        } else if (($changed & 3072) == 0) {
            onCountdownEnd = function0;
            $dirty |= $composer3.changedInstance(onCountdownEnd) ? 2048 : 1024;
        } else {
            onCountdownEnd = function0;
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
            if (i3 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer3, 359011344, "CC(remember):CrowdfundingAtmosFloorComponent.kt#9igjgp");
                Object it$iv6 = $composer3.rememberedValue();
                if (it$iv6 == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function0() { // from class: kntr.app.mall.product.details.page.ui.components.CrowdfundingAtmosFloorComponentKt$$ExternalSyntheticLambda0
                        public final Object invoke() {
                            Unit unit;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv);
                    it$iv6 = value$iv;
                }
                Function0 onCountdownEnd3 = it$iv6;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                onCountdownEnd = onCountdownEnd3;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-218620594, $dirty2, -1, "kntr.app.mall.product.details.page.ui.components.CountDownComponent (CrowdfundingAtmosFloorComponent.kt:176)");
            }
            if (Intrinsics.areEqual(countDownInfo.getShowCountDown(), true)) {
                Long leftTime = countDownInfo.getLeftTime();
                long leftTimeSec = leftTime != null ? leftTime.longValue() : 0L;
                Long serverTime = countDownInfo.getServerTime();
                long serverEndEpochMs = serverTime != null ? serverTime.longValue() : 0L;
                State currentOnEnd = SnapshotStateKt.rememberUpdatedState(onCountdownEnd, $composer3, ($dirty2 >> 9) & 14);
                ComposerKt.sourceInformationMarkerStart($composer3, 359020840, "CC(remember):CrowdfundingAtmosFloorComponent.kt#9igjgp");
                boolean invalid$iv4 = $composer3.changed(serverEndEpochMs) | $composer3.changed(leftTimeSec);
                Object it$iv7 = $composer3.rememberedValue();
                if (invalid$iv4 || it$iv7 == Composer.Companion.getEmpty()) {
                    if (serverEndEpochMs > 0) {
                        currentTimeMillis = serverEndEpochMs;
                    } else {
                        currentTimeMillis = leftTimeSec > 0 ? DateFormatKt.getCurrentTimeMillis() + (1000 * leftTimeSec) : 0L;
                    }
                    Object value$iv2 = Long.valueOf(currentTimeMillis);
                    $composer3.updateRememberedValue(value$iv2);
                    it$iv7 = value$iv2;
                }
                long endEpochMs = ((Number) it$iv7).longValue();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerStart($composer3, 359031045, "CC(remember):CrowdfundingAtmosFloorComponent.kt#9igjgp");
                boolean invalid$iv5 = $composer3.changed(endEpochMs);
                Object value$iv3 = $composer3.rememberedValue();
                if (!invalid$iv5 && value$iv3 != Composer.Companion.getEmpty()) {
                    onCountdownEnd2 = onCountdownEnd;
                    long initialRemainingMs = ((Number) value$iv3).longValue();
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerStart($composer3, 359037721, "CC(remember):CrowdfundingAtmosFloorComponent.kt#9igjgp");
                    invalid$iv = $composer3.changed(endEpochMs);
                    Object it$iv8 = $composer3.rememberedValue();
                    if (invalid$iv) {
                    }
                    Object value$iv4 = TimeSource.Monotonic.ValueTimeMark.box-impl(TimeSource.Monotonic.INSTANCE.markNow-z9LOYto());
                    $composer3.updateRememberedValue(value$iv4);
                    it$iv8 = value$iv4;
                    long startMark = ((TimeSource.Monotonic.ValueTimeMark) it$iv8).unbox-impl();
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerStart($composer3, 359040657, "CC(remember):CrowdfundingAtmosFloorComponent.kt#9igjgp");
                    it$iv = $composer3.rememberedValue();
                    if (it$iv == Composer.Companion.getEmpty()) {
                        Object value$iv5 = SnapshotLongStateKt.mutableLongStateOf(0L);
                        $composer3.updateRememberedValue(value$iv5);
                        it$iv = value$iv5;
                    }
                    days$delegate = (MutableLongState) it$iv;
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerStart($composer3, 359042353, "CC(remember):CrowdfundingAtmosFloorComponent.kt#9igjgp");
                    it$iv2 = $composer3.rememberedValue();
                    if (it$iv2 == Composer.Companion.getEmpty()) {
                        Object value$iv6 = SnapshotLongStateKt.mutableLongStateOf(0L);
                        $composer3.updateRememberedValue(value$iv6);
                        it$iv2 = value$iv6;
                    }
                    MutableLongState hours$delegate = (MutableLongState) it$iv2;
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerStart($composer3, 359044113, "CC(remember):CrowdfundingAtmosFloorComponent.kt#9igjgp");
                    it$iv3 = $composer3.rememberedValue();
                    if (it$iv3 == Composer.Companion.getEmpty()) {
                        Object value$iv7 = SnapshotLongStateKt.mutableLongStateOf(0L);
                        $composer3.updateRememberedValue(value$iv7);
                        it$iv3 = value$iv7;
                    }
                    MutableLongState minutes$delegate = (MutableLongState) it$iv3;
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerStart($composer3, 359045873, "CC(remember):CrowdfundingAtmosFloorComponent.kt#9igjgp");
                    it$iv4 = $composer3.rememberedValue();
                    modifier3 = modifier4;
                    if (it$iv4 == Composer.Companion.getEmpty()) {
                        Object value$iv8 = SnapshotLongStateKt.mutableLongStateOf(0L);
                        $composer3.updateRememberedValue(value$iv8);
                        it$iv4 = value$iv8;
                    }
                    MutableLongState seconds$delegate = (MutableLongState) it$iv4;
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerStart($composer3, 359047580, "CC(remember):CrowdfundingAtmosFloorComponent.kt#9igjgp");
                    invalid$iv2 = $composer3.changed(endEpochMs);
                    it$iv5 = $composer3.rememberedValue();
                    if (!invalid$iv2 || it$iv5 == Composer.Companion.getEmpty()) {
                        Object value$iv9 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                        $composer3.updateRememberedValue(value$iv9);
                        it$iv5 = value$iv9;
                    }
                    MutableState ended$delegate = (MutableState) it$iv5;
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    Long valueOf = Long.valueOf(endEpochMs);
                    ComposerKt.sourceInformationMarkerStart($composer3, 359051157, "CC(remember):CrowdfundingAtmosFloorComponent.kt#9igjgp");
                    invalid$iv3 = $composer3.changed(initialRemainingMs) | $composer3.changed(ended$delegate) | $composer3.changed(currentOnEnd) | $composer3.changed(startMark);
                    Object it$iv9 = $composer3.rememberedValue();
                    if (invalid$iv3) {
                    }
                    Object value$iv10 = (Function2) new CrowdfundingAtmosFloorComponentKt$CountDownComponent$3$1(initialRemainingMs, currentOnEnd, startMark, hours$delegate, minutes$delegate, seconds$delegate, ended$delegate, days$delegate, null);
                    $composer3.updateRememberedValue(value$iv10);
                    it$iv9 = value$iv10;
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    EffectsKt.LaunchedEffect(valueOf, (Function2) it$iv9, $composer3, 0);
                    String dayColor = countDownInfo.getDayColor();
                    long dayColor2 = dayColor == null ? ComposeColorParserKt.parseColor(dayColor) : Color.Companion.getWhite-0d7_KjU();
                    String nightColor = countDownInfo.getNightColor();
                    long nightColor2 = nightColor == null ? ComposeColorParserKt.parseColor(nightColor) : Color.Companion.getWhite-0d7_KjU();
                    long textColor = !ThemesKt.isCurrentThemeLight($composer3, 0) ? dayColor2 : nightColor2;
                    CompositionLocal this_$iv = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object consume = $composer3.consume(this_$iv);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    Density density = (Density) consume;
                    long j = Color.copy-wmQWz5c$default(ColorKt.Color(4294916719L), 0.45f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
                    float y$iv = density.toPx-0680j_4(ProvideUiScaleKt.dpScaled(1, scale));
                    long v1$iv$iv = Float.floatToRawIntBits(0.0f);
                    long v2$iv$iv = Float.floatToRawIntBits(y$iv);
                    Shadow shadow = new Shadow(j, Offset.constructor-impl((v1$iv$iv << 32) | (v2$iv$iv & 4294967295L)), density.toPx-0680j_4(ProvideUiScaleKt.dpScaled(1, scale)), (DefaultConstructorMarker) null);
                    TextStyle textStyle = ProvideUiScaleKt.scaled(new TextStyle(0L, TextUnitKt.getSp(14), FontWeight.Companion.getW500(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, TextUnitKt.getEm(0.02d), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, shadow, (DrawStyle) null, 0, 0, TextUnitKt.getSp(20), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16637817, (DefaultConstructorMarker) null), scale);
                    TextStyle countDownNumberStyle = ProvideUiScaleKt.scaled(new TextStyle(0L, TextUnitKt.getSp(12), FontWeight.Companion.getW500(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, "tnum", 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(16), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646073, (DefaultConstructorMarker) null), scale);
                    Modifier modifier$iv = SizeKt.fillMaxHeight$default(modifier3, 0.0f, 1, (Object) null);
                    ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
                    MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                    int $changed$iv$iv = (0 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
                    CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
                    Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
                    int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                    $composer2 = $composer3;
                    ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!($composer3.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer3.startReusableNode();
                    if (!$composer3.getInserting()) {
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
                    int i4 = ($changed$iv$iv$iv >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScope boxScope = BoxScopeInstance.INSTANCE;
                    int i5 = ((0 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer3, 200343008, "C283@10549L4591:CrowdfundingAtmosFloorComponent.kt#o90vz8");
                    Modifier modifier$iv2 = SizeKt.fillMaxHeight$default(Modifier.Companion, 0.0f, 1, (Object) null);
                    Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
                    ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                    Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                    MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((390 >> 3) & 14) | ((390 >> 3) & 112));
                    int $changed$iv$iv2 = (390 << 3) & 112;
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
                    if (!$composer3.getInserting()) {
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
                    int i6 = ($changed$iv$iv$iv2 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                    RowScope rowScope = RowScopeInstance.INSTANCE;
                    int i7 = ((390 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer3, -1541531883, "C289@10724L298,311@11398L762,331@12174L532,347@12720L768,367@13502L532,383@14048L768,403@14830L300:CrowdfundingAtmosFloorComponent.kt#o90vz8");
                    countDownPrefix = countDownInfo.getCountDownPrefix();
                    if (countDownPrefix == null) {
                        countDownPrefix = "";
                    }
                    TextKt.Text-Nvy7gAk(countDownPrefix, PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, ProvideUiScaleKt.dpScaled(2, scale), 0.0f, 11, (Object) null), textColor, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, textStyle, $composer3, 0, 24576, 114680);
                    if (CountDownComponent$lambda$6(days$delegate) <= 0) {
                        $composer3.startReplaceGroup(-1541316899);
                        ComposerKt.sourceInformation($composer3, "300@11069L301");
                        z = false;
                        TextKt.Text-Nvy7gAk(CountDownComponent$lambda$6(days$delegate) + "天", PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, ProvideUiScaleKt.dpScaled(4, scale), 0.0f, 11, (Object) null), textColor, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, textStyle, $composer3, 0, 24576, 114680);
                    } else {
                        z = false;
                        $composer3.startReplaceGroup(-1552307670);
                    }
                    $composer3.endReplaceGroup();
                    Modifier modifier$iv3 = PaddingKt.padding-VpY3zN4$default(SizeKt.sizeIn-qDBjuR0$default(BackgroundKt.background-bw27NRU(Modifier.Companion, Color.Companion.getWhite-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(ProvideUiScaleKt.dpScaled(4, scale))), ProvideUiScaleKt.dpScaled(18, scale), ProvideUiScaleKt.dpScaled(16, scale), 0.0f, 0.0f, 12, (Object) null), ProvideUiScaleKt.dpScaled(1, scale), 0.0f, 2, (Object) null);
                    Alignment contentAlignment$iv2 = Alignment.Companion.getCenter();
                    ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicy$iv3 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
                    int $changed$iv$iv3 = (48 << 3) & 112;
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
                    if (!$composer3.getInserting()) {
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
                    int i8 = ($changed$iv$iv$iv3 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
                    int i9 = ((48 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer3, -1777265656, "C323@11925L221:CrowdfundingAtmosFloorComponent.kt#o90vz8");
                    TextKt.Text-Nvy7gAk(CountDownComponent$lambda$9(hours$delegate) <= 9 ? String.valueOf(CountDownComponent$lambda$9(hours$delegate)) : "0" + CountDownComponent$lambda$9(hours$delegate), (Modifier) null, ColorKt.Color(4294916719L), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, countDownNumberStyle, $composer3, 384, 24576, 114682);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    $composer3.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    TextKt.Text-Nvy7gAk(":", PaddingKt.padding-VpY3zN4$default(OffsetKt.absoluteOffset-VpY3zN4$default(Modifier.Companion, 0.0f, ProvideUiScaleKt.dpScaled(-1, scale), 1, (Object) null), ProvideUiScaleKt.dpScaled(3, scale), 0.0f, 2, (Object) null), textColor, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, ProvideUiScaleKt.scaled(new TextStyle(0L, TextUnitKt.getSp(13), FontWeight.Companion.getW500(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(16), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646137, (DefaultConstructorMarker) null), scale), $composer3, 6, 24576, 114680);
                    Modifier modifier$iv4 = PaddingKt.padding-VpY3zN4$default(SizeKt.sizeIn-qDBjuR0$default(BackgroundKt.background-bw27NRU(Modifier.Companion, Color.Companion.getWhite-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(ProvideUiScaleKt.dpScaled(4, scale))), ProvideUiScaleKt.dpScaled(18, scale), ProvideUiScaleKt.dpScaled(16, scale), 0.0f, 0.0f, 12, (Object) null), ProvideUiScaleKt.dpScaled(1, scale), 0.0f, 2, (Object) null);
                    Alignment contentAlignment$iv3 = Alignment.Companion.getCenter();
                    ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicy$iv4 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv3, false);
                    int $changed$iv$iv4 = (48 << 3) & 112;
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
                    if (!$composer3.getInserting()) {
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
                    int i10 = ($changed$iv$iv$iv4 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScope boxScope3 = BoxScopeInstance.INSTANCE;
                    int i11 = ((48 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer3, 1681456555, "C359@13247L227:CrowdfundingAtmosFloorComponent.kt#o90vz8");
                    TextKt.Text-Nvy7gAk(CountDownComponent$lambda$12(minutes$delegate) <= 9 ? String.valueOf(CountDownComponent$lambda$12(minutes$delegate)) : "0" + CountDownComponent$lambda$12(minutes$delegate), (Modifier) null, ColorKt.Color(4294916719L), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, countDownNumberStyle, $composer3, 384, 24576, 114682);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    $composer3.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    TextKt.Text-Nvy7gAk(":", PaddingKt.padding-VpY3zN4$default(OffsetKt.absoluteOffset-VpY3zN4$default(Modifier.Companion, 0.0f, ProvideUiScaleKt.dpScaled(-1, scale), 1, (Object) null), ProvideUiScaleKt.dpScaled(3, scale), 0.0f, 2, (Object) null), textColor, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, ProvideUiScaleKt.scaled(new TextStyle(0L, TextUnitKt.getSp(13), FontWeight.Companion.getW500(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(16), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646137, (DefaultConstructorMarker) null), scale), $composer3, 6, 24576, 114680);
                    Modifier modifier$iv5 = PaddingKt.padding-VpY3zN4$default(SizeKt.sizeIn-qDBjuR0$default(BackgroundKt.background-bw27NRU(Modifier.Companion, Color.Companion.getWhite-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(ProvideUiScaleKt.dpScaled(4, scale))), ProvideUiScaleKt.dpScaled(18, scale), ProvideUiScaleKt.dpScaled(16, scale), 0.0f, 0.0f, 12, (Object) null), ProvideUiScaleKt.dpScaled(1, scale), 0.0f, 2, (Object) null);
                    Alignment contentAlignment$iv4 = Alignment.Companion.getCenter();
                    ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicy$iv5 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv4, false);
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
                    if (!$composer3.getInserting()) {
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
                    int i12 = ($changed$iv$iv$iv5 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScope boxScope4 = BoxScopeInstance.INSTANCE;
                    int i13 = ((48 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer3, -1955127862, "C395@14575L227:CrowdfundingAtmosFloorComponent.kt#o90vz8");
                    TextKt.Text-Nvy7gAk(CountDownComponent$lambda$15(seconds$delegate) <= 9 ? String.valueOf(CountDownComponent$lambda$15(seconds$delegate)) : "0" + CountDownComponent$lambda$15(seconds$delegate), (Modifier) null, ColorKt.Color(4294916719L), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, countDownNumberStyle, $composer3, 384, 24576, 114682);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    $composer3.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    countDownSuffix = countDownInfo.getCountDownSuffix();
                    if (countDownSuffix == null) {
                        countDownSuffix = "";
                    }
                    TextKt.Text-Nvy7gAk(countDownSuffix, PaddingKt.padding-qDBjuR0$default(Modifier.Companion, ProvideUiScaleKt.dpScaled(2, scale), 0.0f, 0.0f, 0.0f, 14, (Object) null), textColor, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, textStyle, $composer3, 0, 24576, 114680);
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
                    onCountdownEnd = onCountdownEnd2;
                }
                if (endEpochMs <= 0) {
                    onCountdownEnd2 = onCountdownEnd;
                    max = 0;
                } else {
                    onCountdownEnd2 = onCountdownEnd;
                    max = Math.max(0L, endEpochMs - DateFormatKt.getCurrentTimeMillis());
                }
                value$iv3 = Long.valueOf(max);
                $composer3.updateRememberedValue(value$iv3);
                long initialRemainingMs2 = ((Number) value$iv3).longValue();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerStart($composer3, 359037721, "CC(remember):CrowdfundingAtmosFloorComponent.kt#9igjgp");
                invalid$iv = $composer3.changed(endEpochMs);
                Object it$iv82 = $composer3.rememberedValue();
                if (invalid$iv) {
                }
                Object value$iv42 = TimeSource.Monotonic.ValueTimeMark.box-impl(TimeSource.Monotonic.INSTANCE.markNow-z9LOYto());
                $composer3.updateRememberedValue(value$iv42);
                it$iv82 = value$iv42;
                long startMark2 = ((TimeSource.Monotonic.ValueTimeMark) it$iv82).unbox-impl();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerStart($composer3, 359040657, "CC(remember):CrowdfundingAtmosFloorComponent.kt#9igjgp");
                it$iv = $composer3.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                }
                days$delegate = (MutableLongState) it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerStart($composer3, 359042353, "CC(remember):CrowdfundingAtmosFloorComponent.kt#9igjgp");
                it$iv2 = $composer3.rememberedValue();
                if (it$iv2 == Composer.Companion.getEmpty()) {
                }
                MutableLongState hours$delegate2 = (MutableLongState) it$iv2;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerStart($composer3, 359044113, "CC(remember):CrowdfundingAtmosFloorComponent.kt#9igjgp");
                it$iv3 = $composer3.rememberedValue();
                if (it$iv3 == Composer.Companion.getEmpty()) {
                }
                MutableLongState minutes$delegate2 = (MutableLongState) it$iv3;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerStart($composer3, 359045873, "CC(remember):CrowdfundingAtmosFloorComponent.kt#9igjgp");
                it$iv4 = $composer3.rememberedValue();
                modifier3 = modifier4;
                if (it$iv4 == Composer.Companion.getEmpty()) {
                }
                MutableLongState seconds$delegate2 = (MutableLongState) it$iv4;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerStart($composer3, 359047580, "CC(remember):CrowdfundingAtmosFloorComponent.kt#9igjgp");
                invalid$iv2 = $composer3.changed(endEpochMs);
                it$iv5 = $composer3.rememberedValue();
                if (!invalid$iv2) {
                }
                Object value$iv92 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer3.updateRememberedValue(value$iv92);
                it$iv5 = value$iv92;
                MutableState ended$delegate2 = (MutableState) it$iv5;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                Long valueOf2 = Long.valueOf(endEpochMs);
                ComposerKt.sourceInformationMarkerStart($composer3, 359051157, "CC(remember):CrowdfundingAtmosFloorComponent.kt#9igjgp");
                invalid$iv3 = $composer3.changed(initialRemainingMs2) | $composer3.changed(ended$delegate2) | $composer3.changed(currentOnEnd) | $composer3.changed(startMark2);
                Object it$iv92 = $composer3.rememberedValue();
                if (invalid$iv3) {
                }
                Object value$iv102 = (Function2) new CrowdfundingAtmosFloorComponentKt$CountDownComponent$3$1(initialRemainingMs2, currentOnEnd, startMark2, hours$delegate2, minutes$delegate2, seconds$delegate2, ended$delegate2, days$delegate, null);
                $composer3.updateRememberedValue(value$iv102);
                it$iv92 = value$iv102;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                EffectsKt.LaunchedEffect(valueOf2, (Function2) it$iv92, $composer3, 0);
                String dayColor3 = countDownInfo.getDayColor();
                if (dayColor3 == null) {
                }
                String nightColor3 = countDownInfo.getNightColor();
                if (nightColor3 == null) {
                }
                if (!ThemesKt.isCurrentThemeLight($composer3, 0)) {
                }
                CompositionLocal this_$iv2 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object consume2 = $composer3.consume(this_$iv2);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                Density density2 = (Density) consume2;
                long j2 = Color.copy-wmQWz5c$default(ColorKt.Color(4294916719L), 0.45f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
                float y$iv2 = density2.toPx-0680j_4(ProvideUiScaleKt.dpScaled(1, scale));
                long v1$iv$iv2 = Float.floatToRawIntBits(0.0f);
                long v2$iv$iv2 = Float.floatToRawIntBits(y$iv2);
                Shadow shadow2 = new Shadow(j2, Offset.constructor-impl((v1$iv$iv2 << 32) | (v2$iv$iv2 & 4294967295L)), density2.toPx-0680j_4(ProvideUiScaleKt.dpScaled(1, scale)), (DefaultConstructorMarker) null);
                TextStyle textStyle2 = ProvideUiScaleKt.scaled(new TextStyle(0L, TextUnitKt.getSp(14), FontWeight.Companion.getW500(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, TextUnitKt.getEm(0.02d), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, shadow2, (DrawStyle) null, 0, 0, TextUnitKt.getSp(20), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16637817, (DefaultConstructorMarker) null), scale);
                TextStyle countDownNumberStyle2 = ProvideUiScaleKt.scaled(new TextStyle(0L, TextUnitKt.getSp(12), FontWeight.Companion.getW500(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, "tnum", 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(16), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646073, (DefaultConstructorMarker) null), scale);
                Modifier modifier$iv6 = SizeKt.fillMaxHeight$default(modifier3, 0.0f, 1, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                Alignment contentAlignment$iv5 = Alignment.Companion.getTopStart();
                MeasurePolicy measurePolicy$iv6 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv5, false);
                int $changed$iv$iv6 = (0 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv6 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
                CompositionLocalMap localMap$iv$iv6 = $composer3.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv6 = ComposedModifierKt.materializeModifier($composer3, modifier$iv6);
                Function0 factory$iv$iv$iv62 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv6 = (($changed$iv$iv6 << 6) & 896) | 6;
                $composer2 = $composer3;
                ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer3.getApplier() instanceof Applier)) {
                }
                $composer3.startReusableNode();
                if (!$composer3.getInserting()) {
                }
                Composer $this$Layout_u24lambda_u240$iv$iv6 = Updater.constructor-impl($composer3);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv6, measurePolicy$iv6, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv6, localMap$iv$iv6, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv6, Integer.valueOf(compositeKeyHash$iv$iv6), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv6, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv6, materialized$iv$iv6, ComposeUiNode.Companion.getSetModifier());
                int i42 = ($changed$iv$iv$iv6 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScope boxScope5 = BoxScopeInstance.INSTANCE;
                int i52 = ((0 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, 200343008, "C283@10549L4591:CrowdfundingAtmosFloorComponent.kt#o90vz8");
                Modifier modifier$iv22 = SizeKt.fillMaxHeight$default(Modifier.Companion, 0.0f, 1, (Object) null);
                Alignment.Vertical verticalAlignment$iv2 = Alignment.Companion.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.getStart();
                MeasurePolicy measurePolicy$iv22 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer3, ((390 >> 3) & 14) | ((390 >> 3) & 112));
                int $changed$iv$iv22 = (390 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv22 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
                CompositionLocalMap localMap$iv$iv22 = $composer3.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv22 = ComposedModifierKt.materializeModifier($composer3, modifier$iv22);
                Function0 factory$iv$iv$iv72 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv22 = (($changed$iv$iv22 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer3.getApplier() instanceof Applier)) {
                }
                $composer3.startReusableNode();
                if (!$composer3.getInserting()) {
                }
                Composer $this$Layout_u24lambda_u240$iv$iv22 = Updater.constructor-impl($composer3);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv22, measurePolicy$iv22, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv22, localMap$iv$iv22, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv22, Integer.valueOf(compositeKeyHash$iv$iv22), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv22, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv22, materialized$iv$iv22, ComposeUiNode.Companion.getSetModifier());
                int i62 = ($changed$iv$iv$iv22 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScope rowScope2 = RowScopeInstance.INSTANCE;
                int i72 = ((390 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, -1541531883, "C289@10724L298,311@11398L762,331@12174L532,347@12720L768,367@13502L532,383@14048L768,403@14830L300:CrowdfundingAtmosFloorComponent.kt#o90vz8");
                countDownPrefix = countDownInfo.getCountDownPrefix();
                if (countDownPrefix == null) {
                }
                TextKt.Text-Nvy7gAk(countDownPrefix, PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, ProvideUiScaleKt.dpScaled(2, scale), 0.0f, 11, (Object) null), textColor, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, textStyle2, $composer3, 0, 24576, 114680);
                if (CountDownComponent$lambda$6(days$delegate) <= 0) {
                }
                $composer3.endReplaceGroup();
                Modifier modifier$iv32 = PaddingKt.padding-VpY3zN4$default(SizeKt.sizeIn-qDBjuR0$default(BackgroundKt.background-bw27NRU(Modifier.Companion, Color.Companion.getWhite-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(ProvideUiScaleKt.dpScaled(4, scale))), ProvideUiScaleKt.dpScaled(18, scale), ProvideUiScaleKt.dpScaled(16, scale), 0.0f, 0.0f, 12, (Object) null), ProvideUiScaleKt.dpScaled(1, scale), 0.0f, 2, (Object) null);
                Alignment contentAlignment$iv22 = Alignment.Companion.getCenter();
                ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv32 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv22, false);
                int $changed$iv$iv32 = (48 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv32 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
                CompositionLocalMap localMap$iv$iv32 = $composer3.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv32 = ComposedModifierKt.materializeModifier($composer3, modifier$iv32);
                Function0 factory$iv$iv$iv82 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv32 = (($changed$iv$iv32 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer3.getApplier() instanceof Applier)) {
                }
                $composer3.startReusableNode();
                if (!$composer3.getInserting()) {
                }
                Composer $this$Layout_u24lambda_u240$iv$iv32 = Updater.constructor-impl($composer3);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv32, measurePolicy$iv32, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv32, localMap$iv$iv32, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv32, Integer.valueOf(compositeKeyHash$iv$iv32), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv32, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv32, materialized$iv$iv32, ComposeUiNode.Companion.getSetModifier());
                int i82 = ($changed$iv$iv$iv32 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScope boxScope22 = BoxScopeInstance.INSTANCE;
                int i92 = ((48 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, -1777265656, "C323@11925L221:CrowdfundingAtmosFloorComponent.kt#o90vz8");
                TextKt.Text-Nvy7gAk(CountDownComponent$lambda$9(hours$delegate2) <= 9 ? String.valueOf(CountDownComponent$lambda$9(hours$delegate2)) : "0" + CountDownComponent$lambda$9(hours$delegate2), (Modifier) null, ColorKt.Color(4294916719L), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, countDownNumberStyle2, $composer3, 384, 24576, 114682);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                TextKt.Text-Nvy7gAk(":", PaddingKt.padding-VpY3zN4$default(OffsetKt.absoluteOffset-VpY3zN4$default(Modifier.Companion, 0.0f, ProvideUiScaleKt.dpScaled(-1, scale), 1, (Object) null), ProvideUiScaleKt.dpScaled(3, scale), 0.0f, 2, (Object) null), textColor, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, ProvideUiScaleKt.scaled(new TextStyle(0L, TextUnitKt.getSp(13), FontWeight.Companion.getW500(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(16), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646137, (DefaultConstructorMarker) null), scale), $composer3, 6, 24576, 114680);
                Modifier modifier$iv42 = PaddingKt.padding-VpY3zN4$default(SizeKt.sizeIn-qDBjuR0$default(BackgroundKt.background-bw27NRU(Modifier.Companion, Color.Companion.getWhite-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(ProvideUiScaleKt.dpScaled(4, scale))), ProvideUiScaleKt.dpScaled(18, scale), ProvideUiScaleKt.dpScaled(16, scale), 0.0f, 0.0f, 12, (Object) null), ProvideUiScaleKt.dpScaled(1, scale), 0.0f, 2, (Object) null);
                Alignment contentAlignment$iv32 = Alignment.Companion.getCenter();
                ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv42 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv32, false);
                int $changed$iv$iv42 = (48 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv42 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
                CompositionLocalMap localMap$iv$iv42 = $composer3.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv42 = ComposedModifierKt.materializeModifier($composer3, modifier$iv42);
                Function0 factory$iv$iv$iv92 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv42 = (($changed$iv$iv42 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer3.getApplier() instanceof Applier)) {
                }
                $composer3.startReusableNode();
                if (!$composer3.getInserting()) {
                }
                Composer $this$Layout_u24lambda_u240$iv$iv42 = Updater.constructor-impl($composer3);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv42, measurePolicy$iv42, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv42, localMap$iv$iv42, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv42, Integer.valueOf(compositeKeyHash$iv$iv42), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv42, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv42, materialized$iv$iv42, ComposeUiNode.Companion.getSetModifier());
                int i102 = ($changed$iv$iv$iv42 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScope boxScope32 = BoxScopeInstance.INSTANCE;
                int i112 = ((48 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, 1681456555, "C359@13247L227:CrowdfundingAtmosFloorComponent.kt#o90vz8");
                TextKt.Text-Nvy7gAk(CountDownComponent$lambda$12(minutes$delegate2) <= 9 ? String.valueOf(CountDownComponent$lambda$12(minutes$delegate2)) : "0" + CountDownComponent$lambda$12(minutes$delegate2), (Modifier) null, ColorKt.Color(4294916719L), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, countDownNumberStyle2, $composer3, 384, 24576, 114682);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                TextKt.Text-Nvy7gAk(":", PaddingKt.padding-VpY3zN4$default(OffsetKt.absoluteOffset-VpY3zN4$default(Modifier.Companion, 0.0f, ProvideUiScaleKt.dpScaled(-1, scale), 1, (Object) null), ProvideUiScaleKt.dpScaled(3, scale), 0.0f, 2, (Object) null), textColor, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, ProvideUiScaleKt.scaled(new TextStyle(0L, TextUnitKt.getSp(13), FontWeight.Companion.getW500(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(16), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646137, (DefaultConstructorMarker) null), scale), $composer3, 6, 24576, 114680);
                Modifier modifier$iv52 = PaddingKt.padding-VpY3zN4$default(SizeKt.sizeIn-qDBjuR0$default(BackgroundKt.background-bw27NRU(Modifier.Companion, Color.Companion.getWhite-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(ProvideUiScaleKt.dpScaled(4, scale))), ProvideUiScaleKt.dpScaled(18, scale), ProvideUiScaleKt.dpScaled(16, scale), 0.0f, 0.0f, 12, (Object) null), ProvideUiScaleKt.dpScaled(1, scale), 0.0f, 2, (Object) null);
                Alignment contentAlignment$iv42 = Alignment.Companion.getCenter();
                ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv52 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv42, false);
                int $changed$iv$iv52 = (48 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv52 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
                CompositionLocalMap localMap$iv$iv52 = $composer3.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv52 = ComposedModifierKt.materializeModifier($composer3, modifier$iv52);
                Function0 factory$iv$iv$iv102 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv52 = (($changed$iv$iv52 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer3.getApplier() instanceof Applier)) {
                }
                $composer3.startReusableNode();
                if (!$composer3.getInserting()) {
                }
                Composer $this$Layout_u24lambda_u240$iv$iv52 = Updater.constructor-impl($composer3);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv52, measurePolicy$iv52, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv52, localMap$iv$iv52, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv52, Integer.valueOf(compositeKeyHash$iv$iv52), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv52, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv52, materialized$iv$iv52, ComposeUiNode.Companion.getSetModifier());
                int i122 = ($changed$iv$iv$iv52 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScope boxScope42 = BoxScopeInstance.INSTANCE;
                int i132 = ((48 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, -1955127862, "C395@14575L227:CrowdfundingAtmosFloorComponent.kt#o90vz8");
                TextKt.Text-Nvy7gAk(CountDownComponent$lambda$15(seconds$delegate2) <= 9 ? String.valueOf(CountDownComponent$lambda$15(seconds$delegate2)) : "0" + CountDownComponent$lambda$15(seconds$delegate2), (Modifier) null, ColorKt.Color(4294916719L), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, countDownNumberStyle2, $composer3, 384, 24576, 114682);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                countDownSuffix = countDownInfo.getCountDownSuffix();
                if (countDownSuffix == null) {
                }
                TextKt.Text-Nvy7gAk(countDownSuffix, PaddingKt.padding-qDBjuR0$default(Modifier.Companion, ProvideUiScaleKt.dpScaled(2, scale), 0.0f, 0.0f, 0.0f, 14, (Object) null), textColor, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, textStyle2, $composer3, 0, 24576, 114680);
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
                onCountdownEnd = onCountdownEnd2;
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup = $composer3.endRestartGroup();
                if (endRestartGroup != null) {
                    final Modifier modifier5 = modifier4;
                    final Function0 function02 = onCountdownEnd;
                    endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.CrowdfundingAtmosFloorComponentKt$$ExternalSyntheticLambda1
                        public final Object invoke(Object obj, Object obj2) {
                            Unit CountDownComponent$lambda$1;
                            CountDownComponent$lambda$1 = CrowdfundingAtmosFloorComponentKt.CountDownComponent$lambda$1(CountDownInfoVO.this, scale, modifier5, function02, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                            return CountDownComponent$lambda$1;
                        }
                    });
                    return;
                }
                return;
            }
        }
        ScopeUpdateScope endRestartGroup2 = $composer2.endRestartGroup();
        if (endRestartGroup2 != null) {
            final Modifier modifier6 = modifier3;
            final Function0 function03 = onCountdownEnd;
            endRestartGroup2.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.CrowdfundingAtmosFloorComponentKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    Unit CountDownComponent$lambda$23;
                    CountDownComponent$lambda$23 = CrowdfundingAtmosFloorComponentKt.CountDownComponent$lambda$23(CountDownInfoVO.this, scale, modifier6, function03, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return CountDownComponent$lambda$23;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long CountDownComponent$lambda$6(MutableLongState $days$delegate) {
        LongState $this$getValue$iv = (LongState) $days$delegate;
        return $this$getValue$iv.getLongValue();
    }

    private static final long CountDownComponent$lambda$9(MutableLongState $hours$delegate) {
        LongState $this$getValue$iv = (LongState) $hours$delegate;
        return $this$getValue$iv.getLongValue();
    }

    private static final long CountDownComponent$lambda$12(MutableLongState $minutes$delegate) {
        LongState $this$getValue$iv = (LongState) $minutes$delegate;
        return $this$getValue$iv.getLongValue();
    }

    private static final long CountDownComponent$lambda$15(MutableLongState $seconds$delegate) {
        LongState $this$getValue$iv = (LongState) $seconds$delegate;
        return $this$getValue$iv.getLongValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean CountDownComponent$lambda$18(MutableState<Boolean> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void CountDownComponent$lambda$19(MutableState<Boolean> mutableState, boolean z) {
        Object value$iv = Boolean.valueOf(z);
        mutableState.setValue(value$iv);
    }
}