package tv.danmaku.bili.ui.splash.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import tv.danmaku.bili.ui.splash.R;
import tv.danmaku.bili.ui.splash.widget.CircleImageView;
import tv.danmaku.bili.ui.splash.widget.SplashShimmerTextView;

public final class BiliAppLayoutSplashSlideUnlockBtnBinding implements ViewBinding {
    public final FrameLayout guideContainer;
    private final View rootView;
    public final SplashShimmerTextView splashBtnGuide;
    public final CircleImageView splashBtnLogo;

    private BiliAppLayoutSplashSlideUnlockBtnBinding(View rootView, FrameLayout guideContainer, SplashShimmerTextView splashBtnGuide, CircleImageView splashBtnLogo) {
        this.rootView = rootView;
        this.guideContainer = guideContainer;
        this.splashBtnGuide = splashBtnGuide;
        this.splashBtnLogo = splashBtnLogo;
    }

    public View getRoot() {
        return this.rootView;
    }

    public static BiliAppLayoutSplashSlideUnlockBtnBinding inflate(LayoutInflater inflater, ViewGroup parent) {
        if (parent == null) {
            throw new NullPointerException("parent");
        }
        inflater.inflate(R.layout.bili_app_layout_splash_slide_unlock_btn, parent);
        return bind(parent);
    }

    public static BiliAppLayoutSplashSlideUnlockBtnBinding bind(View rootView) {
        int id = R.id.guide_container;
        FrameLayout guideContainer = (FrameLayout) ViewBindings.findChildViewById(rootView, id);
        if (guideContainer != null) {
            id = R.id.splash_btn_guide;
            SplashShimmerTextView splashBtnGuide = (SplashShimmerTextView) ViewBindings.findChildViewById(rootView, id);
            if (splashBtnGuide != null) {
                id = R.id.splash_btn_logo;
                CircleImageView splashBtnLogo = (CircleImageView) ViewBindings.findChildViewById(rootView, id);
                if (splashBtnLogo != null) {
                    return new BiliAppLayoutSplashSlideUnlockBtnBinding(rootView, guideContainer, splashBtnGuide, splashBtnLogo);
                }
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}