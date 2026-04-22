package tv.danmaku.bili.ui.rank.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import com.bilibili.lib.image2.view.legacy.StaticImageView2;
import tv.danmaku.bili.ui.rank.R;

public final class BillAppLayoutListItemRankAvatarBinding implements ViewBinding {
    private final StaticImageView2 rootView;

    private BillAppLayoutListItemRankAvatarBinding(StaticImageView2 rootView) {
        this.rootView = rootView;
    }

    public StaticImageView2 getRoot() {
        return this.rootView;
    }

    public static BillAppLayoutListItemRankAvatarBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BillAppLayoutListItemRankAvatarBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bill_app_layout_list_item_rank_avatar, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BillAppLayoutListItemRankAvatarBinding bind(View rootView) {
        if (rootView == null) {
            throw new NullPointerException("rootView");
        }
        return new BillAppLayoutListItemRankAvatarBinding((StaticImageView2) rootView);
    }
}