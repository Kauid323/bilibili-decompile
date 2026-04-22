package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.IndexedValue;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Ref;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Transform.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "T", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class FlowKt__TransformKt$withIndex$1$1<T> implements FlowCollector {
    final /* synthetic */ Ref.IntRef $index;
    final /* synthetic */ FlowCollector<IndexedValue<? extends T>> $this_unsafeFlow;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__TransformKt$withIndex$1$1(FlowCollector<? super IndexedValue<? extends T>> flowCollector, Ref.IntRef intRef) {
        this.$this_unsafeFlow = flowCollector;
        this.$index = intRef;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0031  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object emit(T t, Continuation<? super Unit> continuation) {
        FlowKt__TransformKt$withIndex$1$1$emit$1 flowKt__TransformKt$withIndex$1$1$emit$1;
        FlowKt__TransformKt$withIndex$1$1$emit$1 flowKt__TransformKt$withIndex$1$1$emit$12;
        if (continuation instanceof FlowKt__TransformKt$withIndex$1$1$emit$1) {
            flowKt__TransformKt$withIndex$1$1$emit$1 = (FlowKt__TransformKt$withIndex$1$1$emit$1) continuation;
            if ((flowKt__TransformKt$withIndex$1$1$emit$1.label & IntCompanionObject.MIN_VALUE) != 0) {
                flowKt__TransformKt$withIndex$1$1$emit$1.label -= IntCompanionObject.MIN_VALUE;
                flowKt__TransformKt$withIndex$1$1$emit$12 = flowKt__TransformKt$withIndex$1$1$emit$1;
                Object $result = flowKt__TransformKt$withIndex$1$1$emit$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (flowKt__TransformKt$withIndex$1$1$emit$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        FlowCollector<IndexedValue<? extends T>> flowCollector = this.$this_unsafeFlow;
                        int index$iv = this.$index.element;
                        this.$index.element = index$iv + 1;
                        if (index$iv >= 0) {
                            IndexedValue<? extends T> indexedValue = new IndexedValue<>(index$iv, t);
                            flowKt__TransformKt$withIndex$1$1$emit$12.label = 1;
                            Object value = flowCollector.emit(indexedValue, flowKt__TransformKt$withIndex$1$1$emit$12);
                            if (value == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else {
                            throw new ArithmeticException("Index overflow has happened");
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
        flowKt__TransformKt$withIndex$1$1$emit$1 = new FlowKt__TransformKt$withIndex$1$1$emit$1(this, continuation);
        flowKt__TransformKt$withIndex$1$1$emit$12 = flowKt__TransformKt$withIndex$1$1$emit$1;
        Object $result2 = flowKt__TransformKt$withIndex$1$1$emit$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (flowKt__TransformKt$withIndex$1$1$emit$12.label) {
        }
        return Unit.INSTANCE;
    }
}