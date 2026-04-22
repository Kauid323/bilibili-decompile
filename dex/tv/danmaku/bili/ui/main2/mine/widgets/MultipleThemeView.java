package tv.danmaku.bili.ui.main2.mine.widgets;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.bilibili.lib.crashreport.CrashReporter;
import com.bilibili.lib.ui.garb.Garb;
import com.bilibili.lib.ui.garb.GarbManager;
import com.bilibili.lib.ui.util.MultipleThemeUtils;
import com.bilibili.magicasakura.widgets.Tintable;
import tv.danmaku.bili.R;

public class MultipleThemeView extends View implements Tintable {
    private boolean mFitPrimaryOnly;
    private int mGarbDarkModeColor;
    private int mGarbLightModeColor;
    private int mNightModeColor;
    private int mPinkModeColor;
    private int mWhiteModeColor;

    public MultipleThemeView(Context context) {
        this(context, null);
    }

    public MultipleThemeView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MultipleThemeView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        try {
            TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.MultipleThemeView, defStyleAttr, 0);
            if (a.hasValue(R.styleable.MultipleThemeView_pinkModeColor)) {
                this.mPinkModeColor = a.getResourceId(R.styleable.MultipleThemeView_pinkModeColor, 0);
            }
            if (a.hasValue(R.styleable.MultipleThemeView_whiteModeColor)) {
                this.mWhiteModeColor = a.getResourceId(R.styleable.MultipleThemeView_whiteModeColor, 0);
            }
            if (a.hasValue(R.styleable.MultipleThemeView_nightModeColor)) {
                this.mNightModeColor = a.getResourceId(R.styleable.MultipleThemeView_nightModeColor, 0);
            }
            if (a.hasValue(R.styleable.MultipleThemeView_garbDarkColor)) {
                this.mGarbDarkModeColor = a.getResourceId(R.styleable.MultipleThemeView_garbDarkColor, 0);
            }
            if (a.hasValue(R.styleable.MultipleThemeView_garbLightColor)) {
                this.mGarbLightModeColor = a.getResourceId(R.styleable.MultipleThemeView_garbLightColor, 0);
            }
            if (a.hasValue(R.styleable.MultipleThemeView_fitGarbPrimaryOnly)) {
                this.mFitPrimaryOnly = a.getBoolean(R.styleable.MultipleThemeView_fitGarbPrimaryOnly, false);
            }
            a.recycle();
        } catch (Exception e) {
        }
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        tint();
    }

    public void tint() {
        Garb garb = GarbManager.getGarbWithNightMode(getContext());
        Drawable bg = getBackground();
        if (bg != null) {
            GradientDrawable gradientDrawable = (GradientDrawable) bg.mutate();
            int bgColor = 0;
            if (garb.isPure()) {
                if (garb.isNight()) {
                    if (this.mNightModeColor != 0) {
                        bgColor = this.mNightModeColor;
                    }
                } else if (garb.isWhite()) {
                    if (this.mWhiteModeColor != 0) {
                        bgColor = this.mWhiteModeColor;
                    }
                } else if (this.mPinkModeColor != 0) {
                    bgColor = this.mPinkModeColor;
                }
            } else if (this.mFitPrimaryOnly && garb.isPrimaryOnly()) {
                bgColor = MultipleThemeUtils.isNightTheme(getContext()) ? this.mNightModeColor : this.mWhiteModeColor;
            } else if (!garb.isDarkMode()) {
                if (this.mGarbDarkModeColor != 0) {
                    bgColor = this.mGarbDarkModeColor;
                }
            } else if (this.mGarbLightModeColor != 0) {
                bgColor = this.mGarbLightModeColor;
            }
            if (bgColor != 0) {
                try {
                    gradientDrawable.setColor(ContextCompat.getColor(getContext(), bgColor));
                    setBackground(gradientDrawable);
                } catch (Resources.NotFoundException e) {
                    CrashReporter.INSTANCE.postCaughtException(e);
                }
            }
        }
    }
}