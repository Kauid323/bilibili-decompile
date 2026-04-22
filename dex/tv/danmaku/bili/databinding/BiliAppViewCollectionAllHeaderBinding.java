package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bilibili.lib.avatar.widget.RoundBorderImageView;
import tv.danmaku.bili.R;

public final class BiliAppViewCollectionAllHeaderBinding implements ViewBinding {
    public final RoundBorderImageView collectionAllHeaderAvatar;
    public final AppCompatTextView collectionAllHeaderTitle;
    private final ConstraintLayout rootView;

    private BiliAppViewCollectionAllHeaderBinding(ConstraintLayout rootView, RoundBorderImageView collectionAllHeaderAvatar, AppCompatTextView collectionAllHeaderTitle) {
        this.rootView = rootView;
        this.collectionAllHeaderAvatar = collectionAllHeaderAvatar;
        this.collectionAllHeaderTitle = collectionAllHeaderTitle;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppViewCollectionAllHeaderBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppViewCollectionAllHeaderBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_view_collection_all_header, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppViewCollectionAllHeaderBinding bind(View rootView) {
        AppCompatTextView collectionAllHeaderTitle;
        int id = R.id.collection_all_header_avatar;
        RoundBorderImageView collectionAllHeaderAvatar = ViewBindings.findChildViewById(rootView, id);
        if (collectionAllHeaderAvatar != null && (collectionAllHeaderTitle = ViewBindings.findChildViewById(rootView, (id = R.id.collection_all_header_title))) != null) {
            return new BiliAppViewCollectionAllHeaderBinding((ConstraintLayout) rootView, collectionAllHeaderAvatar, collectionAllHeaderTitle);
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}