package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.TypeAliasExpansionReportStrategy;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* compiled from: TypeAliasExpander.kt */
public final class TypeAliasExpander {
    public static final Companion Companion = new Companion(null);
    private static final TypeAliasExpander NON_REPORTING = new TypeAliasExpander(TypeAliasExpansionReportStrategy.DO_NOTHING.INSTANCE, false);
    private final TypeAliasExpansionReportStrategy reportStrategy;
    private final boolean shouldCheckBounds;

    public TypeAliasExpander(TypeAliasExpansionReportStrategy reportStrategy, boolean shouldCheckBounds) {
        Intrinsics.checkNotNullParameter(reportStrategy, "reportStrategy");
        this.reportStrategy = reportStrategy;
        this.shouldCheckBounds = shouldCheckBounds;
    }

    public final SimpleType expand(TypeAliasExpansion typeAliasExpansion, TypeAttributes attributes) {
        Intrinsics.checkNotNullParameter(typeAliasExpansion, "typeAliasExpansion");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        return expandRecursively(typeAliasExpansion, attributes, false, 0, true);
    }

    private final SimpleType expandRecursively(TypeAliasExpansion typeAliasExpansion, TypeAttributes attributes, boolean isNullable, int recursionDepth, boolean withAbbreviatedType) {
        TypeProjectionImpl underlyingProjection = new TypeProjectionImpl(Variance.INVARIANT, typeAliasExpansion.getDescriptor().getUnderlyingType());
        TypeProjection expandedProjection = expandTypeProjection(underlyingProjection, typeAliasExpansion, null, recursionDepth);
        KotlinType type = expandedProjection.getType();
        Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
        SimpleType expandedType = TypeSubstitutionKt.asSimpleType(type);
        if (KotlinTypeKt.isError(expandedType)) {
            return expandedType;
        }
        if (!(expandedProjection.getProjectionKind() == Variance.INVARIANT)) {
            throw new AssertionError("Type alias expansion: result for " + typeAliasExpansion.getDescriptor() + " is " + expandedProjection.getProjectionKind() + ", should be invariant");
        }
        checkRepeatedAnnotations(expandedType.getAnnotations(), AnnotationsTypeAttributeKt.getAnnotations(attributes));
        SimpleType it = TypeUtils.makeNullableIfNeeded(combineAttributes(expandedType, attributes), isNullable);
        Intrinsics.checkNotNullExpressionValue(it, "let(...)");
        if (withAbbreviatedType) {
            return SpecialTypesKt.withAbbreviation(it, createAbbreviation(typeAliasExpansion, attributes, isNullable));
        }
        return it;
    }

