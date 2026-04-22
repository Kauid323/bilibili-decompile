package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import tv.danmaku.bili.R;

public final class BiliAppActivityOfflineDownloadedVideoBinding implements ViewBinding {
    public final LinearLayout contentLayout;
    public final RecyclerView recycler;
    private final LinearLayout rootView;

    private BiliAppActivityOfflineDownloadedVideoBinding(LinearLayout rootView, LinearLayout contentLayout, RecyclerView recycler) {
        this.rootView = rootView;
        this.contentLayout = contentLayout;
        this.recycler = recycler;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppActivityOfflineDownloadedVideoBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppActivityOfflineDownloadedVideoBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_activity_offline_downloaded_video, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppActivityOfflineDownloadedVideoBinding bind(View rootView) {
        LinearLayout contentLayout = (LinearLayout) rootView;
        int id = R.id.recycler;
        RecyclerView recycler = ViewBindings.findChildViewById(rootView, id);
        if (recycler != null) {
            return new BiliAppActivityOfflineDownloadedVideoBinding((LinearLayout) rootView, contentLayout, recycler);
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}