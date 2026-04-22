package kotlin.reflect.jvm.internal.impl.resolve;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleCapability;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;

/* compiled from: StdlibClassFinder.kt */
public final class StdlibClassFinderKt {
    private static final ModuleCapability<StdlibClassFinder> STDLIB_CLASS_FINDER_CAPABILITY = new ModuleCapability<>("StdlibClassFinder");

    public static final StdlibClassFinder getStdlibClassFinder(ModuleDescriptor $this$getStdlibClassFinder) {
        Intrinsics.checkNotNullParameter($this$getStdlibClassFinder, "<this>");
        StdlibClassFinder stdlibClassFinder = (StdlibClassFinder) $this$getStdlibClassFinder.getCapability(STDLIB_CLASS_FINDER_CAPABILITY);
        return stdlibClassFinder == null ? CliStdlibClassFinderImpl.INSTANCE : stdlibClassFinder;
    }
}