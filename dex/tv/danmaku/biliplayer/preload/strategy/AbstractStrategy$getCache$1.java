package tv.danmaku.biliplayer.preload.strategy;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AbstractStrategy.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "tv.danmaku.biliplayer.preload.strategy.AbstractStrategy", f = "AbstractStrategy.kt", i = {}, l = {30}, m = "getCache", n = {}, s = {}, v = 1)
public final class AbstractStrategy$getCache$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AbstractStrategy this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractStrategy$getCache$1(AbstractStrategy abstractStrategy, Continuation<? super AbstractStrategy$getCache$1> continuation) {
        super(continuation);
        this.this$0 = abstractStrategy;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getCache(null, (Continuation) this);
    }
}