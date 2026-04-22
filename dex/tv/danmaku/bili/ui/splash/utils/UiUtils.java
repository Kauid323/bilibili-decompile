package tv.danmaku.bili.ui.splash.utils;

import android.app.Activity;
import android.app.Application;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.ViewTreeObserver;
import android.view.Window;
import androidx.core.graphics.drawable.DrawableCompat;
import com.bilibili.base.BiliContext;
import com.bilibili.lib.ui.helper.NotchCompat;
import com.bilibili.lib.ui.util.MultipleThemeUtils;
import com.bilibili.lib.ui.util.StatusBarCompat;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* compiled from: UiUtils.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0007J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0007J\u0010\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0005J\u0010\u0010\u0012\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u0010\u0010\u0013\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r¨\u0006\u0014"}, d2 = {"Ltv/danmaku/bili/ui/splash/utils/UiUtils;", "", "<init>", "()V", "dp2Px", "", "dp", "", "px2dp", "px", "immersive", "", "activity", "Landroid/app/Activity;", "tintDrawable", "Landroid/graphics/drawable/Drawable;", "origin", "color", "transportStatusBarV2", "transportStatusBarV3", "splash_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class UiUtils {
    public static final int $stable = 0;
    public static final UiUtils INSTANCE = new UiUtils();

    private UiUtils() {
    }

    @JvmStatic
    public static final int dp2Px(int dp) {
        return (int) TypedValue.applyDimension(1, dp, Resources.getSystem().getDisplayMetrics());
    }

    @JvmStatic
    public static final int dp2Px(float dp) {
        return (int) TypedValue.applyDimension(1, dp, Resources.getSystem().getDisplayMetrics());
    }

    @JvmStatic
    public static final float px2dp(float px) {
        Resources resources;
        Application application = BiliContext.application();
        if (application == null || (resources = application.getResources()) == null) {
            return px;
        }
        float density = resources.getDisplayMetrics().density;
        return px / density;
    }

    public final void immersive(final Activity activity) {
        final Window window;
        BLog.i("[Splash]UiUtils", "immersive,start");
        if (activity != null && (window = activity.getWindow()) != null) {
            window.clearFlags(67108864);
            window.addFlags(Integer.MIN_VALUE);
            int systemUiVisibility = window.getDecorView().getSystemUiVisibility() | 1024 | IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN;
            window.getDecorView().setSystemUiVisibility(systemUiVisibility);
            window.setStatusBarColor(0);
            ViewTreeObserver viewTreeObserver = window.getDecorView().getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.addOnWindowAttachListener(new ViewTreeObserver.OnWindowAttachListener() { // from class: tv.danmaku.bili.ui.splash.utils.UiUtils$immersive$1$1
                    @Override // android.view.ViewTreeObserver.OnWindowAttachListener
                    public void onWindowAttached() {
                        BLog.i("[Splash]UiUtils", "immersive,set");
                        Window window2 = activity.getWindow();
                        if (window2 != null) {
                            window2.addFlags(1024);
                        }
                        if (NotchCompat.hasDisplayCutout(window)) {
                            NotchCompat.immersiveDisplayCutout(window);
                        }
                        window.getDecorView().getViewTreeObserver().removeOnWindowAttachListener(this);
                    }

                    @Override // android.view.ViewTreeObserver.OnWindowAttachListener
                    public void onWindowDetached() {
                    }
                });
            }
        }
    }

    public final Drawable tintDrawable(Drawable origin, int color) {
        Intrinsics.checkNotNullParameter(origin, "origin");
        Drawable wrapper = DrawableCompat.wrap(origin.mutate());
        DrawableCompat.setTint(wrapper, color);
        Intrinsics.checkNotNull(wrapper);
        return wrapper;
    }

    public final void transportStatusBarV2(Activity activity) {
        Window window;
        if (activity == null || (window = activity.getWindow()) == null) {
            return;
        }
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        int systemUiVisibility = window.getDecorView().getSystemUiVisibility();
        window.getDecorView().setSystemUiVisibility(StatusBarCompat.setNavigationBarMode(activity, systemUiVisibility | 1024 | IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN, MultipleThemeUtils.isNightTheme(activity)));
        window.setStatusBarColor(0);
    }

    public final void transportStatusBarV3(Activity activity) {
        Window window;
        if (activity == null || (window = activity.getWindow()) == null) {
            return;
        }
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        int systemUiVisibility = window.getDecorView().getSystemUiVisibility();
        window.getDecorView().setSystemUiVisibility(StatusBarCompat.setNavigationBarMode(activity, systemUiVisibility | 1024 | IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN, false));
        window.setStatusBarColor(0);
    }
}