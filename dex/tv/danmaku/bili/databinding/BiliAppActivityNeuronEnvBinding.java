package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import tv.danmaku.bili.R;

public final class BiliAppActivityNeuronEnvBinding implements ViewBinding {
    public final EditText etIp;
    private final LinearLayout rootView;
    public final Switch switcher;
    public final TextView tvNeuronTestPageUuid;

    private BiliAppActivityNeuronEnvBinding(LinearLayout rootView, EditText etIp, Switch switcher, TextView tvNeuronTestPageUuid) {
        this.rootView = rootView;
        this.etIp = etIp;
        this.switcher = switcher;
        this.tvNeuronTestPageUuid = tvNeuronTestPageUuid;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppActivityNeuronEnvBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppActivityNeuronEnvBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_activity_neuron_env, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppActivityNeuronEnvBinding bind(View rootView) {
        int id = R.id.et_ip;
        EditText etIp = (EditText) ViewBindings.findChildViewById(rootView, id);
        if (etIp != null) {
            id = R.id.switcher;
            Switch switcher = (Switch) ViewBindings.findChildViewById(rootView, id);
            if (switcher != null) {
                id = R.id.tv_neuron_test_page_uuid;
                TextView tvNeuronTestPageUuid = (TextView) ViewBindings.findChildViewById(rootView, id);
                if (tvNeuronTestPageUuid != null) {
                    return new BiliAppActivityNeuronEnvBinding((LinearLayout) rootView, etIp, switcher, tvNeuronTestPageUuid);
                }
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}