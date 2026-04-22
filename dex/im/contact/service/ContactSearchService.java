package im.contact.service;

import com.bapis.bilibili.app.im.v1.KContactTabType;
import com.bapis.bilibili.app.im.v1.KContactsSearchReq;
import com.bapis.bilibili.app.im.v1.KPaginationParams;
import com.bapis.bilibili.app.im.v1.KimMoss;
import com.tencent.smtt.sdk.TbsListener;
import im.contact.UtilsKt;
import im.contact.di.IMContactScope;
import im.contact.model.ContactsSearchReply;
import javax.inject.Inject;
import kntr.base.log.KLog_androidKt;
import kntr.base.moss.api.KCallOptions;
import kntr.base.moss.api.KMossException;
import kntr.base.moss.api.KMossResponseHandler;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.SerializationStrategy;

/* compiled from: ContactSearchService.kt */
@IMContactScope
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J.\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0080@¢\u0006\u0004\b\u0015\u0010\u0016J\u001e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00170\t2\u0006\u0010\u0018\u001a\u00020\u0006H\u0082@¢\u0006\u0004\b\u0019\u0010\u001aR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u001b"}, d2 = {"Lim/contact/service/ContactSearchService;", "", "<init>", "()V", "searchParamsFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lim/contact/service/SearchParams;", "resultFlow", "Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Result;", "Lim/contact/service/SearchResult;", "getResultFlow$contact_debug", "()Lkotlinx/coroutines/flow/Flow;", "load", "", "searchWord", "", "tab", "Lcom/bapis/bilibili/app/im/v1/KContactTabType;", "paging", "Lcom/bapis/bilibili/app/im/v1/KPaginationParams;", "load$contact_debug", "(Ljava/lang/String;Lcom/bapis/bilibili/app/im/v1/KContactTabType;Lcom/bapis/bilibili/app/im/v1/KPaginationParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lim/contact/model/ContactsSearchReply;", "params", "load-gIAlu-s", "(Lim/contact/service/SearchParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "contact_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ContactSearchService {
    private final Flow<Result<SearchResult>> resultFlow;
    private final MutableSharedFlow<SearchParams> searchParamsFlow = SharedFlowKt.MutableSharedFlow$default(0, 0, (BufferOverflow) null, 7, (Object) null);

    /* JADX WARN: Multi-variable type inference failed */
    @Inject
    public ContactSearchService() {
        final Flow $this$map$iv = FlowKt.conflate(this.searchParamsFlow);
        final Flow $this$map$iv2 = new Flow<SearchParams>() { // from class: im.contact.service.ContactSearchService$special$$inlined$map$1

            /* compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 2, 0}, xi = 48)
            /* renamed from: im.contact.service.ContactSearchService$special$$inlined$map$1$2  reason: invalid class name */
            /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "im.contact.service.ContactSearchService$special$$inlined$map$1$2", f = "ContactSearchService.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1}, l = {TbsListener.ErrorCode.INCRUPDATE_INSTALL_SUCCESS, TbsListener.ErrorCode.RENAME_EXCEPTION}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$completion", "it", "it", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1", "$i$a$-map-ContactSearchService$resultFlow$1", "$i$a$-also-ContactSearchService$resultFlow$1$1", "value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "L$5", "L$6", "L$8", "I$0", "I$1", "I$2", "L$0", "L$1", "L$2", "L$3", "I$0"}, v = 1)
                /* renamed from: im.contact.service.ContactSearchService$special$$inlined$map$1$2$1  reason: invalid class name */
                /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    int I$0;
                    int I$1;
                    int I$2;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    Object L$4;
                    Object L$5;
                    Object L$6;
                    Object L$7;
                    Object L$8;
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

                /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
                /* JADX WARN: Removed duplicated region for block: B:12:0x0030  */
                /* JADX WARN: Removed duplicated region for block: B:13:0x0043  */
                /* JADX WARN: Removed duplicated region for block: B:14:0x0072  */
                /* JADX WARN: Removed duplicated region for block: B:20:0x0105 A[RETURN] */
                /* JADX WARN: Removed duplicated region for block: B:21:0x0106  */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object emit(Object value, Continuation $completion) {
                    Continuation $continuation;
                    FlowCollector $this$map_u24lambda_u245;
                    int i2;
                    SearchParams it;
                    Object value2;
                    AnonymousClass1 anonymousClass1;
                    FlowCollector $this$map_u24lambda_u2452;
                    Object value3;
                    if ($completion instanceof AnonymousClass1) {
                        $continuation = (AnonymousClass1) $completion;
                        if (($continuation.label & Integer.MIN_VALUE) != 0) {
                            $continuation.label -= Integer.MIN_VALUE;
                            Object $result = $continuation.result;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch ($continuation.label) {
                                case 0:
                                    ResultKt.throwOnFailure($result);
                                    AnonymousClass1 anonymousClass12 = $continuation;
                                    $this$map_u24lambda_u245 = this.$this_unsafeFlow;
                                    i2 = 0;
                                    it = (SearchParams) value;
                                    Duration.Companion companion = Duration.Companion;
                                    long duration = DurationKt.toDuration(0.5d, DurationUnit.SECONDS);
                                    $continuation.L$0 = SpillingKt.nullOutSpilledVariable(value);
                                    $continuation.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass12);
                                    $continuation.L$2 = SpillingKt.nullOutSpilledVariable(value);
                                    $continuation.L$3 = SpillingKt.nullOutSpilledVariable($this$map_u24lambda_u245);
                                    $continuation.L$4 = $this$map_u24lambda_u245;
                                    $continuation.L$5 = SpillingKt.nullOutSpilledVariable($continuation);
                                    $continuation.L$6 = SpillingKt.nullOutSpilledVariable(it);
                                    $continuation.L$7 = it;
                                    $continuation.L$8 = SpillingKt.nullOutSpilledVariable(it);
                                    $continuation.I$0 = 0;
                                    $continuation.I$1 = 0;
                                    $continuation.I$2 = 0;
                                    $continuation.label = 1;
                                    if (DelayKt.delay-VtjQ1oo(duration, $continuation) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    value2 = value;
                                    anonymousClass1 = anonymousClass12;
                                    $this$map_u24lambda_u2452 = $this$map_u24lambda_u245;
                                    value3 = value;
                                    $continuation.L$0 = SpillingKt.nullOutSpilledVariable(value3);
                                    $continuation.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                                    $continuation.L$2 = SpillingKt.nullOutSpilledVariable(value2);
                                    $continuation.L$3 = SpillingKt.nullOutSpilledVariable($this$map_u24lambda_u2452);
                                    $continuation.L$4 = null;
                                    $continuation.L$5 = null;
                                    $continuation.L$6 = null;
                                    $continuation.L$7 = null;
                                    $continuation.L$8 = null;
                                    $continuation.I$0 = i2;
                                    $continuation.label = 2;
                                    if ($this$map_u24lambda_u245.emit(it, $continuation) != coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    return Unit.INSTANCE;
                                case 1:
                                    int i3 = $continuation.I$2;
                                    int i4 = $continuation.I$1;
                                    int i5 = $continuation.I$0;
                                    SearchParams searchParams = (SearchParams) $continuation.L$8;
                                    it = (SearchParams) $continuation.L$7;
                                    SearchParams searchParams2 = (SearchParams) $continuation.L$6;
                                    Continuation continuation = (Continuation) $continuation.L$5;
                                    $this$map_u24lambda_u245 = (FlowCollector) $continuation.L$4;
                                    $this$map_u24lambda_u2452 = (FlowCollector) $continuation.L$3;
                                    value2 = $continuation.L$2;
                                    anonymousClass1 = (AnonymousClass1) $continuation.L$1;
                                    value3 = $continuation.L$0;
                                    ResultKt.throwOnFailure($result);
                                    i2 = i5;
                                    $continuation.L$0 = SpillingKt.nullOutSpilledVariable(value3);
                                    $continuation.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                                    $continuation.L$2 = SpillingKt.nullOutSpilledVariable(value2);
                                    $continuation.L$3 = SpillingKt.nullOutSpilledVariable($this$map_u24lambda_u2452);
                                    $continuation.L$4 = null;
                                    $continuation.L$5 = null;
                                    $continuation.L$6 = null;
                                    $continuation.L$7 = null;
                                    $continuation.L$8 = null;
                                    $continuation.I$0 = i2;
                                    $continuation.label = 2;
                                    if ($this$map_u24lambda_u245.emit(it, $continuation) != coroutine_suspended) {
                                    }
                                    break;
                                case 2:
                                    int i6 = $continuation.I$0;
                                    FlowCollector flowCollector = (FlowCollector) $continuation.L$3;
                                    Object obj = $continuation.L$2;
                                    AnonymousClass1 anonymousClass13 = (AnonymousClass1) $continuation.L$1;
                                    Object obj2 = $continuation.L$0;
                                    ResultKt.throwOnFailure($result);
                                    return Unit.INSTANCE;
                                default:
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                        }
                    }
                    $continuation = new AnonymousClass1($completion);
                    Object $result2 = $continuation.result;
                    Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch ($continuation.label) {
                    }
                }
            }

            public Object collect(FlowCollector collector, Continuation $completion) {
                Object collect = $this$map$iv.collect(new AnonymousClass2(collector), $completion);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }
        };
        this.resultFlow = new Flow<Result<? extends SearchResult>>() { // from class: im.contact.service.ContactSearchService$special$$inlined$map$2

            /* compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 2, 0}, xi = 48)
            /* renamed from: im.contact.service.ContactSearchService$special$$inlined$map$2$2  reason: invalid class name */
            /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;
                final /* synthetic */ ContactSearchService this$0;

                /* compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "im.contact.service.ContactSearchService$special$$inlined$map$2$2", f = "ContactSearchService.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1}, l = {TbsListener.ErrorCode.COPY_INSTALL_SUCCESS, TbsListener.ErrorCode.RENAME_EXCEPTION}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$completion", "param", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1", "$i$a$-map-ContactSearchService$resultFlow$2", "value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "L$5", "L$6", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "I$0"}, v = 1)
                /* renamed from: im.contact.service.ContactSearchService$special$$inlined$map$2$2$1  reason: invalid class name */
                /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    int I$0;
                    int I$1;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    Object L$4;
                    Object L$5;
                    Object L$6;
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

                public AnonymousClass2(FlowCollector flowCollector, ContactSearchService contactSearchService) {
                    this.$this_unsafeFlow = flowCollector;
                    this.this$0 = contactSearchService;
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
                /* JADX WARN: Removed duplicated region for block: B:12:0x0030  */
                /* JADX WARN: Removed duplicated region for block: B:13:0x0043  */
                /* JADX WARN: Removed duplicated region for block: B:14:0x006f  */
                /* JADX WARN: Removed duplicated region for block: B:20:0x00c3  */
                /* JADX WARN: Removed duplicated region for block: B:21:0x00d6  */
                /* JADX WARN: Removed duplicated region for block: B:24:0x0109 A[RETURN] */
                /* JADX WARN: Removed duplicated region for block: B:25:0x010a  */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object emit(Object value, Continuation $completion) {
                    Continuation $continuation;
                    FlowCollector $this$map_u24lambda_u245;
                    Object m3163loadgIAlus;
                    Object value2;
                    AnonymousClass1 anonymousClass1;
                    int i2;
                    SearchParams param;
                    FlowCollector $this$map_u24lambda_u2452;
                    Object value3;
                    Object obj;
                    Result result;
                    if ($completion instanceof AnonymousClass1) {
                        $continuation = (AnonymousClass1) $completion;
                        if (($continuation.label & Integer.MIN_VALUE) != 0) {
                            $continuation.label -= Integer.MIN_VALUE;
                            Object $result = $continuation.result;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch ($continuation.label) {
                                case 0:
                                    ResultKt.throwOnFailure($result);
                                    AnonymousClass1 anonymousClass12 = $continuation;
                                    $this$map_u24lambda_u245 = this.$this_unsafeFlow;
                                    SearchParams param2 = (SearchParams) value;
                                    ContactSearchService contactSearchService = this.this$0;
                                    $continuation.L$0 = SpillingKt.nullOutSpilledVariable(value);
                                    $continuation.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass12);
                                    $continuation.L$2 = SpillingKt.nullOutSpilledVariable(value);
                                    $continuation.L$3 = SpillingKt.nullOutSpilledVariable($this$map_u24lambda_u245);
                                    $continuation.L$4 = $this$map_u24lambda_u245;
                                    $continuation.L$5 = SpillingKt.nullOutSpilledVariable($continuation);
                                    $continuation.L$6 = param2;
                                    $continuation.I$0 = 0;
                                    $continuation.I$1 = 0;
                                    $continuation.label = 1;
                                    m3163loadgIAlus = contactSearchService.m3163loadgIAlus(param2, $continuation);
                                    if (m3163loadgIAlus == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    value2 = value;
                                    anonymousClass1 = anonymousClass12;
                                    i2 = 0;
                                    param = param2;
                                    $this$map_u24lambda_u2452 = $this$map_u24lambda_u245;
                                    value3 = value;
                                    if (Result.isSuccess-impl(m3163loadgIAlus)) {
                                        obj = Result.constructor-impl(m3163loadgIAlus);
                                    } else {
                                        Result.Companion companion = Result.Companion;
                                        ContactsSearchReply it = (ContactsSearchReply) m3163loadgIAlus;
                                        obj = Result.constructor-impl(new SearchResult(param.getSearchWord(), it));
                                    }
                                    result = Result.box-impl(obj);
                                    $continuation.L$0 = SpillingKt.nullOutSpilledVariable(value2);
                                    $continuation.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                                    $continuation.L$2 = SpillingKt.nullOutSpilledVariable(value3);
                                    $continuation.L$3 = SpillingKt.nullOutSpilledVariable($this$map_u24lambda_u245);
                                    $continuation.L$4 = null;
                                    $continuation.L$5 = null;
                                    $continuation.L$6 = null;
                                    $continuation.I$0 = i2;
                                    $continuation.label = 2;
                                    if ($this$map_u24lambda_u2452.emit(result, $continuation) != coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    return Unit.INSTANCE;
                                case 1:
                                    int i3 = $continuation.I$1;
                                    i2 = $continuation.I$0;
                                    param = (SearchParams) $continuation.L$6;
                                    Continuation continuation = (Continuation) $continuation.L$5;
                                    FlowCollector $this$map_u24lambda_u2453 = (FlowCollector) $continuation.L$3;
                                    value3 = $continuation.L$2;
                                    anonymousClass1 = (AnonymousClass1) $continuation.L$1;
                                    value2 = $continuation.L$0;
                                    ResultKt.throwOnFailure($result);
                                    m3163loadgIAlus = ((Result) $result).unbox-impl();
                                    $this$map_u24lambda_u2452 = (FlowCollector) $continuation.L$4;
                                    $this$map_u24lambda_u245 = $this$map_u24lambda_u2453;
                                    if (Result.isSuccess-impl(m3163loadgIAlus)) {
                                    }
                                    result = Result.box-impl(obj);
                                    $continuation.L$0 = SpillingKt.nullOutSpilledVariable(value2);
                                    $continuation.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                                    $continuation.L$2 = SpillingKt.nullOutSpilledVariable(value3);
                                    $continuation.L$3 = SpillingKt.nullOutSpilledVariable($this$map_u24lambda_u245);
                                    $continuation.L$4 = null;
                                    $continuation.L$5 = null;
                                    $continuation.L$6 = null;
                                    $continuation.I$0 = i2;
                                    $continuation.label = 2;
                                    if ($this$map_u24lambda_u2452.emit(result, $continuation) != coroutine_suspended) {
                                    }
                                    break;
                                case 2:
                                    int i4 = $continuation.I$0;
                                    FlowCollector flowCollector = (FlowCollector) $continuation.L$3;
                                    Object obj2 = $continuation.L$2;
                                    AnonymousClass1 anonymousClass13 = (AnonymousClass1) $continuation.L$1;
                                    Object obj3 = $continuation.L$0;
                                    ResultKt.throwOnFailure($result);
                                    return Unit.INSTANCE;
                                default:
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                        }
                    }
                    $continuation = new AnonymousClass1($completion);
                    Object $result2 = $continuation.result;
                    Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch ($continuation.label) {
                    }
                }
            }

            public Object collect(FlowCollector collector, Continuation $completion) {
                Object collect = $this$map$iv2.collect(new AnonymousClass2(collector, this), $completion);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }
        };
    }

    public final Flow<Result<SearchResult>> getResultFlow$contact_debug() {
        return this.resultFlow;
    }

    public static /* synthetic */ Object load$contact_debug$default(ContactSearchService contactSearchService, String str, KContactTabType kContactTabType, KPaginationParams kPaginationParams, Continuation continuation, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            kContactTabType = (KContactTabType) KContactTabType.TAB_UNKNOWN.INSTANCE;
        }
        if ((i2 & 4) != 0) {
            kPaginationParams = null;
        }
        return contactSearchService.load$contact_debug(str, kContactTabType, kPaginationParams, continuation);
    }

    public final Object load$contact_debug(String searchWord, KContactTabType tab, KPaginationParams paging, Continuation<? super Unit> continuation) {
        Object emit = this.searchParamsFlow.emit(new SearchParams(searchWord, tab, paging), continuation);
        return emit == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? emit : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x01b2  */
    /* renamed from: load-gIAlu-s  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m3163loadgIAlus(SearchParams params, Continuation<? super Result<ContactsSearchReply>> continuation) {
        ContactSearchService$load$2 contactSearchService$load$2;
        ContactSearchService$load$2 contactSearchService$load$22;
        SearchParams params2;
        Object result;
        Object obj;
        Throwable it;
        if (continuation instanceof ContactSearchService$load$2) {
            contactSearchService$load$2 = (ContactSearchService$load$2) continuation;
            if ((contactSearchService$load$2.label & Integer.MIN_VALUE) != 0) {
                contactSearchService$load$2.label -= Integer.MIN_VALUE;
                contactSearchService$load$22 = contactSearchService$load$2;
                Object $result = contactSearchService$load$22.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (contactSearchService$load$22.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        try {
                            Result.Companion companion = Result.Companion;
                            KLog_androidKt.getKLog().i(UtilsKt.TAG("Search"), "load tab: " + params.getTab() + ", keyword: " + params.getSearchWord());
                            KimMoss $this$iv = new KimMoss((KCallOptions) null, 1, (DefaultConstructorMarker) null);
                            Object request$iv = new KContactsSearchReq(params.getSearchWord(), params.getTab(), params.getPaging());
                            SerializationStrategy reqSerializer$iv = KContactsSearchReq.Companion.serializer();
                            DeserializationStrategy respSerializer$iv = ContactsSearchReply.Companion.serializer();
                            contactSearchService$load$22.L$0 = params;
                            contactSearchService$load$22.L$1 = $this$iv;
                            contactSearchService$load$22.L$2 = request$iv;
                            contactSearchService$load$22.L$3 = contactSearchService$load$22;
                            contactSearchService$load$22.L$4 = reqSerializer$iv;
                            contactSearchService$load$22.L$5 = respSerializer$iv;
                            contactSearchService$load$22.I$0 = 0;
                            contactSearchService$load$22.I$1 = 0;
                            contactSearchService$load$22.I$2 = 0;
                            contactSearchService$load$22.I$3 = 0;
                            contactSearchService$load$22.I$4 = 0;
                            contactSearchService$load$22.label = 1;
                            Continuation uCont$iv$iv$iv = (Continuation) contactSearchService$load$22;
                            try {
                                CancellableContinuation cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(uCont$iv$iv$iv), 1);
                                cancellableContinuationImpl.initCancellability();
                                final CancellableContinuation it$iv$iv = cancellableContinuationImpl;
                                KMossResponseHandler p3$iv = new KMossResponseHandler<ContactsSearchReply>() { // from class: im.contact.service.ContactSearchService$load_gIAlu_s$lambda$0$$inlined$contactsSearch$default$1
                                    private ContactsSearchReply resp;

                                    public void onNext(ContactsSearchReply contactsSearchReply) {
                                        this.resp = contactsSearchReply;
                                    }

                                    public void onCompleted() {
                                        if (it$iv$iv.isActive()) {
                                            Object result2 = this.resp;
                                            if (result2 != null) {
                                                Result.Companion companion2 = Result.Companion;
                                                it$iv$iv.resumeWith(Result.constructor-impl(result2));
                                                return;
                                            }
                                            Result.Companion companion3 = Result.Companion;
                                            it$iv$iv.resumeWith(Result.constructor-impl(ResultKt.createFailure(new KMossException("Unlikely null response without exception", (Throwable) null))));
                                        }
                                    }

                                    public void onError(KMossException t) {
                                        KMossException kMossException;
                                        if (it$iv$iv.isActive()) {
                                            Continuation continuation2 = it$iv$iv;
                                            Result.Companion companion2 = Result.Companion;
                                            if (t != null) {
                                                kMossException = t;
                                            } else {
                                                kMossException = new KMossException("Unknown exception in kmoss coroutine", (Throwable) null);
                                            }
                                            continuation2.resumeWith(Result.constructor-impl(ResultKt.createFailure((Throwable) kMossException)));
                                        }
                                    }
                                };
                                $this$iv.contactsSearch(request$iv, reqSerializer$iv, respSerializer$iv, p3$iv);
                                result = cancellableContinuationImpl.getResult();
                                if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                                    DebugProbesKt.probeCoroutineSuspended((Continuation) contactSearchService$load$22);
                                }
                            } catch (Throwable th) {
                                th = th;
                                params2 = params;
                                Result.Companion companion2 = Result.Companion;
                                obj = Result.constructor-impl(ResultKt.createFailure(th));
                                JobKt.ensureActive(contactSearchService$load$22.getContext());
                                if (Result.isSuccess-impl(obj)) {
                                }
                                it = Result.exceptionOrNull-impl(obj);
                                if (it != null) {
                                }
                                return obj;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            params2 = params;
                        }
                        if (result == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        params2 = params;
                        try {
                            obj = Result.constructor-impl((ContactsSearchReply) result);
                        } catch (Throwable th3) {
                            th = th3;
                            Result.Companion companion22 = Result.Companion;
                            obj = Result.constructor-impl(ResultKt.createFailure(th));
                            JobKt.ensureActive(contactSearchService$load$22.getContext());
                            if (Result.isSuccess-impl(obj)) {
                            }
                            it = Result.exceptionOrNull-impl(obj);
                            if (it != null) {
                            }
                            return obj;
                        }
                        JobKt.ensureActive(contactSearchService$load$22.getContext());
                        if (Result.isSuccess-impl(obj)) {
                            ContactsSearchReply contactsSearchReply = (ContactsSearchReply) obj;
                            KLog_androidKt.getKLog().i(UtilsKt.TAG("Search"), "load success for tab " + params2.getTab() + ", keyword: " + params2.getSearchWord());
                        }
                        it = Result.exceptionOrNull-impl(obj);
                        if (it != null) {
                            KLog_androidKt.getKLog().e(UtilsKt.TAG("Search"), "load failed on tab " + params2.getTab() + ", keyword: " + params2.getSearchWord(), it);
                        }
                        return obj;
                    case 1:
                        int i2 = contactSearchService$load$22.I$4;
                        int i3 = contactSearchService$load$22.I$3;
                        int i4 = contactSearchService$load$22.I$2;
                        int i5 = contactSearchService$load$22.I$1;
                        int i6 = contactSearchService$load$22.I$0;
                        DeserializationStrategy deserializationStrategy = (DeserializationStrategy) contactSearchService$load$22.L$5;
                        SerializationStrategy serializationStrategy = (SerializationStrategy) contactSearchService$load$22.L$4;
                        ContactSearchService$load$2 contactSearchService$load$23 = (ContactSearchService$load$2) contactSearchService$load$22.L$3;
                        KContactsSearchReq kContactsSearchReq = (KContactsSearchReq) contactSearchService$load$22.L$2;
                        KimMoss kimMoss = (KimMoss) contactSearchService$load$22.L$1;
                        params2 = (SearchParams) contactSearchService$load$22.L$0;
                        try {
                            ResultKt.throwOnFailure($result);
                            result = $result;
                            obj = Result.constructor-impl((ContactsSearchReply) result);
                        } catch (Throwable th4) {
                            th = th4;
                            Result.Companion companion222 = Result.Companion;
                            obj = Result.constructor-impl(ResultKt.createFailure(th));
                            JobKt.ensureActive(contactSearchService$load$22.getContext());
                            if (Result.isSuccess-impl(obj)) {
                            }
                            it = Result.exceptionOrNull-impl(obj);
                            if (it != null) {
                            }
                            return obj;
                        }
                        JobKt.ensureActive(contactSearchService$load$22.getContext());
                        if (Result.isSuccess-impl(obj)) {
                        }
                        it = Result.exceptionOrNull-impl(obj);
                        if (it != null) {
                        }
                        return obj;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        contactSearchService$load$2 = new ContactSearchService$load$2(this, continuation);
        contactSearchService$load$22 = contactSearchService$load$2;
        Object $result2 = contactSearchService$load$22.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (contactSearchService$load$22.label) {
        }
    }
}