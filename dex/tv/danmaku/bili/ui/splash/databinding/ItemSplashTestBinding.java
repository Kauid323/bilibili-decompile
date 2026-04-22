package tv.danmaku.bili.ui.splash.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import tv.danmaku.bili.ui.splash.R;

public final class ItemSplashTestBinding implements ViewBinding {
    private final FrameLayout rootView;
    public final TextView titleText;

    private ItemSplashTestBinding(FrameLayout rootView, TextView titleText) {
        this.rootView = rootView;
        this.titleText = titleText;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static ItemSplashTestBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ItemSplashTestBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.item_splash_test, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static ItemSplashTestBinding bind(View rootView) {
        int id = R.id.title_text;
        TextView titleText = (TextView) ViewBindings.findChildViewById(rootView, id);
        if (titleText != null) {
            return new ItemSplashTestBinding((FrameLayout) rootView, titleText);
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}