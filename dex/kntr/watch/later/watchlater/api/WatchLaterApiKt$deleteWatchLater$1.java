package kntr.watch.later.watchlater.api;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.watch.later.watchlater.edit.FavoriteSingleViewModelKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: WatchLaterApi.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.watch.later.watchlater.api.WatchLaterApiKt", f = "WatchLaterApi.kt", i = {0, 0, 1, 1, 1, 1, 1}, l = {FavoriteSingleViewModelKt.MAX_PAGE_SIZE, 174}, m = "deleteWatchLater", n = {"resources", "url", "resources", "url", "httpResponse", "$this$body$iv", "$i$f$body"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "I$0"}, v = 1)
public final class WatchLaterApiKt$deleteWatchLater$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public WatchLaterApiKt$deleteWatchLater$1(Continuation<? super WatchLaterApiKt$deleteWatchLater$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return WatchLaterApiKt.deleteWatchLater(null, (Continuation) this);
    }
}