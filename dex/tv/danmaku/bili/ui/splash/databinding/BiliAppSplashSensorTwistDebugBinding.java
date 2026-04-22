package tv.danmaku.bili.ui.splash.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import tv.danmaku.bili.ui.splash.R;

public final class BiliAppSplashSensorTwistDebugBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final TextView text1;
    public final TextView text2;
    public final TextView text3;
    public final TextView text4;

    private BiliAppSplashSensorTwistDebugBinding(LinearLayout rootView, TextView text1, TextView text2, TextView text3, TextView text4) {
        this.rootView = rootView;
        this.text1 = text1;
        this.text2 = text2;
        this.text3 = text3;
        this.text4 = text4;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppSplashSensorTwistDebugBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppSplashSensorTwistDebugBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_splash_sensor_twist_debug, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppSplashSensorTwistDebugBinding bind(View rootView) {
        int id = R.id.text1;
        TextView text1 = (TextView) ViewBindings.findChildViewById(rootView, id);
        if (text1 != null) {
            id = R.id.text2;
            TextView text2 = (TextView) ViewBindings.findChildViewById(rootView, id);
            if (text2 != null) {
                id = R.id.text3;
                TextView text3 = (TextView) ViewBindings.findChildViewById(rootView, id);
                if (text3 != null) {
                    id = R.id.text4;
                    TextView text4 = (TextView) ViewBindings.findChildViewById(rootView, id);
                    if (text4 != null) {
                        return new BiliAppSplashSensorTwistDebugBinding((LinearLayout) rootView, text1, text2, text3, text4);
                    }
                }
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}