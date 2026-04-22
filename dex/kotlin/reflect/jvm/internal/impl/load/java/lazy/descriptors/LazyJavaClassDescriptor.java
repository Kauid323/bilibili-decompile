package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.MappingUtilKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.ScopesHolderForClass;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterUtilsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueClassRepresentation;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorBase;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.FakePureImplementationsProvider;
import kotlin.reflect.jvm.internal.impl.load.java.JavaDescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames;
import kotlin.reflect.jvm.internal.impl.load.java.UtilsKt;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaResolverCache;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.ContextKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotationsKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributesKt;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNamesUtilKt;
import kotlin.reflect.jvm.internal.impl.resolve.constants.StringValue;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.InnerClassesScopeWrapper;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.AbstractClassTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeUsage;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* compiled from: LazyJavaClassDescriptor.kt */
public final class LazyJavaClassDescriptor extends ClassDescriptorBase implements JavaClassDescriptor {
    public static final Companion Companion = new Companion(null);
    private static final Set<String> PUBLIC_METHOD_NAMES_IN_OBJECT = SetsKt.setOf((Object[]) new String[]{"equals", "hashCode", "getClass", "wait", "notify", "notifyAll", "toString"});
    private final ClassDescriptor additionalSupertypeClassDescriptor;
    private final Annotations annotations;
    private final LazyJavaResolverContext c;
    private final NotNullLazyValue<List<TypeParameterDescriptor>> declaredParameters;
    private final InnerClassesScopeWrapper innerClassesScope;
    private final boolean isInner;
    private final JavaClass jClass;
    private final ClassKind kind;
    private final Modality modality;
    private final Lazy moduleAnnotations$delegate;
    private final LazyJavaResolverContext outerContext;
    private final ScopesHolderForClass<LazyJavaClassMemberScope> scopeHolder;
    private final LazyJavaStaticClassScope staticScope;
    private final LazyJavaClassTypeConstructor typeConstructor;
    private final LazyJavaClassMemberScope unsubstitutedMemberScope;
    private final Visibility visibility;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyJavaClassDescriptor(LazyJavaResolverContext outerContext, DeclarationDescriptor containingDeclaration, JavaClass jClass, ClassDescriptor additionalSupertypeClassDescriptor) {
        super(outerContext.getStorageManager(), containingDeclaration, jClass.getName(), outerContext.getComponents().getSourceElementFactory().source(jClass), false);
        ClassKind classKind;
        Modality modality;
        Intrinsics.checkNotNullParameter(outerContext, "outerContext");
        Intrinsics.checkNotNullParameter(containingDeclaration, "containingDeclaration");
        Intrinsics.checkNotNullParameter(jClass, "jClass");
        this.outerContext = outerContext;
        this.jClass = jClass;
        this.additionalSupertypeClassDescriptor = additionalSupertypeClassDescriptor;
        this.c = ContextKt.childForClassOrPackage$default(this.outerContext, this, this.jClass, 0, 4, null);
        this.c.getComponents().getJavaResolverCache().recordClass(this.jClass, this);
        if (!(this.jClass.getLightClassOriginKind() == null)) {
            throw new AssertionError("Creating LazyJavaClassDescriptor for light class " + this.jClass);
        }
        this.moduleAnnotations$delegate = LazyKt.lazy(new Function0(this) { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor$$Lambda$0
            private final LazyJavaClassDescriptor arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                List moduleAnnotations_delegate$lambda$0;
                moduleAnnotations_delegate$lambda$0 = LazyJavaClassDescriptor.moduleAnnotations_delegate$lambda$0(this.arg$0);
                return moduleAnnotations_delegate$lambda$0;
            }
        });
        if (this.jClass.isAnnotationType()) {
            classKind = ClassKind.ANNOTATION_CLASS;
        } else if (this.jClass.isInterface()) {
            classKind = ClassKind.INTERFACE;
        } else {
            classKind = this.jClass.isEnum() ? ClassKind.ENUM_CLASS : ClassKind.CLASS;
        }
        this.kind = classKind;
        if (this.jClass.isAnnotationType() || this.jClass.isEnum()) {
            modality = Modality.FINAL;
        } else {
            modality = Modality.Companion.convertFromFlags(this.jClass.isSealed(), this.jClass.isSealed() || this.jClass.isAbstract() || this.jClass.isInterface(), !this.jClass.isFinal());
        }
        this.modality = modality;
        this.visibility = this.jClass.getVisibility();
        this.isInner = (this.jClass.getOuterClass() == null || this.jClass.isStatic()) ? false : true;
        this.typeConstructor = new LazyJavaClassTypeConstructor();
        this.unsubstitutedMemberScope = new LazyJavaClassMemberScope(this.c, this, this.jClass, this.additionalSupertypeClassDescriptor != null, null, 16, null);
        this.scopeHolder = ScopesHolderForClass.Companion.create(this, this.c.getStorageManager(), this.c.getComponents().getKotlinTypeChecker().getKotlinTypeRefiner(), new Function1(this) { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor$$Lambda$1
            private final LazyJavaClassDescriptor arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                LazyJavaClassMemberScope scopeHolder$lambda$0;
                scopeHolder$lambda$0 = LazyJavaClassDescriptor.scopeHolder$lambda$0(this.arg$0, (KotlinTypeRefiner) obj);
                return scopeHolder$lambda$0;
            }
        });
        this.innerClassesScope = new InnerClassesScopeWrapper(this.unsubstitutedMemberScope);
        this.staticScope = new LazyJavaStaticClassScope(this.c, this.jClass, this);
        this.annotations = LazyJavaAnnotationsKt.resolveAnnotations(this.c, this.jClass);
        this.declaredParameters = this.c.getStorageManager().createLazyValue(new Function0(this) { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor$$Lambda$2
            private final LazyJavaClassDescriptor arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                List declaredParameters$lambda$0;
                declaredParameters$lambda$0 = LazyJavaClassDescriptor.declaredParameters$lambda$0(this.arg$0);
                return declaredParameters$lambda$0;
            }
        });
    }

    public /* synthetic */ LazyJavaClassDescriptor(LazyJavaResolverContext lazyJavaResolverContext, DeclarationDescriptor declarationDescriptor, JavaClass javaClass, ClassDescriptor classDescriptor, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(lazyJavaResolverContext, declarationDescriptor, javaClass, (i & 8) != 0 ? null : classDescriptor);
    }

    public final JavaClass getJClass() {
        return this.jClass;
    }

    /* compiled from: LazyJavaClassDescriptor.kt */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final List<JavaAnnotation> getModuleAnnotations() {
        return (List) this.moduleAnnotations$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List moduleAnnotations_delegate$lambda$0(LazyJavaClassDescriptor this$0) {
        ClassId it = DescriptorUtilsKt.getClassId(this$0);
        if (it != null) {
            return this$0.outerContext.getComponents().getJavaModuleResolver().getAnnotationsForModuleOwnerOfClass(it);
        }
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public ClassKind getKind() {
        return this.kind;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public Modality getModality() {
        return this.modality;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility
    public DescriptorVisibility getVisibility() {
        if (Intrinsics.areEqual(this.visibility, DescriptorVisibilities.PRIVATE) && this.jClass.getOuterClass() == null) {
            DescriptorVisibility descriptorVisibility = JavaDescriptorVisibilities.PACKAGE_VISIBILITY;
            Intrinsics.checkNotNull(descriptorVisibility);
            return descriptorVisibility;
        }
        return UtilsKt.toDescriptorVisibility(this.visibility);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters
    public boolean isInner() {
        return this.isInner;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public boolean isData() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public boolean isInline() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public boolean isCompanionObject() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isExpect() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isActual() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public boolean isFun() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public boolean isValue() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor
    public TypeConstructor getTypeConstructor() {
        return this.typeConstructor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LazyJavaClassMemberScope scopeHolder$lambda$0(LazyJavaClassDescriptor this$0, KotlinTypeRefiner it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return new LazyJavaClassMemberScope(this$0.c, this$0, this$0.jClass, this$0.additionalSupertypeClassDescriptor != null, this$0.unsubstitutedMemberScope);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleAwareClassDescriptor
    public LazyJavaClassMemberScope getUnsubstitutedMemberScope(KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this.scopeHolder.getScope(kotlinTypeRefiner);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public MemberScope getUnsubstitutedInnerClassesScope() {
        return this.innerClassesScope;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public MemberScope getStaticScope() {
        return this.staticScope;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    /* renamed from: getUnsubstitutedPrimaryConstructor */
    public ClassConstructorDescriptor mo1161getUnsubstitutedPrimaryConstructor() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    /* renamed from: getCompanionObjectDescriptor */
    public ClassDescriptor mo1160getCompanionObjectDescriptor() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public LazyJavaClassMemberScope getUnsubstitutedMemberScope() {
        MemberScope unsubstitutedMemberScope = super.getUnsubstitutedMemberScope();
        Intrinsics.checkNotNull(unsubstitutedMemberScope, "null cannot be cast to non-null type org.jetbrains.kotlin.load.java.lazy.descriptors.LazyJavaClassMemberScope");
        return (LazyJavaClassMemberScope) unsubstitutedMemberScope;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public List<ClassConstructorDescriptor> getConstructors() {
        return this.unsubstitutedMemberScope.getConstructors$descriptors_jvm().invoke();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated
    public Annotations getAnnotations() {
        return this.annotations;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List declaredParameters$lambda$0(LazyJavaClassDescriptor this$0) {
        Iterable $this$map$iv = this$0.jClass.getTypeParameters();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            JavaTypeParameter p = (JavaTypeParameter) item$iv$iv;
            TypeParameterDescriptor resolveTypeParameter = this$0.c.getTypeParameterResolver().resolveTypeParameter(p);
            if (resolveTypeParameter == null) {
                throw new AssertionError("Parameter " + p + " surely belongs to class " + this$0.jClass + ", so it must be resolved");
            }
            destination$iv$iv.add(resolveTypeParameter);
        }
        return (List) destination$iv$iv;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters
    public List<TypeParameterDescriptor> getDeclaredTypeParameters() {
        return this.declaredParameters.invoke();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public ValueClassRepresentation<SimpleType> getValueClassRepresentation() {
        return null;
    }

    public String toString() {
        return "Lazy Java class " + DescriptorUtilsKt.getFqNameUnsafe(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LazyJavaClassDescriptor.kt */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public final class LazyJavaClassTypeConstructor extends AbstractClassTypeConstructor {
        private final NotNullLazyValue<List<TypeParameterDescriptor>> parameters;

        public LazyJavaClassTypeConstructor() {
            super(LazyJavaClassDescriptor.this.c.getStorageManager());
            StorageManager storageManager = LazyJavaClassDescriptor.this.c.getStorageManager();
            final LazyJavaClassDescriptor lazyJavaClassDescriptor = LazyJavaClassDescriptor.this;
            this.parameters = storageManager.createLazyValue(new Function0(lazyJavaClassDescriptor) { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor$LazyJavaClassTypeConstructor$$Lambda$0
                private final LazyJavaClassDescriptor arg$0;

                {
                    this.arg$0 = lazyJavaClassDescriptor;
                }

                @Override // kotlin.jvm.functions.Function0
                public Object invoke() {
                    List parameters$lambda$0;
                    parameters$lambda$0 = LazyJavaClassDescriptor.LazyJavaClassTypeConstructor.parameters$lambda$0(this.arg$0);
                    return parameters$lambda$0;
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final List parameters$lambda$0(LazyJavaClassDescriptor this$0) {
            return TypeParameterUtilsKt.computeConstructorTypeParameters(this$0);
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        public List<TypeParameterDescriptor> getParameters() {
            return this.parameters.invoke();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor
        protected Collection<KotlinType> computeSupertypes() {
            Collection javaTypes = LazyJavaClassDescriptor.this.getJClass().getSupertypes();
            ArrayList result = new ArrayList(javaTypes.size());
            ArrayList incomplete = new ArrayList(0);
            KotlinType purelyImplementedSupertype = getPurelyImplementedSupertype();
            Iterator<JavaClassifierType> it = javaTypes.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                JavaClassifierType javaType = it.next();
                KotlinType kotlinType = LazyJavaClassDescriptor.this.c.getTypeResolver().transformJavaType(javaType, JavaTypeAttributesKt.toAttributes$default(TypeUsage.SUPERTYPE, false, false, null, 7, null));
                KotlinType enhancedKotlinType = LazyJavaClassDescriptor.this.c.getComponents().getSignatureEnhancement().enhanceSuperType(kotlinType, LazyJavaClassDescriptor.this.c);
                if (enhancedKotlinType.getConstructor().mo1171getDeclarationDescriptor() instanceof NotFoundClasses.MockClassDescriptor) {
                    incomplete.add(javaType);
                }
                if (!Intrinsics.areEqual(enhancedKotlinType.getConstructor(), purelyImplementedSupertype != null ? purelyImplementedSupertype.getConstructor() : null) && !KotlinBuiltIns.isAnyOrNullableAny(enhancedKotlinType)) {
                    result.add(enhancedKotlinType);
                }
            }
            ArrayList arrayList = result;
            ClassDescriptor it2 = LazyJavaClassDescriptor.this.additionalSupertypeClassDescriptor;
            kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.addIfNotNull(arrayList, it2 != null ? MappingUtilKt.createMappedTypeParametersSubstitution(it2, LazyJavaClassDescriptor.this).buildSubstitutor().substitute(it2.getDefaultType(), Variance.INVARIANT) : null);
            kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.addIfNotNull(result, purelyImplementedSupertype);
            if (!incomplete.isEmpty()) {
                ErrorReporter errorReporter = LazyJavaClassDescriptor.this.c.getComponents().getErrorReporter();
                ClassDescriptor mo1171getDeclarationDescriptor = mo1171getDeclarationDescriptor();
                ArrayList $this$map$iv = incomplete;
                Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                for (Object item$iv$iv : $this$map$iv) {
                    JavaType javaType2 = (JavaType) item$iv$iv;
                    Intrinsics.checkNotNull(javaType2, "null cannot be cast to non-null type org.jetbrains.kotlin.load.java.structure.JavaClassifierType");
                    destination$iv$iv.add(((JavaClassifierType) javaType2).getPresentableText());
                    javaTypes = javaTypes;
                }
                errorReporter.reportIncompleteHierarchy(mo1171getDeclarationDescriptor, (List) destination$iv$iv);
            }
            return !result.isEmpty() ? CollectionsKt.toList(result) : CollectionsKt.listOf(LazyJavaClassDescriptor.this.c.getModule().getBuiltIns().getAnyType());
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x001d, code lost:
            if ((!r1.isRoot() && r1.startsWith(kotlin.reflect.jvm.internal.impl.builtins.StandardNames.BUILT_INS_PACKAGE_NAME)) != false) goto L9;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final KotlinType getPurelyImplementedSupertype() {
            FqName purelyImplementedFqName;
            List parametersAsTypeProjections;
            FqName annotatedPurelyImplementedFqName = getPurelyImplementsFqNameFromAnnotation();
            if (annotatedPurelyImplementedFqName != null) {
            }
            annotatedPurelyImplementedFqName = null;
            if (annotatedPurelyImplementedFqName == null) {
                purelyImplementedFqName = FakePureImplementationsProvider.INSTANCE.getPurelyImplementedInterface(DescriptorUtilsKt.getFqNameSafe(LazyJavaClassDescriptor.this));
                if (purelyImplementedFqName == null) {
                    return null;
                }
            } else {
                purelyImplementedFqName = annotatedPurelyImplementedFqName;
            }
            ClassDescriptor classDescriptor = DescriptorUtilsKt.resolveTopLevelClass(LazyJavaClassDescriptor.this.c.getModule(), purelyImplementedFqName, NoLookupLocation.FROM_JAVA_LOADER);
            if (classDescriptor == null) {
                return null;
            }
            int supertypeParameterCount = classDescriptor.getTypeConstructor().getParameters().size();
            List typeParameters = LazyJavaClassDescriptor.this.getTypeConstructor().getParameters();
            Intrinsics.checkNotNullExpressionValue(typeParameters, "getParameters(...)");
            int typeParameterCount = typeParameters.size();
            if (typeParameterCount == supertypeParameterCount) {
                List $this$map$iv = typeParameters;
                boolean z = false;
                Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                for (Object item$iv$iv : $this$map$iv) {
                    TypeParameterDescriptor parameter = (TypeParameterDescriptor) item$iv$iv;
                    destination$iv$iv.add(new TypeProjectionImpl(Variance.INVARIANT, parameter.getDefaultType()));
                    $this$map$iv = $this$map$iv;
                    z = z;
                }
                parametersAsTypeProjections = (List) destination$iv$iv;
            } else if (typeParameterCount != 1 || supertypeParameterCount <= 1 || annotatedPurelyImplementedFqName != null) {
                return null;
            } else {
                TypeProjectionImpl parameter2 = new TypeProjectionImpl(Variance.INVARIANT, ((TypeParameterDescriptor) CollectionsKt.single((List<? extends Object>) typeParameters)).getDefaultType());
                Iterable $this$map$iv2 = new IntRange(1, supertypeParameterCount);
                Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
                Iterator<Integer> it = $this$map$iv2.iterator();
                while (it.hasNext()) {
                    ((IntIterator) it).nextInt();
                    destination$iv$iv2.add(parameter2);
                }
                parametersAsTypeProjections = (List) destination$iv$iv2;
            }
            return KotlinTypeFactory.simpleNotNullType(TypeAttributes.Companion.getEmpty(), classDescriptor, parametersAsTypeProjections);
        }

        private final FqName getPurelyImplementsFqNameFromAnnotation() {
            String fqNameString;
            Annotations annotations = LazyJavaClassDescriptor.this.getAnnotations();
            FqName PURELY_IMPLEMENTS_ANNOTATION = JvmAnnotationNames.PURELY_IMPLEMENTS_ANNOTATION;
            Intrinsics.checkNotNullExpressionValue(PURELY_IMPLEMENTS_ANNOTATION, "PURELY_IMPLEMENTS_ANNOTATION");
            AnnotationDescriptor annotation = annotations.mo1162findAnnotation(PURELY_IMPLEMENTS_ANNOTATION);
            if (annotation == null) {
                return null;
            }
            Object singleOrNull = CollectionsKt.singleOrNull(annotation.getAllValueArguments().values());
            StringValue stringValue = singleOrNull instanceof StringValue ? (StringValue) singleOrNull : null;
            if (stringValue == null || (fqNameString = stringValue.getValue()) == null || !FqNamesUtilKt.isValidJavaFqName(fqNameString)) {
                return null;
            }
            return new FqName(fqNameString);
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor
        protected SupertypeLoopChecker getSupertypeLoopChecker() {
            return LazyJavaClassDescriptor.this.c.getComponents().getSupertypeLoopChecker();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        public boolean isDenotable() {
            return true;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.AbstractClassTypeConstructor, kotlin.reflect.jvm.internal.impl.types.ClassifierBasedTypeConstructor, kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        /* renamed from: getDeclarationDescriptor */
        public ClassDescriptor mo1171getDeclarationDescriptor() {
            return LazyJavaClassDescriptor.this;
        }

        public String toString() {
            String asString = LazyJavaClassDescriptor.this.getName().asString();
            Intrinsics.checkNotNullExpressionValue(asString, "asString(...)");
            return asString;
        }
    }

    public final LazyJavaClassDescriptor copy$descriptors_jvm(JavaResolverCache javaResolverCache, ClassDescriptor additionalSupertypeClassDescriptor) {
        Intrinsics.checkNotNullParameter(javaResolverCache, "javaResolverCache");
        LazyJavaResolverContext replaceComponents = ContextKt.replaceComponents(this.c, this.c.getComponents().replace(javaResolverCache));
        DeclarationDescriptor containingDeclaration = getContainingDeclaration();
        Intrinsics.checkNotNullExpressionValue(containingDeclaration, "getContainingDeclaration(...)");
        return new LazyJavaClassDescriptor(replaceComponents, containingDeclaration, this.jClass, additionalSupertypeClassDescriptor);
    }
}