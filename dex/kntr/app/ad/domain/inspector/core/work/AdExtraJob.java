package kntr.app.ad.domain.inspector.core.work;

import kntr.app.ad.common.model.AdSlot;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Job.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lkntr/app/ad/domain/inspector/core/work/AdExtraJob;", "Lkntr/app/ad/domain/inspector/core/work/RequestJob;", "slot", "Lkntr/app/ad/common/model/AdSlot;", "desc", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Lkntr/app/ad/common/model/AdSlot;Ljava/lang/String;)V", "inspector_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AdExtraJob extends RequestJob {
    public static final int $stable = 8;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdExtraJob(AdSlot slot, String desc) {
        super(RequestJobData.Companion.createAdExtraJob(slot, desc), null);
        Intrinsics.checkNotNullParameter(slot, "slot");
    }
}