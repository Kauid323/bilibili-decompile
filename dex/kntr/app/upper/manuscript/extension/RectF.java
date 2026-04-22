package kntr.app.upper.manuscript.extension;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RectF.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 J\b\u0010!\u001a\u00020\"H\u0016J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J1\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010(\u001a\u00020\u001e2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010*\u001a\u00020+HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR\u0011\u0010\u0013\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\nR\u0011\u0010\u0015\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\nR\u0011\u0010\u0017\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\nR\u0011\u0010\u0019\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\nR\u0011\u0010\u001b\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\n¨\u0006,"}, d2 = {"Lkntr/app/upper/manuscript/extension/RectF;", "", "left", "", "top", "right", "bottom", "<init>", "(FFFF)V", "getLeft", "()F", "setLeft", "(F)V", "getTop", "setTop", "getRight", "setRight", "getBottom", "setBottom", "width", "getWidth", "height", "getHeight", "ratio", "getRatio", "centerX", "getCenterX", "centerY", "getCenterY", "isValid", "", "max", "Lkntr/app/upper/manuscript/extension/Size;", "toString", "", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "manuscript_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class RectF {
    private float bottom;
    private float left;
    private float right;
    private float top;

    public static /* synthetic */ RectF copy$default(RectF rectF, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = rectF.left;
        }
        if ((i & 2) != 0) {
            f2 = rectF.top;
        }
        if ((i & 4) != 0) {
            f3 = rectF.right;
        }
        if ((i & 8) != 0) {
            f4 = rectF.bottom;
        }
        return rectF.copy(f, f2, f3, f4);
    }

    public final float component1() {
        return this.left;
    }

    public final float component2() {
        return this.top;
    }

    public final float component3() {
        return this.right;
    }

    public final float component4() {
        return this.bottom;
    }

    public final RectF copy(float f, float f2, float f3, float f4) {
        return new RectF(f, f2, f3, f4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RectF) {
            RectF rectF = (RectF) obj;
            return Float.compare(this.left, rectF.left) == 0 && Float.compare(this.top, rectF.top) == 0 && Float.compare(this.right, rectF.right) == 0 && Float.compare(this.bottom, rectF.bottom) == 0;
        }
        return false;
    }

    public int hashCode() {
        return (((((Float.floatToIntBits(this.left) * 31) + Float.floatToIntBits(this.top)) * 31) + Float.floatToIntBits(this.right)) * 31) + Float.floatToIntBits(this.bottom);
    }

    public RectF(float left, float top, float right, float bottom) {
        this.left = left;
        this.top = top;
        this.right = right;
        this.bottom = bottom;
    }

    public final float getLeft() {
        return this.left;
    }

    public final void setLeft(float f) {
        this.left = f;
    }

    public final float getTop() {
        return this.top;
    }

    public final void setTop(float f) {
        this.top = f;
    }

    public final float getRight() {
        return this.right;
    }

    public final void setRight(float f) {
        this.right = f;
    }

    public final float getBottom() {
        return this.bottom;
    }

    public final void setBottom(float f) {
        this.bottom = f;
    }

    public final float getWidth() {
        return this.right - this.left;
    }

    public final float getHeight() {
        return this.bottom - this.top;
    }

    public final float getRatio() {
        return getWidth() / getHeight();
    }

    public final float getCenterX() {
        return (this.left + this.right) / 2;
    }

    public final float getCenterY() {
        return (this.top + this.bottom) / 2;
    }

    public final boolean isValid(Size max) {
        Intrinsics.checkNotNullParameter(max, "max");
        return this.left >= 0.0f && this.top >= 0.0f && this.right <= max.getWidth() && this.bottom <= max.getHeight();
    }

    public String toString() {
        float f = this.left;
        float f2 = this.top;
        float f3 = this.right;
        float f4 = this.bottom;
        float width = getWidth();
        float height = getHeight();
        float ratio = getRatio();
        float centerX = getCenterX();
        return "RectF(left=" + f + ", top=" + f2 + ", right=" + f3 + ", bottom=" + f4 + ", width=" + width + ", height=" + height + ", ratio=" + ratio + ", centerX=" + centerX + ", centerY=" + getCenterY() + ")";
    }
}