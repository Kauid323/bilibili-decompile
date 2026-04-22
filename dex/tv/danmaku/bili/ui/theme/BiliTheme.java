package tv.danmaku.bili.ui.theme;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.util.SparseArray;
import bili.resource.others.R;
import com.bilibili.base.BiliContext;
import com.bilibili.base.BiliGlobalPreferenceHelper;
import com.bilibili.lib.ui.theme.ThemeWatcher;
import com.bilibili.lib.ui.util.MultipleThemeUtils;
import com.bilibili.magicasakura.utils.ThemeUtils;
import java.util.Calendar;
import java.util.Date;
import tv.danmaku.bili.ui.garb.GarbManagerDelegate;

public class BiliTheme {
    public static int CURRENT_THEME = 0;
    public static final int CURRENT_THEME_DEFAULT = 2;
    public static final int DEFAULT_THEME_ID = 2;
    public static final int NIGHT_THEME_ID = 1;
    public static final int THEME_COLOR_BLUE = -14575885;
    public static final int THEME_COLOR_BLUE_DARK;
    public static final int THEME_COLOR_BLUE_LIGHT;
    public static final int THEME_COLOR_GREEN = -7617718;
    public static final int THEME_COLOR_GREEN_DARK;
    public static final int THEME_COLOR_GREEN_LIGHT;
    public static final int THEME_COLOR_PINK = -39271;
    public static final int THEME_COLOR_PINK_DARK = -4696463;
    public static final int THEME_COLOR_PINK_LIGHT = -4687727;
    public static final int THEME_COLOR_PINK_TRANS = -1712306068;
    public static final int THEME_COLOR_PURPLE = -6543440;
    public static final int THEME_COLOR_PURPLE_DARK;
    public static final int THEME_COLOR_PURPLE_LIGHT;
    public static final int THEME_COLOR_RED = -769226;
    public static final int THEME_COLOR_RED_DARK;
    public static final int THEME_COLOR_RED_LIGHT;
    public static final int THEME_COLOR_YELLOW = -16121;
    public static final int THEME_COLOR_YELLOW_DARK;
    public static final int THEME_COLOR_YELLOW_LIGHT;
    public static final int THEME_ID_BLUE = 6;
    public static final int THEME_ID_GREEN = 5;
    public static final int THEME_ID_PURPLE = 7;
    public static final int THEME_ID_RED = 3;
    public static final int THEME_ID_WHITE = 8;
    public static final int THEME_ID_YELLOW = 4;
    private static final String THEME_PREF_KEY = "theme_entries_current_key";
    private static final String THEME_PREF_KEY_LAST = "theme_entries_last_key";
    public static final String DEFAULT_THEME_NAME = BiliContext.application().getResources().getString(R.string.others_global_string_470);
    public static final String NIGHT_THEME_NAME = BiliContext.application().getResources().getString(bili.resource.common.R.string.common_global_string_349);
    static final SparseArray<int[]> THEME_COLORS = new SparseArray<>(9);
    static final SparseArray<String> THEME_NAMES = new SparseArray<>(9);

