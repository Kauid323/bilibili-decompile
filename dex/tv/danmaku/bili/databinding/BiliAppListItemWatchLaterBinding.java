package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bilibili.app.comm.list.common.widget.RoundCircleFrameLayout;
import com.bilibili.app.comm.list.widget.image.ListPlaceHolderImageView;
import com.bilibili.magicasakura.widgets.TintCheckBox;
import com.bilibili.magicasakura.widgets.TintProgressBar;
import com.bilibili.magicasakura.widgets.TintRelativeLayout;
import com.bilibili.magicasakura.widgets.TintTextView;
import tv.danmaku.bili.R;
import tv.danmaku.bili.widget.FixedPopupAnchor;
import tv.danmaku.bili.widget.ForegroundConstraintLayout;
import tv.danmaku.bili.widget.VectorTextView;
import tv.danmaku.bili.widget.text.TintFixedLineSpacingTextView;

public final class BiliAppListItemWatchLaterBinding implements ViewBinding {
    public final VectorTextView author;
    public final TintCheckBox checkVideo;
    public final ListPlaceHolderImageView cover;
    public final RoundCircleFrameLayout idCoverProgress;
    public final FixedPopupAnchor more;
    public final TintTextView pageNum;
    public final TintProgressBar progress;
    public final TintRelativeLayout rlInvalid;
    private final ForegroundConstraintLayout rootView;
    public final TextView time;
    public final TintFixedLineSpacingTextView title;
    public final TintTextView tvCommentCounts;
    public final VectorTextView tvPlayCounts;

    private BiliAppListItemWatchLaterBinding(ForegroundConstraintLayout rootView, VectorTextView author, TintCheckBox checkVideo, ListPlaceHolderImageView cover, RoundCircleFrameLayout idCoverProgress, FixedPopupAnchor more, TintTextView pageNum, TintProgressBar progress, TintRelativeLayout rlInvalid, TextView time, TintFixedLineSpacingTextView title, TintTextView tvCommentCounts, VectorTextView tvPlayCounts) {
        this.rootView = rootView;
        this.author = author;
        this.checkVideo = checkVideo;
        this.cover = cover;
        this.idCoverProgress = idCoverProgress;
        this.more = more;
        this.pageNum = pageNum;
        this.progress = progress;
        this.rlInvalid = rlInvalid;
        this.time = time;
        this.title = title;
        this.tvCommentCounts = tvCommentCounts;
        this.tvPlayCounts = tvPlayCounts;
    }

    public ForegroundConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppListItemWatchLaterBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppListItemWatchLaterBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_list_item_watch_later, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppListItemWatchLaterBinding bind(View rootView) {
        TintCheckBox checkVideo;
        ListPlaceHolderImageView cover;
        RoundCircleFrameLayout idCoverProgress;
        FixedPopupAnchor more;
        TintTextView pageNum;
        TintProgressBar progress;
        TintRelativeLayout rlInvalid;
        TintFixedLineSpacingTextView title;
        TintTextView tvCommentCounts;
        VectorTextView tvPlayCounts;
        int id = R.id.author;
        VectorTextView author = ViewBindings.findChildViewById(rootView, id);
        if (author != null && (checkVideo = ViewBindings.findChildViewById(rootView, (id = R.id.check_video))) != null && (cover = ViewBindings.findChildViewById(rootView, (id = R.id.cover))) != null && (idCoverProgress = ViewBindings.findChildViewById(rootView, (id = R.id.id_cover_progress))) != null && (more = ViewBindings.findChildViewById(rootView, (id = R.id.more))) != null && (pageNum = ViewBindings.findChildViewById(rootView, (id = R.id.page_num))) != null && (progress = ViewBindings.findChildViewById(rootView, (id = R.id.progress))) != null && (rlInvalid = ViewBindings.findChildViewById(rootView, (id = R.id.rl_invalid))) != null) {
            id = R.id.time;
            TextView time = (TextView) ViewBindings.findChildViewById(rootView, id);
            if (time != null && (title = ViewBindings.findChildViewById(rootView, (id = R.id.title))) != null && (tvCommentCounts = ViewBindings.findChildViewById(rootView, (id = R.id.tv_comment_counts))) != null && (tvPlayCounts = ViewBindings.findChildViewById(rootView, (id = R.id.tv_play_counts))) != null) {
                return new BiliAppListItemWatchLaterBinding((ForegroundConstraintLayout) rootView, author, checkVideo, cover, idCoverProgress, more, pageNum, progress, rlInvalid, time, title, tvCommentCounts, tvPlayCounts);
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}