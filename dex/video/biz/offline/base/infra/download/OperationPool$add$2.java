package video.biz.offline.base.infra.download;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.biz.offline.base.infra.utils.DownloadLog;
import video.biz.offline.base.model.entity.OfflineVideoEntity;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OperationPool.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "video.biz.offline.base.infra.download.OperationPool$add$2", f = "OperationPool.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class OperationPool$add$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<OfflineVideoEntity> $videos;
    int label;
    final /* synthetic */ OperationPool this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OperationPool$add$2(List<OfflineVideoEntity> list, OperationPool operationPool, Continuation<? super OperationPool$add$2> continuation) {
        super(2, continuation);
        this.$videos = list;
        this.this$0 = operationPool;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OperationPool$add$2(this.$videos, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object invokeSuspend(Object $result) {
        List list;
        Object obj;
        Iterable iterable;
        TaskGroup taskGroup;
        DownloadProgressCallback downloadProgressCallback;
        List list2;
        int i;
        List list3;
        Job resolveJob;
        ArrayDeque arrayDeque;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Iterable $this$forEach$iv = this.$videos;
                OperationPool operationPool = this.this$0;
                for (Object element$iv : $this$forEach$iv) {
                    OfflineVideoEntity video2 = (OfflineVideoEntity) element$iv;
                    list = operationPool.activeTasks;
                    Iterator it = list.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            obj = it.next();
                            Pair it2 = (Pair) obj;
                            if (Intrinsics.areEqual(((TaskGroup) it2.getFirst()).getKey(), video2.getKey())) {
                            }
                        } else {
                            obj = null;
                        }
                    }
                    Pair pair = (Pair) obj;
                    TaskGroup group = pair != null ? (TaskGroup) pair.getFirst() : null;
                    if (group == null) {
                        iterable = operationPool.pendingTasks;
                        Iterator it3 = iterable.iterator();
                        while (true) {
                            if (it3.hasNext()) {
                                Object next = it3.next();
                                TaskGroup it4 = (TaskGroup) next;
                                taskGroup = Intrinsics.areEqual(it4.getKey(), video2.getKey()) ? next : null;
                            }
                        }
                        TaskGroup group2 = taskGroup;
                        if (group2 == null) {
                            downloadProgressCallback = operationPool.progressCallback;
                            TaskGroup group3 = new TaskGroup(video2, downloadProgressCallback, operationPool, null, 8, null);
                            list2 = operationPool.activeTasks;
                            int size = list2.size();
                            i = operationPool.maxConcurrent;
                            if (size < i) {
                                new DownloadLog(group3.getKey()).add(false);
                                list3 = operationPool.activeTasks;
                                resolveJob = operationPool.resolveJob(group3);
                                list3.add(new Pair(group3, resolveJob));
                            } else {
                                new DownloadLog(group3.getKey()).add(true);
                                arrayDeque = operationPool.pendingTasks;
                                arrayDeque.add(group3);
                            }
                        } else {
                            new DownloadLog(group2.getKey()).info("TaskGroup already exists in pending");
                        }
                    } else {
                        new DownloadLog(group.getKey()).info("TaskGroup already exists");
                    }
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}