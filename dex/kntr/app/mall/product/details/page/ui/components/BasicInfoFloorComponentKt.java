package kntr.app.mall.product.details.page.ui.components;

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
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.TextLayoutResult;
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
import androidx.compose.ui.unit.TextUnitKt;
import com.bilibili.compose.iconfont.BiliIconfont;
import com.bilibili.compose.theme.BiliTheme;
import java.util.ArrayList;
import java.util.List;
import kntr.app.mall.product.details.page.api.model.BasicInfoFloor;
import kntr.app.mall.product.details.page.api.model.ImageColorModel;
import kntr.app.mall.product.details.page.api.model.ImageModel;
import kntr.app.mall.product.details.page.api.model.LabelObject;
import kntr.app.mall.product.details.page.ui.scale.ProvideUiScaleKt;
import kntr.app.mall.product.details.page.ui.scale.UiScaleModel;
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
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BasicInfoFloorComponent.kt */
@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0001¢\u0006\u0002\u0010\b\u001a\u0012\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0000\u001a\u0012\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\rH\u0000\u001a\u0014\u0010\u000e\u001a\u0004\u0018\u00010\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0000\u001a'\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0001¢\u0006\u0002\u0010\u0015¨\u0006\u0016²\u0006\n\u0010\u0017\u001a\u00020\u0018X\u008a\u0084\u0002"}, d2 = {"BasicInfoFloorComponent", "", "module", "Lkntr/app/mall/product/details/page/vm/ContentModule;", "pageViewModelWrapper", "Lkntr/app/mall/product/details/page/vm/PageViewModelWrapper;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lkntr/app/mall/product/details/page/vm/ContentModule;Lkntr/app/mall/product/details/page/vm/PageViewModelWrapper;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "transferAtmosphereToLabelObject", "Lkntr/app/mall/product/details/page/api/model/LabelObject;", "imageModel", "Lkntr/app/mall/product/details/page/api/model/ImageModel;", "Lkntr/app/mall/product/details/page/api/model/ImageColorModel;", "transferPromoInfoToLabelObject", "promoInfoVO", "Lkntr/app/mall/product/details/page/api/model/BasicInfoFloor$PromotionInfoVO;", "ServiceRightTagComponent", "serviceRightTag", "scale", "", "(Lkntr/app/mall/product/details/page/api/model/LabelObject;FLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "product-details-page_debug", "scaleModel", "Lkntr/app/mall/product/details/page/ui/scale/UiScaleModel;"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class BasicInfoFloorComponentKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BasicInfoFloorComponent$lambda$0(ContentModule contentModule, PageViewModelWrapper pageViewModelWrapper, Modifier modifier, int i, int i2, Composer composer, int i3) {
        BasicInfoFloorComponent(contentModule, pageViewModelWrapper, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BasicInfoFloorComponent$lambda$2(ContentModule contentModule, PageViewModelWrapper pageViewModelWrapper, Modifier modifier, int i, int i2, Composer composer, int i3) {
        BasicInfoFloorComponent(contentModule, pageViewModelWrapper, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BasicInfoFloorComponent$lambda$7(ContentModule contentModule, PageViewModelWrapper pageViewModelWrapper, Modifier modifier, int i, int i2, Composer composer, int i3) {
        BasicInfoFloorComponent(contentModule, pageViewModelWrapper, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ServiceRightTagComponent$lambda$1(LabelObject labelObject, float f, Modifier modifier, int i, int i2, Composer composer, int i3) {
        ServiceRightTagComponent(labelObject, f, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:122:0x0507, code lost:
        if (r15 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L112;
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x05d9, code lost:
        if (r15 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L120;
     */
    /* JADX WARN: Removed duplicated region for block: B:117:0x04d2  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x04d8  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x04ff  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x050b  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0555  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0791  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x07c5  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0835  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x084a  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0856  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x08c2  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x08e8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void BasicInfoFloorComponent(final ContentModule module, final PageViewModelWrapper pageViewModelWrapper, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Composer $composer2;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Object value$iv;
        final MutableState expandState;
        boolean invalid$iv;
        List tagList;
        final MutableState collapsedHasOverflow;
        boolean invalid$iv2;
        Composer $composer$iv$iv;
        Composer $composer$iv;
        Composer $composer3;
        String brief;
        Function0 factory$iv$iv$iv3;
        Object value$iv2;
        Intrinsics.checkNotNullParameter(module, "module");
        Intrinsics.checkNotNullParameter(pageViewModelWrapper, "pageViewModelWrapper");
        Composer $composer4 = $composer.startRestartGroup(756357248);
        ComposerKt.sourceInformation($composer4, "C(BasicInfoFloorComponent)N(module,pageViewModelWrapper,modifier)58@2483L16,81@3183L4142:BasicInfoFloorComponent.kt#o90vz8");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer4.changed(module) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer4.changedInstance(pageViewModelWrapper) ? 32 : 16;
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
        if ($composer4.shouldExecute(($dirty2 & 147) != 146, $dirty2 & 1)) {
            if (i2 != 0) {
                modifier2 = (Modifier) Modifier.Companion;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(756357248, $dirty2, -1, "kntr.app.mall.product.details.page.ui.components.BasicInfoFloorComponent (BasicInfoFloorComponent.kt:53)");
            }
            if (!(module instanceof ContentModule.BasicInfoModule)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup = $composer4.endRestartGroup();
                if (endRestartGroup != null) {
                    final Modifier modifier3 = modifier2;
                    endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.BasicInfoFloorComponentKt$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj, Object obj2) {
                            Unit BasicInfoFloorComponent$lambda$0;
                            BasicInfoFloorComponent$lambda$0 = BasicInfoFloorComponentKt.BasicInfoFloorComponent$lambda$0(ContentModule.this, pageViewModelWrapper, modifier3, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                            return BasicInfoFloorComponent$lambda$0;
                        }
                    });
                    return;
                }
                return;
            }
            final PageViewModel pageVM = pageViewModelWrapper.getViewModel();
            State scaleModel$delegate = SnapshotStateKt.collectAsState(pageVM.getUiScaleModelFlow$product_details_page_debug(), (CoroutineContext) null, $composer4, 0, 1);
            float scale = BasicInfoFloorComponent$lambda$1(scaleModel$delegate).getScale();
            BasicInfoFloor floorData = ((ContentModule.BasicInfoModule) module).getData();
            String itemsName = floorData.getItemsName();
            if (itemsName == null) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup2 = $composer4.endRestartGroup();
                if (endRestartGroup2 != null) {
                    final Modifier modifier4 = modifier2;
                    endRestartGroup2.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.BasicInfoFloorComponentKt$$ExternalSyntheticLambda1
                        public final Object invoke(Object obj, Object obj2) {
                            Unit BasicInfoFloorComponent$lambda$2;
                            BasicInfoFloorComponent$lambda$2 = BasicInfoFloorComponentKt.BasicInfoFloorComponent$lambda$2(ContentModule.this, pageViewModelWrapper, modifier4, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                            return BasicInfoFloorComponent$lambda$2;
                        }
                    });
                    return;
                }
                return;
            }
            List tagList2 = new ArrayList();
            List<BasicInfoFloor.PromotionInfoVO> promoInfoVOS = floorData.getPromoInfoVOS();
            LabelObject it = transferPromoInfoToLabelObject(promoInfoVOS != null ? (BasicInfoFloor.PromotionInfoVO) CollectionsKt.firstOrNull(promoInfoVOS) : null);
            if (it != null) {
                Boolean.valueOf(tagList2.add(it));
            }
            Iterable atmosphereImgList = floorData.getAtmosphereImgList();
            if (atmosphereImgList != null) {
                Iterable $this$forEach$iv = atmosphereImgList;
                for (Object element$iv : $this$forEach$iv) {
                    ImageColorModel imageModel = (ImageColorModel) element$iv;
                    LabelObject labelObject = transferAtmosphereToLabelObject(imageModel);
                    if (labelObject != null) {
                        tagList2.add(labelObject);
                        Unit unit = Unit.INSTANCE;
                        Unit unit2 = Unit.INSTANCE;
                    }
                }
                Unit unit3 = Unit.INSTANCE;
            }
            Iterable salePoint = floorData.getSalePoint();
            if (salePoint != null) {
                Iterable $this$forEach$iv2 = salePoint;
                for (Object element$iv2 : $this$forEach$iv2) {
                    BasicInfoFloor.SalePoint salePoint2 = (BasicInfoFloor.SalePoint) element$iv2;
                    if (salePoint2.getSalePoint() != null) {
                        tagList2.add(salePoint2.getSalePoint());
                    }
                }
                Unit unit4 = Unit.INSTANCE;
            }
            Modifier modifier$iv = PaddingKt.padding-VpY3zN4$default(SizeKt.fillMaxWidth$default(modifier2, 0.0f, 1, (Object) null), ProvideUiScaleKt.dpScaled(16, scale), 0.0f, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer4, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
            CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer4, modifier$iv);
            Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
            Modifier modifier5 = modifier2;
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer4.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer4.startReusableNode();
            if ($composer4.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv4;
                $composer4.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv4;
                $composer4.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer4);
            $composer2 = $composer4;
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer4, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i4 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer4, 584704288, "C87@3338L42,88@3389L3172:BasicInfoFloorComponent.kt#o90vz8");
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(8, scale)), $composer4, 0);
            Modifier modifier$iv2 = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer4, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv2 = (6 << 3) & 112;
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
                factory$iv$iv$iv2 = factory$iv$iv$iv5;
                $composer4.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv5;
                $composer4.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer4);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i5 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer4, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            int i6 = ((6 >> 6) & 112) | 6;
            BoxScope $this$BasicInfoFloorComponent_u24lambda_u246_u240 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer4, -1837715878, "C92@3500L81,102@3801L81,107@3969L6,117@4419L573,105@3895L1112:BasicInfoFloorComponent.kt#o90vz8");
            ComposerKt.sourceInformationMarkerStart($composer4, -1721851059, "CC(remember):BasicInfoFloorComponent.kt#9igjgp");
            boolean invalid$iv3 = $composer4.changed(itemsName);
            Object it$iv = $composer4.rememberedValue();
            if (!invalid$iv3 && it$iv != Composer.Companion.getEmpty()) {
                value$iv = it$iv;
                expandState = (MutableState) value$iv;
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerStart($composer4, -1721841427, "CC(remember):BasicInfoFloorComponent.kt#9igjgp");
                invalid$iv = $composer4.changed(itemsName);
                Object it$iv2 = $composer4.rememberedValue();
                if (!invalid$iv && it$iv2 != Composer.Companion.getEmpty()) {
                    tagList = tagList2;
                    collapsedHasOverflow = (MutableState) it$iv2;
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    long j = BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getGa10-0d7_KjU();
                    TextStyle scaled = ProvideUiScaleKt.scaled(new TextStyle(0L, TextUnitKt.getSp(15), FontWeight.Companion.getSemiBold(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, TextUnitKt.getSp(0.5d), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(22), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646009, (DefaultConstructorMarker) null), scale);
                    int i7 = !((Boolean) expandState.getValue()).booleanValue() ? Integer.MAX_VALUE : 2;
                    int i8 = TextOverflow.Companion.getEllipsis-gIe3tQ8();
                    ComposerKt.sourceInformationMarkerStart($composer4, -1721821159, "CC(remember):BasicInfoFloorComponent.kt#9igjgp");
                    invalid$iv2 = $composer4.changed(expandState) | $composer4.changed(collapsedHasOverflow);
                    Object it$iv3 = $composer4.rememberedValue();
                    if (invalid$iv2) {
                    }
                    Object value$iv3 = new Function1() { // from class: kntr.app.mall.product.details.page.ui.components.BasicInfoFloorComponentKt$$ExternalSyntheticLambda2
                        public final Object invoke(Object obj) {
                            Unit BasicInfoFloorComponent$lambda$6$0$2$0;
                            BasicInfoFloorComponent$lambda$6$0$2$0 = BasicInfoFloorComponentKt.BasicInfoFloorComponent$lambda$6$0$2$0(expandState, collapsedHasOverflow, (TextLayoutResult) obj);
                            return BasicInfoFloorComponent$lambda$6$0$2$0;
                        }
                    };
                    $composer4.updateRememberedValue(value$iv3);
                    it$iv3 = value$iv3;
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    TextKt.Text-Nvy7gAk(itemsName, (Modifier) null, j, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, i8, false, i7, 0, (Function1) it$iv3, scaled, $composer4, 0, 384, 45050);
                    if (((Boolean) collapsedHasOverflow.getValue()).booleanValue()) {
                        $composer$iv$iv = $composer4;
                        $composer$iv = $composer4;
                        $composer4.startReplaceGroup(-1841250778);
                    } else {
                        $composer4.startReplaceGroup(-1836190772);
                        ComposerKt.sourceInformation($composer4, "144@5666L18,147@5812L102,132@5071L1466");
                        Modifier background$default = BackgroundKt.background$default(SizeKt.height-3ABfNKs(SizeKt.width-3ABfNKs($this$BasicInfoFloorComponent_u24lambda_u246_u240.align(Modifier.Companion, Alignment.Companion.getBottomEnd()), ProvideUiScaleKt.dpScaled(32, scale)), ProvideUiScaleKt.dpScaled(22, scale)), Brush.Companion.horizontalGradient-8A-3gB4$default(Brush.Companion, CollectionsKt.listOf(new Color[]{Color.box-impl(Color.Companion.getTransparent-0d7_KjU()), Color.box-impl(ThemesKt.getPageCardColor($composer4, 0))}), 0.0f, 0.0f, 0, 14, (Object) null), (Shape) null, 0.0f, 6, (Object) null);
                        ComposerKt.sourceInformationMarkerStart($composer4, -1721777054, "CC(remember):BasicInfoFloorComponent.kt#9igjgp");
                        boolean invalid$iv4 = $composer4.changed(expandState);
                        Object it$iv4 = $composer4.rememberedValue();
                        if (invalid$iv4) {
                        }
                        Object value$iv4 = new Function0() { // from class: kntr.app.mall.product.details.page.ui.components.BasicInfoFloorComponentKt$$ExternalSyntheticLambda3
                            public final Object invoke() {
                                Unit BasicInfoFloorComponent$lambda$6$0$3$0;
                                BasicInfoFloorComponent$lambda$6$0$3$0 = BasicInfoFloorComponentKt.BasicInfoFloorComponent$lambda$6$0$3$0(expandState);
                                return BasicInfoFloorComponent$lambda$6$0$3$0;
                            }
                        };
                        $composer4.updateRememberedValue(value$iv4);
                        it$iv4 = value$iv4;
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        Modifier modifier$iv3 = ClickableKt.clickable-oSLSa3U$default(background$default, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv4, 15, (Object) null);
                        Alignment contentAlignment$iv2 = Alignment.Companion.getCenterEnd();
                        ComposerKt.sourceInformationMarkerStart($composer4, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicy$iv3 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
                        int $changed$iv$iv3 = (48 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
                        CompositionLocalMap localMap$iv$iv3 = $composer4.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer4, modifier$iv3);
                        Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
                        int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
                        $composer$iv = $composer4;
                        ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                        if (!($composer4.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer4.startReusableNode();
                        if ($composer4.getInserting()) {
                            factory$iv$iv$iv3 = factory$iv$iv$iv6;
                            $composer4.createNode(factory$iv$iv$iv3);
                        } else {
                            factory$iv$iv$iv3 = factory$iv$iv$iv6;
                            $composer4.useNode();
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer4);
                        $composer$iv$iv = $composer4;
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
                        int i9 = ($changed$iv$iv$iv3 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer4, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                        BoxScope boxScope = BoxScopeInstance.INSTANCE;
                        int i10 = ((48 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer4, -478922257, "C153@6069L23,155@6186L6,159@6377L119,152@6016L503:BasicInfoFloorComponent.kt#o90vz8");
                        Painter arrow_collapse_line_500 = BiliIconfont.INSTANCE.getArrow_collapse_line_500($composer4, 6);
                        long j2 = BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getText3-0d7_KjU();
                        Modifier modifier6 = SizeKt.size-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(12, scale));
                        ComposerKt.sourceInformationMarkerStart($composer4, 1231488052, "CC(remember):BasicInfoFloorComponent.kt#9igjgp");
                        boolean invalid$iv5 = $composer4.changed(expandState);
                        Object it$iv5 = $composer4.rememberedValue();
                        if (!invalid$iv5 && it$iv5 != Composer.Companion.getEmpty()) {
                            value$iv2 = it$iv5;
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            IconKt.Icon-ww6aTOc(arrow_collapse_line_500, (String) null, GraphicsLayerModifierKt.graphicsLayer(modifier6, (Function1) value$iv2), j2, $composer4, Painter.$stable | 48, 0);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            $composer4.endNode();
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                        }
                        Object obj = new Function1() { // from class: kntr.app.mall.product.details.page.ui.components.BasicInfoFloorComponentKt$$ExternalSyntheticLambda4
                            public final Object invoke(Object obj2) {
                                Unit BasicInfoFloorComponent$lambda$6$0$4$0$0;
                                BasicInfoFloorComponent$lambda$6$0$4$0$0 = BasicInfoFloorComponentKt.BasicInfoFloorComponent$lambda$6$0$4$0$0(expandState, (GraphicsLayerScope) obj2);
                                return BasicInfoFloorComponent$lambda$6$0$4$0$0;
                            }
                        };
                        $composer4.updateRememberedValue(obj);
                        value$iv2 = obj;
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        IconKt.Icon-ww6aTOc(arrow_collapse_line_500, (String) null, GraphicsLayerModifierKt.graphicsLayer(modifier6, (Function1) value$iv2), j2, $composer4, Painter.$stable | 48, 0);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        $composer4.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                    }
                    $composer4.endReplaceGroup();
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    $composer4.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv);
                    if (tagList.isEmpty()) {
                        $composer3 = $composer4;
                        $composer3.startReplaceGroup(587826049);
                        ComposerKt.sourceInformation($composer3, "168@6611L42,174@6870L97,169@6666L316");
                        SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(8, scale)), $composer3, 0);
                        float dpScaled = ProvideUiScaleKt.dpScaled(24, scale);
                        float dpScaled2 = ProvideUiScaleKt.dpScaled(4, scale);
                        ComposerKt.sourceInformationMarkerStart($composer3, -1643597417, "CC(remember):BasicInfoFloorComponent.kt#9igjgp");
                        boolean invalid$iv6 = $composer3.changedInstance(pageVM);
                        Object it$iv6 = $composer3.rememberedValue();
                        if (invalid$iv6 || it$iv6 == Composer.Companion.getEmpty()) {
                            Object value$iv5 = new Function1() { // from class: kntr.app.mall.product.details.page.ui.components.BasicInfoFloorComponentKt$$ExternalSyntheticLambda5
                                public final Object invoke(Object obj2) {
                                    Unit BasicInfoFloorComponent$lambda$6$1$0;
                                    BasicInfoFloorComponent$lambda$6$1$0 = BasicInfoFloorComponentKt.BasicInfoFloorComponent$lambda$6$1$0(PageViewModel.this, (LabelObject) obj2);
                                    return BasicInfoFloorComponent$lambda$6$1$0;
                                }
                            };
                            $composer3.updateRememberedValue(value$iv5);
                            it$iv6 = value$iv5;
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        LabelComponentKt.m492LabelRowComponent1yyLQnY(tagList, scale, dpScaled, dpScaled2, null, (Function1) it$iv6, $composer3, 0, 16);
                    } else {
                        $composer3 = $composer4;
                        $composer3.startReplaceGroup(581268588);
                    }
                    $composer3.endReplaceGroup();
                    brief = floorData.getBrief();
                    if (brief != null || brief.length() == 0) {
                        $composer3.startReplaceGroup(588261909);
                        ComposerKt.sourceInformation($composer3, "181@7054L42,185@7219L6,186@7267L9,182@7109L200");
                        SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(8, scale)), $composer3, 0);
                        TextKt.Text-Nvy7gAk(floorData.getBrief(), (Modifier) null, BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, ProvideUiScaleKt.scaled(BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT12(), scale), $composer3, 0, 24576, 114682);
                    } else {
                        $composer3.startReplaceGroup(581268588);
                    }
                    $composer3.endReplaceGroup();
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    $composer4.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier2 = modifier5;
                }
                tagList = tagList2;
                Object value$iv6 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer4.updateRememberedValue(value$iv6);
                it$iv2 = value$iv6;
                collapsedHasOverflow = (MutableState) it$iv2;
                ComposerKt.sourceInformationMarkerEnd($composer4);
                long j3 = BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getGa10-0d7_KjU();
                TextStyle scaled2 = ProvideUiScaleKt.scaled(new TextStyle(0L, TextUnitKt.getSp(15), FontWeight.Companion.getSemiBold(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, TextUnitKt.getSp(0.5d), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(22), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646009, (DefaultConstructorMarker) null), scale);
                if (!((Boolean) expandState.getValue()).booleanValue()) {
                }
                int i82 = TextOverflow.Companion.getEllipsis-gIe3tQ8();
                ComposerKt.sourceInformationMarkerStart($composer4, -1721821159, "CC(remember):BasicInfoFloorComponent.kt#9igjgp");
                invalid$iv2 = $composer4.changed(expandState) | $composer4.changed(collapsedHasOverflow);
                Object it$iv32 = $composer4.rememberedValue();
                if (invalid$iv2) {
                }
                Object value$iv32 = new Function1() { // from class: kntr.app.mall.product.details.page.ui.components.BasicInfoFloorComponentKt$$ExternalSyntheticLambda2
                    public final Object invoke(Object obj2) {
                        Unit BasicInfoFloorComponent$lambda$6$0$2$0;
                        BasicInfoFloorComponent$lambda$6$0$2$0 = BasicInfoFloorComponentKt.BasicInfoFloorComponent$lambda$6$0$2$0(expandState, collapsedHasOverflow, (TextLayoutResult) obj2);
                        return BasicInfoFloorComponent$lambda$6$0$2$0;
                    }
                };
                $composer4.updateRememberedValue(value$iv32);
                it$iv32 = value$iv32;
                ComposerKt.sourceInformationMarkerEnd($composer4);
                TextKt.Text-Nvy7gAk(itemsName, (Modifier) null, j3, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, i82, false, i7, 0, (Function1) it$iv32, scaled2, $composer4, 0, 384, 45050);
                if (((Boolean) collapsedHasOverflow.getValue()).booleanValue()) {
                }
                $composer4.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                $composer4.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                if (tagList.isEmpty()) {
                }
                $composer3.endReplaceGroup();
                brief = floorData.getBrief();
                if (brief != null || brief.length() == 0) {
                }
                $composer3.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                $composer4.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier2 = modifier5;
            }
            Object mutableStateOf$default = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
            $composer4.updateRememberedValue(mutableStateOf$default);
            value$iv = mutableStateOf$default;
            expandState = (MutableState) value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerStart($composer4, -1721841427, "CC(remember):BasicInfoFloorComponent.kt#9igjgp");
            invalid$iv = $composer4.changed(itemsName);
            Object it$iv22 = $composer4.rememberedValue();
            if (!invalid$iv) {
                tagList = tagList2;
                collapsedHasOverflow = (MutableState) it$iv22;
                ComposerKt.sourceInformationMarkerEnd($composer4);
                long j32 = BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getGa10-0d7_KjU();
                TextStyle scaled22 = ProvideUiScaleKt.scaled(new TextStyle(0L, TextUnitKt.getSp(15), FontWeight.Companion.getSemiBold(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, TextUnitKt.getSp(0.5d), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(22), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646009, (DefaultConstructorMarker) null), scale);
                if (!((Boolean) expandState.getValue()).booleanValue()) {
                }
                int i822 = TextOverflow.Companion.getEllipsis-gIe3tQ8();
                ComposerKt.sourceInformationMarkerStart($composer4, -1721821159, "CC(remember):BasicInfoFloorComponent.kt#9igjgp");
                invalid$iv2 = $composer4.changed(expandState) | $composer4.changed(collapsedHasOverflow);
                Object it$iv322 = $composer4.rememberedValue();
                if (invalid$iv2) {
                }
                Object value$iv322 = new Function1() { // from class: kntr.app.mall.product.details.page.ui.components.BasicInfoFloorComponentKt$$ExternalSyntheticLambda2
                    public final Object invoke(Object obj2) {
                        Unit BasicInfoFloorComponent$lambda$6$0$2$0;
                        BasicInfoFloorComponent$lambda$6$0$2$0 = BasicInfoFloorComponentKt.BasicInfoFloorComponent$lambda$6$0$2$0(expandState, collapsedHasOverflow, (TextLayoutResult) obj2);
                        return BasicInfoFloorComponent$lambda$6$0$2$0;
                    }
                };
                $composer4.updateRememberedValue(value$iv322);
                it$iv322 = value$iv322;
                ComposerKt.sourceInformationMarkerEnd($composer4);
                TextKt.Text-Nvy7gAk(itemsName, (Modifier) null, j32, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, i822, false, i7, 0, (Function1) it$iv322, scaled22, $composer4, 0, 384, 45050);
                if (((Boolean) collapsedHasOverflow.getValue()).booleanValue()) {
                }
                $composer4.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                $composer4.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                if (tagList.isEmpty()) {
                }
                $composer3.endReplaceGroup();
                brief = floorData.getBrief();
                if (brief != null || brief.length() == 0) {
                }
                $composer3.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                $composer4.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier2 = modifier5;
            }
            tagList = tagList2;
            Object value$iv62 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
            $composer4.updateRememberedValue(value$iv62);
            it$iv22 = value$iv62;
            collapsedHasOverflow = (MutableState) it$iv22;
            ComposerKt.sourceInformationMarkerEnd($composer4);
            long j322 = BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getGa10-0d7_KjU();
            TextStyle scaled222 = ProvideUiScaleKt.scaled(new TextStyle(0L, TextUnitKt.getSp(15), FontWeight.Companion.getSemiBold(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, TextUnitKt.getSp(0.5d), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(22), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646009, (DefaultConstructorMarker) null), scale);
            if (!((Boolean) expandState.getValue()).booleanValue()) {
            }
            int i8222 = TextOverflow.Companion.getEllipsis-gIe3tQ8();
            ComposerKt.sourceInformationMarkerStart($composer4, -1721821159, "CC(remember):BasicInfoFloorComponent.kt#9igjgp");
            invalid$iv2 = $composer4.changed(expandState) | $composer4.changed(collapsedHasOverflow);
            Object it$iv3222 = $composer4.rememberedValue();
            if (invalid$iv2) {
            }
            Object value$iv3222 = new Function1() { // from class: kntr.app.mall.product.details.page.ui.components.BasicInfoFloorComponentKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj2) {
                    Unit BasicInfoFloorComponent$lambda$6$0$2$0;
                    BasicInfoFloorComponent$lambda$6$0$2$0 = BasicInfoFloorComponentKt.BasicInfoFloorComponent$lambda$6$0$2$0(expandState, collapsedHasOverflow, (TextLayoutResult) obj2);
                    return BasicInfoFloorComponent$lambda$6$0$2$0;
                }
            };
            $composer4.updateRememberedValue(value$iv3222);
            it$iv3222 = value$iv3222;
            ComposerKt.sourceInformationMarkerEnd($composer4);
            TextKt.Text-Nvy7gAk(itemsName, (Modifier) null, j322, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, i8222, false, i7, 0, (Function1) it$iv3222, scaled222, $composer4, 0, 384, 45050);
            if (((Boolean) collapsedHasOverflow.getValue()).booleanValue()) {
            }
            $composer4.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            $composer4.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            if (tagList.isEmpty()) {
            }
            $composer3.endReplaceGroup();
            brief = floorData.getBrief();
            if (brief != null || brief.length() == 0) {
            }
            $composer3.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            $composer4.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier2 = modifier5;
        } else {
            $composer2 = $composer4;
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup3 = $composer2.endRestartGroup();
        if (endRestartGroup3 != null) {
            final Modifier modifier7 = modifier2;
            endRestartGroup3.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.BasicInfoFloorComponentKt$$ExternalSyntheticLambda6
                public final Object invoke(Object obj2, Object obj3) {
                    Unit BasicInfoFloorComponent$lambda$7;
                    BasicInfoFloorComponent$lambda$7 = BasicInfoFloorComponentKt.BasicInfoFloorComponent$lambda$7(ContentModule.this, pageViewModelWrapper, modifier7, $changed, i, (Composer) obj2, ((Integer) obj3).intValue());
                    return BasicInfoFloorComponent$lambda$7;
                }
            });
        }
    }

    private static final UiScaleModel BasicInfoFloorComponent$lambda$1(State<UiScaleModel> state) {
        Object thisObj$iv = state.getValue();
        return (UiScaleModel) thisObj$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BasicInfoFloorComponent$lambda$6$0$2$0(MutableState $expandState, MutableState $collapsedHasOverflow, TextLayoutResult layoutResult) {
        Intrinsics.checkNotNullParameter(layoutResult, "layoutResult");
        if (!((Boolean) $expandState.getValue()).booleanValue()) {
            boolean hasOverflow = layoutResult.getHasVisualOverflow() || (layoutResult.getLineCount() >= 2 && layoutResult.isLineEllipsized(1));
            if (hasOverflow && !((Boolean) $collapsedHasOverflow.getValue()).booleanValue()) {
                $collapsedHasOverflow.setValue(true);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BasicInfoFloorComponent$lambda$6$0$3$0(MutableState $expandState) {
        $expandState.setValue(Boolean.valueOf(!((Boolean) $expandState.getValue()).booleanValue()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BasicInfoFloorComponent$lambda$6$0$4$0$0(MutableState $expandState, GraphicsLayerScope $this$graphicsLayer) {
        Intrinsics.checkNotNullParameter($this$graphicsLayer, "$this$graphicsLayer");
        $this$graphicsLayer.setRotationZ(((Boolean) $expandState.getValue()).booleanValue() ? 180.0f : 0.0f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BasicInfoFloorComponent$lambda$6$1$0(PageViewModel $pageVM, LabelObject labelObject) {
        Intrinsics.checkNotNullParameter(labelObject, "labelObject");
        $pageVM.handleLabelObjectClick$product_details_page_debug(labelObject);
        return Unit.INSTANCE;
    }

    public static final LabelObject transferAtmosphereToLabelObject(ImageModel imageModel) {
        Intrinsics.checkNotNullParameter(imageModel, "imageModel");
        if (imageModel.getHeight() == null || imageModel.getWidth() == null || imageModel.getUrl() == null) {
            return null;
        }
        return new LabelObject((String) null, (String) null, (Double) null, (Double) null, (String) null, (String) null, Double.valueOf(imageModel.getHeight().doubleValue()), imageModel.getUrl(), Double.valueOf(imageModel.getWidth().doubleValue()), (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Integer) null, (Integer) 2, (String) null, (String) null, (String) null, (String) null, (String) null, (Integer) null, (String) null, (String) null, (String) null, (Integer) null, (String) null, (Integer) null, (Integer) null, (String) null, (String) null, (Double) null, (Double) null, -131521, 7, (DefaultConstructorMarker) null);
    }

    public static final LabelObject transferAtmosphereToLabelObject(ImageColorModel imageModel) {
        Intrinsics.checkNotNullParameter(imageModel, "imageModel");
        if (imageModel.getHeight() == null || imageModel.getWidth() == null || imageModel.getUrl() == null) {
            return null;
        }
        String url = imageModel.getUrl();
        double doubleValue = imageModel.getWidth().doubleValue();
        double doubleValue2 = imageModel.getHeight().doubleValue();
        return new LabelObject((String) null, (String) null, (Double) null, (Double) null, imageModel.getBackDayColor(), (String) null, Double.valueOf(doubleValue2), url, Double.valueOf(doubleValue), imageModel.getBackNightColor(), (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Integer) null, (Integer) 2, (String) null, (String) null, (String) null, (String) null, (String) null, (Integer) null, (String) null, (String) null, (String) null, (Integer) null, (String) null, (Integer) null, (Integer) null, (String) null, (String) null, (Double) null, (Double) null, -132049, 7, (DefaultConstructorMarker) null);
    }

    public static final LabelObject transferPromoInfoToLabelObject(BasicInfoFloor.PromotionInfoVO promoInfoVO) {
        LabelObject promoInfo;
        Integer tagType;
        if (promoInfoVO == null || (promoInfo = promoInfoVO.getPromoTag()) == null || (tagType = promoInfo.getTagType()) == null || tagType.intValue() != 3) {
            return null;
        }
        LabelObject labelObject = new LabelObject((String) null, (String) null, (Double) null, (Double) null, "ff67b6ff", "ffAF60ff", Double.valueOf(20.0d), "https://i0.hdslb.com/bfs/kfptfe/floor/f41f5e5297d7963a27d39a9356f386c13eb0f2ec.png", Double.valueOf(70.0d), "ff67b6ff", "ffAF60ff", (String) null, (String) null, (String) null, (String) null, (String) null, (Integer) 4, (Integer) 4, promoInfo.getTitle(), "ffffffff", "ffffffff", "ffffffff", "ffffffff", (Integer) 1, (String) null, (String) null, (String) null, (Integer) null, (String) null, (Integer) null, (Integer) null, (String) null, (String) null, (Double) null, (Double) null, -16713713, 7, (DefaultConstructorMarker) null);
        return labelObject;
    }

    public static final void ServiceRightTagComponent(final LabelObject serviceRightTag, final float scale, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Composer $composer2;
        Modifier modifier3;
        Modifier modifier4;
        Function0 factory$iv$iv$iv;
        Intrinsics.checkNotNullParameter(serviceRightTag, "serviceRightTag");
        Composer $composer3 = $composer.startRestartGroup(483240187);
        ComposerKt.sourceInformation($composer3, "C(ServiceRightTagComponent)N(serviceRightTag,scale,modifier)251@9364L10,252@9412L15,255@9544L744:BasicInfoFloorComponent.kt#o90vz8");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(serviceRightTag) ? 4 : 2;
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
                ComposerKt.traceEventStart(483240187, $dirty2, -1, "kntr.app.mall.product.details.page.ui.components.ServiceRightTagComponent (BasicInfoFloorComponent.kt:249)");
            }
            String title = serviceRightTag.getTitle();
            if (title == null) {
                title = "";
            }
            String text = title;
            String imgUrl = serviceRightTag.getBgImg$product_details_page_debug($composer3, $dirty2 & 14);
            Color titleColor = serviceRightTag.m306getTitleColor6MYuD4A$product_details_page_debug($composer3, $dirty2 & 14);
            Double backImgWidth = serviceRightTag.getBackImgWidth();
            double imgWidth = backImgWidth != null ? backImgWidth.doubleValue() : 0.0d;
            Double backImgHeight = serviceRightTag.getBackImgHeight();
            double imgHeight = backImgHeight != null ? backImgHeight.doubleValue() : 0.0d;
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            int $changed$iv = (($dirty2 >> 6) & 14) | 384;
            Modifier modifier$iv = modifier4;
            modifier3 = modifier4;
            ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, (($changed$iv >> 3) & 14) | (($changed$iv >> 3) & 112));
            int $changed$iv$iv = ($changed$iv << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            $composer2 = $composer3;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer3.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv2;
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
            int i4 = (($changed$iv >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -115323508, "C274@10186L9,271@10072L210:BasicInfoFloorComponent.kt#o90vz8");
            String str = imgUrl;
            if (str == null || str.length() == 0) {
                $composer3.startReplaceGroup(-124916893);
            } else {
                $composer3.startReplaceGroup(-115302429);
                ComposerKt.sourceInformation($composer3, "260@9693L360");
                String $this$asRequest$iv = HelperKt.customizedImageUrl(imgUrl);
                ImageRequest $this$ServiceRightTagComponent_u24lambda_u240_u240 = new ImageRequest($this$asRequest$iv);
                $this$ServiceRightTagComponent_u24lambda_u240_u240.contentScale(ContentScale.Companion.getFit());
                BiliImageKt.BiliImage($this$ServiceRightTagComponent_u24lambda_u240_u240.build(), SizeKt.height-3ABfNKs(SizeKt.width-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(imgWidth, scale)), ProvideUiScaleKt.dpScaled(imgHeight, scale)), null, null, null, null, null, null, null, $composer3, 0, 508);
            }
            $composer3.endReplaceGroup();
            TextKt.Text-Nvy7gAk(text, (Modifier) null, titleColor != null ? titleColor.unbox-impl() : ColorKt.Color(4280993892L), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT12(), $composer3, 0, 24960, 110586);
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
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.BasicInfoFloorComponentKt$$ExternalSyntheticLambda7
                public final Object invoke(Object obj, Object obj2) {
                    Unit ServiceRightTagComponent$lambda$1;
                    ServiceRightTagComponent$lambda$1 = BasicInfoFloorComponentKt.ServiceRightTagComponent$lambda$1(LabelObject.this, scale, modifier5, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return ServiceRightTagComponent$lambda$1;
                }
            });
        }
    }
}