package kntr.base.dd.impl.internal.container;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.dd.IDeviceDecisionKt;
import kntr.base.dd.impl.internal.common.DDConst;
import kntr.base.dd.internal.IDeviceDecisionDefault;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DDContainer.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.base.dd.impl.internal.container.DDContainer$observeDefaultConfigKey$1", f = "DDContainer.kt", i = {0}, l = {269}, m = "invokeSuspend", n = {"observeKeys"}, s = {"L$0"}, v = 1)
public final class DDContainer$observeDefaultConfigKey$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ DDContainer this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DDContainer$observeDefaultConfigKey$1(DDContainer dDContainer, Continuation<? super DDContainer$observeDefaultConfigKey$1> continuation) {
        super(2, continuation);
        this.this$0 = dDContainer;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DDContainer$observeDefaultConfigKey$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Iterable $this$map$iv = IDeviceDecisionDefault.Key.getEntries();
                Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                for (Object item$iv$iv : $this$map$iv) {
                    IDeviceDecisionDefault.Key it = (IDeviceDecisionDefault.Key) item$iv$iv;
                    destination$iv$iv.add(it.getRawValue());
                }
                final Set observeKeys = CollectionsKt.toSet((List) destination$iv$iv);
                final Flow $this$filter$iv = FlowKt.onStart(this.this$0.keys(), new AnonymousClass1(observeKeys, null));
                final DDContainer dDContainer = this.this$0;
                this.L$0 = SpillingKt.nullOutSpilledVariable(observeKeys);
                this.label = 1;
                if (new Flow<String>() { // from class: kntr.base.dd.impl.internal.container.DDContainer$observeDefaultConfigKey$1$invokeSuspend$$inlined$filter$1
                    public Object collect(FlowCollector collector, Continuation $completion) {
                        Object collect = $this$filter$iv.collect(new AnonymousClass2(collector, observeKeys), $completion);
                        return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
                    }

                    /* compiled from: Emitters.kt */
                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                    /* renamed from: kntr.base.dd.impl.internal.container.DDContainer$observeDefaultConfigKey$1$invokeSuspend$$inlined$filter$1$2  reason: invalid class name */
                    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                    public static final class AnonymousClass2<T> implements FlowCollector {
                        final /* synthetic */ Set $observeKeys$inlined;
                        final /* synthetic */ FlowCollector $this_unsafeFlow;

                        /* compiled from: Emitters.kt */
                        @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                        @DebugMetadata(c = "kntr.base.dd.impl.internal.container.DDContainer$observeDefaultConfigKey$1$invokeSuspend$$inlined$filter$1$2", f = "DDContainer.kt", i = {0, 0, 0, 0, 0}, l = {219}, m = "emit", n = {"value", "$completion", "value", "$this$filter_u24lambda_u240", "$i$a$-unsafeTransform-FlowKt__TransformKt$filter$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"}, v = 1)
                        /* renamed from: kntr.base.dd.impl.internal.container.DDContainer$observeDefaultConfigKey$1$invokeSuspend$$inlined$filter$1$2$1  reason: invalid class name */
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

                        public AnonymousClass2(FlowCollector flowCollector, Set set) {
                            this.$this_unsafeFlow = flowCollector;
                            this.$observeKeys$inlined = set;
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
                                            FlowCollector $this$filter_u24lambda_u240 = this.$this_unsafeFlow;
                                            AnonymousClass1 anonymousClass1 = $continuation;
                                            String it = (String) value;
                                            if (this.$observeKeys$inlined.contains(it)) {
                                                $continuation.L$0 = SpillingKt.nullOutSpilledVariable(value);
                                                $continuation.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                                                $continuation.L$2 = SpillingKt.nullOutSpilledVariable(value);
                                                $continuation.L$3 = SpillingKt.nullOutSpilledVariable($this$filter_u24lambda_u240);
                                                $continuation.I$0 = 0;
                                                $continuation.label = 1;
                                                if ($this$filter_u24lambda_u240.emit(value, $continuation) != coroutine_suspended) {
                                                    break;
                                                } else {
                                                    return coroutine_suspended;
                                                }
                                            }
                                            break;
                                        case 1:
                                            int i = $continuation.I$0;
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
                }.collect(new FlowCollector() { // from class: kntr.base.dd.impl.internal.container.DDContainer$observeDefaultConfigKey$1.3
                    public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                        return emit((String) value, (Continuation<? super Unit>) $completion);
                    }

                    public final Object emit(String key, Continuation<? super Unit> continuation) {
                        IDeviceDecisionDefault iDeviceDecisionDefault;
                        IDeviceDecisionDefault.Key it2 = IDeviceDecisionDefault.Key.Companion.fromString(key);
                        if (it2 != null) {
                            DDContainer dDContainer2 = DDContainer.this;
                            String value = IDeviceDecisionKt.getString$default(dDContainer2, key, null, null, 6, null);
                            iDeviceDecisionDefault = dDContainer2.defaultConfig;
                            iDeviceDecisionDefault.set(it2, value);
                            DDConst.INSTANCE.logI("set default-config " + key + " to " + value);
                        }
                        return Unit.INSTANCE;
                    }
                }, (Continuation) this) != coroutine_suspended) {
                    break;
                } else {
                    return coroutine_suspended;
                }
            case 1:
                Set set = (Set) this.L$0;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DDContainer.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", ""}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @DebugMetadata(c = "kntr.base.dd.impl.internal.container.DDContainer$observeDefaultConfigKey$1$1", f = "DDContainer.kt", i = {0, 0, 0, 0, 0, 0}, l = {267}, m = "invokeSuspend", n = {"$this$onStart", "$this$forEach$iv", "element$iv", "it", "$i$f$forEach", "$i$a$-forEach-DDContainer$observeDefaultConfigKey$1$1$1"}, s = {"L$0", "L$1", "L$3", "L$4", "I$0", "I$1"}, v = 1)
    /* renamed from: kntr.base.dd.impl.internal.container.DDContainer$observeDefaultConfigKey$1$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<FlowCollector<? super String>, Continuation<? super Unit>, Object> {
        final /* synthetic */ Set<String> $observeKeys;
        int I$0;
        int I$1;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Set<String> set, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$observeKeys = set;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> anonymousClass1 = new AnonymousClass1(this.$observeKeys, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        public final Object invoke(FlowCollector<? super String> flowCollector, Continuation<? super Unit> continuation) {
            return create(flowCollector, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0046  */
        /* JADX WARN: Removed duplicated region for block: B:15:0x0080  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0072 -> B:14:0x007a). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object $result) {
            int $i$f$forEach;
            Iterable $this$forEach$iv;
            Iterator it;
            AnonymousClass1 anonymousClass1;
            AnonymousClass1 anonymousClass12;
            Iterable $this$forEach$iv2;
            Iterator it2;
            int $i$f$forEach2;
            FlowCollector $this$onStart = (FlowCollector) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    Iterable $this$forEach$iv3 = this.$observeKeys;
                    $i$f$forEach = 0;
                    $this$forEach$iv = $this$forEach$iv3;
                    it = $this$forEach$iv3.iterator();
                    anonymousClass1 = this;
                    break;
                case 1:
                    int i = this.I$1;
                    int $i$f$forEach3 = this.I$0;
                    String str = (String) this.L$4;
                    Object obj = this.L$3;
                    ResultKt.throwOnFailure($result);
                    $this$forEach$iv2 = (Iterable) this.L$1;
                    it2 = (Iterator) this.L$2;
                    $i$f$forEach2 = $i$f$forEach3;
                    anonymousClass12 = this;
                    anonymousClass1 = anonymousClass12;
                    $i$f$forEach = $i$f$forEach2;
                    it = it2;
                    $this$forEach$iv = $this$forEach$iv2;
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            if (!it.hasNext()) {
                Object element$iv = it.next();
                String it3 = (String) element$iv;
                anonymousClass1.L$0 = $this$onStart;
                anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable($this$forEach$iv);
                anonymousClass1.L$2 = it;
                anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(element$iv);
                anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(it3);
                anonymousClass1.I$0 = $i$f$forEach;
                anonymousClass1.I$1 = 0;
                anonymousClass1.label = 1;
                if ($this$onStart.emit(it3, anonymousClass1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                int i2 = $i$f$forEach;
                anonymousClass12 = anonymousClass1;
                $this$forEach$iv2 = $this$forEach$iv;
                it2 = it;
                $i$f$forEach2 = i2;
                anonymousClass1 = anonymousClass12;
                $i$f$forEach = $i$f$forEach2;
                it = it2;
                $this$forEach$iv = $this$forEach$iv2;
                if (!it.hasNext()) {
                    return Unit.INSTANCE;
                }
            }
        }
    }
}