package tv.danmaku.bili.ui.splash.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.ui.platform.ComposeView;
import androidx.viewbinding.ViewBinding;
import tv.danmaku.bili.ui.splash.R;

public final class BiliAppListBrandSplashSearchFragmentBinding implements ViewBinding {
    public final ComposeView composeContainer;
    private final ComposeView rootView;

    private BiliAppListBrandSplashSearchFragmentBinding(ComposeView rootView, ComposeView composeContainer) {
        this.rootView = rootView;
        this.composeContainer = composeContainer;
    }

    public ComposeView getRoot() {
        return this.rootView;
    }

    public static BiliAppListBrandSplashSearchFragmentBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppListBrandSplashSearchFragmentBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_list_brand_splash_search_fragment, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppListBrandSplashSearchFragmentBinding bind(View rootView) {
        if (rootView == null) {
            throw new NullPointerException("rootView");
        }
        ComposeView composeContainer = (ComposeView) rootView;
        return new BiliAppListBrandSplashSearchFragmentBinding((ComposeView) rootView, composeContainer);
    }
}