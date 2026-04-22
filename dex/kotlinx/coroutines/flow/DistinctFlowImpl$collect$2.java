package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;

/* compiled from: Distinct.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "T", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class DistinctFlowImpl$collect$2<T> implements FlowCollector {
    final /* synthetic */ FlowCollector<T> $collector;
    final /* synthetic */ Ref.ObjectRef<Object> $previousKey;
    final /* synthetic */ DistinctFlowImpl<T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public DistinctFlowImpl$collect$2(DistinctFlowImpl<T> distinctFlowImpl, Ref.ObjectRef<Object> objectRef, FlowCollector<? super T> flowCollector) {
        this.this$0 = distinctFlowImpl;
        this.$previousKey = objectRef;
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
        DistinctFlowImpl$collect$2$emit$1 distinctFlowImpl$collect$2$emit$1;
        DistinctFlowImpl$collect$2$emit$1 distinctFlowImpl$collect$2$emit$12;
        if (continuation instanceof DistinctFlowImpl$collect$2$emit$1) {
            distinctFlowImpl$collect$2$emit$1 = (DistinctFlowImpl$collect$2$emit$1) continuation;
            if ((distinctFlowImpl$collect$2$emit$1.label & IntCompanionObject.MIN_VALUE) != 0) {
                distinctFlowImpl$collect$2$emit$1.label -= IntCompanionObject.MIN_VALUE;
                distinctFlowImpl$collect$2$emit$12 = distinctFlowImpl$collect$2$emit$1;
                Object $result = distinctFlowImpl$collect$2$emit$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (distinctFlowImpl$collect$2$emit$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        T t2 = (T) this.this$0.keySelector.invoke(t);
                        if (this.$previousKey.element == NullSurrogateKt.NULL || !this.this$0.areEquivalent.invoke(this.$previousKey.element, t2).booleanValue()) {
                            this.$previousKey.element = t2;
                            FlowCollector<T> flowCollector = this.$collector;
                            distinctFlowImpl$collect$2$emit$12.label = 1;
                            Object value = flowCollector.emit(t, distinctFlowImpl$collect$2$emit$12);
                            if (value == coroutine_suspended) {
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
                Object value2 = Unit.INSTANCE;
                return value2;
            }
        }
        distinctFlowImpl$collect$2$emit$1 = new DistinctFlowImpl$collect$2$emit$1(this, continuation);
        distinctFlowImpl$collect$2$emit$12 = distinctFlowImpl$collect$2$emit$1;
        Object $result2 = distinctFlowImpl$collect$2$emit$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (distinctFlowImpl$collect$2$emit$12.label) {
        }
        Object value22 = Unit.INSTANCE;
        return value22;
    }
}