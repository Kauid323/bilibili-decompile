package video.biz.offline.base.infra.download;

import java.util.ArrayList;
import java.util.List;
import kntr.base.utils.CoroutineExJvmKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.biz.offline.base.infra.utils.Config;
import video.biz.offline.base.infra.utils.DownloadLog;
import video.biz.offline.base.infra.utils.OfflineScopeKt;
import video.biz.offline.base.model.entity.OfflineVideoEntity;

/* compiled from: OperationPool.kt */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J&\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00072\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0080@¢\u0006\u0004\b\u0017\u0010\u0018J\u001c\u0010\u0019\u001a\u00020\u00122\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0015H\u0087@¢\u0006\u0002\u0010\u001cJ\u001e\u0010\u001d\u001a\u00020\u00122\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0087@¢\u0006\u0002\u0010\u001cJ\u000e\u0010\u001e\u001a\u00020\u0012H\u0087@¢\u0006\u0002\u0010\u001fJ\u0010\u0010 \u001a\u00020\f2\u0006\u0010!\u001a\u00020\u000bH\u0002J\u000e\u0010\"\u001a\u00020\u0012H\u0082@¢\u0006\u0002\u0010\u001fJ\u001c\u0010#\u001a\u00020\u00122\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0082@¢\u0006\u0002\u0010\u001cJ\u0016\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0080@¢\u0006\u0004\b%\u0010\u001fJ\u0010\u0010&\u001a\u00020\u0007H\u0080@¢\u0006\u0004\b'\u0010\u001fJ\u0010\u0010(\u001a\u00020\u00122\u0006\u0010!\u001a\u00020\u000bH\u0016J\u001c\u0010)\u001a\u00020\u00122\u0006\u0010!\u001a\u00020\u000b2\n\u0010*\u001a\u00060+j\u0002`,H\u0016J\u0016\u0010-\u001a\u00020\u00122\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0015H\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lvideo/biz/offline/base/infra/download/OperationPool;", "Lvideo/biz/offline/base/infra/download/IGroupStateChange;", "progressCallback", "Lvideo/biz/offline/base/infra/download/DownloadProgressCallback;", "<init>", "(Lvideo/biz/offline/base/infra/download/DownloadProgressCallback;)V", "maxConcurrent", "", "activeTasks", "", "Lkotlin/Pair;", "Lvideo/biz/offline/base/infra/download/TaskGroup;", "Lkotlinx/coroutines/Job;", "pendingTasks", "Lkotlin/collections/ArrayDeque;", "operationDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "setMaxConcurrent", "", "max", "keys", "", "", "setMaxConcurrent$infra_debug", "(ILjava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "add", "videos", "Lvideo/biz/offline/base/model/entity/OfflineVideoEntity;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "pause", "autoDownloadNext", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resolveJob", "group", "pauseAll", "pauseKeys", "downloadingKeys", "downloadingKeys$infra_debug", "currentTaskCount", "currentTaskCount$infra_debug", "onFinish", "onError", "error", "Ljava/lang/Exception;", "Lkotlin/Exception;", "updateDanmaku", "infra_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class OperationPool implements IGroupStateChange {
    public static final int $stable = 8;
    private final List<Pair<TaskGroup, Job>> activeTasks;
    private int maxConcurrent;
    private final CoroutineDispatcher operationDispatcher;
    private final ArrayDeque<TaskGroup> pendingTasks;
    private final DownloadProgressCallback progressCallback;

    public OperationPool(DownloadProgressCallback progressCallback) {
        Intrinsics.checkNotNullParameter(progressCallback, "progressCallback");
        this.progressCallback = progressCallback;
        this.maxConcurrent = Config.Companion.getMaxConcurrent();
        this.activeTasks = new ArrayList();
        this.pendingTasks = new ArrayDeque<>();
        this.operationDispatcher = CoroutineExJvmKt.getIoContext().limitedParallelism(1);
    }

    public final Object setMaxConcurrent$infra_debug(int max, List<String> list, Continuation<? super Unit> continuation) {
        this.maxConcurrent = max;
        Object withContext = BuildersKt.withContext(this.operationDispatcher, new OperationPool$setMaxConcurrent$2(list, this, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    public final Object add(List<OfflineVideoEntity> list, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(this.operationDispatcher, new OperationPool$add$2(list, this, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object pause$default(OperationPool operationPool, List list, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            list = CollectionsKt.emptyList();
        }
        return operationPool.pause(list, continuation);
    }

    public final Object pause(List<String> list, Continuation<? super Unit> continuation) {
        new DownloadLog("OperationPool").info("Pause task: " + list);
        if (list.isEmpty()) {
            Object pauseAll = pauseAll(continuation);
            return pauseAll == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? pauseAll : Unit.INSTANCE;
        }
        Object pauseKeys = pauseKeys(list, continuation);
        return pauseKeys == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? pauseKeys : Unit.INSTANCE;
    }

    public final Object autoDownloadNext(Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(this.operationDispatcher, new OperationPool$autoDownloadNext$2(this, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Job resolveJob(TaskGroup group) {
        new DownloadLog(group.getKey()).beginFlow();
        return BuildersKt.launch$default(OfflineScopeKt.getDownloadScope(), (CoroutineContext) null, (CoroutineStart) null, new OperationPool$resolveJob$1(group, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object pauseAll(Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(this.operationDispatcher, new OperationPool$pauseAll$2(this, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x006c A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object pauseKeys(List<String> list, Continuation<? super Unit> continuation) {
        OperationPool$pauseKeys$1 operationPool$pauseKeys$1;
        if (continuation instanceof OperationPool$pauseKeys$1) {
            operationPool$pauseKeys$1 = (OperationPool$pauseKeys$1) continuation;
            if ((operationPool$pauseKeys$1.label & Integer.MIN_VALUE) != 0) {
                operationPool$pauseKeys$1.label -= Integer.MIN_VALUE;
                Object $result = operationPool$pauseKeys$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (operationPool$pauseKeys$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        operationPool$pauseKeys$1.L$0 = SpillingKt.nullOutSpilledVariable(list);
                        operationPool$pauseKeys$1.label = 1;
                        if (BuildersKt.withContext(this.operationDispatcher, new OperationPool$pauseKeys$2(list, this, null), operationPool$pauseKeys$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        operationPool$pauseKeys$1.L$0 = SpillingKt.nullOutSpilledVariable(list);
                        operationPool$pauseKeys$1.label = 2;
                        if (autoDownloadNext(operationPool$pauseKeys$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    case 1:
                        list = (List) operationPool$pauseKeys$1.L$0;
                        ResultKt.throwOnFailure($result);
                        operationPool$pauseKeys$1.L$0 = SpillingKt.nullOutSpilledVariable(list);
                        operationPool$pauseKeys$1.label = 2;
                        if (autoDownloadNext(operationPool$pauseKeys$1) == coroutine_suspended) {
                        }
                        return Unit.INSTANCE;
                    case 2:
                        List list2 = (List) operationPool$pauseKeys$1.L$0;
                        ResultKt.throwOnFailure($result);
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        operationPool$pauseKeys$1 = new OperationPool$pauseKeys$1(this, continuation);
        Object $result2 = operationPool$pauseKeys$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (operationPool$pauseKeys$1.label) {
        }
    }

    public final Object downloadingKeys$infra_debug(Continuation<? super List<String>> continuation) {
        return BuildersKt.withContext(this.operationDispatcher, new OperationPool$downloadingKeys$2(this, null), continuation);
    }

    public final Object currentTaskCount$infra_debug(Continuation<? super Integer> continuation) {
        return BuildersKt.withContext(this.operationDispatcher, new OperationPool$currentTaskCount$2(this, null), continuation);
    }

    @Override // video.biz.offline.base.infra.download.IGroupStateChange
    public void onFinish(TaskGroup group) {
        Intrinsics.checkNotNullParameter(group, "group");
        BuildersKt.launch$default(OfflineScopeKt.getDownloadScope(), (CoroutineContext) null, (CoroutineStart) null, new OperationPool$onFinish$1(this, group, null), 3, (Object) null);
    }

    @Override // video.biz.offline.base.infra.download.IGroupStateChange
    public void onError(TaskGroup group, Exception error) {
        Intrinsics.checkNotNullParameter(group, "group");
        Intrinsics.checkNotNullParameter(error, "error");
        BuildersKt.launch$default(OfflineScopeKt.getDownloadScope(), (CoroutineContext) null, (CoroutineStart) null, new OperationPool$onError$1(this, group, null), 3, (Object) null);
    }

    public final void updateDanmaku(List<OfflineVideoEntity> list) {
        Intrinsics.checkNotNullParameter(list, "videos");
        new DownloadLog("OperationPool").info("update danmaku: " + list);
        List<OfflineVideoEntity> $this$forEach$iv = list;
        for (Object element$iv : $this$forEach$iv) {
            OfflineVideoEntity it = (OfflineVideoEntity) element$iv;
            TaskGroup group = new TaskGroup(it, this.progressCallback, this, null, 8, null);
            group.updateDanmaku();
        }
    }
}