package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import tv.danmaku.bili.R;

public final class BiliAppDialogDigitalBottomMenuCancelBinding implements ViewBinding {
    public final TextView nftDetailMenuItemLimitedTitle;
    private final LinearLayoutCompat rootView;

    private BiliAppDialogDigitalBottomMenuCancelBinding(LinearLayoutCompat rootView, TextView nftDetailMenuItemLimitedTitle) {
        this.rootView = rootView;
        this.nftDetailMenuItemLimitedTitle = nftDetailMenuItemLimitedTitle;
    }

    public LinearLayoutCompat getRoot() {
        return this.rootView;
    }

    public static BiliAppDialogDigitalBottomMenuCancelBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppDialogDigitalBottomMenuCancelBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_dialog_digital_bottom_menu_cancel, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppDialogDigitalBottomMenuCancelBinding bind(View rootView) {
        int id = R.id.nft_detail_menu_item_limited_title;
        TextView nftDetailMenuItemLimitedTitle = (TextView) ViewBindings.findChildViewById(rootView, id);
        if (nftDetailMenuItemLimitedTitle != null) {
            return new BiliAppDialogDigitalBottomMenuCancelBinding((LinearLayoutCompat) rootView, nftDetailMenuItemLimitedTitle);
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}