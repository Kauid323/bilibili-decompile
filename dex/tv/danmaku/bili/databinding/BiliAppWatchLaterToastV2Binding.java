package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bilibili.app.comm.list.common.widget.RoundCircleFrameLayout;
import com.bilibili.magicasakura.widgets.TintConstraintLayout;
import com.bilibili.magicasakura.widgets.TintImageView;
import com.bilibili.magicasakura.widgets.TintTextView;
import tv.danmaku.bili.R;

public final class BiliAppWatchLaterToastV2Binding implements ViewBinding {
    public final TintConstraintLayout container;
    public final TintImageView icon;
    public final FrameLayout iconContainer;
    public final RoundCircleFrameLayout redDot;
    private final FrameLayout rootView;
    public final TintTextView textLeft;
    public final TintTextView textRight;

    private BiliAppWatchLaterToastV2Binding(FrameLayout rootView, TintConstraintLayout container, TintImageView icon, FrameLayout iconContainer, RoundCircleFrameLayout redDot, TintTextView textLeft, TintTextView textRight) {
        this.rootView = rootView;
        this.container = container;
        this.icon = icon;
        this.iconContainer = iconContainer;
        this.redDot = redDot;
        this.textLeft = textLeft;
        this.textRight = textRight;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppWatchLaterToastV2Binding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppWatchLaterToastV2Binding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_watch_later_toast_v2, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppWatchLaterToastV2Binding bind(View rootView) {
        TintImageView icon;
        RoundCircleFrameLayout redDot;
        TintTextView textLeft;
        TintTextView textRight;
        int id = R.id.container;
        TintConstraintLayout container = ViewBindings.findChildViewById(rootView, id);
        if (container != null && (icon = ViewBindings.findChildViewById(rootView, (id = R.id.icon))) != null) {
            id = R.id.icon_container;
            FrameLayout iconContainer = (FrameLayout) ViewBindings.findChildViewById(rootView, id);
            if (iconContainer != null && (redDot = ViewBindings.findChildViewById(rootView, (id = R.id.red_dot))) != null && (textLeft = ViewBindings.findChildViewById(rootView, (id = R.id.text_left))) != null && (textRight = ViewBindings.findChildViewById(rootView, (id = R.id.text_right))) != null) {
                return new BiliAppWatchLaterToastV2Binding((FrameLayout) rootView, container, icon, iconContainer, redDot, textLeft, textRight);
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}