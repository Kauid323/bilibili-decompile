package video.biz.offline.base.infra.download;

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
import video.biz.offline.base.infra.utils.Config;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TaskGroup.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "video.biz.offline.base.infra.download.TaskGroup$startTasks$4", f = "TaskGroup.kt", i = {}, l = {167, 169}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class TaskGroup$startTasks$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ TaskGroup this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskGroup$startTasks$4(TaskGroup taskGroup, Continuation<? super TaskGroup$startTasks$4> continuation) {
        super(2, continuation);
        this.this$0 = taskGroup;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TaskGroup$startTasks$4(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object updateStateDeprecated;
        Object updateState;
        IGroupStateChange iGroupStateChange;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (Config.Companion.getHitTaskTrustFinishOnly()) {
                    this.label = 1;
                    updateState = this.this$0.updateState(true, (Continuation) this);
                    if (updateState == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    this.label = 2;
                    updateStateDeprecated = this.this$0.updateStateDeprecated(true, (Continuation) this);
                    if (updateStateDeprecated == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            case 2:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        iGroupStateChange = this.this$0.delegate;
        if (iGroupStateChange != null) {
            iGroupStateChange.onFinish(this.this$0);
        }
        return Unit.INSTANCE;
    }
}