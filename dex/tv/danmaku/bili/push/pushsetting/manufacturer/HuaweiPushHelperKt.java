package tv.danmaku.bili.push.pushsetting.manufacturer;

import kotlin.Metadata;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;

/* compiled from: HuaweiPushHelper.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\b\u0010\u0004\u001a\u00020\u0005H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"TAG", "", "huaweiManufacturerDialogShowIntervalMs", "", "checkCanShowHuaweiPushDialog", "", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class HuaweiPushHelperKt {
    private static final String TAG = "[Push]HuaweiPushHelper";
    private static final long huaweiManufacturerDialogShowIntervalMs = 172800000;

    public static final boolean checkCanShowHuaweiPushDialog() {
        if (System.currentTimeMillis() - ManufacturerPushHelperKt.getLastRequestManufacturerPushTimestamp() < huaweiManufacturerDialogShowIntervalMs) {
            BLog.i(TAG, "checkCanShowHuaweiPushDialog, can't show cause by rate limit");
            return false;
        }
        return true;
    }
}