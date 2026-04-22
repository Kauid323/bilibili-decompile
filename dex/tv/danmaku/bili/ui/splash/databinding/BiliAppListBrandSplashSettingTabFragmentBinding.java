package tv.danmaku.bili.ui.splash.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bilibili.magicasakura.widgets.TintFrameLayout;
import tv.danmaku.bili.ui.splash.R;

public final class BiliAppListBrandSplashSettingTabFragmentBinding implements ViewBinding {
    private final TintFrameLayout rootView;
    public final RecyclerView rvItems;

    private BiliAppListBrandSplashSettingTabFragmentBinding(TintFrameLayout rootView, RecyclerView rvItems) {
        this.rootView = rootView;
        this.rvItems = rvItems;
    }

    public TintFrameLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppListBrandSplashSettingTabFragmentBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppListBrandSplashSettingTabFragmentBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_list_brand_splash_setting_tab_fragment, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppListBrandSplashSettingTabFragmentBinding bind(View rootView) {
        int id = R.id.rv_items;
        RecyclerView rvItems = ViewBindings.findChildViewById(rootView, id);
        if (rvItems != null) {
            return new BiliAppListBrandSplashSettingTabFragmentBinding((TintFrameLayout) rootView, rvItems);
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}