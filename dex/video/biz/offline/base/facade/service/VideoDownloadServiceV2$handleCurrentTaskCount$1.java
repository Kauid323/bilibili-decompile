package video.biz.offline.base.facade.service;

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
import video.base.log.LogKt;
import video.biz.offline.base.infra.download.OperationDispatcher;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VideoDownloadServiceV2.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "video.biz.offline.base.facade.service.VideoDownloadServiceV2$handleCurrentTaskCount$1", f = "VideoDownloadServiceV2.kt", i = {}, l = {237}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class VideoDownloadServiceV2$handleCurrentTaskCount$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Integer>, Object> {
    int label;
    final /* synthetic */ VideoDownloadServiceV2 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoDownloadServiceV2$handleCurrentTaskCount$1(VideoDownloadServiceV2 videoDownloadServiceV2, Continuation<? super VideoDownloadServiceV2$handleCurrentTaskCount$1> continuation) {
        super(2, continuation);
        this.this$0 = videoDownloadServiceV2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new VideoDownloadServiceV2$handleCurrentTaskCount$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Integer> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        OperationDispatcher operationDispatcher;
        Object currentTaskCount;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                operationDispatcher = this.this$0.dispatcher;
                this.label = 1;
                currentTaskCount = operationDispatcher.currentTaskCount((Continuation) this);
                if (currentTaskCount == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                currentTaskCount = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        int it = ((Number) currentTaskCount).intValue();
        LogKt.getVBLog().info("VideoDownloadServiceV2 handleCurrentTaskCount  count: " + it);
        return currentTaskCount;
    }
}