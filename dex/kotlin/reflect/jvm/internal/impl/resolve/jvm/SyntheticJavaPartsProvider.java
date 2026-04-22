package kotlin.reflect.jvm.internal.impl.resolve.jvm;

import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: SyntheticJavaPartsProvider.kt */
public interface SyntheticJavaPartsProvider {
    public static final Companion Companion = Companion.$$INSTANCE;

    void generateConstructors(ClassDescriptor classDescriptor, List<ClassConstructorDescriptor> list, LazyJavaResolverContext lazyJavaResolverContext);

    void generateMethods(ClassDescriptor classDescriptor, Name name, Collection<SimpleFunctionDescriptor> collection, LazyJavaResolverContext lazyJavaResolverContext);

    void generateNestedClass(ClassDescriptor classDescriptor, Name name, List<ClassDescriptor> list, LazyJavaResolverContext lazyJavaResolverContext);

    void generateStaticFunctions(ClassDescriptor classDescriptor, Name name, Collection<SimpleFunctionDescriptor> collection, LazyJavaResolverContext lazyJavaResolverContext);

    List<Name> getMethodNames(ClassDescriptor classDescriptor, LazyJavaResolverContext lazyJavaResolverContext);

    List<Name> getNestedClassNames(ClassDescriptor classDescriptor, LazyJavaResolverContext lazyJavaResolverContext);

    List<Name> getStaticFunctionNames(ClassDescriptor classDescriptor, LazyJavaResolverContext lazyJavaResolverContext);

    PropertyDescriptorImpl modifyField(ClassDescriptor classDescriptor, PropertyDescriptorImpl propertyDescriptorImpl, LazyJavaResolverContext lazyJavaResolverContext);

    /* compiled from: SyntheticJavaPartsProvider.kt */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final CompositeSyntheticJavaPartsProvider EMPTY = new CompositeSyntheticJavaPartsProvider(CollectionsKt.emptyList());

        private Companion() {
        }

        public final CompositeSyntheticJavaPartsProvider getEMPTY() {
            return EMPTY;
        }
    }
}