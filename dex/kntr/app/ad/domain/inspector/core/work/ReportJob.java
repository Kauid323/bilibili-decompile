package kntr.app.ad.domain.inspector.core.work;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: Job.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b1\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0002H\u0014\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lkntr/app/ad/domain/inspector/core/work/ReportJob;", "Lkntr/app/ad/domain/inspector/core/work/Job;", "Lkntr/app/ad/domain/inspector/core/work/ReportJobData;", "jobData", "<init>", "(Lkntr/app/ad/domain/inspector/core/work/ReportJobData;)V", "createUpdatedData", "Lkntr/app/ad/domain/inspector/core/work/FeeReportJob;", "Lkntr/app/ad/domain/inspector/core/work/MMAReportJob;", "Lkntr/app/ad/domain/inspector/core/work/UIReportJob;", "inspector_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class ReportJob extends Job<ReportJobData> {
    public static final int $stable = 8;

    public /* synthetic */ ReportJob(ReportJobData reportJobData, DefaultConstructorMarker defaultConstructorMarker) {
        this(reportJobData);
    }

    private ReportJob(ReportJobData jobData) {
        super(jobData);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kntr.app.ad.domain.inspector.core.work.Job
    public ReportJobData createUpdatedData() {
        ReportJobData copy;
        copy = r1.copy((r30 & 1) != 0 ? r1.id : null, (r30 & 2) != 0 ? r1.name : null, (r30 & 4) != 0 ? r1.status : null, (r30 & 8) != 0 ? r1.timestamp : 0L, (r30 & 16) != 0 ? r1.startTime : null, (r30 & 32) != 0 ? r1.endTime : null, (r30 & 64) != 0 ? r1.jobType : null, (r30 & 128) != 0 ? r1.reportType : null, (r30 & 256) != 0 ? r1.isRetry : false, (r30 & 512) != 0 ? r1.url : null, (r30 & 1024) != 0 ? r1.requestBody : null, (r30 & 2048) != 0 ? r1.responseBody : null, (r30 & 4096) != 0 ? getData().adId : null);
        return copy;
    }
}