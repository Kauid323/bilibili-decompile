package tv.danmaku.bili.splash.ad.utils.ui;

import android.graphics.Rect;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: SplashLayoutUtils.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0016\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"createMatchParentLayoutParams", "Landroid/view/ViewGroup$LayoutParams;", "rootView", "Landroid/view/ViewGroup;", "rectToLayoutParams", "container", "rect", "Landroid/graphics/Rect;", "splashwidget_debug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class SplashLayoutUtilsKt {
    public static final ViewGroup.LayoutParams createMatchParentLayoutParams(ViewGroup rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        if (rootView instanceof ConstraintLayout) {
            ViewGroup.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-1, -1);
            ((ConstraintLayout.LayoutParams) layoutParams).leftToLeft = 0;
            ((ConstraintLayout.LayoutParams) layoutParams).rightToRight = 0;
            ((ConstraintLayout.LayoutParams) layoutParams).topToTop = 0;
            ((ConstraintLayout.LayoutParams) layoutParams).bottomToBottom = 0;
            return layoutParams;
        } else if (rootView instanceof FrameLayout) {
            return new FrameLayout.LayoutParams(-1, -1);
        } else {
            return new ViewGroup.LayoutParams(-1, -1);
        }
    }

    public static final ViewGroup.LayoutParams rectToLayoutParams(ViewGroup container, Rect rect) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(rect, "rect");
        if (container instanceof ConstraintLayout) {
            ViewGroup.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(rect.width(), rect.height());
            ((ConstraintLayout.LayoutParams) layoutParams).leftMargin = rect.left;
            ((ConstraintLayout.LayoutParams) layoutParams).rightMargin = rect.left;
            ((ConstraintLayout.LayoutParams) layoutParams).topMargin = rect.top;
            ((ConstraintLayout.LayoutParams) layoutParams).topToTop = 0;
            ((ConstraintLayout.LayoutParams) layoutParams).startToStart = 0;
            ((ConstraintLayout.LayoutParams) layoutParams).endToEnd = 0;
            return layoutParams;
        } else if (container instanceof FrameLayout) {
            FrameLayout.LayoutParams $this$rectToLayoutParams_u24lambda_u241 = new FrameLayout.LayoutParams(rect.width(), rect.height());
            $this$rectToLayoutParams_u24lambda_u241.leftMargin = rect.left;
            $this$rectToLayoutParams_u24lambda_u241.rightMargin = rect.left;
            $this$rectToLayoutParams_u24lambda_u241.topMargin = rect.top;
            $this$rectToLayoutParams_u24lambda_u241.gravity = 1;
            return $this$rectToLayoutParams_u24lambda_u241;
        } else if (container instanceof LinearLayout) {
            LinearLayout.LayoutParams $this$rectToLayoutParams_u24lambda_u242 = new LinearLayout.LayoutParams(rect.width(), rect.height());
            $this$rectToLayoutParams_u24lambda_u242.leftMargin = rect.left;
            $this$rectToLayoutParams_u24lambda_u242.rightMargin = rect.left;
            $this$rectToLayoutParams_u24lambda_u242.topMargin = rect.top;
            return $this$rectToLayoutParams_u24lambda_u242;
        } else {
            ViewGroup.MarginLayoutParams $this$rectToLayoutParams_u24lambda_u243 = new ViewGroup.MarginLayoutParams(rect.width(), rect.height());
            $this$rectToLayoutParams_u24lambda_u243.leftMargin = rect.left;
            $this$rectToLayoutParams_u24lambda_u243.rightMargin = rect.left;
            $this$rectToLayoutParams_u24lambda_u243.topMargin = rect.top;
            return $this$rectToLayoutParams_u24lambda_u243;
        }
    }
}