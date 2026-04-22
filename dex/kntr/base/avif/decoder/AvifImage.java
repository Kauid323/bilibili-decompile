package kntr.base.avif.decoder;

import BottomSheetItemData$;
import androidx.compose.ui.graphics.ImageBitmap;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AvifDecoder.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\tHÆ\u0003J;\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\t2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, d2 = {"Lkntr/base/avif/decoder/AvifImage;", "", "bitmap", "Landroidx/compose/ui/graphics/ImageBitmap;", "width", "", "height", "depth", "alphaPresent", "", "<init>", "(Landroidx/compose/ui/graphics/ImageBitmap;IIIZ)V", "getBitmap", "()Landroidx/compose/ui/graphics/ImageBitmap;", "getWidth", "()I", "getHeight", "getDepth", "getAlphaPresent", "()Z", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "", "avif_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class AvifImage {
    public static final int $stable = 8;
    private final boolean alphaPresent;
    private final ImageBitmap bitmap;
    private final int depth;
    private final int height;
    private final int width;

    public static /* synthetic */ AvifImage copy$default(AvifImage avifImage, ImageBitmap imageBitmap, int i, int i2, int i3, boolean z, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            imageBitmap = avifImage.bitmap;
        }
        if ((i4 & 2) != 0) {
            i = avifImage.width;
        }
        int i5 = i;
        if ((i4 & 4) != 0) {
            i2 = avifImage.height;
        }
        int i6 = i2;
        if ((i4 & 8) != 0) {
            i3 = avifImage.depth;
        }
        int i7 = i3;
        if ((i4 & 16) != 0) {
            z = avifImage.alphaPresent;
        }
        return avifImage.copy(imageBitmap, i5, i6, i7, z);
    }

    public final ImageBitmap component1() {
        return this.bitmap;
    }

    public final int component2() {
        return this.width;
    }

    public final int component3() {
        return this.height;
    }

    public final int component4() {
        return this.depth;
    }

    public final boolean component5() {
        return this.alphaPresent;
    }

    public final AvifImage copy(ImageBitmap imageBitmap, int i, int i2, int i3, boolean z) {
        Intrinsics.checkNotNullParameter(imageBitmap, "bitmap");
        return new AvifImage(imageBitmap, i, i2, i3, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AvifImage) {
            AvifImage avifImage = (AvifImage) obj;
            return Intrinsics.areEqual(this.bitmap, avifImage.bitmap) && this.width == avifImage.width && this.height == avifImage.height && this.depth == avifImage.depth && this.alphaPresent == avifImage.alphaPresent;
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.bitmap.hashCode() * 31) + this.width) * 31) + this.height) * 31) + this.depth) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.alphaPresent);
    }

    public String toString() {
        ImageBitmap imageBitmap = this.bitmap;
        int i = this.width;
        int i2 = this.height;
        int i3 = this.depth;
        return "AvifImage(bitmap=" + imageBitmap + ", width=" + i + ", height=" + i2 + ", depth=" + i3 + ", alphaPresent=" + this.alphaPresent + ")";
    }

    public AvifImage(ImageBitmap bitmap, int width, int height, int depth, boolean alphaPresent) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        this.bitmap = bitmap;
        this.width = width;
        this.height = height;
        this.depth = depth;
        this.alphaPresent = alphaPresent;
    }

    public /* synthetic */ AvifImage(ImageBitmap imageBitmap, int i, int i2, int i3, boolean z, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(imageBitmap, (i4 & 2) != 0 ? 0 : i, (i4 & 4) != 0 ? 0 : i2, (i4 & 8) != 0 ? 0 : i3, (i4 & 16) != 0 ? false : z);
    }

    public final ImageBitmap getBitmap() {
        return this.bitmap;
    }

    public final int getWidth() {
        return this.width;
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getDepth() {
        return this.depth;
    }

    public final boolean getAlphaPresent() {
        return this.alphaPresent;
    }
}