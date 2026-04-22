package kntr.app.appwidget.guide.utils;

import java.util.Map;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.neuron.KNeuron;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ReportHelper.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u001a*\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0000\u001a\u001a\u0010\b\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u0000\u001a\"\u0010\t\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0006H\u0000¨\u0006\u000b"}, d2 = {"reportAutoAddGuideRequest", RoomRecommendViewModel.EMPTY_CURSOR, "spmid", RoomRecommendViewModel.EMPTY_CURSOR, "type", "code", RoomRecommendViewModel.EMPTY_CURSOR, "isShow", "reportGuideBannerShow", "reportGuideBannerClick", "choice", "guide_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ReportHelperKt {
    public static /* synthetic */ void reportAutoAddGuideRequest$default(String str, String str2, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str2 = RoomRecommendViewModel.EMPTY_CURSOR;
        }
        reportAutoAddGuideRequest(str, str2, i, i2);
    }

    public static final void reportAutoAddGuideRequest(String spmid, String type, int code, int isShow) {
        Intrinsics.checkNotNullParameter(spmid, "spmid");
        Intrinsics.checkNotNullParameter(type, "type");
        Map $this$reportAutoAddGuideRequest_u24lambda_u240 = MapsKt.createMapBuilder();
        $this$reportAutoAddGuideRequest_u24lambda_u240.put("spmid", spmid);
        $this$reportAutoAddGuideRequest_u24lambda_u240.put("type", type);
        $this$reportAutoAddGuideRequest_u24lambda_u240.put("reason", String.valueOf(code));
        $this$reportAutoAddGuideRequest_u24lambda_u240.put("is_show", String.valueOf(isShow));
        Map map = MapsKt.build($this$reportAutoAddGuideRequest_u24lambda_u240);
        KNeuron.INSTANCE.reportClick(false, "app.add-to-desk.pop.client.click", map);
    }

    public static /* synthetic */ void reportGuideBannerShow$default(String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = RoomRecommendViewModel.EMPTY_CURSOR;
        }
        reportGuideBannerShow(str, str2);
    }

    public static final void reportGuideBannerShow(String spmid, String type) {
        Intrinsics.checkNotNullParameter(spmid, "spmid");
        Intrinsics.checkNotNullParameter(type, "type");
        Map $this$reportGuideBannerShow_u24lambda_u240 = MapsKt.createMapBuilder();
        $this$reportGuideBannerShow_u24lambda_u240.put("spmid", spmid);
        $this$reportGuideBannerShow_u24lambda_u240.put("type", type);
        Map map = MapsKt.build($this$reportGuideBannerShow_u24lambda_u240);
        KNeuron.INSTANCE.reportExposure(false, "app.add-to-desk.guide-banner.0.show", map);
    }

    public static /* synthetic */ void reportGuideBannerClick$default(String str, String str2, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str2 = RoomRecommendViewModel.EMPTY_CURSOR;
        }
        reportGuideBannerClick(str, str2, i);
    }

    public static final void reportGuideBannerClick(String spmid, String type, int choice) {
        Intrinsics.checkNotNullParameter(spmid, "spmid");
        Intrinsics.checkNotNullParameter(type, "type");
        Map $this$reportGuideBannerClick_u24lambda_u240 = MapsKt.createMapBuilder();
        $this$reportGuideBannerClick_u24lambda_u240.put("spmid", spmid);
        $this$reportGuideBannerClick_u24lambda_u240.put("type", type);
        $this$reportGuideBannerClick_u24lambda_u240.put("choice", String.valueOf(choice));
        Map map = MapsKt.build($this$reportGuideBannerClick_u24lambda_u240);
        KNeuron.INSTANCE.reportClick(false, "app.add-to-desk.guide-banner.0.click", map);
    }
}