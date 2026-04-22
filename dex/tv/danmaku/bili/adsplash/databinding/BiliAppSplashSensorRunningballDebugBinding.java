package tv.danmaku.bili.adsplash.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import tv.danmaku.bili.adsplash.R;

public final class BiliAppSplashSensorRunningballDebugBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final TextView text1;

    private BiliAppSplashSensorRunningballDebugBinding(LinearLayout rootView, TextView text1) {
        this.rootView = rootView;
        this.text1 = text1;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppSplashSensorRunningballDebugBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppSplashSensorRunningballDebugBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_splash_sensor_runningball_debug, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppSplashSensorRunningballDebugBinding bind(View rootView) {
        int id = R.id.text1;
        TextView text1 = (TextView) ViewBindings.findChildViewById(rootView, id);
        if (text1 != null) {
            return new BiliAppSplashSensorRunningballDebugBinding((LinearLayout) rootView, text1);
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}