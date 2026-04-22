package tv.danmaku.bili.ui.watchlater;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.bili.ui.watchlater.WatchLaterFragmentV3$onViewCreated$2;
import tv.danmaku.bili.ui.watchlater.data.WLEvent;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: WatchLaterFragmentV3.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "tv.danmaku.bili.ui.watchlater.WatchLaterFragmentV3$onViewCreated$2$1", f = "WatchLaterFragmentV3.kt", i = {0}, l = {163}, m = "emit", n = {"event"}, s = {"L$0"}, v = 1)
public final class WatchLaterFragmentV3$onViewCreated$2$1$emit$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ WatchLaterFragmentV3$onViewCreated$2.AnonymousClass1<T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public WatchLaterFragmentV3$onViewCreated$2$1$emit$1(WatchLaterFragmentV3$onViewCreated$2.AnonymousClass1<? super T> anonymousClass1, Continuation<? super WatchLaterFragmentV3$onViewCreated$2$1$emit$1> continuation) {
        super(continuation);
        this.this$0 = anonymousClass1;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit((WLEvent) null, (Continuation) this);
    }
}