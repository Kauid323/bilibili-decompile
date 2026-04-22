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
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
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
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
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
import kntr.app.mall.product.details.page.api.model.DeliveryInfoFloor;
import kntr.app.mall.product.details.page.ui.scale.ProvideUiScaleKt;
import kntr.app.mall.product.details.page.ui.scale.UiScaleModel;
import kntr.app.mall.product.details.page.utils.HelperKt;
import kntr.app.mall.product.details.page.vm.ContentModule;
import kntr.app.mall.product.details.page.vm.DeliveryInfoContainerState;
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
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeliveryInfoFloorComponent.kt */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0001¢\u0006\u0002\u0010\b\u001a\u001f\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0001¢\u0006\u0002\u0010\f¨\u0006\r²\u0006\n\u0010\u000e\u001a\u00020\u000fX\u008a\u0084\u0002²\u0006\f\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u008a\u0084\u0002"}, d2 = {"DeliveryInfoFloorComponent", "", "module", "Lkntr/app/mall/product/details/page/vm/ContentModule;", "pageViewModelWrapper", "Lkntr/app/mall/product/details/page/vm/PageViewModelWrapper;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lkntr/app/mall/product/details/page/vm/ContentModule;Lkntr/app/mall/product/details/page/vm/PageViewModelWrapper;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "FreeDeliveryLabel", "scale", "", "(FLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "product-details-page_debug", "scaleModel", "Lkntr/app/mall/product/details/page/ui/scale/UiScaleModel;", "deliveryInfoContainerState", "Lkntr/app/mall/product/details/page/vm/DeliveryInfoContainerState;"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class DeliveryInfoFloorComponentKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeliveryInfoFloorComponent$lambda$0(ContentModule contentModule, PageViewModelWrapper pageViewModelWrapper, Modifier modifier, int i, int i2, Composer composer, int i3) {
        DeliveryInfoFloorComponent(contentModule, pageViewModelWrapper, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeliveryInfoFloorComponent$lambda$3(ContentModule contentModule, PageViewModelWrapper pageViewModelWrapper, Modifier modifier, int i, int i2, Composer composer, int i3) {
        DeliveryInfoFloorComponent(contentModule, pageViewModelWrapper, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeliveryInfoFloorComponent$lambda$7(ContentModule contentModule, PageViewModelWrapper pageViewModelWrapper, Modifier modifier, int i, int i2, Composer composer, int i3) {
        DeliveryInfoFloorComponent(contentModule, pageViewModelWrapper, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FreeDeliveryLabel$lambda$1(float f, Modifier modifier, int i, int i2, Composer composer, int i3) {
        FreeDeliveryLabel(f, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:122:0x0230, code lost:
        if (r14 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L116;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void DeliveryInfoFloorComponent(final ContentModule module, final PageViewModelWrapper pageViewModelWrapper, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Composer $composer2;
        Modifier modifier3;
        Modifier modifier4;
        DeliveryInfoFloor floorData;
        PageViewModel pageViewModel;
        Composer $composer3;
        Modifier modifier5;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Function0 factory$iv$iv$iv3;
        Function0 factory$iv$iv$iv4;
        Function0 factory$iv$iv$iv5;
        String addr;
        ContentModule.DeliveryInfoModule data;
        Intrinsics.checkNotNullParameter(module, "module");
        Intrinsics.checkNotNullParameter(pageViewModelWrapper, "pageViewModelWrapper");
        Composer $composer4 = $composer.startRestartGroup(944161580);
        ComposerKt.sourceInformation($composer4, "C(DeliveryInfoFloorComponent)N(module,pageViewModelWrapper,modifier)41@1773L16,43@1902L16,65@2796L164,62@2724L2504:DeliveryInfoFloorComponent.kt#o90vz8");
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
        if (!$composer4.shouldExecute(($dirty2 & 147) != 146, $dirty2 & 1)) {
            $composer2 = $composer4;
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(944161580, $dirty2, -1, "kntr.app.mall.product.details.page.ui.components.DeliveryInfoFloorComponent (DeliveryInfoFloorComponent.kt:36)");
            }
            if (module instanceof ContentModule.DeliveryInfoModule) {
                final PageViewModel pageViewModel2 = pageViewModelWrapper.getViewModel();
                State scaleModel$delegate = SnapshotStateKt.collectAsState(pageViewModel2.getUiScaleModelFlow$product_details_page_debug(), (CoroutineContext) null, $composer4, 0, 1);
                float scale = DeliveryInfoFloorComponent$lambda$1(scaleModel$delegate).getScale();
                State deliveryInfoContainerState$delegate = SnapshotStateKt.collectAsState(pageViewModel2.getDeliveryInfoContainerState$product_details_page_debug(), (CoroutineContext) null, $composer4, 0, 1);
                DeliveryInfoContainerState DeliveryInfoFloorComponent$lambda$2 = DeliveryInfoFloorComponent$lambda$2(deliveryInfoContainerState$delegate);
                final DeliveryInfoFloor floorData2 = (DeliveryInfoFloorComponent$lambda$2 == null || (data = DeliveryInfoFloorComponent$lambda$2.getData()) == null) ? null : data.getData();
                if (floorData2 != null) {
                    DeliveryInfoFloor.ItemsDeliveryInfo deliveryInfo = floorData2.getItemsDeliveryInfo();
                    if (deliveryInfo == null) {
                        floorData = floorData2;
                        pageViewModel = pageViewModel2;
                        $composer3 = $composer4;
                        modifier5 = modifier4;
                    } else {
                        String addrText = floorData2.getAddrText();
                        if (addrText == null) {
                            addrText = "";
                        }
                        String str = addrText;
                        DeliveryInfoFloor.UserDefAddrVO it = floorData2.getUserDefAddrVO();
                        if (it != null) {
                            String city = it.getCity();
                            String str2 = city == null ? "" : city;
                            String area = it.getArea();
                            str = "配送至 " + str2 + (area == null ? "" : area) + (it.getAddr() == null ? "" : addr);
                            Unit unit = Unit.INSTANCE;
                            Unit unit2 = Unit.INSTANCE;
                        }
                        String str3 = str;
                        String deliveryModeDesc = deliveryInfo.getDeliveryModeDesc();
                        String str4 = deliveryModeDesc == null || deliveryModeDesc.length() == 0 ? "" : ((Object) "") + deliveryInfo.getDeliveryModeDesc() + " ";
                        String deliveryMainDesc = deliveryInfo.getDeliveryMainDesc();
                        if (!(deliveryMainDesc == null || deliveryMainDesc.length() == 0)) {
                            str4 = ((Object) str4) + (str4.length() == 0 ? "" : "，") + deliveryInfo.getDeliveryMainDesc();
                        }
                        String deliveryFeeDesc = deliveryInfo.getDeliveryFeeDesc();
                        if (!(deliveryFeeDesc == null || deliveryFeeDesc.length() == 0) && !Intrinsics.areEqual(deliveryInfo.getFreeDelivery(), true)) {
                            str4 = ((Object) str4) + (str4.length() == 0 ? "" : "，") + deliveryInfo.getDeliveryFeeDesc();
                        }
                        ComposerKt.sourceInformationMarkerStart($composer4, 1101222384, "CC(remember):DeliveryInfoFloorComponent.kt#9igjgp");
                        boolean invalid$iv = $composer4.changedInstance(floorData2) | $composer4.changedInstance(pageViewModel2);
                        Object it$iv = $composer4.rememberedValue();
                        if (invalid$iv) {
                        }
                        Object value$iv = new Function0() { // from class: kntr.app.mall.product.details.page.ui.components.DeliveryInfoFloorComponentKt$$ExternalSyntheticLambda2
                            public final Object invoke() {
                                Unit DeliveryInfoFloorComponent$lambda$5$0;
                                DeliveryInfoFloorComponent$lambda$5$0 = DeliveryInfoFloorComponentKt.DeliveryInfoFloorComponent$lambda$5$0(DeliveryInfoFloor.this, pageViewModel2);
                                return DeliveryInfoFloorComponent$lambda$5$0;
                            }
                        };
                        $composer4.updateRememberedValue(value$iv);
                        it$iv = value$iv;
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        Modifier modifier$iv = ClickableKt.clickable-oSLSa3U$default(modifier4, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null);
                        Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
                        ComposerKt.sourceInformationMarkerStart($composer4, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                        Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                        MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer4, ((384 >> 3) & 14) | ((384 >> 3) & 112));
                        int $changed$iv$iv = (384 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
                        CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer4, modifier$iv);
                        Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
                        int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                        modifier3 = modifier4;
                        $composer2 = $composer4;
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
                        Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer4);
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
                        int i3 = ($changed$iv$iv$iv >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer4, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                        int i4 = ((384 >> 6) & 112) | 6;
                        RowScope $this$DeliveryInfoFloorComponent_u24lambda_u246 = RowScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart($composer4, 1798830375, "C72@3034L580,89@3624L959,120@4592L630:DeliveryInfoFloorComponent.kt#o90vz8");
                        Modifier modifier$iv2 = $this$DeliveryInfoFloorComponent_u24lambda_u246.align(SizeKt.width-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(28, scale)), Alignment.Companion.getCenterVertically());
                        Alignment contentAlignment$iv = Alignment.Companion.getCenterStart();
                        ComposerKt.sourceInformationMarkerStart($composer4, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                        int $changed$iv$iv2 = (48 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
                        CompositionLocalMap localMap$iv$iv2 = $composer4.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer4, modifier$iv2);
                        Function0 factory$iv$iv$iv7 = ComposeUiNode.Companion.getConstructor();
                        int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                        String str5 = str4;
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
                        Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer4);
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
                        int i5 = ($changed$iv$iv$iv2 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer4, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                        BoxScope boxScope = BoxScopeInstance.INSTANCE;
                        int i6 = ((48 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer4, -623619427, "C:DeliveryInfoFloorComponent.kt#o90vz8");
                        String floorIcon = floorData2.getFloorIcon();
                        String str6 = floorIcon;
                        if (str6 == null || str6.length() == 0) {
                            $composer4.startReplaceGroup(-626872692);
                        } else {
                            $composer4.startReplaceGroup(-623542548);
                            ComposerKt.sourceInformation($composer4, "81@3366L224");
                            String $this$asRequest_u24default$iv = HelperKt.customizedImageUrl(floorIcon);
                            ImageRequest imageRequest = new ImageRequest($this$asRequest_u24default$iv);
                            Unit unit3 = Unit.INSTANCE;
                            BiliImageKt.BiliImage(imageRequest.build(), OffsetKt.offset-VpY3zN4$default(SizeKt.size-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(16, scale)), ProvideUiScaleKt.dpScaled(-1, scale), 0.0f, 2, (Object) null), null, null, null, null, null, null, null, $composer4, 0, 508);
                        }
                        $composer4.endReplaceGroup();
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        $composer4.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        Modifier modifier$iv3 = RowScope.-CC.weight$default($this$DeliveryInfoFloorComponent_u24lambda_u246, Modifier.Companion, 1.0f, false, 2, (Object) null);
                        ComposerKt.sourceInformationMarkerStart($composer4, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                        Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                        Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
                        MeasurePolicy measurePolicy$iv3 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                        int $changed$iv$iv3 = (0 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
                        CompositionLocalMap localMap$iv$iv3 = $composer4.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer4, modifier$iv3);
                        Function0 factory$iv$iv$iv8 = ComposeUiNode.Companion.getConstructor();
                        int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
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
                        Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer4);
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
                        int i7 = ($changed$iv$iv$iv3 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer4, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                        ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
                        int i8 = ((0 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer4, 1192309945, "C106@4153L420:DeliveryInfoFloorComponent.kt#o90vz8");
                        if (str3.length() > 0) {
                            $composer4.startReplaceGroup(1192339301);
                            ComposerKt.sourceInformation($composer4, "97@3863L6,98@3915L9,95@3782L343");
                            TextKt.Text-Nvy7gAk(str3, PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, 0.0f, ProvideUiScaleKt.dpScaled(4, scale), 7, (Object) null), BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getText2-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, ProvideUiScaleKt.scaled(BiliTheme.INSTANCE.getTextStyle($composer4, BiliTheme.$stable).getT13(), scale), $composer4, 0, 24576, 114680);
                        } else {
                            $composer4.startReplaceGroup(1188575932);
                        }
                        $composer4.endReplaceGroup();
                        ComposerKt.sourceInformationMarkerStart($composer4, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                        Modifier modifier$iv4 = Modifier.Companion;
                        Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.getStart();
                        Alignment.Vertical verticalAlignment$iv2 = Alignment.Companion.getTop();
                        DeliveryInfoFloor floorData3 = floorData2;
                        MeasurePolicy measurePolicy$iv4 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                        int $changed$iv$iv4 = (0 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv4 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
                        CompositionLocalMap localMap$iv$iv4 = $composer4.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer4, modifier$iv4);
                        Function0 factory$iv$iv$iv9 = ComposeUiNode.Companion.getConstructor();
                        int $changed$iv$iv$iv4 = (($changed$iv$iv4 << 6) & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                        if (!($composer4.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer4.startReusableNode();
                        if ($composer4.getInserting()) {
                            factory$iv$iv$iv4 = factory$iv$iv$iv9;
                            $composer4.createNode(factory$iv$iv$iv4);
                        } else {
                            factory$iv$iv$iv4 = factory$iv$iv$iv9;
                            $composer4.useNode();
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv4 = Updater.constructor-impl($composer4);
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, measurePolicy$iv4, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, localMap$iv$iv4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Updater.init-impl($this$Layout_u24lambda_u240$iv$iv4, Integer.valueOf(compositeKeyHash$iv$iv4), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv4, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, materialized$iv$iv4, ComposeUiNode.Companion.getSetModifier());
                        int i9 = ($changed$iv$iv$iv4 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer4, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                        RowScope rowScope = RowScopeInstance.INSTANCE;
                        int i10 = ((0 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer4, 1786286745, "C114@4427L6,115@4479L9,112@4350L209:DeliveryInfoFloorComponent.kt#o90vz8");
                        if (Intrinsics.areEqual(deliveryInfo.getFreeDelivery(), true)) {
                            $composer4.startReplaceGroup(1786317217);
                            ComposerKt.sourceInformation($composer4, "108@4236L79");
                            FreeDeliveryLabel(scale, null, $composer4, 0, 2);
                        } else {
                            $composer4.startReplaceGroup(1782132248);
                        }
                        $composer4.endReplaceGroup();
                        TextKt.Text-Nvy7gAk(str5, (Modifier) null, BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getText2-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, ProvideUiScaleKt.scaled(BiliTheme.INSTANCE.getTextStyle($composer4, BiliTheme.$stable).getT13(), scale), $composer4, 0, 24576, 114682);
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
                        Modifier modifier6 = Modifier.Companion;
                        Alignment.Vertical verticalAlignment$iv3 = Alignment.Companion.getCenterVertically();
                        Arrangement.Horizontal horizontalArrangement$iv3 = Arrangement.INSTANCE.getEnd();
                        Modifier modifier$iv5 = modifier6;
                        ComposerKt.sourceInformationMarkerStart($composer4, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                        MeasurePolicy measurePolicy$iv5 = RowKt.rowMeasurePolicy(horizontalArrangement$iv3, verticalAlignment$iv3, $composer4, ((438 >> 3) & 14) | ((438 >> 3) & 112));
                        int $changed$iv$iv5 = (438 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv5 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
                        CompositionLocalMap localMap$iv$iv5 = $composer4.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv5 = ComposedModifierKt.materializeModifier($composer4, modifier$iv5);
                        Function0 factory$iv$iv$iv10 = ComposeUiNode.Companion.getConstructor();
                        int $changed$iv$iv$iv5 = (($changed$iv$iv5 << 6) & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                        if (!($composer4.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer4.startReusableNode();
                        if ($composer4.getInserting()) {
                            factory$iv$iv$iv5 = factory$iv$iv$iv10;
                            $composer4.createNode(factory$iv$iv$iv5);
                        } else {
                            factory$iv$iv$iv5 = factory$iv$iv$iv10;
                            $composer4.useNode();
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv5 = Updater.constructor-impl($composer4);
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, measurePolicy$iv5, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, localMap$iv$iv5, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Updater.init-impl($this$Layout_u24lambda_u240$iv$iv5, Integer.valueOf(compositeKeyHash$iv$iv5), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv5, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, materialized$iv$iv5, ComposeUiNode.Companion.getSetModifier());
                        int i11 = ($changed$iv$iv$iv5 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer4, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                        RowScope rowScope2 = RowScopeInstance.INSTANCE;
                        int i12 = ((438 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer4, -29699918, "C:DeliveryInfoFloorComponent.kt#o90vz8");
                        if (Intrinsics.areEqual(floorData3.getCanOpenAddr(), true)) {
                            $composer4.startReplaceGroup(-29649420);
                            ComposerKt.sourceInformation($composer4, "127@4869L28,128@4936L6,126@4820L378");
                            IconKt.Icon-ww6aTOc(BiliIconfont.INSTANCE.getArrow_forward_right_line_500($composer4, 6), (String) null, SizeKt.size-3ABfNKs(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, ProvideUiScaleKt.dpScaled(10, scale), 0.0f, 0.0f, 0.0f, 14, (Object) null), ProvideUiScaleKt.dpScaled(12, scale)), BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getText3-0d7_KjU(), $composer4, Painter.$stable | 48, 0);
                        } else {
                            $composer4.startReplaceGroup(-34443570);
                        }
                        $composer4.endReplaceGroup();
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
                    }
                } else {
                    floorData = floorData2;
                    pageViewModel = pageViewModel2;
                    $composer3 = $composer4;
                    modifier5 = modifier4;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup = $composer3.endRestartGroup();
                if (endRestartGroup != null) {
                    final Modifier modifier7 = modifier5;
                    endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.DeliveryInfoFloorComponentKt$$ExternalSyntheticLambda1
                        public final Object invoke(Object obj, Object obj2) {
                            Unit DeliveryInfoFloorComponent$lambda$3;
                            DeliveryInfoFloorComponent$lambda$3 = DeliveryInfoFloorComponentKt.DeliveryInfoFloorComponent$lambda$3(ContentModule.this, pageViewModelWrapper, modifier7, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                            return DeliveryInfoFloorComponent$lambda$3;
                        }
                    });
                    return;
                }
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            ScopeUpdateScope endRestartGroup2 = $composer4.endRestartGroup();
            if (endRestartGroup2 != null) {
                final Modifier modifier8 = modifier4;
                endRestartGroup2.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.DeliveryInfoFloorComponentKt$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj, Object obj2) {
                        Unit DeliveryInfoFloorComponent$lambda$0;
                        DeliveryInfoFloorComponent$lambda$0 = DeliveryInfoFloorComponentKt.DeliveryInfoFloorComponent$lambda$0(ContentModule.this, pageViewModelWrapper, modifier8, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                        return DeliveryInfoFloorComponent$lambda$0;
                    }
                });
                return;
            }
            return;
        }
        ScopeUpdateScope endRestartGroup3 = $composer2.endRestartGroup();
        if (endRestartGroup3 != null) {
            final Modifier modifier9 = modifier3;
            endRestartGroup3.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.DeliveryInfoFloorComponentKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    Unit DeliveryInfoFloorComponent$lambda$7;
                    DeliveryInfoFloorComponent$lambda$7 = DeliveryInfoFloorComponentKt.DeliveryInfoFloorComponent$lambda$7(ContentModule.this, pageViewModelWrapper, modifier9, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return DeliveryInfoFloorComponent$lambda$7;
                }
            });
        }
    }

    private static final UiScaleModel DeliveryInfoFloorComponent$lambda$1(State<UiScaleModel> state) {
        Object thisObj$iv = state.getValue();
        return (UiScaleModel) thisObj$iv;
    }

    private static final DeliveryInfoContainerState DeliveryInfoFloorComponent$lambda$2(State<DeliveryInfoContainerState> state) {
        Object thisObj$iv = state.getValue();
        return (DeliveryInfoContainerState) thisObj$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeliveryInfoFloorComponent$lambda$5$0(DeliveryInfoFloor $floorData, PageViewModel $pageViewModel) {
        if (Intrinsics.areEqual($floorData.getCanOpenAddr(), true)) {
            $pageViewModel.showDeliveryFloatingLayer$product_details_page_debug();
        }
        return Unit.INSTANCE;
    }

    public static final void FreeDeliveryLabel(final float scale, Modifier modifier, Composer $composer, final int $changed, final int i) {
        final Modifier modifier2;
        Composer $composer2;
        Modifier modifier3;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Composer $composer3 = $composer.startRestartGroup(144666266);
        ComposerKt.sourceInformation($composer3, "C(FreeDeliveryLabel)N(scale,modifier)145@5337L649:DeliveryInfoFloorComponent.kt#o90vz8");
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
                ComposerKt.traceEventStart(144666266, $dirty, -1, "kntr.app.mall.product.details.page.ui.components.FreeDeliveryLabel (DeliveryInfoFloorComponent.kt:144)");
            }
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            int $changed$iv = (($dirty >> 3) & 14) | 384;
            Modifier modifier$iv = modifier3;
            ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, (($changed$iv >> 3) & 14) | (($changed$iv >> 3) & 112));
            int $changed$iv$iv = ($changed$iv << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier modifier4 = modifier3;
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
            int i4 = (($changed$iv >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 626154508, "C151@5504L6,152@5548L9,149@5443L169,156@5622L358:DeliveryInfoFloorComponent.kt#o90vz8");
            TextKt.Text-Nvy7gAk("包邮", (Modifier) null, BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText2-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, ProvideUiScaleKt.scaled(BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT13(), scale), $composer3, 6, 24576, 114682);
            Modifier modifier$iv2 = SizeKt.width-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(12, scale));
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
            $composer2 = $composer3;
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i5 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i6 = ((48 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -212365815, "C162@5935L6,157@5724L246:DeliveryInfoFloorComponent.kt#o90vz8");
            BoxKt.Box(BackgroundKt.background-bw27NRU$default(SizeKt.height-3ABfNKs(SizeKt.width-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(0.5d, scale)), ProvideUiScaleKt.dpScaled(12, scale)), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getLine_regular-0d7_KjU(), (Shape) null, 2, (Object) null), $composer3, 0);
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
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.DeliveryInfoFloorComponentKt$$ExternalSyntheticLambda4
                public final Object invoke(Object obj, Object obj2) {
                    Unit FreeDeliveryLabel$lambda$1;
                    FreeDeliveryLabel$lambda$1 = DeliveryInfoFloorComponentKt.FreeDeliveryLabel$lambda$1(scale, modifier2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return FreeDeliveryLabel$lambda$1;
                }
            });
        }
    }
}