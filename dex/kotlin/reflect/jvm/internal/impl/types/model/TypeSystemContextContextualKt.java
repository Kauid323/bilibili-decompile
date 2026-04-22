package kotlin.reflect.jvm.internal.impl.types.model;

import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TypeSystemContextContextual.kt */
public final class TypeSystemContextContextualKt {
    public static final RigidTypeMarker asRigidType(TypeSystemContext c, KotlinTypeMarker $this$asRigidType) {
        Intrinsics.checkNotNullParameter(c, "c");
        Intrinsics.checkNotNullParameter($this$asRigidType, "<this>");
        return c.asRigidType($this$asRigidType);
    }

    public static final FlexibleTypeMarker asFlexibleType(TypeSystemContext c, KotlinTypeMarker $this$asFlexibleType) {
        Intrinsics.checkNotNullParameter(c, "c");
        Intrinsics.checkNotNullParameter($this$asFlexibleType, "<this>");
        return c.asFlexibleType($this$asFlexibleType);
    }

    public static final boolean isError(TypeSystemContext c, KotlinTypeMarker $this$isError) {
        Intrinsics.checkNotNullParameter(c, "c");
        Intrinsics.checkNotNullParameter($this$isError, "<this>");
        return c.isError($this$isError);
    }

    public static final RigidTypeMarker lowerBound(TypeSystemContext c, FlexibleTypeMarker $this$lowerBound) {
        Intrinsics.checkNotNullParameter(c, "c");
        Intrinsics.checkNotNullParameter($this$lowerBound, "<this>");
        return c.lowerBound($this$lowerBound);
    }

    public static final CapturedTypeMarker asCapturedTypeUnwrappingDnn(TypeSystemContext c, RigidTypeMarker $this$asCapturedTypeUnwrappingDnn) {
        Intrinsics.checkNotNullParameter(c, "c");
        Intrinsics.checkNotNullParameter($this$asCapturedTypeUnwrappingDnn, "<this>");
        return c.asCapturedTypeUnwrappingDnn($this$asCapturedTypeUnwrappingDnn);
    }

    public static final boolean isCapturedType(TypeSystemContext c, KotlinTypeMarker $this$isCapturedType) {
        Intrinsics.checkNotNullParameter(c, "c");
        Intrinsics.checkNotNullParameter($this$isCapturedType, "<this>");
        return c.isCapturedType($this$isCapturedType);
    }

    public static final SimpleTypeMarker originalIfDefinitelyNotNullable(TypeSystemContext c, RigidTypeMarker $this$originalIfDefinitelyNotNullable) {
        Intrinsics.checkNotNullParameter(c, "c");
        Intrinsics.checkNotNullParameter($this$originalIfDefinitelyNotNullable, "<this>");
        return c.originalIfDefinitelyNotNullable($this$originalIfDefinitelyNotNullable);
    }

    public static final KotlinTypeMarker makeDefinitelyNotNullOrNotNull(TypeSystemContext c, KotlinTypeMarker $this$makeDefinitelyNotNullOrNotNull) {
        Intrinsics.checkNotNullParameter(c, "c");
        Intrinsics.checkNotNullParameter($this$makeDefinitelyNotNullOrNotNull, "<this>");
        return c.makeDefinitelyNotNullOrNotNull($this$makeDefinitelyNotNullOrNotNull);
    }

    public static final boolean isMarkedNullable(TypeSystemContext c, KotlinTypeMarker $this$isMarkedNullable) {
        Intrinsics.checkNotNullParameter(c, "c");
        Intrinsics.checkNotNullParameter($this$isMarkedNullable, "<this>");
        return c.isMarkedNullable($this$isMarkedNullable);
    }

    public static final RigidTypeMarker withNullability(TypeSystemContext c, RigidTypeMarker $this$withNullability, boolean nullable) {
        Intrinsics.checkNotNullParameter(c, "c");
        Intrinsics.checkNotNullParameter($this$withNullability, "<this>");
        return c.withNullability($this$withNullability, nullable);
    }

