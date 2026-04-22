package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.util.collectionUtils.ScopeUtilsKt;
import kotlin.reflect.jvm.internal.impl.utils.SmartList;

/* compiled from: ChainedMemberScope.kt */
public final class ChainedMemberScope implements MemberScope {
    public static final Companion Companion = new Companion(null);
    private final String debugName;
    private final MemberScope[] scopes;

    public /* synthetic */ ChainedMemberScope(String str, MemberScope[] memberScopeArr, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, memberScopeArr);
    }

    private ChainedMemberScope(String debugName, MemberScope[] scopes) {
        this.debugName = debugName;
        this.scopes = scopes;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    /* renamed from: getContributedClassifier */
    public ClassifierDescriptor mo1173getContributedClassifier(Name name, LookupLocation location2) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(location2, "location");
        Object[] scopes$iv = this.scopes;
        ClassifierDescriptor result$iv = null;
        for (Object scope$iv : scopes$iv) {
            ClassifierDescriptor newResult$iv = ((ResolutionScope) scope$iv).mo1173getContributedClassifier(name, location2);
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
        MemberScope[] memberScopeArr = this.scopes;
        switch (memberScopeArr.length) {
            case 0:
                return CollectionsKt.emptyList();
            case 1:
                MemberScope it = memberScopeArr[0];
                return it.getContributedVariables(name, location2);
            default:
                Collection result$iv = null;
                for (MemberScope memberScope : memberScopeArr) {
                    result$iv = ScopeUtilsKt.concat(result$iv, memberScope.getContributedVariables(name, location2));
                }
                return result$iv == null ? SetsKt.emptySet() : result$iv;
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public Collection<SimpleFunctionDescriptor> getContributedFunctions(Name name, LookupLocation location2) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(location2, "location");
        MemberScope[] memberScopeArr = this.scopes;
        switch (memberScopeArr.length) {
            case 0:
                return CollectionsKt.emptyList();
            case 1:
                MemberScope it = memberScopeArr[0];
                return it.getContributedFunctions(name, location2);
            default:
                Collection result$iv = null;
                for (MemberScope memberScope : memberScopeArr) {
                    result$iv = ScopeUtilsKt.concat(result$iv, memberScope.getContributedFunctions(name, location2));
                }
                return result$iv == null ? SetsKt.emptySet() : result$iv;
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public Collection<DeclarationDescriptor> getContributedDescriptors(DescriptorKindFilter kindFilter, Function1<? super Name, Boolean> nameFilter) {
        Intrinsics.checkNotNullParameter(kindFilter, "kindFilter");
        Intrinsics.checkNotNullParameter(nameFilter, "nameFilter");
        Object[] scopes$iv = this.scopes;
        switch (scopes$iv.length) {
            case 0:
                return CollectionsKt.emptyList();
            case 1:
                Object it = scopes$iv[0];
                return ((ResolutionScope) it).getContributedDescriptors(kindFilter, nameFilter);
            default:
                Collection result$iv = null;
                for (Object scope$iv : scopes$iv) {
                    result$iv = ScopeUtilsKt.concat(result$iv, ((ResolutionScope) scope$iv).getContributedDescriptors(kindFilter, nameFilter));
                }
                return result$iv == null ? SetsKt.emptySet() : result$iv;
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set<Name> getFunctionNames() {
        MemberScope[] memberScopeArr = this.scopes;
        Collection destination$iv = (Set) new LinkedHashSet();
        for (MemberScope memberScope : memberScopeArr) {
            Iterable list$iv = memberScope.getFunctionNames();
            CollectionsKt.addAll(destination$iv, list$iv);
        }
        return (Set) destination$iv;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set<Name> getVariableNames() {
        MemberScope[] memberScopeArr = this.scopes;
        Collection destination$iv = (Set) new LinkedHashSet();
        for (MemberScope memberScope : memberScopeArr) {
            Iterable list$iv = memberScope.getVariableNames();
            CollectionsKt.addAll(destination$iv, list$iv);
        }
        return (Set) destination$iv;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set<Name> getClassifierNames() {
        return MemberScopeKt.flatMapClassifierNamesOrNull(ArraysKt.asIterable(this.scopes));
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    /* renamed from: recordLookup */
    public void mo1177recordLookup(Name name, LookupLocation location2) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(location2, "location");
        for (MemberScope memberScope : this.scopes) {
            memberScope.mo1177recordLookup(name, location2);
        }
    }

    public String toString() {
        return this.debugName;
    }

    /* compiled from: ChainedMemberScope.kt */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final MemberScope create(String debugName, Iterable<? extends MemberScope> scopes) {
            Intrinsics.checkNotNullParameter(debugName, "debugName");
            Intrinsics.checkNotNullParameter(scopes, "scopes");
            SmartList flattenedNonEmptyScopes = new SmartList();
            for (MemberScope scope : scopes) {
                if (scope != MemberScope.Empty.INSTANCE) {
                    if (scope instanceof ChainedMemberScope) {
                        CollectionsKt.addAll(flattenedNonEmptyScopes, ((ChainedMemberScope) scope).scopes);
                    } else {
                        flattenedNonEmptyScopes.add(scope);
                    }
                }
            }
            return createOrSingle$descriptors(debugName, flattenedNonEmptyScopes);
        }

        public final MemberScope createOrSingle$descriptors(String debugName, List<? extends MemberScope> scopes) {
            Intrinsics.checkNotNullParameter(debugName, "debugName");
            Intrinsics.checkNotNullParameter(scopes, "scopes");
            switch (scopes.size()) {
                case 0:
                    return MemberScope.Empty.INSTANCE;
                case 1:
                    return scopes.get(0);
                default:
                    List<? extends MemberScope> $this$toTypedArray$iv = scopes;
                    return new ChainedMemberScope(debugName, (MemberScope[]) $this$toTypedArray$iv.toArray(new MemberScope[0]), null);
            }
        }
    }
}