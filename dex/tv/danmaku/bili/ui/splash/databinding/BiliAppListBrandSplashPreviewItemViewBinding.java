package tv.danmaku.bili.ui.splash.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bilibili.lib.image2.view.BiliImageView;
import com.bilibili.magicasakura.widgets.TintFrameLayout;
import tv.danmaku.bili.ui.splash.R;

public final class BiliAppListBrandSplashPreviewItemViewBinding implements ViewBinding {
    public final ImageView brandLogo;
    public final BiliImageView brandSplash;
    public final BiliImageView fullBrandSplash;
    private final TintFrameLayout rootView;

    private BiliAppListBrandSplashPreviewItemViewBinding(TintFrameLayout rootView, ImageView brandLogo, BiliImageView brandSplash, BiliImageView fullBrandSplash) {
        this.rootView = rootView;
        this.brandLogo = brandLogo;
        this.brandSplash = brandSplash;
        this.fullBrandSplash = fullBrandSplash;
    }

    public TintFrameLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppListBrandSplashPreviewItemViewBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppListBrandSplashPreviewItemViewBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_list_brand_splash_preview_item_view, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppListBrandSplashPreviewItemViewBinding bind(View rootView) {
        BiliImageView brandSplash;
        BiliImageView fullBrandSplash;
        int id = R.id.brand_logo;
        ImageView brandLogo = (ImageView) ViewBindings.findChildViewById(rootView, id);
        if (brandLogo != null && (brandSplash = ViewBindings.findChildViewById(rootView, (id = R.id.brand_splash))) != null && (fullBrandSplash = ViewBindings.findChildViewById(rootView, (id = R.id.full_brand_splash))) != null) {
            return new BiliAppListBrandSplashPreviewItemViewBinding((TintFrameLayout) rootView, brandLogo, brandSplash, fullBrandSplash);
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}