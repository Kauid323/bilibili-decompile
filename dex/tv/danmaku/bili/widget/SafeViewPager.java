package tv.danmaku.bili.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;
import com.bilibili.lib.crashreport.CrashReporter;
import tv.danmaku.android.log.BLog;

public class SafeViewPager extends ViewPager {
    private static final String TAG = "SafeViewPager";

    public SafeViewPager(Context context) {
        super(context);
    }

    public SafeViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public boolean onTouchEvent(MotionEvent ev) {
        try {
            return super.onTouchEvent(ev);
        } catch (Throwable e) {
            BLog.e(TAG, "onTouchEvent crashed.", e);
            CrashReporter.INSTANCE.postCaughtException(e);
            return false;
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent ev) {
        try {
            return super.onInterceptTouchEvent(ev);
        } catch (Throwable e) {
            BLog.e(TAG, "onInterceptTouchEvent crashed.", e);
            CrashReporter.INSTANCE.postCaughtException(e);
            return false;
        }
    }
}