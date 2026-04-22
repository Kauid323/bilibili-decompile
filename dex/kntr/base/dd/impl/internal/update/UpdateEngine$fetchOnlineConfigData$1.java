package kntr.base.dd.impl.internal.update;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: UpdateEngine.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.base.dd.impl.internal.update.UpdateEngine", f = "UpdateEngine.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1}, l = {158, 161}, m = "fetchOnlineConfigData", n = {"env", "info", "dataType", "dataDir", "dataFilePath", "env", "info", "dataType", "dataDir", "dataFilePath"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4"}, v = 1)
public final class UpdateEngine$fetchOnlineConfigData$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ UpdateEngine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UpdateEngine$fetchOnlineConfigData$1(UpdateEngine updateEngine, Continuation<? super UpdateEngine$fetchOnlineConfigData$1> continuation) {
        super(continuation);
        this.this$0 = updateEngine;
    }

    public final Object invokeSuspend(Object obj) {
        Object fetchOnlineConfigData;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        fetchOnlineConfigData = this.this$0.fetchOnlineConfigData(null, null, (Continuation) this);
        return fetchOnlineConfigData;
    }
}