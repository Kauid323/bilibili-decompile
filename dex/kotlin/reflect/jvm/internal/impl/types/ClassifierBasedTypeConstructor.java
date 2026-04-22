package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;

/* compiled from: ClassifierBasedTypeConstructor.kt */
public abstract class ClassifierBasedTypeConstructor implements TypeConstructor {
    private int hashCode;

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    /* renamed from: getDeclarationDescriptor */
    public abstract ClassifierDescriptor mo1171getDeclarationDescriptor();

    protected abstract boolean isSameClassifier(ClassifierDescriptor classifierDescriptor);

    public int hashCode() {
        int computedHashCode;
        int cachedHashCode = this.hashCode;
        if (cachedHashCode != 0) {
            return cachedHashCode;
        }
        ClassifierDescriptor descriptor = mo1171getDeclarationDescriptor();
        if (hasMeaningfulFqName(descriptor)) {
            computedHashCode = DescriptorUtils.getFqName(descriptor).hashCode();
        } else {
            computedHashCode = System.identityHashCode(this);
        }
        int it = computedHashCode;
        this.hashCode = it;
        return computedHashCode;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof TypeConstructor) && other.hashCode() == hashCode() && ((TypeConstructor) other).getParameters().size() == getParameters().size()) {
            ClassifierDescriptor myDescriptor = mo1171getDeclarationDescriptor();
            ClassifierDescriptor otherDescriptor = ((TypeConstructor) other).mo1171getDeclarationDescriptor();
            if (otherDescriptor != null && hasMeaningfulFqName(myDescriptor) && hasMeaningfulFqName(otherDescriptor)) {
                return isSameClassifier(otherDescriptor);
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean areFqNamesEqual(ClassifierDescriptor first, ClassifierDescriptor second) {
        Intrinsics.checkNotNullParameter(first, "first");
        Intrinsics.checkNotNullParameter(second, "second");
        if (Intrinsics.areEqual(first.getName(), second.getName())) {
            DeclarationDescriptor a = first.getContainingDeclaration();
            for (DeclarationDescriptor b = second.getContainingDeclaration(); a != null && b != null; b = b.getContainingDeclaration()) {
                if (a instanceof ModuleDescriptor) {
                    return b instanceof ModuleDescriptor;
                }
                if (b instanceof ModuleDescriptor) {
                    return false;
                }
                if (a instanceof PackageFragmentDescriptor) {
                    return (b instanceof PackageFragmentDescriptor) && Intrinsics.areEqual(((PackageFragmentDescriptor) a).getFqName(), ((PackageFragmentDescriptor) b).getFqName());
                } else if ((b instanceof PackageFragmentDescriptor) || !Intrinsics.areEqual(a.getName(), b.getName())) {
                    return false;
                } else {
                    a = a.getContainingDeclaration();
                }
            }
            return true;
        }
        return false;
    }

    private final boolean hasMeaningfulFqName(ClassifierDescriptor descriptor) {
        return (ErrorUtils.isError(descriptor) || DescriptorUtils.isLocal(descriptor)) ? false : true;
    }
}