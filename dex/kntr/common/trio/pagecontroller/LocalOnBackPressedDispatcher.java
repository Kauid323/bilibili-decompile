package kntr.common.trio.pagecontroller;

import androidx.activity.OnBackPressedDispatcher;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;

/* compiled from: LocalOnBackPressedDispatcher.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0015\u0010\u0004\u001a\u00060\u0005j\u0002`\u00068G¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lkntr/common/trio/pagecontroller/LocalOnBackPressedDispatcher;", "", "<init>", "()V", "current", "Landroidx/activity/OnBackPressedDispatcher;", "Lkntr/common/trio/pagecontroller/OnBackPressedDispatcher;", "getCurrent", "(Landroidx/compose/runtime/Composer;I)Landroidx/activity/OnBackPressedDispatcher;", "trio_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class LocalOnBackPressedDispatcher {
    public static final int $stable = 0;
    public static final LocalOnBackPressedDispatcher INSTANCE = new LocalOnBackPressedDispatcher();

    private LocalOnBackPressedDispatcher() {
    }

    public final OnBackPressedDispatcher getCurrent(Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, -401446303, "C(<get-current>)7@211L37:LocalOnBackPressedDispatcher.kt#yqq3oh");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-401446303, $changed, -1, "kntr.common.trio.pagecontroller.LocalOnBackPressedDispatcher.<get-current> (LocalOnBackPressedDispatcher.kt:6)");
        }
        OnBackPressedDispatcher findViewTreeOnBackPressedDispatcher = LocalOnBackPressedDispatcher_androidKt.findViewTreeOnBackPressedDispatcher($composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return findViewTreeOnBackPressedDispatcher;
    }
}