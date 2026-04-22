package tv.danmaku.bili.ui.rank.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import tv.danmaku.bili.ui.rank.R;

public final class BiliAppLayoutListItemRankTipTitleBinding implements ViewBinding {
    private final TextView rootView;

    private BiliAppLayoutListItemRankTipTitleBinding(TextView rootView) {
        this.rootView = rootView;
    }

    public TextView getRoot() {
        return this.rootView;
    }

    public static BiliAppLayoutListItemRankTipTitleBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppLayoutListItemRankTipTitleBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_layout_list_item_rank_tip_title, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppLayoutListItemRankTipTitleBinding bind(View rootView) {
        if (rootView == null) {
            throw new NullPointerException("rootView");
        }
        return new BiliAppLayoutListItemRankTipTitleBinding((TextView) rootView);
    }
}