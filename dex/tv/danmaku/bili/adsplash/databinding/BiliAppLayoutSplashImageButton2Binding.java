package tv.danmaku.bili.adsplash.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import tv.danmaku.bili.adsplash.R;
import tv.danmaku.bili.splash.ad.widget.SafeLottieAnimationView;

public final class BiliAppLayoutSplashImageButton2Binding implements ViewBinding {
    private final FrameLayout rootView;
    public final SafeLottieAnimationView splashButtonGuide;
    public final SafeLottieAnimationView splashButtonImage;

    private BiliAppLayoutSplashImageButton2Binding(FrameLayout rootView, SafeLottieAnimationView splashButtonGuide, SafeLottieAnimationView splashButtonImage) {
        this.rootView = rootView;
        this.splashButtonGuide = splashButtonGuide;
        this.splashButtonImage = splashButtonImage;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppLayoutSplashImageButton2Binding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppLayoutSplashImageButton2Binding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_layout_splash_image_button_2, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppLayoutSplashImageButton2Binding bind(View rootView) {
        int id = R.id.splash_button_guide;
        SafeLottieAnimationView splashButtonGuide = (SafeLottieAnimationView) ViewBindings.findChildViewById(rootView, id);
        if (splashButtonGuide != null) {
            id = R.id.splash_button_image;
            SafeLottieAnimationView splashButtonImage = (SafeLottieAnimationView) ViewBindings.findChildViewById(rootView, id);
            if (splashButtonImage != null) {
                return new BiliAppLayoutSplashImageButton2Binding((FrameLayout) rootView, splashButtonGuide, splashButtonImage);
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}