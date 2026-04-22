package tv.danmaku.bili.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.recyclerview.widget.RecyclerView;
import com.bilibili.api.BiliApiException;
import com.bilibili.lib.accountinfo.BiliAccountInfo;
import com.bilibili.lib.accountinfo.model.AccountInfo;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.magicasakura.utils.ThemeUtils;

public class UniversalHelper {
    public static boolean isLogin(Context context) {
        return BiliAccounts.get(context).isLogin();
    }

    public static String getAccessKey(Context context) {
        String accessKey = BiliAccounts.get(context).getAccessKey();
        return accessKey == null ? "" : accessKey;
    }

    public static String getMid(Context context) {
        return String.valueOf(getLongMid(context));
    }

    public static long getLongMid(Context context) {
        return BiliAccounts.get(context).mid();
    }

    public static String getAvatar(Context context) {
        AccountInfo accountInfo = BiliAccountInfo.get().getAccountInfoFromCache();
        return accountInfo == null ? "" : accountInfo.getAvatar();
    }

    public static String getName(Context context) {
        AccountInfo accountInfo = BiliAccountInfo.get().getAccountInfoFromCache();
        return accountInfo == null ? "" : accountInfo.getUserName();
    }

    public static int getUserLevel(Context context) {
        AccountInfo accountInfo = BiliAccountInfo.get().getAccountInfoFromCache();
        if (accountInfo == null) {
            return 0;
        }
        return accountInfo.getLevel();
    }

    public static boolean isBindPhone(Context context) {
        AccountInfo accountInfo = BiliAccountInfo.get().getAccountInfoFromCache();
        return accountInfo != null && accountInfo.isMobileVerified();
    }

    public static boolean lessThanLevel1(Context context) {
        BiliAccounts account = BiliAccounts.get(context);
        if (account.isLogin()) {
            int level = BiliAccountInfo.get().getUserLevel();
            if (level == 0) {
                return true;
            }
            return false;
        }
        return false;
    }

    public static boolean isAuthStatusError(Throwable throwable) {
        if (throwable instanceof BiliApiException) {
            if (((BiliApiException) throwable).mCode == -2 || ((BiliApiException) throwable).mCode == -101) {
                return true;
            }
            return false;
        }
        return false;
    }

    public static Drawable getTintDrawable(Context context, int drawableRes, int colorRes) {
        Drawable rd = context.getResources().getDrawable(drawableRes);
        return ThemeUtils.tintDrawableByColorId(context, rd, colorRes);
    }

    public static void smoothScrollToTop(RecyclerView recyclerView) {
        smoothScrollToTop(recyclerView, -1);
    }

    public static void smoothScrollToTop(final RecyclerView recyclerView, int temposition) {
        if (recyclerView == null) {
            return;
        }
        if (temposition < 0) {
            recyclerView.scrollToPosition(0);
            return;
        }
        int position = recyclerView.getChildAdapterPosition(recyclerView.getChildAt(0));
        if (position > temposition) {
            recyclerView.scrollToPosition(temposition);
        }
        recyclerView.post(new Runnable() { // from class: tv.danmaku.bili.utils.UniversalHelper.1
            @Override // java.lang.Runnable
            public void run() {
                recyclerView.smoothScrollToPosition(0);
            }
        });
    }

    public static int safeParseInt(String intString) {
        try {
            return Integer.parseInt(intString);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public static int safeParseInt(String intString, int defaultValue) {
        try {
            return Integer.parseInt(intString);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    public static float safeParseFloat(String intString, float defaultValue) {
        try {
            return Float.parseFloat(intString);
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

    public static int getScreenWidth(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static int getScreenHeight(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static int dp2px(Context context, float dp) {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) ((dp * scale) + 0.5f);
    }
}