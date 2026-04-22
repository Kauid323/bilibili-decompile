package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.TypeIntersectionScope;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.model.IntersectionTypeConstructorMarker;

/* compiled from: IntersectionTypeConstructor.kt */
public final class IntersectionTypeConstructor implements TypeConstructor, IntersectionTypeConstructorMarker {
    private KotlinType alternative;
    private final int hashCode;
    private final LinkedHashSet<KotlinType> intersectedTypes;

    public IntersectionTypeConstructor(Collection<? extends KotlinType> typesToIntersect) {
        Intrinsics.checkNotNullParameter(typesToIntersect, "typesToIntersect");
        if (typesToIntersect.isEmpty()) {
            throw new AssertionError("Attempt to create an empty intersection");
        }
        this.intersectedTypes = new LinkedHashSet<>(typesToIntersect);
        this.hashCode = this.intersectedTypes.hashCode();
    }

    private IntersectionTypeConstructor(Collection<? extends KotlinType> collection, KotlinType alternative) {
        this(collection);
        this.alternative = alternative;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public List<TypeParameterDescriptor> getParameters() {
        return CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    /* renamed from: getSupertypes */
    public Collection<KotlinType> mo1172getSupertypes() {
        return this.intersectedTypes;
    }

    public final MemberScope createScopeForKotlinType() {
        return TypeIntersectionScope.Companion.create("member scope for intersection type", this.intersectedTypes);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public boolean isDenotable() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    /* renamed from: getDeclarationDescriptor */
    public ClassifierDescriptor mo1171getDeclarationDescriptor() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public KotlinBuiltIns getBuiltIns() {
        KotlinBuiltIns builtIns = this.intersectedTypes.iterator().next().getConstructor().getBuiltIns();
        Intrinsics.checkNotNullExpressionValue(builtIns, "getBuiltIns(...)");
        return builtIns;
    }

    public String toString() {
        return makeDebugNameForIntersectionType$default(this, null, 1, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ String makeDebugNameForIntersectionType$default(IntersectionTypeConstructor intersectionTypeConstructor, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = new Function1() { // from class: kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor$$Lambda$1
                @Override // kotlin.jvm.functions.Function1
                public Object invoke(Object obj2) {
                    String makeDebugNameForIntersectionType$lambda$0;
                    makeDebugNameForIntersectionType$lambda$0 = IntersectionTypeConstructor.makeDebugNameForIntersectionType$lambda$0((KotlinType) obj2);
                    return makeDebugNameForIntersectionType$lambda$0;
                }
            };
        }
        return intersectionTypeConstructor.makeDebugNameForIntersectionType(function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String makeDebugNameForIntersectionType$lambda$0(KotlinType it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.toString();
    }

    public final String makeDebugNameForIntersectionType(final Function1<? super KotlinType, ? extends Object> getProperTypeRelatedToStringify) {
        Intrinsics.checkNotNullParameter(getProperTypeRelatedToStringify, "getProperTypeRelatedToStringify");
        Iterable $this$sortedBy$iv = this.intersectedTypes;
        return CollectionsKt.joinToString$default(CollectionsKt.sortedWith($this$sortedBy$iv, new Comparator() { // from class: kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor$makeDebugNameForIntersectionType$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                KotlinType it = (KotlinType) t;
                Function1 function1 = Function1.this;
                Intrinsics.checkNotNull(it);
                KotlinType it2 = (KotlinType) t2;
                Function1 function12 = Function1.this;
                Intrinsics.checkNotNull(it2);
                return ComparisonsKt.compareValues(function1.invoke(it).toString(), function12.invoke(it2).toString());
            }
        }), " & ", "{", "}", 0, null, new Function1(getProperTypeRelatedToStringify) { // from class: kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor$$Lambda$0
            private final Function1 arg$0;

            {
                this.arg$0 = getProperTypeRelatedToStringify;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                CharSequence makeDebugNameForIntersectionType$lambda$2;
                makeDebugNameForIntersectionType$lambda$2 = IntersectionTypeConstructor.makeDebugNameForIntersectionType$lambda$2(this.arg$0, (KotlinType) obj);
                return makeDebugNameForIntersectionType$lambda$2;
            }
        }, 24, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence makeDebugNameForIntersectionType$lambda$2(Function1 $getProperTypeRelatedToStringify, KotlinType it) {
        Intrinsics.checkNotNull(it);
        return $getProperTypeRelatedToStringify.invoke(it).toString();
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof IntersectionTypeConstructor) {
            return Intrinsics.areEqual(this.intersectedTypes, ((IntersectionTypeConstructor) other).intersectedTypes);
        }
        return false;
    }

    public final SimpleType createType() {
        return KotlinTypeFactory.simpleTypeWithNonTrivialMemberScope(TypeAttributes.Companion.getEmpty(), this, CollectionsKt.emptyList(), false, createScopeForKotlinType(), new Function1(this) { // from class: kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor$$Lambda$2
            private final IntersectionTypeConstructor arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                SimpleType createType$lambda$0;
                createType$lambda$0 = IntersectionTypeConstructor.createType$lambda$0(this.arg$0, (KotlinTypeRefiner) obj);
                return createType$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SimpleType createType$lambda$0(IntersectionTypeConstructor this$0, KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this$0.refine(kotlinTypeRefiner).createType();
    }

    public int hashCode() {
        return this.hashCode;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public IntersectionTypeConstructor refine(KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        boolean changed$iv = false;
        Iterable $this$map$iv$iv = mo1172getSupertypes();
        Collection destination$iv$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv$iv, 10));
        for (Object item$iv$iv$iv : $this$map$iv$iv) {
            KotlinType it$iv = (KotlinType) item$iv$iv$iv;
            changed$iv = true;
            KotlinType it = it$iv.refine(kotlinTypeRefiner);
            destination$iv$iv$iv.add(it);
        }
        List newSupertypes$iv = (List) destination$iv$iv$iv;
        IntersectionTypeConstructor intersectionTypeConstructor = null;
        KotlinType updatedAlternative$iv = null;
        if (changed$iv) {
            KotlinType alternative$iv = getAlternativeType();
            if (alternative$iv != null) {
                KotlinType it2 = alternative$iv.refine(kotlinTypeRefiner);
                updatedAlternative$iv = it2;
            }
            intersectionTypeConstructor = new IntersectionTypeConstructor(newSupertypes$iv).setAlternative(updatedAlternative$iv);
        }
        return intersectionTypeConstructor == null ? this : intersectionTypeConstructor;
    }

    public final IntersectionTypeConstructor setAlternative(KotlinType alternative) {
        return new IntersectionTypeConstructor(this.intersectedTypes, alternative);
    }

    public final KotlinType getAlternativeType() {
        return this.alternative;
    }
}