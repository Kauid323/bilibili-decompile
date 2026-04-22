package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bilibili.lib.homepage.widget.badge.MoleBadgeView;
import com.bilibili.lib.image2.view.BiliImageView;
import com.bilibili.magicasakura.widgets.TintConstraintLayout;
import com.bilibili.magicasakura.widgets.TintImageView;
import com.bilibili.magicasakura.widgets.TintTextView;
import tv.danmaku.bili.R;
import tv.danmaku.bili.ui.main2.mine.widgets.MineNightTextView;

public final class BiliLayoutMainUserCenterModuleNormalBinding implements ViewBinding {
    public final MoleBadgeView badge;
    public final TintTextView buttonForward;
    public final ImageView buttonIcon;
    public final TintConstraintLayout buttonLayout;
    public final TintTextView buttonText;
    public final ViewStub buttonTip;
    public final ConstraintLayout headLayout;
    public final TintImageView icArrow;
    public final RecyclerView itemRecycle;
    public final BiliImageView mngBg;
    private final ConstraintLayout rootView;
    public final MineNightTextView subtitle;
    public final MineNightTextView title;

    private BiliLayoutMainUserCenterModuleNormalBinding(ConstraintLayout rootView, MoleBadgeView badge, TintTextView buttonForward, ImageView buttonIcon, TintConstraintLayout buttonLayout, TintTextView buttonText, ViewStub buttonTip, ConstraintLayout headLayout, TintImageView icArrow, RecyclerView itemRecycle, BiliImageView mngBg, MineNightTextView subtitle, MineNightTextView title) {
        this.rootView = rootView;
        this.badge = badge;
        this.buttonForward = buttonForward;
        this.buttonIcon = buttonIcon;
        this.buttonLayout = buttonLayout;
        this.buttonText = buttonText;
        this.buttonTip = buttonTip;
        this.headLayout = headLayout;
        this.icArrow = icArrow;
        this.itemRecycle = itemRecycle;
        this.mngBg = mngBg;
        this.subtitle = subtitle;
        this.title = title;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BiliLayoutMainUserCenterModuleNormalBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliLayoutMainUserCenterModuleNormalBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_layout_main_user_center_module_normal, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliLayoutMainUserCenterModuleNormalBinding bind(View rootView) {
        TintTextView buttonForward;
        TintConstraintLayout buttonLayout;
        TintTextView buttonText;
        ConstraintLayout headLayout;
        TintImageView icArrow;
        RecyclerView itemRecycle;
        BiliImageView mngBg;
        int id = R.id.badge;
        MoleBadgeView badge = ViewBindings.findChildViewById(rootView, id);
        if (badge != null && (buttonForward = ViewBindings.findChildViewById(rootView, (id = R.id.button_forward))) != null) {
            id = R.id.button_icon;
            ImageView buttonIcon = (ImageView) ViewBindings.findChildViewById(rootView, id);
            if (buttonIcon != null && (buttonLayout = ViewBindings.findChildViewById(rootView, (id = R.id.button_layout))) != null && (buttonText = ViewBindings.findChildViewById(rootView, (id = R.id.button_text))) != null) {
                id = R.id.button_tip;
                ViewStub buttonTip = (ViewStub) ViewBindings.findChildViewById(rootView, id);
                if (buttonTip != null && (headLayout = ViewBindings.findChildViewById(rootView, (id = R.id.head_layout))) != null && (icArrow = ViewBindings.findChildViewById(rootView, (id = R.id.ic_arrow))) != null && (itemRecycle = ViewBindings.findChildViewById(rootView, (id = R.id.item_recycle))) != null && (mngBg = ViewBindings.findChildViewById(rootView, (id = R.id.mng_bg))) != null) {
                    id = R.id.subtitle;
                    MineNightTextView subtitle = (MineNightTextView) ViewBindings.findChildViewById(rootView, id);
                    if (subtitle != null) {
                        id = R.id.title;
                        MineNightTextView title = (MineNightTextView) ViewBindings.findChildViewById(rootView, id);
                        if (title != null) {
                            return new BiliLayoutMainUserCenterModuleNormalBinding((ConstraintLayout) rootView, badge, buttonForward, buttonIcon, buttonLayout, buttonText, buttonTip, headLayout, icArrow, itemRecycle, mngBg, subtitle, title);
                        }
                    }
                }
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}