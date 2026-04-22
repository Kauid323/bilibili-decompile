package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bilibili.app.comm.list.widget.tag.TagsView;
import tv.danmaku.bili.R;
import tv.danmaku.bili.ui.offline.OfflineTextView;

public final class BiliAppFragmentVideoUgcPageListItemBinding implements ViewBinding {
    public final TagsView coverBadges;
    private final FrameLayout rootView;
    public final ImageView statusBadge;
    public final OfflineTextView title;

    private BiliAppFragmentVideoUgcPageListItemBinding(FrameLayout rootView, TagsView coverBadges, ImageView statusBadge, OfflineTextView title) {
        this.rootView = rootView;
        this.coverBadges = coverBadges;
        this.statusBadge = statusBadge;
        this.title = title;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppFragmentVideoUgcPageListItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppFragmentVideoUgcPageListItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_fragment_video_ugc_page_list_item, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppFragmentVideoUgcPageListItemBinding bind(View rootView) {
        OfflineTextView title;
        int id = R.id.cover_badges;
        TagsView coverBadges = ViewBindings.findChildViewById(rootView, id);
        if (coverBadges != null) {
            id = R.id.status_badge;
            ImageView statusBadge = (ImageView) ViewBindings.findChildViewById(rootView, id);
            if (statusBadge != null && (title = ViewBindings.findChildViewById(rootView, (id = R.id.title))) != null) {
                return new BiliAppFragmentVideoUgcPageListItemBinding((FrameLayout) rootView, coverBadges, statusBadge, title);
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}