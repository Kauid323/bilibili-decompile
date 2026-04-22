package video.biz.offline.base.facade.client;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.biliplayerv2.service.interact.biz.model.comment.AbsoluteCommentItem;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VideoDownloadClientV2.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "video.biz.offline.base.facade.client.VideoDownloadClientV2", f = "VideoDownloadClientV2.kt", i = {0, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3}, l = {433, AbsoluteCommentItem.BILI_PLAYER_HEIGHT, 440, 444}, m = "setMaxConcurrent", n = {"max", "downloading", "keys", "max", "excess", "downloading", "keys", "needPending", "max", "excess", "downloading", "keys", "max", "excess"}, s = {"I$0", "L$0", "L$1", "I$0", "I$1", "L$0", "L$1", "L$2", "I$0", "I$1", "L$0", "L$1", "I$0", "I$1"}, v = 1)
public final class VideoDownloadClientV2$setMaxConcurrent$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ VideoDownloadClientV2 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoDownloadClientV2$setMaxConcurrent$1(VideoDownloadClientV2 videoDownloadClientV2, Continuation<? super VideoDownloadClientV2$setMaxConcurrent$1> continuation) {
        super(continuation);
        this.this$0 = videoDownloadClientV2;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.setMaxConcurrent(0, (Continuation) this);
    }
}