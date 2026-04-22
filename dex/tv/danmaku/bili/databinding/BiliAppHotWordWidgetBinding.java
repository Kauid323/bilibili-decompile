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

public final class BiliAppHotWordWidgetBinding implements ViewBinding {
    public final LinearLayout background;
    public final ImageView brand;
    public final LinearLayout containerEntrances;
    public final LinearLayout containerSearch;
    private final RelativeLayout rootView;
    public final TextView tvHotWord;

    private BiliAppHotWordWidgetBinding(RelativeLayout rootView, LinearLayout background, ImageView brand, LinearLayout containerEntrances, LinearLayout containerSearch, TextView tvHotWord) {
        this.rootView = rootView;
        this.background = background;
        this.brand = brand;
        this.containerEntrances = containerEntrances;
        this.containerSearch = containerSearch;
        this.tvHotWord = tvHotWord;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppHotWordWidgetBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppHotWordWidgetBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_hot_word_widget, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppHotWordWidgetBinding bind(View rootView) {
        int id = 16908288;
        LinearLayout background = (LinearLayout) ViewBindings.findChildViewById(rootView, 16908288);
        if (background != null) {
            id = R.id.brand;
            ImageView brand = (ImageView) ViewBindings.findChildViewById(rootView, id);
            if (brand != null) {
                id = R.id.container_entrances;
                LinearLayout containerEntrances = (LinearLayout) ViewBindings.findChildViewById(rootView, id);
                if (containerEntrances != null) {
                    id = R.id.container_search;
                    LinearLayout containerSearch = (LinearLayout) ViewBindings.findChildViewById(rootView, id);
                    if (containerSearch != null) {
                        id = R.id.tv_hot_word;
                        TextView tvHotWord = (TextView) ViewBindings.findChildViewById(rootView, id);
                        if (tvHotWord != null) {
                            return new BiliAppHotWordWidgetBinding((RelativeLayout) rootView, background, brand, containerEntrances, containerSearch, tvHotWord);
                        }
                    }
                }
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}