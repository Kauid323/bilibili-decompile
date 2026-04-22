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
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.biz.offline.base.infra.utils.DownloadLog;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OperationPool.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "video.biz.offline.base.infra.download.OperationPool$autoDownloadNext$2", f = "OperationPool.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class OperationPool$autoDownloadNext$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ OperationPool this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OperationPool$autoDownloadNext$2(OperationPool operationPool, Continuation<? super OperationPool$autoDownloadNext$2> continuation) {
        super(2, continuation);
        this.this$0 = operationPool;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OperationPool$autoDownloadNext$2(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        int i;
        List list;
        Iterable iterable;
        Object obj;
        List list2;
        Job resolveJob;
        ArrayDeque arrayDeque;
        boolean canAutoNext;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                i = this.this$0.maxConcurrent;
                list = this.this$0.activeTasks;
                int excess = i - list.size();
                if (excess > 0) {
                    OperationPool operationPool = this.this$0;
                    for (int i2 = 0; i2 < excess; i2++) {
                        iterable = operationPool.pendingTasks;
                        Iterator it = iterable.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                obj = it.next();
                                TaskGroup it2 = (TaskGroup) obj;
                                canAutoNext = OperationPoolKt.getCanAutoNext(it2.getVideo());
                                if (canAutoNext) {
                                }
                            } else {
                                obj = null;
                            }
                        }
                        TaskGroup group = (TaskGroup) obj;
                        if (group != null) {
                            list2 = operationPool.activeTasks;
                            resolveJob = operationPool.resolveJob(group);
                            list2.add(new Pair(group, resolveJob));
                            arrayDeque = operationPool.pendingTasks;
                            Boxing.boxBoolean(arrayDeque.remove(group));
                        } else {
                            new DownloadLog("OperationPool").debug("No task can auto next");
                        }
                    }
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}