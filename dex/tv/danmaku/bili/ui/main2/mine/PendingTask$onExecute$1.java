package tv.danmaku.bili.ui.main2.mine;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.bili.BR;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MinePagePendingTaskUtil.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.ui.main2.mine.PendingTask", f = "MinePagePendingTaskUtil.kt", i = {0}, l = {BR.bannerItemDataList, BR.bannerItems}, m = "onExecute$suspendImpl", n = {"$this"}, s = {"L$0"}, v = 1)
public final class PendingTask$onExecute$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PendingTask this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PendingTask$onExecute$1(PendingTask pendingTask, Continuation<? super PendingTask$onExecute$1> continuation) {
        super(continuation);
        this.this$0 = pendingTask;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return PendingTask.onExecute$suspendImpl(this.this$0, (Continuation) this);
    }
}