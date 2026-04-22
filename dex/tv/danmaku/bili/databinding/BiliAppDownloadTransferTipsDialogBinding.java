package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import tv.danmaku.bili.R;

public final class BiliAppDownloadTransferTipsDialogBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final Button startTransfer;

    private BiliAppDownloadTransferTipsDialogBinding(LinearLayout rootView, Button startTransfer) {
        this.rootView = rootView;
        this.startTransfer = startTransfer;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppDownloadTransferTipsDialogBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppDownloadTransferTipsDialogBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_download_transfer_tips_dialog, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppDownloadTransferTipsDialogBinding bind(View rootView) {
        int id = R.id.start_transfer;
        Button startTransfer = (Button) ViewBindings.findChildViewById(rootView, id);
        if (startTransfer != null) {
            return new BiliAppDownloadTransferTipsDialogBinding((LinearLayout) rootView, startTransfer);
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}