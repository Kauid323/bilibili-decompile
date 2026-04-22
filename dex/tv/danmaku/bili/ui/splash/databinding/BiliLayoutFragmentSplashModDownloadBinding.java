package tv.danmaku.bili.ui.splash.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bilibili.magicasakura.widgets.TintProgressBar;
import tv.danmaku.bili.ui.splash.R;

public final class BiliLayoutFragmentSplashModDownloadBinding implements ViewBinding {
    public final TextView downloadDesc;
    public final TintProgressBar downloadProgress;
    public final ImageView logo;
    private final LinearLayout rootView;

    private BiliLayoutFragmentSplashModDownloadBinding(LinearLayout rootView, TextView downloadDesc, TintProgressBar downloadProgress, ImageView logo) {
        this.rootView = rootView;
        this.downloadDesc = downloadDesc;
        this.downloadProgress = downloadProgress;
        this.logo = logo;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static BiliLayoutFragmentSplashModDownloadBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliLayoutFragmentSplashModDownloadBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_layout_fragment_splash_mod_download, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliLayoutFragmentSplashModDownloadBinding bind(View rootView) {
        TintProgressBar downloadProgress;
        int id = R.id.download_desc;
        TextView downloadDesc = (TextView) ViewBindings.findChildViewById(rootView, id);
        if (downloadDesc != null && (downloadProgress = ViewBindings.findChildViewById(rootView, (id = R.id.download_progress))) != null) {
            id = R.id.logo;
            ImageView logo = (ImageView) ViewBindings.findChildViewById(rootView, id);
            if (logo != null) {
                return new BiliLayoutFragmentSplashModDownloadBinding((LinearLayout) rootView, downloadDesc, downloadProgress, logo);
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}