    public static final TypeConstructorMarker typeConstructor(TypeSystemContext c, RigidTypeMarker $this$typeConstructor) {
        Intrinsics.checkNotNullParameter(c, "c");
        Intrinsics.checkNotNullParameter($this$typeConstructor, "<this>");
        return c.typeConstructor($this$typeConstructor);
    }

    public static final KotlinTypeMarker withNullability(TypeSystemContext c, KotlinTypeMarker $this$withNullability, boolean nullable) {
        Intrinsics.checkNotNullParameter(c, "c");
        Intrinsics.checkNotNullParameter($this$withNullability, "<this>");
        return c.withNullability($this$withNullability, nullable);
    }

    public static final boolean isOldCapturedType(TypeSystemContext c, CapturedTypeMarker $this$isOldCapturedType) {
        Intrinsics.checkNotNullParameter(c, "c");
        Intrinsics.checkNotNullParameter($this$isOldCapturedType, "<this>");
        return c.isOldCapturedType($this$isOldCapturedType);
    }

    public static final CapturedTypeConstructorMarker typeConstructor(TypeSystemContext c, CapturedTypeMarker $this$typeConstructor) {
        Intrinsics.checkNotNullParameter(c, "c");
        Intrinsics.checkNotNullParameter($this$typeConstructor, "<this>");
        return c.typeConstructor($this$typeConstructor);
    }

    public static final CaptureStatus captureStatus(TypeSystemContext c, CapturedTypeMarker $this$captureStatus) {
        Intrinsics.checkNotNullParameter(c, "c");
        Intrinsics.checkNotNullParameter($this$captureStatus, "<this>");
        return c.captureStatus($this$captureStatus);
    }

    public static final TypeArgumentMarker projection(TypeSystemContext c, CapturedTypeConstructorMarker $this$projection) {
        Intrinsics.checkNotNullParameter(c, "c");
        Intrinsics.checkNotNullParameter($this$projection, "<this>");
        return c.projection($this$projection);
    }

    public static final int argumentsCount(TypeSystemContext c, KotlinTypeMarker $this$argumentsCount) {
        Intrinsics.checkNotNullParameter(c, "c");
        Intrinsics.checkNotNullParameter($this$argumentsCount, "<this>");
        return c.argumentsCount($this$argumentsCount);
    }

    public static final TypeArgumentMarker getArgument(TypeSystemContext c, KotlinTypeMarker $this$getArgument, int index) {
        Intrinsics.checkNotNullParameter(c, "c");
        Intrinsics.checkNotNullParameter($this$getArgument, "<this>");
        return c.getArgument($this$getArgument, index);
    }

    public static final TypeArgumentMarker getArgumentOrNull(TypeSystemContext c, RigidTypeMarker $this$getArgumentOrNull, int index) {
        Intrinsics.checkNotNullParameter(c, "c");
        Intrinsics.checkNotNullParameter($this$getArgumentOrNull, "<this>");
        return c.getArgumentOrNull($this$getArgumentOrNull, index);
    }

    public static final boolean isStubType(TypeSystemContext c, RigidTypeMarker $this$isStubType) {
        Intrinsics.checkNotNullParameter(c, "c");
        Intrinsics.checkNotNullParameter($this$isStubType, "<this>");
        return c.isStubType($this$isStubType);
    }

    public static final boolean isStubTypeForBuilderInference(TypeSystemContext c, RigidTypeMarker $this$isStubTypeForBuilderInference) {
        Intrinsics.checkNotNullParameter(c, "c");
        Intrinsics.checkNotNullParameter($this$isStubTypeForBuilderInference, "<this>");
        return c.isStubTypeForBuilderInference($this$isStubTypeForBuilderInference);
    }

    public static final TypeArgumentMarker asTypeArgument(TypeSystemContext c, KotlinTypeMarker $this$asTypeArgument) {
        Intrinsics.checkNotNullParameter(c, "c");
        Intrinsics.checkNotNullParameter($this$asTypeArgument, "<this>");
        return c.asTypeArgument($this$asTypeArgument);
    }

