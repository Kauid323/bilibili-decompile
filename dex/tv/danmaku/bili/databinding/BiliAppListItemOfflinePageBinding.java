package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bilibili.lib.image2.view.legacy.StaticImageView2;
import com.bilibili.magicasakura.widgets.TintCheckBox;
import tv.danmaku.bili.R;
import tv.danmaku.bili.ui.offline.OfflineTextView;
import tv.danmaku.bili.widget.ForegroundConstraintLayout;
import tv.danmaku.bili.widget.VectorTextView;

public final class BiliAppListItemOfflinePageBinding implements ViewBinding {
    public final TintCheckBox checkbox;
    public final StaticImageView2 cover;
    public final TextView danmakuSize;
    public final VectorTextView detail;
    private final ForegroundConstraintLayout rootView;
    public final OfflineTextView title;
    public final TextView vipHint;
    public final TextView watchProgress;

    private BiliAppListItemOfflinePageBinding(ForegroundConstraintLayout rootView, TintCheckBox checkbox, StaticImageView2 cover, TextView danmakuSize, VectorTextView detail, OfflineTextView title, TextView vipHint, TextView watchProgress) {
        this.rootView = rootView;
        this.checkbox = checkbox;
        this.cover = cover;
        this.danmakuSize = danmakuSize;
        this.detail = detail;
        this.title = title;
        this.vipHint = vipHint;
        this.watchProgress = watchProgress;
    }

    public ForegroundConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppListItemOfflinePageBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppListItemOfflinePageBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_list_item_offline_page, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppListItemOfflinePageBinding bind(View rootView) {
        StaticImageView2 cover;
        VectorTextView detail;
        OfflineTextView title;
        int id = R.id.checkbox;
        TintCheckBox checkbox = ViewBindings.findChildViewById(rootView, id);
        if (checkbox != null && (cover = ViewBindings.findChildViewById(rootView, (id = R.id.cover))) != null) {
            id = R.id.danmaku_size;
            TextView danmakuSize = (TextView) ViewBindings.findChildViewById(rootView, id);
            if (danmakuSize != null && (detail = ViewBindings.findChildViewById(rootView, (id = R.id.detail))) != null && (title = ViewBindings.findChildViewById(rootView, (id = R.id.title))) != null) {
                id = R.id.vip_hint;
                TextView vipHint = (TextView) ViewBindings.findChildViewById(rootView, id);
                if (vipHint != null) {
                    id = R.id.watch_progress;
                    TextView watchProgress = (TextView) ViewBindings.findChildViewById(rootView, id);
                    if (watchProgress != null) {
                        return new BiliAppListItemOfflinePageBinding((ForegroundConstraintLayout) rootView, checkbox, cover, danmakuSize, detail, title, vipHint, watchProgress);
                    }
                }
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}