package kntr.app.upper.manuscript.extension;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;

/* compiled from: Size.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\n\u001a\u00020\u000bH\u0016J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lkntr/app/upper/manuscript/extension/Size;", "", "width", "", "height", "<init>", "(FF)V", "getWidth", "()F", "getHeight", "toString", "", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "manuscript_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class Size {
    private final float height;
    private final float width;

    public static /* synthetic */ Size copy$default(Size size, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = size.width;
        }
        if ((i & 2) != 0) {
            f2 = size.height;
        }
        return size.copy(f, f2);
    }

    public final float component1() {
        return this.width;
    }

    public final float component2() {
        return this.height;
    }

    public final Size copy(float f, float f2) {
        return new Size(f, f2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Size) {
            Size size = (Size) obj;
            return Float.compare(this.width, size.width) == 0 && Float.compare(this.height, size.height) == 0;
        }
        return false;
    }

    public int hashCode() {
        return (Float.floatToIntBits(this.width) * 31) + Float.floatToIntBits(this.height);
    }

    public Size(float width, float height) {
        this.width = width;
        this.height = height;
    }

    public final float getWidth() {
        return this.width;
    }

    public final float getHeight() {
        return this.height;
    }

    public String toString() {
        float f = this.width;
        return "Size(width=" + f + ", height=" + this.height + ")";
    }
}