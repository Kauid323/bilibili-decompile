package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.bilibili.lib.image2.view.BiliImageView;
import com.bilibili.magicasakura.widgets.TintTextView;
import tv.danmaku.bili.R;
import tv.danmaku.bili.widget.avatar.LivingAvatarAnimationView;

public final class BiliAppLayoutAppInnerPushLiveAvatarBinding implements ViewBinding {
    public final LivingAvatarAnimationView innerPushLiveAnimation1;
    public final LivingAvatarAnimationView innerPushLiveAnimation2;
    public final BiliImageView innerPushLiveAvatar;
    public final FrameLayout innerPushLiveAvatarContainer;
    public final LottieAnimationView innerPushLiveTagAnimation;
    public final View innerPushLiveTagBackground;
    public final Group innerPushLiveTagGroup;
    public final TintTextView innerPushLiveTagText;
    public final Group innerPushLiveWaveGroup;
    public final ConstraintLayout liveIcon;
    private final ConstraintLayout rootView;

    private BiliAppLayoutAppInnerPushLiveAvatarBinding(ConstraintLayout rootView, LivingAvatarAnimationView innerPushLiveAnimation1, LivingAvatarAnimationView innerPushLiveAnimation2, BiliImageView innerPushLiveAvatar, FrameLayout innerPushLiveAvatarContainer, LottieAnimationView innerPushLiveTagAnimation, View innerPushLiveTagBackground, Group innerPushLiveTagGroup, TintTextView innerPushLiveTagText, Group innerPushLiveWaveGroup, ConstraintLayout liveIcon) {
        this.rootView = rootView;
        this.innerPushLiveAnimation1 = innerPushLiveAnimation1;
        this.innerPushLiveAnimation2 = innerPushLiveAnimation2;
        this.innerPushLiveAvatar = innerPushLiveAvatar;
        this.innerPushLiveAvatarContainer = innerPushLiveAvatarContainer;
        this.innerPushLiveTagAnimation = innerPushLiveTagAnimation;
        this.innerPushLiveTagBackground = innerPushLiveTagBackground;
        this.innerPushLiveTagGroup = innerPushLiveTagGroup;
        this.innerPushLiveTagText = innerPushLiveTagText;
        this.innerPushLiveWaveGroup = innerPushLiveWaveGroup;
        this.liveIcon = liveIcon;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppLayoutAppInnerPushLiveAvatarBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppLayoutAppInnerPushLiveAvatarBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_layout_app_inner_push_live_avatar, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppLayoutAppInnerPushLiveAvatarBinding bind(View rootView) {
        LivingAvatarAnimationView innerPushLiveAnimation2;
        BiliImageView innerPushLiveAvatar;
        LottieAnimationView innerPushLiveTagAnimation;
        View innerPushLiveTagBackground;
        Group innerPushLiveTagGroup;
        TintTextView innerPushLiveTagText;
        Group innerPushLiveWaveGroup;
        int id = R.id.inner_push_live_animation1;
        LivingAvatarAnimationView innerPushLiveAnimation1 = ViewBindings.findChildViewById(rootView, id);
        if (innerPushLiveAnimation1 != null && (innerPushLiveAnimation2 = ViewBindings.findChildViewById(rootView, (id = R.id.inner_push_live_animation2))) != null && (innerPushLiveAvatar = ViewBindings.findChildViewById(rootView, (id = R.id.inner_push_live_avatar))) != null) {
            id = R.id.inner_push_live_avatar_container;
            FrameLayout innerPushLiveAvatarContainer = (FrameLayout) ViewBindings.findChildViewById(rootView, id);
            if (innerPushLiveAvatarContainer != null && (innerPushLiveTagAnimation = ViewBindings.findChildViewById(rootView, (id = R.id.inner_push_live_tag_animation))) != null && (innerPushLiveTagBackground = ViewBindings.findChildViewById(rootView, (id = R.id.inner_push_live_tag_background))) != null && (innerPushLiveTagGroup = ViewBindings.findChildViewById(rootView, (id = R.id.inner_push_live_tag_group))) != null && (innerPushLiveTagText = ViewBindings.findChildViewById(rootView, (id = R.id.inner_push_live_tag_text))) != null && (innerPushLiveWaveGroup = ViewBindings.findChildViewById(rootView, (id = R.id.inner_push_live_wave_group))) != null) {
                ConstraintLayout liveIcon = (ConstraintLayout) rootView;
                return new BiliAppLayoutAppInnerPushLiveAvatarBinding((ConstraintLayout) rootView, innerPushLiveAnimation1, innerPushLiveAnimation2, innerPushLiveAvatar, innerPushLiveAvatarContainer, innerPushLiveTagAnimation, innerPushLiveTagBackground, innerPushLiveTagGroup, innerPushLiveTagText, innerPushLiveWaveGroup, liveIcon);
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}