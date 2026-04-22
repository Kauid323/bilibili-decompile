package kntr.base.imageloader;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BfsProtocol.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u000e\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u000bJ$\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006\u001b"}, d2 = {"Lkntr/base/imageloader/ImageRegionCrop;", "", "size", "Lkntr/base/imageloader/Size;", "pos", "Lkntr/base/imageloader/Position;", "<init>", "(Lkntr/base/imageloader/Size;Ljava/lang/Integer;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getSize", "()Lkntr/base/imageloader/Size;", "getPos-78ljgRQ", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component2-78ljgRQ", "copy", "copy-wwiTXDE", "(Lkntr/base/imageloader/Size;Ljava/lang/Integer;)Lkntr/base/imageloader/ImageRegionCrop;", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "imageloader_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ImageRegionCrop {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private static final ImageRegionCrop UNSET = new ImageRegionCrop(Size.Companion.getUNSET(), Position.Companion.m1532getUNSET78ljgRQ(), null);
    private final Integer pos;
    private final Size size;

    public /* synthetic */ ImageRegionCrop(Size size, Integer num, DefaultConstructorMarker defaultConstructorMarker) {
        this(size, num);
    }

    /* renamed from: copy-wwiTXDE$default  reason: not valid java name */
    public static /* synthetic */ ImageRegionCrop m1479copywwiTXDE$default(ImageRegionCrop imageRegionCrop, Size size, Position position, int i, Object obj) {
        if ((i & 1) != 0) {
            size = imageRegionCrop.size;
        }
        if ((i & 2) != 0) {
            position = Position.m1525boximpl(imageRegionCrop.pos);
        }
        return imageRegionCrop.m1481copywwiTXDE(size, position.m1531unboximpl());
    }

    public final Size component1() {
        return this.size;
    }

    /* renamed from: component2-78ljgRQ  reason: not valid java name */
    public final Integer m1480component278ljgRQ() {
        return this.pos;
    }

    /* renamed from: copy-wwiTXDE  reason: not valid java name */
    public final ImageRegionCrop m1481copywwiTXDE(Size size, Integer num) {
        Intrinsics.checkNotNullParameter(size, "size");
        return new ImageRegionCrop(size, num, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ImageRegionCrop) {
            ImageRegionCrop imageRegionCrop = (ImageRegionCrop) obj;
            return Intrinsics.areEqual(this.size, imageRegionCrop.size) && Position.m1528equalsimpl0(this.pos, imageRegionCrop.pos);
        }
        return false;
    }

    public int hashCode() {
        return (this.size.hashCode() * 31) + Position.m1529hashCodeimpl(this.pos);
    }

    public String toString() {
        Size size = this.size;
        return "ImageRegionCrop(size=" + size + ", pos=" + Position.m1530toStringimpl(this.pos) + ")";
    }

    private ImageRegionCrop(Size size, Integer pos) {
        Intrinsics.checkNotNullParameter(size, "size");
        this.size = size;
        this.pos = pos;
    }

    public final Size getSize() {
        return this.size;
    }

    /* renamed from: getPos-78ljgRQ  reason: not valid java name */
    public final Integer m1482getPos78ljgRQ() {
        return this.pos;
    }

    /* compiled from: BfsProtocol.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lkntr/base/imageloader/ImageRegionCrop$Companion;", "", "<init>", "()V", "UNSET", "Lkntr/base/imageloader/ImageRegionCrop;", "getUNSET", "()Lkntr/base/imageloader/ImageRegionCrop;", "imageloader_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ImageRegionCrop getUNSET() {
            return ImageRegionCrop.UNSET;
        }
    }
}