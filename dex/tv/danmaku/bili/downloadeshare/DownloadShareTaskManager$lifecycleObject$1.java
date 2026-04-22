package tv.danmaku.bili.downloadeshare;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import kotlin.Metadata;
import tv.danmaku.bili.BR;

/* compiled from: DownloadShareTaskManager.kt */
@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0007¨\u0006\u0004"}, d2 = {"tv/danmaku/bili/downloadeshare/DownloadShareTaskManager$lifecycleObject$1", "Landroidx/lifecycle/LifecycleObserver;", "onDestroy", "", "downloadsharecommon_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class DownloadShareTaskManager$lifecycleObject$1 implements LifecycleObserver {
    final /* synthetic */ DownloadShareTaskManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DownloadShareTaskManager$lifecycleObject$1(DownloadShareTaskManager $receiver) {
        this.this$0 = $receiver;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        Lifecycle lifecycle;
        IDownloadShareTask task;
        lifecycle = this.this$0.lifecycle;
        if (lifecycle != null) {
            lifecycle.removeObserver(this);
        }
        for (task = this.this$0.taskHead; task != null; task = task.getNext()) {
            if (task.isActive()) {
                if (task instanceof DownloadVideoTask) {
                    ((DownloadVideoTask) task).cancelWithoutDownloadRequest();
                } else {
                    task.cancel();
                }
            }
        }
    }
}