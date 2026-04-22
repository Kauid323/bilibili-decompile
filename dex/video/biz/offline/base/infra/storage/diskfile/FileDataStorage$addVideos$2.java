package video.biz.offline.base.infra.storage.diskfile;

import java.util.List;
import java.util.Map;
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
import tv.danmaku.biliplayerv2.service.setting.Player;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.biz.offline.base.infra.storage.diskfile.model.DramaGroupModel;
import video.biz.offline.base.model.entity.OfflineVideoEntity;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FileDataStorage.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "video.biz.offline.base.infra.storage.diskfile.FileDataStorage$addVideos$2", f = "FileDataStorage.kt", i = {}, l = {124, Player.PLAYER_QUALITY_HDR}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class FileDataStorage$addVideos$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Map<Long, DramaGroupModel> $dramas;
    final /* synthetic */ List<OfflineVideoEntity> $videos;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileDataStorage$addVideos$2(List<OfflineVideoEntity> list, Map<Long, DramaGroupModel> map, Continuation<? super FileDataStorage$addVideos$2> continuation) {
        super(2, continuation);
        this.$videos = list;
        this.$dramas = map;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FileDataStorage$addVideos$2(this.$videos, this.$dramas, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0043 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                if (DiskFileImpl_androidKt.writeTaskToDisk(this.$videos, (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                this.label = 2;
                if (DiskFileImpl_androidKt.writeDramaToDisk(CollectionsKt.toList(this.$dramas.values()), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            case 1:
                ResultKt.throwOnFailure($result);
                this.label = 2;
                if (DiskFileImpl_androidKt.writeDramaToDisk(CollectionsKt.toList(this.$dramas.values()), (Continuation) this) == coroutine_suspended) {
                }
                return Unit.INSTANCE;
            case 2:
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}