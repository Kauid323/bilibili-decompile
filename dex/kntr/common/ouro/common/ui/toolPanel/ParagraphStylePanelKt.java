package kntr.common.ouro.common.ui.toolPanel;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.unit.Dp;
import bili.resource.ouro_editor.Ouro_editorRes;
import bili.resource.ouro_editor.String0_commonMainKt;
import com.bilibili.compose.theme.BiliTheme;
import java.util.NoSuchElementException;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.common.ui.toolPanel.component.SectionContentKt;
import kntr.common.ouro.common.ui.toolPanel.component.SectionHeaderKt;
import kntr.common.ouro.core.OuroState;
import kntr.common.ouro.core.OuroStore;
import kntr.common.ouro.core.action.OuroIndentAction;
import kntr.common.ouro.core.action.OuroInsertStoragesAction;
import kntr.common.ouro.core.action.OuroOutdentAction;
import kntr.common.ouro.core.action.OuroToggleOrderedListAction;
import kntr.common.ouro.core.action.OuroToggleQuoteAction;
import kntr.common.ouro.core.action.OuroToggleUnorderedListAction;
import kntr.common.ouro.core.dsl.BoxContainerBuilder;
import kntr.common.ouro.core.dsl.OuroNodeDSLKt;
import kntr.common.ouro.core.model.NodeStorage;
import kntr.common.ouro.core.plugin.OuroPluginState;
import kntr.common.ouro.core.plugin.paragraphStyle.OuroParagraphStylePlugin;
import kntr.common.ouro.core.plugin.paragraphStyle.OuroParagraphStyleState;
import kntr.common.ouro.core.plugin.paragraphStyle.OuroToggleTextAlignCenterAction;
import kntr.common.ouro.core.plugin.paragraphStyle.OuroToggleTextAlignEndAction;
import kntr.common.ouro.core.plugin.paragraphStyle.OuroToggleTextAlignStartAction;
import kntr.common.ouro.core.utils.IncreaseIndentCheckResult;
import kntr.common.ouro.core.utils.OuroLayoutUtilsKt;
import kntr.common.ouro.core.utils.OuroStateToolbarExtKt;
import kntr.common.ouro.preview.tool.CommonToolItemKt;
import kntr.common.trio.toast.Toaster;
import kntr.common.trio.toast.ToasterKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.jetbrains.compose.resources.ImageResourcesKt;
import org.jetbrains.compose.resources.StringResourcesKt;
import srcs.common.ouroboros.editor.common.ui.generated.resources.Drawable0_commonMainKt;
import srcs.common.ouroboros.editor.common.ui.generated.resources.Res;

