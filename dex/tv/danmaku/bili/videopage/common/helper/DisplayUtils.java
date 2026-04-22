package tv.danmaku.bili.videopage.common.helper;

import android.content.res.Resources;
import android.util.TypedValue;

public class DisplayUtils {
    public static int dp2Px(int dp) {
        return (int) TypedValue.applyDimension(1, dp, Resources.getSystem().getDisplayMetrics());
    }

    public static int dp2Px(float dp) {
        return (int) TypedValue.applyDimension(1, dp, Resources.getSystem().getDisplayMetrics());
    }
}