package tv.danmaku.bili.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.TypedValue;
import android.view.WindowManager;

public class DisplayUtils {
    public static Drawable createFillBackgroundDrawable(Context context, int radiusDp, int colorId) {
        int radiusPx = (int) TypedValue.applyDimension(1, radiusDp, context.getResources().getDisplayMetrics());
        GradientDrawable drawable = new GradientDrawable();
        drawable.setCornerRadius(radiusPx);
        drawable.setShape(0);
        drawable.setColor(colorId);
        return drawable;
    }

    public static int dp2Px(int dp) {
        return (int) TypedValue.applyDimension(1, dp, Resources.getSystem().getDisplayMetrics());
    }

    public static int dp2Px(float dp) {
        return (int) TypedValue.applyDimension(1, dp, Resources.getSystem().getDisplayMetrics());
    }

    public static int getWindowWidth(Context context) {
        WindowManager wm = (WindowManager) context.getSystemService("window");
        return wm.getDefaultDisplay().getWidth();
    }

    public static int parseColor(String value, int defaultColor) {
        try {
            return Color.parseColor(value);
        } catch (Exception e) {
            return defaultColor;
        }
    }
}