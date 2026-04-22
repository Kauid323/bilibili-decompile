package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.compose.ui.platform.ComposeView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import tv.danmaku.bili.R;

public final class BiliAppFragmentWatchLaterV3Binding implements ViewBinding {
    public final ComposeView composeView;
    private final FrameLayout rootView;

    private BiliAppFragmentWatchLaterV3Binding(FrameLayout rootView, ComposeView composeView) {
        this.rootView = rootView;
        this.composeView = composeView;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppFragmentWatchLaterV3Binding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppFragmentWatchLaterV3Binding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_fragment_watch_later_v3, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppFragmentWatchLaterV3Binding bind(View rootView) {
        int id = R.id.compose_view;
        ComposeView composeView = ViewBindings.findChildViewById(rootView, id);
        if (composeView != null) {
            return new BiliAppFragmentWatchLaterV3Binding((FrameLayout) rootView, composeView);
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}