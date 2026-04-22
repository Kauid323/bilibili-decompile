package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import tv.danmaku.bili.R;

public final class BiliAppItemFavoritesAddFolderBinding implements ViewBinding {
    public final FrameLayout container;
    private final FrameLayout rootView;

    private BiliAppItemFavoritesAddFolderBinding(FrameLayout rootView, FrameLayout container) {
        this.rootView = rootView;
        this.container = container;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppItemFavoritesAddFolderBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppItemFavoritesAddFolderBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_item_favorites_add_folder, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppItemFavoritesAddFolderBinding bind(View rootView) {
        if (rootView == null) {
            throw new NullPointerException("rootView");
        }
        FrameLayout container = (FrameLayout) rootView;
        return new BiliAppItemFavoritesAddFolderBinding((FrameLayout) rootView, container);
    }
}