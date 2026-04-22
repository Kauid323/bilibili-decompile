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
public final class FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$7 implements Flow<Integer> {
    final /* synthetic */ int[] $this_asFlow$inlined;

    /* compiled from: SafeCollector.common.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$7", f = "Builders.kt", i = {0, 0}, l = {114}, m = "collect", n = {"$this$asFlow_u24lambda_u2413", "$this$forEach$iv"}, s = {"L$0", "L$1"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$7$1  reason: invalid class name */
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
            return FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$7.this.collect(null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0073  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x006f -> B:19:0x0070). Please submit an issue!!! */
    @Override // kotlinx.coroutines.flow.Flow
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object collect(FlowCollector<? super Integer> flowCollector, Continuation<? super Unit> continuation) {
        AnonymousClass1 anonymousClass1;
        AnonymousClass1 anonymousClass12;
        FlowCollector $this$asFlow_u24lambda_u2413;
        int[] $this$forEach$iv;
        int $i$f$forEach;
        int i;
        FlowCollector $this$asFlow_u24lambda_u24132;
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
                        int[] $this$forEach$iv2 = this.$this_asFlow$inlined;
                        $this$asFlow_u24lambda_u2413 = flowCollector;
                        $this$forEach$iv = $this$forEach$iv2;
                        $i$f$forEach = $this$forEach$iv2.length;
                        i = 0;
                        break;
                    case 1:
                        $i$f$forEach = anonymousClass12.I$1;
                        i = anonymousClass12.I$0;
                        $this$forEach$iv = (int[]) anonymousClass12.L$1;
                        ResultKt.throwOnFailure($result);
                        $this$asFlow_u24lambda_u24132 = (FlowCollector) anonymousClass12.L$0;
                        i++;
                        $this$asFlow_u24lambda_u2413 = $this$asFlow_u24lambda_u24132;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                if (i < $i$f$forEach) {
                    int value = $this$forEach$iv[i];
                    Integer boxInt = Boxing.boxInt(value);
                    anonymousClass12.L$0 = $this$asFlow_u24lambda_u2413;
                    anonymousClass12.L$1 = $this$forEach$iv;
                    anonymousClass12.I$0 = i;
                    anonymousClass12.I$1 = $i$f$forEach;
                    anonymousClass12.label = 1;
                    if ($this$asFlow_u24lambda_u2413.emit(boxInt, anonymousClass12) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $this$asFlow_u24lambda_u24132 = $this$asFlow_u24lambda_u2413;
                    i++;
                    $this$asFlow_u24lambda_u2413 = $this$asFlow_u24lambda_u24132;
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

    public FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$7(int[] iArr) {
        this.$this_asFlow$inlined = iArr;
    }
}