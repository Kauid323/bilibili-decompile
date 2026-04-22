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

public final class BiliAppHotListWidgetBinding implements ViewBinding {
    public final LinearLayout background;
    public final ImageView brand;
    public final RelativeLayout container;
    public final LinearLayout containerEntrances;
    public final LinearLayout containerSearch;
    public final LinearLayout exchange;
    private final RelativeLayout rootView;
    public final TextView tvHotWord;
    public final TextView tvTips;

    private BiliAppHotListWidgetBinding(RelativeLayout rootView, LinearLayout background, ImageView brand, RelativeLayout container, LinearLayout containerEntrances, LinearLayout containerSearch, LinearLayout exchange, TextView tvHotWord, TextView tvTips) {
        this.rootView = rootView;
        this.background = background;
        this.brand = brand;
        this.container = container;
        this.containerEntrances = containerEntrances;
        this.containerSearch = containerSearch;
        this.exchange = exchange;
        this.tvHotWord = tvHotWord;
        this.tvTips = tvTips;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppHotListWidgetBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppHotListWidgetBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_hot_list_widget, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppHotListWidgetBinding bind(View rootView) {
        int id = 16908288;
        LinearLayout background = (LinearLayout) ViewBindings.findChildViewById(rootView, 16908288);
        if (background != null) {
            id = R.id.brand;
            ImageView brand = (ImageView) ViewBindings.findChildViewById(rootView, id);
            if (brand != null) {
                id = R.id.container;
                RelativeLayout container = (RelativeLayout) ViewBindings.findChildViewById(rootView, id);
                if (container != null) {
                    id = R.id.container_entrances;
                    LinearLayout containerEntrances = (LinearLayout) ViewBindings.findChildViewById(rootView, id);
                    if (containerEntrances != null) {
                        id = R.id.container_search;
                        LinearLayout containerSearch = (LinearLayout) ViewBindings.findChildViewById(rootView, id);
                        if (containerSearch != null) {
                            id = R.id.exchange;
                            LinearLayout exchange = (LinearLayout) ViewBindings.findChildViewById(rootView, id);
                            if (exchange != null) {
                                id = R.id.tv_hot_word;
                                TextView tvHotWord = (TextView) ViewBindings.findChildViewById(rootView, id);
                                if (tvHotWord != null) {
                                    id = R.id.tv_tips;
                                    TextView tvTips = (TextView) ViewBindings.findChildViewById(rootView, id);
                                    if (tvTips != null) {
                                        return new BiliAppHotListWidgetBinding((RelativeLayout) rootView, background, brand, container, containerEntrances, containerSearch, exchange, tvHotWord, tvTips);
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