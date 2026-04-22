package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.widget.DialogTitle;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bilibili.magicasakura.widgets.TintButton;
import tv.danmaku.bili.R;

public final class BiliAppFragmentPlayerAlertDialogBinding implements ViewBinding {
    public final TintButton button1;
    public final TintButton button2;
    public final TintButton button3;
    public final LinearLayout buttonPanel;
    public final FrameLayout customPanel;
    private final LinearLayout rootView;
    public final DialogTitle title;

    private BiliAppFragmentPlayerAlertDialogBinding(LinearLayout rootView, TintButton button1, TintButton button2, TintButton button3, LinearLayout buttonPanel, FrameLayout customPanel, DialogTitle title) {
        this.rootView = rootView;
        this.button1 = button1;
        this.button2 = button2;
        this.button3 = button3;
        this.buttonPanel = buttonPanel;
        this.customPanel = customPanel;
        this.title = title;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppFragmentPlayerAlertDialogBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppFragmentPlayerAlertDialogBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_fragment_player_alert_dialog, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppFragmentPlayerAlertDialogBinding bind(View rootView) {
        DialogTitle title;
        int id = 16908313;
        TintButton button1 = ViewBindings.findChildViewById(rootView, 16908313);
        if (button1 != null) {
            id = 16908314;
            TintButton button2 = ViewBindings.findChildViewById(rootView, 16908314);
            if (button2 != null) {
                id = 16908315;
                TintButton button3 = ViewBindings.findChildViewById(rootView, 16908315);
                if (button3 != null) {
                    id = R.id.buttonPanel;
                    LinearLayout buttonPanel = (LinearLayout) ViewBindings.findChildViewById(rootView, id);
                    if (buttonPanel != null) {
                        id = R.id.customPanel;
                        FrameLayout customPanel = (FrameLayout) ViewBindings.findChildViewById(rootView, id);
                        if (customPanel != null && (title = ViewBindings.findChildViewById(rootView, (id = R.id.title))) != null) {
                            return new BiliAppFragmentPlayerAlertDialogBinding((LinearLayout) rootView, button1, button2, button3, buttonPanel, customPanel, title);
                        }
                    }
                }
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}