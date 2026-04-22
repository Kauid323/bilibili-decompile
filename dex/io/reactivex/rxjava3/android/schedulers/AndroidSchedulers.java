package io.reactivex.rxjava3.android.schedulers;

import android.os.Handler;
import android.os.Looper;
import io.reactivex.rxjava3.android.plugins.RxAndroidPlugins;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Scheduler;
import java.util.concurrent.Callable;

public final class AndroidSchedulers {
    private static final Scheduler MAIN_THREAD = RxAndroidPlugins.initMainThreadScheduler(new Callable() { // from class: io.reactivex.rxjava3.android.schedulers.AndroidSchedulers$$ExternalSyntheticLambda0
        @Override // java.util.concurrent.Callable
        public final Object call() {
            Scheduler scheduler;
            scheduler = AndroidSchedulers.MainHolder.DEFAULT;
            return scheduler;
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/20260223060940f7e941c2-05a4-41f3-b15b-150477b09f88/20260223060940f7e941c2-05a4-41f3-b15b-150477b09f88.dex */
    public static final class MainHolder {
        static final Scheduler DEFAULT = new HandlerScheduler(new Handler(Looper.getMainLooper()), true);

        private MainHolder() {
        }
    }

    public static Scheduler mainThread() {
        return RxAndroidPlugins.onMainThreadScheduler(MAIN_THREAD);
    }

    public static Scheduler from(Looper looper) {
        return from(looper, true);
    }

    public static Scheduler from(Looper looper, boolean async) {
        if (looper == null) {
            throw new NullPointerException("looper == null");
        }
        return new HandlerScheduler(new Handler(looper), async);
    }

    private AndroidSchedulers() {
        throw new AssertionError("No instances.");
    }
}