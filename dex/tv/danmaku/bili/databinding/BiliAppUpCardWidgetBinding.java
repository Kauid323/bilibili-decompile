package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import tv.danmaku.bili.R;

public final class BiliAppUpCardWidgetBinding implements ViewBinding {
    public final LinearLayout background;
    public final RelativeLayout container;
    public final LinearLayout containerEntrances;
    public final ImageView multiCardBrand;
    public final ImageView multiCardMore;
    public final ImageView multiCardRedDot;
    public final TextView multiCardTitle;
    public final RelativeLayout multiCardTopBar;
    public final TextView multiCardUpdateTitle;
    private final RelativeLayout rootView;

    private BiliAppUpCardWidgetBinding(RelativeLayout rootView, LinearLayout background, RelativeLayout container, LinearLayout containerEntrances, ImageView multiCardBrand, ImageView multiCardMore, ImageView multiCardRedDot, TextView multiCardTitle, RelativeLayout multiCardTopBar, TextView multiCardUpdateTitle) {
        this.rootView = rootView;
        this.background = background;
        this.container = container;
        this.containerEntrances = containerEntrances;
        this.multiCardBrand = multiCardBrand;
        this.multiCardMore = multiCardMore;
        this.multiCardRedDot = multiCardRedDot;
        this.multiCardTitle = multiCardTitle;
        this.multiCardTopBar = multiCardTopBar;
        this.multiCardUpdateTitle = multiCardUpdateTitle;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppUpCardWidgetBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppUpCardWidgetBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_up_card_widget, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppUpCardWidgetBinding bind(View rootView) {
        int id = R.id.background;
        LinearLayout background = (LinearLayout) ViewBindings.findChildViewById(rootView, id);
        if (background != null) {
            id = R.id.container;
            RelativeLayout container = (RelativeLayout) ViewBindings.findChildViewById(rootView, id);
            if (container != null) {
                id = R.id.container_entrances;
                LinearLayout containerEntrances = (LinearLayout) ViewBindings.findChildViewById(rootView, id);
                if (containerEntrances != null) {
                    id = R.id.multi_card_brand;
                    ImageView multiCardBrand = (ImageView) ViewBindings.findChildViewById(rootView, id);
                    if (multiCardBrand != null) {
                        id = R.id.multi_card_more;
                        ImageView multiCardMore = (ImageView) ViewBindings.findChildViewById(rootView, id);
                        if (multiCardMore != null) {
                            id = R.id.multi_card_red_dot;
                            ImageView multiCardRedDot = (ImageView) ViewBindings.findChildViewById(rootView, id);
                            if (multiCardRedDot != null) {
                                id = R.id.multi_card_title;
                                TextView multiCardTitle = (TextView) ViewBindings.findChildViewById(rootView, id);
                                if (multiCardTitle != null) {
                                    id = R.id.multi_card_top_bar;
                                    RelativeLayout multiCardTopBar = (RelativeLayout) ViewBindings.findChildViewById(rootView, id);
                                    if (multiCardTopBar != null) {
                                        id = R.id.multi_card_update_title;
                                        TextView multiCardUpdateTitle = (TextView) ViewBindings.findChildViewById(rootView, id);
                                        if (multiCardUpdateTitle != null) {
                                            return new BiliAppUpCardWidgetBinding((RelativeLayout) rootView, background, container, containerEntrances, multiCardBrand, multiCardMore, multiCardRedDot, multiCardTitle, multiCardTopBar, multiCardUpdateTitle);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}