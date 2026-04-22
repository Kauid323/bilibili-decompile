package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bilibili.bililive.uam.view.UAMView;
import tv.danmaku.bili.R;

public final class BiliAppDialogDigitalCardAnimationBinding implements ViewBinding {
    public final View nftCardAnimMask;
    public final View nftCardAnimMask2;
    public final UAMView nftCardMp4Player;
    public final UAMView nftCardMp4Player2;
    private final ConstraintLayout rootView;

    private BiliAppDialogDigitalCardAnimationBinding(ConstraintLayout rootView, View nftCardAnimMask, View nftCardAnimMask2, UAMView nftCardMp4Player, UAMView nftCardMp4Player2) {
        this.rootView = rootView;
        this.nftCardAnimMask = nftCardAnimMask;
        this.nftCardAnimMask2 = nftCardAnimMask2;
        this.nftCardMp4Player = nftCardMp4Player;
        this.nftCardMp4Player2 = nftCardMp4Player2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppDialogDigitalCardAnimationBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppDialogDigitalCardAnimationBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_dialog_digital_card_animation, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppDialogDigitalCardAnimationBinding bind(View rootView) {
        View nftCardAnimMask2;
        UAMView nftCardMp4Player;
        UAMView nftCardMp4Player2;
        int id = R.id.nft_card_anim_mask;
        View nftCardAnimMask = ViewBindings.findChildViewById(rootView, id);
        if (nftCardAnimMask != null && (nftCardAnimMask2 = ViewBindings.findChildViewById(rootView, (id = R.id.nft_card_anim_mask_2))) != null && (nftCardMp4Player = ViewBindings.findChildViewById(rootView, (id = R.id.nft_card_mp4_player))) != null && (nftCardMp4Player2 = ViewBindings.findChildViewById(rootView, (id = R.id.nft_card_mp4_player_2))) != null) {
            return new BiliAppDialogDigitalCardAnimationBinding((ConstraintLayout) rootView, nftCardAnimMask, nftCardAnimMask2, nftCardMp4Player, nftCardMp4Player2);
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}