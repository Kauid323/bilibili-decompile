package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Ref;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Limit.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "T", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class FlowKt__LimitKt$take$2$1<T> implements FlowCollector {
    final /* synthetic */ Ref.IntRef $consumed;
    final /* synthetic */ int $count;
    final /* synthetic */ Object $ownershipMarker;
    final /* synthetic */ FlowCollector<T> $this_unsafeFlow;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__LimitKt$take$2$1(Ref.IntRef intRef, int i, FlowCollector<? super T> flowCollector, Object obj) {
        this.$consumed = intRef;
        this.$count = i;
        this.$this_unsafeFlow = flowCollector;
        this.$ownershipMarker = obj;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0031  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object emit(T t, Continuation<? super Unit> continuation) {
        FlowKt__LimitKt$take$2$1$emit$1 flowKt__LimitKt$take$2$1$emit$1;
        FlowKt__LimitKt$take$2$1$emit$1 flowKt__LimitKt$take$2$1$emit$12;
        Object value;
        if (continuation instanceof FlowKt__LimitKt$take$2$1$emit$1) {
            flowKt__LimitKt$take$2$1$emit$1 = (FlowKt__LimitKt$take$2$1$emit$1) continuation;
            if ((flowKt__LimitKt$take$2$1$emit$1.label & IntCompanionObject.MIN_VALUE) != 0) {
                flowKt__LimitKt$take$2$1$emit$1.label -= IntCompanionObject.MIN_VALUE;
                flowKt__LimitKt$take$2$1$emit$12 = flowKt__LimitKt$take$2$1$emit$1;
                Object $result = flowKt__LimitKt$take$2$1$emit$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (flowKt__LimitKt$take$2$1$emit$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        this.$consumed.element++;
                        if (this.$consumed.element >= this.$count) {
                            FlowCollector<T> flowCollector = this.$this_unsafeFlow;
                            Object obj = this.$ownershipMarker;
                            flowKt__LimitKt$take$2$1$emit$12.label = 2;
                            value = FlowKt__LimitKt.emitAbort$FlowKt__LimitKt(flowCollector, t, obj, flowKt__LimitKt$take$2$1$emit$12);
                            if (value == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else {
                            FlowCollector<T> flowCollector2 = this.$this_unsafeFlow;
                            flowKt__LimitKt$take$2$1$emit$12.label = 1;
                            Object value2 = flowCollector2.emit(t, flowKt__LimitKt$take$2$1$emit$12);
                            if (value2 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        break;
                    case 1:
                    case 2:
                        ResultKt.throwOnFailure($result);
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return Unit.INSTANCE;
            }
        }
        flowKt__LimitKt$take$2$1$emit$1 = new FlowKt__LimitKt$take$2$1$emit$1(this, continuation);
        flowKt__LimitKt$take$2$1$emit$12 = flowKt__LimitKt$take$2$1$emit$1;
        Object $result2 = flowKt__LimitKt$take$2$1$emit$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (flowKt__LimitKt$take$2$1$emit$12.label) {
        }
        return Unit.INSTANCE;
    }
}