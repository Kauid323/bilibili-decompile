package tv.danmaku.bili.splash.ad.button;

import android.content.Context;
import com.bilibili.base.BiliGlobalPreferenceHelper;
import kotlin.Metadata;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.splash.ad.utils.SplashConfigKt;

/* compiled from: SplashButtonHelper.kt */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u001a\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0003H\u0002\u001a\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0003H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"TAG", "", "DESIGN_BLACK_COLOR", "", "PREF_KEY_SPLASH_BUTTON_GUIDE_PREFIX", "isButtonGuideEnable", "", "context", "Landroid/content/Context;", "style", "increaseGuideShowTimes", "", "adsplash_debug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class SplashButtonHelperKt {
    private static final int DESIGN_BLACK_COLOR = -10394003;
    private static final String PREF_KEY_SPLASH_BUTTON_GUIDE_PREFIX = "splash_button_guide_show_times_";
    private static final String TAG = "[Splash]SplashButtonHelper";

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isButtonGuideEnable(Context context, int style) {
        String key = PREF_KEY_SPLASH_BUTTON_GUIDE_PREFIX + style;
        return BiliGlobalPreferenceHelper.getBLKVSharedPreference(context).getInt(key, 0) < SplashConfigKt.getSplashGuideButtonMaxShowTime();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void increaseGuideShowTimes(Context context, int style) {
        String key = PREF_KEY_SPLASH_BUTTON_GUIDE_PREFIX + style;
        int origin = BiliGlobalPreferenceHelper.getBLKVSharedPreference(context).getInt(key, 0);
        BiliGlobalPreferenceHelper.getBLKVSharedPreference(context).edit().putInt(key, origin + 1).apply();
    }
}