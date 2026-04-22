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
import video.biz.offline.base.facade.client.IOfflineClient;
import video.biz.offline.base.facade.notification.OfflineNotificationHelper;
import video.biz.offline.base.infra.download.OperationDispatcher;

/* compiled from: VideoDownloadServiceV2.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "video.biz.offline.base.facade.service.VideoDownloadServiceV2$onTimeout$1", f = "VideoDownloadServiceV2.kt", i = {}, l = {167, 168}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class VideoDownloadServiceV2$onTimeout$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $fgsType;
    final /* synthetic */ int $startId;
    int label;
    final /* synthetic */ VideoDownloadServiceV2 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoDownloadServiceV2$onTimeout$1(VideoDownloadServiceV2 videoDownloadServiceV2, int i, int i2, Continuation<? super VideoDownloadServiceV2$onTimeout$1> continuation) {
        super(2, continuation);
        this.this$0 = videoDownloadServiceV2;
        this.$startId = i;
        this.$fgsType = i2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new VideoDownloadServiceV2$onTimeout$1(this.this$0, this.$startId, this.$fgsType, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:1|2|21|(3:23|(1:25)|7)|8|9|10|(0)|14|15) */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0074, code lost:
        r1 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0075, code lost:
        video.base.log.LogKt.getVBLog().error("VideoDownloadServiceV2 unexpected exception in clientProxy call: " + r1.getMessage(), r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0097, code lost:
        r1 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0098, code lost:
        video.base.log.LogKt.getVBLog().error("VideoDownloadServiceV2 remoteException in clientProxy call : " + r1.getMessage(), r1);
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x006c A[Catch: Exception -> 0x0074, RemoteException -> 0x0097, TRY_LEAVE, TryCatch #2 {RemoteException -> 0x0097, Exception -> 0x0074, blocks: (B:18:0x0066, B:20:0x006c), top: B:28:0x0066 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        OperationDispatcher operationDispatcher;
        Object currentTaskCount;
        OperationDispatcher operationDispatcher2;
        OfflineNotificationHelper notificationHelper;
        IOfflineClient $this$invokeSuspend_u24lambda_u240;
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
            case 2:
                ResultKt.throwOnFailure($result);
                LogKt.getVBLog().info("VideoDownloadServiceV2 timeout, stop all download entries");
                notificationHelper = this.this$0.getNotificationHelper();
                notificationHelper.release();
                VideoDownloadServiceV2 this_$iv = this.this$0;
                int i = this.$startId;
                int i2 = this.$fgsType;
                $this$invokeSuspend_u24lambda_u240 = this_$iv.clientProxy;
                if ($this$invokeSuspend_u24lambda_u240 != null) {
                    $this$invokeSuspend_u24lambda_u240.onServiceTimeout(i, i2);
                    Unit unit = Unit.INSTANCE;
                }
                LogKt.getVBLog().info("VideoDownloadServiceV2 timeout, stop self");
                this.this$0.stopSelf(this.$startId);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (((Number) currentTaskCount).intValue() > 0) {
            operationDispatcher2 = this.this$0.dispatcher;
            this.label = 2;
            if (OperationDispatcher.pause$default(operationDispatcher2, null, (Continuation) this, 1, null) == coroutine_suspended) {
                return coroutine_suspended;
            }
            LogKt.getVBLog().info("VideoDownloadServiceV2 timeout, stop all download entries");
        }
        notificationHelper = this.this$0.getNotificationHelper();
        notificationHelper.release();
        VideoDownloadServiceV2 this_$iv2 = this.this$0;
        int i3 = this.$startId;
        int i22 = this.$fgsType;
        $this$invokeSuspend_u24lambda_u240 = this_$iv2.clientProxy;
        if ($this$invokeSuspend_u24lambda_u240 != null) {
        }
        LogKt.getVBLog().info("VideoDownloadServiceV2 timeout, stop self");
        this.this$0.stopSelf(this.$startId);
        return Unit.INSTANCE;
    }
}