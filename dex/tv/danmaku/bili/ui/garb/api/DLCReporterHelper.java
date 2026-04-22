package tv.danmaku.bili.ui.garb.api;

import android.util.ArrayMap;
import com.bilibili.lib.neuron.api.Neurons;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: DLCReporterHelper.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\b\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J.\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u000bJF\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u000bJF\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u000bJF\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u000bJF\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Ltv/danmaku/bili/ui/garb/api/DLCReporterHelper;", "", "<init>", "()V", "DLC_CARD_SET_AVATAR_HEADER_RESULT_SHOW", "", "DLC_CARD_SKIP_ANIM_CLICK", "DLC_CARD_CLICK", "DLC_CARD_RESULT_SUCCESS_SHOW", "DLC_CARD_API_SUCCESS_SHOW", "DLC_SET_AVATAR_TYPE", "", "DLC_SET_HEADER_TYPE", "reportDLCSetAvatarHeaderClick", "", "actId", "from", "fromId", "fSource", "settingType", "reportCardSkipAnim", "", "lotteryId", "activityStatus", "lotteryNum", "pageType", "reportDrawCardClick", "reportDrawCardApiSuccess", "reportDrawCardResultShow", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class DLCReporterHelper {
    public static final int $stable = 0;
    private static final String DLC_CARD_API_SUCCESS_SHOW = "sqzz.activity.main-page.draw-success.show";
    private static final String DLC_CARD_CLICK = "sqzz.activity.card-result.draw.click";
    private static final String DLC_CARD_RESULT_SUCCESS_SHOW = "sqzz.activity.card-result.draw-result.show";
    private static final String DLC_CARD_SET_AVATAR_HEADER_RESULT_SHOW = "sqzz.activity.main-page.use-result.show";
    private static final String DLC_CARD_SKIP_ANIM_CLICK = "sqzz.activity.main-page.skip-animation.click";
    public static final int DLC_SET_AVATAR_TYPE = 1;
    public static final int DLC_SET_HEADER_TYPE = 2;
    public static final DLCReporterHelper INSTANCE = new DLCReporterHelper();

    private DLCReporterHelper() {
    }

    public final void reportDLCSetAvatarHeaderClick(int actId, String from, String fromId, String fSource, int settingType) {
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(fromId, "fromId");
        Intrinsics.checkNotNullParameter(fSource, "fSource");
        ArrayMap params = new ArrayMap();
        params.put("activity_id", String.valueOf(actId));
        params.put("from", from);
        params.put("from_id", fromId);
        params.put("f_source", fSource);
        params.put("setting_type", String.valueOf(settingType));
        Neurons.reportExposure$default(false, DLC_CARD_SET_AVATAR_HEADER_RESULT_SHOW, params, (List) null, 8, (Object) null);
    }

    public final void reportCardSkipAnim(long actId, long lotteryId, int activityStatus, int lotteryNum, String from, String fromId, String fSource, int pageType) {
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(fromId, "fromId");
        Intrinsics.checkNotNullParameter(fSource, "fSource");
        ArrayMap params = new ArrayMap();
        params.put("activity_id", String.valueOf(actId));
        params.put("lottery_id", String.valueOf(lotteryId));
        params.put("activity_status", String.valueOf(activityStatus));
        params.put("draw_num", String.valueOf(lotteryNum));
        params.put("from", from);
        params.put("from_id", fromId);
        params.put("f_source", fSource);
        params.put("page_type", String.valueOf(pageType));
        Neurons.reportClick(false, DLC_CARD_SKIP_ANIM_CLICK, params);
    }

    public final void reportDrawCardClick(long actId, long lotteryId, int activityStatus, int lotteryNum, String from, String fromId, String fSource, int pageType) {
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(fromId, "fromId");
        Intrinsics.checkNotNullParameter(fSource, "fSource");
        ArrayMap params = new ArrayMap();
        params.put("activity_id", String.valueOf(actId));
        params.put("pot_id", String.valueOf(lotteryId));
        params.put("lottery_id", String.valueOf(lotteryId));
        params.put("activity_status", String.valueOf(activityStatus));
        params.put("draw_num", String.valueOf(lotteryNum));
        params.put("from", from);
        params.put("from_id", fromId);
        params.put("f_source", fSource);
        params.put("page_type", String.valueOf(pageType));
        Neurons.reportClick(false, DLC_CARD_CLICK, params);
    }

    public final void reportDrawCardApiSuccess(long actId, long lotteryId, int activityStatus, int lotteryNum, String from, String fromId, String fSource, int pageType) {
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(fromId, "fromId");
        Intrinsics.checkNotNullParameter(fSource, "fSource");
        ArrayMap params = new ArrayMap();
        params.put("activity_id", String.valueOf(actId));
        params.put("pot_id", String.valueOf(lotteryId));
        params.put("lottery_id", String.valueOf(lotteryId));
        params.put("activity_status", String.valueOf(activityStatus));
        params.put("draw_num", String.valueOf(lotteryNum));
        params.put("from", from);
        params.put("from_id", fromId);
        params.put("f_source", fSource);
        params.put("page_type", String.valueOf(pageType));
        Neurons.reportExposure$default(false, DLC_CARD_API_SUCCESS_SHOW, params, (List) null, 8, (Object) null);
    }

    public final void reportDrawCardResultShow(long actId, long lotteryId, int activityStatus, int lotteryNum, String from, String fromId, String fSource, int pageType) {
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(fromId, "fromId");
        Intrinsics.checkNotNullParameter(fSource, "fSource");
        ArrayMap params = new ArrayMap();
        params.put("activity_id", String.valueOf(actId));
        params.put("pot_id", String.valueOf(lotteryId));
        params.put("lottery_id", String.valueOf(lotteryId));
        params.put("activity_status", String.valueOf(activityStatus));
        params.put("draw_num", String.valueOf(lotteryNum));
        params.put("from", from);
        params.put("from_id", fromId);
        params.put("f_source", fSource);
        params.put("page_type", String.valueOf(pageType));
        Neurons.reportExposure$default(false, DLC_CARD_RESULT_SUCCESS_SHOW, params, (List) null, 8, (Object) null);
    }
}