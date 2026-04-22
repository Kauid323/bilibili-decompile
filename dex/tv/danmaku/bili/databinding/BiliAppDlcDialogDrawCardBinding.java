package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.compose.ui.platform.ComposeView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bilibili.app.common.gyroscope.view.GyroRoundedView;
import com.bilibili.bililive.uam.view.UAMView;
import com.bilibili.lib.image2.view.BiliImageView;
import tv.danmaku.bili.R;
import tv.danmaku.bili.ui.garb.NftCardVideoRoundFrameLayout;

public final class BiliAppDlcDialogDrawCardBinding implements ViewBinding {
    public final BiliImageView bivBadge;
    public final BiliImageView bivFrameBolder;
    public final ConstraintLayout clDlcDrawCardLoading;
    public final ConstraintLayout clDlcDrawCardVideoAnim;
    public final ConstraintLayout flCardWrapper;
    public final NftCardVideoRoundFrameLayout flDlcDrawCardVideo;
    public final AppCompatImageView ivDlcCardSmeltTutorial;
    public final AppCompatImageView ivDlcDrawCardLoading;
    public final LinearLayout linNameWrapper;
    public final AppCompatTextView nftCardBottomName;
    public final ComposeView nftCardLockView;
    public final AppCompatTextView nftCardTopIndex;
    private final ConstraintLayout rootView;
    public final AppCompatTextView tvDlcDrawCardLoading;
    public final AppCompatTextView tvDlcDrawCardSkip;
    public final AppCompatTextView tvNextAction;
    public final UAMView uamDlcDrawCardEntry;
    public final UAMView uamDlcDrawCardPreload;
    public final GyroRoundedView viewDlcDrawCardGyro;
    public final BiliImageView viewDlcDrawCardVideoMask;

