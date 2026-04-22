package kntr.app.upcomingEpisode.base.util;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ReservationApi.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.upcomingEpisode.base.util.ReservationApi", f = "ReservationApi.kt", i = {0, 0, 0, 1, 1, 1, 1, 1, 1}, l = {43, 115}, m = "reserveCard", n = {"sid", "spmid", "url", "sid", "spmid", "url", "httpResponse", "$this$body$iv", "$i$f$body"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0"}, v = 1)
public final class ReservationApi$reserveCard$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ReservationApi this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReservationApi$reserveCard$1(ReservationApi reservationApi, Continuation<? super ReservationApi$reserveCard$1> continuation) {
        super(continuation);
        this.this$0 = reservationApi;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.reserveCard(null, null, (Continuation) this);
    }
}