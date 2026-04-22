package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.ui.platform.ComposeView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager2.widget.ViewPager2;
import com.bilibili.magicasakura.widgets.TintImageView;
import com.bilibili.magicasakura.widgets.TintView;
import com.google.android.material.tabs.TabLayout;
import tv.danmaku.bili.R;

public final class BiliAppFragmentCollectionTabPageBinding implements ViewBinding {
    public final ComposeView errorView;
    public final TintImageView icon1;
    public final TintImageView icon2;
    public final TintImageView icon3;
    public final ConstraintLayout rightButton;
    public final TintView rightButtonStartBg;
    private final ConstraintLayout rootView;
    public final TabLayout tabLayout;
    public final ConstraintLayout topContainer;
    public final ViewPager2 viewPager;

    private BiliAppFragmentCollectionTabPageBinding(ConstraintLayout rootView, ComposeView errorView, TintImageView icon1, TintImageView icon2, TintImageView icon3, ConstraintLayout rightButton, TintView rightButtonStartBg, TabLayout tabLayout, ConstraintLayout topContainer, ViewPager2 viewPager) {
        this.rootView = rootView;
        this.errorView = errorView;
        this.icon1 = icon1;
        this.icon2 = icon2;
        this.icon3 = icon3;
        this.rightButton = rightButton;
        this.rightButtonStartBg = rightButtonStartBg;
        this.tabLayout = tabLayout;
        this.topContainer = topContainer;
        this.viewPager = viewPager;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppFragmentCollectionTabPageBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppFragmentCollectionTabPageBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_fragment_collection_tab_page, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppFragmentCollectionTabPageBinding bind(View rootView) {
        TintImageView icon1;
        TintImageView icon2;
        TintImageView icon3;
        ConstraintLayout rightButton;
        TintView rightButtonStartBg;
        TabLayout tabLayout;
        ConstraintLayout topContainer;
        ViewPager2 viewPager;
        int id = R.id.error_view;
        ComposeView errorView = ViewBindings.findChildViewById(rootView, id);
        if (errorView != null && (icon1 = ViewBindings.findChildViewById(rootView, (id = R.id.icon_1))) != null && (icon2 = ViewBindings.findChildViewById(rootView, (id = R.id.icon_2))) != null && (icon3 = ViewBindings.findChildViewById(rootView, (id = R.id.icon_3))) != null && (rightButton = ViewBindings.findChildViewById(rootView, (id = R.id.right_button))) != null && (rightButtonStartBg = ViewBindings.findChildViewById(rootView, (id = R.id.right_button_start_bg))) != null && (tabLayout = ViewBindings.findChildViewById(rootView, (id = R.id.tab_layout))) != null && (topContainer = ViewBindings.findChildViewById(rootView, (id = R.id.top_container))) != null && (viewPager = ViewBindings.findChildViewById(rootView, (id = R.id.view_pager))) != null) {
            return new BiliAppFragmentCollectionTabPageBinding((ConstraintLayout) rootView, errorView, icon1, icon2, icon3, rightButton, rightButtonStartBg, tabLayout, topContainer, viewPager);
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}