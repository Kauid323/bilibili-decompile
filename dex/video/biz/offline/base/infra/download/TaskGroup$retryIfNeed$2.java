package video.biz.offline.base.infra.download;

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

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TaskGroup.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "video.biz.offline.base.infra.download.TaskGroup$retryIfNeed$2", f = "TaskGroup.kt", i = {}, l = {345}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class TaskGroup$retryIfNeed$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Exception $error;
    int label;
    final /* synthetic */ TaskGroup this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskGroup$retryIfNeed$2(TaskGroup taskGroup, Exception exc, Continuation<? super TaskGroup$retryIfNeed$2> continuation) {
        super(2, continuation);
        this.this$0 = taskGroup;
        this.$error = exc;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TaskGroup$retryIfNeed$2(this.this$0, this.$error, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        DownloadProgressCallback downloadProgressCallback;
        IGroupStateChange iGroupStateChange;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                downloadProgressCallback = this.this$0.progressCallback;
                if (downloadProgressCallback != null) {
                    this.label = 1;
                    if (downloadProgressCallback.updateVideo(CollectionsKt.listOf(this.this$0.getVideo()), true, (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        iGroupStateChange = this.this$0.delegate;
        if (iGroupStateChange != null) {
            iGroupStateChange.onError(this.this$0, this.$error);
        }
        return Unit.INSTANCE;
    }
}