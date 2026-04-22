package tv.danmaku.bili.ui.main2.mine.widgets;

import android.content.Context;
import android.util.AttributeSet;
import com.bilibili.lib.ui.util.MultipleThemeUtils;
import com.bilibili.magicasakura.widgets.TintConstraintLayout;

public class MineNightConstraintLayout extends TintConstraintLayout {
    private IDayNightChangeListener mChangeListener;

    public MineNightConstraintLayout(Context context) {
        this(context, null);
    }

    public MineNightConstraintLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MineNightConstraintLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setChangeListener(IDayNightChangeListener changeListener) {
        this.mChangeListener = changeListener;
    }

    public void tint() {
        super.tint();
        if (this.mChangeListener != null) {
            this.mChangeListener.onThemeChange(MultipleThemeUtils.isNightTheme(getContext()));
        }
    }
}