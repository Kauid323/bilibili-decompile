package tv.danmaku.bili.ui.splash.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import com.bilibili.magicasakura.widgets.TintFrameLayout;
import tv.danmaku.bili.ui.splash.R;

public final class BiliAppListBrandSplashTitleItemBinding implements ViewBinding {
    private final TintFrameLayout rootView;

    private BiliAppListBrandSplashTitleItemBinding(TintFrameLayout rootView) {
        this.rootView = rootView;
    }

    public TintFrameLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppListBrandSplashTitleItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppListBrandSplashTitleItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_list_brand_splash_title_item, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppListBrandSplashTitleItemBinding bind(View rootView) {
        if (rootView == null) {
            throw new NullPointerException("rootView");
        }
        return new BiliAppListBrandSplashTitleItemBinding((TintFrameLayout) rootView);
    }
}