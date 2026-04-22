package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.CompositeAnnotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.FilteredAnnotations;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorKt;
import kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorType;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.model.TypeSubstitutorMarker;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.typesApproximation.CapturedTypeApproximationKt;
import kotlin.reflect.jvm.internal.impl.utils.ExceptionUtilsKt;
import kotlinx.datetime.internal.DateCalculationsKt;
import leakcanary.internal.activity.db.LeaksDbHelper;

public class TypeSubstitutor implements TypeSubstitutorMarker {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final TypeSubstitutor EMPTY = create(TypeSubstitution.EMPTY);
    private final TypeSubstitution substitution;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public enum VarianceConflictType {
        NO_CONFLICT,
        IN_IN_OUT_POSITION,
        OUT_IN_IN_POSITION
    }

    private static /* synthetic */ void $$$reportNull$$$0(int i) {
        String str;
        int i2;
        switch (i) {
            case 1:
            case 2:
            case 8:
            case 11:
            case additional_type_content_opus_VALUE:
            case additional_type_content_video_VALUE:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case DateCalculationsKt.HOURS_PER_DAY /* 24 */:
            case LeaksDbHelper.VERSION /* 25 */:
            case 29:
            case 30:
            case 31:
            case 32:
            case 34:
            case 37:
            case 40:
            case 41:
            case 42:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 9:
            case 10:
            case additional_type_content_comment_VALUE:
            case 15:
            case 16:
            case 17:
            case 18:
            case 26:
            case 27:
            case 28:
            case 33:
            case 35:
            case 36:
            case 38:
            case 39:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 1:
            case 2:
            case 8:
            case 11:
            case additional_type_content_opus_VALUE:
            case additional_type_content_video_VALUE:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case DateCalculationsKt.HOURS_PER_DAY /* 24 */:
            case LeaksDbHelper.VERSION /* 25 */:
            case 29:
            case 30:
            case 31:
            case 32:
            case 34:
            case 37:
            case 40:
            case 41:
            case 42:
                i2 = 2;
                break;
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 9:
            case 10:
            case additional_type_content_comment_VALUE:
            case 15:
            case 16:
            case 17:
            case 18:
            case 26:
            case 27:
            case 28:
            case 33:
            case 35:
            case 36:
            case 38:
            case 39:
            default:
                i2 = 3;
                break;
        }
        Object[] objArr = new Object[i2];
        switch (i) {
            case 1:
            case 2:
            case 8:
            case 11:
            case additional_type_content_opus_VALUE:
            case additional_type_content_video_VALUE:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case DateCalculationsKt.HOURS_PER_DAY /* 24 */:
            case LeaksDbHelper.VERSION /* 25 */:
            case 29:
            case 30:
            case 31:
            case 32:
            case 34:
            case 37:
            case 40:
            case 41:
            case 42:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor";
                break;
            case 3:
                objArr[0] = "first";
                break;
            case 4:
                objArr[0] = "second";
                break;
            case 5:
                objArr[0] = "substitutionContext";
                break;
            case 6:
                objArr[0] = "context";
                break;
            case 7:
            default:
                objArr[0] = "substitution";
                break;
            case 9:
            case additional_type_content_comment_VALUE:
                objArr[0] = "type";
                break;
            case 10:
            case 15:
                objArr[0] = "howThisTypeIsUsed";
                break;
            case 16:
            case 17:
            case 36:
                objArr[0] = "typeProjection";
                break;
            case 18:
            case 28:
                objArr[0] = "originalProjection";
                break;
            case 26:
                objArr[0] = "originalType";
                break;
            case 27:
                objArr[0] = "substituted";
                break;
            case 33:
                objArr[0] = "annotations";
                break;
            case 35:
            case 38:
                objArr[0] = "typeParameterVariance";
                break;
            case 39:
                objArr[0] = "projectionKind";
                break;
        }
        switch (i) {
            case 1:
                objArr[1] = "replaceWithNonApproximatingSubstitution";
                break;
            case 2:
                objArr[1] = "replaceWithContravariantApproximatingSubstitution";
                break;
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 9:
            case 10:
            case additional_type_content_comment_VALUE:
            case 15:
            case 16:
            case 17:
            case 18:
            case 26:
            case 27:
            case 28:
            case 33:
            case 35:
            case 36:
            case 38:
            case 39:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor";
                break;
            case 8:
                objArr[1] = "getSubstitution";
                break;
            case 11:
            case additional_type_content_opus_VALUE:
            case additional_type_content_video_VALUE:
                objArr[1] = "safeSubstitute";
                break;
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case DateCalculationsKt.HOURS_PER_DAY /* 24 */:
            case LeaksDbHelper.VERSION /* 25 */:
                objArr[1] = "unsafeSubstitute";
                break;
            case 29:
            case 30:
            case 31:
            case 32:
                objArr[1] = "projectedTypeForConflictedTypeWithUnsafeVariance";
                break;
            case 34:
                objArr[1] = "filterOutUnsafeVariance";
                break;
            case 37:
            case 40:
            case 41:
            case 42:
                objArr[1] = "combine";
                break;
        }
        switch (i) {
            case 1:
            case 2:
            case 8:
            case 11:
            case additional_type_content_opus_VALUE:
            case additional_type_content_video_VALUE:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case DateCalculationsKt.HOURS_PER_DAY /* 24 */:
            case LeaksDbHelper.VERSION /* 25 */:
            case 29:
            case 30:
            case 31:
            case 32:
            case 34:
            case 37:
            case 40:
            case 41:
            case 42:
                break;
            case 3:
            case 4:
                objArr[2] = "createChainedSubstitutor";
                break;
            case 5:
            case 6:
            default:
                objArr[2] = "create";
                break;
            case 7:
                objArr[2] = "<init>";
                break;
            case 9:
            case 10:
                objArr[2] = "safeSubstitute";
                break;
            case additional_type_content_comment_VALUE:
            case 15:
            case 16:
                objArr[2] = "substitute";
                break;
            case 17:
                objArr[2] = "substituteWithoutApproximation";
                break;
            case 18:
                objArr[2] = "unsafeSubstitute";
                break;
            case 26:
            case 27:
            case 28:
                objArr[2] = "projectedTypeForConflictedTypeWithUnsafeVariance";
                break;
            case 33:
                objArr[2] = "filterOutUnsafeVariance";
                break;
            case 35:
            case 36:
            case 38:
            case 39:
                objArr[2] = "combine";
                break;
        }
        String format = String.format(str, objArr);
        switch (i) {
            case 1:
            case 2:
            case 8:
            case 11:
            case additional_type_content_opus_VALUE:
            case additional_type_content_video_VALUE:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case DateCalculationsKt.HOURS_PER_DAY /* 24 */:
            case LeaksDbHelper.VERSION /* 25 */:
            case 29:
            case 30:
            case 31:
            case 32:
            case 34:
            case 37:
            case 40:
            case 41:
            case 42:
                throw new IllegalStateException(format);
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 9:
            case 10:
            case additional_type_content_comment_VALUE:
            case 15:
            case 16:
            case 17:
            case 18:
            case 26:
            case 27:
            case 28:
            case 33:
            case 35:
            case 36:
            case 38:
            case 39:
            default:
                throw new IllegalArgumentException(format);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class SubstitutionException extends Exception {
        public SubstitutionException(String message) {
            super(message);
        }
    }

    public static TypeSubstitutor create(TypeSubstitution substitution) {
        if (substitution == null) {
            $$$reportNull$$$0(0);
        }
        return new TypeSubstitutor(substitution);
    }

    public TypeSubstitutor replaceWithNonApproximatingSubstitution() {
        if (!(this.substitution instanceof IndexedParametersSubstitution) || !this.substitution.approximateContravariantCapturedTypes()) {
            return this;
        }
        return new TypeSubstitutor(new IndexedParametersSubstitution(((IndexedParametersSubstitution) this.substitution).getParameters(), ((IndexedParametersSubstitution) this.substitution).getArguments(), false));
    }

    public static TypeSubstitutor createChainedSubstitutor(TypeSubstitution first, TypeSubstitution second) {
        if (first == null) {
            $$$reportNull$$$0(3);
        }
        if (second == null) {
            $$$reportNull$$$0(4);
        }
        return create(DisjointKeysUnionTypeSubstitution.create(first, second));
    }

    public static TypeSubstitutor create(Map<TypeConstructor, TypeProjection> substitutionContext) {
        if (substitutionContext == null) {
            $$$reportNull$$$0(5);
        }
        return create(TypeConstructorSubstitution.createByConstructorsMap(substitutionContext));
    }

    public static TypeSubstitutor create(KotlinType context) {
        if (context == null) {
            $$$reportNull$$$0(6);
        }
        return create(TypeConstructorSubstitution.create(context.getConstructor(), context.getArguments()));
    }

    protected TypeSubstitutor(TypeSubstitution substitution) {
        if (substitution == null) {
            $$$reportNull$$$0(7);
        }
        this.substitution = substitution;
    }

    public boolean isEmpty() {
        return this.substitution.isEmpty();
    }

    public TypeSubstitution getSubstitution() {
        TypeSubstitution typeSubstitution = this.substitution;
        if (typeSubstitution == null) {
            $$$reportNull$$$0(8);
        }
        return typeSubstitution;
    }

    public KotlinType safeSubstitute(KotlinType type, Variance howThisTypeIsUsed) {
        if (type == null) {
            $$$reportNull$$$0(9);
        }
        if (howThisTypeIsUsed == null) {
            $$$reportNull$$$0(10);
        }
        if (isEmpty()) {
            if (type == null) {
                $$$reportNull$$$0(11);
            }
            return type;
        }
        try {
            KotlinType type2 = unsafeSubstitute(new TypeProjectionImpl(howThisTypeIsUsed, type), null, 0).getType();
            if (type2 == null) {
                $$$reportNull$$$0(12);
            }
            return type2;
        } catch (SubstitutionException e) {
            ErrorType createErrorType = ErrorUtils.createErrorType(ErrorTypeKind.UNABLE_TO_SUBSTITUTE_TYPE, e.getMessage());
            if (createErrorType == null) {
                $$$reportNull$$$0(13);
            }
            return createErrorType;
        }
    }

    public KotlinType substitute(KotlinType type, Variance howThisTypeIsUsed) {
        if (type == null) {
            $$$reportNull$$$0(14);
        }
        if (howThisTypeIsUsed == null) {
            $$$reportNull$$$0(15);
        }
        TypeProjection projection = substitute(new TypeProjectionImpl(howThisTypeIsUsed, getSubstitution().prepareTopLevelType(type, howThisTypeIsUsed)));
        if (projection == null) {
            return null;
        }
        return projection.getType();
    }

    public TypeProjection substitute(TypeProjection typeProjection) {
        if (typeProjection == null) {
            $$$reportNull$$$0(16);
        }
        TypeProjection substitutedTypeProjection = substituteWithoutApproximation(typeProjection);
        if (!this.substitution.approximateCapturedTypes() && !this.substitution.approximateContravariantCapturedTypes()) {
            return substitutedTypeProjection;
        }
        return CapturedTypeApproximationKt.approximateCapturedTypesIfNecessary(substitutedTypeProjection, this.substitution.approximateContravariantCapturedTypes());
    }

    public TypeProjection substituteWithoutApproximation(TypeProjection typeProjection) {
        if (typeProjection == null) {
            $$$reportNull$$$0(17);
        }
        if (isEmpty()) {
            return typeProjection;
        }
        try {
            return unsafeSubstitute(typeProjection, null, 0);
        } catch (SubstitutionException e) {
            return null;
        }
    }

    private TypeProjection unsafeSubstitute(TypeProjection originalProjection, TypeParameterDescriptor typeParameter, int recursionDepth) throws SubstitutionException {
        KotlinType substitutedType;
        if (originalProjection == null) {
            $$$reportNull$$$0(18);
        }
        assertRecursionDepth(recursionDepth, originalProjection, this.substitution);
        if (originalProjection.isStarProjection()) {
            if (originalProjection == null) {
                $$$reportNull$$$0(19);
            }
            return originalProjection;
        }
        KotlinType type = originalProjection.getType();
        if (type instanceof TypeWithEnhancement) {
            KotlinType origin = ((TypeWithEnhancement) type).getOrigin();
            KotlinType enhancement = ((TypeWithEnhancement) type).getEnhancement();
            TypeProjection substitution = unsafeSubstitute(new TypeProjectionImpl(originalProjection.getProjectionKind(), origin), typeParameter, recursionDepth + 1);
            if (substitution.isStarProjection()) {
                if (substitution == null) {
                    $$$reportNull$$$0(20);
                }
                return substitution;
            }
            KotlinType substitutedEnhancement = substitute(enhancement, originalProjection.getProjectionKind());
            KotlinType resultingType = TypeWithEnhancementKt.wrapEnhancement(substitution.getType().unwrap(), substitutedEnhancement);
            return new TypeProjectionImpl(substitution.getProjectionKind(), resultingType);
        } else if (DynamicTypesKt.isDynamic(type) || (type.unwrap() instanceof RawType)) {
            if (originalProjection == null) {
                $$$reportNull$$$0(21);
            }
            return originalProjection;
        } else {
            TypeProjection substituted = this.substitution.mo1176get(type);
            TypeProjection replacement = substituted != null ? projectedTypeForConflictedTypeWithUnsafeVariance(type, substituted, typeParameter, originalProjection) : null;
            Variance originalProjectionKind = originalProjection.getProjectionKind();
            if (replacement == null && FlexibleTypesKt.isFlexible(type) && !TypeCapabilitiesKt.isCustomTypeParameter(type)) {
                FlexibleType flexibleType = FlexibleTypesKt.asFlexibleType(type);
                TypeProjection substitutedLower = unsafeSubstitute(new TypeProjectionImpl(originalProjectionKind, flexibleType.getLowerBound()), typeParameter, recursionDepth + 1);
                TypeProjection substitutedUpper = unsafeSubstitute(new TypeProjectionImpl(originalProjectionKind, flexibleType.getUpperBound()), typeParameter, recursionDepth + 1);
                Variance substitutedProjectionKind = substitutedLower.getProjectionKind();
                if ((substitutedProjectionKind != substitutedUpper.getProjectionKind() || originalProjectionKind != Variance.INVARIANT) && originalProjectionKind != substitutedProjectionKind) {
                    throw new AssertionError("Unexpected substituted projection kind: " + substitutedProjectionKind + "; original: " + originalProjectionKind);
                }
                if (substitutedLower.getType() != flexibleType.getLowerBound() || substitutedUpper.getType() != flexibleType.getUpperBound()) {
                    KotlinType substitutedFlexibleType = KotlinTypeFactory.flexibleType(TypeSubstitutionKt.asSimpleType(substitutedLower.getType()), TypeSubstitutionKt.asSimpleType(substitutedUpper.getType()));
                    return new TypeProjectionImpl(substitutedProjectionKind, substitutedFlexibleType);
                }
                if (originalProjection == null) {
                    $$$reportNull$$$0(22);
                }
                return originalProjection;
            } else if (KotlinBuiltIns.isNothing(type) || KotlinTypeKt.isError(type)) {
                if (originalProjection == null) {
                    $$$reportNull$$$0(23);
                }
                return originalProjection;
            } else if (replacement != null) {
                VarianceConflictType varianceConflict = conflictType(originalProjectionKind, replacement.getProjectionKind());
                boolean allowVarianceConflict = CapturedTypeConstructorKt.isCaptured(type);
                if (!allowVarianceConflict) {
                    switch (varianceConflict) {
                        case OUT_IN_IN_POSITION:
                            throw new SubstitutionException("Out-projection in in-position");
                        case IN_IN_OUT_POSITION:
                            return new TypeProjectionImpl(Variance.OUT_VARIANCE, type.getConstructor().getBuiltIns().getNullableAnyType());
                    }
                }
                CustomTypeParameter customTypeParameter = TypeCapabilitiesKt.getCustomTypeParameter(type);
                if (replacement.isStarProjection()) {
                    if (replacement == null) {
                        $$$reportNull$$$0(24);
                    }
                    return replacement;
                }
                if (customTypeParameter != null) {
                    substitutedType = customTypeParameter.substitutionResult(replacement.getType());
                } else {
                    KotlinType substitutedType2 = replacement.getType();
                    substitutedType = TypeUtils.makeNullableIfNeeded(substitutedType2, type.isMarkedNullable());
                }
                if (!type.getAnnotations().isEmpty()) {
                    Annotations typeAnnotations = filterOutUnsafeVariance(this.substitution.filterAnnotations(type.getAnnotations()));
                    substitutedType = TypeUtilsKt.replaceAnnotations(substitutedType, new CompositeAnnotations(substitutedType.getAnnotations(), typeAnnotations));
                }
                Variance resultingProjectionKind = varianceConflict == VarianceConflictType.NO_CONFLICT ? combine(originalProjectionKind, replacement.getProjectionKind()) : originalProjectionKind;
                return new TypeProjectionImpl(resultingProjectionKind, substitutedType);
            } else {
                TypeProjection substituteCompoundType = substituteCompoundType(originalProjection, recursionDepth);
                if (substituteCompoundType == null) {
                    $$$reportNull$$$0(25);
                }
                return substituteCompoundType;
            }
        }
    }

    private static TypeProjection projectedTypeForConflictedTypeWithUnsafeVariance(KotlinType originalType, TypeProjection substituted, TypeParameterDescriptor typeParameter, TypeProjection originalProjection) {
        if (originalType == null) {
            $$$reportNull$$$0(26);
        }
        if (substituted == null) {
            $$$reportNull$$$0(27);
        }
        if (originalProjection == null) {
            $$$reportNull$$$0(28);
        }
        if (!originalType.getAnnotations().hasAnnotation(StandardNames.FqNames.unsafeVariance)) {
            if (substituted == null) {
                $$$reportNull$$$0(29);
            }
            return substituted;
        }
        TypeConstructor constructor = substituted.getType().getConstructor();
        if (!(constructor instanceof NewCapturedTypeConstructor)) {
            if (substituted == null) {
                $$$reportNull$$$0(30);
            }
            return substituted;
        }
        NewCapturedTypeConstructor capturedType = (NewCapturedTypeConstructor) constructor;
        TypeProjection capturedTypeProjection = capturedType.getProjection();
        Variance varianceOfCapturedType = capturedTypeProjection.getProjectionKind();
        VarianceConflictType conflictWithTopLevelType = conflictType(originalProjection.getProjectionKind(), varianceOfCapturedType);
        if (conflictWithTopLevelType == VarianceConflictType.OUT_IN_IN_POSITION) {
            return new TypeProjectionImpl(capturedTypeProjection.getType());
        }
        if (typeParameter == null) {
            if (substituted == null) {
                $$$reportNull$$$0(31);
            }
            return substituted;
        }
        VarianceConflictType conflictTypeWithTypeParameter = conflictType(typeParameter.getVariance(), varianceOfCapturedType);
        if (conflictTypeWithTypeParameter == VarianceConflictType.OUT_IN_IN_POSITION) {
            return new TypeProjectionImpl(capturedTypeProjection.getType());
        }
        if (substituted == null) {
            $$$reportNull$$$0(32);
        }
        return substituted;
    }

    private static Annotations filterOutUnsafeVariance(Annotations annotations) {
        if (annotations == null) {
            $$$reportNull$$$0(33);
        }
        if (annotations.hasAnnotation(StandardNames.FqNames.unsafeVariance)) {
            return new FilteredAnnotations(annotations, new Function1<FqName, Boolean>() { // from class: kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor.1
                private static /* synthetic */ void $$$reportNull$$$0(int i) {
                    throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "name", "kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor$1", "invoke"));
                }

                @Override // kotlin.jvm.functions.Function1
                public Boolean invoke(FqName name) {
                    if (name == null) {
                        $$$reportNull$$$0(0);
                    }
                    return Boolean.valueOf(!name.equals(StandardNames.FqNames.unsafeVariance));
                }
            });
        }
        if (annotations == null) {
            $$$reportNull$$$0(34);
        }
        return annotations;
    }

