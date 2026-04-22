package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bilibili.lib.image2.view.legacy.ScalableImageView2;
import com.bilibili.magicasakura.widgets.TintImageView;
import com.bilibili.magicasakura.widgets.TintLinearLayout;
import com.bilibili.magicasakura.widgets.TintTextView;
import tv.danmaku.bili.R;

public final class BiliAppListItemFavoriteH5topicBinding implements ViewBinding {
    public final ScalableImageView2 cover;
    public final TintTextView favTime;
    public final TintImageView menuMore;
    private final TintLinearLayout rootView;
    public final TintTextView title;

    private BiliAppListItemFavoriteH5topicBinding(TintLinearLayout rootView, ScalableImageView2 cover, TintTextView favTime, TintImageView menuMore, TintTextView title) {
        this.rootView = rootView;
        this.cover = cover;
        this.favTime = favTime;
        this.menuMore = menuMore;
        this.title = title;
    }

    public TintLinearLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppListItemFavoriteH5topicBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppListItemFavoriteH5topicBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_list_item_favorite_h5topic, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppListItemFavoriteH5topicBinding bind(View rootView) {
        TintTextView favTime;
        TintImageView menuMore;
        TintTextView title;
        int id = R.id.cover;
        ScalableImageView2 cover = ViewBindings.findChildViewById(rootView, id);
        if (cover != null && (favTime = ViewBindings.findChildViewById(rootView, (id = R.id.fav_time))) != null && (menuMore = ViewBindings.findChildViewById(rootView, (id = R.id.menu_more))) != null && (title = ViewBindings.findChildViewById(rootView, (id = R.id.title))) != null) {
            return new BiliAppListItemFavoriteH5topicBinding((TintLinearLayout) rootView, cover, favTime, menuMore, title);
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}