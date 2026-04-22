package im.base;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import io.ktor.http.ContentDisposition;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* compiled from: Alignment.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J'\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lim/base/IMStatusAlignment;", "Landroidx/compose/ui/Alignment;", "minCenterOffsetPx", "", "<init>", "(F)V", "align", "Landroidx/compose/ui/unit/IntOffset;", ContentDisposition.Parameters.Size, "Landroidx/compose/ui/unit/IntSize;", "space", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "align-KFBX0sM", "(JJLandroidx/compose/ui/unit/LayoutDirection;)J", "base-ui_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
final class IMStatusAlignment implements Alignment {
    private final float minCenterOffsetPx;

    public IMStatusAlignment(float minCenterOffsetPx) {
        this.minCenterOffsetPx = minCenterOffsetPx;
    }

    /* renamed from: align-KFBX0sM  reason: not valid java name */
    public long m3081alignKFBX0sM(long j, long j2, LayoutDirection layoutDirection) {
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        int x = IntOffset.getX-impl(IntSizeKt.getCenter-ozmzZPI(j2)) - IntOffset.getX-impl(IntSizeKt.getCenter-ozmzZPI(j));
        int $i$f$unpackInt2 = (int) (j & 4294967295L);
        int y = MathKt.roundToInt(RangesKt.coerceAtLeast(((int) (j2 & 4294967295L)) * 0.4f, this.minCenterOffsetPx)) - ($i$f$unpackInt2 / 2);
        return IntOffset.constructor-impl((x << 32) | (4294967295L & y));
    }
}