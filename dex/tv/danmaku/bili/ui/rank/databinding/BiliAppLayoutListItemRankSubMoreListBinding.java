package tv.danmaku.bili.ui.rank.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import tv.danmaku.bili.ui.rank.R;

public final class BiliAppLayoutListItemRankSubMoreListBinding implements ViewBinding {
    private final View rootView;
    public final LinearLayout upMoreContentLayout;

    private BiliAppLayoutListItemRankSubMoreListBinding(View rootView, LinearLayout upMoreContentLayout) {
        this.rootView = rootView;
        this.upMoreContentLayout = upMoreContentLayout;
    }

    public View getRoot() {
        return this.rootView;
    }

    public static BiliAppLayoutListItemRankSubMoreListBinding inflate(LayoutInflater inflater, ViewGroup parent) {
        if (parent == null) {
            throw new NullPointerException("parent");
        }
        inflater.inflate(R.layout.bili_app_layout_list_item_rank_sub_more_list, parent);
        return bind(parent);
    }

    public static BiliAppLayoutListItemRankSubMoreListBinding bind(View rootView) {
        int id = R.id.up_more_content_layout;
        LinearLayout upMoreContentLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, id);
        if (upMoreContentLayout != null) {
            return new BiliAppLayoutListItemRankSubMoreListBinding(rootView, upMoreContentLayout);
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}