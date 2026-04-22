package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import tv.danmaku.bili.R;

public final class BiliAppViewCollectionAllFooterBinding implements ViewBinding {
    public final AppCompatTextView collectionAllHeaderTitle;
    public final AppCompatImageView collectionAllHeaderTitleRightArrow;
    private final ConstraintLayout rootView;

    private BiliAppViewCollectionAllFooterBinding(ConstraintLayout rootView, AppCompatTextView collectionAllHeaderTitle, AppCompatImageView collectionAllHeaderTitleRightArrow) {
        this.rootView = rootView;
        this.collectionAllHeaderTitle = collectionAllHeaderTitle;
        this.collectionAllHeaderTitleRightArrow = collectionAllHeaderTitleRightArrow;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppViewCollectionAllFooterBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppViewCollectionAllFooterBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_view_collection_all_footer, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppViewCollectionAllFooterBinding bind(View rootView) {
        AppCompatImageView collectionAllHeaderTitleRightArrow;
        int id = R.id.collection_all_header_title;
        AppCompatTextView collectionAllHeaderTitle = ViewBindings.findChildViewById(rootView, id);
        if (collectionAllHeaderTitle != null && (collectionAllHeaderTitleRightArrow = ViewBindings.findChildViewById(rootView, (id = R.id.collection_all_header_title_right_arrow))) != null) {
            return new BiliAppViewCollectionAllFooterBinding((ConstraintLayout) rootView, collectionAllHeaderTitle, collectionAllHeaderTitleRightArrow);
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}