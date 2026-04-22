package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bilibili.lib.image2.view.BiliImageView;
import com.bilibili.magicasakura.widgets.TintCheckBox;
import com.bilibili.magicasakura.widgets.TintImageView;
import com.bilibili.magicasakura.widgets.TintTextView;
import tv.danmaku.bili.R;
import tv.danmaku.bili.widget.VectorTextView;

public final class BiliAppItemFavoritesArticleBinding implements ViewBinding {
    public final ConstraintLayout bottomDesc;
    public final TintCheckBox checkBox;
    public final BiliImageView cover;
    public final Guideline guideline;
    public final VectorTextView leftText;
    public final TintImageView more;
    public final VectorTextView rightText;
    private final ConstraintLayout rootView;
    public final TintTextView subtitle;
    public final TintTextView title;

    private BiliAppItemFavoritesArticleBinding(ConstraintLayout rootView, ConstraintLayout bottomDesc, TintCheckBox checkBox, BiliImageView cover, Guideline guideline, VectorTextView leftText, TintImageView more, VectorTextView rightText, TintTextView subtitle, TintTextView title) {
        this.rootView = rootView;
        this.bottomDesc = bottomDesc;
        this.checkBox = checkBox;
        this.cover = cover;
        this.guideline = guideline;
        this.leftText = leftText;
        this.more = more;
        this.rightText = rightText;
        this.subtitle = subtitle;
        this.title = title;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppItemFavoritesArticleBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppItemFavoritesArticleBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_item_favorites_article, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppItemFavoritesArticleBinding bind(View rootView) {
        TintCheckBox checkBox;
        BiliImageView cover;
        Guideline guideline;
        VectorTextView leftText;
        TintImageView more;
        VectorTextView rightText;
        TintTextView subtitle;
        TintTextView title;
        int id = R.id.bottom_desc;
        ConstraintLayout bottomDesc = ViewBindings.findChildViewById(rootView, id);
        if (bottomDesc != null && (checkBox = ViewBindings.findChildViewById(rootView, (id = R.id.check_box))) != null && (cover = ViewBindings.findChildViewById(rootView, (id = R.id.cover))) != null && (guideline = ViewBindings.findChildViewById(rootView, (id = R.id.guideline))) != null && (leftText = ViewBindings.findChildViewById(rootView, (id = R.id.left_text))) != null && (more = ViewBindings.findChildViewById(rootView, (id = R.id.more))) != null && (rightText = ViewBindings.findChildViewById(rootView, (id = R.id.right_text))) != null && (subtitle = ViewBindings.findChildViewById(rootView, (id = R.id.subtitle))) != null && (title = ViewBindings.findChildViewById(rootView, (id = R.id.title))) != null) {
            return new BiliAppItemFavoritesArticleBinding((ConstraintLayout) rootView, bottomDesc, checkBox, cover, guideline, leftText, more, rightText, subtitle, title);
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}