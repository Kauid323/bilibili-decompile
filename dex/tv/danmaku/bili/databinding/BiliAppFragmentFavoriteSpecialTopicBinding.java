package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import tv.danmaku.bili.R;
import tv.danmaku.bili.ui.favorite.TabMarginSlidingTabStrip;
import tv.danmaku.bili.widget.DisableScrollViewpager;

public final class BiliAppFragmentFavoriteSpecialTopicBinding implements ViewBinding {
    public final DisableScrollViewpager pager;
    private final LinearLayout rootView;
    public final TabMarginSlidingTabStrip tabs;

    private BiliAppFragmentFavoriteSpecialTopicBinding(LinearLayout rootView, DisableScrollViewpager pager, TabMarginSlidingTabStrip tabs) {
        this.rootView = rootView;
        this.pager = pager;
        this.tabs = tabs;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppFragmentFavoriteSpecialTopicBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppFragmentFavoriteSpecialTopicBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_fragment_favorite_special_topic, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppFragmentFavoriteSpecialTopicBinding bind(View rootView) {
        int id = R.id.pager;
        DisableScrollViewpager pager = ViewBindings.findChildViewById(rootView, id);
        if (pager != null) {
            id = R.id.tabs;
            TabMarginSlidingTabStrip tabs = (TabMarginSlidingTabStrip) ViewBindings.findChildViewById(rootView, id);
            if (tabs != null) {
                return new BiliAppFragmentFavoriteSpecialTopicBinding((LinearLayout) rootView, pager, tabs);
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}