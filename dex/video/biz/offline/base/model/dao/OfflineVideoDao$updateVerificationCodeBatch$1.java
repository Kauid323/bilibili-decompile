package video.biz.offline.base.model.dao;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.biz.offline.base.model.dao.OfflineVideoDao;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OfflineVideoDao.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "video.biz.offline.base.model.dao.OfflineVideoDao", f = "OfflineVideoDao.kt", i = {0, 0, 0, 1, 1, 1, 1, 1}, l = {235, 243}, m = "updateVerificationCodeBatch$suspendImpl", n = {"$this", "updates", "updateMap", "$this", "updates", "updateMap", "allVideos", "updatedVideos"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4"}, v = 1)
public final class OfflineVideoDao$updateVerificationCodeBatch$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ OfflineVideoDao this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OfflineVideoDao$updateVerificationCodeBatch$1(OfflineVideoDao offlineVideoDao, Continuation<? super OfflineVideoDao$updateVerificationCodeBatch$1> continuation) {
        super(continuation);
        this.this$0 = offlineVideoDao;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return OfflineVideoDao.CC.updateVerificationCodeBatch$suspendImpl(this.this$0, null, (Continuation) this);
    }
}