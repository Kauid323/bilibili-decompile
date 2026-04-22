package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bilibili.lib.image2.view.legacy.StaticImageView2;
import tv.danmaku.bili.R;

public final class BiliAppLayoutFavoriteHomeErrorBinding implements ViewBinding {
    public final StaticImageView2 image;
    public final TextView retry;
    private final LinearLayout rootView;
    public final TextView tip;

    private BiliAppLayoutFavoriteHomeErrorBinding(LinearLayout rootView, StaticImageView2 image, TextView retry, TextView tip) {
        this.rootView = rootView;
        this.image = image;
        this.retry = retry;
        this.tip = tip;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppLayoutFavoriteHomeErrorBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppLayoutFavoriteHomeErrorBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_layout_favorite_home_error, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppLayoutFavoriteHomeErrorBinding bind(View rootView) {
        int id = R.id.image;
        StaticImageView2 image = ViewBindings.findChildViewById(rootView, id);
        if (image != null) {
            id = R.id.retry;
            TextView retry = (TextView) ViewBindings.findChildViewById(rootView, id);
            if (retry != null) {
                id = R.id.tip;
                TextView tip = (TextView) ViewBindings.findChildViewById(rootView, id);
                if (tip != null) {
                    return new BiliAppLayoutFavoriteHomeErrorBinding((LinearLayout) rootView, image, retry, tip);
                }
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}