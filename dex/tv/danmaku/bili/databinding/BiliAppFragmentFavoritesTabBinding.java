package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.compose.ui.platform.ComposeView;
import androidx.legacy.widget.Space;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bilibili.magicasakura.widgets.TintCheckBox;
import com.bilibili.magicasakura.widgets.TintConstraintLayout;
import com.bilibili.magicasakura.widgets.TintTextView;
import com.bilibili.magicasakura.widgets.TintToolbar;
import com.bilibili.magicasakura.widgets.TintView;
import tv.danmaku.bili.R;
import tv.danmaku.bili.ui.favorites.widget.InterceptRecyclerView;
import tv.danmaku.bili.widget.swiperefresh.SwipeRefreshLayout;

public final class BiliAppFragmentFavoritesTabBinding implements ViewBinding {
    public final TintConstraintLayout batchManageContainer;
    public final LinearLayout checkAllLayout;
    public final TintCheckBox checkBox;
    public final TintTextView copy;
    public final TintTextView delete;
    public final ComposeView errorView;
    public final TintConstraintLayout layoutContainer;
    public final TintTextView manageDone;
    public final TintTextView manageTitle;
    public final TintTextView move;
    public final InterceptRecyclerView recyclerView;
    private final TintConstraintLayout rootView;
    public final TintTextView selectAll;
    public final TintView shadow;
    public final Space space;
    public final SwipeRefreshLayout swipeLayout;
    public final TintToolbar tabToolBarManage;

    private BiliAppFragmentFavoritesTabBinding(TintConstraintLayout rootView, TintConstraintLayout batchManageContainer, LinearLayout checkAllLayout, TintCheckBox checkBox, TintTextView copy, TintTextView delete, ComposeView errorView, TintConstraintLayout layoutContainer, TintTextView manageDone, TintTextView manageTitle, TintTextView move, InterceptRecyclerView recyclerView, TintTextView selectAll, TintView shadow, Space space, SwipeRefreshLayout swipeLayout, TintToolbar tabToolBarManage) {
        this.rootView = rootView;
        this.batchManageContainer = batchManageContainer;
        this.checkAllLayout = checkAllLayout;
        this.checkBox = checkBox;
        this.copy = copy;
        this.delete = delete;
        this.errorView = errorView;
        this.layoutContainer = layoutContainer;
        this.manageDone = manageDone;
        this.manageTitle = manageTitle;
        this.move = move;
        this.recyclerView = recyclerView;
        this.selectAll = selectAll;
        this.shadow = shadow;
        this.space = space;
        this.swipeLayout = swipeLayout;
        this.tabToolBarManage = tabToolBarManage;
    }

    public TintConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppFragmentFavoritesTabBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppFragmentFavoritesTabBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_fragment_favorites_tab, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppFragmentFavoritesTabBinding bind(View rootView) {
        TintCheckBox checkBox;
        TintTextView copy;
        TintTextView delete;
        ComposeView errorView;
        TintTextView manageTitle;
        TintTextView move;
        TintTextView selectAll;
        TintView shadow;
        Space space;
        SwipeRefreshLayout swipeLayout;
        TintToolbar tabToolBarManage;
        int id = R.id.batch_manage_container;
        TintConstraintLayout batchManageContainer = ViewBindings.findChildViewById(rootView, id);
        if (batchManageContainer != null) {
            id = R.id.check_all_layout;
            LinearLayout checkAllLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, id);
            if (checkAllLayout != null && (checkBox = ViewBindings.findChildViewById(rootView, (id = R.id.check_box))) != null && (copy = ViewBindings.findChildViewById(rootView, (id = R.id.copy))) != null && (delete = ViewBindings.findChildViewById(rootView, (id = R.id.delete))) != null && (errorView = ViewBindings.findChildViewById(rootView, (id = R.id.error_view))) != null) {
                TintConstraintLayout layoutContainer = (TintConstraintLayout) rootView;
                id = R.id.manage_done;
                TintTextView manageDone = ViewBindings.findChildViewById(rootView, id);
                if (manageDone != null && (manageTitle = ViewBindings.findChildViewById(rootView, (id = R.id.manage_title))) != null && (move = ViewBindings.findChildViewById(rootView, (id = R.id.move))) != null) {
                    id = R.id.recycler_view;
                    InterceptRecyclerView recyclerView = (InterceptRecyclerView) ViewBindings.findChildViewById(rootView, id);
                    if (recyclerView != null && (selectAll = ViewBindings.findChildViewById(rootView, (id = R.id.select_all))) != null && (shadow = ViewBindings.findChildViewById(rootView, (id = R.id.shadow))) != null && (space = ViewBindings.findChildViewById(rootView, (id = R.id.space))) != null && (swipeLayout = ViewBindings.findChildViewById(rootView, (id = R.id.swipe_layout))) != null && (tabToolBarManage = ViewBindings.findChildViewById(rootView, (id = R.id.tab_tool_bar_manage))) != null) {
                        return new BiliAppFragmentFavoritesTabBinding((TintConstraintLayout) rootView, batchManageContainer, checkAllLayout, checkBox, copy, delete, errorView, layoutContainer, manageDone, manageTitle, move, recyclerView, selectAll, shadow, space, swipeLayout, tabToolBarManage);
                    }
                }
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}