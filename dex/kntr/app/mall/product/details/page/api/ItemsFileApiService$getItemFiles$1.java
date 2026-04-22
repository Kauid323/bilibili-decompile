package kntr.app.mall.product.details.page.api;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ItemsFileApiService.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.mall.product.details.page.api.ItemsFileApiService", f = "ItemsFileApiService.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH}, m = "getItemFiles$product_details_page_debug", n = {"itemsId", "$this$iv", "url$iv", "method$iv", "params$iv", "skuId", "$i$f$kntrRequest$product_details_page_debug"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "J$0", "I$0"}, v = 1)
public final class ItemsFileApiService$getItemFiles$1 extends ContinuationImpl {
    int I$0;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ItemsFileApiService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ItemsFileApiService$getItemFiles$1(ItemsFileApiService itemsFileApiService, Continuation<? super ItemsFileApiService$getItemFiles$1> continuation) {
        super(continuation);
        this.this$0 = itemsFileApiService;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getItemFiles$product_details_page_debug(null, 0L, (Continuation) this);
    }
}