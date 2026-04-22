package kntr.app.tribee.steam.service;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TribeeSteamDataService.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.tribee.steam.service.TribeeSteamDataService", f = "TribeeSteamDataService.kt", i = {0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3}, l = {181, 210, 222, 265}, m = "pollingState", n = {"fromState", "count", "fromState", "newState", "requestingActions", "nextPollingAction", "count", "fromState", "newState", "requestingActions", "nextPollingAction", "count", "fromState", "newState", "requestingActions", "nextPollingAction", "count"}, s = {"L$0", "J$0", "L$0", "L$1", "L$2", "L$3", "J$0", "L$0", "L$1", "L$2", "L$3", "J$0", "L$0", "L$1", "L$2", "L$3", "J$0"}, v = 1)
public final class TribeeSteamDataService$pollingState$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TribeeSteamDataService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TribeeSteamDataService$pollingState$1(TribeeSteamDataService tribeeSteamDataService, Continuation<? super TribeeSteamDataService$pollingState$1> continuation) {
        super(continuation);
        this.this$0 = tribeeSteamDataService;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.pollingState(null, 0L, (Continuation) this);
    }
}