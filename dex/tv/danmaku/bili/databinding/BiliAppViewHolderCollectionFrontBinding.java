package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bilibili.app.common.gyroscope.view.GyroRoundedView;
import com.bilibili.bililive.uam.view.UAMView;
import com.bilibili.lib.image2.view.BiliImageView;
import tv.danmaku.bili.R;
import tv.danmaku.bili.ui.garb.NftCardVideoRoundFrameLayout;

public final class BiliAppViewHolderCollectionFrontBinding implements ViewBinding {
    public final TextView debugText;
    public final ImageView iconRightArrow;
    public final FrameLayout musicNftCoverGroup;
    public final BiliImageView nftCardBadge;
    public final BiliImageView nftCardBg;
    public final BiliImageView nftCardBottomIcon;
    public final BiliImageView nftCardCollectedFlag;
    public final ConstraintLayout nftCardContainer;
    public final GyroRoundedView nftCardGyro;
    public final BiliImageView nftCardImg;
    public final BiliImageView nftCardMask;
    public final BiliImageView nftCardMaskBackend;
    public final AppCompatTextView nftCardName;
    public final AppCompatTextView nftCardNo;
    public final LinearLayout nftCardNoContainer;
    public final AppCompatTextView nftCardNotice;
    public final LinearLayout nftCardNoticeContainer;
    public final BiliImageView nftCardSmeltImg;
    public final UAMView nftCardSmeltVideo;
    public final NftCardVideoRoundFrameLayout nftCardVideo;
    public final ImageView nftHeaderVideoSound;
    private final ConstraintLayout rootView;

