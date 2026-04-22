package kntr.watch.later.watchlater.api;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FavoritesApi.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.watch.later.watchlater.api.FavoritesApiKt", f = "FavoritesApi.kt", i = {0, 0, 0, 1, 1, 1, 1, 1, 1}, l = {68, 112}, m = "batchCopyResource", n = {"resources", "url", "targetMediaId", "resources", "url", "httpResponse", "$this$body$iv", "targetMediaId", "$i$f$body"}, s = {"L$0", "L$1", "J$0", "L$0", "L$1", "L$2", "L$3", "J$0", "I$0"}, v = 1)
public final class FavoritesApiKt$batchCopyResource$1 extends ContinuationImpl {
    int I$0;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FavoritesApiKt$batchCopyResource$1(Continuation<? super FavoritesApiKt$batchCopyResource$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return FavoritesApiKt.batchCopyResource(null, 0L, (Continuation) this);
    }
}