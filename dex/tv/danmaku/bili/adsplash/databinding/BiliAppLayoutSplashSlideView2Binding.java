package tv.danmaku.bili.adsplash.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import tv.danmaku.bili.adsplash.R;
import tv.danmaku.bili.splash.ad.widget.SafeLottieAnimationView;
import tv.danmaku.bili.splash.ad.widget.SplashSlideUnlockView;

public final class BiliAppLayoutSplashSlideView2Binding implements ViewBinding {
    private final FrameLayout rootView;
    public final SplashSlideUnlockView slideView;
    public final SafeLottieAnimationView splashSlideGuide;

    private BiliAppLayoutSplashSlideView2Binding(FrameLayout rootView, SplashSlideUnlockView slideView, SafeLottieAnimationView splashSlideGuide) {
        this.rootView = rootView;
        this.slideView = slideView;
        this.splashSlideGuide = splashSlideGuide;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppLayoutSplashSlideView2Binding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppLayoutSplashSlideView2Binding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_layout_splash_slide_view_2, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppLayoutSplashSlideView2Binding bind(View rootView) {
        int id = R.id.slide_view;
        SplashSlideUnlockView slideView = (SplashSlideUnlockView) ViewBindings.findChildViewById(rootView, id);
        if (slideView != null) {
            id = R.id.splash_slide_guide;
            SafeLottieAnimationView splashSlideGuide = (SafeLottieAnimationView) ViewBindings.findChildViewById(rootView, id);
            if (splashSlideGuide != null) {
                return new BiliAppLayoutSplashSlideView2Binding((FrameLayout) rootView, slideView, splashSlideGuide);
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}