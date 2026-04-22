package leakcanary;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.lang.reflect.Proxy;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import leakcanary.internal.ObjectsKt;

/* compiled from: ActivityWatcher.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000'\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lleakcanary/ActivityWatcher;", "Lleakcanary/InstallableWatcher;", "application", "Landroid/app/Application;", "reachabilityWatcher", "Lleakcanary/ReachabilityWatcher;", "(Landroid/app/Application;Lleakcanary/ReachabilityWatcher;)V", "lifecycleCallbacks", "leakcanary/ActivityWatcher$lifecycleCallbacks$1", "Lleakcanary/ActivityWatcher$lifecycleCallbacks$1;", "install", "", "uninstall", "leakcanary-object-watcher-android-core_release"}, k = 1, mv = {1, 4, 1})
public final class ActivityWatcher implements InstallableWatcher {
    private final Application application;
    private final ActivityWatcher$lifecycleCallbacks$1 lifecycleCallbacks;
    private final ReachabilityWatcher reachabilityWatcher;

    /* JADX WARN: Type inference failed for: r0v2, types: [leakcanary.ActivityWatcher$lifecycleCallbacks$1] */
    public ActivityWatcher(Application application, ReachabilityWatcher reachabilityWatcher) {
        Intrinsics.checkParameterIsNotNull(application, "application");
        Intrinsics.checkParameterIsNotNull(reachabilityWatcher, "reachabilityWatcher");
        this.application = application;
        this.reachabilityWatcher = reachabilityWatcher;
        this.lifecycleCallbacks = new Application.ActivityLifecycleCallbacks() { // from class: leakcanary.ActivityWatcher$lifecycleCallbacks$1
            private final /* synthetic */ Application.ActivityLifecycleCallbacks $$delegate_0;

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity p0, Bundle bundle) {
                Intrinsics.checkParameterIsNotNull(p0, "p0");
                this.$$delegate_0.onActivityCreated(p0, bundle);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity p0) {
                Intrinsics.checkParameterIsNotNull(p0, "p0");
                this.$$delegate_0.onActivityPaused(p0);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity p0) {
                Intrinsics.checkParameterIsNotNull(p0, "p0");
                this.$$delegate_0.onActivityResumed(p0);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(Activity p0, Bundle p1) {
                Intrinsics.checkParameterIsNotNull(p0, "p0");
                Intrinsics.checkParameterIsNotNull(p1, "p1");
                this.$$delegate_0.onActivitySaveInstanceState(p0, p1);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity p0) {
                Intrinsics.checkParameterIsNotNull(p0, "p0");
                this.$$delegate_0.onActivityStarted(p0);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity p0) {
                Intrinsics.checkParameterIsNotNull(p0, "p0");
                this.$$delegate_0.onActivityStopped(p0);
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                Object newProxyInstance = Proxy.newProxyInstance(Application.ActivityLifecycleCallbacks.class.getClassLoader(), new Class[]{Application.ActivityLifecycleCallbacks.class}, ObjectsKt.access$getNO_OP_HANDLER$p());
                if (newProxyInstance == null) {
                    throw new TypeCastException("null cannot be cast to non-null type android.app.Application.ActivityLifecycleCallbacks");
                }
                this.$$delegate_0 = (Application.ActivityLifecycleCallbacks) newProxyInstance;
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                ReachabilityWatcher reachabilityWatcher2;
                Intrinsics.checkParameterIsNotNull(activity, "activity");
                reachabilityWatcher2 = ActivityWatcher.this.reachabilityWatcher;
                reachabilityWatcher2.expectWeaklyReachable(activity, activity.getClass().getName() + " received Activity#onDestroy() callback");
            }
        };
    }

    @Override // leakcanary.InstallableWatcher
    public void install() {
        this.application.registerActivityLifecycleCallbacks(this.lifecycleCallbacks);
    }

    @Override // leakcanary.InstallableWatcher
    public void uninstall() {
        this.application.unregisterActivityLifecycleCallbacks(this.lifecycleCallbacks);
    }
}