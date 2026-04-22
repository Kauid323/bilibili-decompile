package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bilibili.magicasakura.widgets.TintTextView;
import tv.danmaku.bili.R;

public final class BiliAppDialogDirectGuideBinding implements ViewBinding {
    public final TintTextView ratingDialogTvFeedback;
    public final TintTextView ratingDialogTvGostore;
    public final TintTextView ratingDialogTvNext;
    public final TintTextView ratingDialogTvTitle;
    private final CardView rootView;

    private BiliAppDialogDirectGuideBinding(CardView rootView, TintTextView ratingDialogTvFeedback, TintTextView ratingDialogTvGostore, TintTextView ratingDialogTvNext, TintTextView ratingDialogTvTitle) {
        this.rootView = rootView;
        this.ratingDialogTvFeedback = ratingDialogTvFeedback;
        this.ratingDialogTvGostore = ratingDialogTvGostore;
        this.ratingDialogTvNext = ratingDialogTvNext;
        this.ratingDialogTvTitle = ratingDialogTvTitle;
    }

    public CardView getRoot() {
        return this.rootView;
    }

    public static BiliAppDialogDirectGuideBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppDialogDirectGuideBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_dialog_direct_guide, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppDialogDirectGuideBinding bind(View rootView) {
        TintTextView ratingDialogTvGostore;
        TintTextView ratingDialogTvNext;
        TintTextView ratingDialogTvTitle;
        int id = R.id.rating_dialog_tv_feedback;
        TintTextView ratingDialogTvFeedback = ViewBindings.findChildViewById(rootView, id);
        if (ratingDialogTvFeedback != null && (ratingDialogTvGostore = ViewBindings.findChildViewById(rootView, (id = R.id.rating_dialog_tv_gostore))) != null && (ratingDialogTvNext = ViewBindings.findChildViewById(rootView, (id = R.id.rating_dialog_tv_next))) != null && (ratingDialogTvTitle = ViewBindings.findChildViewById(rootView, (id = R.id.rating_dialog_tv_title))) != null) {
            return new BiliAppDialogDirectGuideBinding((CardView) rootView, ratingDialogTvFeedback, ratingDialogTvGostore, ratingDialogTvNext, ratingDialogTvTitle);
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}