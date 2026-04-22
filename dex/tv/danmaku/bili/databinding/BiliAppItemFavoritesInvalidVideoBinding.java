package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bilibili.lib.image2.view.BiliImageView;
import com.bilibili.magicasakura.widgets.TintCheckBox;
import com.bilibili.magicasakura.widgets.TintImageView;
import com.bilibili.magicasakura.widgets.TintTextView;
import tv.danmaku.bili.R;
import tv.danmaku.bili.widget.VectorTextView;

public final class BiliAppItemFavoritesInvalidVideoBinding implements ViewBinding {
    public final TintCheckBox checkBox;
    public final TintImageView clearInvalid;
    public final BiliImageView cover;
    public final TintImageView icMove;
    public final VectorTextView invalidTag;
    public final View line;
    public final TintImageView more;
    private final ConstraintLayout rootView;
    public final TintTextView title;
    public final VectorTextView upName;

    private BiliAppItemFavoritesInvalidVideoBinding(ConstraintLayout rootView, TintCheckBox checkBox, TintImageView clearInvalid, BiliImageView cover, TintImageView icMove, VectorTextView invalidTag, View line, TintImageView more, TintTextView title, VectorTextView upName) {
        this.rootView = rootView;
        this.checkBox = checkBox;
        this.clearInvalid = clearInvalid;
        this.cover = cover;
        this.icMove = icMove;
        this.invalidTag = invalidTag;
        this.line = line;
        this.more = more;
        this.title = title;
        this.upName = upName;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppItemFavoritesInvalidVideoBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppItemFavoritesInvalidVideoBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_item_favorites_invalid_video, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppItemFavoritesInvalidVideoBinding bind(View rootView) {
        TintImageView clearInvalid;
        BiliImageView cover;
        TintImageView icMove;
        VectorTextView invalidTag;
        View line;
        TintImageView more;
        TintTextView title;
        VectorTextView upName;
        int id = R.id.check_box;
        TintCheckBox checkBox = ViewBindings.findChildViewById(rootView, id);
        if (checkBox != null && (clearInvalid = ViewBindings.findChildViewById(rootView, (id = R.id.clear_invalid))) != null && (cover = ViewBindings.findChildViewById(rootView, (id = R.id.cover))) != null && (icMove = ViewBindings.findChildViewById(rootView, (id = R.id.ic_move))) != null && (invalidTag = ViewBindings.findChildViewById(rootView, (id = R.id.invalid_tag))) != null && (line = ViewBindings.findChildViewById(rootView, (id = R.id.line))) != null && (more = ViewBindings.findChildViewById(rootView, (id = R.id.more))) != null && (title = ViewBindings.findChildViewById(rootView, (id = R.id.title))) != null && (upName = ViewBindings.findChildViewById(rootView, (id = R.id.up_name))) != null) {
            return new BiliAppItemFavoritesInvalidVideoBinding((ConstraintLayout) rootView, checkBox, clearInvalid, cover, icMove, invalidTag, line, more, title, upName);
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}