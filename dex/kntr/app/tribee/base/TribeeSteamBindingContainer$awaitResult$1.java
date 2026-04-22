package kntr.app.tribee.base;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TribeeSteamBindingContainer.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.tribee.base.TribeeSteamBindingContainer", f = "TribeeSteamBindingContainer.kt", i = {0, 0}, l = {79}, m = "awaitResult", n = {"id", "channel"}, s = {"L$0", "L$1"}, v = 1)
public final class TribeeSteamBindingContainer$awaitResult$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TribeeSteamBindingContainer this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TribeeSteamBindingContainer$awaitResult$1(TribeeSteamBindingContainer tribeeSteamBindingContainer, Continuation<? super TribeeSteamBindingContainer$awaitResult$1> continuation) {
        super(continuation);
        this.this$0 = tribeeSteamBindingContainer;
    }

    public final Object invokeSuspend(Object obj) {
        Object awaitResult;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        awaitResult = this.this$0.awaitResult(null, (Continuation) this);
        return awaitResult;
    }
}