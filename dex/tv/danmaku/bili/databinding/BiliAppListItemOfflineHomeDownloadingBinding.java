package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bilibili.lib.image2.view.legacy.StaticImageView2;
import com.bilibili.magicasakura.widgets.TintFrameLayout;
import com.bilibili.magicasakura.widgets.TintTextView;
import tv.danmaku.bili.R;
import tv.danmaku.bili.ui.offline.OfflineProgress;
import tv.danmaku.bili.ui.offline.OfflineTextView;
import tv.danmaku.bili.widget.ForegroundConstraintLayout;

public final class BiliAppListItemOfflineHomeDownloadingBinding implements ViewBinding {
    public final TintTextView count;
    public final StaticImageView2 cover;
    public final ImageView coverShadow;
    public final TintFrameLayout overlay;
    public final OfflineProgress progress;
    private final ForegroundConstraintLayout rootView;
    public final TintTextView sectionTitle;
    public final View space;
    public final OfflineTextView subtitle;
    public final TintTextView tip;
    public final OfflineTextView title;
    public final TintTextView totalSize;

    private BiliAppListItemOfflineHomeDownloadingBinding(ForegroundConstraintLayout rootView, TintTextView count, StaticImageView2 cover, ImageView coverShadow, TintFrameLayout overlay, OfflineProgress progress, TintTextView sectionTitle, View space, OfflineTextView subtitle, TintTextView tip, OfflineTextView title, TintTextView totalSize) {
        this.rootView = rootView;
        this.count = count;
        this.cover = cover;
        this.coverShadow = coverShadow;
        this.overlay = overlay;
        this.progress = progress;
        this.sectionTitle = sectionTitle;
        this.space = space;
        this.subtitle = subtitle;
        this.tip = tip;
        this.title = title;
        this.totalSize = totalSize;
    }

    public ForegroundConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppListItemOfflineHomeDownloadingBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppListItemOfflineHomeDownloadingBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_list_item_offline_home_downloading, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppListItemOfflineHomeDownloadingBinding bind(View rootView) {
        StaticImageView2 cover;
        TintFrameLayout overlay;
        OfflineProgress progress;
        TintTextView sectionTitle;
        View space;
        OfflineTextView subtitle;
        TintTextView tip;
        OfflineTextView title;
        TintTextView totalSize;
        int id = R.id.count;
        TintTextView count = ViewBindings.findChildViewById(rootView, id);
        if (count != null && (cover = ViewBindings.findChildViewById(rootView, (id = R.id.cover))) != null) {
            id = R.id.cover_shadow;
            ImageView coverShadow = (ImageView) ViewBindings.findChildViewById(rootView, id);
            if (coverShadow != null && (overlay = ViewBindings.findChildViewById(rootView, (id = R.id.overlay))) != null && (progress = ViewBindings.findChildViewById(rootView, (id = R.id.progress))) != null && (sectionTitle = ViewBindings.findChildViewById(rootView, (id = R.id.section_title))) != null && (space = ViewBindings.findChildViewById(rootView, (id = R.id.space))) != null && (subtitle = ViewBindings.findChildViewById(rootView, (id = R.id.subtitle))) != null && (tip = ViewBindings.findChildViewById(rootView, (id = R.id.tip))) != null && (title = ViewBindings.findChildViewById(rootView, (id = R.id.title))) != null && (totalSize = ViewBindings.findChildViewById(rootView, (id = R.id.total_size))) != null) {
                return new BiliAppListItemOfflineHomeDownloadingBinding((ForegroundConstraintLayout) rootView, count, cover, coverShadow, overlay, progress, sectionTitle, space, subtitle, tip, title, totalSize);
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}