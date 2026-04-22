package kntr.common.photonic;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Resolution.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0007¨\u0006\u0003"}, d2 = {"coerceAtMostWithScale", "Lkntr/common/photonic/Resolution;", "atMost", "image_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ResolutionKt {
    public static final Resolution coerceAtMostWithScale(Resolution $this$coerceAtMostWithScale, Resolution atMost) {
        Intrinsics.checkNotNullParameter($this$coerceAtMostWithScale, "<this>");
        Intrinsics.checkNotNullParameter(atMost, "atMost");
        if ($this$coerceAtMostWithScale.getWidthPx() <= 0 || $this$coerceAtMostWithScale.getHeightPx() <= 0) {
            return $this$coerceAtMostWithScale;
        }
        if (atMost.getWidthPx() <= 0 || atMost.getHeightPx() <= 0) {
            return $this$coerceAtMostWithScale;
        }
        double widthScale = $this$coerceAtMostWithScale.getWidthPx() / atMost.getWidthPx();
        double heightScale = $this$coerceAtMostWithScale.getHeightPx() / atMost.getHeightPx();
        double scale = Math.max(widthScale, heightScale);
        if (scale <= 1.0d) {
            return $this$coerceAtMostWithScale;
        }
        return new Resolution((int) ($this$coerceAtMostWithScale.getWidthPx() / scale), (int) ($this$coerceAtMostWithScale.getHeightPx() / scale));
    }
}