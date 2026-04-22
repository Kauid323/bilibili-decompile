package kntr.app.ad.domain.report.vendor;

import kntr.app.ad.domain.report.internal.ReportExtraHandler;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: ReportBottle.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\u001b\u0010\u0002\u001a\u0015\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003¢\u0006\u0002\b\u0006H&J\u001b\u0010\u0007\u001a\u0015\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003¢\u0006\u0002\b\u0006H&¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lkntr/app/ad/domain/report/vendor/IReportBottle;", RoomRecommendViewModel.EMPTY_CURSOR, "getBuildIn", "Lkotlin/Function1;", "Lkntr/app/ad/domain/report/internal/ReportExtraHandler;", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlin/ExtensionFunctionType;", "getPreset", "report_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface IReportBottle {
    Function1<ReportExtraHandler, Unit> getBuildIn();

    Function1<ReportExtraHandler, Unit> getPreset();
}