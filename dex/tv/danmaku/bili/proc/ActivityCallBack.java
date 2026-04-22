package tv.danmaku.bili.proc;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.bilibili.base.ipc.IPCAppStateManager;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import tv.danmaku.bili.report.ActivityStackTraceHelper;

public class ActivityCallBack implements Application.ActivityLifecycleCallbacks {
    static List<ActivityStateCallback> sCallbackList = new CopyOnWriteArrayList();
    static List<IPCActivityStateCallback> sIPCCallbackList = new CopyOnWriteArrayList();
    private int mForegroundActivitiesCount;
    private int mIPCForegroundActivitiesCount;
    private int mIPCVisibleCount;
    private int mVisibleCount;

    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public interface ActivityStateCallback {
        void onForegroundActivitiesChanged(Activity activity, int i, int i2);

        void onVisibleCountChanged(Activity activity, int i, int i2);
    }

    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public interface IPCActivityStateCallback {
        void onForegroundActivitiesChanged(Activity activity, int i, int i2);

        void onVisibleCountChanged(Activity activity, int i, int i2);
    }

    public boolean isForeground() {
        return this.mForegroundActivitiesCount > 0;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        this.mForegroundActivitiesCount++;
        for (ActivityStateCallback callback : sCallbackList) {
            callback.onForegroundActivitiesChanged(activity, this.mForegroundActivitiesCount - 1, this.mForegroundActivitiesCount);
        }
        this.mIPCForegroundActivitiesCount = IPCAppStateManager.getInstance().onActivityCreate(activity);
        for (IPCActivityStateCallback iPCCallback : sIPCCallbackList) {
            iPCCallback.onForegroundActivitiesChanged(activity, this.mIPCForegroundActivitiesCount - 1, this.mIPCForegroundActivitiesCount);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        this.mVisibleCount++;
        for (ActivityStateCallback callback : sCallbackList) {
            callback.onVisibleCountChanged(activity, this.mVisibleCount - 1, this.mVisibleCount);
        }
        this.mIPCVisibleCount = IPCAppStateManager.getInstance().onActivityStart(activity);
        for (IPCActivityStateCallback iPCCallback : sIPCCallbackList) {
            iPCCallback.onVisibleCountChanged(activity, this.mIPCVisibleCount - 1, this.mIPCVisibleCount);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        ActivityStackTraceHelper.getInstance().push(activity);
        IPCAppStateManager.getInstance().onActivityResume(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        if (activity.isFinishing()) {
            ActivityStackTraceHelper.getInstance().pop(activity);
        }
        IPCAppStateManager.getInstance().onActivityPause(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        this.mVisibleCount--;
        for (ActivityStateCallback callback : sCallbackList) {
            callback.onVisibleCountChanged(activity, this.mVisibleCount + 1, this.mVisibleCount);
        }
        this.mIPCVisibleCount = IPCAppStateManager.getInstance().onActivityStop(activity);
        for (IPCActivityStateCallback iPCCallback : sIPCCallbackList) {
            iPCCallback.onVisibleCountChanged(activity, this.mIPCVisibleCount + 1, this.mIPCVisibleCount);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        this.mForegroundActivitiesCount--;
        for (ActivityStateCallback callback : sCallbackList) {
            callback.onForegroundActivitiesChanged(activity, this.mForegroundActivitiesCount + 1, this.mForegroundActivitiesCount);
        }
        this.mIPCForegroundActivitiesCount = IPCAppStateManager.getInstance().onActivityDestroy(activity);
        for (IPCActivityStateCallback iPCCallback : sIPCCallbackList) {
            iPCCallback.onForegroundActivitiesChanged(activity, this.mIPCForegroundActivitiesCount + 1, this.mIPCForegroundActivitiesCount);
        }
    }

    public static void addActivityStateCallback(ActivityStateCallback callback) {
        if (!sCallbackList.contains(callback)) {
            sCallbackList.add(callback);
        }
    }

    public static void removeActivityStateCallback(ActivityStateCallback callback) {
        if (sCallbackList.contains(callback)) {
            sCallbackList.remove(callback);
        }
    }

    public static void addIPCActivityStateCallback(IPCActivityStateCallback callback) {
        if (!sIPCCallbackList.contains(callback)) {
            sIPCCallbackList.add(callback);
        }
    }

    public static void removeIPCActivityStateCallback(IPCActivityStateCallback callback) {
        if (sIPCCallbackList.contains(callback)) {
            sIPCCallbackList.remove(callback);
        }
    }
}