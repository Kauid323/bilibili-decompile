package rx.schedulers;

import androidx.compose.animation.core.MutatorMutex$;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
import rx.Scheduler;
import rx.internal.schedulers.ExecutorScheduler;
import rx.internal.schedulers.GenericScheduledExecutorService;
import rx.internal.schedulers.SchedulerLifecycle;
import rx.plugins.RxJavaHooks;
import rx.plugins.RxJavaPlugins;
import rx.plugins.RxJavaSchedulersHook;

public final class Schedulers {
    private static final AtomicReference<Schedulers> INSTANCE = new AtomicReference<>();
    private final Scheduler computationScheduler;
    private final Scheduler ioScheduler;
    private final Scheduler newThreadScheduler;

    private static Schedulers getInstance() {
        while (true) {
            Schedulers current = INSTANCE.get();
            if (current != null) {
                return current;
            }
            Schedulers current2 = new Schedulers();
            if (MutatorMutex$.ExternalSyntheticBackportWithForwarding0.m(INSTANCE, (Object) null, current2)) {
                return current2;
            }
            current2.shutdownInstance();
        }
    }

    private Schedulers() {
        RxJavaSchedulersHook hook = RxJavaPlugins.getInstance().getSchedulersHook();
        Scheduler c = hook.getComputationScheduler();
        if (c != null) {
            this.computationScheduler = c;
        } else {
            this.computationScheduler = RxJavaSchedulersHook.createComputationScheduler();
        }
        Scheduler io = hook.getIOScheduler();
        if (io != null) {
            this.ioScheduler = io;
        } else {
            this.ioScheduler = RxJavaSchedulersHook.createIoScheduler();
        }
        Scheduler nt = hook.getNewThreadScheduler();
        if (nt != null) {
            this.newThreadScheduler = nt;
        } else {
            this.newThreadScheduler = RxJavaSchedulersHook.createNewThreadScheduler();
        }
    }

    public static Scheduler immediate() {
        return rx.internal.schedulers.ImmediateScheduler.INSTANCE;
    }

    public static Scheduler trampoline() {
        return rx.internal.schedulers.TrampolineScheduler.INSTANCE;
    }

    public static Scheduler newThread() {
        return RxJavaHooks.onNewThreadScheduler(getInstance().newThreadScheduler);
    }

    public static Scheduler computation() {
        return RxJavaHooks.onComputationScheduler(getInstance().computationScheduler);
    }

    public static Scheduler io() {
        return RxJavaHooks.onIOScheduler(getInstance().ioScheduler);
    }

    public static TestScheduler test() {
        return new TestScheduler();
    }

    public static Scheduler from(Executor executor) {
        return new ExecutorScheduler(executor);
    }

    public static void reset() {
        Schedulers s = INSTANCE.getAndSet(null);
        if (s != null) {
            s.shutdownInstance();
        }
    }

    public static void start() {
        Schedulers s = getInstance();
        s.startInstance();
        synchronized (s) {
            GenericScheduledExecutorService.INSTANCE.start();
        }
    }

    public static void shutdown() {
        Schedulers s = getInstance();
        s.shutdownInstance();
        synchronized (s) {
            GenericScheduledExecutorService.INSTANCE.shutdown();
        }
    }

    synchronized void startInstance() {
        if (this.computationScheduler instanceof SchedulerLifecycle) {
            this.computationScheduler.start();
        }
        if (this.ioScheduler instanceof SchedulerLifecycle) {
            this.ioScheduler.start();
        }
        if (this.newThreadScheduler instanceof SchedulerLifecycle) {
            this.newThreadScheduler.start();
        }
    }

    synchronized void shutdownInstance() {
        if (this.computationScheduler instanceof SchedulerLifecycle) {
            this.computationScheduler.shutdown();
        }
        if (this.ioScheduler instanceof SchedulerLifecycle) {
            this.ioScheduler.shutdown();
        }
        if (this.newThreadScheduler instanceof SchedulerLifecycle) {
            this.newThreadScheduler.shutdown();
        }
    }
}