package io.ktor.util.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ExceptionUtilsJvm.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\u0019\u0010\u0003\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"", "cause", "", "initCauseBridge", "(Ljava/lang/Throwable;Ljava/lang/Throwable;)V", "ktor-utils"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ExceptionUtilsJvmKt {
    public static final void initCauseBridge(Throwable $this$initCauseBridge, Throwable cause) {
        Intrinsics.checkNotNullParameter($this$initCauseBridge, "<this>");
        Intrinsics.checkNotNullParameter(cause, "cause");
        $this$initCauseBridge.initCause(cause);
    }
}