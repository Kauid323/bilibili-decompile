package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import tv.danmaku.bili.R;

public final class BiliAppHotListWidgetBlockBinding implements ViewBinding {
    public final ImageView background;
    public final ImageView blockLeft;
    public final ImageView brand;
    public final RelativeLayout container;
    private final RelativeLayout rootView;

    private BiliAppHotListWidgetBlockBinding(RelativeLayout rootView, ImageView background, ImageView blockLeft, ImageView brand, RelativeLayout container) {
        this.rootView = rootView;
        this.background = background;
        this.blockLeft = blockLeft;
        this.brand = brand;
        this.container = container;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppHotListWidgetBlockBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppHotListWidgetBlockBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_hot_list_widget_block, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppHotListWidgetBlockBinding bind(View rootView) {
        int id = 16908288;
        ImageView background = (ImageView) ViewBindings.findChildViewById(rootView, 16908288);
        if (background != null) {
            id = R.id.block_left;
            ImageView blockLeft = (ImageView) ViewBindings.findChildViewById(rootView, id);
            if (blockLeft != null) {
                id = R.id.brand;
                ImageView brand = (ImageView) ViewBindings.findChildViewById(rootView, id);
                if (brand != null) {
                    id = R.id.container;
                    RelativeLayout container = (RelativeLayout) ViewBindings.findChildViewById(rootView, id);
                    if (container != null) {
                        return new BiliAppHotListWidgetBlockBinding((RelativeLayout) rootView, background, blockLeft, brand, container);
                    }
                }
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}