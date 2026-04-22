package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Ref;

/* compiled from: Reduce.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 9, 0}, xi = 176)
public final class FlowKt__ReduceKt$fold$2<T> implements FlowCollector {
    final /* synthetic */ Ref.ObjectRef<R> $accumulator;
    final /* synthetic */ Function3<R, T, Continuation<? super R>, Object> $operation;

    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__ReduceKt$fold$2(Ref.ObjectRef<R> objectRef, Function3<? super R, ? super T, ? super Continuation<? super R>, ? extends Object> function3) {
        this.$accumulator = objectRef;
        this.$operation = function3;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0036  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object emit(T t, Continuation<? super Unit> continuation) {
        FlowKt__ReduceKt$fold$2$emit$1 flowKt__ReduceKt$fold$2$emit$1;
        FlowKt__ReduceKt$fold$2$emit$1 flowKt__ReduceKt$fold$2$emit$12;
        T t2;
        Ref.ObjectRef objectRef;
        if (continuation instanceof FlowKt__ReduceKt$fold$2$emit$1) {
            flowKt__ReduceKt$fold$2$emit$1 = (FlowKt__ReduceKt$fold$2$emit$1) continuation;
            if ((flowKt__ReduceKt$fold$2$emit$1.label & IntCompanionObject.MIN_VALUE) != 0) {
                flowKt__ReduceKt$fold$2$emit$1.label -= IntCompanionObject.MIN_VALUE;
                flowKt__ReduceKt$fold$2$emit$12 = flowKt__ReduceKt$fold$2$emit$1;
                Object $result = flowKt__ReduceKt$fold$2$emit$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (flowKt__ReduceKt$fold$2$emit$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        Ref.ObjectRef objectRef2 = this.$accumulator;
                        Function3<R, T, Continuation<? super R>, Object> function3 = this.$operation;
                        T t3 = this.$accumulator.element;
                        flowKt__ReduceKt$fold$2$emit$12.L$0 = objectRef2;
                        flowKt__ReduceKt$fold$2$emit$12.label = 1;
                        Object value = function3.invoke(t3, t, flowKt__ReduceKt$fold$2$emit$12);
                        if (value == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        t2 = (T) value;
                        objectRef = objectRef2;
                        break;
                    case 1:
                        objectRef = (Ref.ObjectRef) flowKt__ReduceKt$fold$2$emit$12.L$0;
                        ResultKt.throwOnFailure($result);
                        t2 = (T) $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                objectRef.element = t2;
                return Unit.INSTANCE;
            }
        }
        flowKt__ReduceKt$fold$2$emit$1 = new FlowKt__ReduceKt$fold$2$emit$1(this, continuation);
        flowKt__ReduceKt$fold$2$emit$12 = flowKt__ReduceKt$fold$2$emit$1;
        Object $result2 = flowKt__ReduceKt$fold$2$emit$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (flowKt__ReduceKt$fold$2$emit$12.label) {
        }
        objectRef.element = t2;
        return Unit.INSTANCE;
    }

    public final Object emit$$forInline(T t, Continuation<? super Unit> continuation) {
        InlineMarker.mark(4);
        new FlowKt__ReduceKt$fold$2$emit$1(this, continuation);
        InlineMarker.mark(5);
        this.$accumulator.element = (T) this.$operation.invoke(this.$accumulator.element, t, continuation);
        return Unit.INSTANCE;
    }
}