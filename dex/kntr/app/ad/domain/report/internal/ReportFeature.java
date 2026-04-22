package kntr.app.ad.domain.report.internal;

import kntr.app.ad.domain.report.internal.cache.IReportStorageManager;
import kntr.app.ad.domain.report.internal.scheduler.IUploadScheduler;
import kntr.app.ad.domain.report.internal.scheduler.UploadScheduler;
import kntr.app.ad.domain.report.internal.upload.IReportUploader;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.log.KLog_androidKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.atomicfu.AtomicBoolean;
import kotlinx.atomicfu.AtomicFU;

/* compiled from: ReportFeature.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\b \u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0014\u001a\u00020\u0015J\b\u0010\u0016\u001a\u00020\u0015H\u0002J\b\u0010\u0017\u001a\u00020\u0007H&J\b\u0010\u0018\u001a\u00020\rH&J\u0010\u0010\u0019\u001a\u00020\u00152\b\b\u0002\u0010\u001a\u001a\u00020\u001bJ\b\u0010\u001c\u001a\u00020\u001bH\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lkntr/app/ad/domain/report/internal/ReportFeature;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "initialized", "Lkotlinx/atomicfu/AtomicBoolean;", "storageManager", "Lkntr/app/ad/domain/report/internal/cache/IReportStorageManager;", "getStorageManager", "()Lkntr/app/ad/domain/report/internal/cache/IReportStorageManager;", "setStorageManager", "(Lkntr/app/ad/domain/report/internal/cache/IReportStorageManager;)V", "uploader", "Lkntr/app/ad/domain/report/internal/upload/IReportUploader;", "getUploader", "()Lkntr/app/ad/domain/report/internal/upload/IReportUploader;", "setUploader", "(Lkntr/app/ad/domain/report/internal/upload/IReportUploader;)V", "scheduler", "Lkntr/app/ad/domain/report/internal/scheduler/IUploadScheduler;", "startup", RoomRecommendViewModel.EMPTY_CURSOR, "setupUploadScheduler", "createStorageManager", "createUploader", "startSchedulingRetryTask", "isFromStartUp", RoomRecommendViewModel.EMPTY_CURSOR, "supportBatch", "report_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class ReportFeature {
    private final AtomicBoolean initialized = AtomicFU.atomic(false);
    private IUploadScheduler scheduler;
    public IReportStorageManager storageManager;
    public IReportUploader uploader;

    public abstract IReportStorageManager createStorageManager();

    public abstract IReportUploader createUploader();

    public final IReportStorageManager getStorageManager() {
        IReportStorageManager iReportStorageManager = this.storageManager;
        if (iReportStorageManager != null) {
            return iReportStorageManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("storageManager");
        return null;
    }

    public final void setStorageManager(IReportStorageManager iReportStorageManager) {
        Intrinsics.checkNotNullParameter(iReportStorageManager, "<set-?>");
        this.storageManager = iReportStorageManager;
    }

    public final IReportUploader getUploader() {
        IReportUploader iReportUploader = this.uploader;
        if (iReportUploader != null) {
            return iReportUploader;
        }
        Intrinsics.throwUninitializedPropertyAccessException("uploader");
        return null;
    }

    public final void setUploader(IReportUploader iReportUploader) {
        Intrinsics.checkNotNullParameter(iReportUploader, "<set-?>");
        this.uploader = iReportUploader;
    }

    public final void startup() {
        if (!this.initialized.compareAndSet(false, true)) {
            return;
        }
        setStorageManager(createStorageManager());
        setUploader(createUploader());
        setupUploadScheduler();
        startSchedulingRetryTask(true);
    }

    private final void setupUploadScheduler() {
        UploadScheduler uploadScheduler;
        if (ReportUtil_androidKt.isMainProcess()) {
            KLog_androidKt.getKLog().d("AdReport", "ReportFeature setupUploadScheduler");
            uploadScheduler = new UploadScheduler(getStorageManager(), getUploader(), supportBatch(), new ReportConfig(0L, 0, 0L, 0L, 0, null, 63, null));
        } else {
            KLog_androidKt.getKLog().d("AdReport", "ReportFeature skip setupUploadScheduler in non-main process");
            uploadScheduler = null;
        }
        this.scheduler = uploadScheduler;
    }

    public static /* synthetic */ void startSchedulingRetryTask$default(ReportFeature reportFeature, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: startSchedulingRetryTask");
        }
        if ((i & 1) != 0) {
            z = false;
        }
        reportFeature.startSchedulingRetryTask(z);
    }

    public final void startSchedulingRetryTask(boolean isFromStartUp) {
        IUploadScheduler iUploadScheduler = this.scheduler;
        if (iUploadScheduler != null) {
            iUploadScheduler.startScheduling(isFromStartUp);
        }
    }

    protected boolean supportBatch() {
        return false;
    }
}