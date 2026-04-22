package kntr.app.mall.product.details.page.api;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IPFeedRecommendApiService.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.mall.product.details.page.api.IPFeedRecommendApiService", f = "IPFeedRecommendApiService.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {454}, m = "kntrGetIPFeedRecommend$product_details_page_debug", n = {"ipRightId", "itemIds", "$this$iv", "url$iv", "method$iv", "params$iv", "$i$f$kntrRequest$product_details_page_debug"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0"}, v = 1)
public final class IPFeedRecommendApiService$kntrGetIPFeedRecommend$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ IPFeedRecommendApiService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IPFeedRecommendApiService$kntrGetIPFeedRecommend$1(IPFeedRecommendApiService iPFeedRecommendApiService, Continuation<? super IPFeedRecommendApiService$kntrGetIPFeedRecommend$1> continuation) {
        super(continuation);
        this.this$0 = iPFeedRecommendApiService;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.kntrGetIPFeedRecommend$product_details_page_debug(null, null, (Continuation) this);
    }
}