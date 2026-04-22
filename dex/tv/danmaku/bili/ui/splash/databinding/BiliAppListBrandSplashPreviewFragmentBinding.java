package tv.danmaku.bili.ui.splash.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager2.widget.ViewPager2;
import com.bilibili.magicasakura.widgets.TintConstraintLayout;
import com.bilibili.magicasakura.widgets.TintFrameLayout;
import com.bilibili.magicasakura.widgets.TintImageView;
import com.bilibili.magicasakura.widgets.TintTextView;
import tv.danmaku.bili.ui.splash.R;

public final class BiliAppListBrandSplashPreviewFragmentBinding implements ViewBinding {
    public final TintImageView brandSplashPreviewBack;
    public final TintTextView brandSplashPreviewImageTitle;
    public final TintTextView brandSplashPreviewSelect;
    public final TintImageView brandSplashPreviewSelectBtn;
    public final ViewPager2 brandSplashPreviewVp;
    private final TintFrameLayout rootView;
    public final TintConstraintLayout topBar;

    private BiliAppListBrandSplashPreviewFragmentBinding(TintFrameLayout rootView, TintImageView brandSplashPreviewBack, TintTextView brandSplashPreviewImageTitle, TintTextView brandSplashPreviewSelect, TintImageView brandSplashPreviewSelectBtn, ViewPager2 brandSplashPreviewVp, TintConstraintLayout topBar) {
        this.rootView = rootView;
        this.brandSplashPreviewBack = brandSplashPreviewBack;
        this.brandSplashPreviewImageTitle = brandSplashPreviewImageTitle;
        this.brandSplashPreviewSelect = brandSplashPreviewSelect;
        this.brandSplashPreviewSelectBtn = brandSplashPreviewSelectBtn;
        this.brandSplashPreviewVp = brandSplashPreviewVp;
        this.topBar = topBar;
    }

    public TintFrameLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppListBrandSplashPreviewFragmentBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppListBrandSplashPreviewFragmentBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_list_brand_splash_preview_fragment, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppListBrandSplashPreviewFragmentBinding bind(View rootView) {
        TintTextView brandSplashPreviewImageTitle;
        TintTextView brandSplashPreviewSelect;
        TintImageView brandSplashPreviewSelectBtn;
        ViewPager2 brandSplashPreviewVp;
        TintConstraintLayout topBar;
        int id = R.id.brand_splash_preview_back;
        TintImageView brandSplashPreviewBack = ViewBindings.findChildViewById(rootView, id);
        if (brandSplashPreviewBack != null && (brandSplashPreviewImageTitle = ViewBindings.findChildViewById(rootView, (id = R.id.brand_splash_preview_image_title))) != null && (brandSplashPreviewSelect = ViewBindings.findChildViewById(rootView, (id = R.id.brand_splash_preview_select))) != null && (brandSplashPreviewSelectBtn = ViewBindings.findChildViewById(rootView, (id = R.id.brand_splash_preview_select_btn))) != null && (brandSplashPreviewVp = ViewBindings.findChildViewById(rootView, (id = R.id.brand_splash_preview_vp))) != null && (topBar = ViewBindings.findChildViewById(rootView, (id = R.id.top_bar))) != null) {
            return new BiliAppListBrandSplashPreviewFragmentBinding((TintFrameLayout) rootView, brandSplashPreviewBack, brandSplashPreviewImageTitle, brandSplashPreviewSelect, brandSplashPreviewSelectBtn, brandSplashPreviewVp, topBar);
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}