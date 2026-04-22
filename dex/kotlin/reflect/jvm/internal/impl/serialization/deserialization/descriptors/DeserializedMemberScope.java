package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;
import kotlin.reflect.jvm.internal.impl.resolve.MemberComparator;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolverUtilKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.sequences.SequencesKt;

/* compiled from: DeserializedMemberScope.kt */
public abstract class DeserializedMemberScope extends MemberScopeImpl {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(DeserializedMemberScope.class, "classNames", "getClassNames$deserialization()Ljava/util/Set;", 0)), Reflection.property1(new PropertyReference1Impl(DeserializedMemberScope.class, "classifierNamesLazy", "getClassifierNamesLazy()Ljava/util/Set;", 0))};
    private final DeserializationContext c;
    private final NotNullLazyValue classNames$delegate;
    private final NullableLazyValue classifierNamesLazy$delegate;
    private final Implementation impl;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DeserializedMemberScope.kt */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public interface Implementation {
        void addFunctionsAndPropertiesTo(Collection<DeclarationDescriptor> collection, DescriptorKindFilter descriptorKindFilter, Function1<? super Name, Boolean> function1, LookupLocation lookupLocation);

        Collection<SimpleFunctionDescriptor> getContributedFunctions(Name name, LookupLocation lookupLocation);

        Collection<PropertyDescriptor> getContributedVariables(Name name, LookupLocation lookupLocation);

        Set<Name> getFunctionNames();

        TypeAliasDescriptor getTypeAliasByName(Name name);

        Set<Name> getTypeAliasNames();

        Set<Name> getVariableNames();
    }

    protected abstract void addEnumEntryDescriptors(Collection<DeclarationDescriptor> collection, Function1<? super Name, Boolean> function1);

    protected abstract ClassId createClassId(Name name);

    protected abstract Set<Name> getNonDeclaredClassifierNames();

    protected abstract Set<Name> getNonDeclaredFunctionNames();

    protected abstract Set<Name> getNonDeclaredVariableNames();

    /* JADX INFO: Access modifiers changed from: protected */
    public DeserializedMemberScope(DeserializationContext c, List<ProtoBuf.Function> functionList, List<ProtoBuf.Property> propertyList, List<ProtoBuf.TypeAlias> typeAliasList, final Function0<? extends Collection<Name>> classNames) {
        Intrinsics.checkNotNullParameter(c, "c");
        Intrinsics.checkNotNullParameter(functionList, "functionList");
        Intrinsics.checkNotNullParameter(propertyList, "propertyList");
        Intrinsics.checkNotNullParameter(typeAliasList, "typeAliasList");
        Intrinsics.checkNotNullParameter(classNames, "classNames");
        this.c = c;
        this.impl = createImplementation(functionList, propertyList, typeAliasList);
        this.classNames$delegate = this.c.getStorageManager().createLazyValue(new Function0(classNames) { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope$$Lambda$0
            private final Function0 arg$0;

            {
                this.arg$0 = classNames;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                Set classNames_delegate$lambda$0;
                classNames_delegate$lambda$0 = DeserializedMemberScope.classNames_delegate$lambda$0(this.arg$0);
                return classNames_delegate$lambda$0;
            }
        });
        this.classifierNamesLazy$delegate = this.c.getStorageManager().createNullableLazyValue(new Function0(this) { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope$$Lambda$1
            private final DeserializedMemberScope arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                Set classifierNamesLazy_delegate$lambda$0;
                classifierNamesLazy_delegate$lambda$0 = DeserializedMemberScope.classifierNamesLazy_delegate$lambda$0(this.arg$0);
                return classifierNamesLazy_delegate$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final DeserializationContext getC() {
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Set classNames_delegate$lambda$0(Function0 $classNames) {
        return CollectionsKt.toSet((Iterable) $classNames.invoke());
    }

    public final Set<Name> getClassNames$deserialization() {
        return (Set) StorageKt.getValue(this.classNames$delegate, this, $$delegatedProperties[0]);
    }

    private final Set<Name> getClassifierNamesLazy() {
        return (Set) StorageKt.getValue(this.classifierNamesLazy$delegate, this, $$delegatedProperties[1]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Set classifierNamesLazy_delegate$lambda$0(DeserializedMemberScope this$0) {
        Set nonDeclaredNames = this$0.getNonDeclaredClassifierNames();
        if (nonDeclaredNames == null) {
            return null;
        }
        return SetsKt.plus(SetsKt.plus((Set) this$0.getClassNames$deserialization(), (Iterable) this$0.impl.getTypeAliasNames()), (Iterable) nonDeclaredNames);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set<Name> getFunctionNames() {
        return this.impl.getFunctionNames();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set<Name> getVariableNames() {
        return this.impl.getVariableNames();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set<Name> getClassifierNames() {
        return getClassifierNamesLazy();
    }

    protected boolean isDeclaredFunctionAvailable(SimpleFunctionDescriptor function) {
        Intrinsics.checkNotNullParameter(function, "function");
        return true;
    }

    protected void computeNonDeclaredFunctions(Name name, List<SimpleFunctionDescriptor> functions) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(functions, "functions");
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public Collection<SimpleFunctionDescriptor> getContributedFunctions(Name name, LookupLocation location2) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(location2, "location");
        return this.impl.getContributedFunctions(name, location2);
    }

    protected void computeNonDeclaredProperties(Name name, List<PropertyDescriptor> descriptors) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(descriptors, "descriptors");
    }

    private final TypeAliasDescriptor getTypeAliasByName(Name name) {
        return this.impl.getTypeAliasByName(name);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Collection<PropertyDescriptor> getContributedVariables(Name name, LookupLocation location2) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(location2, "location");
        return this.impl.getContributedVariables(name, location2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Collection<DeclarationDescriptor> computeDescriptors(DescriptorKindFilter kindFilter, Function1<? super Name, Boolean> nameFilter, LookupLocation location2) {
        Intrinsics.checkNotNullParameter(kindFilter, "kindFilter");
        Intrinsics.checkNotNullParameter(nameFilter, "nameFilter");
        Intrinsics.checkNotNullParameter(location2, "location");
        ArrayList result = new ArrayList(0);
        if (kindFilter.acceptsKinds(DescriptorKindFilter.Companion.getSINGLETON_CLASSIFIERS_MASK())) {
            addEnumEntryDescriptors(result, nameFilter);
        }
        this.impl.addFunctionsAndPropertiesTo(result, kindFilter, nameFilter, location2);
        if (kindFilter.acceptsKinds(DescriptorKindFilter.Companion.getCLASSIFIERS_MASK())) {
            for (Name className : getClassNames$deserialization()) {
                if (nameFilter.invoke(className).booleanValue()) {
                    kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.addIfNotNull(result, deserializeClass(className));
                }
            }
        }
        if (kindFilter.acceptsKinds(DescriptorKindFilter.Companion.getTYPE_ALIASES_MASK())) {
            for (Name typeAliasName : this.impl.getTypeAliasNames()) {
                if (nameFilter.invoke(typeAliasName).booleanValue()) {
                    kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.addIfNotNull(result, this.impl.getTypeAliasByName(typeAliasName));
                }
            }
        }
        return kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.compact(result);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    /* renamed from: getContributedClassifier */
    public ClassifierDescriptor mo1173getContributedClassifier(Name name, LookupLocation location2) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(location2, "location");
        if (hasClass(name)) {
            return deserializeClass(name);
        }
        if (this.impl.getTypeAliasNames().contains(name)) {
            return getTypeAliasByName(name);
        }
        return null;
    }

    private final ClassDescriptor deserializeClass(Name name) {
        return this.c.getComponents().deserializeClass(createClassId(name));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean hasClass(Name name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return getClassNames$deserialization().contains(name);
    }

    private final Implementation createImplementation(List<ProtoBuf.Function> list, List<ProtoBuf.Property> list2, List<ProtoBuf.TypeAlias> list3) {
        if (this.c.getComponents().getConfiguration().getPreserveDeclarationsOrdering()) {
            return new NoReorderImplementation(this, list, list2, list3);
        }
        return new OptimizedImplementation(this, list, list2, list3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DeserializedMemberScope.kt */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public final class OptimizedImplementation implements Implementation {
        static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(OptimizedImplementation.class, "functionNames", "getFunctionNames()Ljava/util/Set;", 0)), Reflection.property1(new PropertyReference1Impl(OptimizedImplementation.class, "variableNames", "getVariableNames()Ljava/util/Set;", 0))};
        private final NotNullLazyValue functionNames$delegate;
        private final Map<Name, byte[]> functionProtosBytes;
        private final MemoizedFunctionToNotNull<Name, Collection<SimpleFunctionDescriptor>> functions;
        private final MemoizedFunctionToNotNull<Name, Collection<PropertyDescriptor>> properties;
        private final Map<Name, byte[]> propertyProtosBytes;
        final /* synthetic */ DeserializedMemberScope this$0;
        private final MemoizedFunctionToNullable<Name, TypeAliasDescriptor> typeAliasByName;
        private final Map<Name, byte[]> typeAliasBytes;
        private final NotNullLazyValue variableNames$delegate;

        public OptimizedImplementation(DeserializedMemberScope this$0, List<ProtoBuf.Function> functionList, List<ProtoBuf.Property> propertyList, List<ProtoBuf.TypeAlias> typeAliasList) {
            Map<Name, byte[]> emptyMap;
            ArrayList arrayList;
            ArrayList arrayList2;
            Collection $this$groupByName$iv;
            ArrayList arrayList3;
            Intrinsics.checkNotNullParameter(functionList, "functionList");
            Intrinsics.checkNotNullParameter(propertyList, "propertyList");
            Intrinsics.checkNotNullParameter(typeAliasList, "typeAliasList");
            this.this$0 = this$0;
            List<ProtoBuf.Function> $this$groupByName$iv2 = functionList;
            List<ProtoBuf.Function> $this$groupBy$iv$iv = $this$groupByName$iv2;
            DeserializedMemberScope deserializedMemberScope = this.this$0;
            Map destination$iv$iv$iv = new LinkedHashMap();
            for (Object element$iv$iv$iv : $this$groupBy$iv$iv) {
                MessageLite it$iv = (MessageLite) element$iv$iv$iv;
                ProtoBuf.Function it = (ProtoBuf.Function) it$iv;
                Name name = NameResolverUtilKt.getName(deserializedMemberScope.getC().getNameResolver(), it.getName());
                Object value$iv$iv$iv$iv = destination$iv$iv$iv.get(name);
                if (value$iv$iv$iv$iv == null) {
                    arrayList3 = new ArrayList();
                    $this$groupByName$iv = $this$groupByName$iv2;
                    destination$iv$iv$iv.put(name, arrayList3);
                } else {
                    $this$groupByName$iv = $this$groupByName$iv2;
                    arrayList3 = value$iv$iv$iv$iv;
                }
                ((List) arrayList3).add(element$iv$iv$iv);
                $this$groupByName$iv2 = $this$groupByName$iv;
            }
            this.functionProtosBytes = packToByteArray(destination$iv$iv$iv);
            List<ProtoBuf.Property> list$iv$iv$iv = propertyList;
            List<ProtoBuf.Property> $this$groupBy$iv$iv2 = list$iv$iv$iv;
            DeserializedMemberScope deserializedMemberScope2 = this.this$0;
            Map destination$iv$iv$iv2 = new LinkedHashMap();
            for (Object element$iv$iv$iv2 : $this$groupBy$iv$iv2) {
                MessageLite it$iv2 = (MessageLite) element$iv$iv$iv2;
                List $this$groupByName$iv3 = list$iv$iv$iv;
                ProtoBuf.Property it2 = (ProtoBuf.Property) it$iv2;
                Name name2 = NameResolverUtilKt.getName(deserializedMemberScope2.getC().getNameResolver(), it2.getName());
                Object value$iv$iv$iv$iv2 = destination$iv$iv$iv2.get(name2);
                if (value$iv$iv$iv$iv2 == null) {
                    arrayList2 = new ArrayList();
                    destination$iv$iv$iv2.put(name2, arrayList2);
                } else {
                    arrayList2 = value$iv$iv$iv$iv2;
                }
                ((List) arrayList2).add(element$iv$iv$iv2);
                list$iv$iv$iv = $this$groupByName$iv3;
            }
            this.propertyProtosBytes = packToByteArray(destination$iv$iv$iv2);
            if (this.this$0.getC().getComponents().getConfiguration().getTypeAliasesAllowed()) {
                List<ProtoBuf.TypeAlias> list$iv$iv$iv2 = typeAliasList;
                List<ProtoBuf.TypeAlias> $this$groupBy$iv$iv3 = list$iv$iv$iv2;
                DeserializedMemberScope deserializedMemberScope3 = this.this$0;
                Map destination$iv$iv$iv3 = new LinkedHashMap();
                for (Object element$iv$iv$iv3 : $this$groupBy$iv$iv3) {
                    MessageLite it$iv3 = (MessageLite) element$iv$iv$iv3;
                    ProtoBuf.TypeAlias it3 = (ProtoBuf.TypeAlias) it$iv3;
                    List $this$groupByName$iv4 = list$iv$iv$iv2;
                    Name name3 = NameResolverUtilKt.getName(deserializedMemberScope3.getC().getNameResolver(), it3.getName());
                    Object value$iv$iv$iv$iv3 = destination$iv$iv$iv3.get(name3);
                    if (value$iv$iv$iv$iv3 == null) {
                        arrayList = new ArrayList();
                        destination$iv$iv$iv3.put(name3, arrayList);
                    } else {
                        arrayList = value$iv$iv$iv$iv3;
                    }
                    ((List) arrayList).add(element$iv$iv$iv3);
                    list$iv$iv$iv2 = $this$groupByName$iv4;
                }
                emptyMap = packToByteArray(destination$iv$iv$iv3);
            } else {
                emptyMap = MapsKt.emptyMap();
            }
            this.typeAliasBytes = emptyMap;
            this.functions = this.this$0.getC().getStorageManager().createMemoizedFunction(new Function1(this) { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope$OptimizedImplementation$$Lambda$0
                private final DeserializedMemberScope.OptimizedImplementation arg$0;

                {
                    this.arg$0 = this_$iv;
                }

                @Override // kotlin.jvm.functions.Function1
                public Object invoke(Object obj) {
                    Collection functions$lambda$0;
                    functions$lambda$0 = DeserializedMemberScope.OptimizedImplementation.functions$lambda$0(this.arg$0, (Name) obj);
                    return functions$lambda$0;
                }
            });
            this.properties = this.this$0.getC().getStorageManager().createMemoizedFunction(new Function1(this) { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope$OptimizedImplementation$$Lambda$1
                private final DeserializedMemberScope.OptimizedImplementation arg$0;

                {
                    this.arg$0 = this_$iv;
                }

                @Override // kotlin.jvm.functions.Function1
                public Object invoke(Object obj) {
                    Collection properties$lambda$0;
                    properties$lambda$0 = DeserializedMemberScope.OptimizedImplementation.properties$lambda$0(this.arg$0, (Name) obj);
                    return properties$lambda$0;
                }
            });
            this.typeAliasByName = this.this$0.getC().getStorageManager().createMemoizedFunctionWithNullableValues(new Function1(this) { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope$OptimizedImplementation$$Lambda$2
                private final DeserializedMemberScope.OptimizedImplementation arg$0;

                {
                    this.arg$0 = this_$iv;
                }

                @Override // kotlin.jvm.functions.Function1
                public Object invoke(Object obj) {
                    TypeAliasDescriptor typeAliasByName$lambda$0;
                    typeAliasByName$lambda$0 = DeserializedMemberScope.OptimizedImplementation.typeAliasByName$lambda$0(this.arg$0, (Name) obj);
                    return typeAliasByName$lambda$0;
                }
            });
            StorageManager storageManager = this.this$0.getC().getStorageManager();
            final DeserializedMemberScope deserializedMemberScope4 = this.this$0;
            this.functionNames$delegate = storageManager.createLazyValue(new Function0(this, deserializedMemberScope4) { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope$OptimizedImplementation$$Lambda$3
                private final DeserializedMemberScope.OptimizedImplementation arg$0;
                private final DeserializedMemberScope arg$1;

                {
                    this.arg$0 = this_$iv;
                    this.arg$1 = deserializedMemberScope4;
                }

                @Override // kotlin.jvm.functions.Function0
                public Object invoke() {
                    Set functionNames_delegate$lambda$0;
                    functionNames_delegate$lambda$0 = DeserializedMemberScope.OptimizedImplementation.functionNames_delegate$lambda$0(this.arg$0, this.arg$1);
                    return functionNames_delegate$lambda$0;
                }
            });
            StorageManager storageManager2 = this.this$0.getC().getStorageManager();
            final DeserializedMemberScope deserializedMemberScope5 = this.this$0;
            this.variableNames$delegate = storageManager2.createLazyValue(new Function0(this, deserializedMemberScope5) { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope$OptimizedImplementation$$Lambda$4
                private final DeserializedMemberScope.OptimizedImplementation arg$0;
                private final DeserializedMemberScope arg$1;

                {
                    this.arg$0 = this_$iv;
                    this.arg$1 = deserializedMemberScope5;
                }

                @Override // kotlin.jvm.functions.Function0
                public Object invoke() {
                    Set variableNames_delegate$lambda$0;
                    variableNames_delegate$lambda$0 = DeserializedMemberScope.OptimizedImplementation.variableNames_delegate$lambda$0(this.arg$0, this.arg$1);
                    return variableNames_delegate$lambda$0;
                }
            });
        }

        private final Map<Name, byte[]> packToByteArray(Map<Name, ? extends Collection<? extends AbstractMessageLite>> map) {
            Map $this$mapValues$iv = map;
            int $i$f$mapValues = 0;
            Map destination$iv$iv = new LinkedHashMap(MapsKt.mapCapacity($this$mapValues$iv.size()));
            Iterable $this$associateByTo$iv$iv$iv = $this$mapValues$iv.entrySet();
            for (Object element$iv$iv$iv : $this$associateByTo$iv$iv$iv) {
                Map.Entry it$iv$iv = (Map.Entry) element$iv$iv$iv;
                Object key = it$iv$iv.getKey();
                Map.Entry entry = (Map.Entry) element$iv$iv$iv;
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                Iterable $this$map$iv = (Iterable) entry.getValue();
                Map $this$mapValues$iv2 = $this$mapValues$iv;
                int $i$f$mapValues2 = $i$f$mapValues;
                Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                Iterable $this$mapTo$iv$iv = $this$map$iv;
                for (Object item$iv$iv : $this$mapTo$iv$iv) {
                    Iterable $this$mapTo$iv$iv2 = $this$mapTo$iv$iv;
                    AbstractMessageLite proto = (AbstractMessageLite) item$iv$iv;
                    proto.writeDelimitedTo(byteArrayOutputStream);
                    destination$iv$iv2.add(Unit.INSTANCE);
                    $this$mapTo$iv$iv = $this$mapTo$iv$iv2;
                    destination$iv$iv = destination$iv$iv;
                }
                ArrayList arrayList = (List) destination$iv$iv2;
                destination$iv$iv.put(key, byteArrayOutputStream.toByteArray());
                $this$mapValues$iv = $this$mapValues$iv2;
                $i$f$mapValues = $i$f$mapValues2;
            }
            return destination$iv$iv;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Collection functions$lambda$0(OptimizedImplementation this$0, Name it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return this$0.computeFunctions(it);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Collection properties$lambda$0(OptimizedImplementation this$0, Name it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return this$0.computeProperties(it);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final TypeAliasDescriptor typeAliasByName$lambda$0(OptimizedImplementation this$0, Name it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return this$0.createTypeAlias(it);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.Implementation
        public Set<Name> getFunctionNames() {
            return (Set) StorageKt.getValue(this.functionNames$delegate, this, $$delegatedProperties[0]);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Set functionNames_delegate$lambda$0(OptimizedImplementation this$0, DeserializedMemberScope this$1) {
            return SetsKt.plus((Set) this$0.functionProtosBytes.keySet(), (Iterable) this$1.getNonDeclaredFunctionNames());
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.Implementation
        public Set<Name> getVariableNames() {
            return (Set) StorageKt.getValue(this.variableNames$delegate, this, $$delegatedProperties[1]);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Set variableNames_delegate$lambda$0(OptimizedImplementation this$0, DeserializedMemberScope this$1) {
            return SetsKt.plus((Set) this$0.propertyProtosBytes.keySet(), (Iterable) this$1.getNonDeclaredVariableNames());
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.Implementation
        public Set<Name> getTypeAliasNames() {
            return this.typeAliasBytes.keySet();
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x005e  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final Collection<SimpleFunctionDescriptor> computeFunctions(Name name) {
            List emptyList;
            Map bytesByName$iv = this.functionProtosBytes;
            Parser PARSER = ProtoBuf.Function.PARSER;
            Intrinsics.checkNotNullExpressionValue(PARSER, "PARSER");
            DeserializedMemberScope deserializedMemberScope = this.this$0;
            DeserializedMemberScope deserializedMemberScope2 = this.this$0;
            byte[] it$iv = bytesByName$iv.get(name);
            if (it$iv != null) {
                DeserializedMemberScope deserializedMemberScope3 = this.this$0;
                ByteArrayInputStream inputStream$iv = new ByteArrayInputStream(it$iv);
                List list = SequencesKt.toList(SequencesKt.generateSequence(new DeserializedMemberScope$OptimizedImplementation$computeDescriptors$1$1(PARSER, inputStream$iv, deserializedMemberScope3)));
                if (list != null) {
                    emptyList = list;
                    Iterable $this$mapNotNullTo$iv$iv$iv = emptyList;
                    Collection destination$iv$iv$iv = new ArrayList(emptyList.size());
                    for (Object element$iv$iv$iv$iv : $this$mapNotNullTo$iv$iv$iv) {
                        ProtoBuf.Function it = (ProtoBuf.Function) element$iv$iv$iv$iv;
                        Map bytesByName$iv2 = bytesByName$iv;
                        MemberDeserializer memberDeserializer = deserializedMemberScope.getC().getMemberDeserializer();
                        Intrinsics.checkNotNull(it);
                        SimpleFunctionDescriptor p0 = memberDeserializer.loadFunction(it);
                        if (!deserializedMemberScope.isDeclaredFunctionAvailable(p0)) {
                            p0 = null;
                        }
                        if (p0 != null) {
                            destination$iv$iv$iv.add(p0);
                        }
                        bytesByName$iv = bytesByName$iv2;
                    }
                    ArrayList descriptors$iv$iv = (ArrayList) destination$iv$iv$iv;
                    deserializedMemberScope2.computeNonDeclaredFunctions(name, descriptors$iv$iv);
                    return kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.compact(descriptors$iv$iv);
                }
            }
            emptyList = CollectionsKt.emptyList();
            Iterable $this$mapNotNullTo$iv$iv$iv2 = emptyList;
            Collection destination$iv$iv$iv2 = new ArrayList(emptyList.size());
            while (r16.hasNext()) {
            }
            ArrayList descriptors$iv$iv2 = (ArrayList) destination$iv$iv$iv2;
            deserializedMemberScope2.computeNonDeclaredFunctions(name, descriptors$iv$iv2);
            return kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.compact(descriptors$iv$iv2);
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x005e  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final Collection<PropertyDescriptor> computeProperties(Name name) {
            List emptyList;
            Map bytesByName$iv = this.propertyProtosBytes;
            Parser PARSER = ProtoBuf.Property.PARSER;
            Intrinsics.checkNotNullExpressionValue(PARSER, "PARSER");
            DeserializedMemberScope deserializedMemberScope = this.this$0;
            DeserializedMemberScope deserializedMemberScope2 = this.this$0;
            OptimizedImplementation this_$iv = this;
            byte[] it$iv = bytesByName$iv.get(name);
            if (it$iv != null) {
                DeserializedMemberScope deserializedMemberScope3 = this_$iv.this$0;
                ByteArrayInputStream inputStream$iv = new ByteArrayInputStream(it$iv);
                List list = SequencesKt.toList(SequencesKt.generateSequence(new DeserializedMemberScope$OptimizedImplementation$computeDescriptors$1$1(PARSER, inputStream$iv, deserializedMemberScope3)));
                if (list != null) {
                    emptyList = list;
                    Iterable $this$mapNotNullTo$iv$iv$iv = emptyList;
                    Collection destination$iv$iv$iv = new ArrayList(emptyList.size());
                    for (Object element$iv$iv$iv$iv : $this$mapNotNullTo$iv$iv$iv) {
                        ProtoBuf.Property it = (ProtoBuf.Property) element$iv$iv$iv$iv;
                        Map bytesByName$iv2 = bytesByName$iv;
                        MemberDeserializer memberDeserializer = deserializedMemberScope.getC().getMemberDeserializer();
                        Intrinsics.checkNotNull(it);
                        Parser parser$iv = PARSER;
                        DeserializedMemberScope deserializedMemberScope4 = deserializedMemberScope;
                        OptimizedImplementation this_$iv2 = this_$iv;
                        PropertyDescriptor loadProperty$default = MemberDeserializer.loadProperty$default(memberDeserializer, it, false, 2, null);
                        if (loadProperty$default != null) {
                            destination$iv$iv$iv.add(loadProperty$default);
                        }
                        PARSER = parser$iv;
                        bytesByName$iv = bytesByName$iv2;
                        deserializedMemberScope = deserializedMemberScope4;
                        this_$iv = this_$iv2;
                    }
                    ArrayList descriptors$iv$iv = (ArrayList) destination$iv$iv$iv;
                    deserializedMemberScope2.computeNonDeclaredProperties(name, descriptors$iv$iv);
                    return kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.compact(descriptors$iv$iv);
                }
            }
            emptyList = CollectionsKt.emptyList();
            Iterable $this$mapNotNullTo$iv$iv$iv2 = emptyList;
            Collection destination$iv$iv$iv2 = new ArrayList(emptyList.size());
            while (r16.hasNext()) {
            }
            ArrayList descriptors$iv$iv2 = (ArrayList) destination$iv$iv$iv2;
            deserializedMemberScope2.computeNonDeclaredProperties(name, descriptors$iv$iv2);
            return kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.compact(descriptors$iv$iv2);
        }

        private final TypeAliasDescriptor createTypeAlias(Name name) {
            ProtoBuf.TypeAlias proto;
            byte[] byteArray = this.typeAliasBytes.get(name);
            if (byteArray == null || (proto = ProtoBuf.TypeAlias.parseDelimitedFrom(new ByteArrayInputStream(byteArray), this.this$0.getC().getComponents().getExtensionRegistryLite())) == null) {
                return null;
            }
            return this.this$0.getC().getMemberDeserializer().loadTypeAlias(proto);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.Implementation
        public Collection<SimpleFunctionDescriptor> getContributedFunctions(Name name, LookupLocation location2) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(location2, "location");
            return !getFunctionNames().contains(name) ? CollectionsKt.emptyList() : this.functions.invoke(name);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.Implementation
        public TypeAliasDescriptor getTypeAliasByName(Name name) {
            Intrinsics.checkNotNullParameter(name, "name");
            return this.typeAliasByName.invoke(name);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.Implementation
        public Collection<PropertyDescriptor> getContributedVariables(Name name, LookupLocation location2) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(location2, "location");
            return !getVariableNames().contains(name) ? CollectionsKt.emptyList() : this.properties.invoke(name);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.Implementation
        public void addFunctionsAndPropertiesTo(Collection<DeclarationDescriptor> result, DescriptorKindFilter kindFilter, Function1<? super Name, Boolean> nameFilter, LookupLocation location2) {
            Intrinsics.checkNotNullParameter(result, "result");
            Intrinsics.checkNotNullParameter(kindFilter, "kindFilter");
            Intrinsics.checkNotNullParameter(nameFilter, "nameFilter");
            Intrinsics.checkNotNullParameter(location2, "location");
            if (kindFilter.acceptsKinds(DescriptorKindFilter.Companion.getVARIABLES_MASK())) {
                Collection names$iv = getVariableNames();
                ArrayList subResult$iv = new ArrayList();
                for (Name name$iv : names$iv) {
                    if (nameFilter.invoke(name$iv).booleanValue()) {
                        subResult$iv.addAll(getContributedVariables(name$iv, location2));
                    }
                }
                MemberComparator.NameAndTypeMemberComparator INSTANCE = MemberComparator.NameAndTypeMemberComparator.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(INSTANCE, "INSTANCE");
                CollectionsKt.sortWith(subResult$iv, INSTANCE);
                result.addAll(subResult$iv);
            }
            if (kindFilter.acceptsKinds(DescriptorKindFilter.Companion.getFUNCTIONS_MASK())) {
                Collection names$iv2 = getFunctionNames();
                ArrayList subResult$iv2 = new ArrayList();
                for (Name name$iv2 : names$iv2) {
                    if (nameFilter.invoke(name$iv2).booleanValue()) {
                        subResult$iv2.addAll(getContributedFunctions(name$iv2, location2));
                    }
                }
                MemberComparator.NameAndTypeMemberComparator INSTANCE2 = MemberComparator.NameAndTypeMemberComparator.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(INSTANCE2, "INSTANCE");
                CollectionsKt.sortWith(subResult$iv2, INSTANCE2);
                result.addAll(subResult$iv2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DeserializedMemberScope.kt */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public final class NoReorderImplementation implements Implementation {
        static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(NoReorderImplementation.class, "declaredFunctions", "getDeclaredFunctions()Ljava/util/List;", 0)), Reflection.property1(new PropertyReference1Impl(NoReorderImplementation.class, "declaredProperties", "getDeclaredProperties()Ljava/util/List;", 0)), Reflection.property1(new PropertyReference1Impl(NoReorderImplementation.class, "allTypeAliases", "getAllTypeAliases()Ljava/util/List;", 0)), Reflection.property1(new PropertyReference1Impl(NoReorderImplementation.class, "allFunctions", "getAllFunctions()Ljava/util/List;", 0)), Reflection.property1(new PropertyReference1Impl(NoReorderImplementation.class, "allProperties", "getAllProperties()Ljava/util/List;", 0)), Reflection.property1(new PropertyReference1Impl(NoReorderImplementation.class, "typeAliasesByName", "getTypeAliasesByName()Ljava/util/Map;", 0)), Reflection.property1(new PropertyReference1Impl(NoReorderImplementation.class, "functionsByName", "getFunctionsByName()Ljava/util/Map;", 0)), Reflection.property1(new PropertyReference1Impl(NoReorderImplementation.class, "propertiesByName", "getPropertiesByName()Ljava/util/Map;", 0)), Reflection.property1(new PropertyReference1Impl(NoReorderImplementation.class, "functionNames", "getFunctionNames()Ljava/util/Set;", 0)), Reflection.property1(new PropertyReference1Impl(NoReorderImplementation.class, "variableNames", "getVariableNames()Ljava/util/Set;", 0))};
        private final NotNullLazyValue allFunctions$delegate;
        private final NotNullLazyValue allProperties$delegate;
        private final NotNullLazyValue allTypeAliases$delegate;
        private final NotNullLazyValue declaredFunctions$delegate;
        private final NotNullLazyValue declaredProperties$delegate;
        private final List<ProtoBuf.Function> functionList;
        private final NotNullLazyValue functionNames$delegate;
        private final NotNullLazyValue functionsByName$delegate;
        private final NotNullLazyValue propertiesByName$delegate;
        private final List<ProtoBuf.Property> propertyList;
        final /* synthetic */ DeserializedMemberScope this$0;
        private final List<ProtoBuf.TypeAlias> typeAliasList;
        private final NotNullLazyValue typeAliasesByName$delegate;
        private final NotNullLazyValue variableNames$delegate;

        public NoReorderImplementation(DeserializedMemberScope this$0, List<ProtoBuf.Function> functionList, List<ProtoBuf.Property> propertyList, List<ProtoBuf.TypeAlias> typeAliasList) {
            Intrinsics.checkNotNullParameter(functionList, "functionList");
            Intrinsics.checkNotNullParameter(propertyList, "propertyList");
            Intrinsics.checkNotNullParameter(typeAliasList, "typeAliasList");
            this.this$0 = this$0;
            this.functionList = functionList;
            this.propertyList = propertyList;
            this.typeAliasList = this.this$0.getC().getComponents().getConfiguration().getTypeAliasesAllowed() ? typeAliasList : CollectionsKt.emptyList();
            this.declaredFunctions$delegate = this.this$0.getC().getStorageManager().createLazyValue(new Function0(this) { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope$NoReorderImplementation$$Lambda$0
                private final DeserializedMemberScope.NoReorderImplementation arg$0;

                {
                    this.arg$0 = this;
                }

                @Override // kotlin.jvm.functions.Function0
                public Object invoke() {
                    List computeFunctions;
                    computeFunctions = this.arg$0.computeFunctions();
                    return computeFunctions;
                }
            });
            this.declaredProperties$delegate = this.this$0.getC().getStorageManager().createLazyValue(new Function0(this) { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope$NoReorderImplementation$$Lambda$1
                private final DeserializedMemberScope.NoReorderImplementation arg$0;

                {
                    this.arg$0 = this;
                }

                @Override // kotlin.jvm.functions.Function0
                public Object invoke() {
                    List computeProperties;
                    computeProperties = this.arg$0.computeProperties();
                    return computeProperties;
                }
            });
            this.allTypeAliases$delegate = this.this$0.getC().getStorageManager().createLazyValue(new Function0(this) { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope$NoReorderImplementation$$Lambda$2
                private final DeserializedMemberScope.NoReorderImplementation arg$0;

                {
                    this.arg$0 = this;
                }

                @Override // kotlin.jvm.functions.Function0
                public Object invoke() {
                    List computeTypeAliases;
                    computeTypeAliases = this.arg$0.computeTypeAliases();
                    return computeTypeAliases;
                }
            });
            this.allFunctions$delegate = this.this$0.getC().getStorageManager().createLazyValue(new Function0(this) { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope$NoReorderImplementation$$Lambda$3
                private final DeserializedMemberScope.NoReorderImplementation arg$0;

                {
                    this.arg$0 = this;
                }

                @Override // kotlin.jvm.functions.Function0
                public Object invoke() {
                    List allFunctions_delegate$lambda$0;
                    allFunctions_delegate$lambda$0 = DeserializedMemberScope.NoReorderImplementation.allFunctions_delegate$lambda$0(this.arg$0);
                    return allFunctions_delegate$lambda$0;
                }
            });
            this.allProperties$delegate = this.this$0.getC().getStorageManager().createLazyValue(new Function0(this) { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope$NoReorderImplementation$$Lambda$4
                private final DeserializedMemberScope.NoReorderImplementation arg$0;

                {
                    this.arg$0 = this;
                }

                @Override // kotlin.jvm.functions.Function0
                public Object invoke() {
                    List allProperties_delegate$lambda$0;
                    allProperties_delegate$lambda$0 = DeserializedMemberScope.NoReorderImplementation.allProperties_delegate$lambda$0(this.arg$0);
                    return allProperties_delegate$lambda$0;
                }
            });
            this.typeAliasesByName$delegate = this.this$0.getC().getStorageManager().createLazyValue(new Function0(this) { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope$NoReorderImplementation$$Lambda$5
                private final DeserializedMemberScope.NoReorderImplementation arg$0;

                {
                    this.arg$0 = this;
                }

                @Override // kotlin.jvm.functions.Function0
                public Object invoke() {
                    Map typeAliasesByName_delegate$lambda$0;
                    typeAliasesByName_delegate$lambda$0 = DeserializedMemberScope.NoReorderImplementation.typeAliasesByName_delegate$lambda$0(this.arg$0);
                    return typeAliasesByName_delegate$lambda$0;
                }
            });
            this.functionsByName$delegate = this.this$0.getC().getStorageManager().createLazyValue(new Function0(this) { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope$NoReorderImplementation$$Lambda$6
                private final DeserializedMemberScope.NoReorderImplementation arg$0;

                {
                    this.arg$0 = this;
                }

                @Override // kotlin.jvm.functions.Function0
                public Object invoke() {
                    Map functionsByName_delegate$lambda$0;
                    functionsByName_delegate$lambda$0 = DeserializedMemberScope.NoReorderImplementation.functionsByName_delegate$lambda$0(this.arg$0);
                    return functionsByName_delegate$lambda$0;
                }
            });
            this.propertiesByName$delegate = this.this$0.getC().getStorageManager().createLazyValue(new Function0(this) { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope$NoReorderImplementation$$Lambda$7
                private final DeserializedMemberScope.NoReorderImplementation arg$0;

                {
                    this.arg$0 = this;
                }

                @Override // kotlin.jvm.functions.Function0
                public Object invoke() {
                    Map propertiesByName_delegate$lambda$0;
                    propertiesByName_delegate$lambda$0 = DeserializedMemberScope.NoReorderImplementation.propertiesByName_delegate$lambda$0(this.arg$0);
                    return propertiesByName_delegate$lambda$0;
                }
            });
            StorageManager storageManager = this.this$0.getC().getStorageManager();
            final DeserializedMemberScope deserializedMemberScope = this.this$0;
            this.functionNames$delegate = storageManager.createLazyValue(new Function0(this, deserializedMemberScope) { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope$NoReorderImplementation$$Lambda$8
                private final DeserializedMemberScope.NoReorderImplementation arg$0;
                private final DeserializedMemberScope arg$1;

                {
                    this.arg$0 = this;
                    this.arg$1 = deserializedMemberScope;
                }

                @Override // kotlin.jvm.functions.Function0
                public Object invoke() {
                    Set functionNames_delegate$lambda$0;
                    functionNames_delegate$lambda$0 = DeserializedMemberScope.NoReorderImplementation.functionNames_delegate$lambda$0(this.arg$0, this.arg$1);
                    return functionNames_delegate$lambda$0;
                }
            });
            StorageManager storageManager2 = this.this$0.getC().getStorageManager();
            final DeserializedMemberScope deserializedMemberScope2 = this.this$0;
            this.variableNames$delegate = storageManager2.createLazyValue(new Function0(this, deserializedMemberScope2) { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope$NoReorderImplementation$$Lambda$9
                private final DeserializedMemberScope.NoReorderImplementation arg$0;
                private final DeserializedMemberScope arg$1;

                {
                    this.arg$0 = this;
                    this.arg$1 = deserializedMemberScope2;
                }

                @Override // kotlin.jvm.functions.Function0
                public Object invoke() {
                    Set variableNames_delegate$lambda$0;
                    variableNames_delegate$lambda$0 = DeserializedMemberScope.NoReorderImplementation.variableNames_delegate$lambda$0(this.arg$0, this.arg$1);
                    return variableNames_delegate$lambda$0;
                }
            });
        }

        private final List<SimpleFunctionDescriptor> getDeclaredFunctions() {
            return (List) StorageKt.getValue(this.declaredFunctions$delegate, this, $$delegatedProperties[0]);
        }

        private final List<PropertyDescriptor> getDeclaredProperties() {
            return (List) StorageKt.getValue(this.declaredProperties$delegate, this, $$delegatedProperties[1]);
        }

        private final List<TypeAliasDescriptor> getAllTypeAliases() {
            return (List) StorageKt.getValue(this.allTypeAliases$delegate, this, $$delegatedProperties[2]);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final List allFunctions_delegate$lambda$0(NoReorderImplementation this$0) {
            return CollectionsKt.plus((Collection) this$0.getDeclaredFunctions(), (Iterable) this$0.computeAllNonDeclaredFunctions());
        }

        private final List<SimpleFunctionDescriptor> getAllFunctions() {
            return (List) StorageKt.getValue(this.allFunctions$delegate, this, $$delegatedProperties[3]);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final List allProperties_delegate$lambda$0(NoReorderImplementation this$0) {
            return CollectionsKt.plus((Collection) this$0.getDeclaredProperties(), (Iterable) this$0.computeAllNonDeclaredProperties());
        }

        private final List<PropertyDescriptor> getAllProperties() {
            return (List) StorageKt.getValue(this.allProperties$delegate, this, $$delegatedProperties[4]);
        }

        private final Map<Name, TypeAliasDescriptor> getTypeAliasesByName() {
            return (Map) StorageKt.getValue(this.typeAliasesByName$delegate, this, $$delegatedProperties[5]);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Map typeAliasesByName_delegate$lambda$0(NoReorderImplementation this$0) {
            Iterable $this$associateBy$iv = this$0.getAllTypeAliases();
            int capacity$iv = RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associateBy$iv, 10)), 16);
            Map destination$iv$iv = new LinkedHashMap(capacity$iv);
            for (Object element$iv$iv : $this$associateBy$iv) {
                TypeAliasDescriptor it = (TypeAliasDescriptor) element$iv$iv;
                Name name = it.getName();
                Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                destination$iv$iv.put(name, element$iv$iv);
            }
            return destination$iv$iv;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Map functionsByName_delegate$lambda$0(NoReorderImplementation this$0) {
            ArrayList arrayList;
            Iterable $this$groupBy$iv = this$0.getAllFunctions();
            Map destination$iv$iv = new LinkedHashMap();
            for (Object element$iv$iv : $this$groupBy$iv) {
                SimpleFunctionDescriptor it = (SimpleFunctionDescriptor) element$iv$iv;
                Name name = it.getName();
                Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                Object value$iv$iv$iv = destination$iv$iv.get(name);
                if (value$iv$iv$iv == null) {
                    arrayList = new ArrayList();
                    destination$iv$iv.put(name, arrayList);
                } else {
                    arrayList = value$iv$iv$iv;
                }
                Object key$iv$iv$iv = arrayList;
                List list$iv$iv = (List) key$iv$iv$iv;
                list$iv$iv.add(element$iv$iv);
            }
            return destination$iv$iv;
        }

        private final Map<Name, Collection<SimpleFunctionDescriptor>> getFunctionsByName() {
            return (Map) StorageKt.getValue(this.functionsByName$delegate, this, $$delegatedProperties[6]);
        }

        private final Map<Name, Collection<PropertyDescriptor>> getPropertiesByName() {
            return (Map) StorageKt.getValue(this.propertiesByName$delegate, this, $$delegatedProperties[7]);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Map propertiesByName_delegate$lambda$0(NoReorderImplementation this$0) {
            ArrayList arrayList;
            Iterable $this$groupBy$iv = this$0.getAllProperties();
            Map destination$iv$iv = new LinkedHashMap();
            for (Object element$iv$iv : $this$groupBy$iv) {
                PropertyDescriptor it = (PropertyDescriptor) element$iv$iv;
                Name name = it.getName();
                Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                Object value$iv$iv$iv = destination$iv$iv.get(name);
                if (value$iv$iv$iv == null) {
                    arrayList = new ArrayList();
                    destination$iv$iv.put(name, arrayList);
                } else {
                    arrayList = value$iv$iv$iv;
                }
                Object key$iv$iv$iv = arrayList;
                List list$iv$iv = (List) key$iv$iv$iv;
                list$iv$iv.add(element$iv$iv);
            }
            return destination$iv$iv;
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.Implementation
        public Set<Name> getFunctionNames() {
            return (Set) StorageKt.getValue(this.functionNames$delegate, this, $$delegatedProperties[8]);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Set functionNames_delegate$lambda$0(NoReorderImplementation this$0, DeserializedMemberScope this$1) {
            Iterable $this$mapToNames$iv = this$0.functionList;
            Iterable $this$mapTo$iv$iv = $this$mapToNames$iv;
            Collection destination$iv$iv = (Set) new LinkedHashSet();
            DeserializedMemberScope deserializedMemberScope = this$0.this$0;
            for (Object item$iv$iv : $this$mapTo$iv$iv) {
                MessageLite it$iv = (MessageLite) item$iv$iv;
                ProtoBuf.Function it = (ProtoBuf.Function) it$iv;
                destination$iv$iv.add(NameResolverUtilKt.getName(deserializedMemberScope.getC().getNameResolver(), it.getName()));
            }
            return SetsKt.plus((Set) ((Set) destination$iv$iv), (Iterable) this$1.getNonDeclaredFunctionNames());
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.Implementation
        public Set<Name> getVariableNames() {
            return (Set) StorageKt.getValue(this.variableNames$delegate, this, $$delegatedProperties[9]);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Set variableNames_delegate$lambda$0(NoReorderImplementation this$0, DeserializedMemberScope this$1) {
            Iterable $this$mapToNames$iv = this$0.propertyList;
            Iterable $this$mapTo$iv$iv = $this$mapToNames$iv;
            Collection destination$iv$iv = (Set) new LinkedHashSet();
            DeserializedMemberScope deserializedMemberScope = this$0.this$0;
            for (Object item$iv$iv : $this$mapTo$iv$iv) {
                MessageLite it$iv = (MessageLite) item$iv$iv;
                ProtoBuf.Property it = (ProtoBuf.Property) it$iv;
                destination$iv$iv.add(NameResolverUtilKt.getName(deserializedMemberScope.getC().getNameResolver(), it.getName()));
            }
            return SetsKt.plus((Set) ((Set) destination$iv$iv), (Iterable) this$1.getNonDeclaredVariableNames());
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.Implementation
        public Set<Name> getTypeAliasNames() {
            Iterable $this$mapToNames$iv = this.typeAliasList;
            Iterable $this$mapTo$iv$iv = $this$mapToNames$iv;
            Collection destination$iv$iv = (Set) new LinkedHashSet();
            DeserializedMemberScope deserializedMemberScope = this.this$0;
            for (Object item$iv$iv : $this$mapTo$iv$iv) {
                MessageLite it$iv = (MessageLite) item$iv$iv;
                ProtoBuf.TypeAlias it = (ProtoBuf.TypeAlias) it$iv;
                destination$iv$iv.add(NameResolverUtilKt.getName(deserializedMemberScope.getC().getNameResolver(), it.getName()));
            }
            return (Set) destination$iv$iv;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List<SimpleFunctionDescriptor> computeFunctions() {
            List $this$mapWithDeserializer$iv = this.functionList;
            DeserializedMemberScope deserializedMemberScope = this.this$0;
            List $this$mapNotNull$iv$iv = $this$mapWithDeserializer$iv;
            DeserializedMemberScope deserializedMemberScope2 = this.this$0;
            Collection destination$iv$iv$iv = new ArrayList();
            for (Object element$iv$iv$iv$iv : $this$mapNotNull$iv$iv) {
                MessageLite it$iv = (MessageLite) element$iv$iv$iv$iv;
                MemberDeserializer $this$computeFunctions_u24lambda_u240 = deserializedMemberScope2.getC().getMemberDeserializer();
                ProtoBuf.Function it = (ProtoBuf.Function) it$iv;
                List $this$mapWithDeserializer$iv2 = $this$mapWithDeserializer$iv;
                SimpleFunctionDescriptor p0 = $this$computeFunctions_u24lambda_u240.loadFunction(it);
                if (!deserializedMemberScope.isDeclaredFunctionAvailable(p0)) {
                    p0 = null;
                }
                SimpleFunctionDescriptor simpleFunctionDescriptor = p0;
                if (simpleFunctionDescriptor != null) {
                    destination$iv$iv$iv.add(simpleFunctionDescriptor);
                }
                $this$mapWithDeserializer$iv = $this$mapWithDeserializer$iv2;
            }
            return (List) destination$iv$iv$iv;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List<PropertyDescriptor> computeProperties() {
            List $this$mapWithDeserializer$iv = this.propertyList;
            NoReorderImplementation this_$iv = this;
            int $i$f$mapWithDeserializer = 0;
            List $this$mapNotNull$iv$iv = $this$mapWithDeserializer$iv;
            DeserializedMemberScope deserializedMemberScope = this_$iv.this$0;
            Collection destination$iv$iv$iv = new ArrayList();
            for (Object element$iv$iv$iv$iv : $this$mapNotNull$iv$iv) {
                MessageLite it$iv = (MessageLite) element$iv$iv$iv$iv;
                MemberDeserializer $this$computeProperties_u24lambda_u240 = deserializedMemberScope.getC().getMemberDeserializer();
                List $this$mapWithDeserializer$iv2 = $this$mapWithDeserializer$iv;
                ProtoBuf.Property it = (ProtoBuf.Property) it$iv;
                NoReorderImplementation this_$iv2 = this_$iv;
                int $i$f$mapWithDeserializer2 = $i$f$mapWithDeserializer;
                Iterable $this$mapNotNull$iv$iv2 = $this$mapNotNull$iv$iv;
                PropertyDescriptor loadProperty$default = MemberDeserializer.loadProperty$default($this$computeProperties_u24lambda_u240, it, false, 2, null);
                if (loadProperty$default != null) {
                    destination$iv$iv$iv.add(loadProperty$default);
                }
                $this$mapWithDeserializer$iv = $this$mapWithDeserializer$iv2;
                this_$iv = this_$iv2;
                $i$f$mapWithDeserializer = $i$f$mapWithDeserializer2;
                $this$mapNotNull$iv$iv = $this$mapNotNull$iv$iv2;
            }
            return (List) destination$iv$iv$iv;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List<TypeAliasDescriptor> computeTypeAliases() {
            List $this$mapWithDeserializer$iv = this.typeAliasList;
            List $this$mapNotNull$iv$iv = $this$mapWithDeserializer$iv;
            DeserializedMemberScope deserializedMemberScope = this.this$0;
            Collection destination$iv$iv$iv = new ArrayList();
            for (Object element$iv$iv$iv$iv : $this$mapNotNull$iv$iv) {
                MessageLite it$iv = (MessageLite) element$iv$iv$iv$iv;
                MemberDeserializer $this$computeTypeAliases_u24lambda_u240 = deserializedMemberScope.getC().getMemberDeserializer();
                List $this$mapWithDeserializer$iv2 = $this$mapWithDeserializer$iv;
                ProtoBuf.TypeAlias it = (ProtoBuf.TypeAlias) it$iv;
                TypeAliasDescriptor loadTypeAlias = $this$computeTypeAliases_u24lambda_u240.loadTypeAlias(it);
                if (loadTypeAlias != null) {
                    destination$iv$iv$iv.add(loadTypeAlias);
                }
                $this$mapWithDeserializer$iv = $this$mapWithDeserializer$iv2;
            }
            return (List) destination$iv$iv$iv;
        }

        private final List<SimpleFunctionDescriptor> computeAllNonDeclaredFunctions() {
            Iterable $this$flatMap$iv = this.this$0.getNonDeclaredFunctionNames();
            Collection destination$iv$iv = new ArrayList();
            for (Object element$iv$iv : $this$flatMap$iv) {
                Name it = (Name) element$iv$iv;
                Iterable list$iv$iv = computeNonDeclaredFunctionsForName(it);
                CollectionsKt.addAll(destination$iv$iv, list$iv$iv);
            }
            return (List) destination$iv$iv;
        }

        private final List<PropertyDescriptor> computeAllNonDeclaredProperties() {
            Iterable $this$flatMap$iv = this.this$0.getNonDeclaredVariableNames();
            Collection destination$iv$iv = new ArrayList();
            for (Object element$iv$iv : $this$flatMap$iv) {
                Name it = (Name) element$iv$iv;
                Iterable list$iv$iv = computeNonDeclaredPropertiesForName(it);
                CollectionsKt.addAll(destination$iv$iv, list$iv$iv);
            }
            return (List) destination$iv$iv;
        }

        private final List<SimpleFunctionDescriptor> computeNonDeclaredFunctionsForName(Name name) {
            Iterable declaredDescriptors$iv = getDeclaredFunctions();
            DeserializedMemberScope deserializedMemberScope = this.this$0;
            Iterable $this$filterTo$iv$iv = declaredDescriptors$iv;
            Collection destination$iv$iv = (List) new ArrayList();
            for (Object element$iv$iv : $this$filterTo$iv$iv) {
                DeclarationDescriptor it$iv = (DeclarationDescriptor) element$iv$iv;
                if (Intrinsics.areEqual(it$iv.getName(), name)) {
                    destination$iv$iv.add(element$iv$iv);
                }
            }
            List declaredDescriptorsWithSameName$iv = (List) destination$iv$iv;
            int nonDeclaredPropertiesStartIndex$iv = declaredDescriptorsWithSameName$iv.size();
            deserializedMemberScope.computeNonDeclaredFunctions(name, declaredDescriptorsWithSameName$iv);
            List declaredDescriptors$iv2 = declaredDescriptorsWithSameName$iv.subList(nonDeclaredPropertiesStartIndex$iv, declaredDescriptorsWithSameName$iv.size());
            return declaredDescriptors$iv2;
        }

        private final List<PropertyDescriptor> computeNonDeclaredPropertiesForName(Name name) {
            Iterable declaredDescriptors$iv = getDeclaredProperties();
            DeserializedMemberScope deserializedMemberScope = this.this$0;
            Iterable $this$filterTo$iv$iv = declaredDescriptors$iv;
            Collection destination$iv$iv = (List) new ArrayList();
            for (Object element$iv$iv : $this$filterTo$iv$iv) {
                DeclarationDescriptor it$iv = (DeclarationDescriptor) element$iv$iv;
                if (Intrinsics.areEqual(it$iv.getName(), name)) {
                    destination$iv$iv.add(element$iv$iv);
                }
            }
            List declaredDescriptorsWithSameName$iv = (List) destination$iv$iv;
            int nonDeclaredPropertiesStartIndex$iv = declaredDescriptorsWithSameName$iv.size();
            deserializedMemberScope.computeNonDeclaredProperties(name, declaredDescriptorsWithSameName$iv);
            List declaredDescriptors$iv2 = declaredDescriptorsWithSameName$iv.subList(nonDeclaredPropertiesStartIndex$iv, declaredDescriptorsWithSameName$iv.size());
            return declaredDescriptors$iv2;
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.Implementation
        public Collection<SimpleFunctionDescriptor> getContributedFunctions(Name name, LookupLocation location2) {
            Collection<SimpleFunctionDescriptor> collection;
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(location2, "location");
            return (getFunctionNames().contains(name) && (collection = getFunctionsByName().get(name)) != null) ? collection : CollectionsKt.emptyList();
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.Implementation
        public TypeAliasDescriptor getTypeAliasByName(Name name) {
            Intrinsics.checkNotNullParameter(name, "name");
            return getTypeAliasesByName().get(name);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.Implementation
        public Collection<PropertyDescriptor> getContributedVariables(Name name, LookupLocation location2) {
            Collection<PropertyDescriptor> collection;
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(location2, "location");
            return (getVariableNames().contains(name) && (collection = getPropertiesByName().get(name)) != null) ? collection : CollectionsKt.emptyList();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.Implementation
        public void addFunctionsAndPropertiesTo(Collection<DeclarationDescriptor> result, DescriptorKindFilter kindFilter, Function1<? super Name, Boolean> nameFilter, LookupLocation location2) {
            Intrinsics.checkNotNullParameter(result, "result");
            Intrinsics.checkNotNullParameter(kindFilter, "kindFilter");
            Intrinsics.checkNotNullParameter(nameFilter, "nameFilter");
            Intrinsics.checkNotNullParameter(location2, "location");
            if (kindFilter.acceptsKinds(DescriptorKindFilter.Companion.getVARIABLES_MASK())) {
                Iterable $this$filterTo$iv = getAllProperties();
                for (Object element$iv : $this$filterTo$iv) {
                    PropertyDescriptor it = (PropertyDescriptor) element$iv;
                    Name name = it.getName();
                    Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                    if (nameFilter.invoke(name).booleanValue()) {
                        result.add(element$iv);
                    }
                }
            }
            if (kindFilter.acceptsKinds(DescriptorKindFilter.Companion.getFUNCTIONS_MASK())) {
                Iterable $this$filterTo$iv2 = getAllFunctions();
                for (Object element$iv2 : $this$filterTo$iv2) {
                    SimpleFunctionDescriptor it2 = (SimpleFunctionDescriptor) element$iv2;
                    Name name2 = it2.getName();
                    Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
                    if (nameFilter.invoke(name2).booleanValue()) {
                        result.add(element$iv2);
                    }
                }
            }
        }
    }
}