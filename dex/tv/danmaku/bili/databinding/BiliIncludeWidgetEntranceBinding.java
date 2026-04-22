package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import tv.danmaku.bili.R;

public final class BiliIncludeWidgetEntranceBinding implements ViewBinding {
    public final ImageView ivEntrance;
    public final LinearLayout llEntrance;
    private final LinearLayout rootView;
    public final TextView tvEntrance;

    private BiliIncludeWidgetEntranceBinding(LinearLayout rootView, ImageView ivEntrance, LinearLayout llEntrance, TextView tvEntrance) {
        this.rootView = rootView;
        this.ivEntrance = ivEntrance;
        this.llEntrance = llEntrance;
        this.tvEntrance = tvEntrance;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static BiliIncludeWidgetEntranceBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliIncludeWidgetEntranceBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_include_widget_entrance, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliIncludeWidgetEntranceBinding bind(View rootView) {
        int id = R.id.iv_entrance;
        ImageView ivEntrance = (ImageView) ViewBindings.findChildViewById(rootView, id);
        if (ivEntrance != null) {
            LinearLayout llEntrance = (LinearLayout) rootView;
            id = R.id.tv_entrance;
            TextView tvEntrance = (TextView) ViewBindings.findChildViewById(rootView, id);
            if (tvEntrance != null) {
                return new BiliIncludeWidgetEntranceBinding((LinearLayout) rootView, ivEntrance, llEntrance, tvEntrance);
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}