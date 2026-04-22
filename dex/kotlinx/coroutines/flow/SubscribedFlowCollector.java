package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.IntCompanionObject;
import kotlinx.coroutines.flow.internal.SafeCollector;

/* compiled from: Share.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002BB\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012-\u0010\u0004\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005¢\u0006\u0002\b\t¢\u0006\u0002\u0010\nJ\u0016\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00028\u0000H\u0096A¢\u0006\u0002\u0010\u000eJ\u000e\u0010\u000f\u001a\u00020\u0007H\u0086@¢\u0006\u0002\u0010\u0010R7\u0010\u0004\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005¢\u0006\u0002\b\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lkotlinx/coroutines/flow/SubscribedFlowCollector;", "T", "Lkotlinx/coroutines/flow/FlowCollector;", "collector", "action", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/jvm/functions/Function2;)V", "Lkotlin/jvm/functions/Function2;", "emit", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onSubscription", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class SubscribedFlowCollector<T> implements FlowCollector<T> {
    private final Function2<FlowCollector<? super T>, Continuation<? super Unit>, Object> action;
    private final FlowCollector<T> collector;

    @Override // kotlinx.coroutines.flow.FlowCollector
    public Object emit(T t, Continuation<? super Unit> continuation) {
        return this.collector.emit(t, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SubscribedFlowCollector(FlowCollector<? super T> flowCollector, Function2<? super FlowCollector<? super T>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        this.collector = flowCollector;
        this.action = function2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0068  */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [kotlinx.coroutines.flow.internal.SafeCollector] */
    /* JADX WARN: Type inference failed for: r2v5, types: [boolean] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object onSubscription(Continuation<? super Unit> continuation) {
        SubscribedFlowCollector$onSubscription$1 subscribedFlowCollector$onSubscription$1;
        ?? r2;
        SubscribedFlowCollector subscribedFlowCollector;
        SafeCollector safeCollector;
        try {
            if (continuation instanceof SubscribedFlowCollector$onSubscription$1) {
                subscribedFlowCollector$onSubscription$1 = (SubscribedFlowCollector$onSubscription$1) continuation;
                if ((subscribedFlowCollector$onSubscription$1.label & IntCompanionObject.MIN_VALUE) != 0) {
                    subscribedFlowCollector$onSubscription$1.label -= IntCompanionObject.MIN_VALUE;
                    SubscribedFlowCollector$onSubscription$1 subscribedFlowCollector$onSubscription$12 = subscribedFlowCollector$onSubscription$1;
                    Object $result = subscribedFlowCollector$onSubscription$12.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    r2 = subscribedFlowCollector$onSubscription$12.label;
                    switch (r2) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            subscribedFlowCollector = this;
                            safeCollector = new SafeCollector(subscribedFlowCollector.collector, subscribedFlowCollector$onSubscription$12.getContext());
                            Function2<FlowCollector<? super T>, Continuation<? super Unit>, Object> function2 = subscribedFlowCollector.action;
                            subscribedFlowCollector$onSubscription$12.L$0 = subscribedFlowCollector;
                            subscribedFlowCollector$onSubscription$12.L$1 = safeCollector;
                            subscribedFlowCollector$onSubscription$12.label = 1;
                            if (function2.invoke(safeCollector, subscribedFlowCollector$onSubscription$12) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            safeCollector.releaseIntercepted();
                            r2 = subscribedFlowCollector.collector instanceof SubscribedFlowCollector;
                            if (r2 != 0) {
                                subscribedFlowCollector$onSubscription$12.L$0 = null;
                                subscribedFlowCollector$onSubscription$12.L$1 = null;
                                subscribedFlowCollector$onSubscription$12.label = 2;
                                if (((SubscribedFlowCollector) subscribedFlowCollector.collector).onSubscription(subscribedFlowCollector$onSubscription$12) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            }
                            return Unit.INSTANCE;
                        case 1:
                            safeCollector = (SafeCollector) subscribedFlowCollector$onSubscription$12.L$1;
                            subscribedFlowCollector = (SubscribedFlowCollector) subscribedFlowCollector$onSubscription$12.L$0;
                            ResultKt.throwOnFailure($result);
                            safeCollector.releaseIntercepted();
                            r2 = subscribedFlowCollector.collector instanceof SubscribedFlowCollector;
                            if (r2 != 0) {
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
            switch (r2) {
            }
        } catch (Throwable th) {
            r2.releaseIntercepted();
            throw th;
        }
        subscribedFlowCollector$onSubscription$1 = new SubscribedFlowCollector$onSubscription$1(this, continuation);
        SubscribedFlowCollector$onSubscription$1 subscribedFlowCollector$onSubscription$122 = subscribedFlowCollector$onSubscription$1;
        Object $result2 = subscribedFlowCollector$onSubscription$122.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        r2 = subscribedFlowCollector$onSubscription$122.label;
    }
}