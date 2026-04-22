package kntr.common.photonic.aphro.ui.preview.utils;

import androidx.compose.ui.unit.IntSize;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.photonic.Resolution;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ResolutionExt.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"toIntSize", "Landroidx/compose/ui/unit/IntSize;", "Lkntr/common/photonic/Resolution;", "(Lkntr/common/photonic/Resolution;)J", "ui_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ResolutionExtKt {
    public static final long toIntSize(Resolution $this$toIntSize) {
        Intrinsics.checkNotNullParameter($this$toIntSize, "<this>");
        int width$iv = $this$toIntSize.getWidthPx();
        int height$iv = $this$toIntSize.getHeightPx();
        return IntSize.constructor-impl((width$iv << 32) | (height$iv & 4294967295L));
    }
}