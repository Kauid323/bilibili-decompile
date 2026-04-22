package kotlin.reflect.jvm.internal.impl.types.typesApproximation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.renderer.ClassifierNamePolicy;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructor;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorKt;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutionKt;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancementKt;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* compiled from: CapturedTypeApproximation.kt */
public final class CapturedTypeApproximationKt {

    /* compiled from: CapturedTypeApproximation.kt */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Variance.values().length];
            try {
                iArr[Variance.INVARIANT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[Variance.IN_VARIANCE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[Variance.OUT_VARIANCE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private static final TypeProjection toTypeProjection(TypeArgument $this$toTypeProjection) {
        if ($this$toTypeProjection.isConsistent()) {
            return (Intrinsics.areEqual($this$toTypeProjection.getInProjection(), $this$toTypeProjection.getOutProjection()) || $this$toTypeProjection.getTypeParameter().getVariance() == Variance.IN_VARIANCE) ? new TypeProjectionImpl($this$toTypeProjection.getInProjection()) : (!KotlinBuiltIns.isNothing($this$toTypeProjection.getInProjection()) || $this$toTypeProjection.getTypeParameter().getVariance() == Variance.IN_VARIANCE) ? KotlinBuiltIns.isNullableAny($this$toTypeProjection.getOutProjection()) ? new TypeProjectionImpl(toTypeProjection$removeProjectionIfRedundant($this$toTypeProjection, Variance.IN_VARIANCE), $this$toTypeProjection.getInProjection()) : new TypeProjectionImpl(toTypeProjection$removeProjectionIfRedundant($this$toTypeProjection, Variance.OUT_VARIANCE), $this$toTypeProjection.getOutProjection()) : new TypeProjectionImpl(toTypeProjection$removeProjectionIfRedundant($this$toTypeProjection, Variance.OUT_VARIANCE), $this$toTypeProjection.getOutProjection());
        }
        DescriptorRenderer descriptorRenderer = DescriptorRenderer.Companion.withOptions(new Function1() { // from class: kotlin.reflect.jvm.internal.impl.types.typesApproximation.CapturedTypeApproximationKt$$Lambda$0
            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                Unit typeProjection$lambda$0$0;
                typeProjection$lambda$0$0 = CapturedTypeApproximationKt.toTypeProjection$lambda$0$0((DescriptorRendererOptions) obj);
                return typeProjection$lambda$0$0;
            }
        });
        throw new AssertionError("Only consistent enhanced type projection can be converted to type projection, but [" + descriptorRenderer.render($this$toTypeProjection.getTypeParameter()) + ": <" + descriptorRenderer.renderType($this$toTypeProjection.getInProjection()) + ", " + descriptorRenderer.renderType($this$toTypeProjection.getOutProjection()) + ">] was found");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit toTypeProjection$lambda$0$0(DescriptorRendererOptions withOptions) {
        Intrinsics.checkNotNullParameter(withOptions, "$this$withOptions");
        withOptions.setClassifierNamePolicy(ClassifierNamePolicy.FULLY_QUALIFIED.INSTANCE);
        return Unit.INSTANCE;
    }

    private static final Variance toTypeProjection$removeProjectionIfRedundant(TypeArgument $this_toTypeProjection, Variance variance) {
        return variance == $this_toTypeProjection.getTypeParameter().getVariance() ? Variance.INVARIANT : variance;
    }

    private static final TypeArgument toTypeArgument(TypeProjection $this$toTypeArgument, TypeParameterDescriptor typeParameter) {
        switch (WhenMappings.$EnumSwitchMapping$0[TypeSubstitutor.combine(typeParameter.getVariance(), $this$toTypeArgument).ordinal()]) {
            case 1:
                KotlinType type = $this$toTypeArgument.getType();
                Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
                KotlinType type2 = $this$toTypeArgument.getType();
                Intrinsics.checkNotNullExpressionValue(type2, "getType(...)");
                return new TypeArgument(typeParameter, type, type2);
            case 2:
                KotlinType type3 = $this$toTypeArgument.getType();
                Intrinsics.checkNotNullExpressionValue(type3, "getType(...)");
                SimpleType nullableAnyType = DescriptorUtilsKt.getBuiltIns(typeParameter).getNullableAnyType();
                Intrinsics.checkNotNullExpressionValue(nullableAnyType, "getNullableAnyType(...)");
                return new TypeArgument(typeParameter, type3, nullableAnyType);
            case 3:
                SimpleType nothingType = DescriptorUtilsKt.getBuiltIns(typeParameter).getNothingType();
                Intrinsics.checkNotNullExpressionValue(nothingType, "getNothingType(...)");
                KotlinType type4 = $this$toTypeArgument.getType();
                Intrinsics.checkNotNullExpressionValue(type4, "getType(...)");
                return new TypeArgument(typeParameter, nothingType, type4);
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static final TypeProjection approximateCapturedTypesIfNecessary(TypeProjection typeProjection, boolean approximateContravariant) {
        if (typeProjection == null) {
            return null;
        }
        if (typeProjection.isStarProjection()) {
            return typeProjection;
        }
        KotlinType type = typeProjection.getType();
        Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
        if (!TypeUtils.contains(type, new Function1() { // from class: kotlin.reflect.jvm.internal.impl.types.typesApproximation.CapturedTypeApproximationKt$$Lambda$1
            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                Boolean approximateCapturedTypesIfNecessary$lambda$0;
                approximateCapturedTypesIfNecessary$lambda$0 = CapturedTypeApproximationKt.approximateCapturedTypesIfNecessary$lambda$0((UnwrappedType) obj);
                return approximateCapturedTypesIfNecessary$lambda$0;
            }
        })) {
            return typeProjection;
        }
        Variance howThisTypeIsUsed = typeProjection.getProjectionKind();
        Intrinsics.checkNotNullExpressionValue(howThisTypeIsUsed, "getProjectionKind(...)");
        if (howThisTypeIsUsed == Variance.OUT_VARIANCE) {
            ApproximationBounds approximation = approximateCapturedTypes(type);
            return new TypeProjectionImpl(howThisTypeIsUsed, approximation.getUpper());
        } else if (approximateContravariant) {
            KotlinType approximation2 = approximateCapturedTypes(type).getLower();
            return new TypeProjectionImpl(howThisTypeIsUsed, approximation2);
        } else {
            return substituteCapturedTypesWithProjections(typeProjection);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Boolean approximateCapturedTypesIfNecessary$lambda$0(UnwrappedType it) {
        Intrinsics.checkNotNull(it);
        return Boolean.valueOf(CapturedTypeConstructorKt.isCaptured(it));
    }

    private static final TypeProjection substituteCapturedTypesWithProjections(TypeProjection typeProjection) {
        TypeSubstitutor typeSubstitutor = TypeSubstitutor.create(new TypeConstructorSubstitution() { // from class: kotlin.reflect.jvm.internal.impl.types.typesApproximation.CapturedTypeApproximationKt$substituteCapturedTypesWithProjections$typeSubstitutor$1
            @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution
            public TypeProjection get(TypeConstructor key) {
                Intrinsics.checkNotNullParameter(key, "key");
                CapturedTypeConstructor capturedTypeConstructor = key instanceof CapturedTypeConstructor ? (CapturedTypeConstructor) key : null;
                if (capturedTypeConstructor == null) {
                    return null;
                }
                if (capturedTypeConstructor.getProjection().isStarProjection()) {
                    return new TypeProjectionImpl(Variance.OUT_VARIANCE, capturedTypeConstructor.getProjection().getType());
                }
                return capturedTypeConstructor.getProjection();
            }
        });
        Intrinsics.checkNotNullExpressionValue(typeSubstitutor, "create(...)");
        return typeSubstitutor.substituteWithoutApproximation(typeProjection);
    }

    public static final ApproximationBounds<KotlinType> approximateCapturedTypes(KotlinType type) {
        SimpleType replaceTypeArguments;
        Intrinsics.checkNotNullParameter(type, "type");
        if (FlexibleTypesKt.isFlexible(type)) {
            ApproximationBounds boundsForFlexibleLower = approximateCapturedTypes(FlexibleTypesKt.lowerIfFlexible(type));
            ApproximationBounds boundsForFlexibleUpper = approximateCapturedTypes(FlexibleTypesKt.upperIfFlexible(type));
            return new ApproximationBounds<>(TypeWithEnhancementKt.inheritEnhancement(KotlinTypeFactory.flexibleType(FlexibleTypesKt.lowerIfFlexible(boundsForFlexibleLower.getLower()), FlexibleTypesKt.upperIfFlexible(boundsForFlexibleUpper.getLower())), type), TypeWithEnhancementKt.inheritEnhancement(KotlinTypeFactory.flexibleType(FlexibleTypesKt.lowerIfFlexible(boundsForFlexibleLower.getUpper()), FlexibleTypesKt.upperIfFlexible(boundsForFlexibleUpper.getUpper())), type));
        }
        TypeConstructor typeConstructor = type.getConstructor();
        if (CapturedTypeConstructorKt.isCaptured(type)) {
            Intrinsics.checkNotNull(typeConstructor, "null cannot be cast to non-null type org.jetbrains.kotlin.resolve.calls.inference.CapturedTypeConstructor");
            TypeProjection typeProjection = ((CapturedTypeConstructor) typeConstructor).getProjection();
            KotlinType type2 = typeProjection.getType();
            Intrinsics.checkNotNullExpressionValue(type2, "getType(...)");
            KotlinType bound = approximateCapturedTypes$makeNullableIfNeeded(type2, type);
            switch (WhenMappings.$EnumSwitchMapping$0[typeProjection.getProjectionKind().ordinal()]) {
                case 2:
                    return new ApproximationBounds<>(bound, TypeUtilsKt.getBuiltIns(type).getNullableAnyType());
                case 3:
                    SimpleType nothingType = TypeUtilsKt.getBuiltIns(type).getNothingType();
                    Intrinsics.checkNotNullExpressionValue(nothingType, "getNothingType(...)");
                    return new ApproximationBounds<>(approximateCapturedTypes$makeNullableIfNeeded(nothingType, type), bound);
                default:
                    throw new AssertionError("Only nontrivial projections should have been captured, not: " + typeProjection);
            }
        } else if (type.getArguments().isEmpty() || type.getArguments().size() != typeConstructor.getParameters().size()) {
            return new ApproximationBounds<>(type, type);
        } else {
            ArrayList lowerBoundArguments = new ArrayList();
            ArrayList upperBoundArguments = new ArrayList();
            List<TypeParameterDescriptor> parameters = typeConstructor.getParameters();
            Intrinsics.checkNotNullExpressionValue(parameters, "getParameters(...)");
            for (Pair pair : CollectionsKt.zip(type.getArguments(), parameters)) {
                TypeProjection typeProjection2 = (TypeProjection) pair.component1();
                TypeParameterDescriptor typeParameter = (TypeParameterDescriptor) pair.component2();
                Intrinsics.checkNotNull(typeParameter);
                TypeArgument typeArgument = toTypeArgument(typeProjection2, typeParameter);
                if (typeProjection2.isStarProjection()) {
                    lowerBoundArguments.add(typeArgument);
                    upperBoundArguments.add(typeArgument);
                } else {
                    ApproximationBounds<TypeArgument> approximateProjection = approximateProjection(typeArgument);
                    TypeArgument lower = approximateProjection.component1();
                    TypeArgument upper = approximateProjection.component2();
                    lowerBoundArguments.add(lower);
                    upperBoundArguments.add(upper);
                }
            }
            ArrayList $this$any$iv = lowerBoundArguments;
            boolean z = false;
            if (!($this$any$iv instanceof Collection) || !$this$any$iv.isEmpty()) {
                Iterator it = $this$any$iv.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Object element$iv = it.next();
                    TypeArgument it2 = (TypeArgument) element$iv;
                    if (!it2.isConsistent()) {
                        z = true;
                        break;
                    }
                }
            }
            boolean lowerBoundIsTrivial = z;
            if (lowerBoundIsTrivial) {
                SimpleType nothingType2 = TypeUtilsKt.getBuiltIns(type).getNothingType();
                Intrinsics.checkNotNullExpressionValue(nothingType2, "getNothingType(...)");
                replaceTypeArguments = nothingType2;
            } else {
                replaceTypeArguments = replaceTypeArguments(type, lowerBoundArguments);
            }
            return new ApproximationBounds<>(replaceTypeArguments, replaceTypeArguments(type, upperBoundArguments));
        }
    }

    private static final KotlinType approximateCapturedTypes$makeNullableIfNeeded(KotlinType $this$approximateCapturedTypes_u24makeNullableIfNeeded, KotlinType $type) {
        KotlinType makeNullableIfNeeded = TypeUtils.makeNullableIfNeeded($this$approximateCapturedTypes_u24makeNullableIfNeeded, $type.isMarkedNullable());
        Intrinsics.checkNotNullExpressionValue(makeNullableIfNeeded, "makeNullableIfNeeded(...)");
        return makeNullableIfNeeded;
    }

    private static final KotlinType replaceTypeArguments(KotlinType $this$replaceTypeArguments, List<TypeArgument> list) {
        if (!($this$replaceTypeArguments.getArguments().size() == list.size())) {
            throw new AssertionError("Incorrect type arguments " + list);
        }
        List<TypeArgument> $this$map$iv = list;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            TypeArgument it = (TypeArgument) item$iv$iv;
            destination$iv$iv.add(toTypeProjection(it));
        }
        return TypeSubstitutionKt.replace$default($this$replaceTypeArguments, (List) destination$iv$iv, null, null, 6, null);
    }

    private static final ApproximationBounds<TypeArgument> approximateProjection(TypeArgument typeArgument) {
        ApproximationBounds<KotlinType> approximateCapturedTypes = approximateCapturedTypes(typeArgument.getInProjection());
        KotlinType inLower = approximateCapturedTypes.component1();
        KotlinType inUpper = approximateCapturedTypes.component2();
        ApproximationBounds<KotlinType> approximateCapturedTypes2 = approximateCapturedTypes(typeArgument.getOutProjection());
        KotlinType outLower = approximateCapturedTypes2.component1();
        KotlinType outUpper = approximateCapturedTypes2.component2();
        return new ApproximationBounds<>(new TypeArgument(typeArgument.getTypeParameter(), inUpper, outLower), new TypeArgument(typeArgument.getTypeParameter(), inLower, outUpper));
    }
}