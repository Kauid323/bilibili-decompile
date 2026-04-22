package video.biz.offline.base.facade.client;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VideoDownloadClientV2.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "video.biz.offline.base.facade.client.VideoDownloadClientV2", f = "VideoDownloadClientV2.kt", i = {0, 1, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 4}, l = {247, 248, 255, IjkMediaPlayer.FFP_BUFFERING_END_REASON_ENOUGH_DURATION, IjkMediaPlayer.FFP_BUFFERING_END_REASON_ENOUGH_PACKETS}, m = "addVideos", n = {"params", "params", "params", "completes", "needDownloads", "needUpdateItems", "params", "completes", "needDownloads", "needUpdateItems", "params", "completes", "needDownloads", "needUpdateItems", "flow"}, s = {"L$0", "L$0", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4"}, v = 1)
public final class VideoDownloadClientV2$addVideos$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ VideoDownloadClientV2 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoDownloadClientV2$addVideos$1(VideoDownloadClientV2 videoDownloadClientV2, Continuation<? super VideoDownloadClientV2$addVideos$1> continuation) {
        super(continuation);
        this.this$0 = videoDownloadClientV2;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.addVideos(null, (Continuation) this);
    }
}