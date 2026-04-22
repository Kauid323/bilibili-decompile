package kntr.app.mall.product.details.page.kmm;

import java.util.Map;
import kntr.app.mall.product.details.page.api.CommentInfoApiService;
import kntr.app.mall.product.details.page.api.ProductApiService;
import kntr.app.mall.product.details.page.api.model.ProductDetailsResponse;
import kntr.app.mall.product.details.page.kmm.ProductDetailsPageDataState;
import kntr.app.mall.product.details.page.utils.DateFormatKt;
import kntr.app.mall.product.details.page.utils.TrackConsts;
import kntr.app.mall.product.details.page.vm.ApiRepository;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.neuron.KNeuron;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.flow.MutableStateFlow;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProductDetailsPageService.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.mall.product.details.page.kmm.ProductDetailsPageService$loadProductDetails$1", f = "ProductDetailsPageService.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2}, l = {565, 566, 585}, m = "invokeSuspend", n = {"$this$launch", "productDetailsDeferred", "commentsDeferred", "success", "startTime", "$this$launch", "productDetailsDeferred", "commentsDeferred", "productDetailsResponse", "success", "startTime", "$this$launch", "productDetailsDeferred", "commentsDeferred", "productDetailsResponse", "commentResponse", "success", "startTime", "endTime"}, s = {"L$0", "L$1", "L$2", "I$0", "J$0", "L$0", "L$1", "L$2", "L$3", "I$0", "J$0", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "J$0", "J$1"}, v = 1)
public final class ProductDetailsPageService$loadProductDetails$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Long $addrId;
    final /* synthetic */ boolean $isFirst;
    int I$0;
    long J$0;
    long J$1;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    final /* synthetic */ ProductDetailsPageService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProductDetailsPageService$loadProductDetails$1(ProductDetailsPageService productDetailsPageService, boolean z, Long l, Continuation<? super ProductDetailsPageService$loadProductDetails$1> continuation) {
        super(2, continuation);
        this.this$0 = productDetailsPageService;
        this.$isFirst = z;
        this.$addrId = l;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> productDetailsPageService$loadProductDetails$1 = new ProductDetailsPageService$loadProductDetails$1(this.this$0, this.$isFirst, this.$addrId, continuation);
        productDetailsPageService$loadProductDetails$1.L$0 = obj;
        return productDetailsPageService$loadProductDetails$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x00fa A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x020f  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0271 A[LOOP:0: B:21:0x0120->B:48:0x0271, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x013f A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        int i;
        MutableStateFlow $this$update$iv;
        Deferred commentsDeferred;
        long startTime;
        Object await;
        Deferred productDetailsDeferred;
        Object await2;
        long startTime2;
        ProductDetailsResponse productDetailsResponse;
        Deferred commentsDeferred2;
        Deferred productDetailsDeferred2;
        int i2;
        long endTime;
        MutableStateFlow $this$update$iv$iv;
        ProductDetailsPageDataState.ProductDetailsPageStatus pageStatus$iv;
        Object holdData$iv;
        Object prevValue$iv$iv;
        Object nextValue$iv$iv;
        MutableStateFlow $this$update$iv$iv2;
        int i3;
        ApiRepository mRepository;
        long startTime3;
        ProductDetailsResponse productDetailsResponse2;
        Deferred commentsDeferred3;
        Deferred productDetailsDeferred3;
        ProductDetailsPageService$loadProductDetails$1 productDetailsPageService$loadProductDetails$1 = this;
        CoroutineScope $this$launch = (CoroutineScope) productDetailsPageService$loadProductDetails$1.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (productDetailsPageService$loadProductDetails$1.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                i = 0;
                $this$update$iv = productDetailsPageService$loadProductDetails$1.this$0._loadingState;
                while (true) {
                    Object prevValue$iv = $this$update$iv.getValue();
                    ((Boolean) prevValue$iv).booleanValue();
                    Object nextValue$iv = Boxing.boxBoolean(true);
                    if ($this$update$iv.compareAndSet(prevValue$iv, nextValue$iv)) {
                        Deferred productDetailsDeferred4 = BuildersKt.async$default($this$launch, (CoroutineContext) null, (CoroutineStart) null, new ProductDetailsPageService$loadProductDetails$1$productDetailsDeferred$1(productDetailsPageService$loadProductDetails$1.this$0, productDetailsPageService$loadProductDetails$1.$addrId, null), 3, (Object) null);
                        commentsDeferred = BuildersKt.async$default($this$launch, (CoroutineContext) null, (CoroutineStart) null, new ProductDetailsPageService$loadProductDetails$1$commentsDeferred$1(productDetailsPageService$loadProductDetails$1.this$0, null), 3, (Object) null);
                        startTime = DateFormatKt.getCurrentTimeMillis();
                        productDetailsPageService$loadProductDetails$1.L$0 = SpillingKt.nullOutSpilledVariable($this$launch);
                        productDetailsPageService$loadProductDetails$1.L$1 = SpillingKt.nullOutSpilledVariable(productDetailsDeferred4);
                        productDetailsPageService$loadProductDetails$1.L$2 = commentsDeferred;
                        productDetailsPageService$loadProductDetails$1.I$0 = 0;
                        productDetailsPageService$loadProductDetails$1.J$0 = startTime;
                        productDetailsPageService$loadProductDetails$1.label = 1;
                        await = productDetailsDeferred4.await((Continuation) productDetailsPageService$loadProductDetails$1);
                        if (await == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        productDetailsDeferred = productDetailsDeferred4;
                        ProductDetailsResponse productDetailsResponse3 = (ProductDetailsResponse) await;
                        productDetailsPageService$loadProductDetails$1.L$0 = SpillingKt.nullOutSpilledVariable($this$launch);
                        productDetailsPageService$loadProductDetails$1.L$1 = SpillingKt.nullOutSpilledVariable(productDetailsDeferred);
                        productDetailsPageService$loadProductDetails$1.L$2 = SpillingKt.nullOutSpilledVariable(commentsDeferred);
                        productDetailsPageService$loadProductDetails$1.L$3 = productDetailsResponse3;
                        productDetailsPageService$loadProductDetails$1.I$0 = i;
                        productDetailsPageService$loadProductDetails$1.J$0 = startTime;
                        productDetailsPageService$loadProductDetails$1.label = 2;
                        await2 = commentsDeferred.await((Continuation) productDetailsPageService$loadProductDetails$1);
                        if (await2 != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        startTime2 = startTime;
                        productDetailsResponse = productDetailsResponse3;
                        commentsDeferred2 = commentsDeferred;
                        productDetailsDeferred2 = productDetailsDeferred;
                        i2 = i;
                        CommentInfoApiService.CommentInfoResponse commentResponse = (CommentInfoApiService.CommentInfoResponse) await2;
                        endTime = DateFormatKt.getCurrentTimeMillis();
                        ProductDetailsPageService productDetailsPageService = productDetailsPageService$loadProductDetails$1.this$0;
                        $this$update$iv$iv = productDetailsPageService$loadProductDetails$1.this$0._productDetailsResponse;
                        pageStatus$iv = ProductDetailsPageDataState.ProductDetailsPageStatus.SUCCESS;
                        holdData$iv = productDetailsResponse;
                        while (true) {
                            prevValue$iv$iv = $this$update$iv$iv.getValue();
                            ProductDetailsPageDataState productDetailsPageDataState = (ProductDetailsPageDataState) prevValue$iv$iv;
                            Object holdData$iv2 = holdData$iv;
                            nextValue$iv$iv = new ProductDetailsPageDataState(pageStatus$iv, holdData$iv2, null);
                            if ($this$update$iv$iv.compareAndSet(prevValue$iv$iv, nextValue$iv$iv)) {
                                productDetailsPageService$loadProductDetails$1 = this;
                                holdData$iv = holdData$iv2;
                                $this$launch = $this$launch;
                            } else {
                                ProductDetailsPageService productDetailsPageService2 = productDetailsPageService$loadProductDetails$1.this$0;
                                $this$update$iv$iv2 = productDetailsPageService$loadProductDetails$1.this$0._commentApiResponse;
                                ProductDetailsPageDataState.ProductDetailsPageStatus pageStatus$iv2 = ProductDetailsPageDataState.ProductDetailsPageStatus.SUCCESS;
                                while (true) {
                                    Object prevValue$iv$iv2 = $this$update$iv$iv2.getValue();
                                    ProductDetailsPageDataState productDetailsPageDataState2 = (ProductDetailsPageDataState) prevValue$iv$iv2;
                                    int i4 = i2;
                                    Object nextValue$iv$iv2 = new ProductDetailsPageDataState(pageStatus$iv2, commentResponse, null);
                                    if ($this$update$iv$iv2.compareAndSet(prevValue$iv$iv2, nextValue$iv$iv2)) {
                                        productDetailsPageService$loadProductDetails$1.this$0.fetchDataSuccess(productDetailsResponse, commentResponse);
                                        Integer code = productDetailsResponse.getCode();
                                        if (code != null && code.intValue() == 0) {
                                            productDetailsPageService$loadProductDetails$1.this$0.fetchDataSuccessAfter();
                                            productDetailsPageService$loadProductDetails$1.this$0.reportLoadFinished(productDetailsPageService$loadProductDetails$1.$isFirst);
                                            i3 = 1;
                                        } else {
                                            i3 = i4;
                                        }
                                        if (productDetailsPageService$loadProductDetails$1.$isFirst) {
                                            mRepository = productDetailsPageService$loadProductDetails$1.this$0.getMRepository();
                                            productDetailsPageService$loadProductDetails$1.L$0 = SpillingKt.nullOutSpilledVariable($this$launch);
                                            productDetailsPageService$loadProductDetails$1.L$1 = SpillingKt.nullOutSpilledVariable(productDetailsDeferred2);
                                            productDetailsPageService$loadProductDetails$1.L$2 = SpillingKt.nullOutSpilledVariable(commentsDeferred2);
                                            productDetailsPageService$loadProductDetails$1.L$3 = SpillingKt.nullOutSpilledVariable(productDetailsResponse);
                                            productDetailsPageService$loadProductDetails$1.L$4 = SpillingKt.nullOutSpilledVariable(commentResponse);
                                            productDetailsPageService$loadProductDetails$1.I$0 = i3;
                                            productDetailsPageService$loadProductDetails$1.J$0 = startTime2;
                                            productDetailsPageService$loadProductDetails$1.J$1 = endTime;
                                            productDetailsPageService$loadProductDetails$1.label = 3;
                                            if (mRepository.reportHistory((Continuation) productDetailsPageService$loadProductDetails$1) == coroutine_suspended) {
                                                return coroutine_suspended;
                                            }
                                            startTime3 = startTime2;
                                            productDetailsResponse2 = productDetailsResponse;
                                            commentsDeferred3 = commentsDeferred2;
                                            productDetailsDeferred3 = productDetailsDeferred2;
                                            long duration = endTime - startTime3;
                                            long productTimeConsuming = ProductApiService.INSTANCE.getRecentTimeConsuming().getThird().longValue();
                                            long commentTimeConsuming = CommentInfoApiService.INSTANCE.getRecentTimeConsuming().getThird().longValue();
                                            Pair[] pairArr = new Pair[4];
                                            pairArr[0] = TuplesKt.to("sentinel_req_cost", String.valueOf(duration));
                                            pairArr[1] = TuplesKt.to("sentinel_req_suc", String.valueOf(i3 == 0));
                                            pairArr[2] = TuplesKt.to("sentinel_req_comment_cost", String.valueOf(commentTimeConsuming));
                                            pairArr[3] = TuplesKt.to("sentinel_req_detail_cost", String.valueOf(productTimeConsuming));
                                            Map map = MapsKt.mapOf(pairArr);
                                            KNeuron.INSTANCE.reportExposure(false, TrackConsts.MALL_MALL_DETAIL_PAGE_LOAD_0_SHOW, map);
                                            return Unit.INSTANCE;
                                        }
                                        return Unit.INSTANCE;
                                    }
                                    productDetailsPageService$loadProductDetails$1 = this;
                                    i2 = i4;
                                    $this$launch = $this$launch;
                                }
                            }
                        }
                    } else {
                        productDetailsPageService$loadProductDetails$1 = this;
                        $this$launch = $this$launch;
                    }
                }
                break;
            case 1:
                startTime = productDetailsPageService$loadProductDetails$1.J$0;
                int i5 = productDetailsPageService$loadProductDetails$1.I$0;
                commentsDeferred = (Deferred) productDetailsPageService$loadProductDetails$1.L$2;
                productDetailsDeferred = (Deferred) productDetailsPageService$loadProductDetails$1.L$1;
                ResultKt.throwOnFailure($result);
                i = i5;
                await = $result;
                ProductDetailsResponse productDetailsResponse32 = (ProductDetailsResponse) await;
                productDetailsPageService$loadProductDetails$1.L$0 = SpillingKt.nullOutSpilledVariable($this$launch);
                productDetailsPageService$loadProductDetails$1.L$1 = SpillingKt.nullOutSpilledVariable(productDetailsDeferred);
                productDetailsPageService$loadProductDetails$1.L$2 = SpillingKt.nullOutSpilledVariable(commentsDeferred);
                productDetailsPageService$loadProductDetails$1.L$3 = productDetailsResponse32;
                productDetailsPageService$loadProductDetails$1.I$0 = i;
                productDetailsPageService$loadProductDetails$1.J$0 = startTime;
                productDetailsPageService$loadProductDetails$1.label = 2;
                await2 = commentsDeferred.await((Continuation) productDetailsPageService$loadProductDetails$1);
                if (await2 != coroutine_suspended) {
                }
                break;
            case 2:
                long endTime2 = productDetailsPageService$loadProductDetails$1.J$0;
                int i6 = productDetailsPageService$loadProductDetails$1.I$0;
                ResultKt.throwOnFailure($result);
                startTime2 = endTime2;
                productDetailsResponse = (ProductDetailsResponse) productDetailsPageService$loadProductDetails$1.L$3;
                commentsDeferred2 = (Deferred) productDetailsPageService$loadProductDetails$1.L$2;
                productDetailsDeferred2 = (Deferred) productDetailsPageService$loadProductDetails$1.L$1;
                await2 = $result;
                i2 = i6;
                CommentInfoApiService.CommentInfoResponse commentResponse2 = (CommentInfoApiService.CommentInfoResponse) await2;
                endTime = DateFormatKt.getCurrentTimeMillis();
                ProductDetailsPageService productDetailsPageService3 = productDetailsPageService$loadProductDetails$1.this$0;
                $this$update$iv$iv = productDetailsPageService$loadProductDetails$1.this$0._productDetailsResponse;
                pageStatus$iv = ProductDetailsPageDataState.ProductDetailsPageStatus.SUCCESS;
                holdData$iv = productDetailsResponse;
                while (true) {
                    prevValue$iv$iv = $this$update$iv$iv.getValue();
                    ProductDetailsPageDataState productDetailsPageDataState3 = (ProductDetailsPageDataState) prevValue$iv$iv;
                    Object holdData$iv22 = holdData$iv;
                    nextValue$iv$iv = new ProductDetailsPageDataState(pageStatus$iv, holdData$iv22, null);
                    if ($this$update$iv$iv.compareAndSet(prevValue$iv$iv, nextValue$iv$iv)) {
                    }
                    productDetailsPageService$loadProductDetails$1 = this;
                    holdData$iv = holdData$iv22;
                    $this$launch = $this$launch;
                }
                break;
            case 3:
                endTime = productDetailsPageService$loadProductDetails$1.J$1;
                startTime3 = productDetailsPageService$loadProductDetails$1.J$0;
                i3 = productDetailsPageService$loadProductDetails$1.I$0;
                CommentInfoApiService.CommentInfoResponse commentInfoResponse = (CommentInfoApiService.CommentInfoResponse) productDetailsPageService$loadProductDetails$1.L$4;
                productDetailsResponse2 = (ProductDetailsResponse) productDetailsPageService$loadProductDetails$1.L$3;
                commentsDeferred3 = (Deferred) productDetailsPageService$loadProductDetails$1.L$2;
                productDetailsDeferred3 = (Deferred) productDetailsPageService$loadProductDetails$1.L$1;
                ResultKt.throwOnFailure($result);
                long duration2 = endTime - startTime3;
                long productTimeConsuming2 = ProductApiService.INSTANCE.getRecentTimeConsuming().getThird().longValue();
                long commentTimeConsuming2 = CommentInfoApiService.INSTANCE.getRecentTimeConsuming().getThird().longValue();
                Pair[] pairArr2 = new Pair[4];
                pairArr2[0] = TuplesKt.to("sentinel_req_cost", String.valueOf(duration2));
                pairArr2[1] = TuplesKt.to("sentinel_req_suc", String.valueOf(i3 == 0));
                pairArr2[2] = TuplesKt.to("sentinel_req_comment_cost", String.valueOf(commentTimeConsuming2));
                pairArr2[3] = TuplesKt.to("sentinel_req_detail_cost", String.valueOf(productTimeConsuming2));
                Map map2 = MapsKt.mapOf(pairArr2);
                KNeuron.INSTANCE.reportExposure(false, TrackConsts.MALL_MALL_DETAIL_PAGE_LOAD_0_SHOW, map2);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}