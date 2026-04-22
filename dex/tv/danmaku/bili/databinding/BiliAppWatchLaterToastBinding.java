package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bilibili.magicasakura.widgets.TintConstraintLayout;
import com.bilibili.magicasakura.widgets.TintImageView;
import com.bilibili.magicasakura.widgets.TintTextView;
import tv.danmaku.bili.R;

public final class BiliAppWatchLaterToastBinding implements ViewBinding {
    public final TintConstraintLayout container;
    public final TintImageView icon;
    private final FrameLayout rootView;
    public final TintTextView textLeft;
    public final TintTextView textRight;

    private BiliAppWatchLaterToastBinding(FrameLayout rootView, TintConstraintLayout container, TintImageView icon, TintTextView textLeft, TintTextView textRight) {
        this.rootView = rootView;
        this.container = container;
        this.icon = icon;
        this.textLeft = textLeft;
        this.textRight = textRight;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppWatchLaterToastBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppWatchLaterToastBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_watch_later_toast, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppWatchLaterToastBinding bind(View rootView) {
        TintImageView icon;
        TintTextView textLeft;
        TintTextView textRight;
        int id = R.id.container;
        TintConstraintLayout container = ViewBindings.findChildViewById(rootView, id);
        if (container != null && (icon = ViewBindings.findChildViewById(rootView, (id = R.id.icon))) != null && (textLeft = ViewBindings.findChildViewById(rootView, (id = R.id.text_left))) != null && (textRight = ViewBindings.findChildViewById(rootView, (id = R.id.text_right))) != null) {
            return new BiliAppWatchLaterToastBinding((FrameLayout) rootView, container, icon, textLeft, textRight);
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}