package tv.danmaku.bili.ui.main2.mine.widgets;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import com.bilibili.lib.crashreport.CrashReporter;
import com.bilibili.lib.ui.garb.Garb;
import com.bilibili.lib.ui.garb.GarbManager;
import com.bilibili.lib.ui.util.MultipleThemeUtils;
import com.bilibili.magicasakura.utils.ThemeUtils;
import com.bilibili.magicasakura.widgets.Tintable;
import tv.danmaku.bili.R;

public class MultipleThemeImageView extends ImageView implements Tintable {
    private boolean mFitPrimaryOnly;
    private int mGarbDarkModeColor;
    private int mGarbLightModeColor;
    private boolean mIsTintable;
    private int mNightModeColor;
    private int mPinkModeColor;
    private int mWhiteModeColor;

    public MultipleThemeImageView(Context context) {
        this(context, null);
    }

    public MultipleThemeImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MultipleThemeImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mIsTintable = true;
        try {
            TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.MultipleThemeImageView, defStyleAttr, 0);
            if (a.hasValue(R.styleable.MultipleThemeImageView_pinkModeColor)) {
                this.mPinkModeColor = a.getResourceId(R.styleable.MultipleThemeImageView_pinkModeColor, 0);
            }
            if (a.hasValue(R.styleable.MultipleThemeImageView_whiteModeColor)) {
                this.mWhiteModeColor = a.getResourceId(R.styleable.MultipleThemeImageView_whiteModeColor, 0);
            }
            if (a.hasValue(R.styleable.MultipleThemeImageView_nightModeColor)) {
                this.mNightModeColor = a.getResourceId(R.styleable.MultipleThemeImageView_nightModeColor, 0);
            }
            if (a.hasValue(R.styleable.MultipleThemeImageView_garbDarkColor)) {
                this.mGarbDarkModeColor = a.getResourceId(R.styleable.MultipleThemeImageView_garbDarkColor, 0);
            }
            if (a.hasValue(R.styleable.MultipleThemeImageView_garbLightColor)) {
                this.mGarbLightModeColor = a.getResourceId(R.styleable.MultipleThemeImageView_garbLightColor, 0);
            }
            if (a.hasValue(R.styleable.MultipleThemeImageView_fitGarbPrimaryOnly)) {
                this.mFitPrimaryOnly = a.getBoolean(R.styleable.MultipleThemeImageView_fitGarbPrimaryOnly, false);
            }
            a.recycle();
        } catch (Exception e) {
        }
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        tint();
    }

    public void setTintable(boolean tintable) {
        this.mIsTintable = tintable;
    }

    public void tint() {
        Drawable drawable;
        int tintColor;
        if (this.mIsTintable && (drawable = getDrawable()) != null) {
            Drawable drawable2 = ThemeUtils.getWrapperDrawable(drawable);
            Garb garb = GarbManager.getGarbWithNightMode(getContext());
            Context context = getContext();
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
                Drawable tep = DrawableCompat.wrap(drawable2.mutate());
                DrawableCompat.setTint(tep, ContextCompat.getColor(context, tintColor == 0 ? R.color.nav_footer_icon_color : tintColor));
                setImageDrawable(tep);
            } catch (Resources.NotFoundException e) {
                CrashReporter.INSTANCE.postCaughtException(e);
            }
        }
    }
}