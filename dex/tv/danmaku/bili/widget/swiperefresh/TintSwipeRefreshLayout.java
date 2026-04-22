package tv.danmaku.bili.widget.swiperefresh;

import android.content.Context;
import android.util.AttributeSet;
import com.bilibili.magicasakura.utils.ThemeUtils;
import com.bilibili.magicasakura.widgets.Tintable;

public class TintSwipeRefreshLayout extends androidx.swiperefreshlayout.widget.SwipeRefreshLayout implements Tintable {
    private int[] schemeColorResIds;

    public TintSwipeRefreshLayout(Context context) {
        this(context, null);
    }

    public TintSwipeRefreshLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setColorSchemeResources(int... colorResIds) {
        this.schemeColorResIds = colorResIds;
        int[] colorRes = new int[colorResIds.length];
        for (int i = 0; i < colorResIds.length; i++) {
            colorRes[i] = ThemeUtils.getColorById(getContext(), colorResIds[i]);
        }
        setColorSchemeColors(colorRes);
    }

    public void tint() {
        if (this.schemeColorResIds == null || this.schemeColorResIds.length == 0) {
            return;
        }
        int[] colors = new int[this.schemeColorResIds.length];
        for (int i = 0; i < this.schemeColorResIds.length; i++) {
            colors[i] = ThemeUtils.getColorById(getContext(), this.schemeColorResIds[i]);
        }
        setColorSchemeColors(colors);
    }
}