package kntr.app.ad.domain.inspector.core.work;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kntr.app.ad.domain.alarm.AdAlarmExtraKey;
import kntr.app.ad.domain.inspector.core.work.IJob;
import kntr.app.ad.domain.inspector.model.StageType;
import kntr.app.ad.domain.inspector.model.Status;
import kntr.app.ad.domain.report.internal.ReportBuildInParam;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Stage.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\tH\u0016J\u0010\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\tH\u0016J\u0010\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\tH\u0016J\u001e\u0010\u001c\u001a\u00020\u00182\u0006\u0010\f\u001a\u00020\t2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eH\u0016J\u0010\u0010 \u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\tH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006!"}, d2 = {"Lkntr/app/ad/domain/inspector/core/work/Stage;", "Lkntr/app/ad/domain/inspector/core/work/IStage;", "pipeline", "Lkntr/app/ad/domain/inspector/core/work/Pipeline;", "type", "Lkntr/app/ad/domain/inspector/model/StageType;", "<init>", "(Lkntr/app/ad/domain/inspector/core/work/Pipeline;Lkntr/app/ad/domain/inspector/model/StageType;)V", ReportBuildInParam.ID, RoomRecommendViewModel.EMPTY_CURSOR, "getId", "()Ljava/lang/String;", "name", "getName", "jobs", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/ad/domain/inspector/core/work/IJob;", "getJobs", "()Ljava/util/List;", AdAlarmExtraKey.STATUS, "Lkntr/app/ad/domain/inspector/model/Status;", "getStatus", "()Lkntr/app/ad/domain/inspector/model/Status;", "info", RoomRecommendViewModel.EMPTY_CURSOR, "message", "warning", "error", "addCheckJob", "block", "Lkotlin/Function0;", RoomRecommendViewModel.EMPTY_CURSOR, "addAsyncJob", "inspector_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class Stage implements IStage {
    public static final int $stable = 8;
    private final String id;
    private final String name;
    private final Pipeline pipeline;
    private final StageType type;

    public Stage(Pipeline pipeline, StageType type) {
        Intrinsics.checkNotNullParameter(pipeline, "pipeline");
        Intrinsics.checkNotNullParameter(type, "type");
        this.pipeline = pipeline;
        this.type = type;
        String id = this.pipeline.getId();
        this.id = "stage_" + id + "_" + this.type.name();
        this.name = this.type.getText();
    }

    @Override // kntr.app.ad.domain.inspector.core.work.IStage
    public String getId() {
        return this.id;
    }

    @Override // kntr.app.ad.domain.inspector.core.work.IStage
    public String getName() {
        return this.name;
    }

    @Override // kntr.app.ad.domain.inspector.core.work.IStage
    public List<IJob> getJobs() {
        return this.pipeline.getJobsByType$inspector_debug(this.type);
    }

    @Override // kntr.app.ad.domain.inspector.core.work.IStage
    public Status getStatus() {
        Iterable $this$any$iv;
        IJob it;
        Iterable $this$any$iv2;
        IJob it2;
        IJob it3;
        List jobs = this.pipeline.getJobsByType$inspector_debug(this.type);
        if (!jobs.isEmpty() && !jobs.isEmpty()) {
            List $this$any$iv3 = jobs;
            boolean z = true;
            if (!($this$any$iv3 instanceof Collection) || !$this$any$iv3.isEmpty()) {
                Iterator<T> it4 = $this$any$iv3.iterator();
                while (true) {
                    if (it4.hasNext()) {
                        Object element$iv = it4.next();
                        IJob it5 = (IJob) element$iv;
                        if (it5.getData().getStatus() == Status.FAILED) {
                            it = 1;
                            continue;
                        } else {
                            it = null;
                            continue;
                        }
                        if (it != null) {
                            $this$any$iv = 1;
                            break;
                        }
                    } else {
                        $this$any$iv = null;
                        break;
                    }
                }
            } else {
                $this$any$iv = null;
            }
            if ($this$any$iv != null) {
                return Status.FAILED;
            }
            List $this$any$iv4 = jobs;
            if (!($this$any$iv4 instanceof Collection) || !$this$any$iv4.isEmpty()) {
                Iterator<T> it6 = $this$any$iv4.iterator();
                while (true) {
                    if (it6.hasNext()) {
                        Object element$iv2 = it6.next();
                        IJob it7 = (IJob) element$iv2;
                        if (it7.getData().getStatus() == Status.RUNNING) {
                            it2 = 1;
                            continue;
                        } else {
                            it2 = null;
                            continue;
                        }
                        if (it2 != null) {
                            $this$any$iv2 = 1;
                            break;
                        }
                    } else {
                        $this$any$iv2 = null;
                        break;
                    }
                }
            } else {
                $this$any$iv2 = null;
            }
            if ($this$any$iv2 != null) {
                return Status.RUNNING;
            }
            List $this$all$iv = jobs;
            if (!($this$all$iv instanceof Collection) || !$this$all$iv.isEmpty()) {
                Iterator<T> it8 = $this$all$iv.iterator();
                while (true) {
                    if (!it8.hasNext()) {
                        break;
                    }
                    Object element$iv3 = it8.next();
                    IJob it9 = (IJob) element$iv3;
                    if (it9.getData().getStatus() == Status.SUCCESS) {
                        it3 = 1;
                        continue;
                    } else {
                        it3 = null;
                        continue;
                    }
                    if (it3 == null) {
                        z = false;
                        break;
                    }
                }
            }
            return z ? Status.SUCCESS : Status.PENDING;
        }
        return Status.PENDING;
    }

    @Override // kntr.app.ad.domain.inspector.core.work.IStage
    public void info(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        this.pipeline.addJobToStage$inspector_debug(new PrintJob(PrintType.INFO, "stage", message), this.type);
    }

    @Override // kntr.app.ad.domain.inspector.core.work.IStage
    public void warning(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        this.pipeline.addJobToStage$inspector_debug(new PrintJob(PrintType.WARNING, "stage", message), this.type);
    }

    @Override // kntr.app.ad.domain.inspector.core.work.IStage
    public void error(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        this.pipeline.addJobToStage$inspector_debug(new PrintJob(PrintType.ERROR, "stage", message), this.type);
    }

    @Override // kntr.app.ad.domain.inspector.core.work.IStage
    public void addCheckJob(String name, Function0<Boolean> function0) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(function0, "block");
        CheckJob checkJob = new CheckJob(name);
        try {
            if (((Boolean) function0.invoke()).booleanValue()) {
                IJob.CC.success$default(checkJob, null, 1, null);
            } else {
                IJob.CC.fail$default(checkJob, null, 1, null);
            }
        } catch (Exception e) {
            checkJob.fail("异常: " + e.getMessage());
        }
        this.pipeline.addJobToStage$inspector_debug(checkJob, this.type);
    }

    @Override // kntr.app.ad.domain.inspector.core.work.IStage
    public IJob addAsyncJob(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        AsyncJob job = new AsyncJob(name);
        this.pipeline.addJobToStage$inspector_debug(job, this.type);
        return job;
    }
}