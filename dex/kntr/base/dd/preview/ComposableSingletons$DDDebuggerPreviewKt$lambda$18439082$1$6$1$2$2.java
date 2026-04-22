package kntr.base.dd.preview;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.dd.IDeviceDecision;
import kntr.base.dd.IDeviceDecisionKt;
import kntr.base.dd.KDeviceDecision;
import kntr.common.trio.toast.Toaster;
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
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.serialization.internal.BooleanSerializer;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DDDebuggerPreview.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.base.dd.preview.ComposableSingletons$DDDebuggerPreviewKt$lambda$-18439082$1$6$1$2$2", f = "DDDebuggerPreview.kt", i = {0}, l = {259}, m = "invokeSuspend", n = {"flow"}, s = {"L$0"}, v = 1)
/* renamed from: kntr.base.dd.preview.ComposableSingletons$DDDebuggerPreviewKt$lambda$-18439082$1$6$1$2$2  reason: invalid class name */
public final class ComposableSingletons$DDDebuggerPreviewKt$lambda$18439082$1$6$1$2$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isFF;
    final /* synthetic */ String $key;
    final /* synthetic */ Toaster $toaster;
    Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ComposableSingletons$DDDebuggerPreviewKt$lambda$18439082$1$6$1$2$2(boolean z, String str, Toaster toaster, Continuation<? super ComposableSingletons$DDDebuggerPreviewKt$lambda$18439082$1$6$1$2$2> continuation) {
        super(2, continuation);
        this.$isFF = z;
        this.$key = str;
        this.$toaster = toaster;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ComposableSingletons$DDDebuggerPreviewKt$lambda$18439082$1$6$1$2$2(this.$isFF, this.$key, this.$toaster, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Flow<String> stringFlow$default;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (this.$isFF) {
                    IDeviceDecision $this$asFlow_u24default$iv = KDeviceDecision.INSTANCE.getDd();
                    String key$iv = this.$key;
                    final Flow $this$mapNotNull$iv = $this$asFlow_u24default$iv.asFlow(key$iv, BooleanSerializer.INSTANCE, Boxing.boxBoolean(true), null);
                    stringFlow$default = new Flow<String>() { // from class: kntr.base.dd.preview.ComposableSingletons$DDDebuggerPreviewKt$lambda$-18439082$1$6$1$2$2$invokeSuspend$$inlined$mapNotNull$1
                        public Object collect(FlowCollector collector, Continuation $completion) {
                            Object collect = $this$mapNotNull$iv.collect(new AnonymousClass2(collector), $completion);
                            return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
                        }

                        /* compiled from: Emitters.kt */
                        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$mapNotNull$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                        /* renamed from: kntr.base.dd.preview.ComposableSingletons$DDDebuggerPreviewKt$lambda$-18439082$1$6$1$2$2$invokeSuspend$$inlined$mapNotNull$1$2  reason: invalid class name */
                        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                        public static final class AnonymousClass2<T> implements FlowCollector {
                            final /* synthetic */ FlowCollector $this_unsafeFlow;

                            /* compiled from: Emitters.kt */
                            @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                            @DebugMetadata(c = "kntr.base.dd.preview.ComposableSingletons$DDDebuggerPreviewKt$lambda$-18439082$1$6$1$2$2$invokeSuspend$$inlined$mapNotNull$1$2", f = "DDDebuggerPreview.kt", i = {0, 0, 0, 0, 0, 0}, l = {221}, m = "emit", n = {"value", "$completion", "value", "$this$mapNotNull_u24lambda_u246", "transformed", "$i$a$-unsafeTransform-FlowKt__TransformKt$mapNotNull$1"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0"}, v = 1)
                            /* renamed from: kntr.base.dd.preview.ComposableSingletons$DDDebuggerPreviewKt$lambda$-18439082$1$6$1$2$2$invokeSuspend$$inlined$mapNotNull$1$2$1  reason: invalid class name */
                            /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                            public static final class AnonymousClass1 extends ContinuationImpl {
                                int I$0;
                                Object L$0;
                                Object L$1;
                                Object L$2;
                                Object L$3;
                                Object L$4;
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

                            public AnonymousClass2(FlowCollector flowCollector) {
                                this.$this_unsafeFlow = flowCollector;
                            }

                            /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
                            /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
                            /* JADX WARN: Removed duplicated region for block: B:13:0x0042  */
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
                                                FlowCollector $this$mapNotNull_u24lambda_u246 = this.$this_unsafeFlow;
                                                AnonymousClass1 anonymousClass1 = $continuation;
                                                Boolean it = (Boolean) value;
                                                Object transformed = String.valueOf(it);
                                                if (transformed != null) {
                                                    $continuation.L$0 = SpillingKt.nullOutSpilledVariable(value);
                                                    $continuation.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                                                    $continuation.L$2 = SpillingKt.nullOutSpilledVariable(value);
                                                    $continuation.L$3 = SpillingKt.nullOutSpilledVariable($this$mapNotNull_u24lambda_u246);
                                                    $continuation.L$4 = SpillingKt.nullOutSpilledVariable(transformed);
                                                    $continuation.I$0 = 0;
                                                    $continuation.label = 1;
                                                    if ($this$mapNotNull_u24lambda_u246.emit(transformed, $continuation) != coroutine_suspended) {
                                                        break;
                                                    } else {
                                                        return coroutine_suspended;
                                                    }
                                                }
                                                break;
                                            case 1:
                                                int i = $continuation.I$0;
                                                String str = (String) $continuation.L$4;
                                                FlowCollector flowCollector = (FlowCollector) $continuation.L$3;
                                                Object obj = $continuation.L$2;
                                                AnonymousClass1 anonymousClass12 = (AnonymousClass1) $continuation.L$1;
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
                    };
                } else {
                    stringFlow$default = IDeviceDecisionKt.stringFlow$default(KDeviceDecision.INSTANCE.getDd(), this.$key, "DEBUGGER_QUERY_DEFAULT_VALUE", null, 4, null);
                }
                Flow flow = stringFlow$default;
                final Toaster toaster = this.$toaster;
                final String str = this.$key;
                this.L$0 = SpillingKt.nullOutSpilledVariable(flow);
                this.label = 1;
                if (flow.collect(new FlowCollector() { // from class: kntr.base.dd.preview.ComposableSingletons$DDDebuggerPreviewKt$lambda$-18439082$1$6$1$2$2.1

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* compiled from: DDDebuggerPreview.kt */
                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                    @DebugMetadata(c = "kntr.base.dd.preview.ComposableSingletons$DDDebuggerPreviewKt$lambda$-18439082$1$6$1$2$2$1$1", f = "DDDebuggerPreview.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
                    /* renamed from: kntr.base.dd.preview.ComposableSingletons$DDDebuggerPreviewKt$lambda$-18439082$1$6$1$2$2$1$1  reason: invalid class name and collision with other inner class name */
                    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                    public static final class C00011 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        final /* synthetic */ String $key;
                        final /* synthetic */ Toaster $toaster;
                        final /* synthetic */ String $value;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        C00011(String str, Toaster toaster, String str2, Continuation<? super C00011> continuation) {
                            super(2, continuation);
                            this.$value = str;
                            this.$toaster = toaster;
                            this.$key = str2;
                        }

                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new C00011(this.$value, this.$toaster, this.$key, continuation);
                        }

                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
                        }

                        public final Object invokeSuspend(Object $result) {
                            IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch (this.label) {
                                case 0:
                                    ResultKt.throwOnFailure($result);
                                    String v = (Intrinsics.areEqual(this.$value, "DEBUGGER_QUERY_DEFAULT_VALUE") || this.$value == null) ? "空值" : this.$value;
                                    Toaster.CC.showToast$default(this.$toaster, this.$key + " 的值已更新为：" + v + ".", null, 2, null);
                                    return Unit.INSTANCE;
                                default:
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                        }
                    }

                    public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                        return emit((String) value, (Continuation<? super Unit>) $completion);
                    }

                    public final Object emit(String value, Continuation<? super Unit> continuation) {
                        Object withContext = BuildersKt.withContext(Dispatchers.getMain(), new C00011(value, Toaster.this, str, null), continuation);
                        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
                    }
                }, (Continuation) this) != coroutine_suspended) {
                    break;
                } else {
                    return coroutine_suspended;
                }
            case 1:
                Flow flow2 = (Flow) this.L$0;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}