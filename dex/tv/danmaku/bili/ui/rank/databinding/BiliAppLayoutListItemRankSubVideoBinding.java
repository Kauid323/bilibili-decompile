package tv.danmaku.bili.ui.rank.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bilibili.lib.image2.view.legacy.ScalableImageView2;
import tv.danmaku.bili.ui.rank.R;
import tv.danmaku.bili.widget.FixedPopupAnchor;
import tv.danmaku.bili.widget.ForegroundRelativeLayout;
import tv.danmaku.bili.widget.VectorTextView;

public final class BiliAppLayoutListItemRankSubVideoBinding implements ViewBinding {
    public final FixedPopupAnchor anchorMore;
    public final ScalableImageView2 cover;
    public final VectorTextView rankDanmakuNum;
    public final LinearLayout rankInfoContainer;
    public final VectorTextView rankPlayNum;
    private final ForegroundRelativeLayout rootView;
    public final TextView title;
    public final TextView tvDuration;
    public final TextView tvRankNum;
    public final VectorTextView upName;
    public final ForegroundRelativeLayout videoLayout;

    private BiliAppLayoutListItemRankSubVideoBinding(ForegroundRelativeLayout rootView, FixedPopupAnchor anchorMore, ScalableImageView2 cover, VectorTextView rankDanmakuNum, LinearLayout rankInfoContainer, VectorTextView rankPlayNum, TextView title, TextView tvDuration, TextView tvRankNum, VectorTextView upName, ForegroundRelativeLayout videoLayout) {
        this.rootView = rootView;
        this.anchorMore = anchorMore;
        this.cover = cover;
        this.rankDanmakuNum = rankDanmakuNum;
        this.rankInfoContainer = rankInfoContainer;
        this.rankPlayNum = rankPlayNum;
        this.title = title;
        this.tvDuration = tvDuration;
        this.tvRankNum = tvRankNum;
        this.upName = upName;
        this.videoLayout = videoLayout;
    }

    public ForegroundRelativeLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppLayoutListItemRankSubVideoBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppLayoutListItemRankSubVideoBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_layout_list_item_rank_sub_video, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppLayoutListItemRankSubVideoBinding bind(View rootView) {
        ScalableImageView2 cover;
        int id = R.id.anchor_more;
        FixedPopupAnchor anchorMore = (FixedPopupAnchor) ViewBindings.findChildViewById(rootView, id);
        if (anchorMore != null && (cover = ViewBindings.findChildViewById(rootView, (id = R.id.cover))) != null) {
            id = R.id.rank_danmaku_num;
            VectorTextView rankDanmakuNum = (VectorTextView) ViewBindings.findChildViewById(rootView, id);
            if (rankDanmakuNum != null) {
                id = R.id.rank_info_container;
                LinearLayout rankInfoContainer = (LinearLayout) ViewBindings.findChildViewById(rootView, id);
                if (rankInfoContainer != null) {
                    id = R.id.rank_play_num;
                    VectorTextView rankPlayNum = (VectorTextView) ViewBindings.findChildViewById(rootView, id);
                    if (rankPlayNum != null) {
                        id = R.id.title;
                        TextView title = (TextView) ViewBindings.findChildViewById(rootView, id);
                        if (title != null) {
                            id = R.id.tv_duration;
                            TextView tvDuration = (TextView) ViewBindings.findChildViewById(rootView, id);
                            if (tvDuration != null) {
                                id = R.id.tv_rank_num;
                                TextView tvRankNum = (TextView) ViewBindings.findChildViewById(rootView, id);
                                if (tvRankNum != null) {
                                    id = R.id.up_name;
                                    VectorTextView upName = (VectorTextView) ViewBindings.findChildViewById(rootView, id);
                                    if (upName != null) {
                                        ForegroundRelativeLayout videoLayout = (ForegroundRelativeLayout) rootView;
                                        return new BiliAppLayoutListItemRankSubVideoBinding((ForegroundRelativeLayout) rootView, anchorMore, cover, rankDanmakuNum, rankInfoContainer, rankPlayNum, title, tvDuration, tvRankNum, upName, videoLayout);
                                    }
                                }
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