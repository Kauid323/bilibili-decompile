package kotlin.reflect.jvm.internal.impl.types;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

public class DescriptorSubstitutor {
    private static /* synthetic */ void $$$reportNull$$$0(int i) {
        String str;
        int i2;
        switch (i) {
            case 4:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 4:
                i2 = 2;
                break;
            default:
                i2 = 3;
                break;
        }
        Object[] objArr = new Object[i2];
        switch (i) {
            case 1:
            case 6:
                objArr[0] = "originalSubstitution";
                break;
            case 2:
            case 7:
                objArr[0] = "newContainingDeclaration";
                break;
            case 3:
            case 8:
                objArr[0] = "result";
                break;
            case 4:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/DescriptorSubstitutor";
                break;
            case 5:
            default:
                objArr[0] = "typeParameters";
                break;
        }
        switch (i) {
            case 4:
                objArr[1] = "substituteTypeParameters";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/types/DescriptorSubstitutor";
                break;
        }
        switch (i) {
            case 4:
                break;
            default:
                objArr[2] = "substituteTypeParameters";
                break;
        }
        String format = String.format(str, objArr);
        switch (i) {
            case 4:
                throw new IllegalStateException(format);
            default:
                throw new IllegalArgumentException(format);
        }
    }

    public static TypeSubstitutor substituteTypeParameters(List<TypeParameterDescriptor> typeParameters, TypeSubstitution originalSubstitution, DeclarationDescriptor newContainingDeclaration, List<TypeParameterDescriptor> result) {
        if (typeParameters == null) {
            $$$reportNull$$$0(0);
        }
        if (originalSubstitution == null) {
            $$$reportNull$$$0(1);
        }
        if (newContainingDeclaration == null) {
            $$$reportNull$$$0(2);
        }
        if (result == null) {
            $$$reportNull$$$0(3);
        }
        TypeSubstitutor substitutor = substituteTypeParameters(typeParameters, originalSubstitution, newContainingDeclaration, result, null);
        if (substitutor == null) {
            throw new AssertionError("Substitution failed");
        }
        if (substitutor == null) {
            $$$reportNull$$$0(4);
        }
        return substitutor;
    }

    public static TypeSubstitutor substituteTypeParameters(List<TypeParameterDescriptor> typeParameters, TypeSubstitution originalSubstitution, DeclarationDescriptor newContainingDeclaration, List<TypeParameterDescriptor> result, boolean[] wereChanges) {
        if (typeParameters == null) {
            $$$reportNull$$$0(5);
        }
        if (originalSubstitution == null) {
            $$$reportNull$$$0(6);
        }
        if (newContainingDeclaration == null) {
            $$$reportNull$$$0(7);
        }
        if (result == null) {
            $$$reportNull$$$0(8);
        }
        Map<TypeConstructor, TypeProjection> mutableSubstitutionMap = new HashMap<>();
        Map<TypeParameterDescriptor, TypeParameterDescriptorImpl> substitutedMap = new HashMap<>();
        int index = 0;
        for (TypeParameterDescriptor descriptor : typeParameters) {
            TypeParameterDescriptorImpl substituted = TypeParameterDescriptorImpl.createForFurtherModification(newContainingDeclaration, descriptor.getAnnotations(), descriptor.isReified(), descriptor.getVariance(), descriptor.getName(), index, SourceElement.NO_SOURCE, descriptor.getStorageManager());
            mutableSubstitutionMap.put(descriptor.getTypeConstructor(), new TypeProjectionImpl(substituted.getDefaultType()));
            substitutedMap.put(descriptor, substituted);
            result.add(substituted);
            index++;
        }
        TypeConstructorSubstitution mutableSubstitution = TypeConstructorSubstitution.createByConstructorsMap(mutableSubstitutionMap);
        TypeSubstitutor substitutor = TypeSubstitutor.createChainedSubstitutor(originalSubstitution, mutableSubstitution);
        TypeSubstitutor nonApproximatingSubstitutor = TypeSubstitutor.createChainedSubstitutor(originalSubstitution.replaceWithNonApproximating(), mutableSubstitution);
        for (TypeParameterDescriptor descriptor2 : typeParameters) {
            TypeParameterDescriptorImpl substituted2 = substitutedMap.get(descriptor2);
            for (KotlinType upperBound : descriptor2.getUpperBounds()) {
                ClassifierDescriptor upperBoundDeclaration = upperBound.getConstructor().mo1171getDeclarationDescriptor();
                TypeSubstitutor boundSubstitutor = ((upperBoundDeclaration instanceof TypeParameterDescriptor) && TypeUtilsKt.hasTypeParameterRecursiveBounds((TypeParameterDescriptor) upperBoundDeclaration)) ? substitutor : nonApproximatingSubstitutor;
                KotlinType substitutedBound = boundSubstitutor.substitute(upperBound, Variance.OUT_VARIANCE);
                if (substitutedBound == null) {
                    return null;
                }
                if (substitutedBound != upperBound && wereChanges != null) {
                    wereChanges[0] = true;
                }
                substituted2.addUpperBound(substitutedBound);
            }
            substituted2.setInitialized();
        }
        return substitutor;
    }
}