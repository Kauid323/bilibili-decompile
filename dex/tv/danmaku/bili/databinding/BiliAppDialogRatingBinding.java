package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bilibili.magicasakura.widgets.TintImageView;
import com.bilibili.magicasakura.widgets.TintTextView;
import tv.danmaku.bili.R;
import tv.danmaku.bili.rating.RatingView;

public final class BiliAppDialogRatingBinding implements ViewBinding {
    public final TintImageView ratingDialogClose;
    public final RatingView ratingDialogRatingview;
    public final TintTextView ratingDialogTvTitle;
    private final CardView rootView;

    private BiliAppDialogRatingBinding(CardView rootView, TintImageView ratingDialogClose, RatingView ratingDialogRatingview, TintTextView ratingDialogTvTitle) {
        this.rootView = rootView;
        this.ratingDialogClose = ratingDialogClose;
        this.ratingDialogRatingview = ratingDialogRatingview;
        this.ratingDialogTvTitle = ratingDialogTvTitle;
    }

    public CardView getRoot() {
        return this.rootView;
    }

    public static BiliAppDialogRatingBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppDialogRatingBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_dialog_rating, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppDialogRatingBinding bind(View rootView) {
        TintTextView ratingDialogTvTitle;
        int id = R.id.rating_dialog_close;
        TintImageView ratingDialogClose = ViewBindings.findChildViewById(rootView, id);
        if (ratingDialogClose != null) {
            id = R.id.rating_dialog_ratingview;
            RatingView ratingDialogRatingview = (RatingView) ViewBindings.findChildViewById(rootView, id);
            if (ratingDialogRatingview != null && (ratingDialogTvTitle = ViewBindings.findChildViewById(rootView, (id = R.id.rating_dialog_tv_title))) != null) {
                return new BiliAppDialogRatingBinding((CardView) rootView, ratingDialogClose, ratingDialogRatingview, ratingDialogTvTitle);
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}