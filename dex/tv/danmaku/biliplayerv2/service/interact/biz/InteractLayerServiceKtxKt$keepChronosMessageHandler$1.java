package tv.danmaku.biliplayerv2.service.interact.biz;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkCpuInfo;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: InteractLayerServiceKtx.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "tv.danmaku.biliplayerv2.service.interact.biz.InteractLayerServiceKtxKt", f = "InteractLayerServiceKtx.kt", i = {0, 0}, l = {IjkCpuInfo.CPU_PART_SNAPDRAGON_S3}, m = "keepChronosMessageHandler", n = {"$this$keepChronosMessageHandler", "handler"}, s = {"L$0", "L$1"}, v = 1)
public final class InteractLayerServiceKtxKt$keepChronosMessageHandler$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public InteractLayerServiceKtxKt$keepChronosMessageHandler$1(Continuation<? super InteractLayerServiceKtxKt$keepChronosMessageHandler$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return InteractLayerServiceKtxKt.keepChronosMessageHandler(null, null, (Continuation) this);
    }
}