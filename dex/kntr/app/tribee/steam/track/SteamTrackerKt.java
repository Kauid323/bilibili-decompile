package kntr.app.tribee.steam.track;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.neuron.IPlatformNeuron;
import kntr.base.neuron.KNeuron;
import kntr.watch.later.watchlater.utils.WatchLaterReporterKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SteamTracker.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000f\u001a\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0001\u001a\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0001\u001a\u0016\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0001\u001a\u0006\u0010\u000b\u001a\u00020\u0005\u001a\u000e\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0001\u001a\u000e\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0001\u001a\u000e\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0001\u001a\u0016\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0001\u001a\u000e\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"STEAM_PAGE_PV", "", "STEAM_PAGE_SPMID", "STEAM_PAGE_SHARE_ID", "steamPageExposure", "", "reportSteamPageClick", "actionType", "steamUnboundExposure", "status", "reportSteamUnboundClick", "reportSteamAchievementCardClick", "steamPageFloatExposure", "pageType", "reportSteamPageFloatClick", "steamPagePopupExposure", "popupType", "reportSteamPagePopupClick", "toastDialogExposure", "toastType", "consume_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class SteamTrackerKt {
    public static final String STEAM_PAGE_PV = "tribee.steam-page.0.0.pv";
    public static final String STEAM_PAGE_SHARE_ID = "tribee.steam-page.0.0.click";
    public static final String STEAM_PAGE_SPMID = "tribee.steam-page.0.0";

    public static final void steamPageExposure() {
        IPlatformNeuron.CC.reportExposure$default(KNeuron.INSTANCE, false, "tribee.steam-page.0.0.show", null, 4, null);
    }

    public static final void reportSteamPageClick(String actionType) {
        Intrinsics.checkNotNullParameter(actionType, "actionType");
        KNeuron.INSTANCE.reportClick(false, STEAM_PAGE_SHARE_ID, MapsKt.mapOf(TuplesKt.to(WatchLaterReporterKt.KEY_ACTION_TYPE, actionType)));
    }

    public static final void steamUnboundExposure(String status) {
        Intrinsics.checkNotNullParameter(status, "status");
        KNeuron.INSTANCE.reportExposure(false, "tribee.steam-page.setting.0.show", MapsKt.mapOf(TuplesKt.to("status", status)));
    }

    public static final void reportSteamUnboundClick(String status, String actionType) {
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(actionType, "actionType");
        KNeuron.INSTANCE.reportClick(false, "tribee.steam-page.setting.0.click", MapsKt.mapOf(new Pair[]{TuplesKt.to("status", status), TuplesKt.to(WatchLaterReporterKt.KEY_ACTION_TYPE, actionType)}));
    }

    public static final void reportSteamAchievementCardClick() {
        IPlatformNeuron.CC.reportClick$default(KNeuron.INSTANCE, false, "tribee.steam-page.steam-feed.achievement-card.click", null, 4, null);
    }

    public static final void steamPageFloatExposure(String pageType) {
        Intrinsics.checkNotNullParameter(pageType, "pageType");
        KNeuron.INSTANCE.reportExposure(false, "tribee.steam-page.float.0.show", MapsKt.mapOf(TuplesKt.to("page_type", pageType)));
    }

    public static final void reportSteamPageFloatClick(String actionType) {
        Intrinsics.checkNotNullParameter(actionType, "actionType");
        KNeuron.INSTANCE.reportClick(false, "tribee.steam-page.float.0.click", MapsKt.mapOf(TuplesKt.to(WatchLaterReporterKt.KEY_ACTION_TYPE, actionType)));
    }

    public static final void steamPagePopupExposure(String popupType) {
        Intrinsics.checkNotNullParameter(popupType, "popupType");
        KNeuron.INSTANCE.reportExposure(false, "tribee.steam-page.popup.0.show", MapsKt.mapOf(TuplesKt.to("popup_type", popupType)));
    }

    public static final void reportSteamPagePopupClick(String popupType, String actionType) {
        Intrinsics.checkNotNullParameter(popupType, "popupType");
        Intrinsics.checkNotNullParameter(actionType, "actionType");
        KNeuron.INSTANCE.reportClick(false, "tribee.steam-page.popup.0.click", MapsKt.mapOf(new Pair[]{TuplesKt.to("popup_type", popupType), TuplesKt.to(WatchLaterReporterKt.KEY_ACTION_TYPE, actionType)}));
    }

    public static final void toastDialogExposure(String toastType) {
        Intrinsics.checkNotNullParameter(toastType, "toastType");
        KNeuron.INSTANCE.reportExposure(false, "tribee.steam-page.toast.0.show", MapsKt.mapOf(TuplesKt.to("toast_type", toastType)));
    }
}