package tv.danmaku.bili.ui.splash.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bilibili.lib.image2.view.BiliImageView;
import com.bilibili.magicasakura.widgets.TintTextView;
import tv.danmaku.bili.ui.splash.R;

public final class BiliAppLayoutBrandSplashFragmentBinding implements ViewBinding {
    public final ImageView brandLogo;
    public final ConstraintLayout brandLogoContainer;
    public final ConstraintLayout brandSearchContainer;
    public final TintTextView brandSearchWord;
    public final BiliImageView brandSplash;
    public final BiliImageView fullBrandSplash;
    private final ConstraintLayout rootView;
    public final Guideline searchGuideLine;
    public final ConstraintLayout splashContainer;

    private BiliAppLayoutBrandSplashFragmentBinding(ConstraintLayout rootView, ImageView brandLogo, ConstraintLayout brandLogoContainer, ConstraintLayout brandSearchContainer, TintTextView brandSearchWord, BiliImageView brandSplash, BiliImageView fullBrandSplash, Guideline searchGuideLine, ConstraintLayout splashContainer) {
        this.rootView = rootView;
        this.brandLogo = brandLogo;
        this.brandLogoContainer = brandLogoContainer;
        this.brandSearchContainer = brandSearchContainer;
        this.brandSearchWord = brandSearchWord;
        this.brandSplash = brandSplash;
        this.fullBrandSplash = fullBrandSplash;
        this.searchGuideLine = searchGuideLine;
        this.splashContainer = splashContainer;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppLayoutBrandSplashFragmentBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppLayoutBrandSplashFragmentBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_layout_brand_splash_fragment, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppLayoutBrandSplashFragmentBinding bind(View rootView) {
        ConstraintLayout brandLogoContainer;
        ConstraintLayout brandSearchContainer;
        TintTextView brandSearchWord;
        BiliImageView brandSplash;
        BiliImageView fullBrandSplash;
        Guideline searchGuideLine;
        int id = R.id.brand_logo;
        ImageView brandLogo = (ImageView) ViewBindings.findChildViewById(rootView, id);
        if (brandLogo != null && (brandLogoContainer = ViewBindings.findChildViewById(rootView, (id = R.id.brand_logo_container))) != null && (brandSearchContainer = ViewBindings.findChildViewById(rootView, (id = R.id.brand_search_container))) != null && (brandSearchWord = ViewBindings.findChildViewById(rootView, (id = R.id.brand_search_word))) != null && (brandSplash = ViewBindings.findChildViewById(rootView, (id = R.id.brand_splash))) != null && (fullBrandSplash = ViewBindings.findChildViewById(rootView, (id = R.id.full_brand_splash))) != null && (searchGuideLine = ViewBindings.findChildViewById(rootView, (id = R.id.search_guide_line))) != null) {
            ConstraintLayout splashContainer = (ConstraintLayout) rootView;
            return new BiliAppLayoutBrandSplashFragmentBinding((ConstraintLayout) rootView, brandLogo, brandLogoContainer, brandSearchContainer, brandSearchWord, brandSplash, fullBrandSplash, searchGuideLine, splashContainer);
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}