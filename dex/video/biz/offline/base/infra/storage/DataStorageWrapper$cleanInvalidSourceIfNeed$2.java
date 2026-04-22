package video.biz.offline.base.infra.storage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
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
import video.base.utils.DateKt;
import video.biz.offline.base.infra.utils.DataLog;
import video.biz.offline.base.model.entity.OfflineVideoEntity;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DataStorageWrapper.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "video.biz.offline.base.infra.storage.DataStorageWrapper$cleanInvalidSourceIfNeed$2", f = "DataStorageWrapper.kt", i = {}, l = {228}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class DataStorageWrapper$cleanInvalidSourceIfNeed$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DataStorageWrapper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DataStorageWrapper$cleanInvalidSourceIfNeed$2(DataStorageWrapper dataStorageWrapper, Continuation<? super DataStorageWrapper$cleanInvalidSourceIfNeed$2> continuation) {
        super(2, continuation);
        this.this$0 = dataStorageWrapper;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DataStorageWrapper$cleanInvalidSourceIfNeed$2(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        boolean migrationCompleted;
        boolean cleanInvalidSourceIfNeed$canDeleteInvalidFile;
        Object allVideos;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        boolean z = true;
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                migrationCompleted = this.this$0.migrationCompleted();
                if (!migrationCompleted) {
                    return Unit.INSTANCE;
                }
                cleanInvalidSourceIfNeed$canDeleteInvalidFile = DataStorageWrapper.cleanInvalidSourceIfNeed$canDeleteInvalidFile();
                if (!cleanInvalidSourceIfNeed$canDeleteInvalidFile) {
                    return Unit.INSTANCE;
                }
                this.label = 1;
                allVideos = this.this$0.getAllVideos((Continuation) this);
                if (allVideos == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                allVideos = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Iterable allVideos2 = (List) allVideos;
        Iterable $this$any$iv = allVideos2;
        if (($this$any$iv instanceof Collection) && ((Collection) $this$any$iv).isEmpty()) {
            z = false;
        } else {
            Iterator it = $this$any$iv.iterator();
            while (true) {
                if (it.hasNext()) {
                    Object element$iv = it.next();
                    OfflineVideoEntity it2 = (OfflineVideoEntity) element$iv;
                    if (it2.isDownloading()) {
                    }
                } else {
                    z = false;
                }
            }
        }
        boolean hasDownloading = z;
        if (hasDownloading) {
            return Unit.INSTANCE;
        }
        Iterable $this$map$iv = allVideos2;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            OfflineVideoEntity it3 = (OfflineVideoEntity) item$iv$iv;
            destination$iv$iv.add(it3.getKey());
        }
        Set allKeys = CollectionsKt.toSet((List) destination$iv$iv);
        new DataLog().info("deleteInvalidFileMap start checkAndRemoveTaskFile allKeys size " + allKeys);
        long snapshotTime = DateKt.getCurrentTimeMillis();
        DataStorageWrapper_androidKt.cleanInvalidSource(allKeys, snapshotTime);
        return Unit.INSTANCE;
    }
}