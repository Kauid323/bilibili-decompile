package kntr.compose.avatar.model.common;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GeneralSpec.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J'\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u000f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0010¨\u0006\u001b"}, d2 = {"Lkntr/compose/avatar/model/common/PositionSpec;", "", "x", "", "y", "position", "Lkntr/compose/avatar/model/common/Coordinate;", "<init>", "(FFLkntr/compose/avatar/model/common/Coordinate;)V", "getX", "()F", "getY", "getPosition", "()Lkntr/compose/avatar/model/common/Coordinate;", "isValid", "", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "model_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class PositionSpec {
    private final Coordinate position;
    private final float x;
    private final float y;

    public PositionSpec() {
        this(0.0f, 0.0f, null, 7, null);
    }

    public static /* synthetic */ PositionSpec copy$default(PositionSpec positionSpec, float f, float f2, Coordinate coordinate, int i, Object obj) {
        if ((i & 1) != 0) {
            f = positionSpec.x;
        }
        if ((i & 2) != 0) {
            f2 = positionSpec.y;
        }
        if ((i & 4) != 0) {
            coordinate = positionSpec.position;
        }
        return positionSpec.copy(f, f2, coordinate);
    }

    public final float component1() {
        return this.x;
    }

    public final float component2() {
        return this.y;
    }

    public final Coordinate component3() {
        return this.position;
    }

    public final PositionSpec copy(float f, float f2, Coordinate coordinate) {
        Intrinsics.checkNotNullParameter(coordinate, "position");
        return new PositionSpec(f, f2, coordinate);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PositionSpec) {
            PositionSpec positionSpec = (PositionSpec) obj;
            return Float.compare(this.x, positionSpec.x) == 0 && Float.compare(this.y, positionSpec.y) == 0 && this.position == positionSpec.position;
        }
        return false;
    }

    public int hashCode() {
        return (((Float.floatToIntBits(this.x) * 31) + Float.floatToIntBits(this.y)) * 31) + this.position.hashCode();
    }

    public String toString() {
        float f = this.x;
        float f2 = this.y;
        return "PositionSpec(x=" + f + ", y=" + f2 + ", position=" + this.position + ")";
    }

    public PositionSpec(float x, float y, Coordinate position) {
        Intrinsics.checkNotNullParameter(position, "position");
        this.x = x;
        this.y = y;
        this.position = position;
    }

    public /* synthetic */ PositionSpec(float f, float f2, Coordinate coordinate, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0.0f : f, (i & 2) != 0 ? 0.0f : f2, (i & 4) != 0 ? Coordinate.Default : coordinate);
    }

    public final float getX() {
        return this.x;
    }

    public final float getY() {
        return this.y;
    }

    public final Coordinate getPosition() {
        return this.position;
    }

    public final boolean isValid() {
        return this.position != Coordinate.Invalid;
    }
}