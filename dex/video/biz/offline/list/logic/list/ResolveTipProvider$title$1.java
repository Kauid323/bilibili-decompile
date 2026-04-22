package video.biz.offline.list.logic.list;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.bili.ui.rank.router.RankRouter;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OfflineResolveDataProvider.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "video.biz.offline.list.logic.list.ResolveTipProvider", f = "OfflineResolveDataProvider.kt", i = {}, l = {IjkMediaPlayer.FFP_BUFFERING_END_REASON_ENOUGH_PACKETS}, m = RankRouter.BundleKey.ACTION_PARAM_TITLE, n = {}, s = {}, v = 1)
public final class ResolveTipProvider$title$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ResolveTipProvider this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResolveTipProvider$title$1(ResolveTipProvider resolveTipProvider, Continuation<? super ResolveTipProvider$title$1> continuation) {
        super(continuation);
        this.this$0 = resolveTipProvider;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.title((Continuation) this);
    }
}