package okio;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationUnit;
import kotlin.time.DurationUnitKt;

/* compiled from: Timeout.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\nH\u0016J\b\u0010\u000e\u001a\u00020\u0000H\u0016J\b\u0010\u000f\u001a\u00020\u0000H\u0016J\u0016\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0013J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016J-\u0010\u0014\u001a\u0002H\u0015\"\u0004\b\u0000\u0010\u00152\u0006\u0010\u0016\u001a\u00020\u00002\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00150\u0018H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u0019J\b\u0010\u001a\u001a\u00020\nH\u0016J\u0018\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\u0010\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u0001H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001f"}, d2 = {"Lokio/Timeout;", "", "()V", "cancelMark", "deadlineNanoTime", "", "hasDeadline", "", "timeoutNanos", "awaitSignal", "", "condition", "Ljava/util/concurrent/locks/Condition;", "cancel", "clearDeadline", "clearTimeout", "deadline", "duration", "unit", "Ljava/util/concurrent/TimeUnit;", "intersectWith", "T", "other", "block", "Lkotlin/Function0;", "(Lokio/Timeout;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "throwIfReached", "timeout", "waitUntilNotified", "monitor", "Companion", "okio"}, k = 1, mv = {1, 9, 0}, xi = 48)
public class Timeout {
    public static final Companion Companion = new Companion(null);
    public static final Timeout NONE = new Timeout() { // from class: okio.Timeout$Companion$NONE$1
        @Override // okio.Timeout
        public Timeout timeout(long timeout, TimeUnit unit) {
            Intrinsics.checkNotNullParameter(unit, "unit");
            return this;
        }

        @Override // okio.Timeout
        public Timeout deadlineNanoTime(long deadlineNanoTime) {
            return this;
        }

        @Override // okio.Timeout
        public void throwIfReached() {
        }
    };
    private volatile Object cancelMark;
    private long deadlineNanoTime;
    private boolean hasDeadline;
    private long timeoutNanos;

    public Timeout timeout(long timeout, TimeUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        if (!(timeout >= 0)) {
            throw new IllegalArgumentException(("timeout < 0: " + timeout).toString());
        }
        this.timeoutNanos = unit.toNanos(timeout);
        return this;
    }

    public long timeoutNanos() {
        return this.timeoutNanos;
    }

    public boolean hasDeadline() {
        return this.hasDeadline;
    }

    public long deadlineNanoTime() {
        if (this.hasDeadline) {
            return this.deadlineNanoTime;
        }
        throw new IllegalStateException("No deadline".toString());
    }

    public Timeout deadlineNanoTime(long deadlineNanoTime) {
        this.hasDeadline = true;
        this.deadlineNanoTime = deadlineNanoTime;
        return this;
    }

    public final Timeout deadline(long duration, TimeUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        if (!(duration > 0)) {
            throw new IllegalArgumentException(("duration <= 0: " + duration).toString());
        }
        return deadlineNanoTime(System.nanoTime() + unit.toNanos(duration));
    }

    public Timeout clearTimeout() {
        this.timeoutNanos = 0L;
        return this;
    }

    public Timeout clearDeadline() {
        this.hasDeadline = false;
        return this;
    }

    public void throwIfReached() throws IOException {
        if (Thread.currentThread().isInterrupted()) {
            throw new InterruptedIOException("interrupted");
        }
        if (this.hasDeadline && this.deadlineNanoTime - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }

    public void cancel() {
        this.cancelMark = new Object();
    }

    public void awaitSignal(Condition condition) throws InterruptedIOException {
        long j;
        Intrinsics.checkNotNullParameter(condition, "condition");
        try {
            boolean hasDeadline = hasDeadline();
            long timeoutNanos = timeoutNanos();
            if (!hasDeadline && timeoutNanos == 0) {
                condition.await();
                return;
            }
            if (hasDeadline && timeoutNanos != 0) {
                long deadlineNanos = deadlineNanoTime() - System.nanoTime();
                j = Math.min(timeoutNanos, deadlineNanos);
            } else if (hasDeadline) {
                j = deadlineNanoTime() - System.nanoTime();
            } else {
                j = timeoutNanos;
            }
            long waitNanos = j;
            if (waitNanos <= 0) {
                throw new InterruptedIOException("timeout");
            }
            Object cancelMarkBefore = this.cancelMark;
            long nanosRemaining = condition.awaitNanos(waitNanos);
            if (nanosRemaining <= 0 && this.cancelMark == cancelMarkBefore) {
                throw new InterruptedIOException("timeout");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        }
    }

    public void waitUntilNotified(Object monitor) throws InterruptedIOException {
        long j;
        Intrinsics.checkNotNullParameter(monitor, "monitor");
        try {
            boolean hasDeadline = hasDeadline();
            long timeoutNanos = timeoutNanos();
            if (!hasDeadline && timeoutNanos == 0) {
                monitor.wait();
                return;
            }
            long start = System.nanoTime();
            if (hasDeadline && timeoutNanos != 0) {
                long deadlineNanos = deadlineNanoTime() - start;
                j = Math.min(timeoutNanos, deadlineNanos);
            } else if (hasDeadline) {
                j = deadlineNanoTime() - start;
            } else {
                j = timeoutNanos;
            }
            long waitNanos = j;
            if (waitNanos <= 0) {
                throw new InterruptedIOException("timeout");
            }
            Object cancelMarkBefore = this.cancelMark;
            long waitMillis = waitNanos / 1000000;
            Long.signum(waitMillis);
            monitor.wait(waitMillis, (int) (waitNanos - (1000000 * waitMillis)));
            long elapsedNanos = System.nanoTime() - start;
            if (elapsedNanos >= waitNanos && this.cancelMark == cancelMarkBefore) {
                throw new InterruptedIOException("timeout");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        }
    }

    public final <T> T intersectWith(Timeout other, Function0<? extends T> block) {
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(block, "block");
        long originalTimeout = timeoutNanos();
        timeout(Companion.minTimeout(other.timeoutNanos(), timeoutNanos()), TimeUnit.NANOSECONDS);
        if (hasDeadline()) {
            long originalDeadline = deadlineNanoTime();
            if (other.hasDeadline()) {
                deadlineNanoTime(Math.min(deadlineNanoTime(), other.deadlineNanoTime()));
            }
            try {
                return block.invoke();
            } finally {
                InlineMarker.finallyStart(1);
                timeout(originalTimeout, TimeUnit.NANOSECONDS);
                if (other.hasDeadline()) {
                    deadlineNanoTime(originalDeadline);
                }
                InlineMarker.finallyEnd(1);
            }
        }
        if (other.hasDeadline()) {
            deadlineNanoTime(other.deadlineNanoTime());
        }
        try {
            return block.invoke();
        } finally {
            InlineMarker.finallyStart(1);
            timeout(originalTimeout, TimeUnit.NANOSECONDS);
            if (other.hasDeadline()) {
                clearDeadline();
            }
            InlineMarker.finallyEnd(1);
        }
    }

    /* compiled from: Timeout.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006J\u001a\u0010\t\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bJ\u001c\u0010\t\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\f\u001a\u00020\rø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0010"}, d2 = {"Lokio/Timeout$Companion;", "", "()V", "NONE", "Lokio/Timeout;", "minTimeout", "", "aNanos", "bNanos", "timeout", "unit", "Lkotlin/time/DurationUnit;", "duration", "Lkotlin/time/Duration;", "timeout-HG0u8IE", "(Lokio/Timeout;J)Lokio/Timeout;", "okio"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Timeout timeout(Timeout $this$timeout, long timeout, DurationUnit unit) {
            Intrinsics.checkNotNullParameter($this$timeout, "<this>");
            Intrinsics.checkNotNullParameter(unit, "unit");
            return $this$timeout.timeout(timeout, DurationUnitKt.toTimeUnit(unit));
        }

        /* renamed from: timeout-HG0u8IE  reason: not valid java name */
        public final Timeout m1657timeoutHG0u8IE(Timeout timeout, long duration) {
            Intrinsics.checkNotNullParameter(timeout, "$this$timeout");
            return timeout.timeout(Duration.m1258getInWholeNanosecondsimpl(duration), TimeUnit.NANOSECONDS);
        }

        public final long minTimeout(long aNanos, long bNanos) {
            return (aNanos != 0 && (bNanos == 0 || aNanos < bNanos)) ? aNanos : bNanos;
        }
    }
}