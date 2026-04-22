package tv.danmaku.bili.ui.splash.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import tv.danmaku.bili.ui.splash.R;
import tv.danmaku.bili.ui.splash.widget.SplashImageView;

public final class SplashFragmentEventSplashBinding implements ViewBinding {
    public final SplashImageView backgroundImage;
    public final ImageView logo;
    public final ConstraintLayout root;
    private final ConstraintLayout rootView;
    public final TextView skip;

    private SplashFragmentEventSplashBinding(ConstraintLayout rootView, SplashImageView backgroundImage, ImageView logo, ConstraintLayout root, TextView skip) {
        this.rootView = rootView;
        this.backgroundImage = backgroundImage;
        this.logo = logo;
        this.root = root;
        this.skip = skip;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static SplashFragmentEventSplashBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static SplashFragmentEventSplashBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.splash_fragment_event_splash, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static SplashFragmentEventSplashBinding bind(View rootView) {
        int id = R.id.background_image;
        SplashImageView backgroundImage = (SplashImageView) ViewBindings.findChildViewById(rootView, id);
        if (backgroundImage != null) {
            id = R.id.logo;
            ImageView logo = (ImageView) ViewBindings.findChildViewById(rootView, id);
            if (logo != null) {
                ConstraintLayout root = (ConstraintLayout) rootView;
                id = R.id.skip;
                TextView skip = (TextView) ViewBindings.findChildViewById(rootView, id);
                if (skip != null) {
                    return new SplashFragmentEventSplashBinding((ConstraintLayout) rootView, backgroundImage, logo, root, skip);
                }
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}