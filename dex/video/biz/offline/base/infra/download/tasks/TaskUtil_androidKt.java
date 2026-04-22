package video.biz.offline.base.infra.download.tasks;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: TaskUtil.android.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u0018\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0001¨\u0006\u0004"}, d2 = {"getTaskId", "", "taskId", "url", "infra_debug"}, k = 2, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class TaskUtil_androidKt {
    public static final String getTaskId(String taskId, String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        return taskId == null ? "" : taskId;
    }
}