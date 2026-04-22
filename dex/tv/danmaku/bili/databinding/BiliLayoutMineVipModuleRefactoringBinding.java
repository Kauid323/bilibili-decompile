package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bilibili.lib.image2.view.BiliImageView;
import com.bilibili.magicasakura.widgets.TintView;
import com.opensource.svgaplayer.SVGAImageView;
import tv.danmaku.bili.R;

public final class BiliLayoutMineVipModuleRefactoringBinding implements ViewBinding {
    public final View animateSpace;
    public final BiliImageView background;
    public final BiliImageView bivStaticIcon;
    public final LinearLayout button;
    public final TextView buttonText;
    public final ConstraintLayout container;
    public final Space iconGuideSpace;
    public final BiliImageView logo;
    public final FrameLayout mineVipLayoutRefactoring;
    public final ImageView rightArrow;
    private final FrameLayout rootView;
    public final TintView shadow;
    public final TintView solidBg;
    public final TextView subtitle;
    public final SVGAImageView svgaImage;
    public final TextView title;

    private BiliLayoutMineVipModuleRefactoringBinding(FrameLayout rootView, View animateSpace, BiliImageView background, BiliImageView bivStaticIcon, LinearLayout button, TextView buttonText, ConstraintLayout container, Space iconGuideSpace, BiliImageView logo, FrameLayout mineVipLayoutRefactoring, ImageView rightArrow, TintView shadow, TintView solidBg, TextView subtitle, SVGAImageView svgaImage, TextView title) {
        this.rootView = rootView;
        this.animateSpace = animateSpace;
        this.background = background;
        this.bivStaticIcon = bivStaticIcon;
        this.button = button;
        this.buttonText = buttonText;
        this.container = container;
        this.iconGuideSpace = iconGuideSpace;
        this.logo = logo;
        this.mineVipLayoutRefactoring = mineVipLayoutRefactoring;
        this.rightArrow = rightArrow;
        this.shadow = shadow;
        this.solidBg = solidBg;
        this.subtitle = subtitle;
        this.svgaImage = svgaImage;
        this.title = title;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static BiliLayoutMineVipModuleRefactoringBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliLayoutMineVipModuleRefactoringBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_layout_mine_vip_module_refactoring, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliLayoutMineVipModuleRefactoringBinding bind(View rootView) {
        BiliImageView background;
        BiliImageView bivStaticIcon;
        ConstraintLayout container;
        BiliImageView logo;
        TintView shadow;
        TintView solidBg;
        SVGAImageView svgaImage;
        int id = R.id.animate_space;
        View animateSpace = ViewBindings.findChildViewById(rootView, id);
        if (animateSpace != null && (background = ViewBindings.findChildViewById(rootView, (id = R.id.background))) != null && (bivStaticIcon = ViewBindings.findChildViewById(rootView, (id = R.id.biv_static_icon))) != null) {
            id = R.id.button;
            LinearLayout button = (LinearLayout) ViewBindings.findChildViewById(rootView, id);
            if (button != null) {
                id = R.id.button_text;
                TextView buttonText = (TextView) ViewBindings.findChildViewById(rootView, id);
                if (buttonText != null && (container = ViewBindings.findChildViewById(rootView, (id = R.id.container))) != null) {
                    id = R.id.icon_guide_space;
                    Space iconGuideSpace = (Space) ViewBindings.findChildViewById(rootView, id);
                    if (iconGuideSpace != null && (logo = ViewBindings.findChildViewById(rootView, (id = R.id.logo))) != null) {
                        FrameLayout mineVipLayoutRefactoring = (FrameLayout) rootView;
                        id = R.id.right_arrow;
                        ImageView rightArrow = (ImageView) ViewBindings.findChildViewById(rootView, id);
                        if (rightArrow != null && (shadow = ViewBindings.findChildViewById(rootView, (id = R.id.shadow))) != null && (solidBg = ViewBindings.findChildViewById(rootView, (id = R.id.solid_bg))) != null) {
                            id = R.id.subtitle;
                            TextView subtitle = (TextView) ViewBindings.findChildViewById(rootView, id);
                            if (subtitle != null && (svgaImage = ViewBindings.findChildViewById(rootView, (id = R.id.svga_image))) != null) {
                                id = R.id.title;
                                TextView title = (TextView) ViewBindings.findChildViewById(rootView, id);
                                if (title != null) {
                                    return new BiliLayoutMineVipModuleRefactoringBinding((FrameLayout) rootView, animateSpace, background, bivStaticIcon, button, buttonText, container, iconGuideSpace, logo, mineVipLayoutRefactoring, rightArrow, shadow, solidBg, subtitle, svgaImage, title);
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