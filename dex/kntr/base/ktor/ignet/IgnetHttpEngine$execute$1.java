package kntr.base.ktor.ignet;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IgnetHttpEngine.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.base.ktor.ignet.IgnetHttpEngine", f = "IgnetHttpEngine.kt", i = {0, 1, 1, 2, 2, 2}, l = {73, 74, 75}, m = "execute", n = {"data", "data", "callContext", "data", "callContext", "ighttpRequest"}, s = {"L$0", "L$0", "L$1", "L$0", "L$1", "L$2"}, v = 1)
public final class IgnetHttpEngine$execute$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ IgnetHttpEngine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IgnetHttpEngine$execute$1(IgnetHttpEngine ignetHttpEngine, Continuation<? super IgnetHttpEngine$execute$1> continuation) {
        super(continuation);
        this.this$0 = ignetHttpEngine;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.execute(null, (Continuation) this);
    }
}