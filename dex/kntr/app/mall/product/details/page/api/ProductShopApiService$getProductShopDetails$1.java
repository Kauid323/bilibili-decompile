package kntr.app.mall.product.details.page.api;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProductShopApiService.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.mall.product.details.page.api.ProductShopApiService", f = "ProductShopApiService.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1}, l = {373, 374}, m = "getProductShopDetails$product_details_page_debug", n = {"mSource", "trackId", "$this$post$iv", "urlString$iv", "$this$post$iv$iv", "$this$post$iv$iv$iv", "builder$iv$iv$iv", "$this$request$iv$iv$iv$iv", "merchantId", "$i$f$post", "$i$f$post", "$i$f$post", "$i$f$request", "mSource", "trackId", "response", "$this$body$iv", "merchantId", "$i$f$body"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "J$0", "I$0", "I$1", "I$2", "I$3", "L$0", "L$1", "L$2", "L$3", "J$0", "I$0"}, v = 1)
public final class ProductShopApiService$getProductShopDetails$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    int I$3;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ProductShopApiService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProductShopApiService$getProductShopDetails$1(ProductShopApiService productShopApiService, Continuation<? super ProductShopApiService$getProductShopDetails$1> continuation) {
        super(continuation);
        this.this$0 = productShopApiService;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getProductShopDetails$product_details_page_debug(0L, null, null, (Continuation) this);
    }
}