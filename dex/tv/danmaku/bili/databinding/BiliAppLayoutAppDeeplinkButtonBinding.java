package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bilibili.lib.image2.view.BiliImageView;
import com.bilibili.magicasakura.widgets.TintConstraintLayout;
import com.bilibili.magicasakura.widgets.TintImageView;
import com.bilibili.magicasakura.widgets.TintTextView;
import tv.danmaku.bili.R;

public final class BiliAppLayoutAppDeeplinkButtonBinding implements ViewBinding {
    public final TintImageView back;
    public final TintImageView close;
    public final TintConstraintLayout contentLayout;
    public final BiliImageView icon;
    public final FrameLayout iconBg;
    private final TintConstraintLayout rootView;
    public final TintTextView title;

    private BiliAppLayoutAppDeeplinkButtonBinding(TintConstraintLayout rootView, TintImageView back, TintImageView close, TintConstraintLayout contentLayout, BiliImageView icon, FrameLayout iconBg, TintTextView title) {
        this.rootView = rootView;
        this.back = back;
        this.close = close;
        this.contentLayout = contentLayout;
        this.icon = icon;
        this.iconBg = iconBg;
        this.title = title;
    }

    public TintConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppLayoutAppDeeplinkButtonBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppLayoutAppDeeplinkButtonBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_layout_app_deeplink_button, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppLayoutAppDeeplinkButtonBinding bind(View rootView) {
        TintImageView close;
        TintTextView title;
        int id = R.id.back;
        TintImageView back = ViewBindings.findChildViewById(rootView, id);
        if (back != null && (close = ViewBindings.findChildViewById(rootView, (id = R.id.close))) != null) {
            TintConstraintLayout contentLayout = (TintConstraintLayout) rootView;
            id = R.id.icon;
            BiliImageView icon = ViewBindings.findChildViewById(rootView, id);
            if (icon != null) {
                id = R.id.icon_bg;
                FrameLayout iconBg = (FrameLayout) ViewBindings.findChildViewById(rootView, id);
                if (iconBg != null && (title = ViewBindings.findChildViewById(rootView, (id = R.id.title))) != null) {
                    return new BiliAppLayoutAppDeeplinkButtonBinding((TintConstraintLayout) rootView, back, close, contentLayout, icon, iconBg, title);
                }
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}