    static {
        float[] hsv = new float[3];
        THEME_COLOR_RED_DARK = getThemeDarkColor(THEME_COLOR_RED, hsv);
        THEME_COLOR_YELLOW_DARK = getThemeDarkColor(THEME_COLOR_YELLOW, hsv);
        THEME_COLOR_BLUE_DARK = getThemeDarkColor(THEME_COLOR_BLUE, hsv);
        THEME_COLOR_GREEN_DARK = getThemeDarkColor(THEME_COLOR_GREEN, hsv);
        THEME_COLOR_PURPLE_DARK = getThemeDarkColor(THEME_COLOR_PURPLE, hsv);
        THEME_COLOR_RED_LIGHT = getThemeLightColor(THEME_COLOR_RED, hsv);
        THEME_COLOR_YELLOW_LIGHT = getThemeLightColor(THEME_COLOR_YELLOW, hsv);
        THEME_COLOR_GREEN_LIGHT = getThemeLightColor(THEME_COLOR_GREEN, hsv);
        THEME_COLOR_BLUE_LIGHT = getThemeLightColor(THEME_COLOR_BLUE, hsv);
        THEME_COLOR_PURPLE_LIGHT = getThemeLightColor(THEME_COLOR_PURPLE, hsv);
        THEME_NAMES.put(2, DEFAULT_THEME_NAME);
        THEME_NAMES.put(1, NIGHT_THEME_NAME);
        THEME_NAMES.put(3, BiliContext.application().getResources().getString(R.string.others_global_string_485));
        THEME_NAMES.put(4, BiliContext.application().getResources().getString(R.string.others_global_string_492));
        THEME_NAMES.put(5, BiliContext.application().getResources().getString(R.string.others_global_string_469));
        THEME_NAMES.put(6, BiliContext.application().getResources().getString(R.string.others_global_string_497));
        THEME_NAMES.put(7, BiliContext.application().getResources().getString(R.string.others_global_string_488));
        THEME_COLORS.put(2, new int[]{THEME_COLOR_PINK, THEME_COLOR_PINK_DARK, THEME_COLOR_PINK_LIGHT, THEME_COLOR_PINK_TRANS});
        THEME_COLORS.put(1, new int[]{-13816531, -14408668, -12763843, -1725684700});
        THEME_COLORS.put(3, new int[]{THEME_COLOR_RED, THEME_COLOR_RED_DARK, THEME_COLOR_RED_LIGHT, getThemeTransColor(THEME_COLOR_RED_DARK)});
        THEME_COLORS.put(4, new int[]{THEME_COLOR_YELLOW, THEME_COLOR_YELLOW_DARK, THEME_COLOR_YELLOW_LIGHT, getThemeTransColor(THEME_COLOR_YELLOW_DARK)});
        THEME_COLORS.put(5, new int[]{THEME_COLOR_GREEN, THEME_COLOR_GREEN_DARK, THEME_COLOR_GREEN_LIGHT, getThemeTransColor(THEME_COLOR_GREEN_DARK)});
        THEME_COLORS.put(6, new int[]{THEME_COLOR_BLUE, THEME_COLOR_BLUE_DARK, THEME_COLOR_BLUE_LIGHT, getThemeTransColor(THEME_COLOR_BLUE_DARK)});
        THEME_COLORS.put(7, new int[]{THEME_COLOR_PURPLE, THEME_COLOR_PURPLE_DARK, THEME_COLOR_PURPLE_LIGHT, getThemeTransColor(THEME_COLOR_PURPLE_DARK)});
        THEME_COLORS.put(8, new int[]{THEME_COLOR_PINK, THEME_COLOR_PINK_DARK, THEME_COLOR_PINK_LIGHT, THEME_COLOR_PINK_TRANS});
        CURRENT_THEME = -1;
    }

    private static int getThemeDarkColor(int color1, float[] hsv) {
        Color.colorToHSV(color1, hsv);
        hsv[2] = hsv[2] - (hsv[2] * 0.2f);
        return Color.HSVToColor(hsv);
    }

    private static int getThemeLightColor(int color1, float[] hsv) {
        Color.colorToHSV(color1, hsv);
        hsv[2] = hsv[2] + (hsv[2] * 0.1f);
        return Color.HSVToColor(hsv);
    }

    private static int getThemeTransColor(int color1) {
        return (16777215 & color1) | (-1275068416);
    }

    public static boolean isAvailableThemeId(int themeId) {
        return THEME_COLORS.indexOfKey(themeId) >= 0;
    }

    public static int getThemePrimaryColorBySkinId(int skinId) {
        return THEME_COLORS.get(skinId)[0];
    }

    public static int getThemePrimaryDarkColorBySkinId(int skinId) {
        return THEME_COLORS.get(skinId)[1];
    }

    public static int getThemePrimaryLightColorBySkinId(int skinId) {
        return THEME_COLORS.get(skinId)[2];
    }

    public static int getThemePrimaryTransColorBySkinId(int skinId) {
        return THEME_COLORS.get(skinId)[3];
    }

