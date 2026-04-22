package tv.danmaku.bili.ui.splash.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentContainerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager2.widget.ViewPager2;
import com.bilibili.magicasakura.widgets.TintFrameLayout;
import com.bilibili.magicasakura.widgets.TintLinearLayout;
import com.bilibili.magicasakura.widgets.TintToolbar;
import com.google.android.material.tabs.TabLayout;
import tv.danmaku.bili.ui.splash.R;
import tv.danmaku.bili.widget.LoadingImageViewWButton;

public final class BiliAppListBrandSplashSettingFragmentBinding implements ViewBinding {
    public final FragmentContainerView bottomFloatFragmentContainer;
    public final TabLayout brandSplashTab;
    public final TintLinearLayout contentContainer;
    public final FragmentContainerView fragmentContainer;
    public final LoadingImageViewWButton loadingView;
    public final BiliAppListBrandSplashModeSetLayoutBinding modeSettingArea;
    public final TintFrameLayout modeSettingAreaContainer;
    public final TintToolbar navTopBar;
    private final TintFrameLayout rootView;
    public final FragmentContainerView searchFragmentContainer;
    public final ViewPager2 vpContainer;

    private BiliAppListBrandSplashSettingFragmentBinding(TintFrameLayout rootView, FragmentContainerView bottomFloatFragmentContainer, TabLayout brandSplashTab, TintLinearLayout contentContainer, FragmentContainerView fragmentContainer, LoadingImageViewWButton loadingView, BiliAppListBrandSplashModeSetLayoutBinding modeSettingArea, TintFrameLayout modeSettingAreaContainer, TintToolbar navTopBar, FragmentContainerView searchFragmentContainer, ViewPager2 vpContainer) {
        this.rootView = rootView;
        this.bottomFloatFragmentContainer = bottomFloatFragmentContainer;
        this.brandSplashTab = brandSplashTab;
        this.contentContainer = contentContainer;
        this.fragmentContainer = fragmentContainer;
        this.loadingView = loadingView;
        this.modeSettingArea = modeSettingArea;
        this.modeSettingAreaContainer = modeSettingAreaContainer;
        this.navTopBar = navTopBar;
        this.searchFragmentContainer = searchFragmentContainer;
        this.vpContainer = vpContainer;
    }

    public TintFrameLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppListBrandSplashSettingFragmentBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppListBrandSplashSettingFragmentBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_list_brand_splash_setting_fragment, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppListBrandSplashSettingFragmentBinding bind(View rootView) {
        TabLayout brandSplashTab;
        TintLinearLayout contentContainer;
        FragmentContainerView fragmentContainer;
        View modeSettingArea;
        TintToolbar navTopBar;
        FragmentContainerView searchFragmentContainer;
        ViewPager2 vpContainer;
        int id = R.id.bottom_float_fragment_container;
        FragmentContainerView bottomFloatFragmentContainer = ViewBindings.findChildViewById(rootView, id);
        if (bottomFloatFragmentContainer != null && (brandSplashTab = ViewBindings.findChildViewById(rootView, (id = R.id.brand_splash_tab))) != null && (contentContainer = ViewBindings.findChildViewById(rootView, (id = R.id.content_container))) != null && (fragmentContainer = ViewBindings.findChildViewById(rootView, (id = R.id.fragment_container))) != null) {
            id = R.id.loading_view;
            LoadingImageViewWButton loadingView = (LoadingImageViewWButton) ViewBindings.findChildViewById(rootView, id);
            if (loadingView != null && (modeSettingArea = ViewBindings.findChildViewById(rootView, (id = R.id.mode_setting_area))) != null) {
                BiliAppListBrandSplashModeSetLayoutBinding binding_modeSettingArea = BiliAppListBrandSplashModeSetLayoutBinding.bind(modeSettingArea);
                id = R.id.mode_setting_area_container;
                TintFrameLayout modeSettingAreaContainer = ViewBindings.findChildViewById(rootView, id);
                if (modeSettingAreaContainer != null && (navTopBar = ViewBindings.findChildViewById(rootView, (id = R.id.nav_top_bar))) != null && (searchFragmentContainer = ViewBindings.findChildViewById(rootView, (id = R.id.search_fragment_container))) != null && (vpContainer = ViewBindings.findChildViewById(rootView, (id = R.id.vp_container))) != null) {
                    return new BiliAppListBrandSplashSettingFragmentBinding((TintFrameLayout) rootView, bottomFloatFragmentContainer, brandSplashTab, contentContainer, fragmentContainer, loadingView, binding_modeSettingArea, modeSettingAreaContainer, navTopBar, searchFragmentContainer, vpContainer);
                }
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}