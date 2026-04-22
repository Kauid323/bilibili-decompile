package video.biz.offline.base.infra.storage.diskfile;

import java.util.Map;
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
import video.base.utils.DateKt;
import video.biz.offline.base.infra.storage.diskfile.model.DramaGroupModel;
import video.biz.offline.base.infra.utils.DataLog;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FileDataStorage.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "", "Lvideo/biz/offline/base/infra/storage/diskfile/model/DramaGroupModel;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "video.biz.offline.base.infra.storage.diskfile.FileDataStorage$loadLocalDramasWithTrack$2", f = "FileDataStorage.kt", i = {0}, l = {105}, m = "invokeSuspend", n = {"startTime"}, s = {"J$0"}, v = 1)
public final class FileDataStorage$loadLocalDramasWithTrack$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Map<Long, ? extends DramaGroupModel>>, Object> {
    long J$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FileDataStorage$loadLocalDramasWithTrack$2(Continuation<? super FileDataStorage$loadLocalDramasWithTrack$2> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FileDataStorage$loadLocalDramasWithTrack$2(continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Map<Long, DramaGroupModel>> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object loadLocalDrama;
        long startTime;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                long startTime2 = DateKt.getCurrentTimeMillis();
                this.J$0 = startTime2;
                this.label = 1;
                loadLocalDrama = DiskFileImpl_androidKt.loadLocalDrama((Continuation) this);
                if (loadLocalDrama == coroutine_suspended) {
                    return coroutine_suspended;
                }
                startTime = startTime2;
                break;
            case 1:
                startTime = this.J$0;
                ResultKt.throwOnFailure($result);
                loadLocalDrama = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Map dramas = (Map) loadLocalDrama;
        new DataLog().info("load drama files: " + dramas);
        long endTime = DateKt.getCurrentTimeMillis();
        long costTime = endTime - startTime;
        new DataLog().loadDramaFiles(dramas.size(), costTime);
        return dramas;
    }
}