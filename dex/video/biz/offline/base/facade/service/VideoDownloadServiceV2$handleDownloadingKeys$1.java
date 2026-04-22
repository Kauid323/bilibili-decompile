package video.biz.offline.base.facade.service;

import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import video.base.log.LogKt;
import video.biz.offline.base.infra.download.OperationDispatcher;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VideoDownloadServiceV2.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "video.biz.offline.base.facade.service.VideoDownloadServiceV2$handleDownloadingKeys$1", f = "VideoDownloadServiceV2.kt", i = {}, l = {IjkMediaMeta.FF_PROFILE_H264_HIGH_444_PREDICTIVE}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class VideoDownloadServiceV2$handleDownloadingKeys$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends String>>, Object> {
    int label;
    final /* synthetic */ VideoDownloadServiceV2 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoDownloadServiceV2$handleDownloadingKeys$1(VideoDownloadServiceV2 videoDownloadServiceV2, Continuation<? super VideoDownloadServiceV2$handleDownloadingKeys$1> continuation) {
        super(2, continuation);
        this.this$0 = videoDownloadServiceV2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new VideoDownloadServiceV2$handleDownloadingKeys$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<String>> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        OperationDispatcher operationDispatcher;
        Object downloadingKeys;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                operationDispatcher = this.this$0.dispatcher;
                this.label = 1;
                downloadingKeys = operationDispatcher.downloadingKeys((Continuation) this);
                if (downloadingKeys == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                downloadingKeys = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        List it = (List) downloadingKeys;
        LogKt.getVBLog().info("VideoDownloadServiceV2 handleDownloadingKeys keys: " + it);
        return downloadingKeys;
    }
}