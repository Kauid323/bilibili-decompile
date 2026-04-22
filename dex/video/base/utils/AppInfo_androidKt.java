package video.base.utils;

import kotlin.Metadata;
import tv.danmaku.android.util.AppBuildConfig;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: AppInfo.android.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\"\u0011\u0010\u0000\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0000\u0010\u0002¨\u0006\u0003"}, d2 = {"isHDApp", "", "()Z", "base_debug"}, k = 2, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class AppInfo_androidKt {
    private static final boolean isHDApp = AppBuildConfig.Companion.isHDApp();

    public static final boolean isHDApp() {
        return isHDApp;
    }
}