package tv.danmaku.bili.ui.splash.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bilibili.lib.image2.view.BiliImageView;
import tv.danmaku.bili.ui.splash.R;
import tv.danmaku.bili.ui.splash.widget.DeliverySlideEventFrameLayout;
import tv.danmaku.bili.ui.splash.widget.SplashContainerView;
import tv.danmaku.bili.ui.splash.widget.SplashImageView;
import tv.danmaku.bili.ui.splash.widget.SplashInteractView;

public final class BiliAppFragmentSplashBinding implements ViewBinding {
    public final TextView countDown;
    public final TextView countDown2;
    public final Guideline guideline;
    public final TextView labelAd;
    public final TextView labelAd2;
    public final TextView labelAd3;
    public final LinearLayout labelLayout;
    public final LinearLayout labelLayout2;
    public final LinearLayout labelLayout3;
    public final BiliImageView logo;
    public final ConstraintLayout logoLayout;
    public final View lottieShadow;
    public final SplashContainerView rootContainer;
    private final SplashContainerView rootView;
    public final DeliverySlideEventFrameLayout splashButtonContainer;
    public final SplashInteractView splashInteractView;
    public final FrameLayout splashSecondPageContainer;
    public final SplashImageView splashView;
    public final ViewStub stubFloat;

    private BiliAppFragmentSplashBinding(SplashContainerView rootView, TextView countDown, TextView countDown2, Guideline guideline, TextView labelAd, TextView labelAd2, TextView labelAd3, LinearLayout labelLayout, LinearLayout labelLayout2, LinearLayout labelLayout3, BiliImageView logo, ConstraintLayout logoLayout, View lottieShadow, SplashContainerView rootContainer, DeliverySlideEventFrameLayout splashButtonContainer, SplashInteractView splashInteractView, FrameLayout splashSecondPageContainer, SplashImageView splashView, ViewStub stubFloat) {
        this.rootView = rootView;
        this.countDown = countDown;
        this.countDown2 = countDown2;
        this.guideline = guideline;
        this.labelAd = labelAd;
        this.labelAd2 = labelAd2;
        this.labelAd3 = labelAd3;
        this.labelLayout = labelLayout;
        this.labelLayout2 = labelLayout2;
        this.labelLayout3 = labelLayout3;
        this.logo = logo;
        this.logoLayout = logoLayout;
        this.lottieShadow = lottieShadow;
        this.rootContainer = rootContainer;
        this.splashButtonContainer = splashButtonContainer;
        this.splashInteractView = splashInteractView;
        this.splashSecondPageContainer = splashSecondPageContainer;
        this.splashView = splashView;
        this.stubFloat = stubFloat;
    }

    public SplashContainerView getRoot() {
        return this.rootView;
    }

    public static BiliAppFragmentSplashBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppFragmentSplashBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_fragment_splash, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppFragmentSplashBinding bind(View rootView) {
        Guideline guideline;
        BiliImageView logo;
        ConstraintLayout logoLayout;
        View lottieShadow;
        int id = R.id.count_down;
        TextView countDown = (TextView) ViewBindings.findChildViewById(rootView, id);
        if (countDown != null) {
            id = R.id.count_down2;
            TextView countDown2 = (TextView) ViewBindings.findChildViewById(rootView, id);
            if (countDown2 != null && (guideline = ViewBindings.findChildViewById(rootView, (id = R.id.guideline))) != null) {
                id = R.id.label_ad;
                TextView labelAd = (TextView) ViewBindings.findChildViewById(rootView, id);
                if (labelAd != null) {
                    id = R.id.label_ad2;
                    TextView labelAd2 = (TextView) ViewBindings.findChildViewById(rootView, id);
                    if (labelAd2 != null) {
                        id = R.id.label_ad3;
                        TextView labelAd3 = (TextView) ViewBindings.findChildViewById(rootView, id);
                        if (labelAd3 != null) {
                            id = R.id.label_layout;
                            LinearLayout labelLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, id);
                            if (labelLayout != null) {
                                id = R.id.label_layout2;
                                LinearLayout labelLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, id);
                                if (labelLayout2 != null) {
                                    id = R.id.label_layout3;
                                    LinearLayout labelLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, id);
                                    if (labelLayout3 != null && (logo = ViewBindings.findChildViewById(rootView, (id = R.id.logo))) != null && (logoLayout = ViewBindings.findChildViewById(rootView, (id = R.id.logo_layout))) != null && (lottieShadow = ViewBindings.findChildViewById(rootView, (id = R.id.lottie_shadow))) != null) {
                                        SplashContainerView rootContainer = (SplashContainerView) rootView;
                                        id = R.id.splash_button_container;
                                        DeliverySlideEventFrameLayout splashButtonContainer = (DeliverySlideEventFrameLayout) ViewBindings.findChildViewById(rootView, id);
                                        if (splashButtonContainer != null) {
                                            id = R.id.splash_interact_view;
                                            SplashInteractView splashInteractView = (SplashInteractView) ViewBindings.findChildViewById(rootView, id);
                                            if (splashInteractView != null) {
                                                id = R.id.splash_second_page_container;
                                                FrameLayout splashSecondPageContainer = (FrameLayout) ViewBindings.findChildViewById(rootView, id);
                                                if (splashSecondPageContainer != null) {
                                                    id = R.id.splash_view;
                                                    SplashImageView splashView = (SplashImageView) ViewBindings.findChildViewById(rootView, id);
                                                    if (splashView != null) {
                                                        id = R.id.stub_float;
                                                        ViewStub stubFloat = (ViewStub) ViewBindings.findChildViewById(rootView, id);
                                                        if (stubFloat != null) {
                                                            return new BiliAppFragmentSplashBinding((SplashContainerView) rootView, countDown, countDown2, guideline, labelAd, labelAd2, labelAd3, labelLayout, labelLayout2, labelLayout3, logo, logoLayout, lottieShadow, rootContainer, splashButtonContainer, splashInteractView, splashSecondPageContainer, splashView, stubFloat);
                                                        }
                                                    }
                                                }
                                            }
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