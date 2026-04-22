package kntr.app.mall.product.details.page.ui.components;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.gestures.FlingBehavior;
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
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.SnapshotStateMap;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
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
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kntr.app.mall.product.details.page.api.model.SkuInfoFloor;
import kntr.app.mall.product.details.page.ui.scale.ProvideUiScaleKt;
import kntr.app.mall.product.details.page.ui.scale.UiScaleModel;
import kntr.app.mall.product.details.page.vm.ContentModule;
import kntr.app.mall.product.details.page.vm.FloorType;
import kntr.app.mall.product.details.page.vm.PageViewModel;
import kntr.app.mall.product.details.page.vm.PageViewModelWrapper;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SkuSwitchSheetComponent.kt */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0001¢\u0006\u0002\u0010\u0006\u001a3\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\u000fH\u0003¢\u0006\u0002\u0010\u0010¨\u0006\u0011²\u0006\n\u0010\u0012\u001a\u00020\u0013X\u008a\u0084\u0002"}, d2 = {"SkuSwitchSheetComponent", "", "pageViewModelWrapper", "Lkntr/app/mall/product/details/page/vm/PageViewModelWrapper;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lkntr/app/mall/product/details/page/vm/PageViewModelWrapper;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "SpecValueItem", "specValue", "Lkntr/app/mall/product/details/page/api/model/SkuInfoFloor$ItemsSkuListVO$SpecInfoListItem$SpecValueListItem;", "isSelected", "", "scale", "", "onClick", "Lkotlin/Function0;", "(Lkntr/app/mall/product/details/page/api/model/SkuInfoFloor$ItemsSkuListVO$SpecInfoListItem$SpecValueListItem;ZFLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "product-details-page_debug", "scaleModel", "Lkntr/app/mall/product/details/page/ui/scale/UiScaleModel;"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class SkuSwitchSheetComponentKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SkuSwitchSheetComponent$lambda$2(PageViewModelWrapper pageViewModelWrapper, Modifier modifier, int i, int i2, Composer composer, int i3) {
        SkuSwitchSheetComponent(pageViewModelWrapper, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SkuSwitchSheetComponent$lambda$3(PageViewModelWrapper pageViewModelWrapper, Modifier modifier, int i, int i2, Composer composer, int i3) {
        SkuSwitchSheetComponent(pageViewModelWrapper, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SkuSwitchSheetComponent$lambda$4(PageViewModelWrapper pageViewModelWrapper, Modifier modifier, int i, int i2, Composer composer, int i3) {
        SkuSwitchSheetComponent(pageViewModelWrapper, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SkuSwitchSheetComponent$lambda$5(PageViewModelWrapper pageViewModelWrapper, Modifier modifier, int i, int i2, Composer composer, int i3) {
        SkuSwitchSheetComponent(pageViewModelWrapper, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SkuSwitchSheetComponent$lambda$9(PageViewModelWrapper pageViewModelWrapper, Modifier modifier, int i, int i2, Composer composer, int i3) {
        SkuSwitchSheetComponent(pageViewModelWrapper, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SpecValueItem$lambda$1(SkuInfoFloor.ItemsSkuListVO.SpecInfoListItem.SpecValueListItem specValueListItem, boolean z, float f, Function0 function0, int i, Composer composer, int i2) {
        SpecValueItem(specValueListItem, z, f, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:142:0x068c, code lost:
        if (r13 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L120;
     */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0235  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x02a5  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x033f  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x034b  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0351  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x045c  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0468  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x046e  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x05c5  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x05d1  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x05d7  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0684  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0690  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x07a3  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x07af  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x07b5  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0845  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0a4e  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0a5a  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0a60  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0b4c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void SkuSwitchSheetComponent(final PageViewModelWrapper pageViewModelWrapper, Modifier modifier, Composer $composer, final int $changed, final int i) {
        final Modifier modifier2;
        final int i2;
        Composer $composer2;
        final int i3;
        final PageViewModelWrapper pageViewModelWrapper2;
        Object obj;
        Composer $composer3;
        Modifier modifier3;
        boolean z;
        Map $this$SkuSwitchSheetComponent_u24lambda_u246_u240;
        SkuInfoFloor skuInfoFloor;
        Object it$iv;
        Object it$iv2;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Function0 factory$iv$iv$iv3;
        boolean invalid$iv;
        Function0 factory$iv$iv$iv4;
        boolean invalid$iv2;
        Object it$iv3;
        Function0 factory$iv$iv$iv5;
        Iterable specValues;
        Intrinsics.checkNotNullParameter(pageViewModelWrapper, "pageViewModelWrapper");
        Composer $composer4 = $composer.startRestartGroup(-430339065);
        ComposerKt.sourceInformation($composer4, "C(SkuSwitchSheetComponent)N(pageViewModelWrapper,modifier)49@2123L16,51@2227L16,59@2686L16,63@2782L415,77@3259L316,86@3581L3884:SkuSwitchSheetComponent.kt#o90vz8");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer4.changedInstance(pageViewModelWrapper) ? 4 : 2;
        }
        int i4 = i & 2;
        if (i4 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty |= $composer4.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        if ($composer4.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
            final Modifier modifier4 = i4 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-430339065, $dirty, -1, "kntr.app.mall.product.details.page.ui.components.SkuSwitchSheetComponent (SkuSwitchSheetComponent.kt:47)");
            }
            final PageViewModel pageViewModel = pageViewModelWrapper.getViewModel();
            State scaleModel$delegate = SnapshotStateKt.collectAsState(pageViewModel.getUiScaleModelFlow$product_details_page_debug(), (CoroutineContext) null, $composer4, 0, 1);
            final float scale = SkuSwitchSheetComponent$lambda$0(scaleModel$delegate).getScale();
            State contentModules = SnapshotStateKt.collectAsState(pageViewModel.getContentModules$product_details_page_debug(), (CoroutineContext) null, $composer4, 0, 1);
            Iterator it = ((Iterable) contentModules.getValue()).iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                ContentModule it2 = (ContentModule) obj;
                if (it2.getFloorType() == FloorType.SKU_INFO) {
                    break;
                }
            }
            ContentModule skuInfoModule = (ContentModule) obj;
            ContentModule.SkuInfoModule skuInfoModule2 = (ContentModule.SkuInfoModule) skuInfoModule;
            if (skuInfoModule2 != null) {
                SkuInfoFloor skuInfoFloor2 = skuInfoModule2.getData();
                if (skuInfoFloor2 == null) {
                    $composer3 = $composer4;
                    modifier3 = modifier4;
                } else {
                    SkuInfoFloor.ItemsSkuListVO itemsSkuInfoVO = skuInfoFloor2.getItemsSkuListVO();
                    if (itemsSkuInfoVO == null) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        ScopeUpdateScope endRestartGroup = $composer4.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.SkuSwitchSheetComponentKt$$ExternalSyntheticLambda6
                                public final Object invoke(Object obj2, Object obj3) {
                                    Unit SkuSwitchSheetComponent$lambda$3;
                                    SkuSwitchSheetComponent$lambda$3 = SkuSwitchSheetComponentKt.SkuSwitchSheetComponent$lambda$3(PageViewModelWrapper.this, modifier4, $changed, i, (Composer) obj2, ((Integer) obj3).intValue());
                                    return SkuSwitchSheetComponent$lambda$3;
                                }
                            });
                            return;
                        }
                        return;
                    }
                    Iterable specInfoList = itemsSkuInfoVO.getSpecInfoList();
                    if (specInfoList == null) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        ScopeUpdateScope endRestartGroup2 = $composer4.endRestartGroup();
                        if (endRestartGroup2 != null) {
                            endRestartGroup2.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.SkuSwitchSheetComponentKt$$ExternalSyntheticLambda7
                                public final Object invoke(Object obj2, Object obj3) {
                                    Unit SkuSwitchSheetComponent$lambda$4;
                                    SkuSwitchSheetComponent$lambda$4 = SkuSwitchSheetComponentKt.SkuSwitchSheetComponent$lambda$4(PageViewModelWrapper.this, modifier4, $changed, i, (Composer) obj2, ((Integer) obj3).intValue());
                                    return SkuSwitchSheetComponent$lambda$4;
                                }
                            });
                            return;
                        }
                        return;
                    }
                    final List itemsSkuList = itemsSkuInfoVO.getItemsSkuList();
                    if (itemsSkuList == null) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        ScopeUpdateScope endRestartGroup3 = $composer4.endRestartGroup();
                        if (endRestartGroup3 != null) {
                            endRestartGroup3.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.SkuSwitchSheetComponentKt$$ExternalSyntheticLambda8
                                public final Object invoke(Object obj2, Object obj3) {
                                    Unit SkuSwitchSheetComponent$lambda$5;
                                    SkuSwitchSheetComponent$lambda$5 = SkuSwitchSheetComponentKt.SkuSwitchSheetComponent$lambda$5(PageViewModelWrapper.this, modifier4, $changed, i, (Composer) obj2, ((Integer) obj3).intValue());
                                    return SkuSwitchSheetComponent$lambda$5;
                                }
                            });
                            return;
                        }
                        return;
                    }
                    State currentSelectedSku = SnapshotStateKt.collectAsState(pageViewModel.getFileInfoSelectedSku(), (CoroutineContext) null, $composer4, 0, 1);
                    ComposerKt.sourceInformationMarkerStart($composer4, -1238952378, "CC(remember):SkuSwitchSheetComponent.kt#9igjgp");
                    boolean invalid$iv3 = $composer4.changed(specInfoList);
                    Object it$iv4 = $composer4.rememberedValue();
                    if (!invalid$iv3 && it$iv4 != Composer.Companion.getEmpty()) {
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        Map specValueToSpecName = (Map) it$iv4;
                        ComposerKt.sourceInformationMarkerStart($composer4, -1238937213, "CC(remember):SkuSwitchSheetComponent.kt#9igjgp");
                        it$iv2 = $composer4.rememberedValue();
                        if (it$iv2 != Composer.Companion.getEmpty()) {
                            SnapshotStateMap mutableStateMapOf = SnapshotStateKt.mutableStateMapOf();
                            SnapshotStateMap $this$SkuSwitchSheetComponent_u24lambda_u247_u240 = mutableStateMapOf;
                            SkuInfoFloor.ItemsSkuListVO.ItemsSkuListItem itemsSkuListItem = (SkuInfoFloor.ItemsSkuListVO.ItemsSkuListItem) currentSelectedSku.getValue();
                            if (itemsSkuListItem != null && (specValues = itemsSkuListItem.getSpecValues()) != null) {
                                Iterable $this$forEach$iv = specValues;
                                for (Object element$iv : $this$forEach$iv) {
                                    State currentSelectedSku2 = currentSelectedSku;
                                    String specValueName = (String) element$iv;
                                    String str = (String) specValueToSpecName.get(specValueName);
                                    if (str == null) {
                                        str = "规格";
                                    }
                                    String specName = str;
                                    Map specValueToSpecName2 = specValueToSpecName;
                                    SnapshotStateMap $this$SkuSwitchSheetComponent_u24lambda_u247_u2402 = $this$SkuSwitchSheetComponent_u24lambda_u247_u240;
                                    $this$SkuSwitchSheetComponent_u24lambda_u247_u2402.put(specName, specValueName);
                                    it$iv2 = it$iv2;
                                    currentSelectedSku = currentSelectedSku2;
                                    $this$SkuSwitchSheetComponent_u24lambda_u247_u240 = $this$SkuSwitchSheetComponent_u24lambda_u247_u2402;
                                    specValueToSpecName = specValueToSpecName2;
                                }
                                Unit unit = Unit.INSTANCE;
                            }
                            $composer4.updateRememberedValue(mutableStateMapOf);
                            it$iv2 = mutableStateMapOf;
                        }
                        SnapshotStateMap selectedSpecValues = (SnapshotStateMap) it$iv2;
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        Modifier modifier$iv = SizeKt.fillMaxSize$default(modifier4, 0.0f, 1, (Object) null);
                        ComposerKt.sourceInformationMarkerStart($composer4, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                        Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                        Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
                        MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                        int $changed$iv$iv = (0 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
                        CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer4, modifier$iv);
                        Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
                        Modifier modifier5 = modifier4;
                        int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                        $composer2 = $composer4;
                        ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                        if (!($composer4.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer4.startReusableNode();
                        if ($composer4.getInserting()) {
                            factory$iv$iv$iv = factory$iv$iv$iv6;
                            $composer4.useNode();
                        } else {
                            factory$iv$iv$iv = factory$iv$iv$iv6;
                            $composer4.createNode(factory$iv$iv$iv);
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer4);
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
                        int i5 = ($changed$iv$iv$iv >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer4, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                        int i6 = ((0 >> 6) & 112) | 6;
                        ColumnScope $this$SkuSwitchSheetComponent_u24lambda_u248 = ColumnScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart($composer4, -1654217996, "C87@3633L1007,121@4809L21,116@4649L1710,168@6581L6,170@6704L529,162@6369L1090:SkuSwitchSheetComponent.kt#o90vz8");
                        Modifier modifier$iv2 = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), ProvideUiScaleKt.dpScaled(48, scale));
                        Alignment contentAlignment$iv = Alignment.Companion.getTopCenter();
                        ComposerKt.sourceInformationMarkerStart($composer4, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                        int $changed$iv$iv2 = (48 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
                        CompositionLocalMap localMap$iv$iv2 = $composer4.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer4, modifier$iv2);
                        Function0 factory$iv$iv$iv7 = ComposeUiNode.Companion.getConstructor();
                        int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                        SnapshotStateMap selectedSpecValues2 = selectedSpecValues;
                        ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                        if (!($composer4.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer4.startReusableNode();
                        if ($composer4.getInserting()) {
                            factory$iv$iv$iv2 = factory$iv$iv$iv7;
                            $composer4.useNode();
                        } else {
                            factory$iv$iv$iv2 = factory$iv$iv$iv7;
                            $composer4.createNode(factory$iv$iv$iv2);
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer4);
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
                        int i7 = ($changed$iv$iv$iv2 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer4, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                        int i8 = ((48 >> 6) & 112) | 6;
                        BoxScope $this$SkuSwitchSheetComponent_u24lambda_u248_u240 = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart($composer4, -62686799, "C97@3964L6,98@4012L9,94@3847L208,100@4068L562:SkuSwitchSheetComponent.kt#o90vz8");
                        int i9 = TextAlign.Companion.getCenter-e0LSkKk();
                        BiliTheme biliTheme = BiliTheme.INSTANCE;
                        int $changed$iv = BiliTheme.$stable;
                        TextKt.Text-Nvy7gAk("切换规格", (Modifier) null, biliTheme.getColors($composer4, $changed$iv).getText1-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(i9), 0L, 0, false, 0, 0, (Function1) null, ProvideUiScaleKt.scaled(BiliTheme.INSTANCE.getTextStyle($composer4, BiliTheme.$stable).getT16b(), scale), $composer4, 6, 0, 130042);
                        Modifier modifier$iv3 = $this$SkuSwitchSheetComponent_u24lambda_u248_u240.align(Modifier.Companion, Alignment.Companion.getTopEnd());
                        ComposerKt.sourceInformationMarkerStart($composer4, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                        Alignment contentAlignment$iv2 = Alignment.Companion.getTopStart();
                        MeasurePolicy measurePolicy$iv3 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
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
                            $composer4.useNode();
                        } else {
                            factory$iv$iv$iv3 = factory$iv$iv$iv8;
                            $composer4.createNode(factory$iv$iv$iv3);
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer4);
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
                        int i10 = ($changed$iv$iv$iv3 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer4, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                        BoxScope boxScope = BoxScopeInstance.INSTANCE;
                        int i11 = ((0 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer4, -1617353960, "C104@4215L20,105@4274L6,109@4445L105,103@4166L450:SkuSwitchSheetComponent.kt#o90vz8");
                        Painter xmark_close_line_500 = BiliIconfont.INSTANCE.getXmark_close_line_500($composer4, 6);
                        long j = BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getText3-0d7_KjU();
                        Modifier modifier6 = SizeKt.size-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(24, scale));
                        ComposerKt.sourceInformationMarkerStart($composer4, -606353454, "CC(remember):SkuSwitchSheetComponent.kt#9igjgp");
                        invalid$iv = $composer4.changedInstance(pageViewModel);
                        Object it$iv5 = $composer4.rememberedValue();
                        if (invalid$iv) {
                        }
                        Object value$iv = new Function0() { // from class: kntr.app.mall.product.details.page.ui.components.SkuSwitchSheetComponentKt$$ExternalSyntheticLambda9
                            public final Object invoke() {
                                Unit SkuSwitchSheetComponent$lambda$8$0$0$0$0;
                                SkuSwitchSheetComponent$lambda$8$0$0$0$0 = SkuSwitchSheetComponentKt.SkuSwitchSheetComponent$lambda$8$0$0$0$0(PageViewModel.this);
                                return SkuSwitchSheetComponent$lambda$8$0$0$0$0;
                            }
                        };
                        $composer4.updateRememberedValue(value$iv);
                        it$iv5 = value$iv;
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        IconKt.Icon-ww6aTOc(xmark_close_line_500, (String) null, ClickableKt.clickable-oSLSa3U$default(modifier6, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv5, 15, (Object) null), j, $composer4, Painter.$stable | 48, 0);
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
                        Modifier modifier$iv4 = ScrollKt.verticalScroll$default(ColumnScope.-CC.weight$default($this$SkuSwitchSheetComponent_u24lambda_u248, SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 1.0f, false, 2, (Object) null), ScrollKt.rememberScrollState(0, $composer4, 0, 1), false, (FlingBehavior) null, false, 14, (Object) null);
                        ComposerKt.sourceInformationMarkerStart($composer4, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                        Arrangement.Vertical verticalArrangement$iv2 = Arrangement.INSTANCE.getTop();
                        Alignment.Horizontal horizontalAlignment$iv2 = Alignment.Companion.getStart();
                        MeasurePolicy measurePolicy$iv4 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv2, horizontalAlignment$iv2, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                        int $changed$iv$iv4 = (0 << 3) & 112;
                        MeasurePolicy measurePolicy$iv$iv = measurePolicy$iv4;
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
                            $composer4.useNode();
                        } else {
                            factory$iv$iv$iv4 = factory$iv$iv$iv9;
                            $composer4.createNode(factory$iv$iv$iv4);
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv4 = Updater.constructor-impl($composer4);
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, measurePolicy$iv$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, localMap$iv$iv4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Updater.init-impl($this$Layout_u24lambda_u240$iv$iv4, Integer.valueOf(compositeKeyHash$iv$iv4), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv4, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, materialized$iv$iv4, ComposeUiNode.Companion.getSetModifier());
                        int i12 = ($changed$iv$iv$iv4 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer4, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                        ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
                        int i13 = ((0 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer4, -742208716, "C159@6295L54:SkuSwitchSheetComponent.kt#o90vz8");
                        $composer4.startReplaceGroup(-301036546);
                        ComposerKt.sourceInformation($composer4, "*128@5072L6,129@5124L9,126@4991L179,140@5579L616,133@5213L982,156@6213L54");
                        Iterable $this$forEach$iv2 = specInfoList;
                        boolean z2 = false;
                        for (Object element$iv2 : $this$forEach$iv2) {
                            Iterable $this$forEach$iv3 = $this$forEach$iv2;
                            final SkuInfoFloor.ItemsSkuListVO.SpecInfoListItem specInfo = (SkuInfoFloor.ItemsSkuListVO.SpecInfoListItem) element$iv2;
                            String specName2 = specInfo.getSpecName();
                            if (specName2 == null) {
                                specName2 = "";
                            }
                            final String specName3 = specName2;
                            Modifier materialized$iv$iv5 = materialized$iv$iv4;
                            TextKt.Text-Nvy7gAk(specName3, (Modifier) null, BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, ProvideUiScaleKt.scaled(BiliTheme.INSTANCE.getTextStyle($composer4, BiliTheme.$stable).getT14(), scale), $composer4, 0, 0, 131066);
                            final SnapshotStateMap selectedSpecValues3 = selectedSpecValues2;
                            FlowLayoutKt.FlowRow(PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, ProvideUiScaleKt.dpScaled(8, scale), 0.0f, 0.0f, 13, (Object) null), Arrangement.INSTANCE.spacedBy-0680j_4(ProvideUiScaleKt.dpScaled(8, scale)), Arrangement.INSTANCE.spacedBy-0680j_4(ProvideUiScaleKt.dpScaled(8, scale)), (Alignment.Vertical) null, 0, 0, ComposableLambdaKt.rememberComposableLambda(-1693735193, true, new Function3() { // from class: kntr.app.mall.product.details.page.ui.components.SkuSwitchSheetComponentKt$$ExternalSyntheticLambda0
                                public final Object invoke(Object obj2, Object obj3, Object obj4) {
                                    Unit SkuSwitchSheetComponent$lambda$8$1$0$0;
                                    SkuSwitchSheetComponent$lambda$8$1$0$0 = SkuSwitchSheetComponentKt.SkuSwitchSheetComponent$lambda$8$1$0$0(SkuInfoFloor.ItemsSkuListVO.SpecInfoListItem.this, selectedSpecValues3, specName3, scale, (FlowRowScope) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                                    return SkuSwitchSheetComponent$lambda$8$1$0$0;
                                }
                            }, $composer4, 54), $composer4, 1572864, 56);
                            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(12, scale)), $composer4, 0);
                            selectedSpecValues2 = selectedSpecValues3;
                            $this$forEach$iv2 = $this$forEach$iv3;
                            z2 = z2;
                            materialized$iv$iv4 = materialized$iv$iv5;
                            $changed$iv$iv$iv4 = $changed$iv$iv$iv4;
                            measurePolicy$iv$iv = measurePolicy$iv$iv;
                        }
                        final SnapshotStateMap selectedSpecValues4 = selectedSpecValues2;
                        $composer4.endReplaceGroup();
                        SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(16, scale)), $composer4, 0);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        $composer4.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        Modifier modifier7 = BackgroundKt.background-bw27NRU(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), ProvideUiScaleKt.dpScaled(44, scale)), BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getBrand_pink-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(ProvideUiScaleKt.dpScaled(22, scale)));
                        ComposerKt.sourceInformationMarkerStart($composer4, 2024943086, "CC(remember):SkuSwitchSheetComponent.kt#9igjgp");
                        invalid$iv2 = $composer4.changedInstance(itemsSkuList) | $composer4.changedInstance(pageViewModel);
                        it$iv3 = $composer4.rememberedValue();
                        if (!invalid$iv2 || it$iv3 == Composer.Companion.getEmpty()) {
                            Object value$iv2 = new Function0() { // from class: kntr.app.mall.product.details.page.ui.components.SkuSwitchSheetComponentKt$$ExternalSyntheticLambda4
                                public final Object invoke() {
                                    Unit SkuSwitchSheetComponent$lambda$8$2$0;
                                    SkuSwitchSheetComponent$lambda$8$2$0 = SkuSwitchSheetComponentKt.SkuSwitchSheetComponent$lambda$8$2$0(itemsSkuList, pageViewModel, selectedSpecValues4);
                                    return SkuSwitchSheetComponent$lambda$8$2$0;
                                }
                            };
                            $composer4.updateRememberedValue(value$iv2);
                            it$iv3 = value$iv2;
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        Modifier modifier$iv5 = ClickableKt.clickable-oSLSa3U$default(modifier7, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv3, 15, (Object) null);
                        Alignment contentAlignment$iv3 = Alignment.Companion.getCenter();
                        ComposerKt.sourceInformationMarkerStart($composer4, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicy$iv5 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv3, false);
                        int $changed$iv$iv5 = (48 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv5 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
                        CompositionLocalMap localMap$iv$iv5 = $composer4.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv6 = ComposedModifierKt.materializeModifier($composer4, modifier$iv5);
                        Function0 factory$iv$iv$iv10 = ComposeUiNode.Companion.getConstructor();
                        int $changed$iv$iv$iv5 = (($changed$iv$iv5 << 6) & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                        if (!($composer4.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer4.startReusableNode();
                        if ($composer4.getInserting()) {
                            factory$iv$iv$iv5 = factory$iv$iv$iv10;
                            $composer4.useNode();
                        } else {
                            factory$iv$iv$iv5 = factory$iv$iv$iv10;
                            $composer4.createNode(factory$iv$iv$iv5);
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv5 = Updater.constructor-impl($composer4);
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, measurePolicy$iv5, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, localMap$iv$iv5, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Updater.init-impl($this$Layout_u24lambda_u240$iv$iv5, Integer.valueOf(compositeKeyHash$iv$iv5), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv5, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, materialized$iv$iv6, ComposeUiNode.Companion.getSetModifier());
                        int i14 = ($changed$iv$iv$iv5 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer4, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                        BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
                        int i15 = ((48 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer4, -604926564, "C185@7407L9,182@7308L141:SkuSwitchSheetComponent.kt#o90vz8");
                        TextKt.Text-Nvy7gAk("确认", (Modifier) null, Color.Companion.getWhite-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, ProvideUiScaleKt.scaled(BiliTheme.INSTANCE.getTextStyle($composer4, BiliTheme.$stable).getT16(), scale), $composer4, 390, 0, 131066);
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
                        pageViewModelWrapper2 = pageViewModelWrapper;
                        i2 = $changed;
                        i3 = i;
                        modifier2 = modifier5;
                    }
                    boolean invalid$iv4 = false;
                    Map createMapBuilder = MapsKt.createMapBuilder();
                    Map $this$SkuSwitchSheetComponent_u24lambda_u246_u2402 = createMapBuilder;
                    Iterable $this$forEach$iv4 = specInfoList;
                    for (Object element$iv3 : $this$forEach$iv4) {
                        SkuInfoFloor.ItemsSkuListVO.SpecInfoListItem specInfo2 = (SkuInfoFloor.ItemsSkuListVO.SpecInfoListItem) element$iv3;
                        String specName4 = specInfo2.getSpecName();
                        if (specName4 == null) {
                            specName4 = "规格";
                        }
                        String specName5 = specName4;
                        Iterable specValueVOList = specInfo2.getSpecValueVOList();
                        if (specValueVOList != null) {
                            Iterable $this$forEach$iv5 = specValueVOList;
                            for (Object element$iv4 : $this$forEach$iv5) {
                                SkuInfoFloor.ItemsSkuListVO.SpecInfoListItem.SpecValueListItem specValue = (SkuInfoFloor.ItemsSkuListVO.SpecInfoListItem.SpecValueListItem) element$iv4;
                                String specValueName2 = specValue.getSpecValueName();
                                if (specValueName2 == null) {
                                    specValueName2 = "";
                                }
                                String valueName = specValueName2;
                                boolean z3 = invalid$iv4;
                                Map $this$SkuSwitchSheetComponent_u24lambda_u246_u2403 = $this$SkuSwitchSheetComponent_u24lambda_u246_u2402;
                                SkuInfoFloor skuInfoFloor3 = skuInfoFloor2;
                                String specName6 = specName5;
                                $this$SkuSwitchSheetComponent_u24lambda_u246_u2403.put(valueName, specName6);
                                it$iv4 = it$iv4;
                                specName5 = specName6;
                                skuInfoFloor2 = skuInfoFloor3;
                                $this$SkuSwitchSheetComponent_u24lambda_u246_u2402 = $this$SkuSwitchSheetComponent_u24lambda_u246_u2403;
                                invalid$iv4 = z3;
                            }
                            z = invalid$iv4;
                            $this$SkuSwitchSheetComponent_u24lambda_u246_u240 = $this$SkuSwitchSheetComponent_u24lambda_u246_u2402;
                            skuInfoFloor = skuInfoFloor2;
                            it$iv = it$iv4;
                            Object it$iv6 = Unit.INSTANCE;
                        } else {
                            z = invalid$iv4;
                            $this$SkuSwitchSheetComponent_u24lambda_u246_u240 = $this$SkuSwitchSheetComponent_u24lambda_u246_u2402;
                            skuInfoFloor = skuInfoFloor2;
                            it$iv = it$iv4;
                        }
                        skuInfoFloor2 = skuInfoFloor;
                        it$iv4 = it$iv;
                        $this$SkuSwitchSheetComponent_u24lambda_u246_u2402 = $this$SkuSwitchSheetComponent_u24lambda_u246_u240;
                        invalid$iv4 = z;
                    }
                    Object value$iv3 = MapsKt.build(createMapBuilder);
                    $composer4.updateRememberedValue(value$iv3);
                    it$iv4 = value$iv3;
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    Map specValueToSpecName3 = (Map) it$iv4;
                    ComposerKt.sourceInformationMarkerStart($composer4, -1238937213, "CC(remember):SkuSwitchSheetComponent.kt#9igjgp");
                    it$iv2 = $composer4.rememberedValue();
                    if (it$iv2 != Composer.Companion.getEmpty()) {
                    }
                    SnapshotStateMap selectedSpecValues5 = (SnapshotStateMap) it$iv2;
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    Modifier modifier$iv6 = SizeKt.fillMaxSize$default(modifier4, 0.0f, 1, (Object) null);
                    ComposerKt.sourceInformationMarkerStart($composer4, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                    Arrangement.Vertical verticalArrangement$iv3 = Arrangement.INSTANCE.getTop();
                    Alignment.Horizontal horizontalAlignment$iv3 = Alignment.Companion.getStart();
                    MeasurePolicy measurePolicy$iv6 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv3, horizontalAlignment$iv3, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                    int $changed$iv$iv6 = (0 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int compositeKeyHash$iv$iv6 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
                    CompositionLocalMap localMap$iv$iv6 = $composer4.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv7 = ComposedModifierKt.materializeModifier($composer4, modifier$iv6);
                    Function0 factory$iv$iv$iv62 = ComposeUiNode.Companion.getConstructor();
                    Modifier modifier52 = modifier4;
                    int $changed$iv$iv$iv6 = (($changed$iv$iv6 << 6) & 896) | 6;
                    $composer2 = $composer4;
                    ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!($composer4.getApplier() instanceof Applier)) {
                    }
                    $composer4.startReusableNode();
                    if ($composer4.getInserting()) {
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv6 = Updater.constructor-impl($composer4);
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv6, measurePolicy$iv6, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv6, localMap$iv$iv6, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv6, Integer.valueOf(compositeKeyHash$iv$iv6), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv6, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv6, materialized$iv$iv7, ComposeUiNode.Companion.getSetModifier());
                    int i52 = ($changed$iv$iv$iv6 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer4, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                    int i62 = ((0 >> 6) & 112) | 6;
                    ColumnScope $this$SkuSwitchSheetComponent_u24lambda_u2482 = ColumnScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart($composer4, -1654217996, "C87@3633L1007,121@4809L21,116@4649L1710,168@6581L6,170@6704L529,162@6369L1090:SkuSwitchSheetComponent.kt#o90vz8");
                    Modifier modifier$iv22 = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), ProvideUiScaleKt.dpScaled(48, scale));
                    Alignment contentAlignment$iv4 = Alignment.Companion.getTopCenter();
                    ComposerKt.sourceInformationMarkerStart($composer4, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicy$iv22 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv4, false);
                    int $changed$iv$iv22 = (48 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int compositeKeyHash$iv$iv22 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
                    CompositionLocalMap localMap$iv$iv22 = $composer4.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv22 = ComposedModifierKt.materializeModifier($composer4, modifier$iv22);
                    Function0 factory$iv$iv$iv72 = ComposeUiNode.Companion.getConstructor();
                    int $changed$iv$iv$iv22 = (($changed$iv$iv22 << 6) & 896) | 6;
                    SnapshotStateMap selectedSpecValues22 = selectedSpecValues5;
                    ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!($composer4.getApplier() instanceof Applier)) {
                    }
                    $composer4.startReusableNode();
                    if ($composer4.getInserting()) {
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv22 = Updater.constructor-impl($composer4);
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv22, measurePolicy$iv22, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv22, localMap$iv$iv22, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv22, Integer.valueOf(compositeKeyHash$iv$iv22), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv22, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv22, materialized$iv$iv22, ComposeUiNode.Companion.getSetModifier());
                    int i72 = ($changed$iv$iv$iv22 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer4, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    int i82 = ((48 >> 6) & 112) | 6;
                    BoxScope $this$SkuSwitchSheetComponent_u24lambda_u248_u2402 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart($composer4, -62686799, "C97@3964L6,98@4012L9,94@3847L208,100@4068L562:SkuSwitchSheetComponent.kt#o90vz8");
                    int i92 = TextAlign.Companion.getCenter-e0LSkKk();
                    BiliTheme biliTheme2 = BiliTheme.INSTANCE;
                    int $changed$iv2 = BiliTheme.$stable;
                    TextKt.Text-Nvy7gAk("切换规格", (Modifier) null, biliTheme2.getColors($composer4, $changed$iv2).getText1-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(i92), 0L, 0, false, 0, 0, (Function1) null, ProvideUiScaleKt.scaled(BiliTheme.INSTANCE.getTextStyle($composer4, BiliTheme.$stable).getT16b(), scale), $composer4, 6, 0, 130042);
                    Modifier modifier$iv32 = $this$SkuSwitchSheetComponent_u24lambda_u248_u2402.align(Modifier.Companion, Alignment.Companion.getTopEnd());
                    ComposerKt.sourceInformationMarkerStart($composer4, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    Alignment contentAlignment$iv22 = Alignment.Companion.getTopStart();
                    MeasurePolicy measurePolicy$iv32 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv22, false);
                    int $changed$iv$iv32 = (0 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int compositeKeyHash$iv$iv32 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
                    CompositionLocalMap localMap$iv$iv32 = $composer4.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv32 = ComposedModifierKt.materializeModifier($composer4, modifier$iv32);
                    Function0 factory$iv$iv$iv82 = ComposeUiNode.Companion.getConstructor();
                    int $changed$iv$iv$iv32 = (($changed$iv$iv32 << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!($composer4.getApplier() instanceof Applier)) {
                    }
                    $composer4.startReusableNode();
                    if ($composer4.getInserting()) {
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv32 = Updater.constructor-impl($composer4);
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv32, measurePolicy$iv32, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv32, localMap$iv$iv32, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv32, Integer.valueOf(compositeKeyHash$iv$iv32), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv32, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv32, materialized$iv$iv32, ComposeUiNode.Companion.getSetModifier());
                    int i102 = ($changed$iv$iv$iv32 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer4, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScope boxScope3 = BoxScopeInstance.INSTANCE;
                    int i112 = ((0 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer4, -1617353960, "C104@4215L20,105@4274L6,109@4445L105,103@4166L450:SkuSwitchSheetComponent.kt#o90vz8");
                    Painter xmark_close_line_5002 = BiliIconfont.INSTANCE.getXmark_close_line_500($composer4, 6);
                    long j2 = BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getText3-0d7_KjU();
                    Modifier modifier62 = SizeKt.size-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(24, scale));
                    ComposerKt.sourceInformationMarkerStart($composer4, -606353454, "CC(remember):SkuSwitchSheetComponent.kt#9igjgp");
                    invalid$iv = $composer4.changedInstance(pageViewModel);
                    Object it$iv52 = $composer4.rememberedValue();
                    if (invalid$iv) {
                    }
                    Object value$iv4 = new Function0() { // from class: kntr.app.mall.product.details.page.ui.components.SkuSwitchSheetComponentKt$$ExternalSyntheticLambda9
                        public final Object invoke() {
                            Unit SkuSwitchSheetComponent$lambda$8$0$0$0$0;
                            SkuSwitchSheetComponent$lambda$8$0$0$0$0 = SkuSwitchSheetComponentKt.SkuSwitchSheetComponent$lambda$8$0$0$0$0(PageViewModel.this);
                            return SkuSwitchSheetComponent$lambda$8$0$0$0$0;
                        }
                    };
                    $composer4.updateRememberedValue(value$iv4);
                    it$iv52 = value$iv4;
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    IconKt.Icon-ww6aTOc(xmark_close_line_5002, (String) null, ClickableKt.clickable-oSLSa3U$default(modifier62, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv52, 15, (Object) null), j2, $composer4, Painter.$stable | 48, 0);
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
                    Modifier modifier$iv42 = ScrollKt.verticalScroll$default(ColumnScope.-CC.weight$default($this$SkuSwitchSheetComponent_u24lambda_u2482, SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 1.0f, false, 2, (Object) null), ScrollKt.rememberScrollState(0, $composer4, 0, 1), false, (FlingBehavior) null, false, 14, (Object) null);
                    ComposerKt.sourceInformationMarkerStart($composer4, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                    Arrangement.Vertical verticalArrangement$iv22 = Arrangement.INSTANCE.getTop();
                    Alignment.Horizontal horizontalAlignment$iv22 = Alignment.Companion.getStart();
                    MeasurePolicy measurePolicy$iv42 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv22, horizontalAlignment$iv22, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                    int $changed$iv$iv42 = (0 << 3) & 112;
                    MeasurePolicy measurePolicy$iv$iv2 = measurePolicy$iv42;
                    ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int compositeKeyHash$iv$iv42 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
                    CompositionLocalMap localMap$iv$iv42 = $composer4.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv42 = ComposedModifierKt.materializeModifier($composer4, modifier$iv42);
                    Function0 factory$iv$iv$iv92 = ComposeUiNode.Companion.getConstructor();
                    int $changed$iv$iv$iv42 = (($changed$iv$iv42 << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!($composer4.getApplier() instanceof Applier)) {
                    }
                    $composer4.startReusableNode();
                    if ($composer4.getInserting()) {
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv42 = Updater.constructor-impl($composer4);
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv42, measurePolicy$iv$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv42, localMap$iv$iv42, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv42, Integer.valueOf(compositeKeyHash$iv$iv42), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv42, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv42, materialized$iv$iv42, ComposeUiNode.Companion.getSetModifier());
                    int i122 = ($changed$iv$iv$iv42 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer4, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                    ColumnScope columnScope2 = ColumnScopeInstance.INSTANCE;
                    int i132 = ((0 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer4, -742208716, "C159@6295L54:SkuSwitchSheetComponent.kt#o90vz8");
                    $composer4.startReplaceGroup(-301036546);
                    ComposerKt.sourceInformation($composer4, "*128@5072L6,129@5124L9,126@4991L179,140@5579L616,133@5213L982,156@6213L54");
                    Iterable $this$forEach$iv22 = specInfoList;
                    boolean z22 = false;
                    while (r86.hasNext()) {
                    }
                    final SnapshotStateMap selectedSpecValues42 = selectedSpecValues22;
                    $composer4.endReplaceGroup();
                    SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(16, scale)), $composer4, 0);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    $composer4.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    Modifier modifier72 = BackgroundKt.background-bw27NRU(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), ProvideUiScaleKt.dpScaled(44, scale)), BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getBrand_pink-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(ProvideUiScaleKt.dpScaled(22, scale)));
                    ComposerKt.sourceInformationMarkerStart($composer4, 2024943086, "CC(remember):SkuSwitchSheetComponent.kt#9igjgp");
                    invalid$iv2 = $composer4.changedInstance(itemsSkuList) | $composer4.changedInstance(pageViewModel);
                    it$iv3 = $composer4.rememberedValue();
                    if (!invalid$iv2) {
                    }
                    Object value$iv22 = new Function0() { // from class: kntr.app.mall.product.details.page.ui.components.SkuSwitchSheetComponentKt$$ExternalSyntheticLambda4
                        public final Object invoke() {
                            Unit SkuSwitchSheetComponent$lambda$8$2$0;
                            SkuSwitchSheetComponent$lambda$8$2$0 = SkuSwitchSheetComponentKt.SkuSwitchSheetComponent$lambda$8$2$0(itemsSkuList, pageViewModel, selectedSpecValues42);
                            return SkuSwitchSheetComponent$lambda$8$2$0;
                        }
                    };
                    $composer4.updateRememberedValue(value$iv22);
                    it$iv3 = value$iv22;
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    Modifier modifier$iv52 = ClickableKt.clickable-oSLSa3U$default(modifier72, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv3, 15, (Object) null);
                    Alignment contentAlignment$iv32 = Alignment.Companion.getCenter();
                    ComposerKt.sourceInformationMarkerStart($composer4, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicy$iv52 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv32, false);
                    int $changed$iv$iv52 = (48 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int compositeKeyHash$iv$iv52 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
                    CompositionLocalMap localMap$iv$iv52 = $composer4.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv62 = ComposedModifierKt.materializeModifier($composer4, modifier$iv52);
                    Function0 factory$iv$iv$iv102 = ComposeUiNode.Companion.getConstructor();
                    int $changed$iv$iv$iv52 = (($changed$iv$iv52 << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!($composer4.getApplier() instanceof Applier)) {
                    }
                    $composer4.startReusableNode();
                    if ($composer4.getInserting()) {
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv52 = Updater.constructor-impl($composer4);
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv52, measurePolicy$iv52, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv52, localMap$iv$iv52, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv52, Integer.valueOf(compositeKeyHash$iv$iv52), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv52, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv52, materialized$iv$iv62, ComposeUiNode.Companion.getSetModifier());
                    int i142 = ($changed$iv$iv$iv52 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer4, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScope boxScope22 = BoxScopeInstance.INSTANCE;
                    int i152 = ((48 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer4, -604926564, "C185@7407L9,182@7308L141:SkuSwitchSheetComponent.kt#o90vz8");
                    TextKt.Text-Nvy7gAk("确认", (Modifier) null, Color.Companion.getWhite-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, ProvideUiScaleKt.scaled(BiliTheme.INSTANCE.getTextStyle($composer4, BiliTheme.$stable).getT16(), scale), $composer4, 390, 0, 131066);
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
                    }
                    pageViewModelWrapper2 = pageViewModelWrapper;
                    i2 = $changed;
                    i3 = i;
                    modifier2 = modifier52;
                }
            } else {
                $composer3 = $composer4;
                modifier3 = modifier4;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            ScopeUpdateScope endRestartGroup4 = $composer3.endRestartGroup();
            if (endRestartGroup4 != null) {
                final Modifier modifier8 = modifier3;
                endRestartGroup4.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.SkuSwitchSheetComponentKt$$ExternalSyntheticLambda3
                    public final Object invoke(Object obj2, Object obj3) {
                        Unit SkuSwitchSheetComponent$lambda$2;
                        SkuSwitchSheetComponent$lambda$2 = SkuSwitchSheetComponentKt.SkuSwitchSheetComponent$lambda$2(PageViewModelWrapper.this, modifier8, $changed, i, (Composer) obj2, ((Integer) obj3).intValue());
                        return SkuSwitchSheetComponent$lambda$2;
                    }
                });
                return;
            }
            return;
        }
        i2 = $changed;
        $composer2 = $composer4;
        i3 = i;
        pageViewModelWrapper2 = pageViewModelWrapper;
        $composer2.skipToGroupEnd();
        ScopeUpdateScope endRestartGroup5 = $composer2.endRestartGroup();
        if (endRestartGroup5 != null) {
            endRestartGroup5.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.SkuSwitchSheetComponentKt$$ExternalSyntheticLambda5
                public final Object invoke(Object obj2, Object obj3) {
                    Unit SkuSwitchSheetComponent$lambda$9;
                    SkuSwitchSheetComponent$lambda$9 = SkuSwitchSheetComponentKt.SkuSwitchSheetComponent$lambda$9(PageViewModelWrapper.this, modifier2, i2, i3, (Composer) obj2, ((Integer) obj3).intValue());
                    return SkuSwitchSheetComponent$lambda$9;
                }
            });
        }
    }

    private static final UiScaleModel SkuSwitchSheetComponent$lambda$0(State<UiScaleModel> state) {
        Object thisObj$iv = state.getValue();
        return (UiScaleModel) thisObj$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SkuSwitchSheetComponent$lambda$8$0$0$0$0(PageViewModel $pageViewModel) {
        $pageViewModel.updateSkuSwitchState$product_details_page_debug(false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SkuSwitchSheetComponent$lambda$8$1$0$0(SkuInfoFloor.ItemsSkuListVO.SpecInfoListItem $specInfo, final SnapshotStateMap $selectedSpecValues, final String $specName, float $scale, FlowRowScope $this$FlowRow, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$FlowRow, "$this$FlowRow");
        ComposerKt.sourceInformation($composer, "C:SkuSwitchSheetComponent.kt#o90vz8");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1693735193, $changed, -1, "kntr.app.mall.product.details.page.ui.components.SkuSwitchSheetComponent.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SkuSwitchSheetComponent.kt:141)");
            }
            Iterable specValueVOList = $specInfo.getSpecValueVOList();
            if (specValueVOList == null) {
                $composer.startReplaceGroup(-789276588);
            } else {
                $composer.startReplaceGroup(-789276587);
                ComposerKt.sourceInformation($composer, "*148@5957L128,145@5800L355");
                Iterable $this$forEach$iv = specValueVOList;
                for (Object element$iv : $this$forEach$iv) {
                    final SkuInfoFloor.ItemsSkuListVO.SpecInfoListItem.SpecValueListItem specValue = (SkuInfoFloor.ItemsSkuListVO.SpecInfoListItem.SpecValueListItem) element$iv;
                    boolean isSelected = Intrinsics.areEqual($selectedSpecValues.get($specName), specValue.getSpecValueName());
                    ComposerKt.sourceInformationMarkerStart($composer, 705324918, "CC(remember):SkuSwitchSheetComponent.kt#9igjgp");
                    boolean invalid$iv = $composer.changed($specName) | $composer.changed(specValue);
                    Object it$iv = $composer.rememberedValue();
                    if (!invalid$iv && it$iv != Composer.Companion.getEmpty()) {
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        SpecValueItem(specValue, isSelected, $scale, (Function0) it$iv, $composer, 0);
                    }
                    Object value$iv = new Function0() { // from class: kntr.app.mall.product.details.page.ui.components.SkuSwitchSheetComponentKt$$ExternalSyntheticLambda1
                        public final Object invoke() {
                            Unit SkuSwitchSheetComponent$lambda$8$1$0$0$0$0$0;
                            SkuSwitchSheetComponent$lambda$8$1$0$0$0$0$0 = SkuSwitchSheetComponentKt.SkuSwitchSheetComponent$lambda$8$1$0$0$0$0$0($selectedSpecValues, $specName, specValue);
                            return SkuSwitchSheetComponent$lambda$8$1$0$0$0$0$0;
                        }
                    };
                    $composer.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    SpecValueItem(specValue, isSelected, $scale, (Function0) it$iv, $composer, 0);
                }
            }
            $composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SkuSwitchSheetComponent$lambda$8$1$0$0$0$0$0(SnapshotStateMap $selectedSpecValues, String $specName, SkuInfoFloor.ItemsSkuListVO.SpecInfoListItem.SpecValueListItem $specValue) {
        Map map = (Map) $selectedSpecValues;
        String specValueName = $specValue.getSpecValueName();
        if (specValueName == null) {
            specValueName = "";
        }
        map.put($specName, specValueName);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SkuSwitchSheetComponent$lambda$8$2$0(List $itemsSkuList, PageViewModel $pageViewModel, SnapshotStateMap $selectedSpecValues) {
        Object obj;
        Set skuSpecValues;
        Iterator it = $itemsSkuList.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            SkuInfoFloor.ItemsSkuListVO.ItemsSkuListItem sku = (SkuInfoFloor.ItemsSkuListVO.ItemsSkuListItem) obj;
            List<String> specValues = sku.getSpecValues();
            if (specValues == null || (skuSpecValues = CollectionsKt.toSet(specValues)) == null) {
                skuSpecValues = SetsKt.emptySet();
            }
            Set selectedValues = CollectionsKt.toSet($selectedSpecValues.values());
            if (Intrinsics.areEqual(skuSpecValues, selectedValues)) {
                break;
            }
        }
        SkuInfoFloor.ItemsSkuListVO.ItemsSkuListItem selectedSku = (SkuInfoFloor.ItemsSkuListVO.ItemsSkuListItem) obj;
        $pageViewModel.handleNewFileInfoSku$product_details_page_debug(selectedSku);
        $pageViewModel.updateSkuSwitchState$product_details_page_debug(false);
        return Unit.INSTANCE;
    }

    private static final void SpecValueItem(final SkuInfoFloor.ItemsSkuListVO.SpecInfoListItem.SpecValueListItem specValue, final boolean isSelected, final float scale, final Function0<Unit> function0, Composer $composer, final int $changed) {
        int $dirty;
        long backgroundColor;
        long j;
        long contentColor;
        Function0 factory$iv$iv$iv;
        Composer $composer2 = $composer.startRestartGroup(1317862363);
        ComposerKt.sourceInformation($composer2, "C(SpecValueItem)N(specValue,isSelected,scale,onClick)216@8089L687:SkuSwitchSheetComponent.kt#o90vz8");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer2.changed(specValue) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty2 |= $composer2.changed(isSelected) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty2 |= $composer2.changed(scale) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty2 |= $composer2.changedInstance(function0) ? 2048 : 1024;
        }
        int $dirty3 = $dirty2;
        if (!$composer2.shouldExecute(($dirty3 & 1171) != 1170, $dirty3 & 1)) {
            $dirty = $dirty3;
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1317862363, $dirty3, -1, "kntr.app.mall.product.details.page.ui.components.SpecValueItem (SkuSwitchSheetComponent.kt:197)");
            }
            if (isSelected) {
                $composer2.startReplaceGroup(-549613346);
                ComposerKt.sourceInformation($composer2, "200@7736L6");
                backgroundColor = BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getPi0-0d7_KjU();
                $composer2.endReplaceGroup();
            } else {
                $composer2.startReplaceGroup(-549612034);
                ComposerKt.sourceInformation($composer2, "201@7777L6");
                backgroundColor = BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBg2-0d7_KjU();
                $composer2.endReplaceGroup();
            }
            if (isSelected) {
                $composer2.startReplaceGroup(-549608987);
                ComposerKt.sourceInformation($composer2, "206@7872L6");
                j = BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBrand_pink-0d7_KjU();
                $composer2.endReplaceGroup();
            } else {
                $composer2.startReplaceGroup(-549607802);
                $composer2.endReplaceGroup();
                j = Color.Companion.getTransparent-0d7_KjU();
            }
            long borderColor = j;
            if (isSelected) {
                $composer2.startReplaceGroup(-549604475);
                ComposerKt.sourceInformation($composer2, "212@8013L6");
                long j2 = BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBrand_pink-0d7_KjU();
                $composer2.endReplaceGroup();
                contentColor = j2;
            } else {
                $composer2.startReplaceGroup(-549602944);
                ComposerKt.sourceInformation($composer2, "213@8061L6");
                long j3 = BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText1-0d7_KjU();
                $composer2.endReplaceGroup();
                contentColor = j3;
            }
            Modifier modifier$iv$iv = PaddingKt.padding-VpY3zN4(ClickableKt.clickable-oSLSa3U$default(BackgroundKt.background-bw27NRU(BorderKt.border-xT4_qwU(Modifier.Companion, ProvideUiScaleKt.dpScaled(1, scale), borderColor, RoundedCornerShapeKt.RoundedCornerShape-0680j_4(ProvideUiScaleKt.dpScaled(4, scale))), backgroundColor, RoundedCornerShapeKt.RoundedCornerShape-0680j_4(ProvideUiScaleKt.dpScaled(4, scale))), false, (String) null, (Role) null, (MutableInteractionSource) null, function0, 15, (Object) null), ProvideUiScaleKt.dpScaled(12, scale), ProvideUiScaleKt.dpScaled(8, scale));
            ComposerKt.sourceInformationMarkerStart($composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            $dirty = $dirty3;
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv$iv);
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
            int i = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i2 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -1216551200, "C232@8732L9,229@8608L162:SkuSwitchSheetComponent.kt#o90vz8");
            String specValueName = specValue.getSpecValueName();
            if (specValueName == null) {
                specValueName = "";
            }
            TextKt.Text-Nvy7gAk(specValueName, (Modifier) null, contentColor, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, ProvideUiScaleKt.scaled(BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT14(), scale), $composer2, 0, 0, 131066);
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
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.SkuSwitchSheetComponentKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    Unit SpecValueItem$lambda$1;
                    SpecValueItem$lambda$1 = SkuSwitchSheetComponentKt.SpecValueItem$lambda$1(SkuInfoFloor.ItemsSkuListVO.SpecInfoListItem.SpecValueListItem.this, isSelected, scale, function0, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return SpecValueItem$lambda$1;
                }
            });
        }
    }
}