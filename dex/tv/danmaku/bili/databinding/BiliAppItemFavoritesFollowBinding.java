package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bilibili.lib.image2.view.BiliImageView;
import com.bilibili.magicasakura.widgets.TintImageView;
import com.bilibili.magicasakura.widgets.TintTextView;
import tv.danmaku.bili.R;

public final class BiliAppItemFavoritesFollowBinding implements ViewBinding {
    public final TintTextView bottomText1;
    public final TintTextView bottomText2;
    public final BiliImageView cover;
    public final TintTextView coverShadow;
    public final TintTextView coverTag;
    public final TintImageView more;
    private final ConstraintLayout rootView;
    public final TintTextView tagNew;
    public final TintTextView title;

    private BiliAppItemFavoritesFollowBinding(ConstraintLayout rootView, TintTextView bottomText1, TintTextView bottomText2, BiliImageView cover, TintTextView coverShadow, TintTextView coverTag, TintImageView more, TintTextView tagNew, TintTextView title) {
        this.rootView = rootView;
        this.bottomText1 = bottomText1;
        this.bottomText2 = bottomText2;
        this.cover = cover;
        this.coverShadow = coverShadow;
        this.coverTag = coverTag;
        this.more = more;
        this.tagNew = tagNew;
        this.title = title;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppItemFavoritesFollowBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppItemFavoritesFollowBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_item_favorites_follow, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppItemFavoritesFollowBinding bind(View rootView) {
        TintTextView bottomText2;
        BiliImageView cover;
        TintTextView coverShadow;
        TintTextView coverTag;
        TintImageView more;
        TintTextView tagNew;
        TintTextView title;
        int id = R.id.bottom_text_1;
        TintTextView bottomText1 = ViewBindings.findChildViewById(rootView, id);
        if (bottomText1 != null && (bottomText2 = ViewBindings.findChildViewById(rootView, (id = R.id.bottom_text_2))) != null && (cover = ViewBindings.findChildViewById(rootView, (id = R.id.cover))) != null && (coverShadow = ViewBindings.findChildViewById(rootView, (id = R.id.cover_shadow))) != null && (coverTag = ViewBindings.findChildViewById(rootView, (id = R.id.cover_tag))) != null && (more = ViewBindings.findChildViewById(rootView, (id = R.id.more))) != null && (tagNew = ViewBindings.findChildViewById(rootView, (id = R.id.tag_new))) != null && (title = ViewBindings.findChildViewById(rootView, (id = R.id.title))) != null) {
            return new BiliAppItemFavoritesFollowBinding((ConstraintLayout) rootView, bottomText1, bottomText2, cover, coverShadow, coverTag, more, tagNew, title);
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}