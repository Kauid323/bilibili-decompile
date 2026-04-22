package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.ui.platform.ComposeView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager2.widget.ViewPager2;
import com.bilibili.magicasakura.widgets.TintFrameLayout;
import com.bilibili.magicasakura.widgets.TintLinearLayout;
import com.bilibili.magicasakura.widgets.TintTextView;
import com.bilibili.magicasakura.widgets.TintToolbar;
import com.google.android.material.tabs.TabLayout;
import tv.danmaku.bili.R;

public final class BiliAppActivityCollectionV2Binding implements ViewBinding {
    public final TintTextView cancelManage;
    public final ComposeView errorView;
    public final TintTextView manageTitle;
    public final TintToolbar navTopBar;
    private final TintLinearLayout rootView;
    public final TabLayout tabLayout;
    public final TintFrameLayout toolBarContainer;
    public final TintToolbar toolBarManage;
    public final TintTextView toolBarTitle;
    public final ViewPager2 viewPager;

    private BiliAppActivityCollectionV2Binding(TintLinearLayout rootView, TintTextView cancelManage, ComposeView errorView, TintTextView manageTitle, TintToolbar navTopBar, TabLayout tabLayout, TintFrameLayout toolBarContainer, TintToolbar toolBarManage, TintTextView toolBarTitle, ViewPager2 viewPager) {
        this.rootView = rootView;
        this.cancelManage = cancelManage;
        this.errorView = errorView;
        this.manageTitle = manageTitle;
        this.navTopBar = navTopBar;
        this.tabLayout = tabLayout;
        this.toolBarContainer = toolBarContainer;
        this.toolBarManage = toolBarManage;
        this.toolBarTitle = toolBarTitle;
        this.viewPager = viewPager;
    }

    public TintLinearLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppActivityCollectionV2Binding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppActivityCollectionV2Binding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_activity_collection_v2, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppActivityCollectionV2Binding bind(View rootView) {
        ComposeView errorView;
        TintTextView manageTitle;
        TintToolbar navTopBar;
        TabLayout tabLayout;
        TintFrameLayout toolBarContainer;
        TintToolbar toolBarManage;
        TintTextView toolBarTitle;
        ViewPager2 viewPager;
        int id = R.id.cancel_manage;
        TintTextView cancelManage = ViewBindings.findChildViewById(rootView, id);
        if (cancelManage != null && (errorView = ViewBindings.findChildViewById(rootView, (id = R.id.error_view))) != null && (manageTitle = ViewBindings.findChildViewById(rootView, (id = R.id.manage_title))) != null && (navTopBar = ViewBindings.findChildViewById(rootView, (id = R.id.nav_top_bar))) != null && (tabLayout = ViewBindings.findChildViewById(rootView, (id = R.id.tab_layout))) != null && (toolBarContainer = ViewBindings.findChildViewById(rootView, (id = R.id.tool_bar_container))) != null && (toolBarManage = ViewBindings.findChildViewById(rootView, (id = R.id.tool_bar_manage))) != null && (toolBarTitle = ViewBindings.findChildViewById(rootView, (id = R.id.tool_bar_title))) != null && (viewPager = ViewBindings.findChildViewById(rootView, (id = R.id.view_pager))) != null) {
            return new BiliAppActivityCollectionV2Binding((TintLinearLayout) rootView, cancelManage, errorView, manageTitle, navTopBar, tabLayout, toolBarContainer, toolBarManage, toolBarTitle, viewPager);
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}