package video.biz.offline.base.infra.download;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.biz.offline.base.infra.utils.Config;
import video.biz.offline.base.infra.utils.OfflineScopeKt;
import video.biz.offline.base.model.entity.OfflineVideoEntity;

/* compiled from: OperationDispatcher.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0087@¢\u0006\u0002\u0010\rJ\u001e\u0010\u000e\u001a\u00020\t2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u000bH\u0087@¢\u0006\u0002\u0010\rJ\u0014\u0010\u0011\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bJ$\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00142\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u000bH\u0087@¢\u0006\u0002\u0010\u0015J\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00100\u000bH\u0087@¢\u0006\u0002\u0010\u0017J\u000e\u0010\u0018\u001a\u00020\u0014H\u0087@¢\u0006\u0002\u0010\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lvideo/biz/offline/base/infra/download/OperationDispatcher;", "", "progressCallback", "Lvideo/biz/offline/base/infra/download/DownloadProgressCallback;", "<init>", "(Lvideo/biz/offline/base/infra/download/DownloadProgressCallback;)V", "operationPool", "Lvideo/biz/offline/base/infra/download/OperationPool;", "addDownload", "", "videos", "", "Lvideo/biz/offline/base/model/entity/OfflineVideoEntity;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "pause", "keys", "", "updateDanmaku", "setMaxConcurrent", "max", "", "(ILjava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "downloadingKeys", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "currentTaskCount", "infra_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class OperationDispatcher {
    public static final int $stable = 8;
    private final OperationPool operationPool;
    private final DownloadProgressCallback progressCallback;

    public OperationDispatcher(DownloadProgressCallback progressCallback) {
        Intrinsics.checkNotNullParameter(progressCallback, "progressCallback");
        this.progressCallback = progressCallback;
        this.operationPool = new OperationPool(this.progressCallback);
    }

    public final Object addDownload(List<OfflineVideoEntity> list, Continuation<? super Unit> continuation) {
        Object add = this.operationPool.add(list, continuation);
        return add == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? add : Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object pause$default(OperationDispatcher operationDispatcher, List list, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            list = CollectionsKt.emptyList();
        }
        return operationDispatcher.pause(list, continuation);
    }

    public final Object pause(List<String> list, Continuation<? super Unit> continuation) {
        Object pause = this.operationPool.pause(list, continuation);
        return pause == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? pause : Unit.INSTANCE;
    }

    public final void updateDanmaku(List<OfflineVideoEntity> list) {
        Intrinsics.checkNotNullParameter(list, "videos");
        BuildersKt.launch$default(OfflineScopeKt.getDownloadScope(), (CoroutineContext) null, (CoroutineStart) null, new OperationDispatcher$updateDanmaku$1(this, list, null), 3, (Object) null);
    }

    public final Object setMaxConcurrent(int max, List<String> list, Continuation<? super Unit> continuation) {
        Config.Companion.setMaxConcurrent(max);
        Object maxConcurrent$infra_debug = this.operationPool.setMaxConcurrent$infra_debug(max, list, continuation);
        return maxConcurrent$infra_debug == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? maxConcurrent$infra_debug : Unit.INSTANCE;
    }

    public final Object downloadingKeys(Continuation<? super List<String>> continuation) {
        return this.operationPool.downloadingKeys$infra_debug(continuation);
    }

    public final Object currentTaskCount(Continuation<? super Integer> continuation) {
        return this.operationPool.currentTaskCount$infra_debug(continuation);
    }
}