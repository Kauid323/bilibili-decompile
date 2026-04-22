package leakcanary.internal;

import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import java.lang.reflect.Proxy;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VisibilityTracker.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\u0010\u0007J\u001f\u0010\r\u001a\u00020\u00062\b\b\u0001\u0010\u000e\u001a\u00020\u000f2\n\b\u0001\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0096\u0001J\u0013\u0010\u0012\u001a\u00020\u00062\b\b\u0001\u0010\u000e\u001a\u00020\u000fH\u0096\u0001J\u0013\u0010\u0013\u001a\u00020\u00062\b\b\u0001\u0010\u000e\u001a\u00020\u000fH\u0096\u0001J\u0013\u0010\u0014\u001a\u00020\u00062\b\b\u0001\u0010\u000e\u001a\u00020\u000fH\u0096\u0001J\u001d\u0010\u0015\u001a\u00020\u00062\b\b\u0001\u0010\u000e\u001a\u00020\u000f2\b\b\u0001\u0010\u0010\u001a\u00020\u0011H\u0096\u0001J\u0010\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u000fH\u0016J\u0010\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u000fH\u0016J\u0018\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u0006H\u0002R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lleakcanary/internal/VisibilityTracker;", "Landroid/app/Application$ActivityLifecycleCallbacks;", "Landroid/content/BroadcastReceiver;", "listener", "Lkotlin/Function1;", "", "", "(Lkotlin/jvm/functions/Function1;)V", "hasVisibleActivities", "lastUpdate", "screenOn", "startedActivityCount", "", "onActivityCreated", "p0", "Landroid/app/Activity;", "p1", "Landroid/os/Bundle;", "onActivityDestroyed", "onActivityPaused", "onActivityResumed", "onActivitySaveInstanceState", "onActivityStarted", "activity", "onActivityStopped", "onReceive", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "updateVisible", "leakcanary-android-core_release"}, k = 1, mv = {1, 4, 1})
public final class VisibilityTracker extends BroadcastReceiver implements Application.ActivityLifecycleCallbacks {
    private final /* synthetic */ Application.ActivityLifecycleCallbacks $$delegate_0;
    private boolean hasVisibleActivities;
    private boolean lastUpdate;
    private final Function1<Boolean, Unit> listener;
    private boolean screenOn;
    private int startedActivityCount;

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity p0, Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(p0, "p0");
        this.$$delegate_0.onActivityCreated(p0, bundle);
    }

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

    /* JADX WARN: Multi-variable type inference failed */
    public VisibilityTracker(Function1<? super Boolean, Unit> listener) {
        Intrinsics.checkParameterIsNotNull(listener, "listener");
        Object newProxyInstance = Proxy.newProxyInstance(Application.ActivityLifecycleCallbacks.class.getClassLoader(), new Class[]{Application.ActivityLifecycleCallbacks.class}, ObjectsKt.NO_OP_HANDLER);
        if (newProxyInstance != null) {
            this.$$delegate_0 = (Application.ActivityLifecycleCallbacks) newProxyInstance;
            this.listener = listener;
            this.screenOn = true;
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.app.Application.ActivityLifecycleCallbacks");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        this.startedActivityCount++;
        if (!this.hasVisibleActivities && this.startedActivityCount == 1) {
            this.hasVisibleActivities = true;
            updateVisible();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        if (this.startedActivityCount > 0) {
            this.startedActivityCount--;
        }
        if (this.hasVisibleActivities && this.startedActivityCount == 0 && !activity.isChangingConfigurations()) {
            this.hasVisibleActivities = false;
            updateVisible();
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(intent, "intent");
        this.screenOn = !Intrinsics.areEqual(intent.getAction(), "android.intent.action.SCREEN_OFF");
        updateVisible();
    }

    private final void updateVisible() {
        boolean visible = this.screenOn && this.hasVisibleActivities;
        if (visible != this.lastUpdate) {
            this.lastUpdate = visible;
            this.listener.invoke(Boolean.valueOf(visible));
        }
    }
}