    private final SimpleType createAbbreviation(TypeAliasExpansion $this$createAbbreviation, TypeAttributes attributes, boolean isNullable) {
        TypeConstructor typeConstructor = $this$createAbbreviation.getDescriptor().getTypeConstructor();
        Intrinsics.checkNotNullExpressionValue(typeConstructor, "getTypeConstructor(...)");
        return KotlinTypeFactory.simpleTypeWithNonTrivialMemberScope(attributes, typeConstructor, $this$createAbbreviation.getArguments(), isNullable, MemberScope.Empty.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00d7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final TypeProjection expandTypeProjection(TypeProjection underlyingProjection, TypeAliasExpansion typeAliasExpansion, TypeParameterDescriptor typeParameterDescriptor, int recursionDepth) {
        Variance substitutionVariance;
        Variance parameterVariance;
        Variance variance;
        Companion.assertRecursionDepth(recursionDepth, typeAliasExpansion.getDescriptor());
        if (underlyingProjection.isStarProjection()) {
            Intrinsics.checkNotNull(typeParameterDescriptor);
            TypeProjection makeStarProjection = TypeUtils.makeStarProjection(typeParameterDescriptor);
            Intrinsics.checkNotNullExpressionValue(makeStarProjection, "makeStarProjection(...)");
            return makeStarProjection;
        }
        KotlinType underlyingType = underlyingProjection.getType();
        Intrinsics.checkNotNullExpressionValue(underlyingType, "getType(...)");
        TypeProjection argument = typeAliasExpansion.getReplacement(underlyingType.getConstructor());
        if (argument == null) {
            return expandNonArgumentTypeProjection(underlyingProjection, typeAliasExpansion, recursionDepth);
        }
        if (argument.isStarProjection()) {
            Intrinsics.checkNotNull(typeParameterDescriptor);
            TypeProjection makeStarProjection2 = TypeUtils.makeStarProjection(typeParameterDescriptor);
            Intrinsics.checkNotNullExpressionValue(makeStarProjection2, "makeStarProjection(...)");
            return makeStarProjection2;
        }
        UnwrappedType argumentType = argument.getType().unwrap();
        TypeAliasExpander $this$expandTypeProjection_u24lambda_u240 = this;
        Variance argumentVariance = argument.getProjectionKind();
        Intrinsics.checkNotNullExpressionValue(argumentVariance, "getProjectionKind(...)");
        Variance underlyingVariance = underlyingProjection.getProjectionKind();
        Intrinsics.checkNotNullExpressionValue(underlyingVariance, "getProjectionKind(...)");
        if (underlyingVariance != argumentVariance && underlyingVariance != Variance.INVARIANT) {
            if (argumentVariance != Variance.INVARIANT) {
                $this$expandTypeProjection_u24lambda_u240.reportStrategy.conflictingProjection(typeAliasExpansion.getDescriptor(), typeParameterDescriptor, argumentType);
            } else {
                substitutionVariance = underlyingVariance;
                if (typeParameterDescriptor != null || (parameterVariance = typeParameterDescriptor.getVariance()) == null) {
                    parameterVariance = Variance.INVARIANT;
                }
                if (parameterVariance != substitutionVariance && parameterVariance != Variance.INVARIANT) {
                    if (substitutionVariance != Variance.INVARIANT) {
                        variance = Variance.INVARIANT;
                        Variance resultingVariance = variance;
                        checkRepeatedAnnotations(underlyingType.getAnnotations(), argumentType.getAnnotations());
                        UnwrappedType substitutedType = argumentType instanceof DynamicType ? combineAttributes((DynamicType) argumentType, underlyingType.getAttributes()) : combineNullabilityAndAnnotations(TypeSubstitutionKt.asSimpleType(argumentType), underlyingType);
                        return new TypeProjectionImpl(resultingVariance, substitutedType);
                    }
                    $this$expandTypeProjection_u24lambda_u240.reportStrategy.conflictingProjection(typeAliasExpansion.getDescriptor(), typeParameterDescriptor, argumentType);
                }
                variance = substitutionVariance;
                Variance resultingVariance2 = variance;
                checkRepeatedAnnotations(underlyingType.getAnnotations(), argumentType.getAnnotations());
                if (argumentType instanceof DynamicType) {
                }
                return new TypeProjectionImpl(resultingVariance2, substitutedType);
            }
        }
        substitutionVariance = argumentVariance;
        if (typeParameterDescriptor != null) {
        }
        parameterVariance = Variance.INVARIANT;
        if (parameterVariance != substitutionVariance) {
            if (substitutionVariance != Variance.INVARIANT) {
            }
        }
        variance = substitutionVariance;
        Variance resultingVariance22 = variance;
        checkRepeatedAnnotations(underlyingType.getAnnotations(), argumentType.getAnnotations());
        if (argumentType instanceof DynamicType) {
        }
        return new TypeProjectionImpl(resultingVariance22, substitutedType);
    }

    private final DynamicType combineAttributes(DynamicType $this$combineAttributes, TypeAttributes newAttributes) {
        return $this$combineAttributes.replaceAttributes(createdCombinedAttributes($this$combineAttributes, newAttributes));
    }

    private final SimpleType combineAttributes(SimpleType $this$combineAttributes, TypeAttributes newAttributes) {
        return KotlinTypeKt.isError($this$combineAttributes) ? $this$combineAttributes : TypeSubstitutionKt.replace$default($this$combineAttributes, null, createdCombinedAttributes($this$combineAttributes, newAttributes), 1, null);
    }

    private final TypeAttributes createdCombinedAttributes(KotlinType $this$createdCombinedAttributes, TypeAttributes newAttributes) {
        return KotlinTypeKt.isError($this$createdCombinedAttributes) ? $this$createdCombinedAttributes.getAttributes() : newAttributes.add($this$createdCombinedAttributes.getAttributes());
    }

    private final void checkRepeatedAnnotations(Annotations existingAnnotations, Annotations newAnnotations) {
        Annotations $this$mapTo$iv = existingAnnotations;
        Collection destination$iv = new HashSet();
        for (Object item$iv : $this$mapTo$iv) {
            AnnotationDescriptor it = (AnnotationDescriptor) item$iv;
            destination$iv.add(it.getFqName());
        }
        HashSet existingAnnotationFqNames = (HashSet) destination$iv;
        for (AnnotationDescriptor annotation : newAnnotations) {
            if (existingAnnotationFqNames.contains(annotation.getFqName())) {
                this.reportStrategy.repeatedAnnotation(annotation);
            }
        }
    }

    private final SimpleType combineNullability(SimpleType $this$combineNullability, KotlinType fromType) {
        SimpleType makeNullableIfNeeded = TypeUtils.makeNullableIfNeeded($this$combineNullability, fromType.isMarkedNullable());
        Intrinsics.checkNotNullExpressionValue(makeNullableIfNeeded, "makeNullableIfNeeded(...)");
        return makeNullableIfNeeded;
    }

    private final SimpleType combineNullabilityAndAnnotations(SimpleType $this$combineNullabilityAndAnnotations, KotlinType fromType) {
        return combineAttributes(combineNullability($this$combineNullabilityAndAnnotations, fromType), fromType.getAttributes());
    }

    private final TypeProjection expandNonArgumentTypeProjection(TypeProjection originalProjection, TypeAliasExpansion typeAliasExpansion, int recursionDepth) {
        UnwrappedType originalType = originalProjection.getType().unwrap();
        if (DynamicTypesKt.isDynamic(originalType)) {
            return originalProjection;
        }
        SimpleType type = TypeSubstitutionKt.asSimpleType(originalType);
        if (KotlinTypeKt.isError(type) || !TypeUtilsKt.requiresTypeAliasExpansion(type)) {
            return originalProjection;
        }
        TypeConstructor typeConstructor = type.getConstructor();
        ClassifierDescriptor typeDescriptor = typeConstructor.mo1171getDeclarationDescriptor();
        if (!(typeConstructor.getParameters().size() == type.getArguments().size())) {
            throw new AssertionError("Unexpected malformed type: " + type);
        }
        if (typeDescriptor instanceof TypeParameterDescriptor) {
            return originalProjection;
        }
        if (typeDescriptor instanceof TypeAliasDescriptor) {
            if (typeAliasExpansion.isRecursion((TypeAliasDescriptor) typeDescriptor)) {
                this.reportStrategy.recursiveTypeAlias((TypeAliasDescriptor) typeDescriptor);
                Variance variance = Variance.INVARIANT;
                ErrorTypeKind errorTypeKind = ErrorTypeKind.RECURSIVE_TYPE_ALIAS;
                String name = ((TypeAliasDescriptor) typeDescriptor).getName().toString();
                Intrinsics.checkNotNullExpressionValue(name, "toString(...)");
                return new TypeProjectionImpl(variance, ErrorUtils.createErrorType(errorTypeKind, name));
            }
            Iterable $this$mapIndexed$iv = type.getArguments();
            boolean z = false;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$mapIndexed$iv, 10));
            Iterable $this$mapIndexedTo$iv$iv = $this$mapIndexed$iv;
            int index$iv$iv = 0;
            for (Object item$iv$iv : $this$mapIndexedTo$iv$iv) {
                int index$iv$iv2 = index$iv$iv + 1;
                if (index$iv$iv < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                Iterable $this$mapIndexed$iv2 = $this$mapIndexed$iv;
                TypeProjection typeAliasArgument = (TypeProjection) item$iv$iv;
                destination$iv$iv.add(expandTypeProjection(typeAliasArgument, typeAliasExpansion, typeConstructor.getParameters().get(index$iv$iv), recursionDepth + 1));
                index$iv$iv = index$iv$iv2;
                $this$mapIndexed$iv = $this$mapIndexed$iv2;
                z = z;
                $this$mapIndexedTo$iv$iv = $this$mapIndexedTo$iv$iv;
            }
            List expandedArguments = (List) destination$iv$iv;
            TypeAliasExpansion nestedExpansion = TypeAliasExpansion.Companion.create(typeAliasExpansion, (TypeAliasDescriptor) typeDescriptor, expandedArguments);
            SimpleType nestedExpandedType = expandRecursively(nestedExpansion, type.getAttributes(), type.isMarkedNullable(), recursionDepth + 1, false);
            SimpleType typeWithAbbreviation = DynamicTypesKt.isDynamic(nestedExpandedType) ? nestedExpandedType : SpecialTypesKt.withAbbreviation(nestedExpandedType, substituteArguments(type, typeAliasExpansion, recursionDepth));
            return new TypeProjectionImpl(originalProjection.getProjectionKind(), typeWithAbbreviation);
        }
        SimpleType substitutedType = substituteArguments(type, typeAliasExpansion, recursionDepth);
        checkTypeArgumentsSubstitution(type, substitutedType);
        return new TypeProjectionImpl(originalProjection.getProjectionKind(), substitutedType);
    }

    private final SimpleType substituteArguments(SimpleType $this$substituteArguments, TypeAliasExpansion typeAliasExpansion, int recursionDepth) {
        TypeConstructor typeConstructor;
        Iterable $this$mapIndexed$iv;
        boolean z;
        TypeProjectionImpl typeProjectionImpl;
        TypeConstructor typeConstructor2 = $this$substituteArguments.getConstructor();
        Iterable $this$mapIndexed$iv2 = $this$substituteArguments.getArguments();
        boolean z2 = false;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$mapIndexed$iv2, 10));
        int index$iv$iv = 0;
        for (Object item$iv$iv : $this$mapIndexed$iv2) {
            int index$iv$iv2 = index$iv$iv + 1;
            if (index$iv$iv < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            TypeProjection originalArgument = (TypeProjection) item$iv$iv;
            TypeProjection projection = expandTypeProjection(originalArgument, typeAliasExpansion, typeConstructor2.getParameters().get(index$iv$iv), recursionDepth + 1);
            if (projection.isStarProjection()) {
                typeConstructor = typeConstructor2;
                $this$mapIndexed$iv = $this$mapIndexed$iv2;
                z = z2;
                typeProjectionImpl = projection;
            } else {
                typeConstructor = typeConstructor2;
                $this$mapIndexed$iv = $this$mapIndexed$iv2;
                z = z2;
                typeProjectionImpl = new TypeProjectionImpl(projection.getProjectionKind(), TypeUtils.makeNullableIfNeeded(projection.getType(), originalArgument.getType().isMarkedNullable()));
            }
            destination$iv$iv.add(typeProjectionImpl);
            index$iv$iv = index$iv$iv2;
            typeConstructor2 = typeConstructor;
            $this$mapIndexed$iv2 = $this$mapIndexed$iv;
            z2 = z;
        }
        List substitutedArguments = (List) destination$iv$iv;
        return TypeSubstitutionKt.replace$default($this$substituteArguments, substitutedArguments, null, 2, null);
    }

