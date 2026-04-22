package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import tv.danmaku.bili.R;
import tv.danmaku.bili.widget.LoadingImageView;
import tv.danmaku.bili.widget.RecyclerView;

public final class BiliAppLayoutVideoDownloadSheetUgcFlexibleViewBinding implements ViewBinding {
    public final TextView audioTips;
    public final ImageButton close;
    public final View dividerTop;
    public final RelativeLayout headerLayout;
    public final LoadingImageView loading;
    public final RelativeLayout qualityLayout;
    public final RecyclerView qualityRecycler;
    public final TextView qualityTips;
    private final View rootView;
    public final TextView title;
    public final ViewStub vsEpisodes;

    private BiliAppLayoutVideoDownloadSheetUgcFlexibleViewBinding(View rootView, TextView audioTips, ImageButton close, View dividerTop, RelativeLayout headerLayout, LoadingImageView loading, RelativeLayout qualityLayout, RecyclerView qualityRecycler, TextView qualityTips, TextView title, ViewStub vsEpisodes) {
        this.rootView = rootView;
        this.audioTips = audioTips;
        this.close = close;
        this.dividerTop = dividerTop;
        this.headerLayout = headerLayout;
        this.loading = loading;
        this.qualityLayout = qualityLayout;
        this.qualityRecycler = qualityRecycler;
        this.qualityTips = qualityTips;
        this.title = title;
        this.vsEpisodes = vsEpisodes;
    }

    public View getRoot() {
        return this.rootView;
    }

    public static BiliAppLayoutVideoDownloadSheetUgcFlexibleViewBinding inflate(LayoutInflater inflater, ViewGroup parent) {
        if (parent == null) {
            throw new NullPointerException("parent");
        }
        inflater.inflate(R.layout.bili_app_layout_video_download_sheet_ugc_flexible_view, parent);
        return bind(parent);
    }

    public static BiliAppLayoutVideoDownloadSheetUgcFlexibleViewBinding bind(View rootView) {
        View dividerTop;
        LoadingImageView loading;
        RecyclerView qualityRecycler;
        int id = R.id.audio_tips;
        TextView audioTips = (TextView) ViewBindings.findChildViewById(rootView, id);
        if (audioTips != null) {
            id = R.id.close;
            ImageButton close = (ImageButton) ViewBindings.findChildViewById(rootView, id);
            if (close != null && (dividerTop = ViewBindings.findChildViewById(rootView, (id = R.id.divider_top))) != null) {
                id = R.id.header_layout;
                RelativeLayout headerLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, id);
                if (headerLayout != null && (loading = ViewBindings.findChildViewById(rootView, (id = R.id.loading))) != null) {
                    id = R.id.quality_layout;
                    RelativeLayout qualityLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, id);
                    if (qualityLayout != null && (qualityRecycler = ViewBindings.findChildViewById(rootView, (id = R.id.quality_recycler))) != null) {
                        id = R.id.quality_tips;
                        TextView qualityTips = (TextView) ViewBindings.findChildViewById(rootView, id);
                        if (qualityTips != null) {
                            id = R.id.title;
                            TextView title = (TextView) ViewBindings.findChildViewById(rootView, id);
                            if (title != null) {
                                int id2 = R.id.vs_episodes;
                                ViewStub vsEpisodes = (ViewStub) ViewBindings.findChildViewById(rootView, id2);
                                if (vsEpisodes == null) {
                                    id = id2;
                                } else {
                                    return new BiliAppLayoutVideoDownloadSheetUgcFlexibleViewBinding(rootView, audioTips, close, dividerTop, headerLayout, loading, qualityLayout, qualityRecycler, qualityTips, title, vsEpisodes);
                                }
                            }
                        }
                    }
                }
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}