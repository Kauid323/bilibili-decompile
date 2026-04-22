package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;

/* compiled from: StarProjectionImpl.kt */
public final class StarProjectionImplKt {
    private static final KotlinType buildStarProjectionTypeByTypeParameters(final List<? extends TypeConstructor> list, List<? extends KotlinType> list2, KotlinBuiltIns builtIns) {
        KotlinType substitute = TypeSubstitutor.create(new TypeConstructorSubstitution() { // from class: kotlin.reflect.jvm.internal.impl.types.StarProjectionImplKt$buildStarProjectionTypeByTypeParameters$1
            @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution
            public TypeProjection get(TypeConstructor key) {
                Intrinsics.checkNotNullParameter(key, "key");
                if (list.contains(key)) {
                    ClassifierDescriptor mo1171getDeclarationDescriptor = key.mo1171getDeclarationDescriptor();
                    Intrinsics.checkNotNull(mo1171getDeclarationDescriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.TypeParameterDescriptor");
                    return TypeUtils.makeStarProjection((TypeParameterDescriptor) mo1171getDeclarationDescriptor);
                }
                return null;
            }
        }).substitute((KotlinType) CollectionsKt.first((List<? extends Object>) list2), Variance.OUT_VARIANCE);
        if (substitute == null) {
            SimpleType defaultBound = builtIns.getDefaultBound();
            Intrinsics.checkNotNullExpressionValue(defaultBound, "getDefaultBound(...)");
            return defaultBound;
        }
        return substitute;
    }

    public static final KotlinType starProjectionType(TypeParameterDescriptor $this$starProjectionType) {
        Intrinsics.checkNotNullParameter($this$starProjectionType, "<this>");
        DeclarationDescriptor descriptor = $this$starProjectionType.getContainingDeclaration();
        Intrinsics.checkNotNullExpressionValue(descriptor, "getContainingDeclaration(...)");
        if (descriptor instanceof ClassifierDescriptorWithTypeParameters) {
            Iterable parameters = ((ClassifierDescriptorWithTypeParameters) descriptor).getTypeConstructor().getParameters();
            Intrinsics.checkNotNullExpressionValue(parameters, "getParameters(...)");
            Iterable $this$map$iv = parameters;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                TypeParameterDescriptor it = (TypeParameterDescriptor) item$iv$iv;
                TypeConstructor typeConstructor = it.getTypeConstructor();
                Intrinsics.checkNotNullExpressionValue(typeConstructor, "getTypeConstructor(...)");
                destination$iv$iv.add(typeConstructor);
            }
            List<KotlinType> upperBounds = $this$starProjectionType.getUpperBounds();
            Intrinsics.checkNotNullExpressionValue(upperBounds, "getUpperBounds(...)");
            return buildStarProjectionTypeByTypeParameters((List) destination$iv$iv, upperBounds, DescriptorUtilsKt.getBuiltIns($this$starProjectionType));
        } else if (descriptor instanceof FunctionDescriptor) {
            Iterable typeParameters = ((FunctionDescriptor) descriptor).getTypeParameters();
            Intrinsics.checkNotNullExpressionValue(typeParameters, "getTypeParameters(...)");
            Iterable $this$map$iv2 = typeParameters;
            Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
            for (Object item$iv$iv2 : $this$map$iv2) {
                TypeParameterDescriptor it2 = (TypeParameterDescriptor) item$iv$iv2;
                TypeConstructor typeConstructor2 = it2.getTypeConstructor();
                Intrinsics.checkNotNullExpressionValue(typeConstructor2, "getTypeConstructor(...)");
                destination$iv$iv2.add(typeConstructor2);
            }
            List<KotlinType> upperBounds2 = $this$starProjectionType.getUpperBounds();
            Intrinsics.checkNotNullExpressionValue(upperBounds2, "getUpperBounds(...)");
            return buildStarProjectionTypeByTypeParameters((List) destination$iv$iv2, upperBounds2, DescriptorUtilsKt.getBuiltIns($this$starProjectionType));
        } else {
            throw new IllegalArgumentException("Unsupported descriptor type to build star projection type based on type parameters of it");
        }
    }
}