package tv.danmaku.bili.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public class FixedPopupAnchor extends FrameLayout {
    public FixedPopupAnchor(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public FixedPopupAnchor(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FixedPopupAnchor(Context context) {
        super(context);
    }

    @Override // android.view.View
    public boolean requestRectangleOnScreen(Rect rectangle, boolean immediate) {
        return false;
    }
}