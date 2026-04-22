package video.biz.offline.base.infra.download;

import java.util.List;
import kotlin.Metadata;
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
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OperationPool.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "video.biz.offline.base.infra.download.OperationPool$currentTaskCount$2", f = "OperationPool.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class OperationPool$currentTaskCount$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Integer>, Object> {
    int label;
    final /* synthetic */ OperationPool this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OperationPool$currentTaskCount$2(OperationPool operationPool, Continuation<? super OperationPool$currentTaskCount$2> continuation) {
        super(2, continuation);
        this.this$0 = operationPool;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OperationPool$currentTaskCount$2(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Integer> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        List list;
        ArrayDeque arrayDeque;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                list = this.this$0.activeTasks;
                int size = list.size();
                arrayDeque = this.this$0.pendingTasks;
                return Boxing.boxInt(size + arrayDeque.size());
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}