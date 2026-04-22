package tv.danmaku.bili.ui.main2.mine.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import com.bilibili.lib.ui.garb.Garb;
import com.bilibili.lib.ui.garb.GarbManager;
import com.bilibili.lib.ui.util.MultipleThemeUtils;
import com.bilibili.magicasakura.widgets.Tintable;
import tv.danmaku.bili.R;

public class MultipleThemeTextView extends AppCompatTextView implements Tintable {
    protected boolean mFitPrimaryOnly;
    protected int mGarbDarkModeColor;
    protected int mGarbLightModeColor;
    protected int mNightModeColor;
    protected int mPinkModeColor;
    protected int mWhiteModeColor;

    public MultipleThemeTextView(Context context) {
        this(context, null);
    }

    public MultipleThemeTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MultipleThemeTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        try {
            TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.MultipleThemeTextView, defStyleAttr, 0);
            if (a.hasValue(R.styleable.MultipleThemeTextView_pinkModeColor)) {
                this.mPinkModeColor = a.getResourceId(R.styleable.MultipleThemeTextView_pinkModeColor, 0);
            }
            if (a.hasValue(R.styleable.MultipleThemeTextView_whiteModeColor)) {
                this.mWhiteModeColor = a.getResourceId(R.styleable.MultipleThemeTextView_whiteModeColor, 0);
            }
            if (a.hasValue(R.styleable.MultipleThemeTextView_nightModeColor)) {
                this.mNightModeColor = a.getResourceId(R.styleable.MultipleThemeTextView_nightModeColor, 0);
            }
            if (a.hasValue(R.styleable.MultipleThemeTextView_garbDarkColor)) {
                this.mGarbDarkModeColor = a.getResourceId(R.styleable.MultipleThemeTextView_garbDarkColor, 0);
            }
            if (a.hasValue(R.styleable.MultipleThemeTextView_garbLightColor)) {
                this.mGarbLightModeColor = a.getResourceId(R.styleable.MultipleThemeTextView_garbLightColor, 0);
            }
            if (a.hasValue(R.styleable.MultipleThemeTextView_fitGarbPrimaryOnly)) {
                this.mFitPrimaryOnly = a.getBoolean(R.styleable.MultipleThemeTextView_fitGarbPrimaryOnly, false);
            }
            a.recycle();
        } catch (Exception e) {
        }
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        tint();
    }

    public void tint() {
        Context context = getContext();
        Garb garb = GarbManager.getGarbWithNightMode(context);
        if (garb.isPure()) {
            if (garb.isNight()) {
                if (this.mNightModeColor != 0) {
                    setTextColor(ContextCompat.getColor(context, this.mNightModeColor));
                }
            } else if (garb.isWhite()) {
                if (this.mWhiteModeColor != 0) {
                    setTextColor(ContextCompat.getColor(context, this.mWhiteModeColor));
                }
            } else if (this.mPinkModeColor != 0) {
                setTextColor(ContextCompat.getColor(context, this.mPinkModeColor));
            }
        } else if (this.mFitPrimaryOnly && garb.isPrimaryOnly()) {
            if (MultipleThemeUtils.isWhiteTheme(context) && this.mWhiteModeColor != 0) {
                setTextColor(ContextCompat.getColor(context, this.mWhiteModeColor));
            } else if (MultipleThemeUtils.isNightTheme(context) && this.mNightModeColor != 0) {
                setTextColor(ContextCompat.getColor(context, this.mNightModeColor));
            }
        } else if (!garb.isDarkMode()) {
            if (this.mGarbDarkModeColor != 0) {
                setTextColor(ContextCompat.getColor(context, this.mGarbDarkModeColor));
            }
        } else if (this.mGarbLightModeColor != 0) {
            setTextColor(ContextCompat.getColor(context, this.mGarbLightModeColor));
        }
    }
}