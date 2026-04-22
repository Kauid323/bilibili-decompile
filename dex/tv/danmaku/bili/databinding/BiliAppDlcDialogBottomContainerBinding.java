package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Placeholder;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bilibili.lib.image2.view.BiliImageView;
import tv.danmaku.bili.R;

public final class BiliAppDlcDialogBottomContainerBinding implements ViewBinding {
    public final ConstraintLayout containerBottomButton;
    public final ConstraintLayout containerBottomClose;
    public final AppCompatImageView ivBottomClose;
    public final BiliImageView ivDlcBottomButtonTag;
    public final Placeholder ivDlcBottomPlaceholder;
    public final AppCompatTextView ivDlcBottomView;
    private final ConstraintLayout rootView;

    private BiliAppDlcDialogBottomContainerBinding(ConstraintLayout rootView, ConstraintLayout containerBottomButton, ConstraintLayout containerBottomClose, AppCompatImageView ivBottomClose, BiliImageView ivDlcBottomButtonTag, Placeholder ivDlcBottomPlaceholder, AppCompatTextView ivDlcBottomView) {
        this.rootView = rootView;
        this.containerBottomButton = containerBottomButton;
        this.containerBottomClose = containerBottomClose;
        this.ivBottomClose = ivBottomClose;
        this.ivDlcBottomButtonTag = ivDlcBottomButtonTag;
        this.ivDlcBottomPlaceholder = ivDlcBottomPlaceholder;
        this.ivDlcBottomView = ivDlcBottomView;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppDlcDialogBottomContainerBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppDlcDialogBottomContainerBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_dlc_dialog_bottom_container, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppDlcDialogBottomContainerBinding bind(View rootView) {
        ConstraintLayout containerBottomClose;
        AppCompatImageView ivBottomClose;
        BiliImageView ivDlcBottomButtonTag;
        Placeholder ivDlcBottomPlaceholder;
        AppCompatTextView ivDlcBottomView;
        int id = R.id.container_bottom_button;
        ConstraintLayout containerBottomButton = ViewBindings.findChildViewById(rootView, id);
        if (containerBottomButton != null && (containerBottomClose = ViewBindings.findChildViewById(rootView, (id = R.id.container_bottom_close))) != null && (ivBottomClose = ViewBindings.findChildViewById(rootView, (id = R.id.iv_bottom_close))) != null && (ivDlcBottomButtonTag = ViewBindings.findChildViewById(rootView, (id = R.id.iv_dlc_bottom_button_tag))) != null && (ivDlcBottomPlaceholder = ViewBindings.findChildViewById(rootView, (id = R.id.iv_dlc_bottom_placeholder))) != null && (ivDlcBottomView = ViewBindings.findChildViewById(rootView, (id = R.id.iv_dlc_bottom_view))) != null) {
            return new BiliAppDlcDialogBottomContainerBinding((ConstraintLayout) rootView, containerBottomButton, containerBottomClose, ivBottomClose, ivDlcBottomButtonTag, ivDlcBottomPlaceholder, ivDlcBottomView);
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}