package kntr.app.ad.domain.inspector.core.work;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;

/* compiled from: Job.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0014¨\u0006\u000b"}, d2 = {"Lkntr/app/ad/domain/inspector/core/work/UIReportJob;", "Lkntr/app/ad/domain/inspector/core/work/ReportJob;", "requestBody", RoomRecommendViewModel.EMPTY_CURSOR, "isRetry", RoomRecommendViewModel.EMPTY_CURSOR, "adId", "<init>", "(Ljava/lang/String;ZLjava/lang/String;)V", "createUpdatedData", "Lkntr/app/ad/domain/inspector/core/work/ReportJobData;", "inspector_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class UIReportJob extends ReportJob {
    public static final int $stable = 8;

    public UIReportJob(String requestBody, boolean isRetry, String adId) {
        super(ReportJobData.Companion.createUIReportJob(requestBody, isRetry, adId), null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kntr.app.ad.domain.inspector.core.work.ReportJob, kntr.app.ad.domain.inspector.core.work.Job
    public ReportJobData createUpdatedData() {
        ReportJobData copy;
        copy = r1.copy((r30 & 1) != 0 ? r1.id : null, (r30 & 2) != 0 ? r1.name : null, (r30 & 4) != 0 ? r1.status : null, (r30 & 8) != 0 ? r1.timestamp : 0L, (r30 & 16) != 0 ? r1.startTime : null, (r30 & 32) != 0 ? r1.endTime : null, (r30 & 64) != 0 ? r1.jobType : null, (r30 & 128) != 0 ? r1.reportType : null, (r30 & 256) != 0 ? r1.isRetry : false, (r30 & 512) != 0 ? r1.url : null, (r30 & 1024) != 0 ? r1.requestBody : null, (r30 & 2048) != 0 ? r1.responseBody : null, (r30 & 4096) != 0 ? getData().adId : null);
        return copy;
    }
}