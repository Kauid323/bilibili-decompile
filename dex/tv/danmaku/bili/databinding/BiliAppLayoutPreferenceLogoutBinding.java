package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import tv.danmaku.bili.R;
import tv.danmaku.bili.widget.ForegroundRelativeLayout;

public final class BiliAppLayoutPreferenceLogoutBinding implements ViewBinding {
    private final ForegroundRelativeLayout rootView;

    private BiliAppLayoutPreferenceLogoutBinding(ForegroundRelativeLayout rootView) {
        this.rootView = rootView;
    }

    public ForegroundRelativeLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppLayoutPreferenceLogoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppLayoutPreferenceLogoutBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_layout_preference_logout, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppLayoutPreferenceLogoutBinding bind(View rootView) {
        if (rootView == null) {
            throw new NullPointerException("rootView");
        }
        return new BiliAppLayoutPreferenceLogoutBinding((ForegroundRelativeLayout) rootView);
    }
}