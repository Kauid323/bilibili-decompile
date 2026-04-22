package kntr.app.ad.domain.inspector.core.work;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Job.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b1\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0002H\u0014J\u001a\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014\u0082\u0001\u0002\f\r¨\u0006\u000e"}, d2 = {"Lkntr/app/ad/domain/inspector/core/work/RequestJob;", "Lkntr/app/ad/domain/inspector/core/work/Job;", "Lkntr/app/ad/domain/inspector/core/work/RequestJobData;", "jobData", "<init>", "(Lkntr/app/ad/domain/inspector/core/work/RequestJobData;)V", "createUpdatedData", "handleSuccessData", RoomRecommendViewModel.EMPTY_CURSOR, "newData", "data", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/ad/domain/inspector/core/work/AdExtraJob;", "Lkntr/app/ad/domain/inspector/core/work/ApiJob;", "inspector_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class RequestJob extends Job<RequestJobData> {
    public static final int $stable = 8;

    public /* synthetic */ RequestJob(RequestJobData requestJobData, DefaultConstructorMarker defaultConstructorMarker) {
        this(requestJobData);
    }

    private RequestJob(RequestJobData jobData) {
        super(jobData);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kntr.app.ad.domain.inspector.core.work.Job
    public RequestJobData createUpdatedData() {
        RequestJobData copy;
        copy = r1.copy((r30 & 1) != 0 ? r1.id : null, (r30 & 2) != 0 ? r1.name : null, (r30 & 4) != 0 ? r1.status : null, (r30 & 8) != 0 ? r1.timestamp : 0L, (r30 & 16) != 0 ? r1.startTime : null, (r30 & 32) != 0 ? r1.endTime : null, (r30 & 64) != 0 ? r1.slot : null, (r30 & 128) != 0 ? r1.type : null, (r30 & 256) != 0 ? r1.jobType : null, (r30 & 512) != 0 ? r1.url : null, (r30 & 1024) != 0 ? r1.requestJson : null, (r30 & 2048) != 0 ? r1.responseJson : null, (r30 & 4096) != 0 ? getData().desc : null);
        return copy;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kntr.app.ad.domain.inspector.core.work.Job
    public void handleSuccessData(RequestJobData newData, String data) {
        Intrinsics.checkNotNullParameter(newData, "newData");
        newData.setResponseJson(data);
    }
}