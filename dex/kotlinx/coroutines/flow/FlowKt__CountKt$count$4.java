package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Ref;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Count.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "T", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class FlowKt__CountKt$count$4<T> implements FlowCollector {
    final /* synthetic */ Ref.IntRef $i;
    final /* synthetic */ Function2<T, Continuation<? super Boolean>, Object> $predicate;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__CountKt$count$4(Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2, Ref.IntRef intRef) {
        this.$predicate = function2;
        this.$i = intRef;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0051  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object emit(T t, Continuation<? super Unit> continuation) {
        FlowKt__CountKt$count$4$emit$1 flowKt__CountKt$count$4$emit$1;
        FlowKt__CountKt$count$4$emit$1 flowKt__CountKt$count$4$emit$12;
        FlowKt__CountKt$count$4 flowKt__CountKt$count$4;
        Object value;
        if (continuation instanceof FlowKt__CountKt$count$4$emit$1) {
            flowKt__CountKt$count$4$emit$1 = (FlowKt__CountKt$count$4$emit$1) continuation;
            if ((flowKt__CountKt$count$4$emit$1.label & IntCompanionObject.MIN_VALUE) != 0) {
                flowKt__CountKt$count$4$emit$1.label -= IntCompanionObject.MIN_VALUE;
                flowKt__CountKt$count$4$emit$12 = flowKt__CountKt$count$4$emit$1;
                Object $result = flowKt__CountKt$count$4$emit$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (flowKt__CountKt$count$4$emit$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        flowKt__CountKt$count$4 = this;
                        Function2<T, Continuation<? super Boolean>, Object> function2 = flowKt__CountKt$count$4.$predicate;
                        flowKt__CountKt$count$4$emit$12.L$0 = flowKt__CountKt$count$4;
                        flowKt__CountKt$count$4$emit$12.label = 1;
                        value = function2.invoke(t, flowKt__CountKt$count$4$emit$12);
                        if (value == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        ResultKt.throwOnFailure($result);
                        flowKt__CountKt$count$4 = (FlowKt__CountKt$count$4) flowKt__CountKt$count$4$emit$12.L$0;
                        value = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                if (((Boolean) value).booleanValue()) {
                    flowKt__CountKt$count$4.$i.element++;
                    int i = flowKt__CountKt$count$4.$i.element;
                }
                return Unit.INSTANCE;
            }
        }
        flowKt__CountKt$count$4$emit$1 = new FlowKt__CountKt$count$4$emit$1(this, continuation);
        flowKt__CountKt$count$4$emit$12 = flowKt__CountKt$count$4$emit$1;
        Object $result2 = flowKt__CountKt$count$4$emit$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (flowKt__CountKt$count$4$emit$12.label) {
        }
        if (((Boolean) value).booleanValue()) {
        }
        return Unit.INSTANCE;
    }
}