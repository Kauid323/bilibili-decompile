package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager.widget.ViewPager;
import tv.danmaku.bili.R;

public final class BiliAppLayoutViewPagerBinding implements ViewBinding {
    public final ViewPager pager;
    private final ViewPager rootView;

    private BiliAppLayoutViewPagerBinding(ViewPager rootView, ViewPager pager) {
        this.rootView = rootView;
        this.pager = pager;
    }

    public ViewPager getRoot() {
        return this.rootView;
    }

    public static BiliAppLayoutViewPagerBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppLayoutViewPagerBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_layout_view_pager, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppLayoutViewPagerBinding bind(View rootView) {
        if (rootView == null) {
            throw new NullPointerException("rootView");
        }
        ViewPager pager = (ViewPager) rootView;
        return new BiliAppLayoutViewPagerBinding((ViewPager) rootView, pager);
    }
}