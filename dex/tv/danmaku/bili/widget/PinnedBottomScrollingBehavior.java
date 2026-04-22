package tv.danmaku.bili.widget;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.google.android.material.appbar.AppBarLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PinnedBottomScrollingBehavior extends AppBarLayout.ScrollingViewBehavior {
    ArrayList<View> mPinnedViewList;

    public PinnedBottomScrollingBehavior() {
        this.mPinnedViewList = new ArrayList<>();
    }

    public PinnedBottomScrollingBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mPinnedViewList = new ArrayList<>();
    }

    public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {
        super.onDependentViewChanged(parent, child, dependency);
        updatePinnedOffset(parent, child, dependency);
        return false;
    }

    public boolean onMeasureChild(CoordinatorLayout parent, View child, int parentWidthMeasureSpec, int widthUsed, int parentHeightMeasureSpec, int heightUsed) {
        if ((child instanceof FrameLayout) && TextUtils.equals(parent.getContext().getString(com.bilibili.lib.widget.R.string.main_content_layout), (CharSequence) child.getTag())) {
            int status = getStatusBarHeight(parent.getContext());
            child.setPadding(0, 0, 0, status);
        }
        return super.onMeasureChild(parent, child, parentWidthMeasureSpec, widthUsed, parentHeightMeasureSpec, heightUsed);
    }

    public boolean onLayoutChild(CoordinatorLayout parent, View child, int layoutDirection) {
        try {
            super.onLayoutChild(parent, child, layoutDirection);
            List<View> dependencies = parent.getDependencies(child);
            int z = dependencies.size();
            for (int i = 0; i < z && !updatePinnedOffset(parent, child, dependencies.get(i)); i++) {
            }
            return true;
        } catch (IllegalStateException e) {
            ViewTreeTraversalHelper.INSTANCE.reportViewTreeIfNeed(child);
            throw e;
        }
    }

    private boolean updatePinnedOffset(CoordinatorLayout parent, View child, View dependency) {
        View directParent;
        PinnedBottomScrollingBehavior pinnedBottomScrollingBehavior = this;
        CoordinatorLayout.LayoutParams params = dependency.getLayoutParams();
        AppBarLayout.Behavior behavior = params.getBehavior();
        int offset = 0;
        boolean isAppBar = false;
        if (behavior instanceof AppBarLayout.Behavior) {
            offset = behavior.getTopAndBottomOffset();
            isAppBar = true;
        }
        int scrollRange = 0;
        if (dependency instanceof AppBarLayout) {
            scrollRange = ((AppBarLayout) dependency).getTotalScrollRange();
        }
        Iterator<View> it = pinnedBottomScrollingBehavior.mPinnedViewList.iterator();
        while (it.hasNext()) {
            View view2 = it.next();
            if (!pinnedBottomScrollingBehavior.layoutDependsOn(parent, child, view2) && ViewCompat.isLaidOut(view2) && pinnedBottomScrollingBehavior.isViewInParent(parent, view2, child) && (directParent = (View) view2.getParent()) != null) {
                ViewGroup.MarginLayoutParams lp = (ViewGroup.MarginLayoutParams) view2.getLayoutParams();
                view2.offsetTopAndBottom(offset);
                int bottom = (directParent.getHeight() - (scrollRange + offset)) - lp.bottomMargin;
                int top = (bottom - view2.getHeight()) - lp.topMargin;
                view2.layout(view2.getLeft(), top, view2.getRight(), bottom);
            }
            pinnedBottomScrollingBehavior = this;
        }
        return isAppBar;
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

    public static <V extends View> PinnedBottomScrollingBehavior from(V view2) {
        CoordinatorLayout.LayoutParams layoutParams = view2.getLayoutParams();
        if (!(layoutParams instanceof CoordinatorLayout.LayoutParams)) {
            throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
        }
        PinnedBottomScrollingBehavior behavior = layoutParams.getBehavior();
        if (!(behavior instanceof PinnedBottomScrollingBehavior)) {
            throw new IllegalArgumentException("The view is not associated with ScrollingViewBehavior");
        }
        return behavior;
    }

    public static int getStatusBarHeight(Context context) {
        int resId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resId <= 0) {
            return 0;
        }
        int result = context.getResources().getDimensionPixelSize(resId);
        return result;
    }

    public static int dp2Px(int dp) {
        return (int) TypedValue.applyDimension(1, dp, Resources.getSystem().getDisplayMetrics());
    }
}