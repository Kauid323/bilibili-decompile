package kntr.common.ouro.common.ui.toolPanel;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
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
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Dp;
import bili.resource.ouro_editor.Ouro_editorRes;
import bili.resource.ouro_editor.String0_commonMainKt;
import com.bilibili.compose.theme.BiliTheme;
import com.bilibili.compose.theme.BiliThemeKt;
import com.bilibili.compose.theme.ThemeDayNight;
import java.util.List;
import java.util.NoSuchElementException;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.common.ui.toolPanel.component.SectionContentKt;
import kntr.common.ouro.common.ui.toolPanel.component.SectionHeaderKt;
import kntr.common.ouro.core.OuroState;
import kntr.common.ouro.core.OuroStore;
import kntr.common.ouro.core.model.mark.OuroColor;
import kntr.common.ouro.core.plugin.OuroPluginState;
import kntr.common.ouro.core.plugin.paragraphStyle.OuroParagraphStylePlugin;
import kntr.common.ouro.core.plugin.paragraphStyle.OuroParagraphStyleState;
import kntr.common.ouro.core.plugin.paragraphStyle.OuroToggleH1Action;
import kntr.common.ouro.core.plugin.paragraphStyle.OuroToggleH2Action;
import kntr.common.ouro.core.plugin.paragraphStyle.OuroToggleH3Action;
import kntr.common.ouro.core.plugin.paragraphStyle.OuroToggleTextAction;
import kntr.common.ouro.core.plugin.textStyle.OuroChangeBackgroundColor;
import kntr.common.ouro.core.plugin.textStyle.OuroChangeForegroundColor;
import kntr.common.ouro.core.plugin.textStyle.OuroTextStyle;
import kntr.common.ouro.core.plugin.textStyle.OuroTextStylePlugin;
import kntr.common.ouro.core.plugin.textStyle.OuroTextStyleState;
import kntr.common.ouro.core.plugin.textStyle.OuroToggleBoldAction;
import kntr.common.ouro.core.plugin.textStyle.OuroToggleItalicAction;
import kntr.common.ouro.core.plugin.textStyle.OuroToggleStrikethroughAction;
import kntr.common.ouro.core.plugin.textStyle.OuroToggleUnderlineAction;
import kntr.common.ouro.core.utils.OuroStateToolbarExtKt;
import kntr.common.ouro.preview.tool.CommonToolItemKt;
import kotlin.Metadata;
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

