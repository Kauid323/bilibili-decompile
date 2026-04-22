package rx.android.schedulers;

import android.os.Looper;
import androidx.compose.animation.core.MutatorMutex$;
import java.util.concurrent.atomic.AtomicReference;
import rx.Scheduler;
import rx.android.plugins.RxAndroidPlugins;
import rx.android.plugins.RxAndroidSchedulersHook;

public final class AndroidSchedulers {
    private static final AtomicReference<AndroidSchedulers> INSTANCE = new AtomicReference<>();
    private final Scheduler mainThreadScheduler;

    private static AndroidSchedulers getInstance() {
        AndroidSchedulers current;
        do {
            AndroidSchedulers current2 = INSTANCE.get();
            if (current2 != null) {
                return current2;
            }
            current = new AndroidSchedulers();
        } while (!MutatorMutex$.ExternalSyntheticBackportWithForwarding0.m(INSTANCE, (Object) null, current));
        return current;
    }

    private AndroidSchedulers() {
        RxAndroidSchedulersHook hook = RxAndroidPlugins.getInstance().getSchedulersHook();
        Scheduler main = hook.getMainThreadScheduler();
        if (main != null) {
            this.mainThreadScheduler = main;
        } else {
            this.mainThreadScheduler = new LooperScheduler(Looper.getMainLooper());
        }
    }

    public static Scheduler mainThread() {
        return getInstance().mainThreadScheduler;
    }

    public static Scheduler from(Looper looper) {
        if (looper == null) {
            throw new NullPointerException("looper == null");
        }
        return new LooperScheduler(looper);
    }

    public static void reset() {
        INSTANCE.set(null);
    }
}