package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bilibili.app.comm.list.common.widget.RoundCircleFrameLayout;
import com.bilibili.lib.image2.view.BiliImageView;
import com.bilibili.magicasakura.widgets.TintCheckBox;
import com.bilibili.magicasakura.widgets.TintImageView;
import com.bilibili.magicasakura.widgets.TintProgressBar;
import com.bilibili.magicasakura.widgets.TintTextView;
import tv.danmaku.bili.R;
import tv.danmaku.bili.widget.PriorityLinearLayout;
import tv.danmaku.bili.widget.VectorTextView;

public final class BiliAppItemFavoritesVideoBinding implements ViewBinding {
    public final FrameLayout audioIcon;
    public final PriorityLinearLayout bottomDesc;
    public final TintCheckBox checkBox;
    public final BiliImageView cover;
    public final TintTextView coverTag;
    public final TintImageView icMove;
    public final RoundCircleFrameLayout idCoverProgress;
    public final VectorTextView leftText;
    public final View line;
    public final TintImageView more;
    public final TintProgressBar progress;
    public final VectorTextView rightText;
    private final ConstraintLayout rootView;
    public final TintTextView subtitle;
    public final TintTextView title;
    public final VectorTextView upName;
    public final VectorTextView videoTime;

    private BiliAppItemFavoritesVideoBinding(ConstraintLayout rootView, FrameLayout audioIcon, PriorityLinearLayout bottomDesc, TintCheckBox checkBox, BiliImageView cover, TintTextView coverTag, TintImageView icMove, RoundCircleFrameLayout idCoverProgress, VectorTextView leftText, View line, TintImageView more, TintProgressBar progress, VectorTextView rightText, TintTextView subtitle, TintTextView title, VectorTextView upName, VectorTextView videoTime) {
        this.rootView = rootView;
        this.audioIcon = audioIcon;
        this.bottomDesc = bottomDesc;
        this.checkBox = checkBox;
        this.cover = cover;
        this.coverTag = coverTag;
        this.icMove = icMove;
        this.idCoverProgress = idCoverProgress;
        this.leftText = leftText;
        this.line = line;
        this.more = more;
        this.progress = progress;
        this.rightText = rightText;
        this.subtitle = subtitle;
        this.title = title;
        this.upName = upName;
        this.videoTime = videoTime;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppItemFavoritesVideoBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppItemFavoritesVideoBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_item_favorites_video, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppItemFavoritesVideoBinding bind(View rootView) {
        PriorityLinearLayout bottomDesc;
        TintCheckBox checkBox;
        BiliImageView cover;
        TintTextView coverTag;
        TintImageView icMove;
        RoundCircleFrameLayout idCoverProgress;
        VectorTextView leftText;
        View line;
        TintImageView more;
        TintProgressBar progress;
        VectorTextView rightText;
        TintTextView subtitle;
        TintTextView title;
        VectorTextView upName;
        VectorTextView videoTime;
        int id = R.id.audio_icon;
        FrameLayout audioIcon = (FrameLayout) ViewBindings.findChildViewById(rootView, id);
        if (audioIcon != null && (bottomDesc = ViewBindings.findChildViewById(rootView, (id = R.id.bottom_desc))) != null && (checkBox = ViewBindings.findChildViewById(rootView, (id = R.id.check_box))) != null && (cover = ViewBindings.findChildViewById(rootView, (id = R.id.cover))) != null && (coverTag = ViewBindings.findChildViewById(rootView, (id = R.id.cover_tag))) != null && (icMove = ViewBindings.findChildViewById(rootView, (id = R.id.ic_move))) != null && (idCoverProgress = ViewBindings.findChildViewById(rootView, (id = R.id.id_cover_progress))) != null && (leftText = ViewBindings.findChildViewById(rootView, (id = R.id.left_text))) != null && (line = ViewBindings.findChildViewById(rootView, (id = R.id.line))) != null && (more = ViewBindings.findChildViewById(rootView, (id = R.id.more))) != null && (progress = ViewBindings.findChildViewById(rootView, (id = R.id.progress))) != null && (rightText = ViewBindings.findChildViewById(rootView, (id = R.id.right_text))) != null && (subtitle = ViewBindings.findChildViewById(rootView, (id = R.id.subtitle))) != null && (title = ViewBindings.findChildViewById(rootView, (id = R.id.title))) != null && (upName = ViewBindings.findChildViewById(rootView, (id = R.id.up_name))) != null && (videoTime = ViewBindings.findChildViewById(rootView, (id = R.id.video_time))) != null) {
            return new BiliAppItemFavoritesVideoBinding((ConstraintLayout) rootView, audioIcon, bottomDesc, checkBox, cover, coverTag, icMove, idCoverProgress, leftText, line, more, progress, rightText, subtitle, title, upName, videoTime);
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}