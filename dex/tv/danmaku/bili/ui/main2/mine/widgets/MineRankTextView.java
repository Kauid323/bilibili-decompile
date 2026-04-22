package tv.danmaku.bili.ui.main2.mine.widgets;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import androidx.core.content.ContextCompat;
import com.bilibili.lib.crashreport.CrashReporter;
import com.bilibili.lib.ui.garb.Garb;
import com.bilibili.lib.ui.garb.GarbManager;
import com.bilibili.lib.ui.util.MultipleThemeUtils;
import tv.danmaku.bili.ui.DisplayUtils;

public class MineRankTextView extends MultipleThemeTextView {
    public MineRankTextView(Context context) {
        this(context, null);
    }

    public MineRankTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MineRankTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override // tv.danmaku.bili.ui.main2.mine.widgets.MultipleThemeTextView
    public void tint() {
        int tintColor;
        super.tint();
        Context context = getContext();
        Drawable bg = getBackground();
        if (bg != null) {
            GradientDrawable temp = (GradientDrawable) bg.mutate();
            Garb garb = GarbManager.getGarbWithNightMode(context);
            if (garb.isPure()) {
                if (garb.isNight()) {
                    tintColor = this.mNightModeColor;
                } else if (garb.isWhite()) {
                    tintColor = this.mWhiteModeColor;
                } else {
                    tintColor = this.mPinkModeColor;
                }
            } else if (this.mFitPrimaryOnly && garb.isPrimaryOnly()) {
                if (MultipleThemeUtils.isNightTheme(context)) {
                    tintColor = this.mNightModeColor;
                } else {
                    tintColor = this.mWhiteModeColor;
                }
            } else if (!garb.isDarkMode()) {
                tintColor = this.mGarbDarkModeColor;
            } else {
                tintColor = this.mGarbLightModeColor;
            }
            try {
                temp.setStroke(DisplayUtils.dp2Px(1), ContextCompat.getColor(context, tintColor));
                setBackground(temp);
            } catch (Resources.NotFoundException e) {
                CrashReporter.INSTANCE.postCaughtException(e);
            }
        }
    }
}