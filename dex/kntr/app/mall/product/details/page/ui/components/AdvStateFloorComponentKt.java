package kntr.app.mall.product.details.page.ui.components;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
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
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import com.bilibili.compose.theme.BiliTheme;
import java.util.List;
import kntr.app.mall.product.details.page.api.model.AdvStateFloor;
import kntr.app.mall.product.details.page.ui.scale.ProvideUiScaleKt;
import kntr.app.mall.product.details.page.ui.scale.UiScaleModel;
import kntr.app.mall.product.details.page.utils.HelperKt;
import kntr.app.mall.product.details.page.utils.TrackConsts;
import kntr.app.mall.product.details.page.vm.ContentModule;
import kntr.app.mall.product.details.page.vm.PageActionHandler;
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
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AdvStateFloorComponent.kt */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0001¢\u0006\u0002\u0010\b\u001a'\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0001¢\u0006\u0002\u0010\u000e¨\u0006\u000f²\u0006\n\u0010\u0010\u001a\u00020\u0011X\u008a\u0084\u0002"}, d2 = {"AdvStateFloorComponent", "", "module", "Lkntr/app/mall/product/details/page/vm/ContentModule;", "pageViewModelWrapper", "Lkntr/app/mall/product/details/page/vm/PageViewModelWrapper;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lkntr/app/mall/product/details/page/vm/ContentModule;Lkntr/app/mall/product/details/page/vm/PageViewModelWrapper;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "TimeNodeComponent", "state", "Lkntr/app/mall/product/details/page/api/model/AdvStateFloor$AdvState$StateInfo;", "scale", "", "(Lkntr/app/mall/product/details/page/api/model/AdvStateFloor$AdvState$StateInfo;FLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "product-details-page_debug", "scaleModel", "Lkntr/app/mall/product/details/page/ui/scale/UiScaleModel;"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class AdvStateFloorComponentKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AdvStateFloorComponent$lambda$0(ContentModule contentModule, PageViewModelWrapper pageViewModelWrapper, Modifier modifier, int i, int i2, Composer composer, int i3) {
        AdvStateFloorComponent(contentModule, pageViewModelWrapper, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AdvStateFloorComponent$lambda$1(ContentModule contentModule, PageViewModelWrapper pageViewModelWrapper, Modifier modifier, int i, int i2, Composer composer, int i3) {
        AdvStateFloorComponent(contentModule, pageViewModelWrapper, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AdvStateFloorComponent$lambda$5(ContentModule contentModule, PageViewModelWrapper pageViewModelWrapper, Modifier modifier, int i, int i2, Composer composer, int i3) {
        AdvStateFloorComponent(contentModule, pageViewModelWrapper, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TimeNodeComponent$lambda$1(AdvStateFloor.AdvState.StateInfo stateInfo, float f, Modifier modifier, int i, int i2, Composer composer, int i3) {
        TimeNodeComponent(stateInfo, f, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void AdvStateFloorComponent(final ContentModule module, final PageViewModelWrapper pageViewModelWrapper, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Composer $composer2;
        Modifier modifier3;
        Composer $composer3;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Function0 factory$iv$iv$iv3;
        int $changed$iv;
        int $changed$iv$iv$iv;
        boolean z;
        Intrinsics.checkNotNullParameter(module, "module");
        Intrinsics.checkNotNullParameter(pageViewModelWrapper, "pageViewModelWrapper");
        Composer $composer4 = $composer.startRestartGroup(-65811340);
        ComposerKt.sourceInformation($composer4, "C(AdvStateFloorComponent)N(module,pageViewModelWrapper,modifier)39@1673L16,41@1749L25,51@2091L220,46@1842L469,43@1780L1953:AdvStateFloorComponent.kt#o90vz8");
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
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-65811340, $dirty2, -1, "kntr.app.mall.product.details.page.ui.components.AdvStateFloorComponent (AdvStateFloorComponent.kt:32)");
            }
            if (module instanceof ContentModule.AdvStateModule) {
                AdvStateFloor floorData = ((ContentModule.AdvStateModule) module).getData();
                AdvStateFloor.AdvState advState = floorData.getAdvState();
                if (advState != null) {
                    List stateList = advState.getState();
                    if (stateList == null) {
                        $composer3 = $composer4;
                    } else {
                        final PageViewModel pageVM = pageViewModelWrapper.getViewModel();
                        State scaleModel$delegate = SnapshotStateKt.collectAsState(pageVM.getUiScaleModelFlow$product_details_page_debug(), (CoroutineContext) null, $composer4, 0, 1);
                        float scale = AdvStateFloorComponent$lambda$2(scaleModel$delegate).getScale();
                        CollectorHolder collectorHolder = ExposerKt.rememberCollectorHolder($composer4, 0);
                        String str = "adv_state_floor_" + floorData.hashCode();
                        ComposerKt.sourceInformationMarkerStart($composer4, 1179838448, "CC(remember):AdvStateFloorComponent.kt#9igjgp");
                        boolean invalid$iv = $composer4.changedInstance(pageVM);
                        Object it$iv = $composer4.rememberedValue();
                        if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                            Object value$iv = new Function0() { // from class: kntr.app.mall.product.details.page.ui.components.AdvStateFloorComponentKt$$ExternalSyntheticLambda2
                                public final Object invoke() {
                                    Unit AdvStateFloorComponent$lambda$3$0;
                                    AdvStateFloorComponent$lambda$3$0 = AdvStateFloorComponentKt.AdvStateFloorComponent$lambda$3$0(PageViewModel.this);
                                    return AdvStateFloorComponent$lambda$3$0;
                                }
                            };
                            $composer4.updateRememberedValue(value$iv);
                            it$iv = value$iv;
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        $composer2 = $composer4;
                        Modifier modifier$iv$iv = ExposerKt.reportOnExposure(modifier3, str, collectorHolder, null, false, 0.5f, 0, 500L, (Function0) it$iv, $composer2, (($dirty2 >> 6) & 14) | 12779520, 44);
                        Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
                        ComposerKt.sourceInformationMarkerStart($composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                        Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                        MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer2, ((384 >> 3) & 14) | ((384 >> 3) & 112));
                        int $changed$iv$iv = (384 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
                        CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv$iv);
                        Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
                        int $changed$iv$iv$iv2 = (($changed$iv$iv << 6) & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                        if (!($composer2.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer2.startReusableNode();
                        if ($composer2.getInserting()) {
                            factory$iv$iv$iv = factory$iv$iv$iv4;
                            $composer2.createNode(factory$iv$iv$iv);
                        } else {
                            factory$iv$iv$iv = factory$iv$iv$iv4;
                            $composer2.useNode();
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer2);
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
                        int i3 = ($changed$iv$iv$iv2 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                        int i4 = ((384 >> 6) & 112) | 6;
                        RowScope $this$AdvStateFloorComponent_u24lambda_u244 = RowScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart($composer2, 1439596653, "C59@2385L547,76@2942L785:AdvStateFloorComponent.kt#o90vz8");
                        Modifier modifier$iv = $this$AdvStateFloorComponent_u24lambda_u244.align(SizeKt.width-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(28, scale)), Alignment.Companion.getCenterVertically());
                        Alignment contentAlignment$iv = Alignment.Companion.getCenterStart();
                        ComposerKt.sourceInformationMarkerStart($composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                        int $changed$iv$iv2 = (48 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
                        CompositionLocalMap localMap$iv$iv2 = $composer2.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
                        Function0 factory$iv$iv$iv5 = ComposeUiNode.Companion.getConstructor();
                        int $changed$iv$iv$iv3 = (($changed$iv$iv2 << 6) & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                        if (!($composer2.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer2.startReusableNode();
                        if ($composer2.getInserting()) {
                            factory$iv$iv$iv2 = factory$iv$iv$iv5;
                            $composer2.createNode(factory$iv$iv$iv2);
                        } else {
                            factory$iv$iv$iv2 = factory$iv$iv$iv5;
                            $composer2.useNode();
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer2);
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
                        int i5 = ($changed$iv$iv$iv3 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                        BoxScope boxScope = BoxScopeInstance.INSTANCE;
                        int i6 = ((48 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer2, 2083395158, "C:AdvStateFloorComponent.kt#o90vz8");
                        String floorIcon = floorData.getFloorIcon();
                        String str2 = floorIcon;
                        if (!(str2 == null || str2.length() == 0)) {
                            $composer2.startReplaceGroup(2083472037);
                            ComposerKt.sourceInformation($composer2, "68@2717L191");
                            String $this$asRequest_u24default$iv = HelperKt.customizedImageUrl(floorIcon);
                            ImageRequest imageRequest = new ImageRequest($this$asRequest_u24default$iv);
                            Unit unit = Unit.INSTANCE;
                            BiliImageKt.BiliImage(imageRequest.build(), SizeKt.size-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(16, scale)), null, null, null, null, null, null, null, $composer2, 0, 508);
                        } else {
                            $composer2.startReplaceGroup(2080786724);
                        }
                        $composer2.endReplaceGroup();
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        $composer2.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        Modifier modifier$iv2 = RowScope.-CC.weight$default($this$AdvStateFloorComponent_u24lambda_u244, Modifier.Companion, 1.0f, false, 2, (Object) null);
                        Alignment.Vertical verticalAlignment$iv2 = Alignment.Companion.getCenterVertically();
                        int $changed$iv2 = 384;
                        ComposerKt.sourceInformationMarkerStart($composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                        Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.getStart();
                        MeasurePolicy measurePolicy$iv3 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer2, ((384 >> 3) & 14) | ((384 >> 3) & 112));
                        int $changed$iv$iv3 = (384 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
                        CompositionLocalMap localMap$iv$iv3 = $composer2.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer2, modifier$iv2);
                        Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
                        int $i$f$Row = $changed$iv$iv3 << 6;
                        int $changed$iv$iv$iv4 = ($i$f$Row & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                        if (!($composer2.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer2.startReusableNode();
                        if ($composer2.getInserting()) {
                            factory$iv$iv$iv3 = factory$iv$iv$iv6;
                            $composer2.createNode(factory$iv$iv$iv3);
                        } else {
                            factory$iv$iv$iv3 = factory$iv$iv$iv6;
                            $composer2.useNode();
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer2);
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
                        int i7 = ($changed$iv$iv$iv4 >> 6) & 14;
                        boolean z2 = false;
                        ComposerKt.sourceInformationMarkerStart($composer2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                        RowScope rowScope = RowScopeInstance.INSTANCE;
                        int i8 = ((384 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer2, -1346588091, "C:AdvStateFloorComponent.kt#o90vz8");
                        $composer2.startReplaceGroup(-459080012);
                        ComposerKt.sourceInformation($composer2, "*81@3138L110");
                        List $this$forEachIndexed$iv = stateList;
                        boolean z3 = false;
                        int index$iv = 0;
                        for (Object item$iv : $this$forEachIndexed$iv) {
                            int index$iv2 = index$iv + 1;
                            if (index$iv < 0) {
                                CollectionsKt.throwIndexOverflow();
                            }
                            AdvStateFloor.AdvState.StateInfo stateInfo = (AdvStateFloor.AdvState.StateInfo) item$iv;
                            int index = index$iv;
                            TimeNodeComponent(stateInfo, scale, null, $composer2, 0, 4);
                            Iterable $this$forEachIndexed$iv2 = $this$forEachIndexed$iv;
                            boolean z4 = z3;
                            int $i$f$forEachIndexed = stateList.size() - 1;
                            if (index < $i$f$forEachIndexed) {
                                $composer2.startReplaceGroup(-710697143);
                                ComposerKt.sourceInformation($composer2, "93@3642L6,87@3320L365");
                                $changed$iv = $changed$iv2;
                                $changed$iv$iv$iv = $changed$iv$iv$iv4;
                                z = z2;
                                BoxKt.Box(BackgroundKt.background-bw27NRU$default(SizeKt.height-3ABfNKs(SizeKt.width-3ABfNKs(PaddingKt.padding-VpY3zN4$default(Modifier.Companion, ProvideUiScaleKt.dpScaled(4, scale), 0.0f, 2, (Object) null), ProvideUiScaleKt.dpScaled(21, scale)), ProvideUiScaleKt.dpScaled(1, scale)), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getLine_regular-0d7_KjU(), (Shape) null, 2, (Object) null), $composer2, 0);
                            } else {
                                $changed$iv = $changed$iv2;
                                $changed$iv$iv$iv = $changed$iv$iv$iv4;
                                z = z2;
                                $composer2.startReplaceGroup(-713982306);
                            }
                            $composer2.endReplaceGroup();
                            $this$forEachIndexed$iv = $this$forEachIndexed$iv2;
                            z3 = z4;
                            $changed$iv2 = $changed$iv;
                            $changed$iv$iv$iv4 = $changed$iv$iv$iv;
                            z2 = z;
                            index$iv = index$iv2;
                        }
                        $composer2.endReplaceGroup();
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        $composer2.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        ComposerKt.sourceInformationMarkerEnd($composer2);
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
                    $composer3 = $composer4;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup = $composer3.endRestartGroup();
                if (endRestartGroup != null) {
                    final Modifier modifier4 = modifier3;
                    endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.AdvStateFloorComponentKt$$ExternalSyntheticLambda1
                        public final Object invoke(Object obj, Object obj2) {
                            Unit AdvStateFloorComponent$lambda$1;
                            AdvStateFloorComponent$lambda$1 = AdvStateFloorComponentKt.AdvStateFloorComponent$lambda$1(ContentModule.this, pageViewModelWrapper, modifier4, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                            return AdvStateFloorComponent$lambda$1;
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
                final Modifier modifier5 = modifier3;
                endRestartGroup2.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.AdvStateFloorComponentKt$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj, Object obj2) {
                        Unit AdvStateFloorComponent$lambda$0;
                        AdvStateFloorComponent$lambda$0 = AdvStateFloorComponentKt.AdvStateFloorComponent$lambda$0(ContentModule.this, pageViewModelWrapper, modifier5, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                        return AdvStateFloorComponent$lambda$0;
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
            final Modifier modifier6 = modifier3;
            endRestartGroup3.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.AdvStateFloorComponentKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    Unit AdvStateFloorComponent$lambda$5;
                    AdvStateFloorComponent$lambda$5 = AdvStateFloorComponentKt.AdvStateFloorComponent$lambda$5(ContentModule.this, pageViewModelWrapper, modifier6, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return AdvStateFloorComponent$lambda$5;
                }
            });
        }
    }

    private static final UiScaleModel AdvStateFloorComponent$lambda$2(State<UiScaleModel> state) {
        Object thisObj$iv = state.getValue();
        return (UiScaleModel) thisObj$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AdvStateFloorComponent$lambda$3$0(PageViewModel $pageVM) {
        PageActionHandler.trackEvent$product_details_page_debug$default($pageVM.getActionHandler$product_details_page_debug(), TrackConsts.MALL_MALL_DETAIL_PRE_SALE_RULE_0_SHOW, null, false, false, 10, null);
        return Unit.INSTANCE;
    }

    public static final void TimeNodeComponent(final AdvStateFloor.AdvState.StateInfo state, final float scale, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Modifier modifier3;
        Modifier modifier4;
        Function0 factory$iv$iv$iv;
        String str;
        long j;
        long j2;
        Intrinsics.checkNotNullParameter(state, "state");
        Composer $composer2 = $composer.startRestartGroup(518736715);
        ComposerKt.sourceInformation($composer2, "C(TimeNodeComponent)N(state,scale,modifier)121@4360L678:AdvStateFloorComponent.kt#o90vz8");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(state) ? 4 : 2;
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
        int $dirty2 = $dirty;
        if ($composer2.shouldExecute(($dirty2 & 147) != 146, $dirty2 & 1)) {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(518736715, $dirty2, -1, "kntr.app.mall.product.details.page.ui.components.TimeNodeComponent (AdvStateFloorComponent.kt:106)");
            }
            boolean isActive = Intrinsics.areEqual(state.getActive(), true);
            AdvStateFloor.AdvState.StateInfo.TimeNode timeNode = state.getTimeNode();
            String sb = (timeNode != null ? timeNode.getYear() : null) != null ? new StringBuilder().append((Object) "").append(state.getTimeNode().getYear()).toString() : "";
            AdvStateFloor.AdvState.StateInfo.TimeNode timeNode2 = state.getTimeNode();
            if ((timeNode2 != null ? timeNode2.getMonth() : null) != null) {
                sb = ((Object) sb) + (sb.length() == 0 ? "" : ".") + state.getTimeNode().getMonth();
            }
            AdvStateFloor.AdvState.StateInfo.TimeNode timeNode3 = state.getTimeNode();
            if ((timeNode3 != null ? timeNode3.getDay() : null) != null) {
                sb = ((Object) sb) + (sb.length() == 0 ? "" : ".") + state.getTimeNode().getDay();
            }
            if (sb.length() == 0) {
                sb = "时间待定";
            }
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getCenterHorizontally();
            int $changed$iv = (($dirty2 >> 6) & 14) | 384;
            Modifier modifier$iv = modifier4;
            ComposerKt.sourceInformationMarkerStart($composer2, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer2, (($changed$iv >> 3) & 14) | (($changed$iv >> 3) & 112));
            int $changed$iv$iv = ($changed$iv << 3) & 112;
            modifier3 = modifier4;
            String str2 = sb;
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
            ComposerKt.sourceInformationMarkerStart($composer2, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i4 = (($changed$iv >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -1975811949, "C133@4785L9,125@4473L350,138@4994L9,135@4832L200:AdvStateFloorComponent.kt#o90vz8");
            String timeNodeDesc = state.getTimeNodeDesc();
            if (!(timeNodeDesc == null || timeNodeDesc.length() == 0)) {
                str = state.getTimeNodeDesc();
            } else {
                str = str2;
            }
            if (isActive) {
                $composer2.startReplaceGroup(1460292134);
                ComposerKt.sourceInformation($composer2, "132@4713L6");
                j = BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText2-0d7_KjU();
            } else {
                $composer2.startReplaceGroup(1460293030);
                ComposerKt.sourceInformation($composer2, "132@4741L6");
                j = BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText3-0d7_KjU();
            }
            $composer2.endReplaceGroup();
            TextKt.Text-Nvy7gAk(str, (Modifier) null, j, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, ProvideUiScaleKt.scaled(BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT13(), scale), $composer2, 0, 0, 131066);
            String process = state.getProcess();
            String str3 = process == null ? "" : process;
            if (isActive) {
                $composer2.startReplaceGroup(1460298822);
                ComposerKt.sourceInformation($composer2, "137@4922L6");
                j2 = BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText2-0d7_KjU();
            } else {
                $composer2.startReplaceGroup(1460299718);
                ComposerKt.sourceInformation($composer2, "137@4950L6");
                j2 = BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText3-0d7_KjU();
            }
            $composer2.endReplaceGroup();
            TextKt.Text-Nvy7gAk(str3, (Modifier) null, j2, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, ProvideUiScaleKt.scaled(BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT12(), scale), $composer2, 0, 0, 131066);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.AdvStateFloorComponentKt$$ExternalSyntheticLambda4
                public final Object invoke(Object obj, Object obj2) {
                    Unit TimeNodeComponent$lambda$1;
                    TimeNodeComponent$lambda$1 = AdvStateFloorComponentKt.TimeNodeComponent$lambda$1(AdvStateFloor.AdvState.StateInfo.this, scale, modifier5, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return TimeNodeComponent$lambda$1;
                }
            });
        }
    }
}