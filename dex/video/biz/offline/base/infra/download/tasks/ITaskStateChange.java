package video.biz.offline.base.infra.download.tasks;

import kotlin.Metadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.biz.offline.base.model.error.DownloadException;

/* compiled from: ITask.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH&¨\u0006\rÀ\u0006\u0003"}, d2 = {"Lvideo/biz/offline/base/infra/download/tasks/ITaskStateChange;", "", "onLoading", "", "task", "Lvideo/biz/offline/base/infra/download/tasks/ITask;", "onFinish", "onError", "error", "Lvideo/biz/offline/base/model/error/DownloadException;", "danmakuUpdate", "count", "", "infra_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public interface ITaskStateChange {
    void danmakuUpdate(int i);

    void onError(ITask iTask, DownloadException downloadException);

    void onFinish(ITask iTask);

    void onLoading(ITask iTask);
}