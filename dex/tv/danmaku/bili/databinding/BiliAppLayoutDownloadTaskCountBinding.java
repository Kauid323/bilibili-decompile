package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bilibili.magicasakura.widgets.TintTextView;
import tv.danmaku.bili.R;

public final class BiliAppLayoutDownloadTaskCountBinding implements ViewBinding {
    public final TintTextView cancel;
    public final LinearLayout list;
    private final LinearLayout rootView;

    private BiliAppLayoutDownloadTaskCountBinding(LinearLayout rootView, TintTextView cancel, LinearLayout list) {
        this.rootView = rootView;
        this.cancel = cancel;
        this.list = list;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppLayoutDownloadTaskCountBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppLayoutDownloadTaskCountBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_layout_download_task_count, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppLayoutDownloadTaskCountBinding bind(View rootView) {
        int id = R.id.cancel;
        TintTextView cancel = ViewBindings.findChildViewById(rootView, id);
        if (cancel != null) {
            id = R.id.list;
            LinearLayout list = (LinearLayout) ViewBindings.findChildViewById(rootView, id);
            if (list != null) {
                return new BiliAppLayoutDownloadTaskCountBinding((LinearLayout) rootView, cancel, list);
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}