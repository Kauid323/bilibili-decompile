package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bilibili.lib.image2.view.BiliImageView;
import com.bilibili.magicasakura.widgets.TintTextView;
import tv.danmaku.bili.R;

public final class BiliAppItemFavoritesFolderItemBinding implements ViewBinding {
    public final ConstraintLayout container;
    public final BiliImageView cover;
    public final BiliImageView cover11;
    private final ConstraintLayout rootView;
    public final TintTextView title;

    private BiliAppItemFavoritesFolderItemBinding(ConstraintLayout rootView, ConstraintLayout container, BiliImageView cover, BiliImageView cover11, TintTextView title) {
        this.rootView = rootView;
        this.container = container;
        this.cover = cover;
        this.cover11 = cover11;
        this.title = title;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppItemFavoritesFolderItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppItemFavoritesFolderItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_item_favorites_folder_item, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppItemFavoritesFolderItemBinding bind(View rootView) {
        BiliImageView cover11;
        ConstraintLayout container = (ConstraintLayout) rootView;
        int id = R.id.cover;
        BiliImageView cover = ViewBindings.findChildViewById(rootView, id);
        if (cover != null && (cover11 = ViewBindings.findChildViewById(rootView, (id = R.id.cover_11))) != null) {
            int id2 = R.id.title;
            TintTextView title = ViewBindings.findChildViewById(rootView, id2);
            if (title == null) {
                id = id2;
            } else {
                return new BiliAppItemFavoritesFolderItemBinding((ConstraintLayout) rootView, container, cover, cover11, title);
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}