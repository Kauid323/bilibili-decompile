package tv.danmaku.bili.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.bilibili.lib.ui.util.StatusBarCompat;

public class ResizeWindowHelper {
    private View mChildOfContent;
    private int mChildOfContentHeight;
    private FrameLayout.LayoutParams mFrameLayoutParams;
    private int mUsableHeightPrevious;

    public static void assistActivity(Activity activity) {
        new ResizeWindowHelper(activity);
    }

    private ResizeWindowHelper(final Activity activity) {
        final FrameLayout content = (FrameLayout) activity.findViewById(16908290);
        this.mChildOfContent = content.getChildAt(0);
        if (this.mChildOfContent == null) {
            return;
        }
        this.mChildOfContent.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: tv.danmaku.bili.utils.ResizeWindowHelper.1
            boolean isFirst = true;

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (this.isFirst) {
                    this.isFirst = false;
                    ResizeWindowHelper.this.mChildOfContentHeight = ResizeWindowHelper.this.mChildOfContent.getHeight();
                    if (ResizeWindowHelper.this.mChildOfContentHeight != content.getHeight()) {
                        ResizeWindowHelper.this.mChildOfContent.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                        return;
                    }
                }
                ResizeWindowHelper.this.possiblyResizeChildOfContent(activity);
            }
        });
        this.mFrameLayoutParams = (FrameLayout.LayoutParams) this.mChildOfContent.getLayoutParams();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void possiblyResizeChildOfContent(Context context) {
        int usableHeightNow = computeUsableHeight();
        if (usableHeightNow != this.mUsableHeightPrevious) {
            int usableHeightSansKeyboard = this.mChildOfContent.getRootView().getHeight();
            int heightDifference = usableHeightSansKeyboard - usableHeightNow;
            if (heightDifference > usableHeightSansKeyboard / 4) {
                this.mFrameLayoutParams.height = (usableHeightSansKeyboard - heightDifference) + StatusBarCompat.getStatusBarHeight(context);
            } else {
                this.mFrameLayoutParams.height = this.mChildOfContentHeight == 0 ? usableHeightNow : this.mChildOfContentHeight;
            }
            this.mChildOfContent.requestLayout();
            this.mUsableHeightPrevious = usableHeightNow;
        }
    }

    private int computeUsableHeight() {
        Rect r = new Rect();
        this.mChildOfContent.getWindowVisibleDisplayFrame(r);
        return r.bottom - r.top;
    }
}