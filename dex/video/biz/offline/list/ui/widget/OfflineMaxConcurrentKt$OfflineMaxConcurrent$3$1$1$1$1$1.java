package video.biz.offline.list.ui.widget;

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
import video.biz.offline.list.logic.model.MaxConcurrentModel;
import video.biz.offline.list.logic.statemachine.OfflineBaseListStateMachine;
import video.biz.offline.list.logic.statemachine.SetConcurrentCount;
import video.biz.offline.list.logic.statemachine.ShowConcurrentSheet;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OfflineMaxConcurrent.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "video.biz.offline.list.ui.widget.OfflineMaxConcurrentKt$OfflineMaxConcurrent$3$1$1$1$1$1", f = "OfflineMaxConcurrent.kt", i = {}, l = {101, 102}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class OfflineMaxConcurrentKt$OfflineMaxConcurrent$3$1$1$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ OfflineBaseListStateMachine $machine;
    final /* synthetic */ MaxConcurrentModel $option;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OfflineMaxConcurrentKt$OfflineMaxConcurrent$3$1$1$1$1$1(OfflineBaseListStateMachine offlineBaseListStateMachine, MaxConcurrentModel maxConcurrentModel, Continuation<? super OfflineMaxConcurrentKt$OfflineMaxConcurrent$3$1$1$1$1$1> continuation) {
        super(2, continuation);
        this.$machine = offlineBaseListStateMachine;
        this.$option = maxConcurrentModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OfflineMaxConcurrentKt$OfflineMaxConcurrent$3$1$1$1$1$1(this.$machine, this.$option, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x004a A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                if (this.$machine.dispatch(new ShowConcurrentSheet(false), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                this.label = 2;
                if (this.$machine.dispatch(new SetConcurrentCount(this.$option.getCount()), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            case 1:
                ResultKt.throwOnFailure($result);
                this.label = 2;
                if (this.$machine.dispatch(new SetConcurrentCount(this.$option.getCount()), (Continuation) this) == coroutine_suspended) {
                }
                return Unit.INSTANCE;
            case 2:
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}