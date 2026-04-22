package tv.danmaku.bili.splash.ad.utils.ui;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bilibili.app.comm.list.common.utils.ListDeviceInfoKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.splash.ad.model.SplashOrder;
import tv.danmaku.bili.ui.main2.userprotocol.UserProtocolHelper;

/* compiled from: SplashLayoutHelper.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001a\u0018\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0000\u001a\u0016\u0010\t\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\b¨\u0006\u000b"}, d2 = {"createPinkHdCompatFullscreenVideoLayoutParams", "Landroid/view/ViewGroup$LayoutParams;", "rootView", "Landroid/view/ViewGroup;", UserProtocolHelper.UserDialogDismissWatcher.FROM_SPLASH, "Ltv/danmaku/bili/splash/ad/model/SplashOrder;", "createMatchParentHeightLayoutParams", "width", "", "createMatchParentWidthLayoutParams", "height", "adsplash_debug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class SplashLayoutHelperKt {
    public static final ViewGroup.LayoutParams createPinkHdCompatFullscreenVideoLayoutParams(ViewGroup rootView, SplashOrder splash) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(splash, UserProtocolHelper.UserDialogDismissWatcher.FROM_SPLASH);
        if (ListDeviceInfoKt.isHdApp()) {
            return createMatchParentHeightLayoutParams(rootView, (int) (((rootView.getContext().getResources().getDisplayMetrics().heightPixels * splash.getVideoWidth()) * 1.0f) / splash.getVideoHeight()));
        }
        return SplashLayoutUtilsKt.createMatchParentLayoutParams(rootView);
    }

    public static final ViewGroup.LayoutParams createMatchParentHeightLayoutParams(ViewGroup rootView, int width) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        if (rootView instanceof ConstraintLayout) {
            ViewGroup.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(width, -1);
            ((ConstraintLayout.LayoutParams) layoutParams).leftToLeft = 0;
            ((ConstraintLayout.LayoutParams) layoutParams).rightToRight = 0;
            ((ConstraintLayout.LayoutParams) layoutParams).topToTop = 0;
            ((ConstraintLayout.LayoutParams) layoutParams).bottomToBottom = 0;
            return layoutParams;
        } else if (rootView instanceof FrameLayout) {
            return new FrameLayout.LayoutParams(width, -1, 17);
        } else {
            return new ViewGroup.LayoutParams(width, -1);
        }
    }

    public static final ViewGroup.LayoutParams createMatchParentWidthLayoutParams(ViewGroup rootView, int height) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        if (rootView instanceof ConstraintLayout) {
            ViewGroup.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-1, height);
            ((ConstraintLayout.LayoutParams) layoutParams).leftToLeft = 0;
            ((ConstraintLayout.LayoutParams) layoutParams).rightToRight = 0;
            ((ConstraintLayout.LayoutParams) layoutParams).topToTop = 0;
            ((ConstraintLayout.LayoutParams) layoutParams).bottomToBottom = 0;
            return layoutParams;
        } else if (rootView instanceof FrameLayout) {
            return new FrameLayout.LayoutParams(-1, height);
        } else {
            return new ViewGroup.LayoutParams(-1, height);
        }
    }
}