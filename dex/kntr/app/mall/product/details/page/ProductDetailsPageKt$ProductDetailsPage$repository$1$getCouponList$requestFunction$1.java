package kntr.app.mall.product.details.page;

import java.util.List;
import kntr.app.mall.product.details.page.api.CouponListApiService;
import kntr.app.mall.product.details.page.api.CouponListResponse;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProductDetailsPage.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final /* synthetic */ class ProductDetailsPageKt$ProductDetailsPage$repository$1$getCouponList$requestFunction$1 extends FunctionReferenceImpl implements Function5<String, Byte, List<? extends String>, String, Continuation<? super CouponListResponse>, Object>, SuspendFunction {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ProductDetailsPageKt$ProductDetailsPage$repository$1$getCouponList$requestFunction$1(Object obj) {
        super(5, obj, CouponListApiService.class, "mallKntrGetCouponList", "mallKntrGetCouponList$product_details_page_debug(Ljava/lang/String;Ljava/lang/Byte;Ljava/util/List;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    public final Object invoke(String p0, Byte p1, List<String> list, String p3, Continuation<? super CouponListResponse> continuation) {
        return ((CouponListApiService) this.receiver).mallKntrGetCouponList$product_details_page_debug(p0, p1, list, p3, continuation);
    }
}