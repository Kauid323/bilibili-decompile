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

public final class BiliIncludeWidgetListCardBinding implements ViewBinding {
    public final LinearLayout cardContainer;
    public final FrameLayout coverLayout;
    public final FrameLayout fillLayout1;
    public final FrameLayout fillLayout2;
    public final FrameLayout fillLayout3;
    public final ImageView ivCover;
    public final ImageView ivPlay;
    public final ImageView ivUpIcon;
    private final LinearLayout rootView;
    public final TextView tvName;
    public final TextView tvRcmdReason;
    public final TextView tvTitle1;
    public final TextView tvTitle2;
    public final TextView tvTitle3;
    public final TextView tvView;

    private BiliIncludeWidgetListCardBinding(LinearLayout rootView, LinearLayout cardContainer, FrameLayout coverLayout, FrameLayout fillLayout1, FrameLayout fillLayout2, FrameLayout fillLayout3, ImageView ivCover, ImageView ivPlay, ImageView ivUpIcon, TextView tvName, TextView tvRcmdReason, TextView tvTitle1, TextView tvTitle2, TextView tvTitle3, TextView tvView) {
        this.rootView = rootView;
        this.cardContainer = cardContainer;
        this.coverLayout = coverLayout;
        this.fillLayout1 = fillLayout1;
        this.fillLayout2 = fillLayout2;
        this.fillLayout3 = fillLayout3;
        this.ivCover = ivCover;
        this.ivPlay = ivPlay;
        this.ivUpIcon = ivUpIcon;
        this.tvName = tvName;
        this.tvRcmdReason = tvRcmdReason;
        this.tvTitle1 = tvTitle1;
        this.tvTitle2 = tvTitle2;
        this.tvTitle3 = tvTitle3;
        this.tvView = tvView;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static BiliIncludeWidgetListCardBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliIncludeWidgetListCardBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_include_widget_list_card, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliIncludeWidgetListCardBinding bind(View rootView) {
        LinearLayout cardContainer = (LinearLayout) rootView;
        int id = R.id.cover_layout;
        FrameLayout coverLayout = (FrameLayout) ViewBindings.findChildViewById(rootView, id);
        if (coverLayout != null) {
            id = R.id.fill_layout_1;
            FrameLayout fillLayout1 = (FrameLayout) ViewBindings.findChildViewById(rootView, id);
            if (fillLayout1 != null) {
                id = R.id.fill_layout_2;
                FrameLayout fillLayout2 = (FrameLayout) ViewBindings.findChildViewById(rootView, id);
                if (fillLayout2 != null) {
                    id = R.id.fill_layout_3;
                    FrameLayout fillLayout3 = (FrameLayout) ViewBindings.findChildViewById(rootView, id);
                    if (fillLayout3 != null) {
                        id = R.id.iv_cover;
                        ImageView ivCover = (ImageView) ViewBindings.findChildViewById(rootView, id);
                        if (ivCover != null) {
                            id = R.id.iv_play;
                            ImageView ivPlay = (ImageView) ViewBindings.findChildViewById(rootView, id);
                            if (ivPlay != null) {
                                id = R.id.iv_up_icon;
                                ImageView ivUpIcon = (ImageView) ViewBindings.findChildViewById(rootView, id);
                                if (ivUpIcon != null) {
                                    id = R.id.tv_name;
                                    TextView tvName = (TextView) ViewBindings.findChildViewById(rootView, id);
                                    if (tvName != null) {
                                        id = R.id.tv_rcmd_reason;
                                        TextView tvRcmdReason = (TextView) ViewBindings.findChildViewById(rootView, id);
                                        if (tvRcmdReason != null) {
                                            id = R.id.tv_title_1;
                                            TextView tvTitle1 = (TextView) ViewBindings.findChildViewById(rootView, id);
                                            if (tvTitle1 != null) {
                                                id = R.id.tv_title_2;
                                                TextView tvTitle2 = (TextView) ViewBindings.findChildViewById(rootView, id);
                                                if (tvTitle2 != null) {
                                                    id = R.id.tv_title_3;
                                                    TextView tvTitle3 = (TextView) ViewBindings.findChildViewById(rootView, id);
                                                    if (tvTitle3 != null) {
                                                        int id2 = R.id.tv_view;
                                                        TextView tvView = (TextView) ViewBindings.findChildViewById(rootView, id2);
                                                        if (tvView == null) {
                                                            id = id2;
                                                        } else {
                                                            return new BiliIncludeWidgetListCardBinding((LinearLayout) rootView, cardContainer, coverLayout, fillLayout1, fillLayout2, fillLayout3, ivCover, ivPlay, ivUpIcon, tvName, tvRcmdReason, tvTitle1, tvTitle2, tvTitle3, tvView);
                                                        }
                                                    }
                                                }
                                            }
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