package kotlin.reflect.jvm.internal.impl.resolve;

import java.util.Collection;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;

/* compiled from: VisibilityUtil.kt */
public final class VisibilityUtilKt {
    public static final CallableMemberDescriptor findMemberWithMaxVisibility(Collection<? extends CallableMemberDescriptor> descriptors) {
        Intrinsics.checkNotNullParameter(descriptors, "descriptors");
        if (descriptors.isEmpty()) {
            throw new AssertionError("Assertion failed");
        }
        CallableMemberDescriptor descriptor = null;
        for (CallableMemberDescriptor candidate : descriptors) {
            if (descriptor == null) {
                descriptor = candidate;
            } else {
                Integer result = DescriptorVisibilities.compare(descriptor.getVisibility(), candidate.getVisibility());
                if (result != null && result.intValue() < 0) {
                    descriptor = candidate;
                }
            }
        }
        Intrinsics.checkNotNull(descriptor);
        return descriptor;
    }
}