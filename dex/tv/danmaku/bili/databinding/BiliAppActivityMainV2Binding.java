package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import tv.danmaku.bili.R;

public final class BiliAppActivityMainV2Binding implements ViewBinding {
    public final FrameLayout contentLayout;
    public final FrameLayout drawer;
    public final FrameLayout previewLayout;
    private final FrameLayout rootView;
    public final FrameLayout splashLayout;

    private BiliAppActivityMainV2Binding(FrameLayout rootView, FrameLayout contentLayout, FrameLayout drawer, FrameLayout previewLayout, FrameLayout splashLayout) {
        this.rootView = rootView;
        this.contentLayout = contentLayout;
        this.drawer = drawer;
        this.previewLayout = previewLayout;
        this.splashLayout = splashLayout;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppActivityMainV2Binding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppActivityMainV2Binding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_activity_main_v2, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppActivityMainV2Binding bind(View rootView) {
        int id = R.id.content_layout;
        FrameLayout contentLayout = (FrameLayout) ViewBindings.findChildViewById(rootView, id);
        if (contentLayout != null) {
            FrameLayout drawer = (FrameLayout) rootView;
            id = R.id.preview_layout;
            FrameLayout previewLayout = (FrameLayout) ViewBindings.findChildViewById(rootView, id);
            if (previewLayout != null) {
                id = R.id.splash_layout;
                FrameLayout splashLayout = (FrameLayout) ViewBindings.findChildViewById(rootView, id);
                if (splashLayout != null) {
                    return new BiliAppActivityMainV2Binding((FrameLayout) rootView, contentLayout, drawer, previewLayout, splashLayout);
                }
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}