    private BiliAppViewHolderCollectionFrontBinding(ConstraintLayout rootView, TextView debugText, ImageView iconRightArrow, FrameLayout musicNftCoverGroup, BiliImageView nftCardBadge, BiliImageView nftCardBg, BiliImageView nftCardBottomIcon, BiliImageView nftCardCollectedFlag, ConstraintLayout nftCardContainer, GyroRoundedView nftCardGyro, BiliImageView nftCardImg, BiliImageView nftCardMask, BiliImageView nftCardMaskBackend, AppCompatTextView nftCardName, AppCompatTextView nftCardNo, LinearLayout nftCardNoContainer, AppCompatTextView nftCardNotice, LinearLayout nftCardNoticeContainer, BiliImageView nftCardSmeltImg, UAMView nftCardSmeltVideo, NftCardVideoRoundFrameLayout nftCardVideo, ImageView nftHeaderVideoSound) {
        this.rootView = rootView;
        this.debugText = debugText;
        this.iconRightArrow = iconRightArrow;
        this.musicNftCoverGroup = musicNftCoverGroup;
        this.nftCardBadge = nftCardBadge;
        this.nftCardBg = nftCardBg;
        this.nftCardBottomIcon = nftCardBottomIcon;
        this.nftCardCollectedFlag = nftCardCollectedFlag;
        this.nftCardContainer = nftCardContainer;
        this.nftCardGyro = nftCardGyro;
        this.nftCardImg = nftCardImg;
        this.nftCardMask = nftCardMask;
        this.nftCardMaskBackend = nftCardMaskBackend;
        this.nftCardName = nftCardName;
        this.nftCardNo = nftCardNo;
        this.nftCardNoContainer = nftCardNoContainer;
        this.nftCardNotice = nftCardNotice;
        this.nftCardNoticeContainer = nftCardNoticeContainer;
        this.nftCardSmeltImg = nftCardSmeltImg;
        this.nftCardSmeltVideo = nftCardSmeltVideo;
        this.nftCardVideo = nftCardVideo;
        this.nftHeaderVideoSound = nftHeaderVideoSound;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppViewHolderCollectionFrontBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppViewHolderCollectionFrontBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_view_holder_collection_front, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppViewHolderCollectionFrontBinding bind(View rootView) {
        BiliImageView nftCardBadge;
        BiliImageView nftCardBg;
        BiliImageView nftCardBottomIcon;
        BiliImageView nftCardCollectedFlag;
        ConstraintLayout nftCardContainer;
        GyroRoundedView nftCardGyro;
        BiliImageView nftCardImg;
        BiliImageView nftCardMask;
        BiliImageView nftCardMaskBackend;
        AppCompatTextView nftCardName;
        AppCompatTextView nftCardNo;
        AppCompatTextView nftCardNotice;
        BiliImageView nftCardSmeltImg;
        UAMView nftCardSmeltVideo;
        int id = R.id.debug_text;
        TextView debugText = (TextView) ViewBindings.findChildViewById(rootView, id);
        if (debugText != null) {
            id = R.id.icon_right_arrow;
            ImageView iconRightArrow = (ImageView) ViewBindings.findChildViewById(rootView, id);
            if (iconRightArrow != null) {
                id = R.id.music_nft_cover_group;
                FrameLayout musicNftCoverGroup = (FrameLayout) ViewBindings.findChildViewById(rootView, id);
                if (musicNftCoverGroup != null && (nftCardBadge = ViewBindings.findChildViewById(rootView, (id = R.id.nft_card_badge))) != null && (nftCardBg = ViewBindings.findChildViewById(rootView, (id = R.id.nft_card_bg))) != null && (nftCardBottomIcon = ViewBindings.findChildViewById(rootView, (id = R.id.nft_card_bottom_icon))) != null && (nftCardCollectedFlag = ViewBindings.findChildViewById(rootView, (id = R.id.nft_card_collected_flag))) != null && (nftCardContainer = ViewBindings.findChildViewById(rootView, (id = R.id.nft_card_container))) != null && (nftCardGyro = ViewBindings.findChildViewById(rootView, (id = R.id.nft_card_gyro))) != null && (nftCardImg = ViewBindings.findChildViewById(rootView, (id = R.id.nft_card_img))) != null && (nftCardMask = ViewBindings.findChildViewById(rootView, (id = R.id.nft_card_mask))) != null && (nftCardMaskBackend = ViewBindings.findChildViewById(rootView, (id = R.id.nft_card_mask_backend))) != null && (nftCardName = ViewBindings.findChildViewById(rootView, (id = R.id.nft_card_name))) != null && (nftCardNo = ViewBindings.findChildViewById(rootView, (id = R.id.nft_card_no))) != null) {
                    id = R.id.nft_card_no_container;
                    LinearLayout nftCardNoContainer = (LinearLayout) ViewBindings.findChildViewById(rootView, id);
                    if (nftCardNoContainer != null && (nftCardNotice = ViewBindings.findChildViewById(rootView, (id = R.id.nft_card_notice))) != null) {
                        id = R.id.nft_card_notice_container;
                        LinearLayout nftCardNoticeContainer = (LinearLayout) ViewBindings.findChildViewById(rootView, id);
                        if (nftCardNoticeContainer != null && (nftCardSmeltImg = ViewBindings.findChildViewById(rootView, (id = R.id.nft_card_smelt_img))) != null && (nftCardSmeltVideo = ViewBindings.findChildViewById(rootView, (id = R.id.nft_card_smelt_video))) != null) {
                            id = R.id.nft_card_video;
                            NftCardVideoRoundFrameLayout nftCardVideo = (NftCardVideoRoundFrameLayout) ViewBindings.findChildViewById(rootView, id);
                            if (nftCardVideo != null) {
                                id = R.id.nft_header_video_sound;
                                ImageView nftHeaderVideoSound = (ImageView) ViewBindings.findChildViewById(rootView, id);
                                if (nftHeaderVideoSound != null) {
                                    return new BiliAppViewHolderCollectionFrontBinding((ConstraintLayout) rootView, debugText, iconRightArrow, musicNftCoverGroup, nftCardBadge, nftCardBg, nftCardBottomIcon, nftCardCollectedFlag, nftCardContainer, nftCardGyro, nftCardImg, nftCardMask, nftCardMaskBackend, nftCardName, nftCardNo, nftCardNoContainer, nftCardNotice, nftCardNoticeContainer, nftCardSmeltImg, nftCardSmeltVideo, nftCardVideo, nftHeaderVideoSound);
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