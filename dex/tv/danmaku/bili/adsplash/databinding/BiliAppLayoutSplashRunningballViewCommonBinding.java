package tv.danmaku.bili.adsplash.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import tv.danmaku.bili.adsplash.R;
import tv.danmaku.bili.splash.ad.widget.SplashRunningBallViewV2;

public final class BiliAppLayoutSplashRunningballViewCommonBinding implements ViewBinding {
    private final SplashRunningBallViewV2 rootView;

    private BiliAppLayoutSplashRunningballViewCommonBinding(SplashRunningBallViewV2 rootView) {
        this.rootView = rootView;
    }

    public SplashRunningBallViewV2 getRoot() {
        return this.rootView;
    }

    public static BiliAppLayoutSplashRunningballViewCommonBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppLayoutSplashRunningballViewCommonBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_layout_splash_runningball_view_common, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppLayoutSplashRunningballViewCommonBinding bind(View rootView) {
        if (rootView == null) {
            throw new NullPointerException("rootView");
        }
        return new BiliAppLayoutSplashRunningballViewCommonBinding((SplashRunningBallViewV2) rootView);
    }
}