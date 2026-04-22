package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import tv.danmaku.bili.R;

public final class BiliAppDialogDigitalCardTopBinding implements ViewBinding {
    public final AppCompatImageView nftCardBottomClose;
    public final AppCompatTextView nftCardTopLink;
    public final View nftCardTopLinkArrow;
    private final ConstraintLayout rootView;

    private BiliAppDialogDigitalCardTopBinding(ConstraintLayout rootView, AppCompatImageView nftCardBottomClose, AppCompatTextView nftCardTopLink, View nftCardTopLinkArrow) {
        this.rootView = rootView;
        this.nftCardBottomClose = nftCardBottomClose;
        this.nftCardTopLink = nftCardTopLink;
        this.nftCardTopLinkArrow = nftCardTopLinkArrow;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppDialogDigitalCardTopBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppDialogDigitalCardTopBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_dialog_digital_card_top, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppDialogDigitalCardTopBinding bind(View rootView) {
        AppCompatTextView nftCardTopLink;
        View nftCardTopLinkArrow;
        int id = R.id.nft_card_bottom_close;
        AppCompatImageView nftCardBottomClose = ViewBindings.findChildViewById(rootView, id);
        if (nftCardBottomClose != null && (nftCardTopLink = ViewBindings.findChildViewById(rootView, (id = R.id.nft_card_top_link))) != null && (nftCardTopLinkArrow = ViewBindings.findChildViewById(rootView, (id = R.id.nft_card_top_link_arrow))) != null) {
            return new BiliAppDialogDigitalCardTopBinding((ConstraintLayout) rootView, nftCardBottomClose, nftCardTopLink, nftCardTopLinkArrow);
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}