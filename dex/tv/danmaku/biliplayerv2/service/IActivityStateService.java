package tv.danmaku.biliplayerv2.service;

import android.content.Context;
import android.content.res.Configuration;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Deprecated;
import kotlin.Metadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: IActivityStateService.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\b\u0010\u0006\u001a\u00020\u0005H'J\b\u0010\u0007\u001a\u00020\bH&J)\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0012\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\r\"\u00020\u0005H'¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH'J\u0012\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H&J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0015H&J\b\u0010\u0016\u001a\u00020\u0015H&J\u0010\u0010\u0017\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0018H&J\u0010\u0010\u0019\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0018H&J\b\u0010\u001a\u001a\u00020\u001bH'ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u001cÀ\u0006\u0001"}, d2 = {"Ltv/danmaku/biliplayerv2/service/IActivityStateService;", "Landroidx/lifecycle/LifecycleOwner;", "setLifecycleState", "", "state", "Ltv/danmaku/biliplayerv2/service/LifecycleState;", "getLifecycleState", "getOrientation", "", "registerLifecycle", "observer", "Ltv/danmaku/biliplayerv2/service/LifecycleObserver;", "states", "", "(Ltv/danmaku/biliplayerv2/service/LifecycleObserver;[Ltv/danmaku/biliplayerv2/service/LifecycleState;)V", "unregisterLifecycle", "setActivityOrientation", "newConfig", "Landroid/content/res/Configuration;", "dispatchWindowInsetChanged", "windowInset", "Ltv/danmaku/biliplayerv2/service/WindowInset;", "getWindowInset", "registerWindowInset", "Ltv/danmaku/biliplayerv2/service/IWindowInsetObserver;", "unregisterWindowInset", "getContext", "Landroid/content/Context;", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public interface IActivityStateService extends LifecycleOwner {
    void dispatchWindowInsetChanged(WindowInset windowInset);

    @Deprecated(message = "Use @InjectPlayerService to acquire Context.")
    Context getContext();

    @Deprecated(message = "Use androidx Lifecycle.")
    LifecycleState getLifecycleState();

    int getOrientation();

    WindowInset getWindowInset();

    @Deprecated(message = "Use androidx Lifecycle.")
    void registerLifecycle(LifecycleObserver lifecycleObserver, LifecycleState... lifecycleStateArr);

    void registerWindowInset(IWindowInsetObserver iWindowInsetObserver);

    void setActivityOrientation(Configuration configuration);

    @Deprecated(message = "Use androidx Lifecycle.")
    void setLifecycleState(LifecycleState lifecycleState);

    @Deprecated(message = "Use androidx Lifecycle.")
    void unregisterLifecycle(LifecycleObserver lifecycleObserver);

    void unregisterWindowInset(IWindowInsetObserver iWindowInsetObserver);
}