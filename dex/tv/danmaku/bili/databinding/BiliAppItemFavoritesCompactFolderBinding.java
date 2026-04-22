package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bilibili.lib.image2.view.BiliImageView;
import com.bilibili.magicasakura.widgets.TintConstraintLayout;
import com.bilibili.magicasakura.widgets.TintImageView;
import com.bilibili.magicasakura.widgets.TintTextView;
import tv.danmaku.bili.R;

public final class BiliAppItemFavoritesCompactFolderBinding implements ViewBinding {
    public final BiliImageView cover;
    public final BiliImageView cover11;
    public final TintImageView lock;
    public final TintImageView play;
    public final FrameLayout playContainer;
    public final TintTextView playText;
    private final TintConstraintLayout rootView;
    public final TintTextView subtitle;
    public final TintTextView title;

    private BiliAppItemFavoritesCompactFolderBinding(TintConstraintLayout rootView, BiliImageView cover, BiliImageView cover11, TintImageView lock, TintImageView play, FrameLayout playContainer, TintTextView playText, TintTextView subtitle, TintTextView title) {
        this.rootView = rootView;
        this.cover = cover;
        this.cover11 = cover11;
        this.lock = lock;
        this.play = play;
        this.playContainer = playContainer;
        this.playText = playText;
        this.subtitle = subtitle;
        this.title = title;
    }

    public TintConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppItemFavoritesCompactFolderBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppItemFavoritesCompactFolderBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_item_favorites_compact_folder, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppItemFavoritesCompactFolderBinding bind(View rootView) {
        BiliImageView cover11;
        TintImageView lock;
        TintImageView play;
        TintTextView playText;
        TintTextView subtitle;
        TintTextView title;
        int id = R.id.cover;
        BiliImageView cover = ViewBindings.findChildViewById(rootView, id);
        if (cover != null && (cover11 = ViewBindings.findChildViewById(rootView, (id = R.id.cover_11))) != null && (lock = ViewBindings.findChildViewById(rootView, (id = R.id.lock))) != null && (play = ViewBindings.findChildViewById(rootView, (id = R.id.play))) != null) {
            id = R.id.play_container;
            FrameLayout playContainer = (FrameLayout) ViewBindings.findChildViewById(rootView, id);
            if (playContainer != null && (playText = ViewBindings.findChildViewById(rootView, (id = R.id.play_text))) != null && (subtitle = ViewBindings.findChildViewById(rootView, (id = R.id.subtitle))) != null && (title = ViewBindings.findChildViewById(rootView, (id = R.id.title))) != null) {
                return new BiliAppItemFavoritesCompactFolderBinding((TintConstraintLayout) rootView, cover, cover11, lock, play, playContainer, playText, subtitle, title);
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}