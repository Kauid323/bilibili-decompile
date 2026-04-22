package kotlin.reflect.jvm.internal.impl.types;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: flexibleTypes.kt */
public final class FlexibleTypesKt {
    public static final boolean isFlexible(KotlinType $this$isFlexible) {
        Intrinsics.checkNotNullParameter($this$isFlexible, "<this>");
        return $this$isFlexible.unwrap() instanceof FlexibleType;
    }

    public static final FlexibleType asFlexibleType(KotlinType $this$asFlexibleType) {
        Intrinsics.checkNotNullParameter($this$asFlexibleType, "<this>");
        UnwrappedType unwrap = $this$asFlexibleType.unwrap();
        Intrinsics.checkNotNull(unwrap, "null cannot be cast to non-null type org.jetbrains.kotlin.types.FlexibleType");
        return (FlexibleType) unwrap;
    }

    public static final SimpleType lowerIfFlexible(KotlinType $this$lowerIfFlexible) {
        Intrinsics.checkNotNullParameter($this$lowerIfFlexible, "<this>");
        UnwrappedType $this$lowerIfFlexible_u24lambda_u240 = $this$lowerIfFlexible.unwrap();
        if ($this$lowerIfFlexible_u24lambda_u240 instanceof FlexibleType) {
            return ((FlexibleType) $this$lowerIfFlexible_u24lambda_u240).getLowerBound();
        }
        if ($this$lowerIfFlexible_u24lambda_u240 instanceof SimpleType) {
            return (SimpleType) $this$lowerIfFlexible_u24lambda_u240;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final SimpleType upperIfFlexible(KotlinType $this$upperIfFlexible) {
        Intrinsics.checkNotNullParameter($this$upperIfFlexible, "<this>");
        UnwrappedType $this$upperIfFlexible_u24lambda_u240 = $this$upperIfFlexible.unwrap();
        if ($this$upperIfFlexible_u24lambda_u240 instanceof FlexibleType) {
            return ((FlexibleType) $this$upperIfFlexible_u24lambda_u240).getUpperBound();
        }
        if ($this$upperIfFlexible_u24lambda_u240 instanceof SimpleType) {
            return (SimpleType) $this$upperIfFlexible_u24lambda_u240;
        }
        throw new NoWhenBranchMatchedException();
    }
}