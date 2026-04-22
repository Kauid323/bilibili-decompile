package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import tv.danmaku.bili.R;

public final class BiliAppNftTransferDialogBinding implements ViewBinding {
    public final ImageView nftTransferClose;
    public final TextView nftTransferContent;
    public final TextView nftTransferIKnow;
    public final TextView nftTransferTitle;
    private final FrameLayout rootView;

    private BiliAppNftTransferDialogBinding(FrameLayout rootView, ImageView nftTransferClose, TextView nftTransferContent, TextView nftTransferIKnow, TextView nftTransferTitle) {
        this.rootView = rootView;
        this.nftTransferClose = nftTransferClose;
        this.nftTransferContent = nftTransferContent;
        this.nftTransferIKnow = nftTransferIKnow;
        this.nftTransferTitle = nftTransferTitle;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppNftTransferDialogBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppNftTransferDialogBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_nft_transfer_dialog, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppNftTransferDialogBinding bind(View rootView) {
        int id = R.id.nft_transfer_close;
        ImageView nftTransferClose = (ImageView) ViewBindings.findChildViewById(rootView, id);
        if (nftTransferClose != null) {
            id = R.id.nft_transfer_content;
            TextView nftTransferContent = (TextView) ViewBindings.findChildViewById(rootView, id);
            if (nftTransferContent != null) {
                id = R.id.nft_transfer_i_know;
                TextView nftTransferIKnow = (TextView) ViewBindings.findChildViewById(rootView, id);
                if (nftTransferIKnow != null) {
                    id = R.id.nft_transfer_title;
                    TextView nftTransferTitle = (TextView) ViewBindings.findChildViewById(rootView, id);
                    if (nftTransferTitle != null) {
                        return new BiliAppNftTransferDialogBinding((FrameLayout) rootView, nftTransferClose, nftTransferContent, nftTransferIKnow, nftTransferTitle);
                    }
                }
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}