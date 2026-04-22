package kotlin.reflect.jvm.internal.impl.types;

import org.slf4j.Marker;

public abstract class TypeProjectionBase implements TypeProjection {
    public String toString() {
        if (isStarProjection()) {
            return Marker.ANY_MARKER;
        }
        if (getProjectionKind() == Variance.INVARIANT) {
            return getType().toString();
        }
        return getProjectionKind() + " " + getType();
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o instanceof TypeProjection) {
            TypeProjection that = (TypeProjection) o;
            return isStarProjection() == that.isStarProjection() && getProjectionKind() == that.getProjectionKind() && getType().equals(that.getType());
        }
        return false;
    }

    public int hashCode() {
        int result = getProjectionKind().hashCode();
        if (TypeUtils.noExpectedType(getType())) {
            return (result * 31) + 19;
        }
        return (result * 31) + (isStarProjection() ? 17 : getType().hashCode());
    }
}