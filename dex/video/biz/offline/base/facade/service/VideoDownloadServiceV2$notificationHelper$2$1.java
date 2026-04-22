package video.biz.offline.base.facade.service;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.biz.offline.base.infra.download.OperationDispatcher;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VideoDownloadServiceV2.kt */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "video.biz.offline.base.facade.service.VideoDownloadServiceV2$notificationHelper$2$1", f = "VideoDownloadServiceV2.kt", i = {}, l = {124}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class VideoDownloadServiceV2$notificationHelper$2$1 extends SuspendLambda implements Function1<Continuation<? super Boolean>, Object> {
    int label;
    final /* synthetic */ VideoDownloadServiceV2 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoDownloadServiceV2$notificationHelper$2$1(VideoDownloadServiceV2 videoDownloadServiceV2, Continuation<? super VideoDownloadServiceV2$notificationHelper$2$1> continuation) {
        super(1, continuation);
        this.this$0 = videoDownloadServiceV2;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new VideoDownloadServiceV2$notificationHelper$2$1(this.this$0, continuation);
    }

    public final Object invoke(Continuation<? super Boolean> continuation) {
        return create(continuation).invokeSuspend(Unit.INSTANCE);
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
        return Boxing.boxBoolean(((Number) currentTaskCount).intValue() <= 0);
    }
}