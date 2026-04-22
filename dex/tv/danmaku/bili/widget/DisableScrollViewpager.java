package tv.danmaku.bili.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.viewpager.widget.ViewPager;

public class DisableScrollViewpager extends ViewPager {
    private boolean mIsPagingEnabled;

    public DisableScrollViewpager(Context context) {
        super(context);
        this.mIsPagingEnabled = true;
    }

    public DisableScrollViewpager(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mIsPagingEnabled = true;
    }

    public boolean canScrollHorizontally(int direction) {
        if (this.mIsPagingEnabled) {
            return super.canScrollHorizontally(direction);
        }
        return false;
    }

    public void setPagingEnabled(boolean isPagingEnabled) {
        this.mIsPagingEnabled = isPagingEnabled;
    }
}