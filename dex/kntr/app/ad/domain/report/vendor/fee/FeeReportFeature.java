package kntr.app.ad.domain.report.vendor.fee;

import java.util.Map;
import kntr.app.ad.domain.report.internal.ReportFeature;
import kntr.app.ad.domain.report.internal.ReportUtilKt;
import kntr.app.ad.domain.report.internal.ReportUtil_androidKt;
import kntr.app.ad.domain.report.internal.cache.AdReportCacheManager;
import kntr.app.ad.domain.report.internal.cache.IReportStorageManager;
import kntr.app.ad.domain.report.internal.cache.MemoryCache;
import kntr.app.ad.domain.report.internal.cache.local.AdReportFileStorageCache;
import kntr.app.ad.domain.report.internal.upload.IReportUploader;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FeeReportFeature.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0014¨\u0006\n"}, d2 = {"Lkntr/app/ad/domain/report/vendor/fee/FeeReportFeature;", "Lkntr/app/ad/domain/report/internal/ReportFeature;", "<init>", "()V", "createStorageManager", "Lkntr/app/ad/domain/report/internal/cache/IReportStorageManager;", "createUploader", "Lkntr/app/ad/domain/report/internal/upload/IReportUploader;", "supportBatch", RoomRecommendViewModel.EMPTY_CURSOR, "report_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FeeReportFeature extends ReportFeature {
    public static final FeeReportFeature INSTANCE = new FeeReportFeature();

    private FeeReportFeature() {
    }

    @Override // kntr.app.ad.domain.report.internal.ReportFeature
    public IReportStorageManager createStorageManager() {
        AdReportFileStorageCache localCache = new AdReportFileStorageCache(ReportUtil_androidKt.getFpDir("ad-report-fee-kntr"), ReportUtilKt.getReportConfig());
        MemoryCache memoryCache = new MemoryCache(50, new Function1() { // from class: kntr.app.ad.domain.report.vendor.fee.FeeReportFeature$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit createStorageManager$lambda$0;
                createStorageManager$lambda$0 = FeeReportFeature.createStorageManager$lambda$0((Map) obj);
                return createStorageManager$lambda$0;
            }
        });
        return new AdReportCacheManager(memoryCache, localCache, ReportUtilKt.getReportConfig());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit createStorageManager$lambda$0(Map it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    @Override // kntr.app.ad.domain.report.internal.ReportFeature
    public IReportUploader createUploader() {
        return new FeeReportUploader();
    }

    @Override // kntr.app.ad.domain.report.internal.ReportFeature
    protected boolean supportBatch() {
        return true;
    }
}