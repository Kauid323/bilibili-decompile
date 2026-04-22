package tv.danmaku.bili.ui.splash.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import tv.danmaku.bili.ui.splash.R;
import tv.danmaku.bili.ui.splash.widget.SplashRunningBallView;

public final class BiliAppLayoutSplashRunningballViewBinding implements ViewBinding {
    private final SplashRunningBallView rootView;

    private BiliAppLayoutSplashRunningballViewBinding(SplashRunningBallView rootView) {
        this.rootView = rootView;
    }

    public SplashRunningBallView getRoot() {
        return this.rootView;
    }

    public static BiliAppLayoutSplashRunningballViewBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppLayoutSplashRunningballViewBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_layout_splash_runningball_view, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppLayoutSplashRunningballViewBinding bind(View rootView) {
        if (rootView == null) {
            throw new NullPointerException("rootView");
        }
        return new BiliAppLayoutSplashRunningballViewBinding((SplashRunningBallView) rootView);
    }
}