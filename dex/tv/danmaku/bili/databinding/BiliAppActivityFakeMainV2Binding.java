package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bilibili.magicasakura.widgets.TintFrameLayout;
import com.bilibili.magicasakura.widgets.TintTextView;
import com.bilibili.magicasakura.widgets.TintView;
import com.google.android.material.appbar.AppBarLayout;
import tv.danmaku.bili.R;
import tv.danmaku.bili.widget.VerifyAnimationAvatarFrameLayout;

public final class BiliAppActivityFakeMainV2Binding implements ViewBinding {
    public final AppBarLayout appBar;
    public final VerifyAnimationAvatarFrameLayout avatar;
    public final ConstraintLayout content;
    public final TintView divider;
    public final TintTextView expandSearch;
    public final ImageView ivGameCenter;
    public final ImageView ivMessage;
    public final ImageView mainTopBg;
    public final FrameLayout mainTopLayout;
    public final Toolbar navTopBar;
    public final ConstraintLayout navigation;
    public final FrameLayout pegasusContent;
    public final RecyclerView recyclerView;
    private final CoordinatorLayout rootView;
    public final TintFrameLayout tabsLayout;

    private BiliAppActivityFakeMainV2Binding(CoordinatorLayout rootView, AppBarLayout appBar, VerifyAnimationAvatarFrameLayout avatar, ConstraintLayout content, TintView divider, TintTextView expandSearch, ImageView ivGameCenter, ImageView ivMessage, ImageView mainTopBg, FrameLayout mainTopLayout, Toolbar navTopBar, ConstraintLayout navigation, FrameLayout pegasusContent, RecyclerView recyclerView, TintFrameLayout tabsLayout) {
        this.rootView = rootView;
        this.appBar = appBar;
        this.avatar = avatar;
        this.content = content;
        this.divider = divider;
        this.expandSearch = expandSearch;
        this.ivGameCenter = ivGameCenter;
        this.ivMessage = ivMessage;
        this.mainTopBg = mainTopBg;
        this.mainTopLayout = mainTopLayout;
        this.navTopBar = navTopBar;
        this.navigation = navigation;
        this.pegasusContent = pegasusContent;
        this.recyclerView = recyclerView;
        this.tabsLayout = tabsLayout;
    }

    public CoordinatorLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppActivityFakeMainV2Binding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppActivityFakeMainV2Binding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_activity_fake_main_v2, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppActivityFakeMainV2Binding bind(View rootView) {
        VerifyAnimationAvatarFrameLayout avatar;
        ConstraintLayout content;
        TintView divider;
        TintTextView expandSearch;
        Toolbar navTopBar;
        ConstraintLayout navigation;
        RecyclerView recyclerView;
        TintFrameLayout tabsLayout;
        int id = R.id.app_bar;
        AppBarLayout appBar = ViewBindings.findChildViewById(rootView, id);
        if (appBar != null && (avatar = ViewBindings.findChildViewById(rootView, (id = R.id.avatar))) != null && (content = ViewBindings.findChildViewById(rootView, (id = R.id.content))) != null && (divider = ViewBindings.findChildViewById(rootView, (id = R.id.divider))) != null && (expandSearch = ViewBindings.findChildViewById(rootView, (id = R.id.expand_search))) != null) {
            id = R.id.iv_game_center;
            ImageView ivGameCenter = (ImageView) ViewBindings.findChildViewById(rootView, id);
            if (ivGameCenter != null) {
                id = R.id.iv_message;
                ImageView ivMessage = (ImageView) ViewBindings.findChildViewById(rootView, id);
                if (ivMessage != null) {
                    id = R.id.main_top_bg;
                    ImageView mainTopBg = (ImageView) ViewBindings.findChildViewById(rootView, id);
                    if (mainTopBg != null) {
                        id = R.id.main_top_layout;
                        FrameLayout mainTopLayout = (FrameLayout) ViewBindings.findChildViewById(rootView, id);
                        if (mainTopLayout != null && (navTopBar = ViewBindings.findChildViewById(rootView, (id = R.id.nav_top_bar))) != null && (navigation = ViewBindings.findChildViewById(rootView, (id = R.id.navigation))) != null) {
                            id = R.id.pegasus_content;
                            FrameLayout pegasusContent = (FrameLayout) ViewBindings.findChildViewById(rootView, id);
                            if (pegasusContent != null && (recyclerView = ViewBindings.findChildViewById(rootView, (id = R.id.recycler_view))) != null && (tabsLayout = ViewBindings.findChildViewById(rootView, (id = R.id.tabs_layout))) != null) {
                                return new BiliAppActivityFakeMainV2Binding((CoordinatorLayout) rootView, appBar, avatar, content, divider, expandSearch, ivGameCenter, ivMessage, mainTopBg, mainTopLayout, navTopBar, navigation, pegasusContent, recyclerView, tabsLayout);
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