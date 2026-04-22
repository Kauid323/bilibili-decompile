package kntr.watch.later.watchlater.consts;

import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* compiled from: WatchLaterConsts.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lkntr/watch/later/watchlater/consts/Tabs;", "", "<init>", "()V", "tabs", "", "", "getTabs", "()Ljava/util/List;", "watch_later_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class Tabs {
    public static final int $stable = 0;

    public final List<String> getTabs() {
        return CollectionsKt.listOf(new String[]{WatchLaterConstsKt.access$getAllTabName(), WatchLaterConstsKt.access$getContinueTabName()});
    }
}