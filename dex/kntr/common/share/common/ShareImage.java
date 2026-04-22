package kntr.common.share.common;

import androidx.compose.ui.graphics.ImageBitmap;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ShareImage.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bw\u0018\u00002\u00020\u0001:\u0001\u0004J\b\u0010\u0002\u001a\u00020\u0003H'\u0082\u0001\u0001\u0005¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lkntr/common/share/common/ShareImage;", "", "content", "Landroidx/compose/ui/graphics/ImageBitmap;", "Raw", "Lkntr/common/share/common/ShareImage$Raw;", "common_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface ShareImage {
    ImageBitmap content();

    /* compiled from: ShareImage.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\t\u0010\u0007\u001a\u00020\u0003HÂ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lkntr/common/share/common/ShareImage$Raw;", "Lkntr/common/share/common/ShareImage;", "image", "Landroidx/compose/ui/graphics/ImageBitmap;", "<init>", "(Landroidx/compose/ui/graphics/ImageBitmap;)V", "content", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "common_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Raw implements ShareImage {
        public static final int $stable = 8;
        private final ImageBitmap image;

        private final ImageBitmap component1() {
            return this.image;
        }

        public static /* synthetic */ Raw copy$default(Raw raw, ImageBitmap imageBitmap, int i, Object obj) {
            if ((i & 1) != 0) {
                imageBitmap = raw.image;
            }
            return raw.copy(imageBitmap);
        }

        public final Raw copy(ImageBitmap imageBitmap) {
            Intrinsics.checkNotNullParameter(imageBitmap, "image");
            return new Raw(imageBitmap);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Raw) && Intrinsics.areEqual(this.image, ((Raw) obj).image);
        }

        public int hashCode() {
            return this.image.hashCode();
        }

        public String toString() {
            return "Raw(image=" + this.image + ")";
        }

        public Raw(ImageBitmap image) {
            Intrinsics.checkNotNullParameter(image, "image");
            this.image = image;
        }

        @Override // kntr.common.share.common.ShareImage
        public ImageBitmap content() {
            return this.image;
        }
    }
}