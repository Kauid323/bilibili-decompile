package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import tv.danmaku.bili.R;

public final class BiliAppFragmentWatchLaterMenuBinding implements ViewBinding {
    public final LinearLayout bottomBar;
    public final FrameLayout contentLayout;
    public final LinearLayout menuDelete;
    public final CoordinatorLayout rootLayout;
    private final CoordinatorLayout rootView;
    public final View shadow;

    private BiliAppFragmentWatchLaterMenuBinding(CoordinatorLayout rootView, LinearLayout bottomBar, FrameLayout contentLayout, LinearLayout menuDelete, CoordinatorLayout rootLayout, View shadow) {
        this.rootView = rootView;
        this.bottomBar = bottomBar;
        this.contentLayout = contentLayout;
        this.menuDelete = menuDelete;
        this.rootLayout = rootLayout;
        this.shadow = shadow;
    }

    public CoordinatorLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppFragmentWatchLaterMenuBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppFragmentWatchLaterMenuBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_fragment_watch_later_menu, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppFragmentWatchLaterMenuBinding bind(View rootView) {
        int id = R.id.bottom_bar;
        LinearLayout bottomBar = (LinearLayout) ViewBindings.findChildViewById(rootView, id);
        if (bottomBar != null) {
            id = R.id.content_layout;
            FrameLayout contentLayout = (FrameLayout) ViewBindings.findChildViewById(rootView, id);
            if (contentLayout != null) {
                id = R.id.menu_delete;
                LinearLayout menuDelete = (LinearLayout) ViewBindings.findChildViewById(rootView, id);
                if (menuDelete != null) {
                    CoordinatorLayout rootLayout = (CoordinatorLayout) rootView;
                    id = R.id.shadow;
                    View shadow = ViewBindings.findChildViewById(rootView, id);
                    if (shadow != null) {
                        return new BiliAppFragmentWatchLaterMenuBinding((CoordinatorLayout) rootView, bottomBar, contentLayout, menuDelete, rootLayout, shadow);
                    }
                }
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}