package tv.danmaku.bili.ui.rank.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.ui.platform.ComposeView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager.widget.ViewPager;
import com.bilibili.magicasakura.widgets.TintLinearLayout;
import com.bilibili.magicasakura.widgets.TintToolbar;
import tv.danmaku.bili.ui.rank.R;
import tv.danmaku.bili.widget.PagerSlidingTabStrip;

public final class BiliAppLayoutFragmentPagerContainerBinding implements ViewBinding {
    public final TintLinearLayout appbar;
    public final ComposeView errorView;
    public final TintToolbar navTopBar;
    public final ViewPager pager;
    private final TintLinearLayout rootView;
    public final PagerSlidingTabStrip tabs;

    private BiliAppLayoutFragmentPagerContainerBinding(TintLinearLayout rootView, TintLinearLayout appbar, ComposeView errorView, TintToolbar navTopBar, ViewPager pager, PagerSlidingTabStrip tabs) {
        this.rootView = rootView;
        this.appbar = appbar;
        this.errorView = errorView;
        this.navTopBar = navTopBar;
        this.pager = pager;
        this.tabs = tabs;
    }

    public TintLinearLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppLayoutFragmentPagerContainerBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppLayoutFragmentPagerContainerBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_layout_fragment_pager_container, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppLayoutFragmentPagerContainerBinding bind(View rootView) {
        ComposeView errorView;
        TintToolbar navTopBar;
        ViewPager pager;
        int id = R.id.appbar;
        TintLinearLayout appbar = ViewBindings.findChildViewById(rootView, id);
        if (appbar != null && (errorView = ViewBindings.findChildViewById(rootView, (id = R.id.error_view))) != null && (navTopBar = ViewBindings.findChildViewById(rootView, (id = R.id.nav_top_bar))) != null && (pager = ViewBindings.findChildViewById(rootView, (id = R.id.pager))) != null) {
            id = R.id.tabs;
            PagerSlidingTabStrip tabs = (PagerSlidingTabStrip) ViewBindings.findChildViewById(rootView, id);
            if (tabs != null) {
                return new BiliAppLayoutFragmentPagerContainerBinding((TintLinearLayout) rootView, appbar, errorView, navTopBar, pager, tabs);
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}