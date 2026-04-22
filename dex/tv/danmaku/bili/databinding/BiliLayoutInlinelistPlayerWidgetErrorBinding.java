package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bilibili.magicasakura.widgets.TintImageView;
import tv.danmaku.bili.R;

public final class BiliLayoutInlinelistPlayerWidgetErrorBinding implements ViewBinding {
    public final LinearLayout errorActionContainer;
    public final TintImageView errorIcon;
    public final TextView errorText;
    private final LinearLayout rootView;

    private BiliLayoutInlinelistPlayerWidgetErrorBinding(LinearLayout rootView, LinearLayout errorActionContainer, TintImageView errorIcon, TextView errorText) {
        this.rootView = rootView;
        this.errorActionContainer = errorActionContainer;
        this.errorIcon = errorIcon;
        this.errorText = errorText;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static BiliLayoutInlinelistPlayerWidgetErrorBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliLayoutInlinelistPlayerWidgetErrorBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_layout_inlinelist_player_widget_error, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliLayoutInlinelistPlayerWidgetErrorBinding bind(View rootView) {
        LinearLayout errorActionContainer = (LinearLayout) rootView;
        int id = R.id.error_icon;
        TintImageView errorIcon = ViewBindings.findChildViewById(rootView, id);
        if (errorIcon != null) {
            id = R.id.error_text;
            TextView errorText = (TextView) ViewBindings.findChildViewById(rootView, id);
            if (errorText != null) {
                return new BiliLayoutInlinelistPlayerWidgetErrorBinding((LinearLayout) rootView, errorActionContainer, errorIcon, errorText);
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}