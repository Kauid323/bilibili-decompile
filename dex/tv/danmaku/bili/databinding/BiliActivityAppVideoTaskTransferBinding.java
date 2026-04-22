package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bilibili.magicasakura.widgets.TintProgressBar;
import com.bilibili.magicasakura.widgets.TintToolbar;
import tv.danmaku.bili.R;

public final class BiliActivityAppVideoTaskTransferBinding implements ViewBinding {
    public final TextView close;
    public final ImageView image;
    public final TintToolbar navTopBar;
    public final TintProgressBar progress;
    public final TextView progressText;
    private final LinearLayout rootView;
    public final TextView tips;

    private BiliActivityAppVideoTaskTransferBinding(LinearLayout rootView, TextView close, ImageView image, TintToolbar navTopBar, TintProgressBar progress, TextView progressText, TextView tips) {
        this.rootView = rootView;
        this.close = close;
        this.image = image;
        this.navTopBar = navTopBar;
        this.progress = progress;
        this.progressText = progressText;
        this.tips = tips;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static BiliActivityAppVideoTaskTransferBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliActivityAppVideoTaskTransferBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_activity_app_video_task_transfer, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliActivityAppVideoTaskTransferBinding bind(View rootView) {
        TintToolbar navTopBar;
        TintProgressBar progress;
        int id = R.id.close;
        TextView close = (TextView) ViewBindings.findChildViewById(rootView, id);
        if (close != null) {
            id = R.id.image;
            ImageView image = (ImageView) ViewBindings.findChildViewById(rootView, id);
            if (image != null && (navTopBar = ViewBindings.findChildViewById(rootView, (id = R.id.nav_top_bar))) != null && (progress = ViewBindings.findChildViewById(rootView, (id = R.id.progress))) != null) {
                id = R.id.progress_text;
                TextView progressText = (TextView) ViewBindings.findChildViewById(rootView, id);
                if (progressText != null) {
                    id = R.id.tips;
                    TextView tips = (TextView) ViewBindings.findChildViewById(rootView, id);
                    if (tips != null) {
                        return new BiliActivityAppVideoTaskTransferBinding((LinearLayout) rootView, close, image, navTopBar, progress, progressText, tips);
                    }
                }
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}