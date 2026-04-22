package video.biz.offline.base.facade.client;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VideoDownloadClientV2.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "video.biz.offline.base.facade.client.VideoDownloadClientV2", f = "VideoDownloadClientV2.kt", i = {0, 1, 1, 1}, l = {404, 406}, m = "start", n = {"key", "key", "it", "$i$a$-let-VideoDownloadClientV2$start$2"}, s = {"L$0", "L$0", "L$1", "I$0"}, v = 1)
public final class VideoDownloadClientV2$start$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ VideoDownloadClientV2 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoDownloadClientV2$start$1(VideoDownloadClientV2 videoDownloadClientV2, Continuation<? super VideoDownloadClientV2$start$1> continuation) {
        super(continuation);
        this.this$0 = videoDownloadClientV2;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.start(null, (Continuation) this);
    }
}