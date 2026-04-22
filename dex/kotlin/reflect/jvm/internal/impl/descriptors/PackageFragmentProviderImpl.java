package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Deprecated;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.sequences.SequencesKt;

/* compiled from: PackageFragmentProviderImpl.kt */
public final class PackageFragmentProviderImpl implements PackageFragmentProviderOptimized {
    private final Collection<PackageFragmentDescriptor> packageFragments;

    /* JADX WARN: Multi-variable type inference failed */
    public PackageFragmentProviderImpl(Collection<? extends PackageFragmentDescriptor> packageFragments) {
        Intrinsics.checkNotNullParameter(packageFragments, "packageFragments");
        this.packageFragments = packageFragments;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderOptimized
    public void collectPackageFragments(FqName fqName, Collection<PackageFragmentDescriptor> packageFragments) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        Intrinsics.checkNotNullParameter(packageFragments, "packageFragments");
        Iterable $this$filterTo$iv = this.packageFragments;
        for (Object element$iv : $this$filterTo$iv) {
            PackageFragmentDescriptor it = (PackageFragmentDescriptor) element$iv;
            if (Intrinsics.areEqual(it.getFqName(), fqName)) {
                packageFragments.add(element$iv);
            }
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderOptimized
    public boolean isEmpty(FqName fqName) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        Iterable $this$none$iv = this.packageFragments;
        if (($this$none$iv instanceof Collection) && ((Collection) $this$none$iv).isEmpty()) {
            return true;
        }
        for (Object element$iv : $this$none$iv) {
            PackageFragmentDescriptor it = (PackageFragmentDescriptor) element$iv;
            if (Intrinsics.areEqual(it.getFqName(), fqName)) {
                return false;
            }
        }
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider
    @Deprecated(message = "for usages use #packageFragments(FqName) at final point, for impl use #collectPackageFragments(FqName, MutableCollection<PackageFragmentDescriptor>)")
    public List<PackageFragmentDescriptor> getPackageFragments(FqName fqName) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        Iterable $this$filter$iv = this.packageFragments;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            PackageFragmentDescriptor it = (PackageFragmentDescriptor) element$iv$iv;
            if (Intrinsics.areEqual(it.getFqName(), fqName)) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        return (List) destination$iv$iv;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider
    public Collection<FqName> getSubPackagesOf(final FqName fqName, Function1<? super Name, Boolean> nameFilter) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        Intrinsics.checkNotNullParameter(nameFilter, "nameFilter");
        return SequencesKt.toList(SequencesKt.filter(SequencesKt.map(CollectionsKt.asSequence(this.packageFragments), new Function1() { // from class: kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderImpl$$Lambda$0
            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                FqName subPackagesOf$lambda$0;
                subPackagesOf$lambda$0 = PackageFragmentProviderImpl.getSubPackagesOf$lambda$0((PackageFragmentDescriptor) obj);
                return subPackagesOf$lambda$0;
            }
        }), new Function1(fqName) { // from class: kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderImpl$$Lambda$1
            private final FqName arg$0;

            {
                this.arg$0 = fqName;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                boolean subPackagesOf$lambda$1;
                subPackagesOf$lambda$1 = PackageFragmentProviderImpl.getSubPackagesOf$lambda$1(this.arg$0, (FqName) obj);
                return Boolean.valueOf(subPackagesOf$lambda$1);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FqName getSubPackagesOf$lambda$0(PackageFragmentDescriptor it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getFqName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean getSubPackagesOf$lambda$1(FqName $fqName, FqName it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return !it.isRoot() && Intrinsics.areEqual(it.parent(), $fqName);
    }
}