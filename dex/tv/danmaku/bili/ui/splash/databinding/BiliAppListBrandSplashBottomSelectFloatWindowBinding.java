package tv.danmaku.bili.ui.splash.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bilibili.magicasakura.widgets.TintConstraintLayout;
import com.bilibili.magicasakura.widgets.TintFrameLayout;
import com.bilibili.magicasakura.widgets.TintTextView;
import com.bilibili.magicasakura.widgets.TintView;
import tv.danmaku.bili.ui.splash.R;

public final class BiliAppListBrandSplashBottomSelectFloatWindowBinding implements ViewBinding {
    public final TintFrameLayout brandBottomSelectFloatWindow;
    public final TintConstraintLayout clContentArea;
    public final TintView clickArea;
    public final ImageView ivSelectCover;
    private final TintFrameLayout rootView;
    public final TintTextView tvMaxPrompt;
    public final TintTextView tvSaveSelect;
    public final TintTextView tvSelectedCount;
    public final TintTextView tvSelectedPrompt;
    public final TintView vArrow;

    private BiliAppListBrandSplashBottomSelectFloatWindowBinding(TintFrameLayout rootView, TintFrameLayout brandBottomSelectFloatWindow, TintConstraintLayout clContentArea, TintView clickArea, ImageView ivSelectCover, TintTextView tvMaxPrompt, TintTextView tvSaveSelect, TintTextView tvSelectedCount, TintTextView tvSelectedPrompt, TintView vArrow) {
        this.rootView = rootView;
        this.brandBottomSelectFloatWindow = brandBottomSelectFloatWindow;
        this.clContentArea = clContentArea;
        this.clickArea = clickArea;
        this.ivSelectCover = ivSelectCover;
        this.tvMaxPrompt = tvMaxPrompt;
        this.tvSaveSelect = tvSaveSelect;
        this.tvSelectedCount = tvSelectedCount;
        this.tvSelectedPrompt = tvSelectedPrompt;
        this.vArrow = vArrow;
    }

    public TintFrameLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppListBrandSplashBottomSelectFloatWindowBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppListBrandSplashBottomSelectFloatWindowBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_list_brand_splash_bottom_select_float_window, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppListBrandSplashBottomSelectFloatWindowBinding bind(View rootView) {
        TintView clickArea;
        TintTextView tvMaxPrompt;
        TintTextView tvSaveSelect;
        TintTextView tvSelectedCount;
        TintTextView tvSelectedPrompt;
        TintFrameLayout brandBottomSelectFloatWindow = (TintFrameLayout) rootView;
        int id = R.id.cl_content_area;
        TintConstraintLayout clContentArea = ViewBindings.findChildViewById(rootView, id);
        if (clContentArea != null && (clickArea = ViewBindings.findChildViewById(rootView, (id = R.id.click_area))) != null) {
            id = R.id.iv_select_cover;
            ImageView ivSelectCover = (ImageView) ViewBindings.findChildViewById(rootView, id);
            if (ivSelectCover != null && (tvMaxPrompt = ViewBindings.findChildViewById(rootView, (id = R.id.tv_max_prompt))) != null && (tvSaveSelect = ViewBindings.findChildViewById(rootView, (id = R.id.tv_save_select))) != null && (tvSelectedCount = ViewBindings.findChildViewById(rootView, (id = R.id.tv_selected_count))) != null && (tvSelectedPrompt = ViewBindings.findChildViewById(rootView, (id = R.id.tv_selected_prompt))) != null) {
                int id2 = R.id.v_arrow;
                TintView vArrow = ViewBindings.findChildViewById(rootView, id2);
                if (vArrow == null) {
                    id = id2;
                } else {
                    return new BiliAppListBrandSplashBottomSelectFloatWindowBinding((TintFrameLayout) rootView, brandBottomSelectFloatWindow, clContentArea, clickArea, ivSelectCover, tvMaxPrompt, tvSaveSelect, tvSelectedCount, tvSelectedPrompt, vArrow);
                }
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}