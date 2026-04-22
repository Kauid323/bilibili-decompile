package kntr.app.tribee.publish.draft;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TribeeDraftService.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.tribee.publish.draft.TribeeDraftServiceKt", f = "TribeeDraftService.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1}, l = {43, ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH}, m = "saveDraft", n = {"$this$saveDraft", "tribeeInfo", "converter", "content", "it", "$i$a$-let-TribeeDraftServiceKt$saveDraft$draft$1", "$this$saveDraft", "tribeeInfo", "converter", "content", "draft"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4"}, v = 1)
public final class TribeeDraftServiceKt$saveDraft$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TribeeDraftServiceKt$saveDraft$1(Continuation<? super TribeeDraftServiceKt$saveDraft$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return TribeeDraftServiceKt.saveDraft(null, null, null, null, (Continuation) this);
    }
}