package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import tv.danmaku.bili.R;
import tv.danmaku.bili.ui.main2.mine.widgets.MultipleThemeImageView;

public final class BiliLayoutGloballinkEntranceBinding implements ViewBinding {
    public final MultipleThemeImageView mineLinkNormal;
    public final MultipleThemeImageView mineLinkSelected;
    private final ConstraintLayout rootView;

    private BiliLayoutGloballinkEntranceBinding(ConstraintLayout rootView, MultipleThemeImageView mineLinkNormal, MultipleThemeImageView mineLinkSelected) {
        this.rootView = rootView;
        this.mineLinkNormal = mineLinkNormal;
        this.mineLinkSelected = mineLinkSelected;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BiliLayoutGloballinkEntranceBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliLayoutGloballinkEntranceBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_layout_globallink_entrance, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliLayoutGloballinkEntranceBinding bind(View rootView) {
        int id = R.id.mine_link_normal;
        MultipleThemeImageView mineLinkNormal = (MultipleThemeImageView) ViewBindings.findChildViewById(rootView, id);
        if (mineLinkNormal != null) {
            id = R.id.mine_link_selected;
            MultipleThemeImageView mineLinkSelected = (MultipleThemeImageView) ViewBindings.findChildViewById(rootView, id);
            if (mineLinkSelected != null) {
                return new BiliLayoutGloballinkEntranceBinding((ConstraintLayout) rootView, mineLinkNormal, mineLinkSelected);
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}