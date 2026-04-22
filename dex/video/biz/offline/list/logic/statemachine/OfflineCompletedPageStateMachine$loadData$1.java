package video.biz.offline.list.logic.statemachine;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.send.AddCustomDanmaku;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OfflineCompletedPageStateMachine.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "video.biz.offline.list.logic.statemachine.OfflineCompletedPageStateMachine", f = "OfflineCompletedPageStateMachine.kt", i = {0, 0, 0, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4}, l = {101, 102, 105, AddCustomDanmaku.TYPE_REAL_TIME_INTERACT, 107}, m = "loadData", n = {"state", "queryId", "startTimestamp", "state", "queryId", "startTimestamp", "state", "videos", "queryId", "startTimestamp", "loadedTimestamp", "state", "videos", "completed", "queryId", "startTimestamp", "loadedTimestamp", "state", "videos", "completed", "queryId", "startTimestamp", "loadedTimestamp"}, s = {"L$0", "J$0", "J$1", "L$0", "J$0", "J$1", "L$0", "L$1", "J$0", "J$1", "J$2", "L$0", "L$1", "L$2", "J$0", "J$1", "J$2", "L$0", "L$1", "L$2", "J$0", "J$1", "J$2"}, v = 1)
public final class OfflineCompletedPageStateMachine$loadData$1 extends ContinuationImpl {
    long J$0;
    long J$1;
    long J$2;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ OfflineCompletedPageStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OfflineCompletedPageStateMachine$loadData$1(OfflineCompletedPageStateMachine offlineCompletedPageStateMachine, Continuation<? super OfflineCompletedPageStateMachine$loadData$1> continuation) {
        super(continuation);
        this.this$0 = offlineCompletedPageStateMachine;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.loadData(null, (Continuation) this);
    }
}