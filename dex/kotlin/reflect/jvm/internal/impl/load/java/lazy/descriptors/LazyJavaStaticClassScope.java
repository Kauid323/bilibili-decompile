package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.components.DescriptorResolverUtils;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.UtilKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMember;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.utils.DFS;
import kotlin.sequences.SequencesKt;

/* compiled from: LazyJavaStaticClassScope.kt */
public final class LazyJavaStaticClassScope extends LazyJavaStaticScope {
    private final JavaClass jClass;
    private final JavaClassDescriptor ownerDescriptor;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyJavaStaticClassScope(LazyJavaResolverContext c, JavaClass jClass, JavaClassDescriptor ownerDescriptor) {
        super(c);
        Intrinsics.checkNotNullParameter(c, "c");
        Intrinsics.checkNotNullParameter(jClass, "jClass");
        Intrinsics.checkNotNullParameter(ownerDescriptor, "ownerDescriptor");
        this.jClass = jClass;
        this.ownerDescriptor = ownerDescriptor;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public JavaClassDescriptor getOwnerDescriptor() {
        return this.ownerDescriptor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean computeMemberIndex$lambda$0(JavaMember it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.isStatic();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public ClassDeclaredMemberIndex computeMemberIndex() {
        return new ClassDeclaredMemberIndex(this.jClass, new Function1() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaStaticClassScope$$Lambda$0
            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                boolean computeMemberIndex$lambda$0;
                computeMemberIndex$lambda$0 = LazyJavaStaticClassScope.computeMemberIndex$lambda$0((JavaMember) obj);
                return Boolean.valueOf(computeMemberIndex$lambda$0);
            }
        });
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    protected Set<Name> computeFunctionNames(DescriptorKindFilter kindFilter, Function1<? super Name, Boolean> function1) {
        Intrinsics.checkNotNullParameter(kindFilter, "kindFilter");
        Set $this$computeFunctionNames_u24lambda_u240 = CollectionsKt.toMutableSet(getDeclaredMemberIndex().invoke().getMethodNames());
        LazyJavaStaticClassScope parentJavaStaticClassScope = UtilKt.getParentJavaStaticClassScope(getOwnerDescriptor());
        Set<Name> functionNames = parentJavaStaticClassScope != null ? parentJavaStaticClassScope.getFunctionNames() : null;
        if (functionNames == null) {
            functionNames = SetsKt.emptySet();
        }
        $this$computeFunctionNames_u24lambda_u240.addAll(functionNames);
        if (this.jClass.isEnum()) {
            $this$computeFunctionNames_u24lambda_u240.addAll(CollectionsKt.listOf((Object[]) new Name[]{StandardNames.ENUM_VALUE_OF, StandardNames.ENUM_VALUES}));
        }
        $this$computeFunctionNames_u24lambda_u240.addAll(getC().getComponents().getSyntheticPartsProvider().getStaticFunctionNames(getOwnerDescriptor(), getC()));
        return $this$computeFunctionNames_u24lambda_u240;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    protected Set<Name> computePropertyNames(DescriptorKindFilter kindFilter, Function1<? super Name, Boolean> function1) {
        Intrinsics.checkNotNullParameter(kindFilter, "kindFilter");
        Set $this$computePropertyNames_u24lambda_u240 = CollectionsKt.toMutableSet(getDeclaredMemberIndex().invoke().getFieldNames());
        flatMapJavaStaticSupertypesScopes(getOwnerDescriptor(), $this$computePropertyNames_u24lambda_u240, new Function1() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaStaticClassScope$$Lambda$1
            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                Collection computePropertyNames$lambda$0$0;
                computePropertyNames$lambda$0$0 = LazyJavaStaticClassScope.computePropertyNames$lambda$0$0((MemberScope) obj);
                return computePropertyNames$lambda$0$0;
            }
        });
        if (this.jClass.isEnum()) {
            $this$computePropertyNames_u24lambda_u240.add(StandardNames.ENUM_ENTRIES);
        }
        return $this$computePropertyNames_u24lambda_u240;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Collection computePropertyNames$lambda$0$0(MemberScope it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getVariableNames();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    protected Set<Name> computeClassNames(DescriptorKindFilter kindFilter, Function1<? super Name, Boolean> function1) {
        Intrinsics.checkNotNullParameter(kindFilter, "kindFilter");
        return SetsKt.emptySet();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    /* renamed from: getContributedClassifier */
    public ClassifierDescriptor mo1173getContributedClassifier(Name name, LookupLocation location2) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(location2, "location");
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    protected void computeNonDeclaredFunctions(Collection<SimpleFunctionDescriptor> result, Name name) {
        Intrinsics.checkNotNullParameter(result, "result");
        Intrinsics.checkNotNullParameter(name, "name");
        Set functionsFromSupertypes = getStaticFunctionsFromJavaSuperClasses(name, getOwnerDescriptor());
        Collection<? extends SimpleFunctionDescriptor> resolveOverridesForStaticMembers = DescriptorResolverUtils.resolveOverridesForStaticMembers(name, functionsFromSupertypes, result, getOwnerDescriptor(), getC().getComponents().getErrorReporter(), getC().getComponents().getKotlinTypeChecker().getOverridingUtil());
        Intrinsics.checkNotNullExpressionValue(resolveOverridesForStaticMembers, "resolveOverridesForStaticMembers(...)");
        result.addAll(resolveOverridesForStaticMembers);
        if (this.jClass.isEnum()) {
            if (!Intrinsics.areEqual(name, StandardNames.ENUM_VALUE_OF)) {
                if (Intrinsics.areEqual(name, StandardNames.ENUM_VALUES)) {
                    SimpleFunctionDescriptor createEnumValuesMethod = DescriptorFactory.createEnumValuesMethod(getOwnerDescriptor());
                    Intrinsics.checkNotNullExpressionValue(createEnumValuesMethod, "createEnumValuesMethod(...)");
                    result.add(createEnumValuesMethod);
                    return;
                }
                return;
            }
            SimpleFunctionDescriptor createEnumValueOfMethod = DescriptorFactory.createEnumValueOfMethod(getOwnerDescriptor());
            Intrinsics.checkNotNullExpressionValue(createEnumValueOfMethod, "createEnumValueOfMethod(...)");
            result.add(createEnumValueOfMethod);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    protected void computeImplicitlyDeclaredFunctions(Collection<SimpleFunctionDescriptor> result, Name name) {
        Intrinsics.checkNotNullParameter(result, "result");
        Intrinsics.checkNotNullParameter(name, "name");
        getC().getComponents().getSyntheticPartsProvider().generateStaticFunctions(getOwnerDescriptor(), name, result, getC());
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaStaticScope, kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    protected void computeNonDeclaredProperties(final Name name, Collection<PropertyDescriptor> result) {
        Iterable $this$groupBy$iv;
        ArrayList arrayList;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(result, "result");
        Iterable propertiesFromSupertypes = flatMapJavaStaticSupertypesScopes(getOwnerDescriptor(), new LinkedHashSet(), new Function1(name) { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaStaticClassScope$$Lambda$2
            private final Name arg$0;

            {
                this.arg$0 = name;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                Collection computeNonDeclaredProperties$lambda$0;
                computeNonDeclaredProperties$lambda$0 = LazyJavaStaticClassScope.computeNonDeclaredProperties$lambda$0(this.arg$0, (MemberScope) obj);
                return computeNonDeclaredProperties$lambda$0;
            }
        });
        if (!result.isEmpty()) {
            Collection<? extends PropertyDescriptor> resolveOverridesForStaticMembers = DescriptorResolverUtils.resolveOverridesForStaticMembers(name, (Collection) propertiesFromSupertypes, result, getOwnerDescriptor(), getC().getComponents().getErrorReporter(), getC().getComponents().getKotlinTypeChecker().getOverridingUtil());
            Intrinsics.checkNotNullExpressionValue(resolveOverridesForStaticMembers, "resolveOverridesForStaticMembers(...)");
            result.addAll(resolveOverridesForStaticMembers);
        } else {
            Iterable $this$groupBy$iv2 = propertiesFromSupertypes;
            Map destination$iv$iv = new LinkedHashMap();
            for (Object element$iv$iv : $this$groupBy$iv2) {
                PropertyDescriptor it = getRealOriginal((PropertyDescriptor) element$iv$iv);
                Object value$iv$iv$iv = destination$iv$iv.get(it);
                if (value$iv$iv$iv == null) {
                    arrayList = new ArrayList();
                    $this$groupBy$iv = $this$groupBy$iv2;
                    destination$iv$iv.put(it, arrayList);
                } else {
                    $this$groupBy$iv = $this$groupBy$iv2;
                    arrayList = value$iv$iv$iv;
                }
                List list$iv$iv = (List) arrayList;
                list$iv$iv.add(element$iv$iv);
                $this$groupBy$iv2 = $this$groupBy$iv;
            }
            Collection destination$iv$iv2 = new ArrayList();
            for (Map.Entry element$iv$iv2 : destination$iv$iv.entrySet()) {
                Iterable resolveOverridesForStaticMembers2 = DescriptorResolverUtils.resolveOverridesForStaticMembers(name, (Collection) element$iv$iv2.getValue(), result, getOwnerDescriptor(), getC().getComponents().getErrorReporter(), getC().getComponents().getKotlinTypeChecker().getOverridingUtil());
                Intrinsics.checkNotNullExpressionValue(resolveOverridesForStaticMembers2, "resolveOverridesForStaticMembers(...)");
                Iterable list$iv$iv2 = resolveOverridesForStaticMembers2;
                CollectionsKt.addAll(destination$iv$iv2, list$iv$iv2);
            }
            result.addAll((List) destination$iv$iv2);
        }
        if (this.jClass.isEnum() && Intrinsics.areEqual(name, StandardNames.ENUM_ENTRIES)) {
            kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.addIfNotNull(result, DescriptorFactory.createEnumEntriesProperty(getOwnerDescriptor()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Collection computeNonDeclaredProperties$lambda$0(Name $name, MemberScope it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getContributedVariables($name, NoLookupLocation.WHEN_GET_SUPER_MEMBERS);
    }

    private final Set<SimpleFunctionDescriptor> getStaticFunctionsFromJavaSuperClasses(Name name, ClassDescriptor descriptor) {
        LazyJavaStaticClassScope staticScope = UtilKt.getParentJavaStaticClassScope(descriptor);
        return staticScope == null ? SetsKt.emptySet() : CollectionsKt.toSet(staticScope.getContributedFunctions(name, NoLookupLocation.WHEN_GET_SUPER_MEMBERS));
    }

    private final <R> Set<R> flatMapJavaStaticSupertypesScopes(final ClassDescriptor root, final Set<R> set, final Function1<? super MemberScope, ? extends Collection<? extends R>> function1) {
        DFS.dfs(CollectionsKt.listOf(root), new DFS.Neighbors() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaStaticClassScope$$Lambda$3
            @Override // kotlin.reflect.jvm.internal.impl.utils.DFS.Neighbors
            public Iterable getNeighbors(Object obj) {
                Iterable flatMapJavaStaticSupertypesScopes$lambda$0;
                flatMapJavaStaticSupertypesScopes$lambda$0 = LazyJavaStaticClassScope.flatMapJavaStaticSupertypesScopes$lambda$0((ClassDescriptor) obj);
                return flatMapJavaStaticSupertypesScopes$lambda$0;
            }
        }, new DFS.AbstractNodeHandler<ClassDescriptor, Unit>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaStaticClassScope$flatMapJavaStaticSupertypesScopes$2
            @Override // kotlin.reflect.jvm.internal.impl.utils.DFS.NodeHandler
            public /* bridge */ /* synthetic */ Object result() {
                m1168result();
                return Unit.INSTANCE;
            }

            @Override // kotlin.reflect.jvm.internal.impl.utils.DFS.AbstractNodeHandler, kotlin.reflect.jvm.internal.impl.utils.DFS.NodeHandler
            public boolean beforeChildren(ClassDescriptor current) {
                Intrinsics.checkNotNullParameter(current, "current");
                if (current == ClassDescriptor.this) {
                    return true;
                }
                MemberScope staticScope = current.getStaticScope();
                Intrinsics.checkNotNullExpressionValue(staticScope, "getStaticScope(...)");
                if (staticScope instanceof LazyJavaStaticScope) {
                    set.addAll((Collection) function1.invoke(staticScope));
                    return false;
                }
                return true;
            }

            /* renamed from: result  reason: collision with other method in class */
            public void m1168result() {
            }
        });
        return set;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Iterable flatMapJavaStaticSupertypesScopes$lambda$0(ClassDescriptor it) {
        Collection<KotlinType> mo1172getSupertypes = it.getTypeConstructor().mo1172getSupertypes();
        Intrinsics.checkNotNullExpressionValue(mo1172getSupertypes, "getSupertypes(...)");
        return SequencesKt.asIterable(SequencesKt.mapNotNull(CollectionsKt.asSequence(mo1172getSupertypes), new Function1() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaStaticClassScope$$Lambda$4
            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                ClassDescriptor flatMapJavaStaticSupertypesScopes$lambda$0$0;
                flatMapJavaStaticSupertypesScopes$lambda$0$0 = LazyJavaStaticClassScope.flatMapJavaStaticSupertypesScopes$lambda$0$0((KotlinType) obj);
                return flatMapJavaStaticSupertypesScopes$lambda$0$0;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ClassDescriptor flatMapJavaStaticSupertypesScopes$lambda$0$0(KotlinType supertype) {
        ClassifierDescriptor mo1171getDeclarationDescriptor = supertype.getConstructor().mo1171getDeclarationDescriptor();
        if (mo1171getDeclarationDescriptor instanceof ClassDescriptor) {
            return (ClassDescriptor) mo1171getDeclarationDescriptor;
        }
        return null;
    }

    private final PropertyDescriptor getRealOriginal(PropertyDescriptor $this$realOriginal) {
        if ($this$realOriginal.getKind().isReal()) {
            return $this$realOriginal;
        }
        Iterable overriddenDescriptors = $this$realOriginal.getOverriddenDescriptors();
        Intrinsics.checkNotNullExpressionValue(overriddenDescriptors, "getOverriddenDescriptors(...)");
        Iterable $this$map$iv = overriddenDescriptors;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            PropertyDescriptor it = (PropertyDescriptor) item$iv$iv;
            Intrinsics.checkNotNull(it);
            destination$iv$iv.add(getRealOriginal(it));
        }
        return (PropertyDescriptor) CollectionsKt.single((List<? extends Object>) CollectionsKt.distinct((List) destination$iv$iv));
    }
}