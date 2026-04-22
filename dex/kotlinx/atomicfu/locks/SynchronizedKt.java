package kotlinx.atomicfu.locks;

import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Synchronized.kt */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\r\u0010\u0000\u001a\u00060\u0001j\u0002`\u0002H\u0087\b\u001a1\u0010\u0003\u001a\u0002H\u0004\"\u0004\b\u0000\u0010\u00042\n\u0010\u0005\u001a\u00060\u0006j\u0002`\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00040\tH\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\n\u001a-\u0010\u000b\u001a\u0002H\u0004\"\u0004\b\u0000\u0010\u0004*\u00060\u0001j\u0002`\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00040\tH\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\f*\n\u0010\r\"\u00020\u00012\u00020\u0001*\n\u0010\u000e\"\u00020\u00062\u00020\u0006\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u000f"}, d2 = {"reentrantLock", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/atomicfu/locks/ReentrantLock;", "synchronized", "T", "lock", "", "Lkotlinx/atomicfu/locks/SynchronizedObject;", "block", "Lkotlin/Function0;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "withLock", "(Ljava/util/concurrent/locks/ReentrantLock;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "ReentrantLock", "SynchronizedObject", "atomicfu"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class SynchronizedKt {
    private static final ReentrantLock reentrantLock() {
        return new ReentrantLock();
    }

    private static final <T> T withLock(ReentrantLock $this$withLock, Function0<? extends T> block) {
        Intrinsics.checkNotNullParameter($this$withLock, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        $this$withLock.lock();
        try {
            return block.invoke();
        } finally {
            InlineMarker.finallyStart(1);
            $this$withLock.unlock();
            InlineMarker.finallyEnd(1);
        }
    }

    /* renamed from: synchronized  reason: not valid java name */
    private static final <T> T m1385synchronized(Object lock, Function0<? extends T> block) {
        T invoke;
        Intrinsics.checkNotNullParameter(lock, "lock");
        Intrinsics.checkNotNullParameter(block, "block");
        synchronized (lock) {
            try {
                invoke = block.invoke();
                InlineMarker.finallyStart(1);
            } catch (Throwable th) {
                InlineMarker.finallyStart(1);
                InlineMarker.finallyEnd(1);
                throw th;
            }
        }
        InlineMarker.finallyEnd(1);
        return invoke;
    }
}