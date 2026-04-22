package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.DelayKt;

/* compiled from: SharingStarted.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lkotlinx/coroutines/flow/SharingCommand;", "count", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.StartedWhileSubscribed$command$1", f = "SharingStarted.kt", i = {1, 2, 3}, l = {174, 176, 178, 179, 181}, m = "invokeSuspend", n = {"$this$transformLatest", "$this$transformLatest", "$this$transformLatest"}, s = {"L$0", "L$0", "L$0"})
final class StartedWhileSubscribed$command$1 extends SuspendLambda implements Function3<FlowCollector<? super SharingCommand>, Integer, Continuation<? super Unit>, Object> {
    /* synthetic */ int I$0;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ StartedWhileSubscribed this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StartedWhileSubscribed$command$1(StartedWhileSubscribed startedWhileSubscribed, Continuation<? super StartedWhileSubscribed$command$1> continuation) {
        super(3, continuation);
        this.this$0 = startedWhileSubscribed;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super SharingCommand> flowCollector, Integer num, Continuation<? super Unit> continuation) {
        return invoke(flowCollector, num.intValue(), continuation);
    }

    public final Object invoke(FlowCollector<? super SharingCommand> flowCollector, int i, Continuation<? super Unit> continuation) {
        StartedWhileSubscribed$command$1 startedWhileSubscribed$command$1 = new StartedWhileSubscribed$command$1(this.this$0, continuation);
        startedWhileSubscribed$command$1.L$0 = flowCollector;
        startedWhileSubscribed$command$1.I$0 = i;
        return startedWhileSubscribed$command$1.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x009c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00af A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00b0  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        StartedWhileSubscribed$command$1 startedWhileSubscribed$command$1;
        FlowCollector $this$transformLatest;
        long j;
        long j2;
        long j3;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                startedWhileSubscribed$command$1 = this;
                $this$transformLatest = (FlowCollector) startedWhileSubscribed$command$1.L$0;
                int count = startedWhileSubscribed$command$1.I$0;
                if (count > 0) {
                    startedWhileSubscribed$command$1.label = 1;
                    return $this$transformLatest.emit(SharingCommand.START, startedWhileSubscribed$command$1) == coroutine_suspended ? coroutine_suspended : Unit.INSTANCE;
                }
                j = startedWhileSubscribed$command$1.this$0.stopTimeout;
                startedWhileSubscribed$command$1.L$0 = $this$transformLatest;
                startedWhileSubscribed$command$1.label = 2;
                if (DelayKt.delay(j, startedWhileSubscribed$command$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                j2 = startedWhileSubscribed$command$1.this$0.replayExpiration;
                if (j2 > 0) {
                    startedWhileSubscribed$command$1.L$0 = $this$transformLatest;
                    startedWhileSubscribed$command$1.label = 3;
                    if ($this$transformLatest.emit(SharingCommand.STOP, startedWhileSubscribed$command$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    j3 = startedWhileSubscribed$command$1.this$0.replayExpiration;
                    startedWhileSubscribed$command$1.L$0 = $this$transformLatest;
                    startedWhileSubscribed$command$1.label = 4;
                    if (DelayKt.delay(j3, startedWhileSubscribed$command$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                startedWhileSubscribed$command$1.L$0 = null;
                startedWhileSubscribed$command$1.label = 5;
                if ($this$transformLatest.emit(SharingCommand.STOP_AND_RESET_REPLAY_CACHE, startedWhileSubscribed$command$1) != coroutine_suspended) {
                    return coroutine_suspended;
                }
            case 1:
                ResultKt.throwOnFailure($result);
            case 2:
                startedWhileSubscribed$command$1 = this;
                $this$transformLatest = (FlowCollector) startedWhileSubscribed$command$1.L$0;
                ResultKt.throwOnFailure($result);
                j2 = startedWhileSubscribed$command$1.this$0.replayExpiration;
                if (j2 > 0) {
                }
                startedWhileSubscribed$command$1.L$0 = null;
                startedWhileSubscribed$command$1.label = 5;
                if ($this$transformLatest.emit(SharingCommand.STOP_AND_RESET_REPLAY_CACHE, startedWhileSubscribed$command$1) != coroutine_suspended) {
                }
                break;
            case 3:
                startedWhileSubscribed$command$1 = this;
                $this$transformLatest = (FlowCollector) startedWhileSubscribed$command$1.L$0;
                ResultKt.throwOnFailure($result);
                j3 = startedWhileSubscribed$command$1.this$0.replayExpiration;
                startedWhileSubscribed$command$1.L$0 = $this$transformLatest;
                startedWhileSubscribed$command$1.label = 4;
                if (DelayKt.delay(j3, startedWhileSubscribed$command$1) == coroutine_suspended) {
                }
                startedWhileSubscribed$command$1.L$0 = null;
                startedWhileSubscribed$command$1.label = 5;
                if ($this$transformLatest.emit(SharingCommand.STOP_AND_RESET_REPLAY_CACHE, startedWhileSubscribed$command$1) != coroutine_suspended) {
                }
                break;
            case 4:
                startedWhileSubscribed$command$1 = this;
                $this$transformLatest = (FlowCollector) startedWhileSubscribed$command$1.L$0;
                ResultKt.throwOnFailure($result);
                startedWhileSubscribed$command$1.L$0 = null;
                startedWhileSubscribed$command$1.label = 5;
                if ($this$transformLatest.emit(SharingCommand.STOP_AND_RESET_REPLAY_CACHE, startedWhileSubscribed$command$1) != coroutine_suspended) {
                }
                break;
            case 5:
                ResultKt.throwOnFailure($result);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}