package kntr.app.deepsearch.history.ui;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.activity.OnBackPressedDispatcher;
import androidx.compose.foundation.BackgroundKt;
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
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import com.bilibili.compose.theme.BiliTheme;
import java.util.List;
import kntr.app.deepsearch.base.model.history.DSConversationItem;
import kntr.app.deepsearch.base.model.history.DSConversationSection;
import kntr.app.deepsearch.base.model.history.DSHistoryAction;
import kntr.app.deepsearch.base.model.history.DSHistoryData;
import kntr.app.deepsearch.base.model.history.DSHistoryPageStatus;
import kntr.app.deepsearch.stub.PageStub_androidKt;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.router.Router;
import kntr.common.compose.list.LoadMoreListStateKt;
import kntr.common.compose.pulltorefresh.PullToRefreshKt;
import kntr.common.compose.pulltorefresh.PullToRefreshState;
import kntr.common.compose.pulltorefresh.PullToRefreshStateKt;
import kntr.common.router.RouterKt;
import kntr.common.router.UrisKt;
import kntr.common.trio.pagecontroller.LocalOnBackPressedDispatcher;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.compose.resources.StringResource;
import org.jetbrains.compose.resources.StringResourcesKt;
import srcs.app.deepsearch.history.ui.generated.resources.Res;
import srcs.app.deepsearch.history.ui.generated.resources.String0_commonMainKt;

