package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.utils.SmartList;

/* compiled from: StaticScopeForKotlinEnum.kt */
public final class StaticScopeForKotlinEnum extends MemberScopeImpl {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(StaticScopeForKotlinEnum.class, "functions", "getFunctions()Ljava/util/List;", 0)), Reflection.property1(new PropertyReference1Impl(StaticScopeForKotlinEnum.class, "properties", "getProperties()Ljava/util/List;", 0))};
    private final ClassDescriptor containingClass;
    private final boolean enumEntriesCanBeUsed;
    private final NotNullLazyValue functions$delegate;
    private final NotNullLazyValue properties$delegate;

    public StaticScopeForKotlinEnum(StorageManager storageManager, ClassDescriptor containingClass, boolean enumEntriesCanBeUsed) {
        Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics.checkNotNullParameter(containingClass, "containingClass");
        this.containingClass = containingClass;
        this.enumEntriesCanBeUsed = enumEntriesCanBeUsed;
        if (!(this.containingClass.getKind() == ClassKind.ENUM_CLASS)) {
            throw new AssertionError("Class should be an enum: " + this.containingClass);
        }
        this.functions$delegate = storageManager.createLazyValue(new Function0(this) { // from class: kotlin.reflect.jvm.internal.impl.resolve.scopes.StaticScopeForKotlinEnum$$Lambda$0
            private final StaticScopeForKotlinEnum arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                List functions_delegate$lambda$0;
                functions_delegate$lambda$0 = StaticScopeForKotlinEnum.functions_delegate$lambda$0(this.arg$0);
                return functions_delegate$lambda$0;
            }
        });
        this.properties$delegate = storageManager.createLazyValue(new Function0(this) { // from class: kotlin.reflect.jvm.internal.impl.resolve.scopes.StaticScopeForKotlinEnum$$Lambda$1
            private final StaticScopeForKotlinEnum arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                List properties_delegate$lambda$0;
                properties_delegate$lambda$0 = StaticScopeForKotlinEnum.properties_delegate$lambda$0(this.arg$0);
                return properties_delegate$lambda$0;
            }
        });
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    /* renamed from: getContributedClassifier  reason: collision with other method in class */
    public /* bridge */ /* synthetic */ ClassifierDescriptor mo1173getContributedClassifier(Name name, LookupLocation location2) {
        return (ClassifierDescriptor) getContributedClassifier(name, location2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public /* bridge */ /* synthetic */ Collection getContributedDescriptors(DescriptorKindFilter kindFilter, Function1 nameFilter) {
        return getContributedDescriptors(kindFilter, (Function1<? super Name, Boolean>) nameFilter);
    }

    public Void getContributedClassifier(Name name, LookupLocation location2) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(location2, "location");
        return null;
    }

    private final List<SimpleFunctionDescriptor> getFunctions() {
        return (List) StorageKt.getValue(this.functions$delegate, this, $$delegatedProperties[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List functions_delegate$lambda$0(StaticScopeForKotlinEnum this$0) {
        return CollectionsKt.listOf((Object[]) new SimpleFunctionDescriptor[]{DescriptorFactory.createEnumValueOfMethod(this$0.containingClass), DescriptorFactory.createEnumValuesMethod(this$0.containingClass)});
    }

    private final List<PropertyDescriptor> getProperties() {
        return (List) StorageKt.getValue(this.properties$delegate, this, $$delegatedProperties[1]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List properties_delegate$lambda$0(StaticScopeForKotlinEnum this$0) {
        if (this$0.enumEntriesCanBeUsed) {
            return CollectionsKt.listOfNotNull(DescriptorFactory.createEnumEntriesProperty(this$0.containingClass));
        }
        return CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public List<CallableMemberDescriptor> getContributedDescriptors(DescriptorKindFilter kindFilter, Function1<? super Name, Boolean> nameFilter) {
        Intrinsics.checkNotNullParameter(kindFilter, "kindFilter");
        Intrinsics.checkNotNullParameter(nameFilter, "nameFilter");
        return CollectionsKt.plus((Collection) getFunctions(), (Iterable) getProperties());
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public SmartList<SimpleFunctionDescriptor> getContributedFunctions(Name name, LookupLocation location2) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(location2, "location");
        Iterable $this$filterTo$iv = getFunctions();
        Collection destination$iv = new SmartList();
        for (Object element$iv : $this$filterTo$iv) {
            SimpleFunctionDescriptor it = (SimpleFunctionDescriptor) element$iv;
            if (Intrinsics.areEqual(it.getName(), name)) {
                destination$iv.add(element$iv);
            }
        }
        return (SmartList) destination$iv;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Collection<PropertyDescriptor> getContributedVariables(Name name, LookupLocation location2) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(location2, "location");
        Iterable $this$filterTo$iv = getProperties();
        Collection destination$iv = new SmartList();
        for (Object element$iv : $this$filterTo$iv) {
            PropertyDescriptor it = (PropertyDescriptor) element$iv;
            if (Intrinsics.areEqual(it.getName(), name)) {
                destination$iv.add(element$iv);
            }
        }
        return destination$iv;
    }
}