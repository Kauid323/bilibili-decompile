package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bilibili.lib.image2.view.legacy.StaticImageView2;
import com.bilibili.magicasakura.widgets.TintCheckBox;
import com.bilibili.magicasakura.widgets.TintProgressBar;
import com.bilibili.magicasakura.widgets.TintTextView;
import tv.danmaku.bili.R;
import tv.danmaku.bili.ui.offline.OfflineTextView;

public final class BiliAppListItemOfflineHomeDownloadedBinding implements ViewBinding {
    public final TintCheckBox checkbox;
    public final StaticImageView2 cover;
    public final TintTextView coverDesc;
    public final TintTextView label;
    public final TintProgressBar progress;
    private final ConstraintLayout rootView;
    public final OfflineTextView title;
    public final TintTextView upName;
    public final TintTextView videoSize;

    private BiliAppListItemOfflineHomeDownloadedBinding(ConstraintLayout rootView, TintCheckBox checkbox, StaticImageView2 cover, TintTextView coverDesc, TintTextView label, TintProgressBar progress, OfflineTextView title, TintTextView upName, TintTextView videoSize) {
        this.rootView = rootView;
        this.checkbox = checkbox;
        this.cover = cover;
        this.coverDesc = coverDesc;
        this.label = label;
        this.progress = progress;
        this.title = title;
        this.upName = upName;
        this.videoSize = videoSize;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppListItemOfflineHomeDownloadedBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppListItemOfflineHomeDownloadedBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_list_item_offline_home_downloaded, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppListItemOfflineHomeDownloadedBinding bind(View rootView) {
        StaticImageView2 cover;
        TintTextView coverDesc;
        TintTextView label;
        TintProgressBar progress;
        OfflineTextView title;
        TintTextView upName;
        TintTextView videoSize;
        int id = R.id.checkbox;
        TintCheckBox checkbox = ViewBindings.findChildViewById(rootView, id);
        if (checkbox != null && (cover = ViewBindings.findChildViewById(rootView, (id = R.id.cover))) != null && (coverDesc = ViewBindings.findChildViewById(rootView, (id = R.id.cover_desc))) != null && (label = ViewBindings.findChildViewById(rootView, (id = R.id.label))) != null && (progress = ViewBindings.findChildViewById(rootView, (id = R.id.progress))) != null && (title = ViewBindings.findChildViewById(rootView, (id = R.id.title))) != null && (upName = ViewBindings.findChildViewById(rootView, (id = R.id.up_name))) != null && (videoSize = ViewBindings.findChildViewById(rootView, (id = R.id.video_size))) != null) {
            return new BiliAppListItemOfflineHomeDownloadedBinding((ConstraintLayout) rootView, checkbox, cover, coverDesc, label, progress, title, upName, videoSize);
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}