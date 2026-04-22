package tv.danmaku.bili.ui.splash.ad.util;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: SplashLayoutHelper.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¨\u0006\u0004"}, d2 = {"createMatchParentLayoutParams", "Landroid/view/ViewGroup$LayoutParams;", "rootView", "Landroid/view/ViewGroup;", "splash_debug"}, k = 2, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class SplashLayoutHelperKt {
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
}