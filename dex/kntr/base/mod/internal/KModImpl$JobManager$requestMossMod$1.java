package kntr.base.mod.internal;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.mod.internal.KModImpl;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: KModImpl.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.base.mod.internal.KModImpl$JobManager", f = "KModImpl.kt", i = {0, 0, 0}, l = {472}, m = "requestMossMod", n = {"poolName", "modName", "locals"}, s = {"L$0", "L$1", "L$2"}, v = 1)
public final class KModImpl$JobManager$requestMossMod$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ KModImpl.JobManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KModImpl$JobManager$requestMossMod$1(KModImpl.JobManager jobManager, Continuation<? super KModImpl$JobManager$requestMossMod$1> continuation) {
        super(continuation);
        this.this$0 = jobManager;
    }

    public final Object invokeSuspend(Object obj) {
        Object requestMossMod;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        requestMossMod = this.this$0.requestMossMod(null, null, (Continuation) this);
        return requestMossMod;
    }
}