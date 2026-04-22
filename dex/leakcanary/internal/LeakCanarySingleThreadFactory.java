package leakcanary.internal;

import java.util.concurrent.ThreadFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LeakCanarySingleThreadFactory.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lleakcanary/internal/LeakCanarySingleThreadFactory;", "Ljava/util/concurrent/ThreadFactory;", "threadName", "", "(Ljava/lang/String;)V", "newThread", "Ljava/lang/Thread;", "runnable", "Ljava/lang/Runnable;", "leakcanary-android-core_release"}, k = 1, mv = {1, 4, 1})
public final class LeakCanarySingleThreadFactory implements ThreadFactory {
    private final String threadName;

    public LeakCanarySingleThreadFactory(String threadName) {
        Intrinsics.checkParameterIsNotNull(threadName, "threadName");
        this.threadName = "LeakCanary-" + threadName;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Intrinsics.checkParameterIsNotNull(runnable, "runnable");
        return new Thread(runnable, this.threadName);
    }
}