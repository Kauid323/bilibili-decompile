package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Reduce.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\b\b\u0001\u0010\u0003*\u0002H\u00022\u0006\u0010\u0004\u001a\u0002H\u0003H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "S", "T", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class FlowKt__ReduceKt$reduce$2<T> implements FlowCollector {
    final /* synthetic */ Ref.ObjectRef<Object> $accumulator;
    final /* synthetic */ Function3<S, T, Continuation<? super S>, Object> $operation;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__ReduceKt$reduce$2(Ref.ObjectRef<Object> objectRef, Function3<? super S, ? super T, ? super Continuation<? super S>, ? extends Object> function3) {
        this.$accumulator = objectRef;
        this.$operation = function3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0036  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object emit(T t, Continuation<? super Unit> continuation) {
        FlowKt__ReduceKt$reduce$2$emit$1 flowKt__ReduceKt$reduce$2$emit$1;
        FlowKt__ReduceKt$reduce$2$emit$1 flowKt__ReduceKt$reduce$2$emit$12;
        Ref.ObjectRef<Object> objectRef;
        Object obj;
        Ref.ObjectRef<Object> objectRef2;
        if (continuation instanceof FlowKt__ReduceKt$reduce$2$emit$1) {
            flowKt__ReduceKt$reduce$2$emit$1 = (FlowKt__ReduceKt$reduce$2$emit$1) continuation;
            if ((flowKt__ReduceKt$reduce$2$emit$1.label & IntCompanionObject.MIN_VALUE) != 0) {
                flowKt__ReduceKt$reduce$2$emit$1.label -= IntCompanionObject.MIN_VALUE;
                flowKt__ReduceKt$reduce$2$emit$12 = flowKt__ReduceKt$reduce$2$emit$1;
                Object $result = flowKt__ReduceKt$reduce$2$emit$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (flowKt__ReduceKt$reduce$2$emit$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        objectRef = this.$accumulator;
                        if (this.$accumulator.element != NullSurrogateKt.NULL) {
                            Function3<S, T, Continuation<? super S>, Object> function3 = this.$operation;
                            Object obj2 = this.$accumulator.element;
                            flowKt__ReduceKt$reduce$2$emit$12.L$0 = objectRef;
                            flowKt__ReduceKt$reduce$2$emit$12.label = 1;
                            Object value = function3.invoke(obj2, t, flowKt__ReduceKt$reduce$2$emit$12);
                            if (value == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            obj = value;
                            objectRef2 = objectRef;
                            objectRef = objectRef2;
                            t = obj;
                            break;
                        }
                        break;
                    case 1:
                        objectRef2 = (Ref.ObjectRef) flowKt__ReduceKt$reduce$2$emit$12.L$0;
                        ResultKt.throwOnFailure($result);
                        obj = $result;
                        objectRef = objectRef2;
                        t = obj;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                objectRef.element = t;
                return Unit.INSTANCE;
            }
        }
        flowKt__ReduceKt$reduce$2$emit$1 = new FlowKt__ReduceKt$reduce$2$emit$1(this, continuation);
        flowKt__ReduceKt$reduce$2$emit$12 = flowKt__ReduceKt$reduce$2$emit$1;
        Object $result2 = flowKt__ReduceKt$reduce$2$emit$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (flowKt__ReduceKt$reduce$2$emit$12.label) {
        }
        objectRef.element = t;
        return Unit.INSTANCE;
    }
}