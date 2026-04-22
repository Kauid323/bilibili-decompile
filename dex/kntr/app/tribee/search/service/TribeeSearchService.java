package kntr.app.tribee.search.service;

import com.bapis.bilibili.app.dynamic.v2.KTribeeMoss;
import com.bapis.bilibili.app.dynamic.v2.KTribeeSearchAllReq;
import com.bapis.bilibili.app.dynamic.v2.KTribeeSearchAllResp;
import com.bapis.bilibili.app.dynamic.v2.KTribeeSearchOrder;
import com.bapis.bilibili.app.dynamic.v2.KTribeeSearchType;
import com.bapis.bilibili.pagination.KPagination;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.moss.api.KCallOptions;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: TribeeSearchService.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0086@¢\u0006\u0002\u0010\nJ&\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0007H\u0086@¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"Lkntr/app/tribee/search/service/TribeeSearchService;", "", "<init>", "()V", "loadSearchData", "Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSearchAllResp;", "keyword", "", "tribeeId", "", "(Ljava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadNextSearchData", "next", "(Ljava/lang/String;JLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "search_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeeSearchService {
    public static final int $stable = 0;

    public final Object loadSearchData(String keyword, long tribeeId, Continuation<? super KTribeeSearchAllResp> continuation) {
        return new KTribeeMoss((KCallOptions) null, 1, (DefaultConstructorMarker) null).tribeeSearchAll(new KTribeeSearchAllReq(keyword, tribeeId, (KTribeeSearchType) null, (KTribeeSearchOrder) null, new KPagination(20, (String) null, 2, (DefaultConstructorMarker) null), false, 44, (DefaultConstructorMarker) null), continuation);
    }

    public final Object loadNextSearchData(String keyword, long tribeeId, String next, Continuation<? super KTribeeSearchAllResp> continuation) {
        return new KTribeeMoss((KCallOptions) null, 1, (DefaultConstructorMarker) null).tribeeSearchAll(new KTribeeSearchAllReq(keyword, tribeeId, (KTribeeSearchType) null, (KTribeeSearchOrder) null, new KPagination(20, next), false, 44, (DefaultConstructorMarker) null), continuation);
    }
}