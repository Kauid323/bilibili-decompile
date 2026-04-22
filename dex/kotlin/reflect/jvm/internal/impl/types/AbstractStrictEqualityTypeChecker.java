package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.model.FlexibleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext;

/* compiled from: AbstractStrictEqualityTypeChecker.kt */
public final class AbstractStrictEqualityTypeChecker {
    public static final AbstractStrictEqualityTypeChecker INSTANCE = new AbstractStrictEqualityTypeChecker();

    private AbstractStrictEqualityTypeChecker() {
    }

    public final boolean strictEqualTypes(TypeSystemContext context, KotlinTypeMarker a, KotlinTypeMarker b) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(a, "a");
        Intrinsics.checkNotNullParameter(b, "b");
        return strictEqualTypesInternal(context, a, b);
    }

    private final boolean strictEqualTypesInternal(TypeSystemContext $this$strictEqualTypesInternal, KotlinTypeMarker a, KotlinTypeMarker b) {
        if (a == b) {
            return true;
        }
        RigidTypeMarker simpleA = $this$strictEqualTypesInternal.asRigidType(a);
        RigidTypeMarker simpleB = $this$strictEqualTypesInternal.asRigidType(b);
        if (simpleA == null || simpleB == null) {
            FlexibleTypeMarker flexibleA = $this$strictEqualTypesInternal.asFlexibleType(a);
            FlexibleTypeMarker flexibleB = $this$strictEqualTypesInternal.asFlexibleType(b);
            if (flexibleA == null || flexibleB == null) {
                return false;
            }
            if (strictEqualRigidTypes($this$strictEqualTypesInternal, $this$strictEqualTypesInternal.lowerBound(flexibleA), $this$strictEqualTypesInternal.lowerBound(flexibleB)) && strictEqualRigidTypes($this$strictEqualTypesInternal, $this$strictEqualTypesInternal.upperBound(flexibleA), $this$strictEqualTypesInternal.upperBound(flexibleB))) {
                return true;
            }
            return false;
        }
        return strictEqualRigidTypes($this$strictEqualTypesInternal, simpleA, simpleB);
    }

    private final boolean strictEqualRigidTypes(TypeSystemContext $this$strictEqualRigidTypes, RigidTypeMarker a, RigidTypeMarker b) {
        if ($this$strictEqualRigidTypes.argumentsCount(a) == $this$strictEqualRigidTypes.argumentsCount(b) && $this$strictEqualRigidTypes.isMarkedNullable(a) == $this$strictEqualRigidTypes.isMarkedNullable(b) && $this$strictEqualRigidTypes.isDefinitelyNotNullType(a) == $this$strictEqualRigidTypes.isDefinitelyNotNullType(b) && $this$strictEqualRigidTypes.areEqualTypeConstructors($this$strictEqualRigidTypes.typeConstructor(a), $this$strictEqualRigidTypes.typeConstructor(b))) {
            if ($this$strictEqualRigidTypes.identicalArguments(a, b)) {
                return true;
            }
            int argumentsCount = $this$strictEqualRigidTypes.argumentsCount(a);
            for (int i = 0; i < argumentsCount; i++) {
                TypeArgumentMarker aArg = $this$strictEqualRigidTypes.getArgument(a, i);
                TypeArgumentMarker bArg = $this$strictEqualRigidTypes.getArgument(b, i);
                if ($this$strictEqualRigidTypes.isStarProjection(aArg) != $this$strictEqualRigidTypes.isStarProjection(bArg)) {
                    return false;
                }
                if (!$this$strictEqualRigidTypes.isStarProjection(aArg)) {
                    if ($this$strictEqualRigidTypes.getVariance(aArg) != $this$strictEqualRigidTypes.getVariance(bArg)) {
                        return false;
                    }
                    KotlinTypeMarker type = $this$strictEqualRigidTypes.getType(aArg);
                    Intrinsics.checkNotNull(type);
                    KotlinTypeMarker type2 = $this$strictEqualRigidTypes.getType(bArg);
                    Intrinsics.checkNotNull(type2);
                    if (!strictEqualTypesInternal($this$strictEqualRigidTypes, type, type2)) {
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }
}