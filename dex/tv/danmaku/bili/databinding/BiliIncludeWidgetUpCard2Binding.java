package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import tv.danmaku.bili.R;

public final class BiliIncludeWidgetUpCard2Binding implements ViewBinding {
    public final LinearLayout cardContainer;
    public final FrameLayout coverLayout;
    public final ImageView ivCover;
    public final ImageView ivUpIcon;
    private final LinearLayout rootView;
    public final TextView tvName;
    public final TextView tvTitle1;

    private BiliIncludeWidgetUpCard2Binding(LinearLayout rootView, LinearLayout cardContainer, FrameLayout coverLayout, ImageView ivCover, ImageView ivUpIcon, TextView tvName, TextView tvTitle1) {
        this.rootView = rootView;
        this.cardContainer = cardContainer;
        this.coverLayout = coverLayout;
        this.ivCover = ivCover;
        this.ivUpIcon = ivUpIcon;
        this.tvName = tvName;
        this.tvTitle1 = tvTitle1;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static BiliIncludeWidgetUpCard2Binding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliIncludeWidgetUpCard2Binding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_include_widget_up_card2, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliIncludeWidgetUpCard2Binding bind(View rootView) {
        LinearLayout cardContainer = (LinearLayout) rootView;
        int id = R.id.cover_layout;
        FrameLayout coverLayout = (FrameLayout) ViewBindings.findChildViewById(rootView, id);
        if (coverLayout != null) {
            id = R.id.iv_cover;
            ImageView ivCover = (ImageView) ViewBindings.findChildViewById(rootView, id);
            if (ivCover != null) {
                id = R.id.iv_up_icon;
                ImageView ivUpIcon = (ImageView) ViewBindings.findChildViewById(rootView, id);
                if (ivUpIcon != null) {
                    id = R.id.tv_name;
                    TextView tvName = (TextView) ViewBindings.findChildViewById(rootView, id);
                    if (tvName != null) {
                        int id2 = R.id.tv_title_1;
                        TextView tvTitle1 = (TextView) ViewBindings.findChildViewById(rootView, id2);
                        if (tvTitle1 == null) {
                            id = id2;
                        } else {
                            return new BiliIncludeWidgetUpCard2Binding((LinearLayout) rootView, cardContainer, coverLayout, ivCover, ivUpIcon, tvName, tvTitle1);
                        }
                    }
                }
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}