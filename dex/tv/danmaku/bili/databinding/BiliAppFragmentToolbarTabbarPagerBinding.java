package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager.widget.ViewPager;
import com.bilibili.magicasakura.widgets.TintToolbar;
import com.google.android.material.appbar.AppBarLayout;
import tv.danmaku.bili.R;
import tv.danmaku.bili.widget.PagerSlidingTabStrip;

public final class BiliAppFragmentToolbarTabbarPagerBinding implements ViewBinding {
    public final AppBarLayout appBar;
    public final ImageView ivCreateFolder;
    public final BiliAppLayoutFavoriteHomeErrorBinding layoutTip;
    public final TintToolbar navTopBar;
    public final ViewPager pager;
    public final LinearLayout root;
    private final LinearLayout rootView;
    public final PagerSlidingTabStrip tabs;

    private BiliAppFragmentToolbarTabbarPagerBinding(LinearLayout rootView, AppBarLayout appBar, ImageView ivCreateFolder, BiliAppLayoutFavoriteHomeErrorBinding layoutTip, TintToolbar navTopBar, ViewPager pager, LinearLayout root, PagerSlidingTabStrip tabs) {
        this.rootView = rootView;
        this.appBar = appBar;
        this.ivCreateFolder = ivCreateFolder;
        this.layoutTip = layoutTip;
        this.navTopBar = navTopBar;
        this.pager = pager;
        this.root = root;
        this.tabs = tabs;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppFragmentToolbarTabbarPagerBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppFragmentToolbarTabbarPagerBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_fragment_toolbar_tabbar_pager, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppFragmentToolbarTabbarPagerBinding bind(View rootView) {
        View layoutTip;
        ViewPager pager;
        int id = R.id.app_bar;
        AppBarLayout appBar = ViewBindings.findChildViewById(rootView, id);
        if (appBar != null) {
            id = R.id.iv_create_folder;
            ImageView ivCreateFolder = (ImageView) ViewBindings.findChildViewById(rootView, id);
            if (ivCreateFolder != null && (layoutTip = ViewBindings.findChildViewById(rootView, (id = R.id.layout_tip))) != null) {
                BiliAppLayoutFavoriteHomeErrorBinding binding_layoutTip = BiliAppLayoutFavoriteHomeErrorBinding.bind(layoutTip);
                id = R.id.nav_top_bar;
                TintToolbar navTopBar = ViewBindings.findChildViewById(rootView, id);
                if (navTopBar != null && (pager = ViewBindings.findChildViewById(rootView, (id = R.id.pager))) != null) {
                    LinearLayout root = (LinearLayout) rootView;
                    id = R.id.tabs;
                    PagerSlidingTabStrip tabs = ViewBindings.findChildViewById(rootView, id);
                    if (tabs != null) {
                        return new BiliAppFragmentToolbarTabbarPagerBinding((LinearLayout) rootView, appBar, ivCreateFolder, binding_layoutTip, navTopBar, pager, root, tabs);
                    }
                }
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}