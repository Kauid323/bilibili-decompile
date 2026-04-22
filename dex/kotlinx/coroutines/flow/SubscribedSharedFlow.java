package kotlinx.coroutines.flow;

import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.IntCompanionObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Share.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0002\b\u0003\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002BB\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012-\u0010\u0004\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0005¢\u0006\u0002\b\n¢\u0006\u0002\u0010\u000bJ\u001c\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096@¢\u0006\u0002\u0010\u0014R7\u0010\u0004\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0005¢\u0006\u0002\b\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0018\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lkotlinx/coroutines/flow/SubscribedSharedFlow;", "T", "Lkotlinx/coroutines/flow/SharedFlow;", "sharedFlow", "action", "Lkotlin/Function2;", "Lkotlinx/coroutines/flow/FlowCollector;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/flow/SharedFlow;Lkotlin/jvm/functions/Function2;)V", "Lkotlin/jvm/functions/Function2;", "replayCache", "", "getReplayCache", "()Ljava/util/List;", "collect", "", "collector", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class SubscribedSharedFlow<T> implements SharedFlow<T> {
    private final Function2<FlowCollector<? super T>, Continuation<? super Unit>, Object> action;
    private final SharedFlow<T> sharedFlow;

    @Override // kotlinx.coroutines.flow.SharedFlow
    public List<T> getReplayCache() {
        return this.sharedFlow.getReplayCache();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SubscribedSharedFlow(SharedFlow<? extends T> sharedFlow, Function2<? super FlowCollector<? super T>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        this.sharedFlow = sharedFlow;
        this.action = function2;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0031  */
    @Override // kotlinx.coroutines.flow.SharedFlow, kotlinx.coroutines.flow.Flow
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object collect(FlowCollector<? super T> flowCollector, Continuation<?> continuation) {
        SubscribedSharedFlow$collect$1 subscribedSharedFlow$collect$1;
        SubscribedSharedFlow$collect$1 subscribedSharedFlow$collect$12;
        if (continuation instanceof SubscribedSharedFlow$collect$1) {
            subscribedSharedFlow$collect$1 = (SubscribedSharedFlow$collect$1) continuation;
            if ((subscribedSharedFlow$collect$1.label & IntCompanionObject.MIN_VALUE) != 0) {
                subscribedSharedFlow$collect$1.label -= IntCompanionObject.MIN_VALUE;
                subscribedSharedFlow$collect$12 = subscribedSharedFlow$collect$1;
                Object $result = subscribedSharedFlow$collect$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (subscribedSharedFlow$collect$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        subscribedSharedFlow$collect$12.label = 1;
                        if (this.sharedFlow.collect(new SubscribedFlowCollector(flowCollector, this.action), subscribedSharedFlow$collect$12) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        ResultKt.throwOnFailure($result);
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                throw new KotlinNothingValueException();
            }
        }
        subscribedSharedFlow$collect$1 = new SubscribedSharedFlow$collect$1(this, continuation);
        subscribedSharedFlow$collect$12 = subscribedSharedFlow$collect$1;
        Object $result2 = subscribedSharedFlow$collect$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (subscribedSharedFlow$collect$12.label) {
        }
        throw new KotlinNothingValueException();
    }
}