package tv.danmaku.bili.ui.splash.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import tv.danmaku.bili.ui.splash.R;
import tv.danmaku.bili.widget.PendantAvatarFrameLayout;

public final class BiliAppFragmentUserSplashBinding implements ViewBinding {
    public final PendantAvatarFrameLayout avatar;
    public final ImageView background;
    public final ImageView level;
    public final ImageView logo;
    public final TextView nickname;
    public final ConstraintLayout rootContainer;
    private final ConstraintLayout rootView;
    public final TextView skip;
    public final LinearLayout textContainer;

    private BiliAppFragmentUserSplashBinding(ConstraintLayout rootView, PendantAvatarFrameLayout avatar, ImageView background, ImageView level, ImageView logo, TextView nickname, ConstraintLayout rootContainer, TextView skip, LinearLayout textContainer) {
        this.rootView = rootView;
        this.avatar = avatar;
        this.background = background;
        this.level = level;
        this.logo = logo;
        this.nickname = nickname;
        this.rootContainer = rootContainer;
        this.skip = skip;
        this.textContainer = textContainer;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppFragmentUserSplashBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppFragmentUserSplashBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_fragment_user_splash, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppFragmentUserSplashBinding bind(View rootView) {
        int id = R.id.avatar;
        PendantAvatarFrameLayout avatar = (PendantAvatarFrameLayout) ViewBindings.findChildViewById(rootView, id);
        if (avatar != null) {
            id = R.id.background;
            ImageView background = (ImageView) ViewBindings.findChildViewById(rootView, id);
            if (background != null) {
                id = R.id.level;
                ImageView level = (ImageView) ViewBindings.findChildViewById(rootView, id);
                if (level != null) {
                    id = R.id.logo;
                    ImageView logo = (ImageView) ViewBindings.findChildViewById(rootView, id);
                    if (logo != null) {
                        id = R.id.nickname;
                        TextView nickname = (TextView) ViewBindings.findChildViewById(rootView, id);
                        if (nickname != null) {
                            ConstraintLayout rootContainer = (ConstraintLayout) rootView;
                            id = R.id.skip;
                            TextView skip = (TextView) ViewBindings.findChildViewById(rootView, id);
                            if (skip != null) {
                                id = R.id.text_container;
                                LinearLayout textContainer = (LinearLayout) ViewBindings.findChildViewById(rootView, id);
                                if (textContainer != null) {
                                    return new BiliAppFragmentUserSplashBinding((ConstraintLayout) rootView, avatar, background, level, logo, nickname, rootContainer, skip, textContainer);
                                }
                            }
                        }
                    }
                }
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}