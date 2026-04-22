package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bilibili.app.comm.bh.BiliWebView;
import com.bilibili.magicasakura.widgets.TintFrameLayout;
import com.bilibili.magicasakura.widgets.TintProgressBar;
import tv.danmaku.bili.R;

public final class BiliAppActivityThemeStoreWebContainerBinding implements ViewBinding {
    public final TintFrameLayout contentFrame;
    public final TintProgressBar progressHorizontal;
    private final View rootView;
    public final BiliWebView webview;

    private BiliAppActivityThemeStoreWebContainerBinding(View rootView, TintFrameLayout contentFrame, TintProgressBar progressHorizontal, BiliWebView webview) {
        this.rootView = rootView;
        this.contentFrame = contentFrame;
        this.progressHorizontal = progressHorizontal;
        this.webview = webview;
    }

    public View getRoot() {
        return this.rootView;
    }

    public static BiliAppActivityThemeStoreWebContainerBinding inflate(LayoutInflater inflater, ViewGroup parent) {
        if (parent == null) {
            throw new NullPointerException("parent");
        }
        inflater.inflate(R.layout.bili_app_activity_theme_store_web_container, parent);
        return bind(parent);
    }

    public static BiliAppActivityThemeStoreWebContainerBinding bind(View rootView) {
        TintProgressBar progressHorizontal;
        BiliWebView webview;
        int id = R.id.content_frame;
        TintFrameLayout contentFrame = ViewBindings.findChildViewById(rootView, id);
        if (contentFrame != null && (progressHorizontal = ViewBindings.findChildViewById(rootView, (id = R.id.progress_horizontal))) != null && (webview = ViewBindings.findChildViewById(rootView, (id = R.id.webview))) != null) {
            return new BiliAppActivityThemeStoreWebContainerBinding(rootView, contentFrame, progressHorizontal, webview);
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}