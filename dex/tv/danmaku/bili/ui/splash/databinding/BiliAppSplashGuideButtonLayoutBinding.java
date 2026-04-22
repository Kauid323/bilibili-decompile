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

public final class BiliAppSplashGuideButtonLayoutBinding implements ViewBinding {
    public final ImageView guideIcon;
    public final TextView guideText;
    private final ConstraintLayout rootView;
    public final TextView secondaryGuideText;

    private BiliAppSplashGuideButtonLayoutBinding(ConstraintLayout rootView, ImageView guideIcon, TextView guideText, TextView secondaryGuideText) {
        this.rootView = rootView;
        this.guideIcon = guideIcon;
        this.guideText = guideText;
        this.secondaryGuideText = secondaryGuideText;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppSplashGuideButtonLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppSplashGuideButtonLayoutBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_splash_guide_button_layout, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppSplashGuideButtonLayoutBinding bind(View rootView) {
        int id = R.id.guide_icon;
        ImageView guideIcon = (ImageView) ViewBindings.findChildViewById(rootView, id);
        if (guideIcon != null) {
            id = R.id.guide_text;
            TextView guideText = (TextView) ViewBindings.findChildViewById(rootView, id);
            if (guideText != null) {
                id = R.id.secondary_guide_text;
                TextView secondaryGuideText = (TextView) ViewBindings.findChildViewById(rootView, id);
                if (secondaryGuideText != null) {
                    return new BiliAppSplashGuideButtonLayoutBinding((ConstraintLayout) rootView, guideIcon, guideText, secondaryGuideText);
                }
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}