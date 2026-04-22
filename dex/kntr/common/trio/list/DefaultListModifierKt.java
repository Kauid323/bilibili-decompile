package kntr.common.trio.list;

import androidx.compose.foundation.gestures.ScrollableState;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.compose.list.OverscrollKt;
import kntr.common.trio.systemui.ScrollToTopKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DefaultListModifier.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"defaultVerticalScrollableEffects", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/gestures/ScrollableState;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/gestures/ScrollableState;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;", "trio_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class DefaultListModifierKt {
    public static final Modifier defaultVerticalScrollableEffects(Modifier $this$defaultVerticalScrollableEffects, ScrollableState state, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$defaultVerticalScrollableEffects, "<this>");
        Intrinsics.checkNotNullParameter(state, "state");
        ComposerKt.sourceInformationMarkerStart($composer, -414236362, "C(defaultVerticalScrollableEffects)N(state)24@1088L32:DefaultListModifier.kt#2aozde");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-414236362, $changed, -1, "kntr.common.trio.list.defaultVerticalScrollableEffects (DefaultListModifier.kt:22)");
        }
        Modifier preferScrollToTop = ScrollToTopKt.preferScrollToTop(OverscrollKt.overScrollVertical$default($this$defaultVerticalScrollableEffects, false, null, 0.0f, 0.0f, 0.0f, state instanceof LazyListState ? (LazyListState) state : null, 31, null), state, null, $composer, $changed & 112, 2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return preferScrollToTop;
    }
}