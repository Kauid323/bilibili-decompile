package kotlin.reflect.jvm.internal.impl.types;

/* compiled from: TypeParameterErasureOptions.kt */
public final class TypeParameterErasureOptions {
    private final boolean intersectUpperBounds;
    private final boolean leaveNonTypeParameterTypes;

    public TypeParameterErasureOptions(boolean leaveNonTypeParameterTypes, boolean intersectUpperBounds) {
        this.leaveNonTypeParameterTypes = leaveNonTypeParameterTypes;
        this.intersectUpperBounds = intersectUpperBounds;
    }

    public final boolean getLeaveNonTypeParameterTypes() {
        return this.leaveNonTypeParameterTypes;
    }

    public final boolean getIntersectUpperBounds() {
        return this.intersectUpperBounds;
    }
}