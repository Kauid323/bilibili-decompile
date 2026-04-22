package video.biz.offline.list.logic.statemachine;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OfflineSearchPageStateMachine.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "video.biz.offline.list.logic.statemachine.OfflineSearchPageStateMachine", f = "OfflineSearchPageStateMachine.kt", i = {0, 1, 1}, l = {89, 90}, m = "onHistoryUpdated", n = {"state", "state", "videos"}, s = {"L$0", "L$0", "L$1"}, v = 1)
public final class OfflineSearchPageStateMachine$onHistoryUpdated$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ OfflineSearchPageStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OfflineSearchPageStateMachine$onHistoryUpdated$1(OfflineSearchPageStateMachine offlineSearchPageStateMachine, Continuation<? super OfflineSearchPageStateMachine$onHistoryUpdated$1> continuation) {
        super(continuation);
        this.this$0 = offlineSearchPageStateMachine;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.onHistoryUpdated(null, (Continuation) this);
    }
}