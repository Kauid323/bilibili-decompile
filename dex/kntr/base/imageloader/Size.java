package kntr.base.imageloader;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: SizeController.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u000b\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\f\u0010\bJ\u0010\u0010\r\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u000e\u0010\bJ$\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\n\u0010\b¨\u0006\u001a"}, d2 = {"Lkntr/base/imageloader/Size;", "", "width", "Lkntr/base/imageloader/Pixel;", "height", "<init>", "(IILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getWidth-uhUG8m8", "()I", "I", "getHeight-uhUG8m8", "component1", "component1-uhUG8m8", "component2", "component2-uhUG8m8", "copy", "copy-Ic4ZqO0", "(II)Lkntr/base/imageloader/Size;", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "imageloader_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class Size {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private static final Size UNSET = new Size(Pixel.Companion.m1523getUNSETuhUG8m8(), Pixel.Companion.m1523getUNSETuhUG8m8(), null);
    private final int height;
    private final int width;

    public /* synthetic */ Size(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2);
    }

    /* renamed from: copy-Ic4ZqO0$default  reason: not valid java name */
    public static /* synthetic */ Size m1572copyIc4ZqO0$default(Size size, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = size.width;
        }
        if ((i3 & 2) != 0) {
            i2 = size.height;
        }
        return size.m1575copyIc4ZqO0(i, i2);
    }

    /* renamed from: component1-uhUG8m8  reason: not valid java name */
    public final int m1573component1uhUG8m8() {
        return this.width;
    }

    /* renamed from: component2-uhUG8m8  reason: not valid java name */
    public final int m1574component2uhUG8m8() {
        return this.height;
    }

    /* renamed from: copy-Ic4ZqO0  reason: not valid java name */
    public final Size m1575copyIc4ZqO0(int i, int i2) {
        return new Size(i, i2, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Size) {
            Size size = (Size) obj;
            return Pixel.m1519equalsimpl0(this.width, size.width) && Pixel.m1519equalsimpl0(this.height, size.height);
        }
        return false;
    }

    public int hashCode() {
        return (Pixel.m1520hashCodeimpl(this.width) * 31) + Pixel.m1520hashCodeimpl(this.height);
    }

    public String toString() {
        String m1521toStringimpl = Pixel.m1521toStringimpl(this.width);
        return "Size(width=" + m1521toStringimpl + ", height=" + Pixel.m1521toStringimpl(this.height) + ")";
    }

    private Size(int width, int height) {
        this.width = width;
        this.height = height;
    }

    /* renamed from: getWidth-uhUG8m8  reason: not valid java name */
    public final int m1577getWidthuhUG8m8() {
        return this.width;
    }

    /* renamed from: getHeight-uhUG8m8  reason: not valid java name */
    public final int m1576getHeightuhUG8m8() {
        return this.height;
    }

    /* compiled from: SizeController.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lkntr/base/imageloader/Size$Companion;", "", "<init>", "()V", "UNSET", "Lkntr/base/imageloader/Size;", "getUNSET", "()Lkntr/base/imageloader/Size;", "imageloader_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Size getUNSET() {
            return Size.UNSET;
        }
    }
}