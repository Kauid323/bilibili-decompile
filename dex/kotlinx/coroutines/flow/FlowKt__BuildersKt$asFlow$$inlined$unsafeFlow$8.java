package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.IntCompanionObject;

/* compiled from: SafeCollector.common.kt */
@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@¢\u0006\u0002\u0010\u0006¨\u0006\u0007¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$8 implements Flow<Long> {
    final /* synthetic */ long[] $this_asFlow$inlined;

    /* compiled from: SafeCollector.common.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$8", f = "Builders.kt", i = {0, 0}, l = {114}, m = "collect", n = {"$this$asFlow_u24lambda_u2415", "$this$forEach$iv"}, s = {"L$0", "L$1"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$8$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
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
            return FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$8.this.collect(null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0072  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x006c -> B:18:0x006f). Please submit an issue!!! */
    @Override // kotlinx.coroutines.flow.Flow
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object collect(FlowCollector<? super Long> flowCollector, Continuation<? super Unit> continuation) {
        AnonymousClass1 anonymousClass1;
        AnonymousClass1 anonymousClass12;
        FlowCollector $this$asFlow_u24lambda_u2415;
        long[] $this$forEach$iv;
        int $i$f$forEach;
        int i;
        FlowCollector $this$asFlow_u24lambda_u24152;
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
                        long[] $this$forEach$iv2 = this.$this_asFlow$inlined;
                        $this$asFlow_u24lambda_u2415 = flowCollector;
                        $this$forEach$iv = $this$forEach$iv2;
                        $i$f$forEach = $this$forEach$iv2.length;
                        i = 0;
                        break;
                    case 1:
                        $i$f$forEach = anonymousClass12.I$1;
                        i = anonymousClass12.I$0;
                        $this$forEach$iv = (long[]) anonymousClass12.L$1;
                        ResultKt.throwOnFailure($result);
                        $this$asFlow_u24lambda_u24152 = (FlowCollector) anonymousClass12.L$0;
                        i++;
                        $this$asFlow_u24lambda_u2415 = $this$asFlow_u24lambda_u24152;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                if (i < $i$f$forEach) {
                    long value = $this$forEach$iv[i];
                    Long boxLong = Boxing.boxLong(value);
                    anonymousClass12.L$0 = $this$asFlow_u24lambda_u2415;
                    anonymousClass12.L$1 = $this$forEach$iv;
                    anonymousClass12.I$0 = i;
                    anonymousClass12.I$1 = $i$f$forEach;
                    anonymousClass12.label = 1;
                    Object emit = $this$asFlow_u24lambda_u2415.emit(boxLong, anonymousClass12);
                    $this$asFlow_u24lambda_u24152 = $this$asFlow_u24lambda_u2415;
                    if (emit == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    i++;
                    $this$asFlow_u24lambda_u2415 = $this$asFlow_u24lambda_u24152;
                    if (i < $i$f$forEach) {
                        return Unit.INSTANCE;
                    }
                }
            }
        }
        anonymousClass1 = new AnonymousClass1(continuation);
        anonymousClass12 = anonymousClass1;
        Object $result2 = anonymousClass12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (anonymousClass12.label) {
        }
        if (i < $i$f$forEach) {
        }
    }

    public FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$8(long[] jArr) {
        this.$this_asFlow$inlined = jArr;
    }
}