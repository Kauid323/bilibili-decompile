package kotlin.reflect.jvm.internal.impl.resolve;

import java.util.Collection;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* compiled from: DescriptorEquivalenceForOverrides.kt */
public final class DescriptorEquivalenceForOverrides {
    public static final DescriptorEquivalenceForOverrides INSTANCE = new DescriptorEquivalenceForOverrides();

    public final boolean areTypeParametersEquivalent(TypeParameterDescriptor a, TypeParameterDescriptor b, boolean z) {
        Intrinsics.checkNotNullParameter(a, "a");
        Intrinsics.checkNotNullParameter(b, "b");
        return areTypeParametersEquivalent$default(this, a, b, z, null, 8, null);
    }

    private DescriptorEquivalenceForOverrides() {
    }

    public static /* synthetic */ boolean areEquivalent$default(DescriptorEquivalenceForOverrides descriptorEquivalenceForOverrides, DeclarationDescriptor declarationDescriptor, DeclarationDescriptor declarationDescriptor2, boolean z, boolean z2, int i, Object obj) {
        if ((i & 8) != 0) {
            z2 = true;
        }
        return descriptorEquivalenceForOverrides.areEquivalent(declarationDescriptor, declarationDescriptor2, z, z2);
    }

    public final boolean areEquivalent(DeclarationDescriptor a, DeclarationDescriptor b, boolean allowCopiesFromTheSameDeclaration, boolean distinguishExpectsAndNonExpects) {
        if ((a instanceof ClassDescriptor) && (b instanceof ClassDescriptor)) {
            return areClassesEquivalent((ClassDescriptor) a, (ClassDescriptor) b);
        }
        if ((a instanceof TypeParameterDescriptor) && (b instanceof TypeParameterDescriptor)) {
            return areTypeParametersEquivalent$default(this, (TypeParameterDescriptor) a, (TypeParameterDescriptor) b, allowCopiesFromTheSameDeclaration, null, 8, null);
        }
        if ((a instanceof CallableDescriptor) && (b instanceof CallableDescriptor)) {
            return areCallableDescriptorsEquivalent$default(this, (CallableDescriptor) a, (CallableDescriptor) b, allowCopiesFromTheSameDeclaration, distinguishExpectsAndNonExpects, false, KotlinTypeRefiner.Default.INSTANCE, 16, null);
        }
        return ((a instanceof PackageFragmentDescriptor) && (b instanceof PackageFragmentDescriptor)) ? Intrinsics.areEqual(((PackageFragmentDescriptor) a).getFqName(), ((PackageFragmentDescriptor) b).getFqName()) : Intrinsics.areEqual(a, b);
    }

