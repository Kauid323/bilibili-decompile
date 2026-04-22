package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bilibili.app.comm.list.widget.tag.TagView;
import com.bilibili.lib.image2.view.legacy.ScalableImageView2;
import com.bilibili.magicasakura.widgets.TintImageView;
import com.bilibili.magicasakura.widgets.TintRelativeLayout;
import com.bilibili.magicasakura.widgets.TintTextView;
import tv.danmaku.bili.R;
import tv.danmaku.bili.widget.VectorTextView;

public final class BiliAppListCheeseFavoriteBinding implements ViewBinding {
    public final ScalableImageView2 cover;
    public final ImageView icon;
    public final ImageView imgPlay;
    public final TintImageView more;
    public final VectorTextView playNum;
    private final TintRelativeLayout rootView;
    public final TintTextView status;
    public final TagView tag;
    public final TintTextView title;

    private BiliAppListCheeseFavoriteBinding(TintRelativeLayout rootView, ScalableImageView2 cover, ImageView icon, ImageView imgPlay, TintImageView more, VectorTextView playNum, TintTextView status, TagView tag, TintTextView title) {
        this.rootView = rootView;
        this.cover = cover;
        this.icon = icon;
        this.imgPlay = imgPlay;
        this.more = more;
        this.playNum = playNum;
        this.status = status;
        this.tag = tag;
        this.title = title;
    }

    public TintRelativeLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppListCheeseFavoriteBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppListCheeseFavoriteBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_list_cheese_favorite, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppListCheeseFavoriteBinding bind(View rootView) {
        TintImageView more;
        VectorTextView playNum;
        TintTextView status;
        TagView tag;
        TintTextView title;
        int id = R.id.cover;
        ScalableImageView2 cover = ViewBindings.findChildViewById(rootView, id);
        if (cover != null) {
            id = R.id.icon;
            ImageView icon = (ImageView) ViewBindings.findChildViewById(rootView, id);
            if (icon != null) {
                id = R.id.img_play;
                ImageView imgPlay = (ImageView) ViewBindings.findChildViewById(rootView, id);
                if (imgPlay != null && (more = ViewBindings.findChildViewById(rootView, (id = R.id.more))) != null && (playNum = ViewBindings.findChildViewById(rootView, (id = R.id.play_num))) != null && (status = ViewBindings.findChildViewById(rootView, (id = R.id.status))) != null && (tag = ViewBindings.findChildViewById(rootView, (id = R.id.tag))) != null && (title = ViewBindings.findChildViewById(rootView, (id = R.id.title))) != null) {
                    return new BiliAppListCheeseFavoriteBinding((TintRelativeLayout) rootView, cover, icon, imgPlay, more, playNum, status, tag, title);
                }
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}