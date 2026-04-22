package tv.danmaku.bili.ui.splash.ad.button;

import android.content.Context;
import android.view.View;
import com.airbnb.lottie.LottieAnimationView;
import com.bilibili.base.BiliGlobalPreferenceHelper;
import com.bilibili.ogv.needle.enhancedunmodifiability.EnhancedUnmodifiabilityKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.ui.splash.utils.SplashConfigKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: SplashButtonHelper.kt */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\f\u0010\u0004\u001a\u00020\u0005*\u00020\u0006H\u0000\u001a\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0003H\u0002\u001a\u0018\u0010\r\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0003H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"TAG", "", "DESIGN_BLACK_COLOR", "", "stopWhenDetach", "", "Lcom/airbnb/lottie/LottieAnimationView;", "PREF_KEY_SPLASH_BUTTON_GUIDE_PREFIX", "isButtonGuideEnable", "", "context", "Landroid/content/Context;", "style", "increaseGuideShowTimes", "splash_debug"}, k = 2, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class SplashButtonHelperKt {
    private static final int DESIGN_BLACK_COLOR = -10394003;
    private static final String PREF_KEY_SPLASH_BUTTON_GUIDE_PREFIX = "splash_button_guide_show_times_";
    private static final String TAG = "[Splash]SplashButtonHelper";

    public static final void stopWhenDetach(final LottieAnimationView $this$stopWhenDetach) {
        Intrinsics.checkNotNullParameter($this$stopWhenDetach, "<this>");
        $this$stopWhenDetach.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: tv.danmaku.bili.ui.splash.ad.button.SplashButtonHelperKt$stopWhenDetach$1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View v) {
                Intrinsics.checkNotNullParameter(v, "v");
                BLog.i("[Splash]SplashButtonHelper", "businessSplashFixLottieOOM, lottie view onViewAttachedToWindow");
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View v) {
                Intrinsics.checkNotNullParameter(v, "v");
                BLog.i("[Splash]SplashButtonHelper", "businessSplashFixLottieOOM, lottie view onViewDetachedFromWindow");
                $this$stopWhenDetach.cancelAnimation();
                $this$stopWhenDetach.removeOnAttachStateChangeListener(this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isButtonGuideEnable(Context context, int style) {
        Context context2 = EnhancedUnmodifiabilityKt.unmodifiable(context);
        String key = PREF_KEY_SPLASH_BUTTON_GUIDE_PREFIX + style;
        return BiliGlobalPreferenceHelper.getBLKVSharedPreference(context2).getInt(key, 0) < SplashConfigKt.getSplashGuideButtonMaxShowTime();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void increaseGuideShowTimes(Context context, int style) {
        Context context2 = EnhancedUnmodifiabilityKt.unmodifiable(context);
        String key = PREF_KEY_SPLASH_BUTTON_GUIDE_PREFIX + style;
        int origin = BiliGlobalPreferenceHelper.getBLKVSharedPreference(context2).getInt(key, 0);
        BiliGlobalPreferenceHelper.getBLKVSharedPreference(context2).edit().putInt(key, origin + 1).apply();
    }
}