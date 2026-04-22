package tv.danmaku.bili.videopage.common.segment;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.bilibili.droid.thread.HandlerThreads;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.videopage.common.helper.HostHelper;
import tv.danmaku.bili.videopage.foundation.IHost;
import tv.danmaku.bili.videopage.foundation.ISegment;
import tv.danmaku.bili.videopage.foundation.ParamsParser;
import tv.danmaku.bili.videopage.foundation.UISegment;
import tv.danmaku.bili.videopage.foundation.event.ActivityLifecycleStateEventObserver;
import tv.danmaku.bili.videopage.foundation.event.ILifecycleStateEventDispatcher;
import tv.danmaku.bili.videopage.foundation.event.ILifecycleStateEventObserver;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: ActivityEventDispatcher.kt */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u00020\u0005B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\u0018\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0004H\u0016J\b\u0010\u0016\u001a\u00020\u0012H\u0016J\u0010\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0012H\u0016J\u0012\u0010\u001b\u001a\u00020\u00122\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u0012H\u0016J\b\u0010\u001f\u001a\u00020\u0012H\u0016J\b\u0010 \u001a\u00020\u0012H\u0016J\b\u0010!\u001a\u00020\u0012H\u0016J\b\u0010\"\u001a\u00020\u0012H\u0016J\u0010\u0010#\u001a\u00020\u00122\u0006\u0010$\u001a\u00020%H\u0016J\u0010\u0010&\u001a\u00020\u00122\u0006\u0010'\u001a\u00020\u0010H\u0016J\u0010\u0010(\u001a\u00020\u00122\u0006\u0010)\u001a\u00020*H\u0016J\u0010\u0010+\u001a\u00020\u00122\u0006\u0010)\u001a\u00020*H\u0016J\u000e\u0010,\u001a\u00020\u00122\u0006\u0010-\u001a\u00020\u0010J\u0010\u0010.\u001a\u00020\u00102\b\u0010/\u001a\u0004\u0018\u000100R\u000e\u0010\b\u001a\u00020\u0003X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Ltv/danmaku/bili/videopage/common/segment/ActivityEventDispatcher;", "Landroidx/fragment/app/Fragment;", "Ltv/danmaku/bili/videopage/foundation/UISegment;", "Ltv/danmaku/bili/videopage/foundation/IHost;", "Ltv/danmaku/bili/videopage/foundation/ParamsParser;", "Ltv/danmaku/bili/videopage/foundation/event/ILifecycleStateEventDispatcher;", "<init>", "()V", "mHost", "mActivityEventObservers", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Ltv/danmaku/bili/videopage/foundation/event/ActivityLifecycleStateEventObserver;", "mPendingStateDispatchRunnable", "Ljava/util/LinkedList;", "Ljava/lang/Runnable;", "mIsRunningDispatchRunnable", "", "scheduleRunPendingRunnable", "", "onAttach", "host", "paramsParser", "onDetachView", "onAttachView", "container", "Landroid/view/ViewGroup;", "onDetach", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "onResume", "onPause", "onStop", "onDestroy", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onMultiWindowModeChanged", "isInMultiWindowMode", "addEventObserver", "observer", "Ltv/danmaku/bili/videopage/foundation/event/ILifecycleStateEventObserver;", "removeEventObserver", "performWindowFocusChanged", "hasFocus", "dispatchKeyEvent", "event", "Landroid/view/KeyEvent;", "videopagecommon_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class ActivityEventDispatcher extends Fragment implements UISegment<IHost, ParamsParser>, ILifecycleStateEventDispatcher {
    private IHost mHost;
    private boolean mIsRunningDispatchRunnable;
    private final CopyOnWriteArrayList<ActivityLifecycleStateEventObserver> mActivityEventObservers = new CopyOnWriteArrayList<>();
    private final LinkedList<Runnable> mPendingStateDispatchRunnable = new LinkedList<>();

    @Override // tv.danmaku.bili.videopage.foundation.ISegment
    public /* synthetic */ void onBindDependency(ISegment iSegment) {
        Intrinsics.checkNotNullParameter(iSegment, "segment");
    }

    private final void scheduleRunPendingRunnable() {
        if (this.mIsRunningDispatchRunnable) {
            return;
        }
        this.mIsRunningDispatchRunnable = true;
        HandlerThreads.post(0, new Runnable() { // from class: tv.danmaku.bili.videopage.common.segment.ActivityEventDispatcher$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                ActivityEventDispatcher.scheduleRunPendingRunnable$lambda$0(ActivityEventDispatcher.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void scheduleRunPendingRunnable$lambda$0(ActivityEventDispatcher this$0) {
        this$0.mIsRunningDispatchRunnable = false;
        while (!this$0.mPendingStateDispatchRunnable.isEmpty()) {
            this$0.mPendingStateDispatchRunnable.removeFirst().run();
        }
    }

    @Override // tv.danmaku.bili.videopage.foundation.ISegment
    public void onAttach(IHost host, ParamsParser paramsParser) {
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(paramsParser, "paramsParser");
        this.mHost = host;
    }

    @Override // tv.danmaku.bili.videopage.foundation.UISegment
    public void onDetachView() {
        HostHelper hostHelper = HostHelper.INSTANCE;
        IHost iHost = this.mHost;
        if (iHost == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHost");
            iHost = null;
        }
        FragmentManager fragmentManager = hostHelper.getFragmentManager(iHost);
        if (fragmentManager == null) {
            return;
        }
        fragmentManager.beginTransaction().remove((Fragment) this).commitNowAllowingStateLoss();
    }

    @Override // tv.danmaku.bili.videopage.foundation.UISegment
    public void onAttachView(ViewGroup container) {
        Intrinsics.checkNotNullParameter(container, "container");
        HostHelper hostHelper = HostHelper.INSTANCE;
        IHost iHost = this.mHost;
        if (iHost == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHost");
            iHost = null;
        }
        FragmentManager fragmentManager = hostHelper.getFragmentManager(iHost);
        if (fragmentManager == null) {
            return;
        }
        fragmentManager.beginTransaction().replace(container.getId(), (Fragment) this).commitNowAllowingStateLoss();
    }

    @Override // tv.danmaku.bili.videopage.foundation.ISegment
    public void onDetach() {
        super.onDetach();
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        this.mPendingStateDispatchRunnable.add(new Runnable() { // from class: tv.danmaku.bili.videopage.common.segment.ActivityEventDispatcher$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                ActivityEventDispatcher.onActivityCreated$lambda$0(ActivityEventDispatcher.this);
            }
        });
        scheduleRunPendingRunnable();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onActivityCreated$lambda$0(ActivityEventDispatcher this$0) {
        Iterable $this$forEach$iv = this$0.mActivityEventObservers;
        for (Object element$iv : $this$forEach$iv) {
            ActivityLifecycleStateEventObserver it = (ActivityLifecycleStateEventObserver) element$iv;
            it.onCreate();
        }
    }

    public void onStart() {
        super.onStart();
        this.mPendingStateDispatchRunnable.add(new Runnable() { // from class: tv.danmaku.bili.videopage.common.segment.ActivityEventDispatcher$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                ActivityEventDispatcher.onStart$lambda$0(ActivityEventDispatcher.this);
            }
        });
        scheduleRunPendingRunnable();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onStart$lambda$0(ActivityEventDispatcher this$0) {
        Iterable $this$forEach$iv = this$0.mActivityEventObservers;
        for (Object element$iv : $this$forEach$iv) {
            ActivityLifecycleStateEventObserver it = (ActivityLifecycleStateEventObserver) element$iv;
            it.onStart();
        }
    }

    public void onResume() {
        super.onResume();
        this.mPendingStateDispatchRunnable.add(new Runnable() { // from class: tv.danmaku.bili.videopage.common.segment.ActivityEventDispatcher$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                ActivityEventDispatcher.onResume$lambda$0(ActivityEventDispatcher.this);
            }
        });
        scheduleRunPendingRunnable();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onResume$lambda$0(ActivityEventDispatcher this$0) {
        Iterable $this$forEach$iv = this$0.mActivityEventObservers;
        for (Object element$iv : $this$forEach$iv) {
            ActivityLifecycleStateEventObserver it = (ActivityLifecycleStateEventObserver) element$iv;
            it.onResume();
        }
    }

    public void onPause() {
        super.onPause();
        this.mPendingStateDispatchRunnable.add(new Runnable() { // from class: tv.danmaku.bili.videopage.common.segment.ActivityEventDispatcher$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                ActivityEventDispatcher.onPause$lambda$0(ActivityEventDispatcher.this);
            }
        });
        scheduleRunPendingRunnable();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onPause$lambda$0(ActivityEventDispatcher this$0) {
        Iterable $this$forEach$iv = this$0.mActivityEventObservers;
        for (Object element$iv : $this$forEach$iv) {
            ActivityLifecycleStateEventObserver it = (ActivityLifecycleStateEventObserver) element$iv;
            it.onPause();
        }
    }

    public void onStop() {
        super.onStop();
        this.mPendingStateDispatchRunnable.add(new Runnable() { // from class: tv.danmaku.bili.videopage.common.segment.ActivityEventDispatcher$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                ActivityEventDispatcher.onStop$lambda$0(ActivityEventDispatcher.this);
            }
        });
        scheduleRunPendingRunnable();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onStop$lambda$0(ActivityEventDispatcher this$0) {
        Iterable $this$forEach$iv = this$0.mActivityEventObservers;
        for (Object element$iv : $this$forEach$iv) {
            ActivityLifecycleStateEventObserver it = (ActivityLifecycleStateEventObserver) element$iv;
            it.onStop();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        this.mPendingStateDispatchRunnable.add(new Runnable() { // from class: tv.danmaku.bili.videopage.common.segment.ActivityEventDispatcher$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                ActivityEventDispatcher.onDestroy$lambda$0(ActivityEventDispatcher.this);
            }
        });
        scheduleRunPendingRunnable();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onDestroy$lambda$0(ActivityEventDispatcher this$0) {
        Iterable $this$forEach$iv = this$0.mActivityEventObservers;
        for (Object element$iv : $this$forEach$iv) {
            ActivityLifecycleStateEventObserver it = (ActivityLifecycleStateEventObserver) element$iv;
            it.onDestroy();
        }
    }

    public void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        Iterable $this$forEach$iv = this.mActivityEventObservers;
        for (Object element$iv : $this$forEach$iv) {
            ActivityLifecycleStateEventObserver it = (ActivityLifecycleStateEventObserver) element$iv;
            it.onConfigurationChanged(newConfig);
        }
    }

    public void onMultiWindowModeChanged(boolean isInMultiWindowMode) {
        super.onMultiWindowModeChanged(isInMultiWindowMode);
        Iterable $this$forEach$iv = this.mActivityEventObservers;
        for (Object element$iv : $this$forEach$iv) {
            ActivityLifecycleStateEventObserver it = (ActivityLifecycleStateEventObserver) element$iv;
            it.onMultiWindowModeChanged(isInMultiWindowMode);
        }
    }

    @Override // tv.danmaku.bili.videopage.foundation.event.ILifecycleStateEventDispatcher
    public void addEventObserver(ILifecycleStateEventObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        if ((observer instanceof ActivityLifecycleStateEventObserver) && !this.mActivityEventObservers.contains(observer)) {
            this.mActivityEventObservers.add(observer);
        }
    }

    @Override // tv.danmaku.bili.videopage.foundation.event.ILifecycleStateEventDispatcher
    public void removeEventObserver(ILifecycleStateEventObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        if ((observer instanceof ActivityLifecycleStateEventObserver) && this.mActivityEventObservers.contains(observer)) {
            this.mActivityEventObservers.remove(observer);
        }
    }

    public final void performWindowFocusChanged(boolean hasFocus) {
        Iterable $this$forEach$iv = this.mActivityEventObservers;
        for (Object element$iv : $this$forEach$iv) {
            ActivityLifecycleStateEventObserver it = (ActivityLifecycleStateEventObserver) element$iv;
            it.onWindowFocusChanged(hasFocus);
        }
    }

    public final boolean dispatchKeyEvent(KeyEvent event) {
        int size = this.mActivityEventObservers.size();
        for (int i = 0; i < size; i++) {
            if (this.mActivityEventObservers.get(i).onKeyEvent(event)) {
                return true;
            }
        }
        return false;
    }
}