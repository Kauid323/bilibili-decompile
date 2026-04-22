package leakcanary.internal;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VisibilityTracker.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\u001a \u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H\u0000¨\u0006\u0006"}, d2 = {"registerVisibilityListener", "", "Landroid/app/Application;", "listener", "Lkotlin/Function1;", "", "leakcanary-android-core_release"}, k = 2, mv = {1, 4, 1})
public final class VisibilityTrackerKt {
    private static Intent __Ghost$Insertion$com_bilibili_infra_base_aop_RegisterReceiverHook_hookRegisterReceiver(Object ctx, BroadcastReceiver receiver, IntentFilter filter) {
        if (Build.VERSION.SDK_INT >= 34) {
            return ((Context) ctx).registerReceiver(receiver, filter, 4);
        }
        return ((Application) ctx).registerReceiver(receiver, filter);
    }

    public static final void registerVisibilityListener(Application registerVisibilityListener, Function1<? super Boolean, Unit> listener) {
        Intrinsics.checkParameterIsNotNull(registerVisibilityListener, "$this$registerVisibilityListener");
        Intrinsics.checkParameterIsNotNull(listener, "listener");
        VisibilityTracker visibilityTracker = new VisibilityTracker(listener);
        registerVisibilityListener.registerActivityLifecycleCallbacks(visibilityTracker);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        if (Build.VERSION.SDK_INT >= 33) {
            registerVisibilityListener.registerReceiver(visibilityTracker, intentFilter, 2);
        } else {
            __Ghost$Insertion$com_bilibili_infra_base_aop_RegisterReceiverHook_hookRegisterReceiver(registerVisibilityListener, visibilityTracker, intentFilter);
        }
    }
}