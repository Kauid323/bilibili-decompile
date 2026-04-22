package video.biz.offline.base.infra.download;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TaskGroup.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "video.biz.offline.base.infra.download.TaskGroup", f = "TaskGroup.kt", i = {0, 0, 0}, l = {373}, m = "resolvePlayView", n = {"vipCheck", "downloadParam", "req"}, s = {"L$0", "L$1", "L$2"}, v = 1)
public final class TaskGroup$resolvePlayView$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TaskGroup this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskGroup$resolvePlayView$1(TaskGroup taskGroup, Continuation<? super TaskGroup$resolvePlayView$1> continuation) {
        super(continuation);
        this.this$0 = taskGroup;
    }

    public final Object invokeSuspend(Object obj) {
        Object resolvePlayView;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        resolvePlayView = this.this$0.resolvePlayView((Continuation) this);
        return resolvePlayView;
    }
}