    public static final KotlinTypeMarker lowerType(TypeSystemContext c, CapturedTypeMarker $this$lowerType) {
        Intrinsics.checkNotNullParameter(c, "c");
        Intrinsics.checkNotNullParameter($this$lowerType, "<this>");
        return c.lowerType($this$lowerType);
    }

    public static final boolean isStarProjection(TypeSystemContext c, TypeArgumentMarker $this$isStarProjection) {
        Intrinsics.checkNotNullParameter(c, "c");
        Intrinsics.checkNotNullParameter($this$isStarProjection, "<this>");
        return c.isStarProjection($this$isStarProjection);
    }

    public static final TypeVariance getVariance(TypeSystemContext c, TypeArgumentMarker $this$getVariance) {
        Intrinsics.checkNotNullParameter(c, "c");
        Intrinsics.checkNotNullParameter($this$getVariance, "<this>");
        return c.getVariance($this$getVariance);
    }

    public static final KotlinTypeMarker getType(TypeSystemContext c, TypeArgumentMarker $this$getType) {
        Intrinsics.checkNotNullParameter(c, "c");
        Intrinsics.checkNotNullParameter($this$getType, "<this>");
        return c.getType($this$getType);
    }

    public static final int parametersCount(TypeSystemContext c, TypeConstructorMarker $this$parametersCount) {
        Intrinsics.checkNotNullParameter(c, "c");
        Intrinsics.checkNotNullParameter($this$parametersCount, "<this>");
        return c.parametersCount($this$parametersCount);
    }

    public static final TypeParameterMarker getParameter(TypeSystemContext c, TypeConstructorMarker $this$getParameter, int index) {
        Intrinsics.checkNotNullParameter(c, "c");
        Intrinsics.checkNotNullParameter($this$getParameter, "<this>");
        return c.getParameter($this$getParameter, index);
    }

    public static final Collection<KotlinTypeMarker> supertypes(TypeSystemContext c, TypeConstructorMarker $this$supertypes) {
        Intrinsics.checkNotNullParameter(c, "c");
        Intrinsics.checkNotNullParameter($this$supertypes, "<this>");
        return c.supertypes($this$supertypes);
    }

    public static final boolean isIntersection(TypeSystemContext c, TypeConstructorMarker $this$isIntersection) {
        Intrinsics.checkNotNullParameter(c, "c");
        Intrinsics.checkNotNullParameter($this$isIntersection, "<this>");
        return c.isIntersection($this$isIntersection);
    }

    public static final boolean isClassTypeConstructor(TypeSystemContext c, TypeConstructorMarker $this$isClassTypeConstructor) {
        Intrinsics.checkNotNullParameter(c, "c");
        Intrinsics.checkNotNullParameter($this$isClassTypeConstructor, "<this>");
        return c.isClassTypeConstructor($this$isClassTypeConstructor);
    }

    public static final boolean isIntegerLiteralTypeConstructor(TypeSystemContext c, TypeConstructorMarker $this$isIntegerLiteralTypeConstructor) {
        Intrinsics.checkNotNullParameter(c, "c");
        Intrinsics.checkNotNullParameter($this$isIntegerLiteralTypeConstructor, "<this>");
        return c.isIntegerLiteralTypeConstructor($this$isIntegerLiteralTypeConstructor);
    }

    public static final TypeParameterMarker getTypeParameter(TypeSystemContext c, TypeVariableTypeConstructorMarker $this$typeParameter) {
        Intrinsics.checkNotNullParameter(c, "c");
        Intrinsics.checkNotNullParameter($this$typeParameter, "<this>");
        return c.getTypeParameter($this$typeParameter);
    }

    public static final TypeVariance getVariance(TypeSystemContext c, TypeParameterMarker $this$getVariance) {
        Intrinsics.checkNotNullParameter(c, "c");
        Intrinsics.checkNotNullParameter($this$getVariance, "<this>");
        return c.getVariance($this$getVariance);
    }

