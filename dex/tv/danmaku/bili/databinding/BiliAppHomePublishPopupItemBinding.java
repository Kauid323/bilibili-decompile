package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import tv.danmaku.bili.R;

public final class BiliAppHomePublishPopupItemBinding implements ViewBinding {
    public final ImageView image;
    private final ImageView rootView;

    private BiliAppHomePublishPopupItemBinding(ImageView rootView, ImageView image) {
        this.rootView = rootView;
        this.image = image;
    }

    public ImageView getRoot() {
        return this.rootView;
    }

    public static BiliAppHomePublishPopupItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppHomePublishPopupItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_home_publish_popup_item, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppHomePublishPopupItemBinding bind(View rootView) {
        if (rootView == null) {
            throw new NullPointerException("rootView");
        }
        ImageView image = (ImageView) rootView;
        return new BiliAppHomePublishPopupItemBinding((ImageView) rootView, image);
    }
}