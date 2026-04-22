package kntr.app.tribee.repost.page.selectTribeeBottomSheet;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DensityKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import bili.resource.tribee.String0_commonMainKt;
import bili.resource.tribee.TribeeRes;
import com.bilibili.compose.theme.BiliTheme;
import kntr.app.tribee.consume.page.TribeePageStatusComposeKt;
import kntr.app.tribee.repost.page.selectTribeeBottomSheet.SelectTribeeBottomSheetState;
import kntr.app.tribee.repost.page.selectTribeeBottomSheet.SelectTribeeBottomSheetStateAction;
import kntr.app.tribee.repost.page.selectTribeeBottomSheet.selectTribeeList.SelectTribeeListKt;
import kntr.app.tribee.repost.page.selectTribeeBottomSheet.selectTribeeList.SelectTribeeListScrollPosition;
import kntr.app.tribee.repost.page.selectTribeeBottomSheet.selectTribeeList.SelectTribeeListState;
import kntr.app.tribee.repost.page.selectTribeeBottomSheet.selectTribeeList.SelectableTribeeItem;
import kntr.app.tribee.repost.page.selectTribeeBottomSheet.selectTribeeList.SelectableTribeePartition;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.bilitheme.compose.bottomsheet.BottomSheetScope;
import kntr.common.bilitheme.compose.bottomsheet.ComposeBottomsheetKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.compose.resources.StringResourcesKt;

