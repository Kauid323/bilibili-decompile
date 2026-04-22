package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bilibili.lib.image2.view.legacy.StaticImageView2;
import com.bilibili.magicasakura.widgets.TintCheckBox;
import tv.danmaku.bili.R;
import tv.danmaku.bili.widget.ForegroundConstraintLayout;

public final class BiliAppListItemOfflineSearchAudioBinding implements ViewBinding {
    public final TextView author;
    public final TintCheckBox checkbox;
    public final StaticImageView2 cover;
    public final FrameLayout coverContainer;
    private final ForegroundConstraintLayout rootView;
    public final TextView size;
    public final TextView title;

    private BiliAppListItemOfflineSearchAudioBinding(ForegroundConstraintLayout rootView, TextView author, TintCheckBox checkbox, StaticImageView2 cover, FrameLayout coverContainer, TextView size, TextView title) {
        this.rootView = rootView;
        this.author = author;
        this.checkbox = checkbox;
        this.cover = cover;
        this.coverContainer = coverContainer;
        this.size = size;
        this.title = title;
    }

    public ForegroundConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppListItemOfflineSearchAudioBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppListItemOfflineSearchAudioBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_list_item_offline_search_audio, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppListItemOfflineSearchAudioBinding bind(View rootView) {
        TintCheckBox checkbox;
        StaticImageView2 cover;
        int id = R.id.author;
        TextView author = (TextView) ViewBindings.findChildViewById(rootView, id);
        if (author != null && (checkbox = ViewBindings.findChildViewById(rootView, (id = R.id.checkbox))) != null && (cover = ViewBindings.findChildViewById(rootView, (id = R.id.cover))) != null) {
            id = R.id.cover_container;
            FrameLayout coverContainer = (FrameLayout) ViewBindings.findChildViewById(rootView, id);
            if (coverContainer != null) {
                id = R.id.size;
                TextView size = (TextView) ViewBindings.findChildViewById(rootView, id);
                if (size != null) {
                    id = R.id.title;
                    TextView title = (TextView) ViewBindings.findChildViewById(rootView, id);
                    if (title != null) {
                        return new BiliAppListItemOfflineSearchAudioBinding((ForegroundConstraintLayout) rootView, author, checkbox, cover, coverContainer, size, title);
                    }
                }
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}