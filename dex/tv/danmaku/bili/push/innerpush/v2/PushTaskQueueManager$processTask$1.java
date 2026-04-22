package tv.danmaku.bili.push.innerpush.v2;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.bili.BR;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: InnerPushTaskManager.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.push.innerpush.v2.PushTaskQueueManager", f = "InnerPushTaskManager.kt", i = {}, l = {BR.config}, m = "processTask", n = {}, s = {}, v = 1)
public final class PushTaskQueueManager$processTask$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PushTaskQueueManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PushTaskQueueManager$processTask$1(PushTaskQueueManager pushTaskQueueManager, Continuation<? super PushTaskQueueManager$processTask$1> continuation) {
        super(continuation);
        this.this$0 = pushTaskQueueManager;
    }

    public final Object invokeSuspend(Object obj) {
        Object processTask;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        processTask = this.this$0.processTask(null, (Continuation) this);
        return processTask;
    }
}