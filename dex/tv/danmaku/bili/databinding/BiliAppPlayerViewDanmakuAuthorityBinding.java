package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bilibili.lib.image2.view.legacy.StaticImageView2;
import tv.danmaku.bili.R;

public final class BiliAppPlayerViewDanmakuAuthorityBinding implements ViewBinding {
    public final TextView cancel;
    public final TextView hint;
    public final StaticImageView2 image;
    public final TextView message;
    public final TextView ok;
    private final FrameLayout rootView;
    public final TextView title;

    private BiliAppPlayerViewDanmakuAuthorityBinding(FrameLayout rootView, TextView cancel, TextView hint, StaticImageView2 image, TextView message, TextView ok, TextView title) {
        this.rootView = rootView;
        this.cancel = cancel;
        this.hint = hint;
        this.image = image;
        this.message = message;
        this.ok = ok;
        this.title = title;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppPlayerViewDanmakuAuthorityBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppPlayerViewDanmakuAuthorityBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_player_view_danmaku_authority, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppPlayerViewDanmakuAuthorityBinding bind(View rootView) {
        StaticImageView2 image;
        int id = R.id.cancel;
        TextView cancel = (TextView) ViewBindings.findChildViewById(rootView, id);
        if (cancel != null) {
            id = R.id.hint;
            TextView hint = (TextView) ViewBindings.findChildViewById(rootView, id);
            if (hint != null && (image = ViewBindings.findChildViewById(rootView, (id = R.id.image))) != null) {
                id = R.id.message;
                TextView message = (TextView) ViewBindings.findChildViewById(rootView, id);
                if (message != null) {
                    id = R.id.ok;
                    TextView ok = (TextView) ViewBindings.findChildViewById(rootView, id);
                    if (ok != null) {
                        id = R.id.title;
                        TextView title = (TextView) ViewBindings.findChildViewById(rootView, id);
                        if (title != null) {
                            return new BiliAppPlayerViewDanmakuAuthorityBinding((FrameLayout) rootView, cancel, hint, image, message, ok, title);
                        }
                    }
                }
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}