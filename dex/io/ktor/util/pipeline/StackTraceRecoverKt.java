package io.ktor.util.pipeline;

import com.bilibili.studio.editor.asr.core.config.AsrDefaultConfig;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;

/* compiled from: StackTraceRecover.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a#\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0000¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {AsrDefaultConfig.SUBTITLE_TYPE_DEFAULT, "exception", "Lkotlin/coroutines/Continuation;", "continuation", "recoverStackTraceBridge", "(Ljava/lang/Throwable;Lkotlin/coroutines/Continuation;)Ljava/lang/Throwable;", "ktor-utils"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class StackTraceRecoverKt {
    public static final Throwable recoverStackTraceBridge(Throwable exception, Continuation<?> continuation) {
        Throwable th;
        Intrinsics.checkNotNullParameter(exception, "exception");
        Intrinsics.checkNotNullParameter(continuation, "continuation");
        try {
            if (DebugKt.getRECOVER_STACK_TRACES() && (continuation instanceof CoroutineStackFrame)) {
                th = StackTraceRecoveryKt.access$recoverFromStackFrame(exception, (CoroutineStackFrame) continuation);
                return StackTraceRecoverJvmKt.withCause(th, exception.getCause());
            }
            th = exception;
            return StackTraceRecoverJvmKt.withCause(th, exception.getCause());
        } catch (Throwable th2) {
            return exception;
        }
    }
}