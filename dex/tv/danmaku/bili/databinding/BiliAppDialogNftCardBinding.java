package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bilibili.bililive.uam.view.UAMView;
import com.bilibili.lib.image2.view.BiliImageView;
import tv.danmaku.bili.R;
import tv.danmaku.bili.ui.garb.NftCardVideoRoundFrameLayout;

public final class BiliAppDialogNftCardBinding implements ViewBinding {
    public final View nftCardAnimMask;
    public final View nftCardAnimMask2;
    public final View nftCardBottomArrow;
    public final LinearLayout nftCardBottomButtonGroup;
    public final AppCompatImageView nftCardBottomClose;
    public final ConstraintLayout nftCardBottomDesc;
    public final AppCompatTextView nftCardBottomDraw;
    public final AppCompatTextView nftCardBottomDrawNumber;
    public final LinearLayout nftCardBottomGroup;
    public final AppCompatTextView nftCardBottomName;
    public final AppCompatTextView nftCardBottomRatio;
    public final AppCompatTextView nftCardBottomShare;
    public final LinearLayout nftCardCommentGroup;
    public final TextView nftCardExchangeLabel;
    public final View nftCardFakeView;
    public final RecyclerView nftCardList;
    public final LinearLayout nftCardMenuList;
    public final UAMView nftCardMp4Player;
    public final UAMView nftCardMp4Player2;
    public final LinearLayout nftCardNameGroup;
    public final AppCompatImageView nftCardSoundSwitch;
    public final AppCompatTextView nftCardTopIndex;
    public final AppCompatImageView nftCardTopMenu;
    public final NftCardVideoRoundFrameLayout nftCardVideo;
    public final BiliImageView nftCardsLightH;
    public final BiliImageView nftCardsLightV;
    public final BiliImageView nftCardsTableH;
    public final BiliImageView nftCardsTableV;
    private final ConstraintLayout rootView;

