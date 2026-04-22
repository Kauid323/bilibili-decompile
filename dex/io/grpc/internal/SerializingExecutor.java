package io.grpc.internal;

import com.google.common.base.Preconditions;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

public final class SerializingExecutor implements Executor, Runnable {
    private static final int RUNNING = -1;
    private static final int STOPPED = 0;
    private final Executor executor;
    private final Queue<Runnable> runQueue = new ConcurrentLinkedQueue();
    private volatile int runState = 0;
    private static final Logger log = Logger.getLogger(SerializingExecutor.class.getName());
    private static final AtomicHelper atomicHelper = getAtomicHelper();

    private static AtomicHelper getAtomicHelper() {
        try {
            AtomicHelper helper = new FieldUpdaterAtomicHelper(AtomicIntegerFieldUpdater.newUpdater(SerializingExecutor.class, "runState"));
            return helper;
        } catch (Throwable t) {
            log.log(Level.SEVERE, "FieldUpdaterAtomicHelper failed", t);
            AtomicHelper helper2 = new SynchronizedAtomicHelper();
            return helper2;
        }
    }

    public SerializingExecutor(Executor executor) {
        Preconditions.checkNotNull(executor, "'executor' must not be null.");
        this.executor = executor;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.concurrent.Executor
    public void execute(Runnable r) {
        this.runQueue.add(Preconditions.checkNotNull(r, "'r' must not be null."));
        schedule(r);
    }

    private void schedule(@Nullable Runnable removable) {
        if (atomicHelper.runStateCompareAndSet(this, 0, -1)) {
            boolean success = false;
            try {
                this.executor.execute(this);
                success = true;
            } finally {
                if (!success) {
                    if (removable != null) {
                        this.runQueue.remove(removable);
                    }
                    atomicHelper.runStateSet(this, 0);
                }
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        while (true) {
            try {
                Runnable r = this.runQueue.poll();
                if (r == null) {
                    break;
                }
                try {
                    r.run();
                } catch (RuntimeException e2) {
                    log.log(Level.SEVERE, "Exception while executing runnable " + r, (Throwable) e2);
                }
            } catch (Throwable th) {
                atomicHelper.runStateSet(this, 0);
                throw th;
            }
        }
        atomicHelper.runStateSet(this, 0);
        if (!this.runQueue.isEmpty()) {
            schedule(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static abstract class AtomicHelper {
        public abstract boolean runStateCompareAndSet(SerializingExecutor serializingExecutor, int i2, int i3);

        public abstract void runStateSet(SerializingExecutor serializingExecutor, int i2);

        private AtomicHelper() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class FieldUpdaterAtomicHelper extends AtomicHelper {
        private final AtomicIntegerFieldUpdater<SerializingExecutor> runStateUpdater;

        private FieldUpdaterAtomicHelper(AtomicIntegerFieldUpdater<SerializingExecutor> runStateUpdater) {
            super();
            this.runStateUpdater = runStateUpdater;
        }

        @Override // io.grpc.internal.SerializingExecutor.AtomicHelper
        public boolean runStateCompareAndSet(SerializingExecutor obj, int expect, int update) {
            return this.runStateUpdater.compareAndSet(obj, expect, update);
        }

        @Override // io.grpc.internal.SerializingExecutor.AtomicHelper
        public void runStateSet(SerializingExecutor obj, int newValue) {
            this.runStateUpdater.set(obj, newValue);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class SynchronizedAtomicHelper extends AtomicHelper {
        private SynchronizedAtomicHelper() {
            super();
        }

        @Override // io.grpc.internal.SerializingExecutor.AtomicHelper
        public boolean runStateCompareAndSet(SerializingExecutor obj, int expect, int update) {
            synchronized (obj) {
                if (obj.runState == expect) {
                    obj.runState = update;
                    return true;
                }
                return false;
            }
        }

        @Override // io.grpc.internal.SerializingExecutor.AtomicHelper
        public void runStateSet(SerializingExecutor obj, int newValue) {
            synchronized (obj) {
                obj.runState = newValue;
            }
        }
    }
}