package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: ModalityUtils.kt */
public final class ModalityUtilsKt {
    public static final boolean isFinalClass(ClassDescriptor $this$isFinalClass) {
        Intrinsics.checkNotNullParameter($this$isFinalClass, "<this>");
        return $this$isFinalClass.getModality() == Modality.FINAL && $this$isFinalClass.getKind() != ClassKind.ENUM_CLASS;
    }
}