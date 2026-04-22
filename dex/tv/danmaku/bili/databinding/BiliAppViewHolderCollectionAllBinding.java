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

public final class BiliAppViewHolderCollectionAllBinding implements ViewBinding {
    public final AppCompatTextView badgeTitle;
    public final View collectionAllCardBottomBg;
    public final View collectionAllCardBottomBgMask;
    public final BiliImageView collectionAllCardBottomIcon;
    public final BiliImageView collectionAllCardCollectedFlag;
    public final ConstraintLayout collectionAllCardContainer;
    public final BiliImageView collectionAllCardImg;
    public final LinearLayout collectionAllCardNoContainer;
    public final LinearLayout collectionAllHeaderBadge;
    public final AppCompatTextView collectionAllHeaderCount;
    public final AppCompatTextView collectionAllHeaderName;
    public final AppCompatTextView collectionAllHeaderNo;
    public final ImageView iconRightArrow;
    private final ConstraintLayout rootView;

    private BiliAppViewHolderCollectionAllBinding(ConstraintLayout rootView, AppCompatTextView badgeTitle, View collectionAllCardBottomBg, View collectionAllCardBottomBgMask, BiliImageView collectionAllCardBottomIcon, BiliImageView collectionAllCardCollectedFlag, ConstraintLayout collectionAllCardContainer, BiliImageView collectionAllCardImg, LinearLayout collectionAllCardNoContainer, LinearLayout collectionAllHeaderBadge, AppCompatTextView collectionAllHeaderCount, AppCompatTextView collectionAllHeaderName, AppCompatTextView collectionAllHeaderNo, ImageView iconRightArrow) {
        this.rootView = rootView;
        this.badgeTitle = badgeTitle;
        this.collectionAllCardBottomBg = collectionAllCardBottomBg;
        this.collectionAllCardBottomBgMask = collectionAllCardBottomBgMask;
        this.collectionAllCardBottomIcon = collectionAllCardBottomIcon;
        this.collectionAllCardCollectedFlag = collectionAllCardCollectedFlag;
        this.collectionAllCardContainer = collectionAllCardContainer;
        this.collectionAllCardImg = collectionAllCardImg;
        this.collectionAllCardNoContainer = collectionAllCardNoContainer;
        this.collectionAllHeaderBadge = collectionAllHeaderBadge;
        this.collectionAllHeaderCount = collectionAllHeaderCount;
        this.collectionAllHeaderName = collectionAllHeaderName;
        this.collectionAllHeaderNo = collectionAllHeaderNo;
        this.iconRightArrow = iconRightArrow;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppViewHolderCollectionAllBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppViewHolderCollectionAllBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_view_holder_collection_all, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppViewHolderCollectionAllBinding bind(View rootView) {
        View collectionAllCardBottomBg;
        View collectionAllCardBottomBgMask;
        BiliImageView collectionAllCardBottomIcon;
        BiliImageView collectionAllCardCollectedFlag;
        AppCompatTextView collectionAllHeaderCount;
        AppCompatTextView collectionAllHeaderName;
        AppCompatTextView collectionAllHeaderNo;
        int id = R.id.badge_title;
        AppCompatTextView badgeTitle = ViewBindings.findChildViewById(rootView, id);
        if (badgeTitle != null && (collectionAllCardBottomBg = ViewBindings.findChildViewById(rootView, (id = R.id.collection_all_card_bottom_bg))) != null && (collectionAllCardBottomBgMask = ViewBindings.findChildViewById(rootView, (id = R.id.collection_all_card_bottom_bg_mask))) != null && (collectionAllCardBottomIcon = ViewBindings.findChildViewById(rootView, (id = R.id.collection_all_card_bottom_icon))) != null && (collectionAllCardCollectedFlag = ViewBindings.findChildViewById(rootView, (id = R.id.collection_all_card_collected_flag))) != null) {
            ConstraintLayout collectionAllCardContainer = (ConstraintLayout) rootView;
            id = R.id.collection_all_card_img;
            BiliImageView collectionAllCardImg = ViewBindings.findChildViewById(rootView, id);
            if (collectionAllCardImg != null) {
                id = R.id.collection_all_card_no_container;
                LinearLayout collectionAllCardNoContainer = (LinearLayout) ViewBindings.findChildViewById(rootView, id);
                if (collectionAllCardNoContainer != null) {
                    id = R.id.collection_all_header_badge;
                    LinearLayout collectionAllHeaderBadge = (LinearLayout) ViewBindings.findChildViewById(rootView, id);
                    if (collectionAllHeaderBadge != null && (collectionAllHeaderCount = ViewBindings.findChildViewById(rootView, (id = R.id.collection_all_header_count))) != null && (collectionAllHeaderName = ViewBindings.findChildViewById(rootView, (id = R.id.collection_all_header_name))) != null && (collectionAllHeaderNo = ViewBindings.findChildViewById(rootView, (id = R.id.collection_all_header_no))) != null) {
                        id = R.id.icon_right_arrow;
                        ImageView iconRightArrow = (ImageView) ViewBindings.findChildViewById(rootView, id);
                        if (iconRightArrow != null) {
                            return new BiliAppViewHolderCollectionAllBinding((ConstraintLayout) rootView, badgeTitle, collectionAllCardBottomBg, collectionAllCardBottomBgMask, collectionAllCardBottomIcon, collectionAllCardCollectedFlag, collectionAllCardContainer, collectionAllCardImg, collectionAllCardNoContainer, collectionAllHeaderBadge, collectionAllHeaderCount, collectionAllHeaderName, collectionAllHeaderNo, iconRightArrow);
                        }
                    }
                }
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}