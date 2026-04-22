package tv.danmaku.bili.ui.favorites.util;

import com.bilibili.lib.neuron.api.Neurons;
import com.bilibili.pvtracker.PageViewTracker;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.favorites.consts.FavoritesConstsKt;

/* compiled from: FavReportHelper.kt */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\b\u001a\"\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005\u001a\"\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005\u001a\u000e\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u0003\u001a\u0016\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r\u001a\u001a\u0010\u000e\u001a\u00020\u00012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005\u001a\u001a\u0010\u000f\u001a\u00020\u00012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005\u001a\u0006\u0010\u0010\u001a\u00020\u0001\u001a\u0006\u0010\u0011\u001a\u00020\u0001\u001a\u0016\u0010\u0012\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0003\u001a\u001a\u0010\u0014\u001a\u00020\u00012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005¨\u0006\u0015"}, d2 = {"reportFavShow", "", "eventId", "", "params", "", "reportFavClick", "reportSecButtonClick", "buttonName", "reportLonePressTopClick", "isTop", "", "fid", "", "reportFavCardShow", "reportFavCardClick", "reportSwitchLayoutTypeClick", "reportAddFavoritesFolderClick", "reportClickClearInvalidPanel", FavoritesConstsKt.SPMID, "reportSwitchTranslateClick", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class FavReportHelperKt {
    public static final void reportFavShow(String eventId, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        Intrinsics.checkNotNullParameter(map, "params");
        Neurons.reportExposure$default(false, eventId, map, (List) null, 8, (Object) null);
    }

    public static final void reportFavClick(String eventId, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        Intrinsics.checkNotNullParameter(map, "params");
        Neurons.reportClick(false, eventId, map);
    }

    public static final void reportSecButtonClick(String buttonName) {
        Intrinsics.checkNotNullParameter(buttonName, "buttonName");
        Pair[] pairArr = new Pair[2];
        pairArr[0] = TuplesKt.to(FavoritesConstsKt.BUTTON_NAME, buttonName);
        String currentPolarisActionId = PageViewTracker.getInstance().currentPolarisActionId();
        if (currentPolarisActionId == null) {
            currentPolarisActionId = "";
        }
        pairArr[1] = TuplesKt.to(FavoritesConstsKt.ACTION_ID, currentPolarisActionId);
        reportFavClick(FavoritesConstsKt.FAV_SEC_BUTTON_CLICK, MapsKt.mapOf(pairArr));
    }

    public static final void reportLonePressTopClick(boolean isTop, long fid) {
        Pair[] pairArr = new Pair[3];
        pairArr[0] = TuplesKt.to(FavoritesConstsKt.LONG_PRESS_TYPE, isTop ? "1" : "0");
        String currentPolarisActionId = PageViewTracker.getInstance().currentPolarisActionId();
        if (currentPolarisActionId == null) {
            currentPolarisActionId = "";
        }
        pairArr[1] = TuplesKt.to(FavoritesConstsKt.ACTION_ID, currentPolarisActionId);
        pairArr[2] = TuplesKt.to(FavoritesConstsKt.PLAYLIST_ID, String.valueOf(fid));
        reportFavClick(FavoritesConstsKt.FAV_LONG_PRESS_BUTTON_CLICK, MapsKt.mapOf(pairArr));
    }

    public static final void reportFavCardShow(Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "params");
        reportFavShow(FavoritesConstsKt.FAV_CONTENT_CARD_SHOW, map);
    }

    public static final void reportFavCardClick(Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "params");
        reportFavClick(FavoritesConstsKt.FAV_CONTENT_CARD_CLICK, map);
    }

    public static final void reportSwitchLayoutTypeClick() {
        Map params = MapsKt.mapOf(TuplesKt.to(FavoritesConstsKt.LAYOUT_TYPE, String.valueOf(FavoritesFolderUtilsKt.layoutType())));
        reportFavClick(FavoritesConstsKt.FAV_LAYOUT_CHANGE_BUTTON_CLICK, params);
    }

    public static final void reportAddFavoritesFolderClick() {
        Neurons.reportClick$default(false, FavoritesConstsKt.FAV_CREATE_FAVORITE_BUTTON_CLICK, (Map) null, 4, (Object) null);
    }

    public static final void reportClickClearInvalidPanel(String buttonName, String spmid) {
        Intrinsics.checkNotNullParameter(buttonName, "buttonName");
        Intrinsics.checkNotNullParameter(spmid, FavoritesConstsKt.SPMID);
        reportFavClick(FavoritesConstsKt.FAV_CLEAR_INVALID_PANEL_CLICK, MapsKt.mapOf(new Pair[]{TuplesKt.to(FavoritesConstsKt.BUTTON_NAME, buttonName), TuplesKt.to(FavoritesConstsKt.SPMID, spmid)}));
    }

    public static final void reportSwitchTranslateClick(Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "params");
        Neurons.reportClick(false, "main.my-fav.content-card.more-translate.click", map);
    }
}