package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.ui.platform.ComposeView;
import androidx.viewbinding.ViewBinding;
import tv.danmaku.bili.R;

public final class BiliLayoutMainUserCenterComposeBinding implements ViewBinding {
    public final ComposeView composeView;
    private final ComposeView rootView;

    private BiliLayoutMainUserCenterComposeBinding(ComposeView rootView, ComposeView composeView) {
        this.rootView = rootView;
        this.composeView = composeView;
    }

    public ComposeView getRoot() {
        return this.rootView;
    }

    public static BiliLayoutMainUserCenterComposeBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliLayoutMainUserCenterComposeBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_layout_main_user_center_compose, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliLayoutMainUserCenterComposeBinding bind(View rootView) {
        if (rootView == null) {
            throw new NullPointerException("rootView");
        }
        ComposeView composeView = (ComposeView) rootView;
        return new BiliLayoutMainUserCenterComposeBinding((ComposeView) rootView, composeView);
    }
}