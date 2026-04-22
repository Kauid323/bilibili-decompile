package tv.danmaku.bili.ui.splash.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import tv.danmaku.bili.ui.splash.R;

public final class EventSplashElementNickNameBinding implements ViewBinding {
    public final ImageView level;
    public final TextView nickname;
    private final LinearLayout rootView;

    private EventSplashElementNickNameBinding(LinearLayout rootView, ImageView level, TextView nickname) {
        this.rootView = rootView;
        this.level = level;
        this.nickname = nickname;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static EventSplashElementNickNameBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static EventSplashElementNickNameBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.event_splash_element_nick_name, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static EventSplashElementNickNameBinding bind(View rootView) {
        int id = R.id.level;
        ImageView level = (ImageView) ViewBindings.findChildViewById(rootView, id);
        if (level != null) {
            id = R.id.nickname;
            TextView nickname = (TextView) ViewBindings.findChildViewById(rootView, id);
            if (nickname != null) {
                return new EventSplashElementNickNameBinding((LinearLayout) rootView, level, nickname);
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}