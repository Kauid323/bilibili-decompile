package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.compose.ui.platform.ComposeView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bilibili.lib.image2.view.BiliImageView;
import tv.danmaku.bili.R;
import tv.danmaku.bili.ui.garb.view.MarqueeView;

public final class BiliAppDialogDigitalDetailViewBinding implements ViewBinding {
    public final MarqueeView marqueeView;
    public final FrameLayout nftCardAnimationContainer;
    public final View nftCardBottomArrow;
    public final FrameLayout nftCardBottomContainer;
    public final ConstraintLayout nftCardBottomDesc;
    public final FrameLayout nftCardBottomFloatContainer;
    public final LinearLayout nftCardBottomGroup;
    public final LinearLayout nftCardBottomMenuContainer;
    public final AppCompatTextView nftCardBottomName;
    public final AppCompatTextView nftCardBottomRatio;
    public final TextView nftCardExchangeLabel;
    public final FrameLayout nftCardIndexAboveContainer;
    public final RecyclerView nftCardList;
    public final ComposeView nftCardLockView;
    public final FrameLayout nftCardMultiViewContainer;
    public final LinearLayout nftCardNameGroup;
    public final ConstraintLayout nftCardSingleViewContainer;
    public final AppCompatImageView nftCardSoundSwitch;
    public final AppCompatImageView nftCardTopCancel;
    public final FrameLayout nftCardTopContainer;
    public final AppCompatTextView nftCardTopIndex;
    public final LinearLayout nftCardTopMenuContainer;
    public final BiliImageView nftCardsLightH;
    public final BiliImageView nftCardsLightV;
    public final ConstraintLayout nftCardsRootview;
    public final BiliImageView nftCardsTableH;
    public final BiliImageView nftCardsTableV;
    public final AppCompatTextView nftExtName;
    public final TextView rewardTag;
    private final ConstraintLayout rootView;
    public final LinearLayout trialLinkLayout;
    public final AppCompatTextView trialText;
    public final View viewNameLineLeft;
    public final View viewNameLineRight;

