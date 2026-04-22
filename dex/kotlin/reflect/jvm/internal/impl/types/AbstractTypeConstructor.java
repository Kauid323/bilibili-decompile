package kotlin.reflect.jvm.internal.impl.types;

import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefinerKt;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;

/* compiled from: AbstractTypeConstructor.kt */
public abstract class AbstractTypeConstructor extends ClassifierBasedTypeConstructor {
    private final boolean shouldReportCyclicScopeWithCompanionWarning;
    private final NotNullLazyValue<Supertypes> supertypes;

    protected abstract Collection<KotlinType> computeSupertypes();

    protected abstract SupertypeLoopChecker getSupertypeLoopChecker();

    public AbstractTypeConstructor(StorageManager storageManager) {
        Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        this.supertypes = storageManager.createLazyValueWithPostCompute(new Function0(this) { // from class: kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor$$Lambda$0
            private final AbstractTypeConstructor arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                AbstractTypeConstructor.Supertypes supertypes$lambda$0;
                supertypes$lambda$0 = AbstractTypeConstructor.supertypes$lambda$0(this.arg$0);
                return supertypes$lambda$0;
            }
        }, new Function1() { // from class: kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor$$Lambda$1
            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                AbstractTypeConstructor.Supertypes supertypes$lambda$1;
                supertypes$lambda$1 = AbstractTypeConstructor.supertypes$lambda$1(((Boolean) obj).booleanValue());
                return supertypes$lambda$1;
            }
        }, new Function1(this) { // from class: kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor$$Lambda$2
            private final AbstractTypeConstructor arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                Unit supertypes$lambda$2;
                supertypes$lambda$2 = AbstractTypeConstructor.supertypes$lambda$2(this.arg$0, (AbstractTypeConstructor.Supertypes) obj);
                return supertypes$lambda$2;
            }
        });
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    /* renamed from: getSupertypes */
    public List<KotlinType> mo1172getSupertypes() {
        return this.supertypes.invoke().getSupertypesWithoutCycles();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public TypeConstructor refine(KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        return new ModuleViewTypeConstructor(this, kotlinTypeRefiner);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AbstractTypeConstructor.kt */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public final class ModuleViewTypeConstructor implements TypeConstructor {
        private final KotlinTypeRefiner kotlinTypeRefiner;
        private final Lazy refinedSupertypes$delegate;
        final /* synthetic */ AbstractTypeConstructor this$0;

        public ModuleViewTypeConstructor(AbstractTypeConstructor this$0, KotlinTypeRefiner kotlinTypeRefiner) {
            Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
            this.this$0 = this$0;
            this.kotlinTypeRefiner = kotlinTypeRefiner;
            LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.PUBLICATION;
            final AbstractTypeConstructor abstractTypeConstructor = this.this$0;
            this.refinedSupertypes$delegate = LazyKt.lazy(lazyThreadSafetyMode, new Function0(this, abstractTypeConstructor) { // from class: kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor$ModuleViewTypeConstructor$$Lambda$0
                private final AbstractTypeConstructor.ModuleViewTypeConstructor arg$0;
                private final AbstractTypeConstructor arg$1;

                {
                    this.arg$0 = this;
                    this.arg$1 = abstractTypeConstructor;
                }

                @Override // kotlin.jvm.functions.Function0
                public Object invoke() {
                    List refinedSupertypes_delegate$lambda$0;
                    refinedSupertypes_delegate$lambda$0 = AbstractTypeConstructor.ModuleViewTypeConstructor.refinedSupertypes_delegate$lambda$0(this.arg$0, this.arg$1);
                    return refinedSupertypes_delegate$lambda$0;
                }
            });
        }

        private final List<KotlinType> getRefinedSupertypes() {
            return (List) this.refinedSupertypes$delegate.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final List refinedSupertypes_delegate$lambda$0(ModuleViewTypeConstructor this$0, AbstractTypeConstructor this$1) {
            return KotlinTypeRefinerKt.refineTypes(this$0.kotlinTypeRefiner, this$1.mo1172getSupertypes());
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        public List<TypeParameterDescriptor> getParameters() {
            List<TypeParameterDescriptor> parameters = this.this$0.getParameters();
            Intrinsics.checkNotNullExpressionValue(parameters, "getParameters(...)");
            return parameters;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        /* renamed from: getSupertypes */
        public List<KotlinType> mo1172getSupertypes() {
            return getRefinedSupertypes();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        public boolean isDenotable() {
            return this.this$0.isDenotable();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        /* renamed from: getDeclarationDescriptor */
        public ClassifierDescriptor mo1171getDeclarationDescriptor() {
            return this.this$0.mo1171getDeclarationDescriptor();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        public KotlinBuiltIns getBuiltIns() {
            KotlinBuiltIns builtIns = this.this$0.getBuiltIns();
            Intrinsics.checkNotNullExpressionValue(builtIns, "getBuiltIns(...)");
            return builtIns;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        public TypeConstructor refine(KotlinTypeRefiner kotlinTypeRefiner) {
            Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
            return this.this$0.refine(kotlinTypeRefiner);
        }

        public boolean equals(Object other) {
            return this.this$0.equals(other);
        }

        public int hashCode() {
            return this.this$0.hashCode();
        }

        public String toString() {
            return this.this$0.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AbstractTypeConstructor.kt */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Supertypes {
        private final Collection<KotlinType> allSupertypes;
        private List<? extends KotlinType> supertypesWithoutCycles;

        /* JADX WARN: Multi-variable type inference failed */
        public Supertypes(Collection<? extends KotlinType> allSupertypes) {
            Intrinsics.checkNotNullParameter(allSupertypes, "allSupertypes");
            this.allSupertypes = allSupertypes;
            this.supertypesWithoutCycles = CollectionsKt.listOf(ErrorUtils.INSTANCE.getErrorTypeForLoopInSupertypes());
        }

        public final Collection<KotlinType> getAllSupertypes() {
            return this.allSupertypes;
        }

        public final List<KotlinType> getSupertypesWithoutCycles() {
            return this.supertypesWithoutCycles;
        }

        public final void setSupertypesWithoutCycles(List<? extends KotlinType> list) {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.supertypesWithoutCycles = list;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Supertypes supertypes$lambda$0(AbstractTypeConstructor this$0) {
        return new Supertypes(this$0.computeSupertypes());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Supertypes supertypes$lambda$1(boolean it) {
        return new Supertypes(CollectionsKt.listOf(ErrorUtils.INSTANCE.getErrorTypeForLoopInSupertypes()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit supertypes$lambda$2(final AbstractTypeConstructor this$0, Supertypes supertypes) {
        Intrinsics.checkNotNullParameter(supertypes, "supertypes");
        Collection findLoopsInSupertypesAndDisconnect = this$0.getSupertypeLoopChecker().findLoopsInSupertypesAndDisconnect(this$0, supertypes.getAllSupertypes(), new Function1(this$0) { // from class: kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor$$Lambda$3
            private final AbstractTypeConstructor arg$0;

            {
                this.arg$0 = this$0;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                Iterable supertypes$lambda$2$0;
                supertypes$lambda$2$0 = AbstractTypeConstructor.supertypes$lambda$2$0(this.arg$0, (TypeConstructor) obj);
                return supertypes$lambda$2$0;
            }
        }, new Function1(this$0) { // from class: kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor$$Lambda$4
            private final AbstractTypeConstructor arg$0;

            {
                this.arg$0 = this$0;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                Unit supertypes$lambda$2$1;
                supertypes$lambda$2$1 = AbstractTypeConstructor.supertypes$lambda$2$1(this.arg$0, (KotlinType) obj);
                return supertypes$lambda$2$1;
            }
        });
        if (findLoopsInSupertypesAndDisconnect.isEmpty()) {
            KotlinType it = this$0.defaultSupertypeIfEmpty();
            Collection listOf = it != null ? CollectionsKt.listOf(it) : null;
            if (listOf == null) {
                listOf = CollectionsKt.emptyList();
            }
            Collection resultWithoutCycles = listOf;
            findLoopsInSupertypesAndDisconnect = resultWithoutCycles;
        }
        if (this$0.getShouldReportCyclicScopeWithCompanionWarning()) {
            this$0.getSupertypeLoopChecker().findLoopsInSupertypesAndDisconnect(this$0, findLoopsInSupertypesAndDisconnect, new Function1(this$0) { // from class: kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor$$Lambda$5
                private final AbstractTypeConstructor arg$0;

                {
                    this.arg$0 = this$0;
                }

                @Override // kotlin.jvm.functions.Function1
                public Object invoke(Object obj) {
                    Iterable supertypes$lambda$2$3;
                    supertypes$lambda$2$3 = AbstractTypeConstructor.supertypes$lambda$2$3(this.arg$0, (TypeConstructor) obj);
                    return supertypes$lambda$2$3;
                }
            }, new Function1(this$0) { // from class: kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor$$Lambda$6
                private final AbstractTypeConstructor arg$0;

                {
                    this.arg$0 = this$0;
                }

                @Override // kotlin.jvm.functions.Function1
                public Object invoke(Object obj) {
                    Unit supertypes$lambda$2$4;
                    supertypes$lambda$2$4 = AbstractTypeConstructor.supertypes$lambda$2$4(this.arg$0, (KotlinType) obj);
                    return supertypes$lambda$2$4;
                }
            });
        }
        List<KotlinType> list = findLoopsInSupertypesAndDisconnect instanceof List ? (List) findLoopsInSupertypesAndDisconnect : null;
        if (list == null) {
            list = CollectionsKt.toList(findLoopsInSupertypesAndDisconnect);
        }
        supertypes.setSupertypesWithoutCycles(this$0.processSupertypesWithoutCycles(list));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Iterable supertypes$lambda$2$0(AbstractTypeConstructor this$0, TypeConstructor it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return this$0.computeNeighbours(it, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit supertypes$lambda$2$1(AbstractTypeConstructor this$0, KotlinType it) {
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.reportSupertypeLoopError(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Iterable supertypes$lambda$2$3(AbstractTypeConstructor this$0, TypeConstructor it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return this$0.computeNeighbours(it, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit supertypes$lambda$2$4(AbstractTypeConstructor this$0, KotlinType it) {
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.reportScopesLoopError(it);
        return Unit.INSTANCE;
    }

    private final Collection<KotlinType> computeNeighbours(TypeConstructor $this$computeNeighbours, boolean useCompanions) {
        List plus;
        AbstractTypeConstructor abstractClassifierDescriptor = $this$computeNeighbours instanceof AbstractTypeConstructor ? (AbstractTypeConstructor) $this$computeNeighbours : null;
        if (abstractClassifierDescriptor == null || (plus = CollectionsKt.plus((Collection) abstractClassifierDescriptor.supertypes.invoke().getAllSupertypes(), (Iterable) abstractClassifierDescriptor.getAdditionalNeighboursInSupertypeGraph(useCompanions))) == null) {
            Collection<KotlinType> mo1172getSupertypes = $this$computeNeighbours.mo1172getSupertypes();
            Intrinsics.checkNotNullExpressionValue(mo1172getSupertypes, "getSupertypes(...)");
            return mo1172getSupertypes;
        }
        return plus;
    }

    protected void reportSupertypeLoopError(KotlinType type) {
        Intrinsics.checkNotNullParameter(type, "type");
    }

    protected List<KotlinType> processSupertypesWithoutCycles(List<KotlinType> supertypes) {
        Intrinsics.checkNotNullParameter(supertypes, "supertypes");
        return supertypes;
    }

    protected void reportScopesLoopError(KotlinType type) {
        Intrinsics.checkNotNullParameter(type, "type");
    }

    protected boolean getShouldReportCyclicScopeWithCompanionWarning() {
        return this.shouldReportCyclicScopeWithCompanionWarning;
    }

    protected Collection<KotlinType> getAdditionalNeighboursInSupertypeGraph(boolean useCompanions) {
        return CollectionsKt.emptyList();
    }

    protected KotlinType defaultSupertypeIfEmpty() {
        return null;
    }
}