package tv.danmaku.bili.ui.rank.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bilibili.magicasakura.widgets.TintImageView;
import tv.danmaku.bili.ui.rank.R;
import tv.danmaku.bili.widget.FixedPopupAnchor;

public final class BiliAppLayoutListItemRankMoreItemBinding implements ViewBinding {
    public final View gap;
    public final TintImageView ivAnchor;
    public final FixedPopupAnchor moreSub;
    private final ConstraintLayout rootView;
    public final TextView tvTitle;

    private BiliAppLayoutListItemRankMoreItemBinding(ConstraintLayout rootView, View gap, TintImageView ivAnchor, FixedPopupAnchor moreSub, TextView tvTitle) {
        this.rootView = rootView;
        this.gap = gap;
        this.ivAnchor = ivAnchor;
        this.moreSub = moreSub;
        this.tvTitle = tvTitle;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppLayoutListItemRankMoreItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppLayoutListItemRankMoreItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_layout_list_item_rank_more_item, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppLayoutListItemRankMoreItemBinding bind(View rootView) {
        TintImageView ivAnchor;
        int id = R.id.gap;
        View gap = ViewBindings.findChildViewById(rootView, id);
        if (gap != null && (ivAnchor = ViewBindings.findChildViewById(rootView, (id = R.id.iv_anchor))) != null) {
            id = R.id.more_sub;
            FixedPopupAnchor moreSub = (FixedPopupAnchor) ViewBindings.findChildViewById(rootView, id);
            if (moreSub != null) {
                id = R.id.tv_title;
                TextView tvTitle = (TextView) ViewBindings.findChildViewById(rootView, id);
                if (tvTitle != null) {
                    return new BiliAppLayoutListItemRankMoreItemBinding((ConstraintLayout) rootView, gap, ivAnchor, moreSub, tvTitle);
                }
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}