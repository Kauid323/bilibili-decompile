package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bilibili.magicasakura.widgets.TintTextView;
import tv.danmaku.bili.R;
import tv.danmaku.bili.widget.ForegroundRelativeLayout;

public final class BiliAppListItemAttentionTagBinding implements ViewBinding {
    public final ImageView iconLayout;
    private final ForegroundRelativeLayout rootView;
    public final TintTextView title;

    private BiliAppListItemAttentionTagBinding(ForegroundRelativeLayout rootView, ImageView iconLayout, TintTextView title) {
        this.rootView = rootView;
        this.iconLayout = iconLayout;
        this.title = title;
    }

    public ForegroundRelativeLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppListItemAttentionTagBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppListItemAttentionTagBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_list_item_attention_tag, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppListItemAttentionTagBinding bind(View rootView) {
        TintTextView title;
        int id = R.id.icon_layout;
        ImageView iconLayout = (ImageView) ViewBindings.findChildViewById(rootView, id);
        if (iconLayout != null && (title = ViewBindings.findChildViewById(rootView, (id = R.id.title))) != null) {
            return new BiliAppListItemAttentionTagBinding((ForegroundRelativeLayout) rootView, iconLayout, title);
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}