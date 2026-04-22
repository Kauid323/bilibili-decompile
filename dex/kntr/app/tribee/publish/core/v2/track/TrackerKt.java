package kntr.app.tribee.publish.core.v2.track;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.neuron.KNeuron;
import kntr.watch.later.watchlater.utils.WatchLaterReporterKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Tracker.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\u001a\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0006\u0010\u0006\u001a\u00020\u0005\u001a\u0006\u0010\u0007\u001a\u00020\u0005\u001a\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0001\u001a\u0006\u0010\n\u001a\u00020\u0005\u001a\u001e\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u0001\u001a\u001e\u0010\u000f\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u0001\u001a\b\u0010\u0010\u001a\u00020\u0005H\u0000\u001a\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0001H\u0000\u001a\u0018\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u0015H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"PAGE_PV", "", "TRIBEE_TYPE_KEY", "TRIBEE_TYPE_VALUE", "reportPhotoFloatLayerExposure", "", "reportPublishButtonClick", "reportPublishSuccessClick", "reportPhotoFloatLayerClick", "actionType", "reportSyncToDynClick", "reportCategoryExposure", "tribeeId", "categoryId", "categoryName", "reportCategoryClick", "reportSettingsClick", "reportToolbarButtonClick", "button", "reportToolPanelButtonClick", "isSelected", "", "core_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TrackerKt {
    public static final String PAGE_PV = "read.column-contribution.0.0.pv";
    private static final String TRIBEE_TYPE_KEY = "type";
    private static final String TRIBEE_TYPE_VALUE = "tribee";

    public static final void reportPhotoFloatLayerExposure() {
        KNeuron.INSTANCE.reportExposure(false, "read.column-contribution.default.pic-layer.show", MapsKt.mapOf(TuplesKt.to(TRIBEE_TYPE_KEY, TRIBEE_TYPE_VALUE)));
    }

    public static final void reportPublishButtonClick() {
        KNeuron.INSTANCE.reportClick(false, "read.column-contribution.default.produce.click", MapsKt.mapOf(TuplesKt.to(TRIBEE_TYPE_KEY, TRIBEE_TYPE_VALUE)));
    }

    public static final void reportPublishSuccessClick() {
        KNeuron.INSTANCE.reportClick(false, "read.column-contribution.default.produce-suc.click", MapsKt.mapOf(TuplesKt.to(TRIBEE_TYPE_KEY, TRIBEE_TYPE_VALUE)));
    }

    public static final void reportPhotoFloatLayerClick(String actionType) {
        Intrinsics.checkNotNullParameter(actionType, "actionType");
        KNeuron.INSTANCE.reportClick(false, "read.column-contribution.default.pic-layer.click", MapsKt.mapOf(new Pair[]{TuplesKt.to(TRIBEE_TYPE_KEY, TRIBEE_TYPE_VALUE), TuplesKt.to(WatchLaterReporterKt.KEY_ACTION_TYPE, actionType)}));
    }

    public static final void reportSyncToDynClick() {
        KNeuron.INSTANCE.reportClick(false, "read.column-contribution.default.sync-dt.click", MapsKt.mapOf(TuplesKt.to(TRIBEE_TYPE_KEY, TRIBEE_TYPE_VALUE)));
    }

    public static final void reportCategoryExposure(String tribeeId, String categoryId, String categoryName) {
        Intrinsics.checkNotNullParameter(tribeeId, "tribeeId");
        Intrinsics.checkNotNullParameter(categoryId, "categoryId");
        Intrinsics.checkNotNullParameter(categoryName, "categoryName");
        KNeuron.INSTANCE.reportExposure(false, "read.column-contribution.default.sub.show", MapsKt.mapOf(new Pair[]{TuplesKt.to(TRIBEE_TYPE_KEY, TRIBEE_TYPE_VALUE), TuplesKt.to("tribee_id", tribeeId), TuplesKt.to("tribee_sub_id", categoryId), TuplesKt.to("tribee_sub_name", categoryName)}));
    }

    public static final void reportCategoryClick(String tribeeId, String categoryId, String categoryName) {
        Intrinsics.checkNotNullParameter(tribeeId, "tribeeId");
        Intrinsics.checkNotNullParameter(categoryId, "categoryId");
        Intrinsics.checkNotNullParameter(categoryName, "categoryName");
        KNeuron.INSTANCE.reportClick(false, "read.column-contribution.default.sub.click", MapsKt.mapOf(new Pair[]{TuplesKt.to(TRIBEE_TYPE_KEY, TRIBEE_TYPE_VALUE), TuplesKt.to("tribee_id", tribeeId), TuplesKt.to("tribee_sub_id", categoryId), TuplesKt.to("tribee_sub_name", categoryName)}));
    }

    public static final void reportSettingsClick() {
        KNeuron.INSTANCE.reportClick(false, "read.column-contribution.bottom.setting-bnt.click", MapsKt.mapOf(TuplesKt.to(TRIBEE_TYPE_KEY, TRIBEE_TYPE_VALUE)));
    }

    public static final void reportToolbarButtonClick(String button) {
        Intrinsics.checkNotNullParameter(button, "button");
        KNeuron.INSTANCE.reportClick(false, "read.column-contribution.bottom.bar-bnt.click", MapsKt.mapOf(new Pair[]{TuplesKt.to(TRIBEE_TYPE_KEY, TRIBEE_TYPE_VALUE), TuplesKt.to("btn_type", button)}));
    }

    public static final void reportToolPanelButtonClick(String button, boolean isSelected) {
        Intrinsics.checkNotNullParameter(button, "button");
        KNeuron kNeuron = KNeuron.INSTANCE;
        Pair[] pairArr = new Pair[3];
        pairArr[0] = TuplesKt.to(TRIBEE_TYPE_KEY, TRIBEE_TYPE_VALUE);
        pairArr[1] = TuplesKt.to("btn_type", button);
        pairArr[2] = TuplesKt.to("is_select", isSelected ? "1" : "0");
        kNeuron.reportClick(false, "read.column-contribution.bottom.bar-popup.click", MapsKt.mapOf(pairArr));
    }
}