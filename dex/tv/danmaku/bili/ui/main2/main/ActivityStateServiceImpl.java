package tv.danmaku.bili.ui.main2.main;

import android.app.Activity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import com.bilibili.homepage.ActivityStateObserver;
import com.bilibili.homepage.ActivityStateService;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.proc.ActivityCallBack;
import tv.danmaku.bili.ui.audio.AudioIntentHelper;

/* compiled from: ActivityStateServiceImpl.kt */
@Singleton
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006H\u0016J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006H\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Ltv/danmaku/bili/ui/main2/main/ActivityStateServiceImpl;", "Lcom/bilibili/homepage/ActivityStateService;", "<init>", "()V", "mObservers", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/bilibili/homepage/ActivityStateObserver;", "registerActivityStateObserver", "", "observer", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "unregisterActivityStateObserver", "activityStateCallback", "Ltv/danmaku/bili/proc/ActivityCallBack$ActivityStateCallback;", "getActivityStateCallback", "()Ltv/danmaku/bili/proc/ActivityCallBack$ActivityStateCallback;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class ActivityStateServiceImpl implements ActivityStateService {
    public static final int $stable = 8;
    private final CopyOnWriteArrayList<ActivityStateObserver> mObservers = new CopyOnWriteArrayList<>();
    private final ActivityCallBack.ActivityStateCallback activityStateCallback = new ActivityCallBack.ActivityStateCallback() { // from class: tv.danmaku.bili.ui.main2.main.ActivityStateServiceImpl$activityStateCallback$1
        @Override // tv.danmaku.bili.proc.ActivityCallBack.ActivityStateCallback
        public void onVisibleCountChanged(Activity activity, int lastVisibleCount, int currentVisibleCount) {
            Iterable iterable;
            Intrinsics.checkNotNullParameter(activity, AudioIntentHelper.FROM_ACTIVITY);
            iterable = ActivityStateServiceImpl.this.mObservers;
            Iterable $this$forEach$iv = iterable;
            for (Object element$iv : $this$forEach$iv) {
                ActivityStateObserver it = (ActivityStateObserver) element$iv;
                it.onVisibleCountChanged(activity, lastVisibleCount, currentVisibleCount);
            }
        }

        @Override // tv.danmaku.bili.proc.ActivityCallBack.ActivityStateCallback
        public void onForegroundActivitiesChanged(Activity activity, int lastForegroundCount, int currentForegroundCount) {
            Iterable iterable;
            Intrinsics.checkNotNullParameter(activity, AudioIntentHelper.FROM_ACTIVITY);
            iterable = ActivityStateServiceImpl.this.mObservers;
            Iterable $this$forEach$iv = iterable;
            for (Object element$iv : $this$forEach$iv) {
                ActivityStateObserver it = (ActivityStateObserver) element$iv;
                it.onForegroundActivitiesChanged(activity, lastForegroundCount, currentForegroundCount);
            }
        }
    };

    public void registerActivityStateObserver(ActivityStateObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.mObservers.add(observer);
    }

    public void registerActivityStateObserver(final ActivityStateObserver observer, final Lifecycle lifecycle) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        Intrinsics.checkNotNullParameter(lifecycle, "lifecycle");
        this.mObservers.add(observer);
        lifecycle.addObserver(new LifecycleEventObserver() { // from class: tv.danmaku.bili.ui.main2.main.ActivityStateServiceImpl$registerActivityStateObserver$1
            public void onStateChanged(LifecycleOwner source, Lifecycle.Event event) {
                CopyOnWriteArrayList copyOnWriteArrayList;
                Intrinsics.checkNotNullParameter(source, "source");
                Intrinsics.checkNotNullParameter(event, "event");
                if (event == Lifecycle.Event.ON_DESTROY) {
                    lifecycle.removeObserver((LifecycleObserver) this);
                    copyOnWriteArrayList = this.mObservers;
                    copyOnWriteArrayList.remove(observer);
                }
            }
        });
    }

    public void unregisterActivityStateObserver(ActivityStateObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.mObservers.remove(observer);
    }

    public final ActivityCallBack.ActivityStateCallback getActivityStateCallback() {
        return this.activityStateCallback;
    }
}