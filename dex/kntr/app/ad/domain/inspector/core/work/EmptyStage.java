package kntr.app.ad.domain.inspector.core.work;

import java.util.List;
import kntr.app.ad.domain.alarm.AdAlarmExtraKey;
import kntr.app.ad.domain.inspector.model.Status;
import kntr.app.ad.domain.report.internal.ReportBuildInParam;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Stage.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0005H\u0016J\u0010\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0005H\u0016J\u0010\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0005H\u0016J\u001e\u0010\u0018\u001a\u00020\u00142\u0006\u0010\b\u001a\u00020\u00052\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH\u0016J\u0010\u0010\u001c\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\u0005H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001d"}, d2 = {"Lkntr/app/ad/domain/inspector/core/work/EmptyStage;", "Lkntr/app/ad/domain/inspector/core/work/IStage;", "<init>", "()V", ReportBuildInParam.ID, RoomRecommendViewModel.EMPTY_CURSOR, "getId", "()Ljava/lang/String;", "name", "getName", AdAlarmExtraKey.STATUS, "Lkntr/app/ad/domain/inspector/model/Status;", "getStatus", "()Lkntr/app/ad/domain/inspector/model/Status;", "jobs", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/ad/domain/inspector/core/work/IJob;", "getJobs", "()Ljava/util/List;", "info", RoomRecommendViewModel.EMPTY_CURSOR, "message", "warning", "error", "addCheckJob", "block", "Lkotlin/Function0;", RoomRecommendViewModel.EMPTY_CURSOR, "addAsyncJob", "inspector_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class EmptyStage implements IStage {
    public static final EmptyStage INSTANCE = new EmptyStage();
    private static final String id = RoomRecommendViewModel.EMPTY_CURSOR;
    private static final String name = RoomRecommendViewModel.EMPTY_CURSOR;
    private static final Status status = Status.PENDING;
    private static final List<IJob> jobs = CollectionsKt.emptyList();
    public static final int $stable = 8;

    private EmptyStage() {
    }

    @Override // kntr.app.ad.domain.inspector.core.work.IStage
    public String getId() {
        return id;
    }

    @Override // kntr.app.ad.domain.inspector.core.work.IStage
    public String getName() {
        return name;
    }

    @Override // kntr.app.ad.domain.inspector.core.work.IStage
    public Status getStatus() {
        return status;
    }

    @Override // kntr.app.ad.domain.inspector.core.work.IStage
    public List<IJob> getJobs() {
        return jobs;
    }

    @Override // kntr.app.ad.domain.inspector.core.work.IStage
    public void info(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
    }

    @Override // kntr.app.ad.domain.inspector.core.work.IStage
    public void warning(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
    }

    @Override // kntr.app.ad.domain.inspector.core.work.IStage
    public void error(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
    }

    @Override // kntr.app.ad.domain.inspector.core.work.IStage
    public void addCheckJob(String name2, Function0<Boolean> function0) {
        Intrinsics.checkNotNullParameter(name2, "name");
        Intrinsics.checkNotNullParameter(function0, "block");
    }

    @Override // kntr.app.ad.domain.inspector.core.work.IStage
    public IJob addAsyncJob(String name2) {
        Intrinsics.checkNotNullParameter(name2, "name");
        return EmptyJob.INSTANCE;
    }
}