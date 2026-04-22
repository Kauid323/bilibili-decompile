package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bilibili.app.comm.bh.BiliWebView;
import tv.danmaku.bili.R;

public final class BiliAppActivityUserGrowDialogBinding implements ViewBinding {
    public final ImageView close;
    public final FrameLayout content;
    private final FrameLayout rootView;
    public final BiliWebView webview;

    private BiliAppActivityUserGrowDialogBinding(FrameLayout rootView, ImageView close, FrameLayout content, BiliWebView webview) {
        this.rootView = rootView;
        this.close = close;
        this.content = content;
        this.webview = webview;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppActivityUserGrowDialogBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppActivityUserGrowDialogBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_activity_user_grow_dialog, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppActivityUserGrowDialogBinding bind(View rootView) {
        int id = R.id.close;
        ImageView close = (ImageView) ViewBindings.findChildViewById(rootView, id);
        if (close != null) {
            FrameLayout content = (FrameLayout) rootView;
            id = R.id.webview;
            BiliWebView webview = ViewBindings.findChildViewById(rootView, id);
            if (webview != null) {
                return new BiliAppActivityUserGrowDialogBinding((FrameLayout) rootView, close, content, webview);
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}