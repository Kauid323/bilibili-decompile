package tv.danmaku.bili.ui.splash.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import tv.danmaku.bili.ui.splash.R;

public final class BiliAppLayoutSplashCountdownViewBinding implements ViewBinding {
    public final TextView countdown;
    public final TextView countdownTitle;
    private final ConstraintLayout rootView;

    private BiliAppLayoutSplashCountdownViewBinding(ConstraintLayout rootView, TextView countdown, TextView countdownTitle) {
        this.rootView = rootView;
        this.countdown = countdown;
        this.countdownTitle = countdownTitle;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppLayoutSplashCountdownViewBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppLayoutSplashCountdownViewBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_layout_splash_countdown_view, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppLayoutSplashCountdownViewBinding bind(View rootView) {
        int id = R.id.countdown;
        TextView countdown = (TextView) ViewBindings.findChildViewById(rootView, id);
        if (countdown != null) {
            id = R.id.countdown_title;
            TextView countdownTitle = (TextView) ViewBindings.findChildViewById(rootView, id);
            if (countdownTitle != null) {
                return new BiliAppLayoutSplashCountdownViewBinding((ConstraintLayout) rootView, countdown, countdownTitle);
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}