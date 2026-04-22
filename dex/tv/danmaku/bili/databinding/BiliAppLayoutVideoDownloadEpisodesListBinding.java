package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import tv.danmaku.bili.R;

public final class BiliAppLayoutVideoDownloadEpisodesListBinding implements ViewBinding {
    public final RecyclerView recycler;
    private final RecyclerView rootView;

    private BiliAppLayoutVideoDownloadEpisodesListBinding(RecyclerView rootView, RecyclerView recycler) {
        this.rootView = rootView;
        this.recycler = recycler;
    }

    public RecyclerView getRoot() {
        return this.rootView;
    }

    public static BiliAppLayoutVideoDownloadEpisodesListBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppLayoutVideoDownloadEpisodesListBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_layout_video_download_episodes_list, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppLayoutVideoDownloadEpisodesListBinding bind(View rootView) {
        if (rootView == null) {
            throw new NullPointerException("rootView");
        }
        RecyclerView recycler = (RecyclerView) rootView;
        return new BiliAppLayoutVideoDownloadEpisodesListBinding((RecyclerView) rootView, recycler);
    }
}