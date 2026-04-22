package video.biz.offline.base.facade.client;

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

/* compiled from: VideoDownloadClientV2.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "video.biz.offline.base.facade.client.VideoDownloadClientV2$callback$1$onUpdateVideo$1", f = "VideoDownloadClientV2.kt", i = {}, l = {74}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class VideoDownloadClientV2$callback$1$onUpdateVideo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $entryList;
    final /* synthetic */ boolean $forceUpdate;
    int label;
    final /* synthetic */ VideoDownloadClientV2 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoDownloadClientV2$callback$1$onUpdateVideo$1(VideoDownloadClientV2 videoDownloadClientV2, String str, boolean z, Continuation<? super VideoDownloadClientV2$callback$1$onUpdateVideo$1> continuation) {
        super(2, continuation);
        this.this$0 = videoDownloadClientV2;
        this.$entryList = str;
        this.$forceUpdate = z;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new VideoDownloadClientV2$callback$1$onUpdateVideo$1(this.this$0, this.$entryList, this.$forceUpdate, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object handleUpdateVideo;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                handleUpdateVideo = this.this$0.handleUpdateVideo(this.$entryList, this.$forceUpdate, (Continuation) this);
                if (handleUpdateVideo == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}