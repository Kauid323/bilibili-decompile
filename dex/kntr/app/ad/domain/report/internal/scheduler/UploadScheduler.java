package kntr.app.ad.domain.report.internal.scheduler;

import java.util.concurrent.CancellationException;
import kntr.app.ad.domain.report.internal.ReportConfig;
import kntr.app.ad.domain.report.internal.cache.IReportStorageManager;
import kntr.app.ad.domain.report.internal.upload.IReportUploader;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.log.KLog_androidKt;
import kntr.base.utils.CoroutineExJvmKt;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* compiled from: UploadScheduler.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0007H\u0016J\b\u0010\u0015\u001a\u00020\u0013H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lkntr/app/ad/domain/report/internal/scheduler/UploadScheduler;", "Lkntr/app/ad/domain/report/internal/scheduler/IUploadScheduler;", "persistence", "Lkntr/app/ad/domain/report/internal/cache/IReportStorageManager;", "dataUploader", "Lkntr/app/ad/domain/report/internal/upload/IReportUploader;", "supportBatch", RoomRecommendViewModel.EMPTY_CURSOR, "config", "Lkntr/app/ad/domain/report/internal/ReportConfig;", "<init>", "(Lkntr/app/ad/domain/report/internal/cache/IReportStorageManager;Lkntr/app/ad/domain/report/internal/upload/IReportUploader;ZLkntr/app/ad/domain/report/internal/ReportConfig;)V", "scope", "Lkotlinx/coroutines/CoroutineScope;", "job", "Lkotlinx/coroutines/Job;", "runnable", "Lkntr/app/ad/domain/report/internal/scheduler/UploadRunnable;", "startScheduling", RoomRecommendViewModel.EMPTY_CURSOR, "isFromStartUp", "stopScheduling", "report_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class UploadScheduler implements IUploadScheduler {
    private final ReportConfig config;
    private final IReportUploader dataUploader;
    private Job job;
    private final IReportStorageManager persistence;
    private final UploadRunnable runnable;
    private final CoroutineScope scope;
    private final boolean supportBatch;

    public UploadScheduler(IReportStorageManager persistence, IReportUploader dataUploader, boolean supportBatch, ReportConfig config) {
        Intrinsics.checkNotNullParameter(persistence, "persistence");
        Intrinsics.checkNotNullParameter(dataUploader, "dataUploader");
        Intrinsics.checkNotNullParameter(config, "config");
        this.persistence = persistence;
        this.dataUploader = dataUploader;
        this.supportBatch = supportBatch;
        this.config = config;
        this.scope = CoroutineScopeKt.CoroutineScope(CoroutineExJvmKt.getIoContext().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));
        this.runnable = new UploadRunnable(this.persistence, this.dataUploader, this.config, this.supportBatch);
    }

    @Override // kntr.app.ad.domain.report.internal.scheduler.IUploadScheduler
    public void startScheduling(boolean isFromStartUp) {
        if (isFromStartUp) {
            KLog_androidKt.getKLog().d("AdReport", "UploadScheduler startScheduling from startup");
            this.job = BuildersKt.launch$default(this.scope, (CoroutineContext) null, (CoroutineStart) null, new UploadScheduler$startScheduling$1(this, null), 3, (Object) null);
            return;
        }
        KLog_androidKt.getKLog().d("AdReport", "UploadScheduler startScheduling from api");
        this.job = BuildersKt.launch$default(this.scope, (CoroutineContext) null, (CoroutineStart) null, new UploadScheduler$startScheduling$2(this, null), 3, (Object) null);
    }

    @Override // kntr.app.ad.domain.report.internal.scheduler.IUploadScheduler
    public void stopScheduling() {
        Job job = this.job;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.job = null;
    }
}