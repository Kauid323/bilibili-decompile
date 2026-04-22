package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bilibili.lib.homepage.widget.badge.MoleBadgeView;
import com.bilibili.lib.image2.view.BiliImageView;
import com.bilibili.magicasakura.widgets.TintConstraintLayout;
import com.bilibili.magicasakura.widgets.TintTextView;
import tv.danmaku.bili.R;

public final class BiliLayoutMainUserCenterModuleNotUpperBinding implements ViewBinding {
    public final MoleBadgeView badge;
    public final ImageView buttonIcon;
    public final TintConstraintLayout buttonLayout;
    public final TintTextView buttonText;
    public final TintTextView notUpperSubtitle;
    public final TintTextView notUpperTitle;
    public final BiliImageView notUpperTitleIcon;
    private final TintConstraintLayout rootView;
    public final ConstraintLayout subtitleClickContainer;
    public final TintTextView tvClickTip;

    private BiliLayoutMainUserCenterModuleNotUpperBinding(TintConstraintLayout rootView, MoleBadgeView badge, ImageView buttonIcon, TintConstraintLayout buttonLayout, TintTextView buttonText, TintTextView notUpperSubtitle, TintTextView notUpperTitle, BiliImageView notUpperTitleIcon, ConstraintLayout subtitleClickContainer, TintTextView tvClickTip) {
        this.rootView = rootView;
        this.badge = badge;
        this.buttonIcon = buttonIcon;
        this.buttonLayout = buttonLayout;
        this.buttonText = buttonText;
        this.notUpperSubtitle = notUpperSubtitle;
        this.notUpperTitle = notUpperTitle;
        this.notUpperTitleIcon = notUpperTitleIcon;
        this.subtitleClickContainer = subtitleClickContainer;
        this.tvClickTip = tvClickTip;
    }

    public TintConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BiliLayoutMainUserCenterModuleNotUpperBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliLayoutMainUserCenterModuleNotUpperBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_layout_main_user_center_module_not_upper, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliLayoutMainUserCenterModuleNotUpperBinding bind(View rootView) {
        TintConstraintLayout buttonLayout;
        TintTextView buttonText;
        TintTextView notUpperSubtitle;
        TintTextView notUpperTitle;
        BiliImageView notUpperTitleIcon;
        ConstraintLayout subtitleClickContainer;
        TintTextView tvClickTip;
        int id = R.id.badge;
        MoleBadgeView badge = ViewBindings.findChildViewById(rootView, id);
        if (badge != null) {
            id = R.id.button_icon;
            ImageView buttonIcon = (ImageView) ViewBindings.findChildViewById(rootView, id);
            if (buttonIcon != null && (buttonLayout = ViewBindings.findChildViewById(rootView, (id = R.id.button_layout))) != null && (buttonText = ViewBindings.findChildViewById(rootView, (id = R.id.button_text))) != null && (notUpperSubtitle = ViewBindings.findChildViewById(rootView, (id = R.id.not_upper_subtitle))) != null && (notUpperTitle = ViewBindings.findChildViewById(rootView, (id = R.id.not_upper_title))) != null && (notUpperTitleIcon = ViewBindings.findChildViewById(rootView, (id = R.id.not_upper_title_icon))) != null && (subtitleClickContainer = ViewBindings.findChildViewById(rootView, (id = R.id.subtitle_click_container))) != null && (tvClickTip = ViewBindings.findChildViewById(rootView, (id = R.id.tv_click_tip))) != null) {
                return new BiliLayoutMainUserCenterModuleNotUpperBinding((TintConstraintLayout) rootView, badge, buttonIcon, buttonLayout, buttonText, notUpperSubtitle, notUpperTitle, notUpperTitleIcon, subtitleClickContainer, tvClickTip);
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}