package tv.danmaku.bili.ui.splash.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import tv.danmaku.bili.ui.splash.R;
import tv.danmaku.bili.widget.PendantAvatarFrameLayout;

public final class EventSplashElementAvatarBinding implements ViewBinding {
    public final PendantAvatarFrameLayout avatar;
    private final PendantAvatarFrameLayout rootView;

    private EventSplashElementAvatarBinding(PendantAvatarFrameLayout rootView, PendantAvatarFrameLayout avatar) {
        this.rootView = rootView;
        this.avatar = avatar;
    }

    public PendantAvatarFrameLayout getRoot() {
        return this.rootView;
    }

    public static EventSplashElementAvatarBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static EventSplashElementAvatarBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.event_splash_element_avatar, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static EventSplashElementAvatarBinding bind(View rootView) {
        if (rootView == null) {
            throw new NullPointerException("rootView");
        }
        PendantAvatarFrameLayout avatar = (PendantAvatarFrameLayout) rootView;
        return new EventSplashElementAvatarBinding((PendantAvatarFrameLayout) rootView, avatar);
    }
}