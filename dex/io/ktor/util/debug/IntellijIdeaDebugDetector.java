package io.ktor.util.debug;

import java.lang.management.ManagementFactory;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.text.StringsKt;

/* compiled from: IntellijIdeaDebugDetectorJvm.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001b\u0010\u0007\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lio/ktor/util/debug/IntellijIdeaDebugDetector;", "", "<init>", "()V", "", "isDebuggerConnected$delegate", "Lkotlin/Lazy;", "isDebuggerConnected", "()Z", "ktor-utils"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class IntellijIdeaDebugDetector {
    public static final IntellijIdeaDebugDetector INSTANCE = new IntellijIdeaDebugDetector();
    private static final Lazy isDebuggerConnected$delegate = LazyKt.lazy(new Function0() { // from class: io.ktor.util.debug.IntellijIdeaDebugDetector$$ExternalSyntheticLambda0
        public final Object invoke() {
            boolean isDebuggerConnected_delegate$lambda$0;
            isDebuggerConnected_delegate$lambda$0 = IntellijIdeaDebugDetector.isDebuggerConnected_delegate$lambda$0();
            return Boolean.valueOf(isDebuggerConnected_delegate$lambda$0);
        }
    });

    private IntellijIdeaDebugDetector() {
    }

    public final boolean isDebuggerConnected() {
        return ((Boolean) isDebuggerConnected$delegate.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isDebuggerConnected_delegate$lambda$0() {
        try {
            return StringsKt.contains$default(ManagementFactory.getRuntimeMXBean().getInputArguments().toString(), "jdwp", false, 2, (Object) null);
        } catch (Throwable th) {
            return false;
        }
    }
}