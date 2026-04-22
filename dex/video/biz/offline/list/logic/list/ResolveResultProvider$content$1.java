package video.biz.offline.list.logic.list;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OfflineResolveDataProvider.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "video.biz.offline.list.logic.list.ResolveResultProvider", f = "OfflineResolveDataProvider.kt", i = {}, l = {182}, m = "content", n = {}, s = {}, v = 1)
public final class ResolveResultProvider$content$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ResolveResultProvider this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResolveResultProvider$content$1(ResolveResultProvider resolveResultProvider, Continuation<? super ResolveResultProvider$content$1> continuation) {
        super(continuation);
        this.this$0 = resolveResultProvider;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.content((Continuation) this);
    }
}