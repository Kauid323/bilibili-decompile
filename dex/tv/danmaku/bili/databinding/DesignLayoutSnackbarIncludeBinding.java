package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bilibili.magicasakura.widgets.TintButton;
import com.google.android.material.snackbar.SnackbarContentLayout;
import tv.danmaku.bili.R;

public final class DesignLayoutSnackbarIncludeBinding implements ViewBinding {
    private final SnackbarContentLayout rootView;
    public final TintButton snackbarAction;
    public final TextView snackbarText;

    private DesignLayoutSnackbarIncludeBinding(SnackbarContentLayout rootView, TintButton snackbarAction, TextView snackbarText) {
        this.rootView = rootView;
        this.snackbarAction = snackbarAction;
        this.snackbarText = snackbarText;
    }

    public SnackbarContentLayout getRoot() {
        return this.rootView;
    }

    public static DesignLayoutSnackbarIncludeBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static DesignLayoutSnackbarIncludeBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.design_layout_snackbar_include, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static DesignLayoutSnackbarIncludeBinding bind(View rootView) {
        int id = R.id.snackbar_action;
        TintButton snackbarAction = ViewBindings.findChildViewById(rootView, id);
        if (snackbarAction != null) {
            id = R.id.snackbar_text;
            TextView snackbarText = (TextView) ViewBindings.findChildViewById(rootView, id);
            if (snackbarText != null) {
                return new DesignLayoutSnackbarIncludeBinding((SnackbarContentLayout) rootView, snackbarAction, snackbarText);
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}