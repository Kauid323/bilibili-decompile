package kntr.base.avif.decoder;

import androidx.collection.DoubleList$;
import androidx.compose.ui.graphics.ImageBitmap;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AvifDecoder.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lkntr/base/avif/decoder/AvifFrame;", "", "bitmap", "Landroidx/compose/ui/graphics/ImageBitmap;", "duration", "", "<init>", "(Landroidx/compose/ui/graphics/ImageBitmap;D)V", "getBitmap", "()Landroidx/compose/ui/graphics/ImageBitmap;", "getDuration", "()D", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "avif_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class AvifFrame {
    public static final int $stable = 8;
    private final ImageBitmap bitmap;
    private final double duration;

    public static /* synthetic */ AvifFrame copy$default(AvifFrame avifFrame, ImageBitmap imageBitmap, double d, int i, Object obj) {
        if ((i & 1) != 0) {
            imageBitmap = avifFrame.bitmap;
        }
        if ((i & 2) != 0) {
            d = avifFrame.duration;
        }
        return avifFrame.copy(imageBitmap, d);
    }

    public final ImageBitmap component1() {
        return this.bitmap;
    }

    public final double component2() {
        return this.duration;
    }

    public final AvifFrame copy(ImageBitmap imageBitmap, double d) {
        Intrinsics.checkNotNullParameter(imageBitmap, "bitmap");
        return new AvifFrame(imageBitmap, d);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AvifFrame) {
            AvifFrame avifFrame = (AvifFrame) obj;
            return Intrinsics.areEqual(this.bitmap, avifFrame.bitmap) && Double.compare(this.duration, avifFrame.duration) == 0;
        }
        return false;
    }

    public int hashCode() {
        return (this.bitmap.hashCode() * 31) + DoubleList$.ExternalSyntheticBackport0.m(this.duration);
    }

    public String toString() {
        ImageBitmap imageBitmap = this.bitmap;
        return "AvifFrame(bitmap=" + imageBitmap + ", duration=" + this.duration + ")";
    }

    public AvifFrame(ImageBitmap bitmap, double duration) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        this.bitmap = bitmap;
        this.duration = duration;
    }

    public final ImageBitmap getBitmap() {
        return this.bitmap;
    }

    public final double getDuration() {
        return this.duration;
    }
}