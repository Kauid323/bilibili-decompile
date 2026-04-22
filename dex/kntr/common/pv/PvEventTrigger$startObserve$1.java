package kntr.common.pv;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PvEventTrigger.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.pv.PvEventTrigger", f = "PvEventTrigger.kt", i = {}, l = {49, 51, 63}, m = "startObserve", n = {}, s = {}, v = 1)
public final class PvEventTrigger$startObserve$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PvEventTrigger this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PvEventTrigger$startObserve$1(PvEventTrigger pvEventTrigger, Continuation<? super PvEventTrigger$startObserve$1> continuation) {
        super(continuation);
        this.this$0 = pvEventTrigger;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.startObserve((Continuation) this);
    }
}