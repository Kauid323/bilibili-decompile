package kntr.app.tribee.base;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TribeeResultChannel.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.tribee.base.TribeeResultChannel", f = "TribeeResultChannel.kt", i = {0, 0}, l = {46}, m = "awaitResult", n = {"resultKey", "channel"}, s = {"L$0", "L$1"}, v = 1)
public final class TribeeResultChannel$awaitResult$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TribeeResultChannel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TribeeResultChannel$awaitResult$1(TribeeResultChannel tribeeResultChannel, Continuation<? super TribeeResultChannel$awaitResult$1> continuation) {
        super(continuation);
        this.this$0 = tribeeResultChannel;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.awaitResult(null, (Continuation) this);
    }
}