    private BiliAppDialogNftCardBinding(ConstraintLayout rootView, View nftCardAnimMask, View nftCardAnimMask2, View nftCardBottomArrow, LinearLayout nftCardBottomButtonGroup, AppCompatImageView nftCardBottomClose, ConstraintLayout nftCardBottomDesc, AppCompatTextView nftCardBottomDraw, AppCompatTextView nftCardBottomDrawNumber, LinearLayout nftCardBottomGroup, AppCompatTextView nftCardBottomName, AppCompatTextView nftCardBottomRatio, AppCompatTextView nftCardBottomShare, LinearLayout nftCardCommentGroup, TextView nftCardExchangeLabel, View nftCardFakeView, RecyclerView nftCardList, LinearLayout nftCardMenuList, UAMView nftCardMp4Player, UAMView nftCardMp4Player2, LinearLayout nftCardNameGroup, AppCompatImageView nftCardSoundSwitch, AppCompatTextView nftCardTopIndex, AppCompatImageView nftCardTopMenu, NftCardVideoRoundFrameLayout nftCardVideo, BiliImageView nftCardsLightH, BiliImageView nftCardsLightV, BiliImageView nftCardsTableH, BiliImageView nftCardsTableV) {
        this.rootView = rootView;
        this.nftCardAnimMask = nftCardAnimMask;
        this.nftCardAnimMask2 = nftCardAnimMask2;
        this.nftCardBottomArrow = nftCardBottomArrow;
        this.nftCardBottomButtonGroup = nftCardBottomButtonGroup;
        this.nftCardBottomClose = nftCardBottomClose;
        this.nftCardBottomDesc = nftCardBottomDesc;
        this.nftCardBottomDraw = nftCardBottomDraw;
        this.nftCardBottomDrawNumber = nftCardBottomDrawNumber;
        this.nftCardBottomGroup = nftCardBottomGroup;
        this.nftCardBottomName = nftCardBottomName;
        this.nftCardBottomRatio = nftCardBottomRatio;
        this.nftCardBottomShare = nftCardBottomShare;
        this.nftCardCommentGroup = nftCardCommentGroup;
        this.nftCardExchangeLabel = nftCardExchangeLabel;
        this.nftCardFakeView = nftCardFakeView;
        this.nftCardList = nftCardList;
        this.nftCardMenuList = nftCardMenuList;
        this.nftCardMp4Player = nftCardMp4Player;
        this.nftCardMp4Player2 = nftCardMp4Player2;
        this.nftCardNameGroup = nftCardNameGroup;
        this.nftCardSoundSwitch = nftCardSoundSwitch;
        this.nftCardTopIndex = nftCardTopIndex;
        this.nftCardTopMenu = nftCardTopMenu;
        this.nftCardVideo = nftCardVideo;
        this.nftCardsLightH = nftCardsLightH;
        this.nftCardsLightV = nftCardsLightV;
        this.nftCardsTableH = nftCardsTableH;
        this.nftCardsTableV = nftCardsTableV;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppDialogNftCardBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppDialogNftCardBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_dialog_nft_card, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppDialogNftCardBinding bind(View rootView) {
        View nftCardAnimMask2;
        View nftCardBottomArrow;
        AppCompatImageView nftCardBottomClose;
        ConstraintLayout nftCardBottomDesc;
        AppCompatTextView nftCardBottomDraw;
        AppCompatTextView nftCardBottomDrawNumber;
        AppCompatTextView nftCardBottomName;
        AppCompatTextView nftCardBottomRatio;
        AppCompatTextView nftCardBottomShare;
        View nftCardFakeView;
        RecyclerView nftCardList;
        UAMView nftCardMp4Player;
        UAMView nftCardMp4Player2;
        AppCompatImageView nftCardSoundSwitch;
        AppCompatTextView nftCardTopIndex;
        AppCompatImageView nftCardTopMenu;
        BiliImageView nftCardsLightH;
        BiliImageView nftCardsLightV;
        BiliImageView nftCardsTableH;
        BiliImageView nftCardsTableV;
        int id = R.id.nft_card_anim_mask;
        View nftCardAnimMask = ViewBindings.findChildViewById(rootView, id);
        if (nftCardAnimMask != null && (nftCardAnimMask2 = ViewBindings.findChildViewById(rootView, (id = R.id.nft_card_anim_mask_2))) != null && (nftCardBottomArrow = ViewBindings.findChildViewById(rootView, (id = R.id.nft_card_bottom_arrow))) != null) {
            id = R.id.nft_card_bottom_button_group;
            LinearLayout nftCardBottomButtonGroup = (LinearLayout) ViewBindings.findChildViewById(rootView, id);
            if (nftCardBottomButtonGroup != null && (nftCardBottomClose = ViewBindings.findChildViewById(rootView, (id = R.id.nft_card_bottom_close))) != null && (nftCardBottomDesc = ViewBindings.findChildViewById(rootView, (id = R.id.nft_card_bottom_desc))) != null && (nftCardBottomDraw = ViewBindings.findChildViewById(rootView, (id = R.id.nft_card_bottom_draw))) != null && (nftCardBottomDrawNumber = ViewBindings.findChildViewById(rootView, (id = R.id.nft_card_bottom_draw_number))) != null) {
                id = R.id.nft_card_bottom_group;
                LinearLayout nftCardBottomGroup = (LinearLayout) ViewBindings.findChildViewById(rootView, id);
                if (nftCardBottomGroup != null && (nftCardBottomName = ViewBindings.findChildViewById(rootView, (id = R.id.nft_card_bottom_name))) != null && (nftCardBottomRatio = ViewBindings.findChildViewById(rootView, (id = R.id.nft_card_bottom_ratio))) != null && (nftCardBottomShare = ViewBindings.findChildViewById(rootView, (id = R.id.nft_card_bottom_share))) != null) {
                    id = R.id.nft_card_comment_group;
                    LinearLayout nftCardCommentGroup = (LinearLayout) ViewBindings.findChildViewById(rootView, id);
                    if (nftCardCommentGroup != null) {
                        id = R.id.nft_card_exchange_label;
                        TextView nftCardExchangeLabel = (TextView) ViewBindings.findChildViewById(rootView, id);
                        if (nftCardExchangeLabel != null && (nftCardFakeView = ViewBindings.findChildViewById(rootView, (id = R.id.nft_card_fake_view))) != null && (nftCardList = ViewBindings.findChildViewById(rootView, (id = R.id.nft_card_list))) != null) {
                            id = R.id.nft_card_menu_list;
                            LinearLayout nftCardMenuList = (LinearLayout) ViewBindings.findChildViewById(rootView, id);
                            if (nftCardMenuList != null && (nftCardMp4Player = ViewBindings.findChildViewById(rootView, (id = R.id.nft_card_mp4_player))) != null && (nftCardMp4Player2 = ViewBindings.findChildViewById(rootView, (id = R.id.nft_card_mp4_player_2))) != null) {
                                id = R.id.nft_card_name_group;
                                LinearLayout nftCardNameGroup = (LinearLayout) ViewBindings.findChildViewById(rootView, id);
                                if (nftCardNameGroup != null && (nftCardSoundSwitch = ViewBindings.findChildViewById(rootView, (id = R.id.nft_card_sound_switch))) != null && (nftCardTopIndex = ViewBindings.findChildViewById(rootView, (id = R.id.nft_card_top_index))) != null && (nftCardTopMenu = ViewBindings.findChildViewById(rootView, (id = R.id.nft_card_top_menu))) != null) {
                                    id = R.id.nft_card_video;
                                    NftCardVideoRoundFrameLayout nftCardVideo = (NftCardVideoRoundFrameLayout) ViewBindings.findChildViewById(rootView, id);
                                    if (nftCardVideo != null && (nftCardsLightH = ViewBindings.findChildViewById(rootView, (id = R.id.nft_cards_light_h))) != null && (nftCardsLightV = ViewBindings.findChildViewById(rootView, (id = R.id.nft_cards_light_v))) != null && (nftCardsTableH = ViewBindings.findChildViewById(rootView, (id = R.id.nft_cards_table_h))) != null && (nftCardsTableV = ViewBindings.findChildViewById(rootView, (id = R.id.nft_cards_table_v))) != null) {
                                        return new BiliAppDialogNftCardBinding((ConstraintLayout) rootView, nftCardAnimMask, nftCardAnimMask2, nftCardBottomArrow, nftCardBottomButtonGroup, nftCardBottomClose, nftCardBottomDesc, nftCardBottomDraw, nftCardBottomDrawNumber, nftCardBottomGroup, nftCardBottomName, nftCardBottomRatio, nftCardBottomShare, nftCardCommentGroup, nftCardExchangeLabel, nftCardFakeView, nftCardList, nftCardMenuList, nftCardMp4Player, nftCardMp4Player2, nftCardNameGroup, nftCardSoundSwitch, nftCardTopIndex, nftCardTopMenu, nftCardVideo, nftCardsLightH, nftCardsLightV, nftCardsTableH, nftCardsTableV);
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