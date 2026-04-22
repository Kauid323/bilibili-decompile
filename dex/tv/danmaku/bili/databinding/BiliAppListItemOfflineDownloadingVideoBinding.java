package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bilibili.lib.image2.view.legacy.StaticImageView2;
import com.bilibili.magicasakura.widgets.TintCheckBox;
import com.bilibili.magicasakura.widgets.TintTextView;
import tv.danmaku.bili.R;
import tv.danmaku.bili.ui.offline.OfflineProgress;
import tv.danmaku.bili.ui.offline.OfflineTextView;
import tv.danmaku.bili.widget.ForegroundConstraintLayout;

public final class BiliAppListItemOfflineDownloadingVideoBinding implements ViewBinding {
    public final TintCheckBox checkbox;
    public final StaticImageView2 cover;
    public final TintTextView label;
    public final ImageView playInAdvance;
    public final OfflineProgress progress;
    private final ForegroundConstraintLayout rootView;
    public final OfflineTextView subtitle;
    public final TextView tip;
    public final OfflineTextView title;

    private BiliAppListItemOfflineDownloadingVideoBinding(ForegroundConstraintLayout rootView, TintCheckBox checkbox, StaticImageView2 cover, TintTextView label, ImageView playInAdvance, OfflineProgress progress, OfflineTextView subtitle, TextView tip, OfflineTextView title) {
        this.rootView = rootView;
        this.checkbox = checkbox;
        this.cover = cover;
        this.label = label;
        this.playInAdvance = playInAdvance;
        this.progress = progress;
        this.subtitle = subtitle;
        this.tip = tip;
        this.title = title;
    }

    public ForegroundConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppListItemOfflineDownloadingVideoBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppListItemOfflineDownloadingVideoBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_list_item_offline_downloading_video, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppListItemOfflineDownloadingVideoBinding bind(View rootView) {
        StaticImageView2 cover;
        TintTextView label;
        OfflineProgress progress;
        OfflineTextView subtitle;
        OfflineTextView title;
        int id = R.id.checkbox;
        TintCheckBox checkbox = ViewBindings.findChildViewById(rootView, id);
        if (checkbox != null && (cover = ViewBindings.findChildViewById(rootView, (id = R.id.cover))) != null && (label = ViewBindings.findChildViewById(rootView, (id = R.id.label))) != null) {
            id = R.id.play_in_advance;
            ImageView playInAdvance = (ImageView) ViewBindings.findChildViewById(rootView, id);
            if (playInAdvance != null && (progress = ViewBindings.findChildViewById(rootView, (id = R.id.progress))) != null && (subtitle = ViewBindings.findChildViewById(rootView, (id = R.id.subtitle))) != null) {
                id = R.id.tip;
                TextView tip = (TextView) ViewBindings.findChildViewById(rootView, id);
                if (tip != null && (title = ViewBindings.findChildViewById(rootView, (id = R.id.title))) != null) {
                    return new BiliAppListItemOfflineDownloadingVideoBinding((ForegroundConstraintLayout) rootView, checkbox, cover, label, playInAdvance, progress, subtitle, tip, title);
                }
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}