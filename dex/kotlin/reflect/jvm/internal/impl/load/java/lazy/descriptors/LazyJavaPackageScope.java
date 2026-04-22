package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.JavaClassFinder;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageScope;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage;
import kotlin.reflect.jvm.internal.impl.load.java.structure.LightClassOriginKind;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinderKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.MetadataVersion;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.name.SpecialNames;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue;
import kotlin.reflect.jvm.internal.impl.utils.FunctionsKt;

/* compiled from: LazyJavaPackageScope.kt */
public final class LazyJavaPackageScope extends LazyJavaStaticScope {
    private final MemoizedFunctionToNullable<FindClassRequest, ClassDescriptor> classes;
    private final JavaPackage jPackage;
    private final NullableLazyValue<Set<String>> knownClassNamesInPackage;
    private final LazyJavaPackageFragment ownerDescriptor;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyJavaPackageScope(final LazyJavaResolverContext c, JavaPackage jPackage, LazyJavaPackageFragment ownerDescriptor) {
        super(c);
        Intrinsics.checkNotNullParameter(c, "c");
        Intrinsics.checkNotNullParameter(jPackage, "jPackage");
        Intrinsics.checkNotNullParameter(ownerDescriptor, "ownerDescriptor");
        this.jPackage = jPackage;
        this.ownerDescriptor = ownerDescriptor;
        this.knownClassNamesInPackage = c.getStorageManager().createNullableLazyValue(new Function0(c, this) { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageScope$$Lambda$0
            private final LazyJavaResolverContext arg$0;
            private final LazyJavaPackageScope arg$1;

            {
                this.arg$0 = c;
                this.arg$1 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                Set knownClassNamesInPackage$lambda$0;
                knownClassNamesInPackage$lambda$0 = LazyJavaPackageScope.knownClassNamesInPackage$lambda$0(this.arg$0, this.arg$1);
                return knownClassNamesInPackage$lambda$0;
            }
        });
        this.classes = c.getStorageManager().createMemoizedFunctionWithNullableValues(new Function1(this, c) { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageScope$$Lambda$1
            private final LazyJavaPackageScope arg$0;
            private final LazyJavaResolverContext arg$1;

            {
                this.arg$0 = this;
                this.arg$1 = c;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                ClassDescriptor classes$lambda$0;
                classes$lambda$0 = LazyJavaPackageScope.classes$lambda$0(this.arg$0, this.arg$1, (LazyJavaPackageScope.FindClassRequest) obj);
                return classes$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public LazyJavaPackageFragment getOwnerDescriptor() {
        return this.ownerDescriptor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Set knownClassNamesInPackage$lambda$0(LazyJavaResolverContext $c, LazyJavaPackageScope this$0) {
        return $c.getComponents().getFinder().knownClassNamesInPackage(this$0.getOwnerDescriptor().getFqName());
    }

    private final MetadataVersion getMetadataVersion() {
        return getC().getComponents().getDeserializedDescriptorResolver().getComponents().getConfiguration().getMetadataVersion();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ClassDescriptor classes$lambda$0(LazyJavaPackageScope this$0, LazyJavaResolverContext $c, FindClassRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        ClassId requestClassId = new ClassId(this$0.getOwnerDescriptor().getFqName(), request.getName());
        KotlinClassFinder.Result kotlinClassOrClassFileContent = request.getJavaClass() != null ? $c.getComponents().getKotlinClassFinder().findKotlinClassOrContent(request.getJavaClass(), this$0.getMetadataVersion()) : $c.getComponents().getKotlinClassFinder().findKotlinClassOrContent(requestClassId, this$0.getMetadataVersion());
        JavaClassDescriptor javaClassDescriptor = null;
        KotlinJvmBinaryClass kotlinBinaryClass = kotlinClassOrClassFileContent != null ? kotlinClassOrClassFileContent.toKotlinJvmBinaryClass() : null;
        ClassId classId = kotlinBinaryClass != null ? kotlinBinaryClass.getClassId() : null;
        if (classId == null || !(classId.isNestedClass() || classId.isLocal())) {
            KotlinClassLookupResult kotlinResult = this$0.resolveKotlinBinaryClass(kotlinBinaryClass);
            if (kotlinResult instanceof KotlinClassLookupResult.Found) {
                return ((KotlinClassLookupResult.Found) kotlinResult).getDescriptor();
            }
            if (kotlinResult instanceof KotlinClassLookupResult.SyntheticClass) {
                return null;
            }
            if (kotlinResult instanceof KotlinClassLookupResult.NotFound) {
                JavaClass javaClass = request.getJavaClass();
                if (javaClass == null) {
                    JavaClassFinder finder = $c.getComponents().getFinder();
                    KotlinClassFinder.Result.ClassFileContent classFileContent = kotlinClassOrClassFileContent instanceof KotlinClassFinder.Result.ClassFileContent ? (KotlinClassFinder.Result.ClassFileContent) kotlinClassOrClassFileContent : null;
                    javaClass = finder.findClass(new JavaClassFinder.Request(requestClassId, classFileContent != null ? classFileContent.getContent() : null, null, 4, null));
                }
                if ((javaClass != null ? javaClass.getLightClassOriginKind() : null) != LightClassOriginKind.BINARY) {
                    FqName actualFqName = javaClass != null ? javaClass.getFqName() : null;
                    if (actualFqName != null && !actualFqName.isRoot() && Intrinsics.areEqual(actualFqName.parent(), this$0.getOwnerDescriptor().getFqName())) {
                        javaClassDescriptor = new LazyJavaClassDescriptor($c, this$0.getOwnerDescriptor(), javaClass, null, 8, null);
                        JavaClassDescriptor p0 = javaClassDescriptor;
                        $c.getComponents().getJavaClassesTracker().reportClass(p0);
                    }
                    return javaClassDescriptor;
                }
                throw new IllegalStateException("Couldn't find kotlin binary class for light class created by kotlin binary file\nJavaClass: " + javaClass + "\nClassId: " + requestClassId + "\nfindKotlinClass(JavaClass) = " + KotlinClassFinderKt.findKotlinClass($c.getComponents().getKotlinClassFinder(), javaClass, this$0.getMetadataVersion()) + "\nfindKotlinClass(ClassId) = " + KotlinClassFinderKt.findKotlinClass($c.getComponents().getKotlinClassFinder(), requestClassId, this$0.getMetadataVersion()) + '\n');
            }
            throw new NoWhenBranchMatchedException();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LazyJavaPackageScope.kt */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static abstract class KotlinClassLookupResult {
        public /* synthetic */ KotlinClassLookupResult(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* compiled from: LazyJavaPackageScope.kt */
        /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
        public static final class Found extends KotlinClassLookupResult {
            private final ClassDescriptor descriptor;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Found(ClassDescriptor descriptor) {
                super(null);
                Intrinsics.checkNotNullParameter(descriptor, "descriptor");
                this.descriptor = descriptor;
            }

            public final ClassDescriptor getDescriptor() {
                return this.descriptor;
            }
        }

        private KotlinClassLookupResult() {
        }

        /* compiled from: LazyJavaPackageScope.kt */
        /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
        public static final class NotFound extends KotlinClassLookupResult {
            public static final NotFound INSTANCE = new NotFound();

            private NotFound() {
                super(null);
            }
        }

        /* compiled from: LazyJavaPackageScope.kt */
        /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
        public static final class SyntheticClass extends KotlinClassLookupResult {
            public static final SyntheticClass INSTANCE = new SyntheticClass();

            private SyntheticClass() {
                super(null);
            }
        }
    }

    private final KotlinClassLookupResult resolveKotlinBinaryClass(KotlinJvmBinaryClass kotlinClass) {
        if (kotlinClass == null) {
            return KotlinClassLookupResult.NotFound.INSTANCE;
        }
        if (kotlinClass.getClassHeader().getKind() == KotlinClassHeader.Kind.CLASS) {
            ClassDescriptor descriptor = getC().getComponents().getDeserializedDescriptorResolver().resolveClass(kotlinClass);
            return descriptor != null ? new KotlinClassLookupResult.Found(descriptor) : KotlinClassLookupResult.NotFound.INSTANCE;
        }
        return KotlinClassLookupResult.SyntheticClass.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LazyJavaPackageScope.kt */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class FindClassRequest {
        private final JavaClass javaClass;
        private final Name name;

        public FindClassRequest(Name name, JavaClass javaClass) {
            Intrinsics.checkNotNullParameter(name, "name");
            this.name = name;
            this.javaClass = javaClass;
        }

        public final JavaClass getJavaClass() {
            return this.javaClass;
        }

        public final Name getName() {
            return this.name;
        }

        public boolean equals(Object other) {
            return (other instanceof FindClassRequest) && Intrinsics.areEqual(this.name, ((FindClassRequest) other).name);
        }

        public int hashCode() {
            return this.name.hashCode();
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    /* renamed from: getContributedClassifier */
    public ClassDescriptor mo1173getContributedClassifier(Name name, LookupLocation location2) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(location2, "location");
        return findClassifier(name, null);
    }

    private final ClassDescriptor findClassifier(Name name, JavaClass javaClass) {
        if (SpecialNames.INSTANCE.isSafeIdentifier(name)) {
            Set knownClassNamesInPackage = this.knownClassNamesInPackage.invoke();
            if (javaClass != null || knownClassNamesInPackage == null || knownClassNamesInPackage.contains(name.asString())) {
                return this.classes.invoke(new FindClassRequest(name, javaClass));
            }
            return null;
        }
        return null;
    }

    public final ClassDescriptor findClassifierByJavaClass$descriptors_jvm(JavaClass javaClass) {
        Intrinsics.checkNotNullParameter(javaClass, "javaClass");
        return findClassifier(javaClass.getName(), javaClass);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Collection<PropertyDescriptor> getContributedVariables(Name name, LookupLocation location2) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(location2, "location");
        return CollectionsKt.emptyList();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public DeclaredMemberIndex computeMemberIndex() {
        return DeclaredMemberIndex.Empty.INSTANCE;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    protected Set<Name> computeClassNames(DescriptorKindFilter kindFilter, Function1<? super Name, Boolean> function1) {
        Intrinsics.checkNotNullParameter(kindFilter, "kindFilter");
        if (kindFilter.acceptsKinds(DescriptorKindFilter.Companion.getNON_SINGLETON_CLASSIFIERS_MASK())) {
            Iterable knownClassNamesInPackage = (Set) this.knownClassNamesInPackage.invoke();
            if (knownClassNamesInPackage != null) {
                Iterable $this$mapTo$iv = knownClassNamesInPackage;
                Collection destination$iv = new HashSet();
                for (Object item$iv : $this$mapTo$iv) {
                    String it = (String) item$iv;
                    destination$iv.add(Name.identifier(it));
                }
                return (Set) destination$iv;
            }
            Iterable $this$mapNotNullTo$iv = this.jPackage.getClasses(function1 == null ? FunctionsKt.alwaysTrue() : function1);
            Collection destination$iv2 = new LinkedHashSet();
            for (Object element$iv$iv : $this$mapNotNullTo$iv) {
                JavaClass klass = (JavaClass) element$iv$iv;
                Name name = klass.getLightClassOriginKind() == LightClassOriginKind.SOURCE ? null : klass.getName();
                if (name != null) {
                    destination$iv2.add(name);
                }
            }
            return (Set) destination$iv2;
        }
        return SetsKt.emptySet();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    protected Set<Name> computeFunctionNames(DescriptorKindFilter kindFilter, Function1<? super Name, Boolean> function1) {
        Intrinsics.checkNotNullParameter(kindFilter, "kindFilter");
        return SetsKt.emptySet();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    protected void computeNonDeclaredFunctions(Collection<SimpleFunctionDescriptor> result, Name name) {
        Intrinsics.checkNotNullParameter(result, "result");
        Intrinsics.checkNotNullParameter(name, "name");
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    protected Set<Name> computePropertyNames(DescriptorKindFilter kindFilter, Function1<? super Name, Boolean> function1) {
        Intrinsics.checkNotNullParameter(kindFilter, "kindFilter");
        return SetsKt.emptySet();
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x006c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x003d A[SYNTHETIC] */
    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Collection<DeclarationDescriptor> getContributedDescriptors(DescriptorKindFilter kindFilter, Function1<? super Name, Boolean> nameFilter) {
        boolean z;
        Intrinsics.checkNotNullParameter(kindFilter, "kindFilter");
        Intrinsics.checkNotNullParameter(nameFilter, "nameFilter");
        if (!kindFilter.acceptsKinds(DescriptorKindFilter.Companion.getCLASSIFIERS_MASK() | DescriptorKindFilter.Companion.getNON_SINGLETON_CLASSIFIERS_MASK())) {
            return CollectionsKt.emptyList();
        }
        Iterable $this$filter$iv = getAllDescriptors().invoke();
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            DeclarationDescriptor it = (DeclarationDescriptor) element$iv$iv;
            if (it instanceof ClassDescriptor) {
                Name name = ((ClassDescriptor) it).getName();
                Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                if (nameFilter.invoke(name).booleanValue()) {
                    z = true;
                    if (!z) {
                        destination$iv$iv.add(element$iv$iv);
                    }
                }
            }
            z = false;
            if (!z) {
            }
        }
        return (List) destination$iv$iv;
    }
}