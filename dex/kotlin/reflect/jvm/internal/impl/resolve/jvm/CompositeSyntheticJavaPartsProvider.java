package kotlin.reflect.jvm.internal.impl.resolve.jvm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: SyntheticJavaPartsProvider.kt */
public final class CompositeSyntheticJavaPartsProvider implements SyntheticJavaPartsProvider {
    private final List<SyntheticJavaPartsProvider> inner;

    /* JADX WARN: Multi-variable type inference failed */
    public CompositeSyntheticJavaPartsProvider(List<? extends SyntheticJavaPartsProvider> inner) {
        Intrinsics.checkNotNullParameter(inner, "inner");
        this.inner = inner;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.jvm.SyntheticJavaPartsProvider
    public List<Name> getMethodNames(ClassDescriptor thisDescriptor, LazyJavaResolverContext c) {
        Intrinsics.checkNotNullParameter(thisDescriptor, "thisDescriptor");
        Intrinsics.checkNotNullParameter(c, "c");
        Iterable $this$flatMap$iv = this.inner;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$flatMap$iv) {
            SyntheticJavaPartsProvider it = (SyntheticJavaPartsProvider) element$iv$iv;
            Iterable list$iv$iv = it.getMethodNames(thisDescriptor, c);
            CollectionsKt.addAll(destination$iv$iv, list$iv$iv);
        }
        return (List) destination$iv$iv;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.jvm.SyntheticJavaPartsProvider
    public void generateMethods(ClassDescriptor thisDescriptor, Name name, Collection<SimpleFunctionDescriptor> result, LazyJavaResolverContext c) {
        Intrinsics.checkNotNullParameter(thisDescriptor, "thisDescriptor");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(result, "result");
        Intrinsics.checkNotNullParameter(c, "c");
        Iterable $this$forEach$iv = this.inner;
        for (Object element$iv : $this$forEach$iv) {
            SyntheticJavaPartsProvider it = (SyntheticJavaPartsProvider) element$iv;
            it.generateMethods(thisDescriptor, name, result, c);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.jvm.SyntheticJavaPartsProvider
    public List<Name> getStaticFunctionNames(ClassDescriptor thisDescriptor, LazyJavaResolverContext c) {
        Intrinsics.checkNotNullParameter(thisDescriptor, "thisDescriptor");
        Intrinsics.checkNotNullParameter(c, "c");
        Iterable $this$flatMap$iv = this.inner;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$flatMap$iv) {
            SyntheticJavaPartsProvider it = (SyntheticJavaPartsProvider) element$iv$iv;
            Iterable list$iv$iv = it.getStaticFunctionNames(thisDescriptor, c);
            CollectionsKt.addAll(destination$iv$iv, list$iv$iv);
        }
        return (List) destination$iv$iv;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.jvm.SyntheticJavaPartsProvider
    public void generateStaticFunctions(ClassDescriptor thisDescriptor, Name name, Collection<SimpleFunctionDescriptor> result, LazyJavaResolverContext c) {
        Intrinsics.checkNotNullParameter(thisDescriptor, "thisDescriptor");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(result, "result");
        Intrinsics.checkNotNullParameter(c, "c");
        Iterable $this$forEach$iv = this.inner;
        for (Object element$iv : $this$forEach$iv) {
            SyntheticJavaPartsProvider it = (SyntheticJavaPartsProvider) element$iv;
            it.generateStaticFunctions(thisDescriptor, name, result, c);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.jvm.SyntheticJavaPartsProvider
    public void generateConstructors(ClassDescriptor thisDescriptor, List<ClassConstructorDescriptor> result, LazyJavaResolverContext c) {
        Intrinsics.checkNotNullParameter(thisDescriptor, "thisDescriptor");
        Intrinsics.checkNotNullParameter(result, "result");
        Intrinsics.checkNotNullParameter(c, "c");
        Iterable $this$forEach$iv = this.inner;
        for (Object element$iv : $this$forEach$iv) {
            SyntheticJavaPartsProvider it = (SyntheticJavaPartsProvider) element$iv;
            it.generateConstructors(thisDescriptor, result, c);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.jvm.SyntheticJavaPartsProvider
    public List<Name> getNestedClassNames(ClassDescriptor thisDescriptor, LazyJavaResolverContext c) {
        Intrinsics.checkNotNullParameter(thisDescriptor, "thisDescriptor");
        Intrinsics.checkNotNullParameter(c, "c");
        Iterable $this$flatMap$iv = this.inner;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$flatMap$iv) {
            SyntheticJavaPartsProvider it = (SyntheticJavaPartsProvider) element$iv$iv;
            Iterable list$iv$iv = it.getNestedClassNames(thisDescriptor, c);
            CollectionsKt.addAll(destination$iv$iv, list$iv$iv);
        }
        return (List) destination$iv$iv;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.jvm.SyntheticJavaPartsProvider
    public void generateNestedClass(ClassDescriptor thisDescriptor, Name name, List<ClassDescriptor> result, LazyJavaResolverContext c) {
        Intrinsics.checkNotNullParameter(thisDescriptor, "thisDescriptor");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(result, "result");
        Intrinsics.checkNotNullParameter(c, "c");
        Iterable $this$forEach$iv = this.inner;
        for (Object element$iv : $this$forEach$iv) {
            SyntheticJavaPartsProvider it = (SyntheticJavaPartsProvider) element$iv;
            it.generateNestedClass(thisDescriptor, name, result, c);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.jvm.SyntheticJavaPartsProvider
    public PropertyDescriptorImpl modifyField(ClassDescriptor thisDescriptor, PropertyDescriptorImpl propertyDescriptor, LazyJavaResolverContext c) {
        Intrinsics.checkNotNullParameter(thisDescriptor, "thisDescriptor");
        Intrinsics.checkNotNullParameter(propertyDescriptor, "propertyDescriptor");
        Intrinsics.checkNotNullParameter(c, "c");
        Iterable $this$fold$iv = this.inner;
        PropertyDescriptorImpl propertyDescriptorImpl = propertyDescriptor;
        for (Object element$iv : $this$fold$iv) {
            SyntheticJavaPartsProvider provider = (SyntheticJavaPartsProvider) element$iv;
            PropertyDescriptorImpl property = propertyDescriptorImpl;
            propertyDescriptorImpl = provider.modifyField(thisDescriptor, property, c);
        }
        return propertyDescriptorImpl;
    }
}