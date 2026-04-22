package video.biz.offline.list.logic.statemachine;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OfflineHomePageStateMachine.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "video.biz.offline.list.logic.statemachine.OfflineHomePageStateMachine", f = "OfflineHomePageStateMachine.kt", i = {1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3}, l = {273, 280, 300, 324}, m = "handleAuth", n = {"videos", "avMap", "updateList", "videos", "avMap", "updateList", "epList", "videos", "avMap", "updateList", "epList"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3"}, v = 1)
public final class OfflineHomePageStateMachine$handleAuth$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ OfflineHomePageStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OfflineHomePageStateMachine$handleAuth$1(OfflineHomePageStateMachine offlineHomePageStateMachine, Continuation<? super OfflineHomePageStateMachine$handleAuth$1> continuation) {
        super(continuation);
        this.this$0 = offlineHomePageStateMachine;
    }

    public final Object invokeSuspend(Object obj) {
        Object handleAuth;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        handleAuth = this.this$0.handleAuth((Continuation) this);
        return handleAuth;
    }
}