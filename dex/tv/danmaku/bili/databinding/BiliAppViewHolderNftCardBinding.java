package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bilibili.app.common.gyroscope.view.GyroRoundedView;
import com.bilibili.lib.image2.view.BiliImageView;
import tv.danmaku.bili.R;
import tv.danmaku.bili.ui.garb.NftCardVideoRoundFrameLayout;

public final class BiliAppViewHolderNftCardBinding implements ViewBinding {
    public final View nftCardBg;
    public final ConstraintLayout nftCardContainer;
    public final GyroRoundedView nftCardGyro;
    public final BiliImageView nftCardImg;
    public final View nftCardMask;
    public final NftCardVideoRoundFrameLayout nftCardVideo;
    private final ConstraintLayout rootView;

    private BiliAppViewHolderNftCardBinding(ConstraintLayout rootView, View nftCardBg, ConstraintLayout nftCardContainer, GyroRoundedView nftCardGyro, BiliImageView nftCardImg, View nftCardMask, NftCardVideoRoundFrameLayout nftCardVideo) {
        this.rootView = rootView;
        this.nftCardBg = nftCardBg;
        this.nftCardContainer = nftCardContainer;
        this.nftCardGyro = nftCardGyro;
        this.nftCardImg = nftCardImg;
        this.nftCardMask = nftCardMask;
        this.nftCardVideo = nftCardVideo;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppViewHolderNftCardBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppViewHolderNftCardBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_view_holder_nft_card, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppViewHolderNftCardBinding bind(View rootView) {
        BiliImageView nftCardImg;
        View nftCardMask;
        int id = R.id.nft_card_bg;
        View nftCardBg = ViewBindings.findChildViewById(rootView, id);
        if (nftCardBg != null) {
            ConstraintLayout nftCardContainer = (ConstraintLayout) rootView;
            id = R.id.nft_card_gyro;
            GyroRoundedView nftCardGyro = ViewBindings.findChildViewById(rootView, id);
            if (nftCardGyro != null && (nftCardImg = ViewBindings.findChildViewById(rootView, (id = R.id.nft_card_img))) != null && (nftCardMask = ViewBindings.findChildViewById(rootView, (id = R.id.nft_card_mask))) != null) {
                id = R.id.nft_card_video;
                NftCardVideoRoundFrameLayout nftCardVideo = (NftCardVideoRoundFrameLayout) ViewBindings.findChildViewById(rootView, id);
                if (nftCardVideo != null) {
                    return new BiliAppViewHolderNftCardBinding((ConstraintLayout) rootView, nftCardBg, nftCardContainer, nftCardGyro, nftCardImg, nftCardMask, nftCardVideo);
                }
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}