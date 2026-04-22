package tv.danmaku.biliplayerv2.service;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IPlayerCoreServiceKtx.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "tv.danmaku.biliplayerv2.service.IPlayerCoreServiceKtxKt", f = "IPlayerCoreServiceKtx.kt", i = {0}, l = {93}, m = "retainOnAssetUpdateListener", n = {"$this$retainOnAssetUpdateListener"}, s = {"L$0"}, v = 1)
public final class IPlayerCoreServiceKtxKt$retainOnAssetUpdateListener$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public IPlayerCoreServiceKtxKt$retainOnAssetUpdateListener$1(Continuation<? super IPlayerCoreServiceKtxKt$retainOnAssetUpdateListener$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return IPlayerCoreServiceKtxKt.retainOnAssetUpdateListener(null, null, (Continuation) this);
    }
}