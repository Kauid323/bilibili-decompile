package kntr.watch.later.watchlater.api;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: WatchLaterApi.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.watch.later.watchlater.api.WatchLaterApiKt", f = "WatchLaterApi.kt", i = {0, 0, 0, 1, 1, 1, 1, 1, 1}, l = {157, 174}, m = "batchAddToWatchLater", n = {"resources", "spmid", "url", "resources", "spmid", "url", "httpResponse", "$this$body$iv", "$i$f$body"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0"}, v = 1)
public final class WatchLaterApiKt$batchAddToWatchLater$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public WatchLaterApiKt$batchAddToWatchLater$1(Continuation<? super WatchLaterApiKt$batchAddToWatchLater$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return WatchLaterApiKt.batchAddToWatchLater(null, null, (Continuation) this);
    }
}