/* compiled from: ParagraphStylePanel.kt */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\u001a;\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u001a\b\u0002\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\u0007H\u0007¢\u0006\u0002\u0010\n¨\u0006\u000b²\u0006\n\u0010\f\u001a\u00020\rX\u008a\u0084\u0002"}, d2 = {"ParagraphStylePanel", "", "ouroStore", "Lkntr/common/ouro/core/OuroStore;", "modifier", "Landroidx/compose/ui/Modifier;", "onTrackEvent", "Lkotlin/Function2;", "Lkntr/common/ouro/common/ui/toolPanel/ParagraphStylePanelEvent;", "", "(Lkntr/common/ouro/core/OuroStore;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "ui_debug", "state", "Lkntr/common/ouro/core/OuroState;"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ParagraphStylePanelKt {

    /* compiled from: ParagraphStylePanel.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[IncreaseIndentCheckResult.values().length];
            try {
                iArr[IncreaseIndentCheckResult.ALLOW.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[IncreaseIndentCheckResult.INCLUDE_UNINDENTABLE_ELEMENT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[IncreaseIndentCheckResult.REACHED_MAX_INDENT.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ParagraphStylePanel$lambda$3(OuroStore ouroStore, Modifier modifier, Function2 function2, int i, int i2, Composer composer, int i3) {
        ParagraphStylePanel(ouroStore, modifier, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ParagraphStylePanel$lambda$0$0(ParagraphStylePanelEvent paragraphStylePanelEvent, boolean z) {
        Intrinsics.checkNotNullParameter(paragraphStylePanelEvent, "<unused var>");
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v13 */
    public static final void ParagraphStylePanel(final OuroStore ouroStore, Modifier modifier, Function2<? super ParagraphStylePanelEvent, ? super Boolean, Unit> function2, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Function2 onTrackEvent;
        Composer $composer2;
        Modifier modifier3;
        Function2 onTrackEvent2;
        Intrinsics.checkNotNullParameter(ouroStore, "ouroStore");
        Composer $composer3 = $composer.startRestartGroup(99782019);
        ComposerKt.sourceInformation($composer3, "C(ParagraphStylePanel)N(ouroStore,modifier,onTrackEvent)69@3962L11,71@4016L16,75@4207L7,77@4272L6,77@4300L5983,77@4220L6063:ParagraphStylePanel.kt#wsnt7k");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changedInstance(ouroStore) ? 4 : 2;
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
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty |= 384;
            onTrackEvent = function2;
        } else if (($changed & 384) == 0) {
            onTrackEvent = function2;
            $dirty |= $composer3.changedInstance(onTrackEvent) ? 256 : 128;
        } else {
            onTrackEvent = function2;
        }
        int $dirty2 = $dirty;
        if ($composer3.shouldExecute(($dirty2 & 147) != 146, $dirty2 & 1)) {
            modifier3 = i2 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (i3 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer3, 1401244558, "CC(remember):ParagraphStylePanel.kt#9igjgp");
                Object it$iv = $composer3.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function2() { // from class: kntr.common.ouro.common.ui.toolPanel.ParagraphStylePanelKt$$ExternalSyntheticLambda16
                        public final Object invoke(Object obj, Object obj2) {
                            Unit ParagraphStylePanel$lambda$0$0;
                            ParagraphStylePanel$lambda$0$0 = ParagraphStylePanelKt.ParagraphStylePanel$lambda$0$0((ParagraphStylePanelEvent) obj, ((Boolean) obj2).booleanValue());
                            return ParagraphStylePanel$lambda$0$0;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                Function2 onTrackEvent3 = it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                onTrackEvent2 = onTrackEvent3;
            } else {
                onTrackEvent2 = onTrackEvent;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(99782019, $dirty2, -1, "kntr.common.ouro.common.ui.toolPanel.ParagraphStylePanel (ParagraphStylePanel.kt:70)");
            }
            final State state$delegate = SnapshotStateKt.collectAsState(ouroStore.getStateFlow(), (CoroutineContext) null, $composer3, 0, 1);
            OuroState this_$iv = ParagraphStylePanel$lambda$1(state$delegate);
            KClass key$iv = Reflection.getOrCreateKotlinClass(OuroParagraphStylePlugin.class);
            OuroPluginState ouroPluginState = this_$iv.getPluginStates().get(key$iv);
            OuroParagraphStyleState ouroParagraphStyleState = ouroPluginState instanceof OuroParagraphStyleState ? ouroPluginState : null;
            if (ouroParagraphStyleState == null) {
                throw new NoSuchElementException("No plugin state for " + key$iv);
            }
            final OuroParagraphStyleState paragraphMarkState = ouroParagraphStyleState;
            final IncreaseIndentCheckResult increaseIndentCheckResult = OuroStateToolbarExtKt.canIncreaseIndent(ParagraphStylePanel$lambda$1(state$delegate));
            CompositionLocal this_$iv2 = ToasterKt.getLocalToaster();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer3.consume(this_$iv2);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            final Toaster toaster = (Toaster) consume;
            Modifier modifier4 = PaddingKt.padding-3ABfNKs(BackgroundKt.background-bw27NRU$default(modifier3, BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getBg1-0d7_KjU(), (Shape) null, 2, (Object) null), Dp.constructor-impl(16));
            ComposerKt.sourceInformationMarkerStart($composer3, 1401261346, "CC(remember):ParagraphStylePanel.kt#9igjgp");
            boolean invalid$iv = $composer3.changedInstance(paragraphMarkState) | $composer3.changed(state$delegate) | $composer3.changedInstance(ouroStore) | (($dirty2 & 896) == 256) | $composer3.changed(increaseIndentCheckResult.ordinal()) | $composer3.changedInstance(toaster);
            Object value$iv2 = $composer3.rememberedValue();
            if (invalid$iv || value$iv2 == Composer.Companion.getEmpty()) {
                final Function2 function22 = onTrackEvent2;
                value$iv2 = new Function1() { // from class: kntr.common.ouro.common.ui.toolPanel.ParagraphStylePanelKt$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj) {
                        Unit ParagraphStylePanel$lambda$2$0;
                        ParagraphStylePanel$lambda$2$0 = ParagraphStylePanelKt.ParagraphStylePanel$lambda$2$0(OuroParagraphStyleState.this, ouroStore, function22, state$delegate, increaseIndentCheckResult, toaster, (LazyListScope) obj);
                        return ParagraphStylePanel$lambda$2$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv2);
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer2 = $composer3;
            LazyDslKt.LazyColumn(modifier4, (LazyListState) null, (PaddingValues) null, false, (Arrangement.Vertical) null, (Alignment.Horizontal) null, (FlingBehavior) null, false, (OverscrollEffect) null, (Function1) value$iv2, $composer2, 0, 510);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            onTrackEvent = onTrackEvent2;
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final Function2 function23 = onTrackEvent;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.common.ouro.common.ui.toolPanel.ParagraphStylePanelKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    Unit ParagraphStylePanel$lambda$3;
                    ParagraphStylePanel$lambda$3 = ParagraphStylePanelKt.ParagraphStylePanel$lambda$3(OuroStore.this, modifier5, function23, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return ParagraphStylePanel$lambda$3;
                }
            });
        }
    }

    private static final OuroState ParagraphStylePanel$lambda$1(State<OuroState> state) {
        Object thisObj$iv = state.getValue();
        return (OuroState) thisObj$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ParagraphStylePanel$lambda$2$0(final OuroParagraphStyleState $paragraphMarkState, final OuroStore $ouroStore, final Function2 $onTrackEvent, final State $state$delegate, final IncreaseIndentCheckResult $increaseIndentCheckResult, final Toaster $toaster, LazyListScope $this$LazyColumn) {
        Intrinsics.checkNotNullParameter($this$LazyColumn, "$this$LazyColumn");
        SectionHeaderKt.sectionHeader($this$LazyColumn, String0_commonMainKt.getOuro_editor_global_string_4(Ouro_editorRes.INSTANCE.getString()));
        SectionContentKt.sectionContent($this$LazyColumn, ComposableLambdaKt.composableLambdaInstance(2018759430, true, new Function3() { // from class: kntr.common.ouro.common.ui.toolPanel.ParagraphStylePanelKt$$ExternalSyntheticLambda12
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit ParagraphStylePanel$lambda$2$0$0;
                ParagraphStylePanel$lambda$2$0$0 = ParagraphStylePanelKt.ParagraphStylePanel$lambda$2$0$0(OuroParagraphStyleState.this, $ouroStore, $onTrackEvent, $state$delegate, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return ParagraphStylePanel$lambda$2$0$0;
            }
        }));
        SectionHeaderKt.sectionHeader($this$LazyColumn, String0_commonMainKt.getOuro_editor_global_string_8(Ouro_editorRes.INSTANCE.getString()));
        SectionContentKt.sectionContent($this$LazyColumn, ComposableLambdaKt.composableLambdaInstance(1487532463, true, new Function3() { // from class: kntr.common.ouro.common.ui.toolPanel.ParagraphStylePanelKt$$ExternalSyntheticLambda13
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit ParagraphStylePanel$lambda$2$0$1;
                ParagraphStylePanel$lambda$2$0$1 = ParagraphStylePanelKt.ParagraphStylePanel$lambda$2$0$1(IncreaseIndentCheckResult.this, $ouroStore, $onTrackEvent, $toaster, $state$delegate, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return ParagraphStylePanel$lambda$2$0$1;
            }
        }));
        SectionHeaderKt.sectionHeader($this$LazyColumn, String0_commonMainKt.getOuro_editor_global_string_11(Ouro_editorRes.INSTANCE.getString()));
        SectionContentKt.sectionContent($this$LazyColumn, ComposableLambdaKt.composableLambdaInstance(-783935282, true, new Function3() { // from class: kntr.common.ouro.common.ui.toolPanel.ParagraphStylePanelKt$$ExternalSyntheticLambda14
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit ParagraphStylePanel$lambda$2$0$2;
                ParagraphStylePanel$lambda$2$0$2 = ParagraphStylePanelKt.ParagraphStylePanel$lambda$2$0$2(OuroStore.this, $onTrackEvent, $state$delegate, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return ParagraphStylePanel$lambda$2$0$2;
            }
        }));
        SectionHeaderKt.sectionHeader($this$LazyColumn, String0_commonMainKt.getOuro_editor_global_string_14(Ouro_editorRes.INSTANCE.getString()));
        SectionContentKt.sectionContent($this$LazyColumn, ComposableLambdaKt.composableLambdaInstance(1239564269, true, new Function3() { // from class: kntr.common.ouro.common.ui.toolPanel.ParagraphStylePanelKt$$ExternalSyntheticLambda15
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit ParagraphStylePanel$lambda$2$0$3;
                ParagraphStylePanel$lambda$2$0$3 = ParagraphStylePanelKt.ParagraphStylePanel$lambda$2$0$3(OuroStore.this, $onTrackEvent, $state$delegate, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return ParagraphStylePanel$lambda$2$0$3;
            }
        }));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ParagraphStylePanel$lambda$2$0$0(OuroParagraphStyleState $paragraphMarkState, final OuroStore $ouroStore, final Function2 $onTrackEvent, State $state$delegate, RowScope $this$sectionContent, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$sectionContent, "$this$sectionContent");
        ComposerKt.sourceInformation($composer, "C81@4462L65,82@4555L48,86@4801L170,80@4420L566,92@5041L65,93@5134L50,97@5383L173,91@4999L572,103@5626L65,104@5719L49,108@5964L169,102@5584L564:ParagraphStylePanel.kt#wsnt7k");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer.changed($this$sectionContent) ? 4 : 2;
        }
        int $dirty2 = $dirty;
        if ($composer.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2018759430, $dirty2, -1, "kntr.common.ouro.common.ui.toolPanel.ParagraphStylePanel.<anonymous>.<anonymous>.<anonymous> (ParagraphStylePanel.kt:80)");
            }
            String stringResource = StringResourcesKt.stringResource(String0_commonMainKt.getOuro_editor_global_string_5(Ouro_editorRes.INSTANCE.getString()), $composer, 0);
            Painter painterResource = ImageResourcesKt.painterResource(Drawable0_commonMainKt.getToolbar_align_left(Res.drawable.INSTANCE), $composer, 0);
            boolean isTextAlignStart = $paragraphMarkState.isTextAlignStart();
            Modifier weight$default = RowScope.-CC.weight$default($this$sectionContent, Modifier.Companion, 1.0f, false, 2, (Object) null);
            boolean z = !OuroStateToolbarExtKt.canApplyAlignment(ParagraphStylePanel$lambda$1($state$delegate));
            ComposerKt.sourceInformationMarkerStart($composer, -1297392752, "CC(remember):ParagraphStylePanel.kt#9igjgp");
            boolean invalid$iv = $composer.changedInstance($ouroStore) | $composer.changed($onTrackEvent);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function0() { // from class: kntr.common.ouro.common.ui.toolPanel.ParagraphStylePanelKt$$ExternalSyntheticLambda9
                    public final Object invoke() {
                        Unit ParagraphStylePanel$lambda$2$0$0$0$0;
                        ParagraphStylePanel$lambda$2$0$0$0$0 = ParagraphStylePanelKt.ParagraphStylePanel$lambda$2$0$0$0$0(OuroStore.this, $onTrackEvent);
                        return ParagraphStylePanel$lambda$2$0$0$0$0;
                    }
                };
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            CommonToolItemKt.m2078TextImageToolItemCcamzx0((Function0) it$iv, weight$default, stringResource, null, painterResource, 0L, isTextAlignStart, z, false, $composer, Painter.$stable << 12, 296);
            String stringResource2 = StringResourcesKt.stringResource(String0_commonMainKt.getOuro_editor_global_string_6(Ouro_editorRes.INSTANCE.getString()), $composer, 0);
            Painter painterResource2 = ImageResourcesKt.painterResource(Drawable0_commonMainKt.getToolbar_align_center(Res.drawable.INSTANCE), $composer, 0);
            boolean isTextAlignCenter = $paragraphMarkState.isTextAlignCenter();
            Modifier weight$default2 = RowScope.-CC.weight$default($this$sectionContent, Modifier.Companion, 1.0f, false, 2, (Object) null);
            boolean z2 = !OuroStateToolbarExtKt.canApplyAlignment(ParagraphStylePanel$lambda$1($state$delegate));
            ComposerKt.sourceInformationMarkerStart($composer, -1297374125, "CC(remember):ParagraphStylePanel.kt#9igjgp");
            boolean invalid$iv2 = $composer.changedInstance($ouroStore) | $composer.changed($onTrackEvent);
            Object it$iv2 = $composer.rememberedValue();
            if (invalid$iv2 || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = new Function0() { // from class: kntr.common.ouro.common.ui.toolPanel.ParagraphStylePanelKt$$ExternalSyntheticLambda10
                    public final Object invoke() {
                        Unit ParagraphStylePanel$lambda$2$0$0$1$0;
                        ParagraphStylePanel$lambda$2$0$0$1$0 = ParagraphStylePanelKt.ParagraphStylePanel$lambda$2$0$0$1$0(OuroStore.this, $onTrackEvent);
                        return ParagraphStylePanel$lambda$2$0$0$1$0;
                    }
                };
                $composer.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            CommonToolItemKt.m2078TextImageToolItemCcamzx0((Function0) it$iv2, weight$default2, stringResource2, null, painterResource2, 0L, isTextAlignCenter, z2, false, $composer, Painter.$stable << 12, 296);
            String stringResource3 = StringResourcesKt.stringResource(String0_commonMainKt.getOuro_editor_global_string_7(Ouro_editorRes.INSTANCE.getString()), $composer, 0);
            Painter painterResource3 = ImageResourcesKt.painterResource(Drawable0_commonMainKt.getToolbar_align_right(Res.drawable.INSTANCE), $composer, 0);
            boolean isTextAlignEnd = $paragraphMarkState.isTextAlignEnd();
            Modifier weight$default3 = RowScope.-CC.weight$default($this$sectionContent, Modifier.Companion, 1.0f, false, 2, (Object) null);
            boolean z3 = !OuroStateToolbarExtKt.canApplyAlignment(ParagraphStylePanel$lambda$1($state$delegate));
            ComposerKt.sourceInformationMarkerStart($composer, -1297355537, "CC(remember):ParagraphStylePanel.kt#9igjgp");
            boolean invalid$iv3 = $composer.changedInstance($ouroStore) | $composer.changed($onTrackEvent);
            Object it$iv3 = $composer.rememberedValue();
            if (invalid$iv3 || it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv3 = new Function0() { // from class: kntr.common.ouro.common.ui.toolPanel.ParagraphStylePanelKt$$ExternalSyntheticLambda11
                    public final Object invoke() {
                        Unit ParagraphStylePanel$lambda$2$0$0$2$0;
                        ParagraphStylePanel$lambda$2$0$0$2$0 = ParagraphStylePanelKt.ParagraphStylePanel$lambda$2$0$0$2$0(OuroStore.this, $onTrackEvent);
                        return ParagraphStylePanel$lambda$2$0$0$2$0;
                    }
                };
                $composer.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            CommonToolItemKt.m2078TextImageToolItemCcamzx0((Function0) it$iv3, weight$default3, stringResource3, null, painterResource3, 0L, isTextAlignEnd, z3, false, $composer, Painter.$stable << 12, 296);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ParagraphStylePanel$lambda$2$0$0$0$0(OuroStore $ouroStore, Function2 $onTrackEvent) {
        $ouroStore.dispatch(OuroToggleTextAlignStartAction.INSTANCE);
        $onTrackEvent.invoke(ParagraphStylePanelEvent.ALIGNMENT_LEFT, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ParagraphStylePanel$lambda$2$0$0$1$0(OuroStore $ouroStore, Function2 $onTrackEvent) {
        $ouroStore.dispatch(OuroToggleTextAlignCenterAction.INSTANCE);
        $onTrackEvent.invoke(ParagraphStylePanelEvent.ALIGNMENT_CENTER, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ParagraphStylePanel$lambda$2$0$0$2$0(OuroStore $ouroStore, Function2 $onTrackEvent) {
        $ouroStore.dispatch(OuroToggleTextAlignEndAction.INSTANCE);
        $onTrackEvent.invoke(ParagraphStylePanelEvent.ALIGNMENT_RIGHT, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ParagraphStylePanel$lambda$2$0$1(final IncreaseIndentCheckResult $increaseIndentCheckResult, final OuroStore $ouroStore, final Function2 $onTrackEvent, final Toaster $toaster, State $state$delegate, RowScope $this$sectionContent, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$sectionContent, "$this$sectionContent");
        ComposerKt.sourceInformation($composer, "C117@6319L65,118@6412L44,122@6662L531,116@6277L931,134@7263L66,135@7357L45,138@7534L160,133@7221L488:ParagraphStylePanel.kt#wsnt7k");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer.changed($this$sectionContent) ? 4 : 2;
        }
        int $dirty2 = $dirty;
        if ($composer.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1487532463, $dirty2, -1, "kntr.common.ouro.common.ui.toolPanel.ParagraphStylePanel.<anonymous>.<anonymous>.<anonymous> (ParagraphStylePanel.kt:116)");
            }
            String stringResource = StringResourcesKt.stringResource(String0_commonMainKt.getOuro_editor_global_string_9(Ouro_editorRes.INSTANCE.getString()), $composer, 0);
            Painter painterResource = ImageResourcesKt.painterResource(Drawable0_commonMainKt.getToolbar_indent(Res.drawable.INSTANCE), $composer, 0);
            Modifier weight$default = RowScope.-CC.weight$default($this$sectionContent, Modifier.Companion, 1.0f, false, 2, (Object) null);
            boolean z = $increaseIndentCheckResult != IncreaseIndentCheckResult.ALLOW;
            ComposerKt.sourceInformationMarkerStart($composer, -705399326, "CC(remember):ParagraphStylePanel.kt#9igjgp");
            boolean invalid$iv = $composer.changed($increaseIndentCheckResult.ordinal()) | $composer.changedInstance($ouroStore) | $composer.changed($onTrackEvent) | $composer.changedInstance($toaster);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function0() { // from class: kntr.common.ouro.common.ui.toolPanel.ParagraphStylePanelKt$$ExternalSyntheticLambda3
                    public final Object invoke() {
                        Unit ParagraphStylePanel$lambda$2$0$1$0$0;
                        ParagraphStylePanel$lambda$2$0$1$0$0 = ParagraphStylePanelKt.ParagraphStylePanel$lambda$2$0$1$0$0(IncreaseIndentCheckResult.this, $ouroStore, $onTrackEvent, $toaster);
                        return ParagraphStylePanel$lambda$2$0$1$0$0;
                    }
                };
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            CommonToolItemKt.m2078TextImageToolItemCcamzx0((Function0) it$iv, weight$default, stringResource, null, painterResource, 0L, false, false, z, $composer, (Painter.$stable << 12) | 12582912, 104);
            String stringResource2 = StringResourcesKt.stringResource(String0_commonMainKt.getOuro_editor_global_string_10(Ouro_editorRes.INSTANCE.getString()), $composer, 0);
            Painter painterResource2 = ImageResourcesKt.painterResource(Drawable0_commonMainKt.getToolbar_outdent(Res.drawable.INSTANCE), $composer, 0);
            Modifier weight$default2 = RowScope.-CC.weight$default($this$sectionContent, Modifier.Companion, 1.0f, false, 2, (Object) null);
            boolean z2 = !OuroStateToolbarExtKt.canDecreaseIndent(ParagraphStylePanel$lambda$1($state$delegate));
            ComposerKt.sourceInformationMarkerStart($composer, -705371793, "CC(remember):ParagraphStylePanel.kt#9igjgp");
            boolean invalid$iv2 = $composer.changedInstance($ouroStore) | $composer.changed($onTrackEvent);
            Object it$iv2 = $composer.rememberedValue();
            if (invalid$iv2 || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = new Function0() { // from class: kntr.common.ouro.common.ui.toolPanel.ParagraphStylePanelKt$$ExternalSyntheticLambda4
                    public final Object invoke() {
                        Unit ParagraphStylePanel$lambda$2$0$1$1$0;
                        ParagraphStylePanel$lambda$2$0$1$1$0 = ParagraphStylePanelKt.ParagraphStylePanel$lambda$2$0$1$1$0(OuroStore.this, $onTrackEvent);
                        return ParagraphStylePanel$lambda$2$0$1$1$0;
                    }
                };
                $composer.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            CommonToolItemKt.m2078TextImageToolItemCcamzx0((Function0) it$iv2, weight$default2, stringResource2, null, painterResource2, 0L, false, z2, false, $composer, Painter.$stable << 12, 360);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ParagraphStylePanel$lambda$2$0$1$0$0(IncreaseIndentCheckResult $increaseIndentCheckResult, OuroStore $ouroStore, Function2 $onTrackEvent, Toaster $toaster) {
        switch (WhenMappings.$EnumSwitchMapping$0[$increaseIndentCheckResult.ordinal()]) {
            case 1:
                $ouroStore.dispatch(new OuroIndentAction(null, null, 3, null));
                $onTrackEvent.invoke(ParagraphStylePanelEvent.INCREASE_INDENT, true);
                break;
            case 2:
                break;
            case 3:
                Toaster.CC.showToast$default($toaster, "当前内容块已达最大缩进层级", null, 2, null);
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ParagraphStylePanel$lambda$2$0$1$1$0(OuroStore $ouroStore, Function2 $onTrackEvent) {
        $ouroStore.dispatch(new OuroOutdentAction(null, null, 3, null));
        $onTrackEvent.invoke(ParagraphStylePanelEvent.DECREASE_INDENT, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ParagraphStylePanel$lambda$2$0$2(final OuroStore $ouroStore, final Function2 $onTrackEvent, final State $state$delegate, RowScope $this$sectionContent, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$sectionContent, "$this$sectionContent");
        ComposerKt.sourceInformation($composer, "C147@7881L66,148@7975L52,152@8208L191,146@7839L575,158@8469L66,159@8563L50,163@8792L185,157@8427L565:ParagraphStylePanel.kt#wsnt7k");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer.changed($this$sectionContent) ? 4 : 2;
        }
        int $dirty2 = $dirty;
        if ($composer.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-783935282, $dirty2, -1, "kntr.common.ouro.common.ui.toolPanel.ParagraphStylePanel.<anonymous>.<anonymous>.<anonymous> (ParagraphStylePanel.kt:146)");
            }
            String stringResource = StringResourcesKt.stringResource(String0_commonMainKt.getOuro_editor_global_string_12(Ouro_editorRes.INSTANCE.getString()), $composer, 0);
            Painter painterResource = ImageResourcesKt.painterResource(Drawable0_commonMainKt.getToolbar_unordered_list(Res.drawable.INSTANCE), $composer, 0);
            Modifier weight$default = RowScope.-CC.weight$default($this$sectionContent, Modifier.Companion, 1.0f, false, 2, (Object) null);
            boolean inUnorderedList = OuroStateToolbarExtKt.inUnorderedList(ParagraphStylePanel$lambda$1($state$delegate));
            boolean z = !OuroStateToolbarExtKt.canApplyList(ParagraphStylePanel$lambda$1($state$delegate));
            ComposerKt.sourceInformationMarkerStart($composer, -1742516755, "CC(remember):ParagraphStylePanel.kt#9igjgp");
            boolean invalid$iv = $composer.changedInstance($ouroStore) | $composer.changed($onTrackEvent) | $composer.changed($state$delegate);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function0() { // from class: kntr.common.ouro.common.ui.toolPanel.ParagraphStylePanelKt$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        Unit ParagraphStylePanel$lambda$2$0$2$0$0;
                        ParagraphStylePanel$lambda$2$0$2$0$0 = ParagraphStylePanelKt.ParagraphStylePanel$lambda$2$0$2$0$0(OuroStore.this, $onTrackEvent, $state$delegate);
                        return ParagraphStylePanel$lambda$2$0$2$0$0;
                    }
                };
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            CommonToolItemKt.m2078TextImageToolItemCcamzx0((Function0) it$iv, weight$default, stringResource, null, painterResource, 0L, inUnorderedList, z, false, $composer, Painter.$stable << 12, 296);
            String stringResource2 = StringResourcesKt.stringResource(String0_commonMainKt.getOuro_editor_global_string_13(Ouro_editorRes.INSTANCE.getString()), $composer, 0);
            Painter painterResource2 = ImageResourcesKt.painterResource(Drawable0_commonMainKt.getToolbar_ordered_list(Res.drawable.INSTANCE), $composer, 0);
            Modifier weight$default2 = RowScope.-CC.weight$default($this$sectionContent, Modifier.Companion, 1.0f, false, 2, (Object) null);
            boolean inOrderedList = OuroStateToolbarExtKt.inOrderedList(ParagraphStylePanel$lambda$1($state$delegate));
            boolean z2 = !OuroStateToolbarExtKt.canApplyList(ParagraphStylePanel$lambda$1($state$delegate));
            ComposerKt.sourceInformationMarkerStart($composer, -1742498073, "CC(remember):ParagraphStylePanel.kt#9igjgp");
            boolean invalid$iv2 = $composer.changedInstance($ouroStore) | $composer.changed($onTrackEvent) | $composer.changed($state$delegate);
            Object it$iv2 = $composer.rememberedValue();
            if (invalid$iv2 || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = new Function0() { // from class: kntr.common.ouro.common.ui.toolPanel.ParagraphStylePanelKt$$ExternalSyntheticLambda8
                    public final Object invoke() {
                        Unit ParagraphStylePanel$lambda$2$0$2$1$0;
                        ParagraphStylePanel$lambda$2$0$2$1$0 = ParagraphStylePanelKt.ParagraphStylePanel$lambda$2$0$2$1$0(OuroStore.this, $onTrackEvent, $state$delegate);
                        return ParagraphStylePanel$lambda$2$0$2$1$0;
                    }
                };
                $composer.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            CommonToolItemKt.m2078TextImageToolItemCcamzx0((Function0) it$iv2, weight$default2, stringResource2, null, painterResource2, 0L, inOrderedList, z2, false, $composer, Painter.$stable << 12, 296);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ParagraphStylePanel$lambda$2$0$2$0$0(OuroStore $ouroStore, Function2 $onTrackEvent, State $state$delegate) {
        $ouroStore.dispatch(new OuroToggleUnorderedListAction(null, null, 3, null));
        $onTrackEvent.invoke(ParagraphStylePanelEvent.UNORDERED_LIST, Boolean.valueOf(!OuroStateToolbarExtKt.inUnorderedList(ParagraphStylePanel$lambda$1($state$delegate))));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ParagraphStylePanel$lambda$2$0$2$1$0(OuroStore $ouroStore, Function2 $onTrackEvent, State $state$delegate) {
        $ouroStore.dispatch(new OuroToggleOrderedListAction(null, null, 3, null));
        $onTrackEvent.invoke(ParagraphStylePanelEvent.ORDERED_LIST, Boolean.valueOf(!OuroStateToolbarExtKt.inOrderedList(ParagraphStylePanel$lambda$1($state$delegate))));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ParagraphStylePanel$lambda$2$0$3(final OuroStore $ouroStore, final Function2 $onTrackEvent, final State $state$delegate, RowScope $this$sectionContent, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$sectionContent, "$this$sectionContent");
        ComposerKt.sourceInformation($composer, "C172@9164L66,173@9258L43,177@9485L171,171@9122L549,183@9726L66,184@9820L45,187@9996L256,182@9684L583:ParagraphStylePanel.kt#wsnt7k");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer.changed($this$sectionContent) ? 4 : 2;
        }
        int $dirty2 = $dirty;
        if ($composer.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1239564269, $dirty2, -1, "kntr.common.ouro.common.ui.toolPanel.ParagraphStylePanel.<anonymous>.<anonymous>.<anonymous> (ParagraphStylePanel.kt:171)");
            }
            String stringResource = StringResourcesKt.stringResource(String0_commonMainKt.getOuro_editor_global_string_15(Ouro_editorRes.INSTANCE.getString()), $composer, 0);
            Painter painterResource = ImageResourcesKt.painterResource(Drawable0_commonMainKt.getToolbar_quote(Res.drawable.INSTANCE), $composer, 0);
            Modifier weight$default = RowScope.-CC.weight$default($this$sectionContent, Modifier.Companion, 1.0f, false, 2, (Object) null);
            boolean inQuoteBlock = OuroStateToolbarExtKt.inQuoteBlock(ParagraphStylePanel$lambda$1($state$delegate));
            boolean z = !OuroStateToolbarExtKt.canApplyQuoteBlock(ParagraphStylePanel$lambda$1($state$delegate));
            ComposerKt.sourceInformationMarkerStart($composer, 1515333752, "CC(remember):ParagraphStylePanel.kt#9igjgp");
            boolean invalid$iv = $composer.changedInstance($ouroStore) | $composer.changed($onTrackEvent) | $composer.changed($state$delegate);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function0() { // from class: kntr.common.ouro.common.ui.toolPanel.ParagraphStylePanelKt$$ExternalSyntheticLambda6
                    public final Object invoke() {
                        Unit ParagraphStylePanel$lambda$2$0$3$0$0;
                        ParagraphStylePanel$lambda$2$0$3$0$0 = ParagraphStylePanelKt.ParagraphStylePanel$lambda$2$0$3$0$0(OuroStore.this, $onTrackEvent, $state$delegate);
                        return ParagraphStylePanel$lambda$2$0$3$0$0;
                    }
                };
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            CommonToolItemKt.m2078TextImageToolItemCcamzx0((Function0) it$iv, weight$default, stringResource, null, painterResource, 0L, inQuoteBlock, z, false, $composer, Painter.$stable << 12, 296);
            String stringResource2 = StringResourcesKt.stringResource(String0_commonMainKt.getOuro_editor_global_string_16(Ouro_editorRes.INSTANCE.getString()), $composer, 0);
            Painter painterResource2 = ImageResourcesKt.painterResource(Drawable0_commonMainKt.getToolbar_divider(Res.drawable.INSTANCE), $composer, 0);
            Modifier weight$default2 = RowScope.-CC.weight$default($this$sectionContent, Modifier.Companion, 1.0f, false, 2, (Object) null);
            boolean z2 = !OuroStateToolbarExtKt.canInsertDivider(ParagraphStylePanel$lambda$1($state$delegate));
            ComposerKt.sourceInformationMarkerStart($composer, 1515350189, "CC(remember):ParagraphStylePanel.kt#9igjgp");
            boolean invalid$iv2 = $composer.changedInstance($ouroStore) | $composer.changed($onTrackEvent);
            Object it$iv2 = $composer.rememberedValue();
            if (invalid$iv2 || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = new Function0() { // from class: kntr.common.ouro.common.ui.toolPanel.ParagraphStylePanelKt$$ExternalSyntheticLambda7
                    public final Object invoke() {
                        Unit ParagraphStylePanel$lambda$2$0$3$1$0;
                        ParagraphStylePanel$lambda$2$0$3$1$0 = ParagraphStylePanelKt.ParagraphStylePanel$lambda$2$0$3$1$0(OuroStore.this, $onTrackEvent);
                        return ParagraphStylePanel$lambda$2$0$3$1$0;
                    }
                };
                $composer.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            CommonToolItemKt.m2078TextImageToolItemCcamzx0((Function0) it$iv2, weight$default2, stringResource2, null, painterResource2, 0L, false, z2, false, $composer, Painter.$stable << 12, 360);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ParagraphStylePanel$lambda$2$0$3$0$0(OuroStore $ouroStore, Function2 $onTrackEvent, State $state$delegate) {
        $ouroStore.dispatch(new OuroToggleQuoteAction(null, null, 3, null));
        $onTrackEvent.invoke(ParagraphStylePanelEvent.QUOTE, Boolean.valueOf(!OuroStateToolbarExtKt.inQuoteBlock(ParagraphStylePanel$lambda$1($state$delegate))));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ParagraphStylePanel$lambda$2$0$3$1$0(OuroStore $ouroStore, Function2 $onTrackEvent) {
        NodeStorage divider = OuroNodeDSLKt.BoxContainer(OuroLayoutUtilsKt.getDividerDefaultMarks(), new Function1() { // from class: kntr.common.ouro.common.ui.toolPanel.ParagraphStylePanelKt$$ExternalSyntheticLambda5
            public final Object invoke(Object obj) {
                Unit ParagraphStylePanel$lambda$2$0$3$1$0$0;
                ParagraphStylePanel$lambda$2$0$3$1$0$0 = ParagraphStylePanelKt.ParagraphStylePanel$lambda$2$0$3$1$0$0((BoxContainerBuilder) obj);
                return ParagraphStylePanel$lambda$2$0$3$1$0$0;
            }
        });
        $ouroStore.dispatch(new OuroInsertStoragesAction(CollectionsKt.listOf(divider), null, null, 6, null));
        $onTrackEvent.invoke(ParagraphStylePanelEvent.DIVIDER, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ParagraphStylePanel$lambda$2$0$3$1$0$0(BoxContainerBuilder $this$BoxContainer) {
        Intrinsics.checkNotNullParameter($this$BoxContainer, "$this$BoxContainer");
        $this$BoxContainer.Divider();
        return Unit.INSTANCE;
    }
}