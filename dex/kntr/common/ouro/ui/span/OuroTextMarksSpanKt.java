package kntr.common.ouro.ui.span;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.KotlinVersion;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;

/* compiled from: OuroTextMarksSpan.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¨\u0006\u0004"}, d2 = {"fade", "", "alpha", "", "ui_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class OuroTextMarksSpanKt {
    public static final int fade(int $this$fade, float alpha) {
        int newAlpha = RangesKt.coerceIn((int) (((float) KotlinVersion.MAX_COMPONENT_VALUE) * alpha), 0, (int) KotlinVersion.MAX_COMPONENT_VALUE);
        return (16777215 & $this$fade) | (newAlpha << 24);
    }
}