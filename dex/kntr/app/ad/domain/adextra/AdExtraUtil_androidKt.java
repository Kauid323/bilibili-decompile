package kntr.app.ad.domain.adextra;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AdExtraUtil.android.kt */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0001H\u0000¨\u0006\u0002"}, d2 = {"adAES", RoomRecommendViewModel.EMPTY_CURSOR, "adextra_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class AdExtraUtil_androidKt {
    public static final String adAES(String $this$adAES) {
        Intrinsics.checkNotNullParameter($this$adAES, "<this>");
        return AesCryptor.Companion.encryptAES($this$adAES);
    }
}