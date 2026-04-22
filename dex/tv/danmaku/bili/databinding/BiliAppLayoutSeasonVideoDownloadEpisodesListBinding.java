package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager.widget.ViewPager;
import tv.danmaku.bili.R;
import tv.danmaku.bili.widget.PagerSlidingTabStrip;

public final class BiliAppLayoutSeasonVideoDownloadEpisodesListBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final PagerSlidingTabStrip tabs;
    public final ViewPager vpContent;

    private BiliAppLayoutSeasonVideoDownloadEpisodesListBinding(LinearLayout rootView, PagerSlidingTabStrip tabs, ViewPager vpContent) {
        this.rootView = rootView;
        this.tabs = tabs;
        this.vpContent = vpContent;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppLayoutSeasonVideoDownloadEpisodesListBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppLayoutSeasonVideoDownloadEpisodesListBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_layout_season_video_download_episodes_list, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppLayoutSeasonVideoDownloadEpisodesListBinding bind(View rootView) {
        ViewPager vpContent;
        int id = R.id.tabs;
        PagerSlidingTabStrip tabs = ViewBindings.findChildViewById(rootView, id);
        if (tabs != null && (vpContent = ViewBindings.findChildViewById(rootView, (id = R.id.vp_content))) != null) {
            return new BiliAppLayoutSeasonVideoDownloadEpisodesListBinding((LinearLayout) rootView, tabs, vpContent);
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}