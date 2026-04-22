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
/* compiled from: Transform.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "T", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class FlowKt__TransformKt$runningReduce$1$1<T> implements FlowCollector {
    final /* synthetic */ Ref.ObjectRef<Object> $accumulator;
    final /* synthetic */ Function3<T, T, Continuation<? super T>, Object> $operation;
    final /* synthetic */ FlowCollector<T> $this_unsafeFlow;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__TransformKt$runningReduce$1$1(Ref.ObjectRef<Object> objectRef, Function3<? super T, ? super T, ? super Continuation<? super T>, ? extends Object> function3, FlowCollector<? super T> flowCollector) {
        this.$accumulator = objectRef;
        this.$operation = function3;
        this.$this_unsafeFlow = flowCollector;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0080 A[RETURN] */
    @Override // kotlinx.coroutines.flow.FlowCollector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object emit(T t, Continuation<? super Unit> continuation) {
        FlowKt__TransformKt$runningReduce$1$1$emit$1 flowKt__TransformKt$runningReduce$1$1$emit$1;
        FlowKt__TransformKt$runningReduce$1$1$emit$1 flowKt__TransformKt$runningReduce$1$1$emit$12;
        FlowKt__TransformKt$runningReduce$1$1 flowKt__TransformKt$runningReduce$1$1;
        Ref.ObjectRef<Object> objectRef;
        T t2;
        Ref.ObjectRef<Object> objectRef2;
        FlowKt__TransformKt$runningReduce$1$1 flowKt__TransformKt$runningReduce$1$12;
        FlowCollector<T> flowCollector;
        T t3;
        if (continuation instanceof FlowKt__TransformKt$runningReduce$1$1$emit$1) {
            flowKt__TransformKt$runningReduce$1$1$emit$1 = (FlowKt__TransformKt$runningReduce$1$1$emit$1) continuation;
            if ((flowKt__TransformKt$runningReduce$1$1$emit$1.label & IntCompanionObject.MIN_VALUE) != 0) {
                flowKt__TransformKt$runningReduce$1$1$emit$1.label -= IntCompanionObject.MIN_VALUE;
                flowKt__TransformKt$runningReduce$1$1$emit$12 = flowKt__TransformKt$runningReduce$1$1$emit$1;
                Object $result = flowKt__TransformKt$runningReduce$1$1$emit$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (flowKt__TransformKt$runningReduce$1$1$emit$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        flowKt__TransformKt$runningReduce$1$1 = this;
                        objectRef = flowKt__TransformKt$runningReduce$1$1.$accumulator;
                        if (flowKt__TransformKt$runningReduce$1$1.$accumulator.element != NullSurrogateKt.NULL) {
                            Function3<T, T, Continuation<? super T>, Object> function3 = flowKt__TransformKt$runningReduce$1$1.$operation;
                            T t4 = flowKt__TransformKt$runningReduce$1$1.$accumulator.element;
                            flowKt__TransformKt$runningReduce$1$1$emit$12.L$0 = flowKt__TransformKt$runningReduce$1$1;
                            flowKt__TransformKt$runningReduce$1$1$emit$12.L$1 = objectRef;
                            flowKt__TransformKt$runningReduce$1$1$emit$12.label = 1;
                            Object value = function3.invoke(t4, t, flowKt__TransformKt$runningReduce$1$1$emit$12);
                            if (value == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            t2 = value;
                            objectRef2 = objectRef;
                            flowKt__TransformKt$runningReduce$1$12 = flowKt__TransformKt$runningReduce$1$1;
                            FlowKt__TransformKt$runningReduce$1$1 flowKt__TransformKt$runningReduce$1$13 = flowKt__TransformKt$runningReduce$1$12;
                            objectRef = objectRef2;
                            t = t2;
                            flowKt__TransformKt$runningReduce$1$1 = flowKt__TransformKt$runningReduce$1$13;
                        }
                        objectRef.element = t;
                        flowCollector = flowKt__TransformKt$runningReduce$1$1.$this_unsafeFlow;
                        t3 = flowKt__TransformKt$runningReduce$1$1.$accumulator.element;
                        flowKt__TransformKt$runningReduce$1$1$emit$12.L$0 = null;
                        flowKt__TransformKt$runningReduce$1$1$emit$12.L$1 = null;
                        flowKt__TransformKt$runningReduce$1$1$emit$12.label = 2;
                        if (flowCollector.emit(t3, flowKt__TransformKt$runningReduce$1$1$emit$12) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    case 1:
                        objectRef2 = (Ref.ObjectRef) flowKt__TransformKt$runningReduce$1$1$emit$12.L$1;
                        ResultKt.throwOnFailure($result);
                        flowKt__TransformKt$runningReduce$1$12 = (FlowKt__TransformKt$runningReduce$1$1) flowKt__TransformKt$runningReduce$1$1$emit$12.L$0;
                        t2 = $result;
                        FlowKt__TransformKt$runningReduce$1$1 flowKt__TransformKt$runningReduce$1$132 = flowKt__TransformKt$runningReduce$1$12;
                        objectRef = objectRef2;
                        t = t2;
                        flowKt__TransformKt$runningReduce$1$1 = flowKt__TransformKt$runningReduce$1$132;
                        objectRef.element = t;
                        flowCollector = flowKt__TransformKt$runningReduce$1$1.$this_unsafeFlow;
                        t3 = flowKt__TransformKt$runningReduce$1$1.$accumulator.element;
                        flowKt__TransformKt$runningReduce$1$1$emit$12.L$0 = null;
                        flowKt__TransformKt$runningReduce$1$1$emit$12.L$1 = null;
                        flowKt__TransformKt$runningReduce$1$1$emit$12.label = 2;
                        if (flowCollector.emit(t3, flowKt__TransformKt$runningReduce$1$1$emit$12) == coroutine_suspended) {
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
        flowKt__TransformKt$runningReduce$1$1$emit$1 = new FlowKt__TransformKt$runningReduce$1$1$emit$1(this, continuation);
        flowKt__TransformKt$runningReduce$1$1$emit$12 = flowKt__TransformKt$runningReduce$1$1$emit$1;
        Object $result2 = flowKt__TransformKt$runningReduce$1$1$emit$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (flowKt__TransformKt$runningReduce$1$1$emit$12.label) {
        }
    }
}