package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bilibili.lib.image2.view.BiliImageView;
import com.opensource.svgaplayer.SVGAImageView;
import tv.danmaku.bili.R;
import tv.danmaku.bili.widget.PendantAvatarFrameLayout;

public final class BiliAppLayoutImageRecognizeDialogBinding implements ViewBinding {
    public final PendantAvatarFrameLayout avatar;
    public final ImageView closeBtn;
    public final BiliImageView cover;
    public final ConstraintLayout dialogContent;
    public final TextView duration;
    public final TextView fansNum;
    public final BiliImageView fullCover;
    public final TextView hint;
    public final BiliImageView imageLabel;
    public final FrameLayout labelContainer;
    public final TextView nickname;
    public final Button play;
    public final ImageView playIc;
    public final TextView playNum;
    public final ImageView playNumIcon;
    private final LinearLayout rootView;
    public final SVGAImageView svgaLabel;
    public final TextView title;

    private BiliAppLayoutImageRecognizeDialogBinding(LinearLayout rootView, PendantAvatarFrameLayout avatar, ImageView closeBtn, BiliImageView cover, ConstraintLayout dialogContent, TextView duration, TextView fansNum, BiliImageView fullCover, TextView hint, BiliImageView imageLabel, FrameLayout labelContainer, TextView nickname, Button play, ImageView playIc, TextView playNum, ImageView playNumIcon, SVGAImageView svgaLabel, TextView title) {
        this.rootView = rootView;
        this.avatar = avatar;
        this.closeBtn = closeBtn;
        this.cover = cover;
        this.dialogContent = dialogContent;
        this.duration = duration;
        this.fansNum = fansNum;
        this.fullCover = fullCover;
        this.hint = hint;
        this.imageLabel = imageLabel;
        this.labelContainer = labelContainer;
        this.nickname = nickname;
        this.play = play;
        this.playIc = playIc;
        this.playNum = playNum;
        this.playNumIcon = playNumIcon;
        this.svgaLabel = svgaLabel;
        this.title = title;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppLayoutImageRecognizeDialogBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppLayoutImageRecognizeDialogBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_layout_image_recognize_dialog, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppLayoutImageRecognizeDialogBinding bind(View rootView) {
        BiliImageView cover;
        ConstraintLayout dialogContent;
        BiliImageView fullCover;
        BiliImageView imageLabel;
        SVGAImageView svgaLabel;
        int id = R.id.avatar;
        PendantAvatarFrameLayout avatar = ViewBindings.findChildViewById(rootView, id);
        if (avatar != null) {
            id = R.id.close_btn;
            ImageView closeBtn = (ImageView) ViewBindings.findChildViewById(rootView, id);
            if (closeBtn != null && (cover = ViewBindings.findChildViewById(rootView, (id = R.id.cover))) != null && (dialogContent = ViewBindings.findChildViewById(rootView, (id = R.id.dialog_content))) != null) {
                id = R.id.duration;
                TextView duration = (TextView) ViewBindings.findChildViewById(rootView, id);
                if (duration != null) {
                    id = R.id.fans_num;
                    TextView fansNum = (TextView) ViewBindings.findChildViewById(rootView, id);
                    if (fansNum != null && (fullCover = ViewBindings.findChildViewById(rootView, (id = R.id.full_cover))) != null) {
                        id = R.id.hint;
                        TextView hint = (TextView) ViewBindings.findChildViewById(rootView, id);
                        if (hint != null && (imageLabel = ViewBindings.findChildViewById(rootView, (id = R.id.image_label))) != null) {
                            id = R.id.label_container;
                            FrameLayout labelContainer = (FrameLayout) ViewBindings.findChildViewById(rootView, id);
                            if (labelContainer != null) {
                                id = R.id.nickname;
                                TextView nickname = (TextView) ViewBindings.findChildViewById(rootView, id);
                                if (nickname != null) {
                                    id = R.id.play;
                                    Button play = (Button) ViewBindings.findChildViewById(rootView, id);
                                    if (play != null) {
                                        id = R.id.play_ic;
                                        ImageView playIc = (ImageView) ViewBindings.findChildViewById(rootView, id);
                                        if (playIc != null) {
                                            id = R.id.play_num;
                                            TextView playNum = (TextView) ViewBindings.findChildViewById(rootView, id);
                                            if (playNum != null) {
                                                id = R.id.play_num_icon;
                                                ImageView playNumIcon = (ImageView) ViewBindings.findChildViewById(rootView, id);
                                                if (playNumIcon != null && (svgaLabel = ViewBindings.findChildViewById(rootView, (id = R.id.svga_label))) != null) {
                                                    id = R.id.title;
                                                    TextView title = (TextView) ViewBindings.findChildViewById(rootView, id);
                                                    if (title != null) {
                                                        return new BiliAppLayoutImageRecognizeDialogBinding((LinearLayout) rootView, avatar, closeBtn, cover, dialogContent, duration, fansNum, fullCover, hint, imageLabel, labelContainer, nickname, play, playIc, playNum, playNumIcon, svgaLabel, title);
                                                    }
                                                }
                                            }
                                        }
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