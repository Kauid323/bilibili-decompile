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
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
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
import kntr.app.mall.product.details.page.api.model.ServiceFloor;
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
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ServiceFloorComponent.kt */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0001¢\u0006\u0002\u0010\b¨\u0006\t²\u0006\n\u0010\n\u001a\u00020\u000bX\u008a\u0084\u0002²\u0006\n\u0010\f\u001a\u00020\rX\u008a\u008e\u0002"}, d2 = {"ServiceFloorComponent", "", "module", "Lkntr/app/mall/product/details/page/vm/ContentModule;", "pageVMWrapper", "Lkntr/app/mall/product/details/page/vm/PageViewModelWrapper;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lkntr/app/mall/product/details/page/vm/ContentModule;Lkntr/app/mall/product/details/page/vm/PageViewModelWrapper;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "product-details-page_debug", "scaleModel", "Lkntr/app/mall/product/details/page/ui/scale/UiScaleModel;", "showPanel", ""}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ServiceFloorComponentKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ServiceFloorComponent$lambda$0(ContentModule contentModule, PageViewModelWrapper pageViewModelWrapper, Modifier modifier, int i, int i2, Composer composer, int i3) {
        ServiceFloorComponent(contentModule, pageViewModelWrapper, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ServiceFloorComponent$lambda$12(ContentModule contentModule, PageViewModelWrapper pageViewModelWrapper, Modifier modifier, int i, int i2, Composer composer, int i3) {
        ServiceFloorComponent(contentModule, pageViewModelWrapper, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ServiceFloorComponent$lambda$2(ContentModule contentModule, PageViewModelWrapper pageViewModelWrapper, Modifier modifier, int i, int i2, Composer composer, int i3) {
        ServiceFloorComponent(contentModule, pageViewModelWrapper, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ServiceFloorComponent$lambda$3(ContentModule contentModule, PageViewModelWrapper pageViewModelWrapper, Modifier modifier, int i, int i2, Composer composer, int i3) {
        ServiceFloorComponent(contentModule, pageViewModelWrapper, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: SSATransform
        java.lang.IndexOutOfBoundsException: bitIndex < 0: -123
        	at java.util.BitSet.get(BitSet.java:623)
        	at jadx.core.dex.visitors.ssa.LiveVarAnalysis.fillBasicBlockInfo(LiveVarAnalysis.java:65)
        	at jadx.core.dex.visitors.ssa.LiveVarAnalysis.runAnalysis(LiveVarAnalysis.java:36)
        	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:55)
        	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:41)
        */
    public static final void ServiceFloorComponent(kntr.app.mall.product.details.page.vm.ContentModule r145, kntr.app.mall.product.details.page.vm.PageViewModelWrapper r146, androidx.compose.ui.Modifier r147, androidx.compose.runtime.Composer r148, int r149, int r150) {
        /*
            Method dump skipped, instructions count: 3148
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kntr.app.mall.product.details.page.ui.components.ServiceFloorComponentKt.ServiceFloorComponent(kntr.app.mall.product.details.page.vm.ContentModule, kntr.app.mall.product.details.page.vm.PageViewModelWrapper, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final UiScaleModel ServiceFloorComponent$lambda$1(State<UiScaleModel> state) {
        Object thisObj$iv = state.getValue();
        return (UiScaleModel) thisObj$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MutableState ServiceFloorComponent$lambda$4$0() {
        return SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
    }

    private static final boolean ServiceFloorComponent$lambda$5(MutableState<Boolean> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    private static final void ServiceFloorComponent$lambda$6(MutableState<Boolean> mutableState, boolean z) {
        Object value$iv = Boolean.valueOf(z);
        mutableState.setValue(value$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ServiceFloorComponent$lambda$7$0(PageViewModel $pageVM) {
        PageActionHandler.trackEvent$product_details_page_debug$default($pageVM.getActionHandler$product_details_page_debug(), TrackConsts.MALL_MALL_DETAIL_SERVICE_0_SHOW, null, false, false, 10, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ServiceFloorComponent$lambda$8$0(PageViewModel $pageVM, MutableState $showPanel$delegate) {
        ServiceFloorComponent$lambda$6($showPanel$delegate, !ServiceFloorComponent$lambda$5($showPanel$delegate));
        PageActionHandler.trackEvent$product_details_page_debug$default($pageVM.getActionHandler$product_details_page_debug(), TrackConsts.MALL_MALL_DETAIL_SERVICE_0_CLICK, null, true, false, 10, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ServiceFloorComponent$lambda$10$0(MutableState $showPanel$delegate) {
        ServiceFloorComponent$lambda$6($showPanel$delegate, !ServiceFloorComponent$lambda$5($showPanel$delegate));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0414, code lost:
        if (r10 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L35;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit ServiceFloorComponent$lambda$11(float $scale, ServiceFloor.ServicePanelVO $servicePanelInfo, final MutableState $showPanel$delegate, ColumnScope $this$BottomSheet, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Function0 factory$iv$iv$iv3;
        Composer $composer2;
        Function0 factory$iv$iv$iv4;
        Intrinsics.checkNotNullParameter($this$BottomSheet, "$this$BottomSheet");
        ComposerKt.sourceInformation($composer, "C192@7615L3098:ServiceFloorComponent.kt#o90vz8");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1973815860, $changed, -1, "kntr.app.mall.product.details.page.ui.components.ServiceFloorComponent.<anonymous> (ServiceFloorComponent.kt:192)");
            }
            Modifier modifier$iv = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer, ((6 >> 3) & 14) | ((6 >> 3) & 112));
            int $changed$iv$iv = (6 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer, modifier$iv);
            Function0 factory$iv$iv$iv5 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv5;
                $composer.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv5;
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
            int i2 = ((6 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -2069946135, "C197@7731L1122:ServiceFloorComponent.kt#o90vz8");
            Modifier modifier$iv2 = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), ProvideUiScaleKt.dpScaled(48, $scale));
            Alignment contentAlignment$iv = Alignment.Companion.getTopCenter();
            ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv2 = (48 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer, modifier$iv2);
            Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv6;
                $composer.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv6;
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
            int i4 = ((48 >> 6) & 112) | 6;
            BoxScope $this$ServiceFloorComponent_u24lambda_u2411_u240_u240 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer, -1977485463, "C207@8128L6,208@8180L9,204@7973L254,211@8245L594:ServiceFloorComponent.kt#o90vz8");
            String title = $servicePanelInfo.getTitle();
            if (title == null) {
                title = "服务说明";
            }
            TextKt.Text-Nvy7gAk(title, (Modifier) null, BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, ProvideUiScaleKt.scaled(BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT16b(), $scale), $composer, 0, 0, 130042);
            Modifier modifier$iv3 = $this$ServiceFloorComponent_u24lambda_u2411_u240_u240.align(Modifier.Companion, Alignment.Companion.getTopEnd());
            ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv2 = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv3 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
            int $changed$iv$iv3 = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv3 = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer, modifier$iv3);
            Function0 factory$iv$iv$iv7 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                factory$iv$iv$iv3 = factory$iv$iv$iv7;
                $composer.createNode(factory$iv$iv$iv3);
            } else {
                factory$iv$iv$iv3 = factory$iv$iv$iv7;
                $composer.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer);
            String str = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
            int i5 = ($changed$iv$iv$iv3 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i6 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -1663565313, "C215@8408L20,216@8471L6,220@8658L89,214@8355L466:ServiceFloorComponent.kt#o90vz8");
            Painter xmark_close_line_500 = BiliIconfont.INSTANCE.getXmark_close_line_500($composer, 6);
            long j = BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText3-0d7_KjU();
            Modifier modifier = SizeKt.size-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(24, $scale));
            ComposerKt.sourceInformationMarkerStart($composer, 1331819243, "CC(remember):ServiceFloorComponent.kt#9igjgp");
            boolean invalid$iv = $composer.changed($showPanel$delegate);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv) {
            }
            Object value$iv = new Function0() { // from class: kntr.app.mall.product.details.page.ui.components.ServiceFloorComponentKt$$ExternalSyntheticLambda0
                public final Object invoke() {
                    Unit ServiceFloorComponent$lambda$11$0$0$0$0$0;
                    ServiceFloorComponent$lambda$11$0$0$0$0$0 = ServiceFloorComponentKt.ServiceFloorComponent$lambda$11$0$0$0$0$0($showPanel$delegate);
                    return ServiceFloorComponent$lambda$11$0$0$0$0$0;
                }
            };
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer);
            IconKt.Icon-ww6aTOc(xmark_close_line_500, (String) null, ClickableKt.clickable-oSLSa3U$default(modifier, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null), j, $composer, Painter.$stable | 48, 0);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            String desc = $servicePanelInfo.getDesc();
            boolean z = desc == null || desc.length() == 0;
            int i7 = 8;
            if (!z) {
                $composer2 = $composer;
                $composer2.startReplaceGroup(-2068841513);
                ComposerKt.sourceInformation($composer2, "231@9023L6,232@9075L9,229@8929L269");
                TextKt.Text-Nvy7gAk($servicePanelInfo.getDesc(), PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, 0.0f, ProvideUiScaleKt.dpScaled(8, $scale), 7, (Object) null), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, ProvideUiScaleKt.scaled(BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT14(), $scale), $composer2, 0, 0, 131064);
            } else {
                $composer2 = $composer;
                $composer2.startReplaceGroup(-2077708412);
            }
            $composer2.endReplaceGroup();
            Iterable contents = $servicePanelInfo.getContents();
            if (contents == null) {
                $composer2.startReplaceGroup(-2068483495);
                $composer2.endReplaceGroup();
            } else {
                $composer2.startReplaceGroup(-2068483494);
                ComposerKt.sourceInformation($composer2, "*241@9418L995,267@10514L6,268@10566L9,265@10431L258");
                Iterable $this$forEach$iv = contents;
                boolean z2 = false;
                Iterator it = $this$forEach$iv.iterator();
                while (it.hasNext()) {
                    Object element$iv = it.next();
                    ServiceFloor.ServicePanelVO.Content content = (ServiceFloor.ServicePanelVO.Content) element$iv;
                    String iconUrl = content.getIcon();
                    String title2 = content.getTitle();
                    String desc2 = content.getContent();
                    Modifier modifier$iv4 = PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, 0.0f, 0.0f, ProvideUiScaleKt.dpScaled(i7, $scale), 7, (Object) null);
                    Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
                    Composer $composer$iv = $composer2;
                    ComposerKt.sourceInformationMarkerStart($composer$iv, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                    Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                    MeasurePolicy measurePolicy$iv4 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer$iv, ((384 >> 3) & 14) | ((384 >> 3) & 112));
                    int $changed$iv$iv4 = (384 << 3) & 112;
                    Iterable $this$forEach$iv2 = $this$forEach$iv;
                    ComposerKt.sourceInformationMarkerStart($composer$iv, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int compositeKeyHash$iv$iv4 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv, 0));
                    CompositionLocalMap localMap$iv$iv4 = $composer$iv.getCurrentCompositionLocalMap();
                    boolean z3 = z2;
                    Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer$iv, modifier$iv4);
                    Function0 factory$iv$iv$iv8 = ComposeUiNode.Companion.getConstructor();
                    int $changed$iv$iv$iv4 = (($changed$iv$iv4 << 6) & 896) | 6;
                    Iterator it2 = it;
                    String str2 = str;
                    ComposerKt.sourceInformationMarkerStart($composer$iv, -553112988, str2);
                    if (!($composer$iv.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer$iv.startReusableNode();
                    if ($composer$iv.getInserting()) {
                        factory$iv$iv$iv4 = factory$iv$iv$iv8;
                        $composer$iv.createNode(factory$iv$iv$iv4);
                    } else {
                        factory$iv$iv$iv4 = factory$iv$iv$iv8;
                        $composer$iv.useNode();
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv4 = Updater.constructor-impl($composer$iv);
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, measurePolicy$iv4, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, localMap$iv$iv4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv4, Integer.valueOf(compositeKeyHash$iv$iv4), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv4, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, materialized$iv$iv4, ComposeUiNode.Companion.getSetModifier());
                    int i8 = ($changed$iv$iv$iv4 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer$iv, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                    int i9 = ((384 >> 6) & 112) | 6;
                    RowScope $this$ServiceFloorComponent_u24lambda_u2411_u240_u241_u240 = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart($composer$iv, -1205517176, "C:ServiceFloorComponent.kt#o90vz8");
                    String str3 = iconUrl;
                    if (str3 == null || str3.length() == 0) {
                        $composer$iv.startReplaceGroup(-1215088117);
                    } else {
                        $composer$iv.startReplaceGroup(-1205499693);
                        ComposerKt.sourceInformation($composer$iv, "246@9679L328");
                        String $this$asRequest_u24default$iv = HelperKt.customizedImageUrl(iconUrl);
                        ImageRequest imageRequest = new ImageRequest($this$asRequest_u24default$iv);
                        Unit unit = Unit.INSTANCE;
                        BiliImageKt.BiliImage(imageRequest.build(), PaddingKt.padding-qDBjuR0$default(SizeKt.size-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(24, $scale)), 0.0f, 0.0f, ProvideUiScaleKt.dpScaled(8, $scale), 0.0f, 11, (Object) null), null, null, null, null, null, null, null, $composer$iv, 0, 508);
                    }
                    $composer$iv.endReplaceGroup();
                    String str4 = title2;
                    if (str4 == null || str4.length() == 0) {
                        $composer$iv.startReplaceGroup(-1215088117);
                    } else {
                        $composer$iv.startReplaceGroup(-1205054657);
                        ComposerKt.sourceInformation($composer$iv, "258@10199L6,259@10259L9,256@10105L268");
                        TextKt.Text-Nvy7gAk(title2, RowScope.-CC.weight$default($this$ServiceFloorComponent_u24lambda_u2411_u240_u241_u240, Modifier.Companion, 1.0f, false, 2, (Object) null), BiliTheme.INSTANCE.getColors($composer$iv, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, ProvideUiScaleKt.scaled(BiliTheme.INSTANCE.getTextStyle($composer$iv, BiliTheme.$stable).getT14(), $scale), $composer$iv, 0, 0, 131064);
                    }
                    $composer$iv.endReplaceGroup();
                    ComposerKt.sourceInformationMarkerEnd($composer$iv);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv);
                    $composer$iv.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer$iv);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv);
                    TextKt.Text-Nvy7gAk(desc2 == null ? "" : desc2, PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, 0.0f, ProvideUiScaleKt.dpScaled(8, $scale), 7, (Object) null), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText2-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, ProvideUiScaleKt.scaled(BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT12(), $scale), $composer2, 0, 0, 131064);
                    i7 = 8;
                    z2 = z3;
                    $this$forEach$iv = $this$forEach$iv2;
                    str = str2;
                    it = it2;
                }
                $composer2.endReplaceGroup();
                Unit unit2 = Unit.INSTANCE;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ServiceFloorComponent$lambda$11$0$0$0$0$0(MutableState $showPanel$delegate) {
        ServiceFloorComponent$lambda$6($showPanel$delegate, false);
        return Unit.INSTANCE;
    }
}