package kntr.common.ouro.common.ui.toolPanel.expandablePanel;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.common.ui.toolPanel.expandablePanel.ExpandablePanelState;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ExpandablePanelState.kt */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0017\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u0001¢\u0006\u0002\u0010\u0004\u001a\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0001*\u00020\u0003H\u0001¢\u0006\u0002\u0010\u0004\u001a5\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, d2 = {"rememberProgress", "Landroidx/compose/runtime/State;", "", "Lkntr/common/ouro/common/ui/toolPanel/expandablePanel/ExpandablePanelState;", "(Lkntr/common/ouro/common/ui/toolPanel/expandablePanel/ExpandablePanelState;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "rememberCurrentValue", "Lkntr/common/ouro/common/ui/toolPanel/expandablePanel/ExpandablePanelState$Style;", "rememberExpandablePanelState", "initialValue", "isEnableExpand", "", "normalAnchor", "Lkntr/common/ouro/common/ui/toolPanel/expandablePanel/ExpandablePanelState$Anchor;", "expandedAnchor", "(Lkntr/common/ouro/common/ui/toolPanel/expandablePanel/ExpandablePanelState$Style;ZLkntr/common/ouro/common/ui/toolPanel/expandablePanel/ExpandablePanelState$Anchor;Lkntr/common/ouro/common/ui/toolPanel/expandablePanel/ExpandablePanelState$Anchor;Landroidx/compose/runtime/Composer;II)Lkntr/common/ouro/common/ui/toolPanel/expandablePanel/ExpandablePanelState;", "ui_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ExpandablePanelStateKt {
    public static final State<Float> rememberProgress(final ExpandablePanelState $this$rememberProgress, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$rememberProgress, "<this>");
        ComposerKt.sourceInformationMarkerStart($composer, -2146702663, "C(rememberProgress)56@1561L40:ExpandablePanelState.kt#x1p13y");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2146702663, $changed, -1, "kntr.common.ouro.common.ui.toolPanel.expandablePanel.rememberProgress (ExpandablePanelState.kt:56)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, -1396955103, "CC(remember):ExpandablePanelState.kt#9igjgp");
        Object it$iv = $composer.rememberedValue();
        if (it$iv == Composer.Companion.getEmpty()) {
            Object value$iv = SnapshotStateKt.derivedStateOf(new Function0() { // from class: kntr.common.ouro.common.ui.toolPanel.expandablePanel.ExpandablePanelStateKt$$ExternalSyntheticLambda1
                public final Object invoke() {
                    float progress;
                    progress = ExpandablePanelState.this.getProgress();
                    return Float.valueOf(progress);
                }
            });
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
        }
        State<Float> state = (State) it$iv;
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return state;
    }

    public static final State<ExpandablePanelState.Style> rememberCurrentValue(final ExpandablePanelState $this$rememberCurrentValue, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$rememberCurrentValue, "<this>");
        ComposerKt.sourceInformationMarkerStart($composer, -1300354226, "C(rememberCurrentValue)60@1692L79:ExpandablePanelState.kt#x1p13y");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1300354226, $changed, -1, "kntr.common.ouro.common.ui.toolPanel.expandablePanel.rememberCurrentValue (ExpandablePanelState.kt:60)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, 195074205, "CC(remember):ExpandablePanelState.kt#9igjgp");
        Object it$iv = $composer.rememberedValue();
        if (it$iv == Composer.Companion.getEmpty()) {
            Object value$iv = SnapshotStateKt.derivedStateOf(new Function0() { // from class: kntr.common.ouro.common.ui.toolPanel.expandablePanel.ExpandablePanelStateKt$$ExternalSyntheticLambda0
                public final Object invoke() {
                    ExpandablePanelState.Style rememberCurrentValue$lambda$0$0;
                    rememberCurrentValue$lambda$0$0 = ExpandablePanelStateKt.rememberCurrentValue$lambda$0$0(ExpandablePanelState.this);
                    return rememberCurrentValue$lambda$0$0;
                }
            });
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
        }
        State<ExpandablePanelState.Style> state = (State) it$iv;
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return state;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ExpandablePanelState.Style rememberCurrentValue$lambda$0$0(ExpandablePanelState $this_rememberCurrentValue) {
        return (ExpandablePanelState.Style) $this_rememberCurrentValue.getAnchoredDraggableState().getCurrentValue();
    }

    public static final ExpandablePanelState rememberExpandablePanelState(ExpandablePanelState.Style initialValue, boolean isEnableExpand, ExpandablePanelState.Anchor normalAnchor, ExpandablePanelState.Anchor expandedAnchor, Composer $composer, int $changed, int i) {
        ComposerKt.sourceInformationMarkerStart($composer, 718719819, "C(rememberExpandablePanelState)N(initialValue,isEnableExpand,normalAnchor,expandedAnchor)71@2161L105:ExpandablePanelState.kt#x1p13y");
        if ((i & 1) != 0) {
            initialValue = ExpandablePanelState.Style.Normal;
        }
        if ((i & 2) != 0) {
            isEnableExpand = true;
        }
        if ((i & 4) != 0) {
            ExpandablePanelState.Anchor normalAnchor2 = new ExpandablePanelState.Anchor.AbsoluteHeight(Constant.INSTANCE.m1904getNormalHeightD9Ej5fM(), null);
            normalAnchor = normalAnchor2;
        }
        if ((i & 8) != 0) {
            ExpandablePanelState.Anchor expandedAnchor2 = new ExpandablePanelState.Anchor.PaddingFromTop(Constant.INSTANCE.m1903getExpandTopPaddingD9Ej5fM(), null);
            expandedAnchor = expandedAnchor2;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(718719819, $changed, -1, "kntr.common.ouro.common.ui.toolPanel.expandablePanel.rememberExpandablePanelState (ExpandablePanelState.kt:71)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, -799976460, "CC(remember):ExpandablePanelState.kt#9igjgp");
        Object it$iv = $composer.rememberedValue();
        if (it$iv == Composer.Companion.getEmpty()) {
            Object value$iv = new ExpandablePanelState(initialValue, isEnableExpand, normalAnchor, expandedAnchor);
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
        }
        ExpandablePanelState expandablePanelState = (ExpandablePanelState) it$iv;
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return expandablePanelState;
    }
}