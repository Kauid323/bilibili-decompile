package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import BottomSheetItemData$;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.UtilsKt;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaPropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.ContextKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotationsKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributes;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributesKt;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaValueParameter;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindExclude;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeUsage;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;

/* compiled from: LazyJavaScope.kt */
public abstract class LazyJavaScope extends MemberScopeImpl {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(LazyJavaScope.class, "functionNamesLazy", "getFunctionNamesLazy()Ljava/util/Set;", 0)), Reflection.property1(new PropertyReference1Impl(LazyJavaScope.class, "propertyNamesLazy", "getPropertyNamesLazy()Ljava/util/Set;", 0)), Reflection.property1(new PropertyReference1Impl(LazyJavaScope.class, "classNamesLazy", "getClassNamesLazy()Ljava/util/Set;", 0))};
    private final NotNullLazyValue<Collection<DeclarationDescriptor>> allDescriptors;
    private final LazyJavaResolverContext c;
    private final NotNullLazyValue classNamesLazy$delegate;
    private final MemoizedFunctionToNullable<Name, PropertyDescriptor> declaredField;
    private final MemoizedFunctionToNotNull<Name, Collection<SimpleFunctionDescriptor>> declaredFunctions;
    private final NotNullLazyValue<DeclaredMemberIndex> declaredMemberIndex;
    private final NotNullLazyValue functionNamesLazy$delegate;
    private final MemoizedFunctionToNotNull<Name, Collection<SimpleFunctionDescriptor>> functions;
    private final LazyJavaScope mainScope;
    private final MemoizedFunctionToNotNull<Name, List<PropertyDescriptor>> properties;
    private final NotNullLazyValue propertyNamesLazy$delegate;

    protected abstract Set<Name> computeClassNames(DescriptorKindFilter descriptorKindFilter, Function1<? super Name, Boolean> function1);

    protected abstract Set<Name> computeFunctionNames(DescriptorKindFilter descriptorKindFilter, Function1<? super Name, Boolean> function1);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract DeclaredMemberIndex computeMemberIndex();

    protected abstract void computeNonDeclaredFunctions(Collection<SimpleFunctionDescriptor> collection, Name name);

    protected abstract void computeNonDeclaredProperties(Name name, Collection<PropertyDescriptor> collection);

    protected abstract Set<Name> computePropertyNames(DescriptorKindFilter descriptorKindFilter, Function1<? super Name, Boolean> function1);

    protected abstract ReceiverParameterDescriptor getDispatchReceiverParameter();

    protected abstract DeclarationDescriptor getOwnerDescriptor();

    protected abstract MethodSignatureData resolveMethodSignature(JavaMethod javaMethod, List<? extends TypeParameterDescriptor> list, KotlinType kotlinType, List<? extends ValueParameterDescriptor> list2);

    public LazyJavaScope(LazyJavaResolverContext c, LazyJavaScope mainScope) {
        Intrinsics.checkNotNullParameter(c, "c");
        this.c = c;
        this.mainScope = mainScope;
        this.allDescriptors = this.c.getStorageManager().createRecursionTolerantLazyValue(new Function0(this) { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope$$Lambda$0
            private final LazyJavaScope arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                Collection allDescriptors$lambda$0;
                allDescriptors$lambda$0 = LazyJavaScope.allDescriptors$lambda$0(this.arg$0);
                return allDescriptors$lambda$0;
            }
        }, CollectionsKt.emptyList());
        this.declaredMemberIndex = this.c.getStorageManager().createLazyValue(new Function0(this) { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope$$Lambda$1
            private final LazyJavaScope arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                DeclaredMemberIndex computeMemberIndex;
                computeMemberIndex = this.arg$0.computeMemberIndex();
                return computeMemberIndex;
            }
        });
        this.declaredFunctions = this.c.getStorageManager().createMemoizedFunction(new Function1(this) { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope$$Lambda$2
            private final LazyJavaScope arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                Collection declaredFunctions$lambda$0;
                declaredFunctions$lambda$0 = LazyJavaScope.declaredFunctions$lambda$0(this.arg$0, (Name) obj);
                return declaredFunctions$lambda$0;
            }
        });
        this.declaredField = this.c.getStorageManager().createMemoizedFunctionWithNullableValues(new Function1(this) { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope$$Lambda$3
            private final LazyJavaScope arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                PropertyDescriptor declaredField$lambda$0;
                declaredField$lambda$0 = LazyJavaScope.declaredField$lambda$0(this.arg$0, (Name) obj);
                return declaredField$lambda$0;
            }
        });
        this.functions = this.c.getStorageManager().createMemoizedFunction(new Function1(this) { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope$$Lambda$4
            private final LazyJavaScope arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                Collection functions$lambda$0;
                functions$lambda$0 = LazyJavaScope.functions$lambda$0(this.arg$0, (Name) obj);
                return functions$lambda$0;
            }
        });
        this.functionNamesLazy$delegate = this.c.getStorageManager().createLazyValue(new Function0(this) { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope$$Lambda$5
            private final LazyJavaScope arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                Set functionNamesLazy_delegate$lambda$0;
                functionNamesLazy_delegate$lambda$0 = LazyJavaScope.functionNamesLazy_delegate$lambda$0(this.arg$0);
                return functionNamesLazy_delegate$lambda$0;
            }
        });
        this.propertyNamesLazy$delegate = this.c.getStorageManager().createLazyValue(new Function0(this) { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope$$Lambda$6
            private final LazyJavaScope arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                Set propertyNamesLazy_delegate$lambda$0;
                propertyNamesLazy_delegate$lambda$0 = LazyJavaScope.propertyNamesLazy_delegate$lambda$0(this.arg$0);
                return propertyNamesLazy_delegate$lambda$0;
            }
        });
        this.classNamesLazy$delegate = this.c.getStorageManager().createLazyValue(new Function0(this) { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope$$Lambda$7
            private final LazyJavaScope arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                Set classNamesLazy_delegate$lambda$0;
                classNamesLazy_delegate$lambda$0 = LazyJavaScope.classNamesLazy_delegate$lambda$0(this.arg$0);
                return classNamesLazy_delegate$lambda$0;
            }
        });
        this.properties = this.c.getStorageManager().createMemoizedFunction(new Function1(this) { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope$$Lambda$8
            private final LazyJavaScope arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                List properties$lambda$0;
                properties$lambda$0 = LazyJavaScope.properties$lambda$0(this.arg$0, (Name) obj);
                return properties$lambda$0;
            }
        });
    }

    public /* synthetic */ LazyJavaScope(LazyJavaResolverContext lazyJavaResolverContext, LazyJavaScope lazyJavaScope, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(lazyJavaResolverContext, (i & 2) != 0 ? null : lazyJavaScope);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LazyJavaResolverContext getC() {
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LazyJavaScope getMainScope() {
        return this.mainScope;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final NotNullLazyValue<Collection<DeclarationDescriptor>> getAllDescriptors() {
        return this.allDescriptors;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Collection allDescriptors$lambda$0(LazyJavaScope this$0) {
        return this$0.computeDescriptors(DescriptorKindFilter.ALL, MemberScope.Companion.getALL_NAME_FILTER());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final NotNullLazyValue<DeclaredMemberIndex> getDeclaredMemberIndex() {
        return this.declaredMemberIndex;
    }

    protected void computeImplicitlyDeclaredFunctions(Collection<SimpleFunctionDescriptor> result, Name name) {
        Intrinsics.checkNotNullParameter(result, "result");
        Intrinsics.checkNotNullParameter(name, "name");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Collection declaredFunctions$lambda$0(LazyJavaScope this$0, Name name) {
        Intrinsics.checkNotNullParameter(name, "name");
        if (this$0.mainScope != null) {
            return this$0.mainScope.declaredFunctions.invoke(name);
        }
        List result = new ArrayList();
        for (JavaMethod method : this$0.declaredMemberIndex.invoke().findMethodsByName(name)) {
            JavaMethodDescriptor descriptor = this$0.resolveMethodToFunctionDescriptor(method);
            if (this$0.isVisibleAsFunction(descriptor)) {
                this$0.c.getComponents().getJavaResolverCache().recordMethod(method, descriptor);
                result.add(descriptor);
            }
        }
        this$0.computeImplicitlyDeclaredFunctions(result, name);
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PropertyDescriptor declaredField$lambda$0(LazyJavaScope this$0, Name name) {
        Intrinsics.checkNotNullParameter(name, "name");
        if (this$0.mainScope != null) {
            return this$0.mainScope.declaredField.invoke(name);
        }
        JavaField field = this$0.declaredMemberIndex.invoke().findFieldByName(name);
        if (field != null && !field.isEnumEntry()) {
            return this$0.resolveProperty(field);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Collection functions$lambda$0(LazyJavaScope this$0, Name name) {
        Intrinsics.checkNotNullParameter(name, "name");
        LinkedHashSet result = new LinkedHashSet(this$0.declaredFunctions.invoke(name));
        this$0.retainMostSpecificMethods(result);
        this$0.computeNonDeclaredFunctions(result, name);
        return CollectionsKt.toList(this$0.c.getComponents().getSignatureEnhancement().enhanceSignatures(this$0.c, result));
    }

    private final void retainMostSpecificMethods(Set<SimpleFunctionDescriptor> set) {
        ArrayList arrayList;
        Set<SimpleFunctionDescriptor> $this$groupBy$iv = set;
        Map destination$iv$iv = new LinkedHashMap();
        for (Object element$iv$iv : $this$groupBy$iv) {
            SimpleFunctionDescriptor it = (SimpleFunctionDescriptor) element$iv$iv;
            String computeJvmDescriptor$default = MethodSignatureMappingKt.computeJvmDescriptor$default(it, false, false, 2, null);
            Object value$iv$iv$iv = destination$iv$iv.get(computeJvmDescriptor$default);
            if (value$iv$iv$iv == null) {
                arrayList = new ArrayList();
                destination$iv$iv.put(computeJvmDescriptor$default, arrayList);
            } else {
                arrayList = value$iv$iv$iv;
            }
            Object key$iv$iv$iv = arrayList;
            List list$iv$iv = (List) key$iv$iv$iv;
            list$iv$iv.add(element$iv$iv);
        }
        Collection<List> groups = destination$iv$iv.values();
        for (List group : groups) {
            if (group.size() != 1) {
                Collection mostSpecificMethods = OverridingUtilsKt.selectMostSpecificInEachOverridableGroup(group, new Function1() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope$$Lambda$9
                    @Override // kotlin.jvm.functions.Function1
                    public Object invoke(Object obj) {
                        CallableDescriptor retainMostSpecificMethods$lambda$1;
                        retainMostSpecificMethods$lambda$1 = LazyJavaScope.retainMostSpecificMethods$lambda$1((SimpleFunctionDescriptor) obj);
                        return retainMostSpecificMethods$lambda$1;
                    }
                });
                set.removeAll(group);
                set.addAll(mostSpecificMethods);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CallableDescriptor retainMostSpecificMethods$lambda$1(SimpleFunctionDescriptor selectMostSpecificInEachOverridableGroup) {
        Intrinsics.checkNotNullParameter(selectMostSpecificInEachOverridableGroup, "$this$selectMostSpecificInEachOverridableGroup");
        return selectMostSpecificInEachOverridableGroup;
    }

    protected boolean isVisibleAsFunction(JavaMethodDescriptor $this$isVisibleAsFunction) {
        Intrinsics.checkNotNullParameter($this$isVisibleAsFunction, "<this>");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: LazyJavaScope.kt */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class MethodSignatureData {
        private final List<String> errors;
        private final boolean hasStableParameterNames;
        private final KotlinType receiverType;
        private final KotlinType returnType;
        private final List<TypeParameterDescriptor> typeParameters;
        private final List<ValueParameterDescriptor> valueParameters;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof MethodSignatureData) {
                MethodSignatureData methodSignatureData = (MethodSignatureData) obj;
                return Intrinsics.areEqual(this.returnType, methodSignatureData.returnType) && Intrinsics.areEqual(this.receiverType, methodSignatureData.receiverType) && Intrinsics.areEqual(this.valueParameters, methodSignatureData.valueParameters) && Intrinsics.areEqual(this.typeParameters, methodSignatureData.typeParameters) && this.hasStableParameterNames == methodSignatureData.hasStableParameterNames && Intrinsics.areEqual(this.errors, methodSignatureData.errors);
            }
            return false;
        }

        public int hashCode() {
            return (((((((((this.returnType.hashCode() * 31) + (this.receiverType == null ? 0 : this.receiverType.hashCode())) * 31) + this.valueParameters.hashCode()) * 31) + this.typeParameters.hashCode()) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.hasStableParameterNames)) * 31) + this.errors.hashCode();
        }

        public String toString() {
            return "MethodSignatureData(returnType=" + this.returnType + ", receiverType=" + this.receiverType + ", valueParameters=" + this.valueParameters + ", typeParameters=" + this.typeParameters + ", hasStableParameterNames=" + this.hasStableParameterNames + ", errors=" + this.errors + ')';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public MethodSignatureData(KotlinType returnType, KotlinType receiverType, List<? extends ValueParameterDescriptor> valueParameters, List<? extends TypeParameterDescriptor> typeParameters, boolean hasStableParameterNames, List<String> errors) {
            Intrinsics.checkNotNullParameter(returnType, "returnType");
            Intrinsics.checkNotNullParameter(valueParameters, "valueParameters");
            Intrinsics.checkNotNullParameter(typeParameters, "typeParameters");
            Intrinsics.checkNotNullParameter(errors, "errors");
            this.returnType = returnType;
            this.receiverType = receiverType;
            this.valueParameters = valueParameters;
            this.typeParameters = typeParameters;
            this.hasStableParameterNames = hasStableParameterNames;
            this.errors = errors;
        }

        public final KotlinType getReturnType() {
            return this.returnType;
        }

        public final KotlinType getReceiverType() {
            return this.receiverType;
        }

        public final List<ValueParameterDescriptor> getValueParameters() {
            return this.valueParameters;
        }

        public final List<TypeParameterDescriptor> getTypeParameters() {
            return this.typeParameters;
        }

        public final boolean getHasStableParameterNames() {
            return this.hasStableParameterNames;
        }

        public final List<String> getErrors() {
            return this.errors;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final JavaMethodDescriptor resolveMethodToFunctionDescriptor(JavaMethod method) {
        Map<? extends CallableDescriptor.UserDataKey<?>, ?> emptyMap;
        Intrinsics.checkNotNullParameter(method, "method");
        Annotations annotations = LazyJavaAnnotationsKt.resolveAnnotations(this.c, method);
        JavaMethodDescriptor functionDescriptorImpl = JavaMethodDescriptor.createJavaMethod(getOwnerDescriptor(), annotations, method.getName(), this.c.getComponents().getSourceElementFactory().source(method), this.declaredMemberIndex.invoke().findRecordComponentByName(method.getName()) != null && method.getValueParameters().isEmpty());
        Intrinsics.checkNotNullExpressionValue(functionDescriptorImpl, "createJavaMethod(...)");
        LazyJavaResolverContext c = ContextKt.childForMethod$default(this.c, functionDescriptorImpl, method, 0, 4, null);
        Iterable $this$map$iv = method.getTypeParameters();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            JavaTypeParameter p = (JavaTypeParameter) item$iv$iv;
            TypeParameterDescriptor resolveTypeParameter = c.getTypeParameterResolver().resolveTypeParameter(p);
            Intrinsics.checkNotNull(resolveTypeParameter);
            destination$iv$iv.add(resolveTypeParameter);
        }
        List methodTypeParameters = (List) destination$iv$iv;
        ResolvedValueParameters valueParameters = resolveValueParameters(c, functionDescriptorImpl, method.getValueParameters());
        KotlinType returnType = computeMethodReturnType(method, c);
        MethodSignatureData effectiveSignature = resolveMethodSignature(method, methodTypeParameters, returnType, valueParameters.getDescriptors());
        KotlinType it = effectiveSignature.getReceiverType();
        ReceiverParameterDescriptor createExtensionReceiverParameterForCallable = it != null ? DescriptorFactory.createExtensionReceiverParameterForCallable(functionDescriptorImpl, it, Annotations.Companion.getEMPTY()) : null;
        ReceiverParameterDescriptor dispatchReceiverParameter = getDispatchReceiverParameter();
        List<ReceiverParameterDescriptor> emptyList = CollectionsKt.emptyList();
        List<TypeParameterDescriptor> typeParameters = effectiveSignature.getTypeParameters();
        List<ValueParameterDescriptor> valueParameters2 = effectiveSignature.getValueParameters();
        KotlinType returnType2 = effectiveSignature.getReturnType();
        Modality convertFromFlags = Modality.Companion.convertFromFlags(false, method.isAbstract(), !method.isFinal());
        DescriptorVisibility descriptorVisibility = UtilsKt.toDescriptorVisibility(method.getVisibility());
        if (effectiveSignature.getReceiverType() != null) {
            emptyMap = MapsKt.mapOf(TuplesKt.to(JavaMethodDescriptor.ORIGINAL_VALUE_PARAMETER_FOR_EXTENSION_RECEIVER, CollectionsKt.first((List<? extends Object>) valueParameters.getDescriptors())));
        } else {
            emptyMap = MapsKt.emptyMap();
        }
        functionDescriptorImpl.initialize(createExtensionReceiverParameterForCallable, dispatchReceiverParameter, emptyList, typeParameters, valueParameters2, returnType2, convertFromFlags, descriptorVisibility, emptyMap);
        functionDescriptorImpl.setParameterNamesStatus(effectiveSignature.getHasStableParameterNames(), valueParameters.getHasSynthesizedNames());
        if (!effectiveSignature.getErrors().isEmpty()) {
            c.getComponents().getSignaturePropagator().reportSignatureErrors(functionDescriptorImpl, effectiveSignature.getErrors());
        }
        return functionDescriptorImpl;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final KotlinType computeMethodReturnType(JavaMethod method, LazyJavaResolverContext c) {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(c, "c");
        boolean annotationMethod = method.getContainingClass().isAnnotationType();
        JavaTypeAttributes returnTypeAttrs = JavaTypeAttributesKt.toAttributes$default(TypeUsage.COMMON, annotationMethod, false, null, 6, null);
        return c.getTypeResolver().transformJavaType(method.getReturnType(), returnTypeAttrs);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: LazyJavaScope.kt */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class ResolvedValueParameters {
        private final List<ValueParameterDescriptor> descriptors;
        private final boolean hasSynthesizedNames;

        /* JADX WARN: Multi-variable type inference failed */
        public ResolvedValueParameters(List<? extends ValueParameterDescriptor> descriptors, boolean hasSynthesizedNames) {
            Intrinsics.checkNotNullParameter(descriptors, "descriptors");
            this.descriptors = descriptors;
            this.hasSynthesizedNames = hasSynthesizedNames;
        }

        public final List<ValueParameterDescriptor> getDescriptors() {
            return this.descriptors;
        }

        public final boolean getHasSynthesizedNames() {
            return this.hasSynthesizedNames;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final ResolvedValueParameters resolveValueParameters(LazyJavaResolverContext c, FunctionDescriptor function, List<? extends JavaValueParameter> jValueParameters) {
        Pair pair;
        Name name;
        LazyJavaResolverContext c2 = c;
        FunctionDescriptor function2 = function;
        Intrinsics.checkNotNullParameter(c2, "c");
        Intrinsics.checkNotNullParameter(function2, "function");
        Intrinsics.checkNotNullParameter(jValueParameters, "jValueParameters");
        boolean synthesizedNames = false;
        Iterable $this$map$iv = CollectionsKt.withIndex(jValueParameters);
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            IndexedValue indexedValue = (IndexedValue) item$iv$iv;
            int index = indexedValue.component1();
            JavaValueParameter javaParameter = (JavaValueParameter) indexedValue.component2();
            Annotations annotations = LazyJavaAnnotationsKt.resolveAnnotations(c2, javaParameter);
            JavaTypeAttributes typeUsage = JavaTypeAttributesKt.toAttributes$default(TypeUsage.COMMON, false, false, null, 7, null);
            if (javaParameter.isVararg()) {
                JavaType type = javaParameter.getType();
                JavaArrayType paramType = type instanceof JavaArrayType ? (JavaArrayType) type : null;
                if (paramType == null) {
                    throw new AssertionError("Vararg parameter should be an array: " + javaParameter);
                }
                KotlinType outType = c.getTypeResolver().transformArrayType(paramType, typeUsage, true);
                pair = TuplesKt.to(outType, c.getModule().getBuiltIns().getArrayElementType(outType));
            } else {
                pair = TuplesKt.to(c.getTypeResolver().transformJavaType(javaParameter.getType(), typeUsage), (Object) null);
            }
            KotlinType outType2 = (KotlinType) pair.component1();
            KotlinType varargElementType = (KotlinType) pair.component2();
            Iterable $this$map$iv2 = $this$map$iv;
            if (Intrinsics.areEqual(function.getName().asString(), "equals") && jValueParameters.size() == 1 && Intrinsics.areEqual(c.getModule().getBuiltIns().getNullableAnyType(), outType2)) {
                name = Name.identifier("other");
            } else {
                Name javaName = javaParameter.getName();
                if (javaName == null) {
                    synthesizedNames = true;
                }
                if (javaName == null) {
                    boolean synthesizedNames2 = synthesizedNames;
                    Name identifier = Name.identifier(new StringBuilder().append('p').append(index).toString());
                    Intrinsics.checkNotNullExpressionValue(identifier, "identifier(...)");
                    name = identifier;
                    synthesizedNames = synthesizedNames2;
                } else {
                    name = javaName;
                }
            }
            Intrinsics.checkNotNull(name);
            destination$iv$iv.add(new ValueParameterDescriptorImpl(function2, null, index, annotations, name, outType2, false, false, false, varargElementType, c.getComponents().getSourceElementFactory().source(javaParameter)));
            c2 = c;
            function2 = function;
            $this$map$iv = $this$map$iv2;
        }
        List descriptors = CollectionsKt.toList((List) destination$iv$iv);
        return new ResolvedValueParameters(descriptors, synthesizedNames);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Set functionNamesLazy_delegate$lambda$0(LazyJavaScope this$0) {
        return this$0.computeFunctionNames(DescriptorKindFilter.FUNCTIONS, null);
    }

    private final Set<Name> getFunctionNamesLazy() {
        return (Set) StorageKt.getValue(this.functionNamesLazy$delegate, this, $$delegatedProperties[0]);
    }

    private final Set<Name> getPropertyNamesLazy() {
        return (Set) StorageKt.getValue(this.propertyNamesLazy$delegate, this, $$delegatedProperties[1]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Set propertyNamesLazy_delegate$lambda$0(LazyJavaScope this$0) {
        return this$0.computePropertyNames(DescriptorKindFilter.VARIABLES, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Set classNamesLazy_delegate$lambda$0(LazyJavaScope this$0) {
        return this$0.computeClassNames(DescriptorKindFilter.CLASSIFIERS, null);
    }

    private final Set<Name> getClassNamesLazy() {
        return (Set) StorageKt.getValue(this.classNamesLazy$delegate, this, $$delegatedProperties[2]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set<Name> getFunctionNames() {
        return getFunctionNamesLazy();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set<Name> getVariableNames() {
        return getPropertyNamesLazy();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set<Name> getClassifierNames() {
        return getClassNamesLazy();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public Collection<SimpleFunctionDescriptor> getContributedFunctions(Name name, LookupLocation location2) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(location2, "location");
        return !getFunctionNames().contains(name) ? CollectionsKt.emptyList() : this.functions.invoke(name);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List properties$lambda$0(LazyJavaScope this$0, Name name) {
        Intrinsics.checkNotNullParameter(name, "name");
        ArrayList properties = new ArrayList();
        kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.addIfNotNull(properties, this$0.declaredField.invoke(name));
        this$0.computeNonDeclaredProperties(name, properties);
        if (DescriptorUtils.isAnnotationClass(this$0.getOwnerDescriptor())) {
            return CollectionsKt.toList(properties);
        }
        return CollectionsKt.toList(this$0.c.getComponents().getSignatureEnhancement().enhanceSignatures(this$0.c, properties));
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [T, kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl] */
    /* JADX WARN: Type inference failed for: r4v5, types: [T, kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl] */
    private final PropertyDescriptor resolveProperty(final JavaField field) {
        final Ref.ObjectRef propertyDescriptor = new Ref.ObjectRef();
        propertyDescriptor.element = createPropertyDescriptor(field);
        ((PropertyDescriptorImpl) propertyDescriptor.element).initialize(null, null, null, null);
        KotlinType propertyType = getPropertyType(field);
        ((PropertyDescriptorImpl) propertyDescriptor.element).setType(propertyType, CollectionsKt.emptyList(), getDispatchReceiverParameter(), null, CollectionsKt.emptyList());
        DeclarationDescriptor ownerDescriptor = getOwnerDescriptor();
        ClassDescriptor classDescriptor = ownerDescriptor instanceof ClassDescriptor ? (ClassDescriptor) ownerDescriptor : null;
        if (classDescriptor != null) {
            propertyDescriptor.element = this.c.getComponents().getSyntheticPartsProvider().modifyField(classDescriptor, (PropertyDescriptorImpl) propertyDescriptor.element, this.c);
        }
        if (DescriptorUtils.shouldRecordInitializerForProperty((VariableDescriptor) propertyDescriptor.element, ((PropertyDescriptorImpl) propertyDescriptor.element).getType())) {
            ((PropertyDescriptorImpl) propertyDescriptor.element).setCompileTimeInitializerFactory(new Function0(this, field, propertyDescriptor) { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope$$Lambda$10
                private final LazyJavaScope arg$0;
                private final JavaField arg$1;
                private final Ref.ObjectRef arg$2;

                {
                    this.arg$0 = this;
                    this.arg$1 = field;
                    this.arg$2 = propertyDescriptor;
                }

                @Override // kotlin.jvm.functions.Function0
                public Object invoke() {
                    NullableLazyValue resolveProperty$lambda$1;
                    resolveProperty$lambda$1 = LazyJavaScope.resolveProperty$lambda$1(this.arg$0, this.arg$1, this.arg$2);
                    return resolveProperty$lambda$1;
                }
            });
        }
        this.c.getComponents().getJavaResolverCache().recordField(field, (PropertyDescriptor) propertyDescriptor.element);
        return (PropertyDescriptor) propertyDescriptor.element;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NullableLazyValue resolveProperty$lambda$1(final LazyJavaScope this$0, final JavaField $field, final Ref.ObjectRef $propertyDescriptor) {
        return this$0.c.getStorageManager().createNullableLazyValue(new Function0(this$0, $field, $propertyDescriptor) { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope$$Lambda$11
            private final LazyJavaScope arg$0;
            private final JavaField arg$1;
            private final Ref.ObjectRef arg$2;

            {
                this.arg$0 = this$0;
                this.arg$1 = $field;
                this.arg$2 = $propertyDescriptor;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                ConstantValue resolveProperty$lambda$1$0;
                resolveProperty$lambda$1$0 = LazyJavaScope.resolveProperty$lambda$1$0(this.arg$0, this.arg$1, this.arg$2);
                return resolveProperty$lambda$1$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ConstantValue resolveProperty$lambda$1$0(LazyJavaScope this$0, JavaField $field, Ref.ObjectRef $propertyDescriptor) {
        return this$0.c.getComponents().getJavaPropertyInitializerEvaluator().getInitializerConstant($field, (PropertyDescriptor) $propertyDescriptor.element);
    }

    private final PropertyDescriptorImpl createPropertyDescriptor(JavaField field) {
        boolean isVar = !field.isFinal();
        Annotations annotations = LazyJavaAnnotationsKt.resolveAnnotations(this.c, field);
        JavaPropertyDescriptor create = JavaPropertyDescriptor.create(getOwnerDescriptor(), annotations, Modality.FINAL, UtilsKt.toDescriptorVisibility(field.getVisibility()), isVar, field.getName(), this.c.getComponents().getSourceElementFactory().source(field), isFinalStatic(field));
        Intrinsics.checkNotNullExpressionValue(create, "create(...)");
        return create;
    }

    private final boolean isFinalStatic(JavaField $this$isFinalStatic) {
        return $this$isFinalStatic.isFinal() && $this$isFinalStatic.isStatic();
    }

    private final KotlinType getPropertyType(JavaField field) {
        KotlinType propertyType = this.c.getTypeResolver().transformJavaType(field.getType(), JavaTypeAttributesKt.toAttributes$default(TypeUsage.COMMON, false, false, null, 7, null));
        boolean isNotNullable = (KotlinBuiltIns.isPrimitiveType(propertyType) || KotlinBuiltIns.isString(propertyType)) && isFinalStatic(field) && field.getHasConstantNotNullInitializer();
        if (isNotNullable) {
            KotlinType makeNotNullable = TypeUtils.makeNotNullable(propertyType);
            Intrinsics.checkNotNullExpressionValue(makeNotNullable, "makeNotNullable(...)");
            return makeNotNullable;
        }
        return propertyType;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Collection<PropertyDescriptor> getContributedVariables(Name name, LookupLocation location2) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(location2, "location");
        return !getVariableNames().contains(name) ? CollectionsKt.emptyList() : this.properties.invoke(name);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public Collection<DeclarationDescriptor> getContributedDescriptors(DescriptorKindFilter kindFilter, Function1<? super Name, Boolean> nameFilter) {
        Intrinsics.checkNotNullParameter(kindFilter, "kindFilter");
        Intrinsics.checkNotNullParameter(nameFilter, "nameFilter");
        return this.allDescriptors.invoke();
    }

    protected final List<DeclarationDescriptor> computeDescriptors(DescriptorKindFilter kindFilter, Function1<? super Name, Boolean> nameFilter) {
        Intrinsics.checkNotNullParameter(kindFilter, "kindFilter");
        Intrinsics.checkNotNullParameter(nameFilter, "nameFilter");
        NoLookupLocation location2 = NoLookupLocation.WHEN_GET_ALL_DESCRIPTORS;
        LinkedHashSet result = new LinkedHashSet();
        if (kindFilter.acceptsKinds(DescriptorKindFilter.Companion.getCLASSIFIERS_MASK())) {
            for (Name name : computeClassNames(kindFilter, nameFilter)) {
                if (nameFilter.invoke(name).booleanValue()) {
                    kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.addIfNotNull(result, mo1173getContributedClassifier(name, location2));
                }
            }
        }
        if (kindFilter.acceptsKinds(DescriptorKindFilter.Companion.getFUNCTIONS_MASK()) && !kindFilter.getExcludes().contains(DescriptorKindExclude.NonExtensions.INSTANCE)) {
            for (Name name2 : computeFunctionNames(kindFilter, nameFilter)) {
                if (nameFilter.invoke(name2).booleanValue()) {
                    result.addAll(getContributedFunctions(name2, location2));
                }
            }
        }
        if (kindFilter.acceptsKinds(DescriptorKindFilter.Companion.getVARIABLES_MASK()) && !kindFilter.getExcludes().contains(DescriptorKindExclude.NonExtensions.INSTANCE)) {
            for (Name name3 : computePropertyNames(kindFilter, nameFilter)) {
                if (nameFilter.invoke(name3).booleanValue()) {
                    result.addAll(getContributedVariables(name3, location2));
                }
            }
        }
        return CollectionsKt.toList(result);
    }

    public String toString() {
        return "Lazy scope for " + getOwnerDescriptor();
    }
}