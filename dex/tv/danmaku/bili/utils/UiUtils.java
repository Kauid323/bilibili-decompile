package tv.danmaku.bili.utils;

import android.content.Context;

public class UiUtils {
    public static int dp2px(Context context, float dp) {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) ((dp * scale) + 0.5f);
    }
}