package tv.danmaku.bili.ui.main2.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.bilibili.magicasakura.widgets.TintAppBarLayout;

public class HomeAppBarLayout extends TintAppBarLayout {
    private boolean isForcedExpanded;

    public HomeAppBarLayout(Context context) {
        super(context);
        this.isForcedExpanded = false;
    }

    public HomeAppBarLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.isForcedExpanded = false;
    }

    public void setExpanded(boolean expanded, boolean animate) {
        if (expanded) {
            this.isForcedExpanded = true;
        }
        super.setExpanded(expanded, animate);
    }

    public boolean popForceState() {
        boolean result = this.isForcedExpanded;
        this.isForcedExpanded = false;
        return result;
    }
}