package io.ktor.util.pipeline;

import com.bilibili.studio.editor.asr.core.config.AsrDefaultConfig;
import io.ktor.util.StackFramesJvmKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* compiled from: StackWalkingFailedFrame.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00060\u0001j\u0002`\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\t\u001a\u00060\u0007j\u0002`\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u000e\u001a\u00020\r2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0012\u001a\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Lio/ktor/util/pipeline/StackWalkingFailedFrame;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Lio/ktor/util/CoroutineStackFrame;", "Lkotlin/coroutines/Continuation;", AsrDefaultConfig.SUBTITLE_TYPE_DEFAULT, "<init>", "()V", "Ljava/lang/StackTraceElement;", "Lio/ktor/util/StackTraceElement;", "getStackTraceElement", "()Ljava/lang/StackTraceElement;", "Lkotlin/Result;", "result", AsrDefaultConfig.SUBTITLE_TYPE_DEFAULT, "resumeWith", "(Ljava/lang/Object;)V", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "callerFrame", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "context", "ktor-utils"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class StackWalkingFailedFrame implements CoroutineStackFrame, Continuation<?> {
    public static final StackWalkingFailedFrame INSTANCE = new StackWalkingFailedFrame();

    private StackWalkingFailedFrame() {
    }

    public CoroutineStackFrame getCallerFrame() {
        return null;
    }

    public StackTraceElement getStackTraceElement() {
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(StackWalkingFailed.class);
        StackWalkingFailed stackWalkingFailed = StackWalkingFailed.INSTANCE;
        return StackFramesJvmKt.createStackTraceElement(orCreateKotlinClass, "failedToCaptureStackFrame", "StackWalkingFailed.kt", 8);
    }

    public CoroutineContext getContext() {
        return EmptyCoroutineContext.INSTANCE;
    }

    public void resumeWith(Object result) {
        StackWalkingFailed.INSTANCE.failedToCaptureStackFrame();
    }
}