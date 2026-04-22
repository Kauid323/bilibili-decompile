package tv.danmaku.bili.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;

public class NoScrollViewPager extends ViewPager {
    private boolean isCanScroll;

    public NoScrollViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.isCanScroll = false;
    }

    public NoScrollViewPager(Context context) {
        super(context);
        this.isCanScroll = false;
    }

    public boolean onTouchEvent(MotionEvent ev) {
        return this.isCanScroll && super.onTouchEvent(ev);
    }

    public boolean onInterceptTouchEvent(MotionEvent arg0) {
        return this.isCanScroll && super.onInterceptTouchEvent(arg0);
    }

    public void setScrollble(boolean isCanScroll) {
        this.isCanScroll = isCanScroll;
    }
}