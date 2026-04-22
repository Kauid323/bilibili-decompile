package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import tv.danmaku.bili.R;

public final class BiliAppActivityFakeTabItemBinding implements ViewBinding {
    public final View line;
    public final View redDot;
    private final ConstraintLayout rootView;
    public final TextView text;

    private BiliAppActivityFakeTabItemBinding(ConstraintLayout rootView, View line, View redDot, TextView text) {
        this.rootView = rootView;
        this.line = line;
        this.redDot = redDot;
        this.text = text;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppActivityFakeTabItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppActivityFakeTabItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_activity_fake_tab_item, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppActivityFakeTabItemBinding bind(View rootView) {
        View redDot;
        int id = R.id.line;
        View line = ViewBindings.findChildViewById(rootView, id);
        if (line != null && (redDot = ViewBindings.findChildViewById(rootView, (id = R.id.red_dot))) != null) {
            id = R.id.text;
            TextView text = (TextView) ViewBindings.findChildViewById(rootView, id);
            if (text != null) {
                return new BiliAppActivityFakeTabItemBinding((ConstraintLayout) rootView, line, redDot, text);
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}