package kntr.app.tribee.publish.draft;

import kntr.app.tribee.publish.TribeeInfo;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* compiled from: TribeeDraftService.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u0006J \u0010\u0007\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\nH¦@¢\u0006\u0002\u0010\u000bJ \u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\r2\u0006\u0010\u0004\u001a\u00020\u0005H¦@¢\u0006\u0004\b\u000e\u0010\u0006¨\u0006\u000fÀ\u0006\u0003"}, d2 = {"Lkntr/app/tribee/publish/draft/TribeeDraftService;", "", "checkDraft", "", "tribeeInfo", "Lkntr/app/tribee/publish/TribeeInfo;", "(Lkntr/app/tribee/publish/TribeeInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveDraft", "", "content", "Lkntr/app/tribee/publish/draft/TribeeDraftContent;", "(Lkntr/app/tribee/publish/TribeeInfo;Lkntr/app/tribee/publish/draft/TribeeDraftContent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadDraft", "Lkotlin/Result;", "loadDraft-gIAlu-s", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface TribeeDraftService {
    Object checkDraft(TribeeInfo tribeeInfo, Continuation<? super Boolean> continuation);

    /* renamed from: loadDraft-gIAlu-s  reason: not valid java name */
    Object mo901loadDraftgIAlus(TribeeInfo tribeeInfo, Continuation<? super Result<TribeeDraftContent>> continuation);

    Object saveDraft(TribeeInfo tribeeInfo, TribeeDraftContent tribeeDraftContent, Continuation<? super Unit> continuation);
}