package tv.danmaku.bili.videopage.common.helper;

import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.PopupWindow;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: VideoBubbleHelper.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0007J0\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0007¨\u0006\r"}, d2 = {"Ltv/danmaku/bili/videopage/common/helper/VideoBubbleHelper;", "", "<init>", "()V", "createBubble", "Landroid/widget/PopupWindow;", "popView", "Landroid/view/View;", "anchor", "XPx", "", "YPx", "minW", "videopagecommon_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class VideoBubbleHelper {
    public static final VideoBubbleHelper INSTANCE = new VideoBubbleHelper();

    private VideoBubbleHelper() {
    }

    @JvmStatic
    public static final PopupWindow createBubble(View popView, View anchor, int XPx, int YPx) {
        Intrinsics.checkNotNullParameter(popView, "popView");
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        return createBubble(popView, anchor, XPx, YPx, 0);
    }

    @JvmStatic
    public static final PopupWindow createBubble(View popView, View anchor, int XPx, int YPx, int minW) {
        Intrinsics.checkNotNullParameter(popView, "popView");
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        PopupWindow popupWindow = new PopupWindow(popView, -2, -2);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setBackgroundDrawable(new ColorDrawable(0));
        popupWindow.setFocusable(false);
        if (minW > 0) {
            popupWindow.setWidth(minW);
        }
        int[] location = new int[2];
        anchor.getLocationOnScreen(location);
        Rect rect = new Rect();
        boolean localVisibleRect = anchor.getGlobalVisibleRect(rect);
        if (localVisibleRect) {
            int locationY = (rect.isEmpty() || rect.top >= location[1]) ? location[1] : rect.top;
            popupWindow.showAtLocation(anchor, 8388659, location[0] + XPx, locationY + YPx);
        }
        return popupWindow;
    }
}