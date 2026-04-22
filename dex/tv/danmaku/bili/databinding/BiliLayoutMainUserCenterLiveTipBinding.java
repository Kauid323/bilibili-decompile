package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bilibili.lib.image2.view.BiliImageView;
import com.bilibili.magicasakura.widgets.TintConstraintLayout;
import com.bilibili.magicasakura.widgets.TintTextView;
import tv.danmaku.bili.R;

public final class BiliLayoutMainUserCenterLiveTipBinding implements ViewBinding {
    public final Guideline guideLine;
    private final TintConstraintLayout rootView;
    public final FrameLayout tipBtnContainer;
    public final BiliImageView tipBtnIcon;
    public final TintConstraintLayout tipBtnMode;
    public final TintTextView tipBtnText;
    public final BiliImageView tipIcon;
    public final ImageView tipIconMode;
    public final ImageView tipLinkBtn;
    public final ConstraintLayout tipLinkMode;
    public final TintTextView tipLinkText;
    public final TintConstraintLayout tipRoot;
    public final TintTextView tipText;

    private BiliLayoutMainUserCenterLiveTipBinding(TintConstraintLayout rootView, Guideline guideLine, FrameLayout tipBtnContainer, BiliImageView tipBtnIcon, TintConstraintLayout tipBtnMode, TintTextView tipBtnText, BiliImageView tipIcon, ImageView tipIconMode, ImageView tipLinkBtn, ConstraintLayout tipLinkMode, TintTextView tipLinkText, TintConstraintLayout tipRoot, TintTextView tipText) {
        this.rootView = rootView;
        this.guideLine = guideLine;
        this.tipBtnContainer = tipBtnContainer;
        this.tipBtnIcon = tipBtnIcon;
        this.tipBtnMode = tipBtnMode;
        this.tipBtnText = tipBtnText;
        this.tipIcon = tipIcon;
        this.tipIconMode = tipIconMode;
        this.tipLinkBtn = tipLinkBtn;
        this.tipLinkMode = tipLinkMode;
        this.tipLinkText = tipLinkText;
        this.tipRoot = tipRoot;
        this.tipText = tipText;
    }

    public TintConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BiliLayoutMainUserCenterLiveTipBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliLayoutMainUserCenterLiveTipBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_layout_main_user_center_live_tip, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliLayoutMainUserCenterLiveTipBinding bind(View rootView) {
        BiliImageView tipBtnIcon;
        TintConstraintLayout tipBtnMode;
        TintTextView tipBtnText;
        BiliImageView tipIcon;
        ConstraintLayout tipLinkMode;
        TintTextView tipLinkText;
        int id = R.id.guide_line;
        Guideline guideLine = ViewBindings.findChildViewById(rootView, id);
        if (guideLine != null) {
            id = R.id.tip_btn_container;
            FrameLayout tipBtnContainer = (FrameLayout) ViewBindings.findChildViewById(rootView, id);
            if (tipBtnContainer != null && (tipBtnIcon = ViewBindings.findChildViewById(rootView, (id = R.id.tip_btn_icon))) != null && (tipBtnMode = ViewBindings.findChildViewById(rootView, (id = R.id.tip_btn_mode))) != null && (tipBtnText = ViewBindings.findChildViewById(rootView, (id = R.id.tip_btn_text))) != null && (tipIcon = ViewBindings.findChildViewById(rootView, (id = R.id.tip_icon))) != null) {
                id = R.id.tip_icon_mode;
                ImageView tipIconMode = (ImageView) ViewBindings.findChildViewById(rootView, id);
                if (tipIconMode != null) {
                    id = R.id.tip_link_btn;
                    ImageView tipLinkBtn = (ImageView) ViewBindings.findChildViewById(rootView, id);
                    if (tipLinkBtn != null && (tipLinkMode = ViewBindings.findChildViewById(rootView, (id = R.id.tip_link_mode))) != null && (tipLinkText = ViewBindings.findChildViewById(rootView, (id = R.id.tip_link_text))) != null) {
                        TintConstraintLayout tipRoot = (TintConstraintLayout) rootView;
                        id = R.id.tip_text;
                        TintTextView tipText = ViewBindings.findChildViewById(rootView, id);
                        if (tipText != null) {
                            return new BiliLayoutMainUserCenterLiveTipBinding((TintConstraintLayout) rootView, guideLine, tipBtnContainer, tipBtnIcon, tipBtnMode, tipBtnText, tipIcon, tipIconMode, tipLinkBtn, tipLinkMode, tipLinkText, tipRoot, tipText);
                        }
                    }
                }
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}