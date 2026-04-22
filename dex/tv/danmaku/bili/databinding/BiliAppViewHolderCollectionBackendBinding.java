package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bilibili.lib.image2.view.BiliImageView;
import tv.danmaku.bili.R;

public final class BiliAppViewHolderCollectionBackendBinding implements ViewBinding {
    public final ImageView iconRightArrow;
    public final BiliImageView nftCardBg;
    public final BiliImageView nftCardBottomIcon;
    public final BiliImageView nftCardCollectedFlag;
    public final ConstraintLayout nftCardContainer;
    public final BiliImageView nftCardImg;
    public final BiliImageView nftCardMask;
    public final BiliImageView nftCardMaskBackend;
    public final AppCompatTextView nftCardName;
    public final AppCompatTextView nftCardNo;
    public final LinearLayout nftCardNoContainer;
    public final AppCompatTextView nftCardNotice;
    public final LinearLayout nftCardNoticeContainer;
    private final ConstraintLayout rootView;

    private BiliAppViewHolderCollectionBackendBinding(ConstraintLayout rootView, ImageView iconRightArrow, BiliImageView nftCardBg, BiliImageView nftCardBottomIcon, BiliImageView nftCardCollectedFlag, ConstraintLayout nftCardContainer, BiliImageView nftCardImg, BiliImageView nftCardMask, BiliImageView nftCardMaskBackend, AppCompatTextView nftCardName, AppCompatTextView nftCardNo, LinearLayout nftCardNoContainer, AppCompatTextView nftCardNotice, LinearLayout nftCardNoticeContainer) {
        this.rootView = rootView;
        this.iconRightArrow = iconRightArrow;
        this.nftCardBg = nftCardBg;
        this.nftCardBottomIcon = nftCardBottomIcon;
        this.nftCardCollectedFlag = nftCardCollectedFlag;
        this.nftCardContainer = nftCardContainer;
        this.nftCardImg = nftCardImg;
        this.nftCardMask = nftCardMask;
        this.nftCardMaskBackend = nftCardMaskBackend;
        this.nftCardName = nftCardName;
        this.nftCardNo = nftCardNo;
        this.nftCardNoContainer = nftCardNoContainer;
        this.nftCardNotice = nftCardNotice;
        this.nftCardNoticeContainer = nftCardNoticeContainer;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppViewHolderCollectionBackendBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppViewHolderCollectionBackendBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_view_holder_collection_backend, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppViewHolderCollectionBackendBinding bind(View rootView) {
        BiliImageView nftCardBg;
        BiliImageView nftCardBottomIcon;
        BiliImageView nftCardCollectedFlag;
        ConstraintLayout nftCardContainer;
        BiliImageView nftCardImg;
        BiliImageView nftCardMask;
        BiliImageView nftCardMaskBackend;
        AppCompatTextView nftCardName;
        AppCompatTextView nftCardNo;
        AppCompatTextView nftCardNotice;
        int id = R.id.icon_right_arrow;
        ImageView iconRightArrow = (ImageView) ViewBindings.findChildViewById(rootView, id);
        if (iconRightArrow != null && (nftCardBg = ViewBindings.findChildViewById(rootView, (id = R.id.nft_card_bg))) != null && (nftCardBottomIcon = ViewBindings.findChildViewById(rootView, (id = R.id.nft_card_bottom_icon))) != null && (nftCardCollectedFlag = ViewBindings.findChildViewById(rootView, (id = R.id.nft_card_collected_flag))) != null && (nftCardContainer = ViewBindings.findChildViewById(rootView, (id = R.id.nft_card_container))) != null && (nftCardImg = ViewBindings.findChildViewById(rootView, (id = R.id.nft_card_img))) != null && (nftCardMask = ViewBindings.findChildViewById(rootView, (id = R.id.nft_card_mask))) != null && (nftCardMaskBackend = ViewBindings.findChildViewById(rootView, (id = R.id.nft_card_mask_backend))) != null && (nftCardName = ViewBindings.findChildViewById(rootView, (id = R.id.nft_card_name))) != null && (nftCardNo = ViewBindings.findChildViewById(rootView, (id = R.id.nft_card_no))) != null) {
            id = R.id.nft_card_no_container;
            LinearLayout nftCardNoContainer = (LinearLayout) ViewBindings.findChildViewById(rootView, id);
            if (nftCardNoContainer != null && (nftCardNotice = ViewBindings.findChildViewById(rootView, (id = R.id.nft_card_notice))) != null) {
                id = R.id.nft_card_notice_container;
                LinearLayout nftCardNoticeContainer = (LinearLayout) ViewBindings.findChildViewById(rootView, id);
                if (nftCardNoticeContainer != null) {
                    return new BiliAppViewHolderCollectionBackendBinding((ConstraintLayout) rootView, iconRightArrow, nftCardBg, nftCardBottomIcon, nftCardCollectedFlag, nftCardContainer, nftCardImg, nftCardMask, nftCardMaskBackend, nftCardName, nftCardNo, nftCardNoContainer, nftCardNotice, nftCardNoticeContainer);
                }
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}