package tv.danmaku.biliplayer.preload.repository;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PreloadPoolImpl.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "tv.danmaku.biliplayer.preload.repository.PreloadPoolImpl$getPlayerItemCache$2", f = "PreloadPoolImpl.kt", i = {0, 0}, l = {246}, m = "invokeSuspend$waitCache", n = {"cachedItem", "this$0"}, s = {"L$0", "L$1"}, v = 1)
public final class PreloadPoolImpl$getPlayerItemCache$2$waitCache$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PreloadPoolImpl$getPlayerItemCache$2$waitCache$1(Continuation<? super PreloadPoolImpl$getPlayerItemCache$2$waitCache$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return PreloadPoolImpl$getPlayerItemCache$2.invokeSuspend$waitCache(null, null, (Continuation) this);
    }
}