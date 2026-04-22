package io.grpc.internal;

import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class LogExceptionRunnable implements Runnable {
    private static final Logger log = Logger.getLogger(LogExceptionRunnable.class.getName());
    private final Runnable task;

    public LogExceptionRunnable(Runnable task) {
        this.task = (Runnable) Preconditions.checkNotNull(task, "task");
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.task.run();
        } catch (Throwable t) {
            log.log(Level.SEVERE, "Exception while executing runnable " + this.task, t);
            Throwables.throwIfUnchecked(t);
            throw new AssertionError(t);
        }
    }

    public String toString() {
        return "LogExceptionRunnable(" + this.task + ")";
    }
}