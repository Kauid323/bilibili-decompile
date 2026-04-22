package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import tv.danmaku.bili.R;
import tv.danmaku.bili.widget.RecyclerView;

public final class BiliAppFragmentNeuronRedirectBinding implements ViewBinding {
    private final ConstraintLayout rootView;
    public final RecyclerView rvProxy;
    public final TextView tvUuid;

    private BiliAppFragmentNeuronRedirectBinding(ConstraintLayout rootView, RecyclerView rvProxy, TextView tvUuid) {
        this.rootView = rootView;
        this.rvProxy = rvProxy;
        this.tvUuid = tvUuid;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppFragmentNeuronRedirectBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppFragmentNeuronRedirectBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_fragment_neuron_redirect, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppFragmentNeuronRedirectBinding bind(View rootView) {
        int id = R.id.rv_proxy;
        RecyclerView rvProxy = ViewBindings.findChildViewById(rootView, id);
        if (rvProxy != null) {
            id = R.id.tv_uuid;
            TextView tvUuid = (TextView) ViewBindings.findChildViewById(rootView, id);
            if (tvUuid != null) {
                return new BiliAppFragmentNeuronRedirectBinding((ConstraintLayout) rootView, rvProxy, tvUuid);
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}