package kntr.app.ad.ui.inspector.ui.main.ad;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.OverscrollEffect;
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
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.ProgressIndicatorKt;
import androidx.compose.material3.SurfaceKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.Shape;
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
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import java.util.List;
import kntr.app.ad.common.model.AdSlot;
import kntr.app.ad.domain.inspector.model.InspectorInfo;
import kntr.app.ad.domain.inspector.model.Status;
import kntr.app.ad.ui.inspector.ui.components.AdSlotIconKt;
import kntr.app.ad.ui.inspector.ui.components.AdSlotItemKt;
import kntr.app.ad.ui.inspector.ui.components.AppIcons;
import kntr.app.ad.ui.inspector.ui.components.EmptyViewKt;
import kntr.app.ad.ui.inspector.ui.components.StatsPanelCountItem;
import kntr.app.ad.ui.inspector.ui.components.StatsPanelKt;
import kntr.app.ad.ui.inspector.ui.main.ad.viewmodel.AdListViewModelMVI;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.enums.EnumEntries;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: AdListScreen.kt */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\u001a+\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u0001¢\u0006\u0002\u0010\u0007\u001a;\u0010\b\u001a\u00020\u00012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0014\u0010\r\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\u00010\u0003H\u0003¢\u0006\u0002\u0010\u000e\u001a3\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003H\u0003¢\u0006\u0002\u0010\u0015¨\u0006\u0016²\u0006\n\u0010\u0017\u001a\u00020\u0018X\u008a\u0084\u0002"}, d2 = {"AdListScreen", RoomRecommendViewModel.EMPTY_CURSOR, "onItemClick", "Lkotlin/Function1;", RoomRecommendViewModel.EMPTY_CURSOR, "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "(Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;II)V", "AdSlotFlowLayout", "allSlots", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/ad/common/model/AdSlot;", "selectedSlot", "onSlotSelect", "(Ljava/util/List;Lkntr/app/ad/common/model/AdSlot;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "EnhancedAdCard", "inspector", "Lkntr/app/ad/domain/inspector/model/InspectorInfo;", "highlightTitle", RoomRecommendViewModel.EMPTY_CURSOR, "onAdClick", "(Lkntr/app/ad/domain/inspector/model/InspectorInfo;ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "ad-inspector_debug", "viewState", "Lkntr/app/ad/ui/inspector/ui/main/ad/viewmodel/AdListViewModelMVI$ViewState;"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class AdListScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AdListScreen$lambda$4(Function1 function1, PaddingValues paddingValues, int i, int i2, Composer composer, int i3) {
        AdListScreen(function1, paddingValues, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AdSlotFlowLayout$lambda$1(List list, AdSlot adSlot, Function1 function1, int i, Composer composer, int i2) {
        AdSlotFlowLayout(list, adSlot, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EnhancedAdCard$lambda$1(InspectorInfo inspectorInfo, boolean z, Function1 function1, int i, int i2, Composer composer, int i3) {
        EnhancedAdCard(inspectorInfo, z, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:103:0x0347, code lost:
        if (r15 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x0385, code lost:
        if (r15 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x02de, code lost:
        if (r14 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L62;
     */
    /* JADX WARN: Removed duplicated region for block: B:102:0x033f  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x034b  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x037d  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0389  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x03e8  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0527  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0765  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0234  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0239  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0249  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x024b  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x02a9  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x02ae  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x02bc  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x02be  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x02d6  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x02e2  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0312  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0317  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0325  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0327  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void AdListScreen(Function1<? super String, Unit> function1, PaddingValues paddingValues, Composer $composer, final int $changed, final int i) {
        final PaddingValues paddingValues2;
        final Function1<? super String, Unit> function12;
        Composer $composer2;
        PaddingValues paddingValues3;
        boolean isAnyFilterActive;
        Function0 factory$iv$iv$iv;
        boolean invalid$iv;
        Object it$iv;
        Object value$iv;
        boolean invalid$iv2;
        boolean invalid$iv3;
        boolean invalid$iv4;
        Composer $composer$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Function0 factory$iv$iv$iv3;
        Intrinsics.checkNotNullParameter(function1, "onItemClick");
        Composer $composer3 = $composer.startRestartGroup(-485305024);
        ComposerKt.sourceInformation($composer3, "C(AdListScreen)N(onItemClick,paddingValues)52@2394L33,54@2488L16,57@2576L93,57@2548L121,70@2853L4846:AdListScreen.kt#rz1uci");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changedInstance(function1) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
            paddingValues2 = paddingValues;
        } else if (($changed & 48) == 0) {
            paddingValues2 = paddingValues;
            $dirty |= $composer3.changed(paddingValues2) ? 32 : 16;
        } else {
            paddingValues2 = paddingValues;
        }
        if (!$composer3.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
            function12 = function1;
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
        } else {
            if (i2 != 0) {
                paddingValues3 = PaddingKt.PaddingValues-0680j_4(Dp.constructor-impl(0));
            } else {
                paddingValues3 = paddingValues2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-485305024, $dirty, -1, "kntr.app.ad.ui.inspector.ui.main.ad.AdListScreen (AdListScreen.kt:51)");
            }
            ComposerKt.sourceInformationMarkerStart($composer3, 1773311489, "CC(remember):AdListScreen.kt#9igjgp");
            Object it$iv2 = $composer3.rememberedValue();
            if (it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = new AdListViewModelMVI();
                $composer3.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            final AdListViewModelMVI viewModel = (AdListViewModelMVI) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            final State viewState$delegate = SnapshotStateKt.collectAsState(viewModel.getState(), (CoroutineContext) null, $composer3, 0, 1);
            ComposerKt.sourceInformationMarkerStart($composer3, 1773317373, "CC(remember):AdListScreen.kt#9igjgp");
            boolean invalid$iv5 = $composer3.changedInstance(viewModel);
            Object it$iv3 = $composer3.rememberedValue();
            if (invalid$iv5 || it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv3 = new Function1() { // from class: kntr.app.ad.ui.inspector.ui.main.ad.AdListScreenKt$$ExternalSyntheticLambda2
                    public final Object invoke(Object obj) {
                        DisposableEffectResult AdListScreen$lambda$2$0;
                        AdListScreen$lambda$2$0 = AdListScreenKt.AdListScreen$lambda$2$0(AdListViewModelMVI.this, (DisposableEffectScope) obj);
                        return AdListScreen$lambda$2$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            EffectsKt.DisposableEffect(viewModel, (Function1) it$iv3, $composer3, 0);
            final EnumEntries allSlots = AdSlot.getEntries();
            if (AdListScreen$lambda$1(viewState$delegate).getSelectedSlot() == null) {
                if (!(AdListScreen$lambda$1(viewState$delegate).getSearchText().length() > 0)) {
                    isAnyFilterActive = false;
                    Modifier modifier$iv = PaddingKt.padding(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), paddingValues3);
                    ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                    Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                    Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
                    PaddingValues paddingValues4 = paddingValues3;
                    MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
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
                    if (!$composer3.getInserting()) {
                        factory$iv$iv$iv = factory$iv$iv$iv4;
                        $composer3.createNode(factory$iv$iv$iv);
                    } else {
                        factory$iv$iv$iv = factory$iv$iv$iv4;
                        $composer3.useNode();
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer3);
                    int $dirty2 = $dirty;
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
                    int i3 = ($changed$iv$iv$iv >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                    ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
                    int i4 = ((0 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer3, 82905135, "C87@3475L182,98@3948L181,109@4422L182,79@3106L95,116@4676L1422,77@3011L3098,157@6118L41:AdListScreen.kt#rz1uci");
                    Integer num = AdListScreen$lambda$1(viewState$delegate).getStatsCount().get(Status.SUCCESS);
                    int intValue = num == null ? num.intValue() : 0;
                    boolean z = AdListScreen$lambda$1(viewState$delegate).getSelectedStatus() != Status.SUCCESS;
                    ComposerKt.sourceInformationMarkerStart($composer3, 972516032, "CC(remember):AdListScreen.kt#9igjgp");
                    invalid$iv = $composer3.changedInstance(viewModel);
                    it$iv = $composer3.rememberedValue();
                    if (!invalid$iv && it$iv != Composer.Companion.getEmpty()) {
                        value$iv = it$iv;
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        StatsPanelCountItem statsPanelCountItem = new StatsPanelCountItem(intValue, "成功", z, (Function0) value$iv);
                        Integer num2 = AdListScreen$lambda$1(viewState$delegate).getStatsCount().get(Status.FAILED);
                        int intValue2 = num2 == null ? num2.intValue() : 0;
                        boolean z2 = AdListScreen$lambda$1(viewState$delegate).getSelectedStatus() != Status.FAILED;
                        ComposerKt.sourceInformationMarkerStart($composer3, 972531167, "CC(remember):AdListScreen.kt#9igjgp");
                        invalid$iv2 = $composer3.changedInstance(viewModel);
                        Object it$iv4 = $composer3.rememberedValue();
                        if (invalid$iv2) {
                        }
                        Object value$iv4 = new Function0() { // from class: kntr.app.ad.ui.inspector.ui.main.ad.AdListScreenKt$$ExternalSyntheticLambda5
                            public final Object invoke() {
                                Unit AdListScreen$lambda$3$1$0;
                                AdListScreen$lambda$3$1$0 = AdListScreenKt.AdListScreen$lambda$3$1$0(AdListViewModelMVI.this);
                                return AdListScreen$lambda$3$1$0;
                            }
                        };
                        $composer3.updateRememberedValue(value$iv4);
                        it$iv4 = value$iv4;
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        StatsPanelCountItem statsPanelCountItem2 = new StatsPanelCountItem(intValue2, "失败", z2, (Function0) it$iv4);
                        Integer num3 = AdListScreen$lambda$1(viewState$delegate).getStatsCount().get(Status.WARNING);
                        int intValue3 = num3 == null ? num3.intValue() : 0;
                        boolean z3 = AdListScreen$lambda$1(viewState$delegate).getSelectedStatus() != Status.WARNING;
                        ComposerKt.sourceInformationMarkerStart($composer3, 972546336, "CC(remember):AdListScreen.kt#9igjgp");
                        invalid$iv3 = $composer3.changedInstance(viewModel);
                        Object it$iv5 = $composer3.rememberedValue();
                        if (invalid$iv3) {
                        }
                        Object value$iv5 = new Function0() { // from class: kntr.app.ad.ui.inspector.ui.main.ad.AdListScreenKt$$ExternalSyntheticLambda6
                            public final Object invoke() {
                                Unit AdListScreen$lambda$3$2$0;
                                AdListScreen$lambda$3$2$0 = AdListScreenKt.AdListScreen$lambda$3$2$0(AdListViewModelMVI.this);
                                return AdListScreen$lambda$3$2$0;
                            }
                        };
                        $composer3.updateRememberedValue(value$iv5);
                        it$iv5 = value$iv5;
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        StatsPanelCountItem statsPanelCountItem3 = new StatsPanelCountItem(intValue3, "告警", z3, (Function0) it$iv5);
                        ComposerKt.sourceInformationMarkerStart($composer3, 972504137, "CC(remember):AdListScreen.kt#9igjgp");
                        invalid$iv4 = $composer3.changedInstance(viewModel);
                        Object it$iv6 = $composer3.rememberedValue();
                        if (invalid$iv4) {
                        }
                        Object value$iv6 = new Function0() { // from class: kntr.app.ad.ui.inspector.ui.main.ad.AdListScreenKt$$ExternalSyntheticLambda7
                            public final Object invoke() {
                                Unit AdListScreen$lambda$3$3$0;
                                AdListScreen$lambda$3$3$0 = AdListScreenKt.AdListScreen$lambda$3$3$0(AdListViewModelMVI.this);
                                return AdListScreen$lambda$3$3$0;
                            }
                        };
                        $composer3.updateRememberedValue(value$iv6);
                        it$iv6 = value$iv6;
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        StatsPanelKt.StatsPanel(isAnyFilterActive, (Function0) it$iv6, ComposableLambdaKt.rememberComposableLambda(239771350, true, new Function2() { // from class: kntr.app.ad.ui.inspector.ui.main.ad.AdListScreenKt$$ExternalSyntheticLambda8
                            public final Object invoke(Object obj, Object obj2) {
                                Unit AdListScreen$lambda$3$4;
                                AdListScreen$lambda$3$4 = AdListScreenKt.AdListScreen$lambda$3$4(AdListViewModelMVI.this, allSlots, viewState$delegate, (Composer) obj, ((Integer) obj2).intValue());
                                return AdListScreen$lambda$3$4;
                            }
                        }, $composer3, 54), statsPanelCountItem, statsPanelCountItem2, statsPanelCountItem3, $composer3, 384);
                        SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(12)), $composer3, 6);
                        if (!AdListScreen$lambda$1(viewState$delegate).isLoading()) {
                            $composer3.startReplaceGroup(85924875);
                            ComposerKt.sourceInformation($composer3, "161@6239L182");
                            Modifier modifier$iv2 = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
                            Alignment contentAlignment$iv = Alignment.Companion.getCenter();
                            ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                            MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                            int $changed$iv$iv2 = (54 << 3) & 112;
                            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
                            CompositionLocalMap localMap$iv$iv2 = $composer3.getCurrentCompositionLocalMap();
                            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer3, modifier$iv2);
                            Function0 factory$iv$iv$iv5 = ComposeUiNode.Companion.getConstructor();
                            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                            if (!($composer3.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            $composer3.startReusableNode();
                            if ($composer3.getInserting()) {
                                factory$iv$iv$iv3 = factory$iv$iv$iv5;
                                $composer3.createNode(factory$iv$iv$iv3);
                            } else {
                                factory$iv$iv$iv3 = factory$iv$iv$iv5;
                                $composer3.useNode();
                            }
                            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer3);
                            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
                            int i5 = ($changed$iv$iv$iv2 >> 6) & 14;
                            ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                            BoxScope boxScope = BoxScopeInstance.INSTANCE;
                            int i6 = ((54 >> 6) & 112) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer3, 867744159, "C165@6380L27:AdListScreen.kt#rz1uci");
                            ProgressIndicatorKt.CircularProgressIndicator-4lLiAd8((Modifier) null, 0L, 0.0f, 0L, 0, 0.0f, $composer3, 0, 63);
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            $composer3.endNode();
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            $composer3.endReplaceGroup();
                            function12 = function1;
                            $composer2 = $composer3;
                            $composer$iv$iv$iv = $composer3;
                        } else if (AdListScreen$lambda$1(viewState$delegate).getErrorMessage() != null) {
                            $composer3.startReplaceGroup(86201023);
                            ComposerKt.sourceInformation($composer3, "168@6495L185");
                            Modifier modifier$iv3 = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
                            Alignment contentAlignment$iv2 = Alignment.Companion.getCenter();
                            ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                            MeasurePolicy measurePolicy$iv3 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
                            int $changed$iv$iv3 = (54 << 3) & 112;
                            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                            int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
                            CompositionLocalMap localMap$iv$iv3 = $composer3.getCurrentCompositionLocalMap();
                            Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer3, modifier$iv3);
                            Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
                            int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
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
                            ComposerKt.sourceInformationMarkerStart($composer3, 1086189605, "C172@6636L30:AdListScreen.kt#rz1uci");
                            String errorMessage = AdListScreen$lambda$1(viewState$delegate).getErrorMessage();
                            Intrinsics.checkNotNull(errorMessage);
                            TextKt.Text-Nvy7gAk(errorMessage, (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer3, 0, 0, 262142);
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            $composer3.endNode();
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            $composer3.endReplaceGroup();
                            function12 = function1;
                            $composer2 = $composer3;
                            $composer$iv$iv$iv = $composer3;
                        } else if (AdListScreen$lambda$1(viewState$delegate).getFilteredInspectors().isEmpty()) {
                            $composer3.startReplaceGroup(86464430);
                            ComposerKt.sourceInformation($composer3, "175@6763L137");
                            EmptyViewKt.EmptyView("暂无数据", null, isAnyFilterActive ? "请尝试调整筛选条件" : "请尝试创建一个新的广告", $composer3, 6, 2);
                            $composer3.endReplaceGroup();
                            function12 = function1;
                            $composer2 = $composer3;
                            $composer$iv$iv$iv = $composer3;
                        } else {
                            $composer3.startReplaceGroup(86657839);
                            ComposerKt.sourceInformation($composer3, "182@7017L666,180@6940L743");
                            Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
                            ComposerKt.sourceInformationMarkerStart($composer3, 972629860, "CC(remember):AdListScreen.kt#9igjgp");
                            $composer2 = $composer3;
                            boolean invalid$iv6 = $composer2.changed(viewState$delegate) | (($dirty2 & 14) == 4);
                            Object it$iv7 = $composer3.rememberedValue();
                            if (invalid$iv6 || it$iv7 == Composer.Companion.getEmpty()) {
                                function12 = function1;
                                $composer$iv$iv$iv = $composer3;
                                Object value$iv7 = new Function1() { // from class: kntr.app.ad.ui.inspector.ui.main.ad.AdListScreenKt$$ExternalSyntheticLambda9
                                    public final Object invoke(Object obj) {
                                        Unit AdListScreen$lambda$3$7$0;
                                        AdListScreen$lambda$3$7$0 = AdListScreenKt.AdListScreen$lambda$3$7$0(viewState$delegate, function12, (LazyListScope) obj);
                                        return AdListScreen$lambda$3$7$0;
                                    }
                                };
                                $composer3.updateRememberedValue(value$iv7);
                                it$iv7 = value$iv7;
                            } else {
                                function12 = function1;
                                $composer$iv$iv$iv = $composer3;
                            }
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            LazyDslKt.LazyColumn(fillMaxSize$default, (LazyListState) null, (PaddingValues) null, false, (Arrangement.Vertical) null, (Alignment.Horizontal) null, (FlingBehavior) null, false, (OverscrollEffect) null, (Function1) it$iv7, $composer3, 6, 510);
                            $composer3.endReplaceGroup();
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        $composer$iv$iv$iv.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        paddingValues2 = paddingValues4;
                    }
                    value$iv = new Function0() { // from class: kntr.app.ad.ui.inspector.ui.main.ad.AdListScreenKt$$ExternalSyntheticLambda4
                        public final Object invoke() {
                            Unit AdListScreen$lambda$3$0$0;
                            AdListScreen$lambda$3$0$0 = AdListScreenKt.AdListScreen$lambda$3$0$0(AdListViewModelMVI.this);
                            return AdListScreen$lambda$3$0$0;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    StatsPanelCountItem statsPanelCountItem4 = new StatsPanelCountItem(intValue, "成功", z, (Function0) value$iv);
                    Integer num22 = AdListScreen$lambda$1(viewState$delegate).getStatsCount().get(Status.FAILED);
                    if (num22 == null) {
                    }
                    if (AdListScreen$lambda$1(viewState$delegate).getSelectedStatus() != Status.FAILED) {
                    }
                    ComposerKt.sourceInformationMarkerStart($composer3, 972531167, "CC(remember):AdListScreen.kt#9igjgp");
                    invalid$iv2 = $composer3.changedInstance(viewModel);
                    Object it$iv42 = $composer3.rememberedValue();
                    if (invalid$iv2) {
                    }
                    Object value$iv42 = new Function0() { // from class: kntr.app.ad.ui.inspector.ui.main.ad.AdListScreenKt$$ExternalSyntheticLambda5
                        public final Object invoke() {
                            Unit AdListScreen$lambda$3$1$0;
                            AdListScreen$lambda$3$1$0 = AdListScreenKt.AdListScreen$lambda$3$1$0(AdListViewModelMVI.this);
                            return AdListScreen$lambda$3$1$0;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv42);
                    it$iv42 = value$iv42;
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    StatsPanelCountItem statsPanelCountItem22 = new StatsPanelCountItem(intValue2, "失败", z2, (Function0) it$iv42);
                    Integer num32 = AdListScreen$lambda$1(viewState$delegate).getStatsCount().get(Status.WARNING);
                    if (num32 == null) {
                    }
                    if (AdListScreen$lambda$1(viewState$delegate).getSelectedStatus() != Status.WARNING) {
                    }
                    ComposerKt.sourceInformationMarkerStart($composer3, 972546336, "CC(remember):AdListScreen.kt#9igjgp");
                    invalid$iv3 = $composer3.changedInstance(viewModel);
                    Object it$iv52 = $composer3.rememberedValue();
                    if (invalid$iv3) {
                    }
                    Object value$iv52 = new Function0() { // from class: kntr.app.ad.ui.inspector.ui.main.ad.AdListScreenKt$$ExternalSyntheticLambda6
                        public final Object invoke() {
                            Unit AdListScreen$lambda$3$2$0;
                            AdListScreen$lambda$3$2$0 = AdListScreenKt.AdListScreen$lambda$3$2$0(AdListViewModelMVI.this);
                            return AdListScreen$lambda$3$2$0;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv52);
                    it$iv52 = value$iv52;
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    StatsPanelCountItem statsPanelCountItem32 = new StatsPanelCountItem(intValue3, "告警", z3, (Function0) it$iv52);
                    ComposerKt.sourceInformationMarkerStart($composer3, 972504137, "CC(remember):AdListScreen.kt#9igjgp");
                    invalid$iv4 = $composer3.changedInstance(viewModel);
                    Object it$iv62 = $composer3.rememberedValue();
                    if (invalid$iv4) {
                    }
                    Object value$iv62 = new Function0() { // from class: kntr.app.ad.ui.inspector.ui.main.ad.AdListScreenKt$$ExternalSyntheticLambda7
                        public final Object invoke() {
                            Unit AdListScreen$lambda$3$3$0;
                            AdListScreen$lambda$3$3$0 = AdListScreenKt.AdListScreen$lambda$3$3$0(AdListViewModelMVI.this);
                            return AdListScreen$lambda$3$3$0;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv62);
                    it$iv62 = value$iv62;
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    StatsPanelKt.StatsPanel(isAnyFilterActive, (Function0) it$iv62, ComposableLambdaKt.rememberComposableLambda(239771350, true, new Function2() { // from class: kntr.app.ad.ui.inspector.ui.main.ad.AdListScreenKt$$ExternalSyntheticLambda8
                        public final Object invoke(Object obj, Object obj2) {
                            Unit AdListScreen$lambda$3$4;
                            AdListScreen$lambda$3$4 = AdListScreenKt.AdListScreen$lambda$3$4(AdListViewModelMVI.this, allSlots, viewState$delegate, (Composer) obj, ((Integer) obj2).intValue());
                            return AdListScreen$lambda$3$4;
                        }
                    }, $composer3, 54), statsPanelCountItem4, statsPanelCountItem22, statsPanelCountItem32, $composer3, 384);
                    SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(12)), $composer3, 6);
                    if (!AdListScreen$lambda$1(viewState$delegate).isLoading()) {
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    $composer$iv$iv$iv.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    paddingValues2 = paddingValues4;
                }
            }
            isAnyFilterActive = true;
            Modifier modifier$iv4 = PaddingKt.padding(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), paddingValues3);
            ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv2 = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv2 = Alignment.Companion.getStart();
            PaddingValues paddingValues42 = paddingValues3;
            MeasurePolicy measurePolicy$iv4 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv2, horizontalAlignment$iv2, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv4 = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv4 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv4 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer3, modifier$iv4);
            Function0 factory$iv$iv$iv42 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv4 = (($changed$iv$iv4 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
            }
            $composer3.startReusableNode();
            if (!$composer3.getInserting()) {
            }
            Composer $this$Layout_u24lambda_u240$iv$iv4 = Updater.constructor-impl($composer3);
            int $dirty22 = $dirty;
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, measurePolicy$iv4, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, localMap$iv$iv4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv4, Integer.valueOf(compositeKeyHash$iv$iv4), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv4, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, materialized$iv$iv4, ComposeUiNode.Companion.getSetModifier());
            int i32 = ($changed$iv$iv$iv4 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope2 = ColumnScopeInstance.INSTANCE;
            int i42 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 82905135, "C87@3475L182,98@3948L181,109@4422L182,79@3106L95,116@4676L1422,77@3011L3098,157@6118L41:AdListScreen.kt#rz1uci");
            Integer num4 = AdListScreen$lambda$1(viewState$delegate).getStatsCount().get(Status.SUCCESS);
            if (num4 == null) {
            }
            if (AdListScreen$lambda$1(viewState$delegate).getSelectedStatus() != Status.SUCCESS) {
            }
            ComposerKt.sourceInformationMarkerStart($composer3, 972516032, "CC(remember):AdListScreen.kt#9igjgp");
            invalid$iv = $composer3.changedInstance(viewModel);
            it$iv = $composer3.rememberedValue();
            if (!invalid$iv) {
                value$iv = it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                StatsPanelCountItem statsPanelCountItem42 = new StatsPanelCountItem(intValue, "成功", z, (Function0) value$iv);
                Integer num222 = AdListScreen$lambda$1(viewState$delegate).getStatsCount().get(Status.FAILED);
                if (num222 == null) {
                }
                if (AdListScreen$lambda$1(viewState$delegate).getSelectedStatus() != Status.FAILED) {
                }
                ComposerKt.sourceInformationMarkerStart($composer3, 972531167, "CC(remember):AdListScreen.kt#9igjgp");
                invalid$iv2 = $composer3.changedInstance(viewModel);
                Object it$iv422 = $composer3.rememberedValue();
                if (invalid$iv2) {
                }
                Object value$iv422 = new Function0() { // from class: kntr.app.ad.ui.inspector.ui.main.ad.AdListScreenKt$$ExternalSyntheticLambda5
                    public final Object invoke() {
                        Unit AdListScreen$lambda$3$1$0;
                        AdListScreen$lambda$3$1$0 = AdListScreenKt.AdListScreen$lambda$3$1$0(AdListViewModelMVI.this);
                        return AdListScreen$lambda$3$1$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv422);
                it$iv422 = value$iv422;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                StatsPanelCountItem statsPanelCountItem222 = new StatsPanelCountItem(intValue2, "失败", z2, (Function0) it$iv422);
                Integer num322 = AdListScreen$lambda$1(viewState$delegate).getStatsCount().get(Status.WARNING);
                if (num322 == null) {
                }
                if (AdListScreen$lambda$1(viewState$delegate).getSelectedStatus() != Status.WARNING) {
                }
                ComposerKt.sourceInformationMarkerStart($composer3, 972546336, "CC(remember):AdListScreen.kt#9igjgp");
                invalid$iv3 = $composer3.changedInstance(viewModel);
                Object it$iv522 = $composer3.rememberedValue();
                if (invalid$iv3) {
                }
                Object value$iv522 = new Function0() { // from class: kntr.app.ad.ui.inspector.ui.main.ad.AdListScreenKt$$ExternalSyntheticLambda6
                    public final Object invoke() {
                        Unit AdListScreen$lambda$3$2$0;
                        AdListScreen$lambda$3$2$0 = AdListScreenKt.AdListScreen$lambda$3$2$0(AdListViewModelMVI.this);
                        return AdListScreen$lambda$3$2$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv522);
                it$iv522 = value$iv522;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                StatsPanelCountItem statsPanelCountItem322 = new StatsPanelCountItem(intValue3, "告警", z3, (Function0) it$iv522);
                ComposerKt.sourceInformationMarkerStart($composer3, 972504137, "CC(remember):AdListScreen.kt#9igjgp");
                invalid$iv4 = $composer3.changedInstance(viewModel);
                Object it$iv622 = $composer3.rememberedValue();
                if (invalid$iv4) {
                }
                Object value$iv622 = new Function0() { // from class: kntr.app.ad.ui.inspector.ui.main.ad.AdListScreenKt$$ExternalSyntheticLambda7
                    public final Object invoke() {
                        Unit AdListScreen$lambda$3$3$0;
                        AdListScreen$lambda$3$3$0 = AdListScreenKt.AdListScreen$lambda$3$3$0(AdListViewModelMVI.this);
                        return AdListScreen$lambda$3$3$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv622);
                it$iv622 = value$iv622;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                StatsPanelKt.StatsPanel(isAnyFilterActive, (Function0) it$iv622, ComposableLambdaKt.rememberComposableLambda(239771350, true, new Function2() { // from class: kntr.app.ad.ui.inspector.ui.main.ad.AdListScreenKt$$ExternalSyntheticLambda8
                    public final Object invoke(Object obj, Object obj2) {
                        Unit AdListScreen$lambda$3$4;
                        AdListScreen$lambda$3$4 = AdListScreenKt.AdListScreen$lambda$3$4(AdListViewModelMVI.this, allSlots, viewState$delegate, (Composer) obj, ((Integer) obj2).intValue());
                        return AdListScreen$lambda$3$4;
                    }
                }, $composer3, 54), statsPanelCountItem42, statsPanelCountItem222, statsPanelCountItem322, $composer3, 384);
                SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(12)), $composer3, 6);
                if (!AdListScreen$lambda$1(viewState$delegate).isLoading()) {
                }
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer$iv$iv$iv.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                if (ComposerKt.isTraceInProgress()) {
                }
                paddingValues2 = paddingValues42;
            }
            value$iv = new Function0() { // from class: kntr.app.ad.ui.inspector.ui.main.ad.AdListScreenKt$$ExternalSyntheticLambda4
                public final Object invoke() {
                    Unit AdListScreen$lambda$3$0$0;
                    AdListScreen$lambda$3$0$0 = AdListScreenKt.AdListScreen$lambda$3$0$0(AdListViewModelMVI.this);
                    return AdListScreen$lambda$3$0$0;
                }
            };
            $composer3.updateRememberedValue(value$iv);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            StatsPanelCountItem statsPanelCountItem422 = new StatsPanelCountItem(intValue, "成功", z, (Function0) value$iv);
            Integer num2222 = AdListScreen$lambda$1(viewState$delegate).getStatsCount().get(Status.FAILED);
            if (num2222 == null) {
            }
            if (AdListScreen$lambda$1(viewState$delegate).getSelectedStatus() != Status.FAILED) {
            }
            ComposerKt.sourceInformationMarkerStart($composer3, 972531167, "CC(remember):AdListScreen.kt#9igjgp");
            invalid$iv2 = $composer3.changedInstance(viewModel);
            Object it$iv4222 = $composer3.rememberedValue();
            if (invalid$iv2) {
            }
            Object value$iv4222 = new Function0() { // from class: kntr.app.ad.ui.inspector.ui.main.ad.AdListScreenKt$$ExternalSyntheticLambda5
                public final Object invoke() {
                    Unit AdListScreen$lambda$3$1$0;
                    AdListScreen$lambda$3$1$0 = AdListScreenKt.AdListScreen$lambda$3$1$0(AdListViewModelMVI.this);
                    return AdListScreen$lambda$3$1$0;
                }
            };
            $composer3.updateRememberedValue(value$iv4222);
            it$iv4222 = value$iv4222;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            StatsPanelCountItem statsPanelCountItem2222 = new StatsPanelCountItem(intValue2, "失败", z2, (Function0) it$iv4222);
            Integer num3222 = AdListScreen$lambda$1(viewState$delegate).getStatsCount().get(Status.WARNING);
            if (num3222 == null) {
            }
            if (AdListScreen$lambda$1(viewState$delegate).getSelectedStatus() != Status.WARNING) {
            }
            ComposerKt.sourceInformationMarkerStart($composer3, 972546336, "CC(remember):AdListScreen.kt#9igjgp");
            invalid$iv3 = $composer3.changedInstance(viewModel);
            Object it$iv5222 = $composer3.rememberedValue();
            if (invalid$iv3) {
            }
            Object value$iv5222 = new Function0() { // from class: kntr.app.ad.ui.inspector.ui.main.ad.AdListScreenKt$$ExternalSyntheticLambda6
                public final Object invoke() {
                    Unit AdListScreen$lambda$3$2$0;
                    AdListScreen$lambda$3$2$0 = AdListScreenKt.AdListScreen$lambda$3$2$0(AdListViewModelMVI.this);
                    return AdListScreen$lambda$3$2$0;
                }
            };
            $composer3.updateRememberedValue(value$iv5222);
            it$iv5222 = value$iv5222;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            StatsPanelCountItem statsPanelCountItem3222 = new StatsPanelCountItem(intValue3, "告警", z3, (Function0) it$iv5222);
            ComposerKt.sourceInformationMarkerStart($composer3, 972504137, "CC(remember):AdListScreen.kt#9igjgp");
            invalid$iv4 = $composer3.changedInstance(viewModel);
            Object it$iv6222 = $composer3.rememberedValue();
            if (invalid$iv4) {
            }
            Object value$iv6222 = new Function0() { // from class: kntr.app.ad.ui.inspector.ui.main.ad.AdListScreenKt$$ExternalSyntheticLambda7
                public final Object invoke() {
                    Unit AdListScreen$lambda$3$3$0;
                    AdListScreen$lambda$3$3$0 = AdListScreenKt.AdListScreen$lambda$3$3$0(AdListViewModelMVI.this);
                    return AdListScreen$lambda$3$3$0;
                }
            };
            $composer3.updateRememberedValue(value$iv6222);
            it$iv6222 = value$iv6222;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            StatsPanelKt.StatsPanel(isAnyFilterActive, (Function0) it$iv6222, ComposableLambdaKt.rememberComposableLambda(239771350, true, new Function2() { // from class: kntr.app.ad.ui.inspector.ui.main.ad.AdListScreenKt$$ExternalSyntheticLambda8
                public final Object invoke(Object obj, Object obj2) {
                    Unit AdListScreen$lambda$3$4;
                    AdListScreen$lambda$3$4 = AdListScreenKt.AdListScreen$lambda$3$4(AdListViewModelMVI.this, allSlots, viewState$delegate, (Composer) obj, ((Integer) obj2).intValue());
                    return AdListScreen$lambda$3$4;
                }
            }, $composer3, 54), statsPanelCountItem422, statsPanelCountItem2222, statsPanelCountItem3222, $composer3, 384);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(12)), $composer3, 6);
            if (!AdListScreen$lambda$1(viewState$delegate).isLoading()) {
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer$iv$iv$iv.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            if (ComposerKt.isTraceInProgress()) {
            }
            paddingValues2 = paddingValues42;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.ad.ui.inspector.ui.main.ad.AdListScreenKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    Unit AdListScreen$lambda$4;
                    AdListScreen$lambda$4 = AdListScreenKt.AdListScreen$lambda$4(function12, paddingValues2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return AdListScreen$lambda$4;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AdListViewModelMVI.ViewState AdListScreen$lambda$1(State<AdListViewModelMVI.ViewState> state) {
        Object thisObj$iv = state.getValue();
        return (AdListViewModelMVI.ViewState) thisObj$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult AdListScreen$lambda$2$0(final AdListViewModelMVI $viewModel, DisposableEffectScope $this$DisposableEffect) {
        Intrinsics.checkNotNullParameter($this$DisposableEffect, "$this$DisposableEffect");
        return new DisposableEffectResult() { // from class: kntr.app.ad.ui.inspector.ui.main.ad.AdListScreenKt$AdListScreen$lambda$2$0$$inlined$onDispose$1
            public void dispose() {
                AdListViewModelMVI.this.onCleared();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AdListScreen$lambda$3$3$0(AdListViewModelMVI $viewModel) {
        $viewModel.processIntent(AdListViewModelMVI.Intent.ClearFilters.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AdListScreen$lambda$3$0$0(AdListViewModelMVI $viewModel) {
        $viewModel.processIntent(new AdListViewModelMVI.Intent.SelectStatus(Status.SUCCESS));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AdListScreen$lambda$3$1$0(AdListViewModelMVI $viewModel) {
        $viewModel.processIntent(new AdListViewModelMVI.Intent.SelectStatus(Status.FAILED));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AdListScreen$lambda$3$2$0(AdListViewModelMVI $viewModel) {
        $viewModel.processIntent(new AdListViewModelMVI.Intent.SelectStatus(Status.WARNING));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AdListScreen$lambda$3$4(final AdListViewModelMVI $viewModel, EnumEntries $allSlots, State $viewState$delegate, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C120@4799L10,118@4718L204,124@4940L40,128@5128L109,126@5023L328,135@5369L41,139@5510L10,137@5428L205,143@5651L40,149@5887L178,146@5734L350:AdListScreen.kt#rz1uci");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(239771350, $changed, -1, "kntr.app.ad.ui.inspector.ui.main.ad.AdListScreen.<anonymous>.<anonymous> (AdListScreen.kt:118)");
            }
            TextKt.Text-Nvy7gAk("搜索", (Modifier) null, ColorKt.Color(4285231744L), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, TextStyle.copy-p1EtxEg$default(MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getBodySmall(), 0L, 0L, FontWeight.Companion.getMedium(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777211, (Object) null), $composer, 390, 0, 131066);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(8)), $composer, 6);
            String searchText = AdListScreen$lambda$1($viewState$delegate).getSearchText();
            ComposerKt.sourceInformationMarkerStart($composer, -1507952061, "CC(remember):AdListScreen.kt#9igjgp");
            boolean invalid$iv = $composer.changedInstance($viewModel);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function1() { // from class: kntr.app.ad.ui.inspector.ui.main.ad.AdListScreenKt$$ExternalSyntheticLambda18
                    public final Object invoke(Object obj) {
                        Unit AdListScreen$lambda$3$4$0$0;
                        AdListScreen$lambda$3$4$0$0 = AdListScreenKt.AdListScreen$lambda$3$4$0$0(AdListViewModelMVI.this, (String) obj);
                        return AdListScreen$lambda$3$4$0$0;
                    }
                };
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            StatsPanelKt.ModernSearchField(searchText, (Function1) it$iv, "搜索广告标题", AppIcons.INSTANCE.getSearch(), $composer, 3456);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16)), $composer, 6);
            TextKt.Text-Nvy7gAk("广告位", (Modifier) null, ColorKt.Color(4285231744L), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, TextStyle.copy-p1EtxEg$default(MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getBodySmall(), 0L, 0L, FontWeight.Companion.getMedium(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777211, (Object) null), $composer, 390, 0, 131066);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(8)), $composer, 6);
            List list = (List) $allSlots;
            AdSlot selectedSlot = AdListScreen$lambda$1($viewState$delegate).getSelectedSlot();
            ComposerKt.sourceInformationMarkerStart($composer, -1507927704, "CC(remember):AdListScreen.kt#9igjgp");
            boolean invalid$iv2 = $composer.changedInstance($viewModel);
            Object it$iv2 = $composer.rememberedValue();
            if (invalid$iv2 || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = new Function1() { // from class: kntr.app.ad.ui.inspector.ui.main.ad.AdListScreenKt$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        Unit AdListScreen$lambda$3$4$1$0;
                        AdListScreen$lambda$3$4$1$0 = AdListScreenKt.AdListScreen$lambda$3$4$1$0(AdListViewModelMVI.this, (AdSlot) obj);
                        return AdListScreen$lambda$3$4$1$0;
                    }
                };
                $composer.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            AdSlotFlowLayout(list, selectedSlot, (Function1) it$iv2, $composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AdListScreen$lambda$3$4$0$0(AdListViewModelMVI $viewModel, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        $viewModel.processIntent(new AdListViewModelMVI.Intent.Search(it));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AdListScreen$lambda$3$4$1$0(AdListViewModelMVI $viewModel, AdSlot slot) {
        $viewModel.processIntent(new AdListViewModelMVI.Intent.SelectSlot(slot));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AdListScreen$lambda$3$7$0(final State $viewState$delegate, final Function1 $onItemClick, LazyListScope $this$LazyColumn) {
        Intrinsics.checkNotNullParameter($this$LazyColumn, "$this$LazyColumn");
        final List items$iv = AdListScreen$lambda$1($viewState$delegate).getFilteredInspectors();
        final Function1 key$iv = new Function1() { // from class: kntr.app.ad.ui.inspector.ui.main.ad.AdListScreenKt$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Object AdListScreen$lambda$3$7$0$0;
                AdListScreen$lambda$3$7$0$0 = AdListScreenKt.AdListScreen$lambda$3$7$0$0((InspectorInfo) obj);
                return AdListScreen$lambda$3$7$0$0;
            }
        };
        final Function1 contentType$iv = new Function1() { // from class: kntr.app.ad.ui.inspector.ui.main.ad.AdListScreenKt$AdListScreen$lambda$3$7$0$$inlined$items$default$1
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                return m442invoke((InspectorInfo) p1);
            }

            /* renamed from: invoke  reason: collision with other method in class */
            public final Void m442invoke(InspectorInfo inspectorInfo) {
                return null;
            }
        };
        $this$LazyColumn.items(items$iv.size(), new Function1<Integer, Object>() { // from class: kntr.app.ad.ui.inspector.ui.main.ad.AdListScreenKt$AdListScreen$lambda$3$7$0$$inlined$items$default$2
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                return invoke(((Number) p1).intValue());
            }

            public final Object invoke(int index) {
                return key$iv.invoke(items$iv.get(index));
            }
        }, new Function1<Integer, Object>() { // from class: kntr.app.ad.ui.inspector.ui.main.ad.AdListScreenKt$AdListScreen$lambda$3$7$0$$inlined$items$default$3
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                return invoke(((Number) p1).intValue());
            }

            public final Object invoke(int index) {
                return contentType$iv.invoke(items$iv.get(index));
            }
        }, ComposableLambdaKt.composableLambdaInstance(802480018, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: kntr.app.ad.ui.inspector.ui.main.ad.AdListScreenKt$AdListScreen$lambda$3$7$0$$inlined$items$default$4
            public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3, Object p4) {
                invoke((LazyItemScope) p1, ((Number) p2).intValue(), (Composer) p3, ((Number) p4).intValue());
                return Unit.INSTANCE;
            }

            /* JADX WARN: Removed duplicated region for block: B:38:0x00ab  */
            /* JADX WARN: Removed duplicated region for block: B:42:0x00ca  */
            /* JADX WARN: Removed duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void invoke(LazyItemScope $this$items, int it, Composer $composer, int $changed) {
                AdListViewModelMVI.ViewState AdListScreen$lambda$1;
                boolean z;
                boolean z2;
                AdListViewModelMVI.ViewState AdListScreen$lambda$12;
                ComposerKt.sourceInformation($composer, "CN(it)178@8834L22:LazyDsl.kt#428nma");
                int $dirty = $changed;
                if (($changed & 6) == 0) {
                    $dirty |= $composer.changed($this$items) ? 4 : 2;
                }
                if (($changed & 48) == 0) {
                    $dirty |= $composer.changed(it) ? 32 : 16;
                }
                if (!$composer.shouldExecute(($dirty & 147) != 146, $dirty & 1)) {
                    $composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(802480018, $dirty, -1, "androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:178)");
                }
                int $changed2 = $dirty & 14;
                InspectorInfo inspector = (InspectorInfo) items$iv.get(it);
                $composer.startReplaceGroup(-1255172028);
                ComposerKt.sourceInformation($composer, "CN(inspector)*187@7190L461:AdListScreen.kt#rz1uci");
                AdListScreen$lambda$1 = AdListScreenKt.AdListScreen$lambda$1($viewState$delegate);
                if (AdListScreen$lambda$1.getSearchText().length() > 0) {
                    String title = inspector.getAdData().getTitle();
                    if (title != null) {
                        AdListScreen$lambda$12 = AdListScreenKt.AdListScreen$lambda$1($viewState$delegate);
                        if (StringsKt.contains(title, AdListScreen$lambda$12.getSearchText(), true)) {
                            z2 = true;
                            if (z2) {
                                z = true;
                                AdListScreenKt.EnhancedAdCard(inspector, z, $onItemClick, $composer, InspectorInfo.$stable | (($changed2 >> 3) & 14), 0);
                                $composer.endReplaceGroup();
                                if (!ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                        }
                    }
                    z2 = false;
                    if (z2) {
                    }
                }
                z = false;
                AdListScreenKt.EnhancedAdCard(inspector, z, $onItemClick, $composer, InspectorInfo.$stable | (($changed2 >> 3) & 14), 0);
                $composer.endReplaceGroup();
                if (!ComposerKt.isTraceInProgress()) {
                }
            }
        }));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object AdListScreen$lambda$3$7$0$0(InspectorInfo it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getId();
    }

    private static final void AdSlotFlowLayout(final List<? extends AdSlot> list, final AdSlot selectedSlot, final Function1<? super AdSlot, Unit> function1, Composer $composer, final int $changed) {
        Function0 factory$iv$iv$iv;
        Composer $composer2 = $composer.startRestartGroup(384702088);
        ComposerKt.sourceInformation($composer2, "C(AdSlotFlowLayout)N(allSlots,selectedSlot,onSlotSelect)211@7898L607:AdListScreen.kt#rz1uci");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(list) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(selectedSlot == null ? -1 : selectedSlot.ordinal()) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changedInstance(function1) ? 256 : 128;
        }
        if ($composer2.shouldExecute(($dirty & 147) != 146, $dirty & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(384702088, $dirty, -1, "kntr.app.ad.ui.inspector.ui.main.ad.AdSlotFlowLayout (AdListScreen.kt:210)");
            }
            Modifier modifier$iv$iv = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer2, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer2, ((6 >> 3) & 14) | ((6 >> 3) & 112));
            int $changed$iv$iv = (6 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
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
            ComposerKt.sourceInformationMarkerStart($composer2, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i2 = ((6 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -912374997, "C218@8197L302,213@7981L518:AdListScreen.kt#rz1uci");
            FlowLayoutKt.FlowRow(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(8)), Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(8)), (Alignment.Vertical) null, 0, 0, ComposableLambdaKt.rememberComposableLambda(1320953805, true, new Function3() { // from class: kntr.app.ad.ui.inspector.ui.main.ad.AdListScreenKt$$ExternalSyntheticLambda10
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit AdSlotFlowLayout$lambda$0$0;
                    AdSlotFlowLayout$lambda$0$0 = AdListScreenKt.AdSlotFlowLayout$lambda$0$0(list, selectedSlot, function1, (FlowRowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return AdSlotFlowLayout$lambda$0$0;
                }
            }, $composer2, 54), $composer2, 1573302, 56);
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
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.ad.ui.inspector.ui.main.ad.AdListScreenKt$$ExternalSyntheticLambda11
                public final Object invoke(Object obj, Object obj2) {
                    Unit AdSlotFlowLayout$lambda$1;
                    AdSlotFlowLayout$lambda$1 = AdListScreenKt.AdSlotFlowLayout$lambda$1(list, selectedSlot, function1, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return AdSlotFlowLayout$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AdSlotFlowLayout$lambda$0$0(List $allSlots, AdSlot $selectedSlot, final Function1 $onSlotSelect, FlowRowScope $this$FlowRow, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$FlowRow, "$this$FlowRow");
        ComposerKt.sourceInformation($composer, "C*224@8434L22,221@8306L169:AdListScreen.kt#rz1uci");
        if ($composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1320953805, $changed, -1, "kntr.app.ad.ui.inspector.ui.main.ad.AdSlotFlowLayout.<anonymous>.<anonymous> (AdListScreen.kt:219)");
            }
            List $this$forEach$iv = $allSlots;
            for (Object element$iv : $this$forEach$iv) {
                final AdSlot slot = (AdSlot) element$iv;
                boolean z = $selectedSlot == slot;
                ComposerKt.sourceInformationMarkerStart($composer, -1977111197, "CC(remember):AdListScreen.kt#9igjgp");
                boolean invalid$iv = $composer.changed($onSlotSelect) | $composer.changed(slot.ordinal());
                Object it$iv = $composer.rememberedValue();
                if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function0() { // from class: kntr.app.ad.ui.inspector.ui.main.ad.AdListScreenKt$$ExternalSyntheticLambda17
                        public final Object invoke() {
                            Unit AdSlotFlowLayout$lambda$0$0$0$0$0;
                            AdSlotFlowLayout$lambda$0$0$0$0$0 = AdListScreenKt.AdSlotFlowLayout$lambda$0$0$0$0$0($onSlotSelect, slot);
                            return AdSlotFlowLayout$lambda$0$0$0$0$0;
                        }
                    };
                    $composer.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                ComposerKt.sourceInformationMarkerEnd($composer);
                AdSlotItemKt.AdSlotItem(slot, z, (Function0) it$iv, $composer, 0);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AdSlotFlowLayout$lambda$0$0$0$0$0(Function1 $onSlotSelect, AdSlot $slot) {
        $onSlotSelect.invoke($slot);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void EnhancedAdCard(final InspectorInfo inspector, boolean highlightTitle, final Function1<? super String, Unit> function1, Composer $composer, final int $changed, final int i) {
        boolean z;
        boolean highlightTitle2;
        final boolean highlightTitle3;
        Composer $composer2 = $composer.startRestartGroup(-458361974);
        ComposerKt.sourceInformation($composer2, "C(EnhancedAdCard)N(inspector,highlightTitle,onAdClick)246@8903L7796,238@8669L8030:AdListScreen.kt#rz1uci");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= ($changed & 8) == 0 ? $composer2.changed(inspector) : $composer2.changedInstance(inspector) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
            z = highlightTitle;
        } else if (($changed & 48) == 0) {
            z = highlightTitle;
            $dirty |= $composer2.changed(z) ? 32 : 16;
        } else {
            z = highlightTitle;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changedInstance(function1) ? 256 : 128;
        }
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute(($dirty2 & 147) != 146, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
            highlightTitle2 = z;
        } else {
            if (i2 != 0) {
                highlightTitle3 = false;
            } else {
                highlightTitle3 = z;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-458361974, $dirty2, -1, "kntr.app.ad.ui.inspector.ui.main.ad.EnhancedAdCard (AdListScreen.kt:237)");
            }
            SurfaceKt.Surface-T9BRK9s(PaddingKt.padding-VpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, Dp.constructor-impl(6), 1, (Object) null), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(12)), Color.Companion.getWhite-0d7_KjU(), 0L, 0.0f, Dp.constructor-impl(1), (BorderStroke) null, ComposableLambdaKt.rememberComposableLambda(2014073231, true, new Function2() { // from class: kntr.app.ad.ui.inspector.ui.main.ad.AdListScreenKt$$ExternalSyntheticLambda12
                public final Object invoke(Object obj, Object obj2) {
                    Unit EnhancedAdCard$lambda$0;
                    EnhancedAdCard$lambda$0 = AdListScreenKt.EnhancedAdCard$lambda$0(function1, inspector, highlightTitle3, (Composer) obj, ((Integer) obj2).intValue());
                    return EnhancedAdCard$lambda$0;
                }
            }, $composer2, 54), $composer2, 12779910, 88);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            highlightTitle2 = highlightTitle3;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final boolean z2 = highlightTitle2;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.ad.ui.inspector.ui.main.ad.AdListScreenKt$$ExternalSyntheticLambda13
                public final Object invoke(Object obj, Object obj2) {
                    Unit EnhancedAdCard$lambda$1;
                    EnhancedAdCard$lambda$1 = AdListScreenKt.EnhancedAdCard$lambda$1(InspectorInfo.this, z2, function1, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return EnhancedAdCard$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EnhancedAdCard$lambda$0(final Function1 $onAdClick, final InspectorInfo $inspector, final boolean $highlightTitle, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Function0 factory$iv$iv$iv3;
        long j2;
        Composer $composer$iv$iv$iv;
        Composer $composer$iv$iv$iv2;
        Composer $composer$iv;
        Composer $composer$iv2;
        Function0 factory$iv$iv$iv4;
        Function0 factory$iv$iv$iv5;
        Function0 factory$iv$iv$iv6;
        ComposerKt.sourceInformation($composer, "C252@9101L27,248@8981L7712:AdListScreen.kt#rz1uci");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2014073231, $changed, -1, "kntr.app.ad.ui.inspector.ui.main.ad.EnhancedAdCard.<anonymous> (AdListScreen.kt:248)");
            }
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, -1505869142, "CC(remember):AdListScreen.kt#9igjgp");
            boolean invalid$iv = $composer.changed($onAdClick) | $composer.changedInstance($inspector);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function0() { // from class: kntr.app.ad.ui.inspector.ui.main.ad.AdListScreenKt$$ExternalSyntheticLambda14
                    public final Object invoke() {
                        Unit EnhancedAdCard$lambda$0$0$0;
                        EnhancedAdCard$lambda$0$0$0 = AdListScreenKt.EnhancedAdCard$lambda$0$0$0($onAdClick, $inspector);
                        return EnhancedAdCard$lambda$0$0$0;
                    }
                };
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            Modifier modifier$iv = ClickableKt.clickable-oSLSa3U$default(fillMaxWidth$default, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer, modifier$iv);
            Function0 factory$iv$iv$iv7 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv7;
                $composer.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv7;
                $composer.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i2 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, 25051481, "C255@9174L7509:AdListScreen.kt#rz1uci");
            Modifier modifier$iv2 = PaddingKt.padding-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(16));
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            int $changed$iv$iv2 = ((390 >> 3) & 14) | ((390 >> 3) & 112);
            MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer, $changed$iv$iv2);
            int $changed$iv$iv3 = (390 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer, modifier$iv2);
            Function0 factory$iv$iv$iv8 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv3 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv8;
                $composer.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv8;
                $composer.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i4 = ((390 >> 6) & 112) | 6;
            RowScope $this$EnhancedAdCard_u24lambda_u240_u241_u240 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer, 2073560408, "C263@9451L28,265@9497L40,268@9579L6263,412@16139L530,406@15884L785:AdListScreen.kt#rz1uci");
            AdSlotIconKt.AdSlotIcon($inspector.getAdSlot(), $composer, 0);
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(12)), $composer, 6);
            Modifier modifier$iv3 = RowScope.-CC.weight$default($this$EnhancedAdCard_u24lambda_u240_u241_u240, Modifier.Companion, 1.0f, false, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            int $changed$iv$iv$iv3 = ((0 >> 3) & 14) | ((0 >> 3) & 112);
            MeasurePolicy measurePolicy$iv3 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer, $changed$iv$iv$iv3);
            int $changed$iv$iv4 = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv3 = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer, modifier$iv3);
            Function0 factory$iv$iv$iv9 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv4 = (($changed$iv$iv4 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                factory$iv$iv$iv3 = factory$iv$iv$iv9;
                $composer.createNode(factory$iv$iv$iv3);
            } else {
                factory$iv$iv$iv3 = factory$iv$iv$iv9;
                $composer.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
            int i5 = ($changed$iv$iv$iv4 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i6 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, 1432524719, "C276@9975L1149,272@9707L1417,300@11146L40:AdListScreen.kt#rz1uci");
            Shape shape = RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(4));
            if ($highlightTitle) {
                $composer.startReplaceGroup(1431682335);
                ComposerKt.sourceInformation($composer, "274@9840L11");
                j2 = MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getPrimaryContainer-0d7_KjU();
                $composer.endReplaceGroup();
            } else {
                $composer.startReplaceGroup(1431683226);
                $composer.endReplaceGroup();
                j2 = Color.Companion.getTransparent-0d7_KjU();
            }
            SurfaceKt.Surface-T9BRK9s(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), shape, j2, 0L, 0.0f, 0.0f, (BorderStroke) null, ComposableLambdaKt.rememberComposableLambda(-1101977078, true, new Function2() { // from class: kntr.app.ad.ui.inspector.ui.main.ad.AdListScreenKt$$ExternalSyntheticLambda15
                public final Object invoke(Object obj, Object obj2) {
                    Unit EnhancedAdCard$lambda$0$1$0$0$0;
                    EnhancedAdCard$lambda$0$1$0$0$0 = AdListScreenKt.EnhancedAdCard$lambda$0$1$0$0$0(InspectorInfo.this, $highlightTitle, (Composer) obj, ((Integer) obj2).intValue());
                    return EnhancedAdCard$lambda$0$1$0$0$0;
                }
            }, $composer, 54), $composer, 12582918, 120);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(8)), $composer, 6);
            String creativeId = $inspector.getAdData().getCreativeId();
            if (!(creativeId == null || creativeId.length() == 0)) {
                $composer.startReplaceGroup(1433983671);
                ComposerKt.sourceInformation($composer, "305@11350L1322,334@12698L40");
                Alignment.Vertical verticalAlignment$iv2 = Alignment.Companion.getCenterVertically();
                Modifier modifier$iv4 = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.getStart();
                int $i$f$Row = ((390 >> 3) & 14) | ((390 >> 3) & 112);
                MeasurePolicy measurePolicy$iv4 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer, $i$f$Row);
                int $changed$iv$iv5 = (390 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv4 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
                CompositionLocalMap localMap$iv$iv4 = $composer.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer, modifier$iv4);
                Function0 factory$iv$iv$iv10 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv5 = (($changed$iv$iv5 << 6) & 896) | 6;
                $composer$iv = $composer;
                $composer$iv$iv$iv2 = $composer;
                ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer.startReusableNode();
                if ($composer.getInserting()) {
                    factory$iv$iv$iv6 = factory$iv$iv$iv10;
                    $composer.createNode(factory$iv$iv$iv6);
                } else {
                    factory$iv$iv$iv6 = factory$iv$iv$iv10;
                    $composer.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv4 = Updater.constructor-impl($composer);
                $composer$iv$iv$iv = $composer;
                $composer$iv2 = $composer;
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, measurePolicy$iv4, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, localMap$iv$iv4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv4, Integer.valueOf(compositeKeyHash$iv$iv4), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv4, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, materialized$iv$iv4, ComposeUiNode.Companion.getSetModifier());
                int i7 = ($changed$iv$iv$iv5 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                int i8 = ((390 >> 6) & 112) | 6;
                RowScope $this$EnhancedAdCard_u24lambda_u240_u241_u240_u240_u241 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer, 1393178862, "C312@11701L10,309@11551L434,319@12015L39,324@12258L10,321@12084L562:AdListScreen.kt#rz1uci");
                TextKt.Text-Nvy7gAk("creativeId:", (Modifier) null, ColorKt.Color(4285231744L), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, TextStyle.copy-p1EtxEg$default(MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getBodySmall(), 0L, TextUnitKt.getSp(12), FontWeight.Companion.getMedium(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777209, (Object) null), $composer, 390, 0, 131066);
                SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(4)), $composer, 6);
                String creativeId2 = $inspector.getAdData().getCreativeId();
                if (creativeId2 == null) {
                    creativeId2 = RoomRecommendViewModel.EMPTY_CURSOR;
                }
                TextKt.Text-Nvy7gAk(creativeId2, RowScope.-CC.weight$default($this$EnhancedAdCard_u24lambda_u240_u241_u240_u240_u241, Modifier.Companion, 1.0f, false, 2, (Object) null), ColorKt.Color(4281811281L), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, TextStyle.copy-p1EtxEg$default(MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getBodySmall(), 0L, TextUnitKt.getSp(12), (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777213, (Object) null), $composer, 384, 24960, 110584);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(4)), $composer, 6);
            } else {
                $composer$iv$iv$iv = $composer;
                $composer$iv$iv$iv2 = $composer;
                $composer$iv = $composer;
                $composer$iv2 = $composer;
                $composer.startReplaceGroup(1422704755);
            }
            $composer.endReplaceGroup();
            String salesType = $inspector.getAdData().getSalesType();
            if (!(salesType == null || salesType.length() == 0)) {
                $composer.startReplaceGroup(1435508561);
                ComposerKt.sourceInformation($composer, "339@12885L1392,369@14303L40");
                Alignment.Vertical verticalAlignment$iv3 = Alignment.Companion.getCenterVertically();
                Modifier modifier$iv5 = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                Arrangement.Horizontal horizontalArrangement$iv3 = Arrangement.INSTANCE.getStart();
                MeasurePolicy measurePolicy$iv5 = RowKt.rowMeasurePolicy(horizontalArrangement$iv3, verticalAlignment$iv3, $composer, ((390 >> 3) & 14) | ((390 >> 3) & 112));
                int $changed$iv$iv6 = (390 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv5 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
                CompositionLocalMap localMap$iv$iv5 = $composer.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv5 = ComposedModifierKt.materializeModifier($composer, modifier$iv5);
                Function0 factory$iv$iv$iv11 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv6 = (($changed$iv$iv6 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer.startReusableNode();
                if ($composer.getInserting()) {
                    factory$iv$iv$iv5 = factory$iv$iv$iv11;
                    $composer.createNode(factory$iv$iv$iv5);
                } else {
                    factory$iv$iv$iv5 = factory$iv$iv$iv11;
                    $composer.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv5 = Updater.constructor-impl($composer);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, measurePolicy$iv5, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, localMap$iv$iv5, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv5, Integer.valueOf(compositeKeyHash$iv$iv5), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv5, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, materialized$iv$iv5, ComposeUiNode.Companion.getSetModifier());
                int i9 = ($changed$iv$iv$iv6 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                int i10 = ((390 >> 6) & 112) | 6;
                RowScope $this$EnhancedAdCard_u24lambda_u240_u241_u240_u240_u242 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer, 48842385, "C346@13235L10,343@13086L433,353@13549L39,358@13791L10,355@13618L633:AdListScreen.kt#rz1uci");
                TextKt.Text-Nvy7gAk("salesType:", (Modifier) null, ColorKt.Color(4285231744L), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, TextStyle.copy-p1EtxEg$default(MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getBodySmall(), 0L, TextUnitKt.getSp(12), FontWeight.Companion.getMedium(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777209, (Object) null), $composer, 390, 0, 131066);
                SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(4)), $composer, 6);
                String salesType2 = $inspector.getAdData().getSalesType();
                if (salesType2 == null) {
                    salesType2 = RoomRecommendViewModel.EMPTY_CURSOR;
                }
                TextKt.Text-Nvy7gAk(salesType2, RowScope.-CC.weight$default($this$EnhancedAdCard_u24lambda_u240_u241_u240_u240_u242, Modifier.Companion, 1.0f, false, 2, (Object) null), ColorKt.Color(4281811281L), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, TextStyle.copy-p1EtxEg$default(MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getBodySmall(), 0L, TextUnitKt.getSp(12), FontWeight.Companion.getNormal(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777209, (Object) null), $composer, 384, 24960, 110584);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(4)), $composer, 6);
            } else {
                $composer.startReplaceGroup(1422704755);
            }
            $composer.endReplaceGroup();
            if ($inspector.getAdData().getCardStyle() != null) {
                $composer.startReplaceGroup(1437111850);
                ComposerKt.sourceInformation($composer, "374@14481L1321");
                Alignment.Vertical verticalAlignment$iv4 = Alignment.Companion.getCenterVertically();
                Modifier modifier$iv6 = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                Arrangement.Horizontal horizontalArrangement$iv4 = Arrangement.INSTANCE.getStart();
                MeasurePolicy measurePolicy$iv6 = RowKt.rowMeasurePolicy(horizontalArrangement$iv4, verticalAlignment$iv4, $composer, ((390 >> 3) & 14) | ((390 >> 3) & 112));
                int $changed$iv$iv7 = (390 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv6 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
                CompositionLocalMap localMap$iv$iv6 = $composer.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv6 = ComposedModifierKt.materializeModifier($composer, modifier$iv6);
                Function0 factory$iv$iv$iv12 = ComposeUiNode.Companion.getConstructor();
                int $i$f$Row2 = $changed$iv$iv7 << 6;
                int $changed$iv$iv$iv7 = ($i$f$Row2 & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer.startReusableNode();
                if ($composer.getInserting()) {
                    factory$iv$iv$iv4 = factory$iv$iv$iv12;
                    $composer.createNode(factory$iv$iv$iv4);
                } else {
                    factory$iv$iv$iv4 = factory$iv$iv$iv12;
                    $composer.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv6 = Updater.constructor-impl($composer);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv6, measurePolicy$iv6, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv6, localMap$iv$iv6, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv6, Integer.valueOf(compositeKeyHash$iv$iv6), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv6, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv6, materialized$iv$iv6, ComposeUiNode.Companion.getSetModifier());
                int i11 = ($changed$iv$iv$iv7 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                int i12 = ((390 >> 6) & 112) | 6;
                RowScope $this$EnhancedAdCard_u24lambda_u240_u241_u240_u240_u243 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer, -1693383657, "C381@14831L10,378@14682L433,388@15145L39,393@15388L10,390@15214L562:AdListScreen.kt#rz1uci");
                TextKt.Text-Nvy7gAk("cardStyle:", (Modifier) null, ColorKt.Color(4285231744L), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, TextStyle.copy-p1EtxEg$default(MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getBodySmall(), 0L, TextUnitKt.getSp(12), FontWeight.Companion.getMedium(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777209, (Object) null), $composer, 390, 0, 131066);
                SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(4)), $composer, 6);
                TextKt.Text-Nvy7gAk(String.valueOf($inspector.getAdData().getCardStyle()), RowScope.-CC.weight$default($this$EnhancedAdCard_u24lambda_u240_u241_u240_u240_u243, Modifier.Companion, 1.0f, false, 2, (Object) null), ColorKt.Color(4281811281L), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, TextStyle.copy-p1EtxEg$default(MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getBodySmall(), 0L, TextUnitKt.getSp(12), (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777213, (Object) null), $composer, 384, 24960, 110584);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
            } else {
                $composer.startReplaceGroup(1422704755);
            }
            $composer.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer$iv2);
            $composer$iv$iv$iv.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv2);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            SurfaceKt.Surface-T9BRK9s(Modifier.Companion, RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(4)), Color.copy-wmQWz5c$default($inspector.getPipeline().getStatus().m325getColor0d7_KjU(), 0.1f, 0.0f, 0.0f, 0.0f, 14, (Object) null), 0L, 0.0f, 0.0f, (BorderStroke) null, ComposableLambdaKt.rememberComposableLambda(1516249108, true, new Function2() { // from class: kntr.app.ad.ui.inspector.ui.main.ad.AdListScreenKt$$ExternalSyntheticLambda16
                public final Object invoke(Object obj, Object obj2) {
                    Unit EnhancedAdCard$lambda$0$1$0$1;
                    EnhancedAdCard$lambda$0$1$0$1 = AdListScreenKt.EnhancedAdCard$lambda$0$1$0$1(InspectorInfo.this, (Composer) obj, ((Integer) obj2).intValue());
                    return EnhancedAdCard$lambda$0$1$0$1;
                }
            }, $composer, 54), $composer, 12582918, 120);
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
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EnhancedAdCard$lambda$0$0$0(Function1 $onAdClick, InspectorInfo $inspector) {
        $onAdClick.invoke($inspector.getId());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EnhancedAdCard$lambda$0$1$0$0$0(InspectorInfo $inspector, boolean $highlightTitle, Composer $composer, int $changed) {
        long Color;
        ComposerKt.sourceInformation($composer, "C280@10155L10,277@10001L1101:AdListScreen.kt#rz1uci");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1101977078, $changed, -1, "kntr.app.ad.ui.inspector.ui.main.ad.EnhancedAdCard.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AdListScreen.kt:277)");
            }
            String title = $inspector.getAdData().getTitle();
            if (title == null) {
                title = "-";
            }
            TextStyle bodyLarge = MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getBodyLarge();
            FontWeight.Companion companion = FontWeight.Companion;
            TextStyle textStyle = TextStyle.copy-p1EtxEg$default(bodyLarge, 0L, TextUnitKt.getSp(16), $highlightTitle ? companion.getBold() : companion.getMedium(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777209, (Object) null);
            int i = TextOverflow.Companion.getEllipsis-gIe3tQ8();
            if ($highlightTitle) {
                $composer.startReplaceGroup(1731475748);
                ComposerKt.sourceInformation($composer, "288@10624L11");
                long j2 = MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnPrimaryContainer-0d7_KjU();
                $composer.endReplaceGroup();
                Color = j2;
            } else {
                $composer.startReplaceGroup(1731595935);
                $composer.endReplaceGroup();
                Color = ColorKt.Color(4280232247L);
            }
            TextKt.Text-Nvy7gAk(title, PaddingKt.padding-VpY3zN4(Modifier.Companion, $highlightTitle ? Dp.constructor-impl(6) : Dp.constructor-impl(0), $highlightTitle ? Dp.constructor-impl(2) : Dp.constructor-impl(0)), Color, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, i, false, 1, 0, (Function1) null, textStyle, $composer, 0, 24960, 110584);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EnhancedAdCard$lambda$0$1$0$1(InspectorInfo $inspector, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C416@16304L10,413@16161L490:AdListScreen.kt#rz1uci");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1516249108, $changed, -1, "kntr.app.ad.ui.inspector.ui.main.ad.EnhancedAdCard.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AdListScreen.kt:413)");
            }
            TextKt.Text-Nvy7gAk($inspector.getPipeline().getStatus().getText(), PaddingKt.padding-VpY3zN4(Modifier.Companion, Dp.constructor-impl(6), Dp.constructor-impl(2)), $inspector.getPipeline().getStatus().m325getColor0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, TextStyle.copy-p1EtxEg$default(MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getBodySmall(), 0L, TextUnitKt.getSp(11), FontWeight.Companion.getMedium(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777209, (Object) null), $composer, 48, 0, 131064);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}