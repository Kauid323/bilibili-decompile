package tv.danmaku.bili.ui.cheese;

import android.content.Context;
import androidx.core.content.ContextCompat;
import com.bilibili.app.comm.baseres.R;
import com.bilibili.magicasakura.utils.ThemeUtils;
import tv.danmaku.bili.ui.theme.BiliTheme;

public class CheeseThemeSwitch implements ThemeUtils.SwitchColor {
    public int replaceColorById(Context context, int colorId, int viewThemeId) {
        if (colorId == -1) {
            return 0;
        }
        int themeId = BiliTheme.getCurrentTheme(context);
        if (!BiliTheme.isAvailableThemeId(themeId)) {
            return ContextCompat.getColor(context, colorId);
        }
        if (colorId == R.color.theme_color_primary || colorId == R.color.theme_color_secondary) {
            return ContextCompat.getColor(context, tv.danmaku.biliplayer.baseres.R.color.player_cheese_theme_color);
        }
        if (colorId == R.color.theme_color_primary_dark || colorId == R.color.theme_color_secondary_dark) {
            return ContextCompat.getColor(context, tv.danmaku.biliplayer.baseres.R.color.player_cheese_theme_color);
        }
        if (colorId == R.color.theme_color_primary_light) {
            return ContextCompat.getColor(context, tv.danmaku.biliplayer.baseres.R.color.player_cheese_theme_color);
        }
        if (colorId == R.color.theme_color_primary_trans) {
            return ContextCompat.getColor(context, tv.danmaku.biliplayer.baseres.R.color.player_cheese_theme_color);
        }
        if (colorId == R.color.pink) {
            return ContextCompat.getColor(context, tv.danmaku.biliplayer.baseres.R.color.player_cheese_theme_color);
        }
        if (colorId == R.color.daynight_color_pink) {
            return ContextCompat.getColor(context, tv.danmaku.biliplayer.baseres.R.color.player_cheese_theme_color);
        }
        if (colorId == com.bilibili.lib.theme.R.color.Pi5_u) {
            return ContextCompat.getColor(context, tv.danmaku.biliplayer.baseres.R.color.player_cheese_theme_color);
        }
        return ContextCompat.getColor(context, colorId);
    }

    public int replaceColor(Context context, int color) {
        int themeId = BiliTheme.getCurrentTheme(context);
        if (!BiliTheme.isAvailableThemeId(themeId)) {
            return color;
        }
        switch (color) {
            case -1712306068:
                return ContextCompat.getColor(context, tv.danmaku.biliplayer.baseres.R.color.player_cheese_theme_color);
            case -4696463:
                return ContextCompat.getColor(context, tv.danmaku.biliplayer.baseres.R.color.player_cheese_theme_color);
            case -4687727:
                return ContextCompat.getColor(context, tv.danmaku.biliplayer.baseres.R.color.player_cheese_theme_color);
            case -39271:
                return ContextCompat.getColor(context, tv.danmaku.biliplayer.baseres.R.color.player_cheese_theme_color);
            default:
                return color;
        }
    }
}