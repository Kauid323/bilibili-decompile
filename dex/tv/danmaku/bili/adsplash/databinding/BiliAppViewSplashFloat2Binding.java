package tv.danmaku.bili.adsplash.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import tv.danmaku.bili.adsplash.R;

public final class BiliAppViewSplashFloat2Binding implements ViewBinding {
    public final FrameLayout floatContainer;
    public final TextView jumpApp;
    public final TextView jumpTip;
    public final LinearLayout jumpView;
    private final FrameLayout rootView;

    private BiliAppViewSplashFloat2Binding(FrameLayout rootView, FrameLayout floatContainer, TextView jumpApp, TextView jumpTip, LinearLayout jumpView) {
        this.rootView = rootView;
        this.floatContainer = floatContainer;
        this.jumpApp = jumpApp;
        this.jumpTip = jumpTip;
        this.jumpView = jumpView;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppViewSplashFloat2Binding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppViewSplashFloat2Binding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_view_splash_float_2, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppViewSplashFloat2Binding bind(View rootView) {
        FrameLayout floatContainer = (FrameLayout) rootView;
        int id = R.id.jump_app;
        TextView jumpApp = (TextView) ViewBindings.findChildViewById(rootView, id);
        if (jumpApp != null) {
            id = R.id.jump_tip;
            TextView jumpTip = (TextView) ViewBindings.findChildViewById(rootView, id);
            if (jumpTip != null) {
                int id2 = R.id.jump_view;
                LinearLayout jumpView = (LinearLayout) ViewBindings.findChildViewById(rootView, id2);
                if (jumpView == null) {
                    id = id2;
                } else {
                    return new BiliAppViewSplashFloat2Binding((FrameLayout) rootView, floatContainer, jumpApp, jumpTip, jumpView);
                }
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}