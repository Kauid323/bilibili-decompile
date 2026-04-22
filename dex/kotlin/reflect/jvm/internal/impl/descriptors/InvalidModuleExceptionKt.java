package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: InvalidModuleException.kt */
public final class InvalidModuleExceptionKt {
    private static final ModuleCapability<InvalidModuleNotifier> INVALID_MODULE_NOTIFIER_CAPABILITY = new ModuleCapability<>("InvalidModuleNotifier");

    public static final void moduleInvalidated(ModuleDescriptor $this$moduleInvalidated) {
        Intrinsics.checkNotNullParameter($this$moduleInvalidated, "<this>");
        InvalidModuleNotifier capability = (InvalidModuleNotifier) $this$moduleInvalidated.getCapability(INVALID_MODULE_NOTIFIER_CAPABILITY);
        if (capability == null) {
            throw new InvalidModuleException("Accessing invalid module descriptor " + $this$moduleInvalidated);
        }
        capability.notifyModuleInvalidated($this$moduleInvalidated);
    }
}