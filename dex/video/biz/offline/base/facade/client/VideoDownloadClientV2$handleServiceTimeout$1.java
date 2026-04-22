package video.biz.offline.base.facade.client;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.base.log.IVBLog;
import video.base.log.LogKt;
import video.biz.offline.base.infra.storage.DataStorageWrapper;
import video.biz.offline.base.infra.storage.DataStorageWrapperKt;
import video.biz.offline.base.model.entity.OfflineVideoEntity;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VideoDownloadClientV2.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "video.biz.offline.base.facade.client.VideoDownloadClientV2$handleServiceTimeout$1", f = "VideoDownloadClientV2.kt", i = {1}, l = {477, 480}, m = "invokeSuspend", n = {"videos"}, s = {"L$0"}, v = 1)
public final class VideoDownloadClientV2$handleServiceTimeout$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ VideoDownloadClientV2 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoDownloadClientV2$handleServiceTimeout$1(VideoDownloadClientV2 videoDownloadClientV2, Continuation<? super VideoDownloadClientV2$handleServiceTimeout$1> continuation) {
        super(2, continuation);
        this.this$0 = videoDownloadClientV2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new VideoDownloadClientV2$handleServiceTimeout$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x004a A[LOOP:0: B:12:0x0044->B:14:0x004a, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x007d A[LOOP:1: B:16:0x0077->B:18:0x007d, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00bf A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00c0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        DataStorageWrapper dataStorageWrapper;
        Object unDownloadVideos$default;
        List videos;
        DataStorageWrapper dataStorageWrapper2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                dataStorageWrapper = this.this$0.dataStorage;
                this.label = 1;
                unDownloadVideos$default = DataStorageWrapper.getUnDownloadVideos$default(dataStorageWrapper, false, true, 0, (Continuation) this, 4, null);
                if (unDownloadVideos$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
                videos = (List) unDownloadVideos$default;
                List $this$forEach$iv = videos;
                for (Object element$iv : $this$forEach$iv) {
                    OfflineVideoEntity it = (OfflineVideoEntity) element$iv;
                    it.setState(DataStorageWrapperKt.videoPauseState$default(it, null, 1, null));
                }
                IVBLog vBLog = LogKt.getVBLog();
                List $this$map$iv = videos;
                Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                for (Object item$iv$iv : $this$map$iv) {
                    destination$iv$iv.add(((OfflineVideoEntity) item$iv$iv).getKey());
                }
                vBLog.info("VideoDownloadClientV2 service timeout pause all " + ((List) destination$iv$iv));
                dataStorageWrapper2 = this.this$0.dataStorage;
                this.L$0 = SpillingKt.nullOutSpilledVariable(videos);
                this.label = 2;
                if (dataStorageWrapper2.updateVideos(videos, true, (Continuation) this) != coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            case 1:
                ResultKt.throwOnFailure($result);
                unDownloadVideos$default = $result;
                videos = (List) unDownloadVideos$default;
                List $this$forEach$iv2 = videos;
                while (r5.hasNext()) {
                }
                IVBLog vBLog2 = LogKt.getVBLog();
                List $this$map$iv2 = videos;
                Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
                while (r9.hasNext()) {
                }
                vBLog2.info("VideoDownloadClientV2 service timeout pause all " + ((List) destination$iv$iv2));
                dataStorageWrapper2 = this.this$0.dataStorage;
                this.L$0 = SpillingKt.nullOutSpilledVariable(videos);
                this.label = 2;
                if (dataStorageWrapper2.updateVideos(videos, true, (Continuation) this) != coroutine_suspended) {
                }
                break;
            case 2:
                List list = (List) this.L$0;
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}