package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.IntCompanionObject;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: SafeCollector.common.kt */
@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@¢\u0006\u0002\u0010\u0006¨\u0006\u0007¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1<T> implements Flow<T> {
    final /* synthetic */ Function4 $predicate$inlined;
    final /* synthetic */ Flow $this_retryWhen$inlined;

    /* compiled from: SafeCollector.common.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1", f = "Errors.kt", i = {0, 0, 0, 0, 1, 1, 1, 1}, l = {116, 118}, m = "collect", n = {"this", "$this$retryWhen_u24lambda_u242", "attempt", "shallRetry", "this", "$this$retryWhen_u24lambda_u242", "cause", "attempt"}, s = {"L$0", "L$1", "J$0", "I$0", "L$0", "L$1", "L$2", "J$0"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= IntCompanionObject.MIN_VALUE;
            return FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1.this.collect(null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x007e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00d0  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x00ac -> B:25:0x00b0). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x00c6 -> B:30:0x00cd). Please submit an issue!!! */
    @Override // kotlinx.coroutines.flow.Flow
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object collect(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
        AnonymousClass1 anonymousClass1;
        AnonymousClass1 anonymousClass12;
        int $this$retryWhen_u24lambda_u242;
        long attempt;
        FlowCollector<? super T> flowCollector2;
        FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1 flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1;
        int i;
        Object obj;
        Object $result;
        Throwable cause;
        Throwable cause2;
        FlowCollector<? super T> flowCollector3;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & IntCompanionObject.MIN_VALUE) != 0) {
                anonymousClass1.label -= IntCompanionObject.MIN_VALUE;
                anonymousClass12 = anonymousClass1;
                Object $result2 = anonymousClass12.result;
                Object $result3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (anonymousClass12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result2);
                        FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1 flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$12 = this;
                        int i2 = 0;
                        long attempt2 = 0;
                        i = 0;
                        Flow flow = flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$12.$this_retryWhen$inlined;
                        anonymousClass12.L$0 = flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$12;
                        anonymousClass12.L$1 = flowCollector;
                        anonymousClass12.L$2 = null;
                        anonymousClass12.J$0 = attempt2;
                        anonymousClass12.I$0 = 0;
                        anonymousClass12.label = 1;
                        Object catchImpl = FlowKt.catchImpl(flow, flowCollector, anonymousClass12);
                        if (catchImpl == $result3) {
                            return $result3;
                        }
                        flowCollector2 = flowCollector;
                        $this$retryWhen_u24lambda_u242 = i2;
                        attempt = attempt2;
                        Object obj2 = $result3;
                        $result = $result2;
                        $result2 = catchImpl;
                        flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1 = flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$12;
                        obj = obj2;
                        cause = (Throwable) $result2;
                        if (cause == null) {
                            Function4 function4 = flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1.$predicate$inlined;
                            Long boxLong = Boxing.boxLong(attempt);
                            anonymousClass12.L$0 = flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1;
                            anonymousClass12.L$1 = flowCollector2;
                            anonymousClass12.L$2 = cause;
                            anonymousClass12.J$0 = attempt;
                            anonymousClass12.label = 2;
                            InlineMarker.mark(6);
                            Object invoke = function4.invoke(flowCollector2, cause, boxLong, anonymousClass12);
                            InlineMarker.mark(7);
                            if (invoke == obj) {
                                return obj;
                            }
                            FlowCollector<? super T> flowCollector4 = flowCollector2;
                            cause2 = cause;
                            $result2 = invoke;
                            flowCollector3 = flowCollector4;
                            if (((Boolean) $result2).booleanValue()) {
                                throw cause2;
                            }
                            attempt2 = attempt + 1;
                            i2 = $this$retryWhen_u24lambda_u242;
                            flowCollector = flowCollector3;
                            i = 1;
                            $result2 = $result;
                            $result3 = obj;
                            flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$12 = flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1;
                            if (i == 0) {
                                return Unit.INSTANCE;
                            }
                            i = 0;
                            Flow flow2 = flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$12.$this_retryWhen$inlined;
                            anonymousClass12.L$0 = flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$12;
                            anonymousClass12.L$1 = flowCollector;
                            anonymousClass12.L$2 = null;
                            anonymousClass12.J$0 = attempt2;
                            anonymousClass12.I$0 = 0;
                            anonymousClass12.label = 1;
                            Object catchImpl2 = FlowKt.catchImpl(flow2, flowCollector, anonymousClass12);
                            if (catchImpl2 == $result3) {
                            }
                        } else {
                            $result2 = $result;
                            $result3 = obj;
                            flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$12 = flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1;
                            long j = attempt;
                            i2 = $this$retryWhen_u24lambda_u242;
                            flowCollector = flowCollector2;
                            attempt2 = j;
                            if (i == 0) {
                            }
                            i = 0;
                            Flow flow22 = flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$12.$this_retryWhen$inlined;
                            anonymousClass12.L$0 = flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$12;
                            anonymousClass12.L$1 = flowCollector;
                            anonymousClass12.L$2 = null;
                            anonymousClass12.J$0 = attempt2;
                            anonymousClass12.I$0 = 0;
                            anonymousClass12.label = 1;
                            Object catchImpl22 = FlowKt.catchImpl(flow22, flowCollector, anonymousClass12);
                            if (catchImpl22 == $result3) {
                            }
                        }
                    case 1:
                        $this$retryWhen_u24lambda_u242 = 0;
                        int i3 = anonymousClass12.I$0;
                        attempt = anonymousClass12.J$0;
                        flowCollector2 = (FlowCollector) anonymousClass12.L$1;
                        ResultKt.throwOnFailure($result2);
                        flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1 = (FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1) anonymousClass12.L$0;
                        i = i3;
                        obj = $result3;
                        $result = $result2;
                        cause = (Throwable) $result2;
                        if (cause == null) {
                        }
                        break;
                    case 2:
                        $this$retryWhen_u24lambda_u242 = 0;
                        long attempt3 = anonymousClass12.J$0;
                        ResultKt.throwOnFailure($result2);
                        flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1 = (FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1) anonymousClass12.L$0;
                        flowCollector3 = (FlowCollector) anonymousClass12.L$1;
                        cause2 = (Throwable) anonymousClass12.L$2;
                        attempt = attempt3;
                        obj = $result3;
                        $result = $result2;
                        if (((Boolean) $result2).booleanValue()) {
                        }
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        anonymousClass1 = new AnonymousClass1(continuation);
        anonymousClass12 = anonymousClass1;
        Object $result22 = anonymousClass12.result;
        Object $result32 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (anonymousClass12.label) {
        }
    }

    public FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1(Flow flow, Function4 function4) {
        this.$this_retryWhen$inlined = flow;
        this.$predicate$inlined = function4;
    }
}