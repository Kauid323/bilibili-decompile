package kntr.base.primer;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GPrimer.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.base.primer.GPrimerServer", f = "GPrimer.kt", i = {0, 0}, l = {103}, m = "hit", n = {"host", "path"}, s = {"L$0", "L$1"}, v = 1)
public final class GPrimerServer$hit$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GPrimerServer this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GPrimerServer$hit$1(GPrimerServer gPrimerServer, Continuation<? super GPrimerServer$hit$1> continuation) {
        super(continuation);
        this.this$0 = gPrimerServer;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.hit(null, null, (Continuation) this);
    }
}