    private final boolean areClassesEquivalent(ClassDescriptor a, ClassDescriptor b) {
        return Intrinsics.areEqual(a.getTypeConstructor(), b.getTypeConstructor());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ boolean areTypeParametersEquivalent$default(DescriptorEquivalenceForOverrides descriptorEquivalenceForOverrides, TypeParameterDescriptor typeParameterDescriptor, TypeParameterDescriptor typeParameterDescriptor2, boolean z, Function2 function2, int i, Object obj) {
        if ((i & 8) != 0) {
            function2 = new Function2() { // from class: kotlin.reflect.jvm.internal.impl.resolve.DescriptorEquivalenceForOverrides$$Lambda$0
                @Override // kotlin.jvm.functions.Function2
                public Object invoke(Object obj2, Object obj3) {
                    boolean areTypeParametersEquivalent$lambda$0;
                    areTypeParametersEquivalent$lambda$0 = DescriptorEquivalenceForOverrides.areTypeParametersEquivalent$lambda$0((DeclarationDescriptor) obj2, (DeclarationDescriptor) obj3);
                    return Boolean.valueOf(areTypeParametersEquivalent$lambda$0);
                }
            };
        }
        return descriptorEquivalenceForOverrides.areTypeParametersEquivalent(typeParameterDescriptor, typeParameterDescriptor2, z, function2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean areTypeParametersEquivalent$lambda$0(DeclarationDescriptor declarationDescriptor, DeclarationDescriptor declarationDescriptor2) {
        return false;
    }

    public final boolean areTypeParametersEquivalent(TypeParameterDescriptor a, TypeParameterDescriptor b, boolean allowCopiesFromTheSameDeclaration, Function2<? super DeclarationDescriptor, ? super DeclarationDescriptor, Boolean> equivalentCallables) {
        Intrinsics.checkNotNullParameter(a, "a");
        Intrinsics.checkNotNullParameter(b, "b");
        Intrinsics.checkNotNullParameter(equivalentCallables, "equivalentCallables");
        if (Intrinsics.areEqual(a, b)) {
            return true;
        }
        return !Intrinsics.areEqual(a.getContainingDeclaration(), b.getContainingDeclaration()) && ownersEquivalent(a, b, equivalentCallables, allowCopiesFromTheSameDeclaration) && a.getIndex() == b.getIndex();
    }

    private final SourceElement singleSource(CallableDescriptor $this$singleSource) {
        while (($this$singleSource instanceof CallableMemberDescriptor) && ((CallableMemberDescriptor) $this$singleSource).getKind() == CallableMemberDescriptor.Kind.FAKE_OVERRIDE) {
            Collection<? extends CallableMemberDescriptor> overriddenDescriptors = ((CallableMemberDescriptor) $this$singleSource).getOverriddenDescriptors();
            Intrinsics.checkNotNullExpressionValue(overriddenDescriptors, "getOverriddenDescriptors(...)");
            CallableDescriptor $this$singleSource2 = (CallableMemberDescriptor) CollectionsKt.singleOrNull(overriddenDescriptors);
            if ($this$singleSource2 == null) {
                return null;
            }
            $this$singleSource = $this$singleSource2;
        }
        return $this$singleSource.getSource();
    }

    public static /* synthetic */ boolean areCallableDescriptorsEquivalent$default(DescriptorEquivalenceForOverrides descriptorEquivalenceForOverrides, CallableDescriptor callableDescriptor, CallableDescriptor callableDescriptor2, boolean z, boolean z2, boolean z3, KotlinTypeRefiner kotlinTypeRefiner, int i, Object obj) {
        boolean z4;
        boolean z5;
        if ((i & 8) == 0) {
            z4 = z2;
        } else {
            z4 = true;
        }
        if ((i & 16) == 0) {
            z5 = z3;
        } else {
            z5 = false;
        }
        return descriptorEquivalenceForOverrides.areCallableDescriptorsEquivalent(callableDescriptor, callableDescriptor2, z, z4, z5, kotlinTypeRefiner);
    }

    public final boolean areCallableDescriptorsEquivalent(final CallableDescriptor a, final CallableDescriptor b, final boolean allowCopiesFromTheSameDeclaration, boolean distinguishExpectsAndNonExpects, boolean ignoreReturnType, KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(a, "a");
        Intrinsics.checkNotNullParameter(b, "b");
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        if (Intrinsics.areEqual(a, b)) {
            return true;
        }
        if (Intrinsics.areEqual(a.getName(), b.getName())) {
            if (distinguishExpectsAndNonExpects && (a instanceof MemberDescriptor) && (b instanceof MemberDescriptor) && ((MemberDescriptor) a).isExpect() != ((MemberDescriptor) b).isExpect()) {
                return false;
            }
            if ((!Intrinsics.areEqual(a.getContainingDeclaration(), b.getContainingDeclaration()) || (allowCopiesFromTheSameDeclaration && Intrinsics.areEqual(singleSource(a), singleSource(b)))) && !DescriptorUtils.isLocal(a) && !DescriptorUtils.isLocal(b) && ownersEquivalent(a, b, new Function2() { // from class: kotlin.reflect.jvm.internal.impl.resolve.DescriptorEquivalenceForOverrides$$Lambda$1
                @Override // kotlin.jvm.functions.Function2
                public Object invoke(Object obj, Object obj2) {
                    boolean areCallableDescriptorsEquivalent$lambda$0;
                    areCallableDescriptorsEquivalent$lambda$0 = DescriptorEquivalenceForOverrides.areCallableDescriptorsEquivalent$lambda$0((DeclarationDescriptor) obj, (DeclarationDescriptor) obj2);
                    return Boolean.valueOf(areCallableDescriptorsEquivalent$lambda$0);
                }
            }, allowCopiesFromTheSameDeclaration)) {
                OverridingUtil overridingUtil = OverridingUtil.create(kotlinTypeRefiner, new KotlinTypeChecker.TypeConstructorEquality(allowCopiesFromTheSameDeclaration, a, b) { // from class: kotlin.reflect.jvm.internal.impl.resolve.DescriptorEquivalenceForOverrides$$Lambda$2
                    private final boolean arg$0;
                    private final CallableDescriptor arg$1;
                    private final CallableDescriptor arg$2;

                    {
                        this.arg$0 = allowCopiesFromTheSameDeclaration;
                        this.arg$1 = a;
                        this.arg$2 = b;
                    }

                    @Override // kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker.TypeConstructorEquality
                    public boolean equals(TypeConstructor typeConstructor, TypeConstructor typeConstructor2) {
                        boolean areCallableDescriptorsEquivalent$lambda$1;
                        areCallableDescriptorsEquivalent$lambda$1 = DescriptorEquivalenceForOverrides.areCallableDescriptorsEquivalent$lambda$1(this.arg$0, this.arg$1, this.arg$2, typeConstructor, typeConstructor2);
                        return areCallableDescriptorsEquivalent$lambda$1;
                    }
                });
                Intrinsics.checkNotNullExpressionValue(overridingUtil, "create(...)");
                return overridingUtil.isOverridableBy(a, b, null, ignoreReturnType ^ true).getResult() == OverridingUtil.OverrideCompatibilityInfo.Result.OVERRIDABLE && overridingUtil.isOverridableBy(b, a, null, ignoreReturnType ^ true).getResult() == OverridingUtil.OverrideCompatibilityInfo.Result.OVERRIDABLE;
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean areCallableDescriptorsEquivalent$lambda$0(DeclarationDescriptor declarationDescriptor, DeclarationDescriptor declarationDescriptor2) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean areCallableDescriptorsEquivalent$lambda$1(boolean $allowCopiesFromTheSameDeclaration, final CallableDescriptor $a, final CallableDescriptor $b, TypeConstructor c1, TypeConstructor c2) {
        Intrinsics.checkNotNullParameter(c1, "c1");
        Intrinsics.checkNotNullParameter(c2, "c2");
        if (Intrinsics.areEqual(c1, c2)) {
            return true;
        }
        ClassifierDescriptor d1 = c1.mo1171getDeclarationDescriptor();
        ClassifierDescriptor d2 = c2.mo1171getDeclarationDescriptor();
        if (!(d1 instanceof TypeParameterDescriptor) || !(d2 instanceof TypeParameterDescriptor)) {
            return false;
        }
        return INSTANCE.areTypeParametersEquivalent((TypeParameterDescriptor) d1, (TypeParameterDescriptor) d2, $allowCopiesFromTheSameDeclaration, new Function2($a, $b) { // from class: kotlin.reflect.jvm.internal.impl.resolve.DescriptorEquivalenceForOverrides$$Lambda$3
            private final CallableDescriptor arg$0;
            private final CallableDescriptor arg$1;

            {
                this.arg$0 = $a;
                this.arg$1 = $b;
            }

            @Override // kotlin.jvm.functions.Function2
            public Object invoke(Object obj, Object obj2) {
                boolean areCallableDescriptorsEquivalent$lambda$1$0;
                areCallableDescriptorsEquivalent$lambda$1$0 = DescriptorEquivalenceForOverrides.areCallableDescriptorsEquivalent$lambda$1$0(this.arg$0, this.arg$1, (DeclarationDescriptor) obj, (DeclarationDescriptor) obj2);
                return Boolean.valueOf(areCallableDescriptorsEquivalent$lambda$1$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean areCallableDescriptorsEquivalent$lambda$1$0(CallableDescriptor $a, CallableDescriptor $b, DeclarationDescriptor x, DeclarationDescriptor y) {
        return Intrinsics.areEqual(x, $a) && Intrinsics.areEqual(y, $b);
    }

    private final boolean ownersEquivalent(DeclarationDescriptor a, DeclarationDescriptor b, Function2<? super DeclarationDescriptor, ? super DeclarationDescriptor, Boolean> function2, boolean allowCopiesFromTheSameDeclaration) {
        DeclarationDescriptor aOwner = a.getContainingDeclaration();
        DeclarationDescriptor bOwner = b.getContainingDeclaration();
        if ((aOwner instanceof CallableMemberDescriptor) || (bOwner instanceof CallableMemberDescriptor)) {
            return function2.invoke(aOwner, bOwner).booleanValue();
        }
        return areEquivalent$default(this, aOwner, bOwner, allowCopiesFromTheSameDeclaration, false, 8, null);
    }
}