package kntr.app.mall.product.details.page.vm;

import kntr.app.mall.product.details.page.api.CommentInfoApiService;
import kntr.app.mall.product.details.page.api.ProductApiService;
import kntr.app.mall.product.details.page.api.ProductShopApiService;
import kntr.app.mall.product.details.page.api.model.BasicInfoFloor;
import kntr.app.mall.product.details.page.api.model.ProductDetailsResponse;
import kntr.app.mall.product.details.page.utils.DateFormatKt;
import kntr.app.mall.product.details.page.utils.TrackConsts;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
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
/* compiled from: PageViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.mall.product.details.page.vm.PageViewModel$loadProductDetails$2", f = "PageViewModel.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2}, l = {610, 611, 635}, m = "invokeSuspend", n = {"$this$launch", "productDetailsDeferred", "commentsDeferred", "startTime", "endTime", "success", "$this$launch", "productDetailsDeferred", "commentsDeferred", "productDetailsResponse", "startTime", "endTime", "success", "$this$launch", "productDetailsDeferred", "commentsDeferred", "productDetailsResponse", "commentResponse", "startTime", "endTime", "success"}, s = {"L$0", "L$1", "L$2", "J$0", "J$1", "I$0", "L$0", "L$1", "L$2", "L$3", "J$0", "J$1", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "J$0", "J$1", "I$0"}, v = 1)
public final class PageViewModel$loadProductDetails$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
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
    final /* synthetic */ PageViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PageViewModel$loadProductDetails$2(PageViewModel pageViewModel, boolean z, Continuation<? super PageViewModel$loadProductDetails$2> continuation) {
        super(2, continuation);
        this.this$0 = pageViewModel;
        this.$isFirst = z;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> pageViewModel$loadProductDetails$2 = new PageViewModel$loadProductDetails$2(this.this$0, this.$isFirst, continuation);
        pageViewModel$loadProductDetails$2.L$0 = obj;
        return pageViewModel$loadProductDetails$2;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x00ec A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0241  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x02b4 A[LOOP:0: B:18:0x00fe->B:68:0x02b4, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0115 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        int i;
        Deferred commentsDeferred;
        long startTime;
        Object await;
        Deferred productDetailsDeferred;
        long endTime;
        Object await2;
        Deferred productDetailsDeferred2;
        Deferred productDetailsDeferred3;
        ProductDetailsResponse productDetailsResponse;
        int i2;
        long endTime2;
        MutableStateFlow $this$update$iv;
        Object prevValue$iv;
        ProductDetailsResponse it;
        MutableStateFlow $this$update$iv2;
        ProductShopApiService.ProductShopDetailsResponse productShopDetailsResponse;
        ApiRepository apiRepository;
        ProductDetailsResponse productDetailsResponse2;
        CommentInfoApiService.CommentInfoResponse commentResponse;
        Deferred commentsDeferred2;
        Deferred commentsDeferred3;
        MutableStateFlow $this$update$iv3;
        Object prevValue$iv2;
        String it2;
        MutableStateFlow $this$update$iv4;
        Object prevValue$iv3;
        String it3;
        BasicInfoFloor basicInfoFloorVO;
        BasicInfoFloor.NewUpSayModel newUpSayVO;
        BasicInfoFloor basicInfoFloorVO2;
        BasicInfoFloor basicInfoFloorVO3;
        CoroutineScope $this$launch = (CoroutineScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                i = 0;
                Deferred productDetailsDeferred4 = BuildersKt.async$default($this$launch, (CoroutineContext) null, (CoroutineStart) null, new PageViewModel$loadProductDetails$2$productDetailsDeferred$1(this.this$0, null), 3, (Object) null);
                commentsDeferred = BuildersKt.async$default($this$launch, (CoroutineContext) null, (CoroutineStart) null, new PageViewModel$loadProductDetails$2$commentsDeferred$1(this.this$0, null), 3, (Object) null);
                startTime = DateFormatKt.getCurrentTimeMillis();
                this.L$0 = SpillingKt.nullOutSpilledVariable($this$launch);
                this.L$1 = SpillingKt.nullOutSpilledVariable(productDetailsDeferred4);
                this.L$2 = commentsDeferred;
                this.J$0 = startTime;
                this.J$1 = 0L;
                this.I$0 = 0;
                this.label = 1;
                await = productDetailsDeferred4.await((Continuation) this);
                if (await == coroutine_suspended) {
                    return coroutine_suspended;
                }
                productDetailsDeferred = productDetailsDeferred4;
                endTime = 0;
                ProductDetailsResponse productDetailsResponse3 = (ProductDetailsResponse) await;
                this.L$0 = SpillingKt.nullOutSpilledVariable($this$launch);
                this.L$1 = SpillingKt.nullOutSpilledVariable(productDetailsDeferred);
                this.L$2 = SpillingKt.nullOutSpilledVariable(commentsDeferred);
                this.L$3 = productDetailsResponse3;
                this.J$0 = startTime;
                this.J$1 = endTime;
                this.I$0 = i;
                this.label = 2;
                await2 = commentsDeferred.await((Continuation) this);
                if (await2 != coroutine_suspended) {
                    return coroutine_suspended;
                }
                productDetailsDeferred2 = productDetailsDeferred;
                productDetailsDeferred3 = commentsDeferred;
                productDetailsResponse = productDetailsResponse3;
                i2 = i;
                CommentInfoApiService.CommentInfoResponse commentResponse2 = (CommentInfoApiService.CommentInfoResponse) await2;
                endTime2 = DateFormatKt.getCurrentTimeMillis();
                $this$update$iv = this.this$0._productDetailsResponse;
                while (true) {
                    prevValue$iv = $this$update$iv.getValue();
                    ProductDetailsResponse productDetailsResponse4 = (ProductDetailsResponse) prevValue$iv;
                    it = productDetailsResponse;
                    if (!$this$update$iv.compareAndSet(prevValue$iv, it)) {
                        $this$update$iv2 = this.this$0._commentApiResponse;
                        while (true) {
                            Object prevValue$iv4 = $this$update$iv2.getValue();
                            CommentInfoApiService.CommentInfoResponse commentInfoResponse = (CommentInfoApiService.CommentInfoResponse) prevValue$iv4;
                            if ($this$update$iv2.compareAndSet(prevValue$iv4, commentResponse2)) {
                                PageViewModel pageViewModel = this.this$0;
                                productShopDetailsResponse = this.this$0.lastShopResponse;
                                pageViewModel.fetchDataSuccess(productDetailsResponse, commentResponse2, productShopDetailsResponse);
                                PageViewModel pageViewModel2 = this.this$0;
                                ProductDetailsResponse.ProductDetailsData data = productDetailsResponse.getData();
                                pageViewModel2.setMerchantId((data == null || (basicInfoFloorVO3 = data.getBasicInfoFloorVO()) == null) ? null : basicInfoFloorVO3.getOneShopId());
                                this.this$0.getActionHandler$product_details_page_debug().setShopId(String.valueOf(this.this$0.getMerchantId()));
                                Integer code = productDetailsResponse.getCode();
                                if (code != null && code.intValue() == 0) {
                                    $this$update$iv3 = this.this$0._videoUrlState;
                                    do {
                                        prevValue$iv2 = $this$update$iv3.getValue();
                                        String str = (String) prevValue$iv2;
                                        ProductDetailsResponse.ProductDetailsData data2 = productDetailsResponse.getData();
                                        it2 = (data2 == null || (basicInfoFloorVO2 = data2.getBasicInfoFloorVO()) == null) ? null : basicInfoFloorVO2.getVideoUrl$product_details_page_debug();
                                    } while (!$this$update$iv3.compareAndSet(prevValue$iv2, it2));
                                    $this$update$iv4 = this.this$0._upSayVideoUrlState;
                                    do {
                                        prevValue$iv3 = $this$update$iv4.getValue();
                                        String str2 = (String) prevValue$iv3;
                                        ProductDetailsResponse.ProductDetailsData data3 = productDetailsResponse.getData();
                                        it3 = (data3 == null || (basicInfoFloorVO = data3.getBasicInfoFloorVO()) == null || (newUpSayVO = basicInfoFloorVO.getNewUpSayVO()) == null) ? null : newUpSayVO.getVideoUrl();
                                    } while (!$this$update$iv4.compareAndSet(prevValue$iv3, it3));
                                    i2 = 1;
                                    this.this$0.fetchDataSuccessAfter();
                                    this.this$0.reportLoadFinished(this.$isFirst);
                                }
                                if (this.$isFirst) {
                                    apiRepository = this.this$0.repository;
                                    this.L$0 = SpillingKt.nullOutSpilledVariable($this$launch);
                                    this.L$1 = SpillingKt.nullOutSpilledVariable(productDetailsDeferred2);
                                    this.L$2 = SpillingKt.nullOutSpilledVariable(productDetailsDeferred3);
                                    this.L$3 = SpillingKt.nullOutSpilledVariable(productDetailsResponse);
                                    this.L$4 = SpillingKt.nullOutSpilledVariable(commentResponse2);
                                    this.J$0 = startTime;
                                    this.J$1 = endTime2;
                                    this.I$0 = i2;
                                    this.label = 3;
                                    if (apiRepository.reportHistory((Continuation) this) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    productDetailsResponse2 = productDetailsResponse;
                                    commentResponse = commentResponse2;
                                    commentsDeferred2 = productDetailsDeferred3;
                                    commentsDeferred3 = productDetailsDeferred2;
                                    long duration = endTime2 - startTime;
                                    PageActionHandler actionHandler$product_details_page_debug = this.this$0.getActionHandler$product_details_page_debug();
                                    Pair[] pairArr = new Pair[4];
                                    pairArr[0] = TuplesKt.to("sentinel_req_cost", String.valueOf(duration));
                                    pairArr[1] = TuplesKt.to("sentinel_req_suc", String.valueOf(i2 != 0));
                                    pairArr[2] = TuplesKt.to("sentinel_req_comment_cost", String.valueOf(CommentInfoApiService.INSTANCE.getRecentTimeConsuming().getThird().longValue()));
                                    pairArr[3] = TuplesKt.to("sentinel_req_detail_cost", String.valueOf(ProductApiService.INSTANCE.getRecentTimeConsuming().getThird().longValue()));
                                    PageActionHandler.trackEvent$product_details_page_debug$default(actionHandler$product_details_page_debug, TrackConsts.MALL_MALL_DETAIL_PAGE_LOAD_0_SHOW, MapsKt.mapOf(pairArr), false, false, 8, null);
                                }
                                return Unit.INSTANCE;
                            }
                        }
                    }
                }
                break;
            case 1:
                int i3 = this.I$0;
                endTime = this.J$1;
                startTime = this.J$0;
                commentsDeferred = (Deferred) this.L$2;
                productDetailsDeferred = (Deferred) this.L$1;
                ResultKt.throwOnFailure($result);
                i = i3;
                await = $result;
                ProductDetailsResponse productDetailsResponse32 = (ProductDetailsResponse) await;
                this.L$0 = SpillingKt.nullOutSpilledVariable($this$launch);
                this.L$1 = SpillingKt.nullOutSpilledVariable(productDetailsDeferred);
                this.L$2 = SpillingKt.nullOutSpilledVariable(commentsDeferred);
                this.L$3 = productDetailsResponse32;
                this.J$0 = startTime;
                this.J$1 = endTime;
                this.I$0 = i;
                this.label = 2;
                await2 = commentsDeferred.await((Continuation) this);
                if (await2 != coroutine_suspended) {
                }
                break;
            case 2:
                i2 = this.I$0;
                long j = this.J$1;
                startTime = this.J$0;
                productDetailsResponse = (ProductDetailsResponse) this.L$3;
                productDetailsDeferred3 = (Deferred) this.L$2;
                productDetailsDeferred2 = (Deferred) this.L$1;
                ResultKt.throwOnFailure($result);
                await2 = $result;
                CommentInfoApiService.CommentInfoResponse commentResponse22 = (CommentInfoApiService.CommentInfoResponse) await2;
                endTime2 = DateFormatKt.getCurrentTimeMillis();
                $this$update$iv = this.this$0._productDetailsResponse;
                while (true) {
                    prevValue$iv = $this$update$iv.getValue();
                    ProductDetailsResponse productDetailsResponse42 = (ProductDetailsResponse) prevValue$iv;
                    it = productDetailsResponse;
                    if (!$this$update$iv.compareAndSet(prevValue$iv, it)) {
                    }
                }
                break;
            case 3:
                i2 = this.I$0;
                endTime2 = this.J$1;
                startTime = this.J$0;
                commentResponse = (CommentInfoApiService.CommentInfoResponse) this.L$4;
                productDetailsResponse2 = (ProductDetailsResponse) this.L$3;
                commentsDeferred2 = (Deferred) this.L$2;
                commentsDeferred3 = (Deferred) this.L$1;
                ResultKt.throwOnFailure($result);
                long duration2 = endTime2 - startTime;
                PageActionHandler actionHandler$product_details_page_debug2 = this.this$0.getActionHandler$product_details_page_debug();
                Pair[] pairArr2 = new Pair[4];
                pairArr2[0] = TuplesKt.to("sentinel_req_cost", String.valueOf(duration2));
                pairArr2[1] = TuplesKt.to("sentinel_req_suc", String.valueOf(i2 != 0));
                pairArr2[2] = TuplesKt.to("sentinel_req_comment_cost", String.valueOf(CommentInfoApiService.INSTANCE.getRecentTimeConsuming().getThird().longValue()));
                pairArr2[3] = TuplesKt.to("sentinel_req_detail_cost", String.valueOf(ProductApiService.INSTANCE.getRecentTimeConsuming().getThird().longValue()));
                PageActionHandler.trackEvent$product_details_page_debug$default(actionHandler$product_details_page_debug2, TrackConsts.MALL_MALL_DETAIL_PAGE_LOAD_0_SHOW, MapsKt.mapOf(pairArr2), false, false, 8, null);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}