    private TypeProjection substituteCompoundType(TypeProjection originalProjection, int recursionDepth) throws SubstitutionException {
        KotlinType type = originalProjection.getType();
        Variance projectionKind = originalProjection.getProjectionKind();
        if (type.getConstructor().mo1171getDeclarationDescriptor() instanceof TypeParameterDescriptor) {
            return originalProjection;
        }
        KotlinType substitutedAbbreviation = null;
        SimpleType abbreviation = SpecialTypesKt.getAbbreviation(type);
        if (abbreviation != null) {
            TypeSubstitutor substitutorForAbbreviation = replaceWithNonApproximatingSubstitution();
            substitutedAbbreviation = substitutorForAbbreviation.substitute(abbreviation, Variance.INVARIANT);
        }
        List<TypeProjection> substitutedArguments = substituteTypeArguments(type.getConstructor().getParameters(), type.getArguments(), recursionDepth);
        KotlinType substitutedType = TypeSubstitutionKt.replace(type, substitutedArguments, this.substitution.filterAnnotations(type.getAnnotations()));
        if ((substitutedType instanceof SimpleType) && (substitutedAbbreviation instanceof SimpleType)) {
            substitutedType = SpecialTypesKt.withAbbreviation((SimpleType) substitutedType, (SimpleType) substitutedAbbreviation);
        }
        return new TypeProjectionImpl(projectionKind, substitutedType);
    }

