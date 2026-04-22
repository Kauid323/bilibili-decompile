package kntr.app.ad.ui.inspector.ui.main.request;

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
import kntr.app.ad.domain.inspector.core.work.RequestJobData;
import kntr.app.ad.domain.inspector.core.work.RequestType;
import kntr.app.ad.domain.inspector.model.Status;
import kntr.app.ad.ui.inspector.ui.components.AdSlotIconKt;
import kntr.app.ad.ui.inspector.ui.components.AdSlotItemKt;
import kntr.app.ad.ui.inspector.ui.components.EmptyViewKt;
import kntr.app.ad.ui.inspector.ui.components.StatsPanelCountItem;
import kntr.app.ad.ui.inspector.ui.components.StatsPanelKt;
import kntr.app.ad.ui.inspector.ui.main.request.viewmodel.RequestListViewModelMVI;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
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

/* compiled from: RequestListScreen.kt */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\u001a+\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u0001¢\u0006\u0002\u0010\u0007\u001a)\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003H\u0003¢\u0006\u0002\u0010\f¨\u0006\r²\u0006\n\u0010\u000e\u001a\u00020\u000fX\u008a\u0084\u0002"}, d2 = {"RequestListScreen", RoomRecommendViewModel.EMPTY_CURSOR, "onItemClick", "Lkotlin/Function1;", RoomRecommendViewModel.EMPTY_CURSOR, "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "(Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;II)V", "RequestJobCard", "jobData", "Lkntr/app/ad/domain/inspector/core/work/RequestJobData;", "onRequestClick", "(Lkntr/app/ad/domain/inspector/core/work/RequestJobData;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "ad-inspector_debug", "viewState", "Lkntr/app/ad/ui/inspector/ui/main/request/viewmodel/RequestListViewModelMVI$ViewState;"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class RequestListScreenKt {

    /* compiled from: RequestListScreen.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[RequestType.values().length];
            try {
                iArr[RequestType.API.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[RequestType.ADEXTRA.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RequestJobCard$lambda$1(RequestJobData requestJobData, Function1 function1, int i, Composer composer, int i2) {
        RequestJobCard(requestJobData, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RequestListScreen$lambda$4(Function1 function1, PaddingValues paddingValues, int i, int i2, Composer composer, int i3) {
        RequestListScreen(function1, paddingValues, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x034a, code lost:
        if (r5 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x0388, code lost:
        if (r15 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x02e1, code lost:
        if (r15 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L60;
     */
    /* JADX WARN: Removed duplicated region for block: B:103:0x034e  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0380  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x038c  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x03e6  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x052f  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x05fe  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x02ac  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x02b1  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x02bf  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x02c1  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x02d9  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x02e5  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0315  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x031a  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0328  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x032a  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0342  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void RequestListScreen(Function1<? super String, Unit> function1, PaddingValues paddingValues, Composer $composer, final int $changed, final int i) {
        final PaddingValues paddingValues2;
        final Function1<? super String, Unit> function12;
        Composer $composer2;
        PaddingValues paddingValues3;
        Function0 factory$iv$iv$iv;
        Object value$iv;
        boolean invalid$iv;
        boolean invalid$iv2;
        boolean invalid$iv3;
        Function0 factory$iv$iv$iv2;
        Intrinsics.checkNotNullParameter(function1, "onItemClick");
        Composer $composer3 = $composer.startRestartGroup(-831914566);
        ComposerKt.sourceInformation($composer3, "C(RequestListScreen)N(onItemClick,paddingValues)53@2458L38,55@2557L16,58@2645L93,58@2617L121,74@2987L5407:RequestListScreen.kt#wtdq44");
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
                ComposerKt.traceEventStart(-831914566, $dirty, -1, "kntr.app.ad.ui.inspector.ui.main.request.RequestListScreen (RequestListScreen.kt:52)");
            }
            ComposerKt.sourceInformationMarkerStart($composer3, -605976416, "CC(remember):RequestListScreen.kt#9igjgp");
            Object it$iv = $composer3.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv2 = new RequestListViewModelMVI();
                $composer3.updateRememberedValue(value$iv2);
                it$iv = value$iv2;
            }
            final RequestListViewModelMVI viewModel = (RequestListViewModelMVI) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            final State viewState$delegate = SnapshotStateKt.collectAsState(viewModel.getState(), (CoroutineContext) null, $composer3, 0, 1);
            ComposerKt.sourceInformationMarkerStart($composer3, -605970377, "CC(remember):RequestListScreen.kt#9igjgp");
            boolean invalid$iv4 = $composer3.changedInstance(viewModel);
            Object it$iv2 = $composer3.rememberedValue();
            if (invalid$iv4 || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv3 = new Function1() { // from class: kntr.app.ad.ui.inspector.ui.main.request.RequestListScreenKt$$ExternalSyntheticLambda7
                    public final Object invoke(Object obj) {
                        DisposableEffectResult RequestListScreen$lambda$2$0;
                        RequestListScreen$lambda$2$0 = RequestListScreenKt.RequestListScreen$lambda$2$0(RequestListViewModelMVI.this, (DisposableEffectScope) obj);
                        return RequestListScreen$lambda$2$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv3);
                it$iv2 = value$iv3;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            EffectsKt.DisposableEffect(viewModel, (Function1) it$iv2, $composer3, 0);
            final EnumEntries allSlots = AdSlot.getEntries();
            final EnumEntries allRequestTypes = RequestType.getEntries();
            boolean isAnyFilterActive = (RequestListScreen$lambda$1(viewState$delegate).getSelectedSlot() == null && RequestListScreen$lambda$1(viewState$delegate).getSelectedType() == null) ? false : true;
            Modifier modifier$iv = PaddingKt.padding(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), paddingValues3);
            PaddingValues paddingValues4 = paddingValues3;
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
            int $dirty2 = $dirty;
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
            ComposerKt.sourceInformationMarkerStart($composer3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i4 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 881998264, "C91@3614L187,102@4092L186,113@4571L187,83@3240L100,120@4830L2560,81@3145L4256,187@7411L41:RequestListScreen.kt#wtdq44");
            Integer num = RequestListScreen$lambda$1(viewState$delegate).getStatsCount().get(Status.SUCCESS);
            int intValue = num != null ? num.intValue() : 0;
            boolean z = RequestListScreen$lambda$1(viewState$delegate).getSelectedStatus() == Status.SUCCESS;
            ComposerKt.sourceInformationMarkerStart($composer3, -1911201141, "CC(remember):RequestListScreen.kt#9igjgp");
            boolean invalid$iv5 = $composer3.changedInstance(viewModel);
            Object it$iv3 = $composer3.rememberedValue();
            if (!invalid$iv5 && it$iv3 != Composer.Companion.getEmpty()) {
                value$iv = it$iv3;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                StatsPanelCountItem statsPanelCountItem = new StatsPanelCountItem(intValue, "成功", z, (Function0) value$iv);
                Integer num2 = RequestListScreen$lambda$1(viewState$delegate).getStatsCount().get(Status.FAILED);
                int intValue2 = num2 == null ? num2.intValue() : 0;
                boolean z2 = RequestListScreen$lambda$1(viewState$delegate).getSelectedStatus() != Status.FAILED;
                ComposerKt.sourceInformationMarkerStart($composer3, -1911185846, "CC(remember):RequestListScreen.kt#9igjgp");
                invalid$iv = $composer3.changedInstance(viewModel);
                Object it$iv4 = $composer3.rememberedValue();
                if (invalid$iv) {
                }
                Object value$iv4 = new Function0() { // from class: kntr.app.ad.ui.inspector.ui.main.request.RequestListScreenKt$$ExternalSyntheticLambda9
                    public final Object invoke() {
                        Unit RequestListScreen$lambda$3$1$0;
                        RequestListScreen$lambda$3$1$0 = RequestListScreenKt.RequestListScreen$lambda$3$1$0(RequestListViewModelMVI.this);
                        return RequestListScreen$lambda$3$1$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv4);
                it$iv4 = value$iv4;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                StatsPanelCountItem statsPanelCountItem2 = new StatsPanelCountItem(intValue2, "失败", z2, (Function0) it$iv4);
                Integer num3 = RequestListScreen$lambda$1(viewState$delegate).getStatsCount().get(Status.WARNING);
                int intValue3 = num3 == null ? num3.intValue() : 0;
                boolean z3 = RequestListScreen$lambda$1(viewState$delegate).getSelectedStatus() != Status.WARNING;
                ComposerKt.sourceInformationMarkerStart($composer3, -1911170517, "CC(remember):RequestListScreen.kt#9igjgp");
                invalid$iv2 = $composer3.changedInstance(viewModel);
                Object value$iv5 = $composer3.rememberedValue();
                if (invalid$iv2) {
                }
                value$iv5 = new Function0() { // from class: kntr.app.ad.ui.inspector.ui.main.request.RequestListScreenKt$$ExternalSyntheticLambda10
                    public final Object invoke() {
                        Unit RequestListScreen$lambda$3$2$0;
                        RequestListScreen$lambda$3$2$0 = RequestListScreenKt.RequestListScreen$lambda$3$2$0(RequestListViewModelMVI.this);
                        return RequestListScreen$lambda$3$2$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv5);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                StatsPanelCountItem statsPanelCountItem3 = new StatsPanelCountItem(intValue3, "告警", z3, (Function0) value$iv5);
                ComposerKt.sourceInformationMarkerStart($composer3, -1911213196, "CC(remember):RequestListScreen.kt#9igjgp");
                invalid$iv3 = $composer3.changedInstance(viewModel);
                Object it$iv5 = $composer3.rememberedValue();
                if (invalid$iv3) {
                }
                Object value$iv6 = new Function0() { // from class: kntr.app.ad.ui.inspector.ui.main.request.RequestListScreenKt$$ExternalSyntheticLambda11
                    public final Object invoke() {
                        Unit RequestListScreen$lambda$3$3$0;
                        RequestListScreen$lambda$3$3$0 = RequestListScreenKt.RequestListScreen$lambda$3$3$0(RequestListViewModelMVI.this);
                        return RequestListScreen$lambda$3$3$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv6);
                it$iv5 = value$iv6;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                StatsPanelKt.StatsPanel(isAnyFilterActive, (Function0) it$iv5, ComposableLambdaKt.rememberComposableLambda(-1593895580, true, new Function2() { // from class: kntr.app.ad.ui.inspector.ui.main.request.RequestListScreenKt$$ExternalSyntheticLambda12
                    public final Object invoke(Object obj, Object obj2) {
                        Unit RequestListScreen$lambda$3$4;
                        RequestListScreen$lambda$3$4 = RequestListScreenKt.RequestListScreen$lambda$3$4(allRequestTypes, viewModel, viewState$delegate, allSlots, (Composer) obj, ((Integer) obj2).intValue());
                        return RequestListScreen$lambda$3$4;
                    }
                }, $composer3, 54), statsPanelCountItem, statsPanelCountItem2, statsPanelCountItem3, $composer3, 384);
                SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(12)), $composer3, 6);
                if (RequestListScreen$lambda$1(viewState$delegate).isLoading()) {
                    if (RequestListScreen$lambda$1(viewState$delegate).getFilteredRequests().isEmpty()) {
                        $composer3.startReplaceGroup(886439261);
                        ComposerKt.sourceInformation($composer3, "200@7815L136");
                        EmptyViewKt.EmptyView("暂无数据", null, isAnyFilterActive ? "请尝试调整筛选条件" : "尝试创建一个新的请求", $composer3, 6, 2);
                        $composer3.endReplaceGroup();
                        function12 = function1;
                        $composer2 = $composer3;
                    } else {
                        $composer3.startReplaceGroup(886632205);
                        ComposerKt.sourceInformation($composer3, "208@8080L298,206@8003L375");
                        Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
                        ComposerKt.sourceInformationMarkerStart($composer3, -1911058118, "CC(remember):RequestListScreen.kt#9igjgp");
                        $composer2 = $composer3;
                        boolean invalid$iv6 = (($dirty2 & 14) == 4) | $composer2.changed(viewState$delegate);
                        Object it$iv6 = $composer3.rememberedValue();
                        if (invalid$iv6 || it$iv6 == Composer.Companion.getEmpty()) {
                            function12 = function1;
                            Object value$iv7 = new Function1() { // from class: kntr.app.ad.ui.inspector.ui.main.request.RequestListScreenKt$$ExternalSyntheticLambda13
                                public final Object invoke(Object obj) {
                                    Unit RequestListScreen$lambda$3$6$0;
                                    RequestListScreen$lambda$3$6$0 = RequestListScreenKt.RequestListScreen$lambda$3$6$0(viewState$delegate, function12, (LazyListScope) obj);
                                    return RequestListScreen$lambda$3$6$0;
                                }
                            };
                            $composer3.updateRememberedValue(value$iv7);
                            it$iv6 = value$iv7;
                        } else {
                            function12 = function1;
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        LazyDslKt.LazyColumn(fillMaxSize$default, (LazyListState) null, (PaddingValues) null, false, (Arrangement.Vertical) null, (Alignment.Horizontal) null, (FlingBehavior) null, false, (OverscrollEffect) null, (Function1) it$iv6, $composer3, 6, 510);
                        $composer3.endReplaceGroup();
                    }
                } else {
                    $composer3.startReplaceGroup(886165965);
                    ComposerKt.sourceInformation($composer3, "192@7540L182");
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
                    ComposerKt.sourceInformationMarkerStart($composer3, 858858071, "C196@7681L27:RequestListScreen.kt#wtdq44");
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
                }
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                paddingValues2 = paddingValues4;
            }
            value$iv = new Function0() { // from class: kntr.app.ad.ui.inspector.ui.main.request.RequestListScreenKt$$ExternalSyntheticLambda8
                public final Object invoke() {
                    Unit RequestListScreen$lambda$3$0$0;
                    RequestListScreen$lambda$3$0$0 = RequestListScreenKt.RequestListScreen$lambda$3$0$0(RequestListViewModelMVI.this);
                    return RequestListScreen$lambda$3$0$0;
                }
            };
            $composer3.updateRememberedValue(value$iv);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            StatsPanelCountItem statsPanelCountItem4 = new StatsPanelCountItem(intValue, "成功", z, (Function0) value$iv);
            Integer num22 = RequestListScreen$lambda$1(viewState$delegate).getStatsCount().get(Status.FAILED);
            if (num22 == null) {
            }
            if (RequestListScreen$lambda$1(viewState$delegate).getSelectedStatus() != Status.FAILED) {
            }
            ComposerKt.sourceInformationMarkerStart($composer3, -1911185846, "CC(remember):RequestListScreen.kt#9igjgp");
            invalid$iv = $composer3.changedInstance(viewModel);
            Object it$iv42 = $composer3.rememberedValue();
            if (invalid$iv) {
            }
            Object value$iv42 = new Function0() { // from class: kntr.app.ad.ui.inspector.ui.main.request.RequestListScreenKt$$ExternalSyntheticLambda9
                public final Object invoke() {
                    Unit RequestListScreen$lambda$3$1$0;
                    RequestListScreen$lambda$3$1$0 = RequestListScreenKt.RequestListScreen$lambda$3$1$0(RequestListViewModelMVI.this);
                    return RequestListScreen$lambda$3$1$0;
                }
            };
            $composer3.updateRememberedValue(value$iv42);
            it$iv42 = value$iv42;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            StatsPanelCountItem statsPanelCountItem22 = new StatsPanelCountItem(intValue2, "失败", z2, (Function0) it$iv42);
            Integer num32 = RequestListScreen$lambda$1(viewState$delegate).getStatsCount().get(Status.WARNING);
            if (num32 == null) {
            }
            if (RequestListScreen$lambda$1(viewState$delegate).getSelectedStatus() != Status.WARNING) {
            }
            ComposerKt.sourceInformationMarkerStart($composer3, -1911170517, "CC(remember):RequestListScreen.kt#9igjgp");
            invalid$iv2 = $composer3.changedInstance(viewModel);
            Object value$iv52 = $composer3.rememberedValue();
            if (invalid$iv2) {
            }
            value$iv52 = new Function0() { // from class: kntr.app.ad.ui.inspector.ui.main.request.RequestListScreenKt$$ExternalSyntheticLambda10
                public final Object invoke() {
                    Unit RequestListScreen$lambda$3$2$0;
                    RequestListScreen$lambda$3$2$0 = RequestListScreenKt.RequestListScreen$lambda$3$2$0(RequestListViewModelMVI.this);
                    return RequestListScreen$lambda$3$2$0;
                }
            };
            $composer3.updateRememberedValue(value$iv52);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            StatsPanelCountItem statsPanelCountItem32 = new StatsPanelCountItem(intValue3, "告警", z3, (Function0) value$iv52);
            ComposerKt.sourceInformationMarkerStart($composer3, -1911213196, "CC(remember):RequestListScreen.kt#9igjgp");
            invalid$iv3 = $composer3.changedInstance(viewModel);
            Object it$iv52 = $composer3.rememberedValue();
            if (invalid$iv3) {
            }
            Object value$iv62 = new Function0() { // from class: kntr.app.ad.ui.inspector.ui.main.request.RequestListScreenKt$$ExternalSyntheticLambda11
                public final Object invoke() {
                    Unit RequestListScreen$lambda$3$3$0;
                    RequestListScreen$lambda$3$3$0 = RequestListScreenKt.RequestListScreen$lambda$3$3$0(RequestListViewModelMVI.this);
                    return RequestListScreen$lambda$3$3$0;
                }
            };
            $composer3.updateRememberedValue(value$iv62);
            it$iv52 = value$iv62;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            StatsPanelKt.StatsPanel(isAnyFilterActive, (Function0) it$iv52, ComposableLambdaKt.rememberComposableLambda(-1593895580, true, new Function2() { // from class: kntr.app.ad.ui.inspector.ui.main.request.RequestListScreenKt$$ExternalSyntheticLambda12
                public final Object invoke(Object obj, Object obj2) {
                    Unit RequestListScreen$lambda$3$4;
                    RequestListScreen$lambda$3$4 = RequestListScreenKt.RequestListScreen$lambda$3$4(allRequestTypes, viewModel, viewState$delegate, allSlots, (Composer) obj, ((Integer) obj2).intValue());
                    return RequestListScreen$lambda$3$4;
                }
            }, $composer3, 54), statsPanelCountItem4, statsPanelCountItem22, statsPanelCountItem32, $composer3, 384);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(12)), $composer3, 6);
            if (RequestListScreen$lambda$1(viewState$delegate).isLoading()) {
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            if (ComposerKt.isTraceInProgress()) {
            }
            paddingValues2 = paddingValues4;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.ad.ui.inspector.ui.main.request.RequestListScreenKt$$ExternalSyntheticLambda14
                public final Object invoke(Object obj, Object obj2) {
                    Unit RequestListScreen$lambda$4;
                    RequestListScreen$lambda$4 = RequestListScreenKt.RequestListScreen$lambda$4(function12, paddingValues2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return RequestListScreen$lambda$4;
                }
            });
        }
    }

    private static final RequestListViewModelMVI.ViewState RequestListScreen$lambda$1(State<RequestListViewModelMVI.ViewState> state) {
        Object thisObj$iv = state.getValue();
        return (RequestListViewModelMVI.ViewState) thisObj$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult RequestListScreen$lambda$2$0(final RequestListViewModelMVI $viewModel, DisposableEffectScope $this$DisposableEffect) {
        Intrinsics.checkNotNullParameter($this$DisposableEffect, "$this$DisposableEffect");
        return new DisposableEffectResult() { // from class: kntr.app.ad.ui.inspector.ui.main.request.RequestListScreenKt$RequestListScreen$lambda$2$0$$inlined$onDispose$1
            public void dispose() {
                RequestListViewModelMVI.this.onCleared();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RequestListScreen$lambda$3$3$0(RequestListViewModelMVI $viewModel) {
        $viewModel.processIntent(RequestListViewModelMVI.Intent.ClearFilters.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RequestListScreen$lambda$3$0$0(RequestListViewModelMVI $viewModel) {
        $viewModel.processIntent(new RequestListViewModelMVI.Intent.SelectStatus(Status.SUCCESS));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RequestListScreen$lambda$3$1$0(RequestListViewModelMVI $viewModel) {
        $viewModel.processIntent(new RequestListViewModelMVI.Intent.SelectStatus(Status.FAILED));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RequestListScreen$lambda$3$2$0(RequestListViewModelMVI $viewModel) {
        $viewModel.processIntent(new RequestListViewModelMVI.Intent.SelectStatus(Status.WARNING));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RequestListScreen$lambda$3$4(final EnumEntries $allRequestTypes, final RequestListViewModelMVI $viewModel, final State $viewState$delegate, final EnumEntries $allSlots, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C124@4957L10,122@4874L206,128@5098L40,134@5381L761,130@5156L986,154@6160L41,159@6345L10,157@6263L205,163@6486L40,170@6807L569,166@6582L794:RequestListScreen.kt#wtdq44");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1593895580, $changed, -1, "kntr.app.ad.ui.inspector.ui.main.request.RequestListScreen.<anonymous>.<anonymous> (RequestListScreen.kt:122)");
            }
            TextKt.Text-Nvy7gAk("请求类型", (Modifier) null, ColorKt.Color(4285231744L), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, TextStyle.copy-p1EtxEg$default(MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getBodySmall(), 0L, 0L, FontWeight.Companion.getMedium(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777211, (Object) null), $composer, 390, 0, 131066);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(8)), $composer, 6);
            FlowLayoutKt.FlowRow(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(8)), Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(8)), (Alignment.Vertical) null, 0, 0, ComposableLambdaKt.rememberComposableLambda(1527973705, true, new Function3() { // from class: kntr.app.ad.ui.inspector.ui.main.request.RequestListScreenKt$$ExternalSyntheticLambda5
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit RequestListScreen$lambda$3$4$0;
                    RequestListScreen$lambda$3$4$0 = RequestListScreenKt.RequestListScreen$lambda$3$4$0($allRequestTypes, $viewModel, $viewState$delegate, (FlowRowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return RequestListScreen$lambda$3$4$0;
                }
            }, $composer, 54), $composer, 1573302, 56);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16)), $composer, 6);
            TextKt.Text-Nvy7gAk("广告位", (Modifier) null, ColorKt.Color(4285231744L), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, TextStyle.copy-p1EtxEg$default(MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getBodySmall(), 0L, 0L, FontWeight.Companion.getMedium(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777211, (Object) null), $composer, 390, 0, 131066);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(8)), $composer, 6);
            FlowLayoutKt.FlowRow(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(8)), Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(8)), (Alignment.Vertical) null, 0, 0, ComposableLambdaKt.rememberComposableLambda(1147159232, true, new Function3() { // from class: kntr.app.ad.ui.inspector.ui.main.request.RequestListScreenKt$$ExternalSyntheticLambda6
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit RequestListScreen$lambda$3$4$1;
                    RequestListScreen$lambda$3$4$1 = RequestListScreenKt.RequestListScreen$lambda$3$4$1($allSlots, $viewModel, $viewState$delegate, (FlowRowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return RequestListScreen$lambda$3$4$1;
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
    public static final Unit RequestListScreen$lambda$3$4$0(EnumEntries $allRequestTypes, final RequestListViewModelMVI $viewModel, State $viewState$delegate, FlowRowScope $this$FlowRow, Composer $composer, int $changed) {
        String typeName;
        Intrinsics.checkNotNullParameter($this$FlowRow, "$this$FlowRow");
        ComposerKt.sourceInformation($composer, "C*145@5868L207,142@5695L407:RequestListScreen.kt#wtdq44");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1527973705, $changed, -1, "kntr.app.ad.ui.inspector.ui.main.request.RequestListScreen.<anonymous>.<anonymous>.<anonymous> (RequestListScreen.kt:135)");
            }
            Iterable $this$forEach$iv = (Iterable) $allRequestTypes;
            for (Object element$iv : $this$forEach$iv) {
                final RequestType type = (RequestType) element$iv;
                switch (WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) {
                    case 1:
                        typeName = "API";
                        break;
                    case 2:
                        typeName = "AdExtra";
                        break;
                    default:
                        throw new NoWhenBranchMatchedException();
                }
                boolean z = RequestListScreen$lambda$1($viewState$delegate).getSelectedType() == type;
                ComposerKt.sourceInformationMarkerStart($composer, 2065744138, "CC(remember):RequestListScreen.kt#9igjgp");
                boolean invalid$iv = $composer.changedInstance($viewModel) | $composer.changed(type.ordinal());
                Object it$iv = $composer.rememberedValue();
                if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function0() { // from class: kntr.app.ad.ui.inspector.ui.main.request.RequestListScreenKt$$ExternalSyntheticLambda1
                        public final Object invoke() {
                            Unit RequestListScreen$lambda$3$4$0$0$0$0;
                            RequestListScreen$lambda$3$4$0$0$0$0 = RequestListScreenKt.RequestListScreen$lambda$3$4$0$0$0$0(RequestListViewModelMVI.this, type);
                            return RequestListScreen$lambda$3$4$0$0$0$0;
                        }
                    };
                    $composer.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                ComposerKt.sourceInformationMarkerEnd($composer);
                StatsPanelKt.CommonFilterItem(typeName, z, (Function0) it$iv, $composer, 0);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RequestListScreen$lambda$3$4$0$0$0$0(RequestListViewModelMVI $viewModel, RequestType $type) {
        $viewModel.processIntent(new RequestListViewModelMVI.Intent.SelectType($type));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RequestListScreen$lambda$3$4$1(EnumEntries $allSlots, final RequestListViewModelMVI $viewModel, State $viewState$delegate, FlowRowScope $this$FlowRow, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$FlowRow, "$this$FlowRow");
        ComposerKt.sourceInformation($composer, "C*176@7102L207,173@6940L396:RequestListScreen.kt#wtdq44");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1147159232, $changed, -1, "kntr.app.ad.ui.inspector.ui.main.request.RequestListScreen.<anonymous>.<anonymous>.<anonymous> (RequestListScreen.kt:171)");
            }
            Iterable $this$forEach$iv = (Iterable) $allSlots;
            for (Object element$iv : $this$forEach$iv) {
                final AdSlot slot = (AdSlot) element$iv;
                boolean z = RequestListScreen$lambda$1($viewState$delegate).getSelectedSlot() == slot;
                ComposerKt.sourceInformationMarkerStart($composer, -1192384369, "CC(remember):RequestListScreen.kt#9igjgp");
                boolean invalid$iv = $composer.changedInstance($viewModel) | $composer.changed(slot.ordinal());
                Object it$iv = $composer.rememberedValue();
                if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function0() { // from class: kntr.app.ad.ui.inspector.ui.main.request.RequestListScreenKt$$ExternalSyntheticLambda4
                        public final Object invoke() {
                            Unit RequestListScreen$lambda$3$4$1$0$0$0;
                            RequestListScreen$lambda$3$4$1$0$0$0 = RequestListScreenKt.RequestListScreen$lambda$3$4$1$0$0$0(RequestListViewModelMVI.this, slot);
                            return RequestListScreen$lambda$3$4$1$0$0$0;
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
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RequestListScreen$lambda$3$4$1$0$0$0(RequestListViewModelMVI $viewModel, AdSlot $slot) {
        $viewModel.processIntent(new RequestListViewModelMVI.Intent.SelectSlot($slot));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RequestListScreen$lambda$3$6$0(State $viewState$delegate, final Function1 $onItemClick, LazyListScope $this$LazyColumn) {
        Intrinsics.checkNotNullParameter($this$LazyColumn, "$this$LazyColumn");
        final List items$iv = RequestListScreen$lambda$1($viewState$delegate).getFilteredRequests();
        final Function1 contentType$iv = new Function1() { // from class: kntr.app.ad.ui.inspector.ui.main.request.RequestListScreenKt$RequestListScreen$lambda$3$6$0$$inlined$items$default$1
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                return m475invoke((RequestJobData) p1);
            }

            /* renamed from: invoke  reason: collision with other method in class */
            public final Void m475invoke(RequestJobData requestJobData) {
                return null;
            }
        };
        $this$LazyColumn.items(items$iv.size(), (Function1) null, new Function1<Integer, Object>() { // from class: kntr.app.ad.ui.inspector.ui.main.request.RequestListScreenKt$RequestListScreen$lambda$3$6$0$$inlined$items$default$3
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                return invoke(((Number) p1).intValue());
            }

            public final Object invoke(int index) {
                return contentType$iv.invoke(items$iv.get(index));
            }
        }, ComposableLambdaKt.composableLambdaInstance(802480018, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: kntr.app.ad.ui.inspector.ui.main.request.RequestListScreenKt$RequestListScreen$lambda$3$6$0$$inlined$items$default$4
            public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3, Object p4) {
                invoke((LazyItemScope) p1, ((Number) p2).intValue(), (Composer) p3, ((Number) p4).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(LazyItemScope $this$items, int it, Composer $composer, int $changed) {
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
                RequestJobData jobData = (RequestJobData) items$iv.get(it);
                $composer.startReplaceGroup(480266890);
                ComposerKt.sourceInformation($composer, "CN(jobData)*212@8212L134:RequestListScreen.kt#wtdq44");
                RequestListScreenKt.RequestJobCard(jobData, $onItemClick, $composer, RequestJobData.$stable | ((($dirty & 14) >> 3) & 14));
                $composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void RequestJobCard(final RequestJobData jobData, final Function1<? super String, Unit> function1, Composer $composer, final int $changed) {
        Composer $composer2;
        Composer $composer3 = $composer.startRestartGroup(1524182200);
        ComposerKt.sourceInformation($composer3, "C(RequestJobCard)N(jobData,onRequestClick)240@8860L4519,232@8626L4753:RequestListScreen.kt#wtdq44");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= ($changed & 8) == 0 ? $composer3.changed(jobData) : $composer3.changedInstance(jobData) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changedInstance(function1) ? 32 : 16;
        }
        int $dirty2 = $dirty;
        if ($composer3.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1524182200, $dirty2, -1, "kntr.app.ad.ui.inspector.ui.main.request.RequestJobCard (RequestListScreen.kt:227)");
            }
            final AdSlot adSlot = jobData.getSlot();
            $composer2 = $composer3;
            SurfaceKt.Surface-T9BRK9s(PaddingKt.padding-VpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, Dp.constructor-impl(6), 1, (Object) null), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(12)), Color.Companion.getWhite-0d7_KjU(), 0L, 0.0f, Dp.constructor-impl(1), (BorderStroke) null, ComposableLambdaKt.rememberComposableLambda(-847752045, true, new Function2() { // from class: kntr.app.ad.ui.inspector.ui.main.request.RequestListScreenKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    Unit RequestJobCard$lambda$0;
                    RequestJobCard$lambda$0 = RequestListScreenKt.RequestJobCard$lambda$0(function1, jobData, adSlot, (Composer) obj, ((Integer) obj2).intValue());
                    return RequestJobCard$lambda$0;
                }
            }, $composer3, 54), $composer3, 12779910, 88);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.ad.ui.inspector.ui.main.request.RequestListScreenKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    Unit RequestJobCard$lambda$1;
                    RequestJobCard$lambda$1 = RequestListScreenKt.RequestJobCard$lambda$1(RequestJobData.this, function1, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return RequestJobCard$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:79:0x08df  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit RequestJobCard$lambda$0(final Function1 $onRequestClick, final RequestJobData $jobData, AdSlot $adSlot, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Function0 factory$iv$iv$iv3;
        Function0 factory$iv$iv$iv4;
        ComposerKt.sourceInformation($composer, "C247@9093L30,242@8938L4435:RequestListScreen.kt#wtdq44");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-847752045, $changed, -1, "kntr.app.ad.ui.inspector.ui.main.request.RequestJobCard.<anonymous> (RequestListScreen.kt:242)");
            }
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, 1354078481, "CC(remember):RequestListScreen.kt#9igjgp");
            boolean invalid$iv = $composer.changed($onRequestClick) | $composer.changedInstance($jobData);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function0() { // from class: kntr.app.ad.ui.inspector.ui.main.request.RequestListScreenKt$$ExternalSyntheticLambda15
                    public final Object invoke() {
                        Unit RequestJobCard$lambda$0$0$0;
                        RequestJobCard$lambda$0$0$0 = RequestListScreenKt.RequestJobCard$lambda$0$0$0($onRequestClick, $jobData);
                        return RequestJobCard$lambda$0$0$0;
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
            ComposerKt.sourceInformationMarkerStart($composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i2 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, 198162667, "C251@9192L4171:RequestListScreen.kt#wtdq44");
            Modifier modifier$iv2 = PaddingKt.padding-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(16));
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer, ((390 >> 3) & 14) | ((390 >> 3) & 112));
            int $changed$iv$iv2 = (390 << 3) & 112;
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
            ComposerKt.sourceInformationMarkerStart($composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i4 = ((390 >> 6) & 112) | 6;
            RowScope $this$RequestJobCard_u24lambda_u240_u241_u240 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer, -273657873, "C259@9466L18,261@9502L40,264@9584L3024,341@12841L508,337@12650L699:RequestListScreen.kt#wtdq44");
            AdSlotIconKt.AdSlotIcon($adSlot, $composer, 0);
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(12)), $composer, 6);
            Modifier modifier$iv3 = RowScope.-CC.weight$default($this$RequestJobCard_u24lambda_u240_u241_u240, Modifier.Companion, 1.0f, false, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv3 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer, ((0 >> 3) & 14) | ((0 >> 3) & 112));
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
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
            int i5 = ($changed$iv$iv$iv3 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i6 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -719633927, "C268@9719L712,285@10453L40:RequestListScreen.kt#wtdq44");
            Alignment.Vertical verticalAlignment$iv2 = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Modifier modifier$iv4 = Modifier.Companion;
            Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.getStart();
            int $changed$iv$iv$iv4 = ((384 >> 3) & 14) | ((384 >> 3) & 112);
            MeasurePolicy measurePolicy$iv4 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer, $changed$iv$iv$iv4);
            int $changed$iv$iv4 = (384 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv4 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv4 = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer, modifier$iv4);
            Function0 factory$iv$iv$iv8 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv5 = (($changed$iv$iv4 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                factory$iv$iv$iv4 = factory$iv$iv$iv8;
                $composer.createNode(factory$iv$iv$iv4);
            } else {
                factory$iv$iv$iv4 = factory$iv$iv$iv8;
                $composer.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv4 = Updater.constructor-impl($composer);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, measurePolicy$iv4, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, localMap$iv$iv4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv4, Integer.valueOf(compositeKeyHash$iv$iv4), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv4, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, materialized$iv$iv4, ComposeUiNode.Companion.getSetModifier());
            int i7 = ($changed$iv$iv$iv5 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i8 = ((384 >> 6) & 112) | 6;
            RowScope $this$RequestJobCard_u24lambda_u240_u241_u240_u240_u240 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer, 1362945535, "C274@9981L10,271@9844L565:RequestListScreen.kt#wtdq44");
            String name = $jobData.getName();
            TextStyle textStyle = TextStyle.copy-p1EtxEg$default(MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getBodyLarge(), 0L, TextUnitKt.getSp(16), FontWeight.Companion.getMedium(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777209, (Object) null);
            TextKt.Text-Nvy7gAk(name, RowScope.-CC.weight$default($this$RequestJobCard_u24lambda_u240_u241_u240_u240_u240, Modifier.Companion, 1.0f, false, 2, (Object) null), ColorKt.Color(4280232247L), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, textStyle, $composer, 384, 24960, 110584);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(8)), $composer, 6);
            if ($jobData.getType() != RequestType.API || $jobData.getUrl() == null) {
                $composer.startReplaceGroup(-729365169);
            } else {
                $composer.startReplaceGroup(-718813761);
                ComposerKt.sourceInformation($composer, "292@10790L10,289@10644L446,300@11116L40");
                TextKt.Text-Nvy7gAk("url: " + $jobData.getUrl(), (Modifier) null, ColorKt.Color(4285231744L), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 2, 0, (Function1) null, TextStyle.copy-p1EtxEg$default(MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getBodySmall(), 0L, TextUnitKt.getSp(12), (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777213, (Object) null), $composer, 384, 24960, 110586);
                SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(4)), $composer, 6);
            }
            $composer.endReplaceGroup();
            if ($jobData.getDesc() != null) {
                $composer.startReplaceGroup(-718182787);
                ComposerKt.sourceInformation($composer, "308@11428L10,305@11280L448,316@11754L40");
                TextKt.Text-Nvy7gAk("desc: " + $jobData.getDesc(), (Modifier) null, ColorKt.Color(4285231744L), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 2, 0, (Function1) null, TextStyle.copy-p1EtxEg$default(MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getBodySmall(), 0L, TextUnitKt.getSp(12), (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777213, (Object) null), $composer, 384, 24960, 110586);
                SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(4)), $composer, 6);
            } else {
                $composer.startReplaceGroup(-729365169);
            }
            $composer.endReplaceGroup();
            if ($jobData.getRequestJson() != null) {
                String requestJson = $jobData.getRequestJson();
                String str = RoomRecommendViewModel.EMPTY_CURSOR;
                if (requestJson == null) {
                    requestJson = RoomRecommendViewModel.EMPTY_CURSOR;
                }
                if (requestJson.length() > 0) {
                    $composer.startReplaceGroup(-717470438);
                    ComposerKt.sourceInformation($composer, "326@12268L10,321@11971L597");
                    String requestJson2 = $jobData.getRequestJson();
                    if (requestJson2 == null) {
                        requestJson2 = RoomRecommendViewModel.EMPTY_CURSOR;
                    }
                    String take = StringsKt.take(requestJson2, 80);
                    String requestJson3 = $jobData.getRequestJson();
                    if (requestJson3 == null) {
                        requestJson3 = RoomRecommendViewModel.EMPTY_CURSOR;
                    }
                    if (requestJson3.length() > 80) {
                        str = "...";
                    }
                    TextKt.Text-Nvy7gAk("参数: " + take + str, (Modifier) null, ColorKt.Color(4285231744L), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, TextStyle.copy-p1EtxEg$default(MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getBodySmall(), 0L, TextUnitKt.getSp(12), (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777213, (Object) null), $composer, 384, 24960, 110586);
                    $composer.endReplaceGroup();
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    $composer.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    SurfaceKt.Surface-T9BRK9s(Modifier.Companion, RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(4)), Color.copy-wmQWz5c$default($jobData.getStatus().m325getColor0d7_KjU(), 0.1f, 0.0f, 0.0f, 0.0f, 14, (Object) null), 0L, 0.0f, 0.0f, (BorderStroke) null, ComposableLambdaKt.rememberComposableLambda(-1004127250, true, new Function2() { // from class: kntr.app.ad.ui.inspector.ui.main.request.RequestListScreenKt$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj, Object obj2) {
                            Unit RequestJobCard$lambda$0$1$0$1;
                            RequestJobCard$lambda$0$1$0$1 = RequestListScreenKt.RequestJobCard$lambda$0$1$0$1(RequestJobData.this, (Composer) obj, ((Integer) obj2).intValue());
                            return RequestJobCard$lambda$0$1$0$1;
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
            }
            $composer.startReplaceGroup(-729365169);
            $composer.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            SurfaceKt.Surface-T9BRK9s(Modifier.Companion, RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(4)), Color.copy-wmQWz5c$default($jobData.getStatus().m325getColor0d7_KjU(), 0.1f, 0.0f, 0.0f, 0.0f, 14, (Object) null), 0L, 0.0f, 0.0f, (BorderStroke) null, ComposableLambdaKt.rememberComposableLambda(-1004127250, true, new Function2() { // from class: kntr.app.ad.ui.inspector.ui.main.request.RequestListScreenKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit RequestJobCard$lambda$0$1$0$1;
                    RequestJobCard$lambda$0$1$0$1 = RequestListScreenKt.RequestJobCard$lambda$0$1$0$1(RequestJobData.this, (Composer) obj, ((Integer) obj2).intValue());
                    return RequestJobCard$lambda$0$1$0$1;
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
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RequestJobCard$lambda$0$0$0(Function1 $onRequestClick, RequestJobData $jobData) {
        $onRequestClick.invoke($jobData.getId());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RequestJobCard$lambda$0$1$0$1(RequestJobData $jobData, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C345@12995L10,342@12863L468:RequestListScreen.kt#wtdq44");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1004127250, $changed, -1, "kntr.app.ad.ui.inspector.ui.main.request.RequestJobCard.<anonymous>.<anonymous>.<anonymous>.<anonymous> (RequestListScreen.kt:342)");
            }
            TextKt.Text-Nvy7gAk($jobData.getStatus().getText(), PaddingKt.padding-VpY3zN4(Modifier.Companion, Dp.constructor-impl(6), Dp.constructor-impl(2)), $jobData.getStatus().m325getColor0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, TextStyle.copy-p1EtxEg$default(MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getBodySmall(), 0L, TextUnitKt.getSp(11), FontWeight.Companion.getMedium(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777209, (Object) null), $composer, 48, 0, 131064);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}