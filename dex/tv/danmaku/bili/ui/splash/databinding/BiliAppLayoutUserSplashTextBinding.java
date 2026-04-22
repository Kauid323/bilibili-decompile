package tv.danmaku.bili.ui.splash.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import tv.danmaku.bili.ui.splash.R;

public final class BiliAppLayoutUserSplashTextBinding implements ViewBinding {
    private final TextView rootView;

    private BiliAppLayoutUserSplashTextBinding(TextView rootView) {
        this.rootView = rootView;
    }

    public TextView getRoot() {
        return this.rootView;
    }

    public static BiliAppLayoutUserSplashTextBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppLayoutUserSplashTextBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_layout_user_splash_text, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppLayoutUserSplashTextBinding bind(View rootView) {
        if (rootView == null) {
            throw new NullPointerException("rootView");
        }
        return new BiliAppLayoutUserSplashTextBinding((TextView) rootView);
    }
}