    public static int readThemeId(Context context) {
        return MultipleThemeUtils.getCurrentThemeId(context);
    }

    private static int readLastThemeId(Context context) {
        SharedPreferences blkvSp = BiliGlobalPreferenceHelper.getBLKVSharedPreference(context);
        if (blkvSp.contains(THEME_PREF_KEY_LAST)) {
            return blkvSp.getInt(THEME_PREF_KEY_LAST, 2);
        }
        BiliGlobalPreferenceHelper helper = BiliGlobalPreferenceHelper.getInstance(context);
        int lastKey = helper.optInteger(THEME_PREF_KEY_LAST, 2);
        blkvSp.edit().putInt(THEME_PREF_KEY_LAST, lastKey).apply();
        return lastKey;
    }

    @Deprecated
    public static boolean isNightTheme(Context context) {
        return MultipleThemeUtils.isNightTheme(context);
    }

    @Deprecated
    public static boolean isWhiteTheme(Context context) {
        return MultipleThemeUtils.isWhiteTheme(context);
    }

    public static void setCurrentTheme(Context context, int themeId) {
        setCurrentTheme(context, themeId, true);
    }

    public static void setCurrentTheme(Context context, int themeId, boolean syncGarb) {
        CURRENT_THEME = themeId;
        int currentModeId = readThemeId(context);
        BiliGlobalPreferenceHelper.getBLKVSharedPreference(context).edit().putInt(THEME_PREF_KEY_LAST, currentModeId).putInt(THEME_PREF_KEY, themeId).apply();
        MultipleThemeUtils.setCurrentTheme(themeId);
        if (syncGarb) {
            GarbManagerDelegate.syncColorGarb(themeId);
        }
    }

    public static int getCurrentTheme(Context context) {
        return CURRENT_THEME == -1 ? readThemeId(context) : CURRENT_THEME;
    }

    public static void switchNightTheme(Context context) {
        int themeId;
        int currentModeId = readThemeId(context);
        if (currentModeId == 1) {
            themeId = readLastThemeId(context);
            if (themeId == 1) {
                themeId = 8;
            }
        } else {
            themeId = 1;
        }
        BiliGlobalPreferenceHelper.getBLKVSharedPreference(context).edit().putInt(THEME_PREF_KEY_LAST, currentModeId).putInt(THEME_PREF_KEY, themeId).apply();
        MultipleThemeUtils.setCurrentTheme(themeId);
        CURRENT_THEME = themeId;
        GarbManagerDelegate.syncColorGarb(themeId);
        ThemeWatcher.getInstance().onChanged();
    }

    public static boolean isThemeExpired(long serverTime, long themeDueTime) {
        Calendar server = Calendar.getInstance();
        server.setTime(new Date(serverTime));
        Calendar theme = Calendar.getInstance();
        theme.setTime(new Date(themeDueTime));
        if (server.get(1) == theme.get(1)) {
            return server.get(6) - theme.get(6) >= 1;
        }
        theme.add(2, 1);
        server.add(2, 1);
        return server.get(1) != theme.get(1) || server.get(6) - theme.get(6) >= 1;
    }

    public static void switchDefaultTheme(Context context) {
        try {
            int themeId = readThemeId(context);
            if (themeId != 1 && themeId != 8 && themeId != 2) {
                setCurrentTheme(context, 8);
            } else {
                setCurrentTheme(context, themeId);
            }
            ThemeWatcher.getInstance().onChanged();
        } catch (Exception e) {
        }
    }

    public static void tintWindowBackground(Activity activity) {
        activity.getWindow().setBackgroundDrawableResource(com.bilibili.app.comm.baseres.R.color.daynight_color_window_background);
    }

    public static void tintTaskDescription(Activity activity) {
        ActivityManager.TaskDescription description = new ActivityManager.TaskDescription((String) null, (Bitmap) null, ThemeUtils.getThemeAttrColor(activity, androidx.appcompat.R.attr.colorPrimary));
        activity.setTaskDescription(description);
    }
}