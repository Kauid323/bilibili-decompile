package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.UtilsKt;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeKt;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.util.collectionUtils.ScopeUtilsKt;

/* compiled from: JvmPackageScope.kt */
public final class JvmPackageScope implements MemberScope {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(JvmPackageScope.class, "kotlinScopes", "getKotlinScopes()[Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;", 0))};
    private final LazyJavaResolverContext c;
    private final LazyJavaPackageScope javaScope;
    private final NotNullLazyValue kotlinScopes$delegate;
    private final LazyJavaPackageFragment packageFragment;

    public JvmPackageScope(LazyJavaResolverContext c, JavaPackage jPackage, LazyJavaPackageFragment packageFragment) {
        Intrinsics.checkNotNullParameter(c, "c");
        Intrinsics.checkNotNullParameter(jPackage, "jPackage");
        Intrinsics.checkNotNullParameter(packageFragment, "packageFragment");
        this.c = c;
        this.packageFragment = packageFragment;
        this.javaScope = new LazyJavaPackageScope(this.c, jPackage, this.packageFragment);
        this.kotlinScopes$delegate = this.c.getStorageManager().createLazyValue(new Function0(this) { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.JvmPackageScope$$Lambda$0
            private final JvmPackageScope arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                MemberScope[] kotlinScopes_delegate$lambda$0;
                kotlinScopes_delegate$lambda$0 = JvmPackageScope.kotlinScopes_delegate$lambda$0(this.arg$0);
                return kotlinScopes_delegate$lambda$0;
            }
        });
    }

    public final LazyJavaPackageScope getJavaScope$descriptors_jvm() {
        return this.javaScope;
    }

    private final MemberScope[] getKotlinScopes() {
        return (MemberScope[]) StorageKt.getValue(this.kotlinScopes$delegate, this, $$delegatedProperties[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MemberScope[] kotlinScopes_delegate$lambda$0(JvmPackageScope this$0) {
        Iterable $this$mapNotNull$iv = this$0.packageFragment.getBinaryClasses$descriptors_jvm().values();
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
            KotlinJvmBinaryClass partClass = (KotlinJvmBinaryClass) element$iv$iv$iv;
            MemberScope createKotlinPackagePartScope = this$0.c.getComponents().getDeserializedDescriptorResolver().createKotlinPackagePartScope(this$0.packageFragment, partClass);
            if (createKotlinPackagePartScope != null) {
                destination$iv$iv.add(createKotlinPackagePartScope);
            }
        }
        Collection $this$toTypedArray$iv = ScopeUtilsKt.listOfNonEmptyScopes((List) destination$iv$iv);
        return (MemberScope[]) $this$toTypedArray$iv.toArray(new MemberScope[0]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    /* renamed from: getContributedClassifier */
    public ClassifierDescriptor mo1173getContributedClassifier(Name name, LookupLocation location2) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(location2, "location");
        mo1177recordLookup(name, location2);
        ClassDescriptor javaClassifier = this.javaScope.mo1173getContributedClassifier(name, location2);
        if (javaClassifier != null) {
            return javaClassifier;
        }
        ClassifierDescriptor result$iv = null;
        for (MemberScope memberScope : getKotlinScopes()) {
            ClassifierDescriptor newResult$iv = memberScope.mo1173getContributedClassifier(name, location2);
            if (newResult$iv != null) {
                if ((newResult$iv instanceof ClassifierDescriptorWithTypeParameters) && ((MemberDescriptor) newResult$iv).isExpect()) {
                    if (result$iv == null) {
                        result$iv = newResult$iv;
                    }
                } else {
                    return newResult$iv;
                }
            }
        }
        return result$iv;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Collection<PropertyDescriptor> getContributedVariables(Name name, LookupLocation location2) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(location2, "location");
        mo1177recordLookup(name, location2);
        MemberScope firstScope$iv = this.javaScope;
        MemberScope[] kotlinScopes = getKotlinScopes();
        MemberScope it = firstScope$iv;
        Collection<? extends PropertyDescriptor> contributedVariables = it.getContributedVariables(name, location2);
        int length = kotlinScopes.length;
        int i = 0;
        Collection result$iv = contributedVariables;
        while (i < length) {
            i++;
            result$iv = ScopeUtilsKt.concat(result$iv, kotlinScopes[i].getContributedVariables(name, location2));
        }
        return result$iv == null ? SetsKt.emptySet() : result$iv;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public Collection<SimpleFunctionDescriptor> getContributedFunctions(Name name, LookupLocation location2) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(location2, "location");
        mo1177recordLookup(name, location2);
        MemberScope firstScope$iv = this.javaScope;
        MemberScope[] kotlinScopes = getKotlinScopes();
        MemberScope it = firstScope$iv;
        Collection<? extends SimpleFunctionDescriptor> contributedFunctions = it.getContributedFunctions(name, location2);
        int length = kotlinScopes.length;
        int i = 0;
        Collection result$iv = contributedFunctions;
        while (i < length) {
            i++;
            result$iv = ScopeUtilsKt.concat(result$iv, kotlinScopes[i].getContributedFunctions(name, location2));
        }
        return result$iv == null ? SetsKt.emptySet() : result$iv;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public Collection<DeclarationDescriptor> getContributedDescriptors(DescriptorKindFilter kindFilter, Function1<? super Name, Boolean> nameFilter) {
        Intrinsics.checkNotNullParameter(kindFilter, "kindFilter");
        Intrinsics.checkNotNullParameter(nameFilter, "nameFilter");
        MemberScope firstScope$iv = this.javaScope;
        MemberScope[] kotlinScopes = getKotlinScopes();
        MemberScope it = firstScope$iv;
        Collection result$iv = it.getContributedDescriptors(kindFilter, nameFilter);
        for (MemberScope memberScope : kotlinScopes) {
            result$iv = ScopeUtilsKt.concat(result$iv, memberScope.getContributedDescriptors(kindFilter, nameFilter));
        }
        if (result$iv == null) {
            Collection result$iv2 = SetsKt.emptySet();
            return result$iv2;
        }
        return result$iv;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set<Name> getFunctionNames() {
        MemberScope[] kotlinScopes = getKotlinScopes();
        Collection destination$iv = (Set) new LinkedHashSet();
        for (MemberScope memberScope : kotlinScopes) {
            Iterable list$iv = memberScope.getFunctionNames();
            CollectionsKt.addAll(destination$iv, list$iv);
        }
        Set $this$getFunctionNames_u24lambda_u241 = (Set) destination$iv;
        $this$getFunctionNames_u24lambda_u241.addAll(this.javaScope.getFunctionNames());
        return (Set) destination$iv;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set<Name> getVariableNames() {
        MemberScope[] kotlinScopes = getKotlinScopes();
        Collection destination$iv = (Set) new LinkedHashSet();
        for (MemberScope memberScope : kotlinScopes) {
            Iterable list$iv = memberScope.getVariableNames();
            CollectionsKt.addAll(destination$iv, list$iv);
        }
        Set $this$getVariableNames_u24lambda_u241 = (Set) destination$iv;
        $this$getVariableNames_u24lambda_u241.addAll(this.javaScope.getVariableNames());
        return (Set) destination$iv;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set<Name> getClassifierNames() {
        Set $this$getClassifierNames_u24lambda_u240 = MemberScopeKt.flatMapClassifierNamesOrNull(ArraysKt.asIterable(getKotlinScopes()));
        if ($this$getClassifierNames_u24lambda_u240 != null) {
            $this$getClassifierNames_u24lambda_u240.addAll(this.javaScope.getClassifierNames());
            return $this$getClassifierNames_u24lambda_u240;
        }
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    /* renamed from: recordLookup */
    public void mo1177recordLookup(Name name, LookupLocation location2) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(location2, "location");
        UtilsKt.record(this.c.getComponents().getLookupTracker(), location2, this.packageFragment, name);
    }

    public String toString() {
        return "scope for " + this.packageFragment;
    }
}