package tv.danmaku.bili.ui.rank.utils;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: RankSpmidConstants.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a\u000e\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"PV_FORMAT", "", "SPMID_RANK_FRAGMENT_SQUARE", "spmidToPv", "spmid", "rank_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class RankSpmidConstantsKt {
    public static final String PV_FORMAT = "%s.pv";
    public static final String SPMID_RANK_FRAGMENT_SQUARE = "creation.hot-ranking.0.0";

    public static final String spmidToPv(String spmid) {
        Intrinsics.checkNotNullParameter(spmid, "spmid");
        String format = String.format(PV_FORMAT, Arrays.copyOf(new Object[]{spmid}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }
}