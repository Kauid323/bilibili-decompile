package tv.danmaku.bili.ui.push.v2;

import android.app.Activity;
import android.graphics.Rect;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import com.bilibili.base.BiliContext;
import com.bilibili.droid.WindowManagerHelper;
import com.bilibili.lib.basecomponent.R;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.ui.helper.NotchCompat;
import com.bilibili.lib.ui.util.StatusBarCompat;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: InnerPushViewUtils.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002¨\u0006\b"}, d2 = {"getStatusBarHeight", "", "view", "Landroid/view/View;", "isActivityFullScreen", "", "activity", "Landroid/app/Activity;", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class InnerPushViewUtilsKt {
    public static final int getStatusBarHeight(View view2) {
        Intrinsics.checkNotNullParameter(view2, "view");
        Activity topActivity = BiliContext.topActivity();
        if (topActivity != null) {
            Window window = topActivity.getWindow();
            if (view2.getResources().getConfiguration().orientation == 2) {
                if (NotchCompat.hasDisplayCutoutHardware(window)) {
                    int screenWidth = WindowManagerHelper.getDisplayWidth(view2.getContext());
                    int screenHeight = WindowManagerHelper.getDisplayHeight(view2.getContext());
                    return (int) (Math.min(screenHeight, screenWidth) * 0.07f);
                }
                return 0;
            } else if (NotchCompat.hasDisplayCutoutHardware(window)) {
                if (NotchCompat.hasDisplayCutout(window)) {
                    List cutouts = NotchCompat.getDisplayCutoutSize(window);
                    Intrinsics.checkNotNullExpressionValue(cutouts, "getDisplayCutoutSize(...)");
                    if (cutouts.size() > 0) {
                        return ((Rect) cutouts.get(0)).height();
                    }
                }
                if (Intrinsics.areEqual(ConfigManager.Companion.ab().get("ff_inner_push_status_bar_fix", true), false)) {
                    return 0;
                }
                return StatusBarCompat.getStatusBarHeight(view2.getContext());
            } else if (isActivityFullScreen(topActivity) && window.getDecorView().findViewById(R.id.bili_status_bar_view) == null) {
                return 0;
            }
        }
        return StatusBarCompat.getStatusBarHeight(view2.getContext());
    }

    private static final boolean isActivityFullScreen(Activity activity) {
        boolean windowFullScreen = false;
        TypedValue typedValue = new TypedValue();
        activity.getTheme().obtainStyledAttributes(new int[]{16843277}).getValue(0, typedValue);
        if (typedValue.type == 18 && typedValue.data != 0) {
            windowFullScreen = true;
        }
        return windowFullScreen || (activity.getWindow().getAttributes().flags & 1024) == 1024 || (activity.getWindow().getDecorView().getSystemUiVisibility() & 4) == 4;
    }
}