package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bilibili.lib.image2.view.legacy.StaticImageView2;
import com.bilibili.magicasakura.widgets.TintCheckBox;
import com.google.android.material.internal.ForegroundLinearLayout;
import tv.danmaku.bili.R;
import tv.danmaku.bili.ui.offline.OfflineProgress;

public final class BiliAppListItemOfflineDownloadingAudioBinding implements ViewBinding {
    public final TintCheckBox checkbox;
    public final StaticImageView2 cover;
    public final ForegroundLinearLayout itemView;
    public final OfflineProgress progress;
    private final ForegroundLinearLayout rootView;
    public final TextView tip;
    public final TextView title;
    public final TextView totalSize;

    private BiliAppListItemOfflineDownloadingAudioBinding(ForegroundLinearLayout rootView, TintCheckBox checkbox, StaticImageView2 cover, ForegroundLinearLayout itemView, OfflineProgress progress, TextView tip, TextView title, TextView totalSize) {
        this.rootView = rootView;
        this.checkbox = checkbox;
        this.cover = cover;
        this.itemView = itemView;
        this.progress = progress;
        this.tip = tip;
        this.title = title;
        this.totalSize = totalSize;
    }

    public ForegroundLinearLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppListItemOfflineDownloadingAudioBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppListItemOfflineDownloadingAudioBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_list_item_offline_downloading_audio, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppListItemOfflineDownloadingAudioBinding bind(View rootView) {
        StaticImageView2 cover;
        int id = R.id.checkbox;
        TintCheckBox checkbox = ViewBindings.findChildViewById(rootView, id);
        if (checkbox != null && (cover = ViewBindings.findChildViewById(rootView, (id = R.id.cover))) != null) {
            ForegroundLinearLayout itemView = (ForegroundLinearLayout) rootView;
            id = R.id.progress;
            OfflineProgress progress = ViewBindings.findChildViewById(rootView, id);
            if (progress != null) {
                id = R.id.tip;
                TextView tip = (TextView) ViewBindings.findChildViewById(rootView, id);
                if (tip != null) {
                    id = R.id.title;
                    TextView title = (TextView) ViewBindings.findChildViewById(rootView, id);
                    if (title != null) {
                        id = R.id.total_size;
                        TextView totalSize = (TextView) ViewBindings.findChildViewById(rootView, id);
                        if (totalSize != null) {
                            return new BiliAppListItemOfflineDownloadingAudioBinding((ForegroundLinearLayout) rootView, checkbox, cover, itemView, progress, tip, title, totalSize);
                        }
                    }
                }
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}