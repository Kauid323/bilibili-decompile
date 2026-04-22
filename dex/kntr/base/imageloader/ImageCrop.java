package kntr.base.imageloader;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: BfsProtocol.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 !2\u00020\u0001:\u0001!B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u000f\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0010\u0010\nJ\u0010\u0010\u0011\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0012\u0010\nJ\u0010\u0010\u0013\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0014\u0010\nJ\u0010\u0010\u0015\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0016\u0010\nJ8\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\f\u0010\nR\u0013\u0010\u0005\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\r\u0010\nR\u0013\u0010\u0006\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\u000e\u0010\n¨\u0006\""}, d2 = {"Lkntr/base/imageloader/ImageCrop;", "", "left", "Lkntr/base/imageloader/Pixel;", "top", "right", "bottom", "<init>", "(IIIILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getLeft-uhUG8m8", "()I", "I", "getTop-uhUG8m8", "getRight-uhUG8m8", "getBottom-uhUG8m8", "component1", "component1-uhUG8m8", "component2", "component2-uhUG8m8", "component3", "component3-uhUG8m8", "component4", "component4-uhUG8m8", "copy", "copy-h2Ina5c", "(IIII)Lkntr/base/imageloader/ImageCrop;", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "imageloader_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ImageCrop {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private static final ImageCrop UNSET = new ImageCrop(Pixel.Companion.m1523getUNSETuhUG8m8(), Pixel.Companion.m1523getUNSETuhUG8m8(), Pixel.Companion.m1523getUNSETuhUG8m8(), Pixel.Companion.m1523getUNSETuhUG8m8(), null);
    private final int bottom;
    private final int left;
    private final int right;
    private final int top;

    public /* synthetic */ ImageCrop(int i, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, i3, i4);
    }

    /* renamed from: copy-h2Ina5c$default  reason: not valid java name */
    public static /* synthetic */ ImageCrop m1455copyh2Ina5c$default(ImageCrop imageCrop, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = imageCrop.left;
        }
        if ((i5 & 2) != 0) {
            i2 = imageCrop.top;
        }
        if ((i5 & 4) != 0) {
            i3 = imageCrop.right;
        }
        if ((i5 & 8) != 0) {
            i4 = imageCrop.bottom;
        }
        return imageCrop.m1460copyh2Ina5c(i, i2, i3, i4);
    }

    /* renamed from: component1-uhUG8m8  reason: not valid java name */
    public final int m1456component1uhUG8m8() {
        return this.left;
    }

    /* renamed from: component2-uhUG8m8  reason: not valid java name */
    public final int m1457component2uhUG8m8() {
        return this.top;
    }

    /* renamed from: component3-uhUG8m8  reason: not valid java name */
    public final int m1458component3uhUG8m8() {
        return this.right;
    }

    /* renamed from: component4-uhUG8m8  reason: not valid java name */
    public final int m1459component4uhUG8m8() {
        return this.bottom;
    }

    /* renamed from: copy-h2Ina5c  reason: not valid java name */
    public final ImageCrop m1460copyh2Ina5c(int i, int i2, int i3, int i4) {
        return new ImageCrop(i, i2, i3, i4, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ImageCrop) {
            ImageCrop imageCrop = (ImageCrop) obj;
            return Pixel.m1519equalsimpl0(this.left, imageCrop.left) && Pixel.m1519equalsimpl0(this.top, imageCrop.top) && Pixel.m1519equalsimpl0(this.right, imageCrop.right) && Pixel.m1519equalsimpl0(this.bottom, imageCrop.bottom);
        }
        return false;
    }

    public int hashCode() {
        return (((((Pixel.m1520hashCodeimpl(this.left) * 31) + Pixel.m1520hashCodeimpl(this.top)) * 31) + Pixel.m1520hashCodeimpl(this.right)) * 31) + Pixel.m1520hashCodeimpl(this.bottom);
    }

    public String toString() {
        String m1521toStringimpl = Pixel.m1521toStringimpl(this.left);
        String m1521toStringimpl2 = Pixel.m1521toStringimpl(this.top);
        String m1521toStringimpl3 = Pixel.m1521toStringimpl(this.right);
        return "ImageCrop(left=" + m1521toStringimpl + ", top=" + m1521toStringimpl2 + ", right=" + m1521toStringimpl3 + ", bottom=" + Pixel.m1521toStringimpl(this.bottom) + ")";
    }

    private ImageCrop(int left, int top, int right, int bottom) {
        this.left = left;
        this.top = top;
        this.right = right;
        this.bottom = bottom;
    }

    /* renamed from: getLeft-uhUG8m8  reason: not valid java name */
    public final int m1462getLeftuhUG8m8() {
        return this.left;
    }

    /* renamed from: getTop-uhUG8m8  reason: not valid java name */
    public final int m1464getTopuhUG8m8() {
        return this.top;
    }

    /* renamed from: getRight-uhUG8m8  reason: not valid java name */
    public final int m1463getRightuhUG8m8() {
        return this.right;
    }

    /* renamed from: getBottom-uhUG8m8  reason: not valid java name */
    public final int m1461getBottomuhUG8m8() {
        return this.bottom;
    }

    /* compiled from: BfsProtocol.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lkntr/base/imageloader/ImageCrop$Companion;", "", "<init>", "()V", "UNSET", "Lkntr/base/imageloader/ImageCrop;", "getUNSET", "()Lkntr/base/imageloader/ImageCrop;", "imageloader_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ImageCrop getUNSET() {
            return ImageCrop.UNSET;
        }
    }
}