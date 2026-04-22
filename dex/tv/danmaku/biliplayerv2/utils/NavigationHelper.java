package tv.danmaku.biliplayerv2.utils;

import android.app.Activity;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.Window;
import com.bilibili.droid.RomUtils;
import com.bilibili.droid.WindowManagerHelper;
import com.bilibili.lib.ui.helper.NotchCompat;
import com.bilibili.lib.ui.util.StatusBarCompat;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* compiled from: NavigationHelper.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0012\u0010\b\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0007J\u0012\u0010\n\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0007J\u0010\u0010\u000b\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\f\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J\u001a\u0010\r\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000e\u001a\u00020\u0005H\u0002J\u001a\u0010\u000f\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000e\u001a\u00020\u0005H\u0002J\u0010\u0010\u0010\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J\u001a\u0010\u0011\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u0007J\u0018\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0010\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0018H\u0002¨\u0006\u001a"}, d2 = {"Ltv/danmaku/biliplayerv2/utils/NavigationHelper;", "", "<init>", "()V", "getNavigationHeight", "", "activity", "Landroid/app/Activity;", "hideNavigation", "", "hideNavigationImmersive", "showSystemUI", "showNavigation", "addSystemUiFlag", "visibility", "removeSystemUiFlag", "getVisibility", "setOnSystemUiVisibilityChangeListener", "listener", "Landroid/view/View$OnSystemUiVisibilityChangeListener;", "getDisplaySizeExceptCutout", "Landroid/graphics/Point;", "getVerticalDeltaValue", "notchRect", "Landroid/graphics/Rect;", "getLandscapeDeltaValue", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class NavigationHelper {
    public static final NavigationHelper INSTANCE = new NavigationHelper();

    private NavigationHelper() {
    }

    public final int getNavigationHeight(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        return StatusBarCompat.getNavigationBarHeight(activity);
    }

    @Deprecated(message = "使用WindowCompat, WindowInsetsCompact, WindowInsetsControllerCompat等替代")
    public final void hideNavigation(Activity activity) {
        if (activity == null) {
            return;
        }
        removeSystemUiFlag(activity, 0);
        int visibility = 6 | 1024;
        addSystemUiFlag(activity, visibility | 512 | IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN | IjkMediaMeta.FF_PROFILE_H264_INTRA);
    }

    @Deprecated(message = "使用WindowCompat, WindowInsetsCompact, WindowInsetsControllerCompat等替代")
    public final void hideNavigationImmersive(Activity activity) {
        if (activity == null) {
            return;
        }
        int visibility = 2 | 512;
        addSystemUiFlag(activity, visibility | IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN | 4096);
    }

    public final void showSystemUI(Activity activity) {
        if (activity == null) {
            return;
        }
        removeSystemUiFlag(activity, 4096);
        boolean isCutout = NotchCompat.hasDisplayCutoutHardware(activity.getWindow());
        if (isCutout) {
            removeSystemUiFlag(activity, 2);
            removeSystemUiFlag(activity, 512);
            removeSystemUiFlag(activity, IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN);
            return;
        }
        removeSystemUiFlag(activity, 2);
        removeSystemUiFlag(activity, 512);
        removeSystemUiFlag(activity, IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN);
    }

    public final void showNavigation(Activity activity) {
        if (activity == null || getVisibility(activity) == 1) {
            return;
        }
        int visibility = 768 | IjkMediaMeta.FF_PROFILE_H264_INTRA;
        addSystemUiFlag(activity, visibility);
    }

    private final void addSystemUiFlag(Activity activity, int visibility) {
        if (activity == null) {
            return;
        }
        int targetFlag = activity.getWindow().getDecorView().getSystemUiVisibility() | visibility;
        activity.getWindow().getDecorView().setSystemUiVisibility(targetFlag);
    }

    private final void removeSystemUiFlag(Activity activity, int visibility) {
        if (activity == null) {
            return;
        }
        int targetFlag = activity.getWindow().getDecorView().getSystemUiVisibility() & (~visibility);
        activity.getWindow().getDecorView().setSystemUiVisibility(targetFlag);
    }

    public final int getVisibility(Activity activity) {
        Window window;
        View decorView;
        if (activity == null || (window = activity.getWindow()) == null || (decorView = window.getDecorView()) == null) {
            return 0;
        }
        return decorView.getSystemUiVisibility();
    }

    public final void setOnSystemUiVisibilityChangeListener(Activity activity, View.OnSystemUiVisibilityChangeListener listener) {
        if (activity == null) {
            return;
        }
        try {
            activity.getWindow().getDecorView().findViewById(16908290).setOnSystemUiVisibilityChangeListener(listener);
        } catch (Exception e) {
        }
    }

    public final Point getDisplaySizeExceptCutout(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Point size = WindowManagerHelper.getDisplayRealSize(activity.getApplicationContext());
        Window window = activity.getWindow();
        if ((RomUtils.isHuaweiRom() || RomUtils.isMiuiRom() || RomUtils.isMeizuRom() || RomUtils.isSamsungRom() || Build.VERSION.SDK_INT >= 28) && NotchCompat.hasDisplayCutoutHardware(window)) {
            List cutoutSize = NotchCompat.getDisplayCutoutSizeHardware(window);
            Intrinsics.checkNotNullExpressionValue(cutoutSize, "getDisplayCutoutSizeHardware(...)");
            if (!cutoutSize.isEmpty()) {
                Rect rect = (Rect) cutoutSize.get(0);
                if (size.y > size.x) {
                    int i = size.y;
                    Intrinsics.checkNotNull(rect);
                    size.y = i - getVerticalDeltaValue(rect, activity);
                } else {
                    int i2 = size.x;
                    Intrinsics.checkNotNull(rect);
                    size.x = i2 - getLandscapeDeltaValue(rect);
                }
            }
        } else if (activity.getRequestedOrientation() == 0 && size.y > size.x) {
            size = new Point(size.y, size.x);
        } else if (activity.getRequestedOrientation() == 1 && size.x > size.y) {
            size = new Point(size.y, size.x);
        }
        Intrinsics.checkNotNull(size);
        return size;
    }

    private final int getVerticalDeltaValue(Rect notchRect, Activity activity) {
        int statusBarHeight = StatusBarCompat.getStatusBarHeight(activity);
        int notchHeight = Math.abs(notchRect.height());
        if (notchRect.height() > 0 && notchRect.width() > 0) {
            notchHeight = Math.abs(Math.min(notchRect.height(), notchRect.width()));
        }
        if (statusBarHeight > notchHeight) {
            return statusBarHeight;
        }
        return notchHeight;
    }

    private final int getLandscapeDeltaValue(Rect notchRect) {
        if (notchRect.height() > 0 && notchRect.width() > 0) {
            return RangesKt.coerceAtMost(notchRect.height(), notchRect.width());
        }
        return Math.abs(notchRect.height());
    }
}