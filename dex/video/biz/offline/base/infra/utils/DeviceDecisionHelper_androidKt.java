package video.biz.offline.base.infra.utils;

import kntr.base.config.KConfig;
import kotlin.Metadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: DeviceDecisionHelper.android.kt */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\u0006\u0010\u0000\u001a\u00020\u0001¨\u0006\u0002"}, d2 = {"checkIfHideExternalSdcard", "", "infra_debug"}, k = 2, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class DeviceDecisionHelper_androidKt {
    public static final boolean checkIfHideExternalSdcard() {
        return KConfig.INSTANCE.ff("dd_download_hide_extsdcard", false);
    }
}