/* compiled from: History.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a3\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0007¢\u0006\u0002\u0010\t\u001a\u0019\u0010\n\u001a\u00020\u0001*\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0003¢\u0006\u0002\u0010\u000e\u001a-\u0010\u000f\u001a\u00020\u0001*\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00112\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00010\u0007H\u0003¢\u0006\u0002\u0010\u0013¨\u0006\u0014"}, d2 = {"HistoryList", RoomRecommendViewModel.EMPTY_CURSOR, "data", "Lkntr/app/deepsearch/base/model/history/DSHistoryData;", "modifier", "Landroidx/compose/ui/Modifier;", "dispatcher", "Lkotlin/Function1;", "Lkntr/app/deepsearch/base/model/history/DSHistoryAction;", "(Lkntr/app/deepsearch/base/model/history/DSHistoryData;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "Title", "Landroidx/compose/foundation/lazy/LazyItemScope;", "group", RoomRecommendViewModel.EMPTY_CURSOR, "(Landroidx/compose/foundation/lazy/LazyItemScope;Ljava/lang/String;Landroidx/compose/runtime/Composer;I)V", "Item", "item", "Lkntr/app/deepsearch/base/model/history/DSConversationItem;", "select", "(Landroidx/compose/foundation/lazy/LazyItemScope;Lkntr/app/deepsearch/base/model/history/DSConversationItem;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "history-ui_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class HistoryKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HistoryList$lambda$1(DSHistoryData dSHistoryData, Modifier modifier, Function1 function1, int i, int i2, Composer composer, int i3) {
        HistoryList(dSHistoryData, modifier, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Item$lambda$2(LazyItemScope lazyItemScope, DSConversationItem dSConversationItem, Function1 function1, int i, Composer composer, int i2) {
        Item(lazyItemScope, dSConversationItem, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Title$lambda$1(LazyItemScope lazyItemScope, String str, int i, Composer composer, int i2) {
        Title(lazyItemScope, str, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:53:0x01fb, code lost:
        if (r14 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L42;
     */
    /* JADX WARN: Removed duplicated region for block: B:68:0x02b6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void HistoryList(final DSHistoryData data, Modifier modifier, final Function1<? super DSHistoryAction, Unit> function1, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Modifier modifier$iv$iv;
        Modifier modifier3;
        Function0 factory$iv$iv$iv;
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(function1, "dispatcher");
        Composer $composer2 = $composer.startRestartGroup(-707392165);
        ComposerKt.sourceInformation($composer2, "C(HistoryList)N(data,modifier,dispatcher)59@2679L14,60@2723L17,54@2539L2710:History.kt#a2kngy");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(data) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changedInstance(function1) ? 256 : 128;
        }
        int $dirty2 = $dirty;
        if ($composer2.shouldExecute(($dirty2 & 147) != 146, $dirty2 & 1)) {
            if (i2 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-707392165, $dirty2, -1, "kntr.app.deepsearch.history.ui.HistoryList (History.kt:53)");
            }
            Modifier modifier$iv$iv2 = PaddingKt.padding-qDBjuR0$default(modifier3, 0.0f, 0.0f, 0.0f, WindowInsetsKt.asPaddingValues(WindowInsets_androidKt.getNavigationBars(WindowInsets.Companion, $composer2, 6), $composer2, 0).calculateBottomPadding-D9Ej5fM(), 7, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer2, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer2, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            modifier$iv$iv = modifier3;
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv$iv2);
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
            int i4 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -1727802478, "C64@2831L15,66@2875L28,68@2967L133,68@2913L187,74@3152L129,74@3110L171,83@3398L1845,80@3291L1952:History.kt#a2kngy");
            HistoryTopBarKt.HistoryTopBar(null, $composer2, 0, 1);
            PullToRefreshState refreshState = PullToRefreshStateKt.rememberPullToRefreshState-djqs-MU(0.0f, 0.0f, 0.0f, false, $composer2, 0, 15);
            Boolean valueOf = Boolean.valueOf(refreshState.isRefreshing());
            ComposerKt.sourceInformationMarkerStart($composer2, 914097834, "CC(remember):History.kt#9igjgp");
            boolean invalid$iv = $composer2.changed(refreshState) | (($dirty2 & 896) == 256);
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv) {
            }
            Object value$iv = (Function2) new HistoryKt$HistoryList$1$1$1(refreshState, function1, null);
            $composer2.updateRememberedValue(value$iv);
            it$iv = value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(valueOf, function1, (Function2) it$iv, $composer2, ($dirty2 >> 3) & 112);
            DSHistoryPageStatus status = data.getStatus();
            ComposerKt.sourceInformationMarkerStart($composer2, 914103750, "CC(remember):History.kt#9igjgp");
            boolean invalid$iv2 = $composer2.changedInstance(data) | $composer2.changed(refreshState);
            Object it$iv2 = $composer2.rememberedValue();
            if (!invalid$iv2 && it$iv2 != Composer.Companion.getEmpty()) {
                ComposerKt.sourceInformationMarkerEnd($composer2);
                EffectsKt.LaunchedEffect(status, refreshState, (Function2) it$iv2, $composer2, 0);
                PullToRefreshKt.PullToRefresh(refreshState, SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), (PaddingValues) null, (Function3) null, false, ComposableLambdaKt.rememberComposableLambda(-792099782, true, new Function2() { // from class: kntr.app.deepsearch.history.ui.HistoryKt$$ExternalSyntheticLambda4
                    public final Object invoke(Object obj, Object obj2) {
                        Unit HistoryList$lambda$0$2;
                        HistoryList$lambda$0$2 = HistoryKt.HistoryList$lambda$0$2(function1, data, (Composer) obj, ((Integer) obj2).intValue());
                        return HistoryList$lambda$0$2;
                    }
                }, $composer2, 54), $composer2, 196656, 28);
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
            Object value$iv2 = (Function2) new HistoryKt$HistoryList$1$2$1(data, refreshState, null);
            $composer2.updateRememberedValue(value$iv2);
            it$iv2 = value$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(status, refreshState, (Function2) it$iv2, $composer2, 0);
            PullToRefreshKt.PullToRefresh(refreshState, SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), (PaddingValues) null, (Function3) null, false, ComposableLambdaKt.rememberComposableLambda(-792099782, true, new Function2() { // from class: kntr.app.deepsearch.history.ui.HistoryKt$$ExternalSyntheticLambda4
                public final Object invoke(Object obj, Object obj2) {
                    Unit HistoryList$lambda$0$2;
                    HistoryList$lambda$0$2 = HistoryKt.HistoryList$lambda$0$2(function1, data, (Composer) obj, ((Integer) obj2).intValue());
                    return HistoryList$lambda$0$2;
                }
            }, $composer2, 54), $composer2, 196656, 28);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
            }
        } else {
            $composer2.skipToGroupEnd();
            modifier$iv$iv = modifier2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier4 = modifier$iv$iv;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.deepsearch.history.ui.HistoryKt$$ExternalSyntheticLambda5
                public final Object invoke(Object obj, Object obj2) {
                    Unit HistoryList$lambda$1;
                    HistoryList$lambda$1 = HistoryKt.HistoryList$lambda$1(DSHistoryData.this, modifier4, function1, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return HistoryList$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HistoryList$lambda$0$2(final Function1 $dispatcher, final DSHistoryData $data, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C84@3424L23,87@3530L79,85@3466L143,95@3799L1434,91@3623L1610:History.kt#a2kngy");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-792099782, $changed, -1, "kntr.app.deepsearch.history.ui.HistoryList.<anonymous>.<anonymous> (History.kt:84)");
            }
            LazyListState state = LazyListStateKt.rememberLazyListState(0, 0, $composer, 0, 3);
            ComposerKt.sourceInformationMarkerStart($composer, -998674807, "CC(remember):History.kt#9igjgp");
            boolean invalid$iv = $composer.changed($dispatcher);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = (Function1) new HistoryKt$HistoryList$1$3$1$1($dispatcher, null);
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            LoadMoreListStateKt.applyLoadMoreEffects(state, 5, (Function1) null, (Function1) it$iv, $composer, 48, 2);
            Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
            PaddingValues paddingValues = PaddingKt.PaddingValues-YgX7TsA$default(Dp.constructor-impl(16), 0.0f, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, -998664844, "CC(remember):History.kt#9igjgp");
            boolean invalid$iv2 = $composer.changedInstance($data) | $composer.changed($dispatcher);
            Object it$iv2 = $composer.rememberedValue();
            if (invalid$iv2 || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = new Function1() { // from class: kntr.app.deepsearch.history.ui.HistoryKt$$ExternalSyntheticLambda3
                    public final Object invoke(Object obj) {
                        Unit HistoryList$lambda$0$2$1$0;
                        HistoryList$lambda$0$2$1$0 = HistoryKt.HistoryList$lambda$0$2$1$0(DSHistoryData.this, $dispatcher, (LazyListScope) obj);
                        return HistoryList$lambda$0$2$1$0;
                    }
                };
                $composer.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            LazyDslKt.LazyColumn(fillMaxSize$default, state, paddingValues, false, (Arrangement.Vertical) null, (Alignment.Horizontal) null, (FlingBehavior) null, false, (OverscrollEffect) null, (Function1) it$iv2, $composer, 390, 504);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HistoryList$lambda$0$2$1$0(DSHistoryData $data, final Function1 $dispatcher, LazyListScope $this$LazyColumn) {
        Intrinsics.checkNotNullParameter($this$LazyColumn, "$this$LazyColumn");
        List $this$fastForEach$iv = $data.getGroups();
        int size = $this$fastForEach$iv.size();
        int index$iv = 0;
        while (index$iv < size) {
            Object item$iv = $this$fastForEach$iv.get(index$iv);
            final DSConversationSection it = (DSConversationSection) item$iv;
            LazyListScope.-CC.item$default($this$LazyColumn, (Object) null, (Object) null, ComposableLambdaKt.composableLambdaInstance(-2059116177, true, new Function3() { // from class: kntr.app.deepsearch.history.ui.HistoryKt$$ExternalSyntheticLambda6
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit HistoryList$lambda$0$2$1$0$0$0;
                    HistoryList$lambda$0$2$1$0$0$0 = HistoryKt.HistoryList$lambda$0$2$1$0$0$0(DSConversationSection.this, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return HistoryList$lambda$0$2$1$0$0$0;
                }
            }), 3, (Object) null);
            final List items$iv = it.getItems();
            final Function1 contentType$iv = new Function1() { // from class: kntr.app.deepsearch.history.ui.HistoryKt$HistoryList$lambda$0$2$1$0$0$$inlined$items$default$1
                public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                    return m653invoke((DSConversationItem) p1);
                }

                /* renamed from: invoke  reason: collision with other method in class */
                public final Void m653invoke(DSConversationItem dSConversationItem) {
                    return null;
                }
            };
            $this$LazyColumn.items(items$iv.size(), (Function1) null, new Function1<Integer, Object>() { // from class: kntr.app.deepsearch.history.ui.HistoryKt$HistoryList$lambda$0$2$1$0$0$$inlined$items$default$3
                public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                    return invoke(((Number) p1).intValue());
                }

                public final Object invoke(int index) {
                    return contentType$iv.invoke(items$iv.get(index));
                }
            }, ComposableLambdaKt.composableLambdaInstance(802480018, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: kntr.app.deepsearch.history.ui.HistoryKt$HistoryList$lambda$0$2$1$0$0$$inlined$items$default$4
                public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3, Object p4) {
                    invoke((LazyItemScope) p1, ((Number) p2).intValue(), (Composer) p3, ((Number) p4).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(LazyItemScope $this$items, int it2, Composer $composer, int $changed) {
                    ComposerKt.sourceInformation($composer, "CN(it)178@8834L22:LazyDsl.kt#428nma");
                    int $dirty = $changed;
                    if (($changed & 6) == 0) {
                        $dirty |= $composer.changed($this$items) ? 4 : 2;
                    }
                    if (($changed & 48) == 0) {
                        $dirty |= $composer.changed(it2) ? 32 : 16;
                    }
                    if (!$composer.shouldExecute(($dirty & 147) != 146, $dirty & 1)) {
                        $composer.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(802480018, $dirty, -1, "androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:178)");
                    }
                    int $changed2 = $dirty & 14;
                    final DSConversationItem item = (DSConversationItem) items$iv.get(it2);
                    $composer.startReplaceGroup(-1545496692);
                    ComposerKt.sourceInformation($composer, "CN(item)*108@4290L7,109@4381L7,110@4424L755,110@4413L766:History.kt#a2kngy");
                    CompositionLocal this_$iv = RouterKt.getLocalRouter();
                    ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object consume = $composer.consume(this_$iv);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    final Router route = (Router) consume;
                    final OnBackPressedDispatcher onBackPressedDispatcher = LocalOnBackPressedDispatcher.INSTANCE.getCurrent($composer, LocalOnBackPressedDispatcher.$stable);
                    ComposerKt.sourceInformationMarkerStart($composer, -1019681159, "CC(remember):History.kt#9igjgp");
                    boolean invalid$iv = $composer.changed($dispatcher) | $composer.changedInstance(item) | $composer.changedInstance(onBackPressedDispatcher) | $composer.changedInstance(route);
                    Object it$iv = $composer.rememberedValue();
                    if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                        final Function1 function1 = $dispatcher;
                        Object value$iv = (Function1) new Function1<DSConversationItem, Unit>() { // from class: kntr.app.deepsearch.history.ui.HistoryKt$HistoryList$1$3$2$1$1$2$1$1
                            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                                invoke((DSConversationItem) p1);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(DSConversationItem conversationItem) {
                                Intrinsics.checkNotNullParameter(conversationItem, "conversationItem");
                                function1.invoke(new DSHistoryAction.SelectItem(conversationItem));
                                if (item.isCurrent() && PageStub_androidKt.checkDetailPageStub(item.getItemId())) {
                                    onBackPressedDispatcher.onBackPressed();
                                } else {
                                    route.launch(UrisKt.toUri("bilibili://deepsearch/home").buildUpon().appendQueryParameter("session_id", conversationItem.getItemId()).build());
                                }
                            }
                        };
                        $composer.updateRememberedValue(value$iv);
                        it$iv = value$iv;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    HistoryKt.Item($this$items, item, (Function1) it$iv, $composer, ($changed2 & 14) | ($changed2 & 112));
                    $composer.endReplaceGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }));
            index$iv++;
            $this$fastForEach$iv = $this$fastForEach$iv;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HistoryList$lambda$0$2$1$0$0$0(DSConversationSection $it, LazyItemScope $this$item, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$item, "$this$item");
        ComposerKt.sourceInformation($composer, "C98@3917L4:History.kt#a2kngy");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer.changed($this$item) ? 4 : 2;
        }
        if (!$composer.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2059116177, $dirty, -1, "kntr.app.deepsearch.history.ui.HistoryList.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (History.kt:98)");
            }
            StringResource groupRes = DateDescKt.getDesc($it.getType(), $composer, 0);
            if (groupRes != null) {
                $composer.startReplaceGroup(1887963861);
                ComposerKt.sourceInformation($composer, "101@4045L24,100@3998L102");
                Title($this$item, StringResourcesKt.stringResource(groupRes, $composer, 0), $composer, $dirty & 14);
            } else {
                $composer.startReplaceGroup(1884021715);
            }
            $composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private static final void Title(final LazyItemScope $this$Title, final String group, Composer $composer, final int $changed) {
        Composer $composer2;
        Composer $composer3 = $composer.startRestartGroup(1982982918);
        ComposerKt.sourceInformation($composer3, "C(Title)N(group)133@5318L481:History.kt#a2kngy");
        int $dirty = $changed;
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changed(group) ? 32 : 16;
        }
        int $dirty2 = $dirty;
        if ($composer3.shouldExecute(($dirty2 & 17) != 16, $dirty2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1982982918, $dirty2, -1, "kntr.app.deepsearch.history.ui.Title (History.kt:132)");
            }
            Modifier modifier$iv = PaddingKt.padding-VpY3zN4$default(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, Dp.constructor-impl(16), 0.0f, Dp.constructor-impl(8), 5, (Object) null), 0.0f, 1, (Object) null), Dp.constructor-impl(20)), Dp.constructor-impl(12), 0.0f, 2, (Object) null);
            Alignment contentAlignment$iv = Alignment.Companion.getCenterStart();
            ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (54 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0 factory$iv$iv$iv = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                $composer3.createNode(factory$iv$iv$iv);
            } else {
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i2 = ((54 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 1298377593, "C144@5653L6,145@5697L9,142@5591L202:History.kt#a2kngy");
            $composer2 = $composer3;
            TextKt.Text-Nvy7gAk(group, (Modifier) null, BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT14(), $composer3, ($dirty2 >> 3) & 14, 24960, 110586);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.deepsearch.history.ui.HistoryKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    Unit Title$lambda$1;
                    Title$lambda$1 = HistoryKt.Title$lambda$1($this$Title, group, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return Title$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Item(final LazyItemScope $this$Item, final DSConversationItem item, final Function1<? super DSConversationItem, Unit> function1, Composer $composer, final int $changed) {
        Composer $composer2;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Composer $composer$iv;
        Composer $composer3;
        Composer $composer$iv$iv$iv;
        Function0 factory$iv$iv$iv3;
        Composer $composer4 = $composer.startRestartGroup(-2038961362);
        ComposerKt.sourceInformation($composer4, "C(Item)N(item,select)164@6142L6,166@6237L52,157@5927L2039:History.kt#a2kngy");
        int $dirty = $changed;
        if (($changed & 48) == 0) {
            $dirty |= $composer4.changedInstance(item) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer4.changedInstance(function1) ? 256 : 128;
        }
        if (!$composer4.shouldExecute(($dirty & 145) != 144, $dirty & 1)) {
            $composer2 = $composer4;
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2038961362, $dirty, -1, "kntr.app.deepsearch.history.ui.Item (History.kt:156)");
            }
            Modifier modifier = BackgroundKt.background-bw27NRU(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, 0.0f, Dp.constructor-impl(8), 7, (Object) null), 0.0f, 1, (Object) null), Dp.constructor-impl(45)), BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getBg1-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(12)));
            ComposerKt.sourceInformationMarkerStart($composer4, -936768606, "CC(remember):History.kt#9igjgp");
            boolean invalid$iv = $composer4.changedInstance(item) | (($dirty & 896) == 256);
            Object it$iv = $composer4.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function0() { // from class: kntr.app.deepsearch.history.ui.HistoryKt$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        Unit Item$lambda$0$0;
                        Item$lambda$0$0 = HistoryKt.Item$lambda$0$0(function1, item);
                        return Item$lambda$0$0;
                    }
                };
                $composer4.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer4);
            Modifier modifier$iv = PaddingKt.padding-VpY3zN4$default(ClickableKt.clickable-oSLSa3U$default(modifier, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null), Dp.constructor-impl(12), 0.0f, 2, (Object) null);
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getSpaceBetween();
            ComposerKt.sourceInformationMarkerStart($composer4, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer4, ((432 >> 3) & 14) | ((432 >> 3) & 112));
            int $changed$iv$iv = (432 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
            CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer4, modifier$iv);
            Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
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
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer4, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i2 = ((432 >> 6) & 112) | 6;
            RowScope $this$Item_u24lambda_u241 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer4, 1946802666, "C172@6449L1296,210@7837L6,211@7881L9,208@7755L205:History.kt#a2kngy");
            Modifier modifier$iv2 = $this$Item_u24lambda_u241.weight(Modifier.Companion, 1.0f, false);
            Alignment.Vertical verticalAlignment$iv2 = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer4, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer4, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv2 = (384 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer4.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer4, modifier$iv2);
            Function0 factory$iv$iv$iv5 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            $composer2 = $composer4;
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
            int i3 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer4, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i4 = ((384 >> 6) & 112) | 6;
            RowScope $this$Item_u24lambda_u241_u240 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer4, -649508269, "C178@6664L6,179@6712L9,176@6589L286:History.kt#a2kngy");
            TextKt.Text-Nvy7gAk(item.getTitle(), $this$Item_u24lambda_u241_u240.weight(Modifier.Companion, 1.0f, false), BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer4, BiliTheme.$stable).getT15(), $composer4, 0, 24960, 110584);
            if (item.isCurrent()) {
                $composer4.startReplaceGroup(-649200750);
                ComposerKt.sourceInformation($composer4, "192@7186L6,186@6927L794");
                Modifier modifier$iv3 = BackgroundKt.background-bw27NRU(SizeKt.size-VpY3zN4(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(8), 0.0f, 0.0f, 0.0f, 14, (Object) null), Dp.constructor-impl(60), Dp.constructor-impl(21)), BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getGa1-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(4)));
                Alignment contentAlignment$iv = Alignment.Companion.getCenter();
                ComposerKt.sourceInformationMarkerStart($composer4, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv3 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                int $changed$iv$iv3 = (48 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
                CompositionLocalMap localMap$iv$iv3 = $composer4.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer4, modifier$iv3);
                Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
                $composer$iv = $composer4;
                $composer$iv$iv$iv = $composer4;
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
                $composer3 = $composer4;
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
                int i5 = ($changed$iv$iv$iv3 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer4, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScope boxScope = BoxScopeInstance.INSTANCE;
                int i6 = ((48 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer4, -810391051, "C198@7429L42,199@7515L6,200@7571L9,197@7392L311:History.kt#a2kngy");
                TextKt.Text-Nvy7gAk(StringResourcesKt.stringResource(String0_commonMainKt.getHistory_current(Res.string.INSTANCE), $composer4, 0), (Modifier) null, BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getText2-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer4, BiliTheme.$stable).getT12(), $composer4, 0, 24960, 110586);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                $composer4.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
            } else {
                $composer$iv = $composer4;
                $composer3 = $composer4;
                $composer$iv$iv$iv = $composer4;
                $composer4.startReplaceGroup(-656081076);
            }
            $composer4.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            $composer4.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            Composer $composer5 = $composer3;
            TextKt.Text-Nvy7gAk(item.getTimeDescription().getDesc(), PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(8), 0.0f, 0.0f, 0.0f, 14, (Object) null), BiliTheme.INSTANCE.getColors($composer5, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer5, BiliTheme.$stable).getT12(), $composer5, 48, 0, 131064);
            ComposerKt.sourceInformationMarkerEnd($composer5);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            $composer$iv$iv$iv.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.deepsearch.history.ui.HistoryKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit Item$lambda$2;
                    Item$lambda$2 = HistoryKt.Item$lambda$2($this$Item, item, function1, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return Item$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Item$lambda$0$0(Function1 $select, DSConversationItem $item) {
        $select.invoke($item);
        return Unit.INSTANCE;
    }
}