/* compiled from: SelectTribeeBottomSheet.kt */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\u001a)\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\b\u0010\t¨\u0006\n²\u0006\n\u0010\u000b\u001a\u00020\fX\u008a\u0084\u0002"}, d2 = {"SelectTribeeBottomSheet", "", "viewModel", "Lkntr/app/tribee/repost/page/selectTribeeBottomSheet/SelectTribeeBottomSheetViewModel;", "maxHeight", "Landroidx/compose/ui/unit/Dp;", "modifier", "Landroidx/compose/ui/Modifier;", "SelectTribeeBottomSheet-uFdPcIQ", "(Lkntr/app/tribee/repost/page/selectTribeeBottomSheet/SelectTribeeBottomSheetViewModel;FLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "repost_debug", "state", "Lkntr/app/tribee/repost/page/selectTribeeBottomSheet/SelectTribeeBottomSheetState;"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class SelectTribeeBottomSheetKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SelectTribeeBottomSheet_uFdPcIQ$lambda$2(SelectTribeeBottomSheetViewModel selectTribeeBottomSheetViewModel, float f, Modifier modifier, int i, int i2, Composer composer, int i3) {
        m1019SelectTribeeBottomSheetuFdPcIQ(selectTribeeBottomSheetViewModel, f, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* renamed from: SelectTribeeBottomSheet-uFdPcIQ  reason: not valid java name */
    public static final void m1019SelectTribeeBottomSheetuFdPcIQ(final SelectTribeeBottomSheetViewModel viewModel, final float f, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Composer $composer2 = $composer.startRestartGroup(243179314);
        ComposerKt.sourceInformation($composer2, "C(SelectTribeeBottomSheet)N(viewModel,maxHeight:c#ui.unit.Dp,modifier)41@1798L16,44@1897L7,45@1937L4676,43@1820L4793:SelectTribeeBottomSheet.kt#ydrysg");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(viewModel) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(f) ? 32 : 16;
        }
        if (!$composer2.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if ((i & 4) != 0) {
                modifier = (Modifier) Modifier.Companion;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(243179314, $dirty, -1, "kntr.app.tribee.repost.page.selectTribeeBottomSheet.SelectTribeeBottomSheet (SelectTribeeBottomSheet.kt:40)");
            }
            final State state$delegate = SnapshotStateKt.collectAsState(viewModel.getStateFlow(), (CoroutineContext) null, $composer2, 0, 1);
            ProvidableCompositionLocal localDensity = CompositionLocalsKt.getLocalDensity();
            CompositionLocal this_$iv = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            CompositionLocalKt.CompositionLocalProvider(localDensity.provides(DensityKt.Density(((Density) consume).getDensity(), 1.0f)), ComposableLambdaKt.rememberComposableLambda(1436775410, true, new Function2() { // from class: kntr.app.tribee.repost.page.selectTribeeBottomSheet.SelectTribeeBottomSheetKt$$ExternalSyntheticLambda7
                public final Object invoke(Object obj, Object obj2) {
                    Unit SelectTribeeBottomSheet_uFdPcIQ$lambda$1;
                    SelectTribeeBottomSheet_uFdPcIQ$lambda$1 = SelectTribeeBottomSheetKt.SelectTribeeBottomSheet_uFdPcIQ$lambda$1(SelectTribeeBottomSheetViewModel.this, f, state$delegate, (Composer) obj, ((Integer) obj2).intValue());
                    return SelectTribeeBottomSheet_uFdPcIQ$lambda$1;
                }
            }, $composer2, 54), $composer2, ProvidedValue.$stable | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier2 = modifier;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.repost.page.selectTribeeBottomSheet.SelectTribeeBottomSheetKt$$ExternalSyntheticLambda8
                public final Object invoke(Object obj, Object obj2) {
                    Unit SelectTribeeBottomSheet_uFdPcIQ$lambda$2;
                    SelectTribeeBottomSheet_uFdPcIQ$lambda$2 = SelectTribeeBottomSheetKt.SelectTribeeBottomSheet_uFdPcIQ$lambda$2(SelectTribeeBottomSheetViewModel.this, f, modifier2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return SelectTribeeBottomSheet_uFdPcIQ$lambda$2;
                }
            });
        }
    }

    private static final SelectTribeeBottomSheetState SelectTribeeBottomSheet_uFdPcIQ$lambda$0(State<? extends SelectTribeeBottomSheetState> state) {
        Object thisObj$iv = state.getValue();
        return (SelectTribeeBottomSheetState) thisObj$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SelectTribeeBottomSheet_uFdPcIQ$lambda$1(final SelectTribeeBottomSheetViewModel $viewModel, final float f, final State $state$delegate, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C47@2008L6,48@2050L53,52@2157L4450,46@1947L4660:SelectTribeeBottomSheet.kt#ydrysg");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1436775410, $changed, -1, "kntr.app.tribee.repost.page.selectTribeeBottomSheet.SelectTribeeBottomSheet.<anonymous> (SelectTribeeBottomSheet.kt:46)");
            }
            long j = BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBg2_float-0d7_KjU();
            ComposerKt.sourceInformationMarkerStart($composer, 2056670663, "CC(remember):SelectTribeeBottomSheet.kt#9igjgp");
            boolean invalid$iv = $composer.changedInstance($viewModel);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function0() { // from class: kntr.app.tribee.repost.page.selectTribeeBottomSheet.SelectTribeeBottomSheetKt$$ExternalSyntheticLambda5
                    public final Object invoke() {
                        Unit SelectTribeeBottomSheet_uFdPcIQ$lambda$1$0$0;
                        SelectTribeeBottomSheet_uFdPcIQ$lambda$1$0$0 = SelectTribeeBottomSheetKt.SelectTribeeBottomSheet_uFdPcIQ$lambda$1$0$0(SelectTribeeBottomSheetViewModel.this);
                        return SelectTribeeBottomSheet_uFdPcIQ$lambda$1$0$0;
                    }
                };
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposeBottomsheetKt.m1831BottomSheetContainerlVb_Clg((Function0) it$iv, null, j, true, false, false, null, ComposableLambdaKt.rememberComposableLambda(-1435600383, true, new Function3() { // from class: kntr.app.tribee.repost.page.selectTribeeBottomSheet.SelectTribeeBottomSheetKt$$ExternalSyntheticLambda6
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit SelectTribeeBottomSheet_uFdPcIQ$lambda$1$1;
                    SelectTribeeBottomSheet_uFdPcIQ$lambda$1$1 = SelectTribeeBottomSheetKt.SelectTribeeBottomSheet_uFdPcIQ$lambda$1$1(f, $state$delegate, $viewModel, (BottomSheetScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return SelectTribeeBottomSheet_uFdPcIQ$lambda$1$1;
                }
            }, $composer, 54), $composer, 12585984, ConstantsKt.UGC_UPDATE_CALENDAR_CARD_COVER_WIDTH);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SelectTribeeBottomSheet_uFdPcIQ$lambda$1$0$0(SelectTribeeBottomSheetViewModel $viewModel) {
        $viewModel.getOnDismiss().invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x03d3, code lost:
        if (r7 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0725, code lost:
        if (r10 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x075b, code lost:
        if (r9 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0791, code lost:
        if (r9 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L80;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit SelectTribeeBottomSheet_uFdPcIQ$lambda$1$1(float f, State $state$delegate, final SelectTribeeBottomSheetViewModel $viewModel, BottomSheetScope $this$BottomSheetContainer, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        Composer $composer$iv$iv$iv;
        Composer $composer$iv$iv$iv2;
        Composer $composer$iv;
        Composer $composer$iv2;
        Function0 factory$iv$iv$iv2;
        Function0 factory$iv$iv$iv3;
        Function0 factory$iv$iv$iv4;
        Function0 factory$iv$iv$iv5;
        Intrinsics.checkNotNullParameter($this$BottomSheetContainer, "$this$BottomSheetContainer");
        ComposerKt.sourceInformation($composer, "C53@2171L4426:SelectTribeeBottomSheet.kt#ydrysg");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1435600383, $changed, -1, "kntr.app.tribee.repost.page.selectTribeeBottomSheet.SelectTribeeBottomSheet.<anonymous>.<anonymous> (SelectTribeeBottomSheet.kt:53)");
            }
            Modifier modifier$iv = SizeKt.heightIn-VpY3zN4$default(SizeKt.wrapContentHeight$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), (Alignment.Vertical) null, false, 3, (Object) null), 0.0f, f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer, modifier$iv);
            Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv6;
                $composer.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv6;
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
            int i2 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, 341690277, "C:SelectTribeeBottomSheet.kt#ydrysg");
            SelectTribeeBottomSheetState currentState = SelectTribeeBottomSheet_uFdPcIQ$lambda$0($state$delegate);
            if (!(currentState instanceof SelectTribeeBottomSheetState.SelectTribeeBottomSheetLoadingState)) {
                $composer$iv$iv$iv = $composer;
                $composer$iv$iv$iv2 = $composer;
                $composer$iv = $composer;
                if (!(currentState instanceof SelectTribeeBottomSheetState.SelectTribeeBottomSheetErrorState)) {
                    $composer$iv2 = $composer;
                    if (!(currentState instanceof SelectTribeeBottomSheetState.SelectTribeeBottomSheetEmptyState)) {
                        if (currentState instanceof SelectTribeeBottomSheetState.SelectTribeeBottomSheetContentState) {
                            $composer.startReplaceGroup(343161970);
                            ComposerKt.sourceInformation($composer, "95@3962L2581");
                            Modifier modifier$iv2 = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
                            ComposerKt.sourceInformationMarkerStart($composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                            Arrangement.Vertical verticalArrangement$iv2 = Arrangement.INSTANCE.getTop();
                            Alignment.Horizontal horizontalAlignment$iv2 = Alignment.Companion.getStart();
                            MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv2, horizontalAlignment$iv2, $composer, ((6 >> 3) & 14) | ((6 >> 3) & 112));
                            int $changed$iv$iv2 = (6 << 3) & 112;
                            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
                            CompositionLocalMap localMap$iv$iv2 = $composer.getCurrentCompositionLocalMap();
                            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer, modifier$iv2);
                            Function0 factory$iv$iv$iv7 = ComposeUiNode.Companion.getConstructor();
                            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                            if (!($composer.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            $composer.startReusableNode();
                            if ($composer.getInserting()) {
                                factory$iv$iv$iv2 = factory$iv$iv$iv7;
                                $composer.createNode(factory$iv$iv$iv2);
                            } else {
                                factory$iv$iv$iv2 = factory$iv$iv$iv7;
                                $composer.useNode();
                            }
                            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer);
                            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
                            int i3 = ($changed$iv$iv$iv2 >> 6) & 14;
                            ComposerKt.sourceInformationMarkerStart($composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                            ColumnScope columnScope2 = ColumnScopeInstance.INSTANCE;
                            int i4 = ((6 >> 6) & 112) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer, -303685614, "C98@4090L40,101@4240L56,103@4398L6,99@4159L636,111@4824L41,114@5035L404,122@5501L400,130@5948L135,133@6129L357,112@4894L1623:SelectTribeeBottomSheet.kt#ydrysg");
                            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(4)), $composer, 6);
                            String stringResource = StringResourcesKt.stringResource(String0_commonMainKt.getTribee_global_string_50(TribeeRes.INSTANCE.getString()), $composer, 0);
                            long sp = TextUnitKt.getSp(16);
                            long j = BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getGa10-0d7_KjU();
                            FontWeight w600 = FontWeight.Companion.getW600();
                            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
                            int i5 = TextAlign.Companion.getStart-e0LSkKk();
                            TextKt.Text-Nvy7gAk(stringResource, fillMaxWidth$default, j, (TextAutoSize) null, sp, (FontStyle) null, w600, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(i5), TextUnitKt.getSp(22), TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, (TextStyle) null, $composer, 1597488, 25008, 238504);
                            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(12)), $composer, 6);
                            SelectTribeeListState listState = ((SelectTribeeBottomSheetState.SelectTribeeBottomSheetContentState) currentState).getListState();
                            ComposerKt.sourceInformationMarkerStart($composer, -841052086, "CC(remember):SelectTribeeBottomSheet.kt#9igjgp");
                            boolean invalid$iv = $composer.changedInstance($viewModel);
                            Object it$iv = $composer.rememberedValue();
                            if (invalid$iv) {
                            }
                            Object value$iv = new Function2() { // from class: kntr.app.tribee.repost.page.selectTribeeBottomSheet.SelectTribeeBottomSheetKt$$ExternalSyntheticLambda1
                                public final Object invoke(Object obj, Object obj2) {
                                    Unit SelectTribeeBottomSheet_uFdPcIQ$lambda$1$1$0$3$0$0;
                                    SelectTribeeBottomSheet_uFdPcIQ$lambda$1$1$0$3$0$0 = SelectTribeeBottomSheetKt.SelectTribeeBottomSheet_uFdPcIQ$lambda$1$1$0$3$0$0(SelectTribeeBottomSheetViewModel.this, ((Long) obj).longValue(), (String) obj2);
                                    return SelectTribeeBottomSheet_uFdPcIQ$lambda$1$1$0$3$0$0;
                                }
                            };
                            $composer.updateRememberedValue(value$iv);
                            it$iv = value$iv;
                            Function2 function2 = (Function2) it$iv;
                            ComposerKt.sourceInformationMarkerEnd($composer);
                            ComposerKt.sourceInformationMarkerStart($composer, -841037178, "CC(remember):SelectTribeeBottomSheet.kt#9igjgp");
                            boolean invalid$iv2 = $composer.changedInstance($viewModel);
                            Object it$iv2 = $composer.rememberedValue();
                            if (invalid$iv2) {
                            }
                            Object value$iv2 = new Function2() { // from class: kntr.app.tribee.repost.page.selectTribeeBottomSheet.SelectTribeeBottomSheetKt$$ExternalSyntheticLambda2
                                public final Object invoke(Object obj, Object obj2) {
                                    Unit SelectTribeeBottomSheet_uFdPcIQ$lambda$1$1$0$3$1$0;
                                    SelectTribeeBottomSheet_uFdPcIQ$lambda$1$1$0$3$1$0 = SelectTribeeBottomSheetKt.SelectTribeeBottomSheet_uFdPcIQ$lambda$1$1$0$3$1$0(SelectTribeeBottomSheetViewModel.this, (SelectableTribeeItem) obj, (SelectableTribeePartition) obj2);
                                    return SelectTribeeBottomSheet_uFdPcIQ$lambda$1$1$0$3$1$0;
                                }
                            };
                            $composer.updateRememberedValue(value$iv2);
                            it$iv2 = value$iv2;
                            Function2 function22 = (Function2) it$iv2;
                            ComposerKt.sourceInformationMarkerEnd($composer);
                            ComposerKt.sourceInformationMarkerStart($composer, -841023139, "CC(remember):SelectTribeeBottomSheet.kt#9igjgp");
                            boolean invalid$iv3 = $composer.changedInstance($viewModel);
                            Object it$iv3 = $composer.rememberedValue();
                            if (invalid$iv3) {
                            }
                            Object value$iv3 = new Function0() { // from class: kntr.app.tribee.repost.page.selectTribeeBottomSheet.SelectTribeeBottomSheetKt$$ExternalSyntheticLambda3
                                public final Object invoke() {
                                    Unit SelectTribeeBottomSheet_uFdPcIQ$lambda$1$1$0$3$2$0;
                                    SelectTribeeBottomSheet_uFdPcIQ$lambda$1$1$0$3$2$0 = SelectTribeeBottomSheetKt.SelectTribeeBottomSheet_uFdPcIQ$lambda$1$1$0$3$2$0(SelectTribeeBottomSheetViewModel.this);
                                    return SelectTribeeBottomSheet_uFdPcIQ$lambda$1$1$0$3$2$0;
                                }
                            };
                            $composer.updateRememberedValue(value$iv3);
                            it$iv3 = value$iv3;
                            Function0 function0 = (Function0) it$iv3;
                            ComposerKt.sourceInformationMarkerEnd($composer);
                            ComposerKt.sourceInformationMarkerStart($composer, -841017125, "CC(remember):SelectTribeeBottomSheet.kt#9igjgp");
                            boolean invalid$iv4 = $composer.changedInstance($viewModel);
                            Object it$iv4 = $composer.rememberedValue();
                            if (invalid$iv4 || it$iv4 == Composer.Companion.getEmpty()) {
                                Object value$iv4 = new Function1() { // from class: kntr.app.tribee.repost.page.selectTribeeBottomSheet.SelectTribeeBottomSheetKt$$ExternalSyntheticLambda4
                                    public final Object invoke(Object obj) {
                                        Unit SelectTribeeBottomSheet_uFdPcIQ$lambda$1$1$0$3$3$0;
                                        SelectTribeeBottomSheet_uFdPcIQ$lambda$1$1$0$3$3$0 = SelectTribeeBottomSheetKt.SelectTribeeBottomSheet_uFdPcIQ$lambda$1$1$0$3$3$0(SelectTribeeBottomSheetViewModel.this, (SelectTribeeListScrollPosition) obj);
                                        return SelectTribeeBottomSheet_uFdPcIQ$lambda$1$1$0$3$3$0;
                                    }
                                };
                                $composer.updateRememberedValue(value$iv4);
                                it$iv4 = value$iv4;
                            }
                            ComposerKt.sourceInformationMarkerEnd($composer);
                            SelectTribeeListKt.SelectTribeeList(listState, function2, function22, null, function0, (Function1) it$iv4, $composer, 0, 8);
                            ComposerKt.sourceInformationMarkerEnd($composer);
                            ComposerKt.sourceInformationMarkerEnd($composer);
                            $composer.endNode();
                            ComposerKt.sourceInformationMarkerEnd($composer);
                            ComposerKt.sourceInformationMarkerEnd($composer);
                            ComposerKt.sourceInformationMarkerEnd($composer);
                            $composer.endReplaceGroup();
                        } else {
                            $composer.startReplaceGroup(-958809058);
                            $composer.endReplaceGroup();
                            throw new NoWhenBranchMatchedException();
                        }
                    } else {
                        $composer.startReplaceGroup(342633606);
                        ComposerKt.sourceInformation($composer, "84@3500L321");
                        Modifier modifier$iv3 = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
                        Alignment contentAlignment$iv = Alignment.Companion.getCenter();
                        ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicy$iv3 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                        int $changed$iv$iv3 = (54 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
                        CompositionLocalMap localMap$iv$iv3 = $composer.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer, modifier$iv3);
                        Function0 factory$iv$iv$iv8 = ComposeUiNode.Companion.getConstructor();
                        int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                        if (!($composer.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer.startReusableNode();
                        if ($composer.getInserting()) {
                            factory$iv$iv$iv3 = factory$iv$iv$iv8;
                            $composer.createNode(factory$iv$iv$iv3);
                        } else {
                            factory$iv$iv$iv3 = factory$iv$iv$iv8;
                            $composer.useNode();
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer);
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
                        int i6 = ($changed$iv$iv$iv3 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                        BoxScope boxScope = BoxScopeInstance.INSTANCE;
                        int i7 = ((54 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer, -1012836812, "C88@3689L106:SelectTribeeBottomSheet.kt#ydrysg");
                        TribeePageStatusComposeKt.TribeeEmpty(null, ((SelectTribeeBottomSheetState.SelectTribeeBottomSheetEmptyState) currentState).getEmptyDesc(), null, $composer, 0, 5);
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        $composer.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        $composer.endReplaceGroup();
                    }
                } else {
                    $composer.startReplaceGroup(342065810);
                    ComposerKt.sourceInformation($composer, "71@2924L437");
                    Modifier modifier$iv4 = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
                    Alignment contentAlignment$iv2 = Alignment.Companion.getCenter();
                    ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicy$iv4 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
                    int $changed$iv$iv4 = (54 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int compositeKeyHash$iv$iv4 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
                    CompositionLocalMap localMap$iv$iv4 = $composer.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer, modifier$iv4);
                    Function0 factory$iv$iv$iv9 = ComposeUiNode.Companion.getConstructor();
                    int $changed$iv$iv$iv4 = (($changed$iv$iv4 << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!($composer.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer.startReusableNode();
                    if ($composer.getInserting()) {
                        factory$iv$iv$iv4 = factory$iv$iv$iv9;
                        $composer.createNode(factory$iv$iv$iv4);
                    } else {
                        factory$iv$iv$iv4 = factory$iv$iv$iv9;
                        $composer.useNode();
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv4 = Updater.constructor-impl($composer);
                    $composer$iv2 = $composer;
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, measurePolicy$iv4, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, localMap$iv$iv4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv4, Integer.valueOf(compositeKeyHash$iv$iv4), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv4, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, materialized$iv$iv4, ComposeUiNode.Companion.getSetModifier());
                    int i8 = ($changed$iv$iv$iv4 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
                    int i9 = ((54 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer, -597785631, "C76@3170L134,75@3113L222:SelectTribeeBottomSheet.kt#ydrysg");
                    ComposerKt.sourceInformationMarkerStart($composer, 1643286314, "CC(remember):SelectTribeeBottomSheet.kt#9igjgp");
                    boolean invalid$iv5 = $composer.changedInstance($viewModel);
                    Object it$iv5 = $composer.rememberedValue();
                    if (invalid$iv5) {
                    }
                    Object value$iv5 = new Function0() { // from class: kntr.app.tribee.repost.page.selectTribeeBottomSheet.SelectTribeeBottomSheetKt$$ExternalSyntheticLambda0
                        public final Object invoke() {
                            Unit SelectTribeeBottomSheet_uFdPcIQ$lambda$1$1$0$1$0$0;
                            SelectTribeeBottomSheet_uFdPcIQ$lambda$1$1$0$1$0$0 = SelectTribeeBottomSheetKt.SelectTribeeBottomSheet_uFdPcIQ$lambda$1$1$0$1$0$0(SelectTribeeBottomSheetViewModel.this);
                            return SelectTribeeBottomSheet_uFdPcIQ$lambda$1$1$0$1$0$0;
                        }
                    };
                    $composer.updateRememberedValue(value$iv5);
                    it$iv5 = value$iv5;
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    TribeePageStatusComposeKt.TribeeError(null, false, (Function0) it$iv5, $composer, 0, 3);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    $composer.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    $composer.endReplaceGroup();
                }
            } else {
                $composer.startReplaceGroup(341693345);
                ComposerKt.sourceInformation($composer, "62@2555L230");
                Modifier modifier$iv5 = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
                Alignment contentAlignment$iv3 = Alignment.Companion.getCenter();
                ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv5 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv3, false);
                int $changed$iv$iv5 = (54 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv5 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
                CompositionLocalMap localMap$iv$iv5 = $composer.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv5 = ComposedModifierKt.materializeModifier($composer, modifier$iv5);
                Function0 factory$iv$iv$iv10 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv5 = (($changed$iv$iv5 << 6) & 896) | 6;
                $composer$iv = $composer;
                $composer$iv$iv$iv = $composer;
                ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer.startReusableNode();
                if ($composer.getInserting()) {
                    factory$iv$iv$iv5 = factory$iv$iv$iv10;
                    $composer.createNode(factory$iv$iv$iv5);
                } else {
                    factory$iv$iv$iv5 = factory$iv$iv$iv10;
                    $composer.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv5 = Updater.constructor-impl($composer);
                $composer$iv$iv$iv2 = $composer;
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, measurePolicy$iv5, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, localMap$iv$iv5, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv5, Integer.valueOf(compositeKeyHash$iv$iv5), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv5, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, materialized$iv$iv5, ComposeUiNode.Companion.getSetModifier());
                int i10 = ($changed$iv$iv$iv5 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScope boxScope3 = BoxScopeInstance.INSTANCE;
                int i11 = ((54 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, -1691937177, "C66@2744L15:SelectTribeeBottomSheet.kt#ydrysg");
                TribeePageStatusComposeKt.TribeeLoading(null, $composer, 0, 1);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endReplaceGroup();
                $composer$iv2 = $composer;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer$iv2);
            $composer$iv$iv$iv2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv2);
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SelectTribeeBottomSheet_uFdPcIQ$lambda$1$1$0$1$0$0(SelectTribeeBottomSheetViewModel $viewModel) {
        $viewModel.dispatch(SelectTribeeBottomSheetStateAction.Loading.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SelectTribeeBottomSheet_uFdPcIQ$lambda$1$1$0$3$0$0(SelectTribeeBottomSheetViewModel $viewModel, long tribeeId, String tribeeName) {
        Intrinsics.checkNotNullParameter(tribeeName, "tribeeName");
        $viewModel.dispatch(new SelectTribeeBottomSheetStateAction.ListTribeeItemExposed(tribeeId, tribeeName));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SelectTribeeBottomSheet_uFdPcIQ$lambda$1$1$0$3$1$0(SelectTribeeBottomSheetViewModel $viewModel, SelectableTribeeItem tribee, SelectableTribeePartition partition) {
        $viewModel.dispatch(new SelectTribeeBottomSheetStateAction.SelectTribeeOrPartition(tribee, partition));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SelectTribeeBottomSheet_uFdPcIQ$lambda$1$1$0$3$2$0(SelectTribeeBottomSheetViewModel $viewModel) {
        $viewModel.dispatch(SelectTribeeBottomSheetStateAction.LoadMore.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SelectTribeeBottomSheet_uFdPcIQ$lambda$1$1$0$3$3$0(SelectTribeeBottomSheetViewModel $viewModel, SelectTribeeListScrollPosition listScrollPosition) {
        Intrinsics.checkNotNullParameter(listScrollPosition, "listScrollPosition");
        $viewModel.dispatch(new SelectTribeeBottomSheetStateAction.SaveListScrollPosition(listScrollPosition));
        return Unit.INSTANCE;
    }
}