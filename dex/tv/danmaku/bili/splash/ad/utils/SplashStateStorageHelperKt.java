package tv.danmaku.bili.splash.ad.utils;

import android.content.SharedPreferences;
import com.bilibili.app.comm.list.widget.utils.SharedPreferencesField;
import com.bilibili.base.BiliGlobalPreferenceHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import tv.danmaku.bili.BR;

/* compiled from: SplashStateStorageHelper.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\r\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000\"$\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00038F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t\"+\u0010\u000b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00038F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\t¨\u0006\u0010"}, d2 = {"SP_SPLASH_LAST_REQUEST_INTERVAL_MS", "", "DEFAULT_INTERVAL_FOR_PULL_MS", "", "value", "splashLastRequestIntervalMs", "getSplashLastRequestIntervalMs", "()J", "setSplashLastRequestIntervalMs", "(J)V", "<set-?>", "clickGuideShowCountOfElementAnimation", "getClickGuideShowCountOfElementAnimation", "setClickGuideShowCountOfElementAnimation", "clickGuideShowCountOfElementAnimation$delegate", "Lcom/bilibili/app/comm/list/widget/utils/SharedPreferencesField;", "adsplash_debug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class SplashStateStorageHelperKt {
    private static final String SP_SPLASH_LAST_REQUEST_INTERVAL_MS = "sp_splash_last_request_interval";
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty0(new MutablePropertyReference0Impl(SplashStateStorageHelperKt.class, "clickGuideShowCountOfElementAnimation", "getClickGuideShowCountOfElementAnimation()J", 1))};
    private static long DEFAULT_INTERVAL_FOR_PULL_MS = 900000;
    private static final SharedPreferencesField clickGuideShowCountOfElementAnimation$delegate = new SharedPreferencesField("sp_splash_element_animation_click_guide_show_count", 0L, (SharedPreferences) null, 4, (DefaultConstructorMarker) null);

    public static final long getSplashLastRequestIntervalMs() {
        SharedPreferences bLKVSharedPreference = BiliGlobalPreferenceHelper.getBLKVSharedPreference();
        if (bLKVSharedPreference != null) {
            return bLKVSharedPreference.getLong(SP_SPLASH_LAST_REQUEST_INTERVAL_MS, DEFAULT_INTERVAL_FOR_PULL_MS);
        }
        return DEFAULT_INTERVAL_FOR_PULL_MS;
    }

    public static final void setSplashLastRequestIntervalMs(long value) {
        SharedPreferences.Editor edit;
        SharedPreferences bLKVSharedPreference = BiliGlobalPreferenceHelper.getBLKVSharedPreference();
        if (bLKVSharedPreference != null && (edit = bLKVSharedPreference.edit()) != null) {
            SharedPreferences.Editor putLong = edit.putLong(SP_SPLASH_LAST_REQUEST_INTERVAL_MS, value > 0 ? value : DEFAULT_INTERVAL_FOR_PULL_MS);
            if (putLong != null) {
                putLong.apply();
            }
        }
    }

    public static final long getClickGuideShowCountOfElementAnimation() {
        return ((Number) clickGuideShowCountOfElementAnimation$delegate.getValue((Object) null, $$delegatedProperties[0])).longValue();
    }

    public static final void setClickGuideShowCountOfElementAnimation(long j) {
        clickGuideShowCountOfElementAnimation$delegate.setValue((Object) null, $$delegatedProperties[0], Long.valueOf(j));
    }
}