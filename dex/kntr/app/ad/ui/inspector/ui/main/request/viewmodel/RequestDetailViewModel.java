package kntr.app.ad.ui.inspector.ui.main.request.viewmodel;

import kntr.app.ad.domain.inspector.core.StateManager;
import kntr.app.ad.domain.inspector.core.work.RequestJobData;
import kntr.app.ad.ui.inspector.core.util.AdExtraDecoder;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* compiled from: RequestDetailViewModel.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006J\u0016\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000b2\u0006\u0010\r\u001a\u00020\u000eJ\u0016\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u000b2\u0006\u0010\r\u001a\u00020\u000eR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lkntr/app/ad/ui/inspector/ui/main/request/viewmodel/RequestDetailViewModel;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "parseAdextraFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", RoomRecommendViewModel.EMPTY_CURSOR, "updateParseAdextraSetting", RoomRecommendViewModel.EMPTY_CURSOR, "value", "getRequestJobDataFlow", "Lkotlinx/coroutines/flow/Flow;", "Lkntr/app/ad/domain/inspector/core/work/RequestJobData;", "requestId", RoomRecommendViewModel.EMPTY_CURSOR, "getProcessedResponseFlow", "ad-inspector_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class RequestDetailViewModel {
    public static final int $stable = 8;
    private final MutableStateFlow<Boolean> parseAdextraFlow = StateFlowKt.MutableStateFlow(false);

    public final void updateParseAdextraSetting(boolean value) {
        this.parseAdextraFlow.setValue(Boolean.valueOf(value));
    }

    public final Flow<RequestJobData> getRequestJobDataFlow(String requestId) {
        Intrinsics.checkNotNullParameter(requestId, "requestId");
        try {
            final Flow $this$map$iv = StateManager.INSTANCE.getRequestJobDataFlow(requestId);
            return new Flow<RequestJobData>() { // from class: kntr.app.ad.ui.inspector.ui.main.request.viewmodel.RequestDetailViewModel$getRequestJobDataFlow$$inlined$map$1

                /* compiled from: Emitters.kt */
                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 2, 0}, xi = 48)
                /* renamed from: kntr.app.ad.ui.inspector.ui.main.request.viewmodel.RequestDetailViewModel$getRequestJobDataFlow$$inlined$map$1$2  reason: invalid class name */
                /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
                public static final class AnonymousClass2<T> implements FlowCollector {
                    final /* synthetic */ FlowCollector $this_unsafeFlow;

                    /* compiled from: Emitters.kt */
                    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                    @DebugMetadata(c = "kntr.app.ad.ui.inspector.ui.main.request.viewmodel.RequestDetailViewModel$getRequestJobDataFlow$$inlined$map$1$2", f = "RequestDetailViewModel.kt", i = {0, 0, 0, 0, 0}, l = {219}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"}, v = 1)
                    /* renamed from: kntr.app.ad.ui.inspector.ui.main.request.viewmodel.RequestDetailViewModel$getRequestJobDataFlow$$inlined$map$1$2$1  reason: invalid class name */
                    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
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

                    public AnonymousClass2(FlowCollector flowCollector) {
                        this.$this_unsafeFlow = flowCollector;
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
                                        $continuation.L$0 = SpillingKt.nullOutSpilledVariable(value);
                                        $continuation.L$1 = SpillingKt.nullOutSpilledVariable($continuation);
                                        $continuation.L$2 = SpillingKt.nullOutSpilledVariable(value);
                                        $continuation.L$3 = SpillingKt.nullOutSpilledVariable($this$map_u24lambda_u245);
                                        $continuation.I$0 = 0;
                                        $continuation.label = 1;
                                        if ($this$map_u24lambda_u245.emit((RequestJobData) value, $continuation) != coroutine_suspended) {
                                            break;
                                        } else {
                                            return coroutine_suspended;
                                        }
                                    case 1:
                                        int i = $continuation.I$0;
                                        FlowCollector flowCollector = (FlowCollector) $continuation.L$3;
                                        Object obj = $continuation.L$2;
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

                public Object collect(FlowCollector collector, Continuation $completion) {
                    Object collect = $this$map$iv.collect(new AnonymousClass2(collector), $completion);
                    return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
                }
            };
        } catch (Exception e) {
            return FlowKt.flowOf((Object) null);
        }
    }

    public final Flow<String> getProcessedResponseFlow(String requestId) {
        Intrinsics.checkNotNullParameter(requestId, "requestId");
        final Flow $this$map$iv = getRequestJobDataFlow(requestId);
        return new Flow<String>() { // from class: kntr.app.ad.ui.inspector.ui.main.request.viewmodel.RequestDetailViewModel$getProcessedResponseFlow$$inlined$map$1

            /* compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 2, 0}, xi = 48)
            /* renamed from: kntr.app.ad.ui.inspector.ui.main.request.viewmodel.RequestDetailViewModel$getProcessedResponseFlow$$inlined$map$1$2  reason: invalid class name */
            /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;
                final /* synthetic */ RequestDetailViewModel this$0;

                /* compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "kntr.app.ad.ui.inspector.ui.main.request.viewmodel.RequestDetailViewModel$getProcessedResponseFlow$$inlined$map$1$2", f = "RequestDetailViewModel.kt", i = {0, 0, 0, 0, 0}, l = {219}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"}, v = 1)
                /* renamed from: kntr.app.ad.ui.inspector.ui.main.request.viewmodel.RequestDetailViewModel$getProcessedResponseFlow$$inlined$map$1$2$1  reason: invalid class name */
                /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
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

                public AnonymousClass2(FlowCollector flowCollector, RequestDetailViewModel requestDetailViewModel) {
                    this.$this_unsafeFlow = flowCollector;
                    this.this$0 = requestDetailViewModel;
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
                /* JADX WARN: Removed duplicated region for block: B:12:0x0031  */
                /* JADX WARN: Removed duplicated region for block: B:13:0x0044  */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object emit(Object value, Continuation $completion) {
                    AnonymousClass1 anonymousClass1;
                    AnonymousClass1 anonymousClass12;
                    String responseJson;
                    MutableStateFlow mutableStateFlow;
                    if ($completion instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) $completion;
                        if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label -= Integer.MIN_VALUE;
                            anonymousClass12 = anonymousClass1;
                            Object $result = anonymousClass12.result;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch (anonymousClass12.label) {
                                case 0:
                                    ResultKt.throwOnFailure($result);
                                    FlowCollector $this$map_u24lambda_u245 = this.$this_unsafeFlow;
                                    Continuation continuation = (Continuation) anonymousClass12;
                                    RequestJobData jobData = (RequestJobData) value;
                                    String str = null;
                                    if (jobData != null && (responseJson = jobData.getResponseJson()) != null) {
                                        if (Intrinsics.areEqual(jobData.getJobType(), "AdExtraJob")) {
                                            mutableStateFlow = this.this$0.parseAdextraFlow;
                                            if (((Boolean) mutableStateFlow.getValue()).booleanValue()) {
                                                try {
                                                    str = AdExtraDecoder.processAdextra$default(AdExtraDecoder.INSTANCE, responseJson, null, 2, null);
                                                } catch (Exception e) {
                                                    str = responseJson;
                                                }
                                            }
                                        }
                                        str = responseJson;
                                    }
                                    anonymousClass12.L$0 = SpillingKt.nullOutSpilledVariable(value);
                                    anonymousClass12.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass12);
                                    anonymousClass12.L$2 = SpillingKt.nullOutSpilledVariable(value);
                                    anonymousClass12.L$3 = SpillingKt.nullOutSpilledVariable($this$map_u24lambda_u245);
                                    anonymousClass12.I$0 = 0;
                                    anonymousClass12.label = 1;
                                    if ($this$map_u24lambda_u245.emit(str, anonymousClass12) != coroutine_suspended) {
                                        break;
                                    } else {
                                        return coroutine_suspended;
                                    }
                                case 1:
                                    int i = anonymousClass12.I$0;
                                    FlowCollector flowCollector = (FlowCollector) anonymousClass12.L$3;
                                    Object obj = anonymousClass12.L$2;
                                    AnonymousClass1 anonymousClass13 = (AnonymousClass1) anonymousClass12.L$1;
                                    Object obj2 = anonymousClass12.L$0;
                                    ResultKt.throwOnFailure($result);
                                    break;
                                default:
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            return Unit.INSTANCE;
                        }
                    }
                    anonymousClass1 = new AnonymousClass1($completion);
                    anonymousClass12 = anonymousClass1;
                    Object $result2 = anonymousClass12.result;
                    Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (anonymousClass12.label) {
                    }
                    return Unit.INSTANCE;
                }
            }

            public Object collect(FlowCollector collector, Continuation $completion) {
                Object collect = $this$map$iv.collect(new AnonymousClass2(collector, this), $completion);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }
        };
    }
}