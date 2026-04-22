package tv.danmaku.bili.ui.splash.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import tv.danmaku.bili.ui.splash.R;

public final class BiliAppLayoutSplashSettingsTitleItemBinding implements ViewBinding {
    private final TextView rootView;

    private BiliAppLayoutSplashSettingsTitleItemBinding(TextView rootView) {
        this.rootView = rootView;
    }

    public TextView getRoot() {
        return this.rootView;
    }

    public static BiliAppLayoutSplashSettingsTitleItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppLayoutSplashSettingsTitleItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_layout_splash_settings_title_item, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppLayoutSplashSettingsTitleItemBinding bind(View rootView) {
        if (rootView == null) {
            throw new NullPointerException("rootView");
        }
        return new BiliAppLayoutSplashSettingsTitleItemBinding((TextView) rootView);
    }
}