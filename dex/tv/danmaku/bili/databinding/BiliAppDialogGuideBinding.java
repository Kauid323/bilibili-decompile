package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bilibili.magicasakura.widgets.TintTextView;
import tv.danmaku.bili.R;

public final class BiliAppDialogGuideBinding implements ViewBinding {
    public final CardView ratingDialogCardGostore;
    public final FrameLayout ratingDialogFlNext;
    public final ImageView ratingDialogImgIcon;
    public final TintTextView ratingDialogTvCancelBtn;
    public final TintTextView ratingDialogTvSubtitle;
    public final TintTextView ratingDialogTvTitle;
    public final TintTextView ratingDialogTvTostoreBtn;
    private final CardView rootView;

    private BiliAppDialogGuideBinding(CardView rootView, CardView ratingDialogCardGostore, FrameLayout ratingDialogFlNext, ImageView ratingDialogImgIcon, TintTextView ratingDialogTvCancelBtn, TintTextView ratingDialogTvSubtitle, TintTextView ratingDialogTvTitle, TintTextView ratingDialogTvTostoreBtn) {
        this.rootView = rootView;
        this.ratingDialogCardGostore = ratingDialogCardGostore;
        this.ratingDialogFlNext = ratingDialogFlNext;
        this.ratingDialogImgIcon = ratingDialogImgIcon;
        this.ratingDialogTvCancelBtn = ratingDialogTvCancelBtn;
        this.ratingDialogTvSubtitle = ratingDialogTvSubtitle;
        this.ratingDialogTvTitle = ratingDialogTvTitle;
        this.ratingDialogTvTostoreBtn = ratingDialogTvTostoreBtn;
    }

    public CardView getRoot() {
        return this.rootView;
    }

    public static BiliAppDialogGuideBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppDialogGuideBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_dialog_guide, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppDialogGuideBinding bind(View rootView) {
        TintTextView ratingDialogTvCancelBtn;
        TintTextView ratingDialogTvSubtitle;
        TintTextView ratingDialogTvTitle;
        TintTextView ratingDialogTvTostoreBtn;
        int id = R.id.rating_dialog_card_gostore;
        CardView ratingDialogCardGostore = ViewBindings.findChildViewById(rootView, id);
        if (ratingDialogCardGostore != null) {
            id = R.id.rating_dialog_fl_next;
            FrameLayout ratingDialogFlNext = (FrameLayout) ViewBindings.findChildViewById(rootView, id);
            if (ratingDialogFlNext != null) {
                id = R.id.rating_dialog_img_icon;
                ImageView ratingDialogImgIcon = (ImageView) ViewBindings.findChildViewById(rootView, id);
                if (ratingDialogImgIcon != null && (ratingDialogTvCancelBtn = ViewBindings.findChildViewById(rootView, (id = R.id.rating_dialog_tv_cancel_btn))) != null && (ratingDialogTvSubtitle = ViewBindings.findChildViewById(rootView, (id = R.id.rating_dialog_tv_subtitle))) != null && (ratingDialogTvTitle = ViewBindings.findChildViewById(rootView, (id = R.id.rating_dialog_tv_title))) != null && (ratingDialogTvTostoreBtn = ViewBindings.findChildViewById(rootView, (id = R.id.rating_dialog_tv_tostore_btn))) != null) {
                    return new BiliAppDialogGuideBinding((CardView) rootView, ratingDialogCardGostore, ratingDialogFlNext, ratingDialogImgIcon, ratingDialogTvCancelBtn, ratingDialogTvSubtitle, ratingDialogTvTitle, ratingDialogTvTostoreBtn);
                }
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}