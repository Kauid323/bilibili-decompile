package kntr.app.tribee.steam.service;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TribeeSteamDataService.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.tribee.steam.service.TribeeSteamDataService", f = "TribeeSteamDataService.kt", i = {0, 0, 0}, l = {319}, m = "switchGameAchievementState", n = {"game", "games", "achievements"}, s = {"L$0", "L$1", "L$2"}, v = 1)
public final class TribeeSteamDataService$switchGameAchievementState$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TribeeSteamDataService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TribeeSteamDataService$switchGameAchievementState$1(TribeeSteamDataService tribeeSteamDataService, Continuation<? super TribeeSteamDataService$switchGameAchievementState$1> continuation) {
        super(continuation);
        this.this$0 = tribeeSteamDataService;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.switchGameAchievementState(null, null, null, (Continuation) this);
    }
}