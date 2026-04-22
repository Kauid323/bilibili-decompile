package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bilibili.lib.image2.view.BiliImageView;
import tv.danmaku.bili.R;

public final class BiliAppDialogNavigationGuideBinding implements ViewBinding {
    public final BiliImageView bottomImage;
    private final ConstraintLayout rootView;
    public final BiliImageView topImage;

    private BiliAppDialogNavigationGuideBinding(ConstraintLayout rootView, BiliImageView bottomImage, BiliImageView topImage) {
        this.rootView = rootView;
        this.bottomImage = bottomImage;
        this.topImage = topImage;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppDialogNavigationGuideBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppDialogNavigationGuideBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_dialog_navigation_guide, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppDialogNavigationGuideBinding bind(View rootView) {
        BiliImageView topImage;
        int id = R.id.bottom_image;
        BiliImageView bottomImage = ViewBindings.findChildViewById(rootView, id);
        if (bottomImage != null && (topImage = ViewBindings.findChildViewById(rootView, (id = R.id.top_image))) != null) {
            return new BiliAppDialogNavigationGuideBinding((ConstraintLayout) rootView, bottomImage, topImage);
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}