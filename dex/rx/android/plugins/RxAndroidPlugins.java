package rx.android.plugins;

import androidx.compose.animation.core.MutatorMutex$;
import java.util.concurrent.atomic.AtomicReference;

public final class RxAndroidPlugins {
    private static final RxAndroidPlugins INSTANCE = new RxAndroidPlugins();
    private final AtomicReference<RxAndroidSchedulersHook> schedulersHook = new AtomicReference<>();

    public static RxAndroidPlugins getInstance() {
        return INSTANCE;
    }

    RxAndroidPlugins() {
    }

    public void reset() {
        this.schedulersHook.set(null);
    }

    public RxAndroidSchedulersHook getSchedulersHook() {
        if (this.schedulersHook.get() == null) {
            MutatorMutex$.ExternalSyntheticBackportWithForwarding0.m(this.schedulersHook, (Object) null, RxAndroidSchedulersHook.getDefaultInstance());
        }
        return this.schedulersHook.get();
    }

    public void registerSchedulersHook(RxAndroidSchedulersHook impl) {
        if (!MutatorMutex$.ExternalSyntheticBackportWithForwarding0.m(this.schedulersHook, (Object) null, impl)) {
            throw new IllegalStateException("Another strategy was already registered: " + this.schedulersHook.get());
        }
    }
}