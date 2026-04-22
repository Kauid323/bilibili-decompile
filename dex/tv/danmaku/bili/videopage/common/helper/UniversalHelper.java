package tv.danmaku.bili.videopage.common.helper;

import android.content.Context;
import com.bilibili.api.BiliApiException;

public class UniversalHelper {
    public static boolean isAuthStatusError(Throwable throwable) {
        if (throwable instanceof BiliApiException) {
            if (((BiliApiException) throwable).mCode == -2 || ((BiliApiException) throwable).mCode == -101) {
                return true;
            }
            return false;
        }
        return false;
    }

    public static int safeParseInt(String intString, int defaultValue) {
        try {
            return Integer.parseInt(intString);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    public static long safeParseLong(String longString, long defaultValue) {
        try {
            return Long.parseLong(longString);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    public static int dp2px(Context context, float dp) {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) ((dp * scale) + 0.5f);
    }
}