package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* compiled from: typeParameterUtils.kt */
public final class TypeParameterUtilsKt {
    public static final List<TypeParameterDescriptor> computeConstructorTypeParameters(ClassifierDescriptorWithTypeParameters $this$computeConstructorTypeParameters) {
        List list;
        Object element$iv;
        TypeConstructor typeConstructor;
        Intrinsics.checkNotNullParameter($this$computeConstructorTypeParameters, "<this>");
        List declaredParameters = $this$computeConstructorTypeParameters.getDeclaredTypeParameters();
        Intrinsics.checkNotNullExpressionValue(declaredParameters, "getDeclaredTypeParameters(...)");
        if ($this$computeConstructorTypeParameters.isInner() || ($this$computeConstructorTypeParameters.getContainingDeclaration() instanceof CallableDescriptor)) {
            List parametersFromContainingFunctions = SequencesKt.toList(SequencesKt.flatMap(SequencesKt.filter(SequencesKt.takeWhile(DescriptorUtilsKt.getParents($this$computeConstructorTypeParameters), new Function1() { // from class: kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterUtilsKt$$Lambda$0
                @Override // kotlin.jvm.functions.Function1
                public Object invoke(Object obj) {
                    boolean computeConstructorTypeParameters$lambda$0;
                    computeConstructorTypeParameters$lambda$0 = TypeParameterUtilsKt.computeConstructorTypeParameters$lambda$0((DeclarationDescriptor) obj);
                    return Boolean.valueOf(computeConstructorTypeParameters$lambda$0);
                }
            }), new Function1() { // from class: kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterUtilsKt$$Lambda$1
                @Override // kotlin.jvm.functions.Function1
                public Object invoke(Object obj) {
                    boolean computeConstructorTypeParameters$lambda$1;
                    computeConstructorTypeParameters$lambda$1 = TypeParameterUtilsKt.computeConstructorTypeParameters$lambda$1((DeclarationDescriptor) obj);
                    return Boolean.valueOf(computeConstructorTypeParameters$lambda$1);
                }
            }), new Function1() { // from class: kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterUtilsKt$$Lambda$2
                @Override // kotlin.jvm.functions.Function1
                public Object invoke(Object obj) {
                    Sequence computeConstructorTypeParameters$lambda$2;
                    computeConstructorTypeParameters$lambda$2 = TypeParameterUtilsKt.computeConstructorTypeParameters$lambda$2((DeclarationDescriptor) obj);
                    return computeConstructorTypeParameters$lambda$2;
                }
            }));
            Sequence $this$firstIsInstanceOrNull$iv = DescriptorUtilsKt.getParents($this$computeConstructorTypeParameters);
            Iterator<DeclarationDescriptor> it = $this$firstIsInstanceOrNull$iv.iterator();
            while (true) {
                list = null;
                if (!it.hasNext()) {
                    element$iv = null;
                    break;
                }
                element$iv = it.next();
                if (element$iv instanceof ClassDescriptor) {
                    break;
                }
            }
            ClassDescriptor classDescriptor = (ClassDescriptor) element$iv;
            if (classDescriptor != null && (typeConstructor = classDescriptor.getTypeConstructor()) != null) {
                list = typeConstructor.getParameters();
            }
            if (list == null) {
                list = CollectionsKt.emptyList();
            }
            List containingClassTypeConstructorParameters = list;
            if (parametersFromContainingFunctions.isEmpty() && containingClassTypeConstructorParameters.isEmpty()) {
                List<TypeParameterDescriptor> declaredTypeParameters = $this$computeConstructorTypeParameters.getDeclaredTypeParameters();
                Intrinsics.checkNotNullExpressionValue(declaredTypeParameters, "getDeclaredTypeParameters(...)");
                return declaredTypeParameters;
            }
            Iterable $this$map$iv = CollectionsKt.plus((Collection) parametersFromContainingFunctions, (Iterable) containingClassTypeConstructorParameters);
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                TypeParameterDescriptor it2 = (TypeParameterDescriptor) item$iv$iv;
                Intrinsics.checkNotNull(it2);
                destination$iv$iv.add(capturedCopyForInnerDeclaration(it2, $this$computeConstructorTypeParameters, declaredParameters.size()));
            }
            List additional = (List) destination$iv$iv;
            return CollectionsKt.plus((Collection) declaredParameters, (Iterable) additional);
        }
        return declaredParameters;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean computeConstructorTypeParameters$lambda$0(DeclarationDescriptor it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it instanceof CallableDescriptor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean computeConstructorTypeParameters$lambda$1(DeclarationDescriptor it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return !(it instanceof ConstructorDescriptor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Sequence computeConstructorTypeParameters$lambda$2(DeclarationDescriptor it) {
        Intrinsics.checkNotNullParameter(it, "it");
        List<TypeParameterDescriptor> typeParameters = ((CallableDescriptor) it).getTypeParameters();
        Intrinsics.checkNotNullExpressionValue(typeParameters, "getTypeParameters(...)");
        return CollectionsKt.asSequence(typeParameters);
    }

    private static final CapturedTypeParameterDescriptor capturedCopyForInnerDeclaration(TypeParameterDescriptor $this$capturedCopyForInnerDeclaration, DeclarationDescriptor declarationDescriptor, int declaredTypeParametersCount) {
        return new CapturedTypeParameterDescriptor($this$capturedCopyForInnerDeclaration, declarationDescriptor, declaredTypeParametersCount);
    }

    public static final PossiblyInnerType buildPossiblyInnerType(KotlinType $this$buildPossiblyInnerType) {
        Intrinsics.checkNotNullParameter($this$buildPossiblyInnerType, "<this>");
        ClassifierDescriptor mo1171getDeclarationDescriptor = $this$buildPossiblyInnerType.getConstructor().mo1171getDeclarationDescriptor();
        return buildPossiblyInnerType($this$buildPossiblyInnerType, mo1171getDeclarationDescriptor instanceof ClassifierDescriptorWithTypeParameters ? (ClassifierDescriptorWithTypeParameters) mo1171getDeclarationDescriptor : null, 0);
    }

    private static final PossiblyInnerType buildPossiblyInnerType(KotlinType $this$buildPossiblyInnerType, ClassifierDescriptorWithTypeParameters classifierDescriptor, int index) {
        if (classifierDescriptor == null || ErrorUtils.isError(classifierDescriptor)) {
            return null;
        }
        int toIndex = classifierDescriptor.getDeclaredTypeParameters().size() + index;
        if (!classifierDescriptor.isInner()) {
            if (!(toIndex == $this$buildPossiblyInnerType.getArguments().size() || DescriptorUtils.isLocal(classifierDescriptor))) {
                throw new AssertionError(($this$buildPossiblyInnerType.getArguments().size() - toIndex) + " trailing arguments were found in " + $this$buildPossiblyInnerType + " type");
            }
            return new PossiblyInnerType(classifierDescriptor, $this$buildPossiblyInnerType.getArguments().subList(index, $this$buildPossiblyInnerType.getArguments().size()), null);
        }
        List argumentsSubList = $this$buildPossiblyInnerType.getArguments().subList(index, toIndex);
        DeclarationDescriptor containingDeclaration = classifierDescriptor.getContainingDeclaration();
        return new PossiblyInnerType(classifierDescriptor, argumentsSubList, buildPossiblyInnerType($this$buildPossiblyInnerType, containingDeclaration instanceof ClassifierDescriptorWithTypeParameters ? (ClassifierDescriptorWithTypeParameters) containingDeclaration : null, toIndex));
    }
}