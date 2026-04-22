package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderKt;
import kotlin.reflect.jvm.internal.impl.name.ClassId;

/* compiled from: DeserializedClassDataFinder.kt */
public final class DeserializedClassDataFinder implements ClassDataFinder {
    private final PackageFragmentProvider packageFragmentProvider;

    public DeserializedClassDataFinder(PackageFragmentProvider packageFragmentProvider) {
        Intrinsics.checkNotNullParameter(packageFragmentProvider, "packageFragmentProvider");
        this.packageFragmentProvider = packageFragmentProvider;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDataFinder
    public ClassData findClassData(ClassId classId) {
        ClassData it;
        Intrinsics.checkNotNullParameter(classId, "classId");
        List packageFragments = PackageFragmentProviderKt.packageFragments(this.packageFragmentProvider, classId.getPackageFqName());
        for (PackageFragmentDescriptor fragment : packageFragments) {
            if ((fragment instanceof DeserializedPackageFragment) && (it = ((DeserializedPackageFragment) fragment).getClassDataFinder().findClassData(classId)) != null) {
                return it;
            }
        }
        return null;
    }
}