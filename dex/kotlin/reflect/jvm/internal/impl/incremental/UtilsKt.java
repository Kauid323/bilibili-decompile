package kotlin.reflect.jvm.internal.impl.incremental;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LocationInfo;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupTracker;
import kotlin.reflect.jvm.internal.impl.incremental.components.Position;
import kotlin.reflect.jvm.internal.impl.incremental.components.ScopeKind;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;

/* compiled from: utils.kt */
public final class UtilsKt {
    public static final void record(LookupTracker $this$record, LookupLocation from, ClassDescriptor scopeOwner, Name name) {
        LocationInfo location2;
        Intrinsics.checkNotNullParameter($this$record, "<this>");
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(scopeOwner, "scopeOwner");
        Intrinsics.checkNotNullParameter(name, "name");
        if ($this$record == LookupTracker.DO_NOTHING.INSTANCE || (location2 = from.getLocation()) == null) {
            return;
        }
        Position position = $this$record.getRequiresPosition() ? location2.getPosition() : Position.Companion.getNO_POSITION();
        String filePath = location2.getFilePath();
        String asString = DescriptorUtils.getFqName(scopeOwner).asString();
        ScopeKind scopeKind = ScopeKind.CLASSIFIER;
        String asString2 = name.asString();
        Intrinsics.checkNotNullExpressionValue(asString2, "asString(...)");
        $this$record.record(filePath, position, asString, scopeKind, asString2);
    }

    public static final void record(LookupTracker $this$record, LookupLocation from, PackageFragmentDescriptor scopeOwner, Name name) {
        Intrinsics.checkNotNullParameter($this$record, "<this>");
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(scopeOwner, "scopeOwner");
        Intrinsics.checkNotNullParameter(name, "name");
        String asString = scopeOwner.getFqName().asString();
        String asString2 = name.asString();
        Intrinsics.checkNotNullExpressionValue(asString2, "asString(...)");
        recordPackageLookup($this$record, from, asString, asString2);
    }

    public static final void recordPackageLookup(LookupTracker $this$recordPackageLookup, LookupLocation from, String packageFqName, String name) {
        LocationInfo location2;
        Intrinsics.checkNotNullParameter($this$recordPackageLookup, "<this>");
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(packageFqName, "packageFqName");
        Intrinsics.checkNotNullParameter(name, "name");
        if ($this$recordPackageLookup == LookupTracker.DO_NOTHING.INSTANCE || (location2 = from.getLocation()) == null) {
            return;
        }
        Position position = $this$recordPackageLookup.getRequiresPosition() ? location2.getPosition() : Position.Companion.getNO_POSITION();
        $this$recordPackageLookup.record(location2.getFilePath(), position, packageFqName, ScopeKind.PACKAGE, name);
    }
}