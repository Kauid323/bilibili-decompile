package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassConstructorDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.EnumEntrySyntheticClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyGetterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.SimpleFunctionDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithDifferentJvmName;
import kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithSpecialGenericSignature;
import kotlin.reflect.jvm.internal.impl.load.java.ClassicBuiltinSpecialProperties;
import kotlin.reflect.jvm.internal.impl.load.java.JavaClassFinder;
import kotlin.reflect.jvm.internal.impl.load.java.JavaDescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.load.java.JavaIncompatibilityRulesOverridabilityCondition;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAbi;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames;
import kotlin.reflect.jvm.internal.impl.load.java.PropertiesConventionUtilKt;
import kotlin.reflect.jvm.internal.impl.load.java.SpecialBuiltinMembers;
import kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures;
import kotlin.reflect.jvm.internal.impl.load.java.UtilsKt;
import kotlin.reflect.jvm.internal.impl.load.java.components.DescriptorResolverUtils;
import kotlin.reflect.jvm.internal.impl.load.java.components.SignaturePropagator;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaForKotlinOverridePropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaPropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.UtilKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.ContextKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotationsKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributes;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributesKt;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaConstructor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMember;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaRecordComponent;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeUsage;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker;
import kotlin.reflect.jvm.internal.impl.utils.SmartSet;

