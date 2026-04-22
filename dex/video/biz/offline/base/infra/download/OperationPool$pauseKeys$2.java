package video.biz.offline.base.infra.download;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OperationPool.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "video.biz.offline.base.infra.download.OperationPool$pauseKeys$2", f = "OperationPool.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class OperationPool$pauseKeys$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<String> $keys;
    int label;
    final /* synthetic */ OperationPool this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OperationPool$pauseKeys$2(List<String> list, OperationPool operationPool, Continuation<? super OperationPool$pauseKeys$2> continuation) {
        super(2, continuation);
        this.$keys = list;
        this.this$0 = operationPool;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OperationPool$pauseKeys$2(this.$keys, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        List list;
        List list2;
        Object obj;
        List list3;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Iterable $this$forEach$iv = this.$keys;
                OperationPool operationPool = this.this$0;
                for (Object element$iv : $this$forEach$iv) {
                    final String key = (String) element$iv;
                    list = operationPool.pendingTasks;
                    CollectionsKt.removeAll(list, new Function1() { // from class: video.biz.offline.base.infra.download.OperationPool$pauseKeys$2$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj2) {
                            boolean invokeSuspend$lambda$0$0;
                            invokeSuspend$lambda$0$0 = OperationPool$pauseKeys$2.invokeSuspend$lambda$0$0(key, (TaskGroup) obj2);
                            return Boolean.valueOf(invokeSuspend$lambda$0$0);
                        }
                    });
                    list2 = operationPool.activeTasks;
                    Iterator it = list2.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            obj = it.next();
                            Pair it2 = (Pair) obj;
                            if (Intrinsics.areEqual(((TaskGroup) it2.getFirst()).getKey(), key)) {
                            }
                        } else {
                            obj = null;
                        }
                    }
                    Pair task = (Pair) obj;
                    if (task != null) {
                        ((TaskGroup) task.getFirst()).cancel();
                        if (((Job) task.getSecond()).isActive()) {
                            Job.DefaultImpls.cancel$default((Job) task.getSecond(), (CancellationException) null, 1, (Object) null);
                        }
                        list3 = operationPool.activeTasks;
                        CollectionsKt.removeAll(list3, new Function1() { // from class: video.biz.offline.base.infra.download.OperationPool$pauseKeys$2$$ExternalSyntheticLambda1
                            public final Object invoke(Object obj2) {
                                boolean invokeSuspend$lambda$0$2$0;
                                invokeSuspend$lambda$0$2$0 = OperationPool$pauseKeys$2.invokeSuspend$lambda$0$2$0(key, (Pair) obj2);
                                return Boolean.valueOf(invokeSuspend$lambda$0$2$0);
                            }
                        });
                    }
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean invokeSuspend$lambda$0$0(String $key, TaskGroup it) {
        return Intrinsics.areEqual(it.getKey(), $key);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean invokeSuspend$lambda$0$2$0(String $key, Pair it) {
        return Intrinsics.areEqual(((TaskGroup) it.getFirst()).getKey(), $key);
    }
}