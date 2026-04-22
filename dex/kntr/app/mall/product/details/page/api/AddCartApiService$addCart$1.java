package kntr.app.mall.product.details.page.api;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AddCartApiService.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.mall.product.details.page.api.AddCartApiService", f = "AddCartApiService.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, l = {57}, m = "addCart$product_details_page_debug", n = {"trackId", "this_$iv", "url$iv", "method$iv", "params$iv", "itemsId", "shopId", "skuId", "skuNum", "saleType", "$i$f$kntrRequest$product_details_page_debug"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "J$0", "I$0", "J$1", "I$1", "I$2", "I$3"}, v = 1)
public final class AddCartApiService$addCart$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    int I$3;
    long J$0;
    long J$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AddCartApiService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AddCartApiService$addCart$1(AddCartApiService addCartApiService, Continuation<? super AddCartApiService$addCart$1> continuation) {
        super(continuation);
        this.this$0 = addCartApiService;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.addCart$product_details_page_debug(0L, 0, 0L, 0, 0, null, (Continuation) this);
    }
}