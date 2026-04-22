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
import video.biz.offline.base.infra.storage.DataStorageWrapper;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VideoDownloadClientV2.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "video.biz.offline.base.facade.client.VideoDownloadClientV2$resetAndMigrate$1", f = "VideoDownloadClientV2.kt", i = {}, l = {488}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class VideoDownloadClientV2$resetAndMigrate$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ VideoDownloadClientV2 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoDownloadClientV2$resetAndMigrate$1(VideoDownloadClientV2 videoDownloadClientV2, Continuation<? super VideoDownloadClientV2$resetAndMigrate$1> continuation) {
        super(2, continuation);
        this.this$0 = videoDownloadClientV2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new VideoDownloadClientV2$resetAndMigrate$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        DataStorageWrapper dataStorageWrapper;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.this$0.resetMigrate();
                dataStorageWrapper = this.this$0.dataStorage;
                this.label = 1;
                if (dataStorageWrapper.init((Continuation) this) == coroutine_suspended) {
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