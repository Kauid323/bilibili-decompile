package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.ButtonBarLayout;
import androidx.legacy.widget.Space;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bilibili.magicasakura.widgets.TintButton;
import tv.danmaku.bili.R;

public final class AbcAlertDialogButtonBarMaterialBinding implements ViewBinding {
    public final TintButton button1;
    public final TintButton button2;
    public final TintButton button3;
    public final ButtonBarLayout buttonPanel;
    private final ButtonBarLayout rootView;
    public final Space spacer;

    private AbcAlertDialogButtonBarMaterialBinding(ButtonBarLayout rootView, TintButton button1, TintButton button2, TintButton button3, ButtonBarLayout buttonPanel, Space spacer) {
        this.rootView = rootView;
        this.button1 = button1;
        this.button2 = button2;
        this.button3 = button3;
        this.buttonPanel = buttonPanel;
        this.spacer = spacer;
    }

    public ButtonBarLayout getRoot() {
        return this.rootView;
    }

    public static AbcAlertDialogButtonBarMaterialBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static AbcAlertDialogButtonBarMaterialBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.abc_alert_dialog_button_bar_material, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static AbcAlertDialogButtonBarMaterialBinding bind(View rootView) {
        int id = 16908313;
        TintButton button1 = ViewBindings.findChildViewById(rootView, 16908313);
        if (button1 != null) {
            id = 16908314;
            TintButton button2 = ViewBindings.findChildViewById(rootView, 16908314);
            if (button2 != null) {
                id = 16908315;
                TintButton button3 = ViewBindings.findChildViewById(rootView, 16908315);
                if (button3 != null) {
                    ButtonBarLayout buttonPanel = (ButtonBarLayout) rootView;
                    id = R.id.spacer;
                    Space spacer = ViewBindings.findChildViewById(rootView, id);
                    if (spacer != null) {
                        return new AbcAlertDialogButtonBarMaterialBinding((ButtonBarLayout) rootView, button1, button2, button3, buttonPanel, spacer);
                    }
                }
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}