package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import tv.danmaku.bili.R;

public final class BiliAppListHomeTopleftClickGuidanceBinding implements ViewBinding {
    public final View guideline;
    public final ImageView icon;
    public final TextView notice;
    private final ConstraintLayout rootView;

    private BiliAppListHomeTopleftClickGuidanceBinding(ConstraintLayout rootView, View guideline, ImageView icon, TextView notice) {
        this.rootView = rootView;
        this.guideline = guideline;
        this.icon = icon;
        this.notice = notice;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppListHomeTopleftClickGuidanceBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppListHomeTopleftClickGuidanceBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_list_home_topleft_click_guidance, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppListHomeTopleftClickGuidanceBinding bind(View rootView) {
        int id = R.id.guideline;
        View guideline = ViewBindings.findChildViewById(rootView, id);
        if (guideline != null) {
            id = R.id.icon;
            ImageView icon = (ImageView) ViewBindings.findChildViewById(rootView, id);
            if (icon != null) {
                id = R.id.notice;
                TextView notice = (TextView) ViewBindings.findChildViewById(rootView, id);
                if (notice != null) {
                    return new BiliAppListHomeTopleftClickGuidanceBinding((ConstraintLayout) rootView, guideline, icon, notice);
                }
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}