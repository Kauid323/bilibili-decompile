package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Ref;

/* compiled from: Count.kt */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a\u001e\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0086@¢\u0006\u0002\u0010\u0004\u001aB\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\"\u0010\u0005\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0006H\u0086@¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"count", "", "T", "Lkotlinx/coroutines/flow/Flow;", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "predicate", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 5, mv = {1, 9, 0}, xi = 48, xs = "kotlinx/coroutines/flow/FlowKt")
final /* synthetic */ class FlowKt__CountKt {
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object count(Flow<? extends T> flow, Continuation<? super Integer> continuation) {
        FlowKt__CountKt$count$1 flowKt__CountKt$count$1;
        FlowKt__CountKt$count$1 flowKt__CountKt$count$12;
        Ref.IntRef i;
        if (continuation instanceof FlowKt__CountKt$count$1) {
            flowKt__CountKt$count$1 = (FlowKt__CountKt$count$1) continuation;
            if ((flowKt__CountKt$count$1.label & IntCompanionObject.MIN_VALUE) != 0) {
                flowKt__CountKt$count$1.label -= IntCompanionObject.MIN_VALUE;
                flowKt__CountKt$count$12 = flowKt__CountKt$count$1;
                Object $result = flowKt__CountKt$count$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (flowKt__CountKt$count$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        final Ref.IntRef i2 = new Ref.IntRef();
                        flowKt__CountKt$count$12.L$0 = i2;
                        flowKt__CountKt$count$12.label = 1;
                        if (flow.collect(new FlowCollector() { // from class: kotlinx.coroutines.flow.FlowKt__CountKt$count$2
                            @Override // kotlinx.coroutines.flow.FlowCollector
                            public final Object emit(T t, Continuation<? super Unit> continuation2) {
                                Ref.IntRef.this.element++;
                                int i3 = Ref.IntRef.this.element;
                                return Unit.INSTANCE;
                            }
                        }, flowKt__CountKt$count$12) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        i = i2;
                        break;
                    case 1:
                        i = (Ref.IntRef) flowKt__CountKt$count$12.L$0;
                        ResultKt.throwOnFailure($result);
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return Boxing.boxInt(i.element);
            }
        }
        flowKt__CountKt$count$1 = new FlowKt__CountKt$count$1(continuation);
        flowKt__CountKt$count$12 = flowKt__CountKt$count$1;
        Object $result2 = flowKt__CountKt$count$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (flowKt__CountKt$count$12.label) {
        }
        return Boxing.boxInt(i.element);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object count(Flow<? extends T> flow, Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2, Continuation<? super Integer> continuation) {
        FlowKt__CountKt$count$3 flowKt__CountKt$count$3;
        FlowKt__CountKt$count$3 flowKt__CountKt$count$32;
        Ref.IntRef i;
        if (continuation instanceof FlowKt__CountKt$count$3) {
            flowKt__CountKt$count$3 = (FlowKt__CountKt$count$3) continuation;
            if ((flowKt__CountKt$count$3.label & IntCompanionObject.MIN_VALUE) != 0) {
                flowKt__CountKt$count$3.label -= IntCompanionObject.MIN_VALUE;
                flowKt__CountKt$count$32 = flowKt__CountKt$count$3;
                Object $result = flowKt__CountKt$count$32.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (flowKt__CountKt$count$32.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        Ref.IntRef i2 = new Ref.IntRef();
                        flowKt__CountKt$count$32.L$0 = i2;
                        flowKt__CountKt$count$32.label = 1;
                        if (flow.collect(new FlowKt__CountKt$count$4<>(function2, i2), flowKt__CountKt$count$32) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        i = i2;
                        break;
                    case 1:
                        i = (Ref.IntRef) flowKt__CountKt$count$32.L$0;
                        ResultKt.throwOnFailure($result);
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return Boxing.boxInt(i.element);
            }
        }
        flowKt__CountKt$count$3 = new FlowKt__CountKt$count$3(continuation);
        flowKt__CountKt$count$32 = flowKt__CountKt$count$3;
        Object $result2 = flowKt__CountKt$count$32.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (flowKt__CountKt$count$32.label) {
        }
        return Boxing.boxInt(i.element);
    }
}