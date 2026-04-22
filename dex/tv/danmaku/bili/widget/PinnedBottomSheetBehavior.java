package tv.danmaku.bili.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.ViewCompat;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;

public class PinnedBottomSheetBehavior extends BottomSheetBehavior<View> {
    private ArrayList<View> mPinnedViewList;
    private NestedScrollingChild mTargetNestedScrollingChild;

    public PinnedBottomSheetBehavior() {
        this.mPinnedViewList = new ArrayList<>();
    }

    public PinnedBottomSheetBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mPinnedViewList = new ArrayList<>();
    }

    public boolean onLayoutChild(CoordinatorLayout parent, View child, int layoutDirection) {
        super.onLayoutChild(parent, child, layoutDirection);
        updatePinnedOffset(parent, child);
        assignNestedScrollingChildRef(this.mTargetNestedScrollingChild);
        return true;
    }

    private void assignNestedScrollingChildRef(NestedScrollingChild view2) {
        if (view2 == null) {
            return;
        }
        try {
            Field field = BottomSheetBehavior.class.getDeclaredField("nestedScrollingChildRef");
            field.setAccessible(true);
            field.set(this, new WeakReference(view2));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void updatePinnedOffset(CoordinatorLayout parent, View child) {
        Iterator<View> it = this.mPinnedViewList.iterator();
        while (it.hasNext()) {
            View view2 = it.next();
            if (ViewCompat.isLaidOut(view2) && isViewInParent(parent, view2, child)) {
                ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) view2.getLayoutParams();
                int bottom = 0;
                if (getState() == 4) {
                    bottom = Math.min(getPeekHeight(), child.getHeight()) - params.bottomMargin;
                } else if (getState() == 3) {
                    bottom = child.getHeight() - params.bottomMargin;
                }
                if (bottom != 0) {
                    view2.layout(view2.getLeft(), bottom - view2.getHeight(), view2.getRight(), bottom);
                }
            }
        }
    }

    private boolean isViewInParent(CoordinatorLayout root, View view2, View parent) {
        ViewParent p = view2.getParent();
        if (p == parent) {
            return true;
        }
        while (p != root && p != null) {
            if (p instanceof View) {
                p = p.getParent();
                continue;
            }
            if (p == parent) {
                return true;
            }
        }
        return false;
    }

    public void addPinnedView(View view2) {
        if (view2 != null && !this.mPinnedViewList.contains(view2)) {
            this.mPinnedViewList.add(view2);
        }
    }

    public void removePinnedView(View view2) {
        if (view2 != null && this.mPinnedViewList.contains(view2)) {
            this.mPinnedViewList.remove(view2);
        }
    }

    public void setTargetNestedScrollingChild(NestedScrollingChild view2) {
        if (view2 == this.mTargetNestedScrollingChild) {
            return;
        }
        this.mTargetNestedScrollingChild = view2;
        assignNestedScrollingChildRef(this.mTargetNestedScrollingChild);
    }
}