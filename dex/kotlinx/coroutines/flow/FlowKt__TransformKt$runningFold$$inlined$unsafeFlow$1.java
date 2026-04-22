package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Ref;

/* JADX INFO: Add missing generic type declarations: [R] */
/* compiled from: SafeCollector.common.kt */
@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@¢\u0006\u0002\u0010\u0006¨\u0006\u0007¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class FlowKt__TransformKt$runningFold$$inlined$unsafeFlow$1<R> implements Flow<R> {
    final /* synthetic */ Object $initial$inlined;
    final /* synthetic */ Function3 $operation$inlined;
    final /* synthetic */ Flow $this_runningFold$inlined;

    /* compiled from: SafeCollector.common.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__TransformKt$runningFold$$inlined$unsafeFlow$1", f = "Transform.kt", i = {0, 0, 0}, l = {113, 114}, m = "collect", n = {"this", "$this$runningFold_u24lambda_u249", "accumulator"}, s = {"L$0", "L$1", "L$2"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__TransformKt$runningFold$$inlined$unsafeFlow$1$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class AnonymousClass1 extends ContinuationImpl {
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
            return FlowKt__TransformKt$runningFold$$inlined$unsafeFlow$1.this.collect(null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0082 A[RETURN] */
    /* JADX WARN: Type inference failed for: r5v0, types: [T, java.lang.Object] */
    @Override // kotlinx.coroutines.flow.Flow
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object collect(FlowCollector<? super R> flowCollector, Continuation<? super Unit> continuation) {
        AnonymousClass1 anonymousClass1;
        AnonymousClass1 anonymousClass12;
        FlowKt__TransformKt$runningFold$$inlined$unsafeFlow$1 flowKt__TransformKt$runningFold$$inlined$unsafeFlow$1;
        Ref.ObjectRef accumulator;
        FlowCollector $this$runningFold_u24lambda_u249;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & IntCompanionObject.MIN_VALUE) != 0) {
                anonymousClass1.label -= IntCompanionObject.MIN_VALUE;
                anonymousClass12 = anonymousClass1;
                Object $result = anonymousClass12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (anonymousClass12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        flowKt__TransformKt$runningFold$$inlined$unsafeFlow$1 = this;
                        FlowCollector $this$runningFold_u24lambda_u2492 = flowCollector;
                        accumulator = new Ref.ObjectRef();
                        accumulator.element = flowKt__TransformKt$runningFold$$inlined$unsafeFlow$1.$initial$inlined;
                        anonymousClass12.L$0 = flowKt__TransformKt$runningFold$$inlined$unsafeFlow$1;
                        anonymousClass12.L$1 = $this$runningFold_u24lambda_u2492;
                        anonymousClass12.L$2 = accumulator;
                        anonymousClass12.label = 1;
                        Object emit = $this$runningFold_u24lambda_u2492.emit((Object) accumulator.element, anonymousClass12);
                        $this$runningFold_u24lambda_u249 = $this$runningFold_u24lambda_u2492;
                        if (emit == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        anonymousClass12.L$0 = null;
                        anonymousClass12.L$1 = null;
                        anonymousClass12.L$2 = null;
                        anonymousClass12.label = 2;
                        if (flowKt__TransformKt$runningFold$$inlined$unsafeFlow$1.$this_runningFold$inlined.collect(new FlowKt__TransformKt$runningFold$1$1(accumulator, flowKt__TransformKt$runningFold$$inlined$unsafeFlow$1.$operation$inlined, $this$runningFold_u24lambda_u249), anonymousClass12) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    case 1:
                        accumulator = (Ref.ObjectRef) anonymousClass12.L$2;
                        flowKt__TransformKt$runningFold$$inlined$unsafeFlow$1 = (FlowKt__TransformKt$runningFold$$inlined$unsafeFlow$1) anonymousClass12.L$0;
                        ResultKt.throwOnFailure($result);
                        $this$runningFold_u24lambda_u249 = (FlowCollector) anonymousClass12.L$1;
                        anonymousClass12.L$0 = null;
                        anonymousClass12.L$1 = null;
                        anonymousClass12.L$2 = null;
                        anonymousClass12.label = 2;
                        if (flowKt__TransformKt$runningFold$$inlined$unsafeFlow$1.$this_runningFold$inlined.collect(new FlowKt__TransformKt$runningFold$1$1(accumulator, flowKt__TransformKt$runningFold$$inlined$unsafeFlow$1.$operation$inlined, $this$runningFold_u24lambda_u249), anonymousClass12) == coroutine_suspended) {
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
        anonymousClass1 = new AnonymousClass1(continuation);
        anonymousClass12 = anonymousClass1;
        Object $result2 = anonymousClass12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (anonymousClass12.label) {
        }
    }

    public FlowKt__TransformKt$runningFold$$inlined$unsafeFlow$1(Object obj, Flow flow, Function3 function3) {
        this.$initial$inlined = obj;
        this.$this_runningFold$inlined = flow;
        this.$operation$inlined = function3;
    }
}