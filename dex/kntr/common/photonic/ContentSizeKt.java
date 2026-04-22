package kntr.common.photonic;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ContentSize.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0004\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0002\u001a\u000f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¢\u0006\u0002\u0010\u0003\u001a\u000f\u0010\u0004\u001a\u00020\u0001*\u00020\u0002¢\u0006\u0002\u0010\u0003\u001a\u000f\u0010\u0005\u001a\u00020\u0001*\u00020\u0002¢\u0006\u0002\u0010\u0003\u001a\u000f\u0010\u0000\u001a\u00020\u0001*\u00020\u0006¢\u0006\u0002\u0010\u0007\u001a\u000f\u0010\u0004\u001a\u00020\u0001*\u00020\u0006¢\u0006\u0002\u0010\u0007\u001a\u000f\u0010\u0005\u001a\u00020\u0001*\u00020\u0006¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"bytes", "Lkntr/common/photonic/ContentSize;", "", "(Ljava/lang/Number;)D", "kilobytes", "megabytes", "", "(D)D", "image_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ContentSizeKt {
    public static final double bytes(Number $this$bytes) {
        Intrinsics.checkNotNullParameter($this$bytes, "<this>");
        return bytes($this$bytes.doubleValue());
    }

    public static final double kilobytes(Number $this$kilobytes) {
        Intrinsics.checkNotNullParameter($this$kilobytes, "<this>");
        return kilobytes($this$kilobytes.doubleValue());
    }

    public static final double megabytes(Number $this$megabytes) {
        Intrinsics.checkNotNullParameter($this$megabytes, "<this>");
        return megabytes($this$megabytes.doubleValue());
    }

    public static final double bytes(double $this$bytes) {
        return ContentSize.m2183constructorimpl($this$bytes);
    }

    public static final double kilobytes(double $this$kilobytes) {
        return bytes(1024 * $this$kilobytes);
    }

    public static final double megabytes(double $this$megabytes) {
        double d = 1024;
        return bytes($this$megabytes * d * d);
    }
}