package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorUtilKt;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ModalityUtilsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationUtilKt;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilterKt;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PackageFragmentDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaResolverCache;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureBuildingUtilsKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolverUtilKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor;
import kotlin.reflect.jvm.internal.impl.storage.CacheWithNotNullValues;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.LazyWrappedType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.utils.DFS;
import kotlin.reflect.jvm.internal.impl.utils.SmartSet;

/* compiled from: JvmBuiltInsCustomizer.kt */
public final class JvmBuiltInsCustomizer implements AdditionalClassPartsProvider, PlatformDependentDeclarationFilter {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(JvmBuiltInsCustomizer.class, "settings", "getSettings()Lorg/jetbrains/kotlin/builtins/jvm/JvmBuiltIns$Settings;", 0)), Reflection.property1(new PropertyReference1Impl(JvmBuiltInsCustomizer.class, "cloneableType", "getCloneableType()Lorg/jetbrains/kotlin/types/SimpleType;", 0)), Reflection.property1(new PropertyReference1Impl(JvmBuiltInsCustomizer.class, "notConsideredDeprecation", "getNotConsideredDeprecation()Lorg/jetbrains/kotlin/descriptors/annotations/Annotations;", 0))};
    private final NotNullLazyValue cloneableType$delegate;
    private final MemoizedFunctionToNotNull<Pair<String, String>, Annotations> deprecationForSomeOfTheListMethods;
    private final JavaToKotlinClassMapper j2kClassMapper;
    private final CacheWithNotNullValues<FqName, ClassDescriptor> javaAnalogueClassesWithCustomSupertypeCache;
    private final KotlinType mockSerializableType;
    private final ModuleDescriptor moduleDescriptor;
    private final NotNullLazyValue notConsideredDeprecation$delegate;
    private final NotNullLazyValue settings$delegate;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: JvmBuiltInsCustomizer.kt */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public enum JDKMemberStatus {
        HIDDEN,
        VISIBLE,
        DEPRECATED_LIST_METHODS,
        NOT_CONSIDERED,
        DROP;
        
        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);
    }

    /* compiled from: JvmBuiltInsCustomizer.kt */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[JDKMemberStatus.values().length];
            try {
                iArr[JDKMemberStatus.HIDDEN.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[JDKMemberStatus.DEPRECATED_LIST_METHODS.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[JDKMemberStatus.NOT_CONSIDERED.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[JDKMemberStatus.DROP.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[JDKMemberStatus.VISIBLE.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public JvmBuiltInsCustomizer(ModuleDescriptor moduleDescriptor, final StorageManager storageManager, Function0<JvmBuiltIns.Settings> settingsComputation) {
        Intrinsics.checkNotNullParameter(moduleDescriptor, "moduleDescriptor");
        Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics.checkNotNullParameter(settingsComputation, "settingsComputation");
        this.moduleDescriptor = moduleDescriptor;
        this.j2kClassMapper = JavaToKotlinClassMapper.INSTANCE;
        this.settings$delegate = storageManager.createLazyValue(settingsComputation);
        this.mockSerializableType = createMockJavaIoSerializableType(storageManager);
        this.cloneableType$delegate = storageManager.createLazyValue(new Function0(this, storageManager) { // from class: kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer$$Lambda$0
            private final JvmBuiltInsCustomizer arg$0;
            private final StorageManager arg$1;

            {
                this.arg$0 = this;
                this.arg$1 = storageManager;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                SimpleType cloneableType_delegate$lambda$0;
                cloneableType_delegate$lambda$0 = JvmBuiltInsCustomizer.cloneableType_delegate$lambda$0(this.arg$0, this.arg$1);
                return cloneableType_delegate$lambda$0;
            }
        });
        this.javaAnalogueClassesWithCustomSupertypeCache = storageManager.createCacheWithNotNullValues();
        this.notConsideredDeprecation$delegate = storageManager.createLazyValue(new Function0(this) { // from class: kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer$$Lambda$1
            private final JvmBuiltInsCustomizer arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                Annotations notConsideredDeprecation_delegate$lambda$0;
                notConsideredDeprecation_delegate$lambda$0 = JvmBuiltInsCustomizer.notConsideredDeprecation_delegate$lambda$0(this.arg$0);
                return notConsideredDeprecation_delegate$lambda$0;
            }
        });
        this.deprecationForSomeOfTheListMethods = storageManager.createMemoizedFunction(new Function1(this) { // from class: kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer$$Lambda$2
            private final JvmBuiltInsCustomizer arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                Annotations deprecationForSomeOfTheListMethods$lambda$0;
                deprecationForSomeOfTheListMethods$lambda$0 = JvmBuiltInsCustomizer.deprecationForSomeOfTheListMethods$lambda$0(this.arg$0, (Pair) obj);
                return deprecationForSomeOfTheListMethods$lambda$0;
            }
        });
    }

    private final JvmBuiltIns.Settings getSettings() {
        return (JvmBuiltIns.Settings) StorageKt.getValue(this.settings$delegate, this, $$delegatedProperties[0]);
    }

    private final SimpleType getCloneableType() {
        return (SimpleType) StorageKt.getValue(this.cloneableType$delegate, this, $$delegatedProperties[1]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SimpleType cloneableType_delegate$lambda$0(JvmBuiltInsCustomizer this$0, StorageManager $storageManager) {
        return FindClassInModuleKt.findNonGenericClassAcrossDependencies(this$0.getSettings().getOwnerModuleDescriptor(), JvmBuiltInClassDescriptorFactory.Companion.getCLONEABLE_CLASS_ID(), new NotFoundClasses($storageManager, this$0.getSettings().getOwnerModuleDescriptor())).getDefaultType();
    }

    private final Annotations getNotConsideredDeprecation() {
        return (Annotations) StorageKt.getValue(this.notConsideredDeprecation$delegate, this, $$delegatedProperties[2]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Annotations notConsideredDeprecation_delegate$lambda$0(JvmBuiltInsCustomizer this$0) {
        AnnotationDescriptor annotation = AnnotationUtilKt.createDeprecatedAnnotation$default(this$0.moduleDescriptor.getBuiltIns(), "This member is not fully supported by Kotlin compiler, so it may be absent or have different signature in next major version", null, null, true, 6, null);
        return Annotations.Companion.create(CollectionsKt.listOf(annotation));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Annotations deprecationForSomeOfTheListMethods$lambda$0(JvmBuiltInsCustomizer this$0, Pair pair) {
        Intrinsics.checkNotNullParameter(pair, "<destruct>");
        String methodName = (String) pair.component1();
        String extensionName = (String) pair.component2();
        AnnotationDescriptor annotation = AnnotationUtilKt.createDeprecatedAnnotation(this$0.moduleDescriptor.getBuiltIns(), '\'' + methodName + "()' member of List is redundant in Kotlin and might be removed soon. Please use '" + extensionName + "()' stdlib extension instead", extensionName + "()", "HIDDEN", false);
        return Annotations.Companion.create(CollectionsKt.listOf(annotation));
    }

    private final KotlinType createMockJavaIoSerializableType(StorageManager $this$createMockJavaIoSerializableType) {
        final ModuleDescriptor moduleDescriptor = this.moduleDescriptor;
        final FqName fqName = new FqName("java.io");
        PackageFragmentDescriptorImpl packageFragmentDescriptorImpl = new PackageFragmentDescriptorImpl(moduleDescriptor, fqName) { // from class: kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer$createMockJavaIoSerializableType$mockJavaIoPackageFragment$1
            @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor
            public MemberScope.Empty getMemberScope() {
                return MemberScope.Empty.INSTANCE;
            }
        };
        List superTypes = CollectionsKt.listOf(new LazyWrappedType($this$createMockJavaIoSerializableType, new Function0(this) { // from class: kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer$$Lambda$3
            private final JvmBuiltInsCustomizer arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                KotlinType createMockJavaIoSerializableType$lambda$0;
                createMockJavaIoSerializableType$lambda$0 = JvmBuiltInsCustomizer.createMockJavaIoSerializableType$lambda$0(this.arg$0);
                return createMockJavaIoSerializableType$lambda$0;
            }
        }));
        ClassDescriptorImpl mockSerializableClass = new ClassDescriptorImpl(packageFragmentDescriptorImpl, Name.identifier("Serializable"), Modality.ABSTRACT, ClassKind.INTERFACE, superTypes, SourceElement.NO_SOURCE, false, $this$createMockJavaIoSerializableType);
        mockSerializableClass.initialize(MemberScope.Empty.INSTANCE, SetsKt.emptySet(), null);
        SimpleType defaultType = mockSerializableClass.getDefaultType();
        Intrinsics.checkNotNullExpressionValue(defaultType, "getDefaultType(...)");
        return defaultType;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KotlinType createMockJavaIoSerializableType$lambda$0(JvmBuiltInsCustomizer this$0) {
        SimpleType anyType = this$0.moduleDescriptor.getBuiltIns().getAnyType();
        Intrinsics.checkNotNullExpressionValue(anyType, "getAnyType(...)");
        return anyType;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider
    public Collection<KotlinType> getSupertypes(ClassDescriptor classDescriptor) {
        Intrinsics.checkNotNullParameter(classDescriptor, "classDescriptor");
        FqNameUnsafe fqName = DescriptorUtilsKt.getFqNameUnsafe(classDescriptor);
        return JvmBuiltInsSignatures.INSTANCE.isArrayOrPrimitiveArray(fqName) ? CollectionsKt.listOf((Object[]) new KotlinType[]{getCloneableType(), this.mockSerializableType}) : JvmBuiltInsSignatures.INSTANCE.isSerializableInJava(fqName) ? CollectionsKt.listOf(this.mockSerializableType) : CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider
    public Collection<SimpleFunctionDescriptor> getFunctions(final Name name, ClassDescriptor classDescriptor) {
        int $i$f$mapNotNull;
        Iterable $this$mapNotNullTo$iv$iv;
        Annotations invoke;
        ClassDescriptor classDescriptor2 = classDescriptor;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(classDescriptor2, "classDescriptor");
        if (Intrinsics.areEqual(name, CloneableClassScope.Companion.getCLONE_NAME()) && (classDescriptor2 instanceof DeserializedClassDescriptor) && KotlinBuiltIns.isArrayOrPrimitiveArray(classDescriptor)) {
            Iterable functionList = ((DeserializedClassDescriptor) classDescriptor2).getClassProto().getFunctionList();
            Intrinsics.checkNotNullExpressionValue(functionList, "getFunctionList(...)");
            Iterable $this$any$iv = functionList;
            boolean z = false;
            if (!($this$any$iv instanceof Collection) || !((Collection) $this$any$iv).isEmpty()) {
                Iterator<T> it = $this$any$iv.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Object element$iv = it.next();
                    ProtoBuf.Function functionProto = (ProtoBuf.Function) element$iv;
                    if (Intrinsics.areEqual(NameResolverUtilKt.getName(((DeserializedClassDescriptor) classDescriptor2).getC().getNameResolver(), functionProto.getName()), CloneableClassScope.Companion.getCLONE_NAME())) {
                        z = true;
                        break;
                    }
                }
            }
            return z ? CollectionsKt.emptyList() : CollectionsKt.listOf(createCloneForArray((DeserializedClassDescriptor) classDescriptor2, (SimpleFunctionDescriptor) CollectionsKt.single(getCloneableType().getMemberScope().getContributedFunctions(name, NoLookupLocation.FROM_BUILTINS))));
        } else if (getSettings().isAdditionalBuiltInsFeatureSupported()) {
            Iterable $this$mapNotNull$iv = getAdditionalFunctions(classDescriptor2, new Function1(name) { // from class: kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer$$Lambda$4
                private final Name arg$0;

                {
                    this.arg$0 = name;
                }

                @Override // kotlin.jvm.functions.Function1
                public Object invoke(Object obj) {
                    Collection functions$lambda$1;
                    functions$lambda$1 = JvmBuiltInsCustomizer.getFunctions$lambda$1(this.arg$0, (MemberScope) obj);
                    return functions$lambda$1;
                }
            });
            int $i$f$mapNotNull2 = 0;
            Collection destination$iv$iv = new ArrayList();
            Iterable $this$mapNotNullTo$iv$iv2 = $this$mapNotNull$iv;
            for (Object element$iv$iv$iv : $this$mapNotNullTo$iv$iv2) {
                SimpleFunctionDescriptor additionalMember = (SimpleFunctionDescriptor) element$iv$iv$iv;
                DeclarationDescriptor containingDeclaration = additionalMember.getContainingDeclaration();
                Iterable $this$mapNotNull$iv2 = $this$mapNotNull$iv;
                Intrinsics.checkNotNull(containingDeclaration, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                FunctionDescriptor substitute = additionalMember.substitute(MappingUtilKt.createMappedTypeParametersSubstitution((ClassDescriptor) containingDeclaration, classDescriptor2).buildSubstitutor());
                Intrinsics.checkNotNull(substitute, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.SimpleFunctionDescriptor");
                SimpleFunctionDescriptor substitutedWithKotlinTypeParameters = (SimpleFunctionDescriptor) substitute;
                FunctionDescriptor.CopyBuilder $this$getFunctions_u24lambda_u242_u240 = substitutedWithKotlinTypeParameters.newCopyBuilder();
                $this$getFunctions_u24lambda_u242_u240.setOwner(classDescriptor2);
                $this$getFunctions_u24lambda_u242_u240.setDispatchReceiverParameter(classDescriptor.getThisAsReceiverParameter());
                $this$getFunctions_u24lambda_u242_u240.setPreserveSourceElement();
                JDKMemberStatus memberStatus = getJdkMethodStatus(additionalMember);
                SimpleFunctionDescriptor simpleFunctionDescriptor = null;
                switch (WhenMappings.$EnumSwitchMapping$0[memberStatus.ordinal()]) {
                    case 1:
                        $i$f$mapNotNull = $i$f$mapNotNull2;
                        $this$mapNotNullTo$iv$iv = $this$mapNotNullTo$iv$iv2;
                        if (!ModalityUtilsKt.isFinalClass(classDescriptor)) {
                            $this$getFunctions_u24lambda_u242_u240.setHiddenForResolutionEverywhereBesideSupercalls();
                            SimpleFunctionDescriptor build = $this$getFunctions_u24lambda_u242_u240.build();
                            Intrinsics.checkNotNull(build);
                            simpleFunctionDescriptor = build;
                            break;
                        }
                        break;
                    case 2:
                        Name name2 = additionalMember.getName();
                        $i$f$mapNotNull = $i$f$mapNotNull2;
                        if (Intrinsics.areEqual(name2, JvmBuiltInsCustomizerKt.access$getGET_FIRST_LIST_NAME$p())) {
                            $this$mapNotNullTo$iv$iv = $this$mapNotNullTo$iv$iv2;
                            invoke = this.deprecationForSomeOfTheListMethods.invoke(TuplesKt.to(additionalMember.getName().asString(), "first"));
                        } else {
                            $this$mapNotNullTo$iv$iv = $this$mapNotNullTo$iv$iv2;
                            if (!Intrinsics.areEqual(name2, JvmBuiltInsCustomizerKt.access$getGET_LAST_LIST_NAME$p())) {
                                throw new IllegalStateException(("Unexpected name: " + additionalMember.getName()).toString());
                            }
                            invoke = this.deprecationForSomeOfTheListMethods.invoke(TuplesKt.to(additionalMember.getName().asString(), "last"));
                        }
                        $this$getFunctions_u24lambda_u242_u240.setAdditionalAnnotations(invoke);
                        SimpleFunctionDescriptor build2 = $this$getFunctions_u24lambda_u242_u240.build();
                        Intrinsics.checkNotNull(build2);
                        simpleFunctionDescriptor = build2;
                        break;
                    case 3:
                        $this$getFunctions_u24lambda_u242_u240.setAdditionalAnnotations(getNotConsideredDeprecation());
                        $i$f$mapNotNull = $i$f$mapNotNull2;
                        $this$mapNotNullTo$iv$iv = $this$mapNotNullTo$iv$iv2;
                        SimpleFunctionDescriptor build22 = $this$getFunctions_u24lambda_u242_u240.build();
                        Intrinsics.checkNotNull(build22);
                        simpleFunctionDescriptor = build22;
                        break;
                    case 4:
                        $i$f$mapNotNull = $i$f$mapNotNull2;
                        $this$mapNotNullTo$iv$iv = $this$mapNotNullTo$iv$iv2;
                        break;
                    case 5:
                        Unit unit = Unit.INSTANCE;
                        $i$f$mapNotNull = $i$f$mapNotNull2;
                        $this$mapNotNullTo$iv$iv = $this$mapNotNullTo$iv$iv2;
                        SimpleFunctionDescriptor build222 = $this$getFunctions_u24lambda_u242_u240.build();
                        Intrinsics.checkNotNull(build222);
                        simpleFunctionDescriptor = build222;
                        break;
                    default:
                        throw new NoWhenBranchMatchedException();
                }
                if (simpleFunctionDescriptor != null) {
                    destination$iv$iv.add(simpleFunctionDescriptor);
                }
                classDescriptor2 = classDescriptor;
                $this$mapNotNull$iv = $this$mapNotNull$iv2;
                $i$f$mapNotNull2 = $i$f$mapNotNull;
                $this$mapNotNullTo$iv$iv2 = $this$mapNotNullTo$iv$iv;
            }
            return (List) destination$iv$iv;
        } else {
            return CollectionsKt.emptyList();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Collection getFunctions$lambda$1(Name $name, MemberScope it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getContributedFunctions($name, NoLookupLocation.FROM_BUILTINS);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider
    public Set<Name> getFunctionsNames(ClassDescriptor classDescriptor) {
        LazyJavaClassMemberScope unsubstitutedMemberScope;
        Set<Name> functionNames;
        Intrinsics.checkNotNullParameter(classDescriptor, "classDescriptor");
        if (getSettings().isAdditionalBuiltInsFeatureSupported()) {
            LazyJavaClassDescriptor javaAnalogue = getJavaAnalogue(classDescriptor);
            return (javaAnalogue == null || (unsubstitutedMemberScope = javaAnalogue.getUnsubstitutedMemberScope()) == null || (functionNames = unsubstitutedMemberScope.getFunctionNames()) == null) ? SetsKt.emptySet() : functionNames;
        }
        return SetsKt.emptySet();
    }

    private final Collection<SimpleFunctionDescriptor> getAdditionalFunctions(ClassDescriptor classDescriptor, Function1<? super MemberScope, ? extends Collection<? extends SimpleFunctionDescriptor>> function1) {
        Iterable $this$any$iv;
        final LazyJavaClassDescriptor javaAnalogueDescriptor = getJavaAnalogue(classDescriptor);
        if (javaAnalogueDescriptor == null) {
            return CollectionsKt.emptyList();
        }
        Collection kotlinClassDescriptors = this.j2kClassMapper.mapPlatformClass(DescriptorUtilsKt.getFqNameSafe(javaAnalogueDescriptor), FallbackBuiltIns.Companion.getInstance());
        final ClassDescriptor kotlinMutableClassIfContainer = (ClassDescriptor) CollectionsKt.lastOrNull(kotlinClassDescriptors);
        if (kotlinMutableClassIfContainer == null) {
            return CollectionsKt.emptyList();
        }
        SmartSet.Companion companion = SmartSet.Companion;
        Collection $this$map$iv = kotlinClassDescriptors;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            ClassDescriptor it = (ClassDescriptor) item$iv$iv;
            destination$iv$iv.add(DescriptorUtilsKt.getFqNameSafe(it));
        }
        SmartSet kotlinVersions = companion.create((List) destination$iv$iv);
        boolean isMutable = this.j2kClassMapper.isMutable(classDescriptor);
        ClassDescriptor fakeJavaClassDescriptor = this.javaAnalogueClassesWithCustomSupertypeCache.computeIfAbsent(DescriptorUtilsKt.getFqNameSafe(javaAnalogueDescriptor), new Function0(javaAnalogueDescriptor, kotlinMutableClassIfContainer) { // from class: kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer$$Lambda$5
            private final LazyJavaClassDescriptor arg$0;
            private final ClassDescriptor arg$1;

            {
                this.arg$0 = javaAnalogueDescriptor;
                this.arg$1 = kotlinMutableClassIfContainer;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                ClassDescriptor additionalFunctions$lambda$1;
                additionalFunctions$lambda$1 = JvmBuiltInsCustomizer.getAdditionalFunctions$lambda$1(this.arg$0, this.arg$1);
                return additionalFunctions$lambda$1;
            }
        });
        MemberScope scope = fakeJavaClassDescriptor.getUnsubstitutedMemberScope();
        Intrinsics.checkNotNullExpressionValue(scope, "getUnsubstitutedMemberScope(...)");
        Iterable $this$filter$iv = function1.invoke(scope);
        Collection destination$iv$iv2 = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            LazyJavaClassDescriptor javaAnalogueDescriptor2 = javaAnalogueDescriptor;
            Collection kotlinClassDescriptors2 = kotlinClassDescriptors;
            SimpleFunctionDescriptor analogueMember = (SimpleFunctionDescriptor) element$iv$iv;
            ClassDescriptor kotlinMutableClassIfContainer2 = kotlinMutableClassIfContainer;
            boolean z = false;
            if (analogueMember.getKind() == CallableMemberDescriptor.Kind.DECLARATION && analogueMember.getVisibility().isPublicAPI() && !KotlinBuiltIns.isDeprecated(analogueMember)) {
                Iterable overriddenDescriptors = analogueMember.getOverriddenDescriptors();
                Intrinsics.checkNotNullExpressionValue(overriddenDescriptors, "getOverriddenDescriptors(...)");
                Iterable $this$any$iv2 = overriddenDescriptors;
                if (($this$any$iv2 instanceof Collection) && ((Collection) $this$any$iv2).isEmpty()) {
                    $this$any$iv = null;
                } else {
                    Iterator it2 = $this$any$iv2.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            $this$any$iv = null;
                            break;
                        }
                        Object element$iv = it2.next();
                        FunctionDescriptor it3 = (FunctionDescriptor) element$iv;
                        Iterable $this$any$iv3 = $this$any$iv2;
                        DeclarationDescriptor containingDeclaration = it3.getContainingDeclaration();
                        Iterator it4 = it2;
                        Intrinsics.checkNotNullExpressionValue(containingDeclaration, "getContainingDeclaration(...)");
                        if (kotlinVersions.contains(DescriptorUtilsKt.getFqNameSafe(containingDeclaration))) {
                            $this$any$iv = 1;
                            break;
                        }
                        $this$any$iv2 = $this$any$iv3;
                        it2 = it4;
                    }
                }
                if ($this$any$iv == null && !isMutabilityViolation(analogueMember, isMutable)) {
                    z = true;
                }
            }
            if (z) {
                destination$iv$iv2.add(element$iv$iv);
            }
            javaAnalogueDescriptor = javaAnalogueDescriptor2;
            kotlinClassDescriptors = kotlinClassDescriptors2;
            kotlinMutableClassIfContainer = kotlinMutableClassIfContainer2;
        }
        return (List) destination$iv$iv2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ClassDescriptor getAdditionalFunctions$lambda$1(LazyJavaClassDescriptor $javaAnalogueDescriptor, ClassDescriptor $kotlinMutableClassIfContainer) {
        JavaResolverCache EMPTY = JavaResolverCache.EMPTY;
        Intrinsics.checkNotNullExpressionValue(EMPTY, "EMPTY");
        return $javaAnalogueDescriptor.copy$descriptors_jvm(EMPTY, $kotlinMutableClassIfContainer);
    }

    private final SimpleFunctionDescriptor createCloneForArray(DeserializedClassDescriptor arrayClassDescriptor, SimpleFunctionDescriptor cloneFromCloneable) {
        FunctionDescriptor.CopyBuilder $this$createCloneForArray_u24lambda_u240 = cloneFromCloneable.newCopyBuilder();
        $this$createCloneForArray_u24lambda_u240.setOwner(arrayClassDescriptor);
        $this$createCloneForArray_u24lambda_u240.setVisibility(DescriptorVisibilities.PUBLIC);
        $this$createCloneForArray_u24lambda_u240.setReturnType(arrayClassDescriptor.getDefaultType());
        $this$createCloneForArray_u24lambda_u240.setDispatchReceiverParameter(arrayClassDescriptor.getThisAsReceiverParameter());
        SimpleFunctionDescriptor build = $this$createCloneForArray_u24lambda_u240.build();
        Intrinsics.checkNotNull(build);
        return build;
    }

    private final boolean isMutabilityViolation(SimpleFunctionDescriptor $this$isMutabilityViolation, boolean isMutable) {
        DeclarationDescriptor containingDeclaration = $this$isMutabilityViolation.getContainingDeclaration();
        Intrinsics.checkNotNull(containingDeclaration, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        ClassDescriptor owner = (ClassDescriptor) containingDeclaration;
        String jvmDescriptor = MethodSignatureMappingKt.computeJvmDescriptor$default($this$isMutabilityViolation, false, false, 3, null);
        if (JvmBuiltInsSignatures.INSTANCE.getMUTABLE_METHOD_SIGNATURES().contains(MethodSignatureBuildingUtilsKt.signature(SignatureBuildingComponents.INSTANCE, owner, jvmDescriptor)) ^ isMutable) {
            return true;
        }
        Boolean ifAny = DFS.ifAny(CollectionsKt.listOf($this$isMutabilityViolation), new DFS.Neighbors() { // from class: kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer$$Lambda$6
            @Override // kotlin.reflect.jvm.internal.impl.utils.DFS.Neighbors
            public Iterable getNeighbors(Object obj) {
                Iterable isMutabilityViolation$lambda$0;
                isMutabilityViolation$lambda$0 = JvmBuiltInsCustomizer.isMutabilityViolation$lambda$0((CallableMemberDescriptor) obj);
                return isMutabilityViolation$lambda$0;
            }
        }, new Function1(this) { // from class: kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer$$Lambda$7
            private final JvmBuiltInsCustomizer arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                Boolean isMutabilityViolation$lambda$1;
                isMutabilityViolation$lambda$1 = JvmBuiltInsCustomizer.isMutabilityViolation$lambda$1(this.arg$0, (CallableMemberDescriptor) obj);
                return isMutabilityViolation$lambda$1;
            }
        });
        Intrinsics.checkNotNullExpressionValue(ifAny, "ifAny(...)");
        return ifAny.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Iterable isMutabilityViolation$lambda$0(CallableMemberDescriptor it) {
        return it.getOriginal().getOverriddenDescriptors();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Boolean isMutabilityViolation$lambda$1(JvmBuiltInsCustomizer this$0, CallableMemberDescriptor overridden) {
        boolean z;
        if (overridden.getKind() == CallableMemberDescriptor.Kind.DECLARATION) {
            JavaToKotlinClassMapper javaToKotlinClassMapper = this$0.j2kClassMapper;
            DeclarationDescriptor containingDeclaration = overridden.getContainingDeclaration();
            Intrinsics.checkNotNull(containingDeclaration, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
            if (javaToKotlinClassMapper.isMutable((ClassDescriptor) containingDeclaration)) {
                z = true;
                return Boolean.valueOf(z);
            }
        }
        z = false;
        return Boolean.valueOf(z);
    }

    private final JDKMemberStatus getJdkMethodStatus(FunctionDescriptor $this$getJdkMethodStatus) {
        DeclarationDescriptor containingDeclaration = $this$getJdkMethodStatus.getContainingDeclaration();
        Intrinsics.checkNotNull(containingDeclaration, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        ClassDescriptor owner = (ClassDescriptor) containingDeclaration;
        final String jvmDescriptor = MethodSignatureMappingKt.computeJvmDescriptor$default($this$getJdkMethodStatus, false, false, 3, null);
        final Ref.ObjectRef result = new Ref.ObjectRef();
        Object dfs = DFS.dfs(CollectionsKt.listOf(owner), new DFS.Neighbors(this) { // from class: kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer$$Lambda$8
            private final JvmBuiltInsCustomizer arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.utils.DFS.Neighbors
            public Iterable getNeighbors(Object obj) {
                Iterable jdkMethodStatus$lambda$0;
                jdkMethodStatus$lambda$0 = JvmBuiltInsCustomizer.getJdkMethodStatus$lambda$0(this.arg$0, (ClassDescriptor) obj);
                return jdkMethodStatus$lambda$0;
            }
        }, new DFS.AbstractNodeHandler<ClassDescriptor, JDKMemberStatus>() { // from class: kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer$getJdkMethodStatus$2
            /* JADX WARN: Type inference failed for: r2v0, types: [kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer$JDKMemberStatus, T] */
            /* JADX WARN: Type inference failed for: r2v1, types: [kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer$JDKMemberStatus, T] */
            /* JADX WARN: Type inference failed for: r2v2, types: [kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer$JDKMemberStatus, T] */
            /* JADX WARN: Type inference failed for: r2v3, types: [kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer$JDKMemberStatus, T] */
            @Override // kotlin.reflect.jvm.internal.impl.utils.DFS.AbstractNodeHandler, kotlin.reflect.jvm.internal.impl.utils.DFS.NodeHandler
            public boolean beforeChildren(ClassDescriptor javaClassDescriptor) {
                Intrinsics.checkNotNullParameter(javaClassDescriptor, "javaClassDescriptor");
                String signature = MethodSignatureBuildingUtilsKt.signature(SignatureBuildingComponents.INSTANCE, javaClassDescriptor, jvmDescriptor);
                if (JvmBuiltInsSignatures.INSTANCE.getHIDDEN_METHOD_SIGNATURES().contains(signature)) {
                    result.element = JvmBuiltInsCustomizer.JDKMemberStatus.HIDDEN;
                } else if (JvmBuiltInsSignatures.INSTANCE.getVISIBLE_METHOD_SIGNATURES().contains(signature)) {
                    result.element = JvmBuiltInsCustomizer.JDKMemberStatus.VISIBLE;
                } else if (JvmBuiltInsSignatures.INSTANCE.getDEPRECATED_LIST_METHODS().contains(signature)) {
                    result.element = JvmBuiltInsCustomizer.JDKMemberStatus.DEPRECATED_LIST_METHODS;
                } else if (JvmBuiltInsSignatures.INSTANCE.getDROP_LIST_METHOD_SIGNATURES().contains(signature)) {
                    result.element = JvmBuiltInsCustomizer.JDKMemberStatus.DROP;
                }
                return result.element == null;
            }

            @Override // kotlin.reflect.jvm.internal.impl.utils.DFS.NodeHandler
            public JvmBuiltInsCustomizer.JDKMemberStatus result() {
                JvmBuiltInsCustomizer.JDKMemberStatus jDKMemberStatus = result.element;
                return jDKMemberStatus == null ? JvmBuiltInsCustomizer.JDKMemberStatus.NOT_CONSIDERED : jDKMemberStatus;
            }
        });
        Intrinsics.checkNotNullExpressionValue(dfs, "dfs(...)");
        return (JDKMemberStatus) dfs;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Iterable getJdkMethodStatus$lambda$0(JvmBuiltInsCustomizer this$0, ClassDescriptor it) {
        Iterable mo1172getSupertypes = it.getTypeConstructor().mo1172getSupertypes();
        Intrinsics.checkNotNullExpressionValue(mo1172getSupertypes, "getSupertypes(...)");
        Iterable $this$mapNotNull$iv = mo1172getSupertypes;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
            KotlinType supertype = (KotlinType) element$iv$iv$iv;
            ClassifierDescriptor mo1171getDeclarationDescriptor = supertype.getConstructor().mo1171getDeclarationDescriptor();
            ClassDescriptor superClassDescriptor = null;
            ClassifierDescriptor original = mo1171getDeclarationDescriptor != null ? mo1171getDeclarationDescriptor.getOriginal() : null;
            ClassDescriptor classDescriptor = original instanceof ClassDescriptor ? (ClassDescriptor) original : null;
            if (classDescriptor != null) {
                ClassDescriptor superClassDescriptor2 = classDescriptor;
                LazyJavaClassDescriptor javaAnalogue = this$0.getJavaAnalogue(superClassDescriptor2);
                superClassDescriptor = superClassDescriptor2;
                if (javaAnalogue != null) {
                    superClassDescriptor = javaAnalogue;
                }
            }
            if (superClassDescriptor != null) {
                destination$iv$iv.add(superClassDescriptor);
            }
        }
        return (List) destination$iv$iv;
    }

    private final LazyJavaClassDescriptor getJavaAnalogue(ClassDescriptor $this$getJavaAnalogue) {
        ClassId mapKotlinToJava;
        FqName javaAnalogueFqName;
        if (!KotlinBuiltIns.isAny($this$getJavaAnalogue) && KotlinBuiltIns.isUnderKotlinPackage($this$getJavaAnalogue)) {
            FqNameUnsafe fqName = DescriptorUtilsKt.getFqNameUnsafe($this$getJavaAnalogue);
            if (!fqName.isSafe() || (mapKotlinToJava = JavaToKotlinClassMap.INSTANCE.mapKotlinToJava(fqName)) == null || (javaAnalogueFqName = mapKotlinToJava.asSingleFqName()) == null) {
                return null;
            }
            ClassDescriptor resolveClassByFqName = DescriptorUtilKt.resolveClassByFqName(getSettings().getOwnerModuleDescriptor(), javaAnalogueFqName, NoLookupLocation.FROM_BUILTINS);
            if (resolveClassByFqName instanceof LazyJavaClassDescriptor) {
                return (LazyJavaClassDescriptor) resolveClassByFqName;
            }
            return null;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0127 A[SYNTHETIC] */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Collection<ClassConstructorDescriptor> getConstructors(ClassDescriptor classDescriptor) {
        ClassDescriptor defaultKotlinVersion;
        ClassDescriptor defaultKotlinVersion2;
        Iterable $this$filter$iv;
        boolean z;
        boolean z2;
        ClassDescriptor defaultKotlinVersion3;
        JvmBuiltInsCustomizer jvmBuiltInsCustomizer = this;
        ClassDescriptor classDescriptor2 = classDescriptor;
        Intrinsics.checkNotNullParameter(classDescriptor2, "classDescriptor");
        if (classDescriptor.getKind() == ClassKind.CLASS && getSettings().isAdditionalBuiltInsFeatureSupported()) {
            LazyJavaClassDescriptor javaAnalogueDescriptor = getJavaAnalogue(classDescriptor);
            if (javaAnalogueDescriptor != null && (defaultKotlinVersion = JavaToKotlinClassMapper.mapJavaToKotlin$default(jvmBuiltInsCustomizer.j2kClassMapper, DescriptorUtilsKt.getFqNameSafe(javaAnalogueDescriptor), FallbackBuiltIns.Companion.getInstance(), null, 4, null)) != null) {
                TypeSubstitutor substitutor = MappingUtilKt.createMappedTypeParametersSubstitution(defaultKotlinVersion, javaAnalogueDescriptor).buildSubstitutor();
                Iterable $this$filter$iv2 = javaAnalogueDescriptor.getConstructors();
                boolean z3 = false;
                Collection destination$iv$iv = new ArrayList();
                for (Object element$iv$iv : $this$filter$iv2) {
                    ClassConstructorDescriptor javaConstructor = (ClassConstructorDescriptor) element$iv$iv;
                    if (javaConstructor.getVisibility().isPublicAPI()) {
                        Iterable constructors = defaultKotlinVersion.getConstructors();
                        Intrinsics.checkNotNullExpressionValue(constructors, "getConstructors(...)");
                        Iterable $this$none$iv = constructors;
                        if (($this$none$iv instanceof Collection) && ((Collection) $this$none$iv).isEmpty()) {
                            defaultKotlinVersion2 = defaultKotlinVersion;
                            $this$filter$iv = $this$filter$iv2;
                            defaultKotlinVersion3 = 1;
                        } else {
                            Iterator<T> it = $this$none$iv.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    defaultKotlinVersion2 = defaultKotlinVersion;
                                    $this$filter$iv = $this$filter$iv2;
                                    defaultKotlinVersion3 = 1;
                                    break;
                                }
                                Object element$iv = it.next();
                                ClassConstructorDescriptor it2 = (ClassConstructorDescriptor) element$iv;
                                Intrinsics.checkNotNull(it2);
                                defaultKotlinVersion2 = defaultKotlinVersion;
                                $this$filter$iv = $this$filter$iv2;
                                if (getConstructors$isEffectivelyTheSameAs(it2, substitutor, javaConstructor)) {
                                    defaultKotlinVersion3 = null;
                                    break;
                                }
                                defaultKotlinVersion = defaultKotlinVersion2;
                                $this$filter$iv2 = $this$filter$iv;
                            }
                        }
                        if (defaultKotlinVersion3 == null) {
                            z = z3;
                        } else if (jvmBuiltInsCustomizer.isTrivialCopyConstructorFor(javaConstructor, classDescriptor2)) {
                            z = z3;
                        } else if (KotlinBuiltIns.isDeprecated(javaConstructor)) {
                            z = z3;
                        } else {
                            z = z3;
                            if (!JvmBuiltInsSignatures.INSTANCE.getHIDDEN_CONSTRUCTOR_SIGNATURES().contains(MethodSignatureBuildingUtilsKt.signature(SignatureBuildingComponents.INSTANCE, javaAnalogueDescriptor, MethodSignatureMappingKt.computeJvmDescriptor$default(javaConstructor, false, false, 3, null)))) {
                                z2 = true;
                                if (!z2) {
                                    destination$iv$iv.add(element$iv$iv);
                                }
                                jvmBuiltInsCustomizer = this;
                                z3 = z;
                                defaultKotlinVersion = defaultKotlinVersion2;
                                $this$filter$iv2 = $this$filter$iv;
                            }
                        }
                    } else {
                        defaultKotlinVersion2 = defaultKotlinVersion;
                        $this$filter$iv = $this$filter$iv2;
                        z = z3;
                    }
                    z2 = false;
                    if (!z2) {
                    }
                    jvmBuiltInsCustomizer = this;
                    z3 = z;
                    defaultKotlinVersion = defaultKotlinVersion2;
                    $this$filter$iv2 = $this$filter$iv;
                }
                Iterable $this$map$iv = (List) destination$iv$iv;
                int $i$f$map = 0;
                Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                Iterable $this$mapTo$iv$iv = $this$map$iv;
                for (Object item$iv$iv : $this$mapTo$iv$iv) {
                    ClassConstructorDescriptor javaConstructor2 = (ClassConstructorDescriptor) item$iv$iv;
                    FunctionDescriptor.CopyBuilder $this$getConstructors_u24lambda_u241_u240 = javaConstructor2.newCopyBuilder();
                    $this$getConstructors_u24lambda_u241_u240.setOwner(classDescriptor2);
                    $this$getConstructors_u24lambda_u241_u240.setReturnType(classDescriptor.getDefaultType());
                    $this$getConstructors_u24lambda_u241_u240.setPreserveSourceElement();
                    $this$getConstructors_u24lambda_u241_u240.setSubstitution(substitutor.getSubstitution());
                    Iterable $this$map$iv2 = $this$map$iv;
                    LazyJavaClassDescriptor javaAnalogueDescriptor2 = javaAnalogueDescriptor;
                    int $i$f$map2 = $i$f$map;
                    TypeSubstitutor substitutor2 = substitutor;
                    Iterable $this$mapTo$iv$iv2 = $this$mapTo$iv$iv;
                    if (!JvmBuiltInsSignatures.INSTANCE.getVISIBLE_CONSTRUCTOR_SIGNATURES().contains(MethodSignatureBuildingUtilsKt.signature(SignatureBuildingComponents.INSTANCE, javaAnalogueDescriptor, MethodSignatureMappingKt.computeJvmDescriptor$default(javaConstructor2, false, false, 3, null)))) {
                        $this$getConstructors_u24lambda_u241_u240.setAdditionalAnnotations(getNotConsideredDeprecation());
                    }
                    FunctionDescriptor build = $this$getConstructors_u24lambda_u241_u240.build();
                    Intrinsics.checkNotNull(build, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassConstructorDescriptor");
                    destination$iv$iv2.add((ClassConstructorDescriptor) build);
                    classDescriptor2 = classDescriptor;
                    $this$map$iv = $this$map$iv2;
                    substitutor = substitutor2;
                    $this$mapTo$iv$iv = $this$mapTo$iv$iv2;
                    javaAnalogueDescriptor = javaAnalogueDescriptor2;
                    $i$f$map = $i$f$map2;
                }
                return (List) destination$iv$iv2;
            }
            return CollectionsKt.emptyList();
        }
        return CollectionsKt.emptyList();
    }

    private static final boolean getConstructors$isEffectivelyTheSameAs(ConstructorDescriptor $this$getConstructors_u24isEffectivelyTheSameAs, TypeSubstitutor substitutor, ConstructorDescriptor javaConstructor) {
        return OverridingUtil.getBothWaysOverridability($this$getConstructors_u24isEffectivelyTheSameAs, javaConstructor.substitute(substitutor)) == OverridingUtil.OverrideCompatibilityInfo.Result.OVERRIDABLE;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter
    public boolean isFunctionAvailable(ClassDescriptor classDescriptor, SimpleFunctionDescriptor functionDescriptor) {
        Intrinsics.checkNotNullParameter(classDescriptor, "classDescriptor");
        Intrinsics.checkNotNullParameter(functionDescriptor, "functionDescriptor");
        LazyJavaClassDescriptor javaAnalogueClassDescriptor = getJavaAnalogue(classDescriptor);
        if (javaAnalogueClassDescriptor != null && functionDescriptor.getAnnotations().hasAnnotation(PlatformDependentDeclarationFilterKt.getPLATFORM_DEPENDENT_ANNOTATION_FQ_NAME())) {
            if (getSettings().isAdditionalBuiltInsFeatureSupported()) {
                String jvmDescriptor = MethodSignatureMappingKt.computeJvmDescriptor$default(functionDescriptor, false, false, 3, null);
                LazyJavaClassMemberScope unsubstitutedMemberScope = javaAnalogueClassDescriptor.getUnsubstitutedMemberScope();
                Name name = functionDescriptor.getName();
                Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                Iterable $this$any$iv = unsubstitutedMemberScope.getContributedFunctions(name, NoLookupLocation.FROM_BUILTINS);
                if (($this$any$iv instanceof Collection) && ((Collection) $this$any$iv).isEmpty()) {
                    return false;
                }
                for (Object element$iv : $this$any$iv) {
                    SimpleFunctionDescriptor it = (SimpleFunctionDescriptor) element$iv;
                    if (Intrinsics.areEqual(MethodSignatureMappingKt.computeJvmDescriptor$default(it, false, false, 3, null), jvmDescriptor)) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
        return true;
    }

    private final boolean isTrivialCopyConstructorFor(ConstructorDescriptor $this$isTrivialCopyConstructorFor, ClassDescriptor classDescriptor) {
        if ($this$isTrivialCopyConstructorFor.getValueParameters().size() == 1) {
            List<ValueParameterDescriptor> valueParameters = $this$isTrivialCopyConstructorFor.getValueParameters();
            Intrinsics.checkNotNullExpressionValue(valueParameters, "getValueParameters(...)");
            ClassifierDescriptor mo1171getDeclarationDescriptor = ((ValueParameterDescriptor) CollectionsKt.single((List<? extends Object>) valueParameters)).getType().getConstructor().mo1171getDeclarationDescriptor();
            if (Intrinsics.areEqual(mo1171getDeclarationDescriptor != null ? DescriptorUtilsKt.getFqNameUnsafe(mo1171getDeclarationDescriptor) : null, DescriptorUtilsKt.getFqNameUnsafe(classDescriptor))) {
                return true;
            }
        }
        return false;
    }
}