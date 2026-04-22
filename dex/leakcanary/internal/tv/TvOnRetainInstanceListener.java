package leakcanary.internal.tv;

import android.app.Activity;
import android.app.Application;
import com.squareup.leakcanary.core.R;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import leakcanary.LeakCanary;
import leakcanary.internal.HandlersKt;
import leakcanary.internal.InternalLeakCanary;
import leakcanary.internal.OnRetainInstanceListener;
import leakcanary.internal.RetainInstanceEvent;
import shark.SharkLog;

/* compiled from: TvOnRetainInstanceListener.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lleakcanary/internal/tv/TvOnRetainInstanceListener;", "Lleakcanary/internal/OnRetainInstanceListener;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "onEvent", "", "event", "Lleakcanary/internal/RetainInstanceEvent;", "leakcanary-android-core_release"}, k = 1, mv = {1, 4, 1})
public final class TvOnRetainInstanceListener implements OnRetainInstanceListener {
    private final Application application;

    public TvOnRetainInstanceListener(Application application) {
        Intrinsics.checkParameterIsNotNull(application, "application");
        this.application = application;
    }

    @Override // leakcanary.internal.OnRetainInstanceListener
    public void onEvent(RetainInstanceEvent event) {
        final String message;
        Intrinsics.checkParameterIsNotNull(event, "event");
        if (Intrinsics.areEqual(event, RetainInstanceEvent.NoMoreObjects.INSTANCE)) {
            message = this.application.getString(R.string.leak_canary_notification_no_retained_object_title);
        } else if (event instanceof RetainInstanceEvent.CountChanged.BelowThreshold) {
            message = this.application.getString(R.string.leak_canary_tv_toast_retained_objects, new Object[]{Integer.valueOf(((RetainInstanceEvent.CountChanged.BelowThreshold) event).getRetainedCount()), Integer.valueOf(LeakCanary.getConfig().getRetainedVisibleThreshold())});
        } else if (event instanceof RetainInstanceEvent.CountChanged.DumpingDisabled) {
            message = ((RetainInstanceEvent.CountChanged.DumpingDisabled) event).getReason();
        } else if (event instanceof RetainInstanceEvent.CountChanged.DumpHappenedRecently) {
            message = this.application.getString(R.string.leak_canary_notification_retained_dump_wait);
        } else {
            throw new NoWhenBranchMatchedException();
        }
        Intrinsics.checkExpressionValueIsNotNull(message, "when (event) {\n      NoM…_dump_wait)\n      }\n    }");
        SharkLog this_$iv = SharkLog.INSTANCE;
        SharkLog.Logger logger$iv = this_$iv.getLogger();
        if (logger$iv != null) {
            logger$iv.d(message);
        }
        HandlersKt.getMainHandler().post(new Runnable() { // from class: leakcanary.internal.tv.TvOnRetainInstanceListener$onEvent$2
            @Override // java.lang.Runnable
            public final void run() {
                Activity resumedActivity = InternalLeakCanary.INSTANCE.getResumedActivity();
                if (resumedActivity == null) {
                    return;
                }
                TvToast.INSTANCE.makeText(resumedActivity, message).show();
            }
        });
    }
}