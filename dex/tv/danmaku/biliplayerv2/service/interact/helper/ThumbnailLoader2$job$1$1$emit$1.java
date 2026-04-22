package tv.danmaku.biliplayerv2.service.interact.helper;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.biliplayerv2.service.interact.helper.ThumbnailLoader2;
import tv.danmaku.biliplayerv2.service.interact.helper.ThumbnailLoader2$job$1;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ThumbnailLoader2.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "tv.danmaku.biliplayerv2.service.interact.helper.ThumbnailLoader2$job$1$1", f = "ThumbnailLoader2.kt", i = {}, l = {62}, m = "emit", n = {}, s = {}, v = 1)
public final class ThumbnailLoader2$job$1$1$emit$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ThumbnailLoader2$job$1.AnonymousClass1<T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ThumbnailLoader2$job$1$1$emit$1(ThumbnailLoader2$job$1.AnonymousClass1<? super T> anonymousClass1, Continuation<? super ThumbnailLoader2$job$1$1$emit$1> continuation) {
        super(continuation);
        this.this$0 = anonymousClass1;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit((ThumbnailLoader2.ThumbnailFetchRequest) null, (Continuation) this);
    }
}