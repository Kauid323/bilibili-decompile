package kntr.base.primer;

import java.util.Map;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.log.KLog_androidKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.atomicfu.AtomicRef;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: KPrimer.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\u0010\u0000\u001a\u00020\u0001*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", ""}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.base.primer.KPrimer$handle$1", f = "KPrimer.kt", i = {0, 1, 2, 2}, l = {182, 187, 193}, m = "invokeSuspend", n = {"$this$flow", "$this$flow", "$this$flow", "value"}, s = {"L$0", "L$0", "L$0", "L$1"}, v = 1)
public final class KPrimer$handle$1 extends SuspendLambda implements Function2<FlowCollector<? super byte[]>, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $bizKey;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ KPrimer this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KPrimer$handle$1(String str, KPrimer kPrimer, Continuation<? super KPrimer$handle$1> continuation) {
        super(2, continuation);
        this.$bizKey = str;
        this.this$0 = kPrimer;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> kPrimer$handle$1 = new KPrimer$handle$1(this.$bizKey, this.this$0, continuation);
        kPrimer$handle$1.L$0 = obj;
        return kPrimer$handle$1;
    }

    public final Object invoke(FlowCollector<? super byte[]> flowCollector, Continuation<? super Unit> continuation) {
        return create(flowCollector, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x012a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x012b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        Object firstOrNull;
        byte[] value;
        AtomicRef atomicRef;
        AtomicRef atomicRef2;
        FlowCollector $this$flow = (FlowCollector) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                KLog_androidKt.getKLog().i("Primer", this.$bizKey + " coming");
                if (!this.this$0.shouldHandle(this.$bizKey)) {
                    this.L$0 = SpillingKt.nullOutSpilledVariable($this$flow);
                    this.label = 1;
                    if ($this$flow.emit((Object) null, (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                }
                KLog_androidKt.getKLog().i("Primer", this.$bizKey + " match " + this.this$0.getKeys$primer_debug());
                final Flow $this$map$iv = this.this$0.getMap();
                final String str = this.$bizKey;
                this.L$0 = $this$flow;
                this.label = 2;
                firstOrNull = FlowKt.firstOrNull(new Flow<byte[]>() { // from class: kntr.base.primer.KPrimer$handle$1$invokeSuspend$$inlined$map$1
                    public Object collect(FlowCollector collector, Continuation $completion) {
                        Object collect = $this$map$iv.collect(new AnonymousClass2(collector, str), $completion);
                        return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
                    }

                    /* compiled from: Emitters.kt */
                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                    /* renamed from: kntr.base.primer.KPrimer$handle$1$invokeSuspend$$inlined$map$1$2  reason: invalid class name */
                    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                    public static final class AnonymousClass2<T> implements FlowCollector {
                        final /* synthetic */ String $bizKey$inlined;
                        final /* synthetic */ FlowCollector $this_unsafeFlow;

                        /* compiled from: Emitters.kt */
                        @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                        @DebugMetadata(c = "kntr.base.primer.KPrimer$handle$1$invokeSuspend$$inlined$map$1$2", f = "KPrimer.kt", i = {0, 0, 0, 0, 0}, l = {219}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"}, v = 1)
                        /* renamed from: kntr.base.primer.KPrimer$handle$1$invokeSuspend$$inlined$map$1$2$1  reason: invalid class name */
                        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                        public static final class AnonymousClass1 extends ContinuationImpl {
                            int I$0;
                            Object L$0;
                            Object L$1;
                            Object L$2;
                            Object L$3;
                            int label;
                            /* synthetic */ Object result;

                            public AnonymousClass1(Continuation continuation) {
                                super(continuation);
                            }

                            public final Object invokeSuspend(Object obj) {
                                this.result = obj;
                                this.label |= Integer.MIN_VALUE;
                                return AnonymousClass2.this.emit(null, (Continuation) this);
                            }
                        }

                        public AnonymousClass2(FlowCollector flowCollector, String str) {
                            this.$this_unsafeFlow = flowCollector;
                            this.$bizKey$inlined = str;
                        }

                        /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
                        /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
                        /* JADX WARN: Removed duplicated region for block: B:13:0x003e  */
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                        */
                        public final Object emit(Object value, Continuation $completion) {
                            Continuation $continuation;
                            if ($completion instanceof AnonymousClass1) {
                                $continuation = (AnonymousClass1) $completion;
                                if (($continuation.label & Integer.MIN_VALUE) != 0) {
                                    $continuation.label -= Integer.MIN_VALUE;
                                    Object $result = $continuation.result;
                                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                    switch ($continuation.label) {
                                        case 0:
                                            ResultKt.throwOnFailure($result);
                                            FlowCollector $this$map_u24lambda_u245 = this.$this_unsafeFlow;
                                            Map it = (Map) value;
                                            Object obj = it.get(this.$bizKey$inlined);
                                            $continuation.L$0 = SpillingKt.nullOutSpilledVariable(value);
                                            $continuation.L$1 = SpillingKt.nullOutSpilledVariable($continuation);
                                            $continuation.L$2 = SpillingKt.nullOutSpilledVariable(value);
                                            $continuation.L$3 = SpillingKt.nullOutSpilledVariable($this$map_u24lambda_u245);
                                            $continuation.I$0 = 0;
                                            $continuation.label = 1;
                                            if ($this$map_u24lambda_u245.emit(obj, $continuation) != coroutine_suspended) {
                                                break;
                                            } else {
                                                return coroutine_suspended;
                                            }
                                        case 1:
                                            int i = $continuation.I$0;
                                            FlowCollector flowCollector = (FlowCollector) $continuation.L$3;
                                            Object obj2 = $continuation.L$2;
                                            AnonymousClass1 anonymousClass1 = (AnonymousClass1) $continuation.L$1;
                                            Object value2 = $continuation.L$0;
                                            ResultKt.throwOnFailure($result);
                                            break;
                                        default:
                                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    }
                                    return Unit.INSTANCE;
                                }
                            }
                            $continuation = new AnonymousClass1($completion);
                            Object $result2 = $continuation.result;
                            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch ($continuation.label) {
                            }
                            return Unit.INSTANCE;
                        }
                    }
                }, (Continuation) this);
                if (firstOrNull == coroutine_suspended) {
                    return coroutine_suspended;
                }
                value = (byte[]) firstOrNull;
                if (value != null) {
                    atomicRef = this.this$0.hitMap;
                    Map map = (Map) atomicRef.getValue();
                    String str2 = this.$bizKey;
                    atomicRef2 = this.this$0.hitMap;
                    Integer num = (Integer) ((Map) atomicRef2.getValue()).get(this.$bizKey);
                    map.put(str2, Boxing.boxInt((num != null ? num.intValue() : 0) + 1));
                }
                KLog_androidKt.getKLog().i("Primer", "Emit " + this.$bizKey + " = " + value);
                this.L$0 = SpillingKt.nullOutSpilledVariable($this$flow);
                this.L$1 = SpillingKt.nullOutSpilledVariable(value);
                this.label = 3;
                return $this$flow.emit(value, (Continuation) this) != coroutine_suspended ? coroutine_suspended : Unit.INSTANCE;
            case 1:
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            case 2:
                ResultKt.throwOnFailure($result);
                firstOrNull = $result;
                value = (byte[]) firstOrNull;
                if (value != null) {
                }
                KLog_androidKt.getKLog().i("Primer", "Emit " + this.$bizKey + " = " + value);
                this.L$0 = SpillingKt.nullOutSpilledVariable($this$flow);
                this.L$1 = SpillingKt.nullOutSpilledVariable(value);
                this.label = 3;
                if ($this$flow.emit(value, (Continuation) this) != coroutine_suspended) {
                }
                break;
            case 3:
                byte[] bArr = (byte[]) this.L$1;
                ResultKt.throwOnFailure($result);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}