    private List<TypeProjection> substituteTypeArguments(List<TypeParameterDescriptor> typeParameters, List<TypeProjection> typeArguments, int recursionDepth) throws SubstitutionException {
        List<TypeProjection> substitutedArguments = new ArrayList<>(typeParameters.size());
        boolean wereChanges = false;
        for (int i = 0; i < typeParameters.size(); i++) {
            TypeParameterDescriptor typeParameter = typeParameters.get(i);
            TypeProjection typeArgument = typeArguments.get(i);
            TypeProjection substitutedTypeArgument = unsafeSubstitute(typeArgument, typeParameter, recursionDepth + 1);
            switch (conflictType(typeParameter.getVariance(), substitutedTypeArgument.getProjectionKind())) {
                case OUT_IN_IN_POSITION:
                case IN_IN_OUT_POSITION:
                    substitutedTypeArgument = TypeUtils.makeStarProjection(typeParameter);
                    break;
                case NO_CONFLICT:
                    if (typeParameter.getVariance() != Variance.INVARIANT && !substitutedTypeArgument.isStarProjection()) {
                        substitutedTypeArgument = new TypeProjectionImpl(Variance.INVARIANT, substitutedTypeArgument.getType());
                        break;
                    }
                    break;
            }
            if (substitutedTypeArgument != typeArgument) {
                wereChanges = true;
            }
            substitutedArguments.add(substitutedTypeArgument);
        }
        return !wereChanges ? typeArguments : substitutedArguments;
    }

