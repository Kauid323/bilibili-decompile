package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.internal.SafeCollector;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: SafeCollector.common.kt */
@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@¢\u0006\u0002\u0010\u0006¨\u0006\u0007¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class FlowKt__EmittersKt$onEmpty$$inlined$unsafeFlow$1<T> implements Flow<T> {
    final /* synthetic */ Function2 $action$inlined;
    final /* synthetic */ Flow $this_onEmpty$inlined;

    /* compiled from: SafeCollector.common.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__EmittersKt$onEmpty$$inlined$unsafeFlow$1", f = "Emitters.kt", i = {0, 0, 0, 1}, l = {113, 121}, m = "collect", n = {"this", "$this$onEmpty_u24lambda_u243", "isEmpty", "collector"}, s = {"L$0", "L$1", "L$2", "L$0"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__EmittersKt$onEmpty$$inlined$unsafeFlow$1$1  reason: invalid class name */
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
            return FlowKt__EmittersKt$onEmpty$$inlined$unsafeFlow$1.this.collect(null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0077  */
    @Override // kotlinx.coroutines.flow.Flow
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object collect(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
        AnonymousClass1 anonymousClass1;
        AnonymousClass1 anonymousClass12;
        FlowKt__EmittersKt$onEmpty$$inlined$unsafeFlow$1 flowKt__EmittersKt$onEmpty$$inlined$unsafeFlow$1;
        FlowCollector $this$onEmpty_u24lambda_u243;
        Ref.BooleanRef isEmpty;
        Throwable th;
        SafeCollector collector;
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
                        flowKt__EmittersKt$onEmpty$$inlined$unsafeFlow$1 = this;
                        $this$onEmpty_u24lambda_u243 = flowCollector;
                        isEmpty = new Ref.BooleanRef();
                        isEmpty.element = true;
                        anonymousClass12.L$0 = flowKt__EmittersKt$onEmpty$$inlined$unsafeFlow$1;
                        anonymousClass12.L$1 = $this$onEmpty_u24lambda_u243;
                        anonymousClass12.L$2 = isEmpty;
                        anonymousClass12.label = 1;
                        if (flowKt__EmittersKt$onEmpty$$inlined$unsafeFlow$1.$this_onEmpty$inlined.collect(new FlowKt__EmittersKt$onEmpty$1$1(isEmpty, $this$onEmpty_u24lambda_u243), anonymousClass12) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        if (isEmpty.element) {
                            SafeCollector collector2 = new SafeCollector($this$onEmpty_u24lambda_u243, anonymousClass12.getContext());
                            try {
                                Function2 function2 = flowKt__EmittersKt$onEmpty$$inlined$unsafeFlow$1.$action$inlined;
                                anonymousClass12.L$0 = collector2;
                                anonymousClass12.L$1 = null;
                                anonymousClass12.L$2 = null;
                                anonymousClass12.label = 2;
                                InlineMarker.mark(6);
                                Object invoke = function2.invoke(collector2, anonymousClass12);
                                InlineMarker.mark(7);
                                if (invoke == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                collector = collector2;
                                collector.releaseIntercepted();
                            } catch (Throwable th2) {
                                th = th2;
                                collector = collector2;
                                collector.releaseIntercepted();
                                throw th;
                            }
                        }
                        return Unit.INSTANCE;
                    case 1:
                        isEmpty = (Ref.BooleanRef) anonymousClass12.L$2;
                        $this$onEmpty_u24lambda_u243 = (FlowCollector) anonymousClass12.L$1;
                        flowKt__EmittersKt$onEmpty$$inlined$unsafeFlow$1 = (FlowKt__EmittersKt$onEmpty$$inlined$unsafeFlow$1) anonymousClass12.L$0;
                        ResultKt.throwOnFailure($result);
                        if (isEmpty.element) {
                        }
                        return Unit.INSTANCE;
                    case 2:
                        collector = (SafeCollector) anonymousClass12.L$0;
                        try {
                            ResultKt.throwOnFailure($result);
                            collector.releaseIntercepted();
                            return Unit.INSTANCE;
                        } catch (Throwable th3) {
                            th = th3;
                            collector.releaseIntercepted();
                            throw th;
                        }
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

    public FlowKt__EmittersKt$onEmpty$$inlined$unsafeFlow$1(Flow flow, Function2 function2) {
        this.$this_onEmpty$inlined = flow;
        this.$action$inlined = function2;
    }
}