    public static final boolean hasRecursiveBounds(TypeSystemContext c, TypeParameterMarker $this$hasRecursiveBounds, TypeConstructorMarker selfConstructor) {
        Intrinsics.checkNotNullParameter(c, "c");
        Intrinsics.checkNotNullParameter($this$hasRecursiveBounds, "<this>");
        return c.hasRecursiveBounds($this$hasRecursiveBounds, selfConstructor);
    }

    public static final boolean isDenotable(TypeSystemContext c, TypeConstructorMarker $this$isDenotable) {
        Intrinsics.checkNotNullParameter(c, "c");
        Intrinsics.checkNotNullParameter($this$isDenotable, "<this>");
        return c.isDenotable($this$isDenotable);
    }

    public static final RigidTypeMarker lowerBoundIfFlexible(TypeSystemContext c, KotlinTypeMarker $this$lowerBoundIfFlexible) {
        Intrinsics.checkNotNullParameter(c, "c");
        Intrinsics.checkNotNullParameter($this$lowerBoundIfFlexible, "<this>");
        return c.lowerBoundIfFlexible($this$lowerBoundIfFlexible);
    }

    public static final RigidTypeMarker upperBoundIfFlexible(TypeSystemContext c, KotlinTypeMarker $this$upperBoundIfFlexible) {
        Intrinsics.checkNotNullParameter(c, "c");
        Intrinsics.checkNotNullParameter($this$upperBoundIfFlexible, "<this>");
        return c.upperBoundIfFlexible($this$upperBoundIfFlexible);
    }

    public static final boolean isFlexibleWithDifferentTypeConstructors(TypeSystemContext c, KotlinTypeMarker $this$isFlexibleWithDifferentTypeConstructors) {
        Intrinsics.checkNotNullParameter(c, "c");
        Intrinsics.checkNotNullParameter($this$isFlexibleWithDifferentTypeConstructors, "<this>");
        return c.isFlexibleWithDifferentTypeConstructors($this$isFlexibleWithDifferentTypeConstructors);
    }

    public static final boolean isFlexible(TypeSystemContext c, KotlinTypeMarker $this$isFlexible) {
        Intrinsics.checkNotNullParameter(c, "c");
        Intrinsics.checkNotNullParameter($this$isFlexible, "<this>");
        return c.isFlexible($this$isFlexible);
    }

    public static final boolean isDynamic(TypeSystemContext c, KotlinTypeMarker $this$isDynamic) {
        Intrinsics.checkNotNullParameter(c, "c");
        Intrinsics.checkNotNullParameter($this$isDynamic, "<this>");
        return c.isDynamic($this$isDynamic);
    }

    public static final boolean isDefinitelyNotNullType(TypeSystemContext c, KotlinTypeMarker $this$isDefinitelyNotNullType) {
        Intrinsics.checkNotNullParameter(c, "c");
        Intrinsics.checkNotNullParameter($this$isDefinitelyNotNullType, "<this>");
        return c.isDefinitelyNotNullType($this$isDefinitelyNotNullType);
    }

    public static final boolean isDefinitelyNotNullType(TypeSystemContext c, RigidTypeMarker $this$isDefinitelyNotNullType) {
        Intrinsics.checkNotNullParameter(c, "c");
        Intrinsics.checkNotNullParameter($this$isDefinitelyNotNullType, "<this>");
        return c.isDefinitelyNotNullType($this$isDefinitelyNotNullType);
    }

    public static final boolean isNotNullTypeParameter(TypeSystemContext c, KotlinTypeMarker $this$isNotNullTypeParameter) {
        Intrinsics.checkNotNullParameter(c, "c");
        Intrinsics.checkNotNullParameter($this$isNotNullTypeParameter, "<this>");
        return c.isNotNullTypeParameter($this$isNotNullTypeParameter);
    }

    public static final TypeConstructorMarker typeConstructor(TypeSystemContext c, KotlinTypeMarker $this$typeConstructor) {
        Intrinsics.checkNotNullParameter(c, "c");
        Intrinsics.checkNotNullParameter($this$typeConstructor, "<this>");
        return c.typeConstructor($this$typeConstructor);
    }

