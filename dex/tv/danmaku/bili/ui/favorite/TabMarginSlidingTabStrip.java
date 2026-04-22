package tv.danmaku.bili.ui.favorite;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import tv.danmaku.bili.widget.PagerSlidingTabStrip;

public class TabMarginSlidingTabStrip extends PagerSlidingTabStrip {
    public TabMarginSlidingTabStrip(Context context) {
        super(context);
    }

    public TabMarginSlidingTabStrip(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TabMarginSlidingTabStrip(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void setTabItemMargin(int margin) {
        if (this.tabsContainer != null && this.tabsContainer.getChildCount() > 0) {
            for (int i = 0; i < this.tabsContainer.getChildCount(); i++) {
                View tab = this.tabsContainer.getChildAt(i);
                ((ViewGroup.MarginLayoutParams) tab.getLayoutParams()).rightMargin = margin;
            }
        }
    }
}