package kntr.app.ad.domain.inspector.core.work;

import kntr.app.ad.common.model.AdSlot;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Job.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lkntr/app/ad/domain/inspector/core/work/ApiJob;", "Lkntr/app/ad/domain/inspector/core/work/RequestJob;", "slot", "Lkntr/app/ad/common/model/AdSlot;", "url", RoomRecommendViewModel.EMPTY_CURSOR, "requestJson", "desc", "<init>", "(Lkntr/app/ad/common/model/AdSlot;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "inspector_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ApiJob extends RequestJob {
    public static final int $stable = 8;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ApiJob(AdSlot slot, String url, String requestJson, String desc) {
        super(RequestJobData.Companion.createApiJob(slot, url, requestJson, desc), null);
        Intrinsics.checkNotNullParameter(slot, "slot");
    }

    public /* synthetic */ ApiJob(AdSlot adSlot, String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(adSlot, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3);
    }
}