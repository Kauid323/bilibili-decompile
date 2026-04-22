package video.biz.offline.base.facade.client;

import android.os.RemoteException;
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
import kotlinx.serialization.StringFormat;
import kotlinx.serialization.internal.ArrayListSerializer;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.base.log.LogKt;
import video.biz.offline.base.facade.service.IOfflineService;
import video.biz.offline.base.infra.storage.DataStorageWrapper;
import video.biz.offline.base.infra.utils.EntryScannerKt;
import video.biz.offline.base.model.entity.OfflineVideoEntity;

/* compiled from: VideoDownloadClientV2.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "video.biz.offline.base.facade.client.VideoDownloadClientV2$updateDanmaku$1", f = "VideoDownloadClientV2.kt", i = {1}, l = {422, 423}, m = "invokeSuspend", n = {"list"}, s = {"L$0"}, v = 1)
final class VideoDownloadClientV2$updateDanmaku$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<String> $keys;
    Object L$0;
    int label;
    final /* synthetic */ VideoDownloadClientV2 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoDownloadClientV2$updateDanmaku$1(VideoDownloadClientV2 videoDownloadClientV2, List<String> list, Continuation<? super VideoDownloadClientV2$updateDanmaku$1> continuation) {
        super(2, continuation);
        this.this$0 = videoDownloadClientV2;
        this.$keys = list;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new VideoDownloadClientV2$updateDanmaku$1(this.this$0, this.$keys, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0048 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0054 A[Catch: Exception -> 0x0078, RemoteException -> 0x009b, TRY_LEAVE, TryCatch #2 {RemoteException -> 0x009b, Exception -> 0x0078, blocks: (B:16:0x004e, B:18:0x0054), top: B:26:0x004e }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        DataStorageWrapper dataStorageWrapper;
        Object videosByKeys;
        Object checkBind;
        List list;
        IOfflineService $this$invokeSuspend_u24lambda_u240;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                dataStorageWrapper = this.this$0.dataStorage;
                this.label = 1;
                videosByKeys = dataStorageWrapper.getVideosByKeys(this.$keys, (Continuation) this);
                if (videosByKeys == coroutine_suspended) {
                    return coroutine_suspended;
                }
                List list2 = (List) videosByKeys;
                this.L$0 = list2;
                this.label = 2;
                checkBind = this.this$0.checkBind((Continuation) this);
                if (checkBind != coroutine_suspended) {
                    return coroutine_suspended;
                }
                list = list2;
                VideoDownloadClientV2 this_$iv = this.this$0;
                try {
                    $this$invokeSuspend_u24lambda_u240 = this_$iv.getServiceProxy();
                    if ($this$invokeSuspend_u24lambda_u240 != null) {
                        StringFormat $this$encodeToString$iv = EntryScannerKt.getOfflineJson();
                        List value$iv = list;
                        $this$encodeToString$iv.getSerializersModule();
                        $this$invokeSuspend_u24lambda_u240.updateDanmaku($this$encodeToString$iv.encodeToString(new ArrayListSerializer(OfflineVideoEntity.Companion.serializer()), value$iv));
                        Unit unit = Unit.INSTANCE;
                    }
                } catch (RemoteException e$iv) {
                    LogKt.getVBLog().error("RemoteException in serviceProxy call : " + e$iv.getMessage(), e$iv);
                } catch (Exception e$iv2) {
                    LogKt.getVBLog().error("Unexpected exception in serviceProxy call: " + e$iv2.getMessage(), e$iv2);
                }
                return Unit.INSTANCE;
            case 1:
                ResultKt.throwOnFailure($result);
                videosByKeys = $result;
                List list22 = (List) videosByKeys;
                this.L$0 = list22;
                this.label = 2;
                checkBind = this.this$0.checkBind((Continuation) this);
                if (checkBind != coroutine_suspended) {
                }
                break;
            case 2:
                list = (List) this.L$0;
                ResultKt.throwOnFailure($result);
                VideoDownloadClientV2 this_$iv2 = this.this$0;
                $this$invokeSuspend_u24lambda_u240 = this_$iv2.getServiceProxy();
                if ($this$invokeSuspend_u24lambda_u240 != null) {
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}