    private BiliAppDialogDigitalDetailViewBinding(ConstraintLayout rootView, MarqueeView marqueeView, FrameLayout nftCardAnimationContainer, View nftCardBottomArrow, FrameLayout nftCardBottomContainer, ConstraintLayout nftCardBottomDesc, FrameLayout nftCardBottomFloatContainer, LinearLayout nftCardBottomGroup, LinearLayout nftCardBottomMenuContainer, AppCompatTextView nftCardBottomName, AppCompatTextView nftCardBottomRatio, TextView nftCardExchangeLabel, FrameLayout nftCardIndexAboveContainer, RecyclerView nftCardList, ComposeView nftCardLockView, FrameLayout nftCardMultiViewContainer, LinearLayout nftCardNameGroup, ConstraintLayout nftCardSingleViewContainer, AppCompatImageView nftCardSoundSwitch, AppCompatImageView nftCardTopCancel, FrameLayout nftCardTopContainer, AppCompatTextView nftCardTopIndex, LinearLayout nftCardTopMenuContainer, BiliImageView nftCardsLightH, BiliImageView nftCardsLightV, ConstraintLayout nftCardsRootview, BiliImageView nftCardsTableH, BiliImageView nftCardsTableV, AppCompatTextView nftExtName, TextView rewardTag, LinearLayout trialLinkLayout, AppCompatTextView trialText, View viewNameLineLeft, View viewNameLineRight) {
        this.rootView = rootView;
        this.marqueeView = marqueeView;
        this.nftCardAnimationContainer = nftCardAnimationContainer;
        this.nftCardBottomArrow = nftCardBottomArrow;
        this.nftCardBottomContainer = nftCardBottomContainer;
        this.nftCardBottomDesc = nftCardBottomDesc;
        this.nftCardBottomFloatContainer = nftCardBottomFloatContainer;
        this.nftCardBottomGroup = nftCardBottomGroup;
        this.nftCardBottomMenuContainer = nftCardBottomMenuContainer;
        this.nftCardBottomName = nftCardBottomName;
        this.nftCardBottomRatio = nftCardBottomRatio;
        this.nftCardExchangeLabel = nftCardExchangeLabel;
        this.nftCardIndexAboveContainer = nftCardIndexAboveContainer;
        this.nftCardList = nftCardList;
        this.nftCardLockView = nftCardLockView;
        this.nftCardMultiViewContainer = nftCardMultiViewContainer;
        this.nftCardNameGroup = nftCardNameGroup;
        this.nftCardSingleViewContainer = nftCardSingleViewContainer;
        this.nftCardSoundSwitch = nftCardSoundSwitch;
        this.nftCardTopCancel = nftCardTopCancel;
        this.nftCardTopContainer = nftCardTopContainer;
        this.nftCardTopIndex = nftCardTopIndex;
        this.nftCardTopMenuContainer = nftCardTopMenuContainer;
        this.nftCardsLightH = nftCardsLightH;
        this.nftCardsLightV = nftCardsLightV;
        this.nftCardsRootview = nftCardsRootview;
        this.nftCardsTableH = nftCardsTableH;
        this.nftCardsTableV = nftCardsTableV;
        this.nftExtName = nftExtName;
        this.rewardTag = rewardTag;
        this.trialLinkLayout = trialLinkLayout;
        this.trialText = trialText;
        this.viewNameLineLeft = viewNameLineLeft;
        this.viewNameLineRight = viewNameLineRight;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppDialogDigitalDetailViewBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppDialogDigitalDetailViewBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_dialog_digital_detail_view, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppDialogDigitalDetailViewBinding bind(View rootView) {
        View nftCardBottomArrow;
        ConstraintLayout nftCardBottomDesc;
        AppCompatTextView nftCardBottomName;
        AppCompatTextView nftCardBottomRatio;
        RecyclerView nftCardList;
        ComposeView nftCardLockView;
        ConstraintLayout nftCardSingleViewContainer;
        AppCompatImageView nftCardSoundSwitch;
        AppCompatImageView nftCardTopCancel;
        AppCompatTextView nftCardTopIndex;
        BiliImageView nftCardsLightH;
        BiliImageView nftCardsLightV;
        BiliImageView nftCardsTableV;
        AppCompatTextView nftExtName;
        AppCompatTextView trialText;
        View viewNameLineLeft;
        View viewNameLineRight;
        int id = R.id.marqueeView;
        MarqueeView marqueeView = (MarqueeView) ViewBindings.findChildViewById(rootView, id);
        if (marqueeView != null) {
            id = R.id.nft_card_animation_container;
            FrameLayout nftCardAnimationContainer = (FrameLayout) ViewBindings.findChildViewById(rootView, id);
            if (nftCardAnimationContainer != null && (nftCardBottomArrow = ViewBindings.findChildViewById(rootView, (id = R.id.nft_card_bottom_arrow))) != null) {
                id = R.id.nft_card_bottom_container;
                FrameLayout nftCardBottomContainer = (FrameLayout) ViewBindings.findChildViewById(rootView, id);
                if (nftCardBottomContainer != null && (nftCardBottomDesc = ViewBindings.findChildViewById(rootView, (id = R.id.nft_card_bottom_desc))) != null) {
                    id = R.id.nft_card_bottom_float_container;
                    FrameLayout nftCardBottomFloatContainer = (FrameLayout) ViewBindings.findChildViewById(rootView, id);
                    if (nftCardBottomFloatContainer != null) {
                        id = R.id.nft_card_bottom_group;
                        LinearLayout nftCardBottomGroup = (LinearLayout) ViewBindings.findChildViewById(rootView, id);
                        if (nftCardBottomGroup != null) {
                            id = R.id.nft_card_bottom_menu_container;
                            LinearLayout nftCardBottomMenuContainer = (LinearLayout) ViewBindings.findChildViewById(rootView, id);
                            if (nftCardBottomMenuContainer != null && (nftCardBottomName = ViewBindings.findChildViewById(rootView, (id = R.id.nft_card_bottom_name))) != null && (nftCardBottomRatio = ViewBindings.findChildViewById(rootView, (id = R.id.nft_card_bottom_ratio))) != null) {
                                id = R.id.nft_card_exchange_label;
                                TextView nftCardExchangeLabel = (TextView) ViewBindings.findChildViewById(rootView, id);
                                if (nftCardExchangeLabel != null) {
                                    id = R.id.nft_card_index_above_container;
                                    FrameLayout nftCardIndexAboveContainer = (FrameLayout) ViewBindings.findChildViewById(rootView, id);
                                    if (nftCardIndexAboveContainer != null && (nftCardList = ViewBindings.findChildViewById(rootView, (id = R.id.nft_card_list))) != null && (nftCardLockView = ViewBindings.findChildViewById(rootView, (id = R.id.nft_card_lock_view))) != null) {
                                        id = R.id.nft_card_multi_view_container;
                                        FrameLayout nftCardMultiViewContainer = (FrameLayout) ViewBindings.findChildViewById(rootView, id);
                                        if (nftCardMultiViewContainer != null) {
                                            id = R.id.nft_card_name_group;
                                            LinearLayout nftCardNameGroup = (LinearLayout) ViewBindings.findChildViewById(rootView, id);
                                            if (nftCardNameGroup != null && (nftCardSingleViewContainer = ViewBindings.findChildViewById(rootView, (id = R.id.nft_card_single_view_container))) != null && (nftCardSoundSwitch = ViewBindings.findChildViewById(rootView, (id = R.id.nft_card_sound_switch))) != null && (nftCardTopCancel = ViewBindings.findChildViewById(rootView, (id = R.id.nft_card_top_cancel))) != null) {
                                                id = R.id.nft_card_top_container;
                                                FrameLayout nftCardTopContainer = (FrameLayout) ViewBindings.findChildViewById(rootView, id);
                                                if (nftCardTopContainer != null && (nftCardTopIndex = ViewBindings.findChildViewById(rootView, (id = R.id.nft_card_top_index))) != null) {
                                                    id = R.id.nft_card_top_menu_container;
                                                    LinearLayout nftCardTopMenuContainer = (LinearLayout) ViewBindings.findChildViewById(rootView, id);
                                                    if (nftCardTopMenuContainer != null && (nftCardsLightH = ViewBindings.findChildViewById(rootView, (id = R.id.nft_cards_light_h))) != null && (nftCardsLightV = ViewBindings.findChildViewById(rootView, (id = R.id.nft_cards_light_v))) != null) {
                                                        ConstraintLayout nftCardsRootview = (ConstraintLayout) rootView;
                                                        id = R.id.nft_cards_table_h;
                                                        BiliImageView nftCardsTableH = ViewBindings.findChildViewById(rootView, id);
                                                        if (nftCardsTableH != null && (nftCardsTableV = ViewBindings.findChildViewById(rootView, (id = R.id.nft_cards_table_v))) != null && (nftExtName = ViewBindings.findChildViewById(rootView, (id = R.id.nft_ext_name))) != null) {
                                                            id = R.id.reward_tag;
                                                            TextView rewardTag = (TextView) ViewBindings.findChildViewById(rootView, id);
                                                            if (rewardTag != null) {
                                                                id = R.id.trial_link_layout;
                                                                LinearLayout trialLinkLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, id);
                                                                if (trialLinkLayout != null && (trialText = ViewBindings.findChildViewById(rootView, (id = R.id.trial_text))) != null && (viewNameLineLeft = ViewBindings.findChildViewById(rootView, (id = R.id.view_name_line_left))) != null && (viewNameLineRight = ViewBindings.findChildViewById(rootView, (id = R.id.view_name_line_right))) != null) {
                                                                    return new BiliAppDialogDigitalDetailViewBinding((ConstraintLayout) rootView, marqueeView, nftCardAnimationContainer, nftCardBottomArrow, nftCardBottomContainer, nftCardBottomDesc, nftCardBottomFloatContainer, nftCardBottomGroup, nftCardBottomMenuContainer, nftCardBottomName, nftCardBottomRatio, nftCardExchangeLabel, nftCardIndexAboveContainer, nftCardList, nftCardLockView, nftCardMultiViewContainer, nftCardNameGroup, nftCardSingleViewContainer, nftCardSoundSwitch, nftCardTopCancel, nftCardTopContainer, nftCardTopIndex, nftCardTopMenuContainer, nftCardsLightH, nftCardsLightV, nftCardsRootview, nftCardsTableH, nftCardsTableV, nftExtName, rewardTag, trialLinkLayout, trialText, viewNameLineLeft, viewNameLineRight);
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
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}