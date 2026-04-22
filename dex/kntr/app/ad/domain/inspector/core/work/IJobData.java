package kntr.app.ad.domain.inspector.core.work;

import kntr.app.ad.domain.alarm.AdAlarmExtraKey;
import kntr.app.ad.domain.inspector.model.Status;
import kntr.app.ad.domain.report.internal.ReportBuildInParam;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;

/* compiled from: JobData.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0012\u0010\b\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u0004\u0018\u00010\tX¦\u000e¢\u0006\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u0004\u0018\u00010\tX¦\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u0018\u0010\u0014\u001a\u00020\u0015X¦\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019\u0082\u0001\u0005\u001a\u001b\u001c\u001d\u001e¨\u0006\u001fÀ\u0006\u0003"}, d2 = {"Lkntr/app/ad/domain/inspector/core/work/IJobData;", RoomRecommendViewModel.EMPTY_CURSOR, ReportBuildInParam.ID, RoomRecommendViewModel.EMPTY_CURSOR, "getId", "()Ljava/lang/String;", "name", "getName", "timestamp", RoomRecommendViewModel.EMPTY_CURSOR, "getTimestamp", "()J", "startTime", "getStartTime", "()Ljava/lang/Long;", "setStartTime", "(Ljava/lang/Long;)V", "endTime", "getEndTime", "setEndTime", AdAlarmExtraKey.STATUS, "Lkntr/app/ad/domain/inspector/model/Status;", "getStatus", "()Lkntr/app/ad/domain/inspector/model/Status;", "setStatus", "(Lkntr/app/ad/domain/inspector/model/Status;)V", "Lkntr/app/ad/domain/inspector/core/work/EmptyJobData;", "Lkntr/app/ad/domain/inspector/core/work/NormalJobData;", "Lkntr/app/ad/domain/inspector/core/work/PrintJobData;", "Lkntr/app/ad/domain/inspector/core/work/ReportJobData;", "Lkntr/app/ad/domain/inspector/core/work/RequestJobData;", "inspector_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface IJobData {
    Long getEndTime();

    String getId();

    String getName();

    Long getStartTime();

    Status getStatus();

    long getTimestamp();

    void setEndTime(Long l);

    void setStartTime(Long l);

    void setStatus(Status status);
}