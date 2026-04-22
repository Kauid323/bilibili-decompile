package video.biz.offline.list.logic.list;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkCpuInfo;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OfflineResolveDataProvider.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "video.biz.offline.list.logic.list.ResolveDescProvider", f = "OfflineResolveDataProvider.kt", i = {1, 2, 3, 4}, l = {46, 56, 59, 62, IjkCpuInfo.CPU_IMPL_DEC}, m = "content", n = {"state", "state", "state", "state"}, s = {"L$0", "L$0", "L$0", "L$0"}, v = 1)
public final class ResolveDescProvider$content$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ResolveDescProvider this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResolveDescProvider$content$1(ResolveDescProvider resolveDescProvider, Continuation<? super ResolveDescProvider$content$1> continuation) {
        super(continuation);
        this.this$0 = resolveDescProvider;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.content((Continuation) this);
    }
}