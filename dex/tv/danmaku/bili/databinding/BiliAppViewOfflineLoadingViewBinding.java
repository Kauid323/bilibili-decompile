package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bilibili.magicasakura.widgets.TintProgressBar;
import tv.danmaku.bili.R;

public final class BiliAppViewOfflineLoadingViewBinding implements ViewBinding {
    public final ImageView image;
    public final TintProgressBar progressBar;
    private final View rootView;
    public final TextView text;

    private BiliAppViewOfflineLoadingViewBinding(View rootView, ImageView image, TintProgressBar progressBar, TextView text) {
        this.rootView = rootView;
        this.image = image;
        this.progressBar = progressBar;
        this.text = text;
    }

    public View getRoot() {
        return this.rootView;
    }

    public static BiliAppViewOfflineLoadingViewBinding inflate(LayoutInflater inflater, ViewGroup parent) {
        if (parent == null) {
            throw new NullPointerException("parent");
        }
        inflater.inflate(R.layout.bili_app_view_offline_loading_view, parent);
        return bind(parent);
    }

    public static BiliAppViewOfflineLoadingViewBinding bind(View rootView) {
        TintProgressBar progressBar;
        int id = R.id.image;
        ImageView image = (ImageView) ViewBindings.findChildViewById(rootView, id);
        if (image != null && (progressBar = ViewBindings.findChildViewById(rootView, (id = R.id.progress_bar))) != null) {
            id = R.id.text;
            TextView text = (TextView) ViewBindings.findChildViewById(rootView, id);
            if (text != null) {
                return new BiliAppViewOfflineLoadingViewBinding(rootView, image, progressBar, text);
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}