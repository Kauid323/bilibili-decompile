package io.reactivex.rxjava3.internal.schedulers;

import androidx.compose.animation.core.MutatorMutex$;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class SchedulerPoolFactory {
    public static final boolean PURGE_ENABLED;
    static final String PURGE_ENABLED_KEY = "rx3.purge-enabled";
    public static final int PURGE_PERIOD_SECONDS;
    static final String PURGE_PERIOD_SECONDS_KEY = "rx3.purge-period-seconds";
    static final AtomicReference<ScheduledExecutorService> PURGE_THREAD = new AtomicReference<>();
    static final Map<ScheduledThreadPoolExecutor, Object> POOLS = new ConcurrentHashMap();

    private SchedulerPoolFactory() {
        throw new IllegalStateException("No instances!");
    }

    static {
        SystemPropertyAccessor propertyAccessor = new SystemPropertyAccessor();
        PURGE_ENABLED = getBooleanProperty(true, PURGE_ENABLED_KEY, true, true, propertyAccessor);
        PURGE_PERIOD_SECONDS = getIntProperty(PURGE_ENABLED, PURGE_PERIOD_SECONDS_KEY, 1, 1, propertyAccessor);
        start();
    }

    public static void start() {
        tryStart(PURGE_ENABLED);
    }

    static void tryStart(boolean purgeEnabled) {
        if (!purgeEnabled) {
            return;
        }
        while (true) {
            ScheduledExecutorService curr = PURGE_THREAD.get();
            if (curr != null) {
                return;
            }
            ScheduledExecutorService next = Executors.newScheduledThreadPool(1, new RxThreadFactory("RxSchedulerPurge"));
            if (MutatorMutex$.ExternalSyntheticBackportWithForwarding0.m(PURGE_THREAD, curr, next)) {
                next.scheduleAtFixedRate(new ScheduledTask(), PURGE_PERIOD_SECONDS, PURGE_PERIOD_SECONDS, TimeUnit.SECONDS);
                return;
            }
            next.shutdownNow();
        }
    }

    public static void shutdown() {
        ScheduledExecutorService exec = PURGE_THREAD.getAndSet(null);
        if (exec != null) {
            exec.shutdownNow();
        }
        POOLS.clear();
    }

    static int getIntProperty(boolean enabled, String key, int defaultNotFound, int defaultNotEnabled, Function<String, String> propertyAccessor) {
        if (enabled) {
            try {
                String value = propertyAccessor.apply(key);
                if (value == null) {
                    return defaultNotFound;
                }
                return Integer.parseInt(value);
            } catch (Throwable ex) {
                Exceptions.throwIfFatal(ex);
                return defaultNotFound;
            }
        }
        return defaultNotEnabled;
    }

    static boolean getBooleanProperty(boolean enabled, String key, boolean defaultNotFound, boolean defaultNotEnabled, Function<String, String> propertyAccessor) {
        if (enabled) {
            try {
                String value = propertyAccessor.apply(key);
                if (value == null) {
                    return defaultNotFound;
                }
                return "true".equals(value);
            } catch (Throwable ex) {
                Exceptions.throwIfFatal(ex);
                return defaultNotFound;
            }
        }
        return defaultNotEnabled;
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class SystemPropertyAccessor implements Function<String, String> {
        SystemPropertyAccessor() {
        }

        @Override // io.reactivex.rxjava3.functions.Function
        public String apply(String t) {
            return System.getProperty(t);
        }
    }

    public static ScheduledExecutorService create(ThreadFactory factory) {
        ScheduledExecutorService exec = Executors.newScheduledThreadPool(1, factory);
        tryPutIntoPool(PURGE_ENABLED, exec);
        return exec;
    }

    static void tryPutIntoPool(boolean purgeEnabled, ScheduledExecutorService exec) {
        if (purgeEnabled && (exec instanceof ScheduledThreadPoolExecutor)) {
            ScheduledThreadPoolExecutor e = (ScheduledThreadPoolExecutor) exec;
            POOLS.put(e, exec);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class ScheduledTask implements Runnable {
        ScheduledTask() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = new ArrayList(SchedulerPoolFactory.POOLS.keySet()).iterator();
            while (it.hasNext()) {
                ScheduledThreadPoolExecutor e = (ScheduledThreadPoolExecutor) it.next();
                if (e.isShutdown()) {
                    SchedulerPoolFactory.POOLS.remove(e);
                } else {
                    e.purge();
                }
            }
        }
    }
}