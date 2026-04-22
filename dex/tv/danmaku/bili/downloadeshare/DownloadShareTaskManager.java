package tv.danmaku.bili.downloadeshare;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.audio.AudioIntentHelper;

/* compiled from: DownloadShareTaskManager.kt */
@Metadata(d1 = {"\u0000A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\t\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0006\u0010\u0014\u001a\u00020\fJ\u0006\u0010\u0015\u001a\u00020\u0016J\u0006\u0010\u0017\u001a\u00020\fR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\n¨\u0006\u0018"}, d2 = {"Ltv/danmaku/bili/downloadeshare/DownloadShareTaskManager;", "", "<init>", "()V", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "taskHead", "Ltv/danmaku/bili/downloadeshare/IDownloadShareTask;", "lifecycleObject", "tv/danmaku/bili/downloadeshare/DownloadShareTaskManager$lifecycleObject$1", "Ltv/danmaku/bili/downloadeshare/DownloadShareTaskManager$lifecycleObject$1;", "startDownloadShare", "", AudioIntentHelper.FROM_ACTIVITY, "Landroidx/fragment/app/FragmentActivity;", "parameter", "Ltv/danmaku/bili/downloadeshare/DownloadShareParameter;", "panelType", "", "createAllTaskReturnHead", "stopDownloadShare", "isActive", "", "tryHidePanel", "downloadsharecommon_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class DownloadShareTaskManager {
    private Lifecycle lifecycle;
    private DownloadShareTaskManager$lifecycleObject$1 lifecycleObject = new DownloadShareTaskManager$lifecycleObject$1(this);
    private IDownloadShareTask taskHead;

    public final void startDownloadShare(FragmentActivity activity, DownloadShareParameter parameter, int panelType) {
        Intrinsics.checkNotNullParameter(parameter, "parameter");
        if (isActive()) {
            stopDownloadShare();
        }
        this.lifecycle = activity != null ? activity.getLifecycle() : null;
        Lifecycle lifecycle = this.lifecycle;
        if (lifecycle != null) {
            lifecycle.removeObserver(this.lifecycleObject);
        }
        Lifecycle lifecycle2 = this.lifecycle;
        if (lifecycle2 != null) {
            lifecycle2.addObserver(this.lifecycleObject);
        }
        this.taskHead = createAllTaskReturnHead(panelType);
        IDownloadShareTask iDownloadShareTask = this.taskHead;
        if (iDownloadShareTask != null) {
            iDownloadShareTask.start(activity, new DownloadShareContext(parameter));
        }
    }

    private final IDownloadShareTask createAllTaskReturnHead(int panelType) {
        IDownloadShareTask attach;
        IDownloadShareTask attach2;
        PermissionTask it = new PermissionTask();
        IDownloadShareTask attach3 = it.attach(new DownloadInfoTask());
        if (attach3 != null && (attach = attach3.attach(new NetworkTask())) != null && (attach2 = attach.attach(new DownloadVideoTask(panelType))) != null) {
            attach2.attach(new DownloadSharePanelTask());
        }
        return it;
    }

    public final void stopDownloadShare() {
        this.lifecycleObject.onDestroy();
        this.lifecycle = null;
        this.taskHead = null;
    }

    public final boolean isActive() {
        for (IDownloadShareTask task = this.taskHead; task != null; task = task.getNext()) {
            if (task.isActive()) {
                return true;
            }
        }
        return false;
    }

    public final void tryHidePanel() {
        for (IDownloadShareTask task = this.taskHead; task != null; task = task.getNext()) {
            if (task.isActive() && (task instanceof DownloadVideoTask)) {
                ((DownloadVideoTask) task).doSilentDownload();
            }
        }
    }
}