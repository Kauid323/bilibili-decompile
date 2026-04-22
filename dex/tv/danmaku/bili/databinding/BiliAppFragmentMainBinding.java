package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bilibili.lib.homepage.widget.HomePagerSlidingTabStrip;
import com.bilibili.lib.homepage.widget.TabHost;
import com.bilibili.lib.image2.view.BiliImageView;
import com.bilibili.magicasakura.widgets.TintImageView;
import com.bilibili.magicasakura.widgets.TintLinearLayout;
import tv.danmaku.bili.R;
import tv.danmaku.bili.ui.main2.basic.ToolbarCenterTextView;
import tv.danmaku.bili.ui.main2.widget.HomeAppBarLayout;
import tv.danmaku.bili.widget.SwitchTextView;
import tv.danmaku.bili.widget.VerifyAnimationAvatarFrameLayout;

public final class BiliAppFragmentMainBinding implements ViewBinding {
    public final HomeAppBarLayout appBar;
    public final VerifyAnimationAvatarFrameLayout avatar;
    public final ConstraintLayout avatarLayout;
    public final BiliImageView avatarRect;
    public final BiliImageView avatarRectBg;
    public final FrameLayout avatarRectLayout;
    public final TabHost bottomNavigation;
    public final FrameLayout content;
    public final CoordinatorLayout coordinatorLayout;
    public final TintLinearLayout expandSearch;
    public final TintImageView ivTeenUmbrella;
    public final ImageView mainTopBg;
    public final FrameLayout mainTopLayout;
    public final Toolbar navTopBar;
    public final LinearLayout navigation;
    public final ToolbarCenterTextView nickName;
    private final CoordinatorLayout rootView;
    public final TintImageView searchIcon;
    public final SwitchTextView searchText;
    public final HomePagerSlidingTabStrip toolbarTabs;

    private BiliAppFragmentMainBinding(CoordinatorLayout rootView, HomeAppBarLayout appBar, VerifyAnimationAvatarFrameLayout avatar, ConstraintLayout avatarLayout, BiliImageView avatarRect, BiliImageView avatarRectBg, FrameLayout avatarRectLayout, TabHost bottomNavigation, FrameLayout content, CoordinatorLayout coordinatorLayout, TintLinearLayout expandSearch, TintImageView ivTeenUmbrella, ImageView mainTopBg, FrameLayout mainTopLayout, Toolbar navTopBar, LinearLayout navigation, ToolbarCenterTextView nickName, TintImageView searchIcon, SwitchTextView searchText, HomePagerSlidingTabStrip toolbarTabs) {
        this.rootView = rootView;
        this.appBar = appBar;
        this.avatar = avatar;
        this.avatarLayout = avatarLayout;
        this.avatarRect = avatarRect;
        this.avatarRectBg = avatarRectBg;
        this.avatarRectLayout = avatarRectLayout;
        this.bottomNavigation = bottomNavigation;
        this.content = content;
        this.coordinatorLayout = coordinatorLayout;
        this.expandSearch = expandSearch;
        this.ivTeenUmbrella = ivTeenUmbrella;
        this.mainTopBg = mainTopBg;
        this.mainTopLayout = mainTopLayout;
        this.navTopBar = navTopBar;
        this.navigation = navigation;
        this.nickName = nickName;
        this.searchIcon = searchIcon;
        this.searchText = searchText;
        this.toolbarTabs = toolbarTabs;
    }

    public CoordinatorLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppFragmentMainBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppFragmentMainBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_fragment_main, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppFragmentMainBinding bind(View rootView) {
        VerifyAnimationAvatarFrameLayout avatar;
        ConstraintLayout avatarLayout;
        BiliImageView avatarRect;
        BiliImageView avatarRectBg;
        TabHost bottomNavigation;
        TintImageView ivTeenUmbrella;
        Toolbar navTopBar;
        TintImageView searchIcon;
        SwitchTextView searchText;
        HomePagerSlidingTabStrip toolbarTabs;
        int id = R.id.app_bar;
        HomeAppBarLayout appBar = (HomeAppBarLayout) ViewBindings.findChildViewById(rootView, id);
        if (appBar != null && (avatar = ViewBindings.findChildViewById(rootView, (id = R.id.avatar))) != null && (avatarLayout = ViewBindings.findChildViewById(rootView, (id = R.id.avatar_layout))) != null && (avatarRect = ViewBindings.findChildViewById(rootView, (id = R.id.avatar_rect))) != null && (avatarRectBg = ViewBindings.findChildViewById(rootView, (id = R.id.avatar_rect_bg))) != null) {
            id = R.id.avatar_rect_layout;
            FrameLayout avatarRectLayout = (FrameLayout) ViewBindings.findChildViewById(rootView, id);
            if (avatarRectLayout != null && (bottomNavigation = ViewBindings.findChildViewById(rootView, (id = R.id.bottom_navigation))) != null) {
                id = R.id.content;
                FrameLayout content = (FrameLayout) ViewBindings.findChildViewById(rootView, id);
                if (content != null) {
                    CoordinatorLayout coordinatorLayout = (CoordinatorLayout) rootView;
                    id = R.id.expand_search;
                    TintLinearLayout expandSearch = ViewBindings.findChildViewById(rootView, id);
                    if (expandSearch != null && (ivTeenUmbrella = ViewBindings.findChildViewById(rootView, (id = R.id.iv_teen_umbrella))) != null) {
                        id = R.id.main_top_bg;
                        ImageView mainTopBg = (ImageView) ViewBindings.findChildViewById(rootView, id);
                        if (mainTopBg != null) {
                            id = R.id.main_top_layout;
                            FrameLayout mainTopLayout = (FrameLayout) ViewBindings.findChildViewById(rootView, id);
                            if (mainTopLayout != null && (navTopBar = ViewBindings.findChildViewById(rootView, (id = R.id.nav_top_bar))) != null) {
                                id = R.id.navigation;
                                LinearLayout navigation = (LinearLayout) ViewBindings.findChildViewById(rootView, id);
                                if (navigation != null) {
                                    id = R.id.nick_name;
                                    ToolbarCenterTextView nickName = (ToolbarCenterTextView) ViewBindings.findChildViewById(rootView, id);
                                    if (nickName != null && (searchIcon = ViewBindings.findChildViewById(rootView, (id = R.id.search_icon))) != null && (searchText = ViewBindings.findChildViewById(rootView, (id = R.id.search_text))) != null && (toolbarTabs = ViewBindings.findChildViewById(rootView, (id = R.id.toolbar_tabs))) != null) {
                                        return new BiliAppFragmentMainBinding((CoordinatorLayout) rootView, appBar, avatar, avatarLayout, avatarRect, avatarRectBg, avatarRectLayout, bottomNavigation, content, coordinatorLayout, expandSearch, ivTeenUmbrella, mainTopBg, mainTopLayout, navTopBar, navigation, nickName, searchIcon, searchText, toolbarTabs);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}