/* compiled from: LazyJavaClassMemberScope.kt */
public final class LazyJavaClassMemberScope extends LazyJavaScope {
    private final NotNullLazyValue<List<ClassConstructorDescriptor>> constructors;
    private final NotNullLazyValue<Map<Name, JavaField>> enumEntryIndex;
    private final NotNullLazyValue<Set<Name>> generatedNestedClassNames;
    private final JavaClass jClass;
    private final NotNullLazyValue<Set<Name>> nestedClassIndex;
    private final MemoizedFunctionToNullable<Name, ClassDescriptor> nestedClasses;
    private final ClassDescriptor ownerDescriptor;
    private final boolean skipRefinement;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyJavaClassMemberScope(final LazyJavaResolverContext c, ClassDescriptor ownerDescriptor, JavaClass jClass, boolean skipRefinement, LazyJavaClassMemberScope mainScope) {
        super(c, mainScope);
        Intrinsics.checkNotNullParameter(c, "c");
        Intrinsics.checkNotNullParameter(ownerDescriptor, "ownerDescriptor");
        Intrinsics.checkNotNullParameter(jClass, "jClass");
        this.ownerDescriptor = ownerDescriptor;
        this.jClass = jClass;
        this.skipRefinement = skipRefinement;
        this.constructors = c.getStorageManager().createLazyValue(new Function0(this, c) { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope$$Lambda$0
            private final LazyJavaClassMemberScope arg$0;
            private final LazyJavaResolverContext arg$1;

            {
                this.arg$0 = this;
                this.arg$1 = c;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                List constructors$lambda$0;
                constructors$lambda$0 = LazyJavaClassMemberScope.constructors$lambda$0(this.arg$0, this.arg$1);
                return constructors$lambda$0;
            }
        });
        this.nestedClassIndex = c.getStorageManager().createLazyValue(new Function0(this) { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope$$Lambda$1
            private final LazyJavaClassMemberScope arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                Set nestedClassIndex$lambda$0;
                nestedClassIndex$lambda$0 = LazyJavaClassMemberScope.nestedClassIndex$lambda$0(this.arg$0);
                return nestedClassIndex$lambda$0;
            }
        });
        this.generatedNestedClassNames = c.getStorageManager().createLazyValue(new Function0(c, this) { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope$$Lambda$2
            private final LazyJavaResolverContext arg$0;
            private final LazyJavaClassMemberScope arg$1;

            {
                this.arg$0 = c;
                this.arg$1 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                Set generatedNestedClassNames$lambda$0;
                generatedNestedClassNames$lambda$0 = LazyJavaClassMemberScope.generatedNestedClassNames$lambda$0(this.arg$0, this.arg$1);
                return generatedNestedClassNames$lambda$0;
            }
        });
        this.enumEntryIndex = c.getStorageManager().createLazyValue(new Function0(this) { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope$$Lambda$3
            private final LazyJavaClassMemberScope arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                Map enumEntryIndex$lambda$0;
                enumEntryIndex$lambda$0 = LazyJavaClassMemberScope.enumEntryIndex$lambda$0(this.arg$0);
                return enumEntryIndex$lambda$0;
            }
        });
        this.nestedClasses = c.getStorageManager().createMemoizedFunctionWithNullableValues(new Function1(this, c) { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope$$Lambda$4
            private final LazyJavaClassMemberScope arg$0;
            private final LazyJavaResolverContext arg$1;

            {
                this.arg$0 = this;
                this.arg$1 = c;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                ClassDescriptor nestedClasses$lambda$0;
                nestedClasses$lambda$0 = LazyJavaClassMemberScope.nestedClasses$lambda$0(this.arg$0, this.arg$1, (Name) obj);
                return nestedClasses$lambda$0;
            }
        });
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ LazyJavaClassMemberScope(LazyJavaResolverContext lazyJavaResolverContext, ClassDescriptor classDescriptor, JavaClass javaClass, boolean z, LazyJavaClassMemberScope lazyJavaClassMemberScope, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(lazyJavaResolverContext, classDescriptor, javaClass, z, r5);
        LazyJavaClassMemberScope lazyJavaClassMemberScope2;
        if ((i & 16) == 0) {
            lazyJavaClassMemberScope2 = lazyJavaClassMemberScope;
        } else {
            lazyJavaClassMemberScope2 = null;
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public /* bridge */ /* synthetic */ Set computeFunctionNames(DescriptorKindFilter kindFilter, Function1 nameFilter) {
        return computeFunctionNames(kindFilter, (Function1<? super Name, Boolean>) nameFilter);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public ClassDescriptor getOwnerDescriptor() {
        return this.ownerDescriptor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean computeMemberIndex$lambda$0(JavaMember it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return !it.isStatic();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public ClassDeclaredMemberIndex computeMemberIndex() {
        return new ClassDeclaredMemberIndex(this.jClass, new Function1() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope$$Lambda$5
            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                boolean computeMemberIndex$lambda$0;
                computeMemberIndex$lambda$0 = LazyJavaClassMemberScope.computeMemberIndex$lambda$0((JavaMember) obj);
                return Boolean.valueOf(computeMemberIndex$lambda$0);
            }
        });
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    protected LinkedHashSet<Name> computeFunctionNames(DescriptorKindFilter kindFilter, Function1<? super Name, Boolean> function1) {
        Intrinsics.checkNotNullParameter(kindFilter, "kindFilter");
        Iterable mo1172getSupertypes = getOwnerDescriptor().getTypeConstructor().mo1172getSupertypes();
        Intrinsics.checkNotNullExpressionValue(mo1172getSupertypes, "getSupertypes(...)");
        Iterable $this$flatMapTo$iv = mo1172getSupertypes;
        Collection destination$iv = new LinkedHashSet();
        for (Object element$iv : $this$flatMapTo$iv) {
            KotlinType it = (KotlinType) element$iv;
            Iterable list$iv = it.getMemberScope().getFunctionNames();
            CollectionsKt.addAll(destination$iv, list$iv);
        }
        LinkedHashSet $this$computeFunctionNames_u24lambda_u241 = (LinkedHashSet) destination$iv;
        $this$computeFunctionNames_u24lambda_u241.addAll(getDeclaredMemberIndex().invoke().getMethodNames());
        $this$computeFunctionNames_u24lambda_u241.addAll(getDeclaredMemberIndex().invoke().getRecordComponentNames());
        $this$computeFunctionNames_u24lambda_u241.addAll(computeClassNames(kindFilter, function1));
        $this$computeFunctionNames_u24lambda_u241.addAll(getC().getComponents().getSyntheticPartsProvider().getMethodNames(getOwnerDescriptor(), getC()));
        return (LinkedHashSet) destination$iv;
    }

    public final NotNullLazyValue<List<ClassConstructorDescriptor>> getConstructors$descriptors_jvm() {
        return this.constructors;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v3, types: [java.util.Collection] */
    public static final List constructors$lambda$0(LazyJavaClassMemberScope this$0, LazyJavaResolverContext $c) {
        Collection constructors = this$0.jClass.getConstructors();
        ArrayList result = new ArrayList(constructors.size());
        for (JavaConstructor constructor : constructors) {
            JavaClassConstructorDescriptor descriptor = this$0.resolveConstructor(constructor);
            result.add(descriptor);
        }
        if (this$0.jClass.isRecord()) {
            ClassConstructorDescriptor defaultConstructor = this$0.createDefaultRecordConstructor();
            boolean z = false;
            String jvmDescriptor = MethodSignatureMappingKt.computeJvmDescriptor$default(defaultConstructor, false, false, 2, null);
            ArrayList $this$none$iv = result;
            if (!($this$none$iv instanceof Collection) || !$this$none$iv.isEmpty()) {
                Iterator it = $this$none$iv.iterator();
                while (true) {
                    if (it.hasNext()) {
                        Object element$iv = it.next();
                        ClassConstructorDescriptor it2 = (ClassConstructorDescriptor) element$iv;
                        if (Intrinsics.areEqual(MethodSignatureMappingKt.computeJvmDescriptor$default(it2, false, false, 2, null), jvmDescriptor)) {
                            break;
                        }
                    } else {
                        z = true;
                        break;
                    }
                }
            } else {
                z = true;
            }
            if (z) {
                result.add(defaultConstructor);
                $c.getComponents().getJavaResolverCache().recordConstructor(this$0.jClass, defaultConstructor);
            }
        }
        $c.getComponents().getSyntheticPartsProvider().generateConstructors(this$0.getOwnerDescriptor(), result, $c);
        SignatureEnhancement signatureEnhancement = $c.getComponents().getSignatureEnhancement();
        ArrayList arrayList = result;
        if (arrayList.isEmpty()) {
            arrayList = CollectionsKt.listOfNotNull(this$0.createDefaultConstructor());
        }
        return CollectionsKt.toList(signatureEnhancement.enhanceSignatures($c, arrayList));
    }

    private final ClassConstructorDescriptor createDefaultRecordConstructor() {
        ClassDescriptor classDescriptor = getOwnerDescriptor();
        JavaClassConstructorDescriptor constructorDescriptor = JavaClassConstructorDescriptor.createJavaConstructor(classDescriptor, Annotations.Companion.getEMPTY(), true, getC().getComponents().getSourceElementFactory().source(this.jClass));
        Intrinsics.checkNotNullExpressionValue(constructorDescriptor, "createJavaConstructor(...)");
        List valueParameters = createRecordConstructorParameters(constructorDescriptor);
        constructorDescriptor.setHasSynthesizedParameterNames(false);
        constructorDescriptor.initialize(valueParameters, getConstructorVisibility(classDescriptor));
        constructorDescriptor.setHasStableParameterNames(false);
        constructorDescriptor.setReturnType(classDescriptor.getDefaultType());
        return constructorDescriptor;
    }

    private final List<ValueParameterDescriptor> createRecordConstructorParameters(ClassConstructorDescriptorImpl constructor) {
        Collection<JavaRecordComponent> components = this.jClass.getRecordComponents();
        ArrayList result = new ArrayList(components.size());
        int i = 0;
        JavaTypeAttributes attr = JavaTypeAttributesKt.toAttributes$default(TypeUsage.COMMON, false, false, null, 6, null);
        for (JavaRecordComponent component : components) {
            int index = i;
            i++;
            KotlinType parameterType = getC().getTypeResolver().transformJavaType(component.getType(), attr);
            KotlinType varargElementType = component.isVararg() ? getC().getComponents().getModule().getBuiltIns().getArrayElementType(parameterType) : null;
            result.add(new ValueParameterDescriptorImpl(constructor, null, index, Annotations.Companion.getEMPTY(), component.getName(), parameterType, false, false, false, varargElementType, getC().getComponents().getSourceElementFactory().source(component)));
        }
        return result;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    protected boolean isVisibleAsFunction(JavaMethodDescriptor $this$isVisibleAsFunction) {
        Intrinsics.checkNotNullParameter($this$isVisibleAsFunction, "<this>");
        if (this.jClass.isAnnotationType()) {
            return false;
        }
        return isVisibleAsFunctionInCurrentClass($this$isVisibleAsFunction);
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0084, code lost:
        if (kotlin.reflect.jvm.internal.impl.load.java.JvmAbi.isSetterName(r15) == false) goto L39;
     */
    /* JADX WARN: Removed duplicated region for block: B:51:0x008b A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean isVisibleAsFunctionInCurrentClass(final SimpleFunctionDescriptor function) {
        boolean z;
        boolean z2;
        boolean z3;
        Name name = function.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        Iterable $this$any$iv = PropertiesConventionUtilKt.getPropertyNamesCandidatesByAccessorName(name);
        if (!($this$any$iv instanceof Collection) || !((Collection) $this$any$iv).isEmpty()) {
            Iterator<T> it = $this$any$iv.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                Object element$iv = it.next();
                Name propertyName = (Name) element$iv;
                Iterable $this$any$iv2 = getPropertiesFromSupertypes(propertyName);
                if (!($this$any$iv2 instanceof Collection) || !((Collection) $this$any$iv2).isEmpty()) {
                    Iterator<T> it2 = $this$any$iv2.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            z2 = false;
                            continue;
                            break;
                        }
                        Object element$iv2 = it2.next();
                        PropertyDescriptor property = (PropertyDescriptor) element$iv2;
                        if (doesClassOverridesProperty(property, new Function1(function, this) { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope$$Lambda$6
                            private final SimpleFunctionDescriptor arg$0;
                            private final LazyJavaClassMemberScope arg$1;

                            {
                                this.arg$0 = function;
                                this.arg$1 = this;
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public Object invoke(Object obj) {
                                Collection isVisibleAsFunctionInCurrentClass$lambda$0$0$0;
                                isVisibleAsFunctionInCurrentClass$lambda$0$0$0 = LazyJavaClassMemberScope.isVisibleAsFunctionInCurrentClass$lambda$0$0$0(this.arg$0, this.arg$1, (Name) obj);
                                return isVisibleAsFunctionInCurrentClass$lambda$0$0$0;
                            }
                        })) {
                            if (!property.isVar()) {
                                String asString = function.getName().asString();
                                Intrinsics.checkNotNullExpressionValue(asString, "asString(...)");
                            }
                            z3 = true;
                            continue;
                            if (z3) {
                                z2 = true;
                                continue;
                                break;
                            }
                        }
                        z3 = false;
                        continue;
                        if (z3) {
                        }
                    }
                } else {
                    z2 = false;
                    continue;
                }
                if (z2) {
                    z = true;
                    break;
                }
            }
        } else {
            z = false;
        }
        if (z) {
            return false;
        }
        return (doesOverrideRenamedBuiltins(function) || shouldBeVisibleAsOverrideOfBuiltInWithErasedValueParameters(function) || doesOverrideSuspendFunction(function)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Collection isVisibleAsFunctionInCurrentClass$lambda$0$0$0(SimpleFunctionDescriptor $function, LazyJavaClassMemberScope this$0, Name accessorName) {
        Intrinsics.checkNotNullParameter(accessorName, "accessorName");
        if (Intrinsics.areEqual($function.getName(), accessorName)) {
            return CollectionsKt.listOf($function);
        }
        return CollectionsKt.plus((Collection) this$0.searchMethodsByNameWithoutBuiltinMagic(accessorName), (Iterable) this$0.searchMethodsInSupertypesWithoutBuiltinMagic(accessorName));
    }

    private final boolean shouldBeVisibleAsOverrideOfBuiltInWithErasedValueParameters(SimpleFunctionDescriptor $this$shouldBeVisibleAsOverrideOfBuiltInWithErasedValueParameters) {
        BuiltinMethodsWithSpecialGenericSignature builtinMethodsWithSpecialGenericSignature = BuiltinMethodsWithSpecialGenericSignature.INSTANCE;
        Name name = $this$shouldBeVisibleAsOverrideOfBuiltInWithErasedValueParameters.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        if (builtinMethodsWithSpecialGenericSignature.getSameAsBuiltinMethodWithErasedValueParameters(name)) {
            Name name2 = $this$shouldBeVisibleAsOverrideOfBuiltInWithErasedValueParameters.getName();
            Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
            Iterable $this$mapNotNull$iv = getFunctionsFromSupertypes(name2);
            Collection destination$iv$iv = new ArrayList();
            for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
                SimpleFunctionDescriptor it = (SimpleFunctionDescriptor) element$iv$iv$iv;
                FunctionDescriptor overriddenBuiltinFunctionWithErasedValueParametersInJava = BuiltinMethodsWithSpecialGenericSignature.getOverriddenBuiltinFunctionWithErasedValueParametersInJava(it);
                if (overriddenBuiltinFunctionWithErasedValueParametersInJava != null) {
                    destination$iv$iv.add(overriddenBuiltinFunctionWithErasedValueParametersInJava);
                }
            }
            Iterable candidatesToOverride = (List) destination$iv$iv;
            Iterable $this$any$iv = candidatesToOverride;
            if (($this$any$iv instanceof Collection) && ((Collection) $this$any$iv).isEmpty()) {
                return false;
            }
            for (Object element$iv : $this$any$iv) {
                FunctionDescriptor candidate = (FunctionDescriptor) element$iv;
                if (hasSameJvmDescriptorButDoesNotOverride($this$shouldBeVisibleAsOverrideOfBuiltInWithErasedValueParameters, candidate)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Collection<SimpleFunctionDescriptor> searchMethodsByNameWithoutBuiltinMagic(Name name) {
        Iterable $this$map$iv = getDeclaredMemberIndex().invoke().findMethodsByName(name);
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            JavaMethod it = (JavaMethod) item$iv$iv;
            destination$iv$iv.add(resolveMethodToFunctionDescriptor(it));
        }
        return (List) destination$iv$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Collection<SimpleFunctionDescriptor> searchMethodsInSupertypesWithoutBuiltinMagic(Name name) {
        Iterable $this$filterNot$iv = getFunctionsFromSupertypes(name);
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filterNot$iv) {
            SimpleFunctionDescriptor it = (SimpleFunctionDescriptor) element$iv$iv;
            if (!(SpecialBuiltinMembers.doesOverrideBuiltinWithDifferentJvmName(it) || BuiltinMethodsWithSpecialGenericSignature.getOverriddenBuiltinFunctionWithErasedValueParametersInJava(it) != null)) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        return (List) destination$iv$iv;
    }

    private final boolean doesOverrideRenamedBuiltins(SimpleFunctionDescriptor $this$doesOverrideRenamedBuiltins) {
        SpecialGenericSignatures.Companion companion = SpecialGenericSignatures.Companion;
        Name name = $this$doesOverrideRenamedBuiltins.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        Name builtinName = companion.getBuiltinFunctionNamesByJvmName(name);
        if (builtinName == null) {
            return false;
        }
        Iterable $this$filter$iv = getFunctionsFromSupertypes(builtinName);
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            SimpleFunctionDescriptor it = (SimpleFunctionDescriptor) element$iv$iv;
            if (SpecialBuiltinMembers.doesOverrideBuiltinWithDifferentJvmName(it)) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        List builtinSpecialFromSuperTypes = (List) destination$iv$iv;
        if (builtinSpecialFromSuperTypes.isEmpty()) {
            return false;
        }
        SimpleFunctionDescriptor methodDescriptor = createRenamedCopy($this$doesOverrideRenamedBuiltins, builtinName);
        List $this$any$iv = builtinSpecialFromSuperTypes;
        if (($this$any$iv instanceof Collection) && $this$any$iv.isEmpty()) {
            return false;
        }
        for (Object element$iv : $this$any$iv) {
            SimpleFunctionDescriptor it2 = (SimpleFunctionDescriptor) element$iv;
            if (doesOverrideRenamedDescriptor(it2, methodDescriptor)) {
                return true;
            }
        }
        return false;
    }

    private final boolean doesOverrideSuspendFunction(SimpleFunctionDescriptor $this$doesOverrideSuspendFunction) {
        SimpleFunctionDescriptor overriddenCandidate;
        SimpleFunctionDescriptor suspendView = createSuspendView($this$doesOverrideSuspendFunction);
        if (suspendView == null) {
            return false;
        }
        Name name = $this$doesOverrideSuspendFunction.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        Iterable $this$any$iv = getFunctionsFromSupertypes(name);
        if (($this$any$iv instanceof Collection) && ((Collection) $this$any$iv).isEmpty()) {
            return false;
        }
        for (Object element$iv : $this$any$iv) {
            SimpleFunctionDescriptor overriddenCandidate2 = (SimpleFunctionDescriptor) element$iv;
            if (overriddenCandidate2.isSuspend() && doesOverride(suspendView, overriddenCandidate2)) {
                overriddenCandidate = 1;
                continue;
            } else {
                overriddenCandidate = null;
                continue;
            }
            if (overriddenCandidate != null) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x004b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final SimpleFunctionDescriptor createSuspendView(SimpleFunctionDescriptor $this$createSuspendView) {
        FqName fqName;
        FqNameUnsafe p0;
        List<ValueParameterDescriptor> valueParameters = $this$createSuspendView.getValueParameters();
        Intrinsics.checkNotNullExpressionValue(valueParameters, "getValueParameters(...)");
        ValueParameterDescriptor continuationParameter = (ValueParameterDescriptor) CollectionsKt.lastOrNull((List<? extends Object>) valueParameters);
        if (continuationParameter != null) {
            ClassifierDescriptor mo1171getDeclarationDescriptor = continuationParameter.getType().getConstructor().mo1171getDeclarationDescriptor();
            if (mo1171getDeclarationDescriptor != null && (p0 = DescriptorUtilsKt.getFqNameUnsafe(mo1171getDeclarationDescriptor)) != null) {
                if (!p0.isSafe()) {
                    p0 = null;
                }
                if (p0 != null) {
                    fqName = p0.toSafe();
                    if (!Intrinsics.areEqual(fqName, StandardNames.CONTINUATION_INTERFACE_FQ_NAME)) {
                        continuationParameter = null;
                    }
                    if (continuationParameter != null) {
                        FunctionDescriptor.CopyBuilder<? extends SimpleFunctionDescriptor> newCopyBuilder = $this$createSuspendView.newCopyBuilder();
                        List<ValueParameterDescriptor> valueParameters2 = $this$createSuspendView.getValueParameters();
                        Intrinsics.checkNotNullExpressionValue(valueParameters2, "getValueParameters(...)");
                        SimpleFunctionDescriptor functionDescriptor = newCopyBuilder.setValueParameters(CollectionsKt.dropLast(valueParameters2, 1)).setReturnType(continuationParameter.getType().getArguments().get(0).getType()).build();
                        SimpleFunctionDescriptorImpl simpleFunctionDescriptorImpl = (SimpleFunctionDescriptorImpl) functionDescriptor;
                        if (simpleFunctionDescriptorImpl != null) {
                            simpleFunctionDescriptorImpl.setSuspend(true);
                        }
                        return functionDescriptor;
                    }
                }
            }
            fqName = null;
            if (!Intrinsics.areEqual(fqName, StandardNames.CONTINUATION_INTERFACE_FQ_NAME)) {
            }
            if (continuationParameter != null) {
            }
        }
        return null;
    }

    private final SimpleFunctionDescriptor createRenamedCopy(SimpleFunctionDescriptor $this$createRenamedCopy, Name builtinName) {
        FunctionDescriptor.CopyBuilder $this$createRenamedCopy_u24lambda_u240 = $this$createRenamedCopy.newCopyBuilder();
        $this$createRenamedCopy_u24lambda_u240.setName(builtinName);
        $this$createRenamedCopy_u24lambda_u240.setSignatureChange();
        $this$createRenamedCopy_u24lambda_u240.setPreserveSourceElement();
        SimpleFunctionDescriptor build = $this$createRenamedCopy_u24lambda_u240.build();
        Intrinsics.checkNotNull(build);
        return build;
    }

    private final boolean doesOverrideRenamedDescriptor(SimpleFunctionDescriptor superDescriptor, FunctionDescriptor subDescriptor) {
        FunctionDescriptor subDescriptorToCheck = BuiltinMethodsWithDifferentJvmName.INSTANCE.isRemoveAtByIndex(superDescriptor) ? subDescriptor.getOriginal() : subDescriptor;
        Intrinsics.checkNotNull(subDescriptorToCheck);
        return doesOverride(subDescriptorToCheck, superDescriptor);
    }

    private final boolean doesOverride(CallableDescriptor $this$doesOverride, CallableDescriptor superDescriptor) {
        OverridingUtil.OverrideCompatibilityInfo.Result commonOverridabilityResult = OverridingUtil.DEFAULT.isOverridableByWithoutExternalConditions(superDescriptor, $this$doesOverride, true).getResult();
        Intrinsics.checkNotNullExpressionValue(commonOverridabilityResult, "getResult(...)");
        return commonOverridabilityResult == OverridingUtil.OverrideCompatibilityInfo.Result.OVERRIDABLE && !JavaIncompatibilityRulesOverridabilityCondition.Companion.doesJavaOverrideHaveIncompatibleValueParameterKinds(superDescriptor, $this$doesOverride);
    }

    private final SimpleFunctionDescriptor findGetterOverride(PropertyDescriptor $this$findGetterOverride, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> function1) {
        PropertyGetterDescriptor getter = $this$findGetterOverride.getGetter();
        PropertyGetterDescriptor overriddenBuiltinProperty = getter != null ? (PropertyGetterDescriptor) SpecialBuiltinMembers.getOverriddenBuiltinWithDifferentJvmName(getter) : null;
        String specialGetterName = overriddenBuiltinProperty != null ? ClassicBuiltinSpecialProperties.INSTANCE.getBuiltinSpecialPropertyGetterName(overriddenBuiltinProperty) : null;
        if (specialGetterName != null && !SpecialBuiltinMembers.hasRealKotlinSuperClassWithOverrideOf(getOwnerDescriptor(), overriddenBuiltinProperty)) {
            return findGetterByName($this$findGetterOverride, specialGetterName, function1);
        }
        String asString = $this$findGetterOverride.getName().asString();
        Intrinsics.checkNotNullExpressionValue(asString, "asString(...)");
        return findGetterByName($this$findGetterOverride, JvmAbi.getterName(asString), function1);
    }

    private final SimpleFunctionDescriptor findGetterByName(PropertyDescriptor $this$findGetterByName, String getterName, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> function1) {
        SimpleFunctionDescriptor simpleFunctionDescriptor;
        Name identifier = Name.identifier(getterName);
        Intrinsics.checkNotNullExpressionValue(identifier, "identifier(...)");
        Iterator<T> it = function1.invoke(identifier).iterator();
        do {
            simpleFunctionDescriptor = null;
            if (!it.hasNext()) {
                break;
            }
            SimpleFunctionDescriptor descriptor = (SimpleFunctionDescriptor) it.next();
            if (descriptor.getValueParameters().size() == 0) {
                KotlinTypeChecker kotlinTypeChecker = KotlinTypeChecker.DEFAULT;
                KotlinType returnType = descriptor.getReturnType();
                if (returnType == null ? false : kotlinTypeChecker.isSubtypeOf(returnType, $this$findGetterByName.getType())) {
                    simpleFunctionDescriptor = descriptor;
                    continue;
                } else {
                    continue;
                }
            }
        } while (simpleFunctionDescriptor == null);
        return simpleFunctionDescriptor;
    }

    private final SimpleFunctionDescriptor findSetterOverride(PropertyDescriptor $this$findSetterOverride, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> function1) {
        SimpleFunctionDescriptor simpleFunctionDescriptor;
        KotlinType returnType;
        String asString = $this$findSetterOverride.getName().asString();
        Intrinsics.checkNotNullExpressionValue(asString, "asString(...)");
        Name identifier = Name.identifier(JvmAbi.setterName(asString));
        Intrinsics.checkNotNullExpressionValue(identifier, "identifier(...)");
        Iterator<T> it = function1.invoke(identifier).iterator();
        do {
            simpleFunctionDescriptor = null;
            if (!it.hasNext()) {
                break;
            }
            SimpleFunctionDescriptor descriptor = (SimpleFunctionDescriptor) it.next();
            if (descriptor.getValueParameters().size() == 1 && (returnType = descriptor.getReturnType()) != null && KotlinBuiltIns.isUnit(returnType)) {
                KotlinTypeChecker kotlinTypeChecker = KotlinTypeChecker.DEFAULT;
                List<ValueParameterDescriptor> valueParameters = descriptor.getValueParameters();
                Intrinsics.checkNotNullExpressionValue(valueParameters, "getValueParameters(...)");
                if (kotlinTypeChecker.equalTypes(((ValueParameterDescriptor) CollectionsKt.single((List<? extends Object>) valueParameters)).getType(), $this$findSetterOverride.getType())) {
                    simpleFunctionDescriptor = descriptor;
                    continue;
                } else {
                    continue;
                }
            }
        } while (simpleFunctionDescriptor == null);
        return simpleFunctionDescriptor;
    }

    private final boolean doesClassOverridesProperty(PropertyDescriptor property, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> function1) {
        if (JavaDescriptorUtilKt.isJavaField(property)) {
            return false;
        }
        SimpleFunctionDescriptor getter = findGetterOverride(property, function1);
        SimpleFunctionDescriptor setter = findSetterOverride(property, function1);
        if (getter == null) {
            return false;
        }
        if (property.isVar()) {
            return setter != null && setter.getModality() == getter.getModality();
        }
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    protected void computeNonDeclaredFunctions(Collection<SimpleFunctionDescriptor> result, Name name) {
        Iterable $this$none$iv;
        Intrinsics.checkNotNullParameter(result, "result");
        Intrinsics.checkNotNullParameter(name, "name");
        Iterable functionsFromSupertypes = getFunctionsFromSupertypes(name);
        if (!SpecialGenericSignatures.Companion.getSameAsRenamedInJvmBuiltin(name) && !BuiltinMethodsWithSpecialGenericSignature.INSTANCE.getSameAsBuiltinMethodWithErasedValueParameters(name)) {
            Iterable $this$none$iv2 = functionsFromSupertypes;
            if (!($this$none$iv2 instanceof Collection) || !((Collection) $this$none$iv2).isEmpty()) {
                Iterator<T> it = $this$none$iv2.iterator();
                while (true) {
                    if (it.hasNext()) {
                        Object element$iv = it.next();
                        FunctionDescriptor p0 = (FunctionDescriptor) element$iv;
                        if (p0.isSuspend()) {
                            $this$none$iv = null;
                            break;
                        }
                    } else {
                        $this$none$iv = 1;
                        break;
                    }
                }
            } else {
                $this$none$iv = 1;
            }
            if ($this$none$iv != null) {
                Iterable $this$filter$iv = functionsFromSupertypes;
                Collection destination$iv$iv = new ArrayList();
                for (Object element$iv$iv : $this$filter$iv) {
                    SimpleFunctionDescriptor it2 = (SimpleFunctionDescriptor) element$iv$iv;
                    if (isVisibleAsFunctionInCurrentClass(it2)) {
                        destination$iv$iv.add(element$iv$iv);
                    }
                }
                addFunctionFromSupertypes(result, name, (List) destination$iv$iv, false);
                return;
            }
        }
        SmartSet specialBuiltinsFromSuperTypes = SmartSet.Companion.create();
        Collection mergedFunctionFromSuperTypes = DescriptorResolverUtils.resolveOverridesForNonStaticMembers(name, (Collection) functionsFromSupertypes, CollectionsKt.emptyList(), getOwnerDescriptor(), ErrorReporter.DO_NOTHING, getC().getComponents().getKotlinTypeChecker().getOverridingUtil());
        Intrinsics.checkNotNullExpressionValue(mergedFunctionFromSuperTypes, "resolveOverridesForNonStaticMembers(...)");
        addOverriddenSpecialMethods(name, result, mergedFunctionFromSuperTypes, result, new LazyJavaClassMemberScope$computeNonDeclaredFunctions$3(this));
        addOverriddenSpecialMethods(name, result, mergedFunctionFromSuperTypes, specialBuiltinsFromSuperTypes, new LazyJavaClassMemberScope$computeNonDeclaredFunctions$4(this));
        Iterable $this$filter$iv2 = functionsFromSupertypes;
        Collection destination$iv$iv2 = new ArrayList();
        for (Object element$iv$iv2 : $this$filter$iv2) {
            SimpleFunctionDescriptor it3 = (SimpleFunctionDescriptor) element$iv$iv2;
            if (isVisibleAsFunctionInCurrentClass(it3)) {
                destination$iv$iv2.add(element$iv$iv2);
            }
        }
        List visibleFunctionsFromSupertypes = CollectionsKt.plus((List) destination$iv$iv2, (Iterable) specialBuiltinsFromSuperTypes);
        addFunctionFromSupertypes(result, name, visibleFunctionsFromSupertypes, true);
    }

    private final void addFunctionFromSupertypes(Collection<SimpleFunctionDescriptor> collection, Name name, Collection<? extends SimpleFunctionDescriptor> collection2, boolean isSpecialBuiltinName) {
        Collection additionalOverrides = DescriptorResolverUtils.resolveOverridesForNonStaticMembers(name, collection2, collection, getOwnerDescriptor(), getC().getComponents().getErrorReporter(), getC().getComponents().getKotlinTypeChecker().getOverridingUtil());
        Intrinsics.checkNotNullExpressionValue(additionalOverrides, "resolveOverridesForNonStaticMembers(...)");
        if (isSpecialBuiltinName) {
            List allDescriptors = CollectionsKt.plus((Collection) collection, (Iterable) additionalOverrides);
            Collection $this$map$iv = additionalOverrides;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                SimpleFunctionDescriptor resolvedOverride = (SimpleFunctionDescriptor) item$iv$iv;
                SimpleFunctionDescriptor overriddenBuiltin = (SimpleFunctionDescriptor) SpecialBuiltinMembers.getOverriddenSpecialBuiltin(resolvedOverride);
                if (overriddenBuiltin == null) {
                    Intrinsics.checkNotNull(resolvedOverride);
                } else {
                    Intrinsics.checkNotNull(resolvedOverride);
                    resolvedOverride = createHiddenCopyIfBuiltinAlreadyAccidentallyOverridden(resolvedOverride, overriddenBuiltin, allDescriptors);
                }
                destination$iv$iv.add(resolvedOverride);
            }
            collection.addAll((List) destination$iv$iv);
            return;
        }
        collection.addAll(additionalOverrides);
    }

    private final void addOverriddenSpecialMethods(Name name, Collection<? extends SimpleFunctionDescriptor> collection, Collection<? extends SimpleFunctionDescriptor> collection2, Collection<SimpleFunctionDescriptor> collection3, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> function1) {
        for (SimpleFunctionDescriptor descriptor : collection2) {
            kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.addIfNotNull(collection3, obtainOverrideForBuiltinWithDifferentJvmName(descriptor, function1, name, collection));
            kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.addIfNotNull(collection3, obtainOverrideForBuiltInWithErasedValueParametersInJava(descriptor, function1, collection));
            kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.addIfNotNull(collection3, obtainOverrideForSuspend(descriptor, function1));
        }
    }

    private final SimpleFunctionDescriptor obtainOverrideForBuiltInWithErasedValueParametersInJava(SimpleFunctionDescriptor descriptor, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> function1, Collection<? extends SimpleFunctionDescriptor> collection) {
        SimpleFunctionDescriptor p0;
        FunctionDescriptor overriddenBuiltin = BuiltinMethodsWithSpecialGenericSignature.getOverriddenBuiltinFunctionWithErasedValueParametersInJava(descriptor);
        if (overriddenBuiltin == null || (p0 = createOverrideForBuiltinFunctionWithErasedParameterIfNeeded(overriddenBuiltin, function1)) == null) {
            return null;
        }
        if (!isVisibleAsFunctionInCurrentClass(p0)) {
            p0 = null;
        }
        if (p0 != null) {
            return createHiddenCopyIfBuiltinAlreadyAccidentallyOverridden(p0, overriddenBuiltin, collection);
        }
        return null;
    }

    private final SimpleFunctionDescriptor obtainOverrideForBuiltinWithDifferentJvmName(SimpleFunctionDescriptor descriptor, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> function1, Name name, Collection<? extends SimpleFunctionDescriptor> collection) {
        SimpleFunctionDescriptor overriddenBuiltin = (SimpleFunctionDescriptor) SpecialBuiltinMembers.getOverriddenBuiltinWithDifferentJvmName(descriptor);
        if (overriddenBuiltin == null) {
            return null;
        }
        String nameInJava = SpecialBuiltinMembers.getJvmMethodNameIfSpecial(overriddenBuiltin);
        Intrinsics.checkNotNull(nameInJava);
        Name identifier = Name.identifier(nameInJava);
        Intrinsics.checkNotNullExpressionValue(identifier, "identifier(...)");
        for (SimpleFunctionDescriptor method : function1.invoke(identifier)) {
            SimpleFunctionDescriptor renamedCopy = createRenamedCopy(method, name);
            if (doesOverrideRenamedDescriptor(overriddenBuiltin, renamedCopy)) {
                return createHiddenCopyIfBuiltinAlreadyAccidentallyOverridden(renamedCopy, overriddenBuiltin, collection);
            }
        }
        return null;
    }

    private final SimpleFunctionDescriptor obtainOverrideForSuspend(SimpleFunctionDescriptor descriptor, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> function1) {
        if (descriptor.isSuspend()) {
            Name name = descriptor.getName();
            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
            for (SimpleFunctionDescriptor overrideCandidate : function1.invoke(name)) {
                SimpleFunctionDescriptor suspendView = createSuspendView(overrideCandidate);
                if (suspendView == null || !doesOverride(suspendView, descriptor)) {
                    suspendView = null;
                    continue;
                }
                if (suspendView != null) {
                    return suspendView;
                }
            }
            return null;
        }
        return null;
    }

    private final SimpleFunctionDescriptor createHiddenCopyIfBuiltinAlreadyAccidentallyOverridden(SimpleFunctionDescriptor $this$createHiddenCopyIfBuiltinAlreadyAccidentallyOverridden, CallableDescriptor specialBuiltin, Collection<? extends SimpleFunctionDescriptor> collection) {
        SimpleFunctionDescriptor it;
        Collection<? extends SimpleFunctionDescriptor> $this$none$iv = collection;
        boolean z = true;
        if (!($this$none$iv instanceof Collection) || !$this$none$iv.isEmpty()) {
            Iterator<T> it2 = $this$none$iv.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Object element$iv = it2.next();
                SimpleFunctionDescriptor it3 = (SimpleFunctionDescriptor) element$iv;
                if (!Intrinsics.areEqual($this$createHiddenCopyIfBuiltinAlreadyAccidentallyOverridden, it3) && it3.getInitialSignatureDescriptor() == null && doesOverride(it3, specialBuiltin)) {
                    it = 1;
                    continue;
                } else {
                    it = null;
                    continue;
                }
                if (it != null) {
                    z = false;
                    break;
                }
            }
        }
        if (z) {
            return $this$createHiddenCopyIfBuiltinAlreadyAccidentallyOverridden;
        }
        SimpleFunctionDescriptor build = $this$createHiddenCopyIfBuiltinAlreadyAccidentallyOverridden.newCopyBuilder().setHiddenToOvercomeSignatureClash().build();
        Intrinsics.checkNotNull(build);
        return build;
    }

    private final SimpleFunctionDescriptor createOverrideForBuiltinFunctionWithErasedParameterIfNeeded(FunctionDescriptor overridden, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> function1) {
        Object element$iv;
        Name name = overridden.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        Iterable $this$firstOrNull$iv = function1.invoke(name);
        Iterator<T> it = $this$firstOrNull$iv.iterator();
        while (true) {
            if (!it.hasNext()) {
                element$iv = null;
                break;
            }
            element$iv = it.next();
            SimpleFunctionDescriptor it2 = (SimpleFunctionDescriptor) element$iv;
            if (hasSameJvmDescriptorButDoesNotOverride(it2, overridden)) {
                break;
            }
        }
        SimpleFunctionDescriptor override = (SimpleFunctionDescriptor) element$iv;
        if (override != null) {
            FunctionDescriptor.CopyBuilder $this$createOverrideForBuiltinFunctionWithErasedParameterIfNeeded_u24lambda_u241_u240 = override.newCopyBuilder();
            Iterable valueParameters = overridden.getValueParameters();
            Intrinsics.checkNotNullExpressionValue(valueParameters, "getValueParameters(...)");
            Iterable $this$map$iv = valueParameters;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                ValueParameterDescriptor p0 = (ValueParameterDescriptor) item$iv$iv;
                destination$iv$iv.add(p0.getType());
            }
            List<ValueParameterDescriptor> valueParameters2 = override.getValueParameters();
            Intrinsics.checkNotNullExpressionValue(valueParameters2, "getValueParameters(...)");
            $this$createOverrideForBuiltinFunctionWithErasedParameterIfNeeded_u24lambda_u241_u240.setValueParameters(UtilKt.copyValueParameters((List) destination$iv$iv, valueParameters2, overridden));
            $this$createOverrideForBuiltinFunctionWithErasedParameterIfNeeded_u24lambda_u241_u240.setSignatureChange();
            $this$createOverrideForBuiltinFunctionWithErasedParameterIfNeeded_u24lambda_u241_u240.setPreserveSourceElement();
            $this$createOverrideForBuiltinFunctionWithErasedParameterIfNeeded_u24lambda_u241_u240.putUserData(JavaMethodDescriptor.HAS_ERASED_VALUE_PARAMETERS, true);
            return $this$createOverrideForBuiltinFunctionWithErasedParameterIfNeeded_u24lambda_u241_u240.build();
        }
        return null;
    }

    private final Set<SimpleFunctionDescriptor> getFunctionsFromSupertypes(Name name) {
        Iterable $this$flatMapTo$iv = computeSupertypes();
        Collection destination$iv = new LinkedHashSet();
        for (Object element$iv : $this$flatMapTo$iv) {
            KotlinType it = (KotlinType) element$iv;
            Iterable list$iv = it.getMemberScope().getContributedFunctions(name, NoLookupLocation.WHEN_GET_SUPER_MEMBERS);
            CollectionsKt.addAll(destination$iv, list$iv);
        }
        return (Set) destination$iv;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    protected void computeImplicitlyDeclaredFunctions(Collection<SimpleFunctionDescriptor> result, Name name) {
        Intrinsics.checkNotNullParameter(result, "result");
        Intrinsics.checkNotNullParameter(name, "name");
        if (this.jClass.isRecord() && getDeclaredMemberIndex().invoke().findRecordComponentByName(name) != null) {
            Collection<SimpleFunctionDescriptor> $this$none$iv = result;
            boolean z = true;
            if (!$this$none$iv.isEmpty()) {
                Iterator<T> it = $this$none$iv.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Object element$iv = it.next();
                    SimpleFunctionDescriptor it2 = (SimpleFunctionDescriptor) element$iv;
                    if (it2.getValueParameters().isEmpty()) {
                        z = false;
                        break;
                    }
                }
            }
            if (z) {
                JavaRecordComponent findRecordComponentByName = getDeclaredMemberIndex().invoke().findRecordComponentByName(name);
                Intrinsics.checkNotNull(findRecordComponentByName);
                result.add(resolveRecordComponentToFunctionDescriptor(findRecordComponentByName));
            }
        }
        getC().getComponents().getSyntheticPartsProvider().generateMethods(getOwnerDescriptor(), name, result, getC());
    }

    private final JavaMethodDescriptor resolveRecordComponentToFunctionDescriptor(JavaRecordComponent recordComponent) {
        Annotations annotations = LazyJavaAnnotationsKt.resolveAnnotations(getC(), recordComponent);
        JavaMethodDescriptor functionDescriptorImpl = JavaMethodDescriptor.createJavaMethod(getOwnerDescriptor(), annotations, recordComponent.getName(), getC().getComponents().getSourceElementFactory().source(recordComponent), true);
        Intrinsics.checkNotNullExpressionValue(functionDescriptorImpl, "createJavaMethod(...)");
        JavaTypeAttributes returnTypeAttrs = JavaTypeAttributesKt.toAttributes$default(TypeUsage.COMMON, false, false, null, 6, null);
        KotlinType returnType = getC().getTypeResolver().transformJavaType(recordComponent.getType(), returnTypeAttrs);
        functionDescriptorImpl.initialize(null, getDispatchReceiverParameter(), CollectionsKt.emptyList(), CollectionsKt.emptyList(), CollectionsKt.emptyList(), returnType, Modality.Companion.convertFromFlags(false, false, true), DescriptorVisibilities.PUBLIC, null);
        functionDescriptorImpl.setParameterNamesStatus(false, false);
        getC().getComponents().getJavaResolverCache().recordMethod(recordComponent, functionDescriptorImpl);
        return functionDescriptorImpl;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    protected void computeNonDeclaredProperties(Name name, Collection<PropertyDescriptor> result) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(result, "result");
        if (this.jClass.isAnnotationType()) {
            computeAnnotationProperties(name, result);
        }
        Set propertiesFromSupertypes = getPropertiesFromSupertypes(name);
        if (propertiesFromSupertypes.isEmpty()) {
            return;
        }
        SmartSet handledProperties = SmartSet.Companion.create();
        SmartSet propertiesOverridesFromSuperTypes = SmartSet.Companion.create();
        addPropertyOverrideByMethod(propertiesFromSupertypes, result, handledProperties, new Function1(this) { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope$$Lambda$7
            private final LazyJavaClassMemberScope arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                Collection computeNonDeclaredProperties$lambda$0;
                computeNonDeclaredProperties$lambda$0 = LazyJavaClassMemberScope.computeNonDeclaredProperties$lambda$0(this.arg$0, (Name) obj);
                return computeNonDeclaredProperties$lambda$0;
            }
        });
        addPropertyOverrideByMethod(SetsKt.minus(propertiesFromSupertypes, (Iterable) handledProperties), propertiesOverridesFromSuperTypes, null, new Function1(this) { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope$$Lambda$8
            private final LazyJavaClassMemberScope arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                Collection computeNonDeclaredProperties$lambda$1;
                computeNonDeclaredProperties$lambda$1 = LazyJavaClassMemberScope.computeNonDeclaredProperties$lambda$1(this.arg$0, (Name) obj);
                return computeNonDeclaredProperties$lambda$1;
            }
        });
        Collection<? extends PropertyDescriptor> resolveOverridesForNonStaticMembers = DescriptorResolverUtils.resolveOverridesForNonStaticMembers(name, SetsKt.plus(propertiesFromSupertypes, (Iterable) propertiesOverridesFromSuperTypes), result, getOwnerDescriptor(), getC().getComponents().getErrorReporter(), getC().getComponents().getKotlinTypeChecker().getOverridingUtil());
        Intrinsics.checkNotNullExpressionValue(resolveOverridesForNonStaticMembers, "resolveOverridesForNonStaticMembers(...)");
        result.addAll(resolveOverridesForNonStaticMembers);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Collection computeNonDeclaredProperties$lambda$0(LazyJavaClassMemberScope this$0, Name it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return this$0.searchMethodsByNameWithoutBuiltinMagic(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Collection computeNonDeclaredProperties$lambda$1(LazyJavaClassMemberScope this$0, Name it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return this$0.searchMethodsInSupertypesWithoutBuiltinMagic(it);
    }

    private final void addPropertyOverrideByMethod(Set<? extends PropertyDescriptor> set, Collection<PropertyDescriptor> collection, Set<PropertyDescriptor> set2, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> function1) {
        for (PropertyDescriptor property : set) {
            JavaPropertyDescriptor newProperty = createPropertyDescriptorByMethods(property, function1);
            if (newProperty != null) {
                collection.add(newProperty);
                if (set2 != null) {
                    set2.add(property);
                    return;
                }
                return;
            }
        }
    }

    private final void computeAnnotationProperties(Name name, Collection<PropertyDescriptor> collection) {
        JavaMethod method = (JavaMethod) CollectionsKt.singleOrNull(getDeclaredMemberIndex().invoke().findMethodsByName(name));
        if (method == null) {
            return;
        }
        collection.add(createPropertyDescriptorWithDefaultGetter$default(this, method, null, Modality.FINAL, 2, null));
    }

    static /* synthetic */ JavaPropertyDescriptor createPropertyDescriptorWithDefaultGetter$default(LazyJavaClassMemberScope lazyJavaClassMemberScope, JavaMethod javaMethod, KotlinType kotlinType, Modality modality, int i, Object obj) {
        if ((i & 2) != 0) {
            kotlinType = null;
        }
        return lazyJavaClassMemberScope.createPropertyDescriptorWithDefaultGetter(javaMethod, kotlinType, modality);
    }

    private final JavaPropertyDescriptor createPropertyDescriptorWithDefaultGetter(JavaMethod method, KotlinType givenType, Modality modality) {
        Annotations annotations = LazyJavaAnnotationsKt.resolveAnnotations(getC(), method);
        JavaPropertyDescriptor propertyDescriptor = JavaPropertyDescriptor.create(getOwnerDescriptor(), annotations, modality, UtilsKt.toDescriptorVisibility(method.getVisibility()), false, method.getName(), getC().getComponents().getSourceElementFactory().source(method), false);
        Intrinsics.checkNotNullExpressionValue(propertyDescriptor, "create(...)");
        PropertyGetterDescriptorImpl getter = DescriptorFactory.createDefaultGetter(propertyDescriptor, Annotations.Companion.getEMPTY());
        Intrinsics.checkNotNullExpressionValue(getter, "createDefaultGetter(...)");
        propertyDescriptor.initialize(getter, null);
        KotlinType returnType = givenType == null ? computeMethodReturnType(method, ContextKt.childForMethod$default(getC(), propertyDescriptor, method, 0, 4, null)) : givenType;
        propertyDescriptor.setType(returnType, CollectionsKt.emptyList(), getDispatchReceiverParameter(), null, CollectionsKt.emptyList());
        getter.initialize(returnType);
        return propertyDescriptor;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v13, types: [kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertySetterDescriptorImpl] */
    private final JavaPropertyDescriptor createPropertyDescriptorByMethods(PropertyDescriptor overriddenProperty, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> function1) {
        SimpleFunctionDescriptor setterMethod;
        if (doesClassOverridesProperty(overriddenProperty, function1)) {
            SimpleFunctionDescriptor getterMethod = findGetterOverride(overriddenProperty, function1);
            Intrinsics.checkNotNull(getterMethod);
            if (overriddenProperty.isVar()) {
                setterMethod = findSetterOverride(overriddenProperty, function1);
                Intrinsics.checkNotNull(setterMethod);
            } else {
                setterMethod = null;
            }
            boolean z = true;
            if (setterMethod != null) {
                SimpleFunctionDescriptor it = setterMethod;
                if (it.getModality() != getterMethod.getModality()) {
                    z = false;
                }
            }
            if (!z) {
                throw new AssertionError("Different accessors modalities when creating overrides for " + overriddenProperty + " in " + getOwnerDescriptor() + "for getter is " + getterMethod.getModality() + ", but for setter is " + (setterMethod != null ? setterMethod.getModality() : null));
            }
            JavaForKotlinOverridePropertyDescriptor propertyDescriptor = new JavaForKotlinOverridePropertyDescriptor(getOwnerDescriptor(), getterMethod, setterMethod, overriddenProperty);
            KotlinType returnType = getterMethod.getReturnType();
            Intrinsics.checkNotNull(returnType);
            propertyDescriptor.setType(returnType, CollectionsKt.emptyList(), getDispatchReceiverParameter(), null, CollectionsKt.emptyList());
            PropertyGetterDescriptorImpl getter = DescriptorFactory.createGetter(propertyDescriptor, getterMethod.getAnnotations(), false, false, false, getterMethod.getSource());
            getter.setInitialSignatureDescriptor(getterMethod);
            getter.initialize(propertyDescriptor.getType());
            Intrinsics.checkNotNullExpressionValue(getter, "apply(...)");
            if (setterMethod != null) {
                List<ValueParameterDescriptor> valueParameters = setterMethod.getValueParameters();
                Intrinsics.checkNotNullExpressionValue(valueParameters, "getValueParameters(...)");
                ValueParameterDescriptor parameter = (ValueParameterDescriptor) CollectionsKt.firstOrNull((List<? extends Object>) valueParameters);
                if (parameter == null) {
                    throw new AssertionError("No parameter found for " + setterMethod);
                }
                ?? createSetter = DescriptorFactory.createSetter(propertyDescriptor, setterMethod.getAnnotations(), parameter.getAnnotations(), false, false, false, setterMethod.getVisibility(), setterMethod.getSource());
                createSetter.setInitialSignatureDescriptor(setterMethod);
                r2 = createSetter;
            }
            propertyDescriptor.initialize(getter, (PropertySetterDescriptor) r2);
            return propertyDescriptor;
        }
        return null;
    }

    private final Set<PropertyDescriptor> getPropertiesFromSupertypes(Name name) {
        Iterable $this$flatMap$iv = computeSupertypes();
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$flatMap$iv) {
            KotlinType it = (KotlinType) element$iv$iv;
            Iterable $this$map$iv = it.getMemberScope().getContributedVariables(name, NoLookupLocation.WHEN_GET_SUPER_MEMBERS);
            Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                Iterable $this$flatMap$iv2 = $this$flatMap$iv;
                PropertyDescriptor p = (PropertyDescriptor) item$iv$iv;
                destination$iv$iv2.add(p);
                $this$flatMap$iv = $this$flatMap$iv2;
            }
            Iterable $this$flatMap$iv3 = $this$flatMap$iv;
            Iterable list$iv$iv = (List) destination$iv$iv2;
            CollectionsKt.addAll(destination$iv$iv, list$iv$iv);
            $this$flatMap$iv = $this$flatMap$iv3;
        }
        return CollectionsKt.toSet((List) destination$iv$iv);
    }

    private final Collection<KotlinType> computeSupertypes() {
        if (this.skipRefinement) {
            Collection<KotlinType> mo1172getSupertypes = getOwnerDescriptor().getTypeConstructor().mo1172getSupertypes();
            Intrinsics.checkNotNullExpressionValue(mo1172getSupertypes, "getSupertypes(...)");
            return mo1172getSupertypes;
        }
        return getC().getComponents().getKotlinTypeChecker().getKotlinTypeRefiner().refineSupertypes(getOwnerDescriptor());
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    protected LazyJavaScope.MethodSignatureData resolveMethodSignature(JavaMethod method, List<? extends TypeParameterDescriptor> methodTypeParameters, KotlinType returnType, List<? extends ValueParameterDescriptor> valueParameters) {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(methodTypeParameters, "methodTypeParameters");
        Intrinsics.checkNotNullParameter(returnType, "returnType");
        Intrinsics.checkNotNullParameter(valueParameters, "valueParameters");
        SignaturePropagator.PropagatedSignature propagated = getC().getComponents().getSignaturePropagator().resolvePropagatedSignature(method, getOwnerDescriptor(), returnType, null, valueParameters, methodTypeParameters);
        Intrinsics.checkNotNullExpressionValue(propagated, "resolvePropagatedSignature(...)");
        KotlinType returnType2 = propagated.getReturnType();
        Intrinsics.checkNotNullExpressionValue(returnType2, "getReturnType(...)");
        KotlinType receiverType = propagated.getReceiverType();
        List<ValueParameterDescriptor> valueParameters2 = propagated.getValueParameters();
        Intrinsics.checkNotNullExpressionValue(valueParameters2, "getValueParameters(...)");
        List<TypeParameterDescriptor> typeParameters = propagated.getTypeParameters();
        Intrinsics.checkNotNullExpressionValue(typeParameters, "getTypeParameters(...)");
        boolean hasStableParameterNames = propagated.hasStableParameterNames();
        List<String> errors = propagated.getErrors();
        Intrinsics.checkNotNullExpressionValue(errors, "getErrors(...)");
        return new LazyJavaScope.MethodSignatureData(returnType2, receiverType, valueParameters2, typeParameters, hasStableParameterNames, errors);
    }

    private final boolean hasSameJvmDescriptorButDoesNotOverride(SimpleFunctionDescriptor $this$hasSameJvmDescriptorButDoesNotOverride, FunctionDescriptor builtinWithErasedParameters) {
        String computeJvmDescriptor$default = MethodSignatureMappingKt.computeJvmDescriptor$default($this$hasSameJvmDescriptorButDoesNotOverride, false, false, 2, null);
        FunctionDescriptor original = builtinWithErasedParameters.getOriginal();
        Intrinsics.checkNotNullExpressionValue(original, "getOriginal(...)");
        return Intrinsics.areEqual(computeJvmDescriptor$default, MethodSignatureMappingKt.computeJvmDescriptor$default(original, false, false, 2, null)) && !doesOverride($this$hasSameJvmDescriptorButDoesNotOverride, builtinWithErasedParameters);
    }

    private final JavaClassConstructorDescriptor resolveConstructor(JavaConstructor constructor) {
        ClassDescriptor classDescriptor = getOwnerDescriptor();
        JavaClassConstructorDescriptor constructorDescriptor = JavaClassConstructorDescriptor.createJavaConstructor(classDescriptor, LazyJavaAnnotationsKt.resolveAnnotations(getC(), constructor), false, getC().getComponents().getSourceElementFactory().source(constructor));
        Intrinsics.checkNotNullExpressionValue(constructorDescriptor, "createJavaConstructor(...)");
        LazyJavaResolverContext c = ContextKt.childForMethod(getC(), constructorDescriptor, constructor, classDescriptor.getDeclaredTypeParameters().size());
        LazyJavaScope.ResolvedValueParameters valueParameters = resolveValueParameters(c, constructorDescriptor, constructor.getValueParameters());
        List<TypeParameterDescriptor> declaredTypeParameters = classDescriptor.getDeclaredTypeParameters();
        Intrinsics.checkNotNullExpressionValue(declaredTypeParameters, "getDeclaredTypeParameters(...)");
        List<TypeParameterDescriptor> list = declaredTypeParameters;
        Iterable $this$map$iv = constructor.getTypeParameters();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            JavaTypeParameter p = (JavaTypeParameter) item$iv$iv;
            TypeParameterDescriptor resolveTypeParameter = c.getTypeParameterResolver().resolveTypeParameter(p);
            Intrinsics.checkNotNull(resolveTypeParameter);
            destination$iv$iv.add(resolveTypeParameter);
        }
        List constructorTypeParameters = CollectionsKt.plus((Collection) list, (Iterable) ((List) destination$iv$iv));
        constructorDescriptor.initialize(valueParameters.getDescriptors(), UtilsKt.toDescriptorVisibility(constructor.getVisibility()), constructorTypeParameters);
        constructorDescriptor.setHasStableParameterNames(false);
        constructorDescriptor.setHasSynthesizedParameterNames(valueParameters.getHasSynthesizedNames());
        constructorDescriptor.setReturnType(classDescriptor.getDefaultType());
        c.getComponents().getJavaResolverCache().recordConstructor(constructor, constructorDescriptor);
        return constructorDescriptor;
    }

    private final ClassConstructorDescriptor createDefaultConstructor() {
        boolean isAnnotation = this.jClass.isAnnotationType();
        if ((this.jClass.isInterface() || !this.jClass.hasDefaultConstructor()) && !isAnnotation) {
            return null;
        }
        ClassDescriptor classDescriptor = getOwnerDescriptor();
        JavaClassConstructorDescriptor constructorDescriptor = JavaClassConstructorDescriptor.createJavaConstructor(classDescriptor, Annotations.Companion.getEMPTY(), true, getC().getComponents().getSourceElementFactory().source(this.jClass));
        Intrinsics.checkNotNullExpressionValue(constructorDescriptor, "createJavaConstructor(...)");
        List valueParameters = isAnnotation ? createAnnotationConstructorParameters(constructorDescriptor) : Collections.emptyList();
        constructorDescriptor.setHasSynthesizedParameterNames(false);
        constructorDescriptor.initialize(valueParameters, getConstructorVisibility(classDescriptor));
        constructorDescriptor.setHasStableParameterNames(true);
        constructorDescriptor.setReturnType(classDescriptor.getDefaultType());
        getC().getComponents().getJavaResolverCache().recordConstructor(this.jClass, constructorDescriptor);
        return constructorDescriptor;
    }

    private final DescriptorVisibility getConstructorVisibility(ClassDescriptor classDescriptor) {
        DescriptorVisibility visibility = classDescriptor.getVisibility();
        Intrinsics.checkNotNullExpressionValue(visibility, "getVisibility(...)");
        if (Intrinsics.areEqual(visibility, JavaDescriptorVisibilities.PROTECTED_STATIC_VISIBILITY)) {
            DescriptorVisibility PROTECTED_AND_PACKAGE = JavaDescriptorVisibilities.PROTECTED_AND_PACKAGE;
            Intrinsics.checkNotNullExpressionValue(PROTECTED_AND_PACKAGE, "PROTECTED_AND_PACKAGE");
            return PROTECTED_AND_PACKAGE;
        }
        return visibility;
    }

    private final List<ValueParameterDescriptor> createAnnotationConstructorParameters(ClassConstructorDescriptorImpl constructor) {
        Pair pair;
        Collection methods = this.jClass.getMethods();
        ArrayList result = new ArrayList(methods.size());
        JavaTypeAttributes attr = JavaTypeAttributesKt.toAttributes$default(TypeUsage.COMMON, true, false, null, 6, null);
        Collection $this$partition$iv = methods;
        ArrayList first$iv = new ArrayList();
        ArrayList second$iv = new ArrayList();
        for (Object element$iv : $this$partition$iv) {
            JavaMethod it = (JavaMethod) element$iv;
            if (Intrinsics.areEqual(it.getName(), JvmAnnotationNames.DEFAULT_ANNOTATION_MEMBER_NAME)) {
                first$iv.add(element$iv);
            } else {
                second$iv.add(element$iv);
            }
        }
        Pair pair2 = new Pair(first$iv, second$iv);
        List methodsNamedValue = (List) pair2.component1();
        List<JavaMethod> otherMethods = (List) pair2.component2();
        int i = 0;
        if (!(methodsNamedValue.size() <= 1)) {
            throw new AssertionError("There can't be more than one method named 'value' in annotation class: " + this.jClass);
        }
        JavaMethod methodNamedValue = (JavaMethod) CollectionsKt.firstOrNull((List<? extends Object>) methodsNamedValue);
        if (methodNamedValue != null) {
            JavaType parameterNamedValueJavaType = methodNamedValue.getReturnType();
            if (parameterNamedValueJavaType instanceof JavaArrayType) {
                pair = new Pair(getC().getTypeResolver().transformArrayType((JavaArrayType) parameterNamedValueJavaType, attr, true), getC().getTypeResolver().transformJavaType(((JavaArrayType) parameterNamedValueJavaType).getComponentType(), attr));
            } else {
                pair = new Pair(getC().getTypeResolver().transformJavaType(parameterNamedValueJavaType, attr), (Object) null);
            }
            KotlinType parameterType = (KotlinType) pair.component1();
            KotlinType varargType = (KotlinType) pair.component2();
            addAnnotationValueParameter(result, constructor, 0, methodNamedValue, parameterType, varargType);
        }
        int startIndex = methodNamedValue != null ? 1 : 0;
        for (JavaMethod method : otherMethods) {
            int index = i;
            i++;
            KotlinType parameterType2 = getC().getTypeResolver().transformJavaType(method.getReturnType(), attr);
            addAnnotationValueParameter(result, constructor, index + startIndex, method, parameterType2, null);
        }
        return result;
    }

    private final void addAnnotationValueParameter(List<ValueParameterDescriptor> list, ConstructorDescriptor constructor, int index, JavaMethod method, KotlinType returnType, KotlinType varargElementType) {
        KotlinType kotlinType;
        ConstructorDescriptor constructorDescriptor = constructor;
        Annotations empty = Annotations.Companion.getEMPTY();
        Name name = method.getName();
        KotlinType makeNotNullable = TypeUtils.makeNotNullable(returnType);
        Intrinsics.checkNotNullExpressionValue(makeNotNullable, "makeNotNullable(...)");
        boolean hasAnnotationParameterDefaultValue = method.getHasAnnotationParameterDefaultValue();
        if (varargElementType != null) {
            KotlinType it = TypeUtils.makeNotNullable(varargElementType);
            kotlinType = it;
        } else {
            kotlinType = null;
        }
        list.add(new ValueParameterDescriptorImpl(constructorDescriptor, null, index, empty, name, makeNotNullable, hasAnnotationParameterDefaultValue, false, false, kotlinType, getC().getComponents().getSourceElementFactory().source(method)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Set nestedClassIndex$lambda$0(LazyJavaClassMemberScope this$0) {
        return CollectionsKt.toSet(this$0.jClass.getInnerClassNames());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Set generatedNestedClassNames$lambda$0(LazyJavaResolverContext $c, LazyJavaClassMemberScope this$0) {
        return CollectionsKt.toSet($c.getComponents().getSyntheticPartsProvider().getNestedClassNames(this$0.getOwnerDescriptor(), $c));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map enumEntryIndex$lambda$0(LazyJavaClassMemberScope this$0) {
        Iterable $this$filter$iv = this$0.jClass.getFields();
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            JavaField it = (JavaField) element$iv$iv;
            if (it.isEnumEntry()) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        Iterable $this$associateBy$iv = (List) destination$iv$iv;
        int capacity$iv = RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associateBy$iv, 10)), 16);
        Map destination$iv$iv2 = new LinkedHashMap(capacity$iv);
        for (Object element$iv$iv2 : $this$associateBy$iv) {
            JavaField f = (JavaField) element$iv$iv2;
            destination$iv$iv2.put(f.getName(), element$iv$iv2);
        }
        return destination$iv$iv2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ClassDescriptor nestedClasses$lambda$0(final LazyJavaClassMemberScope this$0, LazyJavaResolverContext $c, Name name) {
        Intrinsics.checkNotNullParameter(name, "name");
        ClassDescriptor classDescriptor = null;
        if (this$0.nestedClassIndex.invoke().contains(name)) {
            JavaClassFinder finder = $c.getComponents().getFinder();
            ClassId classId = DescriptorUtilsKt.getClassId(this$0.getOwnerDescriptor());
            Intrinsics.checkNotNull(classId);
            JavaClass it = finder.findClass(new JavaClassFinder.Request(classId.createNestedClassId(name), null, this$0.jClass, 2, null));
            if (it != null) {
                JavaClassDescriptor lazyJavaClassDescriptor = new LazyJavaClassDescriptor($c, this$0.getOwnerDescriptor(), it, null, 8, null);
                JavaClassDescriptor p0 = lazyJavaClassDescriptor;
                $c.getComponents().getJavaClassesTracker().reportClass(p0);
                classDescriptor = lazyJavaClassDescriptor;
            }
            return classDescriptor;
        } else if (this$0.generatedNestedClassNames.invoke().contains(name)) {
            List $this$nestedClasses_u24lambda_u240_u241_u240 = CollectionsKt.createListBuilder();
            $c.getComponents().getSyntheticPartsProvider().generateNestedClass(this$0.getOwnerDescriptor(), name, $this$nestedClasses_u24lambda_u240_u241_u240, $c);
            List classes = CollectionsKt.build($this$nestedClasses_u24lambda_u240_u241_u240);
            switch (classes.size()) {
                case 0:
                    return null;
                case 1:
                    return (ClassDescriptor) CollectionsKt.single((List<? extends Object>) classes);
                default:
                    throw new IllegalStateException(("Multiple classes with same name are generated: " + classes).toString());
            }
        } else {
            JavaField field = this$0.enumEntryIndex.invoke().get(name);
            if (field != null) {
                NotNullLazyValue enumMemberNames = $c.getStorageManager().createLazyValue(new Function0(this$0) { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope$$Lambda$9
                    private final LazyJavaClassMemberScope arg$0;

                    {
                        this.arg$0 = this$0;
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public Object invoke() {
                        Set nestedClasses$lambda$0$2;
                        nestedClasses$lambda$0$2 = LazyJavaClassMemberScope.nestedClasses$lambda$0$2(this.arg$0);
                        return nestedClasses$lambda$0$2;
                    }
                });
                classDescriptor = EnumEntrySyntheticClassDescriptor.create($c.getStorageManager(), this$0.getOwnerDescriptor(), name, enumMemberNames, LazyJavaAnnotationsKt.resolveAnnotations($c, field), $c.getComponents().getSourceElementFactory().source(field));
            }
            return classDescriptor;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Set nestedClasses$lambda$0$2(LazyJavaClassMemberScope this$0) {
        return SetsKt.plus((Set) this$0.getFunctionNames(), (Iterable) this$0.getVariableNames());
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    protected ReceiverParameterDescriptor getDispatchReceiverParameter() {
        return DescriptorUtils.getDispatchReceiverParameterIfNeeded(getOwnerDescriptor());
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    /* renamed from: getContributedClassifier */
    public ClassifierDescriptor mo1173getContributedClassifier(Name name, LookupLocation location2) {
        ClassDescriptor invoke;
        MemoizedFunctionToNullable<Name, ClassDescriptor> memoizedFunctionToNullable;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(location2, "location");
        mo1177recordLookup(name, location2);
        LazyJavaClassMemberScope lazyJavaClassMemberScope = (LazyJavaClassMemberScope) getMainScope();
        if (lazyJavaClassMemberScope == null || (memoizedFunctionToNullable = lazyJavaClassMemberScope.nestedClasses) == null || (invoke = memoizedFunctionToNullable.invoke(name)) == null) {
            invoke = this.nestedClasses.invoke(name);
        }
        return invoke;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public Collection<SimpleFunctionDescriptor> getContributedFunctions(Name name, LookupLocation location2) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(location2, "location");
        mo1177recordLookup(name, location2);
        return super.getContributedFunctions(name, location2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Collection<PropertyDescriptor> getContributedVariables(Name name, LookupLocation location2) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(location2, "location");
        mo1177recordLookup(name, location2);
        return super.getContributedVariables(name, location2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    protected Set<Name> computeClassNames(DescriptorKindFilter kindFilter, Function1<? super Name, Boolean> function1) {
        Intrinsics.checkNotNullParameter(kindFilter, "kindFilter");
        return SetsKt.plus((Set) this.nestedClassIndex.invoke(), (Iterable) this.enumEntryIndex.invoke().keySet());
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    protected Set<Name> computePropertyNames(DescriptorKindFilter kindFilter, Function1<? super Name, Boolean> function1) {
        Intrinsics.checkNotNullParameter(kindFilter, "kindFilter");
        if (this.jClass.isAnnotationType()) {
            return getFunctionNames();
        }
        Collection result = new LinkedHashSet(getDeclaredMemberIndex().invoke().getFieldNames());
        Iterable mo1172getSupertypes = getOwnerDescriptor().getTypeConstructor().mo1172getSupertypes();
        Intrinsics.checkNotNullExpressionValue(mo1172getSupertypes, "getSupertypes(...)");
        Iterable $this$flatMapTo$iv = mo1172getSupertypes;
        Collection destination$iv = result;
        for (Object element$iv : $this$flatMapTo$iv) {
            KotlinType supertype = (KotlinType) element$iv;
            Iterable list$iv = supertype.getMemberScope().getVariableNames();
            CollectionsKt.addAll(destination$iv, list$iv);
        }
        return (Set) destination$iv;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    /* renamed from: recordLookup */
    public void mo1177recordLookup(Name name, LookupLocation location2) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(location2, "location");
        kotlin.reflect.jvm.internal.impl.incremental.UtilsKt.record(getC().getComponents().getLookupTracker(), location2, getOwnerDescriptor(), name);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public String toString() {
        return "Lazy Java member scope for " + this.jClass.getFqName();
    }
}