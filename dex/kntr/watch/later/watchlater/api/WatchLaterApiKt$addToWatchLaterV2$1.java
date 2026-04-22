package kntr.watch.later.watchlater.api;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.watch.later.watchlater.utils.WatchLaterReporterKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: WatchLaterApi.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.watch.later.watchlater.api.WatchLaterApiKt", f = "WatchLaterApi.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1}, l = {128, 174}, m = "addToWatchLaterV2", n = {WatchLaterReporterKt.KEY_AVID, "from", "spmid", "url", WatchLaterReporterKt.KEY_AVID, "from", "spmid", "url", "httpResponse", "$this$body$iv", "$i$f$body"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0"}, v = 1)
public final class WatchLaterApiKt$addToWatchLaterV2$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public WatchLaterApiKt$addToWatchLaterV2$1(Continuation<? super WatchLaterApiKt$addToWatchLaterV2$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return WatchLaterApiKt.addToWatchLaterV2(null, null, null, (Continuation) this);
    }
}