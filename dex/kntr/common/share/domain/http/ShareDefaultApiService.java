package kntr.common.share.domain.http;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.share.domain.ShareDomainApi;
import kntr.common.share.domain.model.ShareChannels;
import kntr.common.share.domain.model.ShareClickParams;
import kntr.common.share.domain.model.ShareClickResult;
import kntr.common.share.domain.model.ShareFinishParams;
import kntr.common.share.domain.model.ShareFinishResult;
import kntr.common.share.domain.model.ShareResponse;
import kntr.common.share.domain.model.ShareSession;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* compiled from: ShareApiService.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\tJ$\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0096@¢\u0006\u0002\u0010\u000eJ$\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0096@¢\u0006\u0002\u0010\u0013¨\u0006\u0014"}, d2 = {"Lkntr/common/share/domain/http/ShareDefaultApiService;", "Lkntr/common/share/domain/ShareDomainApi;", "<init>", "()V", "requestShareChannels", "Lkntr/common/share/domain/model/ShareResponse;", "Lkntr/common/share/domain/model/ShareChannels;", "session", "Lkntr/common/share/domain/model/ShareSession;", "(Lkntr/common/share/domain/model/ShareSession;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestShareClick", "Lkntr/common/share/domain/model/ShareClickResult;", "clickParams", "Lkntr/common/share/domain/model/ShareClickParams;", "(Lkntr/common/share/domain/model/ShareSession;Lkntr/common/share/domain/model/ShareClickParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestShareFinish", "Lkntr/common/share/domain/model/ShareFinishResult;", "finishParams", "Lkntr/common/share/domain/model/ShareFinishParams;", "(Lkntr/common/share/domain/model/ShareSession;Lkntr/common/share/domain/model/ShareFinishParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "domain_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ShareDefaultApiService implements ShareDomainApi {
    public static final int $stable = 0;

    @Override // kntr.common.share.domain.ShareDomainApi
    public Object requestShareChannels(ShareSession session, Continuation<? super ShareResponse<ShareChannels>> continuation) {
        return ShareApiServiceKt.access$handleResponse(new ShareDefaultApiService$requestShareChannels$2(session, null), continuation);
    }

    @Override // kntr.common.share.domain.ShareDomainApi
    public Object requestShareClick(ShareSession session, ShareClickParams clickParams, Continuation<? super ShareResponse<ShareClickResult>> continuation) {
        return ShareApiServiceKt.access$handleResponse(new ShareDefaultApiService$requestShareClick$2(session, clickParams, null), continuation);
    }

    @Override // kntr.common.share.domain.ShareDomainApi
    public Object requestShareFinish(ShareSession session, ShareFinishParams finishParams, Continuation<? super ShareResponse<ShareFinishResult>> continuation) {
        return ShareApiServiceKt.access$handleResponse(new ShareDefaultApiService$requestShareFinish$2(session, finishParams, null), continuation);
    }
}