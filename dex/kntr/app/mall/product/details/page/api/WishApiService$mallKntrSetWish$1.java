package kntr.app.mall.product.details.page.api;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.upper.trace.config.AppKey;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: WishApiService.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.mall.product.details.page.api.WishApiService", f = "WishApiService.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, l = {154}, m = "mallKntrSetWish$product_details_page_debug", n = {"shopId", "subjectType", AppKey.VERSION, "track_id", "from", "msource", "is_ad", "$this$iv", "url$iv", "method$iv", "params$iv", "itemsId", "wishType", "$i$f$kntrRequest$product_details_page_debug"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "J$0", "B$0", "I$0"}, v = 1)
public final class WishApiService$mallKntrSetWish$1 extends ContinuationImpl {
    byte B$0;
    int I$0;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$10;
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
    final /* synthetic */ WishApiService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WishApiService$mallKntrSetWish$1(WishApiService wishApiService, Continuation<? super WishApiService$mallKntrSetWish$1> continuation) {
        super(continuation);
        this.this$0 = wishApiService;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.mallKntrSetWish$product_details_page_debug(0L, null, null, null, (byte) 0, null, null, null, null, (Continuation) this);
    }
}