    private final void checkTypeArgumentsSubstitution(KotlinType unsubstitutedType, KotlinType substitutedType) {
        TypeSubstitutor typeSubstitutor = TypeSubstitutor.create(substitutedType);
        Intrinsics.checkNotNullExpressionValue(typeSubstitutor, "create(...)");
        Iterable $this$forEachIndexed$iv = substitutedType.getArguments();
        int i = 0;
        for (Object item$iv : $this$forEachIndexed$iv) {
            int index$iv = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            TypeProjection substitutedArgument = (TypeProjection) item$iv;
            if (!substitutedArgument.isStarProjection()) {
                KotlinType type = substitutedArgument.getType();
                Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
                if (!TypeUtilsKt.containsTypeAliasParameters(type)) {
                    TypeProjection unsubstitutedArgument = unsubstitutedType.getArguments().get(i);
                    TypeParameterDescriptor typeParameter = unsubstitutedType.getConstructor().getParameters().get(i);
                    if (this.shouldCheckBounds) {
                        TypeAliasExpansionReportStrategy typeAliasExpansionReportStrategy = this.reportStrategy;
                        KotlinType type2 = unsubstitutedArgument.getType();
                        Intrinsics.checkNotNullExpressionValue(type2, "getType(...)");
                        KotlinType type3 = substitutedArgument.getType();
                        Intrinsics.checkNotNullExpressionValue(type3, "getType(...)");
                        Intrinsics.checkNotNull(typeParameter);
                        typeAliasExpansionReportStrategy.boundsViolationInSubstitution(typeSubstitutor, type2, type3, typeParameter);
                    }
                }
            }
            i = index$iv;
        }
    }

    /* compiled from: TypeAliasExpander.kt */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void assertRecursionDepth(int recursionDepth, TypeAliasDescriptor typeAliasDescriptor) {
            if (recursionDepth > 100) {
                throw new AssertionError("Too deep recursion while expanding type alias " + typeAliasDescriptor.getName());
            }
        }
    }
}