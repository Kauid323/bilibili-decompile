package io.ktor.util.pipeline;

import com.bilibili.studio.editor.asr.core.config.AsrDefaultConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StackTraceRecoverJvm.kt */
@Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0003\n\u0002\b\u0004\u001a\u001d\u0010\u0002\u001a\u00020\u0000*\u00020\u00002\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {AsrDefaultConfig.SUBTITLE_TYPE_DEFAULT, "cause", "withCause", "(Ljava/lang/Throwable;Ljava/lang/Throwable;)Ljava/lang/Throwable;", "ktor-utils"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class StackTraceRecoverJvmKt {
    public static final Throwable withCause(Throwable $this$withCause, Throwable cause) {
        Intrinsics.checkNotNullParameter($this$withCause, "<this>");
        return $this$withCause;
    }
}