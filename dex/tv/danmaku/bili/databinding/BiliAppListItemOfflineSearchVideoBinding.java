package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bilibili.lib.image2.view.legacy.StaticImageView2;
import com.bilibili.magicasakura.widgets.TintCheckBox;
import com.bilibili.magicasakura.widgets.TintTextView;
import tv.danmaku.bili.R;
import tv.danmaku.bili.ui.offline.OfflineTextView;
import tv.danmaku.bili.widget.ForegroundConstraintLayout;

public final class BiliAppListItemOfflineSearchVideoBinding implements ViewBinding {
    public final TintCheckBox checkbox;
    public final TintTextView count;
    public final StaticImageView2 cover;
    public final TextView danmakuSize;
    public final TintTextView label;
    private final ForegroundConstraintLayout rootView;
    public final OfflineTextView subtitle;
    public final OfflineTextView title;
    public final TintTextView vipHint;
    public final TextView watchProgress;

    private BiliAppListItemOfflineSearchVideoBinding(ForegroundConstraintLayout rootView, TintCheckBox checkbox, TintTextView count, StaticImageView2 cover, TextView danmakuSize, TintTextView label, OfflineTextView subtitle, OfflineTextView title, TintTextView vipHint, TextView watchProgress) {
        this.rootView = rootView;
        this.checkbox = checkbox;
        this.count = count;
        this.cover = cover;
        this.danmakuSize = danmakuSize;
        this.label = label;
        this.subtitle = subtitle;
        this.title = title;
        this.vipHint = vipHint;
        this.watchProgress = watchProgress;
    }

    public ForegroundConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppListItemOfflineSearchVideoBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppListItemOfflineSearchVideoBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_list_item_offline_search_video, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppListItemOfflineSearchVideoBinding bind(View rootView) {
        TintTextView count;
        StaticImageView2 cover;
        TintTextView label;
        OfflineTextView subtitle;
        OfflineTextView title;
        TintTextView vipHint;
        int id = R.id.checkbox;
        TintCheckBox checkbox = ViewBindings.findChildViewById(rootView, id);
        if (checkbox != null && (count = ViewBindings.findChildViewById(rootView, (id = R.id.count))) != null && (cover = ViewBindings.findChildViewById(rootView, (id = R.id.cover))) != null) {
            id = R.id.danmaku_size;
            TextView danmakuSize = (TextView) ViewBindings.findChildViewById(rootView, id);
            if (danmakuSize != null && (label = ViewBindings.findChildViewById(rootView, (id = R.id.label))) != null && (subtitle = ViewBindings.findChildViewById(rootView, (id = R.id.subtitle))) != null && (title = ViewBindings.findChildViewById(rootView, (id = R.id.title))) != null && (vipHint = ViewBindings.findChildViewById(rootView, (id = R.id.vip_hint))) != null) {
                id = R.id.watch_progress;
                TextView watchProgress = (TextView) ViewBindings.findChildViewById(rootView, id);
                if (watchProgress != null) {
                    return new BiliAppListItemOfflineSearchVideoBinding((ForegroundConstraintLayout) rootView, checkbox, count, cover, danmakuSize, label, subtitle, title, vipHint, watchProgress);
                }
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}