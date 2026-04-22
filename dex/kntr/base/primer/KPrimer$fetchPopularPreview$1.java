package kntr.base.primer;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.watch.later.watchlater.edit.FavoriteSingleViewModelKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: KPrimer.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.base.primer.KPrimer", f = "KPrimer.kt", i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2}, l = {89, 98, FavoriteSingleViewModelKt.MAX_PAGE_SIZE}, m = "fetchPopularPreview", n = {"param", "$this$fetchPopularPreview_u24lambda_u240", "commonParams", "commonReq", "req", "items", "$i$a$-runCatching-KPrimer$fetchPopularPreview$2", "param", "$this$fetchPopularPreview_u24lambda_u240", "commonParams", "commonReq", "req", "result", "resultMap", "items", "$i$a$-runCatching-KPrimer$fetchPopularPreview$2", "param", "e", "$i$a$-onFailure-KPrimer$fetchPopularPreview$3"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "I$0", "L$0", "L$2", "I$0"}, v = 1)
public final class KPrimer$fetchPopularPreview$1 extends ContinuationImpl {
    int I$0;
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
    final /* synthetic */ KPrimer this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KPrimer$fetchPopularPreview$1(KPrimer kPrimer, Continuation<? super KPrimer$fetchPopularPreview$1> continuation) {
        super(continuation);
        this.this$0 = kPrimer;
    }

    public final Object invokeSuspend(Object obj) {
        Object fetchPopularPreview;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        fetchPopularPreview = this.this$0.fetchPopularPreview(null, (Continuation) this);
        return fetchPopularPreview;
    }
}