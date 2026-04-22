package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bilibili.app.common.gyroscope.view.GyroRoundedView;
import com.bilibili.lib.image2.view.BiliImageView;
import tv.danmaku.bili.R;
import tv.danmaku.bili.ui.garb.NftCardVideoRoundFrameLayout;

public final class BiliAppViewHolderNftCardForDetailBinding implements ViewBinding {
    public final BiliImageView badgeTopLeft;
    public final View nftCardBg;
    public final ConstraintLayout nftCardContainer;
    public final GyroRoundedView nftCardGyro;
    public final BiliImageView nftCardImg;
    public final View nftCardMask;
    public final NftCardVideoRoundFrameLayout nftCardVideo;
    private final FrameLayout rootView;
    public final BiliImageView stroke;

    private BiliAppViewHolderNftCardForDetailBinding(FrameLayout rootView, BiliImageView badgeTopLeft, View nftCardBg, ConstraintLayout nftCardContainer, GyroRoundedView nftCardGyro, BiliImageView nftCardImg, View nftCardMask, NftCardVideoRoundFrameLayout nftCardVideo, BiliImageView stroke) {
        this.rootView = rootView;
        this.badgeTopLeft = badgeTopLeft;
        this.nftCardBg = nftCardBg;
        this.nftCardContainer = nftCardContainer;
        this.nftCardGyro = nftCardGyro;
        this.nftCardImg = nftCardImg;
        this.nftCardMask = nftCardMask;
        this.nftCardVideo = nftCardVideo;
        this.stroke = stroke;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppViewHolderNftCardForDetailBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppViewHolderNftCardForDetailBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_view_holder_nft_card_for_detail, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppViewHolderNftCardForDetailBinding bind(View rootView) {
        View nftCardBg;
        ConstraintLayout nftCardContainer;
        GyroRoundedView nftCardGyro;
        BiliImageView nftCardImg;
        View nftCardMask;
        BiliImageView stroke;
        int id = R.id.badge_top_left;
        BiliImageView badgeTopLeft = ViewBindings.findChildViewById(rootView, id);
        if (badgeTopLeft != null && (nftCardBg = ViewBindings.findChildViewById(rootView, (id = R.id.nft_card_bg))) != null && (nftCardContainer = ViewBindings.findChildViewById(rootView, (id = R.id.nft_card_container))) != null && (nftCardGyro = ViewBindings.findChildViewById(rootView, (id = R.id.nft_card_gyro))) != null && (nftCardImg = ViewBindings.findChildViewById(rootView, (id = R.id.nft_card_img))) != null && (nftCardMask = ViewBindings.findChildViewById(rootView, (id = R.id.nft_card_mask))) != null) {
            id = R.id.nft_card_video;
            NftCardVideoRoundFrameLayout nftCardVideo = (NftCardVideoRoundFrameLayout) ViewBindings.findChildViewById(rootView, id);
            if (nftCardVideo != null && (stroke = ViewBindings.findChildViewById(rootView, (id = R.id.stroke))) != null) {
                return new BiliAppViewHolderNftCardForDetailBinding((FrameLayout) rootView, badgeTopLeft, nftCardBg, nftCardContainer, nftCardGyro, nftCardImg, nftCardMask, nftCardVideo, stroke);
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}