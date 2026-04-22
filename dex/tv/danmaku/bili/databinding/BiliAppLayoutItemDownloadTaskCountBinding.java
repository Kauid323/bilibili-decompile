package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import tv.danmaku.bili.R;
import tv.danmaku.bili.widget.ForegroundRelativeLayout;

public final class BiliAppLayoutItemDownloadTaskCountBinding implements ViewBinding {
    public final View line;
    private final ForegroundRelativeLayout rootView;
    public final TextView text;
    public final ImageView tick;

    private BiliAppLayoutItemDownloadTaskCountBinding(ForegroundRelativeLayout rootView, View line, TextView text, ImageView tick) {
        this.rootView = rootView;
        this.line = line;
        this.text = text;
        this.tick = tick;
    }

    public ForegroundRelativeLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppLayoutItemDownloadTaskCountBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppLayoutItemDownloadTaskCountBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_layout_item_download_task_count, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppLayoutItemDownloadTaskCountBinding bind(View rootView) {
        int id = R.id.line;
        View line = ViewBindings.findChildViewById(rootView, id);
        if (line != null) {
            id = R.id.text;
            TextView text = (TextView) ViewBindings.findChildViewById(rootView, id);
            if (text != null) {
                id = R.id.tick;
                ImageView tick = (ImageView) ViewBindings.findChildViewById(rootView, id);
                if (tick != null) {
                    return new BiliAppLayoutItemDownloadTaskCountBinding((ForegroundRelativeLayout) rootView, line, text, tick);
                }
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}