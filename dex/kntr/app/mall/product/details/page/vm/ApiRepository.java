package kntr.app.mall.product.details.page.vm;

import kntr.app.mall.product.details.page.api.CommentInfoApiService;
import kntr.app.mall.product.details.page.api.CouponListResponse;
import kntr.app.mall.product.details.page.api.LiveInfoApiService;
import kntr.app.mall.product.details.page.api.ProductShopApiService;
import kntr.app.mall.product.details.page.api.model.ProductDetailsResponse;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* compiled from: ApiRepository.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H¦@¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\nH¦@¢\u0006\u0002\u0010\u000bJ\u000e\u0010\f\u001a\u00020\rH¦@¢\u0006\u0002\u0010\u000bJ\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u0011J\u000e\u0010\u0012\u001a\u00020\u0013H¦@¢\u0006\u0002\u0010\u000bJ\u000e\u0010\u0014\u001a\u00020\u0015H¦@¢\u0006\u0002\u0010\u000b¨\u0006\u0016À\u0006\u0003"}, d2 = {"Lkntr/app/mall/product/details/page/vm/ApiRepository;", "", "getProductDetails", "Lkntr/app/mall/product/details/page/api/model/ProductDetailsResponse;", "addrId", "", "originUrl", "", "(Ljava/lang/Long;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getComments", "Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCouponList", "Lkntr/app/mall/product/details/page/api/CouponListResponse;", "getShopDetails", "Lkntr/app/mall/product/details/page/api/ProductShopApiService$ProductShopDetailsResponse;", "merchantId", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLiveInfo", "Lkntr/app/mall/product/details/page/api/LiveInfoApiService$LiveInfoResponse;", "reportHistory", "", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface ApiRepository {
    Object getComments(Continuation<? super CommentInfoApiService.CommentInfoResponse> continuation);

    Object getCouponList(Continuation<? super CouponListResponse> continuation);

    Object getLiveInfo(Continuation<? super LiveInfoApiService.LiveInfoResponse> continuation);

    Object getProductDetails(Long l, String str, Continuation<? super ProductDetailsResponse> continuation);

    Object getShopDetails(long j, Continuation<? super ProductShopApiService.ProductShopDetailsResponse> continuation);

    Object reportHistory(Continuation<? super Unit> continuation);

    /* compiled from: ApiRepository.kt */
    /* renamed from: kntr.app.mall.product.details.page.vm.ApiRepository$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public final /* synthetic */ class CC {
        public static /* synthetic */ Object getProductDetails$default(ApiRepository apiRepository, Long l, String str, Continuation continuation, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    l = null;
                }
                return apiRepository.getProductDetails(l, str, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getProductDetails");
        }
    }

    /* compiled from: ApiRepository.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class DefaultImpls {
    }
}