package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;

/* compiled from: methodSignatureBuildingUtils.kt */
public final class MethodSignatureBuildingUtilsKt {
    public static final String signature(SignatureBuildingComponents $this$signature, ClassDescriptor classDescriptor, String jvmDescriptor) {
        Intrinsics.checkNotNullParameter($this$signature, "<this>");
        Intrinsics.checkNotNullParameter(classDescriptor, "classDescriptor");
        Intrinsics.checkNotNullParameter(jvmDescriptor, "jvmDescriptor");
        return $this$signature.signature(MethodSignatureMappingKt.getInternalName(classDescriptor), jvmDescriptor);
    }
}