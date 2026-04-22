package leakcanary;

import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.os.Bundle;
import java.lang.reflect.Constructor;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import leakcanary.internal.AndroidOFragmentDestroyWatcher;
import leakcanary.internal.ObjectsKt;

/* compiled from: FragmentAndViewModelWatcher.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000?\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007*\u0001\r\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J.\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\t2\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\b\u0010\u0016\u001a\u00020\u000bH\u0016J\b\u0010\u0017\u001a\u00020\u000bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lleakcanary/FragmentAndViewModelWatcher;", "Lleakcanary/InstallableWatcher;", "application", "Landroid/app/Application;", "reachabilityWatcher", "Lleakcanary/ReachabilityWatcher;", "(Landroid/app/Application;Lleakcanary/ReachabilityWatcher;)V", "fragmentDestroyWatchers", "", "Lkotlin/Function1;", "Landroid/app/Activity;", "", "lifecycleCallbacks", "leakcanary/FragmentAndViewModelWatcher$lifecycleCallbacks$1", "Lleakcanary/FragmentAndViewModelWatcher$lifecycleCallbacks$1;", "classAvailable", "", "className", "", "getWatcherIfAvailable", "fragmentClassName", "watcherClassName", "install", "uninstall", "Companion", "leakcanary-object-watcher-android-core_release"}, k = 1, mv = {1, 4, 1})
public final class FragmentAndViewModelWatcher implements InstallableWatcher {
    private static final String ANDROIDX_FRAGMENT_CLASS_NAME = "androidx.fragment.app.Fragment";
    private static final String ANDROIDX_FRAGMENT_DESTROY_WATCHER_CLASS_NAME = "leakcanary.internal.AndroidXFragmentDestroyWatcher";
    private static final String ANDROID_SUPPORT_FRAGMENT_CLASS_NAME;
    private static final String ANDROID_SUPPORT_FRAGMENT_DESTROY_WATCHER_CLASS_NAME = "leakcanary.internal.AndroidSupportFragmentDestroyWatcher";
    public static final Companion Companion = new Companion(null);
    private final Application application;
    private final List<Function1<Activity, Unit>> fragmentDestroyWatchers;
    private final FragmentAndViewModelWatcher$lifecycleCallbacks$1 lifecycleCallbacks;
    private final ReachabilityWatcher reachabilityWatcher;

    /* JADX WARN: Type inference failed for: r0v4, types: [leakcanary.FragmentAndViewModelWatcher$lifecycleCallbacks$1] */
    public FragmentAndViewModelWatcher(Application application, ReachabilityWatcher reachabilityWatcher) {
        Intrinsics.checkParameterIsNotNull(application, "application");
        Intrinsics.checkParameterIsNotNull(reachabilityWatcher, "reachabilityWatcher");
        this.application = application;
        this.reachabilityWatcher = reachabilityWatcher;
        FragmentAndViewModelWatcher $this$run = this;
        List fragmentDestroyWatchers = new ArrayList();
        if (Build.VERSION.SDK_INT >= 26) {
            fragmentDestroyWatchers.add(new AndroidOFragmentDestroyWatcher($this$run.reachabilityWatcher));
        }
        Function1 it = $this$run.getWatcherIfAvailable(ANDROIDX_FRAGMENT_CLASS_NAME, ANDROIDX_FRAGMENT_DESTROY_WATCHER_CLASS_NAME, $this$run.reachabilityWatcher);
        if (it != null) {
            fragmentDestroyWatchers.add(it);
        }
        Function1 it2 = $this$run.getWatcherIfAvailable(ANDROID_SUPPORT_FRAGMENT_CLASS_NAME, ANDROID_SUPPORT_FRAGMENT_DESTROY_WATCHER_CLASS_NAME, $this$run.reachabilityWatcher);
        if (it2 != null) {
            fragmentDestroyWatchers.add(it2);
        }
        this.fragmentDestroyWatchers = fragmentDestroyWatchers;
        this.lifecycleCallbacks = new Application.ActivityLifecycleCallbacks() { // from class: leakcanary.FragmentAndViewModelWatcher$lifecycleCallbacks$1
            private final /* synthetic */ Application.ActivityLifecycleCallbacks $$delegate_0;

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity p0) {
                Intrinsics.checkParameterIsNotNull(p0, "p0");
                this.$$delegate_0.onActivityDestroyed(p0);
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
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
                List<Function1> list;
                Intrinsics.checkParameterIsNotNull(activity, "activity");
                list = FragmentAndViewModelWatcher.this.fragmentDestroyWatchers;
                for (Function1 watcher : list) {
                    watcher.invoke(activity);
                }
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

    private final Function1<Activity, Unit> getWatcherIfAvailable(String fragmentClassName, String watcherClassName, ReachabilityWatcher reachabilityWatcher) {
        if (classAvailable(fragmentClassName) && classAvailable(watcherClassName)) {
            Constructor watcherConstructor = Class.forName(watcherClassName).getDeclaredConstructor(ReachabilityWatcher.class);
            Object newInstance = watcherConstructor.newInstance(reachabilityWatcher);
            if (newInstance != null) {
                return (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(newInstance, 1);
            }
            throw new TypeCastException("null cannot be cast to non-null type (android.app.Activity) -> kotlin.Unit");
        }
        return null;
    }

    private final boolean classAvailable(String className) {
        try {
            Class.forName(className);
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    /* compiled from: FragmentAndViewModelWatcher.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0004X\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0007\u0010\u0002R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lleakcanary/FragmentAndViewModelWatcher$Companion;", "", "()V", "ANDROIDX_FRAGMENT_CLASS_NAME", "", "ANDROIDX_FRAGMENT_DESTROY_WATCHER_CLASS_NAME", "ANDROID_SUPPORT_FRAGMENT_CLASS_NAME", "getANDROID_SUPPORT_FRAGMENT_CLASS_NAME$annotations", "ANDROID_SUPPORT_FRAGMENT_DESTROY_WATCHER_CLASS_NAME", "leakcanary-object-watcher-android-core_release"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Companion {
        private static /* synthetic */ void getANDROID_SUPPORT_FRAGMENT_CLASS_NAME$annotations() {
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }

    static {
        String str = "android.support.v4.app.Fragment";
        Intrinsics.checkExpressionValueIsNotNull(str, "StringBuilder(\"android.\"…ent\")\n        .toString()");
        ANDROID_SUPPORT_FRAGMENT_CLASS_NAME = str;
    }
}