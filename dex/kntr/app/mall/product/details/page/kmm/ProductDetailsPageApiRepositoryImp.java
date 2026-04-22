package kntr.app.mall.product.details.page.kmm;

import java.util.List;
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
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ProductDetailsPageApiRepositoryImp.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nJ\"\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003H\u0096@¢\u0006\u0002\u0010\u0010J\u000e\u0010\u0011\u001a\u00020\u0012H\u0096@¢\u0006\u0002\u0010\u0013J\u000e\u0010\u0014\u001a\u00020\u0015H\u0096@¢\u0006\u0002\u0010\u0013J\u0016\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000eH\u0096@¢\u0006\u0002\u0010\u0019J\u000e\u0010\u001a\u001a\u00020\u001bH\u0096@¢\u0006\u0002\u0010\u0013J\u000e\u0010\u001c\u001a\u00020\u001dH\u0096@¢\u0006\u0002\u0010\u0013R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lkntr/app/mall/product/details/page/kmm/ProductDetailsPageApiRepositoryImp;", "Lkntr/app/mall/product/details/page/vm/ApiRepository;", "itemsId", "", "msource", "track_id", "from", "is_ad", "fromSpmId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getProductDetails", "Lkntr/app/mall/product/details/page/api/model/ProductDetailsResponse;", "addrId", "", "originUrl", "(Ljava/lang/Long;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getComments", "Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCouponList", "Lkntr/app/mall/product/details/page/api/CouponListResponse;", "getShopDetails", "Lkntr/app/mall/product/details/page/api/ProductShopApiService$ProductShopDetailsResponse;", "merchantId", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLiveInfo", "Lkntr/app/mall/product/details/page/api/LiveInfoApiService$LiveInfoResponse;", "reportHistory", "", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ProductDetailsPageApiRepositoryImp implements ApiRepository {
    public static final int $stable = 0;
    private final String from;
    private final String fromSpmId;
    private final String is_ad;
    private final String itemsId;
    private final String msource;
    private final String track_id;

    public ProductDetailsPageApiRepositoryImp() {
        this(null, null, null, null, null, null, 63, null);
    }

    public ProductDetailsPageApiRepositoryImp(String itemsId, String msource, String track_id, String from, String is_ad, String fromSpmId) {
        this.itemsId = itemsId;
        this.msource = msource;
        this.track_id = track_id;
        this.from = from;
        this.is_ad = is_ad;
        this.fromSpmId = fromSpmId;
    }

    public /* synthetic */ ProductDetailsPageApiRepositoryImp(String str, String str2, String str3, String str4, String str5, String str6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0042  */
    @Override // kntr.app.mall.product.details.page.vm.ApiRepository
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object getProductDetails(Long addrId, String originUrl, Continuation<? super ProductDetailsResponse> continuation) {
        ProductDetailsPageApiRepositoryImp$getProductDetails$1 productDetailsPageApiRepositoryImp$getProductDetails$1;
        Object obj;
        if (continuation instanceof ProductDetailsPageApiRepositoryImp$getProductDetails$1) {
            productDetailsPageApiRepositoryImp$getProductDetails$1 = (ProductDetailsPageApiRepositoryImp$getProductDetails$1) continuation;
            if ((productDetailsPageApiRepositoryImp$getProductDetails$1.label & Integer.MIN_VALUE) != 0) {
                productDetailsPageApiRepositoryImp$getProductDetails$1.label -= Integer.MIN_VALUE;
                Object $result = productDetailsPageApiRepositoryImp$getProductDetails$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (productDetailsPageApiRepositoryImp$getProductDetails$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        Function2 requestFunction = new ProductDetailsPageApiRepositoryImp$getProductDetails$requestFunction$1(ProductApiService.INSTANCE);
                        ProductApiService.ProductDetailRequest.AppQuery appQuery = new ProductApiService.ProductDetailRequest.AppQuery((String) null, (Boolean) null, KAppInfo.INSTANCE.getMobiApp(), Boxing.boxInt(KAppInfo.INSTANCE.getVersionCode()), NetworkUtilsKt.getNetworkType(), (String) null, 35, (DefaultConstructorMarker) null);
                        Long userId = UserInfoKt.getUserId();
                        String buvid = KDevice.INSTANCE.getBuvid();
                        String str = this.itemsId;
                        ProductApiService.ProductDetailRequest productDetailRequest = new ProductApiService.ProductDetailRequest(appQuery, buvid, (Integer) null, (Boolean) null, str != null ? Boxing.boxLong(Long.parseLong(str)) : null, (Integer) null, (Boolean) null, userId, (Long) null, (String) null, (Integer) null, (String) null, this.msource, this.track_id, this.from, this.is_ad, this.fromSpmId, addrId, originUrl, DateFormatKt.getCurrentTimeZoneString(), Boxing.boxInt(ThemesKt.isCurrentThemeLightNonComposable() ? 1 : 2), 3948, (DefaultConstructorMarker) null);
                        productDetailsPageApiRepositoryImp$getProductDetails$1.L$0 = SpillingKt.nullOutSpilledVariable(addrId);
                        productDetailsPageApiRepositoryImp$getProductDetails$1.L$1 = SpillingKt.nullOutSpilledVariable(originUrl);
                        productDetailsPageApiRepositoryImp$getProductDetails$1.L$2 = SpillingKt.nullOutSpilledVariable(requestFunction);
                        productDetailsPageApiRepositoryImp$getProductDetails$1.label = 1;
                        Object invoke = requestFunction.invoke(productDetailRequest, productDetailsPageApiRepositoryImp$getProductDetails$1);
                        if (invoke != coroutine_suspended) {
                            obj = invoke;
                            break;
                        } else {
                            return coroutine_suspended;
                        }
                    case 1:
                        Function2 function2 = (Function2) productDetailsPageApiRepositoryImp$getProductDetails$1.L$2;
                        String str2 = (String) productDetailsPageApiRepositoryImp$getProductDetails$1.L$1;
                        Long l = (Long) productDetailsPageApiRepositoryImp$getProductDetails$1.L$0;
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
        productDetailsPageApiRepositoryImp$getProductDetails$1 = new ProductDetailsPageApiRepositoryImp$getProductDetails$1(this, continuation);
        Object $result2 = productDetailsPageApiRepositoryImp$getProductDetails$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (productDetailsPageApiRepositoryImp$getProductDetails$1.label) {
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
        ProductDetailsPageApiRepositoryImp$getComments$1 productDetailsPageApiRepositoryImp$getComments$1;
        Object mallKntrGetCommentInfo$product_details_page_debug;
        if (continuation instanceof ProductDetailsPageApiRepositoryImp$getComments$1) {
            productDetailsPageApiRepositoryImp$getComments$1 = (ProductDetailsPageApiRepositoryImp$getComments$1) continuation;
            if ((productDetailsPageApiRepositoryImp$getComments$1.label & Integer.MIN_VALUE) != 0) {
                productDetailsPageApiRepositoryImp$getComments$1.label -= Integer.MIN_VALUE;
                Object $result = productDetailsPageApiRepositoryImp$getComments$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (productDetailsPageApiRepositoryImp$getComments$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        String str = this.itemsId;
                        CommentInfoApiService.CommentInfoRequest requestParams = new CommentInfoApiService.CommentInfoRequest(UserInfoKt.getUserId(), (Integer) null, (List) null, (List) null, (byte) 0, 0, 0, (String) null, (String) null, 0, (Long) null, str != null ? Long.parseLong(str) : 0L, 0, (Long) null, (Long) null, (Long) null, 63486, (DefaultConstructorMarker) null);
                        CommentInfoApiService commentInfoApiService = CommentInfoApiService.INSTANCE;
                        productDetailsPageApiRepositoryImp$getComments$1.L$0 = SpillingKt.nullOutSpilledVariable(requestParams);
                        productDetailsPageApiRepositoryImp$getComments$1.label = 1;
                        mallKntrGetCommentInfo$product_details_page_debug = commentInfoApiService.mallKntrGetCommentInfo$product_details_page_debug(requestParams, productDetailsPageApiRepositoryImp$getComments$1);
                        if (mallKntrGetCommentInfo$product_details_page_debug != coroutine_suspended) {
                            break;
                        } else {
                            return coroutine_suspended;
                        }
                    case 1:
                        CommentInfoApiService.CommentInfoRequest commentInfoRequest = (CommentInfoApiService.CommentInfoRequest) productDetailsPageApiRepositoryImp$getComments$1.L$0;
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
        productDetailsPageApiRepositoryImp$getComments$1 = new ProductDetailsPageApiRepositoryImp$getComments$1(this, continuation);
        Object $result2 = productDetailsPageApiRepositoryImp$getComments$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (productDetailsPageApiRepositoryImp$getComments$1.label) {
        }
        CommentInfoApiService.CommentInfoResponse response2 = (CommentInfoApiService.CommentInfoResponse) mallKntrGetCommentInfo$product_details_page_debug;
        return response2;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0036  */
    @Override // kntr.app.mall.product.details.page.vm.ApiRepository
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object getCouponList(Continuation<? super CouponListResponse> continuation) {
        Continuation<? super CouponListResponse> productDetailsPageApiRepositoryImp$getCouponList$1;
        Object mallKntrGetCouponList$product_details_page_debug;
        if (continuation instanceof ProductDetailsPageApiRepositoryImp$getCouponList$1) {
            productDetailsPageApiRepositoryImp$getCouponList$1 = (ProductDetailsPageApiRepositoryImp$getCouponList$1) continuation;
            if ((productDetailsPageApiRepositoryImp$getCouponList$1.label & Integer.MIN_VALUE) != 0) {
                productDetailsPageApiRepositoryImp$getCouponList$1.label -= Integer.MIN_VALUE;
                Object $result = productDetailsPageApiRepositoryImp$getCouponList$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (productDetailsPageApiRepositoryImp$getCouponList$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        Long userId = UserInfoKt.getUserId();
                        String mid = userId != null ? String.valueOf(userId.longValue()) : null;
                        CouponListApiService couponListApiService = CouponListApiService.INSTANCE;
                        List<String> emptyList = CollectionsKt.emptyList();
                        productDetailsPageApiRepositoryImp$getCouponList$1.L$0 = SpillingKt.nullOutSpilledVariable(mid);
                        productDetailsPageApiRepositoryImp$getCouponList$1.label = 1;
                        mallKntrGetCouponList$product_details_page_debug = couponListApiService.mallKntrGetCouponList$product_details_page_debug(mid, null, emptyList, "item_detail_page", productDetailsPageApiRepositoryImp$getCouponList$1);
                        if (mallKntrGetCouponList$product_details_page_debug == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        String str = (String) productDetailsPageApiRepositoryImp$getCouponList$1.L$0;
                        ResultKt.throwOnFailure($result);
                        mallKntrGetCouponList$product_details_page_debug = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                CouponListResponse response = (CouponListResponse) mallKntrGetCouponList$product_details_page_debug;
                return response;
            }
        }
        productDetailsPageApiRepositoryImp$getCouponList$1 = new ProductDetailsPageApiRepositoryImp$getCouponList$1(this, continuation);
        Object $result2 = productDetailsPageApiRepositoryImp$getCouponList$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (productDetailsPageApiRepositoryImp$getCouponList$1.label) {
        }
        CouponListResponse response2 = (CouponListResponse) mallKntrGetCouponList$product_details_page_debug;
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
        Continuation<? super ProductShopApiService.ProductShopDetailsResponse> productDetailsPageApiRepositoryImp$getShopDetails$1;
        Object productShopDetails$product_details_page_debug;
        if (continuation instanceof ProductDetailsPageApiRepositoryImp$getShopDetails$1) {
            productDetailsPageApiRepositoryImp$getShopDetails$1 = (ProductDetailsPageApiRepositoryImp$getShopDetails$1) continuation;
            if ((productDetailsPageApiRepositoryImp$getShopDetails$1.label & Integer.MIN_VALUE) != 0) {
                productDetailsPageApiRepositoryImp$getShopDetails$1.label -= Integer.MIN_VALUE;
                Object $result = productDetailsPageApiRepositoryImp$getShopDetails$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (productDetailsPageApiRepositoryImp$getShopDetails$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        ProductShopApiService productShopApiService = ProductShopApiService.INSTANCE;
                        String str = this.msource;
                        String str2 = this.track_id;
                        productDetailsPageApiRepositoryImp$getShopDetails$1.J$0 = merchantId;
                        productDetailsPageApiRepositoryImp$getShopDetails$1.label = 1;
                        productShopDetails$product_details_page_debug = productShopApiService.getProductShopDetails$product_details_page_debug(merchantId, str, str2, productDetailsPageApiRepositoryImp$getShopDetails$1);
                        if (productShopDetails$product_details_page_debug == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        long merchantId2 = productDetailsPageApiRepositoryImp$getShopDetails$1.J$0;
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
        productDetailsPageApiRepositoryImp$getShopDetails$1 = new ProductDetailsPageApiRepositoryImp$getShopDetails$1(this, continuation);
        Object $result2 = productDetailsPageApiRepositoryImp$getShopDetails$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (productDetailsPageApiRepositoryImp$getShopDetails$1.label) {
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
        ProductDetailsPageApiRepositoryImp$getLiveInfo$1 productDetailsPageApiRepositoryImp$getLiveInfo$1;
        Object mallKntrGetLiveInfo$product_details_page_debug$default;
        if (continuation instanceof ProductDetailsPageApiRepositoryImp$getLiveInfo$1) {
            productDetailsPageApiRepositoryImp$getLiveInfo$1 = (ProductDetailsPageApiRepositoryImp$getLiveInfo$1) continuation;
            if ((productDetailsPageApiRepositoryImp$getLiveInfo$1.label & Integer.MIN_VALUE) != 0) {
                productDetailsPageApiRepositoryImp$getLiveInfo$1.label -= Integer.MIN_VALUE;
                Object $result = productDetailsPageApiRepositoryImp$getLiveInfo$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (productDetailsPageApiRepositoryImp$getLiveInfo$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        LiveInfoApiService liveInfoApiService = LiveInfoApiService.INSTANCE;
                        String str = this.itemsId;
                        int parseInt = str != null ? Integer.parseInt(str) : 0;
                        productDetailsPageApiRepositoryImp$getLiveInfo$1.label = 1;
                        mallKntrGetLiveInfo$product_details_page_debug$default = LiveInfoApiService.mallKntrGetLiveInfo$product_details_page_debug$default(liveInfoApiService, parseInt, null, null, productDetailsPageApiRepositoryImp$getLiveInfo$1, 6, null);
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
        productDetailsPageApiRepositoryImp$getLiveInfo$1 = new ProductDetailsPageApiRepositoryImp$getLiveInfo$1(this, continuation);
        Object $result2 = productDetailsPageApiRepositoryImp$getLiveInfo$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (productDetailsPageApiRepositoryImp$getLiveInfo$1.label) {
        }
        LiveInfoApiService.LiveInfoResponse response2 = (LiveInfoApiService.LiveInfoResponse) mallKntrGetLiveInfo$product_details_page_debug$default;
        return response2;
    }

    @Override // kntr.app.mall.product.details.page.vm.ApiRepository
    public Object reportHistory(Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }
}