package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bilibili.magicasakura.widgets.GarbTintToolBar;
import com.bilibili.magicasakura.widgets.TintCheckBox;
import com.google.android.material.appbar.AppBarLayout;
import tv.danmaku.bili.R;
import tv.danmaku.bili.widget.LoadingImageView;
import tv.danmaku.bili.widget.swiperefresh.TintSwipeRefreshLayout;

public final class BiliAppFragmentMainSwiperefreshRecyclerBinding implements ViewBinding {
    public final AppBarLayout appBar;
    public final RelativeLayout bottomDeleteLayout;
    public final TintCheckBox checkbox;
    public final LoadingImageView loading;
    public final GarbTintToolBar navTopBar;
    public final RelativeLayout rootContainer;
    private final RelativeLayout rootView;
    public final TintSwipeRefreshLayout swipeLayout;
    public final TextView tvDelete;
    public final TextView tvSelectAll;

    private BiliAppFragmentMainSwiperefreshRecyclerBinding(RelativeLayout rootView, AppBarLayout appBar, RelativeLayout bottomDeleteLayout, TintCheckBox checkbox, LoadingImageView loading, GarbTintToolBar navTopBar, RelativeLayout rootContainer, TintSwipeRefreshLayout swipeLayout, TextView tvDelete, TextView tvSelectAll) {
        this.rootView = rootView;
        this.appBar = appBar;
        this.bottomDeleteLayout = bottomDeleteLayout;
        this.checkbox = checkbox;
        this.loading = loading;
        this.navTopBar = navTopBar;
        this.rootContainer = rootContainer;
        this.swipeLayout = swipeLayout;
        this.tvDelete = tvDelete;
        this.tvSelectAll = tvSelectAll;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppFragmentMainSwiperefreshRecyclerBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppFragmentMainSwiperefreshRecyclerBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_fragment_main_swiperefresh_recycler, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppFragmentMainSwiperefreshRecyclerBinding bind(View rootView) {
        TintCheckBox checkbox;
        LoadingImageView loading;
        GarbTintToolBar navTopBar;
        int id = R.id.app_bar;
        AppBarLayout appBar = ViewBindings.findChildViewById(rootView, id);
        if (appBar != null) {
            id = R.id.bottom_delete_layout;
            RelativeLayout bottomDeleteLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, id);
            if (bottomDeleteLayout != null && (checkbox = ViewBindings.findChildViewById(rootView, (id = R.id.checkbox))) != null && (loading = ViewBindings.findChildViewById(rootView, (id = R.id.loading))) != null && (navTopBar = ViewBindings.findChildViewById(rootView, (id = R.id.nav_top_bar))) != null) {
                RelativeLayout rootContainer = (RelativeLayout) rootView;
                id = R.id.swipe_layout;
                TintSwipeRefreshLayout swipeLayout = ViewBindings.findChildViewById(rootView, id);
                if (swipeLayout != null) {
                    id = R.id.tv_delete;
                    TextView tvDelete = (TextView) ViewBindings.findChildViewById(rootView, id);
                    if (tvDelete != null) {
                        id = R.id.tv_select_all;
                        TextView tvSelectAll = (TextView) ViewBindings.findChildViewById(rootView, id);
                        if (tvSelectAll != null) {
                            return new BiliAppFragmentMainSwiperefreshRecyclerBinding((RelativeLayout) rootView, appBar, bottomDeleteLayout, checkbox, loading, navTopBar, rootContainer, swipeLayout, tvDelete, tvSelectAll);
                        }
                    }
                }
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}