    public static Variance combine(Variance typeParameterVariance, TypeProjection typeProjection) {
        if (typeParameterVariance == null) {
            $$$reportNull$$$0(35);
        }
        if (typeProjection == null) {
            $$$reportNull$$$0(36);
        }
        if (typeProjection.isStarProjection()) {
            Variance variance = Variance.OUT_VARIANCE;
            if (variance == null) {
                $$$reportNull$$$0(37);
            }
            return variance;
        }
        return combine(typeParameterVariance, typeProjection.getProjectionKind());
    }

    public static Variance combine(Variance typeParameterVariance, Variance projectionKind) {
        if (typeParameterVariance == null) {
            $$$reportNull$$$0(38);
        }
        if (projectionKind == null) {
            $$$reportNull$$$0(39);
        }
        if (typeParameterVariance == Variance.INVARIANT) {
            if (projectionKind == null) {
                $$$reportNull$$$0(40);
            }
            return projectionKind;
        } else if (projectionKind == Variance.INVARIANT) {
            if (typeParameterVariance == null) {
                $$$reportNull$$$0(41);
            }
            return typeParameterVariance;
        } else if (typeParameterVariance == projectionKind) {
            if (projectionKind == null) {
                $$$reportNull$$$0(42);
            }
            return projectionKind;
        } else {
            throw new AssertionError("Variance conflict: type parameter variance '" + typeParameterVariance + "' and projection kind '" + projectionKind + "' cannot be combined");
        }
    }

    private static VarianceConflictType conflictType(Variance position, Variance argument) {
        if (position == Variance.IN_VARIANCE && argument == Variance.OUT_VARIANCE) {
            return VarianceConflictType.OUT_IN_IN_POSITION;
        }
        if (position == Variance.OUT_VARIANCE && argument == Variance.IN_VARIANCE) {
            return VarianceConflictType.IN_IN_OUT_POSITION;
        }
        return VarianceConflictType.NO_CONFLICT;
    }

    private static void assertRecursionDepth(int recursionDepth, TypeProjection projection, TypeSubstitution substitution) {
        if (recursionDepth > 100) {
            throw new IllegalStateException("Recursion too deep. Most likely infinite loop while substituting " + safeToString(projection) + "; substitution: " + safeToString(substitution));
        }
    }

    private static String safeToString(Object o) {
        try {
            return o.toString();
        } catch (Throwable e) {
            if (ExceptionUtilsKt.isProcessCanceledException(e)) {
                throw ((RuntimeException) e);
            }
            return "[Exception while computing toString(): " + e + "]";
        }
    }
}