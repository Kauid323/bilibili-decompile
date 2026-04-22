package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.IntCompanionObject;
import kotlinx.coroutines.flow.internal.SafeCollector;
import kotlinx.coroutines.scheduling.WorkQueueKt;
import org.webrtc.H265Utils;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: SafeCollector.common.kt */
@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@¢\u0006\u0002\u0010\u0006¨\u0006\u0007¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1<T> implements Flow<T> {
    final /* synthetic */ Function3 $action$inlined;
    final /* synthetic */ Flow $this_onCompletion$inlined;

    /* compiled from: SafeCollector.common.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1", f = "Emitters.kt", i = {0, 0, 1, 2}, l = {113, H265Utils.kLevel4, WorkQueueKt.MASK}, m = "collect", n = {"this", "$this$onCompletion_u24lambda_u242", "e", "sc"}, s = {"L$0", "L$1", "L$0", "L$0"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= IntCompanionObject.MIN_VALUE;
            return FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1.this.collect(null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x008e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x008f  */
    @Override // kotlinx.coroutines.flow.Flow
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object collect(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
        AnonymousClass1 anonymousClass1;
        AnonymousClass1 anonymousClass12;
        Object coroutine_suspended;
        Object invokeSafely$FlowKt__EmittersKt;
        FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1 flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1;
        FlowCollector $this$onCompletion_u24lambda_u242;
        SafeCollector sc;
        Throwable th;
        SafeCollector sc2;
        Object invoke;
        try {
            if (continuation instanceof AnonymousClass1) {
                anonymousClass1 = (AnonymousClass1) continuation;
                if ((anonymousClass1.label & IntCompanionObject.MIN_VALUE) != 0) {
                    anonymousClass1.label -= IntCompanionObject.MIN_VALUE;
                    anonymousClass12 = anonymousClass1;
                    Object $result = anonymousClass12.result;
                    coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (anonymousClass12.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1 = this;
                            $this$onCompletion_u24lambda_u242 = flowCollector;
                            Flow flow = flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1.$this_onCompletion$inlined;
                            anonymousClass12.L$0 = flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1;
                            anonymousClass12.L$1 = $this$onCompletion_u24lambda_u242;
                            anonymousClass12.label = 1;
                            if (flow.collect($this$onCompletion_u24lambda_u242, anonymousClass12) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            sc = new SafeCollector($this$onCompletion_u24lambda_u242, anonymousClass12.getContext());
                            try {
                                Function3 function3 = flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1.$action$inlined;
                                anonymousClass12.L$0 = sc;
                                anonymousClass12.L$1 = null;
                                anonymousClass12.label = 3;
                                InlineMarker.mark(6);
                                invoke = function3.invoke(sc, null, anonymousClass12);
                                InlineMarker.mark(7);
                                if (invoke != coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                sc2 = sc;
                                sc2.releaseIntercepted();
                                return Unit.INSTANCE;
                            } catch (Throwable th2) {
                                th = th2;
                                sc2 = sc;
                                sc2.releaseIntercepted();
                                throw th;
                            }
                        case 1:
                            $this$onCompletion_u24lambda_u242 = (FlowCollector) anonymousClass12.L$1;
                            flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1 = (FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1) anonymousClass12.L$0;
                            ResultKt.throwOnFailure($result);
                            sc = new SafeCollector($this$onCompletion_u24lambda_u242, anonymousClass12.getContext());
                            Function3 function32 = flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1.$action$inlined;
                            anonymousClass12.L$0 = sc;
                            anonymousClass12.L$1 = null;
                            anonymousClass12.label = 3;
                            InlineMarker.mark(6);
                            invoke = function32.invoke(sc, null, anonymousClass12);
                            InlineMarker.mark(7);
                            if (invoke != coroutine_suspended) {
                            }
                            break;
                        case 2:
                            Throwable e = (Throwable) anonymousClass12.L$0;
                            ResultKt.throwOnFailure($result);
                            throw e;
                        case 3:
                            sc2 = (SafeCollector) anonymousClass12.L$0;
                            try {
                                ResultKt.throwOnFailure($result);
                                sc2.releaseIntercepted();
                                return Unit.INSTANCE;
                            } catch (Throwable th3) {
                                th = th3;
                                sc2.releaseIntercepted();
                                throw th;
                            }
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }
            }
            switch (anonymousClass12.label) {
            }
        } catch (Throwable e2) {
            Function3 function33 = flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1.$action$inlined;
            anonymousClass12.L$0 = e2;
            anonymousClass12.L$1 = null;
            anonymousClass12.label = 2;
            invokeSafely$FlowKt__EmittersKt = FlowKt__EmittersKt.invokeSafely$FlowKt__EmittersKt(new ThrowingCollector(e2), function33, e2, anonymousClass12);
            if (invokeSafely$FlowKt__EmittersKt == coroutine_suspended) {
                return coroutine_suspended;
            }
            throw e2;
        }
        anonymousClass1 = new AnonymousClass1(continuation);
        anonymousClass12 = anonymousClass1;
        Object $result2 = anonymousClass12.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    }

    public FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1(Flow flow, Function3 function3) {
        this.$this_onCompletion$inlined = flow;
        this.$action$inlined = function3;
    }
}