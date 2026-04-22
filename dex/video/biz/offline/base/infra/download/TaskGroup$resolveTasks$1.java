package video.biz.offline.base.infra.download;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.biliplayerv2.service.setting.Player;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TaskGroup.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "video.biz.offline.base.infra.download.TaskGroup", f = "TaskGroup.kt", i = {2, 3}, l = {116, 119, Player.PLAYER_QUALITY_HDR, 133}, m = "resolveTasks", n = {"error", "error"}, s = {"L$0", "L$0"}, v = 1)
public final class TaskGroup$resolveTasks$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TaskGroup this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskGroup$resolveTasks$1(TaskGroup taskGroup, Continuation<? super TaskGroup$resolveTasks$1> continuation) {
        super(continuation);
        this.this$0 = taskGroup;
    }

    public final Object invokeSuspend(Object obj) {
        Object resolveTasks;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        resolveTasks = this.this$0.resolveTasks((Continuation) this);
        return resolveTasks;
    }
}