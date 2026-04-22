package kntr.app.mall.product.details.page.kmm;

import java.util.Map;
import kntr.app.mall.product.details.page.api.ReserveApiService;
import kntr.app.mall.product.details.page.kmm.ProductDetailsPageDataState;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.flow.MutableStateFlow;

/* compiled from: ProductDetailsPageService.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.mall.product.details.page.kmm.ProductDetailsPageService$triggerReserve$1", f = "ProductDetailsPageService.kt", i = {1, 1, 1, 1, 1}, l = {482, 532}, m = "invokeSuspend", n = {"response", "token", "resultCycleTimes", "resultCycleFinished", "resultCycle"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4"}, v = 1)
final class ProductDetailsPageService$triggerReserve$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $itemsId;
    final /* synthetic */ Map<String, Object> $receiveCouponCmd;
    final /* synthetic */ Map<String, Object> $reserveReq;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    final /* synthetic */ ProductDetailsPageService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProductDetailsPageService$triggerReserve$1(ProductDetailsPageService productDetailsPageService, String str, Map<String, ? extends Object> map, Map<String, ? extends Object> map2, Continuation<? super ProductDetailsPageService$triggerReserve$1> continuation) {
        super(2, continuation);
        this.this$0 = productDetailsPageService;
        this.$itemsId = str;
        this.$reserveReq = map;
        this.$receiveCouponCmd = map2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ProductDetailsPageService$triggerReserve$1(this.this$0, this.$itemsId, this.$reserveReq, this.$receiveCouponCmd, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00bd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        MutableStateFlow $receiver$iv;
        Object prevValue$iv$iv;
        Object nextValue$iv$iv;
        Object reserveAndReceiveCoupon$product_details_page_debug;
        String data;
        Function1 function1;
        MutableStateFlow $receiver$iv2;
        Object prevValue$iv$iv2;
        Object nextValue$iv$iv2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        boolean z = true;
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                ProductDetailsPageService productDetailsPageService = this.this$0;
                $receiver$iv = this.this$0._reserveResultFlow;
                ProductDetailsPageDataState.ProductDetailsPageStatus pageStatus$iv = ProductDetailsPageDataState.ProductDetailsPageStatus.LOADING;
                do {
                    prevValue$iv$iv = $receiver$iv.getValue();
                    ProductDetailsPageDataState productDetailsPageDataState = (ProductDetailsPageDataState) prevValue$iv$iv;
                    nextValue$iv$iv = new ProductDetailsPageDataState(pageStatus$iv, null, null);
                } while (!$receiver$iv.compareAndSet(prevValue$iv$iv, nextValue$iv$iv));
                this.label = 1;
                reserveAndReceiveCoupon$product_details_page_debug = ReserveApiService.INSTANCE.reserveAndReceiveCoupon$product_details_page_debug(this.$itemsId, this.$reserveReq, this.$receiveCouponCmd, (Continuation) this);
                if (reserveAndReceiveCoupon$product_details_page_debug == coroutine_suspended) {
                    return coroutine_suspended;
                }
                ReserveApiService.ReserveAndReceiveResponse response = (ReserveApiService.ReserveAndReceiveResponse) reserveAndReceiveCoupon$product_details_page_debug;
                data = response.getData();
                if (data != null && data.length() != 0) {
                    z = false;
                }
                if (!z) {
                    ProductDetailsPageService productDetailsPageService2 = this.this$0;
                    $receiver$iv2 = this.this$0._reserveResultFlow;
                    ProductDetailsPageDataState.ProductDetailsPageStatus pageStatus$iv2 = ProductDetailsPageDataState.ProductDetailsPageStatus.ERROR;
                    do {
                        prevValue$iv$iv2 = $receiver$iv2.getValue();
                        ProductDetailsPageDataState productDetailsPageDataState2 = (ProductDetailsPageDataState) prevValue$iv$iv2;
                        nextValue$iv$iv2 = new ProductDetailsPageDataState(pageStatus$iv2, null, "token为空");
                    } while (!$receiver$iv2.compareAndSet(prevValue$iv$iv2, nextValue$iv$iv2));
                    return Unit.INSTANCE;
                }
                String token = response.getData();
                Ref.IntRef resultCycleTimes = new Ref.IntRef();
                final ProductDetailsPageService productDetailsPageService3 = this.this$0;
                Function1 resultCycleFinished = new Function1() { // from class: kntr.app.mall.product.details.page.kmm.ProductDetailsPageService$triggerReserve$1$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        Unit invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = ProductDetailsPageService$triggerReserve$1.invokeSuspend$lambda$0(ProductDetailsPageService.this, (ReserveApiService.ReserveResultResponse.ReserveResultData) obj);
                        return invokeSuspend$lambda$0;
                    }
                };
                Ref.ObjectRef resultCycle = new Ref.ObjectRef();
                resultCycle.element = new AnonymousClass1(resultCycleTimes, this.this$0, token, this.$itemsId, resultCycleFinished, resultCycle, null);
                if (resultCycle.element == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("resultCycle");
                    function1 = null;
                } else {
                    function1 = (Function1) resultCycle.element;
                }
                this.L$0 = SpillingKt.nullOutSpilledVariable(response);
                this.L$1 = SpillingKt.nullOutSpilledVariable(token);
                this.L$2 = SpillingKt.nullOutSpilledVariable(resultCycleTimes);
                this.L$3 = SpillingKt.nullOutSpilledVariable(resultCycleFinished);
                this.L$4 = SpillingKt.nullOutSpilledVariable(resultCycle);
                this.label = 2;
                if (function1.invoke(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            case 1:
                ResultKt.throwOnFailure($result);
                reserveAndReceiveCoupon$product_details_page_debug = $result;
                ReserveApiService.ReserveAndReceiveResponse response2 = (ReserveApiService.ReserveAndReceiveResponse) reserveAndReceiveCoupon$product_details_page_debug;
                data = response2.getData();
                if (data != null) {
                    z = false;
                    break;
                }
                if (!z) {
                }
                break;
            case 2:
                Ref.ObjectRef objectRef = (Ref.ObjectRef) this.L$4;
                Function1 function12 = (Function1) this.L$3;
                Ref.IntRef intRef = (Ref.IntRef) this.L$2;
                String str = (String) this.L$1;
                ReserveApiService.ReserveAndReceiveResponse reserveAndReceiveResponse = (ReserveApiService.ReserveAndReceiveResponse) this.L$0;
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$0(ProductDetailsPageService this$0, ReserveApiService.ReserveResultResponse.ReserveResultData result) {
        MutableStateFlow $receiver$iv;
        Object prevValue$iv$iv;
        Object nextValue$iv$iv;
        MutableStateFlow $receiver$iv2;
        Object prevValue$iv$iv2;
        Object nextValue$iv$iv2;
        if (!Intrinsics.areEqual(result.getReceiveCouponSuccess(), true) || result.getCouponInfoDTO() == null) {
            $receiver$iv = this$0._reserveResultFlow;
            ProductDetailsPageDataState.ProductDetailsPageStatus pageStatus$iv = ProductDetailsPageDataState.ProductDetailsPageStatus.EMPTY;
            String errorMessage$iv = result.getToast();
            if (errorMessage$iv == null && (errorMessage$iv = result.getResultText()) == null) {
                errorMessage$iv = "success";
            }
            do {
                prevValue$iv$iv = $receiver$iv.getValue();
                ProductDetailsPageDataState productDetailsPageDataState = (ProductDetailsPageDataState) prevValue$iv$iv;
                nextValue$iv$iv = new ProductDetailsPageDataState(pageStatus$iv, null, errorMessage$iv);
            } while (!$receiver$iv.compareAndSet(prevValue$iv$iv, nextValue$iv$iv));
        } else {
            $receiver$iv2 = this$0._reserveResultFlow;
            ProductDetailsPageDataState.ProductDetailsPageStatus pageStatus$iv2 = ProductDetailsPageDataState.ProductDetailsPageStatus.SUCCESS;
            do {
                prevValue$iv$iv2 = $receiver$iv2.getValue();
                ProductDetailsPageDataState productDetailsPageDataState2 = (ProductDetailsPageDataState) prevValue$iv$iv2;
                nextValue$iv$iv2 = new ProductDetailsPageDataState(pageStatus$iv2, result, null);
            } while (!$receiver$iv2.compareAndSet(prevValue$iv$iv2, nextValue$iv$iv2));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ProductDetailsPageService.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @DebugMetadata(c = "kntr.app.mall.product.details.page.kmm.ProductDetailsPageService$triggerReserve$1$1", f = "ProductDetailsPageService.kt", i = {1, 1, 2, 2}, l = {519, 527, 528}, m = "invokeSuspend", n = {"resultResponse", "cycleResult", "resultResponse", "cycleResult"}, s = {"L$0", "L$1", "L$0", "L$1"}, v = 1)
    /* renamed from: kntr.app.mall.product.details.page.kmm.ProductDetailsPageService$triggerReserve$1$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ String $itemsId;
        final /* synthetic */ Ref.ObjectRef<Function1<Continuation<? super Unit>, Object>> $resultCycle;
        final /* synthetic */ Function1<ReserveApiService.ReserveResultResponse.ReserveResultData, Unit> $resultCycleFinished;
        final /* synthetic */ Ref.IntRef $resultCycleTimes;
        final /* synthetic */ String $token;
        Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ ProductDetailsPageService this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(Ref.IntRef intRef, ProductDetailsPageService productDetailsPageService, String str, String str2, Function1<? super ReserveApiService.ReserveResultResponse.ReserveResultData, Unit> function1, Ref.ObjectRef<Function1<Continuation<? super Unit>, Object>> objectRef, Continuation<? super AnonymousClass1> continuation) {
            super(1, continuation);
            this.$resultCycleTimes = intRef;
            this.this$0 = productDetailsPageService;
            this.$token = str;
            this.$itemsId = str2;
            this.$resultCycleFinished = function1;
            this.$resultCycle = objectRef;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass1(this.$resultCycleTimes, this.this$0, this.$token, this.$itemsId, this.$resultCycleFinished, this.$resultCycle, continuation);
        }

        public final Object invoke(Continuation<? super Unit> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x0093  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x00a0  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x00a3  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x00a9  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x00cb  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x00d3  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x00ee A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:35:0x00ef  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object $result) {
            Object reserveAndReceiveCouponResult$product_details_page_debug;
            MutableStateFlow $receiver$iv;
            Object prevValue$iv$iv;
            Object nextValue$iv$iv;
            ReserveApiService.ReserveResultResponse.ReserveResultData cycleResult;
            ReserveApiService.ReserveResultResponse resultResponse;
            ReserveApiService.ReserveResultResponse.ReserveResultData cycleResult2;
            Function1 function1;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    if (this.$resultCycleTimes.element > 2) {
                        ProductDetailsPageService productDetailsPageService = this.this$0;
                        $receiver$iv = this.this$0._reserveResultFlow;
                        ProductDetailsPageDataState.ProductDetailsPageStatus pageStatus$iv = ProductDetailsPageDataState.ProductDetailsPageStatus.ERROR;
                        do {
                            prevValue$iv$iv = $receiver$iv.getValue();
                            ProductDetailsPageDataState productDetailsPageDataState = (ProductDetailsPageDataState) prevValue$iv$iv;
                            nextValue$iv$iv = new ProductDetailsPageDataState(pageStatus$iv, null, "操作超时，请重试");
                        } while (!$receiver$iv.compareAndSet(prevValue$iv$iv, nextValue$iv$iv));
                    }
                    this.$resultCycleTimes.element++;
                    this.label = 1;
                    reserveAndReceiveCouponResult$product_details_page_debug = ReserveApiService.INSTANCE.reserveAndReceiveCouponResult$product_details_page_debug(this.$token, this.$itemsId, (Continuation) this);
                    if (reserveAndReceiveCouponResult$product_details_page_debug == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    ReserveApiService.ReserveResultResponse resultResponse2 = (ReserveApiService.ReserveResultResponse) reserveAndReceiveCouponResult$product_details_page_debug;
                    cycleResult = resultResponse2.getData();
                    if (!(cycleResult == null ? Intrinsics.areEqual(cycleResult.getFinished(), Boxing.boxBoolean(true)) : false)) {
                        this.$resultCycleFinished.invoke(cycleResult);
                    }
                    this.L$0 = SpillingKt.nullOutSpilledVariable(resultResponse2);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(cycleResult);
                    this.label = 2;
                    if (DelayKt.delay(1000L, (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    resultResponse = resultResponse2;
                    cycleResult2 = cycleResult;
                    if (this.$resultCycle.element != null) {
                        Intrinsics.throwUninitializedPropertyAccessException("resultCycle");
                        function1 = null;
                    } else {
                        function1 = (Function1) this.$resultCycle.element;
                    }
                    this.L$0 = SpillingKt.nullOutSpilledVariable(resultResponse);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(cycleResult2);
                    this.label = 3;
                    return function1.invoke(this) != coroutine_suspended ? coroutine_suspended : Unit.INSTANCE;
                case 1:
                    ResultKt.throwOnFailure($result);
                    reserveAndReceiveCouponResult$product_details_page_debug = $result;
                    ReserveApiService.ReserveResultResponse resultResponse22 = (ReserveApiService.ReserveResultResponse) reserveAndReceiveCouponResult$product_details_page_debug;
                    cycleResult = resultResponse22.getData();
                    if (!(cycleResult == null ? Intrinsics.areEqual(cycleResult.getFinished(), Boxing.boxBoolean(true)) : false)) {
                    }
                    break;
                case 2:
                    cycleResult2 = (ReserveApiService.ReserveResultResponse.ReserveResultData) this.L$1;
                    resultResponse = (ReserveApiService.ReserveResultResponse) this.L$0;
                    ResultKt.throwOnFailure($result);
                    if (this.$resultCycle.element != null) {
                    }
                    this.L$0 = SpillingKt.nullOutSpilledVariable(resultResponse);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(cycleResult2);
                    this.label = 3;
                    if (function1.invoke(this) != coroutine_suspended) {
                    }
                    break;
                case 3:
                    ReserveApiService.ReserveResultResponse.ReserveResultData reserveResultData = (ReserveApiService.ReserveResultResponse.ReserveResultData) this.L$1;
                    ReserveApiService.ReserveResultResponse reserveResultResponse = (ReserveApiService.ReserveResultResponse) this.L$0;
                    ResultKt.throwOnFailure($result);
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }
}