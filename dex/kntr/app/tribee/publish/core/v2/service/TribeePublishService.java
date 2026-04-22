package kntr.app.tribee.publish.core.v2.service;

import kntr.app.tribee.publish.core.v2.model.TribeePublishContent;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;

/* compiled from: TribeePublishService.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H¦@¢\u0006\u0004\b\u0007\u0010\b¨\u0006\tÀ\u0006\u0003"}, d2 = {"Lkntr/app/tribee/publish/core/v2/service/TribeePublishService;", "", "publish", "Lkotlin/Result;", "Lkntr/app/tribee/publish/core/v2/service/PublishResult;", "content", "Lkntr/app/tribee/publish/core/v2/model/TribeePublishContent;", "publish-gIAlu-s", "(Lkntr/app/tribee/publish/core/v2/model/TribeePublishContent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface TribeePublishService {
    /* renamed from: publish-gIAlu-s  reason: not valid java name */
    Object mo881publishgIAlus(TribeePublishContent tribeePublishContent, Continuation<? super Result<PublishResult>> continuation);
}