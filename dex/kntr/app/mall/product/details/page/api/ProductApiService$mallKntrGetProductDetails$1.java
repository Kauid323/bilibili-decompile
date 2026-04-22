package kntr.app.mall.product.details.page.api;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProductApiService.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.mall.product.details.page.api.ProductApiService", f = "ProductApiService.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {144}, m = "mallKntrGetProductDetails$product_details_page_debug", n = {"params", "$this$iv", "url$iv", "method$iv", "params$iv", "startTimestamp", "$i$f$kntrRequest$product_details_page_debug"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "J$0", "I$0"}, v = 1)
public final class ProductApiService$mallKntrGetProductDetails$1 extends ContinuationImpl {
    int I$0;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ProductApiService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProductApiService$mallKntrGetProductDetails$1(ProductApiService productApiService, Continuation<? super ProductApiService$mallKntrGetProductDetails$1> continuation) {
        super(continuation);
        this.this$0 = productApiService;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.mallKntrGetProductDetails$product_details_page_debug(null, (Continuation) this);
    }
}