package kntr.app.mall.product.details.page.api;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LiveInfoApiService.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.mall.product.details.page.api.LiveInfoApiService", f = "LiveInfoApiService.kt", i = {0, 0, 0, 0, 0, 0, 0, 0}, l = {147}, m = "mallKntrGetLiveInfo$product_details_page_debug", n = {"itemsVersion", "shopId", "$this$iv", "url$iv", "method$iv", "params$iv", "itemsId", "$i$f$kntrRequest$product_details_page_debug"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "I$1"}, v = 1)
public final class LiveInfoApiService$mallKntrGetLiveInfo$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LiveInfoApiService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveInfoApiService$mallKntrGetLiveInfo$1(LiveInfoApiService liveInfoApiService, Continuation<? super LiveInfoApiService$mallKntrGetLiveInfo$1> continuation) {
        super(continuation);
        this.this$0 = liveInfoApiService;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.mallKntrGetLiveInfo$product_details_page_debug(0, null, null, (Continuation) this);
    }
}