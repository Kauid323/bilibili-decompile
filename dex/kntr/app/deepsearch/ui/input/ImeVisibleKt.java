package kntr.app.deepsearch.ui.input;

import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;

/* compiled from: ImeVisible.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"imeVisible", RoomRecommendViewModel.EMPTY_CURSOR, "(Landroidx/compose/runtime/Composer;I)Z", "compose_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ImeVisibleKt {
    public static final boolean imeVisible(Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, 312455820, "C(imeVisible)9@353L12:ImeVisible.kt#t8834");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(312455820, $changed, -1, "kntr.app.deepsearch.ui.input.imeVisible (ImeVisible.kt:9)");
        }
        boolean isImeVisible = WindowInsets_androidKt.isImeVisible(WindowInsets.Companion, $composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return isImeVisible;
    }
}