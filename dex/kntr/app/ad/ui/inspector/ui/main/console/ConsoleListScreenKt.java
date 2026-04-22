package kntr.app.ad.ui.inspector.ui.main.console;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
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
import androidx.compose.ui.unit.TextUnitKt;
import java.util.List;
import kntr.app.ad.domain.inspector.core.util.DateTimeUtils;
import kntr.app.ad.domain.inspector.core.work.PrintJobData;
import kntr.app.ad.domain.inspector.core.work.PrintType;
import kntr.app.ad.ui.inspector.ui.components.AppIcons;
import kntr.app.ad.ui.inspector.ui.components.EmptyViewKt;
import kntr.app.ad.ui.inspector.ui.components.StatsPanelCountItem;
import kntr.app.ad.ui.inspector.ui.components.StatsPanelKt;
import kntr.app.ad.ui.inspector.ui.main.console.viewmodel.ConsoleListViewModel;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: ConsoleListScreen.kt */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\u001a\u0017\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u0001¢\u0006\u0002\u0010\u0004\u001a)\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\tH\u0003¢\u0006\u0002\u0010\u000b\u001a\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002¨\u0006\u0010²\u0006\n\u0010\u0011\u001a\u00020\u0012X\u008a\u0084\u0002"}, d2 = {"ConsoleListScreen", RoomRecommendViewModel.EMPTY_CURSOR, "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "(Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;II)V", "PrintJobCard", "printJobData", "Lkntr/app/ad/domain/inspector/core/work/PrintJobData;", "highlightTag", RoomRecommendViewModel.EMPTY_CURSOR, "highlightMessage", "(Lkntr/app/ad/domain/inspector/core/work/PrintJobData;ZZLandroidx/compose/runtime/Composer;II)V", "formatTimestamp", RoomRecommendViewModel.EMPTY_CURSOR, "timestamp", RoomRecommendViewModel.EMPTY_CURSOR, "ad-inspector_debug", "viewState", "Lkntr/app/ad/ui/inspector/ui/main/console/viewmodel/ConsoleListViewModel$ViewState;"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ConsoleListScreenKt {

    /* compiled from: ConsoleListScreen.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PrintType.values().length];
            try {
                iArr[PrintType.INFO.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[PrintType.WARNING.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[PrintType.ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConsoleListScreen$lambda$4(PaddingValues paddingValues, int i, int i2, Composer composer, int i3) {
        ConsoleListScreen(paddingValues, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PrintJobCard$lambda$1(PrintJobData printJobData, boolean z, boolean z2, int i, int i2, Composer composer, int i3) {
        PrintJobCard(printJobData, z, z2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:104:0x0365, code lost:
        if (r14 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x02bb, code lost:
        if (r12 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0328, code lost:
        if (r14 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L66;
     */
    /* JADX WARN: Removed duplicated region for block: B:103:0x035d  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0369  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x03d7  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0519  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x05d3  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x021e  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0281  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0286  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0294  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0296  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x02b3  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x02bf  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x02ee  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x02f3  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0301  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0303  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0320  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x032c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void ConsoleListScreen(PaddingValues paddingValues, Composer $composer, final int $changed, final int i) {
        final PaddingValues paddingValues2;
        Composer $composer2;
        boolean isAnyFilterActive;
        Function0 factory$iv$iv$iv;
        boolean invalid$iv;
        Object it$iv;
        Object value$iv;
        boolean invalid$iv2;
        boolean invalid$iv3;
        boolean invalid$iv4;
        Composer $composer$iv$iv;
        Function0 factory$iv$iv$iv2;
        Composer $composer3 = $composer.startRestartGroup(1086331893);
        ComposerKt.sourceInformation($composer3, "C(ConsoleListScreen)N(paddingValues)50@2306L35,52@2402L16,55@2490L93,55@2462L121,65@2712L4278:ConsoleListScreen.kt#ufje4c");
        int $dirty = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty |= 6;
            paddingValues2 = paddingValues;
        } else if (($changed & 6) == 0) {
            paddingValues2 = paddingValues;
            $dirty |= $composer3.changed(paddingValues2) ? 4 : 2;
        } else {
            paddingValues2 = paddingValues;
        }
        if ($composer3.shouldExecute(($dirty & 3) != 2, $dirty & 1)) {
            PaddingValues paddingValues3 = i2 != 0 ? PaddingKt.PaddingValues-0680j_4(Dp.constructor-impl(0)) : paddingValues2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1086331893, $dirty, -1, "kntr.app.ad.ui.inspector.ui.main.console.ConsoleListScreen (ConsoleListScreen.kt:49)");
            }
            ComposerKt.sourceInformationMarkerStart($composer3, 287899352, "CC(remember):ConsoleListScreen.kt#9igjgp");
            Object it$iv2 = $composer3.rememberedValue();
            if (it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = new ConsoleListViewModel();
                $composer3.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            final ConsoleListViewModel viewModel = (ConsoleListViewModel) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            final State viewState$delegate = SnapshotStateKt.collectAsState(viewModel.getState(), (CoroutineContext) null, $composer3, 0, 1);
            ComposerKt.sourceInformationMarkerStart($composer3, 287905298, "CC(remember):ConsoleListScreen.kt#9igjgp");
            boolean invalid$iv5 = $composer3.changedInstance(viewModel);
            Object it$iv3 = $composer3.rememberedValue();
            if (invalid$iv5 || it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv3 = new Function1() { // from class: kntr.app.ad.ui.inspector.ui.main.console.ConsoleListScreenKt$$ExternalSyntheticLambda9
                    public final Object invoke(Object obj) {
                        DisposableEffectResult ConsoleListScreen$lambda$2$0;
                        ConsoleListScreen$lambda$2$0 = ConsoleListScreenKt.ConsoleListScreen$lambda$2$0(ConsoleListViewModel.this, (DisposableEffectScope) obj);
                        return ConsoleListScreen$lambda$2$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            EffectsKt.DisposableEffect(viewModel, (Function1) it$iv3, $composer3, 0);
            if (ConsoleListScreen$lambda$1(viewState$delegate).getSelectedPrintType() == null) {
                if (!(ConsoleListScreen$lambda$1(viewState$delegate).getSearchText().length() > 0)) {
                    isAnyFilterActive = false;
                    Modifier modifier$iv = PaddingKt.padding(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), paddingValues3);
                    ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                    Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                    Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
                    MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                    int $changed$iv$iv = (0 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
                    CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
                    PaddingValues paddingValues4 = paddingValues3;
                    Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
                    Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
                    int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
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
                    $composer2 = $composer3;
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
                    int i3 = ($changed$iv$iv$iv >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                    ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
                    int i4 = ((0 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer3, -1454196378, "C82@3341L311,95@3953L313,108@4573L317,74@2965L97,117@4973L682,72@2870L2796,138@5676L41:ConsoleListScreen.kt#ufje4c");
                    Integer num = ConsoleListScreen$lambda$1(viewState$delegate).getTypesCount().get(PrintType.INFO);
                    int intValue = num == null ? num.intValue() : 0;
                    boolean z = ConsoleListScreen$lambda$1(viewState$delegate).getSelectedPrintType() != PrintType.INFO;
                    ComposerKt.sourceInformationMarkerStart($composer3, 1754217026, "CC(remember):ConsoleListScreen.kt#9igjgp");
                    invalid$iv = $composer3.changedInstance(viewModel) | $composer3.changed(viewState$delegate);
                    it$iv = $composer3.rememberedValue();
                    if (!invalid$iv && it$iv != Composer.Companion.getEmpty()) {
                        value$iv = it$iv;
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        StatsPanelCountItem statsPanelCountItem = new StatsPanelCountItem(intValue, "INFO", z, (Function0) value$iv);
                        Integer num2 = ConsoleListScreen$lambda$1(viewState$delegate).getTypesCount().get(PrintType.ERROR);
                        int intValue2 = num2 == null ? num2.intValue() : 0;
                        boolean z2 = ConsoleListScreen$lambda$1(viewState$delegate).getSelectedPrintType() != PrintType.ERROR;
                        ComposerKt.sourceInformationMarkerStart($composer3, 1754236612, "CC(remember):ConsoleListScreen.kt#9igjgp");
                        invalid$iv2 = $composer3.changedInstance(viewModel) | $composer3.changed(viewState$delegate);
                        Object it$iv4 = $composer3.rememberedValue();
                        if (invalid$iv2) {
                        }
                        Object value$iv4 = new Function0() { // from class: kntr.app.ad.ui.inspector.ui.main.console.ConsoleListScreenKt$$ExternalSyntheticLambda11
                            public final Object invoke() {
                                Unit ConsoleListScreen$lambda$3$1$0;
                                ConsoleListScreen$lambda$3$1$0 = ConsoleListScreenKt.ConsoleListScreen$lambda$3$1$0(ConsoleListViewModel.this, viewState$delegate);
                                return ConsoleListScreen$lambda$3$1$0;
                            }
                        };
                        $composer3.updateRememberedValue(value$iv4);
                        it$iv4 = value$iv4;
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        StatsPanelCountItem statsPanelCountItem2 = new StatsPanelCountItem(intValue2, "ERROR", z2, (Function0) it$iv4);
                        Integer num3 = ConsoleListScreen$lambda$1(viewState$delegate).getTypesCount().get(PrintType.WARNING);
                        int intValue3 = num3 == null ? num3.intValue() : 0;
                        boolean z3 = ConsoleListScreen$lambda$1(viewState$delegate).getSelectedPrintType() != PrintType.WARNING;
                        ComposerKt.sourceInformationMarkerStart($composer3, 1754256456, "CC(remember):ConsoleListScreen.kt#9igjgp");
                        invalid$iv3 = $composer3.changedInstance(viewModel) | $composer3.changed(viewState$delegate);
                        Object it$iv5 = $composer3.rememberedValue();
                        if (invalid$iv3) {
                        }
                        Object value$iv5 = new Function0() { // from class: kntr.app.ad.ui.inspector.ui.main.console.ConsoleListScreenKt$$ExternalSyntheticLambda12
                            public final Object invoke() {
                                Unit ConsoleListScreen$lambda$3$2$0;
                                ConsoleListScreen$lambda$3$2$0 = ConsoleListScreenKt.ConsoleListScreen$lambda$3$2$0(ConsoleListViewModel.this, viewState$delegate);
                                return ConsoleListScreen$lambda$3$2$0;
                            }
                        };
                        $composer3.updateRememberedValue(value$iv5);
                        it$iv5 = value$iv5;
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        StatsPanelCountItem statsPanelCountItem3 = new StatsPanelCountItem(intValue3, "WARNING", z3, (Function0) it$iv5);
                        ComposerKt.sourceInformationMarkerStart($composer3, 1754204780, "CC(remember):ConsoleListScreen.kt#9igjgp");
                        invalid$iv4 = $composer3.changedInstance(viewModel);
                        Object it$iv6 = $composer3.rememberedValue();
                        if (invalid$iv4) {
                        }
                        Object value$iv6 = new Function0() { // from class: kntr.app.ad.ui.inspector.ui.main.console.ConsoleListScreenKt$$ExternalSyntheticLambda0
                            public final Object invoke() {
                                Unit ConsoleListScreen$lambda$3$3$0;
                                ConsoleListScreen$lambda$3$3$0 = ConsoleListScreenKt.ConsoleListScreen$lambda$3$3$0(ConsoleListViewModel.this);
                                return ConsoleListScreen$lambda$3$3$0;
                            }
                        };
                        $composer3.updateRememberedValue(value$iv6);
                        it$iv6 = value$iv6;
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        StatsPanelKt.StatsPanel(isAnyFilterActive, (Function0) it$iv6, ComposableLambdaKt.rememberComposableLambda(2113200159, true, new Function2() { // from class: kntr.app.ad.ui.inspector.ui.main.console.ConsoleListScreenKt$$ExternalSyntheticLambda1
                            public final Object invoke(Object obj, Object obj2) {
                                Unit ConsoleListScreen$lambda$3$4;
                                ConsoleListScreen$lambda$3$4 = ConsoleListScreenKt.ConsoleListScreen$lambda$3$4(ConsoleListViewModel.this, viewState$delegate, (Composer) obj, ((Integer) obj2).intValue());
                                return ConsoleListScreen$lambda$3$4;
                            }
                        }, $composer3, 54), statsPanelCountItem, statsPanelCountItem2, statsPanelCountItem3, $composer3, 384);
                        SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(12)), $composer3, 6);
                        if (ConsoleListScreen$lambda$1(viewState$delegate).isLoading()) {
                            $composer$iv$iv = $composer3;
                            if (ConsoleListScreen$lambda$1(viewState$delegate).getFilteredPrintJobs().isEmpty()) {
                                $composer3.startReplaceGroup(-1451165726);
                                ComposerKt.sourceInformation($composer3, "151@6083L136");
                                EmptyViewKt.EmptyView("暂无数据", null, isAnyFilterActive ? "请尝试调整筛选条件" : "尝试创建一个新的日志", $composer3, 6, 2);
                                $composer3.endReplaceGroup();
                            } else {
                                $composer3.startReplaceGroup(-1450962614);
                                ComposerKt.sourceInformation($composer3, "159@6350L624,157@6273L701");
                                Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
                                ComposerKt.sourceInformationMarkerStart($composer3, 1754313627, "CC(remember):ConsoleListScreen.kt#9igjgp");
                                boolean invalid$iv6 = $composer3.changed(viewState$delegate);
                                Object it$iv7 = $composer3.rememberedValue();
                                if (invalid$iv6 || it$iv7 == Composer.Companion.getEmpty()) {
                                    Object value$iv7 = new Function1() { // from class: kntr.app.ad.ui.inspector.ui.main.console.ConsoleListScreenKt$$ExternalSyntheticLambda2
                                        public final Object invoke(Object obj) {
                                            Unit ConsoleListScreen$lambda$3$6$0;
                                            ConsoleListScreen$lambda$3$6$0 = ConsoleListScreenKt.ConsoleListScreen$lambda$3$6$0(viewState$delegate, (LazyListScope) obj);
                                            return ConsoleListScreen$lambda$3$6$0;
                                        }
                                    };
                                    $composer3.updateRememberedValue(value$iv7);
                                    it$iv7 = value$iv7;
                                }
                                ComposerKt.sourceInformationMarkerEnd($composer3);
                                LazyDslKt.LazyColumn(fillMaxSize$default, (LazyListState) null, (PaddingValues) null, false, (Arrangement.Vertical) null, (Alignment.Horizontal) null, (FlingBehavior) null, false, (OverscrollEffect) null, (Function1) it$iv7, $composer3, 6, 510);
                                $composer3.endReplaceGroup();
                            }
                        } else {
                            $composer3.startReplaceGroup(-1451440014);
                            ComposerKt.sourceInformation($composer3, "143@5807L182");
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
                            $composer$iv$iv = $composer3;
                            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
                            int i5 = ($changed$iv$iv$iv2 >> 6) & 14;
                            ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                            BoxScope boxScope = BoxScopeInstance.INSTANCE;
                            int i6 = ((54 >> 6) & 112) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer3, -517640836, "C147@5948L27:ConsoleListScreen.kt#ufje4c");
                            ProgressIndicatorKt.CircularProgressIndicator-4lLiAd8((Modifier) null, 0L, 0.0f, 0L, 0, 0.0f, $composer3, 0, 63);
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            $composer3.endNode();
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            $composer3.endReplaceGroup();
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        $composer3.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        paddingValues2 = paddingValues4;
                    }
                    value$iv = new Function0() { // from class: kntr.app.ad.ui.inspector.ui.main.console.ConsoleListScreenKt$$ExternalSyntheticLambda10
                        public final Object invoke() {
                            Unit ConsoleListScreen$lambda$3$0$0;
                            ConsoleListScreen$lambda$3$0$0 = ConsoleListScreenKt.ConsoleListScreen$lambda$3$0$0(ConsoleListViewModel.this, viewState$delegate);
                            return ConsoleListScreen$lambda$3$0$0;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    StatsPanelCountItem statsPanelCountItem4 = new StatsPanelCountItem(intValue, "INFO", z, (Function0) value$iv);
                    Integer num22 = ConsoleListScreen$lambda$1(viewState$delegate).getTypesCount().get(PrintType.ERROR);
                    if (num22 == null) {
                    }
                    if (ConsoleListScreen$lambda$1(viewState$delegate).getSelectedPrintType() != PrintType.ERROR) {
                    }
                    ComposerKt.sourceInformationMarkerStart($composer3, 1754236612, "CC(remember):ConsoleListScreen.kt#9igjgp");
                    invalid$iv2 = $composer3.changedInstance(viewModel) | $composer3.changed(viewState$delegate);
                    Object it$iv42 = $composer3.rememberedValue();
                    if (invalid$iv2) {
                    }
                    Object value$iv42 = new Function0() { // from class: kntr.app.ad.ui.inspector.ui.main.console.ConsoleListScreenKt$$ExternalSyntheticLambda11
                        public final Object invoke() {
                            Unit ConsoleListScreen$lambda$3$1$0;
                            ConsoleListScreen$lambda$3$1$0 = ConsoleListScreenKt.ConsoleListScreen$lambda$3$1$0(ConsoleListViewModel.this, viewState$delegate);
                            return ConsoleListScreen$lambda$3$1$0;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv42);
                    it$iv42 = value$iv42;
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    StatsPanelCountItem statsPanelCountItem22 = new StatsPanelCountItem(intValue2, "ERROR", z2, (Function0) it$iv42);
                    Integer num32 = ConsoleListScreen$lambda$1(viewState$delegate).getTypesCount().get(PrintType.WARNING);
                    if (num32 == null) {
                    }
                    if (ConsoleListScreen$lambda$1(viewState$delegate).getSelectedPrintType() != PrintType.WARNING) {
                    }
                    ComposerKt.sourceInformationMarkerStart($composer3, 1754256456, "CC(remember):ConsoleListScreen.kt#9igjgp");
                    invalid$iv3 = $composer3.changedInstance(viewModel) | $composer3.changed(viewState$delegate);
                    Object it$iv52 = $composer3.rememberedValue();
                    if (invalid$iv3) {
                    }
                    Object value$iv52 = new Function0() { // from class: kntr.app.ad.ui.inspector.ui.main.console.ConsoleListScreenKt$$ExternalSyntheticLambda12
                        public final Object invoke() {
                            Unit ConsoleListScreen$lambda$3$2$0;
                            ConsoleListScreen$lambda$3$2$0 = ConsoleListScreenKt.ConsoleListScreen$lambda$3$2$0(ConsoleListViewModel.this, viewState$delegate);
                            return ConsoleListScreen$lambda$3$2$0;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv52);
                    it$iv52 = value$iv52;
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    StatsPanelCountItem statsPanelCountItem32 = new StatsPanelCountItem(intValue3, "WARNING", z3, (Function0) it$iv52);
                    ComposerKt.sourceInformationMarkerStart($composer3, 1754204780, "CC(remember):ConsoleListScreen.kt#9igjgp");
                    invalid$iv4 = $composer3.changedInstance(viewModel);
                    Object it$iv62 = $composer3.rememberedValue();
                    if (invalid$iv4) {
                    }
                    Object value$iv62 = new Function0() { // from class: kntr.app.ad.ui.inspector.ui.main.console.ConsoleListScreenKt$$ExternalSyntheticLambda0
                        public final Object invoke() {
                            Unit ConsoleListScreen$lambda$3$3$0;
                            ConsoleListScreen$lambda$3$3$0 = ConsoleListScreenKt.ConsoleListScreen$lambda$3$3$0(ConsoleListViewModel.this);
                            return ConsoleListScreen$lambda$3$3$0;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv62);
                    it$iv62 = value$iv62;
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    StatsPanelKt.StatsPanel(isAnyFilterActive, (Function0) it$iv62, ComposableLambdaKt.rememberComposableLambda(2113200159, true, new Function2() { // from class: kntr.app.ad.ui.inspector.ui.main.console.ConsoleListScreenKt$$ExternalSyntheticLambda1
                        public final Object invoke(Object obj, Object obj2) {
                            Unit ConsoleListScreen$lambda$3$4;
                            ConsoleListScreen$lambda$3$4 = ConsoleListScreenKt.ConsoleListScreen$lambda$3$4(ConsoleListViewModel.this, viewState$delegate, (Composer) obj, ((Integer) obj2).intValue());
                            return ConsoleListScreen$lambda$3$4;
                        }
                    }, $composer3, 54), statsPanelCountItem4, statsPanelCountItem22, statsPanelCountItem32, $composer3, 384);
                    SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(12)), $composer3, 6);
                    if (ConsoleListScreen$lambda$1(viewState$delegate).isLoading()) {
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    $composer3.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    paddingValues2 = paddingValues4;
                }
            }
            isAnyFilterActive = true;
            Modifier modifier$iv3 = PaddingKt.padding(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), paddingValues3);
            ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv2 = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv2 = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv3 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv2, horizontalAlignment$iv2, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv3 = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv3 = $composer3.getCurrentCompositionLocalMap();
            PaddingValues paddingValues42 = paddingValues3;
            Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer3, modifier$iv3);
            Function0 factory$iv$iv$iv32 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
            }
            $composer3.startReusableNode();
            if (!$composer3.getInserting()) {
            }
            Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer3);
            $composer2 = $composer3;
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
            int i32 = ($changed$iv$iv$iv3 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope2 = ColumnScopeInstance.INSTANCE;
            int i42 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -1454196378, "C82@3341L311,95@3953L313,108@4573L317,74@2965L97,117@4973L682,72@2870L2796,138@5676L41:ConsoleListScreen.kt#ufje4c");
            Integer num4 = ConsoleListScreen$lambda$1(viewState$delegate).getTypesCount().get(PrintType.INFO);
            if (num4 == null) {
            }
            if (ConsoleListScreen$lambda$1(viewState$delegate).getSelectedPrintType() != PrintType.INFO) {
            }
            ComposerKt.sourceInformationMarkerStart($composer3, 1754217026, "CC(remember):ConsoleListScreen.kt#9igjgp");
            invalid$iv = $composer3.changedInstance(viewModel) | $composer3.changed(viewState$delegate);
            it$iv = $composer3.rememberedValue();
            if (!invalid$iv) {
                value$iv = it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                StatsPanelCountItem statsPanelCountItem42 = new StatsPanelCountItem(intValue, "INFO", z, (Function0) value$iv);
                Integer num222 = ConsoleListScreen$lambda$1(viewState$delegate).getTypesCount().get(PrintType.ERROR);
                if (num222 == null) {
                }
                if (ConsoleListScreen$lambda$1(viewState$delegate).getSelectedPrintType() != PrintType.ERROR) {
                }
                ComposerKt.sourceInformationMarkerStart($composer3, 1754236612, "CC(remember):ConsoleListScreen.kt#9igjgp");
                invalid$iv2 = $composer3.changedInstance(viewModel) | $composer3.changed(viewState$delegate);
                Object it$iv422 = $composer3.rememberedValue();
                if (invalid$iv2) {
                }
                Object value$iv422 = new Function0() { // from class: kntr.app.ad.ui.inspector.ui.main.console.ConsoleListScreenKt$$ExternalSyntheticLambda11
                    public final Object invoke() {
                        Unit ConsoleListScreen$lambda$3$1$0;
                        ConsoleListScreen$lambda$3$1$0 = ConsoleListScreenKt.ConsoleListScreen$lambda$3$1$0(ConsoleListViewModel.this, viewState$delegate);
                        return ConsoleListScreen$lambda$3$1$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv422);
                it$iv422 = value$iv422;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                StatsPanelCountItem statsPanelCountItem222 = new StatsPanelCountItem(intValue2, "ERROR", z2, (Function0) it$iv422);
                Integer num322 = ConsoleListScreen$lambda$1(viewState$delegate).getTypesCount().get(PrintType.WARNING);
                if (num322 == null) {
                }
                if (ConsoleListScreen$lambda$1(viewState$delegate).getSelectedPrintType() != PrintType.WARNING) {
                }
                ComposerKt.sourceInformationMarkerStart($composer3, 1754256456, "CC(remember):ConsoleListScreen.kt#9igjgp");
                invalid$iv3 = $composer3.changedInstance(viewModel) | $composer3.changed(viewState$delegate);
                Object it$iv522 = $composer3.rememberedValue();
                if (invalid$iv3) {
                }
                Object value$iv522 = new Function0() { // from class: kntr.app.ad.ui.inspector.ui.main.console.ConsoleListScreenKt$$ExternalSyntheticLambda12
                    public final Object invoke() {
                        Unit ConsoleListScreen$lambda$3$2$0;
                        ConsoleListScreen$lambda$3$2$0 = ConsoleListScreenKt.ConsoleListScreen$lambda$3$2$0(ConsoleListViewModel.this, viewState$delegate);
                        return ConsoleListScreen$lambda$3$2$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv522);
                it$iv522 = value$iv522;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                StatsPanelCountItem statsPanelCountItem322 = new StatsPanelCountItem(intValue3, "WARNING", z3, (Function0) it$iv522);
                ComposerKt.sourceInformationMarkerStart($composer3, 1754204780, "CC(remember):ConsoleListScreen.kt#9igjgp");
                invalid$iv4 = $composer3.changedInstance(viewModel);
                Object it$iv622 = $composer3.rememberedValue();
                if (invalid$iv4) {
                }
                Object value$iv622 = new Function0() { // from class: kntr.app.ad.ui.inspector.ui.main.console.ConsoleListScreenKt$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        Unit ConsoleListScreen$lambda$3$3$0;
                        ConsoleListScreen$lambda$3$3$0 = ConsoleListScreenKt.ConsoleListScreen$lambda$3$3$0(ConsoleListViewModel.this);
                        return ConsoleListScreen$lambda$3$3$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv622);
                it$iv622 = value$iv622;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                StatsPanelKt.StatsPanel(isAnyFilterActive, (Function0) it$iv622, ComposableLambdaKt.rememberComposableLambda(2113200159, true, new Function2() { // from class: kntr.app.ad.ui.inspector.ui.main.console.ConsoleListScreenKt$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj, Object obj2) {
                        Unit ConsoleListScreen$lambda$3$4;
                        ConsoleListScreen$lambda$3$4 = ConsoleListScreenKt.ConsoleListScreen$lambda$3$4(ConsoleListViewModel.this, viewState$delegate, (Composer) obj, ((Integer) obj2).intValue());
                        return ConsoleListScreen$lambda$3$4;
                    }
                }, $composer3, 54), statsPanelCountItem42, statsPanelCountItem222, statsPanelCountItem322, $composer3, 384);
                SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(12)), $composer3, 6);
                if (ConsoleListScreen$lambda$1(viewState$delegate).isLoading()) {
                }
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                if (ComposerKt.isTraceInProgress()) {
                }
                paddingValues2 = paddingValues42;
            }
            value$iv = new Function0() { // from class: kntr.app.ad.ui.inspector.ui.main.console.ConsoleListScreenKt$$ExternalSyntheticLambda10
                public final Object invoke() {
                    Unit ConsoleListScreen$lambda$3$0$0;
                    ConsoleListScreen$lambda$3$0$0 = ConsoleListScreenKt.ConsoleListScreen$lambda$3$0$0(ConsoleListViewModel.this, viewState$delegate);
                    return ConsoleListScreen$lambda$3$0$0;
                }
            };
            $composer3.updateRememberedValue(value$iv);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            StatsPanelCountItem statsPanelCountItem422 = new StatsPanelCountItem(intValue, "INFO", z, (Function0) value$iv);
            Integer num2222 = ConsoleListScreen$lambda$1(viewState$delegate).getTypesCount().get(PrintType.ERROR);
            if (num2222 == null) {
            }
            if (ConsoleListScreen$lambda$1(viewState$delegate).getSelectedPrintType() != PrintType.ERROR) {
            }
            ComposerKt.sourceInformationMarkerStart($composer3, 1754236612, "CC(remember):ConsoleListScreen.kt#9igjgp");
            invalid$iv2 = $composer3.changedInstance(viewModel) | $composer3.changed(viewState$delegate);
            Object it$iv4222 = $composer3.rememberedValue();
            if (invalid$iv2) {
            }
            Object value$iv4222 = new Function0() { // from class: kntr.app.ad.ui.inspector.ui.main.console.ConsoleListScreenKt$$ExternalSyntheticLambda11
                public final Object invoke() {
                    Unit ConsoleListScreen$lambda$3$1$0;
                    ConsoleListScreen$lambda$3$1$0 = ConsoleListScreenKt.ConsoleListScreen$lambda$3$1$0(ConsoleListViewModel.this, viewState$delegate);
                    return ConsoleListScreen$lambda$3$1$0;
                }
            };
            $composer3.updateRememberedValue(value$iv4222);
            it$iv4222 = value$iv4222;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            StatsPanelCountItem statsPanelCountItem2222 = new StatsPanelCountItem(intValue2, "ERROR", z2, (Function0) it$iv4222);
            Integer num3222 = ConsoleListScreen$lambda$1(viewState$delegate).getTypesCount().get(PrintType.WARNING);
            if (num3222 == null) {
            }
            if (ConsoleListScreen$lambda$1(viewState$delegate).getSelectedPrintType() != PrintType.WARNING) {
            }
            ComposerKt.sourceInformationMarkerStart($composer3, 1754256456, "CC(remember):ConsoleListScreen.kt#9igjgp");
            invalid$iv3 = $composer3.changedInstance(viewModel) | $composer3.changed(viewState$delegate);
            Object it$iv5222 = $composer3.rememberedValue();
            if (invalid$iv3) {
            }
            Object value$iv5222 = new Function0() { // from class: kntr.app.ad.ui.inspector.ui.main.console.ConsoleListScreenKt$$ExternalSyntheticLambda12
                public final Object invoke() {
                    Unit ConsoleListScreen$lambda$3$2$0;
                    ConsoleListScreen$lambda$3$2$0 = ConsoleListScreenKt.ConsoleListScreen$lambda$3$2$0(ConsoleListViewModel.this, viewState$delegate);
                    return ConsoleListScreen$lambda$3$2$0;
                }
            };
            $composer3.updateRememberedValue(value$iv5222);
            it$iv5222 = value$iv5222;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            StatsPanelCountItem statsPanelCountItem3222 = new StatsPanelCountItem(intValue3, "WARNING", z3, (Function0) it$iv5222);
            ComposerKt.sourceInformationMarkerStart($composer3, 1754204780, "CC(remember):ConsoleListScreen.kt#9igjgp");
            invalid$iv4 = $composer3.changedInstance(viewModel);
            Object it$iv6222 = $composer3.rememberedValue();
            if (invalid$iv4) {
            }
            Object value$iv6222 = new Function0() { // from class: kntr.app.ad.ui.inspector.ui.main.console.ConsoleListScreenKt$$ExternalSyntheticLambda0
                public final Object invoke() {
                    Unit ConsoleListScreen$lambda$3$3$0;
                    ConsoleListScreen$lambda$3$3$0 = ConsoleListScreenKt.ConsoleListScreen$lambda$3$3$0(ConsoleListViewModel.this);
                    return ConsoleListScreen$lambda$3$3$0;
                }
            };
            $composer3.updateRememberedValue(value$iv6222);
            it$iv6222 = value$iv6222;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            StatsPanelKt.StatsPanel(isAnyFilterActive, (Function0) it$iv6222, ComposableLambdaKt.rememberComposableLambda(2113200159, true, new Function2() { // from class: kntr.app.ad.ui.inspector.ui.main.console.ConsoleListScreenKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit ConsoleListScreen$lambda$3$4;
                    ConsoleListScreen$lambda$3$4 = ConsoleListScreenKt.ConsoleListScreen$lambda$3$4(ConsoleListViewModel.this, viewState$delegate, (Composer) obj, ((Integer) obj2).intValue());
                    return ConsoleListScreen$lambda$3$4;
                }
            }, $composer3, 54), statsPanelCountItem422, statsPanelCountItem2222, statsPanelCountItem3222, $composer3, 384);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(12)), $composer3, 6);
            if (ConsoleListScreen$lambda$1(viewState$delegate).isLoading()) {
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            if (ComposerKt.isTraceInProgress()) {
            }
            paddingValues2 = paddingValues42;
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.ad.ui.inspector.ui.main.console.ConsoleListScreenKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    Unit ConsoleListScreen$lambda$4;
                    ConsoleListScreen$lambda$4 = ConsoleListScreenKt.ConsoleListScreen$lambda$4(paddingValues2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return ConsoleListScreen$lambda$4;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ConsoleListViewModel.ViewState ConsoleListScreen$lambda$1(State<ConsoleListViewModel.ViewState> state) {
        Object thisObj$iv = state.getValue();
        return (ConsoleListViewModel.ViewState) thisObj$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult ConsoleListScreen$lambda$2$0(final ConsoleListViewModel $viewModel, DisposableEffectScope $this$DisposableEffect) {
        Intrinsics.checkNotNullParameter($this$DisposableEffect, "$this$DisposableEffect");
        return new DisposableEffectResult() { // from class: kntr.app.ad.ui.inspector.ui.main.console.ConsoleListScreenKt$ConsoleListScreen$lambda$2$0$$inlined$onDispose$1
            public void dispose() {
                ConsoleListViewModel.this.onCleared();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConsoleListScreen$lambda$3$3$0(ConsoleListViewModel $viewModel) {
        $viewModel.processIntent(ConsoleListViewModel.Intent.ClearFilters.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConsoleListScreen$lambda$3$0$0(ConsoleListViewModel $viewModel, State $viewState$delegate) {
        $viewModel.processIntent(new ConsoleListViewModel.Intent.SelectPrintType(ConsoleListScreen$lambda$1($viewState$delegate).getSelectedPrintType() == PrintType.INFO ? null : PrintType.INFO));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConsoleListScreen$lambda$3$1$0(ConsoleListViewModel $viewModel, State $viewState$delegate) {
        $viewModel.processIntent(new ConsoleListViewModel.Intent.SelectPrintType(ConsoleListScreen$lambda$1($viewState$delegate).getSelectedPrintType() == PrintType.ERROR ? null : PrintType.ERROR));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConsoleListScreen$lambda$3$2$0(ConsoleListViewModel $viewModel, State $viewState$delegate) {
        $viewModel.processIntent(new ConsoleListViewModel.Intent.SelectPrintType(ConsoleListScreen$lambda$1($viewState$delegate).getSelectedPrintType() == PrintType.WARNING ? null : PrintType.WARNING));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConsoleListScreen$lambda$3$4(final ConsoleListViewModel $viewModel, State $viewState$delegate, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C121@5097L10,119@5016L204,125@5238L40,129@5401L121,127@5296L345:ConsoleListScreen.kt#ufje4c");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2113200159, $changed, -1, "kntr.app.ad.ui.inspector.ui.main.console.ConsoleListScreen.<anonymous>.<anonymous> (ConsoleListScreen.kt:119)");
            }
            TextKt.Text-Nvy7gAk("搜索", (Modifier) null, ColorKt.Color(4285231744L), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, TextStyle.copy-p1EtxEg$default(MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getBodySmall(), 0L, 0L, FontWeight.Companion.getMedium(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777211, (Object) null), $composer, 390, 0, 131066);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(8)), $composer, 6);
            String searchText = ConsoleListScreen$lambda$1($viewState$delegate).getSearchText();
            ComposerKt.sourceInformationMarkerStart($composer, -734164392, "CC(remember):ConsoleListScreen.kt#9igjgp");
            boolean invalid$iv = $composer.changedInstance($viewModel);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function1() { // from class: kntr.app.ad.ui.inspector.ui.main.console.ConsoleListScreenKt$$ExternalSyntheticLambda4
                    public final Object invoke(Object obj) {
                        Unit ConsoleListScreen$lambda$3$4$0$0;
                        ConsoleListScreen$lambda$3$4$0$0 = ConsoleListScreenKt.ConsoleListScreen$lambda$3$4$0$0(ConsoleListViewModel.this, (String) obj);
                        return ConsoleListScreen$lambda$3$4$0$0;
                    }
                };
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            StatsPanelKt.ModernSearchField(searchText, (Function1) it$iv, "搜索日志标签或消息内容", AppIcons.INSTANCE.getSearch(), $composer, 3456);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConsoleListScreen$lambda$3$4$0$0(ConsoleListViewModel $viewModel, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        $viewModel.processIntent(new ConsoleListViewModel.Intent.UpdateSearchText(it));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConsoleListScreen$lambda$3$6$0(final State $viewState$delegate, LazyListScope $this$LazyColumn) {
        Intrinsics.checkNotNullParameter($this$LazyColumn, "$this$LazyColumn");
        final List items$iv = ConsoleListScreen$lambda$1($viewState$delegate).getFilteredPrintJobs();
        final Function1 contentType$iv = new Function1() { // from class: kntr.app.ad.ui.inspector.ui.main.console.ConsoleListScreenKt$ConsoleListScreen$lambda$3$6$0$$inlined$items$default$1
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                return m448invoke((PrintJobData) p1);
            }

            /* renamed from: invoke  reason: collision with other method in class */
            public final Void m448invoke(PrintJobData printJobData) {
                return null;
            }
        };
        $this$LazyColumn.items(items$iv.size(), (Function1) null, new Function1<Integer, Object>() { // from class: kntr.app.ad.ui.inspector.ui.main.console.ConsoleListScreenKt$ConsoleListScreen$lambda$3$6$0$$inlined$items$default$3
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                return invoke(((Number) p1).intValue());
            }

            public final Object invoke(int index) {
                return contentType$iv.invoke(items$iv.get(index));
            }
        }, ComposableLambdaKt.composableLambdaInstance(802480018, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: kntr.app.ad.ui.inspector.ui.main.console.ConsoleListScreenKt$ConsoleListScreen$lambda$3$6$0$$inlined$items$default$4
            public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3, Object p4) {
                invoke((LazyItemScope) p1, ((Number) p2).intValue(), (Composer) p3, ((Number) p4).intValue());
                return Unit.INSTANCE;
            }

            /* JADX WARN: Removed duplicated region for block: B:37:0x00b3  */
            /* JADX WARN: Removed duplicated region for block: B:38:0x00b5  */
            /* JADX WARN: Removed duplicated region for block: B:40:0x00b8  */
            /* JADX WARN: Removed duplicated region for block: B:46:0x00ed  */
            /* JADX WARN: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void invoke(LazyItemScope $this$items, int it, Composer $composer, int $changed) {
                ConsoleListViewModel.ViewState ConsoleListScreen$lambda$1;
                boolean z;
                ConsoleListViewModel.ViewState ConsoleListScreen$lambda$12;
                boolean z2;
                ConsoleListViewModel.ViewState ConsoleListScreen$lambda$13;
                ConsoleListViewModel.ViewState ConsoleListScreen$lambda$14;
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
                PrintJobData printJobData = (PrintJobData) items$iv.get(it);
                $composer.startReplaceGroup(-1420175970);
                ComposerKt.sourceInformation($composer, "CN(printJobData)*161@6441L501:ConsoleListScreen.kt#ufje4c");
                ConsoleListScreen$lambda$1 = ConsoleListScreenKt.ConsoleListScreen$lambda$1($viewState$delegate);
                if (ConsoleListScreen$lambda$1.getSearchText().length() > 0) {
                    ConsoleListScreen$lambda$14 = ConsoleListScreenKt.ConsoleListScreen$lambda$1($viewState$delegate);
                    if (StringsKt.contains(printJobData.getName(), ConsoleListScreen$lambda$14.getSearchText(), true)) {
                        z = true;
                        ConsoleListScreen$lambda$12 = ConsoleListScreenKt.ConsoleListScreen$lambda$1($viewState$delegate);
                        if (ConsoleListScreen$lambda$12.getSearchText().length() <= 0) {
                            ConsoleListScreen$lambda$13 = ConsoleListScreenKt.ConsoleListScreen$lambda$1($viewState$delegate);
                            if (StringsKt.contains(printJobData.getMsg(), ConsoleListScreen$lambda$13.getSearchText(), true)) {
                                z2 = true;
                                ConsoleListScreenKt.PrintJobCard(printJobData, z, z2, $composer, PrintJobData.$stable | (($changed2 >> 3) & 14), 0);
                                $composer.endReplaceGroup();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                        }
                        z2 = false;
                        ConsoleListScreenKt.PrintJobCard(printJobData, z, z2, $composer, PrintJobData.$stable | (($changed2 >> 3) & 14), 0);
                        $composer.endReplaceGroup();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                    }
                }
                z = false;
                ConsoleListScreen$lambda$12 = ConsoleListScreenKt.ConsoleListScreen$lambda$1($viewState$delegate);
                if (ConsoleListScreen$lambda$12.getSearchText().length() <= 0) {
                }
                z2 = false;
                ConsoleListScreenKt.PrintJobCard(printJobData, z, z2, $composer, PrintJobData.$stable | (($changed2 >> 3) & 14), 0);
                $composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                }
            }
        }));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void PrintJobCard(final PrintJobData printJobData, boolean highlightTag, boolean highlightMessage, Composer $composer, final int $changed, final int i) {
        boolean z;
        boolean z2;
        Composer $composer2;
        boolean highlightTag2;
        boolean highlightMessage2;
        final long logColor;
        Composer $composer3 = $composer.startRestartGroup(995734307);
        ComposerKt.sourceInformation($composer3, "C(PrintJobCard)N(printJobData,highlightTag,highlightMessage)202@7693L4272,194@7441L4524:ConsoleListScreen.kt#ufje4c");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= ($changed & 8) == 0 ? $composer3.changed(printJobData) : $composer3.changedInstance(printJobData) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
            z = highlightTag;
        } else if (($changed & 48) == 0) {
            z = highlightTag;
            $dirty |= $composer3.changed(z) ? 32 : 16;
        } else {
            z = highlightTag;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty |= 384;
            z2 = highlightMessage;
        } else if (($changed & 384) == 0) {
            z2 = highlightMessage;
            $dirty |= $composer3.changed(z2) ? 256 : 128;
        } else {
            z2 = highlightMessage;
        }
        int $dirty2 = $dirty;
        if ($composer3.shouldExecute(($dirty2 & 147) != 146, $dirty2 & 1)) {
            if (i2 != 0) {
                highlightTag2 = false;
            } else {
                highlightTag2 = z;
            }
            if (i3 == 0) {
                highlightMessage2 = z2;
            } else {
                highlightMessage2 = false;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(995734307, $dirty2, -1, "kntr.app.ad.ui.inspector.ui.main.console.PrintJobCard (ConsoleListScreen.kt:184)");
            }
            switch (WhenMappings.$EnumSwitchMapping$0[printJobData.getType().ordinal()]) {
                case 1:
                    logColor = ColorKt.Color(4279286145L);
                    break;
                case 2:
                    logColor = ColorKt.Color(4294286859L);
                    break;
                case 3:
                    logColor = ColorKt.Color(4293870660L);
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
            final boolean z3 = highlightTag2;
            final boolean z4 = highlightMessage2;
            $composer2 = $composer3;
            SurfaceKt.Surface-T9BRK9s(PaddingKt.padding-VpY3zN4(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(0), Dp.constructor-impl(6)), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(8)), Color.Companion.getWhite-0d7_KjU(), 0L, 0.0f, Dp.constructor-impl(1), (BorderStroke) null, ComposableLambdaKt.rememberComposableLambda(-2100408258, true, new Function2() { // from class: kntr.app.ad.ui.inspector.ui.main.console.ConsoleListScreenKt$$ExternalSyntheticLambda5
                public final Object invoke(Object obj, Object obj2) {
                    Unit PrintJobCard$lambda$0;
                    PrintJobCard$lambda$0 = ConsoleListScreenKt.PrintJobCard$lambda$0(PrintJobData.this, logColor, z3, z4, (Composer) obj, ((Integer) obj2).intValue());
                    return PrintJobCard$lambda$0;
                }
            }, $composer3, 54), $composer2, 12779904, 88);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            highlightTag2 = z;
            highlightMessage2 = z2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final boolean z5 = highlightTag2;
            final boolean z6 = highlightMessage2;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.ad.ui.inspector.ui.main.console.ConsoleListScreenKt$$ExternalSyntheticLambda6
                public final Object invoke(Object obj, Object obj2) {
                    Unit PrintJobCard$lambda$1;
                    PrintJobCard$lambda$1 = ConsoleListScreenKt.PrintJobCard$lambda$1(PrintJobData.this, z5, z6, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return PrintJobCard$lambda$1;
                }
            });
        }
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: SSATransform
        java.lang.IndexOutOfBoundsException: bitIndex < 0: -96
        	at java.util.BitSet.get(BitSet.java:623)
        	at jadx.core.dex.visitors.ssa.LiveVarAnalysis.fillBasicBlockInfo(LiveVarAnalysis.java:65)
        	at jadx.core.dex.visitors.ssa.LiveVarAnalysis.runAnalysis(LiveVarAnalysis.java:36)
        	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:55)
        	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:41)
        */
    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit PrintJobCard$lambda$0(kntr.app.ad.domain.inspector.core.work.PrintJobData r157, long r158, boolean r160, boolean r161, androidx.compose.runtime.Composer r162, int r163) {
        /*
            Method dump skipped, instructions count: 1592
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kntr.app.ad.ui.inspector.ui.main.console.ConsoleListScreenKt.PrintJobCard$lambda$0(kntr.app.ad.domain.inspector.core.work.PrintJobData, long, boolean, boolean, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PrintJobCard$lambda$0$0$0$0$0(PrintJobData $printJobData, long $logColor, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        String str;
        ComposerKt.sourceInformation($composer, "C226@8545L798:ConsoleListScreen.kt#ufje4c");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(728494597, $changed, -1, "kntr.app.ad.ui.inspector.ui.main.console.PrintJobCard.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ConsoleListScreen.kt:226)");
            }
            Alignment contentAlignment$iv = Alignment.Companion.getCenter();
            ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Modifier modifier$iv = Modifier.Companion;
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (48 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer, modifier$iv);
            Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv2;
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
            int i2 = ((48 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, 1070814139, "C235@9043L10,227@8616L701:ConsoleListScreen.kt#ufje4c");
            switch (WhenMappings.$EnumSwitchMapping$0[$printJobData.getType().ordinal()]) {
                case 1:
                    str = "I";
                    break;
                case 2:
                    str = "W";
                    break;
                case 3:
                    str = "E";
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
            TextKt.Text-Nvy7gAk(str, (Modifier) null, $logColor, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, TextStyle.copy-p1EtxEg$default(MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getLabelSmall(), 0L, TextUnitKt.getSp(12), FontWeight.Companion.getBold(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777209, (Object) null), $composer, 0, 0, 131066);
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
    public static final Unit PrintJobCard$lambda$0$0$1(PrintJobData $printJobData, boolean $highlightMessage, Composer $composer, int $changed) {
        long Color;
        ComposerKt.sourceInformation($composer, "C291@11239L10,288@11122L813:ConsoleListScreen.kt#ufje4c");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1981829043, $changed, -1, "kntr.app.ad.ui.inspector.ui.main.console.PrintJobCard.<anonymous>.<anonymous>.<anonymous> (ConsoleListScreen.kt:288)");
            }
            String msg = $printJobData.getMsg();
            TextStyle bodyMedium = MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getBodyMedium();
            FontFamily monospace = FontFamily.Companion.getMonospace();
            long sp = TextUnitKt.getSp(13);
            FontWeight.Companion companion = FontWeight.Companion;
            TextStyle textStyle = TextStyle.copy-p1EtxEg$default(bodyMedium, 0L, sp, $highlightMessage ? companion.getMedium() : companion.getNormal(), (FontStyle) null, (FontSynthesis) null, monospace, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(18), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646105, (Object) null);
            if ($highlightMessage) {
                $composer.startReplaceGroup(-2048044644);
                ComposerKt.sourceInformation($composer, "299@11674L11");
                long j2 = MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getPrimary-0d7_KjU();
                $composer.endReplaceGroup();
                Color = j2;
            } else {
                $composer.startReplaceGroup(-2047948947);
                $composer.endReplaceGroup();
                Color = ColorKt.Color(4281811281L);
            }
            TextKt.Text-Nvy7gAk(msg, PaddingKt.padding-3ABfNKs(Modifier.Companion, Dp.constructor-impl(8)), Color, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, textStyle, $composer, 48, 0, 131064);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private static final String formatTimestamp(long timestamp) {
        return DateTimeUtils.INSTANCE.formatTimestamp(timestamp);
    }
}