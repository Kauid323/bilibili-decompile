package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.legacy.widget.Space;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bilibili.magicasakura.widgets.TintConstraintLayout;
import com.bilibili.magicasakura.widgets.TintImageView;
import com.bilibili.magicasakura.widgets.TintTextView;
import tv.danmaku.bili.R;

public final class BiliAppItemFavoritesFolderBinding implements ViewBinding {
    public final TintTextView folderTitle;
    public final TintImageView lock;
    public final RecyclerView recyclerView;
    public final TintImageView rightArrow;
    private final TintConstraintLayout rootView;
    public final TintTextView subtitle;
    public final Space titleSpace;

    private BiliAppItemFavoritesFolderBinding(TintConstraintLayout rootView, TintTextView folderTitle, TintImageView lock, RecyclerView recyclerView, TintImageView rightArrow, TintTextView subtitle, Space titleSpace) {
        this.rootView = rootView;
        this.folderTitle = folderTitle;
        this.lock = lock;
        this.recyclerView = recyclerView;
        this.rightArrow = rightArrow;
        this.subtitle = subtitle;
        this.titleSpace = titleSpace;
    }

    public TintConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppItemFavoritesFolderBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppItemFavoritesFolderBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_item_favorites_folder, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppItemFavoritesFolderBinding bind(View rootView) {
        TintImageView lock;
        RecyclerView recyclerView;
        TintImageView rightArrow;
        TintTextView subtitle;
        Space titleSpace;
        int id = R.id.folder_title;
        TintTextView folderTitle = ViewBindings.findChildViewById(rootView, id);
        if (folderTitle != null && (lock = ViewBindings.findChildViewById(rootView, (id = R.id.lock))) != null && (recyclerView = ViewBindings.findChildViewById(rootView, (id = R.id.recycler_view))) != null && (rightArrow = ViewBindings.findChildViewById(rootView, (id = R.id.right_arrow))) != null && (subtitle = ViewBindings.findChildViewById(rootView, (id = R.id.subtitle))) != null && (titleSpace = ViewBindings.findChildViewById(rootView, (id = R.id.title_space))) != null) {
            return new BiliAppItemFavoritesFolderBinding((TintConstraintLayout) rootView, folderTitle, lock, recyclerView, rightArrow, subtitle, titleSpace);
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}