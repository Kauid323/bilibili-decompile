package kntr.app.ad.domain.inspector.core.work;

import kntr.app.ad.domain.alarm.AdAlarmExtraKey;
import kntr.app.ad.domain.inspector.model.StageType;
import kntr.app.ad.domain.inspector.model.Status;
import kntr.app.ad.domain.report.internal.ReportBuildInParam;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;

/* compiled from: Pipeline.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0012\u0010\b\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u0010À\u0006\u0003"}, d2 = {"Lkntr/app/ad/domain/inspector/core/work/IPipeline;", RoomRecommendViewModel.EMPTY_CURSOR, ReportBuildInParam.ID, RoomRecommendViewModel.EMPTY_CURSOR, "getId", "()Ljava/lang/String;", "name", "getName", AdAlarmExtraKey.STATUS, "Lkntr/app/ad/domain/inspector/model/Status;", "getStatus", "()Lkntr/app/ad/domain/inspector/model/Status;", "getStage", "Lkntr/app/ad/domain/inspector/core/work/IStage;", "type", "Lkntr/app/ad/domain/inspector/model/StageType;", "inspector_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface IPipeline {
    String getId();

    String getName();

    IStage getStage(StageType stageType);

    Status getStatus();
}