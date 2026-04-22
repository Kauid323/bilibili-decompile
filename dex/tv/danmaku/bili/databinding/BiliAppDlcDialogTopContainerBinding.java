package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import tv.danmaku.bili.R;

public final class BiliAppDlcDialogTopContainerBinding implements ViewBinding {
    public final ConstraintLayout clDlcCardResultFullTop;
    public final AppCompatImageView ivDlcCardBack;
    public final LinearLayout ivDlcCardMenuList;
    public final AppCompatImageView ivDlcCardMore;
    public final AppCompatImageView ivDlcCardShare;
    public final AppCompatImageView ivDlcCardSmeltTutorial;
    private final ConstraintLayout rootView;

    private BiliAppDlcDialogTopContainerBinding(ConstraintLayout rootView, ConstraintLayout clDlcCardResultFullTop, AppCompatImageView ivDlcCardBack, LinearLayout ivDlcCardMenuList, AppCompatImageView ivDlcCardMore, AppCompatImageView ivDlcCardShare, AppCompatImageView ivDlcCardSmeltTutorial) {
        this.rootView = rootView;
        this.clDlcCardResultFullTop = clDlcCardResultFullTop;
        this.ivDlcCardBack = ivDlcCardBack;
        this.ivDlcCardMenuList = ivDlcCardMenuList;
        this.ivDlcCardMore = ivDlcCardMore;
        this.ivDlcCardShare = ivDlcCardShare;
        this.ivDlcCardSmeltTutorial = ivDlcCardSmeltTutorial;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppDlcDialogTopContainerBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppDlcDialogTopContainerBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_dlc_dialog_top_container, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppDlcDialogTopContainerBinding bind(View rootView) {
        AppCompatImageView ivDlcCardMore;
        AppCompatImageView ivDlcCardShare;
        ConstraintLayout clDlcCardResultFullTop = (ConstraintLayout) rootView;
        int id = R.id.iv_dlc_card_back;
        AppCompatImageView ivDlcCardBack = ViewBindings.findChildViewById(rootView, id);
        if (ivDlcCardBack != null) {
            id = R.id.iv_dlc_card_menu_list;
            LinearLayout ivDlcCardMenuList = (LinearLayout) ViewBindings.findChildViewById(rootView, id);
            if (ivDlcCardMenuList != null && (ivDlcCardMore = ViewBindings.findChildViewById(rootView, (id = R.id.iv_dlc_card_more))) != null && (ivDlcCardShare = ViewBindings.findChildViewById(rootView, (id = R.id.iv_dlc_card_share))) != null) {
                int id2 = R.id.iv_dlc_card_smelt_tutorial;
                AppCompatImageView ivDlcCardSmeltTutorial = ViewBindings.findChildViewById(rootView, id2);
                if (ivDlcCardSmeltTutorial == null) {
                    id = id2;
                } else {
                    return new BiliAppDlcDialogTopContainerBinding((ConstraintLayout) rootView, clDlcCardResultFullTop, ivDlcCardBack, ivDlcCardMenuList, ivDlcCardMore, ivDlcCardShare, ivDlcCardSmeltTutorial);
                }
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}