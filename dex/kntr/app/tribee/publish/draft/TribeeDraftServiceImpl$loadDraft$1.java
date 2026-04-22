package kntr.app.tribee.publish.draft;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TribeeDraftServiceImpl.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.tribee.publish.draft.TribeeDraftServiceImpl", f = "TribeeDraftServiceImpl.kt", i = {0, 0, 0, 0}, l = {105}, m = "loadDraft-gIAlu-s", n = {"tribeeInfo", "deferred", "$this$loadDraft_gIAlu_s_u24lambda_u240", "$i$a$-runCatching-TribeeDraftServiceImpl$loadDraft$2"}, s = {"L$0", "L$1", "L$2", "I$0"}, v = 1)
public final class TribeeDraftServiceImpl$loadDraft$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TribeeDraftServiceImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TribeeDraftServiceImpl$loadDraft$1(TribeeDraftServiceImpl tribeeDraftServiceImpl, Continuation<? super TribeeDraftServiceImpl$loadDraft$1> continuation) {
        super(continuation);
        this.this$0 = tribeeDraftServiceImpl;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object mo901loadDraftgIAlus = this.this$0.mo901loadDraftgIAlus(null, (Continuation) this);
        return mo901loadDraftgIAlus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? mo901loadDraftgIAlus : Result.m2635boximpl(mo901loadDraftgIAlus);
    }
}