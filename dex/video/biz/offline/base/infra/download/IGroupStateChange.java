package video.biz.offline.base.infra.download;

import kotlin.Metadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: TaskGroup.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u001c\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\u0010\u0007\u001a\u00060\bj\u0002`\tH&¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lvideo/biz/offline/base/infra/download/IGroupStateChange;", "", "onFinish", "", "group", "Lvideo/biz/offline/base/infra/download/TaskGroup;", "onError", "error", "Ljava/lang/Exception;", "Lkotlin/Exception;", "infra_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public interface IGroupStateChange {
    void onError(TaskGroup taskGroup, Exception exc);

    void onFinish(TaskGroup taskGroup);
}