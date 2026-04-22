package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bilibili.lib.homepage.widget.badge.NumberBadgeView;
import com.bilibili.magicasakura.widgets.TintTextView;
import tv.danmaku.bili.R;

public final class BiliAppLayoutVideoDownloadSheetUgcFixedViewBinding implements ViewBinding {
    public final NumberBadgeView badge;
    public final View dividerBottom;
    public final View dividerMiddle;
    public final TintTextView downloadAll;
    public final TintTextView downloadManager;
    public final RelativeLayout downloadManagerLayout;
    private final View rootView;
    public final TextView storage;

    private BiliAppLayoutVideoDownloadSheetUgcFixedViewBinding(View rootView, NumberBadgeView badge, View dividerBottom, View dividerMiddle, TintTextView downloadAll, TintTextView downloadManager, RelativeLayout downloadManagerLayout, TextView storage) {
        this.rootView = rootView;
        this.badge = badge;
        this.dividerBottom = dividerBottom;
        this.dividerMiddle = dividerMiddle;
        this.downloadAll = downloadAll;
        this.downloadManager = downloadManager;
        this.downloadManagerLayout = downloadManagerLayout;
        this.storage = storage;
    }

    public View getRoot() {
        return this.rootView;
    }

    public static BiliAppLayoutVideoDownloadSheetUgcFixedViewBinding inflate(LayoutInflater inflater, ViewGroup parent) {
        if (parent == null) {
            throw new NullPointerException("parent");
        }
        inflater.inflate(R.layout.bili_app_layout_video_download_sheet_ugc_fixed_view, parent);
        return bind(parent);
    }

    public static BiliAppLayoutVideoDownloadSheetUgcFixedViewBinding bind(View rootView) {
        View dividerBottom;
        View dividerMiddle;
        TintTextView downloadAll;
        TintTextView downloadManager;
        int id = R.id.badge;
        NumberBadgeView badge = ViewBindings.findChildViewById(rootView, id);
        if (badge != null && (dividerBottom = ViewBindings.findChildViewById(rootView, (id = R.id.divider_bottom))) != null && (dividerMiddle = ViewBindings.findChildViewById(rootView, (id = R.id.divider_middle))) != null && (downloadAll = ViewBindings.findChildViewById(rootView, (id = R.id.download_all))) != null && (downloadManager = ViewBindings.findChildViewById(rootView, (id = R.id.download_manager))) != null) {
            id = R.id.download_manager_layout;
            RelativeLayout downloadManagerLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, id);
            if (downloadManagerLayout != null) {
                int id2 = R.id.storage;
                TextView storage = (TextView) ViewBindings.findChildViewById(rootView, id2);
                if (storage == null) {
                    id = id2;
                } else {
                    return new BiliAppLayoutVideoDownloadSheetUgcFixedViewBinding(rootView, badge, dividerBottom, dividerMiddle, downloadAll, downloadManager, downloadManagerLayout, storage);
                }
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}