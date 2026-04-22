package kntr.watch.later.watchlater.consts;

import bili.resource.favorites.FavoritesRes;
import bili.resource.homepage.HomepageRes;
import bili.resource.homepage.String0_commonMainKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: WatchLaterConsts.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u0014\u0010\u0000\u001a\u00020\u00018BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\"\u0014\u0010\u0004\u001a\u00020\u00018BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0003\"\u001b\u0010\u0006\u001a\u00020\u00078@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"allTabName", "", "getAllTabName", "()Ljava/lang/String;", "continueTabName", "getContinueTabName", "tabList", "Lkntr/watch/later/watchlater/consts/Tabs;", "getTabList", "()Lkntr/watch/later/watchlater/consts/Tabs;", "tabList$delegate", "Lkotlin/Lazy;", "watch_later_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class WatchLaterConstsKt {
    private static final Lazy tabList$delegate = LazyKt.lazy(new Function0() { // from class: kntr.watch.later.watchlater.consts.WatchLaterConstsKt$$ExternalSyntheticLambda0
        public final Object invoke() {
            Tabs tabList_delegate$lambda$0;
            tabList_delegate$lambda$0 = WatchLaterConstsKt.tabList_delegate$lambda$0();
            return tabList_delegate$lambda$0;
        }
    });

    public static final /* synthetic */ String access$getAllTabName() {
        return getAllTabName();
    }

    public static final /* synthetic */ String access$getContinueTabName() {
        return getContinueTabName();
    }

    public static final String getAllTabName() {
        return HomepageRes.INSTANCE.getString(String0_commonMainKt.getHomepage_global_string_107(HomepageRes.INSTANCE.getString()));
    }

    public static final String getContinueTabName() {
        return HomepageRes.INSTANCE.getString(bili.resource.favorites.String0_commonMainKt.getFavorites_global_string_233(FavoritesRes.INSTANCE.getString()));
    }

    public static final Tabs getTabList() {
        return (Tabs) tabList$delegate.getValue();
    }

    public static final Tabs tabList_delegate$lambda$0() {
        return new Tabs();
    }
}