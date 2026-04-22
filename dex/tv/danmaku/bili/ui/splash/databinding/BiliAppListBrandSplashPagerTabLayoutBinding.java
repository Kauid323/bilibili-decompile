package tv.danmaku.bili.ui.splash.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import tv.danmaku.bili.ui.splash.R;

public final class BiliAppListBrandSplashPagerTabLayoutBinding implements ViewBinding {
    private final FrameLayout rootView;
    public final TextView title;
    public final View underLine;

    private BiliAppListBrandSplashPagerTabLayoutBinding(FrameLayout rootView, TextView title, View underLine) {
        this.rootView = rootView;
        this.title = title;
        this.underLine = underLine;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppListBrandSplashPagerTabLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppListBrandSplashPagerTabLayoutBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_list_brand_splash_pager_tab_layout, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppListBrandSplashPagerTabLayoutBinding bind(View rootView) {
        View underLine;
        int id = R.id.title;
        TextView title = (TextView) ViewBindings.findChildViewById(rootView, id);
        if (title != null && (underLine = ViewBindings.findChildViewById(rootView, (id = R.id.under_line))) != null) {
            return new BiliAppListBrandSplashPagerTabLayoutBinding((FrameLayout) rootView, title, underLine);
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}