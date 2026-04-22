package kntr.app.ad.ui.inspector.ui.main.report;

import ComposableSingletons$CustomBottomSheetKt$;
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
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.ProgressIndicatorKt;
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
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
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
import androidx.compose.ui.unit.Dp;
import kntr.app.ad.domain.inspector.core.work.ReportType;
import kntr.app.ad.domain.inspector.model.Status;
import kntr.app.ad.ui.inspector.ui.components.AppIcons;
import kntr.app.ad.ui.inspector.ui.components.EmptyViewKt;
import kntr.app.ad.ui.inspector.ui.components.ReportListKt;
import kntr.app.ad.ui.inspector.ui.components.StatsPanelCountItem;
import kntr.app.ad.ui.inspector.ui.components.StatsPanelKt;
import kntr.app.ad.ui.inspector.ui.main.report.viewmodel.ReportListViewModel;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ReportListScreen.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\u001a+\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u0001¢\u0006\u0002\u0010\u0007¨\u0006\b²\u0006\n\u0010\t\u001a\u00020\nX\u008a\u0084\u0002"}, d2 = {"ReportListScreen", RoomRecommendViewModel.EMPTY_CURSOR, "onItemClick", "Lkotlin/Function1;", RoomRecommendViewModel.EMPTY_CURSOR, "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "(Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;II)V", "ad-inspector_debug", "viewState", "Lkntr/app/ad/ui/inspector/ui/main/report/viewmodel/ReportListViewModel$ViewState;"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ReportListScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ReportListScreen$lambda$4(Function1 function1, PaddingValues paddingValues, int i, int i2, Composer composer, int i3) {
        ReportListScreen(function1, paddingValues, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:105:0x033e, code lost:
        if (r9 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x037b, code lost:
        if (r9 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x02d7, code lost:
        if (r8 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L64;
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x031e  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0320  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0336  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0342  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0373  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x037f  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x03dc  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x052f  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x05d2  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x022f  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0234  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0244  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0246  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x02a4  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x02a9  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x02b7  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x02b9  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x02cf  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x02db  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x030b  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0310  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void ReportListScreen(final Function1<? super String, Unit> function1, PaddingValues paddingValues, Composer $composer, final int $changed, final int i) {
        final PaddingValues paddingValues2;
        PaddingValues paddingValues3;
        boolean z;
        Function0 factory$iv$iv$iv;
        boolean invalid$iv;
        Object it$iv;
        Object value$iv;
        boolean invalid$iv2;
        boolean invalid$iv3;
        boolean invalid$iv4;
        Composer $composer$iv$iv;
        Composer $composer2;
        Composer $composer$iv;
        Composer $composer$iv2;
        Function0 factory$iv$iv$iv2;
        Intrinsics.checkNotNullParameter(function1, "onItemClick");
        Composer $composer3 = $composer.startRestartGroup(352038895);
        ComposerKt.sourceInformation($composer3, "C(ReportListScreen)N(onItemClick,paddingValues)43@1988L34,45@2083L16,48@2171L93,48@2143L121,61@2467L5693:ReportListScreen.kt#ezboep");
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
        int $dirty2 = $dirty;
        if (!$composer3.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            $composer3.skipToGroupEnd();
        } else {
            if (i2 != 0) {
                paddingValues3 = PaddingKt.PaddingValues-0680j_4(Dp.constructor-impl(0));
            } else {
                paddingValues3 = paddingValues2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(352038895, $dirty2, -1, "kntr.app.ad.ui.inspector.ui.main.report.ReportListScreen (ReportListScreen.kt:42)");
            }
            ComposerKt.sourceInformationMarkerStart($composer3, -993033871, "CC(remember):ReportListScreen.kt#9igjgp");
            Object it$iv2 = $composer3.rememberedValue();
            if (it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = new ReportListViewModel();
                $composer3.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            final ReportListViewModel viewModel = (ReportListViewModel) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            final State viewState$delegate = SnapshotStateKt.collectAsState(viewModel.getState(), (CoroutineContext) null, $composer3, 0, 1);
            ComposerKt.sourceInformationMarkerStart($composer3, -993027956, "CC(remember):ReportListScreen.kt#9igjgp");
            boolean invalid$iv5 = $composer3.changedInstance(viewModel);
            Object it$iv3 = $composer3.rememberedValue();
            if (invalid$iv5 || it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv3 = new Function1() { // from class: kntr.app.ad.ui.inspector.ui.main.report.ReportListScreenKt$$ExternalSyntheticLambda6
                    public final Object invoke(Object obj) {
                        DisposableEffectResult ReportListScreen$lambda$2$0;
                        ReportListScreen$lambda$2$0 = ReportListScreenKt.ReportListScreen$lambda$2$0(ReportListViewModel.this, (DisposableEffectScope) obj);
                        return ReportListScreen$lambda$2$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            EffectsKt.DisposableEffect(viewModel, (Function1) it$iv3, $composer3, 0);
            if (ReportListScreen$lambda$1(viewState$delegate).getSelectedReportType() == null) {
                if (!(ReportListScreen$lambda$1(viewState$delegate).getSearchText().length() > 0) && ReportListScreen$lambda$1(viewState$delegate).getSelectedAdId() == null) {
                    z = false;
                    boolean isAnyFilterActive = z;
                    Modifier modifier$iv = PaddingKt.padding(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), paddingValues3);
                    ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                    Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                    Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
                    MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                    int $changed$iv$iv = (0 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
                    CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
                    Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
                    int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                    PaddingValues paddingValues4 = paddingValues3;
                    ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!($composer3.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer3.startReusableNode();
                    if (!$composer3.getInserting()) {
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
                    ComposerKt.sourceInformationMarkerStart($composer3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                    ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
                    int i4 = ((0 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer3, -1659117391, "C78@3090L183,89@3564L182,100@4039L183,70@2720L96,107@4294L3062,68@2625L4742,184@7377L41:ReportListScreen.kt#ezboep");
                    Integer num = ReportListScreen$lambda$1(viewState$delegate).getStatsCount().get(Status.SUCCESS);
                    int intValue = num == null ? num.intValue() : 0;
                    boolean z2 = ReportListScreen$lambda$1(viewState$delegate).getSelectedStatus() != Status.SUCCESS;
                    ComposerKt.sourceInformationMarkerStart($composer3, 2024699600, "CC(remember):ReportListScreen.kt#9igjgp");
                    invalid$iv = $composer3.changedInstance(viewModel);
                    it$iv = $composer3.rememberedValue();
                    if (!invalid$iv && it$iv != Composer.Companion.getEmpty()) {
                        value$iv = it$iv;
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        StatsPanelCountItem statsPanelCountItem = new StatsPanelCountItem(intValue, "成功", z2, (Function0) value$iv);
                        Integer num2 = ReportListScreen$lambda$1(viewState$delegate).getStatsCount().get(Status.FAILED);
                        int intValue2 = num2 == null ? num2.intValue() : 0;
                        boolean z3 = ReportListScreen$lambda$1(viewState$delegate).getSelectedStatus() != Status.FAILED;
                        ComposerKt.sourceInformationMarkerStart($composer3, 2024714767, "CC(remember):ReportListScreen.kt#9igjgp");
                        invalid$iv2 = $composer3.changedInstance(viewModel);
                        Object it$iv4 = $composer3.rememberedValue();
                        if (invalid$iv2) {
                        }
                        Object value$iv4 = new Function0() { // from class: kntr.app.ad.ui.inspector.ui.main.report.ReportListScreenKt$$ExternalSyntheticLambda8
                            public final Object invoke() {
                                Unit ReportListScreen$lambda$3$1$0;
                                ReportListScreen$lambda$3$1$0 = ReportListScreenKt.ReportListScreen$lambda$3$1$0(ReportListViewModel.this);
                                return ReportListScreen$lambda$3$1$0;
                            }
                        };
                        $composer3.updateRememberedValue(value$iv4);
                        it$iv4 = value$iv4;
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        StatsPanelCountItem statsPanelCountItem2 = new StatsPanelCountItem(intValue2, "失败", z3, (Function0) it$iv4);
                        Integer num3 = ReportListScreen$lambda$1(viewState$delegate).getStatsCount().get(Status.WARNING);
                        int intValue3 = num3 == null ? num3.intValue() : 0;
                        boolean z4 = ReportListScreen$lambda$1(viewState$delegate).getSelectedStatus() != Status.WARNING;
                        ComposerKt.sourceInformationMarkerStart($composer3, 2024729968, "CC(remember):ReportListScreen.kt#9igjgp");
                        invalid$iv3 = $composer3.changedInstance(viewModel);
                        Object it$iv5 = $composer3.rememberedValue();
                        if (invalid$iv3) {
                        }
                        Object value$iv5 = new Function0() { // from class: kntr.app.ad.ui.inspector.ui.main.report.ReportListScreenKt$$ExternalSyntheticLambda9
                            public final Object invoke() {
                                Unit ReportListScreen$lambda$3$2$0;
                                ReportListScreen$lambda$3$2$0 = ReportListScreenKt.ReportListScreen$lambda$3$2$0(ReportListViewModel.this);
                                return ReportListScreen$lambda$3$2$0;
                            }
                        };
                        $composer3.updateRememberedValue(value$iv5);
                        it$iv5 = value$iv5;
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        StatsPanelCountItem statsPanelCountItem3 = new StatsPanelCountItem(intValue3, "告警", z4, (Function0) it$iv5);
                        ComposerKt.sourceInformationMarkerStart($composer3, 2024687673, "CC(remember):ReportListScreen.kt#9igjgp");
                        invalid$iv4 = $composer3.changedInstance(viewModel);
                        Object it$iv6 = $composer3.rememberedValue();
                        if (invalid$iv4) {
                        }
                        Object value$iv6 = new Function0() { // from class: kntr.app.ad.ui.inspector.ui.main.report.ReportListScreenKt$$ExternalSyntheticLambda10
                            public final Object invoke() {
                                Unit ReportListScreen$lambda$3$3$0;
                                ReportListScreen$lambda$3$3$0 = ReportListScreenKt.ReportListScreen$lambda$3$3$0(ReportListViewModel.this);
                                return ReportListScreen$lambda$3$3$0;
                            }
                        };
                        $composer3.updateRememberedValue(value$iv6);
                        it$iv6 = value$iv6;
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        StatsPanelKt.StatsPanel(isAnyFilterActive, (Function0) it$iv6, ComposableLambdaKt.rememberComposableLambda(-963393403, true, new Function2() { // from class: kntr.app.ad.ui.inspector.ui.main.report.ReportListScreenKt$$ExternalSyntheticLambda11
                            public final Object invoke(Object obj, Object obj2) {
                                Unit ReportListScreen$lambda$3$4;
                                ReportListScreen$lambda$3$4 = ReportListScreenKt.ReportListScreen$lambda$3$4(ReportListViewModel.this, viewState$delegate, (Composer) obj, ((Integer) obj2).intValue());
                                return ReportListScreen$lambda$3$4;
                            }
                        }, $composer3, 54), statsPanelCountItem, statsPanelCountItem2, statsPanelCountItem3, $composer3, 384);
                        SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(12)), $composer3, 6);
                        if (!ReportListScreen$lambda$1(viewState$delegate).isLoading()) {
                            $composer3.startReplaceGroup(-1654476444);
                            ComposerKt.sourceInformation($composer3, "189@7506L182");
                            Modifier modifier$iv2 = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
                            Alignment contentAlignment$iv = Alignment.Companion.getCenter();
                            ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                            MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                            int $changed$iv$iv2 = (54 << 3) & 112;
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
                            int i5 = ($changed$iv$iv$iv2 >> 6) & 14;
                            ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                            BoxScope boxScope = BoxScopeInstance.INSTANCE;
                            int i6 = ((54 >> 6) & 112) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer3, 506995216, "C193@7647L27:ReportListScreen.kt#ezboep");
                            ProgressIndicatorKt.CircularProgressIndicator-4lLiAd8((Modifier) null, 0L, 0.0f, 0L, 0, 0.0f, $composer3, 0, 63);
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            $composer3.endNode();
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            $composer3.endReplaceGroup();
                            $composer2 = $composer3;
                            $composer$iv2 = $composer3;
                            $composer$iv$iv = $composer3;
                            $composer$iv = $composer3;
                        } else if (ReportListScreen$lambda$1(viewState$delegate).getFilteredReports().isEmpty()) {
                            $composer3.startReplaceGroup(-1654204791);
                            ComposerKt.sourceInformation($composer3, "196@7759L136");
                            EmptyViewKt.EmptyView("暂无数据", null, isAnyFilterActive ? "请尝试调整筛选条件" : "尝试创建一个新的上报", $composer3, 6, 2);
                            $composer3.endReplaceGroup();
                            $composer2 = $composer3;
                            $composer$iv2 = $composer3;
                            $composer$iv$iv = $composer3;
                            $composer$iv = $composer3;
                        } else {
                            $composer3.startReplaceGroup(-1654037546);
                            ComposerKt.sourceInformation($composer3, "202@7962L182");
                            $composer$iv$iv = $composer3;
                            $composer2 = $composer3;
                            $composer$iv = $composer3;
                            $composer$iv2 = $composer3;
                            ReportListKt.ReportList(ReportListScreen$lambda$1(viewState$delegate).getFilteredReports(), ReportListScreen$lambda$1(viewState$delegate).getSearchText(), function1, null, $composer2, ($dirty2 << 6) & 896, 8);
                            $composer2.endReplaceGroup();
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv);
                        $composer3.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        paddingValues2 = paddingValues4;
                    }
                    value$iv = new Function0() { // from class: kntr.app.ad.ui.inspector.ui.main.report.ReportListScreenKt$$ExternalSyntheticLambda7
                        public final Object invoke() {
                            Unit ReportListScreen$lambda$3$0$0;
                            ReportListScreen$lambda$3$0$0 = ReportListScreenKt.ReportListScreen$lambda$3$0$0(ReportListViewModel.this);
                            return ReportListScreen$lambda$3$0$0;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    StatsPanelCountItem statsPanelCountItem4 = new StatsPanelCountItem(intValue, "成功", z2, (Function0) value$iv);
                    Integer num22 = ReportListScreen$lambda$1(viewState$delegate).getStatsCount().get(Status.FAILED);
                    if (num22 == null) {
                    }
                    if (ReportListScreen$lambda$1(viewState$delegate).getSelectedStatus() != Status.FAILED) {
                    }
                    ComposerKt.sourceInformationMarkerStart($composer3, 2024714767, "CC(remember):ReportListScreen.kt#9igjgp");
                    invalid$iv2 = $composer3.changedInstance(viewModel);
                    Object it$iv42 = $composer3.rememberedValue();
                    if (invalid$iv2) {
                    }
                    Object value$iv42 = new Function0() { // from class: kntr.app.ad.ui.inspector.ui.main.report.ReportListScreenKt$$ExternalSyntheticLambda8
                        public final Object invoke() {
                            Unit ReportListScreen$lambda$3$1$0;
                            ReportListScreen$lambda$3$1$0 = ReportListScreenKt.ReportListScreen$lambda$3$1$0(ReportListViewModel.this);
                            return ReportListScreen$lambda$3$1$0;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv42);
                    it$iv42 = value$iv42;
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    StatsPanelCountItem statsPanelCountItem22 = new StatsPanelCountItem(intValue2, "失败", z3, (Function0) it$iv42);
                    Integer num32 = ReportListScreen$lambda$1(viewState$delegate).getStatsCount().get(Status.WARNING);
                    if (num32 == null) {
                    }
                    if (ReportListScreen$lambda$1(viewState$delegate).getSelectedStatus() != Status.WARNING) {
                    }
                    ComposerKt.sourceInformationMarkerStart($composer3, 2024729968, "CC(remember):ReportListScreen.kt#9igjgp");
                    invalid$iv3 = $composer3.changedInstance(viewModel);
                    Object it$iv52 = $composer3.rememberedValue();
                    if (invalid$iv3) {
                    }
                    Object value$iv52 = new Function0() { // from class: kntr.app.ad.ui.inspector.ui.main.report.ReportListScreenKt$$ExternalSyntheticLambda9
                        public final Object invoke() {
                            Unit ReportListScreen$lambda$3$2$0;
                            ReportListScreen$lambda$3$2$0 = ReportListScreenKt.ReportListScreen$lambda$3$2$0(ReportListViewModel.this);
                            return ReportListScreen$lambda$3$2$0;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv52);
                    it$iv52 = value$iv52;
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    StatsPanelCountItem statsPanelCountItem32 = new StatsPanelCountItem(intValue3, "告警", z4, (Function0) it$iv52);
                    ComposerKt.sourceInformationMarkerStart($composer3, 2024687673, "CC(remember):ReportListScreen.kt#9igjgp");
                    invalid$iv4 = $composer3.changedInstance(viewModel);
                    Object it$iv62 = $composer3.rememberedValue();
                    if (invalid$iv4) {
                    }
                    Object value$iv62 = new Function0() { // from class: kntr.app.ad.ui.inspector.ui.main.report.ReportListScreenKt$$ExternalSyntheticLambda10
                        public final Object invoke() {
                            Unit ReportListScreen$lambda$3$3$0;
                            ReportListScreen$lambda$3$3$0 = ReportListScreenKt.ReportListScreen$lambda$3$3$0(ReportListViewModel.this);
                            return ReportListScreen$lambda$3$3$0;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv62);
                    it$iv62 = value$iv62;
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    StatsPanelKt.StatsPanel(isAnyFilterActive, (Function0) it$iv62, ComposableLambdaKt.rememberComposableLambda(-963393403, true, new Function2() { // from class: kntr.app.ad.ui.inspector.ui.main.report.ReportListScreenKt$$ExternalSyntheticLambda11
                        public final Object invoke(Object obj, Object obj2) {
                            Unit ReportListScreen$lambda$3$4;
                            ReportListScreen$lambda$3$4 = ReportListScreenKt.ReportListScreen$lambda$3$4(ReportListViewModel.this, viewState$delegate, (Composer) obj, ((Integer) obj2).intValue());
                            return ReportListScreen$lambda$3$4;
                        }
                    }, $composer3, 54), statsPanelCountItem4, statsPanelCountItem22, statsPanelCountItem32, $composer3, 384);
                    SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(12)), $composer3, 6);
                    if (!ReportListScreen$lambda$1(viewState$delegate).isLoading()) {
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv);
                    $composer3.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    paddingValues2 = paddingValues4;
                }
            }
            z = true;
            boolean isAnyFilterActive2 = z;
            Modifier modifier$iv3 = PaddingKt.padding(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), paddingValues3);
            ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv2 = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv2 = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv3 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv2, horizontalAlignment$iv2, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv3 = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv3 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer3, modifier$iv3);
            Function0 factory$iv$iv$iv32 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
            PaddingValues paddingValues42 = paddingValues3;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
            }
            $composer3.startReusableNode();
            if (!$composer3.getInserting()) {
            }
            Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
            int i32 = ($changed$iv$iv$iv3 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope2 = ColumnScopeInstance.INSTANCE;
            int i42 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -1659117391, "C78@3090L183,89@3564L182,100@4039L183,70@2720L96,107@4294L3062,68@2625L4742,184@7377L41:ReportListScreen.kt#ezboep");
            Integer num4 = ReportListScreen$lambda$1(viewState$delegate).getStatsCount().get(Status.SUCCESS);
            if (num4 == null) {
            }
            if (ReportListScreen$lambda$1(viewState$delegate).getSelectedStatus() != Status.SUCCESS) {
            }
            ComposerKt.sourceInformationMarkerStart($composer3, 2024699600, "CC(remember):ReportListScreen.kt#9igjgp");
            invalid$iv = $composer3.changedInstance(viewModel);
            it$iv = $composer3.rememberedValue();
            if (!invalid$iv) {
                value$iv = it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                StatsPanelCountItem statsPanelCountItem42 = new StatsPanelCountItem(intValue, "成功", z2, (Function0) value$iv);
                Integer num222 = ReportListScreen$lambda$1(viewState$delegate).getStatsCount().get(Status.FAILED);
                if (num222 == null) {
                }
                if (ReportListScreen$lambda$1(viewState$delegate).getSelectedStatus() != Status.FAILED) {
                }
                ComposerKt.sourceInformationMarkerStart($composer3, 2024714767, "CC(remember):ReportListScreen.kt#9igjgp");
                invalid$iv2 = $composer3.changedInstance(viewModel);
                Object it$iv422 = $composer3.rememberedValue();
                if (invalid$iv2) {
                }
                Object value$iv422 = new Function0() { // from class: kntr.app.ad.ui.inspector.ui.main.report.ReportListScreenKt$$ExternalSyntheticLambda8
                    public final Object invoke() {
                        Unit ReportListScreen$lambda$3$1$0;
                        ReportListScreen$lambda$3$1$0 = ReportListScreenKt.ReportListScreen$lambda$3$1$0(ReportListViewModel.this);
                        return ReportListScreen$lambda$3$1$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv422);
                it$iv422 = value$iv422;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                StatsPanelCountItem statsPanelCountItem222 = new StatsPanelCountItem(intValue2, "失败", z3, (Function0) it$iv422);
                Integer num322 = ReportListScreen$lambda$1(viewState$delegate).getStatsCount().get(Status.WARNING);
                if (num322 == null) {
                }
                if (ReportListScreen$lambda$1(viewState$delegate).getSelectedStatus() != Status.WARNING) {
                }
                ComposerKt.sourceInformationMarkerStart($composer3, 2024729968, "CC(remember):ReportListScreen.kt#9igjgp");
                invalid$iv3 = $composer3.changedInstance(viewModel);
                Object it$iv522 = $composer3.rememberedValue();
                if (invalid$iv3) {
                }
                Object value$iv522 = new Function0() { // from class: kntr.app.ad.ui.inspector.ui.main.report.ReportListScreenKt$$ExternalSyntheticLambda9
                    public final Object invoke() {
                        Unit ReportListScreen$lambda$3$2$0;
                        ReportListScreen$lambda$3$2$0 = ReportListScreenKt.ReportListScreen$lambda$3$2$0(ReportListViewModel.this);
                        return ReportListScreen$lambda$3$2$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv522);
                it$iv522 = value$iv522;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                StatsPanelCountItem statsPanelCountItem322 = new StatsPanelCountItem(intValue3, "告警", z4, (Function0) it$iv522);
                ComposerKt.sourceInformationMarkerStart($composer3, 2024687673, "CC(remember):ReportListScreen.kt#9igjgp");
                invalid$iv4 = $composer3.changedInstance(viewModel);
                Object it$iv622 = $composer3.rememberedValue();
                if (invalid$iv4) {
                }
                Object value$iv622 = new Function0() { // from class: kntr.app.ad.ui.inspector.ui.main.report.ReportListScreenKt$$ExternalSyntheticLambda10
                    public final Object invoke() {
                        Unit ReportListScreen$lambda$3$3$0;
                        ReportListScreen$lambda$3$3$0 = ReportListScreenKt.ReportListScreen$lambda$3$3$0(ReportListViewModel.this);
                        return ReportListScreen$lambda$3$3$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv622);
                it$iv622 = value$iv622;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                StatsPanelKt.StatsPanel(isAnyFilterActive2, (Function0) it$iv622, ComposableLambdaKt.rememberComposableLambda(-963393403, true, new Function2() { // from class: kntr.app.ad.ui.inspector.ui.main.report.ReportListScreenKt$$ExternalSyntheticLambda11
                    public final Object invoke(Object obj, Object obj2) {
                        Unit ReportListScreen$lambda$3$4;
                        ReportListScreen$lambda$3$4 = ReportListScreenKt.ReportListScreen$lambda$3$4(ReportListViewModel.this, viewState$delegate, (Composer) obj, ((Integer) obj2).intValue());
                        return ReportListScreen$lambda$3$4;
                    }
                }, $composer3, 54), statsPanelCountItem42, statsPanelCountItem222, statsPanelCountItem322, $composer3, 384);
                SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(12)), $composer3, 6);
                if (!ReportListScreen$lambda$1(viewState$delegate).isLoading()) {
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                $composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
                ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                if (ComposerKt.isTraceInProgress()) {
                }
                paddingValues2 = paddingValues42;
            }
            value$iv = new Function0() { // from class: kntr.app.ad.ui.inspector.ui.main.report.ReportListScreenKt$$ExternalSyntheticLambda7
                public final Object invoke() {
                    Unit ReportListScreen$lambda$3$0$0;
                    ReportListScreen$lambda$3$0$0 = ReportListScreenKt.ReportListScreen$lambda$3$0$0(ReportListViewModel.this);
                    return ReportListScreen$lambda$3$0$0;
                }
            };
            $composer3.updateRememberedValue(value$iv);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            StatsPanelCountItem statsPanelCountItem422 = new StatsPanelCountItem(intValue, "成功", z2, (Function0) value$iv);
            Integer num2222 = ReportListScreen$lambda$1(viewState$delegate).getStatsCount().get(Status.FAILED);
            if (num2222 == null) {
            }
            if (ReportListScreen$lambda$1(viewState$delegate).getSelectedStatus() != Status.FAILED) {
            }
            ComposerKt.sourceInformationMarkerStart($composer3, 2024714767, "CC(remember):ReportListScreen.kt#9igjgp");
            invalid$iv2 = $composer3.changedInstance(viewModel);
            Object it$iv4222 = $composer3.rememberedValue();
            if (invalid$iv2) {
            }
            Object value$iv4222 = new Function0() { // from class: kntr.app.ad.ui.inspector.ui.main.report.ReportListScreenKt$$ExternalSyntheticLambda8
                public final Object invoke() {
                    Unit ReportListScreen$lambda$3$1$0;
                    ReportListScreen$lambda$3$1$0 = ReportListScreenKt.ReportListScreen$lambda$3$1$0(ReportListViewModel.this);
                    return ReportListScreen$lambda$3$1$0;
                }
            };
            $composer3.updateRememberedValue(value$iv4222);
            it$iv4222 = value$iv4222;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            StatsPanelCountItem statsPanelCountItem2222 = new StatsPanelCountItem(intValue2, "失败", z3, (Function0) it$iv4222);
            Integer num3222 = ReportListScreen$lambda$1(viewState$delegate).getStatsCount().get(Status.WARNING);
            if (num3222 == null) {
            }
            if (ReportListScreen$lambda$1(viewState$delegate).getSelectedStatus() != Status.WARNING) {
            }
            ComposerKt.sourceInformationMarkerStart($composer3, 2024729968, "CC(remember):ReportListScreen.kt#9igjgp");
            invalid$iv3 = $composer3.changedInstance(viewModel);
            Object it$iv5222 = $composer3.rememberedValue();
            if (invalid$iv3) {
            }
            Object value$iv5222 = new Function0() { // from class: kntr.app.ad.ui.inspector.ui.main.report.ReportListScreenKt$$ExternalSyntheticLambda9
                public final Object invoke() {
                    Unit ReportListScreen$lambda$3$2$0;
                    ReportListScreen$lambda$3$2$0 = ReportListScreenKt.ReportListScreen$lambda$3$2$0(ReportListViewModel.this);
                    return ReportListScreen$lambda$3$2$0;
                }
            };
            $composer3.updateRememberedValue(value$iv5222);
            it$iv5222 = value$iv5222;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            StatsPanelCountItem statsPanelCountItem3222 = new StatsPanelCountItem(intValue3, "告警", z4, (Function0) it$iv5222);
            ComposerKt.sourceInformationMarkerStart($composer3, 2024687673, "CC(remember):ReportListScreen.kt#9igjgp");
            invalid$iv4 = $composer3.changedInstance(viewModel);
            Object it$iv6222 = $composer3.rememberedValue();
            if (invalid$iv4) {
            }
            Object value$iv6222 = new Function0() { // from class: kntr.app.ad.ui.inspector.ui.main.report.ReportListScreenKt$$ExternalSyntheticLambda10
                public final Object invoke() {
                    Unit ReportListScreen$lambda$3$3$0;
                    ReportListScreen$lambda$3$3$0 = ReportListScreenKt.ReportListScreen$lambda$3$3$0(ReportListViewModel.this);
                    return ReportListScreen$lambda$3$3$0;
                }
            };
            $composer3.updateRememberedValue(value$iv6222);
            it$iv6222 = value$iv6222;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            StatsPanelKt.StatsPanel(isAnyFilterActive2, (Function0) it$iv6222, ComposableLambdaKt.rememberComposableLambda(-963393403, true, new Function2() { // from class: kntr.app.ad.ui.inspector.ui.main.report.ReportListScreenKt$$ExternalSyntheticLambda11
                public final Object invoke(Object obj, Object obj2) {
                    Unit ReportListScreen$lambda$3$4;
                    ReportListScreen$lambda$3$4 = ReportListScreenKt.ReportListScreen$lambda$3$4(ReportListViewModel.this, viewState$delegate, (Composer) obj, ((Integer) obj2).intValue());
                    return ReportListScreen$lambda$3$4;
                }
            }, $composer3, 54), statsPanelCountItem422, statsPanelCountItem2222, statsPanelCountItem3222, $composer3, 384);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(12)), $composer3, 6);
            if (!ReportListScreen$lambda$1(viewState$delegate).isLoading()) {
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv2);
            if (ComposerKt.isTraceInProgress()) {
            }
            paddingValues2 = paddingValues42;
        }
        ScopeUpdateScope endRestartGroup = $composer3.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.ad.ui.inspector.ui.main.report.ReportListScreenKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit ReportListScreen$lambda$4;
                    ReportListScreen$lambda$4 = ReportListScreenKt.ReportListScreen$lambda$4(function1, paddingValues2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return ReportListScreen$lambda$4;
                }
            });
        }
    }

    private static final ReportListViewModel.ViewState ReportListScreen$lambda$1(State<ReportListViewModel.ViewState> state) {
        Object thisObj$iv = state.getValue();
        return (ReportListViewModel.ViewState) thisObj$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult ReportListScreen$lambda$2$0(final ReportListViewModel $viewModel, DisposableEffectScope $this$DisposableEffect) {
        Intrinsics.checkNotNullParameter($this$DisposableEffect, "$this$DisposableEffect");
        return new DisposableEffectResult() { // from class: kntr.app.ad.ui.inspector.ui.main.report.ReportListScreenKt$ReportListScreen$lambda$2$0$$inlined$onDispose$1
            public void dispose() {
                ReportListViewModel.this.onCleared();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ReportListScreen$lambda$3$3$0(ReportListViewModel $viewModel) {
        $viewModel.processIntent(ReportListViewModel.Intent.ClearFilters.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ReportListScreen$lambda$3$0$0(ReportListViewModel $viewModel) {
        $viewModel.processIntent(new ReportListViewModel.Intent.SelectStatus(Status.SUCCESS));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ReportListScreen$lambda$3$1$0(ReportListViewModel $viewModel) {
        $viewModel.processIntent(new ReportListViewModel.Intent.SelectStatus(Status.FAILED));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ReportListScreen$lambda$3$2$0(ReportListViewModel $viewModel) {
        $viewModel.processIntent(new ReportListViewModel.Intent.SelectStatus(Status.WARNING));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ReportListScreen$lambda$3$4(final ReportListViewModel $viewModel, final State $viewState$delegate, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C110@4393L10,108@4312L204,114@4534L40,118@4697L110,116@4592L336,125@4946L41,130@5114L10,128@5031L206,134@5255L40,141@5575L1767,137@5350L1992:ReportListScreen.kt#ezboep");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-963393403, $changed, -1, "kntr.app.ad.ui.inspector.ui.main.report.ReportListScreen.<anonymous>.<anonymous> (ReportListScreen.kt:108)");
            }
            TextKt.Text-Nvy7gAk("搜索", (Modifier) null, ColorKt.Color(4285231744L), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, TextStyle.copy-p1EtxEg$default(MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getBodySmall(), 0L, 0L, FontWeight.Companion.getMedium(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777211, (Object) null), $composer, 390, 0, 131066);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(8)), $composer, 6);
            String searchText = ReportListScreen$lambda$1($viewState$delegate).getSearchText();
            ComposerKt.sourceInformationMarkerStart($composer, 1891888659, "CC(remember):ReportListScreen.kt#9igjgp");
            boolean invalid$iv = $composer.changedInstance($viewModel);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function1() { // from class: kntr.app.ad.ui.inspector.ui.main.report.ReportListScreenKt$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj) {
                        Unit ReportListScreen$lambda$3$4$0$0;
                        ReportListScreen$lambda$3$4$0$0 = ReportListScreenKt.ReportListScreen$lambda$3$4$0$0(ReportListViewModel.this, (String) obj);
                        return ReportListScreen$lambda$3$4$0$0;
                    }
                };
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            StatsPanelKt.ModernSearchField(searchText, (Function1) it$iv, "搜索上报名称、事件或URL", AppIcons.INSTANCE.getSearch(), $composer, 3456);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16)), $composer, 6);
            TextKt.Text-Nvy7gAk("上报类型", (Modifier) null, ColorKt.Color(4285231744L), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, TextStyle.copy-p1EtxEg$default(MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getBodySmall(), 0L, 0L, FontWeight.Companion.getMedium(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777211, (Object) null), $composer, 390, 0, 131066);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(8)), $composer, 6);
            FlowLayoutKt.FlowRow(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(8)), Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(8)), (Alignment.Vertical) null, 0, 0, ComposableLambdaKt.rememberComposableLambda(1412344000, true, new Function3() { // from class: kntr.app.ad.ui.inspector.ui.main.report.ReportListScreenKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit ReportListScreen$lambda$3$4$1;
                    ReportListScreen$lambda$3$4$1 = ReportListScreenKt.ReportListScreen$lambda$3$4$1(ReportListViewModel.this, $viewState$delegate, (FlowRowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return ReportListScreen$lambda$3$4$1;
                }
            }, $composer, 54), $composer, 1573302, 56);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ReportListScreen$lambda$3$4$0$0(ReportListViewModel $viewModel, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        $viewModel.processIntent(new ReportListViewModel.Intent.Search(it));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ReportListScreen$lambda$3$4$1(final ReportListViewModel $viewModel, final State $viewState$delegate, FlowRowScope $this$FlowRow, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$FlowRow, "$this$FlowRow");
        ComposerKt.sourceInformation($composer, "C146@5800L336,143@5625L534,159@6383L334,156@6209L531,172@6965L336,169@6790L534:ReportListScreen.kt#ezboep");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1412344000, $changed, -1, "kntr.app.ad.ui.inspector.ui.main.report.ReportListScreen.<anonymous>.<anonymous>.<anonymous> (ReportListScreen.kt:143)");
            }
            boolean z = ReportListScreen$lambda$1($viewState$delegate).getSelectedReportType() == ReportType.FEE;
            ComposerKt.sourceInformationMarkerStart($composer, 52926000, "CC(remember):ReportListScreen.kt#9igjgp");
            boolean invalid$iv = $composer.changedInstance($viewModel) | $composer.changed($viewState$delegate);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function0() { // from class: kntr.app.ad.ui.inspector.ui.main.report.ReportListScreenKt$$ExternalSyntheticLambda3
                    public final Object invoke() {
                        Unit ReportListScreen$lambda$3$4$1$0$0;
                        ReportListScreen$lambda$3$4$1$0$0 = ReportListScreenKt.ReportListScreen$lambda$3$4$1$0$0(ReportListViewModel.this, $viewState$delegate);
                        return ReportListScreen$lambda$3$4$1$0$0;
                    }
                };
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            StatsPanelKt.CommonFilterItem("计费上报", z, (Function0) it$iv, $composer, 6);
            boolean z2 = ReportListScreen$lambda$1($viewState$delegate).getSelectedReportType() == ReportType.UI;
            ComposerKt.sourceInformationMarkerStart($composer, 52944654, "CC(remember):ReportListScreen.kt#9igjgp");
            boolean invalid$iv2 = $composer.changedInstance($viewModel) | $composer.changed($viewState$delegate);
            Object it$iv2 = $composer.rememberedValue();
            if (invalid$iv2 || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = new Function0() { // from class: kntr.app.ad.ui.inspector.ui.main.report.ReportListScreenKt$$ExternalSyntheticLambda4
                    public final Object invoke() {
                        Unit ReportListScreen$lambda$3$4$1$1$0;
                        ReportListScreen$lambda$3$4$1$1$0 = ReportListScreenKt.ReportListScreen$lambda$3$4$1$1$0(ReportListViewModel.this, $viewState$delegate);
                        return ReportListScreen$lambda$3$4$1$1$0;
                    }
                };
                $composer.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            StatsPanelKt.CommonFilterItem("UI上报", z2, (Function0) it$iv2, $composer, 6);
            boolean z3 = ReportListScreen$lambda$1($viewState$delegate).getSelectedReportType() == ReportType.MMA;
            ComposerKt.sourceInformationMarkerStart($composer, 52963280, "CC(remember):ReportListScreen.kt#9igjgp");
            boolean invalid$iv3 = $composer.changedInstance($viewModel) | $composer.changed($viewState$delegate);
            Object it$iv3 = $composer.rememberedValue();
            if (invalid$iv3 || it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv3 = new Function0() { // from class: kntr.app.ad.ui.inspector.ui.main.report.ReportListScreenKt$$ExternalSyntheticLambda5
                    public final Object invoke() {
                        Unit ReportListScreen$lambda$3$4$1$2$0;
                        ReportListScreen$lambda$3$4$1$2$0 = ReportListScreenKt.ReportListScreen$lambda$3$4$1$2$0(ReportListViewModel.this, $viewState$delegate);
                        return ReportListScreen$lambda$3$4$1$2$0;
                    }
                };
                $composer.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            StatsPanelKt.CommonFilterItem("三方上报", z3, (Function0) it$iv3, $composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ReportListScreen$lambda$3$4$1$0$0(ReportListViewModel $viewModel, State $viewState$delegate) {
        $viewModel.processIntent(new ReportListViewModel.Intent.SelectReportType(ReportListScreen$lambda$1($viewState$delegate).getSelectedReportType() == ReportType.FEE ? null : ReportType.FEE));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ReportListScreen$lambda$3$4$1$1$0(ReportListViewModel $viewModel, State $viewState$delegate) {
        $viewModel.processIntent(new ReportListViewModel.Intent.SelectReportType(ReportListScreen$lambda$1($viewState$delegate).getSelectedReportType() == ReportType.UI ? null : ReportType.UI));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ReportListScreen$lambda$3$4$1$2$0(ReportListViewModel $viewModel, State $viewState$delegate) {
        $viewModel.processIntent(new ReportListViewModel.Intent.SelectReportType(ReportListScreen$lambda$1($viewState$delegate).getSelectedReportType() == ReportType.MMA ? null : ReportType.MMA));
        return Unit.INSTANCE;
    }
}