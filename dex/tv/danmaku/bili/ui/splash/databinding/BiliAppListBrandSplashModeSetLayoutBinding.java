package tv.danmaku.bili.ui.splash.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.SwitchCompat;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bilibili.magicasakura.widgets.TintConstraintLayout;
import com.bilibili.magicasakura.widgets.TintLinearLayout;
import com.bilibili.magicasakura.widgets.TintTextView;
import tv.danmaku.bili.ui.splash.R;

public final class BiliAppListBrandSplashModeSetLayoutBinding implements ViewBinding {
    public final TintConstraintLayout defaultMode;
    public final SwitchCompat defaultModeSwitch;
    public final TintTextView defaultModeTitle;
    public final TintTextView defaultSubTitle;
    private final TintLinearLayout rootView;

    private BiliAppListBrandSplashModeSetLayoutBinding(TintLinearLayout rootView, TintConstraintLayout defaultMode, SwitchCompat defaultModeSwitch, TintTextView defaultModeTitle, TintTextView defaultSubTitle) {
        this.rootView = rootView;
        this.defaultMode = defaultMode;
        this.defaultModeSwitch = defaultModeSwitch;
        this.defaultModeTitle = defaultModeTitle;
        this.defaultSubTitle = defaultSubTitle;
    }

    public TintLinearLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppListBrandSplashModeSetLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppListBrandSplashModeSetLayoutBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_list_brand_splash_mode_set_layout, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppListBrandSplashModeSetLayoutBinding bind(View rootView) {
        SwitchCompat defaultModeSwitch;
        TintTextView defaultModeTitle;
        TintTextView defaultSubTitle;
        int id = R.id.default_mode;
        TintConstraintLayout defaultMode = ViewBindings.findChildViewById(rootView, id);
        if (defaultMode != null && (defaultModeSwitch = ViewBindings.findChildViewById(rootView, (id = R.id.default_mode_switch))) != null && (defaultModeTitle = ViewBindings.findChildViewById(rootView, (id = R.id.default_mode_title))) != null && (defaultSubTitle = ViewBindings.findChildViewById(rootView, (id = R.id.default_sub_title))) != null) {
            return new BiliAppListBrandSplashModeSetLayoutBinding((TintLinearLayout) rootView, defaultMode, defaultModeSwitch, defaultModeTitle, defaultSubTitle);
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}