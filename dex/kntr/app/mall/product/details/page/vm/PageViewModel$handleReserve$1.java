package kntr.app.mall.product.details.page.vm;

import java.util.Map;
import kntr.app.mall.product.details.page.api.ReserveApiService;
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

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PageViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.mall.product.details.page.vm.PageViewModel$handleReserve$1", f = "PageViewModel.kt", i = {1, 1, 1, 1, 1}, l = {1993, 2033}, m = "invokeSuspend", n = {"response", "token", "resultCycleTimes", "resultCycleFinished", "resultCycle"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4"}, v = 1)
public final class PageViewModel$handleReserve$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $itemsId;
    final /* synthetic */ Map<String, Object> $receiveCouponCmd;
    final /* synthetic */ Map<String, Object> $reserveReq;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    final /* synthetic */ PageViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PageViewModel$handleReserve$1(String str, Map<String, ? extends Object> map, Map<String, ? extends Object> map2, PageViewModel pageViewModel, Continuation<? super PageViewModel$handleReserve$1> continuation) {
        super(2, continuation);
        this.$itemsId = str;
        this.$reserveReq = map;
        this.$receiveCouponCmd = map2;
        this.this$0 = pageViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PageViewModel$handleReserve$1(this.$itemsId, this.$reserveReq, this.$receiveCouponCmd, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        Object reserveAndReceiveCoupon$product_details_page_debug;
        String data;
        Function1 function1;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        boolean z = true;
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
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
                    return Unit.INSTANCE;
                }
                String token = response.getData();
                Ref.IntRef resultCycleTimes = new Ref.IntRef();
                final PageViewModel pageViewModel = this.this$0;
                Function1 resultCycleFinished = new Function1() { // from class: kntr.app.mall.product.details.page.vm.PageViewModel$handleReserve$1$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        Unit invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = PageViewModel$handleReserve$1.invokeSuspend$lambda$0(PageViewModel.this, (ReserveApiService.ReserveResultResponse.ReserveResultData) obj);
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
    public static final Unit invokeSuspend$lambda$0(PageViewModel this$0, ReserveApiService.ReserveResultResponse.ReserveResultData result) {
        MutableStateFlow $this$update$iv;
        Object prevValue$iv;
        MutableStateFlow $this$update$iv2;
        Object prevValue$iv2;
        if (Intrinsics.areEqual(result.getReceiveCouponSuccess(), true) && result.getCouponInfoDTO() != null) {
            $this$update$iv = this$0._reserveCouponResult;
            do {
                prevValue$iv = $this$update$iv.getValue();
                ReserveApiService.ReserveResultResponse.ReserveResultData reserveResultData = (ReserveApiService.ReserveResultResponse.ReserveResultData) prevValue$iv;
            } while (!$this$update$iv.compareAndSet(prevValue$iv, result));
            $this$update$iv2 = this$0._showCouponReserveResultDialog;
            do {
                prevValue$iv2 = $this$update$iv2.getValue();
                ((Boolean) prevValue$iv2).booleanValue();
            } while (!$this$update$iv2.compareAndSet(prevValue$iv2, true));
            this$0.reloadProductDetails$product_details_page_debug();
        } else {
            String toast = result.getToast();
            if (toast == null && (toast = result.getResultText()) == null) {
                toast = "success";
            }
            this$0.showToast$product_details_page_debug(toast);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PageViewModel.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @DebugMetadata(c = "kntr.app.mall.product.details.page.vm.PageViewModel$handleReserve$1$1", f = "PageViewModel.kt", i = {1, 1, 2, 2}, l = {2020, 2028, 2029}, m = "invokeSuspend", n = {"resultResponse", "cycleResult", "resultResponse", "cycleResult"}, s = {"L$0", "L$1", "L$0", "L$1"}, v = 1)
    /* renamed from: kntr.app.mall.product.details.page.vm.PageViewModel$handleReserve$1$1  reason: invalid class name */
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
        final /* synthetic */ PageViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(Ref.IntRef intRef, PageViewModel pageViewModel, String str, String str2, Function1<? super ReserveApiService.ReserveResultResponse.ReserveResultData, Unit> function1, Ref.ObjectRef<Function1<Continuation<? super Unit>, Object>> objectRef, Continuation<? super AnonymousClass1> continuation) {
            super(1, continuation);
            this.$resultCycleTimes = intRef;
            this.this$0 = pageViewModel;
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

        /* JADX WARN: Removed duplicated region for block: B:17:0x006a  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0077  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x007a  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0080  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x00a2  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x00aa  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x00c5 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:32:0x00c6  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object $result) {
            Object reserveAndReceiveCouponResult$product_details_page_debug;
            ReserveApiService.ReserveResultResponse.ReserveResultData cycleResult;
            ReserveApiService.ReserveResultResponse resultResponse;
            ReserveApiService.ReserveResultResponse.ReserveResultData cycleResult2;
            Function1 function1;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    if (this.$resultCycleTimes.element > 2) {
                        this.this$0.showToast$product_details_page_debug("操作超时，请重试");
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