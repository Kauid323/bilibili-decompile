package kotlin.reflect.jvm.internal.impl.resolve;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope;
import kotlin.sequences.Sequence;

/* compiled from: SealedClassInheritorsProvider.kt */
public final class CliSealedClassInheritorsProvider extends SealedClassInheritorsProvider {
    public static final CliSealedClassInheritorsProvider INSTANCE = new CliSealedClassInheritorsProvider();

    private CliSealedClassInheritorsProvider() {
    }

    public Collection<ClassDescriptor> computeSealedSubclasses(ClassDescriptor sealedClass, boolean allowSealedInheritorsInDifferentFilesOfSamePackage) {
        DeclarationDescriptor declarationDescriptor;
        DeclarationDescriptor container;
        Intrinsics.checkNotNullParameter(sealedClass, "sealedClass");
        if (sealedClass.getModality() != Modality.SEALED) {
            return CollectionsKt.emptyList();
        }
        LinkedHashSet result = new LinkedHashSet();
        if (!allowSealedInheritorsInDifferentFilesOfSamePackage) {
            container = sealedClass.getContainingDeclaration();
        } else {
            Sequence $this$firstOrNull$iv = DescriptorUtilsKt.getParents(sealedClass);
            Iterator<DeclarationDescriptor> it = $this$firstOrNull$iv.iterator();
            while (true) {
                if (it.hasNext()) {
                    declarationDescriptor = it.next();
                    DeclarationDescriptor it2 = declarationDescriptor;
                    if (it2 instanceof PackageFragmentDescriptor) {
                        break;
                    }
                } else {
                    declarationDescriptor = null;
                    break;
                }
            }
            container = declarationDescriptor;
        }
        if (container instanceof PackageFragmentDescriptor) {
            computeSealedSubclasses$collectSubclasses(sealedClass, result, ((PackageFragmentDescriptor) container).getMemberScope(), allowSealedInheritorsInDifferentFilesOfSamePackage);
        }
        MemberScope unsubstitutedInnerClassesScope = sealedClass.getUnsubstitutedInnerClassesScope();
        Intrinsics.checkNotNullExpressionValue(unsubstitutedInnerClassesScope, "getUnsubstitutedInnerClassesScope(...)");
        computeSealedSubclasses$collectSubclasses(sealedClass, result, unsubstitutedInnerClassesScope, true);
        LinkedHashSet $this$sortedBy$iv = result;
        return CollectionsKt.sortedWith($this$sortedBy$iv, new Comparator() { // from class: kotlin.reflect.jvm.internal.impl.resolve.CliSealedClassInheritorsProvider$computeSealedSubclasses$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                ClassDescriptor it3 = (ClassDescriptor) t;
                ClassDescriptor it4 = (ClassDescriptor) t2;
                return ComparisonsKt.compareValues(DescriptorUtilsKt.getFqNameSafe(it3).asString(), DescriptorUtilsKt.getFqNameSafe(it4).asString());
            }
        });
    }

    private static final void computeSealedSubclasses$collectSubclasses(ClassDescriptor $sealedClass, LinkedHashSet<ClassDescriptor> linkedHashSet, MemberScope scope, boolean collectNested) {
        ClassDescriptor classDescriptor;
        for (DeclarationDescriptor descriptor : ResolutionScope.DefaultImpls.getContributedDescriptors$default(scope, DescriptorKindFilter.CLASSIFIERS, null, 2, null)) {
            if (descriptor instanceof ClassDescriptor) {
                if (((ClassDescriptor) descriptor).isExpect()) {
                    Name name = ((ClassDescriptor) descriptor).getName();
                    Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                    ClassifierDescriptor actualDescriptor = scope.mo1173getContributedClassifier(name, NoLookupLocation.WHEN_GET_ALL_DESCRIPTORS);
                    if (actualDescriptor instanceof ClassDescriptor) {
                        classDescriptor = (ClassDescriptor) actualDescriptor;
                    } else {
                        classDescriptor = actualDescriptor instanceof TypeAliasDescriptor ? ((TypeAliasDescriptor) actualDescriptor).getClassDescriptor() : null;
                    }
                } else {
                    classDescriptor = (ClassDescriptor) descriptor;
                }
                if (classDescriptor != null) {
                    ClassDescriptor refinedDescriptor = classDescriptor;
                    if (DescriptorUtils.isDirectSubclass(refinedDescriptor, $sealedClass)) {
                        linkedHashSet.add(refinedDescriptor);
                    }
                    if (collectNested) {
                        MemberScope unsubstitutedInnerClassesScope = refinedDescriptor.getUnsubstitutedInnerClassesScope();
                        Intrinsics.checkNotNullExpressionValue(unsubstitutedInnerClassesScope, "getUnsubstitutedInnerClassesScope(...)");
                        computeSealedSubclasses$collectSubclasses($sealedClass, linkedHashSet, unsubstitutedInnerClassesScope, collectNested);
                    }
                }
            }
        }
    }
}