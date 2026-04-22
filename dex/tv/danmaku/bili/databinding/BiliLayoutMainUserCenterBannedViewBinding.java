package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bilibili.magicasakura.widgets.TintConstraintLayout;
import com.bilibili.magicasakura.widgets.TintTextView;
import tv.danmaku.bili.R;

public final class BiliLayoutMainUserCenterBannedViewBinding implements ViewBinding {
    public final ImageView icArrow;
    public final ImageView icBan;
    public final TintConstraintLayout mineBannedEntry;
    private final TintConstraintLayout rootView;
    public final TintTextView tvBannedEntry;

    private BiliLayoutMainUserCenterBannedViewBinding(TintConstraintLayout rootView, ImageView icArrow, ImageView icBan, TintConstraintLayout mineBannedEntry, TintTextView tvBannedEntry) {
        this.rootView = rootView;
        this.icArrow = icArrow;
        this.icBan = icBan;
        this.mineBannedEntry = mineBannedEntry;
        this.tvBannedEntry = tvBannedEntry;
    }

    public TintConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BiliLayoutMainUserCenterBannedViewBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliLayoutMainUserCenterBannedViewBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_layout_main_user_center_banned_view, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliLayoutMainUserCenterBannedViewBinding bind(View rootView) {
        int id = R.id.ic_arrow;
        ImageView icArrow = (ImageView) ViewBindings.findChildViewById(rootView, id);
        if (icArrow != null) {
            id = R.id.ic_ban;
            ImageView icBan = (ImageView) ViewBindings.findChildViewById(rootView, id);
            if (icBan != null) {
                TintConstraintLayout mineBannedEntry = (TintConstraintLayout) rootView;
                id = R.id.tv_banned_entry;
                TintTextView tvBannedEntry = ViewBindings.findChildViewById(rootView, id);
                if (tvBannedEntry != null) {
                    return new BiliLayoutMainUserCenterBannedViewBinding((TintConstraintLayout) rootView, icArrow, icBan, mineBannedEntry, tvBannedEntry);
                }
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}