package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* compiled from: PackageFragmentProvider.kt */
public final class PackageFragmentProviderKt {
    public static final List<PackageFragmentDescriptor> packageFragments(PackageFragmentProvider $this$packageFragments, FqName fqName) {
        Intrinsics.checkNotNullParameter($this$packageFragments, "<this>");
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        List packageFragments = new ArrayList();
        collectPackageFragmentsOptimizedIfPossible($this$packageFragments, fqName, packageFragments);
        return packageFragments;
    }

    public static final boolean isEmpty(PackageFragmentProvider $this$isEmpty, FqName fqName) {
        Intrinsics.checkNotNullParameter($this$isEmpty, "<this>");
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        return $this$isEmpty instanceof PackageFragmentProviderOptimized ? ((PackageFragmentProviderOptimized) $this$isEmpty).isEmpty(fqName) : packageFragments($this$isEmpty, fqName).isEmpty();
    }

    public static final void collectPackageFragmentsOptimizedIfPossible(PackageFragmentProvider $this$collectPackageFragmentsOptimizedIfPossible, FqName fqName, Collection<PackageFragmentDescriptor> packageFragments) {
        Intrinsics.checkNotNullParameter($this$collectPackageFragmentsOptimizedIfPossible, "<this>");
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        Intrinsics.checkNotNullParameter(packageFragments, "packageFragments");
        if (!($this$collectPackageFragmentsOptimizedIfPossible instanceof PackageFragmentProviderOptimized)) {
            packageFragments.addAll($this$collectPackageFragmentsOptimizedIfPossible.getPackageFragments(fqName));
        } else {
            ((PackageFragmentProviderOptimized) $this$collectPackageFragmentsOptimizedIfPossible).collectPackageFragments(fqName, packageFragments);
        }
    }
}