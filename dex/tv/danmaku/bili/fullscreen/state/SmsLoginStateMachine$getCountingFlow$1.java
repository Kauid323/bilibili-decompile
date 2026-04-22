package tv.danmaku.bili.fullscreen.state;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.flow.FlowCollector;
import tv.danmaku.bili.BR;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SmsLoginPageState.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", ""}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.fullscreen.state.SmsLoginStateMachine$getCountingFlow$1", f = "SmsLoginPageState.kt", i = {0, 0, 1, 1}, l = {784, 785}, m = "invokeSuspend", n = {"$this$flow", "i", "$this$flow", "i"}, s = {"L$0", "I$0", "L$0", "I$0"}, v = 1)
public final class SmsLoginStateMachine$getCountingFlow$1 extends SuspendLambda implements Function2<FlowCollector<? super Integer>, Continuation<? super Unit>, Object> {
    int I$0;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SmsLoginStateMachine$getCountingFlow$1(Continuation<? super SmsLoginStateMachine$getCountingFlow$1> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> smsLoginStateMachine$getCountingFlow$1 = new SmsLoginStateMachine$getCountingFlow$1(continuation);
        smsLoginStateMachine$getCountingFlow$1.L$0 = obj;
        return smsLoginStateMachine$getCountingFlow$1;
    }

    public final Object invoke(FlowCollector<? super Integer> flowCollector, Continuation<? super Unit> continuation) {
        return create(flowCollector, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x005e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0064  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x005c -> B:17:0x005f). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        FlowCollector $this$flow;
        int i;
        SmsLoginStateMachine$getCountingFlow$1 smsLoginStateMachine$getCountingFlow$1;
        int i2;
        FlowCollector $this$flow2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                $this$flow = (FlowCollector) this.L$0;
                i = 60;
                smsLoginStateMachine$getCountingFlow$1 = this;
                if (-1 >= i) {
                    smsLoginStateMachine$getCountingFlow$1.L$0 = $this$flow;
                    smsLoginStateMachine$getCountingFlow$1.I$0 = i;
                    smsLoginStateMachine$getCountingFlow$1.label = 1;
                    if ($this$flow.emit(Boxing.boxInt(i), (Continuation) smsLoginStateMachine$getCountingFlow$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    int i3 = i;
                    $this$flow2 = $this$flow;
                    i2 = i3;
                    smsLoginStateMachine$getCountingFlow$1.L$0 = $this$flow2;
                    smsLoginStateMachine$getCountingFlow$1.I$0 = i2;
                    smsLoginStateMachine$getCountingFlow$1.label = 2;
                    if (DelayKt.delay(1000L, (Continuation) smsLoginStateMachine$getCountingFlow$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    FlowCollector flowCollector = $this$flow2;
                    i = i2 - 1;
                    $this$flow = flowCollector;
                    if (-1 >= i) {
                        return Unit.INSTANCE;
                    }
                }
            case 1:
                i2 = this.I$0;
                $this$flow2 = (FlowCollector) this.L$0;
                ResultKt.throwOnFailure($result);
                smsLoginStateMachine$getCountingFlow$1 = this;
                smsLoginStateMachine$getCountingFlow$1.L$0 = $this$flow2;
                smsLoginStateMachine$getCountingFlow$1.I$0 = i2;
                smsLoginStateMachine$getCountingFlow$1.label = 2;
                if (DelayKt.delay(1000L, (Continuation) smsLoginStateMachine$getCountingFlow$1) == coroutine_suspended) {
                }
                FlowCollector flowCollector2 = $this$flow2;
                i = i2 - 1;
                $this$flow = flowCollector2;
                if (-1 >= i) {
                }
                break;
            case 2:
                i2 = this.I$0;
                $this$flow2 = (FlowCollector) this.L$0;
                ResultKt.throwOnFailure($result);
                smsLoginStateMachine$getCountingFlow$1 = this;
                FlowCollector flowCollector22 = $this$flow2;
                i = i2 - 1;
                $this$flow = flowCollector22;
                if (-1 >= i) {
                }
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}