package kntr.app.mall.product.details.page.api;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CouponListApiService.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.mall.product.details.page.api.CouponListApiService", f = "CouponListApiService.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1}, l = {246, 247}, m = "getCouponList$product_details_page_debug", n = {"mid", "personalStatus", "sourceAuthorityIdList", "sourceId", "$this$post$iv", "urlString$iv", "$this$post$iv$iv", "$this$post$iv$iv$iv", "builder$iv$iv$iv", "$this$request$iv$iv$iv$iv", "$i$f$post", "$i$f$post", "$i$f$post", "$i$f$request", "mid", "personalStatus", "sourceAuthorityIdList", "sourceId", "response", "$this$body$iv", "$i$f$body"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "I$0", "I$1", "I$2", "I$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0"}, v = 1)
public final class CouponListApiService$getCouponList$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    int I$3;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    Object L$9;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CouponListApiService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CouponListApiService$getCouponList$1(CouponListApiService couponListApiService, Continuation<? super CouponListApiService$getCouponList$1> continuation) {
        super(continuation);
        this.this$0 = couponListApiService;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getCouponList$product_details_page_debug(null, null, null, null, (Continuation) this);
    }
}