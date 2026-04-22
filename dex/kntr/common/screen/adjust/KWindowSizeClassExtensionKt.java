package kntr.common.screen.adjust;

import androidx.window.core.layout.WindowSizeClass;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KWindowSizeClassExtension.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0004\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0005"}, d2 = {"widthNormalCompat", "", "Landroidx/window/core/layout/WindowSizeClass;", "widthMediumCompat", "widthLargeCompat", "screen-adjust_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class KWindowSizeClassExtensionKt {
    public static final boolean widthNormalCompat(WindowSizeClass $this$widthNormalCompat) {
        Intrinsics.checkNotNullParameter($this$widthNormalCompat, "<this>");
        return $this$widthNormalCompat.getMinWidthDp() < 600;
    }

    public static final boolean widthMediumCompat(WindowSizeClass $this$widthMediumCompat) {
        Intrinsics.checkNotNullParameter($this$widthMediumCompat, "<this>");
        return $this$widthMediumCompat.getMinWidthDp() < 840 && $this$widthMediumCompat.getMinWidthDp() >= 600;
    }

    public static final boolean widthLargeCompat(WindowSizeClass $this$widthLargeCompat) {
        Intrinsics.checkNotNullParameter($this$widthLargeCompat, "<this>");
        return $this$widthLargeCompat.getMinWidthDp() >= 840;
    }
}