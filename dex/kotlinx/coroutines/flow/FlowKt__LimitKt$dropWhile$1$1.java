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
/* compiled from: Limit.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "T", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class FlowKt__LimitKt$dropWhile$1$1<T> implements FlowCollector {
    final /* synthetic */ Ref.BooleanRef $matched;
    final /* synthetic */ Function2<T, Continuation<? super Boolean>, Object> $predicate;
    final /* synthetic */ FlowCollector<T> $this_unsafeFlow;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__LimitKt$dropWhile$1$1(Ref.BooleanRef booleanRef, FlowCollector<? super T> flowCollector, Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2) {
        this.$matched = booleanRef;
        this.$this_unsafeFlow = flowCollector;
        this.$predicate = function2;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x006d  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object emit(T t, Continuation<? super Unit> continuation) {
        FlowKt__LimitKt$dropWhile$1$1$emit$1 flowKt__LimitKt$dropWhile$1$1$emit$1;
        FlowKt__LimitKt$dropWhile$1$1$emit$1 flowKt__LimitKt$dropWhile$1$1$emit$12;
        FlowKt__LimitKt$dropWhile$1$1 flowKt__LimitKt$dropWhile$1$1;
        Object invoke;
        if (continuation instanceof FlowKt__LimitKt$dropWhile$1$1$emit$1) {
            flowKt__LimitKt$dropWhile$1$1$emit$1 = (FlowKt__LimitKt$dropWhile$1$1$emit$1) continuation;
            if ((flowKt__LimitKt$dropWhile$1$1$emit$1.label & IntCompanionObject.MIN_VALUE) != 0) {
                flowKt__LimitKt$dropWhile$1$1$emit$1.label -= IntCompanionObject.MIN_VALUE;
                flowKt__LimitKt$dropWhile$1$1$emit$12 = flowKt__LimitKt$dropWhile$1$1$emit$1;
                Object $result = flowKt__LimitKt$dropWhile$1$1$emit$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (flowKt__LimitKt$dropWhile$1$1$emit$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        flowKt__LimitKt$dropWhile$1$1 = this;
                        if (flowKt__LimitKt$dropWhile$1$1.$matched.element) {
                            FlowCollector<T> flowCollector = flowKt__LimitKt$dropWhile$1$1.$this_unsafeFlow;
                            flowKt__LimitKt$dropWhile$1$1$emit$12.label = 1;
                            Object value = flowCollector.emit(t, flowKt__LimitKt$dropWhile$1$1$emit$12);
                            if (value == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            return Unit.INSTANCE;
                        }
                        Function2<T, Continuation<? super Boolean>, Object> function2 = flowKt__LimitKt$dropWhile$1$1.$predicate;
                        flowKt__LimitKt$dropWhile$1$1$emit$12.L$0 = flowKt__LimitKt$dropWhile$1$1;
                        flowKt__LimitKt$dropWhile$1$1$emit$12.L$1 = t;
                        flowKt__LimitKt$dropWhile$1$1$emit$12.label = 2;
                        invoke = function2.invoke(t, flowKt__LimitKt$dropWhile$1$1$emit$12);
                        if (invoke == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        if (!((Boolean) invoke).booleanValue()) {
                            flowKt__LimitKt$dropWhile$1$1.$matched.element = true;
                            flowKt__LimitKt$dropWhile$1$1$emit$12.L$0 = null;
                            flowKt__LimitKt$dropWhile$1$1$emit$12.L$1 = null;
                            flowKt__LimitKt$dropWhile$1$1$emit$12.label = 3;
                            Object value2 = flowKt__LimitKt$dropWhile$1$1.$this_unsafeFlow.emit(t, flowKt__LimitKt$dropWhile$1$1$emit$12);
                            if (value2 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        return Unit.INSTANCE;
                    case 1:
                    case 3:
                        ResultKt.throwOnFailure($result);
                        return Unit.INSTANCE;
                    case 2:
                        t = (T) flowKt__LimitKt$dropWhile$1$1$emit$12.L$1;
                        flowKt__LimitKt$dropWhile$1$1 = (FlowKt__LimitKt$dropWhile$1$1) flowKt__LimitKt$dropWhile$1$1$emit$12.L$0;
                        ResultKt.throwOnFailure($result);
                        invoke = $result;
                        if (!((Boolean) invoke).booleanValue()) {
                        }
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        flowKt__LimitKt$dropWhile$1$1$emit$1 = new FlowKt__LimitKt$dropWhile$1$1$emit$1(this, continuation);
        flowKt__LimitKt$dropWhile$1$1$emit$12 = flowKt__LimitKt$dropWhile$1$1$emit$1;
        Object $result2 = flowKt__LimitKt$dropWhile$1$1$emit$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (flowKt__LimitKt$dropWhile$1$1$emit$12.label) {
        }
    }
}