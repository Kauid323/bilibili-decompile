package kntr.base.imageloader;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Image.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u000f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"getSize", "Landroidx/compose/ui/geometry/Size;", "Lkntr/base/imageloader/Image;", "(Lkntr/base/imageloader/Image;)J", "imageloader_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ImageKt {
    public static final long getSize(Image $this$getSize) {
        Intrinsics.checkNotNullParameter($this$getSize, "<this>");
        if (!($this$getSize instanceof StaticImage)) {
            if (!($this$getSize instanceof AnimateImage)) {
                throw new NoWhenBranchMatchedException();
            }
            int bits$iv$iv$iv = (int) (((AnimateImage) $this$getSize).getImageInfo().m1413getSizeNHjbRc() >> 32);
            float width$iv = Float.intBitsToFloat(bits$iv$iv$iv);
            int bits$iv$iv$iv2 = (int) (((AnimateImage) $this$getSize).getImageInfo().m1413getSizeNHjbRc() & 4294967295L);
            float height$iv = Float.intBitsToFloat(bits$iv$iv$iv2);
            long v1$iv$iv = Float.floatToRawIntBits(width$iv);
            long v2$iv$iv = Float.floatToRawIntBits(height$iv);
            return androidx.compose.ui.geometry.Size.constructor-impl((4294967295L & v2$iv$iv) | (v1$iv$iv << 32));
        }
        int bits$iv$iv$iv3 = (int) (((StaticImage) $this$getSize).getImageInfo().m1582getSizeNHjbRc() >> 32);
        float width$iv2 = Float.intBitsToFloat(bits$iv$iv$iv3);
        int bits$iv$iv$iv4 = (int) (((StaticImage) $this$getSize).getImageInfo().m1582getSizeNHjbRc() & 4294967295L);
        float height$iv2 = Float.intBitsToFloat(bits$iv$iv$iv4);
        long v1$iv$iv2 = Float.floatToRawIntBits(width$iv2);
        long v2$iv$iv2 = Float.floatToRawIntBits(height$iv2);
        return androidx.compose.ui.geometry.Size.constructor-impl((4294967295L & v2$iv$iv2) | (v1$iv$iv2 << 32));
    }
}