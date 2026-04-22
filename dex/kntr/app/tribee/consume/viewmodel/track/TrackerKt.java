package kntr.app.tribee.consume.viewmodel.track;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.neuron.IPlatformNeuron;
import kntr.base.neuron.KNeuron;
import kntr.watch.later.watchlater.utils.WatchLaterReporterKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Tracker.kt */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b \u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0016\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003\u001a6\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\b\u001a6\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\b\u001a\u0006\u0010\u0010\u001a\u00020\u0001\u001a\u000e\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\b\u001a\u0006\u0010\u0013\u001a\u00020\u0001\u001a\u000e\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\b\u001a\u0006\u0010\u0015\u001a\u00020\u0001\u001a\u0006\u0010\u0016\u001a\u00020\u0001\u001a\u0006\u0010\u0017\u001a\u00020\u0001\u001a\u000e\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\b\u001a\u000e\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\b\u001a\u000e\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\b\u001a\u000e\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\b\u001a\u0006\u0010\u001e\u001a\u00020\u0001\u001a\u0016\u0010\u001f\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010 \u001a\u00020\b\u001a&\u0010!\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\b\u001a\u001e\u0010\"\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\b\u001a\u0006\u0010#\u001a\u00020\u0001\u001a\u000e\u0010$\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\b\u001a\u000e\u0010%\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\b\u001a>\u0010&\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010'\u001a\u00020\b2\u0006\u0010(\u001a\u00020\b2\u0006\u0010)\u001a\u00020\b2\u0006\u0010*\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b¨\u0006+"}, d2 = {"reportJoinButtonClick", "", "hasJoined", "", "reportPublishInBottom", "isInBlacklist", "reportClickPost", "tribeeId", "", "dynamicId", "tribeeSubId", "", "tribeeSubName", "fromSpmid", "stayRowType", "reportExposurePost", "reportExposureExitDialog", "reportClickInExitDialog", "actionType", "reportExposureJoinDialog", "reportClickInJoinDialog", "reportExposurePermissionDialog", "reportClickInPermissionDialog", "reportExposureMinePage", "reportClickInMinePage", "reportMenuNotifyExposure", "type", "reportMenuNotifyClick", "inviteCodeResultDialogExposure", "result", "inviteCodeInputDialogExposure", "inviteCodeInputDialogClick", "url", "categoryContentExposure", "categoryContentClick", "tribeeRevisitGuideExposure", "tribeeRevisitGuideClick", "reportTribeeSearchBarClick", "reportTribeeSortClick", "stayType", "stayTypePos", "clickType", "clickTypePos", "consume_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TrackerKt {
    public static final void reportJoinButtonClick(boolean hasJoined) {
        KNeuron.INSTANCE.reportClick(false, "tribee.main-page.top.add-or-exit-msite.click", MapsKt.mapOf(TuplesKt.to("has_joined", hasJoined ? "1" : "0")));
    }

    public static final void reportPublishInBottom(boolean hasJoined, boolean isInBlacklist) {
        KNeuron kNeuron = KNeuron.INSTANCE;
        Pair[] pairArr = new Pair[2];
        pairArr[0] = TuplesKt.to("has_joined", hasJoined ? "1" : "0");
        pairArr[1] = TuplesKt.to("is_in_blacklist", isInBlacklist ? "1" : "0");
        kNeuron.reportClick(false, "tribee.main-page.bottom.add-post.click", MapsKt.mapOf(pairArr));
    }

    public static final void reportClickPost(String tribeeId, String dynamicId, long tribeeSubId, String tribeeSubName, String fromSpmid, String stayRowType) {
        Intrinsics.checkNotNullParameter(tribeeId, "tribeeId");
        Intrinsics.checkNotNullParameter(dynamicId, "dynamicId");
        Intrinsics.checkNotNullParameter(tribeeSubName, "tribeeSubName");
        Intrinsics.checkNotNullParameter(fromSpmid, "fromSpmid");
        Intrinsics.checkNotNullParameter(stayRowType, "stayRowType");
        KNeuron.INSTANCE.reportClick(false, "tribee.main-page.post-card-feed.card.click", MapsKt.mapOf(new Pair[]{TuplesKt.to("tribee_id", tribeeId), TuplesKt.to("dynamic_id", dynamicId), TuplesKt.to("tribee_sub_id", String.valueOf(tribeeSubId)), TuplesKt.to("tribee_sub_name", tribeeSubName), TuplesKt.to("from_spmid", fromSpmid), TuplesKt.to("stay_row_type", stayRowType)}));
    }

    public static final void reportExposurePost(String tribeeId, String dynamicId, long tribeeSubId, String tribeeSubName, String fromSpmid, String stayRowType) {
        Intrinsics.checkNotNullParameter(tribeeId, "tribeeId");
        Intrinsics.checkNotNullParameter(dynamicId, "dynamicId");
        Intrinsics.checkNotNullParameter(tribeeSubName, "tribeeSubName");
        Intrinsics.checkNotNullParameter(fromSpmid, "fromSpmid");
        Intrinsics.checkNotNullParameter(stayRowType, "stayRowType");
        KNeuron.INSTANCE.reportExposure(false, "tribee.main-page.post-card-feed.card.show", MapsKt.mapOf(new Pair[]{TuplesKt.to("tribee_id", tribeeId), TuplesKt.to("dynamic_id", dynamicId), TuplesKt.to("tribee_sub_id", String.valueOf(tribeeSubId)), TuplesKt.to("tribee_sub_name", tribeeSubName), TuplesKt.to("from_spmid", fromSpmid), TuplesKt.to("stay_row_type", stayRowType)}));
    }

    public static final void reportExposureExitDialog() {
        IPlatformNeuron.CC.reportExposure$default(KNeuron.INSTANCE, false, "tribee.main-page.top.exit-msite.show", null, 4, null);
    }

    public static final void reportClickInExitDialog(String actionType) {
        Intrinsics.checkNotNullParameter(actionType, "actionType");
        KNeuron.INSTANCE.reportClick(false, "tribee.main-page.top.exit-msite.click", MapsKt.mapOf(TuplesKt.to(WatchLaterReporterKt.KEY_ACTION_TYPE, actionType)));
    }

    public static final void reportExposureJoinDialog() {
        IPlatformNeuron.CC.reportExposure$default(KNeuron.INSTANCE, false, "tribee.main-page.bottom.add-msite-notice.show", null, 4, null);
    }

    public static final void reportClickInJoinDialog(String actionType) {
        Intrinsics.checkNotNullParameter(actionType, "actionType");
        KNeuron.INSTANCE.reportClick(false, "tribee.main-page.bottom.add-msite-notice.click", MapsKt.mapOf(TuplesKt.to(WatchLaterReporterKt.KEY_ACTION_TYPE, actionType)));
    }

    public static final void reportExposurePermissionDialog() {
        IPlatformNeuron.CC.reportExposure$default(KNeuron.INSTANCE, false, "tribee.main-page.top.add-msite-fail.show", null, 4, null);
    }

    public static final void reportClickInPermissionDialog() {
        KNeuron.INSTANCE.reportClick(false, "tribee.main-page.top.add-msite-fail.click", MapsKt.mapOf(TuplesKt.to(WatchLaterReporterKt.KEY_ACTION_TYPE, "OK")));
    }

    public static final void reportExposureMinePage() {
        IPlatformNeuron.CC.reportExposure$default(KNeuron.INSTANCE, false, "tribee.main-page.top.self-page-pannel.show", null, 4, null);
    }

    public static final void reportClickInMinePage(String actionType) {
        Intrinsics.checkNotNullParameter(actionType, "actionType");
        KNeuron.INSTANCE.reportClick(false, "tribee.main-page.top.self-page-pannel.click", MapsKt.mapOf(TuplesKt.to(WatchLaterReporterKt.KEY_ACTION_TYPE, actionType)));
    }

    public static final void reportMenuNotifyExposure(String type) {
        Intrinsics.checkNotNullParameter(type, "type");
        KNeuron.INSTANCE.reportExposure(false, "tribee.main-page.top.self-page-button.show", MapsKt.mapOf(TuplesKt.to("type", type)));
    }

    public static final void reportMenuNotifyClick(String type) {
        Intrinsics.checkNotNullParameter(type, "type");
        KNeuron.INSTANCE.reportClick(false, "tribee.main-page.top.self-page-button.click", MapsKt.mapOf(TuplesKt.to("type", type)));
    }

    public static final void inviteCodeResultDialogExposure(String result) {
        Intrinsics.checkNotNullParameter(result, "result");
        KNeuron.INSTANCE.reportExposure(false, "tribee.main-page.top.verify-result.show", MapsKt.mapOf(TuplesKt.to("result", result)));
    }

    public static final void inviteCodeInputDialogExposure() {
        IPlatformNeuron.CC.reportExposure$default(KNeuron.INSTANCE, false, "tribee.main-page.top.input-invite-code.show", null, 4, null);
    }

    public static final void inviteCodeInputDialogClick(String actionType, String url) {
        Intrinsics.checkNotNullParameter(actionType, "actionType");
        Intrinsics.checkNotNullParameter(url, "url");
        KNeuron.INSTANCE.reportClick(false, "tribee.main-page.top.input-invite-code.click", MapsKt.mapOf(new Pair[]{TuplesKt.to(WatchLaterReporterKt.KEY_ACTION_TYPE, actionType), TuplesKt.to("url", url)}));
    }

    public static final void categoryContentExposure(String fromSpmid, String tribeeId, long tribeeSubId, String tribeeSubName) {
        Intrinsics.checkNotNullParameter(fromSpmid, "fromSpmid");
        Intrinsics.checkNotNullParameter(tribeeId, "tribeeId");
        Intrinsics.checkNotNullParameter(tribeeSubName, "tribeeSubName");
        KNeuron.INSTANCE.reportExposure(false, "tribee.main-page.0.0.show", MapsKt.mapOf(new Pair[]{TuplesKt.to("from_spmid", fromSpmid), TuplesKt.to("tribee_id", tribeeId), TuplesKt.to("tribee_sub_id", String.valueOf(tribeeSubId)), TuplesKt.to("tribee_sub_name", tribeeSubName)}));
    }

    public static final void categoryContentClick(String tribeeId, long tribeeSubId, String tribeeSubName) {
        Intrinsics.checkNotNullParameter(tribeeId, "tribeeId");
        Intrinsics.checkNotNullParameter(tribeeSubName, "tribeeSubName");
        KNeuron.INSTANCE.reportClick(false, "tribee.main-page.top-bar.sub-tab.click", MapsKt.mapOf(new Pair[]{TuplesKt.to("tribee_id", tribeeId), TuplesKt.to("tribee_sub_id", String.valueOf(tribeeSubId)), TuplesKt.to("tribee_sub_name", tribeeSubName)}));
    }

    public static final void tribeeRevisitGuideExposure() {
        IPlatformNeuron.CC.reportExposure$default(KNeuron.INSTANCE, false, "tribee.main-page.bottom.entry-success-float.show", null, 4, null);
    }

    public static final void tribeeRevisitGuideClick(String actionType) {
        Intrinsics.checkNotNullParameter(actionType, "actionType");
        KNeuron.INSTANCE.reportClick(false, "tribee.main-page.bottom.entry-success-float.click", MapsKt.mapOf(TuplesKt.to(WatchLaterReporterKt.KEY_ACTION_TYPE, actionType)));
    }

    public static final void reportTribeeSearchBarClick(String tribeeId) {
        Intrinsics.checkNotNullParameter(tribeeId, "tribeeId");
        KNeuron.INSTANCE.reportClick(false, "tribee.main-page.search.0.click", MapsKt.mapOf(TuplesKt.to("tribee_id", tribeeId)));
    }

    public static final void reportTribeeSortClick(String tribeeId, String fromSpmid, String stayType, String stayTypePos, String clickType, String clickTypePos, String tribeeSubName) {
        Intrinsics.checkNotNullParameter(tribeeId, "tribeeId");
        Intrinsics.checkNotNullParameter(fromSpmid, "fromSpmid");
        Intrinsics.checkNotNullParameter(stayType, "stayType");
        Intrinsics.checkNotNullParameter(stayTypePos, "stayTypePos");
        Intrinsics.checkNotNullParameter(clickType, "clickType");
        Intrinsics.checkNotNullParameter(clickTypePos, "clickTypePos");
        Intrinsics.checkNotNullParameter(tribeeSubName, "tribeeSubName");
        KNeuron.INSTANCE.reportClick(false, "tribee.main-page.post-card-feed.row-btn.click", MapsKt.mapOf(new Pair[]{TuplesKt.to("tribee_id", tribeeId), TuplesKt.to("from_spmid", fromSpmid), TuplesKt.to("stay_type", stayType), TuplesKt.to("stay_type_pos", stayTypePos), TuplesKt.to(WatchLaterReporterKt.KEY_CLICK_TYPE, clickType), TuplesKt.to("click_type_pos", clickTypePos), TuplesKt.to("tribee_sub_name", tribeeSubName)}));
    }
}