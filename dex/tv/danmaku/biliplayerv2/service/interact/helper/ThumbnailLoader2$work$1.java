package tv.danmaku.biliplayerv2.service.interact.helper;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ThumbnailLoader2.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "tv.danmaku.biliplayerv2.service.interact.helper.ThumbnailLoader2", f = "ThumbnailLoader2.kt", i = {5, 5, 5}, l = {178, 184, 213, 231, 278, 282, 293}, m = "work", n = {"key", "bmp", "cacheLevel"}, s = {"L$0", "L$1", "I$0"}, v = 1)
public final class ThumbnailLoader2$work$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ThumbnailLoader2 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThumbnailLoader2$work$1(ThumbnailLoader2 thumbnailLoader2, Continuation<? super ThumbnailLoader2$work$1> continuation) {
        super(continuation);
        this.this$0 = thumbnailLoader2;
    }

    public final Object invokeSuspend(Object obj) {
        Object work;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        work = this.this$0.work(null, (Continuation) this);
        return work;
    }
}