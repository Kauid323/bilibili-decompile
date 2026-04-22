package tv.danmaku.bili.ui.theme;

import android.util.SparseArray;
import com.bilibili.base.BiliContext;

public class H5ThemeCompatHelper {
    private static final int H5_THEME_BLUE = 6;
    private static final int H5_THEME_GREEN = 5;
    private static final int H5_THEME_NIGHT = 2;
    private static final int H5_THEME_NONE = -1;
    private static final int H5_THEME_PINK = 0;
    private static final int H5_THEME_PURPLE = 7;
    private static final int H5_THEME_RED = 3;
    private static final int H5_THEME_WHITE = 1;
    private static final int H5_THEME_YELLOW = 4;
    private static final SparseArray<Integer> THEME_NATIVE_CONVERT_H5 = new SparseArray<>();

    static {
        THEME_NATIVE_CONVERT_H5.put(1, 2);
        THEME_NATIVE_CONVERT_H5.put(2, 0);
        THEME_NATIVE_CONVERT_H5.put(3, 3);
        THEME_NATIVE_CONVERT_H5.put(4, 4);
        THEME_NATIVE_CONVERT_H5.put(5, 5);
        THEME_NATIVE_CONVERT_H5.put(6, 6);
        THEME_NATIVE_CONVERT_H5.put(7, 7);
        THEME_NATIVE_CONVERT_H5.put(8, 1);
    }

    public static int getCompatThemeId() {
        int themeId = BiliTheme.getCurrentTheme(BiliContext.application());
        return THEME_NATIVE_CONVERT_H5.get(themeId, -1).intValue();
    }

    public static int getCompatThemeId(int themeID) {
        return THEME_NATIVE_CONVERT_H5.get(themeID, 1).intValue();
    }
}