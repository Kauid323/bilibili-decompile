package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.NonReportingOverrideStrategy;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.utils.SmartList;

/* compiled from: GivenFunctionsMemberScope.kt */
public abstract class GivenFunctionsMemberScope extends MemberScopeImpl {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(GivenFunctionsMemberScope.class, "allDescriptors", "getAllDescriptors()Ljava/util/List;", 0))};
    private final NotNullLazyValue allDescriptors$delegate;
    private final ClassDescriptor containingClass;

    protected abstract List<FunctionDescriptor> computeDeclaredFunctions();

    public GivenFunctionsMemberScope(StorageManager storageManager, ClassDescriptor containingClass) {
        Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics.checkNotNullParameter(containingClass, "containingClass");
        this.containingClass = containingClass;
        this.allDescriptors$delegate = storageManager.createLazyValue(new Function0(this) { // from class: kotlin.reflect.jvm.internal.impl.resolve.scopes.GivenFunctionsMemberScope$$Lambda$0
            private final GivenFunctionsMemberScope arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                List allDescriptors_delegate$lambda$0;
                allDescriptors_delegate$lambda$0 = GivenFunctionsMemberScope.allDescriptors_delegate$lambda$0(this.arg$0);
                return allDescriptors_delegate$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final ClassDescriptor getContainingClass() {
        return this.containingClass;
    }

    private final List<DeclarationDescriptor> getAllDescriptors() {
        return (List) StorageKt.getValue(this.allDescriptors$delegate, this, $$delegatedProperties[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List allDescriptors_delegate$lambda$0(GivenFunctionsMemberScope this$0) {
        List fromCurrent = this$0.computeDeclaredFunctions();
        return CollectionsKt.plus((Collection) fromCurrent, (Iterable) this$0.createFakeOverrides(fromCurrent));
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public Collection<DeclarationDescriptor> getContributedDescriptors(DescriptorKindFilter kindFilter, Function1<? super Name, Boolean> nameFilter) {
        Intrinsics.checkNotNullParameter(kindFilter, "kindFilter");
        Intrinsics.checkNotNullParameter(nameFilter, "nameFilter");
        return !kindFilter.acceptsKinds(DescriptorKindFilter.CALLABLES.getKindMask()) ? CollectionsKt.emptyList() : getAllDescriptors();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public Collection<SimpleFunctionDescriptor> getContributedFunctions(Name name, LookupLocation location2) {
        Collection<SimpleFunctionDescriptor> collection;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(location2, "location");
        Collection $this$filterIsInstanceAnd$iv = getAllDescriptors();
        if ($this$filterIsInstanceAnd$iv.isEmpty()) {
            collection = CollectionsKt.emptyList();
        } else {
            Collection $this$filterIsInstanceAndTo$iv$iv = $this$filterIsInstanceAnd$iv;
            Collection destination$iv$iv = new SmartList();
            for (Object element$iv$iv : $this$filterIsInstanceAndTo$iv$iv) {
                if (element$iv$iv instanceof SimpleFunctionDescriptor) {
                    SimpleFunctionDescriptor it = (SimpleFunctionDescriptor) element$iv$iv;
                    if (Intrinsics.areEqual(it.getName(), name)) {
                        destination$iv$iv.add(element$iv$iv);
                    }
                }
            }
            collection = (List) destination$iv$iv;
        }
        return collection;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Collection<PropertyDescriptor> getContributedVariables(Name name, LookupLocation location2) {
        Collection<PropertyDescriptor> collection;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(location2, "location");
        Collection $this$filterIsInstanceAnd$iv = getAllDescriptors();
        if ($this$filterIsInstanceAnd$iv.isEmpty()) {
            collection = CollectionsKt.emptyList();
        } else {
            Collection $this$filterIsInstanceAndTo$iv$iv = $this$filterIsInstanceAnd$iv;
            Collection destination$iv$iv = new SmartList();
            for (Object element$iv$iv : $this$filterIsInstanceAndTo$iv$iv) {
                if (element$iv$iv instanceof PropertyDescriptor) {
                    PropertyDescriptor it = (PropertyDescriptor) element$iv$iv;
                    if (Intrinsics.areEqual(it.getName(), name)) {
                        destination$iv$iv.add(element$iv$iv);
                    }
                }
            }
            collection = (List) destination$iv$iv;
        }
        return collection;
    }

    private final List<DeclarationDescriptor> createFakeOverrides(List<? extends FunctionDescriptor> list) {
        Iterator it;
        Iterator it2;
        List emptyList;
        List allSuperDescriptors;
        ArrayList arrayList;
        ArrayList arrayList2;
        final ArrayList result = new ArrayList(3);
        Iterable mo1172getSupertypes = this.containingClass.getTypeConstructor().mo1172getSupertypes();
        Intrinsics.checkNotNullExpressionValue(mo1172getSupertypes, "getSupertypes(...)");
        Iterable<KotlinType> $this$flatMap$iv = mo1172getSupertypes;
        Collection destination$iv$iv = new ArrayList();
        for (KotlinType it3 : $this$flatMap$iv) {
            CollectionsKt.addAll(destination$iv$iv, ResolutionScope.DefaultImpls.getContributedDescriptors$default(it3.getMemberScope(), null, null, 3, null));
        }
        Iterable $this$filterIsInstance$iv = (List) destination$iv$iv;
        Collection destination$iv$iv2 = new ArrayList();
        for (Object element$iv$iv : $this$filterIsInstance$iv) {
            if (element$iv$iv instanceof CallableMemberDescriptor) {
                destination$iv$iv2.add(element$iv$iv);
            }
        }
        List list$iv$iv = (List) destination$iv$iv2;
        List $this$groupBy$iv = list$iv$iv;
        Map destination$iv$iv3 = new LinkedHashMap();
        for (Object element$iv$iv2 : $this$groupBy$iv) {
            CallableMemberDescriptor it4 = (CallableMemberDescriptor) element$iv$iv2;
            Name name = it4.getName();
            Object value$iv$iv$iv = destination$iv$iv3.get(name);
            if (value$iv$iv$iv == null) {
                arrayList2 = new ArrayList();
                destination$iv$iv3.put(name, arrayList2);
            } else {
                arrayList2 = value$iv$iv$iv;
            }
            Object key$iv$iv$iv = arrayList2;
            ((List) key$iv$iv$iv).add(element$iv$iv2);
        }
        Iterator it5 = destination$iv$iv3.entrySet().iterator();
        while (it5.hasNext()) {
            Map.Entry entry = (Map.Entry) it5.next();
            Object key = entry.getKey();
            Intrinsics.checkNotNullExpressionValue(key, "component1(...)");
            Name name2 = (Name) key;
            Iterable group = (List) entry.getValue();
            Iterable $this$groupBy$iv2 = group;
            Map destination$iv$iv4 = new LinkedHashMap();
            for (Object element$iv$iv3 : $this$groupBy$iv2) {
                CallableMemberDescriptor it6 = (CallableMemberDescriptor) element$iv$iv3;
                Boolean valueOf = Boolean.valueOf(it6 instanceof FunctionDescriptor);
                Object value$iv$iv$iv2 = destination$iv$iv4.get(valueOf);
                if (value$iv$iv$iv2 == null) {
                    arrayList = new ArrayList();
                    allSuperDescriptors = list$iv$iv;
                    destination$iv$iv4.put(valueOf, arrayList);
                } else {
                    allSuperDescriptors = list$iv$iv;
                    arrayList = value$iv$iv$iv2;
                }
                ((List) arrayList).add(element$iv$iv3);
                list$iv$iv = allSuperDescriptors;
            }
            List allSuperDescriptors2 = list$iv$iv;
            Iterator it7 = destination$iv$iv4.entrySet().iterator();
            while (it7.hasNext()) {
                Map.Entry entry2 = (Map.Entry) it7.next();
                boolean isFunction = ((Boolean) entry2.getKey()).booleanValue();
                List descriptors = (List) entry2.getValue();
                OverridingUtil overridingUtil = OverridingUtil.DEFAULT;
                List list2 = descriptors;
                if (isFunction) {
                    List<? extends FunctionDescriptor> $this$filter$iv = list;
                    Collection destination$iv$iv5 = new ArrayList();
                    for (Object element$iv$iv4 : $this$filter$iv) {
                        Iterator it8 = it7;
                        FunctionDescriptor it9 = (FunctionDescriptor) element$iv$iv4;
                        Iterator it10 = it5;
                        if (Intrinsics.areEqual(it9.getName(), name2)) {
                            destination$iv$iv5.add(element$iv$iv4);
                        }
                        it7 = it8;
                        it5 = it10;
                    }
                    it = it7;
                    it2 = it5;
                    emptyList = (List) destination$iv$iv5;
                } else {
                    it = it7;
                    it2 = it5;
                    emptyList = CollectionsKt.emptyList();
                }
                overridingUtil.generateOverridesInFunctionGroup(name2, list2, emptyList, this.containingClass, new NonReportingOverrideStrategy() { // from class: kotlin.reflect.jvm.internal.impl.resolve.scopes.GivenFunctionsMemberScope$createFakeOverrides$4
                    @Override // kotlin.reflect.jvm.internal.impl.resolve.OverridingStrategy
                    public void addFakeOverride(CallableMemberDescriptor fakeOverride) {
                        Intrinsics.checkNotNullParameter(fakeOverride, "fakeOverride");
                        OverridingUtil.resolveUnknownVisibilityForMember(fakeOverride, null);
                        result.add(fakeOverride);
                    }

                    @Override // kotlin.reflect.jvm.internal.impl.resolve.NonReportingOverrideStrategy
                    protected void conflict(CallableMemberDescriptor fromSuper, CallableMemberDescriptor fromCurrent) {
                        Intrinsics.checkNotNullParameter(fromSuper, "fromSuper");
                        Intrinsics.checkNotNullParameter(fromCurrent, "fromCurrent");
                        throw new IllegalStateException(("Conflict in scope of " + this.getContainingClass() + ": " + fromSuper + " vs " + fromCurrent).toString());
                    }
                });
                it7 = it;
                it5 = it2;
            }
            list$iv$iv = allSuperDescriptors2;
        }
        List allSuperDescriptors3 = kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.compact(result);
        return allSuperDescriptors3;
    }
}