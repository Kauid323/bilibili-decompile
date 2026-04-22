package tv.danmaku.bili.ui.splash.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import tv.danmaku.bili.ui.splash.R;

public final class SplashLayoutBrandSplashSettingPageBinding implements ViewBinding {
    private final View rootView;
    public final RecyclerView splashList;

    private SplashLayoutBrandSplashSettingPageBinding(View rootView, RecyclerView splashList) {
        this.rootView = rootView;
        this.splashList = splashList;
    }

    public View getRoot() {
        return this.rootView;
    }

    public static SplashLayoutBrandSplashSettingPageBinding inflate(LayoutInflater inflater, ViewGroup parent) {
        if (parent == null) {
            throw new NullPointerException("parent");
        }
        inflater.inflate(R.layout.splash_layout_brand_splash_setting_page, parent);
        return bind(parent);
    }

    public static SplashLayoutBrandSplashSettingPageBinding bind(View rootView) {
        int id = R.id.splash_list;
        RecyclerView splashList = ViewBindings.findChildViewById(rootView, id);
        if (splashList != null) {
            return new SplashLayoutBrandSplashSettingPageBinding(rootView, splashList);
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}