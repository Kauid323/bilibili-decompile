package kotlin.reflect.jvm.internal.impl.resolve;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeCheckerState;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeCheckerStateKt;
import kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypePreparator;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.model.ArgumentList;
import kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus;
import kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.DefinitelyNotNullTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.DynamicTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.FlexibleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentListMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeSubstitutorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeVariableTypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeVariance;

/* compiled from: OverridingUtilTypeSystemContext.kt */
public final class OverridingUtilTypeSystemContext implements ClassicTypeSystemContext {
    private final Function2<KotlinType, KotlinType, Boolean> customSubtype;
    private final KotlinTypeChecker.TypeConstructorEquality equalityAxioms;
    private final KotlinTypePreparator kotlinTypePreparator;
    private final KotlinTypeRefiner kotlinTypeRefiner;
    private final Map<TypeConstructor, TypeConstructor> matchingTypeConstructors;

    /* JADX WARN: Multi-variable type inference failed */
    public OverridingUtilTypeSystemContext(Map<TypeConstructor, ? extends TypeConstructor> map, KotlinTypeChecker.TypeConstructorEquality equalityAxioms, KotlinTypeRefiner kotlinTypeRefiner, KotlinTypePreparator kotlinTypePreparator, Function2<? super KotlinType, ? super KotlinType, Boolean> function2) {
        Intrinsics.checkNotNullParameter(equalityAxioms, "equalityAxioms");
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        Intrinsics.checkNotNullParameter(kotlinTypePreparator, "kotlinTypePreparator");
        this.matchingTypeConstructors = map;
        this.equalityAxioms = equalityAxioms;
        this.kotlinTypeRefiner = kotlinTypeRefiner;
        this.kotlinTypePreparator = kotlinTypePreparator;
        this.customSubtype = function2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public /* bridge */ int argumentsCount(KotlinTypeMarker $this$argumentsCount) {
        return ClassicTypeSystemContext.DefaultImpls.argumentsCount(this, $this$argumentsCount);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext
    public /* bridge */ SimpleTypeMarker arrayType(KotlinTypeMarker componentType) {
        return ClassicTypeSystemContext.DefaultImpls.arrayType(this, componentType);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public /* bridge */ TypeArgumentListMarker asArgumentList(RigidTypeMarker $this$asArgumentList) {
        return ClassicTypeSystemContext.DefaultImpls.asArgumentList(this, $this$asArgumentList);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public /* bridge */ CapturedTypeMarker asCapturedType(SimpleTypeMarker $this$asCapturedType) {
        return ClassicTypeSystemContext.DefaultImpls.asCapturedType(this, $this$asCapturedType);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public /* bridge */ CapturedTypeMarker asCapturedTypeUnwrappingDnn(RigidTypeMarker $this$asCapturedTypeUnwrappingDnn) {
        return default$asCapturedTypeUnwrappingDnn($this$asCapturedTypeUnwrappingDnn);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public /* bridge */ DefinitelyNotNullTypeMarker asDefinitelyNotNullType(RigidTypeMarker $this$asDefinitelyNotNullType) {
        return ClassicTypeSystemContext.DefaultImpls.asDefinitelyNotNullType(this, $this$asDefinitelyNotNullType);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public /* bridge */ DynamicTypeMarker asDynamicType(FlexibleTypeMarker $this$asDynamicType) {
        return ClassicTypeSystemContext.DefaultImpls.asDynamicType(this, $this$asDynamicType);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public /* bridge */ FlexibleTypeMarker asFlexibleType(KotlinTypeMarker $this$asFlexibleType) {
        return ClassicTypeSystemContext.DefaultImpls.asFlexibleType(this, $this$asFlexibleType);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public /* bridge */ SimpleTypeMarker asRigidType(KotlinTypeMarker $this$asRigidType) {
        return ClassicTypeSystemContext.DefaultImpls.asRigidType(this, $this$asRigidType);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public /* bridge */ TypeArgumentMarker asTypeArgument(KotlinTypeMarker $this$asTypeArgument) {
        return ClassicTypeSystemContext.DefaultImpls.asTypeArgument(this, $this$asTypeArgument);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public /* bridge */ SimpleType captureFromArguments(RigidTypeMarker type, CaptureStatus status) {
        return ClassicTypeSystemContext.DefaultImpls.captureFromArguments(this, type, status);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public /* bridge */ CaptureStatus captureStatus(CapturedTypeMarker $this$captureStatus) {
        return ClassicTypeSystemContext.DefaultImpls.captureStatus(this, $this$captureStatus);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext
    public /* bridge */ KotlinTypeMarker createFlexibleType(RigidTypeMarker lowerBound, RigidTypeMarker upperBound) {
        return ClassicTypeSystemContext.DefaultImpls.createFlexibleType(this, lowerBound, upperBound);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public /* bridge */ List<SimpleTypeMarker> fastCorrespondingSupertypes(RigidTypeMarker $this$fastCorrespondingSupertypes, TypeConstructorMarker constructor) {
        return default$fastCorrespondingSupertypes($this$fastCorrespondingSupertypes, constructor);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public /* bridge */ TypeArgumentMarker get(TypeArgumentListMarker $this$get, int index) {
        return default$get($this$get, index);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public /* bridge */ TypeArgumentMarker getArgument(KotlinTypeMarker $this$getArgument, int index) {
        return ClassicTypeSystemContext.DefaultImpls.getArgument(this, $this$getArgument, index);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public /* bridge */ TypeArgumentMarker getArgumentOrNull(RigidTypeMarker $this$getArgumentOrNull, int index) {
        return default$getArgumentOrNull($this$getArgumentOrNull, index);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public /* bridge */ List<TypeArgumentMarker> getArguments(KotlinTypeMarker $this$getArguments) {
        return ClassicTypeSystemContext.DefaultImpls.getArguments(this, $this$getArguments);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext
    public /* bridge */ KotlinBuiltIns getBuiltIns() {
        return ClassicTypeSystemContext.DefaultImpls.getBuiltIns(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext
    public /* bridge */ FqNameUnsafe getClassFqNameUnsafe(TypeConstructorMarker $this$getClassFqNameUnsafe) {
        return ClassicTypeSystemContext.DefaultImpls.getClassFqNameUnsafe(this, $this$getClassFqNameUnsafe);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public /* bridge */ TypeParameterMarker getParameter(TypeConstructorMarker $this$getParameter, int index) {
        return ClassicTypeSystemContext.DefaultImpls.getParameter(this, $this$getParameter, index);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public /* bridge */ List<TypeParameterMarker> getParameters(TypeConstructorMarker $this$getParameters) {
        return ClassicTypeSystemContext.DefaultImpls.getParameters(this, $this$getParameters);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext
    public /* bridge */ PrimitiveType getPrimitiveArrayType(TypeConstructorMarker $this$getPrimitiveArrayType) {
        return ClassicTypeSystemContext.DefaultImpls.getPrimitiveArrayType(this, $this$getPrimitiveArrayType);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext
    public /* bridge */ PrimitiveType getPrimitiveType(TypeConstructorMarker $this$getPrimitiveType) {
        return ClassicTypeSystemContext.DefaultImpls.getPrimitiveType(this, $this$getPrimitiveType);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext
    public /* bridge */ KotlinTypeMarker getRepresentativeUpperBound(TypeParameterMarker $this$getRepresentativeUpperBound) {
        return ClassicTypeSystemContext.DefaultImpls.getRepresentativeUpperBound(this, $this$getRepresentativeUpperBound);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public /* bridge */ KotlinTypeMarker getType(TypeArgumentMarker $this$getType) {
        return ClassicTypeSystemContext.DefaultImpls.getType(this, $this$getType);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public /* bridge */ TypeConstructorMarker getTypeConstructor(TypeParameterMarker $this$getTypeConstructor) {
        return ClassicTypeSystemContext.DefaultImpls.getTypeConstructor(this, $this$getTypeConstructor);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public /* bridge */ TypeParameterMarker getTypeParameter(TypeVariableTypeConstructorMarker $this$typeParameter) {
        return ClassicTypeSystemContext.DefaultImpls.getTypeParameter(this, $this$typeParameter);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public /* bridge */ TypeParameterMarker getTypeParameterClassifier(TypeConstructorMarker $this$getTypeParameterClassifier) {
        return ClassicTypeSystemContext.DefaultImpls.getTypeParameterClassifier(this, $this$getTypeParameterClassifier);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext
    public /* bridge */ KotlinTypeMarker getUnsubstitutedUnderlyingType(KotlinTypeMarker $this$getUnsubstitutedUnderlyingType) {
        return ClassicTypeSystemContext.DefaultImpls.getUnsubstitutedUnderlyingType(this, $this$getUnsubstitutedUnderlyingType);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public /* bridge */ List<KotlinTypeMarker> getUpperBounds(TypeParameterMarker $this$getUpperBounds) {
        return ClassicTypeSystemContext.DefaultImpls.getUpperBounds(this, $this$getUpperBounds);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public /* bridge */ TypeVariance getVariance(TypeArgumentMarker $this$getVariance) {
        return ClassicTypeSystemContext.DefaultImpls.getVariance(this, $this$getVariance);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public /* bridge */ TypeVariance getVariance(TypeParameterMarker $this$getVariance) {
        return ClassicTypeSystemContext.DefaultImpls.getVariance(this, $this$getVariance);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext
    public /* bridge */ boolean hasAnnotation(KotlinTypeMarker $this$hasAnnotation, FqName fqName) {
        return ClassicTypeSystemContext.DefaultImpls.hasAnnotation(this, $this$hasAnnotation, fqName);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public /* bridge */ boolean hasFlexibleNullability(KotlinTypeMarker $this$hasFlexibleNullability) {
        return default$hasFlexibleNullability($this$hasFlexibleNullability);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public /* bridge */ boolean hasRecursiveBounds(TypeParameterMarker $this$hasRecursiveBounds, TypeConstructorMarker selfConstructor) {
        return ClassicTypeSystemContext.DefaultImpls.hasRecursiveBounds(this, $this$hasRecursiveBounds, selfConstructor);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemOptimizationContext
    public /* bridge */ boolean identicalArguments(RigidTypeMarker a, RigidTypeMarker b) {
        return ClassicTypeSystemContext.DefaultImpls.identicalArguments(this, a, b);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public /* bridge */ KotlinTypeMarker intersectTypes(Collection<? extends KotlinTypeMarker> collection) {
        return ClassicTypeSystemContext.DefaultImpls.intersectTypes(this, collection);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public /* bridge */ boolean isAnyConstructor(TypeConstructorMarker $this$isAnyConstructor) {
        return ClassicTypeSystemContext.DefaultImpls.isAnyConstructor(this, $this$isAnyConstructor);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext
    public /* bridge */ boolean isArrayOrNullableArray(KotlinTypeMarker $this$isArrayOrNullableArray) {
        return ClassicTypeSystemContext.DefaultImpls.isArrayOrNullableArray(this, $this$isArrayOrNullableArray);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public /* bridge */ boolean isCapturedType(KotlinTypeMarker $this$isCapturedType) {
        return default$isCapturedType($this$isCapturedType);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public /* bridge */ boolean isClassType(RigidTypeMarker $this$isClassType) {
        return default$isClassType($this$isClassType);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public /* bridge */ boolean isClassTypeConstructor(TypeConstructorMarker $this$isClassTypeConstructor) {
        return ClassicTypeSystemContext.DefaultImpls.isClassTypeConstructor(this, $this$isClassTypeConstructor);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public /* bridge */ boolean isCommonFinalClassConstructor(TypeConstructorMarker $this$isCommonFinalClassConstructor) {
        return ClassicTypeSystemContext.DefaultImpls.isCommonFinalClassConstructor(this, $this$isCommonFinalClassConstructor);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public /* bridge */ boolean isDefinitelyNotNullType(KotlinTypeMarker $this$isDefinitelyNotNullType) {
        return default$isDefinitelyNotNullType($this$isDefinitelyNotNullType);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public /* bridge */ boolean isDefinitelyNotNullType(RigidTypeMarker $this$isDefinitelyNotNullType) {
        return default$isDefinitelyNotNullType($this$isDefinitelyNotNullType);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public /* bridge */ boolean isDenotable(TypeConstructorMarker $this$isDenotable) {
        return ClassicTypeSystemContext.DefaultImpls.isDenotable(this, $this$isDenotable);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public /* bridge */ boolean isDynamic(KotlinTypeMarker $this$isDynamic) {
        return default$isDynamic($this$isDynamic);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public /* bridge */ boolean isError(KotlinTypeMarker $this$isError) {
        return ClassicTypeSystemContext.DefaultImpls.isError(this, $this$isError);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public /* bridge */ boolean isFlexible(KotlinTypeMarker $this$isFlexible) {
        return default$isFlexible($this$isFlexible);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public /* bridge */ boolean isFlexibleWithDifferentTypeConstructors(KotlinTypeMarker $this$isFlexibleWithDifferentTypeConstructors) {
        return default$isFlexibleWithDifferentTypeConstructors($this$isFlexibleWithDifferentTypeConstructors);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext
    public /* bridge */ boolean isInlineClass(TypeConstructorMarker $this$isInlineClass) {
        return ClassicTypeSystemContext.DefaultImpls.isInlineClass(this, $this$isInlineClass);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public /* bridge */ boolean isIntegerLiteralType(RigidTypeMarker $this$isIntegerLiteralType) {
        return default$isIntegerLiteralType($this$isIntegerLiteralType);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public /* bridge */ boolean isIntegerLiteralTypeConstructor(TypeConstructorMarker $this$isIntegerLiteralTypeConstructor) {
        return ClassicTypeSystemContext.DefaultImpls.isIntegerLiteralTypeConstructor(this, $this$isIntegerLiteralTypeConstructor);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public /* bridge */ boolean isIntersection(TypeConstructorMarker $this$isIntersection) {
        return ClassicTypeSystemContext.DefaultImpls.isIntersection(this, $this$isIntersection);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemInferenceExtensionContext
    public /* bridge */ boolean isK2() {
        return ClassicTypeSystemContext.DefaultImpls.isK2(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public /* bridge */ boolean isMarkedNullable(KotlinTypeMarker $this$isMarkedNullable) {
        return ClassicTypeSystemContext.DefaultImpls.isMarkedNullable(this, $this$isMarkedNullable);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public /* bridge */ boolean isNotNullTypeParameter(KotlinTypeMarker $this$isNotNullTypeParameter) {
        return ClassicTypeSystemContext.DefaultImpls.isNotNullTypeParameter(this, $this$isNotNullTypeParameter);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public /* bridge */ boolean isNothing(KotlinTypeMarker $this$isNothing) {
        return default$isNothing($this$isNothing);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public /* bridge */ boolean isNothingConstructor(TypeConstructorMarker $this$isNothingConstructor) {
        return ClassicTypeSystemContext.DefaultImpls.isNothingConstructor(this, $this$isNothingConstructor);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public /* bridge */ boolean isNullableType(KotlinTypeMarker $this$isNullableType) {
        return ClassicTypeSystemContext.DefaultImpls.isNullableType(this, $this$isNullableType);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public /* bridge */ boolean isOldCapturedType(CapturedTypeMarker $this$isOldCapturedType) {
        return ClassicTypeSystemContext.DefaultImpls.isOldCapturedType(this, $this$isOldCapturedType);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public /* bridge */ boolean isPrimitiveType(SimpleTypeMarker $this$isPrimitiveType) {
        return ClassicTypeSystemContext.DefaultImpls.isPrimitiveType(this, $this$isPrimitiveType);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public /* bridge */ boolean isProjectionNotNull(CapturedTypeMarker $this$isProjectionNotNull) {
        return ClassicTypeSystemContext.DefaultImpls.isProjectionNotNull(this, $this$isProjectionNotNull);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public /* bridge */ boolean isRawType(KotlinTypeMarker $this$isRawType) {
        return ClassicTypeSystemContext.DefaultImpls.isRawType(this, $this$isRawType);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public /* bridge */ boolean isSingleClassifierType(RigidTypeMarker $this$isSingleClassifierType) {
        return ClassicTypeSystemContext.DefaultImpls.isSingleClassifierType(this, $this$isSingleClassifierType);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public /* bridge */ boolean isStarProjection(TypeArgumentMarker $this$isStarProjection) {
        return ClassicTypeSystemContext.DefaultImpls.isStarProjection(this, $this$isStarProjection);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public /* bridge */ boolean isStubType(RigidTypeMarker $this$isStubType) {
        return ClassicTypeSystemContext.DefaultImpls.isStubType(this, $this$isStubType);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public /* bridge */ boolean isStubTypeForBuilderInference(RigidTypeMarker $this$isStubTypeForBuilderInference) {
        return ClassicTypeSystemContext.DefaultImpls.isStubTypeForBuilderInference(this, $this$isStubTypeForBuilderInference);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public /* bridge */ boolean isTypeVariableType(KotlinTypeMarker $this$isTypeVariableType) {
        return ClassicTypeSystemContext.DefaultImpls.isTypeVariableType(this, $this$isTypeVariableType);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext
    public /* bridge */ boolean isUnderKotlinPackage(TypeConstructorMarker $this$isUnderKotlinPackage) {
        return ClassicTypeSystemContext.DefaultImpls.isUnderKotlinPackage(this, $this$isUnderKotlinPackage);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public /* bridge */ SimpleTypeMarker lowerBound(FlexibleTypeMarker $this$lowerBound) {
        return ClassicTypeSystemContext.DefaultImpls.lowerBound(this, $this$lowerBound);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public /* bridge */ RigidTypeMarker lowerBoundIfFlexible(KotlinTypeMarker $this$lowerBoundIfFlexible) {
        return default$lowerBoundIfFlexible($this$lowerBoundIfFlexible);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public /* bridge */ KotlinTypeMarker lowerType(CapturedTypeMarker $this$lowerType) {
        return ClassicTypeSystemContext.DefaultImpls.lowerType(this, $this$lowerType);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public /* bridge */ KotlinTypeMarker makeDefinitelyNotNullOrNotNull(KotlinTypeMarker $this$makeDefinitelyNotNullOrNotNull) {
        return default$makeDefinitelyNotNullOrNotNull($this$makeDefinitelyNotNullOrNotNull);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public /* bridge */ KotlinTypeMarker makeDefinitelyNotNullOrNotNull(KotlinTypeMarker $this$makeDefinitelyNotNullOrNotNull, boolean preserveAttributes) {
        return ClassicTypeSystemContext.DefaultImpls.makeDefinitelyNotNullOrNotNull(this, $this$makeDefinitelyNotNullOrNotNull, preserveAttributes);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext
    public /* bridge */ KotlinTypeMarker makeNullable(KotlinTypeMarker $this$makeNullable) {
        return default$makeNullable($this$makeNullable);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext
    public /* bridge */ SimpleTypeMarker nullableAnyType() {
        return ClassicTypeSystemContext.DefaultImpls.nullableAnyType(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public /* bridge */ SimpleTypeMarker original(DefinitelyNotNullTypeMarker $this$original) {
        return ClassicTypeSystemContext.DefaultImpls.original(this, $this$original);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public /* bridge */ SimpleTypeMarker originalIfDefinitelyNotNullable(RigidTypeMarker $this$originalIfDefinitelyNotNullable) {
        return default$originalIfDefinitelyNotNullable($this$originalIfDefinitelyNotNullable);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public /* bridge */ int parametersCount(TypeConstructorMarker $this$parametersCount) {
        return ClassicTypeSystemContext.DefaultImpls.parametersCount(this, $this$parametersCount);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public /* bridge */ Collection<KotlinTypeMarker> possibleIntegerTypes(RigidTypeMarker $this$possibleIntegerTypes) {
        return ClassicTypeSystemContext.DefaultImpls.possibleIntegerTypes(this, $this$possibleIntegerTypes);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public /* bridge */ TypeArgumentMarker projection(CapturedTypeConstructorMarker $this$projection) {
        return ClassicTypeSystemContext.DefaultImpls.projection(this, $this$projection);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public /* bridge */ KotlinTypeMarker safeSubstitute(TypeSubstitutorMarker $this$safeSubstitute, KotlinTypeMarker type) {
        return ClassicTypeSystemContext.DefaultImpls.safeSubstitute(this, $this$safeSubstitute, type);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public /* bridge */ int size(TypeArgumentListMarker $this$size) {
        return default$size($this$size);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public /* bridge */ TypeCheckerState.SupertypesPolicy substitutionSupertypePolicy(RigidTypeMarker type) {
        return ClassicTypeSystemContext.DefaultImpls.substitutionSupertypePolicy(this, type);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public /* bridge */ Collection<KotlinTypeMarker> supertypes(TypeConstructorMarker $this$supertypes) {
        return ClassicTypeSystemContext.DefaultImpls.supertypes(this, $this$supertypes);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public /* bridge */ CapturedTypeConstructorMarker typeConstructor(CapturedTypeMarker $this$typeConstructor) {
        return ClassicTypeSystemContext.DefaultImpls.typeConstructor((ClassicTypeSystemContext) this, $this$typeConstructor);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public /* bridge */ TypeConstructorMarker typeConstructor(KotlinTypeMarker $this$typeConstructor) {
        return default$typeConstructor($this$typeConstructor);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public /* bridge */ TypeConstructorMarker typeConstructor(RigidTypeMarker $this$typeConstructor) {
        return ClassicTypeSystemContext.DefaultImpls.typeConstructor(this, $this$typeConstructor);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext
    public /* bridge */ TypeSubstitutorMarker typeSubstitutorForUnderlyingType(Map<TypeConstructorMarker, ? extends KotlinTypeMarker> map) {
        return ClassicTypeSystemContext.DefaultImpls.typeSubstitutorForUnderlyingType(this, map);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public /* bridge */ SimpleTypeMarker upperBound(FlexibleTypeMarker $this$upperBound) {
        return ClassicTypeSystemContext.DefaultImpls.upperBound(this, $this$upperBound);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public /* bridge */ RigidTypeMarker upperBoundIfFlexible(KotlinTypeMarker $this$upperBoundIfFlexible) {
        return default$upperBoundIfFlexible($this$upperBoundIfFlexible);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public /* bridge */ KotlinTypeMarker withNullability(KotlinTypeMarker $this$withNullability, boolean nullable) {
        return ClassicTypeSystemContext.DefaultImpls.withNullability(this, $this$withNullability, nullable);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public /* bridge */ SimpleTypeMarker withNullability(RigidTypeMarker $this$withNullability, boolean nullable) {
        return ClassicTypeSystemContext.DefaultImpls.withNullability((ClassicTypeSystemContext) this, $this$withNullability, nullable);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean areEqualTypeConstructors(TypeConstructorMarker c1, TypeConstructorMarker c2) {
        Intrinsics.checkNotNullParameter(c1, "c1");
        Intrinsics.checkNotNullParameter(c2, "c2");
        if (!(c1 instanceof TypeConstructor)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (c2 instanceof TypeConstructor) {
            return ClassicTypeSystemContext.DefaultImpls.areEqualTypeConstructors(this, c1, c2) || areEqualTypeConstructorsByAxioms((TypeConstructor) c1, (TypeConstructor) c2);
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeCheckerProviderContext
    public TypeCheckerState newTypeCheckerState(final boolean errorTypesEqualToAnything, final boolean stubTypesEqualToAnything, final boolean dnnTypesEqualToFlexible) {
        if (this.customSubtype == null) {
            return ClassicTypeCheckerStateKt.createClassicTypeCheckerState(errorTypesEqualToAnything, stubTypesEqualToAnything, this, this.kotlinTypePreparator, this.kotlinTypeRefiner);
        }
        final KotlinTypePreparator kotlinTypePreparator = this.kotlinTypePreparator;
        final KotlinTypeRefiner kotlinTypeRefiner = this.kotlinTypeRefiner;
        return new TypeCheckerState(errorTypesEqualToAnything, stubTypesEqualToAnything, dnnTypesEqualToFlexible, this, kotlinTypePreparator, kotlinTypeRefiner) { // from class: kotlin.reflect.jvm.internal.impl.resolve.OverridingUtilTypeSystemContext$newTypeCheckerState$1
            final /* synthetic */ OverridingUtilTypeSystemContext this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.this$0 = this;
                OverridingUtilTypeSystemContext overridingUtilTypeSystemContext = this;
                KotlinTypePreparator kotlinTypePreparator2 = kotlinTypePreparator;
                KotlinTypeRefiner kotlinTypeRefiner2 = kotlinTypeRefiner;
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.TypeCheckerState
            public boolean customIsSubtypeOf(KotlinTypeMarker subType, KotlinTypeMarker superType) {
                Function2 function2;
                Intrinsics.checkNotNullParameter(subType, "subType");
                Intrinsics.checkNotNullParameter(superType, "superType");
                if (!(subType instanceof KotlinType)) {
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
                if (superType instanceof KotlinType) {
                    function2 = this.this$0.customSubtype;
                    return ((Boolean) function2.invoke(subType, superType)).booleanValue();
                }
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
        };
    }

    public KotlinTypeMarker default$makeNullable(KotlinTypeMarker $this$makeNullable) {
        RigidTypeMarker withNullability;
        Intrinsics.checkNotNullParameter($this$makeNullable, "<this>");
        RigidTypeMarker asRigidType = asRigidType($this$makeNullable);
        return (asRigidType == null || (withNullability = withNullability(asRigidType, true)) == null) ? $this$makeNullable : withNullability;
    }

    private final boolean areEqualTypeConstructorsByAxioms(TypeConstructor a, TypeConstructor b) {
        if (this.equalityAxioms.equals(a, b)) {
            return true;
        }
        if (this.matchingTypeConstructors == null) {
            return false;
        }
        TypeConstructor img1 = this.matchingTypeConstructors.get(a);
        TypeConstructor img2 = this.matchingTypeConstructors.get(b);
        if (img1 == null || !Intrinsics.areEqual(img1, b)) {
            return img2 != null && Intrinsics.areEqual(img2, a);
        }
        return true;
    }

    public CapturedTypeMarker default$asCapturedTypeUnwrappingDnn(RigidTypeMarker $this$asCapturedTypeUnwrappingDnn) {
        Intrinsics.checkNotNullParameter($this$asCapturedTypeUnwrappingDnn, "<this>");
        return asCapturedType(originalIfDefinitelyNotNullable($this$asCapturedTypeUnwrappingDnn));
    }

    public boolean default$isCapturedType(KotlinTypeMarker $this$isCapturedType) {
        Intrinsics.checkNotNullParameter($this$isCapturedType, "<this>");
        RigidTypeMarker asRigidType = asRigidType($this$isCapturedType);
        return (asRigidType != null ? asCapturedTypeUnwrappingDnn(asRigidType) : null) != null;
    }

    public SimpleTypeMarker default$originalIfDefinitelyNotNullable(RigidTypeMarker $this$originalIfDefinitelyNotNullable) {
        SimpleTypeMarker original;
        Intrinsics.checkNotNullParameter($this$originalIfDefinitelyNotNullable, "<this>");
        DefinitelyNotNullTypeMarker asDefinitelyNotNullType = asDefinitelyNotNullType($this$originalIfDefinitelyNotNullable);
        return (asDefinitelyNotNullType == null || (original = original(asDefinitelyNotNullType)) == null) ? (SimpleTypeMarker) $this$originalIfDefinitelyNotNullable : original;
    }

    public KotlinTypeMarker default$makeDefinitelyNotNullOrNotNull(KotlinTypeMarker $this$makeDefinitelyNotNullOrNotNull) {
        Intrinsics.checkNotNullParameter($this$makeDefinitelyNotNullOrNotNull, "<this>");
        return makeDefinitelyNotNullOrNotNull($this$makeDefinitelyNotNullOrNotNull, false);
    }

    public TypeArgumentMarker default$getArgumentOrNull(RigidTypeMarker $this$getArgumentOrNull, int index) {
        Intrinsics.checkNotNullParameter($this$getArgumentOrNull, "<this>");
        boolean z = false;
        if (index >= 0 && index < argumentsCount($this$getArgumentOrNull)) {
            z = true;
        }
        if (z) {
            return getArgument($this$getArgumentOrNull, index);
        }
        return null;
    }

    public RigidTypeMarker default$lowerBoundIfFlexible(KotlinTypeMarker $this$lowerBoundIfFlexible) {
        RigidTypeMarker lowerBound;
        Intrinsics.checkNotNullParameter($this$lowerBoundIfFlexible, "<this>");
        FlexibleTypeMarker asFlexibleType = asFlexibleType($this$lowerBoundIfFlexible);
        if (asFlexibleType == null || (lowerBound = lowerBound(asFlexibleType)) == null) {
            RigidTypeMarker asRigidType = asRigidType($this$lowerBoundIfFlexible);
            Intrinsics.checkNotNull(asRigidType);
            return asRigidType;
        }
        return lowerBound;
    }

    public RigidTypeMarker default$upperBoundIfFlexible(KotlinTypeMarker $this$upperBoundIfFlexible) {
        RigidTypeMarker upperBound;
        Intrinsics.checkNotNullParameter($this$upperBoundIfFlexible, "<this>");
        FlexibleTypeMarker asFlexibleType = asFlexibleType($this$upperBoundIfFlexible);
        if (asFlexibleType == null || (upperBound = upperBound(asFlexibleType)) == null) {
            RigidTypeMarker asRigidType = asRigidType($this$upperBoundIfFlexible);
            Intrinsics.checkNotNull(asRigidType);
            return asRigidType;
        }
        return upperBound;
    }

    public boolean default$isFlexibleWithDifferentTypeConstructors(KotlinTypeMarker $this$isFlexibleWithDifferentTypeConstructors) {
        Intrinsics.checkNotNullParameter($this$isFlexibleWithDifferentTypeConstructors, "<this>");
        return !Intrinsics.areEqual(typeConstructor(lowerBoundIfFlexible($this$isFlexibleWithDifferentTypeConstructors)), typeConstructor(upperBoundIfFlexible($this$isFlexibleWithDifferentTypeConstructors)));
    }

    public boolean default$isFlexible(KotlinTypeMarker $this$isFlexible) {
        Intrinsics.checkNotNullParameter($this$isFlexible, "<this>");
        return asFlexibleType($this$isFlexible) != null;
    }

    public boolean default$isDynamic(KotlinTypeMarker $this$isDynamic) {
        Intrinsics.checkNotNullParameter($this$isDynamic, "<this>");
        FlexibleTypeMarker asFlexibleType = asFlexibleType($this$isDynamic);
        return (asFlexibleType != null ? asDynamicType(asFlexibleType) : null) != null;
    }

    public boolean default$isDefinitelyNotNullType(KotlinTypeMarker $this$isDefinitelyNotNullType) {
        Intrinsics.checkNotNullParameter($this$isDefinitelyNotNullType, "<this>");
        RigidTypeMarker asRigidType = asRigidType($this$isDefinitelyNotNullType);
        return (asRigidType != null ? asDefinitelyNotNullType(asRigidType) : null) != null;
    }

    public boolean default$isDefinitelyNotNullType(RigidTypeMarker $this$isDefinitelyNotNullType) {
        Intrinsics.checkNotNullParameter($this$isDefinitelyNotNullType, "<this>");
        return asDefinitelyNotNullType($this$isDefinitelyNotNullType) != null;
    }

    public boolean default$hasFlexibleNullability(KotlinTypeMarker $this$hasFlexibleNullability) {
        Intrinsics.checkNotNullParameter($this$hasFlexibleNullability, "<this>");
        return isMarkedNullable(lowerBoundIfFlexible($this$hasFlexibleNullability)) != isMarkedNullable(upperBoundIfFlexible($this$hasFlexibleNullability));
    }

    public TypeConstructorMarker default$typeConstructor(KotlinTypeMarker $this$typeConstructor) {
        Intrinsics.checkNotNullParameter($this$typeConstructor, "<this>");
        RigidTypeMarker asRigidType = asRigidType($this$typeConstructor);
        if (asRigidType == null) {
            asRigidType = lowerBoundIfFlexible($this$typeConstructor);
        }
        return typeConstructor(asRigidType);
    }

    public boolean default$isNothing(KotlinTypeMarker $this$isNothing) {
        Intrinsics.checkNotNullParameter($this$isNothing, "<this>");
        return isNothingConstructor(typeConstructor($this$isNothing)) && !isNullableType($this$isNothing);
    }

    public boolean default$isClassType(RigidTypeMarker $this$isClassType) {
        Intrinsics.checkNotNullParameter($this$isClassType, "<this>");
        return isClassTypeConstructor(typeConstructor($this$isClassType));
    }

    public List<SimpleTypeMarker> default$fastCorrespondingSupertypes(RigidTypeMarker $this$fastCorrespondingSupertypes, TypeConstructorMarker constructor) {
        Intrinsics.checkNotNullParameter($this$fastCorrespondingSupertypes, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        return null;
    }

    public boolean default$isIntegerLiteralType(RigidTypeMarker $this$isIntegerLiteralType) {
        Intrinsics.checkNotNullParameter($this$isIntegerLiteralType, "<this>");
        return isIntegerLiteralTypeConstructor(typeConstructor($this$isIntegerLiteralType));
    }

    public TypeArgumentMarker default$get(TypeArgumentListMarker $this$get, int index) {
        Intrinsics.checkNotNullParameter($this$get, "<this>");
        if ($this$get instanceof SimpleTypeMarker) {
            return getArgument((KotlinTypeMarker) $this$get, index);
        }
        if ($this$get instanceof ArgumentList) {
            TypeArgumentMarker typeArgumentMarker = ((ArgumentList) $this$get).get(index);
            Intrinsics.checkNotNullExpressionValue(typeArgumentMarker, "get(...)");
            return typeArgumentMarker;
        }
        throw new IllegalStateException(("unknown type argument list type: " + $this$get + ", " + Reflection.getOrCreateKotlinClass($this$get.getClass())).toString());
    }

    public int default$size(TypeArgumentListMarker $this$size) {
        Intrinsics.checkNotNullParameter($this$size, "<this>");
        if ($this$size instanceof RigidTypeMarker) {
            return argumentsCount((KotlinTypeMarker) $this$size);
        }
        if ($this$size instanceof ArgumentList) {
            return ((ArgumentList) $this$size).size();
        }
        throw new IllegalStateException(("unknown type argument list type: " + $this$size + ", " + Reflection.getOrCreateKotlinClass($this$size.getClass())).toString());
    }
}