/* compiled from: TextStylePanel.kt */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\u001a;\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u001a\b\u0002\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\u0007H\u0007¢\u0006\u0002\u0010\n\"\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f²\u0006\n\u0010\u0010\u001a\u00020\u0011X\u008a\u0084\u0002"}, d2 = {"TextStylePanel", "", "ouroStore", "Lkntr/common/ouro/core/OuroStore;", "modifier", "Landroidx/compose/ui/Modifier;", "onTrackEvent", "Lkotlin/Function2;", "Lkntr/common/ouro/common/ui/toolPanel/TextStylePanelEvent;", "", "(Lkntr/common/ouro/core/OuroStore;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "ForegroundColorList", "", "Lkntr/common/ouro/core/model/mark/OuroColor;", "BackgroundColorList", "ui_debug", "state", "Lkntr/common/ouro/core/OuroState;"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TextStylePanelKt {
    private static final List<OuroColor> ForegroundColorList = CollectionsKt.listOf(new OuroColor[]{OuroColor.Companion.getGa9(), OuroColor.Companion.getGa7(), OuroColor.Companion.getGa5(), OuroColor.Companion.getPu6(), OuroColor.Companion.getRe5(), OuroColor.Companion.getOr5(), OuroColor.Companion.getYe5(), OuroColor.Companion.getGr5(), OuroColor.Companion.getLb5()});
    private static final List<OuroColor> BackgroundColorList = CollectionsKt.listOf(new OuroColor[]{OuroColor.Companion.getLb2(), OuroColor.Companion.getYe2(), OuroColor.Companion.getPi2(), OuroColor.Companion.getGr2(), OuroColor.Companion.getOr2(), OuroColor.Companion.getBl2(), OuroColor.Companion.getBr2(), OuroColor.Companion.getSi2()});

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TextStylePanel$lambda$6(OuroStore ouroStore, Modifier modifier, Function2 function2, int i, int i2, Composer composer, int i3) {
        TextStylePanel(ouroStore, modifier, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TextStylePanel$lambda$0$0(TextStylePanelEvent textStylePanelEvent, boolean z) {
        Intrinsics.checkNotNullParameter(textStylePanelEvent, "<unused var>");
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v14 */
    public static final void TextStylePanel(final OuroStore ouroStore, Modifier modifier, Function2<? super TextStylePanelEvent, ? super Boolean, Unit> function2, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Function2 onTrackEvent;
        Composer $composer2;
        Modifier modifier3;
        Function2 onTrackEvent2;
        Intrinsics.checkNotNullParameter(ouroStore, "ouroStore");
        Composer $composer3 = $composer.startRestartGroup(754402821);
        ComposerKt.sourceInformation($composer3, "C(TextStylePanel)N(ouroStore,modifier,onTrackEvent)54@3019L11,56@3073L16,59@3119L103,64@3262L90,69@3388L63,73@3488L7,75@3553L6,75@3581L5583,75@3501L5663:TextStylePanel.kt#wsnt7k");
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
                ComposerKt.sourceInformationMarkerStart($composer3, -868357552, "CC(remember):TextStylePanel.kt#9igjgp");
                Object it$iv = $composer3.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function2() { // from class: kntr.common.ouro.common.ui.toolPanel.TextStylePanelKt$$ExternalSyntheticLambda15
                        public final Object invoke(Object obj, Object obj2) {
                            Unit TextStylePanel$lambda$0$0;
                            TextStylePanel$lambda$0$0 = TextStylePanelKt.TextStylePanel$lambda$0$0((TextStylePanelEvent) obj, ((Boolean) obj2).booleanValue());
                            return TextStylePanel$lambda$0$0;
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
                ComposerKt.traceEventStart(754402821, $dirty2, -1, "kntr.common.ouro.common.ui.toolPanel.TextStylePanel (TextStylePanel.kt:55)");
            }
            State state$delegate = SnapshotStateKt.collectAsState(ouroStore.getStateFlow(), (CoroutineContext) null, $composer3, 0, 1);
            OuroState TextStylePanel$lambda$1 = TextStylePanel$lambda$1(state$delegate);
            ComposerKt.sourceInformationMarkerStart($composer3, -868354260, "CC(remember):TextStylePanel.kt#9igjgp");
            boolean invalid$iv = $composer3.changed(TextStylePanel$lambda$1);
            Object it$iv2 = $composer3.rememberedValue();
            if (invalid$iv || it$iv2 == Composer.Companion.getEmpty()) {
                OuroState this_$iv = TextStylePanel$lambda$1(state$delegate);
                KClass key$iv = Reflection.getOrCreateKotlinClass(OuroTextStylePlugin.class);
                OuroPluginState ouroPluginState = this_$iv.getPluginStates().get(key$iv);
                if (!(ouroPluginState instanceof OuroTextStyleState)) {
                    ouroPluginState = null;
                }
                OuroTextStyleState ouroTextStyleState = (OuroTextStyleState) ouroPluginState;
                if (ouroTextStyleState == null) {
                    throw new NoSuchElementException("No plugin state for " + key$iv);
                }
                Object value$iv2 = ouroTextStyleState.getDisplayPanelStyle();
                $composer3.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            final OuroTextStyle textStyle = (OuroTextStyle) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            OuroState TextStylePanel$lambda$12 = TextStylePanel$lambda$1(state$delegate);
            ComposerKt.sourceInformationMarkerStart($composer3, -868349697, "CC(remember):TextStylePanel.kt#9igjgp");
            boolean invalid$iv2 = $composer3.changed(TextStylePanel$lambda$12);
            Object it$iv3 = $composer3.rememberedValue();
            if (invalid$iv2 || it$iv3 == Composer.Companion.getEmpty()) {
                OuroState this_$iv2 = TextStylePanel$lambda$1(state$delegate);
                KClass key$iv2 = Reflection.getOrCreateKotlinClass(OuroParagraphStylePlugin.class);
                Object obj = this_$iv2.getPluginStates().get(key$iv2);
                boolean invalid$iv3 = obj instanceof OuroParagraphStyleState;
                if (!invalid$iv3) {
                    obj = null;
                }
                Object obj2 = (OuroPluginState) ((OuroParagraphStyleState) obj);
                if (obj2 == null) {
                    throw new NoSuchElementException("No plugin state for " + key$iv2);
                }
                Object value$iv3 = (OuroParagraphStyleState) obj2;
                $composer3.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
            }
            final OuroParagraphStyleState paragraphStyleState = (OuroParagraphStyleState) it$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            OuroState TextStylePanel$lambda$13 = TextStylePanel$lambda$1(state$delegate);
            ComposerKt.sourceInformationMarkerStart($composer3, -868345692, "CC(remember):TextStylePanel.kt#9igjgp");
            boolean invalid$iv4 = $composer3.changed(TextStylePanel$lambda$13);
            Object it$iv4 = $composer3.rememberedValue();
            if (invalid$iv4 || it$iv4 == Composer.Companion.getEmpty()) {
                Object value$iv4 = Boolean.valueOf(OuroStateToolbarExtKt.canApplyHeading(TextStylePanel$lambda$1(state$delegate)));
                $composer3.updateRememberedValue(value$iv4);
                it$iv4 = value$iv4;
            }
            final boolean canApplyHeading = ((Boolean) it$iv4).booleanValue();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            CompositionLocal this_$iv3 = BiliThemeKt.getLocalDayNightTheme();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer3.consume(this_$iv3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            final Enum r26 = (ThemeDayNight) consume;
            Modifier modifier4 = PaddingKt.padding-3ABfNKs(BackgroundKt.background-bw27NRU$default(modifier3, BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getBg1-0d7_KjU(), (Shape) null, 2, (Object) null), Dp.constructor-impl(16));
            ComposerKt.sourceInformationMarkerStart($composer3, -868333996, "CC(remember):TextStylePanel.kt#9igjgp");
            boolean invalid$iv5 = $composer3.changedInstance(paragraphStyleState) | $composer3.changed(canApplyHeading) | $composer3.changedInstance(ouroStore) | (($dirty2 & 896) == 256) | $composer3.changedInstance(textStyle) | $composer3.changed(r26.ordinal());
            Object value$iv5 = $composer3.rememberedValue();
            if (invalid$iv5 || value$iv5 == Composer.Companion.getEmpty()) {
                final Function2 function22 = onTrackEvent2;
                value$iv5 = new Function1() { // from class: kntr.common.ouro.common.ui.toolPanel.TextStylePanelKt$$ExternalSyntheticLambda16
                    public final Object invoke(Object obj3) {
                        Unit TextStylePanel$lambda$5$0;
                        TextStylePanel$lambda$5$0 = TextStylePanelKt.TextStylePanel$lambda$5$0(OuroParagraphStyleState.this, canApplyHeading, ouroStore, function22, textStyle, r26, (LazyListScope) obj3);
                        return TextStylePanel$lambda$5$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv5);
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer2 = $composer3;
            LazyDslKt.LazyColumn(modifier4, (LazyListState) null, (PaddingValues) null, false, (Arrangement.Vertical) null, (Alignment.Horizontal) null, (FlingBehavior) null, false, (OverscrollEffect) null, (Function1) value$iv5, $composer2, 0, 510);
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
            endRestartGroup.updateScope(new Function2() { // from class: kntr.common.ouro.common.ui.toolPanel.TextStylePanelKt$$ExternalSyntheticLambda17
                public final Object invoke(Object obj3, Object obj4) {
                    Unit TextStylePanel$lambda$6;
                    TextStylePanel$lambda$6 = TextStylePanelKt.TextStylePanel$lambda$6(OuroStore.this, modifier5, function23, $changed, i, (Composer) obj3, ((Integer) obj4).intValue());
                    return TextStylePanel$lambda$6;
                }
            });
        }
    }

    private static final OuroState TextStylePanel$lambda$1(State<OuroState> state) {
        Object thisObj$iv = state.getValue();
        return (OuroState) thisObj$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TextStylePanel$lambda$5$0(final OuroParagraphStyleState $paragraphStyleState, final boolean $canApplyHeading, final OuroStore $ouroStore, final Function2 $onTrackEvent, final OuroTextStyle $textStyle, final ThemeDayNight $theme, LazyListScope $this$LazyColumn) {
        Intrinsics.checkNotNullParameter($this$LazyColumn, "$this$LazyColumn");
        SectionHeaderKt.sectionHeader($this$LazyColumn, String0_commonMainKt.getOuro_editor_global_string_23(Ouro_editorRes.INSTANCE.getString()));
        SectionContentKt.sectionContent($this$LazyColumn, ComposableLambdaKt.composableLambdaInstance(151389000, true, new Function3() { // from class: kntr.common.ouro.common.ui.toolPanel.TextStylePanelKt$$ExternalSyntheticLambda5
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit TextStylePanel$lambda$5$0$0;
                TextStylePanel$lambda$5$0$0 = TextStylePanelKt.TextStylePanel$lambda$5$0$0(OuroParagraphStyleState.this, $canApplyHeading, $ouroStore, $onTrackEvent, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return TextStylePanel$lambda$5$0$0;
            }
        }));
        SectionHeaderKt.sectionHeader($this$LazyColumn, String0_commonMainKt.getOuro_editor_global_string_24(Ouro_editorRes.INSTANCE.getString()));
        SectionContentKt.sectionContent($this$LazyColumn, ComposableLambdaKt.composableLambdaInstance(673820977, true, new Function3() { // from class: kntr.common.ouro.common.ui.toolPanel.TextStylePanelKt$$ExternalSyntheticLambda6
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit TextStylePanel$lambda$5$0$1;
                TextStylePanel$lambda$5$0$1 = TextStylePanelKt.TextStylePanel$lambda$5$0$1(OuroTextStyle.this, $ouroStore, $onTrackEvent, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return TextStylePanel$lambda$5$0$1;
            }
        }));
        SectionHeaderKt.sectionHeader($this$LazyColumn, String0_commonMainKt.getOuro_editor_global_string_19(Ouro_editorRes.INSTANCE.getString()));
        SectionContentKt.sectionContent($this$LazyColumn, ComposableLambdaKt.composableLambdaInstance(976708368, true, new Function3() { // from class: kntr.common.ouro.common.ui.toolPanel.TextStylePanelKt$$ExternalSyntheticLambda7
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit TextStylePanel$lambda$5$0$2;
                TextStylePanel$lambda$5$0$2 = TextStylePanelKt.TextStylePanel$lambda$5$0$2($theme, $textStyle, $ouroStore, $onTrackEvent, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return TextStylePanel$lambda$5$0$2;
            }
        }));
        SectionHeaderKt.sectionHeader($this$LazyColumn, String0_commonMainKt.getOuro_editor_global_string_20(Ouro_editorRes.INSTANCE.getString()));
        SectionContentKt.sectionContent($this$LazyColumn, ComposableLambdaKt.composableLambdaInstance(1279595759, true, new Function3() { // from class: kntr.common.ouro.common.ui.toolPanel.TextStylePanelKt$$ExternalSyntheticLambda8
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit TextStylePanel$lambda$5$0$3;
                TextStylePanel$lambda$5$0$3 = TextStylePanelKt.TextStylePanel$lambda$5$0$3(OuroTextStyle.this, $ouroStore, $onTrackEvent, $theme, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return TextStylePanel$lambda$5$0$3;
            }
        }));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TextStylePanel$lambda$5$0$0(OuroParagraphStyleState $paragraphStyleState, boolean $canApplyHeading, final OuroStore $ouroStore, final Function2 $onTrackEvent, RowScope $this$sectionContent, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$sectionContent, "$this$sectionContent");
        ComposerKt.sourceInformation($composer, "C80@3788L9,84@3979L141,78@3702L433,91@4234L9,95@4425L141,89@4148L433,102@4680L9,106@4871L141,100@4594L433,112@5082L66,113@5188L9,116@5334L145,111@5040L454:TextStylePanel.kt#wsnt7k");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer.changed($this$sectionContent) ? 4 : 2;
        }
        int $dirty2 = $dirty;
        if ($composer.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(151389000, $dirty2, -1, "kntr.common.ouro.common.ui.toolPanel.TextStylePanel.<anonymous>.<anonymous>.<anonymous> (TextStylePanel.kt:78)");
            }
            TextStyle t15b = BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT15b();
            Modifier weight$default = RowScope.-CC.weight$default($this$sectionContent, Modifier.Companion, 1.0f, false, 2, (Object) null);
            boolean isH1 = $paragraphStyleState.isH1();
            boolean z = !$canApplyHeading;
            ComposerKt.sourceInformationMarkerStart($composer, -544049611, "CC(remember):TextStylePanel.kt#9igjgp");
            boolean invalid$iv = $composer.changedInstance($ouroStore) | $composer.changed($onTrackEvent);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function0() { // from class: kntr.common.ouro.common.ui.toolPanel.TextStylePanelKt$$ExternalSyntheticLambda1
                    public final Object invoke() {
                        Unit TextStylePanel$lambda$5$0$0$0$0;
                        TextStylePanel$lambda$5$0$0$0$0 = TextStylePanelKt.TextStylePanel$lambda$5$0$0$0$0(OuroStore.this, $onTrackEvent);
                        return TextStylePanel$lambda$5$0$0$0$0;
                    }
                };
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            CommonToolItemKt.m2078TextImageToolItemCcamzx0((Function0) it$iv, weight$default, "H1", t15b, null, 0L, isH1, z, false, $composer, 384, 304);
            TextStyle t14b = BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT14b();
            Modifier weight$default2 = RowScope.-CC.weight$default($this$sectionContent, Modifier.Companion, 1.0f, false, 2, (Object) null);
            boolean isH2 = $paragraphStyleState.isH2();
            boolean z2 = !$canApplyHeading;
            ComposerKt.sourceInformationMarkerStart($composer, -544035339, "CC(remember):TextStylePanel.kt#9igjgp");
            boolean invalid$iv2 = $composer.changedInstance($ouroStore) | $composer.changed($onTrackEvent);
            Object it$iv2 = $composer.rememberedValue();
            if (invalid$iv2 || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = new Function0() { // from class: kntr.common.ouro.common.ui.toolPanel.TextStylePanelKt$$ExternalSyntheticLambda2
                    public final Object invoke() {
                        Unit TextStylePanel$lambda$5$0$0$1$0;
                        TextStylePanel$lambda$5$0$0$1$0 = TextStylePanelKt.TextStylePanel$lambda$5$0$0$1$0(OuroStore.this, $onTrackEvent);
                        return TextStylePanel$lambda$5$0$0$1$0;
                    }
                };
                $composer.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            CommonToolItemKt.m2078TextImageToolItemCcamzx0((Function0) it$iv2, weight$default2, "H2", t14b, null, 0L, isH2, z2, false, $composer, 384, 304);
            TextStyle t13b = BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT13b();
            Modifier weight$default3 = RowScope.-CC.weight$default($this$sectionContent, Modifier.Companion, 1.0f, false, 2, (Object) null);
            boolean isH3 = $paragraphStyleState.isH3();
            boolean z3 = !$canApplyHeading;
            ComposerKt.sourceInformationMarkerStart($composer, -544021067, "CC(remember):TextStylePanel.kt#9igjgp");
            boolean invalid$iv3 = $composer.changedInstance($ouroStore) | $composer.changed($onTrackEvent);
            Object it$iv3 = $composer.rememberedValue();
            if (invalid$iv3 || it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv3 = new Function0() { // from class: kntr.common.ouro.common.ui.toolPanel.TextStylePanelKt$$ExternalSyntheticLambda3
                    public final Object invoke() {
                        Unit TextStylePanel$lambda$5$0$0$2$0;
                        TextStylePanel$lambda$5$0$0$2$0 = TextStylePanelKt.TextStylePanel$lambda$5$0$0$2$0(OuroStore.this, $onTrackEvent);
                        return TextStylePanel$lambda$5$0$0$2$0;
                    }
                };
                $composer.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            CommonToolItemKt.m2078TextImageToolItemCcamzx0((Function0) it$iv3, weight$default3, "H3", t13b, null, 0L, isH3, z3, false, $composer, 384, 304);
            String stringResource = StringResourcesKt.stringResource(String0_commonMainKt.getOuro_editor_global_string_17(Ouro_editorRes.INSTANCE.getString()), $composer, 0);
            TextStyle t12 = BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT12();
            Modifier weight$default4 = RowScope.-CC.weight$default($this$sectionContent, Modifier.Companion, 1.0f, false, 2, (Object) null);
            boolean isText = $paragraphStyleState.isText();
            ComposerKt.sourceInformationMarkerStart($composer, -544006247, "CC(remember):TextStylePanel.kt#9igjgp");
            boolean invalid$iv4 = $composer.changedInstance($ouroStore) | $composer.changed($onTrackEvent);
            Object it$iv4 = $composer.rememberedValue();
            if (invalid$iv4 || it$iv4 == Composer.Companion.getEmpty()) {
                Object value$iv4 = new Function0() { // from class: kntr.common.ouro.common.ui.toolPanel.TextStylePanelKt$$ExternalSyntheticLambda4
                    public final Object invoke() {
                        Unit TextStylePanel$lambda$5$0$0$3$0;
                        TextStylePanel$lambda$5$0$0$3$0 = TextStylePanelKt.TextStylePanel$lambda$5$0$0$3$0(OuroStore.this, $onTrackEvent);
                        return TextStylePanel$lambda$5$0$0$3$0;
                    }
                };
                $composer.updateRememberedValue(value$iv4);
                it$iv4 = value$iv4;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            CommonToolItemKt.m2078TextImageToolItemCcamzx0((Function0) it$iv4, weight$default4, stringResource, t12, null, 0L, isText, false, false, $composer, 0, 432);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TextStylePanel$lambda$5$0$0$0$0(OuroStore $ouroStore, Function2 $onTrackEvent) {
        $ouroStore.dispatch(OuroToggleH1Action.INSTANCE);
        $onTrackEvent.invoke(TextStylePanelEvent.H1, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TextStylePanel$lambda$5$0$0$1$0(OuroStore $ouroStore, Function2 $onTrackEvent) {
        $ouroStore.dispatch(OuroToggleH2Action.INSTANCE);
        $onTrackEvent.invoke(TextStylePanelEvent.H2, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TextStylePanel$lambda$5$0$0$2$0(OuroStore $ouroStore, Function2 $onTrackEvent) {
        $ouroStore.dispatch(OuroToggleH3Action.INSTANCE);
        $onTrackEvent.invoke(TextStylePanelEvent.H3, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TextStylePanel$lambda$5$0$0$3$0(OuroStore $ouroStore, Function2 $onTrackEvent) {
        $ouroStore.dispatch(OuroToggleTextAction.INSTANCE);
        $onTrackEvent.invoke(TextStylePanelEvent.TEXT, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TextStylePanel$lambda$5$0$1(final OuroTextStyle $textStyle, final OuroStore $ouroStore, final Function2 $onTrackEvent, RowScope $this$sectionContent, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$sectionContent, "$this$sectionContent");
        ComposerKt.sourceInformation($composer, "C125@5669L42,128@5834L158,124@5624L383,134@6065L44,137@6234L164,133@6020L393,143@6471L47,146@6646L173,142@6426L408,152@6892L51,155@7075L185,151@6847L428:TextStylePanel.kt#wsnt7k");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer.changed($this$sectionContent) ? 4 : 2;
        }
        int $dirty2 = $dirty;
        if ($composer.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(673820977, $dirty2, -1, "kntr.common.ouro.common.ui.toolPanel.TextStylePanel.<anonymous>.<anonymous>.<anonymous> (TextStylePanel.kt:124)");
            }
            Painter painterResource = ImageResourcesKt.painterResource(Drawable0_commonMainKt.getToolbar_bold(Res.drawable.INSTANCE), $composer, 0);
            Modifier weight$default = RowScope.-CC.weight$default($this$sectionContent, Modifier.Companion, 1.0f, false, 2, (Object) null);
            boolean isBold = $textStyle.isBold();
            ComposerKt.sourceInformationMarkerStart($composer, -998095473, "CC(remember):TextStylePanel.kt#9igjgp");
            boolean invalid$iv = $composer.changedInstance($ouroStore) | $composer.changed($onTrackEvent) | $composer.changedInstance($textStyle);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function0() { // from class: kntr.common.ouro.common.ui.toolPanel.TextStylePanelKt$$ExternalSyntheticLambda9
                    public final Object invoke() {
                        Unit TextStylePanel$lambda$5$0$1$0$0;
                        TextStylePanel$lambda$5$0$1$0$0 = TextStylePanelKt.TextStylePanel$lambda$5$0$1$0$0(OuroStore.this, $onTrackEvent, $textStyle);
                        return TextStylePanel$lambda$5$0$1$0$0;
                    }
                };
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            CommonToolItemKt.m2078TextImageToolItemCcamzx0((Function0) it$iv, weight$default, null, null, painterResource, 0L, isBold, false, false, $composer, Painter.$stable << 12, 428);
            Painter painterResource2 = ImageResourcesKt.painterResource(Drawable0_commonMainKt.getToolbar_italic(Res.drawable.INSTANCE), $composer, 0);
            Modifier weight$default2 = RowScope.-CC.weight$default($this$sectionContent, Modifier.Companion, 1.0f, false, 2, (Object) null);
            boolean isItalic = $textStyle.isItalic();
            ComposerKt.sourceInformationMarkerStart($composer, -998082667, "CC(remember):TextStylePanel.kt#9igjgp");
            boolean invalid$iv2 = $composer.changedInstance($ouroStore) | $composer.changed($onTrackEvent) | $composer.changedInstance($textStyle);
            Object it$iv2 = $composer.rememberedValue();
            if (invalid$iv2 || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = new Function0() { // from class: kntr.common.ouro.common.ui.toolPanel.TextStylePanelKt$$ExternalSyntheticLambda10
                    public final Object invoke() {
                        Unit TextStylePanel$lambda$5$0$1$1$0;
                        TextStylePanel$lambda$5$0$1$1$0 = TextStylePanelKt.TextStylePanel$lambda$5$0$1$1$0(OuroStore.this, $onTrackEvent, $textStyle);
                        return TextStylePanel$lambda$5$0$1$1$0;
                    }
                };
                $composer.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            CommonToolItemKt.m2078TextImageToolItemCcamzx0((Function0) it$iv2, weight$default2, null, null, painterResource2, 0L, isItalic, false, false, $composer, Painter.$stable << 12, 428);
            Painter painterResource3 = ImageResourcesKt.painterResource(Drawable0_commonMainKt.getToolbar_underline(Res.drawable.INSTANCE), $composer, 0);
            Modifier weight$default3 = RowScope.-CC.weight$default($this$sectionContent, Modifier.Companion, 1.0f, false, 2, (Object) null);
            boolean isUnderline = $textStyle.isUnderline();
            ComposerKt.sourceInformationMarkerStart($composer, -998069474, "CC(remember):TextStylePanel.kt#9igjgp");
            boolean invalid$iv3 = $composer.changedInstance($ouroStore) | $composer.changed($onTrackEvent) | $composer.changedInstance($textStyle);
            Object it$iv3 = $composer.rememberedValue();
            if (invalid$iv3 || it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv3 = new Function0() { // from class: kntr.common.ouro.common.ui.toolPanel.TextStylePanelKt$$ExternalSyntheticLambda11
                    public final Object invoke() {
                        Unit TextStylePanel$lambda$5$0$1$2$0;
                        TextStylePanel$lambda$5$0$1$2$0 = TextStylePanelKt.TextStylePanel$lambda$5$0$1$2$0(OuroStore.this, $onTrackEvent, $textStyle);
                        return TextStylePanel$lambda$5$0$1$2$0;
                    }
                };
                $composer.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            CommonToolItemKt.m2078TextImageToolItemCcamzx0((Function0) it$iv3, weight$default3, null, null, painterResource3, 0L, isUnderline, false, false, $composer, Painter.$stable << 12, 428);
            Painter painterResource4 = ImageResourcesKt.painterResource(Drawable0_commonMainKt.getToolbar_strikethrough(Res.drawable.INSTANCE), $composer, 0);
            Modifier weight$default4 = RowScope.-CC.weight$default($this$sectionContent, Modifier.Companion, 1.0f, false, 2, (Object) null);
            boolean isStrikethrough = $textStyle.isStrikethrough();
            ComposerKt.sourceInformationMarkerStart($composer, -998055734, "CC(remember):TextStylePanel.kt#9igjgp");
            boolean invalid$iv4 = $composer.changedInstance($ouroStore) | $composer.changed($onTrackEvent) | $composer.changedInstance($textStyle);
            Object it$iv4 = $composer.rememberedValue();
            if (invalid$iv4 || it$iv4 == Composer.Companion.getEmpty()) {
                Object value$iv4 = new Function0() { // from class: kntr.common.ouro.common.ui.toolPanel.TextStylePanelKt$$ExternalSyntheticLambda12
                    public final Object invoke() {
                        Unit TextStylePanel$lambda$5$0$1$3$0;
                        TextStylePanel$lambda$5$0$1$3$0 = TextStylePanelKt.TextStylePanel$lambda$5$0$1$3$0(OuroStore.this, $onTrackEvent, $textStyle);
                        return TextStylePanel$lambda$5$0$1$3$0;
                    }
                };
                $composer.updateRememberedValue(value$iv4);
                it$iv4 = value$iv4;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            CommonToolItemKt.m2078TextImageToolItemCcamzx0((Function0) it$iv4, weight$default4, null, null, painterResource4, 0L, isStrikethrough, false, false, $composer, Painter.$stable << 12, 428);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TextStylePanel$lambda$5$0$1$0$0(OuroStore $ouroStore, Function2 $onTrackEvent, OuroTextStyle $textStyle) {
        $ouroStore.dispatch(OuroToggleBoldAction.INSTANCE);
        $onTrackEvent.invoke(TextStylePanelEvent.BOLD, Boolean.valueOf(!$textStyle.isBold()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TextStylePanel$lambda$5$0$1$1$0(OuroStore $ouroStore, Function2 $onTrackEvent, OuroTextStyle $textStyle) {
        $ouroStore.dispatch(OuroToggleItalicAction.INSTANCE);
        $onTrackEvent.invoke(TextStylePanelEvent.ITALIC, Boolean.valueOf(!$textStyle.isItalic()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TextStylePanel$lambda$5$0$1$2$0(OuroStore $ouroStore, Function2 $onTrackEvent, OuroTextStyle $textStyle) {
        $ouroStore.dispatch(OuroToggleUnderlineAction.INSTANCE);
        $onTrackEvent.invoke(TextStylePanelEvent.UNDERLINE, Boolean.valueOf(!$textStyle.isUnderline()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TextStylePanel$lambda$5$0$1$3$0(OuroStore $ouroStore, Function2 $onTrackEvent, OuroTextStyle $textStyle) {
        $ouroStore.dispatch(OuroToggleStrikethroughAction.INSTANCE);
        $onTrackEvent.invoke(TextStylePanelEvent.STRIKETHROUGH, Boolean.valueOf(!$textStyle.isStrikethrough()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TextStylePanel$lambda$5$0$2(ThemeDayNight $theme, OuroTextStyle $textStyle, final OuroStore $ouroStore, final Function2 $onTrackEvent, RowScope $this$sectionContent, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$sectionContent, "$this$sectionContent");
        ComposerKt.sourceInformation($composer, "C*166@7578L43,170@7823L182,165@7529L495:TextStylePanel.kt#wsnt7k");
        int i = 0;
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(976708368, $changed, -1, "kntr.common.ouro.common.ui.toolPanel.TextStylePanel.<anonymous>.<anonymous>.<anonymous> (TextStylePanel.kt:163)");
            }
            for (final OuroColor colors : ForegroundColorList) {
                long currentColor = ColorKt.Color(colors.colorForTheme($theme));
                Painter painterResource = ImageResourcesKt.painterResource(Drawable0_commonMainKt.getToolbar_color(Res.drawable.INSTANCE), $composer, i);
                Modifier modifier = SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(48));
                boolean areEqual = Intrinsics.areEqual($textStyle.getForegroundColor(), colors);
                ComposerKt.sourceInformationMarkerStart($composer, -1981082170, "CC(remember):TextStylePanel.kt#9igjgp");
                boolean invalid$iv = $composer.changedInstance($ouroStore) | $composer.changedInstance(colors) | $composer.changed($onTrackEvent);
                Object it$iv = $composer.rememberedValue();
                if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function0() { // from class: kntr.common.ouro.common.ui.toolPanel.TextStylePanelKt$$ExternalSyntheticLambda0
                        public final Object invoke() {
                            Unit TextStylePanel$lambda$5$0$2$0$0;
                            TextStylePanel$lambda$5$0$2$0$0 = TextStylePanelKt.TextStylePanel$lambda$5$0$2$0$0(OuroStore.this, colors, $onTrackEvent);
                            return TextStylePanel$lambda$5$0$2$0$0;
                        }
                    };
                    $composer.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                ComposerKt.sourceInformationMarkerEnd($composer);
                CommonToolItemKt.m2078TextImageToolItemCcamzx0((Function0) it$iv, modifier, null, null, painterResource, currentColor, areEqual, false, false, $composer, (Painter.$stable << 12) | 48, 396);
                i = 0;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TextStylePanel$lambda$5$0$2$0$0(OuroStore $ouroStore, OuroColor $colors, Function2 $onTrackEvent) {
        $ouroStore.dispatch(new OuroChangeForegroundColor($colors));
        $onTrackEvent.invoke(TextStylePanelEvent.FOREGROUND_COLOR, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TextStylePanel$lambda$5$0$3(OuroTextStyle $textStyle, final OuroStore $ouroStore, final Function2 $onTrackEvent, ThemeDayNight $theme, RowScope $this$sectionContent, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$sectionContent, "$this$sectionContent");
        ComposerKt.sourceInformation($composer, "C183@8377L169,179@8168L393,*194@8933L182,190@8698L436:TextStylePanel.kt#wsnt7k");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1279595759, $changed, -1, "kntr.common.ouro.common.ui.toolPanel.TextStylePanel.<anonymous>.<anonymous>.<anonymous> (TextStylePanel.kt:179)");
            }
            Modifier modifier = SizeKt.height-3ABfNKs(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(48)), Dp.constructor-impl(28));
            boolean z = $textStyle.getBackgroundColor() == null;
            ComposerKt.sourceInformationMarkerStart($composer, 1330885048, "CC(remember):TextStylePanel.kt#9igjgp");
            boolean invalid$iv = $composer.changedInstance($ouroStore) | $composer.changed($onTrackEvent);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function0() { // from class: kntr.common.ouro.common.ui.toolPanel.TextStylePanelKt$$ExternalSyntheticLambda13
                    public final Object invoke() {
                        Unit TextStylePanel$lambda$5$0$3$0$0;
                        TextStylePanel$lambda$5$0$3$0$0 = TextStylePanelKt.TextStylePanel$lambda$5$0$3$0$0(OuroStore.this, $onTrackEvent);
                        return TextStylePanel$lambda$5$0$3$0$0;
                    }
                };
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            CommonToolItemKt.m2076BackgroundColorToolItemiWX5oaw(null, (Function0) it$iv, modifier, z, false, $composer, 390, 16);
            for (final OuroColor colors : BackgroundColorList) {
                long currentColor = ColorKt.Color(colors.colorForTheme($theme));
                Modifier modifier2 = SizeKt.height-3ABfNKs(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(48)), Dp.constructor-impl(28));
                boolean areEqual = Intrinsics.areEqual($textStyle.getBackgroundColor(), colors);
                Color color = Color.box-impl(currentColor);
                ComposerKt.sourceInformationMarkerStart($composer, 1330902853, "CC(remember):TextStylePanel.kt#9igjgp");
                boolean invalid$iv2 = $composer.changedInstance($ouroStore) | $composer.changedInstance(colors) | $composer.changed($onTrackEvent);
                Object it$iv2 = $composer.rememberedValue();
                if (!invalid$iv2 && it$iv2 != Composer.Companion.getEmpty()) {
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    CommonToolItemKt.m2076BackgroundColorToolItemiWX5oaw(color, (Function0) it$iv2, modifier2, areEqual, false, $composer, 384, 16);
                }
                Object value$iv2 = new Function0() { // from class: kntr.common.ouro.common.ui.toolPanel.TextStylePanelKt$$ExternalSyntheticLambda14
                    public final Object invoke() {
                        Unit TextStylePanel$lambda$5$0$3$1$0;
                        TextStylePanel$lambda$5$0$3$1$0 = TextStylePanelKt.TextStylePanel$lambda$5$0$3$1$0(OuroStore.this, colors, $onTrackEvent);
                        return TextStylePanel$lambda$5$0$3$1$0;
                    }
                };
                $composer.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
                ComposerKt.sourceInformationMarkerEnd($composer);
                CommonToolItemKt.m2076BackgroundColorToolItemiWX5oaw(color, (Function0) it$iv2, modifier2, areEqual, false, $composer, 384, 16);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TextStylePanel$lambda$5$0$3$0$0(OuroStore $ouroStore, Function2 $onTrackEvent) {
        $ouroStore.dispatch(new OuroChangeBackgroundColor(null));
        $onTrackEvent.invoke(TextStylePanelEvent.BACKGROUND_COLOR, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TextStylePanel$lambda$5$0$3$1$0(OuroStore $ouroStore, OuroColor $colors, Function2 $onTrackEvent) {
        $ouroStore.dispatch(new OuroChangeBackgroundColor($colors));
        $onTrackEvent.invoke(TextStylePanelEvent.BACKGROUND_COLOR, true);
        return Unit.INSTANCE;
    }
}