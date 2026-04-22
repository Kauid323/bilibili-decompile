package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import tv.danmaku.bili.R;

public final class BiliAppDialogDigitalDetailRootBinding implements ViewBinding {
    private final FrameLayout rootView;

    private BiliAppDialogDigitalDetailRootBinding(FrameLayout rootView) {
        this.rootView = rootView;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppDialogDigitalDetailRootBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppDialogDigitalDetailRootBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_dialog_digital_detail_root, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppDialogDigitalDetailRootBinding bind(View rootView) {
        if (rootView == null) {
            throw new NullPointerException("rootView");
        }
        return new BiliAppDialogDigitalDetailRootBinding((FrameLayout) rootView);
    }
}