package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import tv.danmaku.bili.R;
import tv.danmaku.bili.widget.VectorTextView;

public final class BiliAppActivityOfflineDownloadingBinding implements ViewBinding {
    public final TextView batchButton;
    public final LinearLayout contentLayout;
    public final RecyclerView recycler;
    private final LinearLayout rootView;
    public final VectorTextView taskCount;

    private BiliAppActivityOfflineDownloadingBinding(LinearLayout rootView, TextView batchButton, LinearLayout contentLayout, RecyclerView recycler, VectorTextView taskCount) {
        this.rootView = rootView;
        this.batchButton = batchButton;
        this.contentLayout = contentLayout;
        this.recycler = recycler;
        this.taskCount = taskCount;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppActivityOfflineDownloadingBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppActivityOfflineDownloadingBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_activity_offline_downloading, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppActivityOfflineDownloadingBinding bind(View rootView) {
        VectorTextView taskCount;
        int id = R.id.batch_button;
        TextView batchButton = (TextView) ViewBindings.findChildViewById(rootView, id);
        if (batchButton != null) {
            LinearLayout contentLayout = (LinearLayout) rootView;
            id = R.id.recycler;
            RecyclerView recycler = ViewBindings.findChildViewById(rootView, id);
            if (recycler != null && (taskCount = ViewBindings.findChildViewById(rootView, (id = R.id.task_count))) != null) {
                return new BiliAppActivityOfflineDownloadingBinding((LinearLayout) rootView, batchButton, contentLayout, recycler, taskCount);
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}