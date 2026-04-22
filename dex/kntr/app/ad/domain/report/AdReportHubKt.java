package kntr.app.ad.domain.report;

import kntr.app.ad.domain.report.AdReportHub;
import kntr.app.ad.domain.report.vendor.fee.FeeReportFeature;
import kntr.app.ad.domain.report.vendor.mma.MMAReportFeature;
import kntr.app.ad.domain.report.vendor.ui.UIReportFeature;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.log.KLog_androidKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AdReportHub.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0007¨\u0006\u0003"}, d2 = {"startup", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/ad/domain/report/AdReportHub$Companion;", "report_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class AdReportHubKt {
    public static final void startup(AdReportHub.Companion $this$startup) {
        Intrinsics.checkNotNullParameter($this$startup, "<this>");
        KLog_androidKt.getKLog().d("AdReport", "startup");
        FeeReportFeature.INSTANCE.startup();
        MMAReportFeature.INSTANCE.startup();
        UIReportFeature.INSTANCE.startup();
    }
}