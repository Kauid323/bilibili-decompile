package io.ktor.util.logging;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.slf4j.Logger;

/* compiled from: LoggerJvm.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\"\u0019\u0010\u0003\u001a\u00020\u0002*\u00060\u0000j\u0002`\u00018F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004*\n\u0010\u0005\"\u00020\u00002\u00020\u0000¨\u0006\u0006"}, d2 = {"Lorg/slf4j/Logger;", "Lio/ktor/util/logging/Logger;", "", "isTraceEnabled", "(Lorg/slf4j/Logger;)Z", "Logger", "ktor-utils"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class LoggerJvmKt {
    public static final boolean isTraceEnabled(Logger $this$isTraceEnabled) {
        Intrinsics.checkNotNullParameter($this$isTraceEnabled, "<this>");
        return $this$isTraceEnabled.isTraceEnabled();
    }
}