package kntr.app.mall.product.details.page.api;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.net.comm.flowcontrol.internal.backoff.BackoffConfigKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SearchTextApiService.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.mall.product.details.page.api.SearchTextApiService", f = "SearchTextApiService.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1}, l = {119, BackoffConfigKt.MAX_DELAY_SECONDS}, m = "getSearchText$product_details_page_debug", n = {"buvid", "request", "$this$post$iv", "urlString$iv", "$this$post$iv$iv", "$this$post$iv$iv$iv", "builder$iv$iv$iv", "$this$request$iv$iv$iv$iv", "mid", "$i$f$post", "$i$f$post", "$i$f$post", "$i$f$request", "buvid", "request", "response", "$this$body$iv", "mid", "$i$f$body"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "J$0", "I$0", "I$1", "I$2", "I$3", "L$0", "L$1", "L$2", "L$3", "J$0", "I$0"}, v = 1)
public final class SearchTextApiService$getSearchText$1 extends ContinuationImpl {
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
    final /* synthetic */ SearchTextApiService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchTextApiService$getSearchText$1(SearchTextApiService searchTextApiService, Continuation<? super SearchTextApiService$getSearchText$1> continuation) {
        super(continuation);
        this.this$0 = searchTextApiService;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getSearchText$product_details_page_debug(null, 0L, (Continuation) this);
    }
}