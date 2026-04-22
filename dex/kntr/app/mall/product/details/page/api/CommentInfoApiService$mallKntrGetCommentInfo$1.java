package kntr.app.mall.product.details.page.api;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CommentInfoApiService.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.mall.product.details.page.api.CommentInfoApiService", f = "CommentInfoApiService.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {407}, m = "mallKntrGetCommentInfo$product_details_page_debug", n = {"request", "$this$iv", "url$iv", "method$iv", "params$iv", "startTimestamp", "$i$f$kntrRequest$product_details_page_debug"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "J$0", "I$0"}, v = 1)
public final class CommentInfoApiService$mallKntrGetCommentInfo$1 extends ContinuationImpl {
    int I$0;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CommentInfoApiService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommentInfoApiService$mallKntrGetCommentInfo$1(CommentInfoApiService commentInfoApiService, Continuation<? super CommentInfoApiService$mallKntrGetCommentInfo$1> continuation) {
        super(continuation);
        this.this$0 = commentInfoApiService;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.mallKntrGetCommentInfo$product_details_page_debug(null, (Continuation) this);
    }
}