package tv.danmaku.bili.ui.splash.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import tv.danmaku.bili.ui.splash.R;
import tv.danmaku.bili.widget.PendantAvatarFrameLayout;

public final class BiliAppLayoutEventSplashRegisterBinding implements ViewBinding {
    public final PendantAvatarFrameLayout avatar;
    public final TextView content;
    public final ImageView level;
    public final TextView nickname;
    private final ConstraintLayout rootView;
    public final TextView title;

    private BiliAppLayoutEventSplashRegisterBinding(ConstraintLayout rootView, PendantAvatarFrameLayout avatar, TextView content, ImageView level, TextView nickname, TextView title) {
        this.rootView = rootView;
        this.avatar = avatar;
        this.content = content;
        this.level = level;
        this.nickname = nickname;
        this.title = title;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppLayoutEventSplashRegisterBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppLayoutEventSplashRegisterBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_layout_event_splash_register, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppLayoutEventSplashRegisterBinding bind(View rootView) {
        int id = R.id.avatar;
        PendantAvatarFrameLayout avatar = (PendantAvatarFrameLayout) ViewBindings.findChildViewById(rootView, id);
        if (avatar != null) {
            id = R.id.content;
            TextView content = (TextView) ViewBindings.findChildViewById(rootView, id);
            if (content != null) {
                id = R.id.level;
                ImageView level = (ImageView) ViewBindings.findChildViewById(rootView, id);
                if (level != null) {
                    id = R.id.nickname;
                    TextView nickname = (TextView) ViewBindings.findChildViewById(rootView, id);
                    if (nickname != null) {
                        id = R.id.title;
                        TextView title = (TextView) ViewBindings.findChildViewById(rootView, id);
                        if (title != null) {
                            return new BiliAppLayoutEventSplashRegisterBinding((ConstraintLayout) rootView, avatar, content, level, nickname, title);
                        }
                    }
                }
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}