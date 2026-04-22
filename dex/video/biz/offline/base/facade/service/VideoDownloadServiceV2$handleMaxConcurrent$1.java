package video.biz.offline.base.facade.service;

import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "video.biz.offline.base.facade.service.VideoDownloadServiceV2$handleMaxConcurrent$1", f = "VideoDownloadServiceV2.kt", i = {}, l = {230}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class VideoDownloadServiceV2$handleMaxConcurrent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<String> $keys;
    final /* synthetic */ int $maxConcurrent;
    int label;
    final /* synthetic */ VideoDownloadServiceV2 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoDownloadServiceV2$handleMaxConcurrent$1(VideoDownloadServiceV2 videoDownloadServiceV2, int i, List<String> list, Continuation<? super VideoDownloadServiceV2$handleMaxConcurrent$1> continuation) {
        super(2, continuation);
        this.this$0 = videoDownloadServiceV2;
        this.$maxConcurrent = i;
        this.$keys = list;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new VideoDownloadServiceV2$handleMaxConcurrent$1(this.this$0, this.$maxConcurrent, this.$keys, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        OperationDispatcher operationDispatcher;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                operationDispatcher = this.this$0.dispatcher;
                int i = this.$maxConcurrent;
                List<String> list = this.$keys;
                if (list == null) {
                    list = CollectionsKt.emptyList();
                }
                this.label = 1;
                if (operationDispatcher.setMaxConcurrent(i, list, (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        LogKt.getVBLog().info("VideoDownloadServiceV2 setMaxConcurrent complete");
        return Unit.INSTANCE;
    }
}