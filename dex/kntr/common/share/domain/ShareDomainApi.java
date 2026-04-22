package kntr.common.share.domain;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.share.domain.model.ShareChannels;
import kntr.common.share.domain.model.ShareClickParams;
import kntr.common.share.domain.model.ShareClickResult;
import kntr.common.share.domain.model.ShareFinishParams;
import kntr.common.share.domain.model.ShareFinishResult;
import kntr.common.share.domain.model.ShareResponse;
import kntr.common.share.domain.model.ShareSession;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* compiled from: Domain.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H¦@¢\u0006\u0002\u0010\u0007J$\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH¦@¢\u0006\u0002\u0010\fJ$\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010H¦@¢\u0006\u0002\u0010\u0011¨\u0006\u0012À\u0006\u0003"}, d2 = {"Lkntr/common/share/domain/ShareDomainApi;", "", "requestShareChannels", "Lkntr/common/share/domain/model/ShareResponse;", "Lkntr/common/share/domain/model/ShareChannels;", "session", "Lkntr/common/share/domain/model/ShareSession;", "(Lkntr/common/share/domain/model/ShareSession;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestShareClick", "Lkntr/common/share/domain/model/ShareClickResult;", "clickParams", "Lkntr/common/share/domain/model/ShareClickParams;", "(Lkntr/common/share/domain/model/ShareSession;Lkntr/common/share/domain/model/ShareClickParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestShareFinish", "Lkntr/common/share/domain/model/ShareFinishResult;", "finishParams", "Lkntr/common/share/domain/model/ShareFinishParams;", "(Lkntr/common/share/domain/model/ShareSession;Lkntr/common/share/domain/model/ShareFinishParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "domain_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface ShareDomainApi {
    Object requestShareChannels(ShareSession shareSession, Continuation<? super ShareResponse<ShareChannels>> continuation);

    Object requestShareClick(ShareSession shareSession, ShareClickParams shareClickParams, Continuation<? super ShareResponse<ShareClickResult>> continuation);

    Object requestShareFinish(ShareSession shareSession, ShareFinishParams shareFinishParams, Continuation<? super ShareResponse<ShareFinishResult>> continuation);
}