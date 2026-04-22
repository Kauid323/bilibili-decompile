package video.biz.offline.list.logic.statemachine;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OfflineHomePageStateMachine.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "video.biz.offline.list.logic.statemachine.OfflineHomePageStateMachine", f = "OfflineHomePageStateMachine.kt", i = {0, 1, 1, 2, 2, 2}, l = {242, 243, IjkMediaMeta.FF_PROFILE_H264_HIGH_444_PREDICTIVE}, m = "onHistoryUpdated", n = {"state", "state", "videos", "state", "videos", "completed"}, s = {"L$0", "L$0", "L$1", "L$0", "L$1", "L$2"}, v = 1)
public final class OfflineHomePageStateMachine$onHistoryUpdated$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ OfflineHomePageStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OfflineHomePageStateMachine$onHistoryUpdated$1(OfflineHomePageStateMachine offlineHomePageStateMachine, Continuation<? super OfflineHomePageStateMachine$onHistoryUpdated$1> continuation) {
        super(continuation);
        this.this$0 = offlineHomePageStateMachine;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.onHistoryUpdated(null, (Continuation) this);
    }
}