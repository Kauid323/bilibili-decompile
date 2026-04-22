package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bilibili.lib.homepage.widget.badge.NumberBadgeView;
import com.bilibili.lib.image2.view.BiliImageView;
import com.bilibili.magicasakura.widgets.TintTextView;
import tv.danmaku.bili.R;

public final class BiliLayoutMainUserCenterMngItemBinding implements ViewBinding {
    public final NumberBadgeView badge;
    public final BiliImageView icon;
    private final ConstraintLayout rootView;
    public final TintTextView title;

    private BiliLayoutMainUserCenterMngItemBinding(ConstraintLayout rootView, NumberBadgeView badge, BiliImageView icon, TintTextView title) {
        this.rootView = rootView;
        this.badge = badge;
        this.icon = icon;
        this.title = title;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BiliLayoutMainUserCenterMngItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliLayoutMainUserCenterMngItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_layout_main_user_center_mng_item, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliLayoutMainUserCenterMngItemBinding bind(View rootView) {
        BiliImageView icon;
        TintTextView title;
        int id = R.id.badge;
        NumberBadgeView badge = ViewBindings.findChildViewById(rootView, id);
        if (badge != null && (icon = ViewBindings.findChildViewById(rootView, (id = R.id.icon))) != null && (title = ViewBindings.findChildViewById(rootView, (id = R.id.title))) != null) {
            return new BiliLayoutMainUserCenterMngItemBinding((ConstraintLayout) rootView, badge, icon, title);
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}