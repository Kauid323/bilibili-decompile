package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bilibili.magicasakura.widgets.TintSwitchCompat;
import tv.danmaku.bili.R;

public final class BiliAppFragmentDebugHttpCheckBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final TintSwitchCompat switcher;

    private BiliAppFragmentDebugHttpCheckBinding(LinearLayout rootView, TintSwitchCompat switcher) {
        this.rootView = rootView;
        this.switcher = switcher;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppFragmentDebugHttpCheckBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppFragmentDebugHttpCheckBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_fragment_debug_http_check, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppFragmentDebugHttpCheckBinding bind(View rootView) {
        int id = R.id.switcher;
        TintSwitchCompat switcher = ViewBindings.findChildViewById(rootView, id);
        if (switcher != null) {
            return new BiliAppFragmentDebugHttpCheckBinding((LinearLayout) rootView, switcher);
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}