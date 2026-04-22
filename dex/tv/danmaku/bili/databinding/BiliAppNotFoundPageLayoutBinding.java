package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bilibili.lib.image2.view.legacy.StaticImageView2;
import tv.danmaku.bili.R;

public final class BiliAppNotFoundPageLayoutBinding implements ViewBinding {
    public final ImageView errorNotFoundBack;
    public final StaticImageView2 errorNotFoundImg;
    public final RelativeLayout errorNotFoundRoot;
    public final TextView errorNotFoundText;
    private final RelativeLayout rootView;

    private BiliAppNotFoundPageLayoutBinding(RelativeLayout rootView, ImageView errorNotFoundBack, StaticImageView2 errorNotFoundImg, RelativeLayout errorNotFoundRoot, TextView errorNotFoundText) {
        this.rootView = rootView;
        this.errorNotFoundBack = errorNotFoundBack;
        this.errorNotFoundImg = errorNotFoundImg;
        this.errorNotFoundRoot = errorNotFoundRoot;
        this.errorNotFoundText = errorNotFoundText;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppNotFoundPageLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppNotFoundPageLayoutBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_not_found_page_layout, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppNotFoundPageLayoutBinding bind(View rootView) {
        StaticImageView2 errorNotFoundImg;
        int id = R.id.error_not_found_back;
        ImageView errorNotFoundBack = (ImageView) ViewBindings.findChildViewById(rootView, id);
        if (errorNotFoundBack != null && (errorNotFoundImg = ViewBindings.findChildViewById(rootView, (id = R.id.error_not_found_img))) != null) {
            RelativeLayout errorNotFoundRoot = (RelativeLayout) rootView;
            id = R.id.error_not_found_text;
            TextView errorNotFoundText = (TextView) ViewBindings.findChildViewById(rootView, id);
            if (errorNotFoundText != null) {
                return new BiliAppNotFoundPageLayoutBinding((RelativeLayout) rootView, errorNotFoundBack, errorNotFoundImg, errorNotFoundRoot, errorNotFoundText);
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}