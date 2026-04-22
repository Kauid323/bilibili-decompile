package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import tv.danmaku.bili.R;

public final class BiliAppUpCardWidgetBlockBinding implements ViewBinding {
    public final ImageView background;
    public final ImageView blockRight;
    public final ImageView brand;
    public final TextView button;
    public final RelativeLayout container;
    private final RelativeLayout rootView;
    public final TextView title;

    private BiliAppUpCardWidgetBlockBinding(RelativeLayout rootView, ImageView background, ImageView blockRight, ImageView brand, TextView button, RelativeLayout container, TextView title) {
        this.rootView = rootView;
        this.background = background;
        this.blockRight = blockRight;
        this.brand = brand;
        this.button = button;
        this.container = container;
        this.title = title;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppUpCardWidgetBlockBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppUpCardWidgetBlockBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_up_card_widget_block, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppUpCardWidgetBlockBinding bind(View rootView) {
        int id = 16908288;
        ImageView background = (ImageView) ViewBindings.findChildViewById(rootView, 16908288);
        if (background != null) {
            id = R.id.block_right;
            ImageView blockRight = (ImageView) ViewBindings.findChildViewById(rootView, id);
            if (blockRight != null) {
                id = R.id.brand;
                ImageView brand = (ImageView) ViewBindings.findChildViewById(rootView, id);
                if (brand != null) {
                    id = R.id.button;
                    TextView button = (TextView) ViewBindings.findChildViewById(rootView, id);
                    if (button != null) {
                        RelativeLayout container = (RelativeLayout) rootView;
                        id = R.id.title;
                        TextView title = (TextView) ViewBindings.findChildViewById(rootView, id);
                        if (title != null) {
                            return new BiliAppUpCardWidgetBlockBinding((RelativeLayout) rootView, background, blockRight, brand, button, container, title);
                        }
                    }
                }
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}