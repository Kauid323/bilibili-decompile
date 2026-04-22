package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import tv.danmaku.bili.R;

public final class BiliAppActivityFfconfigDebuggerBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final SwitchCompat switchButton;
    public final TextView tvContent;

    private BiliAppActivityFfconfigDebuggerBinding(LinearLayout rootView, SwitchCompat switchButton, TextView tvContent) {
        this.rootView = rootView;
        this.switchButton = switchButton;
        this.tvContent = tvContent;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppActivityFfconfigDebuggerBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppActivityFfconfigDebuggerBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_activity_ffconfig_debugger, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppActivityFfconfigDebuggerBinding bind(View rootView) {
        int id = R.id.switch_button;
        SwitchCompat switchButton = ViewBindings.findChildViewById(rootView, id);
        if (switchButton != null) {
            id = R.id.tv_content;
            TextView tvContent = (TextView) ViewBindings.findChildViewById(rootView, id);
            if (tvContent != null) {
                return new BiliAppActivityFfconfigDebuggerBinding((LinearLayout) rootView, switchButton, tvContent);
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}