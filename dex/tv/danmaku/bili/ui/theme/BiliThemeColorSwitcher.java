package tv.danmaku.bili.ui.theme;

import android.content.Context;
import androidx.core.content.ContextCompat;
import com.bilibili.app.comm.baseres.R;
import com.bilibili.lib.theme.ColorInfo;
import com.bilibili.lib.theme.ThemeColorFactory;
import com.bilibili.magicasakura.utils.ThemeUtils;

public class BiliThemeColorSwitcher implements ThemeUtils.SwitchColor {
    public int replaceColorById(Context context, int colorId, int viewThemeId) {
        int themeId;
        if (colorId == -1) {
            return 0;
        }
        if (viewThemeId != 0) {
            themeId = viewThemeId;
        } else {
            themeId = BiliTheme.getCurrentTheme(context);
        }
        if (!BiliTheme.isAvailableThemeId(themeId)) {
            return ContextCompat.getColor(context, colorId);
        }
        if (themeId == 1) {
            ColorInfo colorInfo = ThemeColorFactory.findBy(themeId, colorId);
            if (colorInfo != null) {
                return colorInfo.color;
            }
            return ContextCompat.getColor(context, colorId);
        }
        ColorInfo colorInfo2 = ThemeColorFactory.findBy(8, colorId);
        if (colorInfo2 != null) {
            return colorInfo2.color;
        }
        if (themeId != 8) {
            if (colorId == R.color.theme_color_primary_tr_title || colorId == R.color.theme_color_tab_pink) {
                return -1;
            }
            if (colorId == R.color.theme_color_primary_tr_background) {
                return BiliTheme.getThemePrimaryColorBySkinId(themeId);
            }
            if (colorId == R.color.theme_color_primary_tr_icon) {
                return -1;
            }
            if (colorId == R.color.theme_color_home_navigation_search_bg) {
                return 218103808;
            }
            if (colorId == R.color.theme_color_home_navigation_search_text) {
                return 1090519039;
            }
            if (colorId == R.color.theme_color_home_navigation_search_icon_tint || colorId == R.color.theme_color_second_search_action_tint || colorId == R.color.theme_color_second_search_bg) {
                return -1;
            }
            if (colorId == R.color.theme_color_primary_tr_text_other) {
                return -1711276033;
            }
            if (colorId == R.color.theme_color_primary_tr_subtitle) {
                return 1728053247;
            }
            if (colorId == R.color.theme_color_primary_tr_fake_icon || colorId == com.bilibili.app.comm.channelsubscriber.R.color.channel_subscriber_stroke_trans || colorId == com.bilibili.app.comm.channelsubscriber.R.color.channel_subscriber_stroke_trans_true_text) {
                return -1;
            }
            if (colorId == com.bilibili.app.comm.channelsubscriber.R.color.channel_subscriber_solid_trans_true_bg) {
                return 738197503;
            }
            if (themeId == 2) {
                return ContextCompat.getColor(context, colorId);
            }
        }
        if (colorId == R.color.theme_color_primary || colorId == R.color.theme_color_secondary) {
            return BiliTheme.getThemePrimaryColorBySkinId(themeId);
        }
        if (colorId == R.color.theme_color_primary_dark || colorId == R.color.theme_color_secondary_dark) {
            return BiliTheme.getThemePrimaryDarkColorBySkinId(themeId);
        }
        if (colorId == R.color.theme_color_primary_light) {
            return BiliTheme.getThemePrimaryLightColorBySkinId(themeId);
        }
        if (colorId == R.color.theme_color_primary_trans) {
            return BiliTheme.getThemePrimaryTransColorBySkinId(themeId);
        }
        return ContextCompat.getColor(context, colorId);
    }

    public int replaceColor(Context context, int color) {
        int themeId = BiliTheme.getCurrentTheme(context);
        if (!BiliTheme.isAvailableThemeId(themeId)) {
            return color;
        }
        if (themeId == 1 || themeId == 2) {
            return color;
        }
        switch (color) {
            case BiliTheme.THEME_COLOR_PINK_TRANS /* -1712306068 */:
                return BiliTheme.getThemePrimaryTransColorBySkinId(themeId);
            case BiliTheme.THEME_COLOR_PINK_DARK /* -4696463 */:
                return BiliTheme.getThemePrimaryDarkColorBySkinId(themeId);
            case BiliTheme.THEME_COLOR_PINK_LIGHT /* -4687727 */:
                return BiliTheme.getThemePrimaryLightColorBySkinId(themeId);
            case BiliTheme.THEME_COLOR_PINK /* -39271 */:
                return BiliTheme.getThemePrimaryColorBySkinId(themeId);
            default:
                return color;
        }
    }
}