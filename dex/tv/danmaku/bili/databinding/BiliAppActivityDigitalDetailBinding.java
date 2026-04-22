package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bilibili.lib.image2.view.BiliImageView;
import tv.danmaku.bili.R;
import tv.danmaku.bili.ui.garb.NftCardVideoRoundFrameLayout;

public final class BiliAppActivityDigitalDetailBinding implements ViewBinding {
    public final FrameLayout nftCardAnimationContainer;
    public final View nftCardBottomArrow;
    public final FrameLayout nftCardBottomContainer;
    public final ConstraintLayout nftCardBottomDesc;
    public final LinearLayout nftCardBottomGroup;
    public final AppCompatTextView nftCardBottomName;
    public final AppCompatTextView nftCardBottomRatio;
    public final TextView nftCardExchangeLabel;
    public final FrameLayout nftCardIndexAboveContainer;
    public final RecyclerView nftCardList;
    public final LinearLayout nftCardNameGroup;
    public final AppCompatImageView nftCardSoundSwitch;
    public final AppCompatTextView nftCardTopIndex;
    public final NftCardVideoRoundFrameLayout nftCardVideo;
    public final BiliImageView nftCardsLightH;
    public final BiliImageView nftCardsLightV;
    public final BiliImageView nftCardsTableH;
    public final BiliImageView nftCardsTableV;
    private final ConstraintLayout rootView;

    private BiliAppActivityDigitalDetailBinding(ConstraintLayout rootView, FrameLayout nftCardAnimationContainer, View nftCardBottomArrow, FrameLayout nftCardBottomContainer, ConstraintLayout nftCardBottomDesc, LinearLayout nftCardBottomGroup, AppCompatTextView nftCardBottomName, AppCompatTextView nftCardBottomRatio, TextView nftCardExchangeLabel, FrameLayout nftCardIndexAboveContainer, RecyclerView nftCardList, LinearLayout nftCardNameGroup, AppCompatImageView nftCardSoundSwitch, AppCompatTextView nftCardTopIndex, NftCardVideoRoundFrameLayout nftCardVideo, BiliImageView nftCardsLightH, BiliImageView nftCardsLightV, BiliImageView nftCardsTableH, BiliImageView nftCardsTableV) {
        this.rootView = rootView;
        this.nftCardAnimationContainer = nftCardAnimationContainer;
        this.nftCardBottomArrow = nftCardBottomArrow;
        this.nftCardBottomContainer = nftCardBottomContainer;
        this.nftCardBottomDesc = nftCardBottomDesc;
        this.nftCardBottomGroup = nftCardBottomGroup;
        this.nftCardBottomName = nftCardBottomName;
        this.nftCardBottomRatio = nftCardBottomRatio;
        this.nftCardExchangeLabel = nftCardExchangeLabel;
        this.nftCardIndexAboveContainer = nftCardIndexAboveContainer;
        this.nftCardList = nftCardList;
        this.nftCardNameGroup = nftCardNameGroup;
        this.nftCardSoundSwitch = nftCardSoundSwitch;
        this.nftCardTopIndex = nftCardTopIndex;
        this.nftCardVideo = nftCardVideo;
        this.nftCardsLightH = nftCardsLightH;
        this.nftCardsLightV = nftCardsLightV;
        this.nftCardsTableH = nftCardsTableH;
        this.nftCardsTableV = nftCardsTableV;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppActivityDigitalDetailBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppActivityDigitalDetailBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_activity_digital_detail, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppActivityDigitalDetailBinding bind(View rootView) {
        View nftCardBottomArrow;
        ConstraintLayout nftCardBottomDesc;
        AppCompatTextView nftCardBottomName;
        AppCompatTextView nftCardBottomRatio;
        RecyclerView nftCardList;
        AppCompatImageView nftCardSoundSwitch;
        AppCompatTextView nftCardTopIndex;
        BiliImageView nftCardsLightH;
        BiliImageView nftCardsLightV;
        BiliImageView nftCardsTableH;
        BiliImageView nftCardsTableV;
        int id = R.id.nft_card_animation_container;
        FrameLayout nftCardAnimationContainer = (FrameLayout) ViewBindings.findChildViewById(rootView, id);
        if (nftCardAnimationContainer != null && (nftCardBottomArrow = ViewBindings.findChildViewById(rootView, (id = R.id.nft_card_bottom_arrow))) != null) {
            id = R.id.nft_card_bottom_container;
            FrameLayout nftCardBottomContainer = (FrameLayout) ViewBindings.findChildViewById(rootView, id);
            if (nftCardBottomContainer != null && (nftCardBottomDesc = ViewBindings.findChildViewById(rootView, (id = R.id.nft_card_bottom_desc))) != null) {
                id = R.id.nft_card_bottom_group;
                LinearLayout nftCardBottomGroup = (LinearLayout) ViewBindings.findChildViewById(rootView, id);
                if (nftCardBottomGroup != null && (nftCardBottomName = ViewBindings.findChildViewById(rootView, (id = R.id.nft_card_bottom_name))) != null && (nftCardBottomRatio = ViewBindings.findChildViewById(rootView, (id = R.id.nft_card_bottom_ratio))) != null) {
                    id = R.id.nft_card_exchange_label;
                    TextView nftCardExchangeLabel = (TextView) ViewBindings.findChildViewById(rootView, id);
                    if (nftCardExchangeLabel != null) {
                        id = R.id.nft_card_index_above_container;
                        FrameLayout nftCardIndexAboveContainer = (FrameLayout) ViewBindings.findChildViewById(rootView, id);
                        if (nftCardIndexAboveContainer != null && (nftCardList = ViewBindings.findChildViewById(rootView, (id = R.id.nft_card_list))) != null) {
                            id = R.id.nft_card_name_group;
                            LinearLayout nftCardNameGroup = (LinearLayout) ViewBindings.findChildViewById(rootView, id);
                            if (nftCardNameGroup != null && (nftCardSoundSwitch = ViewBindings.findChildViewById(rootView, (id = R.id.nft_card_sound_switch))) != null && (nftCardTopIndex = ViewBindings.findChildViewById(rootView, (id = R.id.nft_card_top_index))) != null) {
                                id = R.id.nft_card_video;
                                NftCardVideoRoundFrameLayout nftCardVideo = (NftCardVideoRoundFrameLayout) ViewBindings.findChildViewById(rootView, id);
                                if (nftCardVideo != null && (nftCardsLightH = ViewBindings.findChildViewById(rootView, (id = R.id.nft_cards_light_h))) != null && (nftCardsLightV = ViewBindings.findChildViewById(rootView, (id = R.id.nft_cards_light_v))) != null && (nftCardsTableH = ViewBindings.findChildViewById(rootView, (id = R.id.nft_cards_table_h))) != null && (nftCardsTableV = ViewBindings.findChildViewById(rootView, (id = R.id.nft_cards_table_v))) != null) {
                                    return new BiliAppActivityDigitalDetailBinding((ConstraintLayout) rootView, nftCardAnimationContainer, nftCardBottomArrow, nftCardBottomContainer, nftCardBottomDesc, nftCardBottomGroup, nftCardBottomName, nftCardBottomRatio, nftCardExchangeLabel, nftCardIndexAboveContainer, nftCardList, nftCardNameGroup, nftCardSoundSwitch, nftCardTopIndex, nftCardVideo, nftCardsLightH, nftCardsLightV, nftCardsTableH, nftCardsTableV);
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