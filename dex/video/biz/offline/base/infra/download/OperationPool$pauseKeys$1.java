package video.biz.offline.base.infra.download;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.biliplayerv2.service.setting.Player;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OperationPool.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "video.biz.offline.base.infra.download.OperationPool", f = "OperationPool.kt", i = {0, 1}, l = {Player.PLAYER_QUALITY_HDR, 137}, m = "pauseKeys", n = {"keys", "keys"}, s = {"L$0", "L$0"}, v = 1)
public final class OperationPool$pauseKeys$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ OperationPool this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OperationPool$pauseKeys$1(OperationPool operationPool, Continuation<? super OperationPool$pauseKeys$1> continuation) {
        super(continuation);
        this.this$0 = operationPool;
    }

    public final Object invokeSuspend(Object obj) {
        Object pauseKeys;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        pauseKeys = this.this$0.pauseKeys(null, (Continuation) this);
        return pauseKeys;
    }
}