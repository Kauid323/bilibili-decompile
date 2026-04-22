package kntr.watch.later.watchlater.api;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: WatchLaterApi.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.watch.later.watchlater.api.WatchLaterApiKt", f = "WatchLaterApi.kt", i = {0, 0, 1, 1, 1, 1, 1}, l = {66, 174}, m = "cleanWatchLater", n = {"url", "cleanType", "url", "httpResponse", "$this$body$iv", "cleanType", "$i$f$body"}, s = {"L$0", "I$0", "L$0", "L$1", "L$2", "I$0", "I$1"}, v = 1)
public final class WatchLaterApiKt$cleanWatchLater$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public WatchLaterApiKt$cleanWatchLater$1(Continuation<? super WatchLaterApiKt$cleanWatchLater$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return WatchLaterApiKt.cleanWatchLater(0, (Continuation) this);
    }
}