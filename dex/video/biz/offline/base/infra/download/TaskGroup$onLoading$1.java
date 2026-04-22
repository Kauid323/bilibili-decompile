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

/* compiled from: TaskGroup.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "video.biz.offline.base.infra.download.TaskGroup$onLoading$1", f = "TaskGroup.kt", i = {1}, l = {197, 200}, m = "invokeSuspend", n = {"complete"}, s = {"I$0"}, v = 1)
final class TaskGroup$onLoading$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int I$0;
    int label;
    final /* synthetic */ TaskGroup this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskGroup$onLoading$1(TaskGroup taskGroup, Continuation<? super TaskGroup$onLoading$1> continuation) {
        super(2, continuation);
        this.this$0 = taskGroup;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TaskGroup$onLoading$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object updateStateDeprecated;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (Config.Companion.getHitTaskTrustFinishOnly()) {
                    this.label = 1;
                    if (TaskGroup.updateState$default(this.this$0, false, (Continuation) this, 1, null) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    int i = this.this$0.getVideo().getDownloadedSize() == this.this$0.getVideo().getTotalSize() ? 1 : 0;
                    TaskGroup taskGroup = this.this$0;
                    boolean z = i != 0;
                    this.I$0 = i;
                    this.label = 2;
                    updateStateDeprecated = taskGroup.updateStateDeprecated(z, (Continuation) this);
                    if (updateStateDeprecated != coroutine_suspended) {
                        break;
                    } else {
                        return coroutine_suspended;
                    }
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            case 2:
                int i2 = this.I$0;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}