package im.base;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LiveBadge.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.base.LiveIconPainter", f = "LiveBadge.kt", i = {}, l = {142}, m = "startAni", n = {}, s = {}, v = 1)
public final class LiveIconPainter$startAni$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LiveIconPainter this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveIconPainter$startAni$1(LiveIconPainter liveIconPainter, Continuation<? super LiveIconPainter$startAni$1> continuation) {
        super(continuation);
        this.this$0 = liveIconPainter;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.startAni((Continuation) this);
    }
}