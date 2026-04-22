package kotlin.reflect.jvm.internal.impl.utils;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: exceptionUtils.kt */
public final class ExceptionUtilsKt {
    public static final RuntimeException rethrow(Throwable e) {
        Intrinsics.checkNotNullParameter(e, "e");
        throw e;
    }

    public static final boolean isProcessCanceledException(Throwable $this$isProcessCanceledException) {
        Intrinsics.checkNotNullParameter($this$isProcessCanceledException, "<this>");
        Class klass = $this$isProcessCanceledException.getClass();
        while (!Intrinsics.areEqual(klass.getCanonicalName(), "com.intellij.openapi.progress.ProcessCanceledException")) {
            Class superclass = klass.getSuperclass();
            if (superclass == null) {
                return false;
            }
            klass = superclass;
        }
        return true;
    }
}