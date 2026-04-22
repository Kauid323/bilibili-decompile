package kntr.app.mall.product.details.page;

import java.util.List;
import java.util.Map;
import kntr.app.mall.product.details.page.api.CommentInfoApiService;
import kntr.app.mall.product.details.page.api.CouponListApiService;
import kntr.app.mall.product.details.page.api.CouponListResponse;
import kntr.app.mall.product.details.page.api.LiveInfoApiService;
import kntr.app.mall.product.details.page.api.ProductApiService;
import kntr.app.mall.product.details.page.api.ProductShopApiService;
import kntr.app.mall.product.details.page.api.model.ProductDetailsResponse;
import kntr.app.mall.product.details.page.utils.DateFormatKt;
import kntr.app.mall.product.details.page.utils.NetworkUtilsKt;
import kntr.app.mall.product.details.page.utils.ThemesKt;
import kntr.app.mall.product.details.page.utils.UserInfoKt;
import kntr.app.mall.product.details.page.vm.ApiRepository;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.appinfo.KAppInfo;
import kntr.base.device.KDevice;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ProductDetailsPage.kt */
@Metadata(d1 = {"\u0000A\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0096@¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\nH\u0096@¢\u0006\u0002\u0010\u000bJ\u000e\u0010\f\u001a\u00020\rH\u0096@¢\u0006\u0002\u0010\u000bJ\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010\u0011J\u000e\u0010\u0012\u001a\u00020\u0013H\u0096@¢\u0006\u0002\u0010\u000bJ\u000e\u0010\u0014\u001a\u00020\u0015H\u0096@¢\u0006\u0002\u0010\u000b¨\u0006\u0016"}, d2 = {"kntr/app/mall/product/details/page/ProductDetailsPageKt$ProductDetailsPage$repository$1", "Lkntr/app/mall/product/details/page/vm/ApiRepository;", "getProductDetails", "Lkntr/app/mall/product/details/page/api/model/ProductDetailsResponse;", "addrId", "", "originUrl", "", "(Ljava/lang/Long;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getComments", "Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCouponList", "Lkntr/app/mall/product/details/page/api/CouponListResponse;", "getShopDetails", "Lkntr/app/mall/product/details/page/api/ProductShopApiService$ProductShopDetailsResponse;", "merchantId", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLiveInfo", "Lkntr/app/mall/product/details/page/api/LiveInfoApiService$LiveInfoResponse;", "reportHistory", "", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ProductDetailsPageKt$ProductDetailsPage$repository$1 implements ApiRepository {
    final /* synthetic */ Function3<String, Map<String, ? extends Object>, Function1<? super Map<String, ? extends Object>, Unit>, Unit> $bridgeCall;
    final /* synthetic */ String $from;
    final /* synthetic */ String $fromSpmId;
    final /* synthetic */ String $is_ad;
    final /* synthetic */ String $itemsId;
    final /* synthetic */ String $msource;
    final /* synthetic */ String $track_id;
    final /* synthetic */ Function2<String, Map<String, ? extends Object>, String> $valueBridge;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public ProductDetailsPageKt$ProductDetailsPage$repository$1(String $itemsId, String $msource, String $track_id, String $from, String $is_ad, String $fromSpmId, Function2<? super String, ? super Map<String, ? extends Object>, String> function2, Function3<? super String, ? super Map<String, ? extends Object>, ? super Function1<? super Map<String, ? extends Object>, Unit>, Unit> function3) {
        this.$itemsId = $itemsId;
        this.$msource = $msource;
        this.$track_id = $track_id;
        this.$from = $from;
        this.$is_ad = $is_ad;
        this.$fromSpmId = $fromSpmId;
        this.$valueBridge = function2;
        this.$bridgeCall = function3;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0042  */
    @Override // kntr.app.mall.product.details.page.vm.ApiRepository
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object getProductDetails(Long addrId, String originUrl, Continuation<? super ProductDetailsResponse> continuation) {
        ProductDetailsPageKt$ProductDetailsPage$repository$1$getProductDetails$1 productDetailsPageKt$ProductDetailsPage$repository$1$getProductDetails$1;
        Object obj;
        if (continuation instanceof ProductDetailsPageKt$ProductDetailsPage$repository$1$getProductDetails$1) {
            productDetailsPageKt$ProductDetailsPage$repository$1$getProductDetails$1 = (ProductDetailsPageKt$ProductDetailsPage$repository$1$getProductDetails$1) continuation;
            if ((productDetailsPageKt$ProductDetailsPage$repository$1$getProductDetails$1.label & Integer.MIN_VALUE) != 0) {
                productDetailsPageKt$ProductDetailsPage$repository$1$getProductDetails$1.label -= Integer.MIN_VALUE;
                Object $result = productDetailsPageKt$ProductDetailsPage$repository$1$getProductDetails$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (productDetailsPageKt$ProductDetailsPage$repository$1$getProductDetails$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        Function2 requestFunction = new ProductDetailsPageKt$ProductDetailsPage$repository$1$getProductDetails$requestFunction$1(ProductApiService.INSTANCE);
                        ProductApiService.ProductDetailRequest.AppQuery appQuery = new ProductApiService.ProductDetailRequest.AppQuery((String) null, (Boolean) null, KAppInfo.INSTANCE.getMobiApp(), Boxing.boxInt(KAppInfo.INSTANCE.getVersionCode()), NetworkUtilsKt.getNetworkType(), (String) null, 35, (DefaultConstructorMarker) null);
                        Long userId = UserInfoKt.getUserId();
                        String buvid = KDevice.INSTANCE.getBuvid();
                        String str = this.$itemsId;
                        ProductApiService.ProductDetailRequest productDetailRequest = new ProductApiService.ProductDetailRequest(appQuery, buvid, (Integer) null, (Boolean) null, str != null ? Boxing.boxLong(Long.parseLong(str)) : null, (Integer) null, (Boolean) null, userId, (Long) null, (String) null, (Integer) null, (String) null, this.$msource, this.$track_id, this.$from, this.$is_ad, this.$fromSpmId, addrId, originUrl, DateFormatKt.getCurrentTimeZoneString(), Boxing.boxInt(ThemesKt.isCurrentThemeLightNonComposable() ? 1 : 2), 3948, (DefaultConstructorMarker) null);
                        productDetailsPageKt$ProductDetailsPage$repository$1$getProductDetails$1.L$0 = SpillingKt.nullOutSpilledVariable(addrId);
                        productDetailsPageKt$ProductDetailsPage$repository$1$getProductDetails$1.L$1 = SpillingKt.nullOutSpilledVariable(originUrl);
                        productDetailsPageKt$ProductDetailsPage$repository$1$getProductDetails$1.L$2 = SpillingKt.nullOutSpilledVariable(requestFunction);
                        productDetailsPageKt$ProductDetailsPage$repository$1$getProductDetails$1.label = 1;
                        Object invoke = requestFunction.invoke(productDetailRequest, productDetailsPageKt$ProductDetailsPage$repository$1$getProductDetails$1);
                        if (invoke != coroutine_suspended) {
                            obj = invoke;
                            break;
                        } else {
                            return coroutine_suspended;
                        }
                    case 1:
                        Function2 function2 = (Function2) productDetailsPageKt$ProductDetailsPage$repository$1$getProductDetails$1.L$2;
                        String str2 = (String) productDetailsPageKt$ProductDetailsPage$repository$1$getProductDetails$1.L$1;
                        Long l = (Long) productDetailsPageKt$ProductDetailsPage$repository$1$getProductDetails$1.L$0;
                        ResultKt.throwOnFailure($result);
                        obj = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ProductDetailsResponse response = (ProductDetailsResponse) obj;
                return response;
            }
        }
        productDetailsPageKt$ProductDetailsPage$repository$1$getProductDetails$1 = new ProductDetailsPageKt$ProductDetailsPage$repository$1$getProductDetails$1(this, continuation);
        Object $result2 = productDetailsPageKt$ProductDetailsPage$repository$1$getProductDetails$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (productDetailsPageKt$ProductDetailsPage$repository$1$getProductDetails$1.label) {
        }
        ProductDetailsResponse response2 = (ProductDetailsResponse) obj;
        return response2;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0039  */
    @Override // kntr.app.mall.product.details.page.vm.ApiRepository
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object getComments(Continuation<? super CommentInfoApiService.CommentInfoResponse> continuation) {
        ProductDetailsPageKt$ProductDetailsPage$repository$1$getComments$1 productDetailsPageKt$ProductDetailsPage$repository$1$getComments$1;
        Object mallKntrGetCommentInfo$product_details_page_debug;
        if (continuation instanceof ProductDetailsPageKt$ProductDetailsPage$repository$1$getComments$1) {
            productDetailsPageKt$ProductDetailsPage$repository$1$getComments$1 = (ProductDetailsPageKt$ProductDetailsPage$repository$1$getComments$1) continuation;
            if ((productDetailsPageKt$ProductDetailsPage$repository$1$getComments$1.label & Integer.MIN_VALUE) != 0) {
                productDetailsPageKt$ProductDetailsPage$repository$1$getComments$1.label -= Integer.MIN_VALUE;
                Object $result = productDetailsPageKt$ProductDetailsPage$repository$1$getComments$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (productDetailsPageKt$ProductDetailsPage$repository$1$getComments$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        String str = this.$itemsId;
                        CommentInfoApiService.CommentInfoRequest requestParams = new CommentInfoApiService.CommentInfoRequest(UserInfoKt.getUserId(), (Integer) null, (List) null, (List) null, (byte) 0, 0, 0, (String) null, (String) null, 0, (Long) null, str != null ? Long.parseLong(str) : 0L, 0, (Long) null, (Long) null, (Long) null, 63486, (DefaultConstructorMarker) null);
                        CommentInfoApiService commentInfoApiService = CommentInfoApiService.INSTANCE;
                        productDetailsPageKt$ProductDetailsPage$repository$1$getComments$1.L$0 = SpillingKt.nullOutSpilledVariable(requestParams);
                        productDetailsPageKt$ProductDetailsPage$repository$1$getComments$1.label = 1;
                        mallKntrGetCommentInfo$product_details_page_debug = commentInfoApiService.mallKntrGetCommentInfo$product_details_page_debug(requestParams, productDetailsPageKt$ProductDetailsPage$repository$1$getComments$1);
                        if (mallKntrGetCommentInfo$product_details_page_debug != coroutine_suspended) {
                            break;
                        } else {
                            return coroutine_suspended;
                        }
                    case 1:
                        CommentInfoApiService.CommentInfoRequest commentInfoRequest = (CommentInfoApiService.CommentInfoRequest) productDetailsPageKt$ProductDetailsPage$repository$1$getComments$1.L$0;
                        ResultKt.throwOnFailure($result);
                        mallKntrGetCommentInfo$product_details_page_debug = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                CommentInfoApiService.CommentInfoResponse response = (CommentInfoApiService.CommentInfoResponse) mallKntrGetCommentInfo$product_details_page_debug;
                return response;
            }
        }
        productDetailsPageKt$ProductDetailsPage$repository$1$getComments$1 = new ProductDetailsPageKt$ProductDetailsPage$repository$1$getComments$1(this, continuation);
        Object $result2 = productDetailsPageKt$ProductDetailsPage$repository$1$getComments$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (productDetailsPageKt$ProductDetailsPage$repository$1$getComments$1.label) {
        }
        CommentInfoApiService.CommentInfoResponse response2 = (CommentInfoApiService.CommentInfoResponse) mallKntrGetCommentInfo$product_details_page_debug;
        return response2;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0039  */
    @Override // kntr.app.mall.product.details.page.vm.ApiRepository
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object getCouponList(Continuation<? super CouponListResponse> continuation) {
        ProductDetailsPageKt$ProductDetailsPage$repository$1$getCouponList$1 productDetailsPageKt$ProductDetailsPage$repository$1$getCouponList$1;
        Object invoke;
        if (continuation instanceof ProductDetailsPageKt$ProductDetailsPage$repository$1$getCouponList$1) {
            productDetailsPageKt$ProductDetailsPage$repository$1$getCouponList$1 = (ProductDetailsPageKt$ProductDetailsPage$repository$1$getCouponList$1) continuation;
            if ((productDetailsPageKt$ProductDetailsPage$repository$1$getCouponList$1.label & Integer.MIN_VALUE) != 0) {
                productDetailsPageKt$ProductDetailsPage$repository$1$getCouponList$1.label -= Integer.MIN_VALUE;
                Object $result = productDetailsPageKt$ProductDetailsPage$repository$1$getCouponList$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (productDetailsPageKt$ProductDetailsPage$repository$1$getCouponList$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        Long userId = UserInfoKt.getUserId();
                        String mid = userId != null ? String.valueOf(userId.longValue()) : null;
                        Function5 requestFunction = new ProductDetailsPageKt$ProductDetailsPage$repository$1$getCouponList$requestFunction$1(CouponListApiService.INSTANCE);
                        List emptyList = CollectionsKt.emptyList();
                        productDetailsPageKt$ProductDetailsPage$repository$1$getCouponList$1.L$0 = SpillingKt.nullOutSpilledVariable(mid);
                        productDetailsPageKt$ProductDetailsPage$repository$1$getCouponList$1.L$1 = SpillingKt.nullOutSpilledVariable(requestFunction);
                        productDetailsPageKt$ProductDetailsPage$repository$1$getCouponList$1.label = 1;
                        invoke = requestFunction.invoke(mid, (Object) null, emptyList, "item_detail_page", productDetailsPageKt$ProductDetailsPage$repository$1$getCouponList$1);
                        if (invoke == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        Function5 function5 = (Function5) productDetailsPageKt$ProductDetailsPage$repository$1$getCouponList$1.L$1;
                        String str = (String) productDetailsPageKt$ProductDetailsPage$repository$1$getCouponList$1.L$0;
                        ResultKt.throwOnFailure($result);
                        invoke = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                CouponListResponse response = (CouponListResponse) invoke;
                return response;
            }
        }
        productDetailsPageKt$ProductDetailsPage$repository$1$getCouponList$1 = new ProductDetailsPageKt$ProductDetailsPage$repository$1$getCouponList$1(this, continuation);
        Object $result2 = productDetailsPageKt$ProductDetailsPage$repository$1$getCouponList$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (productDetailsPageKt$ProductDetailsPage$repository$1$getCouponList$1.label) {
        }
        CouponListResponse response2 = (CouponListResponse) invoke;
        return response2;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0033  */
    @Override // kntr.app.mall.product.details.page.vm.ApiRepository
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object getShopDetails(long merchantId, Continuation<? super ProductShopApiService.ProductShopDetailsResponse> continuation) {
        Continuation<? super ProductShopApiService.ProductShopDetailsResponse> productDetailsPageKt$ProductDetailsPage$repository$1$getShopDetails$1;
        Object productShopDetails$product_details_page_debug;
        if (continuation instanceof ProductDetailsPageKt$ProductDetailsPage$repository$1$getShopDetails$1) {
            productDetailsPageKt$ProductDetailsPage$repository$1$getShopDetails$1 = (ProductDetailsPageKt$ProductDetailsPage$repository$1$getShopDetails$1) continuation;
            if ((productDetailsPageKt$ProductDetailsPage$repository$1$getShopDetails$1.label & Integer.MIN_VALUE) != 0) {
                productDetailsPageKt$ProductDetailsPage$repository$1$getShopDetails$1.label -= Integer.MIN_VALUE;
                Object $result = productDetailsPageKt$ProductDetailsPage$repository$1$getShopDetails$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (productDetailsPageKt$ProductDetailsPage$repository$1$getShopDetails$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        ProductShopApiService productShopApiService = ProductShopApiService.INSTANCE;
                        String str = this.$msource;
                        String str2 = this.$track_id;
                        productDetailsPageKt$ProductDetailsPage$repository$1$getShopDetails$1.J$0 = merchantId;
                        productDetailsPageKt$ProductDetailsPage$repository$1$getShopDetails$1.label = 1;
                        productShopDetails$product_details_page_debug = productShopApiService.getProductShopDetails$product_details_page_debug(merchantId, str, str2, productDetailsPageKt$ProductDetailsPage$repository$1$getShopDetails$1);
                        if (productShopDetails$product_details_page_debug == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        long merchantId2 = productDetailsPageKt$ProductDetailsPage$repository$1$getShopDetails$1.J$0;
                        ResultKt.throwOnFailure($result);
                        productShopDetails$product_details_page_debug = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ProductShopApiService.ProductShopDetailsResponse response = (ProductShopApiService.ProductShopDetailsResponse) productShopDetails$product_details_page_debug;
                return response;
            }
        }
        productDetailsPageKt$ProductDetailsPage$repository$1$getShopDetails$1 = new ProductDetailsPageKt$ProductDetailsPage$repository$1$getShopDetails$1(this, continuation);
        Object $result2 = productDetailsPageKt$ProductDetailsPage$repository$1$getShopDetails$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (productDetailsPageKt$ProductDetailsPage$repository$1$getShopDetails$1.label) {
        }
        ProductShopApiService.ProductShopDetailsResponse response2 = (ProductShopApiService.ProductShopDetailsResponse) productShopDetails$product_details_page_debug;
        return response2;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0031  */
    @Override // kntr.app.mall.product.details.page.vm.ApiRepository
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object getLiveInfo(Continuation<? super LiveInfoApiService.LiveInfoResponse> continuation) {
        ProductDetailsPageKt$ProductDetailsPage$repository$1$getLiveInfo$1 productDetailsPageKt$ProductDetailsPage$repository$1$getLiveInfo$1;
        Object mallKntrGetLiveInfo$product_details_page_debug$default;
        if (continuation instanceof ProductDetailsPageKt$ProductDetailsPage$repository$1$getLiveInfo$1) {
            productDetailsPageKt$ProductDetailsPage$repository$1$getLiveInfo$1 = (ProductDetailsPageKt$ProductDetailsPage$repository$1$getLiveInfo$1) continuation;
            if ((productDetailsPageKt$ProductDetailsPage$repository$1$getLiveInfo$1.label & Integer.MIN_VALUE) != 0) {
                productDetailsPageKt$ProductDetailsPage$repository$1$getLiveInfo$1.label -= Integer.MIN_VALUE;
                Object $result = productDetailsPageKt$ProductDetailsPage$repository$1$getLiveInfo$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (productDetailsPageKt$ProductDetailsPage$repository$1$getLiveInfo$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        LiveInfoApiService liveInfoApiService = LiveInfoApiService.INSTANCE;
                        String str = this.$itemsId;
                        int parseInt = str != null ? Integer.parseInt(str) : 0;
                        productDetailsPageKt$ProductDetailsPage$repository$1$getLiveInfo$1.label = 1;
                        mallKntrGetLiveInfo$product_details_page_debug$default = LiveInfoApiService.mallKntrGetLiveInfo$product_details_page_debug$default(liveInfoApiService, parseInt, null, null, productDetailsPageKt$ProductDetailsPage$repository$1$getLiveInfo$1, 6, null);
                        if (mallKntrGetLiveInfo$product_details_page_debug$default == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        ResultKt.throwOnFailure($result);
                        mallKntrGetLiveInfo$product_details_page_debug$default = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                LiveInfoApiService.LiveInfoResponse response = (LiveInfoApiService.LiveInfoResponse) mallKntrGetLiveInfo$product_details_page_debug$default;
                return response;
            }
        }
        productDetailsPageKt$ProductDetailsPage$repository$1$getLiveInfo$1 = new ProductDetailsPageKt$ProductDetailsPage$repository$1$getLiveInfo$1(this, continuation);
        Object $result2 = productDetailsPageKt$ProductDetailsPage$repository$1$getLiveInfo$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (productDetailsPageKt$ProductDetailsPage$repository$1$getLiveInfo$1.label) {
        }
        LiveInfoApiService.LiveInfoResponse response2 = (LiveInfoApiService.LiveInfoResponse) mallKntrGetLiveInfo$product_details_page_debug$default;
        return response2;
    }

    @Override // kntr.app.mall.product.details.page.vm.ApiRepository
    public Object reportHistory(Continuation<? super Unit> continuation) {
        String csrf = (String) this.$valueBridge.invoke("cookie_csrf", MapsKt.emptyMap());
        Function3<String, Map<String, ? extends Object>, Function1<? super Map<String, ? extends Object>, Unit>, Unit> function3 = this.$bridgeCall;
        Pair[] pairArr = new Pair[5];
        String str = this.$itemsId;
        if (str == null) {
            str = "";
        }
        pairArr[0] = TuplesKt.to("aid", str);
        pairArr[1] = TuplesKt.to("csrf", csrf);
        pairArr[2] = TuplesKt.to("mid", String.valueOf(UserInfoKt.getUserId()));
        pairArr[3] = TuplesKt.to("buvid", KDevice.INSTANCE.getBuvid());
        pairArr[4] = TuplesKt.to("type", "14");
        function3.invoke("historyReport", MapsKt.mapOf(pairArr), new Function1() { // from class: kntr.app.mall.product.details.page.ProductDetailsPageKt$ProductDetailsPage$repository$1$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit reportHistory$lambda$0;
                reportHistory$lambda$0 = ProductDetailsPageKt$ProductDetailsPage$repository$1.reportHistory$lambda$0((Map) obj);
                return reportHistory$lambda$0;
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit reportHistory$lambda$0(Map map) {
        Intrinsics.checkNotNullParameter(map, "<unused var>");
        return Unit.INSTANCE;
    }
}