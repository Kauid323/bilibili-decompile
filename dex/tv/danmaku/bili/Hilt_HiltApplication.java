package tv.danmaku.bili;

import com.bilibili.gripper.BiliApp;
import dagger.hilt.android.internal.managers.ApplicationComponentManager;
import dagger.hilt.android.internal.managers.ComponentSupplier;
import dagger.hilt.android.internal.modules.ApplicationContextModule;
import dagger.hilt.internal.GeneratedComponentManagerHolder;
import dagger.hilt.internal.UnsafeCasts;

abstract class Hilt_HiltApplication extends BiliApp implements GeneratedComponentManagerHolder {
    private boolean injected = false;
    private final ApplicationComponentManager componentManager = new ApplicationComponentManager(new ComponentSupplier() { // from class: tv.danmaku.bili.Hilt_HiltApplication.1
        public Object get() {
            return DaggerHiltApplication_HiltComponents_SingletonC.builder().applicationContextModule(new ApplicationContextModule(Hilt_HiltApplication.this)).build();
        }
    });

    /* renamed from: componentManager */
    public final ApplicationComponentManager m619componentManager() {
        return this.componentManager;
    }

    public final Object generatedComponent() {
        return m619componentManager().generatedComponent();
    }

    public void onCreate() {
        hiltInternalInject();
        super.onCreate();
    }

    protected void hiltInternalInject() {
        if (!this.injected) {
            this.injected = true;
            ((HiltApplication_GeneratedInjector) generatedComponent()).injectHiltApplication((HiltApplication) UnsafeCasts.unsafeCast(this));
        }
    }
}