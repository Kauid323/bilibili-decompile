package kntr.app.ad.domain.inspector.core.work;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;

/* compiled from: Job.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0014¨\u0006\u000b"}, d2 = {"Lkntr/app/ad/domain/inspector/core/work/MMAReportJob;", "Lkntr/app/ad/domain/inspector/core/work/ReportJob;", "url", RoomRecommendViewModel.EMPTY_CURSOR, "isRetry", RoomRecommendViewModel.EMPTY_CURSOR, "adId", "<init>", "(Ljava/lang/String;ZLjava/lang/String;)V", "createUpdatedData", "Lkntr/app/ad/domain/inspector/core/work/ReportJobData;", "inspector_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MMAReportJob extends ReportJob {
    public static final int $stable = 8;

    public MMAReportJob(String url, boolean isRetry, String adId) {
        super(ReportJobData.Companion.createMMAReportJob(url, isRetry, adId), null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kntr.app.ad.domain.inspector.core.work.ReportJob, kntr.app.ad.domain.inspector.core.work.Job
    public ReportJobData createUpdatedData() {
        return ReportJobData.copy$default(getData(), null, null, null, 0L, null, null, null, null, false, null, null, null, null, 8191, null);
    }
}