    private BiliAppDlcDialogDrawCardBinding(ConstraintLayout rootView, BiliImageView bivBadge, BiliImageView bivFrameBolder, ConstraintLayout clDlcDrawCardLoading, ConstraintLayout clDlcDrawCardVideoAnim, ConstraintLayout flCardWrapper, NftCardVideoRoundFrameLayout flDlcDrawCardVideo, AppCompatImageView ivDlcCardSmeltTutorial, AppCompatImageView ivDlcDrawCardLoading, LinearLayout linNameWrapper, AppCompatTextView nftCardBottomName, ComposeView nftCardLockView, AppCompatTextView nftCardTopIndex, AppCompatTextView tvDlcDrawCardLoading, AppCompatTextView tvDlcDrawCardSkip, AppCompatTextView tvNextAction, UAMView uamDlcDrawCardEntry, UAMView uamDlcDrawCardPreload, GyroRoundedView viewDlcDrawCardGyro, BiliImageView viewDlcDrawCardVideoMask) {
        this.rootView = rootView;
        this.bivBadge = bivBadge;
        this.bivFrameBolder = bivFrameBolder;
        this.clDlcDrawCardLoading = clDlcDrawCardLoading;
        this.clDlcDrawCardVideoAnim = clDlcDrawCardVideoAnim;
        this.flCardWrapper = flCardWrapper;
        this.flDlcDrawCardVideo = flDlcDrawCardVideo;
        this.ivDlcCardSmeltTutorial = ivDlcCardSmeltTutorial;
        this.ivDlcDrawCardLoading = ivDlcDrawCardLoading;
        this.linNameWrapper = linNameWrapper;
        this.nftCardBottomName = nftCardBottomName;
        this.nftCardLockView = nftCardLockView;
        this.nftCardTopIndex = nftCardTopIndex;
        this.tvDlcDrawCardLoading = tvDlcDrawCardLoading;
        this.tvDlcDrawCardSkip = tvDlcDrawCardSkip;
        this.tvNextAction = tvNextAction;
        this.uamDlcDrawCardEntry = uamDlcDrawCardEntry;
        this.uamDlcDrawCardPreload = uamDlcDrawCardPreload;
        this.viewDlcDrawCardGyro = viewDlcDrawCardGyro;
        this.viewDlcDrawCardVideoMask = viewDlcDrawCardVideoMask;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppDlcDialogDrawCardBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppDlcDialogDrawCardBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_dlc_dialog_draw_card, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppDlcDialogDrawCardBinding bind(View rootView) {
        BiliImageView bivFrameBolder;
        ConstraintLayout clDlcDrawCardLoading;
        ConstraintLayout clDlcDrawCardVideoAnim;
        ConstraintLayout flCardWrapper;
        AppCompatImageView ivDlcCardSmeltTutorial;
        AppCompatImageView ivDlcDrawCardLoading;
        AppCompatTextView nftCardBottomName;
        ComposeView nftCardLockView;
        AppCompatTextView nftCardTopIndex;
        AppCompatTextView tvDlcDrawCardLoading;
        AppCompatTextView tvDlcDrawCardSkip;
        AppCompatTextView tvNextAction;
        UAMView uamDlcDrawCardEntry;
        UAMView uamDlcDrawCardPreload;
        GyroRoundedView viewDlcDrawCardGyro;
        BiliImageView viewDlcDrawCardVideoMask;
        int id = R.id.bivBadge;
        BiliImageView bivBadge = ViewBindings.findChildViewById(rootView, id);
        if (bivBadge != null && (bivFrameBolder = ViewBindings.findChildViewById(rootView, (id = R.id.bivFrameBolder))) != null && (clDlcDrawCardLoading = ViewBindings.findChildViewById(rootView, (id = R.id.cl_dlc_draw_card_loading))) != null && (clDlcDrawCardVideoAnim = ViewBindings.findChildViewById(rootView, (id = R.id.cl_dlc_draw_card_video_anim))) != null && (flCardWrapper = ViewBindings.findChildViewById(rootView, (id = R.id.flCardWrapper))) != null) {
            id = R.id.fl_dlc_draw_card_video;
            NftCardVideoRoundFrameLayout flDlcDrawCardVideo = (NftCardVideoRoundFrameLayout) ViewBindings.findChildViewById(rootView, id);
            if (flDlcDrawCardVideo != null && (ivDlcCardSmeltTutorial = ViewBindings.findChildViewById(rootView, (id = R.id.iv_dlc_card_smelt_tutorial))) != null && (ivDlcDrawCardLoading = ViewBindings.findChildViewById(rootView, (id = R.id.iv_dlc_draw_card_loading))) != null) {
                id = R.id.linNameWrapper;
                LinearLayout linNameWrapper = (LinearLayout) ViewBindings.findChildViewById(rootView, id);
                if (linNameWrapper != null && (nftCardBottomName = ViewBindings.findChildViewById(rootView, (id = R.id.nft_card_bottom_name))) != null && (nftCardLockView = ViewBindings.findChildViewById(rootView, (id = R.id.nft_card_lock_view))) != null && (nftCardTopIndex = ViewBindings.findChildViewById(rootView, (id = R.id.nft_card_top_index))) != null && (tvDlcDrawCardLoading = ViewBindings.findChildViewById(rootView, (id = R.id.tv_dlc_draw_card_loading))) != null && (tvDlcDrawCardSkip = ViewBindings.findChildViewById(rootView, (id = R.id.tv_dlc_draw_card_skip))) != null && (tvNextAction = ViewBindings.findChildViewById(rootView, (id = R.id.tvNextAction))) != null && (uamDlcDrawCardEntry = ViewBindings.findChildViewById(rootView, (id = R.id.uam_dlc_draw_card_entry))) != null && (uamDlcDrawCardPreload = ViewBindings.findChildViewById(rootView, (id = R.id.uam_dlc_draw_card_preload))) != null && (viewDlcDrawCardGyro = ViewBindings.findChildViewById(rootView, (id = R.id.view_dlc_draw_card_gyro))) != null && (viewDlcDrawCardVideoMask = ViewBindings.findChildViewById(rootView, (id = R.id.view_dlc_draw_card_video_mask))) != null) {
                    return new BiliAppDlcDialogDrawCardBinding((ConstraintLayout) rootView, bivBadge, bivFrameBolder, clDlcDrawCardLoading, clDlcDrawCardVideoAnim, flCardWrapper, flDlcDrawCardVideo, ivDlcCardSmeltTutorial, ivDlcDrawCardLoading, linNameWrapper, nftCardBottomName, nftCardLockView, nftCardTopIndex, tvDlcDrawCardLoading, tvDlcDrawCardSkip, tvNextAction, uamDlcDrawCardEntry, uamDlcDrawCardPreload, viewDlcDrawCardGyro, viewDlcDrawCardVideoMask);
                }
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}