package kntr.app.ad.domain.inspector.core.work;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Job.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0007\u001a\u00020\u0002H\u0014¨\u0006\b"}, d2 = {"Lkntr/app/ad/domain/inspector/core/work/AsyncJob;", "Lkntr/app/ad/domain/inspector/core/work/Job;", "Lkntr/app/ad/domain/inspector/core/work/NormalJobData;", "name", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Ljava/lang/String;)V", "createUpdatedData", "inspector_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AsyncJob extends Job<NormalJobData> {
    public static final int $stable = 8;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AsyncJob(String name) {
        super(NormalJobData.Companion.createJobData(name));
        Intrinsics.checkNotNullParameter(name, "name");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kntr.app.ad.domain.inspector.core.work.Job
    public NormalJobData createUpdatedData() {
        return NormalJobData.copy$default(getData(), null, null, null, 0L, null, null, 63, null);
    }
}