package kntr.app.ad.domain.report.internal.inspector;

import kntr.app.ad.domain.inspector.AdInspectorManager;
import kntr.app.ad.domain.inspector.core.work.IJob;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InteractingJobListener.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\t\u001a\u00020\nH\u0016J\u001a\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lkntr/app/ad/domain/report/internal/inspector/InteractingJobListener;", "Lkntr/app/ad/domain/report/internal/inspector/IInspectorListener;", "adCb", RoomRecommendViewModel.EMPTY_CURSOR, "name", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "job", "Lkntr/app/ad/domain/inspector/core/work/IJob;", "reportSuccess", RoomRecommendViewModel.EMPTY_CURSOR, "reportError", "code", RoomRecommendViewModel.EMPTY_CURSOR, "dsc", "report_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class InteractingJobListener implements IInspectorListener {
    private final IJob job;

    public InteractingJobListener(String adCb, String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.job = AdInspectorManager.INSTANCE.getInteractingStage(adCb).addAsyncJob(name);
        this.job.start();
    }

    @Override // kntr.app.ad.domain.report.internal.inspector.IInspectorListener
    public void reportSuccess() {
        IJob.CC.success$default(this.job, null, 1, null);
    }

    @Override // kntr.app.ad.domain.report.internal.inspector.IInspectorListener
    public void reportError(int code, String dsc) {
        this.job.fail("code=" + code + ", desc=" + dsc);
    }
}