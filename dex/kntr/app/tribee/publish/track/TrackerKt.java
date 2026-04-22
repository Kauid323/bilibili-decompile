package kntr.app.tribee.publish.track;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.neuron.KNeuron;
import kntr.watch.later.watchlater.utils.WatchLaterReporterKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Tracker.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\u001a\u000e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001\u001a\u000e\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001\u001a\u000e\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001\u001a\u000e\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001\u001a\u0016\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0001\u001a\u000e\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001\u001a\u001e\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u0001\u001a\u001e\u0010\u000f\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"PAGE_PV", "", "reportPhotoButtonClick", "", "type", "reportPhotoFloatLayerExposure", "reportPublishButtonClick", "reportPublishSuccessClick", "reportPhotoFloatLayerClick", "actionType", "reportSyncToDynClick", "reportCategoryExposure", "tribeeId", "categoryId", "categoryName", "reportCategoryClick", "core_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TrackerKt {
    public static final String PAGE_PV = "read.column-contribution.0.0.pv";

    public static final void reportPhotoButtonClick(String type) {
        Intrinsics.checkNotNullParameter(type, "type");
        KNeuron.INSTANCE.reportClick(false, "read.column-contribution.default.choose-picture.click", MapsKt.mapOf(TuplesKt.to("type", type)));
    }

    public static final void reportPhotoFloatLayerExposure(String type) {
        Intrinsics.checkNotNullParameter(type, "type");
        KNeuron.INSTANCE.reportExposure(false, "read.column-contribution.default.pic-layer.show", MapsKt.mapOf(TuplesKt.to("type", type)));
    }

    public static final void reportPublishButtonClick(String type) {
        Intrinsics.checkNotNullParameter(type, "type");
        KNeuron.INSTANCE.reportClick(false, "read.column-contribution.default.produce.click", MapsKt.mapOf(TuplesKt.to("type", type)));
    }

    public static final void reportPublishSuccessClick(String type) {
        Intrinsics.checkNotNullParameter(type, "type");
        KNeuron.INSTANCE.reportClick(false, "read.column-contribution.default.produce-suc.click", MapsKt.mapOf(TuplesKt.to("type", type)));
    }

    public static final void reportPhotoFloatLayerClick(String type, String actionType) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(actionType, "actionType");
        KNeuron.INSTANCE.reportClick(false, "read.column-contribution.default.pic-layer.click", MapsKt.mapOf(new Pair[]{TuplesKt.to("type", type), TuplesKt.to(WatchLaterReporterKt.KEY_ACTION_TYPE, actionType)}));
    }

    public static final void reportSyncToDynClick(String type) {
        Intrinsics.checkNotNullParameter(type, "type");
        KNeuron.INSTANCE.reportClick(false, "read.column-contribution.default.sync-dt.click", MapsKt.mapOf(TuplesKt.to("type", type)));
    }

    public static final void reportCategoryExposure(String tribeeId, String categoryId, String categoryName) {
        Intrinsics.checkNotNullParameter(tribeeId, "tribeeId");
        Intrinsics.checkNotNullParameter(categoryId, "categoryId");
        Intrinsics.checkNotNullParameter(categoryName, "categoryName");
        KNeuron.INSTANCE.reportExposure(false, "read.column-contribution.default.sub.show", MapsKt.mapOf(new Pair[]{TuplesKt.to("tribee_id", tribeeId), TuplesKt.to("tribee_sub_id", categoryId), TuplesKt.to("tribee_sub_name", categoryName)}));
    }

    public static final void reportCategoryClick(String tribeeId, String categoryId, String categoryName) {
        Intrinsics.checkNotNullParameter(tribeeId, "tribeeId");
        Intrinsics.checkNotNullParameter(categoryId, "categoryId");
        Intrinsics.checkNotNullParameter(categoryName, "categoryName");
        KNeuron.INSTANCE.reportClick(false, "read.column-contribution.default.sub.click", MapsKt.mapOf(new Pair[]{TuplesKt.to("tribee_id", tribeeId), TuplesKt.to("tribee_sub_id", categoryId), TuplesKt.to("tribee_sub_name", categoryName)}));
    }
}