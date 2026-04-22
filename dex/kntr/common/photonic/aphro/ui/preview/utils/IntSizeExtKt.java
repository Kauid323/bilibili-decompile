package kntr.common.photonic.aphro.ui.preview.utils;

import androidx.compose.ui.unit.IntSize;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;

/* compiled from: IntSizeExt.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0007\u001a\u0013\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0013\u0010\u0005\u001a\u00020\u0006*\u00020\u0002H\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a\u001b\u0010\t\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"isLongPicture", "", "Landroidx/compose/ui/unit/IntSize;", "isLongPicture-ozmzZPI", "(J)Z", "factor", "", "factor-ozmzZPI", "(J)F", "scaleIn", "container", "scaleIn-TemP2vQ", "(JJ)J", "ui_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class IntSizeExtKt {
    /* renamed from: isLongPicture-ozmzZPI  reason: not valid java name */
    public static final boolean m2326isLongPictureozmzZPI(long j) {
        if (((int) (j >> 32)) <= 0 || ((int) (j & 4294967295L)) <= 0) {
            return false;
        }
        int $i$f$unpackInt1 = (int) (j >> 32);
        if (((int) (j & 4294967295L)) / $i$f$unpackInt1 < 3.3333333333333335d) {
            int $i$f$unpackInt2 = (int) (4294967295L & j);
            if (((int) (j >> 32)) / $i$f$unpackInt2 < 3.3333333333333335d) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: factor-ozmzZPI  reason: not valid java name */
    public static final float m2325factorozmzZPI(long j) {
        if (((int) (j >> 32)) <= 0 || ((int) (j & 4294967295L)) <= 0) {
            return 1.0f;
        }
        if (m2326isLongPictureozmzZPI(j)) {
            return ((int) (4294967295L & j)) / ((int) (j >> 32));
        }
        return ((int) (j >> 32)) / ((int) (4294967295L & j));
    }

    /* renamed from: scaleIn-TemP2vQ  reason: not valid java name */
    public static final long m2327scaleInTemP2vQ(long j, long j2) {
        if (((int) (j >> 32)) <= 0 || ((int) (j & 4294967295L)) <= 0) {
            return IntSize.Companion.getZero-YbymL2g();
        }
        boolean isLandscape = ((int) (j2 >> 32)) > ((int) (j2 & 4294967295L));
        boolean isLongPicture = m2326isLongPictureozmzZPI(j);
        float factor = m2325factorozmzZPI(j);
        if (!isLandscape || isLongPicture) {
            int targetWidth = (!isLongPicture || ((double) factor) >= 1.0d) ? (int) (j2 >> 32) : ((int) (j2 >> 32)) / 2;
            int height$iv = (int) Math.ceil(((int) (j & 4294967295L)) * (targetWidth / ((int) (j >> 32))));
            return IntSize.constructor-impl((height$iv & 4294967295L) | (targetWidth << 32));
        }
        float scale = m2325factorozmzZPI(j) < m2325factorozmzZPI(j2) ? ((int) (j2 & 4294967295L)) / ((int) (j & 4294967295L)) : ((int) (j2 >> 32)) / ((int) (j >> 32));
        int width$iv = (int) Math.ceil(((int) (j >> 32)) * scale);
        int height$iv2 = (int) Math.ceil(((int) (j & 4294967295L)) * scale);
        return IntSize.constructor-impl((height$iv2 & 4294967295L) | (width$iv << 32));
    }
}