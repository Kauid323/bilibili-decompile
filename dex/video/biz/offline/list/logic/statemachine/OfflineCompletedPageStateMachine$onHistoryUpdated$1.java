package video.biz.offline.list.logic.statemachine;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.bili.utils.PhotoUtil;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OfflineCompletedPageStateMachine.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "video.biz.offline.list.logic.statemachine.OfflineCompletedPageStateMachine", f = "OfflineCompletedPageStateMachine.kt", i = {0, 0, 1, 1, 2, 2, 2}, l = {198, 199, PhotoUtil.GALLERY_REQUEST_CODE}, m = "onHistoryUpdated", n = {"state", "queryId", "state", "queryId", "state", "videos", "queryId"}, s = {"L$0", "J$0", "L$0", "J$0", "L$0", "L$1", "J$0"}, v = 1)
public final class OfflineCompletedPageStateMachine$onHistoryUpdated$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ OfflineCompletedPageStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OfflineCompletedPageStateMachine$onHistoryUpdated$1(OfflineCompletedPageStateMachine offlineCompletedPageStateMachine, Continuation<? super OfflineCompletedPageStateMachine$onHistoryUpdated$1> continuation) {
        super(continuation);
        this.this$0 = offlineCompletedPageStateMachine;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.onHistoryUpdated(null, (Continuation) this);
    }
}