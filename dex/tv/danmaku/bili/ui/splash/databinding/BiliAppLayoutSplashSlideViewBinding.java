package tv.danmaku.bili.ui.splash.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import tv.danmaku.bili.ui.splash.R;
import tv.danmaku.bili.ui.splash.ad.button.widget.SafeLottieAnimationView;
import tv.danmaku.bili.ui.splash.widget.SplashSlideUnlockView;

public final class BiliAppLayoutSplashSlideViewBinding implements ViewBinding {
    private final FrameLayout rootView;
    public final SplashSlideUnlockView slideView;
    public final SafeLottieAnimationView splashSlideGuide;

    private BiliAppLayoutSplashSlideViewBinding(FrameLayout rootView, SplashSlideUnlockView slideView, SafeLottieAnimationView splashSlideGuide) {
        this.rootView = rootView;
        this.slideView = slideView;
        this.splashSlideGuide = splashSlideGuide;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppLayoutSplashSlideViewBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppLayoutSplashSlideViewBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_layout_splash_slide_view, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppLayoutSplashSlideViewBinding bind(View rootView) {
        int id = R.id.slide_view;
        SplashSlideUnlockView slideView = (SplashSlideUnlockView) ViewBindings.findChildViewById(rootView, id);
        if (slideView != null) {
            id = R.id.splash_slide_guide;
            SafeLottieAnimationView splashSlideGuide = (SafeLottieAnimationView) ViewBindings.findChildViewById(rootView, id);
            if (splashSlideGuide != null) {
                return new BiliAppLayoutSplashSlideViewBinding((FrameLayout) rootView, slideView, splashSlideGuide);
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}