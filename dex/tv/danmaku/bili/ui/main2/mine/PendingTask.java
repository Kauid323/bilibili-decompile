package tv.danmaku.bili.ui.main2.mine;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import tv.danmaku.bili.BR;

/* compiled from: MinePagePendingTaskUtil.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\b\u0017\u0018\u00002\u00020\u0001B%\u0012\u001c\u0010\u0002\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0010\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010\u0011J\u000e\u0010\u0012\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010\u0011J\u000e\u0010\u0013\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010\u0011J\b\u0010\u0014\u001a\u00020\u0015H\u0016R&\u0010\u0002\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\bR\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0016"}, d2 = {"Ltv/danmaku/bili/ui/main2/mine/PendingTask;", "", "execute", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "Lkotlin/jvm/functions/Function1;", "_taskStatusFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ltv/danmaku/bili/ui/main2/mine/TaskStatus;", "taskStatusFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getTaskStatusFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "onExecute", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onFailed", "onSuccessful", "ifRemoveInList", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public class PendingTask {
    public static final int $stable = 8;
    private final MutableStateFlow<TaskStatus> _taskStatusFlow;
    private final Function1<Continuation<? super Unit>, Object> execute;
    private final StateFlow<TaskStatus> taskStatusFlow;

    public Object onExecute(Continuation<? super Unit> continuation) {
        return onExecute$suspendImpl(this, continuation);
    }

    public Object onFailed(Continuation<? super Unit> continuation) {
        return onFailed$suspendImpl(this, continuation);
    }

    public Object onSuccessful(Continuation<? super Unit> continuation) {
        return onSuccessful$suspendImpl(this, continuation);
    }

    public PendingTask(Function1<? super Continuation<? super Unit>, ? extends Object> function1) {
        Intrinsics.checkNotNullParameter(function1, "execute");
        this.execute = function1;
        this._taskStatusFlow = StateFlowKt.MutableStateFlow(TaskStatus.WAITING_BE_EXECUTE);
        this.taskStatusFlow = FlowKt.asStateFlow(this._taskStatusFlow);
    }

    public final StateFlow<TaskStatus> getTaskStatusFlow() {
        return this.taskStatusFlow;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0059 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static /* synthetic */ Object onExecute$suspendImpl(PendingTask $this, Continuation<? super Unit> continuation) {
        PendingTask$onExecute$1 pendingTask$onExecute$1;
        Function1<Continuation<? super Unit>, Object> function1;
        if (continuation instanceof PendingTask$onExecute$1) {
            pendingTask$onExecute$1 = (PendingTask$onExecute$1) continuation;
            if ((pendingTask$onExecute$1.label & Integer.MIN_VALUE) != 0) {
                pendingTask$onExecute$1.label -= Integer.MIN_VALUE;
                Object $result = pendingTask$onExecute$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (pendingTask$onExecute$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        MutableStateFlow<TaskStatus> mutableStateFlow = $this._taskStatusFlow;
                        TaskStatus taskStatus = TaskStatus.EXECUTING;
                        pendingTask$onExecute$1.L$0 = $this;
                        pendingTask$onExecute$1.label = 1;
                        if (mutableStateFlow.emit(taskStatus, pendingTask$onExecute$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        function1 = $this.execute;
                        pendingTask$onExecute$1.L$0 = null;
                        pendingTask$onExecute$1.label = 2;
                        if (function1.invoke(pendingTask$onExecute$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    case 1:
                        $this = (PendingTask) pendingTask$onExecute$1.L$0;
                        ResultKt.throwOnFailure($result);
                        function1 = $this.execute;
                        pendingTask$onExecute$1.L$0 = null;
                        pendingTask$onExecute$1.label = 2;
                        if (function1.invoke(pendingTask$onExecute$1) == coroutine_suspended) {
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
        pendingTask$onExecute$1 = new PendingTask$onExecute$1($this, continuation);
        Object $result2 = pendingTask$onExecute$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (pendingTask$onExecute$1.label) {
        }
    }

    static /* synthetic */ Object onFailed$suspendImpl(PendingTask $this, Continuation<? super Unit> continuation) {
        Object emit = $this._taskStatusFlow.emit(TaskStatus.FAILED, continuation);
        return emit == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? emit : Unit.INSTANCE;
    }

    static /* synthetic */ Object onSuccessful$suspendImpl(PendingTask $this, Continuation<? super Unit> continuation) {
        Object emit = $this._taskStatusFlow.emit(TaskStatus.SUCCESSFUL, continuation);
        return emit == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? emit : Unit.INSTANCE;
    }

    public boolean ifRemoveInList() {
        return this.taskStatusFlow.getValue() == TaskStatus.SUCCESSFUL;
    }
}