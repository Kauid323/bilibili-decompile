package tv.danmaku.bili.ui.rank.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import tv.danmaku.bili.ui.rank.R;

public final class BiliAppLayoutListItemRankUgcBinding implements ViewBinding {
    private final LinearLayout rootView;

    private BiliAppLayoutListItemRankUgcBinding(LinearLayout rootView) {
        this.rootView = rootView;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppLayoutListItemRankUgcBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppLayoutListItemRankUgcBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_layout_list_item_rank_ugc, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppLayoutListItemRankUgcBinding bind(View rootView) {
        if (rootView == null) {
            throw new NullPointerException("rootView");
        }
        return new BiliAppLayoutListItemRankUgcBinding((LinearLayout) rootView);
    }
}