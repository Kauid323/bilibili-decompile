package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;

/* compiled from: JavaDescriptorUtil.kt */
public final class JavaDescriptorUtilKt {
    public static final boolean isJavaField(PropertyDescriptor $this$isJavaField) {
        Intrinsics.checkNotNullParameter($this$isJavaField, "<this>");
        return $this$isJavaField.getGetter() == null;
    }
}