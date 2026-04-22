package kntr.compose.avatar.model.common;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: GeneralSpec.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lkntr/compose/avatar/model/common/SizeSpec;", "", "width", "", "height", "<init>", "(FF)V", "getWidth", "()F", "getHeight", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "model_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class SizeSpec {
    private final float height;
    private final float width;

    public SizeSpec() {
        this(0.0f, 0.0f, 3, null);
    }

    public static /* synthetic */ SizeSpec copy$default(SizeSpec sizeSpec, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = sizeSpec.width;
        }
        if ((i & 2) != 0) {
            f2 = sizeSpec.height;
        }
        return sizeSpec.copy(f, f2);
    }

    public final float component1() {
        return this.width;
    }

    public final float component2() {
        return this.height;
    }

    public final SizeSpec copy(float f, float f2) {
        return new SizeSpec(f, f2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SizeSpec) {
            SizeSpec sizeSpec = (SizeSpec) obj;
            return Float.compare(this.width, sizeSpec.width) == 0 && Float.compare(this.height, sizeSpec.height) == 0;
        }
        return false;
    }

    public int hashCode() {
        return (Float.floatToIntBits(this.width) * 31) + Float.floatToIntBits(this.height);
    }

    public String toString() {
        float f = this.width;
        return "SizeSpec(width=" + f + ", height=" + this.height + ")";
    }

    public SizeSpec(float width, float height) {
        this.width = width;
        this.height = height;
    }

    public /* synthetic */ SizeSpec(float f, float f2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 1.0f : f, (i & 2) != 0 ? 1.0f : f2);
    }

    public final float getWidth() {
        return this.width;
    }

    public final float getHeight() {
        return this.height;
    }
}