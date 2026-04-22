package kntr.app.tribee.publish.draft;

import kntr.app.tribee.publish.TribeeInfo;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;

/* compiled from: TribeeNoDraftImpl.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096@¢\u0006\u0002\u0010\bJ \u0010\t\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0096@¢\u0006\u0002\u0010\rJ \u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000f2\u0006\u0010\u0006\u001a\u00020\u0007H\u0096@¢\u0006\u0004\b\u0010\u0010\b¨\u0006\u0011"}, d2 = {"Lkntr/app/tribee/publish/draft/TribeeNoDraftImpl;", "Lkntr/app/tribee/publish/draft/TribeeDraftService;", "<init>", "()V", "checkDraft", "", "tribeeInfo", "Lkntr/app/tribee/publish/TribeeInfo;", "(Lkntr/app/tribee/publish/TribeeInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveDraft", "", "content", "Lkntr/app/tribee/publish/draft/TribeeDraftContent;", "(Lkntr/app/tribee/publish/TribeeInfo;Lkntr/app/tribee/publish/draft/TribeeDraftContent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadDraft", "Lkotlin/Result;", "loadDraft-gIAlu-s", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeeNoDraftImpl implements TribeeDraftService {
    @Override // kntr.app.tribee.publish.draft.TribeeDraftService
    public Object checkDraft(TribeeInfo tribeeInfo, Continuation<? super Boolean> continuation) {
        return Boxing.boxBoolean(false);
    }

    @Override // kntr.app.tribee.publish.draft.TribeeDraftService
    public Object saveDraft(TribeeInfo tribeeInfo, TribeeDraftContent content, Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }

    @Override // kntr.app.tribee.publish.draft.TribeeDraftService
    /* renamed from: loadDraft-gIAlu-s */
    public Object mo901loadDraftgIAlus(TribeeInfo tribeeInfo, Continuation<? super Result<TribeeDraftContent>> continuation) {
        Result.Companion companion = Result.Companion;
        return Result.m2636constructorimpl(null);
    }
}