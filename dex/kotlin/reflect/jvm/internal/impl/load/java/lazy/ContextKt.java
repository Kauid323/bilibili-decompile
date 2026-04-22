package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassOrPackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.load.java.JavaTypeQualifiersByElementType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameterListOwner;

/* compiled from: context.kt */
public final class ContextKt {
    public static final LazyJavaResolverContext child(LazyJavaResolverContext $this$child, TypeParameterResolver typeParameterResolver) {
        Intrinsics.checkNotNullParameter($this$child, "<this>");
        Intrinsics.checkNotNullParameter(typeParameterResolver, "typeParameterResolver");
        return new LazyJavaResolverContext($this$child.getComponents(), typeParameterResolver, $this$child.getDelegateForDefaultTypeQualifiers$descriptors_jvm());
    }

    public static final JavaTypeQualifiersByElementType computeNewDefaultTypeQualifiers(LazyJavaResolverContext $this$computeNewDefaultTypeQualifiers, Annotations additionalAnnotations) {
        Intrinsics.checkNotNullParameter($this$computeNewDefaultTypeQualifiers, "<this>");
        Intrinsics.checkNotNullParameter(additionalAnnotations, "additionalAnnotations");
        return $this$computeNewDefaultTypeQualifiers.getComponents().getAnnotationTypeQualifierResolver().extractAndMergeDefaultQualifiers($this$computeNewDefaultTypeQualifiers.getDefaultTypeQualifiers(), additionalAnnotations);
    }

    public static final LazyJavaResolverContext replaceComponents(LazyJavaResolverContext $this$replaceComponents, JavaResolverComponents components) {
        Intrinsics.checkNotNullParameter($this$replaceComponents, "<this>");
        Intrinsics.checkNotNullParameter(components, "components");
        return new LazyJavaResolverContext(components, $this$replaceComponents.getTypeParameterResolver(), $this$replaceComponents.getDelegateForDefaultTypeQualifiers$descriptors_jvm());
    }

    private static final LazyJavaResolverContext child(LazyJavaResolverContext $this$child, DeclarationDescriptor containingDeclaration, JavaTypeParameterListOwner typeParameterOwner, int typeParametersIndexOffset, Lazy<JavaTypeQualifiersByElementType> lazy) {
        LazyJavaTypeParameterResolver typeParameterResolver;
        JavaResolverComponents components = $this$child.getComponents();
        if (typeParameterOwner != null) {
            typeParameterResolver = new LazyJavaTypeParameterResolver($this$child, containingDeclaration, typeParameterOwner, typeParametersIndexOffset);
        } else {
            typeParameterResolver = $this$child.getTypeParameterResolver();
        }
        return new LazyJavaResolverContext(components, typeParameterResolver, lazy);
    }

    public static /* synthetic */ LazyJavaResolverContext childForMethod$default(LazyJavaResolverContext lazyJavaResolverContext, DeclarationDescriptor declarationDescriptor, JavaTypeParameterListOwner javaTypeParameterListOwner, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return childForMethod(lazyJavaResolverContext, declarationDescriptor, javaTypeParameterListOwner, i);
    }

    public static final LazyJavaResolverContext childForMethod(LazyJavaResolverContext $this$childForMethod, DeclarationDescriptor containingDeclaration, JavaTypeParameterListOwner typeParameterOwner, int typeParametersIndexOffset) {
        Intrinsics.checkNotNullParameter($this$childForMethod, "<this>");
        Intrinsics.checkNotNullParameter(containingDeclaration, "containingDeclaration");
        Intrinsics.checkNotNullParameter(typeParameterOwner, "typeParameterOwner");
        return child($this$childForMethod, containingDeclaration, typeParameterOwner, typeParametersIndexOffset, $this$childForMethod.getDelegateForDefaultTypeQualifiers$descriptors_jvm());
    }

    public static /* synthetic */ LazyJavaResolverContext childForClassOrPackage$default(LazyJavaResolverContext lazyJavaResolverContext, ClassOrPackageFragmentDescriptor classOrPackageFragmentDescriptor, JavaTypeParameterListOwner javaTypeParameterListOwner, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            javaTypeParameterListOwner = null;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return childForClassOrPackage(lazyJavaResolverContext, classOrPackageFragmentDescriptor, javaTypeParameterListOwner, i);
    }

    public static final LazyJavaResolverContext childForClassOrPackage(LazyJavaResolverContext $this$childForClassOrPackage, ClassOrPackageFragmentDescriptor containingDeclaration, JavaTypeParameterListOwner typeParameterOwner, int typeParametersIndexOffset) {
        Intrinsics.checkNotNullParameter($this$childForClassOrPackage, "<this>");
        Intrinsics.checkNotNullParameter(containingDeclaration, "containingDeclaration");
        return child($this$childForClassOrPackage, containingDeclaration, typeParameterOwner, typeParametersIndexOffset, LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0($this$childForClassOrPackage, containingDeclaration) { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.ContextKt$$Lambda$0
            private final LazyJavaResolverContext arg$0;
            private final ClassOrPackageFragmentDescriptor arg$1;

            {
                this.arg$0 = $this$childForClassOrPackage;
                this.arg$1 = containingDeclaration;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                JavaTypeQualifiersByElementType childForClassOrPackage$lambda$0;
                childForClassOrPackage$lambda$0 = ContextKt.childForClassOrPackage$lambda$0(this.arg$0, this.arg$1);
                return childForClassOrPackage$lambda$0;
            }
        }));
    }

    public static final JavaTypeQualifiersByElementType childForClassOrPackage$lambda$0(LazyJavaResolverContext $this_childForClassOrPackage, ClassOrPackageFragmentDescriptor $containingDeclaration) {
        return computeNewDefaultTypeQualifiers($this_childForClassOrPackage, $containingDeclaration.getAnnotations());
    }

    public static final LazyJavaResolverContext copyWithNewDefaultTypeQualifiers(LazyJavaResolverContext $this$copyWithNewDefaultTypeQualifiers, Annotations additionalAnnotations) {
        Intrinsics.checkNotNullParameter($this$copyWithNewDefaultTypeQualifiers, "<this>");
        Intrinsics.checkNotNullParameter(additionalAnnotations, "additionalAnnotations");
        return additionalAnnotations.isEmpty() ? $this$copyWithNewDefaultTypeQualifiers : new LazyJavaResolverContext($this$copyWithNewDefaultTypeQualifiers.getComponents(), $this$copyWithNewDefaultTypeQualifiers.getTypeParameterResolver(), LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0($this$copyWithNewDefaultTypeQualifiers, additionalAnnotations) { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.ContextKt$$Lambda$1
            private final LazyJavaResolverContext arg$0;
            private final Annotations arg$1;

            {
                this.arg$0 = $this$copyWithNewDefaultTypeQualifiers;
                this.arg$1 = additionalAnnotations;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                JavaTypeQualifiersByElementType computeNewDefaultTypeQualifiers;
                computeNewDefaultTypeQualifiers = ContextKt.computeNewDefaultTypeQualifiers(this.arg$0, this.arg$1);
                return computeNewDefaultTypeQualifiers;
            }
        }));
    }
}