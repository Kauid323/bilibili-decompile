package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.IntCompanionObject;
import kotlinx.coroutines.flow.internal.AbortFlowException;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: Limit.kt */
@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"kotlinx/coroutines/flow/FlowKt__LimitKt$collectWhile$collector$1", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 176)
public final class FlowKt__LimitKt$collectWhile$collector$1<T> implements FlowCollector<T> {
    final /* synthetic */ Function2<T, Continuation<? super Boolean>, Object> $predicate;

    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__LimitKt$collectWhile$collector$1(Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2) {
        this.$predicate = function2;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0054  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object emit(T t, Continuation<? super Unit> continuation) {
        FlowKt__LimitKt$collectWhile$collector$1$emit$1 flowKt__LimitKt$collectWhile$collector$1$emit$1;
        FlowKt__LimitKt$collectWhile$collector$1$emit$1 flowKt__LimitKt$collectWhile$collector$1$emit$12;
        FlowKt__LimitKt$collectWhile$collector$1 flowKt__LimitKt$collectWhile$collector$1;
        Object value;
        if (continuation instanceof FlowKt__LimitKt$collectWhile$collector$1$emit$1) {
            flowKt__LimitKt$collectWhile$collector$1$emit$1 = (FlowKt__LimitKt$collectWhile$collector$1$emit$1) continuation;
            if ((flowKt__LimitKt$collectWhile$collector$1$emit$1.label & IntCompanionObject.MIN_VALUE) != 0) {
                flowKt__LimitKt$collectWhile$collector$1$emit$1.label -= IntCompanionObject.MIN_VALUE;
                flowKt__LimitKt$collectWhile$collector$1$emit$12 = flowKt__LimitKt$collectWhile$collector$1$emit$1;
                Object $result = flowKt__LimitKt$collectWhile$collector$1$emit$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (flowKt__LimitKt$collectWhile$collector$1$emit$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        flowKt__LimitKt$collectWhile$collector$1 = this;
                        Function2<T, Continuation<? super Boolean>, Object> function2 = flowKt__LimitKt$collectWhile$collector$1.$predicate;
                        flowKt__LimitKt$collectWhile$collector$1$emit$12.L$0 = flowKt__LimitKt$collectWhile$collector$1;
                        flowKt__LimitKt$collectWhile$collector$1$emit$12.label = 1;
                        value = function2.invoke(t, flowKt__LimitKt$collectWhile$collector$1$emit$12);
                        if (value == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        ResultKt.throwOnFailure($result);
                        flowKt__LimitKt$collectWhile$collector$1 = (FlowKt__LimitKt$collectWhile$collector$1) flowKt__LimitKt$collectWhile$collector$1$emit$12.L$0;
                        value = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                if (((Boolean) value).booleanValue()) {
                    throw new AbortFlowException(flowKt__LimitKt$collectWhile$collector$1);
                }
                return Unit.INSTANCE;
            }
        }
        flowKt__LimitKt$collectWhile$collector$1$emit$1 = new FlowKt__LimitKt$collectWhile$collector$1$emit$1(this, continuation);
        flowKt__LimitKt$collectWhile$collector$1$emit$12 = flowKt__LimitKt$collectWhile$collector$1$emit$1;
        Object $result2 = flowKt__LimitKt$collectWhile$collector$1$emit$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (flowKt__LimitKt$collectWhile$collector$1$emit$12.label) {
        }
        if (((Boolean) value).booleanValue()) {
        }
    }

    public Object emit$$forInline(T t, Continuation<? super Unit> continuation) {
        InlineMarker.mark(4);
        new FlowKt__LimitKt$collectWhile$collector$1$emit$1(this, continuation);
        InlineMarker.mark(5);
        if (!((Boolean) this.$predicate.invoke(t, continuation)).booleanValue()) {
            throw new AbortFlowException(this);
        }
        return Unit.INSTANCE;
    }
}