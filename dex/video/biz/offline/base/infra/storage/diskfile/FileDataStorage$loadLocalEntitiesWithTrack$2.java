package video.biz.offline.base.infra.storage.diskfile;

import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.base.utils.DateKt;
import video.biz.offline.base.infra.utils.DataLog;
import video.biz.offline.base.infra.utils.NeuronKt;
import video.biz.offline.base.infra.utils.OfflineNeuron;
import video.biz.offline.base.infra.utils.OfflineTrackType;
import video.biz.offline.base.model.entity.OfflineVideoEntity;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FileDataStorage.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lvideo/biz/offline/base/model/entity/OfflineVideoEntity;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "video.biz.offline.base.infra.storage.diskfile.FileDataStorage$loadLocalEntitiesWithTrack$2", f = "FileDataStorage.kt", i = {0}, l = {85}, m = "invokeSuspend", n = {"startTime"}, s = {"J$0"}, v = 1)
public final class FileDataStorage$loadLocalEntitiesWithTrack$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends OfflineVideoEntity>>, Object> {
    long J$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FileDataStorage$loadLocalEntitiesWithTrack$2(Continuation<? super FileDataStorage$loadLocalEntitiesWithTrack$2> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FileDataStorage$loadLocalEntitiesWithTrack$2(continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<OfflineVideoEntity>> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object obj;
        long startTime;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                long startTime2 = DateKt.getCurrentTimeMillis();
                this.J$0 = startTime2;
                this.label = 1;
                Object loadLocalEntities = DiskFileImpl_androidKt.loadLocalEntities((Continuation) this);
                if (loadLocalEntities == coroutine_suspended) {
                    return coroutine_suspended;
                }
                obj = loadLocalEntities;
                startTime = startTime2;
                break;
            case 1:
                startTime = this.J$0;
                ResultKt.throwOnFailure($result);
                obj = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        List entities = (List) obj;
        new DataLog().debug("load task files: " + entities);
        long endTime = DateKt.getCurrentTimeMillis();
        long costTime = endTime - startTime;
        new DataLog().loadTaskFiles(entities.size(), costTime);
        OfflineNeuron.Companion.trackT$default(OfflineNeuron.Companion, OfflineTrackType.LOADTASKFILE, MapsKt.mapOf(new Pair[]{TuplesKt.to(NeuronKt.EXTRA_VALUE1, String.valueOf(entities.size())), TuplesKt.to(NeuronKt.EXTRA_VALUE2, String.valueOf(costTime))}), null, 4, null);
        return entities;
    }
}