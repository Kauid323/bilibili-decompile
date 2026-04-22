package rx.internal.schedulers;

import androidx.compose.animation.core.MutatorMutex$;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicReference;

public final class GenericScheduledExecutorService implements SchedulerLifecycle {
    public static final GenericScheduledExecutorService INSTANCE;
    private static final ScheduledExecutorService[] NONE = new ScheduledExecutorService[0];
    private static final ScheduledExecutorService SHUTDOWN = Executors.newScheduledThreadPool(0);
    private static int roundRobin;
    private final AtomicReference<ScheduledExecutorService[]> executor = new AtomicReference<>(NONE);

    static {
        SHUTDOWN.shutdown();
        INSTANCE = new GenericScheduledExecutorService();
    }

    private GenericScheduledExecutorService() {
        start();
    }

    @Override // rx.internal.schedulers.SchedulerLifecycle
    public void start() {
        int count = Runtime.getRuntime().availableProcessors();
        if (count > 4) {
            count /= 2;
        }
        if (count > 8) {
            count = 8;
        }
        ScheduledExecutorService[] execs = new ScheduledExecutorService[count];
        for (int i = 0; i < count; i++) {
            execs[i] = GenericScheduledExecutorServiceFactory.create();
        }
        if (MutatorMutex$.ExternalSyntheticBackportWithForwarding0.m(this.executor, NONE, execs)) {
            for (ScheduledExecutorService exec : execs) {
                if (!NewThreadWorker.tryEnableCancelPolicy(exec) && (exec instanceof ScheduledThreadPoolExecutor)) {
                    NewThreadWorker.registerExecutor((ScheduledThreadPoolExecutor) exec);
                }
            }
            return;
        }
        for (ScheduledExecutorService exec2 : execs) {
            exec2.shutdownNow();
        }
    }

    @Override // rx.internal.schedulers.SchedulerLifecycle
    public void shutdown() {
        ScheduledExecutorService[] execs;
        do {
            execs = this.executor.get();
            if (execs == NONE) {
                return;
            }
        } while (!MutatorMutex$.ExternalSyntheticBackportWithForwarding0.m(this.executor, execs, NONE));
        for (ScheduledExecutorService exec : execs) {
            NewThreadWorker.deregisterExecutor(exec);
            exec.shutdownNow();
        }
    }

    public static ScheduledExecutorService getInstance() {
        ScheduledExecutorService[] execs = INSTANCE.executor.get();
        if (execs == NONE) {
            return SHUTDOWN;
        }
        int r = roundRobin + 1;
        if (r >= execs.length) {
            r = 0;
        }
        roundRobin = r;
        return execs[r];
    }
}