package io.grpc.internal;

import com.google.common.base.Preconditions;
import java.util.ArrayDeque;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;

class SerializeReentrantCallsDirectExecutor implements Executor {
    private static final Logger log = Logger.getLogger(SerializeReentrantCallsDirectExecutor.class.getName());
    private boolean executing;
    private ArrayDeque<Runnable> taskQueue;

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0037, code lost:
        if (r6.taskQueue == null) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:?, code lost:
        return;
     */
    @Override // java.util.concurrent.Executor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void execute(Runnable task) {
        Preconditions.checkNotNull(task, "'task' must not be null.");
        if (!this.executing) {
            this.executing = true;
            try {
                task.run();
            } catch (Throwable t) {
                try {
                    log.log(Level.SEVERE, "Exception while executing runnable " + task, t);
                } finally {
                    if (this.taskQueue != null) {
                        completeQueuedTasks();
                    }
                    this.executing = false;
                }
            }
        } else {
            enqueue(task);
        }
    }

    private void completeQueuedTasks() {
        while (true) {
            Runnable task = this.taskQueue.poll();
            if (task != null) {
                try {
                    task.run();
                } catch (Throwable t) {
                    log.log(Level.SEVERE, "Exception while executing runnable " + task, t);
                }
            } else {
                return;
            }
        }
    }

    private void enqueue(Runnable r) {
        if (this.taskQueue == null) {
            this.taskQueue = new ArrayDeque<>(4);
        }
        this.taskQueue.add(r);
    }
}