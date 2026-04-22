package kntr.app.ad.domain.inspector.core.work;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Job.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\b\u0010\n\u001a\u00020\u0002H\u0014¨\u0006\u000b"}, d2 = {"Lkntr/app/ad/domain/inspector/core/work/PrintJob;", "Lkntr/app/ad/domain/inspector/core/work/Job;", "Lkntr/app/ad/domain/inspector/core/work/PrintJobData;", "type", "Lkntr/app/ad/domain/inspector/core/work/PrintType;", "tag", RoomRecommendViewModel.EMPTY_CURSOR, "msg", "<init>", "(Lkntr/app/ad/domain/inspector/core/work/PrintType;Ljava/lang/String;Ljava/lang/String;)V", "createUpdatedData", "inspector_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PrintJob extends Job<PrintJobData> {
    public static final int $stable = 8;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PrintJob(PrintType type, String tag, String msg) {
        super(PrintJobData.Companion.createJobData(type, tag, msg));
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kntr.app.ad.domain.inspector.core.work.Job
    public PrintJobData createUpdatedData() {
        PrintJobData copy;
        copy = r1.copy((r20 & 1) != 0 ? r1.id : null, (r20 & 2) != 0 ? r1.name : null, (r20 & 4) != 0 ? r1.status : null, (r20 & 8) != 0 ? r1.timestamp : 0L, (r20 & 16) != 0 ? r1.startTime : null, (r20 & 32) != 0 ? r1.endTime : null, (r20 & 64) != 0 ? r1.type : null, (r20 & 128) != 0 ? getData().msg : null);
        return copy;
    }
}