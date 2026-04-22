package kntr.app.ad.domain.inspector.core.work;

import java.util.List;
import kntr.app.ad.domain.alarm.AdAlarmExtraKey;
import kntr.app.ad.domain.inspector.model.Status;
import kntr.app.ad.domain.report.internal.ReportBuildInParam;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: Stage.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0003H'J\u0010\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0003H&J\u0010\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0003H'J\u001e\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u00032\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H&J\u0010\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u0003H'R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0012\u0010\b\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001bÀ\u0006\u0003"}, d2 = {"Lkntr/app/ad/domain/inspector/core/work/IStage;", RoomRecommendViewModel.EMPTY_CURSOR, ReportBuildInParam.ID, RoomRecommendViewModel.EMPTY_CURSOR, "getId", "()Ljava/lang/String;", "name", "getName", AdAlarmExtraKey.STATUS, "Lkntr/app/ad/domain/inspector/model/Status;", "getStatus", "()Lkntr/app/ad/domain/inspector/model/Status;", "jobs", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/ad/domain/inspector/core/work/IJob;", "getJobs", "()Ljava/util/List;", "info", RoomRecommendViewModel.EMPTY_CURSOR, "message", "warning", "error", "addCheckJob", "block", "Lkotlin/Function0;", RoomRecommendViewModel.EMPTY_CURSOR, "addAsyncJob", "inspector_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface IStage {
    IJob addAsyncJob(String str);

    void addCheckJob(String str, Function0<Boolean> function0);

    void error(String str);

    String getId();

    List<IJob> getJobs();

    String getName();

    Status getStatus();

    void info(String str);

    void warning(String str);
}