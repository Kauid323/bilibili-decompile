package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bilibili.lib.homepage.widget.badge.MoleBadgeView;
import com.bilibili.lib.image2.view.BiliImageView;
import com.bilibili.magicasakura.widgets.TintConstraintLayout;
import com.bilibili.magicasakura.widgets.TintTextView;
import tv.danmaku.bili.R;
import tv.danmaku.bili.widget.RoundRectFrameLayout;

public final class BiliLayoutMineBarrenCreationBinding implements ViewBinding {
    public final MoleBadgeView badge;
    public final BiliImageView bivLeft;
    public final BiliImageView bivRight;
    public final RoundRectFrameLayout coverLeft;
    public final RoundRectFrameLayout coverRight;
    public final BiliLayoutMineBarrenCreationOnLoadingBinding layoutLoading;
    public final BiliImageView publishIcon;
    public final TintConstraintLayout publishLayout;
    public final TintTextView publishText;
    private final ConstraintLayout rootView;
    public final View shadowLeft;
    public final View shadowRight;
    public final TintTextView tvGetMore;
    public final TextView tvLeftCoverTitle;
    public final TextView tvLeftCoverUsingNumber;
    public final TextView tvRightCoverTitle;
    public final TextView tvRightCoverUsingNumber;
    public final TintTextView tvSubTitle;
    public final TintTextView tvTitle;

    private BiliLayoutMineBarrenCreationBinding(ConstraintLayout rootView, MoleBadgeView badge, BiliImageView bivLeft, BiliImageView bivRight, RoundRectFrameLayout coverLeft, RoundRectFrameLayout coverRight, BiliLayoutMineBarrenCreationOnLoadingBinding layoutLoading, BiliImageView publishIcon, TintConstraintLayout publishLayout, TintTextView publishText, View shadowLeft, View shadowRight, TintTextView tvGetMore, TextView tvLeftCoverTitle, TextView tvLeftCoverUsingNumber, TextView tvRightCoverTitle, TextView tvRightCoverUsingNumber, TintTextView tvSubTitle, TintTextView tvTitle) {
        this.rootView = rootView;
        this.badge = badge;
        this.bivLeft = bivLeft;
        this.bivRight = bivRight;
        this.coverLeft = coverLeft;
        this.coverRight = coverRight;
        this.layoutLoading = layoutLoading;
        this.publishIcon = publishIcon;
        this.publishLayout = publishLayout;
        this.publishText = publishText;
        this.shadowLeft = shadowLeft;
        this.shadowRight = shadowRight;
        this.tvGetMore = tvGetMore;
        this.tvLeftCoverTitle = tvLeftCoverTitle;
        this.tvLeftCoverUsingNumber = tvLeftCoverUsingNumber;
        this.tvRightCoverTitle = tvRightCoverTitle;
        this.tvRightCoverUsingNumber = tvRightCoverUsingNumber;
        this.tvSubTitle = tvSubTitle;
        this.tvTitle = tvTitle;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BiliLayoutMineBarrenCreationBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliLayoutMineBarrenCreationBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_layout_mine_barren_creation, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliLayoutMineBarrenCreationBinding bind(View rootView) {
        BiliImageView bivLeft;
        BiliImageView bivRight;
        RoundRectFrameLayout coverLeft;
        RoundRectFrameLayout coverRight;
        View layoutLoading;
        TintConstraintLayout publishLayout;
        TintTextView publishText;
        View shadowLeft;
        View shadowRight;
        TintTextView tvGetMore;
        TintTextView tvSubTitle;
        TintTextView tvTitle;
        int id = R.id.badge;
        MoleBadgeView badge = ViewBindings.findChildViewById(rootView, id);
        if (badge != null && (bivLeft = ViewBindings.findChildViewById(rootView, (id = R.id.biv_left))) != null && (bivRight = ViewBindings.findChildViewById(rootView, (id = R.id.biv_right))) != null && (coverLeft = ViewBindings.findChildViewById(rootView, (id = R.id.cover_left))) != null && (coverRight = ViewBindings.findChildViewById(rootView, (id = R.id.cover_right))) != null && (layoutLoading = ViewBindings.findChildViewById(rootView, (id = R.id.layout_loading))) != null) {
            BiliLayoutMineBarrenCreationOnLoadingBinding binding_layoutLoading = BiliLayoutMineBarrenCreationOnLoadingBinding.bind(layoutLoading);
            id = R.id.publish_icon;
            BiliImageView publishIcon = ViewBindings.findChildViewById(rootView, id);
            if (publishIcon != null && (publishLayout = ViewBindings.findChildViewById(rootView, (id = R.id.publish_layout))) != null && (publishText = ViewBindings.findChildViewById(rootView, (id = R.id.publish_text))) != null && (shadowLeft = ViewBindings.findChildViewById(rootView, (id = R.id.shadow_left))) != null && (shadowRight = ViewBindings.findChildViewById(rootView, (id = R.id.shadow_right))) != null && (tvGetMore = ViewBindings.findChildViewById(rootView, (id = R.id.tv_get_more))) != null) {
                id = R.id.tv_left_cover_title;
                TextView tvLeftCoverTitle = (TextView) ViewBindings.findChildViewById(rootView, id);
                if (tvLeftCoverTitle != null) {
                    id = R.id.tv_left_cover_using_number;
                    TextView tvLeftCoverUsingNumber = (TextView) ViewBindings.findChildViewById(rootView, id);
                    if (tvLeftCoverUsingNumber != null) {
                        id = R.id.tv_right_cover_title;
                        TextView tvRightCoverTitle = (TextView) ViewBindings.findChildViewById(rootView, id);
                        if (tvRightCoverTitle != null) {
                            id = R.id.tv_right_cover_using_number;
                            TextView tvRightCoverUsingNumber = (TextView) ViewBindings.findChildViewById(rootView, id);
                            if (tvRightCoverUsingNumber != null && (tvSubTitle = ViewBindings.findChildViewById(rootView, (id = R.id.tv_sub_title))) != null && (tvTitle = ViewBindings.findChildViewById(rootView, (id = R.id.tv_title))) != null) {
                                return new BiliLayoutMineBarrenCreationBinding((ConstraintLayout) rootView, badge, bivLeft, bivRight, coverLeft, coverRight, binding_layoutLoading, publishIcon, publishLayout, publishText, shadowLeft, shadowRight, tvGetMore, tvLeftCoverTitle, tvLeftCoverUsingNumber, tvRightCoverTitle, tvRightCoverUsingNumber, tvSubTitle, tvTitle);
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