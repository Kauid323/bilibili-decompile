package tv.danmaku.bili.ui.splash.event;

import com.bilibili.lib.blconfig.ConfigManager;
import kotlin.Metadata;
import kotlin.text.StringsKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: EventSplashFragment.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"TAG", "", "KEY_EVENT_SPLASH_DATA", "delayHideEventSplashTime", "", "splash_debug"}, k = 2, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class EventSplashFragmentKt {
    public static final String KEY_EVENT_SPLASH_DATA = "key:event:splash:data";
    private static final String TAG = "[EventSplash]EventSplashFragment";
    private static final long delayHideEventSplashTime;

    static {
        Long longOrNull;
        String str = (String) ConfigManager.Companion.config().get("splash.event_splash_jump_delay_time", "1000");
        delayHideEventSplashTime = (str == null || (longOrNull = StringsKt.toLongOrNull(str)) == null) ? 1000L : longOrNull.longValue();
    }
}