    public static final boolean isClassType(TypeSystemContext c, RigidTypeMarker $this$isClassType) {
        Intrinsics.checkNotNullParameter(c, "c");
        Intrinsics.checkNotNullParameter($this$isClassType, "<this>");
        return c.isClassType($this$isClassType);
    }

    public static final List<SimpleTypeMarker> fastCorrespondingSupertypes(TypeSystemContext c, RigidTypeMarker $this$fastCorrespondingSupertypes, TypeConstructorMarker constructor) {
        Intrinsics.checkNotNullParameter(c, "c");
        Intrinsics.checkNotNullParameter($this$fastCorrespondingSupertypes, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        return c.fastCorrespondingSupertypes($this$fastCorrespondingSupertypes, constructor);
    }

    public static final boolean isIntegerLiteralType(TypeSystemContext c, RigidTypeMarker $this$isIntegerLiteralType) {
        Intrinsics.checkNotNullParameter(c, "c");
        Intrinsics.checkNotNullParameter($this$isIntegerLiteralType, "<this>");
        return c.isIntegerLiteralType($this$isIntegerLiteralType);
    }

    public static final Collection<KotlinTypeMarker> possibleIntegerTypes(TypeSystemContext c, RigidTypeMarker $this$possibleIntegerTypes) {
        Intrinsics.checkNotNullParameter(c, "c");
        Intrinsics.checkNotNullParameter($this$possibleIntegerTypes, "<this>");
        return c.possibleIntegerTypes($this$possibleIntegerTypes);
    }

    public static final boolean isCommonFinalClassConstructor(TypeSystemContext c, TypeConstructorMarker $this$isCommonFinalClassConstructor) {
        Intrinsics.checkNotNullParameter(c, "c");
        Intrinsics.checkNotNullParameter($this$isCommonFinalClassConstructor, "<this>");
        return c.isCommonFinalClassConstructor($this$isCommonFinalClassConstructor);
    }

    public static final TypeArgumentListMarker asArgumentList(TypeSystemContext c, RigidTypeMarker $this$asArgumentList) {
        Intrinsics.checkNotNullParameter(c, "c");
        Intrinsics.checkNotNullParameter($this$asArgumentList, "<this>");
        return c.asArgumentList($this$asArgumentList);
    }

    public static final TypeArgumentMarker get(TypeSystemContext c, TypeArgumentListMarker $this$get, int index) {
        Intrinsics.checkNotNullParameter(c, "c");
        Intrinsics.checkNotNullParameter($this$get, "<this>");
        return c.get($this$get, index);
    }

    public static final int size(TypeSystemContext c, TypeArgumentListMarker $this$size) {
        Intrinsics.checkNotNullParameter(c, "c");
        Intrinsics.checkNotNullParameter($this$size, "<this>");
        return c.size($this$size);
    }

    public static final boolean isAnyConstructor(TypeSystemContext c, TypeConstructorMarker $this$isAnyConstructor) {
        Intrinsics.checkNotNullParameter(c, "c");
        Intrinsics.checkNotNullParameter($this$isAnyConstructor, "<this>");
        return c.isAnyConstructor($this$isAnyConstructor);
    }

    public static final boolean isNothingConstructor(TypeSystemContext c, TypeConstructorMarker $this$isNothingConstructor) {
        Intrinsics.checkNotNullParameter(c, "c");
        Intrinsics.checkNotNullParameter($this$isNothingConstructor, "<this>");
        return c.isNothingConstructor($this$isNothingConstructor);
    }

    public static final boolean isSingleClassifierType(TypeSystemContext c, RigidTypeMarker $this$isSingleClassifierType) {
        Intrinsics.checkNotNullParameter(c, "c");
        Intrinsics.checkNotNullParameter($this$isSingleClassifierType, "<this>");
        return c.isSingleClassifierType($this$isSingleClassifierType);
    }
}