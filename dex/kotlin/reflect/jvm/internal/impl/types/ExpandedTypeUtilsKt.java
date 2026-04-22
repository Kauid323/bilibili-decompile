package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeSubstitutorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeVariance;

/* compiled from: expandedTypeUtils.kt */
public final class ExpandedTypeUtilsKt {

    /* compiled from: expandedTypeUtils.kt */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TypeVariance.values().length];
            try {
                iArr[TypeVariance.IN.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final KotlinTypeMarker computeExpandedTypeForInlineClass(TypeSystemCommonBackendContext $this$computeExpandedTypeForInlineClass, KotlinTypeMarker inlineClassType) {
        Intrinsics.checkNotNullParameter($this$computeExpandedTypeForInlineClass, "<this>");
        Intrinsics.checkNotNullParameter(inlineClassType, "inlineClassType");
        return computeExpandedTypeInner($this$computeExpandedTypeForInlineClass, inlineClassType, new HashSet());
    }

    private static final KotlinTypeMarker computeExpandedTypeInner(TypeSystemCommonBackendContext $this$computeExpandedTypeInner, KotlinTypeMarker kotlinType, HashSet<TypeConstructorMarker> hashSet) {
        KotlinTypeMarker expandedUnderlyingType;
        KotlinTypeMarker expandedUpperBound;
        TypeConstructorMarker classifier = $this$computeExpandedTypeInner.typeConstructor(kotlinType);
        if (hashSet.add(classifier)) {
            TypeParameterMarker typeParameter = $this$computeExpandedTypeInner.getTypeParameterClassifier(classifier);
            if (typeParameter != null) {
                KotlinTypeMarker upperBound = $this$computeExpandedTypeInner.getRepresentativeUpperBound(typeParameter);
                KotlinTypeMarker expandedUpperBound2 = computeExpandedTypeInner($this$computeExpandedTypeInner, upperBound, hashSet);
                if (expandedUpperBound2 != null) {
                    boolean upperBoundIsPrimitiveOrInlineClass = $this$computeExpandedTypeInner.isInlineClass($this$computeExpandedTypeInner.typeConstructor(upperBound)) || ((upperBound instanceof SimpleTypeMarker) && $this$computeExpandedTypeInner.isPrimitiveType((SimpleTypeMarker) upperBound));
                    if ((expandedUpperBound2 instanceof SimpleTypeMarker) && $this$computeExpandedTypeInner.isPrimitiveType((SimpleTypeMarker) expandedUpperBound2) && $this$computeExpandedTypeInner.isNullableType(kotlinType) && upperBoundIsPrimitiveOrInlineClass) {
                        expandedUpperBound = $this$computeExpandedTypeInner.makeNullable(upperBound);
                    } else if ($this$computeExpandedTypeInner.isNullableType(expandedUpperBound2) || !$this$computeExpandedTypeInner.isMarkedNullable(kotlinType)) {
                        expandedUpperBound = expandedUpperBound2;
                    } else {
                        expandedUpperBound = $this$computeExpandedTypeInner.makeNullable(expandedUpperBound2);
                    }
                    return expandedUpperBound;
                }
                return null;
            }
            if ($this$computeExpandedTypeInner.isInlineClass(classifier)) {
                KotlinTypeMarker underlyingType = getSubstitutedUnderlyingType($this$computeExpandedTypeInner, kotlinType);
                if (underlyingType == null || (expandedUnderlyingType = computeExpandedTypeInner($this$computeExpandedTypeInner, underlyingType, hashSet)) == null) {
                    return null;
                }
                if (!$this$computeExpandedTypeInner.isNullableType(kotlinType)) {
                    return expandedUnderlyingType;
                }
                if (!$this$computeExpandedTypeInner.isNullableType(expandedUnderlyingType) && (!(expandedUnderlyingType instanceof SimpleTypeMarker) || !$this$computeExpandedTypeInner.isPrimitiveType((SimpleTypeMarker) expandedUnderlyingType))) {
                    return $this$computeExpandedTypeInner.makeNullable(expandedUnderlyingType);
                }
            }
            return kotlinType;
        }
        return null;
    }

    private static final KotlinTypeMarker getSubstitutedUnderlyingType(TypeSystemCommonBackendContext $this$getSubstitutedUnderlyingType, KotlinTypeMarker type) {
        List typeParameters = $this$getSubstitutedUnderlyingType.getParameters($this$getSubstitutedUnderlyingType.typeConstructor(type));
        Iterable $this$mapIndexed$iv = $this$getSubstitutedUnderlyingType.getArguments(type);
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$mapIndexed$iv, 10));
        int index$iv$iv = 0;
        for (Object item$iv$iv : $this$mapIndexed$iv) {
            int index$iv$iv2 = index$iv$iv + 1;
            if (index$iv$iv < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            TypeArgumentMarker typeArgument = (TypeArgumentMarker) item$iv$iv;
            KotlinTypeMarker type2 = $this$getSubstitutedUnderlyingType.getType(typeArgument);
            if (type2 == null) {
                type2 = $this$getSubstitutedUnderlyingType.getRepresentativeUpperBound(typeParameters.get(index$iv$iv));
            }
            destination$iv$iv.add(type2);
            index$iv$iv = index$iv$iv2;
        }
        List typeArguments = (List) destination$iv$iv;
        List $this$map$iv = typeParameters;
        Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv2 : $this$map$iv) {
            TypeParameterMarker it = (TypeParameterMarker) item$iv$iv2;
            destination$iv$iv2.add($this$getSubstitutedUnderlyingType.getTypeConstructor(it));
        }
        Map mapping = MapsKt.toMap(CollectionsKt.zip((List) destination$iv$iv2, typeArguments));
        TypeSubstitutorMarker substitutor = $this$getSubstitutedUnderlyingType.typeSubstitutorForUnderlyingType(mapping);
        KotlinTypeMarker underlyingType = $this$getSubstitutedUnderlyingType.getUnsubstitutedUnderlyingType(type);
        if (underlyingType == null) {
            return null;
        }
        TypeParameterMarker underlyingTypeParameter = asTypeParameterOrArrayThereof($this$getSubstitutedUnderlyingType, underlyingType);
        return underlyingTypeParameter == null ? $this$getSubstitutedUnderlyingType.safeSubstitute(substitutor, underlyingType) : substituteUpperBound($this$getSubstitutedUnderlyingType, underlyingType, $this$getSubstitutedUnderlyingType.safeSubstitute(substitutor, $this$getSubstitutedUnderlyingType.getRepresentativeUpperBound(underlyingTypeParameter)));
    }

    private static final TypeParameterMarker asTypeParameter(TypeSystemCommonBackendContext $this$asTypeParameter, KotlinTypeMarker type) {
        return $this$asTypeParameter.getTypeParameterClassifier($this$asTypeParameter.typeConstructor(type));
    }

    private static final TypeParameterMarker asTypeParameterOrArrayThereof(TypeSystemCommonBackendContext $this$asTypeParameterOrArrayThereof, KotlinTypeMarker type) {
        KotlinTypeMarker it;
        TypeParameterMarker typeParameter = asTypeParameter($this$asTypeParameterOrArrayThereof, type);
        if (typeParameter != null) {
            return typeParameter;
        }
        if ($this$asTypeParameterOrArrayThereof.isArrayOrNullableArray(type) && (it = $this$asTypeParameterOrArrayThereof.getType((TypeArgumentMarker) CollectionsKt.single((List<? extends Object>) $this$asTypeParameterOrArrayThereof.getArguments(type)))) != null) {
            return asTypeParameterOrArrayThereof($this$asTypeParameterOrArrayThereof, it);
        }
        return null;
    }

    private static final KotlinTypeMarker substituteUpperBound(TypeSystemCommonBackendContext $this$substituteUpperBound, KotlinTypeMarker type, KotlinTypeMarker upperBound) {
        SimpleTypeMarker elementTypeBounded;
        if (asTypeParameter($this$substituteUpperBound, type) != null) {
            return $this$substituteUpperBound.isNullableType(type) ? $this$substituteUpperBound.makeNullable(upperBound) : upperBound;
        }
        TypeArgumentMarker elementArgument = (TypeArgumentMarker) CollectionsKt.single((List<? extends Object>) $this$substituteUpperBound.getArguments(type));
        if (WhenMappings.$EnumSwitchMapping$0[$this$substituteUpperBound.getVariance(elementArgument).ordinal()] == 1) {
            elementTypeBounded = $this$substituteUpperBound.nullableAnyType();
        } else {
            KotlinTypeMarker type2 = $this$substituteUpperBound.getType(elementArgument);
            Intrinsics.checkNotNull(type2);
            elementTypeBounded = substituteUpperBound($this$substituteUpperBound, type2, upperBound);
        }
        SimpleTypeMarker arrayType = $this$substituteUpperBound.arrayType(elementTypeBounded);
        return $this$substituteUpperBound.isNullableType(type) ? $this$substituteUpperBound.makeNullable(arrayType) : arrayType;
    }
}