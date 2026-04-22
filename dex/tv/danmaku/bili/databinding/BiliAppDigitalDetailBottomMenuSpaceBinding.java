package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import tv.danmaku.bili.R;

public final class BiliAppDigitalDetailBottomMenuSpaceBinding implements ViewBinding {
    private final View rootView;

    private BiliAppDigitalDetailBottomMenuSpaceBinding(View rootView) {
        this.rootView = rootView;
    }

    public View getRoot() {
        return this.rootView;
    }

    public static BiliAppDigitalDetailBottomMenuSpaceBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppDigitalDetailBottomMenuSpaceBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_digital_detail_bottom_menu_space, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppDigitalDetailBottomMenuSpaceBinding bind(View rootView) {
        if (rootView == null) {
            throw new NullPointerException("rootView");
        }
        return new BiliAppDigitalDetailBottomMenuSpaceBinding(rootView);
    }
}