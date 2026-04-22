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

public final class BiliIncludeWidgetUpCard1Binding implements ViewBinding {
    public final ImageView avatar;
    public final TextView button;
    public final LinearLayout cardContainer;
    public final RelativeLayout coverLayout;
    public final TextView duration;
    public final ImageView ivCover;
    private final LinearLayout rootView;
    public final TextView tvName;
    public final TextView tvTitle2;
    public final TextView tvTitle3;
    public final LinearLayout upLayout;

    private BiliIncludeWidgetUpCard1Binding(LinearLayout rootView, ImageView avatar, TextView button, LinearLayout cardContainer, RelativeLayout coverLayout, TextView duration, ImageView ivCover, TextView tvName, TextView tvTitle2, TextView tvTitle3, LinearLayout upLayout) {
        this.rootView = rootView;
        this.avatar = avatar;
        this.button = button;
        this.cardContainer = cardContainer;
        this.coverLayout = coverLayout;
        this.duration = duration;
        this.ivCover = ivCover;
        this.tvName = tvName;
        this.tvTitle2 = tvTitle2;
        this.tvTitle3 = tvTitle3;
        this.upLayout = upLayout;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static BiliIncludeWidgetUpCard1Binding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliIncludeWidgetUpCard1Binding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_include_widget_up_card1, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliIncludeWidgetUpCard1Binding bind(View rootView) {
        int id = R.id.avatar;
        ImageView avatar = (ImageView) ViewBindings.findChildViewById(rootView, id);
        if (avatar != null) {
            id = R.id.button;
            TextView button = (TextView) ViewBindings.findChildViewById(rootView, id);
            if (button != null) {
                LinearLayout cardContainer = (LinearLayout) rootView;
                id = R.id.cover_layout;
                RelativeLayout coverLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, id);
                if (coverLayout != null) {
                    id = R.id.duration;
                    TextView duration = (TextView) ViewBindings.findChildViewById(rootView, id);
                    if (duration != null) {
                        id = R.id.iv_cover;
                        ImageView ivCover = (ImageView) ViewBindings.findChildViewById(rootView, id);
                        if (ivCover != null) {
                            id = R.id.tv_name;
                            TextView tvName = (TextView) ViewBindings.findChildViewById(rootView, id);
                            if (tvName != null) {
                                id = R.id.tv_title_2;
                                TextView tvTitle2 = (TextView) ViewBindings.findChildViewById(rootView, id);
                                if (tvTitle2 != null) {
                                    id = R.id.tv_title_3;
                                    TextView tvTitle3 = (TextView) ViewBindings.findChildViewById(rootView, id);
                                    if (tvTitle3 != null) {
                                        id = R.id.up_layout;
                                        LinearLayout upLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, id);
                                        if (upLayout != null) {
                                            return new BiliIncludeWidgetUpCard1Binding((LinearLayout) rootView, avatar, button, cardContainer, coverLayout, duration, ivCover, tvName, tvTitle2, tvTitle3, upLayout);
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