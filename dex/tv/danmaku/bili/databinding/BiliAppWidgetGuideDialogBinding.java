package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bilibili.lib.image2.view.BiliImageView;
import com.bilibili.magicasakura.widgets.TintButton;
import com.bilibili.magicasakura.widgets.TintFrameLayout;
import com.bilibili.magicasakura.widgets.TintLinearLayout;
import com.bilibili.magicasakura.widgets.TintTextView;
import com.bilibili.magicasakura.widgets.TintView;
import tv.danmaku.bili.R;

public final class BiliAppWidgetGuideDialogBinding implements ViewBinding {
    public final TintLinearLayout container;
    public final TintView indicator;
    public final TintFrameLayout indicatorContainer;
    public final BiliImageView ivGuide;
    public final TintButton negativeButton;
    public final TintTextView positiveButton;
    private final TintLinearLayout rootView;
    public final TintTextView subtitle;
    public final TintTextView title;

    private BiliAppWidgetGuideDialogBinding(TintLinearLayout rootView, TintLinearLayout container, TintView indicator, TintFrameLayout indicatorContainer, BiliImageView ivGuide, TintButton negativeButton, TintTextView positiveButton, TintTextView subtitle, TintTextView title) {
        this.rootView = rootView;
        this.container = container;
        this.indicator = indicator;
        this.indicatorContainer = indicatorContainer;
        this.ivGuide = ivGuide;
        this.negativeButton = negativeButton;
        this.positiveButton = positiveButton;
        this.subtitle = subtitle;
        this.title = title;
    }

    public TintLinearLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppWidgetGuideDialogBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppWidgetGuideDialogBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_widget_guide_dialog, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppWidgetGuideDialogBinding bind(View rootView) {
        TintFrameLayout indicatorContainer;
        BiliImageView ivGuide;
        TintButton negativeButton;
        TintTextView positiveButton;
        TintTextView subtitle;
        TintLinearLayout container = (TintLinearLayout) rootView;
        int id = R.id.indicator;
        TintView indicator = ViewBindings.findChildViewById(rootView, id);
        if (indicator != null && (indicatorContainer = ViewBindings.findChildViewById(rootView, (id = R.id.indicator_container))) != null && (ivGuide = ViewBindings.findChildViewById(rootView, (id = R.id.iv_guide))) != null && (negativeButton = ViewBindings.findChildViewById(rootView, (id = R.id.negative_button))) != null && (positiveButton = ViewBindings.findChildViewById(rootView, (id = R.id.positive_button))) != null && (subtitle = ViewBindings.findChildViewById(rootView, (id = R.id.subtitle))) != null) {
            int id2 = R.id.title;
            TintTextView title = ViewBindings.findChildViewById(rootView, id2);
            if (title == null) {
                id = id2;
            } else {
                return new BiliAppWidgetGuideDialogBinding((TintLinearLayout) rootView, container, indicator, indicatorContainer, ivGuide, negativeButton, positiveButton, subtitle, title);
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}