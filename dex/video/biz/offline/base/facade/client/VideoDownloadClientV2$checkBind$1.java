package video.biz.offline.base.facade.client;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VideoDownloadClientV2.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "video.biz.offline.base.facade.client.VideoDownloadClientV2", f = "VideoDownloadClientV2.kt", i = {0, 0}, l = {182}, m = "checkBind", n = {"it", "$i$a$-repeat-VideoDownloadClientV2$checkBind$2"}, s = {"I$2", "I$3"}, v = 1)
public final class VideoDownloadClientV2$checkBind$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    int I$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ VideoDownloadClientV2 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoDownloadClientV2$checkBind$1(VideoDownloadClientV2 videoDownloadClientV2, Continuation<? super VideoDownloadClientV2$checkBind$1> continuation) {
        super(continuation);
        this.this$0 = videoDownloadClientV2;
    }

    public final Object invokeSuspend(Object obj) {
        Object checkBind;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        checkBind = this.this$0.checkBind((Continuation) this);
        return checkBind;
    }
}