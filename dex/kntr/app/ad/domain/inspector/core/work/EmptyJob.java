package kntr.app.ad.domain.inspector.core.work;

import kotlin.Metadata;

/* compiled from: Job.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÁ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0002H\u0014¨\u0006\u0006"}, d2 = {"Lkntr/app/ad/domain/inspector/core/work/EmptyJob;", "Lkntr/app/ad/domain/inspector/core/work/Job;", "Lkntr/app/ad/domain/inspector/core/work/EmptyJobData;", "<init>", "()V", "createUpdatedData", "inspector_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class EmptyJob extends Job<EmptyJobData> {
    public static final EmptyJob INSTANCE = new EmptyJob();
    public static final int $stable = 8;

    private EmptyJob() {
        super(EmptyJobData.Companion.createEmptyData());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kntr.app.ad.domain.inspector.core.work.Job
    public EmptyJobData createUpdatedData() {
        return EmptyJobData.copy$default(getData(), null, null, null, 0L, null, null, 63, null);
    }
}