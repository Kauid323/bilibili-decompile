package tv.danmaku.bili.ui.splash.databinding;

import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.bilibili.lib.image2.view.BiliImageView;
import tv.danmaku.bili.ui.splash.R;

public final class BiliAppListSplashImmersiveVideoLandingActivityV2Binding implements ViewBinding {
    public final View btnBack;
    public final TextView desc;
    public final LottieAnimationView enterLiveLottie;
    public final BiliImageView icon;
    public final LottieAnimationView livingIcon;
    public final TextView livingText;
    public final ConstraintLayout maskLayer;
    public final ImageView muteBtn;
    private final ConstraintLayout rootView;
    public final LinearLayout textArea;
    public final TextView title;
    public final ConstraintLayout topLeftRoundContainer;
    public final ConstraintLayout topLiveContainer;
    public final TextView tvEnterLive;
    public final ImageView videoBackground;
    public final TextureView videoLayer;

    private BiliAppListSplashImmersiveVideoLandingActivityV2Binding(ConstraintLayout rootView, View btnBack, TextView desc, LottieAnimationView enterLiveLottie, BiliImageView icon, LottieAnimationView livingIcon, TextView livingText, ConstraintLayout maskLayer, ImageView muteBtn, LinearLayout textArea, TextView title, ConstraintLayout topLeftRoundContainer, ConstraintLayout topLiveContainer, TextView tvEnterLive, ImageView videoBackground, TextureView videoLayer) {
        this.rootView = rootView;
        this.btnBack = btnBack;
        this.desc = desc;
        this.enterLiveLottie = enterLiveLottie;
        this.icon = icon;
        this.livingIcon = livingIcon;
        this.livingText = livingText;
        this.maskLayer = maskLayer;
        this.muteBtn = muteBtn;
        this.textArea = textArea;
        this.title = title;
        this.topLeftRoundContainer = topLeftRoundContainer;
        this.topLiveContainer = topLiveContainer;
        this.tvEnterLive = tvEnterLive;
        this.videoBackground = videoBackground;
        this.videoLayer = videoLayer;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppListSplashImmersiveVideoLandingActivityV2Binding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppListSplashImmersiveVideoLandingActivityV2Binding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_list_splash_immersive_video_landing_activity_v2, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppListSplashImmersiveVideoLandingActivityV2Binding bind(View rootView) {
        LottieAnimationView enterLiveLottie;
        BiliImageView icon;
        LottieAnimationView livingIcon;
        ConstraintLayout maskLayer;
        ConstraintLayout topLeftRoundContainer;
        ConstraintLayout topLiveContainer;
        int id = R.id.btn_back;
        View btnBack = ViewBindings.findChildViewById(rootView, id);
        if (btnBack != null) {
            id = R.id.desc;
            TextView desc = (TextView) ViewBindings.findChildViewById(rootView, id);
            if (desc != null && (enterLiveLottie = ViewBindings.findChildViewById(rootView, (id = R.id.enter_live_lottie))) != null && (icon = ViewBindings.findChildViewById(rootView, (id = R.id.icon))) != null && (livingIcon = ViewBindings.findChildViewById(rootView, (id = R.id.living_icon))) != null) {
                id = R.id.living_text;
                TextView livingText = (TextView) ViewBindings.findChildViewById(rootView, id);
                if (livingText != null && (maskLayer = ViewBindings.findChildViewById(rootView, (id = R.id.mask_layer))) != null) {
                    id = R.id.mute_btn;
                    ImageView muteBtn = (ImageView) ViewBindings.findChildViewById(rootView, id);
                    if (muteBtn != null) {
                        id = R.id.text_area;
                        LinearLayout textArea = (LinearLayout) ViewBindings.findChildViewById(rootView, id);
                        if (textArea != null) {
                            id = R.id.title;
                            TextView title = (TextView) ViewBindings.findChildViewById(rootView, id);
                            if (title != null && (topLeftRoundContainer = ViewBindings.findChildViewById(rootView, (id = R.id.top_left_round_container))) != null && (topLiveContainer = ViewBindings.findChildViewById(rootView, (id = R.id.top_live_container))) != null) {
                                id = R.id.tv_enter_live;
                                TextView tvEnterLive = (TextView) ViewBindings.findChildViewById(rootView, id);
                                if (tvEnterLive != null) {
                                    id = R.id.video_background;
                                    ImageView videoBackground = (ImageView) ViewBindings.findChildViewById(rootView, id);
                                    if (videoBackground != null) {
                                        id = R.id.video_layer;
                                        TextureView videoLayer = (TextureView) ViewBindings.findChildViewById(rootView, id);
                                        if (videoLayer != null) {
                                            return new BiliAppListSplashImmersiveVideoLandingActivityV2Binding((ConstraintLayout) rootView, btnBack, desc, enterLiveLottie, icon, livingIcon, livingText, maskLayer, muteBtn, textArea, title, topLeftRoundContainer, topLiveContainer, tvEnterLive, videoBackground, videoLayer);
                                        }
                                    }
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