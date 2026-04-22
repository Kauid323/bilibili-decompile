package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bilibili.lib.image2.view.BiliImageView;
import tv.danmaku.bili.R;

public final class BiliAppDialogDigitalDeteilMenuItemBinding implements ViewBinding {
    public final BiliImageView nftDetailMenuItemLimitedTag;
    public final TextView nftDetailMenuItemLimitedTitle;
    private final LinearLayoutCompat rootView;

    private BiliAppDialogDigitalDeteilMenuItemBinding(LinearLayoutCompat rootView, BiliImageView nftDetailMenuItemLimitedTag, TextView nftDetailMenuItemLimitedTitle) {
        this.rootView = rootView;
        this.nftDetailMenuItemLimitedTag = nftDetailMenuItemLimitedTag;
        this.nftDetailMenuItemLimitedTitle = nftDetailMenuItemLimitedTitle;
    }

    public LinearLayoutCompat getRoot() {
        return this.rootView;
    }

    public static BiliAppDialogDigitalDeteilMenuItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppDialogDigitalDeteilMenuItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_dialog_digital_deteil_menu_item, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppDialogDigitalDeteilMenuItemBinding bind(View rootView) {
        int id = R.id.nft_detail_menu_item_limited_tag;
        BiliImageView nftDetailMenuItemLimitedTag = ViewBindings.findChildViewById(rootView, id);
        if (nftDetailMenuItemLimitedTag != null) {
            id = R.id.nft_detail_menu_item_limited_title;
            TextView nftDetailMenuItemLimitedTitle = (TextView) ViewBindings.findChildViewById(rootView, id);
            if (nftDetailMenuItemLimitedTitle != null) {
                return new BiliAppDialogDigitalDeteilMenuItemBinding((LinearLayoutCompat) rootView, nftDetailMenuItemLimitedTag, nftDetailMenuItemLimitedTitle);
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}