package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.IntCompanionObject;
import kotlinx.coroutines.JobKt;

/* compiled from: Context.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "T", "it", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class CancellableFlowImpl$collect$2<T> implements FlowCollector {
    final /* synthetic */ FlowCollector<T> $collector;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public CancellableFlowImpl$collect$2(FlowCollector<? super T> flowCollector) {
        this.$collector = flowCollector;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0031  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object emit(T t, Continuation<? super Unit> continuation) {
        CancellableFlowImpl$collect$2$emit$1 cancellableFlowImpl$collect$2$emit$1;
        CancellableFlowImpl$collect$2$emit$1 cancellableFlowImpl$collect$2$emit$12;
        if (continuation instanceof CancellableFlowImpl$collect$2$emit$1) {
            cancellableFlowImpl$collect$2$emit$1 = (CancellableFlowImpl$collect$2$emit$1) continuation;
            if ((cancellableFlowImpl$collect$2$emit$1.label & IntCompanionObject.MIN_VALUE) != 0) {
                cancellableFlowImpl$collect$2$emit$1.label -= IntCompanionObject.MIN_VALUE;
                cancellableFlowImpl$collect$2$emit$12 = cancellableFlowImpl$collect$2$emit$1;
                Object $result = cancellableFlowImpl$collect$2$emit$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (cancellableFlowImpl$collect$2$emit$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        JobKt.ensureActive(cancellableFlowImpl$collect$2$emit$12.getContext());
                        FlowCollector<T> flowCollector = this.$collector;
                        cancellableFlowImpl$collect$2$emit$12.label = 1;
                        Object it = flowCollector.emit(t, cancellableFlowImpl$collect$2$emit$12);
                        if (it == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        ResultKt.throwOnFailure($result);
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return Unit.INSTANCE;
            }
        }
        cancellableFlowImpl$collect$2$emit$1 = new CancellableFlowImpl$collect$2$emit$1(this, continuation);
        cancellableFlowImpl$collect$2$emit$12 = cancellableFlowImpl$collect$2$emit$1;
        Object $result2 = cancellableFlowImpl$collect$2$emit$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (cancellableFlowImpl$collect$2$emit$12.label) {
        }
        return Unit.INSTANCE;
    }
}