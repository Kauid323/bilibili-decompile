package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.IntCompanionObject;
import kotlinx.coroutines.flow.internal.SafeCollector;

/* compiled from: Flow.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b'\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u001c\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0086@¢\u0006\u0002\u0010\tJ\u001c\u0010\n\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bH¦@¢\u0006\u0002\u0010\t¨\u0006\u000b"}, d2 = {"Lkotlinx/coroutines/flow/AbstractFlow;", "T", "Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/flow/CancellableFlow;", "()V", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "collectSafely", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class AbstractFlow<T> implements Flow<T>, CancellableFlow<T> {
    public abstract Object collectSafely(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation);

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0035  */
    /* JADX WARN: Type inference failed for: r5v0, types: [kotlinx.coroutines.flow.AbstractFlow<T>, kotlinx.coroutines.flow.AbstractFlow] */
    /* JADX WARN: Type inference failed for: r6v0, types: [kotlinx.coroutines.flow.FlowCollector, kotlinx.coroutines.flow.FlowCollector<? super T>] */
    /* JADX WARN: Type inference failed for: r6v1, types: [kotlinx.coroutines.flow.internal.SafeCollector] */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v3, types: [kotlinx.coroutines.flow.internal.SafeCollector] */
    /* JADX WARN: Type inference failed for: r6v9 */
    @Override // kotlinx.coroutines.flow.Flow
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object collect(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
        AbstractFlow$collect$1 abstractFlow$collect$1;
        AbstractFlow$collect$1 abstractFlow$collect$12;
        try {
            if (continuation instanceof AbstractFlow$collect$1) {
                abstractFlow$collect$1 = (AbstractFlow$collect$1) continuation;
                if ((abstractFlow$collect$1.label & IntCompanionObject.MIN_VALUE) != 0) {
                    abstractFlow$collect$1.label -= IntCompanionObject.MIN_VALUE;
                    abstractFlow$collect$12 = abstractFlow$collect$1;
                    Object $result = abstractFlow$collect$12.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (abstractFlow$collect$12.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            SafeCollector safeCollector = new SafeCollector(flowCollector, abstractFlow$collect$12.getContext());
                            abstractFlow$collect$12.L$0 = safeCollector;
                            abstractFlow$collect$12.label = 1;
                            Object collectSafely = collectSafely(safeCollector, abstractFlow$collect$12);
                            flowCollector = safeCollector;
                            if (collectSafely == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            break;
                        case 1:
                            SafeCollector safeCollector2 = (SafeCollector) abstractFlow$collect$12.L$0;
                            ResultKt.throwOnFailure($result);
                            flowCollector = safeCollector2;
                            break;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ((SafeCollector) flowCollector).releaseIntercepted();
                    return Unit.INSTANCE;
                }
            }
            switch (abstractFlow$collect$12.label) {
            }
            ((SafeCollector) flowCollector).releaseIntercepted();
            return Unit.INSTANCE;
        } catch (Throwable th) {
            flowCollector.releaseIntercepted();
            throw th;
        }
        abstractFlow$collect$1 = new AbstractFlow$collect$1(this, continuation);
        abstractFlow$collect$12 = abstractFlow$collect$1;
        Object $result2 = abstractFlow$collect$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    }
}