package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorNonRoot;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Substitutable;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.utils.CollectionsKt;

/* compiled from: SubstitutingScope.kt */
public final class SubstitutingScope implements MemberScope {
    private final Lazy _allDescriptors$delegate;
    private final TypeSubstitutor capturingSubstitutor;
    private Map<DeclarationDescriptor, DeclarationDescriptor> substitutedDescriptors;
    private final Lazy substitutor$delegate;
    private final MemberScope workerScope;

    public SubstitutingScope(MemberScope workerScope, final TypeSubstitutor givenSubstitutor) {
        Intrinsics.checkNotNullParameter(workerScope, "workerScope");
        Intrinsics.checkNotNullParameter(givenSubstitutor, "givenSubstitutor");
        this.workerScope = workerScope;
        this.substitutor$delegate = LazyKt.lazy(new Function0(givenSubstitutor) { // from class: kotlin.reflect.jvm.internal.impl.resolve.scopes.SubstitutingScope$$Lambda$0
            private final TypeSubstitutor arg$0;

            {
                this.arg$0 = givenSubstitutor;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                TypeSubstitutor substitutor_delegate$lambda$0;
                substitutor_delegate$lambda$0 = SubstitutingScope.substitutor_delegate$lambda$0(this.arg$0);
                return substitutor_delegate$lambda$0;
            }
        });
        TypeSubstitution substitution = givenSubstitutor.getSubstitution();
        Intrinsics.checkNotNullExpressionValue(substitution, "getSubstitution(...)");
        this.capturingSubstitutor = CapturedTypeConstructorKt.wrapWithCapturingSubstitution$default(substitution, false, 1, null).buildSubstitutor();
        this._allDescriptors$delegate = LazyKt.lazy(new Function0(this) { // from class: kotlin.reflect.jvm.internal.impl.resolve.scopes.SubstitutingScope$$Lambda$1
            private final SubstitutingScope arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                Collection _allDescriptors_delegate$lambda$0;
                _allDescriptors_delegate$lambda$0 = SubstitutingScope._allDescriptors_delegate$lambda$0(this.arg$0);
                return _allDescriptors_delegate$lambda$0;
            }
        });
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    /* renamed from: recordLookup */
    public /* bridge */ void mo1177recordLookup(Name name, LookupLocation location2) {
        MemberScope.DefaultImpls.recordLookup(this, name, location2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TypeSubstitutor substitutor_delegate$lambda$0(TypeSubstitutor $givenSubstitutor) {
        return $givenSubstitutor.getSubstitution().buildSubstitutor();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Collection _allDescriptors_delegate$lambda$0(SubstitutingScope this$0) {
        return this$0.substitute(ResolutionScope.DefaultImpls.getContributedDescriptors$default(this$0.workerScope, null, null, 3, null));
    }

    private final Collection<DeclarationDescriptor> get_allDescriptors() {
        return (Collection) this._allDescriptors$delegate.getValue();
    }

    private final <D extends DeclarationDescriptor> D substitute(D d) {
        DeclarationDescriptorNonRoot declarationDescriptorNonRoot;
        if (this.capturingSubstitutor.isEmpty()) {
            return d;
        }
        if (this.substitutedDescriptors == null) {
            this.substitutedDescriptors = new HashMap();
        }
        Map $this$getOrPut$iv = this.substitutedDescriptors;
        Intrinsics.checkNotNull($this$getOrPut$iv);
        DeclarationDescriptor declarationDescriptor = $this$getOrPut$iv.get(d);
        if (declarationDescriptor == null) {
            if (!(d instanceof Substitutable)) {
                throw new IllegalStateException(("Unknown descriptor in scope: " + d).toString());
            }
            Object $this$sure$iv = ((Substitutable) d).substitute(this.capturingSubstitutor);
            if ($this$sure$iv != null) {
                declarationDescriptorNonRoot = (DeclarationDescriptor) $this$sure$iv;
                $this$getOrPut$iv.put(d, declarationDescriptorNonRoot);
            } else {
                throw new AssertionError("We expect that no conflict should happen while substitution is guaranteed to generate invariant projection, but " + d + " substitution fails");
            }
        } else {
            declarationDescriptorNonRoot = declarationDescriptor;
        }
        D d2 = (D) declarationDescriptorNonRoot;
        Intrinsics.checkNotNull(d2, "null cannot be cast to non-null type D of org.jetbrains.kotlin.resolve.scopes.SubstitutingScope.substitute");
        return d2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final <D extends DeclarationDescriptor> Collection<D> substitute(Collection<? extends D> collection) {
        if (this.capturingSubstitutor.isEmpty() || collection.isEmpty()) {
            return collection;
        }
        LinkedHashSet result = CollectionsKt.newLinkedHashSetWithExpectedSize(collection.size());
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            DeclarationDescriptor descriptor = (DeclarationDescriptor) it.next();
            DeclarationDescriptor substitute = substitute((SubstitutingScope) descriptor);
            result.add(substitute);
        }
        return result;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Collection<? extends PropertyDescriptor> getContributedVariables(Name name, LookupLocation location2) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(location2, "location");
        return substitute(this.workerScope.getContributedVariables(name, location2));
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    /* renamed from: getContributedClassifier */
    public ClassifierDescriptor mo1173getContributedClassifier(Name name, LookupLocation location2) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(location2, "location");
        ClassifierDescriptor it = this.workerScope.mo1173getContributedClassifier(name, location2);
        if (it != null) {
            return (ClassifierDescriptor) substitute((SubstitutingScope) it);
        }
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public Collection<? extends SimpleFunctionDescriptor> getContributedFunctions(Name name, LookupLocation location2) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(location2, "location");
        return substitute(this.workerScope.getContributedFunctions(name, location2));
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public Collection<DeclarationDescriptor> getContributedDescriptors(DescriptorKindFilter kindFilter, Function1<? super Name, Boolean> nameFilter) {
        Intrinsics.checkNotNullParameter(kindFilter, "kindFilter");
        Intrinsics.checkNotNullParameter(nameFilter, "nameFilter");
        return get_allDescriptors();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set<Name> getFunctionNames() {
        return this.workerScope.getFunctionNames();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set<Name> getVariableNames() {
        return this.workerScope.getVariableNames();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set<Name> getClassifierNames() {
        